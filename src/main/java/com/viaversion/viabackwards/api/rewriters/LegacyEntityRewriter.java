/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.api.rewriters;

import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.entities.storage.EntityObjectData;
import com.viaversion.viabackwards.api.entities.storage.EntityReplacement;
import com.viaversion.viabackwards.api.entities.storage.WrappedEntityData;
import com.viaversion.viabackwards.api.rewriters.EntityRewriterBase;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.ObjectType;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityDataType;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_9;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.Nullable;

public abstract class LegacyEntityRewriter<C extends ClientboundPacketType, T extends BackwardsProtocol<C, ?, ?, ?>>
extends EntityRewriterBase<C, T> {
    private final Map<ObjectType, EntityReplacement> objectTypes = new HashMap<ObjectType, EntityReplacement>();

    protected LegacyEntityRewriter(T t) {
        this(t, EntityDataTypes1_9.STRING, EntityDataTypes1_9.BOOLEAN);
    }

    protected LegacyEntityRewriter(T t, EntityDataType entityDataType, EntityDataType entityDataType2) {
        super(t, entityDataType, 2, entityDataType2, 3);
    }

    protected EntityObjectData mapObjectType(ObjectType objectType, ObjectType objectType2, int n) {
        EntityObjectData entityObjectData = new EntityObjectData((BackwardsProtocol)this.protocol, objectType.getType().name().toLowerCase(Locale.ROOT), objectType.getId(), objectType2.getId(), n);
        this.objectTypes.put(objectType, entityObjectData);
        return entityObjectData;
    }

    protected @Nullable EntityReplacement getObjectData(ObjectType objectType) {
        return this.objectTypes.get(objectType);
    }

    protected void registerRespawn(C c) {
        ((BackwardsProtocol)this.protocol).registerClientbound(c, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    Object t = packetWrapper.user().getClientWorld(((BackwardsProtocol)LegacyEntityRewriter.this.protocol).getClass());
                    if (((ClientWorld)t).setEnvironment(packetWrapper.get(Types.INT, 0))) {
                        LegacyEntityRewriter.this.tracker(packetWrapper.user()).clearEntities();
                    }
                });
            }
        });
    }

    protected void registerJoinGame(C c, final EntityType entityType) {
        ((BackwardsProtocol)this.protocol).registerClientbound(c, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    Object t = packetWrapper.user().getClientWorld(((BackwardsProtocol)LegacyEntityRewriter.this.protocol).getClass());
                    ((ClientWorld)t).setEnvironment(packetWrapper.get(Types.INT, 1));
                    int n = packetWrapper.get(Types.INT, 0);
                    Object e = LegacyEntityRewriter.this.tracker(packetWrapper.user());
                    e.addEntity(n, entityType);
                    e.setClientEntityId(n);
                });
            }
        });
    }

    protected PacketHandler getMobSpawnRewriter(Type<List<EntityData>> type, IdSetter idSetter) {
        return packetWrapper -> {
            int n = packetWrapper.get(Types.VAR_INT, 0);
            EntityType entityType = this.tracker(packetWrapper.user()).entityType(n);
            if (entityType == null) {
                return;
            }
            List list = (List)packetWrapper.get(type, 0);
            this.handleEntityData(n, list, packetWrapper.user());
            EntityReplacement entityReplacement = this.entityDataForType(entityType);
            if (entityReplacement != null) {
                idSetter.setId(packetWrapper, entityReplacement.replacementId());
                if (entityReplacement.hasBaseData()) {
                    entityReplacement.defaultData().createData(new WrappedEntityData(list));
                }
            }
        };
    }

    public PacketHandler getMobSpawnRewriter(Type<List<EntityData>> type) {
        return this.getMobSpawnRewriter(type, (packetWrapper, n) -> packetWrapper.set(Types.UNSIGNED_BYTE, 0, (short)n));
    }

    public PacketHandler getMobSpawnRewriter1_11(Type<List<EntityData>> type) {
        return this.getMobSpawnRewriter(type, (packetWrapper, n) -> packetWrapper.set(Types.VAR_INT, 1, n));
    }

    protected PacketHandler getObjectTrackerHandler() {
        return packetWrapper -> {
            int n;
            byte by = packetWrapper.get(Types.BYTE, 0);
            EntityType entityType = this.objectTypeFromId(by, n = packetWrapper.get(Types.INT, 0).intValue());
            if (entityType == null) {
                return;
            }
            this.tracker(packetWrapper.user()).addEntity(packetWrapper.get(Types.VAR_INT, 0), entityType);
        };
    }

    protected PacketHandler getTrackerAndDataHandler(Type<List<EntityData>> type, EntityType entityType) {
        return packetWrapper -> {
            this.tracker(packetWrapper.user()).addEntity(packetWrapper.get(Types.VAR_INT, 0), entityType);
            List list = (List)packetWrapper.get(type, 0);
            this.handleEntityData(packetWrapper.get(Types.VAR_INT, 0), list, packetWrapper.user());
        };
    }

    protected PacketHandler getObjectRewriter(ObjectTypeGetter objectTypeGetter) {
        return packetWrapper -> {
            int n;
            byte by = packetWrapper.get(Types.BYTE, 0);
            ObjectType objectType = objectTypeGetter.get(by, n = packetWrapper.get(Types.INT, 0).intValue());
            if (objectType == null) {
                return;
            }
            EntityReplacement entityReplacement = this.getObjectData(objectType);
            if (entityReplacement != null) {
                packetWrapper.set(Types.BYTE, 0, (byte)entityReplacement.replacementId());
                if (entityReplacement.objectData() != -1) {
                    packetWrapper.set(Types.INT, 0, entityReplacement.objectData());
                }
            }
        };
    }

    @FunctionalInterface
    protected static interface IdSetter {
        public void setId(PacketWrapper var1, int var2);
    }

    @FunctionalInterface
    protected static interface ObjectTypeGetter {
        public ObjectType get(int var1, int var2);
    }
}


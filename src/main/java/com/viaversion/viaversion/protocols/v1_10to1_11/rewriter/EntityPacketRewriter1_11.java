/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_10to1_11.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_10;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_11;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_9;
import com.viaversion.viaversion.api.minecraft.item.DataItem;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_10to1_11.Protocol1_10To1_11;
import com.viaversion.viaversion.protocols.v1_10to1_11.data.BlockEntityMappings1_11;
import com.viaversion.viaversion.protocols.v1_10to1_11.data.EntityMappings1_11;
import com.viaversion.viaversion.protocols.v1_10to1_11.storage.EntityTracker1_11;
import com.viaversion.viaversion.protocols.v1_9_1to1_9_3.packet.ClientboundPackets1_9_3;
import com.viaversion.viaversion.rewriter.EntityRewriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

public class EntityPacketRewriter1_11
extends EntityRewriter<ClientboundPackets1_9_3, Protocol1_10To1_11> {
    public EntityPacketRewriter1_11(Protocol1_10To1_11 protocol1_10To1_11) {
        super(protocol1_10To1_11);
    }

    @Override
    protected void registerPackets() {
        ((Protocol1_10To1_11)this.protocol).registerClientbound(ClientboundPackets1_9_3.LOGIN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    Object t = packetWrapper.user().getClientWorld(Protocol1_10To1_11.class);
                    int n = packetWrapper.get(Types.INT, 1);
                    ((ClientWorld)t).setEnvironment(n);
                });
            }
        });
        ((Protocol1_10To1_11)this.protocol).registerClientbound(ClientboundPackets1_9_3.RESPAWN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    int n;
                    Object t = packetWrapper.user().getClientWorld(Protocol1_10To1_11.class);
                    if (((ClientWorld)t).setEnvironment(n = packetWrapper.get(Types.INT, 0).intValue())) {
                        EntityPacketRewriter1_11.this.tracker(packetWrapper.user()).clearEntities();
                    }
                });
            }
        });
        ((Protocol1_10To1_11)this.protocol).registerClientbound(ClientboundPackets1_9_3.ADD_ENTITY, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.UUID);
                this.map(Types.BYTE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.INT);
                this.handler(EntityPacketRewriter1_11.this.objectTrackerHandler());
                this.handler(packetWrapper -> {
                    byte by = packetWrapper.get(Types.BYTE, 0);
                    if (by == EntityTypes1_10.ObjectType.FISHIHNG_HOOK.getId()) {
                        EntityPacketRewriter1_11.this.tryFixFishingHookVelocity(packetWrapper);
                    } else if (by == EntityTypes1_10.ObjectType.ITEM.getId()) {
                        packetWrapper.send(Protocol1_10To1_11.class);
                        packetWrapper.cancel();
                        int n = packetWrapper.get(Types.VAR_INT, 0);
                        ArrayList<EntityData> arrayList = new ArrayList<EntityData>();
                        arrayList.add(new EntityData(6, EntityDataTypes1_9.ITEM, new DataItem(1, 1, null)));
                        PacketWrapper packetWrapper2 = PacketWrapper.create(ClientboundPackets1_9_3.SET_ENTITY_DATA, packetWrapper.user());
                        packetWrapper2.write(Types.VAR_INT, n);
                        packetWrapper2.write(Types.ENTITY_DATA_LIST1_9, arrayList);
                        packetWrapper2.send(Protocol1_10To1_11.class);
                    }
                });
            }
        });
        ((Protocol1_10To1_11)this.protocol).registerClientbound(ClientboundPackets1_9_3.ADD_MOB, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.UUID);
                this.map(Types.UNSIGNED_BYTE, Types.VAR_INT);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.SHORT);
                this.map(Types.SHORT);
                this.map(Types.SHORT);
                this.map(Types.ENTITY_DATA_LIST1_9);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    int n2 = packetWrapper.get(Types.VAR_INT, 1);
                    EntityTypes1_11.EntityType entityType = EntityPacketRewriter1_11.this.rewriteEntityType(n2, packetWrapper.get(Types.ENTITY_DATA_LIST1_9, 0));
                    if (entityType != null) {
                        packetWrapper.set(Types.VAR_INT, 1, entityType.getId());
                        packetWrapper.user().getEntityTracker(Protocol1_10To1_11.class).addEntity(n, entityType);
                        EntityPacketRewriter1_11.this.handleEntityData(n, packetWrapper.get(Types.ENTITY_DATA_LIST1_9, 0), packetWrapper.user());
                    }
                });
            }
        });
        ((Protocol1_10To1_11)this.protocol).registerClientbound(ClientboundPackets1_9_3.TAKE_ITEM_ENTITY, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> packetWrapper.write(Types.VAR_INT, 1));
            }
        });
        this.registerSetEntityData(ClientboundPackets1_9_3.SET_ENTITY_DATA, Types.ENTITY_DATA_LIST1_9);
        ((Protocol1_10To1_11)this.protocol).registerClientbound(ClientboundPackets1_9_3.TELEPORT_ENTITY, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.BOOLEAN);
                this.handler(packetWrapper -> {
                    EntityTracker1_11 entityTracker1_11;
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    if (Via.getConfig().isHologramPatch() && (entityTracker1_11 = (EntityTracker1_11)packetWrapper.user().getEntityTracker(Protocol1_10To1_11.class)).isHologram(n)) {
                        Double d = packetWrapper.get(Types.DOUBLE, 1);
                        d = d - Via.getConfig().getHologramYOffset();
                        packetWrapper.set(Types.DOUBLE, 1, d);
                    }
                });
            }
        });
        ((Protocol1_10To1_11)this.protocol).registerClientbound(ClientboundPackets1_9_3.SET_ENTITY_MOTION, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            if (this.tracker(packetWrapper.user()).entityType(n) == EntityTypes1_10.EntityType.FISHING_HOOK) {
                this.tryFixFishingHookVelocity(packetWrapper);
            }
        });
        this.registerRemoveEntities(ClientboundPackets1_9_3.REMOVE_ENTITIES);
        ((Protocol1_10To1_11)this.protocol).registerClientbound(ClientboundPackets1_9_3.BLOCK_ENTITY_DATA, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_8);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.NAMED_COMPOUND_TAG);
                this.handler(packetWrapper -> {
                    StringTag stringTag;
                    CompoundTag compoundTag = packetWrapper.get(Types.NAMED_COMPOUND_TAG, 0);
                    if (packetWrapper.get(Types.UNSIGNED_BYTE, 0) == 1) {
                        EntityMappings1_11.toClientSpawner(compoundTag);
                    }
                    if ((stringTag = compoundTag.getStringTag("id")) != null) {
                        stringTag.setValue(BlockEntityMappings1_11.toNewIdentifier(stringTag.getValue()));
                    }
                });
            }
        });
    }

    @Override
    protected void registerRewrites() {
        this.filter().handler((entityDataHandlerEvent, entityData) -> {
            if (entityData.getValue() instanceof DataItem) {
                EntityMappings1_11.toClientItem((Item)entityData.value());
            }
        });
        this.filter().type(EntityTypes1_11.EntityType.GUARDIAN).index(12).handler((entityDataHandlerEvent, entityData) -> {
            boolean bl = ((Byte)entityData.getValue() & 2) == 2;
            entityData.setTypeAndValue(EntityDataTypes1_9.BOOLEAN, bl);
        });
        this.filter().type(EntityTypes1_11.EntityType.ABSTRACT_SKELETON).removeIndex(12);
        this.filter().type(EntityTypes1_11.EntityType.ZOMBIE).handler((entityDataHandlerEvent, entityData) -> {
            if ((entityDataHandlerEvent.entityType() == EntityTypes1_11.EntityType.ZOMBIE || entityDataHandlerEvent.entityType() == EntityTypes1_11.EntityType.HUSK) && entityData.id() == 14) {
                entityDataHandlerEvent.cancel();
            } else if (entityData.id() == 15) {
                entityData.setId(14);
            }
        });
        this.filter().type(EntityTypes1_11.EntityType.ABSTRACT_HORSE).handler((entityDataHandlerEvent, entityData) -> {
            EntityType entityType = entityDataHandlerEvent.entityType();
            int n = entityData.id();
            if (n == 14) {
                entityDataHandlerEvent.cancel();
                return;
            }
            if (n == 16) {
                entityData.setId(14);
            } else if (n == 17) {
                entityData.setId(16);
            }
            if (!entityType.is(EntityTypes1_11.EntityType.HORSE) && entityData.id() == 15 || entityData.id() == 16) {
                entityDataHandlerEvent.cancel();
                return;
            }
            if ((entityType == EntityTypes1_11.EntityType.DONKEY || entityType == EntityTypes1_11.EntityType.MULE) && entityData.id() == 13) {
                if (((Byte)entityData.getValue() & 8) == 8) {
                    entityDataHandlerEvent.createExtraData(new EntityData(15, EntityDataTypes1_9.BOOLEAN, true));
                } else {
                    entityDataHandlerEvent.createExtraData(new EntityData(15, EntityDataTypes1_9.BOOLEAN, false));
                }
            }
        });
        this.filter().type(EntityTypes1_11.EntityType.ARMOR_STAND).index(0).handler((entityDataHandlerEvent, entityData) -> {
            int n;
            EntityTracker1_11 entityTracker1_11;
            if (!Via.getConfig().isHologramPatch()) {
                return;
            }
            EntityData entityData2 = entityDataHandlerEvent.dataAtIndex(11);
            EntityData entityData3 = entityDataHandlerEvent.dataAtIndex(2);
            EntityData entityData4 = entityDataHandlerEvent.dataAtIndex(3);
            if (entityData2 == null || entityData3 == null || entityData4 == null) {
                return;
            }
            byte by = (Byte)entityData.value();
            if ((by & 0x20) == 32 && ((Byte)entityData2.getValue() & 1) == 1 && !((String)entityData3.getValue()).isEmpty() && ((Boolean)entityData4.getValue()).booleanValue() && (entityTracker1_11 = (EntityTracker1_11)this.tracker(entityDataHandlerEvent.user())).addHologram(n = entityDataHandlerEvent.entityId())) {
                PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_9_3.MOVE_ENTITY_POS, null, entityDataHandlerEvent.user());
                packetWrapper.write(Types.VAR_INT, n);
                packetWrapper.write(Types.SHORT, (short)0);
                packetWrapper.write(Types.SHORT, (short)(128.0 * (-Via.getConfig().getHologramYOffset() * 32.0)));
                packetWrapper.write(Types.SHORT, (short)0);
                packetWrapper.write(Types.BOOLEAN, true);
                packetWrapper.send(Protocol1_10To1_11.class);
            }
        });
    }

    private void tryFixFishingHookVelocity(PacketWrapper packetWrapper) {
        short s = packetWrapper.read(Types.SHORT);
        short s2 = packetWrapper.read(Types.SHORT);
        short s3 = packetWrapper.read(Types.SHORT);
        packetWrapper.write(Types.SHORT, (short)((double)s * 1.33));
        packetWrapper.write(Types.SHORT, (short)((double)s2 * 1.2));
        packetWrapper.write(Types.SHORT, (short)((double)s3 * 1.33));
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_11.EntityType.findById(n);
    }

    @Override
    public EntityType objectTypeFromId(int n, int n2) {
        return EntityTypes1_11.ObjectType.getEntityType(n, n2);
    }

    public EntityTypes1_11.EntityType rewriteEntityType(int n, List<EntityData> list) {
        EntityTypes1_11.EntityType entityType;
        block16: {
            entityType = EntityTypes1_11.EntityType.findById(n);
            if (entityType == null) {
                return null;
            }
            try {
                Optional<EntityData> optional;
                if (entityType.is(EntityTypes1_11.EntityType.GUARDIAN) && (optional = this.getById(list, 12)).isPresent() && ((Byte)optional.get().getValue() & 4) == 4) {
                    return EntityTypes1_11.EntityType.ELDER_GUARDIAN;
                }
                if (entityType.is(EntityTypes1_11.EntityType.SKELETON) && (optional = this.getById(list, 12)).isPresent()) {
                    if ((Integer)optional.get().getValue() == 1) {
                        return EntityTypes1_11.EntityType.WITHER_SKELETON;
                    }
                    if ((Integer)optional.get().getValue() == 2) {
                        return EntityTypes1_11.EntityType.STRAY;
                    }
                }
                if (entityType.is(EntityTypes1_11.EntityType.ZOMBIE) && (optional = this.getById(list, 13)).isPresent()) {
                    int n2 = (Integer)optional.get().getValue();
                    if (n2 > 0 && n2 < 6) {
                        list.add(new EntityData(16, EntityDataTypes1_9.VAR_INT, n2 - 1));
                        return EntityTypes1_11.EntityType.ZOMBIE_VILLAGER;
                    }
                    if (n2 == 6) {
                        return EntityTypes1_11.EntityType.HUSK;
                    }
                }
                if (entityType.is(EntityTypes1_11.EntityType.HORSE) && (optional = this.getById(list, 14)).isPresent()) {
                    if ((Integer)optional.get().getValue() == 0) {
                        return EntityTypes1_11.EntityType.HORSE;
                    }
                    if ((Integer)optional.get().getValue() == 1) {
                        return EntityTypes1_11.EntityType.DONKEY;
                    }
                    if ((Integer)optional.get().getValue() == 2) {
                        return EntityTypes1_11.EntityType.MULE;
                    }
                    if ((Integer)optional.get().getValue() == 3) {
                        return EntityTypes1_11.EntityType.ZOMBIE_HORSE;
                    }
                    if ((Integer)optional.get().getValue() == 4) {
                        return EntityTypes1_11.EntityType.SKELETON_HORSE;
                    }
                }
            }
            catch (Exception exception) {
                if (!Via.getConfig().logEntityDataErrors()) break block16;
                ((Protocol1_10To1_11)this.protocol).getLogger().warning("An error occurred with entity type rewriter");
                ((Protocol1_10To1_11)this.protocol).getLogger().warning("Entity data: " + String.valueOf(list));
                ((Protocol1_10To1_11)this.protocol).getLogger().log(Level.WARNING, "Error: ", exception);
            }
        }
        return entityType;
    }

    public Optional<EntityData> getById(List<EntityData> list, int n) {
        for (EntityData entityData : list) {
            if (entityData.id() != n) continue;
            return Optional.of(entityData);
        }
        return Optional.empty();
    }
}


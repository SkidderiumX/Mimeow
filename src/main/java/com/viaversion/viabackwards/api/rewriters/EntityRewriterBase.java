/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.api.rewriters;

import com.google.common.base.Preconditions;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.ViaBackwards;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.entities.storage.EntityReplacement;
import com.viaversion.viabackwards.api.entities.storage.WrappedEntityData;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.entity.TrackedEntity;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.minecraft.Particle;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityDataType;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectOpenHashMap;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.rewriter.EntityRewriter;
import java.util.List;
import org.checkerframework.checker.nullness.qual.Nullable;

public abstract class EntityRewriterBase<C extends ClientboundPacketType, T extends BackwardsProtocol<C, ?, ?, ?>>
extends EntityRewriter<C, T> {
    private final Int2ObjectMap<EntityReplacement> entityDataMappings = new Int2ObjectOpenHashMap<EntityReplacement>();
    private final EntityDataType displayNameDataType;
    private final EntityDataType displayVisibilityDataType;
    private final int displayNameIndex;
    private final int displayVisibilityIndex;

    EntityRewriterBase(T t, EntityDataType entityDataType, int n, EntityDataType entityDataType2, int n2) {
        super(t, false);
        this.displayNameDataType = entityDataType;
        this.displayNameIndex = n;
        this.displayVisibilityDataType = entityDataType2;
        this.displayVisibilityIndex = n2;
    }

    @Override
    public void handleEntityData(int n, List<EntityData> list, UserConnection userConnection) {
        Object object;
        TrackedEntity trackedEntity = this.tracker(userConnection).entity(n);
        boolean bl = trackedEntity == null || !trackedEntity.hasSentEntityData();
        super.handleEntityData(n, list, userConnection);
        if (trackedEntity == null) {
            return;
        }
        EntityReplacement entityReplacement = this.entityDataForType(trackedEntity.entityType());
        if (entityReplacement != null && (object = entityReplacement.entityName()) != null) {
            EntityData entityData = this.getData(this.displayNameIndex, list);
            if (bl) {
                if (entityData == null) {
                    list.add(new EntityData(this.displayNameIndex, this.displayNameDataType, object));
                    this.addDisplayVisibilityData(list);
                } else if (this.isEmptyDisplayName(entityData.getValue())) {
                    entityData.setValue(object);
                    this.addDisplayVisibilityData(list);
                }
            } else if (entityData != null && this.isEmptyDisplayName(entityData)) {
                entityData.setValue(object);
                this.addDisplayVisibilityData(list);
            }
        }
        if (entityReplacement != null && entityReplacement.hasBaseData() && bl) {
            entityReplacement.defaultData().createData(new WrappedEntityData(list));
        }
    }

    private boolean isEmptyDisplayName(@Nullable Object object) {
        if (object == null) {
            return true;
        }
        if (object instanceof String) {
            String string = (String)object;
            return string.isEmpty();
        }
        if (object instanceof JsonElement) {
            JsonElement jsonElement = (JsonElement)object;
            return jsonElement.isJsonNull() || jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().getAsString().isEmpty();
        }
        return false;
    }

    private void addDisplayVisibilityData(List<EntityData> list) {
        if (this.alwaysShowOriginalMobName()) {
            this.removeData(this.displayVisibilityIndex, list);
            list.add(new EntityData(this.displayVisibilityIndex, this.displayVisibilityDataType, this.getDisplayVisibilityDataValue()));
        }
    }

    protected Object getDisplayVisibilityDataValue() {
        return true;
    }

    protected boolean alwaysShowOriginalMobName() {
        return ViaBackwards.getConfig().alwaysShowOriginalMobName();
    }

    protected @Nullable EntityData getData(int n, List<EntityData> list) {
        for (EntityData entityData : list) {
            if (entityData.id() != n) continue;
            return entityData;
        }
        return null;
    }

    protected void removeData(int n, List<EntityData> list) {
        list.removeIf(entityData -> entityData.id() == n);
    }

    protected boolean hasData(EntityType entityType) {
        return this.entityDataMappings.containsKey(entityType.getId());
    }

    protected @Nullable EntityReplacement entityDataForType(EntityType entityType) {
        return (EntityReplacement)this.entityDataMappings.get(entityType.getId());
    }

    protected EntityReplacement mapEntityTypeWithData(EntityType entityType, EntityType entityType2) {
        Preconditions.checkArgument(entityType.getClass() == entityType2.getClass(), "Both entity types need to be of the same class");
        int n = this.newEntityId(entityType2.getId());
        EntityReplacement entityReplacement = new EntityReplacement((BackwardsProtocol)this.protocol, entityType, n);
        this.mapEntityType(entityType.getId(), n);
        this.entityDataMappings.put(entityType.getId(), entityReplacement);
        return entityReplacement;
    }

    public void registerEntityDataTypeHandler(@Nullable EntityDataType entityDataType, @Nullable EntityDataType entityDataType2, @Nullable EntityDataType entityDataType3, @Nullable EntityDataType entityDataType4, @Nullable EntityDataType entityDataType5, @Nullable EntityDataType entityDataType6) {
        this.filter().handler((entityDataHandlerEvent, entityData) -> {
            EntityDataType entityDataType7 = entityData.dataType();
            if (entityDataType7 == entityDataType) {
                entityData.setValue(((BackwardsProtocol)this.protocol).getItemRewriter().handleItemToClient(entityDataHandlerEvent.user(), (Item)entityData.value()));
            } else if (entityDataType7 == entityDataType2) {
                int n = (Integer)entityData.value();
                entityData.setValue(((BackwardsProtocol)this.protocol).getMappingData().getNewBlockStateId(n));
            } else if (entityDataType7 == entityDataType3) {
                int n = (Integer)entityData.value();
                if (n != 0) {
                    entityData.setValue(((BackwardsProtocol)this.protocol).getMappingData().getNewBlockStateId(n));
                }
            } else if (entityDataType7 == entityDataType4) {
                ((BackwardsProtocol)this.protocol).getParticleRewriter().rewriteParticle(entityDataHandlerEvent.user(), (Particle)entityData.value());
            } else if (entityDataType7 == entityDataType6 || entityDataType7 == entityDataType5) {
                JsonElement jsonElement = (JsonElement)entityData.value();
                ((BackwardsProtocol)this.protocol).getComponentRewriter().processText(entityDataHandlerEvent.user(), jsonElement);
            }
        });
    }

    public void registerEntityDataTypeHandler1_20_3(@Nullable EntityDataType entityDataType, @Nullable EntityDataType entityDataType2, @Nullable EntityDataType entityDataType3, @Nullable EntityDataType entityDataType4, @Nullable EntityDataType entityDataType5, @Nullable EntityDataType entityDataType6, @Nullable EntityDataType entityDataType7) {
        this.filter().handler((entityDataHandlerEvent, entityData) -> {
            EntityDataType entityDataType8 = entityData.dataType();
            if (entityDataType8 == entityDataType) {
                entityData.setValue(((BackwardsProtocol)this.protocol).getItemRewriter().handleItemToClient(entityDataHandlerEvent.user(), (Item)entityData.value()));
            } else if (entityDataType8 == entityDataType2) {
                int n = (Integer)entityData.value();
                entityData.setValue(((BackwardsProtocol)this.protocol).getMappingData().getNewBlockStateId(n));
            } else if (entityDataType8 == entityDataType3) {
                int n = (Integer)entityData.value();
                if (n != 0) {
                    entityData.setValue(((BackwardsProtocol)this.protocol).getMappingData().getNewBlockStateId(n));
                }
            } else if (entityDataType8 == entityDataType4) {
                ((BackwardsProtocol)this.protocol).getParticleRewriter().rewriteParticle(entityDataHandlerEvent.user(), (Particle)entityData.value());
            } else if (entityDataType8 == entityDataType5) {
                Particle[] particleArray;
                for (Particle particle : particleArray = (Particle[])entityData.value()) {
                    ((BackwardsProtocol)this.protocol).getParticleRewriter().rewriteParticle(entityDataHandlerEvent.user(), particle);
                }
            } else if (entityDataType8 == entityDataType7 || entityDataType8 == entityDataType6) {
                ((BackwardsProtocol)this.protocol).getComponentRewriter().processTag(entityDataHandlerEvent.user(), (Tag)entityData.value());
            }
        });
    }

    protected PacketHandler getTrackerHandler(Type<? extends Number> type, int n) {
        return packetWrapper -> {
            Number number = (Number)packetWrapper.get(type, n);
            EntityType entityType = this.typeFromId(number.intValue());
            if (entityType != null) {
                this.tracker(packetWrapper.user()).addEntity(packetWrapper.get(Types.VAR_INT, 0), entityType);
            }
        };
    }

    protected PacketHandler getTrackerHandler() {
        return this.getTrackerHandler(Types.VAR_INT, 1);
    }

    protected PacketHandler getDimensionHandler(int n) {
        return packetWrapper -> {
            int n2;
            Object t = packetWrapper.user().getClientWorld(((BackwardsProtocol)this.protocol).getClass());
            if (((ClientWorld)t).setEnvironment(n2 = packetWrapper.get(Types.INT, n).intValue())) {
                this.tracker(packetWrapper.user()).clearEntities();
            }
        };
    }
}


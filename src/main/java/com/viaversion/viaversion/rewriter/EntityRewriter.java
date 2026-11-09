/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.rewriter;

import com.google.common.base.Preconditions;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.FullMappings;
import com.viaversion.viaversion.api.data.Int2IntMapMappings;
import com.viaversion.viaversion.api.data.Mappings;
import com.viaversion.viaversion.api.data.entity.DimensionData;
import com.viaversion.viaversion.api.data.entity.TrackedEntity;
import com.viaversion.viaversion.api.minecraft.GameMode;
import com.viaversion.viaversion.api.minecraft.Particle;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityDataType;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.rewriter.RewriterBase;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.data.entity.DimensionDataImpl;
import com.viaversion.viaversion.rewriter.entitydata.EntityDataFilter;
import com.viaversion.viaversion.rewriter.entitydata.EntityDataHandlerEvent;
import com.viaversion.viaversion.rewriter.entitydata.EntityDataHandlerEventImpl;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.TagUtil;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;
import org.checkerframework.checker.nullness.qual.Nullable;

public abstract class EntityRewriter<C extends ClientboundPacketType, T extends Protocol<C, ?, ?, ?>>
extends RewriterBase<T>
implements com.viaversion.viaversion.api.rewriter.EntityRewriter<T> {
    protected final List<EntityDataFilter> entityDataFilters = new ArrayList<EntityDataFilter>();
    protected final boolean trackMappedType;
    protected Mappings typeMappings;
    private EntityType fallingBlockType;

    protected EntityRewriter(T t) {
        this(t, true);
    }

    protected EntityRewriter(T t, boolean bl) {
        super(t);
        this.trackMappedType = bl;
        t.put(this);
    }

    public EntityDataFilter.Builder filter() {
        return new EntityDataFilter.Builder(this);
    }

    public EntityDataFilter.DataTypeMapper dataTypeMapper() {
        Preconditions.checkNotNull(this.protocol.mappedTypes(), "Protocol does not override mappedTypes, use filter().mapDataType instead");
        return new EntityDataFilter.DataTypeMapper(this);
    }

    public void registerFilter(EntityDataFilter entityDataFilter) {
        Preconditions.checkArgument(!this.entityDataFilters.contains(entityDataFilter));
        this.entityDataFilters.add(entityDataFilter);
    }

    @Override
    public void handleEntityData(int n, List<EntityData> list, UserConnection userConnection) {
        TrackedEntity trackedEntity = this.tracker(userConnection).entity(n);
        EntityType entityType = trackedEntity != null ? trackedEntity.entityType() : null;
        int n2 = list.size();
        for (int i = 0; i < n2; ++i) {
            EntityData entityData = list.get(i);
            EntityDataHandlerEvent entityDataHandlerEvent = null;
            for (EntityDataFilter entityDataFilter : this.entityDataFilters) {
                if (!entityDataFilter.isFiltered(entityType, entityData)) continue;
                if (entityDataHandlerEvent == null) {
                    entityDataHandlerEvent = new EntityDataHandlerEventImpl(userConnection, trackedEntity, n, entityData, list);
                }
                try {
                    entityDataFilter.handler().handle(entityDataHandlerEvent, entityData);
                }
                catch (Exception exception) {
                    this.logException(exception, entityType, list, entityData);
                    list.remove(i--);
                    --n2;
                    break;
                }
                if (!entityDataHandlerEvent.cancelled()) continue;
                list.remove(i--);
                --n2;
                break;
            }
            if (entityDataHandlerEvent == null || !entityDataHandlerEvent.hasExtraData()) continue;
            list.addAll(entityDataHandlerEvent.extraData());
        }
        if (trackedEntity != null) {
            trackedEntity.sentEntityData(true);
        }
    }

    @Override
    public int newEntityId(int n) {
        return this.typeMappings != null ? this.typeMappings.getNewIdOrDefault(n, n) : n;
    }

    @Override
    public void onMappingDataLoaded() {
        if (this.protocol.getMappingData() != null && !Mappings.isFullIdentity(this.protocol.getMappingData().getEntityMappings())) {
            this.mapTypes();
        }
    }

    public @Nullable Mappings typeMappings() {
        return this.typeMappings;
    }

    @Override
    public String mappedEntityIdentifier(String string) {
        FullMappings fullMappings;
        Object object = this.typeMappings;
        if (object instanceof FullMappings && (object = (fullMappings = (FullMappings)object).mappedIdentifier(string)) != null) {
            return object;
        }
        return string;
    }

    @Override
    public @Nullable EntityType typeFromId(String string) {
        FullMappings fullMappings = this.protocol().getMappingData().getEntityMappings();
        int n = this.trackMappedType ? fullMappings.mappedId(string) : fullMappings.id(string);
        return n == -1 ? null : this.typeFromId(n);
    }

    public void mapEntityType(EntityType entityType, EntityType entityType2) {
        Preconditions.checkArgument(entityType.getClass() != entityType2.getClass(), "EntityTypes should not be of the same class/enum");
        this.mapEntityType(entityType.getId(), entityType2.getId());
    }

    protected void mapEntityType(int n, int n2) {
        if (this.typeMappings == null) {
            this.typeMappings = Int2IntMapMappings.of();
        }
        this.typeMappings.setNewId(n, n2);
    }

    public void mapTypes() {
        Preconditions.checkArgument(this.typeMappings == null, "Type mappings have already been set - manual type mappings should be set *after* this");
        Preconditions.checkNotNull(this.protocol.getMappingData().getEntityMappings(), "Protocol does not have entity mappings");
        this.typeMappings = this.protocol.getMappingData().getEntityMappings();
    }

    public void registerEntityDataTypeHandler(@Nullable EntityDataType entityDataType, @Nullable EntityDataType entityDataType2, @Nullable EntityDataType entityDataType3) {
        this.registerEntityDataTypeHandler(entityDataType, null, entityDataType2, entityDataType3, null);
    }

    public void registerEntityDataTypeHandler(@Nullable EntityDataType entityDataType, @Nullable EntityDataType entityDataType2, @Nullable EntityDataType entityDataType3, @Nullable EntityDataType entityDataType4, @Nullable EntityDataType entityDataType5) {
        this.registerEntityDataTypeHandler(entityDataType, entityDataType2, entityDataType3, entityDataType4, entityDataType5, null, null);
    }

    public void registerEntityDataTypeHandler(@Nullable EntityDataType entityDataType, @Nullable EntityDataType entityDataType2, @Nullable EntityDataType entityDataType3, @Nullable EntityDataType entityDataType4, @Nullable EntityDataType entityDataType5, @Nullable EntityDataType entityDataType6, @Nullable EntityDataType entityDataType7) {
        this.filter().handler((entityDataHandlerEvent, entityData) -> {
            EntityDataType entityDataType8 = entityData.dataType();
            if (entityDataType8 == entityDataType) {
                entityData.setValue(this.protocol.getItemRewriter().handleItemToClient(entityDataHandlerEvent.user(), (Item)entityData.value()));
            } else if (entityDataType8 == entityDataType2) {
                int n = (Integer)entityData.value();
                entityData.setValue(this.protocol.getMappingData().getNewBlockStateId(n));
            } else if (entityDataType8 == entityDataType3) {
                int n = (Integer)entityData.value();
                if (n != 0) {
                    entityData.setValue(this.protocol.getMappingData().getNewBlockStateId(n));
                }
            } else if (entityDataType8 == entityDataType4) {
                this.protocol.getParticleRewriter().rewriteParticle(entityDataHandlerEvent.user(), (Particle)entityData.value());
            } else if (entityDataType8 == entityDataType5) {
                Particle[] particleArray;
                for (Particle particle : particleArray = (Particle[])entityData.value()) {
                    this.protocol.getParticleRewriter().rewriteParticle(entityDataHandlerEvent.user(), particle);
                }
            } else if ((entityDataType8 == entityDataType6 || entityDataType8 == entityDataType7) && this.protocol.getComponentRewriter() != null) {
                Tag tag = (Tag)entityData.value();
                this.protocol.getComponentRewriter().processTag(entityDataHandlerEvent.user(), tag);
            }
        });
    }

    public void registerBlockStateHandler(EntityType entityType, int n) {
        this.filter().type(entityType).index(n).handler((entityDataHandlerEvent, entityData) -> {
            int n_r = (Integer)entityData.getValue();
            entityData.setValue(this.protocol.getMappingData().getNewBlockStateId(n_r));
        });
    }

    public void registerTracker(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.UUID);
            packetWrapper.passthrough(Types.VAR_INT);
            this.trackerHandler().handle(packetWrapper);
        });
    }

    public void registerTrackerWithData(C c) {
        this.protocol.registerClientbound(c, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.UUID);
                this.map(Types.VAR_INT);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.INT);
                this.handler(EntityRewriter.this.trackerHandler());
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    EntityType entityType = EntityRewriter.this.tracker(packetWrapper.user()).entityType(n);
                    if (entityType == EntityRewriter.this.fallingBlockType()) {
                        packetWrapper.set(Types.INT, 0, EntityRewriter.this.protocol.getMappingData().getNewBlockStateId(packetWrapper.get(Types.INT, 0)));
                    }
                });
            }
        });
    }

    public void registerTrackerWithData1_19(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> this.handleAddEntity(packetWrapper, false));
    }

    public void registerTrackerWithData1_21_9(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> this.handleAddEntity(packetWrapper, true));
    }

    protected TrackedEntity handleAddEntity(PacketWrapper packetWrapper, boolean bl) {
        int n = packetWrapper.passthrough(Types.VAR_INT);
        packetWrapper.passthrough(Types.UUID);
        int n2 = packetWrapper.passthrough(Types.VAR_INT);
        packetWrapper.passthrough(Types.DOUBLE);
        packetWrapper.passthrough(Types.DOUBLE);
        packetWrapper.passthrough(Types.DOUBLE);
        if (bl) {
            packetWrapper.passthrough(Types.LOW_PRECISION_VECTOR);
        }
        packetWrapper.passthrough(Types.BYTE);
        packetWrapper.passthrough(Types.BYTE);
        packetWrapper.passthrough(Types.BYTE);
        int n3 = packetWrapper.passthrough(Types.VAR_INT);
        TrackedEntity trackedEntity = this.trackAndRewrite(packetWrapper, n2, n);
        if (this.protocol.getMappingData() != null && trackedEntity.entityType() == this.fallingBlockType()) {
            int n4 = this.protocol.getMappingData().getNewBlockStateId(n3);
            packetWrapper.set(Types.VAR_INT, 2, n4);
        }
        return trackedEntity;
    }

    public void registerTracker(C c, EntityType entityType) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            this.tracker(packetWrapper.user()).addEntity(n, entityType);
        });
    }

    public void registerRemoveEntities(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            int[] nArray = packetWrapper.passthrough(Types.VAR_INT_ARRAY_PRIMITIVE);
            Object e = this.tracker(packetWrapper.user());
            for (int n : nArray) {
                e.removeEntity(n);
            }
        });
    }

    public void registerSetEntityData(C c, @Nullable Type<List<EntityData>> type, Type<List<EntityData>> type2) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            List list;
            int n = packetWrapper.passthrough(Types.VAR_INT);
            if (type != null) {
                list = (List)packetWrapper.read(type);
                packetWrapper.write(type2, list);
            } else {
                list = (List)packetWrapper.passthrough(type2);
            }
            this.handleEntityData(n, list, packetWrapper.user());
        });
    }

    public void registerSetEntityData(C c, Type<List<EntityData>> type) {
        this.registerSetEntityData(c, null, type);
    }

    public void registerSetEntityData(C c) {
        this.registerSetEntityData(c, this.protocol.types().entityDataList(), this.protocol.mappedTypes().entityDataList());
    }

    public void registerLogin1_20_5(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.INT);
            packetWrapper.passthrough(Types.BOOLEAN);
            packetWrapper.passthrough(Types.STRING_ARRAY);
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.BOOLEAN);
            packetWrapper.passthrough(Types.BOOLEAN);
            packetWrapper.passthrough(Types.BOOLEAN);
            int n2 = packetWrapper.passthrough(Types.VAR_INT);
            String string = packetWrapper.passthrough(Types.STRING);
            this.trackWorldDataByKey1_20_5(packetWrapper.user(), n2, string);
            packetWrapper.passthrough(Types.LONG);
            byte by = packetWrapper.passthrough(Types.BYTE);
            this.tracker(packetWrapper.user()).setInstaBuild(by == GameMode.CREATIVE.id());
            this.trackPlayer(packetWrapper.user(), n);
        });
    }

    public void registerRespawn1_20_5(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            String string = packetWrapper.passthrough(Types.STRING);
            this.trackWorldDataByKey1_20_5(packetWrapper.user(), n, string);
            packetWrapper.passthrough(Types.LONG);
            byte by = packetWrapper.passthrough(Types.BYTE);
            this.tracker(packetWrapper.user()).setInstaBuild(by == GameMode.CREATIVE.id());
        });
    }

    public void registerPlayerAbilities(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            byte by = packetWrapper.passthrough(Types.BYTE);
            this.tracker(packetWrapper.user()).setInstaBuild((by & 8) != 0);
        });
    }

    public void registerGameEvent(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            short s = packetWrapper.passthrough(Types.UNSIGNED_BYTE);
            if (s == 3) {
                int n = (int)Math.floor(packetWrapper.passthrough(Types.FLOAT).floatValue() + 0.5f);
                this.tracker(packetWrapper.user()).setInstaBuild(n == GameMode.CREATIVE.id());
            }
        });
    }

    public PacketHandler trackerHandler() {
        return this.trackerAndRewriterHandler(null);
    }

    public PacketHandler playerTrackerHandler() {
        return packetWrapper -> this.trackPlayer(packetWrapper.user(), packetWrapper.get(Types.INT, 0));
    }

    public void trackPlayer(UserConnection userConnection, int n) {
        Object e = this.tracker(userConnection);
        e.setClientEntityId(n);
        e.addEntity(n, e.playerType());
    }

    public void trackWorld(UserConnection userConnection, String string) {
        Object e = this.tracker(userConnection);
        if (e.currentWorld() != null && !e.currentWorld().equals(string)) {
            e.clearEntities();
        }
        e.setCurrentWorld(string);
    }

    public PacketHandler worldDataTrackerHandler(int n) {
        return packetWrapper -> {
            Object e = this.tracker(packetWrapper.user());
            CompoundTag compoundTag = packetWrapper.get(Types.NAMED_COMPOUND_TAG, n);
            NumberTag numberTag = compoundTag.getNumberTag("height");
            if (numberTag != null) {
                int n2 = numberTag.asInt();
                e.setCurrentWorldSectionHeight(n2 >> 4);
            } else {
                this.protocol.getLogger().warning("Height missing in dimension data: " + String.valueOf(compoundTag));
            }
            NumberTag numberTag2 = compoundTag.getNumberTag("min_y");
            if (numberTag2 != null) {
                e.setCurrentMinY(numberTag2.asInt());
            } else {
                this.protocol.getLogger().warning("Min Y missing in dimension data: " + String.valueOf(compoundTag));
            }
            String string = packetWrapper.get(Types.STRING, 0);
            this.trackWorld(packetWrapper.user(), string);
        };
    }

    public PacketHandler worldDataTrackerHandlerByKey() {
        return packetWrapper -> {
            String string;
            Object e = this.tracker(packetWrapper.user());
            DimensionData dimensionData = e.dimensionData(string = packetWrapper.get(Types.STRING, 0));
            if (dimensionData == null) {
                this.protocol.getLogger().severe("Dimension data missing for dimension: " + string + ", falling back to overworld");
                dimensionData = e.dimensionData("minecraft:overworld");
                Preconditions.checkNotNull(dimensionData, "Overworld data missing");
            }
            e.setCurrentWorldSectionHeight(dimensionData.height() >> 4);
            e.setCurrentMinY(dimensionData.minY());
            String string2 = packetWrapper.get(Types.STRING, 1);
            this.trackWorld(packetWrapper.user(), string2);
        };
    }

    public PacketHandler worldDataTrackerHandlerByKey1_20_5(int n) {
        return packetWrapper -> {
            int n2 = packetWrapper.get(Types.VAR_INT, n);
            String string = packetWrapper.get(Types.STRING, 0);
            this.trackWorldDataByKey1_20_5(packetWrapper.user(), n2, string);
        };
    }

    public void trackWorldDataByKey1_20_5(UserConnection userConnection, int n, String string) {
        Object e = this.tracker(userConnection);
        DimensionData dimensionData = e.dimensionData(n);
        if (dimensionData == null) {
            this.protocol.getLogger().severe("Dimension data missing for dimension: " + n + ", falling back to overworld");
            dimensionData = e.dimensionData("overworld");
            Preconditions.checkNotNull(dimensionData, "Overworld data missing");
        }
        e.setCurrentDimensionId(n);
        e.setCurrentWorldSectionHeight(dimensionData.height() >> 4);
        e.setCurrentMinY(dimensionData.minY());
        this.trackWorld(userConnection, string);
    }

    public PacketHandler biomeSizeTracker() {
        return packetWrapper -> this.trackBiomeSize(packetWrapper.user(), packetWrapper.get(Types.NAMED_COMPOUND_TAG, 0));
    }

    public PacketHandler configurationBiomeSizeTracker() {
        return packetWrapper -> this.trackBiomeSize(packetWrapper.user(), packetWrapper.get(Types.COMPOUND_TAG, 0));
    }

    public void trackBiomeSize(UserConnection userConnection, CompoundTag compoundTag) {
        ListTag<CompoundTag> listTag = TagUtil.getRegistryEntries(compoundTag, "worldgen/biome");
        this.tracker(userConnection).setBiomesSent(listTag.size());
    }

    public PacketHandler dimensionDataHandler() {
        return packetWrapper -> this.cacheDimensionData(packetWrapper.user(), packetWrapper.get(Types.NAMED_COMPOUND_TAG, 0));
    }

    public PacketHandler configurationDimensionDataHandler() {
        return packetWrapper -> this.cacheDimensionData(packetWrapper.user(), packetWrapper.get(Types.COMPOUND_TAG, 0));
    }

    public void cacheDimensionData(UserConnection userConnection, CompoundTag compoundTag) {
        ListTag<CompoundTag> listTag = TagUtil.getRegistryEntries(compoundTag, "dimension_type");
        HashMap<String, DimensionData> hashMap = new HashMap<String, DimensionData>(listTag.size());
        for (CompoundTag compoundTag2 : listTag) {
            NumberTag numberTag = compoundTag2.getNumberTag("id");
            CompoundTag compoundTag3 = compoundTag2.getCompoundTag("element");
            String string = compoundTag2.getStringTag("name").getValue();
            hashMap.put(Key.stripMinecraftNamespace(string), new DimensionDataImpl(numberTag.asInt(), compoundTag3));
        }
        this.tracker(userConnection).setDimensions(hashMap);
    }

    public TrackedEntity trackAndRewrite(PacketWrapper packetWrapper, int n, int n2) {
        EntityType entityType;
        int n3 = this.newEntityId(n);
        if (n3 != n) {
            packetWrapper.set(Types.VAR_INT, 1, n3);
        }
        if ((entityType = this.typeFromId(this.trackMappedType ? n3 : n)) == null) {
            return null;
        }
        return this.tracker(packetWrapper.user()).addEntity(n2, entityType);
    }

    public PacketHandler trackerAndRewriterHandler(@Nullable Type<List<EntityData>> type) {
        return packetWrapper -> {
            int n = packetWrapper.get(Types.VAR_INT, 0);
            int n2 = packetWrapper.get(Types.VAR_INT, 1);
            this.trackAndRewrite(packetWrapper, n2, n);
            if (type != null) {
                this.handleEntityData(n, (List)packetWrapper.get(type, 0), packetWrapper.user());
            }
        };
    }

    public PacketHandler trackerAndRewriterHandler(@Nullable Type<List<EntityData>> type, EntityType entityType) {
        return packetWrapper -> {
            int n = packetWrapper.get(Types.VAR_INT, 0);
            this.tracker(packetWrapper.user()).addEntity(n, entityType);
            if (type != null) {
                this.handleEntityData(n, (List)packetWrapper.get(type, 0), packetWrapper.user());
            }
        };
    }

    public PacketHandler objectTrackerHandler() {
        return packetWrapper -> {
            int n;
            int n2 = packetWrapper.get(Types.VAR_INT, 0);
            byte by = packetWrapper.get(Types.BYTE, 0);
            EntityType entityType = this.objectTypeFromId(by, n = packetWrapper.get(Types.INT, 0).intValue());
            if (entityType == null) {
                return;
            }
            this.tracker(packetWrapper.user()).addEntity(n2, entityType);
        };
    }

    protected EntityType fallingBlockType() {
        if (this.fallingBlockType == null) {
            this.fallingBlockType = this.typeFromId("falling_block");
        }
        return this.fallingBlockType;
    }

    private void logException(Exception exception, @Nullable EntityType entityType, List<EntityData> list, EntityData entityData) {
        if (Via.getConfig().logEntityDataErrors()) {
            this.protocol.getLogger().severe("An error occurred in entity data handler " + this.getClass().getSimpleName() + " for " + (entityType != null ? entityType.name() : "untracked") + " entity type: " + String.valueOf(entityData));
            this.protocol.getLogger().severe(list.stream().sorted(Comparator.comparingInt(EntityData::id)).map(EntityData::toString).collect(Collectors.joining("\n", "Full entity data: ", "")));
            this.protocol.getLogger().log(Level.SEVERE, "Error: ", exception);
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_19to1_18_2.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.viabackwards.ViaBackwards;
import com.viaversion.viabackwards.api.rewriters.EntityRewriter;
import com.viaversion.viabackwards.protocol.v1_19to1_18_2.Protocol1_19To1_18_2;
import com.viaversion.viabackwards.protocol.v1_19to1_18_2.storage.DimensionRegistryStorage;
import com.viaversion.viabackwards.protocol.v1_19to1_18_2.storage.EntityTracker1_19;
import com.viaversion.viabackwards.protocol.v1_19to1_18_2.storage.LastDeathPosition;
import com.viaversion.viabackwards.protocol.v1_19to1_18_2.storage.StoredPainting;
import com.viaversion.viaversion.api.data.ParticleMappings;
import com.viaversion.viaversion.api.data.entity.TrackedEntity;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.GlobalBlockPosition;
import com.viaversion.viaversion.api.minecraft.Particle;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_19;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityDataType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_18;
import com.viaversion.viaversion.api.type.types.version.Types1_19;
import com.viaversion.viaversion.libs.fastutil.ints.IntOpenHashSet;
import com.viaversion.viaversion.libs.fastutil.ints.IntSet;
import com.viaversion.viaversion.protocols.v1_17_1to1_18.packet.ClientboundPackets1_18;
import com.viaversion.viaversion.protocols.v1_18_2to1_19.packet.ClientboundPackets1_19;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.TagUtil;
import java.util.Iterator;

public class EntityPacketRewriter1_19
extends EntityRewriter<ClientboundPackets1_19, Protocol1_19To1_18_2> {
    private static final IntSet WIDE_PAINTINGS = IntOpenHashSet.of(7, 8, 9, 10, 11, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25);

    public EntityPacketRewriter1_19(Protocol1_19To1_18_2 protocol1_19To1_18_2) {
        super(protocol1_19To1_18_2);
    }

    @Override
    protected void registerPackets() {
        this.registerTracker(ClientboundPackets1_19.ADD_EXPERIENCE_ORB, EntityTypes1_19.EXPERIENCE_ORB);
        this.registerTracker(ClientboundPackets1_19.ADD_PLAYER, EntityTypes1_19.PLAYER);
        this.registerSetEntityData(ClientboundPackets1_19.SET_ENTITY_DATA, Types1_19.ENTITY_DATA_LIST, Types1_18.ENTITY_DATA_LIST);
        ((Protocol1_19To1_18_2)this.protocol).replaceClientbound(ClientboundPackets1_19.ADD_ENTITY, new PacketHandlers(){

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
                this.handler(packetWrapper -> {
                    byte by = packetWrapper.read(Types.BYTE);
                    int n = packetWrapper.read(Types.VAR_INT);
                    int n2 = packetWrapper.get(Types.VAR_INT, 0);
                    int n3 = packetWrapper.get(Types.VAR_INT, 1);
                    TrackedEntity trackedEntity = EntityPacketRewriter1_19.this.trackAndRewrite(packetWrapper, n3, n2);
                    if (trackedEntity.entityType().isOrHasParent(EntityTypes1_19.LIVING_ENTITY)) {
                        packetWrapper.write(Types.BYTE, by);
                        byte by2 = packetWrapper.get(Types.BYTE, 0);
                        byte by3 = packetWrapper.get(Types.BYTE, 1);
                        packetWrapper.set(Types.BYTE, 0, by3);
                        packetWrapper.set(Types.BYTE, 1, by2);
                        packetWrapper.setPacketType(ClientboundPackets1_18.ADD_MOB);
                        return;
                    }
                    if (trackedEntity.entityType() == EntityTypes1_19.PAINTING) {
                        packetWrapper.cancel();
                        int n4 = packetWrapper.get(Types.DOUBLE, 0).intValue();
                        int n5 = packetWrapper.get(Types.DOUBLE, 1).intValue();
                        int n6 = packetWrapper.get(Types.DOUBLE, 2).intValue();
                        BlockPosition blockPosition = new BlockPosition(n4, n5, n6);
                        trackedEntity.put(new StoredPainting(n2, packetWrapper.get(Types.UUID, 0), blockPosition, n));
                        return;
                    }
                    if (trackedEntity.entityType() == EntityTypes1_19.FALLING_BLOCK) {
                        n = ((Protocol1_19To1_18_2)EntityPacketRewriter1_19.this.protocol).getMappingData().getNewBlockStateId(n);
                    }
                    packetWrapper.write(Types.INT, n);
                });
            }
        });
        ((Protocol1_19To1_18_2)this.protocol).registerClientbound(ClientboundPackets1_19.TELEPORT_ENTITY, packetWrapper -> {
            StoredPainting storedPainting;
            int n = packetWrapper.passthrough(Types.VAR_INT);
            if (this.tracker(packetWrapper.user()).entityType(n) != EntityTypes1_19.PAINTING) {
                return;
            }
            double d = packetWrapper.read(Types.DOUBLE);
            double d2 = packetWrapper.read(Types.DOUBLE);
            double d3 = packetWrapper.read(Types.DOUBLE);
            TrackedEntity trackedEntity = this.tracker(packetWrapper.user()).entity(n);
            StoredPainting storedPainting2 = storedPainting = trackedEntity != null ? trackedEntity.get(StoredPainting.class) : null;
            if (storedPainting != null && (storedPainting.direction() == 2 || storedPainting.direction() == 3) && WIDE_PAINTINGS.contains(storedPainting.type())) {
                packetWrapper.write(Types.DOUBLE, storedPainting.direction() == 2 ? d : d + 1.0);
                packetWrapper.write(Types.DOUBLE, d2 + 1.0);
                packetWrapper.write(Types.DOUBLE, storedPainting.direction() == 3 ? d3 : d3 + 1.0);
            } else {
                packetWrapper.write(Types.DOUBLE, d + 1.0);
                packetWrapper.write(Types.DOUBLE, d2 + 1.0);
                packetWrapper.write(Types.DOUBLE, d3 + 1.0);
            }
        });
        ((Protocol1_19To1_18_2)this.protocol).registerClientbound(ClientboundPackets1_19.UPDATE_MOB_EFFECT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.map(Types.BYTE);
                this.map(Types.VAR_INT);
                this.map(Types.BYTE);
                this.handler(packetWrapper -> {
                    packetWrapper.read(Types.OPTIONAL_NAMED_COMPOUND_TAG);
                    if (!ViaBackwards.getConfig().mapDarknessEffect()) {
                        return;
                    }
                    EntityTracker1_19 entityTracker1_19 = (EntityTracker1_19)EntityPacketRewriter1_19.this.tracker(packetWrapper.user());
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    int n2 = packetWrapper.get(Types.VAR_INT, 1);
                    if (n2 == 33) {
                        entityTracker1_19.getAffectedByDarkness().add(n);
                        packetWrapper.set(Types.VAR_INT, 1, 15);
                    } else if (n2 == 15) {
                        entityTracker1_19.getAffectedByBlindness().add(n);
                    }
                });
            }
        });
        ((Protocol1_19To1_18_2)this.protocol).registerClientbound(ClientboundPackets1_19.REMOVE_MOB_EFFECT, new PacketHandlers(){

            @Override
            protected void register() {
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    if (!ViaBackwards.getConfig().mapDarknessEffect()) {
                        return;
                    }
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    int n2 = packetWrapper.get(Types.VAR_INT, 1);
                    EntityTracker1_19 entityTracker1_19 = (EntityTracker1_19)EntityPacketRewriter1_19.this.tracker(packetWrapper.user());
                    if (n2 == 33) {
                        entityTracker1_19.getAffectedByDarkness().rem(n);
                        if (!entityTracker1_19.getAffectedByBlindness().contains(n)) {
                            packetWrapper.set(Types.VAR_INT, 1, 15);
                        }
                    } else if (n2 == 15) {
                        entityTracker1_19.getAffectedByBlindness().rem(n);
                        if (entityTracker1_19.getAffectedByDarkness().contains(n)) {
                            packetWrapper.cancel();
                        }
                    }
                });
            }
        });
        ((Protocol1_19To1_18_2)this.protocol).registerClientbound(ClientboundPackets1_19.LOGIN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.BOOLEAN);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.STRING_ARRAY);
                this.map(Types.NAMED_COMPOUND_TAG);
                this.handler(packetWrapper -> {
                    CompoundTag compoundTag3;
                    Iterator<CompoundTag> iterator2;
                    DimensionRegistryStorage dimensionRegistryStorage = packetWrapper.user().get(DimensionRegistryStorage.class);
                    dimensionRegistryStorage.clear();
                    String string = Key.stripMinecraftNamespace(packetWrapper.read(Types.STRING));
                    CompoundTag compoundTag2 = packetWrapper.get(Types.NAMED_COMPOUND_TAG, 0);
                    ListTag<CompoundTag> listTag2 = TagUtil.getRegistryEntries(compoundTag2, "dimension_type");
                    boolean bl = false;
                    for (CompoundTag listTag3 : listTag2) {
                        iterator2 = Key.stripMinecraftNamespace(listTag3.getString("name"));
                        compoundTag3 = listTag3.getCompoundTag("element");
                        dimensionRegistryStorage.addDimension((String)((Object)iterator2), compoundTag3.copy());
                        if (bl || !((String)((Object)iterator2)).equals(string)) continue;
                        packetWrapper.write(Types.NAMED_COMPOUND_TAG, compoundTag3);
                        bl = true;
                    }
                    if (!bl) {
                        throw new IllegalArgumentException("Could not find dimension " + string + " in dimension registry");
                    }
                    ListTag<CompoundTag> listTag4 = TagUtil.getRegistryEntries(compoundTag2, "worldgen/biome");
                    Iterator iterator3 = listTag4.iterator();
                    while (iterator3.hasNext()) {
                        iterator2 = (CompoundTag)iterator3.next();
                        compoundTag3 = ((CompoundTag)((Object)iterator2)).getCompoundTag("element");
                        compoundTag3.putString("category", "none");
                    }
                    EntityPacketRewriter1_19.this.tracker(packetWrapper.user()).setBiomesSent(listTag4.size());
                    ListTag<CompoundTag> listTag = TagUtil.removeRegistryEntries(compoundTag2, "chat_type");
                    for (CompoundTag compoundTag3 : listTag) {
                        NumberTag numberTag = compoundTag3.getNumberTag("id");
                        dimensionRegistryStorage.addChatType(numberTag.asInt(), compoundTag3);
                    }
                });
                this.map(Types.STRING);
                this.map(Types.LONG);
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.map(Types.BOOLEAN);
                this.map(Types.BOOLEAN);
                this.map(Types.BOOLEAN);
                this.map(Types.BOOLEAN);
                this.handler(packetWrapper -> {
                    GlobalBlockPosition globalBlockPosition = packetWrapper.read(Types.OPTIONAL_GLOBAL_POSITION);
                    if (globalBlockPosition != null) {
                        packetWrapper.user().put(new LastDeathPosition(globalBlockPosition));
                    } else {
                        packetWrapper.user().remove(LastDeathPosition.class);
                    }
                });
                this.handler(EntityPacketRewriter1_19.this.worldDataTrackerHandler(1));
                this.handler(EntityPacketRewriter1_19.this.playerTrackerHandler());
            }
        });
        ((Protocol1_19To1_18_2)this.protocol).registerClientbound(ClientboundPackets1_19.RESPAWN, new PacketHandlers(){

            @Override
            public void register() {
                this.handler(packetWrapper -> {
                    String string = packetWrapper.read(Types.STRING);
                    CompoundTag compoundTag = packetWrapper.user().get(DimensionRegistryStorage.class).dimension(string);
                    if (compoundTag == null) {
                        throw new IllegalArgumentException("Could not find dimension " + string + " in dimension registry");
                    }
                    packetWrapper.write(Types.NAMED_COMPOUND_TAG, compoundTag);
                });
                this.map(Types.STRING);
                this.map(Types.LONG);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.BYTE);
                this.map(Types.BOOLEAN);
                this.map(Types.BOOLEAN);
                this.map(Types.BOOLEAN);
                this.handler(packetWrapper -> {
                    GlobalBlockPosition globalBlockPosition = packetWrapper.read(Types.OPTIONAL_GLOBAL_POSITION);
                    if (globalBlockPosition != null) {
                        packetWrapper.user().put(new LastDeathPosition(globalBlockPosition));
                    } else {
                        packetWrapper.user().remove(LastDeathPosition.class);
                    }
                });
                this.handler(EntityPacketRewriter1_19.this.worldDataTrackerHandler(0));
            }
        });
        ((Protocol1_19To1_18_2)this.protocol).registerClientbound(ClientboundPackets1_19.PLAYER_INFO, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            int n2 = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n2; ++i) {
                packetWrapper.passthrough(Types.UUID);
                if (n == 0) {
                    packetWrapper.passthrough(Types.STRING);
                    packetWrapper.passthrough(Types.PROFILE_PROPERTY_ARRAY);
                    packetWrapper.passthrough(Types.VAR_INT);
                    packetWrapper.passthrough(Types.VAR_INT);
                    packetWrapper.passthrough(Types.OPTIONAL_COMPONENT);
                    packetWrapper.read(Types.OPTIONAL_PROFILE_KEY);
                    continue;
                }
                if (n == 1 || n == 2) {
                    packetWrapper.passthrough(Types.VAR_INT);
                    continue;
                }
                if (n != 3) continue;
                packetWrapper.passthrough(Types.OPTIONAL_COMPONENT);
            }
        });
    }

    @Override
    protected void registerRewrites() {
        this.filter().handler((entityDataHandlerEvent, entityData) -> {
            int n;
            EntityDataType entityDataType;
            if (entityData.dataType().typeId() <= Types1_18.ENTITY_DATA_TYPES.poseType.typeId()) {
                entityData.setDataType(Types1_18.ENTITY_DATA_TYPES.byId(entityData.dataType().typeId()));
            }
            if ((entityDataType = entityData.dataType()) == Types1_18.ENTITY_DATA_TYPES.particleType) {
                Particle particle = (Particle)entityData.getValue();
                ParticleMappings particleMappings = ((Protocol1_19To1_18_2)this.protocol).getMappingData().getParticleMappings();
                if (particle.id() == particleMappings.id("sculk_charge")) {
                    entityDataHandlerEvent.cancel();
                    return;
                }
                if (particle.id() == particleMappings.id("shriek")) {
                    entityDataHandlerEvent.cancel();
                    return;
                }
                if (particle.id() == particleMappings.id("vibration")) {
                    entityDataHandlerEvent.cancel();
                    return;
                }
                ((ParticleRewriter)((Protocol1_19To1_18_2)this.protocol).getParticleRewriter()).rewriteParticle(entityDataHandlerEvent.user(), particle);
            } else if (entityDataType == Types1_18.ENTITY_DATA_TYPES.poseType && (n = ((Integer)entityData.value()).intValue()) >= 8) {
                entityData.setValue(0);
            }
        });
        this.registerEntityDataTypeHandler(Types1_18.ENTITY_DATA_TYPES.itemType, null, Types1_18.ENTITY_DATA_TYPES.optionalBlockStateType, null, Types1_18.ENTITY_DATA_TYPES.componentType, Types1_18.ENTITY_DATA_TYPES.optionalComponentType);
        this.registerBlockStateHandler(EntityTypes1_19.ABSTRACT_MINECART, 11);
        this.filter().type(EntityTypes1_19.PAINTING).index(8).handler((entityDataHandlerEvent, entityData) -> {
            StoredPainting storedPainting;
            entityDataHandlerEvent.cancel();
            TrackedEntity trackedEntity = this.tracker(entityDataHandlerEvent.user()).entity(entityDataHandlerEvent.entityId());
            StoredPainting storedPainting2 = storedPainting = trackedEntity != null ? trackedEntity.get(StoredPainting.class) : null;
            if (storedPainting != null) {
                int n = (Integer)entityData.value();
                storedPainting.setType(n);
                PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_18.ADD_PAINTING, entityDataHandlerEvent.user());
                packetWrapper.write(Types.VAR_INT, storedPainting.entityId());
                packetWrapper.write(Types.UUID, storedPainting.uuid());
                packetWrapper.write(Types.VAR_INT, n);
                packetWrapper.write(Types.BLOCK_POSITION1_14, storedPainting.position());
                packetWrapper.write(Types.BYTE, storedPainting.direction());
                try {
                    packetWrapper.send(Protocol1_19To1_18_2.class);
                }
                catch (Exception exception) {
                    throw new RuntimeException(exception);
                }
            }
        });
        this.filter().type(EntityTypes1_19.CAT).index(19).handler((entityDataHandlerEvent, entityData) -> entityData.setDataType(Types1_18.ENTITY_DATA_TYPES.varIntType));
        this.filter().type(EntityTypes1_19.FROG).cancel(16);
        this.filter().type(EntityTypes1_19.FROG).cancel(17);
        this.filter().type(EntityTypes1_19.FROG).cancel(18);
        this.filter().type(EntityTypes1_19.WARDEN).cancel(16);
        this.filter().type(EntityTypes1_19.GOAT).cancel(18);
        this.filter().type(EntityTypes1_19.GOAT).cancel(19);
    }

    @Override
    public void onMappingDataLoaded() {
        super.onMappingDataLoaded();
        this.mapEntityTypeWithData(EntityTypes1_19.FROG, EntityTypes1_19.RABBIT).jsonName();
        this.mapEntityTypeWithData(EntityTypes1_19.TADPOLE, EntityTypes1_19.PUFFERFISH).jsonName();
        this.mapEntityTypeWithData(EntityTypes1_19.CHEST_BOAT, EntityTypes1_19.BOAT);
        this.mapEntityTypeWithData(EntityTypes1_19.WARDEN, EntityTypes1_19.IRON_GOLEM).jsonName();
        this.mapEntityTypeWithData(EntityTypes1_19.ALLAY, EntityTypes1_19.VEX).jsonName();
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_19.getTypeFromId(n);
    }
}


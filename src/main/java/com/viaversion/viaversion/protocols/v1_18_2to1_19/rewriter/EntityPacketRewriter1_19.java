/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_18_2to1_19.rewriter;

import com.google.common.collect.Maps;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.data.ParticleMappings;
import com.viaversion.viaversion.api.data.entity.DimensionData;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.Particle;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_19;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_18;
import com.viaversion.viaversion.api.type.types.version.Types1_19;
import com.viaversion.viaversion.data.entity.DimensionDataImpl;
import com.viaversion.viaversion.protocols.v1_17_1to1_18.packet.ClientboundPackets1_18;
import com.viaversion.viaversion.protocols.v1_18_2to1_19.Protocol1_18_2To1_19;
import com.viaversion.viaversion.protocols.v1_18_2to1_19.packet.ClientboundPackets1_19;
import com.viaversion.viaversion.protocols.v1_18_2to1_19.storage.DimensionRegistryStorage;
import com.viaversion.viaversion.rewriter.EntityRewriter;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.Pair;
import com.viaversion.viaversion.util.TagUtil;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class EntityPacketRewriter1_19
extends EntityRewriter<ClientboundPackets1_18, Protocol1_18_2To1_19> {
    public EntityPacketRewriter1_19(Protocol1_18_2To1_19 protocol1_18_2To1_19) {
        super(protocol1_18_2To1_19);
    }

    @Override
    public void registerPackets() {
        this.registerTracker(ClientboundPackets1_18.ADD_PLAYER, EntityTypes1_19.PLAYER);
        this.registerSetEntityData(ClientboundPackets1_18.SET_ENTITY_DATA, Types1_18.ENTITY_DATA_LIST, Types1_19.ENTITY_DATA_LIST);
        ((Protocol1_18_2To1_19)this.protocol).replaceClientbound(ClientboundPackets1_18.ADD_ENTITY, new PacketHandlers(){

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
                    byte by = packetWrapper.get(Types.BYTE, 1);
                    packetWrapper.write(Types.BYTE, by);
                });
                this.map(Types.INT, Types.VAR_INT);
                this.handler(EntityPacketRewriter1_19.this.trackerHandler());
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    EntityType entityType = EntityPacketRewriter1_19.this.tracker(packetWrapper.user()).entityType(n);
                    if (entityType == EntityTypes1_19.FALLING_BLOCK) {
                        packetWrapper.set(Types.VAR_INT, 2, ((Protocol1_18_2To1_19)EntityPacketRewriter1_19.this.protocol).getMappingData().getNewBlockStateId(packetWrapper.get(Types.VAR_INT, 2)));
                    }
                });
            }
        });
        ((Protocol1_18_2To1_19)this.protocol).registerClientbound(ClientboundPackets1_18.ADD_PAINTING, ClientboundPackets1_19.ADD_ENTITY, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.UUID);
                this.handler(packetWrapper -> {
                    packetWrapper.write(Types.VAR_INT, EntityTypes1_19.PAINTING.getId());
                    int n = packetWrapper.read(Types.VAR_INT);
                    BlockPosition blockPosition = packetWrapper.read(Types.BLOCK_POSITION1_14);
                    byte by = packetWrapper.read(Types.BYTE);
                    packetWrapper.write(Types.DOUBLE, (double)blockPosition.x() + 0.5);
                    packetWrapper.write(Types.DOUBLE, (double)blockPosition.y() + 0.5);
                    packetWrapper.write(Types.DOUBLE, (double)blockPosition.z() + 0.5);
                    packetWrapper.write(Types.BYTE, (byte)0);
                    packetWrapper.write(Types.BYTE, (byte)0);
                    packetWrapper.write(Types.BYTE, (byte)0);
                    packetWrapper.write(Types.VAR_INT, EntityPacketRewriter1_19.this.to3dId(by));
                    packetWrapper.write(Types.SHORT, (short)0);
                    packetWrapper.write(Types.SHORT, (short)0);
                    packetWrapper.write(Types.SHORT, (short)0);
                    packetWrapper.send(Protocol1_18_2To1_19.class);
                    packetWrapper.cancel();
                    PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundPackets1_19.SET_ENTITY_DATA);
                    packetWrapper2.write(Types.VAR_INT, packetWrapper.get(Types.VAR_INT, 0));
                    ArrayList<EntityData> arrayList = new ArrayList<EntityData>();
                    arrayList.add(new EntityData(8, Types1_19.ENTITY_DATA_TYPES.paintingVariantType, ((Protocol1_18_2To1_19)EntityPacketRewriter1_19.this.protocol).getMappingData().getPaintingMappings().getNewIdOrDefault(n, 0)));
                    packetWrapper2.write(Types1_19.ENTITY_DATA_LIST, arrayList);
                    packetWrapper2.send(Protocol1_18_2To1_19.class);
                });
            }
        });
        ((Protocol1_18_2To1_19)this.protocol).registerClientbound(ClientboundPackets1_18.ADD_MOB, ClientboundPackets1_19.ADD_ENTITY, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.UUID);
                this.map(Types.VAR_INT);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.handler(packetWrapper -> {
                    byte by = packetWrapper.read(Types.BYTE);
                    byte by2 = packetWrapper.read(Types.BYTE);
                    packetWrapper.write(Types.BYTE, by2);
                    packetWrapper.write(Types.BYTE, by);
                });
                this.map(Types.BYTE);
                this.create(Types.VAR_INT, 0);
                this.map(Types.SHORT);
                this.map(Types.SHORT);
                this.map(Types.SHORT);
                this.handler(EntityPacketRewriter1_19.this.trackerHandler());
            }
        });
        ((Protocol1_18_2To1_19)this.protocol).registerClientbound(ClientboundPackets1_18.UPDATE_MOB_EFFECT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.map(Types.BYTE);
                this.map(Types.VAR_INT);
                this.map(Types.BYTE);
                this.create(Types.OPTIONAL_NAMED_COMPOUND_TAG, null);
            }
        });
        ((Protocol1_18_2To1_19)this.protocol).registerClientbound(ClientboundPackets1_18.LOGIN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.BOOLEAN);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.STRING_ARRAY);
                this.map(Types.NAMED_COMPOUND_TAG);
                this.handler(packetWrapper -> {
                    CompoundTag compoundTag = packetWrapper.get(Types.NAMED_COMPOUND_TAG, 0);
                    compoundTag.put("minecraft:chat_type", ((Protocol1_18_2To1_19)EntityPacketRewriter1_19.this.protocol).getMappingData().chatRegistry());
                    ListTag<CompoundTag> listTag = TagUtil.getRegistryEntries(compoundTag, "dimension_type");
                    HashMap<String, DimensionData> hashMap = new HashMap<String, DimensionData>(listTag.size());
                    HashMap<CompoundTag, String> hashMap2 = new HashMap<CompoundTag, String>(listTag.size());
                    for (CompoundTag compoundTag2 : listTag) {
                        NumberTag numberTag = compoundTag2.getNumberTag("id");
                        CompoundTag compoundTag3 = compoundTag2.getCompoundTag("element");
                        String string = compoundTag2.getStringTag("name").getValue();
                        EntityPacketRewriter1_19.this.addMonsterSpawnData(compoundTag3);
                        hashMap.put(Key.stripMinecraftNamespace(string), new DimensionDataImpl(numberTag.asInt(), compoundTag3));
                        hashMap2.put(compoundTag3.copy(), string);
                    }
                    EntityPacketRewriter1_19.this.tracker(packetWrapper.user()).setDimensions(hashMap);
                    DimensionRegistryStorage dimensionRegistryStorage = packetWrapper.user().get(DimensionRegistryStorage.class);
                    dimensionRegistryStorage.setDimensions(hashMap2);
                    EntityPacketRewriter1_19.this.writeDimensionKey(packetWrapper, dimensionRegistryStorage);
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
                this.create(Types.OPTIONAL_GLOBAL_POSITION, null);
                this.handler(EntityPacketRewriter1_19.this.playerTrackerHandler());
                this.handler(EntityPacketRewriter1_19.this.worldDataTrackerHandlerByKey());
                this.handler(EntityPacketRewriter1_19.this.biomeSizeTracker());
                this.handler(packetWrapper -> {
                    PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundPackets1_19.SET_DISPLAY_CHAT_PREVIEW);
                    packetWrapper2.write(Types.BOOLEAN, false);
                    packetWrapper2.scheduleSend(Protocol1_18_2To1_19.class);
                });
            }
        });
        ((Protocol1_18_2To1_19)this.protocol).registerClientbound(ClientboundPackets1_18.RESPAWN, new PacketHandlers(){

            @Override
            public void register() {
                this.handler(packetWrapper -> EntityPacketRewriter1_19.this.writeDimensionKey(packetWrapper, packetWrapper.user().get(DimensionRegistryStorage.class)));
                this.map(Types.STRING);
                this.map(Types.LONG);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.BYTE);
                this.map(Types.BOOLEAN);
                this.map(Types.BOOLEAN);
                this.map(Types.BOOLEAN);
                this.create(Types.OPTIONAL_GLOBAL_POSITION, null);
                this.handler(EntityPacketRewriter1_19.this.worldDataTrackerHandlerByKey());
            }
        });
    }

    private void writeDimensionKey(PacketWrapper packetWrapper, DimensionRegistryStorage dimensionRegistryStorage) {
        CompoundTag compoundTag = packetWrapper.read(Types.NAMED_COMPOUND_TAG);
        this.addMonsterSpawnData(compoundTag);
        String string = dimensionRegistryStorage.dimensionKey(compoundTag);
        if (string == null) {
            if (Via.getConfig().logOtherConversionWarnings()) {
                ((Protocol1_18_2To1_19)this.protocol).getLogger().warning("The server tried to send dimension data from a dimension the client wasn't told about on join. Plugins and mods have to make sure they are not creating new dimension types while players are online, and proxies need to make sure they don't scramble dimension data. Received dimension: " + String.valueOf(compoundTag) + ". Known dimensions: " + String.valueOf(dimensionRegistryStorage.dimensions()));
            }
            string = (String)((Map.Entry)dimensionRegistryStorage.dimensions().entrySet().stream().map(entry -> new Pair((Map.Entry)entry, Maps.difference(compoundTag.getValue(), ((CompoundTag)entry.getKey()).getValue()).entriesInCommon())).filter(pair -> ((Map)pair.value()).containsKey("min_y") && ((Map)pair.value()).containsKey("height")).max(Comparator.comparingInt(pair -> ((Map)pair.value()).size())).orElseThrow(() -> new IllegalArgumentException("Dimension not found in registry data from join packet: " + String.valueOf(compoundTag))).key()).getValue();
        }
        packetWrapper.write(Types.STRING, string);
    }

    private int to3dId(int n) {
        return switch (n) {
            case -1 -> 1;
            case 2 -> 2;
            case 0 -> 3;
            case 1 -> 4;
            case 3 -> 5;
            default -> throw new IllegalArgumentException("Unknown 2d id: " + n);
        };
    }

    private void addMonsterSpawnData(CompoundTag compoundTag) {
        compoundTag.put("monster_spawn_block_light_limit", new IntTag(0));
        compoundTag.put("monster_spawn_light_level", new IntTag(11));
    }

    @Override
    protected void registerRewrites() {
        this.filter().mapDataType(Types1_19.ENTITY_DATA_TYPES::byId);
        this.filter().dataType(Types1_19.ENTITY_DATA_TYPES.particleType).handler((entityDataHandlerEvent, entityData) -> {
            Particle particle = (Particle)entityData.getValue();
            ParticleMappings particleMappings = ((Protocol1_18_2To1_19)this.protocol).getMappingData().getParticleMappings();
            if (particle.id() == particleMappings.id("vibration")) {
                particle.getArguments().remove(0);
                String string = Key.stripMinecraftNamespace((String)particle.getArgument(0).getValue());
                if (string.equals("entity")) {
                    particle.getArguments().add(2, new Particle.ParticleData<Float>(Types.FLOAT, Float.valueOf(0.0f)));
                }
            }
            ((ParticleRewriter)((Protocol1_18_2To1_19)this.protocol).getParticleRewriter()).rewriteParticle(entityDataHandlerEvent.user(), particle);
        });
        this.registerEntityDataTypeHandler(Types1_19.ENTITY_DATA_TYPES.itemType, Types1_19.ENTITY_DATA_TYPES.optionalBlockStateType, null);
        this.registerBlockStateHandler(EntityTypes1_19.ABSTRACT_MINECART, 11);
        this.filter().type(EntityTypes1_19.CAT).index(19).mapDataType(n -> Types1_19.ENTITY_DATA_TYPES.catVariantType);
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_19.getTypeFromId(n);
    }
}


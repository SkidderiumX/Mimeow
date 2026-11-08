/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_16_2to1_16_1.rewriter;

import com.google.common.collect.Sets;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.ViaBackwards;
import com.viaversion.viabackwards.api.rewriters.EntityRewriter;
import com.viaversion.viabackwards.protocol.v1_16_2to1_16_1.Protocol1_16_2To1_16_1;
import com.viaversion.viabackwards.protocol.v1_16_2to1_16_1.storage.BiomeStorage;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_16_2;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_16;
import com.viaversion.viaversion.protocols.v1_15_2to1_16.data.DimensionRegistries1_16;
import com.viaversion.viaversion.protocols.v1_16_1to1_16_2.packet.ClientboundPackets1_16_2;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.TagUtil;
import java.util.Set;

public class EntityPacketRewriter1_16_2
extends EntityRewriter<ClientboundPackets1_16_2, Protocol1_16_2To1_16_1> {
    private final Set<String> oldDimensions = Sets.newHashSet("minecraft:overworld", "minecraft:the_nether", "minecraft:the_end");
    private boolean warned;

    public EntityPacketRewriter1_16_2(Protocol1_16_2To1_16_1 protocol1_16_2To1_16_1) {
        super(protocol1_16_2To1_16_1);
    }

    @Override
    protected void registerPackets() {
        this.registerTracker(ClientboundPackets1_16_2.ADD_EXPERIENCE_ORB, EntityTypes1_16_2.EXPERIENCE_ORB);
        this.registerTracker(ClientboundPackets1_16_2.ADD_PAINTING, EntityTypes1_16_2.PAINTING);
        this.registerTracker(ClientboundPackets1_16_2.ADD_PLAYER, EntityTypes1_16_2.PLAYER);
        this.registerSetEntityData(ClientboundPackets1_16_2.SET_ENTITY_DATA, Types1_16.ENTITY_DATA_LIST);
        ((Protocol1_16_2To1_16_1)this.protocol).registerClientbound(ClientboundPackets1_16_2.LOGIN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    boolean bl = packetWrapper.read(Types.BOOLEAN);
                    short s = packetWrapper.read(Types.BYTE).byteValue();
                    if (bl) {
                        s = (short)(s | 8);
                    }
                    packetWrapper.write(Types.UNSIGNED_BYTE, s);
                });
                this.map(Types.BYTE);
                this.map(Types.STRING_ARRAY);
                this.handler(packetWrapper -> {
                    Tag tag;
                    CompoundTag compoundTag = packetWrapper.read(Types.NAMED_COMPOUND_TAG);
                    if (packetWrapper.user().getProtocolInfo().protocolVersion().olderThanOrEqualTo(ProtocolVersion.v1_15_2)) {
                        tag = TagUtil.getRegistryEntries(compoundTag, "worldgen/biome");
                        BiomeStorage biomeStorage = packetWrapper.user().get(BiomeStorage.class);
                        biomeStorage.clear();
                        for (CompoundTag compoundTag2 : tag) {
                            StringTag stringTag = compoundTag2.getStringTag("name");
                            NumberTag numberTag = compoundTag2.getNumberTag("id");
                            biomeStorage.addBiome(stringTag.getValue(), numberTag.asInt());
                        }
                    } else if (!EntityPacketRewriter1_16_2.this.warned && !ViaBackwards.getConfig().suppressEmulationWarnings()) {
                        EntityPacketRewriter1_16_2.this.warned = true;
                        ((Protocol1_16_2To1_16_1)EntityPacketRewriter1_16_2.this.protocol).getLogger().warning("1.16 and 1.16.1 clients are only partially supported and may have wrong biomes displayed.");
                    }
                    packetWrapper.write(Types.NAMED_COMPOUND_TAG, DimensionRegistries1_16.getDimensionsTag());
                    tag = packetWrapper.read(Types.NAMED_COMPOUND_TAG);
                    packetWrapper.write(Types.STRING, EntityPacketRewriter1_16_2.this.getDimensionFromData((CompoundTag)tag));
                });
                this.map(Types.STRING);
                this.handler(packetWrapper -> {
                    String string = packetWrapper.get(Types.STRING, 1);
                    EntityPacketRewriter1_16_2.this.trackWorld(packetWrapper.user(), string);
                });
                this.map(Types.LONG);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.read(Types.VAR_INT);
                    packetWrapper.write(Types.UNSIGNED_BYTE, (short)Math.min(n, 255));
                });
                this.handler(EntityPacketRewriter1_16_2.this.playerTrackerHandler());
            }
        });
        ((Protocol1_16_2To1_16_1)this.protocol).registerClientbound(ClientboundPackets1_16_2.RESPAWN, packetWrapper -> {
            CompoundTag compoundTag = packetWrapper.read(Types.NAMED_COMPOUND_TAG);
            packetWrapper.write(Types.STRING, this.getDimensionFromData(compoundTag));
            String string = packetWrapper.passthrough(Types.STRING);
            this.trackWorld(packetWrapper.user(), string);
        });
    }

    private String getDimensionFromData(CompoundTag compoundTag) {
        StringTag stringTag = compoundTag.getStringTag("effects");
        return stringTag != null && this.oldDimensions.contains(Key.namespaced(stringTag.getValue())) ? stringTag.getValue() : "minecraft:overworld";
    }

    @Override
    protected void registerRewrites() {
        this.registerEntityDataTypeHandler(Types1_16.ENTITY_DATA_TYPES.itemType, null, Types1_16.ENTITY_DATA_TYPES.optionalBlockStateType, Types1_16.ENTITY_DATA_TYPES.particleType, Types1_16.ENTITY_DATA_TYPES.componentType, Types1_16.ENTITY_DATA_TYPES.optionalComponentType);
        this.filter().type(EntityTypes1_16_2.ABSTRACT_PIGLIN).index(15).toIndex(16);
        this.filter().type(EntityTypes1_16_2.ABSTRACT_PIGLIN).index(16).toIndex(15);
    }

    @Override
    public void onMappingDataLoaded() {
        super.onMappingDataLoaded();
        this.mapEntityTypeWithData(EntityTypes1_16_2.PIGLIN_BRUTE, EntityTypes1_16_2.PIGLIN).jsonName();
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_16_2.getTypeFromId(n);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_4to1_21_2;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.data.BackwardsMappingData;
import com.viaversion.viabackwards.api.rewriters.BackwardsRegistryRewriter;
import com.viaversion.viabackwards.api.rewriters.text.JsonNBTComponentRewriter;
import com.viaversion.viabackwards.protocol.v1_21_4to1_21_2.rewriter.BlockItemPacketRewriter1_21_4;
import com.viaversion.viabackwards.protocol.v1_21_4to1_21_2.rewriter.ComponentRewriter1_21_4;
import com.viaversion.viabackwards.protocol.v1_21_4to1_21_2.rewriter.EntityPacketRewriter1_21_4;
import com.viaversion.viabackwards.protocol.v1_21_4to1_21_2.rewriter.ParticleRewriter1_21_4;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.Particle;
import com.viaversion.viaversion.api.minecraft.RegistryEntry;
import com.viaversion.viaversion.api.minecraft.RegistryType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_4;
import com.viaversion.viaversion.api.protocol.packet.provider.PacketTypesProvider;
import com.viaversion.viaversion.api.protocol.packet.provider.SimplePacketTypesProvider;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_20_2;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.api.type.types.version.VersionedTypesHolder;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundConfigurationPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundConfigurationPackets1_21;
import com.viaversion.viaversion.protocols.v1_21_2to1_21_4.Protocol1_21_2To1_21_4;
import com.viaversion.viaversion.protocols.v1_21_2to1_21_4.packet.ServerboundPacket1_21_4;
import com.viaversion.viaversion.protocols.v1_21_2to1_21_4.packet.ServerboundPackets1_21_4;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPacket1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPackets1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ServerboundPacket1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ServerboundPackets1_21_2;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.RecipeDisplayRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;
import com.viaversion.viaversion.util.ArrayUtil;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.ProtocolUtil;
import java.util.BitSet;

public class Protocol1_21_4To1_21_2
extends BackwardsProtocol<ClientboundPacket1_21_2, ClientboundPacket1_21_2, ServerboundPacket1_21_4, ServerboundPacket1_21_2> {
    public static final BackwardsMappingData MAPPINGS = new BackwardsMappingData("1.21.4", "1.21.2", Protocol1_21_2To1_21_4.class);
    private final EntityPacketRewriter1_21_4 entityRewriter = new EntityPacketRewriter1_21_4(this);
    private final BlockItemPacketRewriter1_21_4 itemRewriter = new BlockItemPacketRewriter1_21_4(this);
    private final ParticleRewriter<ClientboundPacket1_21_2> particleRewriter = new ParticleRewriter1_21_4(this);
    private final JsonNBTComponentRewriter<ClientboundPacket1_21_2> translatableRewriter = new ComponentRewriter1_21_4(this);
    private final TagRewriter<ClientboundPacket1_21_2> tagRewriter = new TagRewriter<ClientboundPacket1_21_2>(this);
    private final RecipeDisplayRewriter<ClientboundPacket1_21_2> recipeRewriter = new RecipeDisplayRewriter<ClientboundPacket1_21_2>(this);
    private final BlockRewriter<ClientboundPacket1_21_2> blockRewriter = BlockRewriter.for1_20_2(this, ChunkType1_20_2::new);
    private final BackwardsRegistryRewriter registryDataRewriter = new BackwardsRegistryRewriter(this){

        @Override
        public RegistryEntry[] handle(UserConnection userConnection, String string, RegistryEntry[] registryEntryArray) {
            block4: {
                String string2;
                block3: {
                    string2 = Key.stripMinecraftNamespace(string);
                    if (!string2.equals("worldgen/biome")) break block3;
                    for (RegistryEntry registryEntry : registryEntryArray) {
                        CompoundTag compoundTag;
                        ListTag<CompoundTag> listTag;
                        if (registryEntry.tag() == null || (listTag = (compoundTag = ((CompoundTag)registryEntry.tag()).getCompoundTag("effects")).getListTag("music", CompoundTag.class)) == null) continue;
                        if (listTag.isEmpty()) {
                            compoundTag.remove("music");
                            continue;
                        }
                        CompoundTag compoundTag2 = listTag.get(0);
                        compoundTag.put("music", compoundTag2.get("data"));
                    }
                    break block4;
                }
                if (!string2.equals("trim_material")) break block4;
                for (RegistryEntry registryEntry : registryEntryArray) {
                    if (registryEntry.tag() == null) continue;
                    CompoundTag compoundTag = (CompoundTag)registryEntry.tag();
                    compoundTag.putFloat("item_model_index", Protocol1_21_4To1_21_2.this.itemModelIndex(registryEntry.key()));
                }
            }
            return super.handle(userConnection, string, registryEntryArray);
        }
    };

    public Protocol1_21_4To1_21_2() {
        super(ClientboundPacket1_21_2.class, ClientboundPacket1_21_2.class, ServerboundPacket1_21_4.class, ServerboundPacket1_21_2.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        this.replaceClientbound(ClientboundPackets1_21_2.LEVEL_PARTICLES, packetWrapper -> {
            packetWrapper.passthrough(Types.BOOLEAN);
            packetWrapper.read(Types.BOOLEAN);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.FLOAT);
            packetWrapper.passthrough(Types.FLOAT);
            packetWrapper.passthrough(Types.FLOAT);
            packetWrapper.passthrough(Types.FLOAT);
            packetWrapper.passthrough(Types.INT);
            Particle particle = packetWrapper.passthroughAndMap(VersionedTypes.V1_21_4.particle(), VersionedTypes.V1_21_2.particle());
            this.particleRewriter.rewriteParticle(packetWrapper.user(), particle);
        });
        this.registerClientbound(ClientboundConfigurationPackets1_21.UPDATE_ENABLED_FEATURES, packetWrapper -> {
            String[] stringArray = packetWrapper.read(Types.STRING_ARRAY);
            packetWrapper.write(Types.STRING_ARRAY, ArrayUtil.add(stringArray, "winter_drop"));
        });
        this.replaceClientbound(ClientboundPackets1_21_2.PLAYER_INFO_UPDATE, packetWrapper -> {
            int n;
            BitSet bitSet = packetWrapper.read(Types.PROFILE_ACTIONS_ENUM1_21_4);
            BitSet bitSet2 = new BitSet(7);
            for (n = 0; n < 7; ++n) {
                if (!bitSet.get(n)) continue;
                bitSet2.set(n);
            }
            packetWrapper.write(Types.PROFILE_ACTIONS_ENUM1_21_2, bitSet2);
            n = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n; ++i) {
                packetWrapper.passthrough(Types.UUID);
                if (bitSet.get(0)) {
                    packetWrapper.passthrough(Types.STRING);
                    packetWrapper.passthrough(Types.PROFILE_PROPERTY_ARRAY);
                }
                if (bitSet.get(1) && packetWrapper.passthrough(Types.BOOLEAN).booleanValue()) {
                    packetWrapper.passthrough(Types.UUID);
                    packetWrapper.passthrough(Types.PROFILE_KEY);
                }
                if (bitSet.get(2)) {
                    packetWrapper.passthrough(Types.VAR_INT);
                }
                if (bitSet.get(3)) {
                    packetWrapper.passthrough(Types.BOOLEAN);
                }
                if (bitSet.get(4)) {
                    packetWrapper.passthrough(Types.VAR_INT);
                }
                if (bitSet.get(5)) {
                    this.translatableRewriter.processTag(packetWrapper.user(), packetWrapper.passthrough(Types.TRUSTED_OPTIONAL_TAG));
                }
                if (bitSet.get(6)) {
                    packetWrapper.passthrough(Types.VAR_INT);
                }
                if (!bitSet.get(7)) continue;
                packetWrapper.read(Types.BOOLEAN);
            }
        });
    }

    @Override
    protected void onMappingDataLoaded() {
        super.onMappingDataLoaded();
        this.tagRewriter.addEmptyTags(RegistryType.ITEM, "minecraft:tall_flowers", "minecraft:flowers");
        this.tagRewriter.addEmptyTag(RegistryType.BLOCK, "minecraft:tall_flowers");
    }

    @Override
    public void init(UserConnection userConnection) {
        this.addEntityTracker(userConnection, new EntityTrackerBase(userConnection, EntityTypes1_21_4.PLAYER));
    }

    @Override
    public BackwardsMappingData getMappingData() {
        return MAPPINGS;
    }

    public EntityPacketRewriter1_21_4 getEntityRewriter() {
        return this.entityRewriter;
    }

    public BlockItemPacketRewriter1_21_4 getItemRewriter() {
        return this.itemRewriter;
    }

    @Override
    public BlockRewriter<ClientboundPacket1_21_2> getBlockRewriter() {
        return this.blockRewriter;
    }

    @Override
    public ParticleRewriter<ClientboundPacket1_21_2> getParticleRewriter() {
        return this.particleRewriter;
    }

    @Override
    public JsonNBTComponentRewriter<ClientboundPacket1_21_2> getComponentRewriter() {
        return this.translatableRewriter;
    }

    @Override
    public TagRewriter<ClientboundPacket1_21_2> getTagRewriter() {
        return this.tagRewriter;
    }

    @Override
    public RecipeDisplayRewriter<ClientboundPacket1_21_2> getRecipeRewriter() {
        return this.recipeRewriter;
    }

    @Override
    public BackwardsRegistryRewriter getRegistryDataRewriter() {
        return this.registryDataRewriter;
    }

    @Override
    public VersionedTypesHolder types() {
        return VersionedTypes.V1_21_4;
    }

    @Override
    public VersionedTypesHolder mappedTypes() {
        return VersionedTypes.V1_21_2;
    }

    @Override
    protected PacketTypesProvider<ClientboundPacket1_21_2, ClientboundPacket1_21_2, ServerboundPacket1_21_4, ServerboundPacket1_21_2> createPacketTypesProvider() {
        return new SimplePacketTypesProvider<ClientboundPacket1_21_2, ClientboundPacket1_21_2, ServerboundPacket1_21_4, ServerboundPacket1_21_2>(ProtocolUtil.packetTypeMap(this.unmappedClientboundPacketType, ClientboundPackets1_21_2.class, ClientboundConfigurationPackets1_21.class), ProtocolUtil.packetTypeMap(this.mappedClientboundPacketType, ClientboundPackets1_21_2.class, ClientboundConfigurationPackets1_21.class), ProtocolUtil.packetTypeMap(this.mappedServerboundPacketType, ServerboundPackets1_21_4.class, ServerboundConfigurationPackets1_20_5.class), ProtocolUtil.packetTypeMap(this.unmappedServerboundPacketType, ServerboundPackets1_21_2.class, ServerboundConfigurationPackets1_20_5.class));
    }

    private float itemModelIndex(String string) {
        return switch (Key.stripNamespace(string)) {
            case "amethyst" -> 1.0f;
            case "copper" -> 0.5f;
            case "diamond" -> 0.8f;
            case "emerald" -> 0.7f;
            case "gold" -> 0.6f;
            case "iron" -> 0.2f;
            case "lapis" -> 0.9f;
            case "netherite" -> 0.3f;
            case "quartz" -> 0.1f;
            case "redstone" -> 0.4f;
            default -> 1.0f;
        };
    }
}


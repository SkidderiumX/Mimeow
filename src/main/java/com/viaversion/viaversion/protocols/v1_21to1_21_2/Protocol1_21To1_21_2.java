/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21to1_21_2;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.MappingData;
import com.viaversion.viaversion.api.data.MappingDataBase;
import com.viaversion.viaversion.api.minecraft.RegistryEntry;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_2;
import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.protocol.packet.provider.PacketTypesProvider;
import com.viaversion.viaversion.api.protocol.packet.provider.SimplePacketTypesProvider;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_20_2;
import com.viaversion.viaversion.api.type.types.misc.ParticleType;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.api.type.types.version.VersionedTypesHolder;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectOpenHashMap;
import com.viaversion.viaversion.protocols.base.ClientboundLoginPackets;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundConfigurationPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundPacket1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundConfigurationPackets1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundPacket1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundPackets1_21;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPacket1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPackets1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ServerboundPacket1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ServerboundPackets1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.rewriter.BlockItemPacketRewriter1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.rewriter.ComponentRewriter1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.rewriter.EntityPacketRewriter1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.rewriter.ParticleRewriter1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.storage.BundleStateTracker;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.storage.ChunkLoadTracker;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.storage.EntityTracker1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.storage.GroundFlagTracker;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.storage.LastExplosionPowerStorage;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.storage.PlayerPositionStorage;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.storage.TeleportAckCancelStorage;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.RegistryDataRewriter;
import com.viaversion.viaversion.rewriter.SoundRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;
import com.viaversion.viaversion.util.ProtocolUtil;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;

public class Protocol1_21To1_21_2
extends AbstractProtocol<ClientboundPacket1_21, ClientboundPacket1_21_2, ServerboundPacket1_20_5, ServerboundPacket1_21_2> {
    public static final MappingData MAPPINGS = new MappingDataBase("1.21", "1.21.2");
    private final EntityPacketRewriter1_21_2 entityRewriter = new EntityPacketRewriter1_21_2(this);
    private final BlockItemPacketRewriter1_21_2 itemRewriter = new BlockItemPacketRewriter1_21_2(this);
    private final ParticleRewriter1_21_2 particleRewriter = new ParticleRewriter1_21_2(this);
    private final TagRewriter<ClientboundPacket1_21> tagRewriter = new TagRewriter<ClientboundPacket1_21>(this);
    private final ComponentRewriter1_21_2 componentRewriter = new ComponentRewriter1_21_2(this);
    private final SoundRewriter<ClientboundPacket1_21> soundRewriter = new SoundRewriter<ClientboundPacket1_21>(this);
    private final BlockRewriter<ClientboundPacket1_21> blockRewriter = BlockRewriter.for1_20_2(this, ChunkType1_20_2::new);
    private final RegistryDataRewriter registryDataRewriter = this.registryDataRewriter();

    public Protocol1_21To1_21_2() {
        super(ClientboundPacket1_21.class, ClientboundPacket1_21_2.class, ServerboundPacket1_20_5.class, ServerboundPacket1_21_2.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        this.registerServerbound(ServerboundPackets1_21_2.CLIENT_INFORMATION, this::clientInformation);
        this.registerServerbound(ServerboundConfigurationPackets1_20_5.CLIENT_INFORMATION, this::clientInformation);
        this.cancelServerbound(ServerboundPackets1_21_2.BUNDLE_ITEM_SELECTED);
        this.cancelServerbound(ServerboundPackets1_21_2.CLIENT_TICK_END);
        this.registerClientbound(State.LOGIN, ClientboundLoginPackets.LOGIN_FINISHED, (PacketWrapper packetWrapper) -> {
            packetWrapper.passthrough(Types.UUID);
            packetWrapper.passthrough(Types.STRING);
            packetWrapper.passthrough(Types.PROFILE_PROPERTY_ARRAY);
            packetWrapper.read(Types.BOOLEAN);
        });
        this.registerClientbound(ClientboundPackets1_21.SET_TIME, packetWrapper -> {
            packetWrapper.passthrough(Types.LONG);
            long l = packetWrapper.read(Types.LONG);
            boolean bl = true;
            if (l < 0L) {
                l = -l;
                bl = false;
            }
            packetWrapper.write(Types.LONG, l);
            packetWrapper.write(Types.BOOLEAN, bl);
        });
        this.replaceClientbound(ClientboundPackets1_21.PLAYER_INFO_UPDATE, packetWrapper -> {
            BitSet bitSet = packetWrapper.passthroughAndMap(Types.PROFILE_ACTIONS_ENUM1_19_3, Types.PROFILE_ACTIONS_ENUM1_21_2);
            if (!bitSet.get(5)) {
                return;
            }
            int n = packetWrapper.passthrough(Types.VAR_INT);
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
                this.componentRewriter.processTag(packetWrapper.user(), packetWrapper.passthrough(Types.TRUSTED_OPTIONAL_TAG));
            }
        });
        this.appendClientbound(ClientboundPackets1_21.UPDATE_ATTRIBUTES, packetWrapper -> {
            packetWrapper.resetReader();
            int n2 = packetWrapper.passthrough(Types.VAR_INT);
            EntityTracker1_21_2 entityTracker1_21_2 = (EntityTracker1_21_2)packetWrapper.user().getEntityTracker(Protocol1_21To1_21_2.class);
            if (n2 != entityTracker1_21_2.clientEntityId()) {
                return;
            }
            int n3 = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n3; ++i) {
                int n4 = packetWrapper.passthrough(Types.VAR_INT);
                if (n4 == 18) {
                    double d;
                    double d2 = packetWrapper.passthrough(Types.DOUBLE);
                    int n5 = packetWrapper.passthrough(Types.VAR_INT);
                    Int2ObjectOpenHashMap int2ObjectOpenHashMap = new Int2ObjectOpenHashMap();
                    for (int j = 0; j < n5; ++j) {
                        String string = packetWrapper.passthrough(Types.STRING);
                        d = packetWrapper.passthrough(Types.DOUBLE);
                        byte by = packetWrapper.passthrough(Types.BYTE);
                        int2ObjectOpenHashMap.computeIfAbsent((int)by, n -> new HashMap()).put(string, d);
                    }
                    double d3 = d2;
                    for (Double d4 : int2ObjectOpenHashMap.getOrDefault(0, Collections.emptyMap()).values()) {
                        d3 += d4.doubleValue();
                    }
                    d = d3;
                    for (Double d5 : int2ObjectOpenHashMap.getOrDefault(1, Collections.emptyMap()).values()) {
                        d += d3 * d5;
                    }
                    for (Double d5 : int2ObjectOpenHashMap.getOrDefault(2, Collections.emptyMap()).values()) {
                        d *= 1.0 + d5;
                    }
                    entityTracker1_21_2.setPlayerMaxHealthAttributeValue(Math.max(1.0, Math.min(1024.0, d)));
                    continue;
                }
                packetWrapper.passthrough(Types.DOUBLE);
                int n6 = packetWrapper.passthrough(Types.VAR_INT);
                for (int j = 0; j < n6; ++j) {
                    packetWrapper.passthrough(Types.STRING);
                    packetWrapper.passthrough(Types.DOUBLE);
                    packetWrapper.passthrough(Types.BYTE);
                }
            }
        });
        this.registerClientbound(ClientboundPackets1_21.BUNDLE_DELIMITER, packetWrapper -> packetWrapper.user().get(BundleStateTracker.class).toggleBundling());
        this.registerServerbound(ServerboundPackets1_21_2.PONG, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.INT);
            PlayerPositionStorage playerPositionStorage = packetWrapper.user().get(PlayerPositionStorage.class);
            if (playerPositionStorage != null && playerPositionStorage.checkPong(n)) {
                packetWrapper.cancel();
            }
        });
    }

    private void clientInformation(PacketWrapper packetWrapper) {
        packetWrapper.passthrough(Types.STRING);
        packetWrapper.passthrough(Types.BYTE);
        packetWrapper.passthrough(Types.VAR_INT);
        packetWrapper.passthrough(Types.BOOLEAN);
        packetWrapper.passthrough(Types.UNSIGNED_BYTE);
        packetWrapper.passthrough(Types.VAR_INT);
        packetWrapper.passthrough(Types.BOOLEAN);
        packetWrapper.passthrough(Types.BOOLEAN);
        packetWrapper.read(Types.VAR_INT);
    }

    @Override
    protected void onMappingDataLoaded() {
        EntityTypes1_21_2.initialize(this);
        ParticleType.Fillers.fill1_21_2(this);
        VersionedTypes.V1_21_2.structuredData.filler(this).add(StructuredDataKey.CUSTOM_DATA, StructuredDataKey.MAX_STACK_SIZE, StructuredDataKey.MAX_DAMAGE, StructuredDataKey.UNBREAKABLE1_20_5, StructuredDataKey.RARITY, StructuredDataKey.HIDE_TOOLTIP, StructuredDataKey.DAMAGE_RESISTANT1_21_2, StructuredDataKey.CUSTOM_NAME, StructuredDataKey.LORE, StructuredDataKey.ENCHANTMENTS1_20_5, StructuredDataKey.CAN_PLACE_ON1_20_5, StructuredDataKey.CAN_BREAK1_20_5, StructuredDataKey.CUSTOM_MODEL_DATA1_20_5, StructuredDataKey.HIDE_ADDITIONAL_TOOLTIP, StructuredDataKey.REPAIR_COST, StructuredDataKey.CREATIVE_SLOT_LOCK, StructuredDataKey.ENCHANTMENT_GLINT_OVERRIDE, StructuredDataKey.INTANGIBLE_PROJECTILE, StructuredDataKey.STORED_ENCHANTMENTS1_20_5, StructuredDataKey.DYED_COLOR1_20_5, StructuredDataKey.MAP_COLOR, StructuredDataKey.MAP_ID, StructuredDataKey.MAP_DECORATIONS, StructuredDataKey.MAP_POST_PROCESSING, StructuredDataKey.POTION_CONTENTS1_21_2, StructuredDataKey.SUSPICIOUS_STEW_EFFECTS, StructuredDataKey.WRITABLE_BOOK_CONTENT, StructuredDataKey.WRITTEN_BOOK_CONTENT, StructuredDataKey.TRIM1_21_2, StructuredDataKey.DEBUG_STICK_STATE, StructuredDataKey.ENTITY_DATA1_20_5, StructuredDataKey.BUCKET_ENTITY_DATA, StructuredDataKey.BLOCK_ENTITY_DATA1_20_5, StructuredDataKey.INSTRUMENT1_21_2, StructuredDataKey.RECIPES, StructuredDataKey.LODESTONE_TRACKER, StructuredDataKey.FIREWORK_EXPLOSION, StructuredDataKey.FIREWORKS, StructuredDataKey.PROFILE1_20_5, StructuredDataKey.NOTE_BLOCK_SOUND, StructuredDataKey.BANNER_PATTERNS, StructuredDataKey.BASE_COLOR, StructuredDataKey.POT_DECORATIONS, StructuredDataKey.BLOCK_STATE, StructuredDataKey.BEES1_20_5, StructuredDataKey.LOCK1_21_2, StructuredDataKey.CONTAINER_LOOT, StructuredDataKey.TOOL1_20_5, StructuredDataKey.ITEM_NAME, StructuredDataKey.OMINOUS_BOTTLE_AMPLIFIER, StructuredDataKey.FOOD1_21_2, StructuredDataKey.JUKEBOX_PLAYABLE1_21, StructuredDataKey.ATTRIBUTE_MODIFIERS1_21, StructuredDataKey.REPAIRABLE, StructuredDataKey.ENCHANTABLE, StructuredDataKey.CONSUMABLE1_21_2, StructuredDataKey.USE_COOLDOWN, StructuredDataKey.DAMAGE, StructuredDataKey.EQUIPPABLE1_21_2, StructuredDataKey.ITEM_MODEL, StructuredDataKey.GLIDER, StructuredDataKey.TOOLTIP_STYLE, StructuredDataKey.DEATH_PROTECTION);
        super.onMappingDataLoaded();
    }

    @Override
    public void init(UserConnection userConnection) {
        ProtocolVersion protocolVersion;
        this.addEntityTracker(userConnection, new EntityTracker1_21_2(userConnection));
        userConnection.put(new BundleStateTracker());
        userConnection.put(new GroundFlagTracker());
        userConnection.put(new TeleportAckCancelStorage());
        if (userConnection.getProtocolInfo().protocolVersion().newerThanOrEqualTo(ProtocolVersion.v1_21_9)) {
            userConnection.put(new LastExplosionPowerStorage());
        }
        if ((protocolVersion = userConnection.getProtocolInfo().protocolVersion()).olderThan(ProtocolVersion.v1_21_4)) {
            userConnection.put(new PlayerPositionStorage());
        }
        if (protocolVersion.equals(ProtocolVersion.v1_21_2)) {
            userConnection.put(new ChunkLoadTracker());
        }
    }

    @Override
    public MappingData getMappingData() {
        return MAPPINGS;
    }

    public EntityPacketRewriter1_21_2 getEntityRewriter() {
        return this.entityRewriter;
    }

    public BlockItemPacketRewriter1_21_2 getItemRewriter() {
        return this.itemRewriter;
    }

    @Override
    public BlockRewriter<ClientboundPacket1_21> getBlockRewriter() {
        return this.blockRewriter;
    }

    @Override
    public RegistryDataRewriter getRegistryDataRewriter() {
        return this.registryDataRewriter;
    }

    @Override
    public ParticleRewriter1_21_2 getParticleRewriter() {
        return this.particleRewriter;
    }

    @Override
    public TagRewriter<ClientboundPacket1_21> getTagRewriter() {
        return this.tagRewriter;
    }

    @Override
    public ComponentRewriter1_21_2 getComponentRewriter() {
        return this.componentRewriter;
    }

    public SoundRewriter<ClientboundPacket1_21> getSoundRewriter() {
        return this.soundRewriter;
    }

    @Override
    public VersionedTypesHolder types() {
        return VersionedTypes.V1_21;
    }

    @Override
    public VersionedTypesHolder mappedTypes() {
        return VersionedTypes.V1_21_2;
    }

    @Override
    protected PacketTypesProvider<ClientboundPacket1_21, ClientboundPacket1_21_2, ServerboundPacket1_20_5, ServerboundPacket1_21_2> createPacketTypesProvider() {
        return new SimplePacketTypesProvider<ClientboundPacket1_21, ClientboundPacket1_21_2, ServerboundPacket1_20_5, ServerboundPacket1_21_2>(ProtocolUtil.packetTypeMap(this.unmappedClientboundPacketType, ClientboundPackets1_21.class, ClientboundConfigurationPackets1_21.class), ProtocolUtil.packetTypeMap(this.mappedClientboundPacketType, ClientboundPackets1_21_2.class, ClientboundConfigurationPackets1_21.class), ProtocolUtil.packetTypeMap(this.mappedServerboundPacketType, ServerboundPackets1_20_5.class, ServerboundConfigurationPackets1_20_5.class), ProtocolUtil.packetTypeMap(this.unmappedServerboundPacketType, ServerboundPackets1_21_2.class, ServerboundConfigurationPackets1_20_5.class));
    }

    private RegistryDataRewriter registryDataRewriter() {
        CompoundTag compoundTag2 = new CompoundTag();
        compoundTag2.putString("scaling", "when_caused_by_living_non_player");
        compoundTag2.putString("message_id", "fall");
        compoundTag2.putFloat("exhaustion", 0.0f);
        CompoundTag compoundTag3 = new CompoundTag();
        compoundTag3.putString("scaling", "when_caused_by_living_non_player");
        compoundTag3.putString("message_id", "mace_smash");
        compoundTag3.putFloat("exhaustion", 0.1f);
        RegistryDataRewriter registryDataRewriter = new RegistryDataRewriter(this);
        registryDataRewriter.addEntries("damage_type", new RegistryEntry("minecraft:ender_pearl", compoundTag2), new RegistryEntry("minecraft:mace_smash", compoundTag3));
        registryDataRewriter.addEnchantmentEffectRewriter("damage_item", compoundTag -> compoundTag.putString("type", "change_item_damage"));
        return registryDataRewriter;
    }
}


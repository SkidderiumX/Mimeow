/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_20_5to1_21;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.RegistryType;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_20_5;
import com.viaversion.viaversion.api.minecraft.item.data.ChatType;
import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viaversion.api.protocol.packet.provider.PacketTypesProvider;
import com.viaversion.viaversion.api.protocol.packet.provider.SimplePacketTypesProvider;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_20_2;
import com.viaversion.viaversion.api.type.types.misc.ParticleType;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.api.type.types.version.VersionedTypesHolder;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ClientboundConfigurationPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ClientboundPacket1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ClientboundPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundConfigurationPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundPacket1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.data.AttributeModifierMappings1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.data.MappingData1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundConfigurationPackets1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundPacket1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundPackets1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.rewriter.BlockItemPacketRewriter1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.rewriter.ComponentRewriter1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.rewriter.EntityPacketRewriter1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.storage.EfficiencyAttributeStorage;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.storage.PlayerPositionStorage;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;
import com.viaversion.viaversion.rewriter.text.JsonNBTComponentRewriter;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.ProtocolUtil;
import com.viaversion.viaversion.util.UUIDUtil;
import java.util.Locale;
import java.util.UUID;

public class Protocol1_20_5To1_21
extends AbstractProtocol<ClientboundPacket1_20_5, ClientboundPacket1_21, ServerboundPacket1_20_5, ServerboundPacket1_20_5> {
    public static final MappingData1_21 MAPPINGS = new MappingData1_21();
    private final EntityPacketRewriter1_21 entityRewriter = new EntityPacketRewriter1_21(this);
    private final BlockItemPacketRewriter1_21 itemRewriter = new BlockItemPacketRewriter1_21(this);
    private final ParticleRewriter<ClientboundPacket1_20_5> particleRewriter = new ParticleRewriter<ClientboundPacket1_20_5>(this);
    private final TagRewriter<ClientboundPacket1_20_5> tagRewriter = new TagRewriter<ClientboundPacket1_20_5>(this);
    private final JsonNBTComponentRewriter<ClientboundPacket1_20_5> componentRewriter = new ComponentRewriter1_21(this);
    private final BlockRewriter<ClientboundPacket1_20_5> blockRewriter = BlockRewriter.for1_20_2(this, ChunkType1_20_2::new);

    public Protocol1_20_5To1_21() {
        super(ClientboundPacket1_20_5.class, ClientboundPacket1_21.class, ServerboundPacket1_20_5.class, ServerboundPacket1_20_5.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        this.replaceClientbound(ClientboundPackets1_20_5.DISGUISED_CHAT, packetWrapper -> {
            this.componentRewriter.processTag(packetWrapper.user(), packetWrapper.passthrough(Types.TRUSTED_TAG));
            int n = packetWrapper.read(Types.VAR_INT);
            packetWrapper.write(ChatType.TYPE, Holder.of(n));
        });
        this.replaceClientbound(ClientboundPackets1_20_5.PLAYER_CHAT, packetWrapper -> {
            int n;
            int n2;
            packetWrapper.passthrough(Types.UUID);
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.OPTIONAL_SIGNATURE_BYTES);
            packetWrapper.passthrough(Types.STRING);
            packetWrapper.passthrough(Types.LONG);
            packetWrapper.passthrough(Types.LONG);
            int n3 = packetWrapper.passthrough(Types.VAR_INT);
            for (n2 = 0; n2 < n3; ++n2) {
                n = packetWrapper.passthrough(Types.VAR_INT);
                if (n != 0) continue;
                packetWrapper.passthrough(Types.SIGNATURE_BYTES);
            }
            this.componentRewriter.processTag(packetWrapper.user(), packetWrapper.passthrough(Types.TRUSTED_OPTIONAL_TAG));
            n2 = packetWrapper.passthrough(Types.VAR_INT);
            if (n2 == 2) {
                packetWrapper.passthrough(Types.LONG_ARRAY_PRIMITIVE);
            }
            n = packetWrapper.read(Types.VAR_INT);
            packetWrapper.write(ChatType.TYPE, Holder.of(n));
            this.componentRewriter.processTag(packetWrapper.user(), packetWrapper.passthrough(Types.TRUSTED_TAG));
            this.componentRewriter.processTag(packetWrapper.user(), packetWrapper.passthrough(Types.TRUSTED_OPTIONAL_TAG));
        });
        this.registerClientbound(ClientboundPackets1_20_5.UPDATE_ATTRIBUTES, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            int n = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n; ++i) {
                int n2 = packetWrapper.read(Types.VAR_INT);
                packetWrapper.write(Types.VAR_INT, MAPPINGS.getNewAttributeId(n2));
                packetWrapper.passthrough(Types.DOUBLE);
                int n3 = packetWrapper.passthrough(Types.VAR_INT);
                for (int j = 0; j < n3; ++j) {
                    UUID uUID = packetWrapper.read(Types.UUID);
                    packetWrapper.write(Types.STRING, Protocol1_20_5To1_21.mapAttributeUUID(uUID, null));
                    packetWrapper.passthrough(Types.DOUBLE);
                    packetWrapper.passthrough(Types.BYTE);
                }
            }
        });
        this.registerClientbound(ClientboundPackets1_20_5.PROJECTILE_POWER, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            double d = packetWrapper.read(Types.DOUBLE);
            double d2 = packetWrapper.read(Types.DOUBLE);
            double d3 = packetWrapper.read(Types.DOUBLE);
            double d4 = Math.sqrt(d * d + d2 * d2 + d3 * d3);
            packetWrapper.write(Types.DOUBLE, d4);
        });
    }

    public static String mapAttributeUUID(UUID uUID, String string) {
        String string2 = AttributeModifierMappings1_21.uuidToId(uUID);
        if (string2 != null) {
            return string2;
        }
        if (string != null) {
            string2 = AttributeModifierMappings1_21.nameToId(string);
        }
        return string2 != null ? string2 : uUID.toString().toLowerCase(Locale.ROOT);
    }

    public static UUID mapAttributeId(String string) {
        UUID uUID = AttributeModifierMappings1_21.idToUuid(string);
        if (uUID != null) {
            return uUID;
        }
        uUID = UUIDUtil.parseUUID(Key.stripNamespace(string).toUpperCase(Locale.ROOT));
        return uUID != null ? uUID : UUIDUtil.randomUUID();
    }

    @Override
    protected void onMappingDataLoaded() {
        ParticleType.Fillers.fill1_20_5(this, this.mappedTypes().particle());
        VersionedTypes.V1_21.structuredData.filler(this).add((StructuredDataKey<?>)StructuredDataKey.CUSTOM_DATA).add((StructuredDataKey<?>)StructuredDataKey.MAX_STACK_SIZE).add((StructuredDataKey<?>)StructuredDataKey.MAX_DAMAGE).add((StructuredDataKey<?>)StructuredDataKey.DAMAGE).add((StructuredDataKey<?>)StructuredDataKey.UNBREAKABLE1_20_5).add((StructuredDataKey<?>)StructuredDataKey.RARITY).add((StructuredDataKey<?>)StructuredDataKey.HIDE_TOOLTIP).add((StructuredDataKey<?>)StructuredDataKey.FIRE_RESISTANT).add((StructuredDataKey<?>)StructuredDataKey.CUSTOM_NAME).add((StructuredDataKey<?>)StructuredDataKey.LORE).add((StructuredDataKey<?>)StructuredDataKey.ENCHANTMENTS1_20_5).add((StructuredDataKey<?>)StructuredDataKey.CAN_PLACE_ON1_20_5).add((StructuredDataKey<?>)StructuredDataKey.CAN_BREAK1_20_5).add((StructuredDataKey<?>)StructuredDataKey.CUSTOM_MODEL_DATA1_20_5).add((StructuredDataKey<?>)StructuredDataKey.HIDE_ADDITIONAL_TOOLTIP).add((StructuredDataKey<?>)StructuredDataKey.REPAIR_COST).add((StructuredDataKey<?>)StructuredDataKey.CREATIVE_SLOT_LOCK).add((StructuredDataKey<?>)StructuredDataKey.ENCHANTMENT_GLINT_OVERRIDE).add((StructuredDataKey<?>)StructuredDataKey.INTANGIBLE_PROJECTILE).add((StructuredDataKey<?>)StructuredDataKey.STORED_ENCHANTMENTS1_20_5).add((StructuredDataKey<?>)StructuredDataKey.DYED_COLOR1_20_5).add((StructuredDataKey<?>)StructuredDataKey.MAP_COLOR).add((StructuredDataKey<?>)StructuredDataKey.MAP_ID).add((StructuredDataKey<?>)StructuredDataKey.MAP_DECORATIONS).add((StructuredDataKey<?>)StructuredDataKey.MAP_POST_PROCESSING).add((StructuredDataKey<?>)StructuredDataKey.POTION_CONTENTS1_20_5).add((StructuredDataKey<?>)StructuredDataKey.SUSPICIOUS_STEW_EFFECTS).add((StructuredDataKey<?>)StructuredDataKey.WRITABLE_BOOK_CONTENT).add((StructuredDataKey<?>)StructuredDataKey.WRITTEN_BOOK_CONTENT).add((StructuredDataKey<?>)StructuredDataKey.TRIM1_20_5).add((StructuredDataKey<?>)StructuredDataKey.DEBUG_STICK_STATE).add((StructuredDataKey<?>)StructuredDataKey.ENTITY_DATA1_20_5).add((StructuredDataKey<?>)StructuredDataKey.BUCKET_ENTITY_DATA).add((StructuredDataKey<?>)StructuredDataKey.BLOCK_ENTITY_DATA1_20_5).add((StructuredDataKey<?>)StructuredDataKey.INSTRUMENT1_20_5).add((StructuredDataKey<?>)StructuredDataKey.RECIPES).add((StructuredDataKey<?>)StructuredDataKey.LODESTONE_TRACKER).add((StructuredDataKey<?>)StructuredDataKey.FIREWORK_EXPLOSION).add((StructuredDataKey<?>)StructuredDataKey.FIREWORKS).add((StructuredDataKey<?>)StructuredDataKey.PROFILE1_20_5).add((StructuredDataKey<?>)StructuredDataKey.NOTE_BLOCK_SOUND).add((StructuredDataKey<?>)StructuredDataKey.BANNER_PATTERNS).add((StructuredDataKey<?>)StructuredDataKey.BASE_COLOR).add((StructuredDataKey<?>)StructuredDataKey.POT_DECORATIONS).add((StructuredDataKey<?>)StructuredDataKey.BLOCK_STATE).add((StructuredDataKey<?>)StructuredDataKey.BEES1_20_5).add((StructuredDataKey<?>)StructuredDataKey.LOCK1_20_5).add((StructuredDataKey<?>)StructuredDataKey.CONTAINER_LOOT).add((StructuredDataKey<?>)StructuredDataKey.TOOL1_20_5).add((StructuredDataKey<?>)StructuredDataKey.ITEM_NAME).add((StructuredDataKey<?>)StructuredDataKey.OMINOUS_BOTTLE_AMPLIFIER).add((StructuredDataKey<?>)StructuredDataKey.FOOD1_21).add((StructuredDataKey<?>)StructuredDataKey.JUKEBOX_PLAYABLE1_21).add((StructuredDataKey<?>)StructuredDataKey.ATTRIBUTE_MODIFIERS1_21);
        super.onMappingDataLoaded();
        this.tagRewriter.addEmptyTags(RegistryType.BLOCK, "minecraft:blocks_wind_charge_explosions");
        this.tagRewriter.addEmptyTags(RegistryType.ENTITY, "minecraft:can_turn_in_boats", "minecraft:deflects_projectiles", "minecraft:immune_to_infested", "minecraft:immune_to_oozing", "minecraft:no_anger_from_wind_charge");
        this.tagRewriter.addTag(RegistryType.ENCHANTMENT, "minecraft:curse", 10, 41);
        this.tagRewriter.addEmptyTags(RegistryType.ENCHANTMENT, "double_trade_price", "in_enchanting_table", "non_treasure", "on_mob_spawn_equipment", "on_random_loot", "on_traded_equipment", "prevents_bee_spawns_when_mining", "prevents_decorated_pot_shattering", "prevents_ice_melting", "prevents_infested_spawns", "smelts_loot", "tooltip_order", "tradeable", "treasure", "exclusive_set/armor", "exclusive_set/boots", "exclusive_set/bow", "exclusive_set/crossbow", "exclusive_set/damage", "exclusive_set/mining", "exclusive_set/riptide");
    }

    @Override
    public void init(UserConnection userConnection) {
        this.addEntityTracker(userConnection, new EntityTrackerBase(userConnection, EntityTypes1_20_5.PLAYER));
        userConnection.put(new EfficiencyAttributeStorage());
        userConnection.put(new PlayerPositionStorage());
    }

    @Override
    public MappingData1_21 getMappingData() {
        return MAPPINGS;
    }

    public EntityPacketRewriter1_21 getEntityRewriter() {
        return this.entityRewriter;
    }

    public BlockItemPacketRewriter1_21 getItemRewriter() {
        return this.itemRewriter;
    }

    @Override
    public BlockRewriter<ClientboundPacket1_20_5> getBlockRewriter() {
        return this.blockRewriter;
    }

    @Override
    public ParticleRewriter<ClientboundPacket1_20_5> getParticleRewriter() {
        return this.particleRewriter;
    }

    @Override
    public TagRewriter<ClientboundPacket1_20_5> getTagRewriter() {
        return this.tagRewriter;
    }

    @Override
    public JsonNBTComponentRewriter<ClientboundPacket1_20_5> getComponentRewriter() {
        return this.componentRewriter;
    }

    @Override
    public VersionedTypesHolder types() {
        return VersionedTypes.V1_20_5;
    }

    @Override
    public VersionedTypesHolder mappedTypes() {
        return VersionedTypes.V1_21;
    }

    @Override
    protected PacketTypesProvider<ClientboundPacket1_20_5, ClientboundPacket1_21, ServerboundPacket1_20_5, ServerboundPacket1_20_5> createPacketTypesProvider() {
        return new SimplePacketTypesProvider<ClientboundPacket1_20_5, ClientboundPacket1_21, ServerboundPacket1_20_5, ServerboundPacket1_20_5>(ProtocolUtil.packetTypeMap(this.unmappedClientboundPacketType, ClientboundPackets1_20_5.class, ClientboundConfigurationPackets1_20_5.class), ProtocolUtil.packetTypeMap(this.mappedClientboundPacketType, ClientboundPackets1_21.class, ClientboundConfigurationPackets1_21.class), ProtocolUtil.packetTypeMap(this.mappedServerboundPacketType, ServerboundPackets1_20_5.class, ServerboundConfigurationPackets1_20_5.class), ProtocolUtil.packetTypeMap(this.unmappedServerboundPacketType, ServerboundPackets1_20_5.class, ServerboundConfigurationPackets1_20_5.class));
    }
}


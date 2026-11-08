/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21_2to1_21_4;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.MappingData;
import com.viaversion.viaversion.api.data.MappingDataBase;
import com.viaversion.viaversion.api.minecraft.Particle;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_4;
import com.viaversion.viaversion.api.platform.providers.ViaProviders;
import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viaversion.api.protocol.packet.provider.PacketTypesProvider;
import com.viaversion.viaversion.api.protocol.packet.provider.SimplePacketTypesProvider;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.misc.ParticleType;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.api.type.types.version.VersionedTypesHolder;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundConfigurationPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundConfigurationPackets1_21;
import com.viaversion.viaversion.protocols.v1_21_2to1_21_4.packet.ServerboundPacket1_21_4;
import com.viaversion.viaversion.protocols.v1_21_2to1_21_4.packet.ServerboundPackets1_21_4;
import com.viaversion.viaversion.protocols.v1_21_2to1_21_4.provider.PickItemProvider;
import com.viaversion.viaversion.protocols.v1_21_2to1_21_4.rewriter.BlockItemPacketRewriter1_21_4;
import com.viaversion.viaversion.protocols.v1_21_2to1_21_4.rewriter.BlockPacketRewriter1_21_4;
import com.viaversion.viaversion.protocols.v1_21_2to1_21_4.rewriter.ComponentRewriter1_21_4;
import com.viaversion.viaversion.protocols.v1_21_2to1_21_4.rewriter.EntityPacketRewriter1_21_4;
import com.viaversion.viaversion.protocols.v1_21_2to1_21_4.rewriter.ParticleRewriter1_21_4;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPacket1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPackets1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ServerboundPacket1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ServerboundPackets1_21_2;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.RecipeDisplayRewriter;
import com.viaversion.viaversion.rewriter.RegistryDataRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;
import com.viaversion.viaversion.rewriter.text.JsonNBTComponentRewriter;
import com.viaversion.viaversion.util.ProtocolUtil;
import java.util.BitSet;

public class Protocol1_21_2To1_21_4
extends AbstractProtocol<ClientboundPacket1_21_2, ClientboundPacket1_21_2, ServerboundPacket1_21_2, ServerboundPacket1_21_4> {
    public static final MappingData MAPPINGS = new MappingDataBase("1.21.2", "1.21.4");
    private final EntityPacketRewriter1_21_4 entityRewriter = new EntityPacketRewriter1_21_4(this);
    private final BlockItemPacketRewriter1_21_4 itemRewriter = new BlockItemPacketRewriter1_21_4(this);
    private final ParticleRewriter<ClientboundPacket1_21_2> particleRewriter = new ParticleRewriter1_21_4(this);
    private final TagRewriter<ClientboundPacket1_21_2> tagRewriter = new TagRewriter<ClientboundPacket1_21_2>(this);
    private final JsonNBTComponentRewriter<ClientboundPacket1_21_2> componentRewriter = new ComponentRewriter1_21_4(this);
    private final BlockRewriter<ClientboundPacket1_21_2> blockRewriter = new BlockPacketRewriter1_21_4(this);
    private final RecipeDisplayRewriter<ClientboundPacket1_21_2> recipeRewriter = new RecipeDisplayRewriter<ClientboundPacket1_21_2>(this);
    private final RegistryDataRewriter registryDataRewriter = new RegistryDataRewriter(this);

    public Protocol1_21_2To1_21_4() {
        super(ClientboundPacket1_21_2.class, ClientboundPacket1_21_2.class, ServerboundPacket1_21_2.class, ServerboundPacket1_21_4.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        this.replaceClientbound(ClientboundPackets1_21_2.LEVEL_PARTICLES, packetWrapper -> {
            packetWrapper.passthrough(Types.BOOLEAN);
            packetWrapper.write(Types.BOOLEAN, false);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.FLOAT);
            packetWrapper.passthrough(Types.FLOAT);
            packetWrapper.passthrough(Types.FLOAT);
            packetWrapper.passthrough(Types.FLOAT);
            packetWrapper.passthrough(Types.INT);
            Particle particle = packetWrapper.passthroughAndMap(VersionedTypes.V1_21_2.particle, VersionedTypes.V1_21_4.particle);
            this.particleRewriter.rewriteParticle(packetWrapper.user(), particle);
        });
        this.replaceClientbound(ClientboundPackets1_21_2.PLAYER_INFO_UPDATE, packetWrapper -> {
            BitSet bitSet = packetWrapper.passthroughAndMap(Types.PROFILE_ACTIONS_ENUM1_21_2, Types.PROFILE_ACTIONS_ENUM1_21_4);
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
                if (!bitSet.get(6)) continue;
                packetWrapper.passthrough(Types.VAR_INT);
            }
        });
    }

    @Override
    protected void onMappingDataLoaded() {
        EntityTypes1_21_4.initialize(this);
        ParticleType.Fillers.fill1_21_4(this);
        VersionedTypes.V1_21_4.structuredData.filler(this).add(StructuredDataKey.CUSTOM_DATA, StructuredDataKey.MAX_STACK_SIZE, StructuredDataKey.MAX_DAMAGE, StructuredDataKey.UNBREAKABLE1_20_5, StructuredDataKey.RARITY, StructuredDataKey.HIDE_TOOLTIP, StructuredDataKey.DAMAGE_RESISTANT1_21_2, StructuredDataKey.CUSTOM_NAME, StructuredDataKey.LORE, StructuredDataKey.ENCHANTMENTS1_20_5, StructuredDataKey.CAN_PLACE_ON1_20_5, StructuredDataKey.CAN_BREAK1_20_5, StructuredDataKey.CUSTOM_MODEL_DATA1_21_4, StructuredDataKey.HIDE_ADDITIONAL_TOOLTIP, StructuredDataKey.REPAIR_COST, StructuredDataKey.CREATIVE_SLOT_LOCK, StructuredDataKey.ENCHANTMENT_GLINT_OVERRIDE, StructuredDataKey.INTANGIBLE_PROJECTILE, StructuredDataKey.STORED_ENCHANTMENTS1_20_5, StructuredDataKey.DYED_COLOR1_20_5, StructuredDataKey.MAP_COLOR, StructuredDataKey.MAP_ID, StructuredDataKey.MAP_DECORATIONS, StructuredDataKey.MAP_POST_PROCESSING, StructuredDataKey.POTION_CONTENTS1_21_2, StructuredDataKey.SUSPICIOUS_STEW_EFFECTS, StructuredDataKey.WRITABLE_BOOK_CONTENT, StructuredDataKey.WRITTEN_BOOK_CONTENT, StructuredDataKey.TRIM1_21_4, StructuredDataKey.DEBUG_STICK_STATE, StructuredDataKey.ENTITY_DATA1_20_5, StructuredDataKey.BUCKET_ENTITY_DATA, StructuredDataKey.BLOCK_ENTITY_DATA1_20_5, StructuredDataKey.INSTRUMENT1_21_2, StructuredDataKey.RECIPES, StructuredDataKey.LODESTONE_TRACKER, StructuredDataKey.FIREWORK_EXPLOSION, StructuredDataKey.FIREWORKS, StructuredDataKey.PROFILE1_20_5, StructuredDataKey.NOTE_BLOCK_SOUND, StructuredDataKey.BANNER_PATTERNS, StructuredDataKey.BASE_COLOR, StructuredDataKey.POT_DECORATIONS, StructuredDataKey.BLOCK_STATE, StructuredDataKey.BEES1_20_5, StructuredDataKey.LOCK1_21_2, StructuredDataKey.CONTAINER_LOOT, StructuredDataKey.TOOL1_20_5, StructuredDataKey.ITEM_NAME, StructuredDataKey.OMINOUS_BOTTLE_AMPLIFIER, StructuredDataKey.FOOD1_21_2, StructuredDataKey.JUKEBOX_PLAYABLE1_21, StructuredDataKey.ATTRIBUTE_MODIFIERS1_21, StructuredDataKey.REPAIRABLE, StructuredDataKey.ENCHANTABLE, StructuredDataKey.CONSUMABLE1_21_2, StructuredDataKey.USE_COOLDOWN, StructuredDataKey.DAMAGE, StructuredDataKey.EQUIPPABLE1_21_2, StructuredDataKey.ITEM_MODEL, StructuredDataKey.GLIDER, StructuredDataKey.TOOLTIP_STYLE, StructuredDataKey.DEATH_PROTECTION);
        super.onMappingDataLoaded();
    }

    @Override
    public void register(ViaProviders viaProviders) {
        viaProviders.register(PickItemProvider.class, new PickItemProvider());
    }

    @Override
    public void init(UserConnection userConnection) {
        this.addEntityTracker(userConnection, new EntityTrackerBase(userConnection, EntityTypes1_21_4.PLAYER));
    }

    @Override
    public MappingData getMappingData() {
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
    public RecipeDisplayRewriter<ClientboundPacket1_21_2> getRecipeRewriter() {
        return this.recipeRewriter;
    }

    @Override
    public RegistryDataRewriter getRegistryDataRewriter() {
        return this.registryDataRewriter;
    }

    @Override
    public ParticleRewriter<ClientboundPacket1_21_2> getParticleRewriter() {
        return this.particleRewriter;
    }

    @Override
    public TagRewriter<ClientboundPacket1_21_2> getTagRewriter() {
        return this.tagRewriter;
    }

    @Override
    public JsonNBTComponentRewriter<ClientboundPacket1_21_2> getComponentRewriter() {
        return this.componentRewriter;
    }

    @Override
    public VersionedTypesHolder types() {
        return VersionedTypes.V1_21_2;
    }

    @Override
    public VersionedTypesHolder mappedTypes() {
        return VersionedTypes.V1_21_4;
    }

    @Override
    protected PacketTypesProvider<ClientboundPacket1_21_2, ClientboundPacket1_21_2, ServerboundPacket1_21_2, ServerboundPacket1_21_4> createPacketTypesProvider() {
        return new SimplePacketTypesProvider<ClientboundPacket1_21_2, ClientboundPacket1_21_2, ServerboundPacket1_21_2, ServerboundPacket1_21_4>(ProtocolUtil.packetTypeMap(this.unmappedClientboundPacketType, ClientboundPackets1_21_2.class, ClientboundConfigurationPackets1_21.class), ProtocolUtil.packetTypeMap(this.mappedClientboundPacketType, ClientboundPackets1_21_2.class, ClientboundConfigurationPackets1_21.class), ProtocolUtil.packetTypeMap(this.mappedServerboundPacketType, ServerboundPackets1_21_2.class, ServerboundConfigurationPackets1_20_5.class), ProtocolUtil.packetTypeMap(this.unmappedServerboundPacketType, ServerboundPackets1_21_4.class, ServerboundConfigurationPackets1_20_5.class));
    }
}


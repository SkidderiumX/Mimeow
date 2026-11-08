/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_20_3to1_20_5;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.ProfileKey;
import com.viaversion.viaversion.api.minecraft.RegistryType;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_20_5;
import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.protocol.packet.provider.PacketTypesProvider;
import com.viaversion.viaversion.api.protocol.packet.provider.SimplePacketTypesProvider;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_20_2;
import com.viaversion.viaversion.api.type.types.misc.ParticleType;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.protocols.base.ClientboundLoginPackets;
import com.viaversion.viaversion.protocols.base.ServerboundLoginPackets;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.packet.ClientboundConfigurationPackets1_20_3;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.packet.ClientboundPacket1_20_3;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.packet.ClientboundPackets1_20_3;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.packet.ServerboundPacket1_20_3;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.packet.ServerboundPackets1_20_3;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.MappingData1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ClientboundConfigurationPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ClientboundPacket1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ClientboundPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundConfigurationPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundPacket1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.rewriter.BlockItemPacketRewriter1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.rewriter.ComponentRewriter1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.rewriter.EntityPacketRewriter1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.rewriter.ParticleRewriter1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.storage.AcknowledgedMessagesStorage;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.storage.ArmorTrimStorage;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.storage.ScoreboardTeamStorage;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.storage.TagKeys;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.packet.ServerboundConfigurationPackets1_20_2;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;
import com.viaversion.viaversion.rewriter.text.JsonNBTComponentRewriter;
import com.viaversion.viaversion.util.ProtocolLogger;
import com.viaversion.viaversion.util.ProtocolUtil;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Objects;
import java.util.UUID;

public class Protocol1_20_3To1_20_5
extends AbstractProtocol<ClientboundPacket1_20_3, ClientboundPacket1_20_5, ServerboundPacket1_20_3, ServerboundPacket1_20_5> {
    public static final MappingData1_20_5 MAPPINGS = new MappingData1_20_5();
    public static final ProtocolLogger LOGGER = new ProtocolLogger(Protocol1_20_3To1_20_5.class);
    public static boolean strictErrorHandling = System.getProperty("viaversion.strict-error-handling1_20_5", "true").equalsIgnoreCase("true");
    private final EntityPacketRewriter1_20_5 entityRewriter = new EntityPacketRewriter1_20_5(this);
    private final BlockItemPacketRewriter1_20_5 itemRewriter = new BlockItemPacketRewriter1_20_5(this);
    private final ParticleRewriter1_20_5 particleRewriter = new ParticleRewriter1_20_5(this);
    private final TagRewriter<ClientboundPacket1_20_3> tagRewriter = new TagRewriter<ClientboundPacket1_20_3>((Protocol)this){

        @Override
        public void handleGeneric(PacketWrapper packetWrapper) {
            super.handleGeneric(packetWrapper);
            packetWrapper.resetReader();
            packetWrapper.user().put(new TagKeys(packetWrapper));
        }
    };
    private final ComponentRewriter1_20_5<ClientboundPacket1_20_3> componentRewriter;
    private final BlockRewriter<ClientboundPacket1_20_3> blockRewriter;

    public Protocol1_20_3To1_20_5() {
        super(ClientboundPacket1_20_3.class, ClientboundPacket1_20_5.class, ServerboundPacket1_20_3.class, ServerboundPacket1_20_5.class);
        this.componentRewriter = new ComponentRewriter1_20_5<ClientboundPacket1_20_3>(this, VersionedTypes.V1_20_5.structuredData);
        this.blockRewriter = BlockRewriter.for1_20_2(this, ChunkType1_20_2::new);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        this.registerClientbound(State.LOGIN, ClientboundLoginPackets.HELLO, (PacketWrapper packetWrapper) -> {
            packetWrapper.passthrough(Types.STRING);
            packetWrapper.passthrough(Types.BYTE_ARRAY_PRIMITIVE);
            packetWrapper.passthrough(Types.BYTE_ARRAY_PRIMITIVE);
            packetWrapper.write(Types.BOOLEAN, true);
        });
        this.replaceClientbound(ClientboundPackets1_20_3.SERVER_DATA, packetWrapper -> {
            this.componentRewriter.passthroughAndProcess(packetWrapper);
            packetWrapper.passthrough(Types.OPTIONAL_BYTE_ARRAY_PRIMITIVE);
            boolean bl = packetWrapper.read(Types.BOOLEAN);
            AcknowledgedMessagesStorage acknowledgedMessagesStorage = packetWrapper.user().get(AcknowledgedMessagesStorage.class);
            acknowledgedMessagesStorage.setSecureChatEnforced(bl);
            if (bl) {
                acknowledgedMessagesStorage.sendQueuedChatSession(packetWrapper);
            }
        });
        this.registerServerbound(ServerboundPackets1_20_5.CHAT, packetWrapper -> {
            packetWrapper.passthrough(Types.STRING);
            packetWrapper.passthrough(Types.LONG);
            AcknowledgedMessagesStorage acknowledgedMessagesStorage = packetWrapper.user().get(AcknowledgedMessagesStorage.class);
            long l = packetWrapper.read(Types.LONG);
            byte[] byArray = packetWrapper.read(Types.OPTIONAL_SIGNATURE_BYTES);
            if (acknowledgedMessagesStorage.isSecureChatEnforced()) {
                packetWrapper.write(Types.LONG, l);
                packetWrapper.write(Types.OPTIONAL_SIGNATURE_BYTES, byArray);
            } else {
                packetWrapper.write(Types.LONG, 0L);
                packetWrapper.write(Types.OPTIONAL_SIGNATURE_BYTES, null);
            }
            this.fixChatAck(packetWrapper, acknowledgedMessagesStorage);
        });
        this.registerServerbound(ServerboundPackets1_20_5.CHAT_COMMAND_SIGNED, ServerboundPackets1_20_3.CHAT_COMMAND, (PacketWrapper packetWrapper) -> {
            packetWrapper.passthrough(Types.STRING);
            packetWrapper.passthrough(Types.LONG);
            AcknowledgedMessagesStorage acknowledgedMessagesStorage = packetWrapper.user().get(AcknowledgedMessagesStorage.class);
            long l = packetWrapper.read(Types.LONG);
            int n = packetWrapper.read(Types.VAR_INT);
            if (acknowledgedMessagesStorage.isSecureChatEnforced()) {
                packetWrapper.write(Types.LONG, l);
                packetWrapper.write(Types.VAR_INT, n);
                for (int i = 0; i < n; ++i) {
                    packetWrapper.passthrough(Types.STRING);
                    packetWrapper.passthrough(Types.SIGNATURE_BYTES);
                }
            } else {
                packetWrapper.write(Types.LONG, 0L);
                packetWrapper.write(Types.VAR_INT, 0);
                for (int i = 0; i < n; ++i) {
                    packetWrapper.read(Types.STRING);
                    packetWrapper.read(Types.SIGNATURE_BYTES);
                }
            }
            this.fixChatAck(packetWrapper, acknowledgedMessagesStorage);
        });
        this.registerServerbound(ServerboundPackets1_20_5.CHAT_ACK, packetWrapper -> {
            int n = packetWrapper.read(Types.VAR_INT);
            int n2 = packetWrapper.user().get(AcknowledgedMessagesStorage.class).accumulateAckCount(n);
            if (n2 > 0) {
                packetWrapper.write(Types.VAR_INT, n2);
            } else {
                packetWrapper.cancel();
            }
        });
        this.registerServerbound(ServerboundPackets1_20_5.CHAT_COMMAND, packetWrapper -> {
            packetWrapper.passthrough(Types.STRING);
            packetWrapper.write(Types.LONG, System.currentTimeMillis());
            packetWrapper.write(Types.LONG, 0L);
            packetWrapper.write(Types.VAR_INT, 0);
            this.writeSpoofedChatAck(packetWrapper, packetWrapper.user().get(AcknowledgedMessagesStorage.class));
        });
        this.registerServerbound(ServerboundPackets1_20_5.CHAT_SESSION_UPDATE, packetWrapper -> {
            AcknowledgedMessagesStorage acknowledgedMessagesStorage = packetWrapper.user().get(AcknowledgedMessagesStorage.class);
            if (acknowledgedMessagesStorage.secureChatEnforced() != null && acknowledgedMessagesStorage.secureChatEnforced().booleanValue()) {
                return;
            }
            UUID uUID = packetWrapper.read(Types.UUID);
            ProfileKey profileKey = packetWrapper.read(Types.PROFILE_KEY);
            acknowledgedMessagesStorage.queueChatSession(uUID, profileKey);
            packetWrapper.cancel();
        });
        this.appendClientbound(ClientboundPackets1_20_3.START_CONFIGURATION, packetWrapper -> packetWrapper.user().put(new AcknowledgedMessagesStorage()));
        this.registerClientbound(State.LOGIN, ClientboundLoginPackets.LOGIN_FINISHED, (PacketWrapper packetWrapper) -> {
            packetWrapper.passthrough(Types.UUID);
            packetWrapper.passthrough(Types.STRING);
            packetWrapper.passthrough(Types.PROFILE_PROPERTY_ARRAY);
            packetWrapper.write(Types.BOOLEAN, strictErrorHandling);
        });
        this.replaceClientbound(ClientboundPackets1_20_3.SET_PLAYER_TEAM, packetWrapper -> {
            String string;
            String string2;
            String[] stringArray;
            ScoreboardTeamStorage scoreboardTeamStorage = packetWrapper.user().get(ScoreboardTeamStorage.class);
            String string3 = packetWrapper.passthrough(Types.STRING);
            byte by = packetWrapper.passthrough(Types.BYTE);
            if (by == 0) {
                this.componentRewriter.passthroughAndProcess(packetWrapper);
                packetWrapper.passthrough(Types.BYTE);
                packetWrapper.passthrough(Types.STRING);
                packetWrapper.passthrough(Types.STRING);
                packetWrapper.passthrough(Types.VAR_INT);
                this.componentRewriter.passthroughAndProcess(packetWrapper);
                this.componentRewriter.passthroughAndProcess(packetWrapper);
                scoreboardTeamStorage.createTeam(string3);
                stringArray = packetWrapper.passthrough(Types.STRING_ARRAY);
                scoreboardTeamStorage.addPlayerToTeam(string3, stringArray);
            } else if (by == 1) {
                scoreboardTeamStorage.removeTeam(string3);
            } else if (by == 3) {
                stringArray = packetWrapper.passthrough(Types.STRING_ARRAY);
                scoreboardTeamStorage.addPlayerToTeam(string3, stringArray);
            }
            if (by != 4) {
                return;
            }
            stringArray = packetWrapper.read(Types.STRING_ARRAY);
            HashSet<String> hashSet = new HashSet<String>();
            String[] stringArray2 = stringArray;
            int n = stringArray2.length;
            for (int i = 0; i < n && Objects.equals(string2 = scoreboardTeamStorage.getPlayerTeam(string = stringArray2[i]), string3); ++i) {
                scoreboardTeamStorage.removeFromTeam(string3, string);
                hashSet.add(string);
            }
            if (!hashSet.isEmpty()) {
                packetWrapper.write(Types.STRING_ARRAY, hashSet.toArray(new String[0]));
            } else {
                packetWrapper.cancel();
            }
        });
        this.cancelServerbound(State.LOGIN, ServerboundLoginPackets.COOKIE_RESPONSE.getId());
        this.cancelServerbound(ServerboundConfigurationPackets1_20_5.COOKIE_RESPONSE);
        this.cancelServerbound(ServerboundConfigurationPackets1_20_5.SELECT_KNOWN_PACKS);
        this.cancelServerbound(ServerboundPackets1_20_5.COOKIE_RESPONSE);
        this.cancelServerbound(ServerboundPackets1_20_5.DEBUG_SAMPLE_SUBSCRIPTION);
    }

    private void fixChatAck(PacketWrapper packetWrapper, AcknowledgedMessagesStorage acknowledgedMessagesStorage) {
        int n = packetWrapper.read(Types.VAR_INT);
        BitSet bitSet = packetWrapper.read(Types.ACKNOWLEDGED_BIT_SET);
        int n2 = acknowledgedMessagesStorage.updateFromMessage(n, bitSet);
        packetWrapper.write(Types.VAR_INT, n2);
        packetWrapper.write(Types.ACKNOWLEDGED_BIT_SET, bitSet);
    }

    private void writeSpoofedChatAck(PacketWrapper packetWrapper, AcknowledgedMessagesStorage acknowledgedMessagesStorage) {
        packetWrapper.write(Types.VAR_INT, 0);
        packetWrapper.write(Types.ACKNOWLEDGED_BIT_SET, acknowledgedMessagesStorage.createSpoofedAck());
    }

    @Override
    protected void onMappingDataLoaded() {
        EntityTypes1_20_5.initialize(this);
        ParticleType.Fillers.fill1_20_5(this, VersionedTypes.V1_20_5.particle);
        VersionedTypes.V1_20_5.structuredData.filler(this).add((StructuredDataKey<?>)StructuredDataKey.CUSTOM_DATA).add((StructuredDataKey<?>)StructuredDataKey.MAX_STACK_SIZE).add((StructuredDataKey<?>)StructuredDataKey.MAX_DAMAGE).add((StructuredDataKey<?>)StructuredDataKey.DAMAGE).add((StructuredDataKey<?>)StructuredDataKey.UNBREAKABLE1_20_5).add((StructuredDataKey<?>)StructuredDataKey.RARITY).add((StructuredDataKey<?>)StructuredDataKey.HIDE_TOOLTIP).add((StructuredDataKey<?>)StructuredDataKey.FOOD1_20_5).add((StructuredDataKey<?>)StructuredDataKey.FIRE_RESISTANT).add((StructuredDataKey<?>)StructuredDataKey.CUSTOM_NAME).add((StructuredDataKey<?>)StructuredDataKey.LORE).add((StructuredDataKey<?>)StructuredDataKey.ENCHANTMENTS1_20_5).add((StructuredDataKey<?>)StructuredDataKey.CAN_PLACE_ON1_20_5).add((StructuredDataKey<?>)StructuredDataKey.CAN_BREAK1_20_5).add((StructuredDataKey<?>)StructuredDataKey.ATTRIBUTE_MODIFIERS1_20_5).add((StructuredDataKey<?>)StructuredDataKey.CUSTOM_MODEL_DATA1_20_5).add((StructuredDataKey<?>)StructuredDataKey.HIDE_ADDITIONAL_TOOLTIP).add((StructuredDataKey<?>)StructuredDataKey.REPAIR_COST).add((StructuredDataKey<?>)StructuredDataKey.CREATIVE_SLOT_LOCK).add((StructuredDataKey<?>)StructuredDataKey.ENCHANTMENT_GLINT_OVERRIDE).add((StructuredDataKey<?>)StructuredDataKey.INTANGIBLE_PROJECTILE).add((StructuredDataKey<?>)StructuredDataKey.STORED_ENCHANTMENTS1_20_5).add((StructuredDataKey<?>)StructuredDataKey.DYED_COLOR1_20_5).add((StructuredDataKey<?>)StructuredDataKey.MAP_COLOR).add((StructuredDataKey<?>)StructuredDataKey.MAP_ID).add((StructuredDataKey<?>)StructuredDataKey.MAP_DECORATIONS).add((StructuredDataKey<?>)StructuredDataKey.MAP_POST_PROCESSING).add((StructuredDataKey<?>)StructuredDataKey.POTION_CONTENTS1_20_5).add((StructuredDataKey<?>)StructuredDataKey.SUSPICIOUS_STEW_EFFECTS).add((StructuredDataKey<?>)StructuredDataKey.WRITABLE_BOOK_CONTENT).add((StructuredDataKey<?>)StructuredDataKey.WRITTEN_BOOK_CONTENT).add((StructuredDataKey<?>)StructuredDataKey.TRIM1_20_5).add((StructuredDataKey<?>)StructuredDataKey.DEBUG_STICK_STATE).add((StructuredDataKey<?>)StructuredDataKey.ENTITY_DATA1_20_5).add((StructuredDataKey<?>)StructuredDataKey.BUCKET_ENTITY_DATA).add((StructuredDataKey<?>)StructuredDataKey.BLOCK_ENTITY_DATA1_20_5).add((StructuredDataKey<?>)StructuredDataKey.INSTRUMENT1_20_5).add((StructuredDataKey<?>)StructuredDataKey.RECIPES).add((StructuredDataKey<?>)StructuredDataKey.LODESTONE_TRACKER).add((StructuredDataKey<?>)StructuredDataKey.FIREWORK_EXPLOSION).add((StructuredDataKey<?>)StructuredDataKey.FIREWORKS).add((StructuredDataKey<?>)StructuredDataKey.PROFILE1_20_5).add((StructuredDataKey<?>)StructuredDataKey.NOTE_BLOCK_SOUND).add((StructuredDataKey<?>)StructuredDataKey.BANNER_PATTERNS).add((StructuredDataKey<?>)StructuredDataKey.BASE_COLOR).add((StructuredDataKey<?>)StructuredDataKey.POT_DECORATIONS).add((StructuredDataKey<?>)StructuredDataKey.BLOCK_STATE).add((StructuredDataKey<?>)StructuredDataKey.BEES1_20_5).add((StructuredDataKey<?>)StructuredDataKey.LOCK1_20_5).add((StructuredDataKey<?>)StructuredDataKey.CONTAINER_LOOT).add((StructuredDataKey<?>)StructuredDataKey.TOOL1_20_5).add((StructuredDataKey<?>)StructuredDataKey.ITEM_NAME).add((StructuredDataKey<?>)StructuredDataKey.OMINOUS_BOTTLE_AMPLIFIER).add(VersionedTypes.V1_20_5.structuredDataKeys().keys());
        this.tagRewriter.renameTag(RegistryType.ITEM, "minecraft:axolotl_tempt_items", "minecraft:axolotl_food");
        this.tagRewriter.removeTag(RegistryType.ITEM, "minecraft:tools");
        this.tagRewriter.addEmptyTags(RegistryType.BLOCK, "minecraft:badlands_terracotta");
        this.tagRewriter.addEmptyTags(RegistryType.ITEM, "minecraft:enchantable/mace");
        super.onMappingDataLoaded();
    }

    @Override
    public void init(UserConnection userConnection) {
        this.addEntityTracker(userConnection, new EntityTrackerBase(userConnection, EntityTypes1_20_5.PLAYER));
        userConnection.put(new AcknowledgedMessagesStorage());
        userConnection.put(new ArmorTrimStorage());
        userConnection.put(new ScoreboardTeamStorage());
    }

    @Override
    public MappingData1_20_5 getMappingData() {
        return MAPPINGS;
    }

    @Override
    public ProtocolLogger getLogger() {
        return LOGGER;
    }

    public EntityPacketRewriter1_20_5 getEntityRewriter() {
        return this.entityRewriter;
    }

    public BlockItemPacketRewriter1_20_5 getItemRewriter() {
        return this.itemRewriter;
    }

    @Override
    public BlockRewriter<ClientboundPacket1_20_3> getBlockRewriter() {
        return this.blockRewriter;
    }

    @Override
    public ParticleRewriter1_20_5 getParticleRewriter() {
        return this.particleRewriter;
    }

    @Override
    public TagRewriter<ClientboundPacket1_20_3> getTagRewriter() {
        return this.tagRewriter;
    }

    @Override
    public JsonNBTComponentRewriter<ClientboundPacket1_20_3> getComponentRewriter() {
        return this.componentRewriter;
    }

    @Override
    protected PacketTypesProvider<ClientboundPacket1_20_3, ClientboundPacket1_20_5, ServerboundPacket1_20_3, ServerboundPacket1_20_5> createPacketTypesProvider() {
        return new SimplePacketTypesProvider<ClientboundPacket1_20_3, ClientboundPacket1_20_5, ServerboundPacket1_20_3, ServerboundPacket1_20_5>(ProtocolUtil.packetTypeMap(this.unmappedClientboundPacketType, ClientboundPackets1_20_3.class, ClientboundConfigurationPackets1_20_3.class), ProtocolUtil.packetTypeMap(this.mappedClientboundPacketType, ClientboundPackets1_20_5.class, ClientboundConfigurationPackets1_20_5.class), ProtocolUtil.packetTypeMap(this.mappedServerboundPacketType, ServerboundPackets1_20_3.class, ServerboundConfigurationPackets1_20_2.class), ProtocolUtil.packetTypeMap(this.unmappedServerboundPacketType, ServerboundPackets1_20_5.class, ServerboundConfigurationPackets1_20_5.class));
    }
}


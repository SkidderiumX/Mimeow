/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_19_1to1_19_3;

import com.google.common.primitives.Longs;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.MappingData;
import com.viaversion.viaversion.api.data.MappingDataBase;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.PlayerMessageSignature;
import com.viaversion.viaversion.api.minecraft.RegistryType;
import com.viaversion.viaversion.api.minecraft.SoundEvent;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_19_3;
import com.viaversion.viaversion.api.minecraft.signature.SignableCommandArgumentsProvider;
import com.viaversion.viaversion.api.minecraft.signature.model.DecoratableMessage;
import com.viaversion.viaversion.api.minecraft.signature.model.MessageMetadata;
import com.viaversion.viaversion.api.minecraft.signature.storage.ChatSession1_19_1;
import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_18;
import com.viaversion.viaversion.api.type.types.misc.ParticleType;
import com.viaversion.viaversion.api.type.types.version.Types1_19_3;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.protocols.base.ClientboundLoginPackets;
import com.viaversion.viaversion.protocols.base.ServerboundLoginPackets;
import com.viaversion.viaversion.protocols.v1_19_1to1_19_3.packet.ClientboundPackets1_19_3;
import com.viaversion.viaversion.protocols.v1_19_1to1_19_3.packet.ServerboundPackets1_19_3;
import com.viaversion.viaversion.protocols.v1_19_1to1_19_3.rewriter.ComponentRewriter1_19_3;
import com.viaversion.viaversion.protocols.v1_19_1to1_19_3.rewriter.EntityPacketRewriter1_19_3;
import com.viaversion.viaversion.protocols.v1_19_1to1_19_3.rewriter.ItemPacketRewriter1_19_3;
import com.viaversion.viaversion.protocols.v1_19_1to1_19_3.storage.NonceStorage1_19_3;
import com.viaversion.viaversion.protocols.v1_19_1to1_19_3.storage.ReceivedMessagesStorage;
import com.viaversion.viaversion.protocols.v1_19to1_19_1.packet.ClientboundPackets1_19_1;
import com.viaversion.viaversion.protocols.v1_19to1_19_1.packet.ServerboundPackets1_19_1;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.CommandRewriter;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;
import com.viaversion.viaversion.util.ComponentUtil;
import com.viaversion.viaversion.util.Pair;
import java.security.SignatureException;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class Protocol1_19_1To1_19_3
extends AbstractProtocol<ClientboundPackets1_19_1, ClientboundPackets1_19_3, ServerboundPackets1_19_1, ServerboundPackets1_19_3> {
    public static final MappingData MAPPINGS = new MappingDataBase("1.19", "1.19.3");
    private static final UUID ZERO_UUID = new UUID(0L, 0L);
    private static final byte[] EMPTY_BYTES = new byte[0];
    private static final int SOUND_SOURCE_BLOCKS = 4;
    private static final int SOUND_IRON_DOOR_CLOSE = 614;
    private static final int SOUND_IRON_DOOR_OPEN = 615;
    private static final int SOUND_IRON_TRAPDOOR_CLOSE = 622;
    private static final int SOUND_IRON_TRAPDOOR_OPEN = 623;
    private static final int SOUND_FENCE_GATE_CLOSE = 110;
    private static final int SOUND_FENCE_GATE_OPEN = 111;
    private static final int SOUND_WOODEN_DOOR_CLOSE = 1345;
    private static final int SOUND_WOODEN_DOOR_OPEN = 1346;
    private static final int SOUND_WOODEN_TRAPDOOR_CLOSE = 1347;
    private static final int SOUND_WOODEN_TRAPDOOR_OPEN = 1348;
    private final EntityPacketRewriter1_19_3 entityRewriter = new EntityPacketRewriter1_19_3(this);
    private final ItemPacketRewriter1_19_3 itemRewriter = new ItemPacketRewriter1_19_3(this);
    private final ParticleRewriter<ClientboundPackets1_19_1> particleRewriter = new ParticleRewriter<ClientboundPackets1_19_1>(this);
    private final ComponentRewriter1_19_3 componentRewriter = new ComponentRewriter1_19_3(this);
    private final TagRewriter<ClientboundPackets1_19_1> tagRewriter = new TagRewriter<ClientboundPackets1_19_1>(this);
    private final BlockRewriter<ClientboundPackets1_19_1> blockRewriter = BlockRewriter.for1_18(this, ChunkType1_18::new);

    public Protocol1_19_1To1_19_3() {
        super(ClientboundPackets1_19_1.class, ClientboundPackets1_19_3.class, ServerboundPackets1_19_1.class, ServerboundPackets1_19_3.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        PacketHandler packetHandler = packetWrapper -> {
            int n = packetWrapper.read(Types.VAR_INT);
            n = MAPPINGS.getSoundMappings().getNewId(n);
            if (n == -1) {
                packetWrapper.cancel();
                return;
            }
            packetWrapper.write(Types.SOUND_EVENT, Holder.of(n));
        };
        this.replaceClientbound(ClientboundPackets1_19_1.SOUND_ENTITY, packetHandler);
        this.replaceClientbound(ClientboundPackets1_19_1.SOUND, packetHandler);
        this.registerClientbound(ClientboundPackets1_19_1.CUSTOM_SOUND, ClientboundPackets1_19_3.SOUND, (PacketWrapper packetWrapper) -> {
            String string = packetWrapper.read(Types.STRING);
            packetWrapper.write(Types.SOUND_EVENT, Holder.of(new SoundEvent(string, null)));
        });
        this.appendClientbound(ClientboundPackets1_19_1.LEVEL_EVENT, packetWrapper -> {
            packetWrapper.resetReader();
            int n = packetWrapper.read(Types.INT);
            int n2 = Protocol1_19_1To1_19_3.levelEventSoundId(n);
            if (n2 == -1) {
                packetWrapper.write(Types.INT, n);
                return;
            }
            BlockPosition blockPosition = packetWrapper.read(Types.BLOCK_POSITION1_14);
            packetWrapper.read(Types.INT);
            packetWrapper.read(Types.BOOLEAN);
            packetWrapper.setPacketType(ClientboundPackets1_19_3.SOUND);
            packetWrapper.write(Types.SOUND_EVENT, Holder.of(n2));
            packetWrapper.write(Types.VAR_INT, 4);
            packetWrapper.write(Types.INT, blockPosition.x() * 8 + 4);
            packetWrapper.write(Types.INT, blockPosition.y() * 8 + 4);
            packetWrapper.write(Types.INT, blockPosition.z() * 8 + 4);
            packetWrapper.write(Types.FLOAT, Float.valueOf(1.0f));
            packetWrapper.write(Types.FLOAT, Float.valueOf(ThreadLocalRandom.current().nextFloat() * 0.1f + 0.9f));
            packetWrapper.write(Types.LONG, ThreadLocalRandom.current().nextLong());
        });
        CommandRewriter<ClientboundPackets1_19_1> commandRewriter = new CommandRewriter<ClientboundPackets1_19_1>((Protocol)this){

            @Override
            public void handleArgument(PacketWrapper packetWrapper, String string) {
                switch (string) {
                    case "minecraft:item_enchantment": {
                        packetWrapper.write(Types.STRING, "minecraft:enchantment");
                        break;
                    }
                    case "minecraft:mob_effect": {
                        packetWrapper.write(Types.STRING, "minecraft:mob_effect");
                        break;
                    }
                    case "minecraft:entity_summon": {
                        packetWrapper.write(Types.STRING, "minecraft:entity_type");
                        break;
                    }
                    default: {
                        super.handleArgument(packetWrapper, string);
                    }
                }
            }
        };
        this.replaceClientbound(ClientboundPackets1_19_1.COMMANDS, commandRewriter::handle1_19);
        this.replaceClientbound(ClientboundPackets1_19_1.SERVER_DATA, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.OPTIONAL_COMPONENT);
                this.map(Types.OPTIONAL_STRING);
                this.read(Types.BOOLEAN);
            }
        });
        this.registerClientbound(ClientboundPackets1_19_1.PLAYER_CHAT, ClientboundPackets1_19_3.DISGUISED_CHAT, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.read(Types.OPTIONAL_BYTE_ARRAY_PRIMITIVE);
                this.handler(packetWrapper -> {
                    int n;
                    Object object;
                    Object object2;
                    PlayerMessageSignature playerMessageSignature = packetWrapper.read(Types.PLAYER_MESSAGE_SIGNATURE);
                    if (!playerMessageSignature.uuid().equals(ZERO_UUID) && playerMessageSignature.signatureBytes().length != 0) {
                        object2 = packetWrapper.user().get(ReceivedMessagesStorage.class);
                        ((ReceivedMessagesStorage)object2).add(playerMessageSignature);
                        if (((ReceivedMessagesStorage)object2).tickUnacknowledged() > 64) {
                            ((ReceivedMessagesStorage)object2).resetUnacknowledgedCount();
                            object = packetWrapper.create(ServerboundPackets1_19_1.CHAT_ACK);
                            object.write(Types.PLAYER_MESSAGE_SIGNATURE_ARRAY, ((ReceivedMessagesStorage)object2).lastSignatures());
                            object.write(Types.OPTIONAL_PLAYER_MESSAGE_SIGNATURE, null);
                            object.sendToServer(Protocol1_19_1To1_19_3.class);
                        }
                    }
                    object2 = packetWrapper.read(Types.STRING);
                    object = packetWrapper.read(Types.OPTIONAL_COMPONENT);
                    packetWrapper.read(Types.LONG);
                    packetWrapper.read(Types.LONG);
                    packetWrapper.read(Types.PLAYER_MESSAGE_SIGNATURE_ARRAY);
                    JsonElement jsonElement = packetWrapper.read(Types.OPTIONAL_COMPONENT);
                    if (jsonElement != null) {
                        object = jsonElement;
                    }
                    if (object == null) {
                        object = ComponentUtil.plainToJson((String)object2);
                    }
                    if ((n = packetWrapper.read(Types.VAR_INT).intValue()) == 2) {
                        packetWrapper.read(Types.LONG_ARRAY_PRIMITIVE);
                    }
                    packetWrapper.write(Types.COMPONENT, object);
                });
            }
        });
        this.registerServerbound(ServerboundPackets1_19_3.CHAT_COMMAND, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.map(Types.LONG);
                this.map(Types.LONG);
                this.handler(packetWrapper -> {
                    ChatSession1_19_1 chatSession1_19_1 = packetWrapper.user().get(ChatSession1_19_1.class);
                    ReceivedMessagesStorage receivedMessagesStorage = packetWrapper.user().get(ReceivedMessagesStorage.class);
                    int n = packetWrapper.read(Types.VAR_INT);
                    for (int i = 0; i < n; ++i) {
                        packetWrapper.read(Types.STRING);
                        packetWrapper.read(Types.SIGNATURE_BYTES);
                    }
                    SignableCommandArgumentsProvider signableCommandArgumentsProvider = Via.getManager().getProviders().get(SignableCommandArgumentsProvider.class);
                    if (chatSession1_19_1 != null && signableCommandArgumentsProvider != null) {
                        UUID uUID = packetWrapper.user().getProtocolInfo().getUuid();
                        String string = packetWrapper.get(Types.STRING, 0);
                        long l = packetWrapper.get(Types.LONG, 0);
                        long l2 = packetWrapper.get(Types.LONG, 1);
                        List<Pair<String, String>> list = signableCommandArgumentsProvider.getSignableArguments(string);
                        packetWrapper.write(Types.VAR_INT, list.size());
                        for (Pair<String, String> pair : list) {
                            byte[] byArray;
                            MessageMetadata messageMetadata = new MessageMetadata(uUID, l, l2);
                            DecoratableMessage decoratableMessage = new DecoratableMessage(pair.value());
                            try {
                                byArray = chatSession1_19_1.signChatMessage(messageMetadata, decoratableMessage, receivedMessagesStorage.lastSignatures());
                            }
                            catch (SignatureException signatureException) {
                                throw new RuntimeException(signatureException);
                            }
                            packetWrapper.write(Types.STRING, pair.key());
                            packetWrapper.write(Types.BYTE_ARRAY_PRIMITIVE, byArray);
                        }
                    } else {
                        packetWrapper.write(Types.VAR_INT, 0);
                    }
                    packetWrapper.write(Types.BOOLEAN, false);
                    receivedMessagesStorage.resetUnacknowledgedCount();
                    packetWrapper.write(Types.PLAYER_MESSAGE_SIGNATURE_ARRAY, receivedMessagesStorage.lastSignatures());
                    packetWrapper.write(Types.OPTIONAL_PLAYER_MESSAGE_SIGNATURE, null);
                });
                this.read(Types.VAR_INT);
                this.read(Types.ACKNOWLEDGED_BIT_SET);
            }
        });
        this.registerServerbound(ServerboundPackets1_19_3.CHAT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.map(Types.LONG);
                this.map(Types.LONG);
                this.read(Types.OPTIONAL_SIGNATURE_BYTES);
                this.handler(packetWrapper -> {
                    ChatSession1_19_1 chatSession1_19_1 = packetWrapper.user().get(ChatSession1_19_1.class);
                    ReceivedMessagesStorage receivedMessagesStorage = packetWrapper.user().get(ReceivedMessagesStorage.class);
                    if (chatSession1_19_1 != null) {
                        byte[] byArray;
                        UUID uUID = packetWrapper.user().getProtocolInfo().getUuid();
                        String string = packetWrapper.get(Types.STRING, 0);
                        long l = packetWrapper.get(Types.LONG, 0);
                        long l2 = packetWrapper.get(Types.LONG, 1);
                        MessageMetadata messageMetadata = new MessageMetadata(uUID, l, l2);
                        DecoratableMessage decoratableMessage = new DecoratableMessage(string);
                        try {
                            byArray = chatSession1_19_1.signChatMessage(messageMetadata, decoratableMessage, receivedMessagesStorage.lastSignatures());
                        }
                        catch (SignatureException signatureException) {
                            throw new RuntimeException(signatureException);
                        }
                        packetWrapper.write(Types.BYTE_ARRAY_PRIMITIVE, byArray);
                        packetWrapper.write(Types.BOOLEAN, decoratableMessage.isDecorated());
                    } else {
                        packetWrapper.write(Types.BYTE_ARRAY_PRIMITIVE, EMPTY_BYTES);
                        packetWrapper.write(Types.BOOLEAN, false);
                    }
                    receivedMessagesStorage.resetUnacknowledgedCount();
                    packetWrapper.write(Types.PLAYER_MESSAGE_SIGNATURE_ARRAY, receivedMessagesStorage.lastSignatures());
                    packetWrapper.write(Types.OPTIONAL_PLAYER_MESSAGE_SIGNATURE, null);
                });
                this.read(Types.VAR_INT);
                this.read(Types.ACKNOWLEDGED_BIT_SET);
            }
        });
        this.registerClientbound(State.LOGIN, ClientboundLoginPackets.HELLO, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.map(Types.BYTE_ARRAY_PRIMITIVE);
                this.handler(packetWrapper -> {
                    if (packetWrapper.user().has(ChatSession1_19_1.class)) {
                        packetWrapper.user().put(new NonceStorage1_19_3(packetWrapper.passthrough(Types.BYTE_ARRAY_PRIMITIVE)));
                    }
                });
            }
        });
        this.registerServerbound(State.LOGIN, ServerboundLoginPackets.HELLO, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.handler(packetWrapper -> {
                    ChatSession1_19_1 chatSession1_19_1 = packetWrapper.user().get(ChatSession1_19_1.class);
                    packetWrapper.write(Types.OPTIONAL_PROFILE_KEY, chatSession1_19_1 == null ? null : chatSession1_19_1.getProfileKey());
                });
                this.map(Types.OPTIONAL_UUID);
            }
        });
        this.registerServerbound(State.LOGIN, ServerboundLoginPackets.ENCRYPTION_KEY, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BYTE_ARRAY_PRIMITIVE);
                this.handler(packetWrapper -> {
                    ChatSession1_19_1 chatSession1_19_1 = packetWrapper.user().get(ChatSession1_19_1.class);
                    byte[] byArray = packetWrapper.read(Types.BYTE_ARRAY_PRIMITIVE);
                    packetWrapper.write(Types.BOOLEAN, chatSession1_19_1 == null);
                    if (chatSession1_19_1 != null) {
                        byte[] byArray2;
                        long l = ThreadLocalRandom.current().nextLong();
                        try {
                            byArray2 = chatSession1_19_1.sign(dataConsumer -> {
                                dataConsumer.accept(packetWrapper.user().remove(NonceStorage1_19_3.class).nonce());
                                dataConsumer.accept(Longs.toByteArray(l));
                            });
                        }
                        catch (SignatureException signatureException) {
                            throw new RuntimeException(signatureException);
                        }
                        packetWrapper.write(Types.LONG, l);
                        packetWrapper.write(Types.BYTE_ARRAY_PRIMITIVE, byArray2);
                    } else {
                        packetWrapper.write(Types.BYTE_ARRAY_PRIMITIVE, byArray);
                    }
                });
            }
        });
        this.cancelServerbound(ServerboundPackets1_19_3.CHAT_SESSION_UPDATE);
        this.cancelClientbound(ClientboundPackets1_19_1.DELETE_CHAT);
        this.cancelClientbound(ClientboundPackets1_19_1.PLAYER_CHAT_HEADER);
        this.cancelClientbound(ClientboundPackets1_19_1.CHAT_PREVIEW);
        this.cancelClientbound(ClientboundPackets1_19_1.SET_DISPLAY_CHAT_PREVIEW);
        this.cancelServerbound(ServerboundPackets1_19_3.CHAT_ACK);
    }

    @Override
    protected void onMappingDataLoaded() {
        EntityTypes1_19_3.initialize(this);
        ParticleType.Fillers.fill1_19(this, Types1_19_3.PARTICLE);
        this.tagRewriter.removeTag(RegistryType.ITEM, "minecraft:overworld_natural_logs");
        this.tagRewriter.removeTag(RegistryType.BLOCK, "minecraft:non_flammable_wood");
        super.onMappingDataLoaded();
    }

    @Override
    public void init(UserConnection userConnection) {
        userConnection.put(new ReceivedMessagesStorage());
        this.addEntityTracker(userConnection, new EntityTrackerBase(userConnection, EntityTypes1_19_3.PLAYER));
    }

    @Override
    public MappingData getMappingData() {
        return MAPPINGS;
    }

    public EntityPacketRewriter1_19_3 getEntityRewriter() {
        return this.entityRewriter;
    }

    public ItemPacketRewriter1_19_3 getItemRewriter() {
        return this.itemRewriter;
    }

    @Override
    public BlockRewriter<ClientboundPackets1_19_1> getBlockRewriter() {
        return this.blockRewriter;
    }

    @Override
    public ParticleRewriter<ClientboundPackets1_19_1> getParticleRewriter() {
        return this.particleRewriter;
    }

    @Override
    public ComponentRewriter1_19_3 getComponentRewriter() {
        return this.componentRewriter;
    }

    @Override
    public TagRewriter<ClientboundPackets1_19_1> getTagRewriter() {
        return this.tagRewriter;
    }

    private static int levelEventSoundId(int n) {
        return switch (n) {
            case 1005 -> 615;
            case 1006 -> 1346;
            case 1007 -> 1348;
            case 1008 -> 111;
            case 1011 -> 614;
            case 1012 -> 1345;
            case 1013 -> 1347;
            case 1014 -> 110;
            case 1036 -> 622;
            case 1037 -> 623;
            default -> -1;
        };
    }
}


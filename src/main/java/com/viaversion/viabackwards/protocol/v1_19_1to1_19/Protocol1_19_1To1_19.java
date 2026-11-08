/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_19_1to1_19;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.rewriters.text.JsonNBTComponentRewriter;
import com.viaversion.viabackwards.protocol.v1_19_1to1_19.rewriter.EntityPacketRewriter1_19_1;
import com.viaversion.viabackwards.protocol.v1_19_1to1_19.storage.ChatRegistryStorage;
import com.viaversion.viabackwards.protocol.v1_19_1to1_19.storage.ChatRegistryStorage1_19_1;
import com.viaversion.viabackwards.protocol.v1_19_1to1_19.storage.NonceStorage;
import com.viaversion.viabackwards.protocol.v1_19_1to1_19.storage.ReceivedMessagesStorage;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.PlayerMessageSignature;
import com.viaversion.viaversion.api.minecraft.ProfileKey;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_19;
import com.viaversion.viaversion.api.minecraft.signature.SignableCommandArgumentsProvider;
import com.viaversion.viaversion.api.minecraft.signature.model.DecoratableMessage;
import com.viaversion.viaversion.api.minecraft.signature.model.MessageMetadata;
import com.viaversion.viaversion.api.minecraft.signature.storage.ChatSession1_19_1;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.protocols.base.ClientboundLoginPackets;
import com.viaversion.viaversion.protocols.base.ServerboundLoginPackets;
import com.viaversion.viaversion.protocols.v1_18_2to1_19.Protocol1_18_2To1_19;
import com.viaversion.viaversion.protocols.v1_18_2to1_19.packet.ClientboundPackets1_19;
import com.viaversion.viaversion.protocols.v1_18_2to1_19.packet.ServerboundPackets1_19;
import com.viaversion.viaversion.protocols.v1_19to1_19_1.Protocol1_19To1_19_1;
import com.viaversion.viaversion.protocols.v1_19to1_19_1.packet.ClientboundPackets1_19_1;
import com.viaversion.viaversion.protocols.v1_19to1_19_1.packet.ServerboundPackets1_19_1;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.util.CipherUtil;
import com.viaversion.viaversion.util.ComponentUtil;
import com.viaversion.viaversion.util.Pair;
import com.viaversion.viaversion.util.TagUtil;
import java.security.SignatureException;
import java.util.List;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.Nullable;

public class Protocol1_19_1To1_19
extends BackwardsProtocol<ClientboundPackets1_19_1, ClientboundPackets1_19, ServerboundPackets1_19_1, ServerboundPackets1_19> {
    public static final int SYSTEM_CHAT_ID = 1;
    public static final int GAME_INFO_ID = 2;
    private static final UUID ZERO_UUID = new UUID(0L, 0L);
    private static final byte[] EMPTY_BYTES = new byte[0];
    private final EntityPacketRewriter1_19_1 entityRewriter = new EntityPacketRewriter1_19_1(this);
    private final JsonNBTComponentRewriter<ClientboundPackets1_19_1> translatableRewriter = new JsonNBTComponentRewriter<ClientboundPackets1_19_1>(this, ComponentRewriterBase.ReadType.JSON);

    public Protocol1_19_1To1_19() {
        super(ClientboundPackets1_19_1.class, ClientboundPackets1_19.class, ServerboundPackets1_19_1.class, ServerboundPackets1_19.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        this.registerClientbound(ClientboundPackets1_19_1.LOGIN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.BOOLEAN);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.STRING_ARRAY);
                this.map(Types.NAMED_COMPOUND_TAG);
                this.map(Types.STRING);
                this.map(Types.STRING);
                this.handler(packetWrapper -> {
                    ChatRegistryStorage chatRegistryStorage = packetWrapper.user().get(ChatRegistryStorage1_19_1.class);
                    chatRegistryStorage.clear();
                    CompoundTag compoundTag = packetWrapper.get(Types.NAMED_COMPOUND_TAG, 0);
                    ListTag<CompoundTag> listTag = TagUtil.removeRegistryEntries(compoundTag, "chat_type", new ListTag<CompoundTag>(CompoundTag.class));
                    for (CompoundTag compoundTag2 : listTag) {
                        NumberTag numberTag = compoundTag2.getNumberTag("id");
                        chatRegistryStorage.addChatType(numberTag.asInt(), compoundTag2);
                    }
                    compoundTag.put("minecraft:chat_type", Protocol1_18_2To1_19.MAPPINGS.chatRegistry());
                    Protocol1_19_1To1_19.this.entityRewriter.trackWorld(packetWrapper.user(), packetWrapper.get(Types.STRING, 1));
                });
            }
        });
        this.registerClientbound(ClientboundPackets1_19_1.PLAYER_CHAT, ClientboundPackets1_19.SYSTEM_CHAT, (PacketWrapper packetWrapper) -> {
            int n;
            Object object;
            Object object2;
            packetWrapper.read(Types.OPTIONAL_BYTE_ARRAY_PRIMITIVE);
            PlayerMessageSignature playerMessageSignature = packetWrapper.read(Types.PLAYER_MESSAGE_SIGNATURE);
            if (!playerMessageSignature.uuid().equals(ZERO_UUID) && playerMessageSignature.signatureBytes().length != 0) {
                object2 = packetWrapper.user().get(ReceivedMessagesStorage.class);
                ((ReceivedMessagesStorage)object2).add(playerMessageSignature);
                if (((ReceivedMessagesStorage)object2).tickUnacknowledged() > 64) {
                    ((ReceivedMessagesStorage)object2).resetUnacknowledgedCount();
                    object = packetWrapper.create(ServerboundPackets1_19_1.CHAT_ACK);
                    object.write(Types.PLAYER_MESSAGE_SIGNATURE_ARRAY, ((ReceivedMessagesStorage)object2).lastSignatures());
                    object.write(Types.OPTIONAL_PLAYER_MESSAGE_SIGNATURE, null);
                    object.sendToServer(Protocol1_19_1To1_19.class);
                }
            }
            object2 = packetWrapper.read(Types.STRING);
            object = null;
            JsonElement jsonElement = packetWrapper.read(Types.OPTIONAL_COMPONENT);
            if (jsonElement != null) {
                object = jsonElement;
            }
            packetWrapper.read(Types.LONG);
            packetWrapper.read(Types.LONG);
            packetWrapper.read(Types.PLAYER_MESSAGE_SIGNATURE_ARRAY);
            JsonElement jsonElement2 = packetWrapper.read(Types.OPTIONAL_COMPONENT);
            if (jsonElement2 != null) {
                object = jsonElement2;
            }
            if (object == null) {
                object = ComponentUtil.plainToJson((String)object2);
            }
            if ((n = packetWrapper.read(Types.VAR_INT).intValue()) == 2) {
                packetWrapper.read(Types.LONG_ARRAY_PRIMITIVE);
            }
            int n2 = packetWrapper.read(Types.VAR_INT);
            JsonElement jsonElement3 = packetWrapper.read(Types.COMPONENT);
            JsonElement jsonElement4 = packetWrapper.read(Types.OPTIONAL_COMPONENT);
            jsonElement = Protocol1_19_1To1_19.decorateChatMessage(this, packetWrapper.user().get(ChatRegistryStorage1_19_1.class), n2, jsonElement3, jsonElement4, (JsonElement)object);
            if (jsonElement == null) {
                packetWrapper.cancel();
                return;
            }
            this.translatableRewriter.processText(packetWrapper.user(), jsonElement);
            packetWrapper.write(Types.COMPONENT, jsonElement);
            packetWrapper.write(Types.VAR_INT, 1);
        });
        this.replaceClientbound(ClientboundPackets1_19_1.SYSTEM_CHAT, packetWrapper -> {
            JsonElement jsonElement = packetWrapper.passthrough(Types.COMPONENT);
            this.translatableRewriter.processText(packetWrapper.user(), jsonElement);
            boolean bl = packetWrapper.read(Types.BOOLEAN);
            packetWrapper.write(Types.VAR_INT, bl ? 2 : 1);
        });
        this.registerServerbound(ServerboundPackets1_19.CHAT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.map(Types.LONG);
                this.map(Types.LONG);
                this.read(Types.BYTE_ARRAY_PRIMITIVE);
                this.read(Types.BOOLEAN);
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
            }
        });
        this.registerServerbound(ServerboundPackets1_19.CHAT_COMMAND, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.map(Types.LONG);
                this.map(Types.LONG);
                this.handler(packetWrapper -> {
                    ReceivedMessagesStorage receivedMessagesStorage = packetWrapper.user().get(ReceivedMessagesStorage.class);
                    ChatSession1_19_1 chatSession1_19_1 = packetWrapper.user().get(ChatSession1_19_1.class);
                    SignableCommandArgumentsProvider signableCommandArgumentsProvider = Via.getManager().getProviders().get(SignableCommandArgumentsProvider.class);
                    if (chatSession1_19_1 != null && signableCommandArgumentsProvider != null) {
                        int n = packetWrapper.read(Types.VAR_INT);
                        for (int i = 0; i < n; ++i) {
                            packetWrapper.read(Types.STRING);
                            packetWrapper.read(Types.BYTE_ARRAY_PRIMITIVE);
                        }
                        UUID uUID = packetWrapper.user().getProtocolInfo().getUuid();
                        String string = packetWrapper.get(Types.STRING, 0);
                        long l = packetWrapper.get(Types.LONG, 0);
                        long l2 = packetWrapper.get(Types.LONG, 1);
                        MessageMetadata messageMetadata = new MessageMetadata(uUID, l, l2);
                        List<Pair<String, String>> list = signableCommandArgumentsProvider.getSignableArguments(string);
                        packetWrapper.write(Types.VAR_INT, list.size());
                        for (Pair<String, String> pair : list) {
                            byte[] byArray;
                            try {
                                byArray = chatSession1_19_1.signChatMessage(messageMetadata, new DecoratableMessage(pair.value()), receivedMessagesStorage.lastSignatures());
                            }
                            catch (SignatureException signatureException) {
                                throw new RuntimeException(signatureException);
                            }
                            packetWrapper.write(Types.STRING, pair.key());
                            packetWrapper.write(Types.BYTE_ARRAY_PRIMITIVE, byArray);
                        }
                    } else {
                        int n = packetWrapper.passthrough(Types.VAR_INT);
                        for (int i = 0; i < n; ++i) {
                            packetWrapper.passthrough(Types.STRING);
                            packetWrapper.read(Types.BYTE_ARRAY_PRIMITIVE);
                            packetWrapper.write(Types.BYTE_ARRAY_PRIMITIVE, EMPTY_BYTES);
                        }
                    }
                    packetWrapper.passthrough(Types.BOOLEAN);
                    receivedMessagesStorage.resetUnacknowledgedCount();
                    packetWrapper.write(Types.PLAYER_MESSAGE_SIGNATURE_ARRAY, receivedMessagesStorage.lastSignatures());
                    packetWrapper.write(Types.OPTIONAL_PLAYER_MESSAGE_SIGNATURE, null);
                });
            }
        });
        this.replaceClientbound(ClientboundPackets1_19_1.SERVER_DATA, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.OPTIONAL_COMPONENT);
                this.map(Types.OPTIONAL_STRING);
                this.map(Types.BOOLEAN);
                this.read(Types.BOOLEAN);
            }
        });
        this.registerServerbound(State.LOGIN, ServerboundLoginPackets.HELLO, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.handler(packetWrapper -> {
                    ProfileKey profileKey = packetWrapper.read(Types.OPTIONAL_PROFILE_KEY);
                    ChatSession1_19_1 chatSession1_19_1 = packetWrapper.user().get(ChatSession1_19_1.class);
                    packetWrapper.write(Types.OPTIONAL_PROFILE_KEY, chatSession1_19_1 == null ? null : chatSession1_19_1.getProfileKey());
                    packetWrapper.write(Types.OPTIONAL_UUID, chatSession1_19_1 == null ? null : chatSession1_19_1.getUuid());
                    if (profileKey == null || chatSession1_19_1 != null) {
                        packetWrapper.user().put(new NonceStorage(null));
                    }
                });
            }
        });
        this.registerClientbound(State.LOGIN, ClientboundLoginPackets.HELLO, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.handler(packetWrapper -> {
                    if (packetWrapper.user().has(NonceStorage.class)) {
                        return;
                    }
                    byte[] byArray = packetWrapper.passthrough(Types.BYTE_ARRAY_PRIMITIVE);
                    byte[] byArray2 = packetWrapper.passthrough(Types.BYTE_ARRAY_PRIMITIVE);
                    packetWrapper.user().put(new NonceStorage(CipherUtil.encryptNonce(byArray, byArray2)));
                });
            }
        });
        this.registerServerbound(State.LOGIN, ServerboundLoginPackets.ENCRYPTION_KEY, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BYTE_ARRAY_PRIMITIVE);
                this.handler(packetWrapper -> {
                    NonceStorage nonceStorage = packetWrapper.user().remove(NonceStorage.class);
                    if (nonceStorage.nonce() == null) {
                        return;
                    }
                    boolean bl = packetWrapper.read(Types.BOOLEAN);
                    packetWrapper.write(Types.BOOLEAN, true);
                    if (!bl) {
                        packetWrapper.read(Types.LONG);
                        packetWrapper.read(Types.BYTE_ARRAY_PRIMITIVE);
                        packetWrapper.write(Types.BYTE_ARRAY_PRIMITIVE, nonceStorage.nonce());
                    }
                });
            }
        });
        this.registerClientbound(State.LOGIN, ClientboundLoginPackets.CUSTOM_QUERY, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.STRING);
                this.handler(packetWrapper -> {
                    String string = packetWrapper.get(Types.STRING, 0);
                    if (string.equals("velocity:player_info")) {
                        byte[] byArray = packetWrapper.passthrough(Types.REMAINING_BYTES);
                        if (byArray.length == 1 && byArray[0] > 1) {
                            byArray[0] = 1;
                        } else if (byArray.length == 0) {
                            byArray = new byte[]{1};
                            packetWrapper.set(Types.REMAINING_BYTES, 0, byArray);
                        } else {
                            Protocol1_19_1To1_19.this.getLogger().warning("Received unexpected data in velocity:player_info (length=" + byArray.length + ")");
                        }
                    }
                });
            }
        });
        this.cancelClientbound(ClientboundPackets1_19_1.CUSTOM_CHAT_COMPLETIONS);
        this.cancelClientbound(ClientboundPackets1_19_1.DELETE_CHAT);
        this.cancelClientbound(ClientboundPackets1_19_1.PLAYER_CHAT_HEADER);
    }

    @Override
    public void init(UserConnection userConnection) {
        userConnection.put(new ChatRegistryStorage1_19_1());
        userConnection.put(new ReceivedMessagesStorage());
        this.addEntityTracker(userConnection, new EntityTrackerBase(userConnection, EntityTypes1_19.PLAYER));
    }

    @Override
    public JsonNBTComponentRewriter<ClientboundPackets1_19_1> getComponentRewriter() {
        return this.translatableRewriter;
    }

    public EntityPacketRewriter1_19_1 getEntityRewriter() {
        return this.entityRewriter;
    }

    public static @Nullable JsonElement decorateChatMessage(Protocol protocol, ChatRegistryStorage chatRegistryStorage, int n, JsonElement jsonElement, @Nullable JsonElement jsonElement2, JsonElement jsonElement3) {
        CompoundTag compoundTag = chatRegistryStorage.chatType(n);
        if (compoundTag == null) {
            protocol.getLogger().warning("Chat message has unknown chat type id " + n + ". Message: " + String.valueOf(jsonElement3));
            return null;
        }
        if ((compoundTag = compoundTag.getCompoundTag("element").getCompoundTag("chat")) == null) {
            return null;
        }
        return Protocol1_19To1_19_1.translatabaleComponentFromTag(compoundTag, jsonElement, jsonElement2, jsonElement3);
    }
}


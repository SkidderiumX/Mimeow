/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_19to1_19_1;

import com.google.common.base.Preconditions;
import com.viaversion.nbt.tag.ByteTag;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.ProfileKey;
import com.viaversion.viaversion.api.minecraft.signature.SignableCommandArgumentsProvider;
import com.viaversion.viaversion.api.minecraft.signature.model.DecoratableMessage;
import com.viaversion.viaversion.api.minecraft.signature.model.MessageMetadata;
import com.viaversion.viaversion.api.minecraft.signature.storage.ChatSession1_19_0;
import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.mcstructs.text.Style;
import com.viaversion.viaversion.libs.mcstructs.text.TextFormatting;
import com.viaversion.viaversion.libs.mcstructs.text.components.TranslationComponent;
import com.viaversion.viaversion.protocols.base.ClientboundLoginPackets;
import com.viaversion.viaversion.protocols.base.ServerboundLoginPackets;
import com.viaversion.viaversion.protocols.v1_18_2to1_19.packet.ClientboundPackets1_19;
import com.viaversion.viaversion.protocols.v1_18_2to1_19.packet.ServerboundPackets1_19;
import com.viaversion.viaversion.protocols.v1_19to1_19_1.data.ChatDecorationResult;
import com.viaversion.viaversion.protocols.v1_19to1_19_1.data.ChatRegistry1_19_1;
import com.viaversion.viaversion.protocols.v1_19to1_19_1.packet.ClientboundPackets1_19_1;
import com.viaversion.viaversion.protocols.v1_19to1_19_1.packet.ServerboundPackets1_19_1;
import com.viaversion.viaversion.protocols.v1_19to1_19_1.storage.ChatTypeStorage;
import com.viaversion.viaversion.protocols.v1_19to1_19_1.storage.NonceStorage1_19_1;
import com.viaversion.viaversion.util.CipherUtil;
import com.viaversion.viaversion.util.Pair;
import com.viaversion.viaversion.util.ProtocolLogger;
import com.viaversion.viaversion.util.SerializerVersion;
import com.viaversion.viaversion.util.TagUtil;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.Nullable;

public class Protocol1_19To1_19_1
extends AbstractProtocol<ClientboundPackets1_19, ClientboundPackets1_19_1, ServerboundPackets1_19, ServerboundPackets1_19_1> {
    public static final ProtocolLogger LOGGER = new ProtocolLogger(Protocol1_19To1_19_1.class);

    public Protocol1_19To1_19_1() {
        super(ClientboundPackets1_19.class, ClientboundPackets1_19_1.class, ServerboundPackets1_19.class, ServerboundPackets1_19_1.class);
    }

    @Override
    protected void registerPackets() {
        this.registerClientbound(ClientboundPackets1_19.SYSTEM_CHAT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.COMPONENT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.read(Types.VAR_INT);
                    boolean bl = n == 2;
                    packetWrapper.write(Types.BOOLEAN, bl);
                });
            }
        });
        this.registerClientbound(ClientboundPackets1_19.PLAYER_CHAT, ClientboundPackets1_19_1.SYSTEM_CHAT, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.handler(packetWrapper -> {
                    JsonElement jsonElement = packetWrapper.read(Types.COMPONENT);
                    JsonElement jsonElement2 = packetWrapper.read(Types.OPTIONAL_COMPONENT);
                    int n = packetWrapper.read(Types.VAR_INT);
                    packetWrapper.read(Types.UUID);
                    JsonElement jsonElement3 = packetWrapper.read(Types.COMPONENT);
                    JsonElement jsonElement4 = packetWrapper.read(Types.OPTIONAL_COMPONENT);
                    CompoundTag compoundTag = packetWrapper.user().get(ChatTypeStorage.class).chatType(n);
                    ChatDecorationResult chatDecorationResult = Protocol1_19To1_19_1.decorateChatMessage(compoundTag, n, jsonElement3, jsonElement4, jsonElement2 != null ? jsonElement2 : jsonElement);
                    if (chatDecorationResult == null) {
                        packetWrapper.cancel();
                        return;
                    }
                    packetWrapper.write(Types.COMPONENT, chatDecorationResult.content());
                    packetWrapper.write(Types.BOOLEAN, chatDecorationResult.overlay());
                });
                this.read(Types.LONG);
                this.read(Types.LONG);
                this.read(Types.BYTE_ARRAY_PRIMITIVE);
            }
        });
        this.registerServerbound(ServerboundPackets1_19_1.CHAT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.map(Types.LONG);
                this.map(Types.LONG);
                this.map(Types.BYTE_ARRAY_PRIMITIVE);
                this.map(Types.BOOLEAN);
                this.handler(packetWrapper -> {
                    ChatSession1_19_0 chatSession1_19_0 = packetWrapper.user().get(ChatSession1_19_0.class);
                    if (chatSession1_19_0 != null) {
                        byte[] byArray;
                        UUID uUID = packetWrapper.user().getProtocolInfo().getUuid();
                        String string = packetWrapper.get(Types.STRING, 0);
                        long l = packetWrapper.get(Types.LONG, 0);
                        long l2 = packetWrapper.get(Types.LONG, 1);
                        MessageMetadata messageMetadata = new MessageMetadata(uUID, l, l2);
                        DecoratableMessage decoratableMessage = new DecoratableMessage(string);
                        try {
                            byArray = chatSession1_19_0.signChatMessage(messageMetadata, decoratableMessage);
                        }
                        catch (SignatureException signatureException) {
                            throw new RuntimeException(signatureException);
                        }
                        packetWrapper.set(Types.BYTE_ARRAY_PRIMITIVE, 0, byArray);
                        packetWrapper.set(Types.BOOLEAN, 0, decoratableMessage.isDecorated());
                    }
                });
                this.read(Types.PLAYER_MESSAGE_SIGNATURE_ARRAY);
                this.read(Types.OPTIONAL_PLAYER_MESSAGE_SIGNATURE);
            }
        });
        this.registerServerbound(ServerboundPackets1_19_1.CHAT_COMMAND, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.map(Types.LONG);
                this.map(Types.LONG);
                this.handler(packetWrapper -> {
                    ChatSession1_19_0 chatSession1_19_0 = packetWrapper.user().get(ChatSession1_19_0.class);
                    SignableCommandArgumentsProvider signableCommandArgumentsProvider = Via.getManager().getProviders().get(SignableCommandArgumentsProvider.class);
                    int n = packetWrapper.read(Types.VAR_INT);
                    for (int i = 0; i < n; ++i) {
                        packetWrapper.read(Types.STRING);
                        packetWrapper.read(Types.BYTE_ARRAY_PRIMITIVE);
                    }
                    if (chatSession1_19_0 != null && signableCommandArgumentsProvider != null) {
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
                                byArray = chatSession1_19_0.signChatMessage(messageMetadata, decoratableMessage);
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
                });
                this.map(Types.BOOLEAN);
                this.read(Types.PLAYER_MESSAGE_SIGNATURE_ARRAY);
                this.read(Types.OPTIONAL_PLAYER_MESSAGE_SIGNATURE);
            }
        });
        this.cancelServerbound(ServerboundPackets1_19_1.CHAT_ACK);
        this.registerClientbound(ClientboundPackets1_19.LOGIN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.BOOLEAN);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.STRING_ARRAY);
                this.handler(packetWrapper -> {
                    ChatTypeStorage chatTypeStorage = packetWrapper.user().get(ChatTypeStorage.class);
                    chatTypeStorage.clear();
                    CompoundTag compoundTag = packetWrapper.passthrough(Types.NAMED_COMPOUND_TAG);
                    ListTag<CompoundTag> listTag = TagUtil.removeRegistryEntries(compoundTag, "chat_type");
                    for (CompoundTag compoundTag2 : listTag) {
                        NumberTag numberTag = compoundTag2.getNumberTag("id");
                        chatTypeStorage.addChatType(numberTag.asInt(), compoundTag2);
                    }
                    compoundTag.put("minecraft:chat_type", ChatRegistry1_19_1.chatRegistry());
                });
            }
        });
        this.registerClientbound(ClientboundPackets1_19.SERVER_DATA, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.OPTIONAL_COMPONENT);
                this.map(Types.OPTIONAL_STRING);
                this.map(Types.BOOLEAN);
                this.create(Types.BOOLEAN, Via.getConfig().enforceSecureChat());
            }
        });
        this.registerServerbound(State.LOGIN, ServerboundLoginPackets.HELLO, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.handler(packetWrapper -> {
                    ProfileKey profileKey = packetWrapper.read(Types.OPTIONAL_PROFILE_KEY);
                    ChatSession1_19_0 chatSession1_19_0 = packetWrapper.user().get(ChatSession1_19_0.class);
                    packetWrapper.write(Types.OPTIONAL_PROFILE_KEY, chatSession1_19_0 == null ? null : chatSession1_19_0.getProfileKey());
                    if (profileKey == null || chatSession1_19_0 != null) {
                        packetWrapper.user().put(new NonceStorage1_19_1(null));
                    }
                });
                this.read(Types.OPTIONAL_UUID);
            }
        });
        this.registerClientbound(State.LOGIN, ClientboundLoginPackets.HELLO, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.handler(packetWrapper -> {
                    if (packetWrapper.user().has(NonceStorage1_19_1.class)) {
                        return;
                    }
                    byte[] byArray = packetWrapper.passthrough(Types.BYTE_ARRAY_PRIMITIVE);
                    byte[] byArray2 = packetWrapper.passthrough(Types.BYTE_ARRAY_PRIMITIVE);
                    packetWrapper.user().put(new NonceStorage1_19_1(CipherUtil.encryptNonce(byArray, byArray2)));
                });
            }
        });
        this.registerServerbound(State.LOGIN, ServerboundLoginPackets.ENCRYPTION_KEY, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BYTE_ARRAY_PRIMITIVE);
                this.handler(packetWrapper -> {
                    NonceStorage1_19_1 nonceStorage1_19_1 = packetWrapper.user().remove(NonceStorage1_19_1.class);
                    if (nonceStorage1_19_1.nonce() == null) {
                        return;
                    }
                    boolean bl = packetWrapper.read(Types.BOOLEAN);
                    packetWrapper.write(Types.BOOLEAN, true);
                    if (!bl) {
                        packetWrapper.read(Types.LONG);
                        packetWrapper.read(Types.BYTE_ARRAY_PRIMITIVE);
                        packetWrapper.write(Types.BYTE_ARRAY_PRIMITIVE, nonceStorage1_19_1.nonce());
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
                            LOGGER.warning("Received unexpected data in velocity:player_info (length=" + byArray.length + ")");
                        }
                    }
                });
            }
        });
    }

    @Override
    public void init(UserConnection userConnection) {
        userConnection.put(new ChatTypeStorage());
    }

    @Override
    public ProtocolLogger getLogger() {
        return LOGGER;
    }

    public static @Nullable ChatDecorationResult decorateChatMessage(CompoundTag compoundTag, int n, JsonElement jsonElement, @Nullable JsonElement jsonElement2, JsonElement jsonElement3) {
        CompoundTag compoundTag2;
        if (compoundTag == null) {
            LOGGER.warning("Chat message has unknown chat type id " + n + ". Message: " + String.valueOf(jsonElement3));
            return null;
        }
        CompoundTag compoundTag3 = compoundTag.getCompoundTag("element").getCompoundTag("chat");
        boolean bl = false;
        if (compoundTag3 == null) {
            compoundTag3 = compoundTag.getCompoundTag("element").getCompoundTag("overlay");
            if (compoundTag3 == null) {
                return null;
            }
            bl = true;
        }
        if ((compoundTag2 = compoundTag3.getCompoundTag("decoration")) == null) {
            return new ChatDecorationResult(jsonElement3, bl);
        }
        return new ChatDecorationResult(Protocol1_19To1_19_1.translatabaleComponentFromTag(compoundTag2, jsonElement, jsonElement2, jsonElement3), bl);
    }

    public static JsonElement translatabaleComponentFromTag(CompoundTag compoundTag, JsonElement jsonElement, @Nullable JsonElement jsonElement2, JsonElement jsonElement3) {
        Tag tag;
        Iterator<Map.Entry<String, TextFormatting>> iterator2;
        Tag tag2;
        String string = compoundTag.getStringTag("translation_key").getValue();
        Style style = new Style();
        CompoundTag compoundTag2 = compoundTag.getCompoundTag("style");
        if (compoundTag2 != null) {
            tag2 = compoundTag2.getStringTag("color");
            if (tag2 != null && (iterator2 = TextFormatting.getByName(((StringTag)tag2).getValue())) != null) {
                style.setFormatting((TextFormatting)((Object)iterator2));
            }
            for (Map.Entry<String, TextFormatting> entry : TextFormatting.FORMATTINGS.entrySet()) {
                tag = compoundTag2.getNumberTag((String)entry.getKey());
                if (!(tag instanceof ByteTag)) continue;
                boolean bl = tag.asBoolean();
                Object object = (TextFormatting)entry.getValue();
                if (object == TextFormatting.OBFUSCATED) {
                    style.setObfuscated(bl);
                    continue;
                }
                if (object == TextFormatting.BOLD) {
                    style.setBold(bl);
                    continue;
                }
                if (object == TextFormatting.STRIKETHROUGH) {
                    style.setStrikethrough(bl);
                    continue;
                }
                if (object == TextFormatting.UNDERLINE) {
                    style.setUnderlined(bl);
                    continue;
                }
                if (object != TextFormatting.ITALIC) continue;
                style.setItalic(bl);
            }
        }
        tag2 = compoundTag.getListTag("parameters", StringTag.class);
        iterator2 = new ArrayList();
        if (tag2 != null) {
            Map.Entry<String, TextFormatting> entry;
            entry = ((ListTag)tag2).iterator();
            while (entry.hasNext()) {
                tag = (StringTag)entry.next();
                JsonElement jsonElement4 = null;
                switch (((StringTag)tag).getValue()) {
                    case "sender": {
                        jsonElement4 = jsonElement;
                        break;
                    }
                    case "content": {
                        jsonElement4 = jsonElement3;
                        break;
                    }
                    case "team_name": 
                    case "target": {
                        Preconditions.checkNotNull(jsonElement2, "Team name is null");
                        jsonElement4 = jsonElement2;
                        break;
                    }
                    default: {
                        LOGGER.warning("Unknown parameter for chat decoration: " + ((StringTag)tag).getValue());
                    }
                }
                if (jsonElement4 == null) continue;
                iterator2.add((Map.Entry<String, TextFormatting>)((Object)SerializerVersion.V1_18.toComponent(jsonElement4)));
            }
        }
        return SerializerVersion.V1_18.toJson(new TranslationComponent(string, (List<?>)((Object)iterator2)));
    }
}


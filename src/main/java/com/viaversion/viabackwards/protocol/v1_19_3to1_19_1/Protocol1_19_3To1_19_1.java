/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_19_3to1_19_1;

import com.google.common.base.Preconditions;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.data.BackwardsMappingData;
import com.viaversion.viabackwards.api.rewriters.text.JsonNBTComponentRewriter;
import com.viaversion.viabackwards.protocol.v1_19_1to1_19.Protocol1_19_1To1_19;
import com.viaversion.viabackwards.protocol.v1_19_3to1_19_1.rewriter.BlockItemPacketRewriter1_19_3;
import com.viaversion.viabackwards.protocol.v1_19_3to1_19_1.rewriter.EntityPacketRewriter1_19_3;
import com.viaversion.viabackwards.protocol.v1_19_3to1_19_1.storage.ChatSessionStorage;
import com.viaversion.viabackwards.protocol.v1_19_3to1_19_1.storage.ChatTypeStorage1_19_3;
import com.viaversion.viabackwards.protocol.v1_19_3to1_19_1.storage.NonceStorage;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.PlayerMessageSignature;
import com.viaversion.viaversion.api.minecraft.ProfileKey;
import com.viaversion.viaversion.api.minecraft.RegistryType;
import com.viaversion.viaversion.api.minecraft.SoundEvent;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_19_3;
import com.viaversion.viaversion.api.minecraft.signature.SignableCommandArgumentsProvider;
import com.viaversion.viaversion.api.minecraft.signature.model.MessageMetadata;
import com.viaversion.viaversion.api.minecraft.signature.storage.ChatSession1_19_3;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.BitSetType;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_18;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.protocols.base.ClientboundLoginPackets;
import com.viaversion.viaversion.protocols.base.ServerboundLoginPackets;
import com.viaversion.viaversion.protocols.v1_19_1to1_19_3.Protocol1_19_1To1_19_3;
import com.viaversion.viaversion.protocols.v1_19_1to1_19_3.packet.ClientboundPackets1_19_3;
import com.viaversion.viaversion.protocols.v1_19_1to1_19_3.packet.ServerboundPackets1_19_3;
import com.viaversion.viaversion.protocols.v1_19to1_19_1.packet.ClientboundPackets1_19_1;
import com.viaversion.viaversion.protocols.v1_19to1_19_1.packet.ServerboundPackets1_19_1;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.CommandRewriter;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.util.CipherUtil;
import com.viaversion.viaversion.util.ComponentUtil;
import com.viaversion.viaversion.util.Pair;
import java.security.SignatureException;
import java.util.BitSet;
import java.util.Iterator;
import org.checkerframework.checker.nullness.qual.Nullable;

public class Protocol1_19_3To1_19_1
extends BackwardsProtocol<ClientboundPackets1_19_3, ClientboundPackets1_19_1, ServerboundPackets1_19_3, ServerboundPackets1_19_1> {
    public static final BackwardsMappingData MAPPINGS = new BackwardsMappingData("1.19.3", "1.19", Protocol1_19_1To1_19_3.class);
    private final EntityPacketRewriter1_19_3 entityRewriter = new EntityPacketRewriter1_19_3(this);
    private final BlockItemPacketRewriter1_19_3 itemRewriter = new BlockItemPacketRewriter1_19_3(this);
    private final ParticleRewriter<ClientboundPackets1_19_3> particleRewriter = new ParticleRewriter<ClientboundPackets1_19_3>(this);
    private final JsonNBTComponentRewriter<ClientboundPackets1_19_3> translatableRewriter = new JsonNBTComponentRewriter<ClientboundPackets1_19_3>(this, ComponentRewriterBase.ReadType.JSON);
    private final TagRewriter<ClientboundPackets1_19_3> tagRewriter = new TagRewriter<ClientboundPackets1_19_3>(this);
    private final BlockRewriter<ClientboundPackets1_19_3> blockRewriter = BlockRewriter.for1_18(this, ChunkType1_18::new);

    public Protocol1_19_3To1_19_1() {
        super(ClientboundPackets1_19_3.class, ClientboundPackets1_19_1.class, ServerboundPackets1_19_3.class, ServerboundPackets1_19_1.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        this.replaceClientbound(ClientboundPackets1_19_3.SOUND, packetWrapper -> {
            String string = this.rewriteSound(packetWrapper);
            if (string != null) {
                packetWrapper.write(Types.STRING, string);
                packetWrapper.setPacketType(ClientboundPackets1_19_1.CUSTOM_SOUND);
            }
        });
        this.replaceClientbound(ClientboundPackets1_19_3.SOUND_ENTITY, packetWrapper -> {
            String string = this.rewriteSound(packetWrapper);
            if (string == null) {
                return;
            }
            int n = MAPPINGS.getFullSoundMappings().mappedId(string);
            if (n == -1) {
                packetWrapper.cancel();
                return;
            }
            packetWrapper.write(Types.VAR_INT, n);
        });
        this.tagRewriter.addEmptyTag(RegistryType.BLOCK, "minecraft:non_flammable_wood");
        this.tagRewriter.addEmptyTag(RegistryType.ITEM, "minecraft:overworld_natural_logs");
        CommandRewriter<ClientboundPackets1_19_3> commandRewriter = new CommandRewriter<ClientboundPackets1_19_3>(this);
        this.replaceClientbound(ClientboundPackets1_19_3.COMMANDS, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n; ++i) {
                int n2;
                byte by = packetWrapper.passthrough(Types.BYTE);
                packetWrapper.passthrough(Types.VAR_INT_ARRAY_PRIMITIVE);
                if ((by & 8) != 0) {
                    packetWrapper.passthrough(Types.VAR_INT);
                }
                if ((n2 = by & 3) == 1 || n2 == 2) {
                    packetWrapper.passthrough(Types.STRING);
                }
                if (n2 != 2) continue;
                int n3 = packetWrapper.read(Types.VAR_INT);
                int n4 = MAPPINGS.getArgumentTypeMappings().getNewId(n3);
                Preconditions.checkArgument(n4 != -1, "Unknown command argument type id: " + n3);
                packetWrapper.write(Types.VAR_INT, n4);
                String string = MAPPINGS.getArgumentTypeMappings().identifier(n3);
                commandRewriter.handleArgument(packetWrapper, string);
                if (string.equals("minecraft:gamemode")) {
                    packetWrapper.write(Types.VAR_INT, 0);
                }
                if ((by & 0x10) == 0) continue;
                packetWrapper.passthrough(Types.STRING);
            }
            packetWrapper.passthrough(Types.VAR_INT);
        });
        this.replaceClientbound(ClientboundPackets1_19_3.SERVER_DATA, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.OPTIONAL_COMPONENT);
                this.map(Types.OPTIONAL_STRING);
                this.create(Types.BOOLEAN, false);
            }
        });
        this.registerServerbound(State.LOGIN, ServerboundLoginPackets.HELLO, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.handler(packetWrapper -> {
                    ProfileKey profileKey = packetWrapper.read(Types.OPTIONAL_PROFILE_KEY);
                    if (profileKey == null) {
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
                    boolean bl = packetWrapper.read(Types.BOOLEAN);
                    if (!bl) {
                        packetWrapper.read(Types.LONG);
                        packetWrapper.read(Types.BYTE_ARRAY_PRIMITIVE);
                        packetWrapper.write(Types.BYTE_ARRAY_PRIMITIVE, nonceStorage.nonce() != null ? nonceStorage.nonce() : new byte[]{});
                    }
                });
            }
        });
        this.registerServerbound(ServerboundPackets1_19_1.CHAT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.map(Types.LONG);
                this.map(Types.LONG);
                this.read(Types.BYTE_ARRAY_PRIMITIVE);
                this.read(Types.BOOLEAN);
                this.read(Types.PLAYER_MESSAGE_SIGNATURE_ARRAY);
                this.read(Types.OPTIONAL_PLAYER_MESSAGE_SIGNATURE);
                this.handler(packetWrapper -> {
                    ChatSession1_19_3 chatSession1_19_3 = packetWrapper.user().get(ChatSession1_19_3.class);
                    if (chatSession1_19_3 != null) {
                        byte[] byArray;
                        String string = packetWrapper.get(Types.STRING, 0);
                        long l = packetWrapper.get(Types.LONG, 0);
                        long l2 = packetWrapper.get(Types.LONG, 1);
                        MessageMetadata messageMetadata = new MessageMetadata(null, l, l2);
                        try {
                            byArray = chatSession1_19_3.signChatMessage(messageMetadata, string, new PlayerMessageSignature[0]);
                        }
                        catch (SignatureException signatureException) {
                            throw new RuntimeException(signatureException);
                        }
                        packetWrapper.write(Types.OPTIONAL_SIGNATURE_BYTES, byArray);
                    } else {
                        packetWrapper.write(Types.OPTIONAL_SIGNATURE_BYTES, null);
                    }
                    packetWrapper.write(Types.VAR_INT, 0);
                    packetWrapper.write(new BitSetType(20), new BitSet(20));
                });
            }
        });
        this.registerServerbound(ServerboundPackets1_19_1.CHAT_COMMAND, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.map(Types.LONG);
                this.map(Types.LONG);
                this.handler(packetWrapper -> {
                    Object object;
                    ChatSession1_19_3 chatSession1_19_3 = packetWrapper.user().get(ChatSession1_19_3.class);
                    SignableCommandArgumentsProvider signableCommandArgumentsProvider = Via.getManager().getProviders().get(SignableCommandArgumentsProvider.class);
                    String string = packetWrapper.get(Types.STRING, 0);
                    long l = packetWrapper.get(Types.LONG, 0);
                    long l2 = packetWrapper.get(Types.LONG, 1);
                    int n = packetWrapper.read(Types.VAR_INT);
                    for (int i = 0; i < n; ++i) {
                        packetWrapper.read(Types.STRING);
                        packetWrapper.read(Types.BYTE_ARRAY_PRIMITIVE);
                    }
                    packetWrapper.read(Types.BOOLEAN);
                    if (chatSession1_19_3 != null && signableCommandArgumentsProvider != null) {
                        MessageMetadata messageMetadata = new MessageMetadata(null, l, l2);
                        object = signableCommandArgumentsProvider.getSignableArguments(string);
                        packetWrapper.write(Types.VAR_INT, object.size());
                        Iterator iterator2 = object.iterator();
                        while (iterator2.hasNext()) {
                            byte[] byArray;
                            Pair pair = (Pair)iterator2.next();
                            try {
                                byArray = chatSession1_19_3.signChatMessage(messageMetadata, (String)pair.value(), new PlayerMessageSignature[0]);
                            }
                            catch (SignatureException signatureException) {
                                throw new RuntimeException(signatureException);
                            }
                            packetWrapper.write(Types.STRING, (String)pair.key());
                            packetWrapper.write(Types.SIGNATURE_BYTES, byArray);
                        }
                    } else {
                        packetWrapper.write(Types.VAR_INT, 0);
                    }
                    boolean bl = false;
                    object = new BitSet(20);
                    packetWrapper.write(Types.VAR_INT, 0);
                    packetWrapper.write(new BitSetType(20), object);
                });
                this.read(Types.PLAYER_MESSAGE_SIGNATURE_ARRAY);
                this.read(Types.OPTIONAL_PLAYER_MESSAGE_SIGNATURE);
            }
        });
        this.registerClientbound(ClientboundPackets1_19_3.PLAYER_CHAT, ClientboundPackets1_19_1.SYSTEM_CHAT, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.read(Types.UUID);
                this.read(Types.VAR_INT);
                this.read(Types.OPTIONAL_SIGNATURE_BYTES);
                this.handler(packetWrapper -> {
                    String string = packetWrapper.read(Types.STRING);
                    packetWrapper.read(Types.LONG);
                    packetWrapper.read(Types.LONG);
                    int n = packetWrapper.read(Types.VAR_INT);
                    for (int i = 0; i < n; ++i) {
                        int n2 = packetWrapper.read(Types.VAR_INT);
                        if (n2 != 0) continue;
                        packetWrapper.read(Types.SIGNATURE_BYTES);
                    }
                    JsonElement jsonElement = packetWrapper.read(Types.OPTIONAL_COMPONENT);
                    JsonElement jsonElement2 = jsonElement != null ? jsonElement : ComponentUtil.plainToJson(string);
                    Protocol1_19_3To1_19_1.this.translatableRewriter.processText(packetWrapper.user(), jsonElement2);
                    int n3 = packetWrapper.read(Types.VAR_INT);
                    if (n3 == 2) {
                        packetWrapper.read(Types.LONG_ARRAY_PRIMITIVE);
                    }
                    int n4 = packetWrapper.read(Types.VAR_INT);
                    JsonElement jsonElement3 = packetWrapper.read(Types.COMPONENT);
                    JsonElement jsonElement4 = packetWrapper.read(Types.OPTIONAL_COMPONENT);
                    JsonElement jsonElement5 = Protocol1_19_1To1_19.decorateChatMessage(Protocol1_19_3To1_19_1.this, packetWrapper.user().get(ChatTypeStorage1_19_3.class), n4, jsonElement3, jsonElement4, jsonElement2);
                    if (jsonElement5 == null) {
                        packetWrapper.cancel();
                        return;
                    }
                    packetWrapper.write(Types.COMPONENT, jsonElement5);
                    packetWrapper.write(Types.BOOLEAN, false);
                });
            }
        });
        this.registerClientbound(ClientboundPackets1_19_3.DISGUISED_CHAT, ClientboundPackets1_19_1.SYSTEM_CHAT, (PacketWrapper packetWrapper) -> {
            JsonElement jsonElement = packetWrapper.read(Types.COMPONENT);
            this.translatableRewriter.processText(packetWrapper.user(), jsonElement);
            int n = packetWrapper.read(Types.VAR_INT);
            JsonElement jsonElement2 = packetWrapper.read(Types.COMPONENT);
            JsonElement jsonElement3 = packetWrapper.read(Types.OPTIONAL_COMPONENT);
            JsonElement jsonElement4 = Protocol1_19_1To1_19.decorateChatMessage(this, packetWrapper.user().get(ChatTypeStorage1_19_3.class), n, jsonElement2, jsonElement3, jsonElement);
            if (jsonElement4 == null) {
                packetWrapper.cancel();
                return;
            }
            packetWrapper.write(Types.COMPONENT, jsonElement4);
            packetWrapper.write(Types.BOOLEAN, false);
        });
        this.cancelClientbound(ClientboundPackets1_19_3.UPDATE_ENABLED_FEATURES);
        this.cancelServerbound(ServerboundPackets1_19_1.CHAT_PREVIEW);
        this.cancelServerbound(ServerboundPackets1_19_1.CHAT_ACK);
    }

    private @Nullable String rewriteSound(PacketWrapper packetWrapper) {
        Holder holder = (Holder)((Object)packetWrapper.read(Types.SOUND_EVENT));
        if (holder.hasId()) {
            int n = MAPPINGS.getSoundMappings().getNewId(holder.id());
            if (n == -1) {
                packetWrapper.cancel();
                return null;
            }
            packetWrapper.write(Types.VAR_INT, n);
            return null;
        }
        String string = ((SoundEvent)holder.value()).identifier();
        String string2 = MAPPINGS.getMappedNamedSound(string);
        if (string2 == null) {
            return string;
        }
        if (string2.isEmpty()) {
            packetWrapper.cancel();
            return null;
        }
        return string2;
    }

    @Override
    public void init(UserConnection userConnection) {
        userConnection.put(new ChatSessionStorage());
        userConnection.put(new ChatTypeStorage1_19_3());
        this.addEntityTracker(userConnection, new EntityTrackerBase(userConnection, EntityTypes1_19_3.PLAYER));
    }

    @Override
    public BackwardsMappingData getMappingData() {
        return MAPPINGS;
    }

    @Override
    public JsonNBTComponentRewriter<ClientboundPackets1_19_3> getComponentRewriter() {
        return this.translatableRewriter;
    }

    public BlockItemPacketRewriter1_19_3 getItemRewriter() {
        return this.itemRewriter;
    }

    @Override
    public BlockRewriter<ClientboundPackets1_19_3> getBlockRewriter() {
        return this.blockRewriter;
    }

    @Override
    public ParticleRewriter<ClientboundPackets1_19_3> getParticleRewriter() {
        return this.particleRewriter;
    }

    public EntityPacketRewriter1_19_3 getEntityRewriter() {
        return this.entityRewriter;
    }

    @Override
    public TagRewriter<ClientboundPackets1_19_3> getTagRewriter() {
        return this.tagRewriter;
    }
}


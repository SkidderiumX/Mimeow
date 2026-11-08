/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_19to1_18_2;

import com.google.common.primitives.Longs;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.rewriters.SoundRewriter;
import com.viaversion.viabackwards.api.rewriters.text.JsonNBTComponentRewriter;
import com.viaversion.viabackwards.protocol.v1_19to1_18_2.data.BackwardsMappingData1_19;
import com.viaversion.viabackwards.protocol.v1_19to1_18_2.rewriter.BlockItemPacketRewriter1_19;
import com.viaversion.viabackwards.protocol.v1_19to1_18_2.rewriter.CommandRewriter1_19;
import com.viaversion.viabackwards.protocol.v1_19to1_18_2.rewriter.EntityPacketRewriter1_19;
import com.viaversion.viabackwards.protocol.v1_19to1_18_2.storage.DimensionRegistryStorage;
import com.viaversion.viabackwards.protocol.v1_19to1_18_2.storage.EntityTracker1_19;
import com.viaversion.viabackwards.protocol.v1_19to1_18_2.storage.NonceStorage;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.RegistryType;
import com.viaversion.viaversion.api.minecraft.signature.SignableCommandArgumentsProvider;
import com.viaversion.viaversion.api.minecraft.signature.model.DecoratableMessage;
import com.viaversion.viaversion.api.minecraft.signature.model.MessageMetadata;
import com.viaversion.viaversion.api.minecraft.signature.storage.ChatSession1_19_0;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_18;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.protocols.base.ClientboundLoginPackets;
import com.viaversion.viaversion.protocols.base.ServerboundLoginPackets;
import com.viaversion.viaversion.protocols.v1_16_4to1_17.packet.ServerboundPackets1_17;
import com.viaversion.viaversion.protocols.v1_17_1to1_18.packet.ClientboundPackets1_18;
import com.viaversion.viaversion.protocols.v1_18_2to1_19.packet.ClientboundPackets1_19;
import com.viaversion.viaversion.protocols.v1_18_2to1_19.packet.ServerboundPackets1_19;
import com.viaversion.viaversion.protocols.v1_19to1_19_1.Protocol1_19To1_19_1;
import com.viaversion.viaversion.protocols.v1_19to1_19_1.data.ChatDecorationResult;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.util.Pair;
import java.security.SignatureException;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class Protocol1_19To1_18_2
extends BackwardsProtocol<ClientboundPackets1_19, ClientboundPackets1_18, ServerboundPackets1_19, ServerboundPackets1_17> {
    public static final BackwardsMappingData1_19 MAPPINGS = new BackwardsMappingData1_19();
    private static final UUID ZERO_UUID = new UUID(0L, 0L);
    private static final byte[] EMPTY_BYTES = new byte[0];
    private final EntityPacketRewriter1_19 entityRewriter = new EntityPacketRewriter1_19(this);
    private final BlockItemPacketRewriter1_19 blockItemPackets = new BlockItemPacketRewriter1_19(this);
    private final ParticleRewriter<ClientboundPackets1_19> particleRewriter = new ParticleRewriter<ClientboundPackets1_19>(this);
    private final JsonNBTComponentRewriter<ClientboundPackets1_19> translatableRewriter = new JsonNBTComponentRewriter<ClientboundPackets1_19>(this, ComponentRewriterBase.ReadType.JSON);
    private final TagRewriter<ClientboundPackets1_19> tagRewriter = new TagRewriter<ClientboundPackets1_19>(this);
    private final BlockRewriter<ClientboundPackets1_19> blockRewriter = BlockRewriter.for1_18(this, ChunkType1_18::new);

    public Protocol1_19To1_18_2() {
        super(ClientboundPackets1_19.class, ClientboundPackets1_18.class, ServerboundPackets1_19.class, ServerboundPackets1_17.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        final SoundRewriter<ClientboundPackets1_19> soundRewriter = new SoundRewriter<ClientboundPackets1_19>(this);
        this.replaceClientbound(ClientboundPackets1_19.SOUND, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.map(Types.INT);
                this.map(Types.INT);
                this.map(Types.INT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.read(Types.LONG);
                this.handler(soundRewriter.getSoundHandler());
            }
        });
        this.replaceClientbound(ClientboundPackets1_19.SOUND_ENTITY, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.read(Types.LONG);
                this.handler(soundRewriter.getSoundHandler());
            }
        });
        this.replaceClientbound(ClientboundPackets1_19.CUSTOM_SOUND, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.map(Types.VAR_INT);
                this.map(Types.INT);
                this.map(Types.INT);
                this.map(Types.INT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.read(Types.LONG);
                this.handler(soundRewriter.getNamedSoundHandler());
            }
        });
        this.tagRewriter.removeTags("minecraft:banner_pattern");
        this.tagRewriter.removeTags("minecraft:instrument");
        this.tagRewriter.removeTags("minecraft:cat_variant");
        this.tagRewriter.removeTags("minecraft:painting_variant");
        this.tagRewriter.addEmptyTag(RegistryType.BLOCK, "minecraft:polar_bears_spawnable_on_in_frozen_ocean");
        this.tagRewriter.renameTag(RegistryType.BLOCK, "minecraft:wool_carpets", "minecraft:carpets");
        this.tagRewriter.renameTag(RegistryType.ITEM, "minecraft:wool_carpets", "minecraft:carpets");
        this.tagRewriter.addEmptyTag(RegistryType.ITEM, "minecraft:occludes_vibration_signals");
        CommandRewriter1_19 commandRewriter1_19 = new CommandRewriter1_19(this);
        this.replaceClientbound(ClientboundPackets1_19.COMMANDS, packetWrapper -> {
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
                String string = MAPPINGS.getArgumentTypeMappings().identifier(n3);
                if (string == null) {
                    this.getLogger().warning("Unknown command argument type id: " + n3);
                    string = "minecraft:no";
                }
                packetWrapper.write(Types.STRING, commandRewriter1_19.handleArgumentType(string));
                commandRewriter1_19.handleArgument(packetWrapper, string);
                if ((by & 0x10) == 0) continue;
                packetWrapper.passthrough(Types.STRING);
            }
            packetWrapper.passthrough(Types.VAR_INT);
        });
        this.cancelClientbound(ClientboundPackets1_19.SERVER_DATA);
        this.cancelClientbound(ClientboundPackets1_19.CHAT_PREVIEW);
        this.cancelClientbound(ClientboundPackets1_19.SET_DISPLAY_CHAT_PREVIEW);
        this.registerClientbound(ClientboundPackets1_19.PLAYER_CHAT, ClientboundPackets1_18.CHAT, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.handler(packetWrapper -> {
                    JsonElement jsonElement = packetWrapper.read(Types.COMPONENT);
                    JsonElement jsonElement2 = packetWrapper.read(Types.OPTIONAL_COMPONENT);
                    int n = packetWrapper.read(Types.VAR_INT);
                    UUID uUID = packetWrapper.read(Types.UUID);
                    JsonElement jsonElement3 = packetWrapper.read(Types.COMPONENT);
                    JsonElement jsonElement4 = packetWrapper.read(Types.OPTIONAL_COMPONENT);
                    CompoundTag compoundTag = packetWrapper.user().get(DimensionRegistryStorage.class).chatType(n);
                    ChatDecorationResult chatDecorationResult = Protocol1_19To1_19_1.decorateChatMessage(compoundTag, n, jsonElement3, jsonElement4, jsonElement2 != null ? jsonElement2 : jsonElement);
                    if (chatDecorationResult == null) {
                        packetWrapper.cancel();
                        return;
                    }
                    Protocol1_19To1_18_2.this.translatableRewriter.processText(packetWrapper.user(), chatDecorationResult.content());
                    packetWrapper.write(Types.COMPONENT, chatDecorationResult.content());
                    packetWrapper.write(Types.BYTE, chatDecorationResult.overlay() ? (byte)2 : (byte)1);
                    packetWrapper.write(Types.UUID, uUID);
                });
                this.read(Types.LONG);
                this.read(Types.LONG);
                this.read(Types.BYTE_ARRAY_PRIMITIVE);
            }
        });
        this.registerClientbound(ClientboundPackets1_19.SYSTEM_CHAT, ClientboundPackets1_18.CHAT, new PacketHandlers(){

            @Override
            public void register() {
                this.handler(packetWrapper -> {
                    JsonElement jsonElement = packetWrapper.passthrough(Types.COMPONENT);
                    Protocol1_19To1_18_2.this.translatableRewriter.processText(packetWrapper.user(), jsonElement);
                    int n = packetWrapper.read(Types.VAR_INT);
                    packetWrapper.write(Types.BYTE, n == 2 ? (byte)2 : (byte)0);
                });
                this.create(Types.UUID, ZERO_UUID);
            }
        }, true);
        this.registerServerbound(ServerboundPackets1_17.CHAT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.handler(packetWrapper -> {
                    ChatSession1_19_0 chatSession1_19_0 = packetWrapper.user().get(ChatSession1_19_0.class);
                    UUID uUID = packetWrapper.user().getProtocolInfo().getUuid();
                    Instant instant = Instant.now();
                    long l = ThreadLocalRandom.current().nextLong();
                    packetWrapper.write(Types.LONG, instant.toEpochMilli());
                    packetWrapper.write(Types.LONG, chatSession1_19_0 != null ? l : 0L);
                    String string = packetWrapper.get(Types.STRING, 0);
                    if (!string.isEmpty() && string.charAt(0) == '/') {
                        String string2 = string.substring(1);
                        packetWrapper.setPacketType(ServerboundPackets1_19.CHAT_COMMAND);
                        packetWrapper.set(Types.STRING, 0, string2);
                        SignableCommandArgumentsProvider signableCommandArgumentsProvider = Via.getManager().getProviders().get(SignableCommandArgumentsProvider.class);
                        if (chatSession1_19_0 != null && signableCommandArgumentsProvider != null) {
                            MessageMetadata messageMetadata = new MessageMetadata(uUID, instant, l);
                            List<Pair<String, String>> list = signableCommandArgumentsProvider.getSignableArguments(string2);
                            packetWrapper.write(Types.VAR_INT, list.size());
                            for (Pair<String, String> pair : list) {
                                byte[] byArray;
                                try {
                                    byArray = chatSession1_19_0.signChatMessage(messageMetadata, new DecoratableMessage(pair.value()));
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
                    } else if (chatSession1_19_0 != null) {
                        byte[] byArray;
                        MessageMetadata messageMetadata = new MessageMetadata(uUID, instant, l);
                        DecoratableMessage decoratableMessage = new DecoratableMessage(string);
                        try {
                            byArray = chatSession1_19_0.signChatMessage(messageMetadata, decoratableMessage);
                        }
                        catch (SignatureException signatureException) {
                            throw new RuntimeException(signatureException);
                        }
                        packetWrapper.write(Types.BYTE_ARRAY_PRIMITIVE, byArray);
                    } else {
                        packetWrapper.write(Types.BYTE_ARRAY_PRIMITIVE, EMPTY_BYTES);
                    }
                    packetWrapper.write(Types.BOOLEAN, false);
                });
            }
        });
        this.registerClientbound(State.LOGIN, ClientboundLoginPackets.LOGIN_FINISHED, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.UUID);
                this.map(Types.STRING);
                this.read(Types.PROFILE_PROPERTY_ARRAY);
            }
        });
        this.registerClientbound(State.LOGIN, ClientboundLoginPackets.HELLO, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.map(Types.BYTE_ARRAY_PRIMITIVE);
                this.handler(packetWrapper -> {
                    if (packetWrapper.user().has(ChatSession1_19_0.class)) {
                        packetWrapper.user().put(new NonceStorage(packetWrapper.passthrough(Types.BYTE_ARRAY_PRIMITIVE)));
                    }
                });
            }
        });
        this.registerServerbound(State.LOGIN, ServerboundLoginPackets.HELLO, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.handler(packetWrapper -> {
                    ChatSession1_19_0 chatSession1_19_0 = packetWrapper.user().get(ChatSession1_19_0.class);
                    packetWrapper.write(Types.OPTIONAL_PROFILE_KEY, chatSession1_19_0 == null ? null : chatSession1_19_0.getProfileKey());
                });
            }
        });
        this.registerServerbound(State.LOGIN, ServerboundLoginPackets.ENCRYPTION_KEY, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BYTE_ARRAY_PRIMITIVE);
                this.handler(packetWrapper -> {
                    ChatSession1_19_0 chatSession1_19_0 = packetWrapper.user().get(ChatSession1_19_0.class);
                    byte[] byArray = packetWrapper.read(Types.BYTE_ARRAY_PRIMITIVE);
                    packetWrapper.write(Types.BOOLEAN, chatSession1_19_0 == null);
                    if (chatSession1_19_0 != null) {
                        byte[] byArray2;
                        long l = ThreadLocalRandom.current().nextLong();
                        try {
                            byArray2 = chatSession1_19_0.sign(dataConsumer -> {
                                dataConsumer.accept(packetWrapper.user().remove(NonceStorage.class).nonce());
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
    }

    @Override
    public void init(UserConnection userConnection) {
        userConnection.put(new DimensionRegistryStorage());
        this.addEntityTracker(userConnection, new EntityTracker1_19(userConnection));
    }

    @Override
    public BackwardsMappingData1_19 getMappingData() {
        return MAPPINGS;
    }

    @Override
    public JsonNBTComponentRewriter<ClientboundPackets1_19> getComponentRewriter() {
        return this.translatableRewriter;
    }

    public EntityPacketRewriter1_19 getEntityRewriter() {
        return this.entityRewriter;
    }

    public BlockItemPacketRewriter1_19 getItemRewriter() {
        return this.blockItemPackets;
    }

    @Override
    public BlockRewriter<ClientboundPackets1_19> getBlockRewriter() {
        return this.blockRewriter;
    }

    @Override
    public ParticleRewriter<ClientboundPackets1_19> getParticleRewriter() {
        return this.particleRewriter;
    }

    @Override
    public TagRewriter<ClientboundPackets1_19> getTagRewriter() {
        return this.tagRewriter;
    }
}


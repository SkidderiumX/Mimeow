/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_9to1_21_7;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viabackwards.ViaBackwards;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.data.BackwardsMappingData;
import com.viaversion.viabackwards.api.rewriters.BackwardsRegistryRewriter;
import com.viaversion.viabackwards.api.rewriters.SoundRewriter;
import com.viaversion.viabackwards.api.rewriters.text.NBTComponentRewriter;
import com.viaversion.viabackwards.protocol.v1_21_9to1_21_7.rewriter.BlockItemPacketRewriter1_21_9;
import com.viaversion.viabackwards.protocol.v1_21_9to1_21_7.rewriter.ComponentRewriter1_21_9;
import com.viaversion.viabackwards.protocol.v1_21_9to1_21_7.rewriter.EntityPacketRewriter1_21_9;
import com.viaversion.viabackwards.protocol.v1_21_9to1_21_7.rewriter.ParticleRewriter1_21_9;
import com.viaversion.viabackwards.protocol.v1_21_9to1_21_7.rewriter.RegistryDataRewriter1_21_9;
import com.viaversion.viabackwards.protocol.v1_21_9to1_21_7.storage.DimensionScaleStorage;
import com.viaversion.viabackwards.protocol.v1_21_9to1_21_7.storage.PlayerRotationStorage;
import com.viaversion.viabackwards.protocol.v1_21_9to1_21_7.tracker.EntityTracker1_21_9;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.data.version.StructuredDataKeys1_21_5;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_9;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_5;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.provider.PacketTypesProvider;
import com.viaversion.viaversion.api.protocol.packet.provider.SimplePacketTypesProvider;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_21_5;
import com.viaversion.viaversion.api.type.types.version.Types1_20_5;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.api.type.types.version.VersionedTypesHolder;
import com.viaversion.viaversion.data.item.ItemHasherBase;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.rewriter.RecipeDisplayRewriter1_21_5;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ClientboundConfigurationPackets1_21_6;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ClientboundPacket1_21_6;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ClientboundPackets1_21_6;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ServerboundConfigurationPackets1_21_6;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ServerboundPacket1_21_6;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ServerboundPackets1_21_6;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.Protocol1_21_7To1_21_9;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.packet.ClientboundConfigurationPackets1_21_9;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.packet.ClientboundPacket1_21_9;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.packet.ClientboundPackets1_21_9;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.packet.ServerboundConfigurationPackets1_21_9;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.packet.ServerboundPacket1_21_9;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.storage.BundleStateTracker;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.RecipeDisplayRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;
import com.viaversion.viaversion.rewriter.block.BlockRewriter1_21_5;
import com.viaversion.viaversion.util.ProtocolUtil;

public class Protocol1_21_9To1_21_7
extends BackwardsProtocol<ClientboundPacket1_21_9, ClientboundPacket1_21_6, ServerboundPacket1_21_9, ServerboundPacket1_21_6> {
    public static final BackwardsMappingData MAPPINGS = new BackwardsMappingData("1.21.9", "1.21.7", Protocol1_21_7To1_21_9.class);
    private final EntityPacketRewriter1_21_9 entityRewriter = new EntityPacketRewriter1_21_9(this);
    private final BlockItemPacketRewriter1_21_9 itemRewriter = new BlockItemPacketRewriter1_21_9(this);
    private final ParticleRewriter<ClientboundPacket1_21_9> particleRewriter = new ParticleRewriter1_21_9(this);
    private final NBTComponentRewriter<ClientboundPacket1_21_9> translatableRewriter = new ComponentRewriter1_21_9(this);
    private final TagRewriter<ClientboundPacket1_21_9> tagRewriter = new TagRewriter<ClientboundPacket1_21_9>(this);
    private final RecipeDisplayRewriter<ClientboundPacket1_21_9> recipeRewriter = new RecipeDisplayRewriter1_21_5<ClientboundPacket1_21_9>(this);
    private final BackwardsRegistryRewriter registryDataRewriter = new RegistryDataRewriter1_21_9(this);
    private final BlockRewriter<ClientboundPacket1_21_9> blockRewriter = new BlockRewriter1_21_5<ClientboundPacket1_21_9>(this, ChunkType1_21_5::new);

    public Protocol1_21_9To1_21_7() {
        super(ClientboundPacket1_21_9.class, ClientboundPacket1_21_6.class, ServerboundPacket1_21_9.class, ServerboundPacket1_21_6.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        SoundRewriter<ClientboundPacket1_21_9> soundRewriter = new SoundRewriter<ClientboundPacket1_21_9>(this);
        this.replaceClientbound(ClientboundPackets1_21_9.EXPLODE, packetWrapper -> {
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.read(Types.FLOAT);
            packetWrapper.read(Types.INT);
            if (packetWrapper.passthrough(Types.BOOLEAN).booleanValue()) {
                packetWrapper.passthrough(Types.DOUBLE);
                packetWrapper.passthrough(Types.DOUBLE);
                packetWrapper.passthrough(Types.DOUBLE);
            }
            this.particleRewriter.passthroughParticle(packetWrapper);
            soundRewriter.soundHolderHandler().handle(packetWrapper);
            int n = packetWrapper.read(Types.VAR_INT);
            for (int i = 0; i < n; ++i) {
                packetWrapper.read(this.particleRewriter.particleType());
                packetWrapper.read(Types.FLOAT);
                packetWrapper.read(Types.FLOAT);
                packetWrapper.read(Types.VAR_INT);
            }
        });
        this.registerClientbound(ClientboundConfigurationPackets1_21_9.CODE_OF_CONDUCT, ClientboundConfigurationPackets1_21_6.SHOW_DIALOG, (PacketWrapper packetWrapper) -> {
            boolean bl = packetWrapper.user().getProtocolInfo().protocolVersion().newerThan(ProtocolVersion.v1_21_5);
            if (!ViaBackwards.getConfig().codeOfConductAsDialog() || !bl) {
                packetWrapper.cancel();
                PacketWrapper packetWrapper2 = packetWrapper.create(ServerboundConfigurationPackets1_21_9.ACCEPT_CODE_OF_CONDUCT);
                packetWrapper2.sendToServer(Protocol1_21_9To1_21_7.class);
                return;
            }
            String string = packetWrapper.read(Types.STRING);
            CompoundTag compoundTag = new CompoundTag();
            compoundTag.putString("type", "minecraft:confirmation");
            compoundTag.putString("title", this.translatableRewriter.mappedTranslationKey("multiplayer.codeOfConduct.title"));
            CompoundTag compoundTag2 = new CompoundTag();
            compoundTag2.putString("type", "minecraft:plain_message");
            compoundTag2.putString("contents", string);
            compoundTag.put("body", compoundTag2);
            CompoundTag compoundTag3 = new CompoundTag();
            CompoundTag compoundTag4 = new CompoundTag();
            compoundTag4.putString("translate", "gui.acknowledge");
            compoundTag3.put("label", compoundTag4);
            CompoundTag compoundTag5 = new CompoundTag();
            compoundTag5.putString("type", "minecraft:custom");
            compoundTag5.putString("id", "viabackwards:ack_code_of_conduct");
            compoundTag3.put("action", compoundTag5);
            compoundTag.put("yes", compoundTag3);
            CompoundTag compoundTag6 = new CompoundTag();
            CompoundTag compoundTag7 = new CompoundTag();
            compoundTag7.putString("translate", "menu.disconnect");
            compoundTag6.put("label", compoundTag7);
            CompoundTag compoundTag8 = new CompoundTag();
            compoundTag8.putString("type", "minecraft:custom");
            compoundTag8.putString("id", "viabackwards:disconnect");
            compoundTag6.put("action", compoundTag8);
            compoundTag.put("no", compoundTag6);
            packetWrapper.write(Types.TRUSTED_COMPOUND_TAG, compoundTag);
        });
        this.registerServerbound(ServerboundConfigurationPackets1_21_6.CUSTOM_CLICK_ACTION, packetWrapper -> {
            String string = packetWrapper.passthrough(Types.STRING);
            if ("viabackwards:ack_code_of_conduct".equals(string)) {
                packetWrapper.cancel();
                PacketWrapper packetWrapper2 = packetWrapper.create(ServerboundConfigurationPackets1_21_9.ACCEPT_CODE_OF_CONDUCT);
                packetWrapper2.sendToServer(Protocol1_21_9To1_21_7.class);
            } else if ("viabackwards:disconnect".equals(string)) {
                packetWrapper.cancel();
                packetWrapper.user().disconnect(this.translatableRewriter.mappedTranslationKey("multiplayer.disconnect.code_of_conduct"));
            }
        });
        this.registerServerbound(ServerboundPackets1_21_6.DEBUG_SAMPLE_SUBSCRIPTION, packetWrapper -> {
            int n = packetWrapper.read(Types.VAR_INT);
            if (n == 0) {
                packetWrapper.write(Types.VAR_INT, 1);
                packetWrapper.write(Types.VAR_INT, 0);
            }
        });
        this.registerClientbound(ClientboundPackets1_21_9.BUNDLE_DELIMITER, packetWrapper -> packetWrapper.user().get(BundleStateTracker.class).toggleBundling());
        this.cancelClientbound(ClientboundPackets1_21_9.DEBUG_BLOCK_VALUE);
        this.cancelClientbound(ClientboundPackets1_21_9.DEBUG_CHUNK_VALUE);
        this.cancelClientbound(ClientboundPackets1_21_9.DEBUG_ENTITY_VALUE);
        this.cancelClientbound(ClientboundPackets1_21_9.DEBUG_EVENT);
        this.cancelClientbound(ClientboundPackets1_21_9.GAME_EVENT_TEST_HIGHLIGHT_POS);
    }

    @Override
    public void init(UserConnection userConnection) {
        this.addEntityTracker(userConnection, new EntityTracker1_21_9(userConnection, EntityTypes1_21_9.PLAYER));
        userConnection.addItemHasher(this.getClass(), new ItemHasherBase(this, userConnection));
        userConnection.put(new PlayerRotationStorage());
        userConnection.put(new DimensionScaleStorage());
        userConnection.put(new BundleStateTracker());
    }

    @Override
    public BackwardsMappingData getMappingData() {
        return MAPPINGS;
    }

    public EntityPacketRewriter1_21_9 getEntityRewriter() {
        return this.entityRewriter;
    }

    public BlockItemPacketRewriter1_21_9 getItemRewriter() {
        return this.itemRewriter;
    }

    @Override
    public BlockRewriter<ClientboundPacket1_21_9> getBlockRewriter() {
        return this.blockRewriter;
    }

    @Override
    public BackwardsRegistryRewriter getRegistryDataRewriter() {
        return this.registryDataRewriter;
    }

    @Override
    public ParticleRewriter<ClientboundPacket1_21_9> getParticleRewriter() {
        return this.particleRewriter;
    }

    @Override
    public NBTComponentRewriter<ClientboundPacket1_21_9> getComponentRewriter() {
        return this.translatableRewriter;
    }

    @Override
    public TagRewriter<ClientboundPacket1_21_9> getTagRewriter() {
        return this.tagRewriter;
    }

    @Override
    public RecipeDisplayRewriter<ClientboundPacket1_21_9> getRecipeRewriter() {
        return this.recipeRewriter;
    }

    @Override
    public VersionedTypesHolder types() {
        return VersionedTypes.V1_21_9;
    }

    @Override
    public Types1_20_5<StructuredDataKeys1_21_5, EntityDataTypes1_21_5> mappedTypes() {
        return VersionedTypes.V1_21_6;
    }

    @Override
    protected PacketTypesProvider<ClientboundPacket1_21_9, ClientboundPacket1_21_6, ServerboundPacket1_21_9, ServerboundPacket1_21_6> createPacketTypesProvider() {
        return new SimplePacketTypesProvider<ClientboundPacket1_21_9, ClientboundPacket1_21_6, ServerboundPacket1_21_9, ServerboundPacket1_21_6>(ProtocolUtil.packetTypeMap(this.unmappedClientboundPacketType, ClientboundPackets1_21_9.class, ClientboundConfigurationPackets1_21_9.class), ProtocolUtil.packetTypeMap(this.mappedClientboundPacketType, ClientboundPackets1_21_6.class, ClientboundConfigurationPackets1_21_6.class), ProtocolUtil.packetTypeMap(this.mappedServerboundPacketType, ServerboundPackets1_21_6.class, ServerboundConfigurationPackets1_21_9.class), ProtocolUtil.packetTypeMap(this.unmappedServerboundPacketType, ServerboundPackets1_21_6.class, ServerboundConfigurationPackets1_21_6.class));
    }
}


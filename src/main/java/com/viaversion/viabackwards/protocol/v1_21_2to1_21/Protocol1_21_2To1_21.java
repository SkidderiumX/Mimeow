/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_2to1_21;

import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.data.BackwardsMappingData;
import com.viaversion.viabackwards.api.rewriters.BackwardsRegistryRewriter;
import com.viaversion.viabackwards.api.rewriters.text.JsonNBTComponentRewriter;
import com.viaversion.viabackwards.protocol.v1_21_2to1_21.rewriter.BlockItemPacketRewriter1_21_2;
import com.viaversion.viabackwards.protocol.v1_21_2to1_21.rewriter.ComponentRewriter1_21_2;
import com.viaversion.viabackwards.protocol.v1_21_2to1_21.rewriter.EntityPacketRewriter1_21_2;
import com.viaversion.viabackwards.protocol.v1_21_2to1_21.rewriter.ParticleRewriter1_21_2;
import com.viaversion.viabackwards.protocol.v1_21_2to1_21.storage.InventoryStateIdStorage;
import com.viaversion.viabackwards.protocol.v1_21_2to1_21.storage.ItemTagStorage;
import com.viaversion.viabackwards.protocol.v1_21_2to1_21.storage.PlayerStorage;
import com.viaversion.viabackwards.protocol.v1_21_2to1_21.storage.RecipeStorage;
import com.viaversion.viabackwards.protocol.v1_21_2to1_21.storage.SignStorage;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_20_5;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.protocol.packet.provider.PacketTypesProvider;
import com.viaversion.viaversion.api.protocol.packet.provider.SimplePacketTypesProvider;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_20_2;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.api.type.types.version.VersionedTypesHolder;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.protocols.base.ClientboundLoginPackets;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundConfigurationPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundPacket1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundConfigurationPackets1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundPacket1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundPackets1_21;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.Protocol1_21To1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPacket1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPackets1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ServerboundPacket1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ServerboundPackets1_21_2;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;
import com.viaversion.viaversion.util.ArrayUtil;
import com.viaversion.viaversion.util.ProtocolUtil;

public class Protocol1_21_2To1_21
extends BackwardsProtocol<ClientboundPacket1_21_2, ClientboundPacket1_21, ServerboundPacket1_21_2, ServerboundPacket1_20_5> {
    public static final BackwardsMappingData MAPPINGS = new BackwardsMappingData("1.21.2", "1.21", Protocol1_21To1_21_2.class);
    private final EntityPacketRewriter1_21_2 entityRewriter = new EntityPacketRewriter1_21_2(this);
    private final BlockItemPacketRewriter1_21_2 itemRewriter = new BlockItemPacketRewriter1_21_2(this);
    private final ParticleRewriter1_21_2 particleRewriter = new ParticleRewriter1_21_2(this);
    private final JsonNBTComponentRewriter<ClientboundPacket1_21_2> translatableRewriter = new ComponentRewriter1_21_2(this);
    private final TagRewriter<ClientboundPacket1_21_2> tagRewriter = new TagRewriter<ClientboundPacket1_21_2>(this);
    private final BackwardsRegistryRewriter registryDataRewriter = new BackwardsRegistryRewriter(this);
    private final BlockRewriter<ClientboundPacket1_21_2> blockRewriter = BlockRewriter.for1_20_2(this, ChunkType1_20_2::new);

    public Protocol1_21_2To1_21() {
        super(ClientboundPacket1_21_2.class, ClientboundPacket1_21.class, ServerboundPacket1_21_2.class, ServerboundPacket1_20_5.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        this.replaceClientbound(ClientboundPackets1_21_2.UPDATE_TAGS, this::storeTags);
        this.replaceClientbound(ClientboundConfigurationPackets1_21.UPDATE_TAGS, this::storeTags);
        this.registerServerbound(ServerboundPackets1_20_5.CLIENT_INFORMATION, this::clientInformation);
        this.registerServerbound(ServerboundConfigurationPackets1_20_5.CLIENT_INFORMATION, this::clientInformation);
        this.registerClientbound(ClientboundConfigurationPackets1_21.UPDATE_ENABLED_FEATURES, packetWrapper -> {
            String[] stringArray = packetWrapper.read(Types.STRING_ARRAY);
            packetWrapper.write(Types.STRING_ARRAY, ArrayUtil.add(stringArray, "bundle"));
        });
        this.cancelClientbound(ClientboundPackets1_21_2.MOVE_MINECART_ALONG_TRACK);
        this.registerClientbound(State.LOGIN, ClientboundLoginPackets.LOGIN_FINISHED, (PacketWrapper packetWrapper) -> {
            packetWrapper.passthrough(Types.UUID);
            packetWrapper.passthrough(Types.STRING);
            packetWrapper.passthrough(Types.PROFILE_PROPERTY_ARRAY);
            packetWrapper.write(Types.BOOLEAN, true);
        });
        this.registerClientbound(ClientboundPackets1_21_2.SET_TIME, packetWrapper -> {
            packetWrapper.passthrough(Types.LONG);
            long l = packetWrapper.read(Types.LONG);
            boolean bl = packetWrapper.read(Types.BOOLEAN);
            if (!bl) {
                l = l == 0L ? -1L : -l;
            }
            packetWrapper.write(Types.LONG, l);
        });
    }

    private void storeTags(PacketWrapper packetWrapper) {
        this.tagRewriter.handleGeneric(packetWrapper);
        packetWrapper.resetReader();
        packetWrapper.user().get(ItemTagStorage.class).readItemTags(packetWrapper);
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
        packetWrapper.write(Types.VAR_INT, 0);
    }

    @Override
    public void init(UserConnection userConnection) {
        this.addEntityTracker(userConnection, new EntityTrackerBase(userConnection, EntityTypes1_20_5.PLAYER));
        userConnection.put(new InventoryStateIdStorage());
        userConnection.put(new ItemTagStorage());
        userConnection.put(new RecipeStorage(this));
        userConnection.put(new PlayerStorage());
        userConnection.put(new SignStorage());
    }

    @Override
    public BackwardsMappingData getMappingData() {
        return MAPPINGS;
    }

    public EntityPacketRewriter1_21_2 getEntityRewriter() {
        return this.entityRewriter;
    }

    public BlockItemPacketRewriter1_21_2 getItemRewriter() {
        return this.itemRewriter;
    }

    @Override
    public BlockRewriter<ClientboundPacket1_21_2> getBlockRewriter() {
        return this.blockRewriter;
    }

    @Override
    public ParticleRewriter1_21_2 getParticleRewriter() {
        return this.particleRewriter;
    }

    @Override
    public BackwardsRegistryRewriter getRegistryDataRewriter() {
        return this.registryDataRewriter;
    }

    @Override
    public JsonNBTComponentRewriter<ClientboundPacket1_21_2> getComponentRewriter() {
        return this.translatableRewriter;
    }

    @Override
    public TagRewriter<ClientboundPacket1_21_2> getTagRewriter() {
        return this.tagRewriter;
    }

    @Override
    public VersionedTypesHolder types() {
        return VersionedTypes.V1_21_2;
    }

    @Override
    public VersionedTypesHolder mappedTypes() {
        return VersionedTypes.V1_21;
    }

    @Override
    protected PacketTypesProvider<ClientboundPacket1_21_2, ClientboundPacket1_21, ServerboundPacket1_21_2, ServerboundPacket1_20_5> createPacketTypesProvider() {
        return new SimplePacketTypesProvider<ClientboundPacket1_21_2, ClientboundPacket1_21, ServerboundPacket1_21_2, ServerboundPacket1_20_5>(ProtocolUtil.packetTypeMap(this.unmappedClientboundPacketType, ClientboundPackets1_21_2.class, ClientboundConfigurationPackets1_21.class), ProtocolUtil.packetTypeMap(this.mappedClientboundPacketType, ClientboundPackets1_21.class, ClientboundConfigurationPackets1_21.class), ProtocolUtil.packetTypeMap(this.mappedServerboundPacketType, ServerboundPackets1_21_2.class, ServerboundConfigurationPackets1_20_5.class), ProtocolUtil.packetTypeMap(this.unmappedServerboundPacketType, ServerboundPackets1_20_5.class, ServerboundConfigurationPackets1_20_5.class));
    }
}


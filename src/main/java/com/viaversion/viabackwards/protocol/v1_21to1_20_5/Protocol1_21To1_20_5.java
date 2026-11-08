/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21to1_20_5;

import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.data.BackwardsMappingData;
import com.viaversion.viabackwards.api.rewriters.BackwardsRegistryRewriter;
import com.viaversion.viabackwards.api.rewriters.text.JsonNBTComponentRewriter;
import com.viaversion.viabackwards.protocol.v1_21to1_20_5.rewriter.BlockItemPacketRewriter1_21;
import com.viaversion.viabackwards.protocol.v1_21to1_20_5.rewriter.ComponentRewriter1_21;
import com.viaversion.viabackwards.protocol.v1_21to1_20_5.rewriter.EntityPacketRewriter1_21;
import com.viaversion.viabackwards.protocol.v1_21to1_20_5.storage.EnchantmentsPaintingsStorage;
import com.viaversion.viabackwards.protocol.v1_21to1_20_5.storage.OpenScreenStorage;
import com.viaversion.viabackwards.protocol.v1_21to1_20_5.storage.PlayerRotationStorage;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.data.version.StructuredDataKeys1_20_5;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_20_5;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_20_5;
import com.viaversion.viaversion.api.minecraft.item.data.ChatType;
import com.viaversion.viaversion.api.protocol.packet.provider.PacketTypesProvider;
import com.viaversion.viaversion.api.protocol.packet.provider.SimplePacketTypesProvider;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_20_2;
import com.viaversion.viaversion.api.type.types.version.Types1_20_5;
import com.viaversion.viaversion.api.type.types.version.Types1_21;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ClientboundConfigurationPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ClientboundPacket1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ClientboundPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundConfigurationPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundPacket1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.Protocol1_20_5To1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundConfigurationPackets1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundPacket1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundPackets1_21;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;
import com.viaversion.viaversion.util.ArrayUtil;
import com.viaversion.viaversion.util.ProtocolUtil;

public class Protocol1_21To1_20_5
extends BackwardsProtocol<ClientboundPacket1_21, ClientboundPacket1_20_5, ServerboundPacket1_20_5, ServerboundPacket1_20_5> {
    public static final BackwardsMappingData MAPPINGS = new BackwardsMappingData("1.21", "1.20.5", Protocol1_20_5To1_21.class);
    private final EntityPacketRewriter1_21 entityRewriter = new EntityPacketRewriter1_21(this);
    private final BlockItemPacketRewriter1_21 itemRewriter = new BlockItemPacketRewriter1_21(this);
    private final ParticleRewriter<ClientboundPacket1_21> particleRewriter = new ParticleRewriter<ClientboundPacket1_21>(this);
    private final JsonNBTComponentRewriter<ClientboundPacket1_21> translatableRewriter = new ComponentRewriter1_21(this);
    private final TagRewriter<ClientboundPacket1_21> tagRewriter = new TagRewriter<ClientboundPacket1_21>(this);
    private final BlockRewriter<ClientboundPacket1_21> blockRewriter = BlockRewriter.for1_20_2(this, ChunkType1_20_2::new);
    private final BackwardsRegistryRewriter registryDataRewriter = new BackwardsRegistryRewriter(this);

    public Protocol1_21To1_20_5() {
        super(ClientboundPacket1_21.class, ClientboundPacket1_20_5.class, ServerboundPacket1_20_5.class, ServerboundPacket1_20_5.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        this.cancelClientbound(ClientboundPackets1_21.PROJECTILE_POWER);
        this.cancelClientbound(ClientboundPackets1_21.CUSTOM_REPORT_DETAILS);
        this.cancelClientbound(ClientboundPackets1_21.SERVER_LINKS);
        this.cancelClientbound(ClientboundConfigurationPackets1_21.CUSTOM_REPORT_DETAILS);
        this.cancelClientbound(ClientboundConfigurationPackets1_21.SERVER_LINKS);
        this.replaceClientbound(ClientboundPackets1_21.DISGUISED_CHAT, packetWrapper -> {
            this.translatableRewriter.processTag(packetWrapper.user(), packetWrapper.passthrough(Types.TRUSTED_TAG));
            Holder holder = (Holder)((Object)packetWrapper.read(ChatType.TYPE));
            if (holder.isDirect()) {
                packetWrapper.write(Types.VAR_INT, 0);
                return;
            }
            packetWrapper.write(Types.VAR_INT, holder.id());
        });
        this.replaceClientbound(ClientboundPackets1_21.PLAYER_CHAT, packetWrapper -> {
            Holder holder;
            int n;
            packetWrapper.passthrough(Types.UUID);
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.OPTIONAL_SIGNATURE_BYTES);
            packetWrapper.passthrough(Types.STRING);
            packetWrapper.passthrough(Types.LONG);
            packetWrapper.passthrough(Types.LONG);
            int n2 = packetWrapper.passthrough(Types.VAR_INT);
            for (n = 0; n < n2; ++n) {
                int n3 = packetWrapper.passthrough(Types.VAR_INT);
                if (n3 != 0) continue;
                packetWrapper.passthrough(Types.SIGNATURE_BYTES);
            }
            packetWrapper.passthrough(Types.TRUSTED_OPTIONAL_TAG);
            n = packetWrapper.passthrough(Types.VAR_INT);
            if (n == 2) {
                packetWrapper.passthrough(Types.LONG_ARRAY_PRIMITIVE);
            }
            if ((holder = (Holder)((Object)packetWrapper.read(ChatType.TYPE))).isDirect()) {
                packetWrapper.write(Types.VAR_INT, 0);
            } else {
                packetWrapper.write(Types.VAR_INT, holder.id());
            }
            this.translatableRewriter.processTag(packetWrapper.user(), packetWrapper.passthrough(Types.TRUSTED_TAG));
            this.translatableRewriter.processTag(packetWrapper.user(), packetWrapper.passthrough(Types.TRUSTED_OPTIONAL_TAG));
        });
        this.replaceClientbound(ClientboundPackets1_21.UPDATE_ATTRIBUTES, packetWrapper -> {
            int n;
            packetWrapper.passthrough(Types.VAR_INT);
            int n2 = n = packetWrapper.passthrough(Types.VAR_INT).intValue();
            for (int i = 0; i < n; ++i) {
                int n3;
                int n4;
                int n5 = packetWrapper.read(Types.VAR_INT);
                int n6 = MAPPINGS.getNewAttributeId(n5);
                if (n6 == -1) {
                    --n2;
                    packetWrapper.read(Types.DOUBLE);
                    n4 = packetWrapper.read(Types.VAR_INT);
                    for (n3 = 0; n3 < n4; ++n3) {
                        packetWrapper.read(Types.STRING);
                        packetWrapper.read(Types.DOUBLE);
                        packetWrapper.read(Types.BYTE);
                    }
                    continue;
                }
                packetWrapper.write(Types.VAR_INT, n6);
                packetWrapper.passthrough(Types.DOUBLE);
                n4 = packetWrapper.passthrough(Types.VAR_INT);
                for (n3 = 0; n3 < n4; ++n3) {
                    String string = packetWrapper.read(Types.STRING);
                    packetWrapper.write(Types.UUID, Protocol1_20_5To1_21.mapAttributeId(string));
                    packetWrapper.passthrough(Types.DOUBLE);
                    packetWrapper.passthrough(Types.BYTE);
                }
            }
            if (n != n2) {
                packetWrapper.set(Types.VAR_INT, 1, n2);
            }
        });
        this.registerClientbound(ClientboundConfigurationPackets1_21.UPDATE_ENABLED_FEATURES, packetWrapper -> {
            String[] stringArray = packetWrapper.read(Types.STRING_ARRAY);
            packetWrapper.write(Types.STRING_ARRAY, ArrayUtil.add(stringArray, "minecraft:update_1_21"));
        });
    }

    @Override
    public void init(UserConnection userConnection) {
        this.addEntityTracker(userConnection, new EntityTrackerBase(userConnection, EntityTypes1_20_5.PLAYER));
        userConnection.put(new EnchantmentsPaintingsStorage());
        userConnection.put(new OpenScreenStorage());
        userConnection.put(new PlayerRotationStorage());
    }

    @Override
    public BackwardsMappingData getMappingData() {
        return MAPPINGS;
    }

    public EntityPacketRewriter1_21 getEntityRewriter() {
        return this.entityRewriter;
    }

    public BlockItemPacketRewriter1_21 getItemRewriter() {
        return this.itemRewriter;
    }

    @Override
    public BlockRewriter<ClientboundPacket1_21> getBlockRewriter() {
        return this.blockRewriter;
    }

    @Override
    public BackwardsRegistryRewriter getRegistryDataRewriter() {
        return this.registryDataRewriter;
    }

    @Override
    public ParticleRewriter<ClientboundPacket1_21> getParticleRewriter() {
        return this.particleRewriter;
    }

    @Override
    public JsonNBTComponentRewriter<ClientboundPacket1_21> getComponentRewriter() {
        return this.translatableRewriter;
    }

    @Override
    public TagRewriter<ClientboundPacket1_21> getTagRewriter() {
        return this.tagRewriter;
    }

    @Override
    public Types1_21 types() {
        return VersionedTypes.V1_21;
    }

    @Override
    public Types1_20_5<StructuredDataKeys1_20_5, EntityDataTypes1_20_5> mappedTypes() {
        return VersionedTypes.V1_20_5;
    }

    @Override
    protected PacketTypesProvider<ClientboundPacket1_21, ClientboundPacket1_20_5, ServerboundPacket1_20_5, ServerboundPacket1_20_5> createPacketTypesProvider() {
        return new SimplePacketTypesProvider<ClientboundPacket1_21, ClientboundPacket1_20_5, ServerboundPacket1_20_5, ServerboundPacket1_20_5>(ProtocolUtil.packetTypeMap(this.unmappedClientboundPacketType, ClientboundPackets1_21.class, ClientboundConfigurationPackets1_21.class), ProtocolUtil.packetTypeMap(this.mappedClientboundPacketType, ClientboundPackets1_20_5.class, ClientboundConfigurationPackets1_20_5.class), ProtocolUtil.packetTypeMap(this.mappedServerboundPacketType, ServerboundPackets1_20_5.class, ServerboundConfigurationPackets1_20_5.class), ProtocolUtil.packetTypeMap(this.unmappedServerboundPacketType, ServerboundPackets1_20_5.class, ServerboundConfigurationPackets1_20_5.class));
    }
}


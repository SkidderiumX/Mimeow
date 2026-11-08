/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v26_2to26_1;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.data.BackwardsMappingData;
import com.viaversion.viabackwards.api.rewriters.BackwardsRegistryRewriter;
import com.viaversion.viabackwards.api.rewriters.text.NBTComponentRewriter;
import com.viaversion.viabackwards.protocol.v26_2to26_1.rewriter.BlockItemPacketRewriter26_2;
import com.viaversion.viabackwards.protocol.v26_2to26_1.rewriter.ComponentRewriter26_2;
import com.viaversion.viabackwards.protocol.v26_2to26_1.rewriter.EntityPacketRewriter26_2;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.data.version.StructuredDataKeys1_21_11;
import com.viaversion.viaversion.api.minecraft.data.version.StructuredDataKeys26_2;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes26_1;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.protocol.packet.provider.PacketTypesProvider;
import com.viaversion.viaversion.api.protocol.packet.provider.SimplePacketTypesProvider;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType26_1;
import com.viaversion.viaversion.api.type.types.version.Types26_1;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.protocols.base.ClientboundLoginPackets;
import com.viaversion.viaversion.protocols.v1_21_11to26_1.packet.ClientboundPacket26_1;
import com.viaversion.viaversion.protocols.v1_21_11to26_1.packet.ClientboundPackets26_1;
import com.viaversion.viaversion.protocols.v1_21_11to26_1.packet.ServerboundPacket26_1;
import com.viaversion.viaversion.protocols.v1_21_11to26_1.packet.ServerboundPackets26_1;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.rewriter.RecipeDisplayRewriter1_21_5;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.packet.ClientboundConfigurationPackets1_21_9;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.packet.ServerboundConfigurationPackets1_21_9;
import com.viaversion.viaversion.protocols.v26_1to26_2.Protocol26_1To26_2;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.RecipeDisplayRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;
import com.viaversion.viaversion.rewriter.block.BlockRewriter1_21_5;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.ProtocolUtil;

public class Protocol26_2To26_1
extends BackwardsProtocol<ClientboundPacket26_1, ClientboundPacket26_1, ServerboundPacket26_1, ServerboundPacket26_1> {
    public static final BackwardsMappingData MAPPINGS = new BackwardsMappingData("26.2", "26.1", Protocol26_1To26_2.class);
    private static final int WHITE_TEAM_COLOR = 15;
    private final EntityPacketRewriter26_2 entityRewriter = new EntityPacketRewriter26_2(this);
    private final BlockItemPacketRewriter26_2 itemRewriter = new BlockItemPacketRewriter26_2(this);
    private final ParticleRewriter<ClientboundPacket26_1> particleRewriter = new ParticleRewriter<ClientboundPacket26_1>(this);
    private final NBTComponentRewriter<ClientboundPacket26_1> translatableRewriter = new ComponentRewriter26_2(this);
    private final TagRewriter<ClientboundPacket26_1> tagRewriter = new TagRewriter<ClientboundPacket26_1>(this);
    private final BlockRewriter<ClientboundPacket26_1> blockRewriter = new BlockRewriter1_21_5<ClientboundPacket26_1>(this, ChunkType26_1::new);
    private final RecipeDisplayRewriter<ClientboundPacket26_1> recipeRewriter = new RecipeDisplayRewriter1_21_5<ClientboundPacket26_1>(this);
    private final BackwardsRegistryRewriter registryDataRewriter = new BackwardsRegistryRewriter(this){

        @Override
        public void updateEnchantmentTerm(CompoundTag compoundTag) {
            CompoundTag compoundTag2;
            Tag tag;
            super.updateEnchantmentTerm(compoundTag);
            String string = compoundTag.getString("condition");
            if (Key.equals(string, "entity_properties") && (tag = (compoundTag2 = compoundTag.getCompoundTag("predicate")).remove("entity_type")) != null) {
                compoundTag2.put("type", tag);
            }
        }
    };

    public Protocol26_2To26_1() {
        super(ClientboundPacket26_1.class, ClientboundPacket26_1.class, ServerboundPacket26_1.class, ServerboundPacket26_1.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        this.replaceClientbound(ClientboundPackets26_1.SET_PLAYER_TEAM, packetWrapper -> {
            packetWrapper.passthrough(Types.STRING);
            byte by = packetWrapper.passthrough(Types.BYTE);
            if (by == 0 || by == 2) {
                this.translatableRewriter.passthroughAndProcess(packetWrapper);
                Tag tag = packetWrapper.read(Types.TAG);
                Tag tag2 = packetWrapper.read(Types.TAG);
                this.translatableRewriter.processTag(packetWrapper.user(), tag);
                this.translatableRewriter.processTag(packetWrapper.user(), tag2);
                int n = packetWrapper.read(Types.VAR_INT);
                int n2 = packetWrapper.read(Types.VAR_INT);
                Integer n3 = packetWrapper.read(Types.BOOL_OPTIONAL_VAR_INT);
                byte by2 = packetWrapper.read(Types.BYTE);
                packetWrapper.write(Types.BYTE, by2);
                packetWrapper.write(Types.VAR_INT, n);
                packetWrapper.write(Types.VAR_INT, n2);
                packetWrapper.write(Types.VAR_INT, n3 != null ? n3 : 15);
                packetWrapper.write(Types.TAG, tag);
                packetWrapper.write(Types.TAG, tag2);
            }
        });
        this.registerClientbound(State.LOGIN, ClientboundLoginPackets.LOGIN_FINISHED, (PacketWrapper packetWrapper) -> {
            packetWrapper.passthrough(Types.UUID);
            packetWrapper.passthrough(Types.STRING);
            packetWrapper.passthrough(Types.PROFILE_PROPERTY_ARRAY);
            packetWrapper.read(Types.UUID);
        });
        this.registryDataRewriter.remove("sulfur_cube_archetype");
    }

    @Override
    public void init(UserConnection userConnection) {
        this.addEntityTracker(userConnection);
        this.addItemHasher(userConnection);
    }

    @Override
    public BackwardsMappingData getMappingData() {
        return MAPPINGS;
    }

    public EntityPacketRewriter26_2 getEntityRewriter() {
        return this.entityRewriter;
    }

    public BlockItemPacketRewriter26_2 getItemRewriter() {
        return this.itemRewriter;
    }

    @Override
    public BlockRewriter<ClientboundPacket26_1> getBlockRewriter() {
        return this.blockRewriter;
    }

    @Override
    public RecipeDisplayRewriter<ClientboundPacket26_1> getRecipeRewriter() {
        return this.recipeRewriter;
    }

    @Override
    public BackwardsRegistryRewriter getRegistryDataRewriter() {
        return this.registryDataRewriter;
    }

    @Override
    public ParticleRewriter<ClientboundPacket26_1> getParticleRewriter() {
        return this.particleRewriter;
    }

    @Override
    public NBTComponentRewriter<ClientboundPacket26_1> getComponentRewriter() {
        return this.translatableRewriter;
    }

    @Override
    public TagRewriter<ClientboundPacket26_1> getTagRewriter() {
        return this.tagRewriter;
    }

    @Override
    public Types26_1<StructuredDataKeys26_2, EntityDataTypes26_1> types() {
        return VersionedTypes.V26_2;
    }

    @Override
    public Types26_1<StructuredDataKeys1_21_11, EntityDataTypes26_1> mappedTypes() {
        return VersionedTypes.V26_1;
    }

    @Override
    protected PacketTypesProvider<ClientboundPacket26_1, ClientboundPacket26_1, ServerboundPacket26_1, ServerboundPacket26_1> createPacketTypesProvider() {
        return new SimplePacketTypesProvider<ClientboundPacket26_1, ClientboundPacket26_1, ServerboundPacket26_1, ServerboundPacket26_1>(ProtocolUtil.packetTypeMap(this.unmappedClientboundPacketType, ClientboundPackets26_1.class, ClientboundConfigurationPackets1_21_9.class), ProtocolUtil.packetTypeMap(this.mappedClientboundPacketType, ClientboundPackets26_1.class, ClientboundConfigurationPackets1_21_9.class), ProtocolUtil.packetTypeMap(this.mappedServerboundPacketType, ServerboundPackets26_1.class, ServerboundConfigurationPackets1_21_9.class), ProtocolUtil.packetTypeMap(this.unmappedServerboundPacketType, ServerboundPackets26_1.class, ServerboundConfigurationPackets1_21_9.class));
    }
}


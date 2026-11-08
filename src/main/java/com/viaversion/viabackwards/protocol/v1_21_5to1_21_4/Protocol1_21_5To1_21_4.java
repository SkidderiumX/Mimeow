/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_5to1_21_4;

import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.data.BackwardsMappingData;
import com.viaversion.viabackwards.api.rewriters.BackwardsRegistryRewriter;
import com.viaversion.viabackwards.protocol.v1_21_5to1_21_4.rewriter.BlockItemPacketRewriter1_21_5;
import com.viaversion.viabackwards.protocol.v1_21_5to1_21_4.rewriter.BlockPacketRewriter1_21_5;
import com.viaversion.viabackwards.protocol.v1_21_5to1_21_4.rewriter.ComponentRewriter1_21_5;
import com.viaversion.viabackwards.protocol.v1_21_5to1_21_4.rewriter.EntityPacketRewriter1_21_5;
import com.viaversion.viabackwards.protocol.v1_21_5to1_21_4.rewriter.RegistryDataRewriter1_21_5;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.Particle;
import com.viaversion.viaversion.api.minecraft.data.version.StructuredDataKeys1_21_2;
import com.viaversion.viaversion.api.minecraft.data.version.StructuredDataKeys1_21_5;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_4;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_2;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_5;
import com.viaversion.viaversion.api.minecraft.item.data.ArmorTrimPattern;
import com.viaversion.viaversion.api.minecraft.item.data.ChatType;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.provider.PacketTypesProvider;
import com.viaversion.viaversion.api.protocol.packet.provider.SimplePacketTypesProvider;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_20_5;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.rewriter.CommandRewriter1_19_4;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundConfigurationPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundConfigurationPackets1_21;
import com.viaversion.viaversion.protocols.v1_21_2to1_21_4.packet.ServerboundPacket1_21_4;
import com.viaversion.viaversion.protocols.v1_21_2to1_21_4.packet.ServerboundPackets1_21_4;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.Protocol1_21_4To1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ClientboundPacket1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ClientboundPackets1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ServerboundPacket1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ServerboundPackets1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.rewriter.RecipeDisplayRewriter1_21_5;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPacket1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPackets1_21_2;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.RecipeDisplayRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.Limit;
import com.viaversion.viaversion.util.ProtocolUtil;

public class Protocol1_21_5To1_21_4
extends BackwardsProtocol<ClientboundPacket1_21_5, ClientboundPacket1_21_2, ServerboundPacket1_21_5, ServerboundPacket1_21_4> {
    public static final BackwardsMappingData MAPPINGS = new BackwardsMappingData("1.21.5", "1.21.4", Protocol1_21_4To1_21_5.class);
    private final EntityPacketRewriter1_21_5 entityRewriter = new EntityPacketRewriter1_21_5(this);
    private final BlockItemPacketRewriter1_21_5 itemRewriter = new BlockItemPacketRewriter1_21_5(this);
    private final ParticleRewriter<ClientboundPacket1_21_5> particleRewriter = new ParticleRewriter<ClientboundPacket1_21_5>((Protocol)this){

        @Override
        public void rewriteParticle(UserConnection userConnection, Particle particle) {
            if (particle.id() == MAPPINGS.getParticleMappings().id("tinted_leaves")) {
                particle.getArguments().clear();
            }
            super.rewriteParticle(userConnection, particle);
        }
    };
    private final ComponentRewriter1_21_5 translatableRewriter = new ComponentRewriter1_21_5(this);
    private final TagRewriter<ClientboundPacket1_21_5> tagRewriter = new TagRewriter<ClientboundPacket1_21_5>(this);
    private final RecipeDisplayRewriter<ClientboundPacket1_21_5> recipeRewriter = new RecipeDisplayRewriter1_21_5<ClientboundPacket1_21_5>((Protocol)this){

        @Override
        protected void handleSmithingTrimSlotDisplay(PacketWrapper packetWrapper) {
            this.handleSlotDisplay(packetWrapper);
            this.handleSlotDisplay(packetWrapper);
            packetWrapper.read(ArmorTrimPattern.TYPE1_21_5);
            packetWrapper.write(Types.VAR_INT, 0);
        }
    };
    private final BackwardsRegistryRewriter registryDataRewriter = new RegistryDataRewriter1_21_5(this);
    private final BlockRewriter<ClientboundPacket1_21_5> blockRewriter = new BlockPacketRewriter1_21_5(this);

    public Protocol1_21_5To1_21_4() {
        super(ClientboundPacket1_21_5.class, ClientboundPacket1_21_2.class, ServerboundPacket1_21_5.class, ServerboundPacket1_21_4.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        CommandRewriter1_19_4<ClientboundPacket1_21_5> commandRewriter1_19_4 = new CommandRewriter1_19_4<ClientboundPacket1_21_5>((Protocol)this){

            @Override
            public void handleArgument(PacketWrapper packetWrapper, String string) {
                if (string.equals("minecraft:resource")) {
                    String string2 = packetWrapper.read(Types.STRING);
                    if (Key.equals(string2, "test_instance")) {
                        string2 = "minecraft:item";
                    }
                    packetWrapper.write(Types.STRING, string2);
                } else if (string.equals("minecraft:resource_selector")) {
                    packetWrapper.read(Types.STRING);
                    packetWrapper.write(Types.VAR_INT, 1);
                } else {
                    super.handleArgument(packetWrapper, string);
                }
            }
        };
        this.replaceClientbound(ClientboundPackets1_21_5.COMMANDS, commandRewriter1_19_4::handle1_19);
        this.replaceClientbound(ClientboundPackets1_21_5.PLAYER_CHAT, packetWrapper -> {
            int n;
            packetWrapper.read(Types.VAR_INT);
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
            this.translatableRewriter.processTag(packetWrapper.user(), packetWrapper.passthrough(Types.TRUSTED_OPTIONAL_TAG));
            n = packetWrapper.passthrough(Types.VAR_INT);
            if (n == 2) {
                packetWrapper.passthrough(Types.LONG_ARRAY_PRIMITIVE);
            }
            packetWrapper.passthrough(ChatType.TYPE);
            this.translatableRewriter.processTag(packetWrapper.user(), packetWrapper.passthrough(Types.TRUSTED_TAG));
            this.translatableRewriter.processTag(packetWrapper.user(), packetWrapper.passthrough(Types.TRUSTED_OPTIONAL_TAG));
        });
        this.registerServerbound(ServerboundPackets1_21_4.CHAT_COMMAND_SIGNED, packetWrapper -> {
            packetWrapper.passthrough(Types.STRING);
            packetWrapper.passthrough(Types.LONG);
            packetWrapper.passthrough(Types.LONG);
            int n = Limit.max(packetWrapper.passthrough(Types.VAR_INT), 8);
            for (int i = 0; i < n; ++i) {
                packetWrapper.passthrough(Types.STRING);
                packetWrapper.passthrough(Types.SIGNATURE_BYTES);
            }
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.ACKNOWLEDGED_BIT_SET);
            packetWrapper.write(Types.BYTE, (byte)0);
        });
        this.registerServerbound(ServerboundPackets1_21_4.CHAT, packetWrapper -> {
            packetWrapper.passthrough(Types.STRING);
            packetWrapper.passthrough(Types.LONG);
            packetWrapper.passthrough(Types.LONG);
            packetWrapper.passthrough(Types.OPTIONAL_SIGNATURE_BYTES);
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.ACKNOWLEDGED_BIT_SET);
            packetWrapper.write(Types.BYTE, (byte)0);
        });
        this.cancelClientbound(ClientboundPackets1_21_5.TEST_INSTANCE_BLOCK_STATUS);
    }

    @Override
    public void init(UserConnection userConnection) {
        this.addEntityTracker(userConnection, new EntityTrackerBase(userConnection, EntityTypes1_21_4.PLAYER));
        this.addItemHasher(userConnection);
    }

    @Override
    public BackwardsMappingData getMappingData() {
        return MAPPINGS;
    }

    public EntityPacketRewriter1_21_5 getEntityRewriter() {
        return this.entityRewriter;
    }

    public BlockItemPacketRewriter1_21_5 getItemRewriter() {
        return this.itemRewriter;
    }

    @Override
    public BlockRewriter<ClientboundPacket1_21_5> getBlockRewriter() {
        return this.blockRewriter;
    }

    @Override
    public BackwardsRegistryRewriter getRegistryDataRewriter() {
        return this.registryDataRewriter;
    }

    @Override
    public ParticleRewriter<ClientboundPacket1_21_5> getParticleRewriter() {
        return this.particleRewriter;
    }

    @Override
    public ComponentRewriter1_21_5 getComponentRewriter() {
        return this.translatableRewriter;
    }

    @Override
    public TagRewriter<ClientboundPacket1_21_5> getTagRewriter() {
        return this.tagRewriter;
    }

    @Override
    public RecipeDisplayRewriter<ClientboundPacket1_21_5> getRecipeRewriter() {
        return this.recipeRewriter;
    }

    @Override
    public Types1_20_5<StructuredDataKeys1_21_5, EntityDataTypes1_21_5> types() {
        return VersionedTypes.V1_21_5;
    }

    @Override
    public Types1_20_5<StructuredDataKeys1_21_2, EntityDataTypes1_21_2> mappedTypes() {
        return VersionedTypes.V1_21_4;
    }

    @Override
    protected PacketTypesProvider<ClientboundPacket1_21_5, ClientboundPacket1_21_2, ServerboundPacket1_21_5, ServerboundPacket1_21_4> createPacketTypesProvider() {
        return new SimplePacketTypesProvider<ClientboundPacket1_21_5, ClientboundPacket1_21_2, ServerboundPacket1_21_5, ServerboundPacket1_21_4>(ProtocolUtil.packetTypeMap(this.unmappedClientboundPacketType, ClientboundPackets1_21_5.class, ClientboundConfigurationPackets1_21.class), ProtocolUtil.packetTypeMap(this.mappedClientboundPacketType, ClientboundPackets1_21_2.class, ClientboundConfigurationPackets1_21.class), ProtocolUtil.packetTypeMap(this.mappedServerboundPacketType, ServerboundPackets1_21_5.class, ServerboundConfigurationPackets1_20_5.class), ProtocolUtil.packetTypeMap(this.unmappedServerboundPacketType, ServerboundPackets1_21_4.class, ServerboundConfigurationPackets1_20_5.class));
    }
}


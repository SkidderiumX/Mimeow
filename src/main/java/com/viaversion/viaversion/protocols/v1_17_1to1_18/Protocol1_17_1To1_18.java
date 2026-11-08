/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_17_1to1_18;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.MappingData;
import com.viaversion.viaversion.api.data.MappingDataBase;
import com.viaversion.viaversion.api.minecraft.RegistryType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_17;
import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.misc.ParticleType;
import com.viaversion.viaversion.api.type.types.version.Types1_18;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.protocols.v1_16_4to1_17.packet.ServerboundPackets1_17;
import com.viaversion.viaversion.protocols.v1_17_1to1_18.packet.ClientboundPackets1_18;
import com.viaversion.viaversion.protocols.v1_17_1to1_18.rewriter.ComponentRewriter1_18;
import com.viaversion.viaversion.protocols.v1_17_1to1_18.rewriter.EntityPacketRewriter1_18;
import com.viaversion.viaversion.protocols.v1_17_1to1_18.rewriter.ItemPacketRewriter1_18;
import com.viaversion.viaversion.protocols.v1_17_1to1_18.rewriter.WorldPacketRewriter1_18;
import com.viaversion.viaversion.protocols.v1_17_1to1_18.storage.ChunkLightStorage;
import com.viaversion.viaversion.protocols.v1_17to1_17_1.packet.ClientboundPackets1_17_1;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;
import com.viaversion.viaversion.util.ProtocolLogger;

public class Protocol1_17_1To1_18
extends AbstractProtocol<ClientboundPackets1_17_1, ClientboundPackets1_18, ServerboundPackets1_17, ServerboundPackets1_17> {
    public static final MappingData MAPPINGS = new MappingDataBase("1.17", "1.18");
    public static final ProtocolLogger LOGGER = new ProtocolLogger(Protocol1_17_1To1_18.class);
    private final EntityPacketRewriter1_18 entityRewriter = new EntityPacketRewriter1_18(this);
    private final ItemPacketRewriter1_18 itemRewriter = new ItemPacketRewriter1_18(this);
    private final ParticleRewriter<ClientboundPackets1_17_1> particleRewriter = new ParticleRewriter<ClientboundPackets1_17_1>(this);
    private final ComponentRewriter1_18 componentRewriter = new ComponentRewriter1_18(this);
    private final BlockRewriter<ClientboundPackets1_17_1> blockRewriter = BlockRewriter.for1_14(this);
    private final TagRewriter<ClientboundPackets1_17_1> tagRewriter = new TagRewriter<ClientboundPackets1_17_1>(this);

    public Protocol1_17_1To1_18() {
        super(ClientboundPackets1_17_1.class, ClientboundPackets1_18.class, ServerboundPackets1_17.class, ServerboundPackets1_17.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        WorldPacketRewriter1_18.register(this);
        this.registerServerbound(ServerboundPackets1_17.CLIENT_INFORMATION, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.map(Types.BYTE);
                this.map(Types.VAR_INT);
                this.map(Types.BOOLEAN);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.VAR_INT);
                this.map(Types.BOOLEAN);
                this.read(Types.BOOLEAN);
            }
        });
    }

    @Override
    protected void onMappingDataLoaded() {
        ParticleType.Fillers.fill1_18(this, Types1_18.PARTICLE);
        this.tagRewriter.renameTag(RegistryType.BLOCK, "minecraft:lava_pool_stone_replaceables", "minecraft:lava_pool_stone_cannot_replace");
        super.onMappingDataLoaded();
    }

    @Override
    public MappingData getMappingData() {
        return MAPPINGS;
    }

    @Override
    public ProtocolLogger getLogger() {
        return LOGGER;
    }

    @Override
    public void init(UserConnection userConnection) {
        this.addEntityTracker(userConnection, new EntityTrackerBase(userConnection, EntityTypes1_17.PLAYER));
        userConnection.put(new ChunkLightStorage());
    }

    public EntityPacketRewriter1_18 getEntityRewriter() {
        return this.entityRewriter;
    }

    public ItemPacketRewriter1_18 getItemRewriter() {
        return this.itemRewriter;
    }

    @Override
    public BlockRewriter<ClientboundPackets1_17_1> getBlockRewriter() {
        return this.blockRewriter;
    }

    @Override
    public ParticleRewriter<ClientboundPackets1_17_1> getParticleRewriter() {
        return this.particleRewriter;
    }

    @Override
    public ComponentRewriter1_18 getComponentRewriter() {
        return this.componentRewriter;
    }

    @Override
    public TagRewriter<ClientboundPackets1_17_1> getTagRewriter() {
        return this.tagRewriter;
    }
}


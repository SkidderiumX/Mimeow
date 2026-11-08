/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_16_1to1_16_2;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.RegistryType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_16_2;
import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.protocols.v1_15_2to1_16.packet.ClientboundPackets1_16;
import com.viaversion.viaversion.protocols.v1_15_2to1_16.packet.ServerboundPackets1_16;
import com.viaversion.viaversion.protocols.v1_16_1to1_16_2.data.MappingData1_16_2;
import com.viaversion.viaversion.protocols.v1_16_1to1_16_2.packet.ClientboundPackets1_16_2;
import com.viaversion.viaversion.protocols.v1_16_1to1_16_2.packet.ServerboundPackets1_16_2;
import com.viaversion.viaversion.protocols.v1_16_1to1_16_2.rewriter.EntityPacketRewriter1_16_2;
import com.viaversion.viaversion.protocols.v1_16_1to1_16_2.rewriter.ItemPacketRewriter1_16_2;
import com.viaversion.viaversion.protocols.v1_16_1to1_16_2.rewriter.WorldPacketRewriter1_16_2;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;

public class Protocol1_16_1To1_16_2
extends AbstractProtocol<ClientboundPackets1_16, ClientboundPackets1_16_2, ServerboundPackets1_16, ServerboundPackets1_16_2> {
    public static final MappingData1_16_2 MAPPINGS = new MappingData1_16_2();
    private final EntityPacketRewriter1_16_2 entityRewriter = new EntityPacketRewriter1_16_2(this);
    private final ItemPacketRewriter1_16_2 itemRewriter = new ItemPacketRewriter1_16_2(this);
    private final ParticleRewriter<ClientboundPackets1_16> particleRewriter = new ParticleRewriter<ClientboundPackets1_16>(this);
    private final TagRewriter<ClientboundPackets1_16> tagRewriter = new TagRewriter<ClientboundPackets1_16>(this);
    private final BlockRewriter<ClientboundPackets1_16> blockRewriter = BlockRewriter.for1_14(this);

    public Protocol1_16_1To1_16_2() {
        super(ClientboundPackets1_16.class, ClientboundPackets1_16_2.class, ServerboundPackets1_16.class, ServerboundPackets1_16_2.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        WorldPacketRewriter1_16_2.register(this);
        this.tagRewriter.register(ClientboundPackets1_16.UPDATE_TAGS, RegistryType.ENTITY);
        this.registerServerbound(ServerboundPackets1_16_2.RECIPE_BOOK_CHANGE_SETTINGS, ServerboundPackets1_16.RECIPE_BOOK_UPDATE, (PacketWrapper packetWrapper) -> {
            int n = packetWrapper.read(Types.VAR_INT);
            boolean bl = packetWrapper.read(Types.BOOLEAN);
            boolean bl2 = packetWrapper.read(Types.BOOLEAN);
            packetWrapper.write(Types.VAR_INT, 1);
            packetWrapper.write(Types.BOOLEAN, n == 0 && bl);
            packetWrapper.write(Types.BOOLEAN, bl2);
            packetWrapper.write(Types.BOOLEAN, n == 1 && bl);
            packetWrapper.write(Types.BOOLEAN, bl2);
            packetWrapper.write(Types.BOOLEAN, n == 2 && bl);
            packetWrapper.write(Types.BOOLEAN, bl2);
            packetWrapper.write(Types.BOOLEAN, n == 3 && bl);
            packetWrapper.write(Types.BOOLEAN, bl2);
        });
        this.registerServerbound(ServerboundPackets1_16_2.RECIPE_BOOK_SEEN_RECIPE, ServerboundPackets1_16.RECIPE_BOOK_UPDATE, (PacketWrapper packetWrapper) -> {
            String string = packetWrapper.read(Types.STRING);
            packetWrapper.write(Types.VAR_INT, 0);
            packetWrapper.write(Types.STRING, string);
        });
    }

    @Override
    protected void onMappingDataLoaded() {
        EntityTypes1_16_2.initialize(this);
        this.tagRewriter.removeTag(RegistryType.ITEM, "minecraft:furnace_materials");
        super.onMappingDataLoaded();
    }

    @Override
    public void init(UserConnection userConnection) {
        userConnection.addEntityTracker(this.getClass(), new EntityTrackerBase(userConnection, EntityTypes1_16_2.PLAYER));
    }

    @Override
    public MappingData1_16_2 getMappingData() {
        return MAPPINGS;
    }

    public EntityPacketRewriter1_16_2 getEntityRewriter() {
        return this.entityRewriter;
    }

    public ItemPacketRewriter1_16_2 getItemRewriter() {
        return this.itemRewriter;
    }

    @Override
    public BlockRewriter<ClientboundPackets1_16> getBlockRewriter() {
        return this.blockRewriter;
    }

    @Override
    public ParticleRewriter<ClientboundPackets1_16> getParticleRewriter() {
        return this.particleRewriter;
    }

    @Override
    public TagRewriter<ClientboundPackets1_16> getTagRewriter() {
        return this.tagRewriter;
    }
}


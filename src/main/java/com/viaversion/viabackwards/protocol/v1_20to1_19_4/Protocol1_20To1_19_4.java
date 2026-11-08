/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_20to1_19_4;

import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.rewriters.text.JsonNBTComponentRewriter;
import com.viaversion.viabackwards.protocol.v1_20to1_19_4.data.BackwardsMappingData1_20;
import com.viaversion.viabackwards.protocol.v1_20to1_19_4.rewriter.BlockItemPacketRewriter1_20;
import com.viaversion.viabackwards.protocol.v1_20to1_19_4.rewriter.BlockPacketRewriter1_20;
import com.viaversion.viabackwards.protocol.v1_20to1_19_4.rewriter.EntityPacketRewriter1_20;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.RegistryType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_19_4;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.packet.ClientboundPackets1_19_4;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.packet.ServerboundPackets1_19_4;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.util.ArrayUtil;

public class Protocol1_20To1_19_4
extends BackwardsProtocol<ClientboundPackets1_19_4, ClientboundPackets1_19_4, ServerboundPackets1_19_4, ServerboundPackets1_19_4> {
    public static final BackwardsMappingData1_20 MAPPINGS = new BackwardsMappingData1_20();
    private final JsonNBTComponentRewriter<ClientboundPackets1_19_4> translatableRewriter = new JsonNBTComponentRewriter<ClientboundPackets1_19_4>(this, ComponentRewriterBase.ReadType.JSON);
    private final EntityPacketRewriter1_20 entityRewriter = new EntityPacketRewriter1_20(this);
    private final BlockItemPacketRewriter1_20 itemRewriter = new BlockItemPacketRewriter1_20(this);
    private final ParticleRewriter<ClientboundPackets1_19_4> particleRewriter = new ParticleRewriter<ClientboundPackets1_19_4>(this);
    private final TagRewriter<ClientboundPackets1_19_4> tagRewriter = new TagRewriter<ClientboundPackets1_19_4>(this);
    private final BlockRewriter<ClientboundPackets1_19_4> blockRewriter = new BlockPacketRewriter1_20(this);

    public Protocol1_20To1_19_4() {
        super(ClientboundPackets1_19_4.class, ClientboundPackets1_19_4.class, ServerboundPackets1_19_4.class, ServerboundPackets1_19_4.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        this.tagRewriter.addEmptyTag(RegistryType.BLOCK, "minecraft:replaceable_plants");
        this.registerClientbound(ClientboundPackets1_19_4.UPDATE_ENABLED_FEATURES, packetWrapper -> {
            String[] stringArray = packetWrapper.read(Types.STRING_ARRAY);
            packetWrapper.write(Types.STRING_ARRAY, ArrayUtil.add(stringArray, "minecraft:update_1_20"));
        });
        this.registerClientbound(ClientboundPackets1_19_4.PLAYER_COMBAT_END, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.write(Types.INT, -1);
        });
        this.replaceClientbound(ClientboundPackets1_19_4.PLAYER_COMBAT_KILL, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.write(Types.INT, -1);
            this.translatableRewriter.processText(packetWrapper.user(), packetWrapper.passthrough(Types.COMPONENT));
        });
    }

    @Override
    public void init(UserConnection userConnection) {
        this.addEntityTracker(userConnection, new EntityTrackerBase(userConnection, EntityTypes1_19_4.PLAYER));
    }

    @Override
    public BackwardsMappingData1_20 getMappingData() {
        return MAPPINGS;
    }

    public EntityPacketRewriter1_20 getEntityRewriter() {
        return this.entityRewriter;
    }

    public BlockItemPacketRewriter1_20 getItemRewriter() {
        return this.itemRewriter;
    }

    @Override
    public BlockRewriter<ClientboundPackets1_19_4> getBlockRewriter() {
        return this.blockRewriter;
    }

    @Override
    public ParticleRewriter<ClientboundPackets1_19_4> getParticleRewriter() {
        return this.particleRewriter;
    }

    @Override
    public JsonNBTComponentRewriter<ClientboundPackets1_19_4> getComponentRewriter() {
        return this.translatableRewriter;
    }

    @Override
    public TagRewriter<ClientboundPackets1_19_4> getTagRewriter() {
        return this.tagRewriter;
    }
}


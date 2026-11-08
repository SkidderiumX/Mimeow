/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_12to1_11_1;

import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.data.BackwardsMappingData;
import com.viaversion.viabackwards.protocol.v1_12to1_11_1.rewriter.BlockItemPacketRewriter1_12;
import com.viaversion.viabackwards.protocol.v1_12to1_11_1.rewriter.ComponentRewriter1_12;
import com.viaversion.viabackwards.protocol.v1_12to1_11_1.rewriter.EntityPacketRewriter1_12;
import com.viaversion.viabackwards.protocol.v1_12to1_11_1.rewriter.SoundPacketRewriter1_12;
import com.viaversion.viabackwards.protocol.v1_12to1_11_1.storage.ShoulderTracker;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_12;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.protocols.v1_11_1to1_12.packet.ClientboundPackets1_12;
import com.viaversion.viaversion.protocols.v1_11_1to1_12.packet.ServerboundPackets1_12;
import com.viaversion.viaversion.protocols.v1_9_1to1_9_3.packet.ClientboundPackets1_9_3;
import com.viaversion.viaversion.protocols.v1_9_1to1_9_3.packet.ServerboundPackets1_9_3;
import com.viaversion.viaversion.util.ComponentUtil;
import com.viaversion.viaversion.util.SerializerVersion;

public class Protocol1_12To1_11_1
extends BackwardsProtocol<ClientboundPackets1_12, ClientboundPackets1_9_3, ServerboundPackets1_12, ServerboundPackets1_9_3> {
    private static final BackwardsMappingData MAPPINGS = new BackwardsMappingData("1.12", "1.11");
    private final EntityPacketRewriter1_12 entityRewriter = new EntityPacketRewriter1_12(this);
    private final BlockItemPacketRewriter1_12 itemRewriter = new BlockItemPacketRewriter1_12(this);
    private final ComponentRewriter1_12 componentRewriter = new ComponentRewriter1_12(this);

    public Protocol1_12To1_11_1() {
        super(ClientboundPackets1_12.class, ClientboundPackets1_9_3.class, ServerboundPackets1_12.class, ServerboundPackets1_9_3.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        this.componentRewriter.registerComponentPacket(ClientboundPackets1_12.CHAT);
        new SoundPacketRewriter1_12(this).register();
        this.registerClientbound(ClientboundPackets1_12.SET_TITLES, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            if (n >= 0 && n <= 2) {
                String string = packetWrapper.read(Types.COMPONENT).toString();
                packetWrapper.write(Types.COMPONENT, ComponentUtil.convertJsonOrEmpty(string, SerializerVersion.V1_12, SerializerVersion.V1_9));
            }
        });
        this.cancelClientbound(ClientboundPackets1_12.UPDATE_ADVANCEMENTS);
        this.cancelClientbound(ClientboundPackets1_12.RECIPE);
        this.cancelClientbound(ClientboundPackets1_12.SELECT_ADVANCEMENTS_TAB);
    }

    @Override
    public void init(UserConnection userConnection) {
        userConnection.addEntityTracker(this.getClass(), new EntityTrackerBase(userConnection, EntityTypes1_12.EntityType.PLAYER));
        userConnection.addClientWorld(this.getClass(), new ClientWorld());
        userConnection.put(new ShoulderTracker(userConnection));
    }

    @Override
    public BackwardsMappingData getMappingData() {
        return MAPPINGS;
    }

    public EntityPacketRewriter1_12 getEntityRewriter() {
        return this.entityRewriter;
    }

    public BlockItemPacketRewriter1_12 getItemRewriter() {
        return this.itemRewriter;
    }

    @Override
    public ComponentRewriter1_12 getComponentRewriter() {
        return this.componentRewriter;
    }
}


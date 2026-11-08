/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_9_3to1_10.rewriter;

import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_9;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_9_1to1_9_3.packet.ClientboundPackets1_9_3;
import com.viaversion.viaversion.protocols.v1_9_3to1_10.Protocol1_9_3To1_10;
import com.viaversion.viaversion.rewriter.EntityRewriter;
import java.util.List;

public class EntityPacketRewriter1_10
extends EntityRewriter<ClientboundPackets1_9_3, Protocol1_9_3To1_10> {
    public EntityPacketRewriter1_10(Protocol1_9_3To1_10 protocol1_9_3To1_10) {
        super(protocol1_9_3To1_10);
    }

    @Override
    protected void registerPackets() {
        ((Protocol1_9_3To1_10)this.protocol).registerClientbound(ClientboundPackets1_9_3.ADD_ENTITY, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.UUID);
            packetWrapper.passthrough(Types.BYTE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.BYTE);
            packetWrapper.passthrough(Types.BYTE);
            packetWrapper.passthrough(Types.INT);
            this.objectTrackerHandler().handle(packetWrapper);
        });
        ((Protocol1_9_3To1_10)this.protocol).registerClientbound(ClientboundPackets1_9_3.ADD_MOB, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.UUID);
            short s = packetWrapper.passthrough(Types.UNSIGNED_BYTE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.BYTE);
            packetWrapper.passthrough(Types.BYTE);
            packetWrapper.passthrough(Types.BYTE);
            packetWrapper.passthrough(Types.SHORT);
            packetWrapper.passthrough(Types.SHORT);
            packetWrapper.passthrough(Types.SHORT);
            List<EntityData> list = packetWrapper.passthrough(Types.ENTITY_DATA_LIST1_9);
            this.trackAndRewrite(packetWrapper, s, n);
            this.handleEntityData(n, list, packetWrapper.user());
        });
        ((Protocol1_9_3To1_10)this.protocol).registerClientbound(ClientboundPackets1_9_3.ADD_PLAYER, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.UUID);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.BYTE);
            packetWrapper.passthrough(Types.BYTE);
            List<EntityData> list = packetWrapper.passthrough(Types.ENTITY_DATA_LIST1_9);
            this.tracker(packetWrapper.user()).addEntity(n, EntityTypes1_9.EntityType.PLAYER);
            this.handleEntityData(n, list, packetWrapper.user());
        });
        this.registerSetEntityData(ClientboundPackets1_9_3.SET_ENTITY_DATA, Types.ENTITY_DATA_LIST1_9);
        this.registerRemoveEntities(ClientboundPackets1_9_3.REMOVE_ENTITIES);
    }

    @Override
    protected void registerRewrites() {
        this.filter().type(EntityTypes1_9.EntityType.POTION).removeIndex(5);
        this.filter().addIndex(5);
    }

    @Override
    public EntityTypes1_9.EntityType typeFromId(int n) {
        return EntityTypes1_9.EntityType.findById(n);
    }

    @Override
    public EntityTypes1_9.EntityType objectTypeFromId(int n, int n2) {
        return EntityTypes1_9.ObjectType.getEntityType(n, n2);
    }
}


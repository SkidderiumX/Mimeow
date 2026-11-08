/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_11_1to1_12.rewriter;

import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_12;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_11_1to1_12.Protocol1_11_1To1_12;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.Protocol1_12_2To1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ClientboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_9_1to1_9_3.packet.ClientboundPackets1_9_3;
import com.viaversion.viaversion.rewriter.EntityRewriter;

public class EntityPacketRewriter1_12
extends EntityRewriter<ClientboundPackets1_9_3, Protocol1_11_1To1_12> {
    public EntityPacketRewriter1_12(Protocol1_11_1To1_12 protocol1_11_1To1_12) {
        super(protocol1_11_1To1_12);
    }

    @Override
    protected void registerPackets() {
        ((Protocol1_11_1To1_12)this.protocol).registerClientbound(ClientboundPackets1_9_3.LOGIN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.INT);
                this.handler(packetWrapper2 -> {
                    Object t = packetWrapper2.user().getClientWorld(Protocol1_11_1To1_12.class);
                    int n = packetWrapper2.get(Types.INT, 1);
                    ((ClientWorld)t).setEnvironment(n);
                    if (packetWrapper2.user().getProtocolInfo().protocolVersion().newerThanOrEqualTo(ProtocolVersion.v1_13)) {
                        packetWrapper2.create(ClientboundPackets1_13.UPDATE_RECIPES, packetWrapper -> packetWrapper.write(Types.VAR_INT, 0)).scheduleSend(Protocol1_12_2To1_13.class);
                    }
                });
            }
        });
        ((Protocol1_11_1To1_12)this.protocol).registerClientbound(ClientboundPackets1_9_3.RESPAWN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    int n;
                    Object t = packetWrapper.user().getClientWorld(Protocol1_11_1To1_12.class);
                    if (((ClientWorld)t).setEnvironment(n = packetWrapper.get(Types.INT, 0).intValue())) {
                        EntityPacketRewriter1_12.this.tracker(packetWrapper.user()).clearEntities();
                    }
                });
            }
        });
        ((Protocol1_11_1To1_12)this.protocol).registerClientbound(ClientboundPackets1_9_3.ADD_ENTITY, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.UUID);
                this.map(Types.BYTE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.INT);
                this.handler(EntityPacketRewriter1_12.this.objectTrackerHandler());
            }
        });
        ((Protocol1_11_1To1_12)this.protocol).registerClientbound(ClientboundPackets1_9_3.ADD_MOB, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.UUID);
                this.map(Types.VAR_INT);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.SHORT);
                this.map(Types.SHORT);
                this.map(Types.SHORT);
                this.map(Types.ENTITY_DATA_LIST1_9, Types.ENTITY_DATA_LIST1_12);
                this.handler(EntityPacketRewriter1_12.this.trackerAndRewriterHandler(Types.ENTITY_DATA_LIST1_12));
            }
        });
        this.registerRemoveEntities(ClientboundPackets1_9_3.REMOVE_ENTITIES);
        this.registerSetEntityData(ClientboundPackets1_9_3.SET_ENTITY_DATA, Types.ENTITY_DATA_LIST1_9, Types.ENTITY_DATA_LIST1_12);
    }

    @Override
    protected void registerRewrites() {
        this.filter().handler((entityDataHandlerEvent, entityData) -> {
            if (entityData.getValue() instanceof Item) {
                entityData.setValue(((Protocol1_11_1To1_12)this.protocol).getItemRewriter().handleItemToClient(entityDataHandlerEvent.user(), (Item)entityData.value()));
            }
        });
        this.filter().type(EntityTypes1_12.EntityType.ABSTRACT_ILLAGER).addIndex(12);
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_12.EntityType.findById(n);
    }

    @Override
    public EntityType objectTypeFromId(int n, int n2) {
        return EntityTypes1_12.ObjectType.getEntityType(n, n2);
    }
}


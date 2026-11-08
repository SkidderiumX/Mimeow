/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_14_4to1_15.rewriter;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_15;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_14;
import com.viaversion.viaversion.protocols.v1_14_3to1_14_4.packet.ClientboundPackets1_14_4;
import com.viaversion.viaversion.protocols.v1_14_4to1_15.Protocol1_14_4To1_15;
import com.viaversion.viaversion.protocols.v1_14_4to1_15.packet.ClientboundPackets1_15;
import com.viaversion.viaversion.rewriter.EntityRewriter;
import java.util.List;

public class EntityPacketRewriter1_15
extends EntityRewriter<ClientboundPackets1_14_4, Protocol1_14_4To1_15> {
    public EntityPacketRewriter1_15(Protocol1_14_4To1_15 protocol1_14_4To1_15) {
        super(protocol1_14_4To1_15);
    }

    @Override
    protected void registerPackets() {
        ((Protocol1_14_4To1_15)this.protocol).replaceClientbound(ClientboundPackets1_14_4.ADD_MOB, new PacketHandlers(){

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
                this.handler(EntityPacketRewriter1_15.this.trackerHandler());
                this.handler(packetWrapper -> EntityPacketRewriter1_15.this.sendEntityDataPacket(packetWrapper, packetWrapper.get(Types.VAR_INT, 0)));
            }
        });
        ((Protocol1_14_4To1_15)this.protocol).registerClientbound(ClientboundPackets1_14_4.ADD_PLAYER, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.UUID);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    packetWrapper.user().getEntityTracker(Protocol1_14_4To1_15.class).addEntity(n, EntityTypes1_15.PLAYER);
                    EntityPacketRewriter1_15.this.sendEntityDataPacket(packetWrapper, n);
                });
            }
        });
        ((Protocol1_14_4To1_15)this.protocol).registerClientbound(ClientboundPackets1_14_4.RESPAWN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    int n;
                    Object t = packetWrapper.user().getClientWorld(Protocol1_14_4To1_15.class);
                    if (((ClientWorld)t).setEnvironment(n = packetWrapper.get(Types.INT, 0).intValue())) {
                        EntityPacketRewriter1_15.this.tracker(packetWrapper.user()).clearEntities();
                    }
                    packetWrapper.write(Types.LONG, 0L);
                });
            }
        });
        ((Protocol1_14_4To1_15)this.protocol).registerClientbound(ClientboundPackets1_14_4.LOGIN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.INT);
                this.handler(EntityPacketRewriter1_15.this.playerTrackerHandler());
                this.handler(packetWrapper -> packetWrapper.write(Types.LONG, 0L));
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.STRING);
                this.map(Types.VAR_INT);
                this.map(Types.BOOLEAN);
                this.handler(packetWrapper -> packetWrapper.write(Types.BOOLEAN, !Via.getConfig().is1_15InstantRespawn()));
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.INT, 1);
                    Object t = packetWrapper.user().getClientWorld(Protocol1_14_4To1_15.class);
                    ((ClientWorld)t).setEnvironment(n);
                });
            }
        });
        this.registerSetEntityData(ClientboundPackets1_14_4.SET_ENTITY_DATA, Types1_14.ENTITY_DATA_LIST);
    }

    @Override
    protected void registerRewrites() {
        this.registerEntityDataTypeHandler(Types1_14.ENTITY_DATA_TYPES.itemType, Types1_14.ENTITY_DATA_TYPES.optionalBlockStateType, Types1_14.ENTITY_DATA_TYPES.particleType);
        this.registerBlockStateHandler(EntityTypes1_15.ABSTRACT_MINECART, 10);
        this.filter().type(EntityTypes1_15.LIVING_ENTITY).addIndex(12);
        this.filter().type(EntityTypes1_15.WOLF).removeIndex(18);
    }

    private void sendEntityDataPacket(PacketWrapper packetWrapper, int n) {
        List<EntityData> list = packetWrapper.read(Types1_14.ENTITY_DATA_LIST);
        if (list.isEmpty()) {
            return;
        }
        packetWrapper.send(Protocol1_14_4To1_15.class);
        packetWrapper.cancel();
        this.handleEntityData(n, list, packetWrapper.user());
        PacketWrapper packetWrapper2 = PacketWrapper.create(ClientboundPackets1_15.SET_ENTITY_DATA, packetWrapper.user());
        packetWrapper2.write(Types.VAR_INT, n);
        packetWrapper2.write(Types1_14.ENTITY_DATA_LIST, list);
        packetWrapper2.send(Protocol1_14_4To1_15.class);
    }

    @Override
    public int newEntityId(int n) {
        return n >= 4 ? n + 1 : n;
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_15.getTypeFromId(n);
    }
}


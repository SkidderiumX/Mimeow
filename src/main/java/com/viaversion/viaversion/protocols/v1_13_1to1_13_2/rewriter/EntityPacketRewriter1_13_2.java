/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_13_1to1_13_2.rewriter;

import com.viaversion.viaversion.api.minecraft.Particle;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityDataType;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_13;
import com.viaversion.viaversion.api.type.types.version.Types1_13_2;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ClientboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_13_1to1_13_2.Protocol1_13_1To1_13_2;

public class EntityPacketRewriter1_13_2 {
    public static void register(Protocol1_13_1To1_13_2 protocol1_13_1To1_13_2) {
        final PacketHandler packetHandler = packetWrapper -> {
            for (EntityData entityData : packetWrapper.get(Types1_13_2.ENTITY_DATA_LIST, 0)) {
                Particle particle;
                EntityDataType entityDataType = Types1_13_2.ENTITY_DATA_TYPES.byId(entityData.dataType().typeId());
                if (entityDataType == Types1_13_2.ENTITY_DATA_TYPES.particleType && (particle = (Particle)entityData.value()).id() == 27) {
                    Item item = (Item)particle.getArgument(0).getValue();
                    particle.set(0, Types.ITEM1_13_2, item);
                }
                entityData.setDataType(entityDataType);
            }
        };
        protocol1_13_1To1_13_2.registerClientbound(ClientboundPackets1_13.ADD_MOB, new PacketHandlers(){

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
                this.map(Types1_13.ENTITY_DATA_LIST, Types1_13_2.ENTITY_DATA_LIST);
                this.handler(packetHandler);
            }
        });
        protocol1_13_1To1_13_2.registerClientbound(ClientboundPackets1_13.ADD_PLAYER, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.UUID);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types1_13.ENTITY_DATA_LIST, Types1_13_2.ENTITY_DATA_LIST);
                this.handler(packetHandler);
            }
        });
        protocol1_13_1To1_13_2.registerClientbound(ClientboundPackets1_13.SET_ENTITY_DATA, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types1_13.ENTITY_DATA_LIST, Types1_13_2.ENTITY_DATA_LIST);
                this.handler(packetHandler);
            }
        });
    }
}


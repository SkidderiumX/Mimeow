/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_19_1to1_19_3.rewriter;

import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_19_3;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_19;
import com.viaversion.viaversion.api.type.types.version.Types1_19_3;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.protocols.v1_19_1to1_19_3.Protocol1_19_1To1_19_3;
import com.viaversion.viaversion.protocols.v1_19_1to1_19_3.packet.ClientboundPackets1_19_3;
import com.viaversion.viaversion.protocols.v1_19to1_19_1.packet.ClientboundPackets1_19_1;
import com.viaversion.viaversion.rewriter.EntityRewriter;
import java.util.BitSet;
import java.util.UUID;

public class EntityPacketRewriter1_19_3
extends EntityRewriter<ClientboundPackets1_19_1, Protocol1_19_1To1_19_3> {
    public EntityPacketRewriter1_19_3(Protocol1_19_1To1_19_3 protocol1_19_1To1_19_3) {
        super(protocol1_19_1To1_19_3);
    }

    @Override
    public void registerPackets() {
        this.registerTracker(ClientboundPackets1_19_1.ADD_EXPERIENCE_ORB, EntityTypes1_19_3.EXPERIENCE_ORB);
        this.registerTracker(ClientboundPackets1_19_1.ADD_PLAYER, EntityTypes1_19_3.PLAYER);
        this.registerSetEntityData(ClientboundPackets1_19_1.SET_ENTITY_DATA, Types1_19.ENTITY_DATA_LIST, Types1_19_3.ENTITY_DATA_LIST);
        ((Protocol1_19_1To1_19_3)this.protocol).registerClientbound(ClientboundPackets1_19_1.LOGIN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.BOOLEAN);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.STRING_ARRAY);
                this.map(Types.NAMED_COMPOUND_TAG);
                this.map(Types.STRING);
                this.map(Types.STRING);
                this.handler(EntityPacketRewriter1_19_3.this.dimensionDataHandler());
                this.handler(EntityPacketRewriter1_19_3.this.biomeSizeTracker());
                this.handler(EntityPacketRewriter1_19_3.this.worldDataTrackerHandlerByKey());
                this.handler(EntityPacketRewriter1_19_3.this.playerTrackerHandler());
                this.handler(packetWrapper -> {
                    PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundPackets1_19_3.UPDATE_ENABLED_FEATURES);
                    packetWrapper2.write(Types.STRING_ARRAY, new String[]{"minecraft:vanilla"});
                    if (packetWrapper.user().getProtocolInfo().protocolVersion().newerThanOrEqualTo(ProtocolVersion.v1_20_2)) {
                        packetWrapper2.send(Protocol1_19_1To1_19_3.class);
                    } else {
                        packetWrapper2.scheduleSend(Protocol1_19_1To1_19_3.class);
                    }
                });
            }
        });
        ((Protocol1_19_1To1_19_3)this.protocol).registerClientbound(ClientboundPackets1_19_1.RESPAWN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.map(Types.STRING);
                this.map(Types.LONG);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.BYTE);
                this.map(Types.BOOLEAN);
                this.map(Types.BOOLEAN);
                this.handler(EntityPacketRewriter1_19_3.this.worldDataTrackerHandlerByKey());
                this.handler(packetWrapper -> {
                    boolean bl = packetWrapper.read(Types.BOOLEAN);
                    byte by = 2;
                    if (bl) {
                        by = (byte)(by | 1);
                    }
                    packetWrapper.write(Types.BYTE, by);
                });
            }
        });
        ((Protocol1_19_1To1_19_3)this.protocol).registerClientbound(ClientboundPackets1_19_1.PLAYER_INFO, ClientboundPackets1_19_3.PLAYER_INFO_UPDATE, packetWrapper -> {
            int n = packetWrapper.read(Types.VAR_INT);
            if (n == 4) {
                int n2 = packetWrapper.read(Types.VAR_INT);
                UUID[] uUIDArray = new UUID[n2];
                for (int i = 0; i < n2; ++i) {
                    uUIDArray[i] = packetWrapper.read(Types.UUID);
                }
                packetWrapper.write(Types.UUID_ARRAY, uUIDArray);
                packetWrapper.setPacketType(ClientboundPackets1_19_3.PLAYER_INFO_REMOVE);
                return;
            }
            BitSet bitSet = new BitSet(6);
            if (n == 0) {
                bitSet.set(0, 6);
            } else {
                bitSet.set(n == 1 ? n + 1 : n + 2);
            }
            packetWrapper.write(Types.PROFILE_ACTIONS_ENUM1_19_3, bitSet);
            int n3 = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n3; ++i) {
                JsonElement jsonElement;
                packetWrapper.passthrough(Types.UUID);
                if (n == 0) {
                    packetWrapper.passthrough(Types.STRING);
                    packetWrapper.passthrough(Types.PROFILE_PROPERTY_ARRAY);
                    int n4 = packetWrapper.read(Types.VAR_INT);
                    int n5 = packetWrapper.read(Types.VAR_INT);
                    JsonElement jsonElement2 = packetWrapper.read(Types.OPTIONAL_COMPONENT);
                    if (jsonElement2 != null) {
                        ((Protocol1_19_1To1_19_3)this.protocol).getComponentRewriter().processText(packetWrapper.user(), jsonElement2);
                    }
                    packetWrapper.read(Types.OPTIONAL_PROFILE_KEY);
                    packetWrapper.write(Types.BOOLEAN, false);
                    packetWrapper.write(Types.VAR_INT, n4);
                    packetWrapper.write(Types.BOOLEAN, true);
                    packetWrapper.write(Types.VAR_INT, n5);
                    packetWrapper.write(Types.OPTIONAL_COMPONENT, jsonElement2);
                    continue;
                }
                if (n == 1 || n == 2) {
                    packetWrapper.passthrough(Types.VAR_INT);
                    continue;
                }
                if (n != 3 || (jsonElement = packetWrapper.passthrough(Types.OPTIONAL_COMPONENT)) == null) continue;
                ((Protocol1_19_1To1_19_3)this.protocol).getComponentRewriter().processText(packetWrapper.user(), jsonElement);
            }
        });
    }

    @Override
    protected void registerRewrites() {
        this.filter().mapDataType(n -> Types1_19_3.ENTITY_DATA_TYPES.byId(n >= 2 ? n + 1 : n));
        this.registerEntityDataTypeHandler(Types1_19_3.ENTITY_DATA_TYPES.itemType, Types1_19_3.ENTITY_DATA_TYPES.optionalBlockStateType, Types1_19_3.ENTITY_DATA_TYPES.particleType);
        this.registerBlockStateHandler(EntityTypes1_19_3.ABSTRACT_MINECART, 11);
        this.filter().type(EntityTypes1_19_3.ENTITY).index(6).handler((entityDataHandlerEvent, entityData) -> {
            int n = (Integer)entityData.value();
            if (n >= 10) {
                entityData.setValue(n + 1);
            }
        });
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_19_3.getTypeFromId(n);
    }
}


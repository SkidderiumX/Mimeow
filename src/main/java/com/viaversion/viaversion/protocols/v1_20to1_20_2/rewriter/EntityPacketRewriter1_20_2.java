/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_20to1_20_2.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_19_4;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_20;
import com.viaversion.viaversion.api.type.types.version.Types1_20_2;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.packet.ClientboundPackets1_19_4;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.Protocol1_20To1_20_2;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.packet.ClientboundPackets1_20_2;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.storage.ConfigurationState;
import com.viaversion.viaversion.rewriter.EntityRewriter;

public class EntityPacketRewriter1_20_2
extends EntityRewriter<ClientboundPackets1_19_4, Protocol1_20To1_20_2> {
    public EntityPacketRewriter1_20_2(Protocol1_20To1_20_2 protocol1_20To1_20_2) {
        super(protocol1_20To1_20_2);
    }

    @Override
    public void registerPackets() {
        this.registerSetEntityData(ClientboundPackets1_19_4.SET_ENTITY_DATA, Types1_20.ENTITY_DATA_LIST, Types1_20_2.ENTITY_DATA_LIST);
        ((Protocol1_20To1_20_2)this.protocol).registerClientbound(ClientboundPackets1_19_4.ADD_PLAYER, ClientboundPackets1_20_2.ADD_ENTITY, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.UUID);
            packetWrapper.write(Types.VAR_INT, EntityTypes1_19_4.PLAYER.getId());
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            byte by = packetWrapper.read(Types.BYTE);
            packetWrapper.passthrough(Types.BYTE);
            packetWrapper.write(Types.BYTE, by);
            packetWrapper.write(Types.BYTE, by);
            packetWrapper.write(Types.VAR_INT, 0);
            packetWrapper.write(Types.SHORT, (short)0);
            packetWrapper.write(Types.SHORT, (short)0);
            packetWrapper.write(Types.SHORT, (short)0);
        });
        ((Protocol1_20To1_20_2)this.protocol).registerClientbound(ClientboundPackets1_19_4.LOGIN, new PacketHandlers(){

            @Override
            public void register() {
                this.handler(packetWrapper -> {
                    packetWrapper.passthrough(Types.INT);
                    packetWrapper.passthrough(Types.BOOLEAN);
                    byte by = packetWrapper.read(Types.BYTE);
                    byte by2 = packetWrapper.read(Types.BYTE);
                    packetWrapper.passthrough(Types.STRING_ARRAY);
                    CompoundTag compoundTag = packetWrapper.read(Types.NAMED_COMPOUND_TAG);
                    String string = packetWrapper.read(Types.STRING);
                    String string2 = packetWrapper.read(Types.STRING);
                    long l = packetWrapper.read(Types.LONG);
                    EntityPacketRewriter1_20_2.this.trackBiomeSize(packetWrapper.user(), compoundTag);
                    EntityPacketRewriter1_20_2.this.cacheDimensionData(packetWrapper.user(), compoundTag);
                    packetWrapper.passthrough(Types.VAR_INT);
                    packetWrapper.passthrough(Types.VAR_INT);
                    packetWrapper.passthrough(Types.VAR_INT);
                    packetWrapper.passthrough(Types.BOOLEAN);
                    packetWrapper.passthrough(Types.BOOLEAN);
                    packetWrapper.write(Types.BOOLEAN, false);
                    packetWrapper.write(Types.STRING, string);
                    packetWrapper.write(Types.STRING, string2);
                    packetWrapper.write(Types.LONG, l);
                    packetWrapper.write(Types.BYTE, by);
                    packetWrapper.write(Types.BYTE, by2);
                    ConfigurationState configurationState = packetWrapper.user().get(ConfigurationState.class);
                    if (!configurationState.setLastDimensionRegistry(compoundTag)) {
                        PacketWrapper packetWrapper2 = configurationState.clientInformationPacket(packetWrapper.user());
                        if (packetWrapper2 != null) {
                            packetWrapper2.scheduleSendToServer(Protocol1_20To1_20_2.class);
                        }
                        return;
                    }
                    if (configurationState.bridgePhase() == ConfigurationState.BridgePhase.NONE) {
                        PacketWrapper packetWrapper3 = packetWrapper.create(ClientboundPackets1_20_2.START_CONFIGURATION);
                        packetWrapper3.send(Protocol1_20To1_20_2.class);
                        configurationState.setBridgePhase(ConfigurationState.BridgePhase.REENTERING_CONFIGURATION);
                        configurationState.setJoinGamePacket(packetWrapper);
                        packetWrapper.cancel();
                        return;
                    }
                    configurationState.setJoinGamePacket(packetWrapper);
                    packetWrapper.cancel();
                    Protocol1_20To1_20_2.sendConfigurationPackets(packetWrapper.user(), compoundTag, null);
                });
                this.handler(EntityPacketRewriter1_20_2.this.worldDataTrackerHandlerByKey());
            }
        });
        ((Protocol1_20To1_20_2)this.protocol).registerClientbound(ClientboundPackets1_19_4.RESPAWN, new PacketHandlers(){

            @Override
            public void register() {
                this.handler(packetWrapper -> {
                    packetWrapper.passthrough(Types.STRING);
                    packetWrapper.passthrough(Types.STRING);
                    packetWrapper.passthrough(Types.LONG);
                    packetWrapper.write(Types.BYTE, packetWrapper.read(Types.UNSIGNED_BYTE).byteValue());
                    packetWrapper.passthrough(Types.BYTE);
                    packetWrapper.passthrough(Types.BOOLEAN);
                    packetWrapper.passthrough(Types.BOOLEAN);
                    byte by = packetWrapper.read(Types.BYTE);
                    packetWrapper.passthrough(Types.OPTIONAL_GLOBAL_POSITION);
                    packetWrapper.passthrough(Types.VAR_INT);
                    packetWrapper.write(Types.BYTE, by);
                });
                this.handler(EntityPacketRewriter1_20_2.this.worldDataTrackerHandlerByKey());
            }
        });
        ((Protocol1_20To1_20_2)this.protocol).registerClientbound(ClientboundPackets1_19_4.UPDATE_MOB_EFFECT, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.write(Types.VAR_INT, packetWrapper.read(Types.VAR_INT) - 1);
            packetWrapper.passthrough(Types.BYTE);
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.BYTE);
            packetWrapper.write(Types.OPTIONAL_COMPOUND_TAG, packetWrapper.read(Types.OPTIONAL_NAMED_COMPOUND_TAG));
        });
        ((Protocol1_20To1_20_2)this.protocol).registerClientbound(ClientboundPackets1_19_4.REMOVE_MOB_EFFECT, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.write(Types.VAR_INT, packetWrapper.read(Types.VAR_INT) - 1);
        });
    }

    @Override
    protected void registerRewrites() {
        this.filter().mapDataType(Types1_20_2.ENTITY_DATA_TYPES::byId);
        this.registerEntityDataTypeHandler(Types1_20_2.ENTITY_DATA_TYPES.itemType, Types1_20_2.ENTITY_DATA_TYPES.blockStateType, Types1_20_2.ENTITY_DATA_TYPES.optionalBlockStateType, Types1_20_2.ENTITY_DATA_TYPES.particleType, null);
        this.registerBlockStateHandler(EntityTypes1_19_4.ABSTRACT_MINECART, 11);
        this.filter().type(EntityTypes1_19_4.DISPLAY).addIndex(10);
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_19_4.getTypeFromId(n);
    }
}


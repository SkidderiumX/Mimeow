/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_20_2to1_20.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viabackwards.api.rewriters.EntityRewriter;
import com.viaversion.viabackwards.protocol.v1_20_2to1_20.Protocol1_20_2To1_20;
import com.viaversion.viabackwards.protocol.v1_20_2to1_20.storage.ConfigurationPacketStorage;
import com.viaversion.viaversion.api.minecraft.GlobalBlockPosition;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_19_4;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_20;
import com.viaversion.viaversion.api.type.types.version.Types1_20_2;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.packet.ClientboundPackets1_19_4;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.packet.ClientboundPackets1_20_2;

public class EntityPacketRewriter1_20_2
extends EntityRewriter<ClientboundPackets1_20_2, Protocol1_20_2To1_20> {
    public EntityPacketRewriter1_20_2(Protocol1_20_2To1_20 protocol1_20_2To1_20) {
        super(protocol1_20_2To1_20, Types1_20.ENTITY_DATA_TYPES.optionalComponentType, Types1_20.ENTITY_DATA_TYPES.booleanType);
    }

    @Override
    public void registerPackets() {
        this.registerSetEntityData(ClientboundPackets1_20_2.SET_ENTITY_DATA, Types1_20_2.ENTITY_DATA_LIST, Types1_20.ENTITY_DATA_LIST);
        ((Protocol1_20_2To1_20)this.protocol).replaceClientbound(ClientboundPackets1_20_2.ADD_ENTITY, new PacketHandlers(){

            @Override
            protected void register() {
                this.handler(packetWrapper -> {
                    int n = packetWrapper.passthrough(Types.VAR_INT);
                    packetWrapper.passthrough(Types.UUID);
                    int n2 = packetWrapper.read(Types.VAR_INT);
                    EntityPacketRewriter1_20_2.this.tracker(packetWrapper.user()).addEntity(n, EntityPacketRewriter1_20_2.this.typeFromId(n2));
                    if (n2 != EntityTypes1_19_4.PLAYER.getId()) {
                        packetWrapper.write(Types.VAR_INT, n2);
                        if (n2 == EntityTypes1_19_4.FALLING_BLOCK.getId()) {
                            packetWrapper.passthrough(Types.DOUBLE);
                            packetWrapper.passthrough(Types.DOUBLE);
                            packetWrapper.passthrough(Types.DOUBLE);
                            packetWrapper.passthrough(Types.BYTE);
                            packetWrapper.passthrough(Types.BYTE);
                            packetWrapper.passthrough(Types.BYTE);
                            int n3 = packetWrapper.read(Types.VAR_INT);
                            packetWrapper.write(Types.VAR_INT, ((Protocol1_20_2To1_20)EntityPacketRewriter1_20_2.this.protocol).getMappingData().getNewBlockStateId(n3));
                        }
                        return;
                    }
                    packetWrapper.setPacketType(ClientboundPackets1_19_4.ADD_PLAYER);
                    packetWrapper.passthrough(Types.DOUBLE);
                    packetWrapper.passthrough(Types.DOUBLE);
                    packetWrapper.passthrough(Types.DOUBLE);
                    byte by = packetWrapper.read(Types.BYTE);
                    packetWrapper.passthrough(Types.BYTE);
                    packetWrapper.write(Types.BYTE, by);
                    packetWrapper.read(Types.BYTE);
                    packetWrapper.read(Types.VAR_INT);
                    short s = packetWrapper.read(Types.SHORT);
                    short s2 = packetWrapper.read(Types.SHORT);
                    short s3 = packetWrapper.read(Types.SHORT);
                    if (s == 0 && s2 == 0 && s3 == 0) {
                        return;
                    }
                    packetWrapper.send(Protocol1_20_2To1_20.class);
                    packetWrapper.cancel();
                    PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundPackets1_19_4.SET_ENTITY_MOTION);
                    packetWrapper2.write(Types.VAR_INT, n);
                    packetWrapper2.write(Types.SHORT, s);
                    packetWrapper2.write(Types.SHORT, s2);
                    packetWrapper2.write(Types.SHORT, s3);
                    packetWrapper2.send(Protocol1_20_2To1_20.class);
                });
            }
        });
        ((Protocol1_20_2To1_20)this.protocol).registerClientbound(ClientboundPackets1_20_2.LOGIN, new PacketHandlers(){

            @Override
            public void register() {
                this.handler(packetWrapper -> {
                    ConfigurationPacketStorage configurationPacketStorage = packetWrapper.user().get(ConfigurationPacketStorage.class);
                    packetWrapper.passthrough(Types.INT);
                    packetWrapper.passthrough(Types.BOOLEAN);
                    String[] stringArray = packetWrapper.read(Types.STRING_ARRAY);
                    int n = packetWrapper.read(Types.VAR_INT);
                    int n2 = packetWrapper.read(Types.VAR_INT);
                    int n3 = packetWrapper.read(Types.VAR_INT);
                    boolean bl = packetWrapper.read(Types.BOOLEAN);
                    boolean bl2 = packetWrapper.read(Types.BOOLEAN);
                    packetWrapper.read(Types.BOOLEAN);
                    String string = packetWrapper.read(Types.STRING);
                    String string2 = packetWrapper.read(Types.STRING);
                    long l = packetWrapper.read(Types.LONG);
                    packetWrapper.passthrough(Types.BYTE);
                    packetWrapper.passthrough(Types.BYTE);
                    packetWrapper.write(Types.STRING_ARRAY, stringArray);
                    packetWrapper.write(Types.NAMED_COMPOUND_TAG, configurationPacketStorage.registry());
                    packetWrapper.write(Types.STRING, string);
                    packetWrapper.write(Types.STRING, string2);
                    packetWrapper.write(Types.LONG, l);
                    packetWrapper.write(Types.VAR_INT, n);
                    packetWrapper.write(Types.VAR_INT, n2);
                    packetWrapper.write(Types.VAR_INT, n3);
                    packetWrapper.write(Types.BOOLEAN, bl);
                    packetWrapper.write(Types.BOOLEAN, bl2);
                    EntityPacketRewriter1_20_2.this.worldDataTrackerHandlerByKey().handle(packetWrapper);
                    packetWrapper.send(Protocol1_20_2To1_20.class);
                    packetWrapper.cancel();
                    if (configurationPacketStorage.enabledFeatures() != null) {
                        PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundPackets1_19_4.UPDATE_ENABLED_FEATURES);
                        packetWrapper2.write(Types.STRING_ARRAY, configurationPacketStorage.enabledFeatures());
                        packetWrapper2.send(Protocol1_20_2To1_20.class);
                    }
                    configurationPacketStorage.sendQueuedPackets(packetWrapper.user());
                });
            }
        });
        ((Protocol1_20_2To1_20)this.protocol).registerClientbound(ClientboundPackets1_20_2.RESPAWN, new PacketHandlers(){

            @Override
            public void register() {
                this.handler(packetWrapper -> {
                    packetWrapper.passthrough(Types.STRING);
                    packetWrapper.passthrough(Types.STRING);
                    packetWrapper.passthrough(Types.LONG);
                    packetWrapper.write(Types.UNSIGNED_BYTE, packetWrapper.read(Types.BYTE).shortValue());
                    packetWrapper.passthrough(Types.BYTE);
                    packetWrapper.passthrough(Types.BOOLEAN);
                    packetWrapper.passthrough(Types.BOOLEAN);
                    GlobalBlockPosition globalBlockPosition = packetWrapper.read(Types.OPTIONAL_GLOBAL_POSITION);
                    int n = packetWrapper.read(Types.VAR_INT);
                    packetWrapper.passthrough(Types.BYTE);
                    packetWrapper.write(Types.OPTIONAL_GLOBAL_POSITION, globalBlockPosition);
                    packetWrapper.write(Types.VAR_INT, n);
                });
                this.handler(EntityPacketRewriter1_20_2.this.worldDataTrackerHandlerByKey());
            }
        });
        ((Protocol1_20_2To1_20)this.protocol).registerClientbound(ClientboundPackets1_20_2.UPDATE_MOB_EFFECT, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.write(Types.VAR_INT, packetWrapper.read(Types.VAR_INT) + 1);
            packetWrapper.passthrough(Types.BYTE);
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.BYTE);
            CompoundTag compoundTag = packetWrapper.read(Types.OPTIONAL_COMPOUND_TAG);
            packetWrapper.write(Types.OPTIONAL_NAMED_COMPOUND_TAG, compoundTag);
        });
        ((Protocol1_20_2To1_20)this.protocol).registerClientbound(ClientboundPackets1_20_2.REMOVE_MOB_EFFECT, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.write(Types.VAR_INT, packetWrapper.read(Types.VAR_INT) + 1);
        });
    }

    @Override
    protected void registerRewrites() {
        this.filter().mapDataType(Types1_20.ENTITY_DATA_TYPES::byId);
        this.registerEntityDataTypeHandler(Types1_20.ENTITY_DATA_TYPES.itemType, Types1_20.ENTITY_DATA_TYPES.blockStateType, Types1_20.ENTITY_DATA_TYPES.optionalBlockStateType, Types1_20.ENTITY_DATA_TYPES.particleType, null, null);
        this.registerBlockStateHandler(EntityTypes1_19_4.ABSTRACT_MINECART, 11);
        this.filter().type(EntityTypes1_19_4.DISPLAY).removeIndex(10);
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_19_4.getTypeFromId(n);
    }
}


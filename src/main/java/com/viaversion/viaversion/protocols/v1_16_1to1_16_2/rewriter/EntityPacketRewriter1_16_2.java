/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_16_1to1_16_2.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_16_2;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_16;
import com.viaversion.viaversion.protocols.v1_15_2to1_16.packet.ClientboundPackets1_16;
import com.viaversion.viaversion.protocols.v1_16_1to1_16_2.Protocol1_16_1To1_16_2;
import com.viaversion.viaversion.rewriter.EntityRewriter;

public class EntityPacketRewriter1_16_2
extends EntityRewriter<ClientboundPackets1_16, Protocol1_16_1To1_16_2> {
    public EntityPacketRewriter1_16_2(Protocol1_16_1To1_16_2 protocol1_16_1To1_16_2) {
        super(protocol1_16_1To1_16_2);
    }

    @Override
    protected void registerPackets() {
        this.registerTracker(ClientboundPackets1_16.ADD_PLAYER, EntityTypes1_16_2.PLAYER);
        this.registerSetEntityData(ClientboundPackets1_16.SET_ENTITY_DATA, Types1_16.ENTITY_DATA_LIST);
        ((Protocol1_16_1To1_16_2)this.protocol).registerClientbound(ClientboundPackets1_16.LOGIN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    short s = packetWrapper.read(Types.UNSIGNED_BYTE);
                    packetWrapper.write(Types.BOOLEAN, (s & 8) != 0);
                    packetWrapper.write(Types.BYTE, (byte)(s & 0xFFFFFFF7));
                });
                this.map(Types.BYTE);
                this.map(Types.STRING_ARRAY);
                this.handler(packetWrapper -> {
                    packetWrapper.read(Types.NAMED_COMPOUND_TAG);
                    packetWrapper.write(Types.NAMED_COMPOUND_TAG, ((Protocol1_16_1To1_16_2)EntityPacketRewriter1_16_2.this.protocol).getMappingData().getDimensionRegistry());
                    String string = packetWrapper.read(Types.STRING);
                    packetWrapper.write(Types.NAMED_COMPOUND_TAG, EntityPacketRewriter1_16_2.this.getDimensionData(string));
                });
                this.map(Types.STRING);
                this.handler(packetWrapper -> {
                    String string = packetWrapper.get(Types.STRING, 0);
                    EntityPacketRewriter1_16_2.this.tracker(packetWrapper.user()).setCurrentWorld(string);
                });
                this.map(Types.LONG);
                this.map(Types.UNSIGNED_BYTE, Types.VAR_INT);
                this.handler(EntityPacketRewriter1_16_2.this.playerTrackerHandler());
            }
        });
        ((Protocol1_16_1To1_16_2)this.protocol).registerClientbound(ClientboundPackets1_16.RESPAWN, packetWrapper -> {
            String string = packetWrapper.read(Types.STRING);
            packetWrapper.write(Types.NAMED_COMPOUND_TAG, this.getDimensionData(string));
            String string2 = packetWrapper.passthrough(Types.STRING);
            this.trackWorld(packetWrapper.user(), string2);
        });
    }

    @Override
    protected void registerRewrites() {
        this.registerEntityDataTypeHandler(Types1_16.ENTITY_DATA_TYPES.itemType, Types1_16.ENTITY_DATA_TYPES.optionalBlockStateType, Types1_16.ENTITY_DATA_TYPES.particleType);
        this.registerBlockStateHandler(EntityTypes1_16_2.ABSTRACT_MINECART, 10);
        this.filter().type(EntityTypes1_16_2.ABSTRACT_PIGLIN).handler((entityDataHandlerEvent, entityData) -> {
            if (entityData.id() == 15) {
                entityData.setId(16);
            } else if (entityData.id() == 16) {
                entityData.setId(15);
            }
        });
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_16_2.getTypeFromId(n);
    }

    private CompoundTag getDimensionData(String string) {
        CompoundTag compoundTag = Protocol1_16_1To1_16_2.MAPPINGS.getDimensionDataMap().get(string);
        if (compoundTag == null) {
            ((Protocol1_16_1To1_16_2)this.protocol).getLogger().severe("Could not get dimension data of " + string);
            throw new NullPointerException("Dimension data for " + string + " is null!");
        }
        return compoundTag.copy();
    }
}


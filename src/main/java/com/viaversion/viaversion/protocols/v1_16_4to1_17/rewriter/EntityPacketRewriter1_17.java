/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_16_4to1_17.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_17;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_16;
import com.viaversion.viaversion.api.type.types.version.Types1_17;
import com.viaversion.viaversion.protocols.v1_16_1to1_16_2.packet.ClientboundPackets1_16_2;
import com.viaversion.viaversion.protocols.v1_16_4to1_17.Protocol1_16_4To1_17;
import com.viaversion.viaversion.protocols.v1_16_4to1_17.packet.ClientboundPackets1_17;
import com.viaversion.viaversion.rewriter.EntityRewriter;
import com.viaversion.viaversion.util.TagUtil;

public class EntityPacketRewriter1_17
extends EntityRewriter<ClientboundPackets1_16_2, Protocol1_16_4To1_17> {
    public EntityPacketRewriter1_17(Protocol1_16_4To1_17 protocol1_16_4To1_17) {
        super(protocol1_16_4To1_17);
    }

    @Override
    public void registerPackets() {
        this.registerTracker(ClientboundPackets1_16_2.ADD_PLAYER, EntityTypes1_17.PLAYER);
        this.registerSetEntityData(ClientboundPackets1_16_2.SET_ENTITY_DATA, Types1_16.ENTITY_DATA_LIST, Types1_17.ENTITY_DATA_LIST);
        ((Protocol1_16_4To1_17)this.protocol).appendClientbound(ClientboundPackets1_16_2.ADD_ENTITY, packetWrapper -> {
            int n = packetWrapper.get(Types.VAR_INT, 1);
            if (n != EntityTypes1_17.ITEM_FRAME.getId()) {
                return;
            }
            int n2 = packetWrapper.get(Types.VAR_INT, 0);
            byte by = packetWrapper.get(Types.BYTE, 0);
            byte by2 = packetWrapper.get(Types.BYTE, 1);
            PacketWrapper packetWrapper2 = PacketWrapper.create(ClientboundPackets1_17.MOVE_ENTITY_ROT, packetWrapper.user());
            packetWrapper2.write(Types.VAR_INT, n2);
            packetWrapper2.write(Types.BYTE, by2);
            packetWrapper2.write(Types.BYTE, by);
            packetWrapper2.write(Types.BOOLEAN, false);
            packetWrapper.send(Protocol1_16_4To1_17.class);
            packetWrapper.cancel();
            packetWrapper2.send(Protocol1_16_4To1_17.class);
        });
        ((Protocol1_16_4To1_17)this.protocol).registerClientbound(ClientboundPackets1_16_2.REMOVE_ENTITIES, null, packetWrapper -> {
            int[] nArray = packetWrapper.read(Types.VAR_INT_ARRAY_PRIMITIVE);
            packetWrapper.cancel();
            Object t = packetWrapper.user().getEntityTracker(Protocol1_16_4To1_17.class);
            for (int n : nArray) {
                t.removeEntity(n);
                PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundPackets1_17.REMOVE_ENTITY);
                packetWrapper2.write(Types.VAR_INT, n);
                packetWrapper2.send(Protocol1_16_4To1_17.class);
            }
        });
        ((Protocol1_16_4To1_17)this.protocol).registerClientbound(ClientboundPackets1_16_2.LOGIN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.BOOLEAN);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.STRING_ARRAY);
                this.map(Types.NAMED_COMPOUND_TAG);
                this.map(Types.NAMED_COMPOUND_TAG);
                this.handler(packetWrapper -> {
                    CompoundTag compoundTag = packetWrapper.get(Types.NAMED_COMPOUND_TAG, 0);
                    ListTag<CompoundTag> listTag = TagUtil.getRegistryEntries(compoundTag, "dimension_type");
                    for (CompoundTag compoundTag2 : listTag) {
                        CompoundTag compoundTag3 = compoundTag2.getCompoundTag("element");
                        EntityPacketRewriter1_17.addNewDimensionData(compoundTag3);
                    }
                    CompoundTag compoundTag4 = packetWrapper.get(Types.NAMED_COMPOUND_TAG, 1);
                    EntityPacketRewriter1_17.addNewDimensionData(compoundTag4);
                });
                this.handler(packetWrapper -> {
                    String string = packetWrapper.passthrough(Types.STRING);
                    EntityPacketRewriter1_17.this.tracker(packetWrapper.user()).setCurrentWorld(string);
                });
                this.handler(EntityPacketRewriter1_17.this.playerTrackerHandler());
            }
        });
        ((Protocol1_16_4To1_17)this.protocol).registerClientbound(ClientboundPackets1_16_2.RESPAWN, packetWrapper -> {
            CompoundTag compoundTag = packetWrapper.passthrough(Types.NAMED_COMPOUND_TAG);
            EntityPacketRewriter1_17.addNewDimensionData(compoundTag);
            String string = packetWrapper.passthrough(Types.STRING);
            this.trackWorld(packetWrapper.user(), string);
        });
        ((Protocol1_16_4To1_17)this.protocol).registerClientbound(ClientboundPackets1_16_2.UPDATE_ATTRIBUTES, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> packetWrapper.write(Types.VAR_INT, packetWrapper.read(Types.INT)));
            }
        });
        ((Protocol1_16_4To1_17)this.protocol).registerClientbound(ClientboundPackets1_16_2.PLAYER_POSITION, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.BYTE);
                this.map(Types.VAR_INT);
                this.create(Types.BOOLEAN, false);
            }
        });
        ((Protocol1_16_4To1_17)this.protocol).registerClientbound(ClientboundPackets1_16_2.PLAYER_COMBAT, null, packetWrapper -> {
            int n = packetWrapper.read(Types.VAR_INT);
            ClientboundPackets1_17 clientboundPackets1_17 = switch (n) {
                case 0 -> ClientboundPackets1_17.PLAYER_COMBAT_ENTER;
                case 1 -> ClientboundPackets1_17.PLAYER_COMBAT_END;
                case 2 -> ClientboundPackets1_17.PLAYER_COMBAT_KILL;
                default -> throw new IllegalArgumentException("Invalid combat type received: " + n);
            };
            if (n == 2) {
                packetWrapper.passthrough(Types.VAR_INT);
                packetWrapper.passthrough(Types.INT);
                ((Protocol1_16_4To1_17)this.protocol).getComponentRewriter().processText(packetWrapper.user(), packetWrapper.passthrough(Types.COMPONENT));
            }
            packetWrapper.setPacketType(clientboundPackets1_17);
        });
        ((Protocol1_16_4To1_17)this.protocol).cancelClientbound(ClientboundPackets1_16_2.MOVE_ENTITY);
    }

    @Override
    protected void registerRewrites() {
        this.filter().mapDataType(Types1_17.ENTITY_DATA_TYPES::byId);
        this.filter().dataType(Types1_17.ENTITY_DATA_TYPES.poseType).handler((entityDataHandlerEvent, entityData) -> {
            int n = (Integer)entityData.value();
            if (n > 5) {
                entityData.setValue(n + 1);
            }
        });
        this.registerEntityDataTypeHandler(Types1_17.ENTITY_DATA_TYPES.itemType, Types1_17.ENTITY_DATA_TYPES.optionalBlockStateType, Types1_17.ENTITY_DATA_TYPES.particleType);
        this.filter().type(EntityTypes1_17.ENTITY).addIndex(7);
        this.registerBlockStateHandler(EntityTypes1_17.ABSTRACT_MINECART, 11);
        this.filter().type(EntityTypes1_17.SHULKER).removeIndex(17);
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_17.getTypeFromId(n);
    }

    private static void addNewDimensionData(CompoundTag compoundTag) {
        compoundTag.put("min_y", new IntTag(0));
        compoundTag.put("height", new IntTag(256));
    }
}


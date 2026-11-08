/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_19_3to1_19_4.rewriter;

import com.viaversion.nbt.tag.ByteTag;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_19_4;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_19_3;
import com.viaversion.viaversion.api.type.types.version.Types1_19_4;
import com.viaversion.viaversion.protocols.v1_19_1to1_19_3.packet.ClientboundPackets1_19_3;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.Protocol1_19_3To1_19_4;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.packet.ClientboundPackets1_19_4;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.storage.PlayerVehicleTracker;
import com.viaversion.viaversion.rewriter.EntityRewriter;
import com.viaversion.viaversion.util.TagUtil;

public class EntityPacketRewriter1_19_4
extends EntityRewriter<ClientboundPackets1_19_3, Protocol1_19_3To1_19_4> {
    public EntityPacketRewriter1_19_4(Protocol1_19_3To1_19_4 protocol1_19_3To1_19_4) {
        super(protocol1_19_3To1_19_4);
    }

    @Override
    public void registerPackets() {
        ((Protocol1_19_3To1_19_4)this.protocol).registerClientbound(ClientboundPackets1_19_3.LOGIN, new PacketHandlers(){

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
                this.handler(EntityPacketRewriter1_19_4.this.dimensionDataHandler());
                this.handler(EntityPacketRewriter1_19_4.this.biomeSizeTracker());
                this.handler(EntityPacketRewriter1_19_4.this.worldDataTrackerHandlerByKey());
                this.handler(EntityPacketRewriter1_19_4.this.playerTrackerHandler());
                this.handler(packetWrapper -> {
                    CompoundTag compoundTag = packetWrapper.get(Types.NAMED_COMPOUND_TAG, 0);
                    CompoundTag compoundTag2 = ((Protocol1_19_3To1_19_4)EntityPacketRewriter1_19_4.this.protocol).getMappingData().damageTypesRegistry();
                    compoundTag.put("minecraft:damage_type", compoundTag2);
                    CompoundTag compoundTag3 = new CompoundTag();
                    compoundTag3.putString("type", "minecraft:trim_material");
                    compoundTag3.put("value", new ListTag<CompoundTag>(CompoundTag.class));
                    compoundTag.put("minecraft:trim_material", compoundTag3);
                    ListTag<CompoundTag> listTag = TagUtil.getRegistryEntries(compoundTag, "worldgen/biome");
                    for (CompoundTag compoundTag4 : listTag) {
                        CompoundTag compoundTag5 = compoundTag4.getCompoundTag("element");
                        StringTag stringTag = compoundTag5.getStringTag("precipitation");
                        byte by = stringTag.getValue().equals("none") ? (byte)0 : (byte)1;
                        compoundTag5.put("has_precipitation", new ByteTag(by));
                    }
                });
            }
        });
        ((Protocol1_19_3To1_19_4)this.protocol).registerClientbound(ClientboundPackets1_19_3.PLAYER_POSITION, new PacketHandlers(){

            @Override
            protected void register() {
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.BYTE);
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    PlayerVehicleTracker playerVehicleTracker;
                    if (packetWrapper.read(Types.BOOLEAN).booleanValue() && (playerVehicleTracker = packetWrapper.user().get(PlayerVehicleTracker.class)).getVehicleId() != -1) {
                        PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundPackets1_19_4.BUNDLE_DELIMITER);
                        packetWrapper2.send(Protocol1_19_3To1_19_4.class);
                        PacketWrapper packetWrapper3 = packetWrapper.create(ClientboundPackets1_19_4.SET_PASSENGERS);
                        packetWrapper3.write(Types.VAR_INT, playerVehicleTracker.getVehicleId());
                        packetWrapper3.write(Types.VAR_INT_ARRAY_PRIMITIVE, new int[0]);
                        packetWrapper3.send(Protocol1_19_3To1_19_4.class);
                        packetWrapper.send(Protocol1_19_3To1_19_4.class);
                        packetWrapper.cancel();
                        PacketWrapper packetWrapper4 = packetWrapper.create(ClientboundPackets1_19_4.BUNDLE_DELIMITER);
                        packetWrapper4.send(Protocol1_19_3To1_19_4.class);
                        playerVehicleTracker.setVehicleId(-1);
                    }
                });
            }
        });
        ((Protocol1_19_3To1_19_4)this.protocol).registerClientbound(ClientboundPackets1_19_3.SET_PASSENGERS, new PacketHandlers(){

            @Override
            protected void register() {
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT_ARRAY_PRIMITIVE);
                this.handler(packetWrapper -> {
                    int[] nArray;
                    PlayerVehicleTracker playerVehicleTracker = packetWrapper.user().get(PlayerVehicleTracker.class);
                    int n = packetWrapper.user().getEntityTracker(Protocol1_19_3To1_19_4.class).clientEntityId();
                    int n2 = packetWrapper.get(Types.VAR_INT, 0);
                    if (playerVehicleTracker.getVehicleId() == n2) {
                        playerVehicleTracker.setVehicleId(-1);
                    }
                    for (int n3 : nArray = packetWrapper.get(Types.VAR_INT_ARRAY_PRIMITIVE, 0)) {
                        if (n3 != n) continue;
                        playerVehicleTracker.setVehicleId(n2);
                        break;
                    }
                });
            }
        });
        ((Protocol1_19_3To1_19_4)this.protocol).registerClientbound(ClientboundPackets1_19_3.TELEPORT_ENTITY, new PacketHandlers(){

            @Override
            protected void register() {
                this.handler(packetWrapper -> {
                    int n;
                    int n2 = packetWrapper.read(Types.VAR_INT);
                    if (n2 != (n = packetWrapper.user().getEntityTracker(Protocol1_19_3To1_19_4.class).clientEntityId())) {
                        packetWrapper.write(Types.VAR_INT, n2);
                        return;
                    }
                    packetWrapper.setPacketType(ClientboundPackets1_19_4.PLAYER_POSITION);
                    packetWrapper.passthrough(Types.DOUBLE);
                    packetWrapper.passthrough(Types.DOUBLE);
                    packetWrapper.passthrough(Types.DOUBLE);
                    packetWrapper.write(Types.FLOAT, Float.valueOf((float)packetWrapper.read(Types.BYTE).byteValue() * 360.0f / 256.0f));
                    packetWrapper.write(Types.FLOAT, Float.valueOf((float)packetWrapper.read(Types.BYTE).byteValue() * 360.0f / 256.0f));
                    packetWrapper.read(Types.BOOLEAN);
                    packetWrapper.write(Types.BYTE, (byte)0);
                    packetWrapper.write(Types.VAR_INT, -1);
                });
            }
        });
        ((Protocol1_19_3To1_19_4)this.protocol).registerClientbound(ClientboundPackets1_19_3.ANIMATE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    short s = packetWrapper.read(Types.UNSIGNED_BYTE);
                    if (s != 1) {
                        packetWrapper.write(Types.UNSIGNED_BYTE, s);
                        return;
                    }
                    packetWrapper.setPacketType(ClientboundPackets1_19_4.HURT_ANIMATION);
                    packetWrapper.write(Types.FLOAT, Float.valueOf(0.0f));
                });
            }
        });
        ((Protocol1_19_3To1_19_4)this.protocol).registerClientbound(ClientboundPackets1_19_3.RESPAWN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.map(Types.STRING);
                this.handler(EntityPacketRewriter1_19_4.this.worldDataTrackerHandlerByKey());
                this.handler(packetWrapper -> packetWrapper.user().put(new PlayerVehicleTracker()));
            }
        });
        ((Protocol1_19_3To1_19_4)this.protocol).registerClientbound(ClientboundPackets1_19_3.ENTITY_EVENT, packetWrapper -> {
            int n = packetWrapper.read(Types.INT);
            byte by = packetWrapper.read(Types.BYTE);
            int n2 = this.damageTypeFromEntityEvent(by);
            if (n2 != -1) {
                packetWrapper.setPacketType(ClientboundPackets1_19_4.DAMAGE_EVENT);
                packetWrapper.write(Types.VAR_INT, n);
                packetWrapper.write(Types.VAR_INT, n2);
                packetWrapper.write(Types.OPTIONAL_VAR_INT, null);
                packetWrapper.write(Types.OPTIONAL_VAR_INT, null);
                packetWrapper.write(Types.BOOLEAN, false);
                return;
            }
            packetWrapper.write(Types.INT, n);
            packetWrapper.write(Types.BYTE, by);
        });
        this.registerSetEntityData(ClientboundPackets1_19_3.SET_ENTITY_DATA, Types1_19_3.ENTITY_DATA_LIST, Types1_19_4.ENTITY_DATA_LIST);
    }

    private int damageTypeFromEntityEvent(byte by) {
        return switch (by) {
            case 33 -> 36;
            case 36 -> 5;
            case 37 -> 27;
            case 57 -> 15;
            case 2, 44 -> 16;
            default -> -1;
        };
    }

    @Override
    protected void registerRewrites() {
        this.filter().mapDataType(n -> Types1_19_4.ENTITY_DATA_TYPES.byId(n >= 14 ? n + 1 : n));
        this.registerEntityDataTypeHandler(Types1_19_4.ENTITY_DATA_TYPES.itemType, Types1_19_4.ENTITY_DATA_TYPES.blockStateType, Types1_19_4.ENTITY_DATA_TYPES.optionalBlockStateType, Types1_19_4.ENTITY_DATA_TYPES.particleType, null);
        this.registerBlockStateHandler(EntityTypes1_19_4.ABSTRACT_MINECART, 11);
        this.filter().type(EntityTypes1_19_4.BOAT).index(11).handler((entityDataHandlerEvent, entityData) -> {
            int n = (Integer)entityData.value();
            if (n > 4) {
                entityData.setValue(n + 1);
            }
        });
        this.filter().type(EntityTypes1_19_4.ABSTRACT_HORSE).removeIndex(18);
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_19_4.getTypeFromId(n);
    }
}


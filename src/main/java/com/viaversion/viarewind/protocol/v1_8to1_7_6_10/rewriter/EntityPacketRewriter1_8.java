/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.protocol.v1_8to1_7_6_10.rewriter;

import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;
import com.viaversion.viarewind.ViaRewind;
import com.viaversion.viarewind.api.minecraft.entitydata.EntityDataTypes1_7_6_10;
import com.viaversion.viarewind.api.rewriter.VREntityRewriter;
import com.viaversion.viarewind.api.type.RewindTypes;
import com.viaversion.viarewind.protocol.v1_7_6_10to1_7_2_5.packet.ClientboundPackets1_7_2_5;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.Protocol1_8To1_7_6_10;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.data.EntityDataIndex1_7_6_10;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.data.VirtualHologramEntity;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.storage.EntityTracker1_8;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.storage.GameProfileStorage;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.storage.PlayerSessionStorage;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.storage.ScoreboardTracker;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_8;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_8;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ClientboundPackets1_8;
import com.viaversion.viaversion.rewriter.entitydata.EntityDataHandlerEvent;
import com.viaversion.viaversion.util.IdAndData;
import java.util.List;
import java.util.UUID;

public class EntityPacketRewriter1_8
extends VREntityRewriter<ClientboundPackets1_8, Protocol1_8To1_7_6_10> {
    public EntityPacketRewriter1_8(Protocol1_8To1_7_6_10 protocol1_8To1_7_6_10) {
        super(protocol1_8To1_7_6_10, EntityDataTypes1_7_6_10.STRING, EntityDataTypes1_7_6_10.BYTE);
    }

    @Override
    protected void registerPackets() {
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.LOGIN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.BYTE);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.STRING);
                this.read(Types.BOOLEAN);
                this.handler(EntityPacketRewriter1_8.this.playerTrackerHandler());
                this.handler(EntityPacketRewriter1_8.this.getDimensionHandler());
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.INT, 0);
                    if (ViaRewind.getConfig().isReplaceAdventureMode() && packetWrapper.get(Types.UNSIGNED_BYTE, 0) == 2) {
                        packetWrapper.set(Types.UNSIGNED_BYTE, 0, (short)0);
                    }
                    EntityTracker1_8 entityTracker1_8 = (EntityTracker1_8)packetWrapper.user().getEntityTracker(Protocol1_8To1_7_6_10.class);
                    entityTracker1_8.addPlayer(n, packetWrapper.user().getProtocolInfo().getUuid());
                    entityTracker1_8.setClientEntityGameMode(packetWrapper.get(Types.UNSIGNED_BYTE, 0).shortValue());
                    packetWrapper.user().put(new ScoreboardTracker(packetWrapper.user()));
                });
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.REMOVE_ENTITIES, packetWrapper -> {
            int[] nArray = packetWrapper.read(Types.VAR_INT_ARRAY_PRIMITIVE);
            this.removeEntities(packetWrapper.user(), nArray);
            packetWrapper.cancel();
            List<List<Integer>> list = Lists.partition(Ints.asList(nArray), 127);
            for (List<Integer> list2 : list) {
                PacketWrapper packetWrapper2 = PacketWrapper.create(ClientboundPackets1_7_2_5.REMOVE_ENTITIES, packetWrapper.user());
                packetWrapper2.write(RewindTypes.INT_ARRAY, list2.stream().mapToInt(Integer::intValue).toArray());
                packetWrapper2.send(Protocol1_8To1_7_6_10.class);
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.SET_ENTITY_DATA, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT, Types.INT);
                this.map(Types.ENTITY_DATA_LIST1_8, RewindTypes.ENTITY_DATA_LIST1_7);
                this.handler(packetWrapper -> {
                    EntityTracker1_8 entityTracker1_8 = (EntityTracker1_8)EntityPacketRewriter1_8.this.tracker(packetWrapper.user());
                    int n = packetWrapper.get(Types.INT, 0);
                    List<EntityData> list = packetWrapper.get(RewindTypes.ENTITY_DATA_LIST1_7, 0);
                    if (entityTracker1_8.getHolograms().containsKey(n)) {
                        packetWrapper.cancel();
                        ((VirtualHologramEntity)entityTracker1_8.getHolograms().get(n)).syncState(EntityPacketRewriter1_8.this, list);
                    } else if (entityTracker1_8.hasEntity(n)) {
                        EntityPacketRewriter1_8.this.handleEntityData(n, list, packetWrapper.user());
                    } else {
                        packetWrapper.cancel();
                    }
                    if (entityTracker1_8.clientEntityId() == n) {
                        entityTracker1_8.updateEntityData(list);
                    }
                });
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.ADD_ENTITY, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.BYTE);
                this.map(Types.INT);
                this.map(Types.INT);
                this.map(Types.INT);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.INT);
                this.handler(EntityPacketRewriter1_8.this.getObjectTrackerHandler());
                this.handler(EntityPacketRewriter1_8.this.getObjectRewriter(EntityTypes1_8.ObjectType::findById));
                this.handler(packetWrapper -> {
                    byte by;
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    int n2 = packetWrapper.get(Types.INT, 3);
                    EntityTypes1_8.EntityType entityType = EntityTypes1_8.ObjectType.getEntityType(packetWrapper.get(Types.BYTE, 0).byteValue(), n2);
                    if (entityType == null) {
                        return;
                    }
                    int n3 = packetWrapper.get(Types.INT, 0);
                    int n4 = packetWrapper.get(Types.INT, 1);
                    int n5 = packetWrapper.get(Types.INT, 2);
                    byte by2 = packetWrapper.get(Types.BYTE, 1);
                    byte by22 = packetWrapper.get(Types.BYTE, 2);
                    if (entityType == EntityTypes1_8.ObjectType.ITEM_FRAME.getType()) {
                        by = switch (by22) {
                            case -128 -> {
                                n5 += 32;
                                yield 0;
                            }
                            case -64 -> {
                                n3 -= 32;
                                yield -64;
                            }
                            case 0 -> {
                                n5 -= 32;
                                yield -128;
                            }
                            case 64 -> {
                                n3 += 32;
                                yield 64;
                            }
                            default -> by22;
                        };
                    } else if (entityType == EntityTypes1_8.ObjectType.ARMOR_STAND.getType()) {
                        packetWrapper.cancel();
                        EntityTracker1_8 n6 = (EntityTracker1_8)EntityPacketRewriter1_8.this.tracker(packetWrapper.user());
                        VirtualHologramEntity n7 = (VirtualHologramEntity)n6.getHolograms().get(n);
                        n7.setPosition((double)n3 / 32.0, (double)n4 / 32.0, (double)n5 / 32.0);
                        n7.setRotation((float)by22 * 360.0f / 256.0f, (float)by2 * 360.0f / 256.0f);
                        n7.setHeadYaw((float)by22 * 360.0f / 256.0f);
                    } else if (entityType.isOrHasParent(EntityTypes1_8.EntityType.FALLING_BLOCK)) {
                        int n6 = n2 & 0xFFF;
                        int n7 = n2 >> 12 & 0xF;
                        IdAndData idAndData = ((Protocol1_8To1_7_6_10)EntityPacketRewriter1_8.this.protocol).getItemRewriter().handleBlock(n6, n7);
                        if (idAndData != null) {
                            n6 = idAndData.getId();
                            n7 = idAndData.getData();
                        }
                        n2 = n6 | n7 << 16;
                        packetWrapper.set(Types.INT, 3, n2);
                    }
                    packetWrapper.set(Types.INT, 0, n3);
                    packetWrapper.set(Types.INT, 1, n4);
                    packetWrapper.set(Types.INT, 2, n5);
                    packetWrapper.set(Types.BYTE, 2, by);
                    if (n2 > 0) {
                        packetWrapper.passthrough(Types.SHORT);
                        packetWrapper.passthrough(Types.SHORT);
                        packetWrapper.passthrough(Types.SHORT);
                    }
                });
            }
        });
        this.registerTracker(ClientboundPackets1_8.ADD_EXPERIENCE_ORB, EntityTypes1_8.EntityType.EXPERIENCE_ORB);
        this.registerTracker(ClientboundPackets1_8.ADD_GLOBAL_ENTITY, EntityTypes1_8.EntityType.LIGHTNING_BOLT);
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.ADD_PAINTING, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.STRING);
                this.map(Types.BLOCK_POSITION1_8, RewindTypes.INT_POSITION);
                this.map(Types.UNSIGNED_BYTE, Types.INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    BlockPosition blockPosition = packetWrapper.get(RewindTypes.INT_POSITION, 0);
                    int n2 = packetWrapper.get(Types.INT, 0);
                    int n3 = 0;
                    int n4 = 0;
                    switch (n2) {
                        case 0: {
                            n4 = -1;
                            break;
                        }
                        case 1: {
                            n3 = 1;
                            break;
                        }
                        case 2: {
                            n4 = 1;
                            break;
                        }
                        case 3: {
                            n3 = -1;
                        }
                    }
                    packetWrapper.set(RewindTypes.INT_POSITION, 0, new BlockPosition(blockPosition.x() + n3, blockPosition.y(), blockPosition.z() + n4));
                    EntityPacketRewriter1_8.this.tracker(packetWrapper.user()).addEntity(n, EntityTypes1_8.EntityType.PAINTING);
                });
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.ADD_MOB, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.INT);
                this.map(Types.INT);
                this.map(Types.INT);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.SHORT);
                this.map(Types.SHORT);
                this.map(Types.SHORT);
                this.map(Types.ENTITY_DATA_LIST1_8, RewindTypes.ENTITY_DATA_LIST1_7);
                this.handler(EntityPacketRewriter1_8.this.getTrackerHandler(Types.UNSIGNED_BYTE, 0));
                this.handler(packetWrapper -> {
                    short s = packetWrapper.get(Types.UNSIGNED_BYTE, 0);
                    EntityTypes1_8.EntityType entityType = EntityTypes1_8.EntityType.findById(s);
                    if (entityType == EntityTypes1_8.EntityType.ARMOR_STAND) {
                        packetWrapper.cancel();
                        int n = packetWrapper.get(Types.VAR_INT, 0);
                        int n2 = packetWrapper.get(Types.INT, 0);
                        int n3 = packetWrapper.get(Types.INT, 1);
                        int n4 = packetWrapper.get(Types.INT, 2);
                        byte by = packetWrapper.get(Types.BYTE, 1);
                        byte by2 = packetWrapper.get(Types.BYTE, 0);
                        byte by3 = packetWrapper.get(Types.BYTE, 2);
                        EntityTracker1_8 entityTracker1_8 = (EntityTracker1_8)packetWrapper.user().getEntityTracker(Protocol1_8To1_7_6_10.class);
                        VirtualHologramEntity virtualHologramEntity = (VirtualHologramEntity)entityTracker1_8.getHolograms().get(n);
                        virtualHologramEntity.setPosition((double)n2 / 32.0, (double)n3 / 32.0, (double)n4 / 32.0);
                        virtualHologramEntity.setRotation((float)by2 * 360.0f / 256.0f, (float)by * 360.0f / 256.0f);
                        virtualHologramEntity.setHeadYaw((float)by3 * 360.0f / 256.0f);
                        virtualHologramEntity.syncState(((Protocol1_8To1_7_6_10)EntityPacketRewriter1_8.this.protocol()).getEntityRewriter(), packetWrapper.get(RewindTypes.ENTITY_DATA_LIST1_7, 0));
                    }
                });
                this.handler(EntityPacketRewriter1_8.this.getMobSpawnRewriter(RewindTypes.ENTITY_DATA_LIST1_7));
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.ADD_PLAYER, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    UUID uUID = packetWrapper.read(Types.UUID);
                    packetWrapper.write(Types.STRING, uUID.toString());
                    GameProfileStorage gameProfileStorage = packetWrapper.user().get(GameProfileStorage.class);
                    GameProfileStorage.GameProfile gameProfile = gameProfileStorage.get(uUID);
                    if (gameProfile == null) {
                        packetWrapper.write(Types.STRING, "");
                        packetWrapper.write(Types.VAR_INT, 0);
                    } else {
                        packetWrapper.write(Types.STRING, gameProfile.name.length() > 16 ? gameProfile.name.substring(0, 16) : gameProfile.name);
                        packetWrapper.write(Types.VAR_INT, gameProfile.properties.size());
                        for (GameProfileStorage.Property object2 : gameProfile.properties) {
                            packetWrapper.write(Types.STRING, object2.name);
                            packetWrapper.write(Types.STRING, object2.value);
                            packetWrapper.write(Types.STRING, object2.signature == null ? "" : object2.signature);
                        }
                    }
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    EntityTracker1_8 entityTracker1_8 = (EntityTracker1_8)packetWrapper.user().getEntityTracker(Protocol1_8To1_7_6_10.class);
                    if (gameProfile != null && gameProfile.gamemode == 3) {
                        for (short s = 0; s < 5; s = (short)(s + 1)) {
                            PacketWrapper packetWrapper2 = PacketWrapper.create(ClientboundPackets1_7_2_5.SET_EQUIPPED_ITEM, packetWrapper.user());
                            packetWrapper2.write(Types.INT, n);
                            packetWrapper2.write(Types.SHORT, s);
                            packetWrapper2.write(RewindTypes.COMPRESSED_NBT_ITEM, s == 4 ? gameProfile.getSkull() : null);
                            packetWrapper2.scheduleSend(Protocol1_8To1_7_6_10.class);
                        }
                    }
                    entityTracker1_8.addPlayer(n, uUID);
                });
                this.map(Types.INT);
                this.map(Types.INT);
                this.map(Types.INT);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.SHORT);
                this.map(Types.ENTITY_DATA_LIST1_8, RewindTypes.ENTITY_DATA_LIST1_7);
                this.handler(EntityPacketRewriter1_8.this.getTrackerAndDataHandler(RewindTypes.ENTITY_DATA_LIST1_7, EntityTypes1_8.EntityType.PLAYER));
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    EntityTracker1_8 entityTracker1_8 = (EntityTracker1_8)EntityPacketRewriter1_8.this.tracker(packetWrapper.user());
                    entityTracker1_8.checkNametagVisibility(n);
                });
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.SET_EQUIPPED_ITEM, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT, Types.INT);
                this.map(Types.SHORT);
                this.map(Types.ITEM1_8, RewindTypes.COMPRESSED_NBT_ITEM);
                this.handler(packetWrapper -> ((Protocol1_8To1_7_6_10)EntityPacketRewriter1_8.this.protocol).getItemRewriter().handleItemToClient(packetWrapper.user(), packetWrapper.get(RewindTypes.COMPRESSED_NBT_ITEM, 0)));
                this.handler(packetWrapper -> {
                    short s;
                    EntityTracker1_8 entityTracker1_8 = (EntityTracker1_8)packetWrapper.user().getEntityTracker(Protocol1_8To1_7_6_10.class);
                    int n = packetWrapper.get(Types.INT, 0);
                    short s2 = s = entityTracker1_8.clientEntityId() == n ? (short)3 : (short)4;
                    if (packetWrapper.get(Types.SHORT, 0) > s) {
                        packetWrapper.cancel();
                    }
                });
                this.handler(packetWrapper -> {
                    EntityTracker1_8 entityTracker1_8 = (EntityTracker1_8)packetWrapper.user().getEntityTracker(Protocol1_8To1_7_6_10.class);
                    short s = packetWrapper.get(Types.SHORT, 0);
                    UUID uUID = entityTracker1_8.getPlayerUUID(packetWrapper.get(Types.INT, 0));
                    if (uUID == null) {
                        return;
                    }
                    Item item = packetWrapper.get(RewindTypes.COMPRESSED_NBT_ITEM, 0);
                    packetWrapper.user().get(PlayerSessionStorage.class).setPlayerEquipment(uUID, item, s);
                    GameProfileStorage gameProfileStorage = packetWrapper.user().get(GameProfileStorage.class);
                    GameProfileStorage.GameProfile gameProfile = gameProfileStorage.get(uUID);
                    if (gameProfile != null && gameProfile.gamemode == 3) {
                        packetWrapper.cancel();
                    }
                });
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.PLAYER_SLEEP, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT, Types.INT);
                this.map(Types.BLOCK_POSITION1_8, RewindTypes.U_BYTE_POSITION);
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.TAKE_ITEM_ENTITY, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT, Types.INT);
                this.map(Types.VAR_INT, Types.INT);
                this.handler(packetWrapper -> packetWrapper.user().getEntityTracker(Protocol1_8To1_7_6_10.class).removeEntity(packetWrapper.get(Types.INT, 0)));
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.SET_ENTITY_MOTION, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT, Types.INT);
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.MOVE_ENTITY, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT, Types.INT);
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.MOVE_ENTITY_POS, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT, Types.INT);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.read(Types.BOOLEAN);
                this.handler(packetWrapper -> {
                    EntityTracker1_8 entityTracker1_8 = (EntityTracker1_8)packetWrapper.user().getEntityTracker(Protocol1_8To1_7_6_10.class);
                    VirtualHologramEntity virtualHologramEntity = entityTracker1_8.getHolograms().get(packetWrapper.get(Types.INT, 0));
                    if (virtualHologramEntity != null) {
                        packetWrapper.cancel();
                        byte by = packetWrapper.get(Types.BYTE, 0);
                        byte by2 = packetWrapper.get(Types.BYTE, 1);
                        byte by3 = packetWrapper.get(Types.BYTE, 2);
                        virtualHologramEntity.setRelativePosition((double)by / 32.0, (double)by2 / 32.0, (double)by3 / 32.0);
                    }
                });
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.MOVE_ENTITY_ROT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT, Types.INT);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.read(Types.BOOLEAN);
                this.handler(packetWrapper -> {
                    EntityTracker1_8 entityTracker1_8 = (EntityTracker1_8)packetWrapper.user().getEntityTracker(Protocol1_8To1_7_6_10.class);
                    VirtualHologramEntity virtualHologramEntity = entityTracker1_8.getHolograms().get(packetWrapper.get(Types.INT, 0));
                    if (virtualHologramEntity != null) {
                        packetWrapper.cancel();
                        byte by = packetWrapper.get(Types.BYTE, 0);
                        byte by2 = packetWrapper.get(Types.BYTE, 1);
                        virtualHologramEntity.setRotation((float)by * 360.0f / 256.0f, (float)by2 * 360.0f / 256.0f);
                    }
                });
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.MOVE_ENTITY_POS_ROT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT, Types.INT);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.read(Types.BOOLEAN);
                this.handler(packetWrapper -> {
                    EntityTracker1_8 entityTracker1_8 = (EntityTracker1_8)packetWrapper.user().getEntityTracker(Protocol1_8To1_7_6_10.class);
                    VirtualHologramEntity virtualHologramEntity = entityTracker1_8.getHolograms().get(packetWrapper.get(Types.INT, 0));
                    if (virtualHologramEntity != null) {
                        packetWrapper.cancel();
                        byte by = packetWrapper.get(Types.BYTE, 0);
                        byte by2 = packetWrapper.get(Types.BYTE, 1);
                        byte by3 = packetWrapper.get(Types.BYTE, 2);
                        byte by4 = packetWrapper.get(Types.BYTE, 3);
                        byte by5 = packetWrapper.get(Types.BYTE, 4);
                        virtualHologramEntity.setRelativePosition((double)by / 32.0, (double)by2 / 32.0, (double)by3 / 32.0);
                        virtualHologramEntity.setRotation((float)by4 * 360.0f / 256.0f, (float)by5 * 360.0f / 256.0f);
                    }
                });
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.TELEPORT_ENTITY, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT, Types.INT);
                this.map(Types.INT);
                this.map(Types.INT);
                this.map(Types.INT);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.read(Types.BOOLEAN);
                this.handler(packetWrapper -> {
                    VirtualHologramEntity virtualHologramEntity;
                    int n = packetWrapper.get(Types.INT, 0);
                    EntityTracker1_8 entityTracker1_8 = (EntityTracker1_8)packetWrapper.user().getEntityTracker(Protocol1_8To1_7_6_10.class);
                    if (entityTracker1_8.entityType(n) == EntityTypes1_8.EntityType.ABSTRACT_MINECART) {
                        int n2 = packetWrapper.get(Types.INT, 2);
                        packetWrapper.set(Types.INT, 2, n2 += 12);
                    }
                    if ((virtualHologramEntity = (VirtualHologramEntity)entityTracker1_8.getHolograms().get(n)) != null) {
                        packetWrapper.cancel();
                        int n3 = packetWrapper.get(Types.INT, 1);
                        int n4 = packetWrapper.get(Types.INT, 2);
                        int n5 = packetWrapper.get(Types.INT, 3);
                        byte by = packetWrapper.get(Types.BYTE, 0);
                        byte by2 = packetWrapper.get(Types.BYTE, 1);
                        virtualHologramEntity.setPosition((double)n3 / 32.0, (double)n4 / 32.0, (double)n5 / 32.0);
                        virtualHologramEntity.setRotation((float)by * 360.0f / 256.0f, (float)by2 * 360.0f / 256.0f);
                    }
                });
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.ROTATE_HEAD, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT, Types.INT);
                this.map(Types.BYTE);
                this.handler(packetWrapper -> {
                    EntityTracker1_8 entityTracker1_8 = (EntityTracker1_8)packetWrapper.user().getEntityTracker(Protocol1_8To1_7_6_10.class);
                    VirtualHologramEntity virtualHologramEntity = entityTracker1_8.getHolograms().get(packetWrapper.get(Types.INT, 0));
                    if (virtualHologramEntity != null) {
                        packetWrapper.cancel();
                        byte by = packetWrapper.get(Types.BYTE, 0);
                        virtualHologramEntity.setHeadYaw((float)by * 360.0f / 256.0f);
                    }
                });
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.SET_ENTITY_LINK, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.INT);
                this.map(Types.BOOLEAN);
                this.handler(packetWrapper -> {
                    boolean bl = packetWrapper.get(Types.BOOLEAN, 0);
                    if (!bl) {
                        EntityTracker1_8 entityTracker1_8 = (EntityTracker1_8)packetWrapper.user().getEntityTracker(Protocol1_8To1_7_6_10.class);
                        int n = packetWrapper.get(Types.INT, 0);
                        int n2 = packetWrapper.get(Types.INT, 1);
                        entityTracker1_8.setPassenger(n2, n);
                    }
                });
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.UPDATE_MOB_EFFECT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT, Types.INT);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.VAR_INT, Types.SHORT);
                this.read(Types.BYTE);
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.REMOVE_MOB_EFFECT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT, Types.INT);
                this.map(Types.BYTE);
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).registerClientbound(ClientboundPackets1_8.UPDATE_ATTRIBUTES, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT, Types.INT);
                this.handler(packetWrapper -> {
                    EntityTracker1_8 entityTracker1_8 = (EntityTracker1_8)packetWrapper.user().getEntityTracker(Protocol1_8To1_7_6_10.class);
                    if (entityTracker1_8.getHolograms().containsKey(packetWrapper.get(Types.INT, 0))) {
                        packetWrapper.cancel();
                        return;
                    }
                    int n = packetWrapper.passthrough(Types.INT);
                    for (int i = 0; i < n; ++i) {
                        packetWrapper.passthrough(Types.STRING);
                        packetWrapper.passthrough(Types.DOUBLE);
                        int n2 = packetWrapper.read(Types.VAR_INT);
                        packetWrapper.write(Types.SHORT, (short)n2);
                        for (int j = 0; j < n2; ++j) {
                            packetWrapper.passthrough(Types.UUID);
                            packetWrapper.passthrough(Types.DOUBLE);
                            packetWrapper.passthrough(Types.BYTE);
                        }
                    }
                });
            }
        });
        ((Protocol1_8To1_7_6_10)this.protocol).cancelClientbound(ClientboundPackets1_8.UPDATE_ENTITY_NBT);
    }

    @Override
    protected void registerRewrites() {
        this.mapEntityTypeWithData(EntityTypes1_8.EntityType.GUARDIAN, EntityTypes1_8.EntityType.SQUID).plainName();
        this.mapEntityTypeWithData(EntityTypes1_8.EntityType.ENDERMITE, EntityTypes1_8.EntityType.SQUID).plainName();
        this.mapEntityTypeWithData(EntityTypes1_8.EntityType.RABBIT, EntityTypes1_8.EntityType.CHICKEN).plainName();
        this.filter().handler(this::handleEntityData);
    }

    public void handleEntityData(EntityDataHandlerEvent entityDataHandlerEvent, EntityData entityData) {
        EntityDataIndex1_7_6_10 entityDataIndex1_7_6_10 = EntityDataIndex1_7_6_10.searchIndex(entityDataHandlerEvent.entityType(), entityData.id());
        if (entityDataIndex1_7_6_10 == null) {
            entityDataHandlerEvent.cancel();
            return;
        }
        if (entityDataIndex1_7_6_10.getOldType() == null) {
            entityDataHandlerEvent.cancel();
            return;
        }
        Object object = entityData.getValue();
        entityData.setTypeAndValue(entityDataIndex1_7_6_10.getNewType(), object);
        entityData.setDataTypeUnsafe(entityDataIndex1_7_6_10.getOldType());
        entityData.setId(entityDataIndex1_7_6_10.getIndex());
        switch (entityDataIndex1_7_6_10.getOldType()) {
            case INT: {
                if (entityDataIndex1_7_6_10.getNewType() == EntityDataTypes1_8.BYTE) {
                    entityData.setValue(((Byte)object).intValue());
                    if (entityDataIndex1_7_6_10 == EntityDataIndex1_7_6_10.ABSTRACT_AGEABLE_AGE && (Integer)entityData.getValue() < 0) {
                        entityData.setValue(-25000);
                    }
                }
                if (entityDataIndex1_7_6_10.getNewType() == EntityDataTypes1_8.SHORT) {
                    entityData.setValue(((Short)object).intValue());
                }
                if (entityDataIndex1_7_6_10.getNewType() != EntityDataTypes1_8.INT) break;
                entityData.setValue(object);
                break;
            }
            case BYTE: {
                if (entityDataIndex1_7_6_10.getNewType() == EntityDataTypes1_8.INT) {
                    entityData.setValue(((Integer)object).byteValue());
                }
                if (entityDataIndex1_7_6_10.getNewType() == EntityDataTypes1_8.BYTE) {
                    if (entityDataIndex1_7_6_10 == EntityDataIndex1_7_6_10.ITEM_FRAME_ROTATION) {
                        entityData.setValue(Integer.valueOf((Byte)object % 4).byteValue());
                    } else {
                        entityData.setValue(object);
                    }
                }
                if (entityDataIndex1_7_6_10 != EntityDataIndex1_7_6_10.PLAYER_SKIN_FLAGS) break;
                byte by = (Byte)object;
                boolean bl = (by & 1) != 0;
                by = (byte)(bl ? 0 : 2);
                entityData.setValue(by);
                break;
            }
            case ITEM: {
                entityData.setValue(((Protocol1_8To1_7_6_10)this.protocol).getItemRewriter().handleItemToClient(entityDataHandlerEvent.user(), (Item)object));
                break;
            }
            case FLOAT: 
            case STRING: 
            case SHORT: 
            case POSITION: {
                entityData.setValue(object);
                break;
            }
            default: {
                entityDataHandlerEvent.cancel();
            }
        }
    }

    @Override
    public EntityTypes1_8.EntityType typeFromId(int n) {
        return EntityTypes1_8.EntityType.findById(n);
    }

    @Override
    public EntityTypes1_8.EntityType objectTypeFromId(int n, int n2) {
        return EntityTypes1_8.ObjectType.getEntityType(n, n2);
    }
}


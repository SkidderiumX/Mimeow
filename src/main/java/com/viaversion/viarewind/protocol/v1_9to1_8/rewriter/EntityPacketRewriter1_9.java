/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.protocol.v1_9to1_8.rewriter;

import com.viaversion.viarewind.api.minecraft.math.RelativeMoveUtil;
import com.viaversion.viarewind.api.rewriter.VREntityRewriter;
import com.viaversion.viarewind.protocol.v1_9to1_8.Protocol1_9To1_8;
import com.viaversion.viarewind.protocol.v1_9to1_8.data.EntityDataIndex1_8;
import com.viaversion.viarewind.protocol.v1_9to1_8.storage.CooldownStorage;
import com.viaversion.viarewind.protocol.v1_9to1_8.storage.EntityTracker1_9;
import com.viaversion.viarewind.protocol.v1_9to1_8.storage.LevitationStorage;
import com.viaversion.viarewind.protocol.v1_9to1_8.storage.PlayerPositionTracker;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.minecraft.EulerAngle;
import com.viaversion.viaversion.api.minecraft.Vector;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_9;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_8;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.libs.fastutil.ints.IntArrayList;
import com.viaversion.viaversion.libs.fastutil.ints.IntList;
import com.viaversion.viaversion.protocols.v1_8to1_9.data.EntityDataIndex1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ClientboundPackets1_8;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ClientboundPackets1_9;
import com.viaversion.viaversion.rewriter.entitydata.EntityDataHandlerEvent;
import com.viaversion.viaversion.util.IdAndData;
import com.viaversion.viaversion.util.Pair;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EntityPacketRewriter1_9
extends VREntityRewriter<ClientboundPackets1_9, Protocol1_9To1_8> {
    private static final byte HAND_ACTIVE_BIT = 0;
    private static final byte STATUS_USE_BIT = 4;

    public EntityPacketRewriter1_9(Protocol1_9To1_8 protocol1_9To1_8) {
        super(protocol1_9To1_8);
    }

    @Override
    protected void registerPackets() {
        this.registerRemoveEntities(ClientboundPackets1_9.REMOVE_ENTITIES);
        ((Protocol1_9To1_8)this.protocol).registerClientbound(ClientboundPackets1_9.LOGIN, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.INT);
            packetWrapper.passthrough(Types.UNSIGNED_BYTE);
            byte by = packetWrapper.passthrough(Types.BYTE);
            this.trackPlayer(packetWrapper.user(), n);
            Object t = packetWrapper.user().getClientWorld(Protocol1_9To1_8.class);
            ((ClientWorld)t).setEnvironment(by);
        });
        ((Protocol1_9To1_8)this.protocol).registerClientbound(ClientboundPackets1_9.SET_ENTITY_DATA, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            if (!this.tracker(packetWrapper.user()).hasEntity(n)) {
                packetWrapper.cancel();
                return;
            }
            List<EntityData> list = packetWrapper.read(Types.ENTITY_DATA_LIST1_9);
            this.handleEntityData(n, list, packetWrapper.user());
            packetWrapper.write(Types.ENTITY_DATA_LIST1_8, list);
        });
        ((Protocol1_9To1_8)this.protocol).registerClientbound(ClientboundPackets1_9.ADD_ENTITY, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.read(Types.UUID);
                this.map(Types.BYTE);
                this.map(Types.DOUBLE, Protocol1_9To1_8.DOUBLE_TO_INT_TIMES_32);
                this.map(Types.DOUBLE, Protocol1_9To1_8.DOUBLE_TO_INT_TIMES_32);
                this.map(Types.DOUBLE, Protocol1_9To1_8.DOUBLE_TO_INT_TIMES_32);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.INT);
                this.handler(EntityPacketRewriter1_9.this.getObjectTrackerHandler());
                this.handler(EntityPacketRewriter1_9.this.getObjectRewriter(EntityTypes1_9.ObjectType::findById));
                this.handler(packetWrapper -> {
                    int n;
                    int n2 = packetWrapper.get(Types.VAR_INT, 0);
                    byte by2 = packetWrapper.get(Types.BYTE, 0);
                    EntityTypes1_9.EntityType entityType = EntityTypes1_9.ObjectType.getEntityType(by2, n = packetWrapper.get(Types.INT, 3).intValue());
                    if (entityType == null || entityType == EntityTypes1_9.EntityType.AREA_EFFECT_CLOUD || entityType == EntityTypes1_9.EntityType.SPECTRAL_ARROW || entityType == EntityTypes1_9.EntityType.DRAGON_FIREBALL) {
                        packetWrapper.cancel();
                        return;
                    }
                    if (entityType.is(EntityTypes1_9.EntityType.BOAT)) {
                        byte by3 = packetWrapper.get(Types.BYTE, 1);
                        by3 = (byte)(by3 - 64);
                        packetWrapper.set(Types.BYTE, 1, by3);
                        int n3 = packetWrapper.get(Types.INT, 1);
                        packetWrapper.set(Types.INT, 1, (int)(var7_11 += 6));
                    }
                    if (entityType.isOrHasParent(EntityTypes1_9.EntityType.ARROW) && n != 0) {
                        packetWrapper.set(Types.INT, 3, --n);
                    }
                    if (entityType.is(EntityTypes1_9.EntityType.FALLING_BLOCK)) {
                        int n4 = n & 0xFFF;
                        int n5 = n >> 12 & 0xF;
                        IdAndData idAndData = ((Protocol1_9To1_8)EntityPacketRewriter1_9.this.protocol).getItemRewriter().handleBlock(n4, n5);
                        if (idAndData != null) {
                            packetWrapper.set(Types.INT, 3, idAndData.getId() | idAndData.getData() << 12);
                        }
                    }
                    if (n > 0) {
                        packetWrapper.passthrough(Types.SHORT);
                        packetWrapper.passthrough(Types.SHORT);
                        packetWrapper.passthrough(Types.SHORT);
                    } else {
                        short s = packetWrapper.read(Types.SHORT);
                        short s2 = packetWrapper.read(Types.SHORT);
                        short s3 = packetWrapper.read(Types.SHORT);
                        PacketWrapper packetWrapper2 = PacketWrapper.create(ClientboundPackets1_8.SET_ENTITY_MOTION, packetWrapper.user());
                        packetWrapper2.write(Types.VAR_INT, n2);
                        packetWrapper2.write(Types.SHORT, s);
                        packetWrapper2.write(Types.SHORT, s2);
                        packetWrapper2.write(Types.SHORT, s3);
                        packetWrapper2.scheduleSend(Protocol1_9To1_8.class);
                    }
                });
            }
        });
        ((Protocol1_9To1_8)this.protocol).registerClientbound(ClientboundPackets1_9.ADD_EXPERIENCE_ORB, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.DOUBLE, Protocol1_9To1_8.DOUBLE_TO_INT_TIMES_32);
                this.map(Types.DOUBLE, Protocol1_9To1_8.DOUBLE_TO_INT_TIMES_32);
                this.map(Types.DOUBLE, Protocol1_9To1_8.DOUBLE_TO_INT_TIMES_32);
                this.map(Types.SHORT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    packetWrapper.user().getEntityTracker(Protocol1_9To1_8.class).addEntity(n, EntityTypes1_9.EntityType.EXPERIENCE_ORB);
                });
            }
        });
        ((Protocol1_9To1_8)this.protocol).registerClientbound(ClientboundPackets1_9.ADD_GLOBAL_ENTITY, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.BYTE);
                this.map(Types.DOUBLE, Protocol1_9To1_8.DOUBLE_TO_INT_TIMES_32);
                this.map(Types.DOUBLE, Protocol1_9To1_8.DOUBLE_TO_INT_TIMES_32);
                this.map(Types.DOUBLE, Protocol1_9To1_8.DOUBLE_TO_INT_TIMES_32);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    packetWrapper.user().getEntityTracker(Protocol1_9To1_8.class).addEntity(n, EntityTypes1_9.EntityType.LIGHTNING_BOLT);
                });
            }
        });
        ((Protocol1_9To1_8)this.protocol).registerClientbound(ClientboundPackets1_9.ADD_MOB, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.read(Types.UUID);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.DOUBLE, Protocol1_9To1_8.DOUBLE_TO_INT_TIMES_32);
                this.map(Types.DOUBLE, Protocol1_9To1_8.DOUBLE_TO_INT_TIMES_32);
                this.map(Types.DOUBLE, Protocol1_9To1_8.DOUBLE_TO_INT_TIMES_32);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.SHORT);
                this.map(Types.SHORT);
                this.map(Types.SHORT);
                this.map(Types.ENTITY_DATA_LIST1_9, Types.ENTITY_DATA_LIST1_8);
                this.handler(EntityPacketRewriter1_9.this.getTrackerHandler(Types.UNSIGNED_BYTE, 0));
                this.handler(EntityPacketRewriter1_9.this.getMobSpawnRewriter(Types.ENTITY_DATA_LIST1_8));
            }
        });
        ((Protocol1_9To1_8)this.protocol).registerClientbound(ClientboundPackets1_9.ADD_PAINTING, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.read(Types.UUID);
                this.map(Types.STRING);
                this.map(Types.BLOCK_POSITION1_8);
                this.map(Types.BYTE, Types.UNSIGNED_BYTE);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    packetWrapper.user().getEntityTracker(Protocol1_9To1_8.class).addEntity(n, EntityTypes1_9.EntityType.PAINTING);
                });
            }
        });
        ((Protocol1_9To1_8)this.protocol).registerClientbound(ClientboundPackets1_9.ADD_PLAYER, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.UUID);
                this.map(Types.DOUBLE, Protocol1_9To1_8.DOUBLE_TO_INT_TIMES_32);
                this.map(Types.DOUBLE, Protocol1_9To1_8.DOUBLE_TO_INT_TIMES_32);
                this.map(Types.DOUBLE, Protocol1_9To1_8.DOUBLE_TO_INT_TIMES_32);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.create(Types.SHORT, (short)0);
                this.map(Types.ENTITY_DATA_LIST1_9, Types.ENTITY_DATA_LIST1_8);
                this.handler(EntityPacketRewriter1_9.this.getTrackerAndDataHandler(Types.ENTITY_DATA_LIST1_8, EntityTypes1_9.EntityType.PLAYER));
            }
        });
        ((Protocol1_9To1_8)this.protocol).registerClientbound(ClientboundPackets1_9.ENTITY_EVENT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    byte by = packetWrapper.read(Types.BYTE);
                    if (by > 23) {
                        packetWrapper.cancel();
                        return;
                    }
                    packetWrapper.write(Types.BYTE, by);
                });
            }
        });
        ((Protocol1_9To1_8)this.protocol).registerClientbound(ClientboundPackets1_9.MOVE_ENTITY_POS, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            short s = packetWrapper.read(Types.SHORT);
            short s2 = packetWrapper.read(Types.SHORT);
            short s3 = packetWrapper.read(Types.SHORT);
            Vector[] vectorArray = RelativeMoveUtil.calculateRelativeMoves(packetWrapper.user(), n, s, s2, s3);
            packetWrapper.write(Types.BYTE, (byte)vectorArray[0].blockX());
            packetWrapper.write(Types.BYTE, (byte)vectorArray[0].blockY());
            packetWrapper.write(Types.BYTE, (byte)vectorArray[0].blockZ());
            boolean bl = packetWrapper.passthrough(Types.BOOLEAN);
            if (vectorArray.length > 1) {
                PacketWrapper packetWrapper2 = PacketWrapper.create(ClientboundPackets1_8.MOVE_ENTITY_POS, packetWrapper.user());
                packetWrapper2.write(Types.VAR_INT, n);
                packetWrapper2.write(Types.BYTE, (byte)vectorArray[1].blockX());
                packetWrapper2.write(Types.BYTE, (byte)vectorArray[1].blockY());
                packetWrapper2.write(Types.BYTE, (byte)vectorArray[1].blockZ());
                packetWrapper2.write(Types.BOOLEAN, bl);
                packetWrapper2.scheduleSend(Protocol1_9To1_8.class);
            }
        });
        ((Protocol1_9To1_8)this.protocol).registerClientbound(ClientboundPackets1_9.MOVE_ENTITY_POS_ROT, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            short s = packetWrapper.read(Types.SHORT);
            short s2 = packetWrapper.read(Types.SHORT);
            short s3 = packetWrapper.read(Types.SHORT);
            Vector[] vectorArray = RelativeMoveUtil.calculateRelativeMoves(packetWrapper.user(), n, s, s2, s3);
            packetWrapper.write(Types.BYTE, (byte)vectorArray[0].blockX());
            packetWrapper.write(Types.BYTE, (byte)vectorArray[0].blockY());
            packetWrapper.write(Types.BYTE, (byte)vectorArray[0].blockZ());
            byte by = packetWrapper.passthrough(Types.BYTE);
            byte by2 = packetWrapper.passthrough(Types.BYTE);
            boolean bl = packetWrapper.passthrough(Types.BOOLEAN);
            EntityType entityType = packetWrapper.user().getEntityTracker(Protocol1_9To1_8.class).entityType(n);
            if (entityType == EntityTypes1_9.EntityType.BOAT) {
                by = (byte)(by - 64);
                packetWrapper.set(Types.BYTE, 3, by);
            }
            if (vectorArray.length > 1) {
                PacketWrapper packetWrapper2 = PacketWrapper.create(ClientboundPackets1_8.MOVE_ENTITY_POS_ROT, packetWrapper.user());
                packetWrapper2.write(Types.VAR_INT, n);
                packetWrapper2.write(Types.BYTE, (byte)vectorArray[1].blockX());
                packetWrapper2.write(Types.BYTE, (byte)vectorArray[1].blockY());
                packetWrapper2.write(Types.BYTE, (byte)vectorArray[1].blockZ());
                packetWrapper2.write(Types.BYTE, by);
                packetWrapper2.write(Types.BYTE, by2);
                packetWrapper2.write(Types.BOOLEAN, bl);
                packetWrapper2.scheduleSend(Protocol1_9To1_8.class);
            }
        });
        ((Protocol1_9To1_8)this.protocol).registerClientbound(ClientboundPackets1_9.MOVE_ENTITY_ROT, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            EntityType entityType = packetWrapper.user().getEntityTracker(Protocol1_9To1_8.class).entityType(n);
            if (entityType == EntityTypes1_9.EntityType.BOAT) {
                byte by = packetWrapper.read(Types.BYTE);
                by = (byte)(by - 64);
                packetWrapper.write(Types.BYTE, by);
            }
        });
        ((Protocol1_9To1_8)this.protocol).registerClientbound(ClientboundPackets1_9.MOVE_VEHICLE, ClientboundPackets1_8.TELEPORT_ENTITY, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.handler(packetWrapper -> {
                    EntityTracker1_9 entityTracker1_9 = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_9To1_8.class);
                    Integer n = entityTracker1_9.getVehicle(entityTracker1_9.clientEntityId());
                    if (n == null) {
                        packetWrapper.cancel();
                    } else {
                        packetWrapper.write(Types.VAR_INT, n);
                    }
                });
                this.map(Types.DOUBLE, Protocol1_9To1_8.DOUBLE_TO_INT_TIMES_32);
                this.map(Types.DOUBLE, Protocol1_9To1_8.DOUBLE_TO_INT_TIMES_32);
                this.map(Types.DOUBLE, Protocol1_9To1_8.DOUBLE_TO_INT_TIMES_32);
                this.map(Types.FLOAT, Protocol1_9To1_8.DEGREES_TO_ANGLE);
                this.map(Types.FLOAT, Protocol1_9To1_8.DEGREES_TO_ANGLE);
                this.handler(packetWrapper -> {
                    if (packetWrapper.isCancelled()) {
                        return;
                    }
                    PlayerPositionTracker playerPositionTracker = packetWrapper.user().get(PlayerPositionTracker.class);
                    double d = (double)packetWrapper.get(Types.INT, 0).intValue() / 32.0;
                    double d2 = (double)packetWrapper.get(Types.INT, 1).intValue() / 32.0;
                    double d3 = (double)packetWrapper.get(Types.INT, 2).intValue() / 32.0;
                    playerPositionTracker.setPos(d, d2, d3);
                });
                this.create(Types.BOOLEAN, true);
                this.handler(packetWrapper -> {
                    if (packetWrapper.isCancelled()) {
                        return;
                    }
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    EntityType entityType = packetWrapper.user().getEntityTracker(Protocol1_9To1_8.class).entityType(n);
                    if (entityType == EntityTypes1_9.EntityType.BOAT) {
                        byte by = packetWrapper.get(Types.BYTE, 0);
                        by = (byte)(by - 64);
                        packetWrapper.set(Types.BYTE, 0, by);
                        int n2 = packetWrapper.get(Types.INT, 1);
                        packetWrapper.set(Types.INT, 1, n2 += 6);
                    }
                });
            }
        });
        ((Protocol1_9To1_8)this.protocol).registerClientbound(ClientboundPackets1_9.REMOVE_MOB_EFFECT, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            byte by = packetWrapper.passthrough(Types.BYTE);
            if (by > 23) {
                packetWrapper.cancel();
            }
            EntityTracker1_9 entityTracker1_9 = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_9To1_8.class);
            if (by == 25 && n == entityTracker1_9.clientEntityId()) {
                packetWrapper.user().get(LevitationStorage.class).setActive(false);
            }
        });
        ((Protocol1_9To1_8)this.protocol).registerClientbound(ClientboundPackets1_9.SET_ENTITY_LINK, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.INT);
                this.create(Types.BOOLEAN, true);
            }
        });
        ((Protocol1_9To1_8)this.protocol).registerClientbound(ClientboundPackets1_9.SET_EQUIPPED_ITEM, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.read(Types.VAR_INT);
                    if (n == 1) {
                        packetWrapper.cancel();
                    } else if (n > 1) {
                        --n;
                    }
                    packetWrapper.write(Types.SHORT, (short)n);
                });
                this.map(Types.ITEM1_8);
                this.handler(packetWrapper -> ((Protocol1_9To1_8)EntityPacketRewriter1_9.this.protocol).getItemRewriter().handleItemToClient(packetWrapper.user(), packetWrapper.get(Types.ITEM1_8, 0)));
            }
        });
        ((Protocol1_9To1_8)this.protocol).registerClientbound(ClientboundPackets1_9.SET_PASSENGERS, null, packetWrapper -> {
            packetWrapper.cancel();
            EntityTracker1_9 entityTracker1_9 = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_9To1_8.class);
            int n = packetWrapper.read(Types.VAR_INT);
            IntList intList = entityTracker1_9.getPassengers(n);
            IntArrayList intArrayList = new IntArrayList(packetWrapper.read(Types.VAR_INT_ARRAY_PRIMITIVE));
            entityTracker1_9.setPassengers(n, intArrayList);
            if (!intList.isEmpty()) {
                for (Integer n2 : intList) {
                    PacketWrapper packetWrapper2 = PacketWrapper.create(ClientboundPackets1_8.SET_ENTITY_LINK, packetWrapper.user());
                    packetWrapper2.write(Types.INT, n2);
                    packetWrapper2.write(Types.INT, -1);
                    packetWrapper2.write(Types.BOOLEAN, false);
                    packetWrapper2.scheduleSend(Protocol1_9To1_8.class);
                }
            }
            for (int i = 0; i < intArrayList.size(); ++i) {
                int n3 = intArrayList.getInt(i);
                int n4 = i == 0 ? n : intArrayList.getInt(i - 1);
                PacketWrapper packetWrapper3 = PacketWrapper.create(ClientboundPackets1_8.SET_ENTITY_LINK, packetWrapper.user());
                packetWrapper3.write(Types.INT, n3);
                packetWrapper3.write(Types.INT, n4);
                packetWrapper3.write(Types.BOOLEAN, false);
                packetWrapper3.scheduleSend(Protocol1_9To1_8.class);
            }
        });
        ((Protocol1_9To1_8)this.protocol).registerClientbound(ClientboundPackets1_9.TELEPORT_ENTITY, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.DOUBLE, Protocol1_9To1_8.DOUBLE_TO_INT_TIMES_32);
                this.map(Types.DOUBLE, Protocol1_9To1_8.DOUBLE_TO_INT_TIMES_32);
                this.map(Types.DOUBLE, Protocol1_9To1_8.DOUBLE_TO_INT_TIMES_32);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.BOOLEAN);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    EntityTracker1_9 entityTracker1_9 = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_9To1_8.class);
                    if (entityTracker1_9.entityType(n) == EntityTypes1_9.EntityType.BOAT) {
                        byte by = packetWrapper.get(Types.BYTE, 0);
                        by = (byte)(by - 64);
                        packetWrapper.set(Types.BYTE, 0, by);
                        int n2 = packetWrapper.get(Types.INT, 1);
                        packetWrapper.set(Types.INT, 1, n2 += 6);
                    }
                    entityTracker1_9.resetEntityOffset(n);
                });
            }
        });
        ((Protocol1_9To1_8)this.protocol).registerClientbound(ClientboundPackets1_9.UPDATE_ATTRIBUTES, packetWrapper -> {
            EntityTracker1_9 entityTracker1_9;
            int n = packetWrapper.passthrough(Types.VAR_INT);
            boolean bl = n == (entityTracker1_9 = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_9To1_8.class)).clientEntityId();
            int n2 = 0;
            int n3 = packetWrapper.passthrough(Types.INT);
            for (int i = 0; i < n3; ++i) {
                String string = packetWrapper.read(Types.STRING);
                double d = packetWrapper.read(Types.DOUBLE);
                int n4 = packetWrapper.read(Types.VAR_INT);
                boolean bl2 = ((Protocol1_9To1_8)this.protocol).getItemRewriter().VALID_ATTRIBUTES.contains(string);
                if (bl2) {
                    packetWrapper.write(Types.STRING, string);
                    packetWrapper.write(Types.DOUBLE, d);
                    packetWrapper.write(Types.VAR_INT, n4);
                }
                ArrayList<Pair<Byte, Double>> arrayList = new ArrayList<Pair<Byte, Double>>();
                for (int j = 0; j < n4; ++j) {
                    UUID uUID = packetWrapper.read(Types.UUID);
                    double d2 = packetWrapper.read(Types.DOUBLE);
                    byte by = packetWrapper.read(Types.BYTE);
                    if (bl2) {
                        packetWrapper.write(Types.UUID, uUID);
                        packetWrapper.write(Types.DOUBLE, d2);
                        packetWrapper.write(Types.BYTE, by);
                    }
                    arrayList.add(new Pair<Byte, Double>(by, d2));
                }
                if (bl2) continue;
                if (bl && string.equals("generic.attackSpeed")) {
                    packetWrapper.user().get(CooldownStorage.class).setAttackSpeed(d, arrayList);
                }
                ++n2;
            }
            packetWrapper.set(Types.INT, 0, n3 - n2);
        });
        ((Protocol1_9To1_8)this.protocol).registerClientbound(ClientboundPackets1_9.UPDATE_MOB_EFFECT, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            byte by = packetWrapper.passthrough(Types.BYTE);
            byte by2 = packetWrapper.passthrough(Types.BYTE);
            if (by > 23) {
                packetWrapper.cancel();
            }
            EntityTracker1_9 entityTracker1_9 = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_9To1_8.class);
            if (by == 25 && n == entityTracker1_9.clientEntityId()) {
                LevitationStorage levitationStorage = packetWrapper.user().get(LevitationStorage.class);
                levitationStorage.setActive(true);
                levitationStorage.setAmplifier(by2);
            }
        });
    }

    @Override
    protected void registerRewrites() {
        this.mapEntityTypeWithData(EntityTypes1_9.EntityType.SHULKER, EntityTypes1_9.EntityType.MAGMA_CUBE).plainName();
        this.mapEntityTypeWithData(EntityTypes1_9.EntityType.SHULKER_BULLET, EntityTypes1_9.EntityType.WITCH).plainName();
        this.filter().handler(this::handleEntityData);
    }

    private void handleEntityData(EntityDataHandlerEvent entityDataHandlerEvent, EntityData entityData) {
        EntityDataIndex1_9 entityDataIndex1_9;
        EntityTracker1_9 entityTracker1_9 = (EntityTracker1_9)this.tracker(entityDataHandlerEvent.user());
        if (entityData.id() == EntityDataIndex1_9.ENTITY_STATUS.getIndex()) {
            entityTracker1_9.getStatus().put(entityDataHandlerEvent.entityId(), ((Byte)entityData.value()).byteValue());
        }
        if ((entityDataIndex1_9 = EntityDataIndex1_8.searchIndex(entityDataHandlerEvent.entityType(), entityData.id())) == null) {
            entityDataHandlerEvent.cancel();
            return;
        }
        if (entityDataIndex1_9.getOldType() == null || entityDataIndex1_9.getNewType() == null) {
            if (entityDataIndex1_9 == EntityDataIndex1_9.PLAYER_HAND) {
                byte by = (byte)entityTracker1_9.getStatus().getOrDefault(entityDataHandlerEvent.entityId(), 0);
                by = ((Byte)entityData.value() & 1) != 0 ? (byte)(by | 0x10) : (byte)(by & 0xFFFFFFEF);
                entityDataHandlerEvent.createExtraData(new EntityData(EntityDataIndex1_9.ENTITY_STATUS.getIndex(), EntityDataTypes1_8.BYTE, by));
            }
            entityDataHandlerEvent.cancel();
            return;
        }
        entityData.setId(entityDataIndex1_9.getIndex());
        entityData.setDataTypeUnsafe(entityDataIndex1_9.getOldType());
        Object object = entityData.getValue();
        switch (entityDataIndex1_9.getNewType()) {
            case BYTE: {
                if (entityDataIndex1_9.getOldType() == EntityDataTypes1_8.BYTE) {
                    entityData.setValue(object);
                }
                if (entityDataIndex1_9.getOldType() != EntityDataTypes1_8.INT) break;
                entityData.setValue(((Byte)object).intValue());
                break;
            }
            case OPTIONAL_UUID: {
                if (entityDataIndex1_9.getOldType() != EntityDataTypes1_8.STRING) {
                    entityDataHandlerEvent.cancel();
                    break;
                }
                UUID uUID = (UUID)object;
                entityData.setValue(uUID != null ? uUID.toString() : "");
                break;
            }
            case OPTIONAL_BLOCK_STATE: {
                entityDataHandlerEvent.cancel();
                entityDataHandlerEvent.createExtraData(new EntityData(entityDataIndex1_9.getIndex(), EntityDataTypes1_8.SHORT, ((Integer)object).shortValue()));
                break;
            }
            case VAR_INT: {
                if (entityDataIndex1_9.getOldType() == EntityDataTypes1_8.BYTE) {
                    entityData.setValue(((Integer)object).byteValue());
                }
                if (entityDataIndex1_9.getOldType() == EntityDataTypes1_8.SHORT) {
                    entityData.setValue(((Integer)object).shortValue());
                }
                if (entityDataIndex1_9.getOldType() != EntityDataTypes1_8.INT) break;
                entityData.setValue(object);
                break;
            }
            case FLOAT: 
            case STRING: 
            case COMPONENT: {
                entityData.setValue(object);
                break;
            }
            case BOOLEAN: {
                boolean bl = (Boolean)object;
                if (entityDataIndex1_9 == EntityDataIndex1_9.ABSTRACT_AGEABLE_AGE) {
                    entityData.setValue((byte)(bl ? -1 : 0));
                    break;
                }
                entityData.setValue((byte)(bl ? 1 : 0));
                break;
            }
            case ITEM: {
                entityData.setValue(((Protocol1_9To1_8)this.protocol).getItemRewriter().handleItemToClient(entityDataHandlerEvent.user(), (Item)object));
                break;
            }
            case BLOCK_POSITION: {
                BlockPosition blockPosition = (BlockPosition)object;
                entityData.setValue(blockPosition);
                break;
            }
            case ROTATIONS: {
                EulerAngle eulerAngle = (EulerAngle)object;
                entityData.setValue(eulerAngle);
                break;
            }
            default: {
                entityDataHandlerEvent.cancel();
            }
        }
    }

    @Override
    public EntityTypes1_9.EntityType typeFromId(int n) {
        return EntityTypes1_9.EntityType.findById(n);
    }

    @Override
    public EntityTypes1_9.EntityType objectTypeFromId(int n, int n2) {
        return EntityTypes1_9.ObjectType.getEntityType(n, n2);
    }
}


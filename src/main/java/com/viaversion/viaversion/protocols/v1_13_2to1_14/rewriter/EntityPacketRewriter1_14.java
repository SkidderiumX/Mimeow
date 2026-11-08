/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_13_2to1_14.rewriter;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.minecraft.VillagerData;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_13;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_14;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.item.DataItem;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_13_2;
import com.viaversion.viaversion.api.type.types.version.Types1_14;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ClientboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_13_2to1_14.Protocol1_13_2To1_14;
import com.viaversion.viaversion.protocols.v1_13_2to1_14.packet.ClientboundPackets1_14;
import com.viaversion.viaversion.protocols.v1_13_2to1_14.rewriter.WorldPacketRewriter1_14;
import com.viaversion.viaversion.protocols.v1_13_2to1_14.storage.EntityTracker1_14;
import com.viaversion.viaversion.rewriter.EntityRewriter;
import java.util.ArrayList;

public class EntityPacketRewriter1_14
extends EntityRewriter<ClientboundPackets1_13, Protocol1_13_2To1_14> {
    public EntityPacketRewriter1_14(Protocol1_13_2To1_14 protocol1_13_2To1_14) {
        super(protocol1_13_2To1_14);
    }

    @Override
    protected void registerPackets() {
        ((Protocol1_13_2To1_14)this.protocol).registerClientbound(ClientboundPackets1_13.ADD_EXPERIENCE_ORB, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            this.tracker(packetWrapper.user()).addEntity(n, EntityTypes1_14.EXPERIENCE_ORB);
        });
        ((Protocol1_13_2To1_14)this.protocol).registerClientbound(ClientboundPackets1_13.ADD_GLOBAL_ENTITY, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            if (packetWrapper.passthrough(Types.BYTE) == 1) {
                this.tracker(packetWrapper.user()).addEntity(n, EntityTypes1_14.LIGHTNING_BOLT);
            }
        });
        ((Protocol1_13_2To1_14)this.protocol).registerClientbound(ClientboundPackets1_13.ADD_ENTITY, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.UUID);
                this.map(Types.BYTE, Types.VAR_INT);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.INT);
                this.map(Types.SHORT);
                this.map(Types.SHORT);
                this.map(Types.SHORT);
                this.handler(packetWrapper -> {
                    int n;
                    int n2 = packetWrapper.get(Types.VAR_INT, 0);
                    int n3 = packetWrapper.get(Types.VAR_INT, 1);
                    EntityTypes1_13.EntityType entityType = EntityTypes1_13.ObjectType.getEntityType(n3, n = packetWrapper.get(Types.INT, 0).intValue());
                    if (entityType == null) {
                        return;
                    }
                    n3 = EntityPacketRewriter1_14.this.newEntityId(entityType.getId());
                    EntityType entityType2 = EntityTypes1_14.getTypeFromId(n3);
                    if (entityType2.is(EntityTypes1_14.FALLING_BLOCK)) {
                        packetWrapper.set(Types.INT, 0, ((Protocol1_13_2To1_14)EntityPacketRewriter1_14.this.protocol).getMappingData().getNewBlockStateId(n));
                    } else if (entityType2.is(EntityTypes1_14.ITEM) && n > 0 || entityType2.isOrHasParent(EntityTypes1_14.ABSTRACT_ARROW)) {
                        if (entityType2.isOrHasParent(EntityTypes1_14.ABSTRACT_ARROW)) {
                            packetWrapper.set(Types.INT, 0, n - 1);
                        }
                        PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundPackets1_14.SET_ENTITY_MOTION);
                        packetWrapper2.write(Types.VAR_INT, n2);
                        packetWrapper2.write(Types.SHORT, packetWrapper.get(Types.SHORT, 0));
                        packetWrapper2.write(Types.SHORT, packetWrapper.get(Types.SHORT, 1));
                        packetWrapper2.write(Types.SHORT, packetWrapper.get(Types.SHORT, 2));
                        packetWrapper2.scheduleSend(Protocol1_13_2To1_14.class);
                    }
                    packetWrapper.user().getEntityTracker(Protocol1_13_2To1_14.class).addEntity(n2, entityType2);
                    packetWrapper.set(Types.VAR_INT, 1, n3);
                });
            }
        });
        ((Protocol1_13_2To1_14)this.protocol).registerClientbound(ClientboundPackets1_13.ADD_MOB, new PacketHandlers(){

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
                this.map(Types1_13_2.ENTITY_DATA_LIST, Types1_14.ENTITY_DATA_LIST);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 1);
                    if (EntityTypes1_13.EntityType.findById(n) == null) {
                        packetWrapper.cancel();
                        return;
                    }
                    EntityPacketRewriter1_14.this.trackerAndRewriterHandler(Types1_14.ENTITY_DATA_LIST).handle(packetWrapper);
                });
            }
        });
        ((Protocol1_13_2To1_14)this.protocol).registerClientbound(ClientboundPackets1_13.ADD_PAINTING, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.UUID);
                this.map(Types.VAR_INT);
                this.map(Types.BLOCK_POSITION1_8, Types.BLOCK_POSITION1_14);
                this.map(Types.BYTE);
                this.handler(packetWrapper -> EntityPacketRewriter1_14.this.tracker(packetWrapper.user()).addEntity(packetWrapper.get(Types.VAR_INT, 0), EntityTypes1_14.PAINTING));
            }
        });
        ((Protocol1_13_2To1_14)this.protocol).registerClientbound(ClientboundPackets1_13.ADD_PLAYER, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.UUID);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types1_13_2.ENTITY_DATA_LIST, Types1_14.ENTITY_DATA_LIST);
                this.handler(EntityPacketRewriter1_14.this.trackerAndRewriterHandler(Types1_14.ENTITY_DATA_LIST, EntityTypes1_14.PLAYER));
            }
        });
        ((Protocol1_13_2To1_14)this.protocol).registerClientbound(ClientboundPackets1_13.ANIMATE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    short s = packetWrapper.passthrough(Types.UNSIGNED_BYTE);
                    if (s == 2) {
                        EntityTracker1_14 entityTracker1_14 = (EntityTracker1_14)packetWrapper.user().getEntityTracker(Protocol1_13_2To1_14.class);
                        int n = packetWrapper.get(Types.VAR_INT, 0);
                        entityTracker1_14.setSleeping(n, false);
                        PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundPackets1_14.SET_ENTITY_DATA);
                        packetWrapper2.write(Types.VAR_INT, n);
                        ArrayList<EntityData> arrayList = new ArrayList<EntityData>();
                        if (entityTracker1_14.clientEntityId() != n) {
                            arrayList.add(new EntityData(6, Types1_14.ENTITY_DATA_TYPES.poseType, EntityPacketRewriter1_14.recalculatePlayerPose(n, entityTracker1_14)));
                        }
                        arrayList.add(new EntityData(12, Types1_14.ENTITY_DATA_TYPES.optionalBlockPositionType, null));
                        packetWrapper2.write(Types1_14.ENTITY_DATA_LIST, arrayList);
                        packetWrapper2.scheduleSend(Protocol1_13_2To1_14.class);
                    }
                });
            }
        });
        ((Protocol1_13_2To1_14)this.protocol).registerClientbound(ClientboundPackets1_13.LOGIN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    Object t = packetWrapper.user().getClientWorld(Protocol1_13_2To1_14.class);
                    int n = packetWrapper.get(Types.INT, 1);
                    ((ClientWorld)t).setEnvironment(n);
                });
                this.handler(EntityPacketRewriter1_14.this.playerTrackerHandler());
                this.handler(packetWrapper -> {
                    short s = packetWrapper.read(Types.UNSIGNED_BYTE);
                    PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundPackets1_14.CHANGE_DIFFICULTY);
                    packetWrapper2.write(Types.UNSIGNED_BYTE, s);
                    packetWrapper2.write(Types.BOOLEAN, false);
                    packetWrapper2.scheduleSend(((Protocol1_13_2To1_14)EntityPacketRewriter1_14.this.protocol).getClass());
                    packetWrapper.passthrough(Types.UNSIGNED_BYTE);
                    packetWrapper.passthrough(Types.STRING);
                    packetWrapper.write(Types.VAR_INT, 64);
                });
                this.handler(packetWrapper -> {
                    packetWrapper.send(Protocol1_13_2To1_14.class);
                    packetWrapper.cancel();
                    WorldPacketRewriter1_14.sendViewDistancePacket(packetWrapper.user());
                });
            }
        });
        ((Protocol1_13_2To1_14)this.protocol).registerClientbound(ClientboundPackets1_13.PLAYER_SLEEP, ClientboundPackets1_14.SET_ENTITY_DATA, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    EntityTracker1_14 entityTracker1_14 = (EntityTracker1_14)packetWrapper.user().getEntityTracker(Protocol1_13_2To1_14.class);
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    entityTracker1_14.setSleeping(n, true);
                    BlockPosition blockPosition = packetWrapper.read(Types.BLOCK_POSITION1_8);
                    ArrayList<EntityData> arrayList = new ArrayList<EntityData>();
                    arrayList.add(new EntityData(12, Types1_14.ENTITY_DATA_TYPES.optionalBlockPositionType, blockPosition));
                    if (entityTracker1_14.clientEntityId() != n) {
                        arrayList.add(new EntityData(6, Types1_14.ENTITY_DATA_TYPES.poseType, EntityPacketRewriter1_14.recalculatePlayerPose(n, entityTracker1_14)));
                    }
                    packetWrapper.write(Types1_14.ENTITY_DATA_LIST, arrayList);
                });
            }
        });
        this.registerSetEntityData(ClientboundPackets1_13.SET_ENTITY_DATA, Types1_13_2.ENTITY_DATA_LIST, Types1_14.ENTITY_DATA_LIST);
    }

    @Override
    protected void registerRewrites() {
        this.filter().mapDataType(Types1_14.ENTITY_DATA_TYPES::byId);
        this.registerEntityDataTypeHandler(Types1_14.ENTITY_DATA_TYPES.itemType, Types1_14.ENTITY_DATA_TYPES.optionalBlockStateType, Types1_14.ENTITY_DATA_TYPES.particleType);
        this.filter().type(EntityTypes1_14.ENTITY).addIndex(6);
        this.registerBlockStateHandler(EntityTypes1_14.ABSTRACT_MINECART, 10);
        this.filter().type(EntityTypes1_14.LIVING_ENTITY).addIndex(12);
        this.filter().type(EntityTypes1_14.LIVING_ENTITY).index(8).handler((entityDataHandlerEvent, entityData) -> {
            float f = ((Number)entityData.getValue()).floatValue();
            if (Float.isNaN(f) && Via.getConfig().is1_14HealthNaNFix()) {
                entityData.setValue(Float.valueOf(1.0f));
            }
        });
        this.filter().type(EntityTypes1_14.MOB).index(13).handler((entityDataHandlerEvent, entityData) -> {
            EntityTracker1_14 entityTracker1_14 = (EntityTracker1_14)this.tracker(entityDataHandlerEvent.user());
            int n = entityDataHandlerEvent.entityId();
            entityTracker1_14.setInsentientData(n, (byte)(((Number)entityData.getValue()).byteValue() & 0xFFFFFFFB | entityTracker1_14.getInsentientData(n) & 4));
            entityData.setValue(entityTracker1_14.getInsentientData(n));
        });
        this.filter().type(EntityTypes1_14.PLAYER).handler((entityDataHandlerEvent, entityData) -> {
            EntityTracker1_14 entityTracker1_14 = (EntityTracker1_14)this.tracker(entityDataHandlerEvent.user());
            int n = entityDataHandlerEvent.entityId();
            if (n != entityTracker1_14.clientEntityId()) {
                if (entityData.id() == 0) {
                    byte by = ((Number)entityData.getValue()).byteValue();
                    entityTracker1_14.setEntityFlags(n, by);
                } else if (entityData.id() == 7) {
                    entityTracker1_14.setRiptide(n, (((Number)entityData.getValue()).byteValue() & 4) != 0);
                }
                if (entityData.id() == 0 || entityData.id() == 7) {
                    entityDataHandlerEvent.createExtraData(new EntityData(6, Types1_14.ENTITY_DATA_TYPES.poseType, EntityPacketRewriter1_14.recalculatePlayerPose(n, entityTracker1_14)));
                }
            }
        });
        this.filter().type(EntityTypes1_14.ZOMBIE).handler((entityDataHandlerEvent, entityData) -> {
            if (entityData.id() == 16) {
                EntityTracker1_14 entityTracker1_14 = (EntityTracker1_14)this.tracker(entityDataHandlerEvent.user());
                int n = entityDataHandlerEvent.entityId();
                entityTracker1_14.setInsentientData(n, (byte)(entityTracker1_14.getInsentientData(n) & 0xFFFFFFFB | ((Boolean)entityData.getValue() != false ? 4 : 0)));
                entityDataHandlerEvent.createExtraData(new EntityData(13, Types1_14.ENTITY_DATA_TYPES.byteType, entityTracker1_14.getInsentientData(n)));
                entityDataHandlerEvent.cancel();
            } else if (entityData.id() > 16) {
                entityData.setId(entityData.id() - 1);
            }
        });
        this.filter().type(EntityTypes1_14.HORSE).index(18).handler((entityDataHandlerEvent, entityData) -> {
            entityDataHandlerEvent.cancel();
            int n = (Integer)entityData.value();
            DataItem dataItem = null;
            if (n == 1) {
                dataItem = new DataItem(((Protocol1_13_2To1_14)this.protocol).getMappingData().getNewItemId(727), 1, null);
            } else if (n == 2) {
                dataItem = new DataItem(((Protocol1_13_2To1_14)this.protocol).getMappingData().getNewItemId(728), 1, null);
            } else if (n == 3) {
                dataItem = new DataItem(((Protocol1_13_2To1_14)this.protocol).getMappingData().getNewItemId(729), 1, null);
            }
            PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_14.SET_EQUIPPED_ITEM, null, entityDataHandlerEvent.user());
            packetWrapper.write(Types.VAR_INT, entityDataHandlerEvent.entityId());
            packetWrapper.write(Types.VAR_INT, 4);
            packetWrapper.write(Types.ITEM1_13_2, dataItem);
            try {
                packetWrapper.scheduleSend(Protocol1_13_2To1_14.class);
            }
            catch (Exception exception) {
                throw new RuntimeException(exception);
            }
        });
        this.filter().type(EntityTypes1_14.VILLAGER).index(15).handler((entityDataHandlerEvent, entityData) -> entityData.setTypeAndValue(Types1_14.ENTITY_DATA_TYPES.villagerDataType, new VillagerData(2, EntityPacketRewriter1_14.getNewProfessionId((Integer)entityData.value()), 0)));
        this.filter().type(EntityTypes1_14.ZOMBIE_VILLAGER).index(18).handler((entityDataHandlerEvent, entityData) -> entityData.setTypeAndValue(Types1_14.ENTITY_DATA_TYPES.villagerDataType, new VillagerData(2, EntityPacketRewriter1_14.getNewProfessionId((Integer)entityData.value()), 0)));
        this.filter().type(EntityTypes1_14.ABSTRACT_ARROW).addIndex(9);
        this.filter().type(EntityTypes1_14.FIREWORK_ROCKET).index(8).handler((entityDataHandlerEvent, entityData) -> {
            entityData.setDataType(Types1_14.ENTITY_DATA_TYPES.optionalVarIntType);
            if (entityData.getValue().equals(0)) {
                entityData.setValue(null);
            }
        });
        this.filter().type(EntityTypes1_14.ABSTRACT_SKELETON).index(14).handler((entityDataHandlerEvent, entityData) -> {
            EntityTracker1_14 entityTracker1_14 = (EntityTracker1_14)this.tracker(entityDataHandlerEvent.user());
            int n = entityDataHandlerEvent.entityId();
            entityTracker1_14.setInsentientData(n, (byte)(entityTracker1_14.getInsentientData(n) & 0xFFFFFFFB | ((Boolean)entityData.getValue() != false ? 4 : 0)));
            entityDataHandlerEvent.createExtraData(new EntityData(13, Types1_14.ENTITY_DATA_TYPES.byteType, entityTracker1_14.getInsentientData(n)));
            entityDataHandlerEvent.cancel();
        });
        this.filter().type(EntityTypes1_14.ABSTRACT_ILLAGER).handler((entityDataHandlerEvent, entityData) -> {
            if (entityDataHandlerEvent.index() == 14) {
                EntityTracker1_14 entityTracker1_14 = (EntityTracker1_14)this.tracker(entityDataHandlerEvent.user());
                int n = entityDataHandlerEvent.entityId();
                entityTracker1_14.setInsentientData(n, (byte)(entityTracker1_14.getInsentientData(n) & 0xFFFFFFFB | (((Number)entityData.getValue()).byteValue() != 0 ? 4 : 0)));
                entityDataHandlerEvent.createExtraData(new EntityData(13, Types1_14.ENTITY_DATA_TYPES.byteType, entityTracker1_14.getInsentientData(n)));
                entityDataHandlerEvent.cancel();
            } else if (entityDataHandlerEvent.index() > 14) {
                entityData.setId(entityData.id() - 1);
            }
        });
        this.filter().type(EntityTypes1_14.OCELOT).removeIndex(17);
        this.filter().type(EntityTypes1_14.OCELOT).removeIndex(16);
        this.filter().type(EntityTypes1_14.OCELOT).removeIndex(15);
        this.filter().type(EntityTypes1_14.ABSTRACT_RAIDER).addIndex(14);
    }

    @Override
    public void onMappingDataLoaded() {
        super.onMappingDataLoaded();
        if (Via.getConfig().translateOcelotToCat()) {
            this.mapEntityType(EntityTypes1_13.EntityType.OCELOT, EntityTypes1_14.CAT);
        }
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_14.getTypeFromId(n);
    }

    private static boolean isSneaking(byte by) {
        return (by & 2) != 0;
    }

    private static boolean isSwimming(byte by) {
        return (by & 0x10) != 0;
    }

    private static int getNewProfessionId(int n) {
        return switch (n) {
            case 0 -> 5;
            case 1 -> 9;
            case 2 -> 4;
            case 3 -> 1;
            case 4 -> 2;
            case 5 -> 11;
            default -> 0;
        };
    }

    private static boolean isFallFlying(int n) {
        return (n & 0x80) != 0;
    }

    public static int recalculatePlayerPose(int n, EntityTracker1_14 entityTracker1_14) {
        byte by = entityTracker1_14.getEntityFlags(n);
        int n2 = 0;
        if (EntityPacketRewriter1_14.isFallFlying(by)) {
            n2 = 1;
        } else if (entityTracker1_14.isSleeping(n)) {
            n2 = 2;
        } else if (EntityPacketRewriter1_14.isSwimming(by)) {
            n2 = 3;
        } else if (entityTracker1_14.isRiptide(n)) {
            n2 = 4;
        } else if (EntityPacketRewriter1_14.isSneaking(by)) {
            n2 = 5;
        }
        return n2;
    }
}


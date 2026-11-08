/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_5to1_21_4.rewriter;

import com.viaversion.viabackwards.api.rewriters.EntityRewriter;
import com.viaversion.viabackwards.protocol.v1_21_5to1_21_4.Protocol1_21_5To1_21_4;
import com.viaversion.viabackwards.protocol.v1_21_5to1_21_4.storage.HorseDataStorage;
import com.viaversion.viaversion.api.data.entity.TrackedEntity;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_5;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_2;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_5;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_20_5;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ClientboundPacket1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ClientboundPackets1_21_5;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPackets1_21_2;
import java.util.UUID;

public class EntityPacketRewriter1_21_5
extends EntityRewriter<ClientboundPacket1_21_5, Protocol1_21_5To1_21_4> {
    public EntityPacketRewriter1_21_5(Protocol1_21_5To1_21_4 protocol1_21_5To1_21_4) {
        super(protocol1_21_5To1_21_4, ((EntityDataTypes1_21_2)((Types1_20_5)protocol1_21_5To1_21_4.mappedTypes()).entityDataTypes()).optionalComponentType, ((EntityDataTypes1_21_2)((Types1_20_5)protocol1_21_5To1_21_4.mappedTypes()).entityDataTypes()).booleanType);
    }

    @Override
    public void registerPackets() {
        ((Protocol1_21_5To1_21_4)this.protocol).replaceClientbound(ClientboundPackets1_21_5.ADD_ENTITY, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            UUID uUID = packetWrapper.read(Types.UUID);
            int n2 = packetWrapper.read(Types.VAR_INT);
            if (n2 != EntityTypes1_21_5.EXPERIENCE_ORB.getId()) {
                packetWrapper.write(Types.UUID, uUID);
                packetWrapper.write(Types.VAR_INT, n2);
                packetWrapper.passthrough(Types.DOUBLE);
                packetWrapper.passthrough(Types.DOUBLE);
                packetWrapper.passthrough(Types.DOUBLE);
                packetWrapper.passthrough(Types.BYTE);
                packetWrapper.passthrough(Types.BYTE);
                packetWrapper.passthrough(Types.BYTE);
                int n3 = packetWrapper.passthrough(Types.VAR_INT);
                this.trackSpawnWithData1_19(packetWrapper, n3);
                return;
            }
            this.tracker(packetWrapper.user()).addEntity(n, EntityTypes1_21_5.EXPERIENCE_ORB);
            packetWrapper.setPacketType(ClientboundPackets1_21_2.ADD_EXPERIENCE_ORB);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.read(Types.BYTE);
            packetWrapper.read(Types.BYTE);
            packetWrapper.read(Types.BYTE);
            int n4 = packetWrapper.read(Types.VAR_INT);
            packetWrapper.write(Types.SHORT, (short)n4);
            short s = packetWrapper.read(Types.SHORT);
            short s2 = packetWrapper.read(Types.SHORT);
            short s3 = packetWrapper.read(Types.SHORT);
            if (s != 0 || s2 != 0 || s3 != 0) {
                PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundPackets1_21_2.SET_ENTITY_MOTION);
                packetWrapper2.write(Types.VAR_INT, n);
                packetWrapper2.write(Types.SHORT, s);
                packetWrapper2.write(Types.SHORT, s2);
                packetWrapper2.write(Types.SHORT, s3);
                packetWrapper.send(Protocol1_21_5To1_21_4.class);
                packetWrapper2.send(Protocol1_21_5To1_21_4.class);
                packetWrapper.cancel();
            }
        });
        ((Protocol1_21_5To1_21_4)this.protocol).replaceClientbound(ClientboundPackets1_21_5.SET_PLAYER_TEAM, packetWrapper -> {
            packetWrapper.passthrough(Types.STRING);
            byte by = packetWrapper.passthrough(Types.BYTE);
            if (by == 0 || by == 2) {
                ((Protocol1_21_5To1_21_4)this.protocol).getComponentRewriter().passthroughAndProcess(packetWrapper);
                packetWrapper.passthrough(Types.BYTE);
                int n = packetWrapper.read(Types.VAR_INT);
                int n2 = packetWrapper.read(Types.VAR_INT);
                packetWrapper.write(Types.STRING, this.visibility(n));
                packetWrapper.write(Types.STRING, this.collision(n2));
                packetWrapper.passthrough(Types.VAR_INT);
                ((Protocol1_21_5To1_21_4)this.protocol).getComponentRewriter().passthroughAndProcess(packetWrapper);
                ((Protocol1_21_5To1_21_4)this.protocol).getComponentRewriter().passthroughAndProcess(packetWrapper);
            }
        });
    }

    private String visibility(int n) {
        return switch (n) {
            case 0 -> "always";
            case 1 -> "never";
            case 2 -> "hideForOtherTeams";
            case 3 -> "hideForOwnTeam";
            default -> "always";
        };
    }

    private String collision(int n) {
        return switch (n) {
            case 0 -> "always";
            case 1 -> "never";
            case 2 -> "pushOtherTeams";
            case 3 -> "pushOwnTeam";
            default -> "always";
        };
    }

    @Override
    protected void registerRewrites() {
        EntityDataTypes1_21_5 entityDataTypes1_21_5 = (EntityDataTypes1_21_5)VersionedTypes.V1_21_5.entityDataTypes;
        EntityDataTypes1_21_2 entityDataTypes1_21_2 = (EntityDataTypes1_21_2)VersionedTypes.V1_21_4.entityDataTypes;
        this.dataTypeMapper().removed(entityDataTypes1_21_5.cowVariantType).removed(entityDataTypes1_21_5.wolfSoundVariantType).removed(entityDataTypes1_21_5.pigVariantType).removed(entityDataTypes1_21_5.chickenVariantType).skip(entityDataTypes1_21_5.wolfVariantType).register();
        this.filter().dataType(entityDataTypes1_21_5.wolfVariantType).handler((entityDataHandlerEvent, entityData) -> {
            int n = (Integer)entityData.value();
            Holder<int> holder = Holder.of(n);
            entityData.setTypeAndValue(entityDataTypes1_21_2.wolfVariantType, holder);
        });
        this.registerEntityDataTypeHandler1_20_3(entityDataTypes1_21_2.itemType, entityDataTypes1_21_2.blockStateType, entityDataTypes1_21_2.optionalBlockStateType, entityDataTypes1_21_2.particleType, entityDataTypes1_21_2.particlesType, entityDataTypes1_21_2.componentType, entityDataTypes1_21_2.optionalComponentType);
        this.filter().dataType(entityDataTypes1_21_2.frogVariantType).handler((entityDataHandlerEvent, entityData) -> {
            int n;
            int n2 = (Integer)entityData.value();
            String string = this.tracker(entityDataHandlerEvent.user()).registryKeys("frog_variant").idToKey(n2);
            if (string == null) {
                n = 0;
            } else {
                switch (string) {
                    case "cold": {
                        n = 2;
                        break;
                    }
                    case "temperate": {
                        n = 0;
                        break;
                    }
                    case "warm": {
                        n = 1;
                        break;
                    }
                    default: {
                        n = 0;
                    }
                }
            }
            int n3 = n;
            entityData.setValue(n3);
        });
        this.filter().dataType(entityDataTypes1_21_2.catVariantType).handler((entityDataHandlerEvent, entityData) -> {
            int n;
            int n2 = (Integer)entityData.value();
            String string = this.tracker(entityDataHandlerEvent.user()).registryKeys("cat_variant").idToKey(n2);
            if (string == null) {
                n = 1;
            } else {
                switch (string) {
                    case "all_black": {
                        n = 10;
                        break;
                    }
                    case "black": {
                        n = 1;
                        break;
                    }
                    case "british_shorthair": {
                        n = 4;
                        break;
                    }
                    case "calico": {
                        n = 5;
                        break;
                    }
                    case "jellie": {
                        n = 9;
                        break;
                    }
                    case "persian": {
                        n = 6;
                        break;
                    }
                    case "ragdoll": {
                        n = 7;
                        break;
                    }
                    case "red": {
                        n = 2;
                        break;
                    }
                    case "siamese": {
                        n = 3;
                        break;
                    }
                    case "tabby": {
                        n = 0;
                        break;
                    }
                    case "white": {
                        n = 8;
                        break;
                    }
                    default: {
                        n = 1;
                    }
                }
            }
            int n3 = n;
            entityData.setValue(n3);
        });
        this.filter().type(EntityTypes1_21_5.ABSTRACT_MINECART).addIndex(13);
        this.filter().type(EntityTypes1_21_5.ABSTRACT_MINECART).index(11).handler((entityDataHandlerEvent, entityData) -> {
            int n = (Integer)entityData.getValue();
            if (n == 0) {
                entityDataHandlerEvent.cancel();
                return;
            }
            int n2 = ((Protocol1_21_5To1_21_4)this.protocol).getMappingData().getNewBlockStateId(n);
            entityData.setTypeAndValue(entityDataTypes1_21_5.varIntType, n2);
            entityDataHandlerEvent.createExtraData(new EntityData(13, entityDataTypes1_21_2.booleanType, true));
        });
        this.filter().type(EntityTypes1_21_5.MOOSHROOM).index(17).handler((entityDataHandlerEvent, entityData) -> {
            int n = (Integer)entityData.value();
            String string = n == 0 ? "red" : "brown";
            entityData.setTypeAndValue(entityDataTypes1_21_5.stringType, string);
        });
        this.filter().type(EntityTypes1_21_5.ABSTRACT_HORSE).index(17).handler((entityDataHandlerEvent, entityData) -> {
            TrackedEntity trackedEntity = entityDataHandlerEvent.trackedEntity();
            byte by = (Byte)entityData.value();
            boolean bl = false;
            HorseDataStorage horseDataStorage = trackedEntity.get(HorseDataStorage.class);
            if (horseDataStorage != null && horseDataStorage.saddled()) {
                bl = true;
                entityData.setValue((byte)(by | 4));
            }
            trackedEntity.put(new HorseDataStorage(by, bl));
        });
        this.filter().type(EntityTypes1_21_5.CHICKEN).cancel(17);
        this.filter().type(EntityTypes1_21_5.COW).cancel(17);
        this.filter().type(EntityTypes1_21_5.PIG).cancel(18);
        this.filter().type(EntityTypes1_21_5.WOLF).cancel(23);
        this.filter().type(EntityTypes1_21_5.EXPERIENCE_ORB).cancel(8);
        this.filter().type(EntityTypes1_21_5.DOLPHIN).addIndex(17);
        this.filter().type(EntityTypes1_21_5.TURTLE).addIndex(17);
        this.filter().type(EntityTypes1_21_5.PIG).addIndex(17);
        this.filter().type(EntityTypes1_21_5.STRIDER).addIndex(19);
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_21_5.getTypeFromId(n);
    }
}


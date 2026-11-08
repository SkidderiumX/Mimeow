/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21_7to1_21_9.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.data.entity.TrackedEntity;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.GlobalBlockPosition;
import com.viaversion.viaversion.api.minecraft.Vector3d;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_9;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_5;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_9;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_20_5;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ClientboundPacket1_21_6;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ClientboundPackets1_21_6;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.Protocol1_21_7To1_21_9;
import com.viaversion.viaversion.rewriter.EntityRewriter;
import com.viaversion.viaversion.rewriter.entitydata.EntityDataHandler;
import com.viaversion.viaversion.util.Key;

public class EntityPacketRewriter1_21_9
extends EntityRewriter<ClientboundPacket1_21_6, Protocol1_21_7To1_21_9> {
    public EntityPacketRewriter1_21_9(Protocol1_21_7To1_21_9 protocol1_21_7To1_21_9) {
        super(protocol1_21_7To1_21_9);
    }

    @Override
    public void registerPackets() {
        ((Protocol1_21_7To1_21_9)this.protocol).replaceClientbound(ClientboundPackets1_21_6.ADD_ENTITY, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.UUID);
            int n2 = packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.write(Types.LOW_PRECISION_VECTOR, Vector3d.ZERO);
            packetWrapper.passthrough(Types.BYTE);
            packetWrapper.passthrough(Types.BYTE);
            packetWrapper.passthrough(Types.BYTE);
            int n3 = packetWrapper.passthrough(Types.VAR_INT);
            TrackedEntity trackedEntity = this.trackAndRewrite(packetWrapper, n2, n);
            if (((Protocol1_21_7To1_21_9)this.protocol).getMappingData() != null && trackedEntity.entityType() == EntityTypes1_21_9.FALLING_BLOCK) {
                int n4 = ((Protocol1_21_7To1_21_9)this.protocol).getMappingData().getNewBlockStateId(n3);
                packetWrapper.set(Types.VAR_INT, 2, n4);
            }
            packetWrapper.set(Types.LOW_PRECISION_VECTOR, 0, this.readRelativeMovement(packetWrapper));
        });
        ((Protocol1_21_7To1_21_9)this.protocol).registerClientbound(ClientboundPackets1_21_6.SET_ENTITY_MOTION, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.write(Types.LOW_PRECISION_VECTOR, this.readRelativeMovement(packetWrapper));
        });
        ((Protocol1_21_7To1_21_9)this.protocol).registerClientbound(ClientboundPackets1_21_6.PLAYER_ROTATION, packetWrapper -> {
            packetWrapper.passthrough(Types.FLOAT);
            packetWrapper.write(Types.BOOLEAN, false);
            packetWrapper.passthrough(Types.FLOAT);
            packetWrapper.write(Types.BOOLEAN, false);
        });
        ((Protocol1_21_7To1_21_9)this.protocol).registerClientbound(ClientboundPackets1_21_6.SET_DEFAULT_SPAWN_POSITION, packetWrapper -> {
            BlockPosition blockPosition = packetWrapper.read(Types.BLOCK_POSITION1_14);
            String string = this.tracker(packetWrapper.user()).currentWorld();
            packetWrapper.write(Types.GLOBAL_POSITION, new GlobalBlockPosition(string, blockPosition.x(), blockPosition.y(), blockPosition.z()));
            packetWrapper.passthrough(Types.FLOAT);
            packetWrapper.write(Types.FLOAT, Float.valueOf(0.0f));
        });
        ((Protocol1_21_7To1_21_9)this.protocol).getRegistryDataRewriter().addHandler("dimension_type", (string, compoundTag) -> {
            if (Key.equals(string, "minecraft:the_end")) {
                compoundTag.putFloat("ambient_light", 0.25f);
            }
        });
    }

    private Vector3d readRelativeMovement(PacketWrapper packetWrapper) {
        double d = (double)packetWrapper.read(Types.SHORT).shortValue() / 8000.0;
        double d2 = (double)packetWrapper.read(Types.SHORT).shortValue() / 8000.0;
        double d3 = (double)packetWrapper.read(Types.SHORT).shortValue() / 8000.0;
        return new Vector3d(d, d2, d3);
    }

    @Override
    protected void registerRewrites() {
        EntityDataTypes1_21_5 entityDataTypes1_21_5 = (EntityDataTypes1_21_5)((Types1_20_5)((Protocol1_21_7To1_21_9)this.protocol).types()).entityDataTypes();
        EntityDataTypes1_21_9 entityDataTypes1_21_9 = (EntityDataTypes1_21_9)((Types1_20_5)((Protocol1_21_7To1_21_9)this.protocol).mappedTypes()).entityDataTypes();
        this.dataTypeMapper().added(entityDataTypes1_21_9.copperGolemState).added(entityDataTypes1_21_9.weatheringCopperState).removed(entityDataTypes1_21_5.compoundTagType).register();
        this.registerEntityDataTypeHandler(entityDataTypes1_21_9.itemType, entityDataTypes1_21_9.blockStateType, entityDataTypes1_21_9.optionalBlockStateType, entityDataTypes1_21_9.particleType, entityDataTypes1_21_9.particlesType, entityDataTypes1_21_9.componentType, entityDataTypes1_21_9.optionalComponentType);
        EntityDataHandler entityDataHandler = (entityDataHandlerEvent, entityData) -> {
            CompoundTag compoundTag = (CompoundTag)entityData.value();
            if (compoundTag == null) {
                entityData.setTypeAndValue(((EntityDataTypes1_21_9)((Types1_20_5)((Protocol1_21_7To1_21_9)this.protocol).mappedTypes()).entityDataTypes).optionalVarIntType, null);
                return;
            }
            int n = compoundTag.getInt("Variant", -1);
            if (n != -1) {
                entityData.setTypeAndValue(((EntityDataTypes1_21_9)((Types1_20_5)((Protocol1_21_7To1_21_9)this.protocol).mappedTypes()).entityDataTypes).optionalVarIntType, n);
            } else {
                entityData.setTypeAndValue(((EntityDataTypes1_21_9)((Types1_20_5)((Protocol1_21_7To1_21_9)this.protocol).mappedTypes()).entityDataTypes).optionalVarIntType, null);
            }
        };
        this.filter().type(EntityTypes1_21_9.PLAYER).index(19).handler(entityDataHandler);
        this.filter().type(EntityTypes1_21_9.PLAYER).index(20).handler(entityDataHandler);
        this.filter().type(EntityTypes1_21_9.PLAYER).handler((entityDataHandlerEvent, entityData) -> {
            if (entityDataHandlerEvent.index() == 17) {
                entityDataHandlerEvent.setIndex(16);
            } else if (entityDataHandlerEvent.index() == 18) {
                entityDataHandlerEvent.setIndex(15);
            } else if (entityDataHandlerEvent.index() == 15 || entityDataHandlerEvent.index() == 16) {
                entityDataHandlerEvent.setIndex(entityDataHandlerEvent.index() + 2);
            }
        });
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_21_9.getTypeFromId(n);
    }
}


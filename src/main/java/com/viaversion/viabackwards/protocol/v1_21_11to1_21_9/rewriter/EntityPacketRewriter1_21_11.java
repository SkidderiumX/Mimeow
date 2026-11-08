/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_11to1_21_9.rewriter;

import com.viaversion.viabackwards.api.rewriters.EntityRewriter;
import com.viaversion.viabackwards.protocol.v1_21_11to1_21_9.Protocol1_21_11To1_21_9;
import com.viaversion.viabackwards.protocol.v1_21_11to1_21_9.storage.GameTimeStorage;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_11;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_11;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_9;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.packet.ClientboundPackets1_21_9;
import com.viaversion.viaversion.protocols.v1_21_9to1_21_11.packet.ClientboundPacket1_21_11;
import com.viaversion.viaversion.protocols.v1_21_9to1_21_11.packet.ClientboundPackets1_21_11;
import com.viaversion.viaversion.rewriter.entitydata.EntityDataHandlerEvent;
import com.viaversion.viaversion.util.MathUtil;

public class EntityPacketRewriter1_21_11
extends EntityRewriter<ClientboundPacket1_21_11, Protocol1_21_11To1_21_9> {
    public EntityPacketRewriter1_21_11(Protocol1_21_11To1_21_9 protocol1_21_11To1_21_9) {
        super(protocol1_21_11To1_21_9, ((EntityDataTypes1_21_9)VersionedTypes.V1_21_9.entityDataTypes).optionalComponentType, ((EntityDataTypes1_21_9)VersionedTypes.V1_21_9.entityDataTypes).booleanType);
    }

    @Override
    public void registerPackets() {
        ((Protocol1_21_11To1_21_9)this.protocol).registerClientbound(ClientboundPackets1_21_11.MOUNT_SCREEN_OPEN, ClientboundPackets1_21_9.HORSE_SCREEN_OPEN);
        ((Protocol1_21_11To1_21_9)this.protocol).registerClientbound(ClientboundPackets1_21_11.UPDATE_MOB_EFFECT, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            int n = packetWrapper.passthrough(Types.VAR_INT);
            if (n == 39) {
                packetWrapper.cancel();
            }
        });
        ((Protocol1_21_11To1_21_9)this.protocol).registerClientbound(ClientboundPackets1_21_11.REMOVE_MOB_EFFECT, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            int n = packetWrapper.passthrough(Types.VAR_INT);
            if (n == 39) {
                packetWrapper.cancel();
            }
        });
    }

    @Override
    protected void registerRewrites() {
        EntityDataTypes1_21_11 entityDataTypes1_21_11 = (EntityDataTypes1_21_11)VersionedTypes.V1_21_11.entityDataTypes;
        EntityDataTypes1_21_9 entityDataTypes1_21_9 = (EntityDataTypes1_21_9)VersionedTypes.V1_21_9.entityDataTypes;
        this.dataTypeMapper().removed(entityDataTypes1_21_11.zombieNautilusVariantType).skip(entityDataTypes1_21_11.humanoidArmType).register();
        this.filter().dataType(entityDataTypes1_21_11.humanoidArmType).handler((entityDataHandlerEvent, entityData) -> {
            int n = (Integer)entityData.value();
            entityData.setTypeAndValue(entityDataTypes1_21_9.byteType, (byte)n);
        });
        this.registerEntityDataTypeHandler1_20_3(entityDataTypes1_21_9.itemType, entityDataTypes1_21_9.blockStateType, entityDataTypes1_21_9.optionalBlockStateType, entityDataTypes1_21_9.particleType, entityDataTypes1_21_9.particlesType, entityDataTypes1_21_9.componentType, entityDataTypes1_21_9.optionalComponentType);
        this.filter().type(EntityTypes1_21_11.WOLF).index(21).handler(this::absoluteToRelativeTicks);
        this.filter().type(EntityTypes1_21_11.BEE).index(18).handler(this::absoluteToRelativeTicks);
        this.filter().type(EntityTypes1_21_11.ABSTRACT_NAUTILUS).cancel(17);
        this.filter().type(EntityTypes1_21_11.ABSTRACT_NAUTILUS).cancel(18);
        this.filter().type(EntityTypes1_21_11.ABSTRACT_NAUTILUS).cancel(19);
        this.filter().type(EntityTypes1_21_11.ZOMBIE_NAUTILUS).cancel(20);
    }

    private void absoluteToRelativeTicks(EntityDataHandlerEvent entityDataHandlerEvent, EntityData entityData) {
        long l = entityDataHandlerEvent.user().get(GameTimeStorage.class).gameTime();
        long l2 = (Long)entityData.value();
        int n = (int)MathUtil.clamp(l2 - l, Integer.MIN_VALUE, Integer.MAX_VALUE);
        entityData.setTypeAndValue(((EntityDataTypes1_21_9)VersionedTypes.V1_21_9.entityDataTypes).varIntType, Math.max(n, 0));
    }

    @Override
    public void onMappingDataLoaded() {
        super.onMappingDataLoaded();
        this.mapEntityTypeWithData(EntityTypes1_21_11.NAUTILUS, EntityTypes1_21_11.SQUID).tagName();
        this.mapEntityTypeWithData(EntityTypes1_21_11.ZOMBIE_NAUTILUS, EntityTypes1_21_11.GLOW_SQUID).tagName();
        this.mapEntityTypeWithData(EntityTypes1_21_11.CAMEL_HUSK, EntityTypes1_21_11.CAMEL).tagName();
        this.mapEntityTypeWithData(EntityTypes1_21_11.PARCHED, EntityTypes1_21_11.SKELETON).tagName();
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_21_11.getTypeFromId(n);
    }
}


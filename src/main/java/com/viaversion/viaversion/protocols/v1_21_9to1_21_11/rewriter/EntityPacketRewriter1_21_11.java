/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21_9to1_21_11.rewriter;

import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_11;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_11;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_20_5;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ServerboundPackets1_21_6;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.packet.ClientboundPacket1_21_9;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.packet.ClientboundPackets1_21_9;
import com.viaversion.viaversion.protocols.v1_21_9to1_21_11.Protocol1_21_9To1_21_11;
import com.viaversion.viaversion.protocols.v1_21_9to1_21_11.packet.ClientboundPackets1_21_11;
import com.viaversion.viaversion.protocols.v1_21_9to1_21_11.storage.GameTimeStorage;
import com.viaversion.viaversion.rewriter.EntityRewriter;
import com.viaversion.viaversion.rewriter.entitydata.EntityDataHandlerEvent;

public class EntityPacketRewriter1_21_11
extends EntityRewriter<ClientboundPacket1_21_9, Protocol1_21_9To1_21_11> {
    public EntityPacketRewriter1_21_11(Protocol1_21_9To1_21_11 protocol1_21_9To1_21_11) {
        super(protocol1_21_9To1_21_11);
    }

    @Override
    public void registerPackets() {
        ((Protocol1_21_9To1_21_11)this.protocol).registerServerbound(ServerboundPackets1_21_6.PLAYER_ACTION, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            if (n == 7) {
                packetWrapper.cancel();
            }
        });
        ((Protocol1_21_9To1_21_11)this.protocol).registerClientbound(ClientboundPackets1_21_9.HORSE_SCREEN_OPEN, ClientboundPackets1_21_11.MOUNT_SCREEN_OPEN);
    }

    @Override
    protected void registerRewrites() {
        EntityDataTypes1_21_11 entityDataTypes1_21_11 = (EntityDataTypes1_21_11)((Types1_20_5)((Protocol1_21_9To1_21_11)this.protocol).mappedTypes()).entityDataTypes();
        this.dataTypeMapper().added(entityDataTypes1_21_11.zombieNautilusVariantType).register();
        this.registerEntityDataTypeHandler(entityDataTypes1_21_11.itemType, entityDataTypes1_21_11.blockStateType, entityDataTypes1_21_11.optionalBlockStateType, entityDataTypes1_21_11.particleType, entityDataTypes1_21_11.particlesType, entityDataTypes1_21_11.componentType, entityDataTypes1_21_11.optionalComponentType);
        this.filter().type(EntityTypes1_21_11.WOLF).index(21).handler(this::relativeToAbsoluteTicks);
        this.filter().type(EntityTypes1_21_11.BEE).index(18).handler(this::relativeToAbsoluteTicks);
        this.filter().type(EntityTypes1_21_11.AVATAR).index(15).handler((entityDataHandlerEvent, entityData) -> {
            byte by = (Byte)entityData.value();
            entityData.setTypeAndValue(entityDataTypes1_21_11.humanoidArmType, by);
        });
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_21_11.getTypeFromId(n);
    }

    private void relativeToAbsoluteTicks(EntityDataHandlerEvent entityDataHandlerEvent, EntityData entityData) {
        long l = entityDataHandlerEvent.user().get(GameTimeStorage.class).gameTime();
        int n = (Integer)entityData.value();
        entityData.setTypeAndValue(((EntityDataTypes1_21_11)((Types1_20_5)((Protocol1_21_9To1_21_11)this.protocol).mappedTypes()).entityDataTypes()).longType, l + (long)n);
    }
}


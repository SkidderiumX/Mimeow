/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_7to1_21_6.rewriter;

import com.viaversion.viabackwards.api.rewriters.EntityRewriter;
import com.viaversion.viabackwards.protocol.v1_21_7to1_21_6.Protocol1_21_7To1_21_6;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_6;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_5;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ClientboundPacket1_21_6;

public class EntityPacketRewriter1_21_7
extends EntityRewriter<ClientboundPacket1_21_6, Protocol1_21_7To1_21_6> {
    public EntityPacketRewriter1_21_7(Protocol1_21_7To1_21_6 protocol1_21_7To1_21_6) {
        super(protocol1_21_7To1_21_6, ((EntityDataTypes1_21_5)VersionedTypes.V1_21_6.entityDataTypes).optionalComponentType, ((EntityDataTypes1_21_5)VersionedTypes.V1_21_6.entityDataTypes).booleanType);
    }

    @Override
    protected void registerRewrites() {
        EntityDataTypes1_21_5 entityDataTypes1_21_5 = (EntityDataTypes1_21_5)VersionedTypes.V1_21_6.entityDataTypes;
        this.registerEntityDataTypeHandler1_20_3(entityDataTypes1_21_5.itemType, entityDataTypes1_21_5.blockStateType, entityDataTypes1_21_5.optionalBlockStateType, entityDataTypes1_21_5.particleType, entityDataTypes1_21_5.particlesType, entityDataTypes1_21_5.componentType, entityDataTypes1_21_5.optionalComponentType);
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_21_6.getTypeFromId(n);
    }
}


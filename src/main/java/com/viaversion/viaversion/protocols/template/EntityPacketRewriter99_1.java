/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.template;

import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_11;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes26_1;
import com.viaversion.viaversion.api.type.types.version.Types1_20_5;
import com.viaversion.viaversion.protocols.template.Protocol98_1To99_1;
import com.viaversion.viaversion.protocols.v1_21_11to26_1.packet.ClientboundPacket26_1;
import com.viaversion.viaversion.rewriter.EntityRewriter;

public class EntityPacketRewriter99_1
extends EntityRewriter<ClientboundPacket26_1, Protocol98_1To99_1> {
    public EntityPacketRewriter99_1(Protocol98_1To99_1 protocol98_1To99_1) {
        super(protocol98_1To99_1);
    }

    @Override
    public void registerPackets() {
    }

    @Override
    protected void registerRewrites() {
        EntityDataTypes26_1 entityDataTypes26_1 = (EntityDataTypes26_1)((Types1_20_5)((Protocol98_1To99_1)this.protocol).mappedTypes()).entityDataTypes();
        this.dataTypeMapper().register();
        this.registerEntityDataTypeHandler(entityDataTypes26_1.itemType, entityDataTypes26_1.blockStateType, entityDataTypes26_1.optionalBlockStateType, entityDataTypes26_1.particleType, entityDataTypes26_1.particlesType, entityDataTypes26_1.componentType, entityDataTypes26_1.optionalComponentType);
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_21_11.getTypeFromId(n);
    }
}


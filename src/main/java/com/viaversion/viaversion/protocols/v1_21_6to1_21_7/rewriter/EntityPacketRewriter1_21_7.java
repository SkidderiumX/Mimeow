/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21_6to1_21_7.rewriter;

import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_6;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_5;
import com.viaversion.viaversion.api.type.types.version.Types1_20_5;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ClientboundPacket1_21_6;
import com.viaversion.viaversion.protocols.v1_21_6to1_21_7.Protocol1_21_6To1_21_7;
import com.viaversion.viaversion.rewriter.EntityRewriter;

public class EntityPacketRewriter1_21_7
extends EntityRewriter<ClientboundPacket1_21_6, Protocol1_21_6To1_21_7> {
    public EntityPacketRewriter1_21_7(Protocol1_21_6To1_21_7 protocol1_21_6To1_21_7) {
        super(protocol1_21_6To1_21_7);
    }

    @Override
    protected void registerRewrites() {
        EntityDataTypes1_21_5 entityDataTypes1_21_5 = (EntityDataTypes1_21_5)((Types1_20_5)((Protocol1_21_6To1_21_7)this.protocol).mappedTypes()).entityDataTypes();
        this.registerEntityDataTypeHandler(entityDataTypes1_21_5.itemType, entityDataTypes1_21_5.blockStateType, entityDataTypes1_21_5.optionalBlockStateType, entityDataTypes1_21_5.particleType, entityDataTypes1_21_5.particlesType, entityDataTypes1_21_5.componentType, entityDataTypes1_21_5.optionalComponentType);
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_21_6.getTypeFromId(n);
    }
}


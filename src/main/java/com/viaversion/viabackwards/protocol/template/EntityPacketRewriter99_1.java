/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.template;

import com.viaversion.viabackwards.api.rewriters.EntityRewriter;
import com.viaversion.viabackwards.protocol.template.Protocol99_1To98_1;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_11;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes26_1;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.protocols.v1_21_11to26_1.packet.ClientboundPacket26_1;

public class EntityPacketRewriter99_1
extends EntityRewriter<ClientboundPacket26_1, Protocol99_1To98_1> {
    private static final EntityDataTypes26_1 MAPPED_DATA_TYPES = (EntityDataTypes26_1)VersionedTypes.V26_1.entityDataTypes;

    public EntityPacketRewriter99_1(Protocol99_1To98_1 protocol99_1To98_1) {
        super(protocol99_1To98_1, EntityPacketRewriter99_1.MAPPED_DATA_TYPES.optionalComponentType, EntityPacketRewriter99_1.MAPPED_DATA_TYPES.booleanType);
    }

    @Override
    public void registerPackets() {
    }

    @Override
    protected void registerRewrites() {
        this.dataTypeMapper().register();
        this.registerEntityDataTypeHandler1_20_3(EntityPacketRewriter99_1.MAPPED_DATA_TYPES.itemType, EntityPacketRewriter99_1.MAPPED_DATA_TYPES.blockStateType, EntityPacketRewriter99_1.MAPPED_DATA_TYPES.optionalBlockStateType, EntityPacketRewriter99_1.MAPPED_DATA_TYPES.particleType, EntityPacketRewriter99_1.MAPPED_DATA_TYPES.particlesType, EntityPacketRewriter99_1.MAPPED_DATA_TYPES.componentType, EntityPacketRewriter99_1.MAPPED_DATA_TYPES.optionalComponentType);
    }

    @Override
    public void onMappingDataLoaded() {
        super.onMappingDataLoaded();
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_21_11.getTypeFromId(n);
    }
}


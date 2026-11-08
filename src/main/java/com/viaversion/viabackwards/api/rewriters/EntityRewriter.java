/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.api.rewriters;

import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.rewriters.EntityRewriterBase;
import com.viaversion.viaversion.api.data.entity.TrackedEntity;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityDataType;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_14;

public abstract class EntityRewriter<C extends ClientboundPacketType, T extends BackwardsProtocol<C, ?, ?, ?>>
extends EntityRewriterBase<C, T> {
    protected EntityRewriter(T t) {
        this(t, Types1_14.ENTITY_DATA_TYPES.optionalComponentType, Types1_14.ENTITY_DATA_TYPES.booleanType);
    }

    protected EntityRewriter(T t, EntityDataType entityDataType, EntityDataType entityDataType2) {
        super(t, entityDataType, 2, entityDataType2, 3);
    }

    public PacketHandler getSpawnTrackerWithDataHandler() {
        return packetWrapper -> {
            int n = packetWrapper.get(Types.VAR_INT, 0);
            int n2 = packetWrapper.get(Types.VAR_INT, 1);
            TrackedEntity trackedEntity = this.trackAndRewrite(packetWrapper, n2, n);
            if (trackedEntity.entityType() == this.fallingBlockType()) {
                int n3 = packetWrapper.get(Types.INT, 0);
                packetWrapper.set(Types.INT, 0, ((BackwardsProtocol)this.protocol).getMappingData().getNewBlockStateId(n3));
            }
        };
    }

    public void trackSpawnWithData1_19(PacketWrapper packetWrapper, int n) {
        if (((BackwardsProtocol)this.protocol).getMappingData() == null) {
            return;
        }
        int n2 = packetWrapper.get(Types.VAR_INT, 0);
        int n3 = packetWrapper.get(Types.VAR_INT, 1);
        TrackedEntity trackedEntity = this.trackAndRewrite(packetWrapper, n3, n2);
        if (trackedEntity.entityType() == this.fallingBlockType()) {
            packetWrapper.set(Types.VAR_INT, 2, ((BackwardsProtocol)this.protocol).getMappingData().getNewBlockStateId(n));
        }
    }
}


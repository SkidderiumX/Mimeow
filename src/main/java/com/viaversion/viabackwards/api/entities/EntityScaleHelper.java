/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.api.entities;

import com.google.common.base.Preconditions;
import com.viaversion.viabackwards.api.entities.EntityScaleData;
import com.viaversion.viaversion.api.data.FullMappings;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.rewriter.EntityRewriter;
import com.viaversion.viaversion.rewriter.entitydata.EntityDataHandlerEvent;

public class EntityScaleHelper {
    private final ClientboundPacketType updateAttributesPacket;
    private final EntityRewriter<?, ?> rewriter;

    public <CM extends ClientboundPacketType, P extends Protocol<?, CM, ?, ?>> EntityScaleHelper(EntityRewriter<?, P> entityRewriter, CM CM) {
        this.rewriter = entityRewriter;
        this.updateAttributesPacket = CM;
    }

    public void addBabyScale(EntityType entityType, float f, int n) {
        this.rewriter.filter().type(entityType).index(n).handler((entityDataHandlerEvent, entityData) -> this.trackAndSend(entityDataHandlerEvent, entityData, f));
    }

    public void trackAndSend(EntityDataHandlerEvent entityDataHandlerEvent, EntityData entityData, float f) {
        if (entityDataHandlerEvent.trackedEntity() == null) {
            return;
        }
        EntityScaleData entityScaleData = entityDataHandlerEvent.trackedEntity().get(EntityScaleData.class);
        if (entityScaleData == null) {
            entityScaleData = new EntityScaleData();
            entityDataHandlerEvent.trackedEntity().put(entityScaleData);
        }
        boolean bl = (Boolean)entityData.value();
        if (entityScaleData.isBaby() == bl) {
            return;
        }
        entityScaleData.setBaby(bl);
        entityScaleData.setScale(bl ? f : 1.0f);
        FullMappings fullMappings = this.rewriter.protocol().getMappingData().getAttributeMappings();
        int n = fullMappings.mappedId("scale");
        if (n == -1) {
            n = fullMappings.mappedId("generic.scale");
            Preconditions.checkArgument(n != -1);
        }
        PacketWrapper packetWrapper = PacketWrapper.create(this.updateAttributesPacket, entityDataHandlerEvent.user());
        packetWrapper.write(Types.VAR_INT, entityDataHandlerEvent.entityId());
        packetWrapper.write(Types.VAR_INT, 1);
        packetWrapper.write(Types.VAR_INT, n);
        packetWrapper.write(Types.DOUBLE, Double.valueOf(entityScaleData.scale()));
        packetWrapper.write(Types.VAR_INT, 0);
        packetWrapper.send(this.rewriter.protocol().getClass());
    }
}


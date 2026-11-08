/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.api.rewriter;

import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.rewriters.LegacyEntityRewriter;
import com.viaversion.viarewind.ViaRewind;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityDataType;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_8;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;

public abstract class VREntityRewriter<C extends ClientboundPacketType, T extends BackwardsProtocol<C, ?, ?, ?>>
extends LegacyEntityRewriter<C, T> {
    public VREntityRewriter(T t) {
        super(t, EntityDataTypes1_8.STRING, EntityDataTypes1_8.BYTE);
    }

    public VREntityRewriter(T t, EntityDataType entityDataType, EntityDataType entityDataType2) {
        super(t, entityDataType, entityDataType2);
    }

    protected void removeEntities(UserConnection userConnection, int[] nArray) {
        EntityTrackerBase entityTrackerBase = (EntityTrackerBase)this.tracker(userConnection);
        for (int n : nArray) {
            entityTrackerBase.removeEntity(n);
        }
    }

    protected PacketHandler getDimensionHandler() {
        return packetWrapper -> {
            byte by = packetWrapper.get(Types.BYTE, 0);
            Object t = packetWrapper.user().getClientWorld(((BackwardsProtocol)this.protocol).getClass());
            ((ClientWorld)t).setEnvironment(by);
        };
    }

    @Override
    protected Object getDisplayVisibilityDataValue() {
        return (byte)1;
    }

    @Override
    protected boolean alwaysShowOriginalMobName() {
        return ViaRewind.getConfig().alwaysShowOriginalMobName();
    }
}


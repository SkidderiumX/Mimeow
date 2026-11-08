/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_14to1_13_2.rewriter;

import com.viaversion.viabackwards.protocol.v1_14to1_13_2.Protocol1_14To1_13_2;
import com.viaversion.viabackwards.protocol.v1_14to1_13_2.storage.EntityPositionStorage1_14;
import com.viaversion.viaversion.api.data.entity.TrackedEntity;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.rewriter.RewriterBase;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ClientboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_13_2to1_14.packet.ClientboundPackets1_14;

public class SoundPacketRewriter1_14
extends RewriterBase<Protocol1_14To1_13_2> {
    public SoundPacketRewriter1_14(Protocol1_14To1_13_2 protocol1_14To1_13_2) {
        super(protocol1_14To1_13_2);
    }

    @Override
    protected void registerPackets() {
        ((Protocol1_14To1_13_2)this.protocol).registerClientbound(ClientboundPackets1_14.SOUND_ENTITY, null, packetWrapper -> {
            EntityPositionStorage1_14 entityPositionStorage1_14;
            packetWrapper.cancel();
            int n = packetWrapper.read(Types.VAR_INT);
            int n2 = ((Protocol1_14To1_13_2)this.protocol).getMappingData().getSoundMappings().getNewId(n);
            if (n2 == -1) {
                return;
            }
            int n3 = packetWrapper.read(Types.VAR_INT);
            int n4 = packetWrapper.read(Types.VAR_INT);
            TrackedEntity trackedEntity = packetWrapper.user().getEntityTracker(((Protocol1_14To1_13_2)this.protocol).getClass()).entity(n4);
            if (trackedEntity == null || (entityPositionStorage1_14 = trackedEntity.get(EntityPositionStorage1_14.class)) == null) {
                ((Protocol1_14To1_13_2)this.protocol).getLogger().warning("Untracked entity with id " + n4);
                return;
            }
            float f = packetWrapper.read(Types.FLOAT).floatValue();
            float f2 = packetWrapper.read(Types.FLOAT).floatValue();
            int n5 = (int)(entityPositionStorage1_14.x() * 8.0);
            int n6 = (int)(entityPositionStorage1_14.y() * 8.0);
            int n7 = (int)(entityPositionStorage1_14.z() * 8.0);
            PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundPackets1_13.SOUND);
            packetWrapper2.write(Types.VAR_INT, n2);
            packetWrapper2.write(Types.VAR_INT, n3);
            packetWrapper2.write(Types.INT, n5);
            packetWrapper2.write(Types.INT, n6);
            packetWrapper2.write(Types.INT, n7);
            packetWrapper2.write(Types.FLOAT, Float.valueOf(f));
            packetWrapper2.write(Types.FLOAT, Float.valueOf(f2));
            packetWrapper2.send(Protocol1_14To1_13_2.class);
        });
    }
}


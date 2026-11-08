/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_17_1to1_18.rewriter;

import com.viaversion.viaversion.api.data.ParticleMappings;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_16_4to1_17.packet.ServerboundPackets1_17;
import com.viaversion.viaversion.protocols.v1_17_1to1_18.Protocol1_17_1To1_18;
import com.viaversion.viaversion.protocols.v1_17to1_17_1.packet.ClientboundPackets1_17_1;
import com.viaversion.viaversion.rewriter.ItemRewriter;
import com.viaversion.viaversion.rewriter.RecipeRewriter;

public class ItemPacketRewriter1_18
extends ItemRewriter<ClientboundPackets1_17_1, ServerboundPackets1_17, Protocol1_17_1To1_18> {
    public ItemPacketRewriter1_18(Protocol1_17_1To1_18 protocol1_17_1To1_18) {
        super(protocol1_17_1To1_18, Types.ITEM1_13_2, Types.ITEM1_13_2_ARRAY);
    }

    @Override
    public void registerPackets() {
        ((Protocol1_17_1To1_18)this.protocol).replaceClientbound(ClientboundPackets1_17_1.LEVEL_PARTICLES, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.BOOLEAN);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    int n;
                    int n2 = packetWrapper.get(Types.INT, 0);
                    if (n2 == 2) {
                        packetWrapper.set(Types.INT, 0, 3);
                        packetWrapper.write(Types.VAR_INT, 7754);
                        return;
                    }
                    if (n2 == 3) {
                        packetWrapper.write(Types.VAR_INT, 7786);
                        return;
                    }
                    ParticleMappings particleMappings = ((Protocol1_17_1To1_18)ItemPacketRewriter1_18.this.protocol).getMappingData().getParticleMappings();
                    if (particleMappings.isBlockParticle(n2)) {
                        n = packetWrapper.passthrough(Types.VAR_INT);
                        packetWrapper.set(Types.VAR_INT, 0, ((Protocol1_17_1To1_18)ItemPacketRewriter1_18.this.protocol).getMappingData().getNewBlockStateId(n));
                    } else if (particleMappings.isItemParticle(n2)) {
                        ItemPacketRewriter1_18.this.handleItemToClient(packetWrapper.user(), packetWrapper.passthrough(Types.ITEM1_13_2));
                    }
                    n = ((Protocol1_17_1To1_18)ItemPacketRewriter1_18.this.protocol).getMappingData().getNewParticleId(n2);
                    if (n != n2) {
                        packetWrapper.set(Types.INT, 0, n);
                    }
                });
            }
        });
        new RecipeRewriter<ClientboundPackets1_17_1>(this.protocol).register(ClientboundPackets1_17_1.UPDATE_RECIPES);
    }
}


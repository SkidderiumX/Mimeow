/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_20_3to1_20_2.rewriter;

import com.viaversion.viabackwards.api.rewriters.BackwardsItemRewriter;
import com.viaversion.viabackwards.protocol.v1_20_3to1_20_2.Protocol1_20_3To1_20_2;
import com.viaversion.viaversion.api.data.ParticleMappings;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_20_3;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.packet.ClientboundPacket1_20_3;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.packet.ClientboundPackets1_20_3;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.rewriter.RecipeRewriter1_20_3;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.packet.ServerboundPacket1_20_2;
import com.viaversion.viaversion.rewriter.ParticleRewriter;

public class BlockItemPacketRewriter1_20_3
extends BackwardsItemRewriter<ClientboundPacket1_20_3, ServerboundPacket1_20_2, Protocol1_20_3To1_20_2> {
    public BlockItemPacketRewriter1_20_3(Protocol1_20_3To1_20_2 protocol1_20_3To1_20_2) {
        super(protocol1_20_3To1_20_2, Types.ITEM1_20_2, Types.ITEM1_20_2_ARRAY);
    }

    @Override
    public void registerPackets() {
        ((Protocol1_20_3To1_20_2)this.protocol).replaceClientbound(ClientboundPackets1_20_3.LEVEL_PARTICLES, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
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
                    ParticleMappings particleMappings;
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    if (n == (particleMappings = ((Protocol1_20_3To1_20_2)BlockItemPacketRewriter1_20_3.this.protocol).getMappingData().getParticleMappings()).id("vibration")) {
                        int n2 = packetWrapper.read(Types.VAR_INT);
                        if (n2 == 0) {
                            packetWrapper.write(Types.STRING, "minecraft:block");
                        } else if (n2 == 1) {
                            packetWrapper.write(Types.STRING, "minecraft:entity");
                        } else {
                            ((Protocol1_20_3To1_20_2)BlockItemPacketRewriter1_20_3.this.protocol).getLogger().warning("Unknown position source type: " + n2);
                            packetWrapper.cancel();
                        }
                    }
                });
                this.handler(((ParticleRewriter)((Protocol1_20_3To1_20_2)BlockItemPacketRewriter1_20_3.this.protocol).getParticleRewriter()).levelParticlesHandler1_13(Types.VAR_INT));
            }
        });
        new RecipeRewriter1_20_3<ClientboundPacket1_20_3>(this.protocol){

            @Override
            public void handleCraftingShaped(PacketWrapper packetWrapper) {
                String string = packetWrapper.read(Types.STRING);
                int n = packetWrapper.read(Types.VAR_INT);
                int n2 = packetWrapper.passthrough(Types.VAR_INT);
                int n3 = packetWrapper.passthrough(Types.VAR_INT);
                packetWrapper.write(Types.STRING, string);
                packetWrapper.write(Types.VAR_INT, n);
                int n4 = n3 * n2;
                for (int i = 0; i < n4; ++i) {
                    this.handleIngredient(packetWrapper);
                }
                this.rewrite(packetWrapper.user(), packetWrapper.passthrough(this.itemType()));
                packetWrapper.passthrough(Types.BOOLEAN);
            }
        }.register(ClientboundPackets1_20_3.UPDATE_RECIPES);
        ((Protocol1_20_3To1_20_2)this.protocol).registerClientbound(ClientboundPackets1_20_3.EXPLODE, packetWrapper -> {
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.FLOAT);
            int n = packetWrapper.read(Types.VAR_INT);
            byte[][] byArray = new byte[n][3];
            for (int i = 0; i < n; ++i) {
                byArray[i] = new byte[]{packetWrapper.read(Types.BYTE), packetWrapper.read(Types.BYTE), packetWrapper.read(Types.BYTE)};
            }
            float f = packetWrapper.read(Types.FLOAT).floatValue();
            float f2 = packetWrapper.read(Types.FLOAT).floatValue();
            float f3 = packetWrapper.read(Types.FLOAT).floatValue();
            int n2 = packetWrapper.read(Types.VAR_INT);
            if (n2 == 1 || n2 == 2) {
                packetWrapper.write(Types.VAR_INT, n);
                for (byte[] byArray2 : byArray) {
                    packetWrapper.write(Types.BYTE, byArray2[0]);
                    packetWrapper.write(Types.BYTE, byArray2[1]);
                    packetWrapper.write(Types.BYTE, byArray2[2]);
                }
            } else {
                packetWrapper.write(Types.VAR_INT, 0);
            }
            packetWrapper.write(Types.FLOAT, Float.valueOf(f));
            packetWrapper.write(Types.FLOAT, Float.valueOf(f2));
            packetWrapper.write(Types.FLOAT, Float.valueOf(f3));
            packetWrapper.read(Types1_20_3.PARTICLE);
            packetWrapper.read(Types1_20_3.PARTICLE);
            packetWrapper.read(Types.STRING);
            packetWrapper.read(Types.OPTIONAL_FLOAT);
        });
    }
}


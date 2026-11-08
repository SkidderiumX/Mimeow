/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_18_2to1_19.rewriter;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.data.ParticleMappings;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_17_1to1_18.packet.ClientboundPackets1_18;
import com.viaversion.viaversion.protocols.v1_18_2to1_19.Protocol1_18_2To1_19;
import com.viaversion.viaversion.protocols.v1_18_2to1_19.packet.ServerboundPackets1_19;
import com.viaversion.viaversion.protocols.v1_18_2to1_19.provider.AckSequenceProvider;
import com.viaversion.viaversion.protocols.v1_18_2to1_19.storage.LoomStorage;
import com.viaversion.viaversion.rewriter.ItemRewriter;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.RecipeRewriter;
import com.viaversion.viaversion.util.Key;

public class ItemPacketRewriter1_19
extends ItemRewriter<ClientboundPackets1_18, ServerboundPackets1_19, Protocol1_18_2To1_19> {
    private static final int LOOM_MENU_TYPE_ID = 17;
    private static final int LOOM_SELECTABLE_PATTERNS = 34;

    public ItemPacketRewriter1_19(Protocol1_18_2To1_19 protocol1_18_2To1_19) {
        super(protocol1_18_2To1_19, Types.ITEM1_13_2, Types.ITEM1_13_2_ARRAY);
    }

    @Override
    public void registerPackets() {
        ((Protocol1_18_2To1_19)this.protocol).replaceClientbound(ClientboundPackets1_18.LEVEL_PARTICLES, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT, Types.VAR_INT);
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
                    if (n == (particleMappings = ((Protocol1_18_2To1_19)ItemPacketRewriter1_19.this.protocol).getMappingData().getParticleMappings()).id("vibration")) {
                        packetWrapper.read(Types.BLOCK_POSITION1_14);
                        String string = Key.stripMinecraftNamespace(packetWrapper.passthrough(Types.STRING));
                        if (string.equals("entity")) {
                            packetWrapper.passthrough(Types.VAR_INT);
                            packetWrapper.write(Types.FLOAT, Float.valueOf(0.0f));
                        }
                    }
                });
                this.handler(((ParticleRewriter)((Protocol1_18_2To1_19)ItemPacketRewriter1_19.this.protocol).getParticleRewriter()).levelParticlesHandler1_13(Types.VAR_INT));
            }
        });
        ((Protocol1_18_2To1_19)this.protocol).replaceClientbound(ClientboundPackets1_18.MERCHANT_OFFERS, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.read(Types.UNSIGNED_BYTE).shortValue();
                    packetWrapper.write(Types.VAR_INT, n);
                    for (int i = 0; i < n; ++i) {
                        ItemPacketRewriter1_19.this.handleItemToClient(packetWrapper.user(), packetWrapper.passthrough(Types.ITEM1_13_2));
                        ItemPacketRewriter1_19.this.handleItemToClient(packetWrapper.user(), packetWrapper.passthrough(Types.ITEM1_13_2));
                        if (packetWrapper.read(Types.BOOLEAN).booleanValue()) {
                            ItemPacketRewriter1_19.this.handleItemToClient(packetWrapper.user(), packetWrapper.passthrough(Types.ITEM1_13_2));
                        } else {
                            packetWrapper.write(Types.ITEM1_13_2, null);
                        }
                        packetWrapper.passthrough(Types.BOOLEAN);
                        packetWrapper.passthrough(Types.INT);
                        packetWrapper.passthrough(Types.INT);
                        packetWrapper.passthrough(Types.INT);
                        packetWrapper.passthrough(Types.INT);
                        packetWrapper.passthrough(Types.FLOAT);
                        packetWrapper.passthrough(Types.INT);
                    }
                });
            }
        });
        ((Protocol1_18_2To1_19)this.protocol).registerServerbound(ServerboundPackets1_19.PLAYER_ACTION, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.BLOCK_POSITION1_14);
                this.map(Types.UNSIGNED_BYTE);
                this.handler(ItemPacketRewriter1_19.this.sequenceHandler());
            }
        });
        ((Protocol1_18_2To1_19)this.protocol).registerServerbound(ServerboundPackets1_19.USE_ITEM_ON, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.BLOCK_POSITION1_14);
                this.map(Types.VAR_INT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.BOOLEAN);
                this.handler(ItemPacketRewriter1_19.this.sequenceHandler());
            }
        });
        ((Protocol1_18_2To1_19)this.protocol).registerServerbound(ServerboundPackets1_19.USE_ITEM, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.handler(ItemPacketRewriter1_19.this.sequenceHandler());
            }
        });
        ((Protocol1_18_2To1_19)this.protocol).registerClientbound(ClientboundPackets1_18.CONTAINER_CLOSE, packetWrapper -> packetWrapper.user().get(LoomStorage.class).reset());
        ((Protocol1_18_2To1_19)this.protocol).registerServerbound(ServerboundPackets1_19.CONTAINER_CLOSE, packetWrapper -> packetWrapper.user().get(LoomStorage.class).reset());
        ((Protocol1_18_2To1_19)this.protocol).registerServerbound(ServerboundPackets1_19.CONTAINER_BUTTON_CLICK, packetWrapper -> {
            byte by = packetWrapper.passthrough(Types.BYTE);
            if (by != -1 && by == packetWrapper.user().get(LoomStorage.class).containerId()) {
                byte by2 = packetWrapper.read(Types.BYTE);
                packetWrapper.write(Types.BYTE, (byte)(by2 + 1));
            }
        });
        ((Protocol1_18_2To1_19)this.protocol).registerClientbound(ClientboundPackets1_18.OPEN_SCREEN, packetWrapper -> {
            int n;
            int n2 = packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.user().get(LoomStorage.class).setContainerId((n = packetWrapper.passthrough(Types.VAR_INT).intValue()) == 17 ? n2 : -1);
        });
        ((Protocol1_18_2To1_19)this.protocol).appendClientbound(ClientboundPackets1_18.CONTAINER_SET_DATA, packetWrapper -> {
            packetWrapper.resetReader();
            short s = packetWrapper.passthrough(Types.UNSIGNED_BYTE);
            if (s == -1 || s != packetWrapper.user().get(LoomStorage.class).containerId()) {
                return;
            }
            short s2 = packetWrapper.passthrough(Types.SHORT);
            if (s2 == 0) {
                short s3 = packetWrapper.read(Types.SHORT);
                short s4 = s3 == 0 ? (short)-1 : (s3 <= 34 ? (short)(s3 - 1) : (short)0);
                packetWrapper.write(Types.SHORT, s4);
            }
        });
        new RecipeRewriter<ClientboundPackets1_18>(this.protocol).register(ClientboundPackets1_18.UPDATE_RECIPES);
    }

    private PacketHandler sequenceHandler() {
        return packetWrapper -> {
            int n = packetWrapper.read(Types.VAR_INT);
            AckSequenceProvider ackSequenceProvider = Via.getManager().getProviders().get(AckSequenceProvider.class);
            ackSequenceProvider.handleSequence(packetWrapper.user(), n);
        };
    }
}


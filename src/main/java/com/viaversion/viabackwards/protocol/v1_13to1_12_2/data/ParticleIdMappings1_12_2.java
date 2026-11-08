/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_13to1_12_2.data;

import com.viaversion.viabackwards.protocol.v1_13to1_12_2.Protocol1_13To1_12_2;
import com.viaversion.viaversion.api.minecraft.Particle;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import java.util.List;
import org.checkerframework.checker.nullness.qual.Nullable;

public class ParticleIdMappings1_12_2 {
    private static final ParticleData[] particles;

    public static ParticleData getMapping(int n) {
        return particles[n];
    }

    private static ParticleData rewrite(int n) {
        return new ParticleData(n);
    }

    private static ParticleData rewrite(int n, ParticleHandler particleHandler) {
        return new ParticleData(n, particleHandler);
    }

    static {
        ParticleHandler particleHandler = new ParticleHandler(){

            @Override
            public int[] rewrite(Protocol1_13To1_12_2 protocol1_13To1_12_2, PacketWrapper packetWrapper) {
                return this.rewrite(packetWrapper.read(Types.VAR_INT));
            }

            @Override
            public int[] rewrite(Protocol1_13To1_12_2 protocol1_13To1_12_2, List<Particle.ParticleData<?>> list) {
                return this.rewrite((Integer)list.get(0).getValue());
            }

            private int[] rewrite(int n) {
                int n2 = Protocol1_13To1_12_2.MAPPINGS.getNewBlockStateId(n);
                int n3 = n2 >> 4;
                int n4 = n2 & 0xF;
                return new int[]{n3 + (n4 << 12)};
            }

            @Override
            public boolean isBlockHandler() {
                return true;
            }
        };
        particles = new ParticleData[]{ParticleIdMappings1_12_2.rewrite(16), ParticleIdMappings1_12_2.rewrite(20), ParticleIdMappings1_12_2.rewrite(35), ParticleIdMappings1_12_2.rewrite(37, particleHandler), ParticleIdMappings1_12_2.rewrite(4), ParticleIdMappings1_12_2.rewrite(29), ParticleIdMappings1_12_2.rewrite(9), ParticleIdMappings1_12_2.rewrite(44), ParticleIdMappings1_12_2.rewrite(42), ParticleIdMappings1_12_2.rewrite(19), ParticleIdMappings1_12_2.rewrite(18), ParticleIdMappings1_12_2.rewrite(30, new ParticleHandler(){

            @Override
            public int[] rewrite(Protocol1_13To1_12_2 protocol1_13To1_12_2, PacketWrapper packetWrapper) {
                float f = packetWrapper.read(Types.FLOAT).floatValue();
                float f2 = packetWrapper.read(Types.FLOAT).floatValue();
                float f3 = packetWrapper.read(Types.FLOAT).floatValue();
                float f4 = packetWrapper.read(Types.FLOAT).floatValue();
                packetWrapper.set(Types.FLOAT, 3, Float.valueOf(f));
                packetWrapper.set(Types.FLOAT, 4, Float.valueOf(f2));
                packetWrapper.set(Types.FLOAT, 5, Float.valueOf(f3));
                packetWrapper.set(Types.FLOAT, 6, Float.valueOf(f4));
                packetWrapper.set(Types.INT, 1, 0);
                return null;
            }

            @Override
            public int[] rewrite(Protocol1_13To1_12_2 protocol1_13To1_12_2, List<Particle.ParticleData<?>> list) {
                return null;
            }
        }), ParticleIdMappings1_12_2.rewrite(13), ParticleIdMappings1_12_2.rewrite(41), ParticleIdMappings1_12_2.rewrite(10), ParticleIdMappings1_12_2.rewrite(25), ParticleIdMappings1_12_2.rewrite(43), ParticleIdMappings1_12_2.rewrite(15), ParticleIdMappings1_12_2.rewrite(2), ParticleIdMappings1_12_2.rewrite(1), ParticleIdMappings1_12_2.rewrite(46, particleHandler), ParticleIdMappings1_12_2.rewrite(3), ParticleIdMappings1_12_2.rewrite(6), ParticleIdMappings1_12_2.rewrite(26), ParticleIdMappings1_12_2.rewrite(21), ParticleIdMappings1_12_2.rewrite(34), ParticleIdMappings1_12_2.rewrite(14), ParticleIdMappings1_12_2.rewrite(36, new ParticleHandler(){

            @Override
            public int[] rewrite(Protocol1_13To1_12_2 protocol1_13To1_12_2, PacketWrapper packetWrapper) {
                return this.rewrite(protocol1_13To1_12_2, packetWrapper.read(Types.ITEM1_13));
            }

            @Override
            public int[] rewrite(Protocol1_13To1_12_2 protocol1_13To1_12_2, List<Particle.ParticleData<?>> list) {
                return this.rewrite(protocol1_13To1_12_2, (Item)list.get(0).getValue());
            }

            private int[] rewrite(Protocol1_13To1_12_2 protocol1_13To1_12_2, Item item) {
                Item item2 = protocol1_13To1_12_2.getItemRewriter().handleItemToClient(null, item);
                return new int[]{item2.identifier(), item2.data()};
            }
        }), ParticleIdMappings1_12_2.rewrite(33), ParticleIdMappings1_12_2.rewrite(31), ParticleIdMappings1_12_2.rewrite(12), ParticleIdMappings1_12_2.rewrite(27), ParticleIdMappings1_12_2.rewrite(22), ParticleIdMappings1_12_2.rewrite(23), ParticleIdMappings1_12_2.rewrite(0), ParticleIdMappings1_12_2.rewrite(24), ParticleIdMappings1_12_2.rewrite(39), ParticleIdMappings1_12_2.rewrite(11), ParticleIdMappings1_12_2.rewrite(48), ParticleIdMappings1_12_2.rewrite(12), ParticleIdMappings1_12_2.rewrite(45), ParticleIdMappings1_12_2.rewrite(47), ParticleIdMappings1_12_2.rewrite(7), ParticleIdMappings1_12_2.rewrite(5), ParticleIdMappings1_12_2.rewrite(17), ParticleIdMappings1_12_2.rewrite(4), ParticleIdMappings1_12_2.rewrite(4), ParticleIdMappings1_12_2.rewrite(4), ParticleIdMappings1_12_2.rewrite(18), ParticleIdMappings1_12_2.rewrite(18)};
    }

    public static final class ParticleData {
        private final int historyId;
        private final ParticleHandler handler;

        private ParticleData(int n, ParticleHandler particleHandler) {
            this.historyId = n;
            this.handler = particleHandler;
        }

        private ParticleData(int n) {
            this(n, null);
        }

        public int @Nullable [] rewriteData(Protocol1_13To1_12_2 protocol1_13To1_12_2, PacketWrapper packetWrapper) {
            if (this.handler == null) {
                return null;
            }
            return this.handler.rewrite(protocol1_13To1_12_2, packetWrapper);
        }

        public int @Nullable [] rewriteMeta(Protocol1_13To1_12_2 protocol1_13To1_12_2, List<Particle.ParticleData<?>> list) {
            if (this.handler == null) {
                return null;
            }
            return this.handler.rewrite(protocol1_13To1_12_2, list);
        }

        public int getHistoryId() {
            return this.historyId;
        }

        public ParticleHandler getHandler() {
            return this.handler;
        }
    }

    public static interface ParticleHandler {
        public int[] rewrite(Protocol1_13To1_12_2 var1, PacketWrapper var2);

        public int[] rewrite(Protocol1_13To1_12_2 var1, List<Particle.ParticleData<?>> var2);

        default public boolean isBlockHandler() {
            return false;
        }
    }
}


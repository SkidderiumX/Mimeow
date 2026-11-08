/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_12_2to1_13.data;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.minecraft.Particle;
import com.viaversion.viaversion.api.minecraft.item.DataItem;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.Protocol1_12_2To1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.rewriter.WorldPacketRewriter1_13;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.checkerframework.checker.nullness.qual.Nullable;

public class ParticleIdMappings1_13 {
    private static final List<NewParticle> particles = new ArrayList<NewParticle>();

    public static Particle rewriteParticle(int n, Integer[] integerArray) {
        if (n >= particles.size()) {
            Protocol1_12_2To1_13.LOGGER.severe("Failed to transform particles with id " + n + " and data " + Arrays.toString((Object[])integerArray));
            return null;
        }
        NewParticle newParticle = particles.get(n);
        return newParticle.handle(new Particle(newParticle.id()), integerArray);
    }

    private static void add(int n) {
        particles.add(new NewParticle(n, null));
    }

    private static void add(int n, ParticleDataHandler particleDataHandler) {
        particles.add(new NewParticle(n, particleDataHandler));
    }

    private static ParticleDataHandler reddustHandler() {
        return (particle, integerArray) -> {
            particle.add(Types.FLOAT, Float.valueOf(ParticleIdMappings1_13.randomBool() ? 1.0f : 0.0f));
            particle.add(Types.FLOAT, Float.valueOf(0.0f));
            particle.add(Types.FLOAT, Float.valueOf(ParticleIdMappings1_13.randomBool() ? 1.0f : 0.0f));
            particle.add(Types.FLOAT, Float.valueOf(1.0f));
            return particle;
        };
    }

    private static boolean randomBool() {
        return ThreadLocalRandom.current().nextBoolean();
    }

    private static ParticleDataHandler iconcrackHandler() {
        return (particle, integerArray) -> {
            DataItem dataItem;
            if (integerArray.length == 1) {
                dataItem = new DataItem(integerArray[0], 1, 0, null);
            } else if (integerArray.length == 2) {
                dataItem = new DataItem(integerArray[0], 1, integerArray[1].shortValue(), null);
            } else {
                return particle;
            }
            Via.getManager().getProtocolManager().getProtocol(Protocol1_12_2To1_13.class).getItemRewriter().handleItemToClient(null, dataItem);
            particle.add(Types.ITEM1_13, dataItem);
            return particle;
        };
    }

    private static ParticleDataHandler blockHandler() {
        return ParticleIdMappings1_13.blockHandler(-1, -1);
    }

    private static ParticleDataHandler blockHandler(int n, int n2) {
        return (particle, integerArray) -> {
            int n3 = integerArray[0];
            if ((n3 & 0xFFF) == n) {
                n3 = n3 & 0xFFFFF000 | n2;
            }
            int n4 = (n3 & 0xFFF) << 4 | n3 >> 12 & 0xF;
            int n5 = WorldPacketRewriter1_13.toNewId(n4);
            particle.add(Types.VAR_INT, n5);
            return particle;
        };
    }

    static {
        ParticleIdMappings1_13.add(34);
        ParticleIdMappings1_13.add(19);
        ParticleIdMappings1_13.add(18);
        ParticleIdMappings1_13.add(21);
        ParticleIdMappings1_13.add(4);
        ParticleIdMappings1_13.add(43);
        ParticleIdMappings1_13.add(22);
        ParticleIdMappings1_13.add(42);
        ParticleIdMappings1_13.add(32);
        ParticleIdMappings1_13.add(6);
        ParticleIdMappings1_13.add(14);
        ParticleIdMappings1_13.add(37);
        ParticleIdMappings1_13.add(30);
        ParticleIdMappings1_13.add(12);
        ParticleIdMappings1_13.add(26);
        ParticleIdMappings1_13.add(17);
        ParticleIdMappings1_13.add(0);
        ParticleIdMappings1_13.add(44);
        ParticleIdMappings1_13.add(10);
        ParticleIdMappings1_13.add(9);
        ParticleIdMappings1_13.add(1);
        ParticleIdMappings1_13.add(24);
        ParticleIdMappings1_13.add(32);
        ParticleIdMappings1_13.add(33);
        ParticleIdMappings1_13.add(35);
        ParticleIdMappings1_13.add(15);
        ParticleIdMappings1_13.add(23);
        ParticleIdMappings1_13.add(31);
        ParticleIdMappings1_13.add(-1);
        ParticleIdMappings1_13.add(5);
        ParticleIdMappings1_13.add(11, ParticleIdMappings1_13.reddustHandler());
        ParticleIdMappings1_13.add(29);
        ParticleIdMappings1_13.add(34);
        ParticleIdMappings1_13.add(28);
        ParticleIdMappings1_13.add(25);
        ParticleIdMappings1_13.add(2);
        ParticleIdMappings1_13.add(27, ParticleIdMappings1_13.iconcrackHandler());
        ParticleIdMappings1_13.add(3, ParticleIdMappings1_13.blockHandler());
        ParticleIdMappings1_13.add(3, ParticleIdMappings1_13.blockHandler());
        ParticleIdMappings1_13.add(36);
        ParticleIdMappings1_13.add(-1);
        ParticleIdMappings1_13.add(13);
        ParticleIdMappings1_13.add(8);
        ParticleIdMappings1_13.add(16);
        ParticleIdMappings1_13.add(7);
        ParticleIdMappings1_13.add(40);
        ParticleIdMappings1_13.add(20, ParticleIdMappings1_13.blockHandler(160, 95));
        ParticleIdMappings1_13.add(41);
        ParticleIdMappings1_13.add(38);
    }

    private record NewParticle(int id, @Nullable ParticleDataHandler handler) {
        public Particle handle(Particle particle, Integer[] integerArray) {
            if (this.handler != null) {
                return this.handler.handler(particle, integerArray);
            }
            return particle;
        }
    }

    @FunctionalInterface
    public static interface ParticleDataHandler {
        public Particle handler(Particle var1, Integer[] var2);
    }
}


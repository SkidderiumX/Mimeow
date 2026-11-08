/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.Consumer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.client.C0APacketAnimation;
import net.minecraft.network.play.client.C0CPacketInput;
import x.ocb67361fd4e;
import x.ocd1e93e6984;

public class oc5adc975102 {
    private static final int P = 1000;
    private final Deque<ocd1e93e6984> \u0574 = new ArrayDeque<ocd1e93e6984>();
    private final Consumer<Packet<?>> \u0552;
    private long \u03e1 = 0x7711C163A34B31F1L ^ 0xF711C163A34B31F1L;
    public static int \u045b;

    public oc5adc975102(Consumer<Packet<?>> consumer) {
        this.\u0552 = consumer;
    }

    public boolean \u037d(Packet<?> packet, long l, long l2, long l3) {
        block12: {
            this.\u0373(l);
            if (l < this.\u03e1 || l3 <= 0L) break block12;
            this.\u03e1 = l + l3;
        }
        long l4 = Math.max(l + l2, this.\u03e1);
        ocd1e93e6984 ocd1e93e69842 = this.\u0574.peekLast();
        if (ocd1e93e69842 != null) {
            l4 = Math.max(l4, ocd1e93e69842.\u028f);
        } else {
            if (l4 <= l) {
                return false;
            }
        }
        if (this.\u0574.size() >= (0x8F1D9A6E ^ 0x8F1D9986)) {
            this.\u0552.accept(this.\u0574.removeFirst().\u015d);
        }
        this.\u0574.addLast(new ocd1e93e6984(packet, l4));
        return true;
    }

    public void \u0373(long l) {
        while (true) {
            if (this.\u0574.isEmpty() || this.\u0574.peekFirst().\u028f > l) break;
            this.\u0552.accept(this.\u0574.removeFirst().\u015d);
        }
    }

    public void \u00c8() {
        this.\u03e1 = 0x6274BF628455FE8AL ^ 0xE274BF628455FE8AL;
        while (!this.\u0574.isEmpty()) {
            this.\u0552.accept(this.\u0574.removeFirst().\u015d);
        }
    }

    public void \u053f() {
        this.\u0574.removeIf(ocd1e93e69842 -> {
            ocd1e93e6984 ocd1e93e69843;
            int n;
            int n2;
            block24: {
                C07PacketPlayerDigging c07PacketPlayerDigging;
                C07PacketPlayerDigging c07PacketPlayerDigging2;
                block23: {
                    block20: {
                        block21: {
                            C07PacketPlayerDigging.Action action;
                            block22: {
                                C07PacketPlayerDigging c07PacketPlayerDigging3;
                                n2 = ocb67361fd4e.\u00f4;
                                n = ocd1e93e69842.\u015d instanceof C03PacketPlayer;
                                if (n2 != 0) return n != 0;
                                if (n != 0) return 1 != 0;
                                n = ocd1e93e69842.\u015d instanceof C02PacketUseEntity;
                                if (n2 != 0) return n != 0;
                                if (n != 0) return 1 != 0;
                                c07PacketPlayerDigging2 = ocd1e93e69842.\u015d;
                                if (n2 != 0) break block20;
                                if (!(c07PacketPlayerDigging2 instanceof C07PacketPlayerDigging)) break block21;
                                C07PacketPlayerDigging c07PacketPlayerDigging4 = c07PacketPlayerDigging3 = (C07PacketPlayerDigging)c07PacketPlayerDigging2;
                                if (n2 == 0) {
                                    if (c07PacketPlayerDigging4.getStatus() == C07PacketPlayerDigging.Action.START_DESTROY_BLOCK) return 1 != 0;
                                    c07PacketPlayerDigging4 = c07PacketPlayerDigging3;
                                }
                                action = c07PacketPlayerDigging4.getStatus();
                                if (n2 != 0) break block22;
                                if (action == C07PacketPlayerDigging.Action.ABORT_DESTROY_BLOCK) return 1 != 0;
                                c07PacketPlayerDigging = c07PacketPlayerDigging3;
                                if (n2 != 0) break block23;
                                action = c07PacketPlayerDigging.getStatus();
                            }
                            if (action == C07PacketPlayerDigging.Action.STOP_DESTROY_BLOCK) return 1 != 0;
                        }
                        ocd1e93e69843 = ocd1e93e69842;
                        if (n2 != 0) break block24;
                        c07PacketPlayerDigging2 = ocd1e93e69843.\u015d;
                    }
                    c07PacketPlayerDigging = c07PacketPlayerDigging2;
                }
                if (c07PacketPlayerDigging instanceof C08PacketPlayerBlockPlacement) {
                    C08PacketPlayerBlockPlacement c08PacketPlayerBlockPlacement = (C08PacketPlayerBlockPlacement)((Object)c07PacketPlayerDigging2);
                    n = c08PacketPlayerBlockPlacement.getPlacedBlockDirection();
                    if (n2 != 0) return n != 0;
                    if (n != (0xE0B8C12A ^ 0xE0B8C1D5)) return 1 != 0;
                }
                ocd1e93e69843 = ocd1e93e69842;
            }
            n = ocd1e93e69843.\u015d instanceof C0APacketAnimation;
            if (n2 != 0) return n != 0;
            if (n != 0) return 1 != 0;
            n = ocd1e93e69842.\u015d instanceof C0CPacketInput;
            if (n2 != 0) return n != 0;
            if (n != 0) return 1 != 0;
            return 0 != 0;
        });
    }

    public void \u04ae() {
        this.\u0574.clear();
        this.\u03e1 = 0xFB545AEBE924E42AL ^ 0x7B545AEBE924E42AL;
    }
}


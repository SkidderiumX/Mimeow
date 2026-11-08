/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;
import net.minecraft.client.Minecraft;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.util.Vec3;
import x.oc66fa4f2195;
import x.oc69da1aa7f5;
import x.oc8ce2882092;
import x.oc9d4393f3ce;
import x.ocacfd09d720;
import x.ocb32c6294ba;
import x.ocb67361fd4e;
import x.ocd6ae010123;
import x.oced847c6f44;

public class oc61f27421d1 {
    private final Minecraft \u0267 = Minecraft.getMinecraft();
    private final Deque<ocb32c6294ba> \u0269 = new ConcurrentLinkedDeque<ocb32c6294ba>();
    private oced847c6f44 \u03df = oced847c6f44.E;
    private int \u0397;
    private long \u021e;
    private boolean \u0244;
    private Vec3 \u04b7;
    public static int \u02ad;

    @oc66fa4f2195(priority=oc8ce2882092.NORMAL)
    public synchronized void \u03d0(oc9d4393f3ce oc9d4393f3ce2) {
        oc61f27421d1 oc61f27421d12;
        block20: {
            block21: {
                int n;
                block19: {
                    block22: {
                        block18: {
                            boolean bl;
                            block17: {
                                n = ocacfd09d720.\u03d3;
                                bl = oc9d4393f3ce2.isCanceled();
                                if (n != 0) break block17;
                                if (bl) break block18;
                                oc61f27421d12 = this;
                                if (n != 0) break block19;
                                bl = oc61f27421d12.\u0244;
                            }
                            if (!bl) break block22;
                        }
                        return;
                    }
                    oc61f27421d12 = this;
                }
                if (n != 0) break block20;
                if (oc61f27421d12.\u0267.getNetHandler() != null) break block21;
                this.\u0177();
                return;
            }
            oc61f27421d12 = this;
        }
        if (oc61f27421d12.\u01c9(oc9d4393f3ce2.\u025f())) {
            oc9d4393f3ce2.setCanceled(true);
        }
    }

    public synchronized boolean \u0111(Packet<?> packet) {
        boolean bl;
        block5: {
            block4: {
                if (this.\u0244 || !this.\u01c9(packet)) break block4;
                bl = true;
                break block5;
            }
            bl = false;
        }
        return bl;
    }

    public synchronized boolean \u0119() {
        return this.\u0244;
    }

    private boolean \u01c9(Packet<?> packet) {
        boolean bl;
        block14: {
            block12: {
                block13: {
                    this.\u01e0();
                    if (!ocb67361fd4e.\u0505(packet)) {
                        return false;
                    }
                    if (this.\u03df != oced847c6f44.\u017b) break block12;
                    if (this.\u021e <= 0L) break block13;
                    bl = true;
                    break block14;
                }
                bl = false;
                break block14;
            }
            bl = this.\u0397 > 0;
        }
        boolean bl2 = bl;
        if (bl2) {
            this.\u0269.offer(new ocb32c6294ba(packet));
            return true;
        }
        this.\u0179(packet);
        return false;
    }

    public synchronized void \u0570(int n) {
        this.\u03df = oced847c6f44.E;
        this.\u0397 = Math.max(0, n);
        int n2 = ocacfd09d720.\u03d3;
        this.\u021e = 0L;
        if (false) {
            ocacfd09d720.\u03d3 = ++n2;
        }
    }

    public synchronized void \u0419(long l) {
        block4: {
            boolean bl;
            block6: {
                block5: {
                    this.\u03df = oced847c6f44.\u017b;
                    this.\u021e = Math.max(0L, l);
                    int n = ocacfd09d720.\u03d3;
                    this.\u0397 = 0;
                    if (n == 0) break block4;
                    if (!false) break block5;
                    bl = false;
                    break block6;
                }
                bl = true;
            }
            oc69da1aa7f5.\u04ac = bl;
        }
    }

    public synchronized void \u047f() {
        this.\u03df = oced847c6f44.E;
        this.\u0397 = 0;
        this.\u021e = 0L;
    }

    public synchronized void \u03a0() {
        block14: {
            oc61f27421d1 oc61f27421d12;
            block12: {
                block13: {
                    int n;
                    block10: {
                        block11: {
                            n = ocacfd09d720.\u03d3;
                            oc61f27421d12 = this;
                            if (n != 0) break block10;
                            if (oc61f27421d12.\u0267.getNetHandler() != null) break block11;
                            this.\u0177();
                            return;
                        }
                        oc61f27421d12 = this;
                    }
                    if (n != 0) break block12;
                    if (oc61f27421d12.\u03df == oced847c6f44.\u017b) break block13;
                    for (ocb32c6294ba ocb32c6294ba2 : this.\u0269) {
                        ++ocb32c6294ba2.\u0536;
                        if (n == 0) {
                            if (n == 0) continue;
                            break;
                        }
                        break block14;
                    }
                }
                oc61f27421d12 = this;
            }
            oc61f27421d12.\u01e0();
        }
    }

    public synchronized Vec3 \u00f9() {
        return this.\u04b7;
    }

    public synchronized void \u016d() {
        this.\u047f();
        this.\u0269.clear();
        this.\u04b7 = null;
    }

    public synchronized void \u040b(boolean bl) {
        block12: {
            oc61f27421d1 oc61f27421d12;
            block10: {
                block11: {
                    int n = ocacfd09d720.\u03d3;
                    oc61f27421d12 = this;
                    if (n != 0) break block10;
                    oc61f27421d12.\u047f();
                    if (!bl) break block11;
                    oc61f27421d12 = this;
                    if (n != 0) break block10;
                    if (oc61f27421d12.\u0267.getNetHandler() == null) break block11;
                    this.\u00d6();
                    if (n == 0) break block12;
                }
                oc61f27421d12 = this;
            }
            oc61f27421d12.\u0177();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void \u01e0() {
        long l = System.currentTimeMillis();
        this.\u0244 = true;
        try {
            ocb32c6294ba ocb32c6294ba2;
            while ((ocb32c6294ba2 = this.\u0269.peek()) != null) {
                boolean bl;
                boolean bl2 = this.\u03df == oced847c6f44.\u017b ? this.\u021e <= 0L || l - ocb32c6294ba2.\u04b9 >= this.\u021e : (bl = this.\u0397 <= 0 || ocb32c6294ba2.\u0536 > this.\u0397);
                if (!bl) {
                    return;
                }
                this.\u0269.poll();
                ocd6ae010123.\u0115(ocb32c6294ba2.\u02b5);
                this.\u0179(ocb32c6294ba2.\u02b5);
            }
            return;
        }
        finally {
            this.\u0244 = false;
        }
    }

    private void \u00d6() {
        this.\u0244 = true;
        int n = ocacfd09d720.\u03d3;
        try {
            block6: {
                oc61f27421d1 oc61f27421d12;
                ocb32c6294ba ocb32c6294ba2;
                while ((ocb32c6294ba2 = this.\u0269.poll()) != null) {
                    ocd6ae010123.\u0115(ocb32c6294ba2.\u02b5);
                    oc61f27421d12 = this;
                    if (n == 0) {
                        oc61f27421d12.\u0179(ocb32c6294ba2.\u02b5);
                        if (n == 0) continue;
                        break;
                    }
                    break block6;
                }
                oc61f27421d12 = this;
            }
            oc61f27421d12.\u0244 = false;
        }
        catch (Throwable throwable) {
            this.\u0244 = false;
            throw throwable;
        }
    }

    private void \u0179(Packet<?> packet) {
        if (!(packet instanceof C03PacketPlayer)) {
            return;
        }
        C03PacketPlayer c03PacketPlayer = (C03PacketPlayer)packet;
        if (c03PacketPlayer.isMoving()) {
            this.\u04b7 = new Vec3(c03PacketPlayer.getPositionX(), c03PacketPlayer.getPositionY(), c03PacketPlayer.getPositionZ());
        }
    }

    private void \u0177() {
        this.\u047f();
        this.\u0269.clear();
        this.\u0244 = false;
        this.\u04b7 = null;
    }
}


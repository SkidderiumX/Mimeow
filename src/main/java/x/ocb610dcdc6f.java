/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayDeque;
import java.util.Deque;
import net.minecraft.network.play.client.C0FPacketConfirmTransaction;
import x.oc4ac72a2961;
import x.oc9d4393f3ce;
import x.ocbab3c9954b;
import x.ocd6ae010123;
import x.ocdb9d3f5f92;

public class ocb610dcdc6f
extends oc4ac72a2961 {
    private final Deque<C0FPacketConfirmTransaction> \u0532 = new ArrayDeque<C0FPacketConfirmTransaction>();
    public static boolean \u0226;

    public ocb610dcdc6f(ocdb9d3f5f92 ocdb9d3f5f922) {
        super("DelayedTransaction", ocdb9d3f5f922);
    }

    @Override
    public void z$lg1k3tz4etot() {
        this.\u0477();
    }

    @Override
    public void z$38kb8b9ql2ia2() {
        C0FPacketConfirmTransaction c0FPacketConfirmTransaction;
        boolean bl = oc4ac72a2961.\u01fe;
        while ((c0FPacketConfirmTransaction = this.\u0288()) != null) {
            ocd6ae010123.\u0115(c0FPacketConfirmTransaction);
            if (!bl) continue;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void z$1ea7s7sj3pbka(oc9d4393f3ce oc9d4393f3ce2) {
        oc9d4393f3ce oc9d4393f3ce3;
        block9: {
            block10: {
                block8: {
                    boolean bl;
                    block7: {
                        boolean bl2 = oc4ac72a2961.\u01fe;
                        bl = this.\u03f2.z$3rzb3dil7uydr();
                        if (bl2) break block7;
                        if (!bl) break block8;
                        oc9d4393f3ce3 = oc9d4393f3ce2;
                        if (bl2) break block9;
                        bl = oc9d4393f3ce3.\u025f() instanceof C0FPacketConfirmTransaction;
                    }
                    if (bl) break block10;
                }
                return;
            }
            oc9d4393f3ce3 = oc9d4393f3ce2;
        }
        C0FPacketConfirmTransaction c0FPacketConfirmTransaction = (C0FPacketConfirmTransaction)oc9d4393f3ce3.\u025f();
        Deque<C0FPacketConfirmTransaction> deque = this.\u0532;
        synchronized (deque) {
            this.\u0532.addLast(c0FPacketConfirmTransaction);
        }
        oc9d4393f3ce2.setCanceled(true);
    }

    @Override
    public void z$wf8ltemaqp1d(ocbab3c9954b ocbab3c9954b2) {
        this.\u0477();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void \u0477() {
        Deque<C0FPacketConfirmTransaction> deque = this.\u0532;
        synchronized (deque) {
            this.\u0532.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private C0FPacketConfirmTransaction \u0288() {
        Deque<C0FPacketConfirmTransaction> deque = this.\u0532;
        synchronized (deque) {
            return this.\u0532.pollFirst();
        }
    }
}


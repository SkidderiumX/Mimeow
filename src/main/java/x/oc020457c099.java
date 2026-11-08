/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.util.Vec3;
import x.oc110d7f376c;
import x.oc66fa4f2195;
import x.oc69da1aa7f5;
import x.oc9adb807c19;
import x.ocb67361fd4e;
import x.ocd6ae010123;
import x.oce7a48e7064;

public class oc020457c099 {
    private final Minecraft \u04fb = Minecraft.getMinecraft();
    public final Deque<oce7a48e7064> \u03fb = new ConcurrentLinkedDeque<oce7a48e7064>();
    private int \u01fd;
    private boolean \u013c;
    private Vec3 \u014b = new Vec3(0.0, 0.0, 0.0);
    public static int \u029a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private synchronized void \u01a9() {
        NetHandlerPlayClient netHandlerPlayClient = this.\u04fb.getNetHandler();
        if (netHandlerPlayClient == null || netHandlerPlayClient.getNetworkManager() == null || !netHandlerPlayClient.getNetworkManager().isChannelOpen()) {
            this.\u03fb.clear();
            return;
        }
        this.\u013c = true;
        try {
            while (!this.\u03fb.isEmpty()) {
                oce7a48e7064 oce7a48e70642 = this.\u03fb.peek();
                if (!oc020457c099.\u03c2(this.\u01fd, oce7a48e70642.\u0241)) {
                    return;
                }
                this.\u03fb.poll();
                ocd6ae010123.\u0115(oce7a48e70642.\u03a4);
                this.\u04ce(oce7a48e70642.\u03a4);
            }
            return;
        }
        finally {
            this.\u013c = false;
        }
    }

    private void \u00c9() {
        Iterator<oce7a48e7064> iterator2 = this.\u03fb.iterator();
        int n = ocb67361fd4e.\u00f4;
        while (iterator2.hasNext()) {
            oce7a48e7064 oce7a48e70642 = iterator2.next();
            ++oce7a48e70642.\u0241;
            if (n == 0) continue;
        }
    }

    public synchronized boolean \u027a(Packet<?> packet) {
        this.\u01a9();
        if (!ocb67361fd4e.\u0505(packet)) {
            return false;
        }
        if (this.\u01fd > 0) {
            this.\u03fb.offer(new oce7a48e7064(packet));
            return true;
        }
        this.\u04ce(packet);
        return false;
    }

    public synchronized void \u0370(int n) {
        this.\u01fd = n;
    }

    public synchronized int \u0516() {
        return this.\u01fd;
    }

    public synchronized boolean \u0192() {
        boolean bl;
        block2: {
            block3: {
                int n = ocb67361fd4e.\u00f4;
                bl = this.\u03fb.isEmpty();
                if (n != 0) break block2;
                if (bl) break block3;
                bl = true;
                break block2;
            }
            bl = false;
        }
        return bl;
    }

    public synchronized Vec3 \u016f() {
        return this.\u014b;
    }

    public synchronized boolean \u0494() {
        return this.\u013c;
    }

    public synchronized void \u01c7() {
        block6: {
            boolean bl;
            block8: {
                block7: {
                    this.\u01fd = 0;
                    this.\u013c = false;
                    int n = ocb67361fd4e.\u00f4;
                    this.\u03fb.clear();
                    oc020457c099 oc020457c0992 = this;
                    Vec3 vec3 = this.\u04fb.thePlayer == null ? new Vec3(0.0, 0.0, 0.0) : new Vec3(this.\u04fb.thePlayer.posX, this.\u04fb.thePlayer.posY, this.\u04fb.thePlayer.posZ);
                    oc020457c0992.\u014b = vec3;
                    if (n == 0) break block6;
                    if (!false) break block7;
                    bl = false;
                    break block8;
                }
                bl = true;
            }
            oc69da1aa7f5.\u04ac = bl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @oc66fa4f2195
    public void \u0240(oc9adb807c19 oc9adb807c192) {
        Minecraft minecraft;
        block18: {
            block19: {
                block16: {
                    int n;
                    block17: {
                        block15: {
                            n = ocb67361fd4e.\u00f4;
                            if (oc9adb807c192.\u04b0 != oc110d7f376c.END) {
                                return;
                            }
                            minecraft = this.\u04fb;
                            if (n != 0) break block15;
                            if (minecraft.thePlayer == null) break block16;
                            minecraft = this.\u04fb;
                        }
                        if (n != 0) break block17;
                        if (minecraft.theWorld == null) break block16;
                        minecraft = this.\u04fb;
                    }
                    if (n != 0) break block18;
                    if (minecraft.getNetHandler() != null) break block19;
                }
                this.\u01c7();
                return;
            }
            minecraft = this.\u04fb;
        }
        if (minecraft.thePlayer.isDead) {
            this.\u0370(0);
        }
        oc020457c099 oc020457c0992 = this;
        synchronized (oc020457c0992) {
            this.\u00c9();
            this.\u01a9();
            return;
        }
    }

    private void \u04ce(Packet<?> packet) {
        if (!(packet instanceof C03PacketPlayer)) {
            return;
        }
        C03PacketPlayer c03PacketPlayer = (C03PacketPlayer)packet;
        if (c03PacketPlayer.isMoving()) {
            this.\u014b = new Vec3(c03PacketPlayer.getPositionX(), c03PacketPlayer.getPositionY(), c03PacketPlayer.getPositionZ());
        }
    }

    static boolean \u03c2(int n, int n2) {
        boolean bl;
        block5: {
            block4: {
                if (n > 0 && n2 <= n) break block4;
                bl = true;
                break block5;
            }
            bl = false;
        }
        return bl;
    }
}


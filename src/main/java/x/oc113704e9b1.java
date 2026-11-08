/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Arrays;
import java.util.concurrent.ConcurrentLinkedQueue;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiDownloadTerrain;
import net.minecraft.network.Packet;
import x.R;
import x.oc613fa20ccd;
import x.oc75d51ec7eb;
import x.ocb67361fd4e;
import x.ocd6ae010123;

public class oc113704e9b1 {
    private static final Minecraft \u0270 = Minecraft.getMinecraft();
    private static final long \u00cc = 100L;
    public static final long \u014c = 9999999L;
    public static final ConcurrentLinkedQueue<oc613fa20ccd> \u0107 = new ConcurrentLinkedQueue();
    private static long \u01aa = System.currentTimeMillis();
    private static boolean \u00d9;
    private static long \u014d;
    private static boolean \u01a6;
    public static int \u0424;

    public static void \u00f2() {
        \u01aa = System.currentTimeMillis();
    }

    public static boolean \u01fa(long l) {
        long l2;
        block2: {
            block3: {
                int n = oc75d51ec7eb.\u03e9;
                long l3 = System.currentTimeMillis() - \u01aa - l;
                l2 = l3 == 0L ? 0 : (l3 < 0L ? -1 : 1);
                if (n != 0) break block2;
                if (l2 < 0) break block3;
                l2 = 1;
                break block2;
            }
            l2 = 0;
        }
        return (boolean)l2;
    }

    public static boolean \u00c5(Packet<?> packet) {
        boolean bl;
        block12: {
            block13: {
                int n = oc75d51ec7eb.\u03e9;
                bl = ocb67361fd4e.\u0126(packet);
                if (n != 0) break block12;
                if (bl) break block13;
                bl = \u00d9;
                if (n != 0) break block12;
                if (!bl) break block13;
                bl = oc113704e9b1.\u04ee(packet);
                if (n != 0) break block12;
                if (!bl) break block13;
                \u0107.add(new oc613fa20ccd(packet));
                return true;
            }
            bl = false;
        }
        return bl;
    }

    public static boolean \u04bc(Packet<?> packet) {
        boolean bl;
        block12: {
            block13: {
                int n = oc75d51ec7eb.\u03e9;
                bl = ocb67361fd4e.\u0223(packet);
                if (n != 0) break block12;
                if (bl) break block13;
                bl = \u00d9;
                if (n != 0) break block12;
                if (!bl) break block13;
                bl = oc113704e9b1.\u04ee(packet);
                if (n != 0) break block12;
                if (!bl) break block13;
                \u0107.add(new oc613fa20ccd(packet));
                return true;
            }
            bl = false;
        }
        return bl;
    }

    private static boolean \u04ee(Packet<?> packet) {
        return Arrays.stream(R.values()).anyMatch(r -> {
            boolean bl;
            block8: {
                block7: {
                    R r2;
                    int n;
                    block6: {
                        n = oc75d51ec7eb.\u03e9;
                        r2 = r;
                        if (n != 0) break block6;
                        if (!r2.\u04fc()) break block7;
                        r2 = r;
                    }
                    bl = r2.\u03f3(packet.getClass());
                    if (n != 0) break block8;
                    if (!bl) break block7;
                    bl = true;
                    break block8;
                }
                bl = false;
            }
            return bl;
        });
    }

    public static void \u01af() {
        block3: {
            boolean bl;
            block2: {
                int n = oc75d51ec7eb.\u03e9;
                bl = \u0107.isEmpty();
                if (n != 0) break block2;
                if (bl) break block3;
                bl = \u00d9;
            }
            boolean bl2 = bl;
            \u00d9 = false;
            \u0107.forEach(oc613fa20ccd2 -> ocd6ae010123.\u0115(oc613fa20ccd2.\u053b()));
            \u00d9 = bl2;
            \u0107.clear();
        }
    }

    public static void \u0282() {
        \u00d9 = false;
        \u01aa = System.currentTimeMillis() - (0x9AABBD75CAD63E67L ^ 0x9AABBD75CA4EA818L);
    }

    public static void \u02ac() {
        oc113704e9b1.\u0282();
        oc113704e9b1.\u01af();
    }

    public static void J(boolean bl) {
        block15: {
            boolean bl2;
            block16: {
                int n;
                block13: {
                    block14: {
                        n = oc75d51ec7eb.\u03e9;
                        bl2 = bl;
                        if (n != 0) break block13;
                        if (!bl2) break block14;
                        bl2 = \u01a6;
                        if (n != 0) break block13;
                        if (bl2) break block14;
                        oc113704e9b1.\u0373();
                        if (n == 0) break block15;
                    }
                    bl2 = bl;
                }
                if (n != 0) break block16;
                if (bl2) break block15;
                bl2 = \u01a6;
            }
            if (bl2) {
                oc113704e9b1.\u0373();
            }
        }
    }

    private static void \u0373() {
        block13: {
            block14: {
                boolean bl;
                int n;
                block12: {
                    block11: {
                        block10: {
                            n = oc75d51ec7eb.\u03e9;
                            bl = oc113704e9b1.\u01fa(0x413906343A356D9L ^ 0x413906343A356BDL);
                            if (n != 0) break block10;
                            if (bl) break block11;
                            bl = oc113704e9b1.\u0270.currentScreen instanceof GuiDownloadTerrain;
                        }
                        if (n != 0) break block12;
                        if (bl) break block11;
                        bl = true;
                        break block12;
                    }
                    bl = false;
                }
                \u00d9 = bl;
                if (n != 0) break block13;
                if (\u00d9) break block14;
                oc113704e9b1.\u01af();
                return;
            }
            \u00d9 = false;
            oc113704e9b1.\u028d();
            \u00d9 = true;
        }
    }

    private static void \u028d() {
        oc613fa20ccd oc613fa20ccd2;
        long l = System.currentTimeMillis();
        int n = oc75d51ec7eb.\u03e9;
        while ((oc613fa20ccd2 = \u0107.peek()) != null) {
            block6: {
                oc613fa20ccd oc613fa20ccd3 = oc613fa20ccd2;
                if (n != 0) break block6;
                if (oc613fa20ccd3.\u0440() + \u014d > l) {
                    break;
                }
                ocd6ae010123.\u0115(oc613fa20ccd2.\u053b());
                oc613fa20ccd3 = \u0107.poll();
            }
            if (n == 0) continue;
        }
    }

    public static void \u00fd(int n, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        oc113704e9b1.\u0475(n, bl, bl2, bl3, bl4, bl5, false);
    }

    public static void \u0475(int n, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        oc113704e9b1.\u04c8(n, bl, bl2, bl3, bl4, bl5, bl6, true);
    }

    public static void \u04c8(int n, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7) {
        oc113704e9b1.\u00f2();
        R.h.\u0139(bl);
        R.\u0184.\u0139(bl2);
        R.\u0497.\u0139(bl3);
        R.\u0296.\u0139(bl4);
        R.\u0247.\u0139(bl5);
        R.\u00d3.\u0139(bl6);
        \u01a6 = bl7;
        \u014d = n;
    }
}


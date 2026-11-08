/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Deque;
import java.util.Iterator;
import x.oc47ee786826;
import x.oc75d51ec7eb;
import x.oc9ce2d650f1;

public class oc4e962be445 {
    public static int \u050d;

    private oc4e962be445() {
    }

    public static boolean \u0102(float f, float f2) {
        int n;
        block13: {
            block11: {
                float f3;
                int n2;
                block12: {
                    block10: {
                        n2 = oc75d51ec7eb.\u03e9;
                        f3 = f;
                        if (n2 != 0) break block10;
                        if (Float.isNaN(f3)) break block11;
                        f3 = f2;
                    }
                    if (n2 != 0) break block12;
                    if (Float.isNaN(f3)) break block11;
                    f3 = f2;
                }
                float f4 = f3 - f;
                n = f4 == 0.0f ? 0 : (f4 < 0.0f ? -1 : 1);
                if (n2 != 0) break block13;
                if (n >= 0) break block11;
                n = 1;
                break block13;
            }
            n = 0;
        }
        return n != 0;
    }

    public static int \u0419(int n, int n2, int n3) {
        int n4 = Math.min(n2, n3);
        int n5 = Math.max(n2, n3);
        return Math.max(n4, Math.min(n5, n));
    }

    public static boolean \u053d(boolean n, double d, double d2) {
        int n2;
        block6: {
            block8: {
                block7: {
                    int n3 = oc75d51ec7eb.\u03e9;
                    n2 = n;
                    if (n3 != 0) break block6;
                    if (n2 == 0) break block7;
                    n2 = d == d2 ? 0 : (d > d2 ? 1 : -1);
                    if (n3 != 0) break block6;
                    if (n2 < 0) break block8;
                }
                n2 = 1;
                break block6;
            }
            n2 = 0;
        }
        return n2 != 0;
    }

    public static boolean \u04f9(double d, double d2, double d3) {
        double d4;
        block2: {
            block3: {
                int n = oc75d51ec7eb.\u03e9;
                double d5 = d2 - Math.max(0.0, d3) - d;
                d4 = d5 == 0.0 ? 0 : (d5 > 0.0 ? 1 : -1);
                if (n != 0) break block2;
                if (d4 <= 0) break block3;
                d4 = 1.0;
                break block2;
            }
            d4 = 0.0;
        }
        return (boolean)d4;
    }

    public static boolean \u04ab(double d, double d2, double d3) {
        double d4;
        block8: {
            block7: {
                double d5;
                double d6;
                int n;
                block6: {
                    n = oc75d51ec7eb.\u03e9;
                    d6 = d2;
                    d5 = d3;
                    if (n != 0) break block6;
                    if (!(d6 <= d5)) break block7;
                    d6 = d;
                    d5 = d2;
                }
                double d7 = d6 - d5;
                d4 = d7 == 0.0 ? 0 : (d7 < 0.0 ? -1 : 1);
                if (n != 0) break block8;
                if (d4 > 0) break block7;
                d4 = 1.0;
                break block8;
            }
            d4 = 0.0;
        }
        return (boolean)d4;
    }

    public static boolean \u021f(boolean bl, double d, double d2, double d3, double d4) {
        int n;
        block13: {
            block11: {
                int n2;
                block12: {
                    double d5;
                    block10: {
                        n2 = oc75d51ec7eb.\u03e9;
                        double d5 = d - 6.0;
                        d5 = d5 == 0.0 ? 0 : (d5 < 0.0 ? -1 : 1);
                        if (n2 != 0) break block10;
                        if (d5 > 0) break block11;
                        n = bl;
                        if (n2 != 0) break block12;
                        d5 = (double)oc4e962be445.\u053d(n != 0, d, d2);
                    }
                    if (d5 == false) break block11;
                    double d7 = d3 - Math.max(0.0, d4);
                    n = d7 == 0.0 ? 0 : (d7 < 0.0 ? -1 : 1);
                }
                if (n2 != 0) break block13;
                if (n > 0) break block11;
                n = 1;
                break block13;
            }
            n = 0;
        }
        return n != 0;
    }

    public static void \u045c(Deque<oc47ee786826> deque, int n) {
        int n2 = Math.max(1, n);
        int n3 = oc75d51ec7eb.\u03e9;
        while (deque.size() >= n2) {
            deque.pollFirst();
            if (n3 == 0) continue;
        }
    }

    public static void \u0215(Deque<oc47ee786826> deque, long l) {
        int n = oc75d51ec7eb.\u03e9;
        while (!deque.isEmpty()) {
            block5: {
                oc47ee786826 oc47ee7868262 = deque.peekFirst();
                if (n != 0) break block5;
                if (oc47ee7868262.r() >= l) break;
                oc47ee7868262 = deque.pollFirst();
            }
            if (n == 0) continue;
        }
    }

    public static long \u0398(Iterable<oc47ee786826> iterable, oc9ce2d650f1 oc9ce2d650f12, double d, double d2) {
        Iterator<oc47ee786826> iterator2 = iterable.iterator();
        int n = oc75d51ec7eb.\u03e9;
        while (iterator2.hasNext()) {
            block9: {
                double d3;
                oc47ee786826 oc47ee7868262;
                block8: {
                    oc47ee7868262 = iterator2.next();
                    double d4 = oc9ce2d650f12.z$3ugj32ua7s1dc(oc47ee7868262);
                    d3 = d4;
                    if (n != 0) break block8;
                    if (!(d3 >= d)) break block9;
                    d3 = d4;
                }
                if (d3 <= d2) {
                    return oc47ee7868262.r();
                }
            }
            if (n == 0) continue;
        }
        return 0x3597FC606E51A561L ^ 0xCA68039F91AE5A9EL;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.awt.Color;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import x.oc668fce0dbf;
import x.oc69da1aa7f5;
import x.oc746a23b244;
import x.oca9cc61aada;
import x.ocbd4917c4b1;
import x.occ2f8dff8d8;
import x.ocd2958dac48;

public class oc08992069b4 {
    private static final String[] o;
    private static final int \u00e3 = 2;
    private static final long \u0454 = 750L;
    private final oc668fce0dbf \u040b;
    public final oca9cc61aada v = new oca9cc61aada("Block-Render", 1, o, "ESP");
    public final occ2f8dff8d8 \u03ae = new occ2f8dff8d8("Raytrace", false);
    public final oca9cc61aada \u03db = new oca9cc61aada("ESP alpha", 200.0, 0.0, 255.0, 1.0);
    public final occ2f8dff8d8 \u0234 = new occ2f8dff8d8("ESP outline", true);
    public final occ2f8dff8d8 \u037d = new occ2f8dff8d8("ESP shade", false);
    private final Map<BlockPos, Long> \u0251 = new HashMap<BlockPos, Long>();
    private MovingObjectPosition \u0292;
    public static int \u0163;

    public oc08992069b4(oc668fce0dbf oc668fce0dbf2) {
        this.\u040b = oc668fce0dbf2;
        oc668fce0dbf2.\u028c(this.v);
        oc668fce0dbf2.\u028c(this.\u03ae);
        oc668fce0dbf2.\u028c(this.\u03db);
        oc668fce0dbf2.\u028c(this.\u0234);
        oc668fce0dbf2.\u028c(this.\u037d);
    }

    public void \u03d9(boolean bl) {
        block24: {
            boolean bl2;
            block26: {
                block25: {
                    boolean bl3;
                    oca9cc61aada oca9cc61aada2;
                    int n;
                    block23: {
                        block22: {
                            block21: {
                                int n2;
                                block20: {
                                    block19: {
                                        block18: {
                                            n = \u0163;
                                            n2 = bl;
                                            if (n != 0) break block18;
                                            if (n2 == false) break block19;
                                            n2 = (int)this.v.\u04c1();
                                        }
                                        if (n != 0) break block20;
                                        if (n2 == (0xBC2A4E35 ^ 0xBC2A4E37)) break block19;
                                        n2 = 1;
                                        break block20;
                                    }
                                    n2 = false;
                                }
                                boolean bl4 = n2;
                                oca9cc61aada2 = this.v;
                                bl3 = bl;
                                if (n != 0) break block21;
                                oca9cc61aada2.\u0209(bl3, this.\u040b);
                                this.\u03ae.\u0209(bl4, this.\u040b);
                                this.\u0234.\u0209(bl4, this.\u040b);
                                this.\u037d.\u0209(bl4, this.\u040b);
                                oca9cc61aada2 = this.\u03db;
                                if (!bl4) break block22;
                                bl3 = this.\u03ae.\u01ed();
                            }
                            if (n != 0) break block23;
                            if (!bl3) break block22;
                            bl3 = true;
                            break block23;
                        }
                        bl3 = false;
                    }
                    oca9cc61aada2.\u0209(bl3, this.\u040b);
                    if (n == 0) break block24;
                    if (!false) break block25;
                    bl2 = false;
                    break block26;
                }
                bl2 = true;
            }
            oc69da1aa7f5.\u04ac = bl2;
        }
    }

    public void \u0284() {
        this.\u0251.clear();
        int n = \u0163;
        this.\u0292 = null;
        if (false) {
            \u0163 = ++n;
        }
    }

    public void \u0474(BlockPos blockPos) {
        block10: {
            Object object;
            int n;
            block11: {
                n = \u0163;
                if (blockPos == null) break block10;
                object = this;
                if (n != 0) break block11;
                if ((int)((oc08992069b4)object).v.\u04c1() == (0x1AC40DB3 ^ 0x1AC40DB1)) break block10;
                object = this;
            }
            if (n != 0 || ((oc08992069b4)object).\u03ae.\u01ed()) break block10;
            object = this.\u0251.put(blockPos, System.currentTimeMillis());
        }
    }

    public void \u00e4(oc746a23b244 oc746a23b2442) {
        block17: {
            int n;
            oc08992069b4 oc08992069b42;
            block16: {
                int n2;
                int n3;
                block18: {
                    block15: {
                        double d;
                        block14: {
                            block12: {
                                block13: {
                                    n3 = \u0163;
                                    d = this.v.\u04c1();
                                    if (n3 != 0) break block12;
                                    if ((int)d != (0xE3C5FCD5 ^ 0xE3C5FCD7)) break block13;
                                    return;
                                }
                                d = this.v.\u04c1();
                            }
                            if (n3 != 0) break block14;
                            if ((int)d != 1) break block15;
                            d = 0.0;
                        }
                        n2 = ocd2958dac48.\u016f(d);
                        break block18;
                    }
                    n2 = Color.CYAN.getRGB();
                }
                int n4 = n2;
                oc08992069b42 = this;
                n = n4;
                if (n3 != 0) break block16;
                oc08992069b42.\u0511(n);
                if (!this.\u03ae.\u01ed()) break block17;
                oc08992069b42 = this;
                n = n4;
            }
            oc08992069b42.\u042a(n);
        }
    }

    private void \u0511(int n) {
        Iterator<Map.Entry<BlockPos, Long>> iterator2 = this.\u0251.entrySet().iterator();
        long l = System.currentTimeMillis();
        int n2 = \u0163;
        while (iterator2.hasNext()) {
            block12: {
                Object object;
                int n3;
                block11: {
                    int n4;
                    Map.Entry<BlockPos, Long> entry;
                    block9: {
                        block10: {
                            entry = iterator2.next();
                            long l2 = l - entry.getValue();
                            n3 = oc08992069b4.\u0216(l2);
                            n4 = n3;
                            if (n2 != 0) break block9;
                            if (n4 > 0) break block10;
                            iterator2.remove();
                            if (n2 == 0) continue;
                        }
                        object = this;
                        if (n2 != 0) break block11;
                        n4 = ((oc08992069b4)object).\u03ae.\u01ed() ? 1 : 0;
                    }
                    if (n4 != 0) break block12;
                    object = entry.getKey();
                }
                ocbd4917c4b1.\u044c((BlockPos)object, oc08992069b4.\u0401(n, n3), this.\u0234.\u01ed(), this.\u037d.\u01ed());
            }
            if (n2 == 0) continue;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void \u042a(int n) {
        block16: {
            MovingObjectPosition movingObjectPosition;
            block17: {
                int n2;
                MovingObjectPosition movingObjectPosition2;
                block15: {
                    block14: {
                        block12: {
                            block13: {
                                MovingObjectPosition movingObjectPosition3;
                                block11: {
                                    movingObjectPosition2 = Minecraft.getMinecraft().objectMouseOver;
                                    n2 = \u0163;
                                    movingObjectPosition3 = movingObjectPosition2;
                                    if (n2 != 0) break block11;
                                    if (movingObjectPosition3 == null) break block12;
                                    movingObjectPosition3 = movingObjectPosition2;
                                }
                                if (n2 != 0) break block13;
                                if (movingObjectPosition3.typeOfHit != MovingObjectPosition.MovingObjectType.MISS) break block12;
                                movingObjectPosition3 = movingObjectPosition2 = this.\u0292;
                            }
                            if (n2 == 0) break block14;
                        }
                        this.\u0292 = movingObjectPosition2;
                    }
                    movingObjectPosition = movingObjectPosition2;
                    if (n2 != 0) break block15;
                    if (movingObjectPosition == null) break block16;
                    movingObjectPosition = movingObjectPosition2;
                }
                if (n2 != 0) break block17;
                if (movingObjectPosition.typeOfHit != MovingObjectPosition.MovingObjectType.BLOCK) break block16;
                movingObjectPosition = movingObjectPosition2;
            }
            ocbd4917c4b1.\u044c(movingObjectPosition.getBlockPos(), oc08992069b4.\u0401(n, (int)this.\u03db.\u04c1()), this.\u0234.\u01ed(), this.\u037d.\u01ed());
        }
    }

    static int \u0216(long l) {
        int n;
        block8: {
            block9: {
                long l2;
                block6: {
                    block7: {
                        int n2 = \u0163;
                        long l3 = l - 0L;
                        l2 = l3 == 0L ? 0 : (l3 < 0L ? -1 : 1);
                        if (n2 != 0) break block6;
                        if (l2 < 0) break block7;
                        long l4 = l - (0x3B5B7D989CEFAA7FL ^ 0x3B5B7D989CEFA891L);
                        n = l4 == 0L ? 0 : (l4 < 0L ? -1 : 1);
                        if (n2 != 0) break block8;
                        if (n <= 0) break block9;
                    }
                    l2 = 0;
                }
                return (int)l2;
            }
            n = (int)(210.0 - (double)l / 750.0 * 210.0);
        }
        return n;
    }

    private static int \u0401(int n, int n2) {
        return n & (0x753A5727 ^ 0x75C5A8D8) | n2 << (0x75C5A8C0 ^ 0x75C5A8D8);
    }

    static {
        String[] stringArray = new String[0x1FB0C910 ^ 0x1FB0C913];
        stringArray[0] = "Default";
        stringArray[1] = "HUD";
        stringArray[0x1FB0C911 ^ 0x1FB0C913] = "None";
        o = stringArray;
    }
}


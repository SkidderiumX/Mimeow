/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.UnaryOperator;
import x.oc2ccdd596a1;
import x.oc3094f205ad;

public class ocd289dfdfcb {
    final List<oc3094f205ad> \u03d7 = new ArrayList<oc3094f205ad>();
    final List<oc2ccdd596a1> \u051c = new ArrayList<oc2ccdd596a1>();
    final float[] Y;
    float \u02a9;
    float \u0221;
    float \u043b;
    float \u04b2;

    ocd289dfdfcb(float[] fArray, float[] fArray2, float f, float f2, boolean bl, float f3, float f4, float f5, float f6, int n, int n2, boolean bl2, boolean bl3, int n3, boolean bl4, boolean bl5, float f7, int n4) {
        this(fArray, fArray2, f, f2, bl, f3, f4, f5, f6, n, n2, bl2, bl3, n3, bl4, bl5, f7, n4, null, null);
    }

    ocd289dfdfcb(float[] fArray, float[] fArray2, float f, float f2, boolean bl, float f3, float f4, float f5, float f6, int n, int n2, boolean bl2, boolean bl3, int n3, boolean bl4, boolean bl5, float f7, int n4, boolean[] blArray, UnaryOperator<oc3094f205ad> unaryOperator) {
        int n5;
        this.Y = (float[])fArray2.clone();
        this.\u02a9 = this.\u043b = f;
        this.\u0221 = this.\u04b2 = f2;
        float f8 = f2;
        float f9 = 0.0f;
        for (n5 = 0; n5 < fArray.length; ++n5) {
            if (!(fArray2[n5] > 0.0f)) continue;
            f9 = Math.max(f9, fArray[n5]);
        }
        for (n5 = 0; n5 < fArray.length; ++n5) {
            float f10;
            float f11 = Math.max(0.0f, Math.min(1.0f, fArray2[n5]));
            if (f11 <= 0.0f) continue;
            float f12 = Math.max(bl5 ? f9 : fArray[n5], f7 - f3 * 2.0f);
            float f13 = f12 + f3 * 2.0f;
            float f14 = f10 = bl ? f + f3 - f13 : f - f3;
            int n6 = n4 == 0 ? (bl ? 0x1E18E6BD ^ 0x1E18E6BE : 1) : n4;
            float f15 = f10 + f3;
            if (n6 == (0x1E18E6BC ^ 0x1E18E6BE)) {
                f15 += (f12 - fArray[n5]) / 2.0f;
            } else if (n6 == (0x1E18E6BD ^ 0x1E18E6BE)) {
                f15 += f12 - fArray[n5];
            }
            float f16 = bl3 ? (bl ? (float)n3 - f10 + f6 : -(f10 + f13 + f6)) * (1.0f - f11) : 0.0f;
            float f17 = f13 * (bl2 ? f11 : 1.0f);
            float f18 = f + (bl ? f3 : -f3) + f16;
            float f19 = bl ? f18 - f17 : f18;
            float f20 = bl ? f18 : f18 + f17;
            float f21 = f4 * (blArray != null && !bl2 ? 1.0f : f11);
            float f22 = bl4 ? f8 - f21 : f8;
            oc3094f205ad oc3094f205ad3 = new oc3094f205ad(n5, f19, f22, f20, f22 + f21, f15 + f16, f11, bl ? f19 : f20, bl ? f20 : f19);
            if (unaryOperator != null) {
                oc3094f205ad3 = (oc3094f205ad)unaryOperator.apply(oc3094f205ad3);
            }
            this.\u03d7.add(oc3094f205ad3);
            this.\u02a9 = Math.min(this.\u02a9, oc3094f205ad3.\u0202 - f6);
            this.\u043b = Math.max(this.\u043b, oc3094f205ad3.\u04fc + f6);
            this.\u0221 = Math.min(this.\u0221, oc3094f205ad3.\u0147 - f6);
            this.\u04b2 = Math.max(this.\u04b2, oc3094f205ad3.\u00d1 + f6);
            float f23 = blArray == null ? f21 + f5 * f11 : (blArray[n5] ? f4 + f5 : 0.0f);
            f8 += (float)(bl4 ? -1 : 1) * f23;
        }
        ArrayList<oc3094f205ad> arrayList = new ArrayList<oc3094f205ad>(this.\u03d7);
        arrayList.sort(Comparator.comparingDouble(oc3094f205ad2 -> oc3094f205ad2.\u0147));
        for (int i = 0; i < arrayList.size(); ++i) {
            oc3094f205ad oc3094f205ad4;
            oc3094f205ad oc3094f205ad5 = (oc3094f205ad)arrayList.get(i);
            if (n == 1) {
                if (n2 != 1) {
                    this.\u04f7(oc3094f205ad5.\u0190, oc3094f205ad5, f6, bl);
                }
                if (n2 == 0) continue;
                this.\u04f7(oc3094f205ad5.\u02a4, oc3094f205ad5, f6, !bl);
                continue;
            }
            if (n == (0x1E18E6BA ^ 0x1E18E6BE)) {
                this.\u00fe(oc3094f205ad5.\u0202, oc3094f205ad5.\u04fc, oc3094f205ad5.\u0147 - f6, oc3094f205ad5.\u0147, oc3094f205ad5.\u01dc);
                continue;
            }
            if (n == (0x1E18E6BB ^ 0x1E18E6BE)) {
                this.\u00fe(oc3094f205ad5.\u0202, oc3094f205ad5.\u04fc, oc3094f205ad5.\u00d1, oc3094f205ad5.\u00d1 + f6, oc3094f205ad5.\u01dc);
                continue;
            }
            if (n != (0x1E18E6BC ^ 0x1E18E6BE) && n != (0x1E18E6BD ^ 0x1E18E6BE)) continue;
            this.\u04f7(oc3094f205ad5.\u02a4, oc3094f205ad5, f6, !bl);
            if (n == (0x1E18E6BD ^ 0x1E18E6BE)) {
                this.\u04f7(oc3094f205ad5.\u0190, oc3094f205ad5, f6, bl);
            }
            oc3094f205ad oc3094f205ad6 = oc3094f205ad4 = i == 0 ? null : (oc3094f205ad)arrayList.get(i - 1);
            if (oc3094f205ad4 == null || f5 > 0.0f) {
                if (n == (0x1E18E6BD ^ 0x1E18E6BE)) {
                    this.\u00fe(oc3094f205ad5.\u0202 - f6, oc3094f205ad5.\u04fc + f6, oc3094f205ad5.\u0147 - f6, oc3094f205ad5.\u0147, oc3094f205ad5.\u01dc);
                }
            } else {
                if (oc3094f205ad5.\u0147 > oc3094f205ad4.\u00d1) {
                    oc3094f205ad oc3094f205ad7 = new oc3094f205ad(oc3094f205ad4.\u01dc, oc3094f205ad4.\u0202, oc3094f205ad4.\u00d1, oc3094f205ad4.\u04fc, oc3094f205ad5.\u0147, oc3094f205ad4.J, oc3094f205ad4.\u0393, oc3094f205ad4.\u02a4, oc3094f205ad4.\u0190);
                    this.\u04f7(oc3094f205ad4.\u02a4, oc3094f205ad7, f6, !bl);
                    if (n == (0x1E18E6BD ^ 0x1E18E6BE)) {
                        this.\u04f7(oc3094f205ad4.\u0190, oc3094f205ad7, f6, bl);
                    }
                }
                this.\u02e1(oc3094f205ad4.\u02a4, oc3094f205ad5.\u02a4, oc3094f205ad5.\u0147, f6, oc3094f205ad5.\u01dc);
                if (n == (0x1E18E6BD ^ 0x1E18E6BE)) {
                    this.\u02e1(oc3094f205ad4.\u0190, oc3094f205ad5.\u0190, oc3094f205ad5.\u0147, f6, oc3094f205ad5.\u01dc);
                }
            }
            if (n != (0x1E18E6BD ^ 0x1E18E6BE) || i != arrayList.size() - 1 && !(f5 > 0.0f)) continue;
            this.\u00fe(oc3094f205ad5.\u0202 - f6, oc3094f205ad5.\u04fc + f6, oc3094f205ad5.\u00d1, oc3094f205ad5.\u00d1 + f6, oc3094f205ad5.\u01dc);
        }
    }

    private void \u04f7(float f, oc3094f205ad oc3094f205ad2, float f2, boolean bl) {
        oc2ccdd596a1 oc2ccdd596a12;
        List<oc2ccdd596a1> list = this.\u051c;
        oc2ccdd596a1 oc2ccdd596a13 = oc2ccdd596a12;
        oc2ccdd596a1 oc2ccdd596a14 = oc2ccdd596a12;
        float f3 = bl ? f : f - f2;
        oc2ccdd596a13(f3, oc3094f205ad2.\u0147, bl ? f + f2 : f, oc3094f205ad2.\u00d1, oc3094f205ad2.\u01dc);
        list.add(oc2ccdd596a14);
    }

    private void \u02e1(float f, float f2, float f3, float f4, int n) {
        if (f != f2) {
            this.\u00fe(Math.min(f, f2) - f4, Math.max(f, f2) + f4, f3 - f4, f3, n);
        }
    }

    private void \u00fe(float f, float f2, float f3, float f4, int n) {
        this.\u051c.add(new oc2ccdd596a1(f, f3, f2, f4, n));
    }
}


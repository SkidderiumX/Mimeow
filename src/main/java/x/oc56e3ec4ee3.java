/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc3004491957;
import x.oc53b6121dc1;
import x.oc66ab65400a;
import x.occ1875d4f2d;
import x.ocd63c3dcb1b;
import x.ocd78ebee979;
import x.ocf13aa48070;

public class oc56e3ec4ee3 {
    public final ocd78ebee979 \u00c2;
    public final oc66ab65400a \u01aa;
    public final byte[] \u0539;
    public final occ1875d4f2d \u043b = new occ1875d4f2d();
    public int \u0582;
    public int W;
    public int \u0110 = -1;
    public short \u0494;
    public short \u0393;
    public float \u0456;
    public float \u0568;
    public final int \u0521;
    public float \u0250;
    public float \u04f8;
    public final boolean \u00e9;
    public float \u023d;
    public float \u0279;

    public oc56e3ec4ee3(ocd78ebee979 ocd78ebee9792, float f, float f2, byte[] byArray, float f3, float f4, float f5, int n, int n2, boolean bl, float f6, float f7) {
        this.\u00c2 = ocd78ebee9792;
        this.\u0539 = (byte[])byArray.clone();
        int n3 = oc3004491957.\u0182(f3 * ocd63c3dcb1b.\u051a(0x6A315824 ^ 0x6A1A16F8));
        this.\u0494 = (short)n3;
        this.\u0393 = (short)oc3004491957.\u0182(f4);
        this.\u0456 = (float)n3 / ocd63c3dcb1b.\u051a(0x6A315824 ^ 0x6A1A16F8) / (float)ocd78ebee9792.z$3reop5w4manwh();
        this.\u0568 = f5;
        this.\u0521 = n2;
        this.\u00e9 = bl;
        this.\u023d = f6;
        this.\u0279 = f7;
        if ((n & 1) == 0) {
            if ((n & (0x6A1A16FC ^ 0x6A1A16F8)) != 0) {
                f -= ocd63c3dcb1b.\u0253(ocd78ebee9792, f, f2, byArray, byArray.length, f3, f4, f5, n, bl, f6, f7, null);
            } else if ((n & (0x6A1A16FA ^ 0x6A1A16F8)) != 0) {
                f += ocd63c3dcb1b.\u0253(ocd78ebee9792, f, f2, byArray, byArray.length, f3, f4, f5, n, bl, f6, f7, null) * ocd63c3dcb1b.\u051a(0x6A315818 ^ 0x6A1A16F8);
            }
        }
        this.\u01aa = new oc66ab65400a(f, f2 += ocd63c3dcb1b.\u0146(ocd78ebee9792, bl, n, this.\u0494, 0x6A315824 ^ 0x6A1A16F8, 0x6A31581C ^ 0x6A1A16F8, 0x6A315810 ^ 0x6A1A16F8, 0x6A315818 ^ 0x6A1A16F8, true));
        this.\u0250 = f;
        this.\u04f8 = f2;
    }

    public boolean \u04a2(oc53b6121dc1 oc53b6121dc12) {
        this.W = this.\u0582;
        if (this.\u0582 == this.\u0539.length) {
            return false;
        }
        do {
            int n;
            ++this.\u0582;
            if (!this.\u043b.\u0507(this.\u0539[n])) continue;
            this.\u0250 = this.\u01aa.\u0129;
            this.\u04f8 = this.\u01aa.\u024b;
            ocf13aa48070 ocf13aa480702 = this.\u00c2.z$ru87w5pic870(this.\u043b.\u047f, this.\u0494 & (0xC2634713 ^ 0xC263B8EC), this.\u0393, this.\u0521);
            if (ocf13aa480702 == null) {
                this.\u0110 = -1;
                break;
            }
            oc53b6121dc1 oc53b6121dc13 = ocd63c3dcb1b.\u00fb(this.\u00c2, ocf13aa480702, this.\u0110, this.\u0456, this.\u0568, this.\u01aa, this.\u00e9, this.\u023d, this.\u0279);
            oc53b6121dc12.\u0516 = oc53b6121dc13.\u0516;
            oc53b6121dc12.\u01fe = oc53b6121dc13.\u01fe;
            oc53b6121dc12.\u03dc = oc53b6121dc13.\u03dc;
            oc53b6121dc12.\u04fd = oc53b6121dc13.\u04fd;
            oc53b6121dc12.\u0570 = oc53b6121dc13.\u0570;
            oc53b6121dc12.\u0182 = oc53b6121dc13.\u0182;
            oc53b6121dc12.\u0156 = oc53b6121dc13.\u0156;
            oc53b6121dc12.\u03d1 = oc53b6121dc13.\u03d1;
            this.\u0110 = ocf13aa480702.\u04cc;
            break;
        } while (this.\u0582 != this.\u0539.length);
        return true;
    }
}


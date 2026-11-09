/*
 * Decompiled with CFR 0.152.
 */
package x;
import x.oc7ab2161b9f;
import x.oc93499ec6de;
import x.oce6044968f8;

public class oc9cd81f0bf1
{
    private final float \u0239;
    private final int \u017a;
    private final boolean \u04ef;
    private final int \u0149;
    private final float \u057e;
    private final boolean \u0463;
    private final int \u037c;
    private final float \u00e3;
    private final int \u022f;
    public static int \u04ff;

    public oc9cd81f0bf1(float f, int n, boolean bl, int n2, float f2, boolean bl2, int n3, float f3, int n4) {
        this.\u0239 = f;
        this.\u017a = n;
        this.\u04ef = bl;
        this.\u0149 = n2;
        this.\u057e = f2;
        this.\u0463 = bl2;
        this.\u037c = n3;
        this.\u00e3 = f3;
        this.\u022f = n4;
    }

    public static oc9cd81f0bf1 \u044b(float f, int n, boolean bl, boolean bl2) {
        double d;
        int n2;
        oc93499ec6de oc93499ec6de2;
        block2: {
            block3: {
                oc93499ec6de2 = oce6044968f8.\u015c();
                boolean bl3 = oce6044968f8.\u0452;
                n2 = Math.round((float)oc93499ec6de2.\u0405.\u04c1());
                double d2 = oc93499ec6de2.\u02a4.\u04c1() - 2.0;
                d = d2 == 0.0 ? 0 : (d2 > 0.0 ? 1 : -1);
                if (bl3) break block2;
                if (d != false) break block3;
                d = -1;
                break block2;
            }
            d = 0x921FE79F ^ 0x6D1FE79F;
        }
        double d3 = d;
        return new oc9cd81f0bf1(f, n, bl, (int)oc93499ec6de2.\u03f7.\u04c1(), oce6044968f8.\u018a(), bl2, (int)oc93499ec6de2.\u0517.\u04c1(), oce6044968f8.\u01f4(), oc7ab2161b9f.\u04ac((int)d3, n2));
    }

    public static oc9cd81f0bf1 \u04ce(float f, int n, boolean bl, float f2, boolean bl2, float f3) {
        return new oc9cd81f0bf1(f, n, bl, 0xF3504CF3 ^ 0xF3504CF1, f2, bl2, 0xF3504CF3 ^ 0xF3504CF1, f3, -1);
    }

    public float \u0239() {
        return this.\u0239;
    }

    public int \u017a() {
        return this.\u017a;
    }

    public boolean \u04ef() {
        return this.\u04ef;
    }

    public int \u0149() {
        return this.\u0149;
    }

    public float \u057e() {
        return this.\u057e;
    }

    public boolean \u0462() {
        return this.\u0463;
    }

    public int \u03fe() {
        return this.\u037c;
    }

    public float \u00e3() {
        return this.\u00e3;
    }

    public int \u022f() {
        return this.\u022f;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        oc9cd81f0bf1 other = (oc9cd81f0bf1)object;
        return java.util.Arrays.deepEquals(new Object[]{this.\u0239, this.\u017a, this.\u04ef, this.\u0149, this.\u057e, this.\u0463, this.\u037c, this.\u00e3, this.\u022f}, new Object[]{other.\u0239, other.\u017a, other.\u04ef, other.\u0149, other.\u057e, other.\u0463, other.\u037c, other.\u00e3, other.\u022f});
    }

    @Override
    public int hashCode() {
        return java.util.Arrays.deepHashCode(new Object[]{this.\u0239, this.\u017a, this.\u04ef, this.\u0149, this.\u057e, this.\u0463, this.\u037c, this.\u00e3, this.\u022f});
    }

    @Override
    public String toString() {
        return "oc9cd81f0bf1[\u0239" + java.util.Arrays.deepToString(new Object[]{this.\u0239}) + ", \u017a" + java.util.Arrays.deepToString(new Object[]{this.\u017a}) + ", \u04ef" + java.util.Arrays.deepToString(new Object[]{this.\u04ef}) + ", \u0149" + java.util.Arrays.deepToString(new Object[]{this.\u0149}) + ", \u057e" + java.util.Arrays.deepToString(new Object[]{this.\u057e}) + ", \u0463" + java.util.Arrays.deepToString(new Object[]{this.\u0463}) + ", \u037c" + java.util.Arrays.deepToString(new Object[]{this.\u037c}) + ", \u00e3" + java.util.Arrays.deepToString(new Object[]{this.\u00e3}) + ", \u022f" + java.util.Arrays.deepToString(new Object[]{this.\u022f}) + "]";
    }
}


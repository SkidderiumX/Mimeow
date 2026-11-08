/*
 * Decompiled with CFR 0.152.
 */
package x;

public class occddba6a30a {
    public final float \u0463;
    public final float \u04e4;
    public final float \u051d;
    public final float \u00c1;
    public final long Z;
    public final long \u01f0;
    public final long \u03dc;
    public final long \u018a;

    public occddba6a30a(int n, int n2, int n3, int n4) {
        this.Z = (long)n * (0x155C982DA95CF28AL ^ 0x4759D8063B2C3AE5L);
        this.\u01f0 = (long)n2 * (0x1ED50B213B142D50L ^ 0x4759D8063B2C3AE5L);
        this.\u03dc = (long)n3 * (0x1C95FA68A48C802EL ^ 0x4759D8063B2C3AE5L);
        this.\u018a = (long)n4 * (0x11958A21DEA36FAEL ^ 0x4759D8063B2C3AE5L);
        float f = (float)(n + n2 + n3 + n4) * -0.1381966f;
        this.\u0463 = (float)(-n) - f;
        this.\u04e4 = (float)(-n2) - f;
        this.\u051d = (float)(-n3) - f;
        this.\u00c1 = (float)(-n4) - f;
    }
}


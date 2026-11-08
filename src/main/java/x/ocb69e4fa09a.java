/*
 * Decompiled with CFR 0.152.
 */
package x;

public class ocb69e4fa09a {
    private float \u010b;
    private float \u00f4;
    private long \u00dd;
    private final long \u0252;

    public ocb69e4fa09a(long l) {
        this.\u0252 = l;
        this.\u010b = 0.0f;
        this.\u00f4 = 0.0f;
        this.\u00dd = 0L;
    }

    public void \u0234(float f) {
        this.\u010b = f;
        this.\u00f4 = f;
        this.\u00dd = 0L;
    }

    public void \u02e2(float f) {
        this.\u010b = this.\u021b();
        this.\u00f4 = f;
        this.\u00dd = System.currentTimeMillis();
    }

    public void \u024f(float f) {
        this.\u010b = this.\u021b();
        this.\u00f4 += f;
        this.\u00dd = System.currentTimeMillis();
    }

    public void \u057f(float f, float f2) {
        this.\u00f4 = Math.max(f, Math.min(f2, this.\u00f4));
    }

    public float \u021b() {
        if (this.\u00dd == 0L) {
            return this.\u00f4;
        }
        long l = System.currentTimeMillis() - this.\u00dd;
        if (l >= this.\u0252) {
            this.\u00dd = 0L;
            this.\u010b = this.\u00f4;
            return this.\u00f4;
        }
        float f = (float)l / (float)this.\u0252;
        float f2 = ocb69e4fa09a.i(f);
        return this.\u010b + (this.\u00f4 - this.\u010b) * f2;
    }

    public boolean \u0424() {
        if (this.\u00dd == 0L) {
            return false;
        }
        return System.currentTimeMillis() - this.\u00dd < this.\u0252;
    }

    public float \u0230() {
        return this.\u00f4;
    }

    private static float i(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        return 1.0f - (float)Math.pow(2.0, -10.0 * (double)f);
    }
}


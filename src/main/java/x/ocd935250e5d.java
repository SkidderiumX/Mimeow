/*
 * Decompiled with CFR 0.152.
 */
package x;

public class ocd935250e5d {
    private float \u04d6;
    private float \u0399;
    private float \u02a1;
    private long \u0507;
    private long \u046b;

    ocd935250e5d(float f) {
        this.\u04ca(f);
    }

    void \u0392(float f, long l) {
        float f2 = this.\u02b1();
        if (Math.abs(this.\u02a1 - f) < 0.001f) {
            return;
        }
        this.\u04d6 = f2;
        this.\u0399 = f2;
        this.\u02a1 = f;
        this.\u0507 = System.nanoTime();
        this.\u046b = Math.max(1L, l) * (0x6C2F3BF2D87AA295L ^ 0x6C2F3BF2D875E0D5L);
    }

    float \u02b1() {
        if (this.\u046b == 0L) {
            return this.\u04d6;
        }
        float f = Math.min(1.0f, (float)(System.nanoTime() - this.\u0507) / (float)this.\u046b);
        float f2 = 1.0f - f;
        float f3 = 1.0f - f2 * f2 * f2;
        this.\u04d6 = this.\u0399 + (this.\u02a1 - this.\u0399) * f3;
        if (f >= 1.0f || Math.abs(this.\u04d6 - this.\u02a1) < 0.01f) {
            this.\u04ca(this.\u02a1);
        }
        return this.\u04d6;
    }

    void \u04ca(float f) {
        this.\u04d6 = f;
        this.\u0399 = f;
        this.\u02a1 = f;
        this.\u0507 = 0L;
        this.\u046b = 0L;
    }
}


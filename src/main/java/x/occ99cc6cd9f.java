/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.ocaba452434e;
import x.ocf8ca79feb3;

public class occ99cc6cd9f {
    private final long \u02b3;
    private final ocaba452434e \u03b3;
    private float \u050b;
    private float \u015f;
    private long \u0147;

    occ99cc6cd9f(long l, ocaba452434e ocaba452434e2) {
        this.\u02b3 = l * (0xD2CEB2D3EA85597DL ^ 0xD2CEB2D3EA8A1B3DL);
        this.\u03b3 = ocaba452434e2;
    }

    float \u047f() {
        return this.\u00d8(System.nanoTime());
    }

    float \u00d8(long l) {
        float f = Math.max(0.0f, Math.min(1.0f, (float)(l - this.\u0147) / (float)this.\u02b3));
        float f2 = switch (ocf8ca79feb3.\u0216[this.\u03b3.ordinal()]) {
            default -> throw new IncompatibleClassChangeError();
            case 1 -> f;
            case 2 -> 1.0f - (1.0f - f) * (1.0f - f);
            case 3 -> (float)Math.sin((double)f * Math.PI * 0.5);
            case 4 -> f == 1.0f ? 1.0f : 1.0f - (float)Math.pow(2.0, -10.0f * f);
        };
        return this.\u050b + (this.\u015f - this.\u050b) * f2;
    }

    float \u0540(float f) {
        if (f != this.\u015f) {
            this.\u050b = this.\u047f();
            this.\u015f = f;
            this.\u0147 = System.nanoTime();
        }
        return this.\u047f();
    }

    void \u020e(float f) {
        this.\u050b = this.\u015f = f;
        this.\u0147 = 0L;
    }

    boolean \u01ef() {
        return System.nanoTime() - this.\u0147 >= this.\u02b3;
    }
}


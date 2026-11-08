/*
 * Decompiled with CFR 0.152.
 */
package x;

public class ocf2c1cef686 {
    public static final double \u019f = 1.0;
    private Object \u01a4;
    private double f;
    private boolean \u0580;
    private boolean \u00f9;
    private float \u054d;

    public void \u053c() {
        this.\u00f9 = false;
    }

    public boolean \u0439(Object object, boolean bl, boolean bl2, boolean bl3, boolean bl4, double d) {
        if (this.\u01a4 != null && this.\u01a4.equals(object)) {
            this.\u00f9 = true;
        }
        if (bl3 && bl && bl2) {
            if (this.\u01a4 == null || !this.\u01a4.equals(object)) {
                if (!bl4) {
                    return false;
                }
                this.\u01a4 = object;
                this.f = d;
                this.\u0580 = false;
            }
            this.\u00f9 = true;
            this.\u054d = (float)Math.max(0.0, Math.min(1.0, (d - this.f) / 1.0));
            if (!(this.\u054d < 1.0f) && !this.\u0580) {
                this.\u0580 = true;
                return true;
            }
            return false;
        }
        if (this.\u01a4 != null && this.\u01a4.equals(object)) {
            this.\u04c2();
        }
        return false;
    }

    public float \u019b(Object object) {
        return this.\u01a4 != null && this.\u01a4.equals(object) ? this.\u054d : 0.0f;
    }

    public void \u0490() {
        if (!this.\u00f9) {
            this.\u04c2();
        }
    }

    public void \u04c2() {
        this.\u01a4 = null;
        this.\u054d = 0.0f;
        this.\u0580 = false;
        this.\u00f9 = false;
    }
}


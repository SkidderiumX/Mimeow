/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.nio.charset.StandardCharsets;

public class oc8654f25207 {
    private final byte[] \u0479;
    private int \u03e2;

    public oc8654f25207(int n) {
        this.\u0479 = new byte[n];
    }

    public boolean C(String string) {
        byte[] byArray = string.getBytes(StandardCharsets.UTF_8);
        if (this.\u03e2 < this.\u0479.length && byArray.length < this.\u0479.length - this.\u03e2) {
            System.arraycopy(byArray, 0, this.\u0479, this.\u03e2, byArray.length);
            this.\u03e2 += byArray.length;
            return true;
        }
        return false;
    }

    public boolean \u0476(String string) {
        byte[] byArray = string.getBytes(StandardCharsets.UTF_8);
        if (this.\u03e2 >= this.\u0479.length) {
            return false;
        }
        if (byArray.length >= this.\u0479.length - this.\u03e2) {
            this.\u03e2 = this.\u0479.length;
            return false;
        }
        System.arraycopy(byArray, 0, this.\u0479, this.\u03e2, byArray.length);
        this.\u03e2 += byArray.length;
        return true;
    }

    public boolean \u02a4(int n) {
        if (this.\u03e2 >= this.\u0479.length) {
            return false;
        }
        this.\u0479[this.\u03e2++] = (byte)n;
        return true;
    }

    public String \u01d4() {
        if (this.\u03e2 >= this.\u0479.length) {
            return null;
        }
        this.\u0479[this.\u03e2++] = 0;
        return new String(this.\u0479, 0, this.\u03e2 - 1, StandardCharsets.UTF_8);
    }

    public int \u011f() {
        return this.\u03e2;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.nio.charset.StandardCharsets;

public class oc6f44315029 {
    public String \u0143;
    public float \u0226;
    public float \u0199;
    public float \u03d6;
    public boolean \u026c;

    public void \u0537(String string, int n, int n2) {
        byte[] byArray = string.getBytes(StandardCharsets.UTF_8);
        this.\u0143 = new String(byArray, 0, Math.min(byArray.length, 0x229DE8D8 ^ 0x229DE8BC), StandardCharsets.UTF_8);
        this.\u0226 = n;
        this.\u0199 = n2;
        this.\u026c = true;
    }
}


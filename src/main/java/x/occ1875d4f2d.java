/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.ocd63c3dcb1b;

public class occ1875d4f2d {
    public int \u054d;
    public int \u047f;

    public boolean \u0507(int n) {
        int n2 = ocd63c3dcb1b.\u0129((0xD20AF4FB ^ 0xD22195AB) + (n &= 0xD2219554 ^ 0xD22195AB));
        this.\u047f = this.\u054d != 0 ? this.\u047f << (0xD22195AD ^ 0xD22195AB) | n & (0xD2219594 ^ 0xD22195AB) : (0xD2219554 ^ 0xD22195AB) >>> (n2 & (0xD22195B4 ^ 0xD22195AB)) & n;
        this.\u054d = ocd63c3dcb1b.\u0129((0xD20AF7FB ^ 0xD22195AB) + this.\u054d + n2);
        return this.\u054d == 0;
    }
}


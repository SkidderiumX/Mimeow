/*
 * Decompiled with CFR 0.152.
 */
package x;

public class ocbb1bc27172 {
    public static final ocbb1bc27172 \u00e4 = new ocbb1bc27172(false, "", "", "", "", "", "", "", false, false, "off", 0L, 0L, System.currentTimeMillis());
    private final boolean \u0267;
    private final boolean \u04d5;
    private final boolean \u03f7;
    private final String \u0504;
    private final String H;
    private final String \u0256;
    private final String \u04ce;
    private final String \u03d2;
    private final String \u00ec;
    private final String \u04cf;
    private final String \u011c;
    private final String \u0443;
    private final long \u0235;
    private final long \u0245;
    private final long \u0194;
    public static int \u050d;

    public ocbb1bc27172(boolean bl, String string, String string2, String string3, String string4) {
        this(bl, string, string2, "", string3, string4, "", "", false, false, "off", 0L, 0L, System.currentTimeMillis());
    }

    public ocbb1bc27172(boolean bl, String string, String string2, String string3, String string4, String string5, String string6, String string7, boolean bl2, boolean bl3, String string8, long l, long l2, long l3) {
        this.\u0267 = bl;
        this.\u0504 = ocbb1bc27172.\u0562(string);
        this.H = ocbb1bc27172.\u0562(string2);
        this.\u0256 = ocbb1bc27172.\u0562(string3);
        this.\u04ce = ocbb1bc27172.\u0562(string4);
        this.\u03d2 = ocbb1bc27172.\u0562(string5);
        this.\u00ec = ocbb1bc27172.\u0562(string6);
        this.\u04cf = ocbb1bc27172.\u0562(string7);
        this.\u011c = "";
        this.\u04d5 = bl2;
        this.\u03f7 = bl3;
        this.\u0443 = ocbb1bc27172.\u0562(string8);
        this.\u0235 = Math.max(0L, l);
        this.\u0245 = Math.max(0L, l2);
        this.\u0194 = Math.max(0L, l3);
    }

    private static String \u0562(String string) {
        String string2 = string == null ? "" : string;
        return string2;
    }

    public boolean \u04dc() {
        return this.\u0267;
    }

    public String \u051f() {
        return this.\u0504;
    }

    public String \u03e7() {
        return this.H;
    }

    public String \u0577() {
        return this.\u0256;
    }

    public String \u027a() {
        return this.\u04ce;
    }

    public String B() {
        return this.\u03d2;
    }

    public String \u00d8() {
        return this.\u00ec;
    }

    public String f() {
        return this.\u04cf;
    }

    public String \u01fa() {
        return this.\u011c;
    }

    public boolean \u00c1() {
        return this.\u04d5;
    }

    public boolean \u0247() {
        return this.\u03f7;
    }

    public String \u0434() {
        return this.\u0443;
    }

    public long \u028e() {
        return this.\u0245;
    }

    public long \u0574() {
        return this.\u0194;
    }

    public long \u03bd(long l) {
        long l2;
        block8: {
            long l3;
            block7: {
                ocbb1bc27172 ocbb1bc271722;
                block6: {
                    int n = \u050d;
                    long l4 = this.\u0235;
                    long l5 = this.\u0267 ? Math.max(0L, l - this.\u0194) : 0L;
                    l3 = l4 + l5;
                    ocbb1bc271722 = this;
                    if (n != 0) break block6;
                    if (ocbb1bc271722.\u0245 <= 0L) break block7;
                    ocbb1bc271722 = this;
                }
                l2 = Math.min(ocbb1bc271722.\u0245, l3);
                break block8;
            }
            l2 = l3;
        }
        return l2;
    }
}


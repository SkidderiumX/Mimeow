/*
 * Decompiled with CFR 0.152.
 */
package x;

public class oc804fdd8d75 {
    public static final String \u03f1 = "premium";
    public static final String \u02af = "cracked";
    public static final String \u022e = "cookie";
    public static final String \u0547 = "token";
    public static final String \u0255 = "session";
    public static final String \u04e8 = "refresh";
    private String \u0162;
    private String \u03c0;
    private String \u0492;
    private long \u04d2;
    private String \u0206;
    private String \u0291;
    private String \u0152;
    private String \u02e3;
    private long \u0245;
    private long \u0232;
    private String \u03a0;
    public static int \u0186;

    public oc804fdd8d75(String string, String string2, String string3, String string4, String string5) {
        this(string, string2, string3, 0L, string4, string5, "premium");
    }

    public oc804fdd8d75(String string, String string2, String string3, long l, String string4, String string5) {
        this(string, string2, string3, l, string4, string5, "premium");
    }

    public oc804fdd8d75(String string, String string2, String string3, long l, String string4, String string5, String string6) {
        this(string, string2, string3, l, string4, string5, string6, "", 0L, 0L);
    }

    public oc804fdd8d75(String string, String string2, String string3, long l, String string4, String string5, String string6, String string7, long l2, long l3) {
        this(string, string2, string3, l, string4, string5, string6, string7, l2, l3, "");
    }

    public oc804fdd8d75(String string, String string2, String string3, long l, String string4, String string5, String string6, String string7, long l2, long l3, String string8) {
        this.\u03c0 = string2;
        this.\u0162 = string;
        this.\u0492 = string3;
        this.\u04d2 = l;
        this.\u0206 = string4;
        this.\u0291 = string5;
        this.\u0152 = string6 == null || string6.isEmpty() ? "premium" : string6;
        this.\u02e3 = string7 == null ? "" : string7;
        this.\u0245 = Math.max(0L, l2);
        this.\u0232 = Math.max(0L, l3);
        this.\u03a0 = string8 == null ? "" : string8;
    }

    public static oc804fdd8d75 \u04de(String string) {
        return new oc804fdd8d75("", "", string, 0L, "", "", "cracked");
    }

    public String \u04b0() {
        return this.\u0206;
    }

    public String \u02b3() {
        return this.\u0291;
    }

    public String \u01e3() {
        return this.\u0162;
    }

    public String \u0106() {
        return this.\u03c0;
    }

    public String \u014c() {
        return this.\u0492;
    }

    public long \u028f() {
        return this.\u04d2;
    }

    public String \u017c() {
        return this.\u0152;
    }

    public String \u04fc() {
        return this.\u02e3;
    }

    public long \u038e() {
        return this.\u0245;
    }

    public long B() {
        return this.\u0232;
    }

    public String \u0222() {
        return this.\u03a0;
    }

    public boolean \u049e() {
        return "cracked".equals(this.\u0152);
    }

    public void \u04d0(String string) {
        this.\u0162 = string;
    }

    public void \u04cc(String string) {
        this.\u03c0 = string;
    }

    public void \u024a(String string) {
        this.\u0492 = string;
    }

    public void \u041f(long l) {
        this.\u04d2 = l;
    }

    public void \u0531(String string) {
        this.\u0206 = string;
    }

    public void \u0274(String string) {
        this.\u0291 = string;
    }

    public void \u0200(String string) {
        String string2;
        block8: {
            block10: {
                block9: {
                    int n = \u0186;
                    oc804fdd8d75 oc804fdd8d752 = this;
                    string2 = string;
                    if (n != 0) break block8;
                    if (string2 == null) break block9;
                    string2 = string;
                    if (n != 0) break block8;
                    if (!string2.isEmpty()) break block10;
                }
                string2 = "premium";
                break block8;
            }
            string2 = string;
        }
        oc804fdd8d752.\u0152 = string2;
    }

    public void \u0473(String string) {
        String string2;
        block2: {
            block3: {
                int n = \u0186;
                oc804fdd8d75 oc804fdd8d752 = this;
                string2 = string;
                if (n != 0) break block2;
                if (string2 != null) break block3;
                string2 = "";
                break block2;
            }
            string2 = string;
        }
        oc804fdd8d752.\u02e3 = string2;
    }

    public void \u0226(long l) {
        this.\u0245 = Math.max(0L, l);
    }

    public void \u0163(long l) {
        this.\u0232 = Math.max(0L, l);
    }

    public void \u01e7(String string) {
        String string2;
        block2: {
            block3: {
                int n = \u0186;
                oc804fdd8d75 oc804fdd8d752 = this;
                string2 = string;
                if (n != 0) break block2;
                if (string2 != null) break block3;
                string2 = "";
                break block2;
            }
            string2 = string;
        }
        oc804fdd8d752.\u03a0 = string2;
    }

    public void \u04d8(long l) {
        if (l > 0L) {
            this.\u0232 += l;
        }
    }
}


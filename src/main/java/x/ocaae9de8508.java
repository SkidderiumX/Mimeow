/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc161f4adba4;

public class ocaae9de8508 {
    private final String \u02c1;
    private final String \u00de;
    private final String[] \u054e;
    public static int \u053c;

    public ocaae9de8508(String string, String string2, String[] stringArray) {
        this.\u02c1 = string == null ? "" : string;
        this.\u00de = string2 == null ? "" : string2;
        this.\u054e = stringArray == null ? new String[]{} : (String[])stringArray.clone();
    }

    public String \u03cd() {
        return this.\u02c1;
    }

    public String q() {
        return this.\u00de;
    }

    public int \u04fe() {
        return this.\u054e.length;
    }

    public String[] \u0443() {
        return (String[])this.\u054e.clone();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String \u044c(int n) {
        int n2;
        block4: {
            int n3 = oc161f4adba4.\u04a7;
            n2 = n;
            if (n3 != 0) break block4;
            if (n2 < 0) return null;
            n2 = n;
        }
        if (n2 < this.\u054e.length) return this.\u054e[n];
        return null;
    }

    public boolean \u0144(int n) {
        int n2;
        block8: {
            block7: {
                int n3;
                block6: {
                    n3 = oc161f4adba4.\u04a7;
                    n2 = n;
                    if (n3 != 0) break block6;
                    if (n2 < 0) break block7;
                    n2 = n;
                }
                if (n3 != 0) break block8;
                if (n2 >= this.\u054e.length) break block7;
                n2 = 1;
                break block8;
            }
            n2 = 0;
        }
        return n2 != 0;
    }

    public boolean \u014e(int n, String string) {
        boolean bl;
        block9: {
            block7: {
                String string2;
                int n2;
                block8: {
                    String string3;
                    block6: {
                        string3 = this.\u044c(n);
                        n2 = oc161f4adba4.\u04a7;
                        string2 = string3;
                        if (n2 != 0) break block6;
                        if (string2 == null) break block7;
                        string2 = string;
                    }
                    if (n2 != 0) break block8;
                    if (string2 == null) break block7;
                    string2 = string3;
                }
                bl = string2.equalsIgnoreCase(string);
                if (n2 != 0) break block9;
                if (!bl) break block7;
                bl = true;
                break block9;
            }
            bl = false;
        }
        return bl;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String \u037a(int n) {
        StringBuilder stringBuilder;
        int n2;
        int n3;
        block12: {
            n3 = oc161f4adba4.\u04a7;
            n2 = n;
            if (n3 != 0) break block12;
            if (n2 < 0) return "";
            n2 = n;
        }
        if (n2 >= this.\u054e.length) {
            return "";
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        for (int i = n; i < this.\u054e.length; ++i) {
            block13: {
                stringBuilder = stringBuilder2;
                if (n3 != 0) return stringBuilder.toString();
                if (n3 != 0) continue;
                if (stringBuilder.length() <= 0) break block13;
                stringBuilder2.append((char)(0x540D74CB ^ 0x540D74EB));
            }
            stringBuilder2.append(this.\u054e[i]);
            if (n3 == 0) continue;
        }
        stringBuilder = stringBuilder2;
        return stringBuilder.toString();
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.occ0b63c0426;

public class oc809b444fec {
    public static int \u0235;

    public String \u0103(String string) {
        return occ0b63c0426.\u03bb(string);
    }

    public double \u0273(double d, double d2) {
        return d + Math.random() * (d2 - d);
    }

    public String \u04f3(String string) {
        String string2;
        block6: {
            String string3;
            block4: {
                block5: {
                    int n = occ0b63c0426.\u039f;
                    string3 = string;
                    if (n != 0) break block4;
                    if (string3 != null) break block5;
                    string2 = "";
                    break block6;
                }
                string3 = string;
            }
            string2 = string3.replaceAll("\\u00a7[0-9a-fk-or]", "");
        }
        return string2;
    }

    public double \u037d(double d, int n) {
        double d2 = Math.pow(10.0, Math.max(0, n));
        return (double)Math.round(d * d2) / d2;
    }

    public int \u03c3(int n, int n2) {
        int n3;
        block2: {
            block3: {
                int n4 = occ0b63c0426.\u039f;
                n3 = n2;
                if (n4 != 0) break block2;
                if (n3 >= n) break block3;
                int n5 = n;
                n = n2;
                n2 = n5;
            }
            n3 = n + (int)Math.floor(Math.random() * (double)(n2 - n + 1));
        }
        return n3;
    }
}


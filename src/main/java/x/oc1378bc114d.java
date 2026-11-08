/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.ocd9533bdf8b;

public interface oc1378bc114d {
    public int z$ao2ykh4tuw6w(String var1, float var2, float var3, int var4, boolean var5);

    public int z$22eyp2803ejhs(String var1, float var2, float var3, ocd9533bdf8b var4, boolean var5);

    default public int z$rqv994f7nhin(String string, float f, float f2, int n) {
        return this.z$ao2ykh4tuw6w(string, f, f2, n, false);
    }

    default public int z$2cydkrybcloqp(String string, float f, float f2, ocd9533bdf8b ocd9533bdf8b2) {
        return this.z$22eyp2803ejhs(string, f, f2, ocd9533bdf8b2, false);
    }

    default public int z$1vws8s1usg1n1(String string, float f, float f2, int n) {
        return this.z$ao2ykh4tuw6w(string, f, f2, n, true);
    }

    public int z$toz8pt08w0nc(String var1);

    default public String z$6okofawej3do(String string, int n) {
        if (string == null || string.isEmpty() || n <= 0) {
            return "";
        }
        int n2 = 0;
        while (n2 < string.length()) {
            int n3 = n2 + Character.charCount(string.codePointAt(n2));
            if (string.charAt(n2) == (0xEF2E3485 ^ 0xEF2E3422) && n3 < string.length()) {
                ++n3;
            }
            if (this.z$toz8pt08w0nc(string.substring(0, n3)) > n) break;
            n2 = n3;
        }
        return string.substring(0, n2);
    }

    default public String z$2j2vbn478r8gg(String string, int n, boolean bl) {
        int n2;
        if (!bl) {
            return this.z$6okofawej3do(string, n);
        }
        if (string == null || n <= 0) {
            return "";
        }
        int n3 = string.length();
        while (n3 > 0 && this.z$toz8pt08w0nc(string.substring(n2 = string.offsetByCodePoints(n3, -1))) <= n) {
            n3 = n2;
        }
        return string.substring(n3);
    }

    public int z$1tqmx4tpnr6lq();

    default public int z$3hte9fh87zo6x() {
        return this.z$1tqmx4tpnr6lq();
    }

    default public float z$3l314uvjy8lta() {
        return this.z$3hte9fh87zo6x();
    }

    default public int z$g5bxucc1j700() {
        return 0;
    }

    default public int z$w1h9nvoglpkn() {
        return this.z$1tqmx4tpnr6lq();
    }

    default public void z$2l4c667g0mutb() {
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc151419fdfe;

public enum oc373d6c4e35 {
    \u03cd("text"),
    \u0425("image");
    private static final oc373d6c4e35[] $VALUES_REF;
    static {
        $VALUES_REF = oc373d6c4e35.\u0524();
    }


    private final String \u03aa;
public static int \u0255;



    private oc373d6c4e35(String string2) {
        this.\u03aa = string2;
    }

    static oc373d6c4e35 \u021e(String string) {
        oc373d6c4e35 oc373d6c4e352;
        block11: {
            block10: {
                String string2;
                boolean bl;
                block9: {
                    bl = oc151419fdfe.v;
                    string2 = string;
                    if (bl) break block9;
                    if (string2 == null) break block10;
                    string2 = string.trim();
                }
                String string3 = string2;
                oc373d6c4e35[] oc373d6c4e35Array = oc373d6c4e35.values();
                int n = oc373d6c4e35Array.length;
                int n2 = 0;
                while (n2 < n) {
                    block12: {
                        block13: {
                            oc373d6c4e352 = oc373d6c4e35Array[n2];
                            if (bl) break block11;
                            oc373d6c4e35 oc373d6c4e353 = oc373d6c4e352;
                            if (bl) break block12;
                            if (!oc373d6c4e353.\u03aa.equalsIgnoreCase(string3)) break block13;
                            return oc373d6c4e353;
                        }
                        ++n2;
                    }
                    if (!bl) continue;
                }
            }
            oc373d6c4e352 = \u03cd;
        }
        return oc373d6c4e352;
    }

    private static oc373d6c4e35[] \u0524() {
        oc373d6c4e35[] oc373d6c4e35Array = new oc373d6c4e35[0x93FA7FA7 ^ 0x93FA7FA5];
        oc373d6c4e35Array[0] = \u03cd;
        oc373d6c4e35Array[1] = \u0425;
        return oc373d6c4e35Array;
    }
}


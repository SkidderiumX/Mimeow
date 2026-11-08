/*
 * Decompiled with CFR 0.152.
 */
package x;

public enum oc32fdd3a6bd {
    \u01dd(1, -1),
    \u03a9(0xCE794045 ^ 0xCE794047, 0x3186BF12 ^ 0xCE794047),
    \u054c(0xCE794044 ^ 0xCE794047, 0x312CBFB8 ^ 0xCE794047),
    \u01be(0xCE794043 ^ 0xCE794047, 0x312CBF12 ^ 0xCE794047);
    private static final oc32fdd3a6bd[] $VALUES_REF;
    static {
        $VALUES_REF = oc32fdd3a6bd.\u0278();
    }




    private final int \u023c;
    private final int \u04d8;


    private oc32fdd3a6bd(int n2, int n3) {
        this.\u023c = n2;
        this.\u04d8 = n3;
    }

    private static oc32fdd3a6bd[] \u0278() {
        oc32fdd3a6bd[] oc32fdd3a6bdArray = new oc32fdd3a6bd[0x5D2681C ^ 0x5D26818];
        oc32fdd3a6bdArray[0] = \u01dd;
        oc32fdd3a6bdArray[1] = \u03a9;
        oc32fdd3a6bdArray[0x5D2681A ^ 0x5D26818] = \u054c;
        oc32fdd3a6bdArray[0x5D2681B ^ 0x5D26818] = \u01be;
        return oc32fdd3a6bdArray;
    }
}


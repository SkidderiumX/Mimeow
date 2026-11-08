/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc9e5a7eeec6;

public enum ocd26b62219b {
    \u0423("Official", oc9e5a7eeec6.\u044d),
    \u02a5("Local", null),
    \u0582("User", oc9e5a7eeec6.\u00fd);
    private static final ocd26b62219b[] $VALUES_REF;
    static {
        $VALUES_REF = ocd26b62219b.\u02a9();
    }



    private final String \u00df;
    private final oc9e5a7eeec6 \u03c4;


    private ocd26b62219b(String string2, oc9e5a7eeec6 oc9e5a7eeec62) {
        this.\u00df = string2;
        this.\u03c4 = oc9e5a7eeec62;
    }

    private static ocd26b62219b[] \u02a9() {
        ocd26b62219b[] ocd26b62219bArray = new ocd26b62219b[0x51520617 ^ 0x51520614];
        ocd26b62219bArray[0] = \u0423;
        ocd26b62219bArray[1] = \u02a5;
        ocd26b62219bArray[0x51520616 ^ 0x51520614] = \u0582;
        return ocd26b62219bArray;
    }
}


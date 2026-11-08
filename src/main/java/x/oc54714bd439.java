/*
 * Decompiled with CFR 0.152.
 */
package x;

public enum oc54714bd439 {
    x, d, r;
    private static final oc54714bd439[] $VALUES_REF;
    public static final /* enum */ oc54714bd439 \u013b = new oc54714bd439((char)(0x1055F28E ^ 0x1055F2BE), 0xEF55F2BE ^ 0x1055F2BE);
    public static final /* enum */ oc54714bd439 \u00c8 = new oc54714bd439((char)(0x1055F28F ^ 0x1055F2BE), 0xEF55F214 ^ 0x1055F2BE);
    public static final /* enum */ oc54714bd439 \u04e3 = new oc54714bd439((char)(0x1055F28C ^ 0x1055F2BE), 0xEF5558BE ^ 0x1055F2BE);
    public static final /* enum */ oc54714bd439 \u014e = new oc54714bd439((char)(0x1055F28D ^ 0x1055F2BE), 0xEF555814 ^ 0x1055F2BE);
    public static final /* enum */ oc54714bd439 \u053e = new oc54714bd439((char)(0x1055F28A ^ 0x1055F2BE), 0xEFFFF2BE ^ 0x1055F2BE);
    public static final /* enum */ oc54714bd439 \u0481 = new oc54714bd439((char)(0x1055F28B ^ 0x1055F2BE), 0xEFFFF214 ^ 0x1055F2BE);
    public static final /* enum */ oc54714bd439 \u020a = new oc54714bd439((char)(0x1055F288 ^ 0x1055F2BE), 0xEFAA58BE ^ 0x1055F2BE);
    public static final /* enum */ oc54714bd439 \u0167 = new oc54714bd439((char)(0x1055F289 ^ 0x1055F2BE), 0xEFFF5814 ^ 0x1055F2BE);
    public static final /* enum */ oc54714bd439 \u03fa = new oc54714bd439((char)(0x1055F286 ^ 0x1055F2BE), 0xEF00A7EB ^ 0x1055F2BE);
    public static final /* enum */ oc54714bd439 \u047e = new oc54714bd439((char)(0x1055F287 ^ 0x1055F2BE), 0xEF00A741 ^ 0x1055F2BE);
    public static final /* enum */ oc54714bd439 \u01d9 = new oc54714bd439((char)(0x1055F2DF ^ 0x1055F2BE), 0xEF000DEB ^ 0x1055F2BE);
    public static final /* enum */ oc54714bd439 \u00e0 = new oc54714bd439((char)(0x1055F2DC ^ 0x1055F2BE), 0xEF000D41 ^ 0x1055F2BE);
    public static final /* enum */ oc54714bd439 \u0539 = new oc54714bd439((char)(0x1055F2DD ^ 0x1055F2BE), 0xEFAAA7EB ^ 0x1055F2BE);

    public static final /* enum */ oc54714bd439 \u017f = new oc54714bd439((char)(0x1055F2DB ^ 0x1055F2BE), 0xEFAA0DEB ^ 0x1055F2BE);

    public static final /* enum */ oc54714bd439 \u0392 = new oc54714bd439((char)(0x1055F2D5 ^ 0x1055F2BE), 0);
    public static final /* enum */ oc54714bd439 \u04a4 = new oc54714bd439((char)(0x1055F2D2 ^ 0x1055F2BE), 0);

    public static final /* enum */ oc54714bd439 \u0173 = new oc54714bd439((char)(0x1055F2D0 ^ 0x1055F2BE), 0);
    public static final /* enum */ oc54714bd439 \u026a = new oc54714bd439((char)(0x1055F2D1 ^ 0x1055F2BE), 0);
    public static final /* enum */ oc54714bd439 \u0232 = new oc54714bd439((char)(0x1055F2CC ^ 0x1055F2BE), 0);
    private final String \u011e;
    private final int \u04d3;
    public static final char \u0418 = '\u00a7';
    private static final /* synthetic */ oc54714bd439[] \u03bc;
    public static int \u0563;



    private oc54714bd439(char c, int n2) {
        this.\u04d3 = n2;
        char[] cArray = new char[0x979DC24C ^ 0x979DC24E];
        cArray[0] = 0x979DC2E9 ^ 0x979DC24E;
        cArray[1] = c;
        this.\u011e = new String(cArray);
    }

    public int \u0467() {
        return this.\u04d3;
    }

    public static String \u01e4(String string) {
        char[] cArray = string.toCharArray();
        int n = \u0563;
        for (int i = 0; i < cArray.length - 1; ++i) {
            int n2;
            block9: {
                n2 = cArray[i];
                if (n != 0) break block9;
                if (n2 != (0x915E1F39 ^ 0x915E1F1F)) continue;
                n2 = "0123456789AaBbCcDdEeFfKkLlMmNnOoRr".indexOf(cArray[i + 1]);
            }
            if (n2 <= -1) continue;
            cArray[i] = 0x915E1FB8 ^ 0x915E1F1F;
            cArray[i + 1] = Character.toLowerCase(cArray[i + 1]);
            continue;
        }
        return new String(cArray);
    }

    public String toString() {
        return this.\u011e;
    }

    private static /* synthetic */ oc54714bd439[] \u041e() {
        oc54714bd439[] oc54714bd439Array = new oc54714bd439[0xC5CF5A7F ^ 0xC5CF5A69];
        oc54714bd439Array[0] = \u013b;
        oc54714bd439Array[1] = \u00c8;
        oc54714bd439Array[0xC5CF5A6B ^ 0xC5CF5A69] = \u04e3;
        oc54714bd439Array[0xC5CF5A6A ^ 0xC5CF5A69] = \u014e;
        oc54714bd439Array[0xC5CF5A6D ^ 0xC5CF5A69] = \u053e;
        oc54714bd439Array[0xC5CF5A6C ^ 0xC5CF5A69] = \u0481;
        oc54714bd439Array[0xC5CF5A6F ^ 0xC5CF5A69] = \u020a;
        oc54714bd439Array[0xC5CF5A6E ^ 0xC5CF5A69] = \u0167;
        oc54714bd439Array[0xC5CF5A61 ^ 0xC5CF5A69] = \u03fa;
        oc54714bd439Array[0xC5CF5A60 ^ 0xC5CF5A69] = \u047e;
        oc54714bd439Array[0xC5CF5A63 ^ 0xC5CF5A69] = \u01d9;
        oc54714bd439Array[0xC5CF5A62 ^ 0xC5CF5A69] = \u00e0;
        oc54714bd439Array[0xC5CF5A65 ^ 0xC5CF5A69] = \u0539;
        oc54714bd439Array[0xC5CF5A64 ^ 0xC5CF5A69] = x;
        oc54714bd439Array[0xC5CF5A67 ^ 0xC5CF5A69] = \u017f;
        oc54714bd439Array[0xC5CF5A66 ^ 0xC5CF5A69] = d;
        oc54714bd439Array[0xC5CF5A79 ^ 0xC5CF5A69] = \u0392;
        oc54714bd439Array[0xC5CF5A78 ^ 0xC5CF5A69] = \u04a4;
        oc54714bd439Array[0xC5CF5A7B ^ 0xC5CF5A69] = r;
        oc54714bd439Array[0xC5CF5A7A ^ 0xC5CF5A69] = \u0173;
        oc54714bd439Array[0xC5CF5A7D ^ 0xC5CF5A69] = \u026a;
        oc54714bd439Array[0xC5CF5A7C ^ 0xC5CF5A69] = \u0232;
        return oc54714bd439Array;
    }

    static {
        \u03bc = oc54714bd439.\u041e();
    }
}


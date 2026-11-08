/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import x.oc1e7298eef6;
import x.ocac488f5520;
import x.occ4282ca4a7;
import x.ocd9db3ede42;

public class ocefb3475d27 {
    private static final byte[] E = ocefb3475d27.\u02aa();
    private static final int \u04d6 = oc1e7298eef6.\u011f();

    private static byte[] \u02aa() {
        byte[] byArray;
        block10: {
            byte[] byArray2 = new byte[0x1956BCA6 ^ 0x1956A5A6];
            InputStream inputStream2 = occ4282ca4a7.\u026b("/assets/slinkysemantic/profile-icon-coverage.bin");
            try {
                int n;
                if (inputStream2 == null) {
                    throw new IOException("Profile icon coverage is missing");
                }
                for (int i = 0; i < byArray2.length; i += n) {
                    n = inputStream2.read(byArray2, i, byArray2.length - i);
                    if (n >= 0) continue;
                    throw new IOException("Incomplete profile icon atlas");
                }
                byArray = byArray2;
                if (inputStream2 == null) break block10;
            }
            catch (Throwable throwable) {
                try {
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        }
                        catch (Throwable throwable2) {
                            throwable.addSuppressed(throwable2);
                        }
                    }
                    throw throwable;
                }
                catch (IOException iOException) {
                    throw new IllegalStateException("Cannot load profile icons", iOException);
                }
            }
            inputStream2.close();
        }
        return byArray;
    }

    public static void \u023f(ocac488f5520 ocac488f55202, ocd9db3ede42 ocd9db3ede422, int n, boolean bl, boolean bl2) {
        float f = (float)n / 4.0f;
        float f2 = (float)(n + 1) / 4.0f;
        float f3 = ocd9db3ede422.\u00c8;
        float f4 = ocd9db3ede422.\u0151;
        float f5 = f3 + ocd9db3ede422.\u0423;
        float f6 = f4 + ocd9db3ede422.\u0462;
        int n2 = n == (0x8D912C47 ^ 0x8D912C44) ? (!bl ? 0x72E90169 ^ 0x8D912C44 : (bl2 ? 0x727E731B ^ 0x8D912C44 : 0x724C6B03 ^ 0x8D912C44)) : (!bl ? 0x72C77A12 ^ 0x8D912C44 : (bl2 ? 0x724AF79F ^ 0x8D912C44 : 0x7208B5DD ^ 0x8D912C44));
        float[][] fArrayArray = new float[0x8D912C42 ^ 0x8D912C44][];
        float[] fArray = new float[0x8D912C40 ^ 0x8D912C44];
        fArray[0] = f3;
        fArray[1] = f4;
        fArray[0x8D912C46 ^ 0x8D912C44] = f;
        fArray[0x8D912C47 ^ 0x8D912C44] = 0.0f;
        fArrayArray[0] = fArray;
        float[] fArray2 = new float[0x8D912C40 ^ 0x8D912C44];
        fArray2[0] = f5;
        fArray2[1] = f6;
        fArray2[0x8D912C46 ^ 0x8D912C44] = f2;
        fArray2[0x8D912C47 ^ 0x8D912C44] = 1.0f;
        fArrayArray[1] = fArray2;
        float[] fArray3 = new float[0x8D912C40 ^ 0x8D912C44];
        fArray3[0] = f5;
        fArray3[1] = f4;
        fArray3[0x8D912C46 ^ 0x8D912C44] = f2;
        fArray3[0x8D912C47 ^ 0x8D912C44] = 0.0f;
        fArrayArray[0x8D912C46 ^ 0x8D912C44] = fArray3;
        float[] fArray4 = new float[0x8D912C40 ^ 0x8D912C44];
        fArray4[0] = f3;
        fArray4[1] = f4;
        fArray4[0x8D912C46 ^ 0x8D912C44] = f;
        fArray4[0x8D912C47 ^ 0x8D912C44] = 0.0f;
        fArrayArray[0x8D912C47 ^ 0x8D912C44] = fArray4;
        float[] fArray5 = new float[0x8D912C40 ^ 0x8D912C44];
        fArray5[0] = f3;
        fArray5[1] = f6;
        fArray5[0x8D912C46 ^ 0x8D912C44] = f;
        fArray5[0x8D912C47 ^ 0x8D912C44] = 1.0f;
        fArrayArray[0x8D912C40 ^ 0x8D912C44] = fArray5;
        float[] fArray6 = new float[0x8D912C40 ^ 0x8D912C44];
        fArray6[0] = f5;
        fArray6[1] = f6;
        fArray6[0x8D912C46 ^ 0x8D912C44] = f2;
        fArray6[0x8D912C47 ^ 0x8D912C44] = 1.0f;
        fArrayArray[0x8D912C41 ^ 0x8D912C44] = fArray6;
        ocac488f55202.\u01ff(\u04d6, 0x8D912CE4 ^ 0x8D912C44, 0x8D912C6C ^ 0x8D912C44, E, Arrays.asList(fArrayArray), n2);
    }

    private ocefb3475d27() {
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package x;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import x.oc318edb7d10;
import x.occ4282ca4a7;
import x.ocf2ca791e23;

public class ocbb22f5c593 {
    private static final Map<Integer, byte[]> \u0538 = ocbb22f5c593.\u03ef();
    private static final oc318edb7d10 \u023b = (byArray, l, n) -> {
        String string = new String(byArray, StandardCharsets.UTF_8).replace("%lld", "%d");
        byte[] byArray2 = String.format(Locale.ROOT, string, l).getBytes(StandardCharsets.UTF_8);
        return Arrays.copyOf(byArray2, Math.min(byArray2.length, n - 1));
    };

    private ocbb22f5c593() {
    }

    private static Map<Integer, byte[]> \u03ef() {
        HashMap<Integer, byte[]> hashMap;
        HashMap<Integer, byte[]> hashMap2 = new HashMap<Integer, byte[]>();
        InputStream inputStream2 = occ4282ca4a7.\u026b("/assets/slinkysemantic/ProfileLabels.json");
        if (inputStream2 == null) {
            throw new IllegalStateException("Missing immutable profile labels");
        }
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream2, "UTF-8");
        try {
            for (JsonElement jsonElement : new JsonParser().parse(inputStreamReader).getAsJsonArray()) {
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                String string = jsonObject.get("bytes").getAsString();
                byte[] byArray = new byte[string.length() / (0xCAE0C7A9 ^ 0xCAE0C7AB)];
                for (int i = 0; i < byArray.length; ++i) {
                    byArray[i] = (byte)Integer.parseInt(string.substring((0xCAE0C7A9 ^ 0xCAE0C7AB) * i, (0xCAE0C7A9 ^ 0xCAE0C7AB) * i + (0xCAE0C7A9 ^ 0xCAE0C7AB)), 0xCAE0C7BB ^ 0xCAE0C7AB);
                }
                hashMap2.put(jsonObject.get("rva").getAsInt(), byArray);
            }
            hashMap = hashMap2;
        }
        catch (Throwable throwable) {
            try {
                try {
                    ((Reader)inputStreamReader).close();
                }
                catch (Throwable throwable2) {
                    throwable.addSuppressed(throwable2);
                }
                throw throwable;
            }
            catch (IOException iOException) {
                throw new ExceptionInInitializerError(iOException);
            }
        }
        ((Reader)inputStreamReader).close();
        return hashMap;
    }

    public static long \u0436(long l, long l2) {
        return Long.compareUnsigned(l2 - 1L, l) >= 0 ? 0xE518EAD138C75EA2L ^ 0x1AE7152EC738A15DL : ocf2ca791e23.\u0490(l - l2, 0xCC5881FB2242E3E0L ^ 0x1AE7152EC738A15DL) >>> (0x3E35A4D0 ^ 0x3E35A4C7);
    }

    public static long \u0515(long l) {
        long l2 = ocf2ca791e23.\u020f(l, 0x44080F0A0CFB4E7CL ^ 0x5C4DC7AAC2AA672BL);
        return (l2 >> (0xE0CE1427 ^ 0xE0CE142A)) + (l2 >>> (0xE0CE1415 ^ 0xE0CE142A));
    }

    public static byte[] \u0131(long l, oc318edb7d10 oc318edb7d102) {
        byte[] byArray = new byte[0xDE02FCE2 ^ 0xDE02FCC2];
        if (l == (0xE2984B0A3D47D4C9L ^ 0x1D67B4F5C2B82B36L)) {
            System.arraycopy(\u0538.get(0xDE1103BC ^ 0xDE02FCC2), 0, byArray, 0, 0xDE02FCD2 ^ 0xDE02FCC2);
            byte[] byArray2 = new byte[0xDE02FCCA ^ 0xDE02FCC2];
            byArray2[0] = 0xDE02FCB6 ^ 0xDE02FCC2;
            byArray2[1] = 0xDE02FCAB ^ 0xDE02FCC2;
            byArray2[0xDE02FCC0 ^ 0xDE02FCC2] = 0xDE02FCAD ^ 0xDE02FCC2;
            byArray2[0xDE02FCC1 ^ 0xDE02FCC2] = 0xDE02FCAC ^ 0xDE02FCC2;
            byArray2[0xDE02FCC6 ^ 0xDE02FCC2] = 0xDE02FCE2 ^ 0xDE02FCC2;
            byArray2[0xDE02FCC7 ^ 0xDE02FCC2] = 0xDE02FCA6 ^ 0xDE02FCC2;
            byArray2[0xDE02FCC4 ^ 0xDE02FCC2] = 0xDE02FCA3 ^ 0xDE02FCC2;
            byArray2[0xDE02FCC5 ^ 0xDE02FCC2] = 0xDE02FCB6 ^ 0xDE02FCC2;
            byte[] byArray3 = byArray2;
            System.arraycopy(byArray3, 0, byArray, 0xDE02FCD2 ^ 0xDE02FCC2, byArray3.length);
        } else {
            long l2 = ocbb22f5c593.\u0515(l);
            if (l2 == 1L) {
                System.arraycopy(\u0538.get(0xDE110373 ^ 0xDE02FCC2), 0, byArray, 0, 0xDE02FCD2 ^ 0xDE02FCC2);
                byArray[0xDE02FCD2 ^ 0xDE02FCC2] = 0xDE02FCA5 ^ 0xDE02FCC2;
                byArray[0xDE02FCD3 ^ 0xDE02FCC2] = 0xDE02FCAD ^ 0xDE02FCC2;
                byArray[0xDE02FCD0 ^ 0xDE02FCC2] = 0xDE02FCEC ^ 0xDE02FCC2;
            } else if (l2 == 0L) {
                System.arraycopy(\u0538.get(0xDE11030B ^ 0xDE02FCC2), 0, byArray, 0, 0xDE02FCD2 ^ 0xDE02FCC2);
            } else {
                byte[] byArray4 = oc318edb7d102.z$1qgwb65m65ul6(ocbb22f5c593.D(\u0538.get(0xDE11035B ^ 0xDE02FCC2)), l2, 0xDE02FCDB ^ 0xDE02FCC2);
                System.arraycopy(byArray4, 0, byArray, 0, Math.min(byArray4.length, 0xDE02FCDA ^ 0xDE02FCC2));
            }
        }
        return byArray;
    }

    public static String \u0410(long l) {
        return new String(ocbb22f5c593.D(ocbb22f5c593.\u0131(l, \u023b)), StandardCharsets.UTF_8);
    }

    private static byte[] D(byte[] byArray) {
        int n;
        for (n = 0; n < byArray.length && byArray[n] != 0; ++n) {
        }
        return Arrays.copyOf(byArray, n);
    }

    public static int \u00e5(String string, String string2) {
        byte[] byArray = string.getBytes(StandardCharsets.UTF_8);
        byte[] byArray2 = string2.getBytes(StandardCharsets.UTF_8);
        int n = 0;
        while (true) {
            int n2;
            int n3 = n < byArray.length ? byArray[n] & (0xCA74556B ^ 0xCA745594) : 0;
            int n4 = n2 = n < byArray2.length ? byArray2[n] & (0xCA74556B ^ 0xCA745594) : 0;
            if (n3 != n2) {
                return n3 - n2;
            }
            if (n3 == 0) {
                return 0;
            }
            ++n;
        }
    }
}


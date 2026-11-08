/*
 * Decompiled with CFR 0.152.
 */
package x;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import x.oc01be0c7606;

public class ocd857d42ebe {
    private static final Map<Integer, Byte> \u03eb = new HashMap<Integer, Byte>();
    public static int \u0504;

    private ocd857d42ebe() {
    }

    private static long \u03a3(int n, int n2) {
        long l = 0L;
        int n3 = oc01be0c7606.\u017a;
        int n4 = 0;
        while (n4 < n2) {
            block5: {
                Byte by;
                block6: {
                    by = \u03eb.get(n + n4);
                    if (n3 != 0) break block5;
                    if (by != null) break block6;
                    throw new IllegalArgumentException("Unrecovered numerical operand " + Integer.toHexString(n + n4));
                }
                l |= (long)(by & (0x2DF5AE53 ^ 0x2DF5AEAC)) << n4 * (0x2DF5AEA4 ^ 0x2DF5AEAC);
                ++n4;
            }
            if (n3 == 0) continue;
        }
        return l;
    }

    public static int \u00d3(int n) {
        return (int)ocd857d42ebe.\u03a3(n, 0x93B31841 ^ 0x93B31843);
    }

    public static int \u0522(int n) {
        return (int)ocd857d42ebe.\u03a3(n, 0xF2402E31 ^ 0xF2402E35);
    }

    public static long h(int n) {
        return ocd857d42ebe.\u03a3(n, 0x83D995F1 ^ 0x83D995F9);
    }

    public static float \u0284(int n) {
        return Float.intBitsToFloat(ocd857d42ebe.\u0522(n));
    }

    public static double \u049c(int n) {
        return Double.longBitsToDouble(ocd857d42ebe.h(n));
    }

    static {
        try (InputStreamReader inputStreamReader = new InputStreamReader(ocd857d42ebe.class.getResourceAsStream("/assets/slinkysemantic/NumericConstants.json"), "UTF-8");){
            for (JsonElement jsonElement : new JsonParser().parse(inputStreamReader).getAsJsonArray()) {
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                int n = jsonObject.get("address").getAsInt();
                String string = jsonObject.get("bytes").getAsString();
                for (int i = 0; i < string.length() / (0x47BF53BA ^ 0x47BF53B8); ++i) {
                    \u03eb.put(n + i, (byte)Integer.parseInt(string.substring(i * (0x47BF53BA ^ 0x47BF53B8), i * (0x47BF53BA ^ 0x47BF53B8) + (0x47BF53BA ^ 0x47BF53B8)), 0x47BF53A8 ^ 0x47BF53B8));
                }
            }
        }
        catch (IOException iOException) {
            throw new ExceptionInInitializerError(iOException);
        }
    }
}


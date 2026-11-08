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
import x.oc69da1aa7f5;

public class ocb112cc87f6 {
    private static final Map<Integer, Byte> \u01f4 = new HashMap<Integer, Byte>();
    public static int \u03c8;

    private ocb112cc87f6() {
    }

    private static long \u01ba(int n, int n2) {
        long l = 0L;
        int n3 = oc69da1aa7f5.\u04f5;
        int n4 = 0;
        while (n4 < n2) {
            block5: {
                Byte by;
                block6: {
                    by = \u01f4.get(n + n4);
                    if (n3 != 0) break block5;
                    if (by != null) break block6;
                    throw new IllegalArgumentException("Unrecovered action operand " + Integer.toHexString(n + n4));
                }
                l |= (long)(by & (0x1F1E0909 ^ 0x1F1E09F6)) << (0x1F1E09FE ^ 0x1F1E09F6) * n4;
                ++n4;
            }
            if (n3 == 0) continue;
        }
        return l;
    }

    public static byte \u02e2(int n) {
        return (byte)ocb112cc87f6.\u01ba(n, 1);
    }

    public static int \u0209(int n) {
        return (int)ocb112cc87f6.\u01ba(n, 0x5693F0D ^ 0x5693F0F);
    }

    public static int \u0288(int n) {
        return (int)ocb112cc87f6.\u01ba(n, 0xB698BA8F ^ 0xB698BA8B);
    }

    public static long \u0219(int n) {
        return ocb112cc87f6.\u01ba(n, 0xA9C92908 ^ 0xA9C92900);
    }

    public static float \u0193(int n) {
        return Float.intBitsToFloat(ocb112cc87f6.\u0288(n));
    }

    public static double \u03a4(int n) {
        return Double.longBitsToDouble(ocb112cc87f6.\u0219(n));
    }

    static {
        try (InputStreamReader inputStreamReader = new InputStreamReader(ocb112cc87f6.class.getResourceAsStream("/assets/slinkysemantic/ActionConstants.json"), "UTF-8");){
            for (JsonElement jsonElement : new JsonParser().parse(inputStreamReader).getAsJsonArray()) {
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                int n = jsonObject.get("address").getAsInt();
                String string = jsonObject.get("bytes").getAsString();
                for (int i = 0; i < string.length() / (0x621E97A4 ^ 0x621E97A6); ++i) {
                    \u01f4.put(n + i, (byte)Integer.parseInt(string.substring(i * (0x621E97A4 ^ 0x621E97A6), i * (0x621E97A4 ^ 0x621E97A6) + (0x621E97A4 ^ 0x621E97A6)), 0x621E97B6 ^ 0x621E97A6));
                }
            }
        }
        catch (IOException iOException) {
            throw new ExceptionInInitializerError(iOException);
        }
    }
}


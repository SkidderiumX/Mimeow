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
import x.occ4282ca4a7;

public class ocd8ecc8a91a {
    private static final Map<Integer, Byte> \u0154 = new HashMap<Integer, Byte>();

    private ocd8ecc8a91a() {
    }

    private static long \u01ec(int n, int n2) {
        long l = 0L;
        for (int i = 0; i < n2; ++i) {
            Byte by = \u0154.get(n + i);
            if (by == null) {
                throw new IllegalArgumentException("Unrecovered numerical operand " + Integer.toHexString(n + i));
            }
            l |= (long)(by & (0xF2CEE6F5 ^ 0xF2CEE60A)) << i * (0xF2CEE602 ^ 0xF2CEE60A);
        }
        return l;
    }

    public static int \u0575(int n) {
        return (int)ocd8ecc8a91a.\u01ec(n, 0xFB4BB8E7 ^ 0xFB4BB8E5);
    }

    public static int K(int n) {
        return (int)ocd8ecc8a91a.\u01ec(n, 0x47F3DC97 ^ 0x47F3DC93);
    }

    public static long \u0147(int n) {
        return ocd8ecc8a91a.\u01ec(n, 0x7864BF67 ^ 0x7864BF6F);
    }

    public static float \u027e(int n) {
        return Float.intBitsToFloat(ocd8ecc8a91a.K(n));
    }

    public static double \u042d(int n) {
        return Double.longBitsToDouble(ocd8ecc8a91a.\u0147(n));
    }

    static {
        try (InputStreamReader inputStreamReader = new InputStreamReader(occ4282ca4a7.\u026b("/assets/slinkysemantic/NumericConstants.json"), "UTF-8");){
            for (JsonElement jsonElement : new JsonParser().parse(inputStreamReader).getAsJsonArray()) {
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                int n = jsonObject.get("address").getAsInt();
                String string = jsonObject.get("bytes").getAsString();
                for (int i = 0; i < string.length() / (0x7B0D913A ^ 0x7B0D9138); ++i) {
                    \u0154.put(n + i, (byte)Integer.parseInt(string.substring(i * (0x7B0D913A ^ 0x7B0D9138), i * (0x7B0D913A ^ 0x7B0D9138) + (0x7B0D913A ^ 0x7B0D9138)), 0x7B0D9128 ^ 0x7B0D9138));
                }
            }
        }
        catch (IOException iOException) {
            throw new ExceptionInInitializerError(iOException);
        }
    }
}


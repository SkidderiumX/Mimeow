/*
 * Decompiled with CFR 0.152.
 */
package x;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import x.occ4282ca4a7;

public class L {
    private static final Map<Integer, byte[]> \u0462 = new LinkedHashMap<Integer, byte[]>();
    private static final long P = L.\u0194();
    private static final ConcurrentHashMap<Integer, String> \u03e6;

    private static long \u0194() {
        long l;
        InputStreamReader inputStreamReader = new InputStreamReader(occ4282ca4a7.\u026b("/assets/slinkysemantic/MetadataCatalog.json"), "UTF-8");
        try {
            l = Long.decode(new JsonParser().parse(inputStreamReader).getAsJsonObject().get("runtime_base").getAsString());
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
        return l;
    }

    private L() {
    }

    private static ByteBuffer \u0284(int n, int n2) {
        for (Map.Entry<Integer, byte[]> entry : \u0462.entrySet()) {
            int n3 = n - entry.getKey();
            if (n3 < 0 || n3 + n2 > entry.getValue().length) continue;
            return ByteBuffer.wrap(entry.getValue(), n3, n2).order(ByteOrder.LITTLE_ENDIAN);
        }
        throw new IllegalArgumentException("Uncaptured immutable drawing operand 0x" + Integer.toHexString(n));
    }

    public static int \u0497(int n) {
        return L.\u0284(n, 0xB3A84CC8 ^ 0xB3A84CCC).getInt();
    }

    public static long \u0253(int n) {
        return L.\u0284(n, 0x2699D043 ^ 0x2699D04B).getLong();
    }

    public static float \u026d(int n) {
        return L.\u0284(n, 0x99BA87D3 ^ 0x99BA87D7).getFloat();
    }

    public static double \u0239(int n) {
        return L.\u0284(n, 0xEC328FFB ^ 0xEC328FF3).getDouble();
    }

    public static int \u0473(int n) {
        return L.\u0284(n, 0x6D9F449C ^ 0x6D9F449E).getShort() & (0x6D9FBB61 ^ 0x6D9F449E);
    }

    public static String \u00f2(int n) {
        String string = \u03e6.get(n);
        if (string == null) {
            string = L.\u0231(n);
            \u03e6.put(n, string);
        }
        return string;
    }

    private static String \u0231(int n) {
        int n2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i < (0x4E59A90E ^ 0x4E59A80E) && (n2 = L.\u0284(n + i, 1).get() & (0x4E59A8F1 ^ 0x4E59A80E)) != 0; ++i) {
            byteArrayOutputStream.write(n2);
        }
        try {
            return new String(byteArrayOutputStream.toByteArray(), "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new AssertionError((Object)unsupportedEncodingException);
        }
    }

    public static String \u0216(int n) {
        long l = L.\u0253(n);
        return l == 0L ? null : L.\u00f2((int)(l - P));
    }

    static {
        try (InputStreamReader inputStreamReader = new InputStreamReader(occ4282ca4a7.\u026b("/assets/slinkysemantic/RenderConstants.json"), "UTF-8");){
            for (JsonElement jsonElement : new JsonParser().parse(inputStreamReader).getAsJsonArray()) {
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                String string = jsonObject.get("bytes").getAsString();
                byte[] byArray = new byte[string.length() / (0x8336EF7F ^ 0x8336EF7D)];
                for (int i = 0; i < byArray.length; ++i) {
                    byArray[i] = (byte)Integer.parseInt(string.substring(i * (0x8336EF7F ^ 0x8336EF7D), i * (0x8336EF7F ^ 0x8336EF7D) + (0x8336EF7F ^ 0x8336EF7D)), 0x8336EF6D ^ 0x8336EF7D);
                }
                \u0462.put(jsonObject.get("address").getAsInt(), byArray);
            }
        }
        catch (IOException iOException) {
            throw new ExceptionInInitializerError(iOException);
        }
        \u03e6 = new ConcurrentHashMap();
    }
}


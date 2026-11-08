/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.lang.invoke.CallSite;
import java.lang.invoke.ConstantCallSite;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class b59c7670e8ba07bcf {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static byte[] m20qiwv9mrlxvy(MethodHandles.Lookup lookup, String string, long l) throws Exception {
        byte[] byArray;
        byte[] byArray2;
        block4: {
            byArray2 = Base64.getUrlDecoder().decode(string);
            byte[] byArray3 = null;
            try {
                if (byArray2.length < 28) {
                    throw new BootstrapMethodError();
                }
                byArray3 = b59c7670e8ba07bcf.msvlyr5l5tzgu(lookup, l);
                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                cipher.init(2, (Key)new SecretKeySpec(byArray3, "AES"), new GCMParameterSpec(128, byArray2, 0, 12));
                cipher.updateAAD(b59c7670e8ba07bcf.m6l83bvrwnqha(lookup));
                byArray = cipher.doFinal(byArray2, 12, byArray2.length - 12);
                if (byArray3 == null) break block4;
            }
            catch (Throwable throwable) {
                if (byArray3 != null) {
                    Arrays.fill(byArray3, (byte)0);
                }
                Arrays.fill(byArray2, (byte)0);
                throw throwable;
            }
            Arrays.fill(byArray3, (byte)0);
        }
        Arrays.fill(byArray2, (byte)0);
        return byArray;
    }

    private static Class<?> m2cqgb48prhkni(MethodHandles.Lookup lookup) throws IllegalAccessException {
        return lookup.lookupClass().isHidden() ? MethodHandles.classData(lookup, "_", Class.class) : lookup.lookupClass();
    }

    public static CallSite m3r61ybwsr63f2(MethodHandles.Lookup lookup, String string, MethodType methodType, String string2, long l) throws Exception {
        byte[] byArray = b59c7670e8ba07bcf.m20qiwv9mrlxvy(lookup, string2, l);
        try {
            int n = 0;
            if (methodType.parameterCount() != 0) {
                throw new BootstrapMethodError();
            }
            if (methodType.returnType() == Integer.TYPE && byArray.length == 4) {
                ConstantCallSite constantCallSite = new ConstantCallSite(MethodHandles.constant(Integer.TYPE, ByteBuffer.wrap(byArray).order(n == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN).getInt()));
                return constantCallSite;
            }
            if (methodType.returnType() == Long.TYPE && byArray.length == 8) {
                ConstantCallSite constantCallSite = new ConstantCallSite(MethodHandles.constant(Long.TYPE, ByteBuffer.wrap(byArray).order(n == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN).getLong()));
                return constantCallSite;
            }
            throw new BootstrapMethodError();
        }
        finally {
            Arrays.fill(byArray, (byte)0);
        }
    }

    private b59c7670e8ba07bcf() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static byte[] msvlyr5l5tzgu(MethodHandles.Lookup lookup, long l) throws Exception {
        byte[] byArray;
        byte[] byArray2 = ByteBuffer.allocate(16).putLong(0x3F2F84670FF9A6ADL ^ 0x477A1E6F3441C4B7L).putLong(0x181DC2728807F471L ^ 0x54F60C80634897A5L).array();
        byte[] byArray3 = null;
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(ByteBuffer.allocate(8).putLong(l).array(), "HmacSHA256"));
            byArray3 = mac.doFinal(byArray2);
            mac.init(new SecretKeySpec(byArray3, "HmacSHA256"));
            mac.update(b59c7670e8ba07bcf.m6l83bvrwnqha(lookup));
            byArray = mac.doFinal(new byte[]{1});
        }
        catch (Throwable throwable) {
            Arrays.fill(byArray2, (byte)0);
            if (byArray3 != null) {
                Arrays.fill(byArray3, (byte)0);
            }
            throw throwable;
        }
        Arrays.fill(byArray2, (byte)0);
        if (byArray3 != null) {
            Arrays.fill(byArray3, (byte)0);
        }
        return byArray;
    }

    private static byte[] m6l83bvrwnqha(MethodHandles.Lookup lookup) throws Exception {
        int n = 2;
        return ("Miau/binding/v2\u0000" + b59c7670e8ba07bcf.class.getName() + "\u0000" + n + "\u0000" + b59c7670e8ba07bcf.m2cqgb48prhkni(lookup).getName()).getBytes(StandardCharsets.UTF_8);
    }
}


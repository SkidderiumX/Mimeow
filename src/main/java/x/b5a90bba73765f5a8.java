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

public final class b5a90bba73765f5a8 {
    private static byte[] m3nwip9xa4baml(MethodHandles.Lookup lookup) throws Exception {
        int n = 2;
        return ("Miau/binding/v2\u0000" + b5a90bba73765f5a8.class.getName() + "\u0000" + n + "\u0000" + b5a90bba73765f5a8.m1jwusc4dw27il(lookup).getName()).getBytes(StandardCharsets.UTF_8);
    }

    private static Class<?> m1jwusc4dw27il(MethodHandles.Lookup lookup) throws IllegalAccessException {
        return lookup.lookupClass().isHidden() ? MethodHandles.classData(lookup, "_", Class.class) : lookup.lookupClass();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static byte[] m25u9nx5mgetu5(MethodHandles.Lookup lookup, String string, long l) throws Exception {
        byte[] byArray;
        byte[] byArray2;
        byte[] byArray3;
        byte[] byArray4;
        byte[] byArray5;
        block13: {
            byte[] byArray6;
            byArray5 = Base64.getUrlDecoder().decode(string);
            byArray4 = null;
            byArray3 = new byte[12];
            byArray2 = null;
            byArray = null;
            try {
                if (byArray5.length < 28) {
                    throw new BootstrapMethodError();
                }
                System.arraycopy(byArray5, 0, byArray3, 0, 6);
                System.arraycopy(byArray5, byArray5.length - 6, byArray3, 6, 6);
                byArray4 = b5a90bba73765f5a8.m31olity8iu4y5(lookup, l);
                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                cipher.init(2, (Key)new SecretKeySpec(byArray4, "AES"), new GCMParameterSpec(128, byArray3));
                cipher.updateAAD(b5a90bba73765f5a8.m3nwip9xa4baml(lookup));
                int n = (byArray5.length - 12) / 2;
                byArray2 = cipher.update(byArray5, 6, n);
                byArray = cipher.doFinal(byArray5, 6 + n, byArray5.length - 12 - n);
                if (byArray2 != null && byArray2.length != 0) break block13;
                byte[] byArray7 = byArray;
                byArray = null;
                byArray6 = byArray7;
            }
            catch (Throwable throwable) {
                Arrays.fill(byArray5, (byte)0);
                Arrays.fill(byArray3, (byte)0);
                if (byArray4 != null) {
                    Arrays.fill(byArray4, (byte)0);
                }
                if (byArray2 != null) {
                    Arrays.fill(byArray2, (byte)0);
                }
                if (byArray != null) {
                    Arrays.fill(byArray, (byte)0);
                }
                throw throwable;
            }
            Arrays.fill(byArray5, (byte)0);
            Arrays.fill(byArray3, (byte)0);
            if (byArray4 != null) {
                Arrays.fill(byArray4, (byte)0);
            }
            if (byArray2 != null) {
                Arrays.fill(byArray2, (byte)0);
            }
            if (byArray != null) {
                Arrays.fill(byArray, (byte)0);
            }
            return byArray6;
        }
        byte[] byArray8 = Arrays.copyOf(byArray2, byArray2.length + byArray.length);
        System.arraycopy(byArray, 0, byArray8, byArray2.length, byArray.length);
        byte[] byArray9 = byArray8;
        Arrays.fill(byArray5, (byte)0);
        Arrays.fill(byArray3, (byte)0);
        if (byArray4 != null) {
            Arrays.fill(byArray4, (byte)0);
        }
        if (byArray2 != null) {
            Arrays.fill(byArray2, (byte)0);
        }
        if (byArray != null) {
            Arrays.fill(byArray, (byte)0);
        }
        return byArray9;
    }

    public static CallSite m5h3lrp7vgtxp(MethodHandles.Lookup lookup, String string, MethodType methodType, String string2, long l) throws Exception {
        byte[] byArray = b5a90bba73765f5a8.m25u9nx5mgetu5(lookup, string2, l);
        try {
            int n = 2;
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

    private b5a90bba73765f5a8() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static byte[] m31olity8iu4y5(MethodHandles.Lookup lookup, long l) throws Exception {
        byte[] byArray;
        byte[] byArray2 = ByteBuffer.allocate(16).putLong(0x24CDD9C1364CE542L ^ 0x80B4797205B09DFCL).putLong(0x6083861A28990A3DL ^ 0xCA2CD6951EE340EL).array();
        byte[] byArray3 = null;
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(ByteBuffer.allocate(8).putLong(l).array(), "HmacSHA256"));
            byArray3 = mac.doFinal(byArray2);
            mac.init(new SecretKeySpec(byArray3, "HmacSHA256"));
            mac.update(b5a90bba73765f5a8.m3nwip9xa4baml(lookup));
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
}


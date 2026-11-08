/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.lang.invoke.CallSite;
import java.lang.invoke.ConstantCallSite;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.StringConcatFactory;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class b80ab192a1accd3d0 {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static byte[] m1c519emdu7mh1(MethodHandles.Lookup lookup, long l) throws Exception {
        byte[] byArray;
        byte[] byArray2 = ByteBuffer.allocate(16).putLong(0x334152B65B97F2FAL ^ 0x44FD2CBA1ACC3B99L).putLong(0xF7CDF9BBDAE2532AL ^ 0xD79EFB82F389E5CCL).array();
        byte[] byArray3 = null;
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(ByteBuffer.allocate(8).putLong(l).array(), "HmacSHA256"));
            byArray3 = mac.doFinal(byArray2);
            mac.init(new SecretKeySpec(byArray3, "HmacSHA256"));
            mac.update(b80ab192a1accd3d0.m1oyg2ifnzvced(lookup));
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

    private b80ab192a1accd3d0() {
    }

    private static byte[] m1oyg2ifnzvced(MethodHandles.Lookup lookup) throws Exception {
        int n = 0;
        return ("Miau/binding/v2\u0000" + b80ab192a1accd3d0.class.getName() + "\u0000" + n + "\u0000" + b80ab192a1accd3d0.m3smzi10otj5hh(lookup).getName()).getBytes(StandardCharsets.UTF_8);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static byte[] m9mtcnj5wo7et(MethodHandles.Lookup lookup, String string, long l) throws Exception {
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
                byArray4 = b80ab192a1accd3d0.m1c519emdu7mh1(lookup, l);
                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                cipher.init(2, (Key)new SecretKeySpec(byArray4, "AES"), new GCMParameterSpec(128, byArray3));
                cipher.updateAAD(b80ab192a1accd3d0.m1oyg2ifnzvced(lookup));
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static CallSite m1ey2t8n4dwrd1(MethodHandles.Lookup lookup, String string, MethodType methodType, String string2, long l) throws Exception {
        if (methodType.parameterCount() != 0 || methodType.returnType() != String.class) {
            throw new BootstrapMethodError();
        }
        byte[] byArray = b80ab192a1accd3d0.m9mtcnj5wo7et(lookup, string2, l);
        try {
            ConstantCallSite constantCallSite = new ConstantCallSite(MethodHandles.constant(String.class, new String(byArray, StandardCharsets.UTF_8).intern()));
            return constantCallSite;
        }
        finally {
            Arrays.fill(byArray, (byte)0);
        }
    }

    private static Class<?> m3smzi10otj5hh(MethodHandles.Lookup lookup) throws IllegalAccessException {
        return lookup.lookupClass().isHidden() ? MethodHandles.classData(lookup, "_", Class.class) : lookup.lookupClass();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static CallSite m3s7qk6wz7tqpx(MethodHandles.Lookup lookup, String string, MethodType methodType, String string2, long l, Object ... objectArray) throws Exception {
        byte[] byArray = b80ab192a1accd3d0.m9mtcnj5wo7et(lookup, string2, l);
        try {
            CallSite callSite = StringConcatFactory.makeConcatWithConstants(lookup, string, methodType, new String(byArray, StandardCharsets.UTF_8), objectArray);
            return callSite;
        }
        finally {
            Arrays.fill(byArray, (byte)0);
        }
    }
}


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

public final class bc231f7e06f455557 {
    private static byte[] m10cnm0zbfgrri(MethodHandles.Lookup lookup) throws Exception {
        int n = 2;
        return ("Miau/binding/v2\u0000" + bc231f7e06f455557.class.getName() + "\u0000" + n + "\u0000" + bc231f7e06f455557.m38f7kt77wip3i(lookup).getName()).getBytes(StandardCharsets.UTF_8);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static byte[] mx7azjesufp8u(MethodHandles.Lookup lookup, String string, long l) throws Exception {
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
                byArray4 = bc231f7e06f455557.m1v8gwr9n238ge(lookup, l);
                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                cipher.init(2, (Key)new SecretKeySpec(byArray4, "AES"), new GCMParameterSpec(128, byArray3));
                cipher.updateAAD(bc231f7e06f455557.m10cnm0zbfgrri(lookup));
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
    private static byte[] m1v8gwr9n238ge(MethodHandles.Lookup lookup, long l) throws Exception {
        byte[] byArray;
        byte[] byArray2 = ByteBuffer.allocate(16).putLong(0xA837B6995B2245F6L ^ 0xB08A8FAF26140FEEL).putLong(0x791EBBC6E29A4279L ^ 0x1B723795B64E93EFL).array();
        byte[] byArray3 = null;
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(ByteBuffer.allocate(8).putLong(l).array(), "HmacSHA256"));
            byArray3 = mac.doFinal(byArray2);
            mac.init(new SecretKeySpec(byArray3, "HmacSHA256"));
            mac.update(bc231f7e06f455557.m10cnm0zbfgrri(lookup));
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

    private bc231f7e06f455557() {
    }

    public static CallSite m2t0ycjj96xw9a(MethodHandles.Lookup lookup, String string, MethodType methodType, String string2, long l) throws Exception {
        byte[] byArray = bc231f7e06f455557.mx7azjesufp8u(lookup, string2, l);
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

    private static Class<?> m38f7kt77wip3i(MethodHandles.Lookup lookup) throws IllegalAccessException {
        return lookup.lookupClass().isHidden() ? MethodHandles.classData(lookup, "_", Class.class) : lookup.lookupClass();
    }
}


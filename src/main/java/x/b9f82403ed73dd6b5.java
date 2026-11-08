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

public final class b9f82403ed73dd6b5 {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static byte[] m7oedsv2zzoow(MethodHandles.Lookup lookup, long l) throws Exception {
        byte[] byArray;
        byte[] byArray2 = ByteBuffer.allocate(16).putLong(-2000164755381423642L + -4175878287585517660L).putLong(4651541282836924763L + 7187837887996045807L).array();
        byte[] byArray3 = null;
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(ByteBuffer.allocate(8).putLong(l).array(), "HmacSHA256"));
            byArray3 = mac.doFinal(byArray2);
            mac.init(new SecretKeySpec(byArray3, "HmacSHA256"));
            mac.update(b9f82403ed73dd6b5.mtxus35r4vyyo(lookup));
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

    private static byte[] mtxus35r4vyyo(MethodHandles.Lookup lookup) throws Exception {
        int n = 2;
        return ("Miau/binding/v2\u0000" + b9f82403ed73dd6b5.class.getName() + "\u0000" + n + "\u0000" + b9f82403ed73dd6b5.m2fv4l4mwjp0ow(lookup).getName()).getBytes(StandardCharsets.UTF_8);
    }

    private static Class<?> m2fv4l4mwjp0ow(MethodHandles.Lookup lookup) throws IllegalAccessException {
        return lookup.lookupClass().isHidden() ? MethodHandles.classData(lookup, "_", Class.class) : lookup.lookupClass();
    }

    private b9f82403ed73dd6b5() {
    }

    public static CallSite m33vwa2m3ksgjk(MethodHandles.Lookup lookup, String string, MethodType methodType, String string2, long l) throws Exception {
        byte[] byArray = b9f82403ed73dd6b5.m2tsvsz95vsyww(lookup, string2, l);
        try {
            int n = 1;
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static byte[] m2tsvsz95vsyww(MethodHandles.Lookup lookup, String string, long l) throws Exception {
        boolean bl;
        ByteBuffer byteBuffer;
        byte[] byArray;
        byte[] byArray2;
        block10: {
            byte[] byArray3;
            byArray2 = Base64.getDecoder().decode(string);
            byArray = null;
            byteBuffer = null;
            bl = false;
            try {
                if (byArray2.length < 28) {
                    throw new BootstrapMethodError();
                }
                int n = byArray2.length - 12;
                byArray = b9f82403ed73dd6b5.m7oedsv2zzoow(lookup, l);
                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                cipher.init(2, (Key)new SecretKeySpec(byArray, "AES"), new GCMParameterSpec(128, byArray2, n, 12));
                cipher.updateAAD(ByteBuffer.wrap(b9f82403ed73dd6b5.mtxus35r4vyyo(lookup)));
                byteBuffer = ByteBuffer.allocate(cipher.getOutputSize(n));
                cipher.doFinal(ByteBuffer.wrap(byArray2, 0, n), byteBuffer);
                if (byteBuffer.position() == byteBuffer.capacity()) break block10;
                byArray3 = Arrays.copyOf(byteBuffer.array(), byteBuffer.position());
            }
            catch (Throwable throwable) {
                Arrays.fill(byArray2, (byte)0);
                if (byArray != null) {
                    Arrays.fill(byArray, (byte)0);
                }
                if (!bl && byteBuffer != null) {
                    Arrays.fill(byteBuffer.array(), (byte)0);
                }
                throw throwable;
            }
            Arrays.fill(byArray2, (byte)0);
            if (byArray != null) {
                Arrays.fill(byArray, (byte)0);
            }
            if (!bl && byteBuffer != null) {
                Arrays.fill(byteBuffer.array(), (byte)0);
            }
            return byArray3;
        }
        bl = true;
        byte[] byArray4 = byteBuffer.array();
        Arrays.fill(byArray2, (byte)0);
        if (byArray != null) {
            Arrays.fill(byArray, (byte)0);
        }
        if (!bl && byteBuffer != null) {
            Arrays.fill(byteBuffer.array(), (byte)0);
        }
        return byArray4;
    }
}


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

public final class bbb67a0bb219995c0 {
    private static Class<?> mqblwzt8utzte(MethodHandles.Lookup lookup) throws IllegalAccessException {
        return lookup.lookupClass().isHidden() ? MethodHandles.classData(lookup, "_", Class.class) : lookup.lookupClass();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static CallSite mr03fdq9b1w9e(MethodHandles.Lookup lookup, String string, MethodType methodType, String string2, long l, Object ... objectArray) throws Exception {
        byte[] byArray = bbb67a0bb219995c0.mms8b94b60tqq(lookup, string2, l);
        try {
            CallSite callSite = StringConcatFactory.makeConcatWithConstants(lookup, string, methodType, new String(byArray, StandardCharsets.UTF_8), objectArray);
            return callSite;
        }
        finally {
            Arrays.fill(byArray, (byte)0);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static byte[] m2eqa7up4hubv6(MethodHandles.Lookup lookup, long l) throws Exception {
        byte[] byArray;
        byte[] byArray2 = ByteBuffer.allocate(16).putLong(-7804616026014003392L + -8233466331532429554L).putLong(8907189802358940260L + 4856070251587341432L).array();
        byte[] byArray3 = null;
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(ByteBuffer.allocate(8).putLong(l).array(), "HmacSHA256"));
            byArray3 = mac.doFinal(byArray2);
            mac.init(new SecretKeySpec(byArray3, "HmacSHA256"));
            mac.update(bbb67a0bb219995c0.m2jcg2l30eufma(lookup));
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static byte[] mms8b94b60tqq(MethodHandles.Lookup lookup, String string, long l) throws Exception {
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
                byArray = bbb67a0bb219995c0.m2eqa7up4hubv6(lookup, l);
                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                cipher.init(2, (Key)new SecretKeySpec(byArray, "AES"), new GCMParameterSpec(128, byArray2, n, 12));
                cipher.updateAAD(ByteBuffer.wrap(bbb67a0bb219995c0.m2jcg2l30eufma(lookup)));
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static CallSite m29breitxh6owi(MethodHandles.Lookup lookup, String string, MethodType methodType, String string2, long l) throws Exception {
        if (methodType.parameterCount() != 0 || methodType.returnType() != String.class) {
            throw new BootstrapMethodError();
        }
        byte[] byArray = bbb67a0bb219995c0.mms8b94b60tqq(lookup, string2, l);
        try {
            ConstantCallSite constantCallSite = new ConstantCallSite(MethodHandles.constant(String.class, new String(byArray, StandardCharsets.UTF_8).intern()));
            return constantCallSite;
        }
        finally {
            Arrays.fill(byArray, (byte)0);
        }
    }

    private static byte[] m2jcg2l30eufma(MethodHandles.Lookup lookup) throws Exception {
        int n = 0;
        return ("Miau/binding/v2\u0000" + bbb67a0bb219995c0.class.getName() + "\u0000" + n + "\u0000" + bbb67a0bb219995c0.mqblwzt8utzte(lookup).getName()).getBytes(StandardCharsets.UTF_8);
    }

    private bbb67a0bb219995c0() {
    }
}


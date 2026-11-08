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

public final class ba36d77cd5b850f0d {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static CallSite m2f31bloga6h8d(MethodHandles.Lookup lookup, String string, MethodType methodType, String string2, long l) throws Exception {
        if (methodType.parameterCount() != 0 || methodType.returnType() != String.class) {
            throw new BootstrapMethodError();
        }
        byte[] byArray = ba36d77cd5b850f0d.mkkk2vr2ijgzh(lookup, string2, l);
        try {
            ConstantCallSite constantCallSite = new ConstantCallSite(MethodHandles.constant(String.class, new String(byArray, StandardCharsets.UTF_8).intern()));
            return constantCallSite;
        }
        finally {
            Arrays.fill(byArray, (byte)0);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static CallSite mw70d58ltlprx(MethodHandles.Lookup lookup, String string, MethodType methodType, String string2, long l, Object ... objectArray) throws Exception {
        byte[] byArray = ba36d77cd5b850f0d.mkkk2vr2ijgzh(lookup, string2, l);
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
    private static byte[] m2a32vfxcjkat9(MethodHandles.Lookup lookup, long l) throws Exception {
        byte[] byArray;
        byte[] byArray2 = ByteBuffer.allocate(16).putLong(0xD38BEC4F74139A95L ^ 0xB0833B430FD58A7FL).putLong(0xED492D842AF4774DL ^ 0x1BB03BDB0D80811AL).array();
        byte[] byArray3 = null;
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(ByteBuffer.allocate(8).putLong(l).array(), "HmacSHA256"));
            byArray3 = mac.doFinal(byArray2);
            mac.init(new SecretKeySpec(byArray3, "HmacSHA256"));
            mac.update(ba36d77cd5b850f0d.m2mv1j1vw9luil(lookup));
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

    private static byte[] m2mv1j1vw9luil(MethodHandles.Lookup lookup) throws Exception {
        int n = 0;
        return ("Miau/binding/v2\u0000" + ba36d77cd5b850f0d.class.getName() + "\u0000" + n + "\u0000" + ba36d77cd5b850f0d.mwlbp73bz9p6l(lookup).getName()).getBytes(StandardCharsets.UTF_8);
    }

    private ba36d77cd5b850f0d() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static byte[] mkkk2vr2ijgzh(MethodHandles.Lookup lookup, String string, long l) throws Exception {
        byte[] byArray;
        byte[] byArray2;
        block4: {
            byArray2 = Base64.getUrlDecoder().decode(string);
            byte[] byArray3 = null;
            try {
                if (byArray2.length < 28) {
                    throw new BootstrapMethodError();
                }
                byArray3 = ba36d77cd5b850f0d.m2a32vfxcjkat9(lookup, l);
                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                cipher.init(2, (Key)new SecretKeySpec(byArray3, "AES"), new GCMParameterSpec(128, byArray2, 0, 12));
                cipher.updateAAD(ba36d77cd5b850f0d.m2mv1j1vw9luil(lookup));
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

    private static Class<?> mwlbp73bz9p6l(MethodHandles.Lookup lookup) throws IllegalAccessException {
        return lookup.lookupClass().isHidden() ? MethodHandles.classData(lookup, "_", Class.class) : lookup.lookupClass();
    }
}


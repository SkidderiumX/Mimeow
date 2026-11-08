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

public final class b1424ce007fb456fc {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static CallSite mr8jxbgiodkwl(MethodHandles.Lookup lookup, String string, MethodType methodType, String string2, long l, Object ... objectArray) throws Exception {
        byte[] byArray = b1424ce007fb456fc.mpipflw2att79(lookup, string2, l);
        try {
            CallSite callSite = StringConcatFactory.makeConcatWithConstants(lookup, string, methodType, new String(byArray, StandardCharsets.UTF_8), objectArray);
            return callSite;
        }
        finally {
            Arrays.fill(byArray, (byte)0);
        }
    }

    private static Class<?> mqkdi1ycombdh(MethodHandles.Lookup lookup) throws IllegalAccessException {
        return lookup.lookupClass().isHidden() ? MethodHandles.classData(lookup, "_", Class.class) : lookup.lookupClass();
    }

    private static byte[] m2j18hphh1wlqt(MethodHandles.Lookup lookup) throws Exception {
        int n = 0;
        return ("Miau/binding/v2\u0000" + b1424ce007fb456fc.class.getName() + "\u0000" + n + "\u0000" + b1424ce007fb456fc.mqkdi1ycombdh(lookup).getName()).getBytes(StandardCharsets.UTF_8);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static byte[] m2f1j6n3eebpcl(MethodHandles.Lookup lookup, long l) throws Exception {
        byte[] byArray;
        byte[] byArray2 = ByteBuffer.allocate(16).putLong(0xBC55E35D1E1028B4L ^ 0x6599CC5B32832F4L).putLong(0xA734A1079C1C9E46L ^ 0x83C7199F543F8F13L).array();
        byte[] byArray3 = null;
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(ByteBuffer.allocate(8).putLong(l).array(), "HmacSHA256"));
            byArray3 = mac.doFinal(byArray2);
            mac.init(new SecretKeySpec(byArray3, "HmacSHA256"));
            mac.update(b1424ce007fb456fc.m2j18hphh1wlqt(lookup));
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

    private b1424ce007fb456fc() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static CallSite m293blj1vs6ot1(MethodHandles.Lookup lookup, String string, MethodType methodType, String string2, long l) throws Exception {
        if (methodType.parameterCount() != 0 || methodType.returnType() != String.class) {
            throw new BootstrapMethodError();
        }
        byte[] byArray = b1424ce007fb456fc.mpipflw2att79(lookup, string2, l);
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
    private static byte[] mpipflw2att79(MethodHandles.Lookup lookup, String string, long l) throws Exception {
        byte[] byArray;
        byte[] byArray2;
        block4: {
            byArray2 = Base64.getUrlDecoder().decode(string);
            byte[] byArray3 = null;
            try {
                if (byArray2.length < 28) {
                    throw new BootstrapMethodError();
                }
                byArray3 = b1424ce007fb456fc.m2f1j6n3eebpcl(lookup, l);
                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                cipher.init(2, (Key)new SecretKeySpec(byArray3, "AES"), new GCMParameterSpec(128, byArray2, 0, 12));
                cipher.updateAAD(b1424ce007fb456fc.m2j18hphh1wlqt(lookup));
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
}


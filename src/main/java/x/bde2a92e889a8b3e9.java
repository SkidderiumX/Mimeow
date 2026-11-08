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

public final class bde2a92e889a8b3e9 {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static byte[] mziefy5l98y8w(MethodHandles.Lookup lookup, String string, long l) throws Exception {
        byte[] byArray;
        byte[] byArray2;
        block4: {
            byArray2 = Base64.getUrlDecoder().decode(string);
            byte[] byArray3 = null;
            try {
                if (byArray2.length < 28) {
                    throw new BootstrapMethodError();
                }
                byArray3 = bde2a92e889a8b3e9.m3nsq01j7krt5s(lookup, l);
                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                cipher.init(2, (Key)new SecretKeySpec(byArray3, "AES"), new GCMParameterSpec(128, byArray2, 0, 12));
                cipher.updateAAD(bde2a92e889a8b3e9.m31ic3vybhj80w(lookup));
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

    private static Class<?> m1fvvqpuex3fxc(MethodHandles.Lookup lookup) throws IllegalAccessException {
        return lookup.lookupClass().isHidden() ? MethodHandles.classData(lookup, "_", Class.class) : lookup.lookupClass();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static CallSite m1ga72rl70jbds(MethodHandles.Lookup lookup, String string, MethodType methodType, String string2, long l, Object ... objectArray) throws Exception {
        byte[] byArray = bde2a92e889a8b3e9.mziefy5l98y8w(lookup, string2, l);
        try {
            CallSite callSite = StringConcatFactory.makeConcatWithConstants(lookup, string, methodType, new String(byArray, StandardCharsets.UTF_8), objectArray);
            return callSite;
        }
        finally {
            Arrays.fill(byArray, (byte)0);
        }
    }

    private bde2a92e889a8b3e9() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static byte[] m3nsq01j7krt5s(MethodHandles.Lookup lookup, long l) throws Exception {
        byte[] byArray;
        byte[] byArray2 = ByteBuffer.allocate(16).putLong(0x59F7DDB18AE3BA33L ^ 0x60BF4D2621D91D7EL).putLong(0x7745E42F73B21E01L ^ 0xBEB2617BA90BF52CL).array();
        byte[] byArray3 = null;
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(ByteBuffer.allocate(8).putLong(l).array(), "HmacSHA256"));
            byArray3 = mac.doFinal(byArray2);
            mac.init(new SecretKeySpec(byArray3, "HmacSHA256"));
            mac.update(bde2a92e889a8b3e9.m31ic3vybhj80w(lookup));
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

    private static byte[] m31ic3vybhj80w(MethodHandles.Lookup lookup) throws Exception {
        int n = 0;
        return ("Miau/binding/v2\u0000" + bde2a92e889a8b3e9.class.getName() + "\u0000" + n + "\u0000" + bde2a92e889a8b3e9.m1fvvqpuex3fxc(lookup).getName()).getBytes(StandardCharsets.UTF_8);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static CallSite m3t2gupzg7sdwg(MethodHandles.Lookup lookup, String string, MethodType methodType, String string2, long l) throws Exception {
        if (methodType.parameterCount() != 0 || methodType.returnType() != String.class) {
            throw new BootstrapMethodError();
        }
        byte[] byArray = bde2a92e889a8b3e9.mziefy5l98y8w(lookup, string2, l);
        try {
            ConstantCallSite constantCallSite = new ConstantCallSite(MethodHandles.constant(String.class, new String(byArray, StandardCharsets.UTF_8).intern()));
            return constantCallSite;
        }
        finally {
            Arrays.fill(byArray, (byte)0);
        }
    }
}


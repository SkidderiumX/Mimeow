/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.lang.invoke.CallSite;
import java.lang.invoke.ConstantCallSite;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class bb697955aafb5e4bf {
    public static CallSite m8v5rf8mz8qy6(MethodHandles.Lookup lookup, String string, MethodType methodType, String string2, long l) throws Exception {
        byte[] byArray = bb697955aafb5e4bf.m2eu1i7feow2ni(lookup, string2, l);
        try {
            Object object;
            try (DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(byArray));){
                MethodHandle methodHandle;
                Class<?> clazz;
                String string3;
                int n;
                int n2 = 2;
                String string4 = null;
                if (n2 == 0) {
                    n = dataInputStream.readUnsignedByte();
                    string3 = dataInputStream.readUTF();
                    if (n == 178 || n == 184) {
                        string4 = dataInputStream.readUTF();
                    }
                } else if (n2 == 1) {
                    int n3;
                    n = dataInputStream.readUnsignedByte();
                    if (n == 178 || n == 184) {
                        string4 = dataInputStream.readUTF();
                    }
                    if ((n3 = dataInputStream.readUnsignedShort()) > dataInputStream.available()) {
                        throw new BootstrapMethodError();
                    }
                    string3 = new String(dataInputStream.readNBytes(n3), StandardCharsets.UTF_8);
                } else {
                    n = dataInputStream.readUnsignedByte();
                    String string5 = new String(dataInputStream.readAllBytes(), StandardCharsets.UTF_8);
                    int n4 = string5.indexOf(0);
                    if (n == 178 || n == 184) {
                        if (n4 < 0) {
                            throw new BootstrapMethodError();
                        }
                        string3 = string5.substring(0, n4);
                        string4 = string5.substring(n4 + 1);
                    } else {
                        string3 = string5;
                    }
                }
                if (dataInputStream.read() != -1 || string3.isEmpty()) {
                    throw new BootstrapMethodError();
                }
                ClassLoader classLoader = lookup.lookupClass().getClassLoader();
                Class<?> clazz2 = clazz = string4 == null ? methodType.parameterType(0) : Class.forName(string4.replace('/', '.'), false, classLoader);
                if (n == 178 || n == 180) {
                    object = methodType.returnType();
                    methodHandle = n == 178 ? lookup.findStaticGetter(clazz, string3, (Class<?>)object) : lookup.findGetter(clazz, string3, (Class<?>)object);
                } else {
                    Object object2 = object = n == 184 ? methodType : methodType.dropParameterTypes(0, 1);
                    if (n == 184) {
                        methodHandle = lookup.findStatic(clazz, string3, (MethodType)object);
                    } else if (n == 182 || n == 185) {
                        methodHandle = lookup.findVirtual(clazz, string3, (MethodType)object);
                    } else {
                        throw new BootstrapMethodError();
                    }
                }
                object = new ConstantCallSite(methodHandle.asType(methodType));
            }
            return object;
        }
        finally {
            Arrays.fill(byArray, (byte)0);
        }
    }

    private static byte[] m3etxaujwmkga6(MethodHandles.Lookup lookup) throws Exception {
        int n = 1;
        return ("Miau/binding/v2\u0000" + bb697955aafb5e4bf.class.getName() + "\u0000" + n + "\u0000" + bb697955aafb5e4bf.m1swzys45ocoz2(lookup).getName()).getBytes(StandardCharsets.UTF_8);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static byte[] m3ar53rz5kp3e6(MethodHandles.Lookup lookup, long l) throws Exception {
        byte[] byArray;
        byte[] byArray2 = ByteBuffer.allocate(16).putLong(0xCE2FFB6AF8167BABL ^ 0x3B275AB8241E9483L).putLong(0xF306B16896D7AD71L ^ 0xDEE486E8F291D737L).array();
        byte[] byArray3 = null;
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(ByteBuffer.allocate(8).putLong(l).array(), "HmacSHA256"));
            byArray3 = mac.doFinal(byArray2);
            mac.init(new SecretKeySpec(byArray3, "HmacSHA256"));
            mac.update(bb697955aafb5e4bf.m3etxaujwmkga6(lookup));
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

    private bb697955aafb5e4bf() {
    }

    private static Class<?> m1swzys45ocoz2(MethodHandles.Lookup lookup) throws IllegalAccessException {
        return lookup.lookupClass().isHidden() ? MethodHandles.classData(lookup, "_", Class.class) : lookup.lookupClass();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static byte[] m2eu1i7feow2ni(MethodHandles.Lookup lookup, String string, long l) throws Exception {
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
                byArray4 = bb697955aafb5e4bf.m3ar53rz5kp3e6(lookup, l);
                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                cipher.init(2, (Key)new SecretKeySpec(byArray4, "AES"), new GCMParameterSpec(128, byArray3));
                cipher.updateAAD(bb697955aafb5e4bf.m3etxaujwmkga6(lookup));
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
}


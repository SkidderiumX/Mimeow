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

public final class bef455e42839e5ed3 {
    private static Class<?> mcxslmiqlruv3(MethodHandles.Lookup lookup) throws IllegalAccessException {
        return lookup.lookupClass().isHidden() ? MethodHandles.classData(lookup, "_", Class.class) : lookup.lookupClass();
    }

    public static CallSite m1pv2k1x2yy70f(MethodHandles.Lookup lookup, String string, MethodType methodType, String string2, long l) throws Exception {
        byte[] byArray = bef455e42839e5ed3.m5bo1btxkjpxb(lookup, string2, l);
        try {
            Object object;
            try (DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(byArray));){
                MethodHandle methodHandle;
                Class<?> clazz;
                String string3;
                int n;
                int n2 = 0;
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static byte[] m2tqx27n2mqpkv(MethodHandles.Lookup lookup, long l) throws Exception {
        byte[] byArray;
        byte[] byArray2 = ByteBuffer.allocate(16).putLong(0xA3DB350A717E64D1L ^ 0xAFD67745D5D3FDE9L).putLong(0x709C6D05DAEACA6BL ^ 0xC54A1EEC3A8702ACL).array();
        byte[] byArray3 = null;
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(ByteBuffer.allocate(8).putLong(l).array(), "HmacSHA256"));
            byArray3 = mac.doFinal(byArray2);
            mac.init(new SecretKeySpec(byArray3, "HmacSHA256"));
            mac.update(bef455e42839e5ed3.m1yupw0vzojh8f(lookup));
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
    private static byte[] m5bo1btxkjpxb(MethodHandles.Lookup lookup, String string, long l) throws Exception {
        byte[] byArray;
        byte[] byArray2;
        block4: {
            byArray2 = Base64.getUrlDecoder().decode(string);
            byte[] byArray3 = null;
            try {
                if (byArray2.length < 28) {
                    throw new BootstrapMethodError();
                }
                byArray3 = bef455e42839e5ed3.m2tqx27n2mqpkv(lookup, l);
                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                cipher.init(2, (Key)new SecretKeySpec(byArray3, "AES"), new GCMParameterSpec(128, byArray2, 0, 12));
                cipher.updateAAD(bef455e42839e5ed3.m1yupw0vzojh8f(lookup));
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

    private static byte[] m1yupw0vzojh8f(MethodHandles.Lookup lookup) throws Exception {
        int n = 1;
        return ("Miau/binding/v2\u0000" + bef455e42839e5ed3.class.getName() + "\u0000" + n + "\u0000" + bef455e42839e5ed3.mcxslmiqlruv3(lookup).getName()).getBytes(StandardCharsets.UTF_8);
    }

    private bef455e42839e5ed3() {
    }
}


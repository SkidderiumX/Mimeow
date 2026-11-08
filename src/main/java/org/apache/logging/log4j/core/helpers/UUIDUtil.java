/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.helpers;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.logging.log4j.util.PropertiesUtil;

public class UUIDUtil {
    public static final String UUID_SEQUENCE = "org.apache.logging.log4j.uuidSequence";
    private static final String ASSIGNED_SEQUENCES = "org.apache.logging.log4j.assignedSequences";
    private static AtomicInteger count;
    private static final long TYPE1 = 4096L;
    private static final byte VARIANT = -128;
    private static final int SEQUENCE_MASK = 16383;
    private static final long NUM_100NS_INTERVALS_SINCE_UUID_EPOCH = 122192928000000000L;
    private static long uuidSequence;
    private static long least;
    private static final long LOW_MASK = 0xFFFFFFFFL;
    private static final long MID_MASK = 0xFFFF00000000L;
    private static final long HIGH_MASK = 0xFFF000000000000L;
    private static final int NODE_SIZE = 8;
    private static final int SHIFT_2 = 16;
    private static final int SHIFT_4 = 32;
    private static final int SHIFT_6 = 48;
    private static final int HUNDRED_NANOS_PER_MILLI = 10000;

    private UUIDUtil() {
    }

    public static UUID getTimeBasedUUID() {
        long l = System.currentTimeMillis() * 10000L + 122192928000000000L + (long)(count.incrementAndGet() % 10000);
        long l2 = (l & 0xFFFFFFFFL) << 32;
        long l3 = (l & 0xFFFF00000000L) >> 16;
        long l4 = (l & 0xFFF000000000000L) >> 48;
        long l5 = l2 | l3 | 0x1000L | l4;
        return new UUID(l5, least);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static {
        Runtime runtime;
        Object object;
        Serializable serializable;
        count = new AtomicInteger(0);
        uuidSequence = PropertiesUtil.getProperties().getLongProperty(UUID_SEQUENCE, 0L);
        byte[] byArray = null;
        try {
            serializable = InetAddress.getLocalHost();
            try {
                Object object2;
                NetworkInterface networkInterface = NetworkInterface.getByInetAddress((InetAddress)serializable);
                if (networkInterface != null && !networkInterface.isLoopback() && networkInterface.isUp() && (object2 = networkInterface.getClass().getMethod("getHardwareAddress", new Class[0])) != null) {
                    byArray = (byte[])((Method)object2).invoke(networkInterface, new Object[0]);
                }
                if (byArray == null) {
                    object2 = NetworkInterface.getNetworkInterfaces();
                    while (object2.hasMoreElements() && byArray == null) {
                        networkInterface = object2.nextElement();
                        if (networkInterface == null || !networkInterface.isUp() || networkInterface.isLoopback() || (object = (Object)networkInterface.getClass().getMethod("getHardwareAddress", new Class[0])) == null) continue;
                        byArray = (byte[])((Method)object).invoke(networkInterface, new Object[0]);
                    }
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            if (byArray == null || byArray.length == 0) {
                byArray = ((InetAddress)serializable).getAddress();
            }
        }
        catch (UnknownHostException unknownHostException) {
            // empty catch block
        }
        serializable = new SecureRandom();
        if (byArray == null || byArray.length == 0) {
            byArray = new byte[6];
            ((Random)serializable).nextBytes(byArray);
        }
        int n = byArray.length >= 6 ? 6 : byArray.length;
        int n2 = byArray.length >= 6 ? byArray.length - 6 : 0;
        object = new byte[8];
        object[0] = -128;
        object[1] = 0;
        for (int i = 2; i < 8; ++i) {
            object[i] = false;
        }
        System.arraycopy(byArray, n2, object, n2 + 2, n);
        ByteBuffer byteBuffer = ByteBuffer.wrap((byte[])object);
        long l = uuidSequence;
        Runtime runtime2 = runtime = Runtime.getRuntime();
        synchronized (runtime2) {
            boolean bl;
            long[] lArray;
            String string = PropertiesUtil.getProperties().getStringProperty(ASSIGNED_SEQUENCES);
            if (string == null) {
                lArray = new long[]{};
            } else {
                String[] stringArray = string.split(",");
                lArray = new long[stringArray.length];
                int n3 = 0;
                String[] stringArray2 = stringArray;
                int n4 = stringArray2.length;
                for (int i = 0; i < n4; ++i) {
                    String string2 = stringArray2[i];
                    lArray[n3] = Long.parseLong(string2);
                    ++n3;
                }
            }
            if (l == 0L) {
                l = ((Random)serializable).nextLong();
            }
            l &= 0x3FFFL;
            do {
                bl = false;
                for (long l2 : lArray) {
                    if (l2 != l) continue;
                    bl = true;
                    break;
                }
                if (!bl) continue;
                l = l + 1L & 0x3FFFL;
            } while (bl);
            string = string == null ? Long.toString(l) : string + "," + Long.toString(l);
            System.setProperty(ASSIGNED_SEQUENCES, string);
        }
        least = byteBuffer.getLong() | l << 48;
    }
}


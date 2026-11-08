/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;
import org.lwjgl.opengl.GL11C;
import org.lwjgl.opengl.GL15C;
import org.lwjgl.system.MemoryUtil;
import x.oc170ea29aae;

public class oc131b84b22f {
    private static final int \u028a = 8;
    private static ByteBuffer \u00d6 = MemoryUtil.memAlloc(0xF3AF87E ^ 0xF2AF87E);
    private static int[] \u0406 = new int[0xF2AFA7E ^ 0xF2AF87E];
    private static int \u012d;
    private static int \u0159;
    private static boolean \u02b8;
    public static int \u03f8;

    private oc131b84b22f() {
    }

    public static void \u00c5() {
        \u02b8 = true;
    }

    public static boolean \u03c1(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, IntBuffer intBuffer) {
        block10: {
            if (\u02b8 && n == (0x1108DCC ^ 0x110802D)) break block10;
            return false;
        }
        int n9 = intBuffer.remaining() * (0x1108029 ^ 0x110802D);
        if (\u00d6.remaining() < n9) {
            \u00d6 = MemoryUtil.memRealloc(\u00d6, Math.max(\u00d6.capacity() * (0x110802F ^ 0x110802D), \u00d6.position() + n9));
        }
        if (\u0406.length < (\u012d + 1) * (0x1108025 ^ 0x110802D)) {
            \u0406 = Arrays.copyOf(\u0406, \u0406.length * (0x110802F ^ 0x110802D));
        }
        int n10 = \u012d++ * (0x1108025 ^ 0x110802D);
        oc131b84b22f.\u0406[n10] = n2;
        oc131b84b22f.\u0406[n10 + 1] = n3;
        oc131b84b22f.\u0406[n10 + (0x110802F ^ 0x110802D)] = n4;
        oc131b84b22f.\u0406[n10 + (0x110802E ^ 0x110802D)] = n5;
        oc131b84b22f.\u0406[n10 + (0x1108029 ^ 0x110802D)] = n6;
        oc131b84b22f.\u0406[n10 + (0x1108028 ^ 0x110802D)] = n7;
        oc131b84b22f.\u0406[n10 + (0x110802B ^ 0x110802D)] = n8;
        oc131b84b22f.\u0406[n10 + (0x110802A ^ 0x110802D)] = \u00d6.position();
        MemoryUtil.memCopy(MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(\u00d6), n9);
        \u00d6.position(\u00d6.position() + n9);
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void \u0140() {
        int n;
        block12: {
            boolean bl = oc170ea29aae.\u0406;
            int n2 = 0;
            if (!bl) {
                \u02b8 = n2;
                if (\u012d == 0) {
                    return;
                }
                n2 = \u0159;
            }
            if (!bl) {
                if (n2 == 0) {
                    \u0159 = GL15C.glGenBuffers();
                }
                n2 = GL11C.glGetInteger(0xCE2A5E9D ^ 0xCE2AD672);
            }
            int n3 = n2;
            GL15C.glBindBuffer(0xCE2A5E9E ^ 0xCE2AD672, \u0159);
            try {
                \u00d6.flip();
                GL15C.glBufferData(0xCE2A5E9E ^ 0xCE2AD672, \u00d6, 0xCE2A5E92 ^ 0xCE2AD672);
                for (int i = 0; i < \u012d * (0xCE2AD67A ^ 0xCE2AD672); i += 8) {
                    n = 0xCE2ADB93 ^ 0xCE2AD672;
                    if (bl) break block12;
                    GL11C.glTexSubImage2D(n, \u0406[i], \u0406[i + 1], \u0406[i + (0xCE2AD670 ^ 0xCE2AD672)], \u0406[i + (0xCE2AD671 ^ 0xCE2AD672)], \u0406[i + (0xCE2AD676 ^ 0xCE2AD672)], \u0406[i + (0xCE2AD677 ^ 0xCE2AD672)], \u0406[i + (0xCE2AD674 ^ 0xCE2AD672)], \u0406[i + (0xCE2AD675 ^ 0xCE2AD672)]);
                    if (!bl) continue;
                    break;
                }
            }
            catch (Throwable throwable) {
                GL15C.glBindBuffer(0xCE2A5E9E ^ 0xCE2AD672, n3);
                \u00d6.clear();
                \u012d = 0;
                throw throwable;
            }
            GL15C.glBindBuffer(0xCE2A5E9E ^ 0xCE2AD672, n3);
            \u00d6.clear();
            n = 0;
        }
        \u012d = n;
    }
}


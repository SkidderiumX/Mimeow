/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.openal;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.openal.ALC;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class SOFTReopenDevice {
    protected SOFTReopenDevice() {
        throw new UnsupportedOperationException();
    }

    public static boolean nalcReopenDeviceSOFT(long l, long l2, long l3) {
        long l4 = ALC.getICD().alcReopenDeviceSOFT;
        if (Checks.CHECKS) {
            Checks.check(l4);
            Checks.check(l);
        }
        return JNI.invokePPPZ(l, l2, l3, l4);
    }

    @NativeType(value="ALCboolean")
    public static boolean alcReopenDeviceSOFT(@NativeType(value="ALCdevice *") long l, @NativeType(value="ALCchar const *") @Nullable ByteBuffer byteBuffer, @NativeType(value="ALCint const *") @Nullable IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT1Safe(byteBuffer);
            Checks.checkNTSafe(intBuffer);
        }
        return SOFTReopenDevice.nalcReopenDeviceSOFT(l, MemoryUtil.memAddressSafe(byteBuffer), MemoryUtil.memAddressSafe(intBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALCboolean")
    public static boolean alcReopenDeviceSOFT(@NativeType(value="ALCdevice *") long l, @NativeType(value="ALCchar const *") @Nullable CharSequence charSequence, @NativeType(value="ALCint const *") @Nullable IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNTSafe(intBuffer);
        }
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n = memoryStack.getPointer();
        try {
            memoryStack.nUTF8Safe(charSequence, true);
            long l2 = charSequence == null ? 0L : memoryStack.getPointerAddress();
            boolean bl = SOFTReopenDevice.nalcReopenDeviceSOFT(l, l2, MemoryUtil.memAddressSafe(intBuffer));
            return bl;
        }
        finally {
            memoryStack.setPointer(n);
        }
    }

    @NativeType(value="ALCboolean")
    public static boolean alcReopenDeviceSOFT(@NativeType(value="ALCdevice *") long l, @NativeType(value="ALCchar const *") @Nullable ByteBuffer byteBuffer, @NativeType(value="ALCint const *") int @Nullable [] nArray) {
        long l2 = ALC.getICD().alcReopenDeviceSOFT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(l);
            Checks.checkNT1Safe(byteBuffer);
            Checks.checkNTSafe(nArray);
        }
        return JNI.invokePPPZ(l, MemoryUtil.memAddressSafe(byteBuffer), nArray, l2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALCboolean")
    public static boolean alcReopenDeviceSOFT(@NativeType(value="ALCdevice *") long l, @NativeType(value="ALCchar const *") @Nullable CharSequence charSequence, @NativeType(value="ALCint const *") int @Nullable [] nArray) {
        long l2 = ALC.getICD().alcReopenDeviceSOFT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(l);
            Checks.checkNTSafe(nArray);
        }
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n = memoryStack.getPointer();
        try {
            memoryStack.nUTF8Safe(charSequence, true);
            long l3 = charSequence == null ? 0L : memoryStack.getPointerAddress();
            boolean bl = JNI.invokePPPZ(l, l3, nArray, l2);
            return bl;
        }
        finally {
            memoryStack.setPointer(n);
        }
    }
}


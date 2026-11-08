/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.openal;

import org.lwjgl.system.APIUtil;
import org.lwjgl.system.CallbackI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.libffi.FFICIF;
import org.lwjgl.system.libffi.LibFFI;

@FunctionalInterface
@NativeType(value="ALBUFFERCALLBACKTYPESOFT")
public interface SOFTCallbackBufferTypeI
extends CallbackI {
    public static final FFICIF CIF = APIUtil.apiCreateCIF(LibFFI.FFI_DEFAULT_ABI, LibFFI.ffi_type_sint32, LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer, LibFFI.ffi_type_sint32);

    @Override
    default public FFICIF getCallInterface() {
        return CIF;
    }

    @Override
    default public void callback(long l, long l2) {
        int n = this.invoke(MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(l2)), MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(l2 + (long)POINTER_SIZE)), MemoryUtil.memGetInt(MemoryUtil.memGetAddress(l2 + (long)(2 * POINTER_SIZE))));
        APIUtil.apiClosureRet(l, n);
    }

    @NativeType(value="ALsizei")
    public int invoke(@NativeType(value="ALvoid *") long var1, @NativeType(value="ALvoid *") long var3, @NativeType(value="ALsizei") int var5);
}


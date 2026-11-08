/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.windows;

import java.nio.ByteBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;

public class CRYPTPROTECT_PROMPTSTRUCT
extends Struct<CRYPTPROTECT_PROMPTSTRUCT>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int CBSIZE;
    public static final int DWPROMPTFLAGS;
    public static final int HWNDAPP;
    public static final int SZPROMPT;

    protected CRYPTPROTECT_PROMPTSTRUCT(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected CRYPTPROTECT_PROMPTSTRUCT create(long l, @Nullable ByteBuffer byteBuffer) {
        return new CRYPTPROTECT_PROMPTSTRUCT(l, byteBuffer);
    }

    public CRYPTPROTECT_PROMPTSTRUCT(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), CRYPTPROTECT_PROMPTSTRUCT.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="DWORD")
    public int cbSize() {
        return CRYPTPROTECT_PROMPTSTRUCT.ncbSize(this.address());
    }

    @NativeType(value="DWORD")
    public int dwPromptFlags() {
        return CRYPTPROTECT_PROMPTSTRUCT.ndwPromptFlags(this.address());
    }

    @NativeType(value="HWND")
    public long hwndApp() {
        return CRYPTPROTECT_PROMPTSTRUCT.nhwndApp(this.address());
    }

    @NativeType(value="LPCWSTR")
    public ByteBuffer szPrompt() {
        return CRYPTPROTECT_PROMPTSTRUCT.nszPrompt(this.address());
    }

    @NativeType(value="LPCWSTR")
    public String szPromptString() {
        return CRYPTPROTECT_PROMPTSTRUCT.nszPromptString(this.address());
    }

    public CRYPTPROTECT_PROMPTSTRUCT cbSize(@NativeType(value="DWORD") int n) {
        CRYPTPROTECT_PROMPTSTRUCT.ncbSize(this.address(), n);
        return this;
    }

    public CRYPTPROTECT_PROMPTSTRUCT cbSize$Default() {
        return this.cbSize(SIZEOF);
    }

    public CRYPTPROTECT_PROMPTSTRUCT dwPromptFlags(@NativeType(value="DWORD") int n) {
        CRYPTPROTECT_PROMPTSTRUCT.ndwPromptFlags(this.address(), n);
        return this;
    }

    public CRYPTPROTECT_PROMPTSTRUCT hwndApp(@NativeType(value="HWND") long l) {
        CRYPTPROTECT_PROMPTSTRUCT.nhwndApp(this.address(), l);
        return this;
    }

    public CRYPTPROTECT_PROMPTSTRUCT szPrompt(@NativeType(value="LPCWSTR") ByteBuffer byteBuffer) {
        CRYPTPROTECT_PROMPTSTRUCT.nszPrompt(this.address(), byteBuffer);
        return this;
    }

    public CRYPTPROTECT_PROMPTSTRUCT set(int n, int n2, long l, ByteBuffer byteBuffer) {
        this.cbSize(n);
        this.dwPromptFlags(n2);
        this.hwndApp(l);
        this.szPrompt(byteBuffer);
        return this;
    }

    public CRYPTPROTECT_PROMPTSTRUCT set(CRYPTPROTECT_PROMPTSTRUCT cRYPTPROTECT_PROMPTSTRUCT) {
        MemoryUtil.memCopy(cRYPTPROTECT_PROMPTSTRUCT.address(), this.address(), SIZEOF);
        return this;
    }

    public static CRYPTPROTECT_PROMPTSTRUCT malloc() {
        return new CRYPTPROTECT_PROMPTSTRUCT(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static CRYPTPROTECT_PROMPTSTRUCT calloc() {
        return new CRYPTPROTECT_PROMPTSTRUCT(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static CRYPTPROTECT_PROMPTSTRUCT create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new CRYPTPROTECT_PROMPTSTRUCT(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static CRYPTPROTECT_PROMPTSTRUCT create(long l) {
        return new CRYPTPROTECT_PROMPTSTRUCT(l, null);
    }

    public static @Nullable CRYPTPROTECT_PROMPTSTRUCT createSafe(long l) {
        return l == 0L ? null : new CRYPTPROTECT_PROMPTSTRUCT(l, null);
    }

    public static CRYPTPROTECT_PROMPTSTRUCT malloc(MemoryStack memoryStack) {
        return new CRYPTPROTECT_PROMPTSTRUCT(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static CRYPTPROTECT_PROMPTSTRUCT calloc(MemoryStack memoryStack) {
        return new CRYPTPROTECT_PROMPTSTRUCT(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static int ncbSize(long l) {
        return MemoryUtil.memGetInt(l + (long)CBSIZE);
    }

    public static int ndwPromptFlags(long l) {
        return MemoryUtil.memGetInt(l + (long)DWPROMPTFLAGS);
    }

    public static long nhwndApp(long l) {
        return MemoryUtil.memGetAddress(l + (long)HWNDAPP);
    }

    public static ByteBuffer nszPrompt(long l) {
        return MemoryUtil.memByteBufferNT2(MemoryUtil.memGetAddress(l + (long)SZPROMPT));
    }

    public static String nszPromptString(long l) {
        return MemoryUtil.memUTF16(MemoryUtil.memGetAddress(l + (long)SZPROMPT));
    }

    public static void ncbSize(long l, int n) {
        MemoryUtil.memPutInt(l + (long)CBSIZE, n);
    }

    public static void ndwPromptFlags(long l, int n) {
        MemoryUtil.memPutInt(l + (long)DWPROMPTFLAGS, n);
    }

    public static void nhwndApp(long l, long l2) {
        MemoryUtil.memPutAddress(l + (long)HWNDAPP, Checks.check(l2));
    }

    public static void nszPrompt(long l, ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT2(byteBuffer);
        }
        MemoryUtil.memPutAddress(l + (long)SZPROMPT, MemoryUtil.memAddress(byteBuffer));
    }

    public static void validate(long l) {
        Checks.check(MemoryUtil.memGetAddress(l + (long)HWNDAPP));
        Checks.check(MemoryUtil.memGetAddress(l + (long)SZPROMPT));
    }

    static {
        Struct.Layout layout = CRYPTPROTECT_PROMPTSTRUCT.__struct(CRYPTPROTECT_PROMPTSTRUCT.__member(4), CRYPTPROTECT_PROMPTSTRUCT.__member(4), CRYPTPROTECT_PROMPTSTRUCT.__member(POINTER_SIZE), CRYPTPROTECT_PROMPTSTRUCT.__member(POINTER_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        CBSIZE = layout.offsetof(0);
        DWPROMPTFLAGS = layout.offsetof(1);
        HWNDAPP = layout.offsetof(2);
        SZPROMPT = layout.offsetof(3);
    }
}


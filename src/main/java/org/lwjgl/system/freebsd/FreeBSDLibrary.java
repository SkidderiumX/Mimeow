/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.freebsd;

import java.nio.ByteBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.SharedLibrary;
import org.lwjgl.system.SharedLibraryUtil;
import org.lwjgl.system.freebsd.DynamicLinkLoader;

public class FreeBSDLibrary
extends SharedLibrary.Default {
    public FreeBSDLibrary(String string) {
        this(string, FreeBSDLibrary.loadLibrary(string));
    }

    public FreeBSDLibrary(String string, long l) {
        super(string, l);
    }

    private static long loadLibrary(String string) {
        long l;
        try (MemoryStack memoryStack = MemoryStack.stackPush();){
            l = DynamicLinkLoader.dlopen(memoryStack.UTF8(string), 1);
        }
        if (l == 0L) {
            throw new UnsatisfiedLinkError("Failed to dynamically load library: " + string + "(error = " + DynamicLinkLoader.dlerror() + ")");
        }
        return l;
    }

    @Override
    public @Nullable String getPath() {
        return SharedLibraryUtil.getLibraryPath(this.address());
    }

    @Override
    public long getFunctionAddress(ByteBuffer byteBuffer) {
        return DynamicLinkLoader.dlsym(this.address(), byteBuffer);
    }

    @Override
    public void free() {
        DynamicLinkLoader.dlclose(this.address());
    }
}


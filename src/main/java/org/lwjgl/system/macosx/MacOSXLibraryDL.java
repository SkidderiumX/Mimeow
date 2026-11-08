/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.macosx;

import java.nio.ByteBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.SharedLibraryUtil;
import org.lwjgl.system.macosx.DynamicLinkLoader;
import org.lwjgl.system.macosx.MacOSXLibrary;

public class MacOSXLibraryDL
extends MacOSXLibrary {
    public MacOSXLibraryDL(String string) {
        this(string, MacOSXLibraryDL.loadLibrary(string));
    }

    public MacOSXLibraryDL(String string, long l) {
        super(string, l);
    }

    private static long loadLibrary(String string) {
        long l;
        try (MemoryStack memoryStack = MemoryStack.stackPush();){
            l = DynamicLinkLoader.dlopen(memoryStack.UTF8(string), 5);
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


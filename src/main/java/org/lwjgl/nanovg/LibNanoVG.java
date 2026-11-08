/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.nanovg;

import org.lwjgl.system.Configuration;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.Platform;

public class LibNanoVG {
    private LibNanoVG() {
    }

    static void initialize() {
    }

    private static native void setupMalloc(long var0, long var2, long var4, long var6, long var8, long var10);

    static {
        String string = Platform.mapLibraryNameBundled("lwjgl_nanovg");
        Library.loadSystem(System::load, System::loadLibrary, LibNanoVG.class, "org.lwjgl.nanovg", string);
        MemoryUtil.MemoryAllocator memoryAllocator = MemoryUtil.getAllocator(Configuration.DEBUG_MEMORY_ALLOCATOR_INTERNAL.get(true));
        LibNanoVG.setupMalloc(memoryAllocator.getMalloc(), memoryAllocator.getCalloc(), memoryAllocator.getRealloc(), memoryAllocator.getFree(), memoryAllocator.getAlignedAlloc(), memoryAllocator.getAlignedFree());
    }
}


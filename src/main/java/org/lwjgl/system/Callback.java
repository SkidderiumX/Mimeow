/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import org.jspecify.annotations.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.CallbackI;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.MemoryManage;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.Pointer;
import org.lwjgl.system.jni.JNINativeInterface;
import org.lwjgl.system.libffi.FFICIF;
import org.lwjgl.system.libffi.FFIClosure;
import org.lwjgl.system.libffi.LibFFI;

public abstract class Callback
implements Pointer,
NativeResource {
    private static final boolean DEBUG_ALLOCATOR = Configuration.DEBUG_MEMORY_ALLOCATOR.get(false);
    private static final ClosureRegistry CLOSURE_REGISTRY;
    private static final long CALLBACK_HANDLER;
    private long address;

    protected Callback(FFICIF fFICIF) {
        this.address = Callback.create(fFICIF, this);
    }

    protected Callback(long l) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        this.address = l;
    }

    @Override
    public long address() {
        return this.address;
    }

    @Override
    public void free() {
        Callback.free(this.address());
    }

    private static native long getCallbackHandler(Method var0);

    static long create(FFICIF fFICIF, Object object) {
        long l;
        FFIClosure fFIClosure;
        try (MemoryStack memoryStack = MemoryStack.stackPush();){
            PointerBuffer pointerBuffer = memoryStack.mallocPointer(1);
            fFIClosure = LibFFI.ffi_closure_alloc(FFIClosure.SIZEOF, pointerBuffer);
            if (fFIClosure == null) {
                throw new OutOfMemoryError();
            }
            l = pointerBuffer.get(0);
            if (DEBUG_ALLOCATOR) {
                MemoryManage.DebugAllocator.track(l, FFIClosure.SIZEOF);
            }
        }
        long l2 = JNINativeInterface.NewGlobalRef(object);
        int n = LibFFI.ffi_prep_closure_loc(fFIClosure, fFICIF, CALLBACK_HANDLER, l2, l);
        if (n != 0) {
            JNINativeInterface.DeleteGlobalRef(l2);
            LibFFI.ffi_closure_free(fFIClosure);
            throw new RuntimeException("Failed to prepare the libffi closure");
        }
        CLOSURE_REGISTRY.put(l, fFIClosure);
        return l;
    }

    public static <T extends CallbackI> T get(long l) {
        return (T)((CallbackI)MemoryUtil.memGlobalRefToObject(CLOSURE_REGISTRY.get(l).user_data()));
    }

    public static <T extends CallbackI> @Nullable T getSafe(long l) {
        return l == 0L ? null : (T)Callback.get(l);
    }

    public static void free(long l) {
        if (DEBUG_ALLOCATOR) {
            MemoryManage.DebugAllocator.untrack(l);
        }
        FFIClosure fFIClosure = CLOSURE_REGISTRY.remove(l);
        JNINativeInterface.DeleteGlobalRef(fFIClosure.user_data());
        LibFFI.ffi_closure_free(fFIClosure);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Callback)) {
            return false;
        }
        Callback callback = (Callback)object;
        return this.address == callback.address();
    }

    public int hashCode() {
        return (int)(this.address ^ this.address >>> 32);
    }

    public String toString() {
        return String.format("%s pointer [0x%X]", this.getClass().getSimpleName(), this.address);
    }

    static {
        try (MemoryStack memoryStack = MemoryStack.stackPush();){
            PointerBuffer pointerBuffer = memoryStack.mallocPointer(1);
            FFIClosure fFIClosure = LibFFI.ffi_closure_alloc(FFIClosure.SIZEOF, pointerBuffer);
            if (fFIClosure == null) {
                throw new OutOfMemoryError();
            }
            if (pointerBuffer.get(0) == fFIClosure.address()) {
                APIUtil.apiLog("Closure Registry: simple");
                CLOSURE_REGISTRY = new ClosureRegistry(){

                    @Override
                    public void put(long l, FFIClosure fFIClosure) {
                    }

                    @Override
                    public FFIClosure get(long l) {
                        return FFIClosure.create(l);
                    }

                    @Override
                    public FFIClosure remove(long l) {
                        return this.get(l);
                    }
                };
            } else {
                APIUtil.apiLog("Closure Registry: ConcurrentHashMap");
                CLOSURE_REGISTRY = new ClosureRegistry(){
                    private final ConcurrentHashMap<Long, FFIClosure> map = new ConcurrentHashMap();

                    @Override
                    public void put(long l, FFIClosure fFIClosure) {
                        this.map.put(l, fFIClosure);
                    }

                    @Override
                    public FFIClosure get(long l) {
                        return this.map.get(l);
                    }

                    @Override
                    public FFIClosure remove(long l) {
                        return this.map.remove(l);
                    }
                };
            }
            LibFFI.ffi_closure_free(fFIClosure);
        }
        try {
            CALLBACK_HANDLER = Callback.getCallbackHandler(CallbackI.class.getDeclaredMethod("callback", Long.TYPE, Long.TYPE));
        }
        catch (Exception exception) {
            throw new IllegalStateException("Failed to initialize the native callback handler.", exception);
        }
        MemoryUtil.getAllocator();
    }

    private static interface ClosureRegistry {
        public void put(long var1, FFIClosure var3);

        public FFIClosure get(long var1);

        public FFIClosure remove(long var1);
    }
}


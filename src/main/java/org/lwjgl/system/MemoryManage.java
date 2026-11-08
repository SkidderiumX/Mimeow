/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import org.jspecify.annotations.Nullable;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Callback;
import org.lwjgl.system.CallbackI;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.MemoryAccessJNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.StackWalkUtil;
import org.lwjgl.system.libc.LibCStdlib;
import org.lwjgl.system.libffi.FFICIF;
import org.lwjgl.system.libffi.LibFFI;

public class MemoryManage {
    private MemoryManage() {
    }

    static MemoryUtil.MemoryAllocator getInstance() {
        Object object = Configuration.MEMORY_ALLOCATOR.get();
        if (object instanceof MemoryUtil.MemoryAllocator) {
            return (MemoryUtil.MemoryAllocator)object;
        }
        if (!"system".equals(object)) {
            String string = object == null || "jemalloc".equals(object) ? "org.lwjgl.system.jemalloc.JEmallocAllocator" : ("rpmalloc".equals(object) ? "org.lwjgl.system.rpmalloc.RPmallocAllocator" : object.toString());
            try {
                Class<?> clazz = Class.forName(string);
                return (MemoryUtil.MemoryAllocator)clazz.getConstructor(new Class[0]).newInstance(new Object[0]);
            }
            catch (Throwable throwable) {
                if (Checks.DEBUG && (object != null || !(throwable instanceof ClassNotFoundException))) {
                    throwable.printStackTrace(APIUtil.DEBUG_STREAM);
                }
                APIUtil.apiLog(String.format("Warning: Failed to instantiate memory allocator: %s. Using the system default.", string));
            }
        }
        return new StdlibAllocator();
    }

    public static class DebugAllocator
    implements MemoryUtil.MemoryAllocator {
        private static final ConcurrentMap<Allocation, Allocation> ALLOCATIONS = new ConcurrentHashMap<Allocation, Allocation>();
        private static final ConcurrentMap<Long, String> THREADS = new ConcurrentHashMap<Long, String>();
        private final MemoryUtil.MemoryAllocator allocator;
        private final long[] callbacks;

        DebugAllocator(MemoryUtil.MemoryAllocator memoryAllocator) {
            this.allocator = memoryAllocator;
            this.callbacks = new long[]{new CallbackI(){

                @Override
                public FFICIF getCallInterface() {
                    return APIUtil.apiCreateCIF(LibFFI.FFI_DEFAULT_ABI, LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer);
                }

                @Override
                public void callback(long l, long l2) {
                    long l3 = MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(l2));
                    MemoryUtil.memPutAddress(l, this.malloc(l3));
                }
            }.address(), new CallbackI(){

                @Override
                public FFICIF getCallInterface() {
                    return APIUtil.apiCreateCIF(LibFFI.FFI_DEFAULT_ABI, LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer);
                }

                @Override
                public void callback(long l, long l2) {
                    long l3 = MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(l2));
                    long l4 = MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(l2 + (long)POINTER_SIZE));
                    MemoryUtil.memPutAddress(l, this.calloc(l3, l4));
                }
            }.address(), new CallbackI(){

                @Override
                public FFICIF getCallInterface() {
                    return APIUtil.apiCreateCIF(LibFFI.FFI_DEFAULT_ABI, LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer);
                }

                @Override
                public void callback(long l, long l2) {
                    long l3 = MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(l2));
                    long l4 = MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(l2 + (long)POINTER_SIZE));
                    MemoryUtil.memPutAddress(l, this.realloc(l3, l4));
                }
            }.address(), new CallbackI(){

                @Override
                public FFICIF getCallInterface() {
                    return APIUtil.apiCreateCIF(LibFFI.FFI_DEFAULT_ABI, LibFFI.ffi_type_void, LibFFI.ffi_type_pointer);
                }

                @Override
                public void callback(long l, long l2) {
                    long l3 = MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(l2));
                    this.free(l3);
                }
            }.address(), new CallbackI(){

                @Override
                public FFICIF getCallInterface() {
                    return APIUtil.apiCreateCIF(LibFFI.FFI_DEFAULT_ABI, LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer);
                }

                @Override
                public void callback(long l, long l2) {
                    long l3 = MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(l2));
                    long l4 = MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(l2 + (long)POINTER_SIZE));
                    MemoryUtil.memPutAddress(l, this.aligned_alloc(l3, l4));
                }
            }.address(), new CallbackI(){

                @Override
                public FFICIF getCallInterface() {
                    return APIUtil.apiCreateCIF(LibFFI.FFI_DEFAULT_ABI, LibFFI.ffi_type_void, LibFFI.ffi_type_pointer);
                }

                @Override
                public void callback(long l, long l2) {
                    long l3 = MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(l2));
                    this.aligned_free(l3);
                }
            }.address()};
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                for (long l : this.callbacks) {
                    Callback.free(l);
                }
                if (ALLOCATIONS.isEmpty()) {
                    return;
                }
                boolean bl = false;
                for (Allocation allocation : ALLOCATIONS.keySet()) {
                    StringBuilder stringBuilder = new StringBuilder(512);
                    stringBuilder.append("[LWJGL] ").append(allocation.size).append(" bytes leaked, thread ").append(allocation.threadId).append(" (").append((String)THREADS.get(allocation.threadId)).append("), address: 0x").append(Long.toHexString(allocation.address).toUpperCase()).append("\n");
                    StackTraceElement[] stackTraceElementArray = allocation.getElements();
                    if (stackTraceElementArray != null) {
                        for (StackTraceElement stackTraceElement : stackTraceElementArray) {
                            stringBuilder.append("\tat ").append(((Object)stackTraceElement).toString()).append("\n");
                        }
                    } else {
                        bl = true;
                    }
                    APIUtil.DEBUG_STREAM.print(stringBuilder);
                }
                if (bl) {
                    APIUtil.DEBUG_STREAM.print("[LWJGL] Reminder: disable Configuration.DEBUG_MEMORY_ALLOCATOR_FAST to get stacktraces of leaking allocations.\n");
                }
            }));
        }

        @Override
        public long getMalloc() {
            return this.callbacks[0];
        }

        @Override
        public long getCalloc() {
            return this.callbacks[1];
        }

        @Override
        public long getRealloc() {
            return this.callbacks[2];
        }

        @Override
        public long getFree() {
            return this.callbacks[3];
        }

        @Override
        public long getAlignedAlloc() {
            return this.callbacks[4];
        }

        @Override
        public long getAlignedFree() {
            return this.callbacks[5];
        }

        @Override
        public long malloc(long l) {
            return DebugAllocator.track(this.allocator.malloc(l), l);
        }

        @Override
        public long calloc(long l, long l2) {
            return DebugAllocator.track(this.allocator.calloc(l, l2), l * l2);
        }

        @Override
        public long realloc(long l, long l2) {
            long l3 = DebugAllocator.untrack(l);
            long l4 = this.allocator.realloc(l, l2);
            if (l4 != 0L) {
                DebugAllocator.track(l4, l2);
            } else if (l2 != 0L) {
                DebugAllocator.track(l, l3);
            }
            return l4;
        }

        @Override
        public void free(long l) {
            DebugAllocator.untrack(l);
            this.allocator.free(l);
        }

        @Override
        public long aligned_alloc(long l, long l2) {
            return DebugAllocator.track(this.allocator.aligned_alloc(l, l2), l2);
        }

        @Override
        public void aligned_free(long l) {
            DebugAllocator.untrack(l);
            this.allocator.aligned_free(l);
        }

        static long track(long l, long l2) {
            if (l != 0L) {
                Thread thread2 = Thread.currentThread();
                THREADS.putIfAbsent(thread2.getId(), thread2.getName());
                Allocation allocation = new Allocation(l, l2, thread2.getId(), Configuration.DEBUG_MEMORY_ALLOCATOR_FAST.get(false) != false ? null : StackWalkUtil.stackWalkGetTrace());
                Allocation allocation2 = ALLOCATIONS.put(allocation, allocation);
                if (allocation2 != null) {
                    DebugAllocator.trackAbort(l, allocation2, allocation);
                }
            }
            return l;
        }

        private static void trackAbort(long l, Allocation allocation, Allocation allocation2) {
            String string = Long.toHexString(l).toUpperCase();
            DebugAllocator.trackAbortPrint(allocation, "Old", string);
            DebugAllocator.trackAbortPrint(allocation2, "New", string);
            throw new IllegalStateException("The memory address specified is already being tracked: 0x" + string);
        }

        private static void trackAbortPrint(Allocation allocation, String string, String string2) {
            StringBuilder stringBuilder = new StringBuilder(512);
            stringBuilder.append("[LWJGL] ").append(string).append(" allocation with size ").append(allocation.size).append(", thread ").append(allocation.threadId).append(" (").append((String)THREADS.get(allocation.threadId)).append("), address: 0x").append(string2).append("\n");
            StackTraceElement[] stackTraceElementArray = allocation.getElements();
            if (stackTraceElementArray != null) {
                for (StackTraceElement stackTraceElement : stackTraceElementArray) {
                    stringBuilder.append("\tat ").append(((Object)stackTraceElement).toString()).append("\n");
                }
            }
            APIUtil.DEBUG_STREAM.print(stringBuilder);
        }

        static long untrack(long l) {
            if (l == 0L) {
                return 0L;
            }
            Allocation allocation = (Allocation)ALLOCATIONS.remove(new Allocation(l, 0L, 0L, null));
            if (allocation == null) {
                DebugAllocator.untrackAbort(l);
            }
            return allocation.size;
        }

        private static void untrackAbort(long l) {
            String string = Long.toHexString(l).toUpperCase();
            throw new IllegalStateException("The memory address specified is not being tracked: 0x" + string);
        }

        static void report(MemoryUtil.MemoryAllocationReport memoryAllocationReport) {
            for (Allocation allocation : ALLOCATIONS.keySet()) {
                memoryAllocationReport.invoke(allocation.address, allocation.size, allocation.threadId, (String)THREADS.get(allocation.threadId), allocation.getElements());
            }
        }

        private static <T> void aggregate(T t, long l, Map<T, AtomicLong> map) {
            AtomicLong atomicLong = map.computeIfAbsent(t, object -> new AtomicLong());
            atomicLong.set(atomicLong.get() + l);
        }

        static void report(MemoryUtil.MemoryAllocationReport memoryAllocationReport, MemoryUtil.MemoryAllocationReport.Aggregate aggregate, boolean bl) {
            switch (aggregate) {
                case ALL: {
                    DebugAllocator.reportAll(memoryAllocationReport, bl);
                    break;
                }
                case GROUP_BY_METHOD: {
                    DebugAllocator.reportByMethod(memoryAllocationReport, bl);
                    break;
                }
                case GROUP_BY_STACKTRACE: {
                    DebugAllocator.reportByStacktrace(memoryAllocationReport, bl);
                }
            }
        }

        private static void reportAll(MemoryUtil.MemoryAllocationReport memoryAllocationReport, boolean bl) {
            if (bl) {
                HashMap hashMap = new HashMap();
                for (Allocation object : ALLOCATIONS.values()) {
                    DebugAllocator.aggregate(object.threadId, object.size, hashMap);
                }
                for (Map.Entry entry : hashMap.entrySet()) {
                    memoryAllocationReport.invoke(0L, ((AtomicLong)entry.getValue()).get(), (Long)entry.getKey(), (String)THREADS.get(entry.getKey()), null);
                }
            } else {
                long l = 0L;
                for (Allocation allocation : ALLOCATIONS.values()) {
                    l += allocation.size;
                }
                memoryAllocationReport.invoke(0L, l, 0L, null, null);
            }
        }

        private static void reportByMethod(MemoryUtil.MemoryAllocationReport memoryAllocationReport, boolean bl) {
            if (bl) {
                HashMap<Long, Map> hashMap = new HashMap<Long, Map>();
                for (Allocation object : ALLOCATIONS.keySet()) {
                    StackTraceElement[] stackTraceElementArray = object.getElements();
                    if (stackTraceElementArray == null) continue;
                    Map map = hashMap.computeIfAbsent(object.threadId, l -> new HashMap());
                    DebugAllocator.aggregate(stackTraceElementArray[0], object.size, map);
                }
                for (Map.Entry entry : hashMap.entrySet()) {
                    long l2 = (Long)entry.getKey();
                    String string = (String)THREADS.get(l2);
                    for (Map.Entry entry2 : ((Map)entry.getValue()).entrySet()) {
                        memoryAllocationReport.invoke(0L, ((AtomicLong)entry2.getValue()).get(), l2, string, (StackTraceElement)entry2.getKey());
                    }
                }
            } else {
                HashMap hashMap = new HashMap();
                for (Allocation allocation : ALLOCATIONS.keySet()) {
                    StackTraceElement[] stackTraceElementArray = allocation.getElements();
                    if (stackTraceElementArray == null) continue;
                    DebugAllocator.aggregate(stackTraceElementArray[0], allocation.size, hashMap);
                }
                for (Map.Entry entry : hashMap.entrySet()) {
                    memoryAllocationReport.invoke(0L, ((AtomicLong)entry.getValue()).get(), 0L, null, (StackTraceElement)entry.getKey());
                }
            }
        }

        private static void reportByStacktrace(MemoryUtil.MemoryAllocationReport memoryAllocationReport, boolean bl) {
            if (bl) {
                HashMap<Long, Map> hashMap = new HashMap<Long, Map>();
                for (Allocation object : ALLOCATIONS.keySet()) {
                    StackTraceElement[] stackTraceElementArray = object.getElements();
                    if (stackTraceElementArray == null) continue;
                    Map map = hashMap.computeIfAbsent(object.threadId, l -> new HashMap());
                    DebugAllocator.aggregate(new AllocationKey(stackTraceElementArray), object.size, map);
                }
                for (Map.Entry entry : hashMap.entrySet()) {
                    long l2 = (Long)entry.getKey();
                    for (Map.Entry entry2 : ((Map)entry.getValue()).entrySet()) {
                        memoryAllocationReport.invoke(0L, ((AtomicLong)entry2.getValue()).get(), l2, (String)THREADS.get(l2), ((AllocationKey)entry2.getKey()).elements);
                    }
                }
            } else {
                HashMap hashMap = new HashMap();
                for (Allocation allocation : ALLOCATIONS.keySet()) {
                    StackTraceElement[] stackTraceElementArray = allocation.getElements();
                    if (stackTraceElementArray == null) continue;
                    DebugAllocator.aggregate(new AllocationKey(stackTraceElementArray), allocation.size, hashMap);
                }
                for (Map.Entry entry : hashMap.entrySet()) {
                    memoryAllocationReport.invoke(0L, ((AtomicLong)entry.getValue()).get(), 0L, null, ((AllocationKey)entry.getKey()).elements);
                }
            }
        }

        private static class AllocationKey {
            final StackTraceElement[] elements;

            AllocationKey(StackTraceElement[] stackTraceElementArray) {
                this.elements = stackTraceElementArray;
            }

            public boolean equals(Object object) {
                return this == object || Arrays.equals(this.elements, ((AllocationKey)object).elements);
            }

            public int hashCode() {
                return Arrays.hashCode(this.elements);
            }
        }

        private static class Allocation {
            final long address;
            final long size;
            final long threadId;
            private final Object @Nullable [] stacktrace;

            Allocation(long l, long l2, long l3, Object @Nullable [] objectArray) {
                this.address = l;
                this.size = l2;
                this.threadId = l3;
                this.stacktrace = objectArray;
            }

            private StackTraceElement @Nullable [] getElements() {
                return this.stacktrace == null ? null : StackWalkUtil.stackWalkArray(this.stacktrace);
            }

            public boolean equals(Object object) {
                return this.address == ((Allocation)object).address;
            }

            public int hashCode() {
                return Long.hashCode(this.address);
            }
        }
    }

    private static class StdlibAllocator
    implements MemoryUtil.MemoryAllocator {
        private StdlibAllocator() {
        }

        @Override
        public long getMalloc() {
            return MemoryAccessJNI.malloc;
        }

        @Override
        public long getCalloc() {
            return MemoryAccessJNI.calloc;
        }

        @Override
        public long getRealloc() {
            return MemoryAccessJNI.realloc;
        }

        @Override
        public long getFree() {
            return MemoryAccessJNI.free;
        }

        @Override
        public long getAlignedAlloc() {
            return MemoryAccessJNI.aligned_alloc;
        }

        @Override
        public long getAlignedFree() {
            return MemoryAccessJNI.aligned_free;
        }

        @Override
        public long malloc(long l) {
            return LibCStdlib.nmalloc(l);
        }

        @Override
        public long calloc(long l, long l2) {
            return LibCStdlib.ncalloc(l, l2);
        }

        @Override
        public long realloc(long l, long l2) {
            return LibCStdlib.nrealloc(l, l2);
        }

        @Override
        public void free(long l) {
            LibCStdlib.nfree(l);
        }

        @Override
        public long aligned_alloc(long l, long l2) {
            return LibCStdlib.naligned_alloc(l, l2);
        }

        @Override
        public void aligned_free(long l) {
            LibCStdlib.naligned_free(l);
        }
    }
}


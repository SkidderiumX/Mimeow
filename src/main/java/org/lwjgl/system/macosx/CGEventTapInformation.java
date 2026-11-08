/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.macosx;

import java.nio.ByteBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

public class CGEventTapInformation
extends Struct<CGEventTapInformation>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int EVENTTAPID;
    public static final int TAPPOINT;
    public static final int OPTIONS;
    public static final int EVENTSOFINTEREST;
    public static final int TAPPINGPROCESS;
    public static final int PROCESSBEINGTAPPED;
    public static final int ENABLED;
    public static final int MINUSECLATENCY;
    public static final int AVGUSECLATENCY;
    public static final int MAXUSECLATENCY;

    protected CGEventTapInformation(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected CGEventTapInformation create(long l, @Nullable ByteBuffer byteBuffer) {
        return new CGEventTapInformation(l, byteBuffer);
    }

    public CGEventTapInformation(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), CGEventTapInformation.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="uint32_t")
    public int eventTapID() {
        return CGEventTapInformation.neventTapID(this.address());
    }

    @NativeType(value="CGEventTapLocation")
    public int tapPoint() {
        return CGEventTapInformation.ntapPoint(this.address());
    }

    @NativeType(value="CGEventTapOptions")
    public int options() {
        return CGEventTapInformation.noptions(this.address());
    }

    @NativeType(value="CGEventMask")
    public long eventsOfInterest() {
        return CGEventTapInformation.neventsOfInterest(this.address());
    }

    @NativeType(value="pid_t")
    public long tappingProcess() {
        return CGEventTapInformation.ntappingProcess(this.address());
    }

    @NativeType(value="pid_t")
    public long processBeingTapped() {
        return CGEventTapInformation.nprocessBeingTapped(this.address());
    }

    @NativeType(value="bool")
    public boolean enabled() {
        return CGEventTapInformation.nenabled(this.address());
    }

    public float minUsecLatency() {
        return CGEventTapInformation.nminUsecLatency(this.address());
    }

    public float avgUsecLatency() {
        return CGEventTapInformation.navgUsecLatency(this.address());
    }

    public float maxUsecLatency() {
        return CGEventTapInformation.nmaxUsecLatency(this.address());
    }

    public static CGEventTapInformation malloc() {
        return new CGEventTapInformation(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static CGEventTapInformation calloc() {
        return new CGEventTapInformation(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static CGEventTapInformation create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new CGEventTapInformation(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static CGEventTapInformation create(long l) {
        return new CGEventTapInformation(l, null);
    }

    public static @Nullable CGEventTapInformation createSafe(long l) {
        return l == 0L ? null : new CGEventTapInformation(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(CGEventTapInformation.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = CGEventTapInformation.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static CGEventTapInformation mallocStack() {
        return CGEventTapInformation.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static CGEventTapInformation callocStack() {
        return CGEventTapInformation.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static CGEventTapInformation mallocStack(MemoryStack memoryStack) {
        return CGEventTapInformation.malloc(memoryStack);
    }

    @Deprecated
    public static CGEventTapInformation callocStack(MemoryStack memoryStack) {
        return CGEventTapInformation.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return CGEventTapInformation.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return CGEventTapInformation.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return CGEventTapInformation.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return CGEventTapInformation.calloc(n, memoryStack);
    }

    public static CGEventTapInformation malloc(MemoryStack memoryStack) {
        return new CGEventTapInformation(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static CGEventTapInformation calloc(MemoryStack memoryStack) {
        return new CGEventTapInformation(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static int neventTapID(long l) {
        return MemoryUtil.memGetInt(l + (long)EVENTTAPID);
    }

    public static int ntapPoint(long l) {
        return MemoryUtil.memGetInt(l + (long)TAPPOINT);
    }

    public static int noptions(long l) {
        return MemoryUtil.memGetInt(l + (long)OPTIONS);
    }

    public static long neventsOfInterest(long l) {
        return MemoryUtil.memGetLong(l + (long)EVENTSOFINTEREST);
    }

    public static long ntappingProcess(long l) {
        return MemoryUtil.memGetAddress(l + (long)TAPPINGPROCESS);
    }

    public static long nprocessBeingTapped(long l) {
        return MemoryUtil.memGetAddress(l + (long)PROCESSBEINGTAPPED);
    }

    public static boolean nenabled(long l) {
        return MemoryUtil.memGetByte(l + (long)ENABLED) != 0;
    }

    public static float nminUsecLatency(long l) {
        return MemoryUtil.memGetFloat(l + (long)MINUSECLATENCY);
    }

    public static float navgUsecLatency(long l) {
        return MemoryUtil.memGetFloat(l + (long)AVGUSECLATENCY);
    }

    public static float nmaxUsecLatency(long l) {
        return MemoryUtil.memGetFloat(l + (long)MAXUSECLATENCY);
    }

    static {
        Struct.Layout layout = CGEventTapInformation.__struct(CGEventTapInformation.__member(4), CGEventTapInformation.__member(4), CGEventTapInformation.__member(4), CGEventTapInformation.__member(8), CGEventTapInformation.__member(POINTER_SIZE), CGEventTapInformation.__member(POINTER_SIZE), CGEventTapInformation.__member(1), CGEventTapInformation.__member(4), CGEventTapInformation.__member(4), CGEventTapInformation.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        EVENTTAPID = layout.offsetof(0);
        TAPPOINT = layout.offsetof(1);
        OPTIONS = layout.offsetof(2);
        EVENTSOFINTEREST = layout.offsetof(3);
        TAPPINGPROCESS = layout.offsetof(4);
        PROCESSBEINGTAPPED = layout.offsetof(5);
        ENABLED = layout.offsetof(6);
        MINUSECLATENCY = layout.offsetof(7);
        AVGUSECLATENCY = layout.offsetof(8);
        MAXUSECLATENCY = layout.offsetof(9);
    }

    public static class Buffer
    extends StructBuffer<CGEventTapInformation, Buffer>
    implements NativeResource {
        private static final CGEventTapInformation ELEMENT_FACTORY = CGEventTapInformation.create(-1L);

        public Buffer(ByteBuffer byteBuffer) {
            super(byteBuffer, byteBuffer.remaining() / SIZEOF);
        }

        public Buffer(long l, int n) {
            super(l, null, -1, 0, n, n);
        }

        Buffer(long l, @Nullable ByteBuffer byteBuffer, int n, int n2, int n3, int n4) {
            super(l, byteBuffer, n, n2, n3, n4);
        }

        @Override
        protected Buffer self() {
            return this;
        }

        @Override
        protected Buffer create(long l, @Nullable ByteBuffer byteBuffer, int n, int n2, int n3, int n4) {
            return new Buffer(l, byteBuffer, n, n2, n3, n4);
        }

        @Override
        protected CGEventTapInformation getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="uint32_t")
        public int eventTapID() {
            return CGEventTapInformation.neventTapID(this.address());
        }

        @NativeType(value="CGEventTapLocation")
        public int tapPoint() {
            return CGEventTapInformation.ntapPoint(this.address());
        }

        @NativeType(value="CGEventTapOptions")
        public int options() {
            return CGEventTapInformation.noptions(this.address());
        }

        @NativeType(value="CGEventMask")
        public long eventsOfInterest() {
            return CGEventTapInformation.neventsOfInterest(this.address());
        }

        @NativeType(value="pid_t")
        public long tappingProcess() {
            return CGEventTapInformation.ntappingProcess(this.address());
        }

        @NativeType(value="pid_t")
        public long processBeingTapped() {
            return CGEventTapInformation.nprocessBeingTapped(this.address());
        }

        @NativeType(value="bool")
        public boolean enabled() {
            return CGEventTapInformation.nenabled(this.address());
        }

        public float minUsecLatency() {
            return CGEventTapInformation.nminUsecLatency(this.address());
        }

        public float avgUsecLatency() {
            return CGEventTapInformation.navgUsecLatency(this.address());
        }

        public float maxUsecLatency() {
            return CGEventTapInformation.nmaxUsecLatency(this.address());
        }
    }
}


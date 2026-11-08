/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.Buffer;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.function.LongPredicate;
import org.jspecify.annotations.Nullable;
import org.lwjgl.CLongBuffer;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.CustomBuffer;
import org.lwjgl.system.Library;
import org.lwjgl.system.MathUtil;
import org.lwjgl.system.MemoryManage;
import org.lwjgl.system.MultiReleaseMemCopy;
import org.lwjgl.system.MultiReleaseTextDecoding;
import org.lwjgl.system.Pointer;
import org.lwjgl.system.Struct;
import org.lwjgl.system.jni.JNINativeInterface;
import org.lwjgl.system.libc.LibCString;
import sun.misc.Unsafe;

public class MemoryUtil {
    public static final long NULL = 0L;
    public static final int PAGE_SIZE;
    public static final int CACHE_LINE_SIZE;
    static final int ARRAY_TLC_SIZE;
    static final ThreadLocal<byte[]> ARRAY_TLC_BYTE;
    static final ThreadLocal<char[]> ARRAY_TLC_CHAR;
    static final Unsafe UNSAFE;
    static final ByteOrder NATIVE_ORDER;
    private static final Charset UTF16;
    static final Class<? extends ByteBuffer> BUFFER_BYTE;
    static final Class<? extends ShortBuffer> BUFFER_SHORT;
    static final Class<? extends CharBuffer> BUFFER_CHAR;
    static final Class<? extends IntBuffer> BUFFER_INT;
    static final Class<? extends LongBuffer> BUFFER_LONG;
    static final Class<? extends FloatBuffer> BUFFER_FLOAT;
    static final Class<? extends DoubleBuffer> BUFFER_DOUBLE;
    private static final long MARK;
    private static final long POSITION;
    private static final long LIMIT;
    private static final long CAPACITY;
    private static final long ADDRESS;
    private static final long PARENT_BYTE;
    private static final long PARENT_SHORT;
    private static final long PARENT_CHAR;
    private static final long PARENT_INT;
    private static final long PARENT_LONG;
    private static final long PARENT_FLOAT;
    private static final long PARENT_DOUBLE;
    private static final int FILL_PATTERN_32;
    private static final long FILL_PATTERN_64;
    private static final int MAGIC_CAPACITY = 219540062;
    private static final int MAGIC_POSITION = 16435934;

    private MemoryUtil() {
    }

    public static MemoryAllocator getAllocator() {
        return MemoryUtil.getAllocator(false);
    }

    public static MemoryAllocator getAllocator(boolean bl) {
        return bl ? LazyInit.ALLOCATOR : LazyInit.ALLOCATOR_IMPL;
    }

    public static long nmemAlloc(long l) {
        return LazyInit.ALLOCATOR.malloc(l);
    }

    public static long nmemAllocChecked(long l) {
        long l2 = MemoryUtil.nmemAlloc(l != 0L ? l : 1L);
        if (Checks.CHECKS && l2 == 0L) {
            throw new OutOfMemoryError();
        }
        return l2;
    }

    private static long getAllocationSize(int n, int n2) {
        return APIUtil.apiCheckAllocation(n, Integer.toUnsignedLong(n) << n2, Pointer.BITS64 ? Long.MAX_VALUE : 0xFFFFFFFFL);
    }

    public static ByteBuffer memAlloc(int n) {
        return MemoryUtil.wrapBufferByte(MemoryUtil.nmemAllocChecked(n), n);
    }

    public static ShortBuffer memAllocShort(int n) {
        return MemoryUtil.wrapBufferShort(MemoryUtil.nmemAllocChecked(MemoryUtil.getAllocationSize(n, 1)), n);
    }

    public static IntBuffer memAllocInt(int n) {
        return MemoryUtil.wrapBufferInt(MemoryUtil.nmemAllocChecked(MemoryUtil.getAllocationSize(n, 2)), n);
    }

    public static FloatBuffer memAllocFloat(int n) {
        return MemoryUtil.wrapBufferFloat(MemoryUtil.nmemAllocChecked(MemoryUtil.getAllocationSize(n, 2)), n);
    }

    public static LongBuffer memAllocLong(int n) {
        return MemoryUtil.wrapBufferLong(MemoryUtil.nmemAllocChecked(MemoryUtil.getAllocationSize(n, 3)), n);
    }

    public static CLongBuffer memAllocCLong(int n) {
        return CLongBuffer.create(MemoryUtil.nmemAllocChecked(MemoryUtil.getAllocationSize(n, Pointer.CLONG_SHIFT)), n);
    }

    public static DoubleBuffer memAllocDouble(int n) {
        return MemoryUtil.wrapBufferDouble(MemoryUtil.nmemAllocChecked(MemoryUtil.getAllocationSize(n, 3)), n);
    }

    public static PointerBuffer memAllocPointer(int n) {
        return PointerBuffer.create(MemoryUtil.nmemAllocChecked(MemoryUtil.getAllocationSize(n, Pointer.POINTER_SHIFT)), n);
    }

    public static void nmemFree(long l) {
        LazyInit.ALLOCATOR.free(l);
    }

    public static void memFree(@Nullable Buffer buffer) {
        if (buffer != null) {
            MemoryUtil.nmemFree(UNSAFE.getLong(buffer, ADDRESS));
        }
    }

    public static void memFree(@Nullable ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            MemoryUtil.nmemFree(UNSAFE.getLong(byteBuffer, ADDRESS));
        }
    }

    public static void memFree(@Nullable ShortBuffer shortBuffer) {
        if (shortBuffer != null) {
            MemoryUtil.nmemFree(UNSAFE.getLong(shortBuffer, ADDRESS));
        }
    }

    public static void memFree(@Nullable CharBuffer charBuffer) {
        if (charBuffer != null) {
            MemoryUtil.nmemFree(UNSAFE.getLong(charBuffer, ADDRESS));
        }
    }

    public static void memFree(@Nullable IntBuffer intBuffer) {
        if (intBuffer != null) {
            MemoryUtil.nmemFree(UNSAFE.getLong(intBuffer, ADDRESS));
        }
    }

    public static void memFree(@Nullable LongBuffer longBuffer) {
        if (longBuffer != null) {
            MemoryUtil.nmemFree(UNSAFE.getLong(longBuffer, ADDRESS));
        }
    }

    public static void memFree(@Nullable FloatBuffer floatBuffer) {
        if (floatBuffer != null) {
            MemoryUtil.nmemFree(UNSAFE.getLong(floatBuffer, ADDRESS));
        }
    }

    public static void memFree(@Nullable DoubleBuffer doubleBuffer) {
        if (doubleBuffer != null) {
            MemoryUtil.nmemFree(UNSAFE.getLong(doubleBuffer, ADDRESS));
        }
    }

    public static void memFree(@Nullable CustomBuffer<?> customBuffer) {
        if (customBuffer != null) {
            MemoryUtil.nmemFree(customBuffer.address);
        }
    }

    public static long nmemCalloc(long l, long l2) {
        return LazyInit.ALLOCATOR.calloc(l, l2);
    }

    public static long nmemCallocChecked(long l, long l2) {
        if (l == 0L || l2 == 0L) {
            l = 1L;
            l2 = 1L;
        }
        long l3 = MemoryUtil.nmemCalloc(l, l2);
        if (Checks.CHECKS && l3 == 0L) {
            throw new OutOfMemoryError();
        }
        return l3;
    }

    public static ByteBuffer memCalloc(int n, int n2) {
        return MemoryUtil.wrapBufferByte(MemoryUtil.nmemCallocChecked(n, n2), n * n2);
    }

    public static ByteBuffer memCalloc(int n) {
        return MemoryUtil.wrapBufferByte(MemoryUtil.nmemCallocChecked(n, 1L), n);
    }

    public static ShortBuffer memCallocShort(int n) {
        return MemoryUtil.wrapBufferShort(MemoryUtil.nmemCallocChecked(n, 2L), n);
    }

    public static IntBuffer memCallocInt(int n) {
        return MemoryUtil.wrapBufferInt(MemoryUtil.nmemCallocChecked(n, 4L), n);
    }

    public static FloatBuffer memCallocFloat(int n) {
        return MemoryUtil.wrapBufferFloat(MemoryUtil.nmemCallocChecked(n, 4L), n);
    }

    public static LongBuffer memCallocLong(int n) {
        return MemoryUtil.wrapBufferLong(MemoryUtil.nmemCallocChecked(n, 8L), n);
    }

    public static CLongBuffer memCallocCLong(int n) {
        return CLongBuffer.create(MemoryUtil.nmemCallocChecked(n, Pointer.CLONG_SIZE), n);
    }

    public static DoubleBuffer memCallocDouble(int n) {
        return MemoryUtil.wrapBufferDouble(MemoryUtil.nmemCallocChecked(n, 8L), n);
    }

    public static PointerBuffer memCallocPointer(int n) {
        return PointerBuffer.create(MemoryUtil.nmemCallocChecked(n, Pointer.POINTER_SIZE), n);
    }

    public static long nmemRealloc(long l, long l2) {
        return LazyInit.ALLOCATOR.realloc(l, l2);
    }

    public static long nmemReallocChecked(long l, long l2) {
        long l3 = MemoryUtil.nmemRealloc(l, l2 != 0L ? l2 : 1L);
        if (Checks.CHECKS && l3 == 0L) {
            throw new OutOfMemoryError();
        }
        return l3;
    }

    private static <T extends Buffer> T realloc(@Nullable T t, T t2, int n) {
        if (t != null) {
            t2.position(Math.min(t.position(), n));
        }
        return t2;
    }

    public static ByteBuffer memRealloc(@Nullable ByteBuffer byteBuffer, int n) {
        return MemoryUtil.realloc(byteBuffer, MemoryUtil.memByteBuffer(MemoryUtil.nmemReallocChecked(byteBuffer == null ? 0L : UNSAFE.getLong(byteBuffer, ADDRESS), n), n), n);
    }

    public static ShortBuffer memRealloc(@Nullable ShortBuffer shortBuffer, int n) {
        return MemoryUtil.realloc(shortBuffer, MemoryUtil.memShortBuffer(MemoryUtil.nmemReallocChecked(shortBuffer == null ? 0L : UNSAFE.getLong(shortBuffer, ADDRESS), MemoryUtil.getAllocationSize(n, 1)), n), n);
    }

    public static IntBuffer memRealloc(@Nullable IntBuffer intBuffer, int n) {
        return MemoryUtil.realloc(intBuffer, MemoryUtil.memIntBuffer(MemoryUtil.nmemReallocChecked(intBuffer == null ? 0L : UNSAFE.getLong(intBuffer, ADDRESS), MemoryUtil.getAllocationSize(n, 2)), n), n);
    }

    public static LongBuffer memRealloc(@Nullable LongBuffer longBuffer, int n) {
        return MemoryUtil.realloc(longBuffer, MemoryUtil.memLongBuffer(MemoryUtil.nmemReallocChecked(longBuffer == null ? 0L : UNSAFE.getLong(longBuffer, ADDRESS), MemoryUtil.getAllocationSize(n, 3)), n), n);
    }

    public static CLongBuffer memRealloc(@Nullable CLongBuffer cLongBuffer, int n) {
        CLongBuffer cLongBuffer2 = MemoryUtil.memCLongBuffer(MemoryUtil.nmemReallocChecked(cLongBuffer == null ? 0L : cLongBuffer.address, MemoryUtil.getAllocationSize(n, Pointer.CLONG_SIZE)), n);
        if (cLongBuffer != null) {
            cLongBuffer2.position(Math.min(cLongBuffer.position(), n));
        }
        return cLongBuffer2;
    }

    public static FloatBuffer memRealloc(@Nullable FloatBuffer floatBuffer, int n) {
        return MemoryUtil.realloc(floatBuffer, MemoryUtil.memFloatBuffer(MemoryUtil.nmemReallocChecked(floatBuffer == null ? 0L : UNSAFE.getLong(floatBuffer, ADDRESS), MemoryUtil.getAllocationSize(n, 2)), n), n);
    }

    public static DoubleBuffer memRealloc(@Nullable DoubleBuffer doubleBuffer, int n) {
        return MemoryUtil.realloc(doubleBuffer, MemoryUtil.memDoubleBuffer(MemoryUtil.nmemReallocChecked(doubleBuffer == null ? 0L : UNSAFE.getLong(doubleBuffer, ADDRESS), MemoryUtil.getAllocationSize(n, 3)), n), n);
    }

    public static PointerBuffer memRealloc(@Nullable PointerBuffer pointerBuffer, int n) {
        PointerBuffer pointerBuffer2 = MemoryUtil.memPointerBuffer(MemoryUtil.nmemReallocChecked(pointerBuffer == null ? 0L : pointerBuffer.address, MemoryUtil.getAllocationSize(n, Pointer.POINTER_SHIFT)), n);
        if (pointerBuffer != null) {
            pointerBuffer2.position(Math.min(pointerBuffer.position(), n));
        }
        return pointerBuffer2;
    }

    public static long nmemAlignedAlloc(long l, long l2) {
        return LazyInit.ALLOCATOR.aligned_alloc(l, l2);
    }

    public static long nmemAlignedAllocChecked(long l, long l2) {
        long l3 = MemoryUtil.nmemAlignedAlloc(l, l2 != 0L ? l2 : 1L);
        if (Checks.CHECKS && l3 == 0L) {
            throw new OutOfMemoryError();
        }
        return l3;
    }

    public static ByteBuffer memAlignedAlloc(int n, int n2) {
        return MemoryUtil.wrapBufferByte(MemoryUtil.nmemAlignedAllocChecked(n, n2), n2);
    }

    public static void nmemAlignedFree(long l) {
        LazyInit.ALLOCATOR.aligned_free(l);
    }

    public static void memAlignedFree(@Nullable ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            MemoryUtil.nmemAlignedFree(UNSAFE.getLong(byteBuffer, ADDRESS));
        }
    }

    public static void memReport(MemoryAllocationReport memoryAllocationReport) {
        MemoryManage.DebugAllocator.report(memoryAllocationReport);
    }

    public static void memReport(MemoryAllocationReport memoryAllocationReport, MemoryAllocationReport.Aggregate aggregate, boolean bl) {
        MemoryManage.DebugAllocator.report(memoryAllocationReport, aggregate, bl);
    }

    public static long memAddress0(Buffer buffer) {
        return UNSAFE.getLong(buffer, ADDRESS);
    }

    public static long memAddress0(ByteBuffer byteBuffer) {
        return UNSAFE.getLong(byteBuffer, ADDRESS);
    }

    public static long memAddress0(ShortBuffer shortBuffer) {
        return UNSAFE.getLong(shortBuffer, ADDRESS);
    }

    public static long memAddress0(CharBuffer charBuffer) {
        return UNSAFE.getLong(charBuffer, ADDRESS);
    }

    public static long memAddress0(IntBuffer intBuffer) {
        return UNSAFE.getLong(intBuffer, ADDRESS);
    }

    public static long memAddress0(LongBuffer longBuffer) {
        return UNSAFE.getLong(longBuffer, ADDRESS);
    }

    public static long memAddress0(FloatBuffer floatBuffer) {
        return UNSAFE.getLong(floatBuffer, ADDRESS);
    }

    public static long memAddress0(DoubleBuffer doubleBuffer) {
        return UNSAFE.getLong(doubleBuffer, ADDRESS);
    }

    public static long memAddress(ByteBuffer byteBuffer) {
        return (long)byteBuffer.position() + MemoryUtil.memAddress0(byteBuffer);
    }

    public static long memAddress(ByteBuffer byteBuffer, int n) {
        Objects.requireNonNull(byteBuffer);
        return MemoryUtil.memAddress0(byteBuffer) + Integer.toUnsignedLong(n);
    }

    private static long address(int n, int n2, long l) {
        return l + (((long)n & 0xFFFFFFFFL) << n2);
    }

    public static long memAddress(ShortBuffer shortBuffer) {
        return MemoryUtil.address(shortBuffer.position(), 1, MemoryUtil.memAddress0(shortBuffer));
    }

    public static long memAddress(ShortBuffer shortBuffer, int n) {
        Objects.requireNonNull(shortBuffer);
        return MemoryUtil.address(n, 1, MemoryUtil.memAddress0(shortBuffer));
    }

    public static long memAddress(CharBuffer charBuffer) {
        return MemoryUtil.address(charBuffer.position(), 1, MemoryUtil.memAddress0(charBuffer));
    }

    public static long memAddress(CharBuffer charBuffer, int n) {
        Objects.requireNonNull(charBuffer);
        return MemoryUtil.address(n, 1, MemoryUtil.memAddress0(charBuffer));
    }

    public static long memAddress(IntBuffer intBuffer) {
        return MemoryUtil.address(intBuffer.position(), 2, MemoryUtil.memAddress0(intBuffer));
    }

    public static long memAddress(IntBuffer intBuffer, int n) {
        Objects.requireNonNull(intBuffer);
        return MemoryUtil.address(n, 2, MemoryUtil.memAddress0(intBuffer));
    }

    public static long memAddress(FloatBuffer floatBuffer) {
        return MemoryUtil.address(floatBuffer.position(), 2, MemoryUtil.memAddress0(floatBuffer));
    }

    public static long memAddress(FloatBuffer floatBuffer, int n) {
        Objects.requireNonNull(floatBuffer);
        return MemoryUtil.address(n, 2, MemoryUtil.memAddress0(floatBuffer));
    }

    public static long memAddress(LongBuffer longBuffer) {
        return MemoryUtil.address(longBuffer.position(), 3, MemoryUtil.memAddress0(longBuffer));
    }

    public static long memAddress(LongBuffer longBuffer, int n) {
        Objects.requireNonNull(longBuffer);
        return MemoryUtil.address(n, 3, MemoryUtil.memAddress0(longBuffer));
    }

    public static long memAddress(DoubleBuffer doubleBuffer) {
        return MemoryUtil.address(doubleBuffer.position(), 3, MemoryUtil.memAddress0(doubleBuffer));
    }

    public static long memAddress(DoubleBuffer doubleBuffer, int n) {
        Objects.requireNonNull(doubleBuffer);
        return MemoryUtil.address(n, 3, MemoryUtil.memAddress0(doubleBuffer));
    }

    public static long memAddress(Buffer buffer) {
        int n = buffer instanceof ByteBuffer ? 0 : (buffer instanceof ShortBuffer || buffer instanceof CharBuffer ? 1 : (buffer instanceof IntBuffer || buffer instanceof FloatBuffer ? 2 : 3));
        return MemoryUtil.address(buffer.position(), n, UNSAFE.getLong(buffer, ADDRESS));
    }

    public static long memAddress(CustomBuffer<?> customBuffer) {
        return customBuffer.address();
    }

    public static long memAddress(CustomBuffer<?> customBuffer, int n) {
        return customBuffer.address(n);
    }

    public static long memAddressSafe(@Nullable ByteBuffer byteBuffer) {
        return byteBuffer == null ? 0L : MemoryUtil.memAddress0(byteBuffer) + (long)byteBuffer.position();
    }

    public static long memAddressSafe(@Nullable ShortBuffer shortBuffer) {
        return shortBuffer == null ? 0L : MemoryUtil.address(shortBuffer.position(), 1, MemoryUtil.memAddress0(shortBuffer));
    }

    public static long memAddressSafe(@Nullable CharBuffer charBuffer) {
        return charBuffer == null ? 0L : MemoryUtil.address(charBuffer.position(), 1, MemoryUtil.memAddress0(charBuffer));
    }

    public static long memAddressSafe(@Nullable IntBuffer intBuffer) {
        return intBuffer == null ? 0L : MemoryUtil.address(intBuffer.position(), 2, MemoryUtil.memAddress0(intBuffer));
    }

    public static long memAddressSafe(@Nullable FloatBuffer floatBuffer) {
        return floatBuffer == null ? 0L : MemoryUtil.address(floatBuffer.position(), 2, MemoryUtil.memAddress0(floatBuffer));
    }

    public static long memAddressSafe(@Nullable LongBuffer longBuffer) {
        return longBuffer == null ? 0L : MemoryUtil.address(longBuffer.position(), 3, MemoryUtil.memAddress0(longBuffer));
    }

    public static long memAddressSafe(@Nullable DoubleBuffer doubleBuffer) {
        return doubleBuffer == null ? 0L : MemoryUtil.address(doubleBuffer.position(), 3, MemoryUtil.memAddress0(doubleBuffer));
    }

    public static long memAddressSafe(@Nullable Pointer pointer) {
        return pointer == null ? 0L : pointer.address();
    }

    public static ByteBuffer memByteBuffer(long l, int n) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return MemoryUtil.wrapBufferByte(l, n);
    }

    public static @Nullable ByteBuffer memByteBufferSafe(long l, int n) {
        return l == 0L ? null : MemoryUtil.wrapBufferByte(l, n);
    }

    public static ByteBuffer memByteBuffer(ShortBuffer shortBuffer) {
        if (Checks.CHECKS && 0x3FFFFFFF < shortBuffer.remaining()) {
            throw new IllegalStateException("The source buffer range is too wide");
        }
        return MemoryUtil.wrapBufferByte(MemoryUtil.memAddress(shortBuffer), shortBuffer.remaining() << 1);
    }

    public static ByteBuffer memByteBuffer(CharBuffer charBuffer) {
        if (Checks.CHECKS && 0x3FFFFFFF < charBuffer.remaining()) {
            throw new IllegalStateException("The source buffer range is too wide");
        }
        return MemoryUtil.wrapBufferByte(MemoryUtil.memAddress(charBuffer), charBuffer.remaining() << 1);
    }

    public static ByteBuffer memByteBuffer(IntBuffer intBuffer) {
        if (Checks.CHECKS && 0x1FFFFFFF < intBuffer.remaining()) {
            throw new IllegalStateException("The source buffer range is too wide");
        }
        return MemoryUtil.wrapBufferByte(MemoryUtil.memAddress(intBuffer), intBuffer.remaining() << 2);
    }

    public static ByteBuffer memByteBuffer(LongBuffer longBuffer) {
        if (Checks.CHECKS && 0xFFFFFFF < longBuffer.remaining()) {
            throw new IllegalStateException("The source buffer range is too wide");
        }
        return MemoryUtil.wrapBufferByte(MemoryUtil.memAddress(longBuffer), longBuffer.remaining() << 3);
    }

    public static ByteBuffer memByteBuffer(FloatBuffer floatBuffer) {
        if (Checks.CHECKS && 0x1FFFFFFF < floatBuffer.remaining()) {
            throw new IllegalStateException("The source buffer range is too wide");
        }
        return MemoryUtil.wrapBufferByte(MemoryUtil.memAddress(floatBuffer), floatBuffer.remaining() << 2);
    }

    public static ByteBuffer memByteBuffer(DoubleBuffer doubleBuffer) {
        if (Checks.CHECKS && 0xFFFFFFF < doubleBuffer.remaining()) {
            throw new IllegalStateException("The source buffer range is too wide");
        }
        return MemoryUtil.wrapBufferByte(MemoryUtil.memAddress(doubleBuffer), doubleBuffer.remaining() << 3);
    }

    public static ByteBuffer memByteBuffer(CustomBuffer<?> customBuffer) {
        if (Checks.CHECKS && Integer.MAX_VALUE / customBuffer.sizeof() < customBuffer.remaining()) {
            throw new IllegalStateException("The source buffer range is too wide");
        }
        return MemoryUtil.wrapBufferByte(MemoryUtil.memAddress(customBuffer), customBuffer.remaining() * customBuffer.sizeof());
    }

    public static <T extends Struct<T>> ByteBuffer memByteBuffer(T t) {
        return MemoryUtil.wrapBufferByte(t.address, t.sizeof());
    }

    public static ShortBuffer memShortBuffer(long l, int n) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return MemoryUtil.wrapBufferShort(l, n);
    }

    public static @Nullable ShortBuffer memShortBufferSafe(long l, int n) {
        return l == 0L ? null : MemoryUtil.wrapBufferShort(l, n);
    }

    public static CharBuffer memCharBuffer(long l, int n) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return MemoryUtil.wrapBufferChar(l, n);
    }

    public static @Nullable CharBuffer memCharBufferSafe(long l, int n) {
        return l == 0L ? null : MemoryUtil.wrapBufferChar(l, n);
    }

    public static IntBuffer memIntBuffer(long l, int n) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return MemoryUtil.wrapBufferInt(l, n);
    }

    public static @Nullable IntBuffer memIntBufferSafe(long l, int n) {
        return l == 0L ? null : MemoryUtil.wrapBufferInt(l, n);
    }

    public static LongBuffer memLongBuffer(long l, int n) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return MemoryUtil.wrapBufferLong(l, n);
    }

    public static @Nullable LongBuffer memLongBufferSafe(long l, int n) {
        return l == 0L ? null : MemoryUtil.wrapBufferLong(l, n);
    }

    public static CLongBuffer memCLongBuffer(long l, int n) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return CLongBuffer.create(l, n);
    }

    public static @Nullable CLongBuffer memCLongBufferSafe(long l, int n) {
        return l == 0L ? null : CLongBuffer.create(l, n);
    }

    public static FloatBuffer memFloatBuffer(long l, int n) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return MemoryUtil.wrapBufferFloat(l, n);
    }

    public static @Nullable FloatBuffer memFloatBufferSafe(long l, int n) {
        return l == 0L ? null : MemoryUtil.wrapBufferFloat(l, n);
    }

    public static DoubleBuffer memDoubleBuffer(long l, int n) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return MemoryUtil.wrapBufferDouble(l, n);
    }

    public static @Nullable DoubleBuffer memDoubleBufferSafe(long l, int n) {
        return l == 0L ? null : MemoryUtil.wrapBufferDouble(l, n);
    }

    public static PointerBuffer memPointerBuffer(long l, int n) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return PointerBuffer.create(l, n);
    }

    public static @Nullable PointerBuffer memPointerBufferSafe(long l, int n) {
        return l == 0L ? null : PointerBuffer.create(l, n);
    }

    public static ByteBuffer memDuplicate(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        try {
            byteBuffer2 = (ByteBuffer)UNSAFE.allocateInstance(BUFFER_BYTE);
        }
        catch (InstantiationException instantiationException) {
            throw new UnsupportedOperationException(instantiationException);
        }
        UNSAFE.putLong(byteBuffer2, ADDRESS, UNSAFE.getLong(byteBuffer, ADDRESS));
        UNSAFE.putInt(byteBuffer2, MARK, UNSAFE.getInt(byteBuffer, MARK));
        UNSAFE.putInt(byteBuffer2, POSITION, UNSAFE.getInt(byteBuffer, POSITION));
        UNSAFE.putInt(byteBuffer2, LIMIT, UNSAFE.getInt(byteBuffer, LIMIT));
        UNSAFE.putInt(byteBuffer2, CAPACITY, UNSAFE.getInt(byteBuffer, CAPACITY));
        Object object = UNSAFE.getObject(byteBuffer, PARENT_BYTE);
        UNSAFE.putObject(byteBuffer2, PARENT_BYTE, object == null ? byteBuffer : object);
        return byteBuffer2.order(byteBuffer.order());
    }

    public static ShortBuffer memDuplicate(ShortBuffer shortBuffer) {
        return MemoryUtil.duplicate(BUFFER_SHORT, shortBuffer, PARENT_SHORT);
    }

    public static CharBuffer memDuplicate(CharBuffer charBuffer) {
        return MemoryUtil.duplicate(BUFFER_CHAR, charBuffer, PARENT_CHAR);
    }

    public static IntBuffer memDuplicate(IntBuffer intBuffer) {
        return MemoryUtil.duplicate(BUFFER_INT, intBuffer, PARENT_INT);
    }

    public static LongBuffer memDuplicate(LongBuffer longBuffer) {
        return MemoryUtil.duplicate(BUFFER_LONG, longBuffer, PARENT_LONG);
    }

    public static FloatBuffer memDuplicate(FloatBuffer floatBuffer) {
        return MemoryUtil.duplicate(BUFFER_FLOAT, floatBuffer, PARENT_FLOAT);
    }

    public static DoubleBuffer memDuplicate(DoubleBuffer doubleBuffer) {
        return MemoryUtil.duplicate(BUFFER_DOUBLE, doubleBuffer, PARENT_DOUBLE);
    }

    public static ByteBuffer memSlice(ByteBuffer byteBuffer) {
        return MemoryUtil.slice(byteBuffer, MemoryUtil.memAddress0(byteBuffer) + (long)byteBuffer.position(), byteBuffer.remaining());
    }

    public static ShortBuffer memSlice(ShortBuffer shortBuffer) {
        return MemoryUtil.slice(BUFFER_SHORT, shortBuffer, MemoryUtil.address(shortBuffer.position(), 1, MemoryUtil.memAddress0(shortBuffer)), shortBuffer.remaining(), PARENT_SHORT);
    }

    public static CharBuffer memSlice(CharBuffer charBuffer) {
        return MemoryUtil.slice(BUFFER_CHAR, charBuffer, MemoryUtil.address(charBuffer.position(), 1, MemoryUtil.memAddress0(charBuffer)), charBuffer.remaining(), PARENT_CHAR);
    }

    public static IntBuffer memSlice(IntBuffer intBuffer) {
        return MemoryUtil.slice(BUFFER_INT, intBuffer, MemoryUtil.address(intBuffer.position(), 2, MemoryUtil.memAddress0(intBuffer)), intBuffer.remaining(), PARENT_INT);
    }

    public static LongBuffer memSlice(LongBuffer longBuffer) {
        return MemoryUtil.slice(BUFFER_LONG, longBuffer, MemoryUtil.address(longBuffer.position(), 3, MemoryUtil.memAddress0(longBuffer)), longBuffer.remaining(), PARENT_LONG);
    }

    public static FloatBuffer memSlice(FloatBuffer floatBuffer) {
        return MemoryUtil.slice(BUFFER_FLOAT, floatBuffer, MemoryUtil.address(floatBuffer.position(), 2, MemoryUtil.memAddress0(floatBuffer)), floatBuffer.remaining(), PARENT_FLOAT);
    }

    public static DoubleBuffer memSlice(DoubleBuffer doubleBuffer) {
        return MemoryUtil.slice(BUFFER_DOUBLE, doubleBuffer, MemoryUtil.address(doubleBuffer.position(), 3, MemoryUtil.memAddress0(doubleBuffer)), doubleBuffer.remaining(), PARENT_DOUBLE);
    }

    public static ByteBuffer memSlice(ByteBuffer byteBuffer, int n, int n2) {
        int n3 = byteBuffer.position() + n;
        if (n < 0 || byteBuffer.limit() < n3) {
            throw new IllegalArgumentException();
        }
        if (n2 < 0 || byteBuffer.capacity() - n3 < n2) {
            throw new IllegalArgumentException();
        }
        return MemoryUtil.slice(byteBuffer, MemoryUtil.memAddress0(byteBuffer) + (long)n3, n2);
    }

    public static ShortBuffer memSlice(ShortBuffer shortBuffer, int n, int n2) {
        int n3 = shortBuffer.position() + n;
        if (n < 0 || shortBuffer.limit() < n3) {
            throw new IllegalArgumentException();
        }
        if (n2 < 0 || shortBuffer.capacity() - n3 < n2) {
            throw new IllegalArgumentException();
        }
        return MemoryUtil.slice(BUFFER_SHORT, shortBuffer, MemoryUtil.address(n3, 1, MemoryUtil.memAddress0(shortBuffer)), n2, PARENT_SHORT);
    }

    public static CharBuffer memSlice(CharBuffer charBuffer, int n, int n2) {
        int n3 = charBuffer.position() + n;
        if (n < 0 || charBuffer.limit() < n3) {
            throw new IllegalArgumentException();
        }
        if (n2 < 0 || charBuffer.capacity() - n3 < n2) {
            throw new IllegalArgumentException();
        }
        return MemoryUtil.slice(BUFFER_CHAR, charBuffer, MemoryUtil.address(n3, 1, MemoryUtil.memAddress0(charBuffer)), n2, PARENT_CHAR);
    }

    public static IntBuffer memSlice(IntBuffer intBuffer, int n, int n2) {
        int n3 = intBuffer.position() + n;
        if (n < 0 || intBuffer.limit() < n3) {
            throw new IllegalArgumentException();
        }
        if (n2 < 0 || intBuffer.capacity() - n3 < n2) {
            throw new IllegalArgumentException();
        }
        return MemoryUtil.slice(BUFFER_INT, intBuffer, MemoryUtil.address(n3, 2, MemoryUtil.memAddress0(intBuffer)), n2, PARENT_INT);
    }

    public static LongBuffer memSlice(LongBuffer longBuffer, int n, int n2) {
        int n3 = longBuffer.position() + n;
        if (n < 0 || longBuffer.limit() < n3) {
            throw new IllegalArgumentException();
        }
        if (n2 < 0 || longBuffer.capacity() - n3 < n2) {
            throw new IllegalArgumentException();
        }
        return MemoryUtil.slice(BUFFER_LONG, longBuffer, MemoryUtil.address(n3, 3, MemoryUtil.memAddress0(longBuffer)), n2, PARENT_LONG);
    }

    public static FloatBuffer memSlice(FloatBuffer floatBuffer, int n, int n2) {
        int n3 = floatBuffer.position() + n;
        if (n < 0 || floatBuffer.limit() < n3) {
            throw new IllegalArgumentException();
        }
        if (n2 < 0 || floatBuffer.capacity() - n3 < n2) {
            throw new IllegalArgumentException();
        }
        return MemoryUtil.slice(BUFFER_FLOAT, floatBuffer, MemoryUtil.address(n3, 2, MemoryUtil.memAddress0(floatBuffer)), n2, PARENT_FLOAT);
    }

    public static DoubleBuffer memSlice(DoubleBuffer doubleBuffer, int n, int n2) {
        int n3 = doubleBuffer.position() + n;
        if (n < 0 || doubleBuffer.limit() < n3) {
            throw new IllegalArgumentException();
        }
        if (n2 < 0 || doubleBuffer.capacity() - n3 < n2) {
            throw new IllegalArgumentException();
        }
        return MemoryUtil.slice(BUFFER_DOUBLE, doubleBuffer, MemoryUtil.address(n3, 3, MemoryUtil.memAddress0(doubleBuffer)), n2, PARENT_DOUBLE);
    }

    public static <T extends CustomBuffer<T>> T memSlice(T t, int n, int n2) {
        return t.slice(n, n2);
    }

    public static void memSet(ByteBuffer byteBuffer, int n) {
        MemoryUtil.memSet(MemoryUtil.memAddress(byteBuffer), n, byteBuffer.remaining());
    }

    public static void memSet(ShortBuffer shortBuffer, int n) {
        MemoryUtil.memSet(MemoryUtil.memAddress(shortBuffer), n, APIUtil.apiGetBytes(shortBuffer.remaining(), 1));
    }

    public static void memSet(CharBuffer charBuffer, int n) {
        MemoryUtil.memSet(MemoryUtil.memAddress(charBuffer), n, APIUtil.apiGetBytes(charBuffer.remaining(), 1));
    }

    public static void memSet(IntBuffer intBuffer, int n) {
        MemoryUtil.memSet(MemoryUtil.memAddress(intBuffer), n, APIUtil.apiGetBytes(intBuffer.remaining(), 2));
    }

    public static void memSet(LongBuffer longBuffer, int n) {
        MemoryUtil.memSet(MemoryUtil.memAddress(longBuffer), n, APIUtil.apiGetBytes(longBuffer.remaining(), 3));
    }

    public static void memSet(FloatBuffer floatBuffer, int n) {
        MemoryUtil.memSet(MemoryUtil.memAddress(floatBuffer), n, APIUtil.apiGetBytes(floatBuffer.remaining(), 2));
    }

    public static void memSet(DoubleBuffer doubleBuffer, int n) {
        MemoryUtil.memSet(MemoryUtil.memAddress(doubleBuffer), n, APIUtil.apiGetBytes(doubleBuffer.remaining(), 3));
    }

    public static <T extends CustomBuffer<T>> void memSet(T t, int n) {
        MemoryUtil.memSet(MemoryUtil.memAddress(t), n, Integer.toUnsignedLong(t.remaining()) * (long)t.sizeof());
    }

    public static <T extends Struct<T>> void memSet(T t, int n) {
        MemoryUtil.memSet(t.address, n, t.sizeof());
    }

    public static void memCopy(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)byteBuffer2, byteBuffer.remaining());
        }
        MultiReleaseMemCopy.copy(MemoryUtil.memAddress(byteBuffer), MemoryUtil.memAddress(byteBuffer2), byteBuffer.remaining());
    }

    public static void memCopy(ShortBuffer shortBuffer, ShortBuffer shortBuffer2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)shortBuffer2, shortBuffer.remaining());
        }
        MultiReleaseMemCopy.copy(MemoryUtil.memAddress(shortBuffer), MemoryUtil.memAddress(shortBuffer2), APIUtil.apiGetBytes(shortBuffer.remaining(), 1));
    }

    public static void memCopy(CharBuffer charBuffer, CharBuffer charBuffer2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)charBuffer2, charBuffer.remaining());
        }
        MultiReleaseMemCopy.copy(MemoryUtil.memAddress(charBuffer), MemoryUtil.memAddress(charBuffer2), APIUtil.apiGetBytes(charBuffer.remaining(), 1));
    }

    public static void memCopy(IntBuffer intBuffer, IntBuffer intBuffer2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer2, intBuffer.remaining());
        }
        MultiReleaseMemCopy.copy(MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(intBuffer2), APIUtil.apiGetBytes(intBuffer.remaining(), 2));
    }

    public static void memCopy(LongBuffer longBuffer, LongBuffer longBuffer2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)longBuffer2, longBuffer.remaining());
        }
        MultiReleaseMemCopy.copy(MemoryUtil.memAddress(longBuffer), MemoryUtil.memAddress(longBuffer2), APIUtil.apiGetBytes(longBuffer.remaining(), 3));
    }

    public static void memCopy(FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)floatBuffer2, floatBuffer.remaining());
        }
        MultiReleaseMemCopy.copy(MemoryUtil.memAddress(floatBuffer), MemoryUtil.memAddress(floatBuffer2), APIUtil.apiGetBytes(floatBuffer.remaining(), 2));
    }

    public static void memCopy(DoubleBuffer doubleBuffer, DoubleBuffer doubleBuffer2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)doubleBuffer2, doubleBuffer.remaining());
        }
        MultiReleaseMemCopy.copy(MemoryUtil.memAddress(doubleBuffer), MemoryUtil.memAddress(doubleBuffer2), APIUtil.apiGetBytes(doubleBuffer.remaining(), 3));
    }

    public static <T extends CustomBuffer<T>> void memCopy(T t, T t2) {
        if (Checks.CHECKS) {
            Checks.check(t2, t.remaining());
        }
        MultiReleaseMemCopy.copy(MemoryUtil.memAddress(t), MemoryUtil.memAddress(t2), Integer.toUnsignedLong(t.remaining()) * (long)t.sizeof());
    }

    public static <T extends Struct<T>> void memCopy(T t, T t2) {
        MultiReleaseMemCopy.copy(t.address, t2.address, t.sizeof());
    }

    public static void memSet(long l, int n, long l2) {
        if (Checks.DEBUG && (l == 0L || l2 < 0L)) {
            throw new IllegalArgumentException();
        }
        if (l2 < 256L) {
            int n2 = (int)l;
            if (Pointer.BITS64) {
                if ((n2 & 7) == 0) {
                    MemoryUtil.memSet64(l, n, (int)l2 & 0xFF);
                    return;
                }
            } else if ((n2 & 3) == 0) {
                MemoryUtil.memSet32(n2, n, (int)l2 & 0xFF);
                return;
            }
        }
        LibCString.nmemset(l, n, l2);
    }

    private static void memSet64(long l, int n, int n2) {
        int n3;
        int n4 = n2 & 0xFFFFFFF8;
        long l2 = (long)(n & 0xFF) * FILL_PATTERN_64;
        for (n3 = 0; n3 < n4; n3 += 8) {
            UNSAFE.putLong(null, l + (long)n3, l2);
        }
        n3 = (byte)(n & 0xFF);
        for (int i = n4; i < n2; ++i) {
            UNSAFE.putByte(null, l + (long)i, (byte)n3);
        }
    }

    private static void memSet32(int n, int n2, int n3) {
        int n4;
        int n5 = n3 & 0xFFFFFFFC;
        int n6 = (n2 & 0xFF) * FILL_PATTERN_32;
        for (n4 = 0; n4 < n5; n4 += 4) {
            UNSAFE.putInt(null, (long)(n + n4) & 0xFFFFFFFFL, n6);
        }
        n4 = (byte)(n2 & 0xFF);
        for (int i = n5; i < n3; ++i) {
            UNSAFE.putByte(null, (long)(n + i) & 0xFFFFFFFFL, (byte)n4);
        }
    }

    public static void memCopy(long l, long l2, long l3) {
        if (Checks.DEBUG && (l == 0L || l2 == 0L || l3 < 0L)) {
            throw new IllegalArgumentException();
        }
        MultiReleaseMemCopy.copy(l, l2, l3);
    }

    static void memCopyAligned64(long l, long l2, int n) {
        int n2;
        int n3 = n & 0xFFFFFFF8;
        for (n2 = 0; n2 < n3; n2 += 8) {
            UNSAFE.putLong(null, l2 + (long)n2, UNSAFE.getLong(null, l + (long)n2));
        }
        for (n2 = n3; n2 < n; ++n2) {
            UNSAFE.putByte(null, l2 + (long)n2, UNSAFE.getByte(null, l + (long)n2));
        }
    }

    static void memCopyAligned32(int n, int n2, int n3) {
        int n4;
        int n5 = n3 & 0xFFFFFFFC;
        for (n4 = 0; n4 < n5; n4 += 4) {
            UNSAFE.putInt(null, (long)(n2 + n4) & 0xFFFFFFFFL, UNSAFE.getInt(null, (long)(n + n4) & 0xFFFFFFFFL));
        }
        for (n4 = n5; n4 < n3; ++n4) {
            UNSAFE.putByte(null, (long)(n2 + n4) & 0xFFFFFFFFL, UNSAFE.getByte(null, (long)(n + n4) & 0xFFFFFFFFL));
        }
    }

    public static boolean memGetBoolean(long l) {
        return UNSAFE.getByte(null, l) != 0;
    }

    public static byte memGetByte(long l) {
        return UNSAFE.getByte(null, l);
    }

    public static short memGetShort(long l) {
        return UNSAFE.getShort(null, l);
    }

    public static int memGetInt(long l) {
        return UNSAFE.getInt(null, l);
    }

    public static long memGetLong(long l) {
        return UNSAFE.getLong(null, l);
    }

    public static float memGetFloat(long l) {
        return UNSAFE.getFloat(null, l);
    }

    public static double memGetDouble(long l) {
        return UNSAFE.getDouble(null, l);
    }

    public static long memGetCLong(long l) {
        return Pointer.CLONG_SIZE == 8 ? UNSAFE.getLong(null, l) : (long)UNSAFE.getInt(null, l);
    }

    public static long memGetAddress(long l) {
        return Pointer.BITS64 ? UNSAFE.getLong(null, l) : (long)UNSAFE.getInt(null, l) & 0xFFFFFFFFL;
    }

    public static void memPutByte(long l, byte by) {
        UNSAFE.putByte(null, l, by);
    }

    public static void memPutShort(long l, short s) {
        UNSAFE.putShort(null, l, s);
    }

    public static void memPutInt(long l, int n) {
        UNSAFE.putInt(null, l, n);
    }

    public static void memPutLong(long l, long l2) {
        UNSAFE.putLong(null, l, l2);
    }

    public static void memPutFloat(long l, float f) {
        UNSAFE.putFloat(null, l, f);
    }

    public static void memPutDouble(long l, double d) {
        UNSAFE.putDouble(null, l, d);
    }

    public static void memPutCLong(long l, long l2) {
        if (Pointer.CLONG_SIZE == 8) {
            UNSAFE.putLong(null, l, l2);
        } else {
            UNSAFE.putInt(null, l, (int)l2);
        }
    }

    public static void memPutAddress(long l, long l2) {
        if (Pointer.BITS64) {
            UNSAFE.putLong(null, l, l2);
        } else {
            UNSAFE.putInt(null, l, (int)l2);
        }
    }

    public static native <T> T memGlobalRefToObject(long var0);

    private static int write8(long l, int n, int n2) {
        UNSAFE.putByte(null, l + Integer.toUnsignedLong(n), (byte)n2);
        return n + 1;
    }

    private static int write8Safe(long l, int n, int n2, int n3) {
        if (n == n2) {
            throw new BufferOverflowException();
        }
        UNSAFE.putByte(null, l + Integer.toUnsignedLong(n), (byte)n3);
        return n + 1;
    }

    private static int write16(long l, int n, char c) {
        UNSAFE.putShort(null, l + Integer.toUnsignedLong(n), (short)c);
        return n + 2;
    }

    public static ByteBuffer memASCII(CharSequence charSequence) {
        return MemoryUtil.memASCII(charSequence, true);
    }

    public static @Nullable ByteBuffer memASCIISafe(@Nullable CharSequence charSequence) {
        return charSequence == null ? null : MemoryUtil.memASCII(charSequence, true);
    }

    public static ByteBuffer memASCII(CharSequence charSequence, boolean bl) {
        int n = MemoryUtil.memLengthASCII(charSequence, bl);
        long l = MemoryUtil.nmemAlloc(n);
        if (Checks.CHECKS && l == 0L) {
            throw new OutOfMemoryError();
        }
        MemoryUtil.encodeASCIIUnsafe(charSequence, bl, l);
        return MemoryUtil.wrapBufferByte(l, n);
    }

    public static @Nullable ByteBuffer memASCIISafe(@Nullable CharSequence charSequence, boolean bl) {
        return charSequence == null ? null : MemoryUtil.memASCII(charSequence, bl);
    }

    public static int memASCII(CharSequence charSequence, boolean bl, ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() < MemoryUtil.memLengthASCII(charSequence, bl)) {
            throw new BufferOverflowException();
        }
        long l = MemoryUtil.memAddress(byteBuffer);
        return MemoryUtil.encodeASCIIUnsafe(charSequence, bl, l);
    }

    public static int memASCII(CharSequence charSequence, boolean bl, ByteBuffer byteBuffer, int n) {
        if (byteBuffer.capacity() - n < MemoryUtil.memLengthASCII(charSequence, bl)) {
            throw new BufferOverflowException();
        }
        return MemoryUtil.encodeASCIIUnsafe(charSequence, bl, MemoryUtil.memAddress(byteBuffer, n));
    }

    static int encodeASCIIUnsafe(CharSequence charSequence, boolean bl, long l) {
        int n = 0;
        int n2 = charSequence.length();
        while (n < n2) {
            n = MemoryUtil.write8(l, n, charSequence.charAt(n));
        }
        if (bl) {
            n = MemoryUtil.write8(l, n, 0);
        }
        return n;
    }

    public static int memLengthASCII(CharSequence charSequence, boolean bl) {
        int n = charSequence.length() + (bl ? 1 : 0);
        if (n < 0) {
            throw new BufferOverflowException();
        }
        return n;
    }

    public static ByteBuffer memUTF8(CharSequence charSequence) {
        return MemoryUtil.memUTF8(charSequence, true);
    }

    public static @Nullable ByteBuffer memUTF8Safe(@Nullable CharSequence charSequence) {
        return charSequence == null ? null : MemoryUtil.memUTF8(charSequence, true);
    }

    public static ByteBuffer memUTF8(CharSequence charSequence, boolean bl) {
        int n = MemoryUtil.memLengthUTF8(charSequence, bl);
        long l = MemoryUtil.nmemAlloc(n);
        if (Checks.CHECKS && l == 0L) {
            throw new OutOfMemoryError();
        }
        MemoryUtil.encodeUTF8Unsafe(charSequence, bl, l);
        return MemoryUtil.wrapBufferByte(l, n);
    }

    public static @Nullable ByteBuffer memUTF8Safe(@Nullable CharSequence charSequence, boolean bl) {
        return charSequence == null ? null : MemoryUtil.memUTF8(charSequence, bl);
    }

    public static int memUTF8(CharSequence charSequence, boolean bl, ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() < MemoryUtil.memLengthASCII(charSequence, bl)) {
            throw new BufferOverflowException();
        }
        return MemoryUtil.encodeUTF8Safe(charSequence, bl, MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining());
    }

    public static int memUTF8(CharSequence charSequence, boolean bl, ByteBuffer byteBuffer, int n) {
        if (byteBuffer.capacity() - n < MemoryUtil.memLengthASCII(charSequence, bl)) {
            throw new BufferOverflowException();
        }
        return MemoryUtil.encodeUTF8Safe(charSequence, bl, MemoryUtil.memAddress(byteBuffer, n), byteBuffer.capacity() - n);
    }

    static int encodeUTF8Unsafe(CharSequence charSequence, boolean bl, long l) {
        int n = 0;
        int n2 = 0;
        int n3 = charSequence.length();
        while (n2 < n3) {
            int n4;
            if ((n4 = charSequence.charAt(n2++)) < 128) {
                n = MemoryUtil.write8(l, n, n4);
                continue;
            }
            int n5 = n4;
            if (n4 < 2048) {
                n = MemoryUtil.write8(l, n, 0xC0 | n5 >> 6);
            } else {
                if (!Character.isHighSurrogate((char)n4)) {
                    n = MemoryUtil.write8(l, n, 0xE0 | n5 >> 12);
                } else {
                    n5 = Character.toCodePoint((char)n4, charSequence.charAt(n2++));
                    n = MemoryUtil.write8(l, n, 0xF0 | n5 >> 18);
                    n = MemoryUtil.write8(l, n, 0x80 | n5 >> 12 & 0x3F);
                }
                n = MemoryUtil.write8(l, n, 0x80 | n5 >> 6 & 0x3F);
            }
            n = MemoryUtil.write8(l, n, 0x80 | n5 & 0x3F);
        }
        if (bl) {
            n = MemoryUtil.write8(l, n, 0);
        }
        return n;
    }

    static int encodeUTF8Safe(CharSequence charSequence, boolean bl, long l, int n) {
        int n2;
        int n3;
        int n4 = 0;
        int n5 = charSequence.length();
        for (n3 = 0; n3 < n5 && 128 > (n2 = charSequence.charAt(n3)); ++n3) {
            n4 = MemoryUtil.write8(l, n4, n2);
        }
        while (n3 < n5) {
            if ((n2 = charSequence.charAt(n3++)) < 128) {
                n4 = MemoryUtil.write8Safe(l, n4, n, n2);
                continue;
            }
            int n6 = n2;
            if (n2 < 2048) {
                n4 = MemoryUtil.write8Safe(l, n4, n, 0xC0 | n6 >> 6);
            } else {
                if (!Character.isHighSurrogate((char)n2)) {
                    n4 = MemoryUtil.write8Safe(l, n4, n, 0xE0 | n6 >> 12);
                } else {
                    n6 = Character.toCodePoint((char)n2, charSequence.charAt(n3++));
                    n4 = MemoryUtil.write8Safe(l, n4, n, 0xF0 | n6 >> 18);
                    n4 = MemoryUtil.write8Safe(l, n4, n, 0x80 | n6 >> 12 & 0x3F);
                }
                n4 = MemoryUtil.write8Safe(l, n4, n, 0x80 | n6 >> 6 & 0x3F);
            }
            n4 = MemoryUtil.write8Safe(l, n4, n, 0x80 | n6 & 0x3F);
        }
        if (bl) {
            n4 = MemoryUtil.write8Safe(l, n4, n, 0);
        }
        return n4;
    }

    public static int memLengthUTF8(CharSequence charSequence, boolean bl) {
        int n = charSequence.length();
        int n2 = n + (bl ? 1 : 0);
        for (int i = 0; i < n; ++i) {
            char c = charSequence.charAt(i);
            if (c < '\u0080') continue;
            if (c < '\u0800') {
                n2 += 127 - c >>> 31;
            } else {
                n2 += 2;
                if (Character.isHighSurrogate(c)) {
                    ++i;
                }
            }
            if (n2 >= 0) continue;
            throw new BufferOverflowException();
        }
        if (n2 < 0) {
            throw new BufferOverflowException();
        }
        return n2;
    }

    public static ByteBuffer memUTF16(CharSequence charSequence) {
        return MemoryUtil.memUTF16(charSequence, true);
    }

    public static @Nullable ByteBuffer memUTF16Safe(@Nullable CharSequence charSequence) {
        return charSequence == null ? null : MemoryUtil.memUTF16(charSequence, true);
    }

    public static ByteBuffer memUTF16(CharSequence charSequence, boolean bl) {
        int n = MemoryUtil.memLengthUTF16(charSequence, bl);
        long l = MemoryUtil.nmemAlloc(n);
        if (Checks.CHECKS && l == 0L) {
            throw new OutOfMemoryError();
        }
        MemoryUtil.encodeUTF16Unsafe(charSequence, bl, l);
        return MemoryUtil.wrapBufferByte(l, n);
    }

    public static @Nullable ByteBuffer memUTF16Safe(@Nullable CharSequence charSequence, boolean bl) {
        return charSequence == null ? null : MemoryUtil.memUTF16(charSequence, bl);
    }

    public static int memUTF16(CharSequence charSequence, boolean bl, ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() < MemoryUtil.memLengthUTF16(charSequence, bl)) {
            throw new BufferOverflowException();
        }
        long l = MemoryUtil.memAddress(byteBuffer);
        return MemoryUtil.encodeUTF16Unsafe(charSequence, bl, l);
    }

    public static int memUTF16(CharSequence charSequence, boolean bl, ByteBuffer byteBuffer, int n) {
        if (byteBuffer.capacity() - n < MemoryUtil.memLengthUTF16(charSequence, bl)) {
            throw new BufferOverflowException();
        }
        long l = MemoryUtil.memAddress(byteBuffer, n);
        return MemoryUtil.encodeUTF16Unsafe(charSequence, bl, l);
    }

    static int encodeUTF16Unsafe(CharSequence charSequence, boolean bl, long l) {
        int n = 0;
        int n2 = 0;
        int n3 = charSequence.length();
        while (n2 < n3) {
            n = MemoryUtil.write16(l, n, charSequence.charAt(n2++));
        }
        if (bl) {
            n = MemoryUtil.write16(l, n, '\u0000');
        }
        return n;
    }

    public static int memLengthUTF16(CharSequence charSequence, boolean bl) {
        int n = charSequence.length() + (bl ? 1 : 0);
        if (n < 0 || 0x3FFFFFFF < n) {
            throw new BufferOverflowException();
        }
        return n << 1;
    }

    private static int memLengthNT1(long l, int n) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return Pointer.BITS64 ? MemoryUtil.strlen64NT1(l, n) : MemoryUtil.strlen32NT1(l, n);
    }

    private static int strlen64NT1(long l, int n) {
        int n2;
        if (8 <= n) {
            int n3 = (int)l & 7;
            if (n3 != 0) {
                int n4 = 8 - n3;
                for (n2 = 0; n2 < n4; ++n2) {
                    if (UNSAFE.getByte(null, l + (long)n2) != 0) continue;
                    return n2;
                }
            }
            while (n2 <= n - 8 && !MathUtil.mathHasZeroByte(UNSAFE.getLong(null, l + (long)n2))) {
                n2 += 8;
            }
        }
        while (n2 < n && UNSAFE.getByte(null, l + (long)n2) != 0) {
            ++n2;
        }
        return n2;
    }

    private static int strlen32NT1(long l, int n) {
        int n2;
        if (4 <= n) {
            int n3 = (int)l & 3;
            if (n3 != 0) {
                int n4 = 4 - n3;
                for (n2 = 0; n2 < n4; ++n2) {
                    if (UNSAFE.getByte(null, l + (long)n2) != 0) continue;
                    return n2;
                }
            }
            while (n2 <= n - 4 && !MathUtil.mathHasZeroByte(UNSAFE.getInt(null, l + (long)n2))) {
                n2 += 4;
            }
        }
        while (n2 < n && UNSAFE.getByte(null, l + (long)n2) != 0) {
            ++n2;
        }
        return n2;
    }

    public static int memLengthNT1(ByteBuffer byteBuffer) {
        return MemoryUtil.memLengthNT1(MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining());
    }

    private static int memLengthNT2(long l, int n) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return Pointer.BITS64 ? MemoryUtil.strlen64NT2(l, n) : MemoryUtil.strlen32NT2((int)l, n);
    }

    private static int strlen64NT2(long l, int n) {
        int n2;
        if (8 <= n) {
            int n3 = (int)l & 7;
            if (n3 != 0) {
                int n4 = 8 - n3;
                for (n2 = 0; n2 < n4; n2 += 2) {
                    if (UNSAFE.getShort(null, l + (long)n2) != 0) continue;
                    return n2;
                }
            }
            while (n2 <= n - 8 && !MathUtil.mathHasZeroShort(UNSAFE.getLong(null, l + (long)n2))) {
                n2 += 8;
            }
        }
        while (n2 < n && UNSAFE.getShort(null, l + (long)n2) != 0) {
            n2 += 2;
        }
        return n2;
    }

    private static int strlen32NT2(long l, int n) {
        int n2;
        if (4 <= n) {
            int n3 = (int)l & 3;
            if (n3 != 0) {
                int n4 = 4 - n3;
                for (n2 = 0; n2 < n4; n2 += 2) {
                    if (UNSAFE.getShort(null, l + (long)n2) != 0) continue;
                    return n2;
                }
            }
            while (n2 <= n - 4 && !MathUtil.mathHasZeroShort(UNSAFE.getInt(null, l + (long)n2))) {
                n2 += 4;
            }
        }
        while (n2 < n && UNSAFE.getShort(null, l + (long)n2) != 0) {
            n2 += 2;
        }
        return n2;
    }

    public static int memLengthNT2(ByteBuffer byteBuffer) {
        return MemoryUtil.memLengthNT2(MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining());
    }

    public static ByteBuffer memByteBufferNT1(long l) {
        return MemoryUtil.memByteBuffer(l, MemoryUtil.memLengthNT1(l, Integer.MAX_VALUE));
    }

    public static ByteBuffer memByteBufferNT1(long l, int n) {
        return MemoryUtil.memByteBuffer(l, MemoryUtil.memLengthNT1(l, n));
    }

    public static @Nullable ByteBuffer memByteBufferNT1Safe(long l) {
        return l == 0L ? null : MemoryUtil.memByteBuffer(l, MemoryUtil.memLengthNT1(l, Integer.MAX_VALUE));
    }

    public static @Nullable ByteBuffer memByteBufferNT1Safe(long l, int n) {
        return l == 0L ? null : MemoryUtil.memByteBuffer(l, MemoryUtil.memLengthNT1(l, n));
    }

    public static ByteBuffer memByteBufferNT2(long l) {
        return MemoryUtil.memByteBufferNT2(l, 0x7FFFFFFE);
    }

    public static ByteBuffer memByteBufferNT2(long l, int n) {
        if (Checks.DEBUG && (n & 1) != 0) {
            throw new IllegalArgumentException("The maximum length must be an even number.");
        }
        return MemoryUtil.memByteBuffer(l, MemoryUtil.memLengthNT2(l, n));
    }

    public static @Nullable ByteBuffer memByteBufferNT2Safe(long l) {
        return l == 0L ? null : MemoryUtil.memByteBufferNT2(l, 0x7FFFFFFE);
    }

    public static @Nullable ByteBuffer memByteBufferNT2Safe(long l, int n) {
        return l == 0L ? null : MemoryUtil.memByteBufferNT2(l, n);
    }

    public static String memASCII(long l) {
        return MemoryUtil.memASCII(l, MemoryUtil.memLengthNT1(l, Integer.MAX_VALUE));
    }

    public static String memASCII(long l, int n) {
        if (n <= 0) {
            return "";
        }
        byte[] byArray = n <= ARRAY_TLC_SIZE ? ARRAY_TLC_BYTE.get() : new byte[n];
        MemoryUtil.memByteBuffer(l, n).get(byArray, 0, n);
        return new String(byArray, 0, 0, n);
    }

    public static String memASCII(ByteBuffer byteBuffer) {
        return MemoryUtil.memASCII(MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining());
    }

    public static @Nullable String memASCIISafe(long l) {
        return l == 0L ? null : MemoryUtil.memASCII(l, MemoryUtil.memLengthNT1(l, Integer.MAX_VALUE));
    }

    public static @Nullable String memASCIISafe(long l, int n) {
        return l == 0L ? null : MemoryUtil.memASCII(l, n);
    }

    public static @Nullable String memASCIISafe(@Nullable ByteBuffer byteBuffer) {
        return byteBuffer == null ? null : MemoryUtil.memASCII(MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining());
    }

    public static String memASCII(ByteBuffer byteBuffer, int n) {
        return MemoryUtil.memASCII(MemoryUtil.memAddress(byteBuffer), n);
    }

    public static String memASCII(ByteBuffer byteBuffer, int n, int n2) {
        return MemoryUtil.memASCII(MemoryUtil.memAddress(byteBuffer, n2), n);
    }

    public static String memUTF8(long l) {
        return MultiReleaseTextDecoding.decodeUTF8(l, MemoryUtil.memLengthNT1(l, Integer.MAX_VALUE));
    }

    public static String memUTF8(long l, int n) {
        return MultiReleaseTextDecoding.decodeUTF8(l, n);
    }

    public static String memUTF8(ByteBuffer byteBuffer) {
        return MultiReleaseTextDecoding.decodeUTF8(MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining());
    }

    public static @Nullable String memUTF8Safe(long l) {
        return l == 0L ? null : MultiReleaseTextDecoding.decodeUTF8(l, MemoryUtil.memLengthNT1(l, Integer.MAX_VALUE));
    }

    public static @Nullable String memUTF8Safe(long l, int n) {
        return l == 0L ? null : MultiReleaseTextDecoding.decodeUTF8(l, n);
    }

    public static @Nullable String memUTF8Safe(@Nullable ByteBuffer byteBuffer) {
        return byteBuffer == null ? null : MultiReleaseTextDecoding.decodeUTF8(MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining());
    }

    public static String memUTF8(ByteBuffer byteBuffer, int n) {
        return MultiReleaseTextDecoding.decodeUTF8(MemoryUtil.memAddress(byteBuffer), n);
    }

    public static String memUTF8(ByteBuffer byteBuffer, int n, int n2) {
        return MultiReleaseTextDecoding.decodeUTF8(MemoryUtil.memAddress(byteBuffer, n2), n);
    }

    public static String memUTF16(long l) {
        return MemoryUtil.memUTF16(l, MemoryUtil.memLengthNT2(l, 0x7FFFFFFE) >> 1);
    }

    public static String memUTF16(long l, int n) {
        if (n <= 0) {
            return "";
        }
        if (Checks.DEBUG) {
            int n2 = n << 1;
            byte[] byArray = n2 <= ARRAY_TLC_SIZE ? ARRAY_TLC_BYTE.get() : new byte[n2];
            MemoryUtil.memByteBuffer(l, n2).get(byArray, 0, n2);
            return new String(byArray, 0, n2, UTF16);
        }
        char[] cArray = n <= ARRAY_TLC_SIZE ? ARRAY_TLC_CHAR.get() : new char[n];
        MemoryUtil.memCharBuffer(l, n).get(cArray, 0, n);
        return new String(cArray, 0, n);
    }

    public static String memUTF16(ByteBuffer byteBuffer) {
        return MemoryUtil.memUTF16(MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining() >> 1);
    }

    public static @Nullable String memUTF16Safe(long l) {
        return l == 0L ? null : MemoryUtil.memUTF16(l, MemoryUtil.memLengthNT2(l, 0x7FFFFFFE) >> 1);
    }

    public static @Nullable String memUTF16Safe(long l, int n) {
        return l == 0L ? null : MemoryUtil.memUTF16(l, n);
    }

    public static @Nullable String memUTF16Safe(@Nullable ByteBuffer byteBuffer) {
        return byteBuffer == null ? null : MemoryUtil.memUTF16(MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining() >> 1);
    }

    public static String memUTF16(ByteBuffer byteBuffer, int n) {
        return MemoryUtil.memUTF16(MemoryUtil.memAddress(byteBuffer), n);
    }

    public static String memUTF16(ByteBuffer byteBuffer, int n, int n2) {
        return MemoryUtil.memUTF16(MemoryUtil.memAddress(byteBuffer, n2), n);
    }

    private static Unsafe getUnsafeInstance() {
        Field[] fieldArray;
        for (Field field : fieldArray = Unsafe.class.getDeclaredFields()) {
            int n;
            if (!field.getType().equals(Unsafe.class) || !Modifier.isStatic(n = field.getModifiers()) || !Modifier.isFinal(n)) continue;
            try {
                field.setAccessible(true);
                return (Unsafe)field.get(null);
            }
            catch (Exception exception) {
                break;
            }
        }
        throw new UnsupportedOperationException("LWJGL requires sun.misc.Unsafe to be available.");
    }

    private static long getFieldOffset(Class<?> clazz, Class<?> clazz2, LongPredicate longPredicate) {
        for (Class<?> clazz3 = clazz; clazz3 != Object.class; clazz3 = clazz3.getSuperclass()) {
            Field[] fieldArray;
            for (Field field : fieldArray = clazz3.getDeclaredFields()) {
                long l;
                if (!field.getType().isAssignableFrom(clazz2) || Modifier.isStatic(field.getModifiers()) || field.isSynthetic() || !longPredicate.test(l = UNSAFE.objectFieldOffset(field))) continue;
                return l;
            }
        }
        throw new UnsupportedOperationException("Failed to find field offset in class.");
    }

    private static long getFieldOffsetInt(Object object, int n) {
        return MemoryUtil.getFieldOffset(object.getClass(), Integer.TYPE, l -> UNSAFE.getInt(object, l) == n);
    }

    private static long getFieldOffsetObject(Object object, Object object2) {
        return MemoryUtil.getFieldOffset(object.getClass(), object2.getClass(), l -> UNSAFE.getObject(object, l) == object2);
    }

    private static long getAddressOffset() {
        long l = 0xDEADBEEF8BADF00DL & (Pointer.BITS32 ? 0xFFFFFFFFL : -1L);
        ByteBuffer byteBuffer = Objects.requireNonNull(JNINativeInterface.NewDirectByteBuffer(l, 0L));
        return MemoryUtil.getFieldOffset(byteBuffer.getClass(), Long.TYPE, l2 -> UNSAFE.getLong(byteBuffer, l2) == l);
    }

    private static long getMarkOffset() {
        ByteBuffer byteBuffer = Objects.requireNonNull(JNINativeInterface.NewDirectByteBuffer(1L, 0L));
        return MemoryUtil.getFieldOffsetInt(byteBuffer, -1);
    }

    private static long getPositionOffset() {
        ByteBuffer byteBuffer = Objects.requireNonNull(JNINativeInterface.NewDirectByteBuffer(-1L, 219540062L));
        byteBuffer.position(16435934);
        return MemoryUtil.getFieldOffsetInt(byteBuffer, 16435934);
    }

    private static long getLimitOffset() {
        ByteBuffer byteBuffer = Objects.requireNonNull(JNINativeInterface.NewDirectByteBuffer(-1L, 219540062L));
        byteBuffer.limit(16435934);
        return MemoryUtil.getFieldOffsetInt(byteBuffer, 16435934);
    }

    private static long getCapacityOffset() {
        ByteBuffer byteBuffer = Objects.requireNonNull(JNINativeInterface.NewDirectByteBuffer(-1L, 219540062L));
        byteBuffer.limit(0);
        return MemoryUtil.getFieldOffsetInt(byteBuffer, 219540062);
    }

    static ByteBuffer wrapBufferByte(long l, int n) {
        ByteBuffer byteBuffer;
        try {
            byteBuffer = (ByteBuffer)UNSAFE.allocateInstance(BUFFER_BYTE);
        }
        catch (InstantiationException instantiationException) {
            throw new UnsupportedOperationException(instantiationException);
        }
        UNSAFE.putLong(byteBuffer, ADDRESS, l);
        UNSAFE.putInt(byteBuffer, MARK, -1);
        UNSAFE.putInt(byteBuffer, LIMIT, n);
        UNSAFE.putInt(byteBuffer, CAPACITY, n);
        return byteBuffer.order(NATIVE_ORDER);
    }

    static ShortBuffer wrapBufferShort(long l, int n) {
        ShortBuffer shortBuffer;
        try {
            shortBuffer = (ShortBuffer)UNSAFE.allocateInstance(BUFFER_SHORT);
        }
        catch (InstantiationException instantiationException) {
            throw new UnsupportedOperationException(instantiationException);
        }
        UNSAFE.putLong(shortBuffer, ADDRESS, l);
        UNSAFE.putInt(shortBuffer, MARK, -1);
        UNSAFE.putInt(shortBuffer, LIMIT, n);
        UNSAFE.putInt(shortBuffer, CAPACITY, n);
        return shortBuffer;
    }

    static CharBuffer wrapBufferChar(long l, int n) {
        CharBuffer charBuffer;
        try {
            charBuffer = (CharBuffer)UNSAFE.allocateInstance(BUFFER_CHAR);
        }
        catch (InstantiationException instantiationException) {
            throw new UnsupportedOperationException(instantiationException);
        }
        UNSAFE.putLong(charBuffer, ADDRESS, l);
        UNSAFE.putInt(charBuffer, MARK, -1);
        UNSAFE.putInt(charBuffer, LIMIT, n);
        UNSAFE.putInt(charBuffer, CAPACITY, n);
        return charBuffer;
    }

    static IntBuffer wrapBufferInt(long l, int n) {
        IntBuffer intBuffer;
        try {
            intBuffer = (IntBuffer)UNSAFE.allocateInstance(BUFFER_INT);
        }
        catch (InstantiationException instantiationException) {
            throw new UnsupportedOperationException(instantiationException);
        }
        UNSAFE.putLong(intBuffer, ADDRESS, l);
        UNSAFE.putInt(intBuffer, MARK, -1);
        UNSAFE.putInt(intBuffer, LIMIT, n);
        UNSAFE.putInt(intBuffer, CAPACITY, n);
        return intBuffer;
    }

    static LongBuffer wrapBufferLong(long l, int n) {
        LongBuffer longBuffer;
        try {
            longBuffer = (LongBuffer)UNSAFE.allocateInstance(BUFFER_LONG);
        }
        catch (InstantiationException instantiationException) {
            throw new UnsupportedOperationException(instantiationException);
        }
        UNSAFE.putLong(longBuffer, ADDRESS, l);
        UNSAFE.putInt(longBuffer, MARK, -1);
        UNSAFE.putInt(longBuffer, LIMIT, n);
        UNSAFE.putInt(longBuffer, CAPACITY, n);
        return longBuffer;
    }

    static FloatBuffer wrapBufferFloat(long l, int n) {
        FloatBuffer floatBuffer;
        try {
            floatBuffer = (FloatBuffer)UNSAFE.allocateInstance(BUFFER_FLOAT);
        }
        catch (InstantiationException instantiationException) {
            throw new UnsupportedOperationException(instantiationException);
        }
        UNSAFE.putLong(floatBuffer, ADDRESS, l);
        UNSAFE.putInt(floatBuffer, MARK, -1);
        UNSAFE.putInt(floatBuffer, LIMIT, n);
        UNSAFE.putInt(floatBuffer, CAPACITY, n);
        return floatBuffer;
    }

    static DoubleBuffer wrapBufferDouble(long l, int n) {
        DoubleBuffer doubleBuffer;
        try {
            doubleBuffer = (DoubleBuffer)UNSAFE.allocateInstance(BUFFER_DOUBLE);
        }
        catch (InstantiationException instantiationException) {
            throw new UnsupportedOperationException(instantiationException);
        }
        UNSAFE.putLong(doubleBuffer, ADDRESS, l);
        UNSAFE.putInt(doubleBuffer, MARK, -1);
        UNSAFE.putInt(doubleBuffer, LIMIT, n);
        UNSAFE.putInt(doubleBuffer, CAPACITY, n);
        return doubleBuffer;
    }

    static ByteBuffer slice(ByteBuffer byteBuffer, long l, int n) {
        ByteBuffer byteBuffer2;
        try {
            byteBuffer2 = (ByteBuffer)UNSAFE.allocateInstance(BUFFER_BYTE);
        }
        catch (InstantiationException instantiationException) {
            throw new UnsupportedOperationException(instantiationException);
        }
        UNSAFE.putLong(byteBuffer2, ADDRESS, l);
        UNSAFE.putInt(byteBuffer2, MARK, -1);
        UNSAFE.putInt(byteBuffer2, LIMIT, n);
        UNSAFE.putInt(byteBuffer2, CAPACITY, n);
        Object object = UNSAFE.getObject(byteBuffer, PARENT_BYTE);
        UNSAFE.putObject(byteBuffer2, PARENT_BYTE, object == null ? byteBuffer : object);
        return byteBuffer2.order(byteBuffer.order());
    }

    static <T extends Buffer> T slice(Class<? extends T> clazz, T t, long l, int n, long l2) {
        Buffer buffer;
        try {
            buffer = (Buffer)UNSAFE.allocateInstance(clazz);
        }
        catch (InstantiationException instantiationException) {
            throw new UnsupportedOperationException(instantiationException);
        }
        UNSAFE.putLong(buffer, ADDRESS, l);
        UNSAFE.putInt(buffer, MARK, -1);
        UNSAFE.putInt(buffer, LIMIT, n);
        UNSAFE.putInt(buffer, CAPACITY, n);
        UNSAFE.putObject(buffer, l2, UNSAFE.getObject(t, l2));
        return (T)buffer;
    }

    static <T extends Buffer> T duplicate(Class<? extends T> clazz, T t, long l) {
        Buffer buffer;
        try {
            buffer = (Buffer)UNSAFE.allocateInstance(clazz);
        }
        catch (InstantiationException instantiationException) {
            throw new UnsupportedOperationException(instantiationException);
        }
        UNSAFE.putLong(buffer, ADDRESS, UNSAFE.getLong(t, ADDRESS));
        UNSAFE.putInt(buffer, MARK, UNSAFE.getInt(t, MARK));
        UNSAFE.putInt(buffer, POSITION, UNSAFE.getInt(t, POSITION));
        UNSAFE.putInt(buffer, LIMIT, UNSAFE.getInt(t, LIMIT));
        UNSAFE.putInt(buffer, CAPACITY, UNSAFE.getInt(t, CAPACITY));
        UNSAFE.putObject(buffer, l, UNSAFE.getObject(t, l));
        return (T)buffer;
    }

    static {
        ARRAY_TLC_SIZE = Configuration.ARRAY_TLC_SIZE.get(8192);
        ARRAY_TLC_BYTE = ThreadLocal.withInitial(() -> new byte[ARRAY_TLC_SIZE]);
        ARRAY_TLC_CHAR = ThreadLocal.withInitial(() -> new char[ARRAY_TLC_SIZE]);
        NATIVE_ORDER = ByteOrder.nativeOrder();
        UTF16 = NATIVE_ORDER == ByteOrder.LITTLE_ENDIAN ? StandardCharsets.UTF_16LE : StandardCharsets.UTF_16BE;
        Library.initialize();
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(0).order(NATIVE_ORDER);
        BUFFER_BYTE = byteBuffer.getClass();
        BUFFER_SHORT = byteBuffer.asShortBuffer().getClass();
        BUFFER_CHAR = byteBuffer.asCharBuffer().getClass();
        BUFFER_INT = byteBuffer.asIntBuffer().getClass();
        BUFFER_LONG = byteBuffer.asLongBuffer().getClass();
        BUFFER_FLOAT = byteBuffer.asFloatBuffer().getClass();
        BUFFER_DOUBLE = byteBuffer.asDoubleBuffer().getClass();
        UNSAFE = MemoryUtil.getUnsafeInstance();
        try {
            MARK = MemoryUtil.getMarkOffset();
            POSITION = MemoryUtil.getPositionOffset();
            LIMIT = MemoryUtil.getLimitOffset();
            CAPACITY = MemoryUtil.getCapacityOffset();
            ADDRESS = MemoryUtil.getAddressOffset();
            PARENT_BYTE = MemoryUtil.getFieldOffsetObject(byteBuffer.duplicate().order(byteBuffer.order()), byteBuffer);
            PARENT_SHORT = MemoryUtil.getFieldOffsetObject(byteBuffer.asShortBuffer(), byteBuffer);
            PARENT_CHAR = MemoryUtil.getFieldOffsetObject(byteBuffer.asCharBuffer(), byteBuffer);
            PARENT_INT = MemoryUtil.getFieldOffsetObject(byteBuffer.asIntBuffer(), byteBuffer);
            PARENT_LONG = MemoryUtil.getFieldOffsetObject(byteBuffer.asLongBuffer(), byteBuffer);
            PARENT_FLOAT = MemoryUtil.getFieldOffsetObject(byteBuffer.asFloatBuffer(), byteBuffer);
            PARENT_DOUBLE = MemoryUtil.getFieldOffsetObject(byteBuffer.asDoubleBuffer(), byteBuffer);
        }
        catch (Throwable throwable) {
            throw new UnsupportedOperationException(throwable);
        }
        PAGE_SIZE = UNSAFE.pageSize();
        CACHE_LINE_SIZE = 64;
        FILL_PATTERN_32 = Integer.divideUnsigned(-1, 255);
        FILL_PATTERN_64 = Long.divideUnsigned(-1L, 255L);
    }

    public static interface MemoryAllocationReport {
        public void invoke(long var1, long var3, long var5, @Nullable String var7, StackTraceElement ... var8);

        public static enum Aggregate {
            ALL,
            GROUP_BY_METHOD,
            GROUP_BY_STACKTRACE;

        }
    }

    public static interface MemoryAllocator {
        public long getMalloc();

        public long getCalloc();

        public long getRealloc();

        public long getFree();

        public long getAlignedAlloc();

        public long getAlignedFree();

        public long malloc(long var1);

        public long calloc(long var1, long var3);

        public long realloc(long var1, long var3);

        public void free(long var1);

        public long aligned_alloc(long var1, long var3);

        public void aligned_free(long var1);
    }

    public static final class LazyInit {
        static final MemoryAllocator ALLOCATOR_IMPL;
        static final MemoryAllocator ALLOCATOR;

        private LazyInit() {
        }

        static {
            boolean bl = Configuration.DEBUG_MEMORY_ALLOCATOR.get(false);
            ALLOCATOR_IMPL = MemoryManage.getInstance();
            ALLOCATOR = bl ? new MemoryManage.DebugAllocator(ALLOCATOR_IMPL) : ALLOCATOR_IMPL;
            APIUtil.apiLog("MemoryUtil allocator: " + ALLOCATOR.getClass().getSimpleName());
            if (bl && !Configuration.DEBUG_MEMORY_ALLOCATOR_FAST.get(false).booleanValue()) {
                APIUtil.apiLogMore("Reminder: enable Configuration.DEBUG_MEMORY_ALLOCATOR_FAST for low overhead allocation tracking.");
            }
        }
    }
}


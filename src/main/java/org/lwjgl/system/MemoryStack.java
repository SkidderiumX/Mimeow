/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.Arrays;
import org.jspecify.annotations.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.CLongBuffer;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.CustomBuffer;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.Pointer;
import org.lwjgl.system.StackWalkUtil;

public class MemoryStack
extends Pointer.Default
implements AutoCloseable {
    private static final int DEFAULT_STACK_SIZE = Configuration.STACK_SIZE.get(64) * 1024;
    private static final int DEFAULT_STACK_FRAMES = 8;
    private static final ThreadLocal<MemoryStack> TLS = ThreadLocal.withInitial(MemoryStack::create);
    private final @Nullable ByteBuffer container;
    private final int size;
    private int pointer;
    private int[] frames;
    protected int frameIndex;

    protected MemoryStack(@Nullable ByteBuffer byteBuffer, long l, int n) {
        super(l);
        this.container = byteBuffer;
        this.size = n;
        this.pointer = n;
        this.frames = new int[8];
    }

    public static MemoryStack create() {
        return MemoryStack.create(DEFAULT_STACK_SIZE);
    }

    public static MemoryStack create(int n) {
        return MemoryStack.create(BufferUtils.createByteBuffer(n));
    }

    public static MemoryStack create(ByteBuffer byteBuffer) {
        long l = MemoryUtil.memAddress(byteBuffer);
        int n = byteBuffer.remaining();
        return Configuration.DEBUG_STACK.get(false) != false ? new DebugMemoryStack(byteBuffer, l, n) : new MemoryStack(byteBuffer, l, n);
    }

    public static MemoryStack ncreate(long l, int n) {
        return Configuration.DEBUG_STACK.get(false) != false ? new DebugMemoryStack(null, l, n) : new MemoryStack(null, l, n);
    }

    public MemoryStack push() {
        if (this.frameIndex == this.frames.length) {
            this.frameOverflow();
        }
        this.frames[this.frameIndex++] = this.pointer;
        return this;
    }

    private void frameOverflow() {
        if (Checks.DEBUG) {
            APIUtil.apiLog("[WARNING] Out of frame stack space (" + this.frames.length + ") in thread: " + Thread.currentThread());
        }
        this.frames = Arrays.copyOf(this.frames, this.frames.length * 3 / 2);
    }

    public MemoryStack pop() {
        this.pointer = this.frames[--this.frameIndex];
        return this;
    }

    @Override
    public void close() {
        this.pop();
    }

    public long getAddress() {
        return this.address;
    }

    public int getSize() {
        return this.size;
    }

    public int getFrameIndex() {
        return this.frameIndex;
    }

    public long getPointerAddress() {
        return this.address + ((long)this.pointer & 0xFFFFFFFFL);
    }

    public int getPointer() {
        return this.pointer;
    }

    public void setPointer(int n) {
        if (Checks.CHECKS) {
            this.checkPointer(n);
        }
        this.pointer = n;
    }

    private void checkPointer(int n) {
        if (n < 0 || this.size < n) {
            throw new IndexOutOfBoundsException("Invalid stack pointer");
        }
    }

    private static void checkAlignment(int n) {
        if (Integer.bitCount(n) != 1) {
            throw new IllegalArgumentException("Alignment must be a power-of-two value.");
        }
    }

    public long nmalloc(int n) {
        return this.nmalloc(POINTER_SIZE, n);
    }

    public long nmalloc(int n, int n2) {
        long l = this.address + (long)this.pointer - (long)n2 & (Integer.toUnsignedLong(n - 1) ^ 0xFFFFFFFFFFFFFFFFL);
        this.pointer = (int)(l - this.address);
        if (Checks.CHECKS && this.pointer < 0) {
            throw new OutOfMemoryError("Out of stack space.");
        }
        return l;
    }

    public long ncalloc(int n, int n2, int n3) {
        int n4 = n2 * n3;
        long l = this.nmalloc(n, n4);
        MemoryUtil.memSet(l, 0, n4);
        return l;
    }

    public ByteBuffer malloc(int n, int n2) {
        if (Checks.DEBUG) {
            MemoryStack.checkAlignment(n);
        }
        return MemoryUtil.wrapBufferByte(this.nmalloc(n, n2), n2);
    }

    public ByteBuffer calloc(int n, int n2) {
        if (Checks.DEBUG) {
            MemoryStack.checkAlignment(n);
        }
        return MemoryUtil.wrapBufferByte(this.ncalloc(n, n2, 1), n2);
    }

    public ByteBuffer malloc(int n) {
        return MemoryUtil.wrapBufferByte(this.nmalloc(POINTER_SIZE, n), n);
    }

    public ByteBuffer calloc(int n) {
        return MemoryUtil.wrapBufferByte(this.ncalloc(POINTER_SIZE, n, 1), n);
    }

    public long nbyte(byte by) {
        long l = this.nmalloc(1, 1);
        MemoryUtil.memPutByte(l, by);
        return l;
    }

    public ByteBuffer bytes(byte by) {
        return this.malloc(1, 1).put(0, by);
    }

    public ByteBuffer bytes(byte by, byte by2) {
        return this.malloc(1, 2).put(0, by).put(1, by2);
    }

    public ByteBuffer bytes(byte by, byte by2, byte by3) {
        return this.malloc(1, 3).put(0, by).put(1, by2).put(2, by3);
    }

    public ByteBuffer bytes(byte by, byte by2, byte by3, byte by4) {
        return this.malloc(1, 4).put(0, by).put(1, by2).put(2, by3).put(3, by4);
    }

    public ByteBuffer bytes(byte ... byArray) {
        ByteBuffer byteBuffer = this.malloc(1, byArray.length).put(byArray);
        byteBuffer.flip();
        return byteBuffer;
    }

    public ShortBuffer mallocShort(int n) {
        return MemoryUtil.wrapBufferShort(this.nmalloc(2, n << 1), n);
    }

    public ShortBuffer callocShort(int n) {
        int n2 = n * 2;
        long l = this.nmalloc(2, n2);
        MemoryUtil.memSet(l, 0, n2);
        return MemoryUtil.wrapBufferShort(l, n);
    }

    public long nshort(short s) {
        long l = this.nmalloc(2, 2);
        MemoryUtil.memPutShort(l, s);
        return l;
    }

    public ShortBuffer shorts(short s) {
        return this.mallocShort(1).put(0, s);
    }

    public ShortBuffer shorts(short s, short s2) {
        return this.mallocShort(2).put(0, s).put(1, s2);
    }

    public ShortBuffer shorts(short s, short s2, short s3) {
        return this.mallocShort(3).put(0, s).put(1, s2).put(2, s3);
    }

    public ShortBuffer shorts(short s, short s2, short s3, short s4) {
        return this.mallocShort(4).put(0, s).put(1, s2).put(2, s3).put(3, s4);
    }

    public ShortBuffer shorts(short ... sArray) {
        ShortBuffer shortBuffer = this.mallocShort(sArray.length).put(sArray);
        shortBuffer.flip();
        return shortBuffer;
    }

    public IntBuffer mallocInt(int n) {
        return MemoryUtil.wrapBufferInt(this.nmalloc(4, n << 2), n);
    }

    public IntBuffer callocInt(int n) {
        int n2 = n * 4;
        long l = this.nmalloc(4, n2);
        MemoryUtil.memSet(l, 0, n2);
        return MemoryUtil.wrapBufferInt(l, n);
    }

    public long nint(int n) {
        long l = this.nmalloc(4, 4);
        MemoryUtil.memPutInt(l, n);
        return l;
    }

    public IntBuffer ints(int n) {
        return this.mallocInt(1).put(0, n);
    }

    public IntBuffer ints(int n, int n2) {
        return this.mallocInt(2).put(0, n).put(1, n2);
    }

    public IntBuffer ints(int n, int n2, int n3) {
        return this.mallocInt(3).put(0, n).put(1, n2).put(2, n3);
    }

    public IntBuffer ints(int n, int n2, int n3, int n4) {
        return this.mallocInt(4).put(0, n).put(1, n2).put(2, n3).put(3, n4);
    }

    public IntBuffer ints(int ... nArray) {
        IntBuffer intBuffer = this.mallocInt(nArray.length).put(nArray);
        intBuffer.flip();
        return intBuffer;
    }

    public LongBuffer mallocLong(int n) {
        return MemoryUtil.wrapBufferLong(this.nmalloc(8, n << 3), n);
    }

    public LongBuffer callocLong(int n) {
        int n2 = n * 8;
        long l = this.nmalloc(8, n2);
        MemoryUtil.memSet(l, 0, n2);
        return MemoryUtil.wrapBufferLong(l, n);
    }

    public long nlong(long l) {
        long l2 = this.nmalloc(8, 8);
        MemoryUtil.memPutLong(l2, l);
        return l2;
    }

    public LongBuffer longs(long l) {
        return this.mallocLong(1).put(0, l);
    }

    public LongBuffer longs(long l, long l2) {
        return this.mallocLong(2).put(0, l).put(1, l2);
    }

    public LongBuffer longs(long l, long l2, long l3) {
        return this.mallocLong(3).put(0, l).put(1, l2).put(2, l3);
    }

    public LongBuffer longs(long l, long l2, long l3, long l4) {
        return this.mallocLong(4).put(0, l).put(1, l2).put(2, l3).put(3, l4);
    }

    public LongBuffer longs(long ... lArray) {
        LongBuffer longBuffer = this.mallocLong(lArray.length).put(lArray);
        longBuffer.flip();
        return longBuffer;
    }

    public CLongBuffer mallocCLong(int n) {
        return CLongBuffer.create(this.nmalloc(CLONG_SIZE, n << CLONG_SHIFT), n);
    }

    public CLongBuffer callocCLong(int n) {
        int n2 = n * CLONG_SIZE;
        long l = this.nmalloc(CLONG_SIZE, n2);
        MemoryUtil.memSet(l, 0, n2);
        return CLongBuffer.create(l, n);
    }

    public long nclong(long l) {
        long l2 = this.nmalloc(CLONG_SIZE, CLONG_SIZE);
        MemoryUtil.memPutCLong(l2, l);
        return l2;
    }

    public CLongBuffer clongs(long l) {
        return this.mallocCLong(1).put(0, l);
    }

    public CLongBuffer clongs(long l, long l2) {
        return this.mallocCLong(2).put(0, l).put(1, l2);
    }

    public CLongBuffer clongs(long l, long l2, long l3) {
        return this.mallocCLong(3).put(0, l).put(1, l2).put(2, l3);
    }

    public CLongBuffer clongs(long l, long l2, long l3, long l4) {
        return this.mallocCLong(4).put(0, l).put(1, l2).put(2, l3).put(3, l4);
    }

    public CLongBuffer clongs(long ... lArray) {
        CLongBuffer cLongBuffer = this.mallocCLong(lArray.length).put(lArray);
        cLongBuffer.flip();
        return cLongBuffer;
    }

    public FloatBuffer mallocFloat(int n) {
        return MemoryUtil.wrapBufferFloat(this.nmalloc(4, n << 2), n);
    }

    public FloatBuffer callocFloat(int n) {
        int n2 = n * 4;
        long l = this.nmalloc(4, n2);
        MemoryUtil.memSet(l, 0, n2);
        return MemoryUtil.wrapBufferFloat(l, n);
    }

    public long nfloat(float f) {
        long l = this.nmalloc(4, 4);
        MemoryUtil.memPutFloat(l, f);
        return l;
    }

    public FloatBuffer floats(float f) {
        return this.mallocFloat(1).put(0, f);
    }

    public FloatBuffer floats(float f, float f2) {
        return this.mallocFloat(2).put(0, f).put(1, f2);
    }

    public FloatBuffer floats(float f, float f2, float f3) {
        return this.mallocFloat(3).put(0, f).put(1, f2).put(2, f3);
    }

    public FloatBuffer floats(float f, float f2, float f3, float f4) {
        return this.mallocFloat(4).put(0, f).put(1, f2).put(2, f3).put(3, f4);
    }

    public FloatBuffer floats(float ... fArray) {
        FloatBuffer floatBuffer = this.mallocFloat(fArray.length).put(fArray);
        floatBuffer.flip();
        return floatBuffer;
    }

    public DoubleBuffer mallocDouble(int n) {
        return MemoryUtil.wrapBufferDouble(this.nmalloc(8, n << 3), n);
    }

    public DoubleBuffer callocDouble(int n) {
        int n2 = n * 8;
        long l = this.nmalloc(8, n2);
        MemoryUtil.memSet(l, 0, n2);
        return MemoryUtil.wrapBufferDouble(l, n);
    }

    public long ndouble(double d) {
        long l = this.nmalloc(8, 8);
        MemoryUtil.memPutDouble(l, d);
        return l;
    }

    public DoubleBuffer doubles(double d) {
        return this.mallocDouble(1).put(0, d);
    }

    public DoubleBuffer doubles(double d, double d2) {
        return this.mallocDouble(2).put(0, d).put(1, d2);
    }

    public DoubleBuffer doubles(double d, double d2, double d3) {
        return this.mallocDouble(3).put(0, d).put(1, d2).put(2, d3);
    }

    public DoubleBuffer doubles(double d, double d2, double d3, double d4) {
        return this.mallocDouble(4).put(0, d).put(1, d2).put(2, d3).put(3, d4);
    }

    public DoubleBuffer doubles(double ... dArray) {
        DoubleBuffer doubleBuffer = this.mallocDouble(dArray.length).put(dArray);
        doubleBuffer.flip();
        return doubleBuffer;
    }

    public PointerBuffer mallocPointer(int n) {
        return PointerBuffer.create(this.nmalloc(POINTER_SIZE, n << POINTER_SHIFT), n);
    }

    public PointerBuffer callocPointer(int n) {
        int n2 = n * POINTER_SIZE;
        long l = this.nmalloc(POINTER_SIZE, n2);
        MemoryUtil.memSet(l, 0, n2);
        return PointerBuffer.create(l, n);
    }

    public long npointer(long l) {
        long l2 = this.nmalloc(POINTER_SIZE, POINTER_SIZE);
        MemoryUtil.memPutAddress(l2, l);
        return l2;
    }

    public PointerBuffer pointers(long l) {
        return this.mallocPointer(1).put(0, l);
    }

    public PointerBuffer pointers(long l, long l2) {
        return this.mallocPointer(2).put(0, l).put(1, l2);
    }

    public PointerBuffer pointers(long l, long l2, long l3) {
        return this.mallocPointer(3).put(0, l).put(1, l2).put(2, l3);
    }

    public PointerBuffer pointers(long l, long l2, long l3, long l4) {
        return this.mallocPointer(4).put(0, l).put(1, l2).put(2, l3).put(3, l4);
    }

    public PointerBuffer pointers(long ... lArray) {
        PointerBuffer pointerBuffer = this.mallocPointer(lArray.length).put(lArray);
        pointerBuffer.flip();
        return pointerBuffer;
    }

    public long npointer(Pointer pointer) {
        long l = this.nmalloc(POINTER_SIZE, POINTER_SIZE);
        MemoryUtil.memPutAddress(l, pointer.address());
        return l;
    }

    public PointerBuffer pointers(Pointer pointer) {
        return this.mallocPointer(1).put(0, pointer);
    }

    public PointerBuffer pointers(Pointer pointer, Pointer pointer2) {
        return this.mallocPointer(2).put(0, pointer).put(1, pointer2);
    }

    public PointerBuffer pointers(Pointer pointer, Pointer pointer2, Pointer pointer3) {
        return this.mallocPointer(3).put(0, pointer).put(1, pointer2).put(2, pointer3);
    }

    public PointerBuffer pointers(Pointer pointer, Pointer pointer2, Pointer pointer3, Pointer pointer4) {
        return this.mallocPointer(4).put(0, pointer).put(1, pointer2).put(2, pointer3).put(3, pointer4);
    }

    public PointerBuffer pointers(Pointer ... pointerArray) {
        PointerBuffer pointerBuffer = this.mallocPointer(pointerArray.length);
        for (int i = 0; i < pointerArray.length; ++i) {
            pointerBuffer.put(i, pointerArray[i]);
        }
        return pointerBuffer;
    }

    public long npointer(Buffer buffer) {
        long l = this.nmalloc(POINTER_SIZE, POINTER_SIZE);
        MemoryUtil.memPutAddress(l, MemoryUtil.memAddress(buffer));
        return l;
    }

    public PointerBuffer pointers(Buffer buffer) {
        return this.mallocPointer(1).put(0, MemoryUtil.memAddress(buffer));
    }

    public PointerBuffer pointers(Buffer buffer, Buffer buffer2) {
        return this.mallocPointer(2).put(0, MemoryUtil.memAddress(buffer)).put(1, MemoryUtil.memAddress(buffer2));
    }

    public PointerBuffer pointers(Buffer buffer, Buffer buffer2, Buffer buffer3) {
        return this.mallocPointer(3).put(0, MemoryUtil.memAddress(buffer)).put(1, MemoryUtil.memAddress(buffer2)).put(2, MemoryUtil.memAddress(buffer3));
    }

    public PointerBuffer pointers(Buffer buffer, Buffer buffer2, Buffer buffer3, Buffer buffer4) {
        return this.mallocPointer(4).put(0, MemoryUtil.memAddress(buffer)).put(1, MemoryUtil.memAddress(buffer2)).put(2, MemoryUtil.memAddress(buffer3)).put(3, MemoryUtil.memAddress(buffer4));
    }

    public PointerBuffer pointers(Buffer ... bufferArray) {
        PointerBuffer pointerBuffer = this.mallocPointer(bufferArray.length);
        for (int i = 0; i < bufferArray.length; ++i) {
            pointerBuffer.put(i, MemoryUtil.memAddress(bufferArray[i]));
        }
        return pointerBuffer;
    }

    public PointerBuffer pointersOfElements(CustomBuffer<?> customBuffer) {
        int n = customBuffer.remaining();
        long l = customBuffer.address();
        long l2 = customBuffer.sizeof();
        PointerBuffer pointerBuffer = this.mallocPointer(n);
        for (int i = 0; i < n; ++i) {
            pointerBuffer.put(i, l + l2 * (long)i);
        }
        return pointerBuffer;
    }

    public ByteBuffer ASCII(CharSequence charSequence) {
        return this.ASCII(charSequence, true);
    }

    public ByteBuffer ASCII(CharSequence charSequence, boolean bl) {
        int n = MemoryUtil.memLengthASCII(charSequence, bl);
        long l = this.nmalloc(POINTER_SIZE, n);
        MemoryUtil.encodeASCIIUnsafe(charSequence, bl, l);
        return MemoryUtil.wrapBufferByte(l, n);
    }

    public int nASCII(CharSequence charSequence, boolean bl) {
        long l = this.nmalloc(POINTER_SIZE, MemoryUtil.memLengthASCII(charSequence, bl));
        return MemoryUtil.encodeASCIIUnsafe(charSequence, bl, l);
    }

    public @Nullable ByteBuffer ASCIISafe(@Nullable CharSequence charSequence) {
        return this.ASCIISafe(charSequence, true);
    }

    public @Nullable ByteBuffer ASCIISafe(@Nullable CharSequence charSequence, boolean bl) {
        return charSequence == null ? null : this.ASCII(charSequence, bl);
    }

    public int nASCIISafe(@Nullable CharSequence charSequence, boolean bl) {
        return charSequence == null ? 0 : this.nASCII(charSequence, bl);
    }

    public ByteBuffer UTF8(CharSequence charSequence) {
        return this.UTF8(charSequence, true);
    }

    public ByteBuffer UTF8(CharSequence charSequence, boolean bl) {
        int n = MemoryUtil.memLengthUTF8(charSequence, bl);
        long l = this.nmalloc(POINTER_SIZE, n);
        MemoryUtil.encodeUTF8Unsafe(charSequence, bl, l);
        return MemoryUtil.wrapBufferByte(l, n);
    }

    public int nUTF8(CharSequence charSequence, boolean bl) {
        long l = this.nmalloc(POINTER_SIZE, MemoryUtil.memLengthUTF8(charSequence, bl));
        return MemoryUtil.encodeUTF8Unsafe(charSequence, bl, l);
    }

    public @Nullable ByteBuffer UTF8Safe(@Nullable CharSequence charSequence) {
        return this.UTF8Safe(charSequence, true);
    }

    public @Nullable ByteBuffer UTF8Safe(@Nullable CharSequence charSequence, boolean bl) {
        return charSequence == null ? null : this.UTF8(charSequence, bl);
    }

    public int nUTF8Safe(@Nullable CharSequence charSequence, boolean bl) {
        return charSequence == null ? 0 : this.nUTF8(charSequence, bl);
    }

    public ByteBuffer UTF16(CharSequence charSequence) {
        return this.UTF16(charSequence, true);
    }

    public ByteBuffer UTF16(CharSequence charSequence, boolean bl) {
        int n = MemoryUtil.memLengthUTF16(charSequence, bl);
        long l = this.nmalloc(POINTER_SIZE, n);
        MemoryUtil.encodeUTF16Unsafe(charSequence, bl, l);
        return MemoryUtil.wrapBufferByte(l, n);
    }

    public int nUTF16(CharSequence charSequence, boolean bl) {
        long l = this.nmalloc(POINTER_SIZE, MemoryUtil.memLengthUTF16(charSequence, bl));
        return MemoryUtil.encodeUTF16Unsafe(charSequence, bl, l);
    }

    public @Nullable ByteBuffer UTF16Safe(@Nullable CharSequence charSequence) {
        return this.UTF16Safe(charSequence, true);
    }

    public @Nullable ByteBuffer UTF16Safe(@Nullable CharSequence charSequence, boolean bl) {
        return charSequence == null ? null : this.UTF16(charSequence, bl);
    }

    public int nUTF16Safe(@Nullable CharSequence charSequence, boolean bl) {
        return charSequence == null ? 0 : this.nUTF16(charSequence, bl);
    }

    public static MemoryStack stackGet() {
        return TLS.get();
    }

    public static MemoryStack stackPush() {
        return MemoryStack.stackGet().push();
    }

    public static MemoryStack stackPop() {
        return MemoryStack.stackGet().pop();
    }

    public static long nstackMalloc(int n) {
        return MemoryStack.stackGet().nmalloc(n);
    }

    public static long nstackMalloc(int n, int n2) {
        return MemoryStack.stackGet().nmalloc(n, n2);
    }

    public static long nstackCalloc(int n, int n2, int n3) {
        return MemoryStack.stackGet().ncalloc(n, n2, n3);
    }

    public static ByteBuffer stackMalloc(int n) {
        return MemoryStack.stackGet().malloc(n);
    }

    public static ByteBuffer stackCalloc(int n) {
        return MemoryStack.stackGet().calloc(n);
    }

    public static ByteBuffer stackBytes(byte by) {
        return MemoryStack.stackGet().bytes(by);
    }

    public static ByteBuffer stackBytes(byte by, byte by2) {
        return MemoryStack.stackGet().bytes(by, by2);
    }

    public static ByteBuffer stackBytes(byte by, byte by2, byte by3) {
        return MemoryStack.stackGet().bytes(by, by2, by3);
    }

    public static ByteBuffer stackBytes(byte by, byte by2, byte by3, byte by4) {
        return MemoryStack.stackGet().bytes(by, by2, by3, by4);
    }

    public static ByteBuffer stackBytes(byte ... byArray) {
        return MemoryStack.stackGet().bytes(byArray);
    }

    public static ShortBuffer stackMallocShort(int n) {
        return MemoryStack.stackGet().mallocShort(n);
    }

    public static ShortBuffer stackCallocShort(int n) {
        return MemoryStack.stackGet().callocShort(n);
    }

    public static ShortBuffer stackShorts(short s) {
        return MemoryStack.stackGet().shorts(s);
    }

    public static ShortBuffer stackShorts(short s, short s2) {
        return MemoryStack.stackGet().shorts(s, s2);
    }

    public static ShortBuffer stackShorts(short s, short s2, short s3) {
        return MemoryStack.stackGet().shorts(s, s2, s3);
    }

    public static ShortBuffer stackShorts(short s, short s2, short s3, short s4) {
        return MemoryStack.stackGet().shorts(s, s2, s3, s4);
    }

    public static ShortBuffer stackShorts(short ... sArray) {
        return MemoryStack.stackGet().shorts(sArray);
    }

    public static IntBuffer stackMallocInt(int n) {
        return MemoryStack.stackGet().mallocInt(n);
    }

    public static IntBuffer stackCallocInt(int n) {
        return MemoryStack.stackGet().callocInt(n);
    }

    public static IntBuffer stackInts(int n) {
        return MemoryStack.stackGet().ints(n);
    }

    public static IntBuffer stackInts(int n, int n2) {
        return MemoryStack.stackGet().ints(n, n2);
    }

    public static IntBuffer stackInts(int n, int n2, int n3) {
        return MemoryStack.stackGet().ints(n, n2, n3);
    }

    public static IntBuffer stackInts(int n, int n2, int n3, int n4) {
        return MemoryStack.stackGet().ints(n, n2, n3, n4);
    }

    public static IntBuffer stackInts(int ... nArray) {
        return MemoryStack.stackGet().ints(nArray);
    }

    public static LongBuffer stackMallocLong(int n) {
        return MemoryStack.stackGet().mallocLong(n);
    }

    public static LongBuffer stackCallocLong(int n) {
        return MemoryStack.stackGet().callocLong(n);
    }

    public static LongBuffer stackLongs(long l) {
        return MemoryStack.stackGet().longs(l);
    }

    public static LongBuffer stackLongs(long l, long l2) {
        return MemoryStack.stackGet().longs(l, l2);
    }

    public static LongBuffer stackLongs(long l, long l2, long l3) {
        return MemoryStack.stackGet().longs(l, l2, l3);
    }

    public static LongBuffer stackLongs(long l, long l2, long l3, long l4) {
        return MemoryStack.stackGet().longs(l, l2, l3, l4);
    }

    public static LongBuffer stackLongs(long ... lArray) {
        return MemoryStack.stackGet().longs(lArray);
    }

    public static CLongBuffer stackMallocCLong(int n) {
        return MemoryStack.stackGet().mallocCLong(n);
    }

    public static CLongBuffer stackCallocCLong(int n) {
        return MemoryStack.stackGet().callocCLong(n);
    }

    public static CLongBuffer stackCLongs(long l) {
        return MemoryStack.stackGet().clongs(l);
    }

    public static CLongBuffer stackCLongs(long l, long l2) {
        return MemoryStack.stackGet().clongs(l, l2);
    }

    public static CLongBuffer stackCLongs(long l, long l2, long l3) {
        return MemoryStack.stackGet().clongs(l, l2, l3);
    }

    public static CLongBuffer stackCLongs(long l, long l2, long l3, long l4) {
        return MemoryStack.stackGet().clongs(l, l2, l3, l4);
    }

    public static CLongBuffer stackCLongs(long ... lArray) {
        return MemoryStack.stackGet().clongs(lArray);
    }

    public static FloatBuffer stackMallocFloat(int n) {
        return MemoryStack.stackGet().mallocFloat(n);
    }

    public static FloatBuffer stackCallocFloat(int n) {
        return MemoryStack.stackGet().callocFloat(n);
    }

    public static FloatBuffer stackFloats(float f) {
        return MemoryStack.stackGet().floats(f);
    }

    public static FloatBuffer stackFloats(float f, float f2) {
        return MemoryStack.stackGet().floats(f, f2);
    }

    public static FloatBuffer stackFloats(float f, float f2, float f3) {
        return MemoryStack.stackGet().floats(f, f2, f3);
    }

    public static FloatBuffer stackFloats(float f, float f2, float f3, float f4) {
        return MemoryStack.stackGet().floats(f, f2, f3, f4);
    }

    public static FloatBuffer stackFloats(float ... fArray) {
        return MemoryStack.stackGet().floats(fArray);
    }

    public static DoubleBuffer stackMallocDouble(int n) {
        return MemoryStack.stackGet().mallocDouble(n);
    }

    public static DoubleBuffer stackCallocDouble(int n) {
        return MemoryStack.stackGet().callocDouble(n);
    }

    public static DoubleBuffer stackDoubles(double d) {
        return MemoryStack.stackGet().doubles(d);
    }

    public static DoubleBuffer stackDoubles(double d, double d2) {
        return MemoryStack.stackGet().doubles(d, d2);
    }

    public static DoubleBuffer stackDoubles(double d, double d2, double d3) {
        return MemoryStack.stackGet().doubles(d, d2, d3);
    }

    public static DoubleBuffer stackDoubles(double d, double d2, double d3, double d4) {
        return MemoryStack.stackGet().doubles(d, d2, d3, d4);
    }

    public static DoubleBuffer stackDoubles(double ... dArray) {
        return MemoryStack.stackGet().doubles(dArray);
    }

    public static PointerBuffer stackMallocPointer(int n) {
        return MemoryStack.stackGet().mallocPointer(n);
    }

    public static PointerBuffer stackCallocPointer(int n) {
        return MemoryStack.stackGet().callocPointer(n);
    }

    public static PointerBuffer stackPointers(long l) {
        return MemoryStack.stackGet().pointers(l);
    }

    public static PointerBuffer stackPointers(long l, long l2) {
        return MemoryStack.stackGet().pointers(l, l2);
    }

    public static PointerBuffer stackPointers(long l, long l2, long l3) {
        return MemoryStack.stackGet().pointers(l, l2, l3);
    }

    public static PointerBuffer stackPointers(long l, long l2, long l3, long l4) {
        return MemoryStack.stackGet().pointers(l, l2, l3, l4);
    }

    public static PointerBuffer stackPointers(long ... lArray) {
        return MemoryStack.stackGet().pointers(lArray);
    }

    public static PointerBuffer stackPointers(Pointer pointer) {
        return MemoryStack.stackGet().pointers(pointer);
    }

    public static PointerBuffer stackPointers(Pointer pointer, Pointer pointer2) {
        return MemoryStack.stackGet().pointers(pointer, pointer2);
    }

    public static PointerBuffer stackPointers(Pointer pointer, Pointer pointer2, Pointer pointer3) {
        return MemoryStack.stackGet().pointers(pointer, pointer2, pointer3);
    }

    public static PointerBuffer stackPointers(Pointer pointer, Pointer pointer2, Pointer pointer3, Pointer pointer4) {
        return MemoryStack.stackGet().pointers(pointer, pointer2, pointer3, pointer4);
    }

    public static PointerBuffer stackPointers(Pointer ... pointerArray) {
        return MemoryStack.stackGet().pointers(pointerArray);
    }

    public static ByteBuffer stackASCII(CharSequence charSequence) {
        return MemoryStack.stackGet().ASCII(charSequence);
    }

    public static ByteBuffer stackASCII(CharSequence charSequence, boolean bl) {
        return MemoryStack.stackGet().ASCII(charSequence, bl);
    }

    public static ByteBuffer stackUTF8(CharSequence charSequence) {
        return MemoryStack.stackGet().UTF8(charSequence);
    }

    public static ByteBuffer stackUTF8(CharSequence charSequence, boolean bl) {
        return MemoryStack.stackGet().UTF8(charSequence, bl);
    }

    public static ByteBuffer stackUTF16(CharSequence charSequence) {
        return MemoryStack.stackGet().UTF16(charSequence);
    }

    public static ByteBuffer stackUTF16(CharSequence charSequence, boolean bl) {
        return MemoryStack.stackGet().UTF16(charSequence, bl);
    }

    public static @Nullable ByteBuffer stackASCIISafe(@Nullable CharSequence charSequence) {
        return MemoryStack.stackGet().ASCIISafe(charSequence);
    }

    public static @Nullable ByteBuffer stackASCIISafe(@Nullable CharSequence charSequence, boolean bl) {
        return MemoryStack.stackGet().ASCIISafe(charSequence, bl);
    }

    public static @Nullable ByteBuffer stackUTF8Safe(@Nullable CharSequence charSequence) {
        return MemoryStack.stackGet().UTF8Safe(charSequence);
    }

    public static @Nullable ByteBuffer stackUTF8Safe(@Nullable CharSequence charSequence, boolean bl) {
        return MemoryStack.stackGet().UTF8Safe(charSequence, bl);
    }

    public static @Nullable ByteBuffer stackUTF16Safe(@Nullable CharSequence charSequence) {
        return MemoryStack.stackGet().UTF16Safe(charSequence);
    }

    public static @Nullable ByteBuffer stackUTF16Safe(@Nullable CharSequence charSequence, boolean bl) {
        return MemoryStack.stackGet().UTF16Safe(charSequence, bl);
    }

    static {
        if (DEFAULT_STACK_SIZE < 0) {
            throw new IllegalStateException("Invalid stack size.");
        }
    }

    private static class DebugMemoryStack
    extends MemoryStack {
        private @Nullable Object[] debugFrames = new Object[8];

        DebugMemoryStack(@Nullable ByteBuffer byteBuffer, long l, int n) {
            super(byteBuffer, l, n);
        }

        @Override
        public MemoryStack push() {
            if (this.frameIndex == this.debugFrames.length) {
                this.frameOverflow();
            }
            this.debugFrames[this.frameIndex] = StackWalkUtil.stackWalkGetMethod(MemoryStack.class);
            return super.push();
        }

        @Override
        private void frameOverflow() {
            this.debugFrames = Arrays.copyOf(this.debugFrames, this.debugFrames.length * 3 / 2);
        }

        @Override
        public MemoryStack pop() {
            Object object = this.debugFrames[this.frameIndex - 1];
            Object object2 = StackWalkUtil.stackWalkCheckPop(MemoryStack.class, object);
            if (object2 != null) {
                DebugMemoryStack.reportAsymmetricPop(object, object2);
            }
            this.debugFrames[this.frameIndex - 1] = null;
            return super.pop();
        }

        @Override
        public void close() {
            this.debugFrames[this.frameIndex - 1] = null;
            super.pop();
        }

        private static void reportAsymmetricPop(Object object, Object object2) {
            APIUtil.DEBUG_STREAM.format("[LWJGL] Asymmetric pop detected:\n\tPUSHED: %s\n\tPOPPED: %s\n\tTHREAD: %s\n", object, object2, Thread.currentThread());
        }
    }
}


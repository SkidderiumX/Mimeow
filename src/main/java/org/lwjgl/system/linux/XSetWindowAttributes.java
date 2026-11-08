/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.linux;

import java.nio.ByteBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

public class XSetWindowAttributes
extends Struct<XSetWindowAttributes>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int BACKGROUND_PIXMAP;
    public static final int BACKGROUND_PIXEL;
    public static final int BORDER_PIXMAP;
    public static final int BORDER_PIXEL;
    public static final int BIT_GRAVITY;
    public static final int WIN_GRAVITY;
    public static final int BACKING_STORE;
    public static final int BACKING_PLANES;
    public static final int BACKING_PIXEL;
    public static final int SAVE_UNDER;
    public static final int EVENT_MASK;
    public static final int DO_NOT_PROPAGATE_MASK;
    public static final int OVERRIDE_REDIRECT;
    public static final int COLORMAP;
    public static final int CURSOR;

    protected XSetWindowAttributes(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected XSetWindowAttributes create(long l, @Nullable ByteBuffer byteBuffer) {
        return new XSetWindowAttributes(l, byteBuffer);
    }

    public XSetWindowAttributes(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XSetWindowAttributes.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="Pixmap")
    public long background_pixmap() {
        return XSetWindowAttributes.nbackground_pixmap(this.address());
    }

    @NativeType(value="unsigned long")
    public long background_pixel() {
        return XSetWindowAttributes.nbackground_pixel(this.address());
    }

    @NativeType(value="Pixmap")
    public long border_pixmap() {
        return XSetWindowAttributes.nborder_pixmap(this.address());
    }

    @NativeType(value="unsigned long")
    public long border_pixel() {
        return XSetWindowAttributes.nborder_pixel(this.address());
    }

    public int bit_gravity() {
        return XSetWindowAttributes.nbit_gravity(this.address());
    }

    public int win_gravity() {
        return XSetWindowAttributes.nwin_gravity(this.address());
    }

    public int backing_store() {
        return XSetWindowAttributes.nbacking_store(this.address());
    }

    @NativeType(value="unsigned long")
    public long backing_planes() {
        return XSetWindowAttributes.nbacking_planes(this.address());
    }

    @NativeType(value="unsigned long")
    public long backing_pixel() {
        return XSetWindowAttributes.nbacking_pixel(this.address());
    }

    @NativeType(value="Bool")
    public boolean save_under() {
        return XSetWindowAttributes.nsave_under(this.address()) != 0;
    }

    public long event_mask() {
        return XSetWindowAttributes.nevent_mask(this.address());
    }

    public long do_not_propagate_mask() {
        return XSetWindowAttributes.ndo_not_propagate_mask(this.address());
    }

    @NativeType(value="Bool")
    public boolean override_redirect() {
        return XSetWindowAttributes.noverride_redirect(this.address()) != 0;
    }

    @NativeType(value="Colormap")
    public long colormap() {
        return XSetWindowAttributes.ncolormap(this.address());
    }

    @NativeType(value="Cursor")
    public long cursor() {
        return XSetWindowAttributes.ncursor(this.address());
    }

    public XSetWindowAttributes background_pixmap(@NativeType(value="Pixmap") long l) {
        XSetWindowAttributes.nbackground_pixmap(this.address(), l);
        return this;
    }

    public XSetWindowAttributes background_pixel(@NativeType(value="unsigned long") long l) {
        XSetWindowAttributes.nbackground_pixel(this.address(), l);
        return this;
    }

    public XSetWindowAttributes border_pixmap(@NativeType(value="Pixmap") long l) {
        XSetWindowAttributes.nborder_pixmap(this.address(), l);
        return this;
    }

    public XSetWindowAttributes border_pixel(@NativeType(value="unsigned long") long l) {
        XSetWindowAttributes.nborder_pixel(this.address(), l);
        return this;
    }

    public XSetWindowAttributes bit_gravity(int n) {
        XSetWindowAttributes.nbit_gravity(this.address(), n);
        return this;
    }

    public XSetWindowAttributes win_gravity(int n) {
        XSetWindowAttributes.nwin_gravity(this.address(), n);
        return this;
    }

    public XSetWindowAttributes backing_store(int n) {
        XSetWindowAttributes.nbacking_store(this.address(), n);
        return this;
    }

    public XSetWindowAttributes backing_planes(@NativeType(value="unsigned long") long l) {
        XSetWindowAttributes.nbacking_planes(this.address(), l);
        return this;
    }

    public XSetWindowAttributes backing_pixel(@NativeType(value="unsigned long") long l) {
        XSetWindowAttributes.nbacking_pixel(this.address(), l);
        return this;
    }

    public XSetWindowAttributes save_under(@NativeType(value="Bool") boolean bl) {
        XSetWindowAttributes.nsave_under(this.address(), bl ? 1 : 0);
        return this;
    }

    public XSetWindowAttributes event_mask(long l) {
        XSetWindowAttributes.nevent_mask(this.address(), l);
        return this;
    }

    public XSetWindowAttributes do_not_propagate_mask(long l) {
        XSetWindowAttributes.ndo_not_propagate_mask(this.address(), l);
        return this;
    }

    public XSetWindowAttributes override_redirect(@NativeType(value="Bool") boolean bl) {
        XSetWindowAttributes.noverride_redirect(this.address(), bl ? 1 : 0);
        return this;
    }

    public XSetWindowAttributes colormap(@NativeType(value="Colormap") long l) {
        XSetWindowAttributes.ncolormap(this.address(), l);
        return this;
    }

    public XSetWindowAttributes cursor(@NativeType(value="Cursor") long l) {
        XSetWindowAttributes.ncursor(this.address(), l);
        return this;
    }

    public XSetWindowAttributes set(long l, long l2, long l3, long l4, int n, int n2, int n3, long l5, long l6, boolean bl, long l7, long l8, boolean bl2, long l9, long l10) {
        this.background_pixmap(l);
        this.background_pixel(l2);
        this.border_pixmap(l3);
        this.border_pixel(l4);
        this.bit_gravity(n);
        this.win_gravity(n2);
        this.backing_store(n3);
        this.backing_planes(l5);
        this.backing_pixel(l6);
        this.save_under(bl);
        this.event_mask(l7);
        this.do_not_propagate_mask(l8);
        this.override_redirect(bl2);
        this.colormap(l9);
        this.cursor(l10);
        return this;
    }

    public XSetWindowAttributes set(XSetWindowAttributes xSetWindowAttributes) {
        MemoryUtil.memCopy(xSetWindowAttributes.address(), this.address(), SIZEOF);
        return this;
    }

    public static XSetWindowAttributes malloc() {
        return new XSetWindowAttributes(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XSetWindowAttributes calloc() {
        return new XSetWindowAttributes(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XSetWindowAttributes create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new XSetWindowAttributes(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XSetWindowAttributes create(long l) {
        return new XSetWindowAttributes(l, null);
    }

    public static @Nullable XSetWindowAttributes createSafe(long l) {
        return l == 0L ? null : new XSetWindowAttributes(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XSetWindowAttributes.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = XSetWindowAttributes.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static XSetWindowAttributes mallocStack() {
        return XSetWindowAttributes.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XSetWindowAttributes callocStack() {
        return XSetWindowAttributes.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XSetWindowAttributes mallocStack(MemoryStack memoryStack) {
        return XSetWindowAttributes.malloc(memoryStack);
    }

    @Deprecated
    public static XSetWindowAttributes callocStack(MemoryStack memoryStack) {
        return XSetWindowAttributes.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return XSetWindowAttributes.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return XSetWindowAttributes.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return XSetWindowAttributes.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return XSetWindowAttributes.calloc(n, memoryStack);
    }

    public static XSetWindowAttributes malloc(MemoryStack memoryStack) {
        return new XSetWindowAttributes(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XSetWindowAttributes calloc(MemoryStack memoryStack) {
        return new XSetWindowAttributes(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static long nbackground_pixmap(long l) {
        return MemoryUtil.memGetCLong(l + (long)BACKGROUND_PIXMAP);
    }

    public static long nbackground_pixel(long l) {
        return MemoryUtil.memGetCLong(l + (long)BACKGROUND_PIXEL);
    }

    public static long nborder_pixmap(long l) {
        return MemoryUtil.memGetCLong(l + (long)BORDER_PIXMAP);
    }

    public static long nborder_pixel(long l) {
        return MemoryUtil.memGetCLong(l + (long)BORDER_PIXEL);
    }

    public static int nbit_gravity(long l) {
        return MemoryUtil.memGetInt(l + (long)BIT_GRAVITY);
    }

    public static int nwin_gravity(long l) {
        return MemoryUtil.memGetInt(l + (long)WIN_GRAVITY);
    }

    public static int nbacking_store(long l) {
        return MemoryUtil.memGetInt(l + (long)BACKING_STORE);
    }

    public static long nbacking_planes(long l) {
        return MemoryUtil.memGetCLong(l + (long)BACKING_PLANES);
    }

    public static long nbacking_pixel(long l) {
        return MemoryUtil.memGetCLong(l + (long)BACKING_PIXEL);
    }

    public static int nsave_under(long l) {
        return MemoryUtil.memGetInt(l + (long)SAVE_UNDER);
    }

    public static long nevent_mask(long l) {
        return MemoryUtil.memGetCLong(l + (long)EVENT_MASK);
    }

    public static long ndo_not_propagate_mask(long l) {
        return MemoryUtil.memGetCLong(l + (long)DO_NOT_PROPAGATE_MASK);
    }

    public static int noverride_redirect(long l) {
        return MemoryUtil.memGetInt(l + (long)OVERRIDE_REDIRECT);
    }

    public static long ncolormap(long l) {
        return MemoryUtil.memGetCLong(l + (long)COLORMAP);
    }

    public static long ncursor(long l) {
        return MemoryUtil.memGetCLong(l + (long)CURSOR);
    }

    public static void nbackground_pixmap(long l, long l2) {
        MemoryUtil.memPutCLong(l + (long)BACKGROUND_PIXMAP, l2);
    }

    public static void nbackground_pixel(long l, long l2) {
        MemoryUtil.memPutCLong(l + (long)BACKGROUND_PIXEL, l2);
    }

    public static void nborder_pixmap(long l, long l2) {
        MemoryUtil.memPutCLong(l + (long)BORDER_PIXMAP, l2);
    }

    public static void nborder_pixel(long l, long l2) {
        MemoryUtil.memPutCLong(l + (long)BORDER_PIXEL, l2);
    }

    public static void nbit_gravity(long l, int n) {
        MemoryUtil.memPutInt(l + (long)BIT_GRAVITY, n);
    }

    public static void nwin_gravity(long l, int n) {
        MemoryUtil.memPutInt(l + (long)WIN_GRAVITY, n);
    }

    public static void nbacking_store(long l, int n) {
        MemoryUtil.memPutInt(l + (long)BACKING_STORE, n);
    }

    public static void nbacking_planes(long l, long l2) {
        MemoryUtil.memPutCLong(l + (long)BACKING_PLANES, l2);
    }

    public static void nbacking_pixel(long l, long l2) {
        MemoryUtil.memPutCLong(l + (long)BACKING_PIXEL, l2);
    }

    public static void nsave_under(long l, int n) {
        MemoryUtil.memPutInt(l + (long)SAVE_UNDER, n);
    }

    public static void nevent_mask(long l, long l2) {
        MemoryUtil.memPutCLong(l + (long)EVENT_MASK, l2);
    }

    public static void ndo_not_propagate_mask(long l, long l2) {
        MemoryUtil.memPutCLong(l + (long)DO_NOT_PROPAGATE_MASK, l2);
    }

    public static void noverride_redirect(long l, int n) {
        MemoryUtil.memPutInt(l + (long)OVERRIDE_REDIRECT, n);
    }

    public static void ncolormap(long l, long l2) {
        MemoryUtil.memPutCLong(l + (long)COLORMAP, l2);
    }

    public static void ncursor(long l, long l2) {
        MemoryUtil.memPutCLong(l + (long)CURSOR, l2);
    }

    static {
        Struct.Layout layout = XSetWindowAttributes.__struct(XSetWindowAttributes.__member(CLONG_SIZE), XSetWindowAttributes.__member(CLONG_SIZE), XSetWindowAttributes.__member(CLONG_SIZE), XSetWindowAttributes.__member(CLONG_SIZE), XSetWindowAttributes.__member(4), XSetWindowAttributes.__member(4), XSetWindowAttributes.__member(4), XSetWindowAttributes.__member(CLONG_SIZE), XSetWindowAttributes.__member(CLONG_SIZE), XSetWindowAttributes.__member(4), XSetWindowAttributes.__member(CLONG_SIZE), XSetWindowAttributes.__member(CLONG_SIZE), XSetWindowAttributes.__member(4), XSetWindowAttributes.__member(CLONG_SIZE), XSetWindowAttributes.__member(CLONG_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        BACKGROUND_PIXMAP = layout.offsetof(0);
        BACKGROUND_PIXEL = layout.offsetof(1);
        BORDER_PIXMAP = layout.offsetof(2);
        BORDER_PIXEL = layout.offsetof(3);
        BIT_GRAVITY = layout.offsetof(4);
        WIN_GRAVITY = layout.offsetof(5);
        BACKING_STORE = layout.offsetof(6);
        BACKING_PLANES = layout.offsetof(7);
        BACKING_PIXEL = layout.offsetof(8);
        SAVE_UNDER = layout.offsetof(9);
        EVENT_MASK = layout.offsetof(10);
        DO_NOT_PROPAGATE_MASK = layout.offsetof(11);
        OVERRIDE_REDIRECT = layout.offsetof(12);
        COLORMAP = layout.offsetof(13);
        CURSOR = layout.offsetof(14);
    }

    public static class Buffer
    extends StructBuffer<XSetWindowAttributes, Buffer>
    implements NativeResource {
        private static final XSetWindowAttributes ELEMENT_FACTORY = XSetWindowAttributes.create(-1L);

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
        protected XSetWindowAttributes getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="Pixmap")
        public long background_pixmap() {
            return XSetWindowAttributes.nbackground_pixmap(this.address());
        }

        @NativeType(value="unsigned long")
        public long background_pixel() {
            return XSetWindowAttributes.nbackground_pixel(this.address());
        }

        @NativeType(value="Pixmap")
        public long border_pixmap() {
            return XSetWindowAttributes.nborder_pixmap(this.address());
        }

        @NativeType(value="unsigned long")
        public long border_pixel() {
            return XSetWindowAttributes.nborder_pixel(this.address());
        }

        public int bit_gravity() {
            return XSetWindowAttributes.nbit_gravity(this.address());
        }

        public int win_gravity() {
            return XSetWindowAttributes.nwin_gravity(this.address());
        }

        public int backing_store() {
            return XSetWindowAttributes.nbacking_store(this.address());
        }

        @NativeType(value="unsigned long")
        public long backing_planes() {
            return XSetWindowAttributes.nbacking_planes(this.address());
        }

        @NativeType(value="unsigned long")
        public long backing_pixel() {
            return XSetWindowAttributes.nbacking_pixel(this.address());
        }

        @NativeType(value="Bool")
        public boolean save_under() {
            return XSetWindowAttributes.nsave_under(this.address()) != 0;
        }

        public long event_mask() {
            return XSetWindowAttributes.nevent_mask(this.address());
        }

        public long do_not_propagate_mask() {
            return XSetWindowAttributes.ndo_not_propagate_mask(this.address());
        }

        @NativeType(value="Bool")
        public boolean override_redirect() {
            return XSetWindowAttributes.noverride_redirect(this.address()) != 0;
        }

        @NativeType(value="Colormap")
        public long colormap() {
            return XSetWindowAttributes.ncolormap(this.address());
        }

        @NativeType(value="Cursor")
        public long cursor() {
            return XSetWindowAttributes.ncursor(this.address());
        }

        public Buffer background_pixmap(@NativeType(value="Pixmap") long l) {
            XSetWindowAttributes.nbackground_pixmap(this.address(), l);
            return this;
        }

        public Buffer background_pixel(@NativeType(value="unsigned long") long l) {
            XSetWindowAttributes.nbackground_pixel(this.address(), l);
            return this;
        }

        public Buffer border_pixmap(@NativeType(value="Pixmap") long l) {
            XSetWindowAttributes.nborder_pixmap(this.address(), l);
            return this;
        }

        public Buffer border_pixel(@NativeType(value="unsigned long") long l) {
            XSetWindowAttributes.nborder_pixel(this.address(), l);
            return this;
        }

        public Buffer bit_gravity(int n) {
            XSetWindowAttributes.nbit_gravity(this.address(), n);
            return this;
        }

        public Buffer win_gravity(int n) {
            XSetWindowAttributes.nwin_gravity(this.address(), n);
            return this;
        }

        public Buffer backing_store(int n) {
            XSetWindowAttributes.nbacking_store(this.address(), n);
            return this;
        }

        public Buffer backing_planes(@NativeType(value="unsigned long") long l) {
            XSetWindowAttributes.nbacking_planes(this.address(), l);
            return this;
        }

        public Buffer backing_pixel(@NativeType(value="unsigned long") long l) {
            XSetWindowAttributes.nbacking_pixel(this.address(), l);
            return this;
        }

        public Buffer save_under(@NativeType(value="Bool") boolean bl) {
            XSetWindowAttributes.nsave_under(this.address(), bl ? 1 : 0);
            return this;
        }

        public Buffer event_mask(long l) {
            XSetWindowAttributes.nevent_mask(this.address(), l);
            return this;
        }

        public Buffer do_not_propagate_mask(long l) {
            XSetWindowAttributes.ndo_not_propagate_mask(this.address(), l);
            return this;
        }

        public Buffer override_redirect(@NativeType(value="Bool") boolean bl) {
            XSetWindowAttributes.noverride_redirect(this.address(), bl ? 1 : 0);
            return this;
        }

        public Buffer colormap(@NativeType(value="Colormap") long l) {
            XSetWindowAttributes.ncolormap(this.address(), l);
            return this;
        }

        public Buffer cursor(@NativeType(value="Cursor") long l) {
            XSetWindowAttributes.ncursor(this.address(), l);
            return this;
        }
    }
}


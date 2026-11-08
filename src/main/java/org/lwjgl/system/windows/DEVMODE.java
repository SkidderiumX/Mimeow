/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.windows;

import java.nio.ByteBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;
import org.lwjgl.system.windows.POINTL;

public class DEVMODE
extends Struct<DEVMODE>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int DMDEVICENAME;
    public static final int DMSPECVERSION;
    public static final int DMDRIVERVERSION;
    public static final int DMSIZE;
    public static final int DMDRIVEREXTRA;
    public static final int DMFIELDS;
    public static final int DMORIENTATION;
    public static final int DMPAPERSIZE;
    public static final int DMPAPERLENGTH;
    public static final int DMPAPERWIDTH;
    public static final int DMSCALE;
    public static final int DMCOPIES;
    public static final int DMDEFAULTSOURCE;
    public static final int DMPRINTQUALITY;
    public static final int DMPOSITION;
    public static final int DMDISPLAYORIENTATION;
    public static final int DMDISPLAYFIXEDOUTPUT;
    public static final int DMCOLOR;
    public static final int DMDUPLEX;
    public static final int DMYRESOLUTION;
    public static final int DMTTOPTION;
    public static final int DMCOLLATE;
    public static final int DMFORMNAME;
    public static final int DMLOGPIXELS;
    public static final int DMBITSPERPEL;
    public static final int DMPELSWIDTH;
    public static final int DMPELSHEIGHT;
    public static final int DMDISPLAYFLAGS;
    public static final int DMNUP;
    public static final int DMDISPLAYFREQUENCY;
    public static final int DMICMMETHOD;
    public static final int DMICMINTENT;
    public static final int DMMEDIATYPE;
    public static final int DMDITHERTYPE;
    public static final int DMRESERVED1;
    public static final int DMRESERVED2;
    public static final int DMPANNINGWIDTH;
    public static final int DMPANNINGHEIGHT;

    protected DEVMODE(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected DEVMODE create(long l, @Nullable ByteBuffer byteBuffer) {
        return new DEVMODE(l, byteBuffer);
    }

    public DEVMODE(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), DEVMODE.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="TCHAR[32]")
    public ByteBuffer dmDeviceName() {
        return DEVMODE.ndmDeviceName(this.address());
    }

    @NativeType(value="TCHAR[32]")
    public String dmDeviceNameString() {
        return DEVMODE.ndmDeviceNameString(this.address());
    }

    @NativeType(value="WORD")
    public short dmSpecVersion() {
        return DEVMODE.ndmSpecVersion(this.address());
    }

    @NativeType(value="WORD")
    public short dmDriverVersion() {
        return DEVMODE.ndmDriverVersion(this.address());
    }

    @NativeType(value="WORD")
    public short dmSize() {
        return DEVMODE.ndmSize(this.address());
    }

    @NativeType(value="WORD")
    public short dmDriverExtra() {
        return DEVMODE.ndmDriverExtra(this.address());
    }

    @NativeType(value="DWORD")
    public int dmFields() {
        return DEVMODE.ndmFields(this.address());
    }

    public short dmOrientation() {
        return DEVMODE.ndmOrientation(this.address());
    }

    public short dmPaperSize() {
        return DEVMODE.ndmPaperSize(this.address());
    }

    public short dmPaperLength() {
        return DEVMODE.ndmPaperLength(this.address());
    }

    public short dmPaperWidth() {
        return DEVMODE.ndmPaperWidth(this.address());
    }

    public short dmScale() {
        return DEVMODE.ndmScale(this.address());
    }

    public short dmCopies() {
        return DEVMODE.ndmCopies(this.address());
    }

    public short dmDefaultSource() {
        return DEVMODE.ndmDefaultSource(this.address());
    }

    public short dmPrintQuality() {
        return DEVMODE.ndmPrintQuality(this.address());
    }

    public POINTL dmPosition() {
        return DEVMODE.ndmPosition(this.address());
    }

    @NativeType(value="DWORD")
    public int dmDisplayOrientation() {
        return DEVMODE.ndmDisplayOrientation(this.address());
    }

    @NativeType(value="DWORD")
    public int dmDisplayFixedOutput() {
        return DEVMODE.ndmDisplayFixedOutput(this.address());
    }

    public short dmColor() {
        return DEVMODE.ndmColor(this.address());
    }

    public short dmDuplex() {
        return DEVMODE.ndmDuplex(this.address());
    }

    public short dmYResolution() {
        return DEVMODE.ndmYResolution(this.address());
    }

    public short dmTTOption() {
        return DEVMODE.ndmTTOption(this.address());
    }

    public short dmCollate() {
        return DEVMODE.ndmCollate(this.address());
    }

    @NativeType(value="TCHAR[32]")
    public ByteBuffer dmFormName() {
        return DEVMODE.ndmFormName(this.address());
    }

    @NativeType(value="TCHAR[32]")
    public String dmFormNameString() {
        return DEVMODE.ndmFormNameString(this.address());
    }

    @NativeType(value="WORD")
    public short dmLogPixels() {
        return DEVMODE.ndmLogPixels(this.address());
    }

    @NativeType(value="DWORD")
    public int dmBitsPerPel() {
        return DEVMODE.ndmBitsPerPel(this.address());
    }

    @NativeType(value="DWORD")
    public int dmPelsWidth() {
        return DEVMODE.ndmPelsWidth(this.address());
    }

    @NativeType(value="DWORD")
    public int dmPelsHeight() {
        return DEVMODE.ndmPelsHeight(this.address());
    }

    @NativeType(value="DWORD")
    public int dmDisplayFlags() {
        return DEVMODE.ndmDisplayFlags(this.address());
    }

    @NativeType(value="DWORD")
    public int dmNup() {
        return DEVMODE.ndmNup(this.address());
    }

    @NativeType(value="DWORD")
    public int dmDisplayFrequency() {
        return DEVMODE.ndmDisplayFrequency(this.address());
    }

    @NativeType(value="DWORD")
    public int dmICMMethod() {
        return DEVMODE.ndmICMMethod(this.address());
    }

    @NativeType(value="DWORD")
    public int dmICMIntent() {
        return DEVMODE.ndmICMIntent(this.address());
    }

    @NativeType(value="DWORD")
    public int dmMediaType() {
        return DEVMODE.ndmMediaType(this.address());
    }

    @NativeType(value="DWORD")
    public int dmDitherType() {
        return DEVMODE.ndmDitherType(this.address());
    }

    @NativeType(value="DWORD")
    public int dmReserved1() {
        return DEVMODE.ndmReserved1(this.address());
    }

    @NativeType(value="DWORD")
    public int dmReserved2() {
        return DEVMODE.ndmReserved2(this.address());
    }

    @NativeType(value="DWORD")
    public int dmPanningWidth() {
        return DEVMODE.ndmPanningWidth(this.address());
    }

    @NativeType(value="DWORD")
    public int dmPanningHeight() {
        return DEVMODE.ndmPanningHeight(this.address());
    }

    public DEVMODE dmSpecVersion(@NativeType(value="WORD") short s) {
        DEVMODE.ndmSpecVersion(this.address(), s);
        return this;
    }

    public DEVMODE dmSize(@NativeType(value="WORD") short s) {
        DEVMODE.ndmSize(this.address(), s);
        return this;
    }

    public DEVMODE dmDriverExtra(@NativeType(value="WORD") short s) {
        DEVMODE.ndmDriverExtra(this.address(), s);
        return this;
    }

    public DEVMODE set(DEVMODE dEVMODE) {
        MemoryUtil.memCopy(dEVMODE.address(), this.address(), SIZEOF);
        return this;
    }

    public static DEVMODE malloc() {
        return new DEVMODE(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static DEVMODE calloc() {
        return new DEVMODE(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static DEVMODE create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new DEVMODE(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static DEVMODE create(long l) {
        return new DEVMODE(l, null);
    }

    public static @Nullable DEVMODE createSafe(long l) {
        return l == 0L ? null : new DEVMODE(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(DEVMODE.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = DEVMODE.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static DEVMODE mallocStack() {
        return DEVMODE.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static DEVMODE callocStack() {
        return DEVMODE.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static DEVMODE mallocStack(MemoryStack memoryStack) {
        return DEVMODE.malloc(memoryStack);
    }

    @Deprecated
    public static DEVMODE callocStack(MemoryStack memoryStack) {
        return DEVMODE.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return DEVMODE.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return DEVMODE.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return DEVMODE.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return DEVMODE.calloc(n, memoryStack);
    }

    public static DEVMODE malloc(MemoryStack memoryStack) {
        return new DEVMODE(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static DEVMODE calloc(MemoryStack memoryStack) {
        return new DEVMODE(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static ByteBuffer ndmDeviceName(long l) {
        return MemoryUtil.memByteBuffer(l + (long)DMDEVICENAME, 64);
    }

    public static String ndmDeviceNameString(long l) {
        return MemoryUtil.memUTF16(l + (long)DMDEVICENAME);
    }

    public static short ndmSpecVersion(long l) {
        return MemoryUtil.memGetShort(l + (long)DMSPECVERSION);
    }

    public static short ndmDriverVersion(long l) {
        return MemoryUtil.memGetShort(l + (long)DMDRIVERVERSION);
    }

    public static short ndmSize(long l) {
        return MemoryUtil.memGetShort(l + (long)DMSIZE);
    }

    public static short ndmDriverExtra(long l) {
        return MemoryUtil.memGetShort(l + (long)DMDRIVEREXTRA);
    }

    public static int ndmFields(long l) {
        return MemoryUtil.memGetInt(l + (long)DMFIELDS);
    }

    public static short ndmOrientation(long l) {
        return MemoryUtil.memGetShort(l + (long)DMORIENTATION);
    }

    public static short ndmPaperSize(long l) {
        return MemoryUtil.memGetShort(l + (long)DMPAPERSIZE);
    }

    public static short ndmPaperLength(long l) {
        return MemoryUtil.memGetShort(l + (long)DMPAPERLENGTH);
    }

    public static short ndmPaperWidth(long l) {
        return MemoryUtil.memGetShort(l + (long)DMPAPERWIDTH);
    }

    public static short ndmScale(long l) {
        return MemoryUtil.memGetShort(l + (long)DMSCALE);
    }

    public static short ndmCopies(long l) {
        return MemoryUtil.memGetShort(l + (long)DMCOPIES);
    }

    public static short ndmDefaultSource(long l) {
        return MemoryUtil.memGetShort(l + (long)DMDEFAULTSOURCE);
    }

    public static short ndmPrintQuality(long l) {
        return MemoryUtil.memGetShort(l + (long)DMPRINTQUALITY);
    }

    public static POINTL ndmPosition(long l) {
        return POINTL.create(l + (long)DMPOSITION);
    }

    public static int ndmDisplayOrientation(long l) {
        return MemoryUtil.memGetInt(l + (long)DMDISPLAYORIENTATION);
    }

    public static int ndmDisplayFixedOutput(long l) {
        return MemoryUtil.memGetInt(l + (long)DMDISPLAYFIXEDOUTPUT);
    }

    public static short ndmColor(long l) {
        return MemoryUtil.memGetShort(l + (long)DMCOLOR);
    }

    public static short ndmDuplex(long l) {
        return MemoryUtil.memGetShort(l + (long)DMDUPLEX);
    }

    public static short ndmYResolution(long l) {
        return MemoryUtil.memGetShort(l + (long)DMYRESOLUTION);
    }

    public static short ndmTTOption(long l) {
        return MemoryUtil.memGetShort(l + (long)DMTTOPTION);
    }

    public static short ndmCollate(long l) {
        return MemoryUtil.memGetShort(l + (long)DMCOLLATE);
    }

    public static ByteBuffer ndmFormName(long l) {
        return MemoryUtil.memByteBuffer(l + (long)DMFORMNAME, 64);
    }

    public static String ndmFormNameString(long l) {
        return MemoryUtil.memUTF16(l + (long)DMFORMNAME);
    }

    public static short ndmLogPixels(long l) {
        return MemoryUtil.memGetShort(l + (long)DMLOGPIXELS);
    }

    public static int ndmBitsPerPel(long l) {
        return MemoryUtil.memGetInt(l + (long)DMBITSPERPEL);
    }

    public static int ndmPelsWidth(long l) {
        return MemoryUtil.memGetInt(l + (long)DMPELSWIDTH);
    }

    public static int ndmPelsHeight(long l) {
        return MemoryUtil.memGetInt(l + (long)DMPELSHEIGHT);
    }

    public static int ndmDisplayFlags(long l) {
        return MemoryUtil.memGetInt(l + (long)DMDISPLAYFLAGS);
    }

    public static int ndmNup(long l) {
        return MemoryUtil.memGetInt(l + (long)DMNUP);
    }

    public static int ndmDisplayFrequency(long l) {
        return MemoryUtil.memGetInt(l + (long)DMDISPLAYFREQUENCY);
    }

    public static int ndmICMMethod(long l) {
        return MemoryUtil.memGetInt(l + (long)DMICMMETHOD);
    }

    public static int ndmICMIntent(long l) {
        return MemoryUtil.memGetInt(l + (long)DMICMINTENT);
    }

    public static int ndmMediaType(long l) {
        return MemoryUtil.memGetInt(l + (long)DMMEDIATYPE);
    }

    public static int ndmDitherType(long l) {
        return MemoryUtil.memGetInt(l + (long)DMDITHERTYPE);
    }

    public static int ndmReserved1(long l) {
        return MemoryUtil.memGetInt(l + (long)DMRESERVED1);
    }

    public static int ndmReserved2(long l) {
        return MemoryUtil.memGetInt(l + (long)DMRESERVED2);
    }

    public static int ndmPanningWidth(long l) {
        return MemoryUtil.memGetInt(l + (long)DMPANNINGWIDTH);
    }

    public static int ndmPanningHeight(long l) {
        return MemoryUtil.memGetInt(l + (long)DMPANNINGHEIGHT);
    }

    public static void ndmSpecVersion(long l, short s) {
        MemoryUtil.memPutShort(l + (long)DMSPECVERSION, s);
    }

    public static void ndmSize(long l, short s) {
        MemoryUtil.memPutShort(l + (long)DMSIZE, s);
    }

    public static void ndmDriverExtra(long l, short s) {
        MemoryUtil.memPutShort(l + (long)DMDRIVEREXTRA, s);
    }

    static {
        Struct.Layout layout = DEVMODE.__struct(DEVMODE.__array(2, 32), DEVMODE.__member(2), DEVMODE.__member(2), DEVMODE.__member(2), DEVMODE.__member(2), DEVMODE.__member(4), DEVMODE.__union(DEVMODE.__struct(DEVMODE.__member(2), DEVMODE.__member(2), DEVMODE.__member(2), DEVMODE.__member(2), DEVMODE.__member(2), DEVMODE.__member(2), DEVMODE.__member(2), DEVMODE.__member(2)), DEVMODE.__struct(DEVMODE.__member(POINTL.SIZEOF, POINTL.ALIGNOF), DEVMODE.__member(4), DEVMODE.__member(4))), DEVMODE.__member(2), DEVMODE.__member(2), DEVMODE.__member(2), DEVMODE.__member(2), DEVMODE.__member(2), DEVMODE.__array(2, 32), DEVMODE.__member(2), DEVMODE.__member(4), DEVMODE.__member(4), DEVMODE.__member(4), DEVMODE.__union(DEVMODE.__member(4), DEVMODE.__member(4)), DEVMODE.__member(4), DEVMODE.__member(4), DEVMODE.__member(4), DEVMODE.__member(4), DEVMODE.__member(4), DEVMODE.__member(4), DEVMODE.__member(4), DEVMODE.__member(4), DEVMODE.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        DMDEVICENAME = layout.offsetof(0);
        DMSPECVERSION = layout.offsetof(1);
        DMDRIVERVERSION = layout.offsetof(2);
        DMSIZE = layout.offsetof(3);
        DMDRIVEREXTRA = layout.offsetof(4);
        DMFIELDS = layout.offsetof(5);
        DMORIENTATION = layout.offsetof(8);
        DMPAPERSIZE = layout.offsetof(9);
        DMPAPERLENGTH = layout.offsetof(10);
        DMPAPERWIDTH = layout.offsetof(11);
        DMSCALE = layout.offsetof(12);
        DMCOPIES = layout.offsetof(13);
        DMDEFAULTSOURCE = layout.offsetof(14);
        DMPRINTQUALITY = layout.offsetof(15);
        DMPOSITION = layout.offsetof(17);
        DMDISPLAYORIENTATION = layout.offsetof(18);
        DMDISPLAYFIXEDOUTPUT = layout.offsetof(19);
        DMCOLOR = layout.offsetof(20);
        DMDUPLEX = layout.offsetof(21);
        DMYRESOLUTION = layout.offsetof(22);
        DMTTOPTION = layout.offsetof(23);
        DMCOLLATE = layout.offsetof(24);
        DMFORMNAME = layout.offsetof(25);
        DMLOGPIXELS = layout.offsetof(26);
        DMBITSPERPEL = layout.offsetof(27);
        DMPELSWIDTH = layout.offsetof(28);
        DMPELSHEIGHT = layout.offsetof(29);
        DMDISPLAYFLAGS = layout.offsetof(31);
        DMNUP = layout.offsetof(32);
        DMDISPLAYFREQUENCY = layout.offsetof(33);
        DMICMMETHOD = layout.offsetof(34);
        DMICMINTENT = layout.offsetof(35);
        DMMEDIATYPE = layout.offsetof(36);
        DMDITHERTYPE = layout.offsetof(37);
        DMRESERVED1 = layout.offsetof(38);
        DMRESERVED2 = layout.offsetof(39);
        DMPANNINGWIDTH = layout.offsetof(40);
        DMPANNINGHEIGHT = layout.offsetof(41);
    }

    public static class Buffer
    extends StructBuffer<DEVMODE, Buffer>
    implements NativeResource {
        private static final DEVMODE ELEMENT_FACTORY = DEVMODE.create(-1L);

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
        protected DEVMODE getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="TCHAR[32]")
        public ByteBuffer dmDeviceName() {
            return DEVMODE.ndmDeviceName(this.address());
        }

        @NativeType(value="TCHAR[32]")
        public String dmDeviceNameString() {
            return DEVMODE.ndmDeviceNameString(this.address());
        }

        @NativeType(value="WORD")
        public short dmSpecVersion() {
            return DEVMODE.ndmSpecVersion(this.address());
        }

        @NativeType(value="WORD")
        public short dmDriverVersion() {
            return DEVMODE.ndmDriverVersion(this.address());
        }

        @NativeType(value="WORD")
        public short dmSize() {
            return DEVMODE.ndmSize(this.address());
        }

        @NativeType(value="WORD")
        public short dmDriverExtra() {
            return DEVMODE.ndmDriverExtra(this.address());
        }

        @NativeType(value="DWORD")
        public int dmFields() {
            return DEVMODE.ndmFields(this.address());
        }

        public short dmOrientation() {
            return DEVMODE.ndmOrientation(this.address());
        }

        public short dmPaperSize() {
            return DEVMODE.ndmPaperSize(this.address());
        }

        public short dmPaperLength() {
            return DEVMODE.ndmPaperLength(this.address());
        }

        public short dmPaperWidth() {
            return DEVMODE.ndmPaperWidth(this.address());
        }

        public short dmScale() {
            return DEVMODE.ndmScale(this.address());
        }

        public short dmCopies() {
            return DEVMODE.ndmCopies(this.address());
        }

        public short dmDefaultSource() {
            return DEVMODE.ndmDefaultSource(this.address());
        }

        public short dmPrintQuality() {
            return DEVMODE.ndmPrintQuality(this.address());
        }

        public POINTL dmPosition() {
            return DEVMODE.ndmPosition(this.address());
        }

        @NativeType(value="DWORD")
        public int dmDisplayOrientation() {
            return DEVMODE.ndmDisplayOrientation(this.address());
        }

        @NativeType(value="DWORD")
        public int dmDisplayFixedOutput() {
            return DEVMODE.ndmDisplayFixedOutput(this.address());
        }

        public short dmColor() {
            return DEVMODE.ndmColor(this.address());
        }

        public short dmDuplex() {
            return DEVMODE.ndmDuplex(this.address());
        }

        public short dmYResolution() {
            return DEVMODE.ndmYResolution(this.address());
        }

        public short dmTTOption() {
            return DEVMODE.ndmTTOption(this.address());
        }

        public short dmCollate() {
            return DEVMODE.ndmCollate(this.address());
        }

        @NativeType(value="TCHAR[32]")
        public ByteBuffer dmFormName() {
            return DEVMODE.ndmFormName(this.address());
        }

        @NativeType(value="TCHAR[32]")
        public String dmFormNameString() {
            return DEVMODE.ndmFormNameString(this.address());
        }

        @NativeType(value="WORD")
        public short dmLogPixels() {
            return DEVMODE.ndmLogPixels(this.address());
        }

        @NativeType(value="DWORD")
        public int dmBitsPerPel() {
            return DEVMODE.ndmBitsPerPel(this.address());
        }

        @NativeType(value="DWORD")
        public int dmPelsWidth() {
            return DEVMODE.ndmPelsWidth(this.address());
        }

        @NativeType(value="DWORD")
        public int dmPelsHeight() {
            return DEVMODE.ndmPelsHeight(this.address());
        }

        @NativeType(value="DWORD")
        public int dmDisplayFlags() {
            return DEVMODE.ndmDisplayFlags(this.address());
        }

        @NativeType(value="DWORD")
        public int dmNup() {
            return DEVMODE.ndmNup(this.address());
        }

        @NativeType(value="DWORD")
        public int dmDisplayFrequency() {
            return DEVMODE.ndmDisplayFrequency(this.address());
        }

        @NativeType(value="DWORD")
        public int dmICMMethod() {
            return DEVMODE.ndmICMMethod(this.address());
        }

        @NativeType(value="DWORD")
        public int dmICMIntent() {
            return DEVMODE.ndmICMIntent(this.address());
        }

        @NativeType(value="DWORD")
        public int dmMediaType() {
            return DEVMODE.ndmMediaType(this.address());
        }

        @NativeType(value="DWORD")
        public int dmDitherType() {
            return DEVMODE.ndmDitherType(this.address());
        }

        @NativeType(value="DWORD")
        public int dmReserved1() {
            return DEVMODE.ndmReserved1(this.address());
        }

        @NativeType(value="DWORD")
        public int dmReserved2() {
            return DEVMODE.ndmReserved2(this.address());
        }

        @NativeType(value="DWORD")
        public int dmPanningWidth() {
            return DEVMODE.ndmPanningWidth(this.address());
        }

        @NativeType(value="DWORD")
        public int dmPanningHeight() {
            return DEVMODE.ndmPanningHeight(this.address());
        }

        public Buffer dmSpecVersion(@NativeType(value="WORD") short s) {
            DEVMODE.ndmSpecVersion(this.address(), s);
            return this;
        }

        public Buffer dmSize(@NativeType(value="WORD") short s) {
            DEVMODE.ndmSize(this.address(), s);
            return this;
        }

        public Buffer dmDriverExtra(@NativeType(value="WORD") short s) {
            DEVMODE.ndmDriverExtra(this.address(), s);
            return this;
        }
    }
}


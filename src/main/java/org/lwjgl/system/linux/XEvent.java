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
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;
import org.lwjgl.system.linux.XAnyEvent;
import org.lwjgl.system.linux.XButtonEvent;
import org.lwjgl.system.linux.XCirculateEvent;
import org.lwjgl.system.linux.XCirculateRequestEvent;
import org.lwjgl.system.linux.XClientMessageEvent;
import org.lwjgl.system.linux.XColormapEvent;
import org.lwjgl.system.linux.XConfigureEvent;
import org.lwjgl.system.linux.XConfigureRequestEvent;
import org.lwjgl.system.linux.XCreateWindowEvent;
import org.lwjgl.system.linux.XCrossingEvent;
import org.lwjgl.system.linux.XDestroyWindowEvent;
import org.lwjgl.system.linux.XErrorEvent;
import org.lwjgl.system.linux.XExposeEvent;
import org.lwjgl.system.linux.XFocusChangeEvent;
import org.lwjgl.system.linux.XGenericEvent;
import org.lwjgl.system.linux.XGenericEventCookie;
import org.lwjgl.system.linux.XGraphicsExposeEvent;
import org.lwjgl.system.linux.XGravityEvent;
import org.lwjgl.system.linux.XKeyEvent;
import org.lwjgl.system.linux.XKeymapEvent;
import org.lwjgl.system.linux.XMapEvent;
import org.lwjgl.system.linux.XMapRequestEvent;
import org.lwjgl.system.linux.XMappingEvent;
import org.lwjgl.system.linux.XMotionEvent;
import org.lwjgl.system.linux.XNoExposeEvent;
import org.lwjgl.system.linux.XPropertyEvent;
import org.lwjgl.system.linux.XReparentEvent;
import org.lwjgl.system.linux.XResizeRequestEvent;
import org.lwjgl.system.linux.XSelectionClearEvent;
import org.lwjgl.system.linux.XSelectionEvent;
import org.lwjgl.system.linux.XSelectionRequestEvent;
import org.lwjgl.system.linux.XUnmapEvent;
import org.lwjgl.system.linux.XVisibilityEvent;

public class XEvent
extends Struct<XEvent>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int XANY;
    public static final int XKEY;
    public static final int XBUTTON;
    public static final int XMOTION;
    public static final int XCROSSING;
    public static final int XFOCUS;
    public static final int XEXPOSE;
    public static final int XGRAPHICSEXPOSE;
    public static final int XNOEXPOSE;
    public static final int XVISIBILITY;
    public static final int XCREATEWINDOW;
    public static final int XDESTROYWINDOW;
    public static final int XUNMAP;
    public static final int XMAP;
    public static final int XMAPREQUEST;
    public static final int XREPARENT;
    public static final int XCONFIGURE;
    public static final int XGRAVITY;
    public static final int XRESIZEREQUEST;
    public static final int XCONFIGUREREQUEST;
    public static final int XCIRCULATE;
    public static final int XCIRCULATEREQUEST;
    public static final int XPROPERTY;
    public static final int XSELECTIONCLEAR;
    public static final int XSELECTIONREQUEST;
    public static final int XSELECTION;
    public static final int XCOLORMAP;
    public static final int XCLIENT;
    public static final int XMAPPING;
    public static final int XERROR;
    public static final int XKEYMAP;
    public static final int XGENERIC;
    public static final int XCOOKIE;

    protected XEvent(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected XEvent create(long l, @Nullable ByteBuffer byteBuffer) {
        return new XEvent(l, byteBuffer);
    }

    public XEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XEvent.ntype(this.address());
    }

    public XAnyEvent xany() {
        return XEvent.nxany(this.address());
    }

    public XKeyEvent xkey() {
        return XEvent.nxkey(this.address());
    }

    public XButtonEvent xbutton() {
        return XEvent.nxbutton(this.address());
    }

    public XMotionEvent xmotion() {
        return XEvent.nxmotion(this.address());
    }

    public XCrossingEvent xcrossing() {
        return XEvent.nxcrossing(this.address());
    }

    public XFocusChangeEvent xfocus() {
        return XEvent.nxfocus(this.address());
    }

    public XExposeEvent xexpose() {
        return XEvent.nxexpose(this.address());
    }

    public XGraphicsExposeEvent xgraphicsexpose() {
        return XEvent.nxgraphicsexpose(this.address());
    }

    public XNoExposeEvent xnoexpose() {
        return XEvent.nxnoexpose(this.address());
    }

    public XVisibilityEvent xvisibility() {
        return XEvent.nxvisibility(this.address());
    }

    public XCreateWindowEvent xcreatewindow() {
        return XEvent.nxcreatewindow(this.address());
    }

    public XDestroyWindowEvent xdestroywindow() {
        return XEvent.nxdestroywindow(this.address());
    }

    public XUnmapEvent xunmap() {
        return XEvent.nxunmap(this.address());
    }

    public XMapEvent xmap() {
        return XEvent.nxmap(this.address());
    }

    public XMapRequestEvent xmaprequest() {
        return XEvent.nxmaprequest(this.address());
    }

    public XReparentEvent xreparent() {
        return XEvent.nxreparent(this.address());
    }

    public XConfigureEvent xconfigure() {
        return XEvent.nxconfigure(this.address());
    }

    public XGravityEvent xgravity() {
        return XEvent.nxgravity(this.address());
    }

    public XResizeRequestEvent xresizerequest() {
        return XEvent.nxresizerequest(this.address());
    }

    public XConfigureRequestEvent xconfigurerequest() {
        return XEvent.nxconfigurerequest(this.address());
    }

    public XCirculateEvent xcirculate() {
        return XEvent.nxcirculate(this.address());
    }

    public XCirculateRequestEvent xcirculaterequest() {
        return XEvent.nxcirculaterequest(this.address());
    }

    public XPropertyEvent xproperty() {
        return XEvent.nxproperty(this.address());
    }

    public XSelectionClearEvent xselectionclear() {
        return XEvent.nxselectionclear(this.address());
    }

    public XSelectionRequestEvent xselectionrequest() {
        return XEvent.nxselectionrequest(this.address());
    }

    public XSelectionEvent xselection() {
        return XEvent.nxselection(this.address());
    }

    public XColormapEvent xcolormap() {
        return XEvent.nxcolormap(this.address());
    }

    public XClientMessageEvent xclient() {
        return XEvent.nxclient(this.address());
    }

    public XMappingEvent xmapping() {
        return XEvent.nxmapping(this.address());
    }

    public XErrorEvent xerror() {
        return XEvent.nxerror(this.address());
    }

    public XKeymapEvent xkeymap() {
        return XEvent.nxkeymap(this.address());
    }

    public XGenericEvent xgeneric() {
        return XEvent.nxgeneric(this.address());
    }

    public XGenericEventCookie xcookie() {
        return XEvent.nxcookie(this.address());
    }

    public static XEvent malloc() {
        return new XEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XEvent calloc() {
        return new XEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new XEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XEvent create(long l) {
        return new XEvent(l, null);
    }

    public static @Nullable XEvent createSafe(long l) {
        return l == 0L ? null : new XEvent(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XEvent.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = XEvent.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static XEvent mallocStack() {
        return XEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XEvent callocStack() {
        return XEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XEvent mallocStack(MemoryStack memoryStack) {
        return XEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XEvent callocStack(MemoryStack memoryStack) {
        return XEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return XEvent.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return XEvent.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return XEvent.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return XEvent.calloc(n, memoryStack);
    }

    public static XEvent malloc(MemoryStack memoryStack) {
        return new XEvent(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XEvent calloc(MemoryStack memoryStack) {
        return new XEvent(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static int ntype(long l) {
        return MemoryUtil.memGetInt(l + (long)TYPE);
    }

    public static XAnyEvent nxany(long l) {
        return XAnyEvent.create(l + (long)XANY);
    }

    public static XKeyEvent nxkey(long l) {
        return XKeyEvent.create(l + (long)XKEY);
    }

    public static XButtonEvent nxbutton(long l) {
        return XButtonEvent.create(l + (long)XBUTTON);
    }

    public static XMotionEvent nxmotion(long l) {
        return XMotionEvent.create(l + (long)XMOTION);
    }

    public static XCrossingEvent nxcrossing(long l) {
        return XCrossingEvent.create(l + (long)XCROSSING);
    }

    public static XFocusChangeEvent nxfocus(long l) {
        return XFocusChangeEvent.create(l + (long)XFOCUS);
    }

    public static XExposeEvent nxexpose(long l) {
        return XExposeEvent.create(l + (long)XEXPOSE);
    }

    public static XGraphicsExposeEvent nxgraphicsexpose(long l) {
        return XGraphicsExposeEvent.create(l + (long)XGRAPHICSEXPOSE);
    }

    public static XNoExposeEvent nxnoexpose(long l) {
        return XNoExposeEvent.create(l + (long)XNOEXPOSE);
    }

    public static XVisibilityEvent nxvisibility(long l) {
        return XVisibilityEvent.create(l + (long)XVISIBILITY);
    }

    public static XCreateWindowEvent nxcreatewindow(long l) {
        return XCreateWindowEvent.create(l + (long)XCREATEWINDOW);
    }

    public static XDestroyWindowEvent nxdestroywindow(long l) {
        return XDestroyWindowEvent.create(l + (long)XDESTROYWINDOW);
    }

    public static XUnmapEvent nxunmap(long l) {
        return XUnmapEvent.create(l + (long)XUNMAP);
    }

    public static XMapEvent nxmap(long l) {
        return XMapEvent.create(l + (long)XMAP);
    }

    public static XMapRequestEvent nxmaprequest(long l) {
        return XMapRequestEvent.create(l + (long)XMAPREQUEST);
    }

    public static XReparentEvent nxreparent(long l) {
        return XReparentEvent.create(l + (long)XREPARENT);
    }

    public static XConfigureEvent nxconfigure(long l) {
        return XConfigureEvent.create(l + (long)XCONFIGURE);
    }

    public static XGravityEvent nxgravity(long l) {
        return XGravityEvent.create(l + (long)XGRAVITY);
    }

    public static XResizeRequestEvent nxresizerequest(long l) {
        return XResizeRequestEvent.create(l + (long)XRESIZEREQUEST);
    }

    public static XConfigureRequestEvent nxconfigurerequest(long l) {
        return XConfigureRequestEvent.create(l + (long)XCONFIGUREREQUEST);
    }

    public static XCirculateEvent nxcirculate(long l) {
        return XCirculateEvent.create(l + (long)XCIRCULATE);
    }

    public static XCirculateRequestEvent nxcirculaterequest(long l) {
        return XCirculateRequestEvent.create(l + (long)XCIRCULATEREQUEST);
    }

    public static XPropertyEvent nxproperty(long l) {
        return XPropertyEvent.create(l + (long)XPROPERTY);
    }

    public static XSelectionClearEvent nxselectionclear(long l) {
        return XSelectionClearEvent.create(l + (long)XSELECTIONCLEAR);
    }

    public static XSelectionRequestEvent nxselectionrequest(long l) {
        return XSelectionRequestEvent.create(l + (long)XSELECTIONREQUEST);
    }

    public static XSelectionEvent nxselection(long l) {
        return XSelectionEvent.create(l + (long)XSELECTION);
    }

    public static XColormapEvent nxcolormap(long l) {
        return XColormapEvent.create(l + (long)XCOLORMAP);
    }

    public static XClientMessageEvent nxclient(long l) {
        return XClientMessageEvent.create(l + (long)XCLIENT);
    }

    public static XMappingEvent nxmapping(long l) {
        return XMappingEvent.create(l + (long)XMAPPING);
    }

    public static XErrorEvent nxerror(long l) {
        return XErrorEvent.create(l + (long)XERROR);
    }

    public static XKeymapEvent nxkeymap(long l) {
        return XKeymapEvent.create(l + (long)XKEYMAP);
    }

    public static XGenericEvent nxgeneric(long l) {
        return XGenericEvent.create(l + (long)XGENERIC);
    }

    public static XGenericEventCookie nxcookie(long l) {
        return XGenericEventCookie.create(l + (long)XCOOKIE);
    }

    static {
        Struct.Layout layout = XEvent.__union(XEvent.__member(4), XEvent.__member(XAnyEvent.SIZEOF, XAnyEvent.ALIGNOF), XEvent.__member(XKeyEvent.SIZEOF, XKeyEvent.ALIGNOF), XEvent.__member(XButtonEvent.SIZEOF, XButtonEvent.ALIGNOF), XEvent.__member(XMotionEvent.SIZEOF, XMotionEvent.ALIGNOF), XEvent.__member(XCrossingEvent.SIZEOF, XCrossingEvent.ALIGNOF), XEvent.__member(XFocusChangeEvent.SIZEOF, XFocusChangeEvent.ALIGNOF), XEvent.__member(XExposeEvent.SIZEOF, XExposeEvent.ALIGNOF), XEvent.__member(XGraphicsExposeEvent.SIZEOF, XGraphicsExposeEvent.ALIGNOF), XEvent.__member(XNoExposeEvent.SIZEOF, XNoExposeEvent.ALIGNOF), XEvent.__member(XVisibilityEvent.SIZEOF, XVisibilityEvent.ALIGNOF), XEvent.__member(XCreateWindowEvent.SIZEOF, XCreateWindowEvent.ALIGNOF), XEvent.__member(XDestroyWindowEvent.SIZEOF, XDestroyWindowEvent.ALIGNOF), XEvent.__member(XUnmapEvent.SIZEOF, XUnmapEvent.ALIGNOF), XEvent.__member(XMapEvent.SIZEOF, XMapEvent.ALIGNOF), XEvent.__member(XMapRequestEvent.SIZEOF, XMapRequestEvent.ALIGNOF), XEvent.__member(XReparentEvent.SIZEOF, XReparentEvent.ALIGNOF), XEvent.__member(XConfigureEvent.SIZEOF, XConfigureEvent.ALIGNOF), XEvent.__member(XGravityEvent.SIZEOF, XGravityEvent.ALIGNOF), XEvent.__member(XResizeRequestEvent.SIZEOF, XResizeRequestEvent.ALIGNOF), XEvent.__member(XConfigureRequestEvent.SIZEOF, XConfigureRequestEvent.ALIGNOF), XEvent.__member(XCirculateEvent.SIZEOF, XCirculateEvent.ALIGNOF), XEvent.__member(XCirculateRequestEvent.SIZEOF, XCirculateRequestEvent.ALIGNOF), XEvent.__member(XPropertyEvent.SIZEOF, XPropertyEvent.ALIGNOF), XEvent.__member(XSelectionClearEvent.SIZEOF, XSelectionClearEvent.ALIGNOF), XEvent.__member(XSelectionRequestEvent.SIZEOF, XSelectionRequestEvent.ALIGNOF), XEvent.__member(XSelectionEvent.SIZEOF, XSelectionEvent.ALIGNOF), XEvent.__member(XColormapEvent.SIZEOF, XColormapEvent.ALIGNOF), XEvent.__member(XClientMessageEvent.SIZEOF, XClientMessageEvent.ALIGNOF), XEvent.__member(XMappingEvent.SIZEOF, XMappingEvent.ALIGNOF), XEvent.__member(XErrorEvent.SIZEOF, XErrorEvent.ALIGNOF), XEvent.__member(XKeymapEvent.SIZEOF, XKeymapEvent.ALIGNOF), XEvent.__member(XGenericEvent.SIZEOF, XGenericEvent.ALIGNOF), XEvent.__member(XGenericEventCookie.SIZEOF, XGenericEventCookie.ALIGNOF), XEvent.__padding(24, CLONG_SIZE, true));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        XANY = layout.offsetof(1);
        XKEY = layout.offsetof(2);
        XBUTTON = layout.offsetof(3);
        XMOTION = layout.offsetof(4);
        XCROSSING = layout.offsetof(5);
        XFOCUS = layout.offsetof(6);
        XEXPOSE = layout.offsetof(7);
        XGRAPHICSEXPOSE = layout.offsetof(8);
        XNOEXPOSE = layout.offsetof(9);
        XVISIBILITY = layout.offsetof(10);
        XCREATEWINDOW = layout.offsetof(11);
        XDESTROYWINDOW = layout.offsetof(12);
        XUNMAP = layout.offsetof(13);
        XMAP = layout.offsetof(14);
        XMAPREQUEST = layout.offsetof(15);
        XREPARENT = layout.offsetof(16);
        XCONFIGURE = layout.offsetof(17);
        XGRAVITY = layout.offsetof(18);
        XRESIZEREQUEST = layout.offsetof(19);
        XCONFIGUREREQUEST = layout.offsetof(20);
        XCIRCULATE = layout.offsetof(21);
        XCIRCULATEREQUEST = layout.offsetof(22);
        XPROPERTY = layout.offsetof(23);
        XSELECTIONCLEAR = layout.offsetof(24);
        XSELECTIONREQUEST = layout.offsetof(25);
        XSELECTION = layout.offsetof(26);
        XCOLORMAP = layout.offsetof(27);
        XCLIENT = layout.offsetof(28);
        XMAPPING = layout.offsetof(29);
        XERROR = layout.offsetof(30);
        XKEYMAP = layout.offsetof(31);
        XGENERIC = layout.offsetof(32);
        XCOOKIE = layout.offsetof(33);
    }

    public static class Buffer
    extends StructBuffer<XEvent, Buffer>
    implements NativeResource {
        private static final XEvent ELEMENT_FACTORY = XEvent.create(-1L);

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
        protected XEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XEvent.ntype(this.address());
        }

        public XAnyEvent xany() {
            return XEvent.nxany(this.address());
        }

        public XKeyEvent xkey() {
            return XEvent.nxkey(this.address());
        }

        public XButtonEvent xbutton() {
            return XEvent.nxbutton(this.address());
        }

        public XMotionEvent xmotion() {
            return XEvent.nxmotion(this.address());
        }

        public XCrossingEvent xcrossing() {
            return XEvent.nxcrossing(this.address());
        }

        public XFocusChangeEvent xfocus() {
            return XEvent.nxfocus(this.address());
        }

        public XExposeEvent xexpose() {
            return XEvent.nxexpose(this.address());
        }

        public XGraphicsExposeEvent xgraphicsexpose() {
            return XEvent.nxgraphicsexpose(this.address());
        }

        public XNoExposeEvent xnoexpose() {
            return XEvent.nxnoexpose(this.address());
        }

        public XVisibilityEvent xvisibility() {
            return XEvent.nxvisibility(this.address());
        }

        public XCreateWindowEvent xcreatewindow() {
            return XEvent.nxcreatewindow(this.address());
        }

        public XDestroyWindowEvent xdestroywindow() {
            return XEvent.nxdestroywindow(this.address());
        }

        public XUnmapEvent xunmap() {
            return XEvent.nxunmap(this.address());
        }

        public XMapEvent xmap() {
            return XEvent.nxmap(this.address());
        }

        public XMapRequestEvent xmaprequest() {
            return XEvent.nxmaprequest(this.address());
        }

        public XReparentEvent xreparent() {
            return XEvent.nxreparent(this.address());
        }

        public XConfigureEvent xconfigure() {
            return XEvent.nxconfigure(this.address());
        }

        public XGravityEvent xgravity() {
            return XEvent.nxgravity(this.address());
        }

        public XResizeRequestEvent xresizerequest() {
            return XEvent.nxresizerequest(this.address());
        }

        public XConfigureRequestEvent xconfigurerequest() {
            return XEvent.nxconfigurerequest(this.address());
        }

        public XCirculateEvent xcirculate() {
            return XEvent.nxcirculate(this.address());
        }

        public XCirculateRequestEvent xcirculaterequest() {
            return XEvent.nxcirculaterequest(this.address());
        }

        public XPropertyEvent xproperty() {
            return XEvent.nxproperty(this.address());
        }

        public XSelectionClearEvent xselectionclear() {
            return XEvent.nxselectionclear(this.address());
        }

        public XSelectionRequestEvent xselectionrequest() {
            return XEvent.nxselectionrequest(this.address());
        }

        public XSelectionEvent xselection() {
            return XEvent.nxselection(this.address());
        }

        public XColormapEvent xcolormap() {
            return XEvent.nxcolormap(this.address());
        }

        public XClientMessageEvent xclient() {
            return XEvent.nxclient(this.address());
        }

        public XMappingEvent xmapping() {
            return XEvent.nxmapping(this.address());
        }

        public XErrorEvent xerror() {
            return XEvent.nxerror(this.address());
        }

        public XKeymapEvent xkeymap() {
            return XEvent.nxkeymap(this.address());
        }

        public XGenericEvent xgeneric() {
            return XEvent.nxgeneric(this.address());
        }

        public XGenericEventCookie xcookie() {
            return XEvent.nxcookie(this.address());
        }
    }
}


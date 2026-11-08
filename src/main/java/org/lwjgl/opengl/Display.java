/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWFramebufferSizeCallback;
import org.lwjgl.glfw.GLFWImage;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.glfw.GLFWWindowFocusCallback;
import org.lwjgl.glfw.GLFWWindowIconifyCallback;
import org.lwjgl.glfw.GLFWWindowSizeCallback;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.PixelFormat;
import org.lwjgl.opengl.Sync;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.Pointer;
import x.oc2cf3d80e17;

public class Display {
    private static final DisplayMode initial_mode;
    private static final long window;
    private static DisplayMode current_mode;
    private static String title;
    private static boolean created;
    private static boolean resized;
    private static boolean focused;
    private static boolean vsync;
    private static boolean fullscreen;
    private static int windowedX;
    private static int windowedY;
    private static int windowedWidth;
    private static int windowedHeight;
    private static int windowWidth;
    private static int windowHeight;
    private static int framebufferWidth;
    private static int framebufferHeight;
    private static boolean visible;
    private static final GLFWErrorCallback errorCallback;
    private static GLFWWindowSizeCallback windowSizeCallback;
    private static GLFWFramebufferSizeCallback framebufferSizeCallback;
    private static GLFWWindowFocusCallback windowFocusCallback;
    private static GLFWWindowIconifyCallback windowIconifyCallback;

    public static DisplayMode getDisplayMode() {
        return current_mode;
    }

    public static void setDisplayMode(DisplayMode displayMode) {
        current_mode = displayMode;
        if (!fullscreen) {
            windowedWidth = displayMode.getWidth();
            windowedHeight = displayMode.getHeight();
            windowedX = (initial_mode.getWidth() - displayMode.getWidth()) / 2;
            windowedY = (initial_mode.getHeight() - displayMode.getHeight()) / 2;
            GLFW.glfwSetWindowSize(window, windowedWidth, windowedHeight);
            GLFW.glfwSetWindowPos(window, windowedX, windowedY);
            Display.refreshWindowMetrics();
            resized = true;
        }
    }

    public static void setFullscreen(boolean bl) {
        if (fullscreen == bl) {
            return;
        }
        fullscreen = bl;
        if (bl) {
            try (Pointer.Default default_ = MemoryStack.stackPush();){
                IntBuffer intBuffer = ((MemoryStack)default_).mallocInt(1);
                IntBuffer intBuffer2 = ((MemoryStack)default_).mallocInt(1);
                IntBuffer intBuffer3 = ((MemoryStack)default_).mallocInt(1);
                IntBuffer intBuffer4 = ((MemoryStack)default_).mallocInt(1);
                GLFW.glfwGetWindowPos(window, intBuffer, intBuffer2);
                GLFW.glfwGetWindowSize(window, intBuffer3, intBuffer4);
                windowedX = intBuffer.get(0);
                windowedY = intBuffer2.get(0);
                windowedWidth = intBuffer3.get(0);
                windowedHeight = intBuffer4.get(0);
            }
            default_ = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
            current_mode = new DisplayMode(((GLFWVidMode)default_).width(), ((GLFWVidMode)default_).height(), ((GLFWVidMode)default_).redBits() + ((GLFWVidMode)default_).greenBits() + ((GLFWVidMode)default_).blueBits(), ((GLFWVidMode)default_).refreshRate());
            GLFW.glfwSetWindowMonitor(window, GLFW.glfwGetPrimaryMonitor(), 0, 0, ((GLFWVidMode)default_).width(), ((GLFWVidMode)default_).height(), ((GLFWVidMode)default_).refreshRate());
        } else {
            current_mode = new DisplayMode(windowedWidth, windowedHeight);
            GLFW.glfwSetWindowMonitor(window, 0L, windowedX, windowedY, windowedWidth, windowedHeight, -1);
        }
        Display.refreshWindowMetrics();
        resized = true;
    }

    public static void setResizable(boolean bl) {
        GLFW.glfwSetWindowAttrib(window, 131075, bl ? 1 : 0);
    }

    public static void setTitle(String string) {
        title = string;
        GLFW.glfwSetWindowTitle(window, string);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static int setIcon(ByteBuffer[] byteBufferArray) {
        int n = Math.min(byteBufferArray.length, 2);
        GLFWImage.Buffer buffer = GLFWImage.malloc(n);
        ByteBuffer[] byteBufferArray2 = new ByteBuffer[n];
        try {
            for (int i = 0; i < n; ++i) {
                int n2 = i == 0 ? 16 : 32;
                ByteBuffer byteBuffer = byteBufferArray[i].duplicate();
                byteBufferArray2[i] = BufferUtils.createByteBuffer(byteBuffer.remaining());
                byteBufferArray2[i].put(byteBuffer).flip();
                ((GLFWImage)buffer.get(i)).set(n2, n2, byteBufferArray2[i]);
            }
            GLFW.glfwSetWindowIcon(window, buffer);
        }
        finally {
            buffer.free();
        }
        return n;
    }

    public static void setVSyncEnabled(boolean bl) {
        if (GLFW.glfwGetCurrentContext() != 0L) {
            GLFW.glfwSwapInterval(bl ? 1 : 0);
        }
        vsync = bl;
    }

    public static void destroy() {
        if (!created) {
            return;
        }
        try {
            if (oc2cf3d80e17.\u02e1 != null) {
                oc2cf3d80e17.\u02e1.\u051c();
            }
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        Mouse.destroy();
        Keyboard.destroy();
        GLFW.glfwSetWindowSizeCallback(window, null);
        GLFW.glfwSetFramebufferSizeCallback(window, null);
        GLFW.glfwSetWindowFocusCallback(window, null);
        GLFW.glfwSetWindowIconifyCallback(window, null);
        if (windowSizeCallback != null) {
            windowSizeCallback.free();
        }
        if (framebufferSizeCallback != null) {
            framebufferSizeCallback.free();
        }
        if (windowFocusCallback != null) {
            windowFocusCallback.free();
        }
        if (windowIconifyCallback != null) {
            windowIconifyCallback.free();
        }
        GLFW.glfwMakeContextCurrent(0L);
        GLFW.glfwDestroyWindow(window);
        GLFW.glfwTerminate();
        GLFW.glfwSetErrorCallback(null);
        errorCallback.free();
        created = false;
    }

    public static DisplayMode[] getAvailableDisplayModes() {
        GLFWVidMode.Buffer buffer = GLFW.glfwGetVideoModes(GLFW.glfwGetPrimaryMonitor());
        ArrayList<DisplayMode> arrayList = new ArrayList<DisplayMode>();
        while (buffer.hasRemaining()) {
            GLFWVidMode gLFWVidMode = (GLFWVidMode)buffer.get();
            int n = gLFWVidMode.redBits() + gLFWVidMode.greenBits() + gLFWVidMode.blueBits();
            arrayList.add(new DisplayMode(gLFWVidMode.width(), gLFWVidMode.height(), n, gLFWVidMode.refreshRate()));
        }
        return arrayList.toArray(new DisplayMode[arrayList.size()]);
    }

    public static DisplayMode getDesktopDisplayMode() {
        GLFWVidMode gLFWVidMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
        int n = gLFWVidMode.redBits() + gLFWVidMode.greenBits() + gLFWVidMode.blueBits();
        return new DisplayMode(gLFWVidMode.width(), gLFWVidMode.height(), n, gLFWVidMode.refreshRate());
    }

    public static boolean isCreated() {
        return created;
    }

    public static boolean isCloseRequested() {
        return GLFW.glfwWindowShouldClose(window);
    }

    public static void sync(int n) {
        Sync.sync(n);
    }

    public static void update() {
        if (!created) {
            return;
        }
        resized = false;
        if (visible && GLFW.glfwGetWindowAttrib(window, 131074) == 0) {
            GLFW.glfwSwapBuffers(window);
        }
        Mouse.poll_scrollY = 0;
        GLFW.glfwPollEvents();
        Mouse.poll();
    }

    public static boolean wasResized() {
        return resized;
    }

    public static int getWidth() {
        return framebufferWidth;
    }

    public static int getHeight() {
        return framebufferHeight;
    }

    public static boolean isActive() {
        return created ? GLFW.glfwGetWindowAttrib(window, 131073) == 1 : focused;
    }

    public static boolean isVisible() {
        return visible;
    }

    public static long getWindow() {
        return window;
    }

    public static int getWindowWidth() {
        return windowWidth;
    }

    public static int getWindowHeight() {
        return windowHeight;
    }

    private static void refreshWindowMetrics() {
        try (MemoryStack memoryStack = MemoryStack.stackPush();){
            IntBuffer intBuffer = memoryStack.mallocInt(1);
            IntBuffer intBuffer2 = memoryStack.mallocInt(1);
            GLFW.glfwGetWindowSize(window, intBuffer, intBuffer2);
            if (intBuffer.get(0) > 0 && intBuffer2.get(0) > 0) {
                windowWidth = intBuffer.get(0);
                windowHeight = intBuffer2.get(0);
            }
            intBuffer.clear();
            intBuffer2.clear();
            GLFW.glfwGetFramebufferSize(window, intBuffer, intBuffer2);
            if (intBuffer.get(0) > 0 && intBuffer2.get(0) > 0) {
                framebufferWidth = intBuffer.get(0);
                framebufferHeight = intBuffer2.get(0);
            }
        }
    }

    public static void releaseContext() {
        GLFW.glfwMakeContextCurrent(0L);
    }

    public static void create() throws LWJGLException {
        Display.create(new PixelFormat(), new ContextAttribs());
    }

    public static void create(PixelFormat pixelFormat) throws LWJGLException {
        Display.create(pixelFormat, new ContextAttribs());
    }

    public static void create(PixelFormat pixelFormat, ContextAttribs contextAttribs) throws LWJGLException {
        created = true;
        try (MemoryStack memoryStack = MemoryStack.stackPush();){
            IntBuffer intBuffer = memoryStack.mallocInt(1);
            IntBuffer intBuffer2 = memoryStack.mallocInt(1);
            GLFW.glfwGetWindowSize(window, intBuffer, intBuffer2);
            GLFW.glfwSetWindowPos(window, (initial_mode.getWidth() - intBuffer.get(0)) / 2, (initial_mode.getHeight() - intBuffer2.get(0)) / 2);
        }
        windowSizeCallback = new GLFWWindowSizeCallback(){

            @Override
            public void invoke(long l, int n, int n2) {
                if (n > 0 && n2 > 0) {
                    windowWidth = n;
                    windowHeight = n2;
                    if (!fullscreen) {
                        current_mode = new DisplayMode(n, n2);
                        windowedWidth = n;
                        windowedHeight = n2;
                    }
                }
                resized = true;
            }
        };
        framebufferSizeCallback = new GLFWFramebufferSizeCallback(){

            @Override
            public void invoke(long l, int n, int n2) {
                if (n > 0 && n2 > 0) {
                    framebufferWidth = n;
                    framebufferHeight = n2;
                }
                resized = true;
            }
        };
        windowFocusCallback = new GLFWWindowFocusCallback(){

            @Override
            public void invoke(long l, boolean bl) {
                focused = bl;
                Mouse.poll_xPos = Mouse.last_x;
                Mouse.poll_yPos = Mouse.last_y;
                if (!bl) {
                    Keyboard.releaseAllKeys();
                    Mouse.releaseAllButtons();
                }
            }
        };
        windowIconifyCallback = new GLFWWindowIconifyCallback(){

            @Override
            public void invoke(long l, boolean bl) {
                boolean bl2 = visible = !bl;
                if (bl) {
                    Keyboard.releaseAllKeys();
                    Mouse.releaseAllButtons();
                }
            }
        };
        GLFW.glfwSetWindowSizeCallback(window, windowSizeCallback);
        GLFW.glfwSetFramebufferSizeCallback(window, framebufferSizeCallback);
        GLFW.glfwSetWindowFocusCallback(window, windowFocusCallback);
        GLFW.glfwSetWindowIconifyCallback(window, windowIconifyCallback);
        Keyboard.create();
        Keyboard.pollGLFW();
        Mouse.create();
        Mouse.pollGLFW();
        boolean bl = focused = GLFW.glfwGetWindowAttrib(window, 131073) == 1;
        if (GLFW.glfwRawMouseMotionSupported()) {
            GLFW.glfwSetInputMode(window, 208901, 1);
        }
        Display.refreshWindowMetrics();
        GLFW.glfwSwapInterval(vsync ? 1 : 0);
        GLFW.glfwShowWindow(window);
        visible = true;
    }

    static {
        title = "Minecraft 1.8.9";
        windowWidth = 1;
        windowHeight = 1;
        framebufferWidth = 1;
        framebufferHeight = 1;
        errorCallback = GLFWErrorCallback.createPrint(System.err);
        GLFW.glfwSetErrorCallback(errorCallback);
        if (!GLFW.glfwInit()) {
            throw new RuntimeException("Failed to initialize GLFW");
        }
        GLFWVidMode gLFWVidMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
        int n = gLFWVidMode.redBits() + gLFWVidMode.greenBits() + gLFWVidMode.blueBits();
        current_mode = initial_mode = new DisplayMode(gLFWVidMode.width(), gLFWVidMode.height(), n, gLFWVidMode.refreshRate());
        windowedWidth = current_mode.getWidth();
        windowedHeight = current_mode.getHeight();
        GLFW.glfwDefaultWindowHints();
        GLFW.glfwWindowHint(131076, 0);
        GLFW.glfwWindowHint(131075, 1);
        GLFW.glfwWindowHint(131077, 1);
        window = GLFW.glfwCreateWindow(current_mode.getWidth(), current_mode.getHeight(), title, 0L, 0L);
        if (window == 0L) {
            throw new RuntimeException("Failed to create the GLFW window");
        }
        Display.refreshWindowMetrics();
        GLFW.glfwMakeContextCurrent(window);
        GL.createCapabilities();
    }
}


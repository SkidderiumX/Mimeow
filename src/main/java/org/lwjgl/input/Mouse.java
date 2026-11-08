/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.input;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.util.HashMap;
import java.util.Map;
import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorEnterCallback;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;
import org.lwjgl.glfw.GLFWScrollCallback;
import org.lwjgl.opengl.Display;

public class Mouse {
    private static boolean created;
    private static String[] buttonName;
    private static final Map<String, Integer> buttonMap;
    private static ByteBuffer readBuffer;
    private static ByteBuffer buttons;
    private static final int BUFFER_SIZE = 50;
    private static final int BUTTON_COUNT = 8;
    public static final int EVENT_SIZE = 25;
    private static MouseEvent current_Event;
    private static boolean isGrabbed;
    private static int last_event_raw_x;
    private static int last_event_raw_y;
    private static boolean clipMouseCoordinatesToWindow;
    private static int poll_button;
    private static int poll_action;
    public static int poll_xPos;
    public static int poll_yPos;
    public static int poll_scrollY;
    private static int current_dx;
    private static int current_dy;
    public static int last_x;
    public static int last_y;
    private static boolean poll_outside;
    private static int ignoreNextMove;
    private static GLFWMouseButtonCallback mouseButtonCallback;
    private static GLFWCursorPosCallback cursorPosCallback;
    private static GLFWScrollCallback scrollCallback;
    private static GLFWCursorEnterCallback cursorEnterCallback;
    private static final DoubleBuffer cursorXBuffer;
    private static final DoubleBuffer cursorYBuffer;

    public static void pollGLFW() {
        if (!created) {
            return;
        }
        mouseButtonCallback = new GLFWMouseButtonCallback(){

            @Override
            public void invoke(long l, int n, int n2, int n3) {
                Mouse.refreshCursorPosition(l, false);
                poll_button = n;
                poll_action = n2;
                if (n >= 0 && n < 8) {
                    buttons.put(n, (byte)n2);
                }
                Mouse.queueEvent(n, n2, poll_xPos, poll_yPos, 0);
            }
        };
        cursorPosCallback = new GLFWCursorPosCallback(){

            @Override
            public void invoke(long l, double d, double d2) {
                if (Display.isActive()) {
                    Mouse.updateCursorPosition(d, d2, true);
                }
            }
        };
        scrollCallback = new GLFWScrollCallback(){

            @Override
            public void invoke(long l, double d, double d2) {
                int n = (int)Math.round(d2 * 120.0);
                Mouse.addScrollEvent(n);
            }
        };
        cursorEnterCallback = new GLFWCursorEnterCallback(){

            @Override
            public void invoke(long l, boolean bl) {
                poll_outside = bl;
            }
        };
        GLFW.glfwSetMouseButtonCallback(Display.getWindow(), mouseButtonCallback);
        GLFW.glfwSetCursorPosCallback(Display.getWindow(), cursorPosCallback);
        GLFW.glfwSetScrollCallback(Display.getWindow(), scrollCallback);
        GLFW.glfwSetCursorEnterCallback(Display.getWindow(), cursorEnterCallback);
    }

    public static void createEvent() {
    }

    public static void create() {
        if (created) {
            return;
        }
        buttons = BufferUtils.createByteBuffer(8);
        readBuffer = ByteBuffer.allocate(1250);
        readBuffer.limit(0);
        clipMouseCoordinatesToWindow = true;
        created = true;
        buttonName = new String[8];
        for (int i = 0; i < 8; ++i) {
            Mouse.buttonName[i] = "BUTTON" + i;
            buttonMap.put(buttonName[i], i);
        }
    }

    public static void destroy() {
        if ((mouseButtonCallback != null || cursorPosCallback != null || scrollCallback != null || cursorEnterCallback != null) && Display.isCreated()) {
            GLFW.glfwSetMouseButtonCallback(Display.getWindow(), null);
            GLFW.glfwSetCursorPosCallback(Display.getWindow(), null);
            GLFW.glfwSetScrollCallback(Display.getWindow(), null);
            GLFW.glfwSetCursorEnterCallback(Display.getWindow(), null);
        }
        if (mouseButtonCallback != null) {
            mouseButtonCallback.free();
        }
        if (cursorPosCallback != null) {
            cursorPosCallback.free();
        }
        if (scrollCallback != null) {
            scrollCallback.free();
        }
        if (cursorEnterCallback != null) {
            cursorEnterCallback.free();
        }
        mouseButtonCallback = null;
        cursorPosCallback = null;
        scrollCallback = null;
        cursorEnterCallback = null;
        created = false;
        buttons = null;
        readBuffer = null;
        current_Event = null;
        current_dx = 0;
        current_dy = 0;
        poll_scrollY = 0;
    }

    public static void poll() {
        if (!created || !Display.isCreated()) {
            return;
        }
        Mouse.refreshCursorPosition(Display.getWindow(), true);
        Mouse.pollButtonStates(Display.getWindow());
    }

    public static boolean next() {
        if (!created) {
            throw new IllegalStateException("Mouse must be created before you can read events");
        }
        if (readBuffer.hasRemaining()) {
            MouseEvent mouseEvent = new MouseEvent();
            mouseEvent.eventButton = readBuffer.getInt();
            mouseEvent.eventState = readBuffer.get() != 0;
            int n = readBuffer.getInt();
            int n2 = readBuffer.getInt();
            mouseEvent.dx = n - last_event_raw_x;
            mouseEvent.dy = n2 - last_event_raw_y;
            mouseEvent.x = n;
            mouseEvent.y = n2;
            last_event_raw_x = n;
            last_event_raw_y = n2;
            if (clipMouseCoordinatesToWindow) {
                mouseEvent.x = Math.min(Display.getWidth() - 1, Math.max(0, mouseEvent.x));
                mouseEvent.y = Math.min(Display.getHeight() - 1, Math.max(0, mouseEvent.y));
            }
            mouseEvent.event_dwheel = readBuffer.getInt();
            mouseEvent.nanoseconds = readBuffer.getLong();
            current_Event = mouseEvent;
            return true;
        }
        return false;
    }

    public static int getButtonIndex(String string) {
        Integer n = buttonMap.get(string);
        if (n == null) {
            return -1;
        }
        return n;
    }

    public static String getButtonName(int n) {
        if (n >= buttonName.length || n < 0) {
            return null;
        }
        return buttonName[n];
    }

    public static boolean isInsideWindow() {
        return poll_outside;
    }

    public static int getEventButton() {
        return Mouse.current_Event.eventButton;
    }

    public static boolean getEventButtonState() {
        return Mouse.current_Event.eventState;
    }

    public static int getEventDWheel() {
        return Mouse.current_Event.event_dwheel;
    }

    public static int getEventX() {
        return Mouse.current_Event.x;
    }

    public static int getEventY() {
        return Mouse.current_Event.y;
    }

    public static int getEventDX() {
        return Mouse.current_Event.dx;
    }

    public static int getEventDY() {
        return Mouse.current_Event.dy;
    }

    public static long getEventNanoseconds() {
        return Mouse.current_Event.nanoseconds;
    }

    public static boolean isCreated() {
        return created;
    }

    public static int getX() {
        return Math.min(Math.max(poll_xPos, 0), Display.getWidth() - 1);
    }

    public static int getY() {
        return Math.min(Math.max(poll_yPos, 0), Display.getHeight() - 1);
    }

    public static void setClipMouseCoordinatesToWindow(boolean bl) {
        clipMouseCoordinatesToWindow = bl;
    }

    public static boolean isButtonDown(int n) {
        if (!created) {
            throw new IllegalStateException("Mouse must be created before you can poll the button state");
        }
        if (n >= 8 || n < 0) {
            return false;
        }
        return buttons.get(n) == 1;
    }

    public static boolean isGrabbed() {
        return isGrabbed;
    }

    public static void setGrabbed(boolean bl) {
        if (!created) {
            throw new IllegalStateException("Mouse must be created before you can poll the button state");
        }
        if (isGrabbed == bl) {
            return;
        }
        isGrabbed = bl;
        if (!bl) {
            GLFW.glfwSetInputMode(Display.getWindow(), 208897, 212993);
        } else {
            GLFW.glfwSetInputMode(Display.getWindow(), 208897, 212995);
        }
        ++ignoreNextMove;
        current_dx = 0;
        current_dy = 0;
    }

    public static void setCursorPosition(int n, int n2) {
        if (!Mouse.isCreated()) {
            throw new IllegalStateException("Mouse is not created");
        }
        poll_xPos = n;
        poll_yPos = n2;
        last_x = n;
        last_y = n2;
        last_event_raw_x = n;
        last_event_raw_y = n2;
        ++ignoreNextMove;
        if (current_Event != null) {
            Mouse.current_Event.x = n;
            Mouse.current_Event.y = n2;
        }
        Mouse.setNativeCursorPosition(n, n2);
    }

    public static int getDX() {
        int n = current_dx;
        current_dx = 0;
        return n;
    }

    public static int getDY() {
        int n = current_dy;
        current_dy = 0;
        return n;
    }

    private static int scaleToFramebuffer(double d, int n, int n2) {
        return (int)Math.round(d * (double)n2 / (double)Math.max(1, n));
    }

    private static void refreshCursorPosition(long l, boolean bl) {
        cursorXBuffer.clear();
        cursorYBuffer.clear();
        GLFW.glfwGetCursorPos(l, cursorXBuffer, cursorYBuffer);
        Mouse.updateCursorPosition(cursorXBuffer.get(0), cursorYBuffer.get(0), bl);
    }

    private static void updateCursorPosition(double d, double d2, boolean bl) {
        int n = Mouse.scaleToFramebuffer(d, Display.getWindowWidth(), Display.getWidth());
        int n2 = Display.getHeight() - Mouse.scaleToFramebuffer(d2, Display.getWindowHeight(), Display.getHeight());
        if (n == poll_xPos && n2 == poll_yPos) {
            return;
        }
        last_x = poll_xPos;
        last_y = poll_yPos;
        poll_xPos = n;
        poll_yPos = n2;
        if (ignoreNextMove > 0) {
            --ignoreNextMove;
            last_x = poll_xPos;
            last_y = poll_yPos;
        } else {
            current_dx += poll_xPos - last_x;
            current_dy += poll_yPos - last_y;
        }
        if (bl) {
            Mouse.addMoveEvent(poll_xPos, poll_yPos);
        }
    }

    private static void pollButtonStates(long l) {
        for (int i = 0; i < 8; ++i) {
            Mouse.updatePolledButtonState(i, GLFW.glfwGetMouseButton(l, i));
        }
    }

    static void updatePolledButtonState(int n, int n2) {
        int n3;
        if (!created || n < 0 || n >= 8) {
            return;
        }
        int n4 = n3 = n2 == 1 ? 1 : 0;
        if (buttons.get(n) == (byte)n3) {
            return;
        }
        poll_button = n;
        poll_action = n3;
        buttons.put(n, (byte)n3);
        Mouse.queueEvent(n, n3, poll_xPos, poll_yPos, 0);
    }

    private static void setNativeCursorPosition(int n, int n2) {
        double d = (double)n * (double)Display.getWindowWidth() / (double)Math.max(1, Display.getWidth());
        double d2 = (double)(Display.getHeight() - n2) * (double)Display.getWindowHeight() / (double)Math.max(1, Display.getHeight());
        GLFW.glfwSetCursorPos(Display.getWindow(), d, d2);
    }

    public static int getDWheel() {
        int n = poll_scrollY;
        poll_scrollY = 0;
        return n;
    }

    static void addButtonEvent(int n, boolean bl) {
        if (!created || n < 0 || n >= 8) {
            return;
        }
        poll_button = n;
        poll_action = bl ? 1 : 0;
        buttons.put(n, (byte)poll_action);
        Mouse.queueEvent(n, poll_action, poll_xPos, poll_yPos, 0);
    }

    static void addMoveEvent(int n, int n2) {
        Mouse.queueEvent(-1, 0, n, n2, 0);
    }

    static void addScrollEvent(int n) {
        if (!created || n == 0) {
            return;
        }
        poll_scrollY += n;
        Mouse.queueEvent(-1, 0, poll_xPos, poll_yPos, n);
    }

    public static void releaseAllButtons() {
        if (buttons == null) {
            return;
        }
        for (int i = 0; i < buttons.capacity(); ++i) {
            buttons.put(i, (byte)0);
        }
        current_dx = 0;
        current_dy = 0;
    }

    private static void queueEvent(int n, int n2, int n3, int n4, int n5) {
        if (!created) {
            return;
        }
        readBuffer.compact();
        if (n == -1 && n2 == 0 && n5 == 0 && Mouse.replaceLastMoveEvent(n3, n4)) {
            readBuffer.flip();
            poll_button = -1;
            poll_action = 0;
            return;
        }
        if (readBuffer.remaining() < 25) {
            readBuffer.flip();
            readBuffer.position(Math.min(25, readBuffer.limit()));
            readBuffer.compact();
        }
        readBuffer.putInt(n);
        readBuffer.put((byte)n2);
        readBuffer.putInt(n3);
        readBuffer.putInt(n4);
        readBuffer.putInt(n5);
        readBuffer.putLong(System.nanoTime());
        readBuffer.flip();
        poll_button = -1;
        poll_action = 0;
    }

    private static boolean replaceLastMoveEvent(int n, int n2) {
        int n3 = readBuffer.position();
        if (n3 < 25) {
            return false;
        }
        int n4 = n3 - 25;
        if (readBuffer.getInt(n4) != -1 || readBuffer.get(n4 + 4) != 0 || readBuffer.getInt(n4 + 13) != 0) {
            return false;
        }
        readBuffer.putInt(n4 + 5, n);
        readBuffer.putInt(n4 + 9, n2);
        readBuffer.putLong(n4 + 17, System.nanoTime());
        return true;
    }

    static {
        buttonMap = new HashMap<String, Integer>(8);
        poll_button = 0;
        poll_action = 0;
        poll_xPos = 0;
        poll_yPos = 0;
        poll_scrollY = 0;
        current_dx = 0;
        current_dy = 0;
        last_x = 0;
        last_y = 0;
        cursorXBuffer = BufferUtils.createDoubleBuffer(1);
        cursorYBuffer = BufferUtils.createDoubleBuffer(1);
    }

    private static final class MouseEvent {
        private int eventButton;
        private boolean eventState;
        private int dx;
        private int dy;
        private int x;
        private int y;
        private int event_dwheel;
        private long nanoseconds;

        private MouseEvent() {
        }
    }
}


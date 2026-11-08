/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.input;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCharCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.opengl.Display;

public class Keyboard {
    public static final int KEY_NONE = 0;
    public static final int KEY_ESCAPE = 1;
    public static final int KEY_1 = 2;
    public static final int KEY_2 = 3;
    public static final int KEY_3 = 4;
    public static final int KEY_4 = 5;
    public static final int KEY_5 = 6;
    public static final int KEY_6 = 7;
    public static final int KEY_7 = 8;
    public static final int KEY_8 = 9;
    public static final int KEY_9 = 10;
    public static final int KEY_0 = 11;
    public static final int KEY_MINUS = 12;
    public static final int KEY_EQUALS = 13;
    public static final int KEY_BACK = 14;
    public static final int KEY_TAB = 15;
    public static final int KEY_Q = 16;
    public static final int KEY_W = 17;
    public static final int KEY_E = 18;
    public static final int KEY_R = 19;
    public static final int KEY_T = 20;
    public static final int KEY_Y = 21;
    public static final int KEY_U = 22;
    public static final int KEY_I = 23;
    public static final int KEY_O = 24;
    public static final int KEY_P = 25;
    public static final int KEY_LBRACKET = 26;
    public static final int KEY_RBRACKET = 27;
    public static final int KEY_RETURN = 28;
    public static final int KEY_LCONTROL = 29;
    public static final int KEY_A = 30;
    public static final int KEY_S = 31;
    public static final int KEY_D = 32;
    public static final int KEY_F = 33;
    public static final int KEY_G = 34;
    public static final int KEY_H = 35;
    public static final int KEY_J = 36;
    public static final int KEY_K = 37;
    public static final int KEY_L = 38;
    public static final int KEY_SEMICOLON = 39;
    public static final int KEY_APOSTROPHE = 40;
    public static final int KEY_GRAVE = 41;
    public static final int KEY_LSHIFT = 42;
    public static final int KEY_BACKSLASH = 43;
    public static final int KEY_Z = 44;
    public static final int KEY_X = 45;
    public static final int KEY_C = 46;
    public static final int KEY_V = 47;
    public static final int KEY_B = 48;
    public static final int KEY_N = 49;
    public static final int KEY_M = 50;
    public static final int KEY_COMMA = 51;
    public static final int KEY_PERIOD = 52;
    public static final int KEY_SLASH = 53;
    public static final int KEY_RSHIFT = 54;
    public static final int KEY_MULTIPLY = 55;
    public static final int KEY_LMENU = 56;
    public static final int KEY_SPACE = 57;
    public static final int KEY_CAPITAL = 58;
    public static final int KEY_F1 = 59;
    public static final int KEY_F2 = 60;
    public static final int KEY_F3 = 61;
    public static final int KEY_F4 = 62;
    public static final int KEY_F5 = 63;
    public static final int KEY_F6 = 64;
    public static final int KEY_F7 = 65;
    public static final int KEY_F8 = 66;
    public static final int KEY_F9 = 67;
    public static final int KEY_F10 = 68;
    public static final int KEY_NUMLOCK = 69;
    public static final int KEY_SCROLL = 70;
    public static final int KEY_NUMPAD7 = 71;
    public static final int KEY_NUMPAD8 = 72;
    public static final int KEY_NUMPAD9 = 73;
    public static final int KEY_SUBTRACT = 74;
    public static final int KEY_NUMPAD4 = 75;
    public static final int KEY_NUMPAD5 = 76;
    public static final int KEY_NUMPAD6 = 77;
    public static final int KEY_ADD = 78;
    public static final int KEY_NUMPAD1 = 79;
    public static final int KEY_NUMPAD2 = 80;
    public static final int KEY_NUMPAD3 = 81;
    public static final int KEY_NUMPAD0 = 82;
    public static final int KEY_DECIMAL = 83;
    public static final int KEY_F11 = 87;
    public static final int KEY_F12 = 88;
    public static final int KEY_F13 = 100;
    public static final int KEY_F14 = 101;
    public static final int KEY_F15 = 102;
    public static final int KEY_F16 = 103;
    public static final int KEY_F17 = 104;
    public static final int KEY_F18 = 105;
    public static final int KEY_KANA = 112;
    public static final int KEY_F19 = 113;
    public static final int KEY_CONVERT = 121;
    public static final int KEY_NOCONVERT = 123;
    public static final int KEY_YEN = 125;
    public static final int KEY_NUMPADEQUALS = 141;
    public static final int KEY_CIRCUMFLEX = 144;
    public static final int KEY_AT = 145;
    public static final int KEY_COLON = 146;
    public static final int KEY_UNDERLINE = 147;
    public static final int KEY_KANJI = 148;
    public static final int KEY_STOP = 149;
    public static final int KEY_AX = 150;
    public static final int KEY_UNLABELED = 151;
    public static final int KEY_NUMPADENTER = 156;
    public static final int KEY_RCONTROL = 157;
    public static final int KEY_SECTION = 167;
    public static final int KEY_NUMPADCOMMA = 179;
    public static final int KEY_DIVIDE = 181;
    public static final int KEY_SYSRQ = 183;
    public static final int KEY_RMENU = 184;
    public static final int KEY_FUNCTION = 196;
    public static final int KEY_PAUSE = 197;
    public static final int KEY_HOME = 199;
    public static final int KEY_UP = 200;
    public static final int KEY_PRIOR = 201;
    public static final int KEY_LEFT = 203;
    public static final int KEY_RIGHT = 205;
    public static final int KEY_END = 207;
    public static final int KEY_DOWN = 208;
    public static final int KEY_NEXT = 209;
    public static final int KEY_INSERT = 210;
    public static final int KEY_DELETE = 211;
    public static final int KEY_CLEAR = 218;
    public static final int KEY_LMETA = 219;
    public static final int KEY_LWIN = 219;
    public static final int KEY_RMETA = 220;
    public static final int KEY_RWIN = 220;
    public static final int KEY_APPS = 221;
    public static final int KEY_POWER = 222;
    public static final int KEY_SLEEP = 223;
    public static final int KEYBOARD_SIZE = 256;
    public static final ByteBuffer keyDownBuffer = BufferUtils.createByteBuffer(256);
    private static final int BUFFER_SIZE = 50;
    private static final int STORED_EVENT_SIZE = 8;
    public static final int EVENT_SIZE = 18;
    private static ByteBuffer readBuffer;
    private static boolean created;
    private static boolean repeat_enabled;
    private static final String[] keyName;
    private static final Map<String, Integer> keyMap;
    private static final Map<Integer, Integer> glfwKeys;
    private static int counter;
    private static GLFWCharCallback charCallback;
    private static GLFWKeyCallback keyCallback;
    private static final KeyEvent current_event;

    public static int getKeyCount() {
        return counter;
    }

    public static String getKeyName(int n) {
        return n >= 0 && n < keyName.length ? keyName[n] : null;
    }

    public static int getKeyIndex(String string) {
        Integer n = keyMap.get(string);
        if (n == null) {
            return 0;
        }
        return n;
    }

    public static void create() {
        if (created) {
            return;
        }
        Keyboard.createGLFWKeyMap();
        created = true;
        repeat_enabled = false;
        readBuffer = ByteBuffer.allocate(400);
        Keyboard.reset();
    }

    public static void destroy() {
        if (!created) {
            return;
        }
        if ((charCallback != null || keyCallback != null) && Display.isCreated()) {
            GLFW.glfwSetCharCallback(Display.getWindow(), null);
            GLFW.glfwSetKeyCallback(Display.getWindow(), null);
        }
        if (charCallback != null) {
            charCallback.free();
            charCallback = null;
        }
        if (keyCallback != null) {
            keyCallback.free();
            keyCallback = null;
        }
        created = false;
        Keyboard.reset();
    }

    public static boolean next() {
        boolean bl;
        if (!created) {
            throw new IllegalStateException("Keyboard must be created before you can read events");
        }
        while ((bl = Keyboard.readNext(current_event)) && Keyboard.current_event.repeat && !repeat_enabled) {
        }
        return bl;
    }

    private static boolean readNext(KeyEvent keyEvent) {
        if (readBuffer.hasRemaining()) {
            keyEvent.key = readBuffer.getInt() & 0xFF;
            keyEvent.state = readBuffer.get() != 0;
            keyEvent.character = readBuffer.getChar();
            keyEvent.repeat = readBuffer.get() == 1;
            return true;
        }
        return false;
    }

    public static void enableRepeatEvents(boolean bl) {
        repeat_enabled = bl;
    }

    public static int getEventKey() {
        return Keyboard.current_event.key;
    }

    public static boolean getEventKeyState() {
        return Keyboard.current_event.state;
    }

    public static char getEventCharacter() {
        return (char)Keyboard.current_event.character;
    }

    public static boolean isRepeatEvent() {
        return Keyboard.current_event.repeat;
    }

    public static boolean isCreated() {
        return created;
    }

    public static boolean isKeyDown(int n) {
        if (!created) {
            throw new IllegalStateException("Keyboard must be created before you can query key state");
        }
        if (n < 0 || n >= 256) {
            return false;
        }
        return keyDownBuffer.get(n) != 0;
    }

    public static void reset() {
        readBuffer.limit(0);
        for (int i = 0; i < keyDownBuffer.remaining(); ++i) {
            keyDownBuffer.put(i, (byte)0);
        }
        current_event.reset();
    }

    public static void pollGLFW() {
        charCallback = new GLFWCharCallback(){

            @Override
            public void invoke(long l, int n) {
                Keyboard.parseGLFWCodes(0, 1, n);
            }
        };
        keyCallback = new GLFWKeyCallback(){

            @Override
            public void invoke(long l, int n, int n2, int n3, int n4) {
                if (!repeat_enabled && n3 == 2) {
                    return;
                }
                Integer n5 = glfwKeys.get(n);
                int n6 = n5 == null ? 0 : n5;
                Keyboard.parseGLFWCodes(n6, n3, 0);
                keyDownBuffer.compact();
                keyDownBuffer.put(n6, (byte)(n3 == 2 || n3 == 1 ? 1 : 0));
                keyDownBuffer.flip();
            }
        };
        GLFW.glfwSetCharCallback(Display.getWindow(), charCallback);
        GLFW.glfwSetKeyCallback(Display.getWindow(), keyCallback);
    }

    public static void parseGLFWCodes(int n, int n2, int n3) {
        readBuffer.compact();
        if (readBuffer.remaining() < 8) {
            readBuffer.flip();
            readBuffer.position(Math.min(8, readBuffer.limit()));
            readBuffer.compact();
        }
        readBuffer.putInt(n);
        readBuffer.put((byte)(n2 == 2 || n2 == 1 ? 1 : 0));
        readBuffer.putChar((char)n3);
        readBuffer.put((byte)(n2 == 2 ? 1 : 0));
        readBuffer.flip();
    }

    public static void releaseAllKeys() {
        for (int i = 0; i < keyDownBuffer.capacity(); ++i) {
            keyDownBuffer.put(i, (byte)0);
        }
    }

    private static void createGLFWKeyMap() {
        glfwKeys.put(-1, 0);
        glfwKeys.put(32, 57);
        glfwKeys.put(39, 40);
        glfwKeys.put(44, 51);
        glfwKeys.put(45, 12);
        glfwKeys.put(46, 52);
        glfwKeys.put(47, 53);
        glfwKeys.put(48, 11);
        glfwKeys.put(49, 2);
        glfwKeys.put(50, 3);
        glfwKeys.put(51, 4);
        glfwKeys.put(52, 5);
        glfwKeys.put(53, 6);
        glfwKeys.put(54, 7);
        glfwKeys.put(55, 8);
        glfwKeys.put(56, 9);
        glfwKeys.put(57, 10);
        glfwKeys.put(59, 39);
        glfwKeys.put(61, 13);
        glfwKeys.put(65, 30);
        glfwKeys.put(66, 48);
        glfwKeys.put(67, 46);
        glfwKeys.put(68, 32);
        glfwKeys.put(69, 18);
        glfwKeys.put(70, 33);
        glfwKeys.put(71, 34);
        glfwKeys.put(72, 35);
        glfwKeys.put(73, 23);
        glfwKeys.put(74, 36);
        glfwKeys.put(75, 37);
        glfwKeys.put(76, 38);
        glfwKeys.put(77, 50);
        glfwKeys.put(78, 49);
        glfwKeys.put(79, 24);
        glfwKeys.put(80, 25);
        glfwKeys.put(81, 16);
        glfwKeys.put(82, 19);
        glfwKeys.put(83, 31);
        glfwKeys.put(84, 20);
        glfwKeys.put(85, 22);
        glfwKeys.put(86, 47);
        glfwKeys.put(87, 17);
        glfwKeys.put(88, 45);
        glfwKeys.put(89, 21);
        glfwKeys.put(90, 44);
        glfwKeys.put(91, 26);
        glfwKeys.put(92, 43);
        glfwKeys.put(93, 27);
        glfwKeys.put(96, 41);
        glfwKeys.put(256, 1);
        glfwKeys.put(257, 28);
        glfwKeys.put(258, 15);
        glfwKeys.put(259, 14);
        glfwKeys.put(260, 210);
        glfwKeys.put(261, 211);
        glfwKeys.put(262, 205);
        glfwKeys.put(263, 203);
        glfwKeys.put(264, 208);
        glfwKeys.put(265, 200);
        glfwKeys.put(266, 201);
        glfwKeys.put(267, 209);
        glfwKeys.put(268, 199);
        glfwKeys.put(269, 207);
        glfwKeys.put(280, 58);
        glfwKeys.put(281, 70);
        glfwKeys.put(282, 69);
        glfwKeys.put(283, 183);
        glfwKeys.put(284, 197);
        glfwKeys.put(290, 59);
        glfwKeys.put(291, 60);
        glfwKeys.put(292, 61);
        glfwKeys.put(293, 62);
        glfwKeys.put(294, 63);
        glfwKeys.put(295, 64);
        glfwKeys.put(296, 65);
        glfwKeys.put(297, 66);
        glfwKeys.put(298, 67);
        glfwKeys.put(299, 68);
        glfwKeys.put(300, 87);
        glfwKeys.put(301, 88);
        glfwKeys.put(302, 100);
        glfwKeys.put(303, 101);
        glfwKeys.put(304, 102);
        glfwKeys.put(305, 103);
        glfwKeys.put(306, 104);
        glfwKeys.put(307, 105);
        glfwKeys.put(308, 113);
        glfwKeys.put(320, 82);
        glfwKeys.put(321, 79);
        glfwKeys.put(322, 80);
        glfwKeys.put(323, 81);
        glfwKeys.put(324, 75);
        glfwKeys.put(325, 76);
        glfwKeys.put(326, 77);
        glfwKeys.put(327, 71);
        glfwKeys.put(328, 72);
        glfwKeys.put(329, 73);
        glfwKeys.put(330, 83);
        glfwKeys.put(331, 181);
        glfwKeys.put(332, 55);
        glfwKeys.put(333, 74);
        glfwKeys.put(334, 78);
        glfwKeys.put(335, 156);
        glfwKeys.put(336, 141);
        glfwKeys.put(340, 42);
        glfwKeys.put(341, 29);
        glfwKeys.put(342, 56);
        glfwKeys.put(343, 219);
        glfwKeys.put(344, 54);
        glfwKeys.put(345, 157);
        glfwKeys.put(346, 184);
        glfwKeys.put(347, 220);
        glfwKeys.put(348, 221);
    }

    static {
        keyName = new String[256];
        keyMap = new HashMap<String, Integer>(256);
        glfwKeys = new HashMap<Integer, Integer>(348);
        current_event = new KeyEvent();
        Field[] fieldArray = Keyboard.class.getFields();
        try {
            for (Field field : fieldArray) {
                String string;
                if (!Modifier.isStatic(field.getModifiers()) || !Modifier.isPublic(field.getModifiers()) || !Modifier.isFinal(field.getModifiers()) || !field.getType().equals(Integer.TYPE) || !field.getName().startsWith("KEY_") || field.getName().endsWith("WIN")) continue;
                int n = field.getInt(null);
                Keyboard.keyName[n] = string = field.getName().substring(4);
                keyMap.put(string, n);
                ++counter;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private static final class KeyEvent {
        private int character;
        private int key;
        private boolean state;
        private boolean repeat;

        private KeyEvent() {
        }

        private void reset() {
            this.character = 0;
            this.key = 0;
            this.state = false;
            this.repeat = false;
        }
    }
}


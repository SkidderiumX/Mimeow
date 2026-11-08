/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.glfw;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.glfw.EventLoop;
import org.lwjgl.glfw.GLFWAllocator;
import org.lwjgl.glfw.GLFWCharCallback;
import org.lwjgl.glfw.GLFWCharCallbackI;
import org.lwjgl.glfw.GLFWCharModsCallback;
import org.lwjgl.glfw.GLFWCharModsCallbackI;
import org.lwjgl.glfw.GLFWCursorEnterCallback;
import org.lwjgl.glfw.GLFWCursorEnterCallbackI;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWCursorPosCallbackI;
import org.lwjgl.glfw.GLFWDropCallback;
import org.lwjgl.glfw.GLFWDropCallbackI;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWErrorCallbackI;
import org.lwjgl.glfw.GLFWFramebufferSizeCallback;
import org.lwjgl.glfw.GLFWFramebufferSizeCallbackI;
import org.lwjgl.glfw.GLFWGamepadState;
import org.lwjgl.glfw.GLFWGammaRamp;
import org.lwjgl.glfw.GLFWIMEStatusCallback;
import org.lwjgl.glfw.GLFWIMEStatusCallbackI;
import org.lwjgl.glfw.GLFWImage;
import org.lwjgl.glfw.GLFWJoystickCallback;
import org.lwjgl.glfw.GLFWJoystickCallbackI;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWKeyCallbackI;
import org.lwjgl.glfw.GLFWMonitorCallback;
import org.lwjgl.glfw.GLFWMonitorCallbackI;
import org.lwjgl.glfw.GLFWMouseButtonCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallbackI;
import org.lwjgl.glfw.GLFWPreeditCallback;
import org.lwjgl.glfw.GLFWPreeditCallbackI;
import org.lwjgl.glfw.GLFWPreeditCandidateCallback;
import org.lwjgl.glfw.GLFWPreeditCandidateCallbackI;
import org.lwjgl.glfw.GLFWScrollCallback;
import org.lwjgl.glfw.GLFWScrollCallbackI;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.glfw.GLFWWindowCloseCallback;
import org.lwjgl.glfw.GLFWWindowCloseCallbackI;
import org.lwjgl.glfw.GLFWWindowContentScaleCallback;
import org.lwjgl.glfw.GLFWWindowContentScaleCallbackI;
import org.lwjgl.glfw.GLFWWindowFocusCallback;
import org.lwjgl.glfw.GLFWWindowFocusCallbackI;
import org.lwjgl.glfw.GLFWWindowIconifyCallback;
import org.lwjgl.glfw.GLFWWindowIconifyCallbackI;
import org.lwjgl.glfw.GLFWWindowMaximizeCallback;
import org.lwjgl.glfw.GLFWWindowMaximizeCallbackI;
import org.lwjgl.glfw.GLFWWindowPosCallback;
import org.lwjgl.glfw.GLFWWindowPosCallbackI;
import org.lwjgl.glfw.GLFWWindowRefreshCallback;
import org.lwjgl.glfw.GLFWWindowRefreshCallbackI;
import org.lwjgl.glfw.GLFWWindowSizeCallback;
import org.lwjgl.glfw.GLFWWindowSizeCallbackI;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.JNI;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Platform;
import org.lwjgl.system.SharedLibrary;
import org.lwjgl.system.Struct;

public class GLFW {
    private static final SharedLibrary GLFW = Library.loadNative(GLFW.class, "org.lwjgl.glfw", Configuration.GLFW_LIBRARY_NAME.get(Platform.mapLibraryNameBundled("glfw")), true);
    public static final int GLFW_VERSION_MAJOR = 3;
    public static final int GLFW_VERSION_MINOR = 4;
    public static final int GLFW_VERSION_REVISION = 0;
    public static final int GLFW_TRUE = 1;
    public static final int GLFW_FALSE = 0;
    public static final int GLFW_RELEASE = 0;
    public static final int GLFW_PRESS = 1;
    public static final int GLFW_REPEAT = 2;
    public static final int GLFW_HAT_CENTERED = 0;
    public static final int GLFW_HAT_UP = 1;
    public static final int GLFW_HAT_RIGHT = 2;
    public static final int GLFW_HAT_DOWN = 4;
    public static final int GLFW_HAT_LEFT = 8;
    public static final int GLFW_HAT_RIGHT_UP = 3;
    public static final int GLFW_HAT_RIGHT_DOWN = 6;
    public static final int GLFW_HAT_LEFT_UP = 9;
    public static final int GLFW_HAT_LEFT_DOWN = 12;
    public static final int GLFW_KEY_UNKNOWN = -1;
    public static final int GLFW_KEY_SPACE = 32;
    public static final int GLFW_KEY_APOSTROPHE = 39;
    public static final int GLFW_KEY_COMMA = 44;
    public static final int GLFW_KEY_MINUS = 45;
    public static final int GLFW_KEY_PERIOD = 46;
    public static final int GLFW_KEY_SLASH = 47;
    public static final int GLFW_KEY_0 = 48;
    public static final int GLFW_KEY_1 = 49;
    public static final int GLFW_KEY_2 = 50;
    public static final int GLFW_KEY_3 = 51;
    public static final int GLFW_KEY_4 = 52;
    public static final int GLFW_KEY_5 = 53;
    public static final int GLFW_KEY_6 = 54;
    public static final int GLFW_KEY_7 = 55;
    public static final int GLFW_KEY_8 = 56;
    public static final int GLFW_KEY_9 = 57;
    public static final int GLFW_KEY_SEMICOLON = 59;
    public static final int GLFW_KEY_EQUAL = 61;
    public static final int GLFW_KEY_A = 65;
    public static final int GLFW_KEY_B = 66;
    public static final int GLFW_KEY_C = 67;
    public static final int GLFW_KEY_D = 68;
    public static final int GLFW_KEY_E = 69;
    public static final int GLFW_KEY_F = 70;
    public static final int GLFW_KEY_G = 71;
    public static final int GLFW_KEY_H = 72;
    public static final int GLFW_KEY_I = 73;
    public static final int GLFW_KEY_J = 74;
    public static final int GLFW_KEY_K = 75;
    public static final int GLFW_KEY_L = 76;
    public static final int GLFW_KEY_M = 77;
    public static final int GLFW_KEY_N = 78;
    public static final int GLFW_KEY_O = 79;
    public static final int GLFW_KEY_P = 80;
    public static final int GLFW_KEY_Q = 81;
    public static final int GLFW_KEY_R = 82;
    public static final int GLFW_KEY_S = 83;
    public static final int GLFW_KEY_T = 84;
    public static final int GLFW_KEY_U = 85;
    public static final int GLFW_KEY_V = 86;
    public static final int GLFW_KEY_W = 87;
    public static final int GLFW_KEY_X = 88;
    public static final int GLFW_KEY_Y = 89;
    public static final int GLFW_KEY_Z = 90;
    public static final int GLFW_KEY_LEFT_BRACKET = 91;
    public static final int GLFW_KEY_BACKSLASH = 92;
    public static final int GLFW_KEY_RIGHT_BRACKET = 93;
    public static final int GLFW_KEY_GRAVE_ACCENT = 96;
    public static final int GLFW_KEY_WORLD_1 = 161;
    public static final int GLFW_KEY_WORLD_2 = 162;
    public static final int GLFW_KEY_ESCAPE = 256;
    public static final int GLFW_KEY_ENTER = 257;
    public static final int GLFW_KEY_TAB = 258;
    public static final int GLFW_KEY_BACKSPACE = 259;
    public static final int GLFW_KEY_INSERT = 260;
    public static final int GLFW_KEY_DELETE = 261;
    public static final int GLFW_KEY_RIGHT = 262;
    public static final int GLFW_KEY_LEFT = 263;
    public static final int GLFW_KEY_DOWN = 264;
    public static final int GLFW_KEY_UP = 265;
    public static final int GLFW_KEY_PAGE_UP = 266;
    public static final int GLFW_KEY_PAGE_DOWN = 267;
    public static final int GLFW_KEY_HOME = 268;
    public static final int GLFW_KEY_END = 269;
    public static final int GLFW_KEY_CAPS_LOCK = 280;
    public static final int GLFW_KEY_SCROLL_LOCK = 281;
    public static final int GLFW_KEY_NUM_LOCK = 282;
    public static final int GLFW_KEY_PRINT_SCREEN = 283;
    public static final int GLFW_KEY_PAUSE = 284;
    public static final int GLFW_KEY_F1 = 290;
    public static final int GLFW_KEY_F2 = 291;
    public static final int GLFW_KEY_F3 = 292;
    public static final int GLFW_KEY_F4 = 293;
    public static final int GLFW_KEY_F5 = 294;
    public static final int GLFW_KEY_F6 = 295;
    public static final int GLFW_KEY_F7 = 296;
    public static final int GLFW_KEY_F8 = 297;
    public static final int GLFW_KEY_F9 = 298;
    public static final int GLFW_KEY_F10 = 299;
    public static final int GLFW_KEY_F11 = 300;
    public static final int GLFW_KEY_F12 = 301;
    public static final int GLFW_KEY_F13 = 302;
    public static final int GLFW_KEY_F14 = 303;
    public static final int GLFW_KEY_F15 = 304;
    public static final int GLFW_KEY_F16 = 305;
    public static final int GLFW_KEY_F17 = 306;
    public static final int GLFW_KEY_F18 = 307;
    public static final int GLFW_KEY_F19 = 308;
    public static final int GLFW_KEY_F20 = 309;
    public static final int GLFW_KEY_F21 = 310;
    public static final int GLFW_KEY_F22 = 311;
    public static final int GLFW_KEY_F23 = 312;
    public static final int GLFW_KEY_F24 = 313;
    public static final int GLFW_KEY_F25 = 314;
    public static final int GLFW_KEY_KP_0 = 320;
    public static final int GLFW_KEY_KP_1 = 321;
    public static final int GLFW_KEY_KP_2 = 322;
    public static final int GLFW_KEY_KP_3 = 323;
    public static final int GLFW_KEY_KP_4 = 324;
    public static final int GLFW_KEY_KP_5 = 325;
    public static final int GLFW_KEY_KP_6 = 326;
    public static final int GLFW_KEY_KP_7 = 327;
    public static final int GLFW_KEY_KP_8 = 328;
    public static final int GLFW_KEY_KP_9 = 329;
    public static final int GLFW_KEY_KP_DECIMAL = 330;
    public static final int GLFW_KEY_KP_DIVIDE = 331;
    public static final int GLFW_KEY_KP_MULTIPLY = 332;
    public static final int GLFW_KEY_KP_SUBTRACT = 333;
    public static final int GLFW_KEY_KP_ADD = 334;
    public static final int GLFW_KEY_KP_ENTER = 335;
    public static final int GLFW_KEY_KP_EQUAL = 336;
    public static final int GLFW_KEY_LEFT_SHIFT = 340;
    public static final int GLFW_KEY_LEFT_CONTROL = 341;
    public static final int GLFW_KEY_LEFT_ALT = 342;
    public static final int GLFW_KEY_LEFT_SUPER = 343;
    public static final int GLFW_KEY_RIGHT_SHIFT = 344;
    public static final int GLFW_KEY_RIGHT_CONTROL = 345;
    public static final int GLFW_KEY_RIGHT_ALT = 346;
    public static final int GLFW_KEY_RIGHT_SUPER = 347;
    public static final int GLFW_KEY_MENU = 348;
    public static final int GLFW_KEY_LAST = 348;
    public static final int GLFW_MOD_SHIFT = 1;
    public static final int GLFW_MOD_CONTROL = 2;
    public static final int GLFW_MOD_ALT = 4;
    public static final int GLFW_MOD_SUPER = 8;
    public static final int GLFW_MOD_CAPS_LOCK = 16;
    public static final int GLFW_MOD_NUM_LOCK = 32;
    public static final int GLFW_MOUSE_BUTTON_1 = 0;
    public static final int GLFW_MOUSE_BUTTON_2 = 1;
    public static final int GLFW_MOUSE_BUTTON_3 = 2;
    public static final int GLFW_MOUSE_BUTTON_4 = 3;
    public static final int GLFW_MOUSE_BUTTON_5 = 4;
    public static final int GLFW_MOUSE_BUTTON_6 = 5;
    public static final int GLFW_MOUSE_BUTTON_7 = 6;
    public static final int GLFW_MOUSE_BUTTON_8 = 7;
    public static final int GLFW_MOUSE_BUTTON_LAST = 7;
    public static final int GLFW_MOUSE_BUTTON_LEFT = 0;
    public static final int GLFW_MOUSE_BUTTON_RIGHT = 1;
    public static final int GLFW_MOUSE_BUTTON_MIDDLE = 2;
    public static final int GLFW_JOYSTICK_1 = 0;
    public static final int GLFW_JOYSTICK_2 = 1;
    public static final int GLFW_JOYSTICK_3 = 2;
    public static final int GLFW_JOYSTICK_4 = 3;
    public static final int GLFW_JOYSTICK_5 = 4;
    public static final int GLFW_JOYSTICK_6 = 5;
    public static final int GLFW_JOYSTICK_7 = 6;
    public static final int GLFW_JOYSTICK_8 = 7;
    public static final int GLFW_JOYSTICK_9 = 8;
    public static final int GLFW_JOYSTICK_10 = 9;
    public static final int GLFW_JOYSTICK_11 = 10;
    public static final int GLFW_JOYSTICK_12 = 11;
    public static final int GLFW_JOYSTICK_13 = 12;
    public static final int GLFW_JOYSTICK_14 = 13;
    public static final int GLFW_JOYSTICK_15 = 14;
    public static final int GLFW_JOYSTICK_16 = 15;
    public static final int GLFW_JOYSTICK_LAST = 15;
    public static final int GLFW_GAMEPAD_BUTTON_A = 0;
    public static final int GLFW_GAMEPAD_BUTTON_B = 1;
    public static final int GLFW_GAMEPAD_BUTTON_X = 2;
    public static final int GLFW_GAMEPAD_BUTTON_Y = 3;
    public static final int GLFW_GAMEPAD_BUTTON_LEFT_BUMPER = 4;
    public static final int GLFW_GAMEPAD_BUTTON_RIGHT_BUMPER = 5;
    public static final int GLFW_GAMEPAD_BUTTON_BACK = 6;
    public static final int GLFW_GAMEPAD_BUTTON_START = 7;
    public static final int GLFW_GAMEPAD_BUTTON_GUIDE = 8;
    public static final int GLFW_GAMEPAD_BUTTON_LEFT_THUMB = 9;
    public static final int GLFW_GAMEPAD_BUTTON_RIGHT_THUMB = 10;
    public static final int GLFW_GAMEPAD_BUTTON_DPAD_UP = 11;
    public static final int GLFW_GAMEPAD_BUTTON_DPAD_RIGHT = 12;
    public static final int GLFW_GAMEPAD_BUTTON_DPAD_DOWN = 13;
    public static final int GLFW_GAMEPAD_BUTTON_DPAD_LEFT = 14;
    public static final int GLFW_GAMEPAD_BUTTON_LAST = 14;
    public static final int GLFW_GAMEPAD_BUTTON_CROSS = 0;
    public static final int GLFW_GAMEPAD_BUTTON_CIRCLE = 1;
    public static final int GLFW_GAMEPAD_BUTTON_SQUARE = 2;
    public static final int GLFW_GAMEPAD_BUTTON_TRIANGLE = 3;
    public static final int GLFW_GAMEPAD_AXIS_LEFT_X = 0;
    public static final int GLFW_GAMEPAD_AXIS_LEFT_Y = 1;
    public static final int GLFW_GAMEPAD_AXIS_RIGHT_X = 2;
    public static final int GLFW_GAMEPAD_AXIS_RIGHT_Y = 3;
    public static final int GLFW_GAMEPAD_AXIS_LEFT_TRIGGER = 4;
    public static final int GLFW_GAMEPAD_AXIS_RIGHT_TRIGGER = 5;
    public static final int GLFW_GAMEPAD_AXIS_LAST = 5;
    public static final int GLFW_NO_ERROR = 0;
    public static final int GLFW_NOT_INITIALIZED = 65537;
    public static final int GLFW_NO_CURRENT_CONTEXT = 65538;
    public static final int GLFW_INVALID_ENUM = 65539;
    public static final int GLFW_INVALID_VALUE = 65540;
    public static final int GLFW_OUT_OF_MEMORY = 65541;
    public static final int GLFW_API_UNAVAILABLE = 65542;
    public static final int GLFW_VERSION_UNAVAILABLE = 65543;
    public static final int GLFW_PLATFORM_ERROR = 65544;
    public static final int GLFW_FORMAT_UNAVAILABLE = 65545;
    public static final int GLFW_NO_WINDOW_CONTEXT = 65546;
    public static final int GLFW_CURSOR_UNAVAILABLE = 65547;
    public static final int GLFW_FEATURE_UNAVAILABLE = 65548;
    public static final int GLFW_FEATURE_UNIMPLEMENTED = 65549;
    public static final int GLFW_PLATFORM_UNAVAILABLE = 65550;
    public static final int GLFW_FOCUSED = 131073;
    public static final int GLFW_ICONIFIED = 131074;
    public static final int GLFW_RESIZABLE = 131075;
    public static final int GLFW_VISIBLE = 131076;
    public static final int GLFW_DECORATED = 131077;
    public static final int GLFW_AUTO_ICONIFY = 131078;
    public static final int GLFW_FLOATING = 131079;
    public static final int GLFW_MAXIMIZED = 131080;
    public static final int GLFW_CENTER_CURSOR = 131081;
    public static final int GLFW_TRANSPARENT_FRAMEBUFFER = 131082;
    public static final int GLFW_HOVERED = 131083;
    public static final int GLFW_FOCUS_ON_SHOW = 131084;
    public static final int GLFW_MOUSE_PASSTHROUGH = 131085;
    public static final int GLFW_POSITION_X = 131086;
    public static final int GLFW_POSITION_Y = 131087;
    public static final int GLFW_SOFT_FULLSCREEN = 131088;
    public static final int GLFW_CURSOR = 208897;
    public static final int GLFW_STICKY_KEYS = 208898;
    public static final int GLFW_STICKY_MOUSE_BUTTONS = 208899;
    public static final int GLFW_LOCK_KEY_MODS = 208900;
    public static final int GLFW_RAW_MOUSE_MOTION = 208901;
    public static final int GLFW_UNLIMITED_MOUSE_BUTTONS = 208902;
    public static final int GLFW_IME = 208903;
    public static final int GLFW_CURSOR_NORMAL = 212993;
    public static final int GLFW_CURSOR_HIDDEN = 212994;
    public static final int GLFW_CURSOR_DISABLED = 212995;
    public static final int GLFW_CURSOR_CAPTURED = 212996;
    public static final int GLFW_ARROW_CURSOR = 221185;
    public static final int GLFW_IBEAM_CURSOR = 221186;
    public static final int GLFW_CROSSHAIR_CURSOR = 221187;
    public static final int GLFW_POINTING_HAND_CURSOR = 221188;
    public static final int GLFW_RESIZE_EW_CURSOR = 221189;
    public static final int GLFW_RESIZE_NS_CURSOR = 221190;
    public static final int GLFW_RESIZE_NWSE_CURSOR = 221191;
    public static final int GLFW_RESIZE_NESW_CURSOR = 221192;
    public static final int GLFW_RESIZE_ALL_CURSOR = 221193;
    public static final int GLFW_NOT_ALLOWED_CURSOR = 221194;
    public static final int GLFW_HRESIZE_CURSOR = 221189;
    public static final int GLFW_VRESIZE_CURSOR = 221190;
    public static final int GLFW_HAND_CURSOR = 221188;
    public static final int GLFW_CONNECTED = 262145;
    public static final int GLFW_DISCONNECTED = 262146;
    public static final int GLFW_JOYSTICK_HAT_BUTTONS = 327681;
    public static final int GLFW_ANGLE_PLATFORM_TYPE = 327682;
    public static final int GLFW_ANY_POSITION = Integer.MIN_VALUE;
    public static final int GLFW_PLATFORM = 327683;
    public static final int GLFW_MANAGE_PREEDIT_CANDIDATE = 327684;
    public static final int GLFW_COCOA_CHDIR_RESOURCES = 331777;
    public static final int GLFW_COCOA_MENUBAR = 331778;
    public static final int GLFW_X11_XCB_VULKAN_SURFACE = 335873;
    public static final int GLFW_X11_ONTHESPOT = 335874;
    public static final int GLFW_WAYLAND_LIBDECOR = 339969;
    public static final int GLFW_ANY_PLATFORM = 393216;
    public static final int GLFW_PLATFORM_WIN32 = 393217;
    public static final int GLFW_PLATFORM_COCOA = 393218;
    public static final int GLFW_PLATFORM_WAYLAND = 393219;
    public static final int GLFW_PLATFORM_X11 = 393220;
    public static final int GLFW_PLATFORM_NULL = 393221;
    public static final int GLFW_DONT_CARE = -1;
    public static final int GLFW_RED_BITS = 135169;
    public static final int GLFW_GREEN_BITS = 135170;
    public static final int GLFW_BLUE_BITS = 135171;
    public static final int GLFW_ALPHA_BITS = 135172;
    public static final int GLFW_DEPTH_BITS = 135173;
    public static final int GLFW_STENCIL_BITS = 135174;
    public static final int GLFW_ACCUM_RED_BITS = 135175;
    public static final int GLFW_ACCUM_GREEN_BITS = 135176;
    public static final int GLFW_ACCUM_BLUE_BITS = 135177;
    public static final int GLFW_ACCUM_ALPHA_BITS = 135178;
    public static final int GLFW_AUX_BUFFERS = 135179;
    public static final int GLFW_STEREO = 135180;
    public static final int GLFW_SAMPLES = 135181;
    public static final int GLFW_SRGB_CAPABLE = 135182;
    public static final int GLFW_REFRESH_RATE = 135183;
    public static final int GLFW_DOUBLEBUFFER = 135184;
    public static final int GLFW_CLIENT_API = 139265;
    public static final int GLFW_CONTEXT_VERSION_MAJOR = 139266;
    public static final int GLFW_CONTEXT_VERSION_MINOR = 139267;
    public static final int GLFW_CONTEXT_REVISION = 139268;
    public static final int GLFW_CONTEXT_ROBUSTNESS = 139269;
    public static final int GLFW_OPENGL_FORWARD_COMPAT = 139270;
    public static final int GLFW_CONTEXT_DEBUG = 139271;
    public static final int GLFW_OPENGL_DEBUG_CONTEXT = 139271;
    public static final int GLFW_OPENGL_PROFILE = 139272;
    public static final int GLFW_CONTEXT_RELEASE_BEHAVIOR = 139273;
    public static final int GLFW_CONTEXT_NO_ERROR = 139274;
    public static final int GLFW_CONTEXT_CREATION_API = 139275;
    public static final int GLFW_SCALE_TO_MONITOR = 139276;
    public static final int GLFW_SCALE_FRAMEBUFFER = 139277;
    public static final int GLFW_COCOA_RETINA_FRAMEBUFFER = 143361;
    public static final int GLFW_COCOA_FRAME_NAME = 143362;
    public static final int GLFW_COCOA_GRAPHICS_SWITCHING = 143363;
    public static final int GLFW_X11_CLASS_NAME = 147457;
    public static final int GLFW_X11_INSTANCE_NAME = 147458;
    public static final int GLFW_WIN32_KEYBOARD_MENU = 151553;
    public static final int GLFW_WIN32_SHOWDEFAULT = 151554;
    public static final int GLFW_WAYLAND_APP_ID = 155649;
    public static final int GLFW_NO_API = 0;
    public static final int GLFW_OPENGL_API = 196609;
    public static final int GLFW_OPENGL_ES_API = 196610;
    public static final int GLFW_NO_ROBUSTNESS = 0;
    public static final int GLFW_NO_RESET_NOTIFICATION = 200705;
    public static final int GLFW_LOSE_CONTEXT_ON_RESET = 200706;
    public static final int GLFW_OPENGL_ANY_PROFILE = 0;
    public static final int GLFW_OPENGL_CORE_PROFILE = 204801;
    public static final int GLFW_OPENGL_COMPAT_PROFILE = 204802;
    public static final int GLFW_ANY_RELEASE_BEHAVIOR = 0;
    public static final int GLFW_RELEASE_BEHAVIOR_FLUSH = 217089;
    public static final int GLFW_RELEASE_BEHAVIOR_NONE = 217090;
    public static final int GLFW_NATIVE_CONTEXT_API = 221185;
    public static final int GLFW_EGL_CONTEXT_API = 221186;
    public static final int GLFW_OSMESA_CONTEXT_API = 221187;
    public static final int GLFW_ANGLE_PLATFORM_TYPE_NONE = 225281;
    public static final int GLFW_ANGLE_PLATFORM_TYPE_OPENGL = 225282;
    public static final int GLFW_ANGLE_PLATFORM_TYPE_OPENGLES = 225283;
    public static final int GLFW_ANGLE_PLATFORM_TYPE_D3D9 = 225284;
    public static final int GLFW_ANGLE_PLATFORM_TYPE_D3D11 = 225285;
    public static final int GLFW_ANGLE_PLATFORM_TYPE_VULKAN = 225287;
    public static final int GLFW_ANGLE_PLATFORM_TYPE_METAL = 225288;
    public static final int GLFW_WAYLAND_PREFER_LIBDECOR = 229377;
    public static final int GLFW_WAYLAND_DISABLE_LIBDECOR = 229378;

    public static SharedLibrary getLibrary() {
        return GLFW;
    }

    protected GLFW() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="int")
    public static boolean glfwInit() {
        long l = Functions.Init;
        EventLoop.check();
        return JNI.invokeI(l) != 0;
    }

    public static void glfwTerminate() {
        long l = Functions.Terminate;
        JNI.invokeV(l);
    }

    public static void glfwInitHint(int n, int n2) {
        long l = Functions.InitHint;
        JNI.invokeV(n, n2, l);
    }

    public static void nglfwInitAllocator(long l) {
        long l2 = Functions.InitAllocator;
        if (Checks.CHECKS && l != 0L) {
            GLFWAllocator.validate(l);
        }
        JNI.invokePV(l, l2);
    }

    public static void glfwInitAllocator(@NativeType(value="GLFWallocator const *") @Nullable GLFWAllocator gLFWAllocator) {
        org.lwjgl.glfw.GLFW.nglfwInitAllocator(MemoryUtil.memAddressSafe(gLFWAllocator));
    }

    public static void nglfwGetVersion(long l, long l2, long l3) {
        long l4 = Functions.GetVersion;
        JNI.invokePPPV(l, l2, l3, l4);
    }

    public static void glfwGetVersion(@NativeType(value="int *") @Nullable IntBuffer intBuffer, @NativeType(value="int *") @Nullable IntBuffer intBuffer2, @NativeType(value="int *") @Nullable IntBuffer intBuffer3) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
            Checks.checkSafe((Buffer)intBuffer2, 1);
            Checks.checkSafe((Buffer)intBuffer3, 1);
        }
        org.lwjgl.glfw.GLFW.nglfwGetVersion(MemoryUtil.memAddressSafe(intBuffer), MemoryUtil.memAddressSafe(intBuffer2), MemoryUtil.memAddressSafe(intBuffer3));
    }

    public static long nglfwGetVersionString() {
        long l = Functions.GetVersionString;
        return JNI.invokeP(l);
    }

    @NativeType(value="char const *")
    public static String glfwGetVersionString() {
        long l = org.lwjgl.glfw.GLFW.nglfwGetVersionString();
        return MemoryUtil.memASCII(l);
    }

    public static int nglfwGetError(long l) {
        long l2 = Functions.GetError;
        return JNI.invokePI(l, l2);
    }

    public static int glfwGetError(@NativeType(value="char const **") @Nullable PointerBuffer pointerBuffer) {
        if (Checks.CHECKS) {
            Checks.checkSafe(pointerBuffer, 1);
        }
        return org.lwjgl.glfw.GLFW.nglfwGetError(MemoryUtil.memAddressSafe(pointerBuffer));
    }

    public static long nglfwSetErrorCallback(long l) {
        long l2 = Functions.SetErrorCallback;
        return JNI.invokePP(l, l2);
    }

    @NativeType(value="GLFWerrorfun")
    public static @Nullable GLFWErrorCallback glfwSetErrorCallback(@NativeType(value="GLFWerrorfun") @Nullable GLFWErrorCallbackI gLFWErrorCallbackI) {
        return GLFWErrorCallback.createSafe(org.lwjgl.glfw.GLFW.nglfwSetErrorCallback(MemoryUtil.memAddressSafe(gLFWErrorCallbackI)));
    }

    public static int glfwGetPlatform() {
        long l = Functions.GetPlatform;
        return JNI.invokeI(l);
    }

    @NativeType(value="int")
    public static boolean glfwPlatformSupported(int n) {
        long l = Functions.PlatformSupported;
        return JNI.invokeI(n, l) != 0;
    }

    public static long nglfwGetMonitors(long l) {
        long l2 = Functions.GetMonitors;
        return JNI.invokePP(l, l2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="GLFWmonitor **")
    public static @Nullable PointerBuffer glfwGetMonitors() {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n = memoryStack.getPointer();
        IntBuffer intBuffer = memoryStack.callocInt(1);
        try {
            long l = org.lwjgl.glfw.GLFW.nglfwGetMonitors(MemoryUtil.memAddress(intBuffer));
            PointerBuffer pointerBuffer = MemoryUtil.memPointerBufferSafe(l, intBuffer.get(0));
            return pointerBuffer;
        }
        finally {
            memoryStack.setPointer(n);
        }
    }

    @NativeType(value="GLFWmonitor *")
    public static long glfwGetPrimaryMonitor() {
        long l = Functions.GetPrimaryMonitor;
        return JNI.invokeP(l);
    }

    public static void nglfwGetMonitorPos(long l, long l2, long l3) {
        long l4 = Functions.GetMonitorPos;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePPPV(l, l2, l3, l4);
    }

    public static void glfwGetMonitorPos(@NativeType(value="GLFWmonitor *") long l, @NativeType(value="int *") @Nullable IntBuffer intBuffer, @NativeType(value="int *") @Nullable IntBuffer intBuffer2) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
            Checks.checkSafe((Buffer)intBuffer2, 1);
        }
        org.lwjgl.glfw.GLFW.nglfwGetMonitorPos(l, MemoryUtil.memAddressSafe(intBuffer), MemoryUtil.memAddressSafe(intBuffer2));
    }

    public static void nglfwGetMonitorWorkarea(long l, long l2, long l3, long l4, long l5) {
        long l6 = Functions.GetMonitorWorkarea;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePPPPPV(l, l2, l3, l4, l5, l6);
    }

    public static void glfwGetMonitorWorkarea(@NativeType(value="GLFWmonitor *") long l, @NativeType(value="int *") @Nullable IntBuffer intBuffer, @NativeType(value="int *") @Nullable IntBuffer intBuffer2, @NativeType(value="int *") @Nullable IntBuffer intBuffer3, @NativeType(value="int *") @Nullable IntBuffer intBuffer4) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
            Checks.checkSafe((Buffer)intBuffer2, 1);
            Checks.checkSafe((Buffer)intBuffer3, 1);
            Checks.checkSafe((Buffer)intBuffer4, 1);
        }
        org.lwjgl.glfw.GLFW.nglfwGetMonitorWorkarea(l, MemoryUtil.memAddressSafe(intBuffer), MemoryUtil.memAddressSafe(intBuffer2), MemoryUtil.memAddressSafe(intBuffer3), MemoryUtil.memAddressSafe(intBuffer4));
    }

    public static void nglfwGetMonitorPhysicalSize(long l, long l2, long l3) {
        long l4 = Functions.GetMonitorPhysicalSize;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePPPV(l, l2, l3, l4);
    }

    public static void glfwGetMonitorPhysicalSize(@NativeType(value="GLFWmonitor *") long l, @NativeType(value="int *") @Nullable IntBuffer intBuffer, @NativeType(value="int *") @Nullable IntBuffer intBuffer2) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
            Checks.checkSafe((Buffer)intBuffer2, 1);
        }
        org.lwjgl.glfw.GLFW.nglfwGetMonitorPhysicalSize(l, MemoryUtil.memAddressSafe(intBuffer), MemoryUtil.memAddressSafe(intBuffer2));
    }

    public static void nglfwGetMonitorContentScale(long l, long l2, long l3) {
        long l4 = Functions.GetMonitorContentScale;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePPPV(l, l2, l3, l4);
    }

    public static void glfwGetMonitorContentScale(@NativeType(value="GLFWmonitor *") long l, @NativeType(value="float *") @Nullable FloatBuffer floatBuffer, @NativeType(value="float *") @Nullable FloatBuffer floatBuffer2) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)floatBuffer, 1);
            Checks.checkSafe((Buffer)floatBuffer2, 1);
        }
        org.lwjgl.glfw.GLFW.nglfwGetMonitorContentScale(l, MemoryUtil.memAddressSafe(floatBuffer), MemoryUtil.memAddressSafe(floatBuffer2));
    }

    public static long nglfwGetMonitorName(long l) {
        long l2 = Functions.GetMonitorName;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokePP(l, l2);
    }

    @NativeType(value="char const *")
    public static @Nullable String glfwGetMonitorName(@NativeType(value="GLFWmonitor *") long l) {
        long l2 = org.lwjgl.glfw.GLFW.nglfwGetMonitorName(l);
        return MemoryUtil.memUTF8Safe(l2);
    }

    public static void glfwSetMonitorUserPointer(@NativeType(value="GLFWmonitor *") long l, @NativeType(value="void *") long l2) {
        long l3 = Functions.SetMonitorUserPointer;
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.check(l2);
        }
        JNI.invokePPV(l, l2, l3);
    }

    @NativeType(value="void *")
    public static long glfwGetMonitorUserPointer(@NativeType(value="GLFWmonitor *") long l) {
        long l2 = Functions.GetMonitorUserPointer;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokePP(l, l2);
    }

    public static long nglfwSetMonitorCallback(long l) {
        long l2 = Functions.SetMonitorCallback;
        return JNI.invokePP(l, l2);
    }

    @NativeType(value="GLFWmonitorfun")
    public static @Nullable GLFWMonitorCallback glfwSetMonitorCallback(@NativeType(value="GLFWmonitorfun") @Nullable GLFWMonitorCallbackI gLFWMonitorCallbackI) {
        return GLFWMonitorCallback.createSafe(org.lwjgl.glfw.GLFW.nglfwSetMonitorCallback(MemoryUtil.memAddressSafe(gLFWMonitorCallbackI)));
    }

    public static long nglfwGetVideoModes(long l, long l2) {
        long l3 = Functions.GetVideoModes;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokePPP(l, l2, l3);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="GLFWvidmode const *")
    public static @Nullable GLFWVidMode.Buffer glfwGetVideoModes(@NativeType(value="GLFWmonitor *") long l) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n = memoryStack.getPointer();
        IntBuffer intBuffer = memoryStack.callocInt(1);
        try {
            long l2 = org.lwjgl.glfw.GLFW.nglfwGetVideoModes(l, MemoryUtil.memAddress(intBuffer));
            GLFWVidMode.Buffer buffer = GLFWVidMode.createSafe(l2, intBuffer.get(0));
            return buffer;
        }
        finally {
            memoryStack.setPointer(n);
        }
    }

    public static long nglfwGetVideoMode(long l) {
        long l2 = Functions.GetVideoMode;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokePP(l, l2);
    }

    @NativeType(value="GLFWvidmode const *")
    public static @Nullable GLFWVidMode glfwGetVideoMode(@NativeType(value="GLFWmonitor *") long l) {
        long l2 = org.lwjgl.glfw.GLFW.nglfwGetVideoMode(l);
        return GLFWVidMode.createSafe(l2);
    }

    public static void glfwSetGamma(@NativeType(value="GLFWmonitor *") long l, float f) {
        long l2 = Functions.SetGamma;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePV(l, f, l2);
    }

    public static long nglfwGetGammaRamp(long l) {
        long l2 = Functions.GetGammaRamp;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokePP(l, l2);
    }

    @NativeType(value="GLFWgammaramp const *")
    public static @Nullable GLFWGammaRamp glfwGetGammaRamp(@NativeType(value="GLFWmonitor *") long l) {
        long l2 = org.lwjgl.glfw.GLFW.nglfwGetGammaRamp(l);
        return GLFWGammaRamp.createSafe(l2);
    }

    public static void nglfwSetGammaRamp(long l, long l2) {
        long l3 = Functions.SetGammaRamp;
        if (Checks.CHECKS) {
            Checks.check(l);
            GLFWGammaRamp.validate(l2);
        }
        JNI.invokePPV(l, l2, l3);
    }

    public static void glfwSetGammaRamp(@NativeType(value="GLFWmonitor *") long l, @NativeType(value="GLFWgammaramp const *") GLFWGammaRamp gLFWGammaRamp) {
        org.lwjgl.glfw.GLFW.nglfwSetGammaRamp(l, gLFWGammaRamp.address());
    }

    public static void glfwDefaultWindowHints() {
        long l = Functions.DefaultWindowHints;
        JNI.invokeV(l);
    }

    public static void glfwWindowHint(int n, int n2) {
        long l = Functions.WindowHint;
        JNI.invokeV(n, n2, l);
    }

    public static void nglfwWindowHintString(int n, long l) {
        long l2 = Functions.WindowHintString;
        JNI.invokePV(n, l, l2);
    }

    public static void glfwWindowHintString(int n, @NativeType(value="char const *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        org.lwjgl.glfw.GLFW.nglfwWindowHintString(n, MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glfwWindowHintString(int n, @NativeType(value="char const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l = memoryStack.getPointerAddress();
            org.lwjgl.glfw.GLFW.nglfwWindowHintString(n, l);
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static long nglfwCreateWindow(int n, int n2, long l, long l2, long l3) {
        long l4 = Functions.CreateWindow;
        return JNI.invokePPPP(n, n2, l, l2, l3, l4);
    }

    @NativeType(value="GLFWwindow *")
    public static long glfwCreateWindow(int n, int n2, @NativeType(value="char const *") ByteBuffer byteBuffer, @NativeType(value="GLFWmonitor *") long l, @NativeType(value="GLFWwindow *") long l2) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        return org.lwjgl.glfw.GLFW.nglfwCreateWindow(n, n2, MemoryUtil.memAddress(byteBuffer), l, l2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="GLFWwindow *")
    public static long glfwCreateWindow(int n, int n2, @NativeType(value="char const *") CharSequence charSequence, @NativeType(value="GLFWmonitor *") long l, @NativeType(value="GLFWwindow *") long l2) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l3 = memoryStack.getPointerAddress();
            long l4 = org.lwjgl.glfw.GLFW.nglfwCreateWindow(n, n2, l3, l, l2);
            return l4;
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    public static void glfwDestroyWindow(@NativeType(value="GLFWwindow *") long l) {
        long l2 = Functions.DestroyWindow;
        JNI.invokePV(l, l2);
    }

    @NativeType(value="int")
    public static boolean glfwWindowShouldClose(@NativeType(value="GLFWwindow *") long l) {
        long l2 = Functions.WindowShouldClose;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokePI(l, l2) != 0;
    }

    public static void glfwSetWindowShouldClose(@NativeType(value="GLFWwindow *") long l, @NativeType(value="int") boolean bl) {
        long l2 = Functions.SetWindowShouldClose;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePV(l, bl ? 1 : 0, l2);
    }

    public static long nglfwGetWindowTitle(long l) {
        long l2 = Functions.GetWindowTitle;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokePP(l, l2);
    }

    @NativeType(value="char const *")
    public static @Nullable String glfwGetWindowTitle(@NativeType(value="GLFWwindow *") long l) {
        long l2 = org.lwjgl.glfw.GLFW.nglfwGetWindowTitle(l);
        return MemoryUtil.memUTF8Safe(l2);
    }

    public static void nglfwSetWindowTitle(long l, long l2) {
        long l3 = Functions.SetWindowTitle;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePPV(l, l2, l3);
    }

    public static void glfwSetWindowTitle(@NativeType(value="GLFWwindow *") long l, @NativeType(value="char const *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        org.lwjgl.glfw.GLFW.nglfwSetWindowTitle(l, MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glfwSetWindowTitle(@NativeType(value="GLFWwindow *") long l, @NativeType(value="char const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            org.lwjgl.glfw.GLFW.nglfwSetWindowTitle(l, l2);
        }
        finally {
            memoryStack.setPointer(n);
        }
    }

    public static void nglfwSetWindowIcon(long l, int n, long l2) {
        long l3 = Functions.SetWindowIcon;
        if (Checks.CHECKS) {
            Checks.check(l);
            if (l2 != 0L) {
                Struct.validate(l2, n, GLFWImage.SIZEOF, GLFWImage::validate);
            }
        }
        JNI.invokePPV(l, n, l2, l3);
    }

    public static void glfwSetWindowIcon(@NativeType(value="GLFWwindow *") long l, @NativeType(value="GLFWimage const *") @Nullable GLFWImage.Buffer buffer) {
        org.lwjgl.glfw.GLFW.nglfwSetWindowIcon(l, Checks.remainingSafe(buffer), MemoryUtil.memAddressSafe(buffer));
    }

    public static void nglfwGetWindowPos(long l, long l2, long l3) {
        long l4 = Functions.GetWindowPos;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePPPV(l, l2, l3, l4);
    }

    public static void glfwGetWindowPos(@NativeType(value="GLFWwindow *") long l, @NativeType(value="int *") @Nullable IntBuffer intBuffer, @NativeType(value="int *") @Nullable IntBuffer intBuffer2) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
            Checks.checkSafe((Buffer)intBuffer2, 1);
        }
        org.lwjgl.glfw.GLFW.nglfwGetWindowPos(l, MemoryUtil.memAddressSafe(intBuffer), MemoryUtil.memAddressSafe(intBuffer2));
    }

    public static void glfwSetWindowPos(@NativeType(value="GLFWwindow *") long l, int n, int n2) {
        long l2 = Functions.SetWindowPos;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePV(l, n, n2, l2);
    }

    public static void nglfwGetWindowSize(long l, long l2, long l3) {
        long l4 = Functions.GetWindowSize;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePPPV(l, l2, l3, l4);
    }

    public static void glfwGetWindowSize(@NativeType(value="GLFWwindow *") long l, @NativeType(value="int *") @Nullable IntBuffer intBuffer, @NativeType(value="int *") @Nullable IntBuffer intBuffer2) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
            Checks.checkSafe((Buffer)intBuffer2, 1);
        }
        org.lwjgl.glfw.GLFW.nglfwGetWindowSize(l, MemoryUtil.memAddressSafe(intBuffer), MemoryUtil.memAddressSafe(intBuffer2));
    }

    public static void glfwSetWindowSizeLimits(@NativeType(value="GLFWwindow *") long l, int n, int n2, int n3, int n4) {
        long l2 = Functions.SetWindowSizeLimits;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePV(l, n, n2, n3, n4, l2);
    }

    public static void glfwSetWindowAspectRatio(@NativeType(value="GLFWwindow *") long l, int n, int n2) {
        long l2 = Functions.SetWindowAspectRatio;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePV(l, n, n2, l2);
    }

    public static void glfwSetWindowSize(@NativeType(value="GLFWwindow *") long l, int n, int n2) {
        long l2 = Functions.SetWindowSize;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePV(l, n, n2, l2);
    }

    public static void nglfwGetFramebufferSize(long l, long l2, long l3) {
        long l4 = Functions.GetFramebufferSize;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePPPV(l, l2, l3, l4);
    }

    public static void glfwGetFramebufferSize(@NativeType(value="GLFWwindow *") long l, @NativeType(value="int *") @Nullable IntBuffer intBuffer, @NativeType(value="int *") @Nullable IntBuffer intBuffer2) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
            Checks.checkSafe((Buffer)intBuffer2, 1);
        }
        org.lwjgl.glfw.GLFW.nglfwGetFramebufferSize(l, MemoryUtil.memAddressSafe(intBuffer), MemoryUtil.memAddressSafe(intBuffer2));
    }

    public static void nglfwGetWindowFrameSize(long l, long l2, long l3, long l4, long l5) {
        long l6 = Functions.GetWindowFrameSize;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePPPPPV(l, l2, l3, l4, l5, l6);
    }

    public static void glfwGetWindowFrameSize(@NativeType(value="GLFWwindow *") long l, @NativeType(value="int *") @Nullable IntBuffer intBuffer, @NativeType(value="int *") @Nullable IntBuffer intBuffer2, @NativeType(value="int *") @Nullable IntBuffer intBuffer3, @NativeType(value="int *") @Nullable IntBuffer intBuffer4) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
            Checks.checkSafe((Buffer)intBuffer2, 1);
            Checks.checkSafe((Buffer)intBuffer3, 1);
            Checks.checkSafe((Buffer)intBuffer4, 1);
        }
        org.lwjgl.glfw.GLFW.nglfwGetWindowFrameSize(l, MemoryUtil.memAddressSafe(intBuffer), MemoryUtil.memAddressSafe(intBuffer2), MemoryUtil.memAddressSafe(intBuffer3), MemoryUtil.memAddressSafe(intBuffer4));
    }

    public static void nglfwGetWindowContentScale(long l, long l2, long l3) {
        long l4 = Functions.GetWindowContentScale;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePPPV(l, l2, l3, l4);
    }

    public static void glfwGetWindowContentScale(@NativeType(value="GLFWwindow *") long l, @NativeType(value="float *") @Nullable FloatBuffer floatBuffer, @NativeType(value="float *") @Nullable FloatBuffer floatBuffer2) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)floatBuffer, 1);
            Checks.checkSafe((Buffer)floatBuffer2, 1);
        }
        org.lwjgl.glfw.GLFW.nglfwGetWindowContentScale(l, MemoryUtil.memAddressSafe(floatBuffer), MemoryUtil.memAddressSafe(floatBuffer2));
    }

    public static float glfwGetWindowOpacity(@NativeType(value="GLFWwindow *") long l) {
        long l2 = Functions.GetWindowOpacity;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokePF(l, l2);
    }

    public static void glfwSetWindowOpacity(@NativeType(value="GLFWwindow *") long l, float f) {
        long l2 = Functions.SetWindowOpacity;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePV(l, f, l2);
    }

    public static void glfwIconifyWindow(@NativeType(value="GLFWwindow *") long l) {
        long l2 = Functions.IconifyWindow;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePV(l, l2);
    }

    public static void glfwRestoreWindow(@NativeType(value="GLFWwindow *") long l) {
        long l2 = Functions.RestoreWindow;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePV(l, l2);
    }

    public static void glfwMaximizeWindow(@NativeType(value="GLFWwindow *") long l) {
        long l2 = Functions.MaximizeWindow;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePV(l, l2);
    }

    public static void glfwShowWindow(@NativeType(value="GLFWwindow *") long l) {
        long l2 = Functions.ShowWindow;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePV(l, l2);
    }

    public static void glfwHideWindow(@NativeType(value="GLFWwindow *") long l) {
        long l2 = Functions.HideWindow;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePV(l, l2);
    }

    public static void glfwFocusWindow(@NativeType(value="GLFWwindow *") long l) {
        long l2 = Functions.FocusWindow;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePV(l, l2);
    }

    public static void glfwRequestWindowAttention(@NativeType(value="GLFWwindow *") long l) {
        long l2 = Functions.RequestWindowAttention;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePV(l, l2);
    }

    @NativeType(value="GLFWmonitor *")
    public static long glfwGetWindowMonitor(@NativeType(value="GLFWwindow *") long l) {
        long l2 = Functions.GetWindowMonitor;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokePP(l, l2);
    }

    public static void glfwSetWindowMonitor(@NativeType(value="GLFWwindow *") long l, @NativeType(value="GLFWmonitor *") long l2, int n, int n2, int n3, int n4, int n5) {
        long l3 = Functions.SetWindowMonitor;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePPV(l, l2, n, n2, n3, n4, n5, l3);
    }

    public static int glfwGetWindowAttrib(@NativeType(value="GLFWwindow *") long l, int n) {
        long l2 = Functions.GetWindowAttrib;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokePI(l, n, l2);
    }

    public static void glfwSetWindowAttrib(@NativeType(value="GLFWwindow *") long l, int n, int n2) {
        long l2 = Functions.SetWindowAttrib;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePV(l, n, n2, l2);
    }

    public static void glfwSetWindowUserPointer(@NativeType(value="GLFWwindow *") long l, @NativeType(value="void *") long l2) {
        long l3 = Functions.SetWindowUserPointer;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePPV(l, l2, l3);
    }

    @NativeType(value="void *")
    public static long glfwGetWindowUserPointer(@NativeType(value="GLFWwindow *") long l) {
        long l2 = Functions.GetWindowUserPointer;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokePP(l, l2);
    }

    public static long nglfwSetWindowPosCallback(long l, long l2) {
        long l3 = Functions.SetWindowPosCallback;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokePPP(l, l2, l3);
    }

    @NativeType(value="GLFWwindowposfun")
    public static @Nullable GLFWWindowPosCallback glfwSetWindowPosCallback(@NativeType(value="GLFWwindow *") long l, @NativeType(value="GLFWwindowposfun") @Nullable GLFWWindowPosCallbackI gLFWWindowPosCallbackI) {
        return GLFWWindowPosCallback.createSafe(org.lwjgl.glfw.GLFW.nglfwSetWindowPosCallback(l, MemoryUtil.memAddressSafe(gLFWWindowPosCallbackI)));
    }

    public static long nglfwSetWindowSizeCallback(long l, long l2) {
        long l3 = Functions.SetWindowSizeCallback;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokePPP(l, l2, l3);
    }

    @NativeType(value="GLFWwindowsizefun")
    public static @Nullable GLFWWindowSizeCallback glfwSetWindowSizeCallback(@NativeType(value="GLFWwindow *") long l, @NativeType(value="GLFWwindowsizefun") @Nullable GLFWWindowSizeCallbackI gLFWWindowSizeCallbackI) {
        return GLFWWindowSizeCallback.createSafe(org.lwjgl.glfw.GLFW.nglfwSetWindowSizeCallback(l, MemoryUtil.memAddressSafe(gLFWWindowSizeCallbackI)));
    }

    public static long nglfwSetWindowCloseCallback(long l, long l2) {
        long l3 = Functions.SetWindowCloseCallback;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokePPP(l, l2, l3);
    }

    @NativeType(value="GLFWwindowclosefun")
    public static @Nullable GLFWWindowCloseCallback glfwSetWindowCloseCallback(@NativeType(value="GLFWwindow *") long l, @NativeType(value="GLFWwindowclosefun") @Nullable GLFWWindowCloseCallbackI gLFWWindowCloseCallbackI) {
        return GLFWWindowCloseCallback.createSafe(org.lwjgl.glfw.GLFW.nglfwSetWindowCloseCallback(l, MemoryUtil.memAddressSafe(gLFWWindowCloseCallbackI)));
    }

    public static long nglfwSetWindowRefreshCallback(long l, long l2) {
        long l3 = Functions.SetWindowRefreshCallback;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokePPP(l, l2, l3);
    }

    @NativeType(value="GLFWwindowrefreshfun")
    public static @Nullable GLFWWindowRefreshCallback glfwSetWindowRefreshCallback(@NativeType(value="GLFWwindow *") long l, @NativeType(value="GLFWwindowrefreshfun") @Nullable GLFWWindowRefreshCallbackI gLFWWindowRefreshCallbackI) {
        return GLFWWindowRefreshCallback.createSafe(org.lwjgl.glfw.GLFW.nglfwSetWindowRefreshCallback(l, MemoryUtil.memAddressSafe(gLFWWindowRefreshCallbackI)));
    }

    public static long nglfwSetWindowFocusCallback(long l, long l2) {
        long l3 = Functions.SetWindowFocusCallback;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokePPP(l, l2, l3);
    }

    @NativeType(value="GLFWwindowfocusfun")
    public static @Nullable GLFWWindowFocusCallback glfwSetWindowFocusCallback(@NativeType(value="GLFWwindow *") long l, @NativeType(value="GLFWwindowfocusfun") @Nullable GLFWWindowFocusCallbackI gLFWWindowFocusCallbackI) {
        return GLFWWindowFocusCallback.createSafe(org.lwjgl.glfw.GLFW.nglfwSetWindowFocusCallback(l, MemoryUtil.memAddressSafe(gLFWWindowFocusCallbackI)));
    }

    public static long nglfwSetWindowIconifyCallback(long l, long l2) {
        long l3 = Functions.SetWindowIconifyCallback;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokePPP(l, l2, l3);
    }

    @NativeType(value="GLFWwindowiconifyfun")
    public static @Nullable GLFWWindowIconifyCallback glfwSetWindowIconifyCallback(@NativeType(value="GLFWwindow *") long l, @NativeType(value="GLFWwindowiconifyfun") @Nullable GLFWWindowIconifyCallbackI gLFWWindowIconifyCallbackI) {
        return GLFWWindowIconifyCallback.createSafe(org.lwjgl.glfw.GLFW.nglfwSetWindowIconifyCallback(l, MemoryUtil.memAddressSafe(gLFWWindowIconifyCallbackI)));
    }

    public static long nglfwSetWindowMaximizeCallback(long l, long l2) {
        long l3 = Functions.SetWindowMaximizeCallback;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokePPP(l, l2, l3);
    }

    @NativeType(value="GLFWwindowmaximizefun")
    public static @Nullable GLFWWindowMaximizeCallback glfwSetWindowMaximizeCallback(@NativeType(value="GLFWwindow *") long l, @NativeType(value="GLFWwindowmaximizefun") @Nullable GLFWWindowMaximizeCallbackI gLFWWindowMaximizeCallbackI) {
        return GLFWWindowMaximizeCallback.createSafe(org.lwjgl.glfw.GLFW.nglfwSetWindowMaximizeCallback(l, MemoryUtil.memAddressSafe(gLFWWindowMaximizeCallbackI)));
    }

    public static long nglfwSetFramebufferSizeCallback(long l, long l2) {
        long l3 = Functions.SetFramebufferSizeCallback;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokePPP(l, l2, l3);
    }

    @NativeType(value="GLFWframebuffersizefun")
    public static @Nullable GLFWFramebufferSizeCallback glfwSetFramebufferSizeCallback(@NativeType(value="GLFWwindow *") long l, @NativeType(value="GLFWframebuffersizefun") @Nullable GLFWFramebufferSizeCallbackI gLFWFramebufferSizeCallbackI) {
        return GLFWFramebufferSizeCallback.createSafe(org.lwjgl.glfw.GLFW.nglfwSetFramebufferSizeCallback(l, MemoryUtil.memAddressSafe(gLFWFramebufferSizeCallbackI)));
    }

    public static long nglfwSetWindowContentScaleCallback(long l, long l2) {
        long l3 = Functions.SetWindowContentScaleCallback;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokePPP(l, l2, l3);
    }

    @NativeType(value="GLFWwindowcontentscalefun")
    public static @Nullable GLFWWindowContentScaleCallback glfwSetWindowContentScaleCallback(@NativeType(value="GLFWwindow *") long l, @NativeType(value="GLFWwindowcontentscalefun") @Nullable GLFWWindowContentScaleCallbackI gLFWWindowContentScaleCallbackI) {
        return GLFWWindowContentScaleCallback.createSafe(org.lwjgl.glfw.GLFW.nglfwSetWindowContentScaleCallback(l, MemoryUtil.memAddressSafe(gLFWWindowContentScaleCallbackI)));
    }

    public static void glfwPollEvents() {
        long l = Functions.PollEvents;
        JNI.invokeV(l);
    }

    public static void glfwWaitEvents() {
        long l = Functions.WaitEvents;
        JNI.invokeV(l);
    }

    public static void glfwWaitEventsTimeout(double d) {
        long l = Functions.WaitEventsTimeout;
        JNI.invokeV(d, l);
    }

    public static void glfwPostEmptyEvent() {
        long l = Functions.PostEmptyEvent;
        JNI.invokeV(l);
    }

    public static int glfwGetInputMode(@NativeType(value="GLFWwindow *") long l, int n) {
        long l2 = Functions.GetInputMode;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokePI(l, n, l2);
    }

    public static void glfwSetInputMode(@NativeType(value="GLFWwindow *") long l, int n, int n2) {
        long l2 = Functions.SetInputMode;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePV(l, n, n2, l2);
    }

    @NativeType(value="int")
    public static boolean glfwRawMouseMotionSupported() {
        long l = Functions.RawMouseMotionSupported;
        return JNI.invokeI(l) != 0;
    }

    public static long nglfwGetKeyName(int n, int n2) {
        long l = Functions.GetKeyName;
        return JNI.invokeP(n, n2, l);
    }

    @NativeType(value="char const *")
    public static @Nullable String glfwGetKeyName(int n, int n2) {
        long l = org.lwjgl.glfw.GLFW.nglfwGetKeyName(n, n2);
        return MemoryUtil.memUTF8Safe(l);
    }

    public static int glfwGetKeyScancode(int n) {
        long l = Functions.GetKeyScancode;
        return JNI.invokeI(n, l);
    }

    public static int glfwGetKey(@NativeType(value="GLFWwindow *") long l, int n) {
        long l2 = Functions.GetKey;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokePI(l, n, l2);
    }

    public static int glfwGetMouseButton(@NativeType(value="GLFWwindow *") long l, int n) {
        long l2 = Functions.GetMouseButton;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokePI(l, n, l2);
    }

    public static void nglfwGetCursorPos(long l, long l2, long l3) {
        long l4 = Functions.GetCursorPos;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePPPV(l, l2, l3, l4);
    }

    public static void glfwGetCursorPos(@NativeType(value="GLFWwindow *") long l, @NativeType(value="double *") @Nullable DoubleBuffer doubleBuffer, @NativeType(value="double *") @Nullable DoubleBuffer doubleBuffer2) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)doubleBuffer, 1);
            Checks.checkSafe((Buffer)doubleBuffer2, 1);
        }
        org.lwjgl.glfw.GLFW.nglfwGetCursorPos(l, MemoryUtil.memAddressSafe(doubleBuffer), MemoryUtil.memAddressSafe(doubleBuffer2));
    }

    public static void glfwSetCursorPos(@NativeType(value="GLFWwindow *") long l, double d, double d2) {
        long l2 = Functions.SetCursorPos;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePV(l, d, d2, l2);
    }

    public static long nglfwCreateCursor(long l, int n, int n2) {
        long l2 = Functions.CreateCursor;
        if (Checks.CHECKS) {
            GLFWImage.validate(l);
        }
        return JNI.invokePP(l, n, n2, l2);
    }

    @NativeType(value="GLFWcursor *")
    public static long glfwCreateCursor(@NativeType(value="GLFWimage const *") GLFWImage gLFWImage, int n, int n2) {
        return org.lwjgl.glfw.GLFW.nglfwCreateCursor(gLFWImage.address(), n, n2);
    }

    @NativeType(value="GLFWcursor *")
    public static long glfwCreateStandardCursor(int n) {
        long l = Functions.CreateStandardCursor;
        return JNI.invokeP(n, l);
    }

    public static void glfwDestroyCursor(@NativeType(value="GLFWcursor *") long l) {
        long l2 = Functions.DestroyCursor;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePV(l, l2);
    }

    public static void glfwSetCursor(@NativeType(value="GLFWwindow *") long l, @NativeType(value="GLFWcursor *") long l2) {
        long l3 = Functions.SetCursor;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePPV(l, l2, l3);
    }

    public static void nglfwGetPreeditCursorRectangle(long l, long l2, long l3, long l4, long l5) {
        long l6 = Functions.GetPreeditCursorRectangle;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePPPPPV(l, l2, l3, l4, l5, l6);
    }

    public static void glfwGetPreeditCursorRectangle(@NativeType(value="GLFWwindow *") long l, @NativeType(value="int *") @Nullable IntBuffer intBuffer, @NativeType(value="int *") @Nullable IntBuffer intBuffer2, @NativeType(value="int *") @Nullable IntBuffer intBuffer3, @NativeType(value="int *") @Nullable IntBuffer intBuffer4) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
            Checks.checkSafe((Buffer)intBuffer2, 1);
            Checks.checkSafe((Buffer)intBuffer3, 1);
            Checks.checkSafe((Buffer)intBuffer4, 1);
        }
        org.lwjgl.glfw.GLFW.nglfwGetPreeditCursorRectangle(l, MemoryUtil.memAddressSafe(intBuffer), MemoryUtil.memAddressSafe(intBuffer2), MemoryUtil.memAddressSafe(intBuffer3), MemoryUtil.memAddressSafe(intBuffer4));
    }

    public static void glfwSetPreeditCursorRectangle(@NativeType(value="GLFWwindow *") long l, int n, int n2, int n3, int n4) {
        long l2 = Functions.SetPreeditCursorRectangle;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePV(l, n, n2, n3, n4, l2);
    }

    public static void glfwResetPreeditText(@NativeType(value="GLFWwindow *") long l) {
        long l2 = Functions.ResetPreeditText;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePV(l, l2);
    }

    public static long nglfwGetPreeditCandidate(long l, int n, long l2) {
        long l3 = Functions.GetPreeditCandidate;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokePPP(l, n, l2, l3);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="unsigned int *")
    public static @Nullable IntBuffer glfwGetPreeditCandidate(@NativeType(value="GLFWwindow *") long l, int n) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        IntBuffer intBuffer = memoryStack.callocInt(1);
        try {
            long l2 = org.lwjgl.glfw.GLFW.nglfwGetPreeditCandidate(l, n, MemoryUtil.memAddress(intBuffer));
            IntBuffer intBuffer2 = MemoryUtil.memIntBufferSafe(l2, intBuffer.get(0));
            return intBuffer2;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static long nglfwSetKeyCallback(long l, long l2) {
        long l3 = Functions.SetKeyCallback;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokePPP(l, l2, l3);
    }

    @NativeType(value="GLFWkeyfun")
    public static @Nullable GLFWKeyCallback glfwSetKeyCallback(@NativeType(value="GLFWwindow *") long l, @NativeType(value="GLFWkeyfun") @Nullable GLFWKeyCallbackI gLFWKeyCallbackI) {
        return GLFWKeyCallback.createSafe(org.lwjgl.glfw.GLFW.nglfwSetKeyCallback(l, MemoryUtil.memAddressSafe(gLFWKeyCallbackI)));
    }

    public static long nglfwSetCharCallback(long l, long l2) {
        long l3 = Functions.SetCharCallback;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokePPP(l, l2, l3);
    }

    @NativeType(value="GLFWcharfun")
    public static @Nullable GLFWCharCallback glfwSetCharCallback(@NativeType(value="GLFWwindow *") long l, @NativeType(value="GLFWcharfun") @Nullable GLFWCharCallbackI gLFWCharCallbackI) {
        return GLFWCharCallback.createSafe(org.lwjgl.glfw.GLFW.nglfwSetCharCallback(l, MemoryUtil.memAddressSafe(gLFWCharCallbackI)));
    }

    public static long nglfwSetCharModsCallback(long l, long l2) {
        long l3 = Functions.SetCharModsCallback;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokePPP(l, l2, l3);
    }

    @NativeType(value="GLFWcharmodsfun")
    public static @Nullable GLFWCharModsCallback glfwSetCharModsCallback(@NativeType(value="GLFWwindow *") long l, @NativeType(value="GLFWcharmodsfun") @Nullable GLFWCharModsCallbackI gLFWCharModsCallbackI) {
        return GLFWCharModsCallback.createSafe(org.lwjgl.glfw.GLFW.nglfwSetCharModsCallback(l, MemoryUtil.memAddressSafe(gLFWCharModsCallbackI)));
    }

    public static long nglfwSetPreeditCallback(long l, long l2) {
        long l3 = Functions.SetPreeditCallback;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokePPP(l, l2, l3);
    }

    @NativeType(value="GLFWpreeditfun")
    public static @Nullable GLFWPreeditCallback glfwSetPreeditCallback(@NativeType(value="GLFWwindow *") long l, @NativeType(value="GLFWpreeditfun") @Nullable GLFWPreeditCallbackI gLFWPreeditCallbackI) {
        return GLFWPreeditCallback.createSafe(org.lwjgl.glfw.GLFW.nglfwSetPreeditCallback(l, MemoryUtil.memAddressSafe(gLFWPreeditCallbackI)));
    }

    public static long nglfwSetIMEStatusCallback(long l, long l2) {
        long l3 = Functions.SetIMEStatusCallback;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokePPP(l, l2, l3);
    }

    @NativeType(value="GLFWimestatusfun")
    public static @Nullable GLFWIMEStatusCallback glfwSetIMEStatusCallback(@NativeType(value="GLFWwindow *") long l, @NativeType(value="GLFWimestatusfun") @Nullable GLFWIMEStatusCallbackI gLFWIMEStatusCallbackI) {
        return GLFWIMEStatusCallback.createSafe(org.lwjgl.glfw.GLFW.nglfwSetIMEStatusCallback(l, MemoryUtil.memAddressSafe(gLFWIMEStatusCallbackI)));
    }

    public static long nglfwSetPreeditCandidateCallback(long l, long l2) {
        long l3 = Functions.SetPreeditCandidateCallback;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokePPP(l, l2, l3);
    }

    @NativeType(value="GLFWpreeditcandidatefun")
    public static @Nullable GLFWPreeditCandidateCallback glfwSetPreeditCandidateCallback(@NativeType(value="GLFWwindow *") long l, @NativeType(value="GLFWpreeditcandidatefun") @Nullable GLFWPreeditCandidateCallbackI gLFWPreeditCandidateCallbackI) {
        return GLFWPreeditCandidateCallback.createSafe(org.lwjgl.glfw.GLFW.nglfwSetPreeditCandidateCallback(l, MemoryUtil.memAddressSafe(gLFWPreeditCandidateCallbackI)));
    }

    public static long nglfwSetMouseButtonCallback(long l, long l2) {
        long l3 = Functions.SetMouseButtonCallback;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokePPP(l, l2, l3);
    }

    @NativeType(value="GLFWmousebuttonfun")
    public static @Nullable GLFWMouseButtonCallback glfwSetMouseButtonCallback(@NativeType(value="GLFWwindow *") long l, @NativeType(value="GLFWmousebuttonfun") @Nullable GLFWMouseButtonCallbackI gLFWMouseButtonCallbackI) {
        return GLFWMouseButtonCallback.createSafe(org.lwjgl.glfw.GLFW.nglfwSetMouseButtonCallback(l, MemoryUtil.memAddressSafe(gLFWMouseButtonCallbackI)));
    }

    public static long nglfwSetCursorPosCallback(long l, long l2) {
        long l3 = Functions.SetCursorPosCallback;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokePPP(l, l2, l3);
    }

    @NativeType(value="GLFWcursorposfun")
    public static @Nullable GLFWCursorPosCallback glfwSetCursorPosCallback(@NativeType(value="GLFWwindow *") long l, @NativeType(value="GLFWcursorposfun") @Nullable GLFWCursorPosCallbackI gLFWCursorPosCallbackI) {
        return GLFWCursorPosCallback.createSafe(org.lwjgl.glfw.GLFW.nglfwSetCursorPosCallback(l, MemoryUtil.memAddressSafe(gLFWCursorPosCallbackI)));
    }

    public static long nglfwSetCursorEnterCallback(long l, long l2) {
        long l3 = Functions.SetCursorEnterCallback;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokePPP(l, l2, l3);
    }

    @NativeType(value="GLFWcursorenterfun")
    public static @Nullable GLFWCursorEnterCallback glfwSetCursorEnterCallback(@NativeType(value="GLFWwindow *") long l, @NativeType(value="GLFWcursorenterfun") @Nullable GLFWCursorEnterCallbackI gLFWCursorEnterCallbackI) {
        return GLFWCursorEnterCallback.createSafe(org.lwjgl.glfw.GLFW.nglfwSetCursorEnterCallback(l, MemoryUtil.memAddressSafe(gLFWCursorEnterCallbackI)));
    }

    public static long nglfwSetScrollCallback(long l, long l2) {
        long l3 = Functions.SetScrollCallback;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokePPP(l, l2, l3);
    }

    @NativeType(value="GLFWscrollfun")
    public static @Nullable GLFWScrollCallback glfwSetScrollCallback(@NativeType(value="GLFWwindow *") long l, @NativeType(value="GLFWscrollfun") @Nullable GLFWScrollCallbackI gLFWScrollCallbackI) {
        return GLFWScrollCallback.createSafe(org.lwjgl.glfw.GLFW.nglfwSetScrollCallback(l, MemoryUtil.memAddressSafe(gLFWScrollCallbackI)));
    }

    public static long nglfwSetDropCallback(long l, long l2) {
        long l3 = Functions.SetDropCallback;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokePPP(l, l2, l3);
    }

    @NativeType(value="GLFWdropfun")
    public static @Nullable GLFWDropCallback glfwSetDropCallback(@NativeType(value="GLFWwindow *") long l, @NativeType(value="GLFWdropfun") @Nullable GLFWDropCallbackI gLFWDropCallbackI) {
        return GLFWDropCallback.createSafe(org.lwjgl.glfw.GLFW.nglfwSetDropCallback(l, MemoryUtil.memAddressSafe(gLFWDropCallbackI)));
    }

    @NativeType(value="int")
    public static boolean glfwJoystickPresent(int n) {
        long l = Functions.JoystickPresent;
        return JNI.invokeI(n, l) != 0;
    }

    public static long nglfwGetJoystickAxes(int n, long l) {
        long l2 = Functions.GetJoystickAxes;
        return JNI.invokePP(n, l, l2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="float const *")
    public static @Nullable FloatBuffer glfwGetJoystickAxes(int n) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        IntBuffer intBuffer = memoryStack.callocInt(1);
        try {
            long l = org.lwjgl.glfw.GLFW.nglfwGetJoystickAxes(n, MemoryUtil.memAddress(intBuffer));
            FloatBuffer floatBuffer = MemoryUtil.memFloatBufferSafe(l, intBuffer.get(0));
            return floatBuffer;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static long nglfwGetJoystickButtons(int n, long l) {
        long l2 = Functions.GetJoystickButtons;
        return JNI.invokePP(n, l, l2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="unsigned char const *")
    public static @Nullable ByteBuffer glfwGetJoystickButtons(int n) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        IntBuffer intBuffer = memoryStack.callocInt(1);
        try {
            long l = org.lwjgl.glfw.GLFW.nglfwGetJoystickButtons(n, MemoryUtil.memAddress(intBuffer));
            ByteBuffer byteBuffer = MemoryUtil.memByteBufferSafe(l, intBuffer.get(0));
            return byteBuffer;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static long nglfwGetJoystickHats(int n, long l) {
        long l2 = Functions.GetJoystickHats;
        return JNI.invokePP(n, l, l2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="unsigned char const *")
    public static @Nullable ByteBuffer glfwGetJoystickHats(int n) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        IntBuffer intBuffer = memoryStack.callocInt(1);
        try {
            long l = org.lwjgl.glfw.GLFW.nglfwGetJoystickHats(n, MemoryUtil.memAddress(intBuffer));
            ByteBuffer byteBuffer = MemoryUtil.memByteBufferSafe(l, intBuffer.get(0));
            return byteBuffer;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static long nglfwGetJoystickName(int n) {
        long l = Functions.GetJoystickName;
        return JNI.invokeP(n, l);
    }

    @NativeType(value="char const *")
    public static @Nullable String glfwGetJoystickName(int n) {
        long l = org.lwjgl.glfw.GLFW.nglfwGetJoystickName(n);
        return MemoryUtil.memUTF8Safe(l);
    }

    public static long nglfwGetJoystickGUID(int n) {
        long l = Functions.GetJoystickGUID;
        return JNI.invokeP(n, l);
    }

    @NativeType(value="char const *")
    public static @Nullable String glfwGetJoystickGUID(int n) {
        long l = org.lwjgl.glfw.GLFW.nglfwGetJoystickGUID(n);
        return MemoryUtil.memUTF8Safe(l);
    }

    public static void glfwSetJoystickUserPointer(int n, @NativeType(value="void *") long l) {
        long l2 = Functions.SetJoystickUserPointer;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePV(n, l, l2);
    }

    @NativeType(value="void *")
    public static long glfwGetJoystickUserPointer(int n) {
        long l = Functions.GetJoystickUserPointer;
        return JNI.invokeP(n, l);
    }

    @NativeType(value="int")
    public static boolean glfwJoystickIsGamepad(int n) {
        long l = Functions.JoystickIsGamepad;
        return JNI.invokeI(n, l) != 0;
    }

    public static long nglfwSetJoystickCallback(long l) {
        long l2 = Functions.SetJoystickCallback;
        return JNI.invokePP(l, l2);
    }

    @NativeType(value="GLFWjoystickfun")
    public static @Nullable GLFWJoystickCallback glfwSetJoystickCallback(@NativeType(value="GLFWjoystickfun") @Nullable GLFWJoystickCallbackI gLFWJoystickCallbackI) {
        return GLFWJoystickCallback.createSafe(org.lwjgl.glfw.GLFW.nglfwSetJoystickCallback(MemoryUtil.memAddressSafe(gLFWJoystickCallbackI)));
    }

    public static int nglfwUpdateGamepadMappings(long l) {
        long l2 = Functions.UpdateGamepadMappings;
        return JNI.invokePI(l, l2);
    }

    @NativeType(value="int")
    public static boolean glfwUpdateGamepadMappings(@NativeType(value="char const *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        return org.lwjgl.glfw.GLFW.nglfwUpdateGamepadMappings(MemoryUtil.memAddress(byteBuffer)) != 0;
    }

    public static long nglfwGetGamepadName(int n) {
        long l = Functions.GetGamepadName;
        return JNI.invokeP(n, l);
    }

    @NativeType(value="char const *")
    public static @Nullable String glfwGetGamepadName(int n) {
        long l = org.lwjgl.glfw.GLFW.nglfwGetGamepadName(n);
        return MemoryUtil.memUTF8Safe(l);
    }

    public static int nglfwGetGamepadState(int n, long l) {
        long l2 = Functions.GetGamepadState;
        return JNI.invokePI(n, l, l2);
    }

    @NativeType(value="int")
    public static boolean glfwGetGamepadState(int n, @NativeType(value="GLFWgamepadstate *") GLFWGamepadState gLFWGamepadState) {
        return org.lwjgl.glfw.GLFW.nglfwGetGamepadState(n, gLFWGamepadState.address()) != 0;
    }

    public static void nglfwSetClipboardString(long l, long l2) {
        long l3 = Functions.SetClipboardString;
        JNI.invokePPV(l, l2, l3);
    }

    public static void glfwSetClipboardString(@NativeType(value="GLFWwindow *") long l, @NativeType(value="char const *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        org.lwjgl.glfw.GLFW.nglfwSetClipboardString(l, MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glfwSetClipboardString(@NativeType(value="GLFWwindow *") long l, @NativeType(value="char const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            org.lwjgl.glfw.GLFW.nglfwSetClipboardString(l, l2);
        }
        finally {
            memoryStack.setPointer(n);
        }
    }

    public static long nglfwGetClipboardString(long l) {
        long l2 = Functions.GetClipboardString;
        return JNI.invokePP(l, l2);
    }

    @NativeType(value="char const *")
    public static @Nullable String glfwGetClipboardString(@NativeType(value="GLFWwindow *") long l) {
        long l2 = org.lwjgl.glfw.GLFW.nglfwGetClipboardString(l);
        return MemoryUtil.memUTF8Safe(l2);
    }

    public static double glfwGetTime() {
        long l = Functions.GetTime;
        return JNI.invokeD(l);
    }

    public static void glfwSetTime(double d) {
        long l = Functions.SetTime;
        JNI.invokeV(d, l);
    }

    @NativeType(value="uint64_t")
    public static long glfwGetTimerValue() {
        long l = Functions.GetTimerValue;
        return JNI.invokeJ(l);
    }

    @NativeType(value="uint64_t")
    public static long glfwGetTimerFrequency() {
        long l = Functions.GetTimerFrequency;
        return JNI.invokeJ(l);
    }

    public static void glfwMakeContextCurrent(@NativeType(value="GLFWwindow *") long l) {
        long l2 = Functions.MakeContextCurrent;
        JNI.invokePV(l, l2);
    }

    @NativeType(value="GLFWwindow *")
    public static long glfwGetCurrentContext() {
        long l = Functions.GetCurrentContext;
        return JNI.invokeP(l);
    }

    public static void glfwSwapBuffers(@NativeType(value="GLFWwindow *") long l) {
        long l2 = Functions.SwapBuffers;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePV(l, l2);
    }

    public static void glfwSwapInterval(int n) {
        long l = Functions.SwapInterval;
        JNI.invokeV(n, l);
    }

    public static int nglfwExtensionSupported(long l) {
        long l2 = Functions.ExtensionSupported;
        return JNI.invokePI(l, l2);
    }

    @NativeType(value="int")
    public static boolean glfwExtensionSupported(@NativeType(value="char const *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        return org.lwjgl.glfw.GLFW.nglfwExtensionSupported(MemoryUtil.memAddress(byteBuffer)) != 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="int")
    public static boolean glfwExtensionSupported(@NativeType(value="char const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n = memoryStack.getPointer();
        try {
            memoryStack.nASCII(charSequence, true);
            long l = memoryStack.getPointerAddress();
            boolean bl = org.lwjgl.glfw.GLFW.nglfwExtensionSupported(l) != 0;
            return bl;
        }
        finally {
            memoryStack.setPointer(n);
        }
    }

    public static long nglfwGetProcAddress(long l) {
        long l2 = Functions.GetProcAddress;
        return JNI.invokePP(l, l2);
    }

    @NativeType(value="GLFWglproc")
    public static long glfwGetProcAddress(@NativeType(value="char const *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        return org.lwjgl.glfw.GLFW.nglfwGetProcAddress(MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="GLFWglproc")
    public static long glfwGetProcAddress(@NativeType(value="char const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n = memoryStack.getPointer();
        try {
            memoryStack.nASCII(charSequence, true);
            long l = memoryStack.getPointerAddress();
            long l2 = org.lwjgl.glfw.GLFW.nglfwGetProcAddress(l);
            return l2;
        }
        finally {
            memoryStack.setPointer(n);
        }
    }

    public static void glfwGetVersion(@NativeType(value="int *") int @Nullable [] nArray, @NativeType(value="int *") int @Nullable [] nArray2, @NativeType(value="int *") int @Nullable [] nArray3) {
        long l = Functions.GetVersion;
        if (Checks.CHECKS) {
            Checks.checkSafe(nArray, 1);
            Checks.checkSafe(nArray2, 1);
            Checks.checkSafe(nArray3, 1);
        }
        JNI.invokePPPV(nArray, nArray2, nArray3, l);
    }

    public static void glfwGetMonitorPos(@NativeType(value="GLFWmonitor *") long l, @NativeType(value="int *") int @Nullable [] nArray, @NativeType(value="int *") int @Nullable [] nArray2) {
        long l2 = Functions.GetMonitorPos;
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.checkSafe(nArray, 1);
            Checks.checkSafe(nArray2, 1);
        }
        JNI.invokePPPV(l, nArray, nArray2, l2);
    }

    public static void glfwGetMonitorWorkarea(@NativeType(value="GLFWmonitor *") long l, @NativeType(value="int *") int @Nullable [] nArray, @NativeType(value="int *") int @Nullable [] nArray2, @NativeType(value="int *") int @Nullable [] nArray3, @NativeType(value="int *") int @Nullable [] nArray4) {
        long l2 = Functions.GetMonitorWorkarea;
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.checkSafe(nArray, 1);
            Checks.checkSafe(nArray2, 1);
            Checks.checkSafe(nArray3, 1);
            Checks.checkSafe(nArray4, 1);
        }
        JNI.invokePPPPPV(l, nArray, nArray2, nArray3, nArray4, l2);
    }

    public static void glfwGetMonitorPhysicalSize(@NativeType(value="GLFWmonitor *") long l, @NativeType(value="int *") int @Nullable [] nArray, @NativeType(value="int *") int @Nullable [] nArray2) {
        long l2 = Functions.GetMonitorPhysicalSize;
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.checkSafe(nArray, 1);
            Checks.checkSafe(nArray2, 1);
        }
        JNI.invokePPPV(l, nArray, nArray2, l2);
    }

    public static void glfwGetMonitorContentScale(@NativeType(value="GLFWmonitor *") long l, @NativeType(value="float *") float @Nullable [] fArray, @NativeType(value="float *") float @Nullable [] fArray2) {
        long l2 = Functions.GetMonitorContentScale;
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.checkSafe(fArray, 1);
            Checks.checkSafe(fArray2, 1);
        }
        JNI.invokePPPV(l, fArray, fArray2, l2);
    }

    public static void glfwGetWindowPos(@NativeType(value="GLFWwindow *") long l, @NativeType(value="int *") int @Nullable [] nArray, @NativeType(value="int *") int @Nullable [] nArray2) {
        long l2 = Functions.GetWindowPos;
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.checkSafe(nArray, 1);
            Checks.checkSafe(nArray2, 1);
        }
        JNI.invokePPPV(l, nArray, nArray2, l2);
    }

    public static void glfwGetWindowSize(@NativeType(value="GLFWwindow *") long l, @NativeType(value="int *") int @Nullable [] nArray, @NativeType(value="int *") int @Nullable [] nArray2) {
        long l2 = Functions.GetWindowSize;
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.checkSafe(nArray, 1);
            Checks.checkSafe(nArray2, 1);
        }
        JNI.invokePPPV(l, nArray, nArray2, l2);
    }

    public static void glfwGetFramebufferSize(@NativeType(value="GLFWwindow *") long l, @NativeType(value="int *") int @Nullable [] nArray, @NativeType(value="int *") int @Nullable [] nArray2) {
        long l2 = Functions.GetFramebufferSize;
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.checkSafe(nArray, 1);
            Checks.checkSafe(nArray2, 1);
        }
        JNI.invokePPPV(l, nArray, nArray2, l2);
    }

    public static void glfwGetWindowFrameSize(@NativeType(value="GLFWwindow *") long l, @NativeType(value="int *") int @Nullable [] nArray, @NativeType(value="int *") int @Nullable [] nArray2, @NativeType(value="int *") int @Nullable [] nArray3, @NativeType(value="int *") int @Nullable [] nArray4) {
        long l2 = Functions.GetWindowFrameSize;
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.checkSafe(nArray, 1);
            Checks.checkSafe(nArray2, 1);
            Checks.checkSafe(nArray3, 1);
            Checks.checkSafe(nArray4, 1);
        }
        JNI.invokePPPPPV(l, nArray, nArray2, nArray3, nArray4, l2);
    }

    public static void glfwGetWindowContentScale(@NativeType(value="GLFWwindow *") long l, @NativeType(value="float *") float @Nullable [] fArray, @NativeType(value="float *") float @Nullable [] fArray2) {
        long l2 = Functions.GetWindowContentScale;
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.checkSafe(fArray, 1);
            Checks.checkSafe(fArray2, 1);
        }
        JNI.invokePPPV(l, fArray, fArray2, l2);
    }

    public static void glfwGetCursorPos(@NativeType(value="GLFWwindow *") long l, @NativeType(value="double *") double @Nullable [] dArray, @NativeType(value="double *") double @Nullable [] dArray2) {
        long l2 = Functions.GetCursorPos;
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.checkSafe(dArray, 1);
            Checks.checkSafe(dArray2, 1);
        }
        JNI.invokePPPV(l, dArray, dArray2, l2);
    }

    public static void glfwGetPreeditCursorRectangle(@NativeType(value="GLFWwindow *") long l, @NativeType(value="int *") int @Nullable [] nArray, @NativeType(value="int *") int @Nullable [] nArray2, @NativeType(value="int *") int @Nullable [] nArray3, @NativeType(value="int *") int @Nullable [] nArray4) {
        long l2 = Functions.GetPreeditCursorRectangle;
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.checkSafe(nArray, 1);
            Checks.checkSafe(nArray2, 1);
            Checks.checkSafe(nArray3, 1);
            Checks.checkSafe(nArray4, 1);
        }
        JNI.invokePPPPPV(l, nArray, nArray2, nArray3, nArray4, l2);
    }

    static /* synthetic */ SharedLibrary access$000() {
        return GLFW;
    }

    public static final class Functions {
        public static final long Init = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwInit");
        public static final long Terminate = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwTerminate");
        public static final long InitHint = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwInitHint");
        public static final long InitAllocator = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwInitAllocator");
        public static final long GetVersion = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetVersion");
        public static final long GetVersionString = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetVersionString");
        public static final long GetError = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetError");
        public static final long SetErrorCallback = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetErrorCallback");
        public static final long GetPlatform = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetPlatform");
        public static final long PlatformSupported = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwPlatformSupported");
        public static final long GetMonitors = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetMonitors");
        public static final long GetPrimaryMonitor = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetPrimaryMonitor");
        public static final long GetMonitorPos = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetMonitorPos");
        public static final long GetMonitorWorkarea = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetMonitorWorkarea");
        public static final long GetMonitorPhysicalSize = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetMonitorPhysicalSize");
        public static final long GetMonitorContentScale = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetMonitorContentScale");
        public static final long GetMonitorName = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetMonitorName");
        public static final long SetMonitorUserPointer = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetMonitorUserPointer");
        public static final long GetMonitorUserPointer = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetMonitorUserPointer");
        public static final long SetMonitorCallback = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetMonitorCallback");
        public static final long GetVideoModes = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetVideoModes");
        public static final long GetVideoMode = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetVideoMode");
        public static final long SetGamma = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetGamma");
        public static final long GetGammaRamp = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetGammaRamp");
        public static final long SetGammaRamp = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetGammaRamp");
        public static final long DefaultWindowHints = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwDefaultWindowHints");
        public static final long WindowHint = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwWindowHint");
        public static final long WindowHintString = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwWindowHintString");
        public static final long CreateWindow = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwCreateWindow");
        public static final long DestroyWindow = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwDestroyWindow");
        public static final long WindowShouldClose = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwWindowShouldClose");
        public static final long SetWindowShouldClose = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetWindowShouldClose");
        public static final long GetWindowTitle = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetWindowTitle");
        public static final long SetWindowTitle = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetWindowTitle");
        public static final long SetWindowIcon = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetWindowIcon");
        public static final long GetWindowPos = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetWindowPos");
        public static final long SetWindowPos = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetWindowPos");
        public static final long GetWindowSize = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetWindowSize");
        public static final long SetWindowSizeLimits = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetWindowSizeLimits");
        public static final long SetWindowAspectRatio = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetWindowAspectRatio");
        public static final long SetWindowSize = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetWindowSize");
        public static final long GetFramebufferSize = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetFramebufferSize");
        public static final long GetWindowFrameSize = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetWindowFrameSize");
        public static final long GetWindowContentScale = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetWindowContentScale");
        public static final long GetWindowOpacity = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetWindowOpacity");
        public static final long SetWindowOpacity = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetWindowOpacity");
        public static final long IconifyWindow = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwIconifyWindow");
        public static final long RestoreWindow = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwRestoreWindow");
        public static final long MaximizeWindow = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwMaximizeWindow");
        public static final long ShowWindow = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwShowWindow");
        public static final long HideWindow = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwHideWindow");
        public static final long FocusWindow = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwFocusWindow");
        public static final long RequestWindowAttention = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwRequestWindowAttention");
        public static final long GetWindowMonitor = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetWindowMonitor");
        public static final long SetWindowMonitor = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetWindowMonitor");
        public static final long GetWindowAttrib = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetWindowAttrib");
        public static final long SetWindowAttrib = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetWindowAttrib");
        public static final long SetWindowUserPointer = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetWindowUserPointer");
        public static final long GetWindowUserPointer = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetWindowUserPointer");
        public static final long SetWindowPosCallback = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetWindowPosCallback");
        public static final long SetWindowSizeCallback = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetWindowSizeCallback");
        public static final long SetWindowCloseCallback = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetWindowCloseCallback");
        public static final long SetWindowRefreshCallback = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetWindowRefreshCallback");
        public static final long SetWindowFocusCallback = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetWindowFocusCallback");
        public static final long SetWindowIconifyCallback = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetWindowIconifyCallback");
        public static final long SetWindowMaximizeCallback = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetWindowMaximizeCallback");
        public static final long SetFramebufferSizeCallback = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetFramebufferSizeCallback");
        public static final long SetWindowContentScaleCallback = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetWindowContentScaleCallback");
        public static final long PollEvents = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwPollEvents");
        public static final long WaitEvents = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwWaitEvents");
        public static final long WaitEventsTimeout = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwWaitEventsTimeout");
        public static final long PostEmptyEvent = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwPostEmptyEvent");
        public static final long GetInputMode = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetInputMode");
        public static final long SetInputMode = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetInputMode");
        public static final long RawMouseMotionSupported = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwRawMouseMotionSupported");
        public static final long GetKeyName = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetKeyName");
        public static final long GetKeyScancode = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetKeyScancode");
        public static final long GetKey = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetKey");
        public static final long GetMouseButton = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetMouseButton");
        public static final long GetCursorPos = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetCursorPos");
        public static final long SetCursorPos = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetCursorPos");
        public static final long CreateCursor = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwCreateCursor");
        public static final long CreateStandardCursor = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwCreateStandardCursor");
        public static final long DestroyCursor = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwDestroyCursor");
        public static final long SetCursor = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetCursor");
        public static final long GetPreeditCursorRectangle = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetPreeditCursorRectangle");
        public static final long SetPreeditCursorRectangle = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetPreeditCursorRectangle");
        public static final long ResetPreeditText = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwResetPreeditText");
        public static final long GetPreeditCandidate = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetPreeditCandidate");
        public static final long SetKeyCallback = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetKeyCallback");
        public static final long SetCharCallback = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetCharCallback");
        public static final long SetCharModsCallback = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetCharModsCallback");
        public static final long SetPreeditCallback = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetPreeditCallback");
        public static final long SetIMEStatusCallback = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetIMEStatusCallback");
        public static final long SetPreeditCandidateCallback = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetPreeditCandidateCallback");
        public static final long SetMouseButtonCallback = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetMouseButtonCallback");
        public static final long SetCursorPosCallback = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetCursorPosCallback");
        public static final long SetCursorEnterCallback = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetCursorEnterCallback");
        public static final long SetScrollCallback = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetScrollCallback");
        public static final long SetDropCallback = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetDropCallback");
        public static final long JoystickPresent = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwJoystickPresent");
        public static final long GetJoystickAxes = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetJoystickAxes");
        public static final long GetJoystickButtons = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetJoystickButtons");
        public static final long GetJoystickHats = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetJoystickHats");
        public static final long GetJoystickName = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetJoystickName");
        public static final long GetJoystickGUID = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetJoystickGUID");
        public static final long SetJoystickUserPointer = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetJoystickUserPointer");
        public static final long GetJoystickUserPointer = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetJoystickUserPointer");
        public static final long JoystickIsGamepad = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwJoystickIsGamepad");
        public static final long SetJoystickCallback = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetJoystickCallback");
        public static final long UpdateGamepadMappings = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwUpdateGamepadMappings");
        public static final long GetGamepadName = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetGamepadName");
        public static final long GetGamepadState = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetGamepadState");
        public static final long SetClipboardString = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetClipboardString");
        public static final long GetClipboardString = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetClipboardString");
        public static final long GetTime = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetTime");
        public static final long SetTime = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSetTime");
        public static final long GetTimerValue = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetTimerValue");
        public static final long GetTimerFrequency = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetTimerFrequency");
        public static final long MakeContextCurrent = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwMakeContextCurrent");
        public static final long GetCurrentContext = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetCurrentContext");
        public static final long SwapBuffers = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSwapBuffers");
        public static final long SwapInterval = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwSwapInterval");
        public static final long ExtensionSupported = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwExtensionSupported");
        public static final long GetProcAddress = APIUtil.apiGetFunctionAddress(org.lwjgl.glfw.GLFW.access$000(), "glfwGetProcAddress");

        private Functions() {
        }
    }
}


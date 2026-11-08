/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna.platform;

import com.sun.jna.Platform;
import com.sun.jna.platform.unix.X11;
import com.sun.jna.platform.win32.User32;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;

public class KeyboardUtils {
    static final NativeKeyboardUtils INSTANCE;

    public static boolean isPressed(int n, int n2) {
        return INSTANCE.isPressed(n, n2);
    }

    public static boolean isPressed(int n) {
        return INSTANCE.isPressed(n);
    }

    static {
        if (GraphicsEnvironment.isHeadless()) {
            throw new HeadlessException("KeyboardUtils requires a keyboard");
        }
        if (Platform.isWindows()) {
            INSTANCE = new W32KeyboardUtils();
        } else {
            if (Platform.isMac()) {
                INSTANCE = new MacKeyboardUtils();
                throw new UnsupportedOperationException("No support (yet) for " + System.getProperty("os.name"));
            }
            INSTANCE = new X11KeyboardUtils();
        }
    }

    private static class X11KeyboardUtils
    extends NativeKeyboardUtils {
        private X11KeyboardUtils() {
        }

        private int toKeySym(int n, int n2) {
            if (n >= 65 && n <= 90) {
                return 97 + (n - 65);
            }
            if (n >= 48 && n <= 57) {
                return 48 + (n - 48);
            }
            if (n == 16) {
                if ((n2 & 3) != 0) {
                    return 65505;
                }
                return 65505;
            }
            if (n == 17) {
                if ((n2 & 3) != 0) {
                    return 65508;
                }
                return 65507;
            }
            if (n == 18) {
                if ((n2 & 3) != 0) {
                    return 65514;
                }
                return 65513;
            }
            if (n == 157) {
                if ((n2 & 3) != 0) {
                    return 65512;
                }
                return 65511;
            }
            return 0;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public boolean isPressed(int n, int n2) {
            X11 x11 = X11.INSTANCE;
            X11.Display display = x11.XOpenDisplay(null);
            if (display == null) {
                throw new Error("Can't open X Display");
            }
            try {
                byte[] byArray = new byte[32];
                x11.XQueryKeymap(display, byArray);
                int n3 = this.toKeySym(n, n2);
                for (int i = 5; i < 256; ++i) {
                    int n4;
                    int n5 = i / 8;
                    int n6 = i % 8;
                    if ((byArray[n5] & 1 << n6) == 0 || (n4 = x11.XKeycodeToKeysym(display, (byte)i, 0).intValue()) != n3) continue;
                    boolean bl = true;
                    return bl;
                }
            }
            finally {
                x11.XCloseDisplay(display);
            }
            return false;
        }
    }

    private static class MacKeyboardUtils
    extends NativeKeyboardUtils {
        private MacKeyboardUtils() {
        }

        public boolean isPressed(int n, int n2) {
            return false;
        }
    }

    private static class W32KeyboardUtils
    extends NativeKeyboardUtils {
        private W32KeyboardUtils() {
        }

        private int toNative(int n, int n2) {
            if (n >= 65 && n <= 90 || n >= 48 && n <= 57) {
                return n;
            }
            if (n == 16) {
                if ((n2 & 3) != 0) {
                    return 161;
                }
                if ((n2 & 2) != 0) {
                    return 160;
                }
                return 16;
            }
            if (n == 17) {
                if ((n2 & 3) != 0) {
                    return 163;
                }
                if ((n2 & 2) != 0) {
                    return 162;
                }
                return 17;
            }
            if (n == 18) {
                if ((n2 & 3) != 0) {
                    return 165;
                }
                if ((n2 & 2) != 0) {
                    return 164;
                }
                return 18;
            }
            return 0;
        }

        public boolean isPressed(int n, int n2) {
            User32 user32 = User32.INSTANCE;
            return (user32.GetAsyncKeyState(this.toNative(n, n2)) & 0x8000) != 0;
        }
    }

    private static abstract class NativeKeyboardUtils {
        private NativeKeyboardUtils() {
        }

        public abstract boolean isPressed(int var1, int var2);

        public boolean isPressed(int n) {
            return this.isPressed(n, 0);
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl;

import java.security.AccessController;
import java.security.PrivilegedAction;

public class LWJGLUtil {
    public static final boolean DEBUG = LWJGLUtil.getPrivilegedBoolean("org.lwjgl.util.Debug");

    public static boolean getPrivilegedBoolean(final String string) {
        return AccessController.doPrivileged(new PrivilegedAction<Boolean>(){

            @Override
            public Boolean run() {
                return Boolean.getBoolean(string);
            }
        });
    }

    public static String translateGLErrorString(int n) {
        switch (n) {
            case 0: {
                return "No error";
            }
            case 1280: {
                return "Invalid enum";
            }
            case 1281: {
                return "Invalid value";
            }
            case 1282: {
                return "Invalid operation";
            }
            case 1283: {
                return "Stack overflow";
            }
            case 1284: {
                return "Stack underflow";
            }
            case 1285: {
                return "Out of memory";
            }
            case 32817: {
                return "Table too large";
            }
            case 1286: {
                return "Invalid framebuffer operation";
            }
        }
        return null;
    }

    public static void log(String string) {
        System.out.println(string);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna;

import com.sun.jna.Native;

public class Platform {
    public static final int UNSPECIFIED = -1;
    public static final int MAC = 0;
    public static final int LINUX = 1;
    public static final int WINDOWS = 2;
    public static final int SOLARIS = 3;
    public static final int FREEBSD = 4;
    public static final int OPENBSD = 5;
    public static final int WINDOWSCE = 6;
    public static final boolean RO_FIELDS;
    public static final boolean HAS_BUFFERS;
    public static final boolean HAS_AWT;
    public static final String MATH_LIBRARY_NAME;
    public static final String C_LIBRARY_NAME;
    private static final int osType;

    private Platform() {
    }

    public static final int getOSType() {
        return osType;
    }

    public static final boolean isMac() {
        return osType == 0;
    }

    public static final boolean isLinux() {
        return osType == 1;
    }

    public static final boolean isWindowsCE() {
        return osType == 6;
    }

    public static final boolean isWindows() {
        return osType == 2 || osType == 6;
    }

    public static final boolean isSolaris() {
        return osType == 3;
    }

    public static final boolean isFreeBSD() {
        return osType == 4;
    }

    public static final boolean isOpenBSD() {
        return osType == 5;
    }

    public static final boolean isX11() {
        return !Platform.isWindows() && !Platform.isMac();
    }

    public static final boolean hasRuntimeExec() {
        return !Platform.isWindowsCE() || !"J9".equals(System.getProperty("java.vm.name"));
    }

    public static final boolean is64Bit() {
        String string = System.getProperty("sun.arch.data.model", System.getProperty("com.ibm.vm.bitmode"));
        if (string != null) {
            return "64".equals(string);
        }
        String string2 = System.getProperty("os.arch").toLowerCase();
        if ("x86_64".equals(string2) || "ia64".equals(string2) || "ppc64".equals(string2) || "sparcv9".equals(string2) || "amd64".equals(string2)) {
            return true;
        }
        return Native.POINTER_SIZE == 8;
    }

    public static final boolean isIntel() {
        String string = System.getProperty("os.arch").toLowerCase().trim();
        return string.equals("i386") || string.equals("x86") || string.equals("x86_64") || string.equals("amd64");
    }

    public static final boolean isPPC() {
        String string = System.getProperty("os.arch").toLowerCase().trim();
        return string.equals("ppc") || string.equals("ppc64") || string.equals("powerpc") || string.equals("powerpc64");
    }

    public static final boolean isARM() {
        String string = System.getProperty("os.arch").toLowerCase().trim();
        return string.equals("arm");
    }

    static {
        String string = System.getProperty("os.name");
        osType = string.startsWith("Linux") ? 1 : (string.startsWith("Mac") || string.startsWith("Darwin") ? 0 : (string.startsWith("Windows CE") ? 6 : (string.startsWith("Windows") ? 2 : (string.startsWith("Solaris") || string.startsWith("SunOS") ? 3 : (string.startsWith("FreeBSD") ? 4 : (string.startsWith("OpenBSD") ? 5 : -1))))));
        boolean bl = false;
        try {
            Class.forName("java.awt.Component");
            bl = true;
        }
        catch (ClassNotFoundException classNotFoundException) {
            // empty catch block
        }
        HAS_AWT = bl;
        boolean bl2 = false;
        try {
            Class.forName("java.nio.Buffer");
            bl2 = true;
        }
        catch (ClassNotFoundException classNotFoundException) {
            // empty catch block
        }
        HAS_BUFFERS = bl2;
        boolean bl3 = RO_FIELDS = osType != 6;
        String string2 = osType == 2 ? "msvcrt" : (C_LIBRARY_NAME = osType == 6 ? "coredll" : "c");
        MATH_LIBRARY_NAME = osType == 2 ? "msvcrt" : (osType == 6 ? "coredll" : "m");
    }
}


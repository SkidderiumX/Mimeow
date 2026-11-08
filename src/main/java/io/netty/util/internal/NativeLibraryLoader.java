/*
 * Decompiled with CFR 0.152.
 */
package io.netty.util.internal;

import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Locale;

public class NativeLibraryLoader {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(NativeLibraryLoader.class);
    private static final String NATIVE_RESOURCE_HOME = "META-INF/native/";
    private static final String OSNAME = SystemPropertyUtil.get("os.name", "").toLowerCase(Locale.US).replaceAll("[^a-z0-9]+", "");
    private static final File WORKDIR;

    private static File tmpdir() {
        File file;
        try {
            file = NativeLibraryLoader.toDirectory(SystemPropertyUtil.get("io.netty.tmpdir"));
            if (file != null) {
                logger.debug("-Dio.netty.tmpdir: " + file);
                return file;
            }
            file = NativeLibraryLoader.toDirectory(SystemPropertyUtil.get("java.io.tmpdir"));
            if (file != null) {
                logger.debug("-Dio.netty.tmpdir: " + file + " (java.io.tmpdir)");
                return file;
            }
            if (NativeLibraryLoader.isWindows()) {
                file = NativeLibraryLoader.toDirectory(System.getenv("TEMP"));
                if (file != null) {
                    logger.debug("-Dio.netty.tmpdir: " + file + " (%TEMP%)");
                    return file;
                }
                String string = System.getenv("USERPROFILE");
                if (string != null) {
                    file = NativeLibraryLoader.toDirectory(string + "\\AppData\\Local\\Temp");
                    if (file != null) {
                        logger.debug("-Dio.netty.tmpdir: " + file + " (%USERPROFILE%\\AppData\\Local\\Temp)");
                        return file;
                    }
                    file = NativeLibraryLoader.toDirectory(string + "\\Local Settings\\Temp");
                    if (file != null) {
                        logger.debug("-Dio.netty.tmpdir: " + file + " (%USERPROFILE%\\Local Settings\\Temp)");
                        return file;
                    }
                }
            } else {
                file = NativeLibraryLoader.toDirectory(System.getenv("TMPDIR"));
                if (file != null) {
                    logger.debug("-Dio.netty.tmpdir: " + file + " ($TMPDIR)");
                    return file;
                }
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        file = NativeLibraryLoader.isWindows() ? new File("C:\\Windows\\Temp") : new File("/tmp");
        logger.warn("Failed to get the temporary directory; falling back to: " + file);
        return file;
    }

    private static File toDirectory(String string) {
        if (string == null) {
            return null;
        }
        File file = new File(string);
        file.mkdirs();
        if (!file.isDirectory()) {
            return null;
        }
        try {
            return file.getAbsoluteFile();
        }
        catch (Exception exception) {
            return file;
        }
    }

    private static boolean isWindows() {
        return OSNAME.startsWith("windows");
    }

    private static boolean isOSX() {
        return OSNAME.startsWith("macosx") || OSNAME.startsWith("osx");
    }

    public static void load(String string, ClassLoader classLoader) {
        String string2 = System.mapLibraryName(string);
        String string3 = NATIVE_RESOURCE_HOME + string2;
        URL uRL = classLoader.getResource(string3);
        if (uRL == null && NativeLibraryLoader.isOSX()) {
            uRL = string3.endsWith(".jnilib") ? classLoader.getResource("META-INF/native/lib" + string + ".dynlib") : classLoader.getResource("META-INF/native/lib" + string + ".jnilib");
        }
        if (uRL == null) {
            System.loadLibrary(string);
            return;
        }
        int n = string2.lastIndexOf(46);
        String string4 = string2.substring(0, n);
        String string5 = string2.substring(n, string2.length());
        InputStream inputStream2 = null;
        OutputStream outputStream2 = null;
        File file = null;
        boolean bl = false;
        try {
            int n2;
            file = File.createTempFile(string4, string5, WORKDIR);
            inputStream2 = uRL.openStream();
            outputStream2 = new FileOutputStream(file);
            byte[] byArray = new byte[8192];
            while ((n2 = inputStream2.read(byArray)) > 0) {
                outputStream2.write(byArray, 0, n2);
            }
            outputStream2.flush();
            outputStream2.close();
            outputStream2 = null;
            System.load(file.getPath());
            bl = true;
        }
        catch (Exception exception) {
            throw (UnsatisfiedLinkError)new UnsatisfiedLinkError("could not load a native library: " + string).initCause(exception);
        }
        finally {
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                }
                catch (IOException iOException) {}
            }
            if (outputStream2 != null) {
                try {
                    outputStream2.close();
                }
                catch (IOException iOException) {}
            }
            if (file != null) {
                if (bl) {
                    file.deleteOnExit();
                } else if (!file.delete()) {
                    file.deleteOnExit();
                }
            }
        }
    }

    private NativeLibraryLoader() {
    }

    static {
        String string = SystemPropertyUtil.get("io.netty.native.workdir");
        if (string != null) {
            File file = new File(string);
            file.mkdirs();
            try {
                file = file.getAbsoluteFile();
            }
            catch (Exception exception) {
                // empty catch block
            }
            WORKDIR = file;
            logger.debug("-Dio.netty.netty.workdir: " + WORKDIR);
        } else {
            WORKDIR = NativeLibraryLoader.tmpdir();
            logger.debug("-Dio.netty.netty.workdir: " + WORKDIR + " (io.netty.tmpdir)");
        }
    }
}


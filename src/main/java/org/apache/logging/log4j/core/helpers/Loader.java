/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.helpers;

import java.io.InputStream;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.helpers.OptionConverter;
import org.apache.logging.log4j.status.StatusLogger;
import org.apache.logging.log4j.util.PropertiesUtil;

public class Loader {
    private static boolean ignoreTCL = false;
    private static final Logger LOGGER = StatusLogger.getLogger();
    private static final String TSTR = "Caught Exception while in Loader.getResource. This may be innocuous.";

    public static ClassLoader getClassLoader() {
        return Loader.getClassLoader(Loader.class, null);
    }

    public static ClassLoader getClassLoader(Class<?> clazz, Class<?> clazz2) {
        ClassLoader classLoader;
        ClassLoader classLoader2 = null;
        try {
            classLoader2 = Loader.getTCL();
        }
        catch (Exception exception) {
            LOGGER.warn("Caught exception locating thread ClassLoader {}", exception.getMessage());
        }
        ClassLoader classLoader3 = clazz == null ? null : clazz.getClassLoader();
        ClassLoader classLoader4 = classLoader = clazz2 == null ? null : clazz2.getClass().getClassLoader();
        if (Loader.isChild(classLoader2, classLoader3)) {
            return Loader.isChild(classLoader2, classLoader) ? classLoader2 : classLoader;
        }
        return Loader.isChild(classLoader3, classLoader) ? classLoader3 : classLoader;
    }

    public static URL getResource(String string, ClassLoader classLoader) {
        try {
            URL uRL;
            ClassLoader classLoader2 = Loader.getTCL();
            if (classLoader2 != null) {
                LOGGER.trace("Trying to find [" + string + "] using context classloader " + classLoader2 + '.');
                uRL = classLoader2.getResource(string);
                if (uRL != null) {
                    return uRL;
                }
            }
            if ((classLoader2 = Loader.class.getClassLoader()) != null) {
                LOGGER.trace("Trying to find [" + string + "] using " + classLoader2 + " class loader.");
                uRL = classLoader2.getResource(string);
                if (uRL != null) {
                    return uRL;
                }
            }
            if (classLoader != null) {
                LOGGER.trace("Trying to find [" + string + "] using " + classLoader + " class loader.");
                uRL = classLoader.getResource(string);
                if (uRL != null) {
                    return uRL;
                }
            }
        }
        catch (Throwable throwable) {
            LOGGER.warn(TSTR, throwable);
        }
        LOGGER.trace("Trying to find [" + string + "] using ClassLoader.getSystemResource().");
        return ClassLoader.getSystemResource(string);
    }

    public static InputStream getResourceAsStream(String string, ClassLoader classLoader) {
        try {
            InputStream inputStream2;
            ClassLoader classLoader2 = Loader.getTCL();
            if (classLoader2 != null) {
                LOGGER.trace("Trying to find [" + string + "] using context classloader " + classLoader2 + '.');
                inputStream2 = classLoader2.getResourceAsStream(string);
                if (inputStream2 != null) {
                    return inputStream2;
                }
            }
            if ((classLoader2 = Loader.class.getClassLoader()) != null) {
                LOGGER.trace("Trying to find [" + string + "] using " + classLoader2 + " class loader.");
                inputStream2 = classLoader2.getResourceAsStream(string);
                if (inputStream2 != null) {
                    return inputStream2;
                }
            }
            if (classLoader != null) {
                LOGGER.trace("Trying to find [" + string + "] using " + classLoader + " class loader.");
                inputStream2 = classLoader.getResourceAsStream(string);
                if (inputStream2 != null) {
                    return inputStream2;
                }
            }
        }
        catch (Throwable throwable) {
            LOGGER.warn(TSTR, throwable);
        }
        LOGGER.trace("Trying to find [" + string + "] using ClassLoader.getSystemResource().");
        return ClassLoader.getSystemResourceAsStream(string);
    }

    private static ClassLoader getTCL() {
        ClassLoader classLoader = System.getSecurityManager() == null ? Thread.currentThread().getContextClassLoader() : AccessController.doPrivileged(new PrivilegedAction<ClassLoader>(){

            @Override
            public ClassLoader run() {
                return Thread.currentThread().getContextClassLoader();
            }
        });
        return classLoader;
    }

    private static boolean isChild(ClassLoader classLoader, ClassLoader classLoader2) {
        if (classLoader != null && classLoader2 != null) {
            ClassLoader classLoader3;
            for (classLoader3 = classLoader.getParent(); classLoader3 != null && classLoader3 != classLoader2; classLoader3 = classLoader3.getParent()) {
            }
            return classLoader3 != null;
        }
        return classLoader != null;
    }

    public static Class<?> loadClass(String string) throws ClassNotFoundException {
        if (ignoreTCL) {
            return Class.forName(string);
        }
        try {
            return Loader.getTCL().loadClass(string);
        }
        catch (Throwable throwable) {
            return Class.forName(string);
        }
    }

    private Loader() {
    }

    static {
        String string = PropertiesUtil.getProperties().getStringProperty("log4j.ignoreTCL", null);
        if (string != null) {
            ignoreTCL = OptionConverter.toBoolean(string, true);
        }
    }
}


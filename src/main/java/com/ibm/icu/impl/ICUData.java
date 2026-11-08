/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl;

import java.io.InputStream;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.MissingResourceException;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class ICUData {
    public static boolean exists(final String string) {
        URL uRL = null;
        uRL = System.getSecurityManager() != null ? AccessController.doPrivileged(new PrivilegedAction<URL>(){

            @Override
            public URL run() {
                return ICUData.class.getResource(string);
            }
        }) : ICUData.class.getResource(string);
        return uRL != null;
    }

    private static InputStream getStream(final Class<?> clazz, final String string, boolean bl) {
        InputStream inputStream2 = null;
        inputStream2 = System.getSecurityManager() != null ? AccessController.doPrivileged(new PrivilegedAction<InputStream>(){

            @Override
            public InputStream run() {
                return clazz.getResourceAsStream(string);
            }
        }) : clazz.getResourceAsStream(string);
        if (inputStream2 == null && bl) {
            throw new MissingResourceException("could not locate data " + string, clazz.getPackage().getName(), string);
        }
        return inputStream2;
    }

    private static InputStream getStream(final ClassLoader classLoader, final String string, boolean bl) {
        InputStream inputStream2 = null;
        inputStream2 = System.getSecurityManager() != null ? AccessController.doPrivileged(new PrivilegedAction<InputStream>(){

            @Override
            public InputStream run() {
                return classLoader.getResourceAsStream(string);
            }
        }) : classLoader.getResourceAsStream(string);
        if (inputStream2 == null && bl) {
            throw new MissingResourceException("could not locate data", classLoader.toString(), string);
        }
        return inputStream2;
    }

    public static InputStream getStream(ClassLoader classLoader, String string) {
        return ICUData.getStream(classLoader, string, false);
    }

    public static InputStream getRequiredStream(ClassLoader classLoader, String string) {
        return ICUData.getStream(classLoader, string, true);
    }

    public static InputStream getStream(String string) {
        return ICUData.getStream(ICUData.class, string, false);
    }

    public static InputStream getRequiredStream(String string) {
        return ICUData.getStream(ICUData.class, string, true);
    }

    public static InputStream getStream(Class<?> clazz, String string) {
        return ICUData.getStream(clazz, string, false);
    }

    public static InputStream getRequiredStream(Class<?> clazz, String string) {
        return ICUData.getStream(clazz, string, true);
    }
}


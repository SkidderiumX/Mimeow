/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.helpers.Loader;
import org.apache.logging.log4j.status.StatusLogger;

public class ReflectiveCallerClassUtility {
    private static final Logger LOGGER = StatusLogger.getLogger();
    private static final boolean GET_CALLER_CLASS_SUPPORTED;
    private static final Method GET_CALLER_CLASS_METHOD;
    static final int JAVA_7U25_COMPENSATION_OFFSET;

    private ReflectiveCallerClassUtility() {
    }

    public static boolean isSupported() {
        return GET_CALLER_CLASS_SUPPORTED;
    }

    public static Class<?> getCaller(int n) {
        if (!GET_CALLER_CLASS_SUPPORTED) {
            return null;
        }
        try {
            return (Class)GET_CALLER_CLASS_METHOD.invoke(null, n + 1 + JAVA_7U25_COMPENSATION_OFFSET);
        }
        catch (IllegalAccessException illegalAccessException) {
            LOGGER.warn("Should not have failed to call getCallerClass.");
        }
        catch (InvocationTargetException invocationTargetException) {
            LOGGER.warn("Should not have failed to call getCallerClass.");
        }
        return null;
    }

    static {
        Method method = null;
        int n = 0;
        try {
            Method[] methodArray;
            ClassLoader classLoader = Loader.getClassLoader();
            Class<?> clazz = classLoader.loadClass("sun.reflect.Reflection");
            for (Method method2 : methodArray = clazz.getMethods()) {
                int n2 = method2.getModifiers();
                Class<?>[] classArray = method2.getParameterTypes();
                if (!method2.getName().equals("getCallerClass") || !Modifier.isStatic(n2) || classArray.length != 1 || classArray[0] != Integer.TYPE) continue;
                method = method2;
                break;
            }
            if (method == null) {
                LOGGER.info("sun.reflect.Reflection#getCallerClass does not exist.");
            } else {
                Object object = method.invoke(null, 0);
                if (object == null || object != clazz) {
                    method = null;
                    LOGGER.warn("sun.reflect.Reflection#getCallerClass returned unexpected value of [{}] and is unusable. Will fall back to another option.", object);
                } else {
                    Object object2 = method.invoke(null, 1);
                    if (object2 == clazz) {
                        n = 1;
                        LOGGER.warn("sun.reflect.Reflection#getCallerClass is broken in Java 7u25. You should upgrade to 7u40. Using alternate stack offset to compensate.");
                    }
                }
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            LOGGER.info("sun.reflect.Reflection is not installed.");
        }
        catch (IllegalAccessException illegalAccessException) {
            LOGGER.info("sun.reflect.Reflection#getCallerClass is not accessible.");
        }
        catch (InvocationTargetException invocationTargetException) {
            LOGGER.info("sun.reflect.Reflection#getCallerClass is not supported.");
        }
        if (method == null) {
            GET_CALLER_CLASS_SUPPORTED = false;
            GET_CALLER_CLASS_METHOD = null;
            JAVA_7U25_COMPENSATION_OFFSET = -1;
        } else {
            GET_CALLER_CLASS_SUPPORTED = true;
            GET_CALLER_CLASS_METHOD = method;
            JAVA_7U25_COMPENSATION_OFFSET = n;
        }
    }
}


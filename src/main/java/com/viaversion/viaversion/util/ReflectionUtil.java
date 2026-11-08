/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionUtil {
    public static Object invokeStatic(Class<?> clazz, String string) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = clazz.getDeclaredMethod(string, new Class[0]);
        return method.invoke(null, new Object[0]);
    }

    public static Object invoke(Object object, String string) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = object.getClass().getDeclaredMethod(string, new Class[0]);
        return method.invoke(object, new Object[0]);
    }

    public static <T> T getStatic(Class<?> clazz, String string, Class<T> clazz2) throws NoSuchFieldException, IllegalAccessException {
        Field field = clazz.getDeclaredField(string);
        field.setAccessible(true);
        return clazz2.cast(field.get(null));
    }

    public static void setStatic(Class<?> clazz, String string, Object object) throws NoSuchFieldException, IllegalAccessException {
        Field field = clazz.getDeclaredField(string);
        field.setAccessible(true);
        field.set(null, object);
    }

    public static <T> T getSuper(Object object, String string, Class<T> clazz) throws NoSuchFieldException, IllegalAccessException {
        Field field = object.getClass().getSuperclass().getDeclaredField(string);
        field.setAccessible(true);
        return clazz.cast(field.get(object));
    }

    public static <T> T get(Object object, Class<?> clazz, String string, Class<T> clazz2) throws NoSuchFieldException, IllegalAccessException {
        Field field = clazz.getDeclaredField(string);
        field.setAccessible(true);
        return clazz2.cast(field.get(object));
    }

    public static <T> T get(Object object, String string, Class<T> clazz) throws NoSuchFieldException, IllegalAccessException {
        Field field = object.getClass().getDeclaredField(string);
        field.setAccessible(true);
        return clazz.cast(field.get(object));
    }

    public static <T> T getPublic(Object object, String string, Class<T> clazz) throws NoSuchFieldException, IllegalAccessException {
        Field field = object.getClass().getField(string);
        field.setAccessible(true);
        return clazz.cast(field.get(object));
    }

    public static void set(Object object, String string, Object object2) throws NoSuchFieldException, IllegalAccessException {
        Field field = object.getClass().getDeclaredField(string);
        field.setAccessible(true);
        field.set(object, object2);
    }
}


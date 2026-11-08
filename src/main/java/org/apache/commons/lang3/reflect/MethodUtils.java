/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.reflect.MemberUtils;
import org.apache.commons.lang3.reflect.TypeUtils;

public class MethodUtils {
    public static Object invokeMethod(Object object, String string, Object ... objectArray) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        objectArray = ArrayUtils.nullToEmpty(objectArray);
        Class<?>[] classArray = ClassUtils.toClass(objectArray);
        return MethodUtils.invokeMethod(object, string, objectArray, classArray);
    }

    public static Object invokeMethod(Object object, String string, Object[] objectArray, Class<?>[] classArray) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        classArray = ArrayUtils.nullToEmpty(classArray);
        objectArray = ArrayUtils.nullToEmpty(objectArray);
        Method method = MethodUtils.getMatchingAccessibleMethod(object.getClass(), string, classArray);
        if (method == null) {
            throw new NoSuchMethodException("No such accessible method: " + string + "() on object: " + object.getClass().getName());
        }
        return method.invoke(object, objectArray);
    }

    public static Object invokeExactMethod(Object object, String string, Object ... objectArray) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        objectArray = ArrayUtils.nullToEmpty(objectArray);
        Class<?>[] classArray = ClassUtils.toClass(objectArray);
        return MethodUtils.invokeExactMethod(object, string, objectArray, classArray);
    }

    public static Object invokeExactMethod(Object object, String string, Object[] objectArray, Class<?>[] classArray) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        objectArray = ArrayUtils.nullToEmpty(objectArray);
        classArray = ArrayUtils.nullToEmpty(classArray);
        Method method = MethodUtils.getAccessibleMethod(object.getClass(), string, classArray);
        if (method == null) {
            throw new NoSuchMethodException("No such accessible method: " + string + "() on object: " + object.getClass().getName());
        }
        return method.invoke(object, objectArray);
    }

    public static Object invokeExactStaticMethod(Class<?> clazz, String string, Object[] objectArray, Class<?>[] classArray) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        objectArray = ArrayUtils.nullToEmpty(objectArray);
        Method method = MethodUtils.getAccessibleMethod(clazz, string, classArray = ArrayUtils.nullToEmpty(classArray));
        if (method == null) {
            throw new NoSuchMethodException("No such accessible method: " + string + "() on class: " + clazz.getName());
        }
        return method.invoke(null, objectArray);
    }

    public static Object invokeStaticMethod(Class<?> clazz, String string, Object ... objectArray) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        objectArray = ArrayUtils.nullToEmpty(objectArray);
        Class<?>[] classArray = ClassUtils.toClass(objectArray);
        return MethodUtils.invokeStaticMethod(clazz, string, objectArray, classArray);
    }

    public static Object invokeStaticMethod(Class<?> clazz, String string, Object[] objectArray, Class<?>[] classArray) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        objectArray = ArrayUtils.nullToEmpty(objectArray);
        Method method = MethodUtils.getMatchingAccessibleMethod(clazz, string, classArray = ArrayUtils.nullToEmpty(classArray));
        if (method == null) {
            throw new NoSuchMethodException("No such accessible method: " + string + "() on class: " + clazz.getName());
        }
        return method.invoke(null, objectArray);
    }

    public static Object invokeExactStaticMethod(Class<?> clazz, String string, Object ... objectArray) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        objectArray = ArrayUtils.nullToEmpty(objectArray);
        Class<?>[] classArray = ClassUtils.toClass(objectArray);
        return MethodUtils.invokeExactStaticMethod(clazz, string, objectArray, classArray);
    }

    public static Method getAccessibleMethod(Class<?> clazz, String string, Class<?> ... classArray) {
        try {
            return MethodUtils.getAccessibleMethod(clazz.getMethod(string, classArray));
        }
        catch (NoSuchMethodException noSuchMethodException) {
            return null;
        }
    }

    public static Method getAccessibleMethod(Method method) {
        Class<?>[] classArray;
        if (!MemberUtils.isAccessible(method)) {
            return null;
        }
        Class<?> clazz = method.getDeclaringClass();
        if (Modifier.isPublic(clazz.getModifiers())) {
            return method;
        }
        String string = method.getName();
        if ((method = MethodUtils.getAccessibleMethodFromInterfaceNest(clazz, string, classArray = method.getParameterTypes())) == null) {
            method = MethodUtils.getAccessibleMethodFromSuperclass(clazz, string, classArray);
        }
        return method;
    }

    private static Method getAccessibleMethodFromSuperclass(Class<?> clazz, String string, Class<?> ... classArray) {
        for (Class<?> clazz2 = clazz.getSuperclass(); clazz2 != null; clazz2 = clazz2.getSuperclass()) {
            if (!Modifier.isPublic(clazz2.getModifiers())) continue;
            try {
                return clazz2.getMethod(string, classArray);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                return null;
            }
        }
        return null;
    }

    private static Method getAccessibleMethodFromInterfaceNest(Class<?> clazz, String string, Class<?> ... classArray) {
        while (clazz != null) {
            Class<?>[] classArray2 = clazz.getInterfaces();
            for (int i = 0; i < classArray2.length; ++i) {
                if (!Modifier.isPublic(classArray2[i].getModifiers())) continue;
                try {
                    return classArray2[i].getDeclaredMethod(string, classArray);
                }
                catch (NoSuchMethodException noSuchMethodException) {
                    Method method = MethodUtils.getAccessibleMethodFromInterfaceNest(classArray2[i], string, classArray);
                    if (method == null) continue;
                    return method;
                }
            }
            clazz = clazz.getSuperclass();
        }
        return null;
    }

    public static Method getMatchingAccessibleMethod(Class<?> clazz, String string, Class<?> ... classArray) {
        try {
            Method method = clazz.getMethod(string, classArray);
            MemberUtils.setAccessibleWorkaround(method);
            return method;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            Method[] methodArray;
            Method method = null;
            for (Method method2 : methodArray = clazz.getMethods()) {
                Method method3;
                if (!method2.getName().equals(string) || !ClassUtils.isAssignable(classArray, method2.getParameterTypes(), true) || (method3 = MethodUtils.getAccessibleMethod(method2)) == null || method != null && MemberUtils.compareParameterTypes(method3.getParameterTypes(), method.getParameterTypes(), classArray) >= 0) continue;
                method = method3;
            }
            if (method != null) {
                MemberUtils.setAccessibleWorkaround(method);
            }
            return method;
        }
    }

    public static Set<Method> getOverrideHierarchy(Method method, ClassUtils.Interfaces interfaces) {
        Validate.notNull(method);
        LinkedHashSet<Method> linkedHashSet = new LinkedHashSet<Method>();
        linkedHashSet.add(method);
        Object[] objectArray = method.getParameterTypes();
        Class<?> clazz = method.getDeclaringClass();
        Iterator<Class<?>> iterator2 = ClassUtils.hierarchy(clazz, interfaces).iterator();
        iterator2.next();
        block0: while (iterator2.hasNext()) {
            Class<?> clazz2 = iterator2.next();
            Method method2 = MethodUtils.getMatchingAccessibleMethod(clazz2, method.getName(), objectArray);
            if (method2 == null) continue;
            if (Arrays.equals(method2.getParameterTypes(), objectArray)) {
                linkedHashSet.add(method2);
                continue;
            }
            Map<TypeVariable<?>, Type> map = TypeUtils.getTypeArguments(clazz, method2.getDeclaringClass());
            for (int i = 0; i < objectArray.length; ++i) {
                Type type;
                Type type2 = TypeUtils.unrollVariables(map, method.getGenericParameterTypes()[i]);
                if (!TypeUtils.equals(type2, type = TypeUtils.unrollVariables(map, method2.getGenericParameterTypes()[i]))) continue block0;
            }
            linkedHashSet.add(method2);
        }
        return linkedHashSet;
    }
}


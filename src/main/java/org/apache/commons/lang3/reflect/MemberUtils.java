/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.reflect;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import org.apache.commons.lang3.ClassUtils;

public abstract class MemberUtils {
    private static final int ACCESS_TEST = 7;
    private static final Class<?>[] ORDERED_PRIMITIVE_TYPES = new Class[]{Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE};

    MemberUtils() {
    }

    static boolean setAccessibleWorkaround(AccessibleObject accessibleObject) {
        if (accessibleObject == null || accessibleObject.isAccessible()) {
            return false;
        }
        Member member = (Member)((Object)accessibleObject);
        if (!accessibleObject.isAccessible() && Modifier.isPublic(member.getModifiers()) && MemberUtils.isPackageAccess(member.getDeclaringClass().getModifiers())) {
            try {
                accessibleObject.setAccessible(true);
                return true;
            }
            catch (SecurityException securityException) {
                // empty catch block
            }
        }
        return false;
    }

    static boolean isPackageAccess(int n) {
        return (n & 7) == 0;
    }

    static boolean isAccessible(Member member) {
        return member != null && Modifier.isPublic(member.getModifiers()) && !member.isSynthetic();
    }

    static int compareParameterTypes(Class<?>[] classArray, Class<?>[] classArray2, Class<?>[] classArray3) {
        float f;
        float f2 = MemberUtils.getTotalTransformationCost(classArray3, classArray);
        return f2 < (f = MemberUtils.getTotalTransformationCost(classArray3, classArray2)) ? -1 : (f < f2 ? 1 : 0);
    }

    private static float getTotalTransformationCost(Class<?>[] classArray, Class<?>[] classArray2) {
        float f = 0.0f;
        for (int i = 0; i < classArray.length; ++i) {
            Class<?> clazz = classArray[i];
            Class<?> clazz2 = classArray2[i];
            f += MemberUtils.getObjectTransformationCost(clazz, clazz2);
        }
        return f;
    }

    private static float getObjectTransformationCost(Class<?> clazz, Class<?> clazz2) {
        if (clazz2.isPrimitive()) {
            return MemberUtils.getPrimitivePromotionCost(clazz, clazz2);
        }
        float f = 0.0f;
        while (clazz != null && !clazz2.equals(clazz)) {
            if (clazz2.isInterface() && ClassUtils.isAssignable(clazz, clazz2)) {
                f += 0.25f;
                break;
            }
            f += 1.0f;
            clazz = clazz.getSuperclass();
        }
        if (clazz == null) {
            f += 1.5f;
        }
        return f;
    }

    private static float getPrimitivePromotionCost(Class<?> clazz, Class<?> clazz2) {
        float f = 0.0f;
        Class<?> clazz3 = clazz;
        if (!clazz3.isPrimitive()) {
            f += 0.1f;
            clazz3 = ClassUtils.wrapperToPrimitive(clazz3);
        }
        for (int i = 0; clazz3 != clazz2 && i < ORDERED_PRIMITIVE_TYPES.length; ++i) {
            if (clazz3 != ORDERED_PRIMITIVE_TYPES[i]) continue;
            f += 0.1f;
            if (i >= ORDERED_PRIMITIVE_TYPES.length - 1) continue;
            clazz3 = ORDERED_PRIMITIVE_TYPES[i + 1];
        }
        return f;
    }
}


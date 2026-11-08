/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.JavaVersion;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.lang3.mutable.MutableObject;

public class ClassUtils {
    public static final char PACKAGE_SEPARATOR_CHAR = '.';
    public static final String PACKAGE_SEPARATOR = String.valueOf('.');
    public static final char INNER_CLASS_SEPARATOR_CHAR = '$';
    public static final String INNER_CLASS_SEPARATOR = String.valueOf('$');
    private static final Map<Class<?>, Class<?>> primitiveWrapperMap = new HashMap();
    private static final Map<Class<?>, Class<?>> wrapperPrimitiveMap;
    private static final Map<String, String> abbreviationMap;
    private static final Map<String, String> reverseAbbreviationMap;

    public static String getShortClassName(Object object, String string) {
        if (object == null) {
            return string;
        }
        return ClassUtils.getShortClassName(object.getClass());
    }

    public static String getShortClassName(Class<?> clazz) {
        if (clazz == null) {
            return "";
        }
        return ClassUtils.getShortClassName(clazz.getName());
    }

    public static String getShortClassName(String string) {
        int n;
        if (StringUtils.isEmpty(string)) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (string.startsWith("[")) {
            while (string.charAt(0) == '[') {
                string = string.substring(1);
                stringBuilder.append("[]");
            }
            if (string.charAt(0) == 'L' && string.charAt(string.length() - 1) == ';') {
                string = string.substring(1, string.length() - 1);
            }
            if (reverseAbbreviationMap.containsKey(string)) {
                string = reverseAbbreviationMap.get(string);
            }
        }
        int n2 = string.indexOf(36, (n = string.lastIndexOf(46)) == -1 ? 0 : n + 1);
        String string2 = string.substring(n + 1);
        if (n2 != -1) {
            string2 = string2.replace('$', '.');
        }
        return string2 + stringBuilder;
    }

    public static String getSimpleName(Class<?> clazz) {
        if (clazz == null) {
            return "";
        }
        return clazz.getSimpleName();
    }

    public static String getSimpleName(Object object, String string) {
        if (object == null) {
            return string;
        }
        return ClassUtils.getSimpleName(object.getClass());
    }

    public static String getPackageName(Object object, String string) {
        if (object == null) {
            return string;
        }
        return ClassUtils.getPackageName(object.getClass());
    }

    public static String getPackageName(Class<?> clazz) {
        if (clazz == null) {
            return "";
        }
        return ClassUtils.getPackageName(clazz.getName());
    }

    public static String getPackageName(String string) {
        int n;
        if (StringUtils.isEmpty(string)) {
            return "";
        }
        while (string.charAt(0) == '[') {
            string = string.substring(1);
        }
        if (string.charAt(0) == 'L' && string.charAt(string.length() - 1) == ';') {
            string = string.substring(1);
        }
        if ((n = string.lastIndexOf(46)) == -1) {
            return "";
        }
        return string.substring(0, n);
    }

    public static List<Class<?>> getAllSuperclasses(Class<?> clazz) {
        if (clazz == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Class<?> clazz2 = clazz.getSuperclass(); clazz2 != null; clazz2 = clazz2.getSuperclass()) {
            arrayList.add(clazz2);
        }
        return arrayList;
    }

    public static List<Class<?>> getAllInterfaces(Class<?> clazz) {
        if (clazz == null) {
            return null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ClassUtils.getAllInterfaces(clazz, linkedHashSet);
        return new ArrayList(linkedHashSet);
    }

    private static void getAllInterfaces(Class<?> clazz, HashSet<Class<?>> hashSet) {
        while (clazz != null) {
            Class<?>[] classArray;
            for (Class<?> clazz2 : classArray = clazz.getInterfaces()) {
                if (!hashSet.add(clazz2)) continue;
                ClassUtils.getAllInterfaces(clazz2, hashSet);
            }
            clazz = clazz.getSuperclass();
        }
    }

    public static List<Class<?>> convertClassNamesToClasses(List<String> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (String string : list) {
            try {
                arrayList.add(Class.forName(string));
            }
            catch (Exception exception) {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public static List<String> convertClassesToClassNames(List<Class<?>> list) {
        if (list == null) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<String>(list.size());
        for (Class<?> clazz : list) {
            if (clazz == null) {
                arrayList.add(null);
                continue;
            }
            arrayList.add(clazz.getName());
        }
        return arrayList;
    }

    public static boolean isAssignable(Class<?>[] classArray, Class<?> ... classArray2) {
        return ClassUtils.isAssignable(classArray, classArray2, SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_1_5));
    }

    public static boolean isAssignable(Class<?>[] classArray, Class<?>[] classArray2, boolean bl) {
        if (!ArrayUtils.isSameLength(classArray, classArray2)) {
            return false;
        }
        if (classArray == null) {
            classArray = ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        if (classArray2 == null) {
            classArray2 = ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        for (int i = 0; i < classArray.length; ++i) {
            if (ClassUtils.isAssignable(classArray[i], classArray2[i], bl)) continue;
            return false;
        }
        return true;
    }

    public static boolean isPrimitiveOrWrapper(Class<?> clazz) {
        if (clazz == null) {
            return false;
        }
        return clazz.isPrimitive() || ClassUtils.isPrimitiveWrapper(clazz);
    }

    public static boolean isPrimitiveWrapper(Class<?> clazz) {
        return wrapperPrimitiveMap.containsKey(clazz);
    }

    public static boolean isAssignable(Class<?> clazz, Class<?> clazz2) {
        return ClassUtils.isAssignable(clazz, clazz2, SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_1_5));
    }

    public static boolean isAssignable(Class<?> clazz, Class<?> clazz2, boolean bl) {
        if (clazz2 == null) {
            return false;
        }
        if (clazz == null) {
            return !clazz2.isPrimitive();
        }
        if (bl) {
            if (clazz.isPrimitive() && !clazz2.isPrimitive() && (clazz = ClassUtils.primitiveToWrapper(clazz)) == null) {
                return false;
            }
            if (clazz2.isPrimitive() && !clazz.isPrimitive() && (clazz = ClassUtils.wrapperToPrimitive(clazz)) == null) {
                return false;
            }
        }
        if (clazz.equals(clazz2)) {
            return true;
        }
        if (clazz.isPrimitive()) {
            if (!clazz2.isPrimitive()) {
                return false;
            }
            if (Integer.TYPE.equals(clazz)) {
                return Long.TYPE.equals(clazz2) || Float.TYPE.equals(clazz2) || Double.TYPE.equals(clazz2);
            }
            if (Long.TYPE.equals(clazz)) {
                return Float.TYPE.equals(clazz2) || Double.TYPE.equals(clazz2);
            }
            if (Boolean.TYPE.equals(clazz)) {
                return false;
            }
            if (Double.TYPE.equals(clazz)) {
                return false;
            }
            if (Float.TYPE.equals(clazz)) {
                return Double.TYPE.equals(clazz2);
            }
            if (Character.TYPE.equals(clazz)) {
                return Integer.TYPE.equals(clazz2) || Long.TYPE.equals(clazz2) || Float.TYPE.equals(clazz2) || Double.TYPE.equals(clazz2);
            }
            if (Short.TYPE.equals(clazz)) {
                return Integer.TYPE.equals(clazz2) || Long.TYPE.equals(clazz2) || Float.TYPE.equals(clazz2) || Double.TYPE.equals(clazz2);
            }
            if (Byte.TYPE.equals(clazz)) {
                return Short.TYPE.equals(clazz2) || Integer.TYPE.equals(clazz2) || Long.TYPE.equals(clazz2) || Float.TYPE.equals(clazz2) || Double.TYPE.equals(clazz2);
            }
            return false;
        }
        return clazz2.isAssignableFrom(clazz);
    }

    public static Class<?> primitiveToWrapper(Class<?> clazz) {
        Class<?> clazz2 = clazz;
        if (clazz != null && clazz.isPrimitive()) {
            clazz2 = primitiveWrapperMap.get(clazz);
        }
        return clazz2;
    }

    public static Class<?>[] primitivesToWrappers(Class<?> ... classArray) {
        if (classArray == null) {
            return null;
        }
        if (classArray.length == 0) {
            return classArray;
        }
        Class[] classArray2 = new Class[classArray.length];
        for (int i = 0; i < classArray.length; ++i) {
            classArray2[i] = ClassUtils.primitiveToWrapper(classArray[i]);
        }
        return classArray2;
    }

    public static Class<?> wrapperToPrimitive(Class<?> clazz) {
        return wrapperPrimitiveMap.get(clazz);
    }

    public static Class<?>[] wrappersToPrimitives(Class<?> ... classArray) {
        if (classArray == null) {
            return null;
        }
        if (classArray.length == 0) {
            return classArray;
        }
        Class[] classArray2 = new Class[classArray.length];
        for (int i = 0; i < classArray.length; ++i) {
            classArray2[i] = ClassUtils.wrapperToPrimitive(classArray[i]);
        }
        return classArray2;
    }

    public static boolean isInnerClass(Class<?> clazz) {
        return clazz != null && clazz.getEnclosingClass() != null;
    }

    public static Class<?> getClass(ClassLoader classLoader, String string, boolean bl) throws ClassNotFoundException {
        try {
            Class<?> clazz;
            if (abbreviationMap.containsKey(string)) {
                String string2 = "[" + abbreviationMap.get(string);
                clazz = Class.forName(string2, bl, classLoader).getComponentType();
            } else {
                clazz = Class.forName(ClassUtils.toCanonicalName(string), bl, classLoader);
            }
            return clazz;
        }
        catch (ClassNotFoundException classNotFoundException) {
            int n = string.lastIndexOf(46);
            if (n != -1) {
                try {
                    return ClassUtils.getClass(classLoader, string.substring(0, n) + '$' + string.substring(n + 1), bl);
                }
                catch (ClassNotFoundException classNotFoundException2) {
                    // empty catch block
                }
            }
            throw classNotFoundException;
        }
    }

    public static Class<?> getClass(ClassLoader classLoader, String string) throws ClassNotFoundException {
        return ClassUtils.getClass(classLoader, string, true);
    }

    public static Class<?> getClass(String string) throws ClassNotFoundException {
        return ClassUtils.getClass(string, true);
    }

    public static Class<?> getClass(String string, boolean bl) throws ClassNotFoundException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        ClassLoader classLoader2 = classLoader == null ? ClassUtils.class.getClassLoader() : classLoader;
        return ClassUtils.getClass(classLoader2, string, bl);
    }

    public static Method getPublicMethod(Class<?> clazz, String string, Class<?> ... classArray) throws SecurityException, NoSuchMethodException {
        Method method = clazz.getMethod(string, classArray);
        if (Modifier.isPublic(method.getDeclaringClass().getModifiers())) {
            return method;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(ClassUtils.getAllInterfaces(clazz));
        arrayList.addAll(ClassUtils.getAllSuperclasses(clazz));
        for (Class clazz2 : arrayList) {
            Method method2;
            if (!Modifier.isPublic(clazz2.getModifiers())) continue;
            try {
                method2 = clazz2.getMethod(string, classArray);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                continue;
            }
            if (!Modifier.isPublic(method2.getDeclaringClass().getModifiers())) continue;
            return method2;
        }
        throw new NoSuchMethodException("Can't find a public method for " + string + " " + ArrayUtils.toString(classArray));
    }

    private static String toCanonicalName(String string) {
        if ((string = StringUtils.deleteWhitespace(string)) == null) {
            throw new NullPointerException("className must not be null.");
        }
        if (string.endsWith("[]")) {
            StringBuilder stringBuilder = new StringBuilder();
            while (string.endsWith("[]")) {
                string = string.substring(0, string.length() - 2);
                stringBuilder.append("[");
            }
            String string2 = abbreviationMap.get(string);
            if (string2 != null) {
                stringBuilder.append(string2);
            } else {
                stringBuilder.append("L").append(string).append(";");
            }
            string = stringBuilder.toString();
        }
        return string;
    }

    public static Class<?>[] toClass(Object ... objectArray) {
        if (objectArray == null) {
            return null;
        }
        if (objectArray.length == 0) {
            return ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        Class[] classArray = new Class[objectArray.length];
        for (int i = 0; i < objectArray.length; ++i) {
            classArray[i] = objectArray[i] == null ? null : objectArray[i].getClass();
        }
        return classArray;
    }

    public static String getShortCanonicalName(Object object, String string) {
        if (object == null) {
            return string;
        }
        return ClassUtils.getShortCanonicalName(object.getClass().getName());
    }

    public static String getShortCanonicalName(Class<?> clazz) {
        if (clazz == null) {
            return "";
        }
        return ClassUtils.getShortCanonicalName(clazz.getName());
    }

    public static String getShortCanonicalName(String string) {
        return ClassUtils.getShortClassName(ClassUtils.getCanonicalName(string));
    }

    public static String getPackageCanonicalName(Object object, String string) {
        if (object == null) {
            return string;
        }
        return ClassUtils.getPackageCanonicalName(object.getClass().getName());
    }

    public static String getPackageCanonicalName(Class<?> clazz) {
        if (clazz == null) {
            return "";
        }
        return ClassUtils.getPackageCanonicalName(clazz.getName());
    }

    public static String getPackageCanonicalName(String string) {
        return ClassUtils.getPackageName(ClassUtils.getCanonicalName(string));
    }

    private static String getCanonicalName(String string) {
        if ((string = StringUtils.deleteWhitespace(string)) == null) {
            return null;
        }
        int n = 0;
        while (string.startsWith("[")) {
            ++n;
            string = string.substring(1);
        }
        if (n < 1) {
            return string;
        }
        if (string.startsWith("L")) {
            string = string.substring(1, string.endsWith(";") ? string.length() - 1 : string.length());
        } else if (string.length() > 0) {
            string = reverseAbbreviationMap.get(string.substring(0, 1));
        }
        StringBuilder stringBuilder = new StringBuilder(string);
        for (int i = 0; i < n; ++i) {
            stringBuilder.append("[]");
        }
        return stringBuilder.toString();
    }

    public static Iterable<Class<?>> hierarchy(Class<?> clazz) {
        return ClassUtils.hierarchy(clazz, Interfaces.EXCLUDE);
    }

    public static Iterable<Class<?>> hierarchy(final Class<?> clazz, Interfaces interfaces) {
        final Iterable iterable = new Iterable<Class<?>>(){

            @Override
            public Iterator<Class<?>> iterator() {
                final MutableObject<Class> mutableObject = new MutableObject<Class>(clazz);
                return new Iterator<Class<?>>(){

                    @Override
                    public boolean hasNext() {
                        return mutableObject.getValue() != null;
                    }

                    @Override
                    public Class<?> next() {
                        Class clazz = (Class)mutableObject.getValue();
                        mutableObject.setValue(clazz.getSuperclass());
                        return clazz;
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
        if (interfaces != Interfaces.INCLUDE) {
            return iterable;
        }
        return new Iterable<Class<?>>(){

            @Override
            public Iterator<Class<?>> iterator() {
                final HashSet hashSet = new HashSet();
                final Iterator iterator2 = iterable.iterator();
                return new Iterator<Class<?>>(){
                    Iterator<Class<?>> interfaces = Collections.emptySet().iterator();

                    @Override
                    public boolean hasNext() {
                        return this.interfaces.hasNext() || iterator2.hasNext();
                    }

                    @Override
                    public Class<?> next() {
                        if (this.interfaces.hasNext()) {
                            Class<?> clazz = this.interfaces.next();
                            hashSet.add(clazz);
                            return clazz;
                        }
                        Class clazz = (Class)iterator2.next();
                        LinkedHashSet linkedHashSet = new LinkedHashSet();
                        this.walkInterfaces(linkedHashSet, clazz);
                        this.interfaces = linkedHashSet.iterator();
                        return clazz;
                    }

                    private void walkInterfaces(Set<Class<?>> set, Class<?> clazz) {
                        for (Class<?> clazz2 : clazz.getInterfaces()) {
                            if (!hashSet.contains(clazz2)) {
                                set.add(clazz2);
                            }
                            this.walkInterfaces(set, clazz2);
                        }
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }

    static {
        primitiveWrapperMap.put(Boolean.TYPE, Boolean.class);
        primitiveWrapperMap.put(Byte.TYPE, Byte.class);
        primitiveWrapperMap.put(Character.TYPE, Character.class);
        primitiveWrapperMap.put(Short.TYPE, Short.class);
        primitiveWrapperMap.put(Integer.TYPE, Integer.class);
        primitiveWrapperMap.put(Long.TYPE, Long.class);
        primitiveWrapperMap.put(Double.TYPE, Double.class);
        primitiveWrapperMap.put(Float.TYPE, Float.class);
        primitiveWrapperMap.put(Void.TYPE, Void.TYPE);
        wrapperPrimitiveMap = new HashMap();
        for (Class<?> serializable2 : primitiveWrapperMap.keySet()) {
            Object object;
            if (serializable2.equals(object = primitiveWrapperMap.get(serializable2))) continue;
            wrapperPrimitiveMap.put((Class<?>)object, serializable2);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("int", "I");
        hashMap.put("boolean", "Z");
        hashMap.put("float", "F");
        hashMap.put("long", "J");
        hashMap.put("short", "S");
        hashMap.put("byte", "B");
        hashMap.put("double", "D");
        hashMap.put("char", "C");
        hashMap.put("void", "V");
        HashMap hashMap2 = new HashMap();
        for (Map.Entry entry : hashMap.entrySet()) {
            hashMap2.put(entry.getValue(), entry.getKey());
        }
        abbreviationMap = Collections.unmodifiableMap(hashMap);
        reverseAbbreviationMap = Collections.unmodifiableMap(hashMap2);
    }

    public static enum Interfaces {
        INCLUDE,
        EXCLUDE;

    }
}


/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.reflect;

import com.google.gson.JsonIOException;
import com.google.gson.internal.TroubleshootingGuide;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionHelper {
    private static final RecordHelper RECORD_HELPER;

    private ReflectionHelper() {
    }

    private static String getInaccessibleTroubleshootingSuffix(Exception exception) {
        if (exception.getClass().getName().equals("java.lang.reflect.InaccessibleObjectException")) {
            String string = exception.getMessage();
            String string2 = string != null && string.contains("to module com.google.gson") ? "reflection-inaccessible-to-module-gson" : "reflection-inaccessible";
            return "\nSee " + TroubleshootingGuide.createUrl(string2);
        }
        return "";
    }

    public static void makeAccessible(AccessibleObject accessibleObject) throws JsonIOException {
        try {
            accessibleObject.setAccessible(true);
        }
        catch (Exception exception) {
            String string = ReflectionHelper.getAccessibleObjectDescription(accessibleObject, false);
            throw new JsonIOException("Failed making " + string + " accessible; either increase its visibility or write a custom TypeAdapter for its declaring type." + ReflectionHelper.getInaccessibleTroubleshootingSuffix(exception), exception);
        }
    }

    public static String getAccessibleObjectDescription(AccessibleObject accessibleObject, boolean bl) {
        String string;
        if (accessibleObject instanceof Field) {
            string = "field '" + ReflectionHelper.fieldToString((Field)accessibleObject) + "'";
        } else if (accessibleObject instanceof Method) {
            Method method = (Method)accessibleObject;
            StringBuilder stringBuilder = new StringBuilder(method.getName());
            ReflectionHelper.appendExecutableParameters(method, stringBuilder);
            String string2 = stringBuilder.toString();
            string = "method '" + method.getDeclaringClass().getName() + "#" + string2 + "'";
        } else {
            string = accessibleObject instanceof Constructor ? "constructor '" + ReflectionHelper.constructorToString((Constructor)accessibleObject) + "'" : "<unknown AccessibleObject> " + accessibleObject.toString();
        }
        if (bl && Character.isLowerCase(string.charAt(0))) {
            string = Character.toUpperCase(string.charAt(0)) + string.substring(1);
        }
        return string;
    }

    public static String fieldToString(Field field) {
        return field.getDeclaringClass().getName() + "#" + field.getName();
    }

    public static String constructorToString(Constructor<?> constructor) {
        StringBuilder stringBuilder = new StringBuilder(constructor.getDeclaringClass().getName());
        ReflectionHelper.appendExecutableParameters(constructor, stringBuilder);
        return stringBuilder.toString();
    }

    private static void appendExecutableParameters(AccessibleObject accessibleObject, StringBuilder stringBuilder) {
        stringBuilder.append('(');
        Class<?>[] classArray = accessibleObject instanceof Method ? ((Method)accessibleObject).getParameterTypes() : ((Constructor)accessibleObject).getParameterTypes();
        for (int i = 0; i < classArray.length; ++i) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(classArray[i].getSimpleName());
        }
        stringBuilder.append(')');
    }

    public static boolean isStatic(Class<?> clazz) {
        return Modifier.isStatic(clazz.getModifiers());
    }

    public static boolean isAnonymousOrNonStaticLocal(Class<?> clazz) {
        return !ReflectionHelper.isStatic(clazz) && (clazz.isAnonymousClass() || clazz.isLocalClass());
    }

    public static String tryMakeAccessible(Constructor<?> constructor) {
        try {
            constructor.setAccessible(true);
            return null;
        }
        catch (Exception exception) {
            return "Failed making constructor '" + ReflectionHelper.constructorToString(constructor) + "' accessible; either increase its visibility or write a custom InstanceCreator or TypeAdapter for its declaring type: " + exception.getMessage() + ReflectionHelper.getInaccessibleTroubleshootingSuffix(exception);
        }
    }

    public static boolean isRecord(Class<?> clazz) {
        return RECORD_HELPER.isRecord(clazz);
    }

    public static String[] getRecordComponentNames(Class<?> clazz) {
        return RECORD_HELPER.getRecordComponentNames(clazz);
    }

    public static Method getAccessor(Class<?> clazz, Field field) {
        return RECORD_HELPER.getAccessor(clazz, field);
    }

    public static <T> Constructor<T> getCanonicalRecordConstructor(Class<T> clazz) {
        return RECORD_HELPER.getCanonicalRecordConstructor(clazz);
    }

    public static RuntimeException createExceptionForUnexpectedIllegalAccess(IllegalAccessException illegalAccessException) {
        throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.14.0). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", illegalAccessException);
    }

    private static RuntimeException createExceptionForRecordReflectionException(ReflectiveOperationException reflectiveOperationException) {
        throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.14.0). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", reflectiveOperationException);
    }

    static {
        RecordHelper recordHelper;
        try {
            recordHelper = new RecordSupportedHelper();
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            recordHelper = new RecordNotSupportedHelper();
        }
        RECORD_HELPER = recordHelper;
    }

    private static abstract class RecordHelper {
        private RecordHelper() {
        }

        abstract boolean isRecord(Class<?> var1);

        abstract String[] getRecordComponentNames(Class<?> var1);

        abstract <T> Constructor<T> getCanonicalRecordConstructor(Class<T> var1);

        abstract Method getAccessor(Class<?> var1, Field var2);
    }

    private static class RecordSupportedHelper
    extends RecordHelper {
        private final Method isRecord = Class.class.getMethod("isRecord", new Class[0]);
        private final Method getRecordComponents = Class.class.getMethod("getRecordComponents", new Class[0]);
        private final Method getName;
        private final Method getType;

        private RecordSupportedHelper() throws NoSuchMethodException, ClassNotFoundException {
            Class<?> clazz = Class.forName("java.lang.reflect.RecordComponent");
            this.getName = clazz.getMethod("getName", new Class[0]);
            this.getType = clazz.getMethod("getType", new Class[0]);
        }

        @Override
        boolean isRecord(Class<?> clazz) {
            try {
                return (Boolean)this.isRecord.invoke(clazz, new Object[0]);
            }
            catch (ReflectiveOperationException reflectiveOperationException) {
                throw ReflectionHelper.createExceptionForRecordReflectionException(reflectiveOperationException);
            }
        }

        @Override
        String[] getRecordComponentNames(Class<?> clazz) {
            try {
                Object[] objectArray = (Object[])this.getRecordComponents.invoke(clazz, new Object[0]);
                String[] stringArray = new String[objectArray.length];
                for (int i = 0; i < objectArray.length; ++i) {
                    stringArray[i] = (String)this.getName.invoke(objectArray[i], new Object[0]);
                }
                return stringArray;
            }
            catch (ReflectiveOperationException reflectiveOperationException) {
                throw ReflectionHelper.createExceptionForRecordReflectionException(reflectiveOperationException);
            }
        }

        @Override
        public <T> Constructor<T> getCanonicalRecordConstructor(Class<T> clazz) {
            try {
                Object[] objectArray = (Object[])this.getRecordComponents.invoke(clazz, new Object[0]);
                Class[] classArray = new Class[objectArray.length];
                for (int i = 0; i < objectArray.length; ++i) {
                    classArray[i] = (Class)this.getType.invoke(objectArray[i], new Object[0]);
                }
                return clazz.getDeclaredConstructor(classArray);
            }
            catch (ReflectiveOperationException reflectiveOperationException) {
                throw ReflectionHelper.createExceptionForRecordReflectionException(reflectiveOperationException);
            }
        }

        @Override
        public Method getAccessor(Class<?> clazz, Field field) {
            try {
                return clazz.getMethod(field.getName(), new Class[0]);
            }
            catch (ReflectiveOperationException reflectiveOperationException) {
                throw ReflectionHelper.createExceptionForRecordReflectionException(reflectiveOperationException);
            }
        }
    }

    private static class RecordNotSupportedHelper
    extends RecordHelper {
        private RecordNotSupportedHelper() {
        }

        @Override
        boolean isRecord(Class<?> clazz) {
            return false;
        }

        @Override
        String[] getRecordComponentNames(Class<?> clazz) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override
        <T> Constructor<T> getCanonicalRecordConstructor(Class<T> clazz) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override
        public Method getAccessor(Class<?> clazz, Field field) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }
    }
}


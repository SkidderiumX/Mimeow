/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.gson.internal;

import com.viaversion.viaversion.libs.gson.InstanceCreator;
import com.viaversion.viaversion.libs.gson.JsonIOException;
import com.viaversion.viaversion.libs.gson.ReflectionAccessFilter;
import com.viaversion.viaversion.libs.gson.internal.GsonTypes;
import com.viaversion.viaversion.libs.gson.internal.LinkedTreeMap;
import com.viaversion.viaversion.libs.gson.internal.ObjectConstructor;
import com.viaversion.viaversion.libs.gson.internal.ReflectionAccessFilterHelper;
import com.viaversion.viaversion.libs.gson.internal.TroubleshootingGuide;
import com.viaversion.viaversion.libs.gson.internal.UnsafeAllocator;
import com.viaversion.viaversion.libs.gson.internal.reflect.ReflectionHelper;
import com.viaversion.viaversion.libs.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConstructorConstructor {
    private final Map<Type, InstanceCreator<?>> instanceCreators;
    private final boolean useJdkUnsafe;
    private final List<ReflectionAccessFilter> reflectionFilters;

    public ConstructorConstructor(Map<Type, InstanceCreator<?>> map, boolean bl, List<ReflectionAccessFilter> list) {
        this.instanceCreators = map;
        this.useJdkUnsafe = bl;
        this.reflectionFilters = list;
    }

    static String checkInstantiable(Class<?> clazz) {
        int n = clazz.getModifiers();
        if (Modifier.isInterface(n)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: " + clazz.getName();
        }
        if (Modifier.isAbstract(n)) {
            return "Abstract classes can't be instantiated! Adjust the R8 configuration or register an InstanceCreator or a TypeAdapter for this type. Class name: " + clazz.getName() + "\nSee " + TroubleshootingGuide.createUrl("r8-abstract-class");
        }
        return null;
    }

    public <T> ObjectConstructor<T> get(TypeToken<T> typeToken) {
        return this.get(typeToken, true);
    }

    public <T> ObjectConstructor<T> get(TypeToken<T> typeToken, boolean bl) {
        Type type = typeToken.getType();
        Class<T> clazz = typeToken.getRawType();
        InstanceCreator<?> instanceCreator = this.instanceCreators.get(type);
        if (instanceCreator != null) {
            return new InstanceCreatorConstructor(instanceCreator, type);
        }
        InstanceCreator<?> instanceCreator2 = this.instanceCreators.get(clazz);
        if (instanceCreator2 != null) {
            return new InstanceCreatorConstructor(instanceCreator2, type);
        }
        ObjectConstructor<T> objectConstructor = ConstructorConstructor.newSpecialCollectionConstructor(type, clazz);
        if (objectConstructor != null) {
            return objectConstructor;
        }
        ReflectionAccessFilter.FilterResult filterResult = ReflectionAccessFilterHelper.getFilterResult(this.reflectionFilters, clazz);
        ObjectConstructor<T> objectConstructor2 = ConstructorConstructor.newDefaultConstructor(clazz, filterResult);
        if (objectConstructor2 != null) {
            return objectConstructor2;
        }
        ObjectConstructor<T> objectConstructor3 = ConstructorConstructor.newDefaultImplementationConstructor(type, clazz);
        if (objectConstructor3 != null) {
            return objectConstructor3;
        }
        String string = ConstructorConstructor.checkInstantiable(clazz);
        if (string != null) {
            return new ThrowingObjectConstructor(string);
        }
        if (!bl) {
            String string2 = "Unable to create instance of " + clazz + "; Register an InstanceCreator or a TypeAdapter for this type.";
            return new ThrowingObjectConstructor(string2);
        }
        if (filterResult != ReflectionAccessFilter.FilterResult.ALLOW) {
            String string3 = "Unable to create instance of " + clazz + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.";
            return new ThrowingObjectConstructor(string3);
        }
        return this.newUnsafeAllocator(clazz);
    }

    private static <T> ObjectConstructor<T> newSpecialCollectionConstructor(Type type, Class<? super T> clazz) {
        if (EnumSet.class.isAssignableFrom(clazz)) {
            return () -> {
                if (type instanceof ParameterizedType) {
                    Type type2 = ((ParameterizedType)type).getActualTypeArguments()[0];
                    if (type2 instanceof Class) {
                        EnumSet enumSet = EnumSet.noneOf((Class)type2);
                        return enumSet;
                    }
                    throw new JsonIOException("Invalid EnumSet type: " + type);
                }
                throw new JsonIOException("Invalid EnumSet type: " + type);
            };
        }
        if (clazz == EnumMap.class) {
            return () -> {
                if (type instanceof ParameterizedType) {
                    Type type2 = ((ParameterizedType)type).getActualTypeArguments()[0];
                    if (type2 instanceof Class) {
                        EnumMap enumMap = new EnumMap((Class)type2);
                        return enumMap;
                    }
                    throw new JsonIOException("Invalid EnumMap type: " + type);
                }
                throw new JsonIOException("Invalid EnumMap type: " + type);
            };
        }
        return null;
    }

    private static <T> ObjectConstructor<T> newDefaultConstructor(Class<? super T> clazz, ReflectionAccessFilter.FilterResult filterResult) {
        String string;
        boolean bl;
        Constructor constructor;
        if (Modifier.isAbstract(clazz.getModifiers())) {
            return null;
        }
        try {
            constructor = clazz.getDeclaredConstructor(new Class[0]);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            return null;
        }
        boolean bl2 = bl = filterResult == ReflectionAccessFilter.FilterResult.ALLOW || ReflectionAccessFilterHelper.canAccess(constructor, null) && (filterResult != ReflectionAccessFilter.FilterResult.BLOCK_ALL || Modifier.isPublic(constructor.getModifiers()));
        if (!bl) {
            String string2 = "Unable to invoke no-args constructor of " + clazz + "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.";
            return new ThrowingObjectConstructor(string2);
        }
        if (filterResult == ReflectionAccessFilter.FilterResult.ALLOW && (string = ReflectionHelper.tryMakeAccessible(constructor)) != null) {
            return new ThrowingObjectConstructor(string);
        }
        return () -> {
            try {
                Object t = constructor.newInstance(new Object[0]);
                return t;
            }
            catch (InstantiationException instantiationException) {
                throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(constructor) + "' with no args", instantiationException);
            }
            catch (InvocationTargetException invocationTargetException) {
                throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(constructor) + "' with no args", invocationTargetException.getCause());
            }
            catch (IllegalAccessException illegalAccessException) {
                throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(illegalAccessException);
            }
        };
    }

    private static <T> ObjectConstructor<T> newDefaultImplementationConstructor(Type type, Class<? super T> clazz) {
        if (Collection.class.isAssignableFrom(clazz)) {
            ObjectConstructor<? extends Collection<?>> objectConstructor = ConstructorConstructor.newCollectionConstructor(clazz);
            return objectConstructor;
        }
        if (Map.class.isAssignableFrom(clazz)) {
            ObjectConstructor<? extends Map<?, Object>> objectConstructor = ConstructorConstructor.newMapConstructor(type, clazz);
            return objectConstructor;
        }
        return null;
    }

    private static ObjectConstructor<? extends Collection<?>> newCollectionConstructor(Class<?> clazz) {
        if (clazz.isAssignableFrom(ArrayList.class)) {
            return ArrayList::new;
        }
        if (clazz.isAssignableFrom(LinkedHashSet.class)) {
            return LinkedHashSet::new;
        }
        if (clazz.isAssignableFrom(TreeSet.class)) {
            return TreeSet::new;
        }
        if (clazz.isAssignableFrom(ArrayDeque.class)) {
            return ArrayDeque::new;
        }
        return null;
    }

    private static boolean hasStringKeyType(Type type) {
        if (!(type instanceof ParameterizedType)) {
            return true;
        }
        Type[] typeArray = ((ParameterizedType)type).getActualTypeArguments();
        if (typeArray.length == 0) {
            return false;
        }
        return GsonTypes.getRawType(typeArray[0]) == String.class;
    }

    private static ObjectConstructor<? extends Map<?, Object>> newMapConstructor(Type type, Class<?> clazz) {
        if (clazz.isAssignableFrom(LinkedTreeMap.class) && ConstructorConstructor.hasStringKeyType(type)) {
            return () -> new LinkedTreeMap();
        }
        if (clazz.isAssignableFrom(LinkedHashMap.class)) {
            return LinkedHashMap::new;
        }
        if (clazz.isAssignableFrom(TreeMap.class)) {
            return TreeMap::new;
        }
        if (clazz.isAssignableFrom(ConcurrentHashMap.class)) {
            return ConcurrentHashMap::new;
        }
        if (clazz.isAssignableFrom(ConcurrentSkipListMap.class)) {
            return ConcurrentSkipListMap::new;
        }
        return null;
    }

    private <T> ObjectConstructor<T> newUnsafeAllocator(Class<? super T> clazz) {
        if (this.useJdkUnsafe) {
            return () -> {
                try {
                    Object t = UnsafeAllocator.INSTANCE.newInstance(clazz);
                    return t;
                }
                catch (Exception exception) {
                    throw new RuntimeException("Unable to create instance of " + clazz + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", exception);
                }
            };
        }
        String string = "Unable to create instance of " + clazz + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.";
        if (clazz.getDeclaredConstructors().length == 0) {
            string = string + " Or adjust your R8 configuration to keep the no-args constructor of the class.";
        }
        return new ThrowingObjectConstructor(string);
    }

    public String toString() {
        return this.instanceCreators.toString();
    }

    private static final class InstanceCreatorConstructor<T>
    implements ObjectConstructor<T> {
        private final InstanceCreator<T> instanceCreator;
        private final Type type;

        InstanceCreatorConstructor(InstanceCreator<T> instanceCreator, Type type) {
            this.instanceCreator = instanceCreator;
            this.type = type;
        }

        @Override
        public T construct() {
            return this.instanceCreator.createInstance(this.type);
        }
    }

    private static final class ThrowingObjectConstructor<T>
    implements ObjectConstructor<T> {
        private final String exceptionMessage;

        ThrowingObjectConstructor(String string) {
            this.exceptionMessage = string;
        }

        @Override
        public T construct() {
            throw new JsonIOException(this.exceptionMessage);
        }
    }
}


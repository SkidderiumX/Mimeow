/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.gson.reflect;

import com.viaversion.viaversion.libs.gson.internal.GsonTypes;
import com.viaversion.viaversion.libs.gson.internal.TroubleshootingGuide;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TypeToken<T> {
    private final Class<? super T> rawType;
    private final Type type;
    private final int hashCode;

    protected TypeToken() {
        this.type = this.getTypeTokenTypeArgument();
        this.rawType = GsonTypes.getRawType(this.type);
        this.hashCode = this.type.hashCode();
    }

    private TypeToken(Type type) {
        this.type = GsonTypes.canonicalize(Objects.requireNonNull(type));
        this.rawType = GsonTypes.getRawType(this.type);
        this.hashCode = this.type.hashCode();
    }

    private static boolean isCapturingTypeVariablesForbidden() {
        return !Objects.equals(System.getProperty("gson.allowCapturingTypeVariables"), "true");
    }

    private Type getTypeTokenTypeArgument() {
        Type type = this.getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType)type;
            if (parameterizedType.getRawType() == TypeToken.class) {
                Type type2 = GsonTypes.canonicalize(parameterizedType.getActualTypeArguments()[0]);
                if (TypeToken.isCapturingTypeVariablesForbidden()) {
                    TypeToken.verifyNoTypeVariable(type2);
                }
                return type2;
            }
        } else if (type == TypeToken.class) {
            throw new IllegalStateException("TypeToken must be created with a type argument: new TypeToken<...>() {}; When using code shrinkers (ProGuard, R8, ...) make sure that generic signatures are preserved.\nSee " + TroubleshootingGuide.createUrl("type-token-raw"));
        }
        throw new IllegalStateException("Must only create direct subclasses of TypeToken");
    }

    private static void verifyNoTypeVariable(Type type) {
        if (type instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable)type;
            throw new IllegalArgumentException("TypeToken type argument must not contain a type variable; captured type variable " + typeVariable.getName() + " declared by " + typeVariable.getGenericDeclaration() + "\nSee " + TroubleshootingGuide.createUrl("typetoken-type-variable"));
        }
        if (type instanceof GenericArrayType) {
            TypeToken.verifyNoTypeVariable(((GenericArrayType)type).getGenericComponentType());
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType)type;
            Type type2 = parameterizedType.getOwnerType();
            if (type2 != null) {
                TypeToken.verifyNoTypeVariable(type2);
            }
            for (Type type3 : parameterizedType.getActualTypeArguments()) {
                TypeToken.verifyNoTypeVariable(type3);
            }
        } else if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType)type;
            for (Type type4 : wildcardType.getLowerBounds()) {
                TypeToken.verifyNoTypeVariable(type4);
            }
            for (Type type4 : wildcardType.getUpperBounds()) {
                TypeToken.verifyNoTypeVariable(type4);
            }
        } else if (type == null) {
            throw new IllegalArgumentException("TypeToken captured `null` as type argument; probably a compiler / runtime bug");
        }
    }

    public final Class<? super T> getRawType() {
        return this.rawType;
    }

    public final Type getType() {
        return this.type;
    }

    @Deprecated
    public boolean isAssignableFrom(Class<?> clazz) {
        return this.isAssignableFrom((Type)clazz);
    }

    @Deprecated
    public boolean isAssignableFrom(Type type) {
        if (type == null) {
            return false;
        }
        if (this.type.equals(type)) {
            return true;
        }
        if (this.type instanceof Class) {
            return this.rawType.isAssignableFrom(GsonTypes.getRawType(type));
        }
        if (this.type instanceof ParameterizedType) {
            return TypeToken.isAssignableFrom(type, (ParameterizedType)this.type, new HashMap<String, Type>());
        }
        if (this.type instanceof GenericArrayType) {
            return this.rawType.isAssignableFrom(GsonTypes.getRawType(type)) && TypeToken.isAssignableFrom(type, (GenericArrayType)this.type);
        }
        throw TypeToken.buildUnsupportedTypeException(this.type, Class.class, ParameterizedType.class, GenericArrayType.class);
    }

    @Deprecated
    public boolean isAssignableFrom(TypeToken<?> typeToken) {
        return this.isAssignableFrom(typeToken.getType());
    }

    private static boolean isAssignableFrom(Type type, GenericArrayType genericArrayType) {
        Type type2 = genericArrayType.getGenericComponentType();
        if (type2 instanceof ParameterizedType) {
            Type type3 = type;
            if (type instanceof GenericArrayType) {
                type3 = ((GenericArrayType)type).getGenericComponentType();
            } else if (type instanceof Class) {
                Class<?> clazz = (Class<?>)type;
                while (clazz.isArray()) {
                    clazz = clazz.getComponentType();
                }
                type3 = clazz;
            }
            return TypeToken.isAssignableFrom(type3, (ParameterizedType)type2, new HashMap<String, Type>());
        }
        return true;
    }

    private static boolean isAssignableFrom(Type type, ParameterizedType parameterizedType, Map<String, Type> map) {
        if (type == null) {
            return false;
        }
        if (parameterizedType.equals(type)) {
            return true;
        }
        Class<?> clazz = GsonTypes.getRawType(type);
        ParameterizedType parameterizedType2 = null;
        if (type instanceof ParameterizedType) {
            parameterizedType2 = (ParameterizedType)type;
        }
        if (parameterizedType2 != null) {
            Type[] object = parameterizedType2.getActualTypeArguments();
            TypeVariable<Class<?>>[] typeVariableArray = clazz.getTypeParameters();
            for (int i = 0; i < object.length; ++i) {
                Type type2 = object[i];
                TypeVariable<Class<?>> typeVariable = typeVariableArray[i];
                while (type2 instanceof TypeVariable) {
                    TypeVariable typeVariable2 = (TypeVariable)type2;
                    type2 = map.get(typeVariable2.getName());
                }
                map.put(typeVariable.getName(), type2);
            }
            if (TypeToken.typeEquals(parameterizedType2, parameterizedType, map)) {
                return true;
            }
        }
        for (Type type2 : clazz.getGenericInterfaces()) {
            if (!TypeToken.isAssignableFrom(type2, parameterizedType, new HashMap<String, Type>(map))) continue;
            return true;
        }
        Type type3 = clazz.getGenericSuperclass();
        return TypeToken.isAssignableFrom(type3, parameterizedType, new HashMap<String, Type>(map));
    }

    private static boolean typeEquals(ParameterizedType parameterizedType, ParameterizedType parameterizedType2, Map<String, Type> map) {
        if (parameterizedType.getRawType().equals(parameterizedType2.getRawType())) {
            Type[] typeArray = parameterizedType.getActualTypeArguments();
            Type[] typeArray2 = parameterizedType2.getActualTypeArguments();
            for (int i = 0; i < typeArray.length; ++i) {
                if (TypeToken.matches(typeArray[i], typeArray2[i], map)) continue;
                return false;
            }
            return true;
        }
        return false;
    }

    private static IllegalArgumentException buildUnsupportedTypeException(Type type, Class<?> ... classArray) {
        StringBuilder stringBuilder = new StringBuilder("Unsupported type, expected one of: ");
        for (Class<?> clazz : classArray) {
            stringBuilder.append(clazz.getName()).append(", ");
        }
        stringBuilder.append("but got: ").append(type.getClass().getName()).append(", for type token: ").append(type.toString());
        return new IllegalArgumentException(stringBuilder.toString());
    }

    private static boolean matches(Type type, Type type2, Map<String, Type> map) {
        return type2.equals(type) || type instanceof TypeVariable && type2.equals(map.get(((TypeVariable)type).getName()));
    }

    public final int hashCode() {
        return this.hashCode;
    }

    public final boolean equals(Object object) {
        return object instanceof TypeToken && GsonTypes.equals(this.type, ((TypeToken)object).type);
    }

    public final String toString() {
        return GsonTypes.typeToString(this.type);
    }

    public static TypeToken<?> get(Type type) {
        return new TypeToken(type);
    }

    public static <T> TypeToken<T> get(Class<T> clazz) {
        return new TypeToken<T>(clazz);
    }

    public static TypeToken<?> getParameterized(Type type, Type ... typeArray) {
        Objects.requireNonNull(type);
        Objects.requireNonNull(typeArray);
        if (!(type instanceof Class)) {
            throw new IllegalArgumentException("rawType must be of type Class, but was " + type);
        }
        int n = typeArray.length;
        Class clazz = (Class)type;
        TypeVariable<Class<T>>[] typeVariableArray = clazz.getTypeParameters();
        int n2 = typeVariableArray.length;
        if (n != n2) {
            throw new IllegalArgumentException(clazz.getName() + " requires " + n2 + " type arguments, but got " + n);
        }
        if (typeArray.length == 0) {
            return TypeToken.get(clazz);
        }
        if (GsonTypes.requiresOwnerType(type)) {
            throw new IllegalArgumentException("Raw type " + clazz.getName() + " is not supported because it requires specifying an owner type");
        }
        for (int i = 0; i < n2; ++i) {
            Type type2 = Objects.requireNonNull(typeArray[i], "Type argument must not be null");
            Class<?> clazz2 = GsonTypes.getRawType(type2);
            TypeVariable typeVariable = typeVariableArray[i];
            for (Type type3 : typeVariable.getBounds()) {
                Class<?> clazz3 = GsonTypes.getRawType(type3);
                if (clazz3.isAssignableFrom(clazz2)) continue;
                throw new IllegalArgumentException("Type argument " + type2 + " does not satisfy bounds for type variable " + typeVariable + " declared by " + type);
            }
        }
        return new TypeToken(GsonTypes.newParameterizedTypeWithOwner(null, clazz, typeArray));
    }

    public static TypeToken<?> getArray(Type type) {
        return new TypeToken(GsonTypes.arrayOf(type));
    }
}


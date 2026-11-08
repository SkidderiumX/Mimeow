/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Primitives;
import com.google.common.reflect.Invokable;
import com.google.common.reflect.TypeCapture;
import com.google.common.reflect.TypeParameter;
import com.google.common.reflect.TypeResolver;
import com.google.common.reflect.TypeVisitor;
import com.google.common.reflect.Types;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@Beta
public abstract class TypeToken<T>
extends TypeCapture<T>
implements Serializable {
    private final Type runtimeType;
    private transient TypeResolver typeResolver;

    protected TypeToken() {
        this.runtimeType = this.capture();
        Preconditions.checkState(!(this.runtimeType instanceof TypeVariable), "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", this.runtimeType);
    }

    protected TypeToken(Class<?> clazz) {
        Type type = super.capture();
        this.runtimeType = type instanceof Class ? type : TypeToken.of(clazz).resolveType((Type)type).runtimeType;
    }

    private TypeToken(Type type) {
        this.runtimeType = Preconditions.checkNotNull(type);
    }

    public static <T> TypeToken<T> of(Class<T> clazz) {
        return new SimpleTypeToken((Type)clazz);
    }

    public static TypeToken<?> of(Type type) {
        return new SimpleTypeToken(type);
    }

    public final Class<? super T> getRawType() {
        Class<?> clazz;
        Class<?> clazz2 = clazz = TypeToken.getRawType(this.runtimeType);
        return clazz2;
    }

    private ImmutableSet<Class<? super T>> getImmediateRawTypes() {
        ImmutableSet<Class<? super T>> immutableSet = TypeToken.getRawTypes(this.runtimeType);
        return immutableSet;
    }

    public final Type getType() {
        return this.runtimeType;
    }

    public final <X> TypeToken<T> where(TypeParameter<X> typeParameter, TypeToken<X> typeToken) {
        TypeResolver typeResolver = new TypeResolver().where(ImmutableMap.of(new TypeResolver.TypeVariableKey(typeParameter.typeVariable), typeToken.runtimeType));
        return new SimpleTypeToken(typeResolver.resolveType(this.runtimeType));
    }

    public final <X> TypeToken<T> where(TypeParameter<X> typeParameter, Class<X> clazz) {
        return this.where(typeParameter, TypeToken.of(clazz));
    }

    public final TypeToken<?> resolveType(Type type) {
        Preconditions.checkNotNull(type);
        TypeResolver typeResolver = this.typeResolver;
        if (typeResolver == null) {
            typeResolver = this.typeResolver = TypeResolver.accordingTo(this.runtimeType);
        }
        return TypeToken.of(typeResolver.resolveType(type));
    }

    private Type[] resolveInPlace(Type[] typeArray) {
        for (int i = 0; i < typeArray.length; ++i) {
            typeArray[i] = this.resolveType(typeArray[i]).getType();
        }
        return typeArray;
    }

    private TypeToken<?> resolveSupertype(Type type) {
        TypeToken<?> typeToken = this.resolveType(type);
        typeToken.typeResolver = this.typeResolver;
        return typeToken;
    }

    @Nullable
    final TypeToken<? super T> getGenericSuperclass() {
        if (this.runtimeType instanceof TypeVariable) {
            return this.boundAsSuperclass(((TypeVariable)this.runtimeType).getBounds()[0]);
        }
        if (this.runtimeType instanceof WildcardType) {
            return this.boundAsSuperclass(((WildcardType)this.runtimeType).getUpperBounds()[0]);
        }
        Type type = this.getRawType().getGenericSuperclass();
        if (type == null) {
            return null;
        }
        TypeToken<?> typeToken = this.resolveSupertype(type);
        return typeToken;
    }

    @Nullable
    private TypeToken<? super T> boundAsSuperclass(Type type) {
        TypeToken<?> typeToken = TypeToken.of(type);
        if (typeToken.getRawType().isInterface()) {
            return null;
        }
        TypeToken<?> typeToken2 = typeToken;
        return typeToken2;
    }

    final ImmutableList<TypeToken<? super T>> getGenericInterfaces() {
        if (this.runtimeType instanceof TypeVariable) {
            return this.boundsAsInterfaces(((TypeVariable)this.runtimeType).getBounds());
        }
        if (this.runtimeType instanceof WildcardType) {
            return this.boundsAsInterfaces(((WildcardType)this.runtimeType).getUpperBounds());
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        for (Type type : this.getRawType().getGenericInterfaces()) {
            TypeToken<?> typeToken = this.resolveSupertype(type);
            builder.add(typeToken);
        }
        return builder.build();
    }

    private ImmutableList<TypeToken<? super T>> boundsAsInterfaces(Type[] typeArray) {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (Type type : typeArray) {
            TypeToken<?> typeToken = TypeToken.of(type);
            if (!typeToken.getRawType().isInterface()) continue;
            builder.add(typeToken);
        }
        return builder.build();
    }

    public final TypeSet getTypes() {
        return new TypeSet();
    }

    public final TypeToken<? super T> getSupertype(Class<? super T> clazz) {
        Preconditions.checkArgument(clazz.isAssignableFrom(this.getRawType()), "%s is not a super class of %s", clazz, this);
        if (this.runtimeType instanceof TypeVariable) {
            return this.getSupertypeFromUpperBounds(clazz, ((TypeVariable)this.runtimeType).getBounds());
        }
        if (this.runtimeType instanceof WildcardType) {
            return this.getSupertypeFromUpperBounds(clazz, ((WildcardType)this.runtimeType).getUpperBounds());
        }
        if (clazz.isArray()) {
            return this.getArraySupertype(clazz);
        }
        TypeToken<?> typeToken = this.resolveSupertype(TypeToken.toGenericType(clazz).runtimeType);
        return typeToken;
    }

    public final TypeToken<? extends T> getSubtype(Class<?> clazz) {
        Preconditions.checkArgument(!(this.runtimeType instanceof TypeVariable), "Cannot get subtype of type variable <%s>", this);
        if (this.runtimeType instanceof WildcardType) {
            return this.getSubtypeFromLowerBounds(clazz, ((WildcardType)this.runtimeType).getLowerBounds());
        }
        Preconditions.checkArgument(this.getRawType().isAssignableFrom(clazz), "%s isn't a subclass of %s", clazz, this);
        if (this.isArray()) {
            return this.getArraySubtype(clazz);
        }
        TypeToken<?> typeToken = TypeToken.of(this.resolveTypeArgsForSubclass(clazz));
        return typeToken;
    }

    public final boolean isAssignableFrom(TypeToken<?> typeToken) {
        return this.isAssignableFrom(typeToken.runtimeType);
    }

    public final boolean isAssignableFrom(Type type) {
        return TypeToken.isAssignable(Preconditions.checkNotNull(type), this.runtimeType);
    }

    public final boolean isArray() {
        return this.getComponentType() != null;
    }

    public final boolean isPrimitive() {
        return this.runtimeType instanceof Class && ((Class)this.runtimeType).isPrimitive();
    }

    public final TypeToken<T> wrap() {
        if (this.isPrimitive()) {
            Class clazz = (Class)this.runtimeType;
            return TypeToken.of(Primitives.wrap(clazz));
        }
        return this;
    }

    private boolean isWrapper() {
        return Primitives.allWrapperTypes().contains(this.runtimeType);
    }

    public final TypeToken<T> unwrap() {
        if (this.isWrapper()) {
            Class clazz = (Class)this.runtimeType;
            return TypeToken.of(Primitives.unwrap(clazz));
        }
        return this;
    }

    @Nullable
    public final TypeToken<?> getComponentType() {
        Type type = Types.getComponentType(this.runtimeType);
        if (type == null) {
            return null;
        }
        return TypeToken.of(type);
    }

    public final Invokable<T, Object> method(Method method) {
        Preconditions.checkArgument(TypeToken.of(method.getDeclaringClass()).isAssignableFrom(this), "%s not declared by %s", method, this);
        return new Invokable.MethodInvokable<T>(method){

            @Override
            Type getGenericReturnType() {
                return TypeToken.this.resolveType(super.getGenericReturnType()).getType();
            }

            @Override
            Type[] getGenericParameterTypes() {
                return TypeToken.this.resolveInPlace(super.getGenericParameterTypes());
            }

            @Override
            Type[] getGenericExceptionTypes() {
                return TypeToken.this.resolveInPlace(super.getGenericExceptionTypes());
            }

            @Override
            public TypeToken<T> getOwnerType() {
                return TypeToken.this;
            }

            @Override
            public String toString() {
                return this.getOwnerType() + "." + super.toString();
            }
        };
    }

    public final Invokable<T, T> constructor(Constructor<?> constructor) {
        Preconditions.checkArgument(constructor.getDeclaringClass() == this.getRawType(), "%s not declared by %s", constructor, this.getRawType());
        return new Invokable.ConstructorInvokable<T>(constructor){

            @Override
            Type getGenericReturnType() {
                return TypeToken.this.resolveType(super.getGenericReturnType()).getType();
            }

            @Override
            Type[] getGenericParameterTypes() {
                return TypeToken.this.resolveInPlace(super.getGenericParameterTypes());
            }

            @Override
            Type[] getGenericExceptionTypes() {
                return TypeToken.this.resolveInPlace(super.getGenericExceptionTypes());
            }

            @Override
            public TypeToken<T> getOwnerType() {
                return TypeToken.this;
            }

            @Override
            public String toString() {
                return this.getOwnerType() + "(" + Joiner.on(", ").join(this.getGenericParameterTypes()) + ")";
            }
        };
    }

    public boolean equals(@Nullable Object object) {
        if (object instanceof TypeToken) {
            TypeToken typeToken = (TypeToken)object;
            return this.runtimeType.equals(typeToken.runtimeType);
        }
        return false;
    }

    public int hashCode() {
        return this.runtimeType.hashCode();
    }

    public String toString() {
        return Types.toString(this.runtimeType);
    }

    protected Object writeReplace() {
        return TypeToken.of(new TypeResolver().resolveType(this.runtimeType));
    }

    final TypeToken<T> rejectTypeVariables() {
        new TypeVisitor(){

            @Override
            void visitTypeVariable(TypeVariable<?> typeVariable) {
                throw new IllegalArgumentException(TypeToken.this.runtimeType + "contains a type variable and is not safe for the operation");
            }

            @Override
            void visitWildcardType(WildcardType wildcardType) {
                this.visit(wildcardType.getLowerBounds());
                this.visit(wildcardType.getUpperBounds());
            }

            @Override
            void visitParameterizedType(ParameterizedType parameterizedType) {
                this.visit(parameterizedType.getActualTypeArguments());
                this.visit(parameterizedType.getOwnerType());
            }

            @Override
            void visitGenericArrayType(GenericArrayType genericArrayType) {
                this.visit(genericArrayType.getGenericComponentType());
            }
        }.visit(this.runtimeType);
        return this;
    }

    private static boolean isAssignable(Type type, Type type2) {
        if (type2.equals(type)) {
            return true;
        }
        if (type2 instanceof WildcardType) {
            return TypeToken.isAssignableToWildcardType(type, (WildcardType)type2);
        }
        if (type instanceof TypeVariable) {
            return TypeToken.isAssignableFromAny(((TypeVariable)type).getBounds(), type2);
        }
        if (type instanceof WildcardType) {
            return TypeToken.isAssignableFromAny(((WildcardType)type).getUpperBounds(), type2);
        }
        if (type instanceof GenericArrayType) {
            return TypeToken.isAssignableFromGenericArrayType((GenericArrayType)type, type2);
        }
        if (type2 instanceof Class) {
            return TypeToken.isAssignableToClass(type, (Class)type2);
        }
        if (type2 instanceof ParameterizedType) {
            return TypeToken.isAssignableToParameterizedType(type, (ParameterizedType)type2);
        }
        if (type2 instanceof GenericArrayType) {
            return TypeToken.isAssignableToGenericArrayType(type, (GenericArrayType)type2);
        }
        return false;
    }

    private static boolean isAssignableFromAny(Type[] typeArray, Type type) {
        for (Type type2 : typeArray) {
            if (!TypeToken.isAssignable(type2, type)) continue;
            return true;
        }
        return false;
    }

    private static boolean isAssignableToClass(Type type, Class<?> clazz) {
        return clazz.isAssignableFrom(TypeToken.getRawType(type));
    }

    private static boolean isAssignableToWildcardType(Type type, WildcardType wildcardType) {
        return TypeToken.isAssignable(type, TypeToken.supertypeBound(wildcardType)) && TypeToken.isAssignableBySubtypeBound(type, wildcardType);
    }

    private static boolean isAssignableBySubtypeBound(Type type, WildcardType wildcardType) {
        Type type2 = TypeToken.subtypeBound(wildcardType);
        if (type2 == null) {
            return true;
        }
        Type type3 = TypeToken.subtypeBound(type);
        if (type3 == null) {
            return false;
        }
        return TypeToken.isAssignable(type2, type3);
    }

    private static boolean isAssignableToParameterizedType(Type type, ParameterizedType parameterizedType) {
        Class<?> clazz = TypeToken.getRawType(parameterizedType);
        if (!clazz.isAssignableFrom(TypeToken.getRawType(type))) {
            return false;
        }
        TypeVariable<Class<?>>[] typeVariableArray = clazz.getTypeParameters();
        Type[] typeArray = parameterizedType.getActualTypeArguments();
        TypeToken<?> typeToken = TypeToken.of(type);
        for (int i = 0; i < typeVariableArray.length; ++i) {
            Type type2 = typeToken.resolveType(typeVariableArray[i]).runtimeType;
            if (TypeToken.matchTypeArgument(type2, typeArray[i])) continue;
            return false;
        }
        return true;
    }

    private static boolean isAssignableToGenericArrayType(Type type, GenericArrayType genericArrayType) {
        if (type instanceof Class) {
            Class clazz = (Class)type;
            if (!clazz.isArray()) {
                return false;
            }
            return TypeToken.isAssignable(clazz.getComponentType(), genericArrayType.getGenericComponentType());
        }
        if (type instanceof GenericArrayType) {
            GenericArrayType genericArrayType2 = (GenericArrayType)type;
            return TypeToken.isAssignable(genericArrayType2.getGenericComponentType(), genericArrayType.getGenericComponentType());
        }
        return false;
    }

    private static boolean isAssignableFromGenericArrayType(GenericArrayType genericArrayType, Type type) {
        if (type instanceof Class) {
            Class clazz = (Class)type;
            if (!clazz.isArray()) {
                return clazz == Object.class;
            }
            return TypeToken.isAssignable(genericArrayType.getGenericComponentType(), clazz.getComponentType());
        }
        if (type instanceof GenericArrayType) {
            GenericArrayType genericArrayType2 = (GenericArrayType)type;
            return TypeToken.isAssignable(genericArrayType.getGenericComponentType(), genericArrayType2.getGenericComponentType());
        }
        return false;
    }

    private static boolean matchTypeArgument(Type type, Type type2) {
        if (type.equals(type2)) {
            return true;
        }
        if (type2 instanceof WildcardType) {
            return TypeToken.isAssignableToWildcardType(type, (WildcardType)type2);
        }
        return false;
    }

    private static Type supertypeBound(Type type) {
        if (type instanceof WildcardType) {
            return TypeToken.supertypeBound((WildcardType)type);
        }
        return type;
    }

    private static Type supertypeBound(WildcardType wildcardType) {
        Type[] typeArray = wildcardType.getUpperBounds();
        if (typeArray.length == 1) {
            return TypeToken.supertypeBound(typeArray[0]);
        }
        if (typeArray.length == 0) {
            return Object.class;
        }
        throw new AssertionError((Object)("There should be at most one upper bound for wildcard type: " + wildcardType));
    }

    @Nullable
    private static Type subtypeBound(Type type) {
        if (type instanceof WildcardType) {
            return TypeToken.subtypeBound((WildcardType)type);
        }
        return type;
    }

    @Nullable
    private static Type subtypeBound(WildcardType wildcardType) {
        Type[] typeArray = wildcardType.getLowerBounds();
        if (typeArray.length == 1) {
            return TypeToken.subtypeBound(typeArray[0]);
        }
        if (typeArray.length == 0) {
            return null;
        }
        throw new AssertionError((Object)("Wildcard should have at most one lower bound: " + wildcardType));
    }

    @VisibleForTesting
    static Class<?> getRawType(Type type) {
        return (Class)TypeToken.getRawTypes(type).iterator().next();
    }

    @VisibleForTesting
    static ImmutableSet<Class<?>> getRawTypes(Type type) {
        Preconditions.checkNotNull(type);
        final ImmutableSet.Builder builder = ImmutableSet.builder();
        new TypeVisitor(){

            @Override
            void visitTypeVariable(TypeVariable<?> typeVariable) {
                this.visit(typeVariable.getBounds());
            }

            @Override
            void visitWildcardType(WildcardType wildcardType) {
                this.visit(wildcardType.getUpperBounds());
            }

            @Override
            void visitParameterizedType(ParameterizedType parameterizedType) {
                builder.add((Class)parameterizedType.getRawType());
            }

            @Override
            void visitClass(Class<?> clazz) {
                builder.add(clazz);
            }

            @Override
            void visitGenericArrayType(GenericArrayType genericArrayType) {
                builder.add(Types.getArrayClass(TypeToken.getRawType(genericArrayType.getGenericComponentType())));
            }
        }.visit(type);
        return builder.build();
    }

    @VisibleForTesting
    static <T> TypeToken<? extends T> toGenericType(Class<T> clazz) {
        if (clazz.isArray()) {
            Type type = Types.newArrayType(TypeToken.toGenericType(clazz.getComponentType()).runtimeType);
            TypeToken<?> typeToken = TypeToken.of(type);
            return typeToken;
        }
        Type[] typeArray = clazz.getTypeParameters();
        if (typeArray.length > 0) {
            TypeToken<?> typeToken = TypeToken.of(Types.newParameterizedType(clazz, typeArray));
            return typeToken;
        }
        return TypeToken.of(clazz);
    }

    private TypeToken<? super T> getSupertypeFromUpperBounds(Class<? super T> clazz, Type[] typeArray) {
        for (Type type : typeArray) {
            TypeToken<?> typeToken = TypeToken.of(type);
            if (!TypeToken.of(clazz).isAssignableFrom(typeToken)) continue;
            TypeToken<? super T> typeToken2 = typeToken.getSupertype(clazz);
            return typeToken2;
        }
        throw new IllegalArgumentException(clazz + " isn't a super type of " + this);
    }

    private TypeToken<? extends T> getSubtypeFromLowerBounds(Class<?> clazz, Type[] typeArray) {
        int n = 0;
        Type[] typeArray2 = typeArray;
        int n2 = typeArray2.length;
        if (n < n2) {
            Type type = typeArray2[n];
            TypeToken<?> typeToken = TypeToken.of(type);
            return typeToken.getSubtype(clazz);
        }
        throw new IllegalArgumentException(clazz + " isn't a subclass of " + this);
    }

    private TypeToken<? super T> getArraySupertype(Class<? super T> clazz) {
        TypeToken<?> typeToken = Preconditions.checkNotNull(this.getComponentType(), "%s isn't a super type of %s", clazz, this);
        TypeToken<?> typeToken2 = typeToken.getSupertype(clazz.getComponentType());
        TypeToken<?> typeToken3 = TypeToken.of(TypeToken.newArrayClassOrGenericArrayType(typeToken2.runtimeType));
        return typeToken3;
    }

    private TypeToken<? extends T> getArraySubtype(Class<?> clazz) {
        TypeToken<?> typeToken = this.getComponentType().getSubtype(clazz.getComponentType());
        TypeToken<?> typeToken2 = TypeToken.of(TypeToken.newArrayClassOrGenericArrayType(typeToken.runtimeType));
        return typeToken2;
    }

    private Type resolveTypeArgsForSubclass(Class<?> clazz) {
        if (this.runtimeType instanceof Class) {
            return clazz;
        }
        TypeToken<?> typeToken = TypeToken.toGenericType(clazz);
        Type type = typeToken.getSupertype(this.getRawType()).runtimeType;
        return new TypeResolver().where(type, this.runtimeType).resolveType(typeToken.runtimeType);
    }

    private static Type newArrayClassOrGenericArrayType(Type type) {
        return Types.JavaVersion.JAVA7.newArrayType(type);
    }

    private static abstract class TypeCollector<K> {
        static final TypeCollector<TypeToken<?>> FOR_GENERIC_TYPE = new TypeCollector<TypeToken<?>>(){

            @Override
            Class<?> getRawType(TypeToken<?> typeToken) {
                return typeToken.getRawType();
            }

            @Override
            Iterable<? extends TypeToken<?>> getInterfaces(TypeToken<?> typeToken) {
                return typeToken.getGenericInterfaces();
            }

            @Override
            @Nullable
            TypeToken<?> getSuperclass(TypeToken<?> typeToken) {
                return typeToken.getGenericSuperclass();
            }
        };
        static final TypeCollector<Class<?>> FOR_RAW_TYPE = new TypeCollector<Class<?>>(){

            @Override
            Class<?> getRawType(Class<?> clazz) {
                return clazz;
            }

            @Override
            Iterable<? extends Class<?>> getInterfaces(Class<?> clazz) {
                return Arrays.asList(clazz.getInterfaces());
            }

            @Override
            @Nullable
            Class<?> getSuperclass(Class<?> clazz) {
                return clazz.getSuperclass();
            }
        };

        private TypeCollector() {
        }

        final TypeCollector<K> classesOnly() {
            return new ForwardingTypeCollector<K>(this){

                @Override
                Iterable<? extends K> getInterfaces(K k) {
                    return ImmutableSet.of();
                }

                @Override
                ImmutableList<K> collectTypes(Iterable<? extends K> iterable) {
                    ImmutableList.Builder builder = ImmutableList.builder();
                    for (Object k : iterable) {
                        if (this.getRawType(k).isInterface()) continue;
                        builder.add(k);
                    }
                    return super.collectTypes(builder.build());
                }
            };
        }

        final ImmutableList<K> collectTypes(K k) {
            return this.collectTypes((Iterable<? extends K>)ImmutableList.of(k));
        }

        ImmutableList<K> collectTypes(Iterable<? extends K> iterable) {
            HashMap hashMap = Maps.newHashMap();
            for (K k : iterable) {
                this.collectTypes(k, hashMap);
            }
            return TypeCollector.sortKeysByValue(hashMap, Ordering.natural().reverse());
        }

        private int collectTypes(K k, Map<? super K, Integer> map) {
            Integer n = map.get(this);
            if (n != null) {
                return n;
            }
            int n2 = this.getRawType(k).isInterface() ? 1 : 0;
            for (K k2 : this.getInterfaces(k)) {
                n2 = Math.max(n2, this.collectTypes(k2, map));
            }
            Iterator<K> iterator2 = this.getSuperclass(k);
            if (iterator2 != null) {
                n2 = Math.max(n2, this.collectTypes(iterator2, map));
            }
            map.put(k, n2 + 1);
            return n2 + 1;
        }

        private static <K, V> ImmutableList<K> sortKeysByValue(final Map<K, V> map, final Comparator<? super V> comparator) {
            Ordering ordering = new Ordering<K>(){

                @Override
                public int compare(K k, K k2) {
                    return comparator.compare(map.get(k), map.get(k2));
                }
            };
            return ordering.immutableSortedCopy(map.keySet());
        }

        abstract Class<?> getRawType(K var1);

        abstract Iterable<? extends K> getInterfaces(K var1);

        @Nullable
        abstract K getSuperclass(K var1);

        private static class ForwardingTypeCollector<K>
        extends TypeCollector<K> {
            private final TypeCollector<K> delegate;

            ForwardingTypeCollector(TypeCollector<K> typeCollector) {
                this.delegate = typeCollector;
            }

            @Override
            Class<?> getRawType(K k) {
                return this.delegate.getRawType(k);
            }

            @Override
            Iterable<? extends K> getInterfaces(K k) {
                return this.delegate.getInterfaces(k);
            }

            @Override
            K getSuperclass(K k) {
                return this.delegate.getSuperclass(k);
            }
        }
    }

    private static final class SimpleTypeToken<T>
    extends TypeToken<T> {
        private static final long serialVersionUID = 0L;

        SimpleTypeToken(Type type) {
            super(type);
        }
    }

    private static enum TypeFilter implements Predicate<TypeToken<?>>
    {
        IGNORE_TYPE_VARIABLE_OR_WILDCARD{

            @Override
            public boolean apply(TypeToken<?> typeToken) {
                return !(((TypeToken)typeToken).runtimeType instanceof TypeVariable) && !(((TypeToken)typeToken).runtimeType instanceof WildcardType);
            }
        }
        ,
        INTERFACE_ONLY{

            @Override
            public boolean apply(TypeToken<?> typeToken) {
                return typeToken.getRawType().isInterface();
            }
        };

    }

    private final class ClassSet
    extends TypeSet {
        private transient ImmutableSet<TypeToken<? super T>> classes;
        private static final long serialVersionUID = 0L;

        private ClassSet() {
        }

        @Override
        protected Set<TypeToken<? super T>> delegate() {
            ImmutableSet immutableSet = this.classes;
            if (immutableSet == null) {
                ImmutableList<TypeToken> immutableList = TypeCollector.FOR_GENERIC_TYPE.classesOnly().collectTypes(TypeToken.this);
                this.classes = FluentIterable.from(immutableList).filter(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).toSet();
                return this.classes;
            }
            return immutableSet;
        }

        @Override
        public TypeSet classes() {
            return this;
        }

        @Override
        public Set<Class<? super T>> rawTypes() {
            ImmutableList<Class<?>> immutableList = TypeCollector.FOR_RAW_TYPE.classesOnly().collectTypes(TypeToken.this.getImmediateRawTypes());
            return ImmutableSet.copyOf(immutableList);
        }

        @Override
        public TypeSet interfaces() {
            throw new UnsupportedOperationException("classes().interfaces() not supported.");
        }

        private Object readResolve() {
            return TypeToken.this.getTypes().classes();
        }
    }

    private final class InterfaceSet
    extends TypeSet {
        private final transient TypeSet allTypes;
        private transient ImmutableSet<TypeToken<? super T>> interfaces;
        private static final long serialVersionUID = 0L;

        InterfaceSet(TypeSet typeSet) {
            this.allTypes = typeSet;
        }

        @Override
        protected Set<TypeToken<? super T>> delegate() {
            ImmutableSet immutableSet = this.interfaces;
            if (immutableSet == null) {
                this.interfaces = FluentIterable.from(this.allTypes).filter(TypeFilter.INTERFACE_ONLY).toSet();
                return this.interfaces;
            }
            return immutableSet;
        }

        @Override
        public TypeSet interfaces() {
            return this;
        }

        @Override
        public Set<Class<? super T>> rawTypes() {
            ImmutableList<Class<?>> immutableList = TypeCollector.FOR_RAW_TYPE.collectTypes(TypeToken.this.getImmediateRawTypes());
            return FluentIterable.from(immutableList).filter(new Predicate<Class<?>>(){

                @Override
                public boolean apply(Class<?> clazz) {
                    return clazz.isInterface();
                }
            }).toSet();
        }

        @Override
        public TypeSet classes() {
            throw new UnsupportedOperationException("interfaces().classes() not supported.");
        }

        private Object readResolve() {
            return TypeToken.this.getTypes().interfaces();
        }
    }

    public class TypeSet
    extends ForwardingSet<TypeToken<? super T>>
    implements Serializable {
        private transient ImmutableSet<TypeToken<? super T>> types;
        private static final long serialVersionUID = 0L;

        TypeSet() {
        }

        public TypeSet interfaces() {
            return new InterfaceSet(this);
        }

        public TypeSet classes() {
            return new ClassSet();
        }

        @Override
        protected Set<TypeToken<? super T>> delegate() {
            ImmutableSet immutableSet = this.types;
            if (immutableSet == null) {
                ImmutableList<TypeToken> immutableList = TypeCollector.FOR_GENERIC_TYPE.collectTypes(TypeToken.this);
                this.types = FluentIterable.from(immutableList).filter(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).toSet();
                return this.types;
            }
            return immutableSet;
        }

        public Set<Class<? super T>> rawTypes() {
            ImmutableList<Class<?>> immutableList = TypeCollector.FOR_RAW_TYPE.collectTypes(TypeToken.this.getImmediateRawTypes());
            return ImmutableSet.copyOf(immutableList);
        }
    }
}


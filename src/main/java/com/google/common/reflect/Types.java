package com.google.common.reflect;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.ImmutableList.Builder;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

public class Types {
   private static final Function<Type, String> TYPE_TO_STRING = new Function<Type, String>() {
      public String apply(Type var1) {
         return Types.toString(var1);
      }
   };
   private static final Joiner COMMA_JOINER = Joiner.on(", ").useForNull("null");

   static Type newArrayType(Type var0) {
      if (var0 instanceof WildcardType) {
         WildcardType var1 = (WildcardType)var0;
         Type[] var2 = var1.getLowerBounds();
         Preconditions.checkArgument(var2.length <= 1, "Wildcard cannot have more than one lower bounds.");
         if (var2.length == 1) {
            return supertypeOf(newArrayType(var2[0]));
         } else {
            Type[] var3 = var1.getUpperBounds();
            Preconditions.checkArgument(var3.length == 1, "Wildcard should have only one upper bound.");
            return subtypeOf(newArrayType(var3[0]));
         }
      } else {
         return Types.JavaVersion.CURRENT.newArrayType(var0);
      }
   }

   static ParameterizedType newParameterizedTypeWithOwner(@Nullable Type var0, Class<?> var1, Type... var2) {
      if (var0 == null) {
         return newParameterizedType(var1, var2);
      } else {
         Preconditions.checkNotNull(var2);
         Preconditions.checkArgument(var1.getEnclosingClass() != null, "Owner type for unenclosed %s", new Object[]{var1});
         return new Types.ParameterizedTypeImpl(var0, var1, var2);
      }
   }

   static ParameterizedType newParameterizedType(Class<?> var0, Type... var1) {
      return new Types.ParameterizedTypeImpl(Types.ClassOwnership.JVM_BEHAVIOR.getOwnerType(var0), var0, var1);
   }

   static <D extends GenericDeclaration> TypeVariable<D> newArtificialTypeVariable(D var0, String var1, Type... var2) {
      return new Types.TypeVariableImpl<>((D)var0, var1, var2.length == 0 ? new Type[]{Object.class} : var2);
   }

   @VisibleForTesting
   static WildcardType subtypeOf(Type var0) {
      return new Types.WildcardTypeImpl(new Type[0], new Type[]{var0});
   }

   @VisibleForTesting
   static WildcardType supertypeOf(Type var0) {
      return new Types.WildcardTypeImpl(new Type[]{var0}, new Type[]{Object.class});
   }

   static String toString(Type var0) {
      return var0 instanceof Class ? ((Class)var0).getName() : var0.toString();
   }

   @Nullable
   static Type getComponentType(Type var0) {
      Preconditions.checkNotNull(var0);
      final AtomicReference var1 = new AtomicReference();
      (new TypeVisitor() {
         void visitTypeVariable(TypeVariable<?> var1x) {
            var1.set(Types.subtypeOfComponentType(var1x.getBounds()));
         }

         void visitWildcardType(WildcardType var1x) {
            var1.set(Types.subtypeOfComponentType(var1x.getUpperBounds()));
         }

         void visitGenericArrayType(GenericArrayType var1x) {
            var1.set(var1x.getGenericComponentType());
         }

         void visitClass(Class<?> var1x) {
            var1.set(var1x.getComponentType());
         }
      }).visit(new Type[]{var0});
      return (Type)var1.get();
   }

   @Nullable
   private static Type subtypeOfComponentType(Type[] var0) {
      for (Type var4 : var0) {
         Type var5 = getComponentType(var4);
         if (var5 != null) {
            if (var5 instanceof Class) {
               Class var6 = (Class)var5;
               if (var6.isPrimitive()) {
                  return var6;
               }
            }

            return subtypeOf(var5);
         }
      }

      return null;
   }

   private static Type[] toArray(Collection<Type> var0) {
      return var0.toArray(new Type[var0.size()]);
   }

   private static Iterable<Type> filterUpperBounds(Iterable<Type> var0) {
      return Iterables.filter(var0, Predicates.not(Predicates.equalTo(Object.class)));
   }

   private static void disallowPrimitiveType(Type[] var0, String var1) {
      for (Type var5 : var0) {
         if (var5 instanceof Class) {
            Class var6 = (Class)var5;
            Preconditions.checkArgument(!var6.isPrimitive(), "Primitive type '%s' used as %s", new Object[]{var6, var1});
         }
      }
   }

   static Class<?> getArrayClass(Class<?> var0) {
      return Array.newInstance(var0, 0).getClass();
   }

   private Types() {
   }

   private static enum ClassOwnership {
      OWNED_BY_ENCLOSING_CLASS {
         @Nullable
         @Override
         Class<?> getOwnerType(Class<?> var1) {
            return var1.getEnclosingClass();
         }
      },
      LOCAL_CLASS_HAS_NO_OWNER {
         @Nullable
         @Override
         Class<?> getOwnerType(Class<?> var1) {
            return var1.isLocalClass() ? null : var1.getEnclosingClass();
         }
      };

      static final Types.ClassOwnership JVM_BEHAVIOR = detectJvmBehavior();

      private ClassOwnership() {
      }

      @Nullable
      abstract Class<?> getOwnerType(Class<?> var1);

      private static Types.ClassOwnership detectJvmBehavior() {
         Class var0 = (new LocalClass<String>() {}).getClass();
         ParameterizedType var1 = (ParameterizedType)var0.getGenericSuperclass();

         for (Types.ClassOwnership var5 : values()) {
            class LocalClass<T> {
            }

            if (var5.getOwnerType(LocalClass.class) == var1.getOwnerType()) {
               return var5;
            }
         }

         throw new AssertionError();
      }
   }

   private static final class GenericArrayTypeImpl implements GenericArrayType, Serializable {
      private final Type componentType;
      private static final long serialVersionUID = 0L;

      GenericArrayTypeImpl(Type var1) {
         this.componentType = Types.JavaVersion.CURRENT.usedInGenericType(var1);
      }

      @Override
      public Type getGenericComponentType() {
         return this.componentType;
      }

      @Override
      public String toString() {
         return Types.toString(this.componentType) + "[]";
      }

      @Override
      public int hashCode() {
         return this.componentType.hashCode();
      }

      @Override
      public boolean equals(Object var1) {
         if (var1 instanceof GenericArrayType) {
            GenericArrayType var2 = (GenericArrayType)var1;
            return Objects.equal(this.getGenericComponentType(), var2.getGenericComponentType());
         } else {
            return false;
         }
      }
   }

   static enum JavaVersion {
      JAVA6 {
         GenericArrayType newArrayType(Type var1) {
            return new Types.GenericArrayTypeImpl(var1);
         }

         @Override
         Type usedInGenericType(Type var1) {
            Preconditions.checkNotNull(var1);
            if (var1 instanceof Class) {
               Class var2 = (Class)var1;
               if (var2.isArray()) {
                  return new Types.GenericArrayTypeImpl(var2.getComponentType());
               }
            }

            return var1;
         }
      },
      JAVA7 {
         @Override
         Type newArrayType(Type var1) {
            return (Type)(var1 instanceof Class ? Types.getArrayClass((Class<?>)var1) : new Types.GenericArrayTypeImpl(var1));
         }

         @Override
         Type usedInGenericType(Type var1) {
            return (Type)Preconditions.checkNotNull(var1);
         }
      };

      static final Types.JavaVersion CURRENT = (new TypeCapture<int[]>() {}).capture() instanceof Class ? JAVA7 : JAVA6;

      private JavaVersion() {
      }

      abstract Type newArrayType(Type var1);

      abstract Type usedInGenericType(Type var1);

      final ImmutableList<Type> usedInGenericType(Type[] var1) {
         Builder var2 = ImmutableList.builder();

         for (Type var6 : var1) {
            var2.add(this.usedInGenericType(var6));
         }

         return var2.build();
      }
   }

   static final class NativeTypeVariableEquals<X> {
      static final boolean NATIVE_TYPE_VARIABLE_ONLY = !Types.NativeTypeVariableEquals.class.getTypeParameters()[0]
         .equals(Types.newArtificialTypeVariable(Types.NativeTypeVariableEquals.class, "X"));
   }

   private static final class ParameterizedTypeImpl implements ParameterizedType, Serializable {
      private final Type ownerType;
      private final ImmutableList<Type> argumentsList;
      private final Class<?> rawType;
      private static final long serialVersionUID = 0L;

      ParameterizedTypeImpl(@Nullable Type var1, Class<?> var2, Type[] var3) {
         Preconditions.checkNotNull(var2);
         Preconditions.checkArgument(var3.length == var2.getTypeParameters().length);
         Types.disallowPrimitiveType(var3, "type parameter");
         this.ownerType = var1;
         this.rawType = var2;
         this.argumentsList = Types.JavaVersion.CURRENT.usedInGenericType(var3);
      }

      @Override
      public Type[] getActualTypeArguments() {
         return Types.toArray(this.argumentsList);
      }

      @Override
      public Type getRawType() {
         return this.rawType;
      }

      @Override
      public Type getOwnerType() {
         return this.ownerType;
      }

      @Override
      public String toString() {
         StringBuilder var1 = new StringBuilder();
         if (this.ownerType != null) {
            var1.append(Types.toString(this.ownerType)).append('.');
         }

         var1.append(this.rawType.getName())
            .append('<')
            .append(Types.COMMA_JOINER.join(Iterables.transform(this.argumentsList, Types.TYPE_TO_STRING)))
            .append('>');
         return var1.toString();
      }

      @Override
      public int hashCode() {
         return (this.ownerType == null ? 0 : this.ownerType.hashCode()) ^ this.argumentsList.hashCode() ^ this.rawType.hashCode();
      }

      @Override
      public boolean equals(Object var1) {
         if (!(var1 instanceof ParameterizedType)) {
            return false;
         } else {
            ParameterizedType var2 = (ParameterizedType)var1;
            return this.getRawType().equals(var2.getRawType())
               && Objects.equal(this.getOwnerType(), var2.getOwnerType())
               && Arrays.equals((Object[])this.getActualTypeArguments(), (Object[])var2.getActualTypeArguments());
         }
      }
   }

   private static final class TypeVariableImpl<D extends GenericDeclaration> implements TypeVariable<D> {
      private final D genericDeclaration;
      private final String name;
      private final ImmutableList<Type> bounds;

      TypeVariableImpl(D var1, String var2, Type[] var3) {
         Types.disallowPrimitiveType(var3, "bound for type variable");
         this.genericDeclaration = (D)Preconditions.checkNotNull(var1);
         this.name = (String)Preconditions.checkNotNull(var2);
         this.bounds = ImmutableList.copyOf(var3);
      }

      @Override
      public Type[] getBounds() {
         return Types.toArray(this.bounds);
      }

      @Override
      public D getGenericDeclaration() {
         return this.genericDeclaration;
      }

      @Override
      public String getName() {
         return this.name;
      }

      @Override
      public String toString() {
         return this.name;
      }

      @Override
      public int hashCode() {
         return this.genericDeclaration.hashCode() ^ this.name.hashCode();
      }

      @Override
      public boolean equals(Object var1) {
         if (Types.NativeTypeVariableEquals.NATIVE_TYPE_VARIABLE_ONLY) {
            if (!(var1 instanceof Types.TypeVariableImpl)) {
               return false;
            } else {
               Types.TypeVariableImpl var3 = (Types.TypeVariableImpl)var1;
               return this.name.equals(var3.getName()) && this.genericDeclaration.equals(var3.getGenericDeclaration()) && this.bounds.equals(var3.bounds);
            }
         } else if (!(var1 instanceof TypeVariable)) {
            return false;
         } else {
            TypeVariable var2 = (TypeVariable)var1;
            return this.name.equals(var2.getName()) && this.genericDeclaration.equals(var2.getGenericDeclaration());
         }
      }
   }

   static final class WildcardTypeImpl implements WildcardType, Serializable {
      private final ImmutableList<Type> lowerBounds;
      private final ImmutableList<Type> upperBounds;
      private static final long serialVersionUID = 0L;

      WildcardTypeImpl(Type[] var1, Type[] var2) {
         Types.disallowPrimitiveType(var1, "lower bound for wildcard");
         Types.disallowPrimitiveType(var2, "upper bound for wildcard");
         this.lowerBounds = Types.JavaVersion.CURRENT.usedInGenericType(var1);
         this.upperBounds = Types.JavaVersion.CURRENT.usedInGenericType(var2);
      }

      @Override
      public Type[] getLowerBounds() {
         return Types.toArray(this.lowerBounds);
      }

      @Override
      public Type[] getUpperBounds() {
         return Types.toArray(this.upperBounds);
      }

      @Override
      public boolean equals(Object var1) {
         if (!(var1 instanceof WildcardType)) {
            return false;
         } else {
            WildcardType var2 = (WildcardType)var1;
            return this.lowerBounds.equals(Arrays.asList(var2.getLowerBounds())) && this.upperBounds.equals(Arrays.asList(var2.getUpperBounds()));
         }
      }

      @Override
      public int hashCode() {
         return this.lowerBounds.hashCode() ^ this.upperBounds.hashCode();
      }

      @Override
      public String toString() {
         StringBuilder var1 = new StringBuilder("?");

         for (Type var3 : this.lowerBounds) {
            var1.append(" super ").append(Types.toString(var3));
         }

         for (Type var5 : Types.filterUpperBounds(this.upperBounds)) {
            var1.append(" extends ").append(Types.toString(var5));
         }

         return var1.toString();
      }
   }
}

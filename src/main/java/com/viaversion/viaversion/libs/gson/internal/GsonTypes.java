package com.viaversion.viaversion.libs.gson.internal;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Properties;

public class GsonTypes {
   static final Type[] EMPTY_TYPE_ARRAY = new Type[0];

   private GsonTypes() {
      throw new UnsupportedOperationException();
   }

   public static ParameterizedType newParameterizedTypeWithOwner(Type var0, Class<?> var1, Type... var2) {
      return new GsonTypes.ParameterizedTypeImpl(var0, var1, var2);
   }

   public static GenericArrayType arrayOf(Type var0) {
      return new GsonTypes.GenericArrayTypeImpl(var0);
   }

   public static WildcardType subtypeOf(Type var0) {
      Type[] var1;
      if (var0 instanceof WildcardType) {
         var1 = ((WildcardType)var0).getUpperBounds();
      } else {
         var1 = new Type[]{var0};
      }

      return new GsonTypes.WildcardTypeImpl(var1, EMPTY_TYPE_ARRAY);
   }

   public static WildcardType supertypeOf(Type var0) {
      Type[] var1;
      if (var0 instanceof WildcardType) {
         var1 = ((WildcardType)var0).getLowerBounds();
      } else {
         var1 = new Type[]{var0};
      }

      return new GsonTypes.WildcardTypeImpl(new Type[]{Object.class}, var1);
   }

   public static Type canonicalize(Type var0) {
      if (var0 instanceof Class) {
         Class var4 = (Class)var0;
         return (Type)(var4.isArray() ? new GsonTypes.GenericArrayTypeImpl(canonicalize(var4.getComponentType())) : var4);
      } else if (var0 instanceof ParameterizedType) {
         ParameterizedType var3 = (ParameterizedType)var0;
         return new GsonTypes.ParameterizedTypeImpl(var3.getOwnerType(), (Class<?>)var3.getRawType(), var3.getActualTypeArguments());
      } else if (var0 instanceof GenericArrayType) {
         GenericArrayType var2 = (GenericArrayType)var0;
         return new GsonTypes.GenericArrayTypeImpl(var2.getGenericComponentType());
      } else if (var0 instanceof WildcardType) {
         WildcardType var1 = (WildcardType)var0;
         return new GsonTypes.WildcardTypeImpl(var1.getUpperBounds(), var1.getLowerBounds());
      } else {
         return var0;
      }
   }

   public static Class<?> getRawType(Type var0) {
      if (var0 instanceof Class) {
         return (Class<?>)var0;
      } else if (var0 instanceof ParameterizedType) {
         ParameterizedType var5 = (ParameterizedType)var0;
         Type var2 = var5.getRawType();
         return (Class<?>)var2;
      } else if (var0 instanceof GenericArrayType) {
         Type var4 = ((GenericArrayType)var0).getGenericComponentType();
         return Array.newInstance(getRawType(var4), 0).getClass();
      } else if (var0 instanceof TypeVariable) {
         return Object.class;
      } else if (var0 instanceof WildcardType) {
         Type[] var3 = ((WildcardType)var0).getUpperBounds();

         assert var3.length == 1;

         return getRawType(var3[0]);
      } else {
         String var1 = var0 == null ? "null" : var0.getClass().getName();
         throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + var0 + "> is of type " + var1);
      }
   }

   private static boolean equal(Object var0, Object var1) {
      return Objects.equals(var0, var1);
   }

   public static boolean equals(Type var0, Type var1) {
      if (var0 == var1) {
         return true;
      } else if (var0 instanceof Class) {
         return var0.equals(var1);
      } else if (var0 instanceof ParameterizedType) {
         if (!(var1 instanceof ParameterizedType)) {
            return false;
         } else {
            ParameterizedType var6 = (ParameterizedType)var0;
            ParameterizedType var9 = (ParameterizedType)var1;
            return equal(var6.getOwnerType(), var9.getOwnerType())
               && var6.getRawType().equals(var9.getRawType())
               && Arrays.equals((Object[])var6.getActualTypeArguments(), (Object[])var9.getActualTypeArguments());
         }
      } else if (var0 instanceof GenericArrayType) {
         if (!(var1 instanceof GenericArrayType)) {
            return false;
         } else {
            GenericArrayType var5 = (GenericArrayType)var0;
            GenericArrayType var8 = (GenericArrayType)var1;
            return equals(var5.getGenericComponentType(), var8.getGenericComponentType());
         }
      } else if (var0 instanceof WildcardType) {
         if (!(var1 instanceof WildcardType)) {
            return false;
         } else {
            WildcardType var4 = (WildcardType)var0;
            WildcardType var7 = (WildcardType)var1;
            return Arrays.equals((Object[])var4.getUpperBounds(), (Object[])var7.getUpperBounds())
               && Arrays.equals((Object[])var4.getLowerBounds(), (Object[])var7.getLowerBounds());
         }
      } else if (var0 instanceof TypeVariable) {
         if (!(var1 instanceof TypeVariable)) {
            return false;
         } else {
            TypeVariable var2 = (TypeVariable)var0;
            TypeVariable var3 = (TypeVariable)var1;
            return Objects.equals(var2.getGenericDeclaration(), var3.getGenericDeclaration()) && var2.getName().equals(var3.getName());
         }
      } else {
         return false;
      }
   }

   public static String typeToString(Type var0) {
      return var0 instanceof Class ? ((Class)var0).getName() : var0.toString();
   }

   private static Type getGenericSupertype(Type var0, Class<?> var1, Class<?> var2) {
      if (var2 == var1) {
         return var0;
      } else {
         if (var2.isInterface()) {
            Class[] var3 = var1.getInterfaces();
            int var4 = 0;

            for (int var5 = var3.length; var4 < var5; var4++) {
               if (var3[var4] == var2) {
                  return var1.getGenericInterfaces()[var4];
               }

               if (var2.isAssignableFrom(var3[var4])) {
                  return getGenericSupertype(var1.getGenericInterfaces()[var4], var3[var4], var2);
               }
            }
         }

         if (!var1.isInterface()) {
            while (var1 != Object.class) {
               Class var6 = var1.getSuperclass();
               if (var6 == var2) {
                  return var1.getGenericSuperclass();
               }

               if (var2.isAssignableFrom(var6)) {
                  return getGenericSupertype(var1.getGenericSuperclass(), var6, var2);
               }

               var1 = var6;
            }
         }

         return var2;
      }
   }

   private static Type getSupertype(Type var0, Class<?> var1, Class<?> var2) {
      if (var0 instanceof WildcardType) {
         Type[] var3 = ((WildcardType)var0).getUpperBounds();

         assert var3.length == 1;

         var0 = var3[0];
      }

      if (!var2.isAssignableFrom(var1)) {
         throw new IllegalArgumentException(var1 + " is not the same as or a subtype of " + var2);
      } else {
         return resolve(var0, var1, getGenericSupertype(var0, var1, var2));
      }
   }

   public static Type getArrayComponentType(Type var0) {
      return (Type)(var0 instanceof GenericArrayType ? ((GenericArrayType)var0).getGenericComponentType() : ((Class)var0).getComponentType());
   }

   public static Type getCollectionElementType(Type var0, Class<?> var1) {
      Type var2 = getSupertype(var0, var1, Collection.class);
      return (Type)(var2 instanceof ParameterizedType ? ((ParameterizedType)var2).getActualTypeArguments()[0] : Object.class);
   }

   public static Type[] getMapKeyAndValueTypes(Type var0, Class<?> var1) {
      if (Properties.class.isAssignableFrom(var1)) {
         return new Type[]{String.class, String.class};
      } else {
         Type var2 = getSupertype(var0, var1, Map.class);
         if (var2 instanceof ParameterizedType) {
            ParameterizedType var3 = (ParameterizedType)var2;
            return var3.getActualTypeArguments();
         } else {
            return new Type[]{Object.class, Object.class};
         }
      }
   }

   public static Type resolve(Type var0, Class<?> var1, Type var2) {
      return resolve(var0, var1, var2, new HashMap<>());
   }

   private static Type resolve(Type var0, Class<?> var1, Type var2, Map<TypeVariable<?>, Type> var3) {
      TypeVariable var4 = null;

      while (true) {
         if (var2 instanceof TypeVariable) {
            TypeVariable var5 = (TypeVariable)var2;
            Type var6 = (Type)var3.get(var5);
            if (var6 != null) {
               return (Type)(var6 == void.class ? var2 : var6);
            }

            var3.put(var5, void.class);
            if (var4 == null) {
               var4 = var5;
            }

            var2 = resolveTypeVariable(var0, var1, var5);
            if (var2 != var5) {
               continue;
            }
         } else if (var2 instanceof Class && ((Class)var2).isArray()) {
            Class var17 = (Class)var2;
            Class var21 = var17.getComponentType();
            Type var24 = resolve(var0, var1, var21, var3);
            var2 = equal(var21, var24) ? var17 : arrayOf(var24);
         } else if (var2 instanceof GenericArrayType) {
            GenericArrayType var14 = (GenericArrayType)var2;
            Type var18 = var14.getGenericComponentType();
            Type var7 = resolve(var0, var1, var18, var3);
            var2 = equal(var18, var7) ? var14 : arrayOf(var7);
         } else if (var2 instanceof ParameterizedType) {
            ParameterizedType var15 = (ParameterizedType)var2;
            Type var19 = var15.getOwnerType();
            Type var22 = resolve(var0, var1, var19, var3);
            boolean var8 = !equal(var22, var19);
            Type[] var9 = var15.getActualTypeArguments();
            boolean var10 = false;
            int var11 = 0;

            for (int var12 = var9.length; var11 < var12; var11++) {
               Type var13 = resolve(var0, var1, var9[var11], var3);
               if (!equal(var13, var9[var11])) {
                  if (!var10) {
                     var9 = (Type[])var9.clone();
                     var10 = true;
                  }

                  var9[var11] = var13;
               }
            }

            var2 = !var8 && !var10 ? var15 : newParameterizedTypeWithOwner(var22, (Class<?>)var15.getRawType(), var9);
         } else {
            label76:
            if (var2 instanceof WildcardType) {
               WildcardType var16 = (WildcardType)var2;
               Type[] var20 = var16.getLowerBounds();
               Type[] var23 = var16.getUpperBounds();
               if (var20.length == 1) {
                  Type var25 = resolve(var0, var1, var20[0], var3);
                  if (var25 != var20[0]) {
                     var2 = supertypeOf(var25);
                     break label76;
                  }
               } else if (var23.length == 1) {
                  Type var26 = resolve(var0, var1, var23[0], var3);
                  if (var26 != var23[0]) {
                     var2 = subtypeOf(var26);
                     break label76;
                  }
               }

               var2 = var16;
            }
         }

         if (var4 != null) {
            var3.put(var4, var2);
         }

         return (Type)var2;
      }
   }

   private static Type resolveTypeVariable(Type var0, Class<?> var1, TypeVariable<?> var2) {
      Class var3 = declaringClassOf(var2);
      if (var3 == null) {
         return var2;
      } else {
         Type var4 = getGenericSupertype(var0, var1, var3);
         if (var4 instanceof ParameterizedType) {
            int var5 = indexOf(var3.getTypeParameters(), var2);
            return ((ParameterizedType)var4).getActualTypeArguments()[var5];
         } else {
            return var2;
         }
      }
   }

   private static int indexOf(Object[] var0, Object var1) {
      int var2 = 0;

      for (int var3 = var0.length; var2 < var3; var2++) {
         if (var1.equals(var0[var2])) {
            return var2;
         }
      }

      throw new NoSuchElementException();
   }

   private static Class<?> declaringClassOf(TypeVariable<?> var0) {
      GenericDeclaration var1 = var0.getGenericDeclaration();
      return var1 instanceof Class ? (Class)var1 : null;
   }

   static void checkNotPrimitive(Type var0) {
      if (var0 instanceof Class && ((Class)var0).isPrimitive()) {
         throw new IllegalArgumentException("Primitive type is not allowed");
      }
   }

   public static boolean requiresOwnerType(Type var0) {
      if (!(var0 instanceof Class)) {
         return false;
      } else {
         Class var1 = (Class)var0;
         return !Modifier.isStatic(var1.getModifiers()) && var1.getDeclaringClass() != null;
      }
   }

   private static final class GenericArrayTypeImpl implements GenericArrayType {
      private final Type componentType;

      GenericArrayTypeImpl(Type var1) {
         Objects.requireNonNull(var1);
         this.componentType = GsonTypes.canonicalize(var1);
      }

      @Override
      public Type getGenericComponentType() {
         return this.componentType;
      }

      @Override
      public boolean equals(Object var1) {
         return var1 instanceof GenericArrayType && GsonTypes.equals(this, (GenericArrayType)var1);
      }

      @Override
      public int hashCode() {
         return this.componentType.hashCode();
      }

      @Override
      public String toString() {
         return GsonTypes.typeToString(this.componentType) + "[]";
      }
   }

   private static final class ParameterizedTypeImpl implements ParameterizedType {
      private final Type ownerType;
      private final Type rawType;
      private final Type[] typeArguments;

      ParameterizedTypeImpl(Type var1, Class<?> var2, Type... var3) {
         Objects.requireNonNull(var2);
         if (var1 == null && GsonTypes.requiresOwnerType(var2)) {
            throw new IllegalArgumentException("Must specify owner type for " + var2);
         } else {
            this.ownerType = var1 == null ? null : GsonTypes.canonicalize(var1);
            this.rawType = GsonTypes.canonicalize(var2);
            this.typeArguments = (Type[])var3.clone();
            int var4 = 0;

            for (int var5 = this.typeArguments.length; var4 < var5; var4++) {
               Objects.requireNonNull(this.typeArguments[var4]);
               GsonTypes.checkNotPrimitive(this.typeArguments[var4]);
               this.typeArguments[var4] = GsonTypes.canonicalize(this.typeArguments[var4]);
            }
         }
      }

      @Override
      public Type[] getActualTypeArguments() {
         return (Type[])this.typeArguments.clone();
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
      public boolean equals(Object var1) {
         return var1 instanceof ParameterizedType && GsonTypes.equals(this, (ParameterizedType)var1);
      }

      private static int hashCodeOrZero(Object var0) {
         return var0 != null ? var0.hashCode() : 0;
      }

      @Override
      public int hashCode() {
         return Arrays.hashCode((Object[])this.typeArguments) ^ this.rawType.hashCode() ^ hashCodeOrZero(this.ownerType);
      }

      @Override
      public String toString() {
         int var1 = this.typeArguments.length;
         if (var1 == 0) {
            return GsonTypes.typeToString(this.rawType);
         } else {
            StringBuilder var2 = new StringBuilder(30 * (var1 + 1));
            var2.append(GsonTypes.typeToString(this.rawType)).append("<").append(GsonTypes.typeToString(this.typeArguments[0]));

            for (int var3 = 1; var3 < var1; var3++) {
               var2.append(", ").append(GsonTypes.typeToString(this.typeArguments[var3]));
            }

            return var2.append(">").toString();
         }
      }
   }

   private static final class WildcardTypeImpl implements WildcardType {
      private final Type upperBound;
      private final Type lowerBound;

      WildcardTypeImpl(Type[] var1, Type[] var2) {
         if (var2.length > 1) {
            throw new IllegalArgumentException("At most one lower bound is supported");
         } else if (var1.length != 1) {
            throw new IllegalArgumentException("Exactly one upper bound must be specified");
         } else {
            if (var2.length == 1) {
               Objects.requireNonNull(var2[0]);
               GsonTypes.checkNotPrimitive(var2[0]);
               if (var1[0] != Object.class) {
                  throw new IllegalArgumentException("When lower bound is specified, upper bound must be Object");
               }

               this.lowerBound = GsonTypes.canonicalize(var2[0]);
               this.upperBound = Object.class;
            } else {
               Objects.requireNonNull(var1[0]);
               GsonTypes.checkNotPrimitive(var1[0]);
               this.lowerBound = null;
               this.upperBound = GsonTypes.canonicalize(var1[0]);
            }
         }
      }

      @Override
      public Type[] getUpperBounds() {
         return new Type[]{this.upperBound};
      }

      @Override
      public Type[] getLowerBounds() {
         return this.lowerBound != null ? new Type[]{this.lowerBound} : GsonTypes.EMPTY_TYPE_ARRAY;
      }

      @Override
      public boolean equals(Object var1) {
         return var1 instanceof WildcardType && GsonTypes.equals(this, (WildcardType)var1);
      }

      @Override
      public int hashCode() {
         return (this.lowerBound != null ? 31 + this.lowerBound.hashCode() : 1) ^ 31 + this.upperBound.hashCode();
      }

      @Override
      public String toString() {
         if (this.lowerBound != null) {
            return "? super " + GsonTypes.typeToString(this.lowerBound);
         } else {
            return this.upperBound == Object.class ? "?" : "? extends " + GsonTypes.typeToString(this.upperBound);
         }
      }
   }
}

package com.viaversion.viaversion.libs.gson.internal.bind;

import com.viaversion.viaversion.libs.gson.Gson;
import com.viaversion.viaversion.libs.gson.TypeAdapter;
import com.viaversion.viaversion.libs.gson.TypeAdapterFactory;
import com.viaversion.viaversion.libs.gson.annotations.SerializedName;
import com.viaversion.viaversion.libs.gson.reflect.TypeToken;
import com.viaversion.viaversion.libs.gson.stream.JsonReader;
import com.viaversion.viaversion.libs.gson.stream.JsonToken;
import com.viaversion.viaversion.libs.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {
   static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() {
      public <T> TypeAdapter<T> create(Gson var1, TypeToken<T> var2) {
         Class var3 = var2.getRawType();
         if (Enum.class.isAssignableFrom(var3) && var3 != Enum.class) {
            if (!var3.isEnum()) {
               var3 = var3.getSuperclass();
            }

            return new EnumTypeAdapter<>(var3);
         } else {
            return null;
         }
      }
   };
   private final Map<String, T> nameToConstant;
   private final Map<String, T> stringToConstant;
   private final Map<T, String> constantToName;

   private static int calculateHashMapCapacity(int var0) {
      return (int)Math.ceil(var0 / 0.75F);
   }

   private EnumTypeAdapter(Class<T> var1) {
      try {
         Field[] var2 = var1.getDeclaredFields();
         int var3 = 0;

         for (Field var7 : var2) {
            if (var7.isEnumConstant()) {
               var2[var3++] = var7;
            }
         }

         var2 = Arrays.copyOf(var2, var3);
         int var19 = calculateHashMapCapacity(var3);
         this.nameToConstant = new HashMap<>(var19);
         this.stringToConstant = new HashMap<>(var19);
         this.constantToName = new HashMap<>(var19);
         AccessibleObject.setAccessible(var2, true);

         for (Field var8 : var2) {
            Enum var9 = (Enum)var8.get(null);
            String var10 = var9.name();
            String var11 = var9.toString();
            SerializedName var12 = var8.getAnnotation(SerializedName.class);
            if (var12 != null) {
               var10 = var12.value();

               for (String var16 : var12.alternate()) {
                  this.nameToConstant.put(var16, (T)var9);
               }
            }

            this.nameToConstant.put(var10, (T)var9);
            this.stringToConstant.put(var11, (T)var9);
            this.constantToName.put((T)var9, var10);
         }
      } catch (IllegalAccessException var17) {
         throw new AssertionError(var17);
      }
   }

   public T read(JsonReader var1) throws IOException {
      if (var1.peek() == JsonToken.NULL) {
         var1.nextNull();
         return null;
      } else {
         String var2 = var1.nextString();
         Enum var3 = this.nameToConstant.get(var2);
         return (T)(var3 == null ? this.stringToConstant.get(var2) : var3);
      }
   }

   public void write(JsonWriter var1, T var2) throws IOException {
      var1.value(var2 == null ? null : this.constantToName.get(var2));
   }
}

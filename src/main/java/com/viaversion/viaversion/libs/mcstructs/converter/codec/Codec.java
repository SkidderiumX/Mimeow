package com.viaversion.viaversion.libs.mcstructs.converter.codec;

import com.viaversion.viaversion.libs.mcstructs.converter.DataConverter;
import com.viaversion.viaversion.libs.mcstructs.converter.SerializedData;
import com.viaversion.viaversion.libs.mcstructs.converter.mapcodec.MapCodec;
import com.viaversion.viaversion.libs.mcstructs.converter.mapcodec.impl.FieldMapCodec;
import com.viaversion.viaversion.libs.mcstructs.converter.mapcodec.impl.TypedMapCodec;
import com.viaversion.viaversion.libs.mcstructs.converter.mapcodec.impl.FieldMapCodec.Builder.Stage1;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Either;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Result;
import com.viaversion.viaversion.libs.mcstructs.converter.types.IdentifiedType;
import com.viaversion.viaversion.libs.mcstructs.converter.types.NamedType;
import com.viaversion.viaversion.libs.mcstructs.core.Identifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public interface Codec<T> extends DataSerializer<T>, DataDeserializer<T> {
   Codec<Boolean> UNIT = unit(() -> true);
   Codec<Boolean> BOOLEAN = new Codec<Boolean>() {
      public <S> Result<S> serialize(DataConverter<S> var1, Boolean var2) {
         return Result.success(var1.createBoolean(var2));
      }

      public <S> Result<Boolean> deserialize(DataConverter<S> var1, S var2) {
         return var1.asBoolean(var2);
      }
   };
   Codec<Byte> BYTE = new Codec<Byte>() {
      public <S> Result<S> serialize(DataConverter<S> var1, Byte var2) {
         return Result.success(var1.createByte(var2));
      }

      public <S> Result<Byte> deserialize(DataConverter<S> var1, S var2) {
         return var1.asNumber(var2).map(Number::byteValue);
      }
   };
   Codec<Integer> UNSIGNED_BYTE = BYTE.flatMap(var0 -> {
      if (var0 < 0) {
         return Result.error("Value is smaller than minimum: " + var0 + " < 0");
      } else {
         return var0 > 255 ? Result.error("Value is bigger than maximum: " + var0 + " > 255") : Result.success((byte)(var0 & 0xFF));
      }
   }, var0 -> Result.success(var0 & 255));
   Codec<Short> SHORT = new Codec<Short>() {
      public <S> Result<S> serialize(DataConverter<S> var1, Short var2) {
         return Result.success(var1.createShort(var2));
      }

      public <S> Result<Short> deserialize(DataConverter<S> var1, S var2) {
         return var1.asNumber(var2).map(Number::shortValue);
      }
   };
   Codec<Integer> INTEGER = new Codec<Integer>() {
      public <S> Result<S> serialize(DataConverter<S> var1, Integer var2) {
         return Result.success(var1.createInt(var2));
      }

      public <S> Result<Integer> deserialize(DataConverter<S> var1, S var2) {
         return var1.asNumber(var2).map(Number::intValue);
      }
   };
   Codec<Long> LONG = new Codec<Long>() {
      public <S> Result<S> serialize(DataConverter<S> var1, Long var2) {
         return Result.success(var1.createLong(var2));
      }

      public <S> Result<Long> deserialize(DataConverter<S> var1, S var2) {
         return var1.asNumber(var2).map(Number::longValue);
      }
   };
   Codec<Float> FLOAT = new Codec<Float>() {
      public <S> Result<S> serialize(DataConverter<S> var1, Float var2) {
         return Result.success(var1.createFloat(var2));
      }

      public <S> Result<Float> deserialize(DataConverter<S> var1, S var2) {
         return var1.asNumber(var2).map(Number::floatValue);
      }
   };
   Codec<Double> DOUBLE = new Codec<Double>() {
      public <S> Result<S> serialize(DataConverter<S> var1, Double var2) {
         return Result.success(var1.createDouble(var2));
      }

      public <S> Result<Double> deserialize(DataConverter<S> var1, S var2) {
         return var1.asNumber(var2).map(Number::doubleValue);
      }
   };
   Codec<String> STRING = new Codec<String>() {
      public <S> Result<S> serialize(DataConverter<S> var1, String var2) {
         return Result.success(var1.createString(var2));
      }

      public <S> Result<String> deserialize(DataConverter<S> var1, S var2) {
         return var1.asString(var2);
      }
   };
   Codec<byte[]> BYTE_ARRAY = new Codec<byte[]>() {
      public <S> Result<S> serialize(DataConverter<S> var1, byte[] var2) {
         return Result.success(var1.createByteArray(var2));
      }

      public <S> Result<byte[]> deserialize(DataConverter<S> var1, S var2) {
         return var1.asByteArray(var2);
      }
   };
   Codec<int[]> INT_ARRAY = new Codec<int[]>() {
      public <S> Result<S> serialize(DataConverter<S> var1, int[] var2) {
         return Result.success(var1.createIntArray(var2));
      }

      public <S> Result<int[]> deserialize(DataConverter<S> var1, S var2) {
         return var1.asIntArray(var2);
      }
   };
   Codec<long[]> LONG_ARRAY = new Codec<long[]>() {
      public <S> Result<S> serialize(DataConverter<S> var1, long[] var2) {
         return Result.success(var1.createLongArray(var2));
      }

      public <S> Result<long[]> deserialize(DataConverter<S> var1, S var2) {
         return var1.asLongArray(var2);
      }
   };
   Codec<Identifier> STRING_IDENTIFIER = STRING.mapThrowing(Identifier::get, Identifier::of);
   Codec<String> STRING_IDENTIFIER_PATH = STRING.verified(var0 -> var0.matches("[_\\-a-z0-9/.]*") ? Result.error("Invalid identifier path: " + var0) : null);
   Codec<UUID> INT_ARRAY_UUID = INT_ARRAY.verified(var0 -> var0.length != 4 ? Result.error("UUID array must have a length of 4") : null)
      .map(
         var0 -> new int[]{
            (int)(var0.getMostSignificantBits() >> 32),
            (int)var0.getMostSignificantBits(),
            (int)(var0.getLeastSignificantBits() >> 32),
            (int)var0.getLeastSignificantBits()
         },
         var0 -> {
            long var1 = (long)var0[0] << 32 | var0[1] & 4294967295L;
            long var3 = (long)var0[2] << 32 | var0[3] & 4294967295L;
            return new UUID(var1, var3);
         }
      );
   Codec<UUID> STRICT_STRING_UUID = STRING.mapThrowing(UUID::toString, UUID::fromString);
   Codec<SerializedData<?>> RAW = new Codec<SerializedData<?>>() {
      public <S> Result<S> serialize(DataConverter<S> var1, SerializedData<?> var2) {
         return var2.convert(var1);
      }

      public <S> Result<SerializedData<?>> deserialize(DataConverter<S> var1, S var2) {
         return Result.success(new SerializedData(var2, var1));
      }
   };

   static <T> Codec<T> unit(final Supplier<T> var0) {
      return new Codec<T>() {
         public <S> Result<S> serialize(DataConverter<S> var1, T var2) {
            return Result.success(var1.emptyMap());
         }

         public <S> Result<T> deserialize(DataConverter<S> var1, S var2) {
            return var1.asMap(var2).map(var1x -> var0.get());
         }
      };
   }

   static <T> Codec<T> failing(final String var0) {
      return new Codec<T>() {
         public <S> Result<S> serialize(DataConverter<S> var1, T var2) {
            return Result.error(var0);
         }

         public <S> Result<T> deserialize(DataConverter<S> var1, S var2) {
            return Result.error(var0);
         }
      };
   }

   static <T> Codec<T> ofThrowing(final DataSerializer<T> var0, final DataDeserializer<T> var1) {
      return new Codec<T>() {
         public <S> Result<S> serialize(DataConverter<S> var1x, T var2) {
            try {
               return var0.serialize(var1x, var2);
            } catch (Throwable var4) {
               return Result.error(var4);
            }
         }

         public <S> Result<T> deserialize(DataConverter<S> var1x, S var2) {
            try {
               return var1.deserialize(var1x, var2);
            } catch (Throwable var4) {
               return Result.error(var4);
            }
         }
      };
   }

   static <T> Codec<T> recursive(final Function<Codec<T>, Codec<T>> var0) {
      return new Codec<T>() {
         private final Codec<T> codec = (Codec<T>)var0.apply(this);

         public <S> Result<S> serialize(DataConverter<S> var1, T var2) {
            return this.codec.serialize(var1, var2);
         }

         public <S> Result<T> deserialize(DataConverter<S> var1, S var2) {
            return this.codec.deserialize(var1, var2);
         }
      };
   }

   static Codec<Integer> minInt(int var0) {
      return rangedInt(var0, Integer.MAX_VALUE);
   }

   static Codec<Integer> rangedInt(int var0, int var1) {
      return INTEGER.verified(var2 -> {
         if (var2 < var0) {
            return Result.error("Value is smaller than minimum: " + var2 + " < " + var0);
         } else {
            return var2 > var1 ? Result.error("Value is bigger than maximum: " + var2 + " > " + var1) : null;
         }
      });
   }

   static Codec<Float> minFloat(float var0) {
      return rangedFloat(var0, Float.MAX_VALUE);
   }

   static Codec<Float> minExclusiveFloat(float var0) {
      return FLOAT.verified(var1 -> var1 <= var0 ? Result.error("Value is smaller or equal to minimum: " + var1 + " <= " + var0) : null);
   }

   static Codec<Float> rangedFloat(float var0, float var1) {
      return FLOAT.verified(var2 -> {
         if (var2 < var0) {
            return Result.error("Value is smaller than minimum: " + var2 + " < " + var0);
         } else {
            return var2 > var1 ? Result.error("Value is bigger than maximum: " + var2 + " > " + var1) : null;
         }
      });
   }

   static Codec<String> sizedString(int var0, int var1) {
      return STRING.verified(var2 -> {
         if (var2.length() < var0) {
            return Result.error("String is shorter than minimum: " + var2.length() + " < " + var0);
         } else {
            return var2.length() > var1 ? Result.error("String is longer than maximum: " + var2.length() + " > " + var1) : null;
         }
      });
   }

   @SafeVarargs
   static <T extends NamedType> Codec<T> named(T... var0) {
      return STRING.flatMap(var0x -> Result.success(var0x.getName()), var1 -> {
         for (NamedType var5 : var0) {
            if (var5.getName().equals(var1)) {
               return Result.success(var5);
            }
         }

         String var7 = "";

         for (NamedType var6 : var0) {
            var7 = var7 + var6.getName() + ", ";
         }

         if (!var7.isEmpty()) {
            var7 = var7.substring(0, var7.length() - 2);
         }

         return Result.error("Unknown named value: " + var1 + " (" + var7 + ")");
      });
   }

   static <T extends IdentifiedType> Codec<T> identified(T[] var0) {
      return STRING_IDENTIFIER.flatMap(var0x -> Result.success(var0x.getIdentifier()), var1 -> {
         for (IdentifiedType var5 : var0) {
            if (var5.getIdentifier().equals(var1)) {
               return Result.success(var5);
            }
         }

         Object var7 = "";

         for (IdentifiedType var6 : var0) {
            var7 = var7 + var6.getIdentifier() + ", ";
         }

         if (!var7.isEmpty()) {
            var7 = var7.substring(0, var7.length() - 2);
         }

         return Result.error("Unknown identified value: " + var1 + " (" + var7 + ")");
      });
   }

   static <L, R> Codec<Either<L, R>> either(final Codec<L> var0, final Codec<R> var1) {
      return new Codec<Either<L, R>>() {
         public <S> Result<S> serialize(DataConverter<S> var1x, Either<L, R> var2) {
            if (var2.isLeft()) {
               return var0.serialize(var1x, var2.getLeft());
            } else {
               return var2.isRight() ? var1.serialize(var1x, var2.getRight()) : Result.error("Either is neither left nor right");
            }
         }

         public <S> Result<Either<L, R>> deserialize(DataConverter<S> var1x, S var2) {
            Result var3 = var0.deserialize(var1x, var2);
            if (!var3.isError()) {
               return Result.success(Either.left(var3.get()));
            } else {
               Result var4 = var1.deserialize(var1x, var2);
               return !var4.isError()
                  ? Result.success(Either.right(var4.get()))
                  : Result.mergeErrors("Failed to deserialize as either left or right", Arrays.asList(var3, var4));
            }
         }
      };
   }

   static <T> Codec<T> withAlternative(Codec<T> var0, Codec<T> var1) {
      return either(var0, var1).map(Either::left, Either::unwrap);
   }

   static <T, A> Codec<T> withAlternative(Codec<T> var0, Codec<A> var1, Function<A, T> var2) {
      return either(var0, var1).map(Either::left, var1x -> (T)var1x.xmap(Function.identity(), var2));
   }

   @SafeVarargs
   static <T> Codec<T> oneOf(final Codec<T>... var0) {
      if (var0.length == 0) {
         throw new IllegalArgumentException("At least one codec is required");
      } else {
         return new Codec<T>() {
            public <S> Result<S> serialize(DataConverter<S> var1, T var2) {
               ArrayList var3 = null;

               for (Codec var7 : var0) {
                  Result var8 = var7.serialize(var1, var2);
                  if (!var8.isError()) {
                     return var8;
                  }

                  if (var3 == null) {
                     var3 = new ArrayList();
                  }

                  var3.add(var8.mapError());
               }

               return Result.mergeErrors("Failed to serialize with " + var0.length + " codecs", var3);
            }

            public <S> Result<T> deserialize(DataConverter<S> var1, S var2) {
               ArrayList var3 = null;

               for (Codec var7 : var0) {
                  Result var8 = var7.deserialize(var1, var2);
                  if (!var8.isError()) {
                     return var8;
                  }

                  if (var3 == null) {
                     var3 = new ArrayList();
                  }

                  var3.add(var8.mapError());
               }

               return Result.mergeErrors("Failed to deserialize with " + var0.length + " codecs", var3);
            }
         };
      }
   }

   static <K, V> Codec<Map<K, V>> mapOf(Codec<K> var0, Codec<V> var1) {
      return mapOf(var0, var1x -> var1);
   }

   static <K, V> Codec<Map<K, V>> mapOf(final Codec<K> var0, final Function<K, Codec<V>> var1) {
      return new Codec<Map<K, V>>() {
         public <S> Result<S> serialize(DataConverter<S> var1x, Map<K, V> var2) {
            HashMap var3 = new HashMap();

            for (Entry var5 : var2.entrySet()) {
               Result var6 = var0.serialize(var1x, var5.getKey());
               if (var6.isError()) {
                  return var6.mapError();
               }

               Result var7 = ((Codec)var1.apply(var5.getKey())).serialize(var1x, var5.getValue());
               if (var7.isError()) {
                  return var7.mapError();
               }

               var3.put(var6.get(), var7.get());
            }

            return var1x.createMergedMap(var3);
         }

         public <S> Result<Map<K, V>> deserialize(DataConverter<S> var1x, S var2) {
            Result var3 = var1x.asMap(var2);
            if (var3.isError()) {
               return var3.mapError();
            } else {
               HashMap var4 = new HashMap();

               for (Entry var6 : ((Map)var3.get()).entrySet()) {
                  Result var7 = var0.deserialize(var1x, var6.getKey());
                  if (var7.isError()) {
                     return var7.mapError();
                  }

                  Result var8 = ((Codec)var1.apply(var7.get())).deserialize(var1x, var6.getValue());
                  if (var8.isError()) {
                     return var8.mapError();
                  }

                  var4.put(var7.get(), var8.get());
               }

               return Result.success(var4);
            }
         }
      };
   }

   static <T> Codec<List<T>> compactList(Codec<T> var0) {
      return compactList(var0, var0.listOf());
   }

   static <T> Codec<List<T>> compactList(Codec<T> var0, Codec<List<T>> var1) {
      return either(var1, var0)
         .map(var0x -> var0x.size() == 1 ? Either.right(var0x.get(0)) : Either.left(var0x), var0x -> (List<T>)var0x.xmap(var0xx -> var0xx, var0xx -> {
            ArrayList var1x = new ArrayList();
            var1x.add(var0xx);
            return var1x;
         }));
   }

   static <T> Codec<T> lazyInit(final Supplier<Codec<T>> var0) {
      return new Codec<T>() {
         private Codec<T> codec;

         public <S> Result<S> serialize(DataConverter<S> var1, T var2) {
            if (this.codec == null) {
               this.codec = (Codec<T>)var0.get();
            }

            return this.codec.serialize(var1, var2);
         }

         public <S> Result<T> deserialize(DataConverter<S> var1, S var2) {
            if (this.codec == null) {
               this.codec = (Codec<T>)var0.get();
            }

            return this.codec.deserialize(var1, var2);
         }
      };
   }

   default <N> Codec<N> map(final Function<N, T> var1, final Function<T, N> var2) {
      return new Codec<N>() {
         public <S> Result<S> serialize(DataConverter<S> var1x, N var2x) {
            return Codec.this.serialize(var1x, var1.apply(var2x));
         }

         public <S> Result<N> deserialize(DataConverter<S> var1x, S var2x) {
            return Codec.this.deserialize(var1x, var2x).map(var2);
         }
      };
   }

   default <N> Codec<N> mapThrowing(ThrowingFunction<N, T> var1, ThrowingFunction<T, N> var2) {
      return this.flatMap(var1x -> {
         try {
            return Result.success(var1.apply(var1x));
         } catch (Throwable var3) {
            return Result.error(var3);
         }
      }, var1x -> {
         try {
            return Result.success(var2.apply(var1x));
         } catch (Throwable var3) {
            return Result.error(var3);
         }
      });
   }

   default <N> Codec<N> flatMap(final Function<N, Result<T>> var1, final Function<T, Result<N>> var2) {
      return new Codec<N>() {
         public <S> Result<S> serialize(DataConverter<S> var1x, N var2x) {
            Result var3 = (Result)var1.apply(var2x);
            return var3.isError() ? var3.mapError() : Codec.this.serialize(var1x, var3.get());
         }

         public <S> Result<N> deserialize(DataConverter<S> var1x, S var2x) {
            Result var3 = Codec.this.deserialize(var1x, var2x);
            return var3.isError() ? var3.mapError() : (Result)var2.apply(var3.get());
         }
      };
   }

   default <N> Codec<N> converterFlatMap(final BiFunction<DataConverter<?>, N, Result<T>> var1, final BiFunction<DataConverter<?>, T, Result<N>> var2) {
      return new Codec<N>() {
         public <S> Result<S> serialize(DataConverter<S> var1x, N var2x) {
            Result var3 = (Result)var1.apply(var1x, var2x);
            return var3.isError() ? var3.mapError() : Codec.this.serialize(var1x, var3.get());
         }

         public <S> Result<N> deserialize(DataConverter<S> var1x, S var2x) {
            Result var3 = Codec.this.deserialize(var1x, var2x);
            return var3.isError() ? var3.mapError() : (Result)var2.apply(var1x, var3.get());
         }
      };
   }

   default <N> Codec<N> typed(Function<N, T> var1, Function<T, MapCodec<? extends N>> var2) {
      return this.typedMap(var1, var2).asCodec();
   }

   default <N> Codec<N> typed(String var1, Function<N, T> var2, Function<T, MapCodec<? extends N>> var3) {
      return this.typedMap(var1, var2, var3).asCodec();
   }

   default <N> MapCodec<N> typedMap(Function<N, T> var1, Function<T, MapCodec<? extends N>> var2) {
      return this.typedMap("type", var1, var2);
   }

   default <N> MapCodec<N> typedMap(String var1, Function<N, T> var2, Function<T, MapCodec<? extends N>> var3) {
      return new TypedMapCodec(var1, this, var2, var3);
   }

   default Codec<List<T>> listOf() {
      return this.listOf(Integer.MAX_VALUE);
   }

   default Codec<List<T>> listOf(int var1) {
      return this.listOf(0, var1);
   }

   default Codec<List<T>> listOf(final int var1, final int var2) {
      return new Codec<List<T>>() {
         public <S> Result<S> serialize(DataConverter<S> var1x, List<T> var2x) {
            if (var2x.size() < var1) {
               return Result.error("List size is smaller than minimum: " + var2x.size() + " < " + var1);
            } else if (var2x.size() > var2) {
               return Result.error("List size is bigger than maximum: " + var2x.size() + " > " + var2);
            } else {
               ArrayList var3 = new ArrayList();

               for (Object var5 : var2x) {
                  Result var6 = Codec.this.serialize(var1x, var5);
                  if (var6.isError()) {
                     return var6.mapError();
                  }

                  var3.add(var6.get());
               }

               return Result.success(var1x.createList(var3));
            }
         }

         public <S> Result<List<T>> deserialize(DataConverter<S> var1x, S var2x) {
            Result var3 = var1x.asList(var2x);
            if (var3.isError()) {
               return var3.mapError();
            } else {
               List var4 = (List)var3.get();
               if (var4.size() < var1) {
                  return Result.error("List size is smaller than minimum: " + var4.size() + " < " + var1);
               } else if (var4.size() > var2) {
                  return Result.error("List size is bigger than maximum: " + var4.size() + " > " + var2);
               } else {
                  ArrayList var5 = new ArrayList();

                  for (Object var7 : var4) {
                     Result var8 = Codec.this.deserialize(var1x, var7);
                     if (var8.isError()) {
                        return var8.mapError();
                     }

                     var5.add(var8.get());
                  }

                  return Result.success(var5);
               }
            }
         }
      };
   }

   default Codec<List<T>> optionalListOf() {
      return this.optionalListOf(Integer.MAX_VALUE);
   }

   default Codec<List<T>> optionalListOf(int var1) {
      return this.optionalListOf(0, var1);
   }

   default Codec<List<T>> optionalListOf(int var1, int var2) {
      final Codec var3 = this.listOf(var1, var2);
      return new Codec<List<T>>() {
         public <S> Result<List<T>> deserialize(DataConverter<S> var1, S var2x) {
            Result var3x = Codec.this.deserialize(var1, var2x);
            if (var3x.isError()) {
               return var3.deserialize(var1, var2x);
            } else {
               ArrayList var4 = new ArrayList();
               var4.add(var3x.get());
               return Result.success(var4);
            }
         }

         public <S> Result<S> serialize(DataConverter<S> var1, List<T> var2x) {
            return var2x.size() == 1 ? Codec.this.serialize(var1, var2x.get(0)) : var3.serialize(var1, var2x);
         }
      };
   }

   default Codec<List<T>> nonEmptyList() {
      return this.listOf().verified(var0 -> var0.isEmpty() ? Result.error("List is empty") : null);
   }

   default Codec<List<T>> compactListOf() {
      return compactList(this, this.listOf());
   }

   default Codec<T> verified(final Function<T, Result<Void>> var1) {
      return new Codec<T>() {
         public <S> Result<S> serialize(DataConverter<S> var1x, T var2) {
            Result var3 = (Result)var1.apply(var2);
            return var3 != null && var3.isError() ? var3.mapError() : Codec.this.serialize(var1x, var2);
         }

         public <S> Result<T> deserialize(DataConverter<S> var1x, S var2) {
            Result var3 = Codec.this.deserialize(var1x, var2);
            if (var3.isError()) {
               return var3;
            } else {
               Result var4 = (Result)var1.apply(var3.get());
               return var4 != null && var4.isError() ? var4.mapError() : var3;
            }
         }
      };
   }

   default Codec<T> converterVerified(final BiFunction<DataConverter<?>, T, Result<Void>> var1) {
      return new Codec<T>() {
         public <S> Result<S> serialize(DataConverter<S> var1x, T var2) {
            Result var3 = (Result)var1.apply(var1x, var2);
            return var3 != null && var3.isError() ? var3.mapError() : Codec.this.serialize(var1x, var2);
         }

         public <S> Result<T> deserialize(DataConverter<S> var1x, S var2) {
            Result var3 = Codec.this.deserialize(var1x, var2);
            if (var3.isError()) {
               return var3;
            } else {
               Result var4 = (Result)var1.apply(var1x, var3.get());
               return var4 != null && var4.isError() ? var4.mapError() : var3;
            }
         }
      };
   }

   default Stage1<T> mapCodec(String var1) {
      return FieldMapCodec.builder(this, var1);
   }
}

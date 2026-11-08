package com.viaversion.viaversion.libs.mcstructs.converter.impl.v1_20_3;

import com.viaversion.nbt.tag.ByteArrayTag;
import com.viaversion.nbt.tag.ByteTag;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.DoubleTag;
import com.viaversion.nbt.tag.FloatTag;
import com.viaversion.nbt.tag.IntArrayTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.LongArrayTag;
import com.viaversion.nbt.tag.LongTag;
import com.viaversion.nbt.tag.MixedListTag;
import com.viaversion.nbt.tag.NumberArrayTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.nbt.tag.ShortTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.libs.mcstructs.converter.DataConverter;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Result;
import com.viaversion.viaversion.libs.mcstructs.snbt.SNbt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import javax.annotation.Nullable;

public class NbtConverter_v1_20_3 implements DataConverter<Tag> {
   public static final NbtConverter_v1_20_3 INSTANCE = new NbtConverter_v1_20_3();
   private Consumer<String> stringConsumer;
   private final SNbt<CompoundTag> sNbt;

   @Nullable
   public Consumer<String> currentConsumer() {
      return this.stringConsumer;
   }

   public void setCurrentConsumer(Consumer<String> var1) {
      this.stringConsumer = var1;
   }

   public DataConverter<Tag> forkIfDefault() {
      return this == INSTANCE ? new NbtConverter_v1_20_3() : this;
   }

   public NbtConverter_v1_20_3() {
      this(SNbt.V1_14);
   }

   protected NbtConverter_v1_20_3(SNbt<CompoundTag> var1) {
      this.sNbt = var1;
   }

   public <N> N convertTo(DataConverter<N> var1, @Nullable Tag var2) {
      if (var1 == this) {
         return (N)var2;
      } else if (var2 == null) {
         return (N)var1.empty();
      } else if (var2.getTagId() == 0) {
         return (N)var1.empty();
      } else if (var2 instanceof ByteTag) {
         return (N)var1.createByte(((ByteTag)var2).getValue());
      } else if (var2 instanceof ShortTag) {
         return (N)var1.createShort(((ShortTag)var2).getValue());
      } else if (var2 instanceof IntTag) {
         return (N)var1.createInt(((IntTag)var2).getValue());
      } else if (var2 instanceof LongTag) {
         return (N)var1.createLong(((LongTag)var2).getValue());
      } else if (var2 instanceof FloatTag) {
         return (N)var1.createFloat(((FloatTag)var2).getValue());
      } else if (var2 instanceof DoubleTag) {
         return (N)var1.createDouble(((DoubleTag)var2).getValue());
      } else if (var2 instanceof ByteArrayTag) {
         return (N)var1.createByteArray(((ByteArrayTag)var2).getValue());
      } else if (var2 instanceof StringTag) {
         return (N)var1.createString(((StringTag)var2).getValue());
      } else if (var2 instanceof ListTag) {
         return (N)this.convertList(var1, var2);
      } else if (var2 instanceof CompoundTag) {
         return (N)this.convertMap(var1, var2);
      } else if (var2 instanceof IntArrayTag) {
         return (N)var1.createIntArray(((IntArrayTag)var2).getValue());
      } else if (var2 instanceof LongArrayTag) {
         return (N)var1.createLongArray(((LongArrayTag)var2).getValue());
      } else {
         throw new IllegalArgumentException("Unknown Nbt type: " + var2);
      }
   }

   public Tag createBoolean(boolean var1) {
      return new ByteTag(var1);
   }

   public Result<Boolean> asBoolean(Tag var1) {
      return this.asNumber(var1).map(var0 -> var0.byteValue() != 0);
   }

   public Tag createNumber(Number var1) {
      return new DoubleTag(var1.doubleValue());
   }

   public Result<Number> asNumber(Tag var1) {
      return !(var1 instanceof NumberTag) ? Result.unexpected(var1, new Class[]{NumberTag.class}) : Result.success(((NumberTag)var1).getValue());
   }

   public Tag createByte(byte var1) {
      return new ByteTag(var1);
   }

   public Tag createShort(short var1) {
      return new ShortTag(var1);
   }

   public Tag createInt(int var1) {
      return new IntTag(var1);
   }

   public Tag createLong(long var1) {
      return new LongTag(var1);
   }

   public Tag createFloat(float var1) {
      return new FloatTag(var1);
   }

   public Tag createDouble(double var1) {
      return new DoubleTag(var1);
   }

   public Tag createString(String var1) {
      return new StringTag(var1);
   }

   public Result<String> asString(Tag var1) {
      return !(var1 instanceof StringTag) ? Result.unexpected(var1, new Class[]{StringTag.class}) : Result.success(((StringTag)var1).getValue());
   }

   public Result<Tag> mergeList(@Nullable Tag var1, List<Tag> var2) {
      if (var1 == null) {
         var1 = new ListTag();
      }

      if (var1 instanceof ByteArrayTag && var2.stream().allMatch(var0 -> var0 instanceof ByteTag)) {
         ByteArrayTag var13 = (ByteArrayTag)var1;
         byte[] var16 = Arrays.copyOf(var13.getValue(), var13.length() + var2.size());

         for (int var19 = 0; var19 < var2.size(); var19++) {
            var16[var13.length() + var19] = ((NumberTag)var2.get(var19)).asByte();
         }

         return Result.success(new ByteArrayTag(var16));
      } else if (var1 instanceof IntArrayTag && var2.stream().allMatch(var0 -> var0 instanceof IntTag)) {
         IntArrayTag var12 = (IntArrayTag)var1;
         int[] var15 = Arrays.copyOf(var12.getValue(), var12.length() + var2.size());

         for (int var18 = 0; var18 < var2.size(); var18++) {
            var15[var12.length() + var18] = ((NumberTag)var2.get(var18)).asInt();
         }

         return Result.success(new IntArrayTag(var15));
      } else if (var1 instanceof LongArrayTag && var2.stream().allMatch(var0 -> var0 instanceof LongTag)) {
         LongArrayTag var11 = (LongArrayTag)var1;
         long[] var14 = Arrays.copyOf(var11.getValue(), var11.length() + var2.size());

         for (int var17 = 0; var17 < var2.size(); var17++) {
            var14[var11.length() + var17] = ((NumberTag)var2.get(var17)).asLong();
         }

         return Result.success(new LongArrayTag(var14));
      } else {
         Result var3 = this.asList((Tag)var1);
         if (var3.isError()) {
            return var3.mapError();
         } else {
            ArrayList var4 = new ArrayList((Collection)var3.get());
            var4.addAll(var2);
            Object var5 = null;

            for (Tag var7 : var4) {
               if (var5 == null) {
                  var5 = var7;
               } else if (!var7.equals(var5)) {
                  var5 = new MixedListTag();
               }
            }

            if (var5 == null) {
               return Result.success(new ListTag());
            } else if (var5 instanceof ByteTag) {
               byte[] var23 = new byte[var4.size()];

               for (int var27 = 0; var27 < var4.size(); var27++) {
                  var23[var27] = ((ByteTag)var4.get(var27)).asByte();
               }

               return Result.success(new ByteArrayTag(var23));
            } else if (var5 instanceof IntTag) {
               int[] var22 = new int[var4.size()];

               for (int var26 = 0; var26 < var4.size(); var26++) {
                  var22[var26] = ((IntTag)var4.get(var26)).asInt();
               }

               return Result.success(new IntArrayTag(var22));
            } else if (var5 instanceof LongTag) {
               long[] var21 = new long[var4.size()];

               for (int var25 = 0; var25 < var4.size(); var25++) {
                  var21[var25] = ((LongTag)var4.get(var25)).asLong();
               }

               return Result.success(new LongArrayTag(var21));
            } else if (!(var5 instanceof MixedListTag)) {
               return Result.success(new ListTag(var4));
            } else {
               ListTag var20 = new ListTag();

               for (Tag var8 : var4) {
                  boolean var9 = var8 instanceof CompoundTag && ((CompoundTag)var8).size() == 1 && ((CompoundTag)var8).contains("");
                  if (var8 instanceof CompoundTag && !var9) {
                     var20.add((CompoundTag)var8);
                  } else {
                     CompoundTag var10 = new CompoundTag();
                     var10.put("", var8);
                     var20.add(var10);
                  }
               }

               return Result.success(var20);
            }
         }
      }
   }

   public Result<List<Tag>> asList(Tag var1) {
      if (!(var1 instanceof ListTag)) {
         return var1 instanceof NumberArrayTag
            ? Result.success(((NumberArrayTag)var1).toListTag().getValue())
            : Result.unexpected(var1, new Class[]{ListTag.class, NumberArrayTag.class});
      } else {
         ListTag var2 = (ListTag)var1;
         ArrayList var3 = new ArrayList(var2.size());
         if (CompoundTag.class == var2.getElementType()) {
            for (Tag var5 : var2) {
               CompoundTag var6 = (CompoundTag)var5;
               Tag var7 = var6.size() == 1 ? var6.get("") : null;
               if (var7 != null) {
                  var3.add(var7);
               } else {
                  var3.add(var5);
               }
            }
         } else {
            var3.addAll(var2.getValue());
         }

         return Result.success(var3);
      }
   }

   public Tag createUnsafeMap(Map<Tag, Tag> var1) {
      CompoundTag var2 = new CompoundTag();

      for (Entry var4 : var1.entrySet()) {
         String var5;
         if (var4.getKey() instanceof StringTag) {
            var5 = ((StringTag)var4.getKey()).getValue();
         } else {
            var5 = this.sNbt.trySerialize((Tag)var4.getKey());
         }

         var2.put(var5, (Tag)var4.getValue());
      }

      return var2;
   }

   public Result<Tag> mergeMap(@Nullable Tag var1, Map<Tag, Tag> var2) {
      if (var1 == null) {
         var1 = new CompoundTag();
      }

      if (!(var1 instanceof CompoundTag)) {
         return Result.unexpected(var1, new Class[]{CompoundTag.class});
      } else {
         CompoundTag var3 = (CompoundTag)var1;

         for (Entry var5 : var2.entrySet()) {
            if (!(var5.getKey() instanceof StringTag)) {
               return Result.error("Map key is not a string tag");
            }

            var3.put(((StringTag)var5.getKey()).getValue(), (Tag)var5.getValue());
         }

         return Result.success(var3);
      }
   }

   public Result<Map<Tag, Tag>> asMap(Tag var1) {
      if (!(var1 instanceof CompoundTag)) {
         return Result.unexpected(var1, new Class[]{CompoundTag.class});
      } else {
         CompoundTag var2 = (CompoundTag)var1;
         HashMap var3 = new HashMap();

         for (Entry var5 : var2) {
            var3.put(this.createString((String)var5.getKey()), var5.getValue());
         }

         return Result.success(var3);
      }
   }

   public Result<Map<String, Tag>> asStringTypeMap(Tag var1) {
      if (!(var1 instanceof CompoundTag)) {
         return Result.unexpected(var1, new Class[]{CompoundTag.class});
      } else {
         CompoundTag var2 = (CompoundTag)var1;
         HashMap var3 = new HashMap();

         for (Entry var5 : var2) {
            var3.put(var5.getKey(), var5.getValue());
         }

         return Result.success(var3);
      }
   }

   public Tag createByteArray(byte[] var1) {
      return new ByteArrayTag(var1);
   }

   public Result<byte[]> asByteArray(Tag var1) {
      if (var1 instanceof ByteArrayTag) {
         return Result.success(((ByteArrayTag)var1).getValue());
      } else if (var1 instanceof IntArrayTag) {
         IntArrayTag var6 = (IntArrayTag)var1;
         byte[] var8 = new byte[var6.length()];

         for (int var10 = 0; var10 < var6.length(); var10++) {
            var8[var10] = (byte)var6.get(var10);
         }

         return Result.success(var8);
      } else if (var1 instanceof LongArrayTag) {
         LongArrayTag var5 = (LongArrayTag)var1;
         byte[] var7 = new byte[var5.length()];

         for (int var9 = 0; var9 < var5.length(); var9++) {
            var7[var9] = (byte)var5.get(var9);
         }

         return Result.success(var7);
      } else if (!(var1 instanceof ListTag)) {
         return Result.unexpected(var1, new Class[]{ByteArrayTag.class, IntArrayTag.class, LongArrayTag.class, ListTag.class});
      } else {
         List var2 = (List)this.asList(var1).get();
         if (!var2.stream().allMatch(var0 -> var0 instanceof NumberTag)) {
            return Result.error("List tag does not contain only number tags");
         } else {
            byte[] var3 = new byte[var2.size()];

            for (int var4 = 0; var4 < var2.size(); var4++) {
               var3[var4] = ((NumberTag)var2.get(var4)).asByte();
            }

            return Result.success(var3);
         }
      }
   }

   public Tag createIntArray(int[] var1) {
      return new IntArrayTag(var1);
   }

   public Result<int[]> asIntArray(Tag var1) {
      if (var1 instanceof ByteArrayTag) {
         ByteArrayTag var6 = (ByteArrayTag)var1;
         int[] var8 = new int[var6.length()];

         for (int var10 = 0; var10 < var6.length(); var10++) {
            var8[var10] = var6.get(var10);
         }

         return Result.success(var8);
      } else if (var1 instanceof IntArrayTag) {
         return Result.success(((IntArrayTag)var1).getValue());
      } else if (var1 instanceof LongArrayTag) {
         LongArrayTag var5 = (LongArrayTag)var1;
         int[] var7 = new int[var5.length()];

         for (int var9 = 0; var9 < var5.length(); var9++) {
            var7[var9] = (int)var5.get(var9);
         }

         return Result.success(var7);
      } else if (!(var1 instanceof ListTag)) {
         return Result.unexpected(var1, new Class[]{ByteArrayTag.class, IntArrayTag.class, LongArrayTag.class, ListTag.class});
      } else {
         List var2 = (List)this.asList(var1).get();
         if (!var2.stream().allMatch(var0 -> var0 instanceof NumberTag)) {
            return Result.error("List tag does not contain only number tags");
         } else {
            int[] var3 = new int[var2.size()];

            for (int var4 = 0; var4 < var2.size(); var4++) {
               var3[var4] = ((NumberTag)var2.get(var4)).asInt();
            }

            return Result.success(var3);
         }
      }
   }

   public Tag createLongArray(long[] var1) {
      return new LongArrayTag(var1);
   }

   public Result<long[]> asLongArray(Tag var1) {
      if (var1 instanceof ByteArrayTag) {
         ByteArrayTag var6 = (ByteArrayTag)var1;
         long[] var8 = new long[var6.length()];

         for (int var10 = 0; var10 < var6.length(); var10++) {
            var8[var10] = var6.get(var10);
         }

         return Result.success(var8);
      } else if (var1 instanceof IntArrayTag) {
         IntArrayTag var5 = (IntArrayTag)var1;
         long[] var7 = new long[var5.length()];

         for (int var9 = 0; var9 < var5.length(); var9++) {
            var7[var9] = var5.get(var9);
         }

         return Result.success(var7);
      } else if (var1 instanceof LongArrayTag) {
         return Result.success(((LongArrayTag)var1).getValue());
      } else if (!(var1 instanceof ListTag)) {
         return Result.unexpected(var1, new Class[]{ByteArrayTag.class, IntArrayTag.class, LongArrayTag.class, ListTag.class});
      } else {
         List var2 = (List)this.asList(var1).get();
         if (!var2.stream().allMatch(var0 -> var0 instanceof NumberTag)) {
            return Result.error("List tag does not contain only number tags");
         } else {
            long[] var3 = new long[var2.size()];

            for (int var4 = 0; var4 < var2.size(); var4++) {
               var3[var4] = ((NumberTag)var2.get(var4)).asLong();
            }

            return Result.success(var3);
         }
      }
   }
}

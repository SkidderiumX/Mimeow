package x;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;

public class ocbd3640d420 {
   private final oc0e2667d82a ƞ = new oc0e2667d82a(0, false, 0);
   public static final ocbd3640d420 L = new ocbd3640d420();
   private final Map<String, Boolean> N = new HashMap<>();
   private List<String> ë = Collections.emptyList();
   public static int Ѵ;

   public ocbd3640d420() {
      this.N.put("swords", true);
   }

   private boolean Ӣ(String var1) {
      return this.N.getOrDefault(var1, false);
   }

   private List<String> ĩ(String var1) {
      return this.ë;
   }

   public void ĥ(String var1, boolean var2) {
      this.N.put(var1, var2);
   }

   public void ů(List<String> var1) {
      this.ë = ocac553a4d9a.Ů(var1);
   }

   public boolean Ϲ() {
      return ocac553a4d9a.ƃ(this.ë, 928433810 ^ 928434058);
   }

   public void ҭ(boolean param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 2
      // 04: iload 2
      // 05: new java/util/ArrayList
      // 08: dup
      // 09: aload 0
      // 0a: getfield x/ocbd3640d420.ë Ljava/util/List;
      // 0d: invokespecial java/util/ArrayList.<init> (Ljava/util/Collection;)V
      // 10: astore 3
      // 11: ifne 40
      // 14: aload 3
      // 15: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, x/ocbd3640d420.qn9bmpzjocs7r (Ljava/lang/String;)Z, (Ljava/lang/String;)Z ]
      // 1a: invokeinterface java/util/List.removeIf (Ljava/util/function/Predicate;)Z 2
      // 1f: pop
      // 20: iload 1
      // 21: ifeq 3b
      // 24: goto 28
      // 27: athrow
      // 28: aload 3
      // 29: ldc 922253840
      // 2b: ldc 922254088
      // 2d: ixor
      // 2e: invokestatic x/ocac553a4d9a.ԕ (I)Ljava/lang/String;
      // 31: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 36: pop
      // 37: goto 3b
      // 3a: athrow
      // 3b: aload 0
      // 3c: aload 3
      // 3d: invokevirtual x/ocbd3640d420.ů (Ljava/util/List;)V
      // 40: return
   }

   public boolean У(ItemStack param1, int param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 3
      // 04: aload 1
      // 05: iload 3
      // 06: ifne 19
      // 09: ifnonnull 18
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 0
      // 11: ldc "fist"
      // 13: invokevirtual x/ocbd3640d420.Ӣ (Ljava/lang/String;)Z
      // 16: ireturn
      // 17: athrow
      // 18: aload 1
      // 19: invokestatic x/ocbd3640d420.Н (Lnet/minecraft/item/ItemStack;)I
      // 1c: istore 4
      // 1e: aload 0
      // 1f: iload 2
      // 20: invokevirtual x/ocbd3640d420.č (I)Z
      // 23: iload 3
      // 24: ifne 5b
      // 27: ifne 5a
      // 2a: goto 2e
      // 2d: athrow
      // 2e: aload 0
      // 2f: iload 4
      // 31: invokevirtual x/ocbd3640d420.u (I)Z
      // 34: iload 3
      // 35: ifne 5b
      // 38: goto 3c
      // 3b: athrow
      // 3c: ifne 5a
      // 3f: goto 43
      // 42: athrow
      // 43: aload 0
      // 44: aload 1
      // 45: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 48: invokevirtual x/ocbd3640d420.ճ (Lnet/minecraft/item/Item;)Z
      // 4b: iload 3
      // 4c: ifne 5b
      // 4f: goto 53
      // 52: athrow
      // 53: ifeq 5e
      // 56: goto 5a
      // 59: athrow
      // 5a: bipush 1
      // 5b: goto 5f
      // 5e: bipush 0
      // 5f: ireturn
   }

   private boolean č(int param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 2
      // 04: iload 1
      // 05: iload 2
      // 06: ifne 32
      // 09: iflt 31
      // 0c: goto 10
      // 0f: athrow
      // 10: iload 1
      // 11: iload 2
      // 12: ifne 32
      // 15: goto 19
      // 18: athrow
      // 19: ldc 1759970300
      // 1b: ldc 1759970293
      // 1d: ixor
      // 1e: if_icmpge 31
      // 21: goto 25
      // 24: athrow
      // 25: aload 0
      // 26: iload 1
      // 27: bipush 1
      // 28: iadd
      // 29: invokestatic java/lang/Integer.toString (I)Ljava/lang/String;
      // 2c: invokevirtual x/ocbd3640d420.Ӣ (Ljava/lang/String;)Z
      // 2f: ireturn
      // 30: athrow
      // 31: iload 1
      // 32: iload 2
      // 33: ifne bc
      // 36: tableswitch 83 -1 13 75 83 83 83 83 83 83 83 83 83 100 107 114 121 128
      // 80: athrow
      // 81: aload 0
      // 82: ldc "fist"
      // 84: invokevirtual x/ocbd3640d420.Ӣ (Ljava/lang/String;)Z
      // 87: ireturn
      // 88: athrow
      // 89: new java/lang/IllegalArgumentException
      // 8c: dup
      // 8d: iload 1
      // 8e: ldc "Slot outside recovered setting records: "
      // 90: swap
      // 91: invokedynamic makeConcatWithConstants (Ljava/lang/String;I)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 96: invokespecial java/lang/IllegalArgumentException.<init> (Ljava/lang/String;)V
      // 99: athrow
      // 9a: aload 0
      // 9b: ldc "enchant_sharpness"
      // 9d: invokevirtual x/ocbd3640d420.Ӣ (Ljava/lang/String;)Z
      // a0: ireturn
      // a1: aload 0
      // a2: ldc "enchant_knockback"
      // a4: invokevirtual x/ocbd3640d420.Ӣ (Ljava/lang/String;)Z
      // a7: ireturn
      // a8: aload 0
      // a9: ldc "enchant_fire_aspect"
      // ab: invokevirtual x/ocbd3640d420.Ӣ (Ljava/lang/String;)Z
      // ae: ireturn
      // af: aload 0
      // b0: ldc "axes"
      // b2: invokevirtual x/ocbd3640d420.Ӣ (Ljava/lang/String;)Z
      // b5: ireturn
      // b6: aload 0
      // b7: ldc "swords"
      // b9: invokevirtual x/ocbd3640d420.Ӣ (Ljava/lang/String;)Z
      // bc: ireturn
   }

   private boolean u(int param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 2
      // 04: iload 1
      // 05: iload 2
      // 06: ifne 3a
      // 09: bipush 1
      // 0a: iand
      // 0b: ifeq 27
      // 0e: goto 12
      // 11: athrow
      // 12: aload 0
      // 13: ldc "enchant_sharpness"
      // 15: invokevirtual x/ocbd3640d420.Ӣ (Ljava/lang/String;)Z
      // 18: iload 2
      // 19: ifne 80
      // 1c: goto 20
      // 1f: athrow
      // 20: ifne 7f
      // 23: goto 27
      // 26: athrow
      // 27: iload 1
      // 28: ldc 494926844
      // 2a: ldc 494926846
      // 2c: ixor
      // 2d: iload 2
      // 2e: ifne 64
      // 31: goto 35
      // 34: athrow
      // 35: iand
      // 36: goto 3a
      // 39: athrow
      // 3a: ifeq 52
      // 3d: aload 0
      // 3e: ldc "enchant_knockback"
      // 40: invokevirtual x/ocbd3640d420.Ӣ (Ljava/lang/String;)Z
      // 43: iload 2
      // 44: ifne 80
      // 47: goto 4b
      // 4a: athrow
      // 4b: ifne 7f
      // 4e: goto 52
      // 51: athrow
      // 52: iload 1
      // 53: iload 2
      // 54: ifne 74
      // 57: goto 5b
      // 5a: athrow
      // 5b: ldc 494926842
      // 5d: ldc 494926846
      // 5f: ixor
      // 60: goto 64
      // 63: athrow
      // 64: invokestatic java/lang/Integer.compareUnsigned (II)I
      // 67: iflt 83
      // 6a: aload 0
      // 6b: ldc "enchant_fire_aspect"
      // 6d: invokevirtual x/ocbd3640d420.Ӣ (Ljava/lang/String;)Z
      // 70: goto 74
      // 73: athrow
      // 74: iload 2
      // 75: ifne 80
      // 78: ifeq 83
      // 7b: goto 7f
      // 7e: athrow
      // 7f: bipush 1
      // 80: goto 84
      // 83: bipush 0
      // 84: ireturn
   }

   private boolean ճ(Item param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 16
      // 09: ifnonnull 15
      // 0c: goto 10
      // 0f: athrow
      // 10: aconst_null
      // 11: goto 1c
      // 14: athrow
      // 15: aload 1
      // 16: invokestatic net/minecraft/item/Item.getIdFromItem (Lnet/minecraft/item/Item;)I
      // 19: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 1c: aload 0
      // 1d: ldc "fist"
      // 1f: invokevirtual x/ocbd3640d420.Ӣ (Ljava/lang/String;)Z
      // 22: aload 0
      // 23: ldc "swords"
      // 25: invokevirtual x/ocbd3640d420.Ӣ (Ljava/lang/String;)Z
      // 28: aload 0
      // 29: ldc "axes"
      // 2b: invokevirtual x/ocbd3640d420.Ӣ (Ljava/lang/String;)Z
      // 2e: aload 0
      // 2f: ldc "extra_items"
      // 31: invokevirtual x/ocbd3640d420.ĩ (Ljava/lang/String;)Ljava/util/List;
      // 34: invokestatic x/ocbd3640d420.Ř (Ljava/lang/Integer;ZZZLjava/util/List;)Z
      // 37: ireturn
   }

   public static boolean Ř(Integer param0, boolean param1, boolean param2, boolean param3, List<String> param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 5
      // 05: aload 0
      // 06: iload 5
      // 08: ifne 16
      // 0b: ifnonnull 15
      // 0e: goto 12
      // 11: athrow
      // 12: iload 1
      // 13: ireturn
      // 14: athrow
      // 15: aload 0
      // 16: invokevirtual java/lang/Integer.intValue ()I
      // 19: istore 6
      // 1b: iload 6
      // 1d: ldc -15835061
      // 1f: ldc -15834807
      // 21: ixor
      // 22: isub
      // 23: istore 7
      // 25: iload 7
      // 27: iload 5
      // 29: ifne 73
      // 2c: ldc -15834796
      // 2e: ldc -15834807
      // 30: ixor
      // 31: invokestatic java/lang/Integer.compareUnsigned (II)I
      // 34: ifge 71
      // 37: goto 3b
      // 3a: athrow
      // 3b: ldc -49666231
      // 3d: ldc -15834807
      // 3f: ixor
      // 40: iload 7
      // 42: iushr
      // 43: iload 5
      // 45: ifne 6b
      // 48: goto 4c
      // 4b: athrow
      // 4c: bipush 1
      // 4d: iand
      // 4e: ifeq 58
      // 51: goto 55
      // 54: athrow
      // 55: iload 2
      // 56: ireturn
      // 57: athrow
      // 58: ldc -282312376
      // 5a: ldc -15834807
      // 5c: ixor
      // 5d: iload 7
      // 5f: iushr
      // 60: iload 5
      // 62: ifne 73
      // 65: bipush 1
      // 66: iand
      // 67: goto 6b
      // 6a: athrow
      // 6b: ifeq 71
      // 6e: iload 3
      // 6f: ireturn
      // 70: athrow
      // 71: iload 6
      // 73: iload 5
      // 75: ifne 80
      // 78: ifne 83
      // 7b: goto 7f
      // 7e: athrow
      // 7f: iload 1
      // 80: goto 8a
      // 83: aload 4
      // 85: iload 6
      // 87: invokestatic x/ocac553a4d9a.ƃ (Ljava/util/List;I)Z
      // 8a: ireturn
   }

   public int Ō(InventoryPlayer param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: bipush 0
      // 04: istore 3
      // 05: istore 2
      // 06: iload 3
      // 07: ldc 569013572
      // 09: ldc 569013581
      // 0b: ixor
      // 0c: if_icmpge 7b
      // 0f: aload 0
      // 10: iload 3
      // 11: bipush 1
      // 12: iadd
      // 13: invokestatic java/lang/Integer.toString (I)Ljava/lang/String;
      // 16: invokevirtual x/ocbd3640d420.Ӣ (Ljava/lang/String;)Z
      // 19: iload 2
      // 1a: ifne 7c
      // 1d: iload 2
      // 1e: ifne 2d
      // 21: goto 25
      // 24: athrow
      // 25: ifeq 2e
      // 28: goto 2c
      // 2b: athrow
      // 2c: iload 3
      // 2d: ireturn
      // 2e: aload 1
      // 2f: iload 3
      // 30: invokevirtual net/minecraft/entity/player/InventoryPlayer.getStackInSlot (I)Lnet/minecraft/item/ItemStack;
      // 33: astore 4
      // 35: iload 2
      // 36: ifne 77
      // 39: aload 4
      // 3b: ifnull 74
      // 3e: goto 42
      // 41: athrow
      // 42: aload 0
      // 43: aload 4
      // 45: invokestatic x/ocbd3640d420.Н (Lnet/minecraft/item/ItemStack;)I
      // 48: invokevirtual x/ocbd3640d420.u (I)Z
      // 4b: iload 2
      // 4c: ifne 73
      // 4f: goto 53
      // 52: athrow
      // 53: ifne 72
      // 56: goto 5a
      // 59: athrow
      // 5a: aload 0
      // 5b: aload 4
      // 5d: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 60: invokevirtual x/ocbd3640d420.ճ (Lnet/minecraft/item/Item;)Z
      // 63: iload 2
      // 64: ifne 73
      // 67: goto 6b
      // 6a: athrow
      // 6b: ifeq 74
      // 6e: goto 72
      // 71: athrow
      // 72: iload 3
      // 73: ireturn
      // 74: iinc 3 1
      // 77: iload 2
      // 78: ifeq 06
      // 7b: bipush -1
      // 7c: ireturn
   }

   public boolean Ś(EntityPlayer var1) {
      try {
         if (var1 == null) {
            return false;
         }
      } catch (IllegalArgumentException var2) {
         throw var2;
      }

      this.ӱ(var1);
      return this.ƞ.Ɩ;
   }

   public int ϒ(EntityPlayer var1) {
      try {
         if (var1 == null) {
            return 0;
         }
      } catch (IllegalArgumentException var2) {
         throw var2;
      }

      this.ӱ(var1);
      return this.ƞ.ձ;
   }

   private void ӱ(EntityPlayer var1) {
      this.ƞ.ш(var1.ticksExisted, new oc61f450d65a(this, var1));
   }

   public static int Н(ItemStack var0) {
      int var10000 = oc75d51ec7eb.ϩ;
      NBTTagList var2 = var0.getEnchantmentTagList();
      int var1 = var10000;

      try {
         if (var2 == null) {
            return 0;
         }
      } catch (IllegalArgumentException var5) {
         throw var5;
      }

      int var3 = 0;
      int var4 = 0;

      while (true) {
         if (var4 < var2.tagCount()) {
            var10000 = var3;
            if (var1 != 0) {
               break;
            }

            var3 |= ӛ(var2.getCompoundTagAt(var4).getShort("id") & (-1446208438 ^ -1446222923));
            var4++;
            if (var1 == 0) {
               continue;
            }
         }

         var10000 = var3;
         break;
      }

      return var10000;
   }

   public static int ӛ(int param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 1
      // 04: iload 0
      // 05: iload 1
      // 06: ifne 49
      // 09: ldc_w -1818024858
      // 0c: ldc_w -1817977959
      // 0f: ixor
      // 10: iand
      // 11: tableswitch 39 16 20 36 39 39 41 49
      // 34: athrow
      // 35: bipush 1
      // 36: ireturn
      // 37: athrow
      // 38: bipush 0
      // 39: ireturn
      // 3a: ldc_w -1817977957
      // 3d: ldc_w -1817977959
      // 40: ixor
      // 41: ireturn
      // 42: ldc_w -1817977955
      // 45: ldc_w -1817977959
      // 48: ixor
      // 49: ireturn
   }
}

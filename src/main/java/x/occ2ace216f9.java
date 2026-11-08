package x;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class occ2ace216f9 {
   private final ItemStack Β;
   public ItemStack À;
   public String ŷ;
   public String Է;
   public String Ҍ;
   public int ɡ;
   public int ó;
   public int ȏ;
   public int Ӎ;
   public boolean ɨ;
   public int ʠ;
   public static boolean ɼ;

   public occ2ace216f9(ItemStack var1) {
      this.Β = var1;
      this.À = var1;
      this.ɡ = var1 == null ? 0 : var1.stackSize;
      this.ó = var1 != null && var1.getItem() != null ? var1.getMaxStackSize() : 0;
      this.ʠ = var1 == null ? 0 : var1.getMetadata();
      this.ȏ = var1 == null ? 0 : var1.getItemDamage();
      this.Ӎ = var1 != null && var1.getItem() != null ? var1.getMaxDamage() : 0;
      this.ɨ = var1 != null && var1.getItem() instanceof ItemBlock;
      if (this.ɨ) {
         this.Է = occ0b63c0426.ɛ(((ItemBlock)var1.getItem()).getBlock());
      } else {
         this.Է = var1 != null && var1.getItem() != null ? occ0b63c0426.Ƅ(var1.getItem().getUnlocalizedName()) : null;
      }

      this.ŷ = this.Է;
      this.Ҍ = var1 == null ? "" : var1.getDisplayName();
   }

   public occ2ace216f9(ItemStack var1, byte var2) {
      this(var1);
   }

   public occ2ace216f9(String var1) {
      this(Ǻ(var1));
   }

   private static ItemStack Ǻ(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/occ0b63c0426.Ο I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 20
      // 09: ifnull 26
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 0
      // 11: iload 1
      // 12: ifne 2d
      // 15: goto 19
      // 18: athrow
      // 19: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 1c: goto 20
      // 1f: athrow
      // 20: invokevirtual java/lang/String.isEmpty ()Z
      // 23: ifeq 29
      // 26: aconst_null
      // 27: areturn
      // 28: athrow
      // 29: aload 0
      // 2a: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 2d: astore 2
      // 2e: bipush 0
      // 2f: istore 3
      // 30: aload 2
      // 31: ldc -526560924
      // 33: ldc -526560930
      // 35: ixor
      // 36: invokevirtual java/lang/String.lastIndexOf (I)I
      // 39: istore 4
      // 3b: iload 4
      // 3d: iload 1
      // 3e: ifne 4a
      // 41: ifle 74
      // 44: goto 48
      // 47: athrow
      // 48: iload 4
      // 4a: iload 1
      // 4b: ifne 66
      // 4e: aload 2
      // 4f: invokevirtual java/lang/String.length ()I
      // 52: bipush 1
      // 53: isub
      // 54: if_icmpge 74
      // 57: goto 5b
      // 5a: athrow
      // 5b: aload 2
      // 5c: iload 4
      // 5e: bipush 1
      // 5f: iadd
      // 60: invokevirtual java/lang/String.substring (I)Ljava/lang/String;
      // 63: invokestatic java/lang/Integer.parseInt (Ljava/lang/String;)I
      // 66: istore 3
      // 67: aload 2
      // 68: bipush 0
      // 69: iload 4
      // 6b: invokevirtual java/lang/String.substring (II)Ljava/lang/String;
      // 6e: astore 2
      // 6f: goto 74
      // 72: astore 5
      // 74: aload 2
      // 75: invokestatic net/minecraft/item/Item.getByNameOrId (Ljava/lang/String;)Lnet/minecraft/item/Item;
      // 78: astore 5
      // 7a: aload 5
      // 7c: ifnonnull 84
      // 7f: aconst_null
      // 80: goto 8f
      // 83: athrow
      // 84: new net/minecraft/item/ItemStack
      // 87: dup
      // 88: aload 5
      // 8a: bipush 1
      // 8b: iload 3
      // 8c: invokespecial net/minecraft/item/ItemStack.<init> (Lnet/minecraft/item/Item;II)V
      // 8f: areturn
   }

   static occ2ace216f9 ɖ(ItemStack var0) {
      try {
         if (var0 == null) {
            return null;
         }
      } catch (NumberFormatException var1) {
         throw var1;
      }

      return new occ2ace216f9(var0);
   }

   public static occ2ace216f9 à(ItemStack var0) {
      return ɖ(var0);
   }

   public String Ȋ() {
      return this.Է;
   }

   public int Ԟ() {
      return this.ɡ;
   }

   public int Ҏ() {
      return this.ɡ;
   }

   public int æ() {
      return this.ó;
   }

   public String Ʀ() {
      return this.ŷ;
   }

   public String ă() {
      return this.Ҍ;
   }

   public boolean ŝ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/occ0b63c0426.Ο I
      // 03: istore 1
      // 04: aload 0
      // 05: getfield x/occ2ace216f9.ɡ I
      // 08: iload 1
      // 09: ifne 23
      // 0c: ifle 1e
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: getfield x/occ2ace216f9.Β Lnet/minecraft/item/ItemStack;
      // 17: ifnonnull 26
      // 1a: goto 1e
      // 1d: athrow
      // 1e: bipush 1
      // 1f: goto 23
      // 22: athrow
      // 23: goto 27
      // 26: bipush 0
      // 27: ireturn
   }

   public int ê() {
      return this.ʠ;
   }

   public int к() {
      return this.ʠ;
   }

   public int ш() {
      return this.ȏ;
   }

   public int ɖ() {
      return this.Ӎ;
   }

   public List<String> X() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: new java/util/ArrayList
      // 03: dup
      // 04: invokespecial java/util/ArrayList.<init> ()V
      // 07: astore 1
      // 08: aload 0
      // 09: getfield x/occ2ace216f9.Β Lnet/minecraft/item/ItemStack;
      // 0c: ifnull 1c
      // 0f: invokestatic net/minecraft/client/Minecraft.getMinecraft ()Lnet/minecraft/client/Minecraft;
      // 12: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 15: ifnonnull 1f
      // 18: goto 1c
      // 1b: athrow
      // 1c: aload 1
      // 1d: areturn
      // 1e: athrow
      // 1f: aload 0
      // 20: getfield x/occ2ace216f9.Β Lnet/minecraft/item/ItemStack;
      // 23: invokestatic net/minecraft/client/Minecraft.getMinecraft ()Lnet/minecraft/client/Minecraft;
      // 26: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 29: bipush 0
      // 2a: invokevirtual net/minecraft/item/ItemStack.getTooltip (Lnet/minecraft/entity/player/EntityPlayer;Z)Ljava/util/List;
      // 2d: areturn
   }

   public List<Object[]> ѿ() {
      return new ArrayList<>();
   }

   public ItemStack W() {
      return this.Β;
   }

   @Override
   public String toString() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/occ0b63c0426.Ο I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 1f
      // 09: getfield x/occ2ace216f9.Ҍ Ljava/lang/String;
      // 0c: ifnonnull 1e
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: getfield x/occ2ace216f9.Է Ljava/lang/String;
      // 17: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 1a: goto 22
      // 1d: athrow
      // 1e: aload 0
      // 1f: getfield x/occ2ace216f9.Ҍ Ljava/lang/String;
      // 22: areturn
   }
}

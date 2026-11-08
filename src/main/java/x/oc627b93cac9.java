package x;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class oc627b93cac9 {
   private final IBlockState Ϟ;
   private final String ϸ;
   private final String ͼ;
   private final int ȣ;
   private final ItemStack ʵ;
   private final TextureAtlasSprite ɾ;

   private oc627b93cac9(IBlockState var1, String var2, String var3, ItemStack var4, TextureAtlasSprite var5) {
      this.Ϟ = var1;
      this.ϸ = var2;
      this.ͼ = var3;
      this.ʵ = var4;
      this.ɾ = var5;
      this.ȣ = var2.hashCode();
   }

   private static oc627b93cac9 Ŭ(IBlockState param0, BlockPos param1, World param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokestatic x/occa6aba7d1a.V (Lnet/minecraft/block/state/IBlockState;)Ljava/lang/String;
      // 04: astore 4
      // 06: getstatic x/oce6044968f8.ђ Z
      // 09: aload 0
      // 0a: aload 1
      // 0b: aload 2
      // 0c: invokestatic x/occa6aba7d1a.ӗ (Lnet/minecraft/block/state/IBlockState;Lnet/minecraft/util/BlockPos;Lnet/minecraft/world/World;)Lnet/minecraft/item/ItemStack;
      // 0f: astore 5
      // 11: aload 0
      // 12: aload 5
      // 14: invokestatic x/oc627b93cac9.ȼ (Lnet/minecraft/block/state/IBlockState;Lnet/minecraft/item/ItemStack;)Ljava/lang/String;
      // 17: astore 6
      // 19: istore 3
      // 1a: aconst_null
      // 1b: astore 7
      // 1d: aload 5
      // 1f: iload 3
      // 20: ifne 2c
      // 23: ifnull 32
      // 26: goto 2a
      // 29: athrow
      // 2a: aload 5
      // 2c: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 2f: ifnonnull 57
      // 32: aload 0
      // 33: invokestatic x/occa6aba7d1a.ģ (Lnet/minecraft/block/state/IBlockState;)Lnet/minecraft/client/renderer/texture/TextureAtlasSprite;
      // 36: astore 7
      // 38: iload 3
      // 39: ifne 50
      // 3c: aload 7
      // 3e: ifnonnull 54
      // 41: goto 45
      // 44: athrow
      // 45: aload 0
      // 46: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 4b: invokestatic x/occa6aba7d1a.Ъ (Lnet/minecraft/block/Block;)Lnet/minecraft/item/ItemStack;
      // 4e: astore 5
      // 50: iload 3
      // 51: ifeq 57
      // 54: aconst_null
      // 55: astore 5
      // 57: aload 5
      // 59: iload 3
      // 5a: ifne 66
      // 5d: ifnull 82
      // 60: goto 64
      // 63: athrow
      // 64: aload 5
      // 66: iload 3
      // 67: ifne 7a
      // 6a: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 6d: ifnull 82
      // 70: goto 74
      // 73: athrow
      // 74: aload 5
      // 76: goto 7a
      // 79: athrow
      // 7a: aload 4
      // 7c: invokestatic x/oc627b93cac9.ǆ (Lnet/minecraft/item/ItemStack;Ljava/lang/String;)Ljava/lang/String;
      // 7f: goto 84
      // 82: aload 4
      // 84: astore 8
      // 86: new x/oc627b93cac9
      // 89: dup
      // 8a: aload 0
      // 8b: aload 6
      // 8d: aload 8
      // 8f: aload 5
      // 91: aload 7
      // 93: invokespecial x/oc627b93cac9.<init> (Lnet/minecraft/block/state/IBlockState;Ljava/lang/String;Ljava/lang/String;Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/renderer/texture/TextureAtlasSprite;)V
      // 96: areturn
   }

   private ItemStack Ƣ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 19
      // 09: getfield x/oc627b93cac9.ʵ Lnet/minecraft/item/ItemStack;
      // 0c: ifnonnull 18
      // 0f: goto 13
      // 12: athrow
      // 13: aconst_null
      // 14: goto 1f
      // 17: athrow
      // 18: aload 0
      // 19: getfield x/oc627b93cac9.ʵ Lnet/minecraft/item/ItemStack;
      // 1c: invokevirtual net/minecraft/item/ItemStack.copy ()Lnet/minecraft/item/ItemStack;
      // 1f: areturn
   }

   private static String ȼ(IBlockState param0, ItemStack param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 41
      // 09: ifnull 35
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 1
      // 11: iload 2
      // 12: ifne 41
      // 15: goto 19
      // 18: athrow
      // 19: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 1c: ifnull 35
      // 1f: goto 23
      // 22: athrow
      // 23: aload 1
      // 24: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 27: invokestatic net/minecraft/item/Item.getIdFromItem (Lnet/minecraft/item/Item;)I
      // 2a: aload 1
      // 2b: invokevirtual net/minecraft/item/ItemStack.getMetadata ()I
      // 2e: invokedynamic makeConcatWithConstants (II)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001:\u0001" ]
      // 33: areturn
      // 34: athrow
      // 35: getstatic net/minecraft/block/Block.blockRegistry Lnet/minecraft/util/RegistryNamespacedDefaultedByKey;
      // 38: aload 0
      // 39: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 3e: invokevirtual net/minecraft/util/RegistryNamespacedDefaultedByKey.getNameForObject (Ljava/lang/Object;)Ljava/lang/Object;
      // 41: astore 3
      // 42: aload 3
      // 43: iload 2
      // 44: ifne 4f
      // 47: ifnull 55
      // 4a: goto 4e
      // 4d: athrow
      // 4e: aload 3
      // 4f: invokevirtual java/lang/Object.toString ()Ljava/lang/String;
      // 52: goto 61
      // 55: aload 0
      // 56: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 5b: invokestatic net/minecraft/block/Block.getIdFromBlock (Lnet/minecraft/block/Block;)I
      // 5e: invokestatic java/lang/Integer.toString (I)Ljava/lang/String;
      // 61: areturn
   }

   private static String ǆ(ItemStack param0, String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 11
      // 09: ifnull 1f
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 0
      // 11: iload 2
      // 12: ifne 23
      // 15: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 18: ifnonnull 22
      // 1b: goto 1f
      // 1e: athrow
      // 1f: aload 1
      // 20: areturn
      // 21: athrow
      // 22: aload 0
      // 23: invokevirtual net/minecraft/item/ItemStack.getDisplayName ()Ljava/lang/String;
      // 26: astore 3
      // 27: aload 3
      // 28: iload 2
      // 29: ifne 34
      // 2c: ifnull 4a
      // 2f: goto 33
      // 32: athrow
      // 33: aload 3
      // 34: iload 2
      // 35: ifne 47
      // 38: invokevirtual java/lang/String.isEmpty ()Z
      // 3b: ifne 4a
      // 3e: goto 42
      // 41: athrow
      // 42: aload 3
      // 43: goto 47
      // 46: athrow
      // 47: goto 4b
      // 4a: aload 1
      // 4b: areturn
      // 4c: astore 3
      // 4d: aload 1
      // 4e: areturn
   }

   @Override
   public boolean equals(Object param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 15
      // 09: aload 1
      // 0a: if_acmpne 14
      // 0d: goto 11
      // 10: athrow
      // 11: bipush 1
      // 12: ireturn
      // 13: athrow
      // 14: aload 1
      // 15: iload 2
      // 16: ifne 27
      // 19: instanceof x/oc627b93cac9
      // 1c: ifne 26
      // 1f: goto 23
      // 22: athrow
      // 23: bipush 0
      // 24: ireturn
      // 25: athrow
      // 26: aload 1
      // 27: checkcast x/oc627b93cac9
      // 2a: astore 3
      // 2b: aload 0
      // 2c: getfield x/oc627b93cac9.ϸ Ljava/lang/String;
      // 2f: aload 3
      // 30: getfield x/oc627b93cac9.ϸ Ljava/lang/String;
      // 33: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 36: ireturn
   }

   @Override
   public int hashCode() {
      return this.ȣ;
   }
}

package x;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;

public class oc22bed258fa {
   public static final AxisAlignedBB[] Э;
   public static final AxisAlignedBB[] å;
   public static final AxisAlignedBB[] Ȍ;
   public static final AxisAlignedBB ƒ = new AxisAlignedBB(0.0625, 0.0, 0.0625, 0.9375, 1.0, 0.9375);
   public static int Ί;

   public static AxisAlignedBB ĝ(BlockPos param0, IBlockState param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc22bed258fa.Ί I
      // 03: aload 1
      // 04: getstatic net/minecraft/block/BlockCrops.AGE Lnet/minecraft/block/properties/PropertyInteger;
      // 07: invokeinterface net/minecraft/block/state/IBlockState.getValue (Lnet/minecraft/block/properties/IProperty;)Ljava/lang/Comparable; 2
      // 0c: checkcast java/lang/Integer
      // 0f: invokevirtual java/lang/Integer.intValue ()I
      // 12: istore 3
      // 13: istore 2
      // 14: iload 3
      // 15: iload 2
      // 16: ifne 23
      // 19: ifge 22
      // 1c: goto 20
      // 1f: athrow
      // 20: bipush 0
      // 21: istore 3
      // 22: iload 3
      // 23: iload 2
      // 24: ifne 4a
      // 27: ldc -1974738543
      // 29: ldc -1974738538
      // 2b: ixor
      // 2c: if_icmple 39
      // 2f: goto 33
      // 32: athrow
      // 33: ldc -1974738543
      // 35: ldc -1974738538
      // 37: ixor
      // 38: istore 3
      // 39: aload 1
      // 3a: iload 2
      // 3b: ifne 4e
      // 3e: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 43: instanceof net/minecraft/block/BlockPotato
      // 46: goto 4a
      // 49: athrow
      // 4a: ifne 59
      // 4d: aload 1
      // 4e: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 53: instanceof net/minecraft/block/BlockCarrot
      // 56: ifeq 62
      // 59: getstatic x/oc22bed258fa.Э [Lnet/minecraft/util/AxisAlignedBB;
      // 5c: iload 3
      // 5d: aaload
      // 5e: goto 67
      // 61: athrow
      // 62: getstatic x/oc22bed258fa.å [Lnet/minecraft/util/AxisAlignedBB;
      // 65: iload 3
      // 66: aaload
      // 67: astore 4
      // 69: new net/minecraft/util/AxisAlignedBB
      // 6c: dup
      // 6d: aload 0
      // 6e: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 71: i2d
      // 72: aload 4
      // 74: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 77: dadd
      // 78: aload 0
      // 79: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 7c: i2d
      // 7d: aload 4
      // 7f: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 82: dadd
      // 83: aload 0
      // 84: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 87: i2d
      // 88: aload 4
      // 8a: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 8d: dadd
      // 8e: aload 0
      // 8f: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 92: i2d
      // 93: aload 4
      // 95: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 98: dadd
      // 99: aload 0
      // 9a: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 9d: i2d
      // 9e: aload 4
      // a0: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // a3: dadd
      // a4: aload 0
      // a5: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // a8: i2d
      // a9: aload 4
      // ab: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // ae: dadd
      // af: invokespecial net/minecraft/util/AxisAlignedBB.<init> (DDDDDD)V
      // b2: iload 2
      // b3: ifeq c7
      // b6: bipush 0
      // b7: ifeq c3
      // ba: goto be
      // bd: athrow
      // be: bipush 0
      // bf: goto c4
      // c2: athrow
      // c3: bipush 1
      // c4: putstatic x/oc69da1aa7f5.Ҭ Z
      // c7: areturn
   }

   public static AxisAlignedBB ł(BlockPos param0, IBlockState param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc22bed258fa.Ί I
      // 03: aload 1
      // 04: getstatic net/minecraft/block/BlockNetherWart.AGE Lnet/minecraft/block/properties/PropertyInteger;
      // 07: invokeinterface net/minecraft/block/state/IBlockState.getValue (Lnet/minecraft/block/properties/IProperty;)Ljava/lang/Comparable; 2
      // 0c: checkcast java/lang/Integer
      // 0f: invokevirtual java/lang/Integer.intValue ()I
      // 12: istore 3
      // 13: istore 2
      // 14: iload 3
      // 15: iload 2
      // 16: ifne 23
      // 19: ifge 22
      // 1c: goto 20
      // 1f: athrow
      // 20: bipush 0
      // 21: istore 3
      // 22: iload 3
      // 23: iload 2
      // 24: ifne 3c
      // 27: ldc 377923438
      // 29: ldc 377923437
      // 2b: ixor
      // 2c: if_icmple 3d
      // 2f: goto 33
      // 32: athrow
      // 33: ldc 377923438
      // 35: ldc 377923437
      // 37: ixor
      // 38: goto 3c
      // 3b: athrow
      // 3c: istore 3
      // 3d: getstatic x/oc22bed258fa.Ȍ [Lnet/minecraft/util/AxisAlignedBB;
      // 40: iload 3
      // 41: aaload
      // 42: astore 4
      // 44: new net/minecraft/util/AxisAlignedBB
      // 47: dup
      // 48: aload 0
      // 49: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 4c: i2d
      // 4d: aload 4
      // 4f: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 52: dadd
      // 53: aload 0
      // 54: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 57: i2d
      // 58: aload 4
      // 5a: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 5d: dadd
      // 5e: aload 0
      // 5f: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 62: i2d
      // 63: aload 4
      // 65: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 68: dadd
      // 69: aload 0
      // 6a: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 6d: i2d
      // 6e: aload 4
      // 70: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 73: dadd
      // 74: aload 0
      // 75: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 78: i2d
      // 79: aload 4
      // 7b: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 7e: dadd
      // 7f: aload 0
      // 80: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 83: i2d
      // 84: aload 4
      // 86: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 89: dadd
      // 8a: invokespecial net/minecraft/util/AxisAlignedBB.<init> (DDDDDD)V
      // 8d: bipush 0
      // 8e: ifeq 9c
      // 91: iinc 2 1
      // 94: iload 2
      // 95: putstatic x/oc22bed258fa.Ί I
      // 98: goto 9c
      // 9b: athrow
      // 9c: areturn
   }

   static {
      AxisAlignedBB[] var10000 = new AxisAlignedBB[-755924306 ^ -755924314];
      var10000[0] = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.125, 1.0);
      var10000[1] = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.1875, 1.0);
      var10000[-755924316 ^ -755924314] = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.25, 1.0);
      var10000[-755924315 ^ -755924314] = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.3125, 1.0);
      var10000[-755924318 ^ -755924314] = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.375, 1.0);
      var10000[-755924317 ^ -755924314] = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.4375, 1.0);
      var10000[-755924320 ^ -755924314] = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.5, 1.0);
      var10000[-755924319 ^ -755924314] = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.5625, 1.0);
      Э = var10000;
      var10000 = new AxisAlignedBB[-755924306 ^ -755924314];
      var10000[0] = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.125, 1.0);
      var10000[1] = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.25, 1.0);
      var10000[-755924316 ^ -755924314] = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.375, 1.0);
      var10000[-755924315 ^ -755924314] = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.5, 1.0);
      var10000[-755924318 ^ -755924314] = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.625, 1.0);
      var10000[-755924317 ^ -755924314] = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.75, 1.0);
      var10000[-755924320 ^ -755924314] = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.875, 1.0);
      var10000[-755924319 ^ -755924314] = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
      å = var10000;
      var10000 = new AxisAlignedBB[-755924318 ^ -755924314];
      var10000[0] = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.3125, 1.0);
      var10000[1] = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.5, 1.0);
      var10000[-755924316 ^ -755924314] = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.6875, 1.0);
      var10000[-755924315 ^ -755924314] = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.875, 1.0);
      Ȍ = var10000;
   }
}

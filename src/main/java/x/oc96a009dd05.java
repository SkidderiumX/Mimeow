package x;

import java.util.List;
import net.minecraft.block.BlockBed;
import net.minecraft.block.BlockBed.EnumPartType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Vec3;

public class oc96a009dd05 implements ocda171fe5d8 {
   private static final double Ē = 1.62;
   private static final double ӄ = 4.5;
   private static final double ʢ = 1.0E-4;
   private static final int I = 64;
   public static boolean Ҡ;

   private oc96a009dd05() {
   }

   public static ocee6aeb382f Ǝ(BlockPos var0) {
      return ϓ(var0, null);
   }

   public static ocee6aeb382f ϓ(BlockPos param0, BlockPos param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 2
      // 004: aload 0
      // 005: ifnull 032
      // 008: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 00b: iload 2
      // 00c: ifne 024
      // 00f: goto 013
      // 012: athrow
      // 013: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 016: ifnull 032
      // 019: goto 01d
      // 01c: athrow
      // 01d: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 020: goto 024
      // 023: athrow
      // 024: iload 2
      // 025: ifne 038
      // 028: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 02b: ifnonnull 035
      // 02e: goto 032
      // 031: athrow
      // 032: aconst_null
      // 033: areturn
      // 034: athrow
      // 035: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 038: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 03b: aload 0
      // 03c: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 03f: astore 3
      // 040: aload 3
      // 041: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 046: instanceof net/minecraft/block/BlockBed
      // 049: ifne 04f
      // 04c: aconst_null
      // 04d: areturn
      // 04e: athrow
      // 04f: aload 0
      // 050: aload 3
      // 051: invokestatic x/oc96a009dd05.p (Lnet/minecraft/util/BlockPos;Lnet/minecraft/block/state/IBlockState;)Lnet/minecraft/util/BlockPos;
      // 054: astore 4
      // 056: aload 4
      // 058: ifnonnull 05e
      // 05b: aconst_null
      // 05c: areturn
      // 05d: athrow
      // 05e: aconst_null
      // 05f: astore 5
      // 061: aload 0
      // 062: aload 4
      // 064: invokestatic x/oc96a009dd05.Ŧ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/BlockPos;)Ljava/util/List;
      // 067: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 06c: astore 6
      // 06e: aload 6
      // 070: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 075: ifeq 13a
      // 078: aload 6
      // 07a: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 07f: checkcast net/minecraft/util/BlockPos
      // 082: astore 7
      // 084: aload 7
      // 086: invokestatic x/oc96a009dd05.ƕ (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/util/Vec3;
      // 089: astore 8
      // 08b: iload 2
      // 08c: ifne 160
      // 08f: ldc 548892856
      // 091: ldc 548892858
      // 093: ixor
      // 094: anewarray 52
      // 097: dup
      // 098: bipush 0
      // 099: aload 0
      // 09a: aastore
      // 09b: dup
      // 09c: bipush 1
      // 09d: aload 4
      // 09f: aastore
      // 0a0: astore 9
      // 0a2: aload 9
      // 0a4: arraylength
      // 0a5: istore 10
      // 0a7: bipush 0
      // 0a8: istore 11
      // 0aa: iload 11
      // 0ac: iload 10
      // 0ae: if_icmpge 136
      // 0b1: aload 9
      // 0b3: iload 11
      // 0b5: aaload
      // 0b6: astore 12
      // 0b8: iload 2
      // 0b9: ifne 06e
      // 0bc: aload 12
      // 0be: invokestatic x/oc96a009dd05.Ӻ (Lnet/minecraft/util/BlockPos;)[Lnet/minecraft/util/Vec3;
      // 0c1: astore 13
      // 0c3: aload 13
      // 0c5: arraylength
      // 0c6: istore 14
      // 0c8: bipush 0
      // 0c9: istore 15
      // 0cb: iload 15
      // 0cd: iload 14
      // 0cf: if_icmpge 12f
      // 0d2: aload 13
      // 0d4: iload 15
      // 0d6: aaload
      // 0d7: iload 2
      // 0d8: ifne 089
      // 0db: astore 16
      // 0dd: iload 2
      // 0de: aload 7
      // 0e0: aload 8
      // 0e2: aload 16
      // 0e4: aload 0
      // 0e5: aload 4
      // 0e7: invokestatic x/oc96a009dd05.Ա (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/BlockPos;)Lx/ocee6aeb382f;
      // 0ea: astore 17
      // 0ec: ifne 12b
      // 0ef: aload 17
      // 0f1: ifnull 128
      // 0f4: goto 0f8
      // 0f7: athrow
      // 0f8: aload 5
      // 0fa: iload 2
      // 0fb: ifne 126
      // 0fe: goto 102
      // 101: athrow
      // 102: ifnull 120
      // 105: goto 109
      // 108: athrow
      // 109: aload 17
      // 10b: iload 2
      // 10c: ifne 126
      // 10f: goto 113
      // 112: athrow
      // 113: aload 5
      // 115: aload 1
      // 116: invokestatic x/oc96a009dd05.ǹ (Lx/ocee6aeb382f;Lx/ocee6aeb382f;Lnet/minecraft/util/BlockPos;)Z
      // 119: ifeq 128
      // 11c: goto 120
      // 11f: athrow
      // 120: aload 17
      // 122: goto 126
      // 125: athrow
      // 126: astore 5
      // 128: iinc 15 1
      // 12b: iload 2
      // 12c: ifeq 0cb
      // 12f: iinc 11 1
      // 132: iload 2
      // 133: ifeq 0aa
      // 136: iload 2
      // 137: ifeq 06e
      // 13a: aload 5
      // 13c: iload 2
      // 13d: ifne 149
      // 140: ifnull 160
      // 143: goto 147
      // 146: athrow
      // 147: aload 5
      // 149: iload 2
      // 14a: ifne 15d
      // 14d: invokevirtual x/ocee6aeb382f.Ն ()Z
      // 150: ifeq 160
      // 153: goto 157
      // 156: athrow
      // 157: aload 5
      // 159: goto 15d
      // 15c: athrow
      // 15d: goto 161
      // 160: aconst_null
      // 161: areturn
   }

   private static boolean ǹ(ocee6aeb382f param0, ocee6aeb382f param1, BlockPos param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: aload 0
      // 004: getfield x/ocee6aeb382f.ө D
      // 007: aload 1
      // 008: getfield x/ocee6aeb382f.ө D
      // 00b: invokestatic java/lang/Double.compare (DD)I
      // 00e: istore 4
      // 010: istore 3
      // 011: iload 4
      // 013: iload 3
      // 014: ifne 039
      // 017: ifeq 035
      // 01a: goto 01e
      // 01d: athrow
      // 01e: iload 4
      // 020: iload 3
      // 021: ifne 030
      // 024: goto 028
      // 027: athrow
      // 028: ifge 033
      // 02b: goto 02f
      // 02e: athrow
      // 02f: bipush 1
      // 030: goto 034
      // 033: bipush 0
      // 034: ireturn
      // 035: aload 0
      // 036: getfield x/ocee6aeb382f.Ư I
      // 039: iload 3
      // 03a: ifne 050
      // 03d: aload 1
      // 03e: getfield x/ocee6aeb382f.Ư I
      // 041: if_icmpeq 069
      // 044: goto 048
      // 047: athrow
      // 048: aload 0
      // 049: getfield x/ocee6aeb382f.Ư I
      // 04c: goto 050
      // 04f: athrow
      // 050: iload 3
      // 051: ifne 064
      // 054: aload 1
      // 055: getfield x/ocee6aeb382f.Ư I
      // 058: if_icmpge 067
      // 05b: goto 05f
      // 05e: athrow
      // 05f: bipush 1
      // 060: goto 064
      // 063: athrow
      // 064: goto 068
      // 067: bipush 0
      // 068: ireturn
      // 069: aload 2
      // 06a: iload 3
      // 06b: ifne 0ef
      // 06e: ifnull 0eb
      // 071: goto 075
      // 074: athrow
      // 075: aload 0
      // 076: getfield x/ocee6aeb382f.Χ Lnet/minecraft/util/BlockPos;
      // 079: aload 2
      // 07a: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 07d: istore 5
      // 07f: aload 1
      // 080: iload 3
      // 081: ifne 0ec
      // 084: getfield x/ocee6aeb382f.Χ Lnet/minecraft/util/BlockPos;
      // 087: aload 2
      // 088: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 08b: istore 6
      // 08d: iload 5
      // 08f: iload 6
      // 091: if_icmpeq 0eb
      // 094: aload 0
      // 095: getfield x/ocee6aeb382f.Χ Lnet/minecraft/util/BlockPos;
      // 098: invokestatic x/oc96a009dd05.Ӟ (Lnet/minecraft/util/BlockPos;)D
      // 09b: dstore 7
      // 09d: aload 1
      // 09e: getfield x/ocee6aeb382f.Χ Lnet/minecraft/util/BlockPos;
      // 0a1: invokestatic x/oc96a009dd05.Ӟ (Lnet/minecraft/util/BlockPos;)D
      // 0a4: dstore 9
      // 0a6: iload 6
      // 0a8: iload 3
      // 0a9: ifne 0da
      // 0ac: ifeq 0d1
      // 0af: goto 0b3
      // 0b2: athrow
      // 0b3: dload 7
      // 0b5: ldc2_w 1.5
      // 0b8: dadd
      // 0b9: dload 9
      // 0bb: dcmpg
      // 0bc: iload 3
      // 0bd: ifne 0cc
      // 0c0: goto 0c4
      // 0c3: athrow
      // 0c4: ifge 0cf
      // 0c7: goto 0cb
      // 0ca: athrow
      // 0cb: bipush 1
      // 0cc: goto 0d0
      // 0cf: bipush 0
      // 0d0: ireturn
      // 0d1: dload 7
      // 0d3: dload 9
      // 0d5: ldc2_w 1.5
      // 0d8: dadd
      // 0d9: dcmpg
      // 0da: iload 3
      // 0db: ifne 0e6
      // 0de: ifge 0e9
      // 0e1: goto 0e5
      // 0e4: athrow
      // 0e5: bipush 1
      // 0e6: goto 0ea
      // 0e9: bipush 0
      // 0ea: ireturn
      // 0eb: aload 0
      // 0ec: getfield x/ocee6aeb382f.Χ Lnet/minecraft/util/BlockPos;
      // 0ef: invokestatic x/oc96a009dd05.Ӟ (Lnet/minecraft/util/BlockPos;)D
      // 0f2: aload 1
      // 0f3: getfield x/ocee6aeb382f.Χ Lnet/minecraft/util/BlockPos;
      // 0f6: invokestatic x/oc96a009dd05.Ӟ (Lnet/minecraft/util/BlockPos;)D
      // 0f9: dcmpg
      // 0fa: iload 3
      // 0fb: ifne 106
      // 0fe: ifge 109
      // 101: goto 105
      // 104: athrow
      // 105: bipush 1
      // 106: goto 10a
      // 109: bipush 0
      // 10a: ireturn
   }

   private static double Ӟ(BlockPos var0) {
      double var1 = var0.getX() + 0.5 - ocda171fe5d8.ǔ.thePlayer.posX;
      double var3 = var0.getY() - ocda171fe5d8.ǔ.thePlayer.posY;
      double var5 = var0.getZ() + 0.5 - ocda171fe5d8.ǔ.thePlayer.posZ;
      return var1 * var1 + var3 * var3 + var5 * var5;
   }

   private static ocee6aeb382f Ա(BlockPos param0, Vec3 param1, Vec3 param2, BlockPos param3, BlockPos param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: aconst_null
      // 001: astore 6
      // 003: getstatic x/oc75d51ec7eb.ϩ I
      // 006: dconst_0
      // 007: dstore 7
      // 009: bipush 0
      // 00a: istore 9
      // 00c: bipush 0
      // 00d: istore 10
      // 00f: aload 1
      // 010: aload 2
      // 011: invokestatic x/oc96a009dd05.ė (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Ljava/util/List;
      // 014: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 019: astore 11
      // 01b: istore 5
      // 01d: aload 11
      // 01f: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 024: ifeq 18e
      // 027: aload 11
      // 029: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 02e: checkcast net/minecraft/util/BlockPos
      // 031: astore 12
      // 033: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 036: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 039: aload 12
      // 03b: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 03e: astore 13
      // 040: aload 13
      // 042: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 047: astore 14
      // 049: aload 14
      // 04b: iload 5
      // 04d: ifne 068
      // 050: aload 13
      // 052: bipush 0
      // 053: invokevirtual net/minecraft/block/Block.canCollideCheck (Lnet/minecraft/block/state/IBlockState;Z)Z
      // 056: ifne 066
      // 059: goto 05d
      // 05c: athrow
      // 05d: iload 5
      // 05f: ifeq 01d
      // 062: goto 066
      // 065: athrow
      // 066: aload 14
      // 068: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 06b: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 06e: aload 12
      // 070: aload 1
      // 071: aload 2
      // 072: invokevirtual net/minecraft/block/Block.collisionRayTrace (Lnet/minecraft/world/World;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/MovingObjectPosition;
      // 075: astore 15
      // 077: aload 15
      // 079: iload 5
      // 07b: ifne 087
      // 07e: ifnull 01d
      // 081: goto 085
      // 084: athrow
      // 085: aload 15
      // 087: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 08a: iload 5
      // 08c: ifne 0a0
      // 08f: ifnonnull 09f
      // 092: goto 096
      // 095: athrow
      // 096: iload 5
      // 098: ifeq 01d
      // 09b: goto 09f
      // 09e: athrow
      // 09f: aload 1
      // 0a0: aload 15
      // 0a2: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 0a5: invokevirtual net/minecraft/util/Vec3.distanceTo (Lnet/minecraft/util/Vec3;)D
      // 0a8: dstore 16
      // 0aa: dload 16
      // 0ac: ldc2_w 4.5001
      // 0af: dcmpl
      // 0b0: iload 5
      // 0b2: ifne 0c4
      // 0b5: ifle 0bf
      // 0b8: goto 0bc
      // 0bb: athrow
      // 0bc: aconst_null
      // 0bd: areturn
      // 0be: athrow
      // 0bf: aload 14
      // 0c1: instanceof net/minecraft/block/BlockBed
      // 0c4: istore 18
      // 0c6: iload 18
      // 0c8: iload 5
      // 0ca: ifne 0fb
      // 0cd: ifeq 0f9
      // 0d0: goto 0d4
      // 0d3: athrow
      // 0d4: aload 12
      // 0d6: aload 3
      // 0d7: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 0da: iload 5
      // 0dc: ifne 0fb
      // 0df: goto 0e3
      // 0e2: athrow
      // 0e3: ifeq 0f9
      // 0e6: goto 0ea
      // 0e9: athrow
      // 0ea: new x/ocee6aeb382f
      // 0ed: dup
      // 0ee: aload 0
      // 0ef: aload 2
      // 0f0: dload 7
      // 0f2: iload 9
      // 0f4: invokespecial x/ocee6aeb382f.<init> (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/Vec3;DI)V
      // 0f7: areturn
      // 0f8: athrow
      // 0f9: iload 18
      // 0fb: iload 5
      // 0fd: ifne 13a
      // 100: ifeq 121
      // 103: goto 107
      // 106: athrow
      // 107: aload 12
      // 109: aload 4
      // 10b: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 10e: iload 5
      // 110: ifne 13a
      // 113: goto 117
      // 116: athrow
      // 117: ifeq 121
      // 11a: goto 11e
      // 11d: athrow
      // 11e: aconst_null
      // 11f: areturn
      // 120: athrow
      // 121: aload 14
      // 123: iload 5
      // 125: ifne 142
      // 128: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 12b: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 12e: aload 12
      // 130: invokevirtual net/minecraft/block/Block.getBlockHardness (Lnet/minecraft/world/World;Lnet/minecraft/util/BlockPos;)F
      // 133: f2d
      // 134: dconst_0
      // 135: dcmpg
      // 136: goto 13a
      // 139: athrow
      // 13a: ifge 140
      // 13d: aconst_null
      // 13e: areturn
      // 13f: athrow
      // 140: aload 6
      // 142: iload 5
      // 144: ifne 150
      // 147: ifnonnull 152
      // 14a: goto 14e
      // 14d: athrow
      // 14e: aload 14
      // 150: astore 6
      // 152: aload 12
      // 154: invokestatic x/oce0a4bd4278.ʰ (Lnet/minecraft/util/BlockPos;)F
      // 157: fstore 19
      // 159: iload 5
      // 15b: ifne 17c
      // 15e: fload 19
      // 160: fconst_0
      // 161: fcmpg
      // 162: ifgt 16c
      // 165: goto 169
      // 168: athrow
      // 169: aconst_null
      // 16a: areturn
      // 16b: athrow
      // 16c: dload 7
      // 16e: dconst_1
      // 16f: fload 19
      // 171: f2d
      // 172: ddiv
      // 173: dadd
      // 174: dstore 7
      // 176: iinc 9 1
      // 179: iinc 10 1
      // 17c: iload 10
      // 17e: ldc 442117536
      // 180: ldc 442117600
      // 182: ixor
      // 183: if_icmplt 189
      // 186: aconst_null
      // 187: areturn
      // 188: athrow
      // 189: iload 5
      // 18b: ifeq 01d
      // 18e: aconst_null
      // 18f: areturn
   }

   private static List<BlockPos> Ŧ(BlockPos param0, BlockPos param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: new java/util/ArrayList
      // 06: dup
      // 07: invokespecial java/util/ArrayList.<init> ()V
      // 0a: astore 3
      // 0b: istore 2
      // 0c: ldc2_w 4.5
      // 0f: invokestatic java/lang/Math.ceil (D)D
      // 12: d2i
      // 13: bipush 1
      // 14: iadd
      // 15: istore 4
      // 17: aload 0
      // 18: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 1b: istore 5
      // 1d: aload 0
      // 1e: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 21: istore 6
      // 23: aload 0
      // 24: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 27: istore 7
      // 29: iload 5
      // 2b: iload 4
      // 2d: isub
      // 2e: istore 8
      // 30: iload 8
      // 32: iload 5
      // 34: iload 4
      // 36: iadd
      // 37: if_icmpgt b2
      // 3a: iload 7
      // 3c: iload 4
      // 3e: isub
      // 3f: istore 9
      // 41: iload 9
      // 43: iload 7
      // 45: iload 4
      // 47: iadd
      // 48: if_icmpgt ab
      // 4b: iload 6
      // 4d: iload 4
      // 4f: iload 2
      // 50: ifne 37
      // 53: isub
      // 54: istore 10
      // 56: iload 10
      // 58: iload 6
      // 5a: bipush 1
      // 5b: iadd
      // 5c: if_icmpgt a4
      // 5f: new net/minecraft/util/BlockPos
      // 62: dup
      // 63: iload 8
      // 65: iload 10
      // 67: iload 9
      // 69: invokespecial net/minecraft/util/BlockPos.<init> (III)V
      // 6c: astore 11
      // 6e: iload 2
      // 6f: ifne a7
      // 72: aload 11
      // 74: aload 0
      // 75: aload 1
      // 76: invokestatic x/oc96a009dd05.õ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/BlockPos;)Z
      // 79: iload 2
      // 7a: ifne 9c
      // 7d: goto 81
      // 80: athrow
      // 81: ifne 90
      // 84: goto 88
      // 87: athrow
      // 88: iload 2
      // 89: ifeq 9d
      // 8c: goto 90
      // 8f: athrow
      // 90: aload 3
      // 91: aload 11
      // 93: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 98: goto 9c
      // 9b: athrow
      // 9c: pop
      // 9d: iinc 10 1
      // a0: iload 2
      // a1: ifeq 56
      // a4: iinc 9 1
      // a7: iload 2
      // a8: ifeq 41
      // ab: iinc 8 1
      // ae: iload 2
      // af: ifeq 30
      // b2: aload 3
      // b3: areturn
   }

   private static boolean õ(BlockPos param0, BlockPos param1, BlockPos param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 3
      // 04: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 07: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 0a: aload 0
      // 0b: invokevirtual net/minecraft/util/BlockPos.up ()Lnet/minecraft/util/BlockPos;
      // 0e: invokevirtual net/minecraft/client/multiplayer/WorldClient.isAirBlock (Lnet/minecraft/util/BlockPos;)Z
      // 11: iload 3
      // 12: ifne 42
      // 15: ifeq 3d
      // 18: goto 1c
      // 1b: athrow
      // 1c: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 1f: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 22: aload 0
      // 23: iload 3
      // 24: ifne 52
      // 27: goto 2b
      // 2a: athrow
      // 2b: ldc 1036241455
      // 2d: ldc 1036241453
      // 2f: ixor
      // 30: invokevirtual net/minecraft/util/BlockPos.up (I)Lnet/minecraft/util/BlockPos;
      // 33: invokevirtual net/minecraft/client/multiplayer/WorldClient.isAirBlock (Lnet/minecraft/util/BlockPos;)Z
      // 36: ifne 43
      // 39: goto 3d
      // 3c: athrow
      // 3d: bipush 0
      // 3e: goto 42
      // 41: athrow
      // 42: ireturn
      // 43: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 46: iload 3
      // 47: ifne 5e
      // 4a: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 4d: aload 0
      // 4e: goto 52
      // 51: athrow
      // 52: invokevirtual net/minecraft/client/multiplayer/WorldClient.isAirBlock (Lnet/minecraft/util/BlockPos;)Z
      // 55: ifeq 5b
      // 58: bipush 0
      // 59: ireturn
      // 5a: athrow
      // 5b: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 5e: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 61: aload 0
      // 62: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 65: astore 4
      // 67: aload 4
      // 69: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 6e: iload 3
      // 6f: ifne 8a
      // 72: invokevirtual net/minecraft/block/Block.getMaterial ()Lnet/minecraft/block/material/Material;
      // 75: getstatic net/minecraft/block/material/Material.lava Lnet/minecraft/block/material/Material;
      // 78: if_acmpeq 93
      // 7b: goto 7f
      // 7e: athrow
      // 7f: aload 4
      // 81: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 86: goto 8a
      // 89: athrow
      // 8a: invokevirtual net/minecraft/block/Block.getMaterial ()Lnet/minecraft/block/material/Material;
      // 8d: getstatic net/minecraft/block/material/Material.water Lnet/minecraft/block/material/Material;
      // 90: if_acmpne 96
      // 93: bipush 0
      // 94: ireturn
      // 95: athrow
      // 96: aload 0
      // 97: invokestatic x/oc96a009dd05.ƕ (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/util/Vec3;
      // 9a: astore 5
      // 9c: aload 1
      // 9d: aload 5
      // 9f: invokestatic x/oc96a009dd05.Ơ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/Vec3;)Z
      // a2: iload 3
      // a3: ifne c3
      // a6: ifne c2
      // a9: goto ad
      // ac: athrow
      // ad: aload 2
      // ae: aload 5
      // b0: invokestatic x/oc96a009dd05.Ơ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/Vec3;)Z
      // b3: iload 3
      // b4: ifne c3
      // b7: goto bb
      // ba: athrow
      // bb: ifeq c6
      // be: goto c2
      // c1: athrow
      // c2: bipush 1
      // c3: goto c7
      // c6: bipush 0
      // c7: ireturn
   }

   private static boolean Ơ(BlockPos param0, Vec3 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 14
      // 09: ifnonnull 13
      // 0c: goto 10
      // 0f: athrow
      // 10: bipush 0
      // 11: ireturn
      // 12: athrow
      // 13: aload 0
      // 14: invokestatic x/occb1ed1ed8f.ª (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/util/AxisAlignedBB;
      // 17: astore 3
      // 18: aload 3
      // 19: iload 2
      // 1a: ifne 35
      // 1d: ifnonnull 34
      // 20: goto 24
      // 23: athrow
      // 24: new net/minecraft/util/AxisAlignedBB
      // 27: dup
      // 28: aload 0
      // 29: aload 0
      // 2a: bipush 1
      // 2b: bipush 1
      // 2c: bipush 1
      // 2d: invokevirtual net/minecraft/util/BlockPos.add (III)Lnet/minecraft/util/BlockPos;
      // 30: invokespecial net/minecraft/util/AxisAlignedBB.<init> (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/BlockPos;)V
      // 33: astore 3
      // 34: aload 3
      // 35: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 38: aload 1
      // 39: getfield net/minecraft/util/Vec3.xCoord D
      // 3c: dsub
      // 3d: dconst_0
      // 3e: aload 1
      // 3f: getfield net/minecraft/util/Vec3.xCoord D
      // 42: aload 3
      // 43: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 46: dsub
      // 47: invokestatic java/lang/Math.max (DD)D
      // 4a: invokestatic java/lang/Math.max (DD)D
      // 4d: dstore 4
      // 4f: aload 3
      // 50: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 53: aload 1
      // 54: getfield net/minecraft/util/Vec3.yCoord D
      // 57: dsub
      // 58: dconst_0
      // 59: aload 1
      // 5a: getfield net/minecraft/util/Vec3.yCoord D
      // 5d: aload 3
      // 5e: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 61: dsub
      // 62: invokestatic java/lang/Math.max (DD)D
      // 65: invokestatic java/lang/Math.max (DD)D
      // 68: dstore 6
      // 6a: aload 3
      // 6b: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 6e: aload 1
      // 6f: getfield net/minecraft/util/Vec3.zCoord D
      // 72: dsub
      // 73: dconst_0
      // 74: aload 1
      // 75: getfield net/minecraft/util/Vec3.zCoord D
      // 78: aload 3
      // 79: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 7c: dsub
      // 7d: invokestatic java/lang/Math.max (DD)D
      // 80: invokestatic java/lang/Math.max (DD)D
      // 83: dstore 8
      // 85: dload 4
      // 87: dload 4
      // 89: dmul
      // 8a: dload 6
      // 8c: dload 6
      // 8e: dmul
      // 8f: dadd
      // 90: dload 8
      // 92: dload 8
      // 94: dmul
      // 95: dadd
      // 96: ldc2_w 20.25090001
      // 99: dcmpg
      // 9a: iload 2
      // 9b: ifne a6
      // 9e: ifgt a9
      // a1: goto a5
      // a4: athrow
      // a5: bipush 1
      // a6: goto aa
      // a9: bipush 0
      // aa: ireturn
   }

   private static Vec3 ƕ(BlockPos var0) {
      return new Vec3(var0.getX() + 0.5, var0.getY() + 1.0 + 1.62, var0.getZ() + 0.5);
   }

   private static BlockPos p(BlockPos var0, IBlockState var1) {
      EnumPartType var2 = (EnumPartType)var1.getValue(BlockBed.PART);
      EnumFacing var3 = (EnumFacing)var1.getValue(BlockBed.FACING);

      BlockPos var10000;
      try {
         var10000 = var0;
         if (var2 == EnumPartType.HEAD) {
            return var0.offset(var3.getOpposite());
         }
      } catch (ocbde1165e4e var4) {
         throw var4;
      }

      return var10000.offset(var3);
   }

   private static Vec3[] Ӻ(BlockPos param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: aload 0
      // 04: invokestatic x/occb1ed1ed8f.ª (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/util/AxisAlignedBB;
      // 07: astore 2
      // 08: istore 1
      // 09: aload 2
      // 0a: iload 1
      // 0b: ifne 28
      // 0e: ifnonnull 29
      // 11: goto 15
      // 14: athrow
      // 15: new net/minecraft/util/AxisAlignedBB
      // 18: dup
      // 19: aload 0
      // 1a: aload 0
      // 1b: bipush 1
      // 1c: bipush 1
      // 1d: bipush 1
      // 1e: invokevirtual net/minecraft/util/BlockPos.add (III)Lnet/minecraft/util/BlockPos;
      // 21: invokespecial net/minecraft/util/AxisAlignedBB.<init> (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/BlockPos;)V
      // 24: goto 28
      // 27: athrow
      // 28: astore 2
      // 29: ldc2_w 0.1
      // 2c: aload 2
      // 2d: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 30: aload 2
      // 31: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 34: dsub
      // 35: ldc2_w 0.2
      // 38: dmul
      // 39: invokestatic java/lang/Math.min (DD)D
      // 3c: dstore 3
      // 3d: ldc2_w 0.1
      // 40: aload 2
      // 41: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 44: aload 2
      // 45: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 48: dsub
      // 49: ldc2_w 0.2
      // 4c: dmul
      // 4d: invokestatic java/lang/Math.min (DD)D
      // 50: dstore 5
      // 52: ldc2_w 0.1
      // 55: aload 2
      // 56: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 59: aload 2
      // 5a: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 5d: dsub
      // 5e: ldc2_w 0.2
      // 61: dmul
      // 62: invokestatic java/lang/Math.min (DD)D
      // 65: dstore 7
      // 67: aload 2
      // 68: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 6b: aload 2
      // 6c: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 6f: dadd
      // 70: ldc2_w 0.5
      // 73: dmul
      // 74: dstore 9
      // 76: aload 2
      // 77: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 7a: aload 2
      // 7b: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 7e: dadd
      // 7f: ldc2_w 0.5
      // 82: dmul
      // 83: dstore 11
      // 85: aload 2
      // 86: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 89: aload 2
      // 8a: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 8d: dadd
      // 8e: ldc2_w 0.5
      // 91: dmul
      // 92: dstore 13
      // 94: ldc_w 1208685141
      // 97: ldc_w 1208685142
      // 9a: ixor
      // 9b: anewarray 104
      // 9e: dup
      // 9f: bipush 0
      // a0: new net/minecraft/util/Vec3
      // a3: dup
      // a4: dload 9
      // a6: dload 11
      // a8: dload 13
      // aa: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // ad: aastore
      // ae: dup
      // af: bipush 1
      // b0: new net/minecraft/util/Vec3
      // b3: dup
      // b4: dload 9
      // b6: aload 2
      // b7: getfield net/minecraft/util/AxisAlignedBB.minY D
      // ba: dload 5
      // bc: dadd
      // bd: dload 13
      // bf: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // c2: aastore
      // c3: dup
      // c4: ldc_w 1208685140
      // c7: ldc_w 1208685142
      // ca: ixor
      // cb: new net/minecraft/util/Vec3
      // ce: dup
      // cf: dload 9
      // d1: aload 2
      // d2: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // d5: dload 5
      // d7: dsub
      // d8: dload 13
      // da: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // dd: aastore
      // de: areturn
   }

   private static List<BlockPos> ė(Vec3 param0, Vec3 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: new java/util/ArrayList
      // 003: dup
      // 004: invokespecial java/util/ArrayList.<init> ()V
      // 007: astore 3
      // 008: aload 0
      // 009: getfield net/minecraft/util/Vec3.xCoord D
      // 00c: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 00f: istore 4
      // 011: aload 0
      // 012: getfield net/minecraft/util/Vec3.yCoord D
      // 015: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 018: istore 5
      // 01a: aload 0
      // 01b: getfield net/minecraft/util/Vec3.zCoord D
      // 01e: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 021: istore 6
      // 023: getstatic x/oc75d51ec7eb.ϩ I
      // 026: aload 1
      // 027: getfield net/minecraft/util/Vec3.xCoord D
      // 02a: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 02d: istore 7
      // 02f: aload 1
      // 030: getfield net/minecraft/util/Vec3.yCoord D
      // 033: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 036: istore 8
      // 038: aload 1
      // 039: getfield net/minecraft/util/Vec3.zCoord D
      // 03c: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 03f: istore 9
      // 041: aload 1
      // 042: getfield net/minecraft/util/Vec3.xCoord D
      // 045: aload 0
      // 046: getfield net/minecraft/util/Vec3.xCoord D
      // 049: dsub
      // 04a: dstore 10
      // 04c: aload 1
      // 04d: getfield net/minecraft/util/Vec3.yCoord D
      // 050: aload 0
      // 051: getfield net/minecraft/util/Vec3.yCoord D
      // 054: dsub
      // 055: dstore 12
      // 057: istore 2
      // 058: aload 1
      // 059: getfield net/minecraft/util/Vec3.zCoord D
      // 05c: aload 0
      // 05d: getfield net/minecraft/util/Vec3.zCoord D
      // 060: dsub
      // 061: dstore 14
      // 063: iload 7
      // 065: iload 4
      // 067: invokestatic java/lang/Integer.compare (II)I
      // 06a: istore 16
      // 06c: iload 8
      // 06e: iload 5
      // 070: invokestatic java/lang/Integer.compare (II)I
      // 073: istore 17
      // 075: iload 9
      // 077: iload 6
      // 079: invokestatic java/lang/Integer.compare (II)I
      // 07c: istore 18
      // 07e: iload 16
      // 080: ifne 08a
      // 083: ldc2_w 1.7976931348623157E308
      // 086: goto 091
      // 089: athrow
      // 08a: dconst_1
      // 08b: dload 10
      // 08d: invokestatic java/lang/Math.abs (D)D
      // 090: ddiv
      // 091: dstore 19
      // 093: iload 17
      // 095: ifne 09f
      // 098: ldc2_w 1.7976931348623157E308
      // 09b: goto 0a6
      // 09e: athrow
      // 09f: dconst_1
      // 0a0: dload 12
      // 0a2: invokestatic java/lang/Math.abs (D)D
      // 0a5: ddiv
      // 0a6: dstore 21
      // 0a8: iload 18
      // 0aa: ifne 0b4
      // 0ad: ldc2_w 1.7976931348623157E308
      // 0b0: goto 0bb
      // 0b3: athrow
      // 0b4: dconst_1
      // 0b5: dload 14
      // 0b7: invokestatic java/lang/Math.abs (D)D
      // 0ba: ddiv
      // 0bb: dstore 23
      // 0bd: iload 16
      // 0bf: iload 2
      // 0c0: ifne 0d3
      // 0c3: ifne 0d1
      // 0c6: goto 0ca
      // 0c9: athrow
      // 0ca: ldc2_w 1.7976931348623157E308
      // 0cd: goto 0f9
      // 0d0: athrow
      // 0d1: iload 16
      // 0d3: iload 2
      // 0d4: ifne 0e0
      // 0d7: ifle 0eb
      // 0da: goto 0de
      // 0dd: athrow
      // 0de: iload 4
      // 0e0: i2d
      // 0e1: dconst_1
      // 0e2: dadd
      // 0e3: aload 0
      // 0e4: getfield net/minecraft/util/Vec3.xCoord D
      // 0e7: dsub
      // 0e8: goto 0f3
      // 0eb: aload 0
      // 0ec: getfield net/minecraft/util/Vec3.xCoord D
      // 0ef: iload 4
      // 0f1: i2d
      // 0f2: dsub
      // 0f3: dload 10
      // 0f5: invokestatic java/lang/Math.abs (D)D
      // 0f8: ddiv
      // 0f9: dstore 25
      // 0fb: iload 17
      // 0fd: iload 2
      // 0fe: ifne 111
      // 101: ifne 10f
      // 104: goto 108
      // 107: athrow
      // 108: ldc2_w 1.7976931348623157E308
      // 10b: goto 137
      // 10e: athrow
      // 10f: iload 17
      // 111: iload 2
      // 112: ifne 11e
      // 115: ifle 129
      // 118: goto 11c
      // 11b: athrow
      // 11c: iload 5
      // 11e: i2d
      // 11f: dconst_1
      // 120: dadd
      // 121: aload 0
      // 122: getfield net/minecraft/util/Vec3.yCoord D
      // 125: dsub
      // 126: goto 131
      // 129: aload 0
      // 12a: getfield net/minecraft/util/Vec3.yCoord D
      // 12d: iload 5
      // 12f: i2d
      // 130: dsub
      // 131: dload 12
      // 133: invokestatic java/lang/Math.abs (D)D
      // 136: ddiv
      // 137: dstore 27
      // 139: iload 18
      // 13b: iload 2
      // 13c: ifne 14f
      // 13f: ifne 14d
      // 142: goto 146
      // 145: athrow
      // 146: ldc2_w 1.7976931348623157E308
      // 149: goto 175
      // 14c: athrow
      // 14d: iload 18
      // 14f: iload 2
      // 150: ifne 15c
      // 153: ifle 167
      // 156: goto 15a
      // 159: athrow
      // 15a: iload 6
      // 15c: i2d
      // 15d: dconst_1
      // 15e: dadd
      // 15f: aload 0
      // 160: getfield net/minecraft/util/Vec3.zCoord D
      // 163: dsub
      // 164: goto 16f
      // 167: aload 0
      // 168: getfield net/minecraft/util/Vec3.zCoord D
      // 16b: iload 6
      // 16d: i2d
      // 16e: dsub
      // 16f: dload 14
      // 171: invokestatic java/lang/Math.abs (D)D
      // 174: ddiv
      // 175: dstore 29
      // 177: aload 3
      // 178: new net/minecraft/util/BlockPos
      // 17b: dup
      // 17c: iload 4
      // 17e: iload 5
      // 180: iload 6
      // 182: invokespecial net/minecraft/util/BlockPos.<init> (III)V
      // 185: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 18a: pop
      // 18b: iload 4
      // 18d: iload 7
      // 18f: if_icmpne 1bc
      // 192: iload 5
      // 194: iload 2
      // 195: ifne 1ce
      // 198: iload 2
      // 199: ifne 1ce
      // 19c: goto 1a0
      // 19f: athrow
      // 1a0: iload 8
      // 1a2: if_icmpne 1bc
      // 1a5: goto 1a9
      // 1a8: athrow
      // 1a9: iload 6
      // 1ab: iload 2
      // 1ac: ifne 1ce
      // 1af: goto 1b3
      // 1b2: athrow
      // 1b3: iload 9
      // 1b5: if_icmpeq 25a
      // 1b8: goto 1bc
      // 1bb: athrow
      // 1bc: aload 3
      // 1bd: iload 2
      // 1be: ifne 25b
      // 1c1: goto 1c5
      // 1c4: athrow
      // 1c5: invokeinterface java/util/List.size ()I 1
      // 1ca: goto 1ce
      // 1cd: athrow
      // 1ce: ldc_w -1763717474
      // 1d1: ldc_w -1763717410
      // 1d4: ixor
      // 1d5: if_icmpge 25a
      // 1d8: dload 25
      // 1da: iload 2
      // 1db: ifne 214
      // 1de: goto 1e2
      // 1e1: athrow
      // 1e2: dload 27
      // 1e4: dcmpg
      // 1e5: ifgt 212
      // 1e8: goto 1ec
      // 1eb: athrow
      // 1ec: dload 25
      // 1ee: iload 2
      // 1ef: ifne 214
      // 1f2: goto 1f6
      // 1f5: athrow
      // 1f6: dload 29
      // 1f8: dcmpg
      // 1f9: ifgt 212
      // 1fc: goto 200
      // 1ff: athrow
      // 200: iload 4
      // 202: iload 16
      // 204: iadd
      // 205: istore 4
      // 207: iload 2
      // 208: dload 25
      // 20a: dload 19
      // 20c: dadd
      // 20d: dstore 25
      // 20f: ifeq 242
      // 212: dload 27
      // 214: iload 2
      // 215: ifne 240
      // 218: dload 29
      // 21a: dcmpg
      // 21b: ifgt 234
      // 21e: goto 222
      // 221: athrow
      // 222: iload 5
      // 224: iload 17
      // 226: iadd
      // 227: istore 5
      // 229: iload 2
      // 22a: dload 27
      // 22c: dload 21
      // 22e: dadd
      // 22f: dstore 27
      // 231: ifeq 242
      // 234: iload 6
      // 236: iload 18
      // 238: iadd
      // 239: istore 6
      // 23b: dload 29
      // 23d: dload 23
      // 23f: dadd
      // 240: dstore 29
      // 242: aload 3
      // 243: new net/minecraft/util/BlockPos
      // 246: dup
      // 247: iload 4
      // 249: iload 5
      // 24b: iload 6
      // 24d: invokespecial net/minecraft/util/BlockPos.<init> (III)V
      // 250: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 255: pop
      // 256: iload 2
      // 257: ifeq 18b
      // 25a: aload 3
      // 25b: areturn
   }
}

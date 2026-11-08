package x;

import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockCarpet;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.BlockLadder;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockSkull;
import net.minecraft.block.BlockSnow;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.network.Packet;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;

public class oc3b42959d05 {
   static final float η = 180.0F;
   static final float Ӫ = 120.0F;
   static final float Ļ = 40.0F;
   static final float է = 180.0F;
   static final float θ = 90.0F;
   private static final float Ʃ = 1.0E-4F;
   private static final float Ύ = 0.15F;
   private static final long Ɲ = 16777216L;
   private static final long ƨ = 131072L;
   private static final int Ѯ = -1;
   private static final long Ә = -1L;
   private static final int Ϙ = 64;
   private static final float ļ = 3.6F;
   private static final int V = 8;
   private static final double è = 1.2;
   private static final EnumFacing[] Γ;
   private static final double[] ͽ;
   private final oc668fce0dbf Ы;
   private final Minecraft ʝ = Minecraft.getMinecraft();
   private int ե;
   private int ó;
   private float Ƭ;
   private float М;
   private float ʕ = 180.0F;
   private BlockPos ʸ;
   private EnumFacing ý;
   private boolean Ɏ;
   private boolean β;
   private float ß;
   private float ѷ;
   private boolean Җ;
   private float Ư;
   private int ѳ = -1;
   private long ž = -3053929299089541664L ^ 3053929299089541663L;
   private boolean Ԑ;
   private boolean љ;
   private boolean Ȝ;
   private int ʧ;
   private int u = 1;

   oc3b42959d05(oc668fce0dbf var1) {
      this.Ы = var1;
   }

   void ą() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: aload 0
      // 04: getfield x/oc3b42959d05.Ы Lx/oc668fce0dbf;
      // 07: invokevirtual x/oc668fce0dbf.ն ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0a: astore 2
      // 0b: istore 1
      // 0c: aload 0
      // 0d: aload 2
      // 0e: iload 1
      // 0f: ifne 1f
      // 12: ifnonnull 1e
      // 15: goto 19
      // 18: athrow
      // 19: bipush 0
      // 1a: goto 27
      // 1d: athrow
      // 1e: aload 2
      // 1f: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // 22: dconst_1
      // 23: dsub
      // 24: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 27: putfield x/oc3b42959d05.ե I
      // 2a: aload 0
      // 2b: bipush 0
      // 2c: putfield x/oc3b42959d05.ó I
      // 2f: aload 0
      // 30: ldc 180.0
      // 32: putfield x/oc3b42959d05.ʕ F
      // 35: aload 0
      // 36: aconst_null
      // 37: putfield x/oc3b42959d05.ʸ Lnet/minecraft/util/BlockPos;
      // 3a: aload 0
      // 3b: aconst_null
      // 3c: putfield x/oc3b42959d05.ý Lnet/minecraft/util/EnumFacing;
      // 3f: aload 0
      // 40: bipush 0
      // 41: putfield x/oc3b42959d05.Ɏ Z
      // 44: aload 0
      // 45: bipush 0
      // 46: putfield x/oc3b42959d05.β Z
      // 49: aload 0
      // 4a: bipush 0
      // 4b: iload 1
      // 4c: ifne 7d
      // 4f: putfield x/oc3b42959d05.Җ Z
      // 52: aload 0
      // 53: fconst_0
      // 54: putfield x/oc3b42959d05.Ư F
      // 57: aload 0
      // 58: bipush -1
      // 59: putfield x/oc3b42959d05.ѳ I
      // 5c: aload 0
      // 5d: ldc2_w 7108882505929102873
      // 60: ldc2_w -7108882505929102874
      // 63: lxor
      // 64: putfield x/oc3b42959d05.ž J
      // 67: aload 0
      // 68: bipush 0
      // 69: putfield x/oc3b42959d05.Ԑ Z
      // 6c: aload 0
      // 6d: aload 2
      // 6e: ifnull 8c
      // 71: goto 75
      // 74: athrow
      // 75: aload 2
      // 76: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 79: goto 7d
      // 7c: athrow
      // 7d: iload 1
      // 7e: ifne 89
      // 81: ifne 8c
      // 84: goto 88
      // 87: athrow
      // 88: bipush 1
      // 89: goto 8d
      // 8c: bipush 0
      // 8d: putfield x/oc3b42959d05.љ Z
      // 90: aload 0
      // 91: bipush 0
      // 92: putfield x/oc3b42959d05.Ȝ Z
      // 95: aload 0
      // 96: bipush 0
      // 97: putfield x/oc3b42959d05.ʧ I
      // 9a: aload 0
      // 9b: bipush 1
      // 9c: putfield x/oc3b42959d05.u I
      // 9f: aload 0
      // a0: getfield x/oc3b42959d05.Ы Lx/oc668fce0dbf;
      // a3: bipush 0
      // a4: invokevirtual x/oc668fce0dbf.Σ (Z)V
      // a7: return
   }

   oc47c2cd4bd2 Ə(float param1, float param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: aload 0
      // 001: bipush 0
      // 002: putfield x/oc3b42959d05.Ɏ Z
      // 005: getstatic x/oc84f20a0bc5.ė I
      // 008: aload 0
      // 009: getfield x/oc3b42959d05.Ы Lx/oc668fce0dbf;
      // 00c: invokevirtual x/oc668fce0dbf.ն ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 00f: astore 4
      // 011: istore 3
      // 012: aload 0
      // 013: iload 3
      // 014: ifne 02b
      // 017: aload 4
      // 019: invokevirtual x/oc3b42959d05.ϳ (Lnet/minecraft/client/entity/EntityPlayerSP;)Z
      // 01c: ifne 02a
      // 01f: goto 023
      // 022: athrow
      // 023: aload 0
      // 024: invokevirtual x/oc3b42959d05.ŗ ()V
      // 027: aconst_null
      // 028: areturn
      // 029: athrow
      // 02a: aload 0
      // 02b: iload 3
      // 02c: ifne 044
      // 02f: getfield x/oc3b42959d05.Ы Lx/oc668fce0dbf;
      // 032: invokevirtual x/oc668fce0dbf.Р ()Z
      // 035: ifne 043
      // 038: goto 03c
      // 03b: athrow
      // 03c: aload 0
      // 03d: invokevirtual x/oc3b42959d05.ŗ ()V
      // 040: aconst_null
      // 041: areturn
      // 042: athrow
      // 043: aload 0
      // 044: iload 3
      // 045: ifne 06f
      // 048: getfield x/oc3b42959d05.Җ Z
      // 04b: ifne 060
      // 04e: goto 052
      // 051: athrow
      // 052: aload 0
      // 053: fload 2
      // 054: putfield x/oc3b42959d05.Ư F
      // 057: aload 0
      // 058: bipush 1
      // 059: putfield x/oc3b42959d05.Җ Z
      // 05c: goto 060
      // 05f: athrow
      // 060: aload 0
      // 061: aload 4
      // 063: getfield net/minecraft/client/entity/EntityPlayerSP.posX D
      // 066: aload 4
      // 068: getfield net/minecraft/client/entity/EntityPlayerSP.posZ D
      // 06b: invokevirtual x/oc3b42959d05.ʴ (DD)V
      // 06e: aload 0
      // 06f: invokevirtual x/oc3b42959d05.ʥ ()Z
      // 072: istore 5
      // 074: aload 4
      // 076: iload 3
      // 077: ifne 0ab
      // 07a: getfield net/minecraft/client/entity/EntityPlayerSP.hurtTime I
      // 07d: ifne 0a9
      // 080: goto 084
      // 083: athrow
      // 084: aload 4
      // 086: iload 3
      // 087: ifne 0ab
      // 08a: goto 08e
      // 08d: athrow
      // 08e: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 091: ifeq 0a9
      // 094: goto 098
      // 097: athrow
      // 098: aload 0
      // 099: aload 0
      // 09a: aload 4
      // 09c: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 09f: invokevirtual x/oc3b42959d05.Ö (F)F
      // 0a2: putfield x/oc3b42959d05.Ƭ F
      // 0a5: goto 0a9
      // 0a8: athrow
      // 0a9: aload 4
      // 0ab: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 0ae: iload 3
      // 0af: ifne 0bb
      // 0b2: ifeq 0ea
      // 0b5: goto 0b9
      // 0b8: athrow
      // 0b9: iload 5
      // 0bb: ifeq 0ea
      // 0be: aload 0
      // 0bf: aload 0
      // 0c0: aload 4
      // 0c2: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 0c5: invokevirtual x/oc3b42959d05.Ö (F)F
      // 0c8: putfield x/oc3b42959d05.Ƭ F
      // 0cb: iload 3
      // 0cc: aload 0
      // 0cd: getfield x/oc3b42959d05.Ƭ F
      // 0d0: fstore 6
      // 0d2: aload 0
      // 0d3: getfield x/oc3b42959d05.М F
      // 0d6: fstore 7
      // 0d8: aload 0
      // 0d9: ldc 180.0
      // 0db: putfield x/oc3b42959d05.ʕ F
      // 0de: ldc 180.0
      // 0e0: fstore 8
      // 0e2: aload 0
      // 0e3: bipush 0
      // 0e4: putfield x/oc3b42959d05.ó I
      // 0e7: ifeq 1bc
      // 0ea: aload 0
      // 0eb: iload 3
      // 0ec: ifne 102
      // 0ef: goto 0f3
      // 0f2: athrow
      // 0f3: getfield x/oc3b42959d05.ʸ Lnet/minecraft/util/BlockPos;
      // 0f6: ifnull 138
      // 0f9: goto 0fd
      // 0fc: athrow
      // 0fd: aload 0
      // 0fe: goto 102
      // 101: athrow
      // 102: iload 3
      // 103: ifne 115
      // 106: getfield x/oc3b42959d05.ý Lnet/minecraft/util/EnumFacing;
      // 109: ifnull 138
      // 10c: goto 110
      // 10f: athrow
      // 110: aload 0
      // 111: goto 115
      // 114: athrow
      // 115: aload 4
      // 117: aload 0
      // 118: getfield x/oc3b42959d05.ʸ Lnet/minecraft/util/BlockPos;
      // 11b: aload 0
      // 11c: getfield x/oc3b42959d05.ý Lnet/minecraft/util/EnumFacing;
      // 11f: invokevirtual x/oc3b42959d05.Ԑ (Lnet/minecraft/client/entity/EntityPlayerSP;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;)[F
      // 122: astore 9
      // 124: iload 3
      // 125: aload 0
      // 126: aload 9
      // 128: bipush 0
      // 129: faload
      // 12a: putfield x/oc3b42959d05.Ƭ F
      // 12d: aload 0
      // 12e: aload 9
      // 130: bipush 1
      // 131: faload
      // 132: putfield x/oc3b42959d05.М F
      // 135: ifeq 170
      // 138: iload 5
      // 13a: iload 3
      // 13b: ifne 152
      // 13e: goto 142
      // 141: athrow
      // 142: ifeq 170
      // 145: goto 149
      // 148: athrow
      // 149: aload 4
      // 14b: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 14e: goto 152
      // 151: athrow
      // 152: ifne 170
      // 155: aload 0
      // 156: aload 0
      // 157: aload 4
      // 159: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 15c: invokevirtual x/oc3b42959d05.Ö (F)F
      // 15f: aload 0
      // 160: getfield x/oc3b42959d05.Ы Lx/oc668fce0dbf;
      // 163: invokevirtual x/oc668fce0dbf.ʓ ()F
      // 166: invokestatic x/oc3b42959d05.Ҧ (FF)F
      // 169: putfield x/oc3b42959d05.Ƭ F
      // 16c: goto 170
      // 16f: athrow
      // 170: aload 0
      // 171: getfield x/oc3b42959d05.Ƭ F
      // 174: fstore 6
      // 176: iload 3
      // 177: aload 0
      // 178: getfield x/oc3b42959d05.М F
      // 17b: fstore 7
      // 17d: ifne 1ae
      // 180: aload 4
      // 182: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 185: ifeq 19f
      // 188: goto 18c
      // 18b: athrow
      // 18c: aload 0
      // 18d: ldc 180.0
      // 18f: putfield x/oc3b42959d05.ʕ F
      // 192: iload 3
      // 193: aload 0
      // 194: bipush 0
      // 195: putfield x/oc3b42959d05.ó I
      // 198: ifeq 1b8
      // 19b: goto 19f
      // 19e: athrow
      // 19f: aload 0
      // 1a0: aload 0
      // 1a1: getfield x/oc3b42959d05.ó I
      // 1a4: invokestatic x/oc3b42959d05.Ѐ (I)F
      // 1a7: putfield x/oc3b42959d05.ʕ F
      // 1aa: goto 1ae
      // 1ad: athrow
      // 1ae: aload 0
      // 1af: dup
      // 1b0: getfield x/oc3b42959d05.ó I
      // 1b3: bipush 1
      // 1b4: iadd
      // 1b5: putfield x/oc3b42959d05.ó I
      // 1b8: ldc 90.0
      // 1ba: fstore 8
      // 1bc: aload 0
      // 1bd: invokevirtual x/oc3b42959d05.Ћ ()F
      // 1c0: fstore 9
      // 1c2: aload 0
      // 1c3: fload 1
      // 1c4: fload 2
      // 1c5: fload 6
      // 1c7: fload 7
      // 1c9: aload 0
      // 1ca: getfield x/oc3b42959d05.ʕ F
      // 1cd: fload 8
      // 1cf: fload 9
      // 1d1: invokevirtual x/oc3b42959d05.Í (FFFFFFF)Lx/oc47c2cd4bd2;
      // 1d4: astore 10
      // 1d6: new x/oc47c2cd4bd2
      // 1d9: dup
      // 1da: aload 10
      // 1dc: getfield x/oc47c2cd4bd2.ϳ F
      // 1df: aload 0
      // 1e0: getfield x/oc3b42959d05.Ы Lx/oc668fce0dbf;
      // 1e3: aload 10
      // 1e5: getfield x/oc47c2cd4bd2.Μ F
      // 1e8: fload 2
      // 1e9: fload 9
      // 1eb: invokevirtual x/oc668fce0dbf.б (FFF)F
      // 1ee: invokespecial x/oc47c2cd4bd2.<init> (FF)V
      // 1f1: astore 10
      // 1f3: aload 0
      // 1f4: fload 2
      // 1f5: aload 10
      // 1f7: fload 9
      // 1f9: invokevirtual x/oc3b42959d05.ә (FLx/oc47c2cd4bd2;F)Lx/oc47c2cd4bd2;
      // 1fc: astore 10
      // 1fe: aload 0
      // 1ff: fload 2
      // 200: aload 10
      // 202: fload 9
      // 204: invokevirtual x/oc3b42959d05.γ (FLx/oc47c2cd4bd2;F)Lx/oc47c2cd4bd2;
      // 207: astore 10
      // 209: aload 0
      // 20a: aload 10
      // 20c: getfield x/oc47c2cd4bd2.ϳ F
      // 20f: putfield x/oc3b42959d05.ß F
      // 212: aload 0
      // 213: aload 10
      // 215: getfield x/oc47c2cd4bd2.Μ F
      // 218: putfield x/oc3b42959d05.ѷ F
      // 21b: aload 0
      // 21c: bipush 1
      // 21d: putfield x/oc3b42959d05.β Z
      // 220: aload 10
      // 222: areturn
   }

   void М(boolean var1) {
      this.Ɏ = var1;
   }

   void ɶ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: aload 0
      // 04: getfield x/oc3b42959d05.Ы Lx/oc668fce0dbf;
      // 07: invokevirtual x/oc668fce0dbf.ն ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0a: astore 2
      // 0b: istore 1
      // 0c: aload 0
      // 0d: iload 1
      // 0e: ifne 21
      // 11: aload 2
      // 12: invokevirtual x/oc3b42959d05.ϳ (Lnet/minecraft/client/entity/EntityPlayerSP;)Z
      // 15: ifeq 5b
      // 18: goto 1c
      // 1b: athrow
      // 1c: aload 0
      // 1d: goto 21
      // 20: athrow
      // 21: getfield x/oc3b42959d05.Ɏ Z
      // 24: iload 1
      // 25: ifne 3d
      // 28: ifeq 5b
      // 2b: goto 2f
      // 2e: athrow
      // 2f: invokestatic x/ocbb165642ef.ʨ ()Lx/ocbb165642ef;
      // 32: aload 0
      // 33: getfield x/oc3b42959d05.Ы Lx/oc668fce0dbf;
      // 36: invokevirtual x/ocbb165642ef.D (Ljava/lang/Object;)Z
      // 39: goto 3d
      // 3c: athrow
      // 3d: iload 1
      // 3e: ifne 58
      // 41: ifeq 5b
      // 44: goto 48
      // 47: athrow
      // 48: aload 0
      // 49: iload 1
      // 4a: ifne 5d
      // 4d: goto 51
      // 50: athrow
      // 51: invokevirtual x/oc3b42959d05.ě ()Z
      // 54: goto 58
      // 57: athrow
      // 58: ifne 5c
      // 5b: return
      // 5c: aload 0
      // 5d: iload 1
      // 5e: ifne 79
      // 61: getfield x/oc3b42959d05.Ы Lx/oc668fce0dbf;
      // 64: invokevirtual x/oc668fce0dbf.θ ()Z
      // 67: ifne 70
      // 6a: goto 6e
      // 6d: athrow
      // 6e: return
      // 6f: athrow
      // 70: aload 0
      // 71: getfield x/oc3b42959d05.ʝ Lnet/minecraft/client/Minecraft;
      // 74: bipush 0
      // 75: invokevirtual net/minecraft/client/Minecraft.setRightClickDelayTimer (I)V
      // 78: aload 0
      // 79: getfield x/oc3b42959d05.ʝ Lnet/minecraft/client/Minecraft;
      // 7c: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 7f: astore 3
      // 80: aload 0
      // 81: iload 1
      // 82: ifne 93
      // 85: aload 3
      // 86: invokevirtual x/oc3b42959d05.ƒ (Lnet/minecraft/util/MovingObjectPosition;)Z
      // 89: ifne 92
      // 8c: goto 90
      // 8f: athrow
      // 90: return
      // 91: athrow
      // 92: aload 0
      // 93: getfield x/oc3b42959d05.Ы Lx/oc668fce0dbf;
      // 96: aload 0
      // 97: getfield x/oc3b42959d05.ʸ Lnet/minecraft/util/BlockPos;
      // 9a: aload 0
      // 9b: getfield x/oc3b42959d05.ý Lnet/minecraft/util/EnumFacing;
      // 9e: aload 3
      // 9f: invokevirtual x/oc668fce0dbf.ӥ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;Lnet/minecraft/util/MovingObjectPosition;)Z
      // a2: pop
      // a3: return
   }

   void ә(oc70db705765 var1, boolean var2, boolean var3) {
      this.Ϭ(var1, var2, var3, 1);
   }

   void Ϭ(oc70db705765 param1, boolean param2, boolean param3, int param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: aload 0
      // 004: getfield x/oc3b42959d05.Ы Lx/oc668fce0dbf;
      // 007: invokevirtual x/oc668fce0dbf.ն ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 00a: astore 6
      // 00c: istore 5
      // 00e: aload 1
      // 00f: ifnull 028
      // 012: aload 0
      // 013: aload 6
      // 015: invokevirtual x/oc3b42959d05.ϳ (Lnet/minecraft/client/entity/EntityPlayerSP;)Z
      // 018: iload 5
      // 01a: ifne 02e
      // 01d: goto 021
      // 020: athrow
      // 021: ifne 029
      // 024: goto 028
      // 027: athrow
      // 028: return
      // 029: iload 4
      // 02b: invokestatic x/oc3b42959d05.ȴ (I)I
      // 02e: istore 7
      // 030: aload 0
      // 031: getfield x/oc3b42959d05.u I
      // 034: iload 5
      // 036: ifne 057
      // 039: iload 7
      // 03b: if_icmpeq 056
      // 03e: goto 042
      // 041: athrow
      // 042: aload 0
      // 043: iload 7
      // 045: putfield x/oc3b42959d05.u I
      // 048: aload 0
      // 049: bipush 0
      // 04a: putfield x/oc3b42959d05.ʧ I
      // 04d: aload 0
      // 04e: bipush 0
      // 04f: putfield x/oc3b42959d05.Ȝ Z
      // 052: goto 056
      // 055: athrow
      // 056: iload 3
      // 057: iload 5
      // 059: ifne 095
      // 05c: ifne 090
      // 05f: goto 063
      // 062: athrow
      // 063: aload 0
      // 064: aload 6
      // 066: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 069: iload 5
      // 06b: ifne 07a
      // 06e: goto 072
      // 071: athrow
      // 072: ifne 07d
      // 075: goto 079
      // 078: athrow
      // 079: bipush 1
      // 07a: goto 07e
      // 07d: bipush 0
      // 07e: putfield x/oc3b42959d05.љ Z
      // 081: aload 0
      // 082: bipush 0
      // 083: putfield x/oc3b42959d05.Ȝ Z
      // 086: aload 0
      // 087: bipush 0
      // 088: putfield x/oc3b42959d05.ʧ I
      // 08b: aload 0
      // 08c: bipush 0
      // 08d: putfield x/oc3b42959d05.Ԑ Z
      // 090: aload 6
      // 092: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 095: iload 5
      // 097: ifne 0be
      // 09a: ifeq 0b9
      // 09d: goto 0a1
      // 0a0: athrow
      // 0a1: aload 0
      // 0a2: bipush 0
      // 0a3: putfield x/oc3b42959d05.Ԑ Z
      // 0a6: iload 5
      // 0a8: aload 0
      // 0a9: bipush 0
      // 0aa: putfield x/oc3b42959d05.љ Z
      // 0ad: aload 0
      // 0ae: bipush 0
      // 0af: putfield x/oc3b42959d05.Ȝ Z
      // 0b2: ifeq 19d
      // 0b5: goto 0b9
      // 0b8: athrow
      // 0b9: iload 3
      // 0ba: goto 0be
      // 0bd: athrow
      // 0be: iload 5
      // 0c0: ifne 1b6
      // 0c3: ifeq 19d
      // 0c6: goto 0ca
      // 0c9: athrow
      // 0ca: aload 0
      // 0cb: iload 5
      // 0cd: ifne 11f
      // 0d0: goto 0d4
      // 0d3: athrow
      // 0d4: getfield x/oc3b42959d05.љ Z
      // 0d7: ifne 11e
      // 0da: goto 0de
      // 0dd: athrow
      // 0de: aload 0
      // 0df: iload 5
      // 0e1: ifne 106
      // 0e4: goto 0e8
      // 0e7: athrow
      // 0e8: bipush 1
      // 0e9: putfield x/oc3b42959d05.љ Z
      // 0ec: aload 0
      // 0ed: getfield x/oc3b42959d05.ʧ I
      // 0f0: ifle 105
      // 0f3: goto 0f7
      // 0f6: athrow
      // 0f7: aload 0
      // 0f8: dup
      // 0f9: getfield x/oc3b42959d05.ʧ I
      // 0fc: bipush 1
      // 0fd: isub
      // 0fe: putfield x/oc3b42959d05.ʧ I
      // 101: goto 105
      // 104: athrow
      // 105: aload 0
      // 106: aload 0
      // 107: getfield x/oc3b42959d05.ʧ I
      // 10a: iload 5
      // 10c: ifne 117
      // 10f: ifne 11a
      // 112: goto 116
      // 115: athrow
      // 116: bipush 1
      // 117: goto 11b
      // 11a: bipush 0
      // 11b: putfield x/oc3b42959d05.Ȝ Z
      // 11e: aload 0
      // 11f: getfield x/oc3b42959d05.Ы Lx/oc668fce0dbf;
      // 122: invokevirtual x/oc668fce0dbf.ȉ ()Z
      // 125: iload 5
      // 127: ifne 1b6
      // 12a: ifne 19d
      // 12d: goto 131
      // 130: athrow
      // 131: aload 6
      // 133: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 136: aload 0
      // 137: getfield x/oc3b42959d05.ó I
      // 13a: iload 5
      // 13c: ifne 1a6
      // 13f: goto 143
      // 142: athrow
      // 143: aload 6
      // 145: getfield net/minecraft/client/entity/EntityPlayerSP.motionY D
      // 148: aload 0
      // 149: getfield x/oc3b42959d05.Ԑ Z
      // 14c: aload 0
      // 14d: getfield x/oc3b42959d05.Ȝ Z
      // 150: invokestatic x/oc3b42959d05.ϋ (ZIDZZ)Z
      // 153: ifeq 19d
      // 156: goto 15a
      // 159: athrow
      // 15a: aload 1
      // 15b: invokevirtual x/oc70db705765.ҧ ()Z
      // 15e: iload 5
      // 160: ifne 17d
      // 163: goto 167
      // 166: athrow
      // 167: ifne 189
      // 16a: goto 16e
      // 16d: athrow
      // 16e: aload 0
      // 16f: getfield x/oc3b42959d05.Ы Lx/oc668fce0dbf;
      // 172: aload 1
      // 173: ldc_w "Telly2/Mid cycle"
      // 176: invokevirtual x/oc668fce0dbf.Λ (Lx/oc70db705765;Ljava/lang/String;)Z
      // 179: goto 17d
      // 17c: athrow
      // 17d: iload 5
      // 17f: ifne 1b6
      // 182: ifeq 19d
      // 185: goto 189
      // 188: athrow
      // 189: aload 0
      // 18a: bipush 1
      // 18b: putfield x/oc3b42959d05.Ԑ Z
      // 18e: aload 0
      // 18f: bipush 0
      // 190: putfield x/oc3b42959d05.Ȝ Z
      // 193: aload 0
      // 194: iload 7
      // 196: putfield x/oc3b42959d05.ʧ I
      // 199: goto 19d
      // 19c: athrow
      // 19d: aload 6
      // 19f: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 1a2: aload 0
      // 1a3: invokevirtual x/oc3b42959d05.ʥ ()Z
      // 1a6: iload 5
      // 1a8: ifne 1c8
      // 1ab: aload 0
      // 1ac: invokevirtual x/oc3b42959d05.Ԓ ()Z
      // 1af: invokestatic x/oc3b42959d05.ǚ (ZZZ)Z
      // 1b2: goto 1b6
      // 1b5: athrow
      // 1b6: ifeq 1c2
      // 1b9: aload 1
      // 1ba: bipush 1
      // 1bb: invokevirtual x/oc70db705765.Ƀ (Z)V
      // 1be: goto 1c2
      // 1c1: athrow
      // 1c2: iload 2
      // 1c3: aload 6
      // 1c5: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 1c8: aload 1
      // 1c9: invokevirtual x/oc70db705765.ϧ ()Z
      // 1cc: iload 5
      // 1ce: ifne 1ed
      // 1d1: ifne 1ec
      // 1d4: goto 1d8
      // 1d7: athrow
      // 1d8: aload 0
      // 1d9: invokevirtual x/oc3b42959d05.Ԓ ()Z
      // 1dc: iload 5
      // 1de: ifne 1ed
      // 1e1: goto 1e5
      // 1e4: athrow
      // 1e5: ifeq 1f0
      // 1e8: goto 1ec
      // 1eb: athrow
      // 1ec: bipush 1
      // 1ed: goto 1f1
      // 1f0: bipush 0
      // 1f1: aload 0
      // 1f2: getfield x/oc3b42959d05.ʝ Lnet/minecraft/client/Minecraft;
      // 1f5: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 1f8: aload 6
      // 1fa: aload 6
      // 1fc: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 1ff: aload 6
      // 201: getfield net/minecraft/client/entity/EntityPlayerSP.motionX D
      // 204: aload 6
      // 206: getfield net/minecraft/client/entity/EntityPlayerSP.motionY D
      // 209: aload 6
      // 20b: getfield net/minecraft/client/entity/EntityPlayerSP.motionZ D
      // 20e: invokevirtual net/minecraft/util/AxisAlignedBB.addCoord (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 211: ldc2_w -0.175
      // 214: dconst_0
      // 215: ldc2_w -0.175
      // 218: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 21b: invokevirtual net/minecraft/client/multiplayer/WorldClient.getCollidingBoundingBoxes (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/AxisAlignedBB;)Ljava/util/List;
      // 21e: invokeinterface java/util/List.isEmpty ()Z 1
      // 223: invokestatic x/oc3b42959d05.e (ZZZZ)Z
      // 226: iload 5
      // 228: ifne 243
      // 22b: ifeq 259
      // 22e: goto 232
      // 231: athrow
      // 232: aload 1
      // 233: iload 5
      // 235: ifne 255
      // 238: goto 23c
      // 23b: athrow
      // 23c: invokevirtual x/oc70db705765.ҧ ()Z
      // 23f: goto 243
      // 242: athrow
      // 243: ifne 254
      // 246: aload 0
      // 247: getfield x/oc3b42959d05.Ы Lx/oc668fce0dbf;
      // 24a: ldc_w "Telly2/SafeWalk"
      // 24d: invokevirtual x/oc668fce0dbf.Ԝ (Ljava/lang/String;)V
      // 250: goto 254
      // 253: athrow
      // 254: aload 1
      // 255: bipush 1
      // 256: invokevirtual x/oc70db705765.Г (Z)V
      // 259: return
   }

   static boolean e(boolean var0, boolean var1, boolean var2, boolean var3) {
      int var4 = oc84f20a0bc5.ė;

      boolean var10000;
      label60: {
         try {
            var10000 = var0;
            if (var4 != 0) {
               break label60;
            }

            if (!var0) {
               return false;
            }
         } catch (ocbde1165e4e var8) {
            throw var8;
         }

         var10000 = var1;
      }

      label54: {
         try {
            if (var4 != 0) {
               break label54;
            }

            if (!var10000) {
               return false;
            }
         } catch (ocbde1165e4e var7) {
            throw var7;
         }

         var10000 = var2;
      }

      label48: {
         try {
            if (var4 != 0) {
               break label48;
            }

            if (var10000) {
               return false;
            }
         } catch (ocbde1165e4e var6) {
            throw var6;
         }

         var10000 = var3;
      }

      try {
         if (var4 != 0) {
            return var10000;
         }

         if (var10000) {
            return true;
         }
      } catch (ocbde1165e4e var5) {
         throw var5;
      }

      return false;
   }

   void ƅ(ocf242f30eaa param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield x/oc3b42959d05.Ы Lx/oc668fce0dbf;
      // 04: invokevirtual x/oc668fce0dbf.ն ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 07: astore 3
      // 08: getstatic x/oc84f20a0bc5.ė I
      // 0b: invokestatic x/ocbb165642ef.ʨ ()Lx/ocbb165642ef;
      // 0e: invokevirtual x/ocbb165642ef.ɦ ()Ljava/lang/Float;
      // 11: astore 4
      // 13: istore 2
      // 14: aload 1
      // 15: ifnull 8f
      // 18: aload 3
      // 19: ifnull 8f
      // 1c: goto 20
      // 1f: athrow
      // 20: aload 0
      // 21: getfield x/oc3b42959d05.Ɏ Z
      // 24: iload 2
      // 25: ifne 41
      // 28: goto 2c
      // 2b: athrow
      // 2c: ifeq 8f
      // 2f: goto 33
      // 32: athrow
      // 33: invokestatic x/ocbb165642ef.ʨ ()Lx/ocbb165642ef;
      // 36: aload 0
      // 37: getfield x/oc3b42959d05.Ы Lx/oc668fce0dbf;
      // 3a: invokevirtual x/ocbb165642ef.D (Ljava/lang/Object;)Z
      // 3d: goto 41
      // 40: athrow
      // 41: ifeq 8f
      // 44: aload 4
      // 46: iload 2
      // 47: ifne 57
      // 4a: goto 4e
      // 4d: athrow
      // 4e: ifnull 8f
      // 51: goto 55
      // 54: athrow
      // 55: aload 4
      // 57: invokevirtual java/lang/Float.isNaN ()Z
      // 5a: iload 2
      // 5b: ifne 77
      // 5e: ifne 8f
      // 61: goto 65
      // 64: athrow
      // 65: aload 1
      // 66: invokevirtual x/ocf242f30eaa.Α ()F
      // 69: iload 2
      // 6a: ifne 95
      // 6d: goto 71
      // 70: athrow
      // 71: fconst_0
      // 72: fcmpl
      // 73: goto 77
      // 76: athrow
      // 77: ifne 91
      // 7a: aload 1
      // 7b: invokevirtual x/ocf242f30eaa.Υ ()F
      // 7e: iload 2
      // 7f: ifne 95
      // 82: goto 86
      // 85: athrow
      // 86: fconst_0
      // 87: fcmpl
      // 88: ifne 91
      // 8b: goto 8f
      // 8e: athrow
      // 8f: return
      // 90: athrow
      // 91: aload 3
      // 92: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 95: aload 4
      // 97: invokevirtual java/lang/Float.floatValue ()F
      // 9a: aload 1
      // 9b: invokevirtual x/ocf242f30eaa.Α ()F
      // 9e: aload 1
      // 9f: invokevirtual x/ocf242f30eaa.Υ ()F
      // a2: aload 3
      // a3: iload 2
      // a4: ifne b6
      // a7: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // aa: ifnull cb
      // ad: goto b1
      // b0: athrow
      // b1: aload 3
      // b2: goto b6
      // b5: athrow
      // b6: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // b9: getfield net/minecraft/util/MovementInput.sneak Z
      // bc: iload 2
      // bd: ifne c8
      // c0: ifeq cb
      // c3: goto c7
      // c6: athrow
      // c7: bipush 1
      // c8: goto cc
      // cb: bipush 0
      // cc: invokestatic x/oc3b42959d05.ҷ (FFFFZ)Lx/oc1c4f5dd176;
      // cf: astore 5
      // d1: aload 1
      // d2: aload 5
      // d4: getfield x/oc1c4f5dd176.ˠ F
      // d7: invokevirtual x/ocf242f30eaa.ў (F)V
      // da: aload 1
      // db: aload 5
      // dd: getfield x/oc1c4f5dd176.ô F
      // e0: invokevirtual x/ocf242f30eaa.I (F)V
      // e3: return
   }

   static oc1c4f5dd176 ҷ(float var0, float var1, float var2, float var3, boolean var4) {
      return oc7beea7ccff.p(var0, var1, var2, var3, var4);
   }

   void Լ(oc55585a6f85 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: invokestatic x/ocbb165642ef.ʨ ()Lx/ocbb165642ef;
      // 06: invokevirtual x/ocbb165642ef.ɦ ()Ljava/lang/Float;
      // 09: astore 3
      // 0a: istore 2
      // 0b: aload 1
      // 0c: ifnull 56
      // 0f: aload 0
      // 10: getfield x/oc3b42959d05.Ɏ Z
      // 13: iload 2
      // 14: ifne 30
      // 17: goto 1b
      // 1a: athrow
      // 1b: ifeq 56
      // 1e: goto 22
      // 21: athrow
      // 22: invokestatic x/ocbb165642ef.ʨ ()Lx/ocbb165642ef;
      // 25: aload 0
      // 26: getfield x/oc3b42959d05.Ы Lx/oc668fce0dbf;
      // 29: invokevirtual x/ocbb165642ef.D (Ljava/lang/Object;)Z
      // 2c: goto 30
      // 2f: athrow
      // 30: ifeq 56
      // 33: aload 3
      // 34: iload 2
      // 35: ifne 44
      // 38: goto 3c
      // 3b: athrow
      // 3c: ifnull 56
      // 3f: goto 43
      // 42: athrow
      // 43: aload 3
      // 44: invokevirtual java/lang/Float.isNaN ()Z
      // 47: ifne 56
      // 4a: aload 1
      // 4b: aload 3
      // 4c: invokevirtual java/lang/Float.floatValue ()F
      // 4f: invokevirtual x/oc55585a6f85.Ě (F)V
      // 52: goto 56
      // 55: athrow
      // 56: return
   }

   void Ϋ(oc4c5a4d3446 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: invokestatic x/ocbb165642ef.ʨ ()Lx/ocbb165642ef;
      // 06: invokevirtual x/ocbb165642ef.ɦ ()Ljava/lang/Float;
      // 09: astore 3
      // 0a: istore 2
      // 0b: aload 1
      // 0c: ifnull 56
      // 0f: aload 0
      // 10: getfield x/oc3b42959d05.Ɏ Z
      // 13: iload 2
      // 14: ifne 30
      // 17: goto 1b
      // 1a: athrow
      // 1b: ifeq 56
      // 1e: goto 22
      // 21: athrow
      // 22: invokestatic x/ocbb165642ef.ʨ ()Lx/ocbb165642ef;
      // 25: aload 0
      // 26: getfield x/oc3b42959d05.Ы Lx/oc668fce0dbf;
      // 29: invokevirtual x/ocbb165642ef.D (Ljava/lang/Object;)Z
      // 2c: goto 30
      // 2f: athrow
      // 30: ifeq 56
      // 33: aload 3
      // 34: iload 2
      // 35: ifne 44
      // 38: goto 3c
      // 3b: athrow
      // 3c: ifnull 56
      // 3f: goto 43
      // 42: athrow
      // 43: aload 3
      // 44: invokevirtual java/lang/Float.isNaN ()Z
      // 47: ifne 56
      // 4a: aload 1
      // 4b: aload 3
      // 4c: invokevirtual java/lang/Float.floatValue ()F
      // 4f: invokevirtual x/oc4c5a4d3446.Ŗ (F)V
      // 52: goto 56
      // 55: athrow
      // 56: return
   }

   void δ(Packet<?> param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 18
      // 09: instanceof net/minecraft/network/play/client/C03PacketPlayer
      // 0c: ifeq 29
      // 0f: goto 13
      // 12: athrow
      // 13: aload 1
      // 14: goto 18
      // 17: athrow
      // 18: iload 2
      // 19: ifne 2c
      // 1c: checkcast net/minecraft/network/play/client/C03PacketPlayer
      // 1f: invokevirtual net/minecraft/network/play/client/C03PacketPlayer.getRotating ()Z
      // 22: ifne 2b
      // 25: goto 29
      // 28: athrow
      // 29: return
      // 2a: athrow
      // 2b: aload 1
      // 2c: checkcast net/minecraft/network/play/client/C03PacketPlayer
      // 2f: astore 3
      // 30: iload 2
      // 31: aload 3
      // 32: invokevirtual net/minecraft/network/play/client/C03PacketPlayer.getPitch ()F
      // 35: fstore 4
      // 37: ifne 76
      // 3a: aload 0
      // 3b: getfield x/oc3b42959d05.Җ Z
      // 3e: ifeq 6d
      // 41: goto 45
      // 44: athrow
      // 45: aload 0
      // 46: fload 4
      // 48: aload 0
      // 49: getfield x/oc3b42959d05.Ư F
      // 4c: fsub
      // 4d: aload 0
      // 4e: invokevirtual x/oc3b42959d05.Ћ ()F
      // 51: invokestatic x/oc3b42959d05.Ћ (FF)I
      // 54: putfield x/oc3b42959d05.ѳ I
      // 57: iload 2
      // 58: aload 0
      // 59: fload 4
      // 5b: aload 0
      // 5c: getfield x/oc3b42959d05.Ư F
      // 5f: fsub
      // 60: invokestatic x/oc3b42959d05.Ѱ (F)J
      // 63: putfield x/oc3b42959d05.ž J
      // 66: ifeq 7b
      // 69: goto 6d
      // 6c: athrow
      // 6d: aload 0
      // 6e: bipush 1
      // 6f: putfield x/oc3b42959d05.Җ Z
      // 72: goto 76
      // 75: athrow
      // 76: aload 0
      // 77: bipush -1
      // 78: putfield x/oc3b42959d05.ѳ I
      // 7b: aload 0
      // 7c: fload 4
      // 7e: putfield x/oc3b42959d05.Ư F
      // 81: return
   }

   private boolean ϳ(EntityPlayerSP var1) {
      int var2 = oc84f20a0bc5.ė;
      int var3 = 1911797587 ^ 670690312;

      while (true) {
         switch (var3) {
            case -1632712352:
               if (this.ʝ.playerController != null) {
                  var3 = -1253171181 ^ 670690312;
                  if (var2 == 0) {
                     break;
                  }
               }

               var3 = -508027582 ^ 670690312;
               if (var2 == 0) {
                  break;
               }
            case -1833448421:
               int var10000;
               label52: {
                  label51: {
                     try {
                        var10000 = this.Ы.ɣ();
                        if (var2 != 0) {
                           break label52;
                        }

                        if (var10000 == 0) {
                           break label51;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var3 = 412514063 ^ 670690312;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var10000 = -508027582 ^ 670690312;
               }

               var3 = var10000;
               if (var2 == 0) {
                  break;
               }
            case -1848001534:
               if (this.ʝ.theWorld != null) {
                  var3 = -1185471128 ^ 670690312;
                  if (var2 == 0) {
                     break;
                  }
               }

               var3 = -508027582 ^ 670690312;
               if (var2 == 0) {
                  break;
               }

               return true;
            case -968756918:
               return false;
            case 1064278791:
               return true;
            case 1443519323:
               if (var1 != null) {
                  var3 = -1239396342 ^ 670690312;
                  if (var2 == 0) {
                     break;
                  }
               }

               var3 = -508027582 ^ 670690312;
               break;
            default:
               throw null;
         }
      }
   }

   private void ŗ() {
      this.ʸ = null;
      this.ý = null;
   }

   private void ʴ(double param1, double param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: aload 0
      // 04: getfield x/oc3b42959d05.Ы Lx/oc668fce0dbf;
      // 07: invokevirtual x/oc668fce0dbf.ն ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0a: astore 6
      // 0c: istore 5
      // 0e: aload 0
      // 0f: iload 5
      // 11: ifne 3a
      // 14: getfield x/oc3b42959d05.Ы Lx/oc668fce0dbf;
      // 17: invokevirtual x/oc668fce0dbf.ҧ ()Z
      // 1a: ifeq 35
      // 1d: goto 21
      // 20: athrow
      // 21: aload 0
      // 22: iload 5
      // 24: ifne 48
      // 27: goto 2b
      // 2a: athrow
      // 2b: invokevirtual x/oc3b42959d05.Ԓ ()Z
      // 2e: ifeq 47
      // 31: goto 35
      // 34: athrow
      // 35: aload 0
      // 36: goto 3a
      // 39: athrow
      // 3a: aload 6
      // 3c: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // 3f: dconst_1
      // 40: dsub
      // 41: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 44: putfield x/oc3b42959d05.ե I
      // 47: aload 0
      // 48: dload 1
      // 49: dload 3
      // 4a: invokevirtual x/oc3b42959d05.ʊ (DD)Lx/oc53d3c94c4b;
      // 4d: astore 7
      // 4f: aload 0
      // 50: aload 7
      // 52: iload 5
      // 54: ifne 65
      // 57: ifnonnull 63
      // 5a: goto 5e
      // 5d: athrow
      // 5e: aconst_null
      // 5f: goto 68
      // 62: athrow
      // 63: aload 7
      // 65: getfield x/oc53d3c94c4b.Г Lnet/minecraft/util/BlockPos;
      // 68: putfield x/oc3b42959d05.ʸ Lnet/minecraft/util/BlockPos;
      // 6b: aload 0
      // 6c: aload 7
      // 6e: iload 5
      // 70: ifne 81
      // 73: ifnonnull 7f
      // 76: goto 7a
      // 79: athrow
      // 7a: aconst_null
      // 7b: goto 84
      // 7e: athrow
      // 7f: aload 7
      // 81: getfield x/oc53d3c94c4b.ѻ Lnet/minecraft/util/EnumFacing;
      // 84: putfield x/oc3b42959d05.ý Lnet/minecraft/util/EnumFacing;
      // 87: return
   }

   private oc53d3c94c4b ʊ(double param1, double param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: aload 0
      // 001: getfield x/oc3b42959d05.Ы Lx/oc668fce0dbf;
      // 004: invokevirtual x/oc668fce0dbf.ն ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 007: astore 6
      // 009: getstatic x/oc84f20a0bc5.ė I
      // 00c: dload 1
      // 00d: aload 6
      // 00f: getfield net/minecraft/client/entity/EntityPlayerSP.motionX D
      // 012: dadd
      // 013: dstore 7
      // 015: istore 5
      // 017: dload 3
      // 018: aload 6
      // 01a: getfield net/minecraft/client/entity/EntityPlayerSP.motionZ D
      // 01d: dadd
      // 01e: dstore 9
      // 020: new net/minecraft/util/BlockPos
      // 023: dup
      // 024: dload 7
      // 026: aload 0
      // 027: getfield x/oc3b42959d05.ե I
      // 02a: i2d
      // 02b: dload 9
      // 02d: invokespecial net/minecraft/util/BlockPos.<init> (DDD)V
      // 030: astore 11
      // 032: aload 0
      // 033: aload 11
      // 035: invokevirtual x/oc3b42959d05.ե (Lnet/minecraft/util/BlockPos;)Z
      // 038: iload 5
      // 03a: ifne 04c
      // 03d: ifeq 047
      // 040: goto 044
      // 043: athrow
      // 044: aconst_null
      // 045: areturn
      // 046: athrow
      // 047: aload 6
      // 049: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 04c: iload 5
      // 04e: ifne 059
      // 051: ifne 05c
      // 054: goto 058
      // 057: athrow
      // 058: bipush 1
      // 059: goto 05d
      // 05c: bipush 0
      // 05d: istore 12
      // 05f: aconst_null
      // 060: astore 13
      // 062: ldc_w 750011604
      // 065: ldc_w 1397472043
      // 068: ixor
      // 069: istore 14
      // 06b: ldc2_w Infinity
      // 06e: dstore 15
      // 070: ldc2_w Infinity
      // 073: dstore 17
      // 075: new net/minecraft/util/BlockPos
      // 078: dup
      // 079: dload 1
      // 07a: aload 0
      // 07b: getfield x/oc3b42959d05.ե I
      // 07e: i2d
      // 07f: dload 3
      // 080: invokespecial net/minecraft/util/BlockPos.<init> (DDD)V
      // 083: astore 19
      // 085: aload 0
      // 086: getfield x/oc3b42959d05.ե I
      // 089: bipush 1
      // 08a: isub
      // 08b: istore 20
      // 08d: iload 20
      // 08f: aload 0
      // 090: getfield x/oc3b42959d05.ե I
      // 093: if_icmpgt 281
      // 096: aload 19
      // 098: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 09b: ldc_w 1397472046
      // 09e: ldc_w 1397472043
      // 0a1: ixor
      // 0a2: isub
      // 0a3: istore 21
      // 0a5: iload 21
      // 0a7: aload 19
      // 0a9: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 0ac: ldc_w 1397472046
      // 0af: ldc_w 1397472043
      // 0b2: ixor
      // 0b3: iadd
      // 0b4: if_icmpgt 279
      // 0b7: aload 19
      // 0b9: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 0bc: iload 5
      // 0be: ifne 08f
      // 0c1: ldc_w 1397472046
      // 0c4: ldc_w 1397472043
      // 0c7: ixor
      // 0c8: isub
      // 0c9: istore 22
      // 0cb: iload 22
      // 0cd: aload 19
      // 0cf: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 0d2: ldc_w 1397472046
      // 0d5: ldc_w 1397472043
      // 0d8: ixor
      // 0d9: iadd
      // 0da: if_icmpgt 271
      // 0dd: new net/minecraft/util/BlockPos
      // 0e0: dup
      // 0e1: iload 21
      // 0e3: iload 20
      // 0e5: iload 22
      // 0e7: invokespecial net/minecraft/util/BlockPos.<init> (III)V
      // 0ea: iload 5
      // 0ec: ifne 098
      // 0ef: astore 23
      // 0f1: aload 0
      // 0f2: aload 23
      // 0f4: invokevirtual x/oc3b42959d05.Չ (Lnet/minecraft/util/BlockPos;)Z
      // 0f7: ifne 103
      // 0fa: iload 5
      // 0fc: ifeq 269
      // 0ff: goto 103
      // 102: athrow
      // 103: getstatic x/oc3b42959d05.Γ [Lnet/minecraft/util/EnumFacing;
      // 106: astore 24
      // 108: aload 24
      // 10a: arraylength
      // 10b: istore 25
      // 10d: bipush 0
      // 10e: istore 26
      // 110: iload 26
      // 112: iload 25
      // 114: if_icmpge 269
      // 117: aload 24
      // 119: iload 26
      // 11b: aaload
      // 11c: astore 27
      // 11e: iload 5
      // 120: ifne 26c
      // 123: aload 27
      // 125: getstatic net/minecraft/util/EnumFacing.UP Lnet/minecraft/util/EnumFacing;
      // 128: if_acmpne 141
      // 12b: goto 12f
      // 12e: athrow
      // 12f: iload 12
      // 131: ifne 141
      // 134: goto 138
      // 137: athrow
      // 138: iload 5
      // 13a: ifeq 261
      // 13d: goto 141
      // 140: athrow
      // 141: aload 23
      // 143: aload 27
      // 145: invokevirtual net/minecraft/util/BlockPos.offset (Lnet/minecraft/util/EnumFacing;)Lnet/minecraft/util/BlockPos;
      // 148: astore 28
      // 14a: iload 5
      // 14c: ifne 264
      // 14f: aload 23
      // 151: aload 28
      // 153: aload 11
      // 155: invokestatic x/oc3b42959d05.ե (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/BlockPos;)Z
      // 158: ifeq 261
      // 15b: goto 15f
      // 15e: athrow
      // 15f: aload 0
      // 160: aload 28
      // 162: invokevirtual x/oc3b42959d05.Ç (Lnet/minecraft/util/BlockPos;)Z
      // 165: iload 5
      // 167: ifne 189
      // 16a: goto 16e
      // 16d: athrow
      // 16e: ifne 17e
      // 171: goto 175
      // 174: athrow
      // 175: iload 5
      // 177: ifeq 261
      // 17a: goto 17e
      // 17d: athrow
      // 17e: aload 28
      // 180: aload 11
      // 182: invokestatic x/oc3b42959d05.B (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/BlockPos;)I
      // 185: goto 189
      // 188: athrow
      // 189: istore 29
      // 18b: iload 5
      // 18d: dload 7
      // 18f: aload 0
      // 190: getfield x/oc3b42959d05.ե I
      // 193: i2d
      // 194: ldc2_w 0.5
      // 197: dadd
      // 198: dload 9
      // 19a: aload 28
      // 19c: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 19f: i2d
      // 1a0: ldc2_w 0.5
      // 1a3: dadd
      // 1a4: aload 28
      // 1a6: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 1a9: i2d
      // 1aa: ldc2_w 0.5
      // 1ad: dadd
      // 1ae: aload 28
      // 1b0: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 1b3: i2d
      // 1b4: ldc2_w 0.5
      // 1b7: dadd
      // 1b8: invokestatic x/oc3b42959d05.Ȉ (DDDDDD)D
      // 1bb: dstore 30
      // 1bd: dload 1
      // 1be: aload 6
      // 1c0: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // 1c3: dload 3
      // 1c4: aload 23
      // 1c6: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 1c9: i2d
      // 1ca: ldc2_w 0.5
      // 1cd: dadd
      // 1ce: aload 23
      // 1d0: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 1d3: i2d
      // 1d4: ldc2_w 0.5
      // 1d7: dadd
      // 1d8: aload 23
      // 1da: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 1dd: i2d
      // 1de: ldc2_w 0.5
      // 1e1: dadd
      // 1e2: invokestatic x/oc3b42959d05.Ȉ (DDDDDD)D
      // 1e5: dstore 32
      // 1e7: ifne 254
      // 1ea: iload 29
      // 1ec: iload 14
      // 1ee: if_icmplt 248
      // 1f1: goto 1f5
      // 1f4: athrow
      // 1f5: iload 29
      // 1f7: iload 5
      // 1f9: ifne 21b
      // 1fc: goto 200
      // 1ff: athrow
      // 200: iload 14
      // 202: if_icmpne 261
      // 205: goto 209
      // 208: athrow
      // 209: dload 30
      // 20b: iload 5
      // 20d: ifne 252
      // 210: goto 214
      // 213: athrow
      // 214: dload 15
      // 216: dcmpg
      // 217: goto 21b
      // 21a: athrow
      // 21b: iflt 248
      // 21e: dload 30
      // 220: dload 15
      // 222: iload 5
      // 224: ifne 244
      // 227: goto 22b
      // 22a: athrow
      // 22b: dcmpl
      // 22c: ifne 261
      // 22f: goto 233
      // 232: athrow
      // 233: dload 32
      // 235: iload 5
      // 237: ifne 252
      // 23a: goto 23e
      // 23d: athrow
      // 23e: dload 17
      // 240: goto 244
      // 243: athrow
      // 244: dcmpg
      // 245: ifge 261
      // 248: iload 29
      // 24a: istore 14
      // 24c: dload 30
      // 24e: dstore 15
      // 250: dload 32
      // 252: dstore 17
      // 254: new x/oc53d3c94c4b
      // 257: dup
      // 258: aload 23
      // 25a: aload 27
      // 25c: invokespecial x/oc53d3c94c4b.<init> (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;)V
      // 25f: astore 13
      // 261: iinc 26 1
      // 264: iload 5
      // 266: ifeq 110
      // 269: iinc 22 1
      // 26c: iload 5
      // 26e: ifeq 0cb
      // 271: iinc 21 1
      // 274: iload 5
      // 276: ifeq 0a5
      // 279: iinc 20 1
      // 27c: iload 5
      // 27e: ifeq 08d
      // 281: aload 13
      // 283: areturn
   }

   static boolean ե(BlockPos param0, BlockPos param1, BlockPos param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 3
      // 04: aload 1
      // 05: iload 3
      // 06: ifne 1c
      // 09: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 0c: aload 2
      // 0d: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 10: if_icmpne 38
      // 13: goto 17
      // 16: athrow
      // 17: aload 1
      // 18: goto 1c
      // 1b: athrow
      // 1c: aload 2
      // 1d: invokestatic x/oc3b42959d05.B (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/BlockPos;)I
      // 20: iload 3
      // 21: ifne 35
      // 24: aload 0
      // 25: aload 2
      // 26: invokestatic x/oc3b42959d05.B (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/BlockPos;)I
      // 29: if_icmpge 38
      // 2c: goto 30
      // 2f: athrow
      // 30: bipush 1
      // 31: goto 35
      // 34: athrow
      // 35: goto 39
      // 38: bipush 0
      // 39: ireturn
   }

   private static int B(BlockPos var0, BlockPos var1) {
      return Math.abs(var0.getX() - var1.getX()) + Math.abs(var0.getY() - var1.getY()) + Math.abs(var0.getZ() - var1.getZ());
   }

   private boolean Ç(BlockPos var1) {
      int var2 = oc84f20a0bc5.ė;
      int var3 = -87608516 ^ -1218158502;

      while (true) {
         switch (var3) {
            case -1546887568:
               return false;
            case 1302549350:
               int var10000;
               label50: {
                  label49: {
                     try {
                        var10000 = this.ʝ.theWorld.getBlockState(var1).getBlock().isReplaceable(this.ʝ.theWorld, var1);
                        if (var2 != 0) {
                           break label50;
                        }

                        if (var10000 == 0) {
                           break label49;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var3 = -1632563609 ^ -1218158502;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var10000 = 346570282 ^ -1218158502;
               }

               var3 = var10000;
               if (var2 == 0) {
                  break;
               }
            case 701853245:
               int var6;
               label38: {
                  label37: {
                     try {
                        var6 = this.ʟ(var1);
                        if (var2 != 0) {
                           break label38;
                        }

                        if (var6 != 0) {
                           break label37;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var3 = -411249341 ^ -1218158502;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var6 = 346570282 ^ -1218158502;
               }

               var3 = var6;
               if (var2 == 0) {
                  break;
               }

               return true;
            case 1343796505:
               return true;
            default:
               throw null;
         }
      }
   }

   private boolean ě() {
      EntityPlayerSP var2 = null;
      BlockPos var3 = null;
      oc53d3c94c4b var4 = null;
      int var1 = oc84f20a0bc5.ė;
      int var5 = 2068913566 ^ 1213974238;

      while (true) {
         label144:
         while (true) {
            switch (var5) {
               case -1045142548:
                  break label144;
               case 66972370:
                  return false;
               case 322164751:
                  return true;
               case 350970607:
                  return false;
               case 660676533:
                  return false;
               case 856349504:
                  break;
               case 1624347763:
                  if (this.ý != null) {
                     var5 = -1980783310 ^ 1213974238;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var5 = 1269181452 ^ 1213974238;
                  if (var1 == 0) {
                     continue;
                  }
               case -572774576:
                  var4 = this.ʊ(var2.posX, var2.posZ);

                  label130: {
                     label129: {
                        try {
                           if (var1 != 0) {
                              break label130;
                           }

                           if (var4 == null) {
                              break label129;
                           }
                        } catch (ocbde1165e4e var10) {
                           throw var10;
                        }

                        var5 = 977474243 ^ 1213974238;
                        if (var1 == 0) {
                           continue;
                        }
                     }

                     var5 = 1555080241 ^ 1213974238;
                  }

                  if (var1 == 0) {
                     continue;
                  }
               case -1403073154:
                  int var11;
                  label119: {
                     label118: {
                        try {
                           var11 = this.Չ(this.ʸ);
                           if (var1 != 0) {
                              break label119;
                           }

                           if (var11 != 0) {
                              break label118;
                           }
                        } catch (ocbde1165e4e var9) {
                           throw var9;
                        }

                        var5 = 1269181452 ^ 1213974238;
                        if (var1 == 0) {
                           continue;
                        }
                     }

                     var11 = 920979678 ^ 1213974238;
                  }

                  var5 = var11;
                  if (var1 == 0) {
                     continue;
                  }
                  break label144;
               case 1914229789:
                  int var10000;
                  label110: {
                     label109: {
                        try {
                           var10000 = var3.equals(var4.Г.offset(var4.ѻ));
                           if (var1 != 0) {
                              break label110;
                           }

                           if (var10000 == 0) {
                              break label109;
                           }
                        } catch (ocbde1165e4e var8) {
                           throw var8;
                        }

                        var5 = 1533550289 ^ 1213974238;
                        if (var1 == 0) {
                           continue;
                        }
                     }

                     var10000 = 1555080241 ^ 1213974238;
                  }

                  var5 = var10000;
                  if (var1 == 0) {
                     continue;
                  }
                  break;
               case 2126433792:
                  var3 = this.ʸ.offset(this.ý);

                  label84: {
                     try {
                        if (var1 != 0) {
                           continue;
                        }

                        if (this.Ç(var3)) {
                           break label84;
                        }
                     } catch (ocbde1165e4e var6) {
                        throw var6;
                     }

                     var5 = 1866127723 ^ 1213974238;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var5 = -1786257010 ^ 1213974238;
                  continue;
               default:
                  throw null;
            }

            var2 = this.Ы.ն();

            label94: {
               label93: {
                  try {
                     if (var1 != 0) {
                        break label94;
                     }

                     if (this.ʸ == null) {
                        break label93;
                     }
                  } catch (ocbde1165e4e var7) {
                     throw var7;
                  }

                  var5 = 680153773 ^ 1213974238;
                  if (var1 == 0) {
                     continue;
                  }
               }

               var5 = 1269181452 ^ 1213974238;
            }

            if (var1 != 0) {
               return false;
            }
         }

         if (var2 != null) {
            var5 = -469431392 ^ 1213974238;
            if (var1 == 0) {
               continue;
            }
         }

         var5 = 1269181452 ^ 1213974238;
         if (var1 != 0) {
            return false;
         }
      }
   }

   private boolean ʟ(BlockPos var1) {
      EntityPlayerSP var3 = null;
      Object var4 = null;
      int var2 = oc84f20a0bc5.ė;
      int var5 = 478300116 ^ 349888372;

      while (true) {
         switch (var5) {
            case -1951727027:
               return false;
            case 140023968:
               var3 = this.Ы.ն();

               label35: {
                  label34: {
                     try {
                        if (var2 != 0) {
                           break label35;
                        }

                        if (var3 == null) {
                           break label34;
                        }
                     } catch (ocbde1165e4e var6) {
                        throw var6;
                     }

                     var5 = -1313306934 ^ 349888372;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var5 = -1619927751 ^ 349888372;
               }

               if (var2 == 0) {
                  break;
               }
            case -1520281154:
               if (var1 == null) {
                  var5 = -1619927751 ^ 349888372;
                  if (var2 == 0) {
                     break;
                  }
               }

               var5 = 228695078 ^ 349888372;
               break;
            case 427508562:
               var4 = new AxisAlignedBB(var1.getX(), var1.getY(), var1.getZ(), var1.getX() + 1.0, var1.getY() + 1.0, var1.getZ() + 1.0);
               return var3.getEntityBoundingBox().intersectsWith((AxisAlignedBB)var4);
            default:
               throw null;
         }
      }
   }

   private boolean Չ(BlockPos var1) {
      Block var3 = null;
      int var4 = 1185919289 ^ 1842134277;
      int var2 = oc84f20a0bc5.ė;

      while (true) {
         switch (var4) {
            case -875075346:
               break;
            case -375085589:
               return true;
            case 648978841:
               int var9;
               label67: {
                  label66: {
                     try {
                        var9 = var3 instanceof BlockAir;
                        if (var2 != 0) {
                           break label67;
                        }

                        if (var9 != 0) {
                           break label66;
                        }
                     } catch (ocbde1165e4e var6) {
                        throw var6;
                     }

                     var4 = -1508125205 ^ 1842134277;
                     if (var2 == 0) {
                        continue;
                     }
                  }

                  var9 = 85980120 ^ 1842134277;
               }

               var4 = var9;
               if (var2 == 0) {
                  continue;
               }
               break;
            case 727911484:
               var3 = this.ʝ.theWorld.getBlockState(var1).getBlock();

               label89: {
                  label88: {
                     try {
                        if (var2 != 0) {
                           break label89;
                        }

                        if (var3 instanceof BlockLiquid) {
                           break label88;
                        }
                     } catch (ocbde1165e4e var8) {
                        throw var8;
                     }

                     var4 = 1264721052 ^ 1842134277;
                     if (var2 == 0) {
                        continue;
                     }
                  }

                  var4 = 85980120 ^ 1842134277;
               }

               if (var2 == 0) {
                  continue;
               }
            case -1503499681:
               int var10000;
               label76: {
                  label75: {
                     try {
                        var10000 = var3 instanceof BlockFurnace;
                        if (var2 != 0) {
                           break label76;
                        }

                        if (var10000 != 0) {
                           break label75;
                        }
                     } catch (ocbde1165e4e var7) {
                        throw var7;
                     }

                     var4 = -2073552658 ^ 1842134277;
                     if (var2 == 0) {
                        continue;
                     }
                  }

                  var10000 = 85980120 ^ 1842134277;
               }

               var4 = var10000;
               if (var2 == 0) {
                  continue;
               }

               return true;
            case 1758678749:
               return false;
            default:
               throw null;
         }

         int var10;
         label58: {
            label57: {
               try {
                  var10 = var3 instanceof BlockChest;
                  if (var2 != 0) {
                     break label58;
                  }

                  if (var10 != 0) {
                     break label57;
                  }
               } catch (ocbde1165e4e var5) {
                  throw var5;
               }

               var4 = -877734054 ^ 1842134277;
               if (var2 == 0) {
                  continue;
               }
            }

            var10 = 85980120 ^ 1842134277;
         }

         var4 = var10;
      }
   }

   private boolean ե(BlockPos var1) {
      Block var3 = null;
      int var4 = 1039541334 ^ -757466514;
      int var2 = oc84f20a0bc5.ė;

      while (true) {
         label187:
         while (true) {
            label185:
            while (true) {
               label183:
               while (true) {
                  switch (var4) {
                     case -1786382160:
                        return true;
                     case -1718048745:
                        break label183;
                     case -1396897070:
                        int var13;
                        label169: {
                           label168: {
                              try {
                                 var13 = var3 instanceof BlockSkull;
                                 if (var2 != 0) {
                                    break label169;
                                 }

                                 if (var13 == 0) {
                                    break label168;
                                 }
                              } catch (ocbde1165e4e var12) {
                                 throw var12;
                              }

                              var4 = -2114179783 ^ -757466514;
                              if (var2 == 0) {
                                 continue;
                              }
                           }

                           var13 = -1612557393 ^ -757466514;
                        }

                        var4 = var13;
                        if (var2 == 0) {
                           continue;
                        }
                     case -2107182923:
                        int var14;
                        label159: {
                           label158: {
                              try {
                                 var14 = var3 instanceof BlockLadder;
                                 if (var2 != 0) {
                                    break label159;
                                 }

                                 if (var14 != 0) {
                                    break label158;
                                 }
                              } catch (ocbde1165e4e var11) {
                                 throw var11;
                              }

                              var4 = -1654070303 ^ -757466514;
                              if (var2 == 0) {
                                 continue;
                              }
                           }

                           var14 = -2114179783 ^ -757466514;
                        }

                        var4 = var14;
                        if (var2 == 0) {
                           continue;
                        }
                     case -1373319236:
                        break;
                     case -789463625:
                        int var10000;
                        label106: {
                           label105: {
                              try {
                                 var10000 = var3 instanceof BlockSnow;
                                 if (var2 != 0) {
                                    break label106;
                                 }

                                 if (var10000 != 0) {
                                    break label105;
                                 }
                              } catch (ocbde1165e4e var6) {
                                 throw var6;
                              }

                              var4 = 2120544444 ^ -757466514;
                              if (var2 == 0) {
                                 continue;
                              }
                           }

                           var10000 = -2114179783 ^ -757466514;
                        }

                        var4 = var10000;
                        if (var2 != 0) {
                           return true;
                        }
                        continue;
                     case -282075592:
                        var3 = this.ʝ.theWorld.getBlockState(var1).getBlock();

                        label96: {
                           try {
                              if (var2 != 0) {
                                 continue;
                              }

                              if (var3.getMaterial().isSolid()) {
                                 break label96;
                              }
                           } catch (ocbde1165e4e var5) {
                              throw var5;
                           }

                           var4 = 2096969170 ^ -757466514;
                           if (var2 == 0) {
                              continue;
                           }
                        }

                        var4 = -2114179783 ^ -757466514;
                        continue;
                     case 1295755713:
                        return false;
                     case 1337006479:
                        break label187;
                     case 1394988887:
                        break label185;
                     default:
                        throw null;
                  }

                  int var15;
                  label149: {
                     label148: {
                        try {
                           var15 = var3.isTranslucent();
                           if (var2 != 0) {
                              break label149;
                           }

                           if (var15 == 0) {
                              break label148;
                           }
                        } catch (ocbde1165e4e var10) {
                           throw var10;
                        }

                        var4 = 1354697435 ^ -757466514;
                        if (var2 == 0) {
                           continue;
                        }
                     }

                     var15 = -2114179783 ^ -757466514;
                  }

                  var4 = var15;
                  if (var2 != 0) {
                     break;
                  }
               }

               int var16;
               label139: {
                  label138: {
                     try {
                        var16 = var3 instanceof BlockContainer;
                        if (var2 != 0) {
                           break label139;
                        }

                        if (var16 != 0) {
                           break label138;
                        }
                     } catch (ocbde1165e4e var9) {
                        throw var9;
                     }

                     var4 = 1197212382 ^ -757466514;
                     if (var2 == 0) {
                        continue;
                     }
                  }

                  var16 = -1612557393 ^ -757466514;
               }

               var4 = var16;
               if (var2 != 0) {
                  break;
               }
            }

            int var17;
            label128: {
               label127: {
                  try {
                     var17 = var3.getMaterial().isLiquid();
                     if (var2 != 0) {
                        break label128;
                     }

                     if (var17 != 0) {
                        break label127;
                     }
                  } catch (ocbde1165e4e var8) {
                     throw var8;
                  }

                  var4 = 1262572153 ^ -757466514;
                  if (var2 == 0) {
                     continue;
                  }
               }

               var17 = -1612557393 ^ -757466514;
            }

            var4 = var17;
            if (var2 != 0) {
               break;
            }
         }

         int var18;
         label115: {
            label114: {
               try {
                  var18 = var3 instanceof BlockCarpet;
                  if (var2 != 0) {
                     break label115;
                  }

                  if (var18 != 0) {
                     break label114;
                  }
               } catch (ocbde1165e4e var7) {
                  throw var7;
               }

               var4 = 36194265 ^ -757466514;
               if (var2 == 0) {
                  continue;
               }
            }

            var18 = -2114179783 ^ -757466514;
         }

         var4 = var18;
         if (var2 != 0) {
            return false;
         }
      }
   }

   private float[] Ԑ(EntityPlayerSP param1, BlockPos param2, EnumFacing param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 1
      // 01: aload 2
      // 02: aload 3
      // 03: invokestatic x/oc3b42959d05.Ի (Lnet/minecraft/client/entity/EntityPlayerSP;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;)[F
      // 06: astore 5
      // 08: getstatic x/oc84f20a0bc5.ė I
      // 0b: aload 0
      // 0c: getfield x/oc3b42959d05.Ы Lx/oc668fce0dbf;
      // 0f: invokevirtual x/oc668fce0dbf.ʓ ()F
      // 12: fstore 6
      // 14: aload 0
      // 15: aload 1
      // 16: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 19: invokevirtual x/oc3b42959d05.Ö (F)F
      // 1c: fload 6
      // 1e: invokestatic x/oc3b42959d05.Ҧ (FF)F
      // 21: fstore 7
      // 23: istore 4
      // 25: aload 0
      // 26: aload 2
      // 27: aload 3
      // 28: fload 7
      // 2a: aload 5
      // 2c: bipush 1
      // 2d: faload
      // 2e: invokevirtual x/oc3b42959d05.Ȍ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;FF)[F
      // 31: astore 8
      // 33: aload 8
      // 35: iload 4
      // 37: ifne 52
      // 3a: ifnull 45
      // 3d: goto 41
      // 40: athrow
      // 41: aload 8
      // 43: areturn
      // 44: athrow
      // 45: aload 0
      // 46: aload 1
      // 47: aload 2
      // 48: aload 3
      // 49: fload 7
      // 4b: aload 5
      // 4d: bipush 1
      // 4e: faload
      // 4f: invokevirtual x/oc3b42959d05.ѥ (Lnet/minecraft/client/entity/EntityPlayerSP;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;FF)[F
      // 52: areturn
   }

   private float[] ѥ(EntityPlayerSP param1, BlockPos param2, EnumFacing param3, float param4, float param5) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 6
      // 005: aload 3
      // 006: iload 6
      // 008: ifne 01a
      // 00b: getstatic net/minecraft/util/EnumFacing.UP Lnet/minecraft/util/EnumFacing;
      // 00e: if_acmpeq 020
      // 011: goto 015
      // 014: athrow
      // 015: aload 3
      // 016: goto 01a
      // 019: athrow
      // 01a: getstatic net/minecraft/util/EnumFacing.DOWN Lnet/minecraft/util/EnumFacing;
      // 01d: if_acmpne 035
      // 020: ldc_w 1759653897
      // 023: ldc_w 1759653899
      // 026: ixor
      // 027: newarray 6
      // 029: dup
      // 02a: bipush 0
      // 02b: fload 4
      // 02d: fastore
      // 02e: dup
      // 02f: bipush 1
      // 030: fload 5
      // 032: fastore
      // 033: areturn
      // 034: athrow
      // 035: aload 0
      // 036: aload 1
      // 037: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 03a: invokevirtual x/oc3b42959d05.Ö (F)F
      // 03d: fstore 7
      // 03f: fload 7
      // 041: f2d
      // 042: invokestatic java/lang/Math.toRadians (D)D
      // 045: dstore 8
      // 047: dload 8
      // 049: invokestatic java/lang/Math.sin (D)D
      // 04c: dneg
      // 04d: dstore 10
      // 04f: dload 8
      // 051: invokestatic java/lang/Math.cos (D)D
      // 054: dstore 12
      // 056: aload 1
      // 057: getfield net/minecraft/client/entity/EntityPlayerSP.motionX D
      // 05a: aload 1
      // 05b: getfield net/minecraft/client/entity/EntityPlayerSP.motionX D
      // 05e: dmul
      // 05f: aload 1
      // 060: getfield net/minecraft/client/entity/EntityPlayerSP.motionZ D
      // 063: aload 1
      // 064: getfield net/minecraft/client/entity/EntityPlayerSP.motionZ D
      // 067: dmul
      // 068: dadd
      // 069: invokestatic java/lang/Math.sqrt (D)D
      // 06c: dstore 14
      // 06e: ldc2_w 1.2
      // 071: ldc2_w 0.45
      // 074: dload 14
      // 076: invokestatic java/lang/Math.min (DD)D
      // 079: dadd
      // 07a: dstore 16
      // 07c: aload 1
      // 07d: getfield net/minecraft/client/entity/EntityPlayerSP.posX D
      // 080: dload 10
      // 082: dload 16
      // 084: dmul
      // 085: dadd
      // 086: dstore 18
      // 088: aload 1
      // 089: getfield net/minecraft/client/entity/EntityPlayerSP.posZ D
      // 08c: dload 12
      // 08e: dload 16
      // 090: dmul
      // 091: dadd
      // 092: dstore 20
      // 094: aload 0
      // 095: aload 2
      // 096: aload 3
      // 097: ldc2_w 0.5
      // 09a: ldc2_w 0.5
      // 09d: invokevirtual x/oc3b42959d05.Ӌ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;DD)Lnet/minecraft/util/Vec3;
      // 0a0: astore 22
      // 0a2: aload 22
      // 0a4: getfield net/minecraft/util/Vec3.xCoord D
      // 0a7: dload 18
      // 0a9: dsub
      // 0aa: aload 22
      // 0ac: getfield net/minecraft/util/Vec3.xCoord D
      // 0af: dload 18
      // 0b1: dsub
      // 0b2: dmul
      // 0b3: aload 22
      // 0b5: getfield net/minecraft/util/Vec3.zCoord D
      // 0b8: dload 20
      // 0ba: dsub
      // 0bb: aload 22
      // 0bd: getfield net/minecraft/util/Vec3.zCoord D
      // 0c0: dload 20
      // 0c2: dsub
      // 0c3: dmul
      // 0c4: dadd
      // 0c5: invokestatic net/minecraft/util/MathHelper.sqrt_double (D)F
      // 0c8: f2d
      // 0c9: dstore 23
      // 0cb: dload 23
      // 0cd: iload 6
      // 0cf: ifne 102
      // 0d2: ldc2_w 9.999999747378752E-5
      // 0d5: dcmpg
      // 0d6: ifgt 0f2
      // 0d9: goto 0dd
      // 0dc: athrow
      // 0dd: ldc_w 1759653897
      // 0e0: ldc_w 1759653899
      // 0e3: ixor
      // 0e4: newarray 6
      // 0e6: dup
      // 0e7: bipush 0
      // 0e8: fload 4
      // 0ea: fastore
      // 0eb: dup
      // 0ec: bipush 1
      // 0ed: fload 5
      // 0ef: fastore
      // 0f0: areturn
      // 0f1: athrow
      // 0f2: aload 22
      // 0f4: getfield net/minecraft/util/Vec3.yCoord D
      // 0f7: aload 1
      // 0f8: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // 0fb: dsub
      // 0fc: aload 1
      // 0fd: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getEyeHeight ()F
      // 100: f2d
      // 101: dsub
      // 102: dstore 25
      // 104: dload 25
      // 106: dload 23
      // 108: invokestatic java/lang/Math.atan2 (DD)D
      // 10b: invokestatic java/lang/Math.toDegrees (D)D
      // 10e: dneg
      // 10f: d2f
      // 110: fstore 27
      // 112: fload 27
      // 114: iload 6
      // 116: ifne 13a
      // 119: invokestatic java/lang/Float.isNaN (F)Z
      // 11c: ifne 138
      // 11f: goto 123
      // 122: athrow
      // 123: fload 27
      // 125: invokestatic java/lang/Float.isInfinite (F)Z
      // 128: iload 6
      // 12a: ifne 143
      // 12d: goto 131
      // 130: athrow
      // 131: ifeq 13c
      // 134: goto 138
      // 137: athrow
      // 138: fload 5
      // 13a: fstore 27
      // 13c: ldc_w 1759653897
      // 13f: ldc_w 1759653899
      // 142: ixor
      // 143: newarray 6
      // 145: dup
      // 146: bipush 0
      // 147: fload 4
      // 149: fastore
      // 14a: dup
      // 14b: bipush 1
      // 14c: fload 27
      // 14e: ldc_w 65.0
      // 151: ldc_w 89.0
      // 154: invokestatic net/minecraft/util/MathHelper.clamp_float (FFF)F
      // 157: fastore
      // 158: areturn
   }

   private float[] Ȍ(BlockPos var1, EnumFacing var2, float var3, float var4) {
      float[] var6 = null;
      int var5 = oc84f20a0bc5.ė;
      float var7 = Float.MAX_VALUE;
      double[] var8 = ͽ;
      int var9 = var8.length;
      int var10 = 0;

      while (var10 < var9) {
         double[] var10000 = var8;
         int var10001 = var10;

         label52:
         while (true) {
            double var11 = var10000[var10001];
            double[] var13 = ͽ;
            int var14 = var13.length;
            int var15 = 0;

            while (var15 < var14) {
               var10000 = var13;
               var10001 = var15;
               if (var5 != 0) {
                  continue label52;
               }

               double var16 = var13[var15];
               Vec3 var18 = this.Ӌ(var1, var2, var11, var16);
               float[] var19 = this.ǔ(this.ʝ.thePlayer, var18);
               MovingObjectPosition var20 = this.Ś(var19[0], var19[1]);

               label46: {
                  label61: {
                     try {
                        if (!ʄ(var1, var2, var20) && var5 == 0) {
                           break label61;
                        }
                     } catch (ocbde1165e4e var24) {
                        throw var24;
                     }

                     float var21 = Math.abs(MathHelper.wrapAngleTo180_float(var19[0] - var3));
                     if (var5 != 0) {
                        break label46;
                     }

                     float var22 = Math.abs(var19[1] - var4);
                     float var23 = var21 * 4.0F + var22;
                     if (var23 < var7) {
                        var7 = var23;
                        var6 = var19;
                     }
                  }

                  var15++;
               }

               if (var5 != 0) {
                  break;
               }
            }

            var10++;
            if (var5 != 0) {
               return var6;
            }
            break;
         }
      }

      return var6;
   }

   // $VF: Unable to simplify switch on enum
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private Vec3 Ӌ(BlockPos var1, EnumFacing var2, double var3, double var5) {
      try {
         switch (oc773e63afc1.ժ[var2.ordinal()]) {
            case 1:
               return new Vec3(var1.getX() + 1.0, var1.getY() + var3, var1.getZ() + var5);
            case 2:
               return new Vec3(var1.getX(), var1.getY() + var3, var1.getZ() + var5);
            case 3:
               return new Vec3(var1.getX() + var3, var1.getY() + var5, var1.getZ() + 1.0);
            case 4:
               return new Vec3(var1.getX() + var3, var1.getY() + var5, var1.getZ());
            case 5:
               return new Vec3(var1.getX() + var3, var1.getY() + 1.0, var1.getZ() + var5);
         }
      } catch (ocbde1165e4e var7) {
         throw var7;
      }

      return new Vec3(var1.getX() + var3, var1.getY(), var1.getZ() + var5);
   }

   private float[] ǔ(EntityPlayerSP var1, Vec3 var2) {
      Vec3 var3 = var1.getPositionEyes(1.0F);
      double var4 = var2.xCoord - var3.xCoord;
      double var6 = var2.yCoord - var3.yCoord;
      double var8 = var2.zCoord - var3.zCoord;
      double var10 = MathHelper.sqrt_double(var4 * var4 + var8 * var8);
      float[] var10000 = new float[-58586839 ^ -58586837];
      var10000[0] = (float)Math.toDegrees(Math.atan2(var8, var4)) - 90.0F;
      var10000[1] = (float)(-Math.toDegrees(Math.atan2(var6, var10)));
      return var10000;
   }

   private MovingObjectPosition Ś(float var1, float var2) {
      Vec3 var3 = this.ʝ.thePlayer.getPositionEyes(1.0F);
      Vec3 var4 = oc7ab2161b9f.ҵ(var1, var2);
      double var5 = this.ʝ.playerController.getBlockReachDistance();
      Vec3 var7 = var3.addVector(var4.xCoord * var5, var4.yCoord * var5, var4.zCoord * var5);
      return this.ʝ.theWorld.rayTraceBlocks(var3, var7, false, false, true);
   }

   static float[] Ի(EntityPlayerSP var0, BlockPos var1, EnumFacing var2) {
      double var3 = var1.getX() + 0.5 + var2.getDirectionVec().getX() * 0.5;
      double var5 = var1.getY() + 0.5 + var2.getDirectionVec().getY() * 0.5;
      double var7 = var1.getZ() + 0.5 + var2.getDirectionVec().getZ() * 0.5;
      double var9 = var3 - var0.posX;
      double var11 = var7 - var0.posZ;
      double var13 = var5 - var0.posY - var0.getEyeHeight();
      double var15 = MathHelper.sqrt_double(var9 * var9 + var11 * var11);
      float[] var10000 = new float[-2041338684 ^ -2041338682];
      var10000[0] = (float)Math.toDegrees(Math.atan2(var11, var9)) - 90.0F;
      var10000[1] = (float)(-Math.toDegrees(Math.atan2(var13, var15)));
      return var10000;
   }

   private boolean ʥ() {
      int var1 = oc84f20a0bc5.ė;
      int var2 = -599898123 ^ -1463345624;

      while (true) {
         label111:
         while (true) {
            switch (var2) {
               case -1545419506:
                  int var7;
                  label98: {
                     label97: {
                        try {
                           var7 = this.ʝ.gameSettings.keyBindLeft.isKeyDown();
                           if (var1 != 0) {
                              break label98;
                           }

                           if (var7 == 0) {
                              break label97;
                           }
                        } catch (ocbde1165e4e var6) {
                           throw var6;
                        }

                        var2 = -2001720045 ^ -1463345624;
                        if (var1 == 0) {
                           continue;
                        }
                     }

                     var7 = -837030212 ^ -1463345624;
                  }

                  var2 = var7;
                  if (var1 == 0) {
                     continue;
                  }
               case 16117082:
                  int var8;
                  label88: {
                     label87: {
                        try {
                           var8 = this.ʝ.gameSettings.keyBindBack.isKeyDown();
                           if (var1 != 0) {
                              break label88;
                           }

                           if (var8 != 0) {
                              break label87;
                           }
                        } catch (ocbde1165e4e var5) {
                           throw var5;
                        }

                        var2 = -1786182595 ^ -1463345624;
                        if (var1 == 0) {
                           continue;
                        }
                     }

                     var8 = -2001720045 ^ -1463345624;
                  }

                  var2 = var8;
                  if (var1 == 0) {
                     continue;
                  }
               case -1423451681:
                  break;
               case 544682811:
                  return true;
               case 1028528661:
                  int var10000;
                  label65: {
                     label64: {
                        try {
                           var10000 = this.ʝ.gameSettings.keyBindRight.isKeyDown();
                           if (var1 != 0) {
                              break label65;
                           }

                           if (var10000 != 0) {
                              break label64;
                           }
                        } catch (ocbde1165e4e var3) {
                           throw var3;
                        }

                        var2 = 187030310 ^ -1463345624;
                        if (var1 == 0) {
                           continue;
                        }
                     }

                     var10000 = -2001720045 ^ -1463345624;
                  }

                  var2 = var10000;
                  if (var1 != 0) {
                     return true;
                  }
                  continue;
               case 1725755540:
                  return false;
               case 1962498525:
                  break label111;
               default:
                  throw null;
            }

            int var9;
            label77: {
               label76: {
                  try {
                     var9 = this.ʝ.gameSettings.keyBindForward.isKeyDown();
                     if (var1 != 0) {
                        break label77;
                     }

                     if (var9 != 0) {
                        break label76;
                     }
                  } catch (ocbde1165e4e var4) {
                     throw var4;
                  }

                  var2 = -1473055886 ^ -1463345624;
                  if (var1 == 0) {
                     continue;
                  }
               }

               var9 = -2001720045 ^ -1463345624;
            }

            var2 = var9;
            if (var1 != 0) {
               break;
            }
         }

         if (this.ʝ.gameSettings != null) {
            var2 = 65062903 ^ -1463345624;
            if (var1 == 0) {
               continue;
            }
         }

         var2 = -837030212 ^ -1463345624;
         if (var1 != 0) {
            return false;
         }
      }
   }

   private boolean Ԓ() {
      int var1 = oc84f20a0bc5.ė;
      int var2 = 741552360 ^ -1687283685;

      while (true) {
         switch (var2) {
            case -1709424566:
               return false;
            case -1218631437:
               if (this.ʝ.gameSettings != null) {
                  var2 = 1207332060 ^ -1687283685;
                  if (var1 == 0) {
                     continue;
                  }
               }

               var2 = 24270929 ^ -1687283685;
               if (var1 == 0) {
                  continue;
               }
            case -593988409:
               break;
            case -29977425:
               return true;
            default:
               throw null;
         }

         int var10000;
         label36: {
            label35: {
               try {
                  var10000 = this.ʝ.gameSettings.keyBindJump.isKeyDown();
                  if (var1 != 0) {
                     break label36;
                  }

                  if (var10000 == 0) {
                     break label35;
                  }
               } catch (ocbde1165e4e var3) {
                  throw var3;
               }

               var2 = 1700302004 ^ -1687283685;
               if (var1 == 0) {
                  continue;
               }
            }

            var10000 = 24270929 ^ -1687283685;
         }

         var2 = var10000;
      }
   }

   private float Ö(float var1) {
      return ć(
         var1,
         this.ʝ.gameSettings.keyBindForward.isKeyDown(),
         this.ʝ.gameSettings.keyBindBack.isKeyDown(),
         this.ʝ.gameSettings.keyBindLeft.isKeyDown(),
         this.ʝ.gameSettings.keyBindRight.isKeyDown()
      );
   }

   static float ć(float param0, boolean param1, boolean param2, boolean param3, boolean param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: fload 0
      // 04: fstore 6
      // 06: istore 5
      // 08: iload 1
      // 09: iload 5
      // 0b: ifne 16
      // 0e: ifne 20
      // 11: goto 15
      // 14: athrow
      // 15: iload 2
      // 16: ifeq 20
      // 19: fload 6
      // 1b: ldc 180.0
      // 1d: fadd
      // 1e: fstore 6
      // 20: fconst_1
      // 21: fstore 7
      // 23: iload 1
      // 24: iload 5
      // 26: ifne 50
      // 29: ifne 4b
      // 2c: goto 30
      // 2f: athrow
      // 30: iload 2
      // 31: iload 5
      // 33: ifne 50
      // 36: goto 3a
      // 39: athrow
      // 3a: ifeq 4b
      // 3d: goto 41
      // 40: athrow
      // 41: ldc_w -0.5
      // 44: fstore 7
      // 46: iload 5
      // 48: ifeq 72
      // 4b: iload 1
      // 4c: goto 50
      // 4f: athrow
      // 50: iload 5
      // 52: ifne 73
      // 55: ifeq 72
      // 58: goto 5c
      // 5b: athrow
      // 5c: iload 2
      // 5d: iload 5
      // 5f: ifne 73
      // 62: goto 66
      // 65: athrow
      // 66: ifne 72
      // 69: goto 6d
      // 6c: athrow
      // 6d: ldc_w 0.5
      // 70: fstore 7
      // 72: iload 3
      // 73: iload 5
      // 75: ifne 9c
      // 78: ifeq 9b
      // 7b: goto 7f
      // 7e: athrow
      // 7f: iload 4
      // 81: iload 5
      // 83: ifne 9c
      // 86: goto 8a
      // 89: athrow
      // 8a: ifne 9b
      // 8d: goto 91
      // 90: athrow
      // 91: fload 6
      // 93: ldc 90.0
      // 95: fload 7
      // 97: fmul
      // 98: fsub
      // 99: fstore 6
      // 9b: iload 3
      // 9c: iload 5
      // 9e: ifne aa
      // a1: ifne b7
      // a4: goto a8
      // a7: athrow
      // a8: iload 4
      // aa: ifeq b7
      // ad: fload 6
      // af: ldc 90.0
      // b1: fload 7
      // b3: fmul
      // b4: fadd
      // b5: fstore 6
      // b7: fload 6
      // b9: freturn
   }

   static float Ҧ(float var0, float var1) {
      return var0 + 180.0F + var1;
   }

   static boolean ǚ(boolean var0, boolean var1, boolean var2) {
      int var3 = oc84f20a0bc5.ė;

      boolean var10000;
      label47: {
         try {
            var10000 = var0;
            if (var3 != 0) {
               break label47;
            }

            if (!var0) {
               return false;
            }
         } catch (ocbde1165e4e var6) {
            throw var6;
         }

         var10000 = var1;
      }

      label41: {
         try {
            if (var3 != 0) {
               break label41;
            }

            if (!var10000) {
               return false;
            }
         } catch (ocbde1165e4e var5) {
            throw var5;
         }

         var10000 = var2;
      }

      try {
         if (var3 != 0) {
            return var10000;
         }

         if (!var10000) {
            return true;
         }
      } catch (ocbde1165e4e var4) {
         throw var4;
      }

      return false;
   }

   static boolean ԕ(boolean var0, int var1, double var2, boolean var4) {
      return ϋ(var0, var1, var2, var4, true);
   }

   static boolean ϋ(boolean param0, int param1, double param2, boolean param4, boolean param5) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 6
      // 05: iload 5
      // 07: iload 6
      // 09: ifne 15
      // 0c: ifeq 79
      // 0f: goto 13
      // 12: athrow
      // 13: iload 4
      // 15: iload 6
      // 17: ifne 22
      // 1a: ifne 79
      // 1d: goto 21
      // 20: athrow
      // 21: iload 0
      // 22: iload 6
      // 24: ifne 2f
      // 27: ifne 79
      // 2a: goto 2e
      // 2d: athrow
      // 2e: iload 1
      // 2f: iload 6
      // 31: ifne 4d
      // 34: bipush 1
      // 35: if_icmple 79
      // 38: goto 3c
      // 3b: athrow
      // 3c: dload 2
      // 3d: iload 6
      // 3f: ifne 5a
      // 42: goto 46
      // 45: athrow
      // 46: invokestatic java/lang/Double.isNaN (D)Z
      // 49: goto 4d
      // 4c: athrow
      // 4d: ifne 79
      // 50: dload 2
      // 51: iload 6
      // 53: ifne 65
      // 56: goto 5a
      // 59: athrow
      // 5a: invokestatic java/lang/Double.isInfinite (D)Z
      // 5d: ifne 79
      // 60: dload 2
      // 61: goto 65
      // 64: athrow
      // 65: ldc2_w 0.17
      // 68: dcmpg
      // 69: iload 6
      // 6b: ifne 76
      // 6e: ifgt 79
      // 71: goto 75
      // 74: athrow
      // 75: bipush 1
      // 76: goto 7a
      // 79: bipush 0
      // 7a: ireturn
   }

   private static int ȴ(int var0) {
      return Math.max(1, Math.min(-1429443198 ^ -1429443192, var0));
   }

   static float Ѐ(int var0) {
      try {
         if (var0 < (-1826193809 ^ -1826193811)) {
            return 120.0F;
         }
      } catch (ocbde1165e4e var1) {
         throw var1;
      }

      return 40.0F;
   }

   static oc47c2cd4bd2 Ĉ(float param0, float param1, float param2, float param3, float param4, float param5, float param6) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: fload 2
      // 01: fload 0
      // 02: invokestatic x/oc3b42959d05.W (FF)F
      // 05: fstore 8
      // 07: fload 3
      // 08: fload 1
      // 09: invokestatic x/oc3b42959d05.љ (FF)F
      // 0c: fstore 9
      // 0e: getstatic x/oc84f20a0bc5.ė I
      // 11: fload 0
      // 12: fload 8
      // 14: fload 4
      // 16: invokestatic x/oc3b42959d05.Ǝ (FFF)F
      // 19: fstore 10
      // 1b: istore 7
      // 1d: fload 1
      // 1e: fload 9
      // 20: fload 5
      // 22: invokestatic x/oc3b42959d05.Ǝ (FFF)F
      // 25: fstore 11
      // 27: fload 6
      // 29: invokestatic java/lang/Math.abs (F)F
      // 2c: fstore 12
      // 2e: fload 12
      // 30: iload 7
      // 32: ifne 45
      // 35: invokestatic java/lang/Float.isNaN (F)Z
      // 38: ifne 91
      // 3b: goto 3f
      // 3e: athrow
      // 3f: fload 12
      // 41: goto 45
      // 44: athrow
      // 45: iload 7
      // 47: ifne 5a
      // 4a: invokestatic java/lang/Float.isInfinite (F)Z
      // 4d: ifne 91
      // 50: goto 54
      // 53: athrow
      // 54: fload 12
      // 56: goto 5a
      // 59: athrow
      // 5a: iload 7
      // 5c: ifne 71
      // 5f: ldc 1.0E-4
      // 61: fcmpl
      // 62: ifle 91
      // 65: goto 69
      // 68: athrow
      // 69: fload 10
      // 6b: fload 0
      // 6c: fsub
      // 6d: goto 71
      // 70: athrow
      // 71: fstore 13
      // 73: fload 11
      // 75: fload 1
      // 76: fsub
      // 77: fstore 14
      // 79: fload 0
      // 7a: fload 13
      // 7c: fadd
      // 7d: fload 13
      // 7f: fload 12
      // 81: frem
      // 82: fsub
      // 83: fstore 10
      // 85: fload 1
      // 86: fload 14
      // 88: fadd
      // 89: fload 14
      // 8b: fload 12
      // 8d: frem
      // 8e: fsub
      // 8f: fstore 11
      // 91: new x/oc47c2cd4bd2
      // 94: dup
      // 95: fload 10
      // 97: fload 11
      // 99: ldc_w -90.0
      // 9c: ldc 90.0
      // 9e: invokestatic net/minecraft/util/MathHelper.clamp_float (FFF)F
      // a1: invokespecial x/oc47c2cd4bd2.<init> (FF)V
      // a4: areturn
   }

   private oc47c2cd4bd2 Í(float param1, float param2, float param3, float param4, float param5, float param6, float param7) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 8
      // 05: aload 0
      // 06: getfield x/oc3b42959d05.β Z
      // 09: iload 8
      // 0b: ifne 28
      // 0e: ifeq 39
      // 11: goto 15
      // 14: athrow
      // 15: fload 2
      // 16: iload 8
      // 18: ifne 36
      // 1b: goto 1f
      // 1e: athrow
      // 1f: aload 0
      // 20: getfield x/oc3b42959d05.ѷ F
      // 23: fcmpl
      // 24: goto 28
      // 27: athrow
      // 28: ifeq 39
      // 2b: invokestatic x/oc3b42959d05.ú ()F
      // 2e: ldc_w 3.0
      // 31: fdiv
      // 32: goto 36
      // 35: athrow
      // 36: goto 3a
      // 39: fconst_0
      // 3a: fstore 9
      // 3c: aload 0
      // 3d: getfield x/oc3b42959d05.β Z
      // 40: iload 8
      // 42: ifne 5f
      // 45: ifeq 70
      // 48: goto 4c
      // 4b: athrow
      // 4c: fload 1
      // 4d: iload 8
      // 4f: ifne 6d
      // 52: goto 56
      // 55: athrow
      // 56: aload 0
      // 57: getfield x/oc3b42959d05.ß F
      // 5a: fcmpl
      // 5b: goto 5f
      // 5e: athrow
      // 5f: ifeq 70
      // 62: invokestatic x/oc3b42959d05.ú ()F
      // 65: ldc_w 3.0
      // 68: fdiv
      // 69: goto 6d
      // 6c: athrow
      // 6d: goto 71
      // 70: fconst_0
      // 71: fstore 10
      // 73: fload 5
      // 75: invokestatic x/oc3b42959d05.ú ()F
      // 78: ldc_w 3.0
      // 7b: fmul
      // 7c: fadd
      // 7d: fstore 11
      // 7f: fload 6
      // 81: invokestatic x/oc3b42959d05.ú ()F
      // 84: ldc_w 3.0
      // 87: fmul
      // 88: fadd
      // 89: fstore 12
      // 8b: fload 1
      // 8c: fload 2
      // 8d: fload 3
      // 8e: fload 9
      // 90: fadd
      // 91: fload 4
      // 93: fload 10
      // 95: fadd
      // 96: fload 11
      // 98: fload 12
      // 9a: fload 7
      // 9c: invokestatic x/oc3b42959d05.Ĉ (FFFFFFF)Lx/oc47c2cd4bd2;
      // 9f: areturn
   }

   private static float ú() {
      return (float)(Math.random() - Math.random());
   }

   private float Ћ() {
      float var1 = this.ʝ.gameSettings.mouseSensitivity * 0.6F + 0.2F;
      return var1 * var1 * var1 * 1.2F;
   }

   private oc47c2cd4bd2 ә(float param1, oc47c2cd4bd2 param2, float param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: aload 2
      // 004: getfield x/oc47c2cd4bd2.Μ F
      // 007: fload 1
      // 008: fsub
      // 009: fstore 5
      // 00b: istore 4
      // 00d: fload 5
      // 00f: invokestatic java/lang/Math.abs (F)F
      // 012: fstore 6
      // 014: fload 5
      // 016: fload 3
      // 017: invokestatic x/oc3b42959d05.Ћ (FF)I
      // 01a: istore 7
      // 01c: aload 0
      // 01d: getfield x/oc3b42959d05.ѳ I
      // 020: iload 4
      // 022: ifne 033
      // 025: bipush -1
      // 026: if_icmpeq 054
      // 029: goto 02d
      // 02c: athrow
      // 02d: iload 7
      // 02f: goto 033
      // 032: athrow
      // 033: iload 4
      // 035: ifne 051
      // 038: ifeq 054
      // 03b: goto 03f
      // 03e: athrow
      // 03f: fload 6
      // 041: iload 4
      // 043: ifne 059
      // 046: goto 04a
      // 049: athrow
      // 04a: ldc 0.15
      // 04c: fcmpg
      // 04d: goto 051
      // 050: athrow
      // 051: ifgt 057
      // 054: aload 2
      // 055: areturn
      // 056: athrow
      // 057: fload 5
      // 059: iload 4
      // 05b: ifne 073
      // 05e: aload 0
      // 05f: getfield x/oc3b42959d05.ž J
      // 062: invokestatic x/oc3b42959d05.Ҳ (FJ)Z
      // 065: ifne 06f
      // 068: goto 06c
      // 06b: athrow
      // 06c: aload 2
      // 06d: areturn
      // 06e: athrow
      // 06f: fload 3
      // 070: invokestatic x/oc3b42959d05.œ (F)F
      // 073: fstore 8
      // 075: aload 0
      // 076: aload 2
      // 077: getfield x/oc47c2cd4bd2.ϳ F
      // 07a: aload 2
      // 07b: getfield x/oc47c2cd4bd2.Μ F
      // 07e: invokevirtual x/oc3b42959d05.Ś (FF)Lnet/minecraft/util/MovingObjectPosition;
      // 081: astore 9
      // 083: aload 0
      // 084: aload 9
      // 086: invokevirtual x/oc3b42959d05.ƒ (Lnet/minecraft/util/MovingObjectPosition;)Z
      // 089: istore 10
      // 08b: fload 5
      // 08d: fconst_0
      // 08e: fcmpg
      // 08f: iload 4
      // 091: ifne 09c
      // 094: ifge 09f
      // 097: goto 09b
      // 09a: athrow
      // 09b: bipush -1
      // 09c: goto 0a0
      // 09f: bipush 1
      // 0a0: istore 11
      // 0a2: bipush 0
      // 0a3: istore 12
      // 0a5: iload 12
      // 0a7: ldc_w -1432008993
      // 0aa: ldc_w -1432009057
      // 0ad: ixor
      // 0ae: if_icmpgt 1d1
      // 0b1: iload 7
      // 0b3: iload 12
      // 0b5: isub
      // 0b6: istore 13
      // 0b8: iload 7
      // 0ba: iload 12
      // 0bc: iadd
      // 0bd: istore 14
      // 0bf: iload 12
      // 0c1: iload 4
      // 0c3: ifne 0e0
      // 0c6: ifne 0d9
      // 0c9: goto 0cd
      // 0cc: athrow
      // 0cd: bipush 1
      // 0ce: newarray 10
      // 0d0: dup
      // 0d1: bipush 0
      // 0d2: iload 7
      // 0d4: iastore
      // 0d5: goto 0ec
      // 0d8: athrow
      // 0d9: ldc_w -1432009059
      // 0dc: ldc_w -1432009057
      // 0df: ixor
      // 0e0: newarray 10
      // 0e2: dup
      // 0e3: bipush 0
      // 0e4: iload 13
      // 0e6: iastore
      // 0e7: dup
      // 0e8: bipush 1
      // 0e9: iload 14
      // 0eb: iastore
      // 0ec: astore 15
      // 0ee: aload 15
      // 0f0: astore 16
      // 0f2: aload 16
      // 0f4: arraylength
      // 0f5: istore 17
      // 0f7: bipush 0
      // 0f8: istore 18
      // 0fa: iload 18
      // 0fc: iload 17
      // 0fe: if_icmpge 1c9
      // 101: aload 16
      // 103: iload 4
      // 105: ifne 0e7
      // 108: iload 18
      // 10a: iaload
      // 10b: istore 19
      // 10d: iload 19
      // 10f: ifgt 11b
      // 112: iload 4
      // 114: ifeq 1c1
      // 117: goto 11b
      // 11a: athrow
      // 11b: fload 1
      // 11c: iload 11
      // 11e: iload 19
      // 120: imul
      // 121: i2f
      // 122: fload 8
      // 124: fmul
      // 125: fadd
      // 126: ldc_w -90.0
      // 129: ldc 90.0
      // 12b: invokestatic net/minecraft/util/MathHelper.clamp_float (FFF)F
      // 12e: fstore 20
      // 130: iload 4
      // 132: ifne 1c4
      // 135: fload 20
      // 137: fload 1
      // 138: fsub
      // 139: fstore 21
      // 13b: fload 21
      // 13d: invokestatic java/lang/Math.abs (F)F
      // 140: ldc 0.15
      // 142: fcmpg
      // 143: ifle 1c1
      // 146: aload 0
      // 147: getfield x/oc3b42959d05.Ы Lx/oc668fce0dbf;
      // 14a: fload 20
      // 14c: fload 1
      // 14d: invokevirtual x/oc668fce0dbf.ӳ (FF)Z
      // 150: iload 4
      // 152: ifne 16d
      // 155: goto 159
      // 158: athrow
      // 159: ifeq 1c1
      // 15c: goto 160
      // 15f: athrow
      // 160: fload 21
      // 162: aload 0
      // 163: getfield x/oc3b42959d05.ž J
      // 166: invokestatic x/oc3b42959d05.Ҳ (FJ)Z
      // 169: goto 16d
      // 16c: athrow
      // 16d: iload 4
      // 16f: ifne 188
      // 172: ifeq 182
      // 175: goto 179
      // 178: athrow
      // 179: iload 4
      // 17b: ifeq 1c1
      // 17e: goto 182
      // 181: athrow
      // 182: iload 10
      // 184: goto 188
      // 187: athrow
      // 188: iload 4
      // 18a: ifne 1a6
      // 18d: ifeq 1b2
      // 190: goto 194
      // 193: athrow
      // 194: aload 0
      // 195: aload 0
      // 196: aload 2
      // 197: getfield x/oc47c2cd4bd2.ϳ F
      // 19a: fload 20
      // 19c: invokevirtual x/oc3b42959d05.Ś (FF)Lnet/minecraft/util/MovingObjectPosition;
      // 19f: invokevirtual x/oc3b42959d05.ƒ (Lnet/minecraft/util/MovingObjectPosition;)Z
      // 1a2: goto 1a6
      // 1a5: athrow
      // 1a6: ifne 1b2
      // 1a9: iload 4
      // 1ab: ifeq 1c1
      // 1ae: goto 1b2
      // 1b1: athrow
      // 1b2: new x/oc47c2cd4bd2
      // 1b5: dup
      // 1b6: aload 2
      // 1b7: getfield x/oc47c2cd4bd2.ϳ F
      // 1ba: fload 20
      // 1bc: invokespecial x/oc47c2cd4bd2.<init> (FF)V
      // 1bf: areturn
      // 1c0: athrow
      // 1c1: iinc 18 1
      // 1c4: iload 4
      // 1c6: ifeq 0fa
      // 1c9: iinc 12 1
      // 1cc: iload 4
      // 1ce: ifeq 0a5
      // 1d1: aload 2
      // 1d2: areturn
   }

   private oc47c2cd4bd2 γ(float param1, oc47c2cd4bd2 param2, float param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 4
      // 005: aload 2
      // 006: iload 4
      // 008: ifne 056
      // 00b: ifnull 051
      // 00e: goto 012
      // 011: athrow
      // 012: aload 0
      // 013: iload 4
      // 015: ifne 02b
      // 018: goto 01c
      // 01b: athrow
      // 01c: getfield x/oc3b42959d05.ʸ Lnet/minecraft/util/BlockPos;
      // 01f: ifnull 051
      // 022: goto 026
      // 025: athrow
      // 026: aload 0
      // 027: goto 02b
      // 02a: athrow
      // 02b: iload 4
      // 02d: ifne 03f
      // 030: getfield x/oc3b42959d05.ý Lnet/minecraft/util/EnumFacing;
      // 033: ifnull 051
      // 036: goto 03a
      // 039: athrow
      // 03a: aload 0
      // 03b: goto 03f
      // 03e: athrow
      // 03f: iload 4
      // 041: ifne 058
      // 044: getfield x/oc3b42959d05.ý Lnet/minecraft/util/EnumFacing;
      // 047: getstatic net/minecraft/util/EnumFacing.UP Lnet/minecraft/util/EnumFacing;
      // 04a: if_acmpne 057
      // 04d: goto 051
      // 050: athrow
      // 051: aload 2
      // 052: goto 056
      // 055: athrow
      // 056: areturn
      // 057: aload 0
      // 058: getfield x/oc3b42959d05.ʸ Lnet/minecraft/util/BlockPos;
      // 05b: aload 0
      // 05c: getfield x/oc3b42959d05.ý Lnet/minecraft/util/EnumFacing;
      // 05f: aload 0
      // 060: aload 2
      // 061: getfield x/oc47c2cd4bd2.ϳ F
      // 064: aload 2
      // 065: getfield x/oc47c2cd4bd2.Μ F
      // 068: invokevirtual x/oc3b42959d05.Ś (FF)Lnet/minecraft/util/MovingObjectPosition;
      // 06b: invokestatic x/oc3b42959d05.ʄ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;Lnet/minecraft/util/MovingObjectPosition;)Z
      // 06e: ifeq 074
      // 071: aload 2
      // 072: areturn
      // 073: athrow
      // 074: fload 3
      // 075: invokestatic x/oc3b42959d05.œ (F)F
      // 078: fstore 5
      // 07a: fload 5
      // 07c: invokestatic x/oc3b42959d05.М (F)I
      // 07f: istore 6
      // 081: aload 0
      // 082: getfield x/oc3b42959d05.М F
      // 085: aload 2
      // 086: getfield x/oc47c2cd4bd2.Μ F
      // 089: fcmpl
      // 08a: iload 4
      // 08c: ifne 097
      // 08f: iflt 09a
      // 092: goto 096
      // 095: athrow
      // 096: bipush 1
      // 097: goto 09b
      // 09a: bipush -1
      // 09b: istore 7
      // 09d: bipush 1
      // 09e: istore 8
      // 0a0: iload 8
      // 0a2: iload 6
      // 0a4: if_icmpgt 0f6
      // 0a7: iload 7
      // 0a9: iload 8
      // 0ab: iload 4
      // 0ad: ifne 0ff
      // 0b0: imul
      // 0b1: istore 9
      // 0b3: iload 4
      // 0b5: aload 0
      // 0b6: fload 1
      // 0b7: aload 2
      // 0b8: bipush 0
      // 0b9: iload 9
      // 0bb: fload 5
      // 0bd: invokevirtual x/oc3b42959d05.ɞ (FLx/oc47c2cd4bd2;IIF)Lx/oc47c2cd4bd2;
      // 0c0: astore 10
      // 0c2: ifne 0e5
      // 0c5: aload 10
      // 0c7: ifnull 0d2
      // 0ca: goto 0ce
      // 0cd: athrow
      // 0ce: aload 10
      // 0d0: areturn
      // 0d1: athrow
      // 0d2: aload 0
      // 0d3: fload 1
      // 0d4: aload 2
      // 0d5: bipush 0
      // 0d6: iload 9
      // 0d8: ineg
      // 0d9: fload 5
      // 0db: invokevirtual x/oc3b42959d05.ɞ (FLx/oc47c2cd4bd2;IIF)Lx/oc47c2cd4bd2;
      // 0de: astore 10
      // 0e0: iload 4
      // 0e2: ifne 0f1
      // 0e5: aload 10
      // 0e7: ifnull 0ee
      // 0ea: aload 10
      // 0ec: areturn
      // 0ed: athrow
      // 0ee: iinc 8 1
      // 0f1: iload 4
      // 0f3: ifeq 0a0
      // 0f6: ldc_w 877408858
      // 0f9: ldc_w 877408850
      // 0fc: ixor
      // 0fd: iload 6
      // 0ff: invokestatic java/lang/Math.min (II)I
      // 102: iload 4
      // 104: ifne 11f
      // 107: istore 8
      // 109: aload 0
      // 10a: getfield x/oc3b42959d05.Ƭ F
      // 10d: aload 2
      // 10e: getfield x/oc47c2cd4bd2.ϳ F
      // 111: fsub
      // 112: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_float (F)F
      // 115: fconst_0
      // 116: fcmpl
      // 117: iflt 122
      // 11a: bipush 1
      // 11b: goto 11f
      // 11e: athrow
      // 11f: goto 123
      // 122: bipush -1
      // 123: istore 9
      // 125: bipush 1
      // 126: istore 10
      // 128: iload 10
      // 12a: iload 8
      // 12c: if_icmpgt 1cb
      // 12f: iload 9
      // 131: iload 10
      // 133: imul
      // 134: istore 11
      // 136: bipush 0
      // 137: istore 12
      // 139: iload 12
      // 13b: iload 6
      // 13d: ldc_w 877408858
      // 140: ldc_w 877408850
      // 143: ixor
      // 144: invokestatic java/lang/Math.min (II)I
      // 147: if_icmpgt 1a3
      // 14a: iload 7
      // 14c: iload 12
      // 14e: imul
      // 14f: istore 13
      // 151: aload 0
      // 152: fload 1
      // 153: aload 2
      // 154: iload 11
      // 156: iload 13
      // 158: fload 5
      // 15a: invokevirtual x/oc3b42959d05.ɞ (FLx/oc47c2cd4bd2;IIF)Lx/oc47c2cd4bd2;
      // 15d: iload 4
      // 15f: ifne 1af
      // 162: astore 14
      // 164: aload 14
      // 166: iload 4
      // 168: ifne 174
      // 16b: ifnull 175
      // 16e: goto 172
      // 171: athrow
      // 172: aload 14
      // 174: areturn
      // 175: iload 12
      // 177: ifeq 19b
      // 17a: aload 0
      // 17b: fload 1
      // 17c: aload 2
      // 17d: iload 11
      // 17f: iload 13
      // 181: ineg
      // 182: fload 5
      // 184: invokevirtual x/oc3b42959d05.ɞ (FLx/oc47c2cd4bd2;IIF)Lx/oc47c2cd4bd2;
      // 187: astore 14
      // 189: iload 4
      // 18b: ifne 19e
      // 18e: aload 14
      // 190: ifnull 19b
      // 193: goto 197
      // 196: athrow
      // 197: aload 14
      // 199: areturn
      // 19a: athrow
      // 19b: iinc 12 1
      // 19e: iload 4
      // 1a0: ifeq 139
      // 1a3: aload 0
      // 1a4: fload 1
      // 1a5: aload 2
      // 1a6: iload 11
      // 1a8: ineg
      // 1a9: bipush 0
      // 1aa: fload 5
      // 1ac: invokevirtual x/oc3b42959d05.ɞ (FLx/oc47c2cd4bd2;IIF)Lx/oc47c2cd4bd2;
      // 1af: astore 12
      // 1b1: iload 4
      // 1b3: ifne 1c6
      // 1b6: aload 12
      // 1b8: ifnull 1c3
      // 1bb: goto 1bf
      // 1be: athrow
      // 1bf: aload 12
      // 1c1: areturn
      // 1c2: athrow
      // 1c3: iinc 10 1
      // 1c6: iload 4
      // 1c8: ifeq 128
      // 1cb: aload 2
      // 1cc: areturn
   }

   private oc47c2cd4bd2 ɞ(float param1, oc47c2cd4bd2 param2, int param3, int param4, float param5) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 2
      // 01: getfield x/oc47c2cd4bd2.ϳ F
      // 04: iload 3
      // 05: i2f
      // 06: fload 5
      // 08: fmul
      // 09: fadd
      // 0a: fstore 7
      // 0c: aload 2
      // 0d: getfield x/oc47c2cd4bd2.Μ F
      // 10: iload 4
      // 12: i2f
      // 13: fload 5
      // 15: fmul
      // 16: fadd
      // 17: ldc_w -90.0
      // 1a: ldc 90.0
      // 1c: invokestatic net/minecraft/util/MathHelper.clamp_float (FFF)F
      // 1f: fstore 8
      // 21: getstatic x/oc84f20a0bc5.ė I
      // 24: fload 8
      // 26: fload 1
      // 27: fsub
      // 28: fstore 9
      // 2a: istore 6
      // 2c: iload 4
      // 2e: iload 6
      // 30: ifne 52
      // 33: i2f
      // 34: fload 5
      // 36: fmul
      // 37: invokestatic java/lang/Math.abs (F)F
      // 3a: ldc 3.6
      // 3c: fcmpl
      // 3d: ifgt 77
      // 40: goto 44
      // 43: athrow
      // 44: aload 0
      // 45: getfield x/oc3b42959d05.Ы Lx/oc668fce0dbf;
      // 48: fload 8
      // 4a: fload 1
      // 4b: invokevirtual x/oc668fce0dbf.ӳ (FF)Z
      // 4e: goto 52
      // 51: athrow
      // 52: iload 6
      // 54: ifne 6b
      // 57: ifeq 77
      // 5a: goto 5e
      // 5d: athrow
      // 5e: fload 9
      // 60: aload 0
      // 61: getfield x/oc3b42959d05.ž J
      // 64: invokestatic x/oc3b42959d05.Ҳ (FJ)Z
      // 67: goto 6b
      // 6a: athrow
      // 6b: iload 6
      // 6d: ifne 8d
      // 70: ifeq 7a
      // 73: goto 77
      // 76: athrow
      // 77: aconst_null
      // 78: areturn
      // 79: athrow
      // 7a: aload 0
      // 7b: getfield x/oc3b42959d05.ʸ Lnet/minecraft/util/BlockPos;
      // 7e: aload 0
      // 7f: getfield x/oc3b42959d05.ý Lnet/minecraft/util/EnumFacing;
      // 82: aload 0
      // 83: fload 7
      // 85: fload 8
      // 87: invokevirtual x/oc3b42959d05.Ś (FF)Lnet/minecraft/util/MovingObjectPosition;
      // 8a: invokestatic x/oc3b42959d05.ʄ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;Lnet/minecraft/util/MovingObjectPosition;)Z
      // 8d: ifne 93
      // 90: aconst_null
      // 91: areturn
      // 92: athrow
      // 93: new x/oc47c2cd4bd2
      // 96: dup
      // 97: fload 7
      // 99: fload 8
      // 9b: invokespecial x/oc47c2cd4bd2.<init> (FF)V
      // 9e: areturn
   }

   private static int М(float var0) {
      int var1 = oc84f20a0bc5.ė;
      int var2 = -1433133254 ^ -1098720311;

      while (true) {
         switch (var2) {
            case 337036531:
               int var7;
               label56: {
                  label55: {
                     try {
                        var7 = Float.isNaN(var0);
                        if (var1 != 0) {
                           break label56;
                        }

                        if (var7 != 0) {
                           break label55;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var2 = -1917340626 ^ -1098720311;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var7 = -1987922701 ^ -1098720311;
               }

               var2 = var7;
               break;
            case 754381536:
               return Math.min(-1098720375 ^ -1098720311, Math.max(-1098720309 ^ -1098720311, (int)Math.ceil(3.6F / var0)));
            case 859140071:
               int var10000;
               label69: {
                  label68: {
                     try {
                        var10000 = Float.isInfinite(var0);
                        if (var1 != 0) {
                           break label69;
                        }

                        if (var10000 != 0) {
                           break label68;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var2 = -1708629820 ^ -1098720311;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = -1987922701 ^ -1098720311;
               }

               var2 = var10000;
               if (var1 == 0) {
                  break;
               }
            case 615168781:
               int var6;
               label47: {
                  label46: {
                     try {
                        float var8;
                        var6 = (var8 = var0 - 1.0E-4F) == 0.0F ? 0 : (var8 < 0.0F ? -1 : 1);
                        if (var1 != 0) {
                           break label47;
                        }

                        if (var6 > 0) {
                           break label46;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = -1987922701 ^ -1098720311;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var6 = -1837881047 ^ -1098720311;
               }

               var2 = var6;
               if (var1 == 0) {
                  break;
               }

               return -1098720303 ^ -1098720311;
            case 922775354:
               return -1098720303 ^ -1098720311;
            default:
               throw null;
         }
      }
   }

   static long Ѱ(float param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 1
      // 04: fload 0
      // 05: iload 1
      // 06: ifne 18
      // 09: invokestatic java/lang/Float.isNaN (F)Z
      // 0c: ifne 26
      // 0f: goto 13
      // 12: athrow
      // 13: fload 0
      // 14: goto 18
      // 17: athrow
      // 18: iload 1
      // 19: ifne 2d
      // 1c: invokestatic java/lang/Float.isInfinite (F)Z
      // 1f: ifeq 29
      // 22: goto 26
      // 25: athrow
      // 26: lconst_0
      // 27: lreturn
      // 28: athrow
      // 29: fload 0
      // 2a: invokestatic java/lang/Math.abs (F)F
      // 2d: f2d
      // 2e: ldc2_w 1.6777216E7
      // 31: dmul
      // 32: d2l
      // 33: lreturn
   }

   static long ү(long param0, long param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: lload 0
      // 04: invokestatic java/lang/Math.abs (J)J
      // 07: lstore 5
      // 09: lload 2
      // 0a: invokestatic java/lang/Math.abs (J)J
      // 0d: lstore 7
      // 0f: istore 4
      // 11: lload 5
      // 13: iload 4
      // 15: ifne 3b
      // 18: lconst_0
      // 19: lcmp
      // 1a: ifeq 35
      // 1d: goto 21
      // 20: athrow
      // 21: lload 7
      // 23: iload 4
      // 25: ifne 3e
      // 28: goto 2c
      // 2b: athrow
      // 2c: lconst_0
      // 2d: lcmp
      // 2e: ifne 3c
      // 31: goto 35
      // 34: athrow
      // 35: lload 5
      // 37: goto 3b
      // 3a: athrow
      // 3b: lreturn
      // 3c: lload 7
      // 3e: ldc2_w 3038320981170984251
      // 41: ldc2_w 3038320981171000635
      // 44: lxor
      // 45: lcmp
      // 46: ifle 66
      // 49: lload 5
      // 4b: lload 7
      // 4d: lrem
      // 4e: iload 4
      // 50: ifne 68
      // 53: goto 57
      // 56: athrow
      // 57: lstore 9
      // 59: iload 4
      // 5b: lload 7
      // 5d: lstore 5
      // 5f: lload 9
      // 61: lstore 7
      // 63: ifeq 3c
      // 66: lload 5
      // 68: lreturn
   }

   static boolean Ҳ(float param0, long param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 3
      // 04: fload 0
      // 05: invokestatic java/lang/Float.isNaN (F)Z
      // 08: iload 3
      // 09: ifne 53
      // 0c: ifne 4e
      // 0f: goto 13
      // 12: athrow
      // 13: fload 0
      // 14: invokestatic java/lang/Float.isInfinite (F)Z
      // 17: iload 3
      // 18: ifne 53
      // 1b: goto 1f
      // 1e: athrow
      // 1f: ifne 4e
      // 22: goto 26
      // 25: athrow
      // 26: fload 0
      // 27: invokestatic java/lang/Math.abs (F)F
      // 2a: ldc 0.15
      // 2c: fcmpg
      // 2d: iload 3
      // 2e: ifne 53
      // 31: goto 35
      // 34: athrow
      // 35: ifle 4e
      // 38: goto 3c
      // 3b: athrow
      // 3c: lload 1
      // 3d: iload 3
      // 3e: ifne 58
      // 41: goto 45
      // 44: athrow
      // 45: lconst_0
      // 46: lcmp
      // 47: ifgt 54
      // 4a: goto 4e
      // 4d: athrow
      // 4e: bipush 0
      // 4f: goto 53
      // 52: athrow
      // 53: ireturn
      // 54: fload 0
      // 55: invokestatic x/oc3b42959d05.Ѱ (F)J
      // 58: lstore 4
      // 5a: lload 4
      // 5c: iload 3
      // 5d: ifne 72
      // 60: lconst_0
      // 61: lcmp
      // 62: ifgt 6c
      // 65: goto 69
      // 68: athrow
      // 69: bipush 0
      // 6a: ireturn
      // 6b: athrow
      // 6c: lload 4
      // 6e: lload 1
      // 6f: invokestatic x/oc3b42959d05.ү (JJ)J
      // 72: lstore 6
      // 74: lload 6
      // 76: lconst_0
      // 77: iload 3
      // 78: ifne 90
      // 7b: lcmp
      // 7c: ifle a0
      // 7f: goto 83
      // 82: athrow
      // 83: lload 6
      // 85: ldc2_w 3767998224694679180
      // 88: ldc2_w 3767998224694548108
      // 8b: lxor
      // 8c: goto 90
      // 8f: athrow
      // 90: lcmp
      // 91: iload 3
      // 92: ifne 9d
      // 95: ifge a0
      // 98: goto 9c
      // 9b: athrow
      // 9c: bipush 1
      // 9d: goto a1
      // a0: bipush 0
      // a1: ireturn
   }

   static int Μ(int param0, int param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: iload 0
      // 04: invokestatic java/lang/Math.abs (I)I
      // 07: istore 3
      // 08: istore 2
      // 09: iload 3
      // 0a: iload 2
      // 0b: ifne 2b
      // 0e: ifeq 26
      // 11: goto 15
      // 14: athrow
      // 15: iload 1
      // 16: iload 2
      // 17: ifne 30
      // 1a: goto 1e
      // 1d: athrow
      // 1e: bipush -1
      // 1f: if_icmpne 2c
      // 22: goto 26
      // 25: athrow
      // 26: iload 3
      // 27: goto 2b
      // 2a: athrow
      // 2b: ireturn
      // 2c: iload 1
      // 2d: invokestatic java/lang/Math.abs (I)I
      // 30: istore 4
      // 32: iload 4
      // 34: iload 2
      // 35: ifne 50
      // 38: ifne 42
      // 3b: goto 3f
      // 3e: athrow
      // 3f: bipush 1
      // 40: ireturn
      // 41: athrow
      // 42: iload 3
      // 43: iload 2
      // 44: ifne 58
      // 47: iload 4
      // 49: invokestatic x/oc3b42959d05.և (II)I
      // 4c: goto 50
      // 4f: athrow
      // 50: bipush 1
      // 51: if_icmpne 57
      // 54: iload 3
      // 55: ireturn
      // 56: athrow
      // 57: bipush 1
      // 58: istore 5
      // 5a: iload 5
      // 5c: ldc_w -12121121
      // 5f: ldc_w -12121185
      // 62: ixor
      // 63: if_icmpgt bc
      // 66: iload 3
      // 67: iload 5
      // 69: isub
      // 6a: iload 2
      // 6b: ifne bd
      // 6e: istore 6
      // 70: iload 6
      // 72: iload 2
      // 73: ifne 9c
      // 76: ifle 98
      // 79: goto 7d
      // 7c: athrow
      // 7d: iload 6
      // 7f: iload 4
      // 81: invokestatic x/oc3b42959d05.և (II)I
      // 84: iload 2
      // 85: ifne 9c
      // 88: goto 8c
      // 8b: athrow
      // 8c: bipush 1
      // 8d: if_icmpne 98
      // 90: goto 94
      // 93: athrow
      // 94: iload 6
      // 96: ireturn
      // 97: athrow
      // 98: iload 3
      // 99: iload 5
      // 9b: iadd
      // 9c: istore 7
      // 9e: iload 2
      // 9f: ifne b8
      // a2: iload 7
      // a4: iload 4
      // a6: invokestatic x/oc3b42959d05.և (II)I
      // a9: bipush 1
      // aa: if_icmpne b5
      // ad: goto b1
      // b0: athrow
      // b1: iload 7
      // b3: ireturn
      // b4: athrow
      // b5: iinc 5 1
      // b8: iload 2
      // b9: ifeq 5a
      // bc: iload 3
      // bd: ireturn
   }

   static int և(int var0, int var1) {
      int var10000 = oc84f20a0bc5.ė;
      int var3 = Math.abs(var0);
      int var2 = var10000;
      int var4 = Math.abs(var1);

      while (true) {
         if (var4 != 0) {
            var10000 = var3;
            if (var2 != 0) {
               break;
            }

            int var5 = var3 % var4;
            var3 = var4;
            var4 = var5;
            if (var2 == 0) {
               continue;
            }
         }

         var10000 = var3;
         break;
      }

      return var10000;
   }

   private static int Ћ(float var0, float var1) {
      float var2 = œ(var1);
      return Math.max(0, Math.round(Math.abs(var0) / var2));
   }

   private static float œ(float param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: fload 0
      // 04: invokestatic java/lang/Math.abs (F)F
      // 07: fstore 2
      // 08: istore 1
      // 09: fload 2
      // 0a: iload 1
      // 0b: ifne 1d
      // 0e: invokestatic java/lang/Float.isNaN (F)Z
      // 11: ifne 46
      // 14: goto 18
      // 17: athrow
      // 18: fload 2
      // 19: goto 1d
      // 1c: athrow
      // 1d: iload 1
      // 1e: ifne 30
      // 21: invokestatic java/lang/Float.isInfinite (F)Z
      // 24: ifne 46
      // 27: goto 2b
      // 2a: athrow
      // 2b: fload 2
      // 2c: goto 30
      // 2f: athrow
      // 30: iload 1
      // 31: ifne 43
      // 34: ldc 1.0E-4
      // 36: fcmpl
      // 37: ifle 46
      // 3a: goto 3e
      // 3d: athrow
      // 3e: fload 2
      // 3f: goto 43
      // 42: athrow
      // 43: goto 48
      // 46: ldc 0.15
      // 48: freturn
   }

   static boolean Ȋ(BlockPos param0, EnumFacing param1, MovingObjectPosition param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 3
      // 04: aload 0
      // 05: ifnull 7a
      // 08: aload 1
      // 09: ifnull 7a
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 2
      // 11: iload 3
      // 12: ifne 21
      // 15: goto 19
      // 18: athrow
      // 19: ifnull 7a
      // 1c: goto 20
      // 1f: athrow
      // 20: aload 2
      // 21: iload 3
      // 22: ifne 3b
      // 25: getfield net/minecraft/util/MovingObjectPosition.typeOfHit Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 28: getstatic net/minecraft/util/MovingObjectPosition$MovingObjectType.BLOCK Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 2b: if_acmpne 7a
      // 2e: goto 32
      // 31: athrow
      // 32: aload 2
      // 33: iload 3
      // 34: ifne 4a
      // 37: goto 3b
      // 3a: athrow
      // 3b: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 3e: ifnull 7a
      // 41: aload 2
      // 42: iload 3
      // 43: ifne 59
      // 46: goto 4a
      // 49: athrow
      // 4a: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 4d: aload 0
      // 4e: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 51: ifeq 7a
      // 54: aload 2
      // 55: goto 59
      // 58: athrow
      // 59: getfield net/minecraft/util/MovingObjectPosition.sideHit Lnet/minecraft/util/EnumFacing;
      // 5c: iload 3
      // 5d: ifne 6f
      // 60: getstatic net/minecraft/util/EnumFacing.UP Lnet/minecraft/util/EnumFacing;
      // 63: if_acmpne 75
      // 66: goto 6a
      // 69: athrow
      // 6a: aload 1
      // 6b: goto 6f
      // 6e: athrow
      // 6f: getstatic net/minecraft/util/EnumFacing.UP Lnet/minecraft/util/EnumFacing;
      // 72: if_acmpne 7a
      // 75: bipush 1
      // 76: goto 7b
      // 79: athrow
      // 7a: bipush 0
      // 7b: ireturn
   }

   private boolean ƒ(MovingObjectPosition var1) {
      return ʄ(this.ʸ, this.ý, var1);
   }

   static boolean ʄ(BlockPos param0, EnumFacing param1, MovingObjectPosition param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 0
      // 01: aload 1
      // 02: aload 2
      // 03: invokestatic x/oc3b42959d05.Ȋ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;Lnet/minecraft/util/MovingObjectPosition;)Z
      // 06: ifeq 1a
      // 09: aload 2
      // 0a: getfield net/minecraft/util/MovingObjectPosition.sideHit Lnet/minecraft/util/EnumFacing;
      // 0d: aload 1
      // 0e: if_acmpne 1a
      // 11: goto 15
      // 14: athrow
      // 15: bipush 1
      // 16: goto 1b
      // 19: athrow
      // 1a: bipush 0
      // 1b: ireturn
   }

   private static float Ǝ(float var0, float var1, float var2) {
      float var3 = MathHelper.wrapAngleTo180_float(var1 - var0);
      var3 = Math.max(-var2, Math.min(var2, var3));
      return var0 + var3;
   }

   // $VF: Irreducible bytecode was duplicated to produce valid code
   private static float W(float var0, float var1) {
      int var2 = oc84f20a0bc5.ė;

      while (true) {
         float var10000;
         if (var0 - var1 < -180.0F) {
            var10000 = var0;
            if (var2 == 0) {
               var0 += 360.0F;
               if (var2 == 0) {
                  continue;
               }

               var10000 = var0 - var1;
            }
         } else {
            var10000 = var0 - var1;
         }

         while (true) {
            try {
               if (!(var10000 >= 180.0F)) {
                  return var0;
               }

               var10000 = var0;
               if (var2 != 0) {
                  return var0;
               }
            } catch (ocbde1165e4e var3) {
               throw var3;
            }

            var0 = var10000 - 360.0F;
            if (var2 != 0) {
               return var0;
            }

            var10000 = var0 - var1;
         }
      }
   }

   // $VF: Irreducible bytecode was duplicated to produce valid code
   private static float љ(float var0, float var1) {
      int var2 = oc84f20a0bc5.ė;

      while (true) {
         float var10000;
         if (var0 - var1 < -180.0F) {
            var10000 = var0 + 360.0F;
            if (var2 == 0) {
               var0 = var10000;
               if (var2 == 0) {
                  continue;
               }

               var10000 = var0 - var1;
            }
         } else {
            var10000 = var0 - var1;
         }

         while (true) {
            try {
               if (!(var10000 >= 180.0F)) {
                  return var0;
               }

               var10000 = var0;
               if (var2 != 0) {
                  return var0;
               }
            } catch (ocbde1165e4e var3) {
               throw var3;
            }

            var0 = var10000 - 360.0F;
            if (var2 != 0) {
               return var0;
            }

            var10000 = var0 - var1;
         }
      }
   }

   private static double Ȉ(double var0, double var2, double var4, double var6, double var8, double var10) {
      double var12 = var6 - var0;
      double var14 = var8 - var2;
      double var16 = var10 - var4;
      return var12 * var12 + var14 * var14 + var16 * var16;
   }

   private static double Ơ(double var0, double var2, double var4) {
      return Math.max(var2, Math.min(var4, var0));
   }

   static {
      EnumFacing[] var10000 = new EnumFacing[704301771 ^ 704301774];
      var10000[0] = EnumFacing.UP;
      var10000[1] = EnumFacing.EAST;
      var10000[704301772 ^ 704301774] = EnumFacing.WEST;
      var10000[704301773 ^ 704301774] = EnumFacing.SOUTH;
      var10000[704301770 ^ 704301774] = EnumFacing.NORTH;
      Γ = var10000;
      double[] var0 = new double[704301767 ^ 704301774];
      var0[0] = 0.1;
      var0[1] = 0.2;
      var0[704301772 ^ 704301774] = 0.3;
      var0[704301773 ^ 704301774] = 0.4;
      var0[704301770 ^ 704301774] = 0.5;
      var0[704301771 ^ 704301774] = 0.6;
      var0[704301768 ^ 704301774] = 0.7;
      var0[704301769 ^ 704301774] = 0.8;
      var0[704301766 ^ 704301774] = 0.9;
      ͽ = var0;
   }
}

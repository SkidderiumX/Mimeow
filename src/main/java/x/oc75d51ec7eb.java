package x;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;

public class oc75d51ec7eb implements ocda171fe5d8 {
   public static float ț;
   public static float ų;
   public static float ŏ;
   public static float к;
   public static float[] d;
   public static Float[] Ӟ;
   public static boolean ħ;
   private static final double ɩ = 0.05;
   private static final int ʞ = 30;
   private static final float н = 180.0F;
   public static int ϩ;

   public static float Ā(float var0, float var1) {
      return var1 + MathHelper.wrapAngleTo180_float(var0 - var1);
   }

   public static double ʟ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 0
      // 04: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 07: iload 0
      // 08: ifne 1b
      // 0b: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 0e: ifnonnull 18
      // 11: goto 15
      // 14: athrow
      // 15: dconst_0
      // 16: dreturn
      // 17: athrow
      // 18: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 1b: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 1e: getfield net/minecraft/client/settings/GameSettings.mouseSensitivity F
      // 21: ldc 0.6
      // 23: fmul
      // 24: ldc 0.2
      // 26: fadd
      // 27: fstore 1
      // 28: fload 1
      // 29: fload 1
      // 2a: fmul
      // 2b: fload 1
      // 2c: fmul
      // 2d: ldc 8.0
      // 2f: fmul
      // 30: f2d
      // 31: ldc2_w 0.15
      // 34: dmul
      // 35: dreturn
   }

   public static void č(float var0, float var1) {
      Float[] var10000 = new Float[-753195071 ^ -753195069];
      var10000[0] = var0;
      var10000[1] = var1;
      Ӟ = var10000;
      ħ = true;
   }

   public static void օ(float var0) {
      ocda171fe5d8.ǔ.thePlayer.rotationYawHead = var0;
   }

   public static float[] Ҵ(BlockPos var0, float var1, float var2) {
      float[] var3 = В(var0);
      return Ĩ(var3[0], var3[1], var1, var2);
   }

   public static float[] Ʊ(BlockPos var0, EnumFacing var1, float var2, float var3) {
      float[] var4 = ԃ(var0, var1);
      return Ĩ(var4[0], var4[1], var2, var3);
   }

   public static float[] В(BlockPos var0) {
      double var1 = var0.getX() + 0.45 - ocda171fe5d8.ǔ.thePlayer.posX;
      double var3 = var0.getY() + 0.45 - (ocda171fe5d8.ǔ.thePlayer.posY + ocda171fe5d8.ǔ.thePlayer.getEyeHeight());
      double var5 = var0.getZ() + 0.45 - ocda171fe5d8.ǔ.thePlayer.posZ;
      float var7 = (float)(Math.atan2(var5, var1) * (180.0 / Math.PI)) - 90.0F;
      float var8 = MathHelper.wrapAngleTo180_float(var7 - ocda171fe5d8.ǔ.thePlayer.rotationYaw);
      float var9 = ocda171fe5d8.ǔ.thePlayer.rotationYaw + var8;
      double var10 = MathHelper.sqrt_double(var1 * var1 + var5 * var5);
      float var12 = (float)(-(Math.atan2(var3, var10) * (180.0 / Math.PI)));
      float var13 = MathHelper.wrapAngleTo180_float(var12 - ocda171fe5d8.ǔ.thePlayer.rotationPitch);
      float var14 = ocda171fe5d8.ǔ.thePlayer.rotationPitch + var13;
      var14 = À(var14);
      float[] var10000 = new float[-438532299 ^ -438532297];
      var10000[0] = var9;
      var10000[1] = var14;
      return var10000;
   }

   public static float[] ό(double var0, double var2, double var4) {
      double var6 = var0 + 1.0 - ocda171fe5d8.ǔ.thePlayer.posX;
      double var8 = var2 + 1.0 - (ocda171fe5d8.ǔ.thePlayer.posY + ocda171fe5d8.ǔ.thePlayer.getEyeHeight());
      double var10 = var4 + 1.0 - ocda171fe5d8.ǔ.thePlayer.posZ;
      float var12 = (float)(Math.atan2(var10, var6) * (180.0 / Math.PI)) - 90.0F;
      float var13 = MathHelper.wrapAngleTo180_float(var12 - ocda171fe5d8.ǔ.thePlayer.rotationYaw);
      float var14 = ocda171fe5d8.ǔ.thePlayer.rotationYaw + var13;
      double var15 = MathHelper.sqrt_double(var6 * var6 + var10 * var10);
      float var17 = (float)(-(Math.atan2(var8, var15) * (180.0 / Math.PI)));
      float var18 = MathHelper.wrapAngleTo180_float(var17 - ocda171fe5d8.ǔ.thePlayer.rotationPitch);
      float var19 = ocda171fe5d8.ǔ.thePlayer.rotationPitch + var18;
      var19 = À(var19);
      float[] var10000 = new float[-947932916 ^ -947932914];
      var10000[0] = var14;
      var10000[1] = var19;
      return var10000;
   }

   public static float[] Ǯ(Vec3 var0) {
      double var1 = var0.xCoord + 1.0 - ocda171fe5d8.ǔ.thePlayer.posX;
      double var3 = var0.yCoord + 1.0 - (ocda171fe5d8.ǔ.thePlayer.posY + ocda171fe5d8.ǔ.thePlayer.getEyeHeight());
      double var5 = var0.zCoord + 1.0 - ocda171fe5d8.ǔ.thePlayer.posZ;
      float var7 = (float)(Math.atan2(var5, var1) * (180.0 / Math.PI)) - 90.0F;
      float var8 = MathHelper.wrapAngleTo180_float(var7 - ocda171fe5d8.ǔ.thePlayer.rotationYaw);
      float var9 = ocda171fe5d8.ǔ.thePlayer.rotationYaw + var8;
      double var10 = MathHelper.sqrt_double(var1 * var1 + var5 * var5);
      float var12 = (float)(-(Math.atan2(var3, var10) * (180.0 / Math.PI)));
      float var13 = MathHelper.wrapAngleTo180_float(var12 - ocda171fe5d8.ǔ.thePlayer.rotationPitch);
      float var14 = ocda171fe5d8.ǔ.thePlayer.rotationPitch + var13;
      var14 = À(var14);
      float[] var10000 = new float[991692814 ^ 991692812];
      var10000[0] = var9;
      var10000[1] = var14;
      return var10000;
   }

   public static float[] Ӄ(Entity param0, float param1, float param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: aload 0
      // 04: invokestatic x/oc75d51ec7eb.ɭ (Lnet/minecraft/entity/Entity;)[F
      // 07: astore 4
      // 09: istore 3
      // 0a: aload 4
      // 0c: iload 3
      // 0d: ifne 27
      // 10: ifnonnull 1a
      // 13: goto 17
      // 16: athrow
      // 17: aconst_null
      // 18: areturn
      // 19: athrow
      // 1a: aload 4
      // 1c: bipush 0
      // 1d: faload
      // 1e: aload 4
      // 20: bipush 1
      // 21: faload
      // 22: fload 1
      // 23: fload 2
      // 24: invokestatic x/oc75d51ec7eb.Ĩ (FFFF)[F
      // 27: areturn
   }

   public static float[] ԃ(BlockPos var0, EnumFacing var1) {
      int var10000 = ϩ;
      double var3 = var0.getX() + 0.45 - ocda171fe5d8.ǔ.thePlayer.posX;
      int var2 = var10000;
      double var5 = var0.getY() + 0.45 - (ocda171fe5d8.ǔ.thePlayer.posY + ocda171fe5d8.ǔ.thePlayer.getEyeHeight());
      var10000 = var2;
      double var7 = var0.getZ() + 0.45 - ocda171fe5d8.ǔ.thePlayer.posZ;

      label21: {
         label20: {
            try {
               if (var10000 != 0) {
                  break label20;
               }

               if (var1 == null) {
                  break label21;
               }
            } catch (ocbde1165e4e var13) {
               throw var13;
            }

            var3 += var1.getDirectionVec().getX() * 0.5;
            var5 += var1.getDirectionVec().getY() * 0.5;
         }

         var7 += var1.getDirectionVec().getZ() * 0.5;
      }

      double var9 = MathHelper.sqrt_double(var3 * var3 + var7 * var7);
      float var11 = (float)(Math.atan2(var7, var3) * (float) (180.0 / Math.PI)) - 90.0F;
      float var12 = (float)(-(Math.atan2(var5, var9) * (float) (180.0 / Math.PI)));
      float[] var15 = new float[-34841208 ^ -34841206];
      var15[0] = ocda171fe5d8.ǔ.thePlayer.rotationYaw + MathHelper.wrapAngleTo180_float(var11 - ocda171fe5d8.ǔ.thePlayer.rotationYaw);
      var15[1] = À(ocda171fe5d8.ǔ.thePlayer.rotationPitch + MathHelper.wrapAngleTo180_float(var12 - ocda171fe5d8.ǔ.thePlayer.rotationPitch));
      return var15;
   }

   public static double ҷ(Entity var0, boolean var1) {
      int var2 = ϩ;

      float var10000;
      boolean var10001;
      label27: {
         try {
            var10000 = Ǔ(var0.posX, var0.posZ);
            var10001 = var1;
            if (var2 != 0) {
               break label27;
            }

            if (!var1) {
               return Math.abs(MathHelper.wrapAngleTo180_double(var10000 - ocda171fe5d8.ǔ.thePlayer.rotationYaw));
            }
         } catch (ocbde1165e4e var4) {
            throw var4;
         }

         var10001 = oc25aa89b91f.ű();
      }

      try {
         if (var10001) {
            return Math.abs(MathHelper.wrapAngleTo180_double(var10000 - ŏ));
         }
      } catch (ocbde1165e4e var3) {
         throw var3;
      }

      return Math.abs(MathHelper.wrapAngleTo180_double(var10000 - ocda171fe5d8.ǔ.thePlayer.rotationYaw));
   }

   public static float Ǔ(double var0, double var2) {
      return (float)(Math.atan2(var0 - ocda171fe5d8.ǔ.thePlayer.posX, var2 - ocda171fe5d8.ǔ.thePlayer.posZ) * (float) (180.0 / Math.PI) * -1.0);
   }

   public static boolean ȃ(Entity param0, double param1, float[] param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 003: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 006: fconst_1
      // 007: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 00a: astore 5
      // 00c: aload 3
      // 00d: bipush 0
      // 00e: faload
      // 00f: fstore 6
      // 011: getstatic x/oc75d51ec7eb.ϩ I
      // 014: aload 3
      // 015: bipush 1
      // 016: faload
      // 017: fstore 7
      // 019: fload 6
      // 01b: fneg
      // 01c: ldc 0.017453292
      // 01e: fmul
      // 01f: ldc 3.1415927
      // 021: fsub
      // 022: fstore 8
      // 024: fload 7
      // 026: fneg
      // 027: ldc 0.017453292
      // 029: fmul
      // 02a: fstore 9
      // 02c: istore 4
      // 02e: fload 8
      // 030: invokestatic net/minecraft/util/MathHelper.cos (F)F
      // 033: fstore 10
      // 035: fload 8
      // 037: invokestatic net/minecraft/util/MathHelper.sin (F)F
      // 03a: fstore 11
      // 03c: fload 9
      // 03e: invokestatic net/minecraft/util/MathHelper.cos (F)F
      // 041: fneg
      // 042: fstore 12
      // 044: fload 9
      // 046: invokestatic net/minecraft/util/MathHelper.sin (F)F
      // 049: fstore 13
      // 04b: new net/minecraft/util/Vec3
      // 04e: dup
      // 04f: fload 11
      // 051: fload 12
      // 053: fmul
      // 054: f2d
      // 055: fload 13
      // 057: f2d
      // 058: fload 10
      // 05a: fload 12
      // 05c: fmul
      // 05d: f2d
      // 05e: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 061: astore 14
      // 063: aload 14
      // 065: getfield net/minecraft/util/Vec3.xCoord D
      // 068: dload 1
      // 069: dmul
      // 06a: dstore 15
      // 06c: aload 14
      // 06e: getfield net/minecraft/util/Vec3.yCoord D
      // 071: dload 1
      // 072: dmul
      // 073: dstore 17
      // 075: aload 14
      // 077: getfield net/minecraft/util/Vec3.zCoord D
      // 07a: dload 1
      // 07b: dmul
      // 07c: dstore 19
      // 07e: aload 5
      // 080: dload 15
      // 082: dload 17
      // 084: dload 19
      // 086: invokevirtual net/minecraft/util/Vec3.addVector (DDD)Lnet/minecraft/util/Vec3;
      // 089: astore 21
      // 08b: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 08e: invokevirtual net/minecraft/client/Minecraft.getRenderViewEntity ()Lnet/minecraft/entity/Entity;
      // 091: astore 22
      // 093: aload 22
      // 095: invokevirtual net/minecraft/entity/Entity.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 098: dload 15
      // 09a: dload 17
      // 09c: dload 19
      // 09e: invokevirtual net/minecraft/util/AxisAlignedBB.addCoord (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 0a1: dconst_1
      // 0a2: dconst_1
      // 0a3: dconst_1
      // 0a4: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 0a7: astore 23
      // 0a9: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 0ac: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 0af: aload 22
      // 0b1: aload 23
      // 0b3: invokevirtual net/minecraft/client/multiplayer/WorldClient.getEntitiesWithinAABBExcludingEntity (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/AxisAlignedBB;)Ljava/util/List;
      // 0b6: astore 24
      // 0b8: aload 24
      // 0ba: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 0bf: astore 25
      // 0c1: aload 25
      // 0c3: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0c8: ifeq 135
      // 0cb: aload 25
      // 0cd: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0d2: checkcast net/minecraft/entity/Entity
      // 0d5: astore 26
      // 0d7: aload 26
      // 0d9: iload 4
      // 0db: ifne 0ec
      // 0de: aload 0
      // 0df: if_acmpne 130
      // 0e2: goto 0e6
      // 0e5: athrow
      // 0e6: aload 26
      // 0e8: goto 0ec
      // 0eb: athrow
      // 0ec: iload 4
      // 0ee: ifne 101
      // 0f1: invokevirtual net/minecraft/entity/Entity.canBeCollidedWith ()Z
      // 0f4: ifeq 130
      // 0f7: goto 0fb
      // 0fa: athrow
      // 0fb: aload 26
      // 0fd: goto 101
      // 100: athrow
      // 101: invokevirtual net/minecraft/entity/Entity.getCollisionBorderSize ()F
      // 104: fstore 27
      // 106: aload 26
      // 108: invokevirtual net/minecraft/entity/Entity.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 10b: fload 27
      // 10d: f2d
      // 10e: fload 27
      // 110: f2d
      // 111: fload 27
      // 113: f2d
      // 114: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 117: astore 28
      // 119: aload 28
      // 11b: aload 5
      // 11d: aload 21
      // 11f: invokevirtual net/minecraft/util/AxisAlignedBB.calculateIntercept (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/MovingObjectPosition;
      // 122: astore 29
      // 124: aload 29
      // 126: ifnull 12e
      // 129: bipush 1
      // 12a: goto 12f
      // 12d: athrow
      // 12e: bipush 0
      // 12f: ireturn
      // 130: iload 4
      // 132: ifeq 0c1
      // 135: bipush 0
      // 136: ireturn
   }

   public static boolean Չ(BlockPos var0, double var1) {
      float[] var3 = В(var0);
      Vec3 var4 = ocda171fe5d8.ǔ.thePlayer.getPositionEyes(1.0F);
      float var5 = -var3[0] * (float) (Math.PI / 180.0);
      float var6 = -var3[1] * (float) (Math.PI / 180.0);
      float var7 = MathHelper.cos(var5 - (float) Math.PI);
      float var8 = MathHelper.sin(var5 - (float) Math.PI);
      float var9 = -MathHelper.cos(var6);
      Vec3 var10 = new Vec3(var8 * var9, MathHelper.sin(var6), var7 * var9);
      Block var11 = occb1ed1ed8f.ϛ(var0);
      IBlockState var12 = occb1ed1ed8f.О(var0);

      try {
         if (var11 == null || var12 == null) {
            return false;
         }
      } catch (ocbde1165e4e var17) {
         throw var17;
      }

      AxisAlignedBB var13 = var11.getCollisionBoundingBox(ocda171fe5d8.ǔ.theWorld, var0, var12);
      if (var13 != null) {
         Vec3 var14 = var4.addVector(var10.xCoord * var1, var10.yCoord * var1, var10.zCoord * var1);
         MovingObjectPosition var15 = var13.calculateIntercept(var4, var14);

         try {
            if (var15 != null) {
               return true;
            }
         } catch (ocbde1165e4e var16) {
            throw var16;
         }
      }

      return false;
   }

   public static float[] ɭ(Entity var0) {
      return ѧ(var0, oc210a0247ba.Ƒ);
   }

   public static float[] ѧ(Entity param0, oc210a0247ba param1) {
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
      // 005: iload 2
      // 006: ifne 014
      // 009: ifnonnull 013
      // 00c: goto 010
      // 00f: athrow
      // 010: aconst_null
      // 011: areturn
      // 012: athrow
      // 013: aload 0
      // 014: getfield net/minecraft/entity/Entity.posX D
      // 017: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 01a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 01d: getfield net/minecraft/client/entity/EntityPlayerSP.posX D
      // 020: dsub
      // 021: dstore 3
      // 022: aload 0
      // 023: getfield net/minecraft/entity/Entity.posZ D
      // 026: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 029: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 02c: getfield net/minecraft/client/entity/EntityPlayerSP.posZ D
      // 02f: dsub
      // 030: dstore 5
      // 032: aload 0
      // 033: iload 2
      // 034: ifne 073
      // 037: instanceof net/minecraft/entity/EntityLivingBase
      // 03a: ifeq 072
      // 03d: goto 041
      // 040: athrow
      // 041: aload 0
      // 042: checkcast net/minecraft/entity/EntityLivingBase
      // 045: astore 9
      // 047: iload 2
      // 048: aload 9
      // 04a: getfield net/minecraft/entity/EntityLivingBase.posY D
      // 04d: aload 1
      // 04e: aload 9
      // 050: invokevirtual x/oc210a0247ba.у (Lnet/minecraft/entity/Entity;)D
      // 053: ldc2_w 0.9
      // 056: dmul
      // 057: dadd
      // 058: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 05b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 05e: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // 061: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 064: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 067: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getEyeHeight ()F
      // 06a: f2d
      // 06b: dadd
      // 06c: dsub
      // 06d: dstore 7
      // 06f: ifeq 09c
      // 072: aload 0
      // 073: invokevirtual net/minecraft/entity/Entity.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 076: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 079: aload 0
      // 07a: invokevirtual net/minecraft/entity/Entity.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 07d: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 080: dadd
      // 081: ldc2_w 2.0
      // 084: ddiv
      // 085: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 088: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 08b: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // 08e: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 091: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 094: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getEyeHeight ()F
      // 097: f2d
      // 098: dadd
      // 099: dsub
      // 09a: dstore 7
      // 09c: ldc_w 966860114
      // 09f: ldc_w 966860112
      // 0a2: ixor
      // 0a3: newarray 6
      // 0a5: dup
      // 0a6: bipush 0
      // 0a7: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 0aa: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0ad: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 0b0: dload 5
      // 0b2: dload 3
      // 0b3: invokestatic java/lang/Math.atan2 (DD)D
      // 0b6: ldc2_w 57.295780181884766
      // 0b9: dmul
      // 0ba: d2f
      // 0bb: ldc 90.0
      // 0bd: fsub
      // 0be: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 0c1: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0c4: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 0c7: fsub
      // 0c8: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_float (F)F
      // 0cb: fadd
      // 0cc: fastore
      // 0cd: dup
      // 0ce: bipush 1
      // 0cf: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 0d2: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0d5: getfield net/minecraft/client/entity/EntityPlayerSP.rotationPitch F
      // 0d8: dload 7
      // 0da: dload 3
      // 0db: dload 3
      // 0dc: dmul
      // 0dd: dload 5
      // 0df: dload 5
      // 0e1: dmul
      // 0e2: dadd
      // 0e3: invokestatic net/minecraft/util/MathHelper.sqrt_double (D)F
      // 0e6: f2d
      // 0e7: invokestatic java/lang/Math.atan2 (DD)D
      // 0ea: ldc2_w 57.295780181884766
      // 0ed: dmul
      // 0ee: dneg
      // 0ef: d2f
      // 0f0: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 0f3: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0f6: getfield net/minecraft/client/entity/EntityPlayerSP.rotationPitch F
      // 0f9: fsub
      // 0fa: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_float (F)F
      // 0fd: fadd
      // 0fe: ldc_w 3.0
      // 101: fadd
      // 102: invokestatic x/oc75d51ec7eb.À (F)F
      // 105: fastore
      // 106: areturn
   }

   public static float[] я(double var0, double var2, double var4) {
      return ƺ(var0, var2, var4, ocda171fe5d8.ǔ.thePlayer.rotationYaw, ocda171fe5d8.ǔ.thePlayer.rotationPitch);
   }

   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static float[] ƺ(double var0, double var2, double var4, float var6, float var7) {
      double var9 = var0 - ocda171fe5d8.ǔ.thePlayer.posX;
      int var10000 = ϩ;
      double var11 = var4 - ocda171fe5d8.ǔ.thePlayer.posZ;
      double var13 = var2 - (ocda171fe5d8.ǔ.thePlayer.posY + ocda171fe5d8.ǔ.thePlayer.getEyeHeight());
      int var8 = var10000;
      double var15 = var9 * var9 + var11 * var11;

      float var17;
      float var18;
      label33: {
         label32: {
            label37: {
               try {
                  var26 = var15;
                  if (var8 != 0) {
                     break label32;
                  }

                  if (!(var15 < 1.0E-12)) {
                     break label37;
                  }
               } catch (ocbde1165e4e var24) {
                  throw var24;
               }

               var17 = var6;
               var10000 = var8;
               var18 = (float)(-(Math.atan2(var13, 0.0) * (float) (180.0 / Math.PI)));

               try {
                  if (var10000 == 0) {
                     break label33;
                  }
               } catch (ocbde1165e4e var23) {
                  throw var23;
               }
            }

            try {
               var26 = Math.atan2(var11, var9) * (float) (180.0 / Math.PI);
            } catch (ocbde1165e4e var22) {
               throw var22;
            }
         }

         float var19 = (float)var26 - 90.0F;
         var17 = var6 + MathHelper.wrapAngleTo180_float(var19 - var6);
         double var20 = MathHelper.sqrt_double(var15);
         var18 = (float)(-(Math.atan2(var13, var20) * (float) (180.0 / Math.PI)));
      }

      float var25 = var7 + MathHelper.wrapAngleTo180_float(var18 - var7) + 3.0F;
      float[] var28 = new float[-2101980135 ^ -2101980133];
      var28[0] = var17;
      var28[1] = À(var25);
      return var28;
   }

   public static float[] ϙ(Entity param0, double param1, double param3, float param5, float param6) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: aload 0
      // 04: dload 1
      // 05: dload 3
      // 06: invokestatic x/oc75d51ec7eb.қ (Lnet/minecraft/entity/Entity;DD)Lnet/minecraft/util/Vec3;
      // 09: astore 8
      // 0b: istore 7
      // 0d: aload 8
      // 0f: iload 7
      // 11: ifne 20
      // 14: ifnonnull 1e
      // 17: goto 1b
      // 1a: athrow
      // 1b: aconst_null
      // 1c: areturn
      // 1d: athrow
      // 1e: aload 8
      // 20: getfield net/minecraft/util/Vec3.xCoord D
      // 23: aload 8
      // 25: getfield net/minecraft/util/Vec3.yCoord D
      // 28: aload 8
      // 2a: getfield net/minecraft/util/Vec3.zCoord D
      // 2d: fload 5
      // 2f: fload 6
      // 31: invokestatic x/oc75d51ec7eb.ƺ (DDDFF)[F
      // 34: areturn
   }

   public static Vec3 қ(Entity param0, double param1, double param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 5
      // 005: aload 0
      // 006: ifnull 01f
      // 009: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 00c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 00f: iload 5
      // 011: ifne 023
      // 014: goto 018
      // 017: athrow
      // 018: ifnonnull 022
      // 01b: goto 01f
      // 01e: athrow
      // 01f: aconst_null
      // 020: areturn
      // 021: athrow
      // 022: aload 0
      // 023: invokevirtual net/minecraft/entity/Entity.getCollisionBorderSize ()F
      // 026: fstore 6
      // 028: aload 0
      // 029: invokevirtual net/minecraft/entity/Entity.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 02c: fload 6
      // 02e: f2d
      // 02f: fload 6
      // 031: f2d
      // 032: fload 6
      // 034: f2d
      // 035: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 038: astore 7
      // 03a: aload 7
      // 03c: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 03f: aload 7
      // 041: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 044: dadd
      // 045: ldc2_w 2.0
      // 048: ddiv
      // 049: dstore 8
      // 04b: aload 0
      // 04c: iload 5
      // 04e: ifne 060
      // 051: instanceof net/minecraft/entity/EntityLivingBase
      // 054: ifeq 073
      // 057: goto 05b
      // 05a: athrow
      // 05b: aload 0
      // 05c: goto 060
      // 05f: athrow
      // 060: getfield net/minecraft/entity/Entity.posY D
      // 063: aload 0
      // 064: checkcast net/minecraft/entity/EntityLivingBase
      // 067: invokevirtual net/minecraft/entity/EntityLivingBase.getEyeHeight ()F
      // 06a: f2d
      // 06b: dadd
      // 06c: dstore 10
      // 06e: iload 5
      // 070: ifeq 084
      // 073: aload 7
      // 075: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 078: aload 7
      // 07a: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 07d: dadd
      // 07e: ldc2_w 2.0
      // 081: ddiv
      // 082: dstore 10
      // 084: aload 7
      // 086: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 089: aload 7
      // 08b: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 08e: dadd
      // 08f: ldc2_w 2.0
      // 092: ddiv
      // 093: dstore 12
      // 095: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 098: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 09b: fconst_1
      // 09c: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 09f: astore 14
      // 0a1: aload 7
      // 0a3: iload 5
      // 0a5: ifne 0c8
      // 0a8: aload 14
      // 0aa: invokevirtual net/minecraft/util/AxisAlignedBB.isVecInside (Lnet/minecraft/util/Vec3;)Z
      // 0ad: ifeq 0c6
      // 0b0: goto 0b4
      // 0b3: athrow
      // 0b4: new net/minecraft/util/Vec3
      // 0b7: dup
      // 0b8: dload 8
      // 0ba: aload 14
      // 0bc: getfield net/minecraft/util/Vec3.yCoord D
      // 0bf: dload 12
      // 0c1: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 0c4: areturn
      // 0c5: athrow
      // 0c6: aload 7
      // 0c8: aload 14
      // 0ca: invokestatic x/oc75d51ec7eb.Ϋ (Lnet/minecraft/util/AxisAlignedBB;Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/Vec3;
      // 0cd: astore 15
      // 0cf: dconst_0
      // 0d0: dconst_1
      // 0d1: dload 1
      // 0d2: ldc2_w 100.0
      // 0d5: ddiv
      // 0d6: invokestatic java/lang/Math.min (DD)D
      // 0d9: invokestatic java/lang/Math.max (DD)D
      // 0dc: dstore 16
      // 0de: dconst_0
      // 0df: dconst_1
      // 0e0: dload 3
      // 0e1: ldc2_w 100.0
      // 0e4: ddiv
      // 0e5: invokestatic java/lang/Math.min (DD)D
      // 0e8: invokestatic java/lang/Math.max (DD)D
      // 0eb: dstore 18
      // 0ed: dload 8
      // 0ef: aload 15
      // 0f1: getfield net/minecraft/util/Vec3.xCoord D
      // 0f4: dload 8
      // 0f6: dsub
      // 0f7: dload 16
      // 0f9: dmul
      // 0fa: dadd
      // 0fb: dstore 20
      // 0fd: dload 10
      // 0ff: aload 15
      // 101: getfield net/minecraft/util/Vec3.yCoord D
      // 104: dload 10
      // 106: dsub
      // 107: dload 18
      // 109: dmul
      // 10a: dadd
      // 10b: dstore 22
      // 10d: dload 12
      // 10f: aload 15
      // 111: getfield net/minecraft/util/Vec3.zCoord D
      // 114: dload 12
      // 116: dsub
      // 117: dload 16
      // 119: dmul
      // 11a: dadd
      // 11b: dstore 24
      // 11d: new net/minecraft/util/Vec3
      // 120: dup
      // 121: dload 20
      // 123: dload 22
      // 125: dload 24
      // 127: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 12a: areturn
   }

   public static Vec3 Ϋ(AxisAlignedBB var0, Vec3 var1) {
      double var2 = Math.max(var0.minX, Math.min(var0.maxX, var1.xCoord));
      double var4 = Math.max(var0.minY, Math.min(var0.maxY, var1.yCoord));
      double var6 = Math.max(var0.minZ, Math.min(var0.maxZ, var1.zCoord));
      return new Vec3(var2, var4, var6);
   }

   public static List<Vec3> Ŷ(Entity param0, Vec3 param1) {
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
      // 005: ifnull 01d
      // 008: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 00b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 00e: iload 2
      // 00f: ifne 027
      // 012: goto 016
      // 015: athrow
      // 016: ifnonnull 026
      // 019: goto 01d
      // 01c: athrow
      // 01d: new java/util/ArrayList
      // 020: dup
      // 021: invokespecial java/util/ArrayList.<init> ()V
      // 024: areturn
      // 025: athrow
      // 026: aload 0
      // 027: invokevirtual net/minecraft/entity/Entity.getCollisionBorderSize ()F
      // 02a: fstore 3
      // 02b: aload 0
      // 02c: invokevirtual net/minecraft/entity/Entity.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 02f: fload 3
      // 030: f2d
      // 031: fload 3
      // 032: f2d
      // 033: fload 3
      // 034: f2d
      // 035: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 038: astore 4
      // 03a: aload 4
      // 03c: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 03f: aload 4
      // 041: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 044: dsub
      // 045: dstore 5
      // 047: aload 4
      // 049: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 04c: aload 4
      // 04e: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 051: dsub
      // 052: dstore 7
      // 054: aload 4
      // 056: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 059: aload 4
      // 05b: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 05e: dsub
      // 05f: dstore 9
      // 061: aload 1
      // 062: getfield net/minecraft/util/Vec3.xCoord D
      // 065: aload 4
      // 067: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 06a: dcmpl
      // 06b: iload 2
      // 06c: ifne 077
      // 06f: ifle 07a
      // 072: goto 076
      // 075: athrow
      // 076: bipush 1
      // 077: goto 07b
      // 07a: bipush 0
      // 07b: istore 11
      // 07d: aload 1
      // 07e: getfield net/minecraft/util/Vec3.xCoord D
      // 081: aload 4
      // 083: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 086: dcmpg
      // 087: iload 2
      // 088: ifne 093
      // 08b: ifge 096
      // 08e: goto 092
      // 091: athrow
      // 092: bipush 1
      // 093: goto 097
      // 096: bipush 0
      // 097: istore 12
      // 099: aload 1
      // 09a: getfield net/minecraft/util/Vec3.yCoord D
      // 09d: aload 4
      // 09f: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 0a2: dcmpl
      // 0a3: iload 2
      // 0a4: ifne 0af
      // 0a7: ifle 0b2
      // 0aa: goto 0ae
      // 0ad: athrow
      // 0ae: bipush 1
      // 0af: goto 0b3
      // 0b2: bipush 0
      // 0b3: istore 13
      // 0b5: aload 1
      // 0b6: getfield net/minecraft/util/Vec3.yCoord D
      // 0b9: aload 4
      // 0bb: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 0be: dcmpg
      // 0bf: iload 2
      // 0c0: ifne 0cb
      // 0c3: ifge 0ce
      // 0c6: goto 0ca
      // 0c9: athrow
      // 0ca: bipush 1
      // 0cb: goto 0cf
      // 0ce: bipush 0
      // 0cf: istore 14
      // 0d1: aload 1
      // 0d2: getfield net/minecraft/util/Vec3.zCoord D
      // 0d5: aload 4
      // 0d7: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 0da: dcmpl
      // 0db: iload 2
      // 0dc: ifne 0e7
      // 0df: ifle 0ea
      // 0e2: goto 0e6
      // 0e5: athrow
      // 0e6: bipush 1
      // 0e7: goto 0eb
      // 0ea: bipush 0
      // 0eb: istore 15
      // 0ed: aload 1
      // 0ee: getfield net/minecraft/util/Vec3.zCoord D
      // 0f1: aload 4
      // 0f3: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 0f6: dcmpg
      // 0f7: iload 2
      // 0f8: ifne 103
      // 0fb: ifge 106
      // 0fe: goto 102
      // 101: athrow
      // 102: bipush 1
      // 103: goto 107
      // 106: bipush 0
      // 107: istore 16
      // 109: iload 11
      // 10b: iload 2
      // 10c: ifne 128
      // 10f: ifne 127
      // 112: goto 116
      // 115: athrow
      // 116: iload 12
      // 118: iload 2
      // 119: ifne 128
      // 11c: goto 120
      // 11f: athrow
      // 120: ifeq 12b
      // 123: goto 127
      // 126: athrow
      // 127: bipush 1
      // 128: goto 12c
      // 12b: bipush 0
      // 12c: iload 13
      // 12e: iload 2
      // 12f: ifne 14b
      // 132: ifne 14a
      // 135: goto 139
      // 138: athrow
      // 139: iload 14
      // 13b: iload 2
      // 13c: ifne 14b
      // 13f: goto 143
      // 142: athrow
      // 143: ifeq 14e
      // 146: goto 14a
      // 149: athrow
      // 14a: bipush 1
      // 14b: goto 14f
      // 14e: bipush 0
      // 14f: iadd
      // 150: iload 15
      // 152: iload 2
      // 153: ifne 16f
      // 156: ifne 16e
      // 159: goto 15d
      // 15c: athrow
      // 15d: iload 16
      // 15f: iload 2
      // 160: ifne 16f
      // 163: goto 167
      // 166: athrow
      // 167: ifeq 172
      // 16a: goto 16e
      // 16d: athrow
      // 16e: bipush 1
      // 16f: goto 173
      // 172: bipush 0
      // 173: iadd
      // 174: istore 17
      // 176: iload 17
      // 178: iload 2
      // 179: ifne 196
      // 17c: ifne 18c
      // 17f: goto 183
      // 182: athrow
      // 183: new java/util/ArrayList
      // 186: dup
      // 187: invokespecial java/util/ArrayList.<init> ()V
      // 18a: areturn
      // 18b: athrow
      // 18c: ldc_w 1370567470
      // 18f: ldc_w 1370567472
      // 192: ixor
      // 193: iload 17
      // 195: idiv
      // 196: istore 18
      // 198: new java/util/ArrayList
      // 19b: dup
      // 19c: ldc_w 1370567444
      // 19f: ldc_w 1370567472
      // 1a2: ixor
      // 1a3: invokespecial java/util/ArrayList.<init> (I)V
      // 1a6: astore 19
      // 1a8: iload 11
      // 1aa: iload 2
      // 1ab: ifne 1c8
      // 1ae: ifne 1c6
      // 1b1: goto 1b5
      // 1b4: athrow
      // 1b5: iload 12
      // 1b7: iload 2
      // 1b8: ifne 217
      // 1bb: goto 1bf
      // 1be: athrow
      // 1bf: ifeq 215
      // 1c2: goto 1c6
      // 1c5: athrow
      // 1c6: iload 11
      // 1c8: ifeq 1d8
      // 1cb: aload 4
      // 1cd: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 1d0: ldc2_w 0.05
      // 1d3: dsub
      // 1d4: goto 1e1
      // 1d7: athrow
      // 1d8: aload 4
      // 1da: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 1dd: ldc2_w 0.05
      // 1e0: dadd
      // 1e1: dstore 20
      // 1e3: aload 19
      // 1e5: bipush 0
      // 1e6: dload 20
      // 1e8: aload 4
      // 1ea: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 1ed: ldc2_w 0.05
      // 1f0: dadd
      // 1f1: aload 4
      // 1f3: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 1f6: ldc2_w 0.05
      // 1f9: dsub
      // 1fa: aload 4
      // 1fc: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 1ff: ldc2_w 0.05
      // 202: dadd
      // 203: aload 4
      // 205: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 208: ldc2_w 0.05
      // 20b: dsub
      // 20c: iload 18
      // 20e: dload 7
      // 210: dload 9
      // 212: invokestatic x/oc75d51ec7eb.Ȼ (Ljava/util/List;IDDDDDIDD)V
      // 215: iload 13
      // 217: iload 2
      // 218: ifne 235
      // 21b: ifne 233
      // 21e: goto 222
      // 221: athrow
      // 222: iload 14
      // 224: iload 2
      // 225: ifne 284
      // 228: goto 22c
      // 22b: athrow
      // 22c: ifeq 282
      // 22f: goto 233
      // 232: athrow
      // 233: iload 13
      // 235: ifeq 245
      // 238: aload 4
      // 23a: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 23d: ldc2_w 0.05
      // 240: dsub
      // 241: goto 24e
      // 244: athrow
      // 245: aload 4
      // 247: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 24a: ldc2_w 0.05
      // 24d: dadd
      // 24e: dstore 20
      // 250: aload 19
      // 252: bipush 1
      // 253: dload 20
      // 255: aload 4
      // 257: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 25a: ldc2_w 0.05
      // 25d: dadd
      // 25e: aload 4
      // 260: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 263: ldc2_w 0.05
      // 266: dsub
      // 267: aload 4
      // 269: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 26c: ldc2_w 0.05
      // 26f: dadd
      // 270: aload 4
      // 272: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 275: ldc2_w 0.05
      // 278: dsub
      // 279: iload 18
      // 27b: dload 5
      // 27d: dload 9
      // 27f: invokestatic x/oc75d51ec7eb.Ȼ (Ljava/util/List;IDDDDDIDD)V
      // 282: iload 15
      // 284: iload 2
      // 285: ifne 2a2
      // 288: ifne 2a0
      // 28b: goto 28f
      // 28e: athrow
      // 28f: iload 16
      // 291: iload 2
      // 292: ifne 2a2
      // 295: goto 299
      // 298: athrow
      // 299: ifeq 2f5
      // 29c: goto 2a0
      // 29f: athrow
      // 2a0: iload 15
      // 2a2: ifeq 2b2
      // 2a5: aload 4
      // 2a7: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 2aa: ldc2_w 0.05
      // 2ad: dsub
      // 2ae: goto 2bb
      // 2b1: athrow
      // 2b2: aload 4
      // 2b4: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 2b7: ldc2_w 0.05
      // 2ba: dadd
      // 2bb: dstore 20
      // 2bd: aload 19
      // 2bf: ldc_w 1370567474
      // 2c2: ldc_w 1370567472
      // 2c5: ixor
      // 2c6: dload 20
      // 2c8: aload 4
      // 2ca: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 2cd: ldc2_w 0.05
      // 2d0: dadd
      // 2d1: aload 4
      // 2d3: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 2d6: ldc2_w 0.05
      // 2d9: dsub
      // 2da: aload 4
      // 2dc: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 2df: ldc2_w 0.05
      // 2e2: dadd
      // 2e3: aload 4
      // 2e5: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 2e8: ldc2_w 0.05
      // 2eb: dsub
      // 2ec: iload 18
      // 2ee: dload 5
      // 2f0: dload 7
      // 2f2: invokestatic x/oc75d51ec7eb.Ȼ (Ljava/util/List;IDDDDDIDD)V
      // 2f5: aload 19
      // 2f7: areturn
   }

   private static void Ȼ(
      List<Vec3> param0, int param1, double param2, double param4, double param6, double param8, double param10, int param12, double param13, double param15
   ) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 17
      // 005: dload 13
      // 007: iload 17
      // 009: ifne 03a
      // 00c: ldc2_w 1.0E-4
      // 00f: dcmpg
      // 010: iflt 02d
      // 013: goto 017
      // 016: athrow
      // 017: dload 15
      // 019: iload 17
      // 01b: ifne 0be
      // 01e: goto 022
      // 021: athrow
      // 022: ldc2_w 1.0E-4
      // 025: dcmpg
      // 026: ifge 0b9
      // 029: goto 02d
      // 02c: athrow
      // 02d: dload 4
      // 02f: dload 6
      // 031: dadd
      // 032: ldc2_w 2.0
      // 035: ddiv
      // 036: goto 03a
      // 039: athrow
      // 03a: dstore 18
      // 03c: iload 17
      // 03e: dload 8
      // 040: dload 10
      // 042: dadd
      // 043: ldc2_w 2.0
      // 046: ddiv
      // 047: dstore 20
      // 049: ifne 080
      // 04c: iload 1
      // 04d: tableswitch 107 0 2 28 56 84
      // 068: athrow
      // 069: aload 0
      // 06a: new net/minecraft/util/Vec3
      // 06d: dup
      // 06e: dload 2
      // 06f: dload 18
      // 071: dload 20
      // 073: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 076: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 07b: pop
      // 07c: goto 080
      // 07f: athrow
      // 080: iload 17
      // 082: ifeq 0b8
      // 085: aload 0
      // 086: new net/minecraft/util/Vec3
      // 089: dup
      // 08a: dload 18
      // 08c: dload 2
      // 08d: dload 20
      // 08f: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 092: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 097: pop
      // 098: iload 17
      // 09a: ifeq 0b8
      // 09d: goto 0a1
      // 0a0: athrow
      // 0a1: aload 0
      // 0a2: new net/minecraft/util/Vec3
      // 0a5: dup
      // 0a6: dload 18
      // 0a8: dload 20
      // 0aa: dload 2
      // 0ab: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 0ae: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 0b3: pop
      // 0b4: goto 0b8
      // 0b7: athrow
      // 0b8: return
      // 0b9: dload 13
      // 0bb: dload 15
      // 0bd: ddiv
      // 0be: dstore 18
      // 0c0: ldc_w -858684366
      // 0c3: ldc_w -858684368
      // 0c6: ixor
      // 0c7: iload 12
      // 0c9: i2d
      // 0ca: dload 18
      // 0cc: dmul
      // 0cd: invokestatic java/lang/Math.sqrt (D)D
      // 0d0: invokestatic java/lang/Math.round (D)J
      // 0d3: l2i
      // 0d4: invokestatic java/lang/Math.max (II)I
      // 0d7: istore 20
      // 0d9: ldc_w -858684366
      // 0dc: ldc_w -858684368
      // 0df: ixor
      // 0e0: iload 12
      // 0e2: i2d
      // 0e3: dload 18
      // 0e5: ddiv
      // 0e6: invokestatic java/lang/Math.sqrt (D)D
      // 0e9: invokestatic java/lang/Math.round (D)J
      // 0ec: l2i
      // 0ed: invokestatic java/lang/Math.max (II)I
      // 0f0: istore 21
      // 0f2: bipush 0
      // 0f3: istore 22
      // 0f5: iload 22
      // 0f7: iload 20
      // 0f9: if_icmpge 1b4
      // 0fc: dload 4
      // 0fe: dload 6
      // 100: dload 4
      // 102: dsub
      // 103: iload 22
      // 105: i2d
      // 106: dmul
      // 107: iload 20
      // 109: bipush 1
      // 10a: isub
      // 10b: i2d
      // 10c: ddiv
      // 10d: dadd
      // 10e: dstore 23
      // 110: bipush 0
      // 111: istore 25
      // 113: iload 25
      // 115: iload 21
      // 117: if_icmpge 1ac
      // 11a: dload 8
      // 11c: dload 10
      // 11e: dload 8
      // 120: iload 17
      // 122: ifne 10c
      // 125: dsub
      // 126: iload 25
      // 128: i2d
      // 129: dmul
      // 12a: iload 21
      // 12c: bipush 1
      // 12d: isub
      // 12e: i2d
      // 12f: ddiv
      // 130: dadd
      // 131: dstore 26
      // 133: iload 17
      // 135: ifne 1a7
      // 138: iload 1
      // 139: tableswitch 107 0 2 28 56 84
      // 154: athrow
      // 155: aload 0
      // 156: new net/minecraft/util/Vec3
      // 159: dup
      // 15a: dload 2
      // 15b: dload 23
      // 15d: dload 26
      // 15f: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 162: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 167: pop
      // 168: iload 17
      // 16a: ifeq 1a4
      // 16d: goto 171
      // 170: athrow
      // 171: aload 0
      // 172: new net/minecraft/util/Vec3
      // 175: dup
      // 176: dload 23
      // 178: dload 2
      // 179: dload 26
      // 17b: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 17e: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 183: pop
      // 184: iload 17
      // 186: ifeq 1a4
      // 189: goto 18d
      // 18c: athrow
      // 18d: aload 0
      // 18e: new net/minecraft/util/Vec3
      // 191: dup
      // 192: dload 23
      // 194: dload 26
      // 196: dload 2
      // 197: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 19a: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 19f: pop
      // 1a0: goto 1a4
      // 1a3: athrow
      // 1a4: iinc 25 1
      // 1a7: iload 17
      // 1a9: ifeq 113
      // 1ac: iinc 22 1
      // 1af: iload 17
      // 1b1: ifeq 0f5
      // 1b4: return
   }

   public static double Ώ(Entity param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 1
      // 04: aload 0
      // 05: ifnull 1d
      // 08: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 0b: iload 1
      // 0c: ifne 25
      // 0f: goto 13
      // 12: athrow
      // 13: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 16: ifnonnull 22
      // 19: goto 1d
      // 1c: athrow
      // 1d: ldc2_w 1.7976931348623157E308
      // 20: dreturn
      // 21: athrow
      // 22: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 25: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 28: fconst_1
      // 29: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 2c: astore 2
      // 2d: aload 0
      // 2e: invokevirtual net/minecraft/entity/Entity.getCollisionBorderSize ()F
      // 31: fstore 3
      // 32: aload 0
      // 33: invokevirtual net/minecraft/entity/Entity.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 36: fload 3
      // 37: f2d
      // 38: fload 3
      // 39: f2d
      // 3a: fload 3
      // 3b: f2d
      // 3c: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 3f: astore 4
      // 41: aload 4
      // 43: aload 2
      // 44: invokestatic x/oc75d51ec7eb.Ϋ (Lnet/minecraft/util/AxisAlignedBB;Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/Vec3;
      // 47: astore 5
      // 49: aload 2
      // 4a: getfield net/minecraft/util/Vec3.xCoord D
      // 4d: aload 5
      // 4f: getfield net/minecraft/util/Vec3.xCoord D
      // 52: dsub
      // 53: dstore 6
      // 55: aload 2
      // 56: getfield net/minecraft/util/Vec3.yCoord D
      // 59: aload 5
      // 5b: getfield net/minecraft/util/Vec3.yCoord D
      // 5e: dsub
      // 5f: dstore 8
      // 61: aload 2
      // 62: getfield net/minecraft/util/Vec3.zCoord D
      // 65: aload 5
      // 67: getfield net/minecraft/util/Vec3.zCoord D
      // 6a: dsub
      // 6b: dstore 10
      // 6d: dload 6
      // 6f: dload 6
      // 71: dmul
      // 72: dload 8
      // 74: dload 8
      // 76: dmul
      // 77: dadd
      // 78: dload 10
      // 7a: dload 10
      // 7c: dmul
      // 7d: dadd
      // 7e: dreturn
   }

   public static double Ŭ(Entity param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: aload 0
      // 04: invokestatic x/oc75d51ec7eb.Ώ (Lnet/minecraft/entity/Entity;)D
      // 07: dstore 2
      // 08: istore 1
      // 09: dload 2
      // 0a: iload 1
      // 0b: ifne 21
      // 0e: ldc2_w 1.7976931348623157E308
      // 11: dcmpl
      // 12: ifne 20
      // 15: goto 19
      // 18: athrow
      // 19: ldc2_w 1.7976931348623157E308
      // 1c: goto 24
      // 1f: athrow
      // 20: dload 2
      // 21: invokestatic java/lang/Math.sqrt (D)D
      // 24: dreturn
   }

   public static double Ĵ(Entity var0) {
      return Ŭ(var0);
   }

   public static float ɟ(Entity param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 1
      // 04: aload 0
      // 05: ifnull 1d
      // 08: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 0b: iload 1
      // 0c: ifne 25
      // 0f: goto 13
      // 12: athrow
      // 13: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 16: ifnonnull 22
      // 19: goto 1d
      // 1c: athrow
      // 1d: ldc_w 3.4028235E38
      // 20: freturn
      // 21: athrow
      // 22: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 25: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 28: fconst_1
      // 29: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 2c: astore 2
      // 2d: aload 0
      // 2e: invokevirtual net/minecraft/entity/Entity.getCollisionBorderSize ()F
      // 31: fstore 3
      // 32: aload 0
      // 33: invokevirtual net/minecraft/entity/Entity.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 36: fload 3
      // 37: f2d
      // 38: fload 3
      // 39: f2d
      // 3a: fload 3
      // 3b: f2d
      // 3c: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 3f: astore 4
      // 41: aload 4
      // 43: aload 2
      // 44: invokevirtual net/minecraft/util/AxisAlignedBB.isVecInside (Lnet/minecraft/util/Vec3;)Z
      // 47: ifeq 4d
      // 4a: fconst_0
      // 4b: freturn
      // 4c: athrow
      // 4d: aload 0
      // 4e: getfield net/minecraft/entity/Entity.posX D
      // 51: aload 2
      // 52: getfield net/minecraft/util/Vec3.xCoord D
      // 55: dsub
      // 56: dstore 5
      // 58: aload 0
      // 59: getfield net/minecraft/entity/Entity.posZ D
      // 5c: aload 2
      // 5d: getfield net/minecraft/util/Vec3.zCoord D
      // 60: dsub
      // 61: dstore 7
      // 63: dload 7
      // 65: dload 5
      // 67: invokestatic java/lang/Math.atan2 (DD)D
      // 6a: invokestatic java/lang/Math.toDegrees (D)D
      // 6d: d2f
      // 6e: ldc 90.0
      // 70: fsub
      // 71: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 74: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 77: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 7a: fsub
      // 7b: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_float (F)F
      // 7e: invokestatic java/lang/Math.abs (F)F
      // 81: fconst_2
      // 82: fmul
      // 83: freturn
   }

   public static float[] Ɔ(AxisAlignedBB param0, float param1, float param2, float param3, float param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 06: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 09: fconst_1
      // 0a: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 0d: astore 6
      // 0f: aload 0
      // 10: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 13: ldc2_w 0.05
      // 16: aload 0
      // 17: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 1a: aload 0
      // 1b: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 1e: dsub
      // 1f: dmul
      // 20: dadd
      // 21: dstore 7
      // 23: aload 0
      // 24: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 27: ldc2_w 0.75
      // 2a: aload 0
      // 2b: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 2e: aload 0
      // 2f: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 32: dsub
      // 33: dmul
      // 34: dadd
      // 35: dstore 9
      // 37: istore 5
      // 39: aload 0
      // 3a: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 3d: aload 0
      // 3e: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 41: dadd
      // 42: ldc2_w 2.0
      // 45: ddiv
      // 46: aload 6
      // 48: getfield net/minecraft/util/Vec3.xCoord D
      // 4b: dsub
      // 4c: dstore 11
      // 4e: aload 6
      // 50: iload 5
      // 52: ifne 70
      // 55: getfield net/minecraft/util/Vec3.yCoord D
      // 58: dload 9
      // 5a: dcmpl
      // 5b: iflt 6e
      // 5e: goto 62
      // 61: athrow
      // 62: dload 9
      // 64: aload 6
      // 66: getfield net/minecraft/util/Vec3.yCoord D
      // 69: dsub
      // 6a: goto 92
      // 6d: athrow
      // 6e: aload 6
      // 70: getfield net/minecraft/util/Vec3.yCoord D
      // 73: iload 5
      // 75: ifne 8e
      // 78: dload 7
      // 7a: dcmpg
      // 7b: ifgt 91
      // 7e: goto 82
      // 81: athrow
      // 82: dload 7
      // 84: aload 6
      // 86: getfield net/minecraft/util/Vec3.yCoord D
      // 89: dsub
      // 8a: goto 8e
      // 8d: athrow
      // 8e: goto 92
      // 91: dconst_0
      // 92: dstore 13
      // 94: aload 0
      // 95: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 98: aload 0
      // 99: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 9c: dadd
      // 9d: ldc2_w 2.0
      // a0: ddiv
      // a1: aload 6
      // a3: getfield net/minecraft/util/Vec3.zCoord D
      // a6: dsub
      // a7: dstore 15
      // a9: dload 11
      // ab: dload 13
      // ad: dload 15
      // af: fload 1
      // b0: fload 2
      // b1: fload 3
      // b2: fload 4
      // b4: invokestatic x/oc75d51ec7eb.ĕ (DDDFFFF)[F
      // b7: areturn
   }

   public static float[] ĕ(double param0, double param2, double param4, float param6, float param7, float param8, float param9) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: dload 0
      // 04: dload 0
      // 05: dmul
      // 06: dload 4
      // 08: dload 4
      // 0a: dmul
      // 0b: dadd
      // 0c: invokestatic java/lang/Math.sqrt (D)D
      // 0f: dstore 11
      // 11: istore 10
      // 13: dload 4
      // 15: dload 0
      // 16: invokestatic java/lang/Math.atan2 (DD)D
      // 19: invokestatic java/lang/Math.toDegrees (D)D
      // 1c: d2f
      // 1d: ldc 90.0
      // 1f: fsub
      // 20: fload 6
      // 22: fsub
      // 23: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_float (F)F
      // 26: fstore 13
      // 28: dload 2
      // 29: dload 11
      // 2b: invokestatic java/lang/Math.atan2 (DD)D
      // 2e: invokestatic java/lang/Math.toDegrees (D)D
      // 31: dneg
      // 32: d2f
      // 33: fload 7
      // 35: fsub
      // 36: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_float (F)F
      // 39: fstore 14
      // 3b: fload 13
      // 3d: invokestatic java/lang/Math.abs (F)F
      // 40: iload 10
      // 42: ifne 5a
      // 45: fconst_1
      // 46: fcmpg
      // 47: ifgt 53
      // 4a: goto 4e
      // 4d: athrow
      // 4e: fconst_0
      // 4f: goto 5f
      // 52: athrow
      // 53: fload 13
      // 55: fload 8
      // 57: invokestatic x/oc75d51ec7eb.н (FF)F
      // 5a: fload 9
      // 5c: invokestatic x/oc75d51ec7eb.ɪ (FF)F
      // 5f: fstore 13
      // 61: fload 14
      // 63: iload 10
      // 65: ifne 80
      // 68: invokestatic java/lang/Math.abs (F)F
      // 6b: fconst_1
      // 6c: fcmpg
      // 6d: ifgt 79
      // 70: goto 74
      // 73: athrow
      // 74: fconst_0
      // 75: goto 85
      // 78: athrow
      // 79: fload 14
      // 7b: fload 8
      // 7d: invokestatic x/oc75d51ec7eb.н (FF)F
      // 80: fload 9
      // 82: invokestatic x/oc75d51ec7eb.ɪ (FF)F
      // 85: fstore 14
      // 87: ldc_w -551656376
      // 8a: ldc_w -551656374
      // 8d: ixor
      // 8e: newarray 6
      // 90: dup
      // 91: bipush 0
      // 92: fload 6
      // 94: fload 13
      // 96: fadd
      // 97: invokestatic x/oc75d51ec7eb.ĳ (F)F
      // 9a: fastore
      // 9b: dup
      // 9c: bipush 1
      // 9d: fload 7
      // 9f: fload 14
      // a1: fadd
      // a2: invokestatic x/oc75d51ec7eb.ĳ (F)F
      // a5: fastore
      // a6: areturn
   }

   public static float[] Ѭ(Vec3 var0) {
      Vec3 var1 = ocda171fe5d8.ǔ.thePlayer.getPositionEyes(1.0F);
      double var2 = var0.xCoord - var1.xCoord;
      double var4 = var0.yCoord - var1.yCoord;
      double var6 = var0.zCoord - var1.zCoord;
      double var8 = Math.hypot(var2, var6);
      float var10 = (float)Math.toDegrees(Math.atan2(var6, var2)) - 90.0F;
      float var11 = (float)(-Math.toDegrees(Math.atan2(var4, var8)));
      float[] var10000 = new float[1283634400 ^ 1283634402];
      var10000[0] = MathHelper.wrapAngleTo180_float(var10);
      var10000[1] = MathHelper.wrapAngleTo180_float(var11);
      return var10000;
   }

   private static float н(float var0, float var1) {
      float var2 = Math.max(0.0F, Math.min(180.0F, var1));
      return Math.max(-var2, Math.min(var2, var0));
   }

   private static float ɪ(float var0, float var1) {
      float var2 = ThreadLocalRandom.current().nextFloat() * 0.2F - 0.1F;
      float var3 = Math.max(0.0F, Math.min(1.0F, var1 + var2));
      return var0 * (0.5F + 0.5F * (1.0F - var3));
   }

   private static float ĳ(float var0) {
      return (float)(var0 - var0 % 0.0096F);
   }

   public static boolean γ(Vec3 var0, Vec3 var1, Entity var2, double var3) {
      return ц(var0, var1, var2, var3, false, true);
   }

   public static boolean ц(Vec3 param0, Vec3 param1, Entity param2, double param3, boolean param5, boolean param6) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 7
      // 005: aload 2
      // 006: ifnonnull 00c
      // 009: bipush 0
      // 00a: ireturn
      // 00b: athrow
      // 00c: aload 1
      // 00d: getfield net/minecraft/util/Vec3.xCoord D
      // 010: aload 0
      // 011: getfield net/minecraft/util/Vec3.xCoord D
      // 014: dsub
      // 015: dstore 8
      // 017: aload 1
      // 018: getfield net/minecraft/util/Vec3.yCoord D
      // 01b: aload 0
      // 01c: getfield net/minecraft/util/Vec3.yCoord D
      // 01f: dsub
      // 020: dstore 10
      // 022: aload 1
      // 023: getfield net/minecraft/util/Vec3.zCoord D
      // 026: aload 0
      // 027: getfield net/minecraft/util/Vec3.zCoord D
      // 02a: dsub
      // 02b: dstore 12
      // 02d: dload 8
      // 02f: dload 8
      // 031: dmul
      // 032: dload 10
      // 034: dload 10
      // 036: dmul
      // 037: dadd
      // 038: dload 12
      // 03a: dload 12
      // 03c: dmul
      // 03d: dadd
      // 03e: invokestatic java/lang/Math.sqrt (D)D
      // 041: dstore 14
      // 043: dload 14
      // 045: iload 7
      // 047: ifne 05c
      // 04a: ldc2_w 1.0E-6
      // 04d: dcmpg
      // 04e: ifge 058
      // 051: goto 055
      // 054: athrow
      // 055: bipush 0
      // 056: ireturn
      // 057: athrow
      // 058: dload 3
      // 059: dload 14
      // 05b: ddiv
      // 05c: dstore 16
      // 05e: new net/minecraft/util/Vec3
      // 061: dup
      // 062: aload 0
      // 063: getfield net/minecraft/util/Vec3.xCoord D
      // 066: dload 8
      // 068: dload 16
      // 06a: dmul
      // 06b: dadd
      // 06c: aload 0
      // 06d: getfield net/minecraft/util/Vec3.yCoord D
      // 070: dload 10
      // 072: dload 16
      // 074: dmul
      // 075: dadd
      // 076: aload 0
      // 077: getfield net/minecraft/util/Vec3.zCoord D
      // 07a: dload 12
      // 07c: dload 16
      // 07e: dmul
      // 07f: dadd
      // 080: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 083: astore 18
      // 085: aload 2
      // 086: invokevirtual net/minecraft/entity/Entity.getCollisionBorderSize ()F
      // 089: fstore 19
      // 08b: aload 2
      // 08c: invokevirtual net/minecraft/entity/Entity.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 08f: fload 19
      // 091: f2d
      // 092: fload 19
      // 094: f2d
      // 095: fload 19
      // 097: f2d
      // 098: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 09b: astore 20
      // 09d: aload 20
      // 09f: aload 0
      // 0a0: aload 18
      // 0a2: invokevirtual net/minecraft/util/AxisAlignedBB.calculateIntercept (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/MovingObjectPosition;
      // 0a5: astore 21
      // 0a7: aload 21
      // 0a9: ifnonnull 0af
      // 0ac: bipush 0
      // 0ad: ireturn
      // 0ae: athrow
      // 0af: aload 0
      // 0b0: aload 21
      // 0b2: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 0b5: invokevirtual net/minecraft/util/Vec3.squareDistanceTo (Lnet/minecraft/util/Vec3;)D
      // 0b8: dstore 22
      // 0ba: iload 5
      // 0bc: iload 7
      // 0be: ifne 113
      // 0c1: ifne 111
      // 0c4: goto 0c8
      // 0c7: athrow
      // 0c8: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 0cb: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 0ce: aload 0
      // 0cf: aload 18
      // 0d1: bipush 0
      // 0d2: bipush 0
      // 0d3: bipush 0
      // 0d4: invokevirtual net/minecraft/client/multiplayer/WorldClient.rayTraceBlocks (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;ZZZ)Lnet/minecraft/util/MovingObjectPosition;
      // 0d7: astore 24
      // 0d9: aload 24
      // 0db: iload 7
      // 0dd: ifne 0e9
      // 0e0: ifnull 111
      // 0e3: goto 0e7
      // 0e6: athrow
      // 0e7: aload 24
      // 0e9: getfield net/minecraft/util/MovingObjectPosition.typeOfHit Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 0ec: getstatic net/minecraft/util/MovingObjectPosition$MovingObjectType.BLOCK Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 0ef: if_acmpne 111
      // 0f2: aload 0
      // 0f3: aload 24
      // 0f5: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 0f8: invokevirtual net/minecraft/util/Vec3.squareDistanceTo (Lnet/minecraft/util/Vec3;)D
      // 0fb: dstore 25
      // 0fd: dload 25
      // 0ff: dload 22
      // 101: dcmpg
      // 102: iload 7
      // 104: ifne 113
      // 107: ifge 111
      // 10a: goto 10e
      // 10d: athrow
      // 10e: bipush 0
      // 10f: ireturn
      // 110: athrow
      // 111: iload 6
      // 113: iload 7
      // 115: ifne 13c
      // 118: ifne 13b
      // 11b: goto 11f
      // 11e: athrow
      // 11f: aload 0
      // 120: aload 18
      // 122: aload 2
      // 123: dload 22
      // 125: invokestatic x/oc75d51ec7eb.ӹ (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;Lnet/minecraft/entity/Entity;D)Z
      // 128: iload 7
      // 12a: ifne 13c
      // 12d: goto 131
      // 130: athrow
      // 131: ifeq 13b
      // 134: goto 138
      // 137: athrow
      // 138: bipush 0
      // 139: ireturn
      // 13a: athrow
      // 13b: bipush 1
      // 13c: ireturn
   }

   private static boolean ӹ(Vec3 param0, Vec3 param1, Entity param2, double param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 5
      // 005: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 008: iload 5
      // 00a: ifne 01e
      // 00d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 010: ifnull 024
      // 013: goto 017
      // 016: athrow
      // 017: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 01a: goto 01e
      // 01d: athrow
      // 01e: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 021: ifnonnull 027
      // 024: bipush 0
      // 025: ireturn
      // 026: athrow
      // 027: aload 1
      // 028: aload 0
      // 029: invokevirtual net/minecraft/util/Vec3.subtract (Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/Vec3;
      // 02c: astore 6
      // 02e: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 031: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 034: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 037: aload 6
      // 039: getfield net/minecraft/util/Vec3.xCoord D
      // 03c: aload 6
      // 03e: getfield net/minecraft/util/Vec3.yCoord D
      // 041: aload 6
      // 043: getfield net/minecraft/util/Vec3.zCoord D
      // 046: invokevirtual net/minecraft/util/AxisAlignedBB.addCoord (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 049: dconst_1
      // 04a: dconst_1
      // 04b: dconst_1
      // 04c: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 04f: astore 7
      // 051: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 054: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 057: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 05a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 05d: aload 7
      // 05f: getstatic net/minecraft/util/EntitySelectors.NOT_SPECTATING Lcom/google/common/base/Predicate;
      // 062: invokedynamic apply ()Lcom/google/common/base/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/minecraft/entity/Entity.canBeCollidedWith ()Z, (Lnet/minecraft/entity/Entity;)Z ]
      // 067: invokestatic com/google/common/base/Predicates.and (Lcom/google/common/base/Predicate;Lcom/google/common/base/Predicate;)Lcom/google/common/base/Predicate;
      // 06a: invokevirtual net/minecraft/client/multiplayer/WorldClient.getEntitiesInAABBexcluding (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/AxisAlignedBB;Lcom/google/common/base/Predicate;)Ljava/util/List;
      // 06d: astore 8
      // 06f: aload 8
      // 071: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 076: astore 9
      // 078: aload 9
      // 07a: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 07f: ifeq 127
      // 082: aload 9
      // 084: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 089: checkcast net/minecraft/entity/Entity
      // 08c: astore 10
      // 08e: aload 10
      // 090: iload 5
      // 092: ifne 09e
      // 095: ifnull 078
      // 098: goto 09c
      // 09b: athrow
      // 09c: aload 10
      // 09e: iload 5
      // 0a0: ifne 0ad
      // 0a3: aload 2
      // 0a4: if_acmpeq 078
      // 0a7: goto 0ab
      // 0aa: athrow
      // 0ab: aload 10
      // 0ad: iload 5
      // 0af: ifne 0c7
      // 0b2: getfield net/minecraft/entity/Entity.isDead Z
      // 0b5: ifeq 0c5
      // 0b8: goto 0bc
      // 0bb: athrow
      // 0bc: iload 5
      // 0be: ifeq 078
      // 0c1: goto 0c5
      // 0c4: athrow
      // 0c5: aload 10
      // 0c7: invokevirtual net/minecraft/entity/Entity.getCollisionBorderSize ()F
      // 0ca: fstore 11
      // 0cc: aload 10
      // 0ce: invokevirtual net/minecraft/entity/Entity.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 0d1: fload 11
      // 0d3: f2d
      // 0d4: fload 11
      // 0d6: f2d
      // 0d7: fload 11
      // 0d9: f2d
      // 0da: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 0dd: astore 12
      // 0df: aload 12
      // 0e1: aload 0
      // 0e2: aload 1
      // 0e3: invokevirtual net/minecraft/util/AxisAlignedBB.calculateIntercept (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/MovingObjectPosition;
      // 0e6: astore 13
      // 0e8: aload 12
      // 0ea: aload 0
      // 0eb: invokevirtual net/minecraft/util/AxisAlignedBB.isVecInside (Lnet/minecraft/util/Vec3;)Z
      // 0ee: iload 5
      // 0f0: ifne 0fb
      // 0f3: ifeq 0fc
      // 0f6: goto 0fa
      // 0f9: athrow
      // 0fa: bipush 1
      // 0fb: ireturn
      // 0fc: aload 13
      // 0fe: ifnull 122
      // 101: aload 0
      // 102: aload 13
      // 104: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 107: invokevirtual net/minecraft/util/Vec3.squareDistanceTo (Lnet/minecraft/util/Vec3;)D
      // 10a: dstore 14
      // 10c: dload 14
      // 10e: dload 3
      // 10f: ldc2_w 1.0E-7
      // 112: dsub
      // 113: dcmpg
      // 114: iload 5
      // 116: ifne 121
      // 119: ifge 122
      // 11c: goto 120
      // 11f: athrow
      // 120: bipush 1
      // 121: ireturn
      // 122: iload 5
      // 124: ifeq 078
      // 127: bipush 0
      // 128: ireturn
   }

   public static boolean ê(Vec3 param0, Vec3 param1, Entity param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 3
      // 04: aload 0
      // 05: iload 3
      // 06: ifne 11
      // 09: ifnull 1c
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 1
      // 11: ifnull 1c
      // 14: aload 2
      // 15: ifnonnull 1f
      // 18: goto 1c
      // 1b: athrow
      // 1c: bipush 0
      // 1d: ireturn
      // 1e: athrow
      // 1f: aload 0
      // 20: aload 1
      // 21: invokevirtual net/minecraft/util/Vec3.squareDistanceTo (Lnet/minecraft/util/Vec3;)D
      // 24: dstore 4
      // 26: aload 0
      // 27: aload 1
      // 28: aload 2
      // 29: dload 4
      // 2b: invokestatic x/oc75d51ec7eb.ӹ (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;Lnet/minecraft/entity/Entity;D)Z
      // 2e: ireturn
   }

   public static boolean Ӧ(Entity param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 1
      // 04: aload 0
      // 05: ifnull 1d
      // 08: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 0b: iload 1
      // 0c: ifne 23
      // 0f: goto 13
      // 12: athrow
      // 13: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 16: ifnonnull 20
      // 19: goto 1d
      // 1c: athrow
      // 1d: bipush 0
      // 1e: ireturn
      // 1f: athrow
      // 20: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 23: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 26: fconst_1
      // 27: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 2a: astore 2
      // 2b: aload 0
      // 2c: invokevirtual net/minecraft/entity/Entity.getCollisionBorderSize ()F
      // 2f: fstore 3
      // 30: aload 0
      // 31: invokevirtual net/minecraft/entity/Entity.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 34: fload 3
      // 35: f2d
      // 36: fload 3
      // 37: f2d
      // 38: fload 3
      // 39: f2d
      // 3a: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 3d: astore 4
      // 3f: aload 4
      // 41: aload 2
      // 42: invokevirtual net/minecraft/util/AxisAlignedBB.isVecInside (Lnet/minecraft/util/Vec3;)Z
      // 45: ireturn
   }

   private static boolean D(Vec3 param0, Vec3 param1, Entity param2, double param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: aload 1
      // 04: getfield net/minecraft/util/Vec3.xCoord D
      // 07: aload 0
      // 08: getfield net/minecraft/util/Vec3.xCoord D
      // 0b: dsub
      // 0c: dstore 6
      // 0e: istore 5
      // 10: aload 1
      // 11: getfield net/minecraft/util/Vec3.yCoord D
      // 14: aload 0
      // 15: getfield net/minecraft/util/Vec3.yCoord D
      // 18: dsub
      // 19: dstore 8
      // 1b: aload 1
      // 1c: getfield net/minecraft/util/Vec3.zCoord D
      // 1f: aload 0
      // 20: getfield net/minecraft/util/Vec3.zCoord D
      // 23: dsub
      // 24: dstore 10
      // 26: dload 6
      // 28: dload 6
      // 2a: dmul
      // 2b: dload 8
      // 2d: dload 8
      // 2f: dmul
      // 30: dadd
      // 31: dload 10
      // 33: dload 10
      // 35: dmul
      // 36: dadd
      // 37: invokestatic java/lang/Math.sqrt (D)D
      // 3a: dstore 12
      // 3c: dload 12
      // 3e: iload 5
      // 40: ifne 55
      // 43: ldc2_w 1.0E-6
      // 46: dcmpg
      // 47: ifge 51
      // 4a: goto 4e
      // 4d: athrow
      // 4e: bipush 0
      // 4f: ireturn
      // 50: athrow
      // 51: dload 3
      // 52: dload 12
      // 54: ddiv
      // 55: dstore 14
      // 57: new net/minecraft/util/Vec3
      // 5a: dup
      // 5b: aload 0
      // 5c: getfield net/minecraft/util/Vec3.xCoord D
      // 5f: dload 6
      // 61: dload 14
      // 63: dmul
      // 64: dadd
      // 65: aload 0
      // 66: getfield net/minecraft/util/Vec3.yCoord D
      // 69: dload 8
      // 6b: dload 14
      // 6d: dmul
      // 6e: dadd
      // 6f: aload 0
      // 70: getfield net/minecraft/util/Vec3.zCoord D
      // 73: dload 10
      // 75: dload 14
      // 77: dmul
      // 78: dadd
      // 79: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 7c: astore 16
      // 7e: aload 2
      // 7f: invokevirtual net/minecraft/entity/Entity.getCollisionBorderSize ()F
      // 82: fstore 17
      // 84: aload 2
      // 85: invokevirtual net/minecraft/entity/Entity.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 88: fload 17
      // 8a: f2d
      // 8b: fload 17
      // 8d: f2d
      // 8e: fload 17
      // 90: f2d
      // 91: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 94: astore 18
      // 96: aload 18
      // 98: aload 0
      // 99: aload 16
      // 9b: invokevirtual net/minecraft/util/AxisAlignedBB.calculateIntercept (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/MovingObjectPosition;
      // 9e: ifnull a6
      // a1: bipush 1
      // a2: goto a7
      // a5: athrow
      // a6: bipush 0
      // a7: ireturn
   }

   public static boolean G(Entity var0, double var1, double var3, double var5) {
      return Ι(var0, var1, var3, var5, false, true);
   }

   public static boolean Ι(Entity param0, double param1, double param3, double param5, boolean param7, boolean param8) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 9
      // 05: aload 0
      // 06: ifnull 1f
      // 09: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 0c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0f: iload 9
      // 11: ifne 23
      // 14: goto 18
      // 17: athrow
      // 18: ifnonnull 22
      // 1b: goto 1f
      // 1e: athrow
      // 1f: bipush 0
      // 20: ireturn
      // 21: athrow
      // 22: aload 0
      // 23: dload 1
      // 24: dload 3
      // 25: invokestatic x/oc75d51ec7eb.қ (Lnet/minecraft/entity/Entity;DD)Lnet/minecraft/util/Vec3;
      // 28: astore 10
      // 2a: aload 10
      // 2c: iload 9
      // 2e: ifne 45
      // 31: ifnonnull 3b
      // 34: goto 38
      // 37: athrow
      // 38: bipush 0
      // 39: ireturn
      // 3a: athrow
      // 3b: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 3e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 41: fconst_1
      // 42: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 45: astore 11
      // 47: aload 11
      // 49: iload 9
      // 4b: ifne 63
      // 4e: aload 10
      // 50: invokevirtual net/minecraft/util/Vec3.squareDistanceTo (Lnet/minecraft/util/Vec3;)D
      // 53: ldc2_w 1.0E-6
      // 56: dcmpg
      // 57: ifge 61
      // 5a: goto 5e
      // 5d: athrow
      // 5e: bipush 1
      // 5f: ireturn
      // 60: athrow
      // 61: aload 11
      // 63: aload 10
      // 65: iload 9
      // 67: ifne 7e
      // 6a: aload 0
      // 6b: dload 5
      // 6d: invokestatic x/oc75d51ec7eb.D (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;Lnet/minecraft/entity/Entity;D)Z
      // 70: ifne 7a
      // 73: goto 77
      // 76: athrow
      // 77: bipush 0
      // 78: ireturn
      // 79: athrow
      // 7a: aload 11
      // 7c: aload 10
      // 7e: aload 0
      // 7f: dload 5
      // 81: iload 7
      // 83: iload 8
      // 85: invokestatic x/oc75d51ec7eb.ц (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;Lnet/minecraft/entity/Entity;DZZ)Z
      // 88: iload 9
      // 8a: ifne 95
      // 8d: ifeq 96
      // 90: goto 94
      // 93: athrow
      // 94: bipush 1
      // 95: ireturn
      // 96: aload 0
      // 97: aload 11
      // 99: invokestatic x/oc75d51ec7eb.Ŷ (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/Vec3;)Ljava/util/List;
      // 9c: astore 12
      // 9e: aload 12
      // a0: aload 11
      // a2: invokedynamic applyAsDouble (Lnet/minecraft/util/Vec3;)Ljava/util/function/ToDoubleFunction; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)D, x/oc75d51ec7eb.q1xhez2e43p9f1 (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)D, (Lnet/minecraft/util/Vec3;)D ]
      // a7: invokestatic java/util/Comparator.comparingDouble (Ljava/util/function/ToDoubleFunction;)Ljava/util/Comparator;
      // aa: invokestatic java/util/Collections.sort (Ljava/util/List;Ljava/util/Comparator;)V
      // ad: aload 12
      // af: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // b4: astore 13
      // b6: aload 13
      // b8: invokeinterface java/util/Iterator.hasNext ()Z 1
      // bd: ifeq f6
      // c0: aload 13
      // c2: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // c7: checkcast net/minecraft/util/Vec3
      // ca: astore 14
      // cc: aload 11
      // ce: aload 14
      // d0: aload 0
      // d1: dload 5
      // d3: iload 7
      // d5: iload 8
      // d7: invokestatic x/oc75d51ec7eb.ц (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;Lnet/minecraft/entity/Entity;DZZ)Z
      // da: iload 9
      // dc: ifne f7
      // df: iload 9
      // e1: ifne f0
      // e4: goto e8
      // e7: athrow
      // e8: ifeq f1
      // eb: goto ef
      // ee: athrow
      // ef: bipush 1
      // f0: ireturn
      // f1: iload 9
      // f3: ifeq b6
      // f6: bipush 0
      // f7: ireturn
   }

   public static float[] Ȋ(Entity var0, double var1, double var3, float var5, float var6, double var7) {
      return ҁ(var0, var1, var3, var5, var6, var7, false, true);
   }

   public static Vec3 ӝ(Entity param0, double param1, double param3, double param5, boolean param7, boolean param8) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 9
      // 005: aload 0
      // 006: ifnull 01f
      // 009: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 00c: iload 9
      // 00e: ifne 025
      // 011: goto 015
      // 014: athrow
      // 015: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 018: ifnonnull 022
      // 01b: goto 01f
      // 01e: athrow
      // 01f: aconst_null
      // 020: areturn
      // 021: athrow
      // 022: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 025: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 028: fconst_1
      // 029: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 02c: astore 10
      // 02e: aload 0
      // 02f: invokevirtual net/minecraft/entity/Entity.getCollisionBorderSize ()F
      // 032: fstore 11
      // 034: aload 0
      // 035: invokevirtual net/minecraft/entity/Entity.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 038: fload 11
      // 03a: f2d
      // 03b: fload 11
      // 03d: f2d
      // 03e: fload 11
      // 040: f2d
      // 041: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 044: astore 12
      // 046: aload 12
      // 048: iload 9
      // 04a: ifne 05f
      // 04d: aload 10
      // 04f: invokevirtual net/minecraft/util/AxisAlignedBB.isVecInside (Lnet/minecraft/util/Vec3;)Z
      // 052: ifeq 090
      // 055: goto 059
      // 058: athrow
      // 059: aload 12
      // 05b: goto 05f
      // 05e: athrow
      // 05f: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 062: aload 12
      // 064: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 067: dadd
      // 068: ldc2_w 2.0
      // 06b: ddiv
      // 06c: dstore 13
      // 06e: aload 12
      // 070: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 073: aload 12
      // 075: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 078: dadd
      // 079: ldc2_w 2.0
      // 07c: ddiv
      // 07d: dstore 15
      // 07f: new net/minecraft/util/Vec3
      // 082: dup
      // 083: dload 13
      // 085: aload 10
      // 087: getfield net/minecraft/util/Vec3.yCoord D
      // 08a: dload 15
      // 08c: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 08f: areturn
      // 090: aload 0
      // 091: dload 1
      // 092: dload 3
      // 093: invokestatic x/oc75d51ec7eb.қ (Lnet/minecraft/entity/Entity;DD)Lnet/minecraft/util/Vec3;
      // 096: astore 13
      // 098: aload 13
      // 09a: iload 9
      // 09c: ifne 0a8
      // 09f: ifnull 0bd
      // 0a2: goto 0a6
      // 0a5: athrow
      // 0a6: aload 10
      // 0a8: iload 9
      // 0aa: ifne 0c2
      // 0ad: aload 13
      // 0af: invokevirtual net/minecraft/util/Vec3.squareDistanceTo (Lnet/minecraft/util/Vec3;)D
      // 0b2: ldc2_w 1.0E-6
      // 0b5: dcmpg
      // 0b6: ifge 0c0
      // 0b9: goto 0bd
      // 0bc: athrow
      // 0bd: aconst_null
      // 0be: areturn
      // 0bf: athrow
      // 0c0: aload 10
      // 0c2: aload 13
      // 0c4: aload 0
      // 0c5: dload 5
      // 0c7: iload 9
      // 0c9: ifne 0ea
      // 0cc: invokestatic x/oc75d51ec7eb.D (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;Lnet/minecraft/entity/Entity;D)Z
      // 0cf: ifne 0da
      // 0d2: goto 0d6
      // 0d5: athrow
      // 0d6: aload 13
      // 0d8: areturn
      // 0d9: athrow
      // 0da: aload 10
      // 0dc: iload 9
      // 0de: ifne 0fa
      // 0e1: aload 13
      // 0e3: aload 0
      // 0e4: dload 5
      // 0e6: goto 0ea
      // 0e9: athrow
      // 0ea: iload 7
      // 0ec: iload 8
      // 0ee: invokestatic x/oc75d51ec7eb.ц (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;Lnet/minecraft/entity/Entity;DZZ)Z
      // 0f1: ifeq 0fb
      // 0f4: aload 13
      // 0f6: goto 0fa
      // 0f9: athrow
      // 0fa: areturn
      // 0fb: aload 0
      // 0fc: aload 10
      // 0fe: invokestatic x/oc75d51ec7eb.Ŷ (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/Vec3;)Ljava/util/List;
      // 101: astore 14
      // 103: aload 14
      // 105: aload 10
      // 107: invokedynamic applyAsDouble (Lnet/minecraft/util/Vec3;)Ljava/util/function/ToDoubleFunction; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)D, x/oc75d51ec7eb.q1pwpuznv5eowh (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)D, (Lnet/minecraft/util/Vec3;)D ]
      // 10c: invokestatic java/util/Comparator.comparingDouble (Ljava/util/function/ToDoubleFunction;)Ljava/util/Comparator;
      // 10f: invokestatic java/util/Collections.sort (Ljava/util/List;Ljava/util/Comparator;)V
      // 112: aload 14
      // 114: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 119: astore 15
      // 11b: aload 15
      // 11d: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 122: ifeq 157
      // 125: aload 15
      // 127: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 12c: checkcast net/minecraft/util/Vec3
      // 12f: astore 16
      // 131: aload 10
      // 133: iload 9
      // 135: ifne 151
      // 138: aload 16
      // 13a: aload 0
      // 13b: dload 5
      // 13d: iload 7
      // 13f: iload 8
      // 141: invokestatic x/oc75d51ec7eb.ц (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;Lnet/minecraft/entity/Entity;DZZ)Z
      // 144: ifeq 152
      // 147: goto 14b
      // 14a: athrow
      // 14b: aload 16
      // 14d: goto 151
      // 150: athrow
      // 151: areturn
      // 152: iload 9
      // 154: ifeq 11b
      // 157: aconst_null
      // 158: areturn
   }

   public static float[] ҁ(Entity param0, double param1, double param3, float param5, float param6, double param7, boolean param9, boolean param10) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: aload 0
      // 04: dload 1
      // 05: dload 3
      // 06: dload 7
      // 08: iload 9
      // 0a: iload 10
      // 0c: invokestatic x/oc75d51ec7eb.ӝ (Lnet/minecraft/entity/Entity;DDDZZ)Lnet/minecraft/util/Vec3;
      // 0f: astore 12
      // 11: istore 11
      // 13: aload 12
      // 15: iload 11
      // 17: ifne 28
      // 1a: ifnonnull 26
      // 1d: goto 21
      // 20: athrow
      // 21: aconst_null
      // 22: goto 3c
      // 25: athrow
      // 26: aload 12
      // 28: getfield net/minecraft/util/Vec3.xCoord D
      // 2b: aload 12
      // 2d: getfield net/minecraft/util/Vec3.yCoord D
      // 30: aload 12
      // 32: getfield net/minecraft/util/Vec3.zCoord D
      // 35: fload 5
      // 37: fload 6
      // 39: invokestatic x/oc75d51ec7eb.ƺ (DDDFF)[F
      // 3c: areturn
   }

   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static float[] Ş(Entity var0, int var1) {
      int var2 = ϩ;

      try {
         if (var0 == null) {
            return null;
         }
      } catch (ocbde1165e4e var20) {
         throw var20;
      }

      try {
         if (var1 == 0) {
            return ɭ(var0);
         }
      } catch (ocbde1165e4e var23) {
         throw var23;
      }

      double var3 = var0.posX;
      double var5 = var0.posY;
      double var7 = var0.posZ;
      double var9 = var3 - var0.lastTickPosX;
      double var11 = var7 - var0.lastTickPosZ;
      int var13 = 0;

      double var10000;
      while (true) {
         if (var13 < var1) {
            var10000 = var3 + var9;
            if (var2 != 0) {
               break;
            }

            var3 = var10000;
            var7 += var11;
            var13++;
            if (var2 == 0) {
               continue;
            }
         }

         var10000 = var3 - ocda171fe5d8.ǔ.thePlayer.posX;
         break;
      }

      double var24 = var10000;

      double var15;
      label50: {
         label49: {
            label70: {
               try {
                  var25 = var0;
                  if (var2 != 0) {
                     break label49;
                  }

                  if (!(var0 instanceof EntityLivingBase)) {
                     break label70;
                  }
               } catch (ocbde1165e4e var22) {
                  throw var22;
               }

               var15 = var5 + var0.getEyeHeight() * 0.9 - (ocda171fe5d8.ǔ.thePlayer.posY + ocda171fe5d8.ǔ.thePlayer.getEyeHeight());

               try {
                  if (var2 == 0) {
                     break label50;
                  }
               } catch (ocbde1165e4e var21) {
                  throw var21;
               }
            }

            try {
               var25 = var0;
            } catch (ocbde1165e4e var19) {
               throw var19;
            }
         }

         var15 = (var25.getEntityBoundingBox().minY + var0.getEntityBoundingBox().maxY) / 2.0
            - (ocda171fe5d8.ǔ.thePlayer.posY + ocda171fe5d8.ǔ.thePlayer.getEyeHeight());
      }

      double var17 = var7 - ocda171fe5d8.ǔ.thePlayer.posZ;
      float[] var26 = new float[-1645969915 ^ -1645969913];
      var26[0] = ʥ(
         ocda171fe5d8.ǔ.thePlayer.rotationYaw
            + MathHelper.wrapAngleTo180_float((float)(Math.atan2(var17, var24) * (float) (180.0 / Math.PI)) - 90.0F - ocda171fe5d8.ǔ.thePlayer.rotationYaw)
      );
      var26[1] = À(
         ocda171fe5d8.ǔ.thePlayer.rotationPitch
            + MathHelper.wrapAngleTo180_float(
               (float)(-(Math.atan2(var15, MathHelper.sqrt_double(var24 * var24 + var17 * var17)) * (float) (180.0 / Math.PI)))
                  - ocda171fe5d8.ǔ.thePlayer.rotationPitch
            )
            + 3.0F
      );
      return var26;
   }

   public static float[] ɍ(float var0, float var1, float var2, float var3, int var4) {
      return Ĺ(var0, var1, var2, var3, var4, 0.0F);
   }

   public static float[] Ĺ(float param0, float param1, float param2, float param3, int param4, float param5) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 6
      // 005: iload 4
      // 007: iload 6
      // 009: ifne 02b
      // 00c: ifgt 029
      // 00f: goto 013
      // 012: athrow
      // 013: ldc_w -945722631
      // 016: ldc_w -945722629
      // 019: ixor
      // 01a: newarray 6
      // 01c: dup
      // 01d: bipush 0
      // 01e: fload 0
      // 01f: fastore
      // 020: dup
      // 021: bipush 1
      // 022: fload 1
      // 023: invokestatic x/oc75d51ec7eb.À (F)F
      // 026: fastore
      // 027: areturn
      // 028: athrow
      // 029: iload 4
      // 02b: iload 6
      // 02d: ifne 049
      // 030: ldc_w -945722651
      // 033: ldc_w -945722629
      // 036: ixor
      // 037: if_icmplt 057
      // 03a: goto 03e
      // 03d: athrow
      // 03e: ldc_w -945722631
      // 041: ldc_w -945722629
      // 044: ixor
      // 045: goto 049
      // 048: athrow
      // 049: newarray 6
      // 04b: dup
      // 04c: bipush 0
      // 04d: fload 2
      // 04e: fastore
      // 04f: dup
      // 050: bipush 1
      // 051: fload 3
      // 052: invokestatic x/oc75d51ec7eb.À (F)F
      // 055: fastore
      // 056: areturn
      // 057: fload 2
      // 058: fload 0
      // 059: fsub
      // 05a: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_float (F)F
      // 05d: fstore 7
      // 05f: fload 3
      // 060: fload 1
      // 061: fsub
      // 062: fstore 8
      // 064: fload 7
      // 066: fload 7
      // 068: fmul
      // 069: fload 8
      // 06b: fload 8
      // 06d: fmul
      // 06e: fadd
      // 06f: f2d
      // 070: invokestatic net/minecraft/util/MathHelper.sqrt_double (D)F
      // 073: fstore 9
      // 075: fload 9
      // 077: ldc_w 0.001
      // 07a: iload 6
      // 07c: ifne 0a3
      // 07f: fcmpg
      // 080: ifge 09d
      // 083: goto 087
      // 086: athrow
      // 087: ldc_w -945722631
      // 08a: ldc_w -945722629
      // 08d: ixor
      // 08e: newarray 6
      // 090: dup
      // 091: bipush 0
      // 092: fload 2
      // 093: fastore
      // 094: dup
      // 095: bipush 1
      // 096: fload 3
      // 097: invokestatic x/oc75d51ec7eb.À (F)F
      // 09a: fastore
      // 09b: areturn
      // 09c: athrow
      // 09d: iload 4
      // 09f: i2f
      // 0a0: ldc_w 30.0
      // 0a3: fdiv
      // 0a4: fstore 10
      // 0a6: fload 10
      // 0a8: fload 10
      // 0aa: fmul
      // 0ab: ldc 180.0
      // 0ad: fmul
      // 0ae: fstore 11
      // 0b0: ldc 0.6
      // 0b2: fload 5
      // 0b4: f2d
      // 0b5: ldc2_w 100.0
      // 0b8: ddiv
      // 0b9: d2f
      // 0ba: fmul
      // 0bb: fstore 12
      // 0bd: fload 12
      // 0bf: iload 6
      // 0c1: ifne 0da
      // 0c4: ldc_w 0.001
      // 0c7: fcmpg
      // 0c8: ifgt 0d4
      // 0cb: goto 0cf
      // 0ce: athrow
      // 0cf: fconst_1
      // 0d0: goto 0e3
      // 0d3: athrow
      // 0d4: fconst_1
      // 0d5: fload 12
      // 0d7: fconst_2
      // 0d8: fdiv
      // 0d9: fsub
      // 0da: invokestatic java/lang/Math.random ()D
      // 0dd: fload 12
      // 0df: f2d
      // 0e0: dmul
      // 0e1: d2f
      // 0e2: fadd
      // 0e3: fstore 13
      // 0e5: fload 11
      // 0e7: fload 13
      // 0e9: fmul
      // 0ea: fstore 11
      // 0ec: fconst_1
      // 0ed: fload 9
      // 0ef: ldc 180.0
      // 0f1: fdiv
      // 0f2: invokestatic java/lang/Math.min (FF)F
      // 0f5: fstore 14
      // 0f7: fload 14
      // 0f9: f2d
      // 0fa: ldc2_w 0.7
      // 0fd: invokestatic java/lang/Math.pow (DD)D
      // 100: d2f
      // 101: fstore 14
      // 103: fload 5
      // 105: f2d
      // 106: ldc2_w 100.0
      // 109: ddiv
      // 10a: d2f
      // 10b: fstore 15
      // 10d: ldc_w 0.8
      // 110: fconst_1
      // 111: fload 15
      // 113: fconst_1
      // 114: fload 14
      // 116: fsub
      // 117: fmul
      // 118: fsub
      // 119: invokestatic java/lang/Math.max (FF)F
      // 11c: fstore 16
      // 11e: fload 11
      // 120: fload 16
      // 122: fmul
      // 123: fstore 11
      // 125: fload 11
      // 127: fload 9
      // 129: invokestatic java/lang/Math.min (FF)F
      // 12c: fstore 17
      // 12e: fload 17
      // 130: fload 9
      // 132: fdiv
      // 133: fstore 18
      // 135: fload 7
      // 137: fload 18
      // 139: fmul
      // 13a: fstore 19
      // 13c: fload 8
      // 13e: fload 18
      // 140: fmul
      // 141: fstore 20
      // 143: fload 0
      // 144: fload 19
      // 146: fadd
      // 147: fstore 21
      // 149: fload 1
      // 14a: fload 20
      // 14c: fadd
      // 14d: fstore 22
      // 14f: ldc_w -945722631
      // 152: ldc_w -945722629
      // 155: ixor
      // 156: newarray 6
      // 158: dup
      // 159: bipush 0
      // 15a: fload 21
      // 15c: fastore
      // 15d: dup
      // 15e: bipush 1
      // 15f: fload 22
      // 161: invokestatic x/oc75d51ec7eb.À (F)F
      // 164: fastore
      // 165: areturn
   }

   public static float À(float var0) {
      return MathHelper.clamp_float(var0, -90.0F, 90.0F);
   }

   public static float[] Ĩ(float var0, float var1, float var2, float var3) {
      var0 = ocbb165642ef.ȥ(var0, var2);
      float var4 = var0 - var2;
      float var5 = Math.abs(var4);
      float var6 = var1 - var3;
      float var7 = ocda171fe5d8.ǔ.gameSettings.mouseSensitivity * 0.6F + 0.2F;
      double var8 = var7 * var7 * var7 * 1.2;
      float var10 = (float)(Math.round(var4 / var8) * var8);
      float var11 = (float)(Math.round(var6 / var8) * var8);
      var0 = var2 + var10;
      var1 = var3 + var11;
      float[] var10000 = new float[-1122691979 ^ -1122691977];
      var10000[0] = var0;
      var10000[1] = À(var1);
      return var10000;
   }

   public static float z(double var0, double var2) {
      return (float)(Math.atan2(var0 - ocda171fe5d8.ǔ.thePlayer.posX, var2 - ocda171fe5d8.ǔ.thePlayer.posZ) * (float) (180.0 / Math.PI) * -1.0);
   }

   public static float ŭ(double var0, double var2) {
      return (float)(Math.atan2(var0, var2) * (float) (180.0 / Math.PI) * -1.0);
   }

   public static MovingObjectPosition δ(double var0, float var2, float var3, boolean var4) {
      Vec3 var5 = ocda171fe5d8.ǔ.thePlayer.getPositionEyes(1.0F);
      float var6 = -var2 * (float) (Math.PI / 180.0);
      float var7 = -var3 * (float) (Math.PI / 180.0);
      float var8 = MathHelper.cos(var6 - (float) Math.PI);
      float var9 = MathHelper.sin(var6 - (float) Math.PI);
      float var10 = -MathHelper.cos(var7);
      Vec3 var11 = new Vec3(var9 * var10, MathHelper.sin(var7), var8 * var10);
      return ocda171fe5d8.ǔ.theWorld.rayTraceBlocks(var5, var5.addVector(var11.xCoord * var0, var11.yCoord * var0, var11.zCoord * var0), true, var4, true);
   }

   public static MovingObjectPosition ѭ(double param0, float param2, float param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 06: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 09: fconst_1
      // 0a: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 0d: astore 5
      // 0f: fload 2
      // 10: fload 3
      // 11: invokestatic x/oc7ab2161b9f.ҵ (FF)Lnet/minecraft/util/Vec3;
      // 14: astore 6
      // 16: aload 5
      // 18: aload 6
      // 1a: getfield net/minecraft/util/Vec3.xCoord D
      // 1d: dload 0
      // 1e: dmul
      // 1f: aload 6
      // 21: getfield net/minecraft/util/Vec3.yCoord D
      // 24: dload 0
      // 25: dmul
      // 26: aload 6
      // 28: getfield net/minecraft/util/Vec3.zCoord D
      // 2b: dload 0
      // 2c: dmul
      // 2d: invokevirtual net/minecraft/util/Vec3.addVector (DDD)Lnet/minecraft/util/Vec3;
      // 30: astore 7
      // 32: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 35: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 38: aload 5
      // 3a: aload 7
      // 3c: bipush 0
      // 3d: bipush 0
      // 3e: bipush 0
      // 3f: invokevirtual net/minecraft/client/multiplayer/WorldClient.rayTraceBlocks (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;ZZZ)Lnet/minecraft/util/MovingObjectPosition;
      // 42: astore 8
      // 44: istore 4
      // 46: aload 8
      // 48: iload 4
      // 4a: ifne 56
      // 4d: ifnull 68
      // 50: goto 54
      // 53: athrow
      // 54: aload 8
      // 56: iload 4
      // 58: ifne 6d
      // 5b: getfield net/minecraft/util/MovingObjectPosition.typeOfHit Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 5e: getstatic net/minecraft/util/MovingObjectPosition$MovingObjectType.BLOCK Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 61: if_acmpeq 6b
      // 64: goto 68
      // 67: athrow
      // 68: aconst_null
      // 69: areturn
      // 6a: athrow
      // 6b: aload 8
      // 6d: areturn
   }

   public static MovingObjectPosition τ(double var0, float var2, float var3) {
      Vec3 var4 = ocda171fe5d8.ǔ.thePlayer.getPositionEyes(1.0F);
      Vec3 var5 = ď(var3, var2);
      Vec3 var6 = var4.addVector(var5.xCoord * var0, var5.yCoord * var0, var5.zCoord * var0);
      return ocda171fe5d8.ǔ.theWorld.rayTraceBlocks(var4, var6, false, false, true);
   }

   public static MovingObjectPosition Ǟ(double param0, float param2, float param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 4
      // 005: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 008: iload 4
      // 00a: ifne 01e
      // 00d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 010: ifnull 024
      // 013: goto 017
      // 016: athrow
      // 017: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 01a: goto 01e
      // 01d: athrow
      // 01e: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 021: ifnonnull 027
      // 024: aconst_null
      // 025: areturn
      // 026: athrow
      // 027: dload 0
      // 028: fload 2
      // 029: fload 3
      // 02a: invokestatic x/oc75d51ec7eb.τ (DFF)Lnet/minecraft/util/MovingObjectPosition;
      // 02d: astore 5
      // 02f: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 032: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 035: fconst_1
      // 036: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 039: astore 6
      // 03b: dload 0
      // 03c: dstore 7
      // 03e: aload 5
      // 040: iload 4
      // 042: ifne 04e
      // 045: ifnull 075
      // 048: goto 04c
      // 04b: athrow
      // 04c: aload 5
      // 04e: iload 4
      // 050: ifne 066
      // 053: getfield net/minecraft/util/MovingObjectPosition.typeOfHit Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 056: getstatic net/minecraft/util/MovingObjectPosition$MovingObjectType.BLOCK Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 059: if_acmpne 075
      // 05c: goto 060
      // 05f: athrow
      // 060: aload 5
      // 062: goto 066
      // 065: athrow
      // 066: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 069: aload 6
      // 06b: invokevirtual net/minecraft/util/Vec3.distanceTo (Lnet/minecraft/util/Vec3;)D
      // 06e: dstore 7
      // 070: iload 4
      // 072: ifeq 078
      // 075: aconst_null
      // 076: areturn
      // 077: athrow
      // 078: fload 3
      // 079: fload 2
      // 07a: invokestatic x/oc75d51ec7eb.ď (FF)Lnet/minecraft/util/Vec3;
      // 07d: astore 9
      // 07f: aload 6
      // 081: aload 9
      // 083: getfield net/minecraft/util/Vec3.xCoord D
      // 086: dload 0
      // 087: dmul
      // 088: aload 9
      // 08a: getfield net/minecraft/util/Vec3.yCoord D
      // 08d: dload 0
      // 08e: dmul
      // 08f: aload 9
      // 091: getfield net/minecraft/util/Vec3.zCoord D
      // 094: dload 0
      // 095: dmul
      // 096: invokevirtual net/minecraft/util/Vec3.addVector (DDD)Lnet/minecraft/util/Vec3;
      // 099: astore 10
      // 09b: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 09e: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 0a1: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 0a4: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0a7: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 0aa: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0ad: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 0b0: aload 9
      // 0b2: getfield net/minecraft/util/Vec3.xCoord D
      // 0b5: dload 0
      // 0b6: dmul
      // 0b7: aload 9
      // 0b9: getfield net/minecraft/util/Vec3.yCoord D
      // 0bc: dload 0
      // 0bd: dmul
      // 0be: aload 9
      // 0c0: getfield net/minecraft/util/Vec3.zCoord D
      // 0c3: dload 0
      // 0c4: dmul
      // 0c5: invokevirtual net/minecraft/util/AxisAlignedBB.addCoord (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 0c8: dconst_1
      // 0c9: dconst_1
      // 0ca: dconst_1
      // 0cb: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 0ce: getstatic net/minecraft/util/EntitySelectors.NOT_SPECTATING Lcom/google/common/base/Predicate;
      // 0d1: invokedynamic apply ()Lcom/google/common/base/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/minecraft/entity/Entity.canBeCollidedWith ()Z, (Lnet/minecraft/entity/Entity;)Z ]
      // 0d6: invokestatic com/google/common/base/Predicates.and (Lcom/google/common/base/Predicate;Lcom/google/common/base/Predicate;)Lcom/google/common/base/Predicate;
      // 0d9: invokevirtual net/minecraft/client/multiplayer/WorldClient.getEntitiesInAABBexcluding (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/AxisAlignedBB;Lcom/google/common/base/Predicate;)Ljava/util/List;
      // 0dc: astore 11
      // 0de: aload 11
      // 0e0: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 0e5: astore 12
      // 0e7: aload 12
      // 0e9: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0ee: ifeq 155
      // 0f1: aload 12
      // 0f3: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0f8: checkcast net/minecraft/entity/Entity
      // 0fb: astore 13
      // 0fd: aload 13
      // 0ff: invokevirtual net/minecraft/entity/Entity.getCollisionBorderSize ()F
      // 102: fstore 14
      // 104: aload 13
      // 106: invokevirtual net/minecraft/entity/Entity.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 109: fload 14
      // 10b: f2d
      // 10c: fload 14
      // 10e: f2d
      // 10f: fload 14
      // 111: f2d
      // 112: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 115: astore 15
      // 117: aload 15
      // 119: aload 6
      // 11b: aload 10
      // 11d: invokevirtual net/minecraft/util/AxisAlignedBB.calculateIntercept (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/MovingObjectPosition;
      // 120: iload 4
      // 122: ifne 157
      // 125: astore 16
      // 127: aload 15
      // 129: aload 6
      // 12b: invokevirtual net/minecraft/util/AxisAlignedBB.isVecInside (Lnet/minecraft/util/Vec3;)Z
      // 12e: ifeq 134
      // 131: aconst_null
      // 132: areturn
      // 133: athrow
      // 134: aload 16
      // 136: ifnull 150
      // 139: aload 6
      // 13b: aload 16
      // 13d: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 140: invokevirtual net/minecraft/util/Vec3.distanceTo (Lnet/minecraft/util/Vec3;)D
      // 143: dstore 17
      // 145: dload 17
      // 147: dload 7
      // 149: dcmpg
      // 14a: ifge 150
      // 14d: aconst_null
      // 14e: areturn
      // 14f: athrow
      // 150: iload 4
      // 152: ifeq 0e7
      // 155: aload 5
      // 157: areturn
   }

   public static Vec3 ď(float var0, float var1) {
      float var2 = MathHelper.cos(-var1 * (float) (Math.PI / 180.0) - (float) Math.PI);
      float var3 = MathHelper.sin(-var1 * (float) (Math.PI / 180.0) - (float) Math.PI);
      float var4 = -MathHelper.cos(-var0 * (float) (Math.PI / 180.0));
      float var5 = MathHelper.sin(-var0 * (float) (Math.PI / 180.0));
      return new Vec3(var3 * var4, var5, var2 * var4);
   }

   public static float щ(float param0, boolean param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 2
      // 04: iload 1
      // 05: iload 2
      // 06: ifne 21
      // 09: ifeq 13
      // 0c: goto 10
      // 0f: athrow
      // 10: fload 0
      // 11: freturn
      // 12: athrow
      // 13: getstatic x/oc75d51ec7eb.d [F
      // 16: bipush 0
      // 17: faload
      // 18: ldc_w 360.0
      // 1b: fdiv
      // 1c: f2d
      // 1d: invokestatic java/lang/Math.floor (D)D
      // 20: d2i
      // 21: istore 3
      // 22: fload 0
      // 23: ldc_w 1896472286
      // 26: ldc_w 1896472502
      // 29: ixor
      // 2a: iload 3
      // 2b: imul
      // 2c: i2f
      // 2d: fadd
      // 2e: fstore 4
      // 30: fload 4
      // 32: getstatic x/oc75d51ec7eb.d [F
      // 35: bipush 0
      // 36: faload
      // 37: ldc 180.0
      // 39: iload 2
      // 3a: ifne 67
      // 3d: fsub
      // 3e: fcmpg
      // 3f: ifge 52
      // 42: goto 46
      // 45: athrow
      // 46: fload 4
      // 48: ldc_w 360.0
      // 4b: fadd
      // 4c: fstore 4
      // 4e: iload 2
      // 4f: ifeq 74
      // 52: fload 4
      // 54: getstatic x/oc75d51ec7eb.d [F
      // 57: bipush 0
      // 58: faload
      // 59: iload 2
      // 5a: ifne 7b
      // 5d: goto 61
      // 60: athrow
      // 61: ldc 180.0
      // 63: goto 67
      // 66: athrow
      // 67: fadd
      // 68: fcmpl
      // 69: ifle 74
      // 6c: fload 4
      // 6e: ldc_w 360.0
      // 71: fsub
      // 72: fstore 4
      // 74: fload 4
      // 76: getstatic x/oc75d51ec7eb.d [F
      // 79: bipush 0
      // 7a: faload
      // 7b: fsub
      // 7c: fstore 5
      // 7e: getstatic x/oc75d51ec7eb.d [F
      // 81: bipush 0
      // 82: faload
      // 83: fload 5
      // 85: fadd
      // 86: freturn
   }

   public static MovingObjectPosition Ƕ(double param0, float param2, float[] param3, EntityLivingBase param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 5
      // 005: aload 4
      // 007: ifnull 025
      // 00a: dload 0
      // 00b: fload 2
      // 00c: aload 3
      // 00d: aload 4
      // 00f: invokestatic x/oc75d51ec7eb.Ů (DF[FLnet/minecraft/entity/EntityLivingBase;)Lnet/minecraft/util/MovingObjectPosition;
      // 012: astore 6
      // 014: aload 6
      // 016: iload 5
      // 018: ifne 024
      // 01b: ifnull 025
      // 01e: goto 022
      // 021: athrow
      // 022: aload 6
      // 024: areturn
      // 025: aconst_null
      // 026: astore 6
      // 028: dload 0
      // 029: dstore 8
      // 02b: aload 3
      // 02c: iload 5
      // 02e: ifne 05d
      // 031: ifnonnull 05e
      // 034: goto 038
      // 037: athrow
      // 038: ldc_w -335737402
      // 03b: ldc_w -335737404
      // 03e: ixor
      // 03f: newarray 6
      // 041: dup
      // 042: bipush 0
      // 043: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 046: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 049: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 04c: fastore
      // 04d: dup
      // 04e: bipush 1
      // 04f: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 052: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 055: getfield net/minecraft/client/entity/EntityPlayerSP.rotationPitch F
      // 058: fastore
      // 059: goto 05d
      // 05c: athrow
      // 05d: astore 3
      // 05e: dload 8
      // 060: aload 3
      // 061: bipush 0
      // 062: faload
      // 063: aload 3
      // 064: bipush 1
      // 065: faload
      // 066: invokestatic x/oc75d51ec7eb.τ (DFF)Lnet/minecraft/util/MovingObjectPosition;
      // 069: astore 7
      // 06b: iload 5
      // 06d: dload 8
      // 06f: dstore 10
      // 071: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 074: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 077: fload 2
      // 078: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 07b: astore 12
      // 07d: ifne 095
      // 080: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 083: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 086: invokevirtual net/minecraft/client/multiplayer/PlayerControllerMP.extendedReach ()Z
      // 089: ifeq 09a
      // 08c: goto 090
      // 08f: athrow
      // 090: ldc2_w 6.0
      // 093: dstore 8
      // 095: ldc2_w 6.0
      // 098: dstore 10
      // 09a: aload 7
      // 09c: iload 5
      // 09e: ifne 0aa
      // 0a1: ifnull 0b4
      // 0a4: goto 0a8
      // 0a7: athrow
      // 0a8: aload 7
      // 0aa: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 0ad: aload 12
      // 0af: invokevirtual net/minecraft/util/Vec3.distanceTo (Lnet/minecraft/util/Vec3;)D
      // 0b2: dstore 10
      // 0b4: aload 3
      // 0b5: bipush 1
      // 0b6: faload
      // 0b7: aload 3
      // 0b8: bipush 0
      // 0b9: faload
      // 0ba: invokestatic x/oc75d51ec7eb.ď (FF)Lnet/minecraft/util/Vec3;
      // 0bd: astore 13
      // 0bf: aload 12
      // 0c1: aload 13
      // 0c3: getfield net/minecraft/util/Vec3.xCoord D
      // 0c6: dload 8
      // 0c8: dmul
      // 0c9: aload 13
      // 0cb: getfield net/minecraft/util/Vec3.yCoord D
      // 0ce: dload 8
      // 0d0: dmul
      // 0d1: aload 13
      // 0d3: getfield net/minecraft/util/Vec3.zCoord D
      // 0d6: dload 8
      // 0d8: dmul
      // 0d9: invokevirtual net/minecraft/util/Vec3.addVector (DDD)Lnet/minecraft/util/Vec3;
      // 0dc: astore 14
      // 0de: aconst_null
      // 0df: astore 15
      // 0e1: fconst_1
      // 0e2: fstore 16
      // 0e4: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 0e7: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 0ea: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 0ed: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0f0: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 0f3: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0f6: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 0f9: aload 13
      // 0fb: getfield net/minecraft/util/Vec3.xCoord D
      // 0fe: dload 8
      // 100: dmul
      // 101: aload 13
      // 103: getfield net/minecraft/util/Vec3.yCoord D
      // 106: dload 8
      // 108: dmul
      // 109: aload 13
      // 10b: getfield net/minecraft/util/Vec3.zCoord D
      // 10e: dload 8
      // 110: dmul
      // 111: invokevirtual net/minecraft/util/AxisAlignedBB.addCoord (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 114: fload 16
      // 116: f2d
      // 117: fload 16
      // 119: f2d
      // 11a: fload 16
      // 11c: f2d
      // 11d: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 120: getstatic net/minecraft/util/EntitySelectors.NOT_SPECTATING Lcom/google/common/base/Predicate;
      // 123: invokedynamic apply ()Lcom/google/common/base/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/minecraft/entity/Entity.canBeCollidedWith ()Z, (Lnet/minecraft/entity/Entity;)Z ]
      // 128: invokestatic com/google/common/base/Predicates.and (Lcom/google/common/base/Predicate;Lcom/google/common/base/Predicate;)Lcom/google/common/base/Predicate;
      // 12b: invokevirtual net/minecraft/client/multiplayer/WorldClient.getEntitiesInAABBexcluding (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/AxisAlignedBB;Lcom/google/common/base/Predicate;)Ljava/util/List;
      // 12e: astore 17
      // 130: dload 10
      // 132: dstore 18
      // 134: bipush 0
      // 135: istore 20
      // 137: iload 20
      // 139: aload 17
      // 13b: invokeinterface java/util/List.size ()I 1
      // 140: if_icmpge 25b
      // 143: aload 17
      // 145: iload 20
      // 147: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 14c: checkcast net/minecraft/entity/Entity
      // 14f: astore 21
      // 151: iload 5
      // 153: aload 21
      // 155: invokevirtual net/minecraft/entity/Entity.getCollisionBorderSize ()F
      // 158: fstore 22
      // 15a: aload 21
      // 15c: invokevirtual net/minecraft/entity/Entity.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 15f: fload 22
      // 161: f2d
      // 162: fload 22
      // 164: f2d
      // 165: fload 22
      // 167: f2d
      // 168: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 16b: astore 23
      // 16d: aload 23
      // 16f: aload 12
      // 171: aload 14
      // 173: invokevirtual net/minecraft/util/AxisAlignedBB.calculateIntercept (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/MovingObjectPosition;
      // 176: astore 24
      // 178: ifne 279
      // 17b: aload 23
      // 17d: aload 12
      // 17f: invokevirtual net/minecraft/util/AxisAlignedBB.isVecInside (Lnet/minecraft/util/Vec3;)Z
      // 182: iload 5
      // 184: ifne 19a
      // 187: goto 18b
      // 18a: athrow
      // 18b: ifeq 1c4
      // 18e: goto 192
      // 191: athrow
      // 192: dload 18
      // 194: dconst_0
      // 195: dcmpl
      // 196: goto 19a
      // 199: athrow
      // 19a: iflt 253
      // 19d: aload 21
      // 19f: astore 6
      // 1a1: aload 24
      // 1a3: iload 5
      // 1a5: ifne 1b7
      // 1a8: ifnonnull 1b5
      // 1ab: goto 1af
      // 1ae: athrow
      // 1af: aload 12
      // 1b1: goto 1ba
      // 1b4: athrow
      // 1b5: aload 24
      // 1b7: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 1ba: astore 15
      // 1bc: iload 5
      // 1be: dconst_0
      // 1bf: dstore 18
      // 1c1: ifeq 253
      // 1c4: aload 24
      // 1c6: ifnull 253
      // 1c9: goto 1cd
      // 1cc: athrow
      // 1cd: aload 12
      // 1cf: aload 24
      // 1d1: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 1d4: invokevirtual net/minecraft/util/Vec3.distanceTo (Lnet/minecraft/util/Vec3;)D
      // 1d7: dstore 25
      // 1d9: dload 25
      // 1db: dload 18
      // 1dd: iload 5
      // 1df: ifne 1f1
      // 1e2: dcmpg
      // 1e3: iflt 1f5
      // 1e6: goto 1ea
      // 1e9: athrow
      // 1ea: dload 18
      // 1ec: dconst_0
      // 1ed: goto 1f1
      // 1f0: athrow
      // 1f1: dcmpl
      // 1f2: ifne 253
      // 1f5: aload 21
      // 1f7: iload 5
      // 1f9: ifne 246
      // 1fc: goto 200
      // 1ff: athrow
      // 200: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 203: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 206: getfield net/minecraft/client/entity/EntityPlayerSP.ridingEntity Lnet/minecraft/entity/Entity;
      // 209: if_acmpne 244
      // 20c: goto 210
      // 20f: athrow
      // 210: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 213: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 216: iload 5
      // 218: ifne 246
      // 21b: goto 21f
      // 21e: athrow
      // 21f: invokevirtual net/minecraft/client/entity/EntityPlayerSP.canRiderInteract ()Z
      // 222: ifne 244
      // 225: goto 229
      // 228: athrow
      // 229: dload 18
      // 22b: dconst_0
      // 22c: dcmpl
      // 22d: ifne 253
      // 230: goto 234
      // 233: athrow
      // 234: aload 21
      // 236: astore 6
      // 238: iload 5
      // 23a: aload 24
      // 23c: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 23f: astore 15
      // 241: ifeq 253
      // 244: aload 21
      // 246: astore 6
      // 248: aload 24
      // 24a: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 24d: astore 15
      // 24f: dload 25
      // 251: dstore 18
      // 253: iinc 20 1
      // 256: iload 5
      // 258: ifeq 137
      // 25b: aload 6
      // 25d: ifnull 279
      // 260: dload 18
      // 262: dload 10
      // 264: dcmpg
      // 265: ifge 279
      // 268: goto 26c
      // 26b: athrow
      // 26c: new net/minecraft/util/MovingObjectPosition
      // 26f: dup
      // 270: aload 6
      // 272: aload 15
      // 274: invokespecial net/minecraft/util/MovingObjectPosition.<init> (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/Vec3;)V
      // 277: areturn
      // 278: athrow
      // 279: aconst_null
      // 27a: areturn
   }

   public static MovingObjectPosition Ů(double param0, float param2, float[] param3, EntityLivingBase param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: dload 0
      // 004: aload 3
      // 005: bipush 0
      // 006: faload
      // 007: aload 3
      // 008: bipush 1
      // 009: faload
      // 00a: invokestatic x/oc75d51ec7eb.τ (DFF)Lnet/minecraft/util/MovingObjectPosition;
      // 00d: astore 6
      // 00f: istore 5
      // 011: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 014: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 017: fload 2
      // 018: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 01b: astore 7
      // 01d: dload 0
      // 01e: dstore 8
      // 020: aload 6
      // 022: iload 5
      // 024: ifne 030
      // 027: ifnull 03a
      // 02a: goto 02e
      // 02d: athrow
      // 02e: aload 6
      // 030: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 033: aload 7
      // 035: invokevirtual net/minecraft/util/Vec3.distanceTo (Lnet/minecraft/util/Vec3;)D
      // 038: dstore 8
      // 03a: aload 4
      // 03c: ifnull 107
      // 03f: aload 3
      // 040: iload 5
      // 042: ifne 073
      // 045: goto 049
      // 048: athrow
      // 049: ifnonnull 072
      // 04c: goto 050
      // 04f: athrow
      // 050: ldc_w -438852356
      // 053: ldc_w -438852354
      // 056: ixor
      // 057: newarray 6
      // 059: dup
      // 05a: bipush 0
      // 05b: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 05e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 061: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 064: fastore
      // 065: dup
      // 066: bipush 1
      // 067: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 06a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 06d: getfield net/minecraft/client/entity/EntityPlayerSP.rotationPitch F
      // 070: fastore
      // 071: astore 3
      // 072: aload 3
      // 073: bipush 1
      // 074: faload
      // 075: aload 3
      // 076: bipush 0
      // 077: faload
      // 078: invokestatic x/oc75d51ec7eb.ď (FF)Lnet/minecraft/util/Vec3;
      // 07b: astore 10
      // 07d: aload 7
      // 07f: aload 10
      // 081: getfield net/minecraft/util/Vec3.xCoord D
      // 084: dload 0
      // 085: dmul
      // 086: aload 10
      // 088: getfield net/minecraft/util/Vec3.yCoord D
      // 08b: dload 0
      // 08c: dmul
      // 08d: aload 10
      // 08f: getfield net/minecraft/util/Vec3.zCoord D
      // 092: dload 0
      // 093: dmul
      // 094: invokevirtual net/minecraft/util/Vec3.addVector (DDD)Lnet/minecraft/util/Vec3;
      // 097: astore 11
      // 099: aload 4
      // 09b: invokevirtual net/minecraft/entity/EntityLivingBase.getCollisionBorderSize ()F
      // 09e: fstore 12
      // 0a0: aload 4
      // 0a2: invokevirtual net/minecraft/entity/EntityLivingBase.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 0a5: fload 12
      // 0a7: f2d
      // 0a8: fload 12
      // 0aa: f2d
      // 0ab: fload 12
      // 0ad: f2d
      // 0ae: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 0b1: astore 13
      // 0b3: aload 13
      // 0b5: aload 7
      // 0b7: aload 11
      // 0b9: invokevirtual net/minecraft/util/AxisAlignedBB.calculateIntercept (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/MovingObjectPosition;
      // 0bc: astore 14
      // 0be: aload 13
      // 0c0: aload 7
      // 0c2: invokevirtual net/minecraft/util/AxisAlignedBB.isVecInside (Lnet/minecraft/util/Vec3;)Z
      // 0c5: ifeq 0d5
      // 0c8: new net/minecraft/util/MovingObjectPosition
      // 0cb: dup
      // 0cc: aload 4
      // 0ce: aload 7
      // 0d0: invokespecial net/minecraft/util/MovingObjectPosition.<init> (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/Vec3;)V
      // 0d3: areturn
      // 0d4: athrow
      // 0d5: aload 14
      // 0d7: iload 5
      // 0d9: ifne 109
      // 0dc: ifnull 107
      // 0df: goto 0e3
      // 0e2: athrow
      // 0e3: aload 7
      // 0e5: aload 14
      // 0e7: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 0ea: invokevirtual net/minecraft/util/Vec3.distanceTo (Lnet/minecraft/util/Vec3;)D
      // 0ed: dstore 15
      // 0ef: dload 15
      // 0f1: dload 8
      // 0f3: dcmpg
      // 0f4: ifge 107
      // 0f7: new net/minecraft/util/MovingObjectPosition
      // 0fa: dup
      // 0fb: aload 4
      // 0fd: aload 14
      // 0ff: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 102: invokespecial net/minecraft/util/MovingObjectPosition.<init> (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/Vec3;)V
      // 105: areturn
      // 106: athrow
      // 107: aload 6
      // 109: iload 5
      // 10b: ifne 117
      // 10e: ifnull 118
      // 111: goto 115
      // 114: athrow
      // 115: aload 6
      // 117: areturn
      // 118: aconst_null
      // 119: areturn
   }

   public static float ʥ(float var0) {
      return щ(var0, false);
   }

   public static float[] ӆ(Vec3 var0, double var1, double var3, double var5) {
      double var7 = var1 - var0.xCoord;
      double var9 = var3 - var0.yCoord;
      double var11 = var5 - var0.zCoord;
      double var13 = Math.sqrt(var7 * var7 + var11 * var11);
      float var15 = (float)Math.toDegrees(Math.atan2(var11, var7)) - 90.0F;
      float var16 = (float)(-Math.toDegrees(Math.atan2(var9, var13)));
      float[] var10000 = new float[1680446186 ^ 1680446184];
      var10000[0] = var15;
      var10000[1] = var16;
      return var10000;
   }

   public static Vec3 Ԉ(Vec3 var0, AxisAlignedBB var1) {
      return new Vec3(
         MathHelper.clamp_double(var0.xCoord, var1.minX, var1.maxX),
         MathHelper.clamp_double(var0.yCoord, var1.minY, var1.maxY),
         MathHelper.clamp_double(var0.zCoord, var1.minZ, var1.maxZ)
      );
   }

   public static double Ğ(Entity var0, Vec3 var1) {
      float var2 = var0.getCollisionBorderSize();
      return Ś(var0.getEntityBoundingBox().expand(var2, var2, var2), var1);
   }

   public static double Ś(AxisAlignedBB var0, Vec3 var1) {
      try {
         if (var0.isVecInside(var1)) {
            return 0.0;
         }
      } catch (ocbde1165e4e var9) {
         throw var9;
      }

      Vec3 var2 = Ԉ(var1, var0);
      double var3 = var2.xCoord - var1.xCoord;
      double var5 = var2.yCoord - var1.yCoord;
      double var7 = var2.zCoord - var1.zCoord;
      return Math.sqrt(var3 * var3 + var5 * var5 + var7 * var7);
   }

   public static float[] А(Entity param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 16
      // 09: ifnonnull 15
      // 0c: goto 10
      // 0f: athrow
      // 10: aconst_null
      // 11: goto 1c
      // 14: athrow
      // 15: aload 0
      // 16: invokestatic x/oc75d51ec7eb.ψ (Lnet/minecraft/entity/Entity;)Lnet/minecraft/util/Vec3;
      // 19: invokestatic x/oc75d51ec7eb.Ǖ (Lnet/minecraft/util/Vec3;)[F
      // 1c: areturn
   }

   public static float[] Ǖ(Vec3 param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 1
      // 04: aload 0
      // 05: ifnull 1d
      // 08: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 0b: iload 1
      // 0c: ifne 23
      // 0f: goto 13
      // 12: athrow
      // 13: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 16: ifnonnull 20
      // 19: goto 1d
      // 1c: athrow
      // 1d: aconst_null
      // 1e: areturn
      // 1f: athrow
      // 20: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 23: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 26: fconst_1
      // 27: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 2a: astore 2
      // 2b: aload 0
      // 2c: getfield net/minecraft/util/Vec3.xCoord D
      // 2f: aload 2
      // 30: getfield net/minecraft/util/Vec3.xCoord D
      // 33: dsub
      // 34: dstore 3
      // 35: aload 0
      // 36: getfield net/minecraft/util/Vec3.yCoord D
      // 39: aload 2
      // 3a: getfield net/minecraft/util/Vec3.yCoord D
      // 3d: dsub
      // 3e: dstore 5
      // 40: aload 0
      // 41: getfield net/minecraft/util/Vec3.zCoord D
      // 44: aload 2
      // 45: getfield net/minecraft/util/Vec3.zCoord D
      // 48: dsub
      // 49: dstore 7
      // 4b: dload 3
      // 4c: dload 3
      // 4d: dmul
      // 4e: dload 7
      // 50: dload 7
      // 52: dmul
      // 53: dadd
      // 54: invokestatic java/lang/Math.sqrt (D)D
      // 57: dstore 9
      // 59: dload 7
      // 5b: dload 3
      // 5c: invokestatic java/lang/Math.atan2 (DD)D
      // 5f: invokestatic java/lang/Math.toDegrees (D)D
      // 62: d2f
      // 63: ldc 90.0
      // 65: fsub
      // 66: fstore 11
      // 68: dload 5
      // 6a: dload 9
      // 6c: invokestatic java/lang/Math.atan2 (DD)D
      // 6f: invokestatic java/lang/Math.toDegrees (D)D
      // 72: dneg
      // 73: d2f
      // 74: fstore 12
      // 76: ldc_w 1924720835
      // 79: ldc_w 1924720833
      // 7c: ixor
      // 7d: newarray 6
      // 7f: dup
      // 80: bipush 0
      // 81: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 84: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 87: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 8a: fload 11
      // 8c: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 8f: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 92: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 95: fsub
      // 96: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_float (F)F
      // 99: fadd
      // 9a: fastore
      // 9b: dup
      // 9c: bipush 1
      // 9d: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // a0: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // a3: getfield net/minecraft/client/entity/EntityPlayerSP.rotationPitch F
      // a6: fload 12
      // a8: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // ab: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // ae: getfield net/minecraft/client/entity/EntityPlayerSP.rotationPitch F
      // b1: fsub
      // b2: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_float (F)F
      // b5: fadd
      // b6: fastore
      // b7: areturn
   }

   public static float[] ӈ(float[] var0, float[] var1, float var2) {
      return ӫ(var0, var1, var2, var2);
   }

   public static float[] ӫ(float[] var0, float[] var1, float var2, float var3) {
      float var4 = MathHelper.wrapAngleTo180_float(var1[0] - var0[0]);
      float var5 = MathHelper.wrapAngleTo180_float(var1[1] - var0[1]);
      var4 = MathHelper.clamp_float(var4, -var2, var2);
      var5 = MathHelper.clamp_float(var5, -var3, var3);
      float[] var10000 = new float[-750036247 ^ -750036245];
      var10000[0] = var0[0] + var4;
      var10000[1] = var0[1] + var5;
      return var10000;
   }

   public static float[] ǐ(float[] var0, float[] var1, float var2) {
      return Ǐ(var0, var1, var2, var2);
   }

   public static float[] Ǐ(float[] var0, float[] var1, float var2, float var3) {
      return Ŕ(var0, ӫ(var0, var1, var2, var3));
   }

   public static float[] Ŕ(float[] var0, float[] var1) {
      float var2 = Ӌ();
      float var3 = var1[0] - var0[0];
      float var4 = var1[1] - var0[1];
      float[] var10000 = new float[985180875 ^ 985180873];
      var10000[0] = var0[0] + Math.round(var3 / var2) * var2;
      var10000[1] = var0[1] + Math.round(var4 / var2) * var2;
      return var10000;
   }

   public static float Ӌ() {
      float var0 = ocda171fe5d8.ǔ.gameSettings.mouseSensitivity * 0.6F + 0.2F;
      return var0 * var0 * var0 * 8.0F * 0.15F;
   }

   public static float ɕ(float var0, float var1) {
      return MathHelper.wrapAngleTo180_float(var0 - var1);
   }

   public static Vec3 ψ(Entity param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 1
      // 04: aload 0
      // 05: ifnonnull 14
      // 08: new net/minecraft/util/Vec3
      // 0b: dup
      // 0c: dconst_0
      // 0d: dconst_0
      // 0e: dconst_0
      // 0f: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 12: areturn
      // 13: athrow
      // 14: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 17: iload 1
      // 18: ifne 2e
      // 1b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1e: ifnonnull 2b
      // 21: goto 25
      // 24: athrow
      // 25: aload 0
      // 26: invokevirtual net/minecraft/entity/Entity.getPositionVector ()Lnet/minecraft/util/Vec3;
      // 29: areturn
      // 2a: athrow
      // 2b: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 2e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 31: fconst_1
      // 32: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 35: aload 0
      // 36: invokevirtual net/minecraft/entity/Entity.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 39: invokestatic x/oc75d51ec7eb.Ԉ (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/AxisAlignedBB;)Lnet/minecraft/util/Vec3;
      // 3c: areturn
   }

   public static double Ӟ(Entity param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 1
      // 04: aload 0
      // 05: ifnull 1d
      // 08: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 0b: iload 1
      // 0c: ifne 23
      // 0f: goto 13
      // 12: athrow
      // 13: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 16: ifnonnull 20
      // 19: goto 1d
      // 1c: athrow
      // 1d: dconst_0
      // 1e: dreturn
      // 1f: athrow
      // 20: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 23: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 26: fconst_1
      // 27: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 2a: aload 0
      // 2b: invokestatic x/oc75d51ec7eb.ψ (Lnet/minecraft/entity/Entity;)Lnet/minecraft/util/Vec3;
      // 2e: invokevirtual net/minecraft/util/Vec3.distanceTo (Lnet/minecraft/util/Vec3;)D
      // 31: dreturn
   }

   public static float ή(float var0, float var1) {
      return MathHelper.wrapAngleTo180_float(var0 - var1);
   }

   public static float љ(float[] var0, float[] var1) {
      return (float)Math.hypot(Math.abs(ή(var0[0], var1[0])), Math.abs(var0[1] - var1[1]));
   }

   public static float ԁ(Entity var0) {
      Vec3 var1 = ocda171fe5d8.ǔ.thePlayer.getPositionEyes(1.0F);
      float[] var2 = ӆ(var1, var0.posX, var0.posY + var0.getEyeHeight(), var0.posZ);
      float[] var10000 = new float[481810961 ^ 481810963];
      var10000[0] = d[0];
      var10000[1] = d[1];
      float[] var3 = var10000;
      return љ(var2, var3);
   }

   public static float Ƨ(Entity var0) {
      Vec3 var1 = ocda171fe5d8.ǔ.thePlayer.getPositionEyes(1.0F);
      float[] var2 = ӆ(var1, var0.posX, var0.posY + var0.getEyeHeight(), var0.posZ);
      float[] var10001 = new float[-600689306 ^ -600689308];
      var10001[0] = ocda171fe5d8.ǔ.thePlayer.rotationYaw;
      var10001[1] = ocda171fe5d8.ǔ.thePlayer.rotationPitch;
      return љ(var2, var10001);
   }

   public static float ŗ(EntityLivingBase var0) {
      double var1 = var0.posX - ocda171fe5d8.ǔ.thePlayer.posX;
      double var3 = var0.posZ - ocda171fe5d8.ǔ.thePlayer.posZ;
      float var5 = (float)(MathHelper.atan2(var3, var1) * 180.0 / Math.PI - 90.0);
      return Math.abs(MathHelper.wrapAngleTo180_float(var5 - ocda171fe5d8.ǔ.thePlayer.rotationYaw));
   }

   public static float[] G(Entity var0, float var1, float var2, float var3) {
      double var4 = var0.posX
         + (var0.posX - var0.prevPosX) * var1
         - (ocda171fe5d8.ǔ.thePlayer.posX + (ocda171fe5d8.ǔ.thePlayer.posX - ocda171fe5d8.ǔ.thePlayer.prevPosX));
      double var6 = var0.getEntityBoundingBox().minY
         + (var0.getEntityBoundingBox().minY - var0.prevPosY) * var1
         + var0.getEyeHeight()
         - 0.15
         - (ocda171fe5d8.ǔ.thePlayer.getEntityBoundingBox().minY + (ocda171fe5d8.ǔ.thePlayer.posY - ocda171fe5d8.ǔ.thePlayer.prevPosY))
         - ocda171fe5d8.ǔ.thePlayer.getEyeHeight();
      double var8 = var0.posZ
         + (var0.posZ - var0.prevPosZ) * var1
         - (ocda171fe5d8.ǔ.thePlayer.posZ + (ocda171fe5d8.ǔ.thePlayer.posZ - ocda171fe5d8.ǔ.thePlayer.prevPosZ));
      double var10 = Math.sqrt(var4 * var4 + var8 * var8);
      var3 = Math.min((var3 * var3 + var3 * 2.0F) / 3.0F, 1.0F);
      float var12 = 0.12F * var2;
      float[] var10000 = new float[1403549601 ^ 1403549603];
      var10000[0] = (float)Math.toDegrees(Math.atan2(var8, var4)) - 90.0F;
      var10000[1] = (float)(
         -Math.toDegrees(
            Math.atan((var3 * var3 - Math.sqrt(var3 * var3 * var3 * var3 - var12 * (var12 * var10 * var10 + 2.0 * var6 * var3 * var3))) / (var12 * var10))
         )
      );
      return var10000;
   }

   static {
      float[] var10000 = new float[-1075134598 ^ -1075134600];
      var10000[0] = 0.0F;
      var10000[1] = 0.0F;
      d = var10000;
   }
}

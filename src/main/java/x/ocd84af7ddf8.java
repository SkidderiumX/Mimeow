package x;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;

public class ocd84af7ddf8 implements ocda171fe5d8 {
   public static boolean ɹ;

   private ocd84af7ddf8() {
   }

   public static boolean В(BlockPos var0, double var1) {
      try {
         if (ocda171fe5d8.ǔ.thePlayer == null) {
            return false;
         }
      } catch (ocbde1165e4e var3) {
         throw var3;
      }

      return կ(
         var0, ocda171fe5d8.ǔ.thePlayer.posX, ocda171fe5d8.ǔ.thePlayer.posY + ocda171fe5d8.ǔ.thePlayer.getEyeHeight(), ocda171fe5d8.ǔ.thePlayer.posZ, var1
      );
   }

   public static boolean կ(BlockPos var0, double var1, double var3, double var5, double var7) {
      int var9 = oc75d51ec7eb.ϩ;

      BlockPos var10000;
      label33: {
         try {
            var10000 = var0;
            if (var9 != 0) {
               break label33;
            }

            if (var0 == null) {
               return (boolean)0;
            }
         } catch (ocbde1165e4e var11) {
            throw var11;
         }

         var10000 = var0;
      }

      try {
         double var13;
         int var12 = (var13 = var10000.distanceSqToCenter(var1, var3, var5) - var7 * var7) == 0.0 ? 0 : (var13 < 0.0 ? -1 : 1);
         if (var9 != 0) {
            return (boolean)var12;
         }

         if (var12 < 0) {
            return (boolean)1;
         }
      } catch (ocbde1165e4e var10) {
         throw var10;
      }

      return (boolean)0;
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
      // 05: ifnull 3f
      // 08: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 0b: iload 1
      // 0c: ifne 24
      // 0f: goto 13
      // 12: athrow
      // 13: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 16: ifnull 3f
      // 19: goto 1d
      // 1c: athrow
      // 1d: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 20: goto 24
      // 23: athrow
      // 24: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 27: getfield net/minecraft/client/multiplayer/WorldClient.loadedEntityList Ljava/util/List;
      // 2a: aload 0
      // 2b: invokeinterface java/util/List.contains (Ljava/lang/Object;)Z 2
      // 30: iload 1
      // 31: ifne 3c
      // 34: ifeq 3f
      // 37: goto 3b
      // 3a: athrow
      // 3b: bipush 1
      // 3c: goto 40
      // 3f: bipush 0
      // 40: ireturn
   }

   public static void ф(Entity param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 1
      // 04: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 07: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0a: iload 1
      // 0b: ifne 16
      // 0e: ifnull 4f
      // 11: goto 15
      // 14: athrow
      // 15: aload 0
      // 16: iload 1
      // 17: ifne 2a
      // 1a: ifnull 4f
      // 1d: goto 21
      // 20: athrow
      // 21: aload 0
      // 22: iload 1
      // 23: ifne 35
      // 26: goto 2a
      // 29: athrow
      // 2a: invokevirtual net/minecraft/entity/Entity.canAttackWithItem ()Z
      // 2d: ifeq 4f
      // 30: aload 0
      // 31: goto 35
      // 34: athrow
      // 35: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 38: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 3b: invokevirtual net/minecraft/entity/Entity.hitByEntity (Lnet/minecraft/entity/Entity;)Z
      // 3e: ifne 4f
      // 41: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 44: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 47: aload 0
      // 48: invokevirtual net/minecraft/client/entity/EntityPlayerSP.attackTargetEntityWithCurrentItem (Lnet/minecraft/entity/Entity;)V
      // 4b: goto 4f
      // 4e: athrow
      // 4f: return
   }

   public static boolean Ø(double var0, double var2) {
      return Ͱ(var0, var2, -1.0);
   }

   public static boolean Ͱ(double var0, double var2, double var4) {
      AxisAlignedBB var6 = ocda171fe5d8.ǔ.thePlayer.getEntityBoundingBox().offset(var0, var4, var2);
      return ocda171fe5d8.ǔ.theWorld.getCollidingBoundingBoxes(ocda171fe5d8.ǔ.thePlayer, var6).isEmpty();
   }

   public static Block ձ(double var0, double var2, double var4) {
      return ocda171fe5d8.ǔ.theWorld.getBlockState(new BlockPos(var0, var2, var4)).getBlock();
   }

   public static Block ӿ(BlockPos var0) {
      return ocda171fe5d8.ǔ.theWorld.getBlockState(var0).getBlock();
   }

   public static Block Ѹ(float var0, float var1, float var2) {
      return ԗ(var0, var1, var2);
   }

   public static Block ԗ(double var0, double var2, double var4) {
      return ձ(ocda171fe5d8.ǔ.thePlayer.posX + var0, ocda171fe5d8.ǔ.thePlayer.posY + var2, ocda171fe5d8.ǔ.thePlayer.posZ + var4);
   }

   public static double Ԉ(Entity var0) {
      return ocda171fe5d8.ǔ.thePlayer.getPositionEyes(1.0F).distanceTo(oc75d51ec7eb.ψ(var0));
   }

   public static double Ŏ(Vec3 var0, Entity var1) {
      Vec3 var2 = oc75d51ec7eb.Ԉ(var0, var1.getEntityBoundingBox());
      return var0.distanceTo(var2);
   }

   public static double ɷ(Vec3 var0, Vec3 var1) {
      AxisAlignedBB var2 = ocda171fe5d8.ǔ
         .thePlayer
         .getEntityBoundingBox()
         .offset(var1.xCoord - ocda171fe5d8.ǔ.thePlayer.posX, var1.yCoord - ocda171fe5d8.ǔ.thePlayer.posY, var1.zCoord - ocda171fe5d8.ǔ.thePlayer.posZ);
      return var0.distanceTo(oc75d51ec7eb.Ԉ(var0, var2));
   }

   public static EntityLivingBase δ(double var0) {
      return қ(var0, "Distance");
   }

   public static EntityLivingBase қ(double param0, String param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 3
      // 004: getstatic x/oc9755810e45.ÿ Lx/ocdd342096f8;
      // 007: iload 3
      // 008: ifne 015
      // 00b: ifnull 031
      // 00e: goto 012
      // 011: athrow
      // 012: getstatic x/oc9755810e45.ÿ Lx/ocdd342096f8;
      // 015: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 018: ifeq 031
      // 01b: getstatic x/ocdd342096f8.f Lnet/minecraft/entity/EntityLivingBase;
      // 01e: iload 3
      // 01f: ifne 030
      // 022: goto 026
      // 025: athrow
      // 026: ifnull 031
      // 029: goto 02d
      // 02c: athrow
      // 02d: getstatic x/ocdd342096f8.f Lnet/minecraft/entity/EntityLivingBase;
      // 030: areturn
      // 031: aconst_null
      // 032: astore 4
      // 034: dload 0
      // 035: ldc2_w 0.4
      // 038: dadd
      // 039: dstore 5
      // 03b: ldc2_w 3.4028234663852886E38
      // 03e: dstore 7
      // 040: ldc2_w 10.0
      // 043: dstore 9
      // 045: ldc2_w 1.7976931348623157E308
      // 048: dstore 11
      // 04a: invokestatic x/ocd84af7ddf8.Ԕ ()Lnet/minecraft/util/Vec3;
      // 04d: astore 13
      // 04f: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 052: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 055: getfield net/minecraft/client/multiplayer/WorldClient.loadedEntityList Ljava/util/List;
      // 058: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 05d: astore 14
      // 05f: aload 14
      // 061: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 066: ifeq 1ed
      // 069: aload 14
      // 06b: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 070: checkcast net/minecraft/entity/Entity
      // 073: astore 15
      // 075: aload 15
      // 077: iload 3
      // 078: ifne 087
      // 07b: instanceof net/minecraft/entity/EntityLivingBase
      // 07e: ifeq 05f
      // 081: goto 085
      // 084: athrow
      // 085: aload 15
      // 087: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 08a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 08d: if_acmpeq 05f
      // 090: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 093: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 096: iload 3
      // 097: ifne 0b7
      // 09a: aload 15
      // 09c: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getDistanceSqToEntity (Lnet/minecraft/entity/Entity;)D
      // 09f: dload 0
      // 0a0: dload 0
      // 0a1: dmul
      // 0a2: dcmpl
      // 0a3: ifgt 05f
      // 0a6: goto 0aa
      // 0a9: athrow
      // 0aa: aload 15
      // 0ac: iload 3
      // 0ad: ifne 0c7
      // 0b0: checkcast net/minecraft/entity/EntityLivingBase
      // 0b3: goto 0b7
      // 0b6: athrow
      // 0b7: invokestatic x/ocd84af7ddf8.Բ (Lnet/minecraft/entity/EntityLivingBase;)Z
      // 0ba: ifne 0c5
      // 0bd: iload 3
      // 0be: ifeq 05f
      // 0c1: goto 0c5
      // 0c4: athrow
      // 0c5: aload 15
      // 0c7: checkcast net/minecraft/entity/EntityLivingBase
      // 0ca: astore 16
      // 0cc: aload 16
      // 0ce: invokestatic x/ocd84af7ddf8.Ԉ (Lnet/minecraft/entity/Entity;)D
      // 0d1: dstore 17
      // 0d3: dload 17
      // 0d5: dload 0
      // 0d6: dcmpl
      // 0d7: iload 3
      // 0d8: ifne 0f8
      // 0db: ifle 0ea
      // 0de: goto 0e2
      // 0e1: athrow
      // 0e2: iload 3
      // 0e3: ifeq 05f
      // 0e6: goto 0ea
      // 0e9: athrow
      // 0ea: ldc "None"
      // 0ec: iload 3
      // 0ed: ifne 109
      // 0f0: aload 2
      // 0f1: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0f4: goto 0f8
      // 0f7: athrow
      // 0f8: ifeq 103
      // 0fb: aload 16
      // 0fd: astore 4
      // 0ff: iload 3
      // 100: ifeq 1e9
      // 103: ldc "Health"
      // 105: goto 109
      // 108: athrow
      // 109: aload 2
      // 10a: iload 3
      // 10b: ifne 147
      // 10e: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 111: ifeq 140
      // 114: goto 118
      // 117: athrow
      // 118: aload 16
      // 11a: invokevirtual net/minecraft/entity/EntityLivingBase.getHealth ()F
      // 11d: f2d
      // 11e: dload 7
      // 120: dcmpg
      // 121: iload 3
      // 122: ifne 152
      // 125: goto 129
      // 128: athrow
      // 129: ifge 140
      // 12c: goto 130
      // 12f: athrow
      // 130: aload 16
      // 132: astore 4
      // 134: iload 3
      // 135: aload 16
      // 137: invokevirtual net/minecraft/entity/EntityLivingBase.getHealth ()F
      // 13a: f2d
      // 13b: dstore 7
      // 13d: ifeq 1e9
      // 140: ldc "HurtTime"
      // 142: aload 2
      // 143: goto 147
      // 146: athrow
      // 147: iload 3
      // 148: ifne 185
      // 14b: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 14e: goto 152
      // 151: athrow
      // 152: ifeq 17d
      // 155: aload 16
      // 157: getfield net/minecraft/entity/EntityLivingBase.hurtTime I
      // 15a: iload 3
      // 15b: ifne 190
      // 15e: goto 162
      // 161: athrow
      // 162: i2d
      // 163: dload 9
      // 165: dcmpg
      // 166: ifgt 17d
      // 169: goto 16d
      // 16c: athrow
      // 16d: aload 16
      // 16f: astore 4
      // 171: iload 3
      // 172: aload 16
      // 174: getfield net/minecraft/entity/EntityLivingBase.hurtTime I
      // 177: i2d
      // 178: dstore 9
      // 17a: ifeq 1e9
      // 17d: ldc_w "RayTrace"
      // 180: aload 2
      // 181: goto 185
      // 184: athrow
      // 185: iload 3
      // 186: ifne 1bf
      // 189: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 18c: goto 190
      // 18f: athrow
      // 190: ifeq 1b8
      // 193: aload 13
      // 195: aload 16
      // 197: invokestatic x/ocd84af7ddf8.Ŏ (Lnet/minecraft/util/Vec3;Lnet/minecraft/entity/Entity;)D
      // 19a: dstore 19
      // 19c: iload 3
      // 19d: ifne 1b0
      // 1a0: dload 19
      // 1a2: dload 11
      // 1a4: dcmpg
      // 1a5: ifge 1b4
      // 1a8: goto 1ac
      // 1ab: athrow
      // 1ac: aload 16
      // 1ae: astore 4
      // 1b0: dload 19
      // 1b2: dstore 11
      // 1b4: iload 3
      // 1b5: ifeq 1e9
      // 1b8: ldc "Distance"
      // 1ba: aload 2
      // 1bb: goto 1bf
      // 1be: athrow
      // 1bf: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 1c2: iload 3
      // 1c3: ifne 1de
      // 1c6: ifeq 1e9
      // 1c9: goto 1cd
      // 1cc: athrow
      // 1cd: dload 17
      // 1cf: iload 3
      // 1d0: ifne 1e7
      // 1d3: goto 1d7
      // 1d6: athrow
      // 1d7: dload 5
      // 1d9: dcmpg
      // 1da: goto 1de
      // 1dd: athrow
      // 1de: ifge 1e9
      // 1e1: aload 16
      // 1e3: astore 4
      // 1e5: dload 17
      // 1e7: dstore 5
      // 1e9: iload 3
      // 1ea: ifeq 05f
      // 1ed: aload 4
      // 1ef: areturn
   }

   public static List<EntityLivingBase> Ҿ(double param0) {
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
      // 0b: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 0e: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 11: getfield net/minecraft/client/multiplayer/WorldClient.loadedEntityList Ljava/util/List;
      // 14: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 19: astore 4
      // 1b: istore 2
      // 1c: aload 4
      // 1e: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 23: ifeq 9b
      // 26: aload 4
      // 28: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 2d: checkcast net/minecraft/entity/Entity
      // 30: astore 5
      // 32: aload 5
      // 34: iload 2
      // 35: ifne 44
      // 38: instanceof net/minecraft/entity/EntityLivingBase
      // 3b: ifeq 1c
      // 3e: goto 42
      // 41: athrow
      // 42: aload 5
      // 44: iload 2
      // 45: ifne 5f
      // 48: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 4b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 4e: if_acmpne 5d
      // 51: goto 55
      // 54: athrow
      // 55: iload 2
      // 56: ifeq 1c
      // 59: goto 5d
      // 5c: athrow
      // 5d: aload 5
      // 5f: checkcast net/minecraft/entity/EntityLivingBase
      // 62: astore 6
      // 64: aload 6
      // 66: iload 2
      // 67: ifne 7c
      // 6a: invokestatic x/ocd84af7ddf8.Ԉ (Lnet/minecraft/entity/Entity;)D
      // 6d: dload 0
      // 6e: dcmpg
      // 6f: ifgt 97
      // 72: goto 76
      // 75: athrow
      // 76: aload 6
      // 78: goto 7c
      // 7b: athrow
      // 7c: invokestatic x/ocd84af7ddf8.Բ (Lnet/minecraft/entity/EntityLivingBase;)Z
      // 7f: iload 2
      // 80: ifne 96
      // 83: ifeq 97
      // 86: goto 8a
      // 89: athrow
      // 8a: aload 3
      // 8b: aload 6
      // 8d: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 92: goto 96
      // 95: athrow
      // 96: pop
      // 97: iload 2
      // 98: ifeq 1c
      // 9b: aload 3
      // 9c: areturn
   }

   public static boolean œ() {
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
      // 08: ifne 1c
      // 0b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0e: ifnull 34
      // 11: goto 15
      // 14: athrow
      // 15: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 18: goto 1c
      // 1b: athrow
      // 1c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1f: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionVector ()Lnet/minecraft/util/Vec3;
      // 22: invokestatic x/ocd84af7ddf8.Γ (Lnet/minecraft/util/Vec3;)Z
      // 25: iload 0
      // 26: ifne 31
      // 29: ifeq 34
      // 2c: goto 30
      // 2f: athrow
      // 30: bipush 1
      // 31: goto 35
      // 34: bipush 0
      // 35: ireturn
   }

   public static boolean Γ(Vec3 var0) {
      int var1 = oc75d51ec7eb.ϩ;

      Vec3 var10000;
      label33: {
         try {
            var10000 = var0;
            if (var1 != 0) {
               break label33;
            }

            if (var0 == null) {
               return false;
            }
         } catch (ocbde1165e4e var3) {
            throw var3;
         }

         var10000 = var0;
      }

      try {
         boolean var4 = Ƌ(var10000.xCoord, var0.yCoord, var0.zCoord);
         if (var1 != 0) {
            return var4;
         }

         if (var4) {
            return true;
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }

      return false;
   }

   public static boolean Ƌ(double param0, double param2, double param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: dload 2
      // 04: d2i
      // 05: istore 7
      // 07: istore 6
      // 09: iload 7
      // 0b: bipush -1
      // 0c: if_icmple 3a
      // 0f: dload 0
      // 10: iload 7
      // 12: i2d
      // 13: dload 4
      // 15: invokestatic x/ocd84af7ddf8.ձ (DDD)Lnet/minecraft/block/Block;
      // 18: instanceof net/minecraft/block/BlockAir
      // 1b: iload 6
      // 1d: ifne 3b
      // 20: iload 6
      // 22: ifne 31
      // 25: goto 29
      // 28: athrow
      // 29: ifne 32
      // 2c: goto 30
      // 2f: athrow
      // 30: bipush 0
      // 31: ireturn
      // 32: iinc 7 -1
      // 35: iload 6
      // 37: ifeq 09
      // 3a: bipush 1
      // 3b: ireturn
   }

   public static MovingObjectPosition Ը(BlockPos var0) {
      Vec3 var2 = ocda171fe5d8.ǔ.thePlayer.getPositionEyes(1.0F);
      int var10000 = oc75d51ec7eb.ϩ;
      Vec3 var3 = oc7ab2161b9f.ҵ(oc75d51ec7eb.d[0], oc75d51ec7eb.d[1]);
      Vec3 var4 = var2.addVector(var3.xCoord * 4.5, var3.yCoord * 4.5, var3.zCoord * 4.5);
      int var1 = var10000;
      MovingObjectPosition var5 = ӿ(var0).collisionRayTrace(ocda171fe5d8.ǔ.theWorld, var0, var2, var4);

      try {
         if (var1 != 0) {
            return var5;
         }

         if (var5 != null) {
            return var5;
         }
      } catch (ocbde1165e4e var6) {
         throw var6;
      }

      return new MovingObjectPosition(MovingObjectType.MISS, var4, EnumFacing.UP, new BlockPos(var4));
   }

   private static Vec3 Ԕ() {
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
      // 08: ifne 3b
      // 0b: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 0e: ifnull 38
      // 11: goto 15
      // 14: athrow
      // 15: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 18: iload 0
      // 19: ifne 3b
      // 1c: goto 20
      // 1f: athrow
      // 20: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 23: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 26: ifnull 38
      // 29: goto 2d
      // 2c: athrow
      // 2d: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 30: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 33: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 36: areturn
      // 37: athrow
      // 38: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 3b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 3e: fconst_1
      // 3f: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 42: astore 1
      // 43: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 46: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 49: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getLookVec ()Lnet/minecraft/util/Vec3;
      // 4c: astore 2
      // 4d: aload 1
      // 4e: aload 2
      // 4f: getfield net/minecraft/util/Vec3.xCoord D
      // 52: ldc2_w 4.5
      // 55: dmul
      // 56: aload 2
      // 57: getfield net/minecraft/util/Vec3.yCoord D
      // 5a: ldc2_w 4.5
      // 5d: dmul
      // 5e: aload 2
      // 5f: getfield net/minecraft/util/Vec3.zCoord D
      // 62: ldc2_w 4.5
      // 65: dmul
      // 66: invokevirtual net/minecraft/util/Vec3.addVector (DDD)Lnet/minecraft/util/Vec3;
      // 69: areturn
   }

   private static boolean Բ(EntityLivingBase param0) {
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
      // 06: ifne 73
      // 09: instanceof net/minecraft/entity/passive/EntityAnimal
      // 0c: ifne 72
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: iload 1
      // 15: ifne 73
      // 18: goto 1c
      // 1b: athrow
      // 1c: instanceof net/minecraft/entity/monster/EntityMob
      // 1f: ifne 72
      // 22: goto 26
      // 25: athrow
      // 26: aload 0
      // 27: iload 1
      // 28: ifne 73
      // 2b: goto 2f
      // 2e: athrow
      // 2f: instanceof net/minecraft/entity/passive/EntityVillager
      // 32: ifne 72
      // 35: goto 39
      // 38: athrow
      // 39: aload 0
      // 3a: iload 1
      // 3b: ifne 73
      // 3e: goto 42
      // 41: athrow
      // 42: instanceof net/minecraft/entity/player/EntityPlayer
      // 45: ifne 72
      // 48: goto 4c
      // 4b: athrow
      // 4c: aload 0
      // 4d: iload 1
      // 4e: ifne 73
      // 51: goto 55
      // 54: athrow
      // 55: instanceof net/minecraft/entity/monster/EntitySlime
      // 58: ifne 72
      // 5b: goto 5f
      // 5e: athrow
      // 5f: aload 0
      // 60: instanceof net/minecraft/entity/monster/EntityIronGolem
      // 63: iload 1
      // 64: ifne ac
      // 67: goto 6b
      // 6a: athrow
      // 6b: ifeq a7
      // 6e: goto 72
      // 71: athrow
      // 72: aload 0
      // 73: invokevirtual net/minecraft/entity/EntityLivingBase.isInvisible ()Z
      // 76: iload 1
      // 77: ifne ac
      // 7a: ifne a7
      // 7d: goto 81
      // 80: athrow
      // 81: aload 0
      // 82: getfield net/minecraft/entity/EntityLivingBase.isDead Z
      // 85: iload 1
      // 86: ifne ac
      // 89: goto 8d
      // 8c: athrow
      // 8d: ifne a7
      // 90: goto 94
      // 93: athrow
      // 94: aload 0
      // 95: iload 1
      // 96: ifne ae
      // 99: goto 9d
      // 9c: athrow
      // 9d: getfield net/minecraft/entity/EntityLivingBase.deathTime I
      // a0: ifle ad
      // a3: goto a7
      // a6: athrow
      // a7: bipush 0
      // a8: goto ac
      // ab: athrow
      // ac: ireturn
      // ad: aload 0
      // ae: instanceof net/minecraft/entity/player/EntityPlayer
      // b1: iload 1
      // b2: ifne ec
      // b5: ifeq eb
      // b8: goto bc
      // bb: athrow
      // bc: aload 0
      // bd: checkcast net/minecraft/entity/player/EntityPlayer
      // c0: astore 2
      // c1: aload 2
      // c2: invokestatic x/ocdc8e6f6a42.Ѻ (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // c5: ifne e9
      // c8: getstatic x/oc9755810e45.Ǵ Lx/oca4f99d2d44;
      // cb: ifnull e5
      // ce: goto d2
      // d1: athrow
      // d2: aload 2
      // d3: invokestatic x/oca4f99d2d44.Λ (Lnet/minecraft/entity/Entity;)Z
      // d6: iload 1
      // d7: ifne e6
      // da: goto de
      // dd: athrow
      // de: ifne e9
      // e1: goto e5
      // e4: athrow
      // e5: bipush 1
      // e6: goto ea
      // e9: bipush 0
      // ea: ireturn
      // eb: bipush 1
      // ec: ireturn
   }
}

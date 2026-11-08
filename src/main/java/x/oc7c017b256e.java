package x;

import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;

public class oc7c017b256e {
   private static final double Ж = 0.9;

   private oc7c017b256e() {
   }

   private static Minecraft ɥ() {
      return Minecraft.getMinecraft();
   }

   static void դ(oca9cc61aada param0, oca9cc61aada param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 1d
      // 09: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0c: aload 1
      // 0d: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 10: dcmpl
      // 11: ifle 30
      // 14: goto 18
      // 17: athrow
      // 18: aload 0
      // 19: goto 1d
      // 1c: athrow
      // 1d: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 20: dstore 3
      // 21: aload 0
      // 22: aload 1
      // 23: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 26: invokevirtual x/oca9cc61aada.Ȟ (D)D
      // 29: pop2
      // 2a: aload 1
      // 2b: dload 3
      // 2c: invokevirtual x/oca9cc61aada.Ȟ (D)D
      // 2f: pop2
      // 30: return
   }

   static float[] ʪ() {
      float[] var10000 = new float[-1601648296 ^ -1601648294];
      var10000[0] = ɥ().thePlayer.rotationYaw;
      var10000[1] = ɥ().thePlayer.rotationPitch;
      return var10000;
   }

   static float[] Ñ() {
      try {
         if (oc5e549848f3.ʢ) {
            return oc75d51ec7eb.d;
         }
      } catch (ocbde1165e4e var0) {
         throw var0;
      }

      return ʪ();
   }

   static float ɝ(float var0) {
      return MathHelper.clamp_float(var0, -90.0F, 90.0F);
   }

   static float[] Ր(float var0, float var1, float var2, float var3) {
      float var5 = ɥ().gameSettings.mouseSensitivity * 0.6F + 0.2F;
      double var6 = var5 * var5 * var5 * 1.2;
      float var8 = (float)(Math.round((var0 - var2) / var6) * var6);
      int var10000 = oc5e549848f3.İ;
      float var9 = (float)(Math.round((var1 - var3) / var6) * var6);
      float var10 = var2 + var8;
      int var4 = var10000;

      label21: {
         label20: {
            try {
               double var14;
               var10000 = (var14 = Math.abs(var0 - var2) - var6) == 0.0 ? 0 : (var14 < 0.0 ? -1 : 1);
               if (var4 != 0) {
                  break label21;
               }

               if (var10000 < 0) {
                  break label20;
               }
            } catch (ocbde1165e4e var11) {
               throw var11;
            }

            var10 += (float)(ThreadLocalRandom.current().nextInt(-436438054 ^ 436438055, 436438051 ^ 436438055) * var6);
         }

         var10000 = 436438053 ^ 436438055;
      }

      float[] var13 = new float[var10000];
      var13[0] = var10;
      var13[1] = ɝ(var3 + var9);
      return var13;
   }

   static void Ϲ(float var0, float var1) {
      ɥ().thePlayer.rotationYaw = var0;
      ɥ().thePlayer.rotationPitch = var1;
   }

   static double ȥ(Entity var0, boolean var1) {
      float var10000;
      label16: {
         try {
            if (var1) {
               var10000 = oc75d51ec7eb.d[0];
               break label16;
            }
         } catch (ocbde1165e4e var3) {
            throw var3;
         }

         var10000 = ɥ().thePlayer.rotationYaw;
      }

      float var2 = var10000;
      return Math.abs(MathHelper.wrapAngleTo180_double(ɟ(var0.posX, var0.posZ) - var2));
   }

   static float ɟ(double var0, double var2) {
      double var4 = Math.atan2(var0 - ɥ().thePlayer.posX, var2 - ɥ().thePlayer.posZ) * (float) (180.0 / Math.PI);
      return (float)(var4 * -1.0);
   }

   static MovingObjectPosition ղ(Entity param0, double param1, double param3, double param5, double param7, float param9, float param10) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: aload 0
      // 04: fload 9
      // 06: fload 10
      // 08: dload 1
      // 09: invokestatic x/ocffa9e799de.Ǜ (Lnet/minecraft/entity/Entity;FFD)Lnet/minecraft/util/MovingObjectPosition;
      // 0c: astore 12
      // 0e: istore 11
      // 10: aload 12
      // 12: iload 11
      // 14: ifne 31
      // 17: ifnull 2b
      // 1a: goto 1e
      // 1d: athrow
      // 1e: invokestatic x/oc7c017b256e.ɥ ()Lnet/minecraft/client/Minecraft;
      // 21: invokevirtual net/minecraft/client/Minecraft.getRenderViewEntity ()Lnet/minecraft/entity/Entity;
      // 24: ifnonnull 32
      // 27: goto 2b
      // 2a: athrow
      // 2b: aload 12
      // 2d: goto 31
      // 30: athrow
      // 31: areturn
      // 32: new net/minecraft/util/Vec3
      // 35: dup
      // 36: dload 3
      // 37: dload 5
      // 39: invokestatic x/oc7c017b256e.ɥ ()Lnet/minecraft/client/Minecraft;
      // 3c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 3f: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getEyeHeight ()F
      // 42: f2d
      // 43: dadd
      // 44: dload 7
      // 46: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 49: astore 13
      // 4b: aload 0
      // 4c: iload 11
      // 4e: ifne 66
      // 51: invokestatic x/oc7c017b256e.ɥ ()Lnet/minecraft/client/Minecraft;
      // 54: invokevirtual net/minecraft/client/Minecraft.getRenderViewEntity ()Lnet/minecraft/entity/Entity;
      // 57: getfield net/minecraft/entity/Entity.ridingEntity Lnet/minecraft/entity/Entity;
      // 5a: if_acmpne a3
      // 5d: goto 61
      // 60: athrow
      // 61: aload 0
      // 62: goto 66
      // 65: athrow
      // 66: invokevirtual net/minecraft/entity/Entity.canRiderInteract ()Z
      // 69: iload 11
      // 6b: ifne af
      // 6e: ifne a3
      // 71: goto 75
      // 74: athrow
      // 75: aload 0
      // 76: invokevirtual net/minecraft/entity/Entity.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 79: aload 0
      // 7a: invokevirtual net/minecraft/entity/Entity.getCollisionBorderSize ()F
      // 7d: f2d
      // 7e: aload 0
      // 7f: invokevirtual net/minecraft/entity/Entity.getCollisionBorderSize ()F
      // 82: f2d
      // 83: aload 0
      // 84: invokevirtual net/minecraft/entity/Entity.getCollisionBorderSize ()F
      // 87: f2d
      // 88: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 8b: aload 13
      // 8d: invokevirtual net/minecraft/util/AxisAlignedBB.isVecInside (Lnet/minecraft/util/Vec3;)Z
      // 90: iload 11
      // 92: ifne af
      // 95: goto 99
      // 98: athrow
      // 99: ifne a3
      // 9c: goto a0
      // 9f: athrow
      // a0: aconst_null
      // a1: areturn
      // a2: athrow
      // a3: aload 13
      // a5: aload 12
      // a7: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // aa: invokevirtual net/minecraft/util/Vec3.distanceTo (Lnet/minecraft/util/Vec3;)D
      // ad: dload 1
      // ae: dcmpg
      // af: ifge c3
      // b2: new net/minecraft/util/MovingObjectPosition
      // b5: dup
      // b6: aload 0
      // b7: aload 12
      // b9: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // bc: invokespecial net/minecraft/util/MovingObjectPosition.<init> (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/Vec3;)V
      // bf: goto c4
      // c2: athrow
      // c3: aconst_null
      // c4: areturn
   }

   static boolean Ê(int param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 1
      // 04: invokestatic org/lwjgl/input/Mouse.isCreated ()Z
      // 07: iload 1
      // 08: ifne 22
      // 0b: ifeq 29
      // 0e: goto 12
      // 11: athrow
      // 12: iload 0
      // 13: iload 1
      // 14: ifne 26
      // 17: goto 1b
      // 1a: athrow
      // 1b: invokestatic org/lwjgl/input/Mouse.isButtonDown (I)Z
      // 1e: goto 22
      // 21: athrow
      // 22: ifeq 29
      // 25: bipush 1
      // 26: goto 2a
      // 29: bipush 0
      // 2a: ireturn
   }

   static int Ô() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: bipush 0
      // 04: istore 1
      // 05: istore 0
      // 06: iload 1
      // 07: ldc -1559140137
      // 09: ldc -1559140130
      // 0b: ixor
      // 0c: if_icmpge 39
      // 0f: invokestatic x/oc7c017b256e.ɥ ()Lnet/minecraft/client/Minecraft;
      // 12: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 15: getfield net/minecraft/client/settings/GameSettings.keyBindsHotbar [Lnet/minecraft/client/settings/KeyBinding;
      // 18: iload 1
      // 19: aaload
      // 1a: invokestatic x/oc7ab2161b9f.ն (Lnet/minecraft/client/settings/KeyBinding;)Z
      // 1d: iload 0
      // 1e: ifne 3a
      // 21: iload 0
      // 22: ifne 31
      // 25: goto 29
      // 28: athrow
      // 29: ifeq 32
      // 2c: goto 30
      // 2f: athrow
      // 30: iload 1
      // 31: ireturn
      // 32: iinc 1 1
      // 35: iload 0
      // 36: ifeq 06
      // 39: bipush -1
      // 3a: ireturn
   }

   static int Ǹ() {
      return ɥ().thePlayer.inventory.currentItem;
   }

   static boolean Ĭ(ItemStack var0) {
      int var1 = oc5e549848f3.İ;

      ItemStack var10000;
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
         boolean var4 = var10000.getItem() instanceof ItemSword;
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

   static boolean Э() {
      return Ĭ(ɥ().thePlayer.getHeldItem());
   }

   static boolean Ͻ() {
      return Э();
   }

   static boolean Ͳ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 0
      // 04: getstatic x/ocdd342096f8.Ɯ Lx/ocdd342096f8;
      // 07: iload 0
      // 08: ifne 15
      // 0b: ifnull 38
      // 0e: goto 12
      // 11: athrow
      // 12: getstatic x/ocdd342096f8.Ɯ Lx/ocdd342096f8;
      // 15: invokevirtual x/ocdd342096f8.ъ ()Z
      // 18: iload 0
      // 19: ifne 49
      // 1c: ifeq 38
      // 1f: goto 23
      // 22: athrow
      // 23: invokestatic x/oc7c017b256e.Э ()Z
      // 26: iload 0
      // 27: ifne 49
      // 2a: goto 2e
      // 2d: athrow
      // 2e: ifeq 38
      // 31: goto 35
      // 34: athrow
      // 35: bipush 1
      // 36: ireturn
      // 37: athrow
      // 38: invokestatic x/oc7c017b256e.ɥ ()Lnet/minecraft/client/Minecraft;
      // 3b: iload 0
      // 3c: ifne 4f
      // 3f: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 42: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isUsingItem ()Z
      // 45: goto 49
      // 48: athrow
      // 49: ifeq 7b
      // 4c: invokestatic x/oc7c017b256e.ɥ ()Lnet/minecraft/client/Minecraft;
      // 4f: iload 0
      // 50: ifne 67
      // 53: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 56: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getItemInUse ()Lnet/minecraft/item/ItemStack;
      // 59: ifnull 7b
      // 5c: goto 60
      // 5f: athrow
      // 60: invokestatic x/oc7c017b256e.ɥ ()Lnet/minecraft/client/Minecraft;
      // 63: goto 67
      // 66: athrow
      // 67: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 6a: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getItemInUse ()Lnet/minecraft/item/ItemStack;
      // 6d: invokevirtual net/minecraft/item/ItemStack.getItemUseAction ()Lnet/minecraft/item/EnumAction;
      // 70: getstatic net/minecraft/item/EnumAction.BLOCK Lnet/minecraft/item/EnumAction;
      // 73: if_acmpne 7b
      // 76: bipush 1
      // 77: goto 7c
      // 7a: athrow
      // 7b: bipush 0
      // 7c: ireturn
   }

   static void ï(Entity param0, boolean param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: iload 1
      // 05: iload 2
      // 06: ifne 34
      // 09: bipush 0
      // 0a: invokestatic x/oc7c017b256e.Ӛ (ZZ)V
      // 0d: invokestatic x/oc7c017b256e.ɥ ()Lnet/minecraft/client/Minecraft;
      // 10: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 13: invokestatic x/oc7c017b256e.ɥ ()Lnet/minecraft/client/Minecraft;
      // 16: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 19: aload 0
      // 1a: invokevirtual net/minecraft/client/multiplayer/PlayerControllerMP.attackEntityWithResult (Lnet/minecraft/entity/player/EntityPlayer;Lnet/minecraft/entity/Entity;)Z
      // 1d: ifeq 42
      // 20: goto 24
      // 23: athrow
      // 24: aload 0
      // 25: iload 2
      // 26: ifne 38
      // 29: goto 2d
      // 2c: athrow
      // 2d: instanceof net/minecraft/entity/EntityLivingBase
      // 30: goto 34
      // 33: athrow
      // 34: ifeq 3e
      // 37: aload 0
      // 38: checkcast net/minecraft/entity/EntityLivingBase
      // 3b: goto 3f
      // 3e: aconst_null
      // 3f: putstatic x/ocdd342096f8.ѐ Lnet/minecraft/entity/EntityLivingBase;
      // 42: return
   }

   static void Ӛ(boolean param0, boolean param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: iload 0
      // 05: iload 2
      // 06: ifne 38
      // 09: ifeq 22
      // 0c: goto 10
      // 0f: athrow
      // 10: new net/minecraft/network/play/client/C0APacketAnimation
      // 13: dup
      // 14: invokespecial net/minecraft/network/play/client/C0APacketAnimation.<init> ()V
      // 17: invokestatic x/oc0f63871c3b.Щ (Lnet/minecraft/network/Packet;)V
      // 1a: iload 2
      // 1b: ifeq 44
      // 1e: goto 22
      // 21: athrow
      // 22: invokestatic x/oc7c017b256e.ɥ ()Lnet/minecraft/client/Minecraft;
      // 25: iload 2
      // 26: ifne 3e
      // 29: goto 2d
      // 2c: athrow
      // 2d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 30: invokevirtual net/minecraft/client/entity/EntityPlayerSP.swingItem ()V
      // 33: iload 1
      // 34: goto 38
      // 37: athrow
      // 38: ifeq 44
      // 3b: invokestatic x/oc7c017b256e.ɥ ()Lnet/minecraft/client/Minecraft;
      // 3e: invokevirtual net/minecraft/client/Minecraft.getItemRenderer ()Lnet/minecraft/client/renderer/ItemRenderer;
      // 41: invokevirtual net/minecraft/client/renderer/ItemRenderer.resetEquippedProgress ()V
      // 44: return
   }

   static boolean Ů(Entity var0) {
      int var10000 = oc5e549848f3.İ;
      oce021a2e586 var2 = (oce021a2e586)oc9755810e45.ʬ(oce021a2e586.class);
      int var1 = var10000;

      label46: {
         label33: {
            try {
               var6 = var2;
               if (var1 != 0) {
                  break label33;
               }

               if (var2 == null) {
                  return false;
               }
            } catch (ocbde1165e4e var5) {
               throw var5;
            }

            var6 = var2;
         }

         try {
            boolean var7 = var6.z$3rzb3dil7uydr();
            if (var1 != 0) {
               return var7;
            }

            if (var7) {
               break label46;
            }
         } catch (ocbde1165e4e var4) {
            throw var4;
         }

         return false;
      }

      oc507025139f var3 = new oc507025139f(new MovingObjectPosition(var0, var0.getPositionVector()));
      var2.ѭ(var3);
      return var3.isCanceled();
   }

   static boolean Ӿ(EntityPlayer var0) {
      return oc7ab2161b9f.Ӭ(var0);
   }

   static boolean Ȣ(Entity param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 1
      // 04: aload 0
      // 05: instanceof net/minecraft/entity/monster/EntityMob
      // 08: iload 1
      // 09: ifne 3a
      // 0c: ifne 39
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: instanceof net/minecraft/entity/monster/EntityGolem
      // 17: iload 1
      // 18: ifne 3a
      // 1b: goto 1f
      // 1e: athrow
      // 1f: ifne 39
      // 22: goto 26
      // 25: athrow
      // 26: aload 0
      // 27: instanceof net/minecraft/entity/monster/EntitySlime
      // 2a: iload 1
      // 2b: ifne 3a
      // 2e: goto 32
      // 31: athrow
      // 32: ifeq 3d
      // 35: goto 39
      // 38: athrow
      // 39: bipush 1
      // 3a: goto 3e
      // 3d: bipush 0
      // 3e: ireturn
   }

   static boolean Ͱ() {
      int var0 = oc5e549848f3.İ;

      oc668fce0dbf var10000;
      label33: {
         try {
            var10000 = oc9755810e45.ǜ;
            if (var0 != 0) {
               break label33;
            }

            if (oc9755810e45.ǜ == null) {
               return false;
            }
         } catch (ocbde1165e4e var2) {
            throw var2;
         }

         var10000 = oc9755810e45.ǜ;
      }

      try {
         boolean var3 = var10000.z$3rzb3dil7uydr();
         if (var0 != 0) {
            return var3;
         }

         if (var3) {
            return true;
         }
      } catch (ocbde1165e4e var1) {
         throw var1;
      }

      return false;
   }

   static boolean Ж() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 0
      // 04: getstatic x/oc718fd4d503.Ō Lx/oc718fd4d503;
      // 07: invokevirtual x/oc718fd4d503.Բ ()I
      // 0a: iload 0
      // 0b: ifne 1d
      // 0e: invokestatic x/oc7c017b256e.Ǹ ()I
      // 11: if_icmpeq 20
      // 14: goto 18
      // 17: athrow
      // 18: bipush 1
      // 19: goto 1d
      // 1c: athrow
      // 1d: goto 21
      // 20: bipush 0
      // 21: ireturn
   }

   static boolean ę() {
      int var0 = oc5e549848f3.İ;

      oca3ff10b94f var10000;
      label33: {
         try {
            var10000 = oc9755810e45.ğ;
            if (var0 != 0) {
               break label33;
            }

            if (oc9755810e45.ğ == null) {
               return false;
            }
         } catch (ocbde1165e4e var2) {
            throw var2;
         }

         var10000 = oc9755810e45.ğ;
      }

      try {
         boolean var3 = var10000.έ();
         if (var0 != 0) {
            return var3;
         }

         if (var3) {
            return true;
         }
      } catch (ocbde1165e4e var1) {
         throw var1;
      }

      return false;
   }

   static boolean Հ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 0
      // 04: getstatic x/oc9755810e45.ϔ Lx/oc8edd24b1ed;
      // 07: iload 0
      // 08: ifne 1d
      // 0b: ifnull 35
      // 0e: goto 12
      // 11: athrow
      // 12: getstatic x/oc9755810e45.ϔ Lx/oc8edd24b1ed;
      // 15: iload 0
      // 16: ifne 2a
      // 19: goto 1d
      // 1c: athrow
      // 1d: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 20: ifeq 35
      // 23: getstatic x/oc9755810e45.ϔ Lx/oc8edd24b1ed;
      // 26: goto 2a
      // 29: athrow
      // 2a: invokevirtual x/oc8edd24b1ed.ԓ ()Lnet/minecraft/util/BlockPos;
      // 2d: ifnull 35
      // 30: bipush 1
      // 31: goto 36
      // 34: athrow
      // 35: bipush 0
      // 36: ireturn
   }

   static boolean ɺ() {
      int var0 = oc5e549848f3.İ;

      oc8edd24b1ed var10000;
      label33: {
         try {
            var10000 = oc9755810e45.ϔ;
            if (var0 != 0) {
               break label33;
            }

            if (oc9755810e45.ϔ == null) {
               return false;
            }
         } catch (ocbde1165e4e var2) {
            throw var2;
         }

         var10000 = oc9755810e45.ϔ;
      }

      try {
         boolean var3 = var10000.Ɵ();
         if (var0 != 0) {
            return var3;
         }

         if (var3) {
            return true;
         }
      } catch (ocbde1165e4e var1) {
         throw var1;
      }

      return false;
   }

   static boolean Ľ(boolean param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 1
      // 04: invokestatic x/oc7c017b256e.Ԓ ()Z
      // 07: ifne 66
      // 0a: getstatic x/oc9755810e45.ǜ Lx/oc668fce0dbf;
      // 0d: iload 1
      // 0e: ifne 1f
      // 11: goto 15
      // 14: athrow
      // 15: ifnull 2d
      // 18: goto 1c
      // 1b: athrow
      // 1c: getstatic x/oc9755810e45.ǜ Lx/oc668fce0dbf;
      // 1f: invokevirtual x/oc668fce0dbf.Ƶ ()Z
      // 22: iload 1
      // 23: ifne 30
      // 26: ifeq 66
      // 29: goto 2d
      // 2c: athrow
      // 2d: invokestatic x/oc7c017b256e.Հ ()Z
      // 30: iload 1
      // 31: ifne 63
      // 34: ifeq 62
      // 37: goto 3b
      // 3a: athrow
      // 3b: getstatic x/oc9755810e45.ϔ Lx/oc8edd24b1ed;
      // 3e: invokevirtual x/oc8edd24b1ed.Ƴ ()Z
      // 41: iload 1
      // 42: ifne 63
      // 45: goto 49
      // 48: athrow
      // 49: ifeq 62
      // 4c: goto 50
      // 4f: athrow
      // 50: invokestatic x/oc7c017b256e.ɺ ()Z
      // 53: iload 1
      // 54: ifne 63
      // 57: goto 5b
      // 5a: athrow
      // 5b: ifeq 66
      // 5e: goto 62
      // 61: athrow
      // 62: bipush 1
      // 63: goto 67
      // 66: bipush 0
      // 67: ireturn
   }

   static boolean Ԓ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: invokestatic x/ocf5b7e839f8.ȱ ()Ljava/lang/Object;
      // 03: astore 0
      // 04: aload 0
      // 05: instanceof x/ocd7a10d0610
      // 08: ifne 21
      // 0b: aload 0
      // 0c: instanceof x/oc643c1c9225
      // 0f: ifne 21
      // 12: goto 16
      // 15: athrow
      // 16: aload 0
      // 17: instanceof x/ocb58b5235c7
      // 1a: ifeq 26
      // 1d: goto 21
      // 20: athrow
      // 21: bipush 1
      // 22: goto 27
      // 25: athrow
      // 26: bipush 0
      // 27: ireturn
   }

   static Block Ϭ(BlockPos var0) {
      return ɥ().theWorld.getBlockState(var0).getBlock();
   }

   static void Ǭ() {
      float var0 = oc4557683e94.Ҳ();
      ɥ().thePlayer.movementInput.moveForward *= var0;
      ɥ().thePlayer.movementInput.moveStrafe *= var0;
   }

   public static float[] ҭ(Vec3 param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: invokestatic x/oc7c017b256e.ɥ ()Lnet/minecraft/client/Minecraft;
      // 06: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 09: getfield net/minecraft/client/entity/EntityPlayerSP.posX D
      // 0c: dstore 2
      // 0d: istore 1
      // 0e: invokestatic x/oc7c017b256e.ɥ ()Lnet/minecraft/client/Minecraft;
      // 11: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 14: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // 17: invokestatic x/oc7c017b256e.ɥ ()Lnet/minecraft/client/Minecraft;
      // 1a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1d: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getEyeHeight ()F
      // 20: f2d
      // 21: dadd
      // 22: dstore 4
      // 24: invokestatic x/oc7c017b256e.ɥ ()Lnet/minecraft/client/Minecraft;
      // 27: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 2a: getfield net/minecraft/client/entity/EntityPlayerSP.posZ D
      // 2d: dstore 6
      // 2f: aload 0
      // 30: getfield net/minecraft/util/Vec3.xCoord D
      // 33: iload 1
      // 34: ifne 77
      // 37: dload 2
      // 38: dcmpl
      // 39: ifne 71
      // 3c: goto 40
      // 3f: athrow
      // 40: aload 0
      // 41: getfield net/minecraft/util/Vec3.yCoord D
      // 44: iload 1
      // 45: ifne 77
      // 48: goto 4c
      // 4b: athrow
      // 4c: dload 4
      // 4e: dcmpl
      // 4f: ifne 71
      // 52: goto 56
      // 55: athrow
      // 56: aload 0
      // 57: iload 1
      // 58: ifne 72
      // 5b: goto 5f
      // 5e: athrow
      // 5f: getfield net/minecraft/util/Vec3.zCoord D
      // 62: dload 6
      // 64: dcmpl
      // 65: ifne 71
      // 68: goto 6c
      // 6b: athrow
      // 6c: invokestatic x/oc7c017b256e.ʪ ()[F
      // 6f: areturn
      // 70: athrow
      // 71: aload 0
      // 72: getfield net/minecraft/util/Vec3.xCoord D
      // 75: dload 2
      // 76: dsub
      // 77: aload 0
      // 78: getfield net/minecraft/util/Vec3.yCoord D
      // 7b: dload 4
      // 7d: dsub
      // 7e: aload 0
      // 7f: getfield net/minecraft/util/Vec3.zCoord D
      // 82: dload 6
      // 84: dsub
      // 85: invokestatic x/oc7c017b256e.Ձ (DDD)[F
      // 88: areturn
   }

   public static float[] ɬ(Entity param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 14
      // 09: ifnonnull 13
      // 0c: goto 10
      // 0f: athrow
      // 10: aconst_null
      // 11: areturn
      // 12: athrow
      // 13: aload 0
      // 14: aload 0
      // 15: invokevirtual net/minecraft/entity/Entity.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 18: invokestatic x/oc7c017b256e.Ȳ (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/AxisAlignedBB;)[F
      // 1b: areturn
   }

   public static float[] Ȳ(Entity param0, AxisAlignedBB param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 14
      // 09: ifnonnull 13
      // 0c: goto 10
      // 0f: athrow
      // 10: aconst_null
      // 11: areturn
      // 12: athrow
      // 13: aload 0
      // 14: invokevirtual net/minecraft/entity/Entity.getCollisionBorderSize ()F
      // 17: fstore 4
      // 19: aload 1
      // 1a: fload 4
      // 1c: f2d
      // 1d: fload 4
      // 1f: f2d
      // 20: fload 4
      // 22: f2d
      // 23: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 26: dup
      // 27: astore 1
      // 28: invokestatic x/oc7c017b256e.ɥ ()Lnet/minecraft/client/Minecraft;
      // 2b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 2e: fconst_1
      // 2f: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 32: dup
      // 33: astore 3
      // 34: invokevirtual net/minecraft/util/AxisAlignedBB.isVecInside (Lnet/minecraft/util/Vec3;)Z
      // 37: iload 2
      // 38: ifne 49
      // 3b: ifeq 64
      // 3e: goto 42
      // 41: athrow
      // 42: ldc_w -1827261163
      // 45: ldc_w -1827261161
      // 48: ixor
      // 49: newarray 6
      // 4b: dup
      // 4c: bipush 0
      // 4d: invokestatic x/oc7c017b256e.ɥ ()Lnet/minecraft/client/Minecraft;
      // 50: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 53: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 56: fastore
      // 57: dup
      // 58: bipush 1
      // 59: invokestatic x/oc7c017b256e.ɥ ()Lnet/minecraft/client/Minecraft;
      // 5c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 5f: getfield net/minecraft/client/entity/EntityPlayerSP.rotationPitch F
      // 62: fastore
      // 63: areturn
      // 64: aload 3
      // 65: aload 1
      // 66: invokestatic x/oc7c017b256e.ύ (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/AxisAlignedBB;)Lnet/minecraft/util/Vec3;
      // 69: astore 5
      // 6b: aload 5
      // 6d: getfield net/minecraft/util/Vec3.xCoord D
      // 70: aload 3
      // 71: getfield net/minecraft/util/Vec3.xCoord D
      // 74: dsub
      // 75: aload 5
      // 77: getfield net/minecraft/util/Vec3.yCoord D
      // 7a: aload 3
      // 7b: getfield net/minecraft/util/Vec3.yCoord D
      // 7e: dsub
      // 7f: aload 5
      // 81: getfield net/minecraft/util/Vec3.zCoord D
      // 84: aload 3
      // 85: getfield net/minecraft/util/Vec3.zCoord D
      // 88: dsub
      // 89: invokestatic x/oc7c017b256e.Ձ (DDD)[F
      // 8c: areturn
   }

   public static Vec3 ύ(Vec3 var0, AxisAlignedBB var1) {
      double var2 = (var1.minX + var1.maxX) / 2.0;
      double var4 = var1.minY + (var1.maxY - var1.minY) * 0.825;
      double var6 = (var1.minZ + var1.maxZ) / 2.0;
      double var8 = MathHelper.clamp_double(var0.xCoord, var1.minX + 0.03, var1.maxX - 0.03);
      double var10 = MathHelper.clamp_double(var0.yCoord, var1.minY + 0.03, var1.maxY - 0.03);
      double var12 = MathHelper.clamp_double(var0.zCoord, var1.minZ + 0.03, var1.maxZ - 0.03);
      return new Vec3(var2 + (var8 - var2) * 0.9, var4 + (var10 - var4) * 0.9, var6 + (var12 - var6) * 0.9);
   }

   public static Vec3 Ѩ(Entity param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: invokestatic x/oc7c017b256e.ɥ ()Lnet/minecraft/client/Minecraft;
      // 03: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 06: fconst_1
      // 07: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 0a: astore 2
      // 0b: getstatic x/oc5e549848f3.İ I
      // 0e: aload 0
      // 0f: invokevirtual net/minecraft/entity/Entity.getCollisionBorderSize ()F
      // 12: fstore 3
      // 13: istore 1
      // 14: aload 0
      // 15: invokevirtual net/minecraft/entity/Entity.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 18: fload 3
      // 19: f2d
      // 1a: fload 3
      // 1b: f2d
      // 1c: fload 3
      // 1d: f2d
      // 1e: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 21: astore 4
      // 23: aload 4
      // 25: aload 2
      // 26: invokevirtual net/minecraft/util/AxisAlignedBB.isVecInside (Lnet/minecraft/util/Vec3;)Z
      // 29: ifeq 2f
      // 2c: aload 2
      // 2d: areturn
      // 2e: athrow
      // 2f: aload 2
      // 30: aload 4
      // 32: invokestatic x/oc7c017b256e.ύ (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/AxisAlignedBB;)Lnet/minecraft/util/Vec3;
      // 35: astore 5
      // 37: aload 2
      // 38: iload 1
      // 39: ifne 51
      // 3c: aload 5
      // 3e: invokestatic x/ocffa9e799de.Ǌ (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Z
      // 41: ifeq 4c
      // 44: goto 48
      // 47: athrow
      // 48: aload 5
      // 4a: areturn
      // 4b: athrow
      // 4c: aload 0
      // 4d: aload 2
      // 4e: invokestatic x/oc7c017b256e.Н (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/Vec3;
      // 51: areturn
   }

   public static Vec3 Н(Entity param0, Vec3 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: aload 0
      // 001: getfield net/minecraft/entity/Entity.posX D
      // 004: dstore 3
      // 005: getstatic x/oc5e549848f3.İ I
      // 008: aload 0
      // 009: getfield net/minecraft/entity/Entity.posY D
      // 00c: dstore 5
      // 00e: aload 0
      // 00f: getfield net/minecraft/entity/Entity.posZ D
      // 012: dstore 7
      // 014: istore 2
      // 015: aload 0
      // 016: invokevirtual net/minecraft/entity/Entity.getEyeHeight ()F
      // 019: f2d
      // 01a: dstore 9
      // 01c: dload 9
      // 01e: ldc2_w 0.2
      // 021: dsub
      // 022: dstore 11
      // 024: dload 9
      // 026: ldc2_w 0.9
      // 029: dsub
      // 02a: dstore 13
      // 02c: dload 9
      // 02e: ldc2_w 1.5
      // 031: dsub
      // 032: dstore 15
      // 034: ldc2_w 0.28
      // 037: dstore 17
      // 039: ldc_w 1079186538
      // 03c: ldc_w 1079186555
      // 03f: ixor
      // 040: anewarray 169
      // 043: dup
      // 044: bipush 0
      // 045: new net/minecraft/util/Vec3
      // 048: dup
      // 049: dload 3
      // 04a: dload 5
      // 04c: dload 9
      // 04e: ldc2_w 0.2
      // 051: dadd
      // 052: dadd
      // 053: dload 7
      // 055: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 058: aastore
      // 059: dup
      // 05a: bipush 1
      // 05b: new net/minecraft/util/Vec3
      // 05e: dup
      // 05f: dload 3
      // 060: dload 5
      // 062: dload 9
      // 064: ldc2_w 0.6
      // 067: dsub
      // 068: dadd
      // 069: dload 7
      // 06b: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 06e: aastore
      // 06f: dup
      // 070: ldc_w 1079186553
      // 073: ldc_w 1079186555
      // 076: ixor
      // 077: new net/minecraft/util/Vec3
      // 07a: dup
      // 07b: dload 3
      // 07c: dload 5
      // 07e: dload 13
      // 080: dadd
      // 081: dload 7
      // 083: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 086: aastore
      // 087: dup
      // 088: ldc_w 1079186552
      // 08b: ldc_w 1079186555
      // 08e: ixor
      // 08f: new net/minecraft/util/Vec3
      // 092: dup
      // 093: dload 3
      // 094: dload 5
      // 096: dload 9
      // 098: ldc2_w 1.2
      // 09b: dsub
      // 09c: dadd
      // 09d: dload 7
      // 09f: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 0a2: aastore
      // 0a3: dup
      // 0a4: ldc_w 1079186559
      // 0a7: ldc_w 1079186555
      // 0aa: ixor
      // 0ab: new net/minecraft/util/Vec3
      // 0ae: dup
      // 0af: dload 3
      // 0b0: dload 5
      // 0b2: dload 15
      // 0b4: dadd
      // 0b5: dload 7
      // 0b7: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 0ba: aastore
      // 0bb: dup
      // 0bc: ldc_w 1079186558
      // 0bf: ldc_w 1079186555
      // 0c2: ixor
      // 0c3: new net/minecraft/util/Vec3
      // 0c6: dup
      // 0c7: dload 3
      // 0c8: dload 17
      // 0ca: dadd
      // 0cb: dload 5
      // 0cd: dload 11
      // 0cf: dadd
      // 0d0: dload 7
      // 0d2: dload 17
      // 0d4: dadd
      // 0d5: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 0d8: aastore
      // 0d9: dup
      // 0da: ldc_w 1079186557
      // 0dd: ldc_w 1079186555
      // 0e0: ixor
      // 0e1: new net/minecraft/util/Vec3
      // 0e4: dup
      // 0e5: dload 3
      // 0e6: dload 17
      // 0e8: dadd
      // 0e9: dload 5
      // 0eb: dload 11
      // 0ed: dadd
      // 0ee: dload 7
      // 0f0: dload 17
      // 0f2: dsub
      // 0f3: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 0f6: aastore
      // 0f7: dup
      // 0f8: ldc_w 1079186556
      // 0fb: ldc_w 1079186555
      // 0fe: ixor
      // 0ff: new net/minecraft/util/Vec3
      // 102: dup
      // 103: dload 3
      // 104: dload 17
      // 106: dsub
      // 107: dload 5
      // 109: dload 11
      // 10b: dadd
      // 10c: dload 7
      // 10e: dload 17
      // 110: dadd
      // 111: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 114: aastore
      // 115: dup
      // 116: ldc_w 1079186547
      // 119: ldc_w 1079186555
      // 11c: ixor
      // 11d: new net/minecraft/util/Vec3
      // 120: dup
      // 121: dload 3
      // 122: dload 17
      // 124: dsub
      // 125: dload 5
      // 127: dload 11
      // 129: dadd
      // 12a: dload 7
      // 12c: dload 17
      // 12e: dsub
      // 12f: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 132: aastore
      // 133: dup
      // 134: ldc_w 1079186546
      // 137: ldc_w 1079186555
      // 13a: ixor
      // 13b: new net/minecraft/util/Vec3
      // 13e: dup
      // 13f: dload 3
      // 140: dload 17
      // 142: dadd
      // 143: dload 5
      // 145: dload 13
      // 147: dadd
      // 148: dload 7
      // 14a: dload 17
      // 14c: dadd
      // 14d: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 150: aastore
      // 151: dup
      // 152: ldc_w 1079186545
      // 155: ldc_w 1079186555
      // 158: ixor
      // 159: new net/minecraft/util/Vec3
      // 15c: dup
      // 15d: dload 3
      // 15e: dload 17
      // 160: dadd
      // 161: dload 5
      // 163: dload 13
      // 165: dadd
      // 166: dload 7
      // 168: dload 17
      // 16a: dsub
      // 16b: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 16e: aastore
      // 16f: dup
      // 170: ldc_w 1079186544
      // 173: ldc_w 1079186555
      // 176: ixor
      // 177: new net/minecraft/util/Vec3
      // 17a: dup
      // 17b: dload 3
      // 17c: dload 17
      // 17e: dsub
      // 17f: dload 5
      // 181: dload 13
      // 183: dadd
      // 184: dload 7
      // 186: dload 17
      // 188: dadd
      // 189: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 18c: aastore
      // 18d: dup
      // 18e: ldc_w 1079186551
      // 191: ldc_w 1079186555
      // 194: ixor
      // 195: new net/minecraft/util/Vec3
      // 198: dup
      // 199: dload 3
      // 19a: dload 17
      // 19c: dsub
      // 19d: dload 5
      // 19f: dload 13
      // 1a1: dadd
      // 1a2: dload 7
      // 1a4: dload 17
      // 1a6: dsub
      // 1a7: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 1aa: aastore
      // 1ab: dup
      // 1ac: ldc_w 1079186550
      // 1af: ldc_w 1079186555
      // 1b2: ixor
      // 1b3: new net/minecraft/util/Vec3
      // 1b6: dup
      // 1b7: dload 3
      // 1b8: dload 17
      // 1ba: dadd
      // 1bb: dload 5
      // 1bd: dload 15
      // 1bf: dadd
      // 1c0: dload 7
      // 1c2: dload 17
      // 1c4: dadd
      // 1c5: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 1c8: aastore
      // 1c9: dup
      // 1ca: ldc_w 1079186549
      // 1cd: ldc_w 1079186555
      // 1d0: ixor
      // 1d1: new net/minecraft/util/Vec3
      // 1d4: dup
      // 1d5: dload 3
      // 1d6: dload 17
      // 1d8: dadd
      // 1d9: dload 5
      // 1db: dload 15
      // 1dd: dadd
      // 1de: dload 7
      // 1e0: dload 17
      // 1e2: dsub
      // 1e3: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 1e6: aastore
      // 1e7: dup
      // 1e8: ldc_w 1079186548
      // 1eb: ldc_w 1079186555
      // 1ee: ixor
      // 1ef: new net/minecraft/util/Vec3
      // 1f2: dup
      // 1f3: dload 3
      // 1f4: dload 17
      // 1f6: dsub
      // 1f7: dload 5
      // 1f9: dload 15
      // 1fb: dadd
      // 1fc: dload 7
      // 1fe: dload 17
      // 200: dadd
      // 201: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 204: aastore
      // 205: dup
      // 206: ldc_w 1079186539
      // 209: ldc_w 1079186555
      // 20c: ixor
      // 20d: new net/minecraft/util/Vec3
      // 210: dup
      // 211: dload 3
      // 212: dload 17
      // 214: dsub
      // 215: dload 5
      // 217: dload 15
      // 219: dadd
      // 21a: dload 7
      // 21c: dload 17
      // 21e: dsub
      // 21f: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 222: aastore
      // 223: astore 19
      // 225: aload 19
      // 227: astore 20
      // 229: aload 20
      // 22b: arraylength
      // 22c: istore 21
      // 22e: bipush 0
      // 22f: istore 22
      // 231: iload 22
      // 233: iload 21
      // 235: if_icmpge 268
      // 238: aload 20
      // 23a: iload 22
      // 23c: aaload
      // 23d: astore 23
      // 23f: iload 2
      // 240: ifne 257
      // 243: aload 1
      // 244: aload 23
      // 246: invokestatic x/ocffa9e799de.Ǌ (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Z
      // 249: ifeq 254
      // 24c: goto 250
      // 24f: athrow
      // 250: aload 23
      // 252: areturn
      // 253: athrow
      // 254: iinc 22 1
      // 257: iload 2
      // 258: ifeq 231
      // 25b: bipush 0
      // 25c: ifeq 264
      // 25f: bipush 0
      // 260: goto 265
      // 263: athrow
      // 264: bipush 1
      // 265: putstatic x/oc69da1aa7f5.Ҭ Z
      // 268: aconst_null
      // 269: areturn
   }

   public static boolean K(Entity param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: invokestatic x/oc7c017b256e.ɥ ()Lnet/minecraft/client/Minecraft;
      // 003: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 006: fconst_1
      // 007: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 00a: astore 2
      // 00b: getstatic x/oc5e549848f3.İ I
      // 00e: aload 0
      // 00f: getfield net/minecraft/entity/Entity.posX D
      // 012: dstore 3
      // 013: istore 1
      // 014: aload 0
      // 015: getfield net/minecraft/entity/Entity.posY D
      // 018: dstore 5
      // 01a: aload 0
      // 01b: getfield net/minecraft/entity/Entity.posZ D
      // 01e: dstore 7
      // 020: aload 0
      // 021: invokevirtual net/minecraft/entity/Entity.getEyeHeight ()F
      // 024: f2d
      // 025: ldc2_w 0.2
      // 028: dsub
      // 029: dstore 9
      // 02b: aload 2
      // 02c: iload 1
      // 02d: ifne 050
      // 030: new net/minecraft/util/Vec3
      // 033: dup
      // 034: dload 3
      // 035: ldc2_w 0.3
      // 038: dadd
      // 039: dload 5
      // 03b: dload 9
      // 03d: dadd
      // 03e: dload 7
      // 040: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 043: invokestatic x/ocffa9e799de.Ǌ (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Z
      // 046: ifeq 04f
      // 049: goto 04d
      // 04c: athrow
      // 04d: bipush 1
      // 04e: ireturn
      // 04f: aload 2
      // 050: iload 1
      // 051: ifne 074
      // 054: new net/minecraft/util/Vec3
      // 057: dup
      // 058: dload 3
      // 059: ldc2_w 0.3
      // 05c: dsub
      // 05d: dload 5
      // 05f: dload 9
      // 061: dadd
      // 062: dload 7
      // 064: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 067: invokestatic x/ocffa9e799de.Ǌ (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Z
      // 06a: ifeq 073
      // 06d: goto 071
      // 070: athrow
      // 071: bipush 1
      // 072: ireturn
      // 073: aload 2
      // 074: iload 1
      // 075: ifne 098
      // 078: new net/minecraft/util/Vec3
      // 07b: dup
      // 07c: dload 3
      // 07d: dload 5
      // 07f: dload 9
      // 081: dadd
      // 082: dload 7
      // 084: ldc2_w 0.3
      // 087: dadd
      // 088: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 08b: invokestatic x/ocffa9e799de.Ǌ (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Z
      // 08e: ifeq 097
      // 091: goto 095
      // 094: athrow
      // 095: bipush 1
      // 096: ireturn
      // 097: aload 2
      // 098: new net/minecraft/util/Vec3
      // 09b: dup
      // 09c: dload 3
      // 09d: dload 5
      // 09f: dload 9
      // 0a1: dadd
      // 0a2: dload 7
      // 0a4: ldc2_w 0.3
      // 0a7: dsub
      // 0a8: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 0ab: invokestatic x/ocffa9e799de.Ǌ (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Z
      // 0ae: iload 1
      // 0af: ifne 0ba
      // 0b2: ifeq 0bb
      // 0b5: goto 0b9
      // 0b8: athrow
      // 0b9: bipush 1
      // 0ba: ireturn
      // 0bb: aload 0
      // 0bc: invokevirtual net/minecraft/entity/Entity.getEyeHeight ()F
      // 0bf: f2d
      // 0c0: ldc2_w 0.2
      // 0c3: dadd
      // 0c4: dstore 11
      // 0c6: dload 11
      // 0c8: dconst_0
      // 0c9: dcmpl
      // 0ca: ifle 104
      // 0cd: aload 2
      // 0ce: new net/minecraft/util/Vec3
      // 0d1: dup
      // 0d2: dload 3
      // 0d3: dload 5
      // 0d5: dload 11
      // 0d7: dadd
      // 0d8: dload 7
      // 0da: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 0dd: invokestatic x/ocffa9e799de.Ǌ (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Z
      // 0e0: iload 1
      // 0e1: ifne 105
      // 0e4: iload 1
      // 0e5: ifne 0f7
      // 0e8: goto 0ec
      // 0eb: athrow
      // 0ec: ifne 0f6
      // 0ef: goto 0f3
      // 0f2: athrow
      // 0f3: goto 0f8
      // 0f6: bipush 1
      // 0f7: ireturn
      // 0f8: dload 11
      // 0fa: ldc2_w 0.2
      // 0fd: dsub
      // 0fe: dstore 11
      // 100: iload 1
      // 101: ifeq 0c6
      // 104: bipush 0
      // 105: ireturn
   }

   public static float[] Ձ(double var0, double var2, double var4) {
      double var6 = Math.sqrt(var0 * var0 + var4 * var4);
      float var8 = (float)(Math.atan2(var4, var0) * (float) (180.0 / Math.PI)) - 90.0F;
      float var9 = (float)(-(Math.atan2(var2, var6) * (float) (180.0 / Math.PI)));
      float[] var10 = Ñ();
      var8 = var10[0] + MathHelper.wrapAngleTo180_float(var8 - var10[0]);
      var9 = ɝ(var10[1] + MathHelper.wrapAngleTo180_float(var9 - var10[1]));
      float[] var10000 = new float[1097229335 ^ 1097229333];
      var10000[0] = var8;
      var10000[1] = var9;
      return var10000;
   }

   public static boolean p(Entity var0, AxisAlignedBB var1, float var2, float var3, double var4) {
      int var6 = oc5e549848f3.İ;

      label63: {
         Entity var10000;
         label47: {
            try {
               var10000 = var0;
               if (var6 != 0) {
                  break label47;
               }

               if (var0 == null) {
                  return false;
               }
            } catch (ocbde1165e4e var13) {
               throw var13;
            }

            var10000 = var0;
         }

         try {
            boolean var15 = var10000.canBeCollidedWith();
            if (var6 != 0) {
               return var15;
            }

            if (var15) {
               break label63;
            }
         } catch (ocbde1165e4e var12) {
            throw var12;
         }

         return false;
      }

      Vec3 var7 = ɥ().thePlayer.getPositionEyes(1.0F);
      Vec3 var8 = oc75d51ec7eb.ď(var3, var2);
      Vec3 var9 = var7.addVector(var8.xCoord * var4, var8.yCoord * var4, var8.zCoord * var4);
      float var10 = var0.getCollisionBorderSize();
      var1 = var1.expand(var10, var10, var10);

      try {
         if (var1.calculateIntercept(var7, var9) != null) {
            return true;
         }
      } catch (ocbde1165e4e var11) {
         throw var11;
      }

      return false;
   }

   public static boolean ǽ(Entity param0, float param1, float param2, double param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 5
      // 05: aload 0
      // 06: iload 5
      // 08: ifne 16
      // 0b: ifnonnull 15
      // 0e: goto 12
      // 11: athrow
      // 12: bipush 0
      // 13: ireturn
      // 14: athrow
      // 15: aload 0
      // 16: aload 0
      // 17: invokevirtual net/minecraft/entity/Entity.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 1a: fload 1
      // 1b: fload 2
      // 1c: dload 3
      // 1d: invokestatic x/oc7c017b256e.p (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/AxisAlignedBB;FFD)Z
      // 20: ireturn
   }

   public static boolean ˤ(Entity var0, double var1) {
      float[] var3 = ɬ(var0);
      return ǽ(var0, var3[0], var3[1], var1);
   }

   public static boolean ў(EntityLivingBase param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 1
      // 04: aload 0
      // 05: invokevirtual net/minecraft/entity/EntityLivingBase.isInvisible ()Z
      // 08: iload 1
      // 09: ifne 17
      // 0c: ifne 16
      // 0f: goto 13
      // 12: athrow
      // 13: bipush 0
      // 14: ireturn
      // 15: athrow
      // 16: bipush 0
      // 17: istore 2
      // 18: iload 2
      // 19: ldc_w 1730816524
      // 1c: ldc_w 1730816520
      // 1f: ixor
      // 20: if_icmpgt 38
      // 23: aload 0
      // 24: iload 2
      // 25: invokevirtual net/minecraft/entity/EntityLivingBase.getEquipmentInSlot (I)Lnet/minecraft/item/ItemStack;
      // 28: ifnonnull 2f
      // 2b: goto 31
      // 2e: athrow
      // 2f: bipush 0
      // 30: ireturn
      // 31: iinc 2 1
      // 34: iload 1
      // 35: ifeq 18
      // 38: bipush 1
      // 39: ireturn
   }

   public static boolean Չ(float param0, double param1, double param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: fload 0
      // 04: f2d
      // 05: ldc2_w 0.5
      // 08: dmul
      // 09: d2f
      // 0a: fstore 0
      // 0b: istore 5
      // 0d: invokestatic x/oc7c017b256e.ɥ ()Lnet/minecraft/client/Minecraft;
      // 10: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 13: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 16: dload 1
      // 17: dload 3
      // 18: invokestatic x/oc7c017b256e.ɟ (DD)F
      // 1b: fsub
      // 1c: ldc_w 360.0
      // 1f: frem
      // 20: f2d
      // 21: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_double (D)D
      // 24: dstore 6
      // 26: dload 6
      // 28: dconst_0
      // 29: iload 5
      // 2b: ifne 56
      // 2e: dcmpl
      // 2f: ifle 51
      // 32: goto 36
      // 35: athrow
      // 36: dload 6
      // 38: fload 0
      // 39: f2d
      // 3a: dcmpg
      // 3b: iload 5
      // 3d: ifne 4c
      // 40: goto 44
      // 43: athrow
      // 44: ifge 4f
      // 47: goto 4b
      // 4a: athrow
      // 4b: bipush 1
      // 4c: goto 50
      // 4f: bipush 0
      // 50: ireturn
      // 51: dload 6
      // 53: fload 0
      // 54: fneg
      // 55: f2d
      // 56: dcmpl
      // 57: iload 5
      // 59: ifne 64
      // 5c: ifle 67
      // 5f: goto 63
      // 62: athrow
      // 63: bipush 1
      // 64: goto 68
      // 67: bipush 0
      // 68: ireturn
   }

   public static boolean Ǳ(float param0, Entity param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: fload 0
      // 05: ldc_w 360.0
      // 08: fcmpl
      // 09: iload 2
      // 0a: ifne 15
      // 0d: iflt 16
      // 10: goto 14
      // 13: athrow
      // 14: bipush 1
      // 15: ireturn
      // 16: invokestatic x/oc7c017b256e.ɥ ()Lnet/minecraft/client/Minecraft;
      // 19: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1c: fconst_1
      // 1d: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 20: astore 3
      // 21: aload 1
      // 22: invokevirtual net/minecraft/entity/Entity.getCollisionBorderSize ()F
      // 25: fstore 4
      // 27: aload 1
      // 28: invokevirtual net/minecraft/entity/Entity.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 2b: fload 4
      // 2d: f2d
      // 2e: fload 4
      // 30: f2d
      // 31: fload 4
      // 33: f2d
      // 34: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 37: astore 5
      // 39: aload 5
      // 3b: aload 3
      // 3c: invokevirtual net/minecraft/util/AxisAlignedBB.isVecInside (Lnet/minecraft/util/Vec3;)Z
      // 3f: iload 2
      // 40: ifne 59
      // 43: ifeq 4d
      // 46: goto 4a
      // 49: athrow
      // 4a: bipush 1
      // 4b: ireturn
      // 4c: athrow
      // 4d: fload 0
      // 4e: aload 1
      // 4f: getfield net/minecraft/entity/Entity.posX D
      // 52: aload 1
      // 53: getfield net/minecraft/entity/Entity.posZ D
      // 56: invokestatic x/oc7c017b256e.Չ (FDD)Z
      // 59: ireturn
   }

   public static boolean ö(ItemStack param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 14
      // 09: ifnonnull 13
      // 0c: goto 10
      // 0f: athrow
      // 10: bipush 0
      // 11: ireturn
      // 12: athrow
      // 13: aload 0
      // 14: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 17: astore 2
      // 18: aload 2
      // 19: iload 1
      // 1a: ifne 2c
      // 1d: getstatic net/minecraft/init/Items.fire_charge Lnet/minecraft/item/Item;
      // 20: if_acmpeq c3
      // 23: goto 27
      // 26: athrow
      // 27: aload 2
      // 28: goto 2c
      // 2b: athrow
      // 2c: iload 1
      // 2d: ifne 3f
      // 30: getstatic net/minecraft/init/Items.ender_pearl Lnet/minecraft/item/Item;
      // 33: if_acmpeq c3
      // 36: goto 3a
      // 39: athrow
      // 3a: aload 2
      // 3b: goto 3f
      // 3e: athrow
      // 3f: iload 1
      // 40: ifne 52
      // 43: getstatic net/minecraft/init/Items.ender_eye Lnet/minecraft/item/Item;
      // 46: if_acmpeq c3
      // 49: goto 4d
      // 4c: athrow
      // 4d: aload 2
      // 4e: goto 52
      // 51: athrow
      // 52: iload 1
      // 53: ifne 65
      // 56: getstatic net/minecraft/init/Items.snowball Lnet/minecraft/item/Item;
      // 59: if_acmpeq c3
      // 5c: goto 60
      // 5f: athrow
      // 60: aload 2
      // 61: goto 65
      // 64: athrow
      // 65: iload 1
      // 66: ifne 78
      // 69: getstatic net/minecraft/init/Items.egg Lnet/minecraft/item/Item;
      // 6c: if_acmpeq c3
      // 6f: goto 73
      // 72: athrow
      // 73: aload 2
      // 74: goto 78
      // 77: athrow
      // 78: iload 1
      // 79: ifne 8b
      // 7c: getstatic net/minecraft/init/Items.experience_bottle Lnet/minecraft/item/Item;
      // 7f: if_acmpeq c3
      // 82: goto 86
      // 85: athrow
      // 86: aload 2
      // 87: goto 8b
      // 8a: athrow
      // 8b: iload 1
      // 8c: ifne 9e
      // 8f: getstatic net/minecraft/init/Items.nether_star Lnet/minecraft/item/Item;
      // 92: if_acmpeq c3
      // 95: goto 99
      // 98: athrow
      // 99: aload 2
      // 9a: goto 9e
      // 9d: athrow
      // 9e: iload 1
      // 9f: ifne b1
      // a2: getstatic net/minecraft/init/Items.potionitem Lnet/minecraft/item/ItemPotion;
      // a5: if_acmpne cb
      // a8: goto ac
      // ab: athrow
      // ac: aload 2
      // ad: goto b1
      // b0: athrow
      // b1: aload 0
      // b2: invokevirtual net/minecraft/item/Item.getMetadata (Lnet/minecraft/item/ItemStack;)I
      // b5: iload 1
      // b6: ifne c8
      // b9: invokestatic net/minecraft/item/ItemPotion.isSplash (I)Z
      // bc: ifeq cb
      // bf: goto c3
      // c2: athrow
      // c3: bipush 1
      // c4: goto c8
      // c7: athrow
      // c8: goto cc
      // cb: bipush 0
      // cc: ireturn
   }

   public static boolean ҁ(ItemStack param0, ItemStack param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 16
      // 09: ifnonnull 15
      // 0c: goto 10
      // 0f: athrow
      // 10: aconst_null
      // 11: goto 19
      // 14: athrow
      // 15: aload 0
      // 16: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 19: astore 3
      // 1a: aload 1
      // 1b: iload 2
      // 1c: ifne 2c
      // 1f: ifnonnull 2b
      // 22: goto 26
      // 25: athrow
      // 26: aconst_null
      // 27: goto 2f
      // 2a: athrow
      // 2b: aload 1
      // 2c: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 2f: astore 4
      // 31: aload 3
      // 32: aload 4
      // 34: if_acmpne 3c
      // 37: bipush 1
      // 38: goto 3d
      // 3b: athrow
      // 3c: bipush 0
      // 3d: ireturn
   }

   public static boolean ӷ(Block param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 1
      // 04: aload 0
      // 05: instanceof net/minecraft/block/BlockContainer
      // 08: iload 1
      // 09: ifne 36
      // 0c: ifne 31
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: iload 1
      // 15: ifne 2b
      // 18: goto 1c
      // 1b: athrow
      // 1c: getstatic net/minecraft/init/Blocks.crafting_table Lnet/minecraft/block/Block;
      // 1f: if_acmpeq 31
      // 22: goto 26
      // 25: athrow
      // 26: aload 0
      // 27: goto 2b
      // 2a: athrow
      // 2b: getstatic net/minecraft/init/Blocks.anvil Lnet/minecraft/block/Block;
      // 2e: if_acmpne 39
      // 31: bipush 1
      // 32: goto 36
      // 35: athrow
      // 36: goto 3a
      // 39: bipush 0
      // 3a: ireturn
   }

   public static boolean ƈ(Block param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 1
      // 04: aload 0
      // 05: invokestatic x/oc7c017b256e.ӷ (Lnet/minecraft/block/Block;)Z
      // 08: iload 1
      // 09: ifne 3e
      // 0c: ifne 39
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: iload 1
      // 15: ifne 2b
      // 18: goto 1c
      // 1b: athrow
      // 1c: getstatic net/minecraft/init/Blocks.bed Lnet/minecraft/block/Block;
      // 1f: if_acmpeq 39
      // 22: goto 26
      // 25: athrow
      // 26: aload 0
      // 27: goto 2b
      // 2a: athrow
      // 2b: iload 1
      // 2c: ifne 40
      // 2f: getstatic net/minecraft/init/Blocks.lever Lnet/minecraft/block/Block;
      // 32: if_acmpne 3f
      // 35: goto 39
      // 38: athrow
      // 39: bipush 1
      // 3a: goto 3e
      // 3d: athrow
      // 3e: ireturn
      // 3f: aload 0
      // 40: instanceof net/minecraft/block/BlockTrapDoor
      // 43: iload 1
      // 44: ifne 79
      // 47: ifne 74
      // 4a: goto 4e
      // 4d: athrow
      // 4e: aload 0
      // 4f: instanceof net/minecraft/block/BlockFence
      // 52: iload 1
      // 53: ifne 79
      // 56: goto 5a
      // 59: athrow
      // 5a: ifne 74
      // 5d: goto 61
      // 60: athrow
      // 61: aload 0
      // 62: iload 1
      // 63: ifne 7b
      // 66: goto 6a
      // 69: athrow
      // 6a: instanceof net/minecraft/block/BlockFenceGate
      // 6d: ifeq 7a
      // 70: goto 74
      // 73: athrow
      // 74: bipush 1
      // 75: goto 79
      // 78: athrow
      // 79: ireturn
      // 7a: aload 0
      // 7b: iload 1
      // 7c: ifne 8d
      // 7f: instanceof net/minecraft/block/BlockDoor
      // 82: ifne 8c
      // 85: goto 89
      // 88: athrow
      // 89: bipush 0
      // 8a: ireturn
      // 8b: athrow
      // 8c: aload 0
      // 8d: getstatic net/minecraft/init/Blocks.iron_door Lnet/minecraft/block/Block;
      // 90: if_acmpeq 98
      // 93: bipush 1
      // 94: goto 99
      // 97: athrow
      // 98: bipush 0
      // 99: ireturn
   }
}

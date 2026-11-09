package x;

import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;

public class oc7ab2161b9f implements ocda171fe5d8 {
   public static String Ҧ = "";
   private static final Random ʧ = new Random();
   private static final ThreadLocal<Integer> Ȥ = ThreadLocal.withInitial(() -> 0);
   public static HashSet<String> О = new HashSet<>();
   public static HashSet<String> õ = new HashSet<>();
   public static final Logger ô = LogManager.getLogger();
   public static int ʙ;

   public static String р(int param0, int param1, double param2, int param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 5
      // 05: dload 2
      // 06: ldc2_w 5.0
      // 09: dcmpl
      // 0a: iload 5
      // 0c: ifne 18
      // 0f: ifgt 29
      // 12: goto 16
      // 15: athrow
      // 16: iload 4
      // 18: iload 5
      // 1a: ifne 32
      // 1d: ldc -665063782
      // 1f: ldc -665063792
      // 21: ixor
      // 22: if_icmple 2d
      // 25: goto 29
      // 28: athrow
      // 29: ldc "§4High"
      // 2b: areturn
      // 2c: athrow
      // 2d: dload 2
      // 2e: ldc2_w 2.0
      // 31: dcmpl
      // 32: iload 5
      // 34: ifne 40
      // 37: ifgt 48
      // 3a: goto 3e
      // 3d: athrow
      // 3e: iload 4
      // 40: ldc -665063787
      // 42: ldc -665063792
      // 44: ixor
      // 45: if_icmple 4c
      // 48: ldc "§cMedium"
      // 4a: areturn
      // 4b: athrow
      // 4c: ldc "§aLow"
      // 4e: areturn
   }

   public static boolean ԓ(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 1
      // 04: getstatic x/oc2cf3d80e17.Ȭ Lx/occ9ed06a81d;
      // 07: iload 1
      // 08: ifne 15
      // 0b: ifnull 1a
      // 0e: goto 12
      // 11: athrow
      // 12: getstatic x/oc2cf3d80e17.Ȭ Lx/occ9ed06a81d;
      // 15: aload 0
      // 16: invokevirtual x/occ9ed06a81d.ą (Ljava/lang/String;)Z
      // 19: ireturn
      // 1a: getstatic x/oc7ab2161b9f.õ Ljava/util/HashSet;
      // 1d: aload 0
      // 1e: invokevirtual java/lang/String.toLowerCase ()Ljava/lang/String;
      // 21: invokevirtual java/util/HashSet.add (Ljava/lang/Object;)Z
      // 24: iload 1
      // 25: ifne 3f
      // 28: ifeq 3e
      // 2b: goto 2f
      // 2e: athrow
      // 2f: aload 0
      // 30: ldc "&7Added enemy&7: &b"
      // 32: swap
      // 33: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 38: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 3b: bipush 1
      // 3c: ireturn
      // 3d: athrow
      // 3e: bipush 0
      // 3f: ireturn
   }

   public static boolean ϓ(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 1
      // 04: getstatic x/oc2cf3d80e17.Ȭ Lx/occ9ed06a81d;
      // 07: iload 1
      // 08: ifne 15
      // 0b: ifnull 1a
      // 0e: goto 12
      // 11: athrow
      // 12: getstatic x/oc2cf3d80e17.Ȭ Lx/occ9ed06a81d;
      // 15: aload 0
      // 16: invokevirtual x/occ9ed06a81d.ӫ (Ljava/lang/String;)Z
      // 19: ireturn
      // 1a: getstatic x/oc7ab2161b9f.õ Ljava/util/HashSet;
      // 1d: aload 0
      // 1e: invokevirtual java/lang/String.toLowerCase ()Ljava/lang/String;
      // 21: invokevirtual java/util/HashSet.remove (Ljava/lang/Object;)Z
      // 24: iload 1
      // 25: ifne 3f
      // 28: ifeq 3e
      // 2b: goto 2f
      // 2e: athrow
      // 2f: aload 0
      // 30: ldc "&7Removed enemy&7: &b"
      // 32: swap
      // 33: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 38: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 3b: bipush 1
      // 3c: ireturn
      // 3d: athrow
      // 3e: bipush 0
      // 3f: ireturn
   }

   public static float ǻ() {
      return (float)Math.toDegrees(Math.atan2(ActiveRenderInfo.getRotationZ(), ActiveRenderInfo.getRotationX()));
   }

   public static float ԛ() {
      return (float)Math.toDegrees(Math.acos(ActiveRenderInfo.getRotationXZ()));
   }

   public static Vec3 ֆ(double var0) {
      int var2 = oc75d51ec7eb.ϩ;
      if (ocda171fe5d8.ǔ.gameSettings.thirdPersonView == 0) {
         return new Vec3(ocda171fe5d8.ǔ.thePlayer.posX, ocda171fe5d8.ǔ.thePlayer.posY + ocda171fe5d8.ǔ.thePlayer.getEyeHeight(), ocda171fe5d8.ǔ.thePlayer.posZ);
      } else {
         float var3 = 4.0F;
         Entity var4 = ocda171fe5d8.ǔ.getRenderViewEntity();
         float var5 = var4.getEyeHeight();
         double var6 = var4.prevPosX + (var4.posX - var4.prevPosX) * var0;
         double var8 = var4.prevPosY + (var4.posY - var4.prevPosY) * var0 + var5;
         double var10 = var4.prevPosZ + (var4.posZ - var4.prevPosZ) * var0;
         double var12 = var3;
         float var14 = ǻ();
         float var15 = ԛ();
         double var16 = -MathHelper.sin(var14 / 180.0F * (float) Math.PI) * MathHelper.cos(var15 / 180.0F * (float) Math.PI) * var12;
         double var18 = MathHelper.cos(var14 / 180.0F * (float) Math.PI) * MathHelper.cos(var15 / 180.0F * (float) Math.PI) * var12;
         double var20 = -MathHelper.sin(var15 / 180.0F * (float) Math.PI) * var12;
         int var22 = 0;

         while (var22 < (-509528951 ^ -509528959)) {
            float var23 = ((var22 & 1) * (-509528957 ^ -509528959) - 1) * 0.1F;
            int var10000 = var2;
            float var24 = ((var22 >> 1 & 1) * (-509528957 ^ -509528959) - 1) * 0.1F;
            float var25 = ((var22 >> (-509528957 ^ -509528959) & 1) * (-509528957 ^ -509528959) - 1) * 0.1F;
            MovingObjectPosition var26 = ocda171fe5d8.ǔ
               .theWorld
               .rayTraceBlocks(
                  new Vec3(var6 + var23, var8 + var24, var10 + var25), new Vec3(var6 - var16 + var23 + var25, var8 - var20 + var24, var10 - var18 + var25)
               );

            label45: {
               label53: {
                  try {
                     if (var10000 != 0) {
                        break label45;
                     }

                     if (var26 == null) {
                        break label53;
                     }
                  } catch (ocbde1165e4e var30) {
                     throw var30;
                  }

                  double var27 = var26.hitVec.distanceTo(new Vec3(var6, var8, var10));

                  try {
                     if (var2 != 0) {
                        break label45;
                     }

                     if (!(var27 < var12)) {
                        break label53;
                     }
                  } catch (ocbde1165e4e var29) {
                     throw var29;
                  }

                  var12 = var27;
               }

               var22++;
            }

            if (var2 != 0) {
               break;
            }
         }

         double var31 = var6 - var16 * (var12 / var3);
         double var32 = var8 - var20 * (var12 / var3);
         double var33 = var10 - var18 * (var12 / var3);
         return new Vec3(var31, var32, var33);
      }
   }

   public static void Ś(EntityLivingBase param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 1
      // 004: aload 0
      // 005: iload 1
      // 006: ifne 02e
      // 009: ifnonnull 011
      // 00c: goto 010
      // 00f: athrow
      // 010: return
      // 011: ldc "&7&m-------------------------"
      // 013: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 016: aload 0
      // 017: iload 1
      // 018: ifne 04e
      // 01b: invokevirtual net/minecraft/entity/EntityLivingBase.getName ()Ljava/lang/String;
      // 01e: ldc "&eattacking: &r"
      // 020: swap
      // 021: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 026: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 029: aload 0
      // 02a: goto 02e
      // 02d: athrow
      // 02e: invokevirtual java/lang/Object.getClass ()Ljava/lang/Class;
      // 031: invokevirtual java/lang/Class.getSimpleName ()Ljava/lang/String;
      // 034: ldc_w "&7type: &b"
      // 037: swap
      // 038: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 03d: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 040: getstatic x/oc9755810e45.Ǵ Lx/oca4f99d2d44;
      // 043: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 046: ifeq 057
      // 049: aload 0
      // 04a: goto 04e
      // 04d: athrow
      // 04e: invokestatic x/oca4f99d2d44.Λ (Lnet/minecraft/entity/Entity;)Z
      // 051: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
      // 054: goto 05a
      // 057: ldc_w "&cantibot disabled"
      // 05a: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 05d: ldc_w "&7bot: &r"
      // 060: swap
      // 061: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 066: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 069: aload 0
      // 06a: instanceof net/minecraft/entity/player/EntityPlayer
      // 06d: istore 2
      // 06e: iload 2
      // 06f: ldc_w "&7player: &r"
      // 072: swap
      // 073: invokedynamic makeConcatWithConstants (Ljava/lang/String;Z)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 078: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 07b: aload 0
      // 07c: invokestatic x/oc7ab2161b9f.ΐ (Lnet/minecraft/entity/Entity;)D
      // 07f: ldc_w -2093411080
      // 082: ldc_w -2093411078
      // 085: ixor
      // 086: invokestatic x/oc7ab2161b9f.ɜ (DI)D
      // 089: ldc_w "&7dist eye: &d"
      // 08c: dup_x2
      // 08d: pop
      // 08e: invokedynamic makeConcatWithConstants (Ljava/lang/String;D)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 093: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 096: aload 0
      // 097: ldc2_w 12.0
      // 09a: bipush 0
      // 09b: invokestatic x/oc7ab2161b9f.Ƶ (Lnet/minecraft/entity/Entity;DZ)D
      // 09e: invokestatic java/lang/Math.sqrt (D)D
      // 0a1: ldc_w -2093411080
      // 0a4: ldc_w -2093411078
      // 0a7: ixor
      // 0a8: invokestatic x/oc7ab2161b9f.ɜ (DI)D
      // 0ab: ldc_w "&7min dist: &d"
      // 0ae: dup_x2
      // 0af: pop
      // 0b0: invokedynamic makeConcatWithConstants (Ljava/lang/String;D)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 0b5: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 0b8: aload 0
      // 0b9: invokevirtual net/minecraft/entity/EntityLivingBase.getDisplayName ()Lnet/minecraft/util/IChatComponent;
      // 0bc: astore 3
      // 0bd: aload 3
      // 0be: ifnull 0c6
      // 0c1: bipush 1
      // 0c2: goto 0c7
      // 0c5: athrow
      // 0c6: bipush 0
      // 0c7: istore 4
      // 0c9: iload 2
      // 0ca: iload 1
      // 0cb: ifne 1ba
      // 0ce: ifeq 1b8
      // 0d1: goto 0d5
      // 0d4: athrow
      // 0d5: aload 0
      // 0d6: checkcast net/minecraft/entity/player/EntityPlayer
      // 0d9: astore 5
      // 0db: aload 5
      // 0dd: invokevirtual net/minecraft/entity/player/EntityPlayer.getUniqueID ()Ljava/util/UUID;
      // 0e0: astore 6
      // 0e2: aload 6
      // 0e4: invokevirtual java/util/UUID.toString ()Ljava/lang/String;
      // 0e7: aload 6
      // 0e9: invokevirtual java/util/UUID.variant ()I
      // 0ec: aload 6
      // 0ee: invokevirtual java/util/UUID.version ()I
      // 0f1: istore 9
      // 0f3: istore 10
      // 0f5: astore 11
      // 0f7: ldc_w "&7uuid: &d"
      // 0fa: aload 11
      // 0fc: ldc_w " &b"
      // 0ff: iload 10
      // 101: ldc_w " "
      // 104: iload 9
      // 106: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;I)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001\u0001\u0001\u0001" ]
      // 10b: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 10e: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 111: invokevirtual net/minecraft/client/Minecraft.getNetHandler ()Lnet/minecraft/client/network/NetHandlerPlayClient;
      // 114: aload 5
      // 116: invokevirtual net/minecraft/entity/player/EntityPlayer.getUniqueID ()Ljava/util/UUID;
      // 119: invokevirtual net/minecraft/client/network/NetHandlerPlayClient.getPlayerInfo (Ljava/util/UUID;)Lnet/minecraft/client/network/NetworkPlayerInfo;
      // 11c: astore 7
      // 11e: aload 7
      // 120: iload 1
      // 121: ifne 134
      // 124: ifnonnull 132
      // 127: goto 12b
      // 12a: athrow
      // 12b: ldc_w "&cnot found"
      // 12e: goto 13a
      // 131: athrow
      // 132: aload 7
      // 134: invokevirtual net/minecraft/client/network/NetworkPlayerInfo.getResponseTime ()I
      // 137: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 13a: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 13d: ldc_w "&7ping: &d"
      // 140: swap
      // 141: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 146: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 149: aload 5
      // 14b: invokestatic x/oc7ab2161b9f.ӥ (Lnet/minecraft/entity/Entity;)Z
      // 14e: iload 1
      // 14f: ifne 1ba
      // 152: ldc_w "&7teammate: &r"
      // 155: swap
      // 156: invokedynamic makeConcatWithConstants (Ljava/lang/String;Z)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 15b: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 15e: aload 5
      // 160: invokestatic x/oc7ab2161b9f.Ͳ (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // 163: ldc_w "&7tablist: &r"
      // 166: swap
      // 167: invokedynamic makeConcatWithConstants (Ljava/lang/String;Z)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 16c: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 16f: aload 5
      // 171: invokevirtual net/minecraft/entity/player/EntityPlayer.getTeam ()Lnet/minecraft/scoreboard/Team;
      // 174: ifnull 1b8
      // 177: goto 17b
      // 17a: athrow
      // 17b: aload 5
      // 17d: invokevirtual net/minecraft/entity/player/EntityPlayer.getTeam ()Lnet/minecraft/scoreboard/Team;
      // 180: checkcast net/minecraft/scoreboard/ScorePlayerTeam
      // 183: astore 8
      // 185: aload 8
      // 187: invokevirtual net/minecraft/scoreboard/ScorePlayerTeam.getTeamName ()Ljava/lang/String;
      // 18a: ldc_w "&7team name: &r"
      // 18d: swap
      // 18e: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 193: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 196: aload 8
      // 198: invokevirtual net/minecraft/scoreboard/ScorePlayerTeam.getColorPrefix ()Ljava/lang/String;
      // 19b: ldc_w "&7team prefix: &r"
      // 19e: swap
      // 19f: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 1a4: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 1a7: aload 8
      // 1a9: invokevirtual net/minecraft/scoreboard/ScorePlayerTeam.getColorSuffix ()Ljava/lang/String;
      // 1ac: ldc_w "&7team suffix: &r"
      // 1af: swap
      // 1b0: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 1b5: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 1b8: iload 4
      // 1ba: ifeq 1c7
      // 1bd: aload 3
      // 1be: invokeinterface net/minecraft/util/IChatComponent.getUnformattedText ()Ljava/lang/String; 1
      // 1c3: goto 1ca
      // 1c6: athrow
      // 1c7: ldc_w "&cnull"
      // 1ca: ldc_w "&7display unformatted: &r"
      // 1cd: swap
      // 1ce: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 1d3: iload 1
      // 1d4: ifne 1f0
      // 1d7: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 1da: iload 4
      // 1dc: ifeq 1f3
      // 1df: goto 1e3
      // 1e2: athrow
      // 1e3: aload 3
      // 1e4: invokeinterface net/minecraft/util/IChatComponent.getChatStyle ()Lnet/minecraft/util/ChatStyle; 1
      // 1e9: invokevirtual net/minecraft/util/ChatStyle.getInsertion ()Ljava/lang/String;
      // 1ec: goto 1f0
      // 1ef: athrow
      // 1f0: goto 1f6
      // 1f3: ldc_w "&cnull"
      // 1f6: ldc_w "&7insertion: &r"
      // 1f9: swap
      // 1fa: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 1ff: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 202: aload 0
      // 203: invokevirtual net/minecraft/entity/EntityLivingBase.getHealth ()F
      // 206: ldc_w "&7health: &r"
      // 209: swap
      // 20a: invokedynamic makeConcatWithConstants (Ljava/lang/String;F)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 20f: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 212: aload 0
      // 213: getfield net/minecraft/entity/EntityLivingBase.hurtTime I
      // 216: aload 0
      // 217: getfield net/minecraft/entity/EntityLivingBase.maxHurtTime I
      // 21a: ldc_w "&7ht: &d"
      // 21d: dup_x2
      // 21e: pop
      // 21f: ldc_w " &7mht: &d"
      // 222: swap
      // 223: invokedynamic makeConcatWithConstants (Ljava/lang/String;ILjava/lang/String;I)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001\u0001" ]
      // 228: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 22b: aload 0
      // 22c: getfield net/minecraft/entity/EntityLivingBase.ticksExisted I
      // 22f: ldc_w "&7ticks existed: &r"
      // 232: swap
      // 233: invokedynamic makeConcatWithConstants (Ljava/lang/String;I)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 238: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 23b: aload 0
      // 23c: invokevirtual net/minecraft/entity/EntityLivingBase.isInvisible ()Z
      // 23f: ldc_w "&7invisible: &r"
      // 242: swap
      // 243: invokedynamic makeConcatWithConstants (Ljava/lang/String;Z)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 248: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 24b: aload 0
      // 24c: getfield net/minecraft/entity/EntityLivingBase.isDead Z
      // 24f: ldc_w "&7dead: &r"
      // 252: swap
      // 253: invokedynamic makeConcatWithConstants (Ljava/lang/String;Z)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 258: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 25b: return
   }

   public static double Ƶ(Entity param0, double param1, boolean param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 006: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 009: fconst_1
      // 00a: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 00d: astore 5
      // 00f: istore 4
      // 011: iload 3
      // 012: ifeq 02c
      // 015: aload 0
      // 016: invokestatic x/oc75d51ec7eb.ɭ (Lnet/minecraft/entity/Entity;)[F
      // 019: astore 8
      // 01b: iload 4
      // 01d: aload 8
      // 01f: bipush 0
      // 020: faload
      // 021: fstore 6
      // 023: aload 8
      // 025: bipush 1
      // 026: faload
      // 027: fstore 7
      // 029: ifeq 042
      // 02c: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 02f: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 032: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 035: fstore 6
      // 037: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 03a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 03d: getfield net/minecraft/client/entity/EntityPlayerSP.rotationPitch F
      // 040: fstore 7
      // 042: fload 6
      // 044: fneg
      // 045: ldc_w 0.017453292
      // 048: fmul
      // 049: ldc 3.1415927
      // 04b: fsub
      // 04c: invokestatic net/minecraft/util/MathHelper.cos (F)F
      // 04f: fstore 8
      // 051: fload 6
      // 053: fneg
      // 054: ldc_w 0.017453292
      // 057: fmul
      // 058: ldc 3.1415927
      // 05a: fsub
      // 05b: invokestatic net/minecraft/util/MathHelper.sin (F)F
      // 05e: fstore 9
      // 060: fload 7
      // 062: fneg
      // 063: ldc_w 0.017453292
      // 066: fmul
      // 067: invokestatic net/minecraft/util/MathHelper.cos (F)F
      // 06a: fneg
      // 06b: fstore 10
      // 06d: fload 7
      // 06f: fneg
      // 070: ldc_w 0.017453292
      // 073: fmul
      // 074: invokestatic net/minecraft/util/MathHelper.sin (F)F
      // 077: fstore 11
      // 079: new net/minecraft/util/Vec3
      // 07c: dup
      // 07d: fload 9
      // 07f: fload 10
      // 081: fmul
      // 082: f2d
      // 083: fload 11
      // 085: f2d
      // 086: fload 8
      // 088: fload 10
      // 08a: fmul
      // 08b: f2d
      // 08c: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 08f: astore 12
      // 091: aload 12
      // 093: getfield net/minecraft/util/Vec3.xCoord D
      // 096: dload 1
      // 097: dmul
      // 098: dstore 13
      // 09a: aload 12
      // 09c: getfield net/minecraft/util/Vec3.yCoord D
      // 09f: dload 1
      // 0a0: dmul
      // 0a1: dstore 15
      // 0a3: aload 12
      // 0a5: getfield net/minecraft/util/Vec3.zCoord D
      // 0a8: dload 1
      // 0a9: dmul
      // 0aa: dstore 17
      // 0ac: aload 5
      // 0ae: dload 13
      // 0b0: dload 15
      // 0b2: dload 17
      // 0b4: invokevirtual net/minecraft/util/Vec3.addVector (DDD)Lnet/minecraft/util/Vec3;
      // 0b7: astore 19
      // 0b9: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 0bc: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 0bf: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 0c2: invokevirtual net/minecraft/client/Minecraft.getRenderViewEntity ()Lnet/minecraft/entity/Entity;
      // 0c5: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 0c8: invokevirtual net/minecraft/client/Minecraft.getRenderViewEntity ()Lnet/minecraft/entity/Entity;
      // 0cb: invokevirtual net/minecraft/entity/Entity.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 0ce: dload 13
      // 0d0: dload 15
      // 0d2: dload 17
      // 0d4: invokevirtual net/minecraft/util/AxisAlignedBB.addCoord (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 0d7: dconst_1
      // 0d8: dconst_1
      // 0d9: dconst_1
      // 0da: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 0dd: invokevirtual net/minecraft/client/multiplayer/WorldClient.getEntitiesWithinAABBExcludingEntity (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/AxisAlignedBB;)Ljava/util/List;
      // 0e0: astore 20
      // 0e2: bipush 0
      // 0e3: istore 21
      // 0e5: iload 21
      // 0e7: aload 20
      // 0e9: invokeinterface java/util/List.size ()I 1
      // 0ee: if_icmpge 16a
      // 0f1: aload 20
      // 0f3: iload 21
      // 0f5: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 0fa: checkcast net/minecraft/entity/Entity
      // 0fd: astore 22
      // 0ff: iload 4
      // 101: ifne 165
      // 104: aload 22
      // 106: aload 0
      // 107: if_acmpne 162
      // 10a: goto 10e
      // 10d: athrow
      // 10e: aload 22
      // 110: iload 4
      // 112: ifne 129
      // 115: goto 119
      // 118: athrow
      // 119: invokevirtual net/minecraft/entity/Entity.canBeCollidedWith ()Z
      // 11c: ifeq 162
      // 11f: goto 123
      // 122: athrow
      // 123: aload 22
      // 125: goto 129
      // 128: athrow
      // 129: invokevirtual net/minecraft/entity/Entity.getCollisionBorderSize ()F
      // 12c: fstore 23
      // 12e: iload 4
      // 130: aload 22
      // 132: invokevirtual net/minecraft/entity/Entity.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 135: fload 23
      // 137: f2d
      // 138: fload 23
      // 13a: f2d
      // 13b: fload 23
      // 13d: f2d
      // 13e: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 141: astore 24
      // 143: ifne 165
      // 146: aload 24
      // 148: aload 5
      // 14a: aload 19
      // 14c: invokevirtual net/minecraft/util/AxisAlignedBB.calculateIntercept (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/MovingObjectPosition;
      // 14f: astore 25
      // 151: aload 25
      // 153: ifnull 162
      // 156: aload 5
      // 158: aload 25
      // 15a: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 15d: invokevirtual net/minecraft/util/Vec3.squareDistanceTo (Lnet/minecraft/util/Vec3;)D
      // 160: dreturn
      // 161: athrow
      // 162: iinc 21 1
      // 165: iload 4
      // 167: ifeq 0e5
      // 16a: ldc2_w -1.0
      // 16d: dreturn
   }

   public static double ΐ(Entity var0) {
      return ocda171fe5d8.ǔ.thePlayer.getPositionEyes(1.0F).distanceTo(var0.getPositionEyes(1.0F));
   }

   public static boolean Ͳ(EntityPlayer param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 06: invokevirtual net/minecraft/client/Minecraft.getNetHandler ()Lnet/minecraft/client/network/NetHandlerPlayClient;
      // 09: invokevirtual net/minecraft/client/network/NetHandlerPlayClient.getPlayerInfoMap ()Ljava/util/Collection;
      // 0c: invokeinterface java/util/Collection.iterator ()Ljava/util/Iterator; 1
      // 11: astore 2
      // 12: istore 1
      // 13: aload 2
      // 14: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 19: ifeq 4a
      // 1c: aload 2
      // 1d: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 22: checkcast net/minecraft/client/network/NetworkPlayerInfo
      // 25: astore 3
      // 26: aload 3
      // 27: invokevirtual net/minecraft/client/network/NetworkPlayerInfo.getGameProfile ()Lcom/mojang/authlib/GameProfile;
      // 2a: aload 0
      // 2b: invokevirtual net/minecraft/entity/player/EntityPlayer.getGameProfile ()Lcom/mojang/authlib/GameProfile;
      // 2e: invokevirtual com/mojang/authlib/GameProfile.equals (Ljava/lang/Object;)Z
      // 31: iload 1
      // 32: ifne 4b
      // 35: iload 1
      // 36: ifne 45
      // 39: goto 3d
      // 3c: athrow
      // 3d: ifeq 46
      // 40: goto 44
      // 43: athrow
      // 44: bipush 1
      // 45: ireturn
      // 46: iload 1
      // 47: ifeq 13
      // 4a: bipush 0
      // 4b: ireturn
   }

   public static String ӄ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 0
      // 04: getstatic x/oc7ab2161b9f.Ҧ Ljava/lang/String;
      // 07: iload 0
      // 08: ifne 22
      // 0b: invokevirtual java/lang/String.isEmpty ()Z
      // 0e: ifeq 25
      // 11: goto 15
      // 14: athrow
      // 15: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 18: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1b: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getName ()Ljava/lang/String;
      // 1e: goto 22
      // 21: athrow
      // 22: goto 28
      // 25: getstatic x/oc7ab2161b9f.Ҧ Ljava/lang/String;
      // 28: areturn
   }

   public static boolean ʀ() {
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
      // 0b: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 0e: ifnonnull 2e
      // 11: goto 15
      // 14: athrow
      // 15: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 18: goto 1c
      // 1b: athrow
      // 1c: getfield net/minecraft/client/Minecraft.inGameHasFocus Z
      // 1f: iload 0
      // 20: ifne 2b
      // 23: ifeq 2e
      // 26: goto 2a
      // 29: athrow
      // 2a: bipush 1
      // 2b: goto 2f
      // 2e: bipush 0
      // 2f: ireturn
   }

   public static boolean ƀ(Entity param0) {
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
      // 06: ifne 17
      // 09: instanceof net/minecraft/entity/player/EntityPlayer
      // 0c: ifne 16
      // 0f: goto 13
      // 12: athrow
      // 13: bipush 0
      // 14: ireturn
      // 15: athrow
      // 16: aload 0
      // 17: checkcast net/minecraft/entity/player/EntityPlayer
      // 1a: iload 1
      // 1b: ifne 30
      // 1e: invokevirtual net/minecraft/entity/player/EntityPlayer.isUsingItem ()Z
      // 21: ifeq 42
      // 24: goto 28
      // 27: athrow
      // 28: aload 0
      // 29: checkcast net/minecraft/entity/player/EntityPlayer
      // 2c: goto 30
      // 2f: athrow
      // 30: invokestatic x/oc7ab2161b9f.ͼ (Lnet/minecraft/entity/EntityLivingBase;)Z
      // 33: iload 1
      // 34: ifne 3f
      // 37: ifeq 42
      // 3a: goto 3e
      // 3d: athrow
      // 3e: bipush 1
      // 3f: goto 43
      // 42: bipush 0
      // 43: ireturn
   }

   public static boolean ͼ(EntityLivingBase param0) {
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
      // 06: ifne 18
      // 09: invokevirtual net/minecraft/entity/EntityLivingBase.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 0c: ifnull 30
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: invokevirtual net/minecraft/entity/EntityLivingBase.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 1b: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 1e: instanceof net/minecraft/item/ItemFood
      // 21: iload 1
      // 22: ifne 2d
      // 25: ifeq 30
      // 28: goto 2c
      // 2b: athrow
      // 2c: bipush 1
      // 2d: goto 31
      // 30: bipush 0
      // 31: ireturn
   }

   public static int ǳ(Entity param0) {
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
      // 06: ifne 14
      // 09: ifnonnull 13
      // 0c: goto 10
      // 0f: athrow
      // 10: bipush -1
      // 11: ireturn
      // 12: athrow
      // 13: aload 0
      // 14: iload 1
      // 15: ifne 7b
      // 18: instanceof net/minecraft/entity/player/EntityPlayer
      // 1b: ifeq 7a
      // 1e: goto 22
      // 21: athrow
      // 22: aload 0
      // 23: iload 1
      // 24: ifne 7b
      // 27: goto 2b
      // 2a: athrow
      // 2b: checkcast net/minecraft/entity/EntityLivingBase
      // 2e: invokevirtual net/minecraft/entity/EntityLivingBase.getTeam ()Lnet/minecraft/scoreboard/Team;
      // 31: checkcast net/minecraft/scoreboard/ScorePlayerTeam
      // 34: astore 2
      // 35: aload 2
      // 36: ifnull 7a
      // 39: aload 2
      // 3a: invokevirtual net/minecraft/scoreboard/ScorePlayerTeam.getColorPrefix ()Ljava/lang/String;
      // 3d: invokestatic net/minecraft/client/gui/FontRenderer.getFormatFromString (Ljava/lang/String;)Ljava/lang/String;
      // 40: astore 3
      // 41: aload 3
      // 42: iload 1
      // 43: ifne 5c
      // 46: invokevirtual java/lang/String.length ()I
      // 49: ldc_w 2075041087
      // 4c: ldc_w 2075041085
      // 4f: ixor
      // 50: if_icmplt 7a
      // 53: goto 57
      // 56: athrow
      // 57: aload 3
      // 58: goto 5c
      // 5b: athrow
      // 5c: bipush 1
      // 5d: invokevirtual java/lang/String.charAt (I)C
      // 60: invokestatic x/oc7ab2161b9f.ˁ (C)I
      // 63: istore 4
      // 65: iload 4
      // 67: iload 1
      // 68: ifne 79
      // 6b: bipush -1
      // 6c: if_icmpeq 7a
      // 6f: goto 73
      // 72: athrow
      // 73: iload 4
      // 75: goto 79
      // 78: athrow
      // 79: ireturn
      // 7a: aload 0
      // 7b: invokevirtual net/minecraft/entity/Entity.getDisplayName ()Lnet/minecraft/util/IChatComponent;
      // 7e: astore 2
      // 7f: aload 2
      // 80: iload 1
      // 81: ifne 8f
      // 84: ifnonnull 8e
      // 87: goto 8b
      // 8a: athrow
      // 8b: bipush -1
      // 8c: ireturn
      // 8d: athrow
      // 8e: aload 2
      // 8f: invokeinterface net/minecraft/util/IChatComponent.getFormattedText ()Ljava/lang/String; 1
      // 94: invokestatic x/oc7ab2161b9f.ǩ (Ljava/lang/String;)Ljava/lang/String;
      // 97: astore 3
      // 98: aload 3
      // 99: invokevirtual java/lang/String.length ()I
      // 9c: iload 1
      // 9d: ifne e7
      // a0: ldc_w 2075041087
      // a3: ldc_w 2075041085
      // a6: ixor
      // a7: if_icmplt e2
      // aa: goto ae
      // ad: athrow
      // ae: aload 3
      // af: ldc_w "§"
      // b2: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // b5: iload 1
      // b6: ifne e7
      // b9: goto bd
      // bc: athrow
      // bd: ifeq e2
      // c0: goto c4
      // c3: athrow
      // c4: aload 3
      // c5: bipush 1
      // c6: invokevirtual java/lang/String.charAt (I)C
      // c9: iload 1
      // ca: ifne f0
      // cd: goto d1
      // d0: athrow
      // d1: invokestatic java/lang/Character.toLowerCase (C)C
      // d4: ldc_w 2075041115
      // d7: ldc_w 2075041085
      // da: ixor
      // db: if_icmpne e8
      // de: goto e2
      // e1: athrow
      // e2: bipush -1
      // e3: goto e7
      // e6: athrow
      // e7: ireturn
      // e8: aload 3
      // e9: bipush 1
      // ea: invokevirtual java/lang/String.charAt (I)C
      // ed: invokestatic x/oc7ab2161b9f.ˁ (C)I
      // f0: ireturn
   }

   private static int ˁ(char param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 1
      // 004: iload 0
      // 005: iload 1
      // 006: ifne 139
      // 009: invokestatic java/lang/Character.toLowerCase (C)C
      // 00c: tableswitch 300 48 102 237 242 246 250 254 258 262 266 270 274 300 300 300 300 300 300 300 300 300 300 300 300 300 300 300 300 300 300 300 300 300 300 300 300 300 300 300 300 300 300 300 300 300 300 300 300 300 300 300 278 282 286 290 294 298
      // 0f8: athrow
      // 0f9: getstatic x/ocbb09c57120.ӗ I
      // 0fc: ireturn
      // 0fd: athrow
      // 0fe: getstatic x/ocbb09c57120.ҽ I
      // 101: ireturn
      // 102: getstatic x/ocbb09c57120.ū I
      // 105: ireturn
      // 106: getstatic x/ocbb09c57120.ͳ I
      // 109: ireturn
      // 10a: getstatic x/ocbb09c57120.ȣ I
      // 10d: ireturn
      // 10e: getstatic x/ocbb09c57120.ǡ I
      // 111: ireturn
      // 112: getstatic x/ocbb09c57120.ȯ I
      // 115: ireturn
      // 116: getstatic x/ocbb09c57120.Ɉ I
      // 119: ireturn
      // 11a: getstatic x/ocbb09c57120.ƴ I
      // 11d: ireturn
      // 11e: getstatic x/ocbb09c57120.ȋ I
      // 121: ireturn
      // 122: getstatic x/ocbb09c57120.Η I
      // 125: ireturn
      // 126: getstatic x/ocbb09c57120.Ȳ I
      // 129: ireturn
      // 12a: getstatic x/ocbb09c57120.ң I
      // 12d: ireturn
      // 12e: getstatic x/ocbb09c57120.ȗ I
      // 131: ireturn
      // 132: getstatic x/ocbb09c57120.ԉ I
      // 135: ireturn
      // 136: bipush -1
      // 137: ireturn
      // 138: bipush -1
      // 139: ireturn
   }

   public static boolean ԝ(double param0, double param2, double param4) {
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
      // 0c: if_icmple 4c
      // 0f: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 12: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 15: new net/minecraft/util/BlockPos
      // 18: dup
      // 19: dload 0
      // 1a: iload 7
      // 1c: i2d
      // 1d: dload 4
      // 1f: invokespecial net/minecraft/util/BlockPos.<init> (DDD)V
      // 22: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 25: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 2a: instanceof net/minecraft/block/BlockAir
      // 2d: iload 6
      // 2f: ifne 4d
      // 32: iload 6
      // 34: ifne 43
      // 37: goto 3b
      // 3a: athrow
      // 3b: ifne 44
      // 3e: goto 42
      // 41: athrow
      // 42: bipush 0
      // 43: ireturn
      // 44: iinc 7 -1
      // 47: iload 6
      // 49: ifeq 09
      // 4c: bipush 1
      // 4d: ireturn
   }

   public static Block Ŝ(String var0) {
      return (Block)Block.blockRegistry.getObject(new ResourceLocation("minecraft:" + var0));
   }

   public static boolean ȣ(EntityLivingBase param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: aload 0
      // 001: getfield net/minecraft/entity/EntityLivingBase.posX D
      // 004: dstore 2
      // 005: aload 0
      // 006: getfield net/minecraft/entity/EntityLivingBase.posY D
      // 009: dstore 4
      // 00b: getstatic x/oc75d51ec7eb.ϩ I
      // 00e: aload 0
      // 00f: getfield net/minecraft/entity/EntityLivingBase.posZ D
      // 012: dstore 6
      // 014: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 017: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 01a: fconst_1
      // 01b: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 01e: astore 8
      // 020: aload 0
      // 021: invokevirtual net/minecraft/entity/EntityLivingBase.getEyeHeight ()F
      // 024: f2d
      // 025: ldc2_w 0.2
      // 028: dsub
      // 029: dstore 9
      // 02b: istore 1
      // 02c: aload 8
      // 02e: iload 1
      // 02f: ifne 050
      // 032: new net/minecraft/util/Vec3
      // 035: dup
      // 036: dload 2
      // 037: ldc2_w 0.3
      // 03a: dadd
      // 03b: dload 9
      // 03d: dload 6
      // 03f: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 042: invokestatic x/oc7ab2161b9f.и (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Z
      // 045: ifeq 04e
      // 048: goto 04c
      // 04b: athrow
      // 04c: bipush 1
      // 04d: ireturn
      // 04e: aload 8
      // 050: iload 1
      // 051: ifne 072
      // 054: new net/minecraft/util/Vec3
      // 057: dup
      // 058: dload 2
      // 059: ldc2_w 0.3
      // 05c: dsub
      // 05d: dload 9
      // 05f: dload 6
      // 061: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 064: invokestatic x/oc7ab2161b9f.и (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Z
      // 067: ifeq 070
      // 06a: goto 06e
      // 06d: athrow
      // 06e: bipush 1
      // 06f: ireturn
      // 070: aload 8
      // 072: new net/minecraft/util/Vec3
      // 075: dup
      // 076: dload 2
      // 077: dload 9
      // 079: dload 6
      // 07b: ldc2_w 0.3
      // 07e: dadd
      // 07f: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 082: iload 1
      // 083: ifne 0a5
      // 086: invokestatic x/oc7ab2161b9f.и (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Z
      // 089: ifeq 093
      // 08c: goto 090
      // 08f: athrow
      // 090: bipush 1
      // 091: ireturn
      // 092: athrow
      // 093: aload 8
      // 095: new net/minecraft/util/Vec3
      // 098: dup
      // 099: dload 2
      // 09a: dload 9
      // 09c: dload 6
      // 09e: ldc2_w 0.3
      // 0a1: dsub
      // 0a2: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 0a5: invokestatic x/oc7ab2161b9f.и (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Z
      // 0a8: iload 1
      // 0a9: ifne 0b4
      // 0ac: ifeq 0b5
      // 0af: goto 0b3
      // 0b2: athrow
      // 0b3: bipush 1
      // 0b4: ireturn
      // 0b5: aload 0
      // 0b6: invokevirtual net/minecraft/entity/EntityLivingBase.getEyeHeight ()F
      // 0b9: f2d
      // 0ba: ldc2_w 0.2
      // 0bd: dadd
      // 0be: dstore 11
      // 0c0: dload 11
      // 0c2: dconst_0
      // 0c3: dcmpl
      // 0c4: ifle 101
      // 0c7: new net/minecraft/util/Vec3
      // 0ca: dup
      // 0cb: dload 2
      // 0cc: dload 4
      // 0ce: dload 11
      // 0d0: dadd
      // 0d1: dload 6
      // 0d3: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 0d6: astore 13
      // 0d8: iload 1
      // 0d9: ifne 0fd
      // 0dc: aload 8
      // 0de: aload 13
      // 0e0: invokestatic x/oc7ab2161b9f.и (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Z
      // 0e3: iload 1
      // 0e4: ifne 102
      // 0e7: goto 0eb
      // 0ea: athrow
      // 0eb: ifeq 0f5
      // 0ee: goto 0f2
      // 0f1: athrow
      // 0f2: bipush 1
      // 0f3: ireturn
      // 0f4: athrow
      // 0f5: dload 11
      // 0f7: ldc2_w 0.2
      // 0fa: dsub
      // 0fb: dstore 11
      // 0fd: iload 1
      // 0fe: ifeq 0c0
      // 101: bipush 0
      // 102: ireturn
   }

   public static boolean Ξ() {
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
      // 07: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0a: iload 0
      // 0b: ifne 21
      // 0e: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 11: ifnonnull 1b
      // 14: goto 18
      // 17: athrow
      // 18: bipush 0
      // 19: ireturn
      // 1a: athrow
      // 1b: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 1e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 21: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 24: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 27: instanceof net/minecraft/item/ItemFireball
      // 2a: ireturn
   }

   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static boolean и(Vec3 var0, Vec3 var1) {
      int var10000 = oc75d51ec7eb.ϩ;
      MovingObjectPosition var3 = ocda171fe5d8.ǔ.theWorld.rayTraceBlocks(var0, var1, false, false, false);
      int var2 = var10000;

      label31: {
         label30: {
            try {
               var7 = var3;
               if (var2 != 0) {
                  break label30;
               }

               if (var3 == null) {
                  break label31;
               }
            } catch (ocbde1165e4e var6) {
               throw var6;
            }

            var7 = var3;
         }

         try {
            if (var7.typeOfHit == MovingObjectType.BLOCK) {
               return false;
            }
         } catch (ocbde1165e4e var5) {
            throw var5;
         }
      }

      try {
         return true;
      } catch (ocbde1165e4e var4) {
         throw var4;
      }
   }

   public static List<NetworkPlayerInfo> ˠ(boolean var0) {
      ArrayList var1 = new ArrayList(ocda171fe5d8.ǔ.getNetHandler().getPlayerInfoMap());

      try {
         Ӯ(var1);
         if (var0) {
            var1.remove(ocda171fe5d8.ǔ.getNetHandler().getPlayerInfo(ocda171fe5d8.ǔ.thePlayer.getUniqueID()));
         }

         return var1;
      } catch (ocbde1165e4e var2) {
         throw var2;
      }
   }

   public static void Ӯ(ArrayList var0) {
      HashSet var1 = new HashSet(var0);
      var0.clear();
      var0.addAll(var1);
   }

   public static boolean С(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 1
      // 04: getstatic x/oc2cf3d80e17.Ȭ Lx/occ9ed06a81d;
      // 07: iload 1
      // 08: ifne 15
      // 0b: ifnull 1a
      // 0e: goto 12
      // 11: athrow
      // 12: getstatic x/oc2cf3d80e17.Ȭ Lx/occ9ed06a81d;
      // 15: aload 0
      // 16: invokevirtual x/occ9ed06a81d.Ͳ (Ljava/lang/String;)Z
      // 19: ireturn
      // 1a: getstatic x/oc7ab2161b9f.О Ljava/util/HashSet;
      // 1d: aload 0
      // 1e: invokevirtual java/lang/String.toLowerCase ()Ljava/lang/String;
      // 21: invokevirtual java/util/HashSet.remove (Ljava/lang/Object;)Z
      // 24: iload 1
      // 25: ifne 40
      // 28: ifeq 3f
      // 2b: goto 2f
      // 2e: athrow
      // 2f: aload 0
      // 30: ldc_w "&7Removed &afriend&7: &b"
      // 33: swap
      // 34: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 39: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 3c: bipush 1
      // 3d: ireturn
      // 3e: athrow
      // 3f: bipush 0
      // 40: ireturn
   }

   public static String պ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: new java/io/File
      // 06: dup
      // 07: ldc_w "java.io.tmpdir"
      // 0a: invokestatic java/lang/System.getProperty (Ljava/lang/String;)Ljava/lang/String;
      // 0d: ldc_w "cmF2ZW5fc2NyaXB0cw"
      // 10: invokespecial java/io/File.<init> (Ljava/lang/String;Ljava/lang/String;)V
      // 13: invokevirtual java/io/File.getAbsolutePath ()Ljava/lang/String;
      // 16: astore 1
      // 17: istore 0
      // 18: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 1b: iload 0
      // 1c: ifne 29
      // 1f: ifnull 44
      // 22: goto 26
      // 25: athrow
      // 26: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 29: iload 0
      // 2a: ifne 3e
      // 2d: getfield net/minecraft/client/Minecraft.mcDataDir Ljava/io/File;
      // 30: ifnull 44
      // 33: goto 37
      // 36: athrow
      // 37: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 3a: goto 3e
      // 3d: athrow
      // 3e: getfield net/minecraft/client/Minecraft.mcDataDir Ljava/io/File;
      // 41: goto 45
      // 44: aconst_null
      // 45: astore 2
      // 46: aload 2
      // 47: ifnull ad
      // 4a: ldc_w "os.name"
      // 4d: iload 0
      // 4e: ifne ae
      // 51: goto 55
      // 54: athrow
      // 55: invokestatic java/lang/System.getProperty (Ljava/lang/String;)Ljava/lang/String;
      // 58: invokevirtual java/lang/String.toLowerCase ()Ljava/lang/String;
      // 5b: ldc_w "linux"
      // 5e: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 61: ifeq ad
      // 64: goto 68
      // 67: athrow
      // 68: new java/io/File
      // 6b: dup
      // 6c: aload 2
      // 6d: invokestatic x/oc8ccd9c3f55.պ (Ljava/io/File;)Ljava/io/File;
      // 70: getstatic java/io/File.separator Ljava/lang/String;
      // 73: ldc_w "scripts"
      // 76: swap
      // 77: ldc_w "compiler_temp"
      // 7a: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001" ]
      // 7f: invokespecial java/io/File.<init> (Ljava/io/File;Ljava/lang/String;)V
      // 82: astore 3
      // 83: aload 3
      // 84: iload 0
      // 85: ifne a9
      // 88: invokevirtual java/io/File.exists ()Z
      // 8b: ifne a8
      // 8e: goto 92
      // 91: athrow
      // 92: aload 3
      // 93: iload 0
      // 94: ifne a9
      // 97: goto 9b
      // 9a: athrow
      // 9b: invokevirtual java/io/File.mkdirs ()Z
      // 9e: ifne a8
      // a1: goto a5
      // a4: athrow
      // a5: aload 1
      // a6: areturn
      // a7: athrow
      // a8: aload 3
      // a9: invokevirtual java/io/File.getAbsolutePath ()Ljava/lang/String;
      // ac: areturn
      // ad: aload 1
      // ae: areturn
   }

   public static boolean ſ(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 1
      // 04: getstatic x/oc2cf3d80e17.Ȭ Lx/occ9ed06a81d;
      // 07: iload 1
      // 08: ifne 15
      // 0b: ifnull 1a
      // 0e: goto 12
      // 11: athrow
      // 12: getstatic x/oc2cf3d80e17.Ȭ Lx/occ9ed06a81d;
      // 15: aload 0
      // 16: invokevirtual x/occ9ed06a81d.ʴ (Ljava/lang/String;)Z
      // 19: ireturn
      // 1a: getstatic x/oc7ab2161b9f.О Ljava/util/HashSet;
      // 1d: aload 0
      // 1e: invokevirtual java/lang/String.toLowerCase ()Ljava/lang/String;
      // 21: invokevirtual java/util/HashSet.add (Ljava/lang/Object;)Z
      // 24: iload 1
      // 25: ifne 67
      // 28: ifeq 66
      // 2b: goto 2f
      // 2e: athrow
      // 2f: aload 0
      // 30: ldc_w "&7Added &afriend&7: &b"
      // 33: swap
      // 34: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 39: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 3c: getstatic x/oc7ab2161b9f.õ Ljava/util/HashSet;
      // 3f: aload 0
      // 40: invokevirtual java/lang/String.toLowerCase ()Ljava/lang/String;
      // 43: invokevirtual java/util/HashSet.contains (Ljava/lang/Object;)Z
      // 46: iload 1
      // 47: ifne 65
      // 4a: goto 4e
      // 4d: athrow
      // 4e: ifeq 64
      // 51: goto 55
      // 54: athrow
      // 55: getstatic x/oc7ab2161b9f.õ Ljava/util/HashSet;
      // 58: aload 0
      // 59: invokevirtual java/lang/String.toLowerCase ()Ljava/lang/String;
      // 5c: invokevirtual java/util/HashSet.remove (Ljava/lang/Object;)Z
      // 5f: pop
      // 60: goto 64
      // 63: athrow
      // 64: bipush 1
      // 65: ireturn
      // 66: bipush 0
      // 67: ireturn
   }

   public static boolean Է(double var0) {
      int var2 = oc75d51ec7eb.ϩ;

      try {
         double var4;
         int var10000 = (var4 = var0 - Math.floor(var0)) == 0.0 ? 0 : (var4 < 0.0 ? -1 : 1);
         if (var2 != 0) {
            return (boolean)var10000;
         }

         if (!var10000) {
            return (boolean)1;
         }
      } catch (ocbde1165e4e var3) {
         throw var3;
      }

      return (boolean)0;
   }

   public static String ɑ(double param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 2
      // 04: dload 0
      // 05: iload 2
      // 06: ifne 1f
      // 09: invokestatic x/oc7ab2161b9f.Է (D)Z
      // 0c: ifeq 1e
      // 0f: goto 13
      // 12: athrow
      // 13: dload 0
      // 14: d2i
      // 15: invokedynamic makeConcatWithConstants (I)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001" ]
      // 1a: goto 22
      // 1d: athrow
      // 1e: dload 0
      // 1f: invokestatic java/lang/String.valueOf (D)Ljava/lang/String;
      // 22: areturn
   }

   public static int ե(int var0, int var1) {
      return ʧ.nextInt(var1 - var0 + 1) + var0;
   }

   public static double t(double var0, double var2) {
      return var0 + (var2 - var0) * ʧ.nextDouble();
   }

   public static boolean Ҟ(float var0, BlockPos var1) {
      return З(var0, var1.getX(), var1.getZ());
   }

   public static boolean ˤ(float var0, Entity var1) {
      return Ŷ(var0, var1.posX, var1.posZ);
   }

   public static boolean Ŷ(float var0, double var1, double var3) {
      return А(ocda171fe5d8.ǔ.thePlayer, var0, var1, var3);
   }

   public static boolean А(Entity param0, float param1, double param2, double param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: fload 1
      // 04: f2d
      // 05: ldc2_w 0.5
      // 08: dmul
      // 09: d2f
      // 0a: fstore 1
      // 0b: istore 6
      // 0d: aload 0
      // 0e: getfield net/minecraft/entity/Entity.rotationYaw F
      // 11: dload 2
      // 12: dload 4
      // 14: invokestatic x/oc75d51ec7eb.z (DD)F
      // 17: fsub
      // 18: ldc_w 360.0
      // 1b: frem
      // 1c: f2d
      // 1d: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_double (D)D
      // 20: dstore 7
      // 22: dload 7
      // 24: iload 6
      // 26: ifne 4c
      // 29: dconst_0
      // 2a: dcmpl
      // 2b: ifle 4a
      // 2e: goto 32
      // 31: athrow
      // 32: dload 7
      // 34: fload 1
      // 35: f2d
      // 36: dcmpg
      // 37: iload 6
      // 39: ifne 60
      // 3c: goto 40
      // 3f: athrow
      // 40: ifge 5f
      // 43: goto 47
      // 46: athrow
      // 47: bipush 1
      // 48: ireturn
      // 49: athrow
      // 4a: dload 7
      // 4c: fload 1
      // 4d: fneg
      // 4e: f2d
      // 4f: dcmpl
      // 50: iload 6
      // 52: ifne 60
      // 55: ifle 5f
      // 58: goto 5c
      // 5b: athrow
      // 5c: bipush 1
      // 5d: ireturn
      // 5e: athrow
      // 5f: bipush 0
      // 60: ireturn
   }

   public static boolean З(float param0, float param1, float param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: fload 1
      // 01: ldc_w 0.5
      // 04: fmul
      // 05: fstore 1
      // 06: getstatic x/oc75d51ec7eb.ϩ I
      // 09: fload 0
      // 0a: fload 2
      // 0b: fsub
      // 0c: ldc_w 360.0
      // 0f: frem
      // 10: f2d
      // 11: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_double (D)D
      // 14: dstore 4
      // 16: istore 3
      // 17: dload 4
      // 19: dconst_0
      // 1a: iload 3
      // 1b: ifne 45
      // 1e: dcmpl
      // 1f: ifle 40
      // 22: goto 26
      // 25: athrow
      // 26: dload 4
      // 28: fload 1
      // 29: f2d
      // 2a: dcmpg
      // 2b: iload 3
      // 2c: ifne 3b
      // 2f: goto 33
      // 32: athrow
      // 33: ifge 3e
      // 36: goto 3a
      // 39: athrow
      // 3a: bipush 1
      // 3b: goto 3f
      // 3e: bipush 0
      // 3f: ireturn
      // 40: dload 4
      // 42: fload 1
      // 43: fneg
      // 44: f2d
      // 45: dcmpl
      // 46: iload 3
      // 47: ifne 52
      // 4a: ifle 55
      // 4d: goto 51
      // 50: athrow
      // 51: bipush 1
      // 52: goto 56
      // 55: bipush 0
      // 56: ireturn
   }

   public static Vec3 ҵ(float var0, float var1) {
      float var2 = MathHelper.cos(-var0 * (float) (Math.PI / 180.0) - (float) Math.PI);
      float var3 = MathHelper.sin(-var0 * (float) (Math.PI / 180.0) - (float) Math.PI);
      float var4 = -MathHelper.cos(-var1 * (float) (Math.PI / 180.0));
      float var5 = MathHelper.sin(-var1 * (float) (Math.PI / 180.0));
      return new Vec3(var3 * var4, var5, var2 * var4);
   }

   public static boolean ŕ() {
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
      // 07: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0a: iload 0
      // 0b: ifne 21
      // 0e: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 11: ifnonnull 1b
      // 14: goto 18
      // 17: athrow
      // 18: bipush 0
      // 19: ireturn
      // 1a: athrow
      // 1b: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 1e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 21: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 24: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 27: instanceof net/minecraft/item/ItemBow
      // 2a: ireturn
   }

   public static boolean k() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 0
      // 04: invokestatic x/oc7ab2161b9f.ŕ ()Z
      // 07: iload 0
      // 08: ifne 5c
      // 0b: ifeq 5b
      // 0e: goto 12
      // 11: athrow
      // 12: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 15: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 18: getfield net/minecraft/client/entity/EntityPlayerSP.moveStrafing F
      // 1b: fconst_0
      // 1c: fcmpl
      // 1d: iload 0
      // 1e: ifne 5c
      // 21: goto 25
      // 24: athrow
      // 25: ifne 5b
      // 28: goto 2c
      // 2b: athrow
      // 2c: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 2f: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 32: getfield net/minecraft/client/entity/EntityPlayerSP.moveForward F
      // 35: fconst_0
      // 36: fcmpg
      // 37: iload 0
      // 38: ifne 5c
      // 3b: goto 3f
      // 3e: athrow
      // 3f: ifgt 5b
      // 42: goto 46
      // 45: athrow
      // 46: invokestatic x/oc7ab2161b9f.ȣ ()Z
      // 49: iload 0
      // 4a: ifne 5c
      // 4d: goto 51
      // 50: athrow
      // 51: ifeq 5b
      // 54: goto 58
      // 57: athrow
      // 58: bipush 1
      // 59: ireturn
      // 5a: athrow
      // 5b: bipush 0
      // 5c: ireturn
   }

   public static boolean ΐ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 0
      // 04: getstatic x/oc9755810e45.ҩ Lx/oc4557683e94;
      // 07: getfield x/oc4557683e94.ȏ Z
      // 0a: iload 0
      // 0b: ifne 2b
      // 0e: ifeq 2a
      // 11: goto 15
      // 14: athrow
      // 15: invokestatic x/oc7ab2161b9f.k ()Z
      // 18: iload 0
      // 19: ifne 2b
      // 1c: goto 20
      // 1f: athrow
      // 20: ifeq 2a
      // 23: goto 27
      // 26: athrow
      // 27: bipush 1
      // 28: ireturn
      // 29: athrow
      // 2a: bipush 0
      // 2b: ireturn
   }

   public static void ý(String var0) {
      if (Ð()) {
         String var1 = Ĭ("&7[&cMiau&7]&r " + var0);
         ocda171fe5d8.ǔ.thePlayer.addChatMessage(new ChatComponentText(var1));
      }
   }

   public static void Ʒ(String var0) {
      if (Ð()) {
         String var1 = Ĭ("&7[&cMiau&7]&r " + var0);
         ocda171fe5d8.ǔ.thePlayer.addChatMessage(new ChatComponentText(var1));
      }
   }

   public static void ӽ(Object var0) {
      String var1 = String.valueOf(var0);
      ý(var1);
   }

   public static void պ(String var0) {
      try {
         if (Ð()) {
            ocda171fe5d8.ǔ.thePlayer.addChatMessage(new ChatComponentText("§7[§cMiau§7]§r " + var0));
         }
      } catch (ocbde1165e4e var1) {
         throw var1;
      }
   }

   public static void č(Entity param0, boolean param1, boolean param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 3
      // 04: iload 1
      // 05: iload 3
      // 06: ifne 26
      // 09: ifeq 21
      // 0c: goto 10
      // 0f: athrow
      // 10: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 13: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 16: invokevirtual net/minecraft/client/entity/EntityPlayerSP.swingItem ()V
      // 19: iload 3
      // 1a: ifeq 58
      // 1d: goto 21
      // 20: athrow
      // 21: iload 2
      // 22: goto 26
      // 25: athrow
      // 26: iload 3
      // 27: ifne 32
      // 2a: ifne 41
      // 2d: goto 31
      // 30: athrow
      // 31: iload 2
      // 32: iload 3
      // 33: ifne 3e
      // 36: ifne 58
      // 39: goto 3d
      // 3c: athrow
      // 3d: iload 1
      // 3e: ifne 58
      // 41: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 44: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 47: getfield net/minecraft/client/entity/EntityPlayerSP.sendQueue Lnet/minecraft/client/network/NetHandlerPlayClient;
      // 4a: new net/minecraft/network/play/client/C0APacketAnimation
      // 4d: dup
      // 4e: invokespecial net/minecraft/network/play/client/C0APacketAnimation.<init> ()V
      // 51: invokevirtual net/minecraft/client/network/NetHandlerPlayClient.addToSendQueue (Lnet/minecraft/network/Packet;)V
      // 54: goto 58
      // 57: athrow
      // 58: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 5b: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 5e: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 61: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 64: aload 0
      // 65: invokevirtual net/minecraft/client/multiplayer/PlayerControllerMP.attackEntity (Lnet/minecraft/entity/player/EntityPlayer;Lnet/minecraft/entity/Entity;)V
      // 68: return
   }

   public static void ȫ(String var0) {
      try {
         if (Ð()) {
            ocda171fe5d8.ǔ.thePlayer.addChatMessage(new ChatComponentText(Ĭ(var0)));
         }
      } catch (ocbde1165e4e var1) {
         throw var1;
      }
   }

   public static float ɭ(EntityLivingBase var0) {
      return var0.getHealth() + var0.getAbsorptionAmount();
   }

   public static String ǔ(EntityLivingBase param0, boolean param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: aload 0
      // 04: invokestatic x/oc7ab2161b9f.ɭ (Lnet/minecraft/entity/EntityLivingBase;)F
      // 07: fstore 3
      // 08: istore 2
      // 09: iload 1
      // 0a: iload 2
      // 0b: ifne 25
      // 0e: ifeq 2a
      // 11: goto 15
      // 14: athrow
      // 15: aload 0
      // 16: iload 2
      // 17: ifne 2b
      // 1a: goto 1e
      // 1d: athrow
      // 1e: getfield net/minecraft/entity/EntityLivingBase.isDead Z
      // 21: goto 25
      // 24: athrow
      // 25: ifeq 2a
      // 28: fconst_0
      // 29: fstore 3
      // 2a: aload 0
      // 2b: invokevirtual net/minecraft/entity/EntityLivingBase.getHealth ()F
      // 2e: aload 0
      // 2f: invokevirtual net/minecraft/entity/EntityLivingBase.getMaxHealth ()F
      // 32: fdiv
      // 33: f2d
      // 34: fload 3
      // 35: f2d
      // 36: invokestatic x/oc7ab2161b9f.ց (DD)Ljava/lang/String;
      // 39: areturn
   }

   public static boolean ն(KeyBinding param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: aload 0
      // 04: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // 07: istore 2
      // 08: istore 1
      // 09: iload 2
      // 0a: iload 1
      // 0b: ifne 27
      // 0e: ifge 23
      // 11: goto 15
      // 14: athrow
      // 15: iload 2
      // 16: ldc_w -570611299
      // 19: ldc_w -570611207
      // 1c: ixor
      // 1d: iadd
      // 1e: invokestatic org/lwjgl/input/Mouse.isButtonDown (I)Z
      // 21: ireturn
      // 22: athrow
      // 23: iload 2
      // 24: invokestatic org/lwjgl/input/Keyboard.isKeyDown (I)Z
      // 27: ireturn
   }

   public static int ɲ(Block var0) {
      double var2 = 1.0;
      int var1 = oc75d51ec7eb.ϩ;
      int var4 = -1;
      int var5 = 0;

      while (var5 < InventoryPlayer.getHotbarSize()) {
         ItemStack var6 = ocda171fe5d8.ǔ.thePlayer.inventory.getStackInSlot(var5);

         label41: {
            label49: {
               try {
                  if (var1 != 0) {
                     break label41;
                  }

                  if (var6 == null) {
                     break label49;
                  }
               } catch (ocbde1165e4e var10) {
                  throw var10;
               }

               double var7 = oc561cb941fa.ʃ(var6, var0);

               try {
                  if (var1 != 0) {
                     break label41;
                  }

                  if (!(var7 > var2)) {
                     break label49;
                  }
               } catch (ocbde1165e4e var9) {
                  throw var9;
               }

               var2 = var7;
               var4 = var5;
            }

            var5++;
         }

         if (var1 != 0) {
            break;
         }
      }

      return var4;
   }

   public static boolean Ң(Entity param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield net/minecraft/entity/Entity.posX D
      // 04: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 07: istore 2
      // 08: getstatic x/oc75d51ec7eb.ϩ I
      // 0b: aload 0
      // 0c: getfield net/minecraft/entity/Entity.posY D
      // 0f: ldc2_w 0.20000000298023224
      // 12: dsub
      // 13: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 16: istore 3
      // 17: istore 1
      // 18: aload 0
      // 19: getfield net/minecraft/entity/Entity.posZ D
      // 1c: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 1f: istore 4
      // 21: new net/minecraft/util/BlockPos
      // 24: dup
      // 25: iload 2
      // 26: iload 3
      // 27: iload 4
      // 29: invokespecial net/minecraft/util/BlockPos.<init> (III)V
      // 2c: astore 5
      // 2e: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 31: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 34: aload 5
      // 36: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 39: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 3e: astore 6
      // 40: aload 6
      // 42: instanceof net/minecraft/block/BlockLadder
      // 45: iload 1
      // 46: ifne 58
      // 49: ifeq 67
      // 4c: goto 50
      // 4f: athrow
      // 50: aload 0
      // 51: getfield net/minecraft/entity/Entity.onGround Z
      // 54: goto 58
      // 57: athrow
      // 58: iload 1
      // 59: ifne 64
      // 5c: ifne 67
      // 5f: goto 63
      // 62: athrow
      // 63: bipush 1
      // 64: goto 68
      // 67: bipush 0
      // 68: ireturn
   }

   public static float ʎ(ItemStack var0, Block var1) {
      int var10000 = oc75d51ec7eb.ϩ;
      float var3 = var0.getStrVsBlock(var1);
      int var2 = var10000;

      try {
         if (var2 != 0) {
            return var3;
         }

         if (!(var3 > 1.0F)) {
            return var3;
         }
      } catch (ocbde1165e4e var5) {
         throw var5;
      }

      int var4 = EnchantmentHelper.getEnchantmentLevel(Enchantment.efficiency.effectId, var0);
      if (var4 > 0) {
         var3 += var4 * var4 + 1;
      }

      return var3;
   }

   public static boolean Š(EntityPlayer var0) {
      int var1 = oc75d51ec7eb.ϩ;

      EntityPlayer var10000;
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
         boolean var4 = h(var10000.getName());
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

   public static boolean h(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 1
      // 04: getstatic x/oc2cf3d80e17.Ȭ Lx/occ9ed06a81d;
      // 07: iload 1
      // 08: ifne 15
      // 0b: ifnull 1a
      // 0e: goto 12
      // 11: athrow
      // 12: getstatic x/oc2cf3d80e17.Ȭ Lx/occ9ed06a81d;
      // 15: aload 0
      // 16: invokevirtual x/occ9ed06a81d.Ӽ (Ljava/lang/String;)Z
      // 19: ireturn
      // 1a: aload 0
      // 1b: ifnull 50
      // 1e: getstatic x/oc7ab2161b9f.õ Ljava/util/HashSet;
      // 21: iload 1
      // 22: ifne 3a
      // 25: goto 29
      // 28: athrow
      // 29: invokevirtual java/util/HashSet.isEmpty ()Z
      // 2c: ifne 50
      // 2f: goto 33
      // 32: athrow
      // 33: getstatic x/oc7ab2161b9f.õ Ljava/util/HashSet;
      // 36: goto 3a
      // 39: athrow
      // 3a: aload 0
      // 3b: invokevirtual java/lang/String.toLowerCase ()Ljava/lang/String;
      // 3e: invokevirtual java/util/HashSet.contains (Ljava/lang/Object;)Z
      // 41: iload 1
      // 42: ifne 4d
      // 45: ifeq 50
      // 48: goto 4c
      // 4b: athrow
      // 4c: bipush 1
      // 4d: goto 51
      // 50: bipush 0
      // 51: ireturn
   }

   public static String ց(double param0, double param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: dload 2
      // 04: bipush 1
      // 05: invokestatic x/oc7ab2161b9f.ɜ (DI)D
      // 08: dstore 5
      // 0a: istore 4
      // 0c: dload 0
      // 0d: ldc2_w 0.3
      // 10: iload 4
      // 12: ifne 28
      // 15: dcmpg
      // 16: ifge 24
      // 19: goto 1d
      // 1c: athrow
      // 1d: ldc_w "§c"
      // 20: goto 4e
      // 23: athrow
      // 24: dload 0
      // 25: ldc2_w 0.5
      // 28: iload 4
      // 2a: ifne 40
      // 2d: dcmpg
      // 2e: ifge 3c
      // 31: goto 35
      // 34: athrow
      // 35: ldc_w "§6"
      // 38: goto 4e
      // 3b: athrow
      // 3c: dload 0
      // 3d: ldc2_w 0.7
      // 40: dcmpg
      // 41: ifge 4b
      // 44: ldc_w "§e"
      // 47: goto 4e
      // 4a: athrow
      // 4b: ldc_w "§a"
      // 4e: dload 5
      // 50: invokestatic x/oc7ab2161b9f.ɑ (D)Ljava/lang/String;
      // 53: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 58: areturn
   }

   public static int Ā(double param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 2
      // 04: dload 0
      // 05: iload 2
      // 06: ifne 20
      // 09: ldc2_w 0.3
      // 0c: dcmpg
      // 0d: ifge 1f
      // 10: goto 14
      // 13: athrow
      // 14: ldc_w -2073831350
      // 17: ldc_w 2073857311
      // 1a: ixor
      // 1b: goto 5b
      // 1e: athrow
      // 1f: dload 0
      // 20: ldc2_w 0.5
      // 23: iload 2
      // 24: ifne 3e
      // 27: dcmpg
      // 28: ifge 3a
      // 2b: goto 2f
      // 2e: athrow
      // 2f: ldc_w -2073876705
      // 32: ldc_w 2073857311
      // 35: ixor
      // 36: goto 5b
      // 39: athrow
      // 3a: dload 0
      // 3b: ldc2_w 0.7
      // 3e: dcmpg
      // 3f: iload 2
      // 40: ifne 51
      // 43: ifge 54
      // 46: goto 4a
      // 49: athrow
      // 4a: ldc_w -2073857462
      // 4d: ldc_w 2073857311
      // 50: ixor
      // 51: goto 5b
      // 54: ldc_w -2067172790
      // 57: ldc_w 2073857311
      // 5a: ixor
      // 5b: ireturn
   }

   public static String Ĭ(String var0) {
      return var0.replaceAll("&", "§");
   }

   public static String ó(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 1
      // 004: aload 0
      // 005: iload 1
      // 006: ifne 031
      // 009: ifnull 02a
      // 00c: goto 010
      // 00f: athrow
      // 010: aload 0
      // 011: invokevirtual java/lang/String.length ()I
      // 014: iload 1
      // 015: ifne 033
      // 018: goto 01c
      // 01b: athrow
      // 01c: ldc_w 1404754583
      // 01f: ldc_w 1404754581
      // 022: ixor
      // 023: if_icmpge 032
      // 026: goto 02a
      // 029: athrow
      // 02a: ldc_w ""
      // 02d: goto 031
      // 030: athrow
      // 031: areturn
      // 032: bipush 0
      // 033: istore 2
      // 034: iload 2
      // 035: aload 0
      // 036: invokevirtual java/lang/String.length ()I
      // 039: bipush 1
      // 03a: isub
      // 03b: if_icmpge 101
      // 03e: aload 0
      // 03f: iload 1
      // 040: ifne 104
      // 043: iload 1
      // 044: ifne 062
      // 047: goto 04b
      // 04a: athrow
      // 04b: iload 2
      // 04c: invokevirtual java/lang/String.charAt (I)C
      // 04f: ldc_w 1404754482
      // 052: ldc_w 1404754581
      // 055: ixor
      // 056: if_icmpne 0fa
      // 059: goto 05d
      // 05c: athrow
      // 05d: aload 0
      // 05e: goto 062
      // 061: athrow
      // 062: iload 2
      // 063: bipush 1
      // 064: iadd
      // 065: invokevirtual java/lang/String.charAt (I)C
      // 068: istore 3
      // 069: iload 3
      // 06a: iload 1
      // 06b: ifne 098
      // 06e: ldc_w 1404754597
      // 071: ldc_w 1404754581
      // 074: ixor
      // 075: if_icmplt 093
      // 078: goto 07c
      // 07b: athrow
      // 07c: iload 3
      // 07d: iload 1
      // 07e: ifne 0f4
      // 081: goto 085
      // 084: athrow
      // 085: ldc_w 1404754604
      // 088: ldc_w 1404754581
      // 08b: ixor
      // 08c: if_icmple 0ef
      // 08f: goto 093
      // 092: athrow
      // 093: iload 3
      // 094: goto 098
      // 097: athrow
      // 098: iload 1
      // 099: ifne 0c6
      // 09c: ldc_w 1404754676
      // 09f: ldc_w 1404754581
      // 0a2: ixor
      // 0a3: if_icmplt 0c1
      // 0a6: goto 0aa
      // 0a9: athrow
      // 0aa: iload 3
      // 0ab: iload 1
      // 0ac: ifne 0f4
      // 0af: goto 0b3
      // 0b2: athrow
      // 0b3: ldc_w 1404754675
      // 0b6: ldc_w 1404754581
      // 0b9: ixor
      // 0ba: if_icmple 0ef
      // 0bd: goto 0c1
      // 0c0: athrow
      // 0c1: iload 3
      // 0c2: goto 0c6
      // 0c5: athrow
      // 0c6: iload 1
      // 0c7: ifne 0dd
      // 0ca: ldc_w 1404754644
      // 0cd: ldc_w 1404754581
      // 0d0: ixor
      // 0d1: if_icmplt 0fa
      // 0d4: goto 0d8
      // 0d7: athrow
      // 0d8: iload 3
      // 0d9: goto 0dd
      // 0dc: athrow
      // 0dd: iload 1
      // 0de: ifne 0f4
      // 0e1: ldc_w 1404754643
      // 0e4: ldc_w 1404754581
      // 0e7: ixor
      // 0e8: if_icmpgt 0fa
      // 0eb: goto 0ef
      // 0ee: athrow
      // 0ef: iload 3
      // 0f0: goto 0f4
      // 0f3: athrow
      // 0f4: invokedynamic makeConcatWithConstants (C)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "§\u0001" ]
      // 0f9: areturn
      // 0fa: iinc 2 1
      // 0fd: iload 1
      // 0fe: ifeq 034
      // 101: ldc_w ""
      // 104: areturn
   }

   public static int Ѫ(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 2
      // 02: bipush 0
      // 03: istore 3
      // 04: getstatic x/oc75d51ec7eb.ϩ I
      // 07: bipush 0
      // 08: istore 4
      // 0a: istore 1
      // 0b: iload 4
      // 0d: aload 0
      // 0e: invokevirtual java/lang/String.length ()I
      // 11: if_icmpge 90
      // 14: aload 0
      // 15: iload 4
      // 17: invokevirtual java/lang/String.charAt (I)C
      // 1a: iload 1
      // 1b: ifne 91
      // 1e: istore 5
      // 20: iload 5
      // 22: iload 1
      // 23: ifne 83
      // 26: ldc_w -1908908071
      // 29: ldc_w -1908908162
      // 2c: ixor
      // 2d: if_icmpne 7e
      // 30: goto 34
      // 33: athrow
      // 34: iload 4
      // 36: iload 1
      // 37: ifne 83
      // 3a: goto 3e
      // 3d: athrow
      // 3e: bipush 1
      // 3f: iadd
      // 40: aload 0
      // 41: invokevirtual java/lang/String.length ()I
      // 44: if_icmpge 7e
      // 47: goto 4b
      // 4a: athrow
      // 4b: ldc_w "0123456789abcdefklmnor"
      // 4e: aload 0
      // 4f: getstatic java/util/Locale.ENGLISH Ljava/util/Locale;
      // 52: invokevirtual java/lang/String.toLowerCase (Ljava/util/Locale;)Ljava/lang/String;
      // 55: iload 4
      // 57: bipush 1
      // 58: iadd
      // 59: invokevirtual java/lang/String.charAt (I)C
      // 5c: invokevirtual java/lang/String.indexOf (I)I
      // 5f: istore 6
      // 61: iload 1
      // 62: ifne 7a
      // 65: iload 6
      // 67: ldc_w -1908908177
      // 6a: ldc_w -1908908162
      // 6d: ixor
      // 6e: if_icmpne 77
      // 71: goto 75
      // 74: athrow
      // 75: bipush 1
      // 76: istore 2
      // 77: iinc 4 1
      // 7a: iload 1
      // 7b: ifeq 89
      // 7e: iload 2
      // 7f: goto 83
      // 82: athrow
      // 83: ifeq 89
      // 86: iinc 3 1
      // 89: iinc 4 1
      // 8c: iload 1
      // 8d: ifeq 0b
      // 90: iload 3
      // 91: ireturn
   }

   public static void Ұ(oca9cc61aada param0, oca9cc61aada param1) {
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
      // 06: ifne 1d
      // 09: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0c: aload 1
      // 0d: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 10: dcmpl
      // 11: ifle 2e
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
      // 26: invokevirtual x/oca9cc61aada.ʫ (D)V
      // 29: aload 1
      // 2a: dload 3
      // 2b: invokevirtual x/oca9cc61aada.ʫ (D)V
      // 2e: return
   }

   public static String Ҥ(int var0) {
      char[] var1 = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
      StringBuilder var2 = new StringBuilder();
      IntStream.range(0, var0).forEach(var2x -> var2.append(var1[ʧ.nextInt(var1.length)]));
      return var2.toString();
   }

   public static boolean Ӭ(EntityPlayer param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 0
      // 01: ifnull 17
      // 04: aload 0
      // 05: invokevirtual net/minecraft/entity/player/EntityPlayer.getName ()Ljava/lang/String;
      // 08: invokestatic x/oc7ab2161b9f.Ř (Ljava/lang/String;)Z
      // 0b: ifeq 17
      // 0e: goto 12
      // 11: athrow
      // 12: bipush 1
      // 13: goto 18
      // 16: athrow
      // 17: bipush 0
      // 18: ireturn
   }

   public static boolean Ř(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc2cf3d80e17.Ȭ Lx/occ9ed06a81d;
      // 03: ifnull 0f
      // 06: getstatic x/oc2cf3d80e17.Ȭ Lx/occ9ed06a81d;
      // 09: aload 0
      // 0a: invokevirtual x/occ9ed06a81d.Ϧ (Ljava/lang/String;)Z
      // 0d: ireturn
      // 0e: athrow
      // 0f: aload 0
      // 10: ifnull 36
      // 13: getstatic x/oc7ab2161b9f.О Ljava/util/HashSet;
      // 16: invokevirtual java/util/HashSet.isEmpty ()Z
      // 19: ifne 36
      // 1c: goto 20
      // 1f: athrow
      // 20: getstatic x/oc7ab2161b9f.О Ljava/util/HashSet;
      // 23: aload 0
      // 24: invokevirtual java/lang/String.toLowerCase ()Ljava/lang/String;
      // 27: invokevirtual java/util/HashSet.contains (Ljava/lang/Object;)Z
      // 2a: ifeq 36
      // 2d: goto 31
      // 30: athrow
      // 31: bipush 1
      // 32: goto 37
      // 35: athrow
      // 36: bipush 0
      // 37: ireturn
   }

   public static double Μ(oca9cc61aada param0, oca9cc61aada param1, Random param2) {
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
      // 05: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 08: iload 3
      // 09: ifne 24
      // 0c: aload 1
      // 0d: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 10: dcmpl
      // 11: ifne 20
      // 14: goto 18
      // 17: athrow
      // 18: aload 0
      // 19: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 1c: goto 33
      // 1f: athrow
      // 20: aload 0
      // 21: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 24: aload 2
      // 25: invokevirtual java/util/Random.nextDouble ()D
      // 28: aload 1
      // 29: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 2c: aload 0
      // 2d: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 30: dsub
      // 31: dmul
      // 32: dadd
      // 33: dreturn
   }

   public static boolean Ð() {
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
      // 08: ifne 15
      // 0b: ifnull 35
      // 0e: goto 12
      // 11: athrow
      // 12: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 15: iload 0
      // 16: ifne 2a
      // 19: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1c: ifnull 35
      // 1f: goto 23
      // 22: athrow
      // 23: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 26: goto 2a
      // 29: athrow
      // 2a: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 2d: ifnull 35
      // 30: bipush 1
      // 31: goto 36
      // 34: athrow
      // 35: bipush 0
      // 36: ireturn
   }

   public static boolean Տ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 03: invokevirtual net/minecraft/client/Minecraft.isSingleplayer ()Z
      // 06: ifne 31
      // 09: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 0c: invokevirtual net/minecraft/client/Minecraft.getCurrentServerData ()Lnet/minecraft/client/multiplayer/ServerData;
      // 0f: ifnull 31
      // 12: goto 16
      // 15: athrow
      // 16: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 19: invokevirtual net/minecraft/client/Minecraft.getCurrentServerData ()Lnet/minecraft/client/multiplayer/ServerData;
      // 1c: getfield net/minecraft/client/multiplayer/ServerData.serverIP Ljava/lang/String;
      // 1f: ldc_w "hypixel.net"
      // 22: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 25: ifeq 31
      // 28: goto 2c
      // 2b: athrow
      // 2c: bipush 1
      // 2d: goto 32
      // 30: athrow
      // 31: bipush 0
      // 32: ireturn
   }

   public static String Ȫ(EntityPlayer param0, ItemStack param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: aload 0
      // 04: aload 1
      // 05: invokestatic x/oc7ab2161b9f.Ѹ (Lnet/minecraft/entity/player/EntityPlayer;Lnet/minecraft/item/ItemStack;)D
      // 08: invokestatic java/lang/Math.ceil (D)D
      // 0b: d2i
      // 0c: istore 3
      // 0d: istore 2
      // 0e: iload 3
      // 0f: iload 2
      // 10: ifne 23
      // 13: bipush 1
      // 14: if_icmpgt 22
      // 17: goto 1b
      // 1a: athrow
      // 1b: ldc_w "c"
      // 1e: goto 51
      // 21: athrow
      // 22: iload 3
      // 23: iload 2
      // 24: ifne 3d
      // 27: ldc_w -1629343171
      // 2a: ldc_w -1629343170
      // 2d: ixor
      // 2e: if_icmpgt 3c
      // 31: goto 35
      // 34: athrow
      // 35: ldc_w "6"
      // 38: goto 51
      // 3b: athrow
      // 3c: iload 3
      // 3d: ldc_w -1629343173
      // 40: ldc_w -1629343170
      // 43: ixor
      // 44: if_icmpgt 4e
      // 47: ldc_w "e"
      // 4a: goto 51
      // 4d: athrow
      // 4e: ldc_w "a"
      // 51: iload 3
      // 52: invokedynamic makeConcatWithConstants (Ljava/lang/String;I)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "§\u0001\u0001" ]
      // 57: areturn
   }

   public static double Ѹ(EntityPlayer param0, ItemStack param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: dconst_1
      // 004: dstore 3
      // 005: istore 2
      // 006: aload 1
      // 007: iload 2
      // 008: ifne 013
      // 00b: ifnull 039
      // 00e: goto 012
      // 011: athrow
      // 012: aload 1
      // 013: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 016: iload 2
      // 017: ifne 02c
      // 01a: instanceof net/minecraft/item/ItemSword
      // 01d: ifne 032
      // 020: goto 024
      // 023: athrow
      // 024: aload 1
      // 025: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 028: goto 02c
      // 02b: athrow
      // 02c: instanceof net/minecraft/item/ItemAxe
      // 02f: ifeq 039
      // 032: dload 3
      // 033: aload 1
      // 034: invokestatic x/oc7ab2161b9f.є (Lnet/minecraft/item/ItemStack;)D
      // 037: dadd
      // 038: dstore 3
      // 039: dconst_0
      // 03a: dstore 5
      // 03c: dconst_0
      // 03d: dstore 7
      // 03f: bipush 0
      // 040: istore 9
      // 042: iload 9
      // 044: ldc_w 1902257158
      // 047: ldc_w 1902257154
      // 04a: ixor
      // 04b: if_icmpge 0dd
      // 04e: aload 0
      // 04f: getfield net/minecraft/entity/player/EntityPlayer.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 052: iload 9
      // 054: invokevirtual net/minecraft/entity/player/InventoryPlayer.armorItemInSlot (I)Lnet/minecraft/item/ItemStack;
      // 057: astore 10
      // 059: iload 2
      // 05a: ifne 0f8
      // 05d: iload 2
      // 05e: ifne 0d9
      // 061: goto 065
      // 064: athrow
      // 065: aload 10
      // 067: ifnull 0d6
      // 06a: goto 06e
      // 06d: athrow
      // 06e: aload 10
      // 070: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 073: instanceof net/minecraft/item/ItemArmor
      // 076: iload 2
      // 077: ifne 0ad
      // 07a: goto 07e
      // 07d: athrow
      // 07e: ifeq 0d6
      // 081: goto 085
      // 084: athrow
      // 085: dload 5
      // 087: aload 10
      // 089: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 08c: checkcast net/minecraft/item/ItemArmor
      // 08f: getfield net/minecraft/item/ItemArmor.damageReduceAmount I
      // 092: i2d
      // 093: ldc2_w 0.04
      // 096: dmul
      // 097: dadd
      // 098: dstore 5
      // 09a: iload 2
      // 09b: ifne 0d9
      // 09e: getstatic net/minecraft/enchantment/Enchantment.protection Lnet/minecraft/enchantment/Enchantment;
      // 0a1: getfield net/minecraft/enchantment/Enchantment.effectId I
      // 0a4: aload 10
      // 0a6: invokestatic net/minecraft/enchantment/EnchantmentHelper.getEnchantmentLevel (ILnet/minecraft/item/ItemStack;)I
      // 0a9: goto 0ad
      // 0ac: athrow
      // 0ad: istore 11
      // 0af: iload 11
      // 0b1: ifeq 0d6
      // 0b4: ldc2_w 0.75
      // 0b7: ldc_w 1902257156
      // 0ba: ldc_w 1902257154
      // 0bd: ixor
      // 0be: iload 11
      // 0c0: iload 11
      // 0c2: imul
      // 0c3: iadd
      // 0c4: i2d
      // 0c5: dmul
      // 0c6: ldc2_w 3.0
      // 0c9: ddiv
      // 0ca: invokestatic java/lang/Math.floor (D)D
      // 0cd: dstore 12
      // 0cf: dload 7
      // 0d1: dload 12
      // 0d3: dadd
      // 0d4: dstore 7
      // 0d6: iinc 9 1
      // 0d9: iload 2
      // 0da: ifeq 042
      // 0dd: ldc2_w 0.04
      // 0e0: dload 7
      // 0e2: ldc2_w 25.0
      // 0e5: invokestatic java/lang/Math.min (DD)D
      // 0e8: ldc2_w 0.75
      // 0eb: dmul
      // 0ec: invokestatic java/lang/Math.ceil (D)D
      // 0ef: ldc2_w 20.0
      // 0f2: invokestatic java/lang/Math.min (DD)D
      // 0f5: dmul
      // 0f6: dstore 7
      // 0f8: dload 5
      // 0fa: dload 7
      // 0fc: dconst_1
      // 0fd: dload 5
      // 0ff: dsub
      // 100: dmul
      // 101: dadd
      // 102: dstore 9
      // 104: dload 3
      // 105: dconst_1
      // 106: dload 9
      // 108: dsub
      // 109: dmul
      // 10a: dstore 11
      // 10c: aload 0
      // 10d: invokestatic x/oc7ab2161b9f.ɭ (Lnet/minecraft/entity/EntityLivingBase;)F
      // 110: f2d
      // 111: dload 11
      // 113: ddiv
      // 114: dstore 13
      // 116: dload 13
      // 118: bipush 1
      // 119: invokestatic x/oc7ab2161b9f.ɜ (DI)D
      // 11c: dreturn
   }

   public static float É() {
      return q(ocda171fe5d8.ǔ.thePlayer.rotationYaw, ocda171fe5d8.ǔ.thePlayer.movementInput.moveForward, ocda171fe5d8.ǔ.thePlayer.movementInput.moveStrafe);
   }

   public static String Ä(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: aload 0
      // 04: ldc_w "_"
      // 07: invokevirtual java/lang/String.indexOf (Ljava/lang/String;)I
      // 0a: istore 2
      // 0b: aload 0
      // 0c: ldc_w "_"
      // 0f: invokevirtual java/lang/String.lastIndexOf (Ljava/lang/String;)I
      // 12: istore 3
      // 13: istore 1
      // 14: iload 2
      // 15: iload 1
      // 16: ifne 26
      // 19: bipush -1
      // 1a: if_icmpeq 45
      // 1d: goto 21
      // 20: athrow
      // 21: iload 3
      // 22: goto 26
      // 25: athrow
      // 26: iload 1
      // 27: ifne 37
      // 2a: bipush -1
      // 2b: if_icmpeq 45
      // 2e: goto 32
      // 31: athrow
      // 32: iload 3
      // 33: goto 37
      // 36: athrow
      // 37: iload 2
      // 38: if_icmple 45
      // 3b: aload 0
      // 3c: iload 2
      // 3d: bipush 1
      // 3e: iadd
      // 3f: iload 3
      // 40: invokevirtual java/lang/String.substring (II)Ljava/lang/String;
      // 43: areturn
      // 44: athrow
      // 45: aload 0
      // 46: areturn
   }

   public static int Ҭ(int var0, int var1) {
      return var0 & (-1324521821 ^ -1309501092) | var1 << (-1309501116 ^ -1309501092);
   }

   public static int Պ(int param0) {
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
      // 06: ifne 21
      // 09: ldc_w -288952368
      // 0c: ldc_w -288952529
      // 0f: ixor
      // 10: if_icmple 20
      // 13: goto 17
      // 16: athrow
      // 17: ldc_w -288952368
      // 1a: ldc_w -288952529
      // 1d: ixor
      // 1e: ireturn
      // 1f: athrow
      // 20: iload 0
      // 21: iload 1
      // 22: ifne 3d
      // 25: ldc_w -288952533
      // 28: ldc_w -288952529
      // 2b: ixor
      // 2c: if_icmpge 3c
      // 2f: goto 33
      // 32: athrow
      // 33: ldc_w -288952533
      // 36: ldc_w -288952529
      // 39: ixor
      // 3a: ireturn
      // 3b: athrow
      // 3c: iload 0
      // 3d: ireturn
   }

   public static boolean ũ(ItemStack param0) {
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
      // 0a: getfield net/minecraft/client/entity/EntityPlayerSP.capabilities Lnet/minecraft/entity/player/PlayerCapabilities;
      // 0d: getfield net/minecraft/entity/player/PlayerCapabilities.isCreativeMode Z
      // 10: iload 1
      // 11: ifne 39
      // 14: ifne 34
      // 17: goto 1b
      // 1a: athrow
      // 1b: getstatic net/minecraft/enchantment/Enchantment.infinity Lnet/minecraft/enchantment/Enchantment;
      // 1e: getfield net/minecraft/enchantment/Enchantment.effectId I
      // 21: iload 1
      // 22: ifne 39
      // 25: goto 29
      // 28: athrow
      // 29: aload 0
      // 2a: invokestatic net/minecraft/enchantment/EnchantmentHelper.getEnchantmentLevel (ILnet/minecraft/item/ItemStack;)I
      // 2d: ifle 3c
      // 30: goto 34
      // 33: athrow
      // 34: bipush 1
      // 35: goto 39
      // 38: athrow
      // 39: goto 3d
      // 3c: bipush 0
      // 3d: istore 2
      // 3e: iload 2
      // 3f: iload 1
      // 40: ifne 69
      // 43: ifne 68
      // 46: goto 4a
      // 49: athrow
      // 4a: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 4d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 50: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 53: getstatic net/minecraft/init/Items.arrow Lnet/minecraft/item/Item;
      // 56: invokevirtual net/minecraft/entity/player/InventoryPlayer.hasItem (Lnet/minecraft/item/Item;)Z
      // 59: iload 1
      // 5a: ifne 69
      // 5d: goto 61
      // 60: athrow
      // 61: ifeq 6c
      // 64: goto 68
      // 67: athrow
      // 68: bipush 1
      // 69: goto 6d
      // 6c: bipush 0
      // 6d: ireturn
   }

   public static int Ҭ(int var0, double var1) {
      int var3 = var0 >> (-1867708597 ^ -1867708589) & (-1867708500 ^ -1867708589);
      int var4 = var0 >> (-1867708605 ^ -1867708589) & (-1867708500 ^ -1867708589);
      int var5 = var0 >> (-1867708581 ^ -1867708589) & (-1867708500 ^ -1867708589);
      int var6 = var0 & (-1867708500 ^ -1867708589);
      var1 = (100.0 - var1) / 100.0;
      var4 = (int)(var4 * var1);
      var5 = (int)(var5 * var1);
      var6 = (int)(var6 * var1);
      var4 = Պ(var4);
      var5 = Պ(var5);
      var6 = Պ(var6);
      return var3 << (-1867708597 ^ -1867708589) | var4 << (-1867708605 ^ -1867708589) | var5 << (-1867708581 ^ -1867708589) | var6;
   }

   public static boolean ӥ(Entity param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 0
      // 01: astore 1
      // 02: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 05: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 08: aload 0
      // 09: checkcast net/minecraft/entity/EntityLivingBase
      // 0c: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isOnSameTeam (Lnet/minecraft/entity/EntityLivingBase;)Z
      // 0f: ifne 5f
      // 12: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 15: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 18: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getDisplayName ()Lnet/minecraft/util/IChatComponent;
      // 1b: invokeinterface net/minecraft/util/IChatComponent.getUnformattedText ()Ljava/lang/String; 1
      // 20: aload 1
      // 21: invokevirtual net/minecraft/entity/Entity.getDisplayName ()Lnet/minecraft/util/IChatComponent;
      // 24: invokeinterface net/minecraft/util/IChatComponent.getUnformattedText ()Ljava/lang/String; 1
      // 29: bipush 0
      // 2a: ldc_w 1652170083
      // 2d: ldc_w 1652170081
      // 30: ixor
      // 31: invokevirtual java/lang/String.substring (II)Ljava/lang/String;
      // 34: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 37: ifne 5f
      // 3a: goto 3e
      // 3d: athrow
      // 3e: invokestatic x/oc7ab2161b9f.Ǖ ()Ljava/lang/String;
      // 41: aload 1
      // 42: invokevirtual net/minecraft/entity/Entity.getDisplayName ()Lnet/minecraft/util/IChatComponent;
      // 45: invokeinterface net/minecraft/util/IChatComponent.getUnformattedText ()Ljava/lang/String; 1
      // 4a: bipush 0
      // 4b: ldc_w 1652170083
      // 4e: ldc_w 1652170081
      // 51: ixor
      // 52: invokevirtual java/lang/String.substring (II)Ljava/lang/String;
      // 55: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 58: ifeq 61
      // 5b: goto 5f
      // 5e: athrow
      // 5f: bipush 1
      // 60: ireturn
      // 61: goto 65
      // 64: astore 1
      // 65: bipush 0
      // 66: ireturn
   }

   public static String Ǖ() {
      try {
         NetworkPlayerInfo var0 = ocda171fe5d8.ǔ.getNetHandler().getPlayerInfo(ocda171fe5d8.ǔ.thePlayer.getUniqueID());
         return ScorePlayerTeam.formatPlayerName(var0.getPlayerTeam(), var0.getGameProfile().getName());
      } catch (Exception var1) {
         return "";
      }
   }

   public static void N(double var0) {
      try {
         if (var0 == 0.0) {
            ocda171fe5d8.ǔ.thePlayer.motionZ = 0.0;
            ocda171fe5d8.ǔ.thePlayer.motionX = 0.0;
            return;
         }
      } catch (ocbde1165e4e var3) {
         throw var3;
      }

      float var2 = É();
      ocda171fe5d8.ǔ.thePlayer.motionX = -Math.sin(var2) * var0;
      ocda171fe5d8.ǔ.thePlayer.motionZ = Math.cos(var2) * var0;
   }

   public static void ҁ() {
      ocda171fe5d8.ǔ.getTimer().timerSpeed = 1.0F;
   }

   public static void Ϲ() {
      Ȥ.set(Ȥ.get() + 1);
   }

   public static void º() {
      int var0 = Ȥ.get() - 1;
      Ȥ.set(Math.max(0, var0));
   }

   public static boolean ģ() {
      int var0 = oc75d51ec7eb.ϩ;

      try {
         int var10000 = Ȥ.get();
         if (var0 != 0) {
            return (boolean)var10000;
         }

         if (var10000 > 0) {
            return (boolean)1;
         }
      } catch (ocbde1165e4e var1) {
         throw var1;
      }

      return (boolean)0;
   }

   public static boolean Ձ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 0
      // 04: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 07: iload 0
      // 08: ifne 13
      // 0b: ifne 14
      // 0e: goto 12
      // 11: athrow
      // 12: bipush 0
      // 13: ireturn
      // 14: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 17: iload 0
      // 18: ifne 2c
      // 1b: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 1e: ifnull 74
      // 21: goto 25
      // 24: athrow
      // 25: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 28: goto 2c
      // 2b: athrow
      // 2c: iload 0
      // 2d: ifne 44
      // 30: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 33: getfield net/minecraft/client/entity/EntityPlayerSP.inventoryContainer Lnet/minecraft/inventory/Container;
      // 36: ifnull 74
      // 39: goto 3d
      // 3c: athrow
      // 3d: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 40: goto 44
      // 43: athrow
      // 44: iload 0
      // 45: ifne 5f
      // 48: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 4b: getfield net/minecraft/client/entity/EntityPlayerSP.inventoryContainer Lnet/minecraft/inventory/Container;
      // 4e: instanceof net/minecraft/inventory/ContainerPlayer
      // 51: ifeq 74
      // 54: goto 58
      // 57: athrow
      // 58: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 5b: goto 5f
      // 5e: athrow
      // 5f: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 62: instanceof net/minecraft/client/gui/inventory/GuiInventory
      // 65: iload 0
      // 66: ifne 71
      // 69: ifeq 74
      // 6c: goto 70
      // 6f: athrow
      // 70: bipush 1
      // 71: goto 75
      // 74: bipush 0
      // 75: ireturn
   }

   public static int Ь() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: invokestatic x/oc7ab2161b9f.հ ()Ljava/util/List;
      // 06: astore 1
      // 07: istore 0
      // 08: aload 1
      // 09: iload 0
      // 0a: ifne 23
      // 0d: invokeinterface java/util/List.isEmpty ()Z 1
      // 12: ifeq 1c
      // 15: goto 19
      // 18: athrow
      // 19: bipush -1
      // 1a: ireturn
      // 1b: athrow
      // 1c: aload 1
      // 1d: bipush 0
      // 1e: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 23: checkcast java/lang/String
      // 26: invokestatic x/oc7ab2161b9f.ћ (Ljava/lang/String;)Ljava/lang/String;
      // 29: ldc_w "SKYWARS"
      // 2c: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 2f: iload 0
      // 30: ifne b0
      // 33: ifeq af
      // 36: goto 3a
      // 39: athrow
      // 3a: aload 1
      // 3b: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 40: astore 2
      // 41: aload 2
      // 42: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 47: ifeq ad
      // 4a: aload 2
      // 4b: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 50: checkcast java/lang/String
      // 53: astore 3
      // 54: aload 3
      // 55: invokestatic x/oc7ab2161b9f.ћ (Ljava/lang/String;)Ljava/lang/String;
      // 58: astore 3
      // 59: aload 3
      // 5a: ldc_w "Waiting..."
      // 5d: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 60: iload 0
      // 61: ifne ae
      // 64: iload 0
      // 65: ifne 8e
      // 68: goto 6c
      // 6b: athrow
      // 6c: ifne 89
      // 6f: goto 73
      // 72: athrow
      // 73: aload 3
      // 74: ldc_w "Starting in "
      // 77: iload 0
      // 78: ifne 93
      // 7b: goto 7f
      // 7e: athrow
      // 7f: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 82: ifeq 8f
      // 85: goto 89
      // 88: athrow
      // 89: bipush 1
      // 8a: goto 8e
      // 8d: athrow
      // 8e: ireturn
      // 8f: aload 3
      // 90: ldc_w "Players left: "
      // 93: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 96: iload 0
      // 97: ifne a8
      // 9a: ifeq a9
      // 9d: goto a1
      // a0: athrow
      // a1: ldc_w 629931276
      // a4: ldc_w 629931278
      // a7: ixor
      // a8: ireturn
      // a9: iload 0
      // aa: ifeq 41
      // ad: bipush 0
      // ae: ireturn
      // af: bipush -1
      // b0: ireturn
   }

   public static String Ƽ(JsonObject var0, String var1) {
      try {
         return var0.get(var1).getAsString();
      } catch (Exception var3) {
         return "";
      }
   }

   public static int Ҝ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 0
      // 004: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 007: iload 0
      // 008: ifne 013
      // 00b: ifne 014
      // 00e: goto 012
      // 011: athrow
      // 012: bipush -1
      // 013: ireturn
      // 014: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 017: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 01a: invokevirtual net/minecraft/client/multiplayer/WorldClient.getScoreboard ()Lnet/minecraft/scoreboard/Scoreboard;
      // 01d: astore 1
      // 01e: aload 1
      // 01f: iload 0
      // 020: ifne 02e
      // 023: ifnonnull 02d
      // 026: goto 02a
      // 029: athrow
      // 02a: bipush -1
      // 02b: ireturn
      // 02c: athrow
      // 02d: aload 1
      // 02e: bipush 1
      // 02f: invokevirtual net/minecraft/scoreboard/Scoreboard.getObjectiveInDisplaySlot (I)Lnet/minecraft/scoreboard/ScoreObjective;
      // 032: astore 2
      // 033: aload 2
      // 034: iload 0
      // 035: ifne 040
      // 038: ifnull 057
      // 03b: goto 03f
      // 03e: athrow
      // 03f: aload 2
      // 040: invokevirtual net/minecraft/scoreboard/ScoreObjective.getDisplayName ()Ljava/lang/String;
      // 043: invokestatic x/oc7ab2161b9f.ȑ (Ljava/lang/String;)Ljava/lang/String;
      // 046: ldc_w "BED WARS"
      // 049: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 04c: iload 0
      // 04d: ifne 058
      // 050: ifne 059
      // 053: goto 057
      // 056: athrow
      // 057: bipush -1
      // 058: ireturn
      // 059: invokestatic x/oc7ab2161b9f.հ ()Ljava/util/List;
      // 05c: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 061: astore 3
      // 062: aload 3
      // 063: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 068: ifeq 11f
      // 06b: aload 3
      // 06c: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 071: checkcast java/lang/String
      // 074: astore 4
      // 076: aload 4
      // 078: invokestatic x/oc7ab2161b9f.ȑ (Ljava/lang/String;)Ljava/lang/String;
      // 07b: astore 4
      // 07d: aload 4
      // 07f: ldc_w "  "
      // 082: invokevirtual java/lang/String.split (Ljava/lang/String;)[Ljava/lang/String;
      // 085: astore 5
      // 087: aload 5
      // 089: arraylength
      // 08a: iload 0
      // 08b: ifne 120
      // 08e: iload 0
      // 08f: ifne 0c1
      // 092: goto 096
      // 095: athrow
      // 096: bipush 1
      // 097: if_icmple 0b9
      // 09a: goto 09e
      // 09d: athrow
      // 09e: aload 5
      // 0a0: bipush 1
      // 0a1: aaload
      // 0a2: ldc_w "L"
      // 0a5: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 0a8: iload 0
      // 0a9: ifne 0b8
      // 0ac: goto 0b0
      // 0af: athrow
      // 0b0: ifeq 11b
      // 0b3: goto 0b7
      // 0b6: athrow
      // 0b7: bipush 0
      // 0b8: ireturn
      // 0b9: aload 4
      // 0bb: ldc_w "Waiting..."
      // 0be: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0c1: iload 0
      // 0c2: ifne 0e8
      // 0c5: ifne 0e3
      // 0c8: goto 0cc
      // 0cb: athrow
      // 0cc: aload 4
      // 0ce: iload 0
      // 0cf: ifne 0eb
      // 0d2: goto 0d6
      // 0d5: athrow
      // 0d6: ldc_w "Starting in"
      // 0d9: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 0dc: ifeq 0e9
      // 0df: goto 0e3
      // 0e2: athrow
      // 0e3: bipush 1
      // 0e4: goto 0e8
      // 0e7: athrow
      // 0e8: ireturn
      // 0e9: aload 4
      // 0eb: ldc_w "R Red:"
      // 0ee: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 0f1: iload 0
      // 0f2: ifne 11a
      // 0f5: ifne 113
      // 0f8: goto 0fc
      // 0fb: athrow
      // 0fc: aload 4
      // 0fe: ldc_w "B Blue:"
      // 101: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 104: iload 0
      // 105: ifne 11a
      // 108: goto 10c
      // 10b: athrow
      // 10c: ifeq 11b
      // 10f: goto 113
      // 112: athrow
      // 113: ldc_w 115471640
      // 116: ldc_w 115471642
      // 119: ixor
      // 11a: ireturn
      // 11b: iload 0
      // 11c: ifeq 062
      // 11f: bipush -1
      // 120: ireturn
   }

   public static String ȑ(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokestatic net/minecraft/util/StringUtils.stripControlCodes (Ljava/lang/String;)Ljava/lang/String;
      // 04: invokevirtual java/lang/String.toCharArray ()[C
      // 07: astore 2
      // 08: new java/lang/StringBuilder
      // 0b: dup
      // 0c: invokespecial java/lang/StringBuilder.<init> ()V
      // 0f: astore 3
      // 10: getstatic x/oc75d51ec7eb.ϩ I
      // 13: aload 2
      // 14: astore 4
      // 16: aload 4
      // 18: arraylength
      // 19: istore 5
      // 1b: bipush 0
      // 1c: istore 6
      // 1e: istore 1
      // 1f: iload 6
      // 21: iload 5
      // 23: if_icmpge 63
      // 26: aload 4
      // 28: iload 6
      // 2a: caload
      // 2b: istore 7
      // 2d: iload 1
      // 2e: ifne 5f
      // 31: iload 7
      // 33: ldc_w 1801170638
      // 36: ldc_w 1801170609
      // 39: ixor
      // 3a: if_icmpge 5c
      // 3d: goto 41
      // 40: athrow
      // 41: iload 7
      // 43: ldc_w 1801170597
      // 46: ldc_w 1801170609
      // 49: ixor
      // 4a: if_icmple 5c
      // 4d: goto 51
      // 50: athrow
      // 51: aload 3
      // 52: iload 7
      // 54: invokevirtual java/lang/StringBuilder.append (C)Ljava/lang/StringBuilder;
      // 57: pop
      // 58: goto 5c
      // 5b: athrow
      // 5c: iinc 6 1
      // 5f: iload 1
      // 60: ifeq 1f
      // 63: aload 3
      // 64: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 67: areturn
   }

   public static List<String> հ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: new java/util/ArrayList
      // 003: dup
      // 004: invokespecial java/util/ArrayList.<init> ()V
      // 007: astore 0
      // 008: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 00b: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 00e: ifnonnull 014
      // 011: aload 0
      // 012: areturn
      // 013: athrow
      // 014: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 017: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 01a: invokevirtual net/minecraft/client/multiplayer/WorldClient.getScoreboard ()Lnet/minecraft/scoreboard/Scoreboard;
      // 01d: astore 1
      // 01e: aload 1
      // 01f: ifnonnull 025
      // 022: aload 0
      // 023: areturn
      // 024: athrow
      // 025: aload 1
      // 026: bipush 1
      // 027: invokevirtual net/minecraft/scoreboard/Scoreboard.getObjectiveInDisplaySlot (I)Lnet/minecraft/scoreboard/ScoreObjective;
      // 02a: astore 2
      // 02b: aload 2
      // 02c: ifnonnull 032
      // 02f: aload 0
      // 030: areturn
      // 031: athrow
      // 032: aload 1
      // 033: aload 2
      // 034: invokevirtual net/minecraft/scoreboard/Scoreboard.getSortedScores (Lnet/minecraft/scoreboard/ScoreObjective;)Ljava/util/Collection;
      // 037: astore 3
      // 038: new java/util/ArrayList
      // 03b: dup
      // 03c: invokespecial java/util/ArrayList.<init> ()V
      // 03f: astore 4
      // 041: aload 3
      // 042: invokeinterface java/util/Collection.iterator ()Ljava/util/Iterator; 1
      // 047: astore 5
      // 049: aload 5
      // 04b: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 050: ifeq 093
      // 053: aload 5
      // 055: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 05a: checkcast net/minecraft/scoreboard/Score
      // 05d: astore 6
      // 05f: aload 6
      // 061: ifnull 090
      // 064: aload 6
      // 066: invokevirtual net/minecraft/scoreboard/Score.getPlayerName ()Ljava/lang/String;
      // 069: ifnull 090
      // 06c: goto 070
      // 06f: athrow
      // 070: aload 6
      // 072: invokevirtual net/minecraft/scoreboard/Score.getPlayerName ()Ljava/lang/String;
      // 075: ldc_w "#"
      // 078: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 07b: ifne 090
      // 07e: goto 082
      // 081: athrow
      // 082: aload 4
      // 084: aload 6
      // 086: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 08b: pop
      // 08c: goto 090
      // 08f: athrow
      // 090: goto 049
      // 093: aload 4
      // 095: invokeinterface java/util/List.size ()I 1
      // 09a: ldc_w 403003260
      // 09d: ldc_w 403003251
      // 0a0: ixor
      // 0a1: if_icmple 0c6
      // 0a4: new java/util/ArrayList
      // 0a7: dup
      // 0a8: aload 4
      // 0aa: aload 4
      // 0ac: invokeinterface java/util/List.size ()I 1
      // 0b1: ldc_w 403003260
      // 0b4: ldc_w 403003251
      // 0b7: ixor
      // 0b8: isub
      // 0b9: invokestatic com/google/common/collect/Iterables.skip (Ljava/lang/Iterable;I)Ljava/lang/Iterable;
      // 0bc: invokestatic com/google/common/collect/Lists.newArrayList (Ljava/lang/Iterable;)Ljava/util/ArrayList;
      // 0bf: invokespecial java/util/ArrayList.<init> (Ljava/util/Collection;)V
      // 0c2: astore 3
      // 0c3: goto 0c9
      // 0c6: aload 4
      // 0c8: astore 3
      // 0c9: bipush 0
      // 0ca: istore 5
      // 0cc: aload 3
      // 0cd: invokeinterface java/util/Collection.iterator ()Ljava/util/Iterator; 1
      // 0d2: astore 6
      // 0d4: aload 6
      // 0d6: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0db: ifeq 126
      // 0de: aload 6
      // 0e0: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0e5: checkcast net/minecraft/scoreboard/Score
      // 0e8: astore 7
      // 0ea: iinc 5 1
      // 0ed: aload 1
      // 0ee: aload 7
      // 0f0: invokevirtual net/minecraft/scoreboard/Score.getPlayerName ()Ljava/lang/String;
      // 0f3: invokevirtual net/minecraft/scoreboard/Scoreboard.getPlayersTeam (Ljava/lang/String;)Lnet/minecraft/scoreboard/ScorePlayerTeam;
      // 0f6: astore 8
      // 0f8: aload 0
      // 0f9: aload 8
      // 0fb: aload 7
      // 0fd: invokevirtual net/minecraft/scoreboard/Score.getPlayerName ()Ljava/lang/String;
      // 100: invokestatic net/minecraft/scoreboard/ScorePlayerTeam.formatPlayerName (Lnet/minecraft/scoreboard/Team;Ljava/lang/String;)Ljava/lang/String;
      // 103: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 108: pop
      // 109: iload 5
      // 10b: aload 3
      // 10c: invokeinterface java/util/Collection.size ()I 1
      // 111: if_icmpne 123
      // 114: aload 0
      // 115: aload 2
      // 116: invokevirtual net/minecraft/scoreboard/ScoreObjective.getDisplayName ()Ljava/lang/String;
      // 119: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 11e: pop
      // 11f: goto 123
      // 122: athrow
      // 123: goto 0d4
      // 126: aload 0
      // 127: invokestatic java/util/Collections.reverse (Ljava/util/List;)V
      // 12a: aload 0
      // 12b: areturn
   }

   public static Random û() {
      return ʧ;
   }

   public static boolean ȣ() {
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
      // 07: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0a: getfield net/minecraft/client/entity/EntityPlayerSP.moveForward F
      // 0d: fconst_0
      // 0e: fcmpl
      // 0f: iload 0
      // 10: ifne 35
      // 13: ifne 34
      // 16: goto 1a
      // 19: athrow
      // 1a: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 1d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 20: getfield net/minecraft/client/entity/EntityPlayerSP.moveStrafing F
      // 23: fconst_0
      // 24: fcmpl
      // 25: iload 0
      // 26: ifne 35
      // 29: goto 2d
      // 2c: athrow
      // 2d: ifeq 38
      // 30: goto 34
      // 33: athrow
      // 34: bipush 1
      // 35: goto 39
      // 38: bipush 0
      // 39: ireturn
   }

   public static void ʩ(Entity param0, float param1, boolean param2) {
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
      // 09: ifnull 7f
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 0
      // 11: invokestatic x/oc7ab2161b9f.Ǚ (Lnet/minecraft/entity/Entity;)[F
      // 14: astore 4
      // 16: aload 4
      // 18: iload 3
      // 19: ifne 25
      // 1c: ifnull 7f
      // 1f: goto 23
      // 22: athrow
      // 23: aload 4
      // 25: bipush 0
      // 26: faload
      // 27: fstore 5
      // 29: iload 3
      // 2a: aload 4
      // 2c: bipush 1
      // 2d: faload
      // 2e: ldc 4.0
      // 30: fadd
      // 31: fload 1
      // 32: fadd
      // 33: fstore 6
      // 35: ifne 74
      // 38: iload 2
      // 39: ifeq 65
      // 3c: goto 40
      // 3f: athrow
      // 40: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 43: invokevirtual net/minecraft/client/Minecraft.getNetHandler ()Lnet/minecraft/client/network/NetHandlerPlayClient;
      // 46: new net/minecraft/network/play/client/C03PacketPlayer$C05PacketPlayerLook
      // 49: dup
      // 4a: fload 5
      // 4c: fload 6
      // 4e: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 51: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 54: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 57: invokespecial net/minecraft/network/play/client/C03PacketPlayer$C05PacketPlayerLook.<init> (FFZ)V
      // 5a: invokevirtual net/minecraft/client/network/NetHandlerPlayClient.addToSendQueue (Lnet/minecraft/network/Packet;)V
      // 5d: iload 3
      // 5e: ifeq 7f
      // 61: goto 65
      // 64: athrow
      // 65: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 68: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 6b: fload 5
      // 6d: putfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 70: goto 74
      // 73: athrow
      // 74: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 77: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 7a: fload 6
      // 7c: putfield net/minecraft/client/entity/EntityPlayerSP.rotationPitch F
      // 7f: return
   }

   public static float[] Ǚ(Entity param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 1
      // 004: aload 0
      // 005: iload 1
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
      // 021: dstore 2
      // 022: aload 0
      // 023: iload 1
      // 024: ifne 063
      // 027: instanceof net/minecraft/entity/EntityLivingBase
      // 02a: ifeq 062
      // 02d: goto 031
      // 030: athrow
      // 031: aload 0
      // 032: checkcast net/minecraft/entity/EntityLivingBase
      // 035: astore 6
      // 037: iload 1
      // 038: aload 6
      // 03a: getfield net/minecraft/entity/EntityLivingBase.posY D
      // 03d: aload 6
      // 03f: invokevirtual net/minecraft/entity/EntityLivingBase.getEyeHeight ()F
      // 042: f2d
      // 043: ldc2_w 0.9
      // 046: dmul
      // 047: dadd
      // 048: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 04b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 04e: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // 051: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 054: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 057: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getEyeHeight ()F
      // 05a: f2d
      // 05b: dadd
      // 05c: dsub
      // 05d: dstore 4
      // 05f: ifeq 08c
      // 062: aload 0
      // 063: invokevirtual net/minecraft/entity/Entity.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 066: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 069: aload 0
      // 06a: invokevirtual net/minecraft/entity/Entity.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 06d: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 070: dadd
      // 071: ldc2_w 2.0
      // 074: ddiv
      // 075: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 078: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 07b: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // 07e: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 081: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 084: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getEyeHeight ()F
      // 087: f2d
      // 088: dadd
      // 089: dsub
      // 08a: dstore 4
      // 08c: aload 0
      // 08d: getfield net/minecraft/entity/Entity.posZ D
      // 090: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 093: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 096: getfield net/minecraft/client/entity/EntityPlayerSP.posZ D
      // 099: dsub
      // 09a: dstore 6
      // 09c: dload 2
      // 09d: dload 2
      // 09e: dmul
      // 09f: dload 6
      // 0a1: dload 6
      // 0a3: dmul
      // 0a4: dadd
      // 0a5: invokestatic net/minecraft/util/MathHelper.sqrt_double (D)F
      // 0a8: f2d
      // 0a9: dstore 8
      // 0ab: dload 6
      // 0ad: dload 2
      // 0ae: invokestatic java/lang/Math.atan2 (DD)D
      // 0b1: ldc2_w 180.0
      // 0b4: dmul
      // 0b5: ldc2_w 3.141592653589793
      // 0b8: ddiv
      // 0b9: d2f
      // 0ba: ldc_w 90.0
      // 0bd: fsub
      // 0be: fstore 10
      // 0c0: dload 4
      // 0c2: dload 8
      // 0c4: invokestatic java/lang/Math.atan2 (DD)D
      // 0c7: ldc2_w 180.0
      // 0ca: dmul
      // 0cb: ldc2_w 3.141592653589793
      // 0ce: ddiv
      // 0cf: dneg
      // 0d0: d2f
      // 0d1: fstore 11
      // 0d3: ldc_w 1556429009
      // 0d6: ldc_w 1556429011
      // 0d9: ixor
      // 0da: newarray 6
      // 0dc: dup
      // 0dd: bipush 0
      // 0de: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 0e1: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0e4: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 0e7: fload 10
      // 0e9: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 0ec: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0ef: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 0f2: fsub
      // 0f3: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_float (F)F
      // 0f6: fadd
      // 0f7: fastore
      // 0f8: dup
      // 0f9: bipush 1
      // 0fa: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 0fd: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 100: getfield net/minecraft/client/entity/EntityPlayerSP.rotationPitch F
      // 103: fload 11
      // 105: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 108: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 10b: getfield net/minecraft/client/entity/EntityPlayerSP.rotationPitch F
      // 10e: fsub
      // 10f: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_float (F)F
      // 112: fadd
      // 113: fastore
      // 114: areturn
   }

   public static double ɰ(Entity var0, boolean var1) {
      try {
         if (var1) {
            return ((oc75d51ec7eb.d[0] - ǡ(var0)) % 360.0 + 540.0) % 360.0 - 180.0;
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }

      return ((ocda171fe5d8.ǔ.thePlayer.rotationYaw - ǡ(var0)) % 360.0 + 540.0) % 360.0 - 180.0;
   }

   public static double Ե(Entity var0, boolean var1) {
      try {
         if (var1) {
            return ((oc75d51ec7eb.d[1] - Ԁ(var0)) % 360.0 + 540.0) % 360.0 - 180.0;
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }

      return ((ocda171fe5d8.ǔ.thePlayer.rotationPitch - Ԁ(var0)) % 360.0 + 540.0) % 360.0 - 180.0;
   }

   public static float ǡ(Entity var0) {
      double var1 = var0.posX - ocda171fe5d8.ǔ.thePlayer.posX;
      double var3 = var0.posZ - ocda171fe5d8.ǔ.thePlayer.posZ;
      double var5 = Math.atan2(var1, var3) * (180.0 / Math.PI);
      return (float)(var5 * -1.0);
   }

   public static float Ԁ(Entity var0) {
      double var1 = var0.posX - ocda171fe5d8.ǔ.thePlayer.posX;
      double var3 = var0.posZ - ocda171fe5d8.ǔ.thePlayer.posZ;
      double var5 = var0.posY + var0.getEyeHeight() / 2.0F - (ocda171fe5d8.ǔ.thePlayer.posY + ocda171fe5d8.ǔ.thePlayer.getEyeHeight());
      double var7 = Math.atan2(var5, Math.sqrt(var1 * var1 + var3 * var3)) * (180.0 / Math.PI);
      return (float)(var7 * -1.0);
   }

   public static void ā(int param0, boolean param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 2
      // 04: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 07: iload 2
      // 08: ifne 24
      // 0b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0e: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 11: iload 0
      // 12: putfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 15: iload 1
      // 16: ifeq 2c
      // 19: goto 1d
      // 1c: athrow
      // 1d: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 20: goto 24
      // 23: athrow
      // 24: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 27: invokeinterface x/oc51cbcffcfe.callSyncCurrentPlayItem ()V 1
      // 2c: return
   }

   public static MovingObjectPosition F(double var0, float var2, float var3) {
      Vec3 var4 = ocda171fe5d8.ǔ.thePlayer.getPositionEyes(1.0F);
      float var5 = -var2 * (float) (Math.PI / 180.0);
      float var6 = -var3 * (float) (Math.PI / 180.0);
      float var7 = MathHelper.cos(var5 - (float) Math.PI);
      float var8 = MathHelper.sin(var5 - (float) Math.PI);
      float var9 = -MathHelper.cos(var6);
      float var10 = MathHelper.sin(var6);
      Vec3 var11 = new Vec3(var8 * var9, var10, var7 * var9);
      Vec3 var12 = var4.addVector(var11.xCoord * var0, var11.yCoord * var0, var11.zCoord * var0);
      return ocda171fe5d8.ǔ.theWorld.rayTraceBlocks(var4, var12, false, false, false);
   }

   public static boolean ƶ(BlockPos param0, double param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokestatic x/oc75d51ec7eb.В (Lnet/minecraft/util/BlockPos;)[F
      // 04: astore 4
      // 06: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 09: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0c: fconst_1
      // 0d: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 10: astore 5
      // 12: aload 4
      // 14: bipush 0
      // 15: faload
      // 16: fneg
      // 17: ldc_w 0.017453292
      // 1a: fmul
      // 1b: fstore 6
      // 1d: aload 4
      // 1f: bipush 1
      // 20: faload
      // 21: fneg
      // 22: ldc_w 0.017453292
      // 25: fmul
      // 26: fstore 7
      // 28: fload 6
      // 2a: ldc 3.1415927
      // 2c: fsub
      // 2d: invokestatic net/minecraft/util/MathHelper.cos (F)F
      // 30: fstore 8
      // 32: fload 6
      // 34: ldc 3.1415927
      // 36: fsub
      // 37: invokestatic net/minecraft/util/MathHelper.sin (F)F
      // 3a: fstore 9
      // 3c: fload 7
      // 3e: invokestatic net/minecraft/util/MathHelper.cos (F)F
      // 41: fneg
      // 42: fstore 10
      // 44: getstatic x/oc75d51ec7eb.ϩ I
      // 47: fload 7
      // 49: invokestatic net/minecraft/util/MathHelper.sin (F)F
      // 4c: fstore 11
      // 4e: new net/minecraft/util/Vec3
      // 51: dup
      // 52: fload 9
      // 54: fload 10
      // 56: fmul
      // 57: f2d
      // 58: fload 11
      // 5a: f2d
      // 5b: fload 8
      // 5d: fload 10
      // 5f: fmul
      // 60: f2d
      // 61: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 64: astore 12
      // 66: aload 5
      // 68: aload 12
      // 6a: getfield net/minecraft/util/Vec3.xCoord D
      // 6d: dload 1
      // 6e: dmul
      // 6f: aload 12
      // 71: getfield net/minecraft/util/Vec3.yCoord D
      // 74: dload 1
      // 75: dmul
      // 76: aload 12
      // 78: getfield net/minecraft/util/Vec3.zCoord D
      // 7b: dload 1
      // 7c: dmul
      // 7d: invokevirtual net/minecraft/util/Vec3.addVector (DDD)Lnet/minecraft/util/Vec3;
      // 80: astore 13
      // 82: istore 3
      // 83: aload 0
      // 84: invokestatic x/occb1ed1ed8f.ϛ (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/Block;
      // 87: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 8a: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 8d: aload 0
      // 8e: aload 0
      // 8f: invokestatic x/occb1ed1ed8f.О (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 92: invokevirtual net/minecraft/block/Block.getCollisionBoundingBox (Lnet/minecraft/world/World;Lnet/minecraft/util/BlockPos;Lnet/minecraft/block/state/IBlockState;)Lnet/minecraft/util/AxisAlignedBB;
      // 95: astore 14
      // 97: aload 14
      // 99: iload 3
      // 9a: ifne a9
      // 9d: ifnonnull a7
      // a0: goto a4
      // a3: athrow
      // a4: bipush 0
      // a5: ireturn
      // a6: athrow
      // a7: aload 14
      // a9: aload 5
      // ab: aload 13
      // ad: invokevirtual net/minecraft/util/AxisAlignedBB.calculateIntercept (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/MovingObjectPosition;
      // b0: astore 15
      // b2: aload 15
      // b4: ifnull bc
      // b7: bipush 1
      // b8: goto bd
      // bb: athrow
      // bc: bipush 0
      // bd: ireturn
   }

   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static void ΰ(double var0, boolean var2) {
      int var3 = oc75d51ec7eb.ϩ;

      label33: {
         label32: {
            boolean var10000;
            label31: {
               try {
                  var10000 = var2;
                  if (var3 != 0) {
                     break label31;
                  }

                  if (!var2) {
                     break label32;
                  }
               } catch (ocbde1165e4e var7) {
                  throw var7;
               }

               var10000 = ȣ();
            }

            try {
               if (!var10000) {
                  break label33;
               }
            } catch (ocbde1165e4e var6) {
               throw var6;
            }
         }

         try {
            ocda171fe5d8.ǔ.thePlayer.motionX = -Math.sin(ʏ()) * var0;
            ocda171fe5d8.ǔ.thePlayer.motionZ = Math.cos(ʏ()) * var0;
         } catch (ocbde1165e4e var5) {
            throw var5;
         }
      }

      try {
         ;
      } catch (ocbde1165e4e var4) {
         throw var4;
      }
   }

   public static boolean Ϡ() {
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
      // 07: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 0a: getfield net/minecraft/client/settings/GameSettings.keyBindForward Lnet/minecraft/client/settings/KeyBinding;
      // 0d: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // 10: iload 0
      // 11: ifne 7d
      // 14: invokestatic org/lwjgl/input/Keyboard.isKeyDown (I)Z
      // 17: ifne 78
      // 1a: goto 1e
      // 1d: athrow
      // 1e: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 21: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 24: getfield net/minecraft/client/settings/GameSettings.keyBindBack Lnet/minecraft/client/settings/KeyBinding;
      // 27: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // 2a: iload 0
      // 2b: ifne 7d
      // 2e: goto 32
      // 31: athrow
      // 32: invokestatic org/lwjgl/input/Keyboard.isKeyDown (I)Z
      // 35: ifne 78
      // 38: goto 3c
      // 3b: athrow
      // 3c: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 3f: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 42: getfield net/minecraft/client/settings/GameSettings.keyBindLeft Lnet/minecraft/client/settings/KeyBinding;
      // 45: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // 48: iload 0
      // 49: ifne 7d
      // 4c: goto 50
      // 4f: athrow
      // 50: invokestatic org/lwjgl/input/Keyboard.isKeyDown (I)Z
      // 53: ifne 78
      // 56: goto 5a
      // 59: athrow
      // 5a: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 5d: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 60: getfield net/minecraft/client/settings/GameSettings.keyBindRight Lnet/minecraft/client/settings/KeyBinding;
      // 63: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // 66: iload 0
      // 67: ifne 7d
      // 6a: goto 6e
      // 6d: athrow
      // 6e: invokestatic org/lwjgl/input/Keyboard.isKeyDown (I)Z
      // 71: ifeq 80
      // 74: goto 78
      // 77: athrow
      // 78: bipush 1
      // 79: goto 7d
      // 7c: athrow
      // 7d: goto 81
      // 80: bipush 0
      // 81: ireturn
   }

   public static boolean ƃ() {
      return Keyboard.isKeyDown(ocda171fe5d8.ǔ.gameSettings.keyBindJump.getKeyCode());
   }

   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static double П(Entity var0) {
      int var1 = oc75d51ec7eb.ϩ;

      try {
         if (var0.onGround) {
            return 0.0;
         }
      } catch (ocbde1165e4e var10) {
         throw var10;
      }

      double var2 = -1.0;
      double var4 = var0.posY;

      double var10000;
      label49: {
         label48: {
            try {
               var10000 = var0.posY;
               if (var1 != 0) {
                  break label49;
               }

               if (var0.posY % 1.0 != 0.0) {
                  break label48;
               }
            } catch (ocbde1165e4e var9) {
               throw var9;
            }

            var4--;
         }

         var10000 = Math.floor(var4);
      }

      int var6 = (int)var10000;

      while (var6 > -1) {
         if (!ǆ(new BlockPos(var0.posX, var6, var0.posZ))) {
            var2 = var4 - var6;

            try {
               if (var1 == 0) {
                  break;
               }
            } catch (ocbde1165e4e var8) {
               throw var8;
            }
         }

         try {
            var6--;
            if (var1 != 0) {
               break;
            }
         } catch (ocbde1165e4e var7) {
            throw var7;
         }
      }

      return var2 - 1.0;
   }

   public static float ʏ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 06: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 09: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 0c: fstore 1
      // 0d: istore 0
      // 0e: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 11: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 14: getfield net/minecraft/client/entity/EntityPlayerSP.moveForward F
      // 17: fconst_0
      // 18: iload 0
      // 19: ifne 33
      // 1c: fcmpg
      // 1d: ifge 29
      // 20: goto 24
      // 23: athrow
      // 24: fload 1
      // 25: ldc 180.0
      // 27: fadd
      // 28: fstore 1
      // 29: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 2c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 2f: getfield net/minecraft/client/entity/EntityPlayerSP.moveForward F
      // 32: fconst_0
      // 33: iload 0
      // 34: ifne 5d
      // 37: fcmpg
      // 38: ifge 47
      // 3b: goto 3f
      // 3e: athrow
      // 3f: ldc_w -0.5
      // 42: fstore 2
      // 43: iload 0
      // 44: ifeq 6f
      // 47: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 4a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 4d: getfield net/minecraft/client/entity/EntityPlayerSP.moveForward F
      // 50: iload 0
      // 51: ifne 6e
      // 54: goto 58
      // 57: athrow
      // 58: fconst_0
      // 59: goto 5d
      // 5c: athrow
      // 5d: fcmpl
      // 5e: ifle 69
      // 61: ldc_w 0.5
      // 64: fstore 2
      // 65: iload 0
      // 66: ifeq 6f
      // 69: fconst_1
      // 6a: goto 6e
      // 6d: athrow
      // 6e: fstore 2
      // 6f: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 72: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 75: getfield net/minecraft/client/entity/EntityPlayerSP.moveStrafing F
      // 78: fconst_0
      // 79: iload 0
      // 7a: ifne 9f
      // 7d: fcmpl
      // 7e: ifle 8d
      // 81: goto 85
      // 84: athrow
      // 85: fload 1
      // 86: ldc_w 90.0
      // 89: fload 2
      // 8a: fmul
      // 8b: fsub
      // 8c: fstore 1
      // 8d: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 90: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 93: getfield net/minecraft/client/entity/EntityPlayerSP.moveStrafing F
      // 96: iload 0
      // 97: ifne b2
      // 9a: fconst_0
      // 9b: goto 9f
      // 9e: athrow
      // 9f: fcmpg
      // a0: ifge ab
      // a3: fload 1
      // a4: ldc_w 90.0
      // a7: fload 2
      // a8: fmul
      // a9: fadd
      // aa: fstore 1
      // ab: fload 1
      // ac: ldc_w 0.017453292
      // af: fmul
      // b0: fstore 1
      // b1: fload 1
      // b2: freturn
   }

   public static float q(float param0, float param1, float param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: fconst_1
      // 04: fstore 4
      // 06: istore 3
      // 07: fload 1
      // 08: iload 3
      // 09: ifne 24
      // 0c: fconst_0
      // 0d: fcmpg
      // 0e: ifge 23
      // 11: goto 15
      // 14: athrow
      // 15: fload 0
      // 16: ldc 180.0
      // 18: fadd
      // 19: fstore 0
      // 1a: iload 3
      // 1b: ldc_w -0.5
      // 1e: fstore 4
      // 20: ifeq 36
      // 23: fload 1
      // 24: fconst_0
      // 25: iload 3
      // 26: ifne 38
      // 29: fcmpl
      // 2a: ifle 36
      // 2d: goto 31
      // 30: athrow
      // 31: ldc_w 0.5
      // 34: fstore 4
      // 36: fload 2
      // 37: fconst_0
      // 38: iload 3
      // 39: ifne 5f
      // 3c: fcmpl
      // 3d: ifle 51
      // 40: goto 44
      // 43: athrow
      // 44: fload 0
      // 45: ldc_w 90.0
      // 48: fload 4
      // 4a: fmul
      // 4b: fsub
      // 4c: fstore 0
      // 4d: iload 3
      // 4e: ifeq 6c
      // 51: fload 2
      // 52: iload 3
      // 53: ifne 71
      // 56: goto 5a
      // 59: athrow
      // 5a: fconst_0
      // 5b: goto 5f
      // 5e: athrow
      // 5f: fcmpg
      // 60: ifge 6c
      // 63: fload 0
      // 64: ldc_w 90.0
      // 67: fload 4
      // 69: fmul
      // 6a: fadd
      // 6b: fstore 0
      // 6c: fload 0
      // 6d: ldc_w 0.017453292
      // 70: fmul
      // 71: freturn
   }

   public static double ř() {
      return Ϩ(ocda171fe5d8.ǔ.thePlayer);
   }

   public static double Ϩ(Entity var0) {
      return Math.sqrt(var0.motionX * var0.motionX + var0.motionZ * var0.motionZ);
   }

   public static List<String> ը(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: new java/util/ArrayList
      // 006: dup
      // 007: invokespecial java/util/ArrayList.<init> ()V
      // 00a: astore 2
      // 00b: aload 0
      // 00c: ldc_w "\\r?\\n"
      // 00f: invokevirtual java/lang/String.split (Ljava/lang/String;)[Ljava/lang/String;
      // 012: astore 3
      // 013: istore 1
      // 014: bipush 0
      // 015: istore 4
      // 017: bipush 0
      // 018: istore 5
      // 01a: aload 3
      // 01b: astore 6
      // 01d: aload 6
      // 01f: arraylength
      // 020: istore 7
      // 022: bipush 0
      // 023: istore 8
      // 025: iload 8
      // 027: iload 7
      // 029: if_icmpge 25e
      // 02c: aload 6
      // 02e: iload 8
      // 030: aaload
      // 031: astore 9
      // 033: aload 9
      // 035: astore 10
      // 037: aload 9
      // 039: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 03c: astore 11
      // 03e: iload 5
      // 040: iload 1
      // 041: ifne 08f
      // 044: ifeq 07f
      // 047: goto 04b
      // 04a: athrow
      // 04b: aload 11
      // 04d: iload 1
      // 04e: ifne 07d
      // 051: goto 055
      // 054: athrow
      // 055: ldc_w "*/"
      // 058: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 05b: ifeq 257
      // 05e: goto 062
      // 061: athrow
      // 062: bipush 0
      // 063: istore 5
      // 065: aload 11
      // 067: aload 11
      // 069: ldc_w "*/"
      // 06c: invokevirtual java/lang/String.indexOf (Ljava/lang/String;)I
      // 06f: ldc_w -939566272
      // 072: ldc_w -939566270
      // 075: ixor
      // 076: iadd
      // 077: invokevirtual java/lang/String.substring (I)Ljava/lang/String;
      // 07a: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 07d: astore 11
      // 07f: aload 11
      // 081: ldc_w "//"
      // 084: iload 1
      // 085: ifne 0ab
      // 088: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 08b: goto 08f
      // 08e: athrow
      // 08f: ifeq 09a
      // 092: iload 1
      // 093: ifeq 257
      // 096: goto 09a
      // 099: athrow
      // 09a: aload 11
      // 09c: iload 1
      // 09d: ifne 0e5
      // 0a0: goto 0a4
      // 0a3: athrow
      // 0a4: ldc_w "/*"
      // 0a7: goto 0ab
      // 0aa: athrow
      // 0ab: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 0ae: ifeq 0df
      // 0b1: bipush 1
      // 0b2: iload 1
      // 0b3: ifne 0f3
      // 0b6: goto 0ba
      // 0b9: athrow
      // 0ba: istore 5
      // 0bc: aload 11
      // 0be: bipush 0
      // 0bf: aload 11
      // 0c1: ldc_w "/*"
      // 0c4: invokevirtual java/lang/String.indexOf (Ljava/lang/String;)I
      // 0c7: invokevirtual java/lang/String.substring (II)Ljava/lang/String;
      // 0ca: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 0cd: astore 11
      // 0cf: aload 11
      // 0d1: invokevirtual java/lang/String.isEmpty ()Z
      // 0d4: ifeq 0df
      // 0d7: iload 1
      // 0d8: ifeq 257
      // 0db: goto 0df
      // 0de: athrow
      // 0df: aload 11
      // 0e1: goto 0e5
      // 0e4: athrow
      // 0e5: ldc_w "//"
      // 0e8: iload 1
      // 0e9: ifne 116
      // 0ec: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 0ef: goto 0f3
      // 0f2: athrow
      // 0f3: ifeq 109
      // 0f6: aload 11
      // 0f8: bipush 0
      // 0f9: aload 11
      // 0fb: ldc_w "//"
      // 0fe: invokevirtual java/lang/String.indexOf (Ljava/lang/String;)I
      // 101: invokevirtual java/lang/String.substring (II)Ljava/lang/String;
      // 104: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 107: astore 11
      // 109: aload 11
      // 10b: iload 1
      // 10c: ifne 166
      // 10f: ldc_w "/*"
      // 112: goto 116
      // 115: athrow
      // 116: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 119: ifeq 164
      // 11c: aload 11
      // 11e: iload 1
      // 11f: ifne 166
      // 122: goto 126
      // 125: athrow
      // 126: ldc_w "*/"
      // 129: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 12c: ifeq 164
      // 12f: goto 133
      // 132: athrow
      // 133: aload 11
      // 135: bipush 0
      // 136: aload 11
      // 138: ldc_w "/*"
      // 13b: invokevirtual java/lang/String.indexOf (Ljava/lang/String;)I
      // 13e: invokevirtual java/lang/String.substring (II)Ljava/lang/String;
      // 141: aload 11
      // 143: aload 11
      // 145: ldc_w "*/"
      // 148: invokevirtual java/lang/String.indexOf (Ljava/lang/String;)I
      // 14b: ldc_w -939566272
      // 14e: ldc_w -939566270
      // 151: ixor
      // 152: iadd
      // 153: invokevirtual java/lang/String.substring (I)Ljava/lang/String;
      // 156: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 15b: astore 11
      // 15d: aload 11
      // 15f: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 162: astore 11
      // 164: aload 11
      // 166: iload 1
      // 167: ifne 185
      // 16a: invokevirtual java/lang/String.isEmpty ()Z
      // 16d: ifeq 17c
      // 170: goto 174
      // 173: athrow
      // 174: iload 1
      // 175: ifeq 257
      // 178: goto 17c
      // 17b: athrow
      // 17c: aload 11
      // 17e: invokestatic x/oc7ab2161b9f.Ā (Ljava/lang/String;)Ljava/lang/String;
      // 181: goto 185
      // 184: athrow
      // 185: astore 12
      // 187: bipush 0
      // 188: istore 13
      // 18a: bipush 0
      // 18b: istore 14
      // 18d: aload 12
      // 18f: invokevirtual java/lang/String.toCharArray ()[C
      // 192: astore 15
      // 194: aload 15
      // 196: arraylength
      // 197: istore 16
      // 199: bipush 0
      // 19a: istore 17
      // 19c: iload 17
      // 19e: iload 16
      // 1a0: if_icmpge 1ef
      // 1a3: aload 15
      // 1a5: iload 17
      // 1a7: caload
      // 1a8: istore 18
      // 1aa: iload 1
      // 1ab: ifne 1fd
      // 1ae: iload 18
      // 1b0: iload 1
      // 1b1: ifne 1d7
      // 1b4: goto 1b8
      // 1b7: athrow
      // 1b8: ldc_w -939566279
      // 1bb: ldc_w -939566270
      // 1be: ixor
      // 1bf: if_icmpne 1d1
      // 1c2: goto 1c6
      // 1c5: athrow
      // 1c6: iinc 13 1
      // 1c9: iload 1
      // 1ca: ifeq 1e8
      // 1cd: goto 1d1
      // 1d0: athrow
      // 1d1: iload 18
      // 1d3: goto 1d7
      // 1d6: athrow
      // 1d7: ldc_w -939566273
      // 1da: ldc_w -939566270
      // 1dd: ixor
      // 1de: if_icmpne 1e8
      // 1e1: iinc 14 1
      // 1e4: goto 1e8
      // 1e7: athrow
      // 1e8: iinc 17 1
      // 1eb: iload 1
      // 1ec: ifeq 19c
      // 1ef: iload 4
      // 1f1: iload 13
      // 1f3: iload 14
      // 1f5: isub
      // 1f6: iadd
      // 1f7: istore 4
      // 1f9: iload 1
      // 1fa: ifne 25a
      // 1fd: iload 4
      // 1ff: ifne 257
      // 202: aload 11
      // 204: iload 1
      // 205: ifne 21f
      // 208: goto 20c
      // 20b: athrow
      // 20c: ldc_w "{"
      // 20f: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 212: ifne 257
      // 215: goto 219
      // 218: athrow
      // 219: aload 11
      // 21b: goto 21f
      // 21e: athrow
      // 21f: iload 1
      // 220: ifne 236
      // 223: ldc_w "}"
      // 226: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 229: ifne 257
      // 22c: goto 230
      // 22f: athrow
      // 230: aload 11
      // 232: goto 236
      // 235: athrow
      // 236: ldc_w "@"
      // 239: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 23c: iload 1
      // 23d: ifne 256
      // 240: ifne 257
      // 243: goto 247
      // 246: athrow
      // 247: aload 2
      // 248: aload 10
      // 24a: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 24d: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 252: goto 256
      // 255: athrow
      // 256: pop
      // 257: iinc 8 1
      // 25a: iload 1
      // 25b: ifeq 025
      // 25e: aload 2
      // 25f: areturn
   }

   public static boolean ʵ(ItemStack param0) {
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
      // 05: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 08: instanceof net/minecraft/item/ItemFood
      // 0b: iload 1
      // 0c: ifne 48
      // 0f: ifeq 47
      // 12: goto 16
      // 15: athrow
      // 16: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 19: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1c: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getFoodStats ()Lnet/minecraft/util/FoodStats;
      // 1f: invokevirtual net/minecraft/util/FoodStats.getFoodLevel ()I
      // 22: iload 1
      // 23: ifne 48
      // 26: goto 2a
      // 29: athrow
      // 2a: ldc_w -1886620584
      // 2d: ldc_w -1886620596
      // 30: ixor
      // 31: if_icmpne 47
      // 34: goto 38
      // 37: athrow
      // 38: aload 0
      // 39: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 3c: checkcast net/minecraft/item/ItemFood
      // 3f: astore 2
      // 40: aload 2
      // 41: invokeinterface x/oc94a01ae980.getAlwaysEdible ()Z 1
      // 46: ireturn
      // 47: bipush 1
      // 48: ireturn
   }

   private static String Ā(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: new java/lang/StringBuilder
      // 03: dup
      // 04: invokespecial java/lang/StringBuilder.<init> ()V
      // 07: astore 2
      // 08: getstatic x/oc75d51ec7eb.ϩ I
      // 0b: bipush 0
      // 0c: istore 3
      // 0d: bipush 0
      // 0e: istore 4
      // 10: istore 1
      // 11: iload 4
      // 13: aload 0
      // 14: invokevirtual java/lang/String.length ()I
      // 17: if_icmpge 9d
      // 1a: aload 0
      // 1b: iload 1
      // 1c: ifne a1
      // 1f: iload 4
      // 21: invokevirtual java/lang/String.charAt (I)C
      // 24: istore 5
      // 26: iload 5
      // 28: iload 1
      // 29: ifne 88
      // 2c: ldc_w 1310817033
      // 2f: ldc_w 1310817067
      // 32: ixor
      // 33: if_icmpne 83
      // 36: goto 3a
      // 39: athrow
      // 3a: iload 4
      // 3c: iload 1
      // 3d: ifne 6e
      // 40: goto 44
      // 43: athrow
      // 44: ifeq 69
      // 47: goto 4b
      // 4a: athrow
      // 4b: aload 0
      // 4c: iload 4
      // 4e: bipush 1
      // 4f: isub
      // 50: invokevirtual java/lang/String.charAt (I)C
      // 53: iload 1
      // 54: ifne 88
      // 57: goto 5b
      // 5a: athrow
      // 5b: ldc_w 1310817143
      // 5e: ldc_w 1310817067
      // 61: ixor
      // 62: if_icmpeq 83
      // 65: goto 69
      // 68: athrow
      // 69: iload 3
      // 6a: goto 6e
      // 6d: athrow
      // 6e: iload 1
      // 6f: ifne 7a
      // 72: ifne 7d
      // 75: goto 79
      // 78: athrow
      // 79: bipush 1
      // 7a: goto 7e
      // 7d: bipush 0
      // 7e: istore 3
      // 7f: iload 1
      // 80: ifeq 96
      // 83: iload 3
      // 84: goto 88
      // 87: athrow
      // 88: ifne 96
      // 8b: aload 2
      // 8c: iload 5
      // 8e: invokevirtual java/lang/StringBuilder.append (C)Ljava/lang/StringBuilder;
      // 91: pop
      // 92: goto 96
      // 95: athrow
      // 96: iinc 4 1
      // 99: iload 1
      // 9a: ifeq 11
      // 9d: aload 2
      // 9e: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // a1: areturn
   }

   public static boolean Ș() {
      int var0 = oc75d51ec7eb.ϩ;

      try {
         boolean var10000 = occb1ed1ed8f.ϛ(new BlockPos(ocda171fe5d8.ǔ.thePlayer.posX, ocda171fe5d8.ǔ.thePlayer.posY + 2.0, ocda171fe5d8.ǔ.thePlayer.posZ)) instanceof BlockAir;
         if (var0 != 0) {
            return var10000;
         }

         if (!var10000) {
            return true;
         }
      } catch (ocbde1165e4e var1) {
         throw var1;
      }

      return false;
   }

   public static boolean ӛ() {
      return ӂ(ocda171fe5d8.ǔ.thePlayer);
   }

   public static boolean ӂ(Entity var0) {
      return ocda171fe5d8.ǔ
         .theWorld
         .getCollidingBoundingBoxes(var0, var0.getEntityBoundingBox().offset(var0.motionX / 3.0, -1.0, var0.motionZ / 3.0))
         .isEmpty();
   }

   public static boolean Ɩ() {
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
      // 0b: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 0e: ifnull 45
      // 11: goto 15
      // 14: athrow
      // 15: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 18: goto 1c
      // 1b: athrow
      // 1c: iload 0
      // 1d: ifne 37
      // 20: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 23: getfield net/minecraft/util/MovingObjectPosition.typeOfHit Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 26: getstatic net/minecraft/util/MovingObjectPosition$MovingObjectType.BLOCK Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 29: if_acmpne 45
      // 2c: goto 30
      // 2f: athrow
      // 30: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 33: goto 37
      // 36: athrow
      // 37: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 3a: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 3d: ifnull 45
      // 40: bipush 1
      // 41: goto 46
      // 44: athrow
      // 45: bipush 0
      // 46: ireturn
   }

   public static boolean Ā(boolean param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 006: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 009: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 00c: ldc_w 360.0
      // 00f: frem
      // 010: ldc_w 360.0
      // 013: fadd
      // 014: ldc_w 360.0
      // 017: frem
      // 018: fstore 2
      // 019: istore 1
      // 01a: fload 2
      // 01b: iload 1
      // 01c: ifne 032
      // 01f: ldc 180.0
      // 021: fcmpl
      // 022: ifle 035
      // 025: goto 029
      // 028: athrow
      // 029: fload 2
      // 02a: ldc_w 360.0
      // 02d: fsub
      // 02e: goto 032
      // 031: athrow
      // 032: goto 036
      // 035: fload 2
      // 036: fstore 2
      // 037: ldc2_w -170.0
      // 03a: ldc2_w 170.0
      // 03d: fload 2
      // 03e: iload 1
      // 03f: ifne 058
      // 042: f2d
      // 043: invokestatic x/oc7ab2161b9f.ʀ (DDD)Z
      // 046: ifeq 09f
      // 049: goto 04d
      // 04c: athrow
      // 04d: ldc2_w -10.0
      // 050: ldc2_w 10.0
      // 053: fload 2
      // 054: goto 058
      // 057: athrow
      // 058: iload 1
      // 059: ifne 07a
      // 05c: f2d
      // 05d: invokestatic x/oc7ab2161b9f.ʀ (DDD)Z
      // 060: ifne 09f
      // 063: goto 067
      // 066: athrow
      // 067: ldc2_w 80.0
      // 06a: ldc2_w 100.0
      // 06d: iload 1
      // 06e: ifne 08b
      // 071: goto 075
      // 074: athrow
      // 075: fload 2
      // 076: goto 07a
      // 079: athrow
      // 07a: f2d
      // 07b: invokestatic x/oc7ab2161b9f.ʀ (DDD)Z
      // 07e: ifne 09f
      // 081: ldc2_w -100.0
      // 084: ldc2_w -80.0
      // 087: goto 08b
      // 08a: athrow
      // 08b: fload 2
      // 08c: f2d
      // 08d: invokestatic x/oc7ab2161b9f.ʀ (DDD)Z
      // 090: iload 1
      // 091: ifne 09c
      // 094: ifne 09f
      // 097: goto 09b
      // 09a: athrow
      // 09b: bipush 1
      // 09c: goto 0a0
      // 09f: bipush 0
      // 0a0: istore 3
      // 0a1: iload 0
      // 0a2: iload 1
      // 0a3: ifne 132
      // 0a6: ifeq 11b
      // 0a9: goto 0ad
      // 0ac: athrow
      // 0ad: ldc2_w -178.5
      // 0b0: ldc2_w 178.5
      // 0b3: fload 2
      // 0b4: f2d
      // 0b5: iload 1
      // 0b6: ifne 0db
      // 0b9: goto 0bd
      // 0bc: athrow
      // 0bd: invokestatic x/oc7ab2161b9f.ʀ (DDD)Z
      // 0c0: ifeq 119
      // 0c3: goto 0c7
      // 0c6: athrow
      // 0c7: ldc2_w -1.5
      // 0ca: iload 1
      // 0cb: ifne 0e8
      // 0ce: goto 0d2
      // 0d1: athrow
      // 0d2: ldc2_w 1.5
      // 0d5: fload 2
      // 0d6: f2d
      // 0d7: goto 0db
      // 0da: athrow
      // 0db: invokestatic x/oc7ab2161b9f.ʀ (DDD)Z
      // 0de: ifne 119
      // 0e1: ldc2_w 88.5
      // 0e4: goto 0e8
      // 0e7: athrow
      // 0e8: ldc2_w 91.5
      // 0eb: iload 1
      // 0ec: ifne 105
      // 0ef: fload 2
      // 0f0: f2d
      // 0f1: invokestatic x/oc7ab2161b9f.ʀ (DDD)Z
      // 0f4: ifne 119
      // 0f7: goto 0fb
      // 0fa: athrow
      // 0fb: ldc2_w -91.5
      // 0fe: ldc2_w -88.5
      // 101: goto 105
      // 104: athrow
      // 105: fload 2
      // 106: f2d
      // 107: invokestatic x/oc7ab2161b9f.ʀ (DDD)Z
      // 10a: iload 1
      // 10b: ifne 116
      // 10e: ifne 119
      // 111: goto 115
      // 114: athrow
      // 115: bipush 1
      // 116: goto 11a
      // 119: bipush 0
      // 11a: istore 3
      // 11b: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 11e: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 121: getfield net/minecraft/client/settings/GameSettings.keyBindLeft Lnet/minecraft/client/settings/KeyBinding;
      // 124: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // 127: iload 1
      // 128: ifne 158
      // 12b: invokestatic org/lwjgl/input/Keyboard.isKeyDown (I)Z
      // 12e: goto 132
      // 131: athrow
      // 132: ifne 153
      // 135: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 138: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 13b: getfield net/minecraft/client/settings/GameSettings.keyBindRight Lnet/minecraft/client/settings/KeyBinding;
      // 13e: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // 141: iload 1
      // 142: ifne 158
      // 145: goto 149
      // 148: athrow
      // 149: invokestatic org/lwjgl/input/Keyboard.isKeyDown (I)Z
      // 14c: ifeq 15b
      // 14f: goto 153
      // 152: athrow
      // 153: bipush 1
      // 154: goto 158
      // 157: athrow
      // 158: goto 15c
      // 15b: bipush 0
      // 15c: istore 4
      // 15e: iload 3
      // 15f: iload 1
      // 160: ifne 17c
      // 163: ifne 17b
      // 166: goto 16a
      // 169: athrow
      // 16a: iload 4
      // 16c: iload 1
      // 16d: ifne 17c
      // 170: goto 174
      // 173: athrow
      // 174: ifeq 17f
      // 177: goto 17b
      // 17a: athrow
      // 17b: bipush 1
      // 17c: goto 180
      // 17f: bipush 0
      // 180: ireturn
   }

   public static double ǽ(Entity var0, int var1) {
      double var2 = var0.posX - var0.prevPosX;
      double var4 = var0.posZ - var0.prevPosZ;
      double var6 = Math.sqrt(var2 * var2 + var4 * var4) * 20.0;

      try {
         if (var1 == 0) {
            return var6;
         }
      } catch (ocbde1165e4e var8) {
         throw var8;
      }

      return ɜ(var6, var1);
   }

   public static boolean ʀ(double param0, double param2, double param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 6
      // 05: dload 4
      // 07: dload 0
      // 08: iload 6
      // 0a: ifne 1c
      // 0d: dcmpl
      // 0e: iflt 2d
      // 11: goto 15
      // 14: athrow
      // 15: dload 4
      // 17: dload 2
      // 18: goto 1c
      // 1b: athrow
      // 1c: dcmpg
      // 1d: iload 6
      // 1f: ifne 2a
      // 22: ifgt 2d
      // 25: goto 29
      // 28: athrow
      // 29: bipush 1
      // 2a: goto 2e
      // 2d: bipush 0
      // 2e: ireturn
   }

   public static String ǩ(String var0) {
      return var0.replace("§k", "").replace("§l", "").replace("§m", "").replace("§n", "").replace("§o", "").replace("§r", "");
   }

   public static boolean ó() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 0
      // 04: getstatic x/oc9755810e45.Ս Lx/oc5b049031ce;
      // 07: iload 0
      // 08: ifne 15
      // 0b: ifnull 29
      // 0e: goto 12
      // 11: athrow
      // 12: getstatic x/oc9755810e45.Ս Lx/oc5b049031ce;
      // 15: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 18: iload 0
      // 19: ifne 2c
      // 1c: ifeq 29
      // 1f: goto 23
      // 22: athrow
      // 23: bipush 0
      // 24: invokestatic org/lwjgl/input/Mouse.isButtonDown (I)Z
      // 27: ireturn
      // 28: athrow
      // 29: invokestatic x/oc8eb3e96b6e.Ȭ ()I
      // 2c: iload 0
      // 2d: ifne 4b
      // 30: bipush 1
      // 31: if_icmple 5a
      // 34: goto 38
      // 37: athrow
      // 38: invokestatic java/lang/System.currentTimeMillis ()J
      // 3b: getstatic x/oc8eb3e96b6e.ӛ J
      // 3e: lsub
      // 3f: ldc2_w -2527064911310422426
      // 42: ldc2_w -2527064911310422198
      // 45: lxor
      // 46: lcmp
      // 47: goto 4b
      // 4a: athrow
      // 4b: iload 0
      // 4c: ifne 57
      // 4f: ifge 5a
      // 52: goto 56
      // 55: athrow
      // 56: bipush 1
      // 57: goto 5b
      // 5a: bipush 0
      // 5b: ireturn
   }

   public static boolean Ħ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 06: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 09: getfield net/minecraft/client/settings/GameSettings.keyBindAttack Lnet/minecraft/client/settings/KeyBinding;
      // 0c: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // 0f: istore 1
      // 10: istore 0
      // 11: iload 1
      // 12: iload 0
      // 13: ifne 21
      // 16: ifne 20
      // 19: goto 1d
      // 1c: athrow
      // 1d: bipush 0
      // 1e: ireturn
      // 1f: athrow
      // 20: iload 1
      // 21: iload 0
      // 22: ifne 3d
      // 25: ifge 3c
      // 28: goto 2c
      // 2b: athrow
      // 2c: iload 1
      // 2d: ldc_w -717678278
      // 30: ldc_w -717678242
      // 33: ixor
      // 34: iadd
      // 35: invokestatic org/lwjgl/input/Mouse.isButtonDown (I)Z
      // 38: goto 40
      // 3b: athrow
      // 3c: iload 1
      // 3d: invokestatic org/lwjgl/input/Keyboard.isKeyDown (I)Z
      // 40: istore 2
      // 41: iload 2
      // 42: iload 0
      // 43: ifne 4e
      // 46: ifne 4f
      // 49: goto 4d
      // 4c: athrow
      // 4d: bipush 0
      // 4e: ireturn
      // 4f: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 52: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 55: invokevirtual net/minecraft/client/multiplayer/PlayerControllerMP.getBlockReachDistance ()F
      // 58: f2d
      // 59: dstore 3
      // 5a: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 5d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 60: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 63: fstore 5
      // 65: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 68: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 6b: getfield net/minecraft/client/entity/EntityPlayerSP.rotationPitch F
      // 6e: fstore 6
      // 70: dload 3
      // 71: fconst_1
      // 72: ldc_w -717678244
      // 75: ldc_w -717678242
      // 78: ixor
      // 79: newarray 6
      // 7b: dup
      // 7c: bipush 0
      // 7d: fload 5
      // 7f: fastore
      // 80: dup
      // 81: bipush 1
      // 82: fload 6
      // 84: fastore
      // 85: aconst_null
      // 86: invokestatic x/oc75d51ec7eb.Ƕ (DF[FLnet/minecraft/entity/EntityLivingBase;)Lnet/minecraft/util/MovingObjectPosition;
      // 89: astore 7
      // 8b: aload 7
      // 8d: iload 0
      // 8e: ifne ba
      // 91: ifnull b2
      // 94: goto 98
      // 97: athrow
      // 98: aload 7
      // 9a: iload 0
      // 9b: ifne ba
      // 9e: goto a2
      // a1: athrow
      // a2: getfield net/minecraft/util/MovingObjectPosition.typeOfHit Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // a5: getstatic net/minecraft/util/MovingObjectPosition$MovingObjectType.ENTITY Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // a8: if_acmpne b2
      // ab: goto af
      // ae: athrow
      // af: bipush 0
      // b0: ireturn
      // b1: athrow
      // b2: dload 3
      // b3: fload 5
      // b5: fload 6
      // b7: invokestatic x/oc75d51ec7eb.ѭ (DFF)Lnet/minecraft/util/MovingObjectPosition;
      // ba: astore 8
      // bc: aload 8
      // be: iload 0
      // bf: ifne cb
      // c2: ifnull ed
      // c5: goto c9
      // c8: athrow
      // c9: aload 8
      // cb: iload 0
      // cc: ifne e2
      // cf: getfield net/minecraft/util/MovingObjectPosition.typeOfHit Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // d2: getstatic net/minecraft/util/MovingObjectPosition$MovingObjectType.BLOCK Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // d5: if_acmpne ed
      // d8: goto dc
      // db: athrow
      // dc: aload 8
      // de: goto e2
      // e1: athrow
      // e2: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // e5: ifnull ed
      // e8: bipush 1
      // e9: goto ee
      // ec: athrow
      // ed: bipush 0
      // ee: ireturn
   }

   public static boolean Ͼ() {
      double var10002;
      double var10003;
      byte var10004;
      label16: {
            var10002 = ocda171fe5d8.ǔ.thePlayer.posX;
            var10003 = ocda171fe5d8.ǔ.thePlayer.posY;
            if (ocda171fe5d8.ǔ.thePlayer.posY % 1.0 == 0.0) {
               var10004 = 1;
               break label16;
            }
         var10004 = 0;
      }

      BlockPos var0 = new BlockPos(var10002, var10003 - var10004, 
ocda171fe5d8.ǔ.thePlayer.posZ
);
      return ocda171fe5d8.u.theWorld.isAirBlock(var0);
   }

   public static long Ҋ(long var0, long var2) {
      return Math.abs(var2 - var0);
   }

   public static void ԋ(oc69da1aa7f5 var0, String var1) {
      ȫ("&3" + var0.z$3i8m9vxwuvqj0() + "&7: &r" + var1);
   }

   public static EntityLivingBase Ð(int param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: aconst_null
      // 001: astore 2
      // 002: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 005: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 008: astore 3
      // 009: aload 3
      // 00a: iload 0
      // 00b: i2d
      // 00c: fconst_1
      // 00d: invokevirtual net/minecraft/entity/player/EntityPlayer.rayTrace (DF)Lnet/minecraft/util/MovingObjectPosition;
      // 010: astore 4
      // 012: aload 3
      // 013: fconst_1
      // 014: invokevirtual net/minecraft/entity/player/EntityPlayer.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 017: astore 5
      // 019: aload 3
      // 01a: getfield net/minecraft/entity/player/EntityPlayer.rotationYaw F
      // 01d: fstore 6
      // 01f: aload 3
      // 020: getfield net/minecraft/entity/player/EntityPlayer.rotationPitch F
      // 023: fstore 7
      // 025: getstatic x/oc75d51ec7eb.ϩ I
      // 028: fload 6
      // 02a: fneg
      // 02b: ldc_w 0.017453292
      // 02e: fmul
      // 02f: ldc 3.1415927
      // 031: fsub
      // 032: invokestatic net/minecraft/util/MathHelper.cos (F)F
      // 035: fstore 8
      // 037: fload 6
      // 039: fneg
      // 03a: ldc_w 0.017453292
      // 03d: fmul
      // 03e: ldc 3.1415927
      // 040: fsub
      // 041: invokestatic net/minecraft/util/MathHelper.sin (F)F
      // 044: fstore 9
      // 046: istore 1
      // 047: fload 7
      // 049: fneg
      // 04a: ldc_w 0.017453292
      // 04d: fmul
      // 04e: invokestatic net/minecraft/util/MathHelper.cos (F)F
      // 051: fneg
      // 052: fstore 10
      // 054: new net/minecraft/util/Vec3
      // 057: dup
      // 058: fload 9
      // 05a: fload 10
      // 05c: fmul
      // 05d: f2d
      // 05e: fload 7
      // 060: fneg
      // 061: ldc_w 0.017453292
      // 064: fmul
      // 065: invokestatic net/minecraft/util/MathHelper.sin (F)F
      // 068: f2d
      // 069: fload 8
      // 06b: fload 10
      // 06d: fmul
      // 06e: f2d
      // 06f: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 072: astore 11
      // 074: aload 5
      // 076: aload 11
      // 078: getfield net/minecraft/util/Vec3.xCoord D
      // 07b: iload 0
      // 07c: i2d
      // 07d: dmul
      // 07e: aload 11
      // 080: getfield net/minecraft/util/Vec3.yCoord D
      // 083: iload 0
      // 084: i2d
      // 085: dmul
      // 086: aload 11
      // 088: getfield net/minecraft/util/Vec3.zCoord D
      // 08b: iload 0
      // 08c: i2d
      // 08d: dmul
      // 08e: invokevirtual net/minecraft/util/Vec3.addVector (DDD)Lnet/minecraft/util/Vec3;
      // 091: astore 12
      // 093: aconst_null
      // 094: astore 13
      // 096: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 099: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 09c: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 09f: invokevirtual net/minecraft/client/Minecraft.getRenderViewEntity ()Lnet/minecraft/entity/Entity;
      // 0a2: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 0a5: invokevirtual net/minecraft/client/Minecraft.getRenderViewEntity ()Lnet/minecraft/entity/Entity;
      // 0a8: invokevirtual net/minecraft/entity/Entity.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 0ab: aload 11
      // 0ad: getfield net/minecraft/util/Vec3.xCoord D
      // 0b0: iload 0
      // 0b1: i2d
      // 0b2: dmul
      // 0b3: aload 11
      // 0b5: getfield net/minecraft/util/Vec3.yCoord D
      // 0b8: iload 0
      // 0b9: i2d
      // 0ba: dmul
      // 0bb: aload 11
      // 0bd: getfield net/minecraft/util/Vec3.zCoord D
      // 0c0: iload 0
      // 0c1: i2d
      // 0c2: dmul
      // 0c3: invokevirtual net/minecraft/util/AxisAlignedBB.addCoord (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 0c6: dconst_1
      // 0c7: dconst_1
      // 0c8: dconst_1
      // 0c9: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 0cc: invokevirtual net/minecraft/client/multiplayer/WorldClient.getEntitiesWithinAABBExcludingEntity (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/AxisAlignedBB;)Ljava/util/List;
      // 0cf: astore 14
      // 0d1: iload 0
      // 0d2: i2d
      // 0d3: dstore 15
      // 0d5: bipush 0
      // 0d6: istore 17
      // 0d8: iload 17
      // 0da: aload 14
      // 0dc: invokeinterface java/util/List.size ()I 1
      // 0e1: if_icmpge 20b
      // 0e4: iload 1
      // 0e5: ifne 238
      // 0e8: aload 14
      // 0ea: iload 17
      // 0ec: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 0f1: checkcast net/minecraft/entity/Entity
      // 0f4: astore 18
      // 0f6: iload 1
      // 0f7: ifne 207
      // 0fa: aload 18
      // 0fc: invokevirtual net/minecraft/entity/Entity.canBeCollidedWith ()Z
      // 0ff: ifeq 204
      // 102: goto 106
      // 105: athrow
      // 106: aload 18
      // 108: invokevirtual net/minecraft/entity/Entity.getCollisionBorderSize ()F
      // 10b: fstore 19
      // 10d: aload 18
      // 10f: invokevirtual net/minecraft/entity/Entity.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 112: fload 19
      // 114: f2d
      // 115: fload 19
      // 117: f2d
      // 118: fload 19
      // 11a: f2d
      // 11b: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 11e: astore 20
      // 120: aload 20
      // 122: aload 5
      // 124: aload 12
      // 126: invokevirtual net/minecraft/util/AxisAlignedBB.calculateIntercept (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/MovingObjectPosition;
      // 129: astore 21
      // 12b: aload 20
      // 12d: aload 5
      // 12f: invokevirtual net/minecraft/util/AxisAlignedBB.isVecInside (Lnet/minecraft/util/Vec3;)Z
      // 132: iload 1
      // 133: ifne 14d
      // 136: ifeq 17f
      // 139: goto 13d
      // 13c: athrow
      // 13d: dconst_0
      // 13e: dload 15
      // 140: iload 1
      // 141: ifne 157
      // 144: goto 148
      // 147: athrow
      // 148: dcmpg
      // 149: goto 14d
      // 14c: athrow
      // 14d: iflt 15b
      // 150: dload 15
      // 152: dconst_0
      // 153: goto 157
      // 156: athrow
      // 157: dcmpl
      // 158: ifne 204
      // 15b: aload 18
      // 15d: astore 2
      // 15e: aload 21
      // 160: iload 1
      // 161: ifne 173
      // 164: ifnonnull 171
      // 167: goto 16b
      // 16a: athrow
      // 16b: aload 5
      // 16d: goto 176
      // 170: athrow
      // 171: aload 21
      // 173: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 176: astore 13
      // 178: iload 1
      // 179: dconst_0
      // 17a: dstore 15
      // 17c: ifeq 204
      // 17f: aload 21
      // 181: ifnull 204
      // 184: goto 188
      // 187: athrow
      // 188: aload 5
      // 18a: aload 21
      // 18c: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 18f: invokevirtual net/minecraft/util/Vec3.distanceTo (Lnet/minecraft/util/Vec3;)D
      // 192: dstore 22
      // 194: dload 22
      // 196: dload 15
      // 198: iload 1
      // 199: ifne 1ab
      // 19c: dcmpg
      // 19d: iflt 1af
      // 1a0: goto 1a4
      // 1a3: athrow
      // 1a4: dload 15
      // 1a6: dconst_0
      // 1a7: goto 1ab
      // 1aa: athrow
      // 1ab: dcmpl
      // 1ac: ifne 204
      // 1af: aload 18
      // 1b1: iload 1
      // 1b2: ifne 1f8
      // 1b5: goto 1b9
      // 1b8: athrow
      // 1b9: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 1bc: invokevirtual net/minecraft/client/Minecraft.getRenderViewEntity ()Lnet/minecraft/entity/Entity;
      // 1bf: getfield net/minecraft/entity/Entity.ridingEntity Lnet/minecraft/entity/Entity;
      // 1c2: if_acmpne 1f6
      // 1c5: goto 1c9
      // 1c8: athrow
      // 1c9: aload 18
      // 1cb: iload 1
      // 1cc: ifne 1f8
      // 1cf: goto 1d3
      // 1d2: athrow
      // 1d3: invokevirtual net/minecraft/entity/Entity.canRiderInteract ()Z
      // 1d6: ifne 1f6
      // 1d9: goto 1dd
      // 1dc: athrow
      // 1dd: dload 15
      // 1df: dconst_0
      // 1e0: dcmpl
      // 1e1: ifne 204
      // 1e4: goto 1e8
      // 1e7: athrow
      // 1e8: aload 18
      // 1ea: astore 2
      // 1eb: iload 1
      // 1ec: aload 21
      // 1ee: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 1f1: astore 13
      // 1f3: ifeq 204
      // 1f6: aload 18
      // 1f8: astore 2
      // 1f9: aload 21
      // 1fb: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 1fe: astore 13
      // 200: dload 22
      // 202: dstore 15
      // 204: iinc 17 1
      // 207: iload 1
      // 208: ifeq 0d8
      // 20b: aload 2
      // 20c: ifnull 238
      // 20f: dload 15
      // 211: iload 0
      // 212: i2d
      // 213: dcmpg
      // 214: iflt 22c
      // 217: goto 21b
      // 21a: athrow
      // 21b: aload 4
      // 21d: iload 1
      // 21e: ifne 23a
      // 221: goto 225
      // 224: athrow
      // 225: ifnonnull 238
      // 228: goto 22c
      // 22b: athrow
      // 22c: new net/minecraft/util/MovingObjectPosition
      // 22f: dup
      // 230: aload 2
      // 231: aload 13
      // 233: invokespecial net/minecraft/util/MovingObjectPosition.<init> (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/Vec3;)V
      // 236: astore 4
      // 238: aload 4
      // 23a: iload 1
      // 23b: ifne 247
      // 23e: ifnull 27c
      // 241: goto 245
      // 244: athrow
      // 245: aload 4
      // 247: iload 1
      // 248: ifne 25e
      // 24b: getfield net/minecraft/util/MovingObjectPosition.typeOfHit Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 24e: getstatic net/minecraft/util/MovingObjectPosition$MovingObjectType.ENTITY Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 251: if_acmpne 27c
      // 254: goto 258
      // 257: athrow
      // 258: aload 4
      // 25a: goto 25e
      // 25d: athrow
      // 25e: iload 1
      // 25f: ifne 275
      // 262: getfield net/minecraft/util/MovingObjectPosition.entityHit Lnet/minecraft/entity/Entity;
      // 265: instanceof net/minecraft/entity/EntityLivingBase
      // 268: ifeq 27c
      // 26b: goto 26f
      // 26e: athrow
      // 26f: aload 4
      // 271: goto 275
      // 274: athrow
      // 275: getfield net/minecraft/util/MovingObjectPosition.entityHit Lnet/minecraft/entity/Entity;
      // 278: checkcast net/minecraft/entity/EntityLivingBase
      // 27b: areturn
      // 27c: aconst_null
      // 27d: areturn
   }

   public static int ƾ(long param0, long... param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 3
      // 04: invokestatic java/lang/System.currentTimeMillis ()J
      // 07: aload 2
      // 08: iload 3
      // 09: ifne 19
      // 0c: arraylength
      // 0d: ifle 1e
      // 10: goto 14
      // 13: athrow
      // 14: aload 2
      // 15: goto 19
      // 18: athrow
      // 19: bipush 0
      // 1a: laload
      // 1b: goto 1f
      // 1e: lconst_0
      // 1f: ladd
      // 20: lstore 4
      // 22: lload 4
      // 24: ldc2_w 4180571046660719950
      // 27: ldc2_w 4180571046660734934
      // 2a: lxor
      // 2b: lload 0
      // 2c: ldiv
      // 2d: lrem
      // 2e: l2f
      // 2f: ldc_w 15000.0
      // 32: lload 0
      // 33: l2f
      // 34: fdiv
      // 35: fdiv
      // 36: fconst_1
      // 37: fconst_1
      // 38: invokestatic java/awt/Color.getHSBColor (FFF)Ljava/awt/Color;
      // 3b: invokevirtual java/awt/Color.getRGB ()I
      // 3e: ireturn
   }

   public static double ɜ(double var0, int var2) {
      try {
         if (var2 == 0) {
            return Math.round(var0);
         }
      } catch (ocbde1165e4e var5) {
         throw var5;
      }

      double var3 = Math.pow(10.0, var2);
      return Math.round(var0 * var3) / var3;
   }

   public static String ћ(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokevirtual java/lang/String.isEmpty ()Z
      // 04: ifeq 0a
      // 07: aload 0
      // 08: areturn
      // 09: athrow
      // 0a: aload 0
      // 0b: invokestatic net/minecraft/util/StringUtils.stripControlCodes (Ljava/lang/String;)Ljava/lang/String;
      // 0e: invokevirtual java/lang/String.toCharArray ()[C
      // 11: astore 1
      // 12: new java/lang/StringBuilder
      // 15: dup
      // 16: invokespecial java/lang/StringBuilder.<init> ()V
      // 19: astore 2
      // 1a: aload 1
      // 1b: astore 3
      // 1c: aload 3
      // 1d: arraylength
      // 1e: istore 4
      // 20: bipush 0
      // 21: istore 5
      // 23: iload 5
      // 25: iload 4
      // 27: if_icmpge 5d
      // 2a: aload 3
      // 2b: iload 5
      // 2d: caload
      // 2e: istore 6
      // 30: iload 6
      // 32: ldc_w -426645588
      // 35: ldc_w -426645549
      // 38: ixor
      // 39: if_icmpge 57
      // 3c: iload 6
      // 3e: ldc_w -426645561
      // 41: ldc_w -426645549
      // 44: ixor
      // 45: if_icmple 57
      // 48: goto 4c
      // 4b: athrow
      // 4c: aload 2
      // 4d: iload 6
      // 4f: invokevirtual java/lang/StringBuilder.append (C)Ljava/lang/StringBuilder;
      // 52: pop
      // 53: goto 57
      // 56: athrow
      // 57: iinc 5 1
      // 5a: goto 23
      // 5d: aload 2
      // 5e: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 61: areturn
   }

   public static List<String> ð() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: new java/util/ArrayList
      // 006: dup
      // 007: invokespecial java/util/ArrayList.<init> ()V
      // 00a: astore 1
      // 00b: istore 0
      // 00c: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 00f: iload 0
      // 010: ifne 023
      // 013: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 016: ifnonnull 020
      // 019: goto 01d
      // 01c: athrow
      // 01d: aload 1
      // 01e: areturn
      // 01f: athrow
      // 020: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 023: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 026: invokevirtual net/minecraft/client/multiplayer/WorldClient.getScoreboard ()Lnet/minecraft/scoreboard/Scoreboard;
      // 029: astore 2
      // 02a: aload 2
      // 02b: iload 0
      // 02c: ifne 03a
      // 02f: ifnonnull 039
      // 032: goto 036
      // 035: athrow
      // 036: aload 1
      // 037: areturn
      // 038: athrow
      // 039: aload 2
      // 03a: bipush 1
      // 03b: invokevirtual net/minecraft/scoreboard/Scoreboard.getObjectiveInDisplaySlot (I)Lnet/minecraft/scoreboard/ScoreObjective;
      // 03e: astore 3
      // 03f: aload 3
      // 040: ifnonnull 046
      // 043: aload 1
      // 044: areturn
      // 045: athrow
      // 046: aload 2
      // 047: aload 3
      // 048: invokevirtual net/minecraft/scoreboard/Scoreboard.getSortedScores (Lnet/minecraft/scoreboard/ScoreObjective;)Ljava/util/Collection;
      // 04b: astore 4
      // 04d: new java/util/ArrayList
      // 050: dup
      // 051: invokespecial java/util/ArrayList.<init> ()V
      // 054: astore 5
      // 056: aload 4
      // 058: invokeinterface java/util/Collection.iterator ()Ljava/util/Iterator; 1
      // 05d: astore 6
      // 05f: aload 6
      // 061: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 066: ifeq 0be
      // 069: aload 6
      // 06b: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 070: checkcast net/minecraft/scoreboard/Score
      // 073: astore 7
      // 075: iload 0
      // 076: ifne 0f4
      // 079: aload 7
      // 07b: iload 0
      // 07c: ifne 08c
      // 07f: goto 083
      // 082: athrow
      // 083: ifnull 05f
      // 086: goto 08a
      // 089: athrow
      // 08a: aload 7
      // 08c: iload 0
      // 08d: ifne 09c
      // 090: invokevirtual net/minecraft/scoreboard/Score.getPlayerName ()Ljava/lang/String;
      // 093: ifnull 05f
      // 096: goto 09a
      // 099: athrow
      // 09a: aload 7
      // 09c: invokevirtual net/minecraft/scoreboard/Score.getPlayerName ()Ljava/lang/String;
      // 09f: ldc_w "#"
      // 0a2: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 0a5: iload 0
      // 0a6: ifne 0b9
      // 0a9: ifne 05f
      // 0ac: goto 0b0
      // 0af: athrow
      // 0b0: aload 5
      // 0b2: aload 7
      // 0b4: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 0b9: pop
      // 0ba: iload 0
      // 0bb: ifeq 05f
      // 0be: aload 5
      // 0c0: iload 0
      // 0c1: ifne 0f6
      // 0c4: invokeinterface java/util/List.size ()I 1
      // 0c9: ldc_w -1297097908
      // 0cc: ldc_w -1297097917
      // 0cf: ixor
      // 0d0: if_icmple 0f4
      // 0d3: goto 0d7
      // 0d6: athrow
      // 0d7: aload 5
      // 0d9: aload 4
      // 0db: invokeinterface java/util/Collection.size ()I 1
      // 0e0: ldc_w -1297097908
      // 0e3: ldc_w -1297097917
      // 0e6: ixor
      // 0e7: isub
      // 0e8: invokestatic com/google/common/collect/Iterables.skip (Ljava/lang/Iterable;I)Ljava/lang/Iterable;
      // 0eb: invokestatic com/google/common/collect/Lists.newArrayList (Ljava/lang/Iterable;)Ljava/util/ArrayList;
      // 0ee: astore 4
      // 0f0: iload 0
      // 0f1: ifeq 0f8
      // 0f4: aload 5
      // 0f6: astore 4
      // 0f8: aload 4
      // 0fa: invokeinterface java/util/Collection.iterator ()Ljava/util/Iterator; 1
      // 0ff: astore 6
      // 101: aload 6
      // 103: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 108: ifeq 13f
      // 10b: aload 6
      // 10d: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 112: checkcast net/minecraft/scoreboard/Score
      // 115: astore 7
      // 117: aload 2
      // 118: aload 7
      // 11a: invokevirtual net/minecraft/scoreboard/Score.getPlayerName ()Ljava/lang/String;
      // 11d: invokevirtual net/minecraft/scoreboard/Scoreboard.getPlayersTeam (Ljava/lang/String;)Lnet/minecraft/scoreboard/ScorePlayerTeam;
      // 120: astore 8
      // 122: aload 1
      // 123: iload 0
      // 124: ifne 140
      // 127: aload 8
      // 129: aload 7
      // 12b: invokevirtual net/minecraft/scoreboard/Score.getPlayerName ()Ljava/lang/String;
      // 12e: invokestatic net/minecraft/scoreboard/ScorePlayerTeam.formatPlayerName (Lnet/minecraft/scoreboard/Team;Ljava/lang/String;)Ljava/lang/String;
      // 131: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 136: pop
      // 137: iload 0
      // 138: ifeq 101
      // 13b: goto 13f
      // 13e: athrow
      // 13f: aload 1
      // 140: areturn
   }

   public static void ք() {
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
      // 07: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0a: getstatic net/minecraft/potion/Potion.digSpeed Lnet/minecraft/potion/Potion;
      // 0d: iload 0
      // 0e: ifne 41
      // 11: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isPotionActive (Lnet/minecraft/potion/Potion;)Z
      // 14: ifeq 38
      // 17: goto 1b
      // 1a: athrow
      // 1b: ldc_w -138816471
      // 1e: ldc_w -138816465
      // 21: ixor
      // 22: bipush 1
      // 23: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 26: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 29: getstatic net/minecraft/potion/Potion.digSpeed Lnet/minecraft/potion/Potion;
      // 2c: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getActivePotionEffect (Lnet/minecraft/potion/Potion;)Lnet/minecraft/potion/PotionEffect;
      // 2f: invokevirtual net/minecraft/potion/PotionEffect.getAmplifier ()I
      // 32: iadd
      // 33: isub
      // 34: goto 7e
      // 37: athrow
      // 38: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 3b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 3e: getstatic net/minecraft/potion/Potion.digSlowdown Lnet/minecraft/potion/Potion;
      // 41: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isPotionActive (Lnet/minecraft/potion/Potion;)Z
      // 44: iload 0
      // 45: ifne 74
      // 48: ifeq 77
      // 4b: goto 4f
      // 4e: athrow
      // 4f: ldc_w -138816471
      // 52: ldc_w -138816465
      // 55: ixor
      // 56: bipush 1
      // 57: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 5a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 5d: getstatic net/minecraft/potion/Potion.digSlowdown Lnet/minecraft/potion/Potion;
      // 60: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getActivePotionEffect (Lnet/minecraft/potion/Potion;)Lnet/minecraft/potion/PotionEffect;
      // 63: invokevirtual net/minecraft/potion/PotionEffect.getAmplifier ()I
      // 66: iadd
      // 67: ldc_w -138816467
      // 6a: ldc_w -138816465
      // 6d: ixor
      // 6e: imul
      // 6f: iadd
      // 70: goto 74
      // 73: athrow
      // 74: goto 7e
      // 77: ldc_w -138816471
      // 7a: ldc_w -138816465
      // 7d: ixor
      // 7e: istore 1
      // 7f: iload 0
      // 80: ifne da
      // 83: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 86: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 89: getfield net/minecraft/client/entity/EntityPlayerSP.isSwingInProgress Z
      // 8c: ifeq cc
      // 8f: goto 93
      // 92: athrow
      // 93: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 96: iload 0
      // 97: ifne dd
      // 9a: goto 9e
      // 9d: athrow
      // 9e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // a1: getfield net/minecraft/client/entity/EntityPlayerSP.swingProgressInt I
      // a4: iload 1
      // a5: ldc_w -138816467
      // a8: ldc_w -138816465
      // ab: ixor
      // ac: idiv
      // ad: if_icmpge cc
      // b0: goto b4
      // b3: athrow
      // b4: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // b7: iload 0
      // b8: ifne dd
      // bb: goto bf
      // be: athrow
      // bf: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // c2: getfield net/minecraft/client/entity/EntityPlayerSP.swingProgressInt I
      // c5: ifge e4
      // c8: goto cc
      // cb: athrow
      // cc: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // cf: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // d2: bipush -1
      // d3: putfield net/minecraft/client/entity/EntityPlayerSP.swingProgressInt I
      // d6: goto da
      // d9: athrow
      // da: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // dd: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // e0: bipush 1
      // e1: putfield net/minecraft/client/entity/EntityPlayerSP.isSwingInProgress Z
      // e4: return
   }

   public static String Ԃ(String var0) {
      return var0.substring(0, 1).toUpperCase() + var0.substring(1);
   }

   public static boolean ǆ(BlockPos param0) {
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
      // 05: invokestatic x/occb1ed1ed8f.ɍ (Lnet/minecraft/util/BlockPos;)Z
      // 08: iload 1
      // 09: ifne 2a
      // 0c: ifne 29
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: invokestatic x/occb1ed1ed8f.ϛ (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/Block;
      // 17: invokestatic x/occb1ed1ed8f.ѹ (Lnet/minecraft/block/Block;)Z
      // 1a: iload 1
      // 1b: ifne 2a
      // 1e: goto 22
      // 21: athrow
      // 22: ifeq 2d
      // 25: goto 29
      // 28: athrow
      // 29: bipush 1
      // 2a: goto 2e
      // 2d: bipush 0
      // 2e: ireturn
   }

   public static boolean Ľ() {
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
      // 08: ifne 50
      // 0b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0e: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 11: ldc_w -597223710
      // 14: ldc_w -597223702
      // 17: ixor
      // 18: invokevirtual net/minecraft/entity/player/InventoryPlayer.getStackInSlot (I)Lnet/minecraft/item/ItemStack;
      // 1b: ifnull 4d
      // 1e: goto 22
      // 21: athrow
      // 22: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 25: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 28: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 2b: ldc_w -597223710
      // 2e: ldc_w -597223702
      // 31: ixor
      // 32: invokevirtual net/minecraft/entity/player/InventoryPlayer.getStackInSlot (I)Lnet/minecraft/item/ItemStack;
      // 35: invokevirtual net/minecraft/item/ItemStack.getDisplayName ()Ljava/lang/String;
      // 38: ldc_w "Return"
      // 3b: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 3e: iload 0
      // 3f: ifne 6d
      // 42: goto 46
      // 45: athrow
      // 46: ifne 6c
      // 49: goto 4d
      // 4c: athrow
      // 4d: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 50: getfield net/minecraft/client/Minecraft.ingameGUI Lnet/minecraft/client/gui/GuiIngame;
      // 53: invokeinterface x/oc6e8b910f43.getDisplayedTitle ()Ljava/lang/String; 1
      // 58: invokestatic x/oc7ab2161b9f.ȑ (Ljava/lang/String;)Ljava/lang/String;
      // 5b: ldc_w "YOU DIED"
      // 5e: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 61: iload 0
      // 62: ifne 6d
      // 65: ifeq 70
      // 68: goto 6c
      // 6b: athrow
      // 6c: bipush 1
      // 6d: goto 71
      // 70: bipush 0
      // 71: ireturn
   }

   public static boolean Ȓ() {
      return ŭ(ocda171fe5d8.ǔ.thePlayer);
   }

   public static boolean ŭ(EntityLivingBase param0) {
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
      // 06: ifne 17
      // 09: invokevirtual net/minecraft/entity/EntityLivingBase.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 0c: ifnonnull 16
      // 0f: goto 13
      // 12: athrow
      // 13: bipush 0
      // 14: ireturn
      // 15: athrow
      // 16: aload 0
      // 17: invokevirtual net/minecraft/entity/EntityLivingBase.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 1a: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 1d: astore 2
      // 1e: aload 2
      // 1f: instanceof net/minecraft/item/ItemSword
      // 22: iload 1
      // 23: ifne 3d
      // 26: ifne 38
      // 29: goto 2d
      // 2c: athrow
      // 2d: aload 2
      // 2e: getstatic net/minecraft/init/Items.stick Lnet/minecraft/item/Item;
      // 31: if_acmpne 40
      // 34: goto 38
      // 37: athrow
      // 38: bipush 1
      // 39: goto 3d
      // 3c: athrow
      // 3d: goto 41
      // 40: bipush 0
      // 41: ireturn
   }

   public static boolean ө() {
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
      // 07: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0a: iload 0
      // 0b: ifne 21
      // 0e: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 11: ifnonnull 1b
      // 14: goto 18
      // 17: athrow
      // 18: bipush 0
      // 19: ireturn
      // 1a: athrow
      // 1b: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 1e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 21: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 24: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 27: instanceof net/minecraft/item/ItemSword
      // 2a: ireturn
   }

   public static double є(ItemStack var0) {
      return oc561cb941fa.Ƈ(var0);
   }

   public static float m() {
      return Ⱥ(ocda171fe5d8.ǔ.thePlayer.rotationYaw, ocda171fe5d8.ǔ.thePlayer.movementInput.moveForward, ocda171fe5d8.ǔ.thePlayer.movementInput.moveStrafe);
   }

   public static boolean ɷ() {
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
      // 07: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0a: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 0d: getfield net/minecraft/util/MovementInput.moveForward F
      // 10: fconst_0
      // 11: fcmpl
      // 12: iload 0
      // 13: ifne 3b
      // 16: ifne 3a
      // 19: goto 1d
      // 1c: athrow
      // 1d: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 20: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 23: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 26: getfield net/minecraft/util/MovementInput.moveStrafe F
      // 29: fconst_0
      // 2a: fcmpl
      // 2b: iload 0
      // 2c: ifne 3b
      // 2f: goto 33
      // 32: athrow
      // 33: ifeq 3e
      // 36: goto 3a
      // 39: athrow
      // 3a: bipush 1
      // 3b: goto 3f
      // 3e: bipush 0
      // 3f: ireturn
   }

   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static float Ⱥ(float var0, float var1, float var2) {
      float var4 = 1.0F;
      int var3 = oc75d51ec7eb.ϩ;

      float var10000;
      label92: {
         float var10001;
         label84: {
            label93: {
               label82: {
                  label94: {
                     try {
                        var10000 = var1;
                        var10001 = 0.0F;
                        if (var3 != 0) {
                           break label82;
                        }

                        if (!(var1 < 0.0F)) {
                           break label94;
                        }
                     } catch (ocbde1165e4e var12) {
                        throw var12;
                     }

                     var0 += 180.0F;
                     int var13 = var3;
                     var4 = -0.5F;

                     try {
                        if (var13 == 0) {
                           break label93;
                        }
                     } catch (ocbde1165e4e var11) {
                        throw var11;
                     }
                  }

                  try {
                     var10000 = var1;
                     var10001 = 0.0F;
                  } catch (ocbde1165e4e var6) {
                     throw var6;
                  }
               }

               try {
                  if (var3 != 0) {
                     break label84;
                  }

                  if (!(var10000 > var10001)) {
                     break label93;
                  }
               } catch (ocbde1165e4e var10) {
                  throw var10;
               }

               var4 = 0.5F;
            }

            try {
               var10000 = var2;
               if (var3 != 0) {
                  break label92;
               }

               var10001 = 0.0F;
            } catch (ocbde1165e4e var9) {
               throw var9;
            }
         }

         if (var10000 > var10001) {
            var0 -= 90.0F * var4;

            try {
               if (var3 == 0) {
                  return var0 * (float) (Math.PI / 180.0);
               }
            } catch (ocbde1165e4e var8) {
               throw var8;
            }
         }

         try {
            var10000 = var2;
         } catch (ocbde1165e4e var5) {
            throw var5;
         }
      }

      try {
         if (var3 != 0) {
            return var10000;
         }

         if (!(var10000 < 0.0F)) {
            return var0 * (float) (Math.PI / 180.0);
         }
      } catch (ocbde1165e4e var7) {
         throw var7;
      }

      var0 += 90.0F * var4;
      return var0 * (float) (Math.PI / 180.0);
   }

   public static boolean Ê(ItemBlock param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: aload 0
      // 004: invokevirtual net/minecraft/item/ItemBlock.getBlock ()Lnet/minecraft/block/Block;
      // 007: astore 2
      // 008: istore 1
      // 009: aload 2
      // 00a: iload 1
      // 00b: ifne 019
      // 00e: ifnonnull 018
      // 011: goto 015
      // 014: athrow
      // 015: bipush 0
      // 016: ireturn
      // 017: athrow
      // 018: aload 2
      // 019: invokestatic x/occb1ed1ed8f.ȼ (Lnet/minecraft/block/Block;)Z
      // 01c: iload 1
      // 01d: ifne 2c1
      // 020: ifne 2c0
      // 023: goto 027
      // 026: athrow
      // 027: aload 2
      // 028: instanceof net/minecraft/block/BlockSnow
      // 02b: iload 1
      // 02c: ifne 2c1
      // 02f: goto 033
      // 032: athrow
      // 033: ifne 2c0
      // 036: goto 03a
      // 039: athrow
      // 03a: aload 2
      // 03b: instanceof net/minecraft/block/BlockWeb
      // 03e: iload 1
      // 03f: ifne 2c1
      // 042: goto 046
      // 045: athrow
      // 046: ifne 2c0
      // 049: goto 04d
      // 04c: athrow
      // 04d: aload 2
      // 04e: instanceof net/minecraft/block/BlockSapling
      // 051: iload 1
      // 052: ifne 2c1
      // 055: goto 059
      // 058: athrow
      // 059: ifne 2c0
      // 05c: goto 060
      // 05f: athrow
      // 060: aload 2
      // 061: instanceof net/minecraft/block/BlockDaylightDetector
      // 064: iload 1
      // 065: ifne 2c1
      // 068: goto 06c
      // 06b: athrow
      // 06c: ifne 2c0
      // 06f: goto 073
      // 072: athrow
      // 073: aload 2
      // 074: instanceof net/minecraft/block/BlockBeacon
      // 077: iload 1
      // 078: ifne 2c1
      // 07b: goto 07f
      // 07e: athrow
      // 07f: ifne 2c0
      // 082: goto 086
      // 085: athrow
      // 086: aload 2
      // 087: instanceof net/minecraft/block/BlockBanner
      // 08a: iload 1
      // 08b: ifne 2c1
      // 08e: goto 092
      // 091: athrow
      // 092: ifne 2c0
      // 095: goto 099
      // 098: athrow
      // 099: aload 2
      // 09a: instanceof net/minecraft/block/BlockEndPortalFrame
      // 09d: iload 1
      // 09e: ifne 2c1
      // 0a1: goto 0a5
      // 0a4: athrow
      // 0a5: ifne 2c0
      // 0a8: goto 0ac
      // 0ab: athrow
      // 0ac: aload 2
      // 0ad: instanceof net/minecraft/block/BlockEndPortal
      // 0b0: iload 1
      // 0b1: ifne 2c1
      // 0b4: goto 0b8
      // 0b7: athrow
      // 0b8: ifne 2c0
      // 0bb: goto 0bf
      // 0be: athrow
      // 0bf: aload 2
      // 0c0: instanceof net/minecraft/block/BlockLever
      // 0c3: iload 1
      // 0c4: ifne 2c1
      // 0c7: goto 0cb
      // 0ca: athrow
      // 0cb: ifne 2c0
      // 0ce: goto 0d2
      // 0d1: athrow
      // 0d2: aload 2
      // 0d3: instanceof net/minecraft/block/BlockButton
      // 0d6: iload 1
      // 0d7: ifne 2c1
      // 0da: goto 0de
      // 0dd: athrow
      // 0de: ifne 2c0
      // 0e1: goto 0e5
      // 0e4: athrow
      // 0e5: aload 2
      // 0e6: instanceof net/minecraft/block/BlockSkull
      // 0e9: iload 1
      // 0ea: ifne 2c1
      // 0ed: goto 0f1
      // 0f0: athrow
      // 0f1: ifne 2c0
      // 0f4: goto 0f8
      // 0f7: athrow
      // 0f8: aload 2
      // 0f9: instanceof net/minecraft/block/BlockLiquid
      // 0fc: iload 1
      // 0fd: ifne 2c1
      // 100: goto 104
      // 103: athrow
      // 104: ifne 2c0
      // 107: goto 10b
      // 10a: athrow
      // 10b: aload 2
      // 10c: instanceof net/minecraft/block/BlockCactus
      // 10f: iload 1
      // 110: ifne 2c1
      // 113: goto 117
      // 116: athrow
      // 117: ifne 2c0
      // 11a: goto 11e
      // 11d: athrow
      // 11e: aload 2
      // 11f: instanceof net/minecraft/block/BlockDoublePlant
      // 122: iload 1
      // 123: ifne 2c1
      // 126: goto 12a
      // 129: athrow
      // 12a: ifne 2c0
      // 12d: goto 131
      // 130: athrow
      // 131: aload 2
      // 132: instanceof net/minecraft/block/BlockLilyPad
      // 135: iload 1
      // 136: ifne 2c1
      // 139: goto 13d
      // 13c: athrow
      // 13d: ifne 2c0
      // 140: goto 144
      // 143: athrow
      // 144: aload 2
      // 145: instanceof net/minecraft/block/BlockCarpet
      // 148: iload 1
      // 149: ifne 2c1
      // 14c: goto 150
      // 14f: athrow
      // 150: ifne 2c0
      // 153: goto 157
      // 156: athrow
      // 157: aload 2
      // 158: instanceof net/minecraft/block/BlockTripWire
      // 15b: iload 1
      // 15c: ifne 2c1
      // 15f: goto 163
      // 162: athrow
      // 163: ifne 2c0
      // 166: goto 16a
      // 169: athrow
      // 16a: aload 2
      // 16b: instanceof net/minecraft/block/BlockTripWireHook
      // 16e: iload 1
      // 16f: ifne 2c1
      // 172: goto 176
      // 175: athrow
      // 176: ifne 2c0
      // 179: goto 17d
      // 17c: athrow
      // 17d: aload 2
      // 17e: instanceof net/minecraft/block/BlockTallGrass
      // 181: iload 1
      // 182: ifne 2c1
      // 185: goto 189
      // 188: athrow
      // 189: ifne 2c0
      // 18c: goto 190
      // 18f: athrow
      // 190: aload 2
      // 191: instanceof net/minecraft/block/BlockFlower
      // 194: iload 1
      // 195: ifne 2c1
      // 198: goto 19c
      // 19b: athrow
      // 19c: ifne 2c0
      // 19f: goto 1a3
      // 1a2: athrow
      // 1a3: aload 2
      // 1a4: instanceof net/minecraft/block/BlockFlowerPot
      // 1a7: iload 1
      // 1a8: ifne 2c1
      // 1ab: goto 1af
      // 1ae: athrow
      // 1af: ifne 2c0
      // 1b2: goto 1b6
      // 1b5: athrow
      // 1b6: aload 2
      // 1b7: instanceof net/minecraft/block/BlockSign
      // 1ba: iload 1
      // 1bb: ifne 2c1
      // 1be: goto 1c2
      // 1c1: athrow
      // 1c2: ifne 2c0
      // 1c5: goto 1c9
      // 1c8: athrow
      // 1c9: aload 2
      // 1ca: instanceof net/minecraft/block/BlockLadder
      // 1cd: iload 1
      // 1ce: ifne 2c1
      // 1d1: goto 1d5
      // 1d4: athrow
      // 1d5: ifne 2c0
      // 1d8: goto 1dc
      // 1db: athrow
      // 1dc: aload 2
      // 1dd: instanceof net/minecraft/block/BlockTorch
      // 1e0: iload 1
      // 1e1: ifne 2c1
      // 1e4: goto 1e8
      // 1e7: athrow
      // 1e8: ifne 2c0
      // 1eb: goto 1ef
      // 1ee: athrow
      // 1ef: aload 2
      // 1f0: instanceof net/minecraft/block/BlockRedstoneTorch
      // 1f3: iload 1
      // 1f4: ifne 2c1
      // 1f7: goto 1fb
      // 1fa: athrow
      // 1fb: ifne 2c0
      // 1fe: goto 202
      // 201: athrow
      // 202: aload 2
      // 203: instanceof net/minecraft/block/BlockStairs
      // 206: iload 1
      // 207: ifne 2c1
      // 20a: goto 20e
      // 20d: athrow
      // 20e: ifne 2c0
      // 211: goto 215
      // 214: athrow
      // 215: aload 2
      // 216: instanceof net/minecraft/block/BlockSlab
      // 219: iload 1
      // 21a: ifne 2c1
      // 21d: goto 221
      // 220: athrow
      // 221: ifne 2c0
      // 224: goto 228
      // 227: athrow
      // 228: aload 2
      // 229: instanceof net/minecraft/block/BlockFence
      // 22c: iload 1
      // 22d: ifne 2c1
      // 230: goto 234
      // 233: athrow
      // 234: ifne 2c0
      // 237: goto 23b
      // 23a: athrow
      // 23b: aload 2
      // 23c: instanceof net/minecraft/block/BlockPane
      // 23f: iload 1
      // 240: ifne 2c1
      // 243: goto 247
      // 246: athrow
      // 247: ifne 2c0
      // 24a: goto 24e
      // 24d: athrow
      // 24e: aload 2
      // 24f: instanceof net/minecraft/block/BlockStainedGlassPane
      // 252: iload 1
      // 253: ifne 2c1
      // 256: goto 25a
      // 259: athrow
      // 25a: ifne 2c0
      // 25d: goto 261
      // 260: athrow
      // 261: aload 2
      // 262: instanceof net/minecraft/block/BlockGravel
      // 265: iload 1
      // 266: ifne 2c1
      // 269: goto 26d
      // 26c: athrow
      // 26d: ifne 2c0
      // 270: goto 274
      // 273: athrow
      // 274: aload 2
      // 275: instanceof net/minecraft/block/BlockClay
      // 278: iload 1
      // 279: ifne 2c1
      // 27c: goto 280
      // 27f: athrow
      // 280: ifne 2c0
      // 283: goto 287
      // 286: athrow
      // 287: aload 2
      // 288: instanceof net/minecraft/block/BlockSand
      // 28b: iload 1
      // 28c: ifne 2c1
      // 28f: goto 293
      // 292: athrow
      // 293: ifne 2c0
      // 296: goto 29a
      // 299: athrow
      // 29a: aload 2
      // 29b: instanceof net/minecraft/block/BlockSoulSand
      // 29e: iload 1
      // 29f: ifne 2c1
      // 2a2: goto 2a6
      // 2a5: athrow
      // 2a6: ifne 2c0
      // 2a9: goto 2ad
      // 2ac: athrow
      // 2ad: aload 2
      // 2ae: instanceof net/minecraft/block/BlockRailBase
      // 2b1: iload 1
      // 2b2: ifne 2c3
      // 2b5: goto 2b9
      // 2b8: athrow
      // 2b9: ifeq 2c2
      // 2bc: goto 2c0
      // 2bf: athrow
      // 2c0: bipush 0
      // 2c1: ireturn
      // 2c2: bipush 1
      // 2c3: ireturn
   }

   public static <E extends Enum<E>> E Ġ(Class<E> param0, String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokevirtual java/lang/Class.getEnumConstants ()[Ljava/lang/Object;
      // 04: checkcast [Ljava/lang/Enum;
      // 07: astore 3
      // 08: aload 3
      // 09: arraylength
      // 0a: istore 4
      // 0c: getstatic x/oc75d51ec7eb.ϩ I
      // 0f: bipush 0
      // 10: istore 5
      // 12: istore 2
      // 13: iload 5
      // 15: iload 4
      // 17: if_icmpge 3f
      // 1a: aload 3
      // 1b: iload 5
      // 1d: aaload
      // 1e: astore 6
      // 20: iload 2
      // 21: ifne 3b
      // 24: aload 6
      // 26: invokevirtual java/lang/Enum.name ()Ljava/lang/String;
      // 29: aload 1
      // 2a: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 2d: ifeq 38
      // 30: goto 34
      // 33: athrow
      // 34: aload 6
      // 36: areturn
      // 37: athrow
      // 38: iinc 5 1
      // 3b: iload 2
      // 3c: ifeq 13
      // 3f: aconst_null
      // 40: areturn
   }

   public static int stateI() {
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
      // 07: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0a: getstatic net/minecraft/potion/Potion.moveSpeed Lnet/minecraft/potion/Potion;
      // 0d: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isPotionActive (Lnet/minecraft/potion/Potion;)Z
      // 10: iload 0
      // 11: ifne 2f
      // 14: ifeq 2e
      // 17: goto 1b
      // 1a: athrow
      // 1b: bipush 1
      // 1c: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 1f: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 22: getstatic net/minecraft/potion/Potion.moveSpeed Lnet/minecraft/potion/Potion;
      // 25: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getActivePotionEffect (Lnet/minecraft/potion/Potion;)Lnet/minecraft/potion/PotionEffect;
      // 28: invokevirtual net/minecraft/potion/PotionEffect.getAmplifier ()I
      // 2b: iadd
      // 2c: ireturn
      // 2d: athrow
      // 2e: bipush 0
      // 2f: ireturn
   }

   public static ItemStack Ϟ(ItemStack param0) {
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
      // 0a: ifnull 36
      // 0d: getstatic x/oc718fd4d503.Ō Lx/oc718fd4d503;
      // 10: iload 1
      // 11: ifne 29
      // 14: goto 18
      // 17: athrow
      // 18: invokevirtual x/oc718fd4d503.ȿ ()Z
      // 1b: ifeq 36
      // 1e: goto 22
      // 21: athrow
      // 22: getstatic x/oc718fd4d503.Ō Lx/oc718fd4d503;
      // 25: goto 29
      // 28: athrow
      // 29: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 2c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 2f: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 32: invokevirtual x/oc718fd4d503.е (Lnet/minecraft/entity/player/InventoryPlayer;)Lnet/minecraft/item/ItemStack;
      // 35: areturn
      // 36: aload 0
      // 37: areturn
   }

   public static String ǚ(InputStream var0) {
      StringBuilder var1 = new StringBuilder();

      try {
         BufferedReader var2 = new BufferedReader(new InputStreamReader(var0));

         while (true) {
            String var3;
            String var10000 = var3 = var2.readLine();

            try {
               if (var10000 == null) {
                  break;
               }

               var1.append(var3).append((char)(-515690986 ^ -515690980));
            } catch (Exception var4) {
               throw var4;
            }
         }
      } catch (Exception var5) {
         var5.printStackTrace();
      }

      return var1.toString();
   }

   public static boolean ս() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 0
      // 04: invokestatic x/oc7ab2161b9f.Տ ()Z
      // 07: iload 0
      // 08: ifne 6a
      // 0b: ifeq 69
      // 0e: goto 12
      // 11: athrow
      // 12: invokestatic x/oc7ab2161b9f.հ ()Ljava/util/List;
      // 15: astore 1
      // 16: aload 1
      // 17: invokeinterface java/util/List.isEmpty ()Z 1
      // 1c: iload 0
      // 1d: ifne 6a
      // 20: ifne 69
      // 23: goto 27
      // 26: athrow
      // 27: aload 1
      // 28: bipush 1
      // 29: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 2e: checkcast java/lang/String
      // 31: invokestatic x/oc7ab2161b9f.ћ (Ljava/lang/String;)Ljava/lang/String;
      // 34: ldc_w "  "
      // 37: invokevirtual java/lang/String.split (Ljava/lang/String;)[Ljava/lang/String;
      // 3a: astore 2
      // 3b: aload 2
      // 3c: arraylength
      // 3d: iload 0
      // 3e: ifne 6a
      // 41: bipush 1
      // 42: if_icmple 69
      // 45: goto 49
      // 48: athrow
      // 49: aload 2
      // 4a: bipush 1
      // 4b: aaload
      // 4c: bipush 0
      // 4d: invokevirtual java/lang/String.charAt (I)C
      // 50: iload 0
      // 51: ifne 6a
      // 54: goto 58
      // 57: athrow
      // 58: ldc_w 1597959768
      // 5b: ldc_w 1597959700
      // 5e: ixor
      // 5f: if_icmpne 69
      // 62: goto 66
      // 65: athrow
      // 66: bipush 1
      // 67: ireturn
      // 68: athrow
      // 69: bipush 0
      // 6a: ireturn
   }

   public static boolean Գ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 0
      // 04: invokestatic x/oc7ab2161b9f.Տ ()Z
      // 07: iload 0
      // 08: ifne 89
      // 0b: ifeq 88
      // 0e: goto 12
      // 11: athrow
      // 12: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 15: iload 0
      // 16: ifne 25
      // 19: goto 1d
      // 1c: athrow
      // 1d: ifne 26
      // 20: goto 24
      // 23: athrow
      // 24: bipush 0
      // 25: ireturn
      // 26: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 29: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 2c: invokevirtual net/minecraft/client/multiplayer/WorldClient.getScoreboard ()Lnet/minecraft/scoreboard/Scoreboard;
      // 2f: astore 1
      // 30: aload 1
      // 31: iload 0
      // 32: ifne 40
      // 35: ifnonnull 3f
      // 38: goto 3c
      // 3b: athrow
      // 3c: bipush 0
      // 3d: ireturn
      // 3e: athrow
      // 3f: aload 1
      // 40: bipush 1
      // 41: invokevirtual net/minecraft/scoreboard/Scoreboard.getObjectiveInDisplaySlot (I)Lnet/minecraft/scoreboard/ScoreObjective;
      // 44: astore 2
      // 45: aload 2
      // 46: iload 0
      // 47: ifne 55
      // 4a: ifnonnull 54
      // 4d: goto 51
      // 50: athrow
      // 51: bipush 0
      // 52: ireturn
      // 53: athrow
      // 54: aload 2
      // 55: invokevirtual net/minecraft/scoreboard/ScoreObjective.getDisplayName ()Ljava/lang/String;
      // 58: invokestatic x/oc7ab2161b9f.ȑ (Ljava/lang/String;)Ljava/lang/String;
      // 5b: astore 3
      // 5c: aload 3
      // 5d: ldc_w "BED WARS PRACTICE"
      // 60: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 63: iload 0
      // 64: ifne 85
      // 67: ifne 84
      // 6a: goto 6e
      // 6d: athrow
      // 6e: aload 3
      // 6f: ldc_w "REPLAY"
      // 72: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 75: iload 0
      // 76: ifne 87
      // 79: goto 7d
      // 7c: athrow
      // 7d: ifeq 86
      // 80: goto 84
      // 83: athrow
      // 84: bipush 1
      // 85: ireturn
      // 86: bipush 0
      // 87: ireturn
      // 88: bipush 0
      // 89: ireturn
   }

   public static Vec3 Ϻ(double param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 2
      // 04: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 07: iload 2
      // 08: ifne 1c
      // 0b: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 0e: ifnull 22
      // 11: goto 15
      // 14: athrow
      // 15: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 18: goto 1c
      // 1b: athrow
      // 1c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1f: ifnonnull 25
      // 22: aconst_null
      // 23: areturn
      // 24: athrow
      // 25: aconst_null
      // 26: astore 3
      // 27: dload 0
      // 28: dstore 4
      // 2a: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 2d: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 30: getfield net/minecraft/client/multiplayer/WorldClient.playerEntities Ljava/util/List;
      // 33: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 38: astore 6
      // 3a: aload 6
      // 3c: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 41: ifeq fe
      // 44: aload 6
      // 46: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 4b: checkcast net/minecraft/entity/player/EntityPlayer
      // 4e: astore 7
      // 50: aload 7
      // 52: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 55: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 58: if_acmpne 5f
      // 5b: goto 3a
      // 5e: athrow
      // 5f: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 62: iload 2
      // 63: ifne 73
      // 66: invokevirtual net/minecraft/client/Minecraft.getNetHandler ()Lnet/minecraft/client/network/NetHandlerPlayClient;
      // 69: ifnull 3a
      // 6c: goto 70
      // 6f: athrow
      // 70: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 73: invokevirtual net/minecraft/client/Minecraft.getNetHandler ()Lnet/minecraft/client/network/NetHandlerPlayClient;
      // 76: aload 7
      // 78: invokevirtual net/minecraft/entity/player/EntityPlayer.getUniqueID ()Ljava/util/UUID;
      // 7b: invokevirtual net/minecraft/client/network/NetHandlerPlayClient.getPlayerInfo (Ljava/util/UUID;)Lnet/minecraft/client/network/NetworkPlayerInfo;
      // 7e: ifnonnull 89
      // 81: iload 2
      // 82: ifeq 3a
      // 85: goto 89
      // 88: athrow
      // 89: aload 7
      // 8b: getfield net/minecraft/entity/player/EntityPlayer.posX D
      // 8e: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 91: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 94: getfield net/minecraft/client/entity/EntityPlayerSP.posX D
      // 97: dsub
      // 98: dstore 8
      // 9a: iload 2
      // 9b: aload 7
      // 9d: getfield net/minecraft/entity/player/EntityPlayer.posY D
      // a0: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // a3: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // a6: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // a9: dsub
      // aa: dstore 10
      // ac: aload 7
      // ae: getfield net/minecraft/entity/player/EntityPlayer.posZ D
      // b1: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // b4: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // b7: getfield net/minecraft/client/entity/EntityPlayerSP.posZ D
      // ba: dsub
      // bb: dstore 12
      // bd: dload 8
      // bf: dload 8
      // c1: dmul
      // c2: dload 10
      // c4: dload 10
      // c6: dmul
      // c7: dadd
      // c8: dload 12
      // ca: dload 12
      // cc: dmul
      // cd: dadd
      // ce: dstore 14
      // d0: ifne e3
      // d3: dload 14
      // d5: dload 4
      // d7: dcmpg
      // d8: ifge fa
      // db: goto df
      // de: athrow
      // df: dload 14
      // e1: dstore 4
      // e3: new net/minecraft/util/Vec3
      // e6: dup
      // e7: aload 7
      // e9: getfield net/minecraft/entity/player/EntityPlayer.posX D
      // ec: aload 7
      // ee: getfield net/minecraft/entity/player/EntityPlayer.posY D
      // f1: aload 7
      // f3: getfield net/minecraft/entity/player/EntityPlayer.posZ D
      // f6: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // f9: astore 3
      // fa: iload 2
      // fb: ifeq 3a
      // fe: aload 3
      // ff: areturn
   }
}

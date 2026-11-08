package x;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C0APacketAnimation;
import net.minecraft.network.play.client.C07PacketPlayerDigging.Action;
import net.minecraft.network.play.server.S2FPacketSetSlot;
import net.minecraft.network.play.server.S30PacketWindowItems;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;

public class ocdd342096f8 extends oc69da1aa7f5 {
   public static ocdd342096f8 Ɯ;
   public static oca9cc61aada պ;
   public static oca9cc61aada Ț;
   public static oca9cc61aada ы;
   public static oca9cc61aada ř;
   public static oca9cc61aada ѵ;
   public static oca9cc61aada Ɩ;
   public static oca9cc61aada Ƒ;
   public static oca9cc61aada Ǒ;
   public static oca9cc61aada A;
   public static oca9cc61aada ӷ;
   public static ocf1568fef75 ʄ;
   public static occc831eff22 л;
   public static occ2f8dff8d8 λ;
   public static occ2f8dff8d8 ʎ;
   public static occ2f8dff8d8 Ü;
   public static occ2f8dff8d8 Ѱ;
   public static occ2f8dff8d8 ҵ;
   public static occ2f8dff8d8 Ӹ;
   public static occ2f8dff8d8 ʤ;
   public static oc8df2d0340c ș = oc8df2d0340c.Ѐ;
   public static oc12021474b0 Ӣ = oc12021474b0.ǯ;
   public static oca547efbd9f Ž = oca547efbd9f.ӓ;
   private static oc59dbd08e27 ĕ;
   public static EntityLivingBase f;
   public static EntityLivingBase ѐ;
   public static List<EntityLivingBase> Ց = Collections.emptyList();
   public final oca9cc61aada ʰ;
   private static oc59dbd08e27 ʭ;
   public static boolean Ԣ;
   public static boolean Ł;
   public static boolean ն;
   public static boolean Ŧ = true;
   public static int Г = -1;
   public static double Ա;
   public static double Ҙ;
   public static double ӣ;
   public static double Ή;
   public static double Θ;
   private static double ɜ;
   private static double ǧ;
   private static final int ı = 3;
   private static final long Ҡ = 150L;
   private static final oc932bfa839d դ = new oc932bfa839d();
   private static long ǿ;
   private static boolean ɉ;
   private static int Ư;
   private static int ҁ;
   private static boolean į;
   private static float[] Ë;
   private static boolean ž;
   private static float g;
   private static float վ;
   private static Vec3 Ʉ;
   private static final HashMap<Integer, Vec3> ǉ = new HashMap<>();
   private static final HashMap<UUID, Long> Ě = new HashMap<>();
   private static final List<Packet<?>> Ғ = Collections.synchronizedList(new ArrayList<>());
   private static boolean Ԉ;
   private static int Σ;
   private static boolean ă;
   public static boolean ư;
   private static boolean ϟ;
   private static boolean Վ;
   private static boolean C;
   private static long Ų;
   private static int ʪ;
   public static boolean Ō;
   public static int Ć;

   public ocdd342096f8() {
      super("KillAura", oce4cea752dd.ȁ);
      Ɯ = this;
      this.ą("Automatically attacks and blocks against nearby targets.");
      String[] var10005 = new String[-1944291325 ^ -1944291328];
      var10005[0] = "Silent";
      var10005[1] = "Lock view";
      var10005[-1944291326 ^ -1944291328] = "None";
      this.ʌ(Ǒ = new oca9cc61aada("Rotation mode", 0, var10005));
      String[] var10009 = new String[-1944291326 ^ -1944291328];
      var10009[0] = "Rotation smoothing";
      var10009[1] = "Rotation Smoothing";
      this.ʌ(A = new oca9cc61aada("Smoothing", "", 0.0, 0.0, 8.0, 0.1, var10009));
      A.Ǧ("§cDisabled");
      this.ʌ(պ = new oca9cc61aada("APS", 12.0, 1.0, 20.0, 0.5));
      this.ʌ(ѵ = new oca9cc61aada("Attack Range", "", 3.0, 3.0, 10.0, 0.1, "Range (attack)"));
      this.ʌ(Ɩ = new oca9cc61aada("Swing Range", "", 4.0, 3.0, 10.0, 0.1, "Range (swing)"));
      this.ʌ(ř = new oca9cc61aada("FOV", 360.0, 20.0, 360.0, 5.0));
      String[] var10006 = new String[-1944291323 ^ -1944291328];
      var10006[0] = "None";
      var10006[1] = "Vanilla";
      var10006[-1944291326 ^ -1944291328] = "Damage";
      var10006[-1944291325 ^ -1944291328] = "Fake";
      var10006[-1944291324 ^ -1944291328] = "Legit";
      this.ʌ(Ț = new oc04126f76c9(this, "AutoBlock", 0, var10006));
      this.ʌ(ы = new oca9cc61aada("AutoBlock lag", "%", "§cDisabled", 100.0, 0.0, 100.0, 2.0));
      this.ʌ(Ƒ = new oca9cc61aada("AutoBlock Range", "", 6.0, 3.0, 10.0, 0.1, "Range (block)"));
      this.ʌ(ʄ = new ocf1568fef75("AutoBlock Min/Max", " APS", 1.0, 20.0, 10.0, 10.0, 0.5, "AutoBlock APS"));
      this.ʌ(Ӹ = new occ2f8dff8d8("Require RightHold", true, new String[]{"Manual block"}));
      var10005 = new String[-1944291324 ^ -1944291328];
      var10005[0] = "Distance";
      var10005[1] = "Health";
      var10005[-1944291326 ^ -1944291328] = "Hurt time";
      var10005[-1944291325 ^ -1944291328] = "Yaw";
      this.ʌ(ӷ = new oca9cc61aada("Sort", 0, var10005, "Sort mode"));
      this.ʌ(л = new occc831eff22("Targets"));
      this.ʌ(Ü = new occ2f8dff8d8(л, "Players", true, new String[]{"Attack players"}));
      this.ʌ(ʎ = new occ2f8dff8d8(л, "Mobs", true, new String[]{"Attack mobs"}));
      occc831eff22 var10003 = л;
      var10006 = new String[-1944291324 ^ -1944291328];
      var10006[0] = "Aim invis";
      var10006[1] = "Invisibles";
      var10006[-1944291326 ^ -1944291328] = "Targets.Invisibles";
      var10006[-1944291325 ^ -1944291328] = "Target invis";
      this.ʌ(λ = new occ2f8dff8d8(var10003, "Attack Invisible", false, var10006));
      this.ʌ(ҵ = new occ2f8dff8d8(л, "Ignore teammates", true));
      this.ʌ(Ѱ = new occ2f8dff8d8("Hit Through Block", false, new String[]{"Hit through blocks"}));
      this.ʌ(ʤ = new occ2f8dff8d8("Weapon Only", true, new String[]{"Weapon only"}));
      this.ʰ = Ǒ;
      this.z$2u87utkr1isxg();
   }

   private static Minecraft Ȭ() {
      return Minecraft.getMinecraft();
   }

   public EntityLivingBase ɱ() {
      return f;
   }

   public Entity Ǒ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 1
      // 04: getstatic x/ocdd342096f8.ĕ Lx/oc59dbd08e27;
      // 07: iload 1
      // 08: ifne 1a
      // 0b: ifnonnull 17
      // 0e: goto 12
      // 11: athrow
      // 12: aconst_null
      // 13: goto 1d
      // 16: athrow
      // 17: getstatic x/ocdd342096f8.ĕ Lx/oc59dbd08e27;
      // 1a: getfield x/oc59dbd08e27.Ԍ Lnet/minecraft/entity/Entity;
      // 1d: areturn
   }

   public boolean ъ() {
      int var1 = oc5e549848f3.İ;

      boolean var10000;
      label33: {
         try {
            var10000 = this.z$3rzb3dil7uydr();
            if (var1 != 0) {
               break label33;
            }

            if (!var10000) {
               return false;
            }
         } catch (ocbde1165e4e var3) {
            throw var3;
         }

         var10000 = Ԣ;
      }

      try {
         if (var1 != 0) {
            return var10000;
         }

         if (var10000) {
            return true;
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }

      return false;
   }

   public float[] З(float var1, float var2) {
      try {
         if (Ӣ == oc12021474b0.Ӝ) {
            return null;
         }
      } catch (ocbde1165e4e var3) {
         throw var3;
      }

      return Ը();
   }

   public static boolean ѵ() {
      return ƚ(ĕ);
   }

   private static boolean ƚ(oc59dbd08e27 var0) {
      int var1 = oc5e549848f3.İ;
      int var2 = 212693837 ^ -1265270654;

      while (true) {
         switch (var2) {
            case 1080463079:
               int var10000;
               label34: {
                  label33: {
                     try {
                        var10000 = var0.Ɠ();
                        if (var1 != 0) {
                           break label34;
                        }

                        if (var10000 == 0) {
                           break label33;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = -215419041 ^ -1265270654;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = -80630691 ^ -1265270654;
               }

               var2 = var10000;
               if (var1 == 0) {
                  break;
               }
            case -1204227121:
               if (var0 != null) {
                  var2 = -185397659 ^ -1265270654;
                  if (var1 == 0) {
                     break;
                  }
               }

               var2 = -80630691 ^ -1265270654;
               break;
            case 1203599325:
               return true;
            case 1336159455:
               return false;
            default:
               throw null;
         }
      }
   }

   private static boolean Ά() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: getstatic x/oc5e549848f3.İ I
      // 003: invokestatic x/ocdd342096f8.Ȭ ()Lnet/minecraft/client/Minecraft;
      // 006: astore 1
      // 007: istore 0
      // 008: getstatic x/ocdd342096f8.A Lx/oca9cc61aada;
      // 00b: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 00e: getstatic x/ocdd342096f8.A Lx/oca9cc61aada;
      // 011: invokevirtual x/oca9cc61aada.ԕ ()D
      // 014: dcmpl
      // 015: iload 0
      // 016: ifne 1c8
      // 019: ifeq 1c7
      // 01c: goto 020
      // 01f: athrow
      // 020: aload 1
      // 021: iload 0
      // 022: ifne 038
      // 025: goto 029
      // 028: athrow
      // 029: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 02c: ifnull 044
      // 02f: goto 033
      // 032: athrow
      // 033: aload 1
      // 034: goto 038
      // 037: athrow
      // 038: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 03b: getfield net/minecraft/util/MovingObjectPosition.typeOfHit Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 03e: getstatic net/minecraft/util/MovingObjectPosition$MovingObjectType.MISS Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 041: if_acmpne 1c7
      // 044: invokestatic x/oc7c017b256e.Ͱ ()Z
      // 047: iload 0
      // 048: ifne 1c8
      // 04b: goto 04f
      // 04e: athrow
      // 04f: ifne 1c7
      // 052: goto 056
      // 055: athrow
      // 056: invokestatic x/oc7c017b256e.ę ()Z
      // 059: iload 0
      // 05a: ifne 1c8
      // 05d: goto 061
      // 060: athrow
      // 061: ifne 1c7
      // 064: goto 068
      // 067: athrow
      // 068: invokestatic x/oc7c017b256e.Հ ()Z
      // 06b: iload 0
      // 06c: ifne 1c8
      // 06f: goto 073
      // 072: athrow
      // 073: ifne 1c7
      // 076: goto 07a
      // 079: athrow
      // 07a: aload 1
      // 07b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 07e: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 081: astore 2
      // 082: aload 2
      // 083: iload 0
      // 084: ifne 094
      // 087: ifnonnull 093
      // 08a: goto 08e
      // 08d: athrow
      // 08e: aconst_null
      // 08f: goto 097
      // 092: athrow
      // 093: aload 2
      // 094: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 097: astore 3
      // 098: aload 3
      // 099: iload 0
      // 09a: ifne 0a5
      // 09d: ifnull 0d2
      // 0a0: goto 0a4
      // 0a3: athrow
      // 0a4: aload 3
      // 0a5: iload 0
      // 0a6: ifne 0b8
      // 0a9: getstatic net/minecraft/init/Items.fishing_rod Lnet/minecraft/item/ItemFishingRod;
      // 0ac: if_acmpeq 0be
      // 0af: goto 0b3
      // 0b2: athrow
      // 0b3: aload 3
      // 0b4: goto 0b8
      // 0b7: athrow
      // 0b8: getstatic net/minecraft/init/Items.bow Lnet/minecraft/item/ItemBow;
      // 0bb: if_acmpne 0c1
      // 0be: bipush 0
      // 0bf: ireturn
      // 0c0: athrow
      // 0c1: aload 2
      // 0c2: invokestatic x/oc7c017b256e.ö (Lnet/minecraft/item/ItemStack;)Z
      // 0c5: iload 0
      // 0c6: ifne 0d1
      // 0c9: ifeq 0d2
      // 0cc: goto 0d0
      // 0cf: athrow
      // 0d0: bipush 0
      // 0d1: ireturn
      // 0d2: getstatic x/oc75d51ec7eb.d [F
      // 0d5: bipush 0
      // 0d6: faload
      // 0d7: fstore 4
      // 0d9: getstatic x/oc75d51ec7eb.d [F
      // 0dc: bipush 1
      // 0dd: faload
      // 0de: fstore 5
      // 0e0: aload 1
      // 0e1: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0e4: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 0e7: fstore 6
      // 0e9: aload 1
      // 0ea: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0ed: getfield net/minecraft/client/entity/EntityPlayerSP.rotationPitch F
      // 0f0: fstore 7
      // 0f2: fload 6
      // 0f4: getstatic x/ocdd342096f8.g F
      // 0f7: fsub
      // 0f8: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_float (F)F
      // 0fb: invokestatic java/lang/Math.abs (F)F
      // 0fe: fstore 8
      // 100: fload 7
      // 102: getstatic x/ocdd342096f8.վ F
      // 105: fsub
      // 106: invokestatic java/lang/Math.abs (F)F
      // 109: fstore 9
      // 10b: fload 6
      // 10d: putstatic x/ocdd342096f8.g F
      // 110: fload 7
      // 112: putstatic x/ocdd342096f8.վ F
      // 115: fload 8
      // 117: ldc_w 20.0
      // 11a: fcmpl
      // 11b: iload 0
      // 11c: ifne 140
      // 11f: ifgt 13b
      // 122: goto 126
      // 125: athrow
      // 126: fload 9
      // 128: ldc_w 8.0
      // 12b: iload 0
      // 12c: ifne 182
      // 12f: goto 133
      // 132: athrow
      // 133: fcmpl
      // 134: ifle 141
      // 137: goto 13b
      // 13a: athrow
      // 13b: bipush 0
      // 13c: goto 140
      // 13f: athrow
      // 140: ireturn
      // 141: ldc_w -1994165149
      // 144: ldc_w -1994165151
      // 147: ixor
      // 148: iload 0
      // 149: ifne 1aa
      // 14c: newarray 6
      // 14e: dup
      // 14f: bipush 0
      // 150: fload 6
      // 152: fastore
      // 153: dup
      // 154: bipush 1
      // 155: fload 7
      // 157: fastore
      // 158: putstatic x/ocdd342096f8.Ë [F
      // 15b: getstatic x/ocdd342096f8.Ë [F
      // 15e: fload 4
      // 160: fload 5
      // 162: ldc_w 1.5
      // 165: invokestatic x/ocdd342096f8.ӷ ([FFFF)V
      // 168: getstatic x/ocdd342096f8.Ë [F
      // 16b: bipush 0
      // 16c: faload
      // 16d: aload 1
      // 16e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 171: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 174: fsub
      // 175: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_float (F)F
      // 178: invokestatic java/lang/Math.abs (F)F
      // 17b: ldc_w 3.0
      // 17e: goto 182
      // 181: athrow
      // 182: fcmpl
      // 183: ifgt 1a9
      // 186: getstatic x/ocdd342096f8.Ë [F
      // 189: bipush 1
      // 18a: faload
      // 18b: aload 1
      // 18c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 18f: getfield net/minecraft/client/entity/EntityPlayerSP.rotationPitch F
      // 192: fsub
      // 193: invokestatic java/lang/Math.abs (F)F
      // 196: ldc_w 3.0
      // 199: fcmpl
      // 19a: iload 0
      // 19b: ifne 1aa
      // 19e: goto 1a2
      // 1a1: athrow
      // 1a2: ifle 1ad
      // 1a5: goto 1a9
      // 1a8: athrow
      // 1a9: bipush 1
      // 1aa: goto 1ae
      // 1ad: bipush 0
      // 1ae: istore 10
      // 1b0: getstatic x/ocdd342096f8.Ë [F
      // 1b3: bipush 0
      // 1b4: faload
      // 1b5: getstatic x/ocdd342096f8.Ë [F
      // 1b8: bipush 1
      // 1b9: faload
      // 1ba: fload 4
      // 1bc: fload 5
      // 1be: invokestatic x/oc7c017b256e.Ր (FFFF)[F
      // 1c1: putstatic x/ocdd342096f8.Ë [F
      // 1c4: iload 10
      // 1c6: ireturn
      // 1c7: bipush 0
      // 1c8: ireturn
   }

   public static void Ԡ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: invokestatic x/ocdd342096f8.Ȭ ()Lnet/minecraft/client/Minecraft;
      // 06: astore 1
      // 07: istore 0
      // 08: getstatic x/ocdd342096f8.Ɯ Lx/ocdd342096f8;
      // 0b: iload 0
      // 0c: ifne 19
      // 0f: ifnull a0
      // 12: goto 16
      // 15: athrow
      // 16: getstatic x/ocdd342096f8.Ɯ Lx/ocdd342096f8;
      // 19: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 1c: iload 0
      // 1d: ifne 2a
      // 20: ifeq a0
      // 23: goto 27
      // 26: athrow
      // 27: invokestatic x/oc7c017b256e.Ԓ ()Z
      // 2a: ifne a0
      // 2d: aload 1
      // 2e: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 31: ifnonnull a0
      // 34: goto 38
      // 37: athrow
      // 38: getstatic x/ocdd342096f8.Θ D
      // 3b: dconst_0
      // 3c: dcmpl
      // 3d: iload 0
      // 3e: ifne 61
      // 41: goto 45
      // 44: athrow
      // 45: ifle a0
      // 48: goto 4c
      // 4b: athrow
      // 4c: getstatic x/ocdd342096f8.դ Lx/oc932bfa839d;
      // 4f: iload 0
      // 50: ifne 87
      // 53: goto 57
      // 56: athrow
      // 57: getstatic x/ocdd342096f8.ǿ J
      // 5a: invokevirtual x/oc932bfa839d.ƫ (J)Z
      // 5d: goto 61
      // 60: athrow
      // 61: ifne 84
      // 64: getstatic x/ocdd342096f8.ʭ Lx/oc59dbd08e27;
      // 67: iload 0
      // 68: ifne 79
      // 6b: goto 6f
      // 6e: athrow
      // 6f: ifnonnull a0
      // 72: goto 76
      // 75: athrow
      // 76: getstatic x/ocdd342096f8.ĕ Lx/oc59dbd08e27;
      // 79: iload 0
      // 7a: ifne 99
      // 7d: ifnull a0
      // 80: goto 84
      // 83: athrow
      // 84: getstatic x/ocdd342096f8.դ Lx/oc932bfa839d;
      // 87: invokevirtual x/oc932bfa839d.І ()V
      // 8a: bipush 0
      // 8b: iload 0
      // 8c: ifne 9d
      // 8f: invokestatic x/ocdd342096f8.Ť (Z)V
      // 92: getstatic x/ocdd342096f8.ĕ Lx/oc59dbd08e27;
      // 95: goto 99
      // 98: athrow
      // 99: ifnull a0
      // 9c: bipush 1
      // 9d: putstatic x/ocdd342096f8.ɉ Z
      // a0: return
   }

   private static void ζ(boolean var0) {
      int var1 = oc5e549848f3.İ;

      try {
         if (Ғ.isEmpty()) {
            return;
         }
      } catch (ocbde1165e4e var7) {
         throw var7;
      }

      synchronized (Ғ) {
         for (Packet var4 : Ғ) {
            Packet var8;
            label66: {
               label85: {
                  boolean var10000 = var4 instanceof C02PacketUseEntity;
                  if (var1 == 0) {
                     if (var10000) {
                        if (var0) {
                           continue;
                        }
                        break label85;
                     }

                     var10000 = var0;
                  }

                  label86: {
                     if (var1 == 0) {
                        if (!var10000) {
                           break label85;
                        }

                        var8 = var4;
                        if (var1 != 0) {
                           break label86;
                        }

                        var10000 = var4 instanceof C0APacketAnimation;
                     }

                     if (var10000) {
                        continue;
                     }

                     var8 = var4;
                  }

                  if (var1 != 0) {
                     break label66;
                  }

                  if (var8 instanceof C07PacketPlayerDigging) {
                     var8 = var4;
                     if (var1 != 0) {
                        break label66;
                     }

                     if (((C07PacketPlayerDigging)var4).getStatus() == Action.START_DESTROY_BLOCK) {
                        Վ = true;
                        if (var1 == 0) {
                           continue;
                        }
                     }
                  }
               }

               var8 = var4;
            }

            oc0f63871c3b.p(var8);
            if (var1 != 0) {
               break;
            }
         }
      }

      Ғ.clear();
   }

   private static void Ť(boolean var0) {
      int var1 = oc5e549848f3.İ;

      boolean var10000;
      label33: {
         label32: {
            try {
               var10000 = var0;
               if (var1 != 0) {
                  break label33;
               }

               if (var0) {
                  break label32;
               }
            } catch (ocbde1165e4e var3) {
               throw var3;
            }

            Յ();
         }

         var10000 = var0;
      }

      label24: {
         try {
            if (var10000) {
               var4 = 0L;
               break label24;
            }
         } catch (ocbde1165e4e var2) {
            throw var2;
         }

         var4 = (long)(1000.0 / Θ + ThreadLocalRandom.current().nextInt(-326009952 ^ 326009948, 326009945 ^ 326009948));
      }

      ǿ = var4;
   }

   private static void Յ() {
      Θ = ɜ + ThreadLocalRandom.current().nextDouble() * (ǧ - ɜ);
   }

   public void β() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 1
      // 04: getstatic x/ocdd342096f8.ș Lx/oc8df2d0340c;
      // 07: getfield x/oc8df2d0340c.m Z
      // 0a: iload 1
      // 0b: ifne 2d
      // 0e: ifeq 2a
      // 11: goto 15
      // 14: athrow
      // 15: getstatic x/ocdd342096f8.Ł Z
      // 18: iload 1
      // 19: ifne 2d
      // 1c: goto 20
      // 1f: athrow
      // 20: ifeq 2a
      // 23: goto 27
      // 26: athrow
      // 27: invokestatic x/oc7c017b256e.Ǭ ()V
      // 2a: getstatic x/ocdd342096f8.ն Z
      // 2d: iload 1
      // 2e: ifne 39
      // 31: ifeq 3c
      // 34: goto 38
      // 37: athrow
      // 38: bipush 0
      // 39: putstatic x/ocdd342096f8.ն Z
      // 3c: return
   }

   private static void ӷ(float[] param0, float param1, float param2, float param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: ldc_w 7.0
      // 03: fstore 5
      // 05: ldc_w 3.0
      // 08: fstore 6
      // 0a: dconst_1
      // 0b: ldc2_w 9.9
      // 0e: getstatic x/ocdd342096f8.A Lx/oca9cc61aada;
      // 11: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 14: fload 3
      // 15: f2d
      // 16: dadd
      // 17: invokestatic java/lang/Math.min (DD)D
      // 1a: ldc2_w 10.0
      // 1d: ddiv
      // 1e: dsub
      // 1f: d2f
      // 20: fstore 7
      // 22: getstatic x/oc5e549848f3.İ I
      // 25: aload 0
      // 26: bipush 0
      // 27: faload
      // 28: fload 1
      // 29: fsub
      // 2a: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_float (F)F
      // 2d: fstore 8
      // 2f: fload 8
      // 31: invokestatic java/lang/Math.abs (F)F
      // 34: fstore 9
      // 36: aload 0
      // 37: bipush 1
      // 38: faload
      // 39: fload 2
      // 3a: fsub
      // 3b: fstore 10
      // 3d: fload 10
      // 3f: invokestatic java/lang/Math.abs (F)F
      // 42: fstore 11
      // 44: istore 4
      // 46: fload 9
      // 48: iload 4
      // 4a: ifne 6c
      // 4d: fload 5
      // 4f: fcmpl
      // 50: ifle 6a
      // 53: goto 57
      // 56: athrow
      // 57: fload 8
      // 59: invokestatic java/lang/Math.signum (F)F
      // 5c: fload 9
      // 5e: fload 5
      // 60: fsub
      // 61: fload 7
      // 63: fmul
      // 64: fload 5
      // 66: fadd
      // 67: fmul
      // 68: fstore 8
      // 6a: fload 11
      // 6c: iload 4
      // 6e: ifne 90
      // 71: fload 6
      // 73: fcmpl
      // 74: ifle 92
      // 77: goto 7b
      // 7a: athrow
      // 7b: fload 10
      // 7d: invokestatic java/lang/Math.signum (F)F
      // 80: fload 11
      // 82: fload 6
      // 84: fsub
      // 85: fload 7
      // 87: fmul
      // 88: fload 6
      // 8a: fadd
      // 8b: fmul
      // 8c: goto 90
      // 8f: athrow
      // 90: fstore 10
      // 92: aload 0
      // 93: bipush 0
      // 94: fload 1
      // 95: fload 8
      // 97: fadd
      // 98: fastore
      // 99: aload 0
      // 9a: bipush 1
      // 9b: fload 2
      // 9c: fload 10
      // 9e: fadd
      // 9f: fastore
      // a0: return
   }

   public static void ӳ(boolean param0, boolean param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: invokestatic x/ocdd342096f8.Ȭ ()Lnet/minecraft/client/Minecraft;
      // 06: astore 3
      // 07: istore 2
      // 08: iload 1
      // 09: iload 2
      // 0a: ifne 45
      // 0d: ifeq 40
      // 10: goto 14
      // 13: athrow
      // 14: aload 3
      // 15: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 18: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 1b: getstatic x/oc0f63871c3b.Ϧ I
      // 1e: invokevirtual net/minecraft/entity/player/InventoryPlayer.getStackInSlot (I)Lnet/minecraft/item/ItemStack;
      // 21: dup
      // 22: astore 4
      // 24: iload 2
      // 25: ifne 31
      // 28: ifnull 3a
      // 2b: goto 2f
      // 2e: athrow
      // 2f: aload 4
      // 31: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 34: instanceof net/minecraft/item/ItemSword
      // 37: ifne 3c
      // 3a: return
      // 3b: athrow
      // 3c: iload 2
      // 3d: ifeq 63
      // 40: iload 0
      // 41: goto 45
      // 44: athrow
      // 45: iload 2
      // 46: ifne 64
      // 49: ifeq 63
      // 4c: goto 50
      // 4f: athrow
      // 50: invokestatic x/oc7c017b256e.Э ()Z
      // 53: iload 2
      // 54: ifne 64
      // 57: goto 5b
      // 5a: athrow
      // 5b: ifne 63
      // 5e: goto 62
      // 61: athrow
      // 62: return
      // 63: iload 1
      // 64: iload 2
      // 65: ifne d1
      // 68: ifeq c3
      // 6b: goto 6f
      // 6e: athrow
      // 6f: iload 0
      // 70: iload 2
      // 71: ifne b4
      // 74: goto 78
      // 77: athrow
      // 78: ifeq 98
      // 7b: goto 7f
      // 7e: athrow
      // 7f: new net/minecraft/network/play/client/C08PacketPlayerBlockPlacement
      // 82: dup
      // 83: aload 3
      // 84: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 87: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 8a: invokespecial net/minecraft/network/play/client/C08PacketPlayerBlockPlacement.<init> (Lnet/minecraft/item/ItemStack;)V
      // 8d: invokestatic x/oc0f63871c3b.Щ (Lnet/minecraft/network/Packet;)V
      // 90: iload 2
      // 91: ifeq b7
      // 94: goto 98
      // 97: athrow
      // 98: bipush 1
      // 99: putstatic x/ocdd342096f8.ϟ Z
      // 9c: new net/minecraft/network/play/client/C07PacketPlayerDigging
      // 9f: dup
      // a0: getstatic net/minecraft/network/play/client/C07PacketPlayerDigging$Action.RELEASE_USE_ITEM Lnet/minecraft/network/play/client/C07PacketPlayerDigging$Action;
      // a3: getstatic net/minecraft/util/BlockPos.ORIGIN Lnet/minecraft/util/BlockPos;
      // a6: getstatic net/minecraft/util/EnumFacing.DOWN Lnet/minecraft/util/EnumFacing;
      // a9: invokespecial net/minecraft/network/play/client/C07PacketPlayerDigging.<init> (Lnet/minecraft/network/play/client/C07PacketPlayerDigging$Action;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;)V
      // ac: invokestatic x/oc0f63871c3b.Щ (Lnet/minecraft/network/Packet;)V
      // af: bipush 0
      // b0: goto b4
      // b3: athrow
      // b4: putstatic x/ocdd342096f8.ϟ Z
      // b7: iload 0
      // b8: dup
      // b9: putstatic x/ocdd342096f8.Ԣ Z
      // bc: putstatic x/ocdd342096f8.Ł Z
      // bf: iload 2
      // c0: ifeq d5
      // c3: aload 3
      // c4: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // c7: getfield net/minecraft/client/settings/GameSettings.keyBindUseItem Lnet/minecraft/client/settings/KeyBinding;
      // ca: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // cd: goto d1
      // d0: athrow
      // d1: iload 0
      // d2: invokestatic net/minecraft/client/settings/KeyBinding.setKeyBindState (IZ)V
      // d5: return
   }

   private static void Ŕ(int param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 1
      // 04: iload 0
      // 05: iload 1
      // 06: ifne 26
      // 09: ifne 25
      // 0c: goto 10
      // 0f: athrow
      // 10: getstatic x/ocdd342096f8.ș Lx/oc8df2d0340c;
      // 13: getfield x/oc8df2d0340c.Թ Z
      // 16: iload 1
      // 17: ifne 2b
      // 1a: goto 1e
      // 1d: athrow
      // 1e: ifne 2a
      // 21: goto 25
      // 24: athrow
      // 25: bipush 0
      // 26: bipush 1
      // 27: invokestatic x/ocdd342096f8.ӳ (ZZ)V
      // 2a: bipush 1
      // 2b: putstatic x/ocdd342096f8.ն Z
      // 2e: return
   }

   private static boolean ſ(S2FPacketSetSlot var0) {
      Minecraft var2 = null;
      int var3 = 2109837669 ^ -861842075;
      int var1 = oc5e549848f3.İ;

      while (true) {
         switch (var3) {
            case -1325695230:
               int var11;
               label116: {
                  label115: {
                     try {
                        var11 = oc7ab2161b9f.Ь();
                        if (var1 != 0) {
                           break label116;
                        }

                        if (var11 != (-861842073 ^ -861842075)) {
                           break label115;
                        }
                     } catch (ocbde1165e4e var8) {
                        throw var8;
                     }

                     var3 = -309692129 ^ -861842075;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var11 = -368227064 ^ -861842075;
               }

               var3 = var11;
               if (var1 == 0) {
                  continue;
               }
            case 556477562:
               if (var2.currentScreen == null) {
                  var3 = 418542261 ^ -861842075;
                  if (var1 == 0) {
                     continue;
                  }
               }

               var3 = -368227064 ^ -861842075;
               if (var1 == 0) {
                  continue;
               }

               return false;
            case -732747824:
               int var10;
               label107: {
                  label106: {
                     try {
                        var10 = var2.thePlayer.inventory.currentItem;
                        if (var1 != 0) {
                           break label107;
                        }

                        if (var2.thePlayer.inventory.currentItem != var0.func_149173_d() - (-861842111 ^ -861842075)) {
                           break label106;
                        }
                     } catch (ocbde1165e4e var7) {
                        throw var7;
                     }

                     var3 = -506913143 ^ -861842075;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var10 = -368227064 ^ -861842075;
               }

               var3 = var10;
               if (var1 == 0) {
                  continue;
               }
            case -1319058432:
               var2 = Ȭ();

               label93: {
                  label92: {
                     try {
                        if (var1 != 0) {
                           break label93;
                        }

                        if (ĕ == null) {
                           break label92;
                        }
                     } catch (ocbde1165e4e var6) {
                        throw var6;
                     }

                     var3 = -1485244327 ^ -861842075;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var3 = -368227064 ^ -861842075;
               }

               if (var1 == 0) {
                  continue;
               }

               return true;
            case 648812653:
               return false;
            case 761809900:
               int var10000;
               label84: {
                  label83: {
                     try {
                        var10000 = oc7c017b256e.Э();
                        if (var1 != 0) {
                           break label84;
                        }

                        if (var10000 == 0) {
                           break label83;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var3 = -1512383641 ^ -861842075;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var10000 = -368227064 ^ -861842075;
               }

               var3 = var10000;
               if (var1 == 0) {
                  continue;
               }
               break;
            case 1769704962:
               return true;
            case 1809427772:
               break;
            default:
               throw null;
         }

         int var9;
         label75: {
            label74: {
               try {
                  var9 = oc7ab2161b9f.Տ();
                  if (var1 != 0) {
                     break label75;
                  }

                  if (var9 == 0) {
                     break label74;
                  }
               } catch (ocbde1165e4e var4) {
                  throw var4;
               }

               var3 = 2086283879 ^ -861842075;
               if (var1 == 0) {
                  continue;
               }
            }

            var9 = -368227064 ^ -861842075;
         }

         var3 = var9;
      }
   }

   public void Z() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 1
      // 04: invokestatic x/ocdd342096f8.Ȭ ()Lnet/minecraft/client/Minecraft;
      // 07: iload 1
      // 08: ifne 1c
      // 0b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0e: ifnull 3f
      // 11: goto 15
      // 14: athrow
      // 15: invokestatic x/ocdd342096f8.Ȭ ()Lnet/minecraft/client/Minecraft;
      // 18: goto 1c
      // 1b: athrow
      // 1c: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 1f: ifnull 3f
      // 22: getstatic x/ocdd342096f8.Г I
      // 25: iload 1
      // 26: ifne 50
      // 29: goto 2d
      // 2c: athrow
      // 2d: bipush -1
      // 2e: if_icmpeq 3f
      // 31: goto 35
      // 34: athrow
      // 35: getstatic x/ocdd342096f8.Г I
      // 38: invokestatic x/ocdd342096f8.Ŕ (I)V
      // 3b: goto 3f
      // 3e: athrow
      // 3f: bipush -1
      // 40: putstatic x/ocdd342096f8.Г I
      // 43: bipush 0
      // 44: putstatic x/ocdd342096f8.ն Z
      // 47: bipush 0
      // 48: putstatic x/ocdd342096f8.Ԣ Z
      // 4b: bipush 0
      // 4c: putstatic x/ocdd342096f8.Ł Z
      // 4f: bipush 1
      // 50: putstatic x/ocdd342096f8.Ŧ Z
      // 53: return
   }

   private static double Ѝ(EntityLivingBase var0) {
      return var0.hurtTime;
   }

   @Override
   public void onEnable() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: bipush 0
      // 04: putstatic x/ocdd342096f8.Ŧ Z
      // 07: istore 1
      // 08: invokestatic x/ocdd342096f8.Ȭ ()Lnet/minecraft/client/Minecraft;
      // 0b: iload 1
      // 0c: ifne 21
      // 0f: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 12: ifnonnull 1e
      // 15: goto 19
      // 18: athrow
      // 19: bipush 0
      // 1a: goto 27
      // 1d: athrow
      // 1e: invokestatic x/ocdd342096f8.Ȭ ()Lnet/minecraft/client/Minecraft;
      // 21: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 24: getfield net/minecraft/client/entity/EntityPlayerSP.ticksExisted I
      // 27: putstatic x/ocdd342096f8.ʪ I
      // 2a: return
   }

   @oc66fa4f2195
   public void ռ(ocadfd5cc157 var1) {
      try {
         if (var1.Ц == Ȭ().thePlayer) {
            γ(null);
            Ғ.clear();
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }
   }

   public static boolean բ(boolean param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 1
      // 04: getstatic x/ocdd342096f8.Г I
      // 07: iload 1
      // 08: ifne 29
      // 0b: bipush -1
      // 0c: if_icmpeq 28
      // 0f: goto 13
      // 12: athrow
      // 13: getstatic x/ocdd342096f8.Г I
      // 16: invokestatic x/ocdd342096f8.Ŕ (I)V
      // 19: bipush -1
      // 1a: putstatic x/ocdd342096f8.Г I
      // 1d: iload 0
      // 1e: dup
      // 1f: putstatic x/ocdd342096f8.Ԣ Z
      // 22: putstatic x/ocdd342096f8.Ł Z
      // 25: bipush 1
      // 26: ireturn
      // 27: athrow
      // 28: bipush 0
      // 29: ireturn
   }

   public void Ƙ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: getstatic x/oc5e549848f3.İ I
      // 003: istore 1
      // 004: invokestatic x/oc7c017b256e.Ԓ ()Z
      // 007: iload 1
      // 008: ifne 013
      // 00b: ifeq 017
      // 00e: goto 012
      // 011: athrow
      // 012: bipush 0
      // 013: putstatic x/ocdd342096f8.ă Z
      // 016: return
      // 017: invokestatic x/ocdd342096f8.Ȭ ()Lnet/minecraft/client/Minecraft;
      // 01a: astore 2
      // 01b: getstatic x/ocdd342096f8.ĕ Lx/oc59dbd08e27;
      // 01e: ifnull 13f
      // 021: getstatic x/ocdd342096f8.į Z
      // 024: iload 1
      // 025: ifne 094
      // 028: goto 02c
      // 02b: athrow
      // 02c: ifeq 091
      // 02f: goto 033
      // 032: athrow
      // 033: getstatic x/ocdd342096f8.Ӣ Lx/oc12021474b0;
      // 036: getstatic x/oc12021474b0.g Lx/oc12021474b0;
      // 039: if_acmpne 091
      // 03c: goto 040
      // 03f: athrow
      // 040: invokestatic x/ocbb165642ef.ʨ ()Lx/ocbb165642ef;
      // 043: iload 1
      // 044: ifne 063
      // 047: goto 04b
      // 04a: athrow
      // 04b: invokevirtual x/ocbb165642ef.ɦ ()Ljava/lang/Float;
      // 04e: ifnonnull 060
      // 051: goto 055
      // 054: athrow
      // 055: aload 2
      // 056: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 059: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 05c: goto 069
      // 05f: athrow
      // 060: invokestatic x/ocbb165642ef.ʨ ()Lx/ocbb165642ef;
      // 063: invokevirtual x/ocbb165642ef.ɦ ()Ljava/lang/Float;
      // 066: invokevirtual java/lang/Float.floatValue ()F
      // 069: invokestatic x/ocbb165642ef.ʨ ()Lx/ocbb165642ef;
      // 06c: iload 1
      // 06d: ifne 088
      // 070: invokevirtual x/ocbb165642ef.ȫ ()Ljava/lang/Float;
      // 073: ifnonnull 085
      // 076: goto 07a
      // 079: athrow
      // 07a: aload 2
      // 07b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 07e: getfield net/minecraft/client/entity/EntityPlayerSP.rotationPitch F
      // 081: goto 08e
      // 084: athrow
      // 085: invokestatic x/ocbb165642ef.ʨ ()Lx/ocbb165642ef;
      // 088: invokevirtual x/ocbb165642ef.ȫ ()Ljava/lang/Float;
      // 08b: invokevirtual java/lang/Float.floatValue ()F
      // 08e: invokestatic x/oc7c017b256e.Ϲ (FF)V
      // 091: invokestatic x/ocdd342096f8.Ց ()Z
      // 094: iload 1
      // 095: ifne 145
      // 098: ifeq 13f
      // 09b: goto 09f
      // 09e: athrow
      // 09f: getstatic x/ocdd342096f8.ș Lx/oc8df2d0340c;
      // 0a2: iload 1
      // 0a3: ifne 142
      // 0a6: goto 0aa
      // 0a9: athrow
      // 0aa: getfield x/oc8df2d0340c.m Z
      // 0ad: ifne 13f
      // 0b0: goto 0b4
      // 0b3: athrow
      // 0b4: getstatic x/oc58959f21df.ѕ [I
      // 0b7: getstatic x/ocdd342096f8.ș Lx/oc8df2d0340c;
      // 0ba: invokevirtual java/lang/Enum.ordinal ()I
      // 0bd: iaload
      // 0be: iload 1
      // 0bf: ifne 145
      // 0c2: goto 0c6
      // 0c5: athrow
      // 0c6: tableswitch 121 1 3 27 40 113
      // 0e0: athrow
      // 0e1: bipush 1
      // 0e2: bipush 0
      // 0e3: invokestatic x/ocdd342096f8.ӳ (ZZ)V
      // 0e6: iload 1
      // 0e7: ifeq 13f
      // 0ea: goto 0ee
      // 0ed: athrow
      // 0ee: invokestatic java/lang/System.currentTimeMillis ()J
      // 0f1: getstatic x/ocdd342096f8.Ų J
      // 0f4: lsub
      // 0f5: ldc2_w 3217629369230431823
      // 0f8: ldc2_w 3217629369230431599
      // 0fb: lxor
      // 0fc: lcmp
      // 0fd: iload 1
      // 0fe: ifne 120
      // 101: goto 105
      // 104: athrow
      // 105: ifge 119
      // 108: goto 10c
      // 10b: athrow
      // 10c: bipush 1
      // 10d: bipush 0
      // 10e: invokestatic x/ocdd342096f8.ӳ (ZZ)V
      // 111: iload 1
      // 112: ifeq 13f
      // 115: goto 119
      // 118: athrow
      // 119: invokestatic x/ocdd342096f8.Շ ()Z
      // 11c: goto 120
      // 11f: athrow
      // 120: iload 1
      // 121: ifne 12f
      // 124: ifeq 12e
      // 127: goto 12b
      // 12a: athrow
      // 12b: goto 13f
      // 12e: bipush 0
      // 12f: bipush 0
      // 130: invokestatic x/ocdd342096f8.ӳ (ZZ)V
      // 133: iload 1
      // 134: ifeq 13f
      // 137: bipush 1
      // 138: putstatic x/ocdd342096f8.Ԣ Z
      // 13b: goto 13f
      // 13e: athrow
      // 13f: getstatic x/ocdd342096f8.ș Lx/oc8df2d0340c;
      // 142: getfield x/oc8df2d0340c.m Z
      // 145: iload 1
      // 146: ifne 247
      // 149: ifeq 246
      // 14c: goto 150
      // 14f: athrow
      // 150: getstatic x/ocdd342096f8.C Z
      // 153: iload 1
      // 154: ifne 247
      // 157: goto 15b
      // 15a: athrow
      // 15b: ifne 246
      // 15e: goto 162
      // 161: athrow
      // 162: getstatic x/ocdd342096f8.ĕ Lx/oc59dbd08e27;
      // 165: ifnonnull 246
      // 168: goto 16c
      // 16b: athrow
      // 16c: aload 2
      // 16d: iload 1
      // 16e: ifne 184
      // 171: goto 175
      // 174: athrow
      // 175: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 178: ifnonnull 246
      // 17b: goto 17f
      // 17e: athrow
      // 17f: aload 2
      // 180: goto 184
      // 183: athrow
      // 184: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 187: ifnull 246
      // 18a: invokestatic x/oc7c017b256e.Э ()Z
      // 18d: iload 1
      // 18e: ifne 247
      // 191: goto 195
      // 194: athrow
      // 195: ifeq 246
      // 198: goto 19c
      // 19b: athrow
      // 19c: invokestatic x/ocdd342096f8.Շ ()Z
      // 19f: iload 1
      // 1a0: ifne 247
      // 1a3: goto 1a7
      // 1a6: athrow
      // 1a7: ifeq 246
      // 1aa: goto 1ae
      // 1ad: athrow
      // 1ae: aload 2
      // 1af: iload 1
      // 1b0: ifne 1c9
      // 1b3: goto 1b7
      // 1b6: athrow
      // 1b7: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 1ba: getfield net/minecraft/util/MovingObjectPosition.entityHit Lnet/minecraft/entity/Entity;
      // 1bd: ifnull 1e1
      // 1c0: goto 1c4
      // 1c3: athrow
      // 1c4: aload 2
      // 1c5: goto 1c9
      // 1c8: athrow
      // 1c9: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 1cc: getfield net/minecraft/util/MovingObjectPosition.entityHit Lnet/minecraft/entity/Entity;
      // 1cf: invokestatic x/oca4f99d2d44.Λ (Lnet/minecraft/entity/Entity;)Z
      // 1d2: iload 1
      // 1d3: ifne 1de
      // 1d6: ifeq 1e1
      // 1d9: goto 1dd
      // 1dc: athrow
      // 1dd: bipush 1
      // 1de: goto 1e2
      // 1e1: bipush 0
      // 1e2: istore 3
      // 1e3: iload 3
      // 1e4: iload 1
      // 1e5: ifne 21a
      // 1e8: ifne 219
      // 1eb: goto 1ef
      // 1ee: athrow
      // 1ef: aload 2
      // 1f0: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 1f3: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 1f6: dup
      // 1f7: astore 4
      // 1f9: iload 1
      // 1fa: ifne 206
      // 1fd: ifnull 219
      // 200: goto 204
      // 203: athrow
      // 204: aload 4
      // 206: invokestatic x/oc7c017b256e.Ϭ (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/Block;
      // 209: invokestatic x/oc7c017b256e.ƈ (Lnet/minecraft/block/Block;)Z
      // 20c: iload 1
      // 20d: ifne 21a
      // 210: ifeq 219
      // 213: goto 217
      // 216: athrow
      // 217: bipush 1
      // 218: istore 3
      // 219: iload 3
      // 21a: iload 1
      // 21b: ifne 247
      // 21e: ifeq 246
      // 221: goto 225
      // 224: athrow
      // 225: aload 2
      // 226: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 229: getfield net/minecraft/client/settings/GameSettings.keyBindUseItem Lnet/minecraft/client/settings/KeyBinding;
      // 22c: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // 22f: istore 5
      // 231: iload 5
      // 233: bipush 1
      // 234: invokestatic net/minecraft/client/settings/KeyBinding.setKeyBindState (IZ)V
      // 237: iload 5
      // 239: invokestatic net/minecraft/client/settings/KeyBinding.onTick (I)V
      // 23c: iload 5
      // 23e: bipush 0
      // 23f: invokestatic net/minecraft/client/settings/KeyBinding.setKeyBindState (IZ)V
      // 242: bipush 1
      // 243: putstatic x/ocdd342096f8.C Z
      // 246: bipush 0
      // 247: putstatic x/ocdd342096f8.ă Z
      // 24a: return
   }

   private static void ų() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: getstatic x/oc75d51ec7eb.d [F
      // 06: bipush 0
      // 07: faload
      // 08: fstore 1
      // 09: istore 0
      // 0a: getstatic x/oc75d51ec7eb.d [F
      // 0d: bipush 1
      // 0e: faload
      // 0f: fstore 2
      // 10: iload 0
      // 11: ifne 4d
      // 14: invokestatic x/ocdd342096f8.Ǭ ()[F
      // 17: putstatic x/ocdd342096f8.Ë [F
      // 1a: getstatic x/ocdd342096f8.A Lx/oca9cc61aada;
      // 1d: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 20: getstatic x/ocdd342096f8.A Lx/oca9cc61aada;
      // 23: invokevirtual x/oca9cc61aada.ԕ ()D
      // 26: dcmpl
      // 27: ifeq 3b
      // 2a: goto 2e
      // 2d: athrow
      // 2e: getstatic x/ocdd342096f8.Ë [F
      // 31: fload 1
      // 32: fload 2
      // 33: fconst_0
      // 34: invokestatic x/ocdd342096f8.ӷ ([FFFF)V
      // 37: goto 3b
      // 3a: athrow
      // 3b: getstatic x/ocdd342096f8.Ë [F
      // 3e: bipush 0
      // 3f: faload
      // 40: getstatic x/ocdd342096f8.Ë [F
      // 43: bipush 1
      // 44: faload
      // 45: fload 1
      // 46: fload 2
      // 47: invokestatic x/oc7c017b256e.Ր (FFFF)[F
      // 4a: putstatic x/ocdd342096f8.Ë [F
      // 4d: return
   }

   private static double Ȳ(EntityLivingBase var0) {
      return oc7c017b256e.ȥ(var0, false);
   }

   public static void γ(Entity param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: getstatic x/oc5e549848f3.İ I
      // 003: istore 1
      // 004: aload 0
      // 005: ifnonnull 0d0
      // 008: invokestatic java/util/Collections.emptyList ()Ljava/util/List;
      // 00b: putstatic x/ocdd342096f8.Ց Ljava/util/List;
      // 00e: getstatic x/ocdd342096f8.Ě Ljava/util/HashMap;
      // 011: invokevirtual java/util/HashMap.clear ()V
      // 014: getstatic x/ocdd342096f8.ĕ Lx/oc59dbd08e27;
      // 017: ifnull 06d
      // 01a: goto 01e
      // 01d: athrow
      // 01e: getstatic x/ocdd342096f8.ș Lx/oc8df2d0340c;
      // 021: getfield x/oc8df2d0340c.m Z
      // 024: iload 1
      // 025: ifne 066
      // 028: goto 02c
      // 02b: athrow
      // 02c: ifeq 065
      // 02f: goto 033
      // 032: athrow
      // 033: getstatic x/ocdd342096f8.Ӹ Lx/occ2f8dff8d8;
      // 036: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 039: iload 1
      // 03a: ifne 062
      // 03d: goto 041
      // 040: athrow
      // 041: ifeq 05b
      // 044: goto 048
      // 047: athrow
      // 048: getstatic x/ocdd342096f8.Г I
      // 04b: iload 1
      // 04c: ifne 066
      // 04f: goto 053
      // 052: athrow
      // 053: bipush -1
      // 054: if_icmpeq 065
      // 057: goto 05b
      // 05a: athrow
      // 05b: getstatic x/ocdd342096f8.Г I
      // 05e: goto 062
      // 061: athrow
      // 062: invokestatic x/ocdd342096f8.Ŕ (I)V
      // 065: bipush 0
      // 066: putstatic x/ocdd342096f8.Ԣ Z
      // 069: iload 1
      // 06a: ifeq 096
      // 06d: getstatic x/ocdd342096f8.ș Lx/oc8df2d0340c;
      // 070: getstatic x/oc8df2d0340c.Ѐ Lx/oc8df2d0340c;
      // 073: if_acmpeq 096
      // 076: goto 07a
      // 079: athrow
      // 07a: bipush 1
      // 07b: iload 1
      // 07c: ifne 0a9
      // 07f: goto 083
      // 082: athrow
      // 083: invokestatic x/oc7c017b256e.Ê (I)Z
      // 086: ifne 096
      // 089: goto 08d
      // 08c: athrow
      // 08d: bipush 0
      // 08e: bipush 0
      // 08f: invokestatic x/ocdd342096f8.ӳ (ZZ)V
      // 092: goto 096
      // 095: athrow
      // 096: bipush 0
      // 097: iload 1
      // 098: ifne 0bb
      // 09b: putstatic x/ocdd342096f8.Ł Z
      // 09e: bipush 0
      // 09f: putstatic x/ocdd342096f8.į Z
      // 0a2: getstatic x/ocdd342096f8.Г I
      // 0a5: goto 0a9
      // 0a8: athrow
      // 0a9: bipush -1
      // 0aa: if_icmpeq 0b5
      // 0ad: bipush -1
      // 0ae: putstatic x/ocdd342096f8.Г I
      // 0b1: goto 0b5
      // 0b4: athrow
      // 0b5: getstatic x/ocdd342096f8.Ѱ Lx/occ2f8dff8d8;
      // 0b8: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0bb: ifne 0fc
      // 0be: aconst_null
      // 0bf: putstatic x/ocdd342096f8.Ʉ Lnet/minecraft/util/Vec3;
      // 0c2: iload 1
      // 0c3: getstatic x/ocdd342096f8.ǉ Ljava/util/HashMap;
      // 0c6: invokevirtual java/util/HashMap.clear ()V
      // 0c9: ifeq 0fc
      // 0cc: goto 0d0
      // 0cf: athrow
      // 0d0: getstatic x/ocdd342096f8.Ѱ Lx/occ2f8dff8d8;
      // 0d3: iload 1
      // 0d4: ifne 0f6
      // 0d7: goto 0db
      // 0da: athrow
      // 0db: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0de: ifne 0fc
      // 0e1: goto 0e5
      // 0e4: athrow
      // 0e5: getstatic x/ocdd342096f8.ǉ Ljava/util/HashMap;
      // 0e8: aload 0
      // 0e9: invokevirtual net/minecraft/entity/Entity.getEntityId ()I
      // 0ec: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 0ef: invokevirtual java/util/HashMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 0f2: goto 0f6
      // 0f5: athrow
      // 0f6: checkcast net/minecraft/util/Vec3
      // 0f9: putstatic x/ocdd342096f8.Ʉ Lnet/minecraft/util/Vec3;
      // 0fc: getstatic x/ocdd342096f8.ĕ Lx/oc59dbd08e27;
      // 0ff: iload 1
      // 100: ifne 117
      // 103: putstatic x/ocdd342096f8.ʭ Lx/oc59dbd08e27;
      // 106: getstatic x/ocdd342096f8.ĕ Lx/oc59dbd08e27;
      // 109: ifnull 128
      // 10c: goto 110
      // 10f: athrow
      // 110: getstatic x/ocdd342096f8.ĕ Lx/oc59dbd08e27;
      // 113: goto 117
      // 116: athrow
      // 117: getfield x/oc59dbd08e27.Ԍ Lnet/minecraft/entity/Entity;
      // 11a: iload 1
      // 11b: ifne 129
      // 11e: aload 0
      // 11f: if_acmpne 128
      // 122: goto 126
      // 125: athrow
      // 126: return
      // 127: athrow
      // 128: aload 0
      // 129: ifnull 138
      // 12c: new x/oc59dbd08e27
      // 12f: dup
      // 130: aload 0
      // 131: invokespecial x/oc59dbd08e27.<init> (Lnet/minecraft/entity/Entity;)V
      // 134: goto 139
      // 137: athrow
      // 138: aconst_null
      // 139: putstatic x/ocdd342096f8.ĕ Lx/oc59dbd08e27;
      // 13c: aload 0
      // 13d: iload 1
      // 13e: ifne 150
      // 141: instanceof net/minecraft/entity/EntityLivingBase
      // 144: ifeq 156
      // 147: goto 14b
      // 14a: athrow
      // 14b: aload 0
      // 14c: goto 150
      // 14f: athrow
      // 150: checkcast net/minecraft/entity/EntityLivingBase
      // 153: goto 157
      // 156: aconst_null
      // 157: putstatic x/ocdd342096f8.f Lnet/minecraft/entity/EntityLivingBase;
      // 15a: getstatic x/ocdd342096f8.f Lnet/minecraft/entity/EntityLivingBase;
      // 15d: iload 1
      // 15e: ifne 172
      // 161: ifnonnull 16f
      // 164: goto 168
      // 167: athrow
      // 168: invokestatic java/util/Collections.emptyList ()Ljava/util/List;
      // 16b: goto 175
      // 16e: athrow
      // 16f: getstatic x/ocdd342096f8.f Lnet/minecraft/entity/EntityLivingBase;
      // 172: invokestatic java/util/Collections.singletonList (Ljava/lang/Object;)Ljava/util/List;
      // 175: putstatic x/ocdd342096f8.Ց Ljava/util/List;
      // 178: return
   }

   @Override
   public String getInfo() {
      try {
         if (Ӣ == oc12021474b0.Ӝ) {
            return Integer.toString((int)ř.Ӂ());
         }
      } catch (ocbde1165e4e var1) {
         throw var1;
      }

      return Ǒ.Ҿ()[(int)Ǒ.Ӂ()];
   }

   @Override
   public void onDisable() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 1
      // 04: invokestatic x/ocdd342096f8.Ȭ ()Lnet/minecraft/client/Minecraft;
      // 07: iload 1
      // 08: ifne 1c
      // 0b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0e: ifnull 22
      // 11: goto 15
      // 14: athrow
      // 15: invokestatic x/ocdd342096f8.Ȭ ()Lnet/minecraft/client/Minecraft;
      // 18: goto 1c
      // 1b: athrow
      // 1c: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 1f: ifnonnull 27
      // 22: invokestatic x/ocdd342096f8.Я ()V
      // 25: return
      // 26: athrow
      // 27: getstatic x/ocdd342096f8.ș Lx/oc8df2d0340c;
      // 2a: getstatic x/oc8df2d0340c.Ѐ Lx/oc8df2d0340c;
      // 2d: if_acmpeq 63
      // 30: invokestatic x/ocdd342096f8.Շ ()Z
      // 33: iload 1
      // 34: ifne be
      // 37: goto 3b
      // 3a: athrow
      // 3b: ifne 63
      // 3e: goto 42
      // 41: athrow
      // 42: invokestatic x/ocdd342096f8.Ȭ ()Lnet/minecraft/client/Minecraft;
      // 45: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 48: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isUsingItem ()Z
      // 4b: iload 1
      // 4c: ifne be
      // 4f: goto 53
      // 52: athrow
      // 53: ifeq 63
      // 56: goto 5a
      // 59: athrow
      // 5a: bipush 0
      // 5b: bipush 0
      // 5c: invokestatic x/ocdd342096f8.ӳ (ZZ)V
      // 5f: goto 63
      // 62: athrow
      // 63: bipush 0
      // 64: putstatic x/ocdd342096f8.ž Z
      // 67: bipush 0
      // 68: putstatic x/ocdd342096f8.ă Z
      // 6b: bipush 0
      // 6c: putstatic x/ocdd342096f8.Վ Z
      // 6f: bipush 0
      // 70: putstatic x/ocdd342096f8.Ō Z
      // 73: bipush 0
      // 74: putstatic x/ocdd342096f8.C Z
      // 77: bipush 0
      // 78: putstatic x/ocdd342096f8.į Z
      // 7b: bipush 0
      // 7c: putstatic x/ocdd342096f8.ɉ Z
      // 7f: aconst_null
      // 80: putstatic x/ocdd342096f8.ʭ Lx/oc59dbd08e27;
      // 83: aconst_null
      // 84: putstatic x/ocdd342096f8.ĕ Lx/oc59dbd08e27;
      // 87: aconst_null
      // 88: putstatic x/ocdd342096f8.f Lnet/minecraft/entity/EntityLivingBase;
      // 8b: invokestatic java/util/Collections.emptyList ()Ljava/util/List;
      // 8e: putstatic x/ocdd342096f8.Ց Ljava/util/List;
      // 91: aconst_null
      // 92: putstatic x/ocdd342096f8.ѐ Lnet/minecraft/entity/EntityLivingBase;
      // 95: bipush 0
      // 96: putstatic x/ocdd342096f8.ư Z
      // 99: aconst_null
      // 9a: putstatic x/ocdd342096f8.Ë [F
      // 9d: aconst_null
      // 9e: putstatic x/ocdd342096f8.Ʉ Lnet/minecraft/util/Vec3;
      // a1: getstatic x/ocdd342096f8.ǉ Ljava/util/HashMap;
      // a4: invokevirtual java/util/HashMap.clear ()V
      // a7: getstatic x/ocdd342096f8.Ě Ljava/util/HashMap;
      // aa: invokevirtual java/util/HashMap.clear ()V
      // ad: bipush 0
      // ae: putstatic x/ocdd342096f8.ҁ I
      // b1: bipush 0
      // b2: putstatic x/ocdd342096f8.Ư I
      // b5: lconst_0
      // b6: putstatic x/ocdd342096f8.Ų J
      // b9: lconst_0
      // ba: putstatic x/ocdd342096f8.ǿ J
      // bd: bipush 1
      // be: invokestatic x/ocdd342096f8.ζ (Z)V
      // c1: aload 0
      // c2: invokestatic x/oc5e549848f3.э (Lx/ocdd342096f8;)V
      // c5: return
   }

   private static void ł() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: invokestatic x/ocdd342096f8.Ց ()Z
      // 06: istore 1
      // 07: istore 0
      // 08: iload 1
      // 09: ifeq 16
      // 0c: getstatic x/ocdd342096f8.ʄ Lx/ocf1568fef75;
      // 0f: invokevirtual x/ocf1568fef75.ö ()D
      // 12: goto 1c
      // 15: athrow
      // 16: getstatic x/ocdd342096f8.պ Lx/oca9cc61aada;
      // 19: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 1c: dstore 2
      // 1d: iload 1
      // 1e: ifeq 2b
      // 21: getstatic x/ocdd342096f8.ʄ Lx/ocf1568fef75;
      // 24: invokevirtual x/ocf1568fef75.і ()D
      // 27: goto 2c
      // 2a: athrow
      // 2b: dload 2
      // 2c: dstore 4
      // 2e: getstatic x/ocdd342096f8.ɜ D
      // 31: iload 0
      // 32: ifne 5d
      // 35: dload 2
      // 36: dcmpl
      // 37: ifne 53
      // 3a: goto 3e
      // 3d: athrow
      // 3e: getstatic x/ocdd342096f8.ǧ D
      // 41: iload 0
      // 42: ifne 5d
      // 45: goto 49
      // 48: athrow
      // 49: dload 4
      // 4b: dcmpl
      // 4c: ifeq 67
      // 4f: goto 53
      // 52: athrow
      // 53: dload 2
      // 54: putstatic x/ocdd342096f8.ɜ D
      // 57: dload 4
      // 59: goto 5d
      // 5c: athrow
      // 5d: putstatic x/ocdd342096f8.ǧ D
      // 60: invokestatic x/ocdd342096f8.Յ ()V
      // 63: bipush 1
      // 64: invokestatic x/ocdd342096f8.Ť (Z)V
      // 67: return
   }

   public boolean Ҭ(Packet<?> param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc5e549848f3.İ I
      // 003: istore 2
      // 004: invokestatic x/oc7c017b256e.Ԓ ()Z
      // 007: iload 2
      // 008: ifne 013
      // 00b: ifeq 014
      // 00e: goto 012
      // 011: athrow
      // 012: bipush 1
      // 013: ireturn
      // 014: invokestatic x/ocdd342096f8.Ȭ ()Lnet/minecraft/client/Minecraft;
      // 017: astore 3
      // 018: getstatic x/ocdd342096f8.ș Lx/oc8df2d0340c;
      // 01b: getstatic x/oc8df2d0340c.Ѐ Lx/oc8df2d0340c;
      // 01e: if_acmpne 024
      // 021: bipush 1
      // 022: ireturn
      // 023: athrow
      // 024: aload 1
      // 025: iload 2
      // 026: ifne 0e7
      // 029: instanceof net/minecraft/network/play/client/C09PacketHeldItemChange
      // 02c: ifeq 0e2
      // 02f: goto 033
      // 032: athrow
      // 033: getstatic x/ocdd342096f8.ș Lx/oc8df2d0340c;
      // 036: iload 2
      // 037: ifne 2f8
      // 03a: goto 03e
      // 03d: athrow
      // 03e: getfield x/oc8df2d0340c.m Z
      // 041: ifeq 2f5
      // 044: goto 048
      // 047: athrow
      // 048: aload 1
      // 049: checkcast net/minecraft/network/play/client/C09PacketHeldItemChange
      // 04c: astore 4
      // 04e: aload 3
      // 04f: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 052: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 055: aload 4
      // 057: invokevirtual net/minecraft/network/play/client/C09PacketHeldItemChange.getSlotId ()I
      // 05a: invokevirtual net/minecraft/entity/player/InventoryPlayer.getStackInSlot (I)Lnet/minecraft/item/ItemStack;
      // 05d: invokestatic x/oc7c017b256e.Ĭ (Lnet/minecraft/item/ItemStack;)Z
      // 060: iload 2
      // 061: ifne 08c
      // 064: ifeq 085
      // 067: goto 06b
      // 06a: athrow
      // 06b: aload 3
      // 06c: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 06f: getfield net/minecraft/client/settings/GameSettings.keyBindUseItem Lnet/minecraft/client/settings/KeyBinding;
      // 072: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // 075: bipush 0
      // 076: invokestatic net/minecraft/client/settings/KeyBinding.setKeyBindState (IZ)V
      // 079: iload 2
      // 07a: bipush 1
      // 07b: putstatic x/ocdd342096f8.ҁ I
      // 07e: ifeq 0de
      // 081: goto 085
      // 084: athrow
      // 085: invokestatic x/ocdd342096f8.Շ ()Z
      // 088: goto 08c
      // 08b: athrow
      // 08c: iload 2
      // 08d: ifne 09a
      // 090: ifeq 0de
      // 093: goto 097
      // 096: athrow
      // 097: invokestatic x/oc7c017b256e.Ͱ ()Z
      // 09a: ifne 0de
      // 09d: aload 3
      // 09e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0a1: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 0a4: getstatic x/oc0f63871c3b.û I
      // 0a7: invokevirtual net/minecraft/entity/player/InventoryPlayer.getStackInSlot (I)Lnet/minecraft/item/ItemStack;
      // 0aa: astore 5
      // 0ac: aload 5
      // 0ae: iload 2
      // 0af: ifne 0bb
      // 0b2: ifnull 0de
      // 0b5: goto 0b9
      // 0b8: athrow
      // 0b9: aload 5
      // 0bb: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 0be: instanceof net/minecraft/item/ItemSword
      // 0c1: iload 2
      // 0c2: ifne 0da
      // 0c5: ifeq 0de
      // 0c8: goto 0cc
      // 0cb: athrow
      // 0cc: aload 3
      // 0cd: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 0d0: getfield net/minecraft/client/settings/GameSettings.keyBindUseItem Lnet/minecraft/client/settings/KeyBinding;
      // 0d3: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // 0d6: goto 0da
      // 0d9: athrow
      // 0da: bipush 1
      // 0db: invokestatic net/minecraft/client/settings/KeyBinding.setKeyBindState (IZ)V
      // 0de: iload 2
      // 0df: ifeq 2f5
      // 0e2: aload 1
      // 0e3: goto 0e7
      // 0e6: athrow
      // 0e7: iload 2
      // 0e8: ifne 174
      // 0eb: instanceof net/minecraft/network/play/client/C08PacketPlayerBlockPlacement
      // 0ee: ifeq 16f
      // 0f1: goto 0f5
      // 0f4: athrow
      // 0f5: getstatic x/ocdd342096f8.ҁ I
      // 0f8: iload 2
      // 0f9: ifne 116
      // 0fc: goto 100
      // 0ff: athrow
      // 100: ifle 117
      // 103: goto 107
      // 106: athrow
      // 107: ldc_w 1496684484
      // 10a: ldc_w 1496684487
      // 10d: ixor
      // 10e: putstatic x/oc0f63871c3b.Ÿ I
      // 111: bipush 0
      // 112: goto 116
      // 115: athrow
      // 116: ireturn
      // 117: aload 1
      // 118: checkcast net/minecraft/network/play/client/C08PacketPlayerBlockPlacement
      // 11b: astore 4
      // 11d: aload 4
      // 11f: iload 2
      // 120: ifne 136
      // 123: invokevirtual net/minecraft/network/play/client/C08PacketPlayerBlockPlacement.getStack ()Lnet/minecraft/item/ItemStack;
      // 126: invokestatic x/oc7c017b256e.Ĭ (Lnet/minecraft/item/ItemStack;)Z
      // 129: ifeq 16b
      // 12c: goto 130
      // 12f: athrow
      // 130: aload 4
      // 132: goto 136
      // 135: athrow
      // 136: iload 2
      // 137: ifne 151
      // 13a: invokevirtual net/minecraft/network/play/client/C08PacketPlayerBlockPlacement.getPlacedBlockDirection ()I
      // 13d: ldc_w 1496684344
      // 140: ldc_w 1496684487
      // 143: ixor
      // 144: if_icmpeq 16b
      // 147: goto 14b
      // 14a: athrow
      // 14b: aload 4
      // 14d: goto 151
      // 150: athrow
      // 151: invokevirtual net/minecraft/network/play/client/C08PacketPlayerBlockPlacement.getPosition ()Lnet/minecraft/util/BlockPos;
      // 154: invokestatic x/oc7c017b256e.Ϭ (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/Block;
      // 157: astore 5
      // 159: aload 5
      // 15b: invokestatic x/oc7c017b256e.ƈ (Lnet/minecraft/block/Block;)Z
      // 15e: iload 2
      // 15f: ifne 16a
      // 162: ifne 16b
      // 165: goto 169
      // 168: athrow
      // 169: bipush 0
      // 16a: ireturn
      // 16b: iload 2
      // 16c: ifeq 2f5
      // 16f: aload 1
      // 170: goto 174
      // 173: athrow
      // 174: iload 2
      // 175: ifne 227
      // 178: instanceof net/minecraft/network/play/client/C07PacketPlayerDigging
      // 17b: ifeq 222
      // 17e: goto 182
      // 181: athrow
      // 182: aload 1
      // 183: checkcast net/minecraft/network/play/client/C07PacketPlayerDigging
      // 186: astore 4
      // 188: aload 4
      // 18a: invokevirtual net/minecraft/network/play/client/C07PacketPlayerDigging.getStatus ()Lnet/minecraft/network/play/client/C07PacketPlayerDigging$Action;
      // 18d: getstatic net/minecraft/network/play/client/C07PacketPlayerDigging$Action.RELEASE_USE_ITEM Lnet/minecraft/network/play/client/C07PacketPlayerDigging$Action;
      // 190: if_acmpne 1eb
      // 193: getstatic x/ocdd342096f8.ϟ Z
      // 196: iload 2
      // 197: ifne 1af
      // 19a: goto 19e
      // 19d: athrow
      // 19e: ifne 21e
      // 1a1: goto 1a5
      // 1a4: athrow
      // 1a5: getstatic x/ocdd342096f8.ș Lx/oc8df2d0340c;
      // 1a8: getfield x/oc8df2d0340c.m Z
      // 1ab: goto 1af
      // 1ae: athrow
      // 1af: iload 2
      // 1b0: ifne 1bd
      // 1b3: ifeq 21e
      // 1b6: goto 1ba
      // 1b9: athrow
      // 1ba: invokestatic x/oc7c017b256e.Э ()Z
      // 1bd: iload 2
      // 1be: ifne 1d3
      // 1c1: ifeq 21e
      // 1c4: goto 1c8
      // 1c7: athrow
      // 1c8: aload 3
      // 1c9: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1cc: getfield net/minecraft/client/entity/EntityPlayerSP.ticksExisted I
      // 1cf: goto 1d3
      // 1d2: athrow
      // 1d3: iload 2
      // 1d4: ifne 1ea
      // 1d7: getstatic x/ocdd342096f8.ʪ I
      // 1da: if_icmpeq 21e
      // 1dd: goto 1e1
      // 1e0: athrow
      // 1e1: bipush 0
      // 1e2: putstatic x/oc0f63871c3b.Ÿ I
      // 1e5: bipush 0
      // 1e6: goto 1ea
      // 1e9: athrow
      // 1ea: ireturn
      // 1eb: getstatic x/ocdd342096f8.Վ Z
      // 1ee: ifeq 21e
      // 1f1: aload 4
      // 1f3: iload 2
      // 1f4: ifne 20e
      // 1f7: goto 1fb
      // 1fa: athrow
      // 1fb: invokevirtual net/minecraft/network/play/client/C07PacketPlayerDigging.getStatus ()Lnet/minecraft/network/play/client/C07PacketPlayerDigging$Action;
      // 1fe: getstatic net/minecraft/network/play/client/C07PacketPlayerDigging$Action.ABORT_DESTROY_BLOCK Lnet/minecraft/network/play/client/C07PacketPlayerDigging$Action;
      // 201: if_acmpeq 217
      // 204: goto 208
      // 207: athrow
      // 208: aload 4
      // 20a: goto 20e
      // 20d: athrow
      // 20e: invokevirtual net/minecraft/network/play/client/C07PacketPlayerDigging.getStatus ()Lnet/minecraft/network/play/client/C07PacketPlayerDigging$Action;
      // 211: getstatic net/minecraft/network/play/client/C07PacketPlayerDigging$Action.STOP_DESTROY_BLOCK Lnet/minecraft/network/play/client/C07PacketPlayerDigging$Action;
      // 214: if_acmpne 21e
      // 217: bipush 0
      // 218: putstatic x/ocdd342096f8.Վ Z
      // 21b: bipush 0
      // 21c: ireturn
      // 21d: athrow
      // 21e: iload 2
      // 21f: ifeq 2f5
      // 222: aload 1
      // 223: goto 227
      // 226: athrow
      // 227: instanceof net/minecraft/network/play/client/C02PacketUseEntity
      // 22a: iload 2
      // 22b: ifne 2fb
      // 22e: ifeq 2f5
      // 231: goto 235
      // 234: athrow
      // 235: aload 1
      // 236: checkcast net/minecraft/network/play/client/C02PacketUseEntity
      // 239: astore 4
      // 23b: getstatic x/ocdd342096f8.ĕ Lx/oc59dbd08e27;
      // 23e: ifnonnull 28d
      // 241: getstatic x/ocdd342096f8.ș Lx/oc8df2d0340c;
      // 244: iload 2
      // 245: ifne 2f8
      // 248: goto 24c
      // 24b: athrow
      // 24c: getfield x/oc8df2d0340c.m Z
      // 24f: ifeq 2f5
      // 252: goto 256
      // 255: athrow
      // 256: getstatic x/ocdd342096f8.Г I
      // 259: iload 2
      // 25a: ifne 2fb
      // 25d: goto 261
      // 260: athrow
      // 261: bipush -1
      // 262: if_icmpne 2f5
      // 265: goto 269
      // 268: athrow
      // 269: getstatic x/ocdd342096f8.ҁ I
      // 26c: iload 2
      // 26d: ifne 2fb
      // 270: goto 274
      // 273: athrow
      // 274: ifle 2f5
      // 277: goto 27b
      // 27a: athrow
      // 27b: aload 4
      // 27d: invokevirtual net/minecraft/network/play/client/C02PacketUseEntity.getAction ()Lnet/minecraft/network/play/client/C02PacketUseEntity$Action;
      // 280: getstatic net/minecraft/network/play/client/C02PacketUseEntity$Action.ATTACK Lnet/minecraft/network/play/client/C02PacketUseEntity$Action;
      // 283: if_acmpeq 2f5
      // 286: goto 28a
      // 289: athrow
      // 28a: bipush 0
      // 28b: ireturn
      // 28c: athrow
      // 28d: getstatic x/ocdd342096f8.ș Lx/oc8df2d0340c;
      // 290: iload 2
      // 291: ifne 2f8
      // 294: getfield x/oc8df2d0340c.m Z
      // 297: ifeq 2f5
      // 29a: goto 29e
      // 29d: athrow
      // 29e: aload 4
      // 2a0: invokevirtual net/minecraft/network/play/client/C02PacketUseEntity.getAction ()Lnet/minecraft/network/play/client/C02PacketUseEntity$Action;
      // 2a3: getstatic net/minecraft/network/play/client/C02PacketUseEntity$Action.ATTACK Lnet/minecraft/network/play/client/C02PacketUseEntity$Action;
      // 2a6: if_acmpne 2dd
      // 2a9: goto 2ad
      // 2ac: athrow
      // 2ad: getstatic x/ocdd342096f8.ư Z
      // 2b0: iload 2
      // 2b1: ifne 2fb
      // 2b4: goto 2b8
      // 2b7: athrow
      // 2b8: ifne 2f5
      // 2bb: goto 2bf
      // 2be: athrow
      // 2bf: aload 4
      // 2c1: aload 3
      // 2c2: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 2c5: invokevirtual net/minecraft/network/play/client/C02PacketUseEntity.getEntityFromWorld (Lnet/minecraft/world/World;)Lnet/minecraft/entity/Entity;
      // 2c8: instanceof net/minecraft/entity/projectile/EntityFireball
      // 2cb: iload 2
      // 2cc: ifne 2fb
      // 2cf: goto 2d3
      // 2d2: athrow
      // 2d3: ifne 2f5
      // 2d6: goto 2da
      // 2d9: athrow
      // 2da: bipush 0
      // 2db: ireturn
      // 2dc: athrow
      // 2dd: getstatic x/ocdd342096f8.ș Lx/oc8df2d0340c;
      // 2e0: iload 2
      // 2e1: ifne 2f8
      // 2e4: getfield x/oc8df2d0340c.Ű Z
      // 2e7: ifne 2f5
      // 2ea: goto 2ee
      // 2ed: athrow
      // 2ee: bipush 1
      // 2ef: putstatic x/ocdd342096f8.ҁ I
      // 2f2: bipush 0
      // 2f3: ireturn
      // 2f4: athrow
      // 2f5: getstatic x/ocdd342096f8.ș Lx/oc8df2d0340c;
      // 2f8: getfield x/oc8df2d0340c.Թ Z
      // 2fb: iload 2
      // 2fc: ifne 437
      // 2ff: ifeq 436
      // 302: goto 306
      // 305: athrow
      // 306: aload 3
      // 307: invokevirtual net/minecraft/client/Minecraft.isSingleplayer ()Z
      // 30a: iload 2
      // 30b: ifne 437
      // 30e: goto 312
      // 311: athrow
      // 312: ifne 436
      // 315: goto 319
      // 318: athrow
      // 319: getstatic x/ocdd342096f8.Ԉ Z
      // 31c: iload 2
      // 31d: ifne 345
      // 320: goto 324
      // 323: athrow
      // 324: ifne 342
      // 327: goto 32b
      // 32a: athrow
      // 32b: getstatic x/ocdd342096f8.Ғ Ljava/util/List;
      // 32e: invokeinterface java/util/List.isEmpty ()Z 1
      // 333: iload 2
      // 334: ifne 437
      // 337: goto 33b
      // 33a: athrow
      // 33b: ifne 436
      // 33e: goto 342
      // 341: athrow
      // 342: getstatic x/ocdd342096f8.Г I
      // 345: iload 2
      // 346: ifne 376
      // 349: bipush -1
      // 34a: if_icmpeq 36f
      // 34d: goto 351
      // 350: athrow
      // 351: aload 1
      // 352: instanceof net/minecraft/network/play/client/C08PacketPlayerBlockPlacement
      // 355: iload 2
      // 356: ifne 376
      // 359: goto 35d
      // 35c: athrow
      // 35d: ifeq 36f
      // 360: goto 364
      // 363: athrow
      // 364: aload 1
      // 365: getstatic x/oc0f63871c3b.ӻ Lnet/minecraft/network/Packet;
      // 368: if_acmpne 436
      // 36b: goto 36f
      // 36e: athrow
      // 36f: getstatic x/ocdd342096f8.Г I
      // 372: goto 376
      // 375: athrow
      // 376: iload 2
      // 377: ifne 416
      // 37a: lookupswitch 135 2 -1 27 1 100
      // 394: athrow
      // 395: aload 1
      // 396: instanceof net/minecraft/network/play/client/C03PacketPlayer
      // 399: iload 2
      // 39a: ifne 3c4
      // 39d: goto 3a1
      // 3a0: athrow
      // 3a1: ifeq 3b8
      // 3a4: goto 3a8
      // 3a7: athrow
      // 3a8: bipush 1
      // 3a9: invokestatic x/ocdd342096f8.ζ (Z)V
      // 3ac: iload 2
      // 3ad: bipush 0
      // 3ae: putstatic x/ocdd342096f8.Ԉ Z
      // 3b1: ifeq 3dc
      // 3b4: goto 3b8
      // 3b7: athrow
      // 3b8: getstatic x/ocdd342096f8.Ғ Ljava/util/List;
      // 3bb: invokeinterface java/util/List.isEmpty ()Z 1
      // 3c0: goto 3c4
      // 3c3: athrow
      // 3c4: iload 2
      // 3c5: ifne 3dd
      // 3c8: ifne 3dc
      // 3cb: goto 3cf
      // 3ce: athrow
      // 3cf: getstatic x/ocdd342096f8.Ғ Ljava/util/List;
      // 3d2: aload 1
      // 3d3: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 3d8: pop
      // 3d9: bipush 0
      // 3da: ireturn
      // 3db: athrow
      // 3dc: bipush 1
      // 3dd: ireturn
      // 3de: getstatic x/ocdd342096f8.Ғ Ljava/util/List;
      // 3e1: aload 1
      // 3e2: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 3e7: iload 2
      // 3e8: ifne 400
      // 3eb: pop
      // 3ec: aload 1
      // 3ed: instanceof net/minecraft/network/play/client/C03PacketPlayer
      // 3f0: ifeq 3ff
      // 3f3: goto 3f7
      // 3f6: athrow
      // 3f7: bipush 0
      // 3f8: invokestatic x/ocdd342096f8.ζ (Z)V
      // 3fb: goto 3ff
      // 3fe: athrow
      // 3ff: bipush 0
      // 400: ireturn
      // 401: getstatic x/ocdd342096f8.Ғ Ljava/util/List;
      // 404: aload 1
      // 405: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 40a: iload 2
      // 40b: ifne 435
      // 40e: pop
      // 40f: getstatic x/ocdd342096f8.Ԉ Z
      // 412: goto 416
      // 415: athrow
      // 416: ifne 434
      // 419: aload 1
      // 41a: instanceof net/minecraft/network/play/client/C03PacketPlayer
      // 41d: iload 2
      // 41e: ifne 435
      // 421: goto 425
      // 424: athrow
      // 425: ifeq 434
      // 428: goto 42c
      // 42b: athrow
      // 42c: bipush 1
      // 42d: invokestatic x/ocdd342096f8.ζ (Z)V
      // 430: goto 434
      // 433: athrow
      // 434: bipush 0
      // 435: ireturn
      // 436: bipush 1
      // 437: ireturn
   }

   private static float[] Ǭ() {
      int var0 = oc5e549848f3.İ;

      try {
         if (var0 != 0) {
            return oc7c017b256e.ҭ(Ʉ);
         }

         if (Ʉ == null) {
            return oc7c017b256e.ɬ(ĕ.Ԍ);
         }
      } catch (ocbde1165e4e var1) {
         throw var1;
      }

      return oc7c017b256e.ҭ(Ʉ);
   }

   public boolean Ƞ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: invokestatic x/oc7c017b256e.Ԓ ()Z
      // 03: ifne 2b
      // 06: getstatic x/ocdd342096f8.ș Lx/oc8df2d0340c;
      // 09: getfield x/oc8df2d0340c.m Z
      // 0c: ifeq 2b
      // 0f: goto 13
      // 12: athrow
      // 13: getstatic x/oc0f63871c3b.Ԝ I
      // 16: bipush 1
      // 17: if_icmple 2b
      // 1a: goto 1e
      // 1d: athrow
      // 1e: getstatic x/oc0f63871c3b.ċ I
      // 21: getstatic x/oc0f63871c3b.Ӄ I
      // 24: if_icmpeq 30
      // 27: goto 2b
      // 2a: athrow
      // 2b: bipush 1
      // 2c: goto 31
      // 2f: athrow
      // 30: bipush 0
      // 31: ireturn
   }

   @oc66fa4f2195
   public void ɳ(oc9adb807c19 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: invokestatic x/ocdd342096f8.Ȭ ()Lnet/minecraft/client/Minecraft;
      // 06: astore 3
      // 07: istore 2
      // 08: getstatic x/ocdd342096f8.ș Lx/oc8df2d0340c;
      // 0b: getfield x/oc8df2d0340c.Թ Z
      // 0e: iload 2
      // 0f: ifne 1c
      // 12: ifeq 55
      // 15: goto 19
      // 18: athrow
      // 19: getstatic x/ocdd342096f8.Г I
      // 1c: bipush -1
      // 1d: if_icmpeq 55
      // 20: aload 3
      // 21: iload 2
      // 22: ifne 38
      // 25: goto 29
      // 28: athrow
      // 29: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 2c: ifnull 49
      // 2f: goto 33
      // 32: athrow
      // 33: aload 3
      // 34: goto 38
      // 37: athrow
      // 38: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 3b: instanceof net/minecraft/client/gui/GuiGameOver
      // 3e: iload 2
      // 3f: ifne 4a
      // 42: ifeq 55
      // 45: goto 49
      // 48: athrow
      // 49: bipush -1
      // 4a: putstatic x/ocdd342096f8.Г I
      // 4d: getstatic x/ocdd342096f8.Ғ Ljava/util/List;
      // 50: invokeinterface java/util/List.clear ()V 1
      // 55: return
   }

   private static void ȃ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc5e549848f3.İ I
      // 003: invokestatic x/ocdd342096f8.Ȭ ()Lnet/minecraft/client/Minecraft;
      // 006: astore 1
      // 007: istore 0
      // 008: getstatic x/ocdd342096f8.ʤ Lx/occ2f8dff8d8;
      // 00b: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 00e: iload 0
      // 00f: ifne 038
      // 012: ifeq 035
      // 015: goto 019
      // 018: athrow
      // 019: invokestatic x/oc7c017b256e.Ͻ ()Z
      // 01c: iload 0
      // 01d: ifne 038
      // 020: goto 024
      // 023: athrow
      // 024: ifne 035
      // 027: goto 02b
      // 02a: athrow
      // 02b: aconst_null
      // 02c: invokestatic x/ocdd342096f8.γ (Lnet/minecraft/entity/Entity;)V
      // 02f: bipush 0
      // 030: putstatic x/ocdd342096f8.Ԣ Z
      // 033: return
      // 034: athrow
      // 035: invokestatic x/oc7c017b256e.ę ()Z
      // 038: iload 0
      // 039: ifne 04c
      // 03c: ifeq 049
      // 03f: goto 043
      // 042: athrow
      // 043: aconst_null
      // 044: invokestatic x/ocdd342096f8.γ (Lnet/minecraft/entity/Entity;)V
      // 047: return
      // 048: athrow
      // 049: invokestatic x/oc7c017b256e.Ͱ ()Z
      // 04c: iload 0
      // 04d: ifne 05a
      // 050: ifeq 07b
      // 053: goto 057
      // 056: athrow
      // 057: invokestatic x/oc7c017b256e.Ж ()Z
      // 05a: iload 0
      // 05b: ifne 068
      // 05e: ifeq 07b
      // 061: goto 065
      // 064: athrow
      // 065: getstatic x/oc0f63871c3b.ċ I
      // 068: aload 1
      // 069: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 06c: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 06f: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 072: if_icmpeq 07b
      // 075: aconst_null
      // 076: invokestatic x/ocdd342096f8.γ (Lnet/minecraft/entity/Entity;)V
      // 079: return
      // 07a: athrow
      // 07b: ldc2_w -1.0
      // 07e: dstore 2
      // 07f: aconst_null
      // 080: astore 4
      // 082: new java/util/ArrayList
      // 085: dup
      // 086: invokespecial java/util/ArrayList.<init> ()V
      // 089: astore 5
      // 08b: new java/util/HashSet
      // 08e: dup
      // 08f: invokespecial java/util/HashSet.<init> ()V
      // 092: astore 6
      // 094: aload 1
      // 095: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 098: getfield net/minecraft/client/multiplayer/WorldClient.loadedEntityList Ljava/util/List;
      // 09b: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 0a0: astore 7
      // 0a2: aload 7
      // 0a4: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0a9: ifeq 2c7
      // 0ac: aload 7
      // 0ae: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0b3: checkcast net/minecraft/entity/Entity
      // 0b6: astore 8
      // 0b8: aload 8
      // 0ba: iload 0
      // 0bb: ifne 0d2
      // 0be: instanceof net/minecraft/entity/EntityLivingBase
      // 0c1: ifne 0d0
      // 0c4: goto 0c8
      // 0c7: athrow
      // 0c8: iload 0
      // 0c9: ifeq 0a2
      // 0cc: goto 0d0
      // 0cf: athrow
      // 0d0: aload 8
      // 0d2: checkcast net/minecraft/entity/EntityLivingBase
      // 0d5: astore 9
      // 0d7: aload 9
      // 0d9: iload 0
      // 0da: ifne 0ea
      // 0dd: aload 1
      // 0de: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0e1: if_acmpeq 0a2
      // 0e4: goto 0e8
      // 0e7: athrow
      // 0e8: aload 9
      // 0ea: getfield net/minecraft/entity/EntityLivingBase.deathTime I
      // 0ed: iload 0
      // 0ee: ifne 101
      // 0f1: ifeq 0fb
      // 0f4: goto 0f8
      // 0f7: athrow
      // 0f8: goto 0a2
      // 0fb: getstatic x/ocdd342096f8.λ Lx/occ2f8dff8d8;
      // 0fe: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 101: iload 0
      // 102: ifne 129
      // 105: ifne 124
      // 108: goto 10c
      // 10b: athrow
      // 10c: aload 9
      // 10e: iload 0
      // 10f: ifne 126
      // 112: goto 116
      // 115: athrow
      // 116: invokestatic x/oc7c017b256e.ў (Lnet/minecraft/entity/EntityLivingBase;)Z
      // 119: ifeq 124
      // 11c: goto 120
      // 11f: athrow
      // 120: goto 0a2
      // 123: athrow
      // 124: aload 9
      // 126: instanceof net/minecraft/entity/player/EntityPlayer
      // 129: istore 10
      // 12b: iload 10
      // 12d: iload 0
      // 12e: ifne 152
      // 131: ifeq 14c
      // 134: goto 138
      // 137: athrow
      // 138: getstatic x/ocdd342096f8.Ü Lx/occ2f8dff8d8;
      // 13b: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 13e: iload 0
      // 13f: ifne 0a9
      // 142: goto 146
      // 145: athrow
      // 146: ifeq 0a2
      // 149: goto 180
      // 14c: getstatic x/ocdd342096f8.ʎ Lx/occ2f8dff8d8;
      // 14f: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 152: iload 0
      // 153: ifne 16a
      // 156: ifeq 0a2
      // 159: goto 15d
      // 15c: athrow
      // 15d: aload 9
      // 15f: iload 0
      // 160: ifne 16f
      // 163: invokestatic x/oc7c017b256e.Ȣ (Lnet/minecraft/entity/Entity;)Z
      // 166: goto 16a
      // 169: athrow
      // 16a: ifeq 0a2
      // 16d: aload 9
      // 16f: invokestatic x/oc7ab2161b9f.ӥ (Lnet/minecraft/entity/Entity;)Z
      // 172: iload 0
      // 173: ifne 18a
      // 176: ifeq 180
      // 179: goto 17d
      // 17c: athrow
      // 17d: goto 0a2
      // 180: aload 6
      // 182: aload 9
      // 184: invokevirtual net/minecraft/entity/EntityLivingBase.getUniqueID ()Ljava/util/UUID;
      // 187: invokevirtual java/util/HashSet.contains (Ljava/lang/Object;)Z
      // 18a: ifeq 190
      // 18d: goto 0a2
      // 190: aload 1
      // 191: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 194: aload 9
      // 196: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getDistanceSqToEntity (Lnet/minecraft/entity/Entity;)D
      // 199: dstore 11
      // 19b: dload 11
      // 19d: iload 0
      // 19e: ifne 1b6
      // 1a1: getstatic x/ocdd342096f8.Ή D
      // 1a4: dcmpl
      // 1a5: ifle 1b0
      // 1a8: goto 1ac
      // 1ab: athrow
      // 1ac: goto 0a2
      // 1af: athrow
      // 1b0: getstatic x/ocdd342096f8.ř Lx/oca9cc61aada;
      // 1b3: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 1b6: ldc2_w 360.0
      // 1b9: dcmpl
      // 1ba: iload 0
      // 1bb: ifne 1ea
      // 1be: ifeq 1e8
      // 1c1: goto 1c5
      // 1c4: athrow
      // 1c5: getstatic x/ocdd342096f8.ř Lx/oca9cc61aada;
      // 1c8: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 1cb: d2f
      // 1cc: aload 9
      // 1ce: invokestatic x/oc7c017b256e.Ǳ (FLnet/minecraft/entity/Entity;)Z
      // 1d1: iload 0
      // 1d2: ifne 1ea
      // 1d5: goto 1d9
      // 1d8: athrow
      // 1d9: ifne 1e8
      // 1dc: goto 1e0
      // 1df: athrow
      // 1e0: iload 0
      // 1e1: ifeq 0a2
      // 1e4: goto 1e8
      // 1e7: athrow
      // 1e8: iload 10
      // 1ea: iload 0
      // 1eb: ifne 251
      // 1ee: ifeq 24b
      // 1f1: goto 1f5
      // 1f4: athrow
      // 1f5: aload 9
      // 1f7: checkcast net/minecraft/entity/player/EntityPlayer
      // 1fa: astore 13
      // 1fc: aload 13
      // 1fe: iload 0
      // 1ff: ifne 212
      // 202: invokestatic x/oc7c017b256e.Ӿ (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // 205: ifeq 210
      // 208: goto 20c
      // 20b: athrow
      // 20c: goto 0a2
      // 20f: athrow
      // 210: aload 13
      // 212: invokestatic x/oca4f99d2d44.Λ (Lnet/minecraft/entity/Entity;)Z
      // 215: iload 0
      // 216: ifne 231
      // 219: ifeq 223
      // 21c: goto 220
      // 21f: athrow
      // 220: goto 0a2
      // 223: getstatic x/ocdd342096f8.ҵ Lx/occ2f8dff8d8;
      // 226: iload 0
      // 227: ifne 24e
      // 22a: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 22d: goto 231
      // 230: athrow
      // 231: ifeq 24b
      // 234: aload 13
      // 236: invokestatic x/oc7ab2161b9f.ӥ (Lnet/minecraft/entity/Entity;)Z
      // 239: iload 0
      // 23a: ifne 251
      // 23d: goto 241
      // 240: athrow
      // 241: ifeq 24b
      // 244: goto 248
      // 247: athrow
      // 248: goto 0a2
      // 24b: getstatic x/ocdd342096f8.Ѱ Lx/occ2f8dff8d8;
      // 24e: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 251: iload 0
      // 252: ifne 29c
      // 255: ifne 284
      // 258: goto 25c
      // 25b: athrow
      // 25c: aload 9
      // 25e: invokestatic x/oc7c017b256e.Ѩ (Lnet/minecraft/entity/Entity;)Lnet/minecraft/util/Vec3;
      // 261: astore 13
      // 263: aload 13
      // 265: iload 0
      // 266: ifne 283
      // 269: ifnonnull 273
      // 26c: goto 270
      // 26f: athrow
      // 270: goto 0a2
      // 273: getstatic x/ocdd342096f8.ǉ Ljava/util/HashMap;
      // 276: aload 9
      // 278: invokevirtual net/minecraft/entity/EntityLivingBase.getEntityId ()I
      // 27b: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 27e: aload 13
      // 280: invokevirtual java/util/HashMap.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 283: pop
      // 284: aload 6
      // 286: aload 9
      // 288: invokevirtual net/minecraft/entity/EntityLivingBase.getUniqueID ()Ljava/util/UUID;
      // 28b: invokevirtual java/util/HashSet.add (Ljava/lang/Object;)Z
      // 28e: pop
      // 28f: iload 0
      // 290: ifne 2b5
      // 293: dload 2
      // 294: ldc2_w -1.0
      // 297: dcmpl
      // 298: goto 29c
      // 29b: athrow
      // 29c: ifeq 2b2
      // 29f: dload 2
      // 2a0: dload 11
      // 2a2: dcmpl
      // 2a3: iload 0
      // 2a4: ifne 2c2
      // 2a7: goto 2ab
      // 2aa: athrow
      // 2ab: ifle 2b9
      // 2ae: goto 2b2
      // 2b1: athrow
      // 2b2: dload 11
      // 2b4: dstore 2
      // 2b5: aload 9
      // 2b7: astore 4
      // 2b9: aload 5
      // 2bb: aload 9
      // 2bd: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 2c2: pop
      // 2c3: iload 0
      // 2c4: ifeq 0a2
      // 2c7: aconst_null
      // 2c8: astore 7
      // 2ca: getstatic x/ocdd342096f8.Ҙ D
      // 2cd: getstatic x/ocdd342096f8.Ա D
      // 2d0: dcmpl
      // 2d1: iload 0
      // 2d2: ifne 2dd
      // 2d5: ifne 2e0
      // 2d8: goto 2dc
      // 2db: athrow
      // 2dc: bipush 1
      // 2dd: goto 2e1
      // 2e0: bipush 0
      // 2e1: istore 8
      // 2e3: aload 5
      // 2e5: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 2ea: astore 9
      // 2ec: aload 9
      // 2ee: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 2f3: ifeq 397
      // 2f6: iload 0
      // 2f7: ifne 3a8
      // 2fa: goto 2fe
      // 2fd: athrow
      // 2fe: aload 9
      // 300: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 305: checkcast net/minecraft/entity/EntityLivingBase
      // 308: astore 10
      // 30a: aload 7
      // 30c: ifnonnull 373
      // 30f: aload 10
      // 311: getstatic x/ocdd342096f8.Ҙ D
      // 314: invokestatic x/oc7c017b256e.ˤ (Lnet/minecraft/entity/Entity;D)Z
      // 317: iload 0
      // 318: ifne 337
      // 31b: goto 31f
      // 31e: athrow
      // 31f: ifne 335
      // 322: goto 326
      // 325: athrow
      // 326: aload 9
      // 328: invokeinterface java/util/Iterator.remove ()V 1
      // 32d: iload 0
      // 32e: ifeq 2ec
      // 331: goto 335
      // 334: athrow
      // 335: iload 8
      // 337: iload 0
      // 338: ifne 36e
      // 33b: ifne 35c
      // 33e: goto 342
      // 341: athrow
      // 342: aload 10
      // 344: getstatic x/ocdd342096f8.Ա D
      // 347: invokestatic x/oc7c017b256e.ˤ (Lnet/minecraft/entity/Entity;D)Z
      // 34a: iload 0
      // 34b: ifne 36e
      // 34e: goto 352
      // 351: athrow
      // 352: ifne 35c
      // 355: goto 359
      // 358: athrow
      // 359: goto 2ec
      // 35c: new java/util/ArrayList
      // 35f: dup
      // 360: invokespecial java/util/ArrayList.<init> ()V
      // 363: astore 7
      // 365: aload 7
      // 367: aload 10
      // 369: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 36e: pop
      // 36f: iload 0
      // 370: ifeq 2ec
      // 373: aload 10
      // 375: getstatic x/ocdd342096f8.Ա D
      // 378: invokestatic x/oc7c017b256e.ˤ (Lnet/minecraft/entity/Entity;D)Z
      // 37b: iload 0
      // 37c: ifne 392
      // 37f: ifne 389
      // 382: goto 386
      // 385: athrow
      // 386: goto 2ec
      // 389: aload 7
      // 38b: aload 10
      // 38d: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 392: pop
      // 393: iload 0
      // 394: ifeq 2ec
      // 397: aload 7
      // 399: iload 0
      // 39a: ifne 3aa
      // 39d: ifnull 3a8
      // 3a0: goto 3a4
      // 3a3: athrow
      // 3a4: aload 7
      // 3a6: astore 5
      // 3a8: aload 5
      // 3aa: invokeinterface java/util/List.isEmpty ()Z 1
      // 3af: ifeq 405
      // 3b2: aload 4
      // 3b4: ifnull 3f9
      // 3b7: goto 3bb
      // 3ba: athrow
      // 3bb: getstatic x/ocdd342096f8.ӣ D
      // 3be: getstatic x/ocdd342096f8.Ҙ D
      // 3c1: dcmpl
      // 3c2: iload 0
      // 3c3: ifne 3e5
      // 3c6: goto 3ca
      // 3c9: athrow
      // 3ca: ifle 3f9
      // 3cd: goto 3d1
      // 3d0: athrow
      // 3d1: aload 4
      // 3d3: iload 0
      // 3d4: ifne 3f2
      // 3d7: goto 3db
      // 3da: athrow
      // 3db: getstatic x/ocdd342096f8.ӣ D
      // 3de: invokestatic x/oc7c017b256e.ˤ (Lnet/minecraft/entity/Entity;D)Z
      // 3e1: goto 3e5
      // 3e4: athrow
      // 3e5: ifeq 3f9
      // 3e8: bipush 0
      // 3e9: putstatic x/ocdd342096f8.į Z
      // 3ec: aload 4
      // 3ee: goto 3f2
      // 3f1: athrow
      // 3f2: invokestatic x/ocdd342096f8.γ (Lnet/minecraft/entity/Entity;)V
      // 3f5: iload 0
      // 3f6: ifeq 5f9
      // 3f9: aconst_null
      // 3fa: invokestatic x/ocdd342096f8.γ (Lnet/minecraft/entity/Entity;)V
      // 3fd: iload 0
      // 3fe: ifeq 5f9
      // 401: goto 405
      // 404: athrow
      // 405: aconst_null
      // 406: astore 10
      // 408: getstatic x/oc58959f21df.զ [I
      // 40b: getstatic x/ocdd342096f8.Ž Lx/oca547efbd9f;
      // 40e: invokevirtual java/lang/Enum.ordinal ()I
      // 411: iaload
      // 412: tableswitch 79 1 4 30 43 56 69
      // 430: invokedynamic applyAsDouble ()Ljava/util/function/ToDoubleFunction; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)D, x/ocdd342096f8.Ƽ (Lnet/minecraft/entity/EntityLivingBase;)D, (Lnet/minecraft/entity/EntityLivingBase;)D ]
      // 435: invokestatic java/util/Comparator.comparingDouble (Ljava/util/function/ToDoubleFunction;)Ljava/util/Comparator;
      // 438: astore 10
      // 43a: goto 461
      // 43d: invokedynamic applyAsDouble ()Ljava/util/function/ToDoubleFunction; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)D, net/minecraft/entity/EntityLivingBase.getHealth ()F, (Lnet/minecraft/entity/EntityLivingBase;)D ]
      // 442: invokestatic java/util/Comparator.comparingDouble (Ljava/util/function/ToDoubleFunction;)Ljava/util/Comparator;
      // 445: astore 10
      // 447: goto 461
      // 44a: invokedynamic applyAsDouble ()Ljava/util/function/ToDoubleFunction; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)D, x/ocdd342096f8.Ѝ (Lnet/minecraft/entity/EntityLivingBase;)D, (Lnet/minecraft/entity/EntityLivingBase;)D ]
      // 44f: invokestatic java/util/Comparator.comparingDouble (Ljava/util/function/ToDoubleFunction;)Ljava/util/Comparator;
      // 452: astore 10
      // 454: goto 461
      // 457: invokedynamic applyAsDouble ()Ljava/util/function/ToDoubleFunction; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)D, x/ocdd342096f8.Ȳ (Lnet/minecraft/entity/EntityLivingBase;)D, (Lnet/minecraft/entity/EntityLivingBase;)D ]
      // 45c: invokestatic java/util/Comparator.comparingDouble (Ljava/util/function/ToDoubleFunction;)Ljava/util/Comparator;
      // 45f: astore 10
      // 461: aload 5
      // 463: aload 10
      // 465: invokeinterface java/util/List.sort (Ljava/util/Comparator;)V 2
      // 46a: ldc2_w -1359708746418485436
      // 46d: ldc2_w -1359708746418485294
      // 470: lxor
      // 471: lstore 11
      // 473: invokestatic java/lang/System.currentTimeMillis ()J
      // 476: lstore 13
      // 478: aload 5
      // 47a: invokeinterface java/util/List.size ()I 1
      // 47f: ldc_w -408280494
      // 482: ldc_w -408280495
      // 485: ixor
      // 486: invokestatic java/lang/Math.min (II)I
      // 489: i2l
      // 48a: lload 11
      // 48c: lmul
      // 48d: lstore 15
      // 48f: aconst_null
      // 490: astore 17
      // 492: aload 5
      // 494: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 499: astore 18
      // 49b: aload 18
      // 49d: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 4a2: ifeq 560
      // 4a5: aload 18
      // 4a7: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 4ac: checkcast net/minecraft/entity/EntityLivingBase
      // 4af: astore 19
      // 4b1: iload 0
      // 4b2: ifne 5f9
      // 4b5: aload 19
      // 4b7: invokevirtual net/minecraft/entity/EntityLivingBase.getUniqueID ()Ljava/util/UUID;
      // 4ba: astore 20
      // 4bc: getstatic x/ocdd342096f8.Ě Ljava/util/HashMap;
      // 4bf: aload 20
      // 4c1: invokevirtual java/util/HashMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 4c4: checkcast java/lang/Long
      // 4c7: astore 21
      // 4c9: aload 21
      // 4cb: iload 0
      // 4cc: ifne 4db
      // 4cf: ifnonnull 4d9
      // 4d2: goto 4d6
      // 4d5: athrow
      // 4d6: goto 49b
      // 4d9: aload 21
      // 4db: invokevirtual java/lang/Long.longValue ()J
      // 4de: iload 0
      // 4df: ifne 54a
      // 4e2: lconst_0
      // 4e3: lcmp
      // 4e4: ifle 53e
      // 4e7: goto 4eb
      // 4ea: athrow
      // 4eb: lload 13
      // 4ed: aload 21
      // 4ef: invokevirtual java/lang/Long.longValue ()J
      // 4f2: lsub
      // 4f3: invokestatic java/lang/Math.abs (J)J
      // 4f6: lload 11
      // 4f8: iload 0
      // 4f9: ifne 513
      // 4fc: goto 500
      // 4ff: athrow
      // 500: lcmp
      // 501: ifge 50f
      // 504: goto 508
      // 507: athrow
      // 508: aload 19
      // 50a: astore 17
      // 50c: goto 560
      // 50f: lload 15
      // 511: lload 11
      // 513: lcmp
      // 514: ifeq 531
      // 517: getstatic x/ocdd342096f8.Ě Ljava/util/HashMap;
      // 51a: aload 20
      // 51c: aload 21
      // 51e: invokevirtual java/lang/Long.longValue ()J
      // 521: lneg
      // 522: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 525: invokevirtual java/util/HashMap.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 528: pop
      // 529: iload 0
      // 52a: ifeq 49b
      // 52d: goto 531
      // 530: athrow
      // 531: getstatic x/ocdd342096f8.Ě Ljava/util/HashMap;
      // 534: aload 20
      // 536: invokevirtual java/util/HashMap.remove (Ljava/lang/Object;)Ljava/lang/Object;
      // 539: pop
      // 53a: iload 0
      // 53b: ifeq 49b
      // 53e: lload 13
      // 540: aload 21
      // 542: invokevirtual java/lang/Long.longValue ()J
      // 545: lneg
      // 546: lsub
      // 547: invokestatic java/lang/Math.abs (J)J
      // 54a: lload 15
      // 54c: lcmp
      // 54d: ifge 554
      // 550: goto 49b
      // 553: athrow
      // 554: getstatic x/ocdd342096f8.Ě Ljava/util/HashMap;
      // 557: aload 20
      // 559: invokevirtual java/util/HashMap.remove (Ljava/lang/Object;)Ljava/lang/Object;
      // 55c: pop
      // 55d: goto 49b
      // 560: aload 17
      // 562: iload 0
      // 563: ifne 5f6
      // 566: ifnonnull 5f0
      // 569: goto 56d
      // 56c: athrow
      // 56d: aload 5
      // 56f: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 574: astore 18
      // 576: aload 18
      // 578: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 57d: ifeq 5c6
      // 580: aload 18
      // 582: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 587: checkcast net/minecraft/entity/EntityLivingBase
      // 58a: astore 19
      // 58c: iload 0
      // 58d: ifne 5f4
      // 590: getstatic x/ocdd342096f8.Ě Ljava/util/HashMap;
      // 593: aload 19
      // 595: iload 0
      // 596: ifne 5b3
      // 599: goto 59d
      // 59c: athrow
      // 59d: invokevirtual net/minecraft/entity/EntityLivingBase.getUniqueID ()Ljava/util/UUID;
      // 5a0: invokevirtual java/util/HashMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 5a3: ifnull 5ae
      // 5a6: goto 5aa
      // 5a9: athrow
      // 5aa: goto 576
      // 5ad: athrow
      // 5ae: getstatic x/ocdd342096f8.Ě Ljava/util/HashMap;
      // 5b1: aload 19
      // 5b3: invokevirtual net/minecraft/entity/EntityLivingBase.getUniqueID ()Ljava/util/UUID;
      // 5b6: lload 13
      // 5b8: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 5bb: invokevirtual java/util/HashMap.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 5be: pop
      // 5bf: aload 19
      // 5c1: astore 17
      // 5c3: goto 5c6
      // 5c6: aload 17
      // 5c8: iload 0
      // 5c9: ifne 5f6
      // 5cc: ifnonnull 5f0
      // 5cf: goto 5d3
      // 5d2: athrow
      // 5d3: getstatic x/ocdd342096f8.ʭ Lx/oc59dbd08e27;
      // 5d6: invokestatic x/ocdd342096f8.ƚ (Lx/oc59dbd08e27;)Z
      // 5d9: iload 0
      // 5da: ifne 5f1
      // 5dd: goto 5e1
      // 5e0: athrow
      // 5e1: ifeq 5f0
      // 5e4: goto 5e8
      // 5e7: athrow
      // 5e8: getstatic x/ocdd342096f8.ʭ Lx/oc59dbd08e27;
      // 5eb: getfield x/oc59dbd08e27.Ԍ Lnet/minecraft/entity/Entity;
      // 5ee: astore 17
      // 5f0: bipush 1
      // 5f1: putstatic x/ocdd342096f8.į Z
      // 5f4: aload 17
      // 5f6: invokestatic x/ocdd342096f8.γ (Lnet/minecraft/entity/Entity;)V
      // 5f9: return
   }

   private static boolean ƚ(boolean var0) {
      return oc7c017b256e.Ľ(var0);
   }

   private static boolean ҽ(S30PacketWindowItems var0) {
      Minecraft var2 = null;
      int var3 = -360129475 ^ -1444794758;
      int var1 = oc5e549848f3.İ;

      while (true) {
         label159:
         while (true) {
            label157:
            while (true) {
               label155:
               while (true) {
                  label153:
                  while (true) {
                     switch (var3) {
                        case -1779585843:
                           return true;
                        case -1751072785:
                           break;
                        case -833019818:
                           return false;
                        case -622649249:
                           int var10000;
                           label140: {
                              label139: {
                                 try {
                                    var10000 = oc7c017b256e.Э();
                                    if (var1 != 0) {
                                       break label140;
                                    }

                                    if (var10000 == 0) {
                                       break label139;
                                    }
                                 } catch (ocbde1165e4e var9) {
                                    throw var9;
                                 }

                                 var3 = 1214258231 ^ -1444794758;
                                 if (var1 == 0) {
                                    continue;
                                 }
                              }

                              var10000 = 1740312108 ^ -1444794758;
                           }

                           var3 = var10000;
                           if (var1 == 0) {
                              continue;
                           }
                        case -511561139:
                           int var10;
                           label130: {
                              label129: {
                                 try {
                                    var10 = oc7c017b256e.ҁ(
                                       var0.getItemStacks()[var2.thePlayer.inventory.currentItem + (-1444794786 ^ -1444794758)], var2.thePlayer.getHeldItem()
                                    );
                                    if (var1 != 0) {
                                       break label130;
                                    }

                                    if (var10 == 0) {
                                       break label129;
                                    }
                                 } catch (ocbde1165e4e var8) {
                                    throw var8;
                                 }

                                 var3 = 1007649463 ^ -1444794758;
                                 if (var1 == 0) {
                                    continue;
                                 }
                              }

                              var10 = 1740312108 ^ -1444794758;
                           }

                           var3 = var10;
                           if (var1 == 0) {
                              continue;
                           }
                           break;
                        case 143873630:
                           break label157;
                        case 228121808:
                           break label153;
                        case 1131082311:
                           break label155;
                        case 1698604898:
                           break label159;
                        default:
                           throw null;
                     }

                     if (var2.currentScreen == null) {
                        var3 = -857962216 ^ -1444794758;
                        if (var1 == 0) {
                           continue;
                        }
                     }

                     var3 = 1740312108 ^ -1444794758;
                     if (var1 != 0) {
                        break;
                     }
                  }

                  int var11;
                  label119: {
                     label118: {
                        try {
                           var11 = oc7ab2161b9f.Ь();
                           if (var1 != 0) {
                              break label119;
                           }

                           if (var11 != (-1444794760 ^ -1444794758)) {
                              break label118;
                           }
                        } catch (ocbde1165e4e var7) {
                           throw var7;
                        }

                        var3 = 1044550037 ^ -1444794758;
                        if (var1 == 0) {
                           continue;
                        }
                     }

                     var11 = 1740312108 ^ -1444794758;
                  }

                  var3 = var11;
                  if (var1 != 0) {
                     break;
                  }
               }

               var2 = Ȭ();

               label108: {
                  label107: {
                     try {
                        if (var1 != 0) {
                           break label108;
                        }

                        if (ĕ == null) {
                           break label107;
                        }
                     } catch (ocbde1165e4e var6) {
                        throw var6;
                     }

                     var3 = -1586399196 ^ -1444794758;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var3 = 1740312108 ^ -1444794758;
               }

               if (var1 != 0) {
                  break;
               }
            }

            int var12;
            label98: {
               label97: {
                  try {
                     var12 = oc7ab2161b9f.Տ();
                     if (var1 != 0) {
                        break label98;
                     }

                     if (var12 == 0) {
                        break label97;
                     }
                  } catch (ocbde1165e4e var5) {
                     throw var5;
                  }

                  var3 = -1535446358 ^ -1444794758;
                  if (var1 == 0) {
                     continue;
                  }
               }

               var12 = 1740312108 ^ -1444794758;
            }

            var3 = var12;
            if (var1 != 0) {
               break;
            }
         }

         int var13;
         label86: {
            label85: {
               try {
                  var13 = var0.getItemStacks().length;
                  if (var1 != 0) {
                     break label86;
                  }

                  if (var13 != (-1444794793 ^ -1444794758)) {
                     break label85;
                  }
               } catch (ocbde1165e4e var4) {
                  throw var4;
               }

               var3 = 1929448997 ^ -1444794758;
               if (var1 == 0) {
                  continue;
               }
            }

            var13 = 1740312108 ^ -1444794758;
         }

         var3 = var13;
         if (var1 != 0) {
            return true;
         }
      }
   }

   public boolean ψ(Packet param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 30
      // 09: instanceof net/minecraft/network/play/server/S2FPacketSetSlot
      // 0c: ifeq 2f
      // 0f: goto 13
      // 12: athrow
      // 13: aload 1
      // 14: checkcast net/minecraft/network/play/server/S2FPacketSetSlot
      // 17: invokestatic x/ocdd342096f8.ſ (Lnet/minecraft/network/play/server/S2FPacketSetSlot;)Z
      // 1a: iload 2
      // 1b: ifne 2a
      // 1e: goto 22
      // 21: athrow
      // 22: ifne 2d
      // 25: goto 29
      // 28: athrow
      // 29: bipush 1
      // 2a: goto 2e
      // 2d: bipush 0
      // 2e: ireturn
      // 2f: aload 1
      // 30: instanceof net/minecraft/network/play/server/S30PacketWindowItems
      // 33: iload 2
      // 34: ifne 5b
      // 37: ifeq 5a
      // 3a: goto 3e
      // 3d: athrow
      // 3e: aload 1
      // 3f: checkcast net/minecraft/network/play/server/S30PacketWindowItems
      // 42: invokestatic x/ocdd342096f8.ҽ (Lnet/minecraft/network/play/server/S30PacketWindowItems;)Z
      // 45: iload 2
      // 46: ifne 55
      // 49: goto 4d
      // 4c: athrow
      // 4d: ifne 58
      // 50: goto 54
      // 53: athrow
      // 54: bipush 1
      // 55: goto 59
      // 58: bipush 0
      // 59: ireturn
      // 5a: bipush 1
      // 5b: ireturn
   }

   public void ӻ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: getstatic x/oc5e549848f3.İ I
      // 003: istore 1
      // 004: iload 1
      // 005: invokestatic x/ocdd342096f8.Ȭ ()Lnet/minecraft/client/Minecraft;
      // 008: astore 2
      // 009: ifne 022
      // 00c: aload 0
      // 00d: invokevirtual x/ocdd342096f8.z$2u87utkr1isxg ()V
      // 010: invokestatic x/oc7c017b256e.Ԓ ()Z
      // 013: ifeq 023
      // 016: goto 01a
      // 019: athrow
      // 01a: aload 0
      // 01b: invokevirtual x/ocdd342096f8.ϒ ()V
      // 01e: goto 022
      // 021: athrow
      // 022: return
      // 023: aload 2
      // 024: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 027: ifnonnull 03c
      // 02a: getstatic x/oc0f63871c3b.э Z
      // 02d: iload 1
      // 02e: ifne 0ba
      // 031: goto 035
      // 034: athrow
      // 035: ifeq 0b3
      // 038: goto 03c
      // 03b: athrow
      // 03c: getstatic x/ocdd342096f8.Г I
      // 03f: iload 1
      // 040: ifne 074
      // 043: goto 047
      // 046: athrow
      // 047: bipush -1
      // 048: if_icmpne 073
      // 04b: goto 04f
      // 04e: athrow
      // 04f: getstatic x/ocdd342096f8.Ԣ Z
      // 052: iload 1
      // 053: ifne 074
      // 056: goto 05a
      // 059: athrow
      // 05a: ifne 073
      // 05d: goto 061
      // 060: athrow
      // 061: getstatic x/ocdd342096f8.Ł Z
      // 064: iload 1
      // 065: ifne 074
      // 068: goto 06c
      // 06b: athrow
      // 06c: ifeq 077
      // 06f: goto 073
      // 072: athrow
      // 073: bipush 1
      // 074: goto 078
      // 077: bipush 0
      // 078: istore 3
      // 079: iload 1
      // 07a: aconst_null
      // 07b: invokestatic x/ocdd342096f8.γ (Lnet/minecraft/entity/Entity;)V
      // 07e: ifne 0b2
      // 081: iload 3
      // 082: ifeq 092
      // 085: goto 089
      // 088: athrow
      // 089: bipush 0
      // 08a: bipush 0
      // 08b: invokestatic x/ocdd342096f8.ӳ (ZZ)V
      // 08e: goto 092
      // 091: athrow
      // 092: bipush 1
      // 093: invokestatic x/ocdd342096f8.ζ (Z)V
      // 096: bipush 0
      // 097: dup
      // 098: putstatic x/ocdd342096f8.ն Z
      // 09b: dup
      // 09c: putstatic x/ocdd342096f8.Ԉ Z
      // 09f: dup
      // 0a0: putstatic x/ocdd342096f8.Ł Z
      // 0a3: putstatic x/ocdd342096f8.Ԣ Z
      // 0a6: bipush 0
      // 0a7: putstatic x/ocdd342096f8.ž Z
      // 0aa: aconst_null
      // 0ab: putstatic x/ocdd342096f8.Ë [F
      // 0ae: bipush 0
      // 0af: putstatic x/ocdd342096f8.ɉ Z
      // 0b2: return
      // 0b3: invokestatic x/ocdd342096f8.ȃ ()V
      // 0b6: invokestatic x/ocdd342096f8.ł ()V
      // 0b9: bipush 1
      // 0ba: istore 3
      // 0bb: getstatic x/ocdd342096f8.Ư I
      // 0be: iload 1
      // 0bf: ifne 0d8
      // 0c2: ifle 0d5
      // 0c5: goto 0c9
      // 0c8: athrow
      // 0c9: getstatic x/ocdd342096f8.Ư I
      // 0cc: bipush 1
      // 0cd: isub
      // 0ce: putstatic x/ocdd342096f8.Ư I
      // 0d1: goto 0d5
      // 0d4: athrow
      // 0d5: getstatic x/ocdd342096f8.ҁ I
      // 0d8: iload 1
      // 0d9: ifne 0fd
      // 0dc: ifle 0ef
      // 0df: goto 0e3
      // 0e2: athrow
      // 0e3: getstatic x/ocdd342096f8.ҁ I
      // 0e6: bipush 1
      // 0e7: isub
      // 0e8: putstatic x/ocdd342096f8.ҁ I
      // 0eb: goto 0ef
      // 0ee: athrow
      // 0ef: getstatic x/ocdd342096f8.ĕ Lx/oc59dbd08e27;
      // 0f2: iload 1
      // 0f3: ifne 105
      // 0f6: invokestatic x/ocdd342096f8.ƚ (Lx/oc59dbd08e27;)Z
      // 0f9: goto 0fd
      // 0fc: athrow
      // 0fd: ifne 102
      // 100: bipush 0
      // 101: istore 3
      // 102: getstatic x/ocdd342096f8.ĕ Lx/oc59dbd08e27;
      // 105: ifnull 2d0
      // 108: getstatic x/ocdd342096f8.į Z
      // 10b: iload 1
      // 10c: ifne 15b
      // 10f: goto 113
      // 112: athrow
      // 113: ifeq 155
      // 116: goto 11a
      // 119: athrow
      // 11a: invokestatic x/ocdd342096f8.ų ()V
      // 11d: getstatic x/ocdd342096f8.A Lx/oca9cc61aada;
      // 120: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 123: getstatic x/ocdd342096f8.A Lx/oca9cc61aada;
      // 126: invokevirtual x/oca9cc61aada.ԕ ()D
      // 129: dcmpl
      // 12a: iload 1
      // 12b: ifne 15b
      // 12e: goto 132
      // 131: athrow
      // 132: ifeq 155
      // 135: goto 139
      // 138: athrow
      // 139: aload 2
      // 13a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 13d: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 140: putstatic x/ocdd342096f8.g F
      // 143: aload 2
      // 144: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 147: getfield net/minecraft/client/entity/EntityPlayerSP.rotationPitch F
      // 14a: putstatic x/ocdd342096f8.վ F
      // 14d: bipush 1
      // 14e: putstatic x/ocdd342096f8.ž Z
      // 151: goto 155
      // 154: athrow
      // 155: getstatic x/ocdd342096f8.ș Lx/oc8df2d0340c;
      // 158: getfield x/oc8df2d0340c.m Z
      // 15b: iload 1
      // 15c: ifne 2d3
      // 15f: ifeq 2d0
      // 162: goto 166
      // 165: athrow
      // 166: invokestatic x/ocdd342096f8.Ց ()Z
      // 169: iload 1
      // 16a: ifne 18d
      // 16d: goto 171
      // 170: athrow
      // 171: ifeq 18a
      // 174: goto 178
      // 177: athrow
      // 178: invokestatic x/oc7c017b256e.Э ()Z
      // 17b: iload 1
      // 17c: ifne 1b4
      // 17f: goto 183
      // 182: athrow
      // 183: ifne 1b1
      // 186: goto 18a
      // 189: athrow
      // 18a: getstatic x/ocdd342096f8.Г I
      // 18d: iload 1
      // 18e: ifne 2d3
      // 191: bipush -1
      // 192: if_icmpeq 2d0
      // 195: goto 199
      // 198: athrow
      // 199: getstatic x/ocdd342096f8.Г I
      // 19c: invokestatic x/ocdd342096f8.Ŕ (I)V
      // 19f: iload 1
      // 1a0: bipush -1
      // 1a1: putstatic x/ocdd342096f8.Г I
      // 1a4: bipush 0
      // 1a5: putstatic x/ocdd342096f8.Ԣ Z
      // 1a8: bipush 0
      // 1a9: putstatic x/ocdd342096f8.Ł Z
      // 1ac: bipush 0
      // 1ad: istore 3
      // 1ae: ifeq 2d0
      // 1b1: getstatic x/ocdd342096f8.Г I
      // 1b4: iload 1
      // 1b5: ifne 1d4
      // 1b8: ifne 1c8
      // 1bb: goto 1bf
      // 1be: athrow
      // 1bf: bipush 0
      // 1c0: bipush 0
      // 1c1: invokestatic x/ocdd342096f8.ӳ (ZZ)V
      // 1c4: goto 1c8
      // 1c7: athrow
      // 1c8: bipush 0
      // 1c9: iload 1
      // 1ca: ifne 2bf
      // 1cd: invokestatic x/ocdd342096f8.ƚ (Z)Z
      // 1d0: goto 1d4
      // 1d3: athrow
      // 1d4: ifeq 2b8
      // 1d7: getstatic x/ocdd342096f8.Г I
      // 1da: iload 1
      // 1db: ifne 208
      // 1de: goto 1e2
      // 1e1: athrow
      // 1e2: tableswitch 206 -1 1 87 27 87
      // 1fc: athrow
      // 1fd: getstatic x/ocdd342096f8.Θ D
      // 200: ldc2_w 10.0
      // 203: dcmpl
      // 204: goto 208
      // 207: athrow
      // 208: iload 1
      // 209: ifne 21e
      // 20c: iflt 21b
      // 20f: goto 213
      // 212: athrow
      // 213: bipush 1
      // 214: putstatic x/ocdd342096f8.ɉ Z
      // 217: goto 21b
      // 21a: athrow
      // 21b: getstatic x/ocdd342096f8.ɉ Z
      // 21e: iload 1
      // 21f: ifne 2d3
      // 222: ifeq 2d0
      // 225: goto 229
      // 228: athrow
      // 229: getstatic x/ocdd342096f8.Г I
      // 22c: bipush 1
      // 22d: iadd
      // 22e: putstatic x/ocdd342096f8.Г I
      // 231: iload 1
      // 232: ifeq 2d0
      // 235: goto 239
      // 238: athrow
      // 239: invokestatic x/ocdd342096f8.ɮ ()V
      // 23c: getstatic x/ocdd342096f8.Г I
      // 23f: iload 1
      // 240: ifne 269
      // 243: goto 247
      // 246: athrow
      // 247: bipush 1
      // 248: if_icmpeq 262
      // 24b: goto 24f
      // 24e: athrow
      // 24f: getstatic x/oc0f63871c3b.Ÿ I
      // 252: iload 1
      // 253: ifne 2ab
      // 256: goto 25a
      // 259: athrow
      // 25a: bipush 1
      // 25b: if_icmpne 2a6
      // 25e: goto 262
      // 261: athrow
      // 262: getstatic x/ocdd342096f8.Ł Z
      // 265: goto 269
      // 268: athrow
      // 269: iload 1
      // 26a: ifne 29b
      // 26d: ifne 287
      // 270: goto 274
      // 273: athrow
      // 274: getstatic x/oc0f63871c3b.Ÿ I
      // 277: iload 1
      // 278: ifne 2ab
      // 27b: goto 27f
      // 27e: athrow
      // 27f: bipush 1
      // 280: if_icmpne 2a6
      // 283: goto 287
      // 286: athrow
      // 287: bipush 0
      // 288: iload 1
      // 289: ifne 2ab
      // 28c: goto 290
      // 28f: athrow
      // 290: bipush 1
      // 291: invokestatic x/ocdd342096f8.ӳ (ZZ)V
      // 294: getstatic x/ocdd342096f8.Ԉ Z
      // 297: goto 29b
      // 29a: athrow
      // 29b: ifeq 2a6
      // 29e: bipush 1
      // 29f: putstatic x/ocdd342096f8.Ԣ Z
      // 2a2: goto 2a6
      // 2a5: athrow
      // 2a6: bipush 0
      // 2a7: putstatic x/ocdd342096f8.Г I
      // 2aa: bipush 0
      // 2ab: istore 3
      // 2ac: iload 1
      // 2ad: ifeq 2d0
      // 2b0: iload 1
      // 2b1: ifeq 2d0
      // 2b4: goto 2b8
      // 2b7: athrow
      // 2b8: invokestatic x/oc7c017b256e.ɺ ()Z
      // 2bb: goto 2bf
      // 2be: athrow
      // 2bf: iload 1
      // 2c0: ifne 2cd
      // 2c3: ifeq 2cc
      // 2c6: goto 2ca
      // 2c9: athrow
      // 2ca: bipush 0
      // 2cb: istore 3
      // 2cc: bipush -1
      // 2cd: putstatic x/ocdd342096f8.Г I
      // 2d0: getstatic x/ocdd342096f8.į Z
      // 2d3: iload 1
      // 2d4: ifne 306
      // 2d7: ifne 2fa
      // 2da: goto 2de
      // 2dd: athrow
      // 2de: getstatic x/ocdd342096f8.ž Z
      // 2e1: iload 1
      // 2e2: ifne 306
      // 2e5: goto 2e9
      // 2e8: athrow
      // 2e9: ifeq 2fa
      // 2ec: goto 2f0
      // 2ef: athrow
      // 2f0: invokestatic x/ocdd342096f8.Ά ()Z
      // 2f3: putstatic x/ocdd342096f8.ž Z
      // 2f6: goto 2fa
      // 2f9: athrow
      // 2fa: bipush 1
      // 2fb: iload 1
      // 2fc: ifne 30e
      // 2ff: invokestatic x/ocdd342096f8.ƚ (Z)Z
      // 302: goto 306
      // 305: athrow
      // 306: ifne 30b
      // 309: bipush 0
      // 30a: istore 3
      // 30b: getstatic x/ocdd342096f8.ɉ Z
      // 30e: iload 1
      // 30f: ifne 31c
      // 312: ifeq 558
      // 315: goto 319
      // 318: athrow
      // 319: invokestatic x/oc0f63871c3b.ɦ ()Z
      // 31c: iload 1
      // 31d: ifne 330
      // 320: ifeq 558
      // 323: goto 327
      // 326: athrow
      // 327: bipush 0
      // 328: putstatic x/ocdd342096f8.ɉ Z
      // 32b: iload 3
      // 32c: goto 330
      // 32f: athrow
      // 330: ifeq 558
      // 333: getstatic x/ocdd342096f8.ĕ Lx/oc59dbd08e27;
      // 336: getfield x/oc59dbd08e27.Ԍ Lnet/minecraft/entity/Entity;
      // 339: astore 4
      // 33b: getstatic x/ocdd342096f8.į Z
      // 33e: istore 5
      // 340: bipush 0
      // 341: istore 6
      // 343: iload 5
      // 345: iload 1
      // 346: ifne 3c0
      // 349: ifeq 3be
      // 34c: goto 350
      // 34f: athrow
      // 350: getstatic x/ocdd342096f8.Ա D
      // 353: getstatic x/ocdd342096f8.Ҙ D
      // 356: dcmpl
      // 357: iload 1
      // 358: ifne 367
      // 35b: goto 35f
      // 35e: athrow
      // 35f: ifne 36a
      // 362: goto 366
      // 365: athrow
      // 366: bipush 1
      // 367: goto 36b
      // 36a: bipush 0
      // 36b: istore 7
      // 36d: iload 7
      // 36f: iload 1
      // 370: ifne 3ac
      // 373: ifeq 396
      // 376: goto 37a
      // 379: athrow
      // 37a: getstatic x/ocdd342096f8.A Lx/oca9cc61aada;
      // 37d: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 380: getstatic x/ocdd342096f8.A Lx/oca9cc61aada;
      // 383: invokevirtual x/oca9cc61aada.ԕ ()D
      // 386: dcmpl
      // 387: iload 1
      // 388: ifne 3b8
      // 38b: goto 38f
      // 38e: athrow
      // 38f: ifeq 3b7
      // 392: goto 396
      // 395: athrow
      // 396: aload 4
      // 398: getstatic x/ocdd342096f8.Ë [F
      // 39b: bipush 0
      // 39c: faload
      // 39d: getstatic x/ocdd342096f8.Ë [F
      // 3a0: bipush 1
      // 3a1: faload
      // 3a2: getstatic x/ocdd342096f8.Ա D
      // 3a5: invokestatic x/oc7c017b256e.ǽ (Lnet/minecraft/entity/Entity;FFD)Z
      // 3a8: goto 3ac
      // 3ab: athrow
      // 3ac: iload 1
      // 3ad: ifne 3b8
      // 3b0: ifeq 3bb
      // 3b3: goto 3b7
      // 3b6: athrow
      // 3b7: bipush 1
      // 3b8: goto 3bc
      // 3bb: bipush 0
      // 3bc: istore 6
      // 3be: iload 5
      // 3c0: iload 1
      // 3c1: ifne 460
      // 3c4: ifeq 45d
      // 3c7: goto 3cb
      // 3ca: athrow
      // 3cb: bipush 1
      // 3cc: istore 7
      // 3ce: bipush 1
      // 3cf: istore 8
      // 3d1: getstatic x/ocdd342096f8.Ư I
      // 3d4: iload 1
      // 3d5: ifne 3ec
      // 3d8: ifle 3e6
      // 3db: goto 3df
      // 3de: athrow
      // 3df: bipush 0
      // 3e0: istore 7
      // 3e2: iload 1
      // 3e3: ifeq 3fa
      // 3e6: iload 6
      // 3e8: goto 3ec
      // 3eb: athrow
      // 3ec: iload 1
      // 3ed: ifne 3ff
      // 3f0: ifne 3fa
      // 3f3: goto 3f7
      // 3f6: athrow
      // 3f7: bipush 0
      // 3f8: istore 7
      // 3fa: aload 4
      // 3fc: invokestatic x/oc7c017b256e.Ů (Lnet/minecraft/entity/Entity;)Z
      // 3ff: iload 1
      // 400: ifne 412
      // 403: ifeq 410
      // 406: goto 40a
      // 409: athrow
      // 40a: bipush 0
      // 40b: istore 8
      // 40d: bipush 0
      // 40e: istore 7
      // 410: iload 7
      // 412: iload 1
      // 413: ifne 43d
      // 416: ifeq 437
      // 419: goto 41d
      // 41c: athrow
      // 41d: bipush 1
      // 41e: putstatic x/ocdd342096f8.ă Z
      // 421: iload 1
      // 422: bipush 1
      // 423: putstatic x/ocdd342096f8.ư Z
      // 426: aload 4
      // 428: bipush 0
      // 429: invokestatic x/oc7c017b256e.ï (Lnet/minecraft/entity/Entity;Z)V
      // 42c: bipush 0
      // 42d: putstatic x/ocdd342096f8.ư Z
      // 430: ifeq 45d
      // 433: goto 437
      // 436: athrow
      // 437: iload 8
      // 439: goto 43d
      // 43c: athrow
      // 43d: iload 1
      // 43e: ifne 45a
      // 441: ifeq 455
      // 444: goto 448
      // 447: athrow
      // 448: bipush 0
      // 449: bipush 0
      // 44a: invokestatic x/oc7c017b256e.Ӛ (ZZ)V
      // 44d: iload 1
      // 44e: ifeq 45d
      // 451: goto 455
      // 454: athrow
      // 455: bipush 1
      // 456: goto 45a
      // 459: athrow
      // 45a: invokestatic x/ocdd342096f8.Ť (Z)V
      // 45d: invokestatic x/ocdd342096f8.Ց ()Z
      // 460: iload 1
      // 461: ifne 46e
      // 464: ifeq 558
      // 467: goto 46b
      // 46a: athrow
      // 46b: getstatic x/ocdd342096f8.Г I
      // 46e: iload 1
      // 46f: ifne 484
      // 472: bipush 1
      // 473: if_icmpne 558
      // 476: goto 47a
      // 479: athrow
      // 47a: getstatic x/ocdd342096f8.ș Lx/oc8df2d0340c;
      // 47d: getfield x/oc8df2d0340c.Ű Z
      // 480: goto 484
      // 483: athrow
      // 484: iload 1
      // 485: ifne 490
      // 488: ifeq 558
      // 48b: goto 48f
      // 48e: athrow
      // 48f: bipush 1
      // 490: istore 7
      // 492: iload 6
      // 494: iload 1
      // 495: ifne 538
      // 498: ifeq 528
      // 49b: goto 49f
      // 49e: athrow
      // 49f: aload 4
      // 4a1: getstatic x/ocdd342096f8.Ա D
      // 4a4: ldc2_w 0.3
      // 4a7: dadd
      // 4a8: aload 2
      // 4a9: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 4ac: getfield net/minecraft/client/entity/EntityPlayerSP.posX D
      // 4af: aload 2
      // 4b0: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 4b3: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // 4b6: aload 2
      // 4b7: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 4ba: getfield net/minecraft/client/entity/EntityPlayerSP.posZ D
      // 4bd: getstatic x/ocdd342096f8.Ë [F
      // 4c0: bipush 0
      // 4c1: faload
      // 4c2: getstatic x/ocdd342096f8.Ë [F
      // 4c5: bipush 1
      // 4c6: faload
      // 4c7: invokestatic x/oc7c017b256e.ղ (Lnet/minecraft/entity/Entity;DDDDFF)Lnet/minecraft/util/MovingObjectPosition;
      // 4ca: astore 8
      // 4cc: aload 8
      // 4ce: ifnull 525
      // 4d1: new net/minecraft/util/Vec3
      // 4d4: dup
      // 4d5: aload 8
      // 4d7: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 4da: getfield net/minecraft/util/Vec3.xCoord D
      // 4dd: aload 4
      // 4df: getfield net/minecraft/entity/Entity.posX D
      // 4e2: dsub
      // 4e3: aload 8
      // 4e5: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 4e8: getfield net/minecraft/util/Vec3.yCoord D
      // 4eb: aload 4
      // 4ed: getfield net/minecraft/entity/Entity.posY D
      // 4f0: dsub
      // 4f1: aload 8
      // 4f3: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 4f6: getfield net/minecraft/util/Vec3.zCoord D
      // 4f9: aload 4
      // 4fb: getfield net/minecraft/entity/Entity.posZ D
      // 4fe: dsub
      // 4ff: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 502: astore 9
      // 504: iload 1
      // 505: new net/minecraft/network/play/client/C02PacketUseEntity
      // 508: dup
      // 509: aload 4
      // 50b: aload 9
      // 50d: invokespecial net/minecraft/network/play/client/C02PacketUseEntity.<init> (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/Vec3;)V
      // 510: invokestatic x/oc0f63871c3b.Щ (Lnet/minecraft/network/Packet;)V
      // 513: new net/minecraft/network/play/client/C02PacketUseEntity
      // 516: dup
      // 517: aload 4
      // 519: getstatic net/minecraft/network/play/client/C02PacketUseEntity$Action.INTERACT Lnet/minecraft/network/play/client/C02PacketUseEntity$Action;
      // 51c: invokespecial net/minecraft/network/play/client/C02PacketUseEntity.<init> (Lnet/minecraft/entity/Entity;Lnet/minecraft/network/play/client/C02PacketUseEntity$Action;)V
      // 51f: invokestatic x/oc0f63871c3b.Щ (Lnet/minecraft/network/Packet;)V
      // 522: ifeq 528
      // 525: bipush 0
      // 526: istore 7
      // 528: aload 2
      // 529: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 52c: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 52f: getstatic x/oc0f63871c3b.Ϧ I
      // 532: invokevirtual net/minecraft/entity/player/InventoryPlayer.getStackInSlot (I)Lnet/minecraft/item/ItemStack;
      // 535: invokestatic x/oc7c017b256e.Ĭ (Lnet/minecraft/item/ItemStack;)Z
      // 538: iload 1
      // 539: ifne 548
      // 53c: ifne 546
      // 53f: goto 543
      // 542: athrow
      // 543: bipush 0
      // 544: istore 7
      // 546: iload 7
      // 548: iload 1
      // 549: ifne 554
      // 54c: ifeq 558
      // 54f: goto 553
      // 552: athrow
      // 553: bipush 1
      // 554: bipush 1
      // 555: invokestatic x/ocdd342096f8.ӳ (ZZ)V
      // 558: return
   }

   public void ϒ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: invokestatic x/ocdd342096f8.Ȭ ()Lnet/minecraft/client/Minecraft;
      // 06: astore 2
      // 07: istore 1
      // 08: getstatic x/ocdd342096f8.Г I
      // 0b: iload 1
      // 0c: ifne 2a
      // 0f: bipush -1
      // 10: if_icmpne 29
      // 13: goto 17
      // 16: athrow
      // 17: getstatic x/ocdd342096f8.Ł Z
      // 1a: iload 1
      // 1b: ifne 31
      // 1e: goto 22
      // 21: athrow
      // 22: ifeq 2e
      // 25: goto 29
      // 28: athrow
      // 29: bipush 0
      // 2a: bipush 1
      // 2b: invokestatic x/ocdd342096f8.ӳ (ZZ)V
      // 2e: getstatic x/ocdd342096f8.Ԣ Z
      // 31: iload 1
      // 32: ifne 65
      // 35: ifne 64
      // 38: goto 3c
      // 3b: athrow
      // 3c: getstatic x/ocdd342096f8.Ł Z
      // 3f: iload 1
      // 40: ifne 65
      // 43: goto 47
      // 46: athrow
      // 47: ifne 64
      // 4a: goto 4e
      // 4d: athrow
      // 4e: aload 2
      // 4f: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 52: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isUsingItem ()Z
      // 55: iload 1
      // 56: ifne 86
      // 59: goto 5d
      // 5c: athrow
      // 5d: ifeq 69
      // 60: goto 64
      // 63: athrow
      // 64: bipush 0
      // 65: bipush 0
      // 66: invokestatic x/ocdd342096f8.ӳ (ZZ)V
      // 69: bipush 0
      // 6a: invokestatic x/ocdd342096f8.ζ (Z)V
      // 6d: bipush -1
      // 6e: putstatic x/ocdd342096f8.Г I
      // 71: bipush 0
      // 72: dup
      // 73: putstatic x/ocdd342096f8.ն Z
      // 76: dup
      // 77: putstatic x/ocdd342096f8.Ԉ Z
      // 7a: dup
      // 7b: putstatic x/ocdd342096f8.Ł Z
      // 7e: putstatic x/ocdd342096f8.Ԣ Z
      // 81: aconst_null
      // 82: putstatic x/ocdd342096f8.Ë [F
      // 85: bipush 0
      // 86: putstatic x/ocdd342096f8.ž Z
      // 89: return
   }

   private static boolean Շ() {
      return oc7c017b256e.Ê(1);
   }

   private static void ɮ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 0
      // 04: getstatic x/ocdd342096f8.Σ I
      // 07: iload 0
      // 08: ifne 44
      // 0b: getstatic x/ocdd342096f8.ы Lx/oca9cc61aada;
      // 0e: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 11: d2i
      // 12: iadd
      // 13: dup
      // 14: putstatic x/ocdd342096f8.Σ I
      // 17: ldc_w 350569209
      // 1a: ldc_w 350569117
      // 1d: ixor
      // 1e: if_icmplt 3f
      // 21: goto 25
      // 24: athrow
      // 25: getstatic x/ocdd342096f8.Σ I
      // 28: ldc_w 350569209
      // 2b: ldc_w 350569117
      // 2e: ixor
      // 2f: isub
      // 30: putstatic x/ocdd342096f8.Σ I
      // 33: iload 0
      // 34: bipush 1
      // 35: putstatic x/ocdd342096f8.Ԉ Z
      // 38: ifeq 47
      // 3b: goto 3f
      // 3e: athrow
      // 3f: bipush 0
      // 40: goto 44
      // 43: athrow
      // 44: putstatic x/ocdd342096f8.Ԉ Z
      // 47: return
   }

   private static double Ƽ(EntityLivingBase var0) {
      return Ȭ().thePlayer.getDistanceSqToEntity(var0);
   }

   @oc66fa4f2195
   public void Ѹ(MouseEvent param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: getstatic x/oc5e549848f3.İ I
      // 003: invokestatic x/ocdd342096f8.Ȭ ()Lnet/minecraft/client/Minecraft;
      // 006: astore 3
      // 007: istore 2
      // 008: aload 1
      // 009: iload 2
      // 00a: ifne 087
      // 00d: getfield x/MouseEvent.button I
      // 010: ifne 082
      // 013: goto 017
      // 016: athrow
      // 017: aload 1
      // 018: getfield x/MouseEvent.buttonstate Z
      // 01b: ifeq 1d6
      // 01e: goto 022
      // 021: athrow
      // 022: getstatic x/ocdd342096f8.ĕ Lx/oc59dbd08e27;
      // 025: ifnull 1d6
      // 028: goto 02c
      // 02b: athrow
      // 02c: aload 3
      // 02d: iload 2
      // 02e: ifne 044
      // 031: goto 035
      // 034: athrow
      // 035: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 038: ifnull 05a
      // 03b: goto 03f
      // 03e: athrow
      // 03f: aload 3
      // 040: goto 044
      // 043: athrow
      // 044: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 047: getfield net/minecraft/util/MovingObjectPosition.entityHit Lnet/minecraft/entity/Entity;
      // 04a: ifnull 05a
      // 04d: aload 1
      // 04e: bipush 1
      // 04f: invokevirtual x/oc68d6b191af.setCanceled (Z)V
      // 052: iload 2
      // 053: ifeq 1d6
      // 056: goto 05a
      // 059: athrow
      // 05a: getstatic x/ocdd342096f8.ș Lx/oc8df2d0340c;
      // 05d: getfield x/oc8df2d0340c.m Z
      // 060: iload 2
      // 061: ifne 072
      // 064: goto 068
      // 067: athrow
      // 068: ifeq 1d6
      // 06b: goto 06f
      // 06e: athrow
      // 06f: invokestatic x/ocdd342096f8.Ց ()Z
      // 072: ifeq 1d6
      // 075: aload 1
      // 076: bipush 1
      // 077: invokevirtual x/oc68d6b191af.setCanceled (Z)V
      // 07a: iload 2
      // 07b: ifeq 1d6
      // 07e: goto 082
      // 081: athrow
      // 082: aload 1
      // 083: goto 087
      // 086: athrow
      // 087: iload 2
      // 088: ifne 09b
      // 08b: getfield x/MouseEvent.button I
      // 08e: bipush 1
      // 08f: if_icmpne 1d6
      // 092: goto 096
      // 095: athrow
      // 096: aload 1
      // 097: goto 09b
      // 09a: athrow
      // 09b: getfield x/MouseEvent.buttonstate Z
      // 09e: iload 2
      // 09f: ifne 0b7
      // 0a2: ifne 0b1
      // 0a5: goto 0a9
      // 0a8: athrow
      // 0a9: bipush 0
      // 0aa: putstatic x/ocdd342096f8.C Z
      // 0ad: goto 0b1
      // 0b0: athrow
      // 0b1: getstatic x/ocdd342096f8.ș Lx/oc8df2d0340c;
      // 0b4: getfield x/oc8df2d0340c.m Z
      // 0b7: iload 2
      // 0b8: ifne 0c5
      // 0bb: ifeq 1d6
      // 0be: goto 0c2
      // 0c1: athrow
      // 0c2: invokestatic x/oc7c017b256e.Э ()Z
      // 0c5: ifeq 1d6
      // 0c8: getstatic x/ocdd342096f8.ĕ Lx/oc59dbd08e27;
      // 0cb: iload 2
      // 0cc: ifne 12e
      // 0cf: goto 0d3
      // 0d2: athrow
      // 0d3: ifnull 12b
      // 0d6: goto 0da
      // 0d9: athrow
      // 0da: getstatic x/ocdd342096f8.Ӹ Lx/occ2f8dff8d8;
      // 0dd: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0e0: iload 2
      // 0e1: ifne 0f2
      // 0e4: goto 0e8
      // 0e7: athrow
      // 0e8: ifeq 12b
      // 0eb: goto 0ef
      // 0ee: athrow
      // 0ef: getstatic x/ocdd342096f8.Г I
      // 0f2: iload 2
      // 0f3: ifne 105
      // 0f6: bipush -1
      // 0f7: if_icmpne 12b
      // 0fa: goto 0fe
      // 0fd: athrow
      // 0fe: invokestatic x/oc7c017b256e.Ô ()I
      // 101: goto 105
      // 104: athrow
      // 105: dup
      // 106: istore 4
      // 108: iload 2
      // 109: ifne 127
      // 10c: bipush -1
      // 10d: if_icmpeq 12b
      // 110: goto 114
      // 113: athrow
      // 114: aload 3
      // 115: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 118: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 11b: iload 4
      // 11d: invokevirtual net/minecraft/entity/player/InventoryPlayer.getStackInSlot (I)Lnet/minecraft/item/ItemStack;
      // 120: invokestatic x/oc7c017b256e.Ĭ (Lnet/minecraft/item/ItemStack;)Z
      // 123: goto 127
      // 126: athrow
      // 127: ifne 12b
      // 12a: return
      // 12b: getstatic x/ocdd342096f8.ĕ Lx/oc59dbd08e27;
      // 12e: ifnonnull 1a8
      // 131: aload 3
      // 132: iload 2
      // 133: ifne 149
      // 136: goto 13a
      // 139: athrow
      // 13a: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 13d: ifnull 1a8
      // 140: goto 144
      // 143: athrow
      // 144: aload 3
      // 145: goto 149
      // 148: athrow
      // 149: iload 2
      // 14a: ifne 17a
      // 14d: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 150: getfield net/minecraft/util/MovingObjectPosition.entityHit Lnet/minecraft/entity/Entity;
      // 153: ifnull 179
      // 156: goto 15a
      // 159: athrow
      // 15a: aload 3
      // 15b: iload 2
      // 15c: ifne 17a
      // 15f: goto 163
      // 162: athrow
      // 163: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 166: getfield net/minecraft/util/MovingObjectPosition.entityHit Lnet/minecraft/entity/Entity;
      // 169: invokestatic x/oca4f99d2d44.Λ (Lnet/minecraft/entity/Entity;)Z
      // 16c: ifeq 179
      // 16f: goto 173
      // 172: athrow
      // 173: bipush 0
      // 174: putstatic x/ocdd342096f8.Ԣ Z
      // 177: return
      // 178: athrow
      // 179: aload 3
      // 17a: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 17d: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 180: astore 5
      // 182: aload 5
      // 184: iload 2
      // 185: ifne 191
      // 188: ifnull 1a8
      // 18b: goto 18f
      // 18e: athrow
      // 18f: aload 5
      // 191: invokestatic x/oc7c017b256e.Ϭ (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/Block;
      // 194: invokestatic x/oc7c017b256e.ƈ (Lnet/minecraft/block/Block;)Z
      // 197: iload 2
      // 198: ifne 1ac
      // 19b: ifeq 1a8
      // 19e: goto 1a2
      // 1a1: athrow
      // 1a2: bipush 0
      // 1a3: putstatic x/ocdd342096f8.Ԣ Z
      // 1a6: return
      // 1a7: athrow
      // 1a8: aload 1
      // 1a9: getfield x/MouseEvent.buttonstate Z
      // 1ac: iload 2
      // 1ad: ifne 1b8
      // 1b0: ifeq 1bf
      // 1b3: goto 1b7
      // 1b6: athrow
      // 1b7: bipush 1
      // 1b8: putstatic x/ocdd342096f8.Ԣ Z
      // 1bb: iload 2
      // 1bc: ifeq 1d1
      // 1bf: getstatic x/ocdd342096f8.ĕ Lx/oc59dbd08e27;
      // 1c2: ifnonnull 1d1
      // 1c5: goto 1c9
      // 1c8: athrow
      // 1c9: bipush 0
      // 1ca: putstatic x/ocdd342096f8.Ԣ Z
      // 1cd: goto 1d1
      // 1d0: athrow
      // 1d1: aload 1
      // 1d2: bipush 1
      // 1d3: invokevirtual x/oc68d6b191af.setCanceled (Z)V
      // 1d6: return
   }

   public static boolean Ց() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 0
      // 04: invokestatic x/oc7c017b256e.Ԓ ()Z
      // 07: ifne 42
      // 0a: getstatic x/ocdd342096f8.ș Lx/oc8df2d0340c;
      // 0d: getstatic x/oc8df2d0340c.Ѐ Lx/oc8df2d0340c;
      // 10: if_acmpeq 42
      // 13: goto 17
      // 16: athrow
      // 17: getstatic x/ocdd342096f8.Ӹ Lx/occ2f8dff8d8;
      // 1a: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 1d: iload 0
      // 1e: ifne 3f
      // 21: goto 25
      // 24: athrow
      // 25: ifeq 3e
      // 28: goto 2c
      // 2b: athrow
      // 2c: invokestatic x/ocdd342096f8.Շ ()Z
      // 2f: iload 0
      // 30: ifne 3f
      // 33: goto 37
      // 36: athrow
      // 37: ifeq 42
      // 3a: goto 3e
      // 3d: athrow
      // 3e: bipush 1
      // 3f: goto 43
      // 42: bipush 0
      // 43: ireturn
   }

   @Override
   public void z$2u87utkr1isxg() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc5e549848f3.İ I
      // 003: aload 0
      // 004: invokevirtual x/ocdd342096f8.զ ()Lx/oc8df2d0340c;
      // 007: astore 2
      // 008: istore 1
      // 009: getstatic x/ocdd342096f8.ș Lx/oc8df2d0340c;
      // 00c: iload 1
      // 00d: ifne 0aa
      // 010: aload 2
      // 011: if_acmpeq 0a7
      // 014: goto 018
      // 017: athrow
      // 018: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 01b: iload 1
      // 01c: ifne 02d
      // 01f: goto 023
      // 022: athrow
      // 023: ifeq 06f
      // 026: goto 02a
      // 029: athrow
      // 02a: getstatic x/ocdd342096f8.Г I
      // 02d: iload 1
      // 02e: ifne 040
      // 031: bipush -1
      // 032: if_icmpeq 043
      // 035: goto 039
      // 038: athrow
      // 039: getstatic x/ocdd342096f8.Г I
      // 03c: goto 040
      // 03f: athrow
      // 040: invokestatic x/ocdd342096f8.Ŕ (I)V
      // 043: getstatic x/ocdd342096f8.ș Lx/oc8df2d0340c;
      // 046: getstatic x/oc8df2d0340c.Ѐ Lx/oc8df2d0340c;
      // 049: if_acmpeq 067
      // 04c: invokestatic x/ocdd342096f8.Շ ()Z
      // 04f: iload 1
      // 050: ifne 068
      // 053: goto 057
      // 056: athrow
      // 057: ifne 067
      // 05a: goto 05e
      // 05d: athrow
      // 05e: bipush 0
      // 05f: bipush 0
      // 060: invokestatic x/ocdd342096f8.ӳ (ZZ)V
      // 063: goto 067
      // 066: athrow
      // 067: bipush 1
      // 068: invokestatic x/ocdd342096f8.ζ (Z)V
      // 06b: iload 1
      // 06c: ifeq 07b
      // 06f: getstatic x/ocdd342096f8.Ғ Ljava/util/List;
      // 072: invokeinterface java/util/List.clear ()V 1
      // 077: goto 07b
      // 07a: athrow
      // 07b: bipush -1
      // 07c: putstatic x/ocdd342096f8.Г I
      // 07f: bipush 0
      // 080: dup
      // 081: putstatic x/ocdd342096f8.ն Z
      // 084: dup
      // 085: putstatic x/ocdd342096f8.Ԉ Z
      // 088: dup
      // 089: putstatic x/ocdd342096f8.Ł Z
      // 08c: putstatic x/ocdd342096f8.Ԣ Z
      // 08f: bipush 0
      // 090: dup
      // 091: putstatic x/ocdd342096f8.Ư I
      // 094: putstatic x/ocdd342096f8.ҁ I
      // 097: bipush 0
      // 098: putstatic x/ocdd342096f8.C Z
      // 09b: bipush 0
      // 09c: putstatic x/ocdd342096f8.Σ I
      // 09f: lconst_0
      // 0a0: putstatic x/ocdd342096f8.Ų J
      // 0a3: aload 2
      // 0a4: putstatic x/ocdd342096f8.ș Lx/oc8df2d0340c;
      // 0a7: getstatic x/ocdd342096f8.ș Lx/oc8df2d0340c;
      // 0aa: getstatic x/oc8df2d0340c.Ѐ Lx/oc8df2d0340c;
      // 0ad: if_acmpeq 0b5
      // 0b0: bipush 1
      // 0b1: goto 0b6
      // 0b4: athrow
      // 0b5: bipush 0
      // 0b6: istore 3
      // 0b7: iload 1
      // 0b8: getstatic x/ocdd342096f8.ʄ Lx/ocf1568fef75;
      // 0bb: iload 3
      // 0bc: aload 0
      // 0bd: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0c0: getstatic x/ocdd342096f8.ы Lx/oca9cc61aada;
      // 0c3: getstatic x/ocdd342096f8.ș Lx/oc8df2d0340c;
      // 0c6: getfield x/oc8df2d0340c.Թ Z
      // 0c9: aload 0
      // 0ca: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0cd: getstatic x/ocdd342096f8.Ƒ Lx/oca9cc61aada;
      // 0d0: iload 3
      // 0d1: aload 0
      // 0d2: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0d5: ifne 118
      // 0d8: getstatic x/ocdd342096f8.Ӹ Lx/occ2f8dff8d8;
      // 0db: iload 3
      // 0dc: aload 0
      // 0dd: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0e0: getstatic x/ocdd342096f8.ѵ Lx/oca9cc61aada;
      // 0e3: getstatic x/ocdd342096f8.Ɩ Lx/oca9cc61aada;
      // 0e6: invokestatic x/oc7c017b256e.դ (Lx/oca9cc61aada;Lx/oca9cc61aada;)V
      // 0e9: iload 3
      // 0ea: ifeq 0fe
      // 0ed: goto 0f1
      // 0f0: athrow
      // 0f1: getstatic x/ocdd342096f8.Ɩ Lx/oca9cc61aada;
      // 0f4: getstatic x/ocdd342096f8.Ƒ Lx/oca9cc61aada;
      // 0f7: invokestatic x/oc7c017b256e.դ (Lx/oca9cc61aada;Lx/oca9cc61aada;)V
      // 0fa: goto 0fe
      // 0fd: athrow
      // 0fe: getstatic x/ocdd342096f8.ѵ Lx/oca9cc61aada;
      // 101: iload 1
      // 102: ifne 123
      // 105: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 108: putstatic x/ocdd342096f8.Ա D
      // 10b: getstatic x/ocdd342096f8.Ɩ Lx/oca9cc61aada;
      // 10e: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 111: putstatic x/ocdd342096f8.Ҙ D
      // 114: goto 118
      // 117: athrow
      // 118: iload 3
      // 119: ifeq 129
      // 11c: getstatic x/ocdd342096f8.Ƒ Lx/oca9cc61aada;
      // 11f: goto 123
      // 122: athrow
      // 123: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 126: goto 12c
      // 129: getstatic x/ocdd342096f8.Ҙ D
      // 12c: putstatic x/ocdd342096f8.ӣ D
      // 12f: getstatic x/ocdd342096f8.Ա D
      // 132: getstatic x/ocdd342096f8.Ҙ D
      // 135: invokestatic java/lang/Math.max (DD)D
      // 138: getstatic x/ocdd342096f8.ӣ D
      // 13b: invokestatic java/lang/Math.max (DD)D
      // 13e: ldc2_w 1.2
      // 141: dadd
      // 142: dstore 4
      // 144: dload 4
      // 146: dload 4
      // 148: dmul
      // 149: putstatic x/ocdd342096f8.Ή D
      // 14c: invokestatic x/oc12021474b0.values ()[Lx/oc12021474b0;
      // 14f: getstatic x/ocdd342096f8.Ǒ Lx/oca9cc61aada;
      // 152: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 155: d2i
      // 156: aaload
      // 157: putstatic x/ocdd342096f8.Ӣ Lx/oc12021474b0;
      // 15a: invokestatic x/oca547efbd9f.values ()[Lx/oca547efbd9f;
      // 15d: getstatic x/ocdd342096f8.ӷ Lx/oca9cc61aada;
      // 160: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 163: d2i
      // 164: aaload
      // 165: putstatic x/ocdd342096f8.Ž Lx/oca547efbd9f;
      // 168: return
   }

   private static float[] Ը() {
      float[] var0 = Ë;
      Ë = null;
      return var0;
   }

   @Override
   public void guiButtonToggled(occ2f8dff8d8 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 1a
      // 09: getstatic x/ocdd342096f8.Ѱ Lx/occ2f8dff8d8;
      // 0c: if_acmpne 2e
      // 0f: goto 13
      // 12: athrow
      // 13: getstatic x/ocdd342096f8.Ѱ Lx/occ2f8dff8d8;
      // 16: goto 1a
      // 19: athrow
      // 1a: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 1d: ifeq 2e
      // 20: aconst_null
      // 21: putstatic x/ocdd342096f8.Ʉ Lnet/minecraft/util/Vec3;
      // 24: getstatic x/ocdd342096f8.ǉ Ljava/util/HashMap;
      // 27: invokevirtual java/util/HashMap.clear ()V
      // 2a: goto 2e
      // 2d: athrow
      // 2e: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGH
   )
   public void z(oc86de9e2892 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 07: ifne 0c
      // 0a: return
      // 0b: athrow
      // 0c: aload 0
      // 0d: invokevirtual x/ocdd342096f8.ӻ ()V
      // 10: aload 0
      // 11: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 14: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 17: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 1a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 20: getfield net/minecraft/client/entity/EntityPlayerSP.rotationPitch F
      // 23: invokevirtual x/ocdd342096f8.З (FF)[F
      // 26: astore 3
      // 27: aload 3
      // 28: ifnull 5b
      // 2b: aload 1
      // 2c: iload 2
      // 2d: ifne 57
      // 30: goto 34
      // 33: athrow
      // 34: aload 0
      // 35: ldc_w -2024731503
      // 38: ldc_w -2024731203
      // 3b: ixor
      // 3c: aload 3
      // 3d: bipush 0
      // 3e: faload
      // 3f: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 42: aload 3
      // 43: bipush 1
      // 44: faload
      // 45: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 48: invokevirtual x/oc86de9e2892.л (Ljava/lang/Object;ILjava/lang/Float;Ljava/lang/Float;)Z
      // 4b: ifeq 5b
      // 4e: goto 52
      // 51: athrow
      // 52: aload 1
      // 53: goto 57
      // 56: athrow
      // 57: bipush 1
      // 58: invokevirtual x/oc86de9e2892.ʐ (Z)V
      // 5b: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGH
   )
   public void ʄ(oc0e4b758d9a var1) {
      try {
         if (oc7ab2161b9f.Ð()) {
            this.Ƙ();
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGH
   )
   public void қ(oc52918cda9d var1) {
      try {
         if (oc7ab2161b9f.Ð()) {
            this.β();
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGH
   )
   public void Ӆ(oc9d4393f3ce param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 07: iload 2
      // 08: ifne 1e
      // 0b: ifeq 2a
      // 0e: goto 12
      // 11: athrow
      // 12: aload 0
      // 13: aload 1
      // 14: invokevirtual x/oc9d4393f3ce.ɟ ()Lnet/minecraft/network/Packet;
      // 17: invokevirtual x/ocdd342096f8.Ҭ (Lnet/minecraft/network/Packet;)Z
      // 1a: goto 1e
      // 1d: athrow
      // 1e: ifne 2a
      // 21: aload 1
      // 22: bipush 1
      // 23: invokevirtual x/oc68d6b191af.setCanceled (Z)V
      // 26: goto 2a
      // 29: athrow
      // 2a: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGH
   )
   public void ğ(oce79181588d var1) {
      int var2 = oc5e549848f3.İ;

      boolean var10000;
      label30: {
         try {
            var10000 = oc7ab2161b9f.Ð();
            if (var2 != 0) {
               break label30;
            }

            if (!var10000) {
               return;
            }
         } catch (ocbde1165e4e var4) {
            throw var4;
         }

         var10000 = this.ψ(var1.Ҡ());
      }

      try {
         if (!var10000) {
            var1.setCanceled(true);
         }
      } catch (ocbde1165e4e var3) {
         throw var3;
      }
   }

   @oc66fa4f2195
   public void ư(ocf923d5a814 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 1
      // 01: getfield x/ocb508b4e274.Ұ Lx/oc110d7f376c;
      // 04: getstatic x/oc110d7f376c.START Lx/oc110d7f376c;
      // 07: if_acmpne 1b
      // 0a: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 0d: ifeq 1b
      // 10: goto 14
      // 13: athrow
      // 14: invokestatic x/ocdd342096f8.Ԡ ()V
      // 17: goto 1b
      // 1a: athrow
      // 1b: return
   }

   @oc66fa4f2195
   public void ȝ(oca27090789a param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: getstatic x/ocdd342096f8.ĕ Lx/oc59dbd08e27;
      // 07: ifnull 3b
      // 0a: getstatic x/ocdd342096f8.ș Lx/oc8df2d0340c;
      // 0d: getfield x/oc8df2d0340c.m Z
      // 10: iload 2
      // 11: ifne 22
      // 14: goto 18
      // 17: athrow
      // 18: ifeq 3b
      // 1b: goto 1f
      // 1e: athrow
      // 1f: invokestatic x/ocdd342096f8.Ց ()Z
      // 22: iload 2
      // 23: ifne 30
      // 26: ifeq 3b
      // 29: goto 2d
      // 2c: athrow
      // 2d: invokestatic x/oc7ab2161b9f.ө ()Z
      // 30: ifeq 3b
      // 33: aload 1
      // 34: invokevirtual x/oca27090789a.ʜ ()V
      // 37: goto 3b
      // 3a: athrow
      // 3b: return
   }

   @oc66fa4f2195
   public void Ѹ(ocbab3c9954b var1) {
      Я();
   }

   static void Я() {
      Ғ.clear();
      ʭ = null;
      ĕ = null;
      ѐ = null;
      f = null;
      Ց = Collections.emptyList();
      į = false;
      ɉ = false;
      Ԉ = false;
      Ł = false;
      Ԣ = false;
      ư = false;
      Г = -1;
      Ë = null;
      Ʉ = null;
      ǉ.clear();
      Ě.clear();
      Θ = 0.0;
      ǧ = 0.0;
      ɜ = 0.0;
   }

   @Override
   public void z$1sehylui0i4ix(oca9cc61aada var1) {
      this.z$2u87utkr1isxg();
   }

   @Override
   public void z$3tl278wzjcayb(N var1) {
      this.z$2u87utkr1isxg();
   }

   public oc8df2d0340c զ() {
      int var10000 = oc5e549848f3.İ;
      int var2 = (int)Ț.Ӂ();
      int var1 = var10000;

      label27: {
         try {
            var10000 = var2;
            if (var1 != 0) {
               break label27;
            }

            if (var2 < 0) {
               return oc8df2d0340c.Ѐ;
            }
         } catch (ocbde1165e4e var4) {
            throw var4;
         }

         var10000 = var2;
      }

      try {
         if (var10000 < oc8df2d0340c.values().length) {
            return oc8df2d0340c.values()[var2];
         }
      } catch (ocbde1165e4e var3) {
         throw var3;
      }

      return oc8df2d0340c.Ѐ;
   }

   public boolean ԝ() {
      int var1 = oc5e549848f3.İ;

      boolean var10000;
      label33: {
         try {
            var10000 = this.z$3rzb3dil7uydr();
            if (var1 != 0) {
               break label33;
            }

            if (!var10000) {
               return false;
            }
         } catch (ocbde1165e4e var3) {
            throw var3;
         }

         var10000 = Ł;
      }

      try {
         if (var1 != 0) {
            return var10000;
         }

         if (var10000) {
            return true;
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }

      return false;
   }

   public boolean ϲ() {
      int var1 = oc5e549848f3.İ;

      try {
         double var3;
         int var10000 = (var3 = Ǒ.Ӂ() - 0.0) == 0.0 ? 0 : (var3 < 0.0 ? -1 : 1);
         if (var1 != 0) {
            return (boolean)var10000;
         }

         if (!var10000) {
            return (boolean)1;
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }

      return (boolean)0;
   }

   public boolean ս() {
      return false;
   }

   public boolean љ() {
      return this.ս();
   }

   public double x() {
      return (ʄ.ö() + ʄ.і()) / 2.0;
   }

   EntityPlayer Ȧ(double param1, boolean param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 4
      // 05: aload 0
      // 06: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 09: iload 4
      // 0b: ifne 28
      // 0e: ifeq 4b
      // 11: goto 15
      // 14: athrow
      // 15: getstatic x/ocdd342096f8.f Lnet/minecraft/entity/EntityLivingBase;
      // 18: iload 4
      // 1a: ifne 2e
      // 1d: goto 21
      // 20: athrow
      // 21: instanceof net/minecraft/entity/player/EntityPlayer
      // 24: goto 28
      // 27: athrow
      // 28: ifeq 4b
      // 2b: getstatic x/ocdd342096f8.f Lnet/minecraft/entity/EntityLivingBase;
      // 2e: iload 4
      // 30: ifne 45
      // 33: dload 1
      // 34: invokestatic x/oc7c017b256e.ˤ (Lnet/minecraft/entity/Entity;D)Z
      // 37: ifeq 4b
      // 3a: goto 3e
      // 3d: athrow
      // 3e: getstatic x/ocdd342096f8.f Lnet/minecraft/entity/EntityLivingBase;
      // 41: goto 45
      // 44: athrow
      // 45: checkcast net/minecraft/entity/player/EntityPlayer
      // 48: goto 4c
      // 4b: aconst_null
      // 4c: areturn
   }

   public oca9cc61aada Q() {
      return ѵ;
   }

   public oca9cc61aada ş() {
      return Ɩ;
   }

   public oca9cc61aada Դ() {
      return Ƒ;
   }

   public oca9cc61aada E() {
      return Ƒ;
   }

   public int Ǹ() {
      return 580099808 ^ 580099811;
   }

   public int ĺ() {
      return -1922680692 ^ -1922680806;
   }

   public boolean Đ() {
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
      // 05: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 08: iload 1
      // 09: ifne 16
      // 0c: ifeq 54
      // 0f: goto 13
      // 12: athrow
      // 13: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 16: ifeq 54
      // 19: getstatic x/ocdd342096f8.ĕ Lx/oc59dbd08e27;
      // 1c: ifnull 54
      // 1f: goto 23
      // 22: athrow
      // 23: getstatic x/ocdd342096f8.į Z
      // 26: ifeq 54
      // 29: goto 2d
      // 2c: athrow
      // 2d: getstatic x/ocdd342096f8.Ӣ Lx/oc12021474b0;
      // 30: getstatic x/oc12021474b0.Ӝ Lx/oc12021474b0;
      // 33: if_acmpeq 54
      // 36: goto 3a
      // 39: athrow
      // 3a: invokestatic x/ocbb165642ef.ʨ ()Lx/ocbb165642ef;
      // 3d: aload 0
      // 3e: invokevirtual x/ocbb165642ef.D (Ljava/lang/Object;)Z
      // 41: iload 1
      // 42: ifne 51
      // 45: goto 49
      // 48: athrow
      // 49: ifeq 54
      // 4c: goto 50
      // 4f: athrow
      // 50: bipush 1
      // 51: goto 55
      // 54: bipush 0
      // 55: ireturn
   }

   public boolean ȥ() {
      return Ѱ.ǭ();
   }

   public MovingObjectPosition Կ(EntityLivingBase var1, double var2) {
      try {
         if (oc7ab2161b9f.Ð()) {
            return ocffa9e799de.Ǜ(var1, oc75d51ec7eb.d[0], oc75d51ec7eb.d[1], var2);
         }
      } catch (ocbde1165e4e var4) {
         throw var4;
      }

      return null;
   }

   public void Ҵ(float param1) {
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
      // 06: ifne 18
      // 09: invokevirtual x/ocdd342096f8.Đ ()Z
      // 0c: ifeq 88
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: invokevirtual x/ocdd342096f8.Ǒ ()Lnet/minecraft/entity/Entity;
      // 1b: getstatic x/oc75d51ec7eb.d [F
      // 1e: bipush 0
      // 1f: faload
      // 20: getstatic x/oc75d51ec7eb.d [F
      // 23: bipush 1
      // 24: faload
      // 25: getstatic x/ocdd342096f8.Ա D
      // 28: invokestatic x/ocffa9e799de.Ǜ (Lnet/minecraft/entity/Entity;FFD)Lnet/minecraft/util/MovingObjectPosition;
      // 2b: astore 3
      // 2c: aload 3
      // 2d: ifnull 88
      // 30: getstatic x/ocdd342096f8.Ѱ Lx/occ2f8dff8d8;
      // 33: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 36: iload 2
      // 37: ifne 62
      // 3a: goto 3e
      // 3d: athrow
      // 3e: ifne 65
      // 41: goto 45
      // 44: athrow
      // 45: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 48: iload 2
      // 49: ifne 81
      // 4c: goto 50
      // 4f: athrow
      // 50: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 53: fconst_1
      // 54: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 57: aload 3
      // 58: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 5b: invokestatic x/ocffa9e799de.Ǌ (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Z
      // 5e: goto 62
      // 61: athrow
      // 62: ifeq 88
      // 65: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 68: new net/minecraft/util/MovingObjectPosition
      // 6b: dup
      // 6c: aload 0
      // 6d: invokevirtual x/ocdd342096f8.Ǒ ()Lnet/minecraft/entity/Entity;
      // 70: aload 3
      // 71: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 74: invokespecial net/minecraft/util/MovingObjectPosition.<init> (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/Vec3;)V
      // 77: putfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 7a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 7d: goto 81
      // 80: athrow
      // 81: aload 0
      // 82: invokevirtual x/ocdd342096f8.Ǒ ()Lnet/minecraft/entity/Entity;
      // 85: putfield net/minecraft/client/Minecraft.pointedEntity Lnet/minecraft/entity/Entity;
      // 88: return
   }
}

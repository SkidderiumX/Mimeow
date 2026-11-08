package x;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class oc9817055016 extends oc69da1aa7f5 {
   private static final int Ҡ = 1;
   private static final int Σ = 0;
   private static final int ɟ = 1;
   private static final int Ê = 2;
   private static final String[] ȍ;
   public static oca9cc61aada Ţ;
   public static oca9cc61aada ư;
   public static occ2f8dff8d8 Ά;
   public static occ2f8dff8d8 Ĕ;
   public static occ2f8dff8d8 ʂ;
   public static occ2f8dff8d8 å;
   public static int ʮ;
   public static int գ;
   private final oc4d46a99983 Ù;
   private boolean Θ;
   private boolean ƈ;
   private int ș;
   private int ð = 647779099 ^ 1499704548;
   private Entity Ӛ;
   private int Ǡ = -647779100 ^ 1499704548;
   public static boolean ʝ;

   public oc9817055016() {
      super("KeepSprint", oce4cea752dd.ҕ, 0);
      this.ą("Reduces the sprint slowdown caused by attacks.");
      this.ʌ(this.Ù = new oc4d46a99983("Default is 40% motion reduction."));
      this.ʌ(Ţ = new oca9cc61aada("Mode", 0, ȍ));
      this.ʌ(Ά = new occ2f8dff8d8("Hypixel", false));
      this.ʌ(ư = new oca9cc61aada("Slow %", 40.0, 0.0, 40.0, 1.0));
      this.ʌ(Ĕ = new occ2f8dff8d8("Stop Sprint", true));
      this.ʌ(ʂ = new occ2f8dff8d8("Disable while jumping", false));
      this.ʌ(å = new occ2f8dff8d8("Only reduce reach hits", false));
      this.չ();
      this.ȓ();
   }

   public static void Ϗ(Entity param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: bipush 0
      // 001: getstatic x/oc9817055016.Ţ Lx/oca9cc61aada;
      // 004: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 007: d2i
      // 008: istore 2
      // 009: istore 1
      // 00a: invokestatic x/oc9817055016.ɾ ()Z
      // 00d: iload 1
      // 00e: ifne 01e
      // 011: ifeq 01d
      // 014: goto 018
      // 017: athrow
      // 018: invokestatic x/oc9817055016.Ս ()V
      // 01b: return
      // 01c: athrow
      // 01d: iload 2
      // 01e: iload 1
      // 01f: ifne 059
      // 022: bipush 1
      // 023: if_icmpne 058
      // 026: goto 02a
      // 029: athrow
      // 02a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 02d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 030: dup
      // 031: getfield net/minecraft/client/entity/EntityPlayerSP.motionX D
      // 034: ldc2_w 0.6
      // 037: dmul
      // 038: putfield net/minecraft/client/entity/EntityPlayerSP.motionX D
      // 03b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 03e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 041: dup
      // 042: getfield net/minecraft/client/entity/EntityPlayerSP.motionZ D
      // 045: ldc2_w 0.6
      // 048: dmul
      // 049: putfield net/minecraft/client/entity/EntityPlayerSP.motionZ D
      // 04c: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 04f: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 052: bipush 0
      // 053: invokevirtual net/minecraft/client/entity/EntityPlayerSP.setSprinting (Z)V
      // 056: return
      // 057: athrow
      // 058: bipush 0
      // 059: istore 3
      // 05a: getstatic x/oc9817055016.ʂ Lx/occ2f8dff8d8;
      // 05d: iload 1
      // 05e: ifne 090
      // 061: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 064: ifeq 089
      // 067: goto 06b
      // 06a: athrow
      // 06b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 06e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 071: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 074: iload 1
      // 075: ifne 093
      // 078: goto 07c
      // 07b: athrow
      // 07c: ifne 089
      // 07f: goto 083
      // 082: athrow
      // 083: bipush 1
      // 084: istore 3
      // 085: iload 1
      // 086: ifeq 183
      // 089: getstatic x/oc9817055016.å Lx/occ2f8dff8d8;
      // 08c: goto 090
      // 08f: athrow
      // 090: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 093: iload 1
      // 094: ifne 184
      // 097: ifeq 183
      // 09a: goto 09e
      // 09d: athrow
      // 09e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0a1: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0a4: getfield net/minecraft/client/entity/EntityPlayerSP.capabilities Lnet/minecraft/entity/player/PlayerCapabilities;
      // 0a7: getfield net/minecraft/entity/player/PlayerCapabilities.isCreativeMode Z
      // 0aa: iload 1
      // 0ab: ifne 184
      // 0ae: goto 0b2
      // 0b1: athrow
      // 0b2: ifne 183
      // 0b5: goto 0b9
      // 0b8: athrow
      // 0b9: ldc2_w -1.0
      // 0bc: dstore 4
      // 0be: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0c1: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0c4: fconst_1
      // 0c5: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 0c8: astore 6
      // 0ca: getstatic x/oc9755810e45.ÿ Lx/ocdd342096f8;
      // 0cd: iload 1
      // 0ce: ifne 0db
      // 0d1: ifnull 0fd
      // 0d4: goto 0d8
      // 0d7: athrow
      // 0d8: getstatic x/oc9755810e45.ÿ Lx/ocdd342096f8;
      // 0db: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 0de: ifeq 0fd
      // 0e1: getstatic x/ocdd342096f8.f Lnet/minecraft/entity/EntityLivingBase;
      // 0e4: ifnull 0fd
      // 0e7: goto 0eb
      // 0ea: athrow
      // 0eb: aload 6
      // 0ed: getstatic x/ocdd342096f8.f Lnet/minecraft/entity/EntityLivingBase;
      // 0f0: fconst_1
      // 0f1: invokevirtual net/minecraft/entity/EntityLivingBase.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 0f4: invokevirtual net/minecraft/util/Vec3.distanceTo (Lnet/minecraft/util/Vec3;)D
      // 0f7: dstore 4
      // 0f9: iload 1
      // 0fa: ifeq 15d
      // 0fd: getstatic x/oc9755810e45.Ɖ Lx/oc7e673dd779;
      // 100: iload 1
      // 101: ifne 112
      // 104: goto 108
      // 107: athrow
      // 108: ifnull 15d
      // 10b: goto 10f
      // 10e: athrow
      // 10f: getstatic x/oc9755810e45.Ɖ Lx/oc7e673dd779;
      // 112: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 115: iload 1
      // 116: ifne 169
      // 119: ifeq 15d
      // 11c: goto 120
      // 11f: athrow
      // 120: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 123: iload 1
      // 124: ifne 13c
      // 127: goto 12b
      // 12a: athrow
      // 12b: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 12e: ifnull 15d
      // 131: goto 135
      // 134: athrow
      // 135: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 138: goto 13c
      // 13b: athrow
      // 13c: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 13f: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 142: iload 1
      // 143: ifne 14f
      // 146: ifnull 15d
      // 149: goto 14d
      // 14c: athrow
      // 14d: aload 6
      // 14f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 152: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 155: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 158: invokevirtual net/minecraft/util/Vec3.distanceTo (Lnet/minecraft/util/Vec3;)D
      // 15b: dstore 4
      // 15d: dload 4
      // 15f: iload 1
      // 160: ifne 18d
      // 163: dconst_0
      // 164: dcmpl
      // 165: goto 169
      // 168: athrow
      // 169: iflt 183
      // 16c: dload 4
      // 16e: iload 1
      // 16f: ifne 18d
      // 172: goto 176
      // 175: athrow
      // 176: ldc2_w 3.0
      // 179: dcmpg
      // 17a: ifgt 183
      // 17d: goto 181
      // 180: athrow
      // 181: bipush 1
      // 182: istore 3
      // 183: iload 3
      // 184: getstatic x/oc9817055016.ư Lx/oca9cc61aada;
      // 187: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 18a: invokestatic x/oc9817055016.ǹ (ZD)D
      // 18d: dstore 4
      // 18f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 192: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 195: dup
      // 196: getfield net/minecraft/client/entity/EntityPlayerSP.motionX D
      // 199: dload 4
      // 19b: dmul
      // 19c: iload 1
      // 19d: ifne 1d2
      // 1a0: putfield net/minecraft/client/entity/EntityPlayerSP.motionX D
      // 1a3: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1a6: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1a9: dup
      // 1aa: getfield net/minecraft/client/entity/EntityPlayerSP.motionZ D
      // 1ad: dload 4
      // 1af: dmul
      // 1b0: putfield net/minecraft/client/entity/EntityPlayerSP.motionZ D
      // 1b3: getstatic x/oc9817055016.Ĕ Lx/occ2f8dff8d8;
      // 1b6: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 1b9: ifeq 1d5
      // 1bc: goto 1c0
      // 1bf: athrow
      // 1c0: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1c3: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1c6: dup
      // 1c7: getfield net/minecraft/client/entity/EntityPlayerSP.motionX D
      // 1ca: ldc2_w 0.5
      // 1cd: dmul
      // 1ce: goto 1d2
      // 1d1: athrow
      // 1d2: putfield net/minecraft/client/entity/EntityPlayerSP.motionX D
      // 1d5: return
   }

   static double ǹ(boolean var0, double var1) {
      try {
         if (var0) {
            return 0.6;
         }
      } catch (ocbde1165e4e var3) {
         throw var3;
      }

      return (100.0 - var1) / 100.0;
   }

   public static void ǎ(int var0) {
      ʮ = Math.max(0, Math.min(548524183 ^ 548524181, var0));
      գ = 0;
   }

   public static boolean ɾ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 0
      // 02: getstatic x/oc9817055016.Ţ Lx/oca9cc61aada;
      // 05: ifnull 42
      // 08: getstatic x/oc9817055016.Ά Lx/occ2f8dff8d8;
      // 0b: ifnull 42
      // 0e: goto 12
      // 11: athrow
      // 12: getstatic x/oc9817055016.Ţ Lx/oca9cc61aada;
      // 15: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 18: d2i
      // 19: iload 0
      // 1a: ifne 33
      // 1d: goto 21
      // 20: athrow
      // 21: bipush 1
      // 22: if_icmpne 42
      // 25: goto 29
      // 28: athrow
      // 29: getstatic x/oc9817055016.Ά Lx/occ2f8dff8d8;
      // 2c: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 2f: goto 33
      // 32: athrow
      // 33: iload 0
      // 34: ifne 3f
      // 37: ifeq 42
      // 3a: goto 3e
      // 3d: athrow
      // 3e: bipush 1
      // 3f: goto 43
      // 42: bipush 0
      // 43: ireturn
   }

   @Override
   public void onEnable() {
      this.չ();
   }

   @Override
   public void onDisable() {
      this.չ();
   }

   @Override
   public void z$2u87utkr1isxg() {
      this.ȓ();
   }

   @Override
   public void z$1sehylui0i4ix(oca9cc61aada var1) {
      try {
         if (var1 == Ţ) {
            this.ȓ();
            this.չ();
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }
   }

   @Override
   public void guiButtonToggled(occ2f8dff8d8 var1) {
      try {
         if (var1 == Ά) {
            this.չ();
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }

      super.guiButtonToggled(var1);
   }

   @Override
   public void z$3tl278wzjcayb(N param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 2
      // 02: aload 1
      // 03: iload 2
      // 04: ifne 16
      // 07: getstatic x/oc9817055016.Ţ Lx/oca9cc61aada;
      // 0a: if_acmpeq 1c
      // 0d: goto 11
      // 10: athrow
      // 11: aload 1
      // 12: goto 16
      // 15: athrow
      // 16: getstatic x/oc9817055016.Ά Lx/occ2f8dff8d8;
      // 19: if_acmpne 24
      // 1c: aload 0
      // 1d: invokevirtual x/oc9817055016.չ ()V
      // 20: goto 24
      // 23: athrow
      // 24: aload 0
      // 25: invokevirtual x/oc9817055016.ȓ ()V
      // 28: return
   }

   @oc66fa4f2195
   public void Ԋ(oc9adb807c19 var1) {
      try {
         if (var1.Ұ == oc110d7f376c.START) {
            this.ƈ = false;
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGHEST
   )
   public void Ђ(occ48acb5d22 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 2
      // 02: aload 1
      // 03: getfield x/occ48acb5d22.Ǖ Lnet/minecraft/entity/player/EntityPlayer;
      // 06: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 09: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0c: if_acmpeq 11
      // 0f: return
      // 10: athrow
      // 11: getstatic x/oc9817055016.Ţ Lx/oca9cc61aada;
      // 14: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 17: d2i
      // 18: istore 3
      // 19: iload 2
      // 1a: ifne 32
      // 1d: invokestatic x/oc9817055016.ɾ ()Z
      // 20: ifeq 2e
      // 23: goto 27
      // 26: athrow
      // 27: aload 0
      // 28: aload 1
      // 29: invokevirtual x/oc9817055016.ҍ (Lx/occ48acb5d22;)V
      // 2c: return
      // 2d: athrow
      // 2e: aload 0
      // 2f: invokevirtual x/oc9817055016.Ȧ ()V
      // 32: iload 3
      // 33: iload 2
      // 34: ifne 62
      // 37: bipush 1
      // 38: if_icmpeq 41
      // 3b: goto 3f
      // 3e: athrow
      // 3f: return
      // 40: athrow
      // 41: aload 0
      // 42: aload 1
      // 43: getfield x/occ48acb5d22.Ǻ Lnet/minecraft/entity/Entity;
      // 46: putfield x/oc9817055016.Ӛ Lnet/minecraft/entity/Entity;
      // 49: aload 0
      // 4a: iload 2
      // 4b: ifne 6f
      // 4e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 51: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 54: getfield net/minecraft/client/entity/EntityPlayerSP.ticksExisted I
      // 57: putfield x/oc9817055016.Ǡ I
      // 5a: aload 0
      // 5b: getfield x/oc9817055016.ð I
      // 5e: goto 62
      // 61: athrow
      // 62: ldc_w -1513907095
      // 65: ldc_w -1513907103
      // 68: ixor
      // 69: if_icmpge 6e
      // 6c: return
      // 6d: athrow
      // 6e: aload 0
      // 6f: invokevirtual x/oc9817055016.î ()Z
      // 72: ifeq 7e
      // 75: aload 1
      // 76: bipush 1
      // 77: invokevirtual x/oc68d6b191af.setCanceled (Z)V
      // 7a: goto 7e
      // 7d: athrow
      // 7e: return
   }

   @oc66fa4f2195
   public void Р(oc4c5a4d3446 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 2
      // 02: getstatic x/oc9817055016.Ţ Lx/oca9cc61aada;
      // 05: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 08: d2i
      // 09: iload 2
      // 0a: ifne 1c
      // 0d: bipush 1
      // 0e: if_icmpne 5c
      // 11: goto 15
      // 14: athrow
      // 15: invokestatic x/oc9817055016.ɾ ()Z
      // 18: goto 1c
      // 1b: athrow
      // 1c: ifne 5c
      // 1f: aload 1
      // 20: getfield x/oc4c5a4d3446.ȗ Lnet/minecraft/entity/EntityLivingBase;
      // 23: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 26: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 29: if_acmpne 5c
      // 2c: goto 30
      // 2f: athrow
      // 30: aload 0
      // 31: getfield x/oc9817055016.Θ Z
      // 34: iload 2
      // 35: ifne 50
      // 38: goto 3c
      // 3b: athrow
      // 3c: ifeq 5c
      // 3f: goto 43
      // 42: athrow
      // 43: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 46: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 49: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isSprinting ()Z
      // 4c: goto 50
      // 4f: athrow
      // 50: ifne 5c
      // 53: aload 1
      // 54: bipush 1
      // 55: invokevirtual x/oc68d6b191af.setCanceled (Z)V
      // 58: goto 5c
      // 5b: athrow
      // 5c: return
   }

   @oc66fa4f2195
   public void ϱ(oc2f61de30bc param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: bipush 0
      // 001: istore 2
      // 002: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 005: iload 2
      // 006: ifne 01c
      // 009: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 00c: ifnonnull 019
      // 00f: goto 013
      // 012: athrow
      // 013: aload 0
      // 014: invokevirtual x/oc9817055016.չ ()V
      // 017: return
      // 018: athrow
      // 019: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 01c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 01f: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 022: iload 2
      // 023: ifne 04a
      // 026: ifeq 03a
      // 029: goto 02d
      // 02c: athrow
      // 02d: aload 0
      // 02e: bipush 0
      // 02f: putfield x/oc9817055016.ș I
      // 032: iload 2
      // 033: ifeq 062
      // 036: goto 03a
      // 039: athrow
      // 03a: aload 0
      // 03b: iload 2
      // 03c: ifne 063
      // 03f: goto 043
      // 042: athrow
      // 043: getfield x/oc9817055016.ș I
      // 046: goto 04a
      // 049: athrow
      // 04a: ldc_w -1137483954
      // 04d: ldc_w -1009999695
      // 050: ixor
      // 051: if_icmpge 062
      // 054: aload 0
      // 055: dup
      // 056: getfield x/oc9817055016.ș I
      // 059: bipush 1
      // 05a: iadd
      // 05b: putfield x/oc9817055016.ș I
      // 05e: goto 062
      // 061: athrow
      // 062: aload 0
      // 063: getfield x/oc9817055016.ð I
      // 066: iload 2
      // 067: ifne 08d
      // 06a: ldc_w -1137483954
      // 06d: ldc_w -1009999695
      // 070: ixor
      // 071: if_icmpge 086
      // 074: goto 078
      // 077: athrow
      // 078: aload 0
      // 079: dup
      // 07a: getfield x/oc9817055016.ð I
      // 07d: bipush 1
      // 07e: iadd
      // 07f: putfield x/oc9817055016.ð I
      // 082: goto 086
      // 085: athrow
      // 086: getstatic x/oc9817055016.Ţ Lx/oca9cc61aada;
      // 089: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 08c: d2i
      // 08d: istore 3
      // 08e: iload 2
      // 08f: ifne 0af
      // 092: invokestatic x/oc9817055016.ɾ ()Z
      // 095: ifeq 0a3
      // 098: goto 09c
      // 09b: athrow
      // 09c: aload 0
      // 09d: bipush 0
      // 09e: putfield x/oc9817055016.Θ Z
      // 0a1: return
      // 0a2: athrow
      // 0a3: aload 0
      // 0a4: iload 2
      // 0a5: ifne 0b9
      // 0a8: invokevirtual x/oc9817055016.Ȧ ()V
      // 0ab: goto 0af
      // 0ae: athrow
      // 0af: iload 3
      // 0b0: bipush 1
      // 0b1: if_icmpeq 0be
      // 0b4: aload 0
      // 0b5: goto 0b9
      // 0b8: athrow
      // 0b9: bipush 0
      // 0ba: putfield x/oc9817055016.Θ Z
      // 0bd: return
      // 0be: getstatic x/oc9755810e45.ÿ Lx/ocdd342096f8;
      // 0c1: iload 2
      // 0c2: ifne 0cf
      // 0c5: ifnull 108
      // 0c8: goto 0cc
      // 0cb: athrow
      // 0cc: getstatic x/oc9755810e45.ÿ Lx/ocdd342096f8;
      // 0cf: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 0d2: iload 2
      // 0d3: ifne 111
      // 0d6: ifeq 108
      // 0d9: goto 0dd
      // 0dc: athrow
      // 0dd: aload 0
      // 0de: iload 2
      // 0df: ifne 0fc
      // 0e2: goto 0e6
      // 0e5: athrow
      // 0e6: getstatic x/ocdd342096f8.f Lnet/minecraft/entity/EntityLivingBase;
      // 0e9: putfield x/oc9817055016.Ӛ Lnet/minecraft/entity/Entity;
      // 0ec: aload 0
      // 0ed: getfield x/oc9817055016.Ӛ Lnet/minecraft/entity/Entity;
      // 0f0: ifnull 108
      // 0f3: goto 0f7
      // 0f6: athrow
      // 0f7: aload 0
      // 0f8: goto 0fc
      // 0fb: athrow
      // 0fc: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0ff: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 102: getfield net/minecraft/client/entity/EntityPlayerSP.ticksExisted I
      // 105: putfield x/oc9817055016.Ǡ I
      // 108: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 10b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 10e: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isSprinting ()Z
      // 111: iload 2
      // 112: ifne 12c
      // 115: ifne 12f
      // 118: goto 11c
      // 11b: athrow
      // 11c: aload 0
      // 11d: iload 2
      // 11e: ifne 130
      // 121: goto 125
      // 124: athrow
      // 125: invokevirtual x/oc9817055016.ƪ ()Z
      // 128: goto 12c
      // 12b: athrow
      // 12c: ifne 134
      // 12f: aload 0
      // 130: bipush 0
      // 131: putfield x/oc9817055016.Θ Z
      // 134: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.LOWEST
   )
   public void ʅ(oc2f61de30bc param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 03: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 06: ifnull 13
      // 09: invokestatic x/oc9817055016.ɾ ()Z
      // 0c: ifne 19
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: invokevirtual x/oc9817055016.Ȧ ()V
      // 17: return
      // 18: athrow
      // 19: aload 0
      // 1a: invokevirtual x/oc9817055016.ɰ ()V
      // 1d: return
   }

   @oc66fa4f2195
   public void Ӣ(oc057a60a0eb param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 2
      // 02: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 05: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 08: ifnull 1d
      // 0b: invokestatic x/oc9817055016.ɾ ()Z
      // 0e: iload 2
      // 0f: ifne 26
      // 12: goto 16
      // 15: athrow
      // 16: ifne 23
      // 19: goto 1d
      // 1c: athrow
      // 1d: aload 0
      // 1e: invokevirtual x/oc9817055016.Ȧ ()V
      // 21: return
      // 22: athrow
      // 23: getstatic x/oc9817055016.ʮ I
      // 26: iload 2
      // 27: ifne 4b
      // 2a: bipush 1
      // 2b: if_icmpne 44
      // 2e: goto 32
      // 31: athrow
      // 32: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 35: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 38: bipush 0
      // 39: invokevirtual net/minecraft/client/entity/EntityPlayerSP.setSprinting (Z)V
      // 3c: iload 2
      // 3d: ifeq 5c
      // 40: goto 44
      // 43: athrow
      // 44: getstatic x/oc9817055016.ʮ I
      // 47: goto 4b
      // 4a: athrow
      // 4b: ldc_w -555087435
      // 4e: ldc_w -555087433
      // 51: ixor
      // 52: if_icmpne 5c
      // 55: invokestatic x/oc9817055016.γ ()V
      // 58: goto 5c
      // 5b: athrow
      // 5c: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGHEST
   )
   public void Ý(oce79181588d param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 1
      // 01: invokevirtual x/oce79181588d.Ҡ ()Lnet/minecraft/network/Packet;
      // 04: instanceof net/minecraft/network/play/server/S12PacketEntityVelocity
      // 07: ifeq 3a
      // 0a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 10: ifnull 3a
      // 13: goto 17
      // 16: athrow
      // 17: aload 1
      // 18: invokevirtual x/oce79181588d.Ҡ ()Lnet/minecraft/network/Packet;
      // 1b: checkcast net/minecraft/network/play/server/S12PacketEntityVelocity
      // 1e: invokevirtual net/minecraft/network/play/server/S12PacketEntityVelocity.getEntityID ()I
      // 21: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 24: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 27: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getEntityId ()I
      // 2a: if_icmpne 3a
      // 2d: goto 31
      // 30: athrow
      // 31: aload 0
      // 32: bipush 0
      // 33: putfield x/oc9817055016.ð I
      // 36: goto 3a
      // 39: athrow
      // 3a: return
   }

   @oc66fa4f2195
   public void ƛ(ocbab3c9954b var1) {
      this.չ();
   }

   private void ҍ(occ48acb5d22 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 2
      // 02: aload 0
      // 03: getfield x/oc9817055016.ƈ Z
      // 06: iload 2
      // 07: ifne 19
      // 0a: ifeq 12
      // 0d: goto 11
      // 10: athrow
      // 11: return
      // 12: aload 1
      // 13: getfield x/occ48acb5d22.Ǻ Lnet/minecraft/entity/Entity;
      // 16: instanceof net/minecraft/entity/player/EntityPlayer
      // 19: iload 2
      // 1a: ifne 27
      // 1d: ifeq a0
      // 20: goto 24
      // 23: athrow
      // 24: getstatic x/oc9817055016.ʮ I
      // 27: iload 2
      // 28: ifne 78
      // 2b: ifne 71
      // 2e: goto 32
      // 31: athrow
      // 32: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 35: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 38: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isSprinting ()Z
      // 3b: iload 2
      // 3c: ifne 66
      // 3f: goto 43
      // 42: athrow
      // 43: ifeq 5b
      // 46: goto 4a
      // 49: athrow
      // 4a: aload 1
      // 4b: bipush 1
      // 4c: invokevirtual x/oc68d6b191af.setCanceled (Z)V
      // 4f: iload 2
      // 50: bipush 1
      // 51: putstatic x/oc9817055016.ʮ I
      // 54: ifeq 69
      // 57: goto 5b
      // 5a: athrow
      // 5b: ldc_w -1628689774
      // 5e: ldc_w -1628689776
      // 61: ixor
      // 62: goto 66
      // 65: athrow
      // 66: putstatic x/oc9817055016.ʮ I
      // 69: bipush 0
      // 6a: putstatic x/oc9817055016.գ I
      // 6d: iload 2
      // 6e: ifeq a0
      // 71: getstatic x/oc9817055016.ʮ I
      // 74: goto 78
      // 77: athrow
      // 78: iload 2
      // 79: ifne 9d
      // 7c: bipush 1
      // 7d: if_icmpne a0
      // 80: goto 84
      // 83: athrow
      // 84: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 87: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 8a: bipush 0
      // 8b: invokevirtual net/minecraft/client/entity/EntityPlayerSP.setSprinting (Z)V
      // 8e: bipush 0
      // 8f: putstatic x/oc9817055016.գ I
      // 92: ldc_w -1628689774
      // 95: ldc_w -1628689776
      // 98: ixor
      // 99: goto 9d
      // 9c: athrow
      // 9d: putstatic x/oc9817055016.ʮ I
      // a0: aload 0
      // a1: bipush 1
      // a2: putfield x/oc9817055016.ƈ Z
      // a5: return
   }

   private void ɰ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 1
      // 02: getstatic x/oc9817055016.գ I
      // 05: iload 1
      // 06: ifne 22
      // 09: ldc_w 1246586952
      // 0c: ldc_w 1246586957
      // 0f: ixor
      // 10: if_icmple 1f
      // 13: goto 17
      // 16: athrow
      // 17: aload 0
      // 18: invokevirtual x/oc9817055016.Ȧ ()V
      // 1b: goto 1f
      // 1e: athrow
      // 1f: getstatic x/oc9817055016.ʮ I
      // 22: iload 1
      // 23: ifne 4f
      // 26: bipush 1
      // 27: if_icmpne 48
      // 2a: goto 2e
      // 2d: athrow
      // 2e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 31: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 34: bipush 0
      // 35: invokevirtual net/minecraft/client/entity/EntityPlayerSP.setSprinting (Z)V
      // 38: iload 1
      // 39: getstatic x/oc9817055016.գ I
      // 3c: bipush 1
      // 3d: iadd
      // 3e: putstatic x/oc9817055016.գ I
      // 41: ifeq 70
      // 44: goto 48
      // 47: athrow
      // 48: getstatic x/oc9817055016.ʮ I
      // 4b: goto 4f
      // 4e: athrow
      // 4f: iload 1
      // 50: ifne 6d
      // 53: ldc_w 1246586959
      // 56: ldc_w 1246586957
      // 59: ixor
      // 5a: if_icmpne 70
      // 5d: goto 61
      // 60: athrow
      // 61: invokestatic x/oc9817055016.γ ()V
      // 64: bipush 0
      // 65: putstatic x/oc9817055016.գ I
      // 68: bipush 0
      // 69: goto 6d
      // 6c: athrow
      // 6d: putstatic x/oc9817055016.ʮ I
      // 70: return
   }

   private static void γ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 0
      // 02: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 05: iload 0
      // 06: ifne 25
      // 09: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0c: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isUsingItem ()Z
      // 0f: ifeq 22
      // 12: goto 16
      // 15: athrow
      // 16: invokestatic x/oc9817055016.Ò ()Z
      // 19: ifne 22
      // 1c: goto 20
      // 1f: athrow
      // 20: return
      // 21: athrow
      // 22: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 25: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 28: bipush 1
      // 29: invokevirtual net/minecraft/client/entity/EntityPlayerSP.setSprinting (Z)V
      // 2c: return
   }

   private static boolean Ò() {
      byte var1 = 0;
      int var2 = 742155083 ^ 902491868;
      boolean var0 = false;

      do {
         label238:
         while (true) {
            label234:
            while (true) {
               label232:
               while (true) {
                  label230:
                  while (true) {
                     label228:
                     while (true) {
                        label226:
                        while (true) {
                           label224:
                           while (true) {
                              label222:
                              while (true) {
                                 switch (var2) {
                                    case -1640479265:
                                       break label232;
                                    case -1334613713:
                                       break label234;
                                    case -1055076626:
                                       break label226;
                                    case -587693957:
                                       break label222;
                                    case -434794939:
                                       int var12;
                                       label204: {
                                          label203: {
                                             try {
                                                var12 = oc69da1aa7f5.ő.thePlayer.isUsingItem();
                                                if (var0) {
                                                   break label204;
                                                }

                                                if (var12 != 0) {
                                                   break label203;
                                                }
                                             } catch (ocbde1165e4e var11) {
                                                throw var11;
                                             }

                                             var2 = 1022888689 ^ 902491868;
                                             if (!var0) {
                                                continue;
                                             }
                                          }

                                          var12 = -952744558 ^ 902491868;
                                       }

                                       var2 = var12;
                                       if (!var0) {
                                          continue;
                                       }
                                    case 1911827504:
                                       var1 = 0;
                                       var2 = -382570841 ^ 902491868;
                                       if (!var0) {
                                          continue;
                                       }
                                       break;
                                    case -218322098:
                                       return false;
                                    case 53718889:
                                       break label230;
                                    case 154330157:
                                       break label224;
                                    case 319921256:
                                       return true;
                                    case 370418513:
                                       break label238;
                                    case 435588503:
                                       break label228;
                                    case 486480881:
                                       int var10000;
                                       label119: {
                                          label118: {
                                             try {
                                                var10000 = oc69da1aa7f5.ő.thePlayer.isCollidedHorizontally;
                                                if (var0) {
                                                   break label119;
                                                }

                                                if (oc69da1aa7f5.ő.thePlayer.isCollidedHorizontally) {
                                                   break label118;
                                                }
                                             } catch (ocbde1165e4e var3) {
                                                throw var3;
                                             }

                                             var2 = 922304949 ^ 902491868;
                                             if (!var0) {
                                                continue;
                                             }
                                          }

                                          var10000 = -952744558 ^ 902491868;
                                       }

                                       var2 = var10000;
                                       if (var0) {
                                          return false;
                                       }
                                       continue;
                                    case 1031188856:
                                       break;
                                    default:
                                       throw null;
                                 }

                                 int var13;
                                 label193: {
                                    label192: {
                                       try {
                                          var13 = (int)oc4557683e94.հ.Ӂ();
                                          if (var0) {
                                             break label193;
                                          }

                                          if (var13 != 0) {
                                             break label192;
                                          }
                                       } catch (ocbde1165e4e var10) {
                                          throw var10;
                                       }

                                       var2 = -187293646 ^ 902491868;
                                       if (!var0) {
                                          continue;
                                       }
                                    }

                                    var13 = 1144963820 ^ 902491868;
                                 }

                                 var2 = var13;
                                 if (var0) {
                                    break;
                                 }
                              }

                              int var14;
                              label183: {
                                 label182: {
                                    try {
                                       float var20;
                                       var14 = (var20 = oc69da1aa7f5.ő.thePlayer.moveForward - 0.0F) == 0.0F ? 0 : (var20 < 0.0F ? -1 : 1);
                                       if (var0) {
                                          break label183;
                                       }

                                       if (var14 <= 0) {
                                          break label182;
                                       }
                                    } catch (ocbde1165e4e var9) {
                                       throw var9;
                                    }

                                    var2 = -1410159869 ^ 902491868;
                                    if (!var0) {
                                       continue;
                                    }
                                 }

                                 var14 = -952744558 ^ 902491868;
                              }

                              var2 = var14;
                              if (var0) {
                                 break;
                              }
                           }

                           int var15;
                           label173: {
                              label172: {
                                 try {
                                    var15 = oc69da1aa7f5.ő.thePlayer.isSneaking();
                                    if (var0) {
                                       break label173;
                                    }

                                    if (var15 != 0) {
                                       break label172;
                                    }
                                 } catch (ocbde1165e4e var8) {
                                    throw var8;
                                 }

                                 var2 = 691402029 ^ 902491868;
                                 if (!var0) {
                                    continue;
                                 }
                              }

                              var15 = -952744558 ^ 902491868;
                           }

                           var2 = var15;
                           if (var0) {
                              break;
                           }
                        }

                        int var16;
                        label163: {
                           label162: {
                              try {
                                 float var21;
                                 var16 = (var21 = oc4557683e94.Ҳ() - 0.2F) == 0.0F ? 0 : (var21 < 0.0F ? -1 : 1);
                                 if (var0) {
                                    break label163;
                                 }

                                 if (var16 <= 0) {
                                    break label162;
                                 }
                              } catch (ocbde1165e4e var7) {
                                 throw var7;
                              }

                              var2 = 601804173 ^ 902491868;
                              if (!var0) {
                                 continue;
                              }
                           }

                           var16 = 1144963820 ^ 902491868;
                        }

                        var2 = var16;
                        if (var0) {
                           break;
                        }
                     }

                     if (oc9755810e45.ҩ != null) {
                        var2 = -2051438605 ^ 902491868;
                        if (!var0) {
                           continue;
                        }
                     }

                     var2 = 1144963820 ^ 902491868;
                     if (var0) {
                        break;
                     }
                  }

                  int var17;
                  label152: {
                     label151: {
                        try {
                           var17 = oc69da1aa7f5.ő.thePlayer.getFoodStats().getFoodLevel();
                           if (var0) {
                              break label152;
                           }

                           if (var17 <= (902491866 ^ 902491868)) {
                              break label151;
                           }
                        } catch (ocbde1165e4e var6) {
                           throw var6;
                        }

                        var2 = 651915956 ^ 902491868;
                        if (!var0) {
                           continue;
                        }
                     }

                     var17 = -952744558 ^ 902491868;
                  }

                  var2 = var17;
                  if (var0) {
                     break;
                  }
               }

               int var18;
               label142: {
                  label141: {
                     try {
                        var18 = var1;
                        if (var0) {
                           break label142;
                        }

                        if (var1 != 0) {
                           break label141;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var2 = -740335463 ^ 902491868;
                     if (!var0) {
                        continue;
                     }
                  }

                  var18 = 1022888689 ^ 902491868;
               }

               var2 = var18;
               if (var0) {
                  break;
               }
            }

            int var19;
            label131: {
               label130: {
                  try {
                     var19 = oc9755810e45.ҩ.z$3rzb3dil7uydr();
                     if (var0) {
                        break label131;
                     }

                     if (var19 == 0) {
                        break label130;
                     }
                  } catch (ocbde1165e4e var4) {
                     throw var4;
                  }

                  var2 = 146562980 ^ 902491868;
                  if (!var0) {
                     continue;
                  }
               }

               var19 = 1144963820 ^ 902491868;
            }

            var2 = var19;
            if (var0) {
               break;
            }
         }

         var1 = 1;
         var2 = -382570841 ^ 902491868;
      } while (!var0);

      return true;
   }

   private static void Ս() {
      boolean var0 = false;

      int var10000;
      label32: {
         try {
            var10000 = oc69da1aa7f5.ő.thePlayer.isSprinting();
            if (var0) {
               break label32;
            }

            if (var10000 == 0) {
               return;
            }
         } catch (ocbde1165e4e var2) {
            throw var2;
         }

         var10000 = ʮ;
      }

      try {
         if (var10000 == (-893698193 ^ -893698195)) {
            return;
         }
      } catch (ocbde1165e4e var1) {
         throw var1;
      }

      oc69da1aa7f5.ő.thePlayer.motionX *= 0.6;
      oc69da1aa7f5.ő.thePlayer.motionZ *= 0.6;
      oc69da1aa7f5.ő.thePlayer.setSprinting(false);
   }

   private boolean î() {
      boolean var1 = false;
      int var2 = -1535176090 ^ -2011442311;

      while (true) {
         switch (var2) {
            case -1344196146:
               return false;
            case -1277921636:
               return true;
            case 744800543:
               int var10000;
               label52: {
                  label51: {
                     try {
                        var10000 = this.ș;
                        if (var1) {
                           break label52;
                        }

                        if (this.ș != 1) {
                           break label51;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var2 = 1003464165 ^ -2011442311;
                     if (!var1) {
                        break;
                     }
                  }

                  var10000 = 531315498 ^ -2011442311;
               }

               var2 = var10000;
               if (!var1) {
                  break;
               }
            case -1750013869:
               int var5;
               label39: {
                  label38: {
                     try {
                        var5 = oc69da1aa7f5.ő.thePlayer.isSprinting();
                        if (var1) {
                           break label39;
                        }

                        if (var5 != 0) {
                           break label38;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = 670753463 ^ -2011442311;
                     if (!var1) {
                        break;
                     }
                  }

                  var5 = -1190179460 ^ -2011442311;
               }

               var2 = var5;
               if (!var1) {
                  break;
               }

               return true;
            case 823434757:
               oc69da1aa7f5.ő.thePlayer.setSprinting(false);
               KeyBinding.setKeyBindState(oc69da1aa7f5.ő.gameSettings.keyBindSprint.getKeyCode(), false);
               this.Θ = true;
               return true;
            default:
               throw null;
         }
      }
   }

   private boolean ƪ() {
      boolean var1 = false;
      int var2 = 2042753349 ^ 1712953271;

      while (true) {
         switch (var2) {
            case -1172269246:
               return true;
            case 206167522:
               int var8;
               label101: {
                  label100: {
                     try {
                        var8 = this.Ӛ.isDead;
                        if (var1) {
                           break label101;
                        }

                        if (!this.Ӛ.isDead) {
                           break label100;
                        }
                     } catch (ocbde1165e4e var6) {
                        throw var6;
                     }

                     var2 = 2097430365 ^ 1712953271;
                     if (!var1) {
                        continue;
                     }
                  }

                  var8 = 138413066 ^ 1712953271;
               }

               var2 = var8;
               if (!var1) {
                  continue;
               }
            case 1851364285:
               int var9;
               label90: {
                  label89: {
                     try {
                        var9 = this.Ӛ instanceof EntityLivingBase;
                        if (var1) {
                           break label90;
                        }

                        if (var9 == 0) {
                           break label89;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var2 = 510424164 ^ 1712953271;
                     if (!var1) {
                        continue;
                     }
                  }

                  var9 = 96630479 ^ 1712953271;
               }

               var2 = var9;
               if (!var1) {
                  continue;
               }
               break;
            case 341736500:
               return false;
            case 454928618:
               return false;
            case 534275826:
               break;
            case 637850868:
               return false;
            case 1675354488:
               int var7;
               label66: {
                  label65: {
                     try {
                        var7 = oc69da1aa7f5.ő.thePlayer.ticksExisted;
                        if (var1) {
                           break label66;
                        }

                        if (oc69da1aa7f5.ő.thePlayer.ticksExisted - this.Ǡ > (1712953277 ^ 1712953271)) {
                           break label65;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = -600243979 ^ 1712953271;
                     if (!var1) {
                        continue;
                     }
                  }

                  var7 = 1917315971 ^ 1712953271;
               }

               var2 = var7;
               continue;
            case 2020991955:
               int var10000;
               label75: {
                  label74: {
                     try {
                        float var10;
                        var10000 = (var10 = ((EntityLivingBase)this.Ӛ).getHealth() - 0.0F) == 0.0F ? 0 : (var10 < 0.0F ? -1 : 1);
                        if (var1) {
                           break label75;
                        }

                        if (var10000 > 0) {
                           break label74;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var2 = 1075659587 ^ 1712953271;
                     if (!var1) {
                        continue;
                     }
                  }

                  var10000 = 96630479 ^ 1712953271;
               }

               var2 = var10000;
               if (var1) {
                  return false;
               }
               continue;
            default:
               throw null;
         }

         if (this.Ӛ != null) {
            var2 = 1783646805 ^ 1712953271;
            if (!var1) {
               continue;
            }
         }

         var2 = 2097430365 ^ 1712953271;
         if (var1) {
            return true;
         }
      }
   }

   private void չ() {
      this.Θ = false;
      this.ș = 0;
      this.ð = -270339486 ^ -1877144163;
      this.Ӛ = null;
      this.Ǡ = 270339485 ^ -1877144163;
      this.Ȧ();
   }

   private void Ȧ() {
      ʮ = 0;
      գ = 0;
      this.ƈ = false;
   }

   private void ȓ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: getstatic x/oc9817055016.Ţ Lx/oca9cc61aada;
      // 04: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 07: d2i
      // 08: istore 2
      // 09: istore 1
      // 0a: iload 2
      // 0b: iload 1
      // 0c: ifne 17
      // 0f: ifne 1a
      // 12: goto 16
      // 15: athrow
      // 16: bipush 1
      // 17: goto 1b
      // 1a: bipush 0
      // 1b: istore 3
      // 1c: iload 2
      // 1d: iload 1
      // 1e: ifne 2e
      // 21: bipush 1
      // 22: if_icmpne 31
      // 25: goto 29
      // 28: athrow
      // 29: bipush 1
      // 2a: goto 2e
      // 2d: athrow
      // 2e: goto 32
      // 31: bipush 0
      // 32: istore 4
      // 34: aload 0
      // 35: getfield x/oc9817055016.Ù Lx/oc4d46a99983;
      // 38: iload 3
      // 39: aload 0
      // 3a: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 3d: getstatic x/oc9817055016.Ά Lx/occ2f8dff8d8;
      // 40: iload 4
      // 42: aload 0
      // 43: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 46: getstatic x/oc9817055016.ư Lx/oca9cc61aada;
      // 49: iload 3
      // 4a: aload 0
      // 4b: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 4e: getstatic x/oc9817055016.Ĕ Lx/occ2f8dff8d8;
      // 51: iload 3
      // 52: aload 0
      // 53: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 56: getstatic x/oc9817055016.ʂ Lx/occ2f8dff8d8;
      // 59: iload 3
      // 5a: aload 0
      // 5b: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 5e: getstatic x/oc9817055016.å Lx/occ2f8dff8d8;
      // 61: iload 3
      // 62: aload 0
      // 63: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 66: return
   }

   @Override
   public String getInfo() {
      return ȍ[Math.max(0, Math.min((int)Ţ.Ӂ(), ȍ.length - 1))];
   }

   static {
      String[] var10000 = new String[-428464970 ^ -428464972];
      var10000[0] = "Normal";
      var10000[1] = "Tick";
      ȍ = var10000;
   }
}

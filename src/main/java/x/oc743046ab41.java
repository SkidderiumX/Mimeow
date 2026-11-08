package x;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

public class oc743046ab41 extends oc69da1aa7f5 {
   public static oca9cc61aada Ւ;
   public static oca9cc61aada ǔ;
   public static oca9cc61aada Ч;
   public static oca9cc61aada ǌ;
   public static oca9cc61aada ԕ;
   public static oca9cc61aada Σ;
   private static final String[] ϑ;
   public static boolean Ǳ;

   public oc743046ab41() {
      super("Animations", oce4cea752dd.Ŏ);
      this.ʌ(Ւ = new oca9cc61aada("Mode", 1, ϑ));
      this.ʌ(ǔ = new oca9cc61aada("Scale", 1.0, 0.5, 2.0, 0.05));
      this.ʌ(Ч = new oca9cc61aada("X Offset", 0.0, -1.0, 1.0, 0.05));
      this.ʌ(ǌ = new oca9cc61aada("Y Offset", 0.0, -1.0, 1.0, 0.05));
      this.ʌ(ԕ = new oca9cc61aada("Z Offset", 0.0, -1.0, 1.0, 0.05));
      this.ʌ(Σ = new oca9cc61aada("Swing Speed", 1.0, -200.0, 50.0, 1.0));
   }

   public static boolean η() {
      boolean var10000 = oce6044968f8.ђ;
      oc69da1aa7f5 var1 = oc9755810e45.ʬ(oc743046ab41.class);
      boolean var0 = var10000;

      label33: {
         try {
            var4 = var1;
            if (var0) {
               break label33;
            }

            if (var1 == null) {
               return false;
            }
         } catch (ocbde1165e4e var3) {
            throw var3;
         }

         var4 = var1;
      }

      try {
         var10000 = var4.z$3rzb3dil7uydr();
         if (var0) {
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

   public static int ŀ(EntityLivingBase param0, int param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: ldc x/oc743046ab41
      // 05: invokestatic x/oc9755810e45.ʬ (Ljava/lang/Class;)Lx/oc69da1aa7f5;
      // 08: astore 3
      // 09: istore 2
      // 0a: aload 3
      // 0b: iload 2
      // 0c: ifne 17
      // 0f: ifnull 51
      // 12: goto 16
      // 15: athrow
      // 16: aload 3
      // 17: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 1a: iload 2
      // 1b: ifne 52
      // 1e: ifeq 51
      // 21: goto 25
      // 24: athrow
      // 25: aload 0
      // 26: invokestatic net/minecraft/client/Minecraft.getMinecraft ()Lnet/minecraft/client/Minecraft;
      // 29: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 2c: if_acmpne 51
      // 2f: goto 33
      // 32: athrow
      // 33: getstatic x/oc743046ab41.Σ Lx/oca9cc61aada;
      // 36: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 39: d2f
      // 3a: fstore 4
      // 3c: fload 4
      // 3e: fneg
      // 3f: ldc 100.0
      // 41: fdiv
      // 42: fconst_1
      // 43: fadd
      // 44: fstore 5
      // 46: bipush 1
      // 47: iload 1
      // 48: i2f
      // 49: fload 5
      // 4b: fmul
      // 4c: f2i
      // 4d: invokestatic java/lang/Math.max (II)I
      // 50: ireturn
      // 51: iload 1
      // 52: ireturn
   }

   public static boolean ɱ(float param0, float param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: istore 2
      // 004: invokestatic x/oc743046ab41.η ()Z
      // 007: iload 2
      // 008: ifne 01c
      // 00b: ifne 015
      // 00e: goto 012
      // 011: athrow
      // 012: bipush 0
      // 013: ireturn
      // 014: athrow
      // 015: getstatic x/oc743046ab41.Ւ Lx/oca9cc61aada;
      // 018: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 01b: d2i
      // 01c: istore 3
      // 01d: getstatic x/oc743046ab41.Ч Lx/oca9cc61aada;
      // 020: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 023: d2f
      // 024: getstatic x/oc743046ab41.ǌ Lx/oca9cc61aada;
      // 027: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 02a: d2f
      // 02b: getstatic x/oc743046ab41.ԕ Lx/oca9cc61aada;
      // 02e: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 031: d2f
      // 032: invokestatic net/minecraft/client/renderer/GlStateManager.translate (FFF)V
      // 035: fload 1
      // 036: fload 1
      // 037: fmul
      // 038: ldc 3.1415927
      // 03a: fmul
      // 03b: invokestatic net/minecraft/util/MathHelper.sin (F)F
      // 03e: fstore 4
      // 040: fload 1
      // 041: invokestatic net/minecraft/util/MathHelper.sqrt_float (F)F
      // 044: ldc 3.1415927
      // 046: fmul
      // 047: invokestatic net/minecraft/util/MathHelper.sin (F)F
      // 04a: fstore 5
      // 04c: fload 0
      // 04d: ldc 0.5
      // 04f: fmul
      // 050: fstore 6
      // 052: invokestatic net/minecraft/client/Minecraft.getMinecraft ()Lnet/minecraft/client/Minecraft;
      // 055: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 058: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isSneaking ()Z
      // 05b: ifeq 064
      // 05e: ldc -0.2
      // 060: goto 065
      // 063: athrow
      // 064: fconst_0
      // 065: fstore 7
      // 067: iload 2
      // 068: ifne 163
      // 06b: iload 3
      // 06c: tableswitch 238 0 4 37 53 76 123 182
      // 090: athrow
      // 091: fload 0
      // 092: fload 1
      // 093: invokestatic x/oc743046ab41.ť (FF)V
      // 096: iload 2
      // 097: invokestatic x/oc743046ab41.Б ()V
      // 09a: ifeq 166
      // 09d: goto 0a1
      // 0a0: athrow
      // 0a1: fload 1
      // 0a2: invokestatic x/oc743046ab41.ƒ (F)V
      // 0a5: iload 2
      // 0a6: fload 0
      // 0a7: fload 1
      // 0a8: invokestatic x/oc743046ab41.ť (FF)V
      // 0ab: invokestatic x/oc743046ab41.Б ()V
      // 0ae: invokestatic x/oc743046ab41.Ҽ ()V
      // 0b1: ifeq 166
      // 0b4: goto 0b8
      // 0b7: athrow
      // 0b8: ldc -0.1
      // 0ba: fload 1
      // 0bb: invokestatic x/oc743046ab41.ť (FF)V
      // 0be: iload 2
      // 0bf: ldc -0.5
      // 0c1: ldc 0.4
      // 0c3: ldc -0.2
      // 0c5: invokestatic net/minecraft/client/renderer/GlStateManager.translate (FFF)V
      // 0c8: ldc 32.0
      // 0ca: fconst_0
      // 0cb: fconst_1
      // 0cc: fconst_0
      // 0cd: invokestatic net/minecraft/client/renderer/GlStateManager.rotate (FFFF)V
      // 0d0: ldc -70.0
      // 0d2: fconst_1
      // 0d3: fconst_0
      // 0d4: fconst_0
      // 0d5: invokestatic net/minecraft/client/renderer/GlStateManager.rotate (FFFF)V
      // 0d8: ldc 40.0
      // 0da: fconst_0
      // 0db: fconst_1
      // 0dc: fconst_0
      // 0dd: invokestatic net/minecraft/client/renderer/GlStateManager.rotate (FFFF)V
      // 0e0: ifeq 166
      // 0e3: goto 0e7
      // 0e6: athrow
      // 0e7: fload 6
      // 0e9: fconst_0
      // 0ea: invokestatic x/oc743046ab41.ť (FF)V
      // 0ed: iload 2
      // 0ee: fload 5
      // 0f0: fneg
      // 0f1: ldc 20.0
      // 0f3: fmul
      // 0f4: fload 5
      // 0f6: ldc 0.5
      // 0f8: fmul
      // 0f9: fconst_0
      // 0fa: ldc 9.0
      // 0fc: invokestatic net/minecraft/client/renderer/GlStateManager.rotate (FFFF)V
      // 0ff: fload 5
      // 101: fneg
      // 102: ldc 30.0
      // 104: fmul
      // 105: fconst_1
      // 106: fload 5
      // 108: ldc 0.5
      // 10a: fmul
      // 10b: fconst_0
      // 10c: invokestatic net/minecraft/client/renderer/GlStateManager.rotate (FFFF)V
      // 10f: invokestatic x/oc743046ab41.Б ()V
      // 112: ldc -0.05
      // 114: fload 7
      // 116: ldc 0.1
      // 118: invokestatic net/minecraft/client/renderer/GlStateManager.translate (FFF)V
      // 11b: ifeq 166
      // 11e: goto 122
      // 121: athrow
      // 122: fload 6
      // 124: fload 1
      // 125: invokestatic x/oc743046ab41.ť (FF)V
      // 128: iload 2
      // 129: fload 4
      // 12b: ldc 15.0
      // 12d: fmul
      // 12e: fload 4
      // 130: fneg
      // 131: fconst_0
      // 132: ldc 9.0
      // 134: invokestatic net/minecraft/client/renderer/GlStateManager.rotate (FFFF)V
      // 137: fload 4
      // 139: ldc 40.0
      // 13b: fmul
      // 13c: fconst_1
      // 13d: fload 4
      // 13f: fneg
      // 140: ldc 0.5
      // 142: fmul
      // 143: fconst_0
      // 144: invokestatic net/minecraft/client/renderer/GlStateManager.rotate (FFFF)V
      // 147: invokestatic x/oc743046ab41.Б ()V
      // 14a: ldc -0.05
      // 14c: fload 7
      // 14e: ldc 0.1
      // 150: invokestatic net/minecraft/client/renderer/GlStateManager.translate (FFF)V
      // 153: ifeq 166
      // 156: goto 15a
      // 159: athrow
      // 15a: fload 0
      // 15b: fload 1
      // 15c: invokestatic x/oc743046ab41.ť (FF)V
      // 15f: goto 163
      // 162: athrow
      // 163: invokestatic x/oc743046ab41.Б ()V
      // 166: bipush 1
      // 167: ireturn
   }

   private static void ť(float var0, float var1) {
      ʪ(var0, var1);
      float var2 = (float)ǔ.Ӂ();
      GlStateManager.scale(var2, var2, var2);
   }

   private static void ƒ(float param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: invokestatic net/minecraft/client/Minecraft.getMinecraft ()Lnet/minecraft/client/Minecraft;
      // 06: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 09: astore 2
      // 0a: istore 1
      // 0b: aload 2
      // 0c: iload 1
      // 0d: ifne 19
      // 10: ifnonnull 18
      // 13: goto 17
      // 16: athrow
      // 17: return
      // 18: aload 2
      // 19: invokevirtual net/minecraft/entity/player/EntityPlayer.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 1c: astore 3
      // 1d: aload 3
      // 1e: iload 1
      // 1f: ifne 2a
      // 22: ifnull 84
      // 25: goto 29
      // 28: athrow
      // 29: aload 3
      // 2a: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 2d: iload 1
      // 2e: ifne 43
      // 31: instanceof net/minecraft/item/ItemCarrotOnAStick
      // 34: ifne 51
      // 37: goto 3b
      // 3a: athrow
      // 3b: aload 3
      // 3c: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 3f: goto 43
      // 42: athrow
      // 43: iload 1
      // 44: ifne 69
      // 47: instanceof net/minecraft/item/ItemFishingRod
      // 4a: ifeq 65
      // 4d: goto 51
      // 50: athrow
      // 51: ldc 0.08
      // 53: ldc -0.027
      // 55: ldc -0.33
      // 57: invokestatic net/minecraft/client/renderer/GlStateManager.translate (FFF)V
      // 5a: ldc 0.93
      // 5c: fconst_1
      // 5d: fconst_1
      // 5e: invokestatic net/minecraft/client/renderer/GlStateManager.scale (FFF)V
      // 61: goto 65
      // 64: athrow
      // 65: aload 3
      // 66: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 69: instanceof net/minecraft/item/ItemBow
      // 6c: iload 1
      // 6d: ifne 87
      // 70: ifeq 84
      // 73: goto 77
      // 76: athrow
      // 77: ldc -0.01
      // 79: ldc 0.05
      // 7b: ldc -0.06
      // 7d: invokestatic net/minecraft/client/renderer/GlStateManager.translate (FFF)V
      // 80: goto 84
      // 83: athrow
      // 84: fload 0
      // 85: fconst_0
      // 86: fcmpl
      // 87: iload 1
      // 88: ifne a2
      // 8b: ifeq d5
      // 8e: goto 92
      // 91: athrow
      // 92: aload 2
      // 93: iload 1
      // 94: ifne a6
      // 97: goto 9b
      // 9a: athrow
      // 9b: invokevirtual net/minecraft/entity/player/EntityPlayer.isPlayerSleeping ()Z
      // 9e: goto a2
      // a1: athrow
      // a2: ifne d5
      // a5: aload 2
      // a6: iload 1
      // a7: ifne b9
      // aa: invokevirtual net/minecraft/entity/player/EntityPlayer.isRiding ()Z
      // ad: ifne d5
      // b0: goto b4
      // b3: athrow
      // b4: aload 2
      // b5: goto b9
      // b8: athrow
      // b9: invokevirtual net/minecraft/entity/player/EntityPlayer.isBlocking ()Z
      // bc: ifne d5
      // bf: ldc 0.85
      // c1: ldc 0.85
      // c3: ldc 0.85
      // c5: invokestatic net/minecraft/client/renderer/GlStateManager.scale (FFF)V
      // c8: ldc -0.06
      // ca: ldc 0.003
      // cc: ldc 0.05
      // ce: invokestatic net/minecraft/client/renderer/GlStateManager.translate (FFF)V
      // d1: goto d5
      // d4: athrow
      // d5: return
   }

   private static void Ҽ() {
      GlStateManager.scale(0.83F, 0.88F, 0.85F);
      GlStateManager.translate(-0.3F, 0.1F, 0.0F);
   }

   private static void ʪ(float var0, float var1) {
      GlStateManager.translate(0.56F, -0.52F, -0.72F);
      GlStateManager.translate(0.0F, var0 * -0.6F, 0.0F);
      GlStateManager.rotate(45.0F, 0.0F, 1.0F, 0.0F);
      float var2 = MathHelper.sin(var1 * var1 * (float) Math.PI);
      float var3 = MathHelper.sin(MathHelper.sqrt_float(var1) * (float) Math.PI);
      GlStateManager.rotate(var2 * -20.0F, 0.0F, 1.0F, 0.0F);
      GlStateManager.rotate(var3 * -20.0F, 0.0F, 0.0F, 1.0F);
      GlStateManager.rotate(var3 * -80.0F, 1.0F, 0.0F, 0.0F);
      GlStateManager.scale(0.4F, 0.4F, 0.4F);
   }

   private static void Б() {
      GlStateManager.translate(-0.5F, 0.2F, 0.0F);
      GlStateManager.rotate(30.0F, 0.0F, 1.0F, 0.0F);
      GlStateManager.rotate(-80.0F, 1.0F, 0.0F, 0.0F);
      GlStateManager.rotate(60.0F, 0.0F, 1.0F, 0.0F);
   }

   static {
      String[] var10000 = new String[471044045 ^ 471044040];
      var10000[0] = "1.7B";
      var10000[1] = "1.7";
      var10000[471044042 ^ 471044040] = "Stella";
      var10000[471044043 ^ 471044040] = "Exhi";
      var10000[471044044 ^ 471044040] = "Shred";
      ϑ = var10000;
   }
}

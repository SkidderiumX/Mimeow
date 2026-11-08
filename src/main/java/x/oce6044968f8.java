package x;

import java.util.List;
import net.minecraft.client.gui.FontRenderer;

public class oce6044968f8 implements ocda171fe5d8 {
   private static final oc93499ec6de P = new oc93499ec6de();
   private static float Ӛ = 1.0F;
   private static boolean ĺ;
   private static long Ӎ;
   private static boolean ė;
   public static boolean ђ;

   private oce6044968f8() {
   }

   static oc93499ec6de Ŝ() {
      boolean var10000 = ђ;
      oc93499ec6de var1 = ocd2958dac48.պ();
      boolean var0 = var10000;

      try {
         if (var0) {
            return var1;
         }

         if (var1 == null) {
            return P;
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }

      return var1;
   }

   public static oc1378bc114d ԗ() {
      return Ƴ(1.0F);
   }

   public static oc1378bc114d Ƴ(float var0) {
      return ԓ(ocd2958dac48.ƛ(), Ƽ() * var0);
   }

   public static oc1378bc114d ԓ(String var0, float var1) {
      return new oce9c793ea6c(oc3ebac73392.ȯ(var0, var1));
   }

   public static oc1378bc114d Ɏ(FontRenderer var0) {
      return new oce9c793ea6c(new oca077e2210f(var0, 1.0F, false));
   }

   public static oc1378bc114d ʜ() {
      return ԗ();
   }

   public static oc1378bc114d Ѳ() {
      return new oce9c793ea6c(oc3ebac73392.ȯ(ocd2958dac48.ƛ(), Ƽ()), true);
   }

   public static float Ƽ() {
      return ocd2958dac48.Ѹ();
   }

   public static void н(Runnable var0) {
      boolean var1 = ė;
      ė = true;

      try {
         var0.run();
      } finally {
         ė = var1;
      }
   }

   private static float Ç() {
      try {
         if (ė) {
            return 1.0F;
         }
      } catch (ocbde1165e4e var0) {
         throw var0;
      }

      return Ƽ();
   }

   public static float ќ() {
      return (float)Ŝ().Ӓ.Ӂ() * Ç();
   }

   public static float ѹ() {
      return (float)Ŝ().Ļ.Ӂ() * Ç();
   }

   public static float Ё() {
      return 4.0F * Ç();
   }

   public static float ǆ() {
      return (float)Ŝ().ɿ.Ӂ() * Ç();
   }

   public static float š() {
      return (float)Ŝ().я.Ӂ() * Ç();
   }

   public static boolean ť() {
      return Ŝ().Ă();
   }

   public static boolean ʆ() {
      return Ŝ().ʍ();
   }

   public static float Ɗ() {
      return (float)Ŝ().Û.Ӂ();
   }

   public static float Ǵ() {
      return (float)Ŝ().Ϭ.Ӂ();
   }

   public static int ȭ(float var0, float var1) {
      return ocd2958dac48.Ǩ(var0, var1, ш());
   }

   public static oc9cd81f0bf1 Φ() {
      return oc9cd81f0bf1.ы(Ё(), 2006355099 ^ 429296795, ť(), ʆ());
   }

   public static void қ(float var0, float var1, float var2, float var3, Runnable var4) {
      ϟ(var0, var1, var2, var3, 1.0F, var4);
   }

   public static void ϟ(float var0, float var1, float var2, float var3, float var4, Runnable var5) {
      ѹ(var0, var1, var2, var3, var4, var5, null);
   }

   public static void ѹ(float var0, float var1, float var2, float var3, float var4, Runnable var5, Runnable var6) {
      Ҿ(List.of(new oc99b8eeba10(var0, var1, var2, var3, var4, var5, var6)));
   }

   public static void ӱ(float var0, float var1, float var2, float var3, Runnable var4) {
      Ӗ(var0, var1, var2, var3, 1.0F, var4);
   }

   public static void Ӗ(float var0, float var1, float var2, float var3, float var4, Runnable var5) {
      ΐ(new oc99b8eeba10(var0, var1, var2, var3, var4, var5, null), oc9cd81f0bf1.ӎ(Ё(), -1468744350 ^ -965427870, false, 0.0F, false, 0.0F));
   }

   public static void Ҿ(List<oc99b8eeba10> var0) {
      Š(var0, Φ());
   }

   public static void ΐ(oc99b8eeba10 var0, oc9cd81f0bf1 var1) {
      Š(List.of(var0), var1);
   }

   public static void Š(List<oc99b8eeba10> var0, oc9cd81f0bf1 var1) {
      ƺ(var0, var1, false);
   }

   static void Û(List<oc99b8eeba10> var0) {
      ƺ(var0, null, true);
   }

   private static void ƺ(List<oc99b8eeba10> param0, oc9cd81f0bf1 param1, boolean param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: istore 3
      // 004: aload 0
      // 005: invokeinterface java/util/List.isEmpty ()Z 1
      // 00a: ifeq 00f
      // 00d: return
      // 00e: athrow
      // 00f: invokestatic x/oce6044968f8.Ŝ ()Lx/oc93499ec6de;
      // 012: astore 4
      // 014: getstatic x/oce6044968f8.Ӛ F
      // 017: fstore 5
      // 019: getstatic x/oce6044968f8.ĺ Z
      // 01c: istore 6
      // 01e: getstatic x/oce6044968f8.Ӎ J
      // 021: lstore 7
      // 023: ldc 243602495
      // 025: ldc 243605326
      // 027: ixor
      // 028: invokestatic org/lwjgl/opengl/GL11.glIsEnabled (I)Z
      // 02b: istore 9
      // 02d: ldc 243602492
      // 02f: ldc 243605326
      // 031: ixor
      // 032: invokestatic org/lwjgl/opengl/GL11.glGetBoolean (I)Z
      // 035: istore 10
      // 037: invokestatic java/lang/System.currentTimeMillis ()J
      // 03a: putstatic x/oce6044968f8.Ӎ J
      // 03d: invokestatic net/minecraft/client/renderer/GlStateManager.disableDepth ()V
      // 040: bipush 0
      // 041: iload 3
      // 042: ifne 065
      // 045: invokestatic net/minecraft/client/renderer/GlStateManager.depthMask (Z)V
      // 048: iload 2
      // 049: ifeq 061
      // 04c: invokestatic x/oce6044968f8.ť ()Z
      // 04f: iload 3
      // 050: ifne 0b2
      // 053: goto 057
      // 056: athrow
      // 057: ifeq 0b1
      // 05a: goto 05e
      // 05d: athrow
      // 05e: goto 070
      // 061: aload 1
      // 062: getfield x/oc9cd81f0bf1.ӯ Z
      // 065: iload 3
      // 066: ifne 0b2
      // 069: ifeq 0b1
      // 06c: goto 070
      // 06f: athrow
      // 070: iload 2
      // 071: aload 0
      // 072: fload 5
      // 074: aload 1
      // 075: invokedynamic run (ZLjava/util/List;FLx/oc9cd81f0bf1;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, x/oce6044968f8.q1m0jmpa61fjq8 (ZLjava/util/List;FLx/oc9cd81f0bf1;)V, ()V ]
      // 07a: iload 2
      // 07b: iload 3
      // 07c: ifne 097
      // 07f: goto 083
      // 082: athrow
      // 083: ifeq 09a
      // 086: goto 08a
      // 089: athrow
      // 08a: aload 4
      // 08c: getfield x/oc93499ec6de.Ϸ Lx/oca9cc61aada;
      // 08f: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 092: d2i
      // 093: goto 097
      // 096: athrow
      // 097: goto 09e
      // 09a: aload 1
      // 09b: getfield x/oc9cd81f0bf1.ŉ I
      // 09e: iload 2
      // 09f: ifeq 0a9
      // 0a2: invokestatic x/oce6044968f8.Ɗ ()F
      // 0a5: goto 0ad
      // 0a8: athrow
      // 0a9: aload 1
      // 0aa: getfield x/oc9cd81f0bf1.վ F
      // 0ad: invokestatic x/oc1b46ea259e.ψ (Ljava/lang/Runnable;IF)Z
      // 0b0: pop
      // 0b1: iload 2
      // 0b2: iload 3
      // 0b3: ifne 0f8
      // 0b6: ifeq 0f3
      // 0b9: goto 0bd
      // 0bc: athrow
      // 0bd: invokestatic x/oce6044968f8.ʆ ()Z
      // 0c0: iload 3
      // 0c1: ifne 0f8
      // 0c4: goto 0c8
      // 0c7: athrow
      // 0c8: ifeq 0f3
      // 0cb: goto 0cf
      // 0ce: athrow
      // 0cf: aload 4
      // 0d1: aload 0
      // 0d2: fload 5
      // 0d4: iload 6
      // 0d6: invokedynamic run (Lx/oc93499ec6de;Ljava/util/List;FZ)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, x/oce6044968f8.qk0989p9ffov5 (Lx/oc93499ec6de;Ljava/util/List;FZ)V, ()V ]
      // 0db: aload 4
      // 0dd: getfield x/oc93499ec6de.ԗ Lx/oca9cc61aada;
      // 0e0: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0e3: d2i
      // 0e4: invokestatic x/oce6044968f8.Ǵ ()F
      // 0e7: invokestatic x/oc1b46ea259e.І (Ljava/lang/Runnable;IF)Z
      // 0ea: pop
      // 0eb: iload 3
      // 0ec: ifeq 12f
      // 0ef: goto 0f3
      // 0f2: athrow
      // 0f3: iload 2
      // 0f4: goto 0f8
      // 0f7: athrow
      // 0f8: iload 3
      // 0f9: ifne 13c
      // 0fc: ifne 12f
      // 0ff: goto 103
      // 102: athrow
      // 103: aload 1
      // 104: getfield x/oc9cd81f0bf1.ѣ Z
      // 107: iload 3
      // 108: ifne 13c
      // 10b: goto 10f
      // 10e: athrow
      // 10f: ifeq 12f
      // 112: goto 116
      // 115: athrow
      // 116: aload 0
      // 117: fload 5
      // 119: aload 1
      // 11a: invokedynamic run (Ljava/util/List;FLx/oc9cd81f0bf1;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, x/oce6044968f8.q2m8wjosja4yv (Ljava/util/List;FLx/oc9cd81f0bf1;)V, ()V ]
      // 11f: aload 1
      // 120: getfield x/oc9cd81f0bf1.ͼ I
      // 123: aload 1
      // 124: getfield x/oc9cd81f0bf1.ã F
      // 127: invokestatic x/oc1b46ea259e.І (Ljava/lang/Runnable;IF)Z
      // 12a: pop
      // 12b: goto 12f
      // 12e: athrow
      // 12f: bipush 0
      // 130: putstatic x/oce6044968f8.ĺ Z
      // 133: iload 3
      // 134: ifne 14a
      // 137: iload 2
      // 138: goto 13c
      // 13b: athrow
      // 13c: ifeq 14e
      // 13f: aload 0
      // 140: fload 5
      // 142: bipush 0
      // 143: invokestatic x/oce6044968f8.Ư (Ljava/util/List;FZ)V
      // 146: goto 14a
      // 149: athrow
      // 14a: iload 3
      // 14b: ifeq 15c
      // 14e: aload 0
      // 14f: fload 5
      // 151: aload 1
      // 152: getstatic x/oc65754b7e6f.ӧ Lx/oc65754b7e6f;
      // 155: invokestatic x/oce6044968f8.ϗ (Ljava/util/List;FLx/oc9cd81f0bf1;Lx/oc65754b7e6f;)V
      // 158: goto 15c
      // 15b: athrow
      // 15c: fload 5
      // 15e: putstatic x/oce6044968f8.Ӛ F
      // 161: iload 3
      // 162: ifne 191
      // 165: iload 6
      // 167: putstatic x/oce6044968f8.ĺ Z
      // 16a: lload 7
      // 16c: putstatic x/oce6044968f8.Ӎ J
      // 16f: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 172: invokevirtual net/minecraft/client/Minecraft.getFramebuffer ()Lnet/minecraft/client/shader/Framebuffer;
      // 175: bipush 1
      // 176: invokevirtual net/minecraft/client/shader/Framebuffer.bindFramebuffer (Z)V
      // 179: invokestatic net/minecraft/client/renderer/GlStateManager.enableTexture2D ()V
      // 17c: iload 10
      // 17e: invokestatic net/minecraft/client/renderer/GlStateManager.depthMask (Z)V
      // 181: iload 9
      // 183: ifeq 195
      // 186: goto 18a
      // 189: athrow
      // 18a: invokestatic net/minecraft/client/renderer/GlStateManager.enableDepth ()V
      // 18d: goto 191
      // 190: athrow
      // 191: iload 3
      // 192: ifeq 19c
      // 195: invokestatic net/minecraft/client/renderer/GlStateManager.disableDepth ()V
      // 198: goto 19c
      // 19b: athrow
      // 19c: ldc_w 10.0
      // 19f: invokestatic x/ocbd4917c4b1.В (F)V
      // 1a2: invokestatic x/ocbd4917c4b1.Ԃ ()V
      // 1a5: goto 1f2
      // 1a8: astore 11
      // 1aa: iload 3
      // 1ab: fload 5
      // 1ad: putstatic x/oce6044968f8.Ӛ F
      // 1b0: ifne 1db
      // 1b3: iload 6
      // 1b5: putstatic x/oce6044968f8.ĺ Z
      // 1b8: lload 7
      // 1ba: putstatic x/oce6044968f8.Ӎ J
      // 1bd: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 1c0: invokevirtual net/minecraft/client/Minecraft.getFramebuffer ()Lnet/minecraft/client/shader/Framebuffer;
      // 1c3: bipush 1
      // 1c4: invokevirtual net/minecraft/client/shader/Framebuffer.bindFramebuffer (Z)V
      // 1c7: invokestatic net/minecraft/client/renderer/GlStateManager.enableTexture2D ()V
      // 1ca: iload 10
      // 1cc: invokestatic net/minecraft/client/renderer/GlStateManager.depthMask (Z)V
      // 1cf: iload 9
      // 1d1: ifeq 1df
      // 1d4: invokestatic net/minecraft/client/renderer/GlStateManager.enableDepth ()V
      // 1d7: goto 1db
      // 1da: athrow
      // 1db: iload 3
      // 1dc: ifeq 1e6
      // 1df: invokestatic net/minecraft/client/renderer/GlStateManager.disableDepth ()V
      // 1e2: goto 1e6
      // 1e5: athrow
      // 1e6: ldc_w 10.0
      // 1e9: invokestatic x/ocbd4917c4b1.В (F)V
      // 1ec: invokestatic x/ocbd4917c4b1.Ԃ ()V
      // 1ef: aload 11
      // 1f1: athrow
      // 1f2: return
   }

   private static void ϗ(List<oc99b8eeba10> param0, float param1, oc9cd81f0bf1 param2, oc65754b7e6f param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: aload 0
      // 004: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 009: astore 5
      // 00b: istore 4
      // 00d: aload 5
      // 00f: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 014: ifeq 143
      // 017: aload 5
      // 019: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 01e: checkcast x/oc99b8eeba10
      // 021: astore 6
      // 023: aload 6
      // 025: getfield x/oc99b8eeba10.ŧ F
      // 028: fconst_0
      // 029: iload 4
      // 02b: ifne 045
      // 02e: fcmpg
      // 02f: ifle 00d
      // 032: goto 036
      // 035: athrow
      // 036: aload 6
      // 038: getfield x/oc99b8eeba10.ӎ F
      // 03b: iload 4
      // 03d: ifne 04e
      // 040: fconst_0
      // 041: goto 045
      // 044: athrow
      // 045: fcmpg
      // 046: ifle 00d
      // 049: aload 6
      // 04b: getfield x/oc99b8eeba10.ǹ F
      // 04e: iload 4
      // 050: ifne 06b
      // 053: fconst_0
      // 054: fcmpg
      // 055: ifgt 060
      // 058: goto 05c
      // 05b: athrow
      // 05c: goto 00d
      // 05f: athrow
      // 060: fload 1
      // 061: fconst_1
      // 062: aload 6
      // 064: getfield x/oc99b8eeba10.ǹ F
      // 067: invokestatic java/lang/Math.min (FF)F
      // 06a: fmul
      // 06b: putstatic x/oce6044968f8.Ӛ F
      // 06e: aload 3
      // 06f: iload 4
      // 071: ifne 084
      // 074: getstatic x/oc65754b7e6f.г Lx/oc65754b7e6f;
      // 077: if_acmpne 083
      // 07a: goto 07e
      // 07d: athrow
      // 07e: bipush -1
      // 07f: goto 096
      // 082: athrow
      // 083: aload 3
      // 084: getstatic x/oc65754b7e6f.Վ Lx/oc65754b7e6f;
      // 087: if_acmpne 092
      // 08a: aload 2
      // 08b: getfield x/oc9cd81f0bf1.ȯ I
      // 08e: goto 096
      // 091: athrow
      // 092: aload 2
      // 093: getfield x/oc9cd81f0bf1.ź I
      // 096: istore 7
      // 098: iload 7
      // 09a: ldc_w -807179781
      // 09d: ldc_w -807179805
      // 0a0: ixor
      // 0a1: iushr
      // 0a2: i2f
      // 0a3: getstatic x/oce6044968f8.Ӛ F
      // 0a6: fmul
      // 0a7: invokestatic java/lang/Math.round (F)I
      // 0aa: istore 8
      // 0ac: iload 8
      // 0ae: ifle 0f5
      // 0b1: aload 2
      // 0b2: getfield x/oc9cd81f0bf1.ȹ F
      // 0b5: aload 6
      // 0b7: getfield x/oc99b8eeba10.ŧ F
      // 0ba: aload 6
      // 0bc: getfield x/oc99b8eeba10.ӎ F
      // 0bf: invokestatic java/lang/Math.min (FF)F
      // 0c2: fconst_2
      // 0c3: fdiv
      // 0c4: invokestatic java/lang/Math.min (FF)F
      // 0c7: fstore 9
      // 0c9: aload 6
      // 0cb: getfield x/oc99b8eeba10.ө F
      // 0ce: aload 6
      // 0d0: getfield x/oc99b8eeba10.ɪ F
      // 0d3: aload 6
      // 0d5: getfield x/oc99b8eeba10.ө F
      // 0d8: aload 6
      // 0da: getfield x/oc99b8eeba10.ŧ F
      // 0dd: fadd
      // 0de: aload 6
      // 0e0: getfield x/oc99b8eeba10.ɪ F
      // 0e3: aload 6
      // 0e5: getfield x/oc99b8eeba10.ӎ F
      // 0e8: fadd
      // 0e9: fload 9
      // 0eb: iload 7
      // 0ed: iload 8
      // 0ef: invokestatic x/oc7ab2161b9f.Ҭ (II)I
      // 0f2: invokestatic x/ocbd4917c4b1.Ӛ (FFFFFI)V
      // 0f5: aload 3
      // 0f6: getstatic x/oc65754b7e6f.ӧ Lx/oc65754b7e6f;
      // 0f9: if_acmpne 13e
      // 0fc: aload 6
      // 0fe: iload 4
      // 100: ifne 121
      // 103: goto 107
      // 106: athrow
      // 107: getfield x/oc99b8eeba10.ұ Ljava/lang/Runnable;
      // 10a: ifnull 11f
      // 10d: goto 111
      // 110: athrow
      // 111: aload 6
      // 113: getfield x/oc99b8eeba10.ұ Ljava/lang/Runnable;
      // 116: invokeinterface java/lang/Runnable.run ()V 1
      // 11b: goto 11f
      // 11e: athrow
      // 11f: aload 6
      // 121: iload 4
      // 123: ifne 136
      // 126: getfield x/oc99b8eeba10.ɧ Ljava/lang/Runnable;
      // 129: ifnull 13e
      // 12c: goto 130
      // 12f: athrow
      // 130: aload 6
      // 132: goto 136
      // 135: athrow
      // 136: getfield x/oc99b8eeba10.ɧ Ljava/lang/Runnable;
      // 139: invokeinterface java/lang/Runnable.run ()V 1
      // 13e: iload 4
      // 140: ifeq 00d
      // 143: return
   }

   private static void Ư(List<oc99b8eeba10> param0, float param1, boolean param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: invokestatic x/oce6044968f8.Ŝ ()Lx/oc93499ec6de;
      // 003: astore 4
      // 005: getstatic x/oce6044968f8.ђ Z
      // 008: aload 4
      // 00a: getfield x/oc93499ec6de.ѥ Lx/oca9cc61aada;
      // 00d: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 010: d2i
      // 011: istore 5
      // 013: istore 3
      // 014: aload 0
      // 015: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 01a: astore 6
      // 01c: aload 6
      // 01e: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 023: ifeq 204
      // 026: aload 6
      // 028: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 02d: checkcast x/oc99b8eeba10
      // 030: astore 7
      // 032: aload 7
      // 034: getfield x/oc99b8eeba10.ŧ F
      // 037: iload 3
      // 038: ifne 049
      // 03b: fconst_0
      // 03c: fcmpg
      // 03d: ifle 01c
      // 040: goto 044
      // 043: athrow
      // 044: aload 7
      // 046: getfield x/oc99b8eeba10.ӎ F
      // 049: iload 3
      // 04a: ifne 05b
      // 04d: fconst_0
      // 04e: fcmpg
      // 04f: ifle 01c
      // 052: goto 056
      // 055: athrow
      // 056: aload 7
      // 058: getfield x/oc99b8eeba10.ǹ F
      // 05b: iload 3
      // 05c: ifne 077
      // 05f: fconst_0
      // 060: fcmpg
      // 061: ifgt 06c
      // 064: goto 068
      // 067: athrow
      // 068: goto 01c
      // 06b: athrow
      // 06c: fload 1
      // 06d: fconst_1
      // 06e: aload 7
      // 070: getfield x/oc99b8eeba10.ǹ F
      // 073: invokestatic java/lang/Math.min (FF)F
      // 076: fmul
      // 077: putstatic x/oce6044968f8.Ӛ F
      // 07a: iload 2
      // 07b: iload 3
      // 07c: ifne 0a9
      // 07f: ifeq 0a6
      // 082: goto 086
      // 085: athrow
      // 086: aload 7
      // 088: getfield x/oc99b8eeba10.ө F
      // 08b: aload 7
      // 08d: getfield x/oc99b8eeba10.ɪ F
      // 090: aload 7
      // 092: getfield x/oc99b8eeba10.ŧ F
      // 095: aload 7
      // 097: getfield x/oc99b8eeba10.ӎ F
      // 09a: bipush 1
      // 09b: invokestatic x/oce6044968f8.Ĕ (FFFFZ)V
      // 09e: iload 3
      // 09f: ifeq 01c
      // 0a2: goto 0a6
      // 0a5: athrow
      // 0a6: getstatic x/oce6044968f8.ĺ Z
      // 0a9: iload 3
      // 0aa: ifne 18e
      // 0ad: ifeq 180
      // 0b0: goto 0b4
      // 0b3: athrow
      // 0b4: iload 5
      // 0b6: iload 3
      // 0b7: ifne 0c7
      // 0ba: goto 0be
      // 0bd: athrow
      // 0be: ifeq 0d9
      // 0c1: goto 0c5
      // 0c4: athrow
      // 0c5: iload 5
      // 0c7: iload 3
      // 0c8: ifne 0f7
      // 0cb: ldc_w 424126315
      // 0ce: ldc_w 424126312
      // 0d1: ixor
      // 0d2: if_icmpne 0f5
      // 0d5: goto 0d9
      // 0d8: athrow
      // 0d9: aload 7
      // 0db: getfield x/oc99b8eeba10.ө F
      // 0de: aload 7
      // 0e0: getfield x/oc99b8eeba10.ɪ F
      // 0e3: aload 7
      // 0e5: getfield x/oc99b8eeba10.ŧ F
      // 0e8: aload 7
      // 0ea: getfield x/oc99b8eeba10.ӎ F
      // 0ed: bipush 0
      // 0ee: invokestatic x/oce6044968f8.Ĕ (FFFFZ)V
      // 0f1: goto 0f5
      // 0f4: athrow
      // 0f5: iload 5
      // 0f7: iload 3
      // 0f8: ifne 10f
      // 0fb: ldc_w 424126314
      // 0fe: ldc_w 424126312
      // 101: ixor
      // 102: if_icmpeq 121
      // 105: goto 109
      // 108: athrow
      // 109: iload 5
      // 10b: goto 10f
      // 10e: athrow
      // 10f: iload 3
      // 110: ifne 13e
      // 113: ldc_w 424126315
      // 116: ldc_w 424126312
      // 119: ixor
      // 11a: if_icmpne 13c
      // 11d: goto 121
      // 120: athrow
      // 121: aload 7
      // 123: getfield x/oc99b8eeba10.ө F
      // 126: aload 7
      // 128: getfield x/oc99b8eeba10.ɪ F
      // 12b: aload 7
      // 12d: getfield x/oc99b8eeba10.ŧ F
      // 130: aload 7
      // 132: getfield x/oc99b8eeba10.ӎ F
      // 135: invokestatic x/oce6044968f8.Ω (FFFF)V
      // 138: goto 13c
      // 13b: athrow
      // 13c: iload 5
      // 13e: iload 3
      // 13f: ifne 150
      // 142: bipush 1
      // 143: if_icmpeq 15a
      // 146: goto 14a
      // 149: athrow
      // 14a: iload 5
      // 14c: goto 150
      // 14f: athrow
      // 150: ldc_w 424126315
      // 153: ldc_w 424126312
      // 156: ixor
      // 157: if_icmpne 200
      // 15a: aload 7
      // 15c: iload 3
      // 15d: ifne 174
      // 160: goto 164
      // 163: athrow
      // 164: getfield x/oc99b8eeba10.ɧ Ljava/lang/Runnable;
      // 167: ifnull 200
      // 16a: goto 16e
      // 16d: athrow
      // 16e: aload 7
      // 170: goto 174
      // 173: athrow
      // 174: getfield x/oc99b8eeba10.ɧ Ljava/lang/Runnable;
      // 177: invokeinterface java/lang/Runnable.run ()V 1
      // 17c: iload 3
      // 17d: ifeq 200
      // 180: aload 4
      // 182: getfield x/oc93499ec6de.ƺ Lx/oca9cc61aada;
      // 185: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 188: dconst_0
      // 189: dcmpl
      // 18a: goto 18e
      // 18d: athrow
      // 18e: ifeq 1ad
      // 191: aload 7
      // 193: getfield x/oc99b8eeba10.ө F
      // 196: aload 7
      // 198: getfield x/oc99b8eeba10.ɪ F
      // 19b: aload 7
      // 19d: getfield x/oc99b8eeba10.ŧ F
      // 1a0: aload 7
      // 1a2: getfield x/oc99b8eeba10.ӎ F
      // 1a5: bipush 0
      // 1a6: invokestatic x/oce6044968f8.Ĕ (FFFFZ)V
      // 1a9: goto 1ad
      // 1ac: athrow
      // 1ad: aload 7
      // 1af: iload 3
      // 1b0: ifne 1e4
      // 1b3: getfield x/oc99b8eeba10.ө F
      // 1b6: aload 7
      // 1b8: getfield x/oc99b8eeba10.ɪ F
      // 1bb: aload 7
      // 1bd: getfield x/oc99b8eeba10.ŧ F
      // 1c0: aload 7
      // 1c2: getfield x/oc99b8eeba10.ӎ F
      // 1c5: invokestatic x/oce6044968f8.Ω (FFFF)V
      // 1c8: aload 7
      // 1ca: getfield x/oc99b8eeba10.ұ Ljava/lang/Runnable;
      // 1cd: ifnull 1e2
      // 1d0: goto 1d4
      // 1d3: athrow
      // 1d4: aload 7
      // 1d6: getfield x/oc99b8eeba10.ұ Ljava/lang/Runnable;
      // 1d9: invokeinterface java/lang/Runnable.run ()V 1
      // 1de: goto 1e2
      // 1e1: athrow
      // 1e2: aload 7
      // 1e4: iload 3
      // 1e5: ifne 1f8
      // 1e8: getfield x/oc99b8eeba10.ɧ Ljava/lang/Runnable;
      // 1eb: ifnull 200
      // 1ee: goto 1f2
      // 1f1: athrow
      // 1f2: aload 7
      // 1f4: goto 1f8
      // 1f7: athrow
      // 1f8: getfield x/oc99b8eeba10.ɧ Ljava/lang/Runnable;
      // 1fb: invokeinterface java/lang/Runnable.run ()V 1
      // 200: iload 3
      // 201: ifeq 01c
      // 204: return
   }

   private static void Ĕ(float param0, float param1, float param2, float param3, boolean param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: invokestatic x/oce6044968f8.Ŝ ()Lx/oc93499ec6de;
      // 006: astore 6
      // 008: istore 5
      // 00a: iload 4
      // 00c: iload 5
      // 00e: ifne 022
      // 011: ifeq 01f
      // 014: goto 018
      // 017: athrow
      // 018: ldc_w 255.0
      // 01b: goto 03b
      // 01e: athrow
      // 01f: getstatic x/oce6044968f8.ĺ Z
      // 022: ifeq 032
      // 025: aload 6
      // 027: getfield x/oc93499ec6de.Ѕ Lx/oca9cc61aada;
      // 02a: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 02d: d2f
      // 02e: goto 03b
      // 031: athrow
      // 032: aload 6
      // 034: getfield x/oc93499ec6de.Ǉ Lx/oca9cc61aada;
      // 037: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 03a: d2f
      // 03b: getstatic x/oce6044968f8.Ӛ F
      // 03e: fmul
      // 03f: invokestatic java/lang/Math.round (F)I
      // 042: istore 7
      // 044: iload 7
      // 046: iload 5
      // 048: ifne 05b
      // 04b: ifgt 053
      // 04e: goto 052
      // 051: athrow
      // 052: return
      // 053: aload 6
      // 055: getfield x/oc93499ec6de.ъ Lx/oc24a0a5bddf;
      // 058: invokevirtual x/oc24a0a5bddf.ͳ ()I
      // 05b: istore 8
      // 05d: fload 0
      // 05e: fload 1
      // 05f: invokestatic x/oce6044968f8.ȭ (FF)I
      // 062: istore 9
      // 064: iload 4
      // 066: iload 5
      // 068: ifne 081
      // 06b: ifeq 07a
      // 06e: goto 072
      // 071: athrow
      // 072: bipush -1
      // 073: istore 8
      // 075: iload 5
      // 077: ifeq 107
      // 07a: getstatic x/oce6044968f8.ĺ Z
      // 07d: goto 081
      // 080: athrow
      // 081: iload 5
      // 083: ifne 0ab
      // 086: ifeq 09b
      // 089: goto 08d
      // 08c: athrow
      // 08d: iload 9
      // 08f: iload 9
      // 091: invokestatic x/oce6044968f8.ή (II)I
      // 094: istore 8
      // 096: iload 5
      // 098: ifeq 107
      // 09b: aload 6
      // 09d: getfield x/oc93499ec6de.ƺ Lx/oca9cc61aada;
      // 0a0: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0a3: ldc2_w 2.0
      // 0a6: dcmpl
      // 0a7: goto 0ab
      // 0aa: athrow
      // 0ab: iload 5
      // 0ad: ifne 105
      // 0b0: ifeq 0ed
      // 0b3: goto 0b7
      // 0b6: athrow
      // 0b7: aload 6
      // 0b9: getfield x/oc93499ec6de.ƺ Lx/oca9cc61aada;
      // 0bc: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0bf: iload 5
      // 0c1: ifne 118
      // 0c4: goto 0c8
      // 0c7: athrow
      // 0c8: ldc2_w 3.0
      // 0cb: dcmpl
      // 0cc: ifne 107
      // 0cf: goto 0d3
      // 0d2: athrow
      // 0d3: aload 6
      // 0d5: getfield x/oc93499ec6de.ɔ Lx/oca9cc61aada;
      // 0d8: iload 5
      // 0da: ifne 115
      // 0dd: goto 0e1
      // 0e0: athrow
      // 0e1: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0e4: dconst_0
      // 0e5: dcmpl
      // 0e6: ifne 107
      // 0e9: goto 0ed
      // 0ec: athrow
      // 0ed: iload 8
      // 0ef: iload 9
      // 0f1: aload 6
      // 0f3: getfield x/oc93499ec6de.Ɲ Lx/oca9cc61aada;
      // 0f6: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0f9: d2f
      // 0fa: ldc_w 100.0
      // 0fd: fdiv
      // 0fe: invokestatic x/oc67aa5109f0.Ò (IIF)I
      // 101: goto 105
      // 104: athrow
      // 105: istore 8
      // 107: iload 8
      // 109: iload 7
      // 10b: invokestatic x/oc7ab2161b9f.Ҭ (II)I
      // 10e: istore 8
      // 110: aload 6
      // 112: getfield x/oc93499ec6de.ʟ Lx/oca9cc61aada;
      // 115: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 118: d2f
      // 119: invokestatic x/oce6044968f8.Ç ()F
      // 11c: fmul
      // 11d: fload 2
      // 11e: fload 3
      // 11f: invokestatic java/lang/Math.min (FF)F
      // 122: fconst_2
      // 123: fdiv
      // 124: invokestatic java/lang/Math.min (FF)F
      // 127: fstore 10
      // 129: iload 4
      // 12b: iload 5
      // 12d: ifne 13a
      // 130: ifne 1f4
      // 133: goto 137
      // 136: athrow
      // 137: getstatic x/oce6044968f8.ĺ Z
      // 13a: iload 5
      // 13c: ifne 15f
      // 13f: ifne 1f4
      // 142: goto 146
      // 145: athrow
      // 146: aload 6
      // 148: getfield x/oc93499ec6de.ƺ Lx/oca9cc61aada;
      // 14b: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 14e: iload 5
      // 150: ifne 177
      // 153: goto 157
      // 156: athrow
      // 157: ldc2_w 3.0
      // 15a: dcmpl
      // 15b: goto 15f
      // 15e: athrow
      // 15f: ifne 1f4
      // 162: aload 6
      // 164: iload 5
      // 166: ifne 18a
      // 169: goto 16d
      // 16c: athrow
      // 16d: getfield x/oc93499ec6de.ɔ Lx/oca9cc61aada;
      // 170: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 173: goto 177
      // 176: athrow
      // 177: dconst_1
      // 178: dcmpl
      // 179: ifne 188
      // 17c: aload 6
      // 17e: getfield x/oc93499ec6de.ͷ Lx/oc24a0a5bddf;
      // 181: invokevirtual x/oc24a0a5bddf.ͳ ()I
      // 184: goto 1ad
      // 187: athrow
      // 188: aload 6
      // 18a: getfield x/oc93499ec6de.ъ Lx/oc24a0a5bddf;
      // 18d: invokevirtual x/oc24a0a5bddf.ͳ ()I
      // 190: fload 0
      // 191: fload 2
      // 192: fadd
      // 193: fload 1
      // 194: fload 3
      // 195: fadd
      // 196: ldc_w 40.0
      // 199: fadd
      // 19a: invokestatic x/oce6044968f8.ȭ (FF)I
      // 19d: aload 6
      // 19f: getfield x/oc93499ec6de.Ɲ Lx/oca9cc61aada;
      // 1a2: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 1a5: d2f
      // 1a6: ldc_w 100.0
      // 1a9: fdiv
      // 1aa: invokestatic x/oc67aa5109f0.Ò (IIF)I
      // 1ad: istore 11
      // 1af: iload 5
      // 1b1: iload 8
      // 1b3: iload 11
      // 1b5: iload 7
      // 1b7: invokestatic x/oc7ab2161b9f.Ҭ (II)I
      // 1ba: aload 6
      // 1bc: getfield x/oc93499ec6de.Ψ Lx/oca9cc61aada;
      // 1bf: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 1c2: d2i
      // 1c3: invokestatic x/oc67aa5109f0.ÿ (III)[I
      // 1c6: astore 12
      // 1c8: fload 0
      // 1c9: fload 1
      // 1ca: fload 0
      // 1cb: fload 2
      // 1cc: fadd
      // 1cd: fload 1
      // 1ce: fload 3
      // 1cf: fadd
      // 1d0: fload 10
      // 1d2: aload 12
      // 1d4: bipush 0
      // 1d5: iaload
      // 1d6: aload 12
      // 1d8: bipush 1
      // 1d9: iaload
      // 1da: aload 12
      // 1dc: ldc_w -338468413
      // 1df: ldc_w -338468415
      // 1e2: ixor
      // 1e3: iaload
      // 1e4: aload 12
      // 1e6: ldc_w -338468414
      // 1e9: ldc_w -338468415
      // 1ec: ixor
      // 1ed: iaload
      // 1ee: invokestatic x/ocbd4917c4b1.Ӷ (FFFFFIIII)V
      // 1f1: ifeq 207
      // 1f4: fload 0
      // 1f5: fload 1
      // 1f6: fload 0
      // 1f7: fload 2
      // 1f8: fadd
      // 1f9: fload 1
      // 1fa: fload 3
      // 1fb: fadd
      // 1fc: fload 10
      // 1fe: iload 8
      // 200: invokestatic x/ocbd4917c4b1.Ӛ (FFFFFI)V
      // 203: goto 207
      // 206: athrow
      // 207: return
   }

   private static void Ω(float param0, float param1, float param2, float param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: invokestatic x/oce6044968f8.Ŝ ()Lx/oc93499ec6de;
      // 006: astore 5
      // 008: istore 4
      // 00a: aload 5
      // 00c: getfield x/oc93499ec6de.ӱ Lx/oca9cc61aada;
      // 00f: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 012: d2i
      // 013: istore 6
      // 015: getstatic x/oce6044968f8.ĺ Z
      // 018: ifeq 028
      // 01b: aload 5
      // 01d: getfield x/oc93499ec6de.Ѕ Lx/oca9cc61aada;
      // 020: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 023: d2f
      // 024: goto 031
      // 027: athrow
      // 028: aload 5
      // 02a: getfield x/oc93499ec6de.Ù Lx/oca9cc61aada;
      // 02d: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 030: d2f
      // 031: getstatic x/oce6044968f8.Ӛ F
      // 034: fmul
      // 035: invokestatic java/lang/Math.round (F)I
      // 038: istore 7
      // 03a: iload 6
      // 03c: iload 4
      // 03e: ifne 04a
      // 041: ifeq 04d
      // 044: goto 048
      // 047: athrow
      // 048: iload 7
      // 04a: ifgt 04e
      // 04d: return
      // 04e: aload 5
      // 050: getfield x/oc93499ec6de.ѝ Lx/oca9cc61aada;
      // 053: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 056: d2f
      // 057: invokestatic x/oce6044968f8.Ç ()F
      // 05a: fmul
      // 05b: fload 2
      // 05c: fload 3
      // 05d: invokestatic java/lang/Math.min (FF)F
      // 060: fconst_2
      // 061: fdiv
      // 062: invokestatic java/lang/Math.min (FF)F
      // 065: fstore 8
      // 067: fload 0
      // 068: fload 1
      // 069: invokestatic x/oce6044968f8.ȭ (FF)I
      // 06c: istore 9
      // 06e: aload 5
      // 070: iload 4
      // 072: ifne 08c
      // 075: getfield x/oc93499ec6de.ƚ Lx/oca9cc61aada;
      // 078: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 07b: dconst_0
      // 07c: dcmpl
      // 07d: ifne 08a
      // 080: goto 084
      // 083: athrow
      // 084: iload 9
      // 086: goto 0ad
      // 089: athrow
      // 08a: aload 5
      // 08c: iload 4
      // 08e: ifne 0a7
      // 091: getfield x/oc93499ec6de.ƚ Lx/oca9cc61aada;
      // 094: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 097: dconst_1
      // 098: dcmpl
      // 099: ifne 0a5
      // 09c: goto 0a0
      // 09f: athrow
      // 0a0: bipush -1
      // 0a1: goto 0ad
      // 0a4: athrow
      // 0a5: aload 5
      // 0a7: getfield x/oc93499ec6de.џ Lx/oc24a0a5bddf;
      // 0aa: invokevirtual x/oc24a0a5bddf.ͳ ()I
      // 0ad: istore 10
      // 0af: getstatic x/oce6044968f8.ĺ Z
      // 0b2: iload 4
      // 0b4: ifne 0c9
      // 0b7: ifeq 0cc
      // 0ba: goto 0be
      // 0bd: athrow
      // 0be: iload 10
      // 0c0: iload 9
      // 0c2: invokestatic x/oce6044968f8.ή (II)I
      // 0c5: goto 0c9
      // 0c8: athrow
      // 0c9: goto 0ce
      // 0cc: iload 10
      // 0ce: iload 7
      // 0d0: invokestatic x/oc7ab2161b9f.Ҭ (II)I
      // 0d3: iload 4
      // 0d5: ifne 0ec
      // 0d8: istore 10
      // 0da: iload 6
      // 0dc: ldc_w 1946389396
      // 0df: ldc_w 1946389398
      // 0e2: ixor
      // 0e3: if_icmpeq 0ff
      // 0e6: iload 6
      // 0e8: goto 0ec
      // 0eb: athrow
      // 0ec: iload 4
      // 0ee: ifne 130
      // 0f1: ldc_w 1946389397
      // 0f4: ldc_w 1946389398
      // 0f7: ixor
      // 0f8: if_icmpne 12a
      // 0fb: goto 0ff
      // 0fe: athrow
      // 0ff: aload 5
      // 101: getfield x/oc93499ec6de.ʟ Lx/oca9cc61aada;
      // 104: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 107: d2f
      // 108: invokestatic x/oce6044968f8.Ç ()F
      // 10b: fmul
      // 10c: fload 2
      // 10d: fload 3
      // 10e: invokestatic java/lang/Math.min (FF)F
      // 111: fconst_2
      // 112: fdiv
      // 113: invokestatic java/lang/Math.min (FF)F
      // 116: fstore 11
      // 118: iload 4
      // 11a: fload 0
      // 11b: fload 1
      // 11c: fload 2
      // 11d: fload 3
      // 11e: fload 11
      // 120: fload 8
      // 122: iload 10
      // 124: invokestatic x/oce6044968f8.Ҩ (FFFFFFI)V
      // 127: ifeq 213
      // 12a: iload 6
      // 12c: goto 130
      // 12f: athrow
      // 130: iload 4
      // 132: ifne 162
      // 135: ldc_w 1946389394
      // 138: ldc_w 1946389398
      // 13b: ixor
      // 13c: if_icmpeq 15c
      // 13f: goto 143
      // 142: athrow
      // 143: iload 6
      // 145: iload 4
      // 147: ifne 19f
      // 14a: goto 14e
      // 14d: athrow
      // 14e: ldc_w 1946389395
      // 151: ldc_w 1946389398
      // 154: ixor
      // 155: if_icmpne 192
      // 158: goto 15c
      // 15b: athrow
      // 15c: iload 6
      // 15e: goto 162
      // 161: athrow
      // 162: ldc_w 1946389394
      // 165: ldc_w 1946389398
      // 168: ixor
      // 169: if_icmpne 171
      // 16c: fload 1
      // 16d: goto 177
      // 170: athrow
      // 171: fload 1
      // 172: fload 3
      // 173: fadd
      // 174: fload 8
      // 176: fsub
      // 177: fstore 11
      // 179: iload 4
      // 17b: fload 0
      // 17c: f2d
      // 17d: fload 11
      // 17f: f2d
      // 180: fload 0
      // 181: fload 2
      // 182: fadd
      // 183: f2d
      // 184: fload 11
      // 186: fload 8
      // 188: fadd
      // 189: f2d
      // 18a: iload 10
      // 18c: invokestatic x/ocbd4917c4b1.ĉ (DDDDI)V
      // 18f: ifeq 213
      // 192: aload 5
      // 194: getfield x/oc93499ec6de.Ƌ Lx/oca9cc61aada;
      // 197: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 19a: d2i
      // 19b: goto 19f
      // 19e: athrow
      // 19f: istore 11
      // 1a1: iload 11
      // 1a3: iload 4
      // 1a5: ifne 1b1
      // 1a8: ifeq 1c4
      // 1ab: goto 1af
      // 1ae: athrow
      // 1af: iload 11
      // 1b1: iload 4
      // 1b3: ifne 1e0
      // 1b6: ldc_w 1946389396
      // 1b9: ldc_w 1946389398
      // 1bc: ixor
      // 1bd: if_icmpne 1de
      // 1c0: goto 1c4
      // 1c3: athrow
      // 1c4: fload 0
      // 1c5: fload 2
      // 1c6: fadd
      // 1c7: fload 8
      // 1c9: fsub
      // 1ca: f2d
      // 1cb: fload 1
      // 1cc: f2d
      // 1cd: fload 0
      // 1ce: fload 2
      // 1cf: fadd
      // 1d0: f2d
      // 1d1: fload 1
      // 1d2: fload 3
      // 1d3: fadd
      // 1d4: f2d
      // 1d5: iload 10
      // 1d7: invokestatic x/ocbd4917c4b1.ĉ (DDDDI)V
      // 1da: goto 1de
      // 1dd: athrow
      // 1de: iload 11
      // 1e0: iload 4
      // 1e2: ifne 1f3
      // 1e5: bipush 1
      // 1e6: if_icmpeq 1fd
      // 1e9: goto 1ed
      // 1ec: athrow
      // 1ed: iload 11
      // 1ef: goto 1f3
      // 1f2: athrow
      // 1f3: ldc_w 1946389396
      // 1f6: ldc_w 1946389398
      // 1f9: ixor
      // 1fa: if_icmpne 213
      // 1fd: fload 0
      // 1fe: f2d
      // 1ff: fload 1
      // 200: f2d
      // 201: fload 0
      // 202: fload 8
      // 204: fadd
      // 205: f2d
      // 206: fload 1
      // 207: fload 3
      // 208: fadd
      // 209: f2d
      // 20a: iload 10
      // 20c: invokestatic x/ocbd4917c4b1.ĉ (DDDDI)V
      // 20f: goto 213
      // 212: athrow
      // 213: return
   }

   private static void Ҩ(float param0, float param1, float param2, float param3, float param4, float param5, int param6) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: istore 7
      // 005: fload 4
      // 007: iload 7
      // 009: ifne 104
      // 00c: fconst_0
      // 00d: fcmpg
      // 00e: ifgt 073
      // 011: goto 015
      // 014: athrow
      // 015: fload 0
      // 016: f2d
      // 017: fload 1
      // 018: f2d
      // 019: fload 0
      // 01a: fload 2
      // 01b: fadd
      // 01c: f2d
      // 01d: fload 1
      // 01e: fload 5
      // 020: fadd
      // 021: f2d
      // 022: iload 6
      // 024: invokestatic x/ocbd4917c4b1.ĉ (DDDDI)V
      // 027: fload 0
      // 028: f2d
      // 029: fload 1
      // 02a: fload 3
      // 02b: fadd
      // 02c: fload 5
      // 02e: fsub
      // 02f: f2d
      // 030: fload 0
      // 031: fload 2
      // 032: fadd
      // 033: f2d
      // 034: fload 1
      // 035: fload 3
      // 036: fadd
      // 037: f2d
      // 038: iload 6
      // 03a: invokestatic x/ocbd4917c4b1.ĉ (DDDDI)V
      // 03d: fload 0
      // 03e: f2d
      // 03f: fload 1
      // 040: fload 5
      // 042: fadd
      // 043: f2d
      // 044: fload 0
      // 045: fload 5
      // 047: fadd
      // 048: f2d
      // 049: fload 1
      // 04a: fload 3
      // 04b: fadd
      // 04c: fload 5
      // 04e: fsub
      // 04f: f2d
      // 050: iload 6
      // 052: invokestatic x/ocbd4917c4b1.ĉ (DDDDI)V
      // 055: fload 0
      // 056: fload 2
      // 057: fadd
      // 058: fload 5
      // 05a: fsub
      // 05b: f2d
      // 05c: fload 1
      // 05d: fload 5
      // 05f: fadd
      // 060: f2d
      // 061: fload 0
      // 062: fload 2
      // 063: fadd
      // 064: f2d
      // 065: fload 1
      // 066: fload 3
      // 067: fadd
      // 068: fload 5
      // 06a: fsub
      // 06b: f2d
      // 06c: iload 6
      // 06e: invokestatic x/ocbd4917c4b1.ĉ (DDDDI)V
      // 071: return
      // 072: athrow
      // 073: ldc_w 372270652
      // 076: ldc_w 372246077
      // 079: ixor
      // 07a: invokestatic org/lwjgl/opengl/GL11.glPushAttrib (I)V
      // 07d: ldc_w 372248031
      // 080: ldc_w 372246077
      // 083: ixor
      // 084: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 087: ldc_w 372247516
      // 08a: ldc_w 372246077
      // 08d: ixor
      // 08e: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 091: ldc_w 372245823
      // 094: ldc_w 372246077
      // 097: ixor
      // 098: ldc_w 372245822
      // 09b: ldc_w 372246077
      // 09e: ixor
      // 09f: invokestatic org/lwjgl/opengl/GL11.glBlendFunc (II)V
      // 0a2: iload 6
      // 0a4: ldc_w 372246061
      // 0a7: ldc_w 372246077
      // 0aa: ixor
      // 0ab: ishr
      // 0ac: ldc_w 372246210
      // 0af: ldc_w 372246077
      // 0b2: ixor
      // 0b3: iand
      // 0b4: i2f
      // 0b5: ldc_w 255.0
      // 0b8: fdiv
      // 0b9: iload 6
      // 0bb: ldc_w 372246069
      // 0be: ldc_w 372246077
      // 0c1: ixor
      // 0c2: ishr
      // 0c3: ldc_w 372246210
      // 0c6: ldc_w 372246077
      // 0c9: ixor
      // 0ca: iand
      // 0cb: i2f
      // 0cc: ldc_w 255.0
      // 0cf: fdiv
      // 0d0: iload 6
      // 0d2: ldc_w 372246210
      // 0d5: ldc_w 372246077
      // 0d8: ixor
      // 0d9: iand
      // 0da: i2f
      // 0db: ldc_w 255.0
      // 0de: fdiv
      // 0df: iload 6
      // 0e1: ldc_w 372246053
      // 0e4: ldc_w 372246077
      // 0e7: ixor
      // 0e8: iushr
      // 0e9: i2f
      // 0ea: ldc_w 255.0
      // 0ed: fdiv
      // 0ee: invokestatic org/lwjgl/opengl/GL11.glColor4f (FFFF)V
      // 0f1: ldc_w 372246069
      // 0f4: ldc_w 372246077
      // 0f7: ixor
      // 0f8: invokestatic org/lwjgl/opengl/GL11.glBegin (I)V
      // 0fb: fconst_0
      // 0fc: fload 4
      // 0fe: fload 5
      // 100: fsub
      // 101: invokestatic java/lang/Math.max (FF)F
      // 104: fstore 8
      // 106: bipush 0
      // 107: istore 9
      // 109: iload 9
      // 10b: ldc_w 372246073
      // 10e: ldc_w 372246077
      // 111: ixor
      // 112: if_icmpgt 1ef
      // 115: iload 9
      // 117: ldc_w 372246073
      // 11a: ldc_w 372246077
      // 11d: ixor
      // 11e: irem
      // 11f: istore 10
      // 121: iload 7
      // 123: ifne 1f5
      // 126: fload 0
      // 127: iload 10
      // 129: iload 7
      // 12b: ifne 13b
      // 12e: goto 132
      // 131: athrow
      // 132: ifeq 145
      // 135: goto 139
      // 138: athrow
      // 139: iload 10
      // 13b: ldc_w 372246078
      // 13e: ldc_w 372246077
      // 141: ixor
      // 142: if_icmpne 14b
      // 145: fload 4
      // 147: goto 14f
      // 14a: athrow
      // 14b: fload 2
      // 14c: fload 4
      // 14e: fsub
      // 14f: fadd
      // 150: fstore 11
      // 152: fload 1
      // 153: iload 10
      // 155: ldc_w 372246079
      // 158: ldc_w 372246077
      // 15b: ixor
      // 15c: if_icmpge 165
      // 15f: fload 4
      // 161: goto 169
      // 164: athrow
      // 165: fload 3
      // 166: fload 4
      // 168: fsub
      // 169: fadd
      // 16a: fstore 12
      // 16c: bipush 0
      // 16d: istore 13
      // 16f: iload 13
      // 171: ldc_w 372246061
      // 174: ldc_w 372246077
      // 177: ixor
      // 178: if_icmpgt 1e7
      // 17b: ldc_w 372246153
      // 17e: ldc_w 372246077
      // 181: ixor
      // 182: iload 10
      // 184: ldc_w 372246119
      // 187: ldc_w 372246077
      // 18a: ixor
      // 18b: imul
      // 18c: iadd
      // 18d: i2f
      // 18e: iload 13
      // 190: i2f
      // 191: ldc_w 90.0
      // 194: fmul
      // 195: ldc_w 16.0
      // 198: fdiv
      // 199: fadd
      // 19a: f2d
      // 19b: invokestatic java/lang/Math.toRadians (D)D
      // 19e: dstore 14
      // 1a0: iload 7
      // 1a2: dload 14
      // 1a4: invokestatic java/lang/Math.cos (D)D
      // 1a7: d2f
      // 1a8: fstore 16
      // 1aa: dload 14
      // 1ac: invokestatic java/lang/Math.sin (D)D
      // 1af: d2f
      // 1b0: fstore 17
      // 1b2: ifne 1ea
      // 1b5: fload 11
      // 1b7: fload 16
      // 1b9: fload 4
      // 1bb: fmul
      // 1bc: fadd
      // 1bd: fload 12
      // 1bf: fload 17
      // 1c1: fload 4
      // 1c3: fmul
      // 1c4: fadd
      // 1c5: invokestatic org/lwjgl/opengl/GL11.glVertex2f (FF)V
      // 1c8: iload 7
      // 1ca: fload 11
      // 1cc: fload 16
      // 1ce: fload 8
      // 1d0: fmul
      // 1d1: fadd
      // 1d2: fload 12
      // 1d4: fload 17
      // 1d6: fload 8
      // 1d8: fmul
      // 1d9: fadd
      // 1da: invokestatic org/lwjgl/opengl/GL11.glVertex2f (FF)V
      // 1dd: iinc 13 1
      // 1e0: ifeq 16f
      // 1e3: goto 1e7
      // 1e6: athrow
      // 1e7: iinc 9 1
      // 1ea: iload 7
      // 1ec: ifeq 109
      // 1ef: invokestatic org/lwjgl/opengl/GL11.glEnd ()V
      // 1f2: invokestatic org/lwjgl/opengl/GL11.glPopAttrib ()V
      // 1f5: goto 200
      // 1f8: astore 18
      // 1fa: invokestatic org/lwjgl/opengl/GL11.glPopAttrib ()V
      // 1fd: aload 18
      // 1ff: athrow
      // 200: return
   }

   private static int ή(int param0, int param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: invokestatic x/oce6044968f8.Ŝ ()Lx/oc93499ec6de;
      // 06: astore 3
      // 07: istore 2
      // 08: aload 3
      // 09: getfield x/oc93499ec6de.Ԓ Lx/oca9cc61aada;
      // 0c: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0f: iload 2
      // 10: ifne 2e
      // 13: ldc2_w 2.0
      // 16: dcmpl
      // 17: ifne 27
      // 1a: goto 1e
      // 1d: athrow
      // 1e: aload 3
      // 1f: getfield x/oc93499ec6de.ǻ Lx/oc24a0a5bddf;
      // 22: invokevirtual x/oc24a0a5bddf.ͳ ()I
      // 25: ireturn
      // 26: athrow
      // 27: aload 3
      // 28: getfield x/oc93499ec6de.Ԓ Lx/oca9cc61aada;
      // 2b: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 2e: dconst_1
      // 2f: iload 2
      // 30: ifne 46
      // 33: dcmpl
      // 34: ifne 3e
      // 37: goto 3b
      // 3a: athrow
      // 3b: iload 1
      // 3c: ireturn
      // 3d: athrow
      // 3e: aload 3
      // 3f: getfield x/oc93499ec6de.ʤ Lx/oca9cc61aada;
      // 42: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 45: dconst_1
      // 46: dcmpl
      // 47: iload 2
      // 48: ifne 59
      // 4b: ifne 5c
      // 4e: goto 52
      // 51: athrow
      // 52: ldc_w -194892289
      // 55: ldc_w 190983679
      // 58: ixor
      // 59: goto 5d
      // 5c: iload 0
      // 5d: ireturn
   }

   private static long ш() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 0
      // 04: getstatic x/oce6044968f8.Ӎ J
      // 07: iload 0
      // 08: ifne 1b
      // 0b: lconst_0
      // 0c: lcmp
      // 0d: ifne 1e
      // 10: goto 14
      // 13: athrow
      // 14: invokestatic java/lang/System.currentTimeMillis ()J
      // 17: goto 1b
      // 1a: athrow
      // 1b: goto 21
      // 1e: getstatic x/oce6044968f8.Ӎ J
      // 21: lreturn
   }
}

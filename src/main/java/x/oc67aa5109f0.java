package x;

import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.gui.ScaledResolution;

public class oc67aa5109f0 implements ocda171fe5d8 {
   private final oc93499ec6de φ;
   private final Map<oc69da1aa7f5, occ996d0a351> ȩ = new IdentityHashMap<>();
   private long ư;
   private float z = Float.NaN;
   private float ҭ = Float.NaN;
   private boolean Ҿ = true;
   private boolean ģ;
   private boolean Ԑ;
   private float ն;
   private float Ŵ;

   oc67aa5109f0(oc93499ec6de var1) {
      this.φ = var1;
   }

   void ǫ(List<oc6ae023f1e7> param1, oc1378bc114d param2, boolean param3, boolean param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: new net/minecraft/client/gui/ScaledResolution
      // 006: dup
      // 007: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 00a: invokespecial net/minecraft/client/gui/ScaledResolution.<init> (Lnet/minecraft/client/Minecraft;)V
      // 00d: astore 6
      // 00f: istore 5
      // 011: aload 0
      // 012: aload 6
      // 014: invokevirtual x/oc67aa5109f0.ʫ (Lnet/minecraft/client/gui/ScaledResolution;)V
      // 017: invokestatic java/lang/System.nanoTime ()J
      // 01a: lstore 7
      // 01c: aload 0
      // 01d: getfield x/oc67aa5109f0.ư J
      // 020: lconst_0
      // 021: lcmp
      // 022: ifne 02a
      // 025: fconst_0
      // 026: goto 039
      // 029: athrow
      // 02a: fconst_0
      // 02b: lload 7
      // 02d: aload 0
      // 02e: getfield x/oc67aa5109f0.ư J
      // 031: lsub
      // 032: l2f
      // 033: ldc 1000000.0
      // 035: fdiv
      // 036: invokestatic java/lang/Math.max (FF)F
      // 039: fstore 9
      // 03b: fconst_1
      // 03c: fload 9
      // 03e: ldc 0.015
      // 040: fmul
      // 041: ldc 250.0
      // 043: fmul
      // 044: aload 0
      // 045: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 048: getfield x/oc93499ec6de.Ѫ Lx/oca9cc61aada;
      // 04b: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 04e: d2f
      // 04f: fdiv
      // 050: invokestatic java/lang/Math.min (FF)F
      // 053: fstore 10
      // 055: aload 0
      // 056: lload 7
      // 058: putfield x/oc67aa5109f0.ư J
      // 05b: new java/util/IdentityHashMap
      // 05e: dup
      // 05f: invokespecial java/util/IdentityHashMap.<init> ()V
      // 062: invokestatic java/util/Collections.newSetFromMap (Ljava/util/Map;)Ljava/util/Set;
      // 065: astore 11
      // 067: aload 1
      // 068: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 06d: astore 12
      // 06f: aload 12
      // 071: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 076: ifeq 0a0
      // 079: aload 12
      // 07b: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 080: checkcast x/oc6ae023f1e7
      // 083: astore 13
      // 085: iload 5
      // 087: aload 11
      // 089: aload 13
      // 08b: getfield x/oc6ae023f1e7.ϙ Lx/oc69da1aa7f5;
      // 08e: invokeinterface java/util/Set.add (Ljava/lang/Object;)Z 2
      // 093: pop
      // 094: ifne 0b1
      // 097: iload 5
      // 099: ifeq 06f
      // 09c: goto 0a0
      // 09f: athrow
      // 0a0: aload 0
      // 0a1: getfield x/oc67aa5109f0.ȩ Ljava/util/Map;
      // 0a4: invokeinterface java/util/Map.keySet ()Ljava/util/Set; 1
      // 0a9: aload 11
      // 0ab: invokeinterface java/util/Set.retainAll (Ljava/util/Collection;)Z 2
      // 0b0: pop
      // 0b1: invokestatic x/ocd2958dac48.Ѹ ()F
      // 0b4: fstore 12
      // 0b6: aload 0
      // 0b7: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 0ba: getfield x/oc93499ec6de.ɿ Lx/oca9cc61aada;
      // 0bd: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0c0: d2f
      // 0c1: fload 12
      // 0c3: fmul
      // 0c4: fstore 13
      // 0c6: aload 0
      // 0c7: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 0ca: getfield x/oc93499ec6de.я Lx/oca9cc61aada;
      // 0cd: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0d0: d2f
      // 0d1: fload 12
      // 0d3: fmul
      // 0d4: fstore 14
      // 0d6: aload 2
      // 0d7: fload 14
      // 0d9: invokestatic x/ocd2958dac48.o (Lx/oc1378bc114d;F)F
      // 0dc: fstore 15
      // 0de: fload 15
      // 0e0: aload 2
      // 0e1: invokeinterface x/oc1378bc114d.z$g5bxucc1j700 ()I 1
      // 0e6: i2f
      // 0e7: fsub
      // 0e8: aload 2
      // 0e9: invokeinterface x/oc1378bc114d.z$w1h9nvoglpkn ()I 1
      // 0ee: i2f
      // 0ef: fsub
      // 0f0: fconst_2
      // 0f1: fdiv
      // 0f2: fstore 16
      // 0f4: aload 0
      // 0f5: aload 1
      // 0f6: aload 6
      // 0f8: fload 13
      // 0fa: fload 15
      // 0fc: fload 12
      // 0fe: iload 3
      // 0ff: iload 4
      // 101: fload 10
      // 103: invokevirtual x/oc67aa5109f0.Ď (Ljava/util/List;Lnet/minecraft/client/gui/ScaledResolution;FFFZZF)Lx/ocd289dfdfcb;
      // 106: astore 17
      // 108: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 10b: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 10e: instanceof net/minecraft/client/gui/GuiChat
      // 111: iload 5
      // 113: ifne 134
      // 116: ifeq 16c
      // 119: goto 11d
      // 11c: athrow
      // 11d: aload 0
      // 11e: iload 5
      // 120: ifne 171
      // 123: goto 127
      // 126: athrow
      // 127: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 12a: getfield x/oc93499ec6de.Ҽ Lx/occ2f8dff8d8;
      // 12d: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 130: goto 134
      // 133: athrow
      // 134: ifne 16c
      // 137: aload 0
      // 138: aload 17
      // 13a: aload 6
      // 13c: aload 2
      // 13d: fload 13
      // 13f: fload 15
      // 141: invokevirtual x/oc67aa5109f0.ђ (Lx/ocd289dfdfcb;Lnet/minecraft/client/gui/ScaledResolution;Lx/oc1378bc114d;FF)Z
      // 144: iload 5
      // 146: ifne 188
      // 149: goto 14d
      // 14c: athrow
      // 14d: ifeq 175
      // 150: goto 154
      // 153: athrow
      // 154: aload 0
      // 155: aload 1
      // 156: aload 6
      // 158: fload 13
      // 15a: fload 15
      // 15c: fload 12
      // 15e: iload 3
      // 15f: iload 4
      // 161: fconst_0
      // 162: invokevirtual x/oc67aa5109f0.Ď (Ljava/util/List;Lnet/minecraft/client/gui/ScaledResolution;FFFZZF)Lx/ocd289dfdfcb;
      // 165: astore 17
      // 167: iload 5
      // 169: ifeq 175
      // 16c: aload 0
      // 16d: goto 171
      // 170: athrow
      // 171: bipush 0
      // 172: putfield x/oc67aa5109f0.Ԑ Z
      // 175: aload 17
      // 177: iload 5
      // 179: ifne 18e
      // 17c: getfield x/ocd289dfdfcb.ϗ Ljava/util/List;
      // 17f: invokeinterface java/util/List.isEmpty ()Z 1
      // 184: goto 188
      // 187: athrow
      // 188: ifeq 18c
      // 18b: return
      // 18c: aload 17
      // 18e: astore 18
      // 190: invokestatic java/lang/System.currentTimeMillis ()J
      // 193: lstore 19
      // 195: ldc 936776113
      // 197: ldc 936778432
      // 199: ixor
      // 19a: invokestatic org/lwjgl/opengl/GL11.glIsEnabled (I)Z
      // 19d: istore 21
      // 19f: ldc 936776114
      // 1a1: ldc 936778432
      // 1a3: ixor
      // 1a4: invokestatic org/lwjgl/opengl/GL11.glGetBoolean (I)Z
      // 1a7: istore 22
      // 1a9: invokestatic net/minecraft/client/renderer/GlStateManager.disableDepth ()V
      // 1ac: bipush 0
      // 1ad: invokestatic net/minecraft/client/renderer/GlStateManager.depthMask (Z)V
      // 1b0: aload 0
      // 1b1: iload 5
      // 1b3: ifne 1ec
      // 1b6: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 1b9: invokevirtual x/oc93499ec6de.Ă ()Z
      // 1bc: ifeq 1eb
      // 1bf: goto 1c3
      // 1c2: athrow
      // 1c3: aload 0
      // 1c4: aload 18
      // 1c6: lload 19
      // 1c8: invokedynamic run (Lx/oc67aa5109f0;Lx/ocd289dfdfcb;J)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, x/oc67aa5109f0.q311h1b5q50p49 (Lx/ocd289dfdfcb;J)V, ()V ]
      // 1cd: aload 0
      // 1ce: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 1d1: getfield x/oc93499ec6de.Ϸ Lx/oca9cc61aada;
      // 1d4: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 1d7: d2i
      // 1d8: aload 0
      // 1d9: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 1dc: getfield x/oc93499ec6de.Û Lx/oca9cc61aada;
      // 1df: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 1e2: d2f
      // 1e3: invokestatic x/oc1b46ea259e.ψ (Ljava/lang/Runnable;IF)Z
      // 1e6: pop
      // 1e7: goto 1eb
      // 1ea: athrow
      // 1eb: aload 0
      // 1ec: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 1ef: iload 5
      // 1f1: ifne 238
      // 1f4: invokevirtual x/oc93499ec6de.ʍ ()Z
      // 1f7: ifeq 22b
      // 1fa: goto 1fe
      // 1fd: athrow
      // 1fe: aload 0
      // 1ff: aload 18
      // 201: aload 1
      // 202: aload 2
      // 203: fload 16
      // 205: iload 3
      // 206: lload 19
      // 208: invokedynamic run (Lx/oc67aa5109f0;Lx/ocd289dfdfcb;Ljava/util/List;Lx/oc1378bc114d;FZJ)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, x/oc67aa5109f0.q2cuh6b6v19ya8 (Lx/ocd289dfdfcb;Ljava/util/List;Lx/oc1378bc114d;FZJ)V, ()V ]
      // 20d: aload 0
      // 20e: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 211: getfield x/oc93499ec6de.ԗ Lx/oca9cc61aada;
      // 214: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 217: d2i
      // 218: aload 0
      // 219: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 21c: getfield x/oc93499ec6de.Ϭ Lx/oca9cc61aada;
      // 21f: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 222: d2f
      // 223: invokestatic x/oc1b46ea259e.І (Ljava/lang/Runnable;IF)Z
      // 226: pop
      // 227: goto 22b
      // 22a: athrow
      // 22b: aload 0
      // 22c: iload 5
      // 22e: ifne 25b
      // 231: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 234: goto 238
      // 237: athrow
      // 238: getfield x/oc93499ec6de.ƺ Lx/oca9cc61aada;
      // 23b: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 23e: dconst_0
      // 23f: dcmpl
      // 240: ifeq 251
      // 243: aload 0
      // 244: aload 18
      // 246: lload 19
      // 248: bipush -1
      // 249: bipush 0
      // 24a: invokevirtual x/oc67aa5109f0.ս (Lx/ocd289dfdfcb;JIZ)V
      // 24d: goto 251
      // 250: athrow
      // 251: aload 0
      // 252: aload 18
      // 254: lload 19
      // 256: bipush -1
      // 257: invokevirtual x/oc67aa5109f0.j (Lx/ocd289dfdfcb;JI)V
      // 25a: aload 0
      // 25b: aload 18
      // 25d: aload 1
      // 25e: aload 2
      // 25f: fload 16
      // 261: iload 3
      // 262: lload 19
      // 264: bipush -1
      // 265: invokevirtual x/oc67aa5109f0.Ď (Lx/ocd289dfdfcb;Ljava/util/List;Lx/oc1378bc114d;FZJI)V
      // 268: iload 5
      // 26a: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 26d: invokevirtual net/minecraft/client/Minecraft.getFramebuffer ()Lnet/minecraft/client/shader/Framebuffer;
      // 270: bipush 1
      // 271: invokevirtual net/minecraft/client/shader/Framebuffer.bindFramebuffer (Z)V
      // 274: invokestatic net/minecraft/client/renderer/GlStateManager.enableTexture2D ()V
      // 277: ifne 28b
      // 27a: iload 22
      // 27c: invokestatic net/minecraft/client/renderer/GlStateManager.depthMask (Z)V
      // 27f: iload 21
      // 281: ifeq 290
      // 284: invokestatic net/minecraft/client/renderer/GlStateManager.enableDepth ()V
      // 287: goto 28b
      // 28a: athrow
      // 28b: iload 5
      // 28d: ifeq 297
      // 290: invokestatic net/minecraft/client/renderer/GlStateManager.disableDepth ()V
      // 293: goto 297
      // 296: athrow
      // 297: ldc_w 10.0
      // 29a: invokestatic x/ocbd4917c4b1.В (F)V
      // 29d: invokestatic x/ocbd4917c4b1.Ԃ ()V
      // 2a0: goto 2e0
      // 2a3: astore 23
      // 2a5: iload 5
      // 2a7: ifne 2c8
      // 2aa: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 2ad: invokevirtual net/minecraft/client/Minecraft.getFramebuffer ()Lnet/minecraft/client/shader/Framebuffer;
      // 2b0: bipush 1
      // 2b1: invokevirtual net/minecraft/client/shader/Framebuffer.bindFramebuffer (Z)V
      // 2b4: invokestatic net/minecraft/client/renderer/GlStateManager.enableTexture2D ()V
      // 2b7: iload 22
      // 2b9: invokestatic net/minecraft/client/renderer/GlStateManager.depthMask (Z)V
      // 2bc: iload 21
      // 2be: ifeq 2cd
      // 2c1: invokestatic net/minecraft/client/renderer/GlStateManager.enableDepth ()V
      // 2c4: goto 2c8
      // 2c7: athrow
      // 2c8: iload 5
      // 2ca: ifeq 2d4
      // 2cd: invokestatic net/minecraft/client/renderer/GlStateManager.disableDepth ()V
      // 2d0: goto 2d4
      // 2d3: athrow
      // 2d4: ldc_w 10.0
      // 2d7: invokestatic x/ocbd4917c4b1.В (F)V
      // 2da: invokestatic x/ocbd4917c4b1.Ԃ ()V
      // 2dd: aload 23
      // 2df: athrow
      // 2e0: return
   }

   float Ҥ() {
      this.ʫ(new ScaledResolution(ocda171fe5d8.ǔ));
      return this.z;
   }

   float ԉ() {
      this.ʫ(new ScaledResolution(ocda171fe5d8.ǔ));
      return this.ҭ;
   }

   void ǟ(float param1, float param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 3
      // 04: fload 1
      // 05: iload 3
      // 06: ifne 18
      // 09: invokestatic java/lang/Float.isFinite (F)Z
      // 0c: ifeq 80
      // 0f: goto 13
      // 12: athrow
      // 13: fload 2
      // 14: goto 18
      // 17: athrow
      // 18: invokestatic java/lang/Float.isFinite (F)Z
      // 1b: ifeq 80
      // 1e: aload 0
      // 1f: fconst_0
      // 20: fconst_1
      // 21: fload 1
      // 22: invokestatic java/lang/Math.min (FF)F
      // 25: invokestatic java/lang/Math.max (FF)F
      // 28: putfield x/oc67aa5109f0.z F
      // 2b: aload 0
      // 2c: fconst_0
      // 2d: fconst_1
      // 2e: fload 2
      // 2f: invokestatic java/lang/Math.min (FF)F
      // 32: invokestatic java/lang/Math.max (FF)F
      // 35: putfield x/oc67aa5109f0.ҭ F
      // 38: aload 0
      // 39: aload 0
      // 3a: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 3d: getfield x/oc93499ec6de.ě Lx/oca9cc61aada;
      // 40: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 43: dconst_0
      // 44: dcmpl
      // 45: iload 3
      // 46: ifne 55
      // 49: goto 4d
      // 4c: athrow
      // 4d: ifne 58
      // 50: goto 54
      // 53: athrow
      // 54: bipush 1
      // 55: goto 59
      // 58: bipush 0
      // 59: putfield x/oc67aa5109f0.Ҿ Z
      // 5c: aload 0
      // 5d: aload 0
      // 5e: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 61: getfield x/oc93499ec6de.ʂ Lx/oca9cc61aada;
      // 64: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 67: dconst_1
      // 68: dcmpl
      // 69: iload 3
      // 6a: ifne 75
      // 6d: ifne 78
      // 70: goto 74
      // 73: athrow
      // 74: bipush 1
      // 75: goto 79
      // 78: bipush 0
      // 79: putfield x/oc67aa5109f0.ģ Z
      // 7c: aload 0
      // 7d: invokevirtual x/oc67aa5109f0.Ȭ ()V
      // 80: return
   }

   void Ȭ() {
      this.ȩ.clear();
      this.ư = 0L;
   }

   private void ʫ(ScaledResolution param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: istore 2
      // 004: aload 0
      // 005: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 008: getfield x/oc93499ec6de.ě Lx/oca9cc61aada;
      // 00b: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 00e: dconst_0
      // 00f: dcmpl
      // 010: iload 2
      // 011: ifne 01c
      // 014: ifne 01f
      // 017: goto 01b
      // 01a: athrow
      // 01b: bipush 1
      // 01c: goto 020
      // 01f: bipush 0
      // 020: istore 3
      // 021: aload 0
      // 022: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 025: getfield x/oc93499ec6de.ʂ Lx/oca9cc61aada;
      // 028: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 02b: dconst_1
      // 02c: dcmpl
      // 02d: iload 2
      // 02e: ifne 039
      // 031: ifne 03c
      // 034: goto 038
      // 037: athrow
      // 038: bipush 1
      // 039: goto 03d
      // 03c: bipush 0
      // 03d: istore 4
      // 03f: aload 0
      // 040: iload 2
      // 041: ifne 06c
      // 044: getfield x/oc67aa5109f0.z F
      // 047: invokestatic java/lang/Float.isFinite (F)Z
      // 04a: ifeq 067
      // 04d: goto 051
      // 050: athrow
      // 051: aload 0
      // 052: iload 2
      // 053: ifne 0c5
      // 056: goto 05a
      // 059: athrow
      // 05a: getfield x/oc67aa5109f0.ҭ F
      // 05d: invokestatic java/lang/Float.isFinite (F)Z
      // 060: ifne 0c0
      // 063: goto 067
      // 066: athrow
      // 067: aload 0
      // 068: goto 06c
      // 06b: athrow
      // 06c: iload 3
      // 06d: ifeq 083
      // 070: fconst_1
      // 071: ldc_w 10.0
      // 074: bipush 1
      // 075: aload 1
      // 076: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledWidth ()I
      // 079: invokestatic java/lang/Math.max (II)I
      // 07c: i2f
      // 07d: fdiv
      // 07e: fsub
      // 07f: goto 090
      // 082: athrow
      // 083: ldc_w 10.0
      // 086: bipush 1
      // 087: aload 1
      // 088: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledWidth ()I
      // 08b: invokestatic java/lang/Math.max (II)I
      // 08e: i2f
      // 08f: fdiv
      // 090: putfield x/oc67aa5109f0.z F
      // 093: aload 0
      // 094: iload 4
      // 096: ifeq 0ac
      // 099: fconst_1
      // 09a: ldc_w 10.0
      // 09d: bipush 1
      // 09e: aload 1
      // 09f: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledHeight ()I
      // 0a2: invokestatic java/lang/Math.max (II)I
      // 0a5: i2f
      // 0a6: fdiv
      // 0a7: fsub
      // 0a8: goto 0b9
      // 0ab: athrow
      // 0ac: ldc_w 10.0
      // 0af: bipush 1
      // 0b0: aload 1
      // 0b1: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledHeight ()I
      // 0b4: invokestatic java/lang/Math.max (II)I
      // 0b7: i2f
      // 0b8: fdiv
      // 0b9: putfield x/oc67aa5109f0.ҭ F
      // 0bc: iload 2
      // 0bd: ifeq 12e
      // 0c0: aload 0
      // 0c1: goto 0c5
      // 0c4: athrow
      // 0c5: getfield x/oc67aa5109f0.Ҿ Z
      // 0c8: iload 2
      // 0c9: ifne 0ee
      // 0cc: iload 3
      // 0cd: if_icmpeq 0e2
      // 0d0: goto 0d4
      // 0d3: athrow
      // 0d4: aload 0
      // 0d5: fconst_1
      // 0d6: aload 0
      // 0d7: getfield x/oc67aa5109f0.z F
      // 0da: fsub
      // 0db: putfield x/oc67aa5109f0.z F
      // 0de: goto 0e2
      // 0e1: athrow
      // 0e2: aload 0
      // 0e3: iload 2
      // 0e4: ifne 102
      // 0e7: getfield x/oc67aa5109f0.ģ Z
      // 0ea: goto 0ee
      // 0ed: athrow
      // 0ee: iload 4
      // 0f0: if_icmpeq 101
      // 0f3: aload 0
      // 0f4: fconst_1
      // 0f5: aload 0
      // 0f6: getfield x/oc67aa5109f0.ҭ F
      // 0f9: fsub
      // 0fa: putfield x/oc67aa5109f0.ҭ F
      // 0fd: goto 101
      // 100: athrow
      // 101: aload 0
      // 102: iload 2
      // 103: ifne 12b
      // 106: getfield x/oc67aa5109f0.Ҿ Z
      // 109: iload 3
      // 10a: if_icmpne 126
      // 10d: goto 111
      // 110: athrow
      // 111: aload 0
      // 112: iload 2
      // 113: ifne 134
      // 116: goto 11a
      // 119: athrow
      // 11a: getfield x/oc67aa5109f0.ģ Z
      // 11d: iload 4
      // 11f: if_icmpeq 12e
      // 122: goto 126
      // 125: athrow
      // 126: aload 0
      // 127: goto 12b
      // 12a: athrow
      // 12b: invokevirtual x/oc67aa5109f0.Ȭ ()V
      // 12e: aload 0
      // 12f: iload 3
      // 130: putfield x/oc67aa5109f0.Ҿ Z
      // 133: aload 0
      // 134: iload 4
      // 136: putfield x/oc67aa5109f0.ģ Z
      // 139: return
   }

   private ocd289dfdfcb Ď(
      List<oc6ae023f1e7> param1, ScaledResolution param2, float param3, float param4, float param5, boolean param6, boolean param7, float param8
   ) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: aload 1
      // 004: invokeinterface java/util/List.size ()I 1
      // 009: newarray 6
      // 00b: astore 10
      // 00d: istore 9
      // 00f: aload 1
      // 010: invokeinterface java/util/List.size ()I 1
      // 015: newarray 6
      // 017: astore 11
      // 019: aload 1
      // 01a: invokeinterface java/util/List.size ()I 1
      // 01f: newarray 4
      // 021: astore 12
      // 023: fconst_0
      // 024: fstore 13
      // 026: fconst_0
      // 027: fstore 14
      // 029: fconst_0
      // 02a: fstore 15
      // 02c: aload 0
      // 02d: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 030: getfield x/oc93499ec6de.қ Lx/oca9cc61aada;
      // 033: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 036: d2f
      // 037: fload 5
      // 039: fmul
      // 03a: fstore 16
      // 03c: bipush 0
      // 03d: istore 17
      // 03f: iload 17
      // 041: aload 1
      // 042: invokeinterface java/util/List.size ()I 1
      // 047: if_icmpge 0f0
      // 04a: aload 10
      // 04c: iload 17
      // 04e: aload 1
      // 04f: iload 17
      // 051: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 056: checkcast x/oc6ae023f1e7
      // 059: getfield x/oc6ae023f1e7.њ F
      // 05c: fastore
      // 05d: iload 9
      // 05f: ifne 118
      // 062: aload 11
      // 064: iload 17
      // 066: aload 1
      // 067: iload 17
      // 069: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 06e: checkcast x/oc6ae023f1e7
      // 071: getfield x/oc6ae023f1e7.Ӵ F
      // 074: fastore
      // 075: aload 12
      // 077: iload 17
      // 079: aload 1
      // 07a: iload 17
      // 07c: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 081: checkcast x/oc6ae023f1e7
      // 084: getfield x/oc6ae023f1e7.ϙ Lx/oc69da1aa7f5;
      // 087: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 08a: bastore
      // 08b: fconst_0
      // 08c: fconst_1
      // 08d: aload 11
      // 08f: iload 17
      // 091: faload
      // 092: invokestatic java/lang/Math.min (FF)F
      // 095: invokestatic java/lang/Math.max (FF)F
      // 098: fstore 18
      // 09a: fload 18
      // 09c: fconst_0
      // 09d: fcmpl
      // 09e: iload 9
      // 0a0: ifne 0bb
      // 0a3: ifle 0b6
      // 0a6: goto 0aa
      // 0a9: athrow
      // 0aa: fload 13
      // 0ac: aload 10
      // 0ae: iload 17
      // 0b0: faload
      // 0b1: invokestatic java/lang/Math.max (FF)F
      // 0b4: fstore 13
      // 0b6: aload 12
      // 0b8: iload 17
      // 0ba: baload
      // 0bb: iload 9
      // 0bd: ifne 0d8
      // 0c0: ifeq 0e8
      // 0c3: goto 0c7
      // 0c6: athrow
      // 0c7: fload 18
      // 0c9: iload 9
      // 0cb: ifne 0e6
      // 0ce: goto 0d2
      // 0d1: athrow
      // 0d2: fconst_0
      // 0d3: fcmpl
      // 0d4: goto 0d8
      // 0d7: athrow
      // 0d8: ifle 0e8
      // 0db: fload 14
      // 0dd: fload 4
      // 0df: fload 16
      // 0e1: fadd
      // 0e2: fadd
      // 0e3: fstore 14
      // 0e5: fconst_1
      // 0e6: fstore 15
      // 0e8: iinc 17 1
      // 0eb: iload 9
      // 0ed: ifeq 03f
      // 0f0: fload 14
      // 0f2: fload 16
      // 0f4: fload 15
      // 0f6: fmul
      // 0f7: fsub
      // 0f8: fstore 14
      // 0fa: fload 13
      // 0fc: aload 0
      // 0fd: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 100: getfield x/oc93499ec6de.ƌ Lx/oca9cc61aada;
      // 103: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 106: d2f
      // 107: fload 5
      // 109: fmul
      // 10a: fload 3
      // 10b: fconst_2
      // 10c: fmul
      // 10d: fsub
      // 10e: iload 9
      // 110: ifne 139
      // 113: invokestatic java/lang/Math.max (FF)F
      // 116: fstore 13
      // 118: aload 0
      // 119: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 11c: getfield x/oc93499ec6de.ӱ Lx/oca9cc61aada;
      // 11f: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 122: dconst_0
      // 123: dcmpl
      // 124: ifne 12c
      // 127: fconst_0
      // 128: goto 13a
      // 12b: athrow
      // 12c: aload 0
      // 12d: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 130: getfield x/oc93499ec6de.ѝ Lx/oca9cc61aada;
      // 133: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 136: d2f
      // 137: fload 5
      // 139: fmul
      // 13a: fstore 17
      // 13c: fload 3
      // 13d: fload 17
      // 13f: iload 9
      // 141: ifne 156
      // 144: fadd
      // 145: aload 0
      // 146: getfield x/oc67aa5109f0.Ҿ Z
      // 149: ifeq 159
      // 14c: goto 150
      // 14f: athrow
      // 150: fload 13
      // 152: goto 156
      // 155: athrow
      // 156: goto 15a
      // 159: fconst_0
      // 15a: fadd
      // 15b: fstore 18
      // 15d: aload 2
      // 15e: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledWidth ()I
      // 161: i2f
      // 162: fload 3
      // 163: iload 9
      // 165: ifne 17c
      // 168: fsub
      // 169: fload 17
      // 16b: fsub
      // 16c: aload 0
      // 16d: getfield x/oc67aa5109f0.Ҿ Z
      // 170: ifeq 17f
      // 173: goto 177
      // 176: athrow
      // 177: fconst_0
      // 178: goto 17c
      // 17b: athrow
      // 17c: goto 181
      // 17f: fload 13
      // 181: fsub
      // 182: fstore 19
      // 184: aload 0
      // 185: getfield x/oc67aa5109f0.z F
      // 188: aload 2
      // 189: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledWidth ()I
      // 18c: i2f
      // 18d: fmul
      // 18e: fstore 20
      // 190: fload 18
      // 192: fload 19
      // 194: fcmpg
      // 195: iload 9
      // 197: ifne 1b5
      // 19a: ifgt 1b1
      // 19d: goto 1a1
      // 1a0: athrow
      // 1a1: fload 18
      // 1a3: fload 19
      // 1a5: fload 20
      // 1a7: invokestatic java/lang/Math.min (FF)F
      // 1aa: invokestatic java/lang/Math.max (FF)F
      // 1ad: goto 1c2
      // 1b0: athrow
      // 1b1: aload 0
      // 1b2: getfield x/oc67aa5109f0.Ҿ Z
      // 1b5: ifeq 1be
      // 1b8: fload 19
      // 1ba: goto 1c2
      // 1bd: athrow
      // 1be: fload 3
      // 1bf: fload 17
      // 1c1: fadd
      // 1c2: fstore 20
      // 1c4: aload 0
      // 1c5: fload 20
      // 1c7: bipush 1
      // 1c8: aload 2
      // 1c9: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledWidth ()I
      // 1cc: invokestatic java/lang/Math.max (II)I
      // 1cf: i2f
      // 1d0: fdiv
      // 1d1: putfield x/oc67aa5109f0.z F
      // 1d4: fload 17
      // 1d6: aload 0
      // 1d7: getfield x/oc67aa5109f0.ģ Z
      // 1da: ifeq 1e3
      // 1dd: fload 14
      // 1df: goto 1e4
      // 1e2: athrow
      // 1e3: fconst_0
      // 1e4: fadd
      // 1e5: fstore 21
      // 1e7: aload 2
      // 1e8: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledHeight ()I
      // 1eb: i2f
      // 1ec: fload 17
      // 1ee: iload 9
      // 1f0: ifne 204
      // 1f3: fsub
      // 1f4: aload 0
      // 1f5: getfield x/oc67aa5109f0.ģ Z
      // 1f8: ifeq 207
      // 1fb: goto 1ff
      // 1fe: athrow
      // 1ff: fconst_0
      // 200: goto 204
      // 203: athrow
      // 204: goto 209
      // 207: fload 14
      // 209: fsub
      // 20a: fstore 22
      // 20c: aload 0
      // 20d: getfield x/oc67aa5109f0.ҭ F
      // 210: aload 2
      // 211: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledHeight ()I
      // 214: i2f
      // 215: fmul
      // 216: fstore 23
      // 218: fload 21
      // 21a: fload 22
      // 21c: fcmpg
      // 21d: iload 9
      // 21f: ifne 23d
      // 222: ifgt 239
      // 225: goto 229
      // 228: athrow
      // 229: fload 21
      // 22b: fload 22
      // 22d: fload 23
      // 22f: invokestatic java/lang/Math.min (FF)F
      // 232: invokestatic java/lang/Math.max (FF)F
      // 235: goto 25a
      // 238: athrow
      // 239: aload 0
      // 23a: getfield x/oc67aa5109f0.ģ Z
      // 23d: iload 9
      // 23f: ifne 251
      // 242: ifeq 258
      // 245: goto 249
      // 248: athrow
      // 249: aload 2
      // 24a: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledHeight ()I
      // 24d: goto 251
      // 250: athrow
      // 251: i2f
      // 252: fload 17
      // 254: fsub
      // 255: goto 25a
      // 258: fload 17
      // 25a: fstore 23
      // 25c: aload 0
      // 25d: fload 23
      // 25f: bipush 1
      // 260: aload 2
      // 261: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledHeight ()I
      // 264: invokestatic java/lang/Math.max (II)I
      // 267: i2f
      // 268: fdiv
      // 269: putfield x/oc67aa5109f0.ҭ F
      // 26c: fload 20
      // 26e: fstore 24
      // 270: fload 23
      // 272: fstore 25
      // 274: new x/ocd289dfdfcb
      // 277: dup
      // 278: aload 10
      // 27a: aload 11
      // 27c: fload 20
      // 27e: fload 23
      // 280: aload 0
      // 281: getfield x/oc67aa5109f0.Ҿ Z
      // 284: fload 3
      // 285: fload 4
      // 287: fload 16
      // 289: fload 17
      // 28b: aload 0
      // 28c: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 28f: getfield x/oc93499ec6de.ӱ Lx/oca9cc61aada;
      // 292: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 295: d2i
      // 296: aload 0
      // 297: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 29a: getfield x/oc93499ec6de.Ƌ Lx/oca9cc61aada;
      // 29d: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 2a0: d2i
      // 2a1: iload 6
      // 2a3: iload 7
      // 2a5: aload 2
      // 2a6: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledWidth ()I
      // 2a9: aload 0
      // 2aa: getfield x/oc67aa5109f0.ģ Z
      // 2ad: aload 0
      // 2ae: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 2b1: getfield x/oc93499ec6de.ɯ Lx/oca9cc61aada;
      // 2b4: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 2b7: dconst_1
      // 2b8: dcmpl
      // 2b9: ifne 2c1
      // 2bc: bipush 1
      // 2bd: goto 2c2
      // 2c0: athrow
      // 2c1: bipush 0
      // 2c2: aload 0
      // 2c3: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 2c6: getfield x/oc93499ec6de.ƌ Lx/oca9cc61aada;
      // 2c9: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 2cc: d2f
      // 2cd: fload 5
      // 2cf: fmul
      // 2d0: aload 0
      // 2d1: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 2d4: getfield x/oc93499ec6de.Ν Lx/oca9cc61aada;
      // 2d7: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 2da: d2i
      // 2db: aload 12
      // 2dd: aload 0
      // 2de: aload 1
      // 2df: fload 24
      // 2e1: fload 25
      // 2e3: iload 6
      // 2e5: iload 7
      // 2e7: fload 8
      // 2e9: invokedynamic apply (Lx/oc67aa5109f0;Ljava/util/List;FFZZF)Ljava/util/function/UnaryOperator; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Ljava/lang/Object;, x/oc67aa5109f0.qvnm74iwdcsym (Ljava/util/List;FFZZFLx/oc3094f205ad;)Lx/oc3094f205ad;, (Lx/oc3094f205ad;)Lx/oc3094f205ad; ]
      // 2ee: invokespecial x/ocd289dfdfcb.<init> ([F[FFFZFFFFIIZZIZZFI[ZLjava/util/function/UnaryOperator;)V
      // 2f1: areturn
   }

   private oc3094f205ad Ʃ(oc3094f205ad var1, oc69da1aa7f5 var2, float var3, float var4, boolean var5, float var6) {
      float var7 = var1.J - var3;
      float var8 = var1.Ň - var4;
      occ996d0a351 var9 = this.ȩ.computeIfAbsent(var2, var2x -> new occ996d0a351(var7, var8));

      occ996d0a351 var10000;
      float var10001;
      label29: {
         try {
            var10000 = var9;
            if (var5) {
               var10001 = ћ(var9.Ԅ, var7, var6);
               break label29;
            }
         } catch (ocbde1165e4e var11) {
            throw var11;
         }

         var10001 = var7;
      }

      label22: {
         try {
            var10000.Ԅ = var10001;
            var10000 = var9;
            if (var5) {
               var10001 = ћ(var9.ϑ, var8, var6);
               break label22;
            }
         } catch (ocbde1165e4e var10) {
            throw var10;
         }

         var10001 = var8;
      }

      var10000.ϑ = var10001;
      return var1.ó(var9.Ԅ - var7, var9.ϑ - var8);
   }

   private static float ћ(float param0, float param1, float param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 3
      // 04: fload 0
      // 05: iload 3
      // 06: ifne 1f
      // 09: fload 1
      // 0a: fsub
      // 0b: invokestatic java/lang/Math.abs (F)F
      // 0e: ldc_w 0.5
      // 11: fcmpg
      // 12: ifgt 1e
      // 15: goto 19
      // 18: athrow
      // 19: fload 1
      // 1a: goto 25
      // 1d: athrow
      // 1e: fload 0
      // 1f: fload 1
      // 20: fload 0
      // 21: fsub
      // 22: fload 2
      // 23: fmul
      // 24: fadd
      // 25: freturn
   }

   private boolean ђ(ocd289dfdfcb param1, ScaledResolution param2, oc1378bc114d param3, float param4, float param5) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: invokestatic org/lwjgl/input/Mouse.getX ()I
      // 006: aload 2
      // 007: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledWidth ()I
      // 00a: imul
      // 00b: i2f
      // 00c: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 00f: getfield net/minecraft/client/Minecraft.displayWidth I
      // 012: i2f
      // 013: fdiv
      // 014: fstore 7
      // 016: aload 2
      // 017: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledHeight ()I
      // 01a: i2f
      // 01b: invokestatic org/lwjgl/input/Mouse.getY ()I
      // 01e: aload 2
      // 01f: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledHeight ()I
      // 022: imul
      // 023: i2f
      // 024: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 027: getfield net/minecraft/client/Minecraft.displayHeight I
      // 02a: i2f
      // 02b: fdiv
      // 02c: fsub
      // 02d: fconst_1
      // 02e: fsub
      // 02f: fstore 8
      // 031: aload 0
      // 032: getfield x/oc67aa5109f0.z F
      // 035: aload 2
      // 036: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledWidth ()I
      // 039: i2f
      // 03a: fmul
      // 03b: fstore 9
      // 03d: aload 0
      // 03e: getfield x/oc67aa5109f0.ҭ F
      // 041: aload 2
      // 042: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledHeight ()I
      // 045: i2f
      // 046: fmul
      // 047: fstore 10
      // 049: aload 1
      // 04a: getfield x/ocd289dfdfcb.ʩ F
      // 04d: fstore 11
      // 04f: istore 6
      // 051: aload 1
      // 052: getfield x/ocd289dfdfcb.л F
      // 055: fstore 12
      // 057: aload 1
      // 058: getfield x/ocd289dfdfcb.Ҳ F
      // 05b: fstore 13
      // 05d: aload 1
      // 05e: getfield x/ocd289dfdfcb.ȡ F
      // 061: fstore 14
      // 063: aload 1
      // 064: getfield x/ocd289dfdfcb.ϗ Ljava/util/List;
      // 067: invokeinterface java/util/List.isEmpty ()Z 1
      // 06c: iload 6
      // 06e: ifne 0df
      // 071: ifeq 0d2
      // 074: goto 078
      // 077: athrow
      // 078: aload 3
      // 079: ldc_w "ArrayList"
      // 07c: invokeinterface x/oc1378bc114d.z$toz8pt08w0nc (Ljava/lang/String;)I 2
      // 081: i2f
      // 082: fload 4
      // 084: fconst_2
      // 085: fmul
      // 086: fadd
      // 087: fstore 15
      // 089: aload 0
      // 08a: getfield x/oc67aa5109f0.Ҿ Z
      // 08d: ifeq 099
      // 090: fload 9
      // 092: fload 15
      // 094: fsub
      // 095: goto 09e
      // 098: athrow
      // 099: fload 9
      // 09b: fload 4
      // 09d: fsub
      // 09e: fstore 11
      // 0a0: aload 0
      // 0a1: getfield x/oc67aa5109f0.Ҿ Z
      // 0a4: ifeq 0b0
      // 0a7: fload 9
      // 0a9: fload 4
      // 0ab: fadd
      // 0ac: goto 0b5
      // 0af: athrow
      // 0b0: fload 9
      // 0b2: fload 15
      // 0b4: fadd
      // 0b5: fstore 12
      // 0b7: aload 0
      // 0b8: getfield x/oc67aa5109f0.ģ Z
      // 0bb: ifeq 0c7
      // 0be: fload 10
      // 0c0: fload 5
      // 0c2: fsub
      // 0c3: goto 0c9
      // 0c6: athrow
      // 0c7: fload 10
      // 0c9: fstore 14
      // 0cb: fload 14
      // 0cd: fload 5
      // 0cf: fadd
      // 0d0: fstore 13
      // 0d2: bipush 0
      // 0d3: iload 6
      // 0d5: ifne 0f7
      // 0d8: invokestatic org/lwjgl/input/Mouse.isButtonDown (I)Z
      // 0db: goto 0df
      // 0de: athrow
      // 0df: ifne 0ea
      // 0e2: aload 0
      // 0e3: bipush 0
      // 0e4: putfield x/oc67aa5109f0.Ԑ Z
      // 0e7: bipush 0
      // 0e8: ireturn
      // 0e9: athrow
      // 0ea: aload 0
      // 0eb: iload 6
      // 0ed: ifne 16a
      // 0f0: getfield x/oc67aa5109f0.Ԑ Z
      // 0f3: goto 0f7
      // 0f6: athrow
      // 0f7: ifne 169
      // 0fa: fload 7
      // 0fc: fload 11
      // 0fe: fcmpl
      // 0ff: iload 6
      // 101: ifne 16d
      // 104: goto 108
      // 107: athrow
      // 108: iflt 169
      // 10b: goto 10f
      // 10e: athrow
      // 10f: fload 7
      // 111: fload 12
      // 113: fcmpg
      // 114: iload 6
      // 116: ifne 16d
      // 119: goto 11d
      // 11c: athrow
      // 11d: ifgt 169
      // 120: goto 124
      // 123: athrow
      // 124: fload 8
      // 126: fload 14
      // 128: fcmpl
      // 129: iload 6
      // 12b: ifne 16d
      // 12e: goto 132
      // 131: athrow
      // 132: iflt 169
      // 135: goto 139
      // 138: athrow
      // 139: fload 8
      // 13b: fload 13
      // 13d: fcmpg
      // 13e: iload 6
      // 140: ifne 16d
      // 143: goto 147
      // 146: athrow
      // 147: ifgt 169
      // 14a: goto 14e
      // 14d: athrow
      // 14e: aload 0
      // 14f: bipush 1
      // 150: putfield x/oc67aa5109f0.Ԑ Z
      // 153: aload 0
      // 154: fload 7
      // 156: fload 9
      // 158: fsub
      // 159: putfield x/oc67aa5109f0.ն F
      // 15c: aload 0
      // 15d: fload 8
      // 15f: fload 10
      // 161: fsub
      // 162: putfield x/oc67aa5109f0.Ŵ F
      // 165: goto 169
      // 168: athrow
      // 169: aload 0
      // 16a: getfield x/oc67aa5109f0.Ԑ Z
      // 16d: iload 6
      // 16f: ifne 17a
      // 172: ifne 17b
      // 175: goto 179
      // 178: athrow
      // 179: bipush 0
      // 17a: ireturn
      // 17b: fload 4
      // 17d: fload 9
      // 17f: fload 11
      // 181: fsub
      // 182: invokestatic java/lang/Math.max (FF)F
      // 185: fstore 15
      // 187: aload 2
      // 188: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledWidth ()I
      // 18b: i2f
      // 18c: fload 4
      // 18e: fload 12
      // 190: fload 9
      // 192: fsub
      // 193: invokestatic java/lang/Math.max (FF)F
      // 196: fsub
      // 197: fstore 16
      // 199: fload 15
      // 19b: fload 16
      // 19d: invokestatic java/lang/Math.min (FF)F
      // 1a0: fload 16
      // 1a2: fload 7
      // 1a4: aload 0
      // 1a5: getfield x/oc67aa5109f0.ն F
      // 1a8: fsub
      // 1a9: invokestatic java/lang/Math.min (FF)F
      // 1ac: invokestatic java/lang/Math.max (FF)F
      // 1af: fstore 17
      // 1b1: fconst_0
      // 1b2: fload 10
      // 1b4: fload 14
      // 1b6: fsub
      // 1b7: invokestatic java/lang/Math.max (FF)F
      // 1ba: fstore 18
      // 1bc: aload 2
      // 1bd: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledHeight ()I
      // 1c0: i2f
      // 1c1: fconst_0
      // 1c2: fload 13
      // 1c4: fload 10
      // 1c6: fsub
      // 1c7: invokestatic java/lang/Math.max (FF)F
      // 1ca: fsub
      // 1cb: fstore 19
      // 1cd: fload 18
      // 1cf: fload 19
      // 1d1: invokestatic java/lang/Math.min (FF)F
      // 1d4: fload 19
      // 1d6: fload 8
      // 1d8: aload 0
      // 1d9: getfield x/oc67aa5109f0.Ŵ F
      // 1dc: fsub
      // 1dd: invokestatic java/lang/Math.min (FF)F
      // 1e0: invokestatic java/lang/Math.max (FF)F
      // 1e3: fstore 20
      // 1e5: aload 0
      // 1e6: fload 17
      // 1e8: bipush 1
      // 1e9: aload 2
      // 1ea: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledWidth ()I
      // 1ed: invokestatic java/lang/Math.max (II)I
      // 1f0: i2f
      // 1f1: fdiv
      // 1f2: putfield x/oc67aa5109f0.z F
      // 1f5: aload 0
      // 1f6: fload 20
      // 1f8: bipush 1
      // 1f9: aload 2
      // 1fa: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledHeight ()I
      // 1fd: invokestatic java/lang/Math.max (II)I
      // 200: i2f
      // 201: fdiv
      // 202: putfield x/oc67aa5109f0.ҭ F
      // 205: bipush 1
      // 206: ireturn
   }

   private void Ȁ(ocd289dfdfcb param1, List<oc6ae023f1e7> param2, oc1378bc114d param3, float param4, boolean param5, long param6) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: aload 0
      // 04: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 07: getfield x/oc93499ec6de.ѥ Lx/oca9cc61aada;
      // 0a: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0d: d2i
      // 0e: istore 9
      // 10: aload 0
      // 11: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 14: getfield x/oc93499ec6de.Ѕ Lx/oca9cc61aada;
      // 17: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 1a: d2i
      // 1b: istore 10
      // 1d: istore 8
      // 1f: invokestatic x/ocd2958dac48.Ѹ ()F
      // 22: fstore 11
      // 24: invokestatic net/minecraft/client/renderer/GlStateManager.pushMatrix ()V
      // 27: aload 0
      // 28: iload 8
      // 2a: ifne 6f
      // 2d: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 30: getfield x/oc93499ec6de.c Lx/oca9cc61aada;
      // 33: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 36: fload 11
      // 38: f2d
      // 39: dmul
      // 3a: aload 0
      // 3b: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 3e: getfield x/oc93499ec6de.Ͼ Lx/oca9cc61aada;
      // 41: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 44: fload 11
      // 46: f2d
      // 47: dmul
      // 48: dconst_0
      // 49: invokestatic net/minecraft/client/renderer/GlStateManager.translate (DDD)V
      // 4c: iload 9
      // 4e: ifeq 6a
      // 51: iload 9
      // 53: iload 8
      // 55: ifne 7a
      // 58: goto 5c
      // 5b: athrow
      // 5c: ldc_w -1401200096
      // 5f: ldc_w -1401200093
      // 62: ixor
      // 63: if_icmpne 78
      // 66: goto 6a
      // 69: athrow
      // 6a: aload 0
      // 6b: goto 6f
      // 6e: athrow
      // 6f: aload 1
      // 70: lload 6
      // 72: iload 10
      // 74: bipush 1
      // 75: invokevirtual x/oc67aa5109f0.ս (Lx/ocd289dfdfcb;JIZ)V
      // 78: iload 9
      // 7a: iload 8
      // 7c: ifne 8d
      // 7f: bipush 1
      // 80: if_icmpeq a0
      // 83: goto 87
      // 86: athrow
      // 87: iload 9
      // 89: goto 8d
      // 8c: athrow
      // 8d: iload 8
      // 8f: ifne b5
      // 92: ldc_w -1401200096
      // 95: ldc_w -1401200093
      // 98: ixor
      // 99: if_icmpne b3
      // 9c: goto a0
      // 9f: athrow
      // a0: aload 0
      // a1: aload 1
      // a2: aload 2
      // a3: aload 3
      // a4: fload 4
      // a6: iload 5
      // a8: lload 6
      // aa: iload 10
      // ac: invokevirtual x/oc67aa5109f0.Ď (Lx/ocd289dfdfcb;Ljava/util/List;Lx/oc1378bc114d;FZJI)V
      // af: goto b3
      // b2: athrow
      // b3: iload 9
      // b5: iload 8
      // b7: ifne ce
      // ba: ldc_w -1401200095
      // bd: ldc_w -1401200093
      // c0: ixor
      // c1: if_icmpeq d8
      // c4: goto c8
      // c7: athrow
      // c8: iload 9
      // ca: goto ce
      // cd: athrow
      // ce: ldc_w -1401200096
      // d1: ldc_w -1401200093
      // d4: ixor
      // d5: if_icmpne e5
      // d8: aload 0
      // d9: aload 1
      // da: lload 6
      // dc: iload 10
      // de: invokevirtual x/oc67aa5109f0.j (Lx/ocd289dfdfcb;JI)V
      // e1: goto e5
      // e4: athrow
      // e5: invokestatic net/minecraft/client/renderer/GlStateManager.popMatrix ()V
      // e8: goto f3
      // eb: astore 12
      // ed: invokestatic net/minecraft/client/renderer/GlStateManager.popMatrix ()V
      // f0: aload 12
      // f2: athrow
      // f3: return
   }

   private void ս(ocd289dfdfcb param1, long param2, int param4, boolean param5) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: aload 0
      // 004: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 007: getfield x/oc93499ec6de.ʟ Lx/oca9cc61aada;
      // 00a: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 00d: d2f
      // 00e: invokestatic x/ocd2958dac48.Ѹ ()F
      // 011: fmul
      // 012: fstore 7
      // 014: istore 6
      // 016: aload 1
      // 017: getfield x/ocd289dfdfcb.ϗ Ljava/util/List;
      // 01a: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 01f: astore 8
      // 021: aload 8
      // 023: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 028: ifeq 286
      // 02b: aload 8
      // 02d: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 032: checkcast x/oc3094f205ad
      // 035: astore 9
      // 037: iload 4
      // 039: iload 6
      // 03b: ifne 056
      // 03e: ifge 054
      // 041: goto 045
      // 044: athrow
      // 045: aload 0
      // 046: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 049: getfield x/oc93499ec6de.Ǉ Lx/oca9cc61aada;
      // 04c: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 04f: d2f
      // 050: goto 057
      // 053: athrow
      // 054: iload 4
      // 056: i2f
      // 057: aload 9
      // 059: getfield x/oc3094f205ad.Γ F
      // 05c: fmul
      // 05d: invokestatic java/lang/Math.round (F)I
      // 060: istore 10
      // 062: aload 0
      // 063: aload 9
      // 065: lload 2
      // 066: invokevirtual x/oc67aa5109f0.Ϝ (Lx/oc3094f205ad;J)I
      // 069: istore 11
      // 06b: aload 0
      // 06c: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 06f: getfield x/oc93499ec6de.ъ Lx/oc24a0a5bddf;
      // 072: invokevirtual x/oc24a0a5bddf.ͳ ()I
      // 075: istore 12
      // 077: iload 5
      // 079: iload 6
      // 07b: ifne 09a
      // 07e: ifeq 094
      // 081: goto 085
      // 084: athrow
      // 085: aload 0
      // 086: iload 11
      // 088: iload 11
      // 08a: invokevirtual x/oc67aa5109f0.Ϸ (II)I
      // 08d: istore 12
      // 08f: iload 6
      // 091: ifeq 122
      // 094: iload 4
      // 096: goto 09a
      // 099: athrow
      // 09a: iload 6
      // 09c: ifne 0c0
      // 09f: iflt 0ae
      // 0a2: goto 0a6
      // 0a5: athrow
      // 0a6: bipush -1
      // 0a7: istore 12
      // 0a9: iload 6
      // 0ab: ifeq 122
      // 0ae: aload 0
      // 0af: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 0b2: getfield x/oc93499ec6de.ƺ Lx/oca9cc61aada;
      // 0b5: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0b8: ldc2_w 2.0
      // 0bb: dcmpl
      // 0bc: goto 0c0
      // 0bf: athrow
      // 0c0: iload 6
      // 0c2: ifne 120
      // 0c5: ifeq 106
      // 0c8: goto 0cc
      // 0cb: athrow
      // 0cc: aload 0
      // 0cd: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 0d0: getfield x/oc93499ec6de.ƺ Lx/oca9cc61aada;
      // 0d3: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0d6: ldc2_w 3.0
      // 0d9: dcmpl
      // 0da: iload 6
      // 0dc: ifne 129
      // 0df: goto 0e3
      // 0e2: athrow
      // 0e3: ifne 122
      // 0e6: goto 0ea
      // 0e9: athrow
      // 0ea: aload 0
      // 0eb: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 0ee: getfield x/oc93499ec6de.ɔ Lx/oca9cc61aada;
      // 0f1: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0f4: dconst_0
      // 0f5: dcmpl
      // 0f6: iload 6
      // 0f8: ifne 129
      // 0fb: goto 0ff
      // 0fe: athrow
      // 0ff: ifne 122
      // 102: goto 106
      // 105: athrow
      // 106: iload 12
      // 108: iload 11
      // 10a: aload 0
      // 10b: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 10e: getfield x/oc93499ec6de.Ɲ Lx/oca9cc61aada;
      // 111: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 114: d2f
      // 115: ldc_w 100.0
      // 118: fdiv
      // 119: invokestatic x/oc67aa5109f0.Ò (IIF)I
      // 11c: goto 120
      // 11f: athrow
      // 120: istore 12
      // 122: iload 12
      // 124: iload 10
      // 126: invokestatic x/oc7ab2161b9f.Ҭ (II)I
      // 129: istore 12
      // 12b: fload 7
      // 12d: aload 9
      // 12f: getfield x/oc3094f205ad.Ӽ F
      // 132: aload 9
      // 134: getfield x/oc3094f205ad.Ȃ F
      // 137: fsub
      // 138: aload 9
      // 13a: getfield x/oc3094f205ad.Ñ F
      // 13d: aload 9
      // 13f: getfield x/oc3094f205ad.Ň F
      // 142: fsub
      // 143: invokestatic java/lang/Math.min (FF)F
      // 146: fconst_2
      // 147: fdiv
      // 148: invokestatic java/lang/Math.min (FF)F
      // 14b: fstore 13
      // 14d: iload 4
      // 14f: iload 6
      // 151: ifne 239
      // 154: ifge 228
      // 157: goto 15b
      // 15a: athrow
      // 15b: aload 0
      // 15c: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 15f: getfield x/oc93499ec6de.ƺ Lx/oca9cc61aada;
      // 162: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 165: ldc2_w 3.0
      // 168: dcmpl
      // 169: iload 6
      // 16b: ifne 239
      // 16e: goto 172
      // 171: athrow
      // 172: ifne 228
      // 175: goto 179
      // 178: athrow
      // 179: aload 0
      // 17a: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 17d: iload 6
      // 17f: ifne 1a7
      // 182: goto 186
      // 185: athrow
      // 186: getfield x/oc93499ec6de.ɔ Lx/oca9cc61aada;
      // 189: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 18c: dconst_1
      // 18d: dcmpl
      // 18e: ifne 1a3
      // 191: goto 195
      // 194: athrow
      // 195: aload 0
      // 196: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 199: getfield x/oc93499ec6de.ͷ Lx/oc24a0a5bddf;
      // 19c: invokevirtual x/oc24a0a5bddf.ͳ ()I
      // 19f: goto 1d3
      // 1a2: athrow
      // 1a3: aload 0
      // 1a4: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 1a7: getfield x/oc93499ec6de.ъ Lx/oc24a0a5bddf;
      // 1aa: invokevirtual x/oc24a0a5bddf.ͳ ()I
      // 1ad: aload 9
      // 1af: getfield x/oc3094f205ad.Ӽ F
      // 1b2: f2d
      // 1b3: aload 9
      // 1b5: getfield x/oc3094f205ad.Ñ F
      // 1b8: ldc_w 40.0
      // 1bb: fadd
      // 1bc: f2d
      // 1bd: lload 2
      // 1be: invokestatic x/ocd2958dac48.Ǩ (DDJ)I
      // 1c1: aload 0
      // 1c2: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 1c5: getfield x/oc93499ec6de.Ɲ Lx/oca9cc61aada;
      // 1c8: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 1cb: d2f
      // 1cc: ldc_w 100.0
      // 1cf: fdiv
      // 1d0: invokestatic x/oc67aa5109f0.Ò (IIF)I
      // 1d3: istore 14
      // 1d5: iload 6
      // 1d7: iload 12
      // 1d9: iload 14
      // 1db: iload 10
      // 1dd: invokestatic x/oc7ab2161b9f.Ҭ (II)I
      // 1e0: aload 0
      // 1e1: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 1e4: getfield x/oc93499ec6de.Ψ Lx/oca9cc61aada;
      // 1e7: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 1ea: d2i
      // 1eb: invokestatic x/oc67aa5109f0.ÿ (III)[I
      // 1ee: astore 15
      // 1f0: aload 9
      // 1f2: getfield x/oc3094f205ad.Ȃ F
      // 1f5: aload 9
      // 1f7: getfield x/oc3094f205ad.Ň F
      // 1fa: aload 9
      // 1fc: getfield x/oc3094f205ad.Ӽ F
      // 1ff: aload 9
      // 201: getfield x/oc3094f205ad.Ñ F
      // 204: fload 13
      // 206: aload 15
      // 208: bipush 0
      // 209: iaload
      // 20a: aload 15
      // 20c: bipush 1
      // 20d: iaload
      // 20e: aload 15
      // 210: ldc_w 1219711729
      // 213: ldc_w 1219711731
      // 216: ixor
      // 217: iaload
      // 218: aload 15
      // 21a: ldc_w 1219711728
      // 21d: ldc_w 1219711731
      // 220: ixor
      // 221: iaload
      // 222: invokestatic x/ocbd4917c4b1.Ӷ (FFFFFIIII)V
      // 225: ifeq 281
      // 228: fload 13
      // 22a: iload 6
      // 22c: ifne 269
      // 22f: goto 233
      // 232: athrow
      // 233: fconst_0
      // 234: fcmpl
      // 235: goto 239
      // 238: athrow
      // 239: ifle 260
      // 23c: aload 9
      // 23e: getfield x/oc3094f205ad.Ȃ F
      // 241: aload 9
      // 243: getfield x/oc3094f205ad.Ň F
      // 246: aload 9
      // 248: getfield x/oc3094f205ad.Ӽ F
      // 24b: aload 9
      // 24d: getfield x/oc3094f205ad.Ñ F
      // 250: fload 13
      // 252: iload 12
      // 254: invokestatic x/ocbd4917c4b1.Ӛ (FFFFFI)V
      // 257: iload 6
      // 259: ifeq 281
      // 25c: goto 260
      // 25f: athrow
      // 260: aload 9
      // 262: getfield x/oc3094f205ad.Ȃ F
      // 265: goto 269
      // 268: athrow
      // 269: f2d
      // 26a: aload 9
      // 26c: getfield x/oc3094f205ad.Ň F
      // 26f: f2d
      // 270: aload 9
      // 272: getfield x/oc3094f205ad.Ӽ F
      // 275: f2d
      // 276: aload 9
      // 278: getfield x/oc3094f205ad.Ñ F
      // 27b: f2d
      // 27c: iload 12
      // 27e: invokestatic x/ocbd4917c4b1.ĉ (DDDDI)V
      // 281: iload 6
      // 283: ifeq 021
      // 286: return
   }

   private void j(ocd289dfdfcb param1, long param2, int param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: aload 1
      // 004: getfield x/ocd289dfdfcb.Ԝ Ljava/util/List;
      // 007: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 00c: astore 6
      // 00e: istore 5
      // 010: aload 6
      // 012: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 017: ifeq 106
      // 01a: aload 6
      // 01c: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 021: checkcast x/oc2ccdd596a1
      // 024: astore 7
      // 026: aload 7
      // 028: getfield x/oc2ccdd596a1.ė F
      // 02b: aload 7
      // 02d: getfield x/oc2ccdd596a1.П F
      // 030: fadd
      // 031: fconst_2
      // 032: fdiv
      // 033: f2d
      // 034: aload 7
      // 036: getfield x/oc2ccdd596a1.ӳ F
      // 039: f2d
      // 03a: lload 2
      // 03b: invokestatic x/ocd2958dac48.Ǩ (DDJ)I
      // 03e: istore 8
      // 040: aload 0
      // 041: iload 5
      // 043: ifne 05f
      // 046: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 049: getfield x/oc93499ec6de.ƚ Lx/oca9cc61aada;
      // 04c: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 04f: dconst_0
      // 050: dcmpl
      // 051: ifne 05e
      // 054: goto 058
      // 057: athrow
      // 058: iload 8
      // 05a: goto 085
      // 05d: athrow
      // 05e: aload 0
      // 05f: iload 5
      // 061: ifne 07c
      // 064: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 067: getfield x/oc93499ec6de.ƚ Lx/oca9cc61aada;
      // 06a: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 06d: dconst_1
      // 06e: dcmpl
      // 06f: ifne 07b
      // 072: goto 076
      // 075: athrow
      // 076: bipush -1
      // 077: goto 085
      // 07a: athrow
      // 07b: aload 0
      // 07c: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 07f: getfield x/oc93499ec6de.џ Lx/oc24a0a5bddf;
      // 082: invokevirtual x/oc24a0a5bddf.ͳ ()I
      // 085: istore 9
      // 087: iload 4
      // 089: iload 5
      // 08b: ifne 0a1
      // 08e: iflt 0a3
      // 091: goto 095
      // 094: athrow
      // 095: aload 0
      // 096: iload 9
      // 098: iload 8
      // 09a: invokevirtual x/oc67aa5109f0.Ϸ (II)I
      // 09d: goto 0a1
      // 0a0: athrow
      // 0a1: istore 9
      // 0a3: fconst_0
      // 0a4: fconst_1
      // 0a5: aload 1
      // 0a6: getfield x/ocd289dfdfcb.Y [F
      // 0a9: aload 7
      // 0ab: getfield x/oc2ccdd596a1.ӂ I
      // 0ae: faload
      // 0af: invokestatic java/lang/Math.min (FF)F
      // 0b2: invokestatic java/lang/Math.max (FF)F
      // 0b5: fstore 10
      // 0b7: iload 9
      // 0b9: iload 4
      // 0bb: iload 5
      // 0bd: ifne 0d8
      // 0c0: ifge 0d6
      // 0c3: goto 0c7
      // 0c6: athrow
      // 0c7: aload 0
      // 0c8: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 0cb: getfield x/oc93499ec6de.Ù Lx/oca9cc61aada;
      // 0ce: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0d1: d2f
      // 0d2: goto 0d9
      // 0d5: athrow
      // 0d6: iload 4
      // 0d8: i2f
      // 0d9: fload 10
      // 0db: fmul
      // 0dc: invokestatic java/lang/Math.round (F)I
      // 0df: invokestatic x/oc7ab2161b9f.Ҭ (II)I
      // 0e2: istore 9
      // 0e4: iload 5
      // 0e6: aload 7
      // 0e8: getfield x/oc2ccdd596a1.ė F
      // 0eb: f2d
      // 0ec: aload 7
      // 0ee: getfield x/oc2ccdd596a1.ӳ F
      // 0f1: f2d
      // 0f2: aload 7
      // 0f4: getfield x/oc2ccdd596a1.П F
      // 0f7: f2d
      // 0f8: aload 7
      // 0fa: getfield x/oc2ccdd596a1.ӡ F
      // 0fd: f2d
      // 0fe: iload 9
      // 100: invokestatic x/ocbd4917c4b1.ĉ (DDDDI)V
      // 103: ifeq 010
      // 106: return
   }

   private void Ď(ocd289dfdfcb param1, List<oc6ae023f1e7> param2, oc1378bc114d param3, float param4, boolean param5, long param6, int param8) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: aload 1
      // 004: getfield x/ocd289dfdfcb.ϗ Ljava/util/List;
      // 007: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 00c: astore 10
      // 00e: istore 9
      // 010: aload 10
      // 012: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 017: ifeq 465
      // 01a: aload 10
      // 01c: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 021: checkcast x/oc3094f205ad
      // 024: astore 11
      // 026: iload 8
      // 028: iload 9
      // 02a: ifne 045
      // 02d: ifge 043
      // 030: goto 034
      // 033: athrow
      // 034: aload 0
      // 035: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 038: getfield x/oc93499ec6de.ɟ Lx/oca9cc61aada;
      // 03b: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 03e: d2f
      // 03f: goto 046
      // 042: athrow
      // 043: iload 8
      // 045: i2f
      // 046: aload 11
      // 048: getfield x/oc3094f205ad.Γ F
      // 04b: fmul
      // 04c: invokestatic java/lang/Math.round (F)I
      // 04f: istore 12
      // 051: iload 8
      // 053: iload 9
      // 055: ifne 070
      // 058: ifge 06e
      // 05b: goto 05f
      // 05e: athrow
      // 05f: aload 0
      // 060: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 063: getfield x/oc93499ec6de.ϗ Lx/oca9cc61aada;
      // 066: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 069: d2f
      // 06a: goto 071
      // 06d: athrow
      // 06e: iload 8
      // 070: i2f
      // 071: aload 11
      // 073: getfield x/oc3094f205ad.Γ F
      // 076: fmul
      // 077: invokestatic java/lang/Math.round (F)I
      // 07a: istore 13
      // 07c: iload 12
      // 07e: iload 13
      // 080: invokestatic java/lang/Math.max (II)I
      // 083: ldc_w 660227080
      // 086: ldc_w 660227084
      // 089: ixor
      // 08a: if_icmpge 096
      // 08d: iload 9
      // 08f: ifeq 010
      // 092: goto 096
      // 095: athrow
      // 096: aload 2
      // 097: aload 11
      // 099: getfield x/oc3094f205ad.ǜ I
      // 09c: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 0a1: checkcast x/oc6ae023f1e7
      // 0a4: astore 14
      // 0a6: invokestatic x/ocd2958dac48.Ѹ ()F
      // 0a9: fstore 15
      // 0ab: aload 11
      // 0ad: getfield x/oc3094f205ad.J F
      // 0b0: aload 0
      // 0b1: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 0b4: getfield x/oc93499ec6de.Ӓ Lx/oca9cc61aada;
      // 0b7: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0ba: d2f
      // 0bb: fload 15
      // 0bd: fmul
      // 0be: fadd
      // 0bf: fstore 16
      // 0c1: aload 11
      // 0c3: getfield x/oc3094f205ad.Ň F
      // 0c6: fload 4
      // 0c8: fadd
      // 0c9: aload 3
      // 0ca: invokeinterface x/oc1378bc114d.z$g5bxucc1j700 ()I 1
      // 0cf: i2f
      // 0d0: fadd
      // 0d1: aload 0
      // 0d2: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 0d5: getfield x/oc93499ec6de.Ļ Lx/oca9cc61aada;
      // 0d8: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0db: d2f
      // 0dc: fload 15
      // 0de: fmul
      // 0df: fadd
      // 0e0: fstore 17
      // 0e2: aload 11
      // 0e4: getfield x/oc3094f205ad.Ɛ F
      // 0e7: aload 0
      // 0e8: iload 9
      // 0ea: ifne 108
      // 0ed: getfield x/oc67aa5109f0.Ҿ Z
      // 0f0: ifeq 107
      // 0f3: goto 0f7
      // 0f6: athrow
      // 0f7: aload 0
      // 0f8: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 0fb: getfield x/oc93499ec6de.ɿ Lx/oca9cc61aada;
      // 0fe: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 101: d2f
      // 102: fneg
      // 103: goto 112
      // 106: athrow
      // 107: aload 0
      // 108: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 10b: getfield x/oc93499ec6de.ɿ Lx/oca9cc61aada;
      // 10e: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 111: d2f
      // 112: invokestatic x/ocd2958dac48.Ѹ ()F
      // 115: fmul
      // 116: fadd
      // 117: fstore 18
      // 119: iload 5
      // 11b: iload 9
      // 11d: ifne 132
      // 120: ifne 142
      // 123: goto 127
      // 126: athrow
      // 127: aload 11
      // 129: getfield x/oc3094f205ad.Γ F
      // 12c: fconst_1
      // 12d: fcmpg
      // 12e: goto 132
      // 131: athrow
      // 132: iload 9
      // 134: ifne 13f
      // 137: ifge 142
      // 13a: goto 13e
      // 13d: athrow
      // 13e: bipush 1
      // 13f: goto 143
      // 142: bipush 0
      // 143: istore 19
      // 145: iload 19
      // 147: iload 9
      // 149: ifne 1ba
      // 14c: ifeq 1b8
      // 14f: goto 153
      // 152: athrow
      // 153: iload 8
      // 155: ifge 161
      // 158: goto 15c
      // 15b: athrow
      // 15c: fconst_0
      // 15d: goto 16f
      // 160: athrow
      // 161: aload 0
      // 162: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 165: getfield x/oc93499ec6de.c Lx/oca9cc61aada;
      // 168: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 16b: d2f
      // 16c: fload 15
      // 16e: fmul
      // 16f: fstore 20
      // 171: iload 8
      // 173: ifge 17b
      // 176: fconst_0
      // 177: goto 189
      // 17a: athrow
      // 17b: aload 0
      // 17c: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 17f: getfield x/oc93499ec6de.Ͼ Lx/oca9cc61aada;
      // 182: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 185: d2f
      // 186: fload 15
      // 188: fmul
      // 189: fstore 21
      // 18b: aload 11
      // 18d: getfield x/oc3094f205ad.Ȃ F
      // 190: fload 20
      // 192: fadd
      // 193: f2d
      // 194: aload 11
      // 196: getfield x/oc3094f205ad.Ň F
      // 199: fload 21
      // 19b: fadd
      // 19c: f2d
      // 19d: aload 11
      // 19f: getfield x/oc3094f205ad.Ӽ F
      // 1a2: aload 11
      // 1a4: getfield x/oc3094f205ad.Ȃ F
      // 1a7: fsub
      // 1a8: f2d
      // 1a9: aload 11
      // 1ab: getfield x/oc3094f205ad.Ñ F
      // 1ae: aload 11
      // 1b0: getfield x/oc3094f205ad.Ň F
      // 1b3: fsub
      // 1b4: f2d
      // 1b5: invokestatic x/ocbd4917c4b1.Ď (DDDD)V
      // 1b8: iload 5
      // 1ba: iload 9
      // 1bc: ifne 1f5
      // 1bf: ifeq 1f3
      // 1c2: goto 1c6
      // 1c5: athrow
      // 1c6: invokestatic net/minecraft/client/renderer/GlStateManager.pushMatrix ()V
      // 1c9: fload 18
      // 1cb: aload 11
      // 1cd: getfield x/oc3094f205ad.Ň F
      // 1d0: fconst_0
      // 1d1: invokestatic net/minecraft/client/renderer/GlStateManager.translate (FFF)V
      // 1d4: aload 11
      // 1d6: getfield x/oc3094f205ad.Γ F
      // 1d9: aload 11
      // 1db: getfield x/oc3094f205ad.Γ F
      // 1de: fconst_1
      // 1df: invokestatic net/minecraft/client/renderer/GlStateManager.scale (FFF)V
      // 1e2: fload 18
      // 1e4: fneg
      // 1e5: aload 11
      // 1e7: getfield x/oc3094f205ad.Ň F
      // 1ea: fneg
      // 1eb: fconst_0
      // 1ec: invokestatic net/minecraft/client/renderer/GlStateManager.translate (FFF)V
      // 1ef: goto 1f3
      // 1f2: athrow
      // 1f3: iload 8
      // 1f5: iload 9
      // 1f7: ifne 204
      // 1fa: ifge 214
      // 1fd: goto 201
      // 200: athrow
      // 201: invokestatic x/ocd2958dac48.у ()Z
      // 204: iload 9
      // 206: ifne 211
      // 209: ifeq 214
      // 20c: goto 210
      // 20f: athrow
      // 210: bipush 1
      // 211: goto 215
      // 214: bipush 0
      // 215: istore 20
      // 217: aload 0
      // 218: aload 11
      // 21a: lload 6
      // 21c: invokevirtual x/oc67aa5109f0.Ϝ (Lx/oc3094f205ad;J)I
      // 21f: istore 21
      // 221: aload 0
      // 222: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 225: iload 9
      // 227: ifne 24c
      // 22a: getfield x/oc93499ec6de.ã Lx/oca9cc61aada;
      // 22d: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 230: dconst_0
      // 231: dcmpl
      // 232: ifne 23f
      // 235: goto 239
      // 238: athrow
      // 239: iload 21
      // 23b: goto 266
      // 23e: athrow
      // 23f: aload 0
      // 240: iload 9
      // 242: ifne 25d
      // 245: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 248: goto 24c
      // 24b: athrow
      // 24c: getfield x/oc93499ec6de.ã Lx/oca9cc61aada;
      // 24f: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 252: dconst_1
      // 253: dcmpl
      // 254: ifne 25c
      // 257: bipush -1
      // 258: goto 266
      // 25b: athrow
      // 25c: aload 0
      // 25d: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 260: getfield x/oc93499ec6de.ä Lx/oc24a0a5bddf;
      // 263: invokevirtual x/oc24a0a5bddf.ͳ ()I
      // 266: istore 22
      // 268: aload 0
      // 269: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 26c: getfield x/oc93499ec6de.β Lx/oca9cc61aada;
      // 26f: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 272: dconst_0
      // 273: iload 9
      // 275: ifne 296
      // 278: dcmpl
      // 279: ifne 28b
      // 27c: goto 280
      // 27f: athrow
      // 280: ldc_w -655298906
      // 283: ldc_w 660227084
      // 286: ixor
      // 287: goto 2d2
      // 28a: athrow
      // 28b: aload 0
      // 28c: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 28f: getfield x/oc93499ec6de.β Lx/oca9cc61aada;
      // 292: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 295: dconst_1
      // 296: iload 9
      // 298: ifne 2bf
      // 29b: dcmpl
      // 29c: ifne 2a9
      // 29f: goto 2a3
      // 2a2: athrow
      // 2a3: iload 21
      // 2a5: goto 2d2
      // 2a8: athrow
      // 2a9: aload 0
      // 2aa: iload 9
      // 2ac: ifne 2c9
      // 2af: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 2b2: getfield x/oc93499ec6de.β Lx/oca9cc61aada;
      // 2b5: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 2b8: ldc2_w 2.0
      // 2bb: goto 2bf
      // 2be: athrow
      // 2bf: dcmpl
      // 2c0: ifne 2c8
      // 2c3: bipush -1
      // 2c4: goto 2d2
      // 2c7: athrow
      // 2c8: aload 0
      // 2c9: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 2cc: getfield x/oc93499ec6de.տ Lx/oc24a0a5bddf;
      // 2cf: invokevirtual x/oc24a0a5bddf.ͳ ()I
      // 2d2: istore 23
      // 2d4: iload 8
      // 2d6: iload 9
      // 2d8: ifne 2f8
      // 2db: iflt 2f6
      // 2de: goto 2e2
      // 2e1: athrow
      // 2e2: aload 0
      // 2e3: iload 22
      // 2e5: iload 21
      // 2e7: invokevirtual x/oc67aa5109f0.Ϸ (II)I
      // 2ea: istore 22
      // 2ec: aload 0
      // 2ed: iload 23
      // 2ef: iload 21
      // 2f1: invokevirtual x/oc67aa5109f0.Ϸ (II)I
      // 2f4: istore 23
      // 2f6: iload 12
      // 2f8: iload 9
      // 2fa: ifne 3bd
      // 2fd: ldc_w 660227080
      // 300: ldc_w 660227084
      // 303: ixor
      // 304: if_icmplt 3b7
      // 307: goto 30b
      // 30a: athrow
      // 30b: aload 0
      // 30c: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 30f: getfield x/oc93499ec6de.ϧ Lx/occ2f8dff8d8;
      // 312: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 315: iload 9
      // 317: ifne 3bd
      // 31a: goto 31e
      // 31d: athrow
      // 31e: ifeq 3b7
      // 321: goto 325
      // 324: athrow
      // 325: aload 0
      // 326: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 329: getfield x/oc93499ec6de.ã Lx/oca9cc61aada;
      // 32c: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 32f: dconst_0
      // 330: dcmpl
      // 331: iload 9
      // 333: ifne 3bd
      // 336: goto 33a
      // 339: athrow
      // 33a: ifne 3b7
      // 33d: goto 341
      // 340: athrow
      // 341: iload 8
      // 343: iload 9
      // 345: ifne 3b1
      // 348: goto 34c
      // 34b: athrow
      // 34c: iflt 38f
      // 34f: goto 353
      // 352: athrow
      // 353: aload 0
      // 354: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 357: getfield x/oc93499ec6de.ʤ Lx/oca9cc61aada;
      // 35a: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 35d: ldc2_w 2.0
      // 360: dcmpl
      // 361: iload 9
      // 363: ifne 3bd
      // 366: goto 36a
      // 369: athrow
      // 36a: ifne 3b7
      // 36d: goto 371
      // 370: athrow
      // 371: aload 0
      // 372: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 375: getfield x/oc93499ec6de.Ԓ Lx/oca9cc61aada;
      // 378: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 37b: ldc2_w 2.0
      // 37e: dcmpl
      // 37f: iload 9
      // 381: ifne 3bd
      // 384: goto 388
      // 387: athrow
      // 388: ifeq 3b7
      // 38b: goto 38f
      // 38e: athrow
      // 38f: aload 3
      // 390: aload 14
      // 392: getfield x/oc6ae023f1e7.Ȗ Ljava/lang/String;
      // 395: fload 16
      // 397: fload 17
      // 399: fload 16
      // 39b: aload 11
      // 39d: lload 6
      // 39f: iload 12
      // 3a1: invokedynamic z$151wba1mm8frh (FLx/oc3094f205ad;JI)Lx/ocd9533bdf8b; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (CFFLjava/lang/Integer;)I, x/oc67aa5109f0.q6iv4fiso7e22 (FLx/oc3094f205ad;JICFFLjava/lang/Integer;)I, (CFFLjava/lang/Integer;)I ]
      // 3a6: iload 20
      // 3a8: invokeinterface x/oc1378bc114d.z$22eyp2803ejhs (Ljava/lang/String;FFLx/ocd9533bdf8b;Z)I 6
      // 3ad: goto 3b1
      // 3b0: athrow
      // 3b1: pop
      // 3b2: iload 9
      // 3b4: ifeq 3ed
      // 3b7: iload 12
      // 3b9: goto 3bd
      // 3bc: athrow
      // 3bd: iload 9
      // 3bf: ifne 3ef
      // 3c2: ldc_w 660227080
      // 3c5: ldc_w 660227084
      // 3c8: ixor
      // 3c9: if_icmplt 3ed
      // 3cc: goto 3d0
      // 3cf: athrow
      // 3d0: aload 3
      // 3d1: aload 14
      // 3d3: getfield x/oc6ae023f1e7.Ȗ Ljava/lang/String;
      // 3d6: fload 16
      // 3d8: fload 17
      // 3da: iload 22
      // 3dc: iload 12
      // 3de: invokestatic x/oc7ab2161b9f.Ҭ (II)I
      // 3e1: iload 20
      // 3e3: invokeinterface x/oc1378bc114d.z$ao2ykh4tuw6w (Ljava/lang/String;FFIZ)I 6
      // 3e8: pop
      // 3e9: goto 3ed
      // 3ec: athrow
      // 3ed: iload 13
      // 3ef: iload 9
      // 3f1: ifne 427
      // 3f4: ldc_w 660227080
      // 3f7: ldc_w 660227084
      // 3fa: ixor
      // 3fb: if_icmplt 425
      // 3fe: goto 402
      // 401: athrow
      // 402: aload 3
      // 403: aload 14
      // 405: getfield x/oc6ae023f1e7.Ƕ Ljava/lang/String;
      // 408: fload 16
      // 40a: aload 14
      // 40c: getfield x/oc6ae023f1e7.ɂ F
      // 40f: fadd
      // 410: fload 17
      // 412: iload 23
      // 414: iload 13
      // 416: invokestatic x/oc7ab2161b9f.Ҭ (II)I
      // 419: iload 20
      // 41b: invokeinterface x/oc1378bc114d.z$ao2ykh4tuw6w (Ljava/lang/String;FFIZ)I 6
      // 420: pop
      // 421: goto 425
      // 424: athrow
      // 425: iload 5
      // 427: iload 9
      // 429: ifne 438
      // 42c: ifeq 436
      // 42f: goto 433
      // 432: athrow
      // 433: invokestatic net/minecraft/client/renderer/GlStateManager.popMatrix ()V
      // 436: iload 19
      // 438: ifeq 460
      // 43b: invokestatic x/ocbd4917c4b1.ǟ ()V
      // 43e: goto 460
      // 441: athrow
      // 442: astore 24
      // 444: iload 5
      // 446: iload 9
      // 448: ifne 457
      // 44b: ifeq 455
      // 44e: goto 452
      // 451: athrow
      // 452: invokestatic net/minecraft/client/renderer/GlStateManager.popMatrix ()V
      // 455: iload 19
      // 457: ifeq 45d
      // 45a: invokestatic x/ocbd4917c4b1.ǟ ()V
      // 45d: aload 24
      // 45f: athrow
      // 460: iload 9
      // 462: ifeq 010
      // 465: return
   }

   private int Ϝ(oc3094f205ad var1, long var2) {
      return ocd2958dac48.Ǩ((var1.Ȃ + var1.Ӽ) / 2.0F, var1.Ň, var2);
   }

   private int Ϸ(int param1, int param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 3
      // 04: aload 0
      // 05: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 08: getfield x/oc93499ec6de.Ԓ Lx/oca9cc61aada;
      // 0b: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0e: ldc2_w 2.0
      // 11: iload 3
      // 12: ifne 3c
      // 15: dcmpl
      // 16: ifne 29
      // 19: goto 1d
      // 1c: athrow
      // 1d: aload 0
      // 1e: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 21: getfield x/oc93499ec6de.ǻ Lx/oc24a0a5bddf;
      // 24: invokevirtual x/oc24a0a5bddf.ͳ ()I
      // 27: ireturn
      // 28: athrow
      // 29: aload 0
      // 2a: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 2d: iload 3
      // 2e: ifne 47
      // 31: getfield x/oc93499ec6de.Ԓ Lx/oca9cc61aada;
      // 34: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 37: dconst_1
      // 38: goto 3c
      // 3b: athrow
      // 3c: dcmpl
      // 3d: ifne 43
      // 40: iload 2
      // 41: ireturn
      // 42: athrow
      // 43: aload 0
      // 44: getfield x/oc67aa5109f0.φ Lx/oc93499ec6de;
      // 47: getfield x/oc93499ec6de.ʤ Lx/oca9cc61aada;
      // 4a: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 4d: dconst_1
      // 4e: dcmpl
      // 4f: iload 3
      // 50: ifne 61
      // 53: ifne 64
      // 56: goto 5a
      // 59: athrow
      // 5a: ldc_w 1522229616
      // 5d: ldc_w -1514446480
      // 60: ixor
      // 61: goto 65
      // 64: iload 1
      // 65: ireturn
   }

   static int[] ÿ(int param0, int param1, int param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: iload 0
      // 004: iload 1
      // 005: ldc_w 0.5
      // 008: invokestatic x/oc67aa5109f0.Ò (IIF)I
      // 00b: iload 0
      // 00c: ldc_w -261097995
      // 00f: ldc_w -261098003
      // 012: ixor
      // 013: iushr
      // 014: iload 1
      // 015: ldc_w -261097995
      // 018: ldc_w -261098003
      // 01b: ixor
      // 01c: iushr
      // 01d: iadd
      // 01e: ldc_w -261098001
      // 021: ldc_w -261098003
      // 024: ixor
      // 025: idiv
      // 026: invokestatic x/oc7ab2161b9f.Ҭ (II)I
      // 029: istore 4
      // 02b: istore 3
      // 02c: iload 2
      // 02d: iload 3
      // 02e: ifne 11f
      // 031: tableswitch 231 1 5 36 75 113 151 191
      // 054: athrow
      // 055: ldc_w -261098007
      // 058: ldc_w -261098003
      // 05b: ixor
      // 05c: newarray 10
      // 05e: dup
      // 05f: bipush 0
      // 060: iload 1
      // 061: iastore
      // 062: dup
      // 063: bipush 1
      // 064: iload 1
      // 065: iastore
      // 066: dup
      // 067: ldc_w -261098001
      // 06a: ldc_w -261098003
      // 06d: ixor
      // 06e: iload 0
      // 06f: iastore
      // 070: dup
      // 071: ldc_w -261098002
      // 074: ldc_w -261098003
      // 077: ixor
      // 078: iload 0
      // 079: iastore
      // 07a: areturn
      // 07b: athrow
      // 07c: ldc_w -261098007
      // 07f: ldc_w -261098003
      // 082: ixor
      // 083: newarray 10
      // 085: dup
      // 086: bipush 0
      // 087: iload 0
      // 088: iastore
      // 089: dup
      // 08a: bipush 1
      // 08b: iload 1
      // 08c: iastore
      // 08d: dup
      // 08e: ldc_w -261098001
      // 091: ldc_w -261098003
      // 094: ixor
      // 095: iload 1
      // 096: iastore
      // 097: dup
      // 098: ldc_w -261098002
      // 09b: ldc_w -261098003
      // 09e: ixor
      // 09f: iload 0
      // 0a0: iastore
      // 0a1: areturn
      // 0a2: ldc_w -261098007
      // 0a5: ldc_w -261098003
      // 0a8: ixor
      // 0a9: newarray 10
      // 0ab: dup
      // 0ac: bipush 0
      // 0ad: iload 1
      // 0ae: iastore
      // 0af: dup
      // 0b0: bipush 1
      // 0b1: iload 0
      // 0b2: iastore
      // 0b3: dup
      // 0b4: ldc_w -261098001
      // 0b7: ldc_w -261098003
      // 0ba: ixor
      // 0bb: iload 0
      // 0bc: iastore
      // 0bd: dup
      // 0be: ldc_w -261098002
      // 0c1: ldc_w -261098003
      // 0c4: ixor
      // 0c5: iload 1
      // 0c6: iastore
      // 0c7: areturn
      // 0c8: ldc_w -261098007
      // 0cb: ldc_w -261098003
      // 0ce: ixor
      // 0cf: newarray 10
      // 0d1: dup
      // 0d2: bipush 0
      // 0d3: iload 0
      // 0d4: iastore
      // 0d5: dup
      // 0d6: bipush 1
      // 0d7: iload 4
      // 0d9: iastore
      // 0da: dup
      // 0db: ldc_w -261098001
      // 0de: ldc_w -261098003
      // 0e1: ixor
      // 0e2: iload 1
      // 0e3: iastore
      // 0e4: dup
      // 0e5: ldc_w -261098002
      // 0e8: ldc_w -261098003
      // 0eb: ixor
      // 0ec: iload 4
      // 0ee: iastore
      // 0ef: areturn
      // 0f0: ldc_w -261098007
      // 0f3: ldc_w -261098003
      // 0f6: ixor
      // 0f7: newarray 10
      // 0f9: dup
      // 0fa: bipush 0
      // 0fb: iload 1
      // 0fc: iastore
      // 0fd: dup
      // 0fe: bipush 1
      // 0ff: iload 4
      // 101: iastore
      // 102: dup
      // 103: ldc_w -261098001
      // 106: ldc_w -261098003
      // 109: ixor
      // 10a: iload 0
      // 10b: iastore
      // 10c: dup
      // 10d: ldc_w -261098002
      // 110: ldc_w -261098003
      // 113: ixor
      // 114: iload 4
      // 116: iastore
      // 117: areturn
      // 118: ldc_w -261098007
      // 11b: ldc_w -261098003
      // 11e: ixor
      // 11f: newarray 10
      // 121: dup
      // 122: bipush 0
      // 123: iload 0
      // 124: iastore
      // 125: dup
      // 126: bipush 1
      // 127: iload 0
      // 128: iastore
      // 129: dup
      // 12a: ldc_w -261098001
      // 12d: ldc_w -261098003
      // 130: ixor
      // 131: iload 1
      // 132: iastore
      // 133: dup
      // 134: ldc_w -261098002
      // 137: ldc_w -261098003
      // 13a: ixor
      // 13b: iload 1
      // 13c: iastore
      // 13d: areturn
   }

   static int Ò(int var0, int var1, float var2) {
      float var3 = Math.max(0.0F, Math.min(1.0F, var2));
      int var4 = Math.round(
         (var0 >> (1706263039 ^ 1706263023) & (1706262800 ^ 1706263023)) * (1.0F - var3)
            + (var1 >> (1706263039 ^ 1706263023) & (1706262800 ^ 1706263023)) * var3
      );
      int var5 = Math.round(
         (var0 >> (1706263015 ^ 1706263023) & (1706262800 ^ 1706263023)) * (1.0F - var3)
            + (var1 >> (1706263015 ^ 1706263023) & (1706262800 ^ 1706263023)) * var3
      );
      int var6 = Math.round((var0 & (1706262800 ^ 1706263023)) * (1.0F - var3) + (var1 & (1706262800 ^ 1706263023)) * var3);
      return -1699511825 ^ 1706263023 | var4 << (1706263039 ^ 1706263023) | var5 << (1706263015 ^ 1706263023) | var6;
   }
}

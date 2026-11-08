package x;

import java.util.ArrayList;
import java.util.List;

public class oc491d322362 extends oc69da1aa7f5 {
   private final oca9cc61aada ɨ = new oca9cc61aada("Position X", 0.8, 0.0, 1.0, 0.01);
   private final oca9cc61aada մ = new oca9cc61aada("Position Y", 0.8, 0.0, 1.0, 0.01);
   private final occ2f8dff8d8 d = new occ2f8dff8d8("Space", true);
   private boolean ά = false;
   private double ƿ = 0.0;
   private double Ƞ = 0.0;
   private double ͻ = 0.0;
   private double Π = 0.0;
   private final List<oc5dc0fabda3> Ѹ = new ArrayList<>();
   private final float Ȧ = 22.0F;
   private final float з = 3.0F;
   public static boolean ȥ;

   public oc491d322362() {
      super("KeyStrokes", oce4cea752dd.Ŏ);
      this.ʌ(this.ɨ);
      this.ʌ(this.մ);
      this.ʌ(this.d);
      this.Ѹ.add(new oc5dc0fabda3("W", oc69da1aa7f5.ő.gameSettings.keyBindForward, 25.0F, 0.0F, 22.0F, 22.0F));
      this.Ѹ.add(new oc5dc0fabda3("A", oc69da1aa7f5.ő.gameSettings.keyBindLeft, 0.0F, 25.0F, 22.0F, 22.0F));
      this.Ѹ.add(new oc5dc0fabda3("S", oc69da1aa7f5.ő.gameSettings.keyBindBack, 25.0F, 25.0F, 22.0F, 22.0F));
      this.Ѹ.add(new oc5dc0fabda3("D", oc69da1aa7f5.ő.gameSettings.keyBindRight, 50.0F, 25.0F, 22.0F, 22.0F));
      this.Ѹ.add(new oc5dc0fabda3("Space", oc69da1aa7f5.ő.gameSettings.keyBindJump, 0.0F, 50.0F, 72.0F, 22.0F));
   }

   @oc66fa4f2195
   public void ȕ(ocf923d5a814 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 2
      // 04: aload 1
      // 05: getfield x/ocb508b4e274.Ұ Lx/oc110d7f376c;
      // 08: getstatic x/oc110d7f376c.END Lx/oc110d7f376c;
      // 0b: if_acmpne 18
      // 0e: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 11: ifne 1a
      // 14: goto 18
      // 17: athrow
      // 18: return
      // 19: athrow
      // 1a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1d: iload 2
      // 1e: ifne 4a
      // 21: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 24: ifnull 43
      // 27: goto 2b
      // 2a: athrow
      // 2b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 2e: iload 2
      // 2f: ifne 4a
      // 32: goto 36
      // 35: athrow
      // 36: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 39: instanceof net/minecraft/client/gui/GuiChat
      // 3c: ifeq 53
      // 3f: goto 43
      // 42: athrow
      // 43: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 46: goto 4a
      // 49: athrow
      // 4a: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 4d: getfield net/minecraft/client/settings/GameSettings.showDebugInfo Z
      // 50: ifeq 55
      // 53: return
      // 54: athrow
      // 55: aload 0
      // 56: invokevirtual x/oc491d322362.Ӿ ()V
      // 59: return
   }

   private void Ӿ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: new net/minecraft/client/gui/ScaledResolution
      // 003: dup
      // 004: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 007: invokespecial net/minecraft/client/gui/ScaledResolution.<init> (Lnet/minecraft/client/Minecraft;)V
      // 00a: astore 2
      // 00b: getstatic x/oce6044968f8.ђ Z
      // 00e: bipush 1
      // 00f: aload 2
      // 010: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledWidth ()I
      // 013: invokestatic java/lang/Math.max (II)I
      // 016: istore 3
      // 017: istore 1
      // 018: bipush 1
      // 019: aload 2
      // 01a: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledHeight ()I
      // 01d: invokestatic java/lang/Math.max (II)I
      // 020: istore 4
      // 022: aload 0
      // 023: getfield x/oc491d322362.ɨ Lx/oca9cc61aada;
      // 026: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 029: iload 3
      // 02a: i2d
      // 02b: dmul
      // 02c: d2f
      // 02d: fstore 5
      // 02f: aload 0
      // 030: getfield x/oc491d322362.մ Lx/oca9cc61aada;
      // 033: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 036: iload 4
      // 038: i2d
      // 039: dmul
      // 03a: d2f
      // 03b: fstore 6
      // 03d: invokestatic x/oce6044968f8.Ƽ ()F
      // 040: fstore 7
      // 042: ldc 72.0
      // 044: fload 7
      // 046: fmul
      // 047: fstore 8
      // 049: ldc 50.0
      // 04b: aload 0
      // 04c: getfield x/oc491d322362.d Lx/occ2f8dff8d8;
      // 04f: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 052: ifeq 05b
      // 055: ldc 22.0
      // 057: goto 05c
      // 05a: athrow
      // 05b: fconst_0
      // 05c: fadd
      // 05d: fload 7
      // 05f: fmul
      // 060: fstore 9
      // 062: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 065: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 068: instanceof net/minecraft/client/gui/GuiChat
      // 06b: iload 1
      // 06c: ifne 089
      // 06f: ifeq 259
      // 072: goto 076
      // 075: athrow
      // 076: invokestatic org/lwjgl/input/Mouse.getX ()I
      // 079: aload 2
      // 07a: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledWidth ()I
      // 07d: imul
      // 07e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 081: getfield net/minecraft/client/Minecraft.displayWidth I
      // 084: idiv
      // 085: goto 089
      // 088: athrow
      // 089: istore 10
      // 08b: aload 2
      // 08c: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledHeight ()I
      // 08f: invokestatic org/lwjgl/input/Mouse.getY ()I
      // 092: aload 2
      // 093: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledHeight ()I
      // 096: imul
      // 097: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 09a: getfield net/minecraft/client/Minecraft.displayHeight I
      // 09d: idiv
      // 09e: isub
      // 09f: bipush 1
      // 0a0: isub
      // 0a1: istore 11
      // 0a3: fload 5
      // 0a5: fstore 12
      // 0a7: fload 5
      // 0a9: fload 8
      // 0ab: fadd
      // 0ac: fstore 13
      // 0ae: fload 6
      // 0b0: fstore 14
      // 0b2: fload 6
      // 0b4: fload 9
      // 0b6: fadd
      // 0b7: fstore 15
      // 0b9: fload 12
      // 0bb: iload 1
      // 0bc: ifne 0e5
      // 0bf: f2i
      // 0c0: fload 14
      // 0c2: f2i
      // 0c3: fload 13
      // 0c5: f2i
      // 0c6: fload 15
      // 0c8: f2i
      // 0c9: ldc -1252095044
      // 0cb: ldc -173968317
      // 0cd: ixor
      // 0ce: invokestatic net/minecraft/client/gui/Gui.drawRect (IIIII)V
      // 0d1: iload 10
      // 0d3: i2f
      // 0d4: fload 12
      // 0d6: fcmpl
      // 0d7: iflt 121
      // 0da: goto 0de
      // 0dd: athrow
      // 0de: iload 10
      // 0e0: i2f
      // 0e1: goto 0e5
      // 0e4: athrow
      // 0e5: fload 13
      // 0e7: iload 1
      // 0e8: ifne 104
      // 0eb: fcmpg
      // 0ec: ifgt 121
      // 0ef: goto 0f3
      // 0f2: athrow
      // 0f3: iload 11
      // 0f5: iload 1
      // 0f6: ifne 11a
      // 0f9: goto 0fd
      // 0fc: athrow
      // 0fd: i2f
      // 0fe: fload 14
      // 100: goto 104
      // 103: athrow
      // 104: fcmpl
      // 105: iflt 121
      // 108: iload 11
      // 10a: iload 1
      // 10b: ifne 11e
      // 10e: goto 112
      // 111: athrow
      // 112: i2f
      // 113: fload 15
      // 115: fcmpg
      // 116: goto 11a
      // 119: athrow
      // 11a: ifgt 121
      // 11d: bipush 1
      // 11e: goto 122
      // 121: bipush 0
      // 122: istore 16
      // 124: aload 2
      // 125: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaleFactor ()I
      // 128: i2d
      // 129: aload 2
      // 12a: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaleFactor ()I
      // 12d: i2d
      // 12e: ldc2_w 2.0
      // 131: invokestatic java/lang/Math.pow (DD)D
      // 134: ddiv
      // 135: dstore 17
      // 137: iload 16
      // 139: iload 1
      // 13a: ifne 1aa
      // 13d: ifeq 1a6
      // 140: goto 144
      // 143: athrow
      // 144: aload 0
      // 145: iload 1
      // 146: ifne 1a7
      // 149: goto 14d
      // 14c: athrow
      // 14d: getfield x/oc491d322362.ά Z
      // 150: ifne 1a6
      // 153: goto 157
      // 156: athrow
      // 157: bipush 0
      // 158: iload 1
      // 159: ifne 1aa
      // 15c: goto 160
      // 15f: athrow
      // 160: invokestatic org/lwjgl/input/Mouse.isButtonDown (I)Z
      // 163: ifeq 1a6
      // 166: goto 16a
      // 169: athrow
      // 16a: aload 0
      // 16b: bipush 1
      // 16c: putfield x/oc491d322362.ά Z
      // 16f: aload 0
      // 170: aload 0
      // 171: getfield x/oc491d322362.ɨ Lx/oca9cc61aada;
      // 174: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 177: putfield x/oc491d322362.ƿ D
      // 17a: aload 0
      // 17b: aload 0
      // 17c: getfield x/oc491d322362.մ Lx/oca9cc61aada;
      // 17f: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 182: putfield x/oc491d322362.Ƞ D
      // 185: aload 0
      // 186: invokestatic org/lwjgl/input/Mouse.getX ()I
      // 189: i2d
      // 18a: dload 17
      // 18c: dmul
      // 18d: putfield x/oc491d322362.ͻ D
      // 190: aload 0
      // 191: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 194: getfield net/minecraft/client/Minecraft.displayHeight I
      // 197: invokestatic org/lwjgl/input/Mouse.getY ()I
      // 19a: isub
      // 19b: i2d
      // 19c: dload 17
      // 19e: dmul
      // 19f: putfield x/oc491d322362.Π D
      // 1a2: goto 1a6
      // 1a5: athrow
      // 1a6: aload 0
      // 1a7: getfield x/oc491d322362.ά Z
      // 1aa: iload 1
      // 1ab: ifne 1c5
      // 1ae: ifeq 259
      // 1b1: goto 1b5
      // 1b4: athrow
      // 1b5: bipush 0
      // 1b6: iload 1
      // 1b7: ifne 1dc
      // 1ba: goto 1be
      // 1bd: athrow
      // 1be: invokestatic org/lwjgl/input/Mouse.isButtonDown (I)Z
      // 1c1: goto 1c5
      // 1c4: athrow
      // 1c5: ifne 1d5
      // 1c8: aload 0
      // 1c9: bipush 0
      // 1ca: putfield x/oc491d322362.ά Z
      // 1cd: iload 1
      // 1ce: ifeq 259
      // 1d1: goto 1d5
      // 1d4: athrow
      // 1d5: invokestatic org/lwjgl/input/Mouse.getX ()I
      // 1d8: goto 1dc
      // 1db: athrow
      // 1dc: i2d
      // 1dd: dload 17
      // 1df: dmul
      // 1e0: dstore 19
      // 1e2: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1e5: getfield net/minecraft/client/Minecraft.displayHeight I
      // 1e8: invokestatic org/lwjgl/input/Mouse.getY ()I
      // 1eb: isub
      // 1ec: i2d
      // 1ed: dload 17
      // 1ef: dmul
      // 1f0: dstore 21
      // 1f2: dload 19
      // 1f4: aload 0
      // 1f5: getfield x/oc491d322362.ͻ D
      // 1f8: dsub
      // 1f9: aload 2
      // 1fa: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledWidth ()I
      // 1fd: i2d
      // 1fe: ddiv
      // 1ff: dstore 23
      // 201: dload 21
      // 203: aload 0
      // 204: getfield x/oc491d322362.Π D
      // 207: dsub
      // 208: aload 2
      // 209: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledHeight ()I
      // 20c: i2d
      // 20d: ddiv
      // 20e: dstore 25
      // 210: aload 0
      // 211: getfield x/oc491d322362.ɨ Lx/oca9cc61aada;
      // 214: dconst_0
      // 215: dconst_1
      // 216: aload 0
      // 217: getfield x/oc491d322362.ƿ D
      // 21a: dload 23
      // 21c: dadd
      // 21d: invokestatic java/lang/Math.min (DD)D
      // 220: invokestatic java/lang/Math.max (DD)D
      // 223: invokevirtual x/oca9cc61aada.Ȟ (D)D
      // 226: pop2
      // 227: aload 0
      // 228: getfield x/oc491d322362.մ Lx/oca9cc61aada;
      // 22b: dconst_0
      // 22c: dconst_1
      // 22d: aload 0
      // 22e: getfield x/oc491d322362.Ƞ D
      // 231: dload 25
      // 233: dadd
      // 234: invokestatic java/lang/Math.min (DD)D
      // 237: invokestatic java/lang/Math.max (DD)D
      // 23a: invokevirtual x/oca9cc61aada.Ȟ (D)D
      // 23d: pop2
      // 23e: aload 0
      // 23f: getfield x/oc491d322362.ɨ Lx/oca9cc61aada;
      // 242: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 245: iload 3
      // 246: i2d
      // 247: dmul
      // 248: d2f
      // 249: fstore 5
      // 24b: aload 0
      // 24c: getfield x/oc491d322362.մ Lx/oca9cc61aada;
      // 24f: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 252: iload 4
      // 254: i2d
      // 255: dmul
      // 256: d2f
      // 257: fstore 6
      // 259: invokestatic x/oce6044968f8.ԗ ()Lx/oc1378bc114d;
      // 25c: astore 10
      // 25e: new java/util/ArrayList
      // 261: dup
      // 262: invokespecial java/util/ArrayList.<init> ()V
      // 265: astore 11
      // 267: aload 0
      // 268: getfield x/oc491d322362.Ѹ Ljava/util/List;
      // 26b: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 270: astore 12
      // 272: aload 12
      // 274: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 279: ifeq 2d7
      // 27c: aload 12
      // 27e: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 283: checkcast x/oc5dc0fabda3
      // 286: astore 13
      // 288: iload 1
      // 289: ifne 2dc
      // 28c: iload 1
      // 28d: ifne 2d3
      // 290: goto 294
      // 293: athrow
      // 294: aload 13
      // 296: getfield x/oc5dc0fabda3.Ӣ Ljava/lang/String;
      // 299: ldc "Space"
      // 29b: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 29e: ifeq 2be
      // 2a1: goto 2a5
      // 2a4: athrow
      // 2a5: aload 0
      // 2a6: getfield x/oc491d322362.d Lx/occ2f8dff8d8;
      // 2a9: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 2ac: iload 1
      // 2ad: ifne 2d2
      // 2b0: goto 2b4
      // 2b3: athrow
      // 2b4: ifne 2be
      // 2b7: goto 2bb
      // 2ba: athrow
      // 2bb: goto 272
      // 2be: aload 11
      // 2c0: aload 13
      // 2c2: fload 5
      // 2c4: fload 6
      // 2c6: fload 7
      // 2c8: aload 10
      // 2ca: invokevirtual x/oc5dc0fabda3.ґ (FFFLx/oc1378bc114d;)Lx/oc99b8eeba10;
      // 2cd: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 2d2: pop
      // 2d3: iload 1
      // 2d4: ifeq 272
      // 2d7: aload 11
      // 2d9: invokestatic x/oce6044968f8.Ҿ (Ljava/util/List;)V
      // 2dc: return
   }
}

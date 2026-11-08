package x;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;

public class ocdb10538f60 extends oc69da1aa7f5 {
   private static final int ĥ = 48;
   private static final int Ѣ = -11158;
   private static final String[] ʨ;
   private static final String[] Ĺ;
   private final occ2f8dff8d8 Հ;
   private final occ2f8dff8d8 ӟ;
   private final oca9cc61aada ո;
   private final oca9cc61aada Ə;
   private final oca9cc61aada Џ;
   private final oca9cc61aada Ȥ;
   private final oca9cc61aada Ӑ;
   private final oca9cc61aada ղ;
   private final oca9cc61aada ҩ;
   private final List<oc8fe127ea3b> Ū = new ArrayList<>();
   private final Random Ɏ = new Random();
   private ResourceLocation ʧ;
   private int Է;
   private int Ǭ;
   public static int n;

   public ocdb10538f60() {
      super("Fireflies", oce4cea752dd.Ŏ);
      this.ą("Surrounds you with fireflies or cinematic glowing particles, trails and sparks.");
      this.ʌ(this.Հ = new occ2f8dff8d8("Dark imprint", false));
      this.ʌ(this.ӟ = new occ2f8dff8d8("Lighting", true));
      this.ʌ(this.ո = new oca9cc61aada("Spawn delay", 3.0, 1.0, 10.0, 1.0));
      this.ʌ(this.Ə = new oca9cc61aada("Color mode", 0, Ĺ));
      this.ʌ(this.Џ = new oca9cc61aada("Particle size", 1.0, 0.5, 2.0, 0.1));
      this.ʌ(this.Ȥ = new oca9cc61aada("Density", 28.0, 4.0, 48.0, 1.0));
      this.ʌ(this.Ӑ = new oca9cc61aada("Flight speed", "x", 1.0, 0.25, 2.0, 0.05));
      this.ʌ(this.ղ = new oca9cc61aada("Trail length", "ms", 450.0, 0.0, 1000.0, 50.0));
      this.ʌ(this.ҩ = new oca9cc61aada("Mode", 0, ʨ));
   }

   @Override
   public String getInfo() {
      return ʨ[(int)this.ҩ.Ӂ()];
   }

   private boolean Ų() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 1
      // 04: aload 0
      // 05: getfield x/ocdb10538f60.ҩ Lx/oca9cc61aada;
      // 08: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0b: d2i
      // 0c: iload 1
      // 0d: ifne 1d
      // 10: bipush 1
      // 11: if_icmpne 20
      // 14: goto 18
      // 17: athrow
      // 18: bipush 1
      // 19: goto 1d
      // 1c: athrow
      // 1d: goto 21
      // 20: bipush 0
      // 21: ireturn
   }

   int П(double param1) {
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
      // 05: getfield x/ocdb10538f60.Ə Lx/oca9cc61aada;
      // 08: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0b: iload 3
      // 0c: ifne 21
      // 0f: d2i
      // 10: bipush 1
      // 11: if_icmpne 2c
      // 14: goto 18
      // 17: athrow
      // 18: dload 1
      // 19: ldc2_w 11.0
      // 1c: dmul
      // 1d: goto 21
      // 20: athrow
      // 21: dload 1
      // 22: ldc2_w 17.0
      // 25: dmul
      // 26: invokestatic x/ocd2958dac48.ʰ (DD)I
      // 29: goto 31
      // 2c: ldc -1642474836
      // 2e: ldc 1642464966
      // 30: ixor
      // 31: ireturn
   }

   @Override
   public void onEnable() {
      this.å();
      if (this.ʧ == null) {
         DynamicTexture var1 = new DynamicTexture(ԡ());
         var1.setBlurMipmap(true, false);
         this.ʧ = oc69da1aa7f5.ő.getTextureManager().getDynamicTextureLocation("mimeow/fireflies-glow", var1);
      }
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
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 1
      // 04: iload 1
      // 05: aload 0
      // 06: invokevirtual x/ocdb10538f60.å ()V
      // 09: ifne 28
      // 0c: aload 0
      // 0d: getfield x/ocdb10538f60.ʧ Lnet/minecraft/util/ResourceLocation;
      // 10: ifnull 2d
      // 13: goto 17
      // 16: athrow
      // 17: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1a: invokevirtual net/minecraft/client/Minecraft.getTextureManager ()Lnet/minecraft/client/renderer/texture/TextureManager;
      // 1d: aload 0
      // 1e: getfield x/ocdb10538f60.ʧ Lnet/minecraft/util/ResourceLocation;
      // 21: invokevirtual net/minecraft/client/renderer/texture/TextureManager.deleteTexture (Lnet/minecraft/util/ResourceLocation;)V
      // 24: goto 28
      // 27: athrow
      // 28: aload 0
      // 29: aconst_null
      // 2a: putfield x/ocdb10538f60.ʧ Lnet/minecraft/util/ResourceLocation;
      // 2d: return
   }

   @oc66fa4f2195
   public void ɐ(ocbab3c9954b var1) {
      this.å();
   }

   private void å() {
      this.Ū.clear();
      this.Է = 0;
      this.Ǭ = (int)this.ҩ.Ӂ();
   }

   @Override
   public void z$1m9j3ewef9s() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: istore 1
      // 004: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 007: iload 1
      // 008: ifne 021
      // 00b: ifne 018
      // 00e: goto 012
      // 011: athrow
      // 012: aload 0
      // 013: invokevirtual x/ocdb10538f60.å ()V
      // 016: return
      // 017: athrow
      // 018: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 01b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 01e: getfield net/minecraft/client/entity/EntityPlayerSP.ticksExisted I
      // 021: iload 1
      // 022: ifne 03d
      // 025: bipush 1
      // 026: if_icmple 048
      // 029: goto 02d
      // 02c: athrow
      // 02d: aload 0
      // 02e: iload 1
      // 02f: ifne 051
      // 032: goto 036
      // 035: athrow
      // 036: getfield x/ocdb10538f60.Ǭ I
      // 039: goto 03d
      // 03c: athrow
      // 03d: aload 0
      // 03e: getfield x/ocdb10538f60.ҩ Lx/oca9cc61aada;
      // 041: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 044: d2i
      // 045: if_icmpeq 050
      // 048: aload 0
      // 049: invokevirtual x/ocdb10538f60.å ()V
      // 04c: goto 050
      // 04f: athrow
      // 050: aload 0
      // 051: getfield x/ocdb10538f60.Ū Ljava/util/List;
      // 054: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 059: astore 2
      // 05a: aload 2
      // 05b: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 060: ifeq 075
      // 063: aload 2
      // 064: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 069: checkcast x/oc8fe127ea3b
      // 06c: astore 3
      // 06d: iload 1
      // 06e: aload 3
      // 06f: invokevirtual x/oc8fe127ea3b.К ()V
      // 072: ifeq 05a
      // 075: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 078: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 07b: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionVector ()Lnet/minecraft/util/Vec3;
      // 07e: astore 2
      // 07f: aload 0
      // 080: getfield x/ocdb10538f60.Ū Ljava/util/List;
      // 083: aload 2
      // 084: invokedynamic test (Lnet/minecraft/util/Vec3;)Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, x/ocdb10538f60.q2p0uv65iadklv (Lnet/minecraft/util/Vec3;Lx/oc8fe127ea3b;)Z, (Lx/oc8fe127ea3b;)Z ]
      // 089: invokeinterface java/util/List.removeIf (Ljava/util/function/Predicate;)Z 2
      // 08e: pop
      // 08f: ldc_w -360995348
      // 092: ldc_w -360995364
      // 095: ixor
      // 096: aload 0
      // 097: getfield x/ocdb10538f60.Ȥ Lx/oca9cc61aada;
      // 09a: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 09d: d2i
      // 09e: invokestatic java/lang/Math.min (II)I
      // 0a1: istore 3
      // 0a2: aload 0
      // 0a3: getfield x/ocdb10538f60.Ū Ljava/util/List;
      // 0a6: invokeinterface java/util/List.size ()I 1
      // 0ab: iload 3
      // 0ac: if_icmple 0c6
      // 0af: iload 1
      // 0b0: ifne 162
      // 0b3: aload 0
      // 0b4: getfield x/ocdb10538f60.Ū Ljava/util/List;
      // 0b7: bipush 0
      // 0b8: invokeinterface java/util/List.remove (I)Ljava/lang/Object; 2
      // 0bd: pop
      // 0be: iload 1
      // 0bf: ifeq 0a2
      // 0c2: goto 0c6
      // 0c5: athrow
      // 0c6: aload 0
      // 0c7: dup
      // 0c8: getfield x/ocdb10538f60.Է I
      // 0cb: bipush 1
      // 0cc: iadd
      // 0cd: iload 1
      // 0ce: ifne 0ea
      // 0d1: dup_x1
      // 0d2: putfield x/ocdb10538f60.Է I
      // 0d5: aload 0
      // 0d6: getfield x/ocdb10538f60.ո Lx/oca9cc61aada;
      // 0d9: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0dc: d2i
      // 0dd: if_icmplt 162
      // 0e0: goto 0e4
      // 0e3: athrow
      // 0e4: aload 0
      // 0e5: bipush 0
      // 0e6: goto 0ea
      // 0e9: athrow
      // 0ea: putfield x/ocdb10538f60.Է I
      // 0ed: aload 0
      // 0ee: invokevirtual x/ocdb10538f60.Ų ()Z
      // 0f1: iload 1
      // 0f2: ifne 103
      // 0f5: ifeq 106
      // 0f8: goto 0fc
      // 0fb: athrow
      // 0fc: ldc_w -360995362
      // 0ff: ldc_w -360995364
      // 102: ixor
      // 103: goto 107
      // 106: bipush 1
      // 107: istore 4
      // 109: bipush 0
      // 10a: istore 5
      // 10c: iload 5
      // 10e: iload 4
      // 110: if_icmpge 162
      // 113: aload 0
      // 114: iload 1
      // 115: ifne 12d
      // 118: getfield x/ocdb10538f60.Ū Ljava/util/List;
      // 11b: invokeinterface java/util/List.size ()I 1
      // 120: iload 3
      // 121: if_icmpge 162
      // 124: goto 128
      // 127: athrow
      // 128: aload 0
      // 129: goto 12d
      // 12c: athrow
      // 12d: invokevirtual x/ocdb10538f60.Ƽ ()Lnet/minecraft/util/Vec3;
      // 130: astore 6
      // 132: iload 1
      // 133: ifne 15e
      // 136: aload 6
      // 138: ifnull 15b
      // 13b: goto 13f
      // 13e: athrow
      // 13f: aload 0
      // 140: getfield x/ocdb10538f60.Ū Ljava/util/List;
      // 143: new x/oc8fe127ea3b
      // 146: dup
      // 147: aload 0
      // 148: aload 6
      // 14a: aload 0
      // 14b: invokevirtual x/ocdb10538f60.Ų ()Z
      // 14e: invokespecial x/oc8fe127ea3b.<init> (Lx/ocdb10538f60;Lnet/minecraft/util/Vec3;Z)V
      // 151: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 156: pop
      // 157: goto 15b
      // 15a: athrow
      // 15b: iinc 5 1
      // 15e: iload 1
      // 15f: ifeq 10c
      // 162: return
   }

   private Vec3 Ƽ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 06: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 09: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionVector ()Lnet/minecraft/util/Vec3;
      // 0c: astore 2
      // 0d: istore 1
      // 0e: bipush 0
      // 0f: istore 3
      // 10: iload 3
      // 11: ldc_w -638565657
      // 14: ldc_w -638565653
      // 17: ixor
      // 18: if_icmpge bd
      // 1b: aload 0
      // 1c: getfield x/ocdb10538f60.Ɏ Ljava/util/Random;
      // 1f: invokevirtual java/util/Random.nextDouble ()D
      // 22: ldc2_w 3.141592653589793
      // 25: dmul
      // 26: ldc2_w 2.0
      // 29: dmul
      // 2a: dstore 4
      // 2c: aload 0
      // 2d: invokevirtual x/ocdb10538f60.Ų ()Z
      // 30: ifeq 46
      // 33: ldc2_w 2.0
      // 36: aload 0
      // 37: getfield x/ocdb10538f60.Ɏ Ljava/util/Random;
      // 3a: invokevirtual java/util/Random.nextDouble ()D
      // 3d: ldc2_w 12.0
      // 40: dmul
      // 41: dadd
      // 42: goto 58
      // 45: athrow
      // 46: ldc2_w 2.0
      // 49: aload 0
      // 4a: getfield x/ocdb10538f60.Ɏ Ljava/util/Random;
      // 4d: invokevirtual java/util/Random.nextDouble ()D
      // 50: invokestatic java/lang/Math.sqrt (D)D
      // 53: ldc2_w 8.0
      // 56: dmul
      // 57: dadd
      // 58: dstore 6
      // 5a: aload 2
      // 5b: dload 4
      // 5d: invokestatic java/lang/Math.cos (D)D
      // 60: dload 6
      // 62: iload 1
      // 63: ifne 88
      // 66: dmul
      // 67: aload 0
      // 68: invokevirtual x/ocdb10538f60.Ų ()Z
      // 6b: ifeq 85
      // 6e: goto 72
      // 71: athrow
      // 72: ldc2_w -1.0
      // 75: aload 0
      // 76: getfield x/ocdb10538f60.Ɏ Ljava/util/Random;
      // 79: invokevirtual java/util/Random.nextDouble ()D
      // 7c: ldc2_w 6.0
      // 7f: dmul
      // 80: dadd
      // 81: goto 94
      // 84: athrow
      // 85: ldc2_w 0.5
      // 88: aload 0
      // 89: getfield x/ocdb10538f60.Ɏ Ljava/util/Random;
      // 8c: invokevirtual java/util/Random.nextDouble ()D
      // 8f: ldc2_w 3.5
      // 92: dmul
      // 93: dadd
      // 94: dload 4
      // 96: invokestatic java/lang/Math.sin (D)D
      // 99: dload 6
      // 9b: dmul
      // 9c: invokevirtual net/minecraft/util/Vec3.addVector (DDD)Lnet/minecraft/util/Vec3;
      // 9f: astore 8
      // a1: iload 1
      // a2: ifne b9
      // a5: aload 0
      // a6: aload 8
      // a8: invokevirtual x/ocdb10538f60.Δ (Lnet/minecraft/util/Vec3;)Z
      // ab: ifeq b6
      // ae: goto b2
      // b1: athrow
      // b2: aload 8
      // b4: areturn
      // b5: athrow
      // b6: iinc 3 1
      // b9: iload 1
      // ba: ifeq 10
      // bd: aconst_null
      // be: areturn
   }

   private boolean Δ(Vec3 var1) {
      return oc69da1aa7f5.ő
         .theWorld
         .getCollisionBoxes(
            new AxisAlignedBB(var1.xCoord - 0.06, var1.yCoord - 0.06, var1.zCoord - 0.06, var1.xCoord + 0.06, var1.yCoord + 0.06, var1.zCoord + 0.06)
         )
         .isEmpty();
   }

   @oc66fa4f2195
   public void γ(oc746a23b244 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: istore 2
      // 004: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 007: iload 2
      // 008: ifne 027
      // 00b: ifeq 031
      // 00e: goto 012
      // 011: athrow
      // 012: aload 0
      // 013: iload 2
      // 014: ifne 02b
      // 017: goto 01b
      // 01a: athrow
      // 01b: getfield x/ocdb10538f60.Ū Ljava/util/List;
      // 01e: invokeinterface java/util/List.isEmpty ()Z 1
      // 023: goto 027
      // 026: athrow
      // 027: ifne 031
      // 02a: aload 0
      // 02b: getfield x/ocdb10538f60.ʧ Lnet/minecraft/util/ResourceLocation;
      // 02e: ifnonnull 033
      // 031: return
      // 032: athrow
      // 033: ldc_w -114343696
      // 036: ldc_w -114310128
      // 039: ixor
      // 03a: invokestatic org/lwjgl/opengl/GL11.glGetInteger (I)I
      // 03d: istore 3
      // 03e: getstatic net/minecraft/client/renderer/OpenGlHelper.lightmapTexUnit I
      // 041: invokestatic net/minecraft/client/renderer/GlStateManager.setActiveTexture (I)V
      // 044: ldc_w -114308623
      // 047: ldc_w -114310128
      // 04a: ixor
      // 04b: invokestatic org/lwjgl/opengl/GL11.glIsEnabled (I)Z
      // 04e: istore 4
      // 050: getstatic net/minecraft/client/renderer/OpenGlHelper.defaultTexUnit I
      // 053: invokestatic net/minecraft/client/renderer/GlStateManager.setActiveTexture (I)V
      // 056: ldc_w -114342791
      // 059: ldc_w -114310128
      // 05c: ixor
      // 05d: invokestatic org/lwjgl/opengl/GL11.glGetInteger (I)I
      // 060: istore 5
      // 062: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 065: getfield net/minecraft/client/Minecraft.entityRenderer Lnet/minecraft/client/renderer/EntityRenderer;
      // 068: invokevirtual net/minecraft/client/renderer/EntityRenderer.disableLightmap ()V
      // 06b: ldc_w -114318063
      // 06e: ldc_w -114310128
      // 071: ixor
      // 072: invokestatic org/lwjgl/opengl/GL11.glPushAttrib (I)V
      // 075: ldc_w -114307086
      // 078: ldc_w -114310128
      // 07b: ixor
      // 07c: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 07f: ldc_w -114308623
      // 082: ldc_w -114310128
      // 085: ixor
      // 086: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 089: ldc_w -114307231
      // 08c: ldc_w -114310128
      // 08f: ixor
      // 090: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 093: ldc_w -114307264
      // 096: ldc_w -114310128
      // 099: ixor
      // 09a: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 09d: ldc_w -114307120
      // 0a0: ldc_w -114310128
      // 0a3: ixor
      // 0a4: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 0a7: ldc_w -114307244
      // 0aa: ldc_w -114310128
      // 0ad: ixor
      // 0ae: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 0b1: bipush 0
      // 0b2: invokestatic org/lwjgl/opengl/GL11.glDepthMask (Z)V
      // 0b5: fconst_1
      // 0b6: fconst_1
      // 0b7: fconst_1
      // 0b8: fconst_1
      // 0b9: invokestatic org/lwjgl/opengl/GL11.glColor4f (FFFF)V
      // 0bc: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0bf: invokevirtual net/minecraft/client/Minecraft.getTextureManager ()Lnet/minecraft/client/renderer/texture/TextureManager;
      // 0c2: aload 0
      // 0c3: getfield x/ocdb10538f60.ʧ Lnet/minecraft/util/ResourceLocation;
      // 0c6: invokevirtual net/minecraft/client/renderer/texture/TextureManager.bindTexture (Lnet/minecraft/util/ResourceLocation;)V
      // 0c9: new net/minecraft/util/Vec3
      // 0cc: dup
      // 0cd: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0d0: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 0d3: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosX D
      // 0d6: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0d9: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 0dc: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosY D
      // 0df: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0e2: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 0e5: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosZ D
      // 0e8: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 0eb: astore 6
      // 0ed: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0f0: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 0f3: getfield net/minecraft/client/renderer/entity/RenderManager.playerViewY F
      // 0f6: f2d
      // 0f7: invokestatic java/lang/Math.toRadians (D)D
      // 0fa: dstore 7
      // 0fc: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0ff: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 102: getfield net/minecraft/client/renderer/entity/RenderManager.playerViewX F
      // 105: f2d
      // 106: invokestatic java/lang/Math.toRadians (D)D
      // 109: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 10c: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 10f: getfield net/minecraft/client/settings/GameSettings.thirdPersonView I
      // 112: ldc_w -114310126
      // 115: ldc_w -114310128
      // 118: ixor
      // 119: if_icmpne 123
      // 11c: ldc2_w -1.0
      // 11f: goto 124
      // 122: athrow
      // 123: dconst_1
      // 124: dmul
      // 125: dstore 9
      // 127: iload 2
      // 128: new net/minecraft/util/Vec3
      // 12b: dup
      // 12c: dload 7
      // 12e: invokestatic java/lang/Math.cos (D)D
      // 131: dconst_0
      // 132: dload 7
      // 134: invokestatic java/lang/Math.sin (D)D
      // 137: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 13a: astore 11
      // 13c: new net/minecraft/util/Vec3
      // 13f: dup
      // 140: dload 7
      // 142: invokestatic java/lang/Math.sin (D)D
      // 145: dload 9
      // 147: invokestatic java/lang/Math.sin (D)D
      // 14a: dmul
      // 14b: dload 9
      // 14d: invokestatic java/lang/Math.cos (D)D
      // 150: dload 7
      // 152: invokestatic java/lang/Math.cos (D)D
      // 155: dneg
      // 156: dload 9
      // 158: invokestatic java/lang/Math.sin (D)D
      // 15b: dmul
      // 15c: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 15f: astore 12
      // 161: aload 0
      // 162: aload 1
      // 163: getfield x/oc746a23b244.Ё F
      // 166: aload 6
      // 168: aload 11
      // 16a: aload 12
      // 16c: invokevirtual x/ocdb10538f60.ț (FLnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)V
      // 16f: ifne 190
      // 172: invokestatic org/lwjgl/opengl/GL11.glPopAttrib ()V
      // 175: iload 5
      // 177: invokestatic net/minecraft/client/renderer/GlStateManager.bindTexture (I)V
      // 17a: iload 4
      // 17c: ifeq 18c
      // 17f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 182: getfield net/minecraft/client/Minecraft.entityRenderer Lnet/minecraft/client/renderer/EntityRenderer;
      // 185: invokevirtual net/minecraft/client/renderer/EntityRenderer.enableLightmap ()V
      // 188: goto 18c
      // 18b: athrow
      // 18c: iload 3
      // 18d: invokestatic net/minecraft/client/renderer/GlStateManager.setActiveTexture (I)V
      // 190: goto 1ba
      // 193: astore 13
      // 195: iload 2
      // 196: invokestatic org/lwjgl/opengl/GL11.glPopAttrib ()V
      // 199: ifne 1b7
      // 19c: iload 5
      // 19e: invokestatic net/minecraft/client/renderer/GlStateManager.bindTexture (I)V
      // 1a1: iload 4
      // 1a3: ifeq 1b3
      // 1a6: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1a9: getfield net/minecraft/client/Minecraft.entityRenderer Lnet/minecraft/client/renderer/EntityRenderer;
      // 1ac: invokevirtual net/minecraft/client/renderer/EntityRenderer.enableLightmap ()V
      // 1af: goto 1b3
      // 1b2: athrow
      // 1b3: iload 3
      // 1b4: invokestatic net/minecraft/client/renderer/GlStateManager.setActiveTexture (I)V
      // 1b7: aload 13
      // 1b9: athrow
      // 1ba: return
   }

   private void ț(float param1, Vec3 param2, Vec3 param3, Vec3 param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: invokestatic net/minecraft/client/renderer/Tessellator.getInstance ()Lnet/minecraft/client/renderer/Tessellator;
      // 003: astore 6
      // 005: getstatic x/oce6044968f8.ђ Z
      // 008: aload 6
      // 00a: invokevirtual net/minecraft/client/renderer/Tessellator.getWorldRenderer ()Lnet/minecraft/client/renderer/WorldRenderer;
      // 00d: astore 7
      // 00f: istore 5
      // 011: ldc_w 1387610107
      // 014: ldc_w 1387609337
      // 017: ixor
      // 018: aload 0
      // 019: getfield x/ocdb10538f60.Հ Lx/occ2f8dff8d8;
      // 01c: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 01f: iload 5
      // 021: ifne 032
      // 024: ifeq 035
      // 027: goto 02b
      // 02a: athrow
      // 02b: ldc_w 1387610106
      // 02e: ldc_w 1387609337
      // 031: ixor
      // 032: goto 036
      // 035: bipush 1
      // 036: bipush 1
      // 037: bipush 0
      // 038: invokestatic org/lwjgl/opengl/GL14.glBlendFuncSeparate (IIII)V
      // 03b: aload 7
      // 03d: ldc_w 1387609342
      // 040: ldc_w 1387609337
      // 043: ixor
      // 044: getstatic net/minecraft/client/renderer/vertex/DefaultVertexFormats.POSITION_TEX_COLOR Lnet/minecraft/client/renderer/vertex/VertexFormat;
      // 047: invokevirtual net/minecraft/client/renderer/WorldRenderer.begin (ILnet/minecraft/client/renderer/vertex/VertexFormat;)V
      // 04a: aload 0
      // 04b: getfield x/ocdb10538f60.Ū Ljava/util/List;
      // 04e: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 053: astore 8
      // 055: aload 8
      // 057: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 05c: ifeq 0e6
      // 05f: aload 8
      // 061: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 066: iload 5
      // 068: ifne 123
      // 06b: checkcast x/oc8fe127ea3b
      // 06e: astore 9
      // 070: iload 5
      // 072: aload 9
      // 074: fload 1
      // 075: aload 2
      // 076: invokevirtual x/oc8fe127ea3b.Ȼ (FLnet/minecraft/util/Vec3;)F
      // 079: fstore 10
      // 07b: aload 0
      // 07c: aload 9
      // 07e: getfield x/oc8fe127ea3b.ɲ D
      // 081: invokevirtual x/ocdb10538f60.П (D)I
      // 084: istore 11
      // 086: ifne 0c4
      // 089: aload 9
      // 08b: getfield x/oc8fe127ea3b.ʷ Z
      // 08e: ifeq 0c9
      // 091: goto 095
      // 094: athrow
      // 095: aload 0
      // 096: aload 7
      // 098: aload 9
      // 09a: aload 2
      // 09b: fload 1
      // 09c: iload 11
      // 09e: fload 10
      // 0a0: ldc2_w 0.42
      // 0a3: ldc_w 0.16
      // 0a6: invokevirtual x/ocdb10538f60.У (Lnet/minecraft/client/renderer/WorldRenderer;Lx/oc8fe127ea3b;Lnet/minecraft/util/Vec3;FIFDF)V
      // 0a9: aload 0
      // 0aa: aload 7
      // 0ac: aload 9
      // 0ae: aload 2
      // 0af: fload 1
      // 0b0: iload 11
      // 0b2: invokestatic x/ocdb10538f60.Ӓ (I)I
      // 0b5: fload 10
      // 0b7: ldc2_w 0.075
      // 0ba: ldc_w 0.65
      // 0bd: invokevirtual x/ocdb10538f60.У (Lnet/minecraft/client/renderer/WorldRenderer;Lx/oc8fe127ea3b;Lnet/minecraft/util/Vec3;FIFDF)V
      // 0c0: goto 0c4
      // 0c3: athrow
      // 0c4: iload 5
      // 0c6: ifeq 0e1
      // 0c9: aload 0
      // 0ca: aload 7
      // 0cc: aload 9
      // 0ce: aload 2
      // 0cf: fload 1
      // 0d0: iload 11
      // 0d2: fload 10
      // 0d4: ldc2_w 0.085
      // 0d7: ldc_w 0.35
      // 0da: invokevirtual x/ocdb10538f60.У (Lnet/minecraft/client/renderer/WorldRenderer;Lx/oc8fe127ea3b;Lnet/minecraft/util/Vec3;FIFDF)V
      // 0dd: goto 0e1
      // 0e0: athrow
      // 0e1: iload 5
      // 0e3: ifeq 055
      // 0e6: aload 6
      // 0e8: invokevirtual net/minecraft/client/renderer/Tessellator.draw ()V
      // 0eb: ldc_w 1387610107
      // 0ee: ldc_w 1387609337
      // 0f1: ixor
      // 0f2: bipush 1
      // 0f3: bipush 1
      // 0f4: bipush 0
      // 0f5: invokestatic org/lwjgl/opengl/GL14.glBlendFuncSeparate (IIII)V
      // 0f8: aload 7
      // 0fa: ldc_w 1387609342
      // 0fd: ldc_w 1387609337
      // 100: ixor
      // 101: getstatic net/minecraft/client/renderer/vertex/DefaultVertexFormats.POSITION_TEX_COLOR Lnet/minecraft/client/renderer/vertex/VertexFormat;
      // 104: invokevirtual net/minecraft/client/renderer/WorldRenderer.begin (ILnet/minecraft/client/renderer/vertex/VertexFormat;)V
      // 107: aload 0
      // 108: getfield x/ocdb10538f60.Ū Ljava/util/List;
      // 10b: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 110: astore 8
      // 112: aload 8
      // 114: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 119: ifeq 2dc
      // 11c: aload 8
      // 11e: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 123: checkcast x/oc8fe127ea3b
      // 126: astore 9
      // 128: iload 5
      // 12a: ifne 2e1
      // 12d: aload 9
      // 12f: getfield x/oc8fe127ea3b.Ғ Lnet/minecraft/util/Vec3;
      // 132: aload 9
      // 134: getfield x/oc8fe127ea3b.а Lnet/minecraft/util/Vec3;
      // 137: fload 1
      // 138: invokestatic x/ocdb10538f60.É (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;F)Lnet/minecraft/util/Vec3;
      // 13b: aload 2
      // 13c: invokevirtual net/minecraft/util/Vec3.subtract (Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/Vec3;
      // 13f: astore 10
      // 141: aload 9
      // 143: fload 1
      // 144: aload 2
      // 145: invokevirtual x/oc8fe127ea3b.Ȼ (FLnet/minecraft/util/Vec3;)F
      // 148: fstore 11
      // 14a: aload 0
      // 14b: aload 9
      // 14d: getfield x/oc8fe127ea3b.ɲ D
      // 150: invokevirtual x/ocdb10538f60.П (D)I
      // 153: istore 12
      // 155: aload 0
      // 156: getfield x/ocdb10538f60.Џ Lx/oca9cc61aada;
      // 159: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 15c: aload 9
      // 15e: getfield x/oc8fe127ea3b.ǭ D
      // 161: dmul
      // 162: dstore 13
      // 164: aload 9
      // 166: getfield x/oc8fe127ea3b.ʷ Z
      // 169: iload 5
      // 16b: ifne 19d
      // 16e: ifeq 192
      // 171: goto 175
      // 174: athrow
      // 175: aload 0
      // 176: aload 7
      // 178: aload 9
      // 17a: aload 10
      // 17c: aload 3
      // 17d: aload 4
      // 17f: dload 13
      // 181: iload 12
      // 183: fload 11
      // 185: fload 1
      // 186: invokevirtual x/ocdb10538f60.Ĩ (Lnet/minecraft/client/renderer/WorldRenderer;Lx/oc8fe127ea3b;Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;DIFF)V
      // 189: iload 5
      // 18b: ifeq 1f5
      // 18e: goto 192
      // 191: athrow
      // 192: aload 0
      // 193: getfield x/ocdb10538f60.ӟ Lx/occ2f8dff8d8;
      // 196: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 199: goto 19d
      // 19c: athrow
      // 19d: ifeq 1c2
      // 1a0: aload 7
      // 1a2: aload 10
      // 1a4: aload 3
      // 1a5: aload 4
      // 1a7: dload 13
      // 1a9: ldc2_w 3.2
      // 1ac: dmul
      // 1ad: dload 13
      // 1af: ldc2_w 3.2
      // 1b2: dmul
      // 1b3: iload 12
      // 1b5: fload 11
      // 1b7: ldc_w 0.12
      // 1ba: fmul
      // 1bb: invokestatic x/ocdb10538f60.Ȟ (Lnet/minecraft/client/renderer/WorldRenderer;Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;DDIF)V
      // 1be: goto 1c2
      // 1c1: athrow
      // 1c2: aload 7
      // 1c4: aload 10
      // 1c6: aload 3
      // 1c7: aload 4
      // 1c9: dload 13
      // 1cb: dload 13
      // 1cd: iload 12
      // 1cf: fload 11
      // 1d1: ldc_w 0.7
      // 1d4: fmul
      // 1d5: invokestatic x/ocdb10538f60.Ȟ (Lnet/minecraft/client/renderer/WorldRenderer;Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;DDIF)V
      // 1d8: aload 7
      // 1da: aload 10
      // 1dc: aload 3
      // 1dd: aload 4
      // 1df: dload 13
      // 1e1: ldc2_w 0.27
      // 1e4: dmul
      // 1e5: dload 13
      // 1e7: ldc2_w 0.36
      // 1ea: dmul
      // 1eb: iload 12
      // 1ed: invokestatic x/ocdb10538f60.Ӓ (I)I
      // 1f0: fload 11
      // 1f2: invokestatic x/ocdb10538f60.Ȟ (Lnet/minecraft/client/renderer/WorldRenderer;Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;DDIF)V
      // 1f5: aload 9
      // 1f7: getfield x/oc8fe127ea3b.ӯ Ljava/util/List;
      // 1fa: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 1ff: astore 15
      // 201: aload 15
      // 203: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 208: ifeq 2d7
      // 20b: aload 15
      // 20d: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 212: checkcast x/oc66f33bb961
      // 215: astore 16
      // 217: aload 16
      // 219: getfield x/oc66f33bb961.ʡ I
      // 21c: iload 5
      // 21e: ifne 119
      // 221: i2f
      // 222: fload 1
      // 223: fadd
      // 224: fstore 17
      // 226: fconst_1
      // 227: fload 17
      // 229: aload 16
      // 22b: getfield x/oc66f33bb961.ƴ I
      // 22e: i2f
      // 22f: fdiv
      // 230: fsub
      // 231: fstore 18
      // 233: fload 18
      // 235: fconst_0
      // 236: fcmpl
      // 237: ifle 2d2
      // 23a: aload 16
      // 23c: getfield x/oc66f33bb961.Ԓ Lnet/minecraft/util/Vec3;
      // 23f: aload 16
      // 241: getfield x/oc66f33bb961.ͻ Lnet/minecraft/util/Vec3;
      // 244: fload 1
      // 245: invokestatic x/ocdb10538f60.É (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;F)Lnet/minecraft/util/Vec3;
      // 248: aload 2
      // 249: invokevirtual net/minecraft/util/Vec3.subtract (Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/Vec3;
      // 24c: astore 19
      // 24e: iload 5
      // 250: fload 11
      // 252: fload 18
      // 254: fmul
      // 255: fload 18
      // 257: fmul
      // 258: ldc_w 0.45
      // 25b: fmul
      // 25c: fstore 20
      // 25e: ifne 27b
      // 261: aload 9
      // 263: getfield x/oc8fe127ea3b.ʷ Z
      // 266: ifeq 299
      // 269: goto 26d
      // 26c: athrow
      // 26d: fload 20
      // 26f: fload 17
      // 271: ldc_w 3.0
      // 274: fdiv
      // 275: invokestatic x/ocdb10538f60.ä (F)F
      // 278: fmul
      // 279: fstore 20
      // 27b: aload 7
      // 27d: aload 19
      // 27f: aload 3
      // 280: aload 4
      // 282: dload 13
      // 284: ldc2_w 0.5
      // 287: dmul
      // 288: dload 13
      // 28a: ldc2_w 0.5
      // 28d: dmul
      // 28e: iload 12
      // 290: fload 20
      // 292: ldc_w 0.12
      // 295: fmul
      // 296: invokestatic x/ocdb10538f60.Ȟ (Lnet/minecraft/client/renderer/WorldRenderer;Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;DDIF)V
      // 299: dload 13
      // 29b: aload 16
      // 29d: getfield x/oc66f33bb961.ʚ D
      // 2a0: dmul
      // 2a1: dstore 21
      // 2a3: aload 7
      // 2a5: aload 19
      // 2a7: aload 3
      // 2a8: aload 4
      // 2aa: dload 21
      // 2ac: dload 21
      // 2ae: aload 9
      // 2b0: getfield x/oc8fe127ea3b.ʷ Z
      // 2b3: iload 5
      // 2b5: ifne 2c8
      // 2b8: ifeq 2cb
      // 2bb: goto 2bf
      // 2be: athrow
      // 2bf: iload 12
      // 2c1: invokestatic x/ocdb10538f60.Ӓ (I)I
      // 2c4: goto 2c8
      // 2c7: athrow
      // 2c8: goto 2cd
      // 2cb: iload 12
      // 2cd: fload 20
      // 2cf: invokestatic x/ocdb10538f60.Ȟ (Lnet/minecraft/client/renderer/WorldRenderer;Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;DDIF)V
      // 2d2: iload 5
      // 2d4: ifeq 201
      // 2d7: iload 5
      // 2d9: ifeq 112
      // 2dc: aload 6
      // 2de: invokevirtual net/minecraft/client/renderer/Tessellator.draw ()V
      // 2e1: return
   }

   private void Ĩ(WorldRenderer var1, oc8fe127ea3b var2, Vec3 var3, Vec3 var4, Vec3 var5, double var6, int var8, float var9, float var10) {
      double var16;
      WorldRenderer var23;
      Vec3 var10001;
      Vec3 var10002;
      Vec3 var10003;
      double var10004;
      label19: {
         boolean var10000 = oce6044968f8.ђ;
         float var12 = (float)var3.lengthVector();
         float var13 = ä(Math.abs(var12 - 7.0F) / 8.0F);
         boolean var11 = var10000;
         double var14 = 1.0 + Math.sin((var2.ƛ + var10) * 0.035 + var2.ɲ) * 0.08;
         double var22 = var6;
         if (!var11) {
            var6 *= var14;
            if (this.ӟ.ǭ()) {
               var16 = var6 * (4.5 + var13 * 2.0);
               Ȟ(var1, var3, var4, var5, var16, var16, var8, var9 * 0.07F);
               var23 = var1;
               var10001 = var3;
               var10002 = var4;
               var10003 = var5;
               var10004 = var6 * 2.2;
               if (var11) {
                  break label19;
               }

               Ȟ(var1, var3, var4, var5, var10004, var6 * 2.2, var8, var9 * 0.16F);
               float var18 = var9 * (1.0F - var13) * 0.11F;
               Ȟ(var1, var3, var4, var5, var6 * 7.0, var6 * 0.18, var8, var18);
               Ȟ(var1, var3, var4, var5, var6 * 0.14, var6 * 2.0, var8, var18 * 0.3F);
               if (var13 > 0.01F) {
                  double var19 = var6 * (1.8 + var13 * 2.8);
                  ε(var1, var3, var4, var5, var19, var19, var8, var9 * var13 * 0.22F, 0.5, 1.0);
               }
            }

            Ȟ(var1, var3, var4, var5, var6 * (1.0 + var13), var6 * (1.0 + var13), var8, var9 * (0.75F - var13 * 0.25F));
            var22 = var6 * (0.2 + var13 * 0.12);
         }

         var16 = var22;
         var23 = var1;
         var10001 = var3;
         var10002 = var4;
         var10003 = var5;
         var10004 = var16;
      }

      Ȟ(var23, var10001, var10002, var10003, var10004, var16, Ӓ(var8), var9 * 0.9F);
   }

   private void У(WorldRenderer param1, oc8fe127ea3b param2, Vec3 param3, float param4, int param5, float param6, double param7, float param9) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: istore 10
      // 005: aload 2
      // 006: getfield x/oc8fe127ea3b.Ĩ Ljava/util/Deque;
      // 009: invokeinterface java/util/Deque.size ()I 1
      // 00e: iload 10
      // 010: ifne 02e
      // 013: ldc_w -1302440842
      // 016: ldc_w -1302440844
      // 019: ixor
      // 01a: if_icmplt 031
      // 01d: goto 021
      // 020: athrow
      // 021: aload 0
      // 022: getfield x/ocdb10538f60.ղ Lx/oca9cc61aada;
      // 025: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 028: dconst_0
      // 029: dcmpg
      // 02a: goto 02e
      // 02d: athrow
      // 02e: ifgt 032
      // 031: return
      // 032: aconst_null
      // 033: astore 11
      // 035: aload 0
      // 036: getfield x/ocdb10538f60.ղ Lx/oca9cc61aada;
      // 039: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 03c: ldc2_w 50.0
      // 03f: iload 10
      // 041: ifne 057
      // 044: ddiv
      // 045: aload 2
      // 046: getfield x/oc8fe127ea3b.ʷ Z
      // 049: ifeq 05a
      // 04c: goto 050
      // 04f: athrow
      // 050: ldc2_w 1.8
      // 053: goto 057
      // 056: athrow
      // 057: goto 05b
      // 05a: dconst_1
      // 05b: dmul
      // 05c: dstore 12
      // 05e: aload 0
      // 05f: getfield x/ocdb10538f60.Џ Lx/oca9cc61aada;
      // 062: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 065: aload 2
      // 066: getfield x/oc8fe127ea3b.ǭ D
      // 069: dmul
      // 06a: dload 7
      // 06c: dmul
      // 06d: dstore 14
      // 06f: aload 2
      // 070: getfield x/oc8fe127ea3b.Ĩ Ljava/util/Deque;
      // 073: invokeinterface java/util/Deque.iterator ()Ljava/util/Iterator; 1
      // 078: astore 16
      // 07a: aload 16
      // 07c: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 081: ifeq 22c
      // 084: aload 16
      // 086: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 08b: checkcast x/oc9f8d7423cd
      // 08e: astore 17
      // 090: iload 10
      // 092: ifne 227
      // 095: aload 11
      // 097: ifnull 223
      // 09a: goto 09e
      // 09d: athrow
      // 09e: aload 11
      // 0a0: getfield x/oc9f8d7423cd.ά Lnet/minecraft/util/Vec3;
      // 0a3: aload 3
      // 0a4: invokevirtual net/minecraft/util/Vec3.subtract (Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/Vec3;
      // 0a7: astore 18
      // 0a9: aload 17
      // 0ab: iload 10
      // 0ad: ifne 0d1
      // 0b0: getfield x/oc9f8d7423cd.ĥ I
      // 0b3: aload 2
      // 0b4: getfield x/oc8fe127ea3b.ƛ I
      // 0b7: if_icmpne 0cf
      // 0ba: goto 0be
      // 0bd: athrow
      // 0be: aload 2
      // 0bf: getfield x/oc8fe127ea3b.Ғ Lnet/minecraft/util/Vec3;
      // 0c2: aload 2
      // 0c3: getfield x/oc8fe127ea3b.а Lnet/minecraft/util/Vec3;
      // 0c6: fload 4
      // 0c8: invokestatic x/ocdb10538f60.É (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;F)Lnet/minecraft/util/Vec3;
      // 0cb: goto 0d4
      // 0ce: athrow
      // 0cf: aload 17
      // 0d1: getfield x/oc9f8d7423cd.ά Lnet/minecraft/util/Vec3;
      // 0d4: aload 3
      // 0d5: invokevirtual net/minecraft/util/Vec3.subtract (Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/Vec3;
      // 0d8: astore 19
      // 0da: aload 19
      // 0dc: aload 18
      // 0de: invokevirtual net/minecraft/util/Vec3.subtract (Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/Vec3;
      // 0e1: aload 18
      // 0e3: invokevirtual net/minecraft/util/Vec3.crossProduct (Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/Vec3;
      // 0e6: invokevirtual net/minecraft/util/Vec3.normalize ()Lnet/minecraft/util/Vec3;
      // 0e9: astore 20
      // 0eb: dconst_1
      // 0ec: aload 2
      // 0ed: getfield x/oc8fe127ea3b.ƛ I
      // 0f0: i2f
      // 0f1: fload 4
      // 0f3: fadd
      // 0f4: aload 11
      // 0f6: getfield x/oc9f8d7423cd.ĥ I
      // 0f9: i2f
      // 0fa: fsub
      // 0fb: f2d
      // 0fc: dload 12
      // 0fe: ddiv
      // 0ff: dsub
      // 100: d2f
      // 101: fconst_0
      // 102: fconst_1
      // 103: invokestatic net/minecraft/util/MathHelper.clamp_float (FFF)F
      // 106: fstore 21
      // 108: dconst_1
      // 109: aload 2
      // 10a: getfield x/oc8fe127ea3b.ƛ I
      // 10d: i2f
      // 10e: fload 4
      // 110: fadd
      // 111: aload 17
      // 113: getfield x/oc9f8d7423cd.ĥ I
      // 116: i2f
      // 117: fsub
      // 118: f2d
      // 119: dload 12
      // 11b: ddiv
      // 11c: dsub
      // 11d: d2f
      // 11e: fconst_0
      // 11f: fconst_1
      // 120: invokestatic net/minecraft/util/MathHelper.clamp_float (FFF)F
      // 123: fstore 22
      // 125: aload 1
      // 126: aload 18
      // 128: aload 20
      // 12a: getfield net/minecraft/util/Vec3.xCoord D
      // 12d: dload 14
      // 12f: dmul
      // 130: fload 21
      // 132: f2d
      // 133: dmul
      // 134: aload 20
      // 136: getfield net/minecraft/util/Vec3.yCoord D
      // 139: dload 14
      // 13b: dmul
      // 13c: fload 21
      // 13e: f2d
      // 13f: dmul
      // 140: aload 20
      // 142: getfield net/minecraft/util/Vec3.zCoord D
      // 145: dload 14
      // 147: dmul
      // 148: fload 21
      // 14a: f2d
      // 14b: dmul
      // 14c: invokevirtual net/minecraft/util/Vec3.addVector (DDD)Lnet/minecraft/util/Vec3;
      // 14f: ldc2_w 0.25
      // 152: dconst_0
      // 153: iload 5
      // 155: fload 6
      // 157: fload 21
      // 159: fmul
      // 15a: fload 21
      // 15c: fmul
      // 15d: fload 9
      // 15f: fmul
      // 160: invokestatic x/ocdb10538f60.Л (Lnet/minecraft/client/renderer/WorldRenderer;Lnet/minecraft/util/Vec3;DDIF)V
      // 163: aload 1
      // 164: aload 18
      // 166: aload 20
      // 168: getfield net/minecraft/util/Vec3.xCoord D
      // 16b: dneg
      // 16c: dload 14
      // 16e: dmul
      // 16f: fload 21
      // 171: f2d
      // 172: dmul
      // 173: aload 20
      // 175: getfield net/minecraft/util/Vec3.yCoord D
      // 178: dneg
      // 179: dload 14
      // 17b: dmul
      // 17c: fload 21
      // 17e: f2d
      // 17f: dmul
      // 180: aload 20
      // 182: getfield net/minecraft/util/Vec3.zCoord D
      // 185: dneg
      // 186: dload 14
      // 188: dmul
      // 189: fload 21
      // 18b: f2d
      // 18c: dmul
      // 18d: invokevirtual net/minecraft/util/Vec3.addVector (DDD)Lnet/minecraft/util/Vec3;
      // 190: ldc2_w 0.25
      // 193: dconst_1
      // 194: iload 5
      // 196: fload 6
      // 198: fload 21
      // 19a: fmul
      // 19b: fload 21
      // 19d: fmul
      // 19e: fload 9
      // 1a0: fmul
      // 1a1: invokestatic x/ocdb10538f60.Л (Lnet/minecraft/client/renderer/WorldRenderer;Lnet/minecraft/util/Vec3;DDIF)V
      // 1a4: aload 1
      // 1a5: aload 19
      // 1a7: aload 20
      // 1a9: getfield net/minecraft/util/Vec3.xCoord D
      // 1ac: dneg
      // 1ad: dload 14
      // 1af: dmul
      // 1b0: fload 22
      // 1b2: f2d
      // 1b3: dmul
      // 1b4: aload 20
      // 1b6: getfield net/minecraft/util/Vec3.yCoord D
      // 1b9: dneg
      // 1ba: dload 14
      // 1bc: dmul
      // 1bd: fload 22
      // 1bf: f2d
      // 1c0: dmul
      // 1c1: aload 20
      // 1c3: getfield net/minecraft/util/Vec3.zCoord D
      // 1c6: dneg
      // 1c7: dload 14
      // 1c9: dmul
      // 1ca: fload 22
      // 1cc: f2d
      // 1cd: dmul
      // 1ce: invokevirtual net/minecraft/util/Vec3.addVector (DDD)Lnet/minecraft/util/Vec3;
      // 1d1: ldc2_w 0.25
      // 1d4: dconst_1
      // 1d5: iload 5
      // 1d7: fload 6
      // 1d9: fload 22
      // 1db: fmul
      // 1dc: fload 22
      // 1de: fmul
      // 1df: fload 9
      // 1e1: fmul
      // 1e2: invokestatic x/ocdb10538f60.Л (Lnet/minecraft/client/renderer/WorldRenderer;Lnet/minecraft/util/Vec3;DDIF)V
      // 1e5: aload 1
      // 1e6: aload 19
      // 1e8: aload 20
      // 1ea: getfield net/minecraft/util/Vec3.xCoord D
      // 1ed: dload 14
      // 1ef: dmul
      // 1f0: fload 22
      // 1f2: f2d
      // 1f3: dmul
      // 1f4: aload 20
      // 1f6: getfield net/minecraft/util/Vec3.yCoord D
      // 1f9: dload 14
      // 1fb: dmul
      // 1fc: fload 22
      // 1fe: f2d
      // 1ff: dmul
      // 200: aload 20
      // 202: getfield net/minecraft/util/Vec3.zCoord D
      // 205: dload 14
      // 207: dmul
      // 208: fload 22
      // 20a: f2d
      // 20b: dmul
      // 20c: invokevirtual net/minecraft/util/Vec3.addVector (DDD)Lnet/minecraft/util/Vec3;
      // 20f: ldc2_w 0.25
      // 212: dconst_0
      // 213: iload 5
      // 215: fload 6
      // 217: fload 22
      // 219: fmul
      // 21a: fload 22
      // 21c: fmul
      // 21d: fload 9
      // 21f: fmul
      // 220: invokestatic x/ocdb10538f60.Л (Lnet/minecraft/client/renderer/WorldRenderer;Lnet/minecraft/util/Vec3;DDIF)V
      // 223: aload 17
      // 225: astore 11
      // 227: iload 10
      // 229: ifeq 07a
      // 22c: return
   }

   private static void Ȟ(WorldRenderer var0, Vec3 var1, Vec3 var2, Vec3 var3, double var4, double var6, int var8, float var9) {
      ε(var0, var1, var2, var3, var4, var6, var8, var9, 0.0, 0.5);
   }

   private static void ε(WorldRenderer var0, Vec3 var1, Vec3 var2, Vec3 var3, double var4, double var6, int var8, float var9, double var10, double var12) {
      Л(var0, ե(var1, var2, var3, -var4, -var6), var10, 1.0, var8, var9);
      Л(var0, ե(var1, var2, var3, -var4, var6), var10, 0.0, var8, var9);
      Л(var0, ե(var1, var2, var3, var4, var6), var12, 0.0, var8, var9);
      Л(var0, ե(var1, var2, var3, var4, -var6), var12, 1.0, var8, var9);
   }

   private static Vec3 ե(Vec3 var0, Vec3 var1, Vec3 var2, double var3, double var5) {
      return var0.addVector(var1.xCoord * var3 + var2.xCoord * var5, var1.yCoord * var3 + var2.yCoord * var5, var1.zCoord * var3 + var2.zCoord * var5);
   }

   private static void Л(WorldRenderer var0, Vec3 var1, double var2, double var4, int var6, float var7) {
      int var8 = (int)(MathHelper.clamp_float(var7, 0.0F, 1.0F) * (var6 >>> (-1464415166 ^ -1464415142)));
      var0.pos(var1.xCoord, var1.yCoord, var1.zCoord)
         .tex(var2, var4)
         .color(
            var6 >> (-1464415158 ^ -1464415142) & (-1464415067 ^ -1464415142),
            var6 >> (-1464415150 ^ -1464415142) & (-1464415067 ^ -1464415142),
            var6 & (-1464415067 ^ -1464415142),
            var8
         )
         .endVertex();
   }

   private static int Ӓ(int var0) {
      int var1 = Math.round((var0 >> (-1123218552 ^ -1123218536) & (-1123218585 ^ -1123218536)) * 0.82F + 45.9F);
      int var2 = Math.round((var0 >> (-1123218544 ^ -1123218536) & (-1123218585 ^ -1123218536)) * 0.82F + 45.9F);
      int var3 = Math.round((var0 & (-1123218585 ^ -1123218536)) * 0.82F + 45.9F);
      return var0 & (1108151192 ^ -1123218536) | var1 << (-1123218552 ^ -1123218536) | var2 << (-1123218544 ^ -1123218536) | var3;
   }

   static Vec3 É(Vec3 var0, Vec3 var1, float var2) {
      return var0.addVector((var1.xCoord - var0.xCoord) * var2, (var1.yCoord - var0.yCoord) * var2, (var1.zCoord - var0.zCoord) * var2);
   }

   static float с(float var0, int var1) {
      return ä(var0 / 12.0F) * ä((var1 - var0) / 30.0F);
   }

   private static float ä(float var0) {
      float var1 = MathHelper.clamp_float(var0, 0.0F, 1.0F);
      return var1 * var1 * (3.0F - 2.0F * var1);
   }

   static BufferedImage Ұ() {
      int var10000 = oce6044968f8.ђ;
      BufferedImage var1 = new BufferedImage(199827364 ^ 199827428, 199827364 ^ 199827428, 199827430 ^ 199827428);
      boolean var0 = (boolean)var10000;
      int var2 = 0;

      label29:
      while (true) {
         var10000 = var2;

         label27:
         while (var10000 < var1.getHeight()) {
            int var3 = 0;

            while (var3 < var1.getWidth()) {
               double var4 = (var3 + 0.5) / 32.0 - 1.0;
               double var6 = (var2 + 0.5) / 32.0 - 1.0;
               double var8 = var4 * var4 + var6 * var6;
               double var10 = (0.8 * Math.exp(-8.0 * var8) + 0.2 * Math.exp(-40.0 * var8)) * Math.max(0.0, 1.0 - var8);
               var10000 = (int)Math.round(var10 * 255.0);
               if (var0) {
                  continue label27;
               }

               int var12 = var10000;
               var1.setRGB(var3, var2, var12 << (199827452 ^ 199827428) | 186048539 ^ 199827428);
               var3++;
               if (var0) {
                  break;
               }
            }

            var2++;
            if (var0) {
               return var1;
            }
            continue label29;
         }

         return var1;
      }
   }

   static BufferedImage ԡ() {
      BufferedImage var1 = Ұ();
      boolean var10000 = oce6044968f8.ђ;
      BufferedImage var2 = new BufferedImage(252813132 ^ 252813260, 252813196 ^ 252813260, 252813262 ^ 252813260);
      boolean var0 = var10000;
      int var3 = 0;

      while (var3 < (252813196 ^ 252813260)) {
         int var4 = 0;

         while (true) {
            if (var4 < (252813196 ^ 252813260)) {
               var2.setRGB(var4, var3, var1.getRGB(var4, var3));
               double var5 = (var4 + 0.5) / 32.0 - 1.0;
               if (var0) {
                  break;
               }

               double var7 = (var3 + 0.5) / 32.0 - 1.0;
               double var9 = Math.sqrt(var5 * var5 + var7 * var7);
               double var11 = Math.exp(-Math.pow((var9 - 0.62) / 0.14, 2.0));
               double var13 = (0.18 * Math.exp(-var9 * var9 * 2.5) + 0.42 * var11) * ä((float)((1.0 - var9) / 0.22));
               var2.setRGB(var4 + (252813196 ^ 252813260), var3, (int)Math.round(var13 * 255.0) << (252813268 ^ 252813260) | 267280435 ^ 252813260);
               var4++;
               if (!var0) {
                  continue;
               }
            }

            var3++;
            break;
         }

         if (var0) {
            break;
         }
      }

      return var2;
   }

   static {
      String[] var10000 = new String[492372961 ^ 492372963];
      var10000[0] = "Fireflies";
      var10000[1] = "Cinematic";
      ʨ = var10000;
      var10000 = new String[492372961 ^ 492372963];
      var10000[0] = "Default";
      var10000[1] = "HUD";
      Ĺ = var10000;
   }
}

package x;

import net.minecraft.util.BlockPos;

public class oc588e87ff01 extends oc69da1aa7f5 {
   private oca9cc61aada ƚ;
   private occ2f8dff8d8 Ԧ;
   private occ2f8dff8d8 Ŧ;
   private occ2f8dff8d8 Մ;
   private String[] Ǝ;
   private float յ;
   private BlockPos Ϫ;
   private String Ō;
   public static boolean Ǳ;

   public oc588e87ff01() {
      super("BreakProgress", oce4cea752dd.Ŏ);
      String[] var10001 = new String[1362254944 ^ 1362254947];
      var10001[0] = "Percentage";
      var10001[1] = "Second";
      var10001[1362254945 ^ 1362254947] = "Decimal";
      this.Ǝ = var10001;
      this.ą("Shows progress for block breaking.");
      this.ʌ(this.ƚ = new oca9cc61aada("Mode", 0, this.Ǝ));
      this.ʌ(this.Ԧ = new occ2f8dff8d8("Show manual", true));
      this.ʌ(this.Ŧ = new occ2f8dff8d8("Show BedAura", true));
      this.ʌ(this.Մ = new occ2f8dff8d8("Fade in", false));
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGHEST
   )
   public void Ǎ(oc746a23b244 param1) {
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
      // 005: iload 2
      // 006: ifne 01a
      // 009: getfield x/oc588e87ff01.յ F
      // 00c: fconst_0
      // 00d: fcmpl
      // 00e: ifeq 032
      // 011: goto 015
      // 014: athrow
      // 015: aload 0
      // 016: goto 01a
      // 019: athrow
      // 01a: getfield x/oc588e87ff01.Ϫ Lnet/minecraft/util/BlockPos;
      // 01d: ifnull 032
      // 020: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 023: iload 2
      // 024: ifne 03a
      // 027: goto 02b
      // 02a: athrow
      // 02b: ifne 033
      // 02e: goto 032
      // 031: athrow
      // 032: return
      // 033: aload 0
      // 034: getfield x/oc588e87ff01.Ϫ Lnet/minecraft/util/BlockPos;
      // 037: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 03a: i2d
      // 03b: ldc2_w 0.5
      // 03e: dadd
      // 03f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 042: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 045: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosX D
      // 048: dsub
      // 049: dstore 3
      // 04a: aload 0
      // 04b: getfield x/oc588e87ff01.Ϫ Lnet/minecraft/util/BlockPos;
      // 04e: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 051: i2d
      // 052: ldc2_w 0.5
      // 055: dadd
      // 056: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 059: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 05c: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosY D
      // 05f: dsub
      // 060: dstore 5
      // 062: aload 0
      // 063: getfield x/oc588e87ff01.Ϫ Lnet/minecraft/util/BlockPos;
      // 066: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 069: i2d
      // 06a: ldc2_w 0.5
      // 06d: dadd
      // 06e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 071: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 074: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosZ D
      // 077: dsub
      // 078: dstore 7
      // 07a: invokestatic net/minecraft/client/renderer/GlStateManager.pushMatrix ()V
      // 07d: dload 3
      // 07e: d2f
      // 07f: dload 5
      // 081: d2f
      // 082: dload 7
      // 084: d2f
      // 085: invokestatic net/minecraft/client/renderer/GlStateManager.translate (FFF)V
      // 088: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 08b: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 08e: getfield net/minecraft/client/renderer/entity/RenderManager.playerViewY F
      // 091: fneg
      // 092: fconst_0
      // 093: fconst_1
      // 094: fconst_0
      // 095: invokestatic net/minecraft/client/renderer/GlStateManager.rotate (FFFF)V
      // 098: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 09b: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 09e: getfield net/minecraft/client/settings/GameSettings.thirdPersonView I
      // 0a1: iload 2
      // 0a2: ifne 0b6
      // 0a5: ldc 1510159986
      // 0a7: ldc 1510159984
      // 0a9: ixor
      // 0aa: if_icmpne 0b9
      // 0ad: goto 0b1
      // 0b0: athrow
      // 0b1: bipush -1
      // 0b2: goto 0b6
      // 0b5: athrow
      // 0b6: goto 0ba
      // 0b9: bipush 1
      // 0ba: i2f
      // 0bb: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0be: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 0c1: getfield net/minecraft/client/renderer/entity/RenderManager.playerViewX F
      // 0c4: fmul
      // 0c5: fconst_1
      // 0c6: fconst_0
      // 0c7: fconst_0
      // 0c8: invokestatic net/minecraft/client/renderer/GlStateManager.rotate (FFFF)V
      // 0cb: ldc -0.02266667
      // 0cd: ldc -0.02266667
      // 0cf: ldc -0.02266667
      // 0d1: invokestatic net/minecraft/client/renderer/GlStateManager.scale (FFF)V
      // 0d4: bipush 0
      // 0d5: invokestatic net/minecraft/client/renderer/GlStateManager.depthMask (Z)V
      // 0d8: invokestatic net/minecraft/client/renderer/GlStateManager.disableDepth ()V
      // 0db: ldc 1510161810
      // 0dd: ldc 1510159984
      // 0df: ixor
      // 0e0: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 0e3: bipush -1
      // 0e4: ldc 1510159994
      // 0e6: ldc 1510159984
      // 0e8: ixor
      // 0e9: ldc 255.0
      // 0eb: aload 0
      // 0ec: getfield x/oc588e87ff01.յ F
      // 0ef: fmul
      // 0f0: f2i
      // 0f1: invokestatic java/lang/Math.max (II)I
      // 0f4: invokestatic x/oc7ab2161b9f.Ҭ (II)I
      // 0f7: istore 9
      // 0f9: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0fc: getfield net/minecraft/client/Minecraft.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // 0ff: aload 0
      // 100: getfield x/oc588e87ff01.Ō Ljava/lang/String;
      // 103: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 106: getfield net/minecraft/client/Minecraft.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // 109: aload 0
      // 10a: getfield x/oc588e87ff01.Ō Ljava/lang/String;
      // 10d: invokevirtual net/minecraft/client/gui/FontRenderer.getStringWidth (Ljava/lang/String;)I
      // 110: ineg
      // 111: ldc 1510159986
      // 113: ldc 1510159984
      // 115: ixor
      // 116: idiv
      // 117: i2f
      // 118: ldc -3.0
      // 11a: aload 0
      // 11b: getfield x/oc588e87ff01.Մ Lx/occ2f8dff8d8;
      // 11e: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 121: iload 2
      // 122: ifne 12e
      // 125: ifeq 131
      // 128: goto 12c
      // 12b: athrow
      // 12c: iload 9
      // 12e: goto 132
      // 131: bipush -1
      // 132: bipush 1
      // 133: invokevirtual net/minecraft/client/gui/FontRenderer.drawString (Ljava/lang/String;FFIZ)I
      // 136: pop
      // 137: ldc 1510161810
      // 139: ldc 1510159984
      // 13b: ixor
      // 13c: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 13f: invokestatic net/minecraft/client/renderer/GlStateManager.enableDepth ()V
      // 142: bipush 1
      // 143: invokestatic net/minecraft/client/renderer/GlStateManager.depthMask (Z)V
      // 146: fconst_1
      // 147: fconst_1
      // 148: fconst_1
      // 149: fconst_1
      // 14a: invokestatic net/minecraft/client/renderer/GlStateManager.color (FFFF)V
      // 14d: invokestatic net/minecraft/client/renderer/GlStateManager.popMatrix ()V
      // 150: return
   }

   private void î() {
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
      // 05: iload 1
      // 06: ifne 32
      // 09: getfield x/oc588e87ff01.ƚ Lx/oca9cc61aada;
      // 0c: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0f: d2i
      // 10: tableswitch 157 0 2 29 58 131
      // 2c: athrow
      // 2d: aload 0
      // 2e: goto 32
      // 31: athrow
      // 32: ldc2_w 100.0
      // 35: aload 0
      // 36: getfield x/oc588e87ff01.յ F
      // 39: f2d
      // 3a: dconst_1
      // 3b: ddiv
      // 3c: dmul
      // 3d: d2i
      // 3e: invokedynamic makeConcatWithConstants (I)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001%" ]
      // 43: putfield x/oc588e87ff01.Ō Ljava/lang/String;
      // 46: iload 1
      // 47: ifeq ad
      // 4a: fconst_1
      // 4b: aload 0
      // 4c: getfield x/oc588e87ff01.յ F
      // 4f: fsub
      // 50: aload 0
      // 51: getfield x/oc588e87ff01.Ϫ Lnet/minecraft/util/BlockPos;
      // 54: invokestatic x/occb1ed1ed8f.ϛ (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/Block;
      // 57: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 5a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 5d: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 60: bipush 0
      // 61: bipush 0
      // 62: invokestatic x/occb1ed1ed8f.ԁ (Lnet/minecraft/block/Block;Lnet/minecraft/item/ItemStack;ZZ)F
      // 65: fdiv
      // 66: f2d
      // 67: ldc2_w 20.0
      // 6a: ddiv
      // 6b: bipush 1
      // 6c: invokestatic x/oc7ab2161b9f.ɜ (DI)D
      // 6f: dstore 2
      // 70: aload 0
      // 71: dload 2
      // 72: iload 1
      // 73: ifne 87
      // 76: dconst_0
      // 77: dcmpl
      // 78: ifne 86
      // 7b: goto 7f
      // 7e: athrow
      // 7f: ldc_w "0"
      // 82: goto 8c
      // 85: athrow
      // 86: dload 2
      // 87: invokedynamic makeConcatWithConstants (D)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001s" ]
      // 8c: putfield x/oc588e87ff01.Ō Ljava/lang/String;
      // 8f: iload 1
      // 90: ifeq ad
      // 93: aload 0
      // 94: aload 0
      // 95: getfield x/oc588e87ff01.յ F
      // 98: f2d
      // 99: ldc_w 706885001
      // 9c: ldc_w 706885003
      // 9f: ixor
      // a0: invokestatic x/oc7ab2161b9f.ɜ (DI)D
      // a3: invokestatic java/lang/String.valueOf (D)Ljava/lang/String;
      // a6: putfield x/oc588e87ff01.Ō Ljava/lang/String;
      // a9: goto ad
      // ac: athrow
      // ad: return
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
      // 004: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 007: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 00a: iload 1
      // 00b: ifne 025
      // 00e: getfield net/minecraft/client/entity/EntityPlayerSP.capabilities Lnet/minecraft/entity/player/PlayerCapabilities;
      // 011: getfield net/minecraft/entity/player/PlayerCapabilities.isCreativeMode Z
      // 014: ifne 036
      // 017: goto 01b
      // 01a: athrow
      // 01b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 01e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 021: goto 025
      // 024: athrow
      // 025: getfield net/minecraft/client/entity/EntityPlayerSP.capabilities Lnet/minecraft/entity/player/PlayerCapabilities;
      // 028: getfield net/minecraft/entity/player/PlayerCapabilities.allowEdit Z
      // 02b: iload 1
      // 02c: ifne 04b
      // 02f: ifne 03c
      // 032: goto 036
      // 035: athrow
      // 036: aload 0
      // 037: invokevirtual x/oc588e87ff01.Ӑ ()V
      // 03a: return
      // 03b: athrow
      // 03c: aload 0
      // 03d: getfield x/oc588e87ff01.Ŧ Lx/occ2f8dff8d8;
      // 040: iload 1
      // 041: ifne 0b5
      // 044: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 047: goto 04b
      // 04a: athrow
      // 04b: ifeq 0a9
      // 04e: getstatic x/oc9755810e45.ϔ Lx/oc8edd24b1ed;
      // 051: iload 1
      // 052: ifne 063
      // 055: goto 059
      // 058: athrow
      // 059: ifnull 0a9
      // 05c: goto 060
      // 05f: athrow
      // 060: getstatic x/oc9755810e45.ϔ Lx/oc8edd24b1ed;
      // 063: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 066: iload 1
      // 067: ifne 0b8
      // 06a: ifeq 0a9
      // 06d: goto 071
      // 070: athrow
      // 071: getstatic x/oc9755810e45.ϔ Lx/oc8edd24b1ed;
      // 074: invokevirtual x/oc8edd24b1ed.ԓ ()Lnet/minecraft/util/BlockPos;
      // 077: astore 2
      // 078: getstatic x/oc9755810e45.ϔ Lx/oc8edd24b1ed;
      // 07b: invokevirtual x/oc8edd24b1ed.Ђ ()F
      // 07e: fstore 3
      // 07f: aload 2
      // 080: ifnull 0a9
      // 083: fload 3
      // 084: fconst_0
      // 085: fcmpl
      // 086: iload 1
      // 087: ifne 0b8
      // 08a: goto 08e
      // 08d: athrow
      // 08e: ifle 0a9
      // 091: goto 095
      // 094: athrow
      // 095: aload 0
      // 096: fconst_1
      // 097: fload 3
      // 098: invokestatic java/lang/Math.min (FF)F
      // 09b: putfield x/oc588e87ff01.յ F
      // 09e: aload 0
      // 09f: aload 2
      // 0a0: putfield x/oc588e87ff01.Ϫ Lnet/minecraft/util/BlockPos;
      // 0a3: aload 0
      // 0a4: invokevirtual x/oc588e87ff01.î ()V
      // 0a7: return
      // 0a8: athrow
      // 0a9: aload 0
      // 0aa: iload 1
      // 0ab: ifne 0e8
      // 0ae: getfield x/oc588e87ff01.Ԧ Lx/occ2f8dff8d8;
      // 0b1: goto 0b5
      // 0b4: athrow
      // 0b5: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0b8: ifeq 0e3
      // 0bb: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0be: iload 1
      // 0bf: ifne 0d7
      // 0c2: goto 0c6
      // 0c5: athrow
      // 0c6: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 0c9: ifnull 0e3
      // 0cc: goto 0d0
      // 0cf: athrow
      // 0d0: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0d3: goto 0d7
      // 0d6: athrow
      // 0d7: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 0da: getfield net/minecraft/util/MovingObjectPosition.typeOfHit Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 0dd: getstatic net/minecraft/util/MovingObjectPosition$MovingObjectType.BLOCK Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 0e0: if_acmpeq 0ec
      // 0e3: aload 0
      // 0e4: goto 0e8
      // 0e7: athrow
      // 0e8: invokevirtual x/oc588e87ff01.Ӑ ()V
      // 0eb: return
      // 0ec: aload 0
      // 0ed: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0f0: iload 1
      // 0f1: ifne 116
      // 0f4: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 0f7: invokeinterface x/oc51cbcffcfe.getCurBlockDamageMP ()F 1
      // 0fc: putfield x/oc588e87ff01.յ F
      // 0ff: aload 0
      // 100: getfield x/oc588e87ff01.յ F
      // 103: fconst_0
      // 104: fcmpl
      // 105: ifne 112
      // 108: goto 10c
      // 10b: athrow
      // 10c: aload 0
      // 10d: invokevirtual x/oc588e87ff01.Ӑ ()V
      // 110: return
      // 111: athrow
      // 112: aload 0
      // 113: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 116: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 119: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 11c: putfield x/oc588e87ff01.Ϫ Lnet/minecraft/util/BlockPos;
      // 11f: aload 0
      // 120: invokevirtual x/oc588e87ff01.î ()V
      // 123: return
   }

   @Override
   public void onDisable() {
      this.Ӑ();
   }

   private void Ӑ() {
      this.յ = 0.0F;
      this.Ϫ = null;
      this.Ō = "";
   }
}

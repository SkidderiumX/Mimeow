package x;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;

public class oc21e4c2f7ea extends oc69da1aa7f5 {
   private static final String[] Ԡ;
   private static final double ť = 0.002;
   private final occc831eff22 Ȃ;
   private final occ2f8dff8d8 ͼ;
   private final oca9cc61aada ş;
   private final oc24a0a5bddf Ѣ;
   private final oc24a0a5bddf ϑ;
   private final oca9cc61aada ʦ;
   private final oca9cc61aada Ȉ;
   private final occc831eff22 ō;
   private final occ2f8dff8d8 Î;
   private final oca9cc61aada È;
   private final oc24a0a5bddf A;
   private final oc24a0a5bddf ӷ;
   private final oca9cc61aada Ƃ;
   private final oca9cc61aada ö;
   private final oca9cc61aada Ӂ;
   private final occc831eff22 ҵ;
   private final occ2f8dff8d8 ҁ;
   private final occ2f8dff8d8 ʰ;
   private final occ2f8dff8d8 Ķ;
   private final occ2f8dff8d8 ή;
   public static int Ƀ;

   public oc21e4c2f7ea() {
      super("BlockOverlay", oce4cea752dd.Ŏ);
      this.ą("Customizes the outline and fill of targeted blocks.");
      this.ʌ(this.Ȃ = new occc831eff22("Face"));
      this.ʌ(this.ͼ = new occ2f8dff8d8(this.Ȃ, "Face Visible", true));
      this.ʌ(this.ş = new oca9cc61aada(this.Ȃ, "Face Color mode", 0, Ԡ));
      this.ʌ(this.Ѣ = new oc24a0a5bddf(this.Ȃ, "Face Color", 0, 0, 0, 1022792460 ^ 1022792552));
      this.ʌ(
         this.ϑ = new oc24a0a5bddf(this.Ȃ, "Face Color 2", 1022792599 ^ 1022792552, 1022792599 ^ 1022792552, 1022792599 ^ 1022792552, 1022792460 ^ 1022792552)
      );
      this.ʌ(this.ʦ = new oca9cc61aada(this.Ȃ, "Face Fade speed", 5.5, 1.0, 10.0, 0.5));
      this.ʌ(this.Ȉ = new oca9cc61aada(this.Ȃ, "Face Chroma speed", 5.5, 1.0, 10.0, 0.5));
      this.ʌ(this.ō = new occc831eff22("Outline"));
      this.ʌ(this.Î = new occ2f8dff8d8(this.ō, "Outline Visible", true));
      this.ʌ(this.È = new oca9cc61aada(this.ō, "Outline Color mode", 0, Ԡ));
      this.ʌ(this.A = new oc24a0a5bddf(this.ō, "Outline Color", 0, 0, 0, 1022792599 ^ 1022792552));
      this.ʌ(
         this.ӷ = new oc24a0a5bddf(
            this.ō, "Outline Color 2", 1022792599 ^ 1022792552, 1022792599 ^ 1022792552, 1022792599 ^ 1022792552, 1022792599 ^ 1022792552
         )
      );
      this.ʌ(this.Ƃ = new oca9cc61aada(this.ō, "Outline Fade speed", 5.5, 1.0, 10.0, 0.5));
      this.ʌ(this.ö = new oca9cc61aada(this.ō, "Outline Chroma speed", 5.5, 1.0, 10.0, 0.5));
      this.ʌ(this.Ӂ = new oca9cc61aada(this.ō, "Thickness", 2.0, 1.0, 10.0, 0.5));
      this.ʌ(this.ҵ = new occc831eff22("Options"));
      this.ʌ(this.ҁ = new occ2f8dff8d8(this.ҵ, "Persistence", false));
      this.ʌ(this.ʰ = new occ2f8dff8d8(this.ҵ, "Depthless", false));
      this.ʌ(this.Ķ = new occ2f8dff8d8(this.ҵ, "Barriers", false));
      this.ʌ(this.ή = new occ2f8dff8d8(this.ҵ, "Hide plants", false));
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
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: aload 0
      // 004: getfield x/oc21e4c2f7ea.ş Lx/oca9cc61aada;
      // 007: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 00a: d2i
      // 00b: istore 2
      // 00c: istore 1
      // 00d: aload 0
      // 00e: getfield x/oc21e4c2f7ea.ϑ Lx/oc24a0a5bddf;
      // 011: iload 2
      // 012: iload 1
      // 013: ifne 03c
      // 016: ldc -1965316910
      // 018: ldc -1965316912
      // 01a: ixor
      // 01b: if_icmpeq 037
      // 01e: goto 022
      // 021: athrow
      // 022: iload 2
      // 023: iload 1
      // 024: ifne 03c
      // 027: goto 02b
      // 02a: athrow
      // 02b: ldc -1965316909
      // 02d: ldc -1965316912
      // 02f: ixor
      // 030: if_icmpne 03f
      // 033: goto 037
      // 036: athrow
      // 037: bipush 1
      // 038: goto 03c
      // 03b: athrow
      // 03c: goto 040
      // 03f: bipush 0
      // 040: aload 0
      // 041: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 044: aload 0
      // 045: getfield x/oc21e4c2f7ea.ʦ Lx/oca9cc61aada;
      // 048: iload 2
      // 049: iload 1
      // 04a: ifne 05e
      // 04d: ldc -1965316909
      // 04f: ldc -1965316912
      // 051: ixor
      // 052: if_icmpne 061
      // 055: goto 059
      // 058: athrow
      // 059: bipush 1
      // 05a: goto 05e
      // 05d: athrow
      // 05e: goto 062
      // 061: bipush 0
      // 062: aload 0
      // 063: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 066: aload 0
      // 067: getfield x/oc21e4c2f7ea.Ȉ Lx/oca9cc61aada;
      // 06a: iload 2
      // 06b: iload 1
      // 06c: ifne 080
      // 06f: ldc -1965316908
      // 071: ldc -1965316912
      // 073: ixor
      // 074: if_icmpne 083
      // 077: goto 07b
      // 07a: athrow
      // 07b: bipush 1
      // 07c: goto 080
      // 07f: athrow
      // 080: goto 084
      // 083: bipush 0
      // 084: aload 0
      // 085: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 088: aload 0
      // 089: getfield x/oc21e4c2f7ea.È Lx/oca9cc61aada;
      // 08c: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 08f: d2i
      // 090: istore 3
      // 091: aload 0
      // 092: getfield x/oc21e4c2f7ea.ӷ Lx/oc24a0a5bddf;
      // 095: iload 3
      // 096: iload 1
      // 097: ifne 0c0
      // 09a: ldc -1965316910
      // 09c: ldc -1965316912
      // 09e: ixor
      // 09f: if_icmpeq 0bb
      // 0a2: goto 0a6
      // 0a5: athrow
      // 0a6: iload 3
      // 0a7: iload 1
      // 0a8: ifne 0c0
      // 0ab: goto 0af
      // 0ae: athrow
      // 0af: ldc -1965316909
      // 0b1: ldc -1965316912
      // 0b3: ixor
      // 0b4: if_icmpne 0c3
      // 0b7: goto 0bb
      // 0ba: athrow
      // 0bb: bipush 1
      // 0bc: goto 0c0
      // 0bf: athrow
      // 0c0: goto 0c4
      // 0c3: bipush 0
      // 0c4: aload 0
      // 0c5: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0c8: aload 0
      // 0c9: getfield x/oc21e4c2f7ea.Ƃ Lx/oca9cc61aada;
      // 0cc: iload 3
      // 0cd: iload 1
      // 0ce: ifne 0e2
      // 0d1: ldc -1965316909
      // 0d3: ldc -1965316912
      // 0d5: ixor
      // 0d6: if_icmpne 0e5
      // 0d9: goto 0dd
      // 0dc: athrow
      // 0dd: bipush 1
      // 0de: goto 0e2
      // 0e1: athrow
      // 0e2: goto 0e6
      // 0e5: bipush 0
      // 0e6: aload 0
      // 0e7: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0ea: aload 0
      // 0eb: getfield x/oc21e4c2f7ea.ö Lx/oca9cc61aada;
      // 0ee: iload 3
      // 0ef: iload 1
      // 0f0: ifne 104
      // 0f3: ldc -1965316908
      // 0f5: ldc -1965316912
      // 0f7: ixor
      // 0f8: if_icmpne 107
      // 0fb: goto 0ff
      // 0fe: athrow
      // 0ff: bipush 1
      // 100: goto 104
      // 103: athrow
      // 104: goto 108
      // 107: bipush 0
      // 108: aload 0
      // 109: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 10c: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGHEST
   )
   public void Ż(oce4b2178c11 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: aload 1
      // 04: bipush 1
      // 05: invokevirtual x/oc68d6b191af.setCanceled (Z)V
      // 08: istore 2
      // 09: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 0c: iload 2
      // 0d: ifne 27
      // 10: ifne 18
      // 13: goto 17
      // 16: athrow
      // 17: return
      // 18: aload 0
      // 19: iload 2
      // 1a: ifne 3d
      // 1d: getfield x/oc21e4c2f7ea.ҁ Lx/occ2f8dff8d8;
      // 20: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 23: goto 27
      // 26: athrow
      // 27: ifne 3c
      // 2a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 2d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 30: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isSpectator ()Z
      // 33: ifeq 3c
      // 36: goto 3a
      // 39: athrow
      // 3a: return
      // 3b: athrow
      // 3c: aload 0
      // 3d: invokevirtual x/oc21e4c2f7ea.Ǖ ()Lnet/minecraft/util/BlockPos;
      // 40: astore 3
      // 41: aload 3
      // 42: ifnonnull 47
      // 45: return
      // 46: athrow
      // 47: aload 0
      // 48: getfield x/oc21e4c2f7ea.ͼ Lx/occ2f8dff8d8;
      // 4b: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 4e: istore 4
      // 50: iload 2
      // 51: aload 0
      // 52: getfield x/oc21e4c2f7ea.Î Lx/occ2f8dff8d8;
      // 55: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 58: istore 5
      // 5a: ifne 7b
      // 5d: iload 4
      // 5f: ifne 71
      // 62: goto 66
      // 65: athrow
      // 66: iload 5
      // 68: ifne 71
      // 6b: goto 6f
      // 6e: athrow
      // 6f: return
      // 70: athrow
      // 71: aload 0
      // 72: aload 3
      // 73: aconst_null
      // 74: iload 4
      // 76: iload 5
      // 78: invokevirtual x/oc21e4c2f7ea.B (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;ZZ)V
      // 7b: return
   }

   private void B(BlockPos param1, EnumFacing param2, boolean param3, boolean param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: istore 5
      // 005: iload 5
      // 007: aload 1
      // 008: invokestatic x/occb1ed1ed8f.ª (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/util/AxisAlignedBB;
      // 00b: astore 6
      // 00d: ifne 02b
      // 010: aload 6
      // 012: ifnonnull 01b
      // 015: goto 019
      // 018: athrow
      // 019: return
      // 01a: athrow
      // 01b: aload 6
      // 01d: ldc2_w 0.002
      // 020: ldc2_w 0.002
      // 023: ldc2_w 0.002
      // 026: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 029: astore 6
      // 02b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 02e: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 031: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosX D
      // 034: dstore 7
      // 036: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 039: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 03c: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosY D
      // 03f: dstore 9
      // 041: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 044: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 047: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosZ D
      // 04a: dstore 11
      // 04c: bipush 0
      // 04d: istore 13
      // 04f: bipush 0
      // 050: istore 14
      // 052: bipush 0
      // 053: istore 15
      // 055: bipush 0
      // 056: istore 16
      // 058: iload 3
      // 059: iload 5
      // 05b: ifne 0ad
      // 05e: ifeq 0ab
      // 061: goto 065
      // 064: athrow
      // 065: aload 0
      // 066: getfield x/oc21e4c2f7ea.ş Lx/oca9cc61aada;
      // 069: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 06c: d2i
      // 06d: aload 0
      // 06e: getfield x/oc21e4c2f7ea.Ѣ Lx/oc24a0a5bddf;
      // 071: aload 0
      // 072: getfield x/oc21e4c2f7ea.ϑ Lx/oc24a0a5bddf;
      // 075: aload 0
      // 076: getfield x/oc21e4c2f7ea.ʦ Lx/oca9cc61aada;
      // 079: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 07c: aload 0
      // 07d: getfield x/oc21e4c2f7ea.Ȉ Lx/oca9cc61aada;
      // 080: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 083: invokestatic x/oc21e4c2f7ea.Ҍ (ILx/oc24a0a5bddf;Lx/oc24a0a5bddf;DD)I
      // 086: istore 13
      // 088: aload 0
      // 089: getfield x/oc21e4c2f7ea.ş Lx/oca9cc61aada;
      // 08c: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 08f: d2i
      // 090: aload 0
      // 091: getfield x/oc21e4c2f7ea.Ѣ Lx/oc24a0a5bddf;
      // 094: aload 0
      // 095: getfield x/oc21e4c2f7ea.ϑ Lx/oc24a0a5bddf;
      // 098: aload 0
      // 099: getfield x/oc21e4c2f7ea.ʦ Lx/oca9cc61aada;
      // 09c: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 09f: aload 0
      // 0a0: getfield x/oc21e4c2f7ea.Ȉ Lx/oca9cc61aada;
      // 0a3: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0a6: invokestatic x/oc21e4c2f7ea.Ю (ILx/oc24a0a5bddf;Lx/oc24a0a5bddf;DD)I
      // 0a9: istore 14
      // 0ab: iload 4
      // 0ad: iload 5
      // 0af: ifne 129
      // 0b2: ifeq 0ff
      // 0b5: goto 0b9
      // 0b8: athrow
      // 0b9: aload 0
      // 0ba: getfield x/oc21e4c2f7ea.È Lx/oca9cc61aada;
      // 0bd: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0c0: d2i
      // 0c1: aload 0
      // 0c2: getfield x/oc21e4c2f7ea.A Lx/oc24a0a5bddf;
      // 0c5: aload 0
      // 0c6: getfield x/oc21e4c2f7ea.ӷ Lx/oc24a0a5bddf;
      // 0c9: aload 0
      // 0ca: getfield x/oc21e4c2f7ea.Ƃ Lx/oca9cc61aada;
      // 0cd: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0d0: aload 0
      // 0d1: getfield x/oc21e4c2f7ea.ö Lx/oca9cc61aada;
      // 0d4: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0d7: invokestatic x/oc21e4c2f7ea.Ҍ (ILx/oc24a0a5bddf;Lx/oc24a0a5bddf;DD)I
      // 0da: istore 15
      // 0dc: aload 0
      // 0dd: getfield x/oc21e4c2f7ea.È Lx/oca9cc61aada;
      // 0e0: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0e3: d2i
      // 0e4: aload 0
      // 0e5: getfield x/oc21e4c2f7ea.A Lx/oc24a0a5bddf;
      // 0e8: aload 0
      // 0e9: getfield x/oc21e4c2f7ea.ӷ Lx/oc24a0a5bddf;
      // 0ec: aload 0
      // 0ed: getfield x/oc21e4c2f7ea.Ƃ Lx/oca9cc61aada;
      // 0f0: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0f3: aload 0
      // 0f4: getfield x/oc21e4c2f7ea.ö Lx/oca9cc61aada;
      // 0f7: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0fa: invokestatic x/oc21e4c2f7ea.Ю (ILx/oc24a0a5bddf;Lx/oc24a0a5bddf;DD)I
      // 0fd: istore 16
      // 0ff: invokestatic org/lwjgl/opengl/GL11.glPushMatrix ()V
      // 102: invokestatic net/minecraft/client/renderer/GlStateManager.disableCull ()V
      // 105: invokestatic net/minecraft/client/renderer/GlStateManager.enableBlend ()V
      // 108: ldc_w 2052418268
      // 10b: ldc_w 2052418014
      // 10e: ixor
      // 10f: ldc_w 2052418269
      // 112: ldc_w 2052418014
      // 115: ixor
      // 116: bipush 1
      // 117: bipush 0
      // 118: invokestatic net/minecraft/client/renderer/GlStateManager.tryBlendFuncSeparate (IIII)V
      // 11b: invokestatic net/minecraft/client/renderer/GlStateManager.disableTexture2D ()V
      // 11e: bipush 0
      // 11f: invokestatic net/minecraft/client/renderer/GlStateManager.depthMask (Z)V
      // 122: aload 0
      // 123: getfield x/oc21e4c2f7ea.ʰ Lx/occ2f8dff8d8;
      // 126: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 129: istore 17
      // 12b: iload 5
      // 12d: ifne 160
      // 130: iload 17
      // 132: ifeq 140
      // 135: goto 139
      // 138: athrow
      // 139: invokestatic net/minecraft/client/renderer/GlStateManager.disableDepth ()V
      // 13c: goto 140
      // 13f: athrow
      // 140: ldc_w 2052416254
      // 143: ldc_w 2052418014
      // 146: ixor
      // 147: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 14a: iload 5
      // 14c: ldc_w 2052416908
      // 14f: ldc_w 2052418014
      // 152: ixor
      // 153: ldc_w 2052421852
      // 156: ldc_w 2052418014
      // 159: ixor
      // 15a: invokestatic org/lwjgl/opengl/GL11.glHint (II)V
      // 15d: ifne 1b6
      // 160: iload 4
      // 162: ifeq 174
      // 165: aload 0
      // 166: getfield x/oc21e4c2f7ea.Ӂ Lx/oca9cc61aada;
      // 169: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 16c: d2f
      // 16d: invokestatic org/lwjgl/opengl/GL11.glLineWidth (F)V
      // 170: goto 174
      // 173: athrow
      // 174: ldc_w 2052420831
      // 177: ldc_w 2052418014
      // 17a: ixor
      // 17b: invokestatic org/lwjgl/opengl/GL11.glShadeModel (I)V
      // 17e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 181: aload 1
      // 182: aload 6
      // 184: aload 2
      // 185: dload 7
      // 187: dload 9
      // 189: dload 11
      // 18b: iload 13
      // 18d: iload 14
      // 18f: iload 15
      // 191: iload 16
      // 193: iload 3
      // 194: iload 4
      // 196: invokestatic x/oc21e4c2f7ea.ˣ (Lnet/minecraft/client/Minecraft;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/AxisAlignedBB;Lnet/minecraft/util/EnumFacing;DDDIIIIZZ)V
      // 199: ldc_w 2052420830
      // 19c: ldc_w 2052418014
      // 19f: ixor
      // 1a0: invokestatic org/lwjgl/opengl/GL11.glShadeModel (I)V
      // 1a3: fconst_2
      // 1a4: invokestatic org/lwjgl/opengl/GL11.glLineWidth (F)V
      // 1a7: ldc_w 2052416254
      // 1aa: ldc_w 2052418014
      // 1ad: ixor
      // 1ae: iload 5
      // 1b0: ifne 1c3
      // 1b3: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 1b6: iload 17
      // 1b8: ifeq 1c2
      // 1bb: invokestatic net/minecraft/client/renderer/GlStateManager.enableDepth ()V
      // 1be: goto 1c2
      // 1c1: athrow
      // 1c2: bipush 1
      // 1c3: invokestatic net/minecraft/client/renderer/GlStateManager.depthMask (Z)V
      // 1c6: invokestatic net/minecraft/client/renderer/GlStateManager.enableTexture2D ()V
      // 1c9: invokestatic net/minecraft/client/renderer/GlStateManager.enableCull ()V
      // 1cc: invokestatic net/minecraft/client/renderer/GlStateManager.disableBlend ()V
      // 1cf: invokestatic org/lwjgl/opengl/GL11.glPopMatrix ()V
      // 1d2: goto 213
      // 1d5: astore 18
      // 1d7: iload 5
      // 1d9: ldc_w 2052420830
      // 1dc: ldc_w 2052418014
      // 1df: ixor
      // 1e0: invokestatic org/lwjgl/opengl/GL11.glShadeModel (I)V
      // 1e3: ifne 210
      // 1e6: fconst_2
      // 1e7: invokestatic org/lwjgl/opengl/GL11.glLineWidth (F)V
      // 1ea: ldc_w 2052416254
      // 1ed: ldc_w 2052418014
      // 1f0: ixor
      // 1f1: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 1f4: iload 17
      // 1f6: ifeq 200
      // 1f9: invokestatic net/minecraft/client/renderer/GlStateManager.enableDepth ()V
      // 1fc: goto 200
      // 1ff: athrow
      // 200: bipush 1
      // 201: invokestatic net/minecraft/client/renderer/GlStateManager.depthMask (Z)V
      // 204: invokestatic net/minecraft/client/renderer/GlStateManager.enableTexture2D ()V
      // 207: invokestatic net/minecraft/client/renderer/GlStateManager.enableCull ()V
      // 20a: invokestatic net/minecraft/client/renderer/GlStateManager.disableBlend ()V
      // 20d: invokestatic org/lwjgl/opengl/GL11.glPopMatrix ()V
      // 210: aload 18
      // 212: athrow
      // 213: return
   }

   public static void Ė(BlockPos param0, int param1, int param2, float param3, boolean param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: invokestatic net/minecraft/client/Minecraft.getMinecraft ()Lnet/minecraft/client/Minecraft;
      // 006: astore 6
      // 008: istore 5
      // 00a: aload 6
      // 00c: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 00f: ifnull 023
      // 012: aload 0
      // 013: iload 5
      // 015: ifne 025
      // 018: goto 01c
      // 01b: athrow
      // 01c: ifnonnull 024
      // 01f: goto 023
      // 022: athrow
      // 023: return
      // 024: aload 0
      // 025: invokestatic x/occb1ed1ed8f.ª (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/util/AxisAlignedBB;
      // 028: astore 7
      // 02a: iload 5
      // 02c: ifne 04a
      // 02f: aload 7
      // 031: ifnonnull 03a
      // 034: goto 038
      // 037: athrow
      // 038: return
      // 039: athrow
      // 03a: aload 7
      // 03c: ldc2_w 0.002
      // 03f: ldc2_w 0.002
      // 042: ldc2_w 0.002
      // 045: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 048: astore 7
      // 04a: aload 6
      // 04c: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 04f: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosX D
      // 052: dstore 8
      // 054: iload 5
      // 056: aload 6
      // 058: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 05b: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosY D
      // 05e: dstore 10
      // 060: aload 6
      // 062: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 065: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosZ D
      // 068: dstore 12
      // 06a: invokestatic org/lwjgl/opengl/GL11.glPushMatrix ()V
      // 06d: invokestatic net/minecraft/client/renderer/GlStateManager.disableCull ()V
      // 070: invokestatic net/minecraft/client/renderer/GlStateManager.enableBlend ()V
      // 073: ldc_w -721077558
      // 076: ldc_w -721077816
      // 079: ixor
      // 07a: ldc_w -721077557
      // 07d: ldc_w -721077816
      // 080: ixor
      // 081: bipush 1
      // 082: bipush 0
      // 083: invokestatic net/minecraft/client/renderer/GlStateManager.tryBlendFuncSeparate (IIII)V
      // 086: ifne 0fb
      // 089: invokestatic net/minecraft/client/renderer/GlStateManager.disableTexture2D ()V
      // 08c: bipush 0
      // 08d: invokestatic net/minecraft/client/renderer/GlStateManager.depthMask (Z)V
      // 090: iload 4
      // 092: ifeq 0a0
      // 095: goto 099
      // 098: athrow
      // 099: invokestatic net/minecraft/client/renderer/GlStateManager.disableDepth ()V
      // 09c: goto 0a0
      // 09f: athrow
      // 0a0: ldc_w -721079576
      // 0a3: ldc_w -721077816
      // 0a6: ixor
      // 0a7: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 0aa: ldc_w -721078886
      // 0ad: ldc_w -721077816
      // 0b0: ixor
      // 0b1: ldc_w -721082166
      // 0b4: ldc_w -721077816
      // 0b7: ixor
      // 0b8: invokestatic org/lwjgl/opengl/GL11.glHint (II)V
      // 0bb: fload 3
      // 0bc: invokestatic org/lwjgl/opengl/GL11.glLineWidth (F)V
      // 0bf: ldc_w -721083191
      // 0c2: ldc_w -721077816
      // 0c5: ixor
      // 0c6: invokestatic org/lwjgl/opengl/GL11.glShadeModel (I)V
      // 0c9: aload 6
      // 0cb: aload 0
      // 0cc: aload 7
      // 0ce: aconst_null
      // 0cf: dload 8
      // 0d1: dload 10
      // 0d3: dload 12
      // 0d5: bipush 0
      // 0d6: bipush 0
      // 0d7: iload 1
      // 0d8: iload 2
      // 0d9: bipush 0
      // 0da: bipush 1
      // 0db: invokestatic x/oc21e4c2f7ea.ˣ (Lnet/minecraft/client/Minecraft;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/AxisAlignedBB;Lnet/minecraft/util/EnumFacing;DDDIIIIZZ)V
      // 0de: iload 5
      // 0e0: ifne 117
      // 0e3: ldc_w -721083192
      // 0e6: ldc_w -721077816
      // 0e9: ixor
      // 0ea: invokestatic org/lwjgl/opengl/GL11.glShadeModel (I)V
      // 0ed: fconst_2
      // 0ee: invokestatic org/lwjgl/opengl/GL11.glLineWidth (F)V
      // 0f1: ldc_w -721079576
      // 0f4: ldc_w -721077816
      // 0f7: ixor
      // 0f8: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 0fb: iload 4
      // 0fd: ifeq 107
      // 100: invokestatic net/minecraft/client/renderer/GlStateManager.enableDepth ()V
      // 103: goto 107
      // 106: athrow
      // 107: bipush 1
      // 108: invokestatic net/minecraft/client/renderer/GlStateManager.depthMask (Z)V
      // 10b: invokestatic net/minecraft/client/renderer/GlStateManager.enableTexture2D ()V
      // 10e: invokestatic net/minecraft/client/renderer/GlStateManager.enableCull ()V
      // 111: invokestatic net/minecraft/client/renderer/GlStateManager.disableBlend ()V
      // 114: invokestatic org/lwjgl/opengl/GL11.glPopMatrix ()V
      // 117: goto 158
      // 11a: astore 14
      // 11c: iload 5
      // 11e: ifne 155
      // 121: ldc_w -721083192
      // 124: ldc_w -721077816
      // 127: ixor
      // 128: invokestatic org/lwjgl/opengl/GL11.glShadeModel (I)V
      // 12b: fconst_2
      // 12c: invokestatic org/lwjgl/opengl/GL11.glLineWidth (F)V
      // 12f: ldc_w -721079576
      // 132: ldc_w -721077816
      // 135: ixor
      // 136: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 139: iload 4
      // 13b: ifeq 145
      // 13e: invokestatic net/minecraft/client/renderer/GlStateManager.enableDepth ()V
      // 141: goto 145
      // 144: athrow
      // 145: bipush 1
      // 146: invokestatic net/minecraft/client/renderer/GlStateManager.depthMask (Z)V
      // 149: invokestatic net/minecraft/client/renderer/GlStateManager.enableTexture2D ()V
      // 14c: invokestatic net/minecraft/client/renderer/GlStateManager.enableCull ()V
      // 14f: invokestatic net/minecraft/client/renderer/GlStateManager.disableBlend ()V
      // 152: invokestatic org/lwjgl/opengl/GL11.glPopMatrix ()V
      // 155: aload 14
      // 157: athrow
      // 158: return
   }

   private static void ˣ(
      Minecraft param0,
      BlockPos param1,
      AxisAlignedBB param2,
      EnumFacing param3,
      double param4,
      double param6,
      double param8,
      int param10,
      int param11,
      int param12,
      int param13,
      boolean param14,
      boolean param15
   ) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: aload 2
      // 04: dload 4
      // 06: dneg
      // 07: dload 6
      // 09: dneg
      // 0a: dload 8
      // 0c: dneg
      // 0d: invokevirtual net/minecraft/util/AxisAlignedBB.offset (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 10: astore 17
      // 12: istore 16
      // 14: aload 0
      // 15: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 18: aload 1
      // 19: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 1c: astore 18
      // 1e: iload 16
      // 20: ifne 57
      // 23: aload 18
      // 25: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 2a: instanceof net/minecraft/block/BlockStairs
      // 2d: ifeq 5c
      // 30: goto 34
      // 33: athrow
      // 34: aload 1
      // 35: aload 18
      // 37: aload 2
      // 38: aload 3
      // 39: dload 4
      // 3b: dload 6
      // 3d: dload 8
      // 3f: iload 10
      // 41: iload 11
      // 43: iload 12
      // 45: iload 13
      // 47: iload 14
      // 49: iload 15
      // 4b: invokedynamic z$28or8txyh193t ()Lx/oc6ae6c74639; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Lnet/minecraft/util/AxisAlignedBB;Lnet/minecraft/util/EnumFacing;IIIIZZ)V, x/oc21e4c2f7ea.ԍ (Lnet/minecraft/util/AxisAlignedBB;Lnet/minecraft/util/EnumFacing;IIIIZZ)V, (Lnet/minecraft/util/AxisAlignedBB;Lnet/minecraft/util/EnumFacing;IIIIZZ)V ]
      // 50: invokestatic x/oc8e5d226f46.ϳ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/block/state/IBlockState;Lnet/minecraft/util/AxisAlignedBB;Lnet/minecraft/util/EnumFacing;DDDIIIIZZLx/oc6ae6c74639;)V
      // 53: goto 57
      // 56: athrow
      // 57: iload 16
      // 59: ifeq b5
      // 5c: aload 3
      // 5d: ifnull 7f
      // 60: goto 64
      // 63: athrow
      // 64: aload 17
      // 66: aload 3
      // 67: iload 10
      // 69: iload 11
      // 6b: iload 12
      // 6d: iload 13
      // 6f: iload 14
      // 71: iload 15
      // 73: invokestatic x/oc21e4c2f7ea.ԍ (Lnet/minecraft/util/AxisAlignedBB;Lnet/minecraft/util/EnumFacing;IIIIZZ)V
      // 76: iload 16
      // 78: ifeq b5
      // 7b: goto 7f
      // 7e: athrow
      // 7f: invokestatic net/minecraft/util/EnumFacing.values ()[Lnet/minecraft/util/EnumFacing;
      // 82: astore 19
      // 84: aload 19
      // 86: arraylength
      // 87: istore 20
      // 89: bipush 0
      // 8a: istore 21
      // 8c: iload 21
      // 8e: iload 20
      // 90: if_icmpge b5
      // 93: aload 19
      // 95: iload 21
      // 97: aaload
      // 98: astore 22
      // 9a: iload 16
      // 9c: aload 17
      // 9e: aload 22
      // a0: iload 10
      // a2: iload 11
      // a4: iload 12
      // a6: iload 13
      // a8: iload 14
      // aa: iload 15
      // ac: invokestatic x/oc21e4c2f7ea.ԍ (Lnet/minecraft/util/AxisAlignedBB;Lnet/minecraft/util/EnumFacing;IIIIZZ)V
      // af: iinc 21 1
      // b2: ifeq 8c
      // b5: return
   }

   private BlockPos Ǖ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 1
      // 04: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 07: iload 1
      // 08: ifne 1c
      // 0b: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 0e: ifnull 30
      // 11: goto 15
      // 14: athrow
      // 15: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 18: goto 1c
      // 1b: athrow
      // 1c: iload 1
      // 1d: ifne 36
      // 20: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 23: getfield net/minecraft/util/MovingObjectPosition.typeOfHit Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 26: getstatic net/minecraft/util/MovingObjectPosition$MovingObjectType.BLOCK Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 29: if_acmpeq 33
      // 2c: goto 30
      // 2f: athrow
      // 30: aconst_null
      // 31: areturn
      // 32: athrow
      // 33: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 36: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 39: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 3c: astore 2
      // 3d: aload 2
      // 3e: ifnonnull 44
      // 41: aconst_null
      // 42: areturn
      // 43: athrow
      // 44: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 47: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 4a: aload 2
      // 4b: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 4e: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 53: astore 3
      // 54: aload 3
      // 55: iload 1
      // 56: ifne 67
      // 59: getstatic net/minecraft/init/Blocks.air Lnet/minecraft/block/Block;
      // 5c: if_acmpne 66
      // 5f: goto 63
      // 62: athrow
      // 63: aconst_null
      // 64: areturn
      // 65: athrow
      // 66: aload 3
      // 67: getstatic net/minecraft/init/Blocks.barrier Lnet/minecraft/block/Block;
      // 6a: if_acmpne 86
      // 6d: aload 0
      // 6e: iload 1
      // 6f: ifne 87
      // 72: goto 76
      // 75: athrow
      // 76: getfield x/oc21e4c2f7ea.Ķ Lx/occ2f8dff8d8;
      // 79: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 7c: ifne 86
      // 7f: goto 83
      // 82: athrow
      // 83: aconst_null
      // 84: areturn
      // 85: athrow
      // 86: aload 0
      // 87: getfield x/oc21e4c2f7ea.ή Lx/occ2f8dff8d8;
      // 8a: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 8d: iload 1
      // 8e: ifne a8
      // 91: ifeq db
      // 94: goto 98
      // 97: athrow
      // 98: aload 3
      // 99: iload 1
      // 9a: ifne ac
      // 9d: goto a1
      // a0: athrow
      // a1: instanceof net/minecraft/block/BlockTallGrass
      // a4: goto a8
      // a7: athrow
      // a8: ifne d8
      // ab: aload 3
      // ac: iload 1
      // ad: ifne bf
      // b0: instanceof net/minecraft/block/BlockFlower
      // b3: ifne d8
      // b6: goto ba
      // b9: athrow
      // ba: aload 3
      // bb: goto bf
      // be: athrow
      // bf: iload 1
      // c0: ifne d2
      // c3: instanceof net/minecraft/block/BlockDeadBush
      // c6: ifne d8
      // c9: goto cd
      // cc: athrow
      // cd: aload 3
      // ce: goto d2
      // d1: athrow
      // d2: instanceof net/minecraft/block/BlockDoublePlant
      // d5: ifeq db
      // d8: aconst_null
      // d9: areturn
      // da: athrow
      // db: aload 2
      // dc: areturn
   }

   private static int έ(int var0, int var1, double var2) {
      Color var4 = new Color(var0, true);
      Color var5 = new Color(var1, true);
      double var6 = 1.0 - var2;
      return new Color(
            (int)(var4.getRed() * var2 + var5.getRed() * var6),
            (int)(var4.getGreen() * var2 + var5.getGreen() * var6),
            (int)(var4.getBlue() * var2 + var5.getBlue() * var6),
            (int)(var4.getAlpha() * var2 + var5.getAlpha() * var6)
         )
         .getRGB();
   }

   private static int Ҍ(int param0, oc24a0a5bddf param1, oc24a0a5bddf param2, double param3, double param5) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 7
      // 05: iload 0
      // 06: iload 7
      // 08: ifne 84
      // 0b: tableswitch 110 0 4 34 47 47 52 93
      // 2c: athrow
      // 2d: dconst_0
      // 2e: invokestatic x/ocd2958dac48.ů (D)I
      // 31: aload 1
      // 32: invokevirtual x/oc24a0a5bddf.Ǣ ()I
      // 35: invokestatic x/oc7ab2161b9f.Ҭ (II)I
      // 38: ireturn
      // 39: athrow
      // 3a: aload 1
      // 3b: invokevirtual x/oc24a0a5bddf.ͳ ()I
      // 3e: ireturn
      // 3f: invokestatic java/lang/System.currentTimeMillis ()J
      // 42: l2d
      // 43: ldc2_w 1100.0
      // 46: dload 3
      // 47: ldc2_w 100.0
      // 4a: dmul
      // 4b: dsub
      // 4c: ddiv
      // 4d: invokestatic java/lang/Math.sin (D)D
      // 50: ldc2_w 0.5
      // 53: dmul
      // 54: ldc2_w 0.5
      // 57: dadd
      // 58: dstore 8
      // 5a: aload 1
      // 5b: invokevirtual x/oc24a0a5bddf.ͳ ()I
      // 5e: aload 2
      // 5f: invokevirtual x/oc24a0a5bddf.ͳ ()I
      // 62: dload 8
      // 64: invokestatic x/oc21e4c2f7ea.έ (IID)I
      // 67: ireturn
      // 68: dload 5
      // 6a: d2l
      // 6b: bipush 0
      // 6c: newarray 11
      // 6e: invokestatic x/oc7ab2161b9f.ƾ (J[J)I
      // 71: aload 1
      // 72: invokevirtual x/oc24a0a5bddf.Ǣ ()I
      // 75: invokestatic x/oc7ab2161b9f.Ҭ (II)I
      // 78: ireturn
      // 79: dconst_0
      // 7a: invokestatic x/ocd2958dac48.ů (D)I
      // 7d: aload 1
      // 7e: invokevirtual x/oc24a0a5bddf.Ǣ ()I
      // 81: invokestatic x/oc7ab2161b9f.Ҭ (II)I
      // 84: ireturn
   }

   private static int Ю(int param0, oc24a0a5bddf param1, oc24a0a5bddf param2, double param3, double param5) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 7
      // 05: iload 0
      // 06: iload 7
      // 08: ifne 65
      // 0b: lookupswitch 81 2 2 26 3 32
      // 24: athrow
      // 25: aload 2
      // 26: invokevirtual x/oc24a0a5bddf.ͳ ()I
      // 29: ireturn
      // 2a: athrow
      // 2b: invokestatic java/lang/System.currentTimeMillis ()J
      // 2e: ldc2_w 8493223923956457266
      // 31: ldc2_w 8493223923956457158
      // 34: lxor
      // 35: ladd
      // 36: l2d
      // 37: ldc2_w 1100.0
      // 3a: dload 3
      // 3b: ldc2_w 100.0
      // 3e: dmul
      // 3f: dsub
      // 40: ddiv
      // 41: invokestatic java/lang/Math.sin (D)D
      // 44: ldc2_w 0.5
      // 47: dmul
      // 48: ldc2_w 0.5
      // 4b: dadd
      // 4c: dstore 8
      // 4e: aload 1
      // 4f: invokevirtual x/oc24a0a5bddf.ͳ ()I
      // 52: aload 2
      // 53: invokevirtual x/oc24a0a5bddf.ͳ ()I
      // 56: dload 8
      // 58: invokestatic x/oc21e4c2f7ea.έ (IID)I
      // 5b: ireturn
      // 5c: iload 0
      // 5d: aload 1
      // 5e: aload 2
      // 5f: dload 3
      // 60: dload 5
      // 62: invokestatic x/oc21e4c2f7ea.Ҍ (ILx/oc24a0a5bddf;Lx/oc24a0a5bddf;DD)I
      // 65: ireturn
   }

   private static void ԍ(AxisAlignedBB param0, EnumFacing param1, int param2, int param3, int param4, int param5, boolean param6, boolean param7) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: invokestatic net/minecraft/client/renderer/Tessellator.getInstance ()Lnet/minecraft/client/renderer/Tessellator;
      // 06: astore 9
      // 08: istore 8
      // 0a: aload 9
      // 0c: invokevirtual net/minecraft/client/renderer/Tessellator.getWorldRenderer ()Lnet/minecraft/client/renderer/WorldRenderer;
      // 0f: astore 10
      // 11: iload 6
      // 13: iload 8
      // 15: ifne 42
      // 18: ifeq 40
      // 1b: goto 1f
      // 1e: athrow
      // 1f: aload 10
      // 21: ldc_w 285424074
      // 24: ldc_w 285424077
      // 27: ixor
      // 28: getstatic net/minecraft/client/renderer/vertex/DefaultVertexFormats.POSITION_COLOR Lnet/minecraft/client/renderer/vertex/VertexFormat;
      // 2b: invokevirtual net/minecraft/client/renderer/WorldRenderer.begin (ILnet/minecraft/client/renderer/vertex/VertexFormat;)V
      // 2e: aload 10
      // 30: aload 1
      // 31: aload 0
      // 32: iload 2
      // 33: iload 3
      // 34: invokestatic x/oc21e4c2f7ea.Ѳ (Lnet/minecraft/client/renderer/WorldRenderer;Lnet/minecraft/util/EnumFacing;Lnet/minecraft/util/AxisAlignedBB;II)V
      // 37: aload 9
      // 39: invokevirtual net/minecraft/client/renderer/Tessellator.draw ()V
      // 3c: goto 40
      // 3f: athrow
      // 40: iload 7
      // 42: ifeq 62
      // 45: aload 10
      // 47: bipush 1
      // 48: getstatic net/minecraft/client/renderer/vertex/DefaultVertexFormats.POSITION_COLOR Lnet/minecraft/client/renderer/vertex/VertexFormat;
      // 4b: invokevirtual net/minecraft/client/renderer/WorldRenderer.begin (ILnet/minecraft/client/renderer/vertex/VertexFormat;)V
      // 4e: aload 10
      // 50: aload 1
      // 51: aload 0
      // 52: iload 4
      // 54: iload 5
      // 56: invokestatic x/oc21e4c2f7ea.Ϡ (Lnet/minecraft/client/renderer/WorldRenderer;Lnet/minecraft/util/EnumFacing;Lnet/minecraft/util/AxisAlignedBB;II)V
      // 59: aload 9
      // 5b: invokevirtual net/minecraft/client/renderer/Tessellator.draw ()V
      // 5e: goto 62
      // 61: athrow
      // 62: return
   }

   private static void Ϡ(WorldRenderer param0, EnumFacing param1, AxisAlignedBB param2, int param3, int param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: aload 2
      // 004: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 007: dstore 6
      // 009: aload 2
      // 00a: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 00d: dstore 8
      // 00f: istore 5
      // 011: aload 2
      // 012: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 015: dstore 10
      // 017: iload 5
      // 019: aload 2
      // 01a: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 01d: dstore 12
      // 01f: aload 2
      // 020: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 023: dstore 14
      // 025: aload 2
      // 026: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 029: dstore 16
      // 02b: ifne 0bd
      // 02e: getstatic x/ocd248f47e94.ν [I
      // 031: aload 1
      // 032: invokevirtual net/minecraft/util/EnumFacing.ordinal ()I
      // 035: iaload
      // 036: tableswitch 640 1 6 39 140 241 342 443 544
      // 05c: athrow
      // 05d: aload 0
      // 05e: dload 6
      // 060: dload 14
      // 062: dload 16
      // 064: iload 3
      // 065: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 068: aload 0
      // 069: dload 12
      // 06b: dload 14
      // 06d: dload 16
      // 06f: iload 4
      // 071: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 074: aload 0
      // 075: dload 12
      // 077: dload 14
      // 079: dload 16
      // 07b: iload 4
      // 07d: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 080: aload 0
      // 081: dload 12
      // 083: dload 14
      // 085: dload 10
      // 087: iload 3
      // 088: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 08b: aload 0
      // 08c: dload 12
      // 08e: dload 14
      // 090: dload 10
      // 092: iload 3
      // 093: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 096: aload 0
      // 097: dload 6
      // 099: dload 14
      // 09b: dload 10
      // 09d: iload 4
      // 09f: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 0a2: aload 0
      // 0a3: dload 6
      // 0a5: dload 14
      // 0a7: dload 10
      // 0a9: iload 4
      // 0ab: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 0ae: aload 0
      // 0af: dload 6
      // 0b1: dload 14
      // 0b3: dload 16
      // 0b5: iload 3
      // 0b6: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 0b9: goto 0bd
      // 0bc: athrow
      // 0bd: iload 5
      // 0bf: ifeq 2b6
      // 0c2: aload 0
      // 0c3: dload 12
      // 0c5: dload 8
      // 0c7: dload 16
      // 0c9: iload 3
      // 0ca: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 0cd: iload 5
      // 0cf: aload 0
      // 0d0: dload 6
      // 0d2: dload 8
      // 0d4: dload 16
      // 0d6: iload 4
      // 0d8: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 0db: aload 0
      // 0dc: dload 6
      // 0de: dload 8
      // 0e0: dload 16
      // 0e2: iload 4
      // 0e4: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 0e7: aload 0
      // 0e8: dload 6
      // 0ea: dload 8
      // 0ec: dload 10
      // 0ee: iload 3
      // 0ef: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 0f2: aload 0
      // 0f3: dload 6
      // 0f5: dload 8
      // 0f7: dload 10
      // 0f9: iload 3
      // 0fa: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 0fd: aload 0
      // 0fe: dload 12
      // 100: dload 8
      // 102: dload 10
      // 104: iload 4
      // 106: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 109: aload 0
      // 10a: dload 12
      // 10c: dload 8
      // 10e: dload 10
      // 110: iload 4
      // 112: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 115: aload 0
      // 116: dload 12
      // 118: dload 8
      // 11a: dload 16
      // 11c: iload 3
      // 11d: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 120: ifeq 2b6
      // 123: goto 127
      // 126: athrow
      // 127: aload 0
      // 128: dload 12
      // 12a: dload 14
      // 12c: dload 10
      // 12e: iload 3
      // 12f: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 132: iload 5
      // 134: aload 0
      // 135: dload 12
      // 137: dload 8
      // 139: dload 10
      // 13b: iload 4
      // 13d: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 140: aload 0
      // 141: dload 12
      // 143: dload 8
      // 145: dload 10
      // 147: iload 4
      // 149: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 14c: aload 0
      // 14d: dload 6
      // 14f: dload 8
      // 151: dload 10
      // 153: iload 3
      // 154: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 157: aload 0
      // 158: dload 6
      // 15a: dload 8
      // 15c: dload 10
      // 15e: iload 3
      // 15f: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 162: aload 0
      // 163: dload 6
      // 165: dload 14
      // 167: dload 10
      // 169: iload 4
      // 16b: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 16e: aload 0
      // 16f: dload 6
      // 171: dload 14
      // 173: dload 10
      // 175: iload 4
      // 177: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 17a: aload 0
      // 17b: dload 12
      // 17d: dload 14
      // 17f: dload 10
      // 181: iload 3
      // 182: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 185: ifeq 2b6
      // 188: goto 18c
      // 18b: athrow
      // 18c: aload 0
      // 18d: dload 6
      // 18f: dload 14
      // 191: dload 16
      // 193: iload 3
      // 194: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 197: iload 5
      // 199: aload 0
      // 19a: dload 6
      // 19c: dload 8
      // 19e: dload 16
      // 1a0: iload 4
      // 1a2: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 1a5: aload 0
      // 1a6: dload 6
      // 1a8: dload 8
      // 1aa: dload 16
      // 1ac: iload 4
      // 1ae: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 1b1: aload 0
      // 1b2: dload 12
      // 1b4: dload 8
      // 1b6: dload 16
      // 1b8: iload 3
      // 1b9: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 1bc: aload 0
      // 1bd: dload 12
      // 1bf: dload 8
      // 1c1: dload 16
      // 1c3: iload 3
      // 1c4: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 1c7: aload 0
      // 1c8: dload 12
      // 1ca: dload 14
      // 1cc: dload 16
      // 1ce: iload 4
      // 1d0: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 1d3: aload 0
      // 1d4: dload 12
      // 1d6: dload 14
      // 1d8: dload 16
      // 1da: iload 4
      // 1dc: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 1df: aload 0
      // 1e0: dload 6
      // 1e2: dload 14
      // 1e4: dload 16
      // 1e6: iload 3
      // 1e7: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 1ea: ifeq 2b6
      // 1ed: goto 1f1
      // 1f0: athrow
      // 1f1: aload 0
      // 1f2: dload 12
      // 1f4: dload 14
      // 1f6: dload 10
      // 1f8: iload 3
      // 1f9: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 1fc: iload 5
      // 1fe: aload 0
      // 1ff: dload 12
      // 201: dload 14
      // 203: dload 16
      // 205: iload 4
      // 207: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 20a: aload 0
      // 20b: dload 12
      // 20d: dload 14
      // 20f: dload 16
      // 211: iload 4
      // 213: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 216: aload 0
      // 217: dload 12
      // 219: dload 8
      // 21b: dload 16
      // 21d: iload 3
      // 21e: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 221: aload 0
      // 222: dload 12
      // 224: dload 8
      // 226: dload 16
      // 228: iload 3
      // 229: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 22c: aload 0
      // 22d: dload 12
      // 22f: dload 8
      // 231: dload 10
      // 233: iload 4
      // 235: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 238: aload 0
      // 239: dload 12
      // 23b: dload 8
      // 23d: dload 10
      // 23f: iload 4
      // 241: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 244: aload 0
      // 245: dload 12
      // 247: dload 14
      // 249: dload 10
      // 24b: iload 3
      // 24c: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 24f: ifeq 2b6
      // 252: goto 256
      // 255: athrow
      // 256: aload 0
      // 257: dload 6
      // 259: dload 14
      // 25b: dload 16
      // 25d: iload 3
      // 25e: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 261: aload 0
      // 262: dload 6
      // 264: dload 14
      // 266: dload 10
      // 268: iload 4
      // 26a: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 26d: aload 0
      // 26e: dload 6
      // 270: dload 14
      // 272: dload 10
      // 274: iload 4
      // 276: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 279: aload 0
      // 27a: dload 6
      // 27c: dload 8
      // 27e: dload 10
      // 280: iload 3
      // 281: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 284: aload 0
      // 285: dload 6
      // 287: dload 8
      // 289: dload 10
      // 28b: iload 3
      // 28c: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 28f: aload 0
      // 290: dload 6
      // 292: dload 8
      // 294: dload 16
      // 296: iload 4
      // 298: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 29b: aload 0
      // 29c: dload 6
      // 29e: dload 8
      // 2a0: dload 16
      // 2a2: iload 4
      // 2a4: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 2a7: aload 0
      // 2a8: dload 6
      // 2aa: dload 14
      // 2ac: dload 16
      // 2ae: iload 3
      // 2af: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 2b2: goto 2b6
      // 2b5: athrow
      // 2b6: return
   }

   private static void ǥ(WorldRenderer var0, double var1, double var3, double var5, int var7) {
      var0.pos(var1, var3, var5)
         .color(
            var7 >> (471172994 ^ 471173010) & (471172973 ^ 471173010),
            var7 >> (471173018 ^ 471173010) & (471172973 ^ 471173010),
            var7 & (471172973 ^ 471173010),
            var7 >> (471173002 ^ 471173010) & (471172973 ^ 471173010)
         )
         .endVertex();
   }

   private static void Ѳ(WorldRenderer param0, EnumFacing param1, AxisAlignedBB param2, int param3, int param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: istore 5
      // 005: getstatic x/ocd248f47e94.ν [I
      // 008: aload 1
      // 009: invokevirtual net/minecraft/util/EnumFacing.ordinal ()I
      // 00c: iaload
      // 00d: tableswitch 508 1 6 39 118 197 276 355 434
      // 034: aload 0
      // 035: aload 2
      // 036: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 039: aload 2
      // 03a: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 03d: aload 2
      // 03e: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 041: iload 3
      // 042: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 045: iload 5
      // 047: aload 0
      // 048: aload 2
      // 049: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 04c: aload 2
      // 04d: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 050: aload 2
      // 051: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 054: iload 4
      // 056: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 059: aload 0
      // 05a: aload 2
      // 05b: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 05e: aload 2
      // 05f: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 062: aload 2
      // 063: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 066: iload 3
      // 067: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 06a: aload 0
      // 06b: aload 2
      // 06c: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 06f: aload 2
      // 070: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 073: aload 2
      // 074: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 077: iload 4
      // 079: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 07c: ifeq 209
      // 07f: goto 083
      // 082: athrow
      // 083: aload 0
      // 084: aload 2
      // 085: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 088: aload 2
      // 089: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 08c: aload 2
      // 08d: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 090: iload 3
      // 091: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 094: iload 5
      // 096: aload 0
      // 097: aload 2
      // 098: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 09b: aload 2
      // 09c: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 09f: aload 2
      // 0a0: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 0a3: iload 4
      // 0a5: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 0a8: aload 0
      // 0a9: aload 2
      // 0aa: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 0ad: aload 2
      // 0ae: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 0b1: aload 2
      // 0b2: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 0b5: iload 3
      // 0b6: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 0b9: aload 0
      // 0ba: aload 2
      // 0bb: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 0be: aload 2
      // 0bf: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 0c2: aload 2
      // 0c3: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 0c6: iload 4
      // 0c8: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 0cb: ifeq 209
      // 0ce: goto 0d2
      // 0d1: athrow
      // 0d2: aload 0
      // 0d3: aload 2
      // 0d4: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 0d7: aload 2
      // 0d8: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 0db: aload 2
      // 0dc: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 0df: iload 3
      // 0e0: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 0e3: iload 5
      // 0e5: aload 0
      // 0e6: aload 2
      // 0e7: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 0ea: aload 2
      // 0eb: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 0ee: aload 2
      // 0ef: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 0f2: iload 4
      // 0f4: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 0f7: aload 0
      // 0f8: aload 2
      // 0f9: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 0fc: aload 2
      // 0fd: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 100: aload 2
      // 101: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 104: iload 3
      // 105: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 108: aload 0
      // 109: aload 2
      // 10a: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 10d: aload 2
      // 10e: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 111: aload 2
      // 112: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 115: iload 4
      // 117: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 11a: ifeq 209
      // 11d: goto 121
      // 120: athrow
      // 121: aload 0
      // 122: aload 2
      // 123: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 126: aload 2
      // 127: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 12a: aload 2
      // 12b: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 12e: iload 3
      // 12f: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 132: iload 5
      // 134: aload 0
      // 135: aload 2
      // 136: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 139: aload 2
      // 13a: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 13d: aload 2
      // 13e: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 141: iload 4
      // 143: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 146: aload 0
      // 147: aload 2
      // 148: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 14b: aload 2
      // 14c: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 14f: aload 2
      // 150: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 153: iload 3
      // 154: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 157: aload 0
      // 158: aload 2
      // 159: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 15c: aload 2
      // 15d: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 160: aload 2
      // 161: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 164: iload 4
      // 166: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 169: ifeq 209
      // 16c: goto 170
      // 16f: athrow
      // 170: aload 0
      // 171: aload 2
      // 172: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 175: aload 2
      // 176: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 179: aload 2
      // 17a: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 17d: iload 3
      // 17e: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 181: iload 5
      // 183: aload 0
      // 184: aload 2
      // 185: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 188: aload 2
      // 189: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 18c: aload 2
      // 18d: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 190: iload 4
      // 192: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 195: aload 0
      // 196: aload 2
      // 197: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 19a: aload 2
      // 19b: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 19e: aload 2
      // 19f: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 1a2: iload 3
      // 1a3: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 1a6: aload 0
      // 1a7: aload 2
      // 1a8: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 1ab: aload 2
      // 1ac: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 1af: aload 2
      // 1b0: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 1b3: iload 4
      // 1b5: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 1b8: ifeq 209
      // 1bb: goto 1bf
      // 1be: athrow
      // 1bf: aload 0
      // 1c0: aload 2
      // 1c1: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 1c4: aload 2
      // 1c5: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 1c8: aload 2
      // 1c9: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 1cc: iload 3
      // 1cd: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 1d0: aload 0
      // 1d1: aload 2
      // 1d2: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 1d5: aload 2
      // 1d6: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 1d9: aload 2
      // 1da: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 1dd: iload 4
      // 1df: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 1e2: aload 0
      // 1e3: aload 2
      // 1e4: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 1e7: aload 2
      // 1e8: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 1eb: aload 2
      // 1ec: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 1ef: iload 3
      // 1f0: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 1f3: aload 0
      // 1f4: aload 2
      // 1f5: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 1f8: aload 2
      // 1f9: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 1fc: aload 2
      // 1fd: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 200: iload 4
      // 202: invokestatic x/oc21e4c2f7ea.ǥ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 205: goto 209
      // 208: athrow
      // 209: return
   }

   static {
      String[] var10000 = new String[-1011479415 ^ -1011479412];
      var10000[0] = "HUD";
      var10000[1] = "Static";
      var10000[-1011479410 ^ -1011479412] = "Gradient";
      var10000[-1011479409 ^ -1011479412] = "Fade";
      var10000[-1011479416 ^ -1011479412] = "Chroma";
      Ԡ = var10000;
   }
}

package x;

import java.awt.Color;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.util.Vec3i;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class ocbd4917c4b1 implements ocda171fe5d8 {
   private static Frustum y = new Frustum();
   private static final FloatBuffer Ǽ = BufferUtils.createFloatBuffer(-2115189500 ^ -2115189484);
   private static final FloatBuffer ս = BufferUtils.createFloatBuffer(-2115189500 ^ -2115189484);
   private static final IntBuffer Խ = BufferUtils.createIntBuffer(-2115189500 ^ -2115189484);
   private static final FloatBuffer Ϩ = BufferUtils.createFloatBuffer(-2115189481 ^ -2115189484);
   private static final int ʄ = 4;
   private static final IntBuffer Ĭ = BufferUtils.createIntBuffer(-2115189500 ^ -2115189484);
   private static final int[][] Ð = new int[-2115189488 ^ -2115189484][-2115189487 ^ -2115189484];
   private static int ɷ = 0;
   private static final Map<String, ResourceLocation> ɻ = new HashMap<>();
   public static boolean Ԧ;

   public static void ь(BlockPos var0, int var1, boolean var2, boolean var3) {
      ǩ(var0.getX(), var0.getY(), var0.getZ(), 1.0, 1.0, 1.0, var1, var2, var3);
   }

   public static void ա(BlockPos var0, int var1, boolean var2, boolean var3) {
      ǩ(var0.getX() + 0.0625F, var0.getY(), var0.getZ() + 0.0625F, 0.875, 0.875, 0.875, var1, var2, var3);
   }

   public static void ֆ(List<BlockPos> var0, int var1, boolean var2, boolean var3) {
      Ƽ(var0, var1, var1, var2, var3);
   }

   public static void Ƽ(List<BlockPos> param0, int param1, int param2, boolean param3, boolean param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 5
      // 005: aload 0
      // 006: iload 5
      // 008: ifne 013
      // 00b: ifnull 01b
      // 00e: goto 012
      // 011: athrow
      // 012: aload 0
      // 013: invokeinterface java/util/List.isEmpty ()Z 1
      // 018: ifeq 01d
      // 01b: return
      // 01c: athrow
      // 01d: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 020: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 023: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosX D
      // 026: dstore 6
      // 028: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 02b: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 02e: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosY D
      // 031: dstore 8
      // 033: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 036: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 039: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosZ D
      // 03c: dstore 10
      // 03e: invokestatic org/lwjgl/opengl/GL11.glPushMatrix ()V
      // 041: ldc -2015218380
      // 043: ldc -2015218122
      // 045: ixor
      // 046: ldc -2015218379
      // 048: ldc -2015218122
      // 04a: ixor
      // 04b: invokestatic org/lwjgl/opengl/GL11.glBlendFunc (II)V
      // 04e: ldc -2015216172
      // 050: ldc -2015218122
      // 052: ixor
      // 053: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 056: fconst_2
      // 057: invokestatic org/lwjgl/opengl/GL11.glLineWidth (F)V
      // 05a: ldc -2015216681
      // 05c: ldc -2015218122
      // 05e: ixor
      // 05f: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 062: ldc -2015216313
      // 064: ldc -2015218122
      // 066: ixor
      // 067: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 06a: bipush 0
      // 06b: invokestatic org/lwjgl/opengl/GL11.glDepthMask (Z)V
      // 06e: iload 1
      // 06f: ldc -2015218130
      // 071: ldc -2015218122
      // 073: ixor
      // 074: ishr
      // 075: ldc -2015217975
      // 077: ldc -2015218122
      // 079: ixor
      // 07a: iand
      // 07b: i2f
      // 07c: ldc 255.0
      // 07e: fdiv
      // 07f: fstore 12
      // 081: iload 1
      // 082: ldc -2015218138
      // 084: ldc -2015218122
      // 086: ixor
      // 087: ishr
      // 088: ldc -2015217975
      // 08a: ldc -2015218122
      // 08c: ixor
      // 08d: iand
      // 08e: i2f
      // 08f: ldc 255.0
      // 091: fdiv
      // 092: fstore 13
      // 094: iload 1
      // 095: ldc -2015218114
      // 097: ldc -2015218122
      // 099: ixor
      // 09a: ishr
      // 09b: ldc -2015217975
      // 09d: ldc -2015218122
      // 09f: ixor
      // 0a0: iand
      // 0a1: i2f
      // 0a2: ldc 255.0
      // 0a4: fdiv
      // 0a5: fstore 14
      // 0a7: iload 1
      // 0a8: ldc -2015217975
      // 0aa: ldc -2015218122
      // 0ac: ixor
      // 0ad: iand
      // 0ae: i2f
      // 0af: ldc 255.0
      // 0b1: fdiv
      // 0b2: fstore 15
      // 0b4: iload 2
      // 0b5: ldc -2015218130
      // 0b7: ldc -2015218122
      // 0b9: ixor
      // 0ba: ishr
      // 0bb: ldc -2015217975
      // 0bd: ldc -2015218122
      // 0bf: ixor
      // 0c0: iand
      // 0c1: i2f
      // 0c2: ldc 255.0
      // 0c4: fdiv
      // 0c5: fstore 16
      // 0c7: iload 2
      // 0c8: ldc -2015218138
      // 0ca: ldc -2015218122
      // 0cc: ixor
      // 0cd: ishr
      // 0ce: ldc -2015217975
      // 0d0: ldc -2015218122
      // 0d2: ixor
      // 0d3: iand
      // 0d4: i2f
      // 0d5: ldc 255.0
      // 0d7: fdiv
      // 0d8: fstore 17
      // 0da: iload 2
      // 0db: ldc -2015218114
      // 0dd: ldc -2015218122
      // 0df: ixor
      // 0e0: ishr
      // 0e1: ldc -2015217975
      // 0e3: ldc -2015218122
      // 0e5: ixor
      // 0e6: iand
      // 0e7: i2f
      // 0e8: ldc 255.0
      // 0ea: fdiv
      // 0eb: fstore 18
      // 0ed: iload 2
      // 0ee: ldc -2015217975
      // 0f0: ldc -2015218122
      // 0f2: ixor
      // 0f3: iand
      // 0f4: i2f
      // 0f5: ldc 255.0
      // 0f7: fdiv
      // 0f8: fstore 19
      // 0fa: aload 0
      // 0fb: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 100: astore 20
      // 102: aload 20
      // 104: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 109: ifeq 1a3
      // 10c: aload 20
      // 10e: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 113: checkcast net/minecraft/util/BlockPos
      // 116: astore 21
      // 118: aload 21
      // 11a: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 11d: i2d
      // 11e: ldc2_w 0.0625
      // 121: dadd
      // 122: dload 6
      // 124: dsub
      // 125: dstore 22
      // 127: aload 21
      // 129: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 12c: i2d
      // 12d: dload 8
      // 12f: dsub
      // 130: dstore 24
      // 132: aload 21
      // 134: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 137: iload 5
      // 139: ifne 1c3
      // 13c: i2d
      // 13d: ldc2_w 0.0625
      // 140: dadd
      // 141: dload 10
      // 143: dsub
      // 144: dstore 26
      // 146: new net/minecraft/util/AxisAlignedBB
      // 149: dup
      // 14a: dload 22
      // 14c: dload 24
      // 14e: dload 26
      // 150: dload 22
      // 152: ldc2_w 0.875
      // 155: dadd
      // 156: dload 24
      // 158: ldc2_w 0.875
      // 15b: dadd
      // 15c: dload 26
      // 15e: ldc2_w 0.875
      // 161: dadd
      // 162: invokespecial net/minecraft/util/AxisAlignedBB.<init> (DDDDDD)V
      // 165: astore 28
      // 167: iload 3
      // 168: iload 5
      // 16a: ifne 18a
      // 16d: ifeq 188
      // 170: goto 174
      // 173: athrow
      // 174: fload 13
      // 176: fload 14
      // 178: fload 15
      // 17a: fload 12
      // 17c: invokestatic org/lwjgl/opengl/GL11.glColor4f (FFFF)V
      // 17f: aload 28
      // 181: invokestatic net/minecraft/client/renderer/RenderGlobal.drawSelectionBoundingBox (Lnet/minecraft/util/AxisAlignedBB;)V
      // 184: goto 188
      // 187: athrow
      // 188: iload 4
      // 18a: ifeq 19e
      // 18d: aload 28
      // 18f: fload 17
      // 191: fload 18
      // 193: fload 19
      // 195: fload 16
      // 197: invokestatic x/ocbd4917c4b1.ʓ (Lnet/minecraft/util/AxisAlignedBB;FFFF)V
      // 19a: goto 19e
      // 19d: athrow
      // 19e: iload 5
      // 1a0: ifeq 102
      // 1a3: fconst_1
      // 1a4: fconst_1
      // 1a5: fconst_1
      // 1a6: fconst_1
      // 1a7: invokestatic org/lwjgl/opengl/GL11.glColor4f (FFFF)V
      // 1aa: ldc -2015216681
      // 1ac: ldc -2015218122
      // 1ae: ixor
      // 1af: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 1b2: ldc -2015216313
      // 1b4: ldc -2015218122
      // 1b6: ixor
      // 1b7: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 1ba: bipush 1
      // 1bb: invokestatic org/lwjgl/opengl/GL11.glDepthMask (Z)V
      // 1be: ldc -2015216172
      // 1c0: ldc -2015218122
      // 1c2: ixor
      // 1c3: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 1c6: invokestatic org/lwjgl/opengl/GL11.glPopMatrix ()V
      // 1c9: return
   }

   public static void ҡ(BlockPos var0, int var1, double var2, boolean var4, boolean var5) {
      ǩ(var0.getX(), var0.getY(), var0.getZ(), 1.0, var2, 1.0, var1, var4, var5);
   }

   public static void Ԣ(double var0, double var2, double var4, double var6) {
      double var9 = oc2c25634a7e.Ɩ();
      var0 *= var9;
      var2 *= var9;
      int var10000 = oc75d51ec7eb.ϩ;
      var4 *= var9;
      var6 *= var9;
      ScaledResolution var11 = new ScaledResolution(ocda171fe5d8.ǔ);
      int var12 = var11.getScaleFactor();
      double var13 = var11.getScaledHeight();
      int var15 = (int)Math.floor(var0 * var12);
      int var16 = (int)Math.ceil((var0 + var4) * var12);
      int var17 = Math.max(0, var16 - var15);
      double var18 = var2 + var6;
      int var20 = (int)Math.floor((var13 - var18) * var12);
      int var21 = (int)Math.ceil((var13 - var2) * var12);
      int var8 = var10000;
      int var22 = Math.max(0, var21 - var20);

      label34: {
         try {
            var10000 = var17;
            if (var8 != 0) {
               break label34;
            }

            if (var17 < 0) {
               return;
            }
         } catch (IllegalStateException var24) {
            throw var24;
         }

         var10000 = var22;
      }

      label28: {
         try {
            if (var8 != 0) {
               break label28;
            }

            if (var10000 < 0) {
               return;
            }
         } catch (IllegalStateException var23) {
            throw var23;
         }

         var10000 = var15;
      }

      GL11.glScissor(var10000, var20, var17, var22);
   }

   public static void Ď(double param0, double param2, double param4, double param6) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: invokestatic x/oc2c25634a7e.Ɩ ()D
      // 003: dstore 9
      // 005: getstatic x/oc75d51ec7eb.ϩ I
      // 008: dload 0
      // 009: dload 9
      // 00b: dmul
      // 00c: dstore 0
      // 00d: dload 2
      // 00e: dload 9
      // 010: dmul
      // 011: dstore 2
      // 012: dload 4
      // 014: dload 9
      // 016: dmul
      // 017: dstore 4
      // 019: dload 6
      // 01b: dload 9
      // 01d: dmul
      // 01e: dstore 6
      // 020: new net/minecraft/client/gui/ScaledResolution
      // 023: dup
      // 024: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 027: invokespecial net/minecraft/client/gui/ScaledResolution.<init> (Lnet/minecraft/client/Minecraft;)V
      // 02a: astore 11
      // 02c: aload 11
      // 02e: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaleFactor ()I
      // 031: istore 12
      // 033: istore 8
      // 035: aload 11
      // 037: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledHeight ()I
      // 03a: i2d
      // 03b: dstore 13
      // 03d: dload 0
      // 03e: iload 12
      // 040: i2d
      // 041: dmul
      // 042: invokestatic java/lang/Math.floor (D)D
      // 045: d2i
      // 046: istore 15
      // 048: dload 0
      // 049: dload 4
      // 04b: dadd
      // 04c: iload 12
      // 04e: i2d
      // 04f: dmul
      // 050: invokestatic java/lang/Math.ceil (D)D
      // 053: d2i
      // 054: istore 16
      // 056: bipush 0
      // 057: iload 16
      // 059: iload 15
      // 05b: isub
      // 05c: invokestatic java/lang/Math.max (II)I
      // 05f: istore 17
      // 061: dload 2
      // 062: dload 6
      // 064: dadd
      // 065: dstore 18
      // 067: dload 13
      // 069: dload 18
      // 06b: dsub
      // 06c: iload 12
      // 06e: i2d
      // 06f: dmul
      // 070: invokestatic java/lang/Math.floor (D)D
      // 073: d2i
      // 074: istore 20
      // 076: dload 13
      // 078: dload 2
      // 079: dsub
      // 07a: iload 12
      // 07c: i2d
      // 07d: dmul
      // 07e: invokestatic java/lang/Math.ceil (D)D
      // 081: d2i
      // 082: istore 21
      // 084: bipush 0
      // 085: iload 21
      // 087: iload 20
      // 089: isub
      // 08a: invokestatic java/lang/Math.max (II)I
      // 08d: istore 22
      // 08f: ldc -1219063907
      // 091: ldc -1219066996
      // 093: ixor
      // 094: invokestatic org/lwjgl/opengl/GL11.glIsEnabled (I)Z
      // 097: istore 23
      // 099: getstatic x/ocbd4917c4b1.Ð [[I
      // 09c: getstatic x/ocbd4917c4b1.ɷ I
      // 09f: dup
      // 0a0: bipush 1
      // 0a1: iadd
      // 0a2: putstatic x/ocbd4917c4b1.ɷ I
      // 0a5: aaload
      // 0a6: astore 24
      // 0a8: getstatic x/ocbd4917c4b1.ɷ I
      // 0ab: iload 8
      // 0ad: ifne 0c9
      // 0b0: ldc -1219067000
      // 0b2: ldc -1219066996
      // 0b4: ixor
      // 0b5: if_icmple 0c7
      // 0b8: goto 0bc
      // 0bb: athrow
      // 0bc: new java/lang/IllegalStateException
      // 0bf: dup
      // 0c0: ldc "Scissor stack overflow"
      // 0c2: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 0c5: athrow
      // 0c6: athrow
      // 0c7: iload 23
      // 0c9: iload 8
      // 0cb: ifne 1b0
      // 0ce: ifeq 19d
      // 0d1: goto 0d5
      // 0d4: athrow
      // 0d5: getstatic x/ocbd4917c4b1.Ĭ Ljava/nio/IntBuffer;
      // 0d8: invokevirtual java/nio/Buffer.clear ()Ljava/nio/Buffer;
      // 0db: pop
      // 0dc: iload 8
      // 0de: ldc -1219063908
      // 0e0: ldc -1219066996
      // 0e2: ixor
      // 0e3: getstatic x/ocbd4917c4b1.Ĭ Ljava/nio/IntBuffer;
      // 0e6: invokestatic x/oc30aea91d28.Թ (ILjava/nio/IntBuffer;)V
      // 0e9: aload 24
      // 0eb: bipush 0
      // 0ec: bipush 1
      // 0ed: iastore
      // 0ee: aload 24
      // 0f0: bipush 1
      // 0f1: getstatic x/ocbd4917c4b1.Ĭ Ljava/nio/IntBuffer;
      // 0f4: bipush 0
      // 0f5: invokevirtual java/nio/IntBuffer.get (I)I
      // 0f8: iastore
      // 0f9: aload 24
      // 0fb: ldc_w -1219066994
      // 0fe: ldc -1219066996
      // 100: ixor
      // 101: getstatic x/ocbd4917c4b1.Ĭ Ljava/nio/IntBuffer;
      // 104: bipush 1
      // 105: invokevirtual java/nio/IntBuffer.get (I)I
      // 108: iastore
      // 109: aload 24
      // 10b: ldc_w -1219066993
      // 10e: ldc -1219066996
      // 110: ixor
      // 111: getstatic x/ocbd4917c4b1.Ĭ Ljava/nio/IntBuffer;
      // 114: ldc_w -1219066994
      // 117: ldc -1219066996
      // 119: ixor
      // 11a: invokevirtual java/nio/IntBuffer.get (I)I
      // 11d: iastore
      // 11e: aload 24
      // 120: ldc -1219067000
      // 122: ldc -1219066996
      // 124: ixor
      // 125: getstatic x/ocbd4917c4b1.Ĭ Ljava/nio/IntBuffer;
      // 128: ldc_w -1219066993
      // 12b: ldc -1219066996
      // 12d: ixor
      // 12e: invokevirtual java/nio/IntBuffer.get (I)I
      // 131: iastore
      // 132: aload 24
      // 134: bipush 1
      // 135: iaload
      // 136: iload 15
      // 138: invokestatic java/lang/Math.max (II)I
      // 13b: istore 25
      // 13d: aload 24
      // 13f: ldc_w -1219066994
      // 142: ldc -1219066996
      // 144: ixor
      // 145: iaload
      // 146: iload 20
      // 148: invokestatic java/lang/Math.max (II)I
      // 14b: istore 26
      // 14d: bipush 0
      // 14e: aload 24
      // 150: bipush 1
      // 151: iaload
      // 152: aload 24
      // 154: ldc_w -1219066993
      // 157: ldc -1219066996
      // 159: ixor
      // 15a: iaload
      // 15b: iadd
      // 15c: iload 15
      // 15e: iload 17
      // 160: iadd
      // 161: invokestatic java/lang/Math.min (II)I
      // 164: iload 25
      // 166: isub
      // 167: invokestatic java/lang/Math.max (II)I
      // 16a: istore 27
      // 16c: bipush 0
      // 16d: aload 24
      // 16f: ldc_w -1219066994
      // 172: ldc -1219066996
      // 174: ixor
      // 175: iaload
      // 176: aload 24
      // 178: ldc -1219067000
      // 17a: ldc -1219066996
      // 17c: ixor
      // 17d: iaload
      // 17e: iadd
      // 17f: iload 20
      // 181: iload 22
      // 183: iadd
      // 184: invokestatic java/lang/Math.min (II)I
      // 187: iload 26
      // 189: isub
      // 18a: invokestatic java/lang/Math.max (II)I
      // 18d: istore 28
      // 18f: iload 25
      // 191: iload 26
      // 193: iload 27
      // 195: iload 28
      // 197: invokestatic org/lwjgl/opengl/GL11.glScissor (IIII)V
      // 19a: ifeq 1b9
      // 19d: aload 24
      // 19f: bipush 0
      // 1a0: bipush 0
      // 1a1: iastore
      // 1a2: ldc -1219063907
      // 1a4: ldc -1219066996
      // 1a6: ixor
      // 1a7: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 1aa: iload 15
      // 1ac: goto 1b0
      // 1af: athrow
      // 1b0: iload 20
      // 1b2: iload 17
      // 1b4: iload 22
      // 1b6: invokestatic org/lwjgl/opengl/GL11.glScissor (IIII)V
      // 1b9: return
   }

   public static void ǟ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: getstatic x/ocbd4917c4b1.Ð [[I
      // 06: getstatic x/ocbd4917c4b1.ɷ I
      // 09: bipush 1
      // 0a: isub
      // 0b: dup
      // 0c: putstatic x/ocbd4917c4b1.ɷ I
      // 0f: aaload
      // 10: astore 1
      // 11: istore 0
      // 12: aload 1
      // 13: bipush 0
      // 14: iaload
      // 15: iload 0
      // 16: ifne 55
      // 19: bipush 1
      // 1a: if_icmpne 4a
      // 1d: goto 21
      // 20: athrow
      // 21: aload 1
      // 22: bipush 1
      // 23: iaload
      // 24: aload 1
      // 25: ldc_w 660339277
      // 28: ldc_w 660339279
      // 2b: ixor
      // 2c: iaload
      // 2d: aload 1
      // 2e: ldc_w 660339276
      // 31: ldc_w 660339279
      // 34: ixor
      // 35: iaload
      // 36: aload 1
      // 37: ldc_w 660339275
      // 3a: ldc_w 660339279
      // 3d: ixor
      // 3e: iaload
      // 3f: invokestatic org/lwjgl/opengl/GL11.glScissor (IIII)V
      // 42: iload 0
      // 43: ifeq 58
      // 46: goto 4a
      // 49: athrow
      // 4a: ldc_w 660338270
      // 4d: ldc_w 660339279
      // 50: ixor
      // 51: goto 55
      // 54: athrow
      // 55: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 58: return
   }

   public static boolean ž(Entity param0) {
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
      // 10: bipush 0
      // 11: ireturn
      // 12: athrow
      // 13: aload 0
      // 14: invokevirtual net/minecraft/entity/Entity.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 17: invokestatic x/ocbd4917c4b1.ӥ (Lnet/minecraft/util/AxisAlignedBB;)Z
      // 1a: iload 1
      // 1b: ifne 39
      // 1e: ifne 38
      // 21: goto 25
      // 24: athrow
      // 25: aload 0
      // 26: getfield net/minecraft/entity/Entity.ignoreFrustumCheck Z
      // 29: iload 1
      // 2a: ifne 39
      // 2d: goto 31
      // 30: athrow
      // 31: ifeq 3c
      // 34: goto 38
      // 37: athrow
      // 38: bipush 1
      // 39: goto 3d
      // 3c: bipush 0
      // 3d: ireturn
   }

   public static boolean ӥ(AxisAlignedBB param0) {
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
      // 05: ifnonnull 0b
      // 08: bipush 0
      // 09: ireturn
      // 0a: athrow
      // 0b: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 0e: invokevirtual net/minecraft/client/Minecraft.getRenderViewEntity ()Lnet/minecraft/entity/Entity;
      // 11: astore 2
      // 12: iload 1
      // 13: ifne 33
      // 16: aload 2
      // 17: ifnonnull 21
      // 1a: goto 1e
      // 1d: athrow
      // 1e: bipush 1
      // 1f: ireturn
      // 20: athrow
      // 21: getstatic x/ocbd4917c4b1.y Lnet/minecraft/client/renderer/culling/Frustum;
      // 24: aload 2
      // 25: getfield net/minecraft/entity/Entity.posX D
      // 28: aload 2
      // 29: getfield net/minecraft/entity/Entity.posY D
      // 2c: aload 2
      // 2d: getfield net/minecraft/entity/Entity.posZ D
      // 30: invokevirtual net/minecraft/client/renderer/culling/Frustum.setPosition (DDD)V
      // 33: getstatic x/ocbd4917c4b1.y Lnet/minecraft/client/renderer/culling/Frustum;
      // 36: aload 0
      // 37: invokevirtual net/minecraft/client/renderer/culling/Frustum.isBoundingBoxInFrustum (Lnet/minecraft/util/AxisAlignedBB;)Z
      // 3a: ireturn
   }

   public static boolean Ϗ(Entity param0, double param1) {
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
      // 06: ifne 19
      // 09: ifnonnull 13
      // 0c: goto 10
      // 0f: athrow
      // 10: bipush 0
      // 11: ireturn
      // 12: athrow
      // 13: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 16: invokevirtual net/minecraft/client/Minecraft.getRenderViewEntity ()Lnet/minecraft/entity/Entity;
      // 19: astore 4
      // 1b: aload 4
      // 1d: iload 3
      // 1e: ifne 2c
      // 21: ifnonnull 2b
      // 24: goto 28
      // 27: athrow
      // 28: bipush 0
      // 29: ireturn
      // 2a: athrow
      // 2b: aload 0
      // 2c: aload 4
      // 2e: invokevirtual net/minecraft/entity/Entity.getDistanceSqToEntity (Lnet/minecraft/entity/Entity;)D
      // 31: dload 1
      // 32: dcmpg
      // 33: iload 3
      // 34: ifne 3f
      // 37: ifgt 42
      // 3a: goto 3e
      // 3d: athrow
      // 3e: bipush 1
      // 3f: goto 43
      // 42: bipush 0
      // 43: ireturn
   }

   public static boolean ӹ(BlockPos var0, double var1) {
      int var3 = oc75d51ec7eb.ϩ;

      try {
         if (var0 == null) {
            return false;
         }
      } catch (IllegalStateException var13) {
         throw var13;
      }

      Entity var4 = ocda171fe5d8.ǔ.getRenderViewEntity();

      try {
         if (var4 == null) {
            return false;
         }
      } catch (IllegalStateException var12) {
         throw var12;
      }

      double var5 = var0.getX() + 0.5 - var4.posX;
      double var7 = var0.getY() + 0.5 - var4.posY;
      double var9 = var0.getZ() + 0.5 - var4.posZ;

      try {
         double var14;
         int var10000 = (var14 = var5 * var5 + var7 * var7 + var9 * var9 - var1) == 0.0 ? 0 : (var14 < 0.0 ? -1 : 1);
         if (var3 != 0) {
            return (boolean)var10000;
         }

         if (var10000 <= 0) {
            return (boolean)1;
         }
      } catch (IllegalStateException var11) {
         throw var11;
      }

      return (boolean)0;
   }

   public static void ĉ(double var0, double var2, double var4, double var6, int var8) {
      float var9 = (var8 >> (885020164 ^ 885020188) & (885020387 ^ 885020188)) / 255.0F;
      float var10 = (var8 >> (885020172 ^ 885020188) & (885020387 ^ 885020188)) / 255.0F;
      float var11 = (var8 >> (885020180 ^ 885020188) & (885020387 ^ 885020188)) / 255.0F;
      float var12 = (var8 & (885020387 ^ 885020188)) / 255.0F;
      GlStateManager.pushMatrix();
      Tessellator var13 = Tessellator.getInstance();
      WorldRenderer var14 = var13.getWorldRenderer();
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(885019934 ^ 885020188, 885019935 ^ 885020188, 1, 0);
      GlStateManager.color(var10, var11, var12, var9);
      var14.begin(885020187 ^ 885020188, DefaultVertexFormats.POSITION);
      var14.pos(var0, var6, 0.0).endVertex();
      var14.pos(var4, var6, 0.0).endVertex();
      var14.pos(var4, var2, 0.0).endVertex();
      var14.pos(var0, var2, 0.0).endVertex();
      var13.draw();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.popMatrix();
   }

   public static void đ(Vec3 var0, int var1) {
      GlStateManager.pushMatrix();
      double var2 = var0.xCoord - ocda171fe5d8.ǔ.getRenderManager().viewerPosX;
      double var4 = var0.yCoord - ocda171fe5d8.ǔ.getRenderManager().viewerPosY;
      double var6 = var0.zCoord - ocda171fe5d8.ǔ.getRenderManager().viewerPosZ;
      AxisAlignedBB var8 = ocda171fe5d8.ǔ.thePlayer.getEntityBoundingBox().expand(0.1, 0.1, 0.1);
      AxisAlignedBB var9 = new AxisAlignedBB(
         var8.minX - ocda171fe5d8.ǔ.thePlayer.posX + var2,
         var8.minY - ocda171fe5d8.ǔ.thePlayer.posY + var4,
         var8.minZ - ocda171fe5d8.ǔ.thePlayer.posZ + var6,
         var8.maxX - ocda171fe5d8.ǔ.thePlayer.posX + var2,
         var8.maxY - ocda171fe5d8.ǔ.thePlayer.posY + var4,
         var8.maxZ - ocda171fe5d8.ǔ.thePlayer.posZ + var6
      );
      float var10 = (var1 >> (1693782750 ^ 1693782726) & (1693782585 ^ 1693782726)) / 255.0F;
      float var11 = (var1 >> (1693782742 ^ 1693782726) & (1693782585 ^ 1693782726)) / 255.0F;
      float var12 = (var1 >> (1693782734 ^ 1693782726) & (1693782585 ^ 1693782726)) / 255.0F;
      float var13 = (var1 & (1693782585 ^ 1693782726)) / 255.0F;
      GL11.glBlendFunc(1693782468 ^ 1693782726, 1693782469 ^ 1693782726);
      GL11.glEnable(1693784356 ^ 1693782726);
      GL11.glDisable(1693785895 ^ 1693782726);
      GL11.glDisable(1693784503 ^ 1693782726);
      GL11.glDepthMask(false);
      GL11.glLineWidth(2.0F);
      GL11.glColor4f(var11, var12, var13, var10);
      ʓ(var9, var11, var12, var13, var10);
      GL11.glEnable(1693785895 ^ 1693782726);
      GL11.glEnable(1693784503 ^ 1693782726);
      GL11.glDepthMask(true);
      GL11.glDisable(1693784356 ^ 1693782726);
      GlStateManager.popMatrix();
   }

   public static int Ն(EntityPlayer param0, float param1) {
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
      // 05: ifnull 15
      // 08: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 0b: getfield net/minecraft/client/Minecraft.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // 0e: ifnonnull 2c
      // 11: goto 15
      // 14: athrow
      // 15: ldc_w 149147845
      // 18: ldc_w 136064826
      // 1b: ixor
      // 1c: fload 1
      // 1d: ldc 255.0
      // 1f: fmul
      // 20: f2i
      // 21: ldc_w 136064802
      // 24: ldc_w 136064826
      // 27: ixor
      // 28: ishl
      // 29: ior
      // 2a: ireturn
      // 2b: athrow
      // 2c: ldc_w 149147845
      // 2f: ldc_w 136064826
      // 32: ixor
      // 33: istore 3
      // 34: aload 0
      // 35: invokevirtual net/minecraft/entity/player/EntityPlayer.getTeam ()Lnet/minecraft/scoreboard/Team;
      // 38: checkcast net/minecraft/scoreboard/ScorePlayerTeam
      // 3b: astore 4
      // 3d: aload 4
      // 3f: iload 2
      // 40: ifne 4c
      // 43: ifnull 7b
      // 46: goto 4a
      // 49: athrow
      // 4a: aload 4
      // 4c: invokevirtual net/minecraft/scoreboard/ScorePlayerTeam.getColorPrefix ()Ljava/lang/String;
      // 4f: invokestatic net/minecraft/client/gui/FontRenderer.getFormatFromString (Ljava/lang/String;)Ljava/lang/String;
      // 52: astore 5
      // 54: aload 5
      // 56: invokevirtual java/lang/String.length ()I
      // 59: iload 2
      // 5a: ifne 92
      // 5d: ldc_w 136064824
      // 60: ldc_w 136064826
      // 63: ixor
      // 64: if_icmplt 7b
      // 67: goto 6b
      // 6a: athrow
      // 6b: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 6e: getfield net/minecraft/client/Minecraft.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // 71: aload 5
      // 73: bipush 1
      // 74: invokevirtual java/lang/String.charAt (I)C
      // 77: invokevirtual net/minecraft/client/gui/FontRenderer.getColorCode (C)I
      // 7a: istore 3
      // 7b: iload 3
      // 7c: ldc_w 149147845
      // 7f: ldc_w 136064826
      // 82: ixor
      // 83: iand
      // 84: fload 1
      // 85: ldc 255.0
      // 87: fmul
      // 88: f2i
      // 89: ldc_w 136064802
      // 8c: ldc_w 136064826
      // 8f: ixor
      // 90: ishl
      // 91: ior
      // 92: ireturn
   }

   public static void ȓ(Vec3 param0, int param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 2
      // 004: aload 0
      // 005: ifnull 032
      // 008: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 00b: iload 2
      // 00c: ifne 024
      // 00f: goto 013
      // 012: athrow
      // 013: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 016: ifnull 032
      // 019: goto 01d
      // 01c: athrow
      // 01d: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 020: goto 024
      // 023: athrow
      // 024: iload 2
      // 025: ifne 037
      // 028: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 02b: ifnonnull 034
      // 02e: goto 032
      // 031: athrow
      // 032: return
      // 033: athrow
      // 034: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 037: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 03a: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getCollisionBorderSize ()F
      // 03d: fstore 3
      // 03e: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 041: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 044: getfield net/minecraft/client/entity/EntityPlayerSP.width F
      // 047: f2d
      // 048: ldc2_w 2.0
      // 04b: ddiv
      // 04c: dstore 4
      // 04e: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 051: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 054: astore 6
      // 056: new net/minecraft/util/AxisAlignedBB
      // 059: dup
      // 05a: aload 0
      // 05b: getfield net/minecraft/util/Vec3.xCoord D
      // 05e: dload 4
      // 060: dsub
      // 061: aload 0
      // 062: getfield net/minecraft/util/Vec3.yCoord D
      // 065: aload 0
      // 066: getfield net/minecraft/util/Vec3.zCoord D
      // 069: dload 4
      // 06b: dsub
      // 06c: aload 0
      // 06d: getfield net/minecraft/util/Vec3.xCoord D
      // 070: dload 4
      // 072: dadd
      // 073: aload 0
      // 074: getfield net/minecraft/util/Vec3.yCoord D
      // 077: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 07a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 07d: getfield net/minecraft/client/entity/EntityPlayerSP.height F
      // 080: f2d
      // 081: dadd
      // 082: aload 0
      // 083: getfield net/minecraft/util/Vec3.zCoord D
      // 086: dload 4
      // 088: dadd
      // 089: invokespecial net/minecraft/util/AxisAlignedBB.<init> (DDDDDD)V
      // 08c: fload 3
      // 08d: f2d
      // 08e: fload 3
      // 08f: f2d
      // 090: fload 3
      // 091: f2d
      // 092: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 095: aload 6
      // 097: invokeinterface x/ocbc80def7d5.getRenderPosX ()D 1
      // 09c: dneg
      // 09d: aload 6
      // 09f: invokeinterface x/ocbc80def7d5.getRenderPosY ()D 1
      // 0a4: dneg
      // 0a5: aload 6
      // 0a7: invokeinterface x/ocbc80def7d5.getRenderPosZ ()D 1
      // 0ac: dneg
      // 0ad: invokevirtual net/minecraft/util/AxisAlignedBB.offset (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 0b0: astore 7
      // 0b2: iload 1
      // 0b3: ldc_w 1620131858
      // 0b6: ldc_w 1620131842
      // 0b9: ixor
      // 0ba: ishr
      // 0bb: ldc_w 1620132093
      // 0be: ldc_w 1620131842
      // 0c1: ixor
      // 0c2: iand
      // 0c3: istore 8
      // 0c5: iload 1
      // 0c6: ldc_w 1620131850
      // 0c9: ldc_w 1620131842
      // 0cc: ixor
      // 0cd: ishr
      // 0ce: ldc_w 1620132093
      // 0d1: ldc_w 1620131842
      // 0d4: ixor
      // 0d5: iand
      // 0d6: istore 9
      // 0d8: iload 1
      // 0d9: ldc_w 1620132093
      // 0dc: ldc_w 1620131842
      // 0df: ixor
      // 0e0: iand
      // 0e1: istore 10
      // 0e3: invokestatic net/minecraft/client/renderer/GlStateManager.pushMatrix ()V
      // 0e6: invokestatic net/minecraft/client/renderer/GlStateManager.enableBlend ()V
      // 0e9: ldc_w 1620132608
      // 0ec: ldc_w 1620131842
      // 0ef: ixor
      // 0f0: ldc_w 1620132609
      // 0f3: ldc_w 1620131842
      // 0f6: ixor
      // 0f7: invokestatic net/minecraft/client/renderer/GlStateManager.blendFunc (II)V
      // 0fa: invokestatic net/minecraft/client/renderer/GlStateManager.disableTexture2D ()V
      // 0fd: invokestatic net/minecraft/client/renderer/GlStateManager.disableCull ()V
      // 100: invokestatic net/minecraft/client/renderer/GlStateManager.disableAlpha ()V
      // 103: invokestatic net/minecraft/client/renderer/GlStateManager.disableDepth ()V
      // 106: aload 7
      // 108: iload 8
      // 10a: iload 9
      // 10c: iload 10
      // 10e: invokestatic x/ocbd4917c4b1.ȟ (Lnet/minecraft/util/AxisAlignedBB;III)V
      // 111: invokestatic net/minecraft/client/renderer/GlStateManager.enableDepth ()V
      // 114: invokestatic net/minecraft/client/renderer/GlStateManager.enableAlpha ()V
      // 117: invokestatic net/minecraft/client/renderer/GlStateManager.enableCull ()V
      // 11a: invokestatic net/minecraft/client/renderer/GlStateManager.enableTexture2D ()V
      // 11d: invokestatic net/minecraft/client/renderer/GlStateManager.disableBlend ()V
      // 120: fconst_1
      // 121: fconst_1
      // 122: fconst_1
      // 123: fconst_1
      // 124: invokestatic net/minecraft/client/renderer/GlStateManager.color (FFFF)V
      // 127: invokestatic net/minecraft/client/renderer/GlStateManager.popMatrix ()V
      // 12a: goto 14b
      // 12d: astore 11
      // 12f: invokestatic net/minecraft/client/renderer/GlStateManager.enableDepth ()V
      // 132: invokestatic net/minecraft/client/renderer/GlStateManager.enableAlpha ()V
      // 135: invokestatic net/minecraft/client/renderer/GlStateManager.enableCull ()V
      // 138: invokestatic net/minecraft/client/renderer/GlStateManager.enableTexture2D ()V
      // 13b: invokestatic net/minecraft/client/renderer/GlStateManager.disableBlend ()V
      // 13e: fconst_1
      // 13f: fconst_1
      // 140: fconst_1
      // 141: fconst_1
      // 142: invokestatic net/minecraft/client/renderer/GlStateManager.color (FFFF)V
      // 145: invokestatic net/minecraft/client/renderer/GlStateManager.popMatrix ()V
      // 148: aload 11
      // 14a: athrow
      // 14b: return
   }

   public static void Ԧ(Entity var0, Color var1, float var2) {
      double var3 = var0.lastTickPosX + (var0.posX - var0.lastTickPosX) * var2;
      double var5 = var0.lastTickPosY + (var0.posY - var0.lastTickPosY) * var2;
      double var7 = var0.lastTickPosZ + (var0.posZ - var0.lastTickPosZ) * var2;
      RenderManager var9 = ocda171fe5d8.ǔ.getRenderManager();
      AxisAlignedBB var10 = var0.getEntityBoundingBox()
         .expand(0.1F, 0.1F, 0.1F)
         .offset(var3 - var0.posX, var5 - var0.posY, var7 - var0.posZ)
         .offset(-var9.getRenderPosX(), -var9.getRenderPosY(), -var9.getRenderPosZ());
      GlStateManager.pushMatrix();

      try {
         GlStateManager.enableBlend();
         GlStateManager.blendFunc(1765668190 ^ 1765668444, 1765668191 ^ 1765668444);
         GlStateManager.disableTexture2D();
         GlStateManager.disableCull();
         GlStateManager.disableAlpha();
         GlStateManager.disableDepth();
         ȟ(var10, var1.getRed(), var1.getGreen(), var1.getBlue());
      } finally {
         GlStateManager.enableDepth();
         GlStateManager.enableAlpha();
         GlStateManager.enableCull();
         GlStateManager.enableTexture2D();
         GlStateManager.disableBlend();
         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
         GlStateManager.popMatrix();
      }
   }

   private static void ȟ(AxisAlignedBB var0, int var1, int var2, int var3) {
      Tessellator var4 = Tessellator.getInstance();
      WorldRenderer var5 = var4.getWorldRenderer();
      var5.begin(1336660515 ^ 1336660516, DefaultVertexFormats.POSITION_COLOR);
      var5.pos(var0.minX, var0.minY, var0.minZ).color(var1, var2, var3, 1336660507 ^ 1336660516).endVertex();
      var5.pos(var0.minX, var0.minY, var0.maxZ).color(var1, var2, var3, 1336660507 ^ 1336660516).endVertex();
      var5.pos(var0.maxX, var0.minY, var0.maxZ).color(var1, var2, var3, 1336660507 ^ 1336660516).endVertex();
      var5.pos(var0.maxX, var0.minY, var0.minZ).color(var1, var2, var3, 1336660507 ^ 1336660516).endVertex();
      var5.pos(var0.minX, var0.maxY, var0.minZ).color(var1, var2, var3, 1336660507 ^ 1336660516).endVertex();
      var5.pos(var0.minX, var0.maxY, var0.maxZ).color(var1, var2, var3, 1336660507 ^ 1336660516).endVertex();
      var5.pos(var0.maxX, var0.maxY, var0.maxZ).color(var1, var2, var3, 1336660507 ^ 1336660516).endVertex();
      var5.pos(var0.maxX, var0.maxY, var0.minZ).color(var1, var2, var3, 1336660507 ^ 1336660516).endVertex();
      var5.pos(var0.minX, var0.minY, var0.minZ).color(var1, var2, var3, 1336660507 ^ 1336660516).endVertex();
      var5.pos(var0.minX, var0.maxY, var0.minZ).color(var1, var2, var3, 1336660507 ^ 1336660516).endVertex();
      var5.pos(var0.maxX, var0.maxY, var0.minZ).color(var1, var2, var3, 1336660507 ^ 1336660516).endVertex();
      var5.pos(var0.maxX, var0.minY, var0.minZ).color(var1, var2, var3, 1336660507 ^ 1336660516).endVertex();
      var5.pos(var0.minX, var0.minY, var0.maxZ).color(var1, var2, var3, 1336660507 ^ 1336660516).endVertex();
      var5.pos(var0.minX, var0.maxY, var0.maxZ).color(var1, var2, var3, 1336660507 ^ 1336660516).endVertex();
      var5.pos(var0.maxX, var0.maxY, var0.maxZ).color(var1, var2, var3, 1336660507 ^ 1336660516).endVertex();
      var5.pos(var0.maxX, var0.minY, var0.maxZ).color(var1, var2, var3, 1336660507 ^ 1336660516).endVertex();
      var5.pos(var0.minX, var0.minY, var0.minZ).color(var1, var2, var3, 1336660507 ^ 1336660516).endVertex();
      var5.pos(var0.minX, var0.maxY, var0.minZ).color(var1, var2, var3, 1336660507 ^ 1336660516).endVertex();
      var5.pos(var0.minX, var0.maxY, var0.maxZ).color(var1, var2, var3, 1336660507 ^ 1336660516).endVertex();
      var5.pos(var0.minX, var0.minY, var0.maxZ).color(var1, var2, var3, 1336660507 ^ 1336660516).endVertex();
      var5.pos(var0.maxX, var0.minY, var0.minZ).color(var1, var2, var3, 1336660507 ^ 1336660516).endVertex();
      var5.pos(var0.maxX, var0.maxY, var0.minZ).color(var1, var2, var3, 1336660507 ^ 1336660516).endVertex();
      var5.pos(var0.maxX, var0.maxY, var0.maxZ).color(var1, var2, var3, 1336660507 ^ 1336660516).endVertex();
      var5.pos(var0.maxX, var0.minY, var0.maxZ).color(var1, var2, var3, 1336660507 ^ 1336660516).endVertex();
      var4.draw();
   }

   public static void f(double var0, Color var2, double var3) {
      double var5 = var0 - ocda171fe5d8.ǔ.getRenderManager().getRenderPosY();
      ú(new AxisAlignedBB(var3, var5 + 0.02, var3, -var3, var5, -var3), var2, var2.getAlpha());
   }

   public static void H(AxisAlignedBB var0, Color var1) {
      ú(var0, var1, 685190119 ^ 685190077);
   }

   public static void ú(AxisAlignedBB param0, Color param1, int param2) {
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
      // 05: ifnull 18
      // 08: aload 1
      // 09: iload 3
      // 0a: ifne 51
      // 0d: goto 11
      // 10: athrow
      // 11: ifnonnull 19
      // 14: goto 18
      // 17: athrow
      // 18: return
      // 19: ldc_w -805265338
      // 1c: ldc_w -805264572
      // 1f: ixor
      // 20: ldc_w -805265337
      // 23: ldc_w -805264572
      // 26: ixor
      // 27: invokestatic org/lwjgl/opengl/GL11.glBlendFunc (II)V
      // 2a: ldc_w -805263194
      // 2d: ldc_w -805264572
      // 30: ixor
      // 31: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 34: fconst_2
      // 35: invokestatic org/lwjgl/opengl/GL11.glLineWidth (F)V
      // 38: ldc_w -805261659
      // 3b: ldc_w -805264572
      // 3e: ixor
      // 3f: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 42: ldc_w -805263307
      // 45: ldc_w -805264572
      // 48: ixor
      // 49: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 4c: bipush 0
      // 4d: invokestatic org/lwjgl/opengl/GL11.glDepthMask (Z)V
      // 50: aload 1
      // 51: invokevirtual java/awt/Color.getRed ()I
      // 54: i2b
      // 55: aload 1
      // 56: invokevirtual java/awt/Color.getGreen ()I
      // 59: i2b
      // 5a: aload 1
      // 5b: invokevirtual java/awt/Color.getBlue ()I
      // 5e: i2b
      // 5f: bipush 0
      // 60: iload 2
      // 61: ldc_w -805264453
      // 64: ldc_w -805264572
      // 67: ixor
      // 68: invokestatic java/lang/Math.min (II)I
      // 6b: invokestatic java/lang/Math.max (II)I
      // 6e: i2b
      // 6f: invokestatic org/lwjgl/opengl/GL11.glColor4ub (BBBB)V
      // 72: aload 0
      // 73: invokestatic x/ocbd4917c4b1.Њ (Lnet/minecraft/util/AxisAlignedBB;)V
      // 76: fconst_1
      // 77: fconst_1
      // 78: fconst_1
      // 79: fconst_1
      // 7a: invokestatic org/lwjgl/opengl/GL11.glColor4f (FFFF)V
      // 7d: ldc_w -805261659
      // 80: ldc_w -805264572
      // 83: ixor
      // 84: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 87: ldc_w -805263307
      // 8a: ldc_w -805264572
      // 8d: ixor
      // 8e: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 91: bipush 1
      // 92: invokestatic org/lwjgl/opengl/GL11.glDepthMask (Z)V
      // 95: ldc_w -805263194
      // 98: ldc_w -805264572
      // 9b: ixor
      // 9c: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 9f: return
   }

   private static void Њ(AxisAlignedBB var0) {
      Tessellator var1 = Tessellator.getInstance();
      WorldRenderer var2 = var1.getWorldRenderer();
      var2.begin(553937662 ^ 553937657, DefaultVertexFormats.POSITION);
      var2.pos(var0.minX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.minX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.minX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.minX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.minX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.minX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.minX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.maxZ).endVertex();
      var1.draw();
   }

   public static void Ϙ(float var0, float var1, float var2, float var3, float var4, int var5) {
      float var6 = (var5 >> (-233780452 ^ -233780476) & (-233780229 ^ -233780476)) / 255.0F;
      float var7 = (var5 >> (-233780460 ^ -233780476) & (-233780229 ^ -233780476)) / 255.0F;
      float var8 = (var5 >> (-233780468 ^ -233780476) & (-233780229 ^ -233780476)) / 255.0F;
      float var9 = (var5 & (-233780229 ^ -233780476)) / 255.0F;
      GL11.glEnable(-233783066 ^ -233780476);
      GL11.glDisable(-233781531 ^ -233780476);
      GL11.glBlendFunc(-233781242 ^ -233780476, -233781241 ^ -233780476);
      GL11.glEnable(-233783260 ^ -233780476);
      GL11.glPushMatrix();
      GL11.glColor4f(var7, var8, var9, var6);
      GL11.glLineWidth(var4);
      GL11.glBegin(1);
      GL11.glVertex2d(var0, var1);
      GL11.glVertex2d(var0, var3);
      GL11.glVertex2d(var2, var3);
      GL11.glVertex2d(var2, var1);
      GL11.glVertex2d(var0, var1);
      GL11.glVertex2d(var2, var1);
      GL11.glVertex2d(var0, var3);
      GL11.glVertex2d(var2, var3);
      oc170ea29aae.ŷ();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glPopMatrix();
      GL11.glEnable(-233781531 ^ -233780476);
      GL11.glDisable(-233783066 ^ -233780476);
      GL11.glDisable(-233783260 ^ -233780476);
   }

   public static void ǩ(
      double param0, double param2, double param4, double param6, double param8, double param10, int param12, boolean param13, boolean param14
   ) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: dload 0
      // 001: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 004: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 007: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosX D
      // 00a: dsub
      // 00b: dstore 16
      // 00d: dload 2
      // 00e: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 011: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 014: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosY D
      // 017: dsub
      // 018: dstore 18
      // 01a: dload 4
      // 01c: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 01f: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 022: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosZ D
      // 025: dsub
      // 026: dstore 20
      // 028: invokestatic org/lwjgl/opengl/GL11.glPushMatrix ()V
      // 02b: ldc_w 1105767651
      // 02e: ldc_w 1105768417
      // 031: ixor
      // 032: ldc_w 1105767650
      // 035: ldc_w 1105768417
      // 038: ixor
      // 039: invokestatic org/lwjgl/opengl/GL11.glBlendFunc (II)V
      // 03c: ldc_w 1105765379
      // 03f: ldc_w 1105768417
      // 042: ixor
      // 043: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 046: fconst_2
      // 047: invokestatic org/lwjgl/opengl/GL11.glLineWidth (F)V
      // 04a: ldc_w 1105764864
      // 04d: ldc_w 1105768417
      // 050: ixor
      // 051: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 054: ldc_w 1105765520
      // 057: ldc_w 1105768417
      // 05a: ixor
      // 05b: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 05e: bipush 0
      // 05f: invokestatic org/lwjgl/opengl/GL11.glDepthMask (Z)V
      // 062: iload 12
      // 064: ldc_w 1105768441
      // 067: ldc_w 1105768417
      // 06a: ixor
      // 06b: ishr
      // 06c: ldc_w 1105768222
      // 06f: ldc_w 1105768417
      // 072: ixor
      // 073: iand
      // 074: i2f
      // 075: ldc 255.0
      // 077: fdiv
      // 078: fstore 22
      // 07a: getstatic x/oc75d51ec7eb.ϩ I
      // 07d: iload 12
      // 07f: ldc_w 1105768433
      // 082: ldc_w 1105768417
      // 085: ixor
      // 086: ishr
      // 087: ldc_w 1105768222
      // 08a: ldc_w 1105768417
      // 08d: ixor
      // 08e: iand
      // 08f: i2f
      // 090: ldc 255.0
      // 092: fdiv
      // 093: fstore 23
      // 095: istore 15
      // 097: iload 12
      // 099: ldc_w 1105768425
      // 09c: ldc_w 1105768417
      // 09f: ixor
      // 0a0: ishr
      // 0a1: ldc_w 1105768222
      // 0a4: ldc_w 1105768417
      // 0a7: ixor
      // 0a8: iand
      // 0a9: i2f
      // 0aa: ldc 255.0
      // 0ac: fdiv
      // 0ad: fstore 24
      // 0af: iload 12
      // 0b1: ldc_w 1105768222
      // 0b4: ldc_w 1105768417
      // 0b7: ixor
      // 0b8: iand
      // 0b9: i2f
      // 0ba: ldc 255.0
      // 0bc: fdiv
      // 0bd: fstore 25
      // 0bf: fload 23
      // 0c1: fload 24
      // 0c3: fload 25
      // 0c5: fload 22
      // 0c7: invokestatic org/lwjgl/opengl/GL11.glColor4f (FFFF)V
      // 0ca: new net/minecraft/util/AxisAlignedBB
      // 0cd: dup
      // 0ce: dload 16
      // 0d0: dload 18
      // 0d2: dload 20
      // 0d4: dload 16
      // 0d6: dload 6
      // 0d8: dadd
      // 0d9: dload 18
      // 0db: dload 8
      // 0dd: dadd
      // 0de: dload 20
      // 0e0: dload 10
      // 0e2: dadd
      // 0e3: invokespecial net/minecraft/util/AxisAlignedBB.<init> (DDDDDD)V
      // 0e6: astore 26
      // 0e8: iload 13
      // 0ea: iload 15
      // 0ec: ifne 101
      // 0ef: ifeq 0ff
      // 0f2: goto 0f6
      // 0f5: athrow
      // 0f6: aload 26
      // 0f8: invokestatic net/minecraft/client/renderer/RenderGlobal.drawSelectionBoundingBox (Lnet/minecraft/util/AxisAlignedBB;)V
      // 0fb: goto 0ff
      // 0fe: athrow
      // 0ff: iload 14
      // 101: iload 15
      // 103: ifne 142
      // 106: ifeq 11c
      // 109: goto 10d
      // 10c: athrow
      // 10d: aload 26
      // 10f: fload 23
      // 111: fload 24
      // 113: fload 25
      // 115: invokestatic x/ocbd4917c4b1.x (Lnet/minecraft/util/AxisAlignedBB;FFF)V
      // 118: goto 11c
      // 11b: athrow
      // 11c: fconst_1
      // 11d: fconst_1
      // 11e: fconst_1
      // 11f: fconst_1
      // 120: invokestatic org/lwjgl/opengl/GL11.glColor4f (FFFF)V
      // 123: ldc_w 1105764864
      // 126: ldc_w 1105768417
      // 129: ixor
      // 12a: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 12d: ldc_w 1105765520
      // 130: ldc_w 1105768417
      // 133: ixor
      // 134: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 137: bipush 1
      // 138: invokestatic org/lwjgl/opengl/GL11.glDepthMask (Z)V
      // 13b: ldc_w 1105765379
      // 13e: ldc_w 1105768417
      // 141: ixor
      // 142: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 145: invokestatic org/lwjgl/opengl/GL11.glPopMatrix ()V
      // 148: return
   }

   public static void Å(BlockPos param0, int param1, boolean param2, boolean param3, Set<EnumFacing> param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 5
      // 005: aload 4
      // 007: iload 5
      // 009: ifne 015
      // 00c: ifnull 026
      // 00f: goto 013
      // 012: athrow
      // 013: aload 4
      // 015: invokeinterface java/util/Set.isEmpty ()Z 1
      // 01a: iload 5
      // 01c: ifne 02b
      // 01f: ifeq 027
      // 022: goto 026
      // 025: athrow
      // 026: return
      // 027: aload 0
      // 028: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 02b: i2d
      // 02c: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 02f: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 032: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosX D
      // 035: dsub
      // 036: dstore 6
      // 038: aload 0
      // 039: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 03c: i2d
      // 03d: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 040: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 043: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosY D
      // 046: dsub
      // 047: dstore 8
      // 049: aload 0
      // 04a: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 04d: i2d
      // 04e: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 051: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 054: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosZ D
      // 057: dsub
      // 058: dstore 10
      // 05a: dload 6
      // 05c: dconst_1
      // 05d: dadd
      // 05e: dstore 12
      // 060: dload 8
      // 062: dconst_1
      // 063: dadd
      // 064: dstore 14
      // 066: dload 10
      // 068: dconst_1
      // 069: dadd
      // 06a: dstore 16
      // 06c: iload 1
      // 06d: ldc_w 1665612562
      // 070: ldc_w 1665612546
      // 073: ixor
      // 074: ishr
      // 075: ldc_w 1665612797
      // 078: ldc_w 1665612546
      // 07b: ixor
      // 07c: iand
      // 07d: i2f
      // 07e: ldc 255.0
      // 080: fdiv
      // 081: fstore 18
      // 083: iload 1
      // 084: ldc_w 1665612554
      // 087: ldc_w 1665612546
      // 08a: ixor
      // 08b: ishr
      // 08c: ldc_w 1665612797
      // 08f: ldc_w 1665612546
      // 092: ixor
      // 093: iand
      // 094: i2f
      // 095: ldc 255.0
      // 097: fdiv
      // 098: fstore 19
      // 09a: iload 1
      // 09b: ldc_w 1665612797
      // 09e: ldc_w 1665612546
      // 0a1: ixor
      // 0a2: iand
      // 0a3: i2f
      // 0a4: ldc 255.0
      // 0a6: fdiv
      // 0a7: fstore 20
      // 0a9: iload 1
      // 0aa: ldc_w 1665612570
      // 0ad: ldc_w 1665612546
      // 0b0: ixor
      // 0b1: ishr
      // 0b2: ldc_w 1665612797
      // 0b5: ldc_w 1665612546
      // 0b8: ixor
      // 0b9: iand
      // 0ba: i2f
      // 0bb: ldc 255.0
      // 0bd: fdiv
      // 0be: fstore 21
      // 0c0: ldc_w 0.25
      // 0c3: fstore 22
      // 0c5: invokestatic org/lwjgl/opengl/GL11.glPushMatrix ()V
      // 0c8: ldc_w 1665611776
      // 0cb: ldc_w 1665612546
      // 0ce: ixor
      // 0cf: ldc_w 1665611777
      // 0d2: ldc_w 1665612546
      // 0d5: ixor
      // 0d6: invokestatic org/lwjgl/opengl/GL11.glBlendFunc (II)V
      // 0d9: ldc_w 1665609952
      // 0dc: ldc_w 1665612546
      // 0df: ixor
      // 0e0: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 0e3: fconst_2
      // 0e4: invokestatic org/lwjgl/opengl/GL11.glLineWidth (F)V
      // 0e7: ldc_w 1665611491
      // 0ea: ldc_w 1665612546
      // 0ed: ixor
      // 0ee: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 0f1: ldc_w 1665609843
      // 0f4: ldc_w 1665612546
      // 0f7: ixor
      // 0f8: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 0fb: bipush 0
      // 0fc: invokestatic org/lwjgl/opengl/GL11.glDepthMask (Z)V
      // 0ff: invokestatic net/minecraft/client/renderer/Tessellator.getInstance ()Lnet/minecraft/client/renderer/Tessellator;
      // 102: astore 23
      // 104: aload 23
      // 106: invokevirtual net/minecraft/client/renderer/Tessellator.getWorldRenderer ()Lnet/minecraft/client/renderer/WorldRenderer;
      // 109: astore 24
      // 10b: iload 3
      // 10c: iload 5
      // 10e: ifne 41c
      // 111: ifeq 41b
      // 114: goto 118
      // 117: athrow
      // 118: aload 24
      // 11a: ldc_w 1665612549
      // 11d: ldc_w 1665612546
      // 120: ixor
      // 121: getstatic net/minecraft/client/renderer/vertex/DefaultVertexFormats.POSITION_COLOR Lnet/minecraft/client/renderer/vertex/VertexFormat;
      // 124: invokevirtual net/minecraft/client/renderer/WorldRenderer.begin (ILnet/minecraft/client/renderer/vertex/VertexFormat;)V
      // 127: aload 4
      // 129: iload 5
      // 12b: ifne 1ab
      // 12e: goto 132
      // 131: athrow
      // 132: getstatic net/minecraft/util/EnumFacing.DOWN Lnet/minecraft/util/EnumFacing;
      // 135: invokeinterface java/util/Set.contains (Ljava/lang/Object;)Z 2
      // 13a: ifeq 1a9
      // 13d: goto 141
      // 140: athrow
      // 141: aload 24
      // 143: dload 6
      // 145: dload 8
      // 147: dload 10
      // 149: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 14c: fload 18
      // 14e: fload 19
      // 150: fload 20
      // 152: fload 22
      // 154: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 157: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 15a: aload 24
      // 15c: dload 12
      // 15e: dload 8
      // 160: dload 10
      // 162: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 165: fload 18
      // 167: fload 19
      // 169: fload 20
      // 16b: fload 22
      // 16d: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 170: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 173: aload 24
      // 175: dload 12
      // 177: dload 8
      // 179: dload 16
      // 17b: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 17e: fload 18
      // 180: fload 19
      // 182: fload 20
      // 184: fload 22
      // 186: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 189: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 18c: aload 24
      // 18e: dload 6
      // 190: dload 8
      // 192: dload 16
      // 194: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 197: fload 18
      // 199: fload 19
      // 19b: fload 20
      // 19d: fload 22
      // 19f: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 1a2: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 1a5: goto 1a9
      // 1a8: athrow
      // 1a9: aload 4
      // 1ab: getstatic net/minecraft/util/EnumFacing.UP Lnet/minecraft/util/EnumFacing;
      // 1ae: iload 5
      // 1b0: ifne 235
      // 1b3: invokeinterface java/util/Set.contains (Ljava/lang/Object;)Z 2
      // 1b8: ifeq 227
      // 1bb: goto 1bf
      // 1be: athrow
      // 1bf: aload 24
      // 1c1: dload 6
      // 1c3: dload 14
      // 1c5: dload 10
      // 1c7: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 1ca: fload 18
      // 1cc: fload 19
      // 1ce: fload 20
      // 1d0: fload 22
      // 1d2: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 1d5: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 1d8: aload 24
      // 1da: dload 6
      // 1dc: dload 14
      // 1de: dload 16
      // 1e0: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 1e3: fload 18
      // 1e5: fload 19
      // 1e7: fload 20
      // 1e9: fload 22
      // 1eb: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 1ee: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 1f1: aload 24
      // 1f3: dload 12
      // 1f5: dload 14
      // 1f7: dload 16
      // 1f9: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 1fc: fload 18
      // 1fe: fload 19
      // 200: fload 20
      // 202: fload 22
      // 204: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 207: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 20a: aload 24
      // 20c: dload 12
      // 20e: dload 14
      // 210: dload 10
      // 212: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 215: fload 18
      // 217: fload 19
      // 219: fload 20
      // 21b: fload 22
      // 21d: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 220: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 223: goto 227
      // 226: athrow
      // 227: aload 4
      // 229: iload 5
      // 22b: ifne 2a7
      // 22e: getstatic net/minecraft/util/EnumFacing.NORTH Lnet/minecraft/util/EnumFacing;
      // 231: goto 235
      // 234: athrow
      // 235: invokeinterface java/util/Set.contains (Ljava/lang/Object;)Z 2
      // 23a: ifeq 2a5
      // 23d: aload 24
      // 23f: dload 6
      // 241: dload 8
      // 243: dload 10
      // 245: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 248: fload 18
      // 24a: fload 19
      // 24c: fload 20
      // 24e: fload 22
      // 250: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 253: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 256: aload 24
      // 258: dload 6
      // 25a: dload 14
      // 25c: dload 10
      // 25e: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 261: fload 18
      // 263: fload 19
      // 265: fload 20
      // 267: fload 22
      // 269: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 26c: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 26f: aload 24
      // 271: dload 12
      // 273: dload 14
      // 275: dload 10
      // 277: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 27a: fload 18
      // 27c: fload 19
      // 27e: fload 20
      // 280: fload 22
      // 282: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 285: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 288: aload 24
      // 28a: dload 12
      // 28c: dload 8
      // 28e: dload 10
      // 290: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 293: fload 18
      // 295: fload 19
      // 297: fload 20
      // 299: fload 22
      // 29b: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 29e: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 2a1: goto 2a5
      // 2a4: athrow
      // 2a5: aload 4
      // 2a7: iload 5
      // 2a9: ifne 325
      // 2ac: getstatic net/minecraft/util/EnumFacing.SOUTH Lnet/minecraft/util/EnumFacing;
      // 2af: invokeinterface java/util/Set.contains (Ljava/lang/Object;)Z 2
      // 2b4: ifeq 323
      // 2b7: goto 2bb
      // 2ba: athrow
      // 2bb: aload 24
      // 2bd: dload 12
      // 2bf: dload 8
      // 2c1: dload 16
      // 2c3: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 2c6: fload 18
      // 2c8: fload 19
      // 2ca: fload 20
      // 2cc: fload 22
      // 2ce: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 2d1: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 2d4: aload 24
      // 2d6: dload 12
      // 2d8: dload 14
      // 2da: dload 16
      // 2dc: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 2df: fload 18
      // 2e1: fload 19
      // 2e3: fload 20
      // 2e5: fload 22
      // 2e7: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 2ea: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 2ed: aload 24
      // 2ef: dload 6
      // 2f1: dload 14
      // 2f3: dload 16
      // 2f5: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 2f8: fload 18
      // 2fa: fload 19
      // 2fc: fload 20
      // 2fe: fload 22
      // 300: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 303: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 306: aload 24
      // 308: dload 6
      // 30a: dload 8
      // 30c: dload 16
      // 30e: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 311: fload 18
      // 313: fload 19
      // 315: fload 20
      // 317: fload 22
      // 319: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 31c: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 31f: goto 323
      // 322: athrow
      // 323: aload 4
      // 325: iload 5
      // 327: ifne 3a3
      // 32a: getstatic net/minecraft/util/EnumFacing.WEST Lnet/minecraft/util/EnumFacing;
      // 32d: invokeinterface java/util/Set.contains (Ljava/lang/Object;)Z 2
      // 332: ifeq 3a1
      // 335: goto 339
      // 338: athrow
      // 339: aload 24
      // 33b: dload 6
      // 33d: dload 8
      // 33f: dload 10
      // 341: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 344: fload 18
      // 346: fload 19
      // 348: fload 20
      // 34a: fload 22
      // 34c: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 34f: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 352: aload 24
      // 354: dload 6
      // 356: dload 14
      // 358: dload 10
      // 35a: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 35d: fload 18
      // 35f: fload 19
      // 361: fload 20
      // 363: fload 22
      // 365: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 368: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 36b: aload 24
      // 36d: dload 6
      // 36f: dload 14
      // 371: dload 16
      // 373: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 376: fload 18
      // 378: fload 19
      // 37a: fload 20
      // 37c: fload 22
      // 37e: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 381: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 384: aload 24
      // 386: dload 6
      // 388: dload 8
      // 38a: dload 16
      // 38c: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 38f: fload 18
      // 391: fload 19
      // 393: fload 20
      // 395: fload 22
      // 397: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 39a: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 39d: goto 3a1
      // 3a0: athrow
      // 3a1: aload 4
      // 3a3: getstatic net/minecraft/util/EnumFacing.EAST Lnet/minecraft/util/EnumFacing;
      // 3a6: invokeinterface java/util/Set.contains (Ljava/lang/Object;)Z 2
      // 3ab: ifeq 416
      // 3ae: aload 24
      // 3b0: dload 12
      // 3b2: dload 8
      // 3b4: dload 16
      // 3b6: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 3b9: fload 18
      // 3bb: fload 19
      // 3bd: fload 20
      // 3bf: fload 22
      // 3c1: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 3c4: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 3c7: aload 24
      // 3c9: dload 12
      // 3cb: dload 14
      // 3cd: dload 16
      // 3cf: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 3d2: fload 18
      // 3d4: fload 19
      // 3d6: fload 20
      // 3d8: fload 22
      // 3da: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 3dd: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 3e0: aload 24
      // 3e2: dload 12
      // 3e4: dload 14
      // 3e6: dload 10
      // 3e8: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 3eb: fload 18
      // 3ed: fload 19
      // 3ef: fload 20
      // 3f1: fload 22
      // 3f3: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 3f6: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 3f9: aload 24
      // 3fb: dload 12
      // 3fd: dload 8
      // 3ff: dload 10
      // 401: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 404: fload 18
      // 406: fload 19
      // 408: fload 20
      // 40a: fload 22
      // 40c: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 40f: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 412: goto 416
      // 415: athrow
      // 416: aload 23
      // 418: invokevirtual net/minecraft/client/renderer/Tessellator.draw ()V
      // 41b: iload 2
      // 41c: iload 5
      // 41e: ifne 79e
      // 421: ifeq 778
      // 424: goto 428
      // 427: athrow
      // 428: fload 18
      // 42a: fload 19
      // 42c: fload 20
      // 42e: fload 21
      // 430: invokestatic org/lwjgl/opengl/GL11.glColor4f (FFFF)V
      // 433: aload 24
      // 435: bipush 1
      // 436: getstatic net/minecraft/client/renderer/vertex/DefaultVertexFormats.POSITION Lnet/minecraft/client/renderer/vertex/VertexFormat;
      // 439: invokevirtual net/minecraft/client/renderer/WorldRenderer.begin (ILnet/minecraft/client/renderer/vertex/VertexFormat;)V
      // 43c: aload 4
      // 43e: getstatic net/minecraft/util/EnumFacing.DOWN Lnet/minecraft/util/EnumFacing;
      // 441: iload 5
      // 443: ifne 4d8
      // 446: goto 44a
      // 449: athrow
      // 44a: invokeinterface java/util/Set.contains (Ljava/lang/Object;)Z 2
      // 44f: ifeq 4ca
      // 452: goto 456
      // 455: athrow
      // 456: aload 24
      // 458: dload 6
      // 45a: dload 8
      // 45c: dload 10
      // 45e: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 461: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 464: aload 24
      // 466: dload 12
      // 468: dload 8
      // 46a: dload 10
      // 46c: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 46f: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 472: aload 24
      // 474: dload 12
      // 476: dload 8
      // 478: dload 10
      // 47a: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 47d: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 480: aload 24
      // 482: dload 12
      // 484: dload 8
      // 486: dload 16
      // 488: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 48b: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 48e: aload 24
      // 490: dload 12
      // 492: dload 8
      // 494: dload 16
      // 496: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 499: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 49c: aload 24
      // 49e: dload 6
      // 4a0: dload 8
      // 4a2: dload 16
      // 4a4: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 4a7: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 4aa: aload 24
      // 4ac: dload 6
      // 4ae: dload 8
      // 4b0: dload 16
      // 4b2: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 4b5: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 4b8: aload 24
      // 4ba: dload 6
      // 4bc: dload 8
      // 4be: dload 10
      // 4c0: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 4c3: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 4c6: goto 4ca
      // 4c9: athrow
      // 4ca: aload 4
      // 4cc: iload 5
      // 4ce: ifne 556
      // 4d1: getstatic net/minecraft/util/EnumFacing.UP Lnet/minecraft/util/EnumFacing;
      // 4d4: goto 4d8
      // 4d7: athrow
      // 4d8: invokeinterface java/util/Set.contains (Ljava/lang/Object;)Z 2
      // 4dd: ifeq 554
      // 4e0: aload 24
      // 4e2: dload 6
      // 4e4: dload 14
      // 4e6: dload 10
      // 4e8: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 4eb: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 4ee: aload 24
      // 4f0: dload 12
      // 4f2: dload 14
      // 4f4: dload 10
      // 4f6: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 4f9: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 4fc: aload 24
      // 4fe: dload 12
      // 500: dload 14
      // 502: dload 10
      // 504: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 507: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 50a: aload 24
      // 50c: dload 12
      // 50e: dload 14
      // 510: dload 16
      // 512: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 515: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 518: aload 24
      // 51a: dload 12
      // 51c: dload 14
      // 51e: dload 16
      // 520: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 523: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 526: aload 24
      // 528: dload 6
      // 52a: dload 14
      // 52c: dload 16
      // 52e: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 531: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 534: aload 24
      // 536: dload 6
      // 538: dload 14
      // 53a: dload 16
      // 53c: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 53f: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 542: aload 24
      // 544: dload 6
      // 546: dload 14
      // 548: dload 10
      // 54a: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 54d: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 550: goto 554
      // 553: athrow
      // 554: aload 4
      // 556: iload 5
      // 558: ifne 5e0
      // 55b: getstatic net/minecraft/util/EnumFacing.NORTH Lnet/minecraft/util/EnumFacing;
      // 55e: invokeinterface java/util/Set.contains (Ljava/lang/Object;)Z 2
      // 563: ifeq 5de
      // 566: goto 56a
      // 569: athrow
      // 56a: aload 24
      // 56c: dload 6
      // 56e: dload 8
      // 570: dload 10
      // 572: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 575: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 578: aload 24
      // 57a: dload 6
      // 57c: dload 14
      // 57e: dload 10
      // 580: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 583: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 586: aload 24
      // 588: dload 6
      // 58a: dload 14
      // 58c: dload 10
      // 58e: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 591: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 594: aload 24
      // 596: dload 12
      // 598: dload 14
      // 59a: dload 10
      // 59c: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 59f: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 5a2: aload 24
      // 5a4: dload 12
      // 5a6: dload 14
      // 5a8: dload 10
      // 5aa: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 5ad: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 5b0: aload 24
      // 5b2: dload 12
      // 5b4: dload 8
      // 5b6: dload 10
      // 5b8: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 5bb: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 5be: aload 24
      // 5c0: dload 12
      // 5c2: dload 8
      // 5c4: dload 10
      // 5c6: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 5c9: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 5cc: aload 24
      // 5ce: dload 6
      // 5d0: dload 8
      // 5d2: dload 10
      // 5d4: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 5d7: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 5da: goto 5de
      // 5dd: athrow
      // 5de: aload 4
      // 5e0: iload 5
      // 5e2: ifne 66a
      // 5e5: getstatic net/minecraft/util/EnumFacing.SOUTH Lnet/minecraft/util/EnumFacing;
      // 5e8: invokeinterface java/util/Set.contains (Ljava/lang/Object;)Z 2
      // 5ed: ifeq 668
      // 5f0: goto 5f4
      // 5f3: athrow
      // 5f4: aload 24
      // 5f6: dload 6
      // 5f8: dload 8
      // 5fa: dload 16
      // 5fc: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 5ff: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 602: aload 24
      // 604: dload 6
      // 606: dload 14
      // 608: dload 16
      // 60a: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 60d: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 610: aload 24
      // 612: dload 6
      // 614: dload 14
      // 616: dload 16
      // 618: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 61b: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 61e: aload 24
      // 620: dload 12
      // 622: dload 14
      // 624: dload 16
      // 626: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 629: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 62c: aload 24
      // 62e: dload 12
      // 630: dload 14
      // 632: dload 16
      // 634: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 637: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 63a: aload 24
      // 63c: dload 12
      // 63e: dload 8
      // 640: dload 16
      // 642: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 645: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 648: aload 24
      // 64a: dload 12
      // 64c: dload 8
      // 64e: dload 16
      // 650: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 653: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 656: aload 24
      // 658: dload 6
      // 65a: dload 8
      // 65c: dload 16
      // 65e: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 661: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 664: goto 668
      // 667: athrow
      // 668: aload 4
      // 66a: getstatic net/minecraft/util/EnumFacing.WEST Lnet/minecraft/util/EnumFacing;
      // 66d: iload 5
      // 66f: ifne 6f7
      // 672: invokeinterface java/util/Set.contains (Ljava/lang/Object;)Z 2
      // 677: ifeq 6f2
      // 67a: goto 67e
      // 67d: athrow
      // 67e: aload 24
      // 680: dload 6
      // 682: dload 8
      // 684: dload 10
      // 686: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 689: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 68c: aload 24
      // 68e: dload 6
      // 690: dload 14
      // 692: dload 10
      // 694: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 697: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 69a: aload 24
      // 69c: dload 6
      // 69e: dload 14
      // 6a0: dload 10
      // 6a2: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 6a5: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 6a8: aload 24
      // 6aa: dload 6
      // 6ac: dload 14
      // 6ae: dload 16
      // 6b0: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 6b3: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 6b6: aload 24
      // 6b8: dload 6
      // 6ba: dload 14
      // 6bc: dload 16
      // 6be: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 6c1: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 6c4: aload 24
      // 6c6: dload 6
      // 6c8: dload 8
      // 6ca: dload 16
      // 6cc: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 6cf: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 6d2: aload 24
      // 6d4: dload 6
      // 6d6: dload 8
      // 6d8: dload 16
      // 6da: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 6dd: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 6e0: aload 24
      // 6e2: dload 6
      // 6e4: dload 8
      // 6e6: dload 10
      // 6e8: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 6eb: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 6ee: goto 6f2
      // 6f1: athrow
      // 6f2: aload 4
      // 6f4: getstatic net/minecraft/util/EnumFacing.EAST Lnet/minecraft/util/EnumFacing;
      // 6f7: invokeinterface java/util/Set.contains (Ljava/lang/Object;)Z 2
      // 6fc: ifeq 773
      // 6ff: aload 24
      // 701: dload 12
      // 703: dload 8
      // 705: dload 10
      // 707: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 70a: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 70d: aload 24
      // 70f: dload 12
      // 711: dload 14
      // 713: dload 10
      // 715: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 718: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 71b: aload 24
      // 71d: dload 12
      // 71f: dload 14
      // 721: dload 10
      // 723: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 726: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 729: aload 24
      // 72b: dload 12
      // 72d: dload 14
      // 72f: dload 16
      // 731: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 734: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 737: aload 24
      // 739: dload 12
      // 73b: dload 14
      // 73d: dload 16
      // 73f: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 742: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 745: aload 24
      // 747: dload 12
      // 749: dload 8
      // 74b: dload 16
      // 74d: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 750: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 753: aload 24
      // 755: dload 12
      // 757: dload 8
      // 759: dload 16
      // 75b: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 75e: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 761: aload 24
      // 763: dload 12
      // 765: dload 8
      // 767: dload 10
      // 769: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 76c: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 76f: goto 773
      // 772: athrow
      // 773: aload 23
      // 775: invokevirtual net/minecraft/client/renderer/Tessellator.draw ()V
      // 778: fconst_1
      // 779: fconst_1
      // 77a: fconst_1
      // 77b: fconst_1
      // 77c: invokestatic org/lwjgl/opengl/GL11.glColor4f (FFFF)V
      // 77f: ldc_w 1665611491
      // 782: ldc_w 1665612546
      // 785: ixor
      // 786: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 789: ldc_w 1665609843
      // 78c: ldc_w 1665612546
      // 78f: ixor
      // 790: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 793: bipush 1
      // 794: invokestatic org/lwjgl/opengl/GL11.glDepthMask (Z)V
      // 797: ldc_w 1665609952
      // 79a: ldc_w 1665612546
      // 79d: ixor
      // 79e: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 7a1: invokestatic org/lwjgl/opengl/GL11.glPopMatrix ()V
      // 7a4: return
   }

   private static void Ɓ(WorldRenderer var0, double var1, double var3, double var5, int var7) {
      var0.pos(var1, var3, var5)
         .color(
            var7 >> (-1102906754 ^ -1102906770) & (-1102906735 ^ -1102906770),
            var7 >> (-1102906778 ^ -1102906770) & (-1102906735 ^ -1102906770),
            var7 & (-1102906735 ^ -1102906770),
            var7 >> (-1102906762 ^ -1102906770) & (-1102906735 ^ -1102906770)
         )
         .endVertex();
   }

   private static void Ψ(WorldRenderer param0, EnumFacing param1, AxisAlignedBB param2, int param3, int param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 5
      // 005: getstatic x/oc611eeaef9e.Ґ [I
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
      // 042: invokestatic x/ocbd4917c4b1.Ɓ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 045: iload 5
      // 047: aload 0
      // 048: aload 2
      // 049: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 04c: aload 2
      // 04d: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 050: aload 2
      // 051: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 054: iload 4
      // 056: invokestatic x/ocbd4917c4b1.Ɓ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 059: aload 0
      // 05a: aload 2
      // 05b: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 05e: aload 2
      // 05f: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 062: aload 2
      // 063: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 066: iload 3
      // 067: invokestatic x/ocbd4917c4b1.Ɓ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 06a: aload 0
      // 06b: aload 2
      // 06c: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 06f: aload 2
      // 070: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 073: aload 2
      // 074: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 077: iload 4
      // 079: invokestatic x/ocbd4917c4b1.Ɓ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
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
      // 091: invokestatic x/ocbd4917c4b1.Ɓ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 094: iload 5
      // 096: aload 0
      // 097: aload 2
      // 098: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 09b: aload 2
      // 09c: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 09f: aload 2
      // 0a0: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 0a3: iload 4
      // 0a5: invokestatic x/ocbd4917c4b1.Ɓ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 0a8: aload 0
      // 0a9: aload 2
      // 0aa: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 0ad: aload 2
      // 0ae: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 0b1: aload 2
      // 0b2: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 0b5: iload 3
      // 0b6: invokestatic x/ocbd4917c4b1.Ɓ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 0b9: aload 0
      // 0ba: aload 2
      // 0bb: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 0be: aload 2
      // 0bf: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 0c2: aload 2
      // 0c3: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 0c6: iload 4
      // 0c8: invokestatic x/ocbd4917c4b1.Ɓ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
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
      // 0e0: invokestatic x/ocbd4917c4b1.Ɓ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 0e3: iload 5
      // 0e5: aload 0
      // 0e6: aload 2
      // 0e7: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 0ea: aload 2
      // 0eb: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 0ee: aload 2
      // 0ef: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 0f2: iload 4
      // 0f4: invokestatic x/ocbd4917c4b1.Ɓ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 0f7: aload 0
      // 0f8: aload 2
      // 0f9: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 0fc: aload 2
      // 0fd: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 100: aload 2
      // 101: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 104: iload 3
      // 105: invokestatic x/ocbd4917c4b1.Ɓ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 108: aload 0
      // 109: aload 2
      // 10a: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 10d: aload 2
      // 10e: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 111: aload 2
      // 112: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 115: iload 4
      // 117: invokestatic x/ocbd4917c4b1.Ɓ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
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
      // 12f: invokestatic x/ocbd4917c4b1.Ɓ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 132: iload 5
      // 134: aload 0
      // 135: aload 2
      // 136: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 139: aload 2
      // 13a: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 13d: aload 2
      // 13e: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 141: iload 4
      // 143: invokestatic x/ocbd4917c4b1.Ɓ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 146: aload 0
      // 147: aload 2
      // 148: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 14b: aload 2
      // 14c: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 14f: aload 2
      // 150: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 153: iload 3
      // 154: invokestatic x/ocbd4917c4b1.Ɓ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 157: aload 0
      // 158: aload 2
      // 159: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 15c: aload 2
      // 15d: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 160: aload 2
      // 161: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 164: iload 4
      // 166: invokestatic x/ocbd4917c4b1.Ɓ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
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
      // 17e: invokestatic x/ocbd4917c4b1.Ɓ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 181: iload 5
      // 183: aload 0
      // 184: aload 2
      // 185: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 188: aload 2
      // 189: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 18c: aload 2
      // 18d: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 190: iload 4
      // 192: invokestatic x/ocbd4917c4b1.Ɓ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 195: aload 0
      // 196: aload 2
      // 197: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 19a: aload 2
      // 19b: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 19e: aload 2
      // 19f: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 1a2: iload 3
      // 1a3: invokestatic x/ocbd4917c4b1.Ɓ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 1a6: aload 0
      // 1a7: aload 2
      // 1a8: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 1ab: aload 2
      // 1ac: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 1af: aload 2
      // 1b0: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 1b3: iload 4
      // 1b5: invokestatic x/ocbd4917c4b1.Ɓ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
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
      // 1cd: invokestatic x/ocbd4917c4b1.Ɓ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 1d0: aload 0
      // 1d1: aload 2
      // 1d2: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 1d5: aload 2
      // 1d6: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 1d9: aload 2
      // 1da: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 1dd: iload 4
      // 1df: invokestatic x/ocbd4917c4b1.Ɓ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 1e2: aload 0
      // 1e3: aload 2
      // 1e4: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 1e7: aload 2
      // 1e8: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 1eb: aload 2
      // 1ec: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 1ef: iload 3
      // 1f0: invokestatic x/ocbd4917c4b1.Ɓ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 1f3: aload 0
      // 1f4: aload 2
      // 1f5: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 1f8: aload 2
      // 1f9: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 1fc: aload 2
      // 1fd: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 200: iload 4
      // 202: invokestatic x/ocbd4917c4b1.Ɓ (Lnet/minecraft/client/renderer/WorldRenderer;DDDI)V
      // 205: goto 209
      // 208: athrow
      // 209: return
   }

   public static void ɟ(AxisAlignedBB param0, EnumFacing param1, int param2, int param3, boolean param4, boolean param5) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: invokestatic net/minecraft/client/renderer/Tessellator.getInstance ()Lnet/minecraft/client/renderer/Tessellator;
      // 06: astore 7
      // 08: istore 6
      // 0a: aload 7
      // 0c: invokevirtual net/minecraft/client/renderer/Tessellator.getWorldRenderer ()Lnet/minecraft/client/renderer/WorldRenderer;
      // 0f: astore 8
      // 11: iload 4
      // 13: iload 6
      // 15: ifne 42
      // 18: ifeq 40
      // 1b: goto 1f
      // 1e: athrow
      // 1f: aload 8
      // 21: ldc_w -1511117787
      // 24: ldc_w -1511117790
      // 27: ixor
      // 28: getstatic net/minecraft/client/renderer/vertex/DefaultVertexFormats.POSITION_COLOR Lnet/minecraft/client/renderer/vertex/VertexFormat;
      // 2b: invokevirtual net/minecraft/client/renderer/WorldRenderer.begin (ILnet/minecraft/client/renderer/vertex/VertexFormat;)V
      // 2e: aload 8
      // 30: aload 1
      // 31: aload 0
      // 32: iload 2
      // 33: iload 2
      // 34: invokestatic x/ocbd4917c4b1.Ψ (Lnet/minecraft/client/renderer/WorldRenderer;Lnet/minecraft/util/EnumFacing;Lnet/minecraft/util/AxisAlignedBB;II)V
      // 37: aload 7
      // 39: invokevirtual net/minecraft/client/renderer/Tessellator.draw ()V
      // 3c: goto 40
      // 3f: athrow
      // 40: iload 5
      // 42: ifeq 66
      // 45: aload 8
      // 47: ldc_w -1511117792
      // 4a: ldc_w -1511117790
      // 4d: ixor
      // 4e: getstatic net/minecraft/client/renderer/vertex/DefaultVertexFormats.POSITION_COLOR Lnet/minecraft/client/renderer/vertex/VertexFormat;
      // 51: invokevirtual net/minecraft/client/renderer/WorldRenderer.begin (ILnet/minecraft/client/renderer/vertex/VertexFormat;)V
      // 54: aload 8
      // 56: aload 1
      // 57: aload 0
      // 58: iload 3
      // 59: iload 3
      // 5a: invokestatic x/ocbd4917c4b1.Ψ (Lnet/minecraft/client/renderer/WorldRenderer;Lnet/minecraft/util/EnumFacing;Lnet/minecraft/util/AxisAlignedBB;II)V
      // 5d: aload 7
      // 5f: invokevirtual net/minecraft/client/renderer/Tessellator.draw ()V
      // 62: goto 66
      // 65: athrow
      // 66: return
   }

   public static void Ă(BlockPos param0, IBlockState param1, int param2, boolean param3, boolean param4, Set<EnumFacing> param5) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: aload 0
      // 004: invokestatic x/occb1ed1ed8f.ª (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/util/AxisAlignedBB;
      // 007: astore 7
      // 009: istore 6
      // 00b: aload 7
      // 00d: ifnonnull 012
      // 010: return
      // 011: athrow
      // 012: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 015: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 018: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosX D
      // 01b: dstore 8
      // 01d: iload 6
      // 01f: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 022: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 025: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosY D
      // 028: dstore 10
      // 02a: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 02d: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 030: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosZ D
      // 033: dstore 12
      // 035: iload 2
      // 036: ldc_w 1278701532
      // 039: ldc_w 1288212515
      // 03c: ixor
      // 03d: iand
      // 03e: ldc_w 1942523939
      // 041: ldc_w 1288212515
      // 044: ixor
      // 045: ior
      // 046: istore 14
      // 048: iload 2
      // 049: ldc_w -1278701533
      // 04c: ldc_w 1288212515
      // 04f: ixor
      // 050: ior
      // 051: istore 15
      // 053: invokestatic org/lwjgl/opengl/GL11.glPushMatrix ()V
      // 056: ifne 0c6
      // 059: ldc_w 1288213281
      // 05c: ldc_w 1288212515
      // 05f: ixor
      // 060: ldc_w 1288213280
      // 063: ldc_w 1288212515
      // 066: ixor
      // 067: invokestatic org/lwjgl/opengl/GL11.glBlendFunc (II)V
      // 06a: ldc_w 1288215489
      // 06d: ldc_w 1288212515
      // 070: ixor
      // 071: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 074: fconst_2
      // 075: invokestatic org/lwjgl/opengl/GL11.glLineWidth (F)V
      // 078: ldc_w 1288216002
      // 07b: ldc_w 1288212515
      // 07e: ixor
      // 07f: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 082: ldc_w 1288215378
      // 085: ldc_w 1288212515
      // 088: ixor
      // 089: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 08c: bipush 0
      // 08d: invokestatic org/lwjgl/opengl/GL11.glDepthMask (Z)V
      // 090: aload 1
      // 091: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 096: instanceof net/minecraft/block/BlockStairs
      // 099: ifeq 0cb
      // 09c: goto 0a0
      // 09f: athrow
      // 0a0: aload 0
      // 0a1: aload 1
      // 0a2: aload 7
      // 0a4: aconst_null
      // 0a5: dload 8
      // 0a7: dload 10
      // 0a9: dload 12
      // 0ab: iload 14
      // 0ad: iload 15
      // 0af: iload 15
      // 0b1: iload 15
      // 0b3: iload 4
      // 0b5: iload 3
      // 0b6: iload 14
      // 0b8: iload 15
      // 0ba: invokedynamic z$28or8txyh193t (II)Lx/oc6ae6c74639; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Lnet/minecraft/util/AxisAlignedBB;Lnet/minecraft/util/EnumFacing;IIIIZZ)V, x/ocbd4917c4b1.q3fu95bikifukg (IILnet/minecraft/util/AxisAlignedBB;Lnet/minecraft/util/EnumFacing;IIIIZZ)V, (Lnet/minecraft/util/AxisAlignedBB;Lnet/minecraft/util/EnumFacing;IIIIZZ)V ]
      // 0bf: invokestatic x/oc8e5d226f46.ϳ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/block/state/IBlockState;Lnet/minecraft/util/AxisAlignedBB;Lnet/minecraft/util/EnumFacing;DDDIIIIZZLx/oc6ae6c74639;)V
      // 0c2: goto 0c6
      // 0c5: athrow
      // 0c6: iload 6
      // 0c8: ifeq 116
      // 0cb: aload 7
      // 0cd: dload 8
      // 0cf: dneg
      // 0d0: dload 10
      // 0d2: dneg
      // 0d3: dload 12
      // 0d5: dneg
      // 0d6: invokevirtual net/minecraft/util/AxisAlignedBB.offset (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 0d9: astore 16
      // 0db: aload 5
      // 0dd: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 0e2: astore 17
      // 0e4: aload 17
      // 0e6: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0eb: ifeq 116
      // 0ee: aload 17
      // 0f0: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0f5: checkcast net/minecraft/util/EnumFacing
      // 0f8: astore 18
      // 0fa: iload 6
      // 0fc: aload 16
      // 0fe: aload 18
      // 100: iload 14
      // 102: iload 15
      // 104: iload 4
      // 106: iload 3
      // 107: invokestatic x/ocbd4917c4b1.ɟ (Lnet/minecraft/util/AxisAlignedBB;Lnet/minecraft/util/EnumFacing;IIZZ)V
      // 10a: ifne 13b
      // 10d: iload 6
      // 10f: ifeq 0e4
      // 112: goto 116
      // 115: athrow
      // 116: ldc_w 1288216002
      // 119: ldc_w 1288212515
      // 11c: ixor
      // 11d: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 120: ldc_w 1288215378
      // 123: ldc_w 1288212515
      // 126: ixor
      // 127: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 12a: bipush 1
      // 12b: invokestatic org/lwjgl/opengl/GL11.glDepthMask (Z)V
      // 12e: ldc_w 1288215489
      // 131: ldc_w 1288212515
      // 134: ixor
      // 135: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 138: invokestatic org/lwjgl/opengl/GL11.glPopMatrix ()V
      // 13b: return
   }

   public static void Ʌ(boolean param0, boolean param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: new net/minecraft/client/gui/ScaledResolution
      // 006: dup
      // 007: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 00a: invokespecial net/minecraft/client/gui/ScaledResolution.<init> (Lnet/minecraft/client/Minecraft;)V
      // 00d: astore 3
      // 00e: ldc_w ""
      // 011: astore 4
      // 013: istore 2
      // 014: bipush -1
      // 015: istore 5
      // 017: iload 0
      // 018: iload 2
      // 019: ifne 0d0
      // 01c: ifeq 0cf
      // 01f: goto 023
      // 022: athrow
      // 023: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 026: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 029: ldc_w -954332171
      // 02c: ldc_w -954332169
      // 02f: ixor
      // 030: invokestatic x/oc7ab2161b9f.ǽ (Lnet/minecraft/entity/Entity;I)D
      // 033: dstore 6
      // 035: dload 6
      // 037: iload 2
      // 038: ifne 058
      // 03b: ldc2_w 10.0
      // 03e: dcmpg
      // 03f: ifge 052
      // 042: goto 046
      // 045: athrow
      // 046: getstatic java/awt/Color.green Ljava/awt/Color;
      // 049: invokevirtual java/awt/Color.getRGB ()I
      // 04c: istore 5
      // 04e: iload 2
      // 04f: ifeq 0c1
      // 052: dload 6
      // 054: goto 058
      // 057: athrow
      // 058: ldc2_w 30.0
      // 05b: iload 2
      // 05c: ifne 084
      // 05f: dcmpg
      // 060: ifge 073
      // 063: goto 067
      // 066: athrow
      // 067: getstatic java/awt/Color.yellow Ljava/awt/Color;
      // 06a: invokevirtual java/awt/Color.getRGB ()I
      // 06d: istore 5
      // 06f: iload 2
      // 070: ifeq 0c1
      // 073: dload 6
      // 075: iload 2
      // 076: ifne 09a
      // 079: goto 07d
      // 07c: athrow
      // 07d: ldc2_w 60.0
      // 080: goto 084
      // 083: athrow
      // 084: dcmpg
      // 085: ifge 094
      // 088: getstatic java/awt/Color.orange Ljava/awt/Color;
      // 08b: invokevirtual java/awt/Color.getRGB ()I
      // 08e: istore 5
      // 090: iload 2
      // 091: ifeq 0c1
      // 094: dload 6
      // 096: goto 09a
      // 099: athrow
      // 09a: ldc2_w 160.0
      // 09d: dcmpg
      // 09e: iload 2
      // 09f: ifne 0bf
      // 0a2: ifge 0b5
      // 0a5: goto 0a9
      // 0a8: athrow
      // 0a9: getstatic java/awt/Color.red Ljava/awt/Color;
      // 0ac: invokevirtual java/awt/Color.getRGB ()I
      // 0af: istore 5
      // 0b1: iload 2
      // 0b2: ifeq 0c1
      // 0b5: getstatic java/awt/Color.black Ljava/awt/Color;
      // 0b8: invokevirtual java/awt/Color.getRGB ()I
      // 0bb: goto 0bf
      // 0be: athrow
      // 0bf: istore 5
      // 0c1: aload 4
      // 0c3: dload 6
      // 0c5: ldc_w "bps"
      // 0c8: invokedynamic makeConcatWithConstants (Ljava/lang/String;DLjava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001" ]
      // 0cd: astore 4
      // 0cf: iload 1
      // 0d0: iload 2
      // 0d1: ifne 152
      // 0d4: ifeq 10e
      // 0d7: goto 0db
      // 0da: athrow
      // 0db: invokestatic x/oc7ab2161b9f.ř ()D
      // 0de: dstore 6
      // 0e0: aload 4
      // 0e2: iload 2
      // 0e3: ifne 10c
      // 0e6: invokevirtual java/lang/String.isEmpty ()Z
      // 0e9: ifne 0f9
      // 0ec: goto 0f0
      // 0ef: athrow
      // 0f0: aload 4
      // 0f2: invokedynamic makeConcatWithConstants (Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001 " ]
      // 0f7: astore 4
      // 0f9: aload 4
      // 0fb: dload 6
      // 0fd: ldc_w -954332172
      // 100: ldc_w -954332169
      // 103: ixor
      // 104: invokestatic x/oc7ab2161b9f.ɜ (DI)D
      // 107: invokedynamic makeConcatWithConstants (Ljava/lang/String;D)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 10c: astore 4
      // 10e: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 111: getfield net/minecraft/client/Minecraft.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // 114: aload 4
      // 116: aload 3
      // 117: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledWidth ()I
      // 11a: ldc_w -954332171
      // 11d: ldc_w -954332169
      // 120: ixor
      // 121: idiv
      // 122: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 125: getfield net/minecraft/client/Minecraft.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // 128: aload 4
      // 12a: invokevirtual net/minecraft/client/gui/FontRenderer.getStringWidth (Ljava/lang/String;)I
      // 12d: ldc_w -954332171
      // 130: ldc_w -954332169
      // 133: ixor
      // 134: idiv
      // 135: isub
      // 136: i2f
      // 137: aload 3
      // 138: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledHeight ()I
      // 13b: ldc_w -954332171
      // 13e: ldc_w -954332169
      // 141: ixor
      // 142: idiv
      // 143: ldc_w -954332168
      // 146: ldc_w -954332169
      // 149: ixor
      // 14a: iadd
      // 14b: i2f
      // 14c: iload 5
      // 14e: bipush 0
      // 14f: invokevirtual net/minecraft/client/gui/FontRenderer.drawString (Ljava/lang/String;FFIZ)I
      // 152: pop
      // 153: return
   }

   public static void ƨ(Entity param0, int param1, double param2, double param4, int param6, boolean param7) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 8
      // 005: aload 0
      // 006: instanceof net/minecraft/entity/EntityLivingBase
      // 009: ifeq 5ce
      // 00c: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 00f: invokeinterface x/oc8ecfa69e1b.getTimer ()Lnet/minecraft/util/Timer; 1
      // 014: getfield net/minecraft/util/Timer.renderPartialTicks F
      // 017: fstore 9
      // 019: iload 8
      // 01b: aload 0
      // 01c: getfield net/minecraft/entity/Entity.lastTickPosX D
      // 01f: aload 0
      // 020: getfield net/minecraft/entity/Entity.posX D
      // 023: aload 0
      // 024: getfield net/minecraft/entity/Entity.lastTickPosX D
      // 027: dsub
      // 028: fload 9
      // 02a: f2d
      // 02b: dmul
      // 02c: dadd
      // 02d: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 030: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 033: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosX D
      // 036: dsub
      // 037: dstore 10
      // 039: aload 0
      // 03a: getfield net/minecraft/entity/Entity.lastTickPosY D
      // 03d: aload 0
      // 03e: getfield net/minecraft/entity/Entity.posY D
      // 041: aload 0
      // 042: getfield net/minecraft/entity/Entity.lastTickPosY D
      // 045: dsub
      // 046: fload 9
      // 048: f2d
      // 049: dmul
      // 04a: dadd
      // 04b: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 04e: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 051: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosY D
      // 054: dsub
      // 055: dstore 12
      // 057: aload 0
      // 058: getfield net/minecraft/entity/Entity.lastTickPosZ D
      // 05b: aload 0
      // 05c: getfield net/minecraft/entity/Entity.posZ D
      // 05f: aload 0
      // 060: getfield net/minecraft/entity/Entity.lastTickPosZ D
      // 063: dsub
      // 064: fload 9
      // 066: f2d
      // 067: dmul
      // 068: dadd
      // 069: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 06c: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 06f: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosZ D
      // 072: dsub
      // 073: dstore 14
      // 075: dload 2
      // 076: d2f
      // 077: ldc_w 40.0
      // 07a: fdiv
      // 07b: fstore 16
      // 07d: ifne 0bf
      // 080: aload 0
      // 081: instanceof net/minecraft/entity/player/EntityPlayer
      // 084: ifeq 0bc
      // 087: goto 08b
      // 08a: athrow
      // 08b: iload 7
      // 08d: iload 8
      // 08f: ifne 0c0
      // 092: goto 096
      // 095: athrow
      // 096: ifeq 0bc
      // 099: goto 09d
      // 09c: athrow
      // 09d: aload 0
      // 09e: checkcast net/minecraft/entity/player/EntityPlayer
      // 0a1: getfield net/minecraft/entity/player/EntityPlayer.hurtTime I
      // 0a4: iload 8
      // 0a6: ifne 0c0
      // 0a9: goto 0ad
      // 0ac: athrow
      // 0ad: ifeq 0bc
      // 0b0: goto 0b4
      // 0b3: athrow
      // 0b4: getstatic java/awt/Color.RED Ljava/awt/Color;
      // 0b7: invokevirtual java/awt/Color.getRGB ()I
      // 0ba: istore 6
      // 0bc: invokestatic net/minecraft/client/renderer/GlStateManager.pushMatrix ()V
      // 0bf: iload 1
      // 0c0: iload 8
      // 0c2: ifne 2bf
      // 0c5: ldc_w -1928380200
      // 0c8: ldc_w -1928380197
      // 0cb: ixor
      // 0cc: if_icmpne 2ba
      // 0cf: goto 0d3
      // 0d2: athrow
      // 0d3: dload 10
      // 0d5: dload 12
      // 0d7: ldc2_w 0.2
      // 0da: dsub
      // 0db: dload 14
      // 0dd: invokestatic org/lwjgl/opengl/GL11.glTranslated (DDD)V
      // 0e0: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 0e3: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 0e6: getfield net/minecraft/client/renderer/entity/RenderManager.playerViewY F
      // 0e9: fneg
      // 0ea: f2d
      // 0eb: dconst_0
      // 0ec: dconst_1
      // 0ed: dconst_0
      // 0ee: invokestatic org/lwjgl/opengl/GL11.glRotated (DDDD)V
      // 0f1: invokestatic net/minecraft/client/renderer/GlStateManager.disableDepth ()V
      // 0f4: ldc_w 0.03
      // 0f7: fload 16
      // 0f9: fadd
      // 0fa: ldc_w 0.03
      // 0fd: fload 16
      // 0ff: fadd
      // 100: ldc_w 0.03
      // 103: fload 16
      // 105: fadd
      // 106: invokestatic org/lwjgl/opengl/GL11.glScalef (FFF)V
      // 109: getstatic java/awt/Color.black Ljava/awt/Color;
      // 10c: invokevirtual java/awt/Color.getRGB ()I
      // 10f: istore 17
      // 111: ldc_w 1928380215
      // 114: ldc_w -1928380197
      // 117: ixor
      // 118: iload 8
      // 11a: ifne 221
      // 11d: bipush -1
      // 11e: ldc_w 1928380221
      // 121: ldc_w -1928380197
      // 124: ixor
      // 125: ldc_w -1928380272
      // 128: ldc_w -1928380197
      // 12b: ixor
      // 12c: iload 17
      // 12e: invokestatic net/minecraft/client/gui/Gui.drawRect (IIIII)V
      // 131: ldc_w -1928380209
      // 134: ldc_w -1928380197
      // 137: ixor
      // 138: bipush -1
      // 139: ldc_w -1928380223
      // 13c: ldc_w -1928380197
      // 13f: ixor
      // 140: ldc_w -1928380272
      // 143: ldc_w -1928380197
      // 146: ixor
      // 147: iload 17
      // 149: invokestatic net/minecraft/client/gui/Gui.drawRect (IIIII)V
      // 14c: ldc_w 1928380215
      // 14f: ldc_w -1928380197
      // 152: ixor
      // 153: bipush -1
      // 154: ldc_w -1928380210
      // 157: ldc_w -1928380197
      // 15a: ixor
      // 15b: ldc_w -1928380194
      // 15e: ldc_w -1928380197
      // 161: ixor
      // 162: iload 17
      // 164: invokestatic net/minecraft/client/gui/Gui.drawRect (IIIII)V
      // 167: ldc_w 1928380215
      // 16a: ldc_w -1928380197
      // 16d: ixor
      // 16e: ldc_w -1928380259
      // 171: ldc_w -1928380197
      // 174: ixor
      // 175: ldc_w -1928380210
      // 178: ldc_w -1928380197
      // 17b: ixor
      // 17c: ldc_w -1928380272
      // 17f: ldc_w -1928380197
      // 182: ixor
      // 183: iload 17
      // 185: invokestatic net/minecraft/client/gui/Gui.drawRect (IIIII)V
      // 188: iload 6
      // 18a: ifeq 20c
      // 18d: goto 191
      // 190: athrow
      // 191: ldc_w 1928380208
      // 194: ldc_w -1928380197
      // 197: ixor
      // 198: bipush 0
      // 199: ldc_w 1928380220
      // 19c: ldc_w -1928380197
      // 19f: ixor
      // 1a0: ldc_w -1928380271
      // 1a3: ldc_w -1928380197
      // 1a6: ixor
      // 1a7: iload 6
      // 1a9: invokestatic net/minecraft/client/gui/Gui.drawRect (IIIII)V
      // 1ac: iload 8
      // 1ae: ldc_w -1928380210
      // 1b1: ldc_w -1928380197
      // 1b4: ixor
      // 1b5: bipush 0
      // 1b6: ldc_w -1928380222
      // 1b9: ldc_w -1928380197
      // 1bc: ixor
      // 1bd: ldc_w -1928380271
      // 1c0: ldc_w -1928380197
      // 1c3: ixor
      // 1c4: iload 6
      // 1c6: invokestatic net/minecraft/client/gui/Gui.drawRect (IIIII)V
      // 1c9: ldc_w 1928380208
      // 1cc: ldc_w -1928380197
      // 1cf: ixor
      // 1d0: bipush 0
      // 1d1: ldc_w -1928380221
      // 1d4: ldc_w -1928380197
      // 1d7: ixor
      // 1d8: ldc_w -1928380193
      // 1db: ldc_w -1928380197
      // 1de: ixor
      // 1df: iload 6
      // 1e1: invokestatic net/minecraft/client/gui/Gui.drawRect (IIIII)V
      // 1e4: ldc_w 1928380208
      // 1e7: ldc_w -1928380197
      // 1ea: ixor
      // 1eb: ldc_w -1928380260
      // 1ee: ldc_w -1928380197
      // 1f1: ixor
      // 1f2: ldc_w -1928380222
      // 1f5: ldc_w -1928380197
      // 1f8: ixor
      // 1f9: ldc_w -1928380271
      // 1fc: ldc_w -1928380197
      // 1ff: ixor
      // 200: iload 6
      // 202: invokestatic net/minecraft/client/gui/Gui.drawRect (IIIII)V
      // 205: ifeq 2b2
      // 208: goto 20c
      // 20b: athrow
      // 20c: ldc2_w -2833697128535161461
      // 20f: ldc2_w -2833697128535161463
      // 212: lxor
      // 213: bipush 1
      // 214: newarray 11
      // 216: dup
      // 217: bipush 0
      // 218: lconst_0
      // 219: lastore
      // 21a: invokestatic x/oc7ab2161b9f.ƾ (J[J)I
      // 21d: goto 221
      // 220: athrow
      // 221: istore 18
      // 223: ldc2_w -2833697128535161461
      // 226: ldc2_w -2833697128535161463
      // 229: lxor
      // 22a: bipush 1
      // 22b: newarray 11
      // 22d: dup
      // 22e: bipush 0
      // 22f: ldc2_w -2833697128535161247
      // 232: ldc2_w -2833697128535161463
      // 235: lxor
      // 236: lastore
      // 237: invokestatic x/oc7ab2161b9f.ƾ (J[J)I
      // 23a: istore 19
      // 23c: ldc_w 1928380208
      // 23f: ldc_w -1928380197
      // 242: ixor
      // 243: bipush 0
      // 244: ldc_w 1928380220
      // 247: ldc_w -1928380197
      // 24a: ixor
      // 24b: ldc_w -1928380271
      // 24e: ldc_w -1928380197
      // 251: ixor
      // 252: iload 18
      // 254: iload 19
      // 256: invokestatic x/ocbd4917c4b1.խ (IIIIII)V
      // 259: ldc_w -1928380210
      // 25c: ldc_w -1928380197
      // 25f: ixor
      // 260: bipush 0
      // 261: ldc_w -1928380222
      // 264: ldc_w -1928380197
      // 267: ixor
      // 268: ldc_w -1928380271
      // 26b: ldc_w -1928380197
      // 26e: ixor
      // 26f: iload 18
      // 271: iload 19
      // 273: invokestatic x/ocbd4917c4b1.խ (IIIIII)V
      // 276: ldc_w 1928380208
      // 279: ldc_w -1928380197
      // 27c: ixor
      // 27d: bipush 0
      // 27e: ldc_w -1928380210
      // 281: ldc_w -1928380197
      // 284: ixor
      // 285: ldc_w -1928380193
      // 288: ldc_w -1928380197
      // 28b: ixor
      // 28c: iload 19
      // 28e: invokestatic net/minecraft/client/gui/Gui.drawRect (IIIII)V
      // 291: ldc_w 1928380208
      // 294: ldc_w -1928380197
      // 297: ixor
      // 298: ldc_w -1928380260
      // 29b: ldc_w -1928380197
      // 29e: ixor
      // 29f: ldc_w -1928380210
      // 2a2: ldc_w -1928380197
      // 2a5: ixor
      // 2a6: ldc_w -1928380271
      // 2a9: ldc_w -1928380197
      // 2ac: ixor
      // 2ad: iload 18
      // 2af: invokestatic net/minecraft/client/gui/Gui.drawRect (IIIII)V
      // 2b2: invokestatic net/minecraft/client/renderer/GlStateManager.enableDepth ()V
      // 2b5: iload 8
      // 2b7: ifeq 5cb
      // 2ba: iload 1
      // 2bb: goto 2bf
      // 2be: athrow
      // 2bf: iload 8
      // 2c1: ifne 3f1
      // 2c4: ldc_w -1928380193
      // 2c7: ldc_w -1928380197
      // 2ca: ixor
      // 2cb: if_icmpne 3ec
      // 2ce: goto 2d2
      // 2d1: athrow
      // 2d2: aload 0
      // 2d3: checkcast net/minecraft/entity/EntityLivingBase
      // 2d6: astore 18
      // 2d8: aload 18
      // 2da: invokevirtual net/minecraft/entity/EntityLivingBase.getHealth ()F
      // 2dd: aload 18
      // 2df: invokevirtual net/minecraft/entity/EntityLivingBase.getMaxHealth ()F
      // 2e2: fdiv
      // 2e3: f2d
      // 2e4: dstore 19
      // 2e6: ldc2_w 74.0
      // 2e9: dload 19
      // 2eb: dmul
      // 2ec: d2i
      // 2ed: istore 21
      // 2ef: dload 19
      // 2f1: iload 8
      // 2f3: ifne 30d
      // 2f6: ldc2_w 0.3
      // 2f9: dcmpg
      // 2fa: ifge 30b
      // 2fd: goto 301
      // 300: athrow
      // 301: getstatic java/awt/Color.red Ljava/awt/Color;
      // 304: invokevirtual java/awt/Color.getRGB ()I
      // 307: goto 34c
      // 30a: athrow
      // 30b: dload 19
      // 30d: iload 8
      // 30f: ifne 329
      // 312: ldc2_w 0.5
      // 315: dcmpg
      // 316: ifge 327
      // 319: goto 31d
      // 31c: athrow
      // 31d: getstatic java/awt/Color.orange Ljava/awt/Color;
      // 320: invokevirtual java/awt/Color.getRGB ()I
      // 323: goto 34c
      // 326: athrow
      // 327: dload 19
      // 329: ldc2_w 0.7
      // 32c: dcmpg
      // 32d: iload 8
      // 32f: ifne 343
      // 332: ifge 346
      // 335: goto 339
      // 338: athrow
      // 339: getstatic java/awt/Color.yellow Ljava/awt/Color;
      // 33c: invokevirtual java/awt/Color.getRGB ()I
      // 33f: goto 343
      // 342: athrow
      // 343: goto 34c
      // 346: getstatic java/awt/Color.green Ljava/awt/Color;
      // 349: invokevirtual java/awt/Color.getRGB ()I
      // 34c: istore 22
      // 34e: iload 8
      // 350: dload 10
      // 352: dload 12
      // 354: ldc2_w 0.2
      // 357: dsub
      // 358: dload 14
      // 35a: invokestatic org/lwjgl/opengl/GL11.glTranslated (DDD)V
      // 35d: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 360: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 363: getfield net/minecraft/client/renderer/entity/RenderManager.playerViewY F
      // 366: fneg
      // 367: f2d
      // 368: dconst_0
      // 369: dconst_1
      // 36a: dconst_0
      // 36b: invokestatic org/lwjgl/opengl/GL11.glRotated (DDDD)V
      // 36e: invokestatic net/minecraft/client/renderer/GlStateManager.disableDepth ()V
      // 371: ldc_w 0.03
      // 374: fload 16
      // 376: fadd
      // 377: ldc_w 0.03
      // 37a: fload 16
      // 37c: fadd
      // 37d: ldc_w 0.03
      // 380: fload 16
      // 382: fadd
      // 383: invokestatic org/lwjgl/opengl/GL11.glScalef (FFF)V
      // 386: ldc2_w 21.0
      // 389: dload 4
      // 38b: ldc2_w 2.0
      // 38e: dmul
      // 38f: dadd
      // 390: d2i
      // 391: istore 17
      // 393: iload 17
      // 395: bipush -1
      // 396: iload 17
      // 398: ldc_w -1928380193
      // 39b: ldc_w -1928380197
      // 39e: ixor
      // 39f: iadd
      // 3a0: ldc_w -1928380272
      // 3a3: ldc_w -1928380197
      // 3a6: ixor
      // 3a7: getstatic java/awt/Color.black Ljava/awt/Color;
      // 3aa: invokevirtual java/awt/Color.getRGB ()I
      // 3ad: invokestatic net/minecraft/client/gui/Gui.drawRect (IIIII)V
      // 3b0: iload 17
      // 3b2: bipush 1
      // 3b3: iadd
      // 3b4: iload 21
      // 3b6: iload 17
      // 3b8: ldc_w -1928380200
      // 3bb: ldc_w -1928380197
      // 3be: ixor
      // 3bf: iadd
      // 3c0: ldc_w -1928380271
      // 3c3: ldc_w -1928380197
      // 3c6: ixor
      // 3c7: getstatic java/awt/Color.darkGray Ljava/awt/Color;
      // 3ca: invokevirtual java/awt/Color.getRGB ()I
      // 3cd: invokestatic net/minecraft/client/gui/Gui.drawRect (IIIII)V
      // 3d0: iload 17
      // 3d2: bipush 1
      // 3d3: iadd
      // 3d4: bipush 0
      // 3d5: iload 17
      // 3d7: ldc_w -1928380200
      // 3da: ldc_w -1928380197
      // 3dd: ixor
      // 3de: iadd
      // 3df: iload 21
      // 3e1: iload 22
      // 3e3: invokestatic net/minecraft/client/gui/Gui.drawRect (IIIII)V
      // 3e6: invokestatic net/minecraft/client/renderer/GlStateManager.enableDepth ()V
      // 3e9: ifeq 5cb
      // 3ec: iload 1
      // 3ed: goto 3f1
      // 3f0: athrow
      // 3f1: iload 8
      // 3f3: ifne 43e
      // 3f6: ldc_w -1928380195
      // 3f9: ldc_w -1928380197
      // 3fc: ixor
      // 3fd: if_icmpne 438
      // 400: goto 404
      // 403: athrow
      // 404: dload 10
      // 406: dload 12
      // 408: dload 14
      // 40a: ldc2_w 0.699999988079071
      // 40d: ldc_w -1928380170
      // 410: ldc_w -1928380197
      // 413: ixor
      // 414: ldc_w 1.5
      // 417: iload 6
      // 419: iload 6
      // 41b: iload 8
      // 41d: ifne 42c
      // 420: goto 424
      // 423: athrow
      // 424: ifne 42f
      // 427: goto 42b
      // 42a: athrow
      // 42b: bipush 1
      // 42c: goto 430
      // 42f: bipush 0
      // 430: invokestatic x/ocbd4917c4b1.Σ (DDDDIFIZ)V
      // 433: iload 8
      // 435: ifeq 5cb
      // 438: iload 6
      // 43a: goto 43e
      // 43d: athrow
      // 43e: iload 8
      // 440: ifne 46f
      // 443: ifne 45d
      // 446: goto 44a
      // 449: athrow
      // 44a: ldc2_w -2833697128535161461
      // 44d: ldc2_w -2833697128535161463
      // 450: lxor
      // 451: bipush 1
      // 452: newarray 11
      // 454: dup
      // 455: bipush 0
      // 456: lconst_0
      // 457: lastore
      // 458: invokestatic x/oc7ab2161b9f.ƾ (J[J)I
      // 45b: istore 6
      // 45d: iload 6
      // 45f: ldc_w -1928380221
      // 462: ldc_w -1928380197
      // 465: ixor
      // 466: ishr
      // 467: ldc_w -1928380380
      // 46a: ldc_w -1928380197
      // 46d: ixor
      // 46e: iand
      // 46f: i2f
      // 470: ldc 255.0
      // 472: fdiv
      // 473: fstore 18
      // 475: iload 6
      // 477: ldc_w -1928380213
      // 47a: ldc_w -1928380197
      // 47d: ixor
      // 47e: ishr
      // 47f: ldc_w -1928380380
      // 482: ldc_w -1928380197
      // 485: ixor
      // 486: iand
      // 487: i2f
      // 488: ldc 255.0
      // 48a: fdiv
      // 48b: fstore 19
      // 48d: iload 6
      // 48f: ldc_w -1928380205
      // 492: ldc_w -1928380197
      // 495: ixor
      // 496: ishr
      // 497: ldc_w -1928380380
      // 49a: ldc_w -1928380197
      // 49d: ixor
      // 49e: iand
      // 49f: i2f
      // 4a0: ldc 255.0
      // 4a2: fdiv
      // 4a3: fstore 20
      // 4a5: iload 6
      // 4a7: ldc_w -1928380380
      // 4aa: ldc_w -1928380197
      // 4ad: ixor
      // 4ae: iand
      // 4af: i2f
      // 4b0: ldc 255.0
      // 4b2: fdiv
      // 4b3: fstore 21
      // 4b5: aload 0
      // 4b6: invokevirtual net/minecraft/entity/Entity.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 4b9: ldc2_w 0.1
      // 4bc: dload 2
      // 4bd: dadd
      // 4be: ldc2_w 0.1
      // 4c1: dload 2
      // 4c2: dadd
      // 4c3: ldc2_w 0.1
      // 4c6: dload 2
      // 4c7: dadd
      // 4c8: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 4cb: astore 22
      // 4cd: new net/minecraft/util/AxisAlignedBB
      // 4d0: dup
      // 4d1: aload 22
      // 4d3: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 4d6: aload 0
      // 4d7: getfield net/minecraft/entity/Entity.posX D
      // 4da: dsub
      // 4db: dload 10
      // 4dd: dadd
      // 4de: aload 22
      // 4e0: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 4e3: aload 0
      // 4e4: getfield net/minecraft/entity/Entity.posY D
      // 4e7: dsub
      // 4e8: dload 12
      // 4ea: dadd
      // 4eb: aload 22
      // 4ed: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 4f0: aload 0
      // 4f1: getfield net/minecraft/entity/Entity.posZ D
      // 4f4: dsub
      // 4f5: dload 14
      // 4f7: dadd
      // 4f8: aload 22
      // 4fa: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 4fd: aload 0
      // 4fe: getfield net/minecraft/entity/Entity.posX D
      // 501: dsub
      // 502: dload 10
      // 504: dadd
      // 505: aload 22
      // 507: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 50a: aload 0
      // 50b: getfield net/minecraft/entity/Entity.posY D
      // 50e: dsub
      // 50f: dload 12
      // 511: dadd
      // 512: aload 22
      // 514: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 517: aload 0
      // 518: getfield net/minecraft/entity/Entity.posZ D
      // 51b: dsub
      // 51c: dload 14
      // 51e: dadd
      // 51f: invokespecial net/minecraft/util/AxisAlignedBB.<init> (DDDDDD)V
      // 522: astore 23
      // 524: ldc_w -1928379431
      // 527: ldc_w -1928380197
      // 52a: ixor
      // 52b: ldc_w -1928379432
      // 52e: ldc_w -1928380197
      // 531: ixor
      // 532: invokestatic org/lwjgl/opengl/GL11.glBlendFunc (II)V
      // 535: ldc_w -1928377543
      // 538: ldc_w -1928380197
      // 53b: ixor
      // 53c: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 53f: ldc_w -1928377030
      // 542: ldc_w -1928380197
      // 545: ixor
      // 546: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 549: ldc_w -1928377430
      // 54c: ldc_w -1928380197
      // 54f: ixor
      // 550: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 553: bipush 0
      // 554: iload 8
      // 556: ifne 587
      // 559: invokestatic org/lwjgl/opengl/GL11.glDepthMask (Z)V
      // 55c: fconst_2
      // 55d: invokestatic org/lwjgl/opengl/GL11.glLineWidth (F)V
      // 560: fload 19
      // 562: fload 20
      // 564: fload 21
      // 566: fload 18
      // 568: invokestatic org/lwjgl/opengl/GL11.glColor4f (FFFF)V
      // 56b: iload 1
      // 56c: bipush 1
      // 56d: if_icmpne 582
      // 570: goto 574
      // 573: athrow
      // 574: aload 23
      // 576: invokestatic net/minecraft/client/renderer/RenderGlobal.drawSelectionBoundingBox (Lnet/minecraft/util/AxisAlignedBB;)V
      // 579: iload 8
      // 57b: ifeq 5a9
      // 57e: goto 582
      // 581: athrow
      // 582: iload 1
      // 583: goto 587
      // 586: athrow
      // 587: iload 8
      // 589: ifne 5c8
      // 58c: ldc_w -1928380199
      // 58f: ldc_w -1928380197
      // 592: ixor
      // 593: if_icmpne 5a9
      // 596: goto 59a
      // 599: athrow
      // 59a: aload 23
      // 59c: fload 19
      // 59e: fload 20
      // 5a0: fload 21
      // 5a2: invokestatic x/ocbd4917c4b1.x (Lnet/minecraft/util/AxisAlignedBB;FFF)V
      // 5a5: goto 5a9
      // 5a8: athrow
      // 5a9: ldc_w -1928377030
      // 5ac: ldc_w -1928380197
      // 5af: ixor
      // 5b0: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 5b3: ldc_w -1928377430
      // 5b6: ldc_w -1928380197
      // 5b9: ixor
      // 5ba: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 5bd: bipush 1
      // 5be: invokestatic org/lwjgl/opengl/GL11.glDepthMask (Z)V
      // 5c1: ldc_w -1928377543
      // 5c4: ldc_w -1928380197
      // 5c7: ixor
      // 5c8: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 5cb: invokestatic net/minecraft/client/renderer/GlStateManager.popMatrix ()V
      // 5ce: return
   }

   public static void Æ(double param0, double param2, double param4, int param6, int param7) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 8
      // 005: iload 6
      // 007: iload 8
      // 009: ifne 02e
      // 00c: ldc_w -987278220
      // 00f: ldc_w -987278217
      // 012: ixor
      // 013: if_icmpge 01c
      // 016: goto 01a
      // 019: athrow
      // 01a: return
      // 01b: athrow
      // 01c: iload 7
      // 01e: ldc_w -987278225
      // 021: ldc_w -987278217
      // 024: ixor
      // 025: ishr
      // 026: ldc_w -987278200
      // 029: ldc_w -987278217
      // 02c: ixor
      // 02d: iand
      // 02e: i2f
      // 02f: ldc 255.0
      // 031: fdiv
      // 032: fstore 9
      // 034: iload 7
      // 036: ldc_w -987278233
      // 039: ldc_w -987278217
      // 03c: ixor
      // 03d: ishr
      // 03e: ldc_w -987278200
      // 041: ldc_w -987278217
      // 044: ixor
      // 045: iand
      // 046: i2f
      // 047: ldc 255.0
      // 049: fdiv
      // 04a: fstore 10
      // 04c: iload 7
      // 04e: ldc_w -987278209
      // 051: ldc_w -987278217
      // 054: ixor
      // 055: ishr
      // 056: ldc_w -987278200
      // 059: ldc_w -987278217
      // 05c: ixor
      // 05d: iand
      // 05e: i2f
      // 05f: ldc 255.0
      // 061: fdiv
      // 062: fstore 11
      // 064: iload 7
      // 066: ldc_w -987278200
      // 069: ldc_w -987278217
      // 06c: ixor
      // 06d: iand
      // 06e: i2f
      // 06f: ldc 255.0
      // 071: fdiv
      // 072: fstore 12
      // 074: invokestatic net/minecraft/client/renderer/Tessellator.getInstance ()Lnet/minecraft/client/renderer/Tessellator;
      // 077: astore 13
      // 079: aload 13
      // 07b: invokevirtual net/minecraft/client/renderer/Tessellator.getWorldRenderer ()Lnet/minecraft/client/renderer/WorldRenderer;
      // 07e: astore 14
      // 080: invokestatic net/minecraft/client/renderer/GlStateManager.enableBlend ()V
      // 083: invokestatic net/minecraft/client/renderer/GlStateManager.disableTexture2D ()V
      // 086: ldc_w -987277451
      // 089: ldc_w -987278217
      // 08c: ixor
      // 08d: ldc_w -987277452
      // 090: ldc_w -987278217
      // 093: ixor
      // 094: bipush 1
      // 095: bipush 0
      // 096: invokestatic net/minecraft/client/renderer/GlStateManager.tryBlendFuncSeparate (IIII)V
      // 099: fload 10
      // 09b: fload 11
      // 09d: fload 12
      // 09f: fload 9
      // 0a1: invokestatic org/lwjgl/opengl/GL11.glColor4f (FFFF)V
      // 0a4: aload 14
      // 0a6: ldc_w -987278223
      // 0a9: ldc_w -987278217
      // 0ac: ixor
      // 0ad: getstatic net/minecraft/client/renderer/vertex/DefaultVertexFormats.POSITION Lnet/minecraft/client/renderer/vertex/VertexFormat;
      // 0b0: invokevirtual net/minecraft/client/renderer/WorldRenderer.begin (ILnet/minecraft/client/renderer/vertex/VertexFormat;)V
      // 0b3: bipush 0
      // 0b4: istore 15
      // 0b6: iload 15
      // 0b8: iload 6
      // 0ba: if_icmpge 0ff
      // 0bd: ldc2_w 6.283185307179586
      // 0c0: iload 15
      // 0c2: i2d
      // 0c3: dmul
      // 0c4: iload 6
      // 0c6: i2d
      // 0c7: ddiv
      // 0c8: ldc2_w 180.0
      // 0cb: invokestatic java/lang/Math.toRadians (D)D
      // 0ce: dadd
      // 0cf: dstore 16
      // 0d1: iload 8
      // 0d3: aload 14
      // 0d5: dload 0
      // 0d6: dload 16
      // 0d8: invokestatic java/lang/Math.sin (D)D
      // 0db: dload 4
      // 0dd: dmul
      // 0de: dadd
      // 0df: dload 2
      // 0e0: dload 16
      // 0e2: invokestatic java/lang/Math.cos (D)D
      // 0e5: dload 4
      // 0e7: dmul
      // 0e8: dadd
      // 0e9: dconst_0
      // 0ea: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 0ed: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 0f0: ifne 10a
      // 0f3: iinc 15 1
      // 0f6: iload 8
      // 0f8: ifeq 0b6
      // 0fb: goto 0ff
      // 0fe: athrow
      // 0ff: aload 13
      // 101: invokevirtual net/minecraft/client/renderer/Tessellator.draw ()V
      // 104: invokestatic net/minecraft/client/renderer/GlStateManager.enableTexture2D ()V
      // 107: invokestatic net/minecraft/client/renderer/GlStateManager.disableBlend ()V
      // 10a: return
   }

   public static void ԁ(AxisAlignedBB var0, double var1, double var3, double var5) {
      AxisAlignedBB var7 = var0.offset(-var1, -var3, -var5);
      RenderGlobal.drawSelectionBoundingBox(var7);
   }

   public static void x(AxisAlignedBB var0, float var1, float var2, float var3) {
      ʓ(var0, var1, var2, var3, 0.25F);
   }

   public static void ʓ(AxisAlignedBB param0, float param1, float param2, float param3, float param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: invokestatic net/minecraft/client/renderer/Tessellator.getInstance ()Lnet/minecraft/client/renderer/Tessellator;
      // 003: astore 6
      // 005: aload 6
      // 007: invokevirtual net/minecraft/client/renderer/Tessellator.getWorldRenderer ()Lnet/minecraft/client/renderer/WorldRenderer;
      // 00a: astore 7
      // 00c: aload 7
      // 00e: ldc_w 1026071960
      // 011: ldc_w 1026071967
      // 014: ixor
      // 015: getstatic net/minecraft/client/renderer/vertex/DefaultVertexFormats.POSITION_COLOR Lnet/minecraft/client/renderer/vertex/VertexFormat;
      // 018: invokevirtual net/minecraft/client/renderer/WorldRenderer.begin (ILnet/minecraft/client/renderer/vertex/VertexFormat;)V
      // 01b: aload 7
      // 01d: aload 0
      // 01e: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 021: aload 0
      // 022: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 025: aload 0
      // 026: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 029: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 02c: fload 1
      // 02d: fload 2
      // 02e: fload 3
      // 02f: fload 4
      // 031: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 034: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 037: aload 7
      // 039: aload 0
      // 03a: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 03d: aload 0
      // 03e: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 041: aload 0
      // 042: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 045: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 048: fload 1
      // 049: fload 2
      // 04a: fload 3
      // 04b: fload 4
      // 04d: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 050: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 053: aload 7
      // 055: aload 0
      // 056: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 059: aload 0
      // 05a: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 05d: aload 0
      // 05e: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 061: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 064: fload 1
      // 065: fload 2
      // 066: fload 3
      // 067: fload 4
      // 069: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 06c: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 06f: getstatic x/oc75d51ec7eb.ϩ I
      // 072: aload 7
      // 074: aload 0
      // 075: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 078: aload 0
      // 079: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 07c: aload 0
      // 07d: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 080: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 083: fload 1
      // 084: fload 2
      // 085: fload 3
      // 086: fload 4
      // 088: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 08b: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 08e: aload 7
      // 090: aload 0
      // 091: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 094: aload 0
      // 095: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 098: aload 0
      // 099: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 09c: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 09f: fload 1
      // 0a0: fload 2
      // 0a1: fload 3
      // 0a2: fload 4
      // 0a4: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 0a7: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 0aa: aload 7
      // 0ac: aload 0
      // 0ad: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 0b0: aload 0
      // 0b1: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 0b4: aload 0
      // 0b5: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 0b8: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 0bb: fload 1
      // 0bc: fload 2
      // 0bd: fload 3
      // 0be: fload 4
      // 0c0: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 0c3: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 0c6: aload 7
      // 0c8: aload 0
      // 0c9: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 0cc: aload 0
      // 0cd: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 0d0: aload 0
      // 0d1: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 0d4: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 0d7: fload 1
      // 0d8: fload 2
      // 0d9: fload 3
      // 0da: fload 4
      // 0dc: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 0df: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 0e2: aload 7
      // 0e4: aload 0
      // 0e5: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 0e8: aload 0
      // 0e9: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 0ec: aload 0
      // 0ed: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 0f0: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 0f3: fload 1
      // 0f4: fload 2
      // 0f5: fload 3
      // 0f6: fload 4
      // 0f8: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 0fb: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 0fe: aload 6
      // 100: invokevirtual net/minecraft/client/renderer/Tessellator.draw ()V
      // 103: aload 7
      // 105: ldc_w 1026071960
      // 108: ldc_w 1026071967
      // 10b: ixor
      // 10c: getstatic net/minecraft/client/renderer/vertex/DefaultVertexFormats.POSITION_COLOR Lnet/minecraft/client/renderer/vertex/VertexFormat;
      // 10f: invokevirtual net/minecraft/client/renderer/WorldRenderer.begin (ILnet/minecraft/client/renderer/vertex/VertexFormat;)V
      // 112: aload 7
      // 114: aload 0
      // 115: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 118: aload 0
      // 119: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 11c: aload 0
      // 11d: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 120: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 123: fload 1
      // 124: fload 2
      // 125: fload 3
      // 126: fload 4
      // 128: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 12b: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 12e: aload 7
      // 130: aload 0
      // 131: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 134: aload 0
      // 135: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 138: aload 0
      // 139: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 13c: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 13f: fload 1
      // 140: fload 2
      // 141: fload 3
      // 142: fload 4
      // 144: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 147: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 14a: aload 7
      // 14c: aload 0
      // 14d: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 150: aload 0
      // 151: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 154: aload 0
      // 155: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 158: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 15b: fload 1
      // 15c: fload 2
      // 15d: fload 3
      // 15e: fload 4
      // 160: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 163: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 166: aload 7
      // 168: aload 0
      // 169: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 16c: aload 0
      // 16d: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 170: aload 0
      // 171: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 174: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 177: fload 1
      // 178: fload 2
      // 179: fload 3
      // 17a: fload 4
      // 17c: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 17f: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 182: aload 7
      // 184: aload 0
      // 185: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 188: aload 0
      // 189: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 18c: aload 0
      // 18d: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 190: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 193: fload 1
      // 194: fload 2
      // 195: fload 3
      // 196: fload 4
      // 198: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 19b: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 19e: aload 7
      // 1a0: aload 0
      // 1a1: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 1a4: aload 0
      // 1a5: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 1a8: aload 0
      // 1a9: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 1ac: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 1af: fload 1
      // 1b0: fload 2
      // 1b1: fload 3
      // 1b2: fload 4
      // 1b4: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 1b7: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 1ba: aload 7
      // 1bc: aload 0
      // 1bd: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 1c0: aload 0
      // 1c1: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 1c4: aload 0
      // 1c5: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 1c8: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 1cb: fload 1
      // 1cc: fload 2
      // 1cd: fload 3
      // 1ce: fload 4
      // 1d0: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 1d3: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 1d6: aload 7
      // 1d8: aload 0
      // 1d9: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 1dc: aload 0
      // 1dd: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 1e0: aload 0
      // 1e1: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 1e4: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 1e7: fload 1
      // 1e8: fload 2
      // 1e9: fload 3
      // 1ea: fload 4
      // 1ec: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 1ef: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 1f2: aload 6
      // 1f4: invokevirtual net/minecraft/client/renderer/Tessellator.draw ()V
      // 1f7: aload 7
      // 1f9: ldc_w 1026071960
      // 1fc: ldc_w 1026071967
      // 1ff: ixor
      // 200: getstatic net/minecraft/client/renderer/vertex/DefaultVertexFormats.POSITION_COLOR Lnet/minecraft/client/renderer/vertex/VertexFormat;
      // 203: invokevirtual net/minecraft/client/renderer/WorldRenderer.begin (ILnet/minecraft/client/renderer/vertex/VertexFormat;)V
      // 206: aload 7
      // 208: aload 0
      // 209: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 20c: aload 0
      // 20d: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 210: aload 0
      // 211: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 214: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 217: fload 1
      // 218: fload 2
      // 219: fload 3
      // 21a: fload 4
      // 21c: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 21f: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 222: aload 7
      // 224: aload 0
      // 225: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 228: aload 0
      // 229: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 22c: aload 0
      // 22d: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 230: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 233: fload 1
      // 234: fload 2
      // 235: fload 3
      // 236: fload 4
      // 238: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 23b: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 23e: aload 7
      // 240: aload 0
      // 241: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 244: aload 0
      // 245: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 248: aload 0
      // 249: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 24c: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 24f: fload 1
      // 250: fload 2
      // 251: fload 3
      // 252: fload 4
      // 254: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 257: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 25a: aload 7
      // 25c: aload 0
      // 25d: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 260: aload 0
      // 261: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 264: aload 0
      // 265: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 268: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 26b: fload 1
      // 26c: fload 2
      // 26d: fload 3
      // 26e: fload 4
      // 270: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 273: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 276: aload 7
      // 278: aload 0
      // 279: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 27c: aload 0
      // 27d: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 280: aload 0
      // 281: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 284: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 287: fload 1
      // 288: fload 2
      // 289: fload 3
      // 28a: fload 4
      // 28c: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 28f: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 292: aload 7
      // 294: aload 0
      // 295: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 298: aload 0
      // 299: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 29c: aload 0
      // 29d: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 2a0: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 2a3: fload 1
      // 2a4: fload 2
      // 2a5: fload 3
      // 2a6: fload 4
      // 2a8: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 2ab: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 2ae: aload 7
      // 2b0: aload 0
      // 2b1: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 2b4: aload 0
      // 2b5: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 2b8: aload 0
      // 2b9: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 2bc: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 2bf: fload 1
      // 2c0: fload 2
      // 2c1: fload 3
      // 2c2: fload 4
      // 2c4: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 2c7: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 2ca: aload 7
      // 2cc: aload 0
      // 2cd: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 2d0: aload 0
      // 2d1: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 2d4: aload 0
      // 2d5: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 2d8: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 2db: fload 1
      // 2dc: fload 2
      // 2dd: fload 3
      // 2de: fload 4
      // 2e0: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 2e3: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 2e6: aload 6
      // 2e8: invokevirtual net/minecraft/client/renderer/Tessellator.draw ()V
      // 2eb: aload 7
      // 2ed: ldc_w 1026071960
      // 2f0: ldc_w 1026071967
      // 2f3: ixor
      // 2f4: getstatic net/minecraft/client/renderer/vertex/DefaultVertexFormats.POSITION_COLOR Lnet/minecraft/client/renderer/vertex/VertexFormat;
      // 2f7: invokevirtual net/minecraft/client/renderer/WorldRenderer.begin (ILnet/minecraft/client/renderer/vertex/VertexFormat;)V
      // 2fa: aload 7
      // 2fc: aload 0
      // 2fd: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 300: aload 0
      // 301: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 304: aload 0
      // 305: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 308: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 30b: fload 1
      // 30c: fload 2
      // 30d: fload 3
      // 30e: fload 4
      // 310: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 313: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 316: aload 7
      // 318: aload 0
      // 319: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 31c: aload 0
      // 31d: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 320: aload 0
      // 321: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 324: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 327: fload 1
      // 328: fload 2
      // 329: fload 3
      // 32a: fload 4
      // 32c: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 32f: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 332: aload 7
      // 334: aload 0
      // 335: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 338: aload 0
      // 339: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 33c: aload 0
      // 33d: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 340: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 343: fload 1
      // 344: fload 2
      // 345: fload 3
      // 346: fload 4
      // 348: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 34b: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 34e: aload 7
      // 350: aload 0
      // 351: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 354: aload 0
      // 355: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 358: aload 0
      // 359: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 35c: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 35f: fload 1
      // 360: fload 2
      // 361: fload 3
      // 362: fload 4
      // 364: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 367: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 36a: aload 7
      // 36c: aload 0
      // 36d: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 370: aload 0
      // 371: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 374: aload 0
      // 375: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 378: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 37b: fload 1
      // 37c: fload 2
      // 37d: fload 3
      // 37e: fload 4
      // 380: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 383: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 386: aload 7
      // 388: aload 0
      // 389: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 38c: aload 0
      // 38d: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 390: aload 0
      // 391: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 394: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 397: fload 1
      // 398: fload 2
      // 399: fload 3
      // 39a: fload 4
      // 39c: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 39f: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 3a2: aload 7
      // 3a4: aload 0
      // 3a5: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 3a8: aload 0
      // 3a9: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 3ac: aload 0
      // 3ad: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 3b0: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 3b3: fload 1
      // 3b4: fload 2
      // 3b5: fload 3
      // 3b6: fload 4
      // 3b8: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 3bb: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 3be: aload 7
      // 3c0: aload 0
      // 3c1: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 3c4: aload 0
      // 3c5: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 3c8: aload 0
      // 3c9: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 3cc: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 3cf: fload 1
      // 3d0: fload 2
      // 3d1: fload 3
      // 3d2: fload 4
      // 3d4: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 3d7: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 3da: aload 6
      // 3dc: invokevirtual net/minecraft/client/renderer/Tessellator.draw ()V
      // 3df: aload 7
      // 3e1: ldc_w 1026071960
      // 3e4: ldc_w 1026071967
      // 3e7: ixor
      // 3e8: getstatic net/minecraft/client/renderer/vertex/DefaultVertexFormats.POSITION_COLOR Lnet/minecraft/client/renderer/vertex/VertexFormat;
      // 3eb: invokevirtual net/minecraft/client/renderer/WorldRenderer.begin (ILnet/minecraft/client/renderer/vertex/VertexFormat;)V
      // 3ee: aload 7
      // 3f0: aload 0
      // 3f1: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 3f4: aload 0
      // 3f5: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 3f8: aload 0
      // 3f9: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 3fc: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 3ff: fload 1
      // 400: fload 2
      // 401: fload 3
      // 402: fload 4
      // 404: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 407: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 40a: aload 7
      // 40c: aload 0
      // 40d: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 410: aload 0
      // 411: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 414: aload 0
      // 415: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 418: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 41b: fload 1
      // 41c: fload 2
      // 41d: fload 3
      // 41e: fload 4
      // 420: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 423: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 426: aload 7
      // 428: aload 0
      // 429: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 42c: aload 0
      // 42d: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 430: aload 0
      // 431: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 434: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 437: fload 1
      // 438: fload 2
      // 439: fload 3
      // 43a: fload 4
      // 43c: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 43f: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 442: aload 7
      // 444: aload 0
      // 445: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 448: aload 0
      // 449: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 44c: aload 0
      // 44d: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 450: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 453: fload 1
      // 454: fload 2
      // 455: fload 3
      // 456: fload 4
      // 458: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 45b: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 45e: aload 7
      // 460: aload 0
      // 461: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 464: aload 0
      // 465: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 468: aload 0
      // 469: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 46c: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 46f: fload 1
      // 470: fload 2
      // 471: fload 3
      // 472: fload 4
      // 474: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 477: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 47a: aload 7
      // 47c: aload 0
      // 47d: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 480: aload 0
      // 481: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 484: aload 0
      // 485: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 488: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 48b: fload 1
      // 48c: fload 2
      // 48d: fload 3
      // 48e: fload 4
      // 490: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 493: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 496: aload 7
      // 498: aload 0
      // 499: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 49c: aload 0
      // 49d: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 4a0: aload 0
      // 4a1: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 4a4: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 4a7: fload 1
      // 4a8: fload 2
      // 4a9: fload 3
      // 4aa: fload 4
      // 4ac: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 4af: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 4b2: aload 7
      // 4b4: aload 0
      // 4b5: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 4b8: aload 0
      // 4b9: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 4bc: aload 0
      // 4bd: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 4c0: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 4c3: fload 1
      // 4c4: fload 2
      // 4c5: fload 3
      // 4c6: fload 4
      // 4c8: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 4cb: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 4ce: aload 6
      // 4d0: invokevirtual net/minecraft/client/renderer/Tessellator.draw ()V
      // 4d3: aload 7
      // 4d5: ldc_w 1026071960
      // 4d8: ldc_w 1026071967
      // 4db: ixor
      // 4dc: getstatic net/minecraft/client/renderer/vertex/DefaultVertexFormats.POSITION_COLOR Lnet/minecraft/client/renderer/vertex/VertexFormat;
      // 4df: invokevirtual net/minecraft/client/renderer/WorldRenderer.begin (ILnet/minecraft/client/renderer/vertex/VertexFormat;)V
      // 4e2: aload 7
      // 4e4: aload 0
      // 4e5: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 4e8: aload 0
      // 4e9: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 4ec: aload 0
      // 4ed: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 4f0: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 4f3: fload 1
      // 4f4: fload 2
      // 4f5: fload 3
      // 4f6: fload 4
      // 4f8: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 4fb: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 4fe: aload 7
      // 500: aload 0
      // 501: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 504: aload 0
      // 505: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 508: aload 0
      // 509: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 50c: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 50f: fload 1
      // 510: fload 2
      // 511: fload 3
      // 512: fload 4
      // 514: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 517: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 51a: aload 7
      // 51c: aload 0
      // 51d: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 520: aload 0
      // 521: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 524: aload 0
      // 525: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 528: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 52b: fload 1
      // 52c: fload 2
      // 52d: fload 3
      // 52e: fload 4
      // 530: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 533: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 536: aload 7
      // 538: aload 0
      // 539: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 53c: aload 0
      // 53d: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 540: aload 0
      // 541: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 544: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 547: fload 1
      // 548: fload 2
      // 549: fload 3
      // 54a: fload 4
      // 54c: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 54f: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 552: aload 7
      // 554: aload 0
      // 555: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 558: aload 0
      // 559: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 55c: aload 0
      // 55d: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 560: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 563: fload 1
      // 564: fload 2
      // 565: fload 3
      // 566: fload 4
      // 568: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 56b: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 56e: aload 7
      // 570: aload 0
      // 571: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 574: aload 0
      // 575: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 578: aload 0
      // 579: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 57c: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 57f: fload 1
      // 580: fload 2
      // 581: fload 3
      // 582: fload 4
      // 584: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 587: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 58a: aload 7
      // 58c: aload 0
      // 58d: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 590: aload 0
      // 591: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 594: aload 0
      // 595: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 598: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 59b: fload 1
      // 59c: fload 2
      // 59d: fload 3
      // 59e: fload 4
      // 5a0: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 5a3: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 5a6: istore 5
      // 5a8: aload 7
      // 5aa: aload 0
      // 5ab: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 5ae: aload 0
      // 5af: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 5b2: aload 0
      // 5b3: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 5b6: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 5b9: fload 1
      // 5ba: fload 2
      // 5bb: fload 3
      // 5bc: fload 4
      // 5be: invokevirtual net/minecraft/client/renderer/WorldRenderer.color (FFFF)Lnet/minecraft/client/renderer/WorldRenderer;
      // 5c1: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 5c4: aload 6
      // 5c6: invokevirtual net/minecraft/client/renderer/Tessellator.draw ()V
      // 5c9: iload 5
      // 5cb: ifeq 5df
      // 5ce: bipush 0
      // 5cf: ifeq 5db
      // 5d2: goto 5d6
      // 5d5: athrow
      // 5d6: bipush 0
      // 5d7: goto 5dc
      // 5da: athrow
      // 5db: bipush 1
      // 5dc: putstatic x/oc69da1aa7f5.Ҭ Z
      // 5df: return
   }

   public static void ĸ(IBlockState var0, BlockPos var1, int var2) {
      τ(var0, var1.getX(), var1.getY(), var1.getZ(), var2);
   }

   public static void τ(IBlockState var0, double var1, double var3, double var5, int var7) {
      Minecraft var8 = Minecraft.getMinecraft();
      BlockRendererDispatcher var9 = var8.getBlockRendererDispatcher();
      IBakedModel var10 = var9.getModelFromBlockState(var0, var8.theWorld, new BlockPos(var1, var3, var5));
      double var11 = var1 - var8.getRenderManager().viewerPosX;
      double var13 = var3 - var8.getRenderManager().viewerPosY;
      double var15 = var5 - var8.getRenderManager().viewerPosZ;
      float var17 = (var7 >> (1024843200 ^ 1024843224) & (1024843047 ^ 1024843224)) / 255.0F;
      float var18 = (var7 >> (1024843208 ^ 1024843224) & (1024843047 ^ 1024843224)) / 255.0F;
      float var19 = (var7 >> (1024843216 ^ 1024843224) & (1024843047 ^ 1024843224)) / 255.0F;
      float var20 = (var7 & (1024843047 ^ 1024843224)) / 255.0F;
      GlStateManager.pushMatrix();
      GlStateManager.translate(var11, var13, var15);
      GlStateManager.enableBlend();
      GlStateManager.blendFunc(1024843482 ^ 1024843224, 1024843483 ^ 1024843224);
      GlStateManager.disableTexture2D();
      GlStateManager.disableCull();
      GlStateManager.disableDepth();
      GlStateManager.depthMask(false);
      GlStateManager.color(var18, var19, var20, var17);
      ʣ(var10, var18, var19, var20, var17);
      GlStateManager.depthMask(true);
      GlStateManager.enableDepth();
      GlStateManager.enableTexture2D();
      GlStateManager.enableCull();
      GlStateManager.disableBlend();
      GlStateManager.popMatrix();
   }

   private static void ʣ(IBakedModel var0, float var1, float var2, float var3, float var4) {
      int var10000 = oc75d51ec7eb.ϩ;
      Tessellator var6 = Tessellator.getInstance();
      int var5 = var10000;
      WorldRenderer var7 = var6.getWorldRenderer();
      EnumFacing[] var8 = EnumFacing.values();
      int var9 = var8.length;
      int var10 = 0;

      while (true) {
         if (var10 < var9) {
            EnumFacing var11 = var8[var10];
            var17 = var0.getFaceQuads(var11);
            if (var5 != 0) {
               break;
            }

            label44: {
               for (BakedQuad var13 : var17) {
                  try {
                     ę(var7, var13, var1, var2, var3, var4, var6);
                     if (var5 != 0) {
                        break label44;
                     }

                     if (var5 != 0) {
                        break;
                     }
                  } catch (IllegalStateException var14) {
                     throw var14;
                  }
               }

               var10++;
            }

            if (var5 == 0) {
               continue;
            }
         }

         var17 = var0.getGeneralQuads();
         break;
      }

      for (BakedQuad var16 : var17) {
         ę(var7, var16, var1, var2, var3, var4, var6);
         if (var5 != 0) {
            break;
         }
      }
   }

   private static void ę(WorldRenderer var0, BakedQuad var1, float var2, float var3, float var4, float var5, Tessellator var6) {
      int[] var8 = var1.getVertexData();
      int var9 = -1836917687 ^ -1836917683;
      int var10 = var8.length / (-1836917687 ^ -1836917683);
      int var10000 = oc75d51ec7eb.ϩ;
      var0.begin(-1836917686 ^ -1836917683, DefaultVertexFormats.POSITION_COLOR);
      int var7 = var10000;
      int var11 = 0;

      while (true) {
         if (var11 < (-1836917687 ^ -1836917683)) {
            int var12 = var11 * var10;
            var10000 = var7;
            float var13 = Float.intBitsToFloat(var8[var12]);
            float var14 = Float.intBitsToFloat(var8[var12 + 1]);
            float var15 = Float.intBitsToFloat(var8[var12 + (-1836917681 ^ -1836917683)]);

            try {
               var0.pos(var13, var14, var15).color(var2, var3, var4, var5).endVertex();
               if (var10000 != 0) {
                  break;
               }

               var11++;
               if (var7 == 0) {
                  continue;
               }
            } catch (IllegalStateException var16) {
               throw var16;
            }
         }

         var6.draw();
         break;
      }
   }

   public static void Ń(IBlockState param0, BlockPos param1, float param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 3
      // 004: aload 0
      // 005: ifnull 03a
      // 008: aload 1
      // 009: ifnull 03a
      // 00c: goto 010
      // 00f: athrow
      // 010: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 013: iload 3
      // 014: ifne 02c
      // 017: goto 01b
      // 01a: athrow
      // 01b: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 01e: ifnull 03a
      // 021: goto 025
      // 024: athrow
      // 025: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 028: goto 02c
      // 02b: athrow
      // 02c: iload 3
      // 02d: ifne 049
      // 030: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 033: ifnonnull 03c
      // 036: goto 03a
      // 039: athrow
      // 03a: return
      // 03b: athrow
      // 03c: fconst_0
      // 03d: fconst_1
      // 03e: fload 2
      // 03f: invokestatic java/lang/Math.min (FF)F
      // 042: invokestatic java/lang/Math.max (FF)F
      // 045: fstore 2
      // 046: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 049: invokevirtual net/minecraft/client/Minecraft.getBlockRendererDispatcher ()Lnet/minecraft/client/renderer/BlockRendererDispatcher;
      // 04c: astore 4
      // 04e: aload 4
      // 050: aload 0
      // 051: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 054: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 057: aload 1
      // 058: invokevirtual net/minecraft/client/renderer/BlockRendererDispatcher.getModelFromBlockState (Lnet/minecraft/block/state/IBlockState;Lnet/minecraft/world/IBlockAccess;Lnet/minecraft/util/BlockPos;)Lnet/minecraft/client/resources/model/IBakedModel;
      // 05b: astore 5
      // 05d: aload 5
      // 05f: ifnonnull 064
      // 062: return
      // 063: athrow
      // 064: aload 1
      // 065: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 068: i2d
      // 069: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 06c: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 06f: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosX D
      // 072: dsub
      // 073: dstore 6
      // 075: aload 1
      // 076: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 079: i2d
      // 07a: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 07d: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 080: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosY D
      // 083: dsub
      // 084: dstore 8
      // 086: aload 1
      // 087: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 08a: i2d
      // 08b: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 08e: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 091: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosZ D
      // 094: dsub
      // 095: dstore 10
      // 097: ldc_w 1819591571
      // 09a: ldc_w 1820015724
      // 09d: ixor
      // 09e: invokestatic org/lwjgl/opengl/GL11.glPushAttrib (I)V
      // 0a1: invokestatic org/lwjgl/opengl/GL11.glPushMatrix ()V
      // 0a4: dload 6
      // 0a6: dload 8
      // 0a8: dload 10
      // 0aa: invokestatic org/lwjgl/opengl/GL11.glTranslated (DDD)V
      // 0ad: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 0b0: invokevirtual net/minecraft/client/Minecraft.getTextureManager ()Lnet/minecraft/client/renderer/texture/TextureManager;
      // 0b3: getstatic net/minecraft/client/renderer/texture/TextureMap.locationBlocksTexture Lnet/minecraft/util/ResourceLocation;
      // 0b6: invokevirtual net/minecraft/client/renderer/texture/TextureManager.bindTexture (Lnet/minecraft/util/ResourceLocation;)V
      // 0b9: ldc_w 1820012941
      // 0bc: ldc_w 1820015724
      // 0bf: ixor
      // 0c0: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 0c3: ldc_w 1820014478
      // 0c6: ldc_w 1820015724
      // 0c9: ixor
      // 0ca: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 0cd: ldc_w 1820016494
      // 0d0: ldc_w 1820015724
      // 0d3: ixor
      // 0d4: ldc_w 1820016495
      // 0d7: ldc_w 1820015724
      // 0da: ixor
      // 0db: invokestatic org/lwjgl/opengl/GL11.glBlendFunc (II)V
      // 0de: ldc_w 1820014365
      // 0e1: ldc_w 1820015724
      // 0e4: ixor
      // 0e5: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 0e8: bipush 0
      // 0e9: invokestatic org/lwjgl/opengl/GL11.glDepthMask (Z)V
      // 0ec: ldc_w 1820014376
      // 0ef: ldc_w 1820015724
      // 0f2: ixor
      // 0f3: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 0f6: ldc_w 1820014508
      // 0f9: ldc_w 1820015724
      // 0fc: ixor
      // 0fd: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 100: ldc_w 1820016232
      // 103: ldc_w 1820015724
      // 106: ixor
      // 107: ldc_w 0.003
      // 10a: invokestatic org/lwjgl/opengl/GL11.glAlphaFunc (IF)V
      // 10d: fconst_1
      // 10e: fconst_1
      // 10f: fconst_1
      // 110: fload 2
      // 111: invokestatic org/lwjgl/opengl/GL11.glColor4f (FFFF)V
      // 114: aload 5
      // 116: aload 0
      // 117: aload 1
      // 118: fload 2
      // 119: invokestatic x/ocbd4917c4b1.Ь (Lnet/minecraft/client/resources/model/IBakedModel;Lnet/minecraft/block/state/IBlockState;Lnet/minecraft/util/BlockPos;F)V
      // 11c: fconst_1
      // 11d: fconst_1
      // 11e: fconst_1
      // 11f: fconst_1
      // 120: invokestatic org/lwjgl/opengl/GL11.glColor4f (FFFF)V
      // 123: invokestatic org/lwjgl/opengl/GL11.glPopMatrix ()V
      // 126: invokestatic org/lwjgl/opengl/GL11.glPopAttrib ()V
      // 129: goto 13e
      // 12c: astore 12
      // 12e: fconst_1
      // 12f: fconst_1
      // 130: fconst_1
      // 131: fconst_1
      // 132: invokestatic org/lwjgl/opengl/GL11.glColor4f (FFFF)V
      // 135: invokestatic org/lwjgl/opengl/GL11.glPopMatrix ()V
      // 138: invokestatic org/lwjgl/opengl/GL11.glPopAttrib ()V
      // 13b: aload 12
      // 13d: athrow
      // 13e: return
   }

   private static void Ь(IBakedModel var0, IBlockState var1, BlockPos var2, float var3) {
      EnumFacing[] var5 = EnumFacing.values();
      int var6 = var5.length;
      int var7 = 0;
      int var4 = oc75d51ec7eb.ϩ;

      List var10000;
      while (true) {
         if (var7 < var6) {
            EnumFacing var8 = var5[var7];
            var10000 = var0.getFaceQuads(var8);
            if (var4 != 0) {
               break;
            }

            label44: {
               for (BakedQuad var10 : var10000) {
                  try {
                     if (var4 != 0) {
                        break label44;
                     }

                     ð(var10, var1, var2, var3);
                     if (var4 != 0) {
                        break;
                     }
                  } catch (IllegalStateException var11) {
                     throw var11;
                  }
               }

               var7++;
            }

            if (var4 == 0) {
               continue;
            }
         }

         var10000 = var0.getGeneralQuads();
         break;
      }

      for (BakedQuad var13 : var10000) {
         ð(var13, var1, var2, var3);
         if (var4 != 0) {
            break;
         }
      }
   }

   private static void ð(BakedQuad var0, IBlockState var1, BlockPos var2, float var3) {
      Tessellator var5 = Tessellator.getInstance();
      WorldRenderer var6 = var5.getWorldRenderer();
      var6.begin(1101192790 ^ 1101192785, DefaultVertexFormats.ITEM);
      var6.addVertexData(var0.getVertexData());
      int var10000 = oc75d51ec7eb.ϩ;
      var6.putSprite(var0.getSprite());
      int var4 = var10000;
      float var7 = 1.0F;
      float var8 = 1.0F;
      float var9 = 1.0F;

      label31: {
         label30: {
            try {
               var14 = var0.hasTintIndex();
               if (var4 != 0) {
                  break label31;
               }

               if (var14 == 0) {
                  break label30;
               }
            } catch (IllegalStateException var11) {
               throw var11;
            }

            int var10 = var1.getBlock().colorMultiplier(ocda171fe5d8.ǔ.theWorld, var2, var0.getTintIndex());
            var7 = (var10 >> (1101192769 ^ 1101192785) & (1101192878 ^ 1101192785)) / 255.0F;
            var8 = (var10 >> (1101192793 ^ 1101192785) & (1101192878 ^ 1101192785)) / 255.0F;
            var9 = (var10 & (1101192878 ^ 1101192785)) / 255.0F;
         }

         var14 = 1;
      }

      int var12 = var14;

      while (var12 <= (1101192789 ^ 1101192785)) {
         var6.putColorMultiplierRgba(var7, var8, var9, var3, var12);
         var12++;
         if (var4 != 0) {
            break;
         }
      }

      Vec3i var13 = var0.getFace().getDirectionVec();
      var6.putNormal(var13.getX(), var13.getY(), var13.getZ());
      var5.draw();
   }

   public static void ʟ(Entity param0, int param1, float param2, float param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 4
      // 005: aload 0
      // 006: ifnull 01f
      // 009: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 00c: iload 4
      // 00e: ifne 024
      // 011: goto 015
      // 014: athrow
      // 015: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 018: ifnonnull 021
      // 01b: goto 01f
      // 01e: athrow
      // 01f: return
      // 020: athrow
      // 021: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 024: invokevirtual net/minecraft/client/Minecraft.getRenderViewEntity ()Lnet/minecraft/entity/Entity;
      // 027: astore 5
      // 029: aload 5
      // 02b: iload 4
      // 02d: ifne 041
      // 030: ifnonnull 03f
      // 033: goto 037
      // 036: athrow
      // 037: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 03a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 03d: astore 5
      // 03f: aload 5
      // 041: iload 4
      // 043: ifne 04f
      // 046: ifnonnull 04e
      // 049: goto 04d
      // 04c: athrow
      // 04d: return
      // 04e: aload 0
      // 04f: getfield net/minecraft/entity/Entity.lastTickPosX D
      // 052: aload 0
      // 053: getfield net/minecraft/entity/Entity.posX D
      // 056: aload 0
      // 057: getfield net/minecraft/entity/Entity.lastTickPosX D
      // 05a: dsub
      // 05b: fload 3
      // 05c: f2d
      // 05d: dmul
      // 05e: dadd
      // 05f: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 062: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 065: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosX D
      // 068: dsub
      // 069: dstore 6
      // 06b: aload 0
      // 06c: getfield net/minecraft/entity/Entity.lastTickPosY D
      // 06f: aload 0
      // 070: getfield net/minecraft/entity/Entity.posY D
      // 073: aload 0
      // 074: getfield net/minecraft/entity/Entity.lastTickPosY D
      // 077: dsub
      // 078: fload 3
      // 079: f2d
      // 07a: dmul
      // 07b: dadd
      // 07c: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 07f: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 082: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosY D
      // 085: iload 4
      // 087: ifne 0a3
      // 08a: dsub
      // 08b: aload 0
      // 08c: invokevirtual net/minecraft/entity/Entity.getEyeHeight ()F
      // 08f: f2d
      // 090: dadd
      // 091: aload 0
      // 092: invokevirtual net/minecraft/entity/Entity.isSneaking ()Z
      // 095: ifeq 0a6
      // 098: goto 09c
      // 09b: athrow
      // 09c: ldc2_w -0.125
      // 09f: goto 0a3
      // 0a2: athrow
      // 0a3: goto 0a7
      // 0a6: dconst_0
      // 0a7: dadd
      // 0a8: dstore 8
      // 0aa: aload 0
      // 0ab: getfield net/minecraft/entity/Entity.lastTickPosZ D
      // 0ae: aload 0
      // 0af: getfield net/minecraft/entity/Entity.posZ D
      // 0b2: aload 0
      // 0b3: getfield net/minecraft/entity/Entity.lastTickPosZ D
      // 0b6: dsub
      // 0b7: fload 3
      // 0b8: f2d
      // 0b9: dmul
      // 0ba: dadd
      // 0bb: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 0be: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 0c1: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosZ D
      // 0c4: dsub
      // 0c5: dstore 10
      // 0c7: dconst_0
      // 0c8: dstore 12
      // 0ca: aload 5
      // 0cc: invokevirtual net/minecraft/entity/Entity.getEyeHeight ()F
      // 0cf: f2d
      // 0d0: dstore 14
      // 0d2: dconst_0
      // 0d3: dstore 16
      // 0d5: aload 5
      // 0d7: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 0da: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0dd: if_acmpne 14d
      // 0e0: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 0e3: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 0e6: getfield net/minecraft/client/settings/GameSettings.thirdPersonView I
      // 0e9: iload 4
      // 0eb: ifne 15e
      // 0ee: goto 0f2
      // 0f1: athrow
      // 0f2: ifne 14d
      // 0f5: goto 0f9
      // 0f8: athrow
      // 0f9: aload 5
      // 0fb: getfield net/minecraft/entity/Entity.rotationYaw F
      // 0fe: fstore 18
      // 100: aload 5
      // 102: getfield net/minecraft/entity/Entity.rotationPitch F
      // 105: fstore 19
      // 107: fload 18
      // 109: f2d
      // 10a: invokestatic java/lang/Math.toRadians (D)D
      // 10d: invokestatic java/lang/Math.sin (D)D
      // 110: dneg
      // 111: fload 19
      // 113: f2d
      // 114: invokestatic java/lang/Math.toRadians (D)D
      // 117: invokestatic java/lang/Math.cos (D)D
      // 11a: dmul
      // 11b: dstore 20
      // 11d: fload 19
      // 11f: f2d
      // 120: invokestatic java/lang/Math.toRadians (D)D
      // 123: invokestatic java/lang/Math.sin (D)D
      // 126: dneg
      // 127: dstore 22
      // 129: fload 18
      // 12b: f2d
      // 12c: invokestatic java/lang/Math.toRadians (D)D
      // 12f: invokestatic java/lang/Math.cos (D)D
      // 132: fload 19
      // 134: f2d
      // 135: invokestatic java/lang/Math.toRadians (D)D
      // 138: invokestatic java/lang/Math.cos (D)D
      // 13b: dmul
      // 13c: dstore 24
      // 13e: dload 20
      // 140: dstore 12
      // 142: dload 14
      // 144: dload 22
      // 146: dadd
      // 147: dstore 14
      // 149: dload 24
      // 14b: dstore 16
      // 14d: iload 1
      // 14e: ldc_w -1964191913
      // 151: ldc_w -1964191921
      // 154: ixor
      // 155: ishr
      // 156: ldc_w -1964191824
      // 159: ldc_w -1964191921
      // 15c: ixor
      // 15d: iand
      // 15e: i2f
      // 15f: ldc 255.0
      // 161: fdiv
      // 162: fstore 18
      // 164: iload 1
      // 165: ldc_w -1964191905
      // 168: ldc_w -1964191921
      // 16b: ixor
      // 16c: ishr
      // 16d: ldc_w -1964191824
      // 170: ldc_w -1964191921
      // 173: ixor
      // 174: iand
      // 175: i2f
      // 176: ldc 255.0
      // 178: fdiv
      // 179: fstore 19
      // 17b: iload 1
      // 17c: ldc_w -1964191929
      // 17f: ldc_w -1964191921
      // 182: ixor
      // 183: ishr
      // 184: ldc_w -1964191824
      // 187: ldc_w -1964191921
      // 18a: ixor
      // 18b: iand
      // 18c: i2f
      // 18d: ldc 255.0
      // 18f: fdiv
      // 190: fstore 20
      // 192: iload 1
      // 193: ldc_w -1964191824
      // 196: ldc_w -1964191921
      // 199: ixor
      // 19a: iand
      // 19b: i2f
      // 19c: ldc 255.0
      // 19e: fdiv
      // 19f: fstore 21
      // 1a1: invokestatic org/lwjgl/opengl/GL11.glPushMatrix ()V
      // 1a4: ldc_w -1964194643
      // 1a7: ldc_w -1964191921
      // 1aa: ixor
      // 1ab: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 1ae: ldc_w -1964192691
      // 1b1: ldc_w -1964191921
      // 1b4: ixor
      // 1b5: ldc_w -1964192692
      // 1b8: ldc_w -1964191921
      // 1bb: ixor
      // 1bc: invokestatic org/lwjgl/opengl/GL11.glBlendFunc (II)V
      // 1bf: ldc_w -1964194705
      // 1c2: ldc_w -1964191921
      // 1c5: ixor
      // 1c6: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 1c9: ldc_w -1964195154
      // 1cc: ldc_w -1964191921
      // 1cf: ixor
      // 1d0: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 1d3: ldc_w -1964194754
      // 1d6: ldc_w -1964191921
      // 1d9: ixor
      // 1da: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 1dd: bipush 0
      // 1de: invokestatic org/lwjgl/opengl/GL11.glDepthMask (Z)V
      // 1e1: fload 2
      // 1e2: invokestatic org/lwjgl/opengl/GL11.glLineWidth (F)V
      // 1e5: fload 19
      // 1e7: fload 20
      // 1e9: fload 21
      // 1eb: fload 18
      // 1ed: invokestatic org/lwjgl/opengl/GL11.glColor4f (FFFF)V
      // 1f0: bipush 1
      // 1f1: invokestatic org/lwjgl/opengl/GL11.glBegin (I)V
      // 1f4: dload 12
      // 1f6: dload 14
      // 1f8: dload 16
      // 1fa: invokestatic org/lwjgl/opengl/GL11.glVertex3d (DDD)V
      // 1fd: dload 6
      // 1ff: dload 8
      // 201: dload 10
      // 203: invokestatic org/lwjgl/opengl/GL11.glVertex3d (DDD)V
      // 206: invokestatic x/oc170ea29aae.ŷ ()V
      // 209: fconst_1
      // 20a: invokestatic org/lwjgl/opengl/GL11.glLineWidth (F)V
      // 20d: fconst_1
      // 20e: fconst_1
      // 20f: fconst_1
      // 210: fconst_1
      // 211: invokestatic org/lwjgl/opengl/GL11.glColor4f (FFFF)V
      // 214: bipush 1
      // 215: invokestatic org/lwjgl/opengl/GL11.glDepthMask (Z)V
      // 218: ldc_w -1964194754
      // 21b: ldc_w -1964191921
      // 21e: ixor
      // 21f: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 222: ldc_w -1964195154
      // 225: ldc_w -1964191921
      // 228: ixor
      // 229: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 22c: ldc_w -1964194705
      // 22f: ldc_w -1964191921
      // 232: ixor
      // 233: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 236: ldc_w -1964194643
      // 239: ldc_w -1964191921
      // 23c: ixor
      // 23d: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 240: invokestatic org/lwjgl/opengl/GL11.glPopMatrix ()V
      // 243: return
   }

   public static void խ(int var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = oc75d51ec7eb.ϩ;

      int var10000;
      label37: {
         label36: {
            try {
               var10000 = var0;
               if (var6 != 0) {
                  break label37;
               }

               if (var0 >= var2) {
                  break label36;
               }
            } catch (IllegalStateException var19) {
               throw var19;
            }

            int var7 = var0;
            var0 = var2;
            var2 = var7;
         }

         var10000 = var1;
      }

      label28: {
         label27: {
            try {
               if (var6 != 0) {
                  break label28;
               }

               if (var10000 >= var3) {
                  break label27;
               }
            } catch (IllegalStateException var18) {
               throw var18;
            }

            int var20 = var1;
            var1 = var3;
            var3 = var20;
         }

         var10000 = var4 >> (1249628500 ^ 1249628492) & (1249628595 ^ 1249628492);
      }

      float var8 = var10000 / 255.0F;
      float var9 = (var4 >> (1249628508 ^ 1249628492) & (1249628595 ^ 1249628492)) / 255.0F;
      float var10 = (var4 >> (1249628484 ^ 1249628492) & (1249628595 ^ 1249628492)) / 255.0F;
      float var11 = (var4 & (1249628595 ^ 1249628492)) / 255.0F;
      float var12 = (var5 >> (1249628500 ^ 1249628492) & (1249628595 ^ 1249628492)) / 255.0F;
      float var13 = (var5 >> (1249628508 ^ 1249628492) & (1249628595 ^ 1249628492)) / 255.0F;
      float var14 = (var5 >> (1249628484 ^ 1249628492) & (1249628595 ^ 1249628492)) / 255.0F;
      float var15 = (var5 & (1249628595 ^ 1249628492)) / 255.0F;
      GlStateManager.disableTexture2D();
      GlStateManager.enableBlend();
      GlStateManager.disableAlpha();
      GlStateManager.tryBlendFuncSeparate(1249628750 ^ 1249628492, 1249628751 ^ 1249628492, 1, 0);
      GlStateManager.shadeModel(1249627213 ^ 1249628492);
      Tessellator var16 = Tessellator.getInstance();
      WorldRenderer var17 = var16.getWorldRenderer();
      var17.begin(1249628491 ^ 1249628492, DefaultVertexFormats.POSITION_COLOR);
      var17.pos(var2, var1, 0.0).color(var9, var10, var11, var8).endVertex();
      var17.pos(var0, var1, 0.0).color(var9, var10, var11, var8).endVertex();
      var17.pos(var0, var3, 0.0).color(var13, var14, var15, var12).endVertex();
      var17.pos(var2, var3, 0.0).color(var13, var14, var15, var12).endVertex();
      var16.draw();
      GlStateManager.shadeModel(1249627212 ^ 1249628492);
      GlStateManager.disableBlend();
      GlStateManager.enableAlpha();
      GlStateManager.enableTexture2D();
   }

   public static void Ѵ(int param0, int param1, int param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 3
      // 04: iload 2
      // 05: iload 3
      // 06: ifne 1c
      // 09: bipush -1
      // 0a: if_icmpne 1f
      // 0d: goto 11
      // 10: athrow
      // 11: ldc_w 1871837665
      // 14: ldc_w -796792335
      // 17: ixor
      // 18: goto 1c
      // 1b: athrow
      // 1c: goto 20
      // 1f: iload 2
      // 20: istore 4
      // 22: bipush 0
      // 23: bipush 0
      // 24: iload 0
      // 25: iload 1
      // 26: iload 4
      // 28: invokestatic net/minecraft/client/gui/Gui.drawRect (IIIII)V
      // 2b: return
   }

   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static void È(String var0, char var1, int var2, int var3, long var4, long var6, boolean var8, FontRenderer var9) {
      int var11 = var2;
      int var12 = 0;
      long var13 = 0L;
      int var10 = oc75d51ec7eb.ϩ;
      int var15 = 0;

      while (var15 < var0.length()) {
         char var16 = var0.charAt(var15);

         label48: {
            label47: {
               int var10000;
               label56: {
                  label57: {
                     try {
                        var10000 = var16;
                        if (var10 != 0) {
                           break label56;
                        }

                        if (var16 != var1) {
                           break label57;
                        }
                     } catch (IllegalStateException var19) {
                        throw var19;
                     }

                     var12++;
                     var10000 = var10;
                     var2 = var11;
                     var3 += var9.FONT_HEIGHT + (-1625075327 ^ -1625075324);
                     var13 = var6 * var12;

                     try {
                        if (var10000 == 0) {
                           break label47;
                        }
                     } catch (IllegalStateException var18) {
                        throw var18;
                     }
                  }

                  try {
                     var9.drawString(String.valueOf(var16), var2, var3, oc7ab2161b9f.ƾ(var4, var13), var8);
                     if (var10 != 0) {
                        break label48;
                     }
                  } catch (IllegalStateException var17) {
                     throw var17;
                  }

                  var2 += var9.getCharWidth(var16);
                  var10000 = var16;
               }

               if (var10000 != (-1625075292 ^ -1625075324)) {
                  var13 -= -5068797797440524199L ^ -5068797797440524285L;
               }
            }

            var15++;
         }

         if (var10 != 0) {
            break;
         }
      }
   }

   public static void Σ(double param0, double param2, double param4, double param6, int param8, float param9, int param10, boolean param11) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: iload 10
      // 005: ldc_w 1555171785
      // 008: ldc_w 1555171793
      // 00b: ixor
      // 00c: ishr
      // 00d: ldc_w 1555171630
      // 010: ldc_w 1555171793
      // 013: ixor
      // 014: iand
      // 015: i2f
      // 016: ldc 255.0
      // 018: fdiv
      // 019: fstore 13
      // 01b: istore 12
      // 01d: iload 10
      // 01f: ldc_w 1555171777
      // 022: ldc_w 1555171793
      // 025: ixor
      // 026: ishr
      // 027: ldc_w 1555171630
      // 02a: ldc_w 1555171793
      // 02d: ixor
      // 02e: iand
      // 02f: i2f
      // 030: ldc 255.0
      // 032: fdiv
      // 033: fstore 14
      // 035: iload 10
      // 037: ldc_w 1555171801
      // 03a: ldc_w 1555171793
      // 03d: ixor
      // 03e: ishr
      // 03f: ldc_w 1555171630
      // 042: ldc_w 1555171793
      // 045: ixor
      // 046: iand
      // 047: i2f
      // 048: ldc 255.0
      // 04a: fdiv
      // 04b: fstore 15
      // 04d: iload 10
      // 04f: ldc_w 1555171630
      // 052: ldc_w 1555171793
      // 055: ixor
      // 056: iand
      // 057: i2f
      // 058: ldc 255.0
      // 05a: fdiv
      // 05b: fstore 16
      // 05d: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 060: getfield net/minecraft/client/Minecraft.entityRenderer Lnet/minecraft/client/renderer/EntityRenderer;
      // 063: invokevirtual net/minecraft/client/renderer/EntityRenderer.disableLightmap ()V
      // 066: ldc_w 1555170352
      // 069: ldc_w 1555171793
      // 06c: ixor
      // 06d: iload 12
      // 06f: ifne 0c6
      // 072: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 075: ldc_w 1555169843
      // 078: ldc_w 1555171793
      // 07b: ixor
      // 07c: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 07f: ldc_w 1555172051
      // 082: ldc_w 1555171793
      // 085: ixor
      // 086: ldc_w 1555172050
      // 089: ldc_w 1555171793
      // 08c: ixor
      // 08d: invokestatic org/lwjgl/opengl/GL11.glBlendFunc (II)V
      // 090: ldc_w 1555169952
      // 093: ldc_w 1555171793
      // 096: ixor
      // 097: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 09a: ldc_w 1555170033
      // 09d: ldc_w 1555171793
      // 0a0: ixor
      // 0a1: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 0a4: bipush 0
      // 0a5: invokestatic org/lwjgl/opengl/GL11.glDepthMask (Z)V
      // 0a8: fload 9
      // 0aa: invokestatic org/lwjgl/opengl/GL11.glLineWidth (F)V
      // 0ad: iload 11
      // 0af: ifne 0c5
      // 0b2: goto 0b6
      // 0b5: athrow
      // 0b6: fload 14
      // 0b8: fload 15
      // 0ba: fload 16
      // 0bc: fload 13
      // 0be: invokestatic org/lwjgl/opengl/GL11.glColor4f (FFFF)V
      // 0c1: goto 0c5
      // 0c4: athrow
      // 0c5: bipush 1
      // 0c6: invokestatic org/lwjgl/opengl/GL11.glBegin (I)V
      // 0c9: lconst_0
      // 0ca: lstore 17
      // 0cc: ldc2_w 5559772973495316278
      // 0cf: ldc2_w 5559772973495309742
      // 0d2: lxor
      // 0d3: iload 8
      // 0d5: i2l
      // 0d6: ldiv
      // 0d7: lstore 19
      // 0d9: lload 19
      // 0db: ldc2_w 5559772973495309740
      // 0de: ldc2_w 5559772973495309742
      // 0e1: lxor
      // 0e2: ldiv
      // 0e3: lstore 21
      // 0e5: bipush 0
      // 0e6: istore 23
      // 0e8: iload 23
      // 0ea: iload 8
      // 0ec: ldc_w 1555171795
      // 0ef: ldc_w 1555171793
      // 0f2: ixor
      // 0f3: imul
      // 0f4: if_icmpge 1d5
      // 0f7: iload 12
      // 0f9: ifne 214
      // 0fc: iload 11
      // 0fe: iload 12
      // 100: ifne 125
      // 103: goto 107
      // 106: athrow
      // 107: ifeq 1a0
      // 10a: goto 10e
      // 10d: athrow
      // 10e: iload 23
      // 110: iload 12
      // 112: ifne 155
      // 115: goto 119
      // 118: athrow
      // 119: ldc_w 1555171795
      // 11c: ldc_w 1555171793
      // 11f: ixor
      // 120: irem
      // 121: goto 125
      // 124: athrow
      // 125: ifeq 143
      // 128: iload 23
      // 12a: ldc_w 1555171838
      // 12d: ldc_w 1555171793
      // 130: ixor
      // 131: if_icmpne 13c
      // 134: goto 138
      // 137: athrow
      // 138: lload 21
      // 13a: lstore 17
      // 13c: lload 17
      // 13e: lload 19
      // 140: ladd
      // 141: lstore 17
      // 143: ldc2_w 5559772973495309740
      // 146: ldc2_w 5559772973495309742
      // 149: lxor
      // 14a: bipush 1
      // 14b: newarray 11
      // 14d: dup
      // 14e: bipush 0
      // 14f: lload 17
      // 151: lastore
      // 152: invokestatic x/oc7ab2161b9f.ƾ (J[J)I
      // 155: istore 24
      // 157: iload 24
      // 159: ldc_w 1555171777
      // 15c: ldc_w 1555171793
      // 15f: ixor
      // 160: ishr
      // 161: ldc_w 1555171630
      // 164: ldc_w 1555171793
      // 167: ixor
      // 168: iand
      // 169: i2f
      // 16a: ldc 255.0
      // 16c: fdiv
      // 16d: fstore 25
      // 16f: iload 24
      // 171: ldc_w 1555171801
      // 174: ldc_w 1555171793
      // 177: ixor
      // 178: ishr
      // 179: ldc_w 1555171630
      // 17c: ldc_w 1555171793
      // 17f: ixor
      // 180: iand
      // 181: i2f
      // 182: ldc 255.0
      // 184: fdiv
      // 185: fstore 26
      // 187: iload 24
      // 189: ldc_w 1555171630
      // 18c: ldc_w 1555171793
      // 18f: ixor
      // 190: iand
      // 191: i2f
      // 192: ldc 255.0
      // 194: fdiv
      // 195: fstore 27
      // 197: fload 25
      // 199: fload 26
      // 19b: fload 27
      // 19d: invokestatic org/lwjgl/opengl/GL11.glColor3f (FFF)V
      // 1a0: ldc2_w 6.283185307179586
      // 1a3: iload 23
      // 1a5: i2d
      // 1a6: dmul
      // 1a7: iload 8
      // 1a9: i2d
      // 1aa: ddiv
      // 1ab: ldc2_w 180.0
      // 1ae: invokestatic java/lang/Math.toRadians (D)D
      // 1b1: dadd
      // 1b2: dstore 24
      // 1b4: iload 12
      // 1b6: dload 0
      // 1b7: dload 24
      // 1b9: invokestatic java/lang/Math.cos (D)D
      // 1bc: dload 6
      // 1be: dmul
      // 1bf: dadd
      // 1c0: dload 2
      // 1c1: dload 4
      // 1c3: dload 24
      // 1c5: invokestatic java/lang/Math.sin (D)D
      // 1c8: dload 6
      // 1ca: dmul
      // 1cb: dadd
      // 1cc: invokestatic org/lwjgl/opengl/GL11.glVertex3d (DDD)V
      // 1cf: iinc 23 1
      // 1d2: ifeq 0e8
      // 1d5: invokestatic x/oc170ea29aae.ŷ ()V
      // 1d8: fconst_1
      // 1d9: fconst_1
      // 1da: fconst_1
      // 1db: fconst_1
      // 1dc: invokestatic org/lwjgl/opengl/GL11.glColor4f (FFFF)V
      // 1df: bipush 1
      // 1e0: invokestatic org/lwjgl/opengl/GL11.glDepthMask (Z)V
      // 1e3: ldc_w 1555170033
      // 1e6: ldc_w 1555171793
      // 1e9: ixor
      // 1ea: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 1ed: ldc_w 1555169952
      // 1f0: ldc_w 1555171793
      // 1f3: ixor
      // 1f4: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 1f7: ldc_w 1555169843
      // 1fa: ldc_w 1555171793
      // 1fd: ixor
      // 1fe: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 201: ldc_w 1555170352
      // 204: ldc_w 1555171793
      // 207: ixor
      // 208: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 20b: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 20e: getfield net/minecraft/client/Minecraft.entityRenderer Lnet/minecraft/client/renderer/EntityRenderer;
      // 211: invokevirtual net/minecraft/client/renderer/EntityRenderer.enableLightmap ()V
      // 214: return
   }

   public static void Ë(float var0, float var1, int var2, double var3, double var5) {
      GL11.glPushMatrix();
      GL11.glEnable(-2064341917 ^ -2064339133);
      GL11.glDisable(-2064342366 ^ -2064339133);
      I(var2);
      GL11.glLineWidth((float)var3);
      float var7 = (float)(var3 / 2.0);
      float var8 = var7 / 2.0F;
      float var9 = var7 / 2.0F;
      GL11.glBegin(1);
      GL11.glVertex2d(var0 - var8, var1 + var9);
      GL11.glVertex2d(var0 + var5 - var8, var1 - var5 + var9);
      GL11.glVertex2d(var0 + var5 - var8, var1 - var5 + var9);
      GL11.glVertex2d(var0 + 2.0 * var5 - var8, var1 + var9);
      oc170ea29aae.ŷ();
      GL11.glEnable(-2064342366 ^ -2064339133);
      GL11.glDisable(-2064341917 ^ -2064339133);
      GL11.glPopMatrix();
   }

   public static void ŋ(double param0, double param2, double param4, double param6, double param8, int param10) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: ldc_w 408535726
      // 003: ldc_w 408537420
      // 006: ixor
      // 007: invokestatic org/lwjgl/opengl/GL11.glIsEnabled (I)Z
      // 00a: istore 12
      // 00c: ldc_w 408535726
      // 00f: ldc_w 408537420
      // 012: ixor
      // 013: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 016: ldc_w 408536237
      // 019: ldc_w 408537420
      // 01c: ixor
      // 01d: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 020: ldc_w 408537678
      // 023: ldc_w 408537420
      // 026: ixor
      // 027: ldc_w 408537679
      // 02a: ldc_w 408537420
      // 02d: ixor
      // 02e: invokestatic org/lwjgl/opengl/GL11.glBlendFunc (II)V
      // 031: getstatic x/oc75d51ec7eb.ϩ I
      // 034: ldc_w 408535660
      // 037: ldc_w 408537420
      // 03a: ixor
      // 03b: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 03e: istore 11
      // 040: invokestatic org/lwjgl/opengl/GL11.glPushMatrix ()V
      // 043: iload 11
      // 045: iload 10
      // 047: invokestatic x/ocbd4917c4b1.I (I)V
      // 04a: ldc_w 408537419
      // 04d: ldc_w 408537420
      // 050: ixor
      // 051: invokestatic org/lwjgl/opengl/GL11.glBegin (I)V
      // 054: dload 0
      // 055: dload 2
      // 056: invokestatic org/lwjgl/opengl/GL11.glVertex2d (DD)V
      // 059: dload 0
      // 05a: dload 4
      // 05c: dload 6
      // 05e: ddiv
      // 05f: dsub
      // 060: dload 2
      // 061: dload 4
      // 063: dadd
      // 064: invokestatic org/lwjgl/opengl/GL11.glVertex2d (DD)V
      // 067: ifne 100
      // 06a: dload 0
      // 06b: dload 2
      // 06c: dload 4
      // 06e: dload 8
      // 070: ddiv
      // 071: dadd
      // 072: invokestatic org/lwjgl/opengl/GL11.glVertex2d (DD)V
      // 075: dload 0
      // 076: dload 4
      // 078: dload 6
      // 07a: ddiv
      // 07b: dadd
      // 07c: dload 2
      // 07d: dload 4
      // 07f: dadd
      // 080: invokestatic org/lwjgl/opengl/GL11.glVertex2d (DD)V
      // 083: dload 0
      // 084: dload 2
      // 085: invokestatic org/lwjgl/opengl/GL11.glVertex2d (DD)V
      // 088: invokestatic x/oc170ea29aae.ŷ ()V
      // 08b: fconst_0
      // 08c: fconst_0
      // 08d: fconst_0
      // 08e: ldc_w 0.8
      // 091: invokestatic org/lwjgl/opengl/GL11.glColor4f (FFFF)V
      // 094: ldc_w 408537422
      // 097: ldc_w 408537420
      // 09a: ixor
      // 09b: invokestatic org/lwjgl/opengl/GL11.glBegin (I)V
      // 09e: dload 0
      // 09f: dload 2
      // 0a0: invokestatic org/lwjgl/opengl/GL11.glVertex2d (DD)V
      // 0a3: dload 0
      // 0a4: dload 4
      // 0a6: dload 6
      // 0a8: ddiv
      // 0a9: dsub
      // 0aa: dload 2
      // 0ab: dload 4
      // 0ad: dadd
      // 0ae: invokestatic org/lwjgl/opengl/GL11.glVertex2d (DD)V
      // 0b1: dload 0
      // 0b2: dload 2
      // 0b3: dload 4
      // 0b5: dload 8
      // 0b7: ddiv
      // 0b8: dadd
      // 0b9: invokestatic org/lwjgl/opengl/GL11.glVertex2d (DD)V
      // 0bc: dload 0
      // 0bd: dload 4
      // 0bf: dload 6
      // 0c1: ddiv
      // 0c2: dadd
      // 0c3: dload 2
      // 0c4: dload 4
      // 0c6: dadd
      // 0c7: invokestatic org/lwjgl/opengl/GL11.glVertex2d (DD)V
      // 0ca: dload 0
      // 0cb: dload 2
      // 0cc: invokestatic org/lwjgl/opengl/GL11.glVertex2d (DD)V
      // 0cf: invokestatic x/oc170ea29aae.ŷ ()V
      // 0d2: invokestatic org/lwjgl/opengl/GL11.glPopMatrix ()V
      // 0d5: ldc_w 408536237
      // 0d8: ldc_w 408537420
      // 0db: ixor
      // 0dc: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 0df: iload 12
      // 0e1: ifne 0f6
      // 0e4: goto 0e8
      // 0e7: athrow
      // 0e8: ldc_w 408535726
      // 0eb: ldc_w 408537420
      // 0ee: ixor
      // 0ef: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 0f2: goto 0f6
      // 0f5: athrow
      // 0f6: ldc_w 408535660
      // 0f9: ldc_w 408537420
      // 0fc: ixor
      // 0fd: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 100: return
   }

   public static void I(int var0) {
      GL11.glColor4f(
         (var0 >> (-337367177 ^ -337367193) & (-337367144 ^ -337367193)) / 255.0F,
         (var0 >> (-337367185 ^ -337367193) & (-337367144 ^ -337367193)) / 255.0F,
         (var0 & (-337367144 ^ -337367193)) / 255.0F,
         (var0 >> (-337367169 ^ -337367193) & (-337367144 ^ -337367193)) / 255.0F
      );
   }

   public static void Т(float param0, float param1, float param2, float param3, float param4, int param5, int param6, int param7) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: fload 0
      // 001: fconst_2
      // 002: fmul
      // 003: fstore 0
      // 004: fload 1
      // 005: fconst_2
      // 006: fmul
      // 007: fstore 1
      // 008: fload 2
      // 009: fconst_2
      // 00a: fmul
      // 00b: fstore 2
      // 00c: getstatic x/oc75d51ec7eb.ϩ I
      // 00f: fload 3
      // 010: fconst_2
      // 011: fmul
      // 012: fstore 3
      // 013: invokestatic org/lwjgl/opengl/GL11.glPushMatrix ()V
      // 016: ldc_w 521273190
      // 019: ldc_w 522059929
      // 01c: ixor
      // 01d: invokestatic org/lwjgl/opengl/GL11.glPushAttrib (I)V
      // 020: ldc2_w 0.5
      // 023: ldc2_w 0.5
      // 026: ldc2_w 0.5
      // 029: invokestatic org/lwjgl/opengl/GL11.glScaled (DDD)V
      // 02c: ldc_w 522062715
      // 02f: ldc_w 522059929
      // 032: ixor
      // 033: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 036: ldc_w 522063224
      // 039: ldc_w 522059929
      // 03c: ixor
      // 03d: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 040: istore 8
      // 042: ldc_w 522062777
      // 045: ldc_w 522059929
      // 048: ixor
      // 049: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 04c: ldc_w 522059920
      // 04f: ldc_w 522059929
      // 052: ixor
      // 053: invokestatic org/lwjgl/opengl/GL11.glBegin (I)V
      // 056: iload 5
      // 058: invokestatic x/ocbd4917c4b1.I (I)V
      // 05b: bipush 0
      // 05c: istore 9
      // 05e: iload 9
      // 060: ldc_w 522059971
      // 063: ldc_w 522059929
      // 066: ixor
      // 067: if_icmpgt 0ae
      // 06a: iload 9
      // 06c: i2f
      // 06d: ldc_w 0.017453292
      // 070: fmul
      // 071: f2d
      // 072: dstore 10
      // 074: fload 0
      // 075: fload 4
      // 077: fadd
      // 078: f2d
      // 079: dload 10
      // 07b: invokestatic java/lang/Math.sin (D)D
      // 07e: fload 4
      // 080: f2d
      // 081: dmul
      // 082: ldc2_w -1.0
      // 085: dmul
      // 086: dadd
      // 087: fload 1
      // 088: fload 4
      // 08a: iload 8
      // 08c: ifne 31b
      // 08f: fadd
      // 090: f2d
      // 091: dload 10
      // 093: invokestatic java/lang/Math.cos (D)D
      // 096: fload 4
      // 098: f2d
      // 099: dmul
      // 09a: ldc2_w -1.0
      // 09d: dmul
      // 09e: dadd
      // 09f: invokestatic org/lwjgl/opengl/GL11.glVertex2d (DD)V
      // 0a2: iload 8
      // 0a4: iinc 9 3
      // 0a7: ifeq 05e
      // 0aa: goto 0ae
      // 0ad: athrow
      // 0ae: ldc_w 522059971
      // 0b1: ldc_w 522059929
      // 0b4: ixor
      // 0b5: istore 9
      // 0b7: iload 9
      // 0b9: ldc_w 522059821
      // 0bc: ldc_w 522059929
      // 0bf: ixor
      // 0c0: if_icmpgt 103
      // 0c3: iload 9
      // 0c5: i2f
      // 0c6: ldc_w 0.017453292
      // 0c9: fmul
      // 0ca: f2d
      // 0cb: iload 8
      // 0cd: ifne 307
      // 0d0: dstore 10
      // 0d2: iload 8
      // 0d4: fload 0
      // 0d5: fload 4
      // 0d7: fadd
      // 0d8: f2d
      // 0d9: dload 10
      // 0db: invokestatic java/lang/Math.sin (D)D
      // 0de: fload 4
      // 0e0: f2d
      // 0e1: dmul
      // 0e2: ldc2_w -1.0
      // 0e5: dmul
      // 0e6: dadd
      // 0e7: fload 3
      // 0e8: fload 4
      // 0ea: fsub
      // 0eb: f2d
      // 0ec: dload 10
      // 0ee: invokestatic java/lang/Math.cos (D)D
      // 0f1: fload 4
      // 0f3: f2d
      // 0f4: dmul
      // 0f5: ldc2_w -1.0
      // 0f8: dmul
      // 0f9: dadd
      // 0fa: invokestatic org/lwjgl/opengl/GL11.glVertex2d (DD)V
      // 0fd: iinc 9 3
      // 100: ifeq 0b7
      // 103: bipush 0
      // 104: istore 9
      // 106: iload 9
      // 108: ldc_w 522059971
      // 10b: ldc_w 522059929
      // 10e: ixor
      // 10f: if_icmpgt 14e
      // 112: iload 9
      // 114: i2f
      // 115: ldc_w 0.017453292
      // 118: fmul
      // 119: f2d
      // 11a: dstore 10
      // 11c: fload 2
      // 11d: fload 4
      // 11f: fsub
      // 120: iload 8
      // 122: ifne 1b0
      // 125: f2d
      // 126: dload 10
      // 128: invokestatic java/lang/Math.sin (D)D
      // 12b: fload 4
      // 12d: f2d
      // 12e: dmul
      // 12f: dadd
      // 130: fload 3
      // 131: fload 4
      // 133: fsub
      // 134: f2d
      // 135: dload 10
      // 137: invokestatic java/lang/Math.cos (D)D
      // 13a: fload 4
      // 13c: f2d
      // 13d: dmul
      // 13e: dadd
      // 13f: invokestatic org/lwjgl/opengl/GL11.glVertex2d (DD)V
      // 142: iload 8
      // 144: iinc 9 3
      // 147: ifeq 106
      // 14a: goto 14e
      // 14d: athrow
      // 14e: ldc_w 522059971
      // 151: ldc_w 522059929
      // 154: ixor
      // 155: istore 9
      // 157: iload 9
      // 159: ldc_w 522059821
      // 15c: ldc_w 522059929
      // 15f: ixor
      // 160: if_icmpgt 19f
      // 163: iload 9
      // 165: i2f
      // 166: ldc_w 0.017453292
      // 169: fmul
      // 16a: f2d
      // 16b: dstore 10
      // 16d: fload 2
      // 16e: fload 4
      // 170: fsub
      // 171: f2d
      // 172: dload 10
      // 174: invokestatic java/lang/Math.sin (D)D
      // 177: fload 4
      // 179: f2d
      // 17a: dmul
      // 17b: dadd
      // 17c: fload 1
      // 17d: fload 4
      // 17f: fadd
      // 180: iload 8
      // 182: ifne 31c
      // 185: f2d
      // 186: dload 10
      // 188: invokestatic java/lang/Math.cos (D)D
      // 18b: fload 4
      // 18d: f2d
      // 18e: dmul
      // 18f: dadd
      // 190: invokestatic org/lwjgl/opengl/GL11.glVertex2d (DD)V
      // 193: iload 8
      // 195: iinc 9 3
      // 198: ifeq 157
      // 19b: goto 19f
      // 19e: athrow
      // 19f: invokestatic x/oc170ea29aae.ŷ ()V
      // 1a2: invokestatic org/lwjgl/opengl/GL11.glPushMatrix ()V
      // 1a5: ldc_w 522067352
      // 1a8: ldc_w 522059929
      // 1ab: ixor
      // 1ac: invokestatic org/lwjgl/opengl/GL11.glShadeModel (I)V
      // 1af: fconst_2
      // 1b0: invokestatic org/lwjgl/opengl/GL11.glLineWidth (F)V
      // 1b3: ldc_w 522059931
      // 1b6: ldc_w 522059929
      // 1b9: ixor
      // 1ba: iload 8
      // 1bc: ifne 1d8
      // 1bf: invokestatic org/lwjgl/opengl/GL11.glBegin (I)V
      // 1c2: iload 6
      // 1c4: i2l
      // 1c5: lconst_0
      // 1c6: lcmp
      // 1c7: ifeq 1d7
      // 1ca: goto 1ce
      // 1cd: athrow
      // 1ce: iload 6
      // 1d0: invokestatic x/ocbd4917c4b1.I (I)V
      // 1d3: goto 1d7
      // 1d6: athrow
      // 1d7: bipush 0
      // 1d8: istore 9
      // 1da: iload 9
      // 1dc: ldc_w 522059971
      // 1df: ldc_w 522059929
      // 1e2: ixor
      // 1e3: if_icmpgt 226
      // 1e6: iload 8
      // 1e8: ifne 22f
      // 1eb: iload 9
      // 1ed: i2f
      // 1ee: ldc_w 0.017453292
      // 1f1: fmul
      // 1f2: f2d
      // 1f3: dstore 10
      // 1f5: iload 8
      // 1f7: fload 0
      // 1f8: fload 4
      // 1fa: fadd
      // 1fb: f2d
      // 1fc: dload 10
      // 1fe: invokestatic java/lang/Math.sin (D)D
      // 201: fload 4
      // 203: f2d
      // 204: dmul
      // 205: ldc2_w -1.0
      // 208: dmul
      // 209: dadd
      // 20a: fload 1
      // 20b: fload 4
      // 20d: fadd
      // 20e: f2d
      // 20f: dload 10
      // 211: invokestatic java/lang/Math.cos (D)D
      // 214: fload 4
      // 216: f2d
      // 217: dmul
      // 218: ldc2_w -1.0
      // 21b: dmul
      // 21c: dadd
      // 21d: invokestatic org/lwjgl/opengl/GL11.glVertex2d (DD)V
      // 220: iinc 9 3
      // 223: ifeq 1da
      // 226: ldc_w 522059971
      // 229: ldc_w 522059929
      // 22c: ixor
      // 22d: istore 9
      // 22f: iload 9
      // 231: ldc_w 522059821
      // 234: ldc_w 522059929
      // 237: ixor
      // 238: if_icmpgt 27f
      // 23b: iload 9
      // 23d: i2f
      // 23e: ldc_w 0.017453292
      // 241: fmul
      // 242: f2d
      // 243: dstore 10
      // 245: iload 8
      // 247: fload 0
      // 248: fload 4
      // 24a: fadd
      // 24b: f2d
      // 24c: dload 10
      // 24e: invokestatic java/lang/Math.sin (D)D
      // 251: fload 4
      // 253: f2d
      // 254: dmul
      // 255: ldc2_w -1.0
      // 258: dmul
      // 259: dadd
      // 25a: fload 3
      // 25b: fload 4
      // 25d: fsub
      // 25e: f2d
      // 25f: dload 10
      // 261: invokestatic java/lang/Math.cos (D)D
      // 264: fload 4
      // 266: f2d
      // 267: dmul
      // 268: ldc2_w -1.0
      // 26b: dmul
      // 26c: dadd
      // 26d: invokestatic org/lwjgl/opengl/GL11.glVertex2d (DD)V
      // 270: ifne 296
      // 273: iinc 9 3
      // 276: iload 8
      // 278: ifeq 22f
      // 27b: goto 27f
      // 27e: athrow
      // 27f: iload 7
      // 281: iload 8
      // 283: ifne 297
      // 286: ifeq 296
      // 289: goto 28d
      // 28c: athrow
      // 28d: iload 7
      // 28f: invokestatic x/ocbd4917c4b1.I (I)V
      // 292: goto 296
      // 295: athrow
      // 296: bipush 0
      // 297: istore 9
      // 299: iload 9
      // 29b: ldc_w 522059971
      // 29e: ldc_w 522059929
      // 2a1: ixor
      // 2a2: if_icmpgt 2e1
      // 2a5: iload 9
      // 2a7: i2f
      // 2a8: ldc_w 0.017453292
      // 2ab: fmul
      // 2ac: f2d
      // 2ad: dstore 10
      // 2af: fload 2
      // 2b0: fload 4
      // 2b2: fsub
      // 2b3: f2d
      // 2b4: dload 10
      // 2b6: invokestatic java/lang/Math.sin (D)D
      // 2b9: fload 4
      // 2bb: iload 8
      // 2bd: ifne 315
      // 2c0: f2d
      // 2c1: dmul
      // 2c2: dadd
      // 2c3: fload 3
      // 2c4: fload 4
      // 2c6: fsub
      // 2c7: f2d
      // 2c8: dload 10
      // 2ca: invokestatic java/lang/Math.cos (D)D
      // 2cd: fload 4
      // 2cf: f2d
      // 2d0: dmul
      // 2d1: dadd
      // 2d2: invokestatic org/lwjgl/opengl/GL11.glVertex2d (DD)V
      // 2d5: iload 8
      // 2d7: iinc 9 3
      // 2da: ifeq 299
      // 2dd: goto 2e1
      // 2e0: athrow
      // 2e1: ldc_w 522059971
      // 2e4: ldc_w 522059929
      // 2e7: ixor
      // 2e8: istore 9
      // 2ea: iload 9
      // 2ec: ldc_w 522059821
      // 2ef: ldc_w 522059929
      // 2f2: ixor
      // 2f3: if_icmpgt 332
      // 2f6: iload 9
      // 2f8: i2f
      // 2f9: ldc_w 0.017453292
      // 2fc: iload 8
      // 2fe: ifne 376
      // 301: fmul
      // 302: f2d
      // 303: goto 307
      // 306: athrow
      // 307: dstore 10
      // 309: fload 2
      // 30a: fload 4
      // 30c: fsub
      // 30d: f2d
      // 30e: dload 10
      // 310: invokestatic java/lang/Math.sin (D)D
      // 313: fload 4
      // 315: f2d
      // 316: dmul
      // 317: dadd
      // 318: fload 1
      // 319: fload 4
      // 31b: fadd
      // 31c: f2d
      // 31d: dload 10
      // 31f: invokestatic java/lang/Math.cos (D)D
      // 322: fload 4
      // 324: f2d
      // 325: dmul
      // 326: dadd
      // 327: invokestatic org/lwjgl/opengl/GL11.glVertex2d (DD)V
      // 32a: iload 8
      // 32c: iinc 9 3
      // 32f: ifeq 2ea
      // 332: invokestatic x/oc170ea29aae.ŷ ()V
      // 335: invokestatic org/lwjgl/opengl/GL11.glPopMatrix ()V
      // 338: ldc_w 522063224
      // 33b: ldc_w 522059929
      // 33e: ixor
      // 33f: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 342: ldc_w 522062715
      // 345: ldc_w 522059929
      // 348: ixor
      // 349: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 34c: ldc_w 522062777
      // 34f: ldc_w 522059929
      // 352: ixor
      // 353: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 356: ldc_w 522063224
      // 359: ldc_w 522059929
      // 35c: ixor
      // 35d: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 360: invokestatic org/lwjgl/opengl/GL11.glPopAttrib ()V
      // 363: invokestatic org/lwjgl/opengl/GL11.glPopMatrix ()V
      // 366: fconst_1
      // 367: invokestatic org/lwjgl/opengl/GL11.glLineWidth (F)V
      // 36a: ldc_w 522067353
      // 36d: ldc_w 522059929
      // 370: ixor
      // 371: invokestatic org/lwjgl/opengl/GL11.glShadeModel (I)V
      // 374: fconst_1
      // 375: fconst_1
      // 376: fconst_1
      // 377: fconst_1
      // 378: invokestatic net/minecraft/client/renderer/GlStateManager.color (FFFF)V
      // 37b: return
   }

   public static void İ(double param0, double param2, double param4, int param6, int param7) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 8
      // 005: iload 6
      // 007: iload 8
      // 009: ifne 02e
      // 00c: ldc_w -1093904219
      // 00f: ldc_w -1093904218
      // 012: ixor
      // 013: if_icmpge 01c
      // 016: goto 01a
      // 019: athrow
      // 01a: return
      // 01b: athrow
      // 01c: iload 7
      // 01e: ldc_w -1093904194
      // 021: ldc_w -1093904218
      // 024: ixor
      // 025: ishr
      // 026: ldc_w -1093904295
      // 029: ldc_w -1093904218
      // 02c: ixor
      // 02d: iand
      // 02e: i2f
      // 02f: ldc 255.0
      // 031: fdiv
      // 032: fstore 9
      // 034: iload 7
      // 036: ldc_w -1093904202
      // 039: ldc_w -1093904218
      // 03c: ixor
      // 03d: ishr
      // 03e: ldc_w -1093904295
      // 041: ldc_w -1093904218
      // 044: ixor
      // 045: iand
      // 046: i2f
      // 047: ldc 255.0
      // 049: fdiv
      // 04a: fstore 10
      // 04c: iload 7
      // 04e: ldc_w -1093904210
      // 051: ldc_w -1093904218
      // 054: ixor
      // 055: ishr
      // 056: ldc_w -1093904295
      // 059: ldc_w -1093904218
      // 05c: ixor
      // 05d: iand
      // 05e: i2f
      // 05f: ldc 255.0
      // 061: fdiv
      // 062: fstore 11
      // 064: iload 7
      // 066: ldc_w -1093904295
      // 069: ldc_w -1093904218
      // 06c: ixor
      // 06d: iand
      // 06e: i2f
      // 06f: ldc 255.0
      // 071: fdiv
      // 072: fstore 12
      // 074: invokestatic net/minecraft/client/renderer/Tessellator.getInstance ()Lnet/minecraft/client/renderer/Tessellator;
      // 077: astore 13
      // 079: aload 13
      // 07b: invokevirtual net/minecraft/client/renderer/Tessellator.getWorldRenderer ()Lnet/minecraft/client/renderer/WorldRenderer;
      // 07e: astore 14
      // 080: invokestatic net/minecraft/client/renderer/GlStateManager.enableBlend ()V
      // 083: invokestatic net/minecraft/client/renderer/GlStateManager.disableTexture2D ()V
      // 086: ldc_w -1093903452
      // 089: ldc_w -1093904218
      // 08c: ixor
      // 08d: ldc_w -1093903451
      // 090: ldc_w -1093904218
      // 093: ixor
      // 094: bipush 1
      // 095: bipush 0
      // 096: invokestatic net/minecraft/client/renderer/GlStateManager.tryBlendFuncSeparate (IIII)V
      // 099: ldc_w -1093905530
      // 09c: ldc_w -1093904218
      // 09f: ixor
      // 0a0: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 0a3: fload 10
      // 0a5: fload 11
      // 0a7: fload 12
      // 0a9: fload 9
      // 0ab: invokestatic org/lwjgl/opengl/GL11.glColor4f (FFFF)V
      // 0ae: ldc2_w 180.0
      // 0b1: invokestatic java/lang/Math.toRadians (D)D
      // 0b4: dstore 15
      // 0b6: aload 14
      // 0b8: ldc_w -1093904224
      // 0bb: ldc_w -1093904218
      // 0be: ixor
      // 0bf: getstatic net/minecraft/client/renderer/vertex/DefaultVertexFormats.POSITION Lnet/minecraft/client/renderer/vertex/VertexFormat;
      // 0c2: invokevirtual net/minecraft/client/renderer/WorldRenderer.begin (ILnet/minecraft/client/renderer/vertex/VertexFormat;)V
      // 0c5: bipush 0
      // 0c6: istore 17
      // 0c8: iload 17
      // 0ca: iload 6
      // 0cc: if_icmpge 10d
      // 0cf: ldc2_w 6.283185307179586
      // 0d2: iload 17
      // 0d4: i2d
      // 0d5: dmul
      // 0d6: iload 6
      // 0d8: i2d
      // 0d9: ddiv
      // 0da: dload 15
      // 0dc: dadd
      // 0dd: dstore 18
      // 0df: iload 8
      // 0e1: aload 14
      // 0e3: dload 0
      // 0e4: dload 18
      // 0e6: invokestatic java/lang/Math.sin (D)D
      // 0e9: dload 4
      // 0eb: dmul
      // 0ec: dadd
      // 0ed: dload 2
      // 0ee: dload 18
      // 0f0: invokestatic java/lang/Math.cos (D)D
      // 0f3: dload 4
      // 0f5: dmul
      // 0f6: dadd
      // 0f7: dconst_0
      // 0f8: invokevirtual net/minecraft/client/renderer/WorldRenderer.pos (DDD)Lnet/minecraft/client/renderer/WorldRenderer;
      // 0fb: invokevirtual net/minecraft/client/renderer/WorldRenderer.endVertex ()V
      // 0fe: ifne 118
      // 101: iinc 17 1
      // 104: iload 8
      // 106: ifeq 0c8
      // 109: goto 10d
      // 10c: athrow
      // 10d: aload 13
      // 10f: invokevirtual net/minecraft/client/renderer/Tessellator.draw ()V
      // 112: invokestatic net/minecraft/client/renderer/GlStateManager.enableTexture2D ()V
      // 115: invokestatic net/minecraft/client/renderer/GlStateManager.disableBlend ()V
      // 118: return
   }

   public static Framebuffer τ(Framebuffer var0) {
      return ɓ(var0, false);
   }

   public static Framebuffer ɓ(Framebuffer param0, boolean param1) {
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
      // 06: ifne 41
      // 09: invokestatic x/ocbd4917c4b1.Θ (Lnet/minecraft/client/shader/Framebuffer;)Z
      // 0c: ifeq 40
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: iload 2
      // 15: ifne 3f
      // 18: goto 1c
      // 1b: athrow
      // 1c: ifnull 2b
      // 1f: goto 23
      // 22: athrow
      // 23: aload 0
      // 24: invokevirtual net/minecraft/client/shader/Framebuffer.deleteFramebuffer ()V
      // 27: goto 2b
      // 2a: athrow
      // 2b: new net/minecraft/client/shader/Framebuffer
      // 2e: dup
      // 2f: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 32: getfield net/minecraft/client/Minecraft.displayWidth I
      // 35: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 38: getfield net/minecraft/client/Minecraft.displayHeight I
      // 3b: iload 1
      // 3c: invokespecial net/minecraft/client/shader/Framebuffer.<init> (IIZ)V
      // 3f: areturn
      // 40: aload 0
      // 41: areturn
   }

   public static boolean Θ(Framebuffer param0) {
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
      // 06: ifne 11
      // 09: ifnull 3e
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 0
      // 11: getfield net/minecraft/client/shader/Framebuffer.framebufferWidth I
      // 14: iload 1
      // 15: ifne 43
      // 18: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 1b: getfield net/minecraft/client/Minecraft.displayWidth I
      // 1e: if_icmpne 3e
      // 21: goto 25
      // 24: athrow
      // 25: aload 0
      // 26: getfield net/minecraft/client/shader/Framebuffer.framebufferHeight I
      // 29: iload 1
      // 2a: ifne 43
      // 2d: goto 31
      // 30: athrow
      // 31: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 34: getfield net/minecraft/client/Minecraft.displayHeight I
      // 37: if_icmpeq 46
      // 3a: goto 3e
      // 3d: athrow
      // 3e: bipush 1
      // 3f: goto 43
      // 42: athrow
      // 43: goto 47
      // 46: bipush 0
      // 47: ireturn
   }

   public static void Ή(Framebuffer var0) {
      try {
         if (var0 == null) {
            return;
         }
      } catch (IllegalStateException var2) {
         throw var2;
      }

      ScaledResolution var1 = new ScaledResolution(ocda171fe5d8.ǔ);
      GlStateManager.bindTexture(var0.framebufferTexture);
      GL11.glBegin(-1986712052 ^ -1986712053);
      GL11.glTexCoord2d(0.0, 1.0);
      GL11.glVertex2d(0.0, 0.0);
      GL11.glTexCoord2d(0.0, 0.0);
      GL11.glVertex2d(0.0, var1.getScaledHeight());
      GL11.glTexCoord2d(1.0, 0.0);
      GL11.glVertex2d(var1.getScaledWidth(), var1.getScaledHeight());
      GL11.glTexCoord2d(1.0, 1.0);
      GL11.glVertex2d(var1.getScaledWidth(), 0.0);
      oc170ea29aae.ŷ();
   }

   public static void ã(int var0) {
      GlStateManager.bindTexture(var0);
   }

   public static void В(float var0) {
      GlStateManager.enableAlpha();
      GlStateManager.alphaFunc(-1117182993 ^ -1117183509, (float)(var0 * 0.01));
   }

   public static Color С(Color var0, Color var1, float var2) {
      var2 = Math.min(1.0F, Math.max(0.0F, var2));
      return new Color(
         Ș(var0.getRed(), var1.getRed(), var2),
         Ș(var0.getGreen(), var1.getGreen(), var2),
         Ș(var0.getBlue(), var1.getBlue(), var2),
         Ș(var0.getAlpha(), var1.getAlpha(), var2)
      );
   }

   public static int Ș(int var0, int var1, double var2) {
      return Ҭ(var0, var1, (float)var2).intValue();
   }

   public static Double Ҭ(double var0, double var2, double var4) {
      return var0 + (var2 - var0) * var4;
   }

   public static void Ԃ() {
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static Vec3 ʵ(int var0, double var1, double var3, double var5) {
      oc30aea91d28.Ĳ(-994257212 ^ -994255518, Ǽ);
      oc30aea91d28.Ĳ(-994257211 ^ -994255518, ս);
      oc30aea91d28.Թ(-994257216 ^ -994255518, Խ);
      boolean var7 = GLU.gluProject((float)var1, (float)var3, (float)var5, Ǽ, ս, Խ, Ϩ);

      try {
         return var7 ? new Vec3(Ϩ.get(0) / var0, (Display.getHeight() - Ϩ.get(1)) / var0, Ϩ.get(-994255520 ^ -994255518)) : null;
      } catch (IllegalStateException var8) {
         throw var8;
      }
   }

   public static oc29a4412fc2 ө(oc29a4412fc2 var0, int var1) {
      int var2 = oc75d51ec7eb.ϩ;

      label20: {
         try {
            if (var2 != 0) {
               return var0;
            }

            if (var0 != null) {
               break label20;
            }
         } catch (IllegalStateException var3) {
            throw var3;
         }

         var0 = new oc29a4412fc2();
      }

      var0.ɬ = var1;
      ((Buffer)var0.d).clear();
      ((Buffer)var0.L).clear();
      ((Buffer)var0.ō).clear();
      oc30aea91d28.Ĳ(-1166828253 ^ -1166829947, var0.d);
      oc30aea91d28.Ĳ(-1166828254 ^ -1166829947, var0.L);
      oc30aea91d28.Թ(-1166828249 ^ -1166829947, var0.ō);
      ((Buffer)var0.d).rewind();
      ((Buffer)var0.L).rewind();
      ((Buffer)var0.ō).rewind();
      return var0;
   }

   public static boolean Ǜ(oc29a4412fc2 param0, double param1, double param3, double param5, double[] param7) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 8
      // 05: aload 0
      // 06: dload 1
      // 07: dload 3
      // 08: dload 5
      // 0a: aload 0
      // 0b: iload 8
      // 0d: ifne 1d
      // 10: ifnonnull 1c
      // 13: goto 17
      // 16: athrow
      // 17: bipush 1
      // 18: goto 20
      // 1b: athrow
      // 1c: aload 0
      // 1d: getfield x/oc29a4412fc2.ɬ I
      // 20: aload 7
      // 22: invokestatic x/ocbd4917c4b1.ċ (Lx/oc29a4412fc2;DDDI[D)Z
      // 25: ireturn
   }

   public static boolean ċ(oc29a4412fc2 param0, double param1, double param3, double param5, int param7, double[] param8) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 9
      // 05: aload 0
      // 06: ifnull 31
      // 09: aload 8
      // 0b: iload 9
      // 0d: ifne 1d
      // 10: goto 14
      // 13: athrow
      // 14: ifnull 31
      // 17: goto 1b
      // 1a: athrow
      // 1b: aload 8
      // 1d: arraylength
      // 1e: iload 9
      // 20: ifne 56
      // 23: ldc_w -1532627477
      // 26: ldc_w -1532627480
      // 29: ixor
      // 2a: if_icmpge 34
      // 2d: goto 31
      // 30: athrow
      // 31: bipush 0
      // 32: ireturn
      // 33: athrow
      // 34: aload 0
      // 35: getfield x/oc29a4412fc2.Ŏ Ljava/nio/FloatBuffer;
      // 38: invokevirtual java/nio/Buffer.clear ()Ljava/nio/Buffer;
      // 3b: pop
      // 3c: dload 1
      // 3d: d2f
      // 3e: dload 3
      // 3f: d2f
      // 40: dload 5
      // 42: d2f
      // 43: aload 0
      // 44: getfield x/oc29a4412fc2.d Ljava/nio/FloatBuffer;
      // 47: aload 0
      // 48: getfield x/oc29a4412fc2.L Ljava/nio/FloatBuffer;
      // 4b: aload 0
      // 4c: getfield x/oc29a4412fc2.ō Ljava/nio/IntBuffer;
      // 4f: aload 0
      // 50: getfield x/oc29a4412fc2.Ŏ Ljava/nio/FloatBuffer;
      // 53: invokestatic org/lwjgl/util/glu/GLU.gluProject (FFFLjava/nio/FloatBuffer;Ljava/nio/FloatBuffer;Ljava/nio/IntBuffer;Ljava/nio/FloatBuffer;)Z
      // 56: istore 10
      // 58: iload 9
      // 5a: ifne a9
      // 5d: iload 10
      // 5f: ifne 69
      // 62: goto 66
      // 65: athrow
      // 66: bipush 0
      // 67: ireturn
      // 68: athrow
      // 69: aload 8
      // 6b: bipush 0
      // 6c: aload 0
      // 6d: getfield x/oc29a4412fc2.Ŏ Ljava/nio/FloatBuffer;
      // 70: bipush 0
      // 71: invokevirtual java/nio/FloatBuffer.get (I)F
      // 74: iload 7
      // 76: i2f
      // 77: fdiv
      // 78: f2d
      // 79: dastore
      // 7a: aload 8
      // 7c: bipush 1
      // 7d: invokestatic org/lwjgl/opengl/Display.getHeight ()I
      // 80: i2f
      // 81: aload 0
      // 82: getfield x/oc29a4412fc2.Ŏ Ljava/nio/FloatBuffer;
      // 85: bipush 1
      // 86: invokevirtual java/nio/FloatBuffer.get (I)F
      // 89: fsub
      // 8a: iload 7
      // 8c: i2f
      // 8d: fdiv
      // 8e: f2d
      // 8f: dastore
      // 90: aload 8
      // 92: ldc_w -1532627478
      // 95: ldc_w -1532627480
      // 98: ixor
      // 99: aload 0
      // 9a: getfield x/oc29a4412fc2.Ŏ Ljava/nio/FloatBuffer;
      // 9d: ldc_w -1532627478
      // a0: ldc_w -1532627480
      // a3: ixor
      // a4: invokevirtual java/nio/FloatBuffer.get (I)F
      // a7: f2d
      // a8: dastore
      // a9: bipush 1
      // aa: ireturn
   }

   public static void Ӛ(float param0, float param1, float param2, float param3, float param4, int param5) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 6
      // 005: fload 2
      // 006: iload 6
      // 008: ifne 019
      // 00b: fload 0
      // 00c: fcmpg
      // 00d: ifgt 016
      // 010: goto 014
      // 013: athrow
      // 014: return
      // 015: athrow
      // 016: fload 2
      // 017: fload 0
      // 018: fsub
      // 019: fstore 7
      // 01b: fload 7
      // 01d: iload 6
      // 01f: ifne 057
      // 022: ldc_w 3.0
      // 025: fcmpg
      // 026: ifge 038
      // 029: goto 02d
      // 02c: athrow
      // 02d: fload 4
      // 02f: fload 7
      // 031: fconst_2
      // 032: fdiv
      // 033: invokestatic java/lang/Math.min (FF)F
      // 036: fstore 4
      // 038: fload 0
      // 039: f2d
      // 03a: ldc2_w 2.0
      // 03d: dmul
      // 03e: d2f
      // 03f: fstore 0
      // 040: fload 1
      // 041: f2d
      // 042: ldc2_w 2.0
      // 045: dmul
      // 046: d2f
      // 047: fstore 1
      // 048: fload 2
      // 049: f2d
      // 04a: ldc2_w 2.0
      // 04d: dmul
      // 04e: d2f
      // 04f: fstore 2
      // 050: fload 3
      // 051: f2d
      // 052: ldc2_w 2.0
      // 055: dmul
      // 056: d2f
      // 057: fstore 3
      // 058: invokestatic org/lwjgl/opengl/GL11.glPushMatrix ()V
      // 05b: ldc_w -2033410566
      // 05e: ldc_w -2034015739
      // 061: ixor
      // 062: invokestatic org/lwjgl/opengl/GL11.glPushAttrib (I)V
      // 065: ldc2_w 0.5
      // 068: ldc2_w 0.5
      // 06b: ldc2_w 0.5
      // 06e: invokestatic org/lwjgl/opengl/GL11.glScaled (DDD)V
      // 071: ldc_w -2034013721
      // 074: ldc_w -2034015739
      // 077: ixor
      // 078: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 07b: ldc_w -2034012188
      // 07e: ldc_w -2034015739
      // 081: ixor
      // 082: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 085: ldc_w -2034013915
      // 088: ldc_w -2034015739
      // 08b: ixor
      // 08c: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 08f: ldc_w -2034015732
      // 092: ldc_w -2034015739
      // 095: ixor
      // 096: invokestatic org/lwjgl/opengl/GL11.glBegin (I)V
      // 099: iload 5
      // 09b: invokestatic x/ocbd4917c4b1.I (I)V
      // 09e: bipush 0
      // 09f: istore 8
      // 0a1: iload 8
      // 0a3: ldc_w -2034015649
      // 0a6: ldc_w -2034015739
      // 0a9: ixor
      // 0aa: if_icmpgt 0ed
      // 0ad: iload 8
      // 0af: i2f
      // 0b0: iload 6
      // 0b2: ifne 149
      // 0b5: ldc_w 0.017453292
      // 0b8: fmul
      // 0b9: f2d
      // 0ba: dstore 9
      // 0bc: iload 6
      // 0be: fload 0
      // 0bf: fload 4
      // 0c1: fadd
      // 0c2: f2d
      // 0c3: dload 9
      // 0c5: invokestatic java/lang/Math.sin (D)D
      // 0c8: fload 4
      // 0ca: f2d
      // 0cb: dmul
      // 0cc: ldc2_w -1.0
      // 0cf: dmul
      // 0d0: dadd
      // 0d1: fload 1
      // 0d2: fload 4
      // 0d4: fadd
      // 0d5: f2d
      // 0d6: dload 9
      // 0d8: invokestatic java/lang/Math.cos (D)D
      // 0db: fload 4
      // 0dd: f2d
      // 0de: dmul
      // 0df: ldc2_w -1.0
      // 0e2: dmul
      // 0e3: dadd
      // 0e4: invokestatic org/lwjgl/opengl/GL11.glVertex2d (DD)V
      // 0e7: iinc 8 3
      // 0ea: ifeq 0a1
      // 0ed: ldc_w -2034015649
      // 0f0: ldc_w -2034015739
      // 0f3: ixor
      // 0f4: istore 8
      // 0f6: iload 8
      // 0f8: ldc_w -2034015567
      // 0fb: ldc_w -2034015739
      // 0fe: ixor
      // 0ff: if_icmpgt 146
      // 102: iload 8
      // 104: i2f
      // 105: ldc_w 0.017453292
      // 108: fmul
      // 109: f2d
      // 10a: dstore 9
      // 10c: iload 6
      // 10e: fload 0
      // 10f: fload 4
      // 111: fadd
      // 112: f2d
      // 113: dload 9
      // 115: invokestatic java/lang/Math.sin (D)D
      // 118: fload 4
      // 11a: f2d
      // 11b: dmul
      // 11c: ldc2_w -1.0
      // 11f: dmul
      // 120: dadd
      // 121: fload 3
      // 122: fload 4
      // 124: fsub
      // 125: f2d
      // 126: dload 9
      // 128: invokestatic java/lang/Math.cos (D)D
      // 12b: fload 4
      // 12d: f2d
      // 12e: dmul
      // 12f: ldc2_w -1.0
      // 132: dmul
      // 133: dadd
      // 134: invokestatic org/lwjgl/opengl/GL11.glVertex2d (DD)V
      // 137: ifne 22a
      // 13a: iinc 8 3
      // 13d: iload 6
      // 13f: ifeq 0f6
      // 142: goto 146
      // 145: athrow
      // 146: fload 2
      // 147: fload 0
      // 148: fsub
      // 149: iload 6
      // 14b: ifne 224
      // 14e: f2d
      // 14f: ldc2_w 4.5
      // 152: dcmpl
      // 153: iflt 1f2
      // 156: goto 15a
      // 159: athrow
      // 15a: bipush 0
      // 15b: istore 8
      // 15d: iload 8
      // 15f: ldc_w -2034015649
      // 162: ldc_w -2034015739
      // 165: ixor
      // 166: if_icmpgt 1a5
      // 169: iload 8
      // 16b: i2f
      // 16c: ldc_w 0.017453292
      // 16f: fmul
      // 170: f2d
      // 171: dstore 9
      // 173: fload 2
      // 174: fload 4
      // 176: fsub
      // 177: f2d
      // 178: dload 9
      // 17a: invokestatic java/lang/Math.sin (D)D
      // 17d: fload 4
      // 17f: f2d
      // 180: dmul
      // 181: dadd
      // 182: fload 3
      // 183: fload 4
      // 185: fsub
      // 186: f2d
      // 187: iload 6
      // 189: ifne 1e7
      // 18c: dload 9
      // 18e: invokestatic java/lang/Math.cos (D)D
      // 191: fload 4
      // 193: f2d
      // 194: dmul
      // 195: dadd
      // 196: invokestatic org/lwjgl/opengl/GL11.glVertex2d (DD)V
      // 199: iload 6
      // 19b: iinc 8 1
      // 19e: ifeq 15d
      // 1a1: goto 1a5
      // 1a4: athrow
      // 1a5: ldc_w -2034015649
      // 1a8: ldc_w -2034015739
      // 1ab: ixor
      // 1ac: istore 8
      // 1ae: iload 8
      // 1b0: ldc_w -2034015567
      // 1b3: ldc_w -2034015739
      // 1b6: ixor
      // 1b7: if_icmpgt 1f2
      // 1ba: iload 8
      // 1bc: i2f
      // 1bd: ldc_w 0.017453292
      // 1c0: fmul
      // 1c1: iload 6
      // 1c3: ifne 224
      // 1c6: f2d
      // 1c7: dstore 9
      // 1c9: fload 2
      // 1ca: fload 4
      // 1cc: fsub
      // 1cd: f2d
      // 1ce: dload 9
      // 1d0: invokestatic java/lang/Math.sin (D)D
      // 1d3: fload 4
      // 1d5: f2d
      // 1d6: dmul
      // 1d7: dadd
      // 1d8: fload 1
      // 1d9: fload 4
      // 1db: fadd
      // 1dc: f2d
      // 1dd: dload 9
      // 1df: invokestatic java/lang/Math.cos (D)D
      // 1e2: fload 4
      // 1e4: f2d
      // 1e5: dmul
      // 1e6: dadd
      // 1e7: invokestatic org/lwjgl/opengl/GL11.glVertex2d (DD)V
      // 1ea: iload 6
      // 1ec: iinc 8 1
      // 1ef: ifeq 1ae
      // 1f2: invokestatic x/oc170ea29aae.ŷ ()V
      // 1f5: ldc_w -2034012188
      // 1f8: ldc_w -2034015739
      // 1fb: ixor
      // 1fc: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 1ff: ldc_w -2034013721
      // 202: ldc_w -2034015739
      // 205: ixor
      // 206: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 209: ldc_w -2034013915
      // 20c: ldc_w -2034015739
      // 20f: ixor
      // 210: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 213: ldc_w -2034012188
      // 216: ldc_w -2034015739
      // 219: ixor
      // 21a: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 21d: invokestatic org/lwjgl/opengl/GL11.glPopAttrib ()V
      // 220: invokestatic org/lwjgl/opengl/GL11.glPopMatrix ()V
      // 223: fconst_1
      // 224: fconst_1
      // 225: fconst_1
      // 226: fconst_1
      // 227: invokestatic net/minecraft/client/renderer/GlStateManager.color (FFFF)V
      // 22a: return
   }

   public static void Ç(float var0, float var1, float var2, float var3, int var4) {
      GL11.glPushMatrix();
      GL11.glEnable(-1278907072 ^ -1278908766);
      GL11.glBlendFunc(-1278909024 ^ -1278908766, -1278909023 ^ -1278908766);
      GL11.glDisable(-1278907581 ^ -1278908766);
      I(var4);
      GL11.glBegin(-1278908763 ^ -1278908766);
      GL11.glVertex2f(var0, var1);
      GL11.glVertex2f(var0, var3);
      GL11.glVertex2f(var2, var3);
      GL11.glVertex2f(var2, var1);
      oc170ea29aae.ŷ();
      GL11.glEnable(-1278907581 ^ -1278908766);
      GL11.glDisable(-1278907072 ^ -1278908766);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glPopMatrix();
   }

   public static void Ӷ(float param0, float param1, float param2, float param3, float param4, int param5, int param6, int param7, int param8) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 9
      // 005: fload 2
      // 006: iload 9
      // 008: ifne 019
      // 00b: fload 0
      // 00c: fcmpg
      // 00d: ifgt 016
      // 010: goto 014
      // 013: athrow
      // 014: return
      // 015: athrow
      // 016: fload 2
      // 017: fload 0
      // 018: fsub
      // 019: fstore 10
      // 01b: iload 9
      // 01d: ifne 0e1
      // 020: fload 10
      // 022: ldc_w 3.0
      // 025: fcmpg
      // 026: ifge 038
      // 029: goto 02d
      // 02c: athrow
      // 02d: fload 4
      // 02f: fload 10
      // 031: fconst_2
      // 032: fdiv
      // 033: invokestatic java/lang/Math.min (FF)F
      // 036: fstore 4
      // 038: ldc_w 1511529579
      // 03b: ldc_w 1511528329
      // 03e: ixor
      // 03f: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 042: ldc_w 1511529064
      // 045: ldc_w 1511528329
      // 048: ixor
      // 049: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 04c: ldc_w 1511527563
      // 04f: ldc_w 1511528329
      // 052: ixor
      // 053: ldc_w 1511527562
      // 056: ldc_w 1511528329
      // 059: ixor
      // 05a: invokestatic org/lwjgl/opengl/GL11.glBlendFunc (II)V
      // 05d: ldc_w 1511529641
      // 060: ldc_w 1511528329
      // 063: ixor
      // 064: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 067: ldc_w 1511525000
      // 06a: ldc_w 1511528329
      // 06d: ixor
      // 06e: invokestatic org/lwjgl/opengl/GL11.glShadeModel (I)V
      // 071: invokestatic org/lwjgl/opengl/GL11.glPushMatrix ()V
      // 074: ldc_w 1511516278
      // 077: ldc_w 1511528329
      // 07a: ixor
      // 07b: invokestatic org/lwjgl/opengl/GL11.glPushAttrib (I)V
      // 07e: ldc2_w 0.5
      // 081: ldc2_w 0.5
      // 084: ldc2_w 0.5
      // 087: invokestatic org/lwjgl/opengl/GL11.glScaled (DDD)V
      // 08a: fload 0
      // 08b: f2d
      // 08c: ldc2_w 2.0
      // 08f: dmul
      // 090: d2f
      // 091: fstore 0
      // 092: fload 1
      // 093: f2d
      // 094: ldc2_w 2.0
      // 097: dmul
      // 098: d2f
      // 099: fstore 1
      // 09a: fload 2
      // 09b: f2d
      // 09c: ldc2_w 2.0
      // 09f: dmul
      // 0a0: d2f
      // 0a1: fstore 2
      // 0a2: fload 3
      // 0a3: f2d
      // 0a4: ldc2_w 2.0
      // 0a7: dmul
      // 0a8: d2f
      // 0a9: fstore 3
      // 0aa: ldc_w 1511529579
      // 0ad: ldc_w 1511528329
      // 0b0: ixor
      // 0b1: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 0b4: ldc_w 1511529064
      // 0b7: ldc_w 1511528329
      // 0ba: ixor
      // 0bb: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 0be: iload 5
      // 0c0: invokestatic x/ocbd4917c4b1.I (I)V
      // 0c3: ldc_w 1511529641
      // 0c6: ldc_w 1511528329
      // 0c9: ixor
      // 0ca: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 0cd: ldc_w 1511525000
      // 0d0: ldc_w 1511528329
      // 0d3: ixor
      // 0d4: invokestatic org/lwjgl/opengl/GL11.glShadeModel (I)V
      // 0d7: ldc_w 1511528320
      // 0da: ldc_w 1511528329
      // 0dd: ixor
      // 0de: invokestatic org/lwjgl/opengl/GL11.glBegin (I)V
      // 0e1: bipush 0
      // 0e2: istore 11
      // 0e4: iload 11
      // 0e6: ldc_w 1511528403
      // 0e9: ldc_w 1511528329
      // 0ec: ixor
      // 0ed: if_icmpgt 130
      // 0f0: iload 11
      // 0f2: i2f
      // 0f3: ldc_w 0.017453292
      // 0f6: iload 9
      // 0f8: ifne 199
      // 0fb: fmul
      // 0fc: f2d
      // 0fd: dstore 12
      // 0ff: iload 9
      // 101: fload 0
      // 102: fload 4
      // 104: fadd
      // 105: f2d
      // 106: dload 12
      // 108: invokestatic java/lang/Math.sin (D)D
      // 10b: fload 4
      // 10d: f2d
      // 10e: dmul
      // 10f: ldc2_w -1.0
      // 112: dmul
      // 113: dadd
      // 114: fload 1
      // 115: fload 4
      // 117: fadd
      // 118: f2d
      // 119: dload 12
      // 11b: invokestatic java/lang/Math.cos (D)D
      // 11e: fload 4
      // 120: f2d
      // 121: dmul
      // 122: ldc2_w -1.0
      // 125: dmul
      // 126: dadd
      // 127: invokestatic org/lwjgl/opengl/GL11.glVertex2d (DD)V
      // 12a: iinc 11 3
      // 12d: ifeq 0e4
      // 130: iload 6
      // 132: invokestatic x/ocbd4917c4b1.I (I)V
      // 135: ldc_w 1511528403
      // 138: ldc_w 1511528329
      // 13b: ixor
      // 13c: istore 11
      // 13e: iload 11
      // 140: ldc_w 1511528253
      // 143: ldc_w 1511528329
      // 146: ixor
      // 147: if_icmpgt 18e
      // 14a: iload 11
      // 14c: i2f
      // 14d: ldc_w 0.017453292
      // 150: fmul
      // 151: f2d
      // 152: dstore 12
      // 154: fload 0
      // 155: fload 4
      // 157: fadd
      // 158: f2d
      // 159: dload 12
      // 15b: invokestatic java/lang/Math.sin (D)D
      // 15e: fload 4
      // 160: f2d
      // 161: dmul
      // 162: ldc2_w -1.0
      // 165: iload 9
      // 167: ifne 238
      // 16a: dmul
      // 16b: dadd
      // 16c: fload 3
      // 16d: fload 4
      // 16f: fsub
      // 170: f2d
      // 171: dload 12
      // 173: invokestatic java/lang/Math.cos (D)D
      // 176: fload 4
      // 178: f2d
      // 179: dmul
      // 17a: ldc2_w -1.0
      // 17d: dmul
      // 17e: dadd
      // 17f: invokestatic org/lwjgl/opengl/GL11.glVertex2d (DD)V
      // 182: iload 9
      // 184: iinc 11 3
      // 187: ifeq 13e
      // 18a: goto 18e
      // 18d: athrow
      // 18e: fload 2
      // 18f: iload 9
      // 191: ifne 2a8
      // 194: fload 0
      // 195: goto 199
      // 198: athrow
      // 199: fsub
      // 19a: f2d
      // 19b: ldc2_w 4.5
      // 19e: dcmpl
      // 19f: iflt 244
      // 1a2: iload 7
      // 1a4: invokestatic x/ocbd4917c4b1.I (I)V
      // 1a7: bipush 0
      // 1a8: istore 11
      // 1aa: iload 11
      // 1ac: ldc_w 1511528403
      // 1af: ldc_w 1511528329
      // 1b2: ixor
      // 1b3: if_icmpgt 1f2
      // 1b6: iload 11
      // 1b8: i2f
      // 1b9: ldc_w 0.017453292
      // 1bc: fmul
      // 1bd: f2d
      // 1be: dstore 12
      // 1c0: fload 2
      // 1c1: fload 4
      // 1c3: iload 9
      // 1c5: ifne 2a9
      // 1c8: fsub
      // 1c9: f2d
      // 1ca: dload 12
      // 1cc: invokestatic java/lang/Math.sin (D)D
      // 1cf: fload 4
      // 1d1: f2d
      // 1d2: dmul
      // 1d3: dadd
      // 1d4: fload 3
      // 1d5: fload 4
      // 1d7: fsub
      // 1d8: f2d
      // 1d9: dload 12
      // 1db: invokestatic java/lang/Math.cos (D)D
      // 1de: fload 4
      // 1e0: f2d
      // 1e1: dmul
      // 1e2: dadd
      // 1e3: invokestatic org/lwjgl/opengl/GL11.glVertex2d (DD)V
      // 1e6: iload 9
      // 1e8: iinc 11 3
      // 1eb: ifeq 1aa
      // 1ee: goto 1f2
      // 1f1: athrow
      // 1f2: iload 8
      // 1f4: invokestatic x/ocbd4917c4b1.I (I)V
      // 1f7: ldc_w 1511528403
      // 1fa: ldc_w 1511528329
      // 1fd: ixor
      // 1fe: istore 11
      // 200: iload 11
      // 202: ldc_w 1511528253
      // 205: ldc_w 1511528329
      // 208: ixor
      // 209: if_icmpgt 244
      // 20c: iload 9
      // 20e: ifne 2ae
      // 211: iload 11
      // 213: i2f
      // 214: ldc_w 0.017453292
      // 217: fmul
      // 218: f2d
      // 219: dstore 12
      // 21b: fload 2
      // 21c: fload 4
      // 21e: fsub
      // 21f: f2d
      // 220: dload 12
      // 222: invokestatic java/lang/Math.sin (D)D
      // 225: fload 4
      // 227: f2d
      // 228: dmul
      // 229: dadd
      // 22a: fload 1
      // 22b: fload 4
      // 22d: fadd
      // 22e: f2d
      // 22f: dload 12
      // 231: invokestatic java/lang/Math.cos (D)D
      // 234: fload 4
      // 236: f2d
      // 237: dmul
      // 238: dadd
      // 239: invokestatic org/lwjgl/opengl/GL11.glVertex2d (DD)V
      // 23c: iload 9
      // 23e: iinc 11 3
      // 241: ifeq 200
      // 244: invokestatic x/oc170ea29aae.ŷ ()V
      // 247: ldc_w 1511529064
      // 24a: ldc_w 1511528329
      // 24d: ixor
      // 24e: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 251: ldc_w 1511529579
      // 254: ldc_w 1511528329
      // 257: ixor
      // 258: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 25b: ldc_w 1511529641
      // 25e: ldc_w 1511528329
      // 261: ixor
      // 262: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 265: ldc_w 1511529579
      // 268: ldc_w 1511528329
      // 26b: ixor
      // 26c: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 26f: ldc_w 1511529064
      // 272: ldc_w 1511528329
      // 275: ixor
      // 276: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 279: invokestatic org/lwjgl/opengl/GL11.glPopAttrib ()V
      // 27c: invokestatic org/lwjgl/opengl/GL11.glPopMatrix ()V
      // 27f: ldc_w 1511529064
      // 282: ldc_w 1511528329
      // 285: ixor
      // 286: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 289: ldc_w 1511529579
      // 28c: ldc_w 1511528329
      // 28f: ixor
      // 290: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 293: ldc_w 1511529641
      // 296: ldc_w 1511528329
      // 299: ixor
      // 29a: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 29d: ldc_w 1511525001
      // 2a0: ldc_w 1511528329
      // 2a3: ixor
      // 2a4: invokestatic org/lwjgl/opengl/GL11.glShadeModel (I)V
      // 2a7: fconst_1
      // 2a8: fconst_1
      // 2a9: fconst_1
      // 2aa: fconst_1
      // 2ab: invokestatic net/minecraft/client/renderer/GlStateManager.color (FFFF)V
      // 2ae: return
   }

   public static int Υ(int param0, double param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 3
      // 04: dload 1
      // 05: iload 3
      // 06: ifne 27
      // 09: dconst_0
      // 0a: dcmpg
      // 0b: iflt 24
      // 0e: goto 12
      // 11: athrow
      // 12: dload 1
      // 13: dconst_1
      // 14: dcmpl
      // 15: iload 3
      // 16: ifne 39
      // 19: goto 1d
      // 1c: athrow
      // 1d: ifle 28
      // 20: goto 24
      // 23: athrow
      // 24: ldc2_w 0.5
      // 27: dstore 1
      // 28: iload 0
      // 29: ldc_w 1489821361
      // 2c: ldc_w 1489821345
      // 2f: ixor
      // 30: ishr
      // 31: ldc_w 1489821278
      // 34: ldc_w 1489821345
      // 37: ixor
      // 38: iand
      // 39: istore 4
      // 3b: iload 0
      // 3c: ldc_w 1489821353
      // 3f: ldc_w 1489821345
      // 42: ixor
      // 43: ishr
      // 44: ldc_w 1489821278
      // 47: ldc_w 1489821345
      // 4a: ixor
      // 4b: iand
      // 4c: istore 5
      // 4e: iload 0
      // 4f: ldc_w 1489821278
      // 52: ldc_w 1489821345
      // 55: ixor
      // 56: iand
      // 57: istore 6
      // 59: dload 1
      // 5a: ldc2_w 255.0
      // 5d: dmul
      // 5e: d2i
      // 5f: istore 7
      // 61: iload 7
      // 63: ldc_w 1489821369
      // 66: ldc_w 1489821345
      // 69: ixor
      // 6a: ishl
      // 6b: iload 4
      // 6d: ldc_w 1489821361
      // 70: ldc_w 1489821345
      // 73: ixor
      // 74: ishl
      // 75: ior
      // 76: iload 5
      // 78: ldc_w 1489821353
      // 7b: ldc_w 1489821345
      // 7e: ixor
      // 7f: ishl
      // 80: ior
      // 81: iload 6
      // 83: ior
      // 84: istore 8
      // 86: iload 8
      // 88: ireturn
   }

   public static void Ѭ(float var0, float var1, float var2, int var3, float var4, float var5, float var6, float var7, float var8) {
      GL11.glPushMatrix();
      GL11.glEnable(2029945416 ^ 2029947306);
      int var10000 = oc75d51ec7eb.ϩ;
      GL11.glEnable(2029945582 ^ 2029947306);
      int var9 = var10000;
      GL11.glBlendFunc(2029947560 ^ 2029947306, 2029947561 ^ 2029947306);
      GL11.glDisable(2029945931 ^ 2029947306);
      GL11.glEnable(2029945482 ^ 2029947306);
      GL11.glColor4f(var5, var6, var7, var8);
      GL11.glLineWidth(var4);
      GL11.glBegin(2029947304 ^ 2029947306);
      int var10 = 0;

      while (true) {
         if (var10 <= var3) {
            double var11 = (Math.PI * 2) * var10 / var3;
            var15 = (float)(var2 * Math.cos(var11)) + var0;
            if (var9 != 0) {
               break;
            }

            float var13 = var15;
            float var14 = (float)(var2 * Math.sin(var11)) + var1;
            GL11.glVertex2f(var13, var14);
            var10++;
            if (var9 == 0) {
               continue;
            }
         }

         oc170ea29aae.ŷ();
         GL11.glDisable(2029945416 ^ 2029947306);
         GL11.glDisable(2029945582 ^ 2029947306);
         GL11.glEnable(2029945931 ^ 2029947306);
         GL11.glDisable(2029945482 ^ 2029947306);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         var15 = 1.0F;
         break;
      }

      GL11.glLineWidth(var15);
      GL11.glPopMatrix();
   }

   public static void ȹ(float var0, float var1, float var2, float var3, float var4, float var5, int var6) {
      float var8 = (var6 >> (-306822014 ^ -306821998) & (-306822035 ^ -306821998)) / 255.0F;
      int var10000 = oc75d51ec7eb.ϩ;
      float var9 = (var6 >> (-306821990 ^ -306821998) & (-306822035 ^ -306821998)) / 255.0F;
      float var10 = (var6 & (-306822035 ^ -306821998)) / 255.0F;
      float var11 = (var6 >> (-306822006 ^ -306821998) & (-306822035 ^ -306821998)) / 255.0F;
      GL11.glPushMatrix();
      GL11.glEnable(-306819216 ^ -306821998);
      GL11.glEnable(-306819114 ^ -306821998);
      GL11.glBlendFunc(-306821232 ^ -306821998, -306821231 ^ -306821998);
      GL11.glDisable(-306820749 ^ -306821998);
      GL11.glEnable(-306819150 ^ -306821998);
      int var7 = var10000;
      GL11.glColor4f(var8, var9, var10, var11);
      GL11.glLineWidth(var5);
      GL11.glBegin(-306821999 ^ -306821998);
      float var12 = var3;

      while (true) {
         if (var12 <= var4) {
            double var13 = Math.toRadians(var12 + 180.0F);
            float var15 = (float)(var2 * Math.cos(var13)) + var0;
            var17 = (float)(var2 * Math.sin(var13)) + var1;
            if (var7 != 0) {
               break;
            }

            float var16 = var17;
            GL11.glVertex2f(var15, var16);
            var12++;
            if (var7 == 0) {
               continue;
            }
         }

         oc170ea29aae.ŷ();
         GL11.glDisable(-306819216 ^ -306821998);
         GL11.glDisable(-306819114 ^ -306821998);
         GL11.glEnable(-306820749 ^ -306821998);
         GL11.glDisable(-306819150 ^ -306821998);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         var17 = 1.0F;
         break;
      }

      GL11.glLineWidth(var17);
      GL11.glPopMatrix();
   }

   public static void Ŏ(float var0, float var1, float var2, float var3, int var4, int var5) {
      float var6 = (var4 >> (816388473 ^ 816388449) & (816388510 ^ 816388449)) / 255.0F;
      float var7 = (var4 >> (816388465 ^ 816388449) & (816388510 ^ 816388449)) / 255.0F;
      float var8 = (var4 >> (816388457 ^ 816388449) & (816388510 ^ 816388449)) / 255.0F;
      float var9 = (var4 & (816388510 ^ 816388449)) / 255.0F;
      float var10 = (var5 >> (816388473 ^ 816388449) & (816388510 ^ 816388449)) / 255.0F;
      float var11 = (var5 >> (816388465 ^ 816388449) & (816388510 ^ 816388449)) / 255.0F;
      float var12 = (var5 >> (816388457 ^ 816388449) & (816388510 ^ 816388449)) / 255.0F;
      float var13 = (var5 & (816388510 ^ 816388449)) / 255.0F;
      GlStateManager.disableTexture2D();
      GlStateManager.enableBlend();
      GlStateManager.disableAlpha();
      GlStateManager.tryBlendFuncSeparate(816388707 ^ 816388449, 816388706 ^ 816388449, 1, 0);
      GlStateManager.shadeModel(816383072 ^ 816388449);
      Tessellator var14 = Tessellator.getInstance();
      WorldRenderer var15 = var14.getWorldRenderer();
      var15.begin(816388454 ^ 816388449, DefaultVertexFormats.POSITION_COLOR);
      var15.pos(var0, var3, 0.0).color(var7, var8, var9, var6).endVertex();
      var15.pos(var2, var3, 0.0).color(var11, var12, var13, var10).endVertex();
      var15.pos(var2, var1, 0.0).color(var11, var12, var13, var10).endVertex();
      var15.pos(var0, var1, 0.0).color(var7, var8, var9, var6).endVertex();
      var14.draw();
      GlStateManager.shadeModel(816383073 ^ 816388449);
      GlStateManager.disableBlend();
      GlStateManager.enableAlpha();
      GlStateManager.enableTexture2D();
   }

   public static void ƺ(float var0, float var1, float var2, float var3, int var4, int var5) {
      float var6 = (var4 >> (1312622595 ^ 1312622619) & (1312622820 ^ 1312622619)) / 255.0F;
      float var7 = (var4 >> (1312622603 ^ 1312622619) & (1312622820 ^ 1312622619)) / 255.0F;
      float var8 = (var4 >> (1312622611 ^ 1312622619) & (1312622820 ^ 1312622619)) / 255.0F;
      float var9 = (var4 & (1312622820 ^ 1312622619)) / 255.0F;
      float var10 = (var5 >> (1312622595 ^ 1312622619) & (1312622820 ^ 1312622619)) / 255.0F;
      float var11 = (var5 >> (1312622603 ^ 1312622619) & (1312622820 ^ 1312622619)) / 255.0F;
      float var12 = (var5 >> (1312622611 ^ 1312622619) & (1312622820 ^ 1312622619)) / 255.0F;
      float var13 = (var5 & (1312622820 ^ 1312622619)) / 255.0F;
      GlStateManager.disableTexture2D();
      GlStateManager.enableBlend();
      GlStateManager.disableAlpha();
      GlStateManager.tryBlendFuncSeparate(1312623385 ^ 1312622619, 1312623384 ^ 1312622619, 1, 0);
      GlStateManager.shadeModel(1312625946 ^ 1312622619);
      Tessellator var14 = Tessellator.getInstance();
      WorldRenderer var15 = var14.getWorldRenderer();
      var15.begin(1312622620 ^ 1312622619, DefaultVertexFormats.POSITION_COLOR);
      var15.pos(var2, var1, 0.0).color(var7, var8, var9, var6).endVertex();
      var15.pos(var0, var1, 0.0).color(var7, var8, var9, var6).endVertex();
      var15.pos(var0, var3, 0.0).color(var11, var12, var13, var10).endVertex();
      var15.pos(var2, var3, 0.0).color(var11, var12, var13, var10).endVertex();
      var14.draw();
      GlStateManager.shadeModel(1312625947 ^ 1312622619);
      GlStateManager.disableBlend();
      GlStateManager.enableAlpha();
      GlStateManager.enableTexture2D();
   }

   public static void Ӱ(ItemStack var0, int var1, int var2) {
      try {
         if (var0 == null) {
            return;
         }
      } catch (IllegalStateException var3) {
         throw var3;
      }

      GlStateManager.pushMatrix();
      S();
      GlStateManager.depthMask(true);
      GlStateManager.clear(1276538850 ^ 1276538594);
      RenderHelper.enableStandardItemLighting();
      GlStateManager.pushMatrix();
      GlStateManager.scale(1.0F, 1.0F, -0.01F);
      ocda171fe5d8.ǔ.getRenderItem().zLevel = -150.0F;
      ocda171fe5d8.ǔ.getRenderItem().renderItemAndEffectIntoGUI(var0, var1, var2);
      ocda171fe5d8.ǔ.getRenderItem().zLevel = 0.0F;
      GlStateManager.popMatrix();
      RenderHelper.disableStandardItemLighting();
      Ԑ();
      GlStateManager.disableBlend();
      GlStateManager.popMatrix();
   }

   public static void û(ItemStack var0, int var1, int var2) {
      try {
         if (var0 == null) {
            return;
         }
      } catch (IllegalStateException var3) {
         throw var3;
      }

      S();
      ocda171fe5d8.ǔ.getRenderItem().zLevel = -150.0F;
      GlStateManager.enableDepth();
      RenderHelper.enableGUIStandardItemLighting();
      ocda171fe5d8.ǔ.getRenderItem().renderItemAndEffectIntoGUI(var0, var1, var2 - (-793768970 ^ -793768962));
      ocda171fe5d8.ǔ.getRenderItem().zLevel = 0.0F;
      GlStateManager.disableDepth();
      Ԑ();
      GlStateManager.disableBlend();
   }

   public static int ȅ(float param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 1
      // 04: fload 0
      // 05: iload 1
      // 06: ifne 1e
      // 09: ldc_w 0.6
      // 0c: fcmpl
      // 0d: ifle 1d
      // 10: goto 14
      // 13: athrow
      // 14: ldc_w -1360713061
      // 17: ldc_w -1360669285
      // 1a: ixor
      // 1b: ireturn
      // 1c: athrow
      // 1d: fload 0
      // 1e: ldc_w 0.3
      // 21: fcmpl
      // 22: iload 1
      // 23: ifne 3d
      // 26: ifle 36
      // 29: goto 2d
      // 2c: athrow
      // 2d: ldc_w -1374016869
      // 30: ldc_w -1360669285
      // 33: ixor
      // 34: ireturn
      // 35: athrow
      // 36: ldc_w -1373973093
      // 39: ldc_w -1360669285
      // 3c: ixor
      // 3d: ireturn
   }

   public static void ǝ(int var0, int var1, float var2) {
      int var3 = (int)(var2 * 13.0F);
      int var4 = ȅ(var2);
      GlStateManager.disableTexture2D();
      Tessellator var5 = Tessellator.getInstance();
      WorldRenderer var6 = var5.getWorldRenderer();
      var6.begin(-57703269 ^ -57703268, DefaultVertexFormats.POSITION_COLOR);
      var6.pos(var0 + (-57703266 ^ -57703268), var1 + (-57703277 ^ -57703268), 0.0).color(0.0F, 0.0F, 0.0F, 1.0F).endVertex();
      var6.pos(var0 + (-57703266 ^ -57703268), var1 + (-57703284 ^ -57703268), 0.0).color(0.0F, 0.0F, 0.0F, 1.0F).endVertex();
      var6.pos(var0 + (-57703277 ^ -57703268), var1 + (-57703284 ^ -57703268), 0.0).color(0.0F, 0.0F, 0.0F, 1.0F).endVertex();
      var6.pos(var0 + (-57703277 ^ -57703268), var1 + (-57703277 ^ -57703268), 0.0).color(0.0F, 0.0F, 0.0F, 1.0F).endVertex();
      var5.draw();
      float var7 = (var4 >> (-57703284 ^ -57703268) & (-57703325 ^ -57703268)) / 255.0F;
      float var8 = (var4 >> (-57703276 ^ -57703268) & (-57703325 ^ -57703268)) / 255.0F;
      float var9 = (var4 & (-57703325 ^ -57703268)) / 255.0F;
      var6.begin(-57703269 ^ -57703268, DefaultVertexFormats.POSITION_COLOR);
      var6.pos(var0 + (-57703266 ^ -57703268), var1 + (-57703277 ^ -57703268), 0.0).color(var7, var8, var9, 1.0F).endVertex();
      var6.pos(var0 + (-57703266 ^ -57703268), var1 + (-57703284 ^ -57703268), 0.0).color(var7, var8, var9, 1.0F).endVertex();
      var6.pos(var0 + (-57703266 ^ -57703268) + var3, var1 + (-57703284 ^ -57703268), 0.0).color(var7, var8, var9, 1.0F).endVertex();
      var6.pos(var0 + (-57703266 ^ -57703268) + var3, var1 + (-57703277 ^ -57703268), 0.0).color(var7, var8, var9, 1.0F).endVertex();
      var5.draw();
      GlStateManager.enableTexture2D();
   }

   public static int ɓ(int param0) {
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
      // 06: ifne 73
      // 09: tableswitch 105 1 10 56 65 73 81 89 105 105 105 105 97
      // 40: athrow
      // 41: ldc_w 255758429
      // 44: ldc_w 264335266
      // 47: ixor
      // 48: ireturn
      // 49: athrow
      // 4a: ldc_w 261394525
      // 4d: ldc_w 264335266
      // 50: ixor
      // 51: ireturn
      // 52: ldc_w 264357128
      // 55: ldc_w 264335266
      // 58: ixor
      // 59: ireturn
      // 5a: ldc_w 258699016
      // 5d: ldc_w 264335266
      // 60: ixor
      // 61: ireturn
      // 62: ldc_w 255772066
      // 65: ldc_w 264335266
      // 68: ixor
      // 69: ireturn
      // 6a: ldc_w 255736413
      // 6d: ldc_w 264335266
      // 70: ixor
      // 71: ireturn
      // 72: iload 0
      // 73: iload 1
      // 74: ifne 90
      // 77: ldc_w 264335271
      // 7a: ldc_w 264335266
      // 7d: ixor
      // 7e: if_icmple 93
      // 81: goto 85
      // 84: athrow
      // 85: ldc_w 255736413
      // 88: ldc_w 264335266
      // 8b: ixor
      // 8c: goto 90
      // 8f: athrow
      // 90: goto 9a
      // 93: ldc_w 255758429
      // 96: ldc_w 264335266
      // 99: ixor
      // 9a: ireturn
   }

   public static int ğ(FontRenderer var0, String var1, int var2, int var3, int var4) {
      int var5 = var0.drawStringWithShadow(var1, var3, var4, -508347072 ^ -515063105);
      var0.drawStringWithShadow(String.valueOf(var2), var5, var4, ɓ(var2));
      return var5;
   }

   public static void Ԑ() {
      GlStateManager.disableLighting();
      GlStateManager.disableDepth();
      GlStateManager.depthMask(false);
      GlStateManager.enableTexture2D();
      GlStateManager.enableAlpha();
      GlStateManager.alphaFunc(1418785456 ^ 1418784948, 0.1F);
      GlStateManager.enableBlend();
      GlStateManager.tryBlendFuncSeparate(1418785718 ^ 1418784948, 1418785719 ^ 1418784948, 1, 0);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void S() {
      GlStateManager.disableLighting();
      GlStateManager.enableTexture2D();
      GlStateManager.enableAlpha();
      GlStateManager.alphaFunc(-1299967051 ^ -1299967567, 0.1F);
      GlStateManager.enableBlend();
      GlStateManager.tryBlendFuncSeparate(-1299967309 ^ -1299967567, -1299967310 ^ -1299967567, 1, 0);
      GlStateManager.enableDepth();
      GlStateManager.depthMask(true);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static String ď(int var0) {
      try {
         switch (var0) {
            case 0:
               return "pt";
            case 1:
               return "frp";
            case 2:
               return "ff";
            case 3:
               return "blp";
            case 4:
               return "prp";
            case 5:
               return "thr";
            case 6:
               return "res";
            case 7:
               return "aa";
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            default:
               return null;
            case 16:
               return "sh";
            case 17:
               return "smt";
            case 18:
               return "ban";
            case 19:
               return "kb";
            case 20:
               return "fa";
            case 21:
               return "lot";
            case 32:
               return "eff";
            case 33:
               return "sil";
            case 34:
               return "ub";
            case 35:
               return "for";
            case 48:
               return "pow";
            case 49:
               return "pun";
            case 50:
               return "flm";
            case 51:
               return "inf";
         }
      } catch (IllegalStateException var1) {
         throw var1;
      }
   }

   public static ResourceLocation ι(String param0, String param1, ResourceLocation param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 3
      // 004: ldc_w x/oc2cf3d80e17
      // 007: aload 0
      // 008: invokevirtual java/lang/Class.getResourceAsStream (Ljava/lang/String;)Ljava/io/InputStream;
      // 00b: astore 4
      // 00d: aload 4
      // 00f: iload 3
      // 010: ifne 034
      // 013: ifnonnull 032
      // 016: goto 01a
      // 019: athrow
      // 01a: aload 2
      // 01b: astore 5
      // 01d: aload 4
      // 01f: iload 3
      // 020: ifne 02c
      // 023: ifnull 02f
      // 026: goto 02a
      // 029: athrow
      // 02a: aload 4
      // 02c: invokevirtual java/io/InputStream.close ()V
      // 02f: aload 5
      // 031: areturn
      // 032: aload 4
      // 034: invokestatic javax/imageio/ImageIO.read (Ljava/io/InputStream;)Ljava/awt/image/BufferedImage;
      // 037: astore 5
      // 039: aload 5
      // 03b: invokevirtual java/awt/image/BufferedImage.getWidth ()I
      // 03e: istore 6
      // 040: aload 5
      // 042: invokevirtual java/awt/image/BufferedImage.getHeight ()I
      // 045: istore 7
      // 047: new java/awt/image/BufferedImage
      // 04a: dup
      // 04b: iload 6
      // 04d: iload 7
      // 04f: ldc_w 366667078
      // 052: ldc_w 366667076
      // 055: ixor
      // 056: invokespecial java/awt/image/BufferedImage.<init> (III)V
      // 059: astore 8
      // 05b: bipush 0
      // 05c: istore 9
      // 05e: iload 9
      // 060: iload 7
      // 062: if_icmpge 0c8
      // 065: bipush 0
      // 066: istore 10
      // 068: iload 10
      // 06a: iload 6
      // 06c: if_icmpge 0c1
      // 06f: aload 5
      // 071: iload 10
      // 073: iload 9
      // 075: invokevirtual java/awt/image/BufferedImage.getRGB (II)I
      // 078: ldc_w 366667100
      // 07b: ldc_w 366667076
      // 07e: ixor
      // 07f: iushr
      // 080: ldc_w 366667195
      // 083: ldc_w 366667076
      // 086: ixor
      // 087: iload 3
      // 088: ifne 062
      // 08b: iand
      // 08c: istore 11
      // 08e: iload 3
      // 08f: ifne 0bd
      // 092: iload 11
      // 094: ifle 0ba
      // 097: goto 09b
      // 09a: athrow
      // 09b: aload 8
      // 09d: iload 10
      // 09f: iload 9
      // 0a1: iload 11
      // 0a3: ldc_w 366667100
      // 0a6: ldc_w 366667076
      // 0a9: ixor
      // 0aa: ishl
      // 0ab: ldc_w 354753211
      // 0ae: ldc_w 366667076
      // 0b1: ixor
      // 0b2: ior
      // 0b3: invokevirtual java/awt/image/BufferedImage.setRGB (III)V
      // 0b6: goto 0ba
      // 0b9: athrow
      // 0ba: iinc 10 1
      // 0bd: iload 3
      // 0be: ifeq 068
      // 0c1: iinc 9 1
      // 0c4: iload 3
      // 0c5: ifeq 05e
      // 0c8: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 0cb: invokevirtual net/minecraft/client/Minecraft.getTextureManager ()Lnet/minecraft/client/renderer/texture/TextureManager;
      // 0ce: aload 1
      // 0cf: new net/minecraft/client/renderer/texture/DynamicTexture
      // 0d2: dup
      // 0d3: aload 8
      // 0d5: invokespecial net/minecraft/client/renderer/texture/DynamicTexture.<init> (Ljava/awt/image/BufferedImage;)V
      // 0d8: invokevirtual net/minecraft/client/renderer/texture/TextureManager.getDynamicTextureLocation (Ljava/lang/String;Lnet/minecraft/client/renderer/texture/DynamicTexture;)Lnet/minecraft/util/ResourceLocation;
      // 0db: astore 9
      // 0dd: aload 4
      // 0df: iload 3
      // 0e0: ifne 0ec
      // 0e3: ifnull 0ef
      // 0e6: goto 0ea
      // 0e9: athrow
      // 0ea: aload 4
      // 0ec: invokevirtual java/io/InputStream.close ()V
      // 0ef: aload 9
      // 0f1: areturn
      // 0f2: astore 5
      // 0f4: iload 3
      // 0f5: ifne 106
      // 0f8: aload 4
      // 0fa: ifnull 112
      // 0fd: goto 101
      // 100: athrow
      // 101: aload 4
      // 103: invokevirtual java/io/InputStream.close ()V
      // 106: goto 112
      // 109: astore 6
      // 10b: aload 5
      // 10d: aload 6
      // 10f: invokevirtual java/lang/Throwable.addSuppressed (Ljava/lang/Throwable;)V
      // 112: aload 5
      // 114: athrow
      // 115: astore 4
      // 117: aload 4
      // 119: invokevirtual java/lang/Exception.printStackTrace ()V
      // 11c: aload 2
      // 11d: areturn
   }

   public static ResourceLocation ʸ(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: getstatic x/ocbd4917c4b1.ɻ Ljava/util/Map;
      // 06: aload 0
      // 07: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 0c: checkcast net/minecraft/util/ResourceLocation
      // 0f: astore 2
      // 10: istore 1
      // 11: aload 2
      // 12: iload 1
      // 13: ifne 1e
      // 16: ifnull 1f
      // 19: goto 1d
      // 1c: athrow
      // 1d: aload 2
      // 1e: areturn
      // 1f: aload 0
      // 20: invokevirtual java/lang/String.hashCode ()I
      // 23: ldc_w "raven_icon_"
      // 26: swap
      // 27: invokedynamic makeConcatWithConstants (Ljava/lang/String;I)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 2c: astore 3
      // 2d: aload 0
      // 2e: aload 3
      // 2f: aconst_null
      // 30: invokestatic x/ocbd4917c4b1.ι (Ljava/lang/String;Ljava/lang/String;Lnet/minecraft/util/ResourceLocation;)Lnet/minecraft/util/ResourceLocation;
      // 33: astore 4
      // 35: aload 4
      // 37: iload 1
      // 38: ifne 54
      // 3b: ifnull 52
      // 3e: goto 42
      // 41: athrow
      // 42: getstatic x/ocbd4917c4b1.ɻ Ljava/util/Map;
      // 45: aload 0
      // 46: aload 4
      // 48: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 4d: pop
      // 4e: goto 52
      // 51: athrow
      // 52: aload 4
      // 54: areturn
   }

   public static void ì(ResourceLocation var0, float var1, float var2, int var3, int var4) {
      try {
         if (var0 == null) {
            return;
         }
      } catch (IllegalStateException var12) {
         throw var12;
      }

      boolean var5 = GL11.glIsEnabled(-1273588045 ^ -1273586238);
      boolean var6 = GL11.glIsEnabled(-1273588192 ^ -1273586238);
      boolean var7 = GL11.glGetBoolean(-1273588048 ^ -1273586238);
      Ԑ();
      ocda171fe5d8.ǔ.getTextureManager().bindTexture(var0);
      float var8 = (var4 >>> (-1273586214 ^ -1273586238) & (-1273586371 ^ -1273586238)) / 255.0F;
      float var9 = (var4 >> (-1273586222 ^ -1273586238) & (-1273586371 ^ -1273586238)) / 255.0F;
      float var10 = (var4 >> (-1273586230 ^ -1273586238) & (-1273586371 ^ -1273586238)) / 255.0F;
      float var11 = (var4 & (-1273586371 ^ -1273586238)) / 255.0F;
      GlStateManager.color(var9, var10, var11, var8);
      GL11.glPushMatrix();
      GL11.glTranslatef(var1, var2, 0.0F);
      Gui.drawModalRectWithCustomSizedTexture(0, 0, 0.0F, 0.0F, var3, var3, var3, var3);
      GL11.glPopMatrix();
      Ӿ(var5, var6, var7);
   }

   public static void Ӿ(boolean param0, boolean param1, boolean param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 3
      // 04: iload 3
      // 05: fconst_1
      // 06: fconst_1
      // 07: fconst_1
      // 08: fconst_1
      // 09: invokestatic net/minecraft/client/renderer/GlStateManager.color (FFFF)V
      // 0c: ifne 1e
      // 0f: iload 1
      // 10: ifeq 22
      // 13: goto 17
      // 16: athrow
      // 17: invokestatic net/minecraft/client/renderer/GlStateManager.enableBlend ()V
      // 1a: goto 1e
      // 1d: athrow
      // 1e: iload 3
      // 1f: ifeq 29
      // 22: invokestatic net/minecraft/client/renderer/GlStateManager.disableBlend ()V
      // 25: goto 29
      // 28: athrow
      // 29: iload 0
      // 2a: ifeq 38
      // 2d: invokestatic net/minecraft/client/renderer/GlStateManager.enableDepth ()V
      // 30: iload 3
      // 31: ifeq 3f
      // 34: goto 38
      // 37: athrow
      // 38: invokestatic net/minecraft/client/renderer/GlStateManager.disableDepth ()V
      // 3b: goto 3f
      // 3e: athrow
      // 3f: iload 2
      // 40: invokestatic net/minecraft/client/renderer/GlStateManager.depthMask (Z)V
      // 43: return
   }

   public static void ʅ(AxisAlignedBB var0, int var1, int var2, int var3) {
      ϴ(var0, var1, var2, var3, 1578270810 ^ 1578270821);
   }

   public static void ϴ(AxisAlignedBB var0, int var1, int var2, int var3, int var4) {
      var4 = Math.max(0, Math.min(787692561 ^ 787692782, var4));
      Tessellator var6 = Tessellator.getInstance();
      WorldRenderer var7 = var6.getWorldRenderer();
      var7.begin(787692777 ^ 787692782, DefaultVertexFormats.POSITION_COLOR);
      var7.pos(var0.minX, var0.minY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      var7.pos(var0.minX, var0.minY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      var7.pos(var0.maxX, var0.minY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
      int var10000 = oc75d51ec7eb.ϩ;
      var7.pos(var0.maxX, var0.minY, var0.minZ).color(var1, var2, var3, var4).endVertex();
      int var5 = var10000;

      try {
         var7.pos(var0.minX, var0.maxY, var0.minZ).color(var1, var2, var3, var4).endVertex();
         var7.pos(var0.minX, var0.maxY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
         var7.pos(var0.maxX, var0.maxY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
         var7.pos(var0.maxX, var0.maxY, var0.minZ).color(var1, var2, var3, var4).endVertex();
         var7.pos(var0.minX, var0.minY, var0.minZ).color(var1, var2, var3, var4).endVertex();
         var7.pos(var0.minX, var0.maxY, var0.minZ).color(var1, var2, var3, var4).endVertex();
         var7.pos(var0.maxX, var0.maxY, var0.minZ).color(var1, var2, var3, var4).endVertex();
         var7.pos(var0.maxX, var0.minY, var0.minZ).color(var1, var2, var3, var4).endVertex();
         var7.pos(var0.minX, var0.minY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
         var7.pos(var0.minX, var0.maxY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
         var7.pos(var0.maxX, var0.maxY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
         var7.pos(var0.maxX, var0.minY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
         var7.pos(var0.minX, var0.minY, var0.minZ).color(var1, var2, var3, var4).endVertex();
         var7.pos(var0.minX, var0.maxY, var0.minZ).color(var1, var2, var3, var4).endVertex();
         var7.pos(var0.minX, var0.maxY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
         var7.pos(var0.minX, var0.minY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
         var7.pos(var0.maxX, var0.minY, var0.minZ).color(var1, var2, var3, var4).endVertex();
         var7.pos(var0.maxX, var0.maxY, var0.minZ).color(var1, var2, var3, var4).endVertex();
         var7.pos(var0.maxX, var0.maxY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
         var7.pos(var0.maxX, var0.minY, var0.maxZ).color(var1, var2, var3, var4).endVertex();
         var6.draw();
         if (false) {
            oc75d51ec7eb.ϩ = ++var5;
         }
      } catch (IllegalStateException var8) {
         throw var8;
      }
   }

   public static void Є() {
      GlStateManager.enableBlend();
      GlStateManager.blendFunc(-626621824 ^ -626622078, -626621823 ^ -626622078);
      GlStateManager.disableTexture2D();
      GlStateManager.disableCull();
      GlStateManager.disableAlpha();
      GlStateManager.disableDepth();
   }

   public static void Ӌ() {
      GlStateManager.enableDepth();
      GlStateManager.enableAlpha();
      GlStateManager.enableCull();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
   }

   public static double ķ(double var0, double var2, double var4) {
      return var2 + (var0 - var2) * var4;
   }
}

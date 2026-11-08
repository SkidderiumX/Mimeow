package x;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.shader.Framebuffer;
import org.lwjgl.opengl.GL11;

public class ocad35595dfa implements ocda171fe5d8 {
   public static oc595c51c58f Е = new oc595c51c58f("kawaseDownBloom");
   public static oc595c51c58f Ҋ = new oc595c51c58f("kawaseUpBloom");
   public static Framebuffer ƕ = new Framebuffer(1, 1, false);
   private static int Υ;
   private static final List<Framebuffer> հ = new ArrayList<>();
   public static boolean ɵ;

   private static void ʜ(float var0) {
      boolean var10000 = oc1b46ea259e.ǧ;
      Iterator var2 = հ.iterator();
      boolean var1 = var10000;

      while (true) {
         if (var2.hasNext()) {
            Framebuffer var3 = (Framebuffer)var2.next();

            try {
               if (var1) {
                  break;
               }

               var3.deleteFramebuffer();
               if (!var1) {
                  continue;
               }
            } catch (ocbde1165e4e var6) {
               throw var6;
            }
         }

         հ.clear();
         հ.add(ƕ = ocbd4917c4b1.ɓ(null, false));
         break;
      }

      int var7 = 1;

      while (var7 <= var0) {
         int var8 = Math.max(1, (int)(ocda171fe5d8.ǔ.displayWidth / Math.pow(2.0, var7)));
         int var4 = Math.max(1, (int)(ocda171fe5d8.ǔ.displayHeight / Math.pow(2.0, var7)));
         Framebuffer var5 = new Framebuffer(var8, var4, false);
         var5.setFramebufferFilter(2079955205 ^ 2079964932);
         GlStateManager.bindTexture(var5.framebufferTexture);
         GL11.glTexParameteri(2079961829 ^ 2079964932, 2079954694 ^ 2079964932, 2079931508 ^ 2079964932);
         GL11.glTexParameteri(2079961829 ^ 2079964932, 2079954695 ^ 2079964932, 2079931508 ^ 2079964932);
         GlStateManager.bindTexture(0);
         հ.add(var5);
         var7++;
         if (var1) {
            break;
         }
      }
   }

   public static void ԥ(int param0, int param1, float param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: getstatic x/oc1b46ea259e.ǧ Z
      // 003: istore 3
      // 004: iload 1
      // 005: bipush 1
      // 006: if_icmpge 015
      // 009: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 00c: invokevirtual net/minecraft/client/Minecraft.getFramebuffer ()Lnet/minecraft/client/shader/Framebuffer;
      // 00f: bipush 1
      // 010: invokevirtual net/minecraft/client/shader/Framebuffer.bindFramebuffer (Z)V
      // 013: return
      // 014: athrow
      // 015: new net/minecraft/client/gui/ScaledResolution
      // 018: dup
      // 019: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 01c: invokespecial net/minecraft/client/gui/ScaledResolution.<init> (Lnet/minecraft/client/Minecraft;)V
      // 01f: astore 4
      // 021: invokestatic net/minecraft/client/renderer/GlStateManager.pushMatrix ()V
      // 024: invokestatic net/minecraft/client/renderer/GlStateManager.loadIdentity ()V
      // 027: ldc 1338047680
      // 029: ldc 1338043329
      // 02b: ixor
      // 02c: iload 3
      // 02d: ifne 0a0
      // 030: invokestatic net/minecraft/client/renderer/GlStateManager.matrixMode (I)V
      // 033: invokestatic net/minecraft/client/renderer/GlStateManager.pushMatrix ()V
      // 036: invokestatic net/minecraft/client/renderer/GlStateManager.loadIdentity ()V
      // 039: dconst_0
      // 03a: aload 4
      // 03c: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledWidth_double ()D
      // 03f: aload 4
      // 041: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledHeight_double ()D
      // 044: dconst_0
      // 045: ldc2_w 1000.0
      // 048: ldc2_w 3000.0
      // 04b: invokestatic net/minecraft/client/renderer/GlStateManager.ortho (DDDDDD)V
      // 04e: ldc 1338047681
      // 050: ldc 1338043329
      // 052: ixor
      // 053: invokestatic net/minecraft/client/renderer/GlStateManager.matrixMode (I)V
      // 056: fconst_0
      // 057: fconst_0
      // 058: ldc -2000.0
      // 05a: invokestatic net/minecraft/client/renderer/GlStateManager.translate (FFF)V
      // 05d: getstatic x/ocad35595dfa.Υ I
      // 060: iload 1
      // 061: if_icmpne 096
      // 064: getstatic x/ocad35595dfa.ƕ Lnet/minecraft/client/shader/Framebuffer;
      // 067: getfield net/minecraft/client/shader/Framebuffer.framebufferWidth I
      // 06a: iload 3
      // 06b: ifne 0a0
      // 06e: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 071: getfield net/minecraft/client/Minecraft.displayWidth I
      // 074: if_icmpne 096
      // 077: goto 07b
      // 07a: athrow
      // 07b: getstatic x/ocad35595dfa.ƕ Lnet/minecraft/client/shader/Framebuffer;
      // 07e: getfield net/minecraft/client/shader/Framebuffer.framebufferHeight I
      // 081: iload 3
      // 082: ifne 0b2
      // 085: goto 089
      // 088: athrow
      // 089: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 08c: getfield net/minecraft/client/Minecraft.displayHeight I
      // 08f: if_icmpeq 0a3
      // 092: goto 096
      // 095: athrow
      // 096: iload 1
      // 097: i2f
      // 098: invokestatic x/ocad35595dfa.ʜ (F)V
      // 09b: iload 1
      // 09c: goto 0a0
      // 09f: athrow
      // 0a0: putstatic x/ocad35595dfa.Υ I
      // 0a3: invokestatic net/minecraft/client/renderer/GlStateManager.disableDepth ()V
      // 0a6: bipush 0
      // 0a7: invokestatic net/minecraft/client/renderer/GlStateManager.depthMask (Z)V
      // 0aa: fconst_0
      // 0ab: invokestatic x/ocbd4917c4b1.В (F)V
      // 0ae: invokestatic net/minecraft/client/renderer/GlStateManager.enableBlend ()V
      // 0b1: bipush 1
      // 0b2: bipush 1
      // 0b3: invokestatic net/minecraft/client/renderer/GlStateManager.blendFunc (II)V
      // 0b6: fconst_0
      // 0b7: fconst_0
      // 0b8: fconst_0
      // 0b9: fconst_0
      // 0ba: invokestatic org/lwjgl/opengl/GL11.glClearColor (FFFF)V
      // 0bd: fload 2
      // 0be: fstore 5
      // 0c0: getstatic x/ocad35595dfa.հ Ljava/util/List;
      // 0c3: bipush 1
      // 0c4: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 0c9: checkcast net/minecraft/client/shader/Framebuffer
      // 0cc: iload 0
      // 0cd: getstatic x/ocad35595dfa.Е Lx/oc595c51c58f;
      // 0d0: fload 5
      // 0d2: invokestatic x/ocad35595dfa.ք (Lnet/minecraft/client/shader/Framebuffer;ILx/oc595c51c58f;F)V
      // 0d5: bipush 1
      // 0d6: istore 6
      // 0d8: iload 6
      // 0da: iload 1
      // 0db: if_icmpge 122
      // 0de: fload 2
      // 0df: ldc2_w 1.5
      // 0e2: iload 6
      // 0e4: i2d
      // 0e5: invokestatic java/lang/Math.pow (DD)D
      // 0e8: d2f
      // 0e9: fdiv
      // 0ea: fstore 5
      // 0ec: getstatic x/ocad35595dfa.հ Ljava/util/List;
      // 0ef: iload 6
      // 0f1: bipush 1
      // 0f2: iload 3
      // 0f3: ifne 141
      // 0f6: iadd
      // 0f7: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 0fc: checkcast net/minecraft/client/shader/Framebuffer
      // 0ff: getstatic x/ocad35595dfa.հ Ljava/util/List;
      // 102: iload 6
      // 104: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 109: checkcast net/minecraft/client/shader/Framebuffer
      // 10c: getfield net/minecraft/client/shader/Framebuffer.framebufferTexture I
      // 10f: getstatic x/ocad35595dfa.Е Lx/oc595c51c58f;
      // 112: fload 5
      // 114: invokestatic x/ocad35595dfa.ք (Lnet/minecraft/client/shader/Framebuffer;ILx/oc595c51c58f;F)V
      // 117: iload 3
      // 118: iinc 6 1
      // 11b: ifeq 0d8
      // 11e: goto 122
      // 121: athrow
      // 122: iload 1
      // 123: istore 6
      // 125: iload 6
      // 127: bipush 1
      // 128: if_icmple 171
      // 12b: fload 2
      // 12c: ldc2_w 1.5
      // 12f: iload 6
      // 131: bipush 1
      // 132: isub
      // 133: i2d
      // 134: invokestatic java/lang/Math.pow (DD)D
      // 137: d2f
      // 138: fdiv
      // 139: fstore 5
      // 13b: getstatic x/ocad35595dfa.հ Ljava/util/List;
      // 13e: iload 6
      // 140: bipush 1
      // 141: isub
      // 142: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 147: iload 3
      // 148: ifne 17a
      // 14b: checkcast net/minecraft/client/shader/Framebuffer
      // 14e: getstatic x/ocad35595dfa.հ Ljava/util/List;
      // 151: iload 6
      // 153: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 158: checkcast net/minecraft/client/shader/Framebuffer
      // 15b: getfield net/minecraft/client/shader/Framebuffer.framebufferTexture I
      // 15e: getstatic x/ocad35595dfa.Ҋ Lx/oc595c51c58f;
      // 161: fload 5
      // 163: invokestatic x/ocad35595dfa.ք (Lnet/minecraft/client/shader/Framebuffer;ILx/oc595c51c58f;F)V
      // 166: iload 3
      // 167: iinc 6 -1
      // 16a: ifeq 125
      // 16d: goto 171
      // 170: athrow
      // 171: getstatic x/ocad35595dfa.հ Ljava/util/List;
      // 174: bipush 0
      // 175: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 17a: checkcast net/minecraft/client/shader/Framebuffer
      // 17d: astore 6
      // 17f: aload 6
      // 181: invokevirtual net/minecraft/client/shader/Framebuffer.framebufferClear ()V
      // 184: aload 6
      // 186: bipush 1
      // 187: invokevirtual net/minecraft/client/shader/Framebuffer.bindFramebuffer (Z)V
      // 18a: getstatic x/ocad35595dfa.Ҋ Lx/oc595c51c58f;
      // 18d: invokevirtual x/oc595c51c58f.ǵ ()V
      // 190: getstatic x/ocad35595dfa.Ҋ Lx/oc595c51c58f;
      // 193: ldc "offset"
      // 195: ldc 1338043331
      // 197: ldc 1338043329
      // 199: ixor
      // 19a: newarray 6
      // 19c: dup
      // 19d: bipush 0
      // 19e: fload 2
      // 19f: fastore
      // 1a0: dup
      // 1a1: bipush 1
      // 1a2: fload 2
      // 1a3: fastore
      // 1a4: invokevirtual x/oc595c51c58f.ψ (Ljava/lang/String;[F)V
      // 1a7: getstatic x/ocad35595dfa.Ҋ Lx/oc595c51c58f;
      // 1aa: ldc "inTexture"
      // 1ac: bipush 1
      // 1ad: newarray 10
      // 1af: dup
      // 1b0: bipush 0
      // 1b1: bipush 0
      // 1b2: iastore
      // 1b3: invokevirtual x/oc595c51c58f.ҏ (Ljava/lang/String;[I)V
      // 1b6: getstatic x/ocad35595dfa.Ҋ Lx/oc595c51c58f;
      // 1b9: ldc "check"
      // 1bb: bipush 1
      // 1bc: newarray 10
      // 1be: dup
      // 1bf: bipush 0
      // 1c0: bipush 1
      // 1c1: iastore
      // 1c2: invokevirtual x/oc595c51c58f.ҏ (Ljava/lang/String;[I)V
      // 1c5: getstatic x/ocad35595dfa.Ҋ Lx/oc595c51c58f;
      // 1c8: ldc "textureToCheck"
      // 1ca: bipush 1
      // 1cb: newarray 10
      // 1cd: dup
      // 1ce: bipush 0
      // 1cf: bipush 1
      // 1d0: iastore
      // 1d1: invokevirtual x/oc595c51c58f.ҏ (Ljava/lang/String;[I)V
      // 1d4: getstatic x/ocad35595dfa.Ҋ Lx/oc595c51c58f;
      // 1d7: ldc "halfpixel"
      // 1d9: ldc 1338043331
      // 1db: ldc 1338043329
      // 1dd: ixor
      // 1de: newarray 6
      // 1e0: dup
      // 1e1: bipush 0
      // 1e2: fconst_1
      // 1e3: aload 6
      // 1e5: getfield net/minecraft/client/shader/Framebuffer.framebufferWidth I
      // 1e8: i2f
      // 1e9: fdiv
      // 1ea: fastore
      // 1eb: dup
      // 1ec: bipush 1
      // 1ed: fconst_1
      // 1ee: aload 6
      // 1f0: getfield net/minecraft/client/shader/Framebuffer.framebufferHeight I
      // 1f3: i2f
      // 1f4: fdiv
      // 1f5: fastore
      // 1f6: invokevirtual x/oc595c51c58f.ψ (Ljava/lang/String;[F)V
      // 1f9: getstatic x/ocad35595dfa.Ҋ Lx/oc595c51c58f;
      // 1fc: ldc "iResolution"
      // 1fe: ldc 1338043331
      // 200: ldc 1338043329
      // 202: ixor
      // 203: newarray 6
      // 205: dup
      // 206: bipush 0
      // 207: aload 6
      // 209: getfield net/minecraft/client/shader/Framebuffer.framebufferWidth I
      // 20c: i2f
      // 20d: fastore
      // 20e: dup
      // 20f: bipush 1
      // 210: aload 6
      // 212: getfield net/minecraft/client/shader/Framebuffer.framebufferHeight I
      // 215: i2f
      // 216: fastore
      // 217: invokevirtual x/oc595c51c58f.ψ (Ljava/lang/String;[F)V
      // 21a: ldc 1338011392
      // 21c: ldc 1338043329
      // 21e: ixor
      // 21f: invokestatic net/minecraft/client/renderer/GlStateManager.setActiveTexture (I)V
      // 222: iload 0
      // 223: invokestatic x/ocbd4917c4b1.ã (I)V
      // 226: ldc 1338011393
      // 228: ldc 1338043329
      // 22a: ixor
      // 22b: invokestatic net/minecraft/client/renderer/GlStateManager.setActiveTexture (I)V
      // 22e: getstatic x/ocad35595dfa.հ Ljava/util/List;
      // 231: bipush 1
      // 232: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 237: checkcast net/minecraft/client/shader/Framebuffer
      // 23a: getfield net/minecraft/client/shader/Framebuffer.framebufferTexture I
      // 23d: invokestatic x/ocbd4917c4b1.ã (I)V
      // 240: invokestatic x/oc595c51c58f.ư ()V
      // 243: getstatic x/ocad35595dfa.Ҋ Lx/oc595c51c58f;
      // 246: invokevirtual x/oc595c51c58f.ʇ ()V
      // 249: ldc 1338011392
      // 24b: ldc 1338043329
      // 24d: ixor
      // 24e: invokestatic net/minecraft/client/renderer/GlStateManager.setActiveTexture (I)V
      // 251: bipush 0
      // 252: invokestatic net/minecraft/client/renderer/GlStateManager.bindTexture (I)V
      // 255: ldc 1338011393
      // 257: ldc 1338043329
      // 259: ixor
      // 25a: invokestatic net/minecraft/client/renderer/GlStateManager.setActiveTexture (I)V
      // 25d: fconst_0
      // 25e: fconst_0
      // 25f: fconst_0
      // 260: fconst_0
      // 261: invokestatic net/minecraft/client/renderer/GlStateManager.clearColor (FFFF)V
      // 264: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 267: invokevirtual net/minecraft/client/Minecraft.getFramebuffer ()Lnet/minecraft/client/shader/Framebuffer;
      // 26a: bipush 0
      // 26b: invokevirtual net/minecraft/client/shader/Framebuffer.bindFramebuffer (Z)V
      // 26e: getstatic x/ocad35595dfa.հ Ljava/util/List;
      // 271: bipush 0
      // 272: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 277: checkcast net/minecraft/client/shader/Framebuffer
      // 27a: getfield net/minecraft/client/shader/Framebuffer.framebufferTexture I
      // 27d: invokestatic x/ocbd4917c4b1.ã (I)V
      // 280: fconst_0
      // 281: invokestatic x/ocbd4917c4b1.В (F)V
      // 284: invokestatic net/minecraft/client/renderer/GlStateManager.enableBlend ()V
      // 287: ldc_w 1338042563
      // 28a: ldc 1338043329
      // 28c: ixor
      // 28d: ldc_w 1338042562
      // 290: ldc 1338043329
      // 292: ixor
      // 293: invokestatic net/minecraft/client/renderer/GlStateManager.blendFunc (II)V
      // 296: invokestatic x/ocbd4917c4b1.Ԃ ()V
      // 299: invokestatic x/oc595c51c58f.ư ()V
      // 29c: bipush 0
      // 29d: invokestatic net/minecraft/client/renderer/GlStateManager.bindTexture (I)V
      // 2a0: fconst_0
      // 2a1: invokestatic x/ocbd4917c4b1.В (F)V
      // 2a4: invokestatic net/minecraft/client/renderer/GlStateManager.enableBlend ()V
      // 2a7: ldc_w 1338042563
      // 2aa: ldc 1338043329
      // 2ac: ixor
      // 2ad: ldc_w 1338042562
      // 2b0: ldc 1338043329
      // 2b2: ixor
      // 2b3: invokestatic net/minecraft/client/renderer/GlStateManager.blendFunc (II)V
      // 2b6: ldc 1338047680
      // 2b8: ldc 1338043329
      // 2ba: ixor
      // 2bb: invokestatic net/minecraft/client/renderer/GlStateManager.matrixMode (I)V
      // 2be: invokestatic net/minecraft/client/renderer/GlStateManager.popMatrix ()V
      // 2c1: ldc 1338047681
      // 2c3: ldc 1338043329
      // 2c5: ixor
      // 2c6: invokestatic net/minecraft/client/renderer/GlStateManager.matrixMode (I)V
      // 2c9: invokestatic net/minecraft/client/renderer/GlStateManager.popMatrix ()V
      // 2cc: goto 2ea
      // 2cf: astore 7
      // 2d1: ldc 1338047680
      // 2d3: ldc 1338043329
      // 2d5: ixor
      // 2d6: invokestatic net/minecraft/client/renderer/GlStateManager.matrixMode (I)V
      // 2d9: invokestatic net/minecraft/client/renderer/GlStateManager.popMatrix ()V
      // 2dc: ldc 1338047681
      // 2de: ldc 1338043329
      // 2e0: ixor
      // 2e1: invokestatic net/minecraft/client/renderer/GlStateManager.matrixMode (I)V
      // 2e4: invokestatic net/minecraft/client/renderer/GlStateManager.popMatrix ()V
      // 2e7: aload 7
      // 2e9: athrow
      // 2ea: return
   }

   private static void ք(Framebuffer var0, int var1, oc595c51c58f var2, float var3) {
      var0.framebufferClear();
      var0.bindFramebuffer(true);
      var2.ǵ();
      ocbd4917c4b1.ã(var1);
      float[] var10002 = new float[1034933142 ^ 1034933140];
      var10002[0] = var3;
      var10002[1] = var3;
      var2.ψ("offset", var10002);
      var2.ҏ("inTexture", 0);
      var2.ҏ("check", 0);
      var10002 = new float[1034933142 ^ 1034933140];
      var10002[0] = 1.0F / var0.framebufferWidth;
      var10002[1] = 1.0F / var0.framebufferHeight;
      var2.ψ("halfpixel", var10002);
      var10002 = new float[1034933142 ^ 1034933140];
      var10002[0] = var0.framebufferWidth;
      var10002[1] = var0.framebufferHeight;
      var2.ψ("iResolution", var10002);
      oc595c51c58f.ư();
      var2.ʇ();
   }
}

package x;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.shader.Framebuffer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.GL11;

public class ocf1019b83a2 {
   private static final Logger ǫ = LogManager.getLogger(ocf1019b83a2.class);
   private static final Minecraft Ҙ = Minecraft.getMinecraft();
   private static oc595c51c58f Р;
   private static oc595c51c58f ѿ;
   private static Framebuffer Ɗ;
   private static int Я = -1;
   private static boolean ı;
   private static final List<Framebuffer> Ͷ = new ArrayList<>();
   public static boolean D;

   private static void Ĝ(float var0) {
      boolean var10000 = oc1b46ea259e.ǧ;
      Iterator var2 = Ͷ.iterator();
      boolean var1 = var10000;

      while (true) {
         if (var2.hasNext()) {
            Framebuffer var3 = (Framebuffer)var2.next();

            try {
               var3.deleteFramebuffer();
               if (var1) {
                  break;
               }

               if (!var1) {
                  continue;
               }
            } catch (RuntimeException var6) {
               throw var6;
            }
         }

         Ͷ.clear();
         Ͷ.add(Ɗ = ocbd4917c4b1.τ(null));
         break;
      }

      int var7 = 1;

      while (var7 <= var0) {
         int var8 = Math.max(1, (int)(Ҙ.displayWidth / Math.pow(3.0, var7)));
         int var4 = Math.max(1, (int)(Ҙ.displayHeight / Math.pow(3.0, var7)));
         Framebuffer var5 = new Framebuffer(var8, var4, false);
         var5.setFramebufferFilter(669713724 ^ 669721405);
         GlStateManager.bindTexture(var5.framebufferTexture);
         GL11.glTexParameteri(669724380 ^ 669721405, 669715263 ^ 669721405, 669753421 ^ 669721405);
         GL11.glTexParameteri(669724380 ^ 669721405, 669715262 ^ 669721405, 669753421 ^ 669721405);
         GlStateManager.bindTexture(0);
         Ͷ.add(var5);
         var7++;
         if (var1) {
            break;
         }
      }
   }

   public static boolean ί(int param0, int param1, float param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: getstatic x/oc1b46ea259e.ǧ Z
      // 003: istore 3
      // 004: invokestatic x/ocf1019b83a2.Ͼ ()Z
      // 007: iload 3
      // 008: ifne 016
      // 00b: ifne 015
      // 00e: goto 012
      // 011: athrow
      // 012: bipush 0
      // 013: ireturn
      // 014: athrow
      // 015: iload 1
      // 016: iload 3
      // 017: ifne 031
      // 01a: bipush 1
      // 01b: if_icmpge 032
      // 01e: goto 022
      // 021: athrow
      // 022: getstatic x/ocf1019b83a2.Ҙ Lnet/minecraft/client/Minecraft;
      // 025: invokevirtual net/minecraft/client/Minecraft.getFramebuffer ()Lnet/minecraft/client/shader/Framebuffer;
      // 028: bipush 1
      // 029: invokevirtual net/minecraft/client/shader/Framebuffer.bindFramebuffer (Z)V
      // 02c: bipush 1
      // 02d: goto 031
      // 030: athrow
      // 031: ireturn
      // 032: invokestatic net/minecraft/client/renderer/GlStateManager.pushMatrix ()V
      // 035: invokestatic net/minecraft/client/renderer/GlStateManager.loadIdentity ()V
      // 038: new net/minecraft/client/gui/ScaledResolution
      // 03b: dup
      // 03c: getstatic x/ocf1019b83a2.Ҙ Lnet/minecraft/client/Minecraft;
      // 03f: invokespecial net/minecraft/client/gui/ScaledResolution.<init> (Lnet/minecraft/client/Minecraft;)V
      // 042: astore 4
      // 044: ldc -260296747
      // 046: ldc -260294444
      // 048: ixor
      // 049: iload 3
      // 04a: ifne 0bd
      // 04d: invokestatic net/minecraft/client/renderer/GlStateManager.matrixMode (I)V
      // 050: invokestatic net/minecraft/client/renderer/GlStateManager.pushMatrix ()V
      // 053: invokestatic net/minecraft/client/renderer/GlStateManager.loadIdentity ()V
      // 056: dconst_0
      // 057: aload 4
      // 059: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledWidth_double ()D
      // 05c: aload 4
      // 05e: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledHeight_double ()D
      // 061: dconst_0
      // 062: ldc2_w 1000.0
      // 065: ldc2_w 3000.0
      // 068: invokestatic net/minecraft/client/renderer/GlStateManager.ortho (DDDDDD)V
      // 06b: ldc -260296748
      // 06d: ldc -260294444
      // 06f: ixor
      // 070: invokestatic net/minecraft/client/renderer/GlStateManager.matrixMode (I)V
      // 073: fconst_0
      // 074: fconst_0
      // 075: ldc -2000.0
      // 077: invokestatic net/minecraft/client/renderer/GlStateManager.translate (FFF)V
      // 07a: getstatic x/ocf1019b83a2.Я I
      // 07d: iload 1
      // 07e: if_icmpne 0b3
      // 081: getstatic x/ocf1019b83a2.Ɗ Lnet/minecraft/client/shader/Framebuffer;
      // 084: getfield net/minecraft/client/shader/Framebuffer.framebufferWidth I
      // 087: iload 3
      // 088: ifne 0bd
      // 08b: getstatic x/ocf1019b83a2.Ҙ Lnet/minecraft/client/Minecraft;
      // 08e: getfield net/minecraft/client/Minecraft.displayWidth I
      // 091: if_icmpne 0b3
      // 094: goto 098
      // 097: athrow
      // 098: getstatic x/ocf1019b83a2.Ɗ Lnet/minecraft/client/shader/Framebuffer;
      // 09b: iload 3
      // 09c: ifne 0d3
      // 09f: goto 0a3
      // 0a2: athrow
      // 0a3: getfield net/minecraft/client/shader/Framebuffer.framebufferHeight I
      // 0a6: getstatic x/ocf1019b83a2.Ҙ Lnet/minecraft/client/Minecraft;
      // 0a9: getfield net/minecraft/client/Minecraft.displayHeight I
      // 0ac: if_icmpeq 0c0
      // 0af: goto 0b3
      // 0b2: athrow
      // 0b3: iload 1
      // 0b4: i2f
      // 0b5: invokestatic x/ocf1019b83a2.Ĝ (F)V
      // 0b8: iload 1
      // 0b9: goto 0bd
      // 0bc: athrow
      // 0bd: putstatic x/ocf1019b83a2.Я I
      // 0c0: invokestatic net/minecraft/client/renderer/GlStateManager.disableDepth ()V
      // 0c3: bipush 0
      // 0c4: invokestatic net/minecraft/client/renderer/GlStateManager.depthMask (Z)V
      // 0c7: getstatic x/ocf1019b83a2.Ͷ Ljava/util/List;
      // 0ca: bipush 1
      // 0cb: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 0d0: checkcast net/minecraft/client/shader/Framebuffer
      // 0d3: getstatic x/ocf1019b83a2.Ҙ Lnet/minecraft/client/Minecraft;
      // 0d6: invokevirtual net/minecraft/client/Minecraft.getFramebuffer ()Lnet/minecraft/client/shader/Framebuffer;
      // 0d9: getfield net/minecraft/client/shader/Framebuffer.framebufferTexture I
      // 0dc: getstatic x/ocf1019b83a2.Р Lx/oc595c51c58f;
      // 0df: fload 2
      // 0e0: invokestatic x/ocf1019b83a2.ƃ (Lnet/minecraft/client/shader/Framebuffer;ILx/oc595c51c58f;F)V
      // 0e3: bipush 1
      // 0e4: istore 5
      // 0e6: iload 5
      // 0e8: iload 1
      // 0e9: if_icmpge 121
      // 0ec: getstatic x/ocf1019b83a2.Ͷ Ljava/util/List;
      // 0ef: iload 5
      // 0f1: bipush 1
      // 0f2: iadd
      // 0f3: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 0f8: checkcast net/minecraft/client/shader/Framebuffer
      // 0fb: getstatic x/ocf1019b83a2.Ͷ Ljava/util/List;
      // 0fe: iload 5
      // 100: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 105: checkcast net/minecraft/client/shader/Framebuffer
      // 108: getfield net/minecraft/client/shader/Framebuffer.framebufferTexture I
      // 10b: getstatic x/ocf1019b83a2.Р Lx/oc595c51c58f;
      // 10e: iload 3
      // 10f: ifne 154
      // 112: fload 2
      // 113: invokestatic x/ocf1019b83a2.ƃ (Lnet/minecraft/client/shader/Framebuffer;ILx/oc595c51c58f;F)V
      // 116: iload 3
      // 117: iinc 5 1
      // 11a: ifeq 0e6
      // 11d: goto 121
      // 120: athrow
      // 121: iload 1
      // 122: istore 5
      // 124: iload 5
      // 126: bipush 1
      // 127: if_icmple 15f
      // 12a: getstatic x/ocf1019b83a2.Ͷ Ljava/util/List;
      // 12d: iload 5
      // 12f: bipush 1
      // 130: isub
      // 131: iload 3
      // 132: ifne 163
      // 135: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 13a: checkcast net/minecraft/client/shader/Framebuffer
      // 13d: getstatic x/ocf1019b83a2.Ͷ Ljava/util/List;
      // 140: iload 5
      // 142: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 147: checkcast net/minecraft/client/shader/Framebuffer
      // 14a: getfield net/minecraft/client/shader/Framebuffer.framebufferTexture I
      // 14d: getstatic x/ocf1019b83a2.ѿ Lx/oc595c51c58f;
      // 150: goto 154
      // 153: athrow
      // 154: fload 2
      // 155: invokestatic x/ocf1019b83a2.ƃ (Lnet/minecraft/client/shader/Framebuffer;ILx/oc595c51c58f;F)V
      // 158: iload 3
      // 159: iinc 5 -1
      // 15c: ifeq 124
      // 15f: getstatic x/ocf1019b83a2.Ͷ Ljava/util/List;
      // 162: bipush 0
      // 163: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 168: checkcast net/minecraft/client/shader/Framebuffer
      // 16b: astore 5
      // 16d: aload 5
      // 16f: invokevirtual net/minecraft/client/shader/Framebuffer.framebufferClear ()V
      // 172: aload 5
      // 174: bipush 1
      // 175: invokevirtual net/minecraft/client/shader/Framebuffer.bindFramebuffer (Z)V
      // 178: getstatic x/ocf1019b83a2.ѿ Lx/oc595c51c58f;
      // 17b: invokevirtual x/oc595c51c58f.ǵ ()V
      // 17e: getstatic x/ocf1019b83a2.ѿ Lx/oc595c51c58f;
      // 181: ldc "offset"
      // 183: ldc -260294442
      // 185: ldc -260294444
      // 187: ixor
      // 188: newarray 6
      // 18a: dup
      // 18b: bipush 0
      // 18c: fload 2
      // 18d: fastore
      // 18e: dup
      // 18f: bipush 1
      // 190: fload 2
      // 191: fastore
      // 192: invokevirtual x/oc595c51c58f.ψ (Ljava/lang/String;[F)V
      // 195: getstatic x/ocf1019b83a2.ѿ Lx/oc595c51c58f;
      // 198: ldc "inTexture"
      // 19a: bipush 1
      // 19b: newarray 10
      // 19d: dup
      // 19e: bipush 0
      // 19f: bipush 0
      // 1a0: iastore
      // 1a1: invokevirtual x/oc595c51c58f.ҏ (Ljava/lang/String;[I)V
      // 1a4: getstatic x/ocf1019b83a2.ѿ Lx/oc595c51c58f;
      // 1a7: ldc "check"
      // 1a9: bipush 1
      // 1aa: newarray 10
      // 1ac: dup
      // 1ad: bipush 0
      // 1ae: bipush 1
      // 1af: iastore
      // 1b0: invokevirtual x/oc595c51c58f.ҏ (Ljava/lang/String;[I)V
      // 1b3: getstatic x/ocf1019b83a2.ѿ Lx/oc595c51c58f;
      // 1b6: ldc "textureToCheck"
      // 1b8: bipush 1
      // 1b9: newarray 10
      // 1bb: dup
      // 1bc: bipush 0
      // 1bd: bipush 1
      // 1be: iastore
      // 1bf: invokevirtual x/oc595c51c58f.ҏ (Ljava/lang/String;[I)V
      // 1c2: getstatic x/ocf1019b83a2.ѿ Lx/oc595c51c58f;
      // 1c5: ldc "halfpixel"
      // 1c7: ldc -260294442
      // 1c9: ldc -260294444
      // 1cb: ixor
      // 1cc: newarray 6
      // 1ce: dup
      // 1cf: bipush 0
      // 1d0: fconst_1
      // 1d1: aload 5
      // 1d3: getfield net/minecraft/client/shader/Framebuffer.framebufferWidth I
      // 1d6: i2f
      // 1d7: fdiv
      // 1d8: fastore
      // 1d9: dup
      // 1da: bipush 1
      // 1db: fconst_1
      // 1dc: aload 5
      // 1de: getfield net/minecraft/client/shader/Framebuffer.framebufferHeight I
      // 1e1: i2f
      // 1e2: fdiv
      // 1e3: fastore
      // 1e4: invokevirtual x/oc595c51c58f.ψ (Ljava/lang/String;[F)V
      // 1e7: getstatic x/ocf1019b83a2.ѿ Lx/oc595c51c58f;
      // 1ea: ldc "iResolution"
      // 1ec: ldc -260294442
      // 1ee: ldc -260294444
      // 1f0: ixor
      // 1f1: newarray 6
      // 1f3: dup
      // 1f4: bipush 0
      // 1f5: aload 5
      // 1f7: getfield net/minecraft/client/shader/Framebuffer.framebufferWidth I
      // 1fa: i2f
      // 1fb: fastore
      // 1fc: dup
      // 1fd: bipush 1
      // 1fe: aload 5
      // 200: getfield net/minecraft/client/shader/Framebuffer.framebufferHeight I
      // 203: i2f
      // 204: fastore
      // 205: invokevirtual x/oc595c51c58f.ψ (Ljava/lang/String;[F)V
      // 208: ldc -260260843
      // 20a: ldc -260294444
      // 20c: ixor
      // 20d: invokestatic net/minecraft/client/renderer/GlStateManager.setActiveTexture (I)V
      // 210: iload 0
      // 211: invokestatic x/ocbd4917c4b1.ã (I)V
      // 214: ldc -260260844
      // 216: ldc -260294444
      // 218: ixor
      // 219: invokestatic net/minecraft/client/renderer/GlStateManager.setActiveTexture (I)V
      // 21c: getstatic x/ocf1019b83a2.Ͷ Ljava/util/List;
      // 21f: bipush 1
      // 220: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 225: checkcast net/minecraft/client/shader/Framebuffer
      // 228: getfield net/minecraft/client/shader/Framebuffer.framebufferTexture I
      // 22b: invokestatic x/ocbd4917c4b1.ã (I)V
      // 22e: invokestatic x/oc595c51c58f.ư ()V
      // 231: getstatic x/ocf1019b83a2.ѿ Lx/oc595c51c58f;
      // 234: invokevirtual x/oc595c51c58f.ʇ ()V
      // 237: ldc -260260843
      // 239: ldc -260294444
      // 23b: ixor
      // 23c: invokestatic net/minecraft/client/renderer/GlStateManager.setActiveTexture (I)V
      // 23f: bipush 0
      // 240: invokestatic net/minecraft/client/renderer/GlStateManager.bindTexture (I)V
      // 243: ldc -260260844
      // 245: ldc -260294444
      // 247: ixor
      // 248: invokestatic net/minecraft/client/renderer/GlStateManager.setActiveTexture (I)V
      // 24b: getstatic x/ocf1019b83a2.Ҙ Lnet/minecraft/client/Minecraft;
      // 24e: invokevirtual net/minecraft/client/Minecraft.getFramebuffer ()Lnet/minecraft/client/shader/Framebuffer;
      // 251: bipush 1
      // 252: invokevirtual net/minecraft/client/shader/Framebuffer.bindFramebuffer (Z)V
      // 255: getstatic x/ocf1019b83a2.Ͷ Ljava/util/List;
      // 258: bipush 0
      // 259: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 25e: checkcast net/minecraft/client/shader/Framebuffer
      // 261: getfield net/minecraft/client/shader/Framebuffer.framebufferTexture I
      // 264: invokestatic x/ocbd4917c4b1.ã (I)V
      // 267: fconst_0
      // 268: invokestatic x/ocbd4917c4b1.В (F)V
      // 26b: invokestatic net/minecraft/client/renderer/GlStateManager.enableBlend ()V
      // 26e: ldc -260293674
      // 270: ldc -260294444
      // 272: ixor
      // 273: ldc -260293673
      // 275: ldc -260294444
      // 277: ixor
      // 278: invokestatic net/minecraft/client/renderer/GlStateManager.blendFunc (II)V
      // 27b: invokestatic x/oc595c51c58f.ư ()V
      // 27e: bipush 0
      // 27f: invokestatic net/minecraft/client/renderer/GlStateManager.bindTexture (I)V
      // 282: invokestatic net/minecraft/client/renderer/GlStateManager.disableBlend ()V
      // 285: invokestatic x/ocbd4917c4b1.Ԃ ()V
      // 288: bipush 1
      // 289: istore 6
      // 28b: ldc -260296747
      // 28d: ldc -260294444
      // 28f: ixor
      // 290: invokestatic net/minecraft/client/renderer/GlStateManager.matrixMode (I)V
      // 293: invokestatic net/minecraft/client/renderer/GlStateManager.popMatrix ()V
      // 296: ldc -260296748
      // 298: ldc -260294444
      // 29a: ixor
      // 29b: invokestatic net/minecraft/client/renderer/GlStateManager.matrixMode (I)V
      // 29e: invokestatic net/minecraft/client/renderer/GlStateManager.popMatrix ()V
      // 2a1: iload 6
      // 2a3: ireturn
      // 2a4: astore 5
      // 2a6: bipush 1
      // 2a7: putstatic x/ocf1019b83a2.ı Z
      // 2aa: getstatic x/ocf1019b83a2.ǫ Lorg/apache/logging/log4j/Logger;
      // 2ad: ldc_w "ClickGUI blur is unavailable"
      // 2b0: aload 5
      // 2b2: invokeinterface org/apache/logging/log4j/Logger.warn (Ljava/lang/String;Ljava/lang/Throwable;)V 3
      // 2b7: getstatic x/ocf1019b83a2.Ҙ Lnet/minecraft/client/Minecraft;
      // 2ba: invokevirtual net/minecraft/client/Minecraft.getFramebuffer ()Lnet/minecraft/client/shader/Framebuffer;
      // 2bd: bipush 1
      // 2be: invokevirtual net/minecraft/client/shader/Framebuffer.bindFramebuffer (Z)V
      // 2c1: bipush 0
      // 2c2: istore 6
      // 2c4: ldc -260296747
      // 2c6: ldc -260294444
      // 2c8: ixor
      // 2c9: invokestatic net/minecraft/client/renderer/GlStateManager.matrixMode (I)V
      // 2cc: invokestatic net/minecraft/client/renderer/GlStateManager.popMatrix ()V
      // 2cf: ldc -260296748
      // 2d1: ldc -260294444
      // 2d3: ixor
      // 2d4: invokestatic net/minecraft/client/renderer/GlStateManager.matrixMode (I)V
      // 2d7: invokestatic net/minecraft/client/renderer/GlStateManager.popMatrix ()V
      // 2da: iload 6
      // 2dc: ireturn
      // 2dd: astore 7
      // 2df: ldc -260296747
      // 2e1: ldc -260294444
      // 2e3: ixor
      // 2e4: invokestatic net/minecraft/client/renderer/GlStateManager.matrixMode (I)V
      // 2e7: invokestatic net/minecraft/client/renderer/GlStateManager.popMatrix ()V
      // 2ea: ldc -260296748
      // 2ec: ldc -260294444
      // 2ee: ixor
      // 2ef: invokestatic net/minecraft/client/renderer/GlStateManager.matrixMode (I)V
      // 2f2: invokestatic net/minecraft/client/renderer/GlStateManager.popMatrix ()V
      // 2f5: aload 7
      // 2f7: athrow
   }

   private static boolean Ͼ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc1b46ea259e.ǧ Z
      // 03: istore 0
      // 04: getstatic x/ocf1019b83a2.ı Z
      // 07: iload 0
      // 08: ifne 25
      // 0b: ifne 24
      // 0e: goto 12
      // 11: athrow
      // 12: invokestatic x/oc992493b0d3.ʢ ()Z
      // 15: iload 0
      // 16: ifne 25
      // 19: goto 1d
      // 1c: athrow
      // 1d: ifne 26
      // 20: goto 24
      // 23: athrow
      // 24: bipush 0
      // 25: ireturn
      // 26: getstatic x/ocf1019b83a2.Р Lx/oc595c51c58f;
      // 29: iload 0
      // 2a: ifne 72
      // 2d: ifnull 5b
      // 30: goto 34
      // 33: athrow
      // 34: getstatic x/ocf1019b83a2.ѿ Lx/oc595c51c58f;
      // 37: iload 0
      // 38: ifne 72
      // 3b: goto 3f
      // 3e: athrow
      // 3f: ifnull 5b
      // 42: goto 46
      // 45: athrow
      // 46: getstatic x/ocf1019b83a2.Ɗ Lnet/minecraft/client/shader/Framebuffer;
      // 49: iload 0
      // 4a: ifne 7f
      // 4d: goto 51
      // 50: athrow
      // 51: ifnull 5b
      // 54: goto 58
      // 57: athrow
      // 58: bipush 1
      // 59: ireturn
      // 5a: athrow
      // 5b: new x/oc595c51c58f
      // 5e: dup
      // 5f: ldc_w "kawaseDown"
      // 62: invokespecial x/oc595c51c58f.<init> (Ljava/lang/String;)V
      // 65: putstatic x/ocf1019b83a2.Р Lx/oc595c51c58f;
      // 68: new x/oc595c51c58f
      // 6b: dup
      // 6c: ldc_w "kawaseUp"
      // 6f: invokespecial x/oc595c51c58f.<init> (Ljava/lang/String;)V
      // 72: putstatic x/ocf1019b83a2.ѿ Lx/oc595c51c58f;
      // 75: new net/minecraft/client/shader/Framebuffer
      // 78: dup
      // 79: bipush 1
      // 7a: bipush 1
      // 7b: bipush 0
      // 7c: invokespecial net/minecraft/client/shader/Framebuffer.<init> (IIZ)V
      // 7f: putstatic x/ocf1019b83a2.Ɗ Lnet/minecraft/client/shader/Framebuffer;
      // 82: bipush 1
      // 83: ireturn
      // 84: astore 1
      // 85: bipush 1
      // 86: putstatic x/ocf1019b83a2.ı Z
      // 89: getstatic x/ocf1019b83a2.ǫ Lorg/apache/logging/log4j/Logger;
      // 8c: ldc_w "ClickGUI blur initialization failed"
      // 8f: aload 1
      // 90: invokeinterface org/apache/logging/log4j/Logger.warn (Ljava/lang/String;Ljava/lang/Throwable;)V 3
      // 95: bipush 0
      // 96: ireturn
   }

   private static void ƃ(Framebuffer var0, int var1, oc595c51c58f var2, float var3) {
      var0.framebufferClear();
      var0.bindFramebuffer(true);
      var2.ǵ();
      ocbd4917c4b1.ã(var1);
      float[] var10002 = new float[1589955125 ^ 1589955127];
      var10002[0] = var3;
      var10002[1] = var3;
      var2.ψ("offset", var10002);
      var2.ҏ("inTexture", 0);
      var2.ҏ("check", 0);
      var10002 = new float[1589955125 ^ 1589955127];
      var10002[0] = 1.0F / var0.framebufferWidth;
      var10002[1] = 1.0F / var0.framebufferHeight;
      var2.ψ("halfpixel", var10002);
      var10002 = new float[1589955125 ^ 1589955127];
      var10002[0] = var0.framebufferWidth;
      var10002[1] = var0.framebufferHeight;
      var2.ψ("iResolution", var10002);
      oc595c51c58f.ư();
      var2.ʇ();
   }
}

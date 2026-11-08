package x;

import net.minecraft.client.renderer.OpenGlHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.Display;

public class ocb7e057f84c {
   static final String Ȥ = "minecraft:miau/shaders/main_menu/background.frag";
   private static final Logger Ց = LogManager.getLogger(ocb7e057f84c.class);
   private static oc595c51c58f Չ;
   private static boolean v;
   public static int հ;

   private ocb7e057f84c() {
   }

   public static boolean ё(float var0) {
      return ņ(var0, -1448831017 ^ 1457793064, -1457805135 ^ 1457793064);
   }

   public static boolean ņ(float param0, int param1, int param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc1b46ea259e.ǧ Z
      // 003: invokestatic x/ocb7e057f84c.ī ()Lx/oc595c51c58f;
      // 006: astore 4
      // 008: istore 3
      // 009: aload 4
      // 00b: ifnonnull 011
      // 00e: bipush 0
      // 00f: ireturn
      // 010: athrow
      // 011: invokestatic net/minecraft/client/Minecraft.getMinecraft ()Lnet/minecraft/client/Minecraft;
      // 014: astore 5
      // 016: aload 5
      // 018: getfield net/minecraft/client/Minecraft.displayWidth I
      // 01b: iload 3
      // 01c: ifne 03b
      // 01f: ifle 03a
      // 022: goto 026
      // 025: athrow
      // 026: aload 5
      // 028: getfield net/minecraft/client/Minecraft.displayHeight I
      // 02b: iload 3
      // 02c: ifne 048
      // 02f: goto 033
      // 032: athrow
      // 033: ifgt 03c
      // 036: goto 03a
      // 039: athrow
      // 03a: bipush 0
      // 03b: ireturn
      // 03c: fload 0
      // 03d: iload 3
      // 03e: ifne 054
      // 041: invokestatic java/lang/Float.isFinite (F)Z
      // 044: goto 048
      // 047: athrow
      // 048: ifeq 057
      // 04b: fconst_0
      // 04c: fload 0
      // 04d: invokestatic java/lang/Math.max (FF)F
      // 050: goto 054
      // 053: athrow
      // 054: goto 058
      // 057: fconst_0
      // 058: fstore 6
      // 05a: bipush 0
      // 05b: istore 7
      // 05d: invokestatic net/minecraft/client/renderer/GlStateManager.enableBlend ()V
      // 060: iload 3
      // 061: ldc -130922865
      // 063: ldc -130923123
      // 065: ixor
      // 066: ldc -130922866
      // 068: ldc -130923123
      // 06a: ixor
      // 06b: invokestatic net/minecraft/client/renderer/GlStateManager.blendFunc (II)V
      // 06e: invokestatic net/minecraft/client/renderer/GlStateManager.disableAlpha ()V
      // 071: aload 4
      // 073: invokevirtual x/oc595c51c58f.ǵ ()V
      // 076: bipush 1
      // 077: istore 7
      // 079: aload 4
      // 07b: ldc "resolution"
      // 07d: ldc -130923121
      // 07f: ldc -130923123
      // 081: ixor
      // 082: newarray 6
      // 084: dup
      // 085: bipush 0
      // 086: aload 5
      // 088: getfield net/minecraft/client/Minecraft.displayWidth I
      // 08b: i2f
      // 08c: fastore
      // 08d: dup
      // 08e: bipush 1
      // 08f: aload 5
      // 091: getfield net/minecraft/client/Minecraft.displayHeight I
      // 094: i2f
      // 095: fastore
      // 096: invokevirtual x/oc595c51c58f.ψ (Ljava/lang/String;[F)V
      // 099: aload 4
      // 09b: ldc "time"
      // 09d: bipush 1
      // 09e: newarray 6
      // 0a0: dup
      // 0a1: bipush 0
      // 0a2: fload 6
      // 0a4: fastore
      // 0a5: invokevirtual x/oc595c51c58f.ψ (Ljava/lang/String;[F)V
      // 0a8: aload 4
      // 0aa: ldc "primaryColor"
      // 0ac: iload 1
      // 0ad: invokestatic x/ocb7e057f84c.F (Lx/oc595c51c58f;Ljava/lang/String;I)V
      // 0b0: aload 4
      // 0b2: ldc "secondaryColor"
      // 0b4: iload 2
      // 0b5: invokestatic x/ocb7e057f84c.F (Lx/oc595c51c58f;Ljava/lang/String;I)V
      // 0b8: invokestatic x/oc595c51c58f.ư ()V
      // 0bb: bipush 1
      // 0bc: istore 8
      // 0be: ifne 0e0
      // 0c1: iload 7
      // 0c3: ifeq 0d0
      // 0c6: aload 4
      // 0c8: invokevirtual x/oc595c51c58f.ʇ ()V
      // 0cb: goto 0d0
      // 0ce: astore 9
      // 0d0: invokestatic net/minecraft/client/renderer/GlStateManager.enableAlpha ()V
      // 0d3: invokestatic net/minecraft/client/renderer/GlStateManager.disableBlend ()V
      // 0d6: invokestatic net/minecraft/client/renderer/GlStateManager.enableTexture2D ()V
      // 0d9: fconst_1
      // 0da: fconst_1
      // 0db: fconst_1
      // 0dc: fconst_1
      // 0dd: invokestatic net/minecraft/client/renderer/GlStateManager.color (FFFF)V
      // 0e0: iload 8
      // 0e2: ireturn
      // 0e3: astore 8
      // 0e5: iload 3
      // 0e6: ldc "The Rise main-menu background shader failed while rendering"
      // 0e8: aload 8
      // 0ea: invokestatic x/ocb7e057f84c.E (Ljava/lang/String;Ljava/lang/Throwable;)V
      // 0ed: bipush 0
      // 0ee: istore 9
      // 0f0: ifne 112
      // 0f3: iload 7
      // 0f5: ifeq 102
      // 0f8: aload 4
      // 0fa: invokevirtual x/oc595c51c58f.ʇ ()V
      // 0fd: goto 102
      // 100: astore 10
      // 102: invokestatic net/minecraft/client/renderer/GlStateManager.enableAlpha ()V
      // 105: invokestatic net/minecraft/client/renderer/GlStateManager.disableBlend ()V
      // 108: invokestatic net/minecraft/client/renderer/GlStateManager.enableTexture2D ()V
      // 10b: fconst_1
      // 10c: fconst_1
      // 10d: fconst_1
      // 10e: fconst_1
      // 10f: invokestatic net/minecraft/client/renderer/GlStateManager.color (FFFF)V
      // 112: iload 9
      // 114: ireturn
      // 115: astore 11
      // 117: iload 3
      // 118: ifne 13a
      // 11b: iload 7
      // 11d: ifeq 12a
      // 120: aload 4
      // 122: invokevirtual x/oc595c51c58f.ʇ ()V
      // 125: goto 12a
      // 128: astore 12
      // 12a: invokestatic net/minecraft/client/renderer/GlStateManager.enableAlpha ()V
      // 12d: invokestatic net/minecraft/client/renderer/GlStateManager.disableBlend ()V
      // 130: invokestatic net/minecraft/client/renderer/GlStateManager.enableTexture2D ()V
      // 133: fconst_1
      // 134: fconst_1
      // 135: fconst_1
      // 136: fconst_1
      // 137: invokestatic net/minecraft/client/renderer/GlStateManager.color (FFFF)V
      // 13a: aload 11
      // 13c: athrow
   }

   private static void F(oc595c51c58f var0, String var1, int var2) {
      float[] var10002 = new float[-105273202 ^ -105273203];
      var10002[0] = l(var2, -105273187 ^ -105273203);
      var10002[1] = l(var2, -105273211 ^ -105273203);
      var10002[-105273201 ^ -105273203] = l(var2, 0);
      var0.ψ(var1, var10002);
   }

   static float l(int var0, int var1) {
      return (var0 >> var1 & (-567642809 ^ -567642696)) / 255.0F;
   }

   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static synchronized oc595c51c58f ī() {
      boolean var0 = oc1b46ea259e.ǧ;

      label61: {
         try {
            if (var0) {
               return Չ;
            }

            if (Չ == null) {
               break label61;
            }
         } catch (RuntimeException var6) {
            throw var6;
         }

         return Չ;
      }

      label56: {
         boolean var7;
         label40: {
            try {
               var7 = v;
               if (var0) {
                  break label40;
               }

               if (v) {
                  break label56;
               }
            } catch (RuntimeException var5) {
               throw var5;
            }

            var7 = Α();
         }

         try {
            if (!var7) {
               break label56;
            }
         } catch (RuntimeException var4) {
            throw var4;
         }

         try {
            Չ = new oc595c51c58f("minecraft:miau/shaders/main_menu/background.frag");
            return Չ;
         } catch (LinkageError | RuntimeException var3) {
            E("The Rise main-menu background shader is unavailable", var3);
            return null;
         }
      }

      try {
         return null;
      } catch (RuntimeException var2) {
         throw var2;
      }
   }

   private static boolean Α() {
      try {
         return ξ(Display.isCreated(), OpenGlHelper.openGL21);
      } catch (LinkageError | RuntimeException var1) {
         return false;
      }
   }

   static boolean ξ(boolean var0, boolean var1) {
      boolean var2 = oc1b46ea259e.ǧ;

      boolean var10000;
      label33: {
         try {
            var10000 = var0;
            if (var2) {
               break label33;
            }

            if (!var0) {
               return false;
            }
         } catch (RuntimeException var4) {
            throw var4;
         }

         var10000 = var1;
      }

      try {
         if (var2) {
            return var10000;
         }

         if (var10000) {
            return true;
         }
      } catch (RuntimeException var3) {
         throw var3;
      }

      return false;
   }

   private static synchronized void E(String var0, Throwable var1) {
      boolean var2 = oc1b46ea259e.ǧ;

      boolean var10000;
      label20: {
         try {
            var10000 = v;
            if (var2) {
               break label20;
            }

            if (v) {
               return;
            }
         } catch (RuntimeException var3) {
            throw var3;
         }

         var10000 = true;
      }

      v = var10000;
      Ց.warn(var0, var1);
   }
}

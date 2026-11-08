package x;

import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.GL20;

public abstract class oc188196c08d {
   private static final Logger ӂ = LogManager.getLogger(oc188196c08d.class);
   private static final String Ձ = "#version 120\nvoid main() {\n  gl_TexCoord[0] = gl_MultiTexCoord0;\n  gl_Position = gl_ModelViewProjectionMatrix * gl_Vertex;\n}";
   protected int ֆ = -1;
   private final Map<String, Integer> Ѿ = new HashMap<>();
   private final String հ;
   private boolean µ;
   public static boolean Õ;

   public oc188196c08d(String var1) {
      this.հ = var1;
   }

   private int γ(String param1, int param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc1b46ea259e.ǧ Z
      // 03: istore 3
      // 04: iload 3
      // 05: iload 2
      // 06: invokestatic org/lwjgl/opengl/GL20.glCreateShader (I)I
      // 09: istore 4
      // 0b: ifne 2d
      // 0e: iload 4
      // 10: ifne 1a
      // 13: goto 17
      // 16: athrow
      // 17: bipush -1
      // 18: ireturn
      // 19: athrow
      // 1a: iload 4
      // 1c: aload 1
      // 1d: invokestatic x/oc30aea91d28.Տ (ILjava/lang/CharSequence;)V
      // 20: iload 4
      // 22: iload 3
      // 23: ifne 44
      // 26: invokestatic org/lwjgl/opengl/GL20.glCompileShader (I)V
      // 29: goto 2d
      // 2c: athrow
      // 2d: iload 4
      // 2f: ldc -1921282976
      // 31: ldc -1921316895
      // 33: ixor
      // 34: invokestatic org/lwjgl/opengl/GL20.glGetShaderi (II)I
      // 37: ifne 42
      // 3a: iload 4
      // 3c: invokestatic org/lwjgl/opengl/GL20.glDeleteShader (I)V
      // 3f: bipush -1
      // 40: ireturn
      // 41: athrow
      // 42: iload 4
      // 44: ireturn
   }

   private synchronized boolean ζ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc1b46ea259e.ǧ Z
      // 003: istore 1
      // 004: aload 0
      // 005: iload 1
      // 006: ifne 017
      // 009: getfield x/oc188196c08d.ֆ I
      // 00c: iflt 016
      // 00f: goto 013
      // 012: athrow
      // 013: bipush 1
      // 014: ireturn
      // 015: athrow
      // 016: aload 0
      // 017: getfield x/oc188196c08d.µ Z
      // 01a: iload 1
      // 01b: ifne 038
      // 01e: ifne 037
      // 021: goto 025
      // 024: athrow
      // 025: invokestatic x/oc992493b0d3.ʢ ()Z
      // 028: iload 1
      // 029: ifne 03f
      // 02c: goto 030
      // 02f: athrow
      // 030: ifne 039
      // 033: goto 037
      // 036: athrow
      // 037: bipush 0
      // 038: ireturn
      // 039: aload 0
      // 03a: bipush 1
      // 03b: putfield x/oc188196c08d.µ Z
      // 03e: bipush -1
      // 03f: istore 2
      // 040: bipush -1
      // 041: istore 3
      // 042: bipush -1
      // 043: istore 4
      // 045: aload 0
      // 046: ldc "#version 120\nvoid main() {\n  gl_TexCoord[0] = gl_MultiTexCoord0;\n  gl_Position = gl_ModelViewProjectionMatrix * gl_Vertex;\n}"
      // 048: ldc 1493129809
      // 04a: ldc 1493160288
      // 04c: ixor
      // 04d: invokevirtual x/oc188196c08d.γ (Ljava/lang/String;I)I
      // 050: istore 2
      // 051: aload 0
      // 052: aload 0
      // 053: getfield x/oc188196c08d.հ Ljava/lang/String;
      // 056: ldc 1493129808
      // 058: ldc 1493160288
      // 05a: ixor
      // 05b: invokevirtual x/oc188196c08d.γ (Ljava/lang/String;I)I
      // 05e: iload 1
      // 05f: ifne 078
      // 062: istore 3
      // 063: iload 2
      // 064: iflt 077
      // 067: iload 3
      // 068: iload 1
      // 069: ifne 0b0
      // 06c: goto 070
      // 06f: athrow
      // 070: ifge 0a1
      // 073: goto 077
      // 076: athrow
      // 077: bipush 0
      // 078: istore 5
      // 07a: iload 2
      // 07b: iload 1
      // 07c: ifne 097
      // 07f: invokestatic x/oc188196c08d.Ί (I)V
      // 082: iload 3
      // 083: invokestatic x/oc188196c08d.Ί (I)V
      // 086: aload 0
      // 087: getfield x/oc188196c08d.ֆ I
      // 08a: ifge 09a
      // 08d: goto 091
      // 090: athrow
      // 091: iload 4
      // 093: goto 097
      // 096: athrow
      // 097: goto 09b
      // 09a: bipush -1
      // 09b: invokestatic x/oc188196c08d.ύ (I)V
      // 09e: iload 5
      // 0a0: ireturn
      // 0a1: invokestatic org/lwjgl/opengl/GL20.glCreateProgram ()I
      // 0a4: istore 4
      // 0a6: iload 1
      // 0a7: ifne 0f6
      // 0aa: iload 4
      // 0ac: goto 0b0
      // 0af: athrow
      // 0b0: ifne 0dd
      // 0b3: bipush 0
      // 0b4: istore 5
      // 0b6: iload 2
      // 0b7: invokestatic x/oc188196c08d.Ί (I)V
      // 0ba: iload 3
      // 0bb: iload 1
      // 0bc: ifne 0d3
      // 0bf: invokestatic x/oc188196c08d.Ί (I)V
      // 0c2: aload 0
      // 0c3: getfield x/oc188196c08d.ֆ I
      // 0c6: ifge 0d6
      // 0c9: goto 0cd
      // 0cc: athrow
      // 0cd: iload 4
      // 0cf: goto 0d3
      // 0d2: athrow
      // 0d3: goto 0d7
      // 0d6: bipush -1
      // 0d7: invokestatic x/oc188196c08d.ύ (I)V
      // 0da: iload 5
      // 0dc: ireturn
      // 0dd: iload 4
      // 0df: iload 2
      // 0e0: invokestatic org/lwjgl/opengl/GL20.glAttachShader (II)V
      // 0e3: iload 4
      // 0e5: iload 1
      // 0e6: ifne 138
      // 0e9: iload 3
      // 0ea: invokestatic org/lwjgl/opengl/GL20.glAttachShader (II)V
      // 0ed: iload 4
      // 0ef: invokestatic org/lwjgl/opengl/GL20.glLinkProgram (I)V
      // 0f2: goto 0f6
      // 0f5: athrow
      // 0f6: iload 4
      // 0f8: ldc 1493129954
      // 0fa: ldc 1493160288
      // 0fc: ixor
      // 0fd: invokestatic org/lwjgl/opengl/GL20.glGetProgrami (II)I
      // 100: ifne 12d
      // 103: bipush 0
      // 104: istore 5
      // 106: iload 2
      // 107: iload 1
      // 108: ifne 123
      // 10b: invokestatic x/oc188196c08d.Ί (I)V
      // 10e: iload 3
      // 10f: invokestatic x/oc188196c08d.Ί (I)V
      // 112: aload 0
      // 113: getfield x/oc188196c08d.ֆ I
      // 116: ifge 126
      // 119: goto 11d
      // 11c: athrow
      // 11d: iload 4
      // 11f: goto 123
      // 122: athrow
      // 123: goto 127
      // 126: bipush -1
      // 127: invokestatic x/oc188196c08d.ύ (I)V
      // 12a: iload 5
      // 12c: ireturn
      // 12d: aload 0
      // 12e: iload 4
      // 130: putfield x/oc188196c08d.ֆ I
      // 133: aload 0
      // 134: invokevirtual x/oc188196c08d.z$mr5yuwpmnovg ()V
      // 137: bipush 1
      // 138: istore 5
      // 13a: iload 2
      // 13b: invokestatic x/oc188196c08d.Ί (I)V
      // 13e: iload 3
      // 13f: iload 1
      // 140: ifne 157
      // 143: invokestatic x/oc188196c08d.Ί (I)V
      // 146: aload 0
      // 147: getfield x/oc188196c08d.ֆ I
      // 14a: ifge 15a
      // 14d: goto 151
      // 150: athrow
      // 151: iload 4
      // 153: goto 157
      // 156: athrow
      // 157: goto 15b
      // 15a: bipush -1
      // 15b: invokestatic x/oc188196c08d.ύ (I)V
      // 15e: iload 5
      // 160: ireturn
      // 161: astore 5
      // 163: aload 0
      // 164: bipush -1
      // 165: putfield x/oc188196c08d.ֆ I
      // 168: getstatic x/oc188196c08d.ӂ Lorg/apache/logging/log4j/Logger;
      // 16b: ldc "Custom outline shaders are unavailable"
      // 16d: aload 5
      // 16f: invokeinterface org/apache/logging/log4j/Logger.warn (Ljava/lang/String;Ljava/lang/Throwable;)V 3
      // 174: bipush 0
      // 175: istore 6
      // 177: iload 2
      // 178: invokestatic x/oc188196c08d.Ί (I)V
      // 17b: iload 3
      // 17c: iload 1
      // 17d: ifne 194
      // 180: invokestatic x/oc188196c08d.Ί (I)V
      // 183: aload 0
      // 184: getfield x/oc188196c08d.ֆ I
      // 187: ifge 197
      // 18a: goto 18e
      // 18d: athrow
      // 18e: iload 4
      // 190: goto 194
      // 193: athrow
      // 194: goto 198
      // 197: bipush -1
      // 198: invokestatic x/oc188196c08d.ύ (I)V
      // 19b: iload 6
      // 19d: ireturn
      // 19e: astore 7
      // 1a0: iload 2
      // 1a1: invokestatic x/oc188196c08d.Ί (I)V
      // 1a4: iload 3
      // 1a5: iload 1
      // 1a6: ifne 1bd
      // 1a9: invokestatic x/oc188196c08d.Ί (I)V
      // 1ac: aload 0
      // 1ad: getfield x/oc188196c08d.ֆ I
      // 1b0: ifge 1c0
      // 1b3: goto 1b7
      // 1b6: athrow
      // 1b7: iload 4
      // 1b9: goto 1bd
      // 1bc: athrow
      // 1bd: goto 1c1
      // 1c0: bipush -1
      // 1c1: invokestatic x/oc188196c08d.ύ (I)V
      // 1c4: aload 7
      // 1c6: athrow
   }

   protected void Ȳ(String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc1b46ea259e.ǧ Z
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 2c
      // 09: getfield x/oc188196c08d.ֆ I
      // 0c: iflt 2d
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: getfield x/oc188196c08d.Ѿ Ljava/util/Map;
      // 17: aload 1
      // 18: aload 0
      // 19: getfield x/oc188196c08d.ֆ I
      // 1c: aload 1
      // 1d: invokestatic org/lwjgl/opengl/GL20.glGetUniformLocation (ILjava/lang/CharSequence;)I
      // 20: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 23: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 28: goto 2c
      // 2b: athrow
      // 2c: pop
      // 2d: return
   }

   protected int Т(String var1) {
      return this.Ѿ.getOrDefault(var1, -1);
   }

   public abstract void z$mr5yuwpmnovg();

   public abstract void z$7r1hve2gx412();

   public void ѿ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc1b46ea259e.ǧ Z
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 18
      // 09: invokevirtual x/oc188196c08d.ζ ()Z
      // 0c: ifeq 1b
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: invokevirtual x/oc188196c08d.z$7r1hve2gx412 ()V
      // 1b: return
   }

   public void ʂ() {
      boolean var1 = oc1b46ea259e.ǧ;

      int var10000;
      label34: {
         try {
            var10000 = this.ֆ;
            if (var1) {
               break label34;
            }

            if (this.ֆ < 0) {
               return;
            }
         } catch (RuntimeException var3) {
            throw var3;
         }

         var10000 = oc992493b0d3.ʢ();
      }

      label26: {
         try {
            if (var1) {
               break label26;
            }

            if (var10000 == 0) {
               return;
            }
         } catch (RuntimeException var2) {
            throw var2;
         }

         var10000 = 0;
      }

      GL20.glUseProgram(var10000);
   }

   public boolean Ҹ() {
      return this.ζ();
   }

   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static void Ί(int var0) {
      boolean var1 = oc1b46ea259e.ǧ;

      int var10000;
      label30: {
         try {
            var10000 = var0;
            if (var1) {
               break label30;
            }

            if (var0 <= 0) {
               return;
            }
         } catch (RuntimeException var5) {
            throw var5;
         }

         try {
            var10000 = var0;
         } catch (LinkageError | RuntimeException var4) {
            return;
         }
      }

      try {
         GL20.glDeleteShader(var10000);
      } catch (LinkageError | RuntimeException var3) {
      }
   }

   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static void ύ(int var0) {
      boolean var1 = oc1b46ea259e.ǧ;

      int var10000;
      label30: {
         try {
            var10000 = var0;
            if (var1) {
               break label30;
            }

            if (var0 <= 0) {
               return;
            }
         } catch (RuntimeException var5) {
            throw var5;
         }

         try {
            var10000 = var0;
         } catch (LinkageError | RuntimeException var4) {
            return;
         }
      }

      try {
         GL20.glDeleteProgram(var10000);
      } catch (LinkageError | RuntimeException var3) {
      }
   }
}

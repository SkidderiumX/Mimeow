package x;

import java.nio.charset.StandardCharsets;
import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Session;
import net.minecraft.util.Session.Type;

public class occ791aa07d0 {
   private static final Minecraft Վ;
   private static Session Ɏ;
   public static int ҍ;
   private static final long[] a;
   private static final Integer[] b;

   public static void Ӽ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: ldc2_w -3027749903002176708
      // 03: ldc2_w -3027782368732049629
      // 06: lxor
      // 07: lstore 0
      // 08: lload 0
      // 09: dup2
      // 0a: ldc2_w -3027820451298822140
      // 0d: ldc2_w -3027782368732049629
      // 10: lxor
      // 11: lxor
      // 12: dup2
      // 13: ldc 343666251
      // 15: ldc 343666283
      // 17: ixor
      // 18: lushr
      // 19: l2i
      // 1a: istore 2
      // 1b: dup2
      // 1c: ldc 343666251
      // 1e: ldc 343666283
      // 20: ixor
      // 21: lshl
      // 22: ldc 343666267
      // 24: ldc 343666283
      // 26: ixor
      // 27: lushr
      // 28: l2i
      // 29: istore 3
      // 2a: dup2
      // 2b: ldc 343666267
      // 2d: ldc 343666283
      // 2f: ixor
      // 30: lshl
      // 31: ldc 343666267
      // 33: ldc 343666283
      // 35: ixor
      // 36: lushr
      // 37: l2i
      // 38: istore 4
      // 3a: pop2
      // 3b: pop2
      // 3c: getstatic x/oc804fdd8d75.Ɔ I
      // 3f: istore 5
      // 41: getstatic x/occ791aa07d0.Ɏ Lnet/minecraft/util/Session;
      // 44: ifnonnull 82
      // 47: getstatic x/occ791aa07d0.Վ Lnet/minecraft/client/Minecraft;
      // 4a: iload 5
      // 4c: ifne 5d
      // 4f: goto 53
      // 52: athrow
      // 53: ifnull 82
      // 56: goto 5a
      // 59: athrow
      // 5a: getstatic x/occ791aa07d0.Վ Lnet/minecraft/client/Minecraft;
      // 5d: iload 5
      // 5f: ifne 73
      // 62: invokevirtual net/minecraft/client/Minecraft.getSession ()Lnet/minecraft/util/Session;
      // 65: ifnull 82
      // 68: goto 6c
      // 6b: athrow
      // 6c: getstatic x/occ791aa07d0.Վ Lnet/minecraft/client/Minecraft;
      // 6f: goto 73
      // 72: athrow
      // 73: invokevirtual net/minecraft/client/Minecraft.getSession ()Lnet/minecraft/util/Session;
      // 76: iload 2
      // 77: iload 3
      // 78: i2s
      // 79: iload 4
      // 7b: i2s
      // 7c: invokestatic x/occ791aa07d0.ĉ (Lnet/minecraft/util/Session;ISS)Lnet/minecraft/util/Session;
      // 7f: putstatic x/occ791aa07d0.Ɏ Lnet/minecraft/util/Session;
      // 82: return
   }

   public static Session Ä() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: ldc2_w -3879867663937052976
      // 03: ldc2_w -3879984282651481172
      // 06: lxor
      // 07: lstore 0
      // 08: lload 0
      // 09: dup2
      // 0a: ldc2_w -3879938779158506008
      // 0d: ldc2_w -3879984282651481172
      // 10: lxor
      // 11: lxor
      // 12: dup2
      // 13: ldc -525569268
      // 15: ldc -525569236
      // 17: ixor
      // 18: lushr
      // 19: l2i
      // 1a: istore 2
      // 1b: dup2
      // 1c: ldc -525569268
      // 1e: ldc -525569236
      // 20: ixor
      // 21: lshl
      // 22: ldc -525569252
      // 24: ldc -525569236
      // 26: ixor
      // 27: lushr
      // 28: l2i
      // 29: istore 3
      // 2a: dup2
      // 2b: ldc -525569252
      // 2d: ldc -525569236
      // 2f: ixor
      // 30: lshl
      // 31: ldc -525569252
      // 33: ldc -525569236
      // 35: ixor
      // 36: lushr
      // 37: l2i
      // 38: istore 4
      // 3a: pop2
      // 3b: pop2
      // 3c: getstatic x/oc804fdd8d75.Ɔ I
      // 3f: istore 5
      // 41: getstatic x/occ791aa07d0.Ɏ Lnet/minecraft/util/Session;
      // 44: iload 5
      // 46: ifne 58
      // 49: ifnonnull 55
      // 4c: goto 50
      // 4f: athrow
      // 50: aconst_null
      // 51: goto 61
      // 54: athrow
      // 55: getstatic x/occ791aa07d0.Ɏ Lnet/minecraft/util/Session;
      // 58: iload 2
      // 59: iload 3
      // 5a: i2s
      // 5b: iload 4
      // 5d: i2s
      // 5e: invokestatic x/occ791aa07d0.ĉ (Lnet/minecraft/util/Session;ISS)Lnet/minecraft/util/Session;
      // 61: areturn
   }

   public static boolean Ў() {
      return ճ(Ɏ, þ());
   }

   public static boolean Ǿ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: ldc2_w -7009889226361821142
      // 03: ldc2_w -7009964957284481534
      // 06: lxor
      // 07: lstore 0
      // 08: lload 0
      // 09: dup2
      // 0a: ldc2_w -7009960343205911790
      // 0d: ldc2_w -7009964957284481534
      // 10: lxor
      // 11: lxor
      // 12: dup2
      // 13: ldc -1529814679
      // 15: ldc -1529814711
      // 17: ixor
      // 18: lushr
      // 19: l2i
      // 1a: istore 2
      // 1b: dup2
      // 1c: ldc -1529814679
      // 1e: ldc -1529814711
      // 20: ixor
      // 21: lshl
      // 22: ldc -1529814663
      // 24: ldc -1529814711
      // 26: ixor
      // 27: lushr
      // 28: l2i
      // 29: istore 3
      // 2a: dup2
      // 2b: ldc -1529814663
      // 2d: ldc -1529814711
      // 2f: ixor
      // 30: lshl
      // 31: ldc -1529814663
      // 33: ldc -1529814711
      // 35: ixor
      // 36: lushr
      // 37: l2i
      // 38: istore 4
      // 3a: pop2
      // 3b: pop2
      // 3c: getstatic x/oc804fdd8d75.Ɔ I
      // 3f: istore 5
      // 41: getstatic x/occ791aa07d0.Ɏ Lnet/minecraft/util/Session;
      // 44: iload 5
      // 46: ifne 5f
      // 49: ifnonnull 53
      // 4c: goto 50
      // 4f: athrow
      // 50: bipush 0
      // 51: ireturn
      // 52: athrow
      // 53: getstatic x/occ791aa07d0.Ɏ Lnet/minecraft/util/Session;
      // 56: iload 2
      // 57: iload 3
      // 58: i2s
      // 59: iload 4
      // 5b: i2s
      // 5c: invokestatic x/occ791aa07d0.ĉ (Lnet/minecraft/util/Session;ISS)Lnet/minecraft/util/Session;
      // 5f: invokestatic x/occ791aa07d0.б (Lnet/minecraft/util/Session;)V
      // 62: bipush 1
      // 63: ireturn
   }

   public static Session þ() {
      return Վ.getSession();
   }

   public static Session û(String var0) {
      String var1 = UUID.nameUUIDFromBytes(("OfflinePlayer:" + var0).getBytes(StandardCharsets.UTF_8)).toString().replace("-", "");
      return new Session(var0, var1, "0", Type.LEGACY.toString());
   }

   public static void б(Session param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc804fdd8d75.Ɔ I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 23
      // 09: ifnonnull 1b
      // 0c: goto 10
      // 0f: athrow
      // 10: new java/lang/IllegalArgumentException
      // 13: dup
      // 14: ldc "session"
      // 16: invokespecial java/lang/IllegalArgumentException.<init> (Ljava/lang/String;)V
      // 19: athrow
      // 1a: athrow
      // 1b: getstatic x/occ791aa07d0.Վ Lnet/minecraft/client/Minecraft;
      // 1e: aload 0
      // 1f: invokevirtual net/minecraft/client/Minecraft.setSession (Lnet/minecraft/util/Session;)V
      // 22: aload 0
      // 23: invokestatic x/ocd6bc26d10b.м (Lnet/minecraft/util/Session;)V
      // 26: invokestatic x/ocdf3e495c45.ϝ ()Lx/ocdf3e495c45;
      // 29: invokevirtual x/ocdf3e495c45.Ӧ ()V
      // 2c: return
   }

   static boolean ճ(Session param0, Session param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: ldc2_w -3333413584787960450
      // 03: ldc2_w -3333437589813992147
      // 06: lxor
      // 07: lstore 2
      // 08: lload 2
      // 09: dup2
      // 0a: ldc2_w -3333401710802026997
      // 0d: ldc2_w -3333437589813992147
      // 10: lxor
      // 11: lxor
      // 12: dup2
      // 13: ldc 266096893
      // 15: ldc 266096861
      // 17: ixor
      // 18: lushr
      // 19: l2i
      // 1a: istore 4
      // 1c: dup2
      // 1d: ldc 266096893
      // 1f: ldc 266096861
      // 21: ixor
      // 22: lshl
      // 23: ldc 266096893
      // 25: ldc 266096861
      // 27: ixor
      // 28: lushr
      // 29: lstore 5
      // 2b: pop2
      // 2c: pop2
      // 2d: getstatic x/oc804fdd8d75.Ɔ I
      // 30: istore 8
      // 32: aload 0
      // 33: iload 8
      // 35: ifne 51
      // 38: ifnull 50
      // 3b: goto 3f
      // 3e: athrow
      // 3f: aload 1
      // 40: iload 8
      // 42: ifne 5d
      // 45: goto 49
      // 48: athrow
      // 49: ifnonnull 5c
      // 4c: goto 50
      // 4f: athrow
      // 50: aload 0
      // 51: aload 1
      // 52: if_acmpne 5a
      // 55: bipush 1
      // 56: goto 5b
      // 59: athrow
      // 5a: bipush 0
      // 5b: ireturn
      // 5c: aload 0
      // 5d: invokevirtual net/minecraft/util/Session.getUsername ()Ljava/lang/String;
      // 60: iload 4
      // 62: swap
      // 63: lload 5
      // 65: invokestatic x/occ791aa07d0.Ό (ILjava/lang/String;J)Ljava/lang/String;
      // 68: aload 1
      // 69: invokevirtual net/minecraft/util/Session.getUsername ()Ljava/lang/String;
      // 6c: iload 8
      // 6e: ifne a7
      // 71: astore 7
      // 73: iload 4
      // 75: aload 7
      // 77: lload 5
      // 79: invokestatic x/occ791aa07d0.Ό (ILjava/lang/String;J)Ljava/lang/String;
      // 7c: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 7f: ifeq dc
      // 82: aload 0
      // 83: iload 8
      // 85: ifne b2
      // 88: goto 8c
      // 8b: athrow
      // 8c: invokevirtual net/minecraft/util/Session.getPlayerID ()Ljava/lang/String;
      // 8f: iload 4
      // 91: swap
      // 92: lload 5
      // 94: invokestatic x/occ791aa07d0.Ό (ILjava/lang/String;J)Ljava/lang/String;
      // 97: aload 1
      // 98: invokevirtual net/minecraft/util/Session.getPlayerID ()Ljava/lang/String;
      // 9b: iload 4
      // 9d: swap
      // 9e: lload 5
      // a0: invokestatic x/occ791aa07d0.Ό (ILjava/lang/String;J)Ljava/lang/String;
      // a3: goto a7
      // a6: athrow
      // a7: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // aa: ifeq dc
      // ad: aload 0
      // ae: goto b2
      // b1: athrow
      // b2: invokevirtual net/minecraft/util/Session.getToken ()Ljava/lang/String;
      // b5: iload 4
      // b7: swap
      // b8: lload 5
      // ba: invokestatic x/occ791aa07d0.Ό (ILjava/lang/String;J)Ljava/lang/String;
      // bd: aload 1
      // be: invokevirtual net/minecraft/util/Session.getToken ()Ljava/lang/String;
      // c1: iload 4
      // c3: swap
      // c4: lload 5
      // c6: invokestatic x/occ791aa07d0.Ό (ILjava/lang/String;J)Ljava/lang/String;
      // c9: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // cc: iload 8
      // ce: ifne d9
      // d1: ifeq dc
      // d4: goto d8
      // d7: athrow
      // d8: bipush 1
      // d9: goto dd
      // dc: bipush 0
      // dd: ireturn
   }

   private static Session ĉ(Session var0, int var1, short var2, short var3) {
      long var4 = (long)var1 << (-1185122673 ^ -1185122641)
         | (long)var2 << (-1185122657 ^ -1185122641) >>> (-1185122673 ^ -1185122641)
         | (long)var3 << (-1185122657 ^ -1185122641) >>> (-1185122657 ^ -1185122641);
      int var6 = (int)((var4 ^ 3565577138176128126L ^ 3565460698101517363L) >>> (-1185122673 ^ -1185122641));
      long var7 = (var4 ^ 3565577138176128126L ^ 3565460698101517363L) << (-1185122673 ^ -1185122641) >>> (-1185122673 ^ -1185122641);
      Type var9 = var0.getSessionType();

      String var10002;
      String var10003;
      String var10004;
      String var10005;
      label17: {
            var10002 = Ό(var6, var0.getUsername(), var7);
            var10003 = Ό(var6, var0.getPlayerID(), var7);
            var10004 = Ό(var6, var0.getToken(), var7);
            if (var9 == null) {
               var10005 = Type.LEGACY.toString();
               break label17;
            }
         var10005 = var9.toString();
      }

      return new Session(var10002, var10003, var10004, var10005);
   }

   private static String Ό(int var0, String var1, long var2) {
      long var4 = (long)var0 << (-1300829828 ^ -1300829860) | var2 << (-1300829828 ^ -1300829860) >>> (-1300829828 ^ -1300829860);
      int var6 = oc804fdd8d75.Ɔ;
      int var7 = a(-1300831027 ^ -1300829860, 7816370662380584620L ^ 2104360000791236648L ^ var4);

      while (true) {
         switch (var7) {
            case -515525283:
               int var10000;
               long var10001;
               long var10002;
               label25: {
                  if (var1 == null) {
                     var10000 = -1300824977 ^ -1300829860;
                     var10001 = 2896028960097150479L ^ 2104360000791236648L;
                     var10002 = var4;
                     if (var0 <= 0) {
                        break label25;
                     }

                     var7 = a(var10000, var10001 ^ var4);
                     if (var6 == 0) {
                        break;
                     }
                  }

                  var10000 = -1300851640 ^ -1300829860;
                  var10001 = 5628781175836528171L ^ 2104360000791236648L;
                  var10002 = var4;
               }

               var7 = a(var10000, var10001 ^ var10002);
               if (var6 == 0) {
                  break;
               }
            case -1795395017:
               return "";
            case 861829612:
               return var1;
            default:
               throw null;
         }
      }
   }

   static {
      long var0 = -7661682666929043184L ^ -7661722865897482488L;
      long[] var6 = new long[1171543628 ^ 1171543631];
      int var3 = 0;
      String var4 = "Q\u0007nL!çv´;4§\u00adÞq©}I§ß\u0006\u0080\"J\u0082";
      int var5 = "Q\u0007nL!çv´;4§\u00adÞq©}I§ß\u0006\u0080\"J\u0082".length();
      byte var2 = 0;

      do {
         int var10001 = var2;
         var2 += 8;
         byte[] var7 = var4.substring(var10001, var2).getBytes("ISO-8859-1");
         var10001 = var3++;
         long var10004 = (
               (var7[0] & (-7661722865897482249L ^ -7661722865897482488L)) << (1171543671 ^ 1171543631)
                  | (var7[1] & (-7661722865897482249L ^ -7661722865897482488L)) << (1171543679 ^ 1171543631)
                  | (var7[1171543629 ^ 1171543631] & (-7661722865897482249L ^ -7661722865897482488L)) << (1171543655 ^ 1171543631)
                  | (var7[1171543628 ^ 1171543631] & (-7661722865897482249L ^ -7661722865897482488L)) << (1171543663 ^ 1171543631)
                  | (var7[1171543627 ^ 1171543631] & (-7661722865897482249L ^ -7661722865897482488L)) << (1171543639 ^ 1171543631)
                  | (var7[1171543626 ^ 1171543631] & (-7661722865897482249L ^ -7661722865897482488L)) << (1171543647 ^ 1171543631)
                  | (var7[1171543625 ^ 1171543631] & (-7661722865897482249L ^ -7661722865897482488L)) << (1171543623 ^ 1171543631)
                  | var7[1171543624 ^ 1171543631] & (-7661722865897482249L ^ -7661722865897482488L)
            )
            ^ var0;
         byte var10003 = -1;
         var6[var10001] = var10004;
      } while (var2 < var5);

      a = var6;
      b = new Integer[1171543628 ^ 1171543631];
      Վ = Minecraft.getMinecraft();
   }

   private static int a(int var0, long var1) {
      int var3 = var0 ^ (int)(var1 & (-2702482972636128498L ^ -2702482972636142351L)) ^ 1833011688 ^ 1833032072;
      if (b[var3] == null) {
         b[var3] = (int)(a[var3] ^ var1);
      }

      return b[var3];
   }
}

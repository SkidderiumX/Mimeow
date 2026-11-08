package x;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class oc0326f6e039 {
   private static final byte[] ʊ;
   private static final byte С = 1;
   private static final int Ԋ = 12;
   private static final int ȅ = 128;
   private static final byte[] Ż;
   private static final SecureRandom ą;
   private static final Gson Б;
   private static final String[] a;
   private static final String[] b;
   private static final long[] c;
   private static final Integer[] d;

   private oc0326f6e039() {
   }

   static JsonObject È(Path var0) throws IOException {
      long var1 = 2474116473256504032L ^ 2474139793148871770L;
      long var3 = var1 ^ 2474148651276817290L ^ 2474139793148871770L;
      long var5 = var1 ^ 2474148619098253678L ^ 2474139793148871770L;
      long var7 = var1 ^ 2474080444785684138L ^ 2474139793148871770L;
      long var9 = var1 ^ 2474111916575519417L ^ 2474139793148871770L;
      byte[] var11 = Files.readAllBytes(var0);
      boolean var12 = ѓ(var11, var3);

      byte[] var10000;
      label27: {
         try {
            if (var12) {
               var10000 = ȅ(var5, var11);
               break label27;
            }
         } catch (IOException var16) {
            throw var16;
         }

         var10000 = var11;
      }

      byte[] var13 = var10000;
      JsonObject var14 = ˡ(var9, var13);

      try {
         if (!var12) {
            ʸ(var0, var7, var13);
         }

         return var14;
      } catch (IOException var15) {
         throw var15;
      }
   }

   static void Š(Path var0, JsonObject var1) throws IOException {
      long var2 = -6869282208151984195L ^ -6869385590560696313L;
      long var4 = var2 ^ -6869387020248734729L ^ -6869385590560696313L;
      ʸ(var0, var4, Б.toJson(var1).getBytes(StandardCharsets.UTF_8));
   }

   private static JsonObject ˡ(long param0, byte[] param2) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc151419fdfe.v Z
      // 003: istore 3
      // 004: new com/google/gson/JsonParser
      // 007: dup
      // 008: invokespecial com/google/gson/JsonParser.<init> ()V
      // 00b: new java/io/InputStreamReader
      // 00e: dup
      // 00f: new java/io/ByteArrayInputStream
      // 012: dup
      // 013: aload 2
      // 014: invokespecial java/io/ByteArrayInputStream.<init> ([B)V
      // 017: getstatic java/nio/charset/StandardCharsets.UTF_8 Ljava/nio/charset/Charset;
      // 01a: invokespecial java/io/InputStreamReader.<init> (Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
      // 01d: invokevirtual com/google/gson/JsonParser.parse (Ljava/io/Reader;)Lcom/google/gson/JsonElement;
      // 020: astore 4
      // 022: aload 4
      // 024: lload 0
      // 025: lconst_0
      // 026: lcmp
      // 027: iflt 037
      // 02a: iload 3
      // 02b: ifne 037
      // 02e: ifnull 045
      // 031: goto 035
      // 034: athrow
      // 035: aload 4
      // 037: iload 3
      // 038: ifne 06b
      // 03b: invokevirtual com/google/gson/JsonElement.isJsonObject ()Z
      // 03e: ifne 069
      // 041: goto 045
      // 044: athrow
      // 045: new java/io/IOException
      // 048: dup
      // 049: ldc 1931826439
      // 04b: ldc 2142545513
      // 04d: ixor
      // 04e: ldc 2142567863
      // 050: ldc 2142545513
      // 052: ixor
      // 053: isub
      // 054: ldc 1931826439
      // 056: ldc 2142545513
      // 058: ixor
      // 059: ldc 2142547705
      // 05b: ldc 2142545513
      // 05d: ixor
      // 05e: isub
      // 05f: lload 0
      // 060: l2i
      // 061: invokestatic x/oc0326f6e039.a (III)Ljava/lang/String;
      // 064: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 067: athrow
      // 068: athrow
      // 069: aload 4
      // 06b: invokevirtual com/google/gson/JsonElement.getAsJsonObject ()Lcom/google/gson/JsonObject;
      // 06e: astore 5
      // 070: aload 5
      // 072: lload 0
      // 073: lconst_0
      // 074: lcmp
      // 075: ifle 0cd
      // 078: ldc 1931826439
      // 07a: ldc 2142545513
      // 07c: ixor
      // 07d: ldc 2142567857
      // 07f: ldc 2142545513
      // 081: ixor
      // 082: isub
      // 083: ldc -1931826437
      // 085: ldc 2142545513
      // 087: ixor
      // 088: ldc -2142542124
      // 08a: ldc 2142545513
      // 08c: ixor
      // 08d: isub
      // 08e: lload 0
      // 08f: l2i
      // 090: invokestatic x/oc0326f6e039.a (III)Ljava/lang/String;
      // 093: iload 3
      // 094: ifne 0ca
      // 097: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 09a: ifeq 0d3
      // 09d: goto 0a1
      // 0a0: athrow
      // 0a1: aload 5
      // 0a3: iload 3
      // 0a4: ifne 0f9
      // 0a7: goto 0ab
      // 0aa: athrow
      // 0ab: ldc 1931826439
      // 0ad: ldc 2142545513
      // 0af: ixor
      // 0b0: ldc 2142567856
      // 0b2: ldc 2142545513
      // 0b4: ixor
      // 0b5: isub
      // 0b6: ldc -1931826437
      // 0b8: ldc 2142545513
      // 0ba: ixor
      // 0bb: ldc -2142552042
      // 0bd: ldc 2142545513
      // 0bf: ixor
      // 0c0: isub
      // 0c1: lload 0
      // 0c2: l2i
      // 0c3: invokestatic x/oc0326f6e039.a (III)Ljava/lang/String;
      // 0c6: goto 0ca
      // 0c9: athrow
      // 0ca: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 0cd: invokevirtual com/google/gson/JsonElement.isJsonArray ()Z
      // 0d0: ifne 0f7
      // 0d3: new java/io/IOException
      // 0d6: dup
      // 0d7: ldc 1931826439
      // 0d9: ldc 2142545513
      // 0db: ixor
      // 0dc: ldc 2142567846
      // 0de: ldc 2142545513
      // 0e0: ixor
      // 0e1: isub
      // 0e2: ldc 1931826439
      // 0e4: ldc 2142545513
      // 0e6: ixor
      // 0e7: ldc 2142544437
      // 0e9: ldc 2142545513
      // 0eb: ixor
      // 0ec: isub
      // 0ed: lload 0
      // 0ee: l2i
      // 0ef: invokestatic x/oc0326f6e039.a (III)Ljava/lang/String;
      // 0f2: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 0f5: athrow
      // 0f6: athrow
      // 0f7: aload 5
      // 0f9: areturn
      // 0fa: astore 4
      // 0fc: new java/io/IOException
      // 0ff: dup
      // 100: ldc 1931826439
      // 102: ldc 2142545513
      // 104: ixor
      // 105: ldc 2142567859
      // 107: ldc 2142545513
      // 109: ixor
      // 10a: isub
      // 10b: ldc 1931826439
      // 10d: ldc 2142545513
      // 10f: ixor
      // 110: ldc 2142565317
      // 112: ldc 2142545513
      // 114: ixor
      // 115: isub
      // 116: lload 0
      // 117: l2i
      // 118: invokestatic x/oc0326f6e039.a (III)Ljava/lang/String;
      // 11b: aload 4
      // 11d: invokespecial java/io/IOException.<init> (Ljava/lang/String;Ljava/lang/Throwable;)V
      // 120: athrow
   }

   private static boolean ѓ(byte[] param0, long param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc151419fdfe.v Z
      // 03: istore 3
      // 04: aload 0
      // 05: arraylength
      // 06: iload 3
      // 07: lload 1
      // 08: lconst_0
      // 09: lcmp
      // 0a: ifle 14
      // 0d: ifne 1f
      // 10: getstatic x/oc0326f6e039.ʊ [B
      // 13: arraylength
      // 14: if_icmpge 1e
      // 17: goto 1b
      // 1a: athrow
      // 1b: bipush 0
      // 1c: ireturn
      // 1d: athrow
      // 1e: bipush 0
      // 1f: istore 4
      // 21: iload 4
      // 23: getstatic x/oc0326f6e039.ʊ [B
      // 26: arraylength
      // 27: if_icmpge 5a
      // 2a: aload 0
      // 2b: iload 4
      // 2d: baload
      // 2e: iload 3
      // 2f: lload 1
      // 30: lconst_0
      // 31: lcmp
      // 32: iflt 39
      // 35: ifne 61
      // 38: iload 3
      // 39: ifne 52
      // 3c: goto 40
      // 3f: athrow
      // 40: getstatic x/oc0326f6e039.ʊ [B
      // 43: iload 4
      // 45: baload
      // 46: if_icmpeq 53
      // 49: goto 4d
      // 4c: athrow
      // 4d: bipush 0
      // 4e: goto 52
      // 51: athrow
      // 52: ireturn
      // 53: iinc 4 1
      // 56: iload 3
      // 57: ifeq 21
      // 5a: lload 1
      // 5b: lconst_1
      // 5c: lcmp
      // 5d: ifle 2a
      // 60: bipush 1
      // 61: ireturn
   }

   private static byte[] ȅ(long param0, byte[] param2) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc151419fdfe.v Z
      // 003: istore 3
      // 004: aload 2
      // 005: arraylength
      // 006: getstatic x/oc0326f6e039.ʊ [B
      // 009: arraylength
      // 00a: bipush 1
      // 00b: iadd
      // 00c: lload 0
      // 00d: lconst_0
      // 00e: lcmp
      // 00f: iflt 054
      // 012: ldc 1972777334
      // 014: ldc 1972789887
      // 016: ixor
      // 017: ldc2_w 3894897572977267930
      // 01a: ldc2_w 2204262409580383041
      // 01d: lxor
      // 01e: lload 0
      // 01f: lxor
      // 020: invokestatic x/oc0326f6e039.a (IJ)I
      // 023: iadd
      // 024: iload 3
      // 025: ifne 054
      // 028: ldc 1972774909
      // 02a: ldc 1972789887
      // 02c: ixor
      // 02d: ldc2_w 114118156979126864
      // 030: ldc2_w 2204262409580383041
      // 033: lxor
      // 034: lload 0
      // 035: lxor
      // 036: invokestatic x/oc0326f6e039.a (IJ)I
      // 039: iadd
      // 03a: if_icmplt 057
      // 03d: goto 041
      // 040: athrow
      // 041: aload 2
      // 042: getstatic x/oc0326f6e039.ʊ [B
      // 045: arraylength
      // 046: baload
      // 047: iload 3
      // 048: ifne 081
      // 04b: goto 04f
      // 04e: athrow
      // 04f: bipush 1
      // 050: goto 054
      // 053: athrow
      // 054: if_icmpeq 07b
      // 057: new java/io/IOException
      // 05a: dup
      // 05b: ldc 30665157
      // 05d: ldc 1972789887
      // 05f: ixor
      // 060: ldc 1972772113
      // 062: ldc 1972789887
      // 064: ixor
      // 065: isub
      // 066: ldc -30665159
      // 068: ldc 1972789887
      // 06a: ixor
      // 06b: ldc -1972779454
      // 06d: ldc 1972789887
      // 06f: ixor
      // 070: isub
      // 071: lload 0
      // 072: l2i
      // 073: invokestatic x/oc0326f6e039.a (III)Ljava/lang/String;
      // 076: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 079: athrow
      // 07a: athrow
      // 07b: getstatic x/oc0326f6e039.ʊ [B
      // 07e: arraylength
      // 07f: bipush 1
      // 080: iadd
      // 081: istore 4
      // 083: aload 2
      // 084: iload 4
      // 086: iload 4
      // 088: ldc 1972781438
      // 08a: ldc 1972789887
      // 08c: ixor
      // 08d: ldc2_w 4725975205934343383
      // 090: ldc2_w 2204262409580383041
      // 093: lxor
      // 094: lload 0
      // 095: lxor
      // 096: invokestatic x/oc0326f6e039.a (IJ)I
      // 099: iadd
      // 09a: invokestatic java/util/Arrays.copyOfRange ([BII)[B
      // 09d: astore 5
      // 09f: ldc 30665157
      // 0a1: ldc 1972789887
      // 0a3: ixor
      // 0a4: ldc 1972772114
      // 0a6: ldc 1972789887
      // 0a8: ixor
      // 0a9: isub
      // 0aa: ldc 30665157
      // 0ac: ldc 1972789887
      // 0ae: ixor
      // 0af: ldc 1972793850
      // 0b1: ldc 1972789887
      // 0b3: ixor
      // 0b4: isub
      // 0b5: lload 0
      // 0b6: l2i
      // 0b7: invokestatic x/oc0326f6e039.a (III)Ljava/lang/String;
      // 0ba: invokestatic javax/crypto/Cipher.getInstance (Ljava/lang/String;)Ljavax/crypto/Cipher;
      // 0bd: astore 6
      // 0bf: aload 6
      // 0c1: ldc 1972789885
      // 0c3: ldc 1972789887
      // 0c5: ixor
      // 0c6: new javax/crypto/spec/SecretKeySpec
      // 0c9: dup
      // 0ca: getstatic x/oc0326f6e039.Ż [B
      // 0cd: ldc 30665157
      // 0cf: ldc 1972789887
      // 0d1: ixor
      // 0d2: ldc 1972772115
      // 0d4: ldc 1972789887
      // 0d6: ixor
      // 0d7: isub
      // 0d8: ldc 30665157
      // 0da: ldc 1972789887
      // 0dc: ixor
      // 0dd: ldc 1972787374
      // 0df: ldc 1972789887
      // 0e1: ixor
      // 0e2: isub
      // 0e3: lload 0
      // 0e4: l2i
      // 0e5: invokestatic x/oc0326f6e039.a (III)Ljava/lang/String;
      // 0e8: invokespecial javax/crypto/spec/SecretKeySpec.<init> ([BLjava/lang/String;)V
      // 0eb: new javax/crypto/spec/GCMParameterSpec
      // 0ee: dup
      // 0ef: ldc 1972768596
      // 0f1: ldc 1972789887
      // 0f3: ixor
      // 0f4: ldc2_w 3435411485236751098
      // 0f7: ldc2_w 2204262409580383041
      // 0fa: lxor
      // 0fb: lload 0
      // 0fc: lxor
      // 0fd: invokestatic x/oc0326f6e039.a (IJ)I
      // 100: aload 5
      // 102: invokespecial javax/crypto/spec/GCMParameterSpec.<init> (I[B)V
      // 105: invokevirtual javax/crypto/Cipher.init (ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
      // 108: aload 6
      // 10a: aload 2
      // 10b: bipush 0
      // 10c: iload 4
      // 10e: invokevirtual javax/crypto/Cipher.updateAAD ([BII)V
      // 111: aload 6
      // 113: aload 2
      // 114: iload 4
      // 116: ldc 1972781438
      // 118: ldc 1972789887
      // 11a: ixor
      // 11b: ldc2_w 4725975205934343383
      // 11e: ldc2_w 2204262409580383041
      // 121: lxor
      // 122: lload 0
      // 123: lxor
      // 124: invokestatic x/oc0326f6e039.a (IJ)I
      // 127: iadd
      // 128: aload 2
      // 129: arraylength
      // 12a: iload 4
      // 12c: isub
      // 12d: ldc 1972781438
      // 12f: ldc 1972789887
      // 131: ixor
      // 132: ldc2_w 4725975205934343383
      // 135: ldc2_w 2204262409580383041
      // 138: lxor
      // 139: lload 0
      // 13a: lxor
      // 13b: invokestatic x/oc0326f6e039.a (IJ)I
      // 13e: isub
      // 13f: invokevirtual javax/crypto/Cipher.doFinal ([BII)[B
      // 142: areturn
      // 143: astore 6
      // 145: new java/io/IOException
      // 148: dup
      // 149: ldc 30665157
      // 14b: ldc 1972789887
      // 14d: ixor
      // 14e: ldc 1972772110
      // 150: ldc 1972789887
      // 152: ixor
      // 153: isub
      // 154: ldc 30665157
      // 156: ldc 1972789887
      // 158: ixor
      // 159: ldc 1972793978
      // 15b: ldc 1972789887
      // 15d: ixor
      // 15e: isub
      // 15f: lload 0
      // 160: l2i
      // 161: invokestatic x/oc0326f6e039.a (III)Ljava/lang/String;
      // 164: aload 6
      // 166: invokespecial java/io/IOException.<init> (Ljava/lang/String;Ljava/lang/Throwable;)V
      // 169: athrow
   }

   private static byte[] ǟ(byte[] var0, long var1) throws IOException {
      byte[] var3 = new byte[a(-639113345 ^ -639122306, -400551260721573479L ^ -6525271531868679414L ^ var1)];
      ą.nextBytes(var3);
      byte[] var4 = Arrays.copyOf(ʊ, ʊ.length + 1 + a(-639113345 ^ -639122306, -400551260721573479L ^ -6525271531868679414L ^ var1));
      var4[ʊ.length] = 1;
      System.arraycopy(var3, 0, var4, ʊ.length + 1, a(-639113345 ^ -639122306, -400551260721573479L ^ -6525271531868679414L ^ var1));

      try {
         Cipher var5 = Cipher.getInstance(
            a((835310508 ^ -639122306) + (639126799 ^ -639122306), (835310508 ^ -639122306) + (639129924 ^ -639122306), (int)var1)
         );
         var5.init(
            1,
            new SecretKeySpec(Ż, a((835310508 ^ -639122306) + (639126797 ^ -639122306), (-835310512 ^ -639122306) + (-639113969 ^ -639122306), (int)var1)),
            new GCMParameterSpec(a(-639132703 ^ -639122306, -4710107167240491775L ^ -6525271531868679414L ^ var1), var3)
         );
         var5.updateAAD(var4, 0, ʊ.length + 1);
         byte[] var6 = var5.doFinal(var0);
         byte[] var7 = Arrays.copyOf(var4, var4.length + var6.length);
         System.arraycopy(var6, 0, var7, var4.length, var6.length);
         return var7;
      } catch (GeneralSecurityException var8) {
         throw new IOException(a((835310508 ^ -639122306) + (639126801 ^ -639122306), (-835310512 ^ -639122306) + (-639116909 ^ -639122306), (int)var1), var8);
      }
   }

   private static void ʸ(Path var0, long var1, byte[] var3) throws IOException {
      long var4 = var1 ^ 990856513939982879L ^ 990807248492159198L;
      byte[] var6 = ǟ(var3, var4);
      Path var7 = Files.createTempFile(
         var0.getParent(),
         var0.getFileName().toString() + a((-1742064143 ^ -8147545) + (-8135028 ^ -8147545), (-1742064143 ^ -8147545) + (-8140910 ^ -8147545), (int)var1),
         a((-1742064143 ^ -8147545) + (-8135022 ^ -8147545), (-1742064143 ^ -8147545) + (char)(8129836 ^ -8147545), (int)var1)
      );

      try {
         Files.write(var7, var6);
         oc7d9b6bd5c4.ų(var7, var0);
      } finally {
         Files.deleteIfExists(var7);
      }
   }

   // $VF: Irreducible bytecode was duplicated to produce valid code
   static {
      String[] var13 = new String[-592091048 ^ -592091050];
      int var11 = 0;
      String var10 = "±¾ú[³}\u009a\u0003\u0018´j@a!»Ä\u000f\u0010s\b,wu]!Á\u0097©eu\u008d§4\u0013\\ãÕSf\u0092hóE}$C\u0092\u0084ó¼sæJ\u0011Ôñè\u0011kw®/¼\b\u00adêWU®ï¾\u0007\u0081EÜ²\u00174Q\u0003\u0089\u0097C\u0013\tÝ\u007f\u00943jÂì\u0010\u009e\u008e?Ç\u000bYM&Øà\u0007WL\u0006\u0093L\u0010:\u0011å,Îª¯\u00006Á¯ÕÏQ\u001b\"'\u0001\u008f%t\u001eJø,hµÄ\u0083\u0089\u0003Ð;m\u0000;\u0002\u00ad\u0084\u000bC\b°ÜWI\u009cC7OdÉà\nx\u0018à\u0004Öð\u0014y\u0003\u0093\u0006\u0000";
      int var12 = "±¾ú[³}\u009a\u0003\u0018´j@a!»Ä\u000f\u0010s\b,wu]!Á\u0097©eu\u008d§4\u0013\\ãÕSf\u0092hóE}$C\u0092\u0084ó¼sæJ\u0011Ôñè\u0011kw®/¼\b\u00adêWU®ï¾\u0007\u0081EÜ²\u00174Q\u0003\u0089\u0097C\u0013\tÝ\u007f\u00943jÂì\u0010\u009e\u008e?Ç\u000bYM&Øà\u0007WL\u0006\u0093L\u0010:\u0011å,Îª¯\u00006Á¯ÕÏQ\u001b\"'\u0001\u008f%t\u001eJø,hµÄ\u0083\u0089\u0003Ð;m\u0000;\u0002\u00ad\u0084\u000bC\b°ÜWI\u009cC7OdÉà\nx\u0018à\u0004Öð\u0014y\u0003\u0093\u0006\u0000"
         .length();
      int var9 = -592091042 ^ -592091050;
      int var17 = -1;

      label70:
      while (true) {
         String var10000 = var10.substring(++var17, var17 + var9);
         int var10001 = -1;

         while (true) {
            char[] var35;
            label65: {
               char[] var23 = var10000.toCharArray();
               int var10003 = var23.length;
               int var14 = 0;
               var35 = var23;
               var10001 = var10003;
               char[] var45;
               int var10004;
               if (var10003 <= 1) {
                  var45 = var23;
                  var10004 = var14;
               } else {
                  var35 = var23;
                  var10001 = var10003;
                  if (var10003 <= var14) {
                     break label65;
                  }

                  var45 = var23;
                  var10004 = var14;
               }

               while (true) {
                  var45[var10004] = (char)(var45[var10004] ^ switch (var14 % (-592091055 ^ -592091050)) {
                     case 0 -> -592091108 ^ -592091050;
                     case 1 -> -592091119 ^ -592091050;
                     case 2 -> 1;
                     case 3 -> -592091053 ^ -592091050;
                     case 4 -> -592091010 ^ -592091050;
                     case 5 -> -592091094 ^ -592091050;
                     default -> -592091022 ^ -592091050;
                  });
                  var14++;
                  if (var10001 == 0) {
                     var10004 = var10001;
                     var45 = var35;
                  } else {
                     if (var10001 <= var14) {
                        break;
                     }

                     var45 = var35;
                     var10004 = var14;
                  }
               }
            }

            String var52 = new String(var35).intern();
            switch (var10001) {
               case 0:
                  var13[var11++] = var52;
                  if ((var17 += var9) >= var12) {
                     a = var13;
                     b = new String[-592091048 ^ -592091050];
                     long var0 = 5610797407782418217L ^ 5610908350470106145L;
                     long[] var6 = new long[-592091053 ^ -592091050];
                     int var3 = 0;
                     String var4 = "sÁõk\u0084ÜÑ\u00879Øzü\u0094\"G\u0011\u0003*¿\u0003Ö0Ë\b";
                     int var5 = "sÁõk\u0084ÜÑ\u00879Øzü\u0094\"G\u0011\u0003*¿\u0003Ö0Ë\b".length();
                     byte var2 = 0;

                     label44:
                     while (true) {
                        int var30 = var2;
                        var2 += 8;
                        byte[] var7 = var4.substring(var30, var2).getBytes("ISO-8859-1");
                        long[] var19 = var6;
                        var30 = var3++;
                        long var41 = (var7[0] & (5610908350470106334L ^ 5610908350470106145L)) << (-592091026 ^ -592091050)
                           | (var7[1] & (5610908350470106334L ^ 5610908350470106145L)) << (-592091034 ^ -592091050)
                           | (var7[-592091052 ^ -592091050] & (5610908350470106334L ^ 5610908350470106145L)) << (-592091010 ^ -592091050)
                           | (var7[-592091051 ^ -592091050] & (5610908350470106334L ^ 5610908350470106145L)) << (-592091018 ^ -592091050)
                           | (var7[-592091054 ^ -592091050] & (5610908350470106334L ^ 5610908350470106145L)) << (-592091058 ^ -592091050)
                           | (var7[-592091053 ^ -592091050] & (5610908350470106334L ^ 5610908350470106145L)) << (-592091066 ^ -592091050)
                           | (var7[-592091056 ^ -592091050] & (5610908350470106334L ^ 5610908350470106145L)) << (-592091042 ^ -592091050)
                           | var7[-592091055 ^ -592091050] & (5610908350470106334L ^ 5610908350470106145L);
                        byte var53 = -1;

                        while (true) {
                           long var56 = var41 ^ var0;
                           switch (var53) {
                              case 0:
                                 var19[var30] = var56;
                                 if (var2 >= var5) {
                                    c = var6;
                                    d = new Integer[-592091053 ^ -592091050];
                                    byte[] var20 = new byte[-592091055 ^ -592091050];
                                    var20[0] = (byte)(-592091109 ^ -592091050);
                                    var20[1] = (byte)(-592091105 ^ -592091050);
                                    var20[-592091052 ^ -592091050] = (byte)(-592091113 ^ -592091050);
                                    var20[-592091051 ^ -592091050] = (byte)(-592091133 ^ -592091050);
                                    var20[-592091054 ^ -592091050] = (byte)(-592091115 ^ -592091050);
                                    var20[-592091053 ^ -592091050] = (byte)(-592091120 ^ -592091050);
                                    var20[-592091056 ^ -592091050] = (byte)(-592091119 ^ -592091050);
                                    ʊ = var20;
                                    byte[] var21 = new byte[-592091066 ^ -592091050];
                                    var21[0] = (byte)(592091123 ^ -592091050);
                                    var21[1] = (byte)(-592091072 ^ -592091050);
                                    var21[-592091052 ^ -592091050] = (byte)(592091038 ^ -592091050);
                                    var21[-592091051 ^ -592091050] = (byte)(-592091031 ^ -592091050);
                                    var21[-592091054 ^ -592091050] = (byte)(-592091097 ^ -592091050);
                                    var21[-592091053 ^ -592091050] = (byte)(592091010 ^ -592091050);
                                    var21[-592091056 ^ -592091050] = (byte)(-592091041 ^ -592091050);
                                    var21[-592091055 ^ -592091050] = (byte)(592091112 ^ -592091050);
                                    var21[-592091042 ^ -592091050] = (byte)(-592091132 ^ -592091050);
                                    var21[-592091041 ^ -592091050] = (byte)(592091057 ^ -592091050);
                                    var21[-592091044 ^ -592091050] = (byte)(-592091074 ^ -592091050);
                                    var21[-592091043 ^ -592091050] = (byte)(-592091060 ^ -592091050);
                                    var21[-592091046 ^ -592091050] = (byte)(592091078 ^ -592091050);
                                    var21[-592091045 ^ -592091050] = (byte)(-592091107 ^ -592091050);
                                    var21[-592091048 ^ -592091050] = (byte)(592091045 ^ -592091050);
                                    var21[-592091047 ^ -592091050] = (byte)(-592091013 ^ -592091050);
                                    Ż = var21;
                                    ą = new SecureRandom();
                                    Б = new GsonBuilder().setPrettyPrinting().create();
                                    return;
                                 }
                                 break;
                              default:
                                 var19[var30] = var56;
                                 if (var2 < var5) {
                                    continue label44;
                                 }

                                 var4 = "÷êxì' y½]£\u0000úbð7\u001c";
                                 var5 = "÷êxì' y½]£\u0000úbð7\u001c".length();
                                 var2 = 0;
                           }

                           byte var32 = var2;
                           var2 += 8;
                           var7 = var4.substring(var32, var2).getBytes("ISO-8859-1");
                           var19 = var6;
                           var30 = var3++;
                           var41 = (var7[0] & (5610908350470106334L ^ 5610908350470106145L)) << (-592091026 ^ -592091050)
                              | (var7[1] & (5610908350470106334L ^ 5610908350470106145L)) << (-592091034 ^ -592091050)
                              | (var7[-592091052 ^ -592091050] & (5610908350470106334L ^ 5610908350470106145L)) << (-592091010 ^ -592091050)
                              | (var7[-592091051 ^ -592091050] & (5610908350470106334L ^ 5610908350470106145L)) << (-592091018 ^ -592091050)
                              | (var7[-592091054 ^ -592091050] & (5610908350470106334L ^ 5610908350470106145L)) << (-592091058 ^ -592091050)
                              | (var7[-592091053 ^ -592091050] & (5610908350470106334L ^ 5610908350470106145L)) << (-592091066 ^ -592091050)
                              | (var7[-592091056 ^ -592091050] & (5610908350470106334L ^ 5610908350470106145L)) << (-592091042 ^ -592091050)
                              | var7[-592091055 ^ -592091050] & (5610908350470106334L ^ 5610908350470106145L);
                           var53 = 0;
                        }
                     }
                  }

                  var9 = var10.charAt(var17);
                  break;
               default:
                  var13[var11++] = var52;
                  if ((var17 += var9) < var12) {
                     var9 = var10.charAt(var17);
                     continue label70;
                  }

                  var10 = "*Û\u0093W[}\u008b×ùh4DÑ\u0012\u0089Í[\núÖ\u001fûêú\u0016PÖTõVFni\u0085.<)\u0091É\u0093\u001cqÊÑ\u0001¥w";
                  var12 = "*Û\u0093W[}\u008b×ùh4DÑ\u0012\u0089Í[\núÖ\u001fûêú\u0016PÖTõVFni\u0085.<)\u0091É\u0093\u001cqÊÑ\u0001¥w".length();
                  var9 = -592091058 ^ -592091050;
                  var17 = -1;
            }

            var10000 = var10.substring(++var17, var17 + var9);
            var10001 = 0;
         }
      }
   }

   private static String a(int var0, int var1, int var2) {
      int var3 = (var0 ^ var2 ^ -1246386296 ^ 1246373955) & (1246418876 ^ 1246373955);
      if (b[var3] == null) {
         char[] var4 = a[var3].toCharArray();

         int var5 = switch (var4[0] & (1246374076 ^ 1246373955)) {
            case 0 -> 1246374066 ^ 1246373955;
            case 1 -> 1246374090 ^ 1246373955;
            case 2 -> 1246374009 ^ 1246373955;
            case 3 -> 1246374050 ^ 1246373955;
            case 4 -> 1246374012 ^ 1246373955;
            case 5 -> 1246374060 ^ 1246373955;
            case 6 -> 1246373906 ^ 1246373955;
            case 7 -> 1246374109 ^ 1246373955;
            case 8 -> 1246373929 ^ 1246373955;
            case 9 -> 1246374002 ^ 1246373955;
            case 10 -> 1246374021 ^ 1246373955;
            case 11 -> 1246374081 ^ 1246373955;
            case 12 -> 1246374112 ^ 1246373955;
            case 13 -> 1246374003 ^ 1246373955;
            case 14 -> 1246373984 ^ 1246373955;
            case 15 -> 1246373909 ^ 1246373955;
            case 16 -> 1246374083 ^ 1246373955;
            case 17 -> 1246373959 ^ 1246373955;
            case 18 -> 1246374085 ^ 1246373955;
            case 19 -> 1246373937 ^ 1246373955;
            case 20 -> 1246374056 ^ 1246373955;
            case 21 -> 1246374111 ^ 1246373955;
            case 22 -> 1246373995 ^ 1246373955;
            case 23 -> 1246373979 ^ 1246373955;
            case 24 -> 1246374099 ^ 1246373955;
            case 25 -> 1246374102 ^ 1246373955;
            case 26 -> 1246374075 ^ 1246373955;
            case 27 -> 1246373912 ^ 1246373955;
            case 28 -> 1246373927 ^ 1246373955;
            case 29 -> 1246374041 ^ 1246373955;
            case 30 -> 1246374108 ^ 1246373955;
            case 31 -> 1246373940 ^ 1246373955;
            case 32 -> 1246374014 ^ 1246373955;
            case 33 -> 1246373913 ^ 1246373955;
            case 34 -> 1246373926 ^ 1246373955;
            case 35 -> 1246374073 ^ 1246373955;
            case 36 -> 1246374113 ^ 1246373955;
            case 37 -> 1246373978 ^ 1246373955;
            case 38 -> 1246373988 ^ 1246373955;
            case 39 -> 1246374059 ^ 1246373955;
            case 40 -> 1246374057 ^ 1246373955;
            case 41 -> 1246373997 ^ 1246373955;
            case 42 -> 1246373947 ^ 1246373955;
            case 43 -> 1246374067 ^ 1246373955;
            case 44 -> 1246374023 ^ 1246373955;
            case 45 -> 1246374008 ^ 1246373955;
            case 46 -> 1246374135 ^ 1246373955;
            case 47 -> 1246374024 ^ 1246373955;
            case 48 -> 1246374128 ^ 1246373955;
            case 49 -> 1246374033 ^ 1246373955;
            case 50 -> 1246374058 ^ 1246373955;
            case 51 -> 1246373888 ^ 1246373955;
            case 52 -> 1246373962 ^ 1246373955;
            case 53 -> 1246374137 ^ 1246373955;
            case 54 -> 1246374089 ^ 1246373955;
            case 55 -> 1246374115 ^ 1246373955;
            case 56 -> 1246374015 ^ 1246373955;
            case 57 -> 1246374000 ^ 1246373955;
            case 58 -> 1246373904 ^ 1246373955;
            case 59 -> 1246374031 ^ 1246373955;
            case 60 -> 1246374044 ^ 1246373955;
            case 61 -> 1246373925 ^ 1246373955;
            case 62 -> 1246373983 ^ 1246373955;
            case 63 -> 1246373981 ^ 1246373955;
            case 64 -> 1246373935 ^ 1246373955;
            case 65 -> 1246374132 ^ 1246373955;
            case 66 -> 1246374037 ^ 1246373955;
            case 67 -> 1246374098 ^ 1246373955;
            case 68 -> 1246373971 ^ 1246373955;
            case 69 -> 1246374032 ^ 1246373955;
            case 70 -> 1246373933 ^ 1246373955;
            case 71 -> 1246374061 ^ 1246373955;
            case 72 -> 1246373986 ^ 1246373955;
            case 73 -> 1246374070 ^ 1246373955;
            case 74 -> 1246374022 ^ 1246373955;
            case 75 -> 1246374004 ^ 1246373955;
            case 76 -> 1246374139 ^ 1246373955;
            case 77 -> 1246373972 ^ 1246373955;
            case 78 -> 1246373968 ^ 1246373955;
            case 79 -> 1246373969 ^ 1246373955;
            case 80 -> 1246374069 ^ 1246373955;
            case 81 -> 1246374076 ^ 1246373955;
            case 82 -> 1246374116 ^ 1246373955;
            case 83 -> 1246373939 ^ 1246373955;
            case 84 -> 1246374077 ^ 1246373955;
            case 85 -> 1246374092 ^ 1246373955;
            case 86 -> 1246374125 ^ 1246373955;
            case 87 -> 1246373908 ^ 1246373955;
            case 88 -> 1246374040 ^ 1246373955;
            case 89 -> 1246373924 ^ 1246373955;
            case 90 -> 1246374117 ^ 1246373955;
            case 91 -> 1246374140 ^ 1246373955;
            case 92 -> 1246374062 ^ 1246373955;
            case 93 -> 1246374091 ^ 1246373955;
            case 94 -> 1246373952 ^ 1246373955;
            case 95 -> 1246373958 ^ 1246373955;
            case 96 -> 1246373957 ^ 1246373955;
            case 97 -> 1246374138 ^ 1246373955;
            case 98 -> 1246373994 ^ 1246373955;
            case 99 -> 1246374103 ^ 1246373955;
            case 100 -> 1246374130 ^ 1246373955;
            case 101 -> 1246374051 ^ 1246373955;
            case 102 -> 1246374046 ^ 1246373955;
            case 103 -> 1246373898 ^ 1246373955;
            case 104 -> 1246374043 ^ 1246373955;
            case 105 -> 1246373996 ^ 1246373955;
            case 106 -> 1246374042 ^ 1246373955;
            case 107 -> 1246374133 ^ 1246373955;
            case 108 -> 1246374055 ^ 1246373955;
            case 109 -> 1246374105 ^ 1246373955;
            case 110 -> 1246374048 ^ 1246373955;
            case 111 -> 1246374110 ^ 1246373955;
            case 112 -> 1246373944 ^ 1246373955;
            case 113 -> 1246374038 ^ 1246373955;
            case 114 -> 1246373920 ^ 1246373955;
            case 115 -> 1246373916 ^ 1246373955;
            case 116 -> 1246374096 ^ 1246373955;
            case 117 -> 1246374072 ^ 1246373955;
            case 118 -> 1246374005 ^ 1246373955;
            case 119 -> 1246374080 ^ 1246373955;
            case 120 -> 1246373918 ^ 1246373955;
            case 121 -> 1246373896 ^ 1246373955;
            case 122 -> 1246374045 ^ 1246373955;
            case 123 -> 1246373899 ^ 1246373955;
            case 124 -> 1246374095 ^ 1246373955;
            case 125 -> 1246373977 ^ 1246373955;
            case 126 -> 1246374019 ^ 1246373955;
            case 127 -> 1246373980 ^ 1246373955;
            case 128 -> 1246374088 ^ 1246373955;
            case 129 -> 1246373966 ^ 1246373955;
            case 130 -> 1246373917 ^ 1246373955;
            case 131 -> 1246373970 ^ 1246373955;
            case 132 -> 1246373923 ^ 1246373955;
            case 133 -> 1246374118 ^ 1246373955;
            case 134 -> 1246373942 ^ 1246373955;
            case 135 -> 1246374082 ^ 1246373955;
            case 136 -> 1;
            case 137 -> 1246374086 ^ 1246373955;
            case 138 -> 1246373999 ^ 1246373955;
            case 139 -> 1246373943 ^ 1246373955;
            case 140 -> 1246373900 ^ 1246373955;
            case 141 -> 1246373914 ^ 1246373955;
            case 142 -> 1246373911 ^ 1246373955;
            case 143 -> 1246374141 ^ 1246373955;
            case 144 -> 1246373961 ^ 1246373955;
            case 145 -> 1246374029 ^ 1246373955;
            case 146 -> 1246374093 ^ 1246373955;
            case 147 -> 1246374025 ^ 1246373955;
            case 148 -> 1246374001 ^ 1246373955;
            case 149 -> 1246374018 ^ 1246373955;
            case 150 -> 1246373922 ^ 1246373955;
            case 151 -> 1246373948 ^ 1246373955;
            case 152 -> 1246374016 ^ 1246373955;
            case 153 -> 1246374035 ^ 1246373955;
            case 154 -> 1246373973 ^ 1246373955;
            case 155 -> 1246374120 ^ 1246373955;
            case 156 -> 1246374074 ^ 1246373955;
            case 157 -> 1246373894 ^ 1246373955;
            case 158 -> 1246374123 ^ 1246373955;
            case 159 -> 1246374006 ^ 1246373955;
            case 160 -> 1246373893 ^ 1246373955;
            case 161 -> 1246374126 ^ 1246373955;
            case 162 -> 1246373930 ^ 1246373955;
            case 163 -> 1246373965 ^ 1246373955;
            case 164 -> 0;
            case 165 -> 1246374121 ^ 1246373955;
            case 166 -> 1246373938 ^ 1246373955;
            case 167 -> 1246373931 ^ 1246373955;
            case 168 -> 1246374049 ^ 1246373955;
            case 169 -> 1246373992 ^ 1246373955;
            case 170 -> 1246373960 ^ 1246373955;
            case 171 -> 1246373964 ^ 1246373955;
            case 172 -> 1246373905 ^ 1246373955;
            case 173 -> 1246374122 ^ 1246373955;
            case 174 -> 1246374065 ^ 1246373955;
            case 175 -> 1246374030 ^ 1246373955;
            case 176 -> 1246373903 ^ 1246373955;
            case 177 -> 1246374101 ^ 1246373955;
            case 178 -> 1246374104 ^ 1246373955;
            case 179 -> 1246374039 ^ 1246373955;
            case 180 -> 1246374011 ^ 1246373955;
            case 181 -> 1246373915 ^ 1246373955;
            case 182 -> 1246373928 ^ 1246373955;
            case 183 -> 1246373902 ^ 1246373955;
            case 184 -> 1246373919 ^ 1246373955;
            case 185 -> 1246374142 ^ 1246373955;
            case 186 -> 1246374036 ^ 1246373955;
            case 187 -> 1246374026 ^ 1246373955;
            case 188 -> 1246373963 ^ 1246373955;
            case 189 -> 1246373989 ^ 1246373955;
            case 190 -> 1246374078 ^ 1246373955;
            case 191 -> 1246374106 ^ 1246373955;
            case 192 -> 1246374010 ^ 1246373955;
            case 193 -> 1246374119 ^ 1246373955;
            case 194 -> 1246374079 ^ 1246373955;
            case 195 -> 1246374097 ^ 1246373955;
            case 196 -> 1246374064 ^ 1246373955;
            case 197 -> 1246374068 ^ 1246373955;
            case 198 -> 1246374107 ^ 1246373955;
            case 199 -> 1246374131 ^ 1246373955;
            case 200 -> 1246373976 ^ 1246373955;
            case 201 -> 1246373974 ^ 1246373955;
            case 202 -> 1246374094 ^ 1246373955;
            case 203 -> 1246374053 ^ 1246373955;
            case 204 -> 1246374100 ^ 1246373955;
            case 205 -> 1246374129 ^ 1246373955;
            case 206 -> 1246373892 ^ 1246373955;
            case 207 -> 1246374114 ^ 1246373955;
            case 208 -> 1246374034 ^ 1246373955;
            case 209 -> 1246373991 ^ 1246373955;
            case 210 -> 1246373941 ^ 1246373955;
            case 211 -> 1246373945 ^ 1246373955;
            case 212 -> 1246373949 ^ 1246373955;
            case 213 -> 1246373890 ^ 1246373955;
            case 214 -> 1246374136 ^ 1246373955;
            case 215 -> 1246373891 ^ 1246373955;
            case 216 -> 1246373967 ^ 1246373955;
            case 217 -> 1246374028 ^ 1246373955;
            case 218 -> 1246374017 ^ 1246373955;
            case 219 -> 1246374020 ^ 1246373955;
            case 220 -> 1246374124 ^ 1246373955;
            case 221 -> 1246373897 ^ 1246373955;
            case 222 -> 1246373889 ^ 1246373955;
            case 223 -> 1246374127 ^ 1246373955;
            case 224 -> 1246373910 ^ 1246373955;
            case 225 -> 1246373998 ^ 1246373955;
            case 226 -> 1246374052 ^ 1246373955;
            case 227 -> 1246373921 ^ 1246373955;
            case 228 -> 1246373934 ^ 1246373955;
            case 229 -> 1246373932 ^ 1246373955;
            case 230 -> 1246373950 ^ 1246373955;
            case 231 -> 1246373936 ^ 1246373955;
            case 232 -> 1246373975 ^ 1246373955;
            case 233 -> 1246373953 ^ 1246373955;
            case 234 -> 1246374027 ^ 1246373955;
            case 235 -> 1246373907 ^ 1246373955;
            case 236 -> 1246373901 ^ 1246373955;
            case 237 -> 1246373946 ^ 1246373955;
            case 238 -> 1246374047 ^ 1246373955;
            case 239 -> 1246374007 ^ 1246373955;
            case 240 -> 1246374084 ^ 1246373955;
            case 241 -> 1246374071 ^ 1246373955;
            case 242 -> 1246373985 ^ 1246373955;
            case 243 -> 1246374013 ^ 1246373955;
            case 244 -> 1246373990 ^ 1246373955;
            case 245 -> 1246374087 ^ 1246373955;
            case 246 -> 1246373987 ^ 1246373955;
            case 247 -> 1246373982 ^ 1246373955;
            case 248 -> 1246373993 ^ 1246373955;
            case 249 -> 1246373956 ^ 1246373955;
            case 250 -> 1246374134 ^ 1246373955;
            case 251 -> 1246374063 ^ 1246373955;
            case 252 -> 1246373895 ^ 1246373955;
            case 253 -> 1246374143 ^ 1246373955;
            case 254 -> 1246374054 ^ 1246373955;
            default -> 1246373951 ^ 1246373955;
         };
         int var10;
         int var6 = ((var10 = var1 ^ var2) & (1246374076 ^ 1246373955)) - var5;
         if (var6 < 0) {
            var6 += 256;
         }

         int var7 = ((var10 & (1246418876 ^ 1246373955)) >>> (1246373963 ^ 1246373955)) - var5;
         if (var7 < 0) {
            var7 += 256;
         }

         for (int var8 = 0; var8 < var4.length; var8++) {
            int var9 = var8 % (1246373953 ^ 1246373955);
            char var10002 = var4[var8];
            if (var9 == 0) {
               var4[var8] = (char)(var10002 ^ var6);
               var6 = ((var6 >>> (1246373952 ^ 1246373955) | var6 << (1246373958 ^ 1246373955)) ^ var4[var8]) & (1246374076 ^ 1246373955);
            } else {
               var4[var8] = (char)(var10002 ^ var7);
               var7 = ((var7 >>> (1246373952 ^ 1246373955) | var7 << (1246373958 ^ 1246373955)) ^ var4[var8]) & (1246374076 ^ 1246373955);
            }
         }

         b[var3] = new String(var4).intern();
      }

      return b[var3];
   }

   private static int a(int var0, long var1) {
      int var3 = var0 ^ (int)(var1 & (7209532906364209294L ^ 7209532906364237681L)) ^ -413393258 ^ -413396597;
      if (d[var3] == null) {
         d[var3] = (int)(c[var3] ^ var1);
      }

      return d[var3];
   }
}

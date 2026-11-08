package x;

import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.Collection;
import java.util.Random;

public class oc499a9670c8 {
   private static final String Z = "https://randomapi.dev/api/names?count=1";
   private static final String ό = "https://randomuser.me/api/?inc=name";
   private static final int ӽ = 4000;
   private static final int Ω = 5000;
   private static final int ɧ = 16;
   private static final int π = 3;
   private static final Random ȁ;
   public static boolean ӿ;
   private static final String a;
   private static final long[] b;
   private static final Integer[] c;

   private oc499a9670c8() {
   }

   public static String ͻ(Collection<oc804fdd8d75> param0) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: new java/util/ArrayList
      // 03: dup
      // 04: invokestatic x/oced349c95c3.values ()[Lx/oced349c95c3;
      // 07: invokestatic java/util/Arrays.asList ([Ljava/lang/Object;)Ljava/util/List;
      // 0a: invokespecial java/util/ArrayList.<init> (Ljava/util/Collection;)V
      // 0d: astore 2
      // 0e: aload 2
      // 0f: getstatic x/oc499a9670c8.ȁ Ljava/util/Random;
      // 12: invokestatic java/util/Collections.shuffle (Ljava/util/List;Ljava/util/Random;)V
      // 15: getstatic x/oc804fdd8d75.Ɔ I
      // 18: aconst_null
      // 19: astore 3
      // 1a: aload 2
      // 1b: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 20: astore 4
      // 22: istore 1
      // 23: aload 4
      // 25: iload 1
      // 26: ifne 40
      // 29: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 2e: ifeq 55
      // 31: goto 35
      // 34: athrow
      // 35: aload 4
      // 37: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 3c: goto 40
      // 3f: athrow
      // 40: checkcast x/oced349c95c3
      // 43: astore 5
      // 45: aload 5
      // 47: aload 0
      // 48: invokevirtual x/oced349c95c3.Ȉ (Ljava/util/Collection;)Ljava/lang/String;
      // 4b: areturn
      // 4c: astore 6
      // 4e: iload 1
      // 4f: aload 6
      // 51: astore 3
      // 52: ifeq 23
      // 55: aload 3
      // 56: iload 1
      // 57: ifne 62
      // 5a: ifnull 65
      // 5d: goto 61
      // 60: athrow
      // 61: aload 3
      // 62: goto 6e
      // 65: new java/io/IOException
      // 68: dup
      // 69: ldc "No username source is available"
      // 6b: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 6e: athrow
   }

   private static String ŗ(long var0, JsonObject var2, String var3) {
      int var4 = oc804fdd8d75.Ɔ;
      int var5 = a(-1085253021 ^ -1085269192, 5990643189674385263L ^ 1091962636003266136L ^ var0);

      label91:
      while (true) {
         int var10000 = var5;

         while (true) {
            switch (var10000) {
               case -2115732600:
                  long var13;
                  long var10002;
                  label86: {
                     if (var2 != null) {
                        var10000 = -1085265026 ^ -1085269192;
                        var13 = 4809545798027112057L ^ 1091962636003266136L;
                        var10002 = var0;
                        if (var0 < 0L) {
                           break label86;
                        }

                        var5 = a(var10000, var13 ^ var0);
                        if (var4 == 0) {
                           continue label91;
                        }
                     }

                     var10000 = -1085253726 ^ -1085269192;
                     var13 = 2849763484215415468L ^ 1091962636003266136L;
                     var10002 = var0;
                  }

                  var10000 = a(var10000, var13 ^ var10002);
                  if (var0 <= 0L) {
                     break;
                  }

                  var5 = var10000;
                  if (var4 == 0) {
                     continue label91;
                  }
               case -1119800381:
                  return var2.get(var3).getAsString();
               case -913729354:
                  return "";
               case -297842376:
                  label78: {
                     label94: {
                        label76: {
                           label75: {
                              label95: {
                                 try {
                                    var10000 = var2.has(var3);
                                    if (var0 <= 0L) {
                                       break label94;
                                    }

                                    if (var4 != 0) {
                                       break label76;
                                    }

                                    if (var10000 == 0) {
                                       break label95;
                                    }
                                 } catch (ocbde1165e4e var7) {
                                    throw var7;
                                 }

                                 var10000 = -1085262092 ^ -1085269192;
                                 if (var0 <= 0L) {
                                    break label75;
                                 }

                                 var5 = a(var10000, 4180335129852113917L ^ 1091962636003266136L ^ var0);
                                 if (var4 == 0) {
                                    continue label91;
                                 }
                              }

                              var10000 = -1085271731 ^ -1085269192;
                           }

                           var10000 = a(var10000, 3061176395742630990L ^ 1091962636003266136L ^ var0);
                        }

                        var5 = var10000;
                        if (var0 <= 1L) {
                           break label78;
                        }

                        var10000 = var4;
                     }

                     if (var10000 == 0) {
                        continue label91;
                     }
                  }
               case 158904038:
                  label57: {
                     long var10001;
                     label56: {
                        label93: {
                           try {
                              var10000 = var2.get(var3).isJsonNull();
                              if (var4 != 0) {
                                 break label57;
                              }

                              if (var10000 == 0) {
                                 break label93;
                              }
                           } catch (ocbde1165e4e var6) {
                              throw var6;
                           }

                           var10000 = -1085271731 ^ -1085269192;
                           var10001 = 3061176395742630990L ^ 1091962636003266136L ^ var0;
                           if (var0 <= 1L) {
                              break label56;
                           }

                           var5 = a(var10000, var10001);
                           if (var4 == 0) {
                              continue label91;
                           }
                        }

                        var10000 = -1085264191 ^ -1085269192;
                        var10001 = 994487078855666634L ^ 1091962636003266136L ^ var0;
                     }

                     var10000 = a(var10000, var10001);
                  }

                  var5 = var10000;
                  continue label91;
               default:
                  throw null;
            }
         }
      }
   }

   private static String ϔ(long param0, String param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: new java/lang/StringBuilder
      // 003: dup
      // 004: invokespecial java/lang/StringBuilder.<init> ()V
      // 007: astore 4
      // 009: getstatic x/oc804fdd8d75.Ɔ I
      // 00c: bipush 0
      // 00d: istore 5
      // 00f: istore 3
      // 010: iload 5
      // 012: aload 2
      // 013: invokevirtual java/lang/String.length ()I
      // 016: if_icmpge 17d
      // 019: aload 2
      // 01a: iload 3
      // 01b: lload 0
      // 01c: lconst_1
      // 01d: lcmp
      // 01e: iflt 026
      // 021: ifne 182
      // 024: iload 5
      // 026: invokevirtual java/lang/String.charAt (I)C
      // 029: istore 6
      // 02b: iload 6
      // 02d: iload 3
      // 02e: lload 0
      // 02f: lconst_0
      // 030: lcmp
      // 031: iflt 048
      // 034: ifne 07d
      // 037: ldc -261618922
      // 039: ldc -261612855
      // 03b: ixor
      // 03c: ldc2_w -4826554405998761118
      // 03f: ldc2_w -2442922837449118507
      // 042: lxor
      // 043: lload 0
      // 044: lxor
      // 045: invokestatic x/oc499a9670c8.a (IJ)I
      // 048: if_icmplt 077
      // 04b: goto 04f
      // 04e: athrow
      // 04f: iload 6
      // 051: lload 0
      // 052: lconst_1
      // 053: lcmp
      // 054: ifle 07d
      // 057: iload 3
      // 058: ifne 07d
      // 05b: goto 05f
      // 05e: athrow
      // 05f: ldc -261588184
      // 061: ldc -261612855
      // 063: ixor
      // 064: ldc2_w -6070682142738476206
      // 067: ldc2_w -2442922837449118507
      // 06a: lxor
      // 06b: lload 0
      // 06c: lxor
      // 06d: invokestatic x/oc499a9670c8.a (IJ)I
      // 070: if_icmple 13f
      // 073: goto 077
      // 076: athrow
      // 077: iload 6
      // 079: goto 07d
      // 07c: athrow
      // 07d: iload 3
      // 07e: lload 0
      // 07f: lconst_1
      // 080: lcmp
      // 081: iflt 098
      // 084: ifne 0cd
      // 087: ldc -261604051
      // 089: ldc -261612855
      // 08b: ixor
      // 08c: ldc2_w -3445119905776249515
      // 08f: ldc2_w -2442922837449118507
      // 092: lxor
      // 093: lload 0
      // 094: lxor
      // 095: invokestatic x/oc499a9670c8.a (IJ)I
      // 098: if_icmplt 0c7
      // 09b: goto 09f
      // 09e: athrow
      // 09f: iload 6
      // 0a1: lload 0
      // 0a2: lconst_0
      // 0a3: lcmp
      // 0a4: iflt 0cd
      // 0a7: iload 3
      // 0a8: ifne 0cd
      // 0ab: goto 0af
      // 0ae: athrow
      // 0af: ldc -261618744
      // 0b1: ldc -261612855
      // 0b3: ixor
      // 0b4: ldc2_w -8405988131578090565
      // 0b7: ldc2_w -2442922837449118507
      // 0ba: lxor
      // 0bb: lload 0
      // 0bc: lxor
      // 0bd: invokestatic x/oc499a9670c8.a (IJ)I
      // 0c0: if_icmple 13f
      // 0c3: goto 0c7
      // 0c6: athrow
      // 0c7: iload 6
      // 0c9: goto 0cd
      // 0cc: athrow
      // 0cd: iload 3
      // 0ce: lload 0
      // 0cf: lconst_1
      // 0d0: lcmp
      // 0d1: ifle 0e8
      // 0d4: ifne 11d
      // 0d7: ldc -261615279
      // 0d9: ldc -261612855
      // 0db: ixor
      // 0dc: ldc2_w -3448149681226876626
      // 0df: ldc2_w -2442922837449118507
      // 0e2: lxor
      // 0e3: lload 0
      // 0e4: lxor
      // 0e5: invokestatic x/oc499a9670c8.a (IJ)I
      // 0e8: if_icmplt 117
      // 0eb: goto 0ef
      // 0ee: athrow
      // 0ef: iload 6
      // 0f1: lload 0
      // 0f2: lconst_0
      // 0f3: lcmp
      // 0f4: iflt 11d
      // 0f7: iload 3
      // 0f8: ifne 11d
      // 0fb: goto 0ff
      // 0fe: athrow
      // 0ff: ldc -261591966
      // 101: ldc -261612855
      // 103: ixor
      // 104: ldc2_w -7662959251645201387
      // 107: ldc2_w -2442922837449118507
      // 10a: lxor
      // 10b: lload 0
      // 10c: lxor
      // 10d: invokestatic x/oc499a9670c8.a (IJ)I
      // 110: if_icmple 13f
      // 113: goto 117
      // 116: athrow
      // 117: iload 6
      // 119: goto 11d
      // 11c: athrow
      // 11d: iload 3
      // 11e: lload 0
      // 11f: lconst_0
      // 120: lcmp
      // 121: iflt 161
      // 124: ifne 150
      // 127: ldc -261619403
      // 129: ldc -261612855
      // 12b: ixor
      // 12c: ldc2_w -4947327773418165944
      // 12f: ldc2_w -2442922837449118507
      // 132: lxor
      // 133: lload 0
      // 134: lxor
      // 135: invokestatic x/oc499a9670c8.a (IJ)I
      // 138: if_icmpne 14b
      // 13b: goto 13f
      // 13e: athrow
      // 13f: aload 4
      // 141: iload 6
      // 143: invokevirtual java/lang/StringBuilder.append (C)Ljava/lang/StringBuilder;
      // 146: pop
      // 147: goto 14b
      // 14a: athrow
      // 14b: aload 4
      // 14d: invokevirtual java/lang/StringBuilder.length ()I
      // 150: ldc -261590931
      // 152: ldc -261612855
      // 154: ixor
      // 155: ldc2_w -7409158823182788584
      // 158: ldc2_w -2442922837449118507
      // 15b: lxor
      // 15c: lload 0
      // 15d: lxor
      // 15e: invokestatic x/oc499a9670c8.a (IJ)I
      // 161: if_icmpne 16c
      // 164: iload 3
      // 165: ifeq 17d
      // 168: goto 16c
      // 16b: athrow
      // 16c: iinc 5 1
      // 16f: iload 3
      // 170: ifeq 010
      // 173: lload 0
      // 174: lconst_0
      // 175: lcmp
      // 176: ifle 02b
      // 179: goto 17d
      // 17c: athrow
      // 17d: aload 4
      // 17f: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 182: areturn
   }

   private static String Ν(String param0, short param1, Collection param2, int param3, char param4) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: iload 1
      // 001: i2l
      // 002: ldc 1924268577
      // 004: ldc 1924268561
      // 006: ixor
      // 007: lshl
      // 008: iload 3
      // 009: i2l
      // 00a: ldc 1924268593
      // 00c: ldc 1924268561
      // 00e: ixor
      // 00f: lshl
      // 010: ldc 1924268545
      // 012: ldc 1924268561
      // 014: ixor
      // 015: lushr
      // 016: lor
      // 017: iload 4
      // 019: i2l
      // 01a: ldc 1924268577
      // 01c: ldc 1924268561
      // 01e: ixor
      // 01f: lshl
      // 020: ldc 1924268577
      // 022: ldc 1924268561
      // 024: ixor
      // 025: lushr
      // 026: lor
      // 027: lstore 5
      // 029: getstatic x/oc804fdd8d75.Ɔ I
      // 02c: new java/util/HashSet
      // 02f: dup
      // 030: invokespecial java/util/HashSet.<init> ()V
      // 033: astore 8
      // 035: istore 7
      // 037: aload 2
      // 038: iload 7
      // 03a: ifne 045
      // 03d: ifnull 0a6
      // 040: goto 044
      // 043: athrow
      // 044: aload 2
      // 045: invokeinterface java/util/Collection.iterator ()Ljava/util/Iterator; 1
      // 04a: astore 9
      // 04c: aload 9
      // 04e: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 053: ifeq 0a6
      // 056: aload 9
      // 058: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 05d: checkcast x/oc804fdd8d75
      // 060: astore 10
      // 062: iload 4
      // 064: iflt 06c
      // 067: iload 7
      // 069: ifne 0c7
      // 06c: aload 10
      // 06e: iload 1
      // 06f: iflt 084
      // 072: iload 7
      // 074: ifne 084
      // 077: goto 07b
      // 07a: athrow
      // 07b: ifnull 0a1
      // 07e: goto 082
      // 081: athrow
      // 082: aload 10
      // 084: invokevirtual x/oc804fdd8d75.Ō ()Ljava/lang/String;
      // 087: ifnull 0a1
      // 08a: aload 8
      // 08c: aload 10
      // 08e: invokevirtual x/oc804fdd8d75.Ō ()Ljava/lang/String;
      // 091: getstatic java/util/Locale.ROOT Ljava/util/Locale;
      // 094: invokevirtual java/lang/String.toLowerCase (Ljava/util/Locale;)Ljava/lang/String;
      // 097: invokeinterface java/util/Set.add (Ljava/lang/Object;)Z 2
      // 09c: pop
      // 09d: goto 0a1
      // 0a0: athrow
      // 0a1: iload 7
      // 0a3: ifeq 04c
      // 0a6: iload 3
      // 0a7: iflt 0c7
      // 0aa: aload 8
      // 0ac: aload 0
      // 0ad: getstatic java/util/Locale.ROOT Ljava/util/Locale;
      // 0b0: invokevirtual java/lang/String.toLowerCase (Ljava/util/Locale;)Ljava/lang/String;
      // 0b3: invokeinterface java/util/Set.contains (Ljava/lang/Object;)Z 2
      // 0b8: iload 7
      // 0ba: ifne 0cc
      // 0bd: ifne 0c7
      // 0c0: goto 0c4
      // 0c3: athrow
      // 0c4: aload 0
      // 0c5: areturn
      // 0c6: athrow
      // 0c7: ldc 1924268563
      // 0c9: ldc 1924268561
      // 0cb: ixor
      // 0cc: istore 9
      // 0ce: iload 9
      // 0d0: ldc 1924300651
      // 0d2: ldc 1924268561
      // 0d4: ixor
      // 0d5: ldc2_w -5127064956672303367
      // 0d8: ldc2_w -7525572348124557674
      // 0db: lxor
      // 0dc: lload 5
      // 0de: lxor
      // 0df: invokestatic x/oc499a9670c8.a (IJ)I
      // 0e2: if_icmpge 148
      // 0e5: iload 9
      // 0e7: invokestatic java/lang/Integer.toString (I)Ljava/lang/String;
      // 0ea: astore 10
      // 0ec: iload 7
      // 0ee: aload 0
      // 0ef: invokevirtual java/lang/String.length ()I
      // 0f2: ldc 1924288306
      // 0f4: ldc 1924268561
      // 0f6: ixor
      // 0f7: ldc2_w -4389101723399672159
      // 0fa: ldc2_w -7525572348124557674
      // 0fd: lxor
      // 0fe: lload 5
      // 100: lxor
      // 101: invokestatic x/oc499a9670c8.a (IJ)I
      // 104: aload 10
      // 106: invokevirtual java/lang/String.length ()I
      // 109: isub
      // 10a: invokestatic java/lang/Math.min (II)I
      // 10d: istore 11
      // 10f: aload 0
      // 110: bipush 0
      // 111: iload 11
      // 113: invokevirtual java/lang/String.substring (II)Ljava/lang/String;
      // 116: aload 10
      // 118: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 11d: astore 12
      // 11f: iload 3
      // 120: ifle 145
      // 123: ifne 143
      // 126: aload 8
      // 128: aload 12
      // 12a: getstatic java/util/Locale.ROOT Ljava/util/Locale;
      // 12d: invokevirtual java/lang/String.toLowerCase (Ljava/util/Locale;)Ljava/lang/String;
      // 130: invokeinterface java/util/Set.contains (Ljava/lang/Object;)Z 2
      // 135: ifne 140
      // 138: goto 13c
      // 13b: athrow
      // 13c: aload 12
      // 13e: areturn
      // 13f: athrow
      // 140: iinc 9 1
      // 143: iload 7
      // 145: ifeq 0ce
      // 148: new java/io/IOException
      // 14b: dup
      // 14c: getstatic x/oc499a9670c8.a Ljava/lang/String;
      // 14f: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 152: athrow
   }

   // $VF: Irreducible bytecode was duplicated to produce valid code
   static {
      char[] var10001 = ":_\f\u000f=Zm\u001b^M\u000e#Z,\u001bTM\fqJ#\u0006@\u0018\bq\\?\u000eR\u0006\b5\u001f8\u001cT\u001f\u00030R(".toCharArray();
      int var10003 = var10001.length;
      int var8 = 0;
      char[] var34 = var10001;
      int var21 = var10003;
      char[] var44;
      int var10004;
      char var10005;
      int var10006;
      if (var10003 <= 1) {
         var44 = var10001;
         var10004 = var8;
         var10005 = var10001[var8];
         switch (var8 % (-824190685 ^ -824190684)) {
            case 0:
               var10006 = -824190645 ^ -824190684;
               break;
            case 1:
               var10006 = -824190699 ^ -824190684;
               break;
            case 2:
               var10006 = -824190647 ^ -824190684;
               break;
            case 3:
               var10006 = -824190647 ^ -824190684;
               break;
            case 4:
               var10006 = -824190603 ^ -824190684;
               break;
            case 5:
               var10006 = -824190693 ^ -824190684;
               break;
            default:
               var10006 = -824190615 ^ -824190684;
         }
      } else {
         var34 = var10001;
         var21 = var10003;
         if (var10003 <= var8) {
            String var54 = new String(var10001).intern();
            byte var29 = -1;
            a = var54;
            long var9 = -6306618543184904611L ^ -6306638561427530163L;
            long[] var14 = new long[-824190668 ^ -824190684];
            int var11 = 0;
            String var12 = "n¿aØ^OÏmñ(-ÍÈ¾/I×\u008a×Ã¡~\u009b\u0007}ÐjV\u0019ú(§\u001c\u008d\u001aà¼\t  \u00844yÔ¶dÄð\u0018à)¼ÚÑ¼\u0084\u0081\u009c\u0097p\u009c4O\u008f²ÌKzsâ\u0002\u0012»£\u009b¤Ð¨·¤ÿ=½ã±¢lï\u0087\u000ff\u0098Føñ\u0098÷Õ\u0012|×tÝ\u0092\u001a\u009a\u001f\u0005áHÐ\u0001";
            int var13 = "n¿aØ^OÏmñ(-ÍÈ¾/I×\u008a×Ã¡~\u009b\u0007}ÐjV\u0019ú(§\u001c\u008d\u001aà¼\t  \u00844yÔ¶dÄð\u0018à)¼ÚÑ¼\u0084\u0081\u009c\u0097p\u009c4O\u008f²ÌKzsâ\u0002\u0012»£\u009b¤Ð¨·¤ÿ=½ã±¢lï\u0087\u000ff\u0098Føñ\u0098÷Õ\u0012|×tÝ\u0092\u001a\u009a\u001f\u0005áHÐ\u0001"
               .length();
            byte var10 = 0;

            label71:
            while (true) {
               byte var30 = var10;
               var10 += 8;
               byte[] var16 = var12.substring(var30, var10).getBytes("ISO-8859-1");
               long[] var18 = var14;
               int var31 = var11++;
               long var40 = (var16[0] & (-6306638561427530062L ^ -6306638561427530163L)) << (-824190692 ^ -824190684)
                  | (var16[1] & (-6306638561427530062L ^ -6306638561427530163L)) << (-824190700 ^ -824190684)
                  | (var16[-824190682 ^ -824190684] & (-6306638561427530062L ^ -6306638561427530163L)) << (-824190708 ^ -824190684)
                  | (var16[-824190681 ^ -824190684] & (-6306638561427530062L ^ -6306638561427530163L)) << (-824190716 ^ -824190684)
                  | (var16[-824190688 ^ -824190684] & (-6306638561427530062L ^ -6306638561427530163L)) << (-824190660 ^ -824190684)
                  | (var16[-824190687 ^ -824190684] & (-6306638561427530062L ^ -6306638561427530163L)) << (-824190668 ^ -824190684)
                  | (var16[-824190686 ^ -824190684] & (-6306638561427530062L ^ -6306638561427530163L)) << (-824190676 ^ -824190684)
                  | var16[-824190685 ^ -824190684] & (-6306638561427530062L ^ -6306638561427530163L);
               byte var55 = -1;

               while (true) {
                  long var60 = var40 ^ var9;
                  switch (var55) {
                     case 0:
                        var18[var31] = var60;
                        if (var10 >= var13) {
                           b = var14;
                           c = new Integer[-824190668 ^ -824190684];
                           ȁ = new Random();
                           return;
                        }
                        break;
                     default:
                        var18[var31] = var60;
                        if (var10 < var13) {
                           continue label71;
                        }

                        var12 = "é\u0098ú\u009c¼\u0090Í\u009bÞ¤õ&\u0001rÕ\u0013";
                        var13 = "é\u0098ú\u009c¼\u0090Í\u009bÞ¤õ&\u0001rÕ\u0013".length();
                        var10 = 0;
                  }

                  byte var32 = var10;
                  var10 += 8;
                  var16 = var12.substring(var32, var10).getBytes("ISO-8859-1");
                  var18 = var14;
                  var31 = var11++;
                  var40 = (var16[0] & (-6306638561427530062L ^ -6306638561427530163L)) << (-824190692 ^ -824190684)
                     | (var16[1] & (-6306638561427530062L ^ -6306638561427530163L)) << (-824190700 ^ -824190684)
                     | (var16[-824190682 ^ -824190684] & (-6306638561427530062L ^ -6306638561427530163L)) << (-824190708 ^ -824190684)
                     | (var16[-824190681 ^ -824190684] & (-6306638561427530062L ^ -6306638561427530163L)) << (-824190716 ^ -824190684)
                     | (var16[-824190688 ^ -824190684] & (-6306638561427530062L ^ -6306638561427530163L)) << (-824190660 ^ -824190684)
                     | (var16[-824190687 ^ -824190684] & (-6306638561427530062L ^ -6306638561427530163L)) << (-824190668 ^ -824190684)
                     | (var16[-824190686 ^ -824190684] & (-6306638561427530062L ^ -6306638561427530163L)) << (-824190676 ^ -824190684)
                     | var16[-824190685 ^ -824190684] & (-6306638561427530062L ^ -6306638561427530163L);
                  var55 = 0;
               }
            }
         }

         var44 = var10001;
         var10004 = var8;
         var10005 = var10001[var8];
         switch (var8 % (-824190685 ^ -824190684)) {
            case 0:
               var10006 = -824190645 ^ -824190684;
               break;
            case 1:
               var10006 = -824190699 ^ -824190684;
               break;
            case 2:
               var10006 = -824190647 ^ -824190684;
               break;
            case 3:
               var10006 = -824190647 ^ -824190684;
               break;
            case 4:
               var10006 = -824190603 ^ -824190684;
               break;
            case 5:
               var10006 = -824190693 ^ -824190684;
               break;
            default:
               var10006 = -824190615 ^ -824190684;
         }
      }

      while (true) {
         var44[var10004] = (char)(var10005 ^ var10006);
         var8++;
         if (var21 == 0) {
            var10004 = var21;
            var44 = var34;
            var10005 = var34[var21];
            switch (var8 % (-824190685 ^ -824190684)) {
               case 0:
                  var10006 = -824190645 ^ -824190684;
                  break;
               case 1:
                  var10006 = -824190699 ^ -824190684;
                  break;
               case 2:
                  var10006 = -824190647 ^ -824190684;
                  break;
               case 3:
                  var10006 = -824190647 ^ -824190684;
                  break;
               case 4:
                  var10006 = -824190603 ^ -824190684;
                  break;
               case 5:
                  var10006 = -824190693 ^ -824190684;
                  break;
               default:
                  var10006 = -824190615 ^ -824190684;
            }
         } else {
            if (var21 <= var8) {
               String var51 = new String(var34).intern();
               byte var25 = -1;
               a = var51;
               long var0 = -6306618543184904611L ^ -6306638561427530163L;
               long[] var6 = new long[-824190668 ^ -824190684];
               int var3 = 0;
               String var4 = "n¿aØ^OÏmñ(-ÍÈ¾/I×\u008a×Ã¡~\u009b\u0007}ÐjV\u0019ú(§\u001c\u008d\u001aà¼\t  \u00844yÔ¶dÄð\u0018à)¼ÚÑ¼\u0084\u0081\u009c\u0097p\u009c4O\u008f²ÌKzsâ\u0002\u0012»£\u009b¤Ð¨·¤ÿ=½ã±¢lï\u0087\u000ff\u0098Føñ\u0098÷Õ\u0012|×tÝ\u0092\u001a\u009a\u001f\u0005áHÐ\u0001";
               int var5 = "n¿aØ^OÏmñ(-ÍÈ¾/I×\u008a×Ã¡~\u009b\u0007}ÐjV\u0019ú(§\u001c\u008d\u001aà¼\t  \u00844yÔ¶dÄð\u0018à)¼ÚÑ¼\u0084\u0081\u009c\u0097p\u009c4O\u008f²ÌKzsâ\u0002\u0012»£\u009b¤Ð¨·¤ÿ=½ã±¢lï\u0087\u000ff\u0098Føñ\u0098÷Õ\u0012|×tÝ\u0092\u001a\u009a\u001f\u0005áHÐ\u0001"
                  .length();
               byte var2 = 0;

               label37:
               while (true) {
                  byte var26 = var2;
                  var2 += 8;
                  byte[] var7 = var4.substring(var26, var2).getBytes("ISO-8859-1");
                  long[] var10000 = var6;
                  int var27 = var3++;
                  long var38 = (var7[0] & (-6306638561427530062L ^ -6306638561427530163L)) << (-824190692 ^ -824190684)
                     | (var7[1] & (-6306638561427530062L ^ -6306638561427530163L)) << (-824190700 ^ -824190684)
                     | (var7[-824190682 ^ -824190684] & (-6306638561427530062L ^ -6306638561427530163L)) << (-824190708 ^ -824190684)
                     | (var7[-824190681 ^ -824190684] & (-6306638561427530062L ^ -6306638561427530163L)) << (-824190716 ^ -824190684)
                     | (var7[-824190688 ^ -824190684] & (-6306638561427530062L ^ -6306638561427530163L)) << (-824190660 ^ -824190684)
                     | (var7[-824190687 ^ -824190684] & (-6306638561427530062L ^ -6306638561427530163L)) << (-824190668 ^ -824190684)
                     | (var7[-824190686 ^ -824190684] & (-6306638561427530062L ^ -6306638561427530163L)) << (-824190676 ^ -824190684)
                     | var7[-824190685 ^ -824190684] & (-6306638561427530062L ^ -6306638561427530163L);
                  byte var52 = -1;

                  while (true) {
                     long var58 = var38 ^ var0;
                     switch (var52) {
                        case 0:
                           var10000[var27] = var58;
                           if (var2 >= var5) {
                              b = var6;
                              c = new Integer[-824190668 ^ -824190684];
                              ȁ = new Random();
                              return;
                           }
                           break;
                        default:
                           var10000[var27] = var58;
                           if (var2 < var5) {
                              continue label37;
                           }

                           var4 = "é\u0098ú\u009c¼\u0090Í\u009bÞ¤õ&\u0001rÕ\u0013";
                           var5 = "é\u0098ú\u009c¼\u0090Í\u009bÞ¤õ&\u0001rÕ\u0013".length();
                           var2 = 0;
                     }

                     byte var28 = var2;
                     var2 += 8;
                     var7 = var4.substring(var28, var2).getBytes("ISO-8859-1");
                     var10000 = var6;
                     var27 = var3++;
                     var38 = (var7[0] & (-6306638561427530062L ^ -6306638561427530163L)) << (-824190692 ^ -824190684)
                        | (var7[1] & (-6306638561427530062L ^ -6306638561427530163L)) << (-824190700 ^ -824190684)
                        | (var7[-824190682 ^ -824190684] & (-6306638561427530062L ^ -6306638561427530163L)) << (-824190708 ^ -824190684)
                        | (var7[-824190681 ^ -824190684] & (-6306638561427530062L ^ -6306638561427530163L)) << (-824190716 ^ -824190684)
                        | (var7[-824190688 ^ -824190684] & (-6306638561427530062L ^ -6306638561427530163L)) << (-824190660 ^ -824190684)
                        | (var7[-824190687 ^ -824190684] & (-6306638561427530062L ^ -6306638561427530163L)) << (-824190668 ^ -824190684)
                        | (var7[-824190686 ^ -824190684] & (-6306638561427530062L ^ -6306638561427530163L)) << (-824190676 ^ -824190684)
                        | var7[-824190685 ^ -824190684] & (-6306638561427530062L ^ -6306638561427530163L);
                     var52 = 0;
                  }
               }
            }

            var44 = var34;
            var10004 = var8;
            var10005 = var34[var8];
            switch (var8 % (-824190685 ^ -824190684)) {
               case 0:
                  var10006 = -824190645 ^ -824190684;
                  break;
               case 1:
                  var10006 = -824190699 ^ -824190684;
                  break;
               case 2:
                  var10006 = -824190647 ^ -824190684;
                  break;
               case 3:
                  var10006 = -824190647 ^ -824190684;
                  break;
               case 4:
                  var10006 = -824190603 ^ -824190684;
                  break;
               case 5:
                  var10006 = -824190693 ^ -824190684;
                  break;
               default:
                  var10006 = -824190615 ^ -824190684;
            }
         }
      }
   }

   private static int a(int var0, long var1) {
      int var3 = var0 ^ (int)(var1 & (4755141419132008989L ^ 4755141419132012002L)) ^ -1027310090 ^ -1027339312;
      if (c[var3] == null) {
         c[var3] = (int)(b[var3] ^ var1);
      }

      return c[var3];
   }
}

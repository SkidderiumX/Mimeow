package x;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;

public class oc979e0e9083 implements Comparable<oc979e0e9083> {
   private final List<BigInteger> Ƣ;
   private final String ө;
   private static final String[] a;
   private static final String[] b;
   private static final long[] c;
   private static final Integer[] d;

   private oc979e0e9083(List<BigInteger> var1, String var2) {
      this.Ƣ = var1;
      this.ө = var2;
   }

   static oc979e0e9083 ո(String var0) {
      boolean var1 = oc151419fdfe.v;

      try {
         if (var0 == null) {
            return null;
         }
      } catch (ocbde1165e4e var9) {
         throw var9;
      }

      Matcher var2 = U.ԃ.matcher(var0.trim());

      try {
         if (!var2.matches()) {
            return null;
         }
      } catch (ocbde1165e4e var8) {
         throw var8;
      }

      ArrayList var3 = new ArrayList();
      String[] var4 = var2.group(1).split("\\.");
      int var5 = var4.length;
      int var6 = 0;

      String var10000;
      while (true) {
         if (var6 < var5) {
            var10000 = var4[var6];
            if (var1) {
               break;
            }

            String var7 = var10000;
            var3.add(new BigInteger(var7));
            var6++;
            if (!var1) {
               continue;
            }
         }

         var10000 = var2.group(1927666750 ^ 1927666748).trim();
         break;
      }

      String var10 = var10000;
      var10000 = var10;
      if (!var1) {
         var5 = var10.indexOf(1927666711 ^ 1927666748);
         if (var5 >= 0) {
            var10 = var10.substring(0, var5);
         }

         var10000 = var10.replaceFirst("^[._-]+", "").toLowerCase(Locale.ROOT);
      }

      String var12 = var10000;
      return new oc979e0e9083(var3, var12);
   }

   public int ƞ(oc979e0e9083 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: ldc2_w 4279471291124533564
      // 03: ldc2_w 4279497258969989887
      // 06: lxor
      // 07: lstore 2
      // 08: lload 2
      // 09: dup2
      // 0a: ldc2_w 4279532507429989288
      // 0d: ldc2_w 4279497258969989887
      // 10: lxor
      // 11: lxor
      // 12: lstore 4
      // 14: pop2
      // 15: getstatic x/oc151419fdfe.v Z
      // 18: aload 0
      // 19: getfield x/oc979e0e9083.Ƣ Ljava/util/List;
      // 1c: invokeinterface java/util/List.size ()I 1
      // 21: aload 1
      // 22: getfield x/oc979e0e9083.Ƣ Ljava/util/List;
      // 25: invokeinterface java/util/List.size ()I 1
      // 2a: invokestatic java/lang/Math.max (II)I
      // 2d: istore 7
      // 2f: istore 6
      // 31: bipush 0
      // 32: istore 8
      // 34: iload 8
      // 36: iload 7
      // 38: if_icmpge b1
      // 3b: iload 8
      // 3d: iload 6
      // 3f: ifne c0
      // 42: aload 0
      // 43: getfield x/oc979e0e9083.Ƣ Ljava/util/List;
      // 46: invokeinterface java/util/List.size ()I 1
      // 4b: if_icmpge 64
      // 4e: goto 52
      // 51: athrow
      // 52: aload 0
      // 53: getfield x/oc979e0e9083.Ƣ Ljava/util/List;
      // 56: iload 8
      // 58: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 5d: checkcast java/math/BigInteger
      // 60: goto 67
      // 63: athrow
      // 64: getstatic java/math/BigInteger.ZERO Ljava/math/BigInteger;
      // 67: astore 9
      // 69: iload 8
      // 6b: aload 1
      // 6c: getfield x/oc979e0e9083.Ƣ Ljava/util/List;
      // 6f: invokeinterface java/util/List.size ()I 1
      // 74: if_icmpge 89
      // 77: aload 1
      // 78: getfield x/oc979e0e9083.Ƣ Ljava/util/List;
      // 7b: iload 8
      // 7d: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 82: checkcast java/math/BigInteger
      // 85: goto 8c
      // 88: athrow
      // 89: getstatic java/math/BigInteger.ZERO Ljava/math/BigInteger;
      // 8c: astore 10
      // 8e: iload 6
      // 90: aload 9
      // 92: aload 10
      // 94: invokevirtual java/math/BigInteger.compareTo (Ljava/math/BigInteger;)I
      // 97: istore 11
      // 99: ifne ac
      // 9c: iload 11
      // 9e: ifeq a9
      // a1: goto a5
      // a4: athrow
      // a5: iload 11
      // a7: ireturn
      // a8: athrow
      // a9: iinc 8 1
      // ac: iload 6
      // ae: ifeq 34
      // b1: aload 0
      // b2: getfield x/oc979e0e9083.ө Ljava/lang/String;
      // b5: aload 1
      // b6: getfield x/oc979e0e9083.ө Ljava/lang/String;
      // b9: lload 4
      // bb: dup2_x1
      // bc: pop2
      // bd: invokestatic x/oc979e0e9083.ǔ (Ljava/lang/String;JLjava/lang/String;)I
      // c0: ireturn
   }

   private static int ǔ(String param0, long param1, String param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: lload 1
      // 001: dup2
      // 002: ldc2_w 9177602168495069311
      // 005: ldc2_w 9177580114500328216
      // 008: lxor
      // 009: lxor
      // 00a: dup2
      // 00b: ldc 1096506601
      // 00d: ldc 1096506593
      // 00f: ixor
      // 010: lushr
      // 011: lstore 4
      // 013: dup2
      // 014: ldc 1096506585
      // 016: ldc 1096506593
      // 018: ixor
      // 019: lshl
      // 01a: ldc 1096506585
      // 01c: ldc 1096506593
      // 01e: ixor
      // 01f: lushr
      // 020: l2i
      // 021: istore 6
      // 023: pop2
      // 024: dup2
      // 025: ldc2_w 9177499750181940624
      // 028: ldc2_w 9177580114500328216
      // 02b: lxor
      // 02c: lxor
      // 02d: dup2
      // 02e: ldc 1096506601
      // 030: ldc 1096506593
      // 032: ixor
      // 033: lushr
      // 034: lstore 7
      // 036: dup2
      // 037: ldc 1096506585
      // 039: ldc 1096506593
      // 03b: ixor
      // 03c: lshl
      // 03d: ldc 1096506585
      // 03f: ldc 1096506593
      // 041: ixor
      // 042: lushr
      // 043: l2i
      // 044: istore 9
      // 046: pop2
      // 047: pop2
      // 048: getstatic x/oc151419fdfe.v Z
      // 04b: istore 10
      // 04d: aload 0
      // 04e: iload 10
      // 050: ifne 062
      // 053: aload 3
      // 054: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 057: ifeq 061
      // 05a: goto 05e
      // 05d: athrow
      // 05e: bipush 0
      // 05f: ireturn
      // 060: athrow
      // 061: aload 0
      // 062: iload 10
      // 064: lload 1
      // 065: lconst_1
      // 066: lcmp
      // 067: ifle 07d
      // 06a: ifne 07b
      // 06d: invokevirtual java/lang/String.isEmpty ()Z
      // 070: ifeq 07a
      // 073: goto 077
      // 076: athrow
      // 077: bipush 1
      // 078: ireturn
      // 079: athrow
      // 07a: aload 3
      // 07b: iload 10
      // 07d: ifne 08e
      // 080: invokevirtual java/lang/String.isEmpty ()Z
      // 083: ifeq 08d
      // 086: goto 08a
      // 089: athrow
      // 08a: bipush -1
      // 08b: ireturn
      // 08c: athrow
      // 08d: aload 0
      // 08e: lload 7
      // 090: iload 9
      // 092: i2b
      // 093: invokestatic x/oc979e0e9083.e (Ljava/lang/String;JB)Ljava/util/List;
      // 096: astore 11
      // 098: aload 3
      // 099: lload 7
      // 09b: iload 9
      // 09d: i2b
      // 09e: invokestatic x/oc979e0e9083.e (Ljava/lang/String;JB)Ljava/util/List;
      // 0a1: astore 12
      // 0a3: aload 11
      // 0a5: invokeinterface java/util/List.size ()I 1
      // 0aa: aload 12
      // 0ac: invokeinterface java/util/List.size ()I 1
      // 0b1: invokestatic java/lang/Math.max (II)I
      // 0b4: istore 13
      // 0b6: bipush 0
      // 0b7: istore 14
      // 0b9: iload 14
      // 0bb: iload 13
      // 0bd: if_icmpge 14f
      // 0c0: iload 14
      // 0c2: iload 10
      // 0c4: lload 1
      // 0c5: lconst_0
      // 0c6: lcmp
      // 0c7: iflt 0cf
      // 0ca: ifne 156
      // 0cd: iload 10
      // 0cf: lload 1
      // 0d0: lconst_0
      // 0d1: lcmp
      // 0d2: ifle 0f1
      // 0d5: ifne 0ef
      // 0d8: goto 0dc
      // 0db: athrow
      // 0dc: aload 11
      // 0de: invokeinterface java/util/List.size ()I 1
      // 0e3: if_icmplt 0ed
      // 0e6: goto 0ea
      // 0e9: athrow
      // 0ea: bipush -1
      // 0eb: ireturn
      // 0ec: athrow
      // 0ed: iload 14
      // 0ef: iload 10
      // 0f1: lload 1
      // 0f2: lconst_1
      // 0f3: lcmp
      // 0f4: ifle 101
      // 0f7: ifne 12d
      // 0fa: aload 12
      // 0fc: invokeinterface java/util/List.size ()I 1
      // 101: if_icmplt 10b
      // 104: goto 108
      // 107: athrow
      // 108: bipush 1
      // 109: ireturn
      // 10a: athrow
      // 10b: aload 11
      // 10d: iload 14
      // 10f: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 114: checkcast java/lang/String
      // 117: aload 12
      // 119: iload 14
      // 11b: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 120: lload 4
      // 122: dup2_x1
      // 123: pop2
      // 124: checkcast java/lang/String
      // 127: iload 6
      // 129: i2b
      // 12a: invokestatic x/oc979e0e9083.ѻ (Ljava/lang/String;JLjava/lang/String;B)I
      // 12d: istore 15
      // 12f: iload 10
      // 131: lload 1
      // 132: lconst_1
      // 133: lcmp
      // 134: iflt 14c
      // 137: ifne 14a
      // 13a: iload 15
      // 13c: ifeq 147
      // 13f: goto 143
      // 142: athrow
      // 143: iload 15
      // 145: ireturn
      // 146: athrow
      // 147: iinc 14 1
      // 14a: iload 10
      // 14c: ifeq 0b9
      // 14f: lload 1
      // 150: lconst_1
      // 151: lcmp
      // 152: ifle 0c0
      // 155: bipush 0
      // 156: ireturn
   }

   private static List e(String var0, long var1, byte var3) {
      long var4 = var1 << (362225065 ^ 362225057) | (long)var3 << (362225049 ^ 362225057) >>> (362225049 ^ 362225057);
      boolean var10000 = oc151419fdfe.v;
      ArrayList var7 = new ArrayList();
      boolean var6 = var10000;
      Matcher var8 = U.Ϲ.matcher(var0);

      label48:
      while (true) {
         if (var8.find()) {
            do {
               try {
                  var10000 = var7.add(var8.group().toLowerCase(Locale.ROOT));
                  if (var1 <= 1L || var6) {
                     break label48;
                  }

                  if (!var6) {
                     continue label48;
                  }
               } catch (ocbde1165e4e var11) {
                  throw var11;
               }
            } while (var1 <= 1L);
         }

         try {
            if (var6) {
               return var7;
            }

            var10000 = var7.isEmpty();
            break;
         } catch (ocbde1165e4e var10) {
            throw var10;
         }
      }

      try {
         if (var10000) {
            var7.add(var0);
         }
      } catch (ocbde1165e4e var9) {
         throw var9;
      }

      return var7;
   }

   private static int ѻ(String var0, long var1, String var3, byte var4) {
      long var5 = var1 << (1330115344 ^ 1330115352) | (long)var4 << (1330115360 ^ 1330115352) >>> (1330115360 ^ 1330115352);
      long var7 = var5 ^ 2226198040573622747L ^ 2226202319824558947L;
      byte var10 = 0;
      byte var11 = 0;
      int var12 = 0;
      int var13 = 0;
      int var10000 = oc151419fdfe.v;
      int var14 = a(1330118446 ^ 1330115352, 4490082207462730723L ^ 2226202319824558947L ^ var5);
      byte var9 = (byte)var10000;

      do {
         label214:
         while (true) {
            label212:
            while (true) {
               switch (var14) {
                  case -2091057242:
                     var10000 = Ԓ(var0, var7);
                     if (var4 < 0) {
                        if (var9 == 0) {
                           var12 = var10000;
                           var10000 = Ԓ(var3, var7);
                           label167:
                           if (var1 > 0L) {
                              var13 = var10000;
                              if (var12 == var13) {
                                 var10000 = a(1330103074 ^ 1330115352, 8200610567633016807L ^ 2226202319824558947L ^ var5);
                                 if (var1 < 1L) {
                                    break label167;
                                 }

                                 var14 = var10000;
                                 if (var9 == 0) {
                                    continue;
                                 }
                              }

                              var10000 = 1330110841 ^ 1330115352;
                           }

                           var10000 = a(var10000, 4381865509656671671L ^ 2226202319824558947L ^ var5);
                        }

                        var14 = var10000;
                        if (var1 < 0L) {
                           break label212;
                        }

                        var10000 = var9;
                     }

                     if (var10000 != 0) {
                        break label212;
                     }
                     continue;
                  case -1155079272:
                     label107: {
                        label106: {
                           label105: {
                              label243: {
                                 try {
                                    var10000 = var10;
                                    if (var1 <= 1L) {
                                       break label107;
                                    }

                                    if (var9 != 0) {
                                       break label106;
                                    }

                                    if (var10 == var11) {
                                       break label243;
                                    }
                                 } catch (ocbde1165e4e var15) {
                                    throw var15;
                                 }

                                 var10000 = 1330086323 ^ 1330115352;
                                 if (var1 <= 0L) {
                                    break label105;
                                 }

                                 var14 = a(var10000, 3073867081987872122L ^ 2226202319824558947L ^ var5);
                                 if (var9 == 0) {
                                    continue;
                                 }
                              }

                              var10000 = 1330105497 ^ 1330115352;
                           }

                           var10000 = a(var10000, 3926639326191065174L ^ 2226202319824558947L ^ var5);
                        }

                        var14 = var10000;
                        var10000 = var9;
                     }

                     if (var10000 != 0) {
                        return Integer.compare(var12, var13);
                     }
                     continue;
                  case -967457257:
                     break label212;
                  case -706887925:
                     return new BigInteger(var0).compareTo(new BigInteger(var3));
                  case -123889555:
                     label234: {
                        label195: {
                           label194: {
                              label235: {
                                 try {
                                    var10000 = var11;
                                    if (var1 <= 1L) {
                                       break label234;
                                    }

                                    if (var9 != 0) {
                                       break label195;
                                    }

                                    if (var11 == 0) {
                                       break label235;
                                    }
                                 } catch (ocbde1165e4e var18) {
                                    throw var18;
                                 }

                                 var10000 = a(1330111230 ^ 1330115352, 6014093584097752634L ^ 2226202319824558947L ^ var5);
                                 if (var1 <= 0L) {
                                    break label194;
                                 }

                                 var14 = var10000;
                                 if (var9 == 0) {
                                    continue;
                                 }
                              }

                              var10000 = 1330113828 ^ 1330115352;
                           }

                           var10000 = a(var10000, 6001709014083549676L ^ 2226202319824558947L ^ var5);
                        }

                        var14 = var10000;
                        if (var4 > 0) {
                           break;
                        }

                        var10000 = var9;
                     }

                     if (var10000 == 0) {
                        continue;
                     }
                  case 998609181:
                     var21 = var0.charAt(0);
                     if (var1 <= 0L) {
                        break label214;
                     }

                     var10 = Character.isDigit(var21);
                     break;
                  case 181390416:
                     return var0.compareTo(var3);
                  case 1072235492:
                     return Integer.compare(var12, var13);
                  case 1929836107:
                     return 1;
                  case 2056179467:
                     return -1;
                  default:
                     throw null;
               }

               int var22 = var9;
               var11 = Character.isDigit(var3.charAt(0));

               label154: {
                  label153: {
                     long var10001;
                     label152: {
                        label239: {
                           try {
                              if (var22 != 0) {
                                 break label154;
                              }

                              var22 = var10;
                              if (var4 > 0) {
                                 break label153;
                              }

                              if (var10 == 0) {
                                 break label239;
                              }
                           } catch (ocbde1165e4e var17) {
                              throw var17;
                           }

                           var22 = 1330112158 ^ 1330115352;
                           var10001 = 6112590263038358101L ^ 2226202319824558947L ^ var5;
                           if (var1 < 0L) {
                              break label152;
                           }

                           var14 = a(var22, var10001);
                           if (var9 == 0) {
                              continue;
                           }
                        }

                        var22 = 1330114517 ^ 1330115352;
                        var10001 = 2630413709756578578L ^ 2226202319824558947L ^ var5;
                     }

                     var22 = a(var22, var10001);
                  }

                  var14 = var22;
               }

               var21 = (char)var9;
               break label214;
            }

            label134: {
               label133: {
                  long var31;
                  long var10002;
                  label132: {
                     label241: {
                        try {
                           var10000 = var10;
                           if (var4 > 0) {
                              break label134;
                           }

                           if (var9 != 0) {
                              break label133;
                           }

                           if (var10 == 0) {
                              break label241;
                           }
                        } catch (ocbde1165e4e var16) {
                           throw var16;
                        }

                        var10000 = 1330112332 ^ 1330115352;
                        var31 = 5787536238581855114L ^ 2226202319824558947L;
                        var10002 = var5;
                        if (var1 <= 0L) {
                           break label132;
                        }

                        var14 = a(var10000, var31 ^ var5);
                        if (var9 == 0) {
                           continue;
                        }
                     }

                     var10000 = 1330099104 ^ 1330115352;
                     var31 = 2310437096043865962L ^ 2226202319824558947L;
                     var10002 = var5;
                  }

                  var10000 = a(var10000, var31 ^ var10002);
               }

               var14 = var10000;
               var10000 = var9;
            }

            if (var4 > 0) {
               return var10000;
            }

            if (var10000 != 0) {
               return -1;
            }
         }

         if (var1 < 1L) {
            return var21;
         }
      } while (var21 == 0);

      return var0.compareTo(var3);
   }

   private static int Ԓ(String param0, long param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: getstatic x/oc151419fdfe.v Z
      // 003: istore 3
      // 004: ldc 1310561507
      // 006: ldc 607125809
      // 008: ixor
      // 009: ldc_w -607129012
      // 00c: ldc 607125809
      // 00e: ixor
      // 00f: i2c
      // 010: isub
      // 011: ldc_w -1310561505
      // 014: ldc 607125809
      // 016: ixor
      // 017: ldc_w -607131554
      // 01a: ldc 607125809
      // 01c: ixor
      // 01d: i2c
      // 01e: ineg
      // 01f: isub
      // 020: lload 1
      // 021: l2i
      // 022: invokestatic x/oc979e0e9083.a (III)Ljava/lang/String;
      // 025: aload 0
      // 026: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 029: iload 3
      // 02a: ifne 079
      // 02d: ifne 074
      // 030: goto 034
      // 033: athrow
      // 034: ldc 1310561507
      // 036: ldc 607125809
      // 038: ixor
      // 039: ldc_w -607129019
      // 03c: ldc 607125809
      // 03e: ixor
      // 03f: i2c
      // 040: lload 1
      // 041: lconst_0
      // 042: lcmp
      // 043: ifle 0a0
      // 046: isub
      // 047: ldc_w -1310561505
      // 04a: ldc 607125809
      // 04c: ixor
      // 04d: ldc_w -607126654
      // 050: ldc 607125809
      // 052: ixor
      // 053: i2c
      // 054: ineg
      // 055: isub
      // 056: lload 1
      // 057: l2i
      // 058: invokestatic x/oc979e0e9083.a (III)Ljava/lang/String;
      // 05b: iload 3
      // 05c: ifne 09b
      // 05f: goto 063
      // 062: athrow
      // 063: aload 0
      // 064: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 067: lload 1
      // 068: lconst_0
      // 069: lcmp
      // 06a: ifle 087
      // 06d: ifeq 07a
      // 070: goto 074
      // 073: athrow
      // 074: bipush 0
      // 075: goto 079
      // 078: athrow
      // 079: ireturn
      // 07a: ldc 1310561507
      // 07c: ldc 607125809
      // 07e: ixor
      // 07f: ldc_w -607128909
      // 082: ldc 607125809
      // 084: ixor
      // 085: i2c
      // 086: isub
      // 087: ldc_w -1310561505
      // 08a: ldc 607125809
      // 08c: ixor
      // 08d: ldc_w -607146665
      // 090: ldc 607125809
      // 092: ixor
      // 093: i2c
      // 094: ineg
      // 095: isub
      // 096: lload 1
      // 097: l2i
      // 098: invokestatic x/oc979e0e9083.a (III)Ljava/lang/String;
      // 09b: aload 0
      // 09c: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 09f: iload 3
      // 0a0: ifne 0d1
      // 0a3: ifne 0cc
      // 0a6: goto 0aa
      // 0a9: athrow
      // 0aa: ldc_w "a"
      // 0ad: aload 0
      // 0ae: lload 1
      // 0af: lconst_0
      // 0b0: lcmp
      // 0b1: iflt 0f4
      // 0b4: iload 3
      // 0b5: ifne 0f4
      // 0b8: goto 0bc
      // 0bb: athrow
      // 0bc: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0bf: lload 1
      // 0c0: lconst_0
      // 0c1: lcmp
      // 0c2: ifle 0df
      // 0c5: ifeq 0d2
      // 0c8: goto 0cc
      // 0cb: athrow
      // 0cc: bipush 1
      // 0cd: goto 0d1
      // 0d0: athrow
      // 0d1: ireturn
      // 0d2: ldc 1310561507
      // 0d4: ldc 607125809
      // 0d6: ixor
      // 0d7: ldc_w -607129014
      // 0da: ldc 607125809
      // 0dc: ixor
      // 0dd: i2c
      // 0de: isub
      // 0df: ldc_w -1310430435
      // 0e2: ldc 607125809
      // 0e4: ixor
      // 0e5: ldc_w -607127948
      // 0e8: ldc 607125809
      // 0ea: ixor
      // 0eb: i2c
      // 0ec: ineg
      // 0ed: iadd
      // 0ee: lload 1
      // 0ef: l2i
      // 0f0: invokestatic x/oc979e0e9083.a (III)Ljava/lang/String;
      // 0f3: aload 0
      // 0f4: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0f7: iload 3
      // 0f8: ifne 12e
      // 0fb: ifne 124
      // 0fe: goto 102
      // 101: athrow
      // 102: ldc_w "b"
      // 105: lload 1
      // 106: lconst_0
      // 107: lcmp
      // 108: iflt 150
      // 10b: iload 3
      // 10c: ifne 150
      // 10f: goto 113
      // 112: athrow
      // 113: aload 0
      // 114: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 117: lload 1
      // 118: lconst_1
      // 119: lcmp
      // 11a: ifle 13c
      // 11d: ifeq 12f
      // 120: goto 124
      // 123: athrow
      // 124: ldc_w 607125811
      // 127: ldc 607125809
      // 129: ixor
      // 12a: goto 12e
      // 12d: athrow
      // 12e: ireturn
      // 12f: ldc 1310561507
      // 131: ldc 607125809
      // 133: ixor
      // 134: ldc_w -607129011
      // 137: ldc 607125809
      // 139: ixor
      // 13a: i2c
      // 13b: isub
      // 13c: ldc_w -1310561505
      // 13f: ldc 607125809
      // 141: ixor
      // 142: ldc_w -607130501
      // 145: ldc 607125809
      // 147: ixor
      // 148: i2c
      // 149: ineg
      // 14a: isub
      // 14b: lload 1
      // 14c: l2i
      // 14d: invokestatic x/oc979e0e9083.a (III)Ljava/lang/String;
      // 150: aload 0
      // 151: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 154: iload 3
      // 155: ifne 18b
      // 158: ifne 181
      // 15b: goto 15f
      // 15e: athrow
      // 15f: ldc_w "m"
      // 162: aload 0
      // 163: lload 1
      // 164: lconst_0
      // 165: lcmp
      // 166: iflt 1ae
      // 169: iload 3
      // 16a: ifne 1ae
      // 16d: goto 171
      // 170: athrow
      // 171: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 174: lload 1
      // 175: lconst_1
      // 176: lcmp
      // 177: ifle 199
      // 17a: ifeq 18c
      // 17d: goto 181
      // 180: athrow
      // 181: ldc_w 607125810
      // 184: ldc 607125809
      // 186: ixor
      // 187: goto 18b
      // 18a: athrow
      // 18b: ireturn
      // 18c: ldc 1310561507
      // 18e: ldc 607125809
      // 190: ixor
      // 191: ldc_w -607129010
      // 194: ldc 607125809
      // 196: ixor
      // 197: i2c
      // 198: isub
      // 199: ldc_w -1310561505
      // 19c: ldc 607125809
      // 19e: ixor
      // 19f: ldc_w -607137318
      // 1a2: ldc 607125809
      // 1a4: ixor
      // 1a5: i2c
      // 1a6: ineg
      // 1a7: isub
      // 1a8: lload 1
      // 1a9: l2i
      // 1aa: invokestatic x/oc979e0e9083.a (III)Ljava/lang/String;
      // 1ad: aload 0
      // 1ae: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 1b1: iload 3
      // 1b2: ifne 204
      // 1b5: ifne 1fa
      // 1b8: goto 1bc
      // 1bb: athrow
      // 1bc: ldc 1310561507
      // 1be: ldc 607125809
      // 1c0: ixor
      // 1c1: ldc_w -607129022
      // 1c4: ldc 607125809
      // 1c6: ixor
      // 1c7: i2c
      // 1c8: isub
      // 1c9: ldc 1310561507
      // 1cb: ldc 607125809
      // 1cd: ixor
      // 1ce: lload 1
      // 1cf: lconst_0
      // 1d0: lcmp
      // 1d1: ifle 22b
      // 1d4: ldc_w -607135055
      // 1d7: ldc 607125809
      // 1d9: ixor
      // 1da: i2c
      // 1db: isub
      // 1dc: lload 1
      // 1dd: l2i
      // 1de: invokestatic x/oc979e0e9083.a (III)Ljava/lang/String;
      // 1e1: iload 3
      // 1e2: ifne 226
      // 1e5: goto 1e9
      // 1e8: athrow
      // 1e9: aload 0
      // 1ea: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 1ed: lload 1
      // 1ee: lconst_0
      // 1ef: lcmp
      // 1f0: iflt 212
      // 1f3: ifeq 205
      // 1f6: goto 1fa
      // 1f9: athrow
      // 1fa: ldc_w 607125813
      // 1fd: ldc 607125809
      // 1ff: ixor
      // 200: goto 204
      // 203: athrow
      // 204: ireturn
      // 205: ldc 1310561507
      // 207: ldc 607125809
      // 209: ixor
      // 20a: ldc_w -607129009
      // 20d: ldc 607125809
      // 20f: ixor
      // 210: i2c
      // 211: isub
      // 212: ldc_w -1310561505
      // 215: ldc 607125809
      // 217: ixor
      // 218: ldc_w -607145334
      // 21b: ldc 607125809
      // 21d: ixor
      // 21e: i2c
      // 21f: ineg
      // 220: isub
      // 221: lload 1
      // 222: l2i
      // 223: invokestatic x/oc979e0e9083.a (III)Ljava/lang/String;
      // 226: aload 0
      // 227: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 22a: iload 3
      // 22b: ifne 2ad
      // 22e: ifne 29b
      // 231: goto 235
      // 234: athrow
      // 235: ldc 1310561507
      // 237: ldc 607125809
      // 239: ixor
      // 23a: ldc_w -607128911
      // 23d: ldc 607125809
      // 23f: ixor
      // 240: i2c
      // 241: isub
      // 242: ldc 1310561507
      // 244: ldc 607125809
      // 246: ixor
      // 247: ldc_w -607136953
      // 24a: ldc 607125809
      // 24c: ixor
      // 24d: i2c
      // 24e: isub
      // 24f: lload 1
      // 250: l2i
      // 251: invokestatic x/oc979e0e9083.a (III)Ljava/lang/String;
      // 254: aload 0
      // 255: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 258: iload 3
      // 259: ifne 2ad
      // 25c: goto 260
      // 25f: athrow
      // 260: ifne 29b
      // 263: goto 267
      // 266: athrow
      // 267: ldc 1310561507
      // 269: ldc 607125809
      // 26b: ixor
      // 26c: ldc_w -607128912
      // 26f: ldc 607125809
      // 271: ixor
      // 272: i2c
      // 273: isub
      // 274: ldc_w -1310561505
      // 277: ldc 607125809
      // 279: ixor
      // 27a: ldc_w -607131594
      // 27d: ldc 607125809
      // 27f: ixor
      // 280: i2c
      // 281: ineg
      // 282: isub
      // 283: lload 1
      // 284: l2i
      // 285: invokestatic x/oc979e0e9083.a (III)Ljava/lang/String;
      // 288: aload 0
      // 289: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 28c: iload 3
      // 28d: ifne 2b4
      // 290: goto 294
      // 293: athrow
      // 294: ifeq 2ae
      // 297: goto 29b
      // 29a: athrow
      // 29b: ldc_w 607148096
      // 29e: ldc 607125809
      // 2a0: ixor
      // 2a1: ldc2_w -3574943746681390691
      // 2a4: ldc2_w -5183701620107706653
      // 2a7: lxor
      // 2a8: lload 1
      // 2a9: lxor
      // 2aa: invokestatic x/oc979e0e9083.a (IJ)I
      // 2ad: ireturn
      // 2ae: ldc_w 607125812
      // 2b1: ldc 607125809
      // 2b3: ixor
      // 2b4: ireturn
   }

   // $VF: Irreducible bytecode was duplicated to produce valid code
   static {
      String[] var13 = new String[-2133302117 ^ -2133302127];
      int var11 = 0;
      String var10 = "\u0080Ø\u009c\u0091hJñ`[\u0004q\u0092TQ\u0005'\u001b\u0000í¦\bÄàÄdÏ_\u0005G\u0002\u008e\\\u0002²ú\u0005Æ>ÅåÎ\u0007Â8(\u0000ì\u007f;";
      int var12 = "\u0080Ø\u009c\u0091hJñ`[\u0004q\u0092TQ\u0005'\u001b\u0000í¦\bÄàÄdÏ_\u0005G\u0002\u008e\\\u0002²ú\u0005Æ>ÅåÎ\u0007Â8(\u0000ì\u007f;"
         .length();
      int var9 = -2133302120 ^ -2133302127;
      int var17 = -1;

      label70:
      while (true) {
         String var10000 = var10.substring(++var17, var17 + var9);
         int var10001 = -1;

         while (true) {
            char[] var33;
            label65: {
               char[] var21 = var10000.toCharArray();
               int var10003 = var21.length;
               int var14 = 0;
               var33 = var21;
               var10001 = var10003;
               char[] var43;
               int var10004;
               if (var10003 <= 1) {
                  var43 = var21;
                  var10004 = var14;
               } else {
                  var33 = var21;
                  var10001 = var10003;
                  if (var10003 <= var14) {
                     break label65;
                  }

                  var43 = var21;
                  var10004 = var14;
               }

               while (true) {
                  var43[var10004] = (char)(var43[var10004] ^ switch (var14 % (-2133302122 ^ -2133302127)) {
                     case 0 -> -2133302135 ^ -2133302127;
                     case 1 -> -2133302026 ^ -2133302127;
                     case 2 -> -2133302094 ^ -2133302127;
                     case 3 -> -2133302058 ^ -2133302127;
                     case 4 -> -2133302116 ^ -2133302127;
                     case 5 -> -2133302084 ^ -2133302127;
                     default -> -2133302082 ^ -2133302127;
                  });
                  var14++;
                  if (var10001 == 0) {
                     var10004 = var10001;
                     var43 = var33;
                  } else {
                     if (var10001 <= var14) {
                        break;
                     }

                     var43 = var33;
                     var10004 = var14;
                  }
               }
            }

            String var50 = new String(var33).intern();
            switch (var10001) {
               case 0:
                  var13[var11++] = var50;
                  if ((var17 += var9) >= var12) {
                     a = var13;
                     b = new String[-2133302117 ^ -2133302127];
                     long var0 = 7618943691515795576L ^ 7618946167075756527L;
                     long[] var6 = new long[-2133302115 ^ -2133302127];
                     int var3 = 0;
                     String var4 = "\tö\u001c3³íÜ÷@.§7½u\u008dT\u0089E¿[Ñ\u0098\u0001ùL÷\u0015/\u001eÝÅ¤´8d\u0011+w\u0091?ëâubÍ\u0019\u0013f´\u0016\u0006¢tñ(j\u0013pºÜø\u0090ás¼úOX#~ã\u008d;I\u009bílZ~Æ";
                     int var5 = "\tö\u001c3³íÜ÷@.§7½u\u008dT\u0089E¿[Ñ\u0098\u0001ùL÷\u0015/\u001eÝÅ¤´8d\u0011+w\u0091?ëâubÍ\u0019\u0013f´\u0016\u0006¢tñ(j\u0013pºÜø\u0090ás¼úOX#~ã\u008d;I\u009bílZ~Æ"
                        .length();
                     byte var2 = 0;

                     label44:
                     while (true) {
                        int var28 = var2;
                        var2 += 8;
                        byte[] var7 = var4.substring(var28, var2).getBytes("ISO-8859-1");
                        long[] var19 = var6;
                        var28 = var3++;
                        long var39 = (var7[0] & (7618946167075756304L ^ 7618946167075756527L)) << (-2133302103 ^ -2133302127)
                           | (var7[1] & (7618946167075756304L ^ 7618946167075756527L)) << (-2133302111 ^ -2133302127)
                           | (var7[-2133302125 ^ -2133302127] & (7618946167075756304L ^ 7618946167075756527L)) << (-2133302087 ^ -2133302127)
                           | (var7[-2133302126 ^ -2133302127] & (7618946167075756304L ^ 7618946167075756527L)) << (-2133302095 ^ -2133302127)
                           | (var7[-2133302123 ^ -2133302127] & (7618946167075756304L ^ 7618946167075756527L)) << (-2133302135 ^ -2133302127)
                           | (var7[-2133302124 ^ -2133302127] & (7618946167075756304L ^ 7618946167075756527L)) << (-2133302143 ^ -2133302127)
                           | (var7[-2133302121 ^ -2133302127] & (7618946167075756304L ^ 7618946167075756527L)) << (-2133302119 ^ -2133302127)
                           | var7[-2133302122 ^ -2133302127] & (7618946167075756304L ^ 7618946167075756527L);
                        byte var51 = -1;

                        while (true) {
                           long var54 = var39 ^ var0;
                           switch (var51) {
                              case 0:
                                 var19[var28] = var54;
                                 if (var2 >= var5) {
                                    c = var6;
                                    d = new Integer[-2133302115 ^ -2133302127];
                                    return;
                                 }
                                 break;
                              default:
                                 var19[var28] = var54;
                                 if (var2 < var5) {
                                    continue label44;
                                 }

                                 var4 = "àNüD]Øà°¸\u0082)á}Ä26";
                                 var5 = "àNüD]Øà°¸\u0082)á}Ä26".length();
                                 var2 = 0;
                           }

                           byte var30 = var2;
                           var2 += 8;
                           var7 = var4.substring(var30, var2).getBytes("ISO-8859-1");
                           var19 = var6;
                           var28 = var3++;
                           var39 = (var7[0] & (7618946167075756304L ^ 7618946167075756527L)) << (-2133302103 ^ -2133302127)
                              | (var7[1] & (7618946167075756304L ^ 7618946167075756527L)) << (-2133302111 ^ -2133302127)
                              | (var7[-2133302125 ^ -2133302127] & (7618946167075756304L ^ 7618946167075756527L)) << (-2133302087 ^ -2133302127)
                              | (var7[-2133302126 ^ -2133302127] & (7618946167075756304L ^ 7618946167075756527L)) << (-2133302095 ^ -2133302127)
                              | (var7[-2133302123 ^ -2133302127] & (7618946167075756304L ^ 7618946167075756527L)) << (-2133302135 ^ -2133302127)
                              | (var7[-2133302124 ^ -2133302127] & (7618946167075756304L ^ 7618946167075756527L)) << (-2133302143 ^ -2133302127)
                              | (var7[-2133302121 ^ -2133302127] & (7618946167075756304L ^ 7618946167075756527L)) << (-2133302119 ^ -2133302127)
                              | var7[-2133302122 ^ -2133302127] & (7618946167075756304L ^ 7618946167075756527L);
                           var51 = 0;
                        }
                     }
                  }

                  var9 = var10.charAt(var17);
                  break;
               default:
                  var13[var11++] = var50;
                  if ((var17 += var9) < var12) {
                     var9 = var10.charAt(var17);
                     continue label70;
                  }

                  var10 = "\u0091h\u008c\u0002vø";
                  var12 = "\u0091h\u008c\u0002vø".length();
                  var9 = -2133302126 ^ -2133302127;
                  var17 = -1;
            }

            var10000 = var10.substring(++var17, var17 + var9);
            var10001 = 0;
         }
      }
   }

   private static String a(int var0, int var1, int var2) {
      int var3 = (var0 ^ var2 ^ 1252299228 ^ -1252298559) & (-1252290754 ^ -1252298559);
      if (b[var3] == null) {
         char[] var4 = a[var3].toCharArray();

         int var5 = switch (var4[0] & (-1252298690 ^ -1252298559)) {
            case 0 -> -1252298587 ^ -1252298559;
            case 1 -> -1252298567 ^ -1252298559;
            case 2 -> -1252298632 ^ -1252298559;
            case 3 -> -1252298626 ^ -1252298559;
            case 4 -> -1252298726 ^ -1252298559;
            case 5 -> -1252298640 ^ -1252298559;
            case 6 -> -1252298535 ^ -1252298559;
            case 7 -> -1252298685 ^ -1252298559;
            case 8 -> -1252298728 ^ -1252298559;
            case 9 -> -1252298727 ^ -1252298559;
            case 10 -> 0;
            case 11 -> -1252298702 ^ -1252298559;
            case 12 -> -1252298528 ^ -1252298559;
            case 13 -> -1252298615 ^ -1252298559;
            case 14 -> -1252298519 ^ -1252298559;
            case 15 -> -1252298573 ^ -1252298559;
            case 16 -> -1252298533 ^ -1252298559;
            case 17 -> -1252298498 ^ -1252298559;
            case 18 -> -1252298742 ^ -1252298559;
            case 19 -> -1252298737 ^ -1252298559;
            case 20 -> -1252298749 ^ -1252298559;
            case 21 -> -1252298676 ^ -1252298559;
            case 22 -> -1252298602 ^ -1252298559;
            case 23 -> -1252298641 ^ -1252298559;
            case 24 -> -1252298687 ^ -1252298559;
            case 25 -> -1252298659 ^ -1252298559;
            case 26 -> -1252298509 ^ -1252298559;
            case 27 -> -1252298725 ^ -1252298559;
            case 28 -> -1252298576 ^ -1252298559;
            case 29 -> -1252298671 ^ -1252298559;
            case 30 -> -1252298531 ^ -1252298559;
            case 31 -> -1252298661 ^ -1252298559;
            case 32 -> -1252298500 ^ -1252298559;
            case 33 -> -1252298651 ^ -1252298559;
            case 34 -> -1252298600 ^ -1252298559;
            case 35 -> -1252298681 ^ -1252298559;
            case 36 -> -1252298572 ^ -1252298559;
            case 37 -> -1252298511 ^ -1252298559;
            case 38 -> -1252298670 ^ -1252298559;
            case 39 -> -1252298534 ^ -1252298559;
            case 40 -> -1252298526 ^ -1252298559;
            case 41 -> -1252298652 ^ -1252298559;
            case 42 -> -1252298545 ^ -1252298559;
            case 43 -> -1252298583 ^ -1252298559;
            case 44 -> -1252298610 ^ -1252298559;
            case 45 -> -1252298751 ^ -1252298559;
            case 46 -> -1252298578 ^ -1252298559;
            case 47 -> -1252298665 ^ -1252298559;
            case 48 -> -1252298675 ^ -1252298559;
            case 49 -> -1252298563 ^ -1252298559;
            case 50 -> -1252298719 ^ -1252298559;
            case 51 -> -1252298594 ^ -1252298559;
            case 52 -> -1252298571 ^ -1252298559;
            case 53 -> -1252298499 ^ -1252298559;
            case 54 -> -1252298510 ^ -1252298559;
            case 55 -> -1252298620 ^ -1252298559;
            case 56 -> -1252298529 ^ -1252298559;
            case 57 -> -1252298697 ^ -1252298559;
            case 58 -> -1252298625 ^ -1252298559;
            case 59 -> -1252298752 ^ -1252298559;
            case 60 -> -1252298501 ^ -1252298559;
            case 61 -> -1252298518 ^ -1252298559;
            case 62 -> -1252298688 ^ -1252298559;
            case 63 -> -1252298616 ^ -1252298559;
            case 64 -> -1252298564 ^ -1252298559;
            case 65 -> -1252298698 ^ -1252298559;
            case 66 -> -1252298664 ^ -1252298559;
            case 67 -> -1252298707 ^ -1252298559;
            case 68 -> -1252298552 ^ -1252298559;
            case 69 -> -1252298570 ^ -1252298559;
            case 70 -> -1252298724 ^ -1252298559;
            case 71 -> -1252298607 ^ -1252298559;
            case 72 -> -1252298721 ^ -1252298559;
            case 73 -> -1252298540 ^ -1252298559;
            case 74 -> -1252298584 ^ -1252298559;
            case 75 -> -1252298550 ^ -1252298559;
            case 76 -> -1252298741 ^ -1252298559;
            case 77 -> -1252298718 ^ -1252298559;
            case 78 -> -1252298732 ^ -1252298559;
            case 79 -> -1252298746 ^ -1252298559;
            case 80 -> -1252298551 ^ -1252298559;
            case 81 -> -1252298601 ^ -1252298559;
            case 82 -> 1;
            case 83 -> -1252298536 ^ -1252298559;
            case 84 -> -1252298621 ^ -1252298559;
            case 85 -> -1252298524 ^ -1252298559;
            case 86 -> -1252298515 ^ -1252298559;
            case 87 -> -1252298516 ^ -1252298559;
            case 88 -> -1252298598 ^ -1252298559;
            case 89 -> -1252298613 ^ -1252298559;
            case 90 -> -1252298689 ^ -1252298559;
            case 91 -> -1252298514 ^ -1252298559;
            case 92 -> -1252298619 ^ -1252298559;
            case 93 -> -1252298694 ^ -1252298559;
            case 94 -> -1252298720 ^ -1252298559;
            case 95 -> -1252298541 ^ -1252298559;
            case 96 -> -1252298672 ^ -1252298559;
            case 97 -> -1252298667 ^ -1252298559;
            case 98 -> -1252298614 ^ -1252298559;
            case 99 -> -1252298701 ^ -1252298559;
            case 100 -> -1252298644 ^ -1252298559;
            case 101 -> -1252298691 ^ -1252298559;
            case 102 -> -1252298745 ^ -1252298559;
            case 103 -> -1252298523 ^ -1252298559;
            case 104 -> -1252298548 ^ -1252298559;
            case 105 -> -1252298656 ^ -1252298559;
            case 106 -> -1252298579 ^ -1252298559;
            case 107 -> -1252298655 ^ -1252298559;
            case 108 -> -1252298553 ^ -1252298559;
            case 109 -> -1252298609 ^ -1252298559;
            case 110 -> -1252298547 ^ -1252298559;
            case 111 -> -1252298744 ^ -1252298559;
            case 112 -> -1252298731 ^ -1252298559;
            case 113 -> -1252298544 ^ -1252298559;
            case 114 -> -1252298660 ^ -1252298559;
            case 115 -> -1252298568 ^ -1252298559;
            case 116 -> -1252298650 ^ -1252298559;
            case 117 -> -1252298739 ^ -1252298559;
            case 118 -> -1252298539 ^ -1252298559;
            case 119 -> -1252298577 ^ -1252298559;
            case 120 -> -1252298706 ^ -1252298559;
            case 121 -> -1252298555 ^ -1252298559;
            case 122 -> -1252298648 ^ -1252298559;
            case 123 -> -1252298599 ^ -1252298559;
            case 124 -> -1252298723 ^ -1252298559;
            case 125 -> -1252298554 ^ -1252298559;
            case 126 -> -1252298623 ^ -1252298559;
            case 127 -> -1252298581 ^ -1252298559;
            case 128 -> -1252298684 ^ -1252298559;
            case 129 -> -1252298658 ^ -1252298559;
            case 130 -> -1252298711 ^ -1252298559;
            case 131 -> -1252298715 ^ -1252298559;
            case 132 -> -1252298712 ^ -1252298559;
            case 133 -> -1252298637 ^ -1252298559;
            case 134 -> -1252298596 ^ -1252298559;
            case 135 -> -1252298505 ^ -1252298559;
            case 136 -> -1252298635 ^ -1252298559;
            case 137 -> -1252298628 ^ -1252298559;
            case 138 -> -1252298714 ^ -1252298559;
            case 139 -> -1252298678 ^ -1252298559;
            case 140 -> -1252298590 ^ -1252298559;
            case 141 -> -1252298717 ^ -1252298559;
            case 142 -> -1252298692 ^ -1252298559;
            case 143 -> -1252298633 ^ -1252298559;
            case 144 -> -1252298705 ^ -1252298559;
            case 145 -> -1252298657 ^ -1252298559;
            case 146 -> -1252298735 ^ -1252298559;
            case 147 -> -1252298693 ^ -1252298559;
            case 148 -> -1252298597 ^ -1252298559;
            case 149 -> -1252298574 ^ -1252298559;
            case 150 -> -1252298521 ^ -1252298559;
            case 151 -> -1252298709 ^ -1252298559;
            case 152 -> -1252298497 ^ -1252298559;
            case 153 -> -1252298683 ^ -1252298559;
            case 154 -> -1252298673 ^ -1252298559;
            case 155 -> -1252298520 ^ -1252298559;
            case 156 -> -1252298627 ^ -1252298559;
            case 157 -> -1252298630 ^ -1252298559;
            case 158 -> -1252298679 ^ -1252298559;
            case 159 -> -1252298710 ^ -1252298559;
            case 160 -> -1252298605 ^ -1252298559;
            case 161 -> -1252298504 ^ -1252298559;
            case 162 -> -1252298562 ^ -1252298559;
            case 163 -> -1252298588 ^ -1252298559;
            case 164 -> -1252298503 ^ -1252298559;
            case 165 -> -1252298546 ^ -1252298559;
            case 166 -> -1252298636 ^ -1252298559;
            case 167 -> -1252298699 ^ -1252298559;
            case 168 -> -1252298608 ^ -1252298559;
            case 169 -> -1252298530 ^ -1252298559;
            case 170 -> -1252298565 ^ -1252298559;
            case 171 -> -1252298722 ^ -1252298559;
            case 172 -> -1252298653 ^ -1252298559;
            case 173 -> -1252298747 ^ -1252298559;
            case 174 -> -1252298666 ^ -1252298559;
            case 175 -> -1252298682 ^ -1252298559;
            case 176 -> -1252298748 ^ -1252298559;
            case 177 -> -1252298669 ^ -1252298559;
            case 178 -> -1252298611 ^ -1252298559;
            case 179 -> -1252298525 ^ -1252298559;
            case 180 -> -1252298502 ^ -1252298559;
            case 181 -> -1252298736 ^ -1252298559;
            case 182 -> -1252298506 ^ -1252298559;
            case 183 -> -1252298738 ^ -1252298559;
            case 184 -> -1252298631 ^ -1252298559;
            case 185 -> -1252298566 ^ -1252298559;
            case 186 -> -1252298569 ^ -1252298559;
            case 187 -> -1252298713 ^ -1252298559;
            case 188 -> -1252298700 ^ -1252298559;
            case 189 -> -1252298556 ^ -1252298559;
            case 190 -> -1252298549 ^ -1252298559;
            case 191 -> -1252298507 ^ -1252298559;
            case 192 -> -1252298645 ^ -1252298559;
            case 193 -> -1252298585 ^ -1252298559;
            case 194 -> -1252298580 ^ -1252298559;
            case 195 -> -1252298561 ^ -1252298559;
            case 196 -> -1252298517 ^ -1252298559;
            case 197 -> -1252298586 ^ -1252298559;
            case 198 -> -1252298538 ^ -1252298559;
            case 199 -> -1252298513 ^ -1252298559;
            case 200 -> -1252298575 ^ -1252298559;
            case 201 -> -1252298638 ^ -1252298559;
            case 202 -> -1252298686 ^ -1252298559;
            case 203 -> -1252298512 ^ -1252298559;
            case 204 -> -1252298603 ^ -1252298559;
            case 205 -> -1252298595 ^ -1252298559;
            case 206 -> -1252298703 ^ -1252298559;
            case 207 -> -1252298750 ^ -1252298559;
            case 208 -> -1252298624 ^ -1252298559;
            case 209 -> -1252298668 ^ -1252298559;
            case 210 -> -1252298593 ^ -1252298559;
            case 211 -> -1252298733 ^ -1252298559;
            case 212 -> -1252298592 ^ -1252298559;
            case 213 -> -1252298618 ^ -1252298559;
            case 214 -> -1252298543 ^ -1252298559;
            case 215 -> -1252298704 ^ -1252298559;
            case 216 -> -1252298612 ^ -1252298559;
            case 217 -> -1252298634 ^ -1252298559;
            case 218 -> -1252298729 ^ -1252298559;
            case 219 -> -1252298617 ^ -1252298559;
            case 220 -> -1252298522 ^ -1252298559;
            case 221 -> -1252298647 ^ -1252298559;
            case 222 -> -1252298527 ^ -1252298559;
            case 223 -> -1252298690 ^ -1252298559;
            case 224 -> -1252298508 ^ -1252298559;
            case 225 -> -1252298589 ^ -1252298559;
            case 226 -> -1252298695 ^ -1252298559;
            case 227 -> -1252298643 ^ -1252298559;
            case 228 -> -1252298730 ^ -1252298559;
            case 229 -> -1252298654 ^ -1252298559;
            case 230 -> -1252298708 ^ -1252298559;
            case 231 -> -1252298542 ^ -1252298559;
            case 232 -> -1252298532 ^ -1252298559;
            case 233 -> -1252298591 ^ -1252298559;
            case 234 -> -1252298622 ^ -1252298559;
            case 235 -> -1252298677 ^ -1252298559;
            case 236 -> -1252298734 ^ -1252298559;
            case 237 -> -1252298743 ^ -1252298559;
            case 238 -> -1252298649 ^ -1252298559;
            case 239 -> -1252298604 ^ -1252298559;
            case 240 -> -1252298582 ^ -1252298559;
            case 241 -> -1252298642 ^ -1252298559;
            case 242 -> -1252298629 ^ -1252298559;
            case 243 -> -1252298663 ^ -1252298559;
            case 244 -> -1252298740 ^ -1252298559;
            case 245 -> -1252298696 ^ -1252298559;
            case 246 -> -1252298646 ^ -1252298559;
            case 247 -> -1252298606 ^ -1252298559;
            case 248 -> -1252298639 ^ -1252298559;
            case 249 -> -1252298674 ^ -1252298559;
            case 250 -> -1252298680 ^ -1252298559;
            case 251 -> -1252298558 ^ -1252298559;
            case 252 -> -1252298557 ^ -1252298559;
            case 253 -> -1252298537 ^ -1252298559;
            case 254 -> -1252298662 ^ -1252298559;
            default -> -1252298716 ^ -1252298559;
         };
         int var10;
         int var6 = ((var10 = var1 ^ var2) & (-1252298690 ^ -1252298559)) - var5;
         if (var6 < 0) {
            var6 += 256;
         }

         int var7 = ((var10 & (-1252290754 ^ -1252298559)) >>> (-1252298551 ^ -1252298559)) - var5;
         if (var7 < 0) {
            var7 += 256;
         }

         for (int var8 = 0; var8 < var4.length; var8++) {
            int var9 = var8 % (-1252298557 ^ -1252298559);
            char var10002 = var4[var8];
            if (var9 == 0) {
               var4[var8] = (char)(var10002 ^ var6);
               var6 = ((var6 >>> (-1252298558 ^ -1252298559) | var6 << (-1252298556 ^ -1252298559)) ^ var4[var8]) & (-1252298690 ^ -1252298559);
            } else {
               var4[var8] = (char)(var10002 ^ var7);
               var7 = ((var7 >>> (-1252298558 ^ -1252298559) | var7 << (-1252298556 ^ -1252298559)) ^ var4[var8]) & (-1252298690 ^ -1252298559);
            }
         }

         b[var3] = new String(var4).intern();
      }

      return b[var3];
   }

   private static int a(int var0, long var1) {
      int var3 = var0 ^ (int)(var1 & (1234835303736049947L ^ 1234835303736082148L)) ^ -582448923 ^ -582429278;
      if (d[var3] == null) {
         d[var3] = (int)(c[var3] ^ var1);
      }

      return d[var3];
   }
}

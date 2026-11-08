package x;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import net.minecraft.util.Session;

public class ocd4bd33822b {
   private static final String ҟ = "00000000402b5328";
   private static final String ϙ = "service::user.auth.xboxlive.com::MBI_SSL";
   public static int Ԟ;
   private static final String[] a;
   private static final String[] b;
   private static final long[] c;
   private static final Integer[] d;

   private ocd4bd33822b() {
   }

   public static CompletableFuture<oc804fdd8d75> ѿ(String param0, Executor param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: ldc2_w -8987790519338995202
      // 003: ldc2_w -8987908977761347745
      // 006: lxor
      // 007: lstore 2
      // 008: lload 2
      // 009: dup2
      // 00a: ldc2_w -8987842450242156007
      // 00d: ldc2_w -8987908977761347745
      // 010: lxor
      // 011: lxor
      // 012: lstore 4
      // 014: dup2
      // 015: ldc2_w -8987885479041711914
      // 018: ldc2_w -8987908977761347745
      // 01b: lxor
      // 01c: lxor
      // 01d: dup2
      // 01e: ldc -795453804
      // 020: ldc -795453772
      // 022: ixor
      // 023: lushr
      // 024: l2i
      // 025: istore 6
      // 027: dup2
      // 028: ldc -795453804
      // 02a: ldc -795453772
      // 02c: ixor
      // 02d: lshl
      // 02e: ldc -795453820
      // 030: ldc -795453772
      // 032: ixor
      // 033: lushr
      // 034: l2i
      // 035: istore 7
      // 037: dup2
      // 038: ldc -795453820
      // 03a: ldc -795453772
      // 03c: ixor
      // 03d: lshl
      // 03e: ldc -795453820
      // 040: ldc -795453772
      // 042: ixor
      // 043: lushr
      // 044: l2i
      // 045: istore 8
      // 047: pop2
      // 048: dup2
      // 049: ldc2_w -8987792118021124227
      // 04c: ldc2_w -8987908977761347745
      // 04f: lxor
      // 050: lxor
      // 051: lstore 9
      // 053: pop2
      // 054: getstatic x/oc804fdd8d75.Ɔ I
      // 057: istore 11
      // 059: aload 0
      // 05a: iload 11
      // 05c: ifne 077
      // 05f: ifnull 07d
      // 062: goto 066
      // 065: athrow
      // 066: aload 0
      // 067: iload 11
      // 069: ifne 09f
      // 06c: goto 070
      // 06f: athrow
      // 070: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 073: goto 077
      // 076: athrow
      // 077: invokevirtual java/lang/String.isEmpty ()Z
      // 07a: ifeq 098
      // 07d: new java/util/concurrent/CompletableFuture
      // 080: dup
      // 081: invokespecial java/util/concurrent/CompletableFuture.<init> ()V
      // 084: astore 12
      // 086: aload 12
      // 088: new java/lang/IllegalArgumentException
      // 08b: dup
      // 08c: ldc "Empty refresh token"
      // 08e: invokespecial java/lang/IllegalArgumentException.<init> (Ljava/lang/String;)V
      // 091: invokevirtual java/util/concurrent/CompletableFuture.completeExceptionally (Ljava/lang/Throwable;)Z
      // 094: pop
      // 095: aload 12
      // 097: areturn
      // 098: ldc "00000000402b5328"
      // 09a: putstatic x/ocb616b6fa2e.ɀ Ljava/lang/String;
      // 09d: ldc "service::user.auth.xboxlive.com::MBI_SSL"
      // 09f: putstatic x/ocb616b6fa2e.õ Ljava/lang/String;
      // 0a2: new java/util/concurrent/atomic/AtomicReference
      // 0a5: dup
      // 0a6: aload 0
      // 0a7: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 0aa: invokespecial java/util/concurrent/atomic/AtomicReference.<init> (Ljava/lang/Object;)V
      // 0ad: astore 12
      // 0af: new java/util/concurrent/atomic/AtomicReference
      // 0b2: dup
      // 0b3: ldc ""
      // 0b5: invokespecial java/util/concurrent/atomic/AtomicReference.<init> (Ljava/lang/Object;)V
      // 0b8: astore 13
      // 0ba: aload 0
      // 0bb: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 0be: aload 1
      // 0bf: invokestatic x/ocb616b6fa2e.գ (Ljava/lang/String;Ljava/util/concurrent/Executor;)Ljava/util/concurrent/CompletableFuture;
      // 0c2: iload 6
      // 0c4: aload 12
      // 0c6: iload 7
      // 0c8: i2c
      // 0c9: iload 8
      // 0cb: aload 1
      // 0cc: invokedynamic apply (ILjava/util/concurrent/atomic/AtomicReference;CILjava/util/concurrent/Executor;)Ljava/util/function/Function; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Ljava/lang/Object;, x/ocd4bd33822b.q4wnltpuyvhqc (ILjava/util/concurrent/atomic/AtomicReference;CILjava/util/concurrent/Executor;Ljava/util/Map;)Ljava/util/concurrent/CompletionStage;, (Ljava/util/Map;)Ljava/util/concurrent/CompletionStage; ]
      // 0d1: aload 1
      // 0d2: invokevirtual java/util/concurrent/CompletableFuture.thenComposeAsync (Ljava/util/function/Function;Ljava/util/concurrent/Executor;)Ljava/util/concurrent/CompletableFuture;
      // 0d5: aload 1
      // 0d6: invokedynamic apply (Ljava/util/concurrent/Executor;)Ljava/util/function/Function; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Ljava/lang/Object;, x/ocd4bd33822b.q1gdgj0wwacemv (Ljava/util/concurrent/Executor;Ljava/lang/String;)Ljava/util/concurrent/CompletionStage;, (Ljava/lang/String;)Ljava/util/concurrent/CompletionStage; ]
      // 0db: aload 1
      // 0dc: invokevirtual java/util/concurrent/CompletableFuture.thenComposeAsync (Ljava/util/function/Function;Ljava/util/concurrent/Executor;)Ljava/util/concurrent/CompletableFuture;
      // 0df: lload 4
      // 0e1: aload 1
      // 0e2: invokedynamic apply (JLjava/util/concurrent/Executor;)Ljava/util/function/Function; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Ljava/lang/Object;, x/ocd4bd33822b.qgkfzlllalyyc (JLjava/util/concurrent/Executor;Ljava/util/Map;)Ljava/util/concurrent/CompletionStage;, (Ljava/util/Map;)Ljava/util/concurrent/CompletionStage; ]
      // 0e7: aload 1
      // 0e8: invokevirtual java/util/concurrent/CompletableFuture.thenComposeAsync (Ljava/util/function/Function;Ljava/util/concurrent/Executor;)Ljava/util/concurrent/CompletableFuture;
      // 0eb: aload 13
      // 0ed: aload 1
      // 0ee: invokedynamic apply (Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/Executor;)Ljava/util/function/Function; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Ljava/lang/Object;, x/ocd4bd33822b.qhwbnblesgybe (Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/Executor;Ljava/lang/String;)Ljava/util/concurrent/CompletionStage;, (Ljava/lang/String;)Ljava/util/concurrent/CompletionStage; ]
      // 0f3: aload 1
      // 0f4: invokevirtual java/util/concurrent/CompletableFuture.thenComposeAsync (Ljava/util/function/Function;Ljava/util/concurrent/Executor;)Ljava/util/concurrent/CompletableFuture;
      // 0f7: lload 9
      // 0f9: aload 12
      // 0fb: aload 13
      // 0fd: invokedynamic apply (JLjava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/atomic/AtomicReference;)Ljava/util/function/Function; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Ljava/lang/Object;, x/ocd4bd33822b.q1cc4nmukx0cfk (JLjava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/atomic/AtomicReference;Lnet/minecraft/util/Session;)Lx/oc804fdd8d75;, (Lnet/minecraft/util/Session;)Lx/oc804fdd8d75; ]
      // 102: invokevirtual java/util/concurrent/CompletableFuture.thenApply (Ljava/util/function/Function;)Ljava/util/concurrent/CompletableFuture;
      // 105: areturn
   }

   private static oc804fdd8d75 Œ(Session var0, String var1, long var2, String var4) {
      return new oc804fdd8d75(
         var1,
         var4,
         var0.getUsername(),
         0L,
         a((584469410 ^ -851944528) - (851942073 ^ -851944528), (584469410 ^ -851944528) - (851954943 ^ -851944528), (int)var2),
         a((584469410 ^ -851944528) - (851942068 ^ -851944528), (-584469410 ^ -851944528) - (-851951507 ^ -851944528), (int)var2),
         a((584469410 ^ -851944528) - (851942069 ^ -851944528), (584469410 ^ -851944528) - (851961092 ^ -851944528), (int)var2),
         var0.getPlayerID(),
         0L,
         0L
      );
   }

   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static String ų(short var0, Map var1, String var2, int var3, int var4) {
      long var5 = (long)var0 << (878996535 ^ 878996487)
         | (long)var3 << (878996519 ^ 878996487) >>> (878996503 ^ 878996487)
         | (long)var4 << (878996535 ^ 878996487) >>> (878996535 ^ 878996487);
      String var8 = null;
      int var10000 = oc804fdd8d75.Ɔ;
      int var9 = a(878977911 ^ 878996487, 2204654444310723569L ^ 1096297999488473959L ^ var5);
      int var7 = var10000;

      while (true) {
         switch (var9) {
            case 234278834:
               var8 = (String)var1.get(var2);

               label82: {
                  label81: {
                     label80: {
                        label99: {
                           try {
                              var10000 = var7;
                              if (var0 < 0) {
                                 break label82;
                              }

                              if (var7 != 0) {
                                 break label81;
                              }

                              if (var8 == null) {
                                 break label99;
                              }
                           } catch (IllegalArgumentException var12) {
                              throw var12;
                           }

                           var10000 = a(878998980 ^ 878996487, 4148415782512799046L ^ 1096297999488473959L ^ var5);
                           if (var4 <= 0) {
                              break label80;
                           }

                           var9 = var10000;
                           if (var7 == 0) {
                              continue;
                           }
                        }

                        var10000 = a(878969875 ^ 878996487, 3968497243775261846L ^ 1096297999488473959L ^ var5);
                     }

                     var9 = var10000;
                  }

                  var10000 = var7;
               }

               if (var0 < 0) {
                  break;
               }

               if (var10000 == 0) {
                  continue;
               }
            case 1088075391:
               try {
                  var10000 = var8.isEmpty();
                  break;
               } catch (IllegalArgumentException var10) {
                  throw var10;
               }
            case 711033324:
               throw new IllegalStateException(
                  a((1191305373 ^ 878996487) - (char)(-878984921 ^ 878996487), (1191305373 ^ 878996487) - (char)(-878999914 ^ 878996487), (int)var5) + var2
               );
            case 1977372354:
               return var8;
            default:
               throw null;
         }

         label59: {
            label58: {
               long var10001;
               long var10002;
               label57: {
                  label101: {
                     try {
                        if (var0 < 0) {
                           break label59;
                        }

                        if (var7 != 0) {
                           break label58;
                        }

                        if (var10000 == 0) {
                           break label101;
                        }
                     } catch (IllegalArgumentException var11) {
                        throw var11;
                     }

                     var10000 = 878990819 ^ 878996487;
                     var10001 = 4305302118295276900L ^ 1096297999488473959L;
                     var10002 = var5;
                     if (var3 <= 0) {
                        break label57;
                     }

                     var9 = a(var10000, var10001 ^ var5);
                     if (var7 == 0) {
                        continue;
                     }
                  }

                  var10000 = 878985047 ^ 878996487;
                  var10001 = 8181654265889187804L ^ 1096297999488473959L;
                  var10002 = var5;
               }

               var10000 = a(var10000, var10001 ^ var10002);
            }

            var9 = var10000;
            var10000 = var7;
         }

         if (var10000 != 0) {
            return var8;
         }
      }
   }

   // $VF: Irreducible bytecode was duplicated to produce valid code
   static {
      String[] var13 = new String[-57236313 ^ -57236305];
      int var11 = 0;
      String var10 = "CX\u009d_|\r<o\u009dåÛÙÖ\u0011w¹ÌwÛ\u0010\u0082\u0018\u0016¶cúf1r`}ÿÄîQ\f\f±/X<Ð\u0017Tãí\u00adéz\u0003Ã'\u0090(\u0091÷\u001dòQ¯\u0007¨¯]H²L½¼\u0095î²®aP\\à%±\u0094=\be9\u008e,\u008c\u009f¢6½µãd";
      int var12 = "CX\u009d_|\r<o\u009dåÛÙÖ\u0011w¹ÌwÛ\u0010\u0082\u0018\u0016¶cúf1r`}ÿÄîQ\f\f±/X<Ð\u0017Tãí\u00adéz\u0003Ã'\u0090(\u0091÷\u001dòQ¯\u0007¨¯]H²L½¼\u0095î²®aP\\à%±\u0094=\be9\u008e,\u008c\u009f¢6½µãd"
         .length();
      int var9 = -57236310 ^ -57236305;
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
                  var43[var10004] = (char)(var43[var10004] ^ switch (var14 % (-57236312 ^ -57236305)) {
                     case 0 -> -57236282 ^ -57236305;
                     case 1 -> -57236294 ^ -57236305;
                     case 2 -> -57236286 ^ -57236305;
                     case 3 -> -57236290 ^ -57236305;
                     case 4 -> -57236315 ^ -57236305;
                     case 5 -> -57236313 ^ -57236305;
                     default -> -57236254 ^ -57236305;
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
                     b = new String[-57236313 ^ -57236305];
                     long var0 = 8609467272340760159L ^ 8609376778286188433L;
                     long[] var6 = new long[-57236315 ^ -57236305];
                     int var3 = 0;
                     String var4 = "¤®ðÏRú\u0098-í¿ÍU\u0017\u008fë%GøzoVb®Ø¬±\u008e¶ÕU\u0013! ½:²çÂ|\u0094¹\u009b>×ÞOD_\u0084Ø\u0094Ä//-fNHs×¥\u008bÆx";
                     int var5 = "¤®ðÏRú\u0098-í¿ÍU\u0017\u008fë%GøzoVb®Ø¬±\u008e¶ÕU\u0013! ½:²çÂ|\u0094¹\u009b>×ÞOD_\u0084Ø\u0094Ä//-fNHs×¥\u008bÆx".length();
                     byte var2 = 0;

                     label44:
                     while (true) {
                        int var28 = var2;
                        var2 += 8;
                        byte[] var7 = var4.substring(var28, var2).getBytes("ISO-8859-1");
                        long[] var19 = var6;
                        var28 = var3++;
                        long var39 = (var7[0] & (8609376778286188398L ^ 8609376778286188433L)) << (-57236329 ^ -57236305)
                           | (var7[1] & (8609376778286188398L ^ 8609376778286188433L)) << (-57236321 ^ -57236305)
                           | (var7[-57236307 ^ -57236305] & (8609376778286188398L ^ 8609376778286188433L)) << (-57236345 ^ -57236305)
                           | (var7[-57236308 ^ -57236305] & (8609376778286188398L ^ 8609376778286188433L)) << (-57236337 ^ -57236305)
                           | (var7[-57236309 ^ -57236305] & (8609376778286188398L ^ 8609376778286188433L)) << (-57236297 ^ -57236305)
                           | (var7[-57236310 ^ -57236305] & (8609376778286188398L ^ 8609376778286188433L)) << (-57236289 ^ -57236305)
                           | (var7[-57236311 ^ -57236305] & (8609376778286188398L ^ 8609376778286188433L)) << (-57236313 ^ -57236305)
                           | var7[-57236312 ^ -57236305] & (8609376778286188398L ^ 8609376778286188433L);
                        byte var51 = -1;

                        while (true) {
                           long var54 = var39 ^ var0;
                           switch (var51) {
                              case 0:
                                 var19[var28] = var54;
                                 if (var2 >= var5) {
                                    c = var6;
                                    d = new Integer[-57236315 ^ -57236305];
                                    return;
                                 }
                                 break;
                              default:
                                 var19[var28] = var54;
                                 if (var2 < var5) {
                                    continue label44;
                                 }

                                 var4 = "´\u0097ûÚ\n§Ù\u0002®\u0018\rC\u001bÐÔf";
                                 var5 = "´\u0097ûÚ\n§Ù\u0002®\u0018\rC\u001bÐÔf".length();
                                 var2 = 0;
                           }

                           byte var30 = var2;
                           var2 += 8;
                           var7 = var4.substring(var30, var2).getBytes("ISO-8859-1");
                           var19 = var6;
                           var28 = var3++;
                           var39 = (var7[0] & (8609376778286188398L ^ 8609376778286188433L)) << (-57236329 ^ -57236305)
                              | (var7[1] & (8609376778286188398L ^ 8609376778286188433L)) << (-57236321 ^ -57236305)
                              | (var7[-57236307 ^ -57236305] & (8609376778286188398L ^ 8609376778286188433L)) << (-57236345 ^ -57236305)
                              | (var7[-57236308 ^ -57236305] & (8609376778286188398L ^ 8609376778286188433L)) << (-57236337 ^ -57236305)
                              | (var7[-57236309 ^ -57236305] & (8609376778286188398L ^ 8609376778286188433L)) << (-57236297 ^ -57236305)
                              | (var7[-57236310 ^ -57236305] & (8609376778286188398L ^ 8609376778286188433L)) << (-57236289 ^ -57236305)
                              | (var7[-57236311 ^ -57236305] & (8609376778286188398L ^ 8609376778286188433L)) << (-57236313 ^ -57236305)
                              | var7[-57236312 ^ -57236305] & (8609376778286188398L ^ 8609376778286188433L);
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

                  var10 = ",\u0095\u009fº\u009b2Þ\u001e \fÃ\u0004¿å\u0016¯\u0088?*\u0001 \u0095\u001e\u001er¶Ô\\Á\u0087ôý\u009e/\u008d\u009aúl";
                  var12 = ",\u0095\u009fº\u009b2Þ\u001e \fÃ\u0004¿å\u0016¯\u0088?*\u0001 \u0095\u001e\u001er¶Ô\\Á\u0087ôý\u009e/\u008d\u009aúl".length();
                  var9 = -57236312 ^ -57236305;
                  var17 = -1;
            }

            var10000 = var10.substring(++var17, var17 + var9);
            var10001 = 0;
         }
      }
   }

   private static String a(int var0, int var1, int var2) {
      int var3 = (var0 ^ var2 ^ 752799135 ^ 752785495) & (752773032 ^ 752785495);
      if (b[var3] == null) {
         char[] var4 = a[var3].toCharArray();

         int var5 = switch (var4[0] & (752785576 ^ 752785495)) {
            case 0 -> 752785430 ^ 752785495;
            case 1 -> 752785440 ^ 752785495;
            case 2 -> 752785585 ^ 752785495;
            case 3 -> 752785486 ^ 752785495;
            case 4 -> 752785603 ^ 752785495;
            case 5 -> 752785471 ^ 752785495;
            case 6 -> 752785435 ^ 752785495;
            case 7 -> 752785529 ^ 752785495;
            case 8 -> 752785605 ^ 752785495;
            case 9 -> 752785579 ^ 752785495;
            case 10 -> 752785422 ^ 752785495;
            case 11 -> 752785442 ^ 752785495;
            case 12 -> 752785551 ^ 752785495;
            case 13 -> 752785620 ^ 752785495;
            case 14 -> 752785408 ^ 752785495;
            case 15 -> 752785485 ^ 752785495;
            case 16 -> 752785546 ^ 752785495;
            case 17 -> 752785503 ^ 752785495;
            case 18 -> 752785607 ^ 752785495;
            case 19 -> 752785462 ^ 752785495;
            case 20 -> 752785563 ^ 752785495;
            case 21 -> 752785419 ^ 752785495;
            case 22 -> 752785508 ^ 752785495;
            case 23 -> 752785578 ^ 752785495;
            case 24 -> 752785643 ^ 752785495;
            case 25 -> 752785564 ^ 752785495;
            case 26 -> 752785514 ^ 752785495;
            case 27 -> 752785571 ^ 752785495;
            case 28 -> 752785632 ^ 752785495;
            case 29 -> 752785504 ^ 752785495;
            case 30 -> 752785515 ^ 752785495;
            case 31 -> 752785498 ^ 752785495;
            case 32 -> 752785639 ^ 752785495;
            case 33 -> 752785511 ^ 752785495;
            case 34 -> 752785540 ^ 752785495;
            case 35 -> 752785593 ^ 752785495;
            case 36 -> 752785436 ^ 752785495;
            case 37 -> 752785428 ^ 752785495;
            case 38 -> 752785446 ^ 752785495;
            case 39 -> 752785594 ^ 752785495;
            case 40 -> 752785658 ^ 752785495;
            case 41 -> 752785417 ^ 752785495;
            case 42 -> 752785434 ^ 752785495;
            case 43 -> 1;
            case 44 -> 752785510 ^ 752785495;
            case 45 -> 752785509 ^ 752785495;
            case 46 -> 752785431 ^ 752785495;
            case 47 -> 752785648 ^ 752785495;
            case 48 -> 752785584 ^ 752785495;
            case 49 -> 752785413 ^ 752785495;
            case 50 -> 752785491 ^ 752785495;
            case 51 -> 752785650 ^ 752785495;
            case 52 -> 752785580 ^ 752785495;
            case 53 -> 752785538 ^ 752785495;
            case 54 -> 752785576 ^ 752785495;
            case 55 -> 752785480 ^ 752785495;
            case 56 -> 752785539 ^ 752785495;
            case 57 -> 752785609 ^ 752785495;
            case 58 -> 752785588 ^ 752785495;
            case 59 -> 752785644 ^ 752785495;
            case 60 -> 752785481 ^ 752785495;
            case 61 -> 752785598 ^ 752785495;
            case 62 -> 752785461 ^ 752785495;
            case 63 -> 752785558 ^ 752785495;
            case 64 -> 752785597 ^ 752785495;
            case 65 -> 752785506 ^ 752785495;
            case 66 -> 752785518 ^ 752785495;
            case 67 -> 752785659 ^ 752785495;
            case 68 -> 752785655 ^ 752785495;
            case 69 -> 752785457 ^ 752785495;
            case 70 -> 752785487 ^ 752785495;
            case 71 -> 752785630 ^ 752785495;
            case 72 -> 752785610 ^ 752785495;
            case 73 -> 752785647 ^ 752785495;
            case 74 -> 752785602 ^ 752785495;
            case 75 -> 752785590 ^ 752785495;
            case 76 -> 752785606 ^ 752785495;
            case 77 -> 752785574 ^ 752785495;
            case 78 -> 752785439 ^ 752785495;
            case 79 -> 752785619 ^ 752785495;
            case 80 -> 752785629 ^ 752785495;
            case 81 -> 752785464 ^ 752785495;
            case 82 -> 752785549 ^ 752785495;
            case 83 -> 752785520 ^ 752785495;
            case 84 -> 752785512 ^ 752785495;
            case 85 -> 752785450 ^ 752785495;
            case 86 -> 752785592 ^ 752785495;
            case 87 -> 752785456 ^ 752785495;
            case 88 -> 752785547 ^ 752785495;
            case 89 -> 752785614 ^ 752785495;
            case 90 -> 752785517 ^ 752785495;
            case 91 -> 752785493 ^ 752785495;
            case 92 -> 752785455 ^ 752785495;
            case 93 -> 752785531 ^ 752785495;
            case 94 -> 752785561 ^ 752785495;
            case 95 -> 752785445 ^ 752785495;
            case 96 -> 752785587 ^ 752785495;
            case 97 -> 752785437 ^ 752785495;
            case 98 -> 752785641 ^ 752785495;
            case 99 -> 752785583 ^ 752785495;
            case 100 -> 752785465 ^ 752785495;
            case 101 -> 752785552 ^ 752785495;
            case 102 -> 752785624 ^ 752785495;
            case 103 -> 752785572 ^ 752785495;
            case 104 -> 752785649 ^ 752785495;
            case 105 -> 752785477 ^ 752785495;
            case 106 -> 752785656 ^ 752785495;
            case 107 -> 752785634 ^ 752785495;
            case 108 -> 752785415 ^ 752785495;
            case 109 -> 752785460 ^ 752785495;
            case 110 -> 752785441 ^ 752785495;
            case 111 -> 752785492 ^ 752785495;
            case 112 -> 752785444 ^ 752785495;
            case 113 -> 752785654 ^ 752785495;
            case 114 -> 752785618 ^ 752785495;
            case 115 -> 752785542 ^ 752785495;
            case 116 -> 752785427 ^ 752785495;
            case 117 -> 752785533 ^ 752785495;
            case 118 -> 752785526 ^ 752785495;
            case 119 -> 752785521 ^ 752785495;
            case 120 -> 752785476 ^ 752785495;
            case 121 -> 752785660 ^ 752785495;
            case 122 -> 752785577 ^ 752785495;
            case 123 -> 752785524 ^ 752785495;
            case 124 -> 752785596 ^ 752785495;
            case 125 -> 752785663 ^ 752785495;
            case 126 -> 752785573 ^ 752785495;
            case 127 -> 752785640 ^ 752785495;
            case 128 -> 752785543 ^ 752785495;
            case 129 -> 752785631 ^ 752785495;
            case 130 -> 752785601 ^ 752785495;
            case 131 -> 752785499 ^ 752785495;
            case 132 -> 752785475 ^ 752785495;
            case 133 -> 752785449 ^ 752785495;
            case 134 -> 752785489 ^ 752785495;
            case 135 -> 752785414 ^ 752785495;
            case 136 -> 752785608 ^ 752785495;
            case 137 -> 752785555 ^ 752785495;
            case 138 -> 752785628 ^ 752785495;
            case 139 -> 752785570 ^ 752785495;
            case 140 -> 752785535 ^ 752785495;
            case 141 -> 752785482 ^ 752785495;
            case 142 -> 752785507 ^ 752785495;
            case 143 -> 752785469 ^ 752785495;
            case 144 -> 752785652 ^ 752785495;
            case 145 -> 752785426 ^ 752785495;
            case 146 -> 752785516 ^ 752785495;
            case 147 -> 752785438 ^ 752785495;
            case 148 -> 752785534 ^ 752785495;
            case 149 -> 752785496 ^ 752785495;
            case 150 -> 752785479 ^ 752785495;
            case 151 -> 752785528 ^ 752785495;
            case 152 -> 752785604 ^ 752785495;
            case 153 -> 752785527 ^ 752785495;
            case 154 -> 752785409 ^ 752785495;
            case 155 -> 752785581 ^ 752785495;
            case 156 -> 752785657 ^ 752785495;
            case 157 -> 752785421 ^ 752785495;
            case 158 -> 752785497 ^ 752785495;
            case 159 -> 752785473 ^ 752785495;
            case 160 -> 752785622 ^ 752785495;
            case 161 -> 752785433 ^ 752785495;
            case 162 -> 752785459 ^ 752785495;
            case 163 -> 752785599 ^ 752785495;
            case 164 -> 752785636 ^ 752785495;
            case 165 -> 752785447 ^ 752785495;
            case 166 -> 752785411 ^ 752785495;
            case 167 -> 752785638 ^ 752785495;
            case 168 -> 752785468 ^ 752785495;
            case 169 -> 752785470 ^ 752785495;
            case 170 -> 752785544 ^ 752785495;
            case 171 -> 752785553 ^ 752785495;
            case 172 -> 752785569 ^ 752785495;
            case 173 -> 752785410 ^ 752785495;
            case 174 -> 752785513 ^ 752785495;
            case 175 -> 752785525 ^ 752785495;
            case 176 -> 752785662 ^ 752785495;
            case 177 -> 752785416 ^ 752785495;
            case 178 -> 752785505 ^ 752785495;
            case 179 -> 752785562 ^ 752785495;
            case 180 -> 752785474 ^ 752785495;
            case 181 -> 752785545 ^ 752785495;
            case 182 -> 752785621 ^ 752785495;
            case 183 -> 752785432 ^ 752785495;
            case 184 -> 752785557 ^ 752785495;
            case 185 -> 752785490 ^ 752785495;
            case 186 -> 752785452 ^ 752785495;
            case 187 -> 752785412 ^ 752785495;
            case 188 -> 752785541 ^ 752785495;
            case 189 -> 752785483 ^ 752785495;
            case 190 -> 752785478 ^ 752785495;
            case 191 -> 752785451 ^ 752785495;
            case 192 -> 752785443 ^ 752785495;
            case 193 -> 752785653 ^ 752785495;
            case 194 -> 752785484 ^ 752785495;
            case 195 -> 752785637 ^ 752785495;
            case 196 -> 752785429 ^ 752785495;
            case 197 -> 752785554 ^ 752785495;
            case 198 -> 752785661 ^ 752785495;
            case 199 -> 752785589 ^ 752785495;
            case 200 -> 752785568 ^ 752785495;
            case 201 -> 752785612 ^ 752785495;
            case 202 -> 752785466 ^ 752785495;
            case 203 -> 752785548 ^ 752785495;
            case 204 -> 752785488 ^ 752785495;
            case 205 -> 752785642 ^ 752785495;
            case 206 -> 752785595 ^ 752785495;
            case 207 -> 752785613 ^ 752785495;
            case 208 -> 752785651 ^ 752785495;
            case 209 -> 752785566 ^ 752785495;
            case 210 -> 752785523 ^ 752785495;
            case 211 -> 752785519 ^ 752785495;
            case 212 -> 752785537 ^ 752785495;
            case 213 -> 752785565 ^ 752785495;
            case 214 -> 752785425 ^ 752785495;
            case 215 -> 752785502 ^ 752785495;
            case 216 -> 752785617 ^ 752785495;
            case 217 -> 752785645 ^ 752785495;
            case 218 -> 752785559 ^ 752785495;
            case 219 -> 752785500 ^ 752785495;
            case 220 -> 752785501 ^ 752785495;
            case 221 -> 752785626 ^ 752785495;
            case 222 -> 752785616 ^ 752785495;
            case 223 -> 752785567 ^ 752785495;
            case 224 -> 752785420 ^ 752785495;
            case 225 -> 752785467 ^ 752785495;
            case 226 -> 752785453 ^ 752785495;
            case 227 -> 752785591 ^ 752785495;
            case 228 -> 752785615 ^ 752785495;
            case 229 -> 752785623 ^ 752785495;
            case 230 -> 752785550 ^ 752785495;
            case 231 -> 752785625 ^ 752785495;
            case 232 -> 752785532 ^ 752785495;
            case 233 -> 752785556 ^ 752785495;
            case 234 -> 752785646 ^ 752785495;
            case 235 -> 752785522 ^ 752785495;
            case 236 -> 752785611 ^ 752785495;
            case 237 -> 752785448 ^ 752785495;
            case 238 -> 752785627 ^ 752785495;
            case 239 -> 752785530 ^ 752785495;
            case 240 -> 752785633 ^ 752785495;
            case 241 -> 752785458 ^ 752785495;
            case 242 -> 0;
            case 243 -> 752785560 ^ 752785495;
            case 244 -> 752785454 ^ 752785495;
            case 245 -> 752785586 ^ 752785495;
            case 246 -> 752785418 ^ 752785495;
            case 247 -> 752785463 ^ 752785495;
            case 248 -> 752785424 ^ 752785495;
            case 249 -> 752785635 ^ 752785495;
            case 250 -> 752785600 ^ 752785495;
            case 251 -> 752785423 ^ 752785495;
            case 252 -> 752785575 ^ 752785495;
            case 253 -> 752785536 ^ 752785495;
            case 254 -> 752785472 ^ 752785495;
            default -> 752785582 ^ 752785495;
         };
         int var10;
         int var6 = ((var10 = var1 ^ var2) & (752785576 ^ 752785495)) - var5;
         if (var6 < 0) {
            var6 += 256;
         }

         int var7 = ((var10 & (752773032 ^ 752785495)) >>> (752785503 ^ 752785495)) - var5;
         if (var7 < 0) {
            var7 += 256;
         }

         for (int var8 = 0; var8 < var4.length; var8++) {
            int var9 = var8 % (752785493 ^ 752785495);
            char var10002 = var4[var8];
            if (var9 == 0) {
               var4[var8] = (char)(var10002 ^ var6);
               var6 = ((var6 >>> (752785492 ^ 752785495) | var6 << (752785490 ^ 752785495)) ^ var4[var8]) & (752785576 ^ 752785495);
            } else {
               var4[var8] = (char)(var10002 ^ var7);
               var7 = ((var7 >>> (752785492 ^ 752785495) | var7 << (752785490 ^ 752785495)) ^ var4[var8]) & (752785576 ^ 752785495);
            }
         }

         b[var3] = new String(var4).intern();
      }

      return b[var3];
   }

   private static int a(int var0, long var1) {
      int var3 = var0 ^ (int)(var1 & (-1488448914857524887L ^ -1488448914857492842L)) ^ -345132809 ^ -345123423;
      if (d[var3] == null) {
         d[var3] = (int)(c[var3] ^ var1);
      }

      return d[var3];
   }
}

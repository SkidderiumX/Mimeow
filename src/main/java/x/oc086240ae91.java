package x;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;
import net.minecraft.util.Session;
import net.minecraft.util.Session.Type;
import net.raphimc.minecraftauth.MinecraftAuth;
import net.raphimc.minecraftauth.java.JavaAuthManager;
import net.raphimc.minecraftauth.java.model.MinecraftProfile;
import net.raphimc.minecraftauth.java.model.MinecraftToken;
import net.raphimc.minecraftauth.msa.model.MsaDeviceCode;
import net.raphimc.minecraftauth.msa.service.impl.DeviceCodeMsaAuthService;

public class oc086240ae91 {
   private static final String ī = "Miau/2.5";
   public static int յ;
   private static final String a;
   private static final long[] b;
   private static final Integer[] c;

   private oc086240ae91() {
   }

   public static oc6bcef73ceb ү(Consumer<MsaDeviceCode> var0) throws IOException, InterruptedException, TimeoutException {
      JavaAuthManager var1 = JavaAuthManager.create(MinecraftAuth.createHttpClient("Miau/2.5")).login(DeviceCodeMsaAuthService::new, var0);
      return T(var1);
   }

   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static oc6bcef73ceb ǿ(String var0) throws IOException {
      int var10000 = oc804fdd8d75.Ɔ;
      JsonElement var2 = new JsonParser().parse(var0);
      int var1 = var10000;

      label31: {
         label30: {
            label29: {
               try {
                  var7 = var2;
                  if (var1 != 0) {
                     break label29;
                  }

                  if (var2 == null) {
                     break label30;
                  }
               } catch (IOException var6) {
                  throw var6;
               }

               var7 = var2;
            }

            try {
               if (var7.isJsonObject()) {
                  break label31;
               }
            } catch (IOException var5) {
               throw var5;
            }
         }

         try {
            throw new IOException("Saved Microsoft login is invalid");
         } catch (IOException var4) {
            throw var4;
         }
      }

      JavaAuthManager var3 = JavaAuthManager.fromJson(MinecraftAuth.createHttpClient("Miau/2.5"), var2.getAsJsonObject());
      return T(var3);
   }

   public static oc6bcef73ceb x(String param0) throws IOException {
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
      // 06: ifne 11
      // 09: ifnull 1f
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 0
      // 11: iload 1
      // 12: ifne 2c
      // 15: invokevirtual java/lang/String.isEmpty ()Z
      // 18: ifeq 2a
      // 1b: goto 1f
      // 1e: athrow
      // 1f: new java/io/IOException
      // 22: dup
      // 23: ldc "Saved Microsoft login has expired. Add the account again."
      // 25: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 28: athrow
      // 29: athrow
      // 2a: ldc "Miau/2.5"
      // 2c: invokestatic net/raphimc/minecraftauth/MinecraftAuth.createHttpClient (Ljava/lang/String;)Lnet/lenni0451/commons/httpclient/HttpClient;
      // 2f: invokestatic net/raphimc/minecraftauth/java/JavaAuthManager.create (Lnet/lenni0451/commons/httpclient/HttpClient;)Lnet/raphimc/minecraftauth/java/JavaAuthManager$Builder;
      // 32: aload 0
      // 33: invokevirtual net/raphimc/minecraftauth/java/JavaAuthManager$Builder.login (Ljava/lang/String;)Lnet/raphimc/minecraftauth/java/JavaAuthManager;
      // 36: astore 2
      // 37: aload 2
      // 38: invokestatic x/oc086240ae91.T (Lnet/raphimc/minecraftauth/java/JavaAuthManager;)Lx/oc6bcef73ceb;
      // 3b: areturn
   }

   public static String W(Throwable param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: ldc2_w 2983986826268772854
      // 003: ldc2_w 2984005142442398504
      // 006: lxor
      // 007: lstore 1
      // 008: lload 1
      // 009: dup2
      // 00a: ldc2_w 2983943670516242407
      // 00d: ldc2_w 2984005142442398504
      // 010: lxor
      // 011: lxor
      // 012: lstore 3
      // 013: dup2
      // 014: ldc2_w 2983941148865221821
      // 017: ldc2_w 2984005142442398504
      // 01a: lxor
      // 01b: lxor
      // 01c: lstore 5
      // 01e: dup2
      // 01f: ldc2_w 2983994576315176083
      // 022: ldc2_w 2984005142442398504
      // 025: lxor
      // 026: lxor
      // 027: lstore 7
      // 029: pop2
      // 02a: getstatic x/oc804fdd8d75.Ɔ I
      // 02d: aload 0
      // 02e: lload 5
      // 030: invokestatic x/oc086240ae91.ԁ (Ljava/lang/Throwable;J)Ljava/lang/Throwable;
      // 033: astore 10
      // 035: istore 9
      // 037: aload 10
      // 039: iload 9
      // 03b: ifne 04e
      // 03e: instanceof java/util/concurrent/TimeoutException
      // 041: ifeq 04c
      // 044: goto 048
      // 047: athrow
      // 048: ldc "Microsoft login timed out"
      // 04a: areturn
      // 04b: athrow
      // 04c: aload 10
      // 04e: iload 9
      // 050: ifne 063
      // 053: instanceof java/lang/InterruptedException
      // 056: ifne 072
      // 059: goto 05d
      // 05c: athrow
      // 05d: aload 10
      // 05f: goto 063
      // 062: athrow
      // 063: iload 9
      // 065: ifne 078
      // 068: instanceof java/util/concurrent/CancellationException
      // 06b: ifeq 076
      // 06e: goto 072
      // 071: athrow
      // 072: ldc "Microsoft login cancelled"
      // 074: areturn
      // 075: athrow
      // 076: aload 10
      // 078: iload 9
      // 07a: ifne 0b7
      // 07d: instanceof net/raphimc/minecraftauth/util/http/exception/ApiHttpRequestException
      // 080: ifeq 0b5
      // 083: goto 087
      // 086: athrow
      // 087: aload 10
      // 089: iload 9
      // 08b: ifne 0b7
      // 08e: goto 092
      // 091: athrow
      // 092: checkcast net/raphimc/minecraftauth/util/http/exception/ApiHttpRequestException
      // 095: astore 11
      // 097: aload 11
      // 099: invokevirtual net/raphimc/minecraftauth/util/http/exception/ApiHttpRequestException.getErrorMessage ()Ljava/lang/String;
      // 09c: aload 11
      // 09e: invokevirtual net/raphimc/minecraftauth/util/http/exception/ApiHttpRequestException.getError ()Ljava/lang/String;
      // 0a1: lload 3
      // 0a2: invokestatic x/oc086240ae91.ǖ (Ljava/lang/String;Ljava/lang/String;J)Ljava/lang/String;
      // 0a5: astore 12
      // 0a7: aload 12
      // 0a9: ifnull 0b5
      // 0ac: lload 7
      // 0ae: aload 12
      // 0b0: invokestatic x/oc086240ae91.Ʋ (JLjava/lang/String;)Ljava/lang/String;
      // 0b3: areturn
      // 0b4: athrow
      // 0b5: aload 10
      // 0b7: iload 9
      // 0b9: ifne 0f4
      // 0bc: instanceof net/lenni0451/commons/httpclient/exceptions/HttpRequestException
      // 0bf: ifeq 0f2
      // 0c2: goto 0c6
      // 0c5: athrow
      // 0c6: aload 10
      // 0c8: checkcast net/lenni0451/commons/httpclient/exceptions/HttpRequestException
      // 0cb: iload 9
      // 0cd: ifne 0f4
      // 0d0: goto 0d4
      // 0d3: athrow
      // 0d4: astore 11
      // 0d6: aload 11
      // 0d8: invokevirtual net/lenni0451/commons/httpclient/exceptions/HttpRequestException.getResponse ()Lnet/lenni0451/commons/httpclient/HttpResponse;
      // 0db: ifnull 0f2
      // 0de: aload 11
      // 0e0: invokevirtual net/lenni0451/commons/httpclient/exceptions/HttpRequestException.getResponse ()Lnet/lenni0451/commons/httpclient/HttpResponse;
      // 0e3: invokevirtual net/lenni0451/commons/httpclient/HttpResponse.getStatusCode ()I
      // 0e6: ldc "Microsoft login failed (HTTP "
      // 0e8: swap
      // 0e9: ldc ")"
      // 0eb: invokedynamic makeConcatWithConstants (Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001" ]
      // 0f0: areturn
      // 0f1: athrow
      // 0f2: aload 10
      // 0f4: iload 9
      // 0f6: ifne 107
      // 0f9: ifnonnull 105
      // 0fc: goto 100
      // 0ff: athrow
      // 100: aconst_null
      // 101: goto 10a
      // 104: athrow
      // 105: aload 10
      // 107: invokevirtual java/lang/Throwable.getMessage ()Ljava/lang/String;
      // 10a: astore 11
      // 10c: aload 11
      // 10e: iload 9
      // 110: ifne 138
      // 113: ifnull 132
      // 116: goto 11a
      // 119: athrow
      // 11a: aload 11
      // 11c: iload 9
      // 11e: ifne 140
      // 121: goto 125
      // 124: athrow
      // 125: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 128: invokevirtual java/lang/String.isEmpty ()Z
      // 12b: ifeq 139
      // 12e: goto 132
      // 131: athrow
      // 132: ldc "Microsoft login failed"
      // 134: goto 138
      // 137: athrow
      // 138: areturn
      // 139: lload 7
      // 13b: aload 11
      // 13d: invokestatic x/oc086240ae91.Ʋ (JLjava/lang/String;)Ljava/lang/String;
      // 140: areturn
   }

   private static oc6bcef73ceb T(JavaAuthManager var0) throws IOException {
      MinecraftToken var1 = (MinecraftToken)var0.getMinecraftToken().getUpToDate();
      MinecraftProfile var2 = (MinecraftProfile)var0.getMinecraftProfile().getUpToDate();
      String var3 = var2.getId().toString().replace("-", "");
      Session var4 = new Session(var2.getName(), var3, var1.getToken(), Type.MOJANG.toString());
      return new oc6bcef73ceb(
         var4, JavaAuthManager.toJson(var0).toString(), var0.getMsaApplicationConfig().getClientId(), var0.getMsaApplicationConfig().getScope()
      );
   }

   private static Throwable ԁ(Throwable param0, long param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc804fdd8d75.Ɔ I
      // 03: aload 0
      // 04: astore 4
      // 06: istore 3
      // 07: aload 4
      // 09: instanceof java/util/concurrent/CompletionException
      // 0c: ifne 2d
      // 0f: aload 4
      // 11: iload 3
      // 12: lload 1
      // 13: lconst_1
      // 14: lcmp
      // 15: ifle 1c
      // 18: ifne 3e
      // 1b: iload 3
      // 1c: ifne 54
      // 1f: goto 23
      // 22: athrow
      // 23: instanceof java/util/concurrent/ExecutionException
      // 26: ifeq 4c
      // 29: goto 2d
      // 2c: athrow
      // 2d: aload 4
      // 2f: iload 3
      // 30: ifne 54
      // 33: goto 37
      // 36: athrow
      // 37: invokevirtual java/lang/Throwable.getCause ()Ljava/lang/Throwable;
      // 3a: goto 3e
      // 3d: athrow
      // 3e: ifnull 4c
      // 41: aload 4
      // 43: invokevirtual java/lang/Throwable.getCause ()Ljava/lang/Throwable;
      // 46: astore 4
      // 48: iload 3
      // 49: ifeq 07
      // 4c: lload 1
      // 4d: lconst_1
      // 4e: lcmp
      // 4f: ifle 48
      // 52: aload 4
      // 54: areturn
   }

   private static String ǖ(String var0, String var1, long var2) {
      int var4 = oc804fdd8d75.Ɔ;
      int var5 = a(1685042281 ^ 1685054608, 6844332972501970375L ^ 4616191517161914529L ^ var2);

      label134:
      while (true) {
         int var10000 = var5;

         label127:
         while (true) {
            switch (var10000) {
               case -1979908390:
                  label117: {
                     label142: {
                        label115: {
                           long var10001;
                           long var10002;
                           label114: {
                              label143: {
                                 try {
                                    var10000 = var1.trim().isEmpty();
                                    if (var2 < 1L) {
                                       break label142;
                                    }

                                    if (var4 != 0) {
                                       break label115;
                                    }

                                    if (var10000 != 0) {
                                       break label143;
                                    }
                                 } catch (CancellationException var7) {
                                    throw var7;
                                 }

                                 var10000 = 1685058087 ^ 1685054608;
                                 var10001 = 6674322379240729494L ^ 4616191517161914529L;
                                 var10002 = var2;
                                 if (var2 < 0L) {
                                    break label114;
                                 }

                                 var5 = a(var10000, var10001 ^ var2);
                                 if (var4 == 0) {
                                    continue label134;
                                 }
                              }

                              var10000 = 1685047387 ^ 1685054608;
                              var10001 = 9126369877713080809L ^ 4616191517161914529L;
                              var10002 = var2;
                           }

                           var10000 = a(var10000, var10001 ^ var10002);
                        }

                        var5 = var10000;
                        if (var2 < 1L) {
                           break label117;
                        }

                        var10000 = var4;
                     }

                     if (var10000 == 0) {
                        continue label134;
                     }
                  }
               case -2064529486:
                  label95: {
                     label94: {
                        long var12;
                        label93: {
                           label140: {
                              try {
                                 var10000 = var0.trim().isEmpty();
                                 if (var2 <= 1L) {
                                    break label95;
                                 }

                                 if (var4 != 0) {
                                    break label94;
                                 }

                                 if (var10000 != 0) {
                                    break label140;
                                 }
                              } catch (CancellationException var6) {
                                 throw var6;
                              }

                              var10000 = 1685060578 ^ 1685054608;
                              var12 = 7046083912310055488L ^ 4616191517161914529L ^ var2;
                              if (var2 <= 0L) {
                                 break label93;
                              }

                              var5 = a(var10000, var12);
                              if (var4 == 0) {
                                 continue label134;
                              }
                           }

                           var10000 = 1685036818 ^ 1685054608;
                           var12 = 6019014090615588538L ^ 4616191517161914529L ^ var2;
                        }

                        var10000 = a(var10000, var12);
                     }

                     var5 = var10000;
                     var10000 = var4;
                  }

                  if (var2 <= 1L) {
                     continue;
                  }

                  if (var10000 == 0) {
                     continue label134;
                  }
                  break;
               case -520357583:
                  return null;
               case -429554440:
                  break label127;
               case 246546581:
                  break;
               case 504006592:
                  return var0;
               case 1794799295:
                  return var1;
               default:
                  throw null;
            }

            long var13;
            label145: {
               if (var0 != null) {
                  var10000 = 1685030947 ^ 1685054608;
                  var13 = 2582662366933913987L ^ 4616191517161914529L;
                  if (var2 <= 0L) {
                     break label145;
                  }

                  var5 = a(var10000, var13 ^ var2);
                  if (var4 == 0) {
                     continue label134;
                  }
               }

               var10000 = 1685038809 ^ 1685054608;
               if (var2 <= 0L) {
                  continue;
               }

               var13 = 5308702319777431408L ^ 4616191517161914529L ^ var2;
            }

            var5 = a(var10000, var13);
            if (var4 == 0) {
               continue label134;
            }
            break;
         }

         long var14;
         long var15;
         label62: {
            if (var1 != null) {
               var10000 = 1685033124 ^ 1685054608;
               var14 = 3795651326025173248L ^ 4616191517161914529L;
               var15 = var2;
               if (var2 <= 0L) {
                  break label62;
               }

               var5 = a(var10000, var14 ^ var2);
               if (var4 == 0) {
                  continue;
               }
            }

            var10000 = 1685032118 ^ 1685054608;
            var14 = 1710153207615395089L ^ 4616191517161914529L;
            var15 = var2;
         }

         var5 = a(var10000, var14 ^ var15);
         if (var4 != 0) {
            return var0;
         }
      }
   }

   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static String Ʋ(long var0, String var2) {
      String var4 = null;
      int var10000 = oc804fdd8d75.Ɔ;
      int var5 = a(-215341049 ^ -215348559, 7340569274451176157L ^ 3074403358547965570L ^ var0);
      int var3 = var10000;

      while (true) {
         switch (var5) {
            case -620929699:
               return var4.substring(0, a(-215333714 ^ -215348559, 6392009857527760507L ^ 3074403358547965570L ^ var0)) + a;
            case -310553228:
               return var4;
            case 1237824304:
               String var8 = var2.replace(
                     (char)a(-215320512 ^ -215348559, 816312111622716061L ^ 3074403358547965570L ^ var0),
                     (char)a(-215330519 ^ -215348559, 128308553230832633L ^ 3074403358547965570L ^ var0)
                  )
                  .replace(
                     (char)a(-215337975 ^ -215348559, 9136111977668392655L ^ 3074403358547965570L ^ var0),
                     (char)a(-215338995 ^ -215348559, 5563312230050607830L ^ 3074403358547965570L ^ var0)
                  )
                  .replace(
                     (char)a(-215336573 ^ -215348559, 367688849178835796L ^ 3074403358547965570L ^ var0),
                     (char)a(-215338995 ^ -215348559, 5563312230050607830L ^ 3074403358547965570L ^ var0)
                  );
               if (var0 >= 1L) {
                  var4 = var8.trim();

                  try {
                     if (var3 != 0) {
                        break;
                     }

                     var8 = var4;
                  } catch (CancellationException var6) {
                     throw var6;
                  }
               }

               label46: {
                  long var10001;
                  label45: {
                     label53: {
                        try {
                           var10000 = var8.length();
                           if (var0 <= 0L) {
                              break label46;
                           }

                           if (var10000 > a(-215335340 ^ -215348559, 4113322868544060551L ^ 3074403358547965570L ^ var0)) {
                              break label53;
                           }
                        } catch (CancellationException var7) {
                           throw var7;
                        }

                        var10000 = -215330769 ^ -215348559;
                        var10001 = 4612094013456208627L ^ 3074403358547965570L;
                        if (var0 < 1L) {
                           break label45;
                        }

                        var5 = a(var10000, var10001 ^ var0);
                        if (var3 == 0) {
                           break;
                        }
                     }

                     var10000 = -215330463 ^ -215348559;
                     var10001 = 5145297172275745720L ^ 3074403358547965570L ^ var0;
                  }

                  var10000 = a(var10000, var10001);
               }

               var5 = var10000;
               break;
            default:
               throw null;
         }
      }
   }

   // $VF: Irreducible bytecode was duplicated to produce valid code
   static {
      char[] var10001 = "1R|".toCharArray();
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
         switch (var8 % (-422388684 ^ -422388685)) {
            case 0:
               var10006 = -422388692 ^ -422388685;
               break;
            case 1:
               var10006 = -422388657 ^ -422388685;
               break;
            case 2:
               var10006 = -422388639 ^ -422388685;
               break;
            case 3:
               var10006 = -422388663 ^ -422388685;
               break;
            case 4:
               var10006 = -422388649 ^ -422388685;
               break;
            case 5:
               var10006 = -422388683 ^ -422388685;
               break;
            default:
               var10006 = -422388693 ^ -422388685;
         }
      } else {
         var34 = var10001;
         var21 = var10003;
         if (var10003 <= var8) {
            String var54 = new String(var10001).intern();
            byte var29 = -1;
            a = var54;
            long var9 = 1524691895972424994L ^ 1524749822860389361L;
            long[] var14 = new long[-422388704 ^ -422388685];
            int var11 = 0;
            String var12 = "ì¦!§¹Ô\u000eRÕh]ù&Ú\u0016F=u\rI\u0092'=ãV\u0019;,\u0013Kêf¬W\u001a)Ýü/¹S%TlGø\u0010\u009fMK¹\u0082E\u0000þí\u0001ù\u0016èõj´C¹g¢´\u0001«Z!\u0007\u0093ãÐô=ãë:6Ñs\u001eI*³L\u0089¶M\u0012é×¤\u008ae#üðÿ´ÙÆlµ¬\u00137\u009fÂ ¾úûV3u1'ã@½þ[#Ñ¬´A(\fê\u009bñ";
            int var13 = "ì¦!§¹Ô\u000eRÕh]ù&Ú\u0016F=u\rI\u0092'=ãV\u0019;,\u0013Kêf¬W\u001a)Ýü/¹S%TlGø\u0010\u009fMK¹\u0082E\u0000þí\u0001ù\u0016èõj´C¹g¢´\u0001«Z!\u0007\u0093ãÐô=ãë:6Ñs\u001eI*³L\u0089¶M\u0012é×¤\u008ae#üðÿ´ÙÆlµ¬\u00137\u009fÂ ¾úûV3u1'ã@½þ[#Ñ¬´A(\fê\u009bñ"
               .length();
            byte var10 = 0;

            label71:
            while (true) {
               byte var30 = var10;
               var10 += 8;
               byte[] var16 = var12.substring(var30, var10).getBytes("ISO-8859-1");
               long[] var18 = var14;
               int var31 = var11++;
               long var40 = (var16[0] & (1524749822860389134L ^ 1524749822860389361L)) << (-422388725 ^ -422388685)
                  | (var16[1] & (1524749822860389134L ^ 1524749822860389361L)) << (-422388733 ^ -422388685)
                  | (var16[-422388687 ^ -422388685] & (1524749822860389134L ^ 1524749822860389361L)) << (-422388709 ^ -422388685)
                  | (var16[-422388688 ^ -422388685] & (1524749822860389134L ^ 1524749822860389361L)) << (-422388717 ^ -422388685)
                  | (var16[-422388681 ^ -422388685] & (1524749822860389134L ^ 1524749822860389361L)) << (-422388693 ^ -422388685)
                  | (var16[-422388682 ^ -422388685] & (1524749822860389134L ^ 1524749822860389361L)) << (-422388701 ^ -422388685)
                  | (var16[-422388683 ^ -422388685] & (1524749822860389134L ^ 1524749822860389361L)) << (-422388677 ^ -422388685)
                  | var16[-422388684 ^ -422388685] & (1524749822860389134L ^ 1524749822860389361L);
               byte var55 = -1;

               while (true) {
                  long var60 = var40 ^ var9;
                  switch (var55) {
                     case 0:
                        var18[var31] = var60;
                        if (var10 >= var13) {
                           b = var14;
                           c = new Integer[-422388704 ^ -422388685];
                           return;
                        }
                        break;
                     default:
                        var18[var31] = var60;
                        if (var10 < var13) {
                           continue label71;
                        }

                        var12 = "H¸i¶ï\u0017EJøëg\u0013?êp»";
                        var13 = "H¸i¶ï\u0017EJøëg\u0013?êp»".length();
                        var10 = 0;
                  }

                  byte var32 = var10;
                  var10 += 8;
                  var16 = var12.substring(var32, var10).getBytes("ISO-8859-1");
                  var18 = var14;
                  var31 = var11++;
                  var40 = (var16[0] & (1524749822860389134L ^ 1524749822860389361L)) << (-422388725 ^ -422388685)
                     | (var16[1] & (1524749822860389134L ^ 1524749822860389361L)) << (-422388733 ^ -422388685)
                     | (var16[-422388687 ^ -422388685] & (1524749822860389134L ^ 1524749822860389361L)) << (-422388709 ^ -422388685)
                     | (var16[-422388688 ^ -422388685] & (1524749822860389134L ^ 1524749822860389361L)) << (-422388717 ^ -422388685)
                     | (var16[-422388681 ^ -422388685] & (1524749822860389134L ^ 1524749822860389361L)) << (-422388693 ^ -422388685)
                     | (var16[-422388682 ^ -422388685] & (1524749822860389134L ^ 1524749822860389361L)) << (-422388701 ^ -422388685)
                     | (var16[-422388683 ^ -422388685] & (1524749822860389134L ^ 1524749822860389361L)) << (-422388677 ^ -422388685)
                     | var16[-422388684 ^ -422388685] & (1524749822860389134L ^ 1524749822860389361L);
                  var55 = 0;
               }
            }
         }

         var44 = var10001;
         var10004 = var8;
         var10005 = var10001[var8];
         switch (var8 % (-422388684 ^ -422388685)) {
            case 0:
               var10006 = -422388692 ^ -422388685;
               break;
            case 1:
               var10006 = -422388657 ^ -422388685;
               break;
            case 2:
               var10006 = -422388639 ^ -422388685;
               break;
            case 3:
               var10006 = -422388663 ^ -422388685;
               break;
            case 4:
               var10006 = -422388649 ^ -422388685;
               break;
            case 5:
               var10006 = -422388683 ^ -422388685;
               break;
            default:
               var10006 = -422388693 ^ -422388685;
         }
      }

      while (true) {
         var44[var10004] = (char)(var10005 ^ var10006);
         var8++;
         if (var21 == 0) {
            var10004 = var21;
            var44 = var34;
            var10005 = var34[var21];
            switch (var8 % (-422388684 ^ -422388685)) {
               case 0:
                  var10006 = -422388692 ^ -422388685;
                  break;
               case 1:
                  var10006 = -422388657 ^ -422388685;
                  break;
               case 2:
                  var10006 = -422388639 ^ -422388685;
                  break;
               case 3:
                  var10006 = -422388663 ^ -422388685;
                  break;
               case 4:
                  var10006 = -422388649 ^ -422388685;
                  break;
               case 5:
                  var10006 = -422388683 ^ -422388685;
                  break;
               default:
                  var10006 = -422388693 ^ -422388685;
            }
         } else {
            if (var21 <= var8) {
               String var51 = new String(var34).intern();
               byte var25 = -1;
               a = var51;
               long var0 = 1524691895972424994L ^ 1524749822860389361L;
               long[] var6 = new long[-422388704 ^ -422388685];
               int var3 = 0;
               String var4 = "ì¦!§¹Ô\u000eRÕh]ù&Ú\u0016F=u\rI\u0092'=ãV\u0019;,\u0013Kêf¬W\u001a)Ýü/¹S%TlGø\u0010\u009fMK¹\u0082E\u0000þí\u0001ù\u0016èõj´C¹g¢´\u0001«Z!\u0007\u0093ãÐô=ãë:6Ñs\u001eI*³L\u0089¶M\u0012é×¤\u008ae#üðÿ´ÙÆlµ¬\u00137\u009fÂ ¾úûV3u1'ã@½þ[#Ñ¬´A(\fê\u009bñ";
               int var5 = "ì¦!§¹Ô\u000eRÕh]ù&Ú\u0016F=u\rI\u0092'=ãV\u0019;,\u0013Kêf¬W\u001a)Ýü/¹S%TlGø\u0010\u009fMK¹\u0082E\u0000þí\u0001ù\u0016èõj´C¹g¢´\u0001«Z!\u0007\u0093ãÐô=ãë:6Ñs\u001eI*³L\u0089¶M\u0012é×¤\u008ae#üðÿ´ÙÆlµ¬\u00137\u009fÂ ¾úûV3u1'ã@½þ[#Ñ¬´A(\fê\u009bñ"
                  .length();
               byte var2 = 0;

               label37:
               while (true) {
                  byte var26 = var2;
                  var2 += 8;
                  byte[] var7 = var4.substring(var26, var2).getBytes("ISO-8859-1");
                  long[] var10000 = var6;
                  int var27 = var3++;
                  long var38 = (var7[0] & (1524749822860389134L ^ 1524749822860389361L)) << (-422388725 ^ -422388685)
                     | (var7[1] & (1524749822860389134L ^ 1524749822860389361L)) << (-422388733 ^ -422388685)
                     | (var7[-422388687 ^ -422388685] & (1524749822860389134L ^ 1524749822860389361L)) << (-422388709 ^ -422388685)
                     | (var7[-422388688 ^ -422388685] & (1524749822860389134L ^ 1524749822860389361L)) << (-422388717 ^ -422388685)
                     | (var7[-422388681 ^ -422388685] & (1524749822860389134L ^ 1524749822860389361L)) << (-422388693 ^ -422388685)
                     | (var7[-422388682 ^ -422388685] & (1524749822860389134L ^ 1524749822860389361L)) << (-422388701 ^ -422388685)
                     | (var7[-422388683 ^ -422388685] & (1524749822860389134L ^ 1524749822860389361L)) << (-422388677 ^ -422388685)
                     | var7[-422388684 ^ -422388685] & (1524749822860389134L ^ 1524749822860389361L);
                  byte var52 = -1;

                  while (true) {
                     long var58 = var38 ^ var0;
                     switch (var52) {
                        case 0:
                           var10000[var27] = var58;
                           if (var2 >= var5) {
                              b = var6;
                              c = new Integer[-422388704 ^ -422388685];
                              return;
                           }
                           break;
                        default:
                           var10000[var27] = var58;
                           if (var2 < var5) {
                              continue label37;
                           }

                           var4 = "H¸i¶ï\u0017EJøëg\u0013?êp»";
                           var5 = "H¸i¶ï\u0017EJøëg\u0013?êp»".length();
                           var2 = 0;
                     }

                     byte var28 = var2;
                     var2 += 8;
                     var7 = var4.substring(var28, var2).getBytes("ISO-8859-1");
                     var10000 = var6;
                     var27 = var3++;
                     var38 = (var7[0] & (1524749822860389134L ^ 1524749822860389361L)) << (-422388725 ^ -422388685)
                        | (var7[1] & (1524749822860389134L ^ 1524749822860389361L)) << (-422388733 ^ -422388685)
                        | (var7[-422388687 ^ -422388685] & (1524749822860389134L ^ 1524749822860389361L)) << (-422388709 ^ -422388685)
                        | (var7[-422388688 ^ -422388685] & (1524749822860389134L ^ 1524749822860389361L)) << (-422388717 ^ -422388685)
                        | (var7[-422388681 ^ -422388685] & (1524749822860389134L ^ 1524749822860389361L)) << (-422388693 ^ -422388685)
                        | (var7[-422388682 ^ -422388685] & (1524749822860389134L ^ 1524749822860389361L)) << (-422388701 ^ -422388685)
                        | (var7[-422388683 ^ -422388685] & (1524749822860389134L ^ 1524749822860389361L)) << (-422388677 ^ -422388685)
                        | var7[-422388684 ^ -422388685] & (1524749822860389134L ^ 1524749822860389361L);
                     var52 = 0;
                  }
               }
            }

            var44 = var34;
            var10004 = var8;
            var10005 = var34[var8];
            switch (var8 % (-422388684 ^ -422388685)) {
               case 0:
                  var10006 = -422388692 ^ -422388685;
                  break;
               case 1:
                  var10006 = -422388657 ^ -422388685;
                  break;
               case 2:
                  var10006 = -422388639 ^ -422388685;
                  break;
               case 3:
                  var10006 = -422388663 ^ -422388685;
                  break;
               case 4:
                  var10006 = -422388649 ^ -422388685;
                  break;
               case 5:
                  var10006 = -422388683 ^ -422388685;
                  break;
               default:
                  var10006 = -422388693 ^ -422388685;
            }
         }
      }
   }

   private static int a(int var0, long var1) {
      int var3 = var0 ^ (int)(var1 & (905336175199348511L ^ 905336175199328480L)) ^ -521689652 ^ -521697716;
      if (c[var3] == null) {
         c[var3] = (int)(b[var3] ^ var1);
      }

      return c[var3];
   }
}

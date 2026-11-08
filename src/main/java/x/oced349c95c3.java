package x;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Collection;

public enum oced349c95c3 {
   Ļ,
   ӯ;

   private final String ո;
   private static final oced349c95c3[] ˢ;
   private static final String[] a;
   private static final String[] b;
   private static final long[] c;
   private static final Integer[] d;

   private oced349c95c3(String var3) {
      this.ո = var3;
   }

   String Ȉ(Collection<oc804fdd8d75> param1) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: ldc2_w -3088507536055944346
      // 03: ldc2_w -3088512868960230766
      // 06: lxor
      // 07: lstore 2
      // 08: lload 2
      // 09: dup2
      // 0a: ldc2_w -3088583713231921066
      // 0d: ldc2_w -3088512868960230766
      // 10: lxor
      // 11: lxor
      // 12: dup2
      // 13: ldc -1636768634
      // 15: ldc -1636768586
      // 17: ixor
      // 18: lushr
      // 19: l2i
      // 1a: istore 4
      // 1c: dup2
      // 1d: ldc -1636768602
      // 1f: ldc -1636768586
      // 21: ixor
      // 22: lshl
      // 23: ldc -1636768618
      // 25: ldc -1636768586
      // 27: ixor
      // 28: lushr
      // 29: l2i
      // 2a: istore 5
      // 2c: dup2
      // 2d: ldc -1636768634
      // 2f: ldc -1636768586
      // 31: ixor
      // 32: lshl
      // 33: ldc -1636768634
      // 35: ldc -1636768586
      // 37: ixor
      // 38: lushr
      // 39: l2i
      // 3a: istore 6
      // 3c: pop2
      // 3d: dup2
      // 3e: ldc2_w -3088612333101862449
      // 41: ldc2_w -3088512868960230766
      // 44: lxor
      // 45: lxor
      // 46: dup2
      // 47: ldc -1636768618
      // 49: ldc -1636768586
      // 4b: ixor
      // 4c: lushr
      // 4d: l2i
      // 4e: istore 7
      // 50: dup2
      // 51: ldc -1636768618
      // 53: ldc -1636768586
      // 55: ixor
      // 56: lshl
      // 57: ldc -1636768634
      // 59: ldc -1636768586
      // 5b: ixor
      // 5c: lushr
      // 5d: l2i
      // 5e: istore 8
      // 60: dup2
      // 61: ldc -1636768634
      // 63: ldc -1636768586
      // 65: ixor
      // 66: lshl
      // 67: ldc -1636768634
      // 69: ldc -1636768586
      // 6b: ixor
      // 6c: lushr
      // 6d: l2i
      // 6e: istore 9
      // 70: pop2
      // 71: dup2
      // 72: ldc2_w -3088488070869593297
      // 75: ldc2_w -3088512868960230766
      // 78: lxor
      // 79: lxor
      // 7a: lstore 10
      // 7c: pop2
      // 7d: getstatic x/oc804fdd8d75.Ɔ I
      // 80: aload 0
      // 81: aload 0
      // 82: iload 7
      // 84: iload 8
      // 86: i2s
      // 87: iload 9
      // 89: i2c
      // 8a: invokevirtual x/oced349c95c3.ԙ (ISC)Lcom/google/gson/JsonElement;
      // 8d: invokevirtual x/oced349c95c3.z$2nxpapaw3t84h (Lcom/google/gson/JsonElement;)Ljava/lang/String;
      // 90: lload 10
      // 92: dup2_x1
      // 93: pop2
      // 94: invokestatic x/oc499a9670c8.ϔ (JLjava/lang/String;)Ljava/lang/String;
      // 97: astore 13
      // 99: istore 12
      // 9b: aload 13
      // 9d: iload 12
      // 9f: ifne d3
      // a2: invokevirtual java/lang/String.length ()I
      // a5: ldc -1636768587
      // a7: ldc -1636768586
      // a9: ixor
      // aa: if_icmpge c5
      // ad: goto b1
      // b0: athrow
      // b1: new java/io/IOException
      // b4: dup
      // b5: aload 0
      // b6: getfield x/oced349c95c3.ո Ljava/lang/String;
      // b9: ldc " returned an unusable username"
      // bb: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // c0: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // c3: athrow
      // c4: athrow
      // c5: aload 13
      // c7: iload 4
      // c9: i2s
      // ca: aload 1
      // cb: iload 5
      // cd: iload 6
      // cf: i2c
      // d0: invokestatic x/oc499a9670c8.Ν (Ljava/lang/String;SLjava/util/Collection;IC)Ljava/lang/String;
      // d3: areturn
   }

   abstract String z$2nxpapaw3t84h(JsonElement var1) throws IOException;

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private JsonElement ԙ(int var1, short var2, char var3) throws IOException {
      long var4 = (long)var1 << (1048368652 ^ 1048368684)
         | (long)var2 << (1048368668 ^ 1048368684) >>> (1048368652 ^ 1048368684)
         | (long)var3 << (1048368668 ^ 1048368684) >>> (1048368668 ^ 1048368684);
      HttpURLConnection var7 = (HttpURLConnection)new URL(this.ո).openConnection();
      int var10000 = oc804fdd8d75.Ɔ;
      var7.setRequestMethod(a((833168902 ^ 1048368684) + (1048348308 ^ 1048368684), (833168902 ^ 1048368684) + (1048362173 ^ 1048368684), (int)var4));
      var7.setConnectTimeout(a(1048356157 ^ 1048368684, -2407058721668499006L ^ -796040335432624677L ^ var4));
      var7.setReadTimeout(a(1048374347 ^ 1048368684, -6611381688178462537L ^ -796040335432624677L ^ var4));
      int var6 = var10000;
      var7.setRequestProperty(
         a((833168902 ^ 1048368684) + (1048348311 ^ 1048368684), (-833168902 ^ 1048368684) + (-1048363768 ^ 1048368684), (int)var4),
         a((833168902 ^ 1048368684) + (1048348305 ^ 1048368684), (-833168902 ^ 1048368684) + (-1048354055 ^ 1048368684), (int)var4)
      );
      var7.setRequestProperty(
         a((833168902 ^ 1048368684) + (1048348309 ^ 1048368684), (833168902 ^ 1048368684) + (1048373350 ^ 1048368684), (int)var4),
         a((833168902 ^ 1048368684) + (1048348314 ^ 1048368684), (833168902 ^ 1048368684) + (char)(-1048356749 ^ 1048368684), (int)var4)
      );
      var7.setUseCaches(false);
      boolean var22 = false /* VF: Semaphore variable */;

      JsonElement var12;
      try {
         var22 = true;
         int var8 = var7.getResponseCode();

         try {
            if (var8 != a(1048361214 ^ 1048368684, -4570080145059650560L ^ -796040335432624677L ^ var4)) {
               throw new IOException(
                  this.ո + a((833168902 ^ 1048368684) + (1048348310 ^ 1048368684), (833168902 ^ 1048368684) + (1048364312 ^ 1048368684), (int)var4) + var8
               );
            }
         } catch (RuntimeException var27) {
            throw var27;
         }

         InputStream var9 = var7.getInputStream();

         try {
            label140: {
               InputStreamReader var10 = new InputStreamReader(var9, StandardCharsets.UTF_8);

               try {
                  JsonElement var11;
                  try {
                     var11 = new JsonParser().parse(var10);
                  } catch (RuntimeException var25) {
                     throw new IOException(
                        this.ո + a((833168902 ^ 1048368684) + (1048348304 ^ 1048368684), (833168902 ^ 1048368684) + (1048357288 ^ 1048368684), (int)var4),
                        var25
                     );
                  }

                  var12 = var11;
                  if (var1 < 0) {
                     break label140;
                  }

                  if (var6 != 0) {
                     var22 = false;
                     return var11;
                  }
               } catch (Throwable var28) {
                  try {
                     var10.close();
                  } catch (Throwable var24) {
                     var28.addSuppressed(var24);
                  }

                  throw var28;
               }

               var10.close();
               if (var1 <= 0) {
                  var22 = false;
                  return var12;
               }
            }
         } catch (Throwable var29) {
            try {
               if (var6 != 0 || var9 == null) {
                  throw var29;
               }
            } catch (RuntimeException var26) {
               throw var26;
            }

            try {
               var9.close();
            } catch (Throwable var23) {
               var29.addSuppressed(var23);
            }

            throw var29;
         }

         if (var9 != null) {
            var9.close();
            var22 = false;
         } else {
            var22 = false;
         }
      } finally {
         if (var22) {
            var7.disconnect();
         }
      }

      var7.disconnect();
      return var12;
   }

   private static oced349c95c3[] Q() {
      oced349c95c3[] var10000 = new oced349c95c3[709580558 ^ 709580556];
      var10000[0] = Ļ;
      var10000[1] = ӯ;
      return var10000;
   }

   // $VF: Irreducible bytecode was duplicated to produce valid code
   // $VF: Failed to inline enum fields
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   static {
      String[] var13 = new String[1668494300 ^ 1668494299];
      int var11 = 0;
      String var10 = "\u008a\u0001Òº\u0094\u0006;2ðmM\u0095Bl7ù¡\u0089ä\u009fÌ/\u0010Jt¶N³\u0092O\u0082\u009d\u0007K?yBÌk\u000f)\u0012¦Ø\u001aJê»Ê\\+\u0089©£`\u0006\u0096l\u001a5NÂ\u0003Tï³";
      int var12 = "\u008a\u0001Òº\u0094\u0006;2ðmM\u0095Bl7ù¡\u0089ä\u009fÌ/\u0010Jt¶N³\u0092O\u0082\u009d\u0007K?yBÌk\u000f)\u0012¦Ø\u001aJê»Ê\\+\u0089©£`\u0006\u0096l\u001a5NÂ\u0003Tï³"
         .length();
      int var9 = 1668494285 ^ 1668494299;
      int var16 = -1;

      label61:
      while (true) {
         String var10000 = var10.substring(++var16, var16 + var9);
         int var10001 = -1;

         while (true) {
            char[] var30;
            label56: {
               char[] var19 = var10000.toCharArray();
               int var10003 = var19.length;
               int var14 = 0;
               var30 = var19;
               var10001 = var10003;
               char[] var38;
               int var10004;
               if (var10003 <= 1) {
                  var38 = var19;
                  var10004 = var14;
               } else {
                  var30 = var19;
                  var10001 = var10003;
                  if (var10003 <= var14) {
                     break label56;
                  }

                  var38 = var19;
                  var10004 = var14;
               }

               while (true) {
                  var38[var10004] = (char)(var38[var10004] ^ switch (var14 % (1668494300 ^ 1668494299)) {
                     case 0 -> 1668494239 ^ 1668494299;
                     case 1 -> 1668494308 ^ 1668494299;
                     case 2 -> 1668494225 ^ 1668494299;
                     case 3 -> 1668494318 ^ 1668494299;
                     case 4 -> 1668494304 ^ 1668494299;
                     case 5 -> 1668494244 ^ 1668494299;
                     default -> 1668494240 ^ 1668494299;
                  });
                  var14++;
                  if (var10001 == 0) {
                     var10004 = var10001;
                     var38 = var30;
                  } else {
                     if (var10001 <= var14) {
                        break;
                     }

                     var38 = var30;
                     var10004 = var14;
                  }
               }
            }

            String var45 = new String(var30).intern();
            switch (var10001) {
               case 0:
                  var13[var11++] = var45;
                  if ((var16 += var9) >= var12) {
                     a = var13;
                     b = new String[1668494300 ^ 1668494299];
                     long var0 = -2777877862593908308L ^ -2778014860456152231L;
                     long[] var6 = new long[1668494296 ^ 1668494299];
                     int var3 = 0;
                     String var4 = "<ô&ñ\u00ad¼¹O0¯ûÚnj«å\u001b\u007fx\u0015ò\u0082~¸";
                     int var5 = "<ô&ñ\u00ad¼¹O0¯ûÚnj«å\u001b\u007fx\u0015ò\u0082~¸".length();
                     byte var2 = 0;

                     do {
                        int var26 = var2;
                        var2 += 8;
                        byte[] var7 = var4.substring(var26, var2).getBytes("ISO-8859-1");
                        var26 = var3++;
                        long var47 = (
                              (var7[0] & (-2778014860456152154L ^ -2778014860456152231L)) << (1668494307 ^ 1668494299)
                                 | (var7[1] & (-2778014860456152154L ^ -2778014860456152231L)) << (1668494315 ^ 1668494299)
                                 | (var7[1668494297 ^ 1668494299] & (-2778014860456152154L ^ -2778014860456152231L)) << (1668494323 ^ 1668494299)
                                 | (var7[1668494296 ^ 1668494299] & (-2778014860456152154L ^ -2778014860456152231L)) << (1668494331 ^ 1668494299)
                                 | (var7[1668494303 ^ 1668494299] & (-2778014860456152154L ^ -2778014860456152231L)) << (1668494275 ^ 1668494299)
                                 | (var7[1668494302 ^ 1668494299] & (-2778014860456152154L ^ -2778014860456152231L)) << (1668494283 ^ 1668494299)
                                 | (var7[1668494301 ^ 1668494299] & (-2778014860456152154L ^ -2778014860456152231L)) << (1668494291 ^ 1668494299)
                                 | var7[1668494300 ^ 1668494299] & (-2778014860456152154L ^ -2778014860456152231L)
                           )
                           ^ var0;
                        byte var46 = -1;
                        var6[var26] = var47;
                     } while (var2 < var5);

                     c = var6;
                     d = new Integer[1668494296 ^ 1668494299];
                     Ļ = new oc0bf85e4d32("RANDOM_API", 0, "https://randomapi.dev/api/names?count=1");
                     ӯ = new oc593d56dc9f("RANDOM_USER", 1, "https://randomuser.me/api/?inc=name");
                     ˢ = Q();
                     return;
                  }

                  var9 = var10.charAt(var16);
                  break;
               default:
                  var13[var11++] = var45;
                  if ((var16 += var9) < var12) {
                     var9 = var10.charAt(var16);
                     continue label61;
                  }

                  var10 = "5'þYI\u008fÚVîµ\u000bq\u009ai°?W\u001f\u00037\u0088\u0089";
                  var12 = "5'þYI\u008fÚVîµ\u000bq\u009ai°?W\u001f\u00037\u0088\u0089".length();
                  var9 = 1668494289 ^ 1668494299;
                  var16 = -1;
            }

            var10000 = var10.substring(++var16, var16 + var9);
            var10001 = 0;
         }
      }
   }

   private static String a(int var0, int var1, int var2) {
      int var3 = (var0 ^ var2 ^ 1687040633 ^ 1687058486) & (1687062473 ^ 1687058486);
      if (b[var3] == null) {
         char[] var4 = a[var3].toCharArray();

         int var5 = switch (var4[0] & (1687058633 ^ 1687058486)) {
            case 0 -> 1687058520 ^ 1687058486;
            case 1 -> 1687058504 ^ 1687058486;
            case 2 -> 1687058503 ^ 1687058486;
            case 3 -> 1687058534 ^ 1687058486;
            case 4 -> 1687058657 ^ 1687058486;
            case 5 -> 1687058687 ^ 1687058486;
            case 6 -> 1687058570 ^ 1687058486;
            case 7 -> 1687058464 ^ 1687058486;
            case 8 -> 1687058647 ^ 1687058486;
            case 9 -> 1687058547 ^ 1687058486;
            case 10 -> 1687058507 ^ 1687058486;
            case 11 -> 1687058456 ^ 1687058486;
            case 12 -> 1687058443 ^ 1687058486;
            case 13 -> 1687058518 ^ 1687058486;
            case 14 -> 1687058597 ^ 1687058486;
            case 15 -> 1687058533 ^ 1687058486;
            case 16 -> 1687058573 ^ 1687058486;
            case 17 -> 1687058437 ^ 1687058486;
            case 18 -> 1687058457 ^ 1687058486;
            case 19 -> 1687058435 ^ 1687058486;
            case 20 -> 1687058471 ^ 1687058486;
            case 21 -> 1687058445 ^ 1687058486;
            case 22 -> 1687058568 ^ 1687058486;
            case 23 -> 1687058467 ^ 1687058486;
            case 24 -> 1687058655 ^ 1687058486;
            case 25 -> 1687058669 ^ 1687058486;
            case 26 -> 1687058494 ^ 1687058486;
            case 27 -> 1687058614 ^ 1687058486;
            case 28 -> 1687058459 ^ 1687058486;
            case 29 -> 1687058468 ^ 1687058486;
            case 30 -> 1687058641 ^ 1687058486;
            case 31 -> 1687058636 ^ 1687058486;
            case 32 -> 1687058661 ^ 1687058486;
            case 33 -> 1687058450 ^ 1687058486;
            case 34 -> 1687058540 ^ 1687058486;
            case 35 -> 1687058483 ^ 1687058486;
            case 36 -> 1687058535 ^ 1687058486;
            case 37 -> 1687058510 ^ 1687058486;
            case 38 -> 1687058482 ^ 1687058486;
            case 39 -> 1687058508 ^ 1687058486;
            case 40 -> 1687058465 ^ 1687058486;
            case 41 -> 1687058506 ^ 1687058486;
            case 42 -> 1687058633 ^ 1687058486;
            case 43 -> 1687058676 ^ 1687058486;
            case 44 -> 1687058549 ^ 1687058486;
            case 45 -> 1687058576 ^ 1687058486;
            case 46 -> 1687058513 ^ 1687058486;
            case 47 -> 1687058529 ^ 1687058486;
            case 48 -> 1687058653 ^ 1687058486;
            case 49 -> 1687058451 ^ 1687058486;
            case 50 -> 1687058663 ^ 1687058486;
            case 51 -> 1687058541 ^ 1687058486;
            case 52 -> 1687058654 ^ 1687058486;
            case 53 -> 1687058590 ^ 1687058486;
            case 54 -> 1687058625 ^ 1687058486;
            case 55 -> 1687058632 ^ 1687058486;
            case 56 -> 1687058589 ^ 1687058486;
            case 57 -> 1687058628 ^ 1687058486;
            case 58 -> 1687058596 ^ 1687058486;
            case 59 -> 1687058524 ^ 1687058486;
            case 60 -> 1687058500 ^ 1687058486;
            case 61 -> 1687058658 ^ 1687058486;
            case 62 -> 1687058444 ^ 1687058486;
            case 63 -> 1687058561 ^ 1687058486;
            case 64 -> 1687058685 ^ 1687058486;
            case 65 -> 1687058639 ^ 1687058486;
            case 66 -> 1687058642 ^ 1687058486;
            case 67 -> 1687058587 ^ 1687058486;
            case 68 -> 1687058600 ^ 1687058486;
            case 69 -> 1687058599 ^ 1687058486;
            case 70 -> 1687058502 ^ 1687058486;
            case 71 -> 1687058574 ^ 1687058486;
            case 72 -> 1687058581 ^ 1687058486;
            case 73 -> 1687058475 ^ 1687058486;
            case 74 -> 1687058627 ^ 1687058486;
            case 75 -> 1687058493 ^ 1687058486;
            case 76 -> 1687058583 ^ 1687058486;
            case 77 -> 1687058643 ^ 1687058486;
            case 78 -> 1687058517 ^ 1687058486;
            case 79 -> 1687058436 ^ 1687058486;
            case 80 -> 1687058505 ^ 1687058486;
            case 81 -> 1687058571 ^ 1687058486;
            case 82 -> 1687058543 ^ 1687058486;
            case 83 -> 1687058470 ^ 1687058486;
            case 84 -> 1687058438 ^ 1687058486;
            case 85 -> 1687058621 ^ 1687058486;
            case 86 -> 1687058598 ^ 1687058486;
            case 87 -> 1687058433 ^ 1687058486;
            case 88 -> 1687058564 ^ 1687058486;
            case 89 -> 1687058579 ^ 1687058486;
            case 90 -> 1687058501 ^ 1687058486;
            case 91 -> 1687058509 ^ 1687058486;
            case 92 -> 1687058679 ^ 1687058486;
            case 93 -> 1687058618 ^ 1687058486;
            case 94 -> 1687058615 ^ 1687058486;
            case 95 -> 1687058563 ^ 1687058486;
            case 96 -> 1687058473 ^ 1687058486;
            case 97 -> 1687058461 ^ 1687058486;
            case 98 -> 1687058496 ^ 1687058486;
            case 99 -> 1687058634 ^ 1687058486;
            case 100 -> 1687058670 ^ 1687058486;
            case 101 -> 1687058548 ^ 1687058486;
            case 102 -> 1687058638 ^ 1687058486;
            case 103 -> 1687058635 ^ 1687058486;
            case 104 -> 1687058488 ^ 1687058486;
            case 105 -> 1687058439 ^ 1687058486;
            case 106 -> 1687058626 ^ 1687058486;
            case 107 -> 1687058591 ^ 1687058486;
            case 108 -> 1687058448 ^ 1687058486;
            case 109 -> 1687058588 ^ 1687058486;
            case 110 -> 1687058684 ^ 1687058486;
            case 111 -> 1687058514 ^ 1687058486;
            case 112 -> 1687058478 ^ 1687058486;
            case 113 -> 1687058575 ^ 1687058486;
            case 114 -> 1687058495 ^ 1687058486;
            case 115 -> 1687058672 ^ 1687058486;
            case 116 -> 1687058644 ^ 1687058486;
            case 117 -> 1687058476 ^ 1687058486;
            case 118 -> 1687058572 ^ 1687058486;
            case 119 -> 1687058577 ^ 1687058486;
            case 120 -> 1687058512 ^ 1687058486;
            case 121 -> 1687058666 ^ 1687058486;
            case 122 -> 1687058602 ^ 1687058486;
            case 123 -> 1687058441 ^ 1687058486;
            case 124 -> 1687058452 ^ 1687058486;
            case 125 -> 1687058683 ^ 1687058486;
            case 126 -> 1687058545 ^ 1687058486;
            case 127 -> 1687058565 ^ 1687058486;
            case 128 -> 1687058542 ^ 1687058486;
            case 129 -> 1687058474 ^ 1687058486;
            case 130 -> 1687058455 ^ 1687058486;
            case 131 -> 1687058472 ^ 1687058486;
            case 132 -> 1687058539 ^ 1687058486;
            case 133 -> 1687058619 ^ 1687058486;
            case 134 -> 1687058673 ^ 1687058486;
            case 135 -> 1687058604 ^ 1687058486;
            case 136 -> 1687058606 ^ 1687058486;
            case 137 -> 1687058569 ^ 1687058486;
            case 138 -> 1687058528 ^ 1687058486;
            case 139 -> 1687058434 ^ 1687058486;
            case 140 -> 1687058462 ^ 1687058486;
            case 141 -> 1687058613 ^ 1687058486;
            case 142 -> 1687058671 ^ 1687058486;
            case 143 -> 1687058492 ^ 1687058486;
            case 144 -> 1687058668 ^ 1687058486;
            case 145 -> 1687058556 ^ 1687058486;
            case 146 -> 1687058555 ^ 1687058486;
            case 147 -> 1687058667 ^ 1687058486;
            case 148 -> 1687058652 ^ 1687058486;
            case 149 -> 1687058557 ^ 1687058486;
            case 150 -> 1687058551 ^ 1687058486;
            case 151 -> 1687058649 ^ 1687058486;
            case 152 -> 1687058511 ^ 1687058486;
            case 153 -> 1687058454 ^ 1687058486;
            case 154 -> 1687058629 ^ 1687058486;
            case 155 -> 1687058605 ^ 1687058486;
            case 156 -> 1687058489 ^ 1687058486;
            case 157 -> 1687058463 ^ 1687058486;
            case 158 -> 1687058485 ^ 1687058486;
            case 159 -> 1687058432 ^ 1687058486;
            case 160 -> 1687058537 ^ 1687058486;
            case 161 -> 1687058460 ^ 1687058486;
            case 162 -> 1687058499 ^ 1687058486;
            case 163 -> 1687058519 ^ 1687058486;
            case 164 -> 1687058610 ^ 1687058486;
            case 165 -> 1687058560 ^ 1687058486;
            case 166 -> 1687058585 ^ 1687058486;
            case 167 -> 1687058650 ^ 1687058486;
            case 168 -> 1687058523 ^ 1687058486;
            case 169 -> 1687058645 ^ 1687058486;
            case 170 -> 1687058594 ^ 1687058486;
            case 171 -> 1687058458 ^ 1687058486;
            case 172 -> 1687058449 ^ 1687058486;
            case 173 -> 1687058567 ^ 1687058486;
            case 174 -> 1687058490 ^ 1687058486;
            case 175 -> 1687058617 ^ 1687058486;
            case 176 -> 1687058582 ^ 1687058486;
            case 177 -> 1687058521 ^ 1687058486;
            case 178 -> 1687058516 ^ 1687058486;
            case 179 -> 1687058498 ^ 1687058486;
            case 180 -> 1687058609 ^ 1687058486;
            case 181 -> 1687058646 ^ 1687058486;
            case 182 -> 1687058593 ^ 1687058486;
            case 183 -> 1687058525 ^ 1687058486;
            case 184 -> 1;
            case 185 -> 1687058677 ^ 1687058486;
            case 186 -> 1687058552 ^ 1687058486;
            case 187 -> 1687058566 ^ 1687058486;
            case 188 -> 1687058480 ^ 1687058486;
            case 189 -> 1687058675 ^ 1687058486;
            case 190 -> 1687058558 ^ 1687058486;
            case 191 -> 1687058623 ^ 1687058486;
            case 192 -> 1687058466 ^ 1687058486;
            case 193 -> 1687058447 ^ 1687058486;
            case 194 -> 1687058497 ^ 1687058486;
            case 195 -> 1687058659 ^ 1687058486;
            case 196 -> 1687058680 ^ 1687058486;
            case 197 -> 1687058682 ^ 1687058486;
            case 198 -> 1687058469 ^ 1687058486;
            case 199 -> 1687058515 ^ 1687058486;
            case 200 -> 1687058491 ^ 1687058486;
            case 201 -> 1687058616 ^ 1687058486;
            case 202 -> 1687058595 ^ 1687058486;
            case 203 -> 1687058554 ^ 1687058486;
            case 204 -> 1687058664 ^ 1687058486;
            case 205 -> 1687058592 ^ 1687058486;
            case 206 -> 1687058479 ^ 1687058486;
            case 207 -> 1687058608 ^ 1687058486;
            case 208 -> 1687058578 ^ 1687058486;
            case 209 -> 1687058522 ^ 1687058486;
            case 210 -> 1687058678 ^ 1687058486;
            case 211 -> 1687058544 ^ 1687058486;
            case 212 -> 1687058686 ^ 1687058486;
            case 213 -> 1687058562 ^ 1687058486;
            case 214 -> 1687058630 ^ 1687058486;
            case 215 -> 1687058477 ^ 1687058486;
            case 216 -> 1687058584 ^ 1687058486;
            case 217 -> 1687058538 ^ 1687058486;
            case 218 -> 1687058665 ^ 1687058486;
            case 219 -> 1687058559 ^ 1687058486;
            case 220 -> 1687058453 ^ 1687058486;
            case 221 -> 1687058586 ^ 1687058486;
            case 222 -> 1687058440 ^ 1687058486;
            case 223 -> 1687058640 ^ 1687058486;
            case 224 -> 1687058532 ^ 1687058486;
            case 225 -> 1687058681 ^ 1687058486;
            case 226 -> 1687058446 ^ 1687058486;
            case 227 -> 1687058612 ^ 1687058486;
            case 228 -> 1687058631 ^ 1687058486;
            case 229 -> 1687058622 ^ 1687058486;
            case 230 -> 1687058601 ^ 1687058486;
            case 231 -> 1687058603 ^ 1687058486;
            case 232 -> 1687058648 ^ 1687058486;
            case 233 -> 1687058624 ^ 1687058486;
            case 234 -> 1687058527 ^ 1687058486;
            case 235 -> 0;
            case 236 -> 1687058637 ^ 1687058486;
            case 237 -> 1687058620 ^ 1687058486;
            case 238 -> 1687058546 ^ 1687058486;
            case 239 -> 1687058531 ^ 1687058486;
            case 240 -> 1687058611 ^ 1687058486;
            case 241 -> 1687058607 ^ 1687058486;
            case 242 -> 1687058530 ^ 1687058486;
            case 243 -> 1687058526 ^ 1687058486;
            case 244 -> 1687058536 ^ 1687058486;
            case 245 -> 1687058662 ^ 1687058486;
            case 246 -> 1687058550 ^ 1687058486;
            case 247 -> 1687058656 ^ 1687058486;
            case 248 -> 1687058651 ^ 1687058486;
            case 249 -> 1687058553 ^ 1687058486;
            case 250 -> 1687058484 ^ 1687058486;
            case 251 -> 1687058674 ^ 1687058486;
            case 252 -> 1687058580 ^ 1687058486;
            case 253 -> 1687058660 ^ 1687058486;
            case 254 -> 1687058442 ^ 1687058486;
            default -> 1687058481 ^ 1687058486;
         };
         int var10;
         int var6 = ((var10 = var1 ^ var2) & (1687058633 ^ 1687058486)) - var5;
         if (var6 < 0) {
            var6 += 256;
         }

         int var7 = ((var10 & (1687062473 ^ 1687058486)) >>> (1687058494 ^ 1687058486)) - var5;
         if (var7 < 0) {
            var7 += 256;
         }

         for (int var8 = 0; var8 < var4.length; var8++) {
            int var9 = var8 % (1687058484 ^ 1687058486);
            char var10002 = var4[var8];
            if (var9 == 0) {
               var4[var8] = (char)(var10002 ^ var6);
               var6 = ((var6 >>> (1687058485 ^ 1687058486) | var6 << (1687058483 ^ 1687058486)) ^ var4[var8]) & (1687058633 ^ 1687058486);
            } else {
               var4[var8] = (char)(var10002 ^ var7);
               var7 = ((var7 >>> (1687058485 ^ 1687058486) | var7 << (1687058483 ^ 1687058486)) ^ var4[var8]) & (1687058633 ^ 1687058486);
            }
         }

         b[var3] = new String(var4).intern();
      }

      return b[var3];
   }

   private static int a(int var0, long var1) {
      int var3 = var0 ^ (int)(var1 & (7773214387149036013L ^ 7773214387149022738L)) ^ -1260236543 ^ -1260256095;
      if (d[var3] == null) {
         d[var3] = (int)(c[var3] ^ var1);
      }

      return d[var3];
   }
}

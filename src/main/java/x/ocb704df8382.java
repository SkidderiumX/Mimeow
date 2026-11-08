package x;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ocb704df8382 {
   static final String М = "client-preferences.json";
   static final String Ί;
   private static final long Ȃ = 65536L;
   private static final Object է;
   private static final Gson ԍ;
   private static final Logger ȳ;
   private final File ȑ;
   public static boolean Ê;
   private static final String a;
   private static final long b;

   private ocb704df8382(File var1) {
      this.ȑ = var1;
   }

   private static String ɏ(long var0) {
      return a;
   }

   public static ocb704df8382 Ƴ(File var0) {
      return new ocb704df8382(new File(oc8ccd9c3f55.Ȓ(var0), "client-preferences.json"));
   }

   static ocb704df8382 ǆ(File var0) {
      return new ocb704df8382(var0);
   }

   public oc373d6c4e35 ǆ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: ldc2_w -1199618159100939799
      // 03: ldc2_w -1199628016845104275
      // 06: lxor
      // 07: lstore 1
      // 08: lload 1
      // 09: dup2
      // 0a: ldc2_w -1199520058428217692
      // 0d: ldc2_w -1199628016845104275
      // 10: lxor
      // 11: lxor
      // 12: dup2
      // 13: ldc -984358429
      // 15: ldc -984358461
      // 17: ixor
      // 18: lushr
      // 19: l2i
      // 1a: istore 3
      // 1b: dup2
      // 1c: ldc -984358429
      // 1e: ldc -984358461
      // 20: ixor
      // 21: lshl
      // 22: ldc -984358413
      // 24: ldc -984358461
      // 26: ixor
      // 27: lushr
      // 28: l2i
      // 29: istore 4
      // 2b: dup2
      // 2c: ldc -984358413
      // 2e: ldc -984358461
      // 30: ixor
      // 31: lshl
      // 32: ldc -984358413
      // 34: ldc -984358461
      // 36: ixor
      // 37: lushr
      // 38: l2i
      // 39: istore 5
      // 3b: pop2
      // 3c: pop2
      // 3d: getstatic x/oc151419fdfe.v Z
      // 40: getstatic x/ocb704df8382.է Ljava/lang/Object;
      // 43: dup
      // 44: astore 7
      // 46: monitorenter
      // 47: istore 6
      // 49: aload 0
      // 4a: iload 3
      // 4b: iload 4
      // 4d: i2c
      // 4e: iload 5
      // 50: i2c
      // 51: invokevirtual x/ocb704df8382.ʶ (ICC)Lcom/google/gson/JsonObject;
      // 54: astore 8
      // 56: aload 8
      // 58: getstatic x/ocb704df8382.Ί Ljava/lang/String;
      // 5b: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 5e: astore 9
      // 60: aload 9
      // 62: iload 6
      // 64: ifne 6c
      // 67: ifnull 84
      // 6a: aload 9
      // 6c: iload 6
      // 6e: ifne 79
      // 71: invokevirtual com/google/gson/JsonElement.isJsonNull ()Z
      // 74: ifne 84
      // 77: aload 9
      // 79: iload 6
      // 7b: ifne 8d
      // 7e: invokevirtual com/google/gson/JsonElement.isJsonPrimitive ()Z
      // 81: ifne 8b
      // 84: getstatic x/oc373d6c4e35.ύ Lx/oc373d6c4e35;
      // 87: aload 7
      // 89: monitorexit
      // 8a: areturn
      // 8b: aload 9
      // 8d: invokevirtual com/google/gson/JsonElement.getAsString ()Ljava/lang/String;
      // 90: invokestatic x/oc373d6c4e35.Ȟ (Ljava/lang/String;)Lx/oc373d6c4e35;
      // 93: aload 7
      // 95: monitorexit
      // 96: areturn
      // 97: astore 10
      // 99: getstatic x/oc373d6c4e35.ύ Lx/oc373d6c4e35;
      // 9c: aload 7
      // 9e: monitorexit
      // 9f: areturn
      // a0: astore 11
      // a2: aload 7
      // a4: monitorexit
      // a5: aload 11
      // a7: athrow
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // $VF: Could not create synchronized statement, marking monitor enters and exits
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public boolean Ί(oc373d6c4e35 var1) {
      long var2 = -3017972639000168071L ^ -3017888121796098847L;
      long var10001 = var2 ^ -3017857461805912524L ^ -3017888121796098847L;
      int var4 = (int)((var2 ^ -3017857461805912524L ^ -3017888121796098847L) >>> (1735413181 ^ 1735413149));
      int var5 = (int)((var2 ^ -3017857461805912524L ^ -3017888121796098847L) << (1735413181 ^ 1735413149) >>> (1735413165 ^ 1735413149));
      int var6 = (int)(var10001 << (1735413165 ^ 1735413149) >>> (1735413165 ^ 1735413149));
      Object var8 = է;
      synchronized (է){} // $VF: monitorenter 
      boolean var7 = oc151419fdfe.v;

      try {
         oc373d6c4e35 var10000 = var1;
         if (!var7) {
            var10000 = var1 == null ? oc373d6c4e35.ύ : var1;
         }

         oc373d6c4e35 var9 = var10000;
         JsonObject var10 = this.ʶ(var4, (char)var5, (char)var6);
         var10.addProperty(Ί, var9.Ϊ);
         Path var11 = null;
         boolean var36 = false /* VF: Semaphore variable */;

         boolean var46;
         label201: {
            boolean var13;
            label200: {
               label199: {
                  try {
                     try {
                        var36 = true;
                        Path var12 = this.ȑ.toPath().toAbsolutePath();
                        Path var45 = var12.getParent();
                        if (!var7) {
                           if (var45 == null) {
                              throw new IOException("Main-menu preference file has no parent directory");
                           }

                           Files.createDirectories(var45);
                        }

                        var11 = Files.createTempFile(var45, "client-preferences.json.", ".tmp");
                        BufferedWriter var14 = Files.newBufferedWriter(var11, StandardCharsets.UTF_8);
                        if (!var7) {
                           try {
                              ԍ.toJson(var10, var14);
                           } catch (Throwable var41) {
                              if (!var7 && var14 != null) {
                                 try {
                                    var14.close();
                                 } catch (Throwable var39) {
                                    var41.addSuppressed(var39);
                                 }
                              }

                              throw var41;
                           }

                           if (var14 != null) {
                              var14.close();
                           }

                           oc7d9b6bd5c4.ų(var11, var12);
                        }

                        var11 = null;
                        var46 = true;
                        if (var7) {
                           var36 = false;
                           break label201;
                        }

                        var36 = false;
                        break label199;
                     } catch (RuntimeException | IOException var42) {
                        ȳ.warn("Unable to save the main-menu logo preference", var42);
                        var13 = false;
                        if (var7) {
                           var36 = false;
                           break label200;
                        }
                     }

                     var36 = false;
                  } finally {
                     if (var36) {
                        if (!var7 && var11 != null) {
                           try {
                              Files.deleteIfExists(var11);
                           } catch (IOException var37) {
                           }
                        }
                     }
                  }

                  if (var11 != null) {
                     try {
                        Files.deleteIfExists(var11);
                     } catch (IOException var38) {
                     }
                  }
                  break label200;
               }

               if (var11 != null) {
                  try {
                     Files.deleteIfExists(var11);
                  } catch (IOException var40) {
                  }
               }
               break label201;
            }

            // $VF: monitorexit
            return var13;
         }

         // $VF: monitorexit
         return var46;
      } finally {
         // $VF: monitorexit
      }
   }

   private JsonObject ʶ(int param1, char param2, char param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: iload 1
      // 01: i2l
      // 02: ldc 1729003650
      // 04: ldc 1729003682
      // 06: ixor
      // 07: lshl
      // 08: iload 2
      // 09: i2l
      // 0a: ldc 1729003666
      // 0c: ldc 1729003682
      // 0e: ixor
      // 0f: lshl
      // 10: ldc 1729003650
      // 12: ldc 1729003682
      // 14: ixor
      // 15: lushr
      // 16: lor
      // 17: iload 3
      // 18: i2l
      // 19: ldc 1729003666
      // 1b: ldc 1729003682
      // 1d: ixor
      // 1e: lshl
      // 1f: ldc 1729003666
      // 21: ldc 1729003682
      // 23: ixor
      // 24: lushr
      // 25: lor
      // 26: lstore 4
      // 28: getstatic x/oc151419fdfe.v Z
      // 2b: istore 6
      // 2d: aload 0
      // 2e: iload 6
      // 30: ifne 45
      // 33: getfield x/ocb704df8382.ȑ Ljava/io/File;
      // 36: invokevirtual java/io/File.isFile ()Z
      // 39: ifeq 5b
      // 3c: goto 40
      // 3f: athrow
      // 40: aload 0
      // 41: goto 45
      // 44: athrow
      // 45: iload 6
      // 47: ifne 64
      // 4a: getfield x/ocb704df8382.ȑ Ljava/io/File;
      // 4d: invokevirtual java/io/File.length ()J
      // 50: getstatic x/ocb704df8382.b J
      // 53: lcmp
      // 54: ifle 63
      // 57: goto 5b
      // 5a: athrow
      // 5b: new com/google/gson/JsonObject
      // 5e: dup
      // 5f: invokespecial com/google/gson/JsonObject.<init> ()V
      // 62: areturn
      // 63: aload 0
      // 64: getfield x/ocb704df8382.ȑ Ljava/io/File;
      // 67: invokevirtual java/io/File.toPath ()Ljava/nio/file/Path;
      // 6a: getstatic java/nio/charset/StandardCharsets.UTF_8 Ljava/nio/charset/Charset;
      // 6d: invokestatic java/nio/file/Files.newBufferedReader (Ljava/nio/file/Path;Ljava/nio/charset/Charset;)Ljava/io/BufferedReader;
      // 70: astore 7
      // 72: new com/google/gson/JsonParser
      // 75: dup
      // 76: invokespecial com/google/gson/JsonParser.<init> ()V
      // 79: aload 7
      // 7b: invokevirtual com/google/gson/JsonParser.parse (Ljava/io/Reader;)Lcom/google/gson/JsonElement;
      // 7e: astore 8
      // 80: aload 8
      // 82: iload 3
      // 83: iflt 94
      // 86: iload 6
      // 88: ifne 94
      // 8b: ifnull af
      // 8e: goto 92
      // 91: athrow
      // 92: aload 8
      // 94: iload 6
      // 96: ifne a9
      // 99: invokevirtual com/google/gson/JsonElement.isJsonObject ()Z
      // 9c: ifeq af
      // 9f: goto a3
      // a2: athrow
      // a3: aload 8
      // a5: goto a9
      // a8: athrow
      // a9: invokevirtual com/google/gson/JsonElement.getAsJsonObject ()Lcom/google/gson/JsonObject;
      // ac: goto b6
      // af: new com/google/gson/JsonObject
      // b2: dup
      // b3: invokespecial com/google/gson/JsonObject.<init> ()V
      // b6: astore 9
      // b8: aload 7
      // ba: iload 6
      // bc: ifne c8
      // bf: ifnull cb
      // c2: goto c6
      // c5: athrow
      // c6: aload 7
      // c8: invokevirtual java/io/BufferedReader.close ()V
      // cb: aload 9
      // cd: areturn
      // ce: astore 8
      // d0: iload 6
      // d2: ifne e3
      // d5: aload 7
      // d7: ifnull ef
      // da: goto de
      // dd: athrow
      // de: aload 7
      // e0: invokevirtual java/io/BufferedReader.close ()V
      // e3: goto ef
      // e6: astore 9
      // e8: aload 8
      // ea: aload 9
      // ec: invokevirtual java/lang/Throwable.addSuppressed (Ljava/lang/Throwable;)V
      // ef: aload 8
      // f1: athrow
      // f2: astore 7
      // f4: new com/google/gson/JsonObject
      // f7: dup
      // f8: invokespecial com/google/gson/JsonObject.<init> ()V
      // fb: areturn
   }

   // $VF: Irreducible bytecode was duplicated to produce valid code
   static {
      long var1 = 5314678823156356399L ^ 5314800038025868526L;
      long var3 = var1 ^ 5314777687367535145L ^ 5314800038025868526L;
      char[] var10001 = "\u0019og F!U\u0001Ba)d\tT\u0010k".toCharArray();
      int var10003 = var10001.length;
      int var0 = 0;
      char[] var16 = var10001;
      int var7 = var10003;
      char[] var24;
      int var10004;
      if (var10003 <= 1) {
         var24 = var10001;
         var10004 = var0;
      } else {
         var16 = var10001;
         var7 = var10003;
         if (var10003 <= var0) {
            String var32 = new String(var10001).intern();
            byte var13 = -1;
            a = var32;
            long var21 = 5314678823156421935L ^ 5314800038025868526L ^ var1;
            byte var14 = -1;
            b = var21;
            Ί = ɏ(var3);
            է = new Object();
            ԍ = new GsonBuilder().setPrettyPrinting().create();
            ȳ = LogManager.getLogger(ocb704df8382.class);
            return;
         }

         var24 = var10001;
         var10004 = var0;
      }

      while (true) {
         var24[var10004] = (char)(var24[var10004] ^ switch (var0 % (-1541277556 ^ -1541277557)) {
            case 0 -> -1541277441 ^ -1541277557;
            case 1 -> -1541277563 ^ -1541277557;
            case 2 -> -1541277563 ^ -1541277557;
            case 3 -> -1541277499 ^ -1541277557;
            case 4 -> -1541277568 ^ -1541277557;
            case 5 -> -1541277489 ^ -1541277557;
            default -> -1541277520 ^ -1541277557;
         });
         var0++;
         if (var7 == 0) {
            var10004 = var7;
            var24 = var16;
         } else {
            if (var7 <= var0) {
               String var31 = new String(var16).intern();
               byte var11 = -1;
               a = var31;
               long var20 = 5314678823156421935L ^ 5314800038025868526L ^ var1;
               byte var12 = -1;
               b = var20;
               Ί = ɏ(var3);
               է = new Object();
               ԍ = new GsonBuilder().setPrettyPrinting().create();
               ȳ = LogManager.getLogger(ocb704df8382.class);
               return;
            }

            var24 = var16;
            var10004 = var0;
         }
      }
   }
}

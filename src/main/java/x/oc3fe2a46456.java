package x;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Pattern;

public class oc3fe2a46456 {
   public static String Ճ = "";
   private static final Pattern ƀ = Pattern.compile("<meta property=\"(?:og:image|twitter:image)\" content=\"(?<url>.+?)\".*?/?>");
   private static final Pattern ι = Pattern.compile("<img.*?src=\"(?<url>.+?)\".*?>");
   public static final String ҿ = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36";
   public static boolean օ;

   public static boolean ç(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: aload 0
      // 04: ldc "https://api.hypixel.net/key?key="
      // 06: swap
      // 07: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 0c: bipush 0
      // 0d: invokestatic x/oc3fe2a46456.Ҏ (Ljava/lang/String;Z)Ljava/lang/String;
      // 10: astore 2
      // 11: istore 1
      // 12: aload 2
      // 13: iload 1
      // 14: ifne 26
      // 17: invokevirtual java/lang/String.isEmpty ()Z
      // 1a: ifne 3a
      // 1d: goto 21
      // 20: athrow
      // 21: aload 2
      // 22: goto 26
      // 25: athrow
      // 26: ldc "Invalid"
      // 28: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 2b: iload 1
      // 2c: ifne 37
      // 2f: ifne 3a
      // 32: goto 36
      // 35: athrow
      // 36: bipush 1
      // 37: goto 3b
      // 3a: bipush 0
      // 3b: ireturn
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public static String Ҏ(String var0, boolean var1) {
      String var3 = "";
      int var2 = oc75d51ec7eb.ϩ;
      HttpURLConnection var4 = null;
      boolean var12 = false /* VF: Semaphore variable */;

      label94: {
         try {
            var12 = true;
            URL var5 = new URL(var0);
            var4 = (HttpURLConnection)var5.openConnection();
            var4.setConnectTimeout(-295310727 ^ -295306767);
            var4.setReadTimeout(-295313695 ^ -295306767);
            String var23 = å(var4, var1);
            if (var2 != 0) {
               var12 = false;
               return var23;
            }

            var3 = var23;
            var12 = false;
            break label94;
         } catch (IOException var16) {
            if (var2 != 0) {
               var12 = false;
               return var3;
            }

            var12 = false;
         } finally {
            if (var12) {
               label77: {
                  HttpURLConnection var10000;
                  label76: {
                     try {
                        var10000 = var4;
                        if (var2 != 0) {
                           break label76;
                        }

                        if (var4 == null) {
                           break label77;
                        }
                     } catch (IOException var15) {
                        throw var15;
                     }

                     var10000 = var4;
                  }

                  var10000.disconnect();
               }
            }
         }

         try {
            if (var4 != null) {
               var4.disconnect();
            }

            return var3;
         } catch (IOException var13) {
            throw var13;
         }
      }

      try {
         if (var4 != null) {
            var4.disconnect();
         }
      } catch (IOException var14) {
         throw var14;
      }

      return var3;
   }

   public static String å(HttpURLConnection param0, boolean param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 2
      // 04: aload 0
      // 05: ifnull 76
      // 08: new java/io/BufferedReader
      // 0b: dup
      // 0c: new java/io/InputStreamReader
      // 0f: dup
      // 10: aload 0
      // 11: invokevirtual java/net/HttpURLConnection.getInputStream ()Ljava/io/InputStream;
      // 14: invokespecial java/io/InputStreamReader.<init> (Ljava/io/InputStream;)V
      // 17: invokespecial java/io/BufferedReader.<init> (Ljava/io/Reader;)V
      // 1a: astore 3
      // 1b: new java/lang/StringBuilder
      // 1e: dup
      // 1f: invokespecial java/lang/StringBuilder.<init> ()V
      // 22: astore 5
      // 24: aload 3
      // 25: invokevirtual java/io/BufferedReader.readLine ()Ljava/lang/String;
      // 28: dup
      // 29: astore 6
      // 2b: ifnull 53
      // 2e: aload 5
      // 30: iload 2
      // 31: ifne 55
      // 34: aload 6
      // 36: iload 1
      // 37: ifeq 44
      // 3a: goto 3e
      // 3d: athrow
      // 3e: ldc "\n"
      // 40: goto 46
      // 43: athrow
      // 44: ldc ""
      // 46: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 4b: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 4e: pop
      // 4f: iload 2
      // 50: ifeq 24
      // 53: aload 5
      // 55: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 58: astore 7
      // 5a: aload 0
      // 5b: invokevirtual java/net/HttpURLConnection.disconnect ()V
      // 5e: aload 7
      // 60: astore 4
      // 62: aload 3
      // 63: invokevirtual java/io/BufferedReader.close ()V
      // 66: goto 72
      // 69: astore 8
      // 6b: aload 3
      // 6c: invokevirtual java/io/BufferedReader.close ()V
      // 6f: aload 8
      // 71: athrow
      // 72: aload 4
      // 74: areturn
      // 75: astore 3
      // 76: ldc ""
      // 78: areturn
   }

   public static BufferedImage ԁ(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 1
      // 004: new java/net/URL
      // 007: dup
      // 008: aload 0
      // 009: invokespecial java/net/URL.<init> (Ljava/lang/String;)V
      // 00c: astore 2
      // 00d: bipush 0
      // 00e: istore 4
      // 010: iload 4
      // 012: ldc 1636283257
      // 014: ldc 1636283249
      // 016: ixor
      // 017: if_icmpge 213
      // 01a: aload 2
      // 01b: invokevirtual java/net/URL.openConnection ()Ljava/net/URLConnection;
      // 01e: checkcast java/net/HttpURLConnection
      // 021: astore 3
      // 022: aload 3
      // 023: ldc "GET"
      // 025: invokevirtual java/net/HttpURLConnection.setRequestMethod (Ljava/lang/String;)V
      // 028: aload 3
      // 029: bipush 1
      // 02a: invokevirtual java/net/HttpURLConnection.setUseCaches (Z)V
      // 02d: aload 3
      // 02e: bipush 0
      // 02f: invokevirtual java/net/HttpURLConnection.setInstanceFollowRedirects (Z)V
      // 032: aload 3
      // 033: ldc 1636278521
      // 035: ldc 1636283249
      // 037: ixor
      // 038: invokevirtual java/net/HttpURLConnection.setConnectTimeout (I)V
      // 03b: aload 3
      // 03c: ldc 1636275297
      // 03e: ldc 1636283249
      // 040: ixor
      // 041: invokevirtual java/net/HttpURLConnection.setReadTimeout (I)V
      // 044: aload 3
      // 045: iload 1
      // 046: ifne 075
      // 049: ldc "User-Agent"
      // 04b: ldc "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36"
      // 04d: invokevirtual java/net/HttpURLConnection.setRequestProperty (Ljava/lang/String;Ljava/lang/String;)V
      // 050: aload 3
      // 051: ldc "Accept"
      // 053: ldc "text/html, image/*"
      // 055: invokevirtual java/net/HttpURLConnection.setRequestProperty (Ljava/lang/String;Ljava/lang/String;)V
      // 058: aload 2
      // 059: invokevirtual java/net/URL.getHost ()Ljava/lang/String;
      // 05c: ldc "imgur"
      // 05e: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 061: ifeq 074
      // 064: goto 068
      // 067: athrow
      // 068: aload 3
      // 069: ldc "Referer"
      // 06b: ldc "https://imgur.com/"
      // 06d: invokevirtual java/net/HttpURLConnection.setRequestProperty (Ljava/lang/String;Ljava/lang/String;)V
      // 070: goto 074
      // 073: athrow
      // 074: aload 3
      // 075: invokevirtual java/net/HttpURLConnection.getResponseCode ()I
      // 078: istore 5
      // 07a: iload 5
      // 07c: iload 1
      // 07d: ifne 092
      // 080: ldc 1636282973
      // 082: ldc 1636283249
      // 084: ixor
      // 085: if_icmplt 0cc
      // 088: goto 08c
      // 08b: athrow
      // 08c: iload 5
      // 08e: goto 092
      // 091: athrow
      // 092: ldc 1636283105
      // 094: ldc 1636283249
      // 096: ixor
      // 097: if_icmpge 0cc
      // 09a: aload 3
      // 09b: ldc "Location"
      // 09d: invokevirtual java/net/HttpURLConnection.getHeaderField (Ljava/lang/String;)Ljava/lang/String;
      // 0a0: astore 6
      // 0a2: aload 3
      // 0a3: invokevirtual java/net/HttpURLConnection.disconnect ()V
      // 0a6: aload 6
      // 0a8: iload 1
      // 0a9: ifne 0b5
      // 0ac: ifnull 0bb
      // 0af: goto 0b3
      // 0b2: athrow
      // 0b3: aload 6
      // 0b5: invokevirtual java/lang/String.isEmpty ()Z
      // 0b8: ifeq 0bd
      // 0bb: aconst_null
      // 0bc: areturn
      // 0bd: new java/net/URL
      // 0c0: dup
      // 0c1: aload 2
      // 0c2: aload 6
      // 0c4: invokespecial java/net/URL.<init> (Ljava/net/URL;Ljava/lang/String;)V
      // 0c7: astore 2
      // 0c8: iload 1
      // 0c9: ifeq 20c
      // 0cc: aload 3
      // 0cd: invokevirtual java/net/HttpURLConnection.getContentType ()Ljava/lang/String;
      // 0d0: astore 6
      // 0d2: aload 6
      // 0d4: iload 1
      // 0d5: ifne 0e1
      // 0d8: ifnull 13b
      // 0db: goto 0df
      // 0de: athrow
      // 0df: aload 6
      // 0e1: ldc "image"
      // 0e3: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 0e6: ifeq 13b
      // 0e9: aload 3
      // 0ea: invokevirtual java/net/HttpURLConnection.getInputStream ()Ljava/io/InputStream;
      // 0ed: astore 7
      // 0ef: aload 7
      // 0f1: invokestatic net/minecraft/client/renderer/texture/TextureUtil.readBufferedImage (Ljava/io/InputStream;)Ljava/awt/image/BufferedImage;
      // 0f4: astore 8
      // 0f6: iload 1
      // 0f7: ifne 10c
      // 0fa: aload 7
      // 0fc: ifnull 108
      // 0ff: aload 7
      // 101: invokevirtual java/io/InputStream.close ()V
      // 104: goto 108
      // 107: athrow
      // 108: aload 3
      // 109: invokevirtual java/net/HttpURLConnection.disconnect ()V
      // 10c: aload 8
      // 10e: areturn
      // 10f: astore 8
      // 111: iload 1
      // 112: ifne 123
      // 115: aload 7
      // 117: ifnull 12f
      // 11a: goto 11e
      // 11d: athrow
      // 11e: aload 7
      // 120: invokevirtual java/io/InputStream.close ()V
      // 123: goto 12f
      // 126: astore 9
      // 128: aload 8
      // 12a: aload 9
      // 12c: invokevirtual java/lang/Throwable.addSuppressed (Ljava/lang/Throwable;)V
      // 12f: aload 8
      // 131: athrow
      // 132: astore 10
      // 134: aload 3
      // 135: invokevirtual java/net/HttpURLConnection.disconnect ()V
      // 138: aload 10
      // 13a: athrow
      // 13b: aload 3
      // 13c: invokevirtual java/net/HttpURLConnection.getInputStream ()Ljava/io/InputStream;
      // 13f: astore 7
      // 141: aload 7
      // 143: ldc "UTF-8"
      // 145: invokestatic org/apache/commons/io/IOUtils.toString (Ljava/io/InputStream;Ljava/lang/String;)Ljava/lang/String;
      // 148: astore 8
      // 14a: iload 1
      // 14b: ldc ""
      // 14d: astore 9
      // 14f: getstatic x/oc3fe2a46456.ƀ Ljava/util/regex/Pattern;
      // 152: aload 8
      // 154: invokevirtual java/util/regex/Pattern.matcher (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
      // 157: astore 10
      // 159: ifne 17f
      // 15c: aload 10
      // 15e: invokevirtual java/util/regex/Matcher.find ()Z
      // 161: ifeq 175
      // 164: goto 168
      // 167: athrow
      // 168: aload 10
      // 16a: ldc "url"
      // 16c: invokevirtual java/util/regex/Matcher.group (Ljava/lang/String;)Ljava/lang/String;
      // 16f: astore 9
      // 171: iload 1
      // 172: ifeq 198
      // 175: getstatic x/oc3fe2a46456.ι Ljava/util/regex/Pattern;
      // 178: aload 8
      // 17a: invokevirtual java/util/regex/Pattern.matcher (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
      // 17d: astore 10
      // 17f: aload 10
      // 181: invokevirtual java/util/regex/Matcher.find ()Z
      // 184: iload 1
      // 185: ifne 19d
      // 188: ifeq 198
      // 18b: goto 18f
      // 18e: athrow
      // 18f: aload 10
      // 191: ldc "url"
      // 193: invokevirtual java/util/regex/Matcher.group (Ljava/lang/String;)Ljava/lang/String;
      // 196: astore 9
      // 198: aload 9
      // 19a: invokevirtual java/lang/String.isEmpty ()Z
      // 19d: ifeq 1bc
      // 1a0: aconst_null
      // 1a1: astore 11
      // 1a3: iload 1
      // 1a4: ifne 1b9
      // 1a7: aload 7
      // 1a9: ifnull 1b5
      // 1ac: aload 7
      // 1ae: invokevirtual java/io/InputStream.close ()V
      // 1b1: goto 1b5
      // 1b4: athrow
      // 1b5: aload 3
      // 1b6: invokevirtual java/net/HttpURLConnection.disconnect ()V
      // 1b9: aload 11
      // 1bb: areturn
      // 1bc: new java/net/URL
      // 1bf: dup
      // 1c0: aload 2
      // 1c1: aload 9
      // 1c3: invokespecial java/net/URL.<init> (Ljava/net/URL;Ljava/lang/String;)V
      // 1c6: astore 2
      // 1c7: iload 1
      // 1c8: ifne 200
      // 1cb: aload 7
      // 1cd: ifnull 1fc
      // 1d0: aload 7
      // 1d2: invokevirtual java/io/InputStream.close ()V
      // 1d5: goto 1fc
      // 1d8: athrow
      // 1d9: astore 8
      // 1db: iload 1
      // 1dc: ifne 1ed
      // 1df: aload 7
      // 1e1: ifnull 1f9
      // 1e4: goto 1e8
      // 1e7: athrow
      // 1e8: aload 7
      // 1ea: invokevirtual java/io/InputStream.close ()V
      // 1ed: goto 1f9
      // 1f0: astore 9
      // 1f2: aload 8
      // 1f4: aload 9
      // 1f6: invokevirtual java/lang/Throwable.addSuppressed (Ljava/lang/Throwable;)V
      // 1f9: aload 8
      // 1fb: athrow
      // 1fc: aload 3
      // 1fd: invokevirtual java/net/HttpURLConnection.disconnect ()V
      // 200: goto 20c
      // 203: astore 12
      // 205: aload 3
      // 206: invokevirtual java/net/HttpURLConnection.disconnect ()V
      // 209: aload 12
      // 20b: athrow
      // 20c: iinc 4 1
      // 20f: iload 1
      // 210: ifeq 010
      // 213: aconst_null
      // 214: areturn
      // 215: astore 2
      // 216: aload 2
      // 217: invokevirtual java/lang/Exception.printStackTrace ()V
      // 21a: aconst_null
      // 21b: areturn
   }
}

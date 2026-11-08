package x;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Map;

public class oc380d0f830c {
   public static final String Ȯ = "https://api.getmiau.today";
   public static String D = "myau";
   private static final String Ɋ = "/api/v1";
   private static final String Ǡ = "/api/v1/client/" + D;
   private static final int Ԓ = 5000;
   private static final int Î = 10000;
   private static final int Ԧ = 2097152;
   public static int Ώ;

   private static String ȉ() {
      return "Miau/" + D;
   }

   private oc380d0f830c() {
   }

   public static String Ӊ(String var0) {
      return "https://api.getmiau.today" + φ(var0);
   }

   public static String Ϝ(String var0) {
      return "https://api.getmiau.today/api/v1" + φ(var0);
   }

   public static String Ѿ(String var0) {
      String var10000 = Ǡ;
      String var1 = φ(var0);
      String var2 = var10000;
      return "https://api.getmiau.today" + var2 + var1;
   }

   public static String ѓ(String var0) {
      int var1 = Ώ;

      String var6;
      try {
         label41: {
            label40: {
               try {
                  var6 = var0;
                  if (var1 != 0) {
                     break label41;
                  }

                  if (var0 == null) {
                     break label40;
                  }
               } catch (Exception var4) {
                  throw var4;
               }

               var6 = var0;
               break label41;
            }

            var6 = "";
         }

         var6 = URLEncoder.encode(var6, StandardCharsets.UTF_8.name()).replace("+", "%20");
      } catch (Exception var5) {
         throw new IllegalStateException(var5);
      }

      if (var1 != 0) {
         boolean var10001;
         label30: {
            try {
               if (false) {
                  var10001 = false;
                  break label30;
               }
            } catch (Exception var3) {
               throw var3;
            }

            var10001 = true;
         }

         oc69da1aa7f5.Ҭ = var10001;
      }

      return var6;
   }

   public static String Ɋ(String var0) throws IOException {
      return Ҋ("GET", Ӊ(var0), null, Collections.emptyMap());
   }

   public static String Ĺ(String var0) throws IOException {
      return Ҋ("GET", Ϝ(var0), null, Collections.emptyMap());
   }

   public static String ɦ(String var0) throws IOException {
      return Ҋ("GET", Ѿ(var0), null, Collections.emptyMap());
   }

   public static String ʜ(String var0, String var1, String var2, Map<String, String> var3) throws IOException {
      return Ҋ(var0, Ӊ(var1), var2, var3);
   }

   public static String к(String var0, String var1, String var2, Map<String, String> var3) throws IOException {
      return Ҋ(var0, Ϝ(var1), var2, var3);
   }

   public static String Ǥ(String var0, String var1, String var2, Map<String, String> var3) throws IOException {
      return Ҋ(var0, Ѿ(var1), var2, var3);
   }

   private static String Ҋ(String param0, String param1, String param2, Map<String, String> param3) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc380d0f830c.Ώ I
      // 003: istore 4
      // 005: aload 0
      // 006: iload 4
      // 008: ifne 01c
      // 00b: ifnonnull 018
      // 00e: goto 012
      // 011: athrow
      // 012: ldc ""
      // 014: goto 022
      // 017: athrow
      // 018: aload 0
      // 019: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 01c: getstatic java/util/Locale.ROOT Ljava/util/Locale;
      // 01f: invokevirtual java/lang/String.toUpperCase (Ljava/util/Locale;)Ljava/lang/String;
      // 022: astore 5
      // 024: aload 5
      // 026: invokevirtual java/lang/String.isEmpty ()Z
      // 029: ifeq 037
      // 02c: new java/lang/IllegalArgumentException
      // 02f: dup
      // 030: ldc "HTTP method is required"
      // 032: invokespecial java/lang/IllegalArgumentException.<init> (Ljava/lang/String;)V
      // 035: athrow
      // 036: athrow
      // 037: new java/net/URL
      // 03a: dup
      // 03b: aload 1
      // 03c: invokespecial java/net/URL.<init> (Ljava/lang/String;)V
      // 03f: invokevirtual java/net/URL.openConnection ()Ljava/net/URLConnection;
      // 042: checkcast java/net/HttpURLConnection
      // 045: astore 6
      // 047: aload 6
      // 049: aload 5
      // 04b: invokevirtual java/net/HttpURLConnection.setRequestMethod (Ljava/lang/String;)V
      // 04e: aload 6
      // 050: bipush 0
      // 051: invokevirtual java/net/HttpURLConnection.setUseCaches (Z)V
      // 054: aload 6
      // 056: ldc 205058019
      // 058: ldc 205061227
      // 05a: ixor
      // 05b: invokevirtual java/net/HttpURLConnection.setConnectTimeout (I)V
      // 05e: aload 6
      // 060: ldc 205052795
      // 062: ldc 205061227
      // 064: ixor
      // 065: invokevirtual java/net/HttpURLConnection.setReadTimeout (I)V
      // 068: aload 6
      // 06a: ldc "Accept"
      // 06c: ldc "application/json"
      // 06e: invokevirtual java/net/HttpURLConnection.setRequestProperty (Ljava/lang/String;Ljava/lang/String;)V
      // 071: aload 6
      // 073: ldc "User-Agent"
      // 075: invokestatic x/oc380d0f830c.ȉ ()Ljava/lang/String;
      // 078: invokevirtual java/net/HttpURLConnection.setRequestProperty (Ljava/lang/String;Ljava/lang/String;)V
      // 07b: aload 3
      // 07c: iload 4
      // 07e: ifne 08b
      // 081: ifnonnull 08e
      // 084: goto 088
      // 087: athrow
      // 088: invokestatic java/util/Collections.emptyMap ()Ljava/util/Map;
      // 08b: goto 08f
      // 08e: aload 3
      // 08f: astore 7
      // 091: aload 7
      // 093: invokeinterface java/util/Map.entrySet ()Ljava/util/Set; 1
      // 098: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 09d: astore 8
      // 09f: aload 8
      // 0a1: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0a6: ifeq 101
      // 0a9: aload 8
      // 0ab: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0b0: checkcast java/util/Map$Entry
      // 0b3: astore 9
      // 0b5: iload 4
      // 0b7: ifne 18d
      // 0ba: aload 9
      // 0bc: iload 4
      // 0be: ifne 0dc
      // 0c1: goto 0c5
      // 0c4: athrow
      // 0c5: invokeinterface java/util/Map$Entry.getKey ()Ljava/lang/Object; 1
      // 0ca: ifnull 0fc
      // 0cd: goto 0d1
      // 0d0: athrow
      // 0d1: aload 9
      // 0d3: invokeinterface java/util/Map$Entry.getValue ()Ljava/lang/Object; 1
      // 0d8: goto 0dc
      // 0db: athrow
      // 0dc: ifnull 0fc
      // 0df: aload 6
      // 0e1: aload 9
      // 0e3: invokeinterface java/util/Map$Entry.getKey ()Ljava/lang/Object; 1
      // 0e8: checkcast java/lang/String
      // 0eb: aload 9
      // 0ed: invokeinterface java/util/Map$Entry.getValue ()Ljava/lang/Object; 1
      // 0f2: checkcast java/lang/String
      // 0f5: invokevirtual java/net/HttpURLConnection.setRequestProperty (Ljava/lang/String;Ljava/lang/String;)V
      // 0f8: goto 0fc
      // 0fb: athrow
      // 0fc: iload 4
      // 0fe: ifeq 09f
      // 101: aload 2
      // 102: iload 4
      // 104: ifne 11f
      // 107: ifnull 18d
      // 10a: goto 10e
      // 10d: athrow
      // 10e: aload 6
      // 110: bipush 1
      // 111: invokevirtual java/net/HttpURLConnection.setDoOutput (Z)V
      // 114: aload 6
      // 116: ldc "Content-Type"
      // 118: invokevirtual java/net/HttpURLConnection.getRequestProperty (Ljava/lang/String;)Ljava/lang/String;
      // 11b: goto 11f
      // 11e: athrow
      // 11f: iload 4
      // 121: ifne 139
      // 124: ifnonnull 138
      // 127: goto 12b
      // 12a: athrow
      // 12b: aload 6
      // 12d: ldc "Content-Type"
      // 12f: ldc "application/json; charset=UTF-8"
      // 131: invokevirtual java/net/HttpURLConnection.setRequestProperty (Ljava/lang/String;Ljava/lang/String;)V
      // 134: goto 138
      // 137: athrow
      // 138: aload 2
      // 139: getstatic java/nio/charset/StandardCharsets.UTF_8 Ljava/nio/charset/Charset;
      // 13c: invokevirtual java/lang/String.getBytes (Ljava/nio/charset/Charset;)[B
      // 13f: astore 8
      // 141: aload 6
      // 143: iload 4
      // 145: ifne 18f
      // 148: aload 8
      // 14a: arraylength
      // 14b: invokevirtual java/net/HttpURLConnection.setFixedLengthStreamingMode (I)V
      // 14e: aload 6
      // 150: invokevirtual java/net/HttpURLConnection.getOutputStream ()Ljava/io/OutputStream;
      // 153: astore 9
      // 155: aload 9
      // 157: aload 8
      // 159: invokevirtual java/io/OutputStream.write ([B)V
      // 15c: aload 9
      // 15e: ifnull 18d
      // 161: aload 9
      // 163: invokevirtual java/io/OutputStream.close ()V
      // 166: goto 18d
      // 169: astore 10
      // 16b: iload 4
      // 16d: ifne 17e
      // 170: aload 9
      // 172: ifnull 18a
      // 175: goto 179
      // 178: athrow
      // 179: aload 9
      // 17b: invokevirtual java/io/OutputStream.close ()V
      // 17e: goto 18a
      // 181: astore 11
      // 183: aload 10
      // 185: aload 11
      // 187: invokevirtual java/lang/Throwable.addSuppressed (Ljava/lang/Throwable;)V
      // 18a: aload 10
      // 18c: athrow
      // 18d: aload 6
      // 18f: invokevirtual java/net/HttpURLConnection.getResponseCode ()I
      // 192: istore 8
      // 194: iload 8
      // 196: iload 4
      // 198: ifne 1ae
      // 19b: ldc_w 205061283
      // 19e: ldc 205061227
      // 1a0: ixor
      // 1a1: if_icmplt 1c0
      // 1a4: goto 1a8
      // 1a7: athrow
      // 1a8: iload 8
      // 1aa: goto 1ae
      // 1ad: athrow
      // 1ae: ldc_w 205061447
      // 1b1: ldc 205061227
      // 1b3: ixor
      // 1b4: if_icmpge 1c0
      // 1b7: aload 6
      // 1b9: invokevirtual java/net/HttpURLConnection.getInputStream ()Ljava/io/InputStream;
      // 1bc: goto 1c5
      // 1bf: athrow
      // 1c0: aload 6
      // 1c2: invokevirtual java/net/HttpURLConnection.getErrorStream ()Ljava/io/InputStream;
      // 1c5: invokestatic x/oc380d0f830c.ȧ (Ljava/io/InputStream;)Ljava/lang/String;
      // 1c8: astore 9
      // 1ca: iload 8
      // 1cc: iload 4
      // 1ce: ifne 1e4
      // 1d1: ldc_w 205061283
      // 1d4: ldc 205061227
      // 1d6: ixor
      // 1d7: if_icmplt 1ed
      // 1da: goto 1de
      // 1dd: athrow
      // 1de: iload 8
      // 1e0: goto 1e4
      // 1e3: athrow
      // 1e4: ldc_w 205061447
      // 1e7: ldc 205061227
      // 1e9: ixor
      // 1ea: if_icmplt 1ff
      // 1ed: new x/oca5f3ad0ac4
      // 1f0: dup
      // 1f1: iload 8
      // 1f3: iload 8
      // 1f5: aload 9
      // 1f7: invokestatic x/oc380d0f830c.F (ILjava/lang/String;)Ljava/lang/String;
      // 1fa: invokespecial x/oca5f3ad0ac4.<init> (ILjava/lang/String;)V
      // 1fd: athrow
      // 1fe: athrow
      // 1ff: aload 9
      // 201: astore 10
      // 203: aload 6
      // 205: invokevirtual java/net/HttpURLConnection.disconnect ()V
      // 208: aload 10
      // 20a: areturn
      // 20b: astore 12
      // 20d: aload 6
      // 20f: invokevirtual java/net/HttpURLConnection.disconnect ()V
      // 212: aload 12
      // 214: athrow
   }

   private static String ȧ(InputStream param0) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc380d0f830c.Ώ I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 15
      // 09: ifnonnull 14
      // 0c: goto 10
      // 0f: athrow
      // 10: ldc ""
      // 12: areturn
      // 13: athrow
      // 14: aload 0
      // 15: astore 2
      // 16: new java/io/ByteArrayOutputStream
      // 19: dup
      // 1a: invokespecial java/io/ByteArrayOutputStream.<init> ()V
      // 1d: astore 3
      // 1e: ldc_w 924662711
      // 21: ldc_w 924658615
      // 24: ixor
      // 25: newarray 8
      // 27: astore 4
      // 29: bipush 0
      // 2a: istore 5
      // 2c: aload 2
      // 2d: aload 4
      // 2f: invokevirtual java/io/InputStream.read ([B)I
      // 32: dup
      // 33: istore 6
      // 35: bipush -1
      // 36: if_icmpeq 6d
      // 39: iload 5
      // 3b: iload 6
      // 3d: iadd
      // 3e: istore 5
      // 40: iload 1
      // 41: ifne 69
      // 44: iload 5
      // 46: ldc_w 926755767
      // 49: ldc_w 924658615
      // 4c: ixor
      // 4d: if_icmple 60
      // 50: goto 54
      // 53: athrow
      // 54: new java/io/IOException
      // 57: dup
      // 58: ldc_w "Miau API response is too large"
      // 5b: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 5e: athrow
      // 5f: athrow
      // 60: aload 3
      // 61: aload 4
      // 63: bipush 0
      // 64: iload 6
      // 66: invokevirtual java/io/ByteArrayOutputStream.write ([BII)V
      // 69: iload 1
      // 6a: ifeq 2c
      // 6d: new java/lang/String
      // 70: dup
      // 71: aload 3
      // 72: invokevirtual java/io/ByteArrayOutputStream.toByteArray ()[B
      // 75: getstatic java/nio/charset/StandardCharsets.UTF_8 Ljava/nio/charset/Charset;
      // 78: invokespecial java/lang/String.<init> ([BLjava/nio/charset/Charset;)V
      // 7b: astore 7
      // 7d: aload 3
      // 7e: invokevirtual java/io/ByteArrayOutputStream.close ()V
      // 81: aload 2
      // 82: iload 1
      // 83: ifne 8a
      // 86: ifnull 8d
      // 89: aload 2
      // 8a: invokevirtual java/io/InputStream.close ()V
      // 8d: aload 7
      // 8f: areturn
      // 90: astore 4
      // 92: aload 3
      // 93: invokevirtual java/io/ByteArrayOutputStream.close ()V
      // 96: goto a2
      // 99: astore 5
      // 9b: aload 4
      // 9d: aload 5
      // 9f: invokevirtual java/lang/Throwable.addSuppressed (Ljava/lang/Throwable;)V
      // a2: aload 4
      // a4: athrow
      // a5: astore 3
      // a6: iload 1
      // a7: ifne b6
      // aa: aload 2
      // ab: ifnull c1
      // ae: goto b2
      // b1: athrow
      // b2: aload 2
      // b3: invokevirtual java/io/InputStream.close ()V
      // b6: goto c1
      // b9: astore 4
      // bb: aload 3
      // bc: aload 4
      // be: invokevirtual java/lang/Throwable.addSuppressed (Ljava/lang/Throwable;)V
      // c1: aload 3
      // c2: athrow
   }

   private static String F(int param0, String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc380d0f830c.Ώ I
      // 03: istore 2
      // 04: new com/google/gson/JsonParser
      // 07: dup
      // 08: invokespecial com/google/gson/JsonParser.<init> ()V
      // 0b: aload 1
      // 0c: invokevirtual com/google/gson/JsonParser.parse (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 0f: astore 3
      // 10: aload 3
      // 11: iload 2
      // 12: ifne 24
      // 15: invokevirtual com/google/gson/JsonElement.isJsonObject ()Z
      // 18: ifeq 74
      // 1b: goto 1f
      // 1e: athrow
      // 1f: aload 3
      // 20: goto 24
      // 23: athrow
      // 24: invokevirtual com/google/gson/JsonElement.getAsJsonObject ()Lcom/google/gson/JsonObject;
      // 27: iload 2
      // 28: ifne 46
      // 2b: ldc_w "message"
      // 2e: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 31: ifeq 74
      // 34: goto 38
      // 37: athrow
      // 38: aload 3
      // 39: invokevirtual com/google/gson/JsonElement.getAsJsonObject ()Lcom/google/gson/JsonObject;
      // 3c: ldc_w "message"
      // 3f: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 42: goto 46
      // 45: athrow
      // 46: invokevirtual com/google/gson/JsonElement.getAsString ()Ljava/lang/String;
      // 49: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 4c: astore 4
      // 4e: aload 4
      // 50: iload 2
      // 51: ifne 73
      // 54: invokevirtual java/lang/String.isEmpty ()Z
      // 57: ifne 74
      // 5a: goto 5e
      // 5d: athrow
      // 5e: iload 0
      // 5f: aload 4
      // 61: ldc_w "HTTP "
      // 64: dup_x2
      // 65: pop
      // 66: ldc_w ": "
      // 69: swap
      // 6a: invokedynamic makeConcatWithConstants (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001\u0001" ]
      // 6f: goto 73
      // 72: athrow
      // 73: areturn
      // 74: goto 78
      // 77: astore 3
      // 78: iload 0
      // 79: ldc_w "HTTP "
      // 7c: swap
      // 7d: invokedynamic makeConcatWithConstants (Ljava/lang/String;I)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 82: areturn
   }

   private static String φ(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 0
      // 01: ifnonnull 0a
      // 04: ldc ""
      // 06: goto 0e
      // 09: athrow
      // 0a: aload 0
      // 0b: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 0e: astore 1
      // 0f: aload 1
      // 10: getstatic java/util/Locale.ROOT Ljava/util/Locale;
      // 13: invokevirtual java/lang/String.toLowerCase (Ljava/util/Locale;)Ljava/lang/String;
      // 16: astore 2
      // 17: aload 1
      // 18: ldc_w "//"
      // 1b: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 1e: ifne 3d
      // 21: aload 2
      // 22: ldc_w "http://"
      // 25: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 28: ifne 3d
      // 2b: goto 2f
      // 2e: athrow
      // 2f: aload 2
      // 30: ldc_w "https://"
      // 33: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 36: ifeq 49
      // 39: goto 3d
      // 3c: athrow
      // 3d: new java/lang/IllegalArgumentException
      // 40: dup
      // 41: ldc_w "Miau API path must be relative"
      // 44: invokespecial java/lang/IllegalArgumentException.<init> (Ljava/lang/String;)V
      // 47: athrow
      // 48: athrow
      // 49: aload 1
      // 4a: invokevirtual java/lang/String.isEmpty ()Z
      // 4d: ifeq 54
      // 50: ldc ""
      // 52: areturn
      // 53: athrow
      // 54: aload 1
      // 55: ldc_w "/"
      // 58: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 5b: ifeq 63
      // 5e: aload 1
      // 5f: goto 69
      // 62: athrow
      // 63: aload 1
      // 64: invokedynamic makeConcatWithConstants (Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "/\u0001" ]
      // 69: areturn
   }
}

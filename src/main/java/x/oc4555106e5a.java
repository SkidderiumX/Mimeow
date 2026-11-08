package x;

import java.io.IOException;
import java.io.InputStream;

public class oc4555106e5a implements oce7be97fef5 {
   private static final int ѫ = 1048576;
   public static int ɿ;

   public oc51f4f13c5a z$1ahjbl7dqoxur(oc6bed6d7740 param1) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc51f4f13c5a.Ѕ I
      // 003: new java/net/URL
      // 006: dup
      // 007: aload 1
      // 008: invokevirtual x/oc6bed6d7740.Ҷ ()Ljava/lang/String;
      // 00b: invokespecial java/net/URL.<init> (Ljava/lang/String;)V
      // 00e: invokevirtual java/net/URL.openConnection ()Ljava/net/URLConnection;
      // 011: checkcast java/net/HttpURLConnection
      // 014: astore 3
      // 015: aload 3
      // 016: aload 1
      // 017: invokevirtual x/oc6bed6d7740.ψ ()Ljava/lang/String;
      // 01a: invokevirtual java/net/HttpURLConnection.setRequestMethod (Ljava/lang/String;)V
      // 01d: aload 3
      // 01e: aload 1
      // 01f: invokevirtual x/oc6bed6d7740.Ԅ ()I
      // 022: invokevirtual java/net/HttpURLConnection.setConnectTimeout (I)V
      // 025: istore 2
      // 026: aload 3
      // 027: aload 1
      // 028: invokevirtual x/oc6bed6d7740.ʓ ()I
      // 02b: invokevirtual java/net/HttpURLConnection.setReadTimeout (I)V
      // 02e: aload 3
      // 02f: ldc "User-Agent"
      // 031: ldc "Miau-Nextgen/1.8.9"
      // 033: invokevirtual java/net/HttpURLConnection.setRequestProperty (Ljava/lang/String;Ljava/lang/String;)V
      // 036: aload 1
      // 037: invokevirtual x/oc6bed6d7740.ǭ ()Ljava/util/Map;
      // 03a: invokeinterface java/util/Map.entrySet ()Ljava/util/Set; 1
      // 03f: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 044: astore 4
      // 046: aload 4
      // 048: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 04d: ifeq 08d
      // 050: aload 4
      // 052: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 057: checkcast java/util/Map$Entry
      // 05a: astore 5
      // 05c: iload 2
      // 05d: ifne 0f1
      // 060: aload 3
      // 061: aload 5
      // 063: invokeinterface java/util/Map$Entry.getKey ()Ljava/lang/Object; 1
      // 068: checkcast java/lang/String
      // 06b: aload 5
      // 06d: invokeinterface java/util/Map$Entry.getValue ()Ljava/lang/Object; 1
      // 072: checkcast java/lang/String
      // 075: invokevirtual java/net/HttpURLConnection.setRequestProperty (Ljava/lang/String;Ljava/lang/String;)V
      // 078: iload 2
      // 079: ifeq 046
      // 07c: goto 080
      // 07f: athrow
      // 080: bipush 0
      // 081: ifeq 089
      // 084: bipush 0
      // 085: goto 08a
      // 088: athrow
      // 089: bipush 1
      // 08a: putstatic x/oc69da1aa7f5.Ҭ Z
      // 08d: aload 1
      // 08e: invokevirtual x/oc6bed6d7740.Ə ()Ljava/lang/String;
      // 091: invokevirtual java/lang/String.isEmpty ()Z
      // 094: iload 2
      // 095: ifne 0f5
      // 098: ifne 0f1
      // 09b: goto 09f
      // 09e: athrow
      // 09f: aload 3
      // 0a0: iload 2
      // 0a1: ifne 0f2
      // 0a4: goto 0a8
      // 0a7: athrow
      // 0a8: bipush 1
      // 0a9: invokevirtual java/net/HttpURLConnection.setDoOutput (Z)V
      // 0ac: aload 3
      // 0ad: invokevirtual java/net/HttpURLConnection.getOutputStream ()Ljava/io/OutputStream;
      // 0b0: astore 4
      // 0b2: aload 4
      // 0b4: aload 1
      // 0b5: invokevirtual x/oc6bed6d7740.Ə ()Ljava/lang/String;
      // 0b8: getstatic java/nio/charset/StandardCharsets.UTF_8 Ljava/nio/charset/Charset;
      // 0bb: invokevirtual java/lang/String.getBytes (Ljava/nio/charset/Charset;)[B
      // 0be: invokevirtual java/io/OutputStream.write ([B)V
      // 0c1: aload 4
      // 0c3: ifnull 0f1
      // 0c6: aload 4
      // 0c8: invokevirtual java/io/OutputStream.close ()V
      // 0cb: goto 0f1
      // 0ce: astore 5
      // 0d0: iload 2
      // 0d1: ifne 0e2
      // 0d4: aload 4
      // 0d6: ifnull 0ee
      // 0d9: goto 0dd
      // 0dc: athrow
      // 0dd: aload 4
      // 0df: invokevirtual java/io/OutputStream.close ()V
      // 0e2: goto 0ee
      // 0e5: astore 6
      // 0e7: aload 5
      // 0e9: aload 6
      // 0eb: invokevirtual java/lang/Throwable.addSuppressed (Ljava/lang/Throwable;)V
      // 0ee: aload 5
      // 0f0: athrow
      // 0f1: aload 3
      // 0f2: invokevirtual java/net/HttpURLConnection.getResponseCode ()I
      // 0f5: istore 4
      // 0f7: iload 4
      // 0f9: ldc -1813508651
      // 0fb: ldc -1813509051
      // 0fd: ixor
      // 0fe: if_icmplt 109
      // 101: aload 3
      // 102: invokevirtual java/net/HttpURLConnection.getErrorStream ()Ljava/io/InputStream;
      // 105: goto 10d
      // 108: athrow
      // 109: aload 3
      // 10a: invokevirtual java/net/HttpURLConnection.getInputStream ()Ljava/io/InputStream;
      // 10d: astore 5
      // 10f: new x/oc51f4f13c5a
      // 112: dup
      // 113: iload 4
      // 115: aload 0
      // 116: aload 5
      // 118: invokevirtual x/oc4555106e5a.Ǻ (Ljava/io/InputStream;)Ljava/lang/String;
      // 11b: aload 3
      // 11c: invokevirtual java/net/HttpURLConnection.getHeaderFields ()Ljava/util/Map;
      // 11f: invokespecial x/oc51f4f13c5a.<init> (ILjava/lang/String;Ljava/util/Map;)V
      // 122: astore 6
      // 124: aload 3
      // 125: invokevirtual java/net/HttpURLConnection.disconnect ()V
      // 128: aload 6
      // 12a: areturn
      // 12b: astore 7
      // 12d: aload 3
      // 12e: invokevirtual java/net/HttpURLConnection.disconnect ()V
      // 131: aload 7
      // 133: athrow
   }

   private String Ǻ(InputStream param1) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc51f4f13c5a.Ѕ I
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 15
      // 09: ifnonnull 14
      // 0c: goto 10
      // 0f: athrow
      // 10: ldc ""
      // 12: areturn
      // 13: athrow
      // 14: aload 1
      // 15: astore 3
      // 16: new java/io/ByteArrayOutputStream
      // 19: dup
      // 1a: invokespecial java/io/ByteArrayOutputStream.<init> ()V
      // 1d: astore 4
      // 1f: ldc -1374580530
      // 21: ldc -1374584626
      // 23: ixor
      // 24: newarray 8
      // 26: astore 5
      // 28: bipush 0
      // 29: istore 6
      // 2b: aload 3
      // 2c: aload 5
      // 2e: invokevirtual java/io/InputStream.read ([B)I
      // 31: dup
      // 32: istore 7
      // 34: bipush -1
      // 35: if_icmpeq 6a
      // 38: iload 6
      // 3a: iload 7
      // 3c: iadd
      // 3d: istore 6
      // 3f: iload 2
      // 40: ifne 66
      // 43: iload 6
      // 45: ldc -1375633202
      // 47: ldc -1374584626
      // 49: ixor
      // 4a: if_icmple 5c
      // 4d: goto 51
      // 50: athrow
      // 51: new java/io/IOException
      // 54: dup
      // 55: ldc "Response body exceeded safe limit"
      // 57: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 5a: athrow
      // 5b: athrow
      // 5c: aload 4
      // 5e: aload 5
      // 60: bipush 0
      // 61: iload 7
      // 63: invokevirtual java/io/ByteArrayOutputStream.write ([BII)V
      // 66: iload 2
      // 67: ifeq 2b
      // 6a: new java/lang/String
      // 6d: dup
      // 6e: aload 4
      // 70: invokevirtual java/io/ByteArrayOutputStream.toByteArray ()[B
      // 73: getstatic java/nio/charset/StandardCharsets.UTF_8 Ljava/nio/charset/Charset;
      // 76: invokespecial java/lang/String.<init> ([BLjava/nio/charset/Charset;)V
      // 79: astore 8
      // 7b: aload 4
      // 7d: invokevirtual java/io/ByteArrayOutputStream.close ()V
      // 80: aload 3
      // 81: iload 2
      // 82: ifne 89
      // 85: ifnull 8c
      // 88: aload 3
      // 89: invokevirtual java/io/InputStream.close ()V
      // 8c: aload 8
      // 8e: areturn
      // 8f: astore 5
      // 91: aload 4
      // 93: invokevirtual java/io/ByteArrayOutputStream.close ()V
      // 96: goto a2
      // 99: astore 6
      // 9b: aload 5
      // 9d: aload 6
      // 9f: invokevirtual java/lang/Throwable.addSuppressed (Ljava/lang/Throwable;)V
      // a2: aload 5
      // a4: athrow
      // a5: astore 4
      // a7: iload 2
      // a8: ifne b7
      // ab: aload 3
      // ac: ifnull c3
      // af: goto b3
      // b2: athrow
      // b3: aload 3
      // b4: invokevirtual java/io/InputStream.close ()V
      // b7: goto c3
      // ba: astore 5
      // bc: aload 4
      // be: aload 5
      // c0: invokevirtual java/lang/Throwable.addSuppressed (Ljava/lang/Throwable;)V
      // c3: aload 4
      // c5: athrow
   }
}

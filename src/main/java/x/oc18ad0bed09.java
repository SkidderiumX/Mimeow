package x;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.Proxy;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Request.Builder;

public class oc18ad0bed09 {
   private static final String Є = "https://localts.store/v1";
   private static final RequestBody Ώ = RequestBody.create(new byte[0], null);
   private static final OkHttpClient ʇ = ŝ();
   private static final OkHttpClient Ջ = ʇ.newBuilder().proxy(Proxy.NO_PROXY).build();
   public static int Ⱥ;

   public static oc3a1b603dda b(String var0) throws Exception {
      JsonObject var1 = ш("https://localts.store/v1/me", var0);
      return new oc3a1b603dda(С(var1, "username", ""), б(var1, "balance"));
   }

   public static boolean ɩ(String param0, String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc2c3b75cd91.F I
      // 003: istore 2
      // 004: aload 0
      // 005: iload 2
      // 006: ifne 017
      // 009: ifnonnull 016
      // 00c: goto 010
      // 00f: athrow
      // 010: ldc ""
      // 012: goto 01a
      // 015: athrow
      // 016: aload 0
      // 017: invokevirtual java/lang/String.toLowerCase ()Ljava/lang/String;
      // 01a: astore 3
      // 01b: aload 1
      // 01c: iload 2
      // 01d: ifne 02e
      // 020: ifnonnull 02d
      // 023: goto 027
      // 026: athrow
      // 027: ldc ""
      // 029: goto 031
      // 02c: athrow
      // 02d: aload 1
      // 02e: invokevirtual java/lang/String.toLowerCase ()Ljava/lang/String;
      // 031: astore 4
      // 033: aload 3
      // 034: ldc "full access"
      // 036: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 039: iload 2
      // 03a: ifne 107
      // 03d: ifne 106
      // 040: goto 044
      // 043: athrow
      // 044: aload 3
      // 045: ldc "fullaccess"
      // 047: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 04a: iload 2
      // 04b: ifne 107
      // 04e: goto 052
      // 051: athrow
      // 052: ifne 106
      // 055: goto 059
      // 058: athrow
      // 059: aload 3
      // 05a: ldc "ip vanish"
      // 05c: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 05f: iload 2
      // 060: ifne 107
      // 063: goto 067
      // 066: athrow
      // 067: ifne 106
      // 06a: goto 06e
      // 06d: athrow
      // 06e: aload 3
      // 06f: ldc "ipvanish"
      // 071: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 074: iload 2
      // 075: ifne 107
      // 078: goto 07c
      // 07b: athrow
      // 07c: ifne 106
      // 07f: goto 083
      // 082: athrow
      // 083: aload 3
      // 084: ldc "skyblock coins"
      // 086: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 089: iload 2
      // 08a: ifne 107
      // 08d: goto 091
      // 090: athrow
      // 091: ifne 106
      // 094: goto 098
      // 097: athrow
      // 098: aload 4
      // 09a: ldc "full access"
      // 09c: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 09f: iload 2
      // 0a0: ifne 107
      // 0a3: goto 0a7
      // 0a6: athrow
      // 0a7: ifne 106
      // 0aa: goto 0ae
      // 0ad: athrow
      // 0ae: aload 4
      // 0b0: ldc "fullaccess"
      // 0b2: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 0b5: iload 2
      // 0b6: ifne 107
      // 0b9: goto 0bd
      // 0bc: athrow
      // 0bd: ifne 106
      // 0c0: goto 0c4
      // 0c3: athrow
      // 0c4: aload 4
      // 0c6: ldc "ip vanish"
      // 0c8: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 0cb: iload 2
      // 0cc: ifne 107
      // 0cf: goto 0d3
      // 0d2: athrow
      // 0d3: ifne 106
      // 0d6: goto 0da
      // 0d9: athrow
      // 0da: aload 4
      // 0dc: ldc "ipvanish"
      // 0de: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 0e1: iload 2
      // 0e2: ifne 107
      // 0e5: goto 0e9
      // 0e8: athrow
      // 0e9: ifne 106
      // 0ec: goto 0f0
      // 0ef: athrow
      // 0f0: aload 4
      // 0f2: ldc "skyblock coins"
      // 0f4: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 0f7: iload 2
      // 0f8: ifne 107
      // 0fb: goto 0ff
      // 0fe: athrow
      // 0ff: ifeq 10a
      // 102: goto 106
      // 105: athrow
      // 106: bipush 1
      // 107: goto 10b
      // 10a: bipush 0
      // 10b: ireturn
   }

   public static List<ocffb73a9392> Ĩ(JsonElement param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc2c3b75cd91.F I
      // 003: istore 1
      // 004: aload 0
      // 005: iload 1
      // 006: ifne 031
      // 009: ifnull 02c
      // 00c: goto 010
      // 00f: athrow
      // 010: aload 0
      // 011: iload 1
      // 012: ifne 031
      // 015: goto 019
      // 018: athrow
      // 019: invokevirtual com/google/gson/JsonElement.isJsonArray ()Z
      // 01c: ifeq 02c
      // 01f: goto 023
      // 022: athrow
      // 023: aload 0
      // 024: invokevirtual com/google/gson/JsonElement.getAsJsonArray ()Lcom/google/gson/JsonArray;
      // 027: astore 2
      // 028: iload 1
      // 029: ifeq 098
      // 02c: aload 0
      // 02d: goto 031
      // 030: athrow
      // 031: iload 1
      // 032: ifne 03d
      // 035: ifnull 090
      // 038: goto 03c
      // 03b: athrow
      // 03c: aload 0
      // 03d: iload 1
      // 03e: ifne 050
      // 041: invokevirtual com/google/gson/JsonElement.isJsonObject ()Z
      // 044: ifeq 090
      // 047: goto 04b
      // 04a: athrow
      // 04b: aload 0
      // 04c: goto 050
      // 04f: athrow
      // 050: invokevirtual com/google/gson/JsonElement.getAsJsonObject ()Lcom/google/gson/JsonObject;
      // 053: iload 1
      // 054: ifne 078
      // 057: ldc "products"
      // 059: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 05c: ifeq 090
      // 05f: goto 063
      // 062: athrow
      // 063: aload 0
      // 064: invokevirtual com/google/gson/JsonElement.getAsJsonObject ()Lcom/google/gson/JsonObject;
      // 067: iload 1
      // 068: ifne 086
      // 06b: goto 06f
      // 06e: athrow
      // 06f: ldc "products"
      // 071: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 074: goto 078
      // 077: athrow
      // 078: invokevirtual com/google/gson/JsonElement.isJsonArray ()Z
      // 07b: ifeq 090
      // 07e: aload 0
      // 07f: invokevirtual com/google/gson/JsonElement.getAsJsonObject ()Lcom/google/gson/JsonObject;
      // 082: goto 086
      // 085: athrow
      // 086: ldc "products"
      // 088: invokevirtual com/google/gson/JsonObject.getAsJsonArray (Ljava/lang/String;)Lcom/google/gson/JsonArray;
      // 08b: astore 2
      // 08c: iload 1
      // 08d: ifeq 098
      // 090: new com/google/gson/JsonArray
      // 093: dup
      // 094: invokespecial com/google/gson/JsonArray.<init> ()V
      // 097: astore 2
      // 098: new java/util/ArrayList
      // 09b: dup
      // 09c: invokespecial java/util/ArrayList.<init> ()V
      // 09f: astore 3
      // 0a0: aload 2
      // 0a1: invokevirtual com/google/gson/JsonArray.iterator ()Ljava/util/Iterator;
      // 0a4: astore 4
      // 0a6: aload 4
      // 0a8: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0ad: ifeq 24d
      // 0b0: aload 4
      // 0b2: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0b7: checkcast com/google/gson/JsonElement
      // 0ba: astore 5
      // 0bc: aload 5
      // 0be: iload 1
      // 0bf: ifne 0d2
      // 0c2: invokevirtual com/google/gson/JsonElement.isJsonObject ()Z
      // 0c5: ifne 0d0
      // 0c8: iload 1
      // 0c9: ifeq 0a6
      // 0cc: goto 0d0
      // 0cf: athrow
      // 0d0: aload 5
      // 0d2: invokevirtual com/google/gson/JsonElement.getAsJsonObject ()Lcom/google/gson/JsonObject;
      // 0d5: astore 6
      // 0d7: aload 6
      // 0d9: ldc "name"
      // 0db: ldc ""
      // 0dd: invokestatic x/oc18ad0bed09.С (Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 0e0: astore 7
      // 0e2: aload 6
      // 0e4: ldc "category"
      // 0e6: ldc ""
      // 0e8: invokestatic x/oc18ad0bed09.С (Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 0eb: astore 8
      // 0ed: aload 7
      // 0ef: aload 8
      // 0f1: invokestatic x/oc18ad0bed09.ɩ (Ljava/lang/String;Ljava/lang/String;)Z
      // 0f4: ifeq 0ff
      // 0f7: iload 1
      // 0f8: ifeq 0a6
      // 0fb: goto 0ff
      // 0fe: athrow
      // 0ff: new java/util/ArrayList
      // 102: dup
      // 103: invokespecial java/util/ArrayList.<init> ()V
      // 106: astore 9
      // 108: aload 6
      // 10a: ldc "tags"
      // 10c: iload 1
      // 10d: ifne 12a
      // 110: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 113: ifeq 16e
      // 116: goto 11a
      // 119: athrow
      // 11a: aload 6
      // 11c: iload 1
      // 11d: ifne 139
      // 120: goto 124
      // 123: athrow
      // 124: ldc "tags"
      // 126: goto 12a
      // 129: athrow
      // 12a: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 12d: invokevirtual com/google/gson/JsonElement.isJsonArray ()Z
      // 130: ifeq 16e
      // 133: aload 6
      // 135: goto 139
      // 138: athrow
      // 139: ldc "tags"
      // 13b: invokevirtual com/google/gson/JsonObject.getAsJsonArray (Ljava/lang/String;)Lcom/google/gson/JsonArray;
      // 13e: invokevirtual com/google/gson/JsonArray.iterator ()Ljava/util/Iterator;
      // 141: astore 10
      // 143: aload 10
      // 145: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 14a: ifeq 16e
      // 14d: aload 10
      // 14f: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 154: checkcast com/google/gson/JsonElement
      // 157: astore 11
      // 159: iload 1
      // 15a: ifne 0a6
      // 15d: aload 9
      // 15f: aload 11
      // 161: invokevirtual com/google/gson/JsonElement.getAsString ()Ljava/lang/String;
      // 164: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 169: pop
      // 16a: iload 1
      // 16b: ifeq 143
      // 16e: new java/util/TreeMap
      // 171: dup
      // 172: invokespecial java/util/TreeMap.<init> ()V
      // 175: astore 10
      // 177: iload 1
      // 178: ifne 249
      // 17b: aload 6
      // 17d: ldc "quantityDiscounts"
      // 17f: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 182: ifeq 201
      // 185: goto 189
      // 188: athrow
      // 189: aload 6
      // 18b: ldc "quantityDiscounts"
      // 18d: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 190: invokevirtual com/google/gson/JsonElement.isJsonObject ()Z
      // 193: iload 1
      // 194: ifne 248
      // 197: goto 19b
      // 19a: athrow
      // 19b: ifeq 201
      // 19e: goto 1a2
      // 1a1: athrow
      // 1a2: aload 6
      // 1a4: ldc "quantityDiscounts"
      // 1a6: invokevirtual com/google/gson/JsonObject.getAsJsonObject (Ljava/lang/String;)Lcom/google/gson/JsonObject;
      // 1a9: invokevirtual com/google/gson/JsonObject.entrySet ()Ljava/util/Set;
      // 1ac: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 1b1: astore 11
      // 1b3: aload 11
      // 1b5: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 1ba: ifeq 201
      // 1bd: aload 11
      // 1bf: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 1c4: checkcast java/util/Map$Entry
      // 1c7: astore 12
      // 1c9: aload 10
      // 1cb: aload 12
      // 1cd: invokeinterface java/util/Map$Entry.getKey ()Ljava/lang/Object; 1
      // 1d2: checkcast java/lang/String
      // 1d5: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 1d8: invokestatic java/lang/Integer.parseInt (Ljava/lang/String;)I
      // 1db: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 1de: aload 12
      // 1e0: invokeinterface java/util/Map$Entry.getValue ()Ljava/lang/Object; 1
      // 1e5: checkcast com/google/gson/JsonElement
      // 1e8: invokevirtual com/google/gson/JsonElement.getAsDouble ()D
      // 1eb: invokestatic java/lang/Double.valueOf (D)Ljava/lang/Double;
      // 1ee: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 1f3: iload 1
      // 1f4: ifne 0b7
      // 1f7: pop
      // 1f8: goto 1fd
      // 1fb: astore 13
      // 1fd: iload 1
      // 1fe: ifeq 1b3
      // 201: aload 3
      // 202: new x/ocffb73a9392
      // 205: dup
      // 206: aload 6
      // 208: ldc "id"
      // 20a: ldc ""
      // 20c: invokestatic x/oc18ad0bed09.С (Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 20f: aload 7
      // 211: aload 6
      // 213: ldc "description"
      // 215: ldc ""
      // 217: invokestatic x/oc18ad0bed09.С (Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 21a: aload 8
      // 21c: aload 6
      // 21e: ldc "priceInCredits"
      // 220: invokestatic x/oc18ad0bed09.б (Lcom/google/gson/JsonObject;Ljava/lang/String;)D
      // 223: aload 6
      // 225: ldc "stock"
      // 227: invokestatic x/oc18ad0bed09.Ȑ (Lcom/google/gson/JsonObject;Ljava/lang/String;)I
      // 22a: aload 6
      // 22c: ldc "type"
      // 22e: ldc ""
      // 230: invokestatic x/oc18ad0bed09.С (Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 233: aload 6
      // 235: ldc "logoUrl"
      // 237: ldc ""
      // 239: invokestatic x/oc18ad0bed09.С (Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 23c: aload 9
      // 23e: aload 10
      // 240: invokespecial x/ocffb73a9392.<init> (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;)V
      // 243: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 248: pop
      // 249: iload 1
      // 24a: ifeq 0a6
      // 24d: aload 3
      // 24e: areturn
   }

   public static List<ocffb73a9392> G(String var0) throws Exception {
      return Ĩ(ѡ("https://localts.store/v1/products", var0));
   }

   public static oc073c133a28 ɒ(String param0, String param1, int param2) throws Exception {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc2c3b75cd91.F I
      // 03: ldc_w "https://localts.store/v1"
      // 06: invokestatic okhttp3/HttpUrl.get (Ljava/lang/String;)Lokhttp3/HttpUrl;
      // 09: invokevirtual okhttp3/HttpUrl.newBuilder ()Lokhttp3/HttpUrl$Builder;
      // 0c: ldc "products"
      // 0e: invokevirtual okhttp3/HttpUrl$Builder.addPathSegment (Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;
      // 11: aload 1
      // 12: invokevirtual okhttp3/HttpUrl$Builder.addPathSegment (Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;
      // 15: ldc_w "purchase"
      // 18: invokevirtual okhttp3/HttpUrl$Builder.addPathSegment (Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;
      // 1b: ldc_w "amount"
      // 1e: iload 2
      // 1f: invokestatic java/lang/Integer.toString (I)Ljava/lang/String;
      // 22: invokevirtual okhttp3/HttpUrl$Builder.addQueryParameter (Ljava/lang/String;Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;
      // 25: invokevirtual okhttp3/HttpUrl$Builder.build ()Lokhttp3/HttpUrl;
      // 28: astore 4
      // 2a: aload 4
      // 2c: invokevirtual okhttp3/HttpUrl.toString ()Ljava/lang/String;
      // 2f: aload 0
      // 30: invokestatic x/oc18ad0bed09.Ӌ (Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;
      // 33: getstatic x/oc18ad0bed09.Ώ Lokhttp3/RequestBody;
      // 36: invokevirtual okhttp3/Request$Builder.post (Lokhttp3/RequestBody;)Lokhttp3/Request$Builder;
      // 39: invokevirtual okhttp3/Request$Builder.build ()Lokhttp3/Request;
      // 3c: astore 5
      // 3e: aload 5
      // 40: invokestatic x/oc18ad0bed09.ӝ (Lokhttp3/Request;)Lcom/google/gson/JsonObject;
      // 43: astore 6
      // 45: aload 6
      // 47: ldc_w "orderId"
      // 4a: aload 6
      // 4c: ldc_w "order-id"
      // 4f: aconst_null
      // 50: invokestatic x/oc18ad0bed09.С (Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 53: invokestatic x/oc18ad0bed09.С (Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 56: astore 7
      // 58: aload 6
      // 5a: ldc_w "success"
      // 5d: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 60: astore 8
      // 62: istore 3
      // 63: aload 8
      // 65: iload 3
      // 66: ifne 72
      // 69: ifnull 80
      // 6c: goto 70
      // 6f: athrow
      // 70: aload 8
      // 72: iload 3
      // 73: ifne ac
      // 76: invokevirtual com/google/gson/JsonElement.isJsonNull ()Z
      // 79: ifeq aa
      // 7c: goto 80
      // 7f: athrow
      // 80: aload 7
      // 82: iload 3
      // 83: ifne 93
      // 86: goto 8a
      // 89: athrow
      // 8a: ifnull a6
      // 8d: goto 91
      // 90: athrow
      // 91: aload 7
      // 93: invokevirtual java/lang/String.isBlank ()Z
      // 96: iload 3
      // 97: ifne a7
      // 9a: ifne a6
      // 9d: goto a1
      // a0: athrow
      // a1: bipush 1
      // a2: goto af
      // a5: athrow
      // a6: bipush 0
      // a7: goto af
      // aa: aload 8
      // ac: invokevirtual com/google/gson/JsonElement.getAsBoolean ()Z
      // af: istore 9
      // b1: aload 6
      // b3: ldc_w "error"
      // b6: aconst_null
      // b7: invokestatic x/oc18ad0bed09.С (Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // ba: astore 10
      // bc: new x/oc073c133a28
      // bf: dup
      // c0: iload 9
      // c2: aload 7
      // c4: aload 10
      // c6: invokespecial x/oc073c133a28.<init> (ZLjava/lang/String;Ljava/lang/String;)V
      // c9: iload 3
      // ca: ifeq de
      // cd: bipush 0
      // ce: ifeq da
      // d1: goto d5
      // d4: athrow
      // d5: bipush 0
      // d6: goto db
      // d9: athrow
      // da: bipush 1
      // db: putstatic x/oc69da1aa7f5.Ҭ Z
      // de: areturn
   }

   public static ocf62fc2ab2d Ԛ(String param0, int param1, int param2) throws Exception {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc2c3b75cd91.F I
      // 003: iload 1
      // 004: iload 2
      // 005: ldc_w "https://localts.store/v1/orders?page="
      // 008: dup_x2
      // 009: pop
      // 00a: ldc_w "&size="
      // 00d: swap
      // 00e: invokedynamic makeConcatWithConstants (Ljava/lang/String;ILjava/lang/String;I)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001\u0001" ]
      // 013: astore 4
      // 015: istore 3
      // 016: aload 4
      // 018: aload 0
      // 019: invokestatic x/oc18ad0bed09.ш (Ljava/lang/String;Ljava/lang/String;)Lcom/google/gson/JsonObject;
      // 01c: astore 5
      // 01e: aload 5
      // 020: ldc_w "orders"
      // 023: iload 3
      // 024: ifne 042
      // 027: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 02a: ifeq 05a
      // 02d: goto 031
      // 030: athrow
      // 031: aload 5
      // 033: iload 3
      // 034: ifne 051
      // 037: goto 03b
      // 03a: athrow
      // 03b: ldc_w "orders"
      // 03e: goto 042
      // 041: athrow
      // 042: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 045: invokevirtual com/google/gson/JsonElement.isJsonArray ()Z
      // 048: ifeq 05a
      // 04b: aload 5
      // 04d: goto 051
      // 050: athrow
      // 051: ldc_w "orders"
      // 054: invokevirtual com/google/gson/JsonObject.getAsJsonArray (Ljava/lang/String;)Lcom/google/gson/JsonArray;
      // 057: goto 061
      // 05a: new com/google/gson/JsonArray
      // 05d: dup
      // 05e: invokespecial com/google/gson/JsonArray.<init> ()V
      // 061: astore 6
      // 063: new java/util/ArrayList
      // 066: dup
      // 067: invokespecial java/util/ArrayList.<init> ()V
      // 06a: astore 7
      // 06c: aload 6
      // 06e: invokevirtual com/google/gson/JsonArray.iterator ()Ljava/util/Iterator;
      // 071: astore 8
      // 073: aload 8
      // 075: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 07a: ifeq 0f0
      // 07d: aload 8
      // 07f: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 084: checkcast com/google/gson/JsonElement
      // 087: astore 9
      // 089: iload 3
      // 08a: aload 9
      // 08c: invokevirtual com/google/gson/JsonElement.getAsJsonObject ()Lcom/google/gson/JsonObject;
      // 08f: astore 10
      // 091: aload 10
      // 093: ldc "id"
      // 095: aload 10
      // 097: ldc_w "order-id"
      // 09a: ldc ""
      // 09c: invokestatic x/oc18ad0bed09.С (Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 09f: invokestatic x/oc18ad0bed09.С (Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 0a2: astore 11
      // 0a4: aload 10
      // 0a6: ldc_w "productId"
      // 0a9: aload 10
      // 0ab: ldc_w "product-id"
      // 0ae: ldc ""
      // 0b0: invokestatic x/oc18ad0bed09.С (Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 0b3: invokestatic x/oc18ad0bed09.С (Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 0b6: astore 12
      // 0b8: aload 10
      // 0ba: ldc_w "productType"
      // 0bd: aload 10
      // 0bf: ldc_w "product-type"
      // 0c2: ldc ""
      // 0c4: invokestatic x/oc18ad0bed09.С (Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 0c7: invokestatic x/oc18ad0bed09.С (Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 0ca: astore 13
      // 0cc: aload 10
      // 0ce: ldc_w "timestamp"
      // 0d1: invokestatic x/oc18ad0bed09.ő (Lcom/google/gson/JsonObject;Ljava/lang/String;)J
      // 0d4: lstore 14
      // 0d6: aload 7
      // 0d8: new x/occ796112162
      // 0db: dup
      // 0dc: aload 11
      // 0de: aload 12
      // 0e0: aload 13
      // 0e2: lload 14
      // 0e4: invokespecial x/occ796112162.<init> (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V
      // 0e7: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 0ec: pop
      // 0ed: ifeq 073
      // 0f0: new x/ocf62fc2ab2d
      // 0f3: dup
      // 0f4: aload 7
      // 0f6: aload 5
      // 0f8: ldc_w "page"
      // 0fb: invokestatic x/oc18ad0bed09.Ȑ (Lcom/google/gson/JsonObject;Ljava/lang/String;)I
      // 0fe: aload 5
      // 100: ldc_w "size"
      // 103: invokestatic x/oc18ad0bed09.Ȑ (Lcom/google/gson/JsonObject;Ljava/lang/String;)I
      // 106: aload 5
      // 108: ldc_w "totalPages"
      // 10b: invokestatic x/oc18ad0bed09.Ȑ (Lcom/google/gson/JsonObject;Ljava/lang/String;)I
      // 10e: aload 5
      // 110: ldc_w "totalElements"
      // 113: invokestatic x/oc18ad0bed09.Ȑ (Lcom/google/gson/JsonObject;Ljava/lang/String;)I
      // 116: invokespecial x/ocf62fc2ab2d.<init> (Ljava/util/List;IIII)V
      // 119: areturn
   }

   public static oc0a3967fcea ə(String param0, String param1) throws Exception {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc2c3b75cd91.F I
      // 003: ldc_w "https://localts.store/v1"
      // 006: invokestatic okhttp3/HttpUrl.get (Ljava/lang/String;)Lokhttp3/HttpUrl;
      // 009: invokevirtual okhttp3/HttpUrl.newBuilder ()Lokhttp3/HttpUrl$Builder;
      // 00c: ldc_w "orders"
      // 00f: invokevirtual okhttp3/HttpUrl$Builder.addPathSegment (Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;
      // 012: ldc_w "get-order"
      // 015: invokevirtual okhttp3/HttpUrl$Builder.addPathSegment (Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;
      // 018: ldc "id"
      // 01a: aload 1
      // 01b: invokevirtual okhttp3/HttpUrl$Builder.addQueryParameter (Ljava/lang/String;Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;
      // 01e: invokevirtual okhttp3/HttpUrl$Builder.build ()Lokhttp3/HttpUrl;
      // 021: astore 3
      // 022: aload 3
      // 023: invokevirtual okhttp3/HttpUrl.toString ()Ljava/lang/String;
      // 026: aload 0
      // 027: invokestatic x/oc18ad0bed09.ш (Ljava/lang/String;Ljava/lang/String;)Lcom/google/gson/JsonObject;
      // 02a: astore 4
      // 02c: aload 4
      // 02e: ldc_w "status"
      // 031: ldc ""
      // 033: invokestatic x/oc18ad0bed09.С (Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 036: astore 5
      // 038: istore 2
      // 039: aload 4
      // 03b: ldc_w "product-name"
      // 03e: aload 4
      // 040: ldc_w "productName"
      // 043: ldc ""
      // 045: invokestatic x/oc18ad0bed09.С (Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 048: invokestatic x/oc18ad0bed09.С (Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 04b: astore 6
      // 04d: aload 4
      // 04f: ldc_w "order-id"
      // 052: aload 4
      // 054: ldc_w "orderId"
      // 057: aload 1
      // 058: invokestatic x/oc18ad0bed09.С (Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 05b: invokestatic x/oc18ad0bed09.С (Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 05e: astore 7
      // 060: new java/util/ArrayList
      // 063: dup
      // 064: invokespecial java/util/ArrayList.<init> ()V
      // 067: astore 8
      // 069: aload 4
      // 06b: ldc_w "items"
      // 06e: iload 2
      // 06f: ifne 08d
      // 072: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 075: ifeq 0ea
      // 078: goto 07c
      // 07b: athrow
      // 07c: aload 4
      // 07e: iload 2
      // 07f: ifne 09c
      // 082: goto 086
      // 085: athrow
      // 086: ldc_w "items"
      // 089: goto 08d
      // 08c: athrow
      // 08d: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 090: invokevirtual com/google/gson/JsonElement.isJsonArray ()Z
      // 093: ifeq 0ea
      // 096: aload 4
      // 098: goto 09c
      // 09b: athrow
      // 09c: ldc_w "items"
      // 09f: invokevirtual com/google/gson/JsonObject.getAsJsonArray (Ljava/lang/String;)Lcom/google/gson/JsonArray;
      // 0a2: invokevirtual com/google/gson/JsonArray.iterator ()Ljava/util/Iterator;
      // 0a5: astore 9
      // 0a7: aload 9
      // 0a9: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0ae: ifeq 0ea
      // 0b1: aload 9
      // 0b3: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0b8: checkcast com/google/gson/JsonElement
      // 0bb: astore 10
      // 0bd: iload 2
      // 0be: aload 10
      // 0c0: invokevirtual com/google/gson/JsonElement.getAsJsonObject ()Lcom/google/gson/JsonObject;
      // 0c3: astore 11
      // 0c5: aload 8
      // 0c7: new x/oc2c3b75cd91
      // 0ca: dup
      // 0cb: aload 11
      // 0cd: ldc "id"
      // 0cf: ldc ""
      // 0d1: invokestatic x/oc18ad0bed09.С (Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 0d4: aload 11
      // 0d6: ldc_w "content"
      // 0d9: ldc ""
      // 0db: invokestatic x/oc18ad0bed09.С (Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 0de: invokespecial x/oc2c3b75cd91.<init> (Ljava/lang/String;Ljava/lang/String;)V
      // 0e1: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 0e6: pop
      // 0e7: ifeq 0a7
      // 0ea: new x/oc0a3967fcea
      // 0ed: dup
      // 0ee: aload 7
      // 0f0: aload 5
      // 0f2: aload 6
      // 0f4: aload 8
      // 0f6: invokespecial x/oc0a3967fcea.<init> (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V
      // 0f9: bipush 0
      // 0fa: ifeq 108
      // 0fd: iinc 2 1
      // 100: iload 2
      // 101: putstatic x/oc2c3b75cd91.F I
      // 104: goto 108
      // 107: athrow
      // 108: areturn
   }

   private static String С(JsonObject param0, String param1, String param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc2c3b75cd91.F I
      // 03: aload 0
      // 04: aload 1
      // 05: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 08: astore 4
      // 0a: istore 3
      // 0b: aload 4
      // 0d: iload 3
      // 0e: ifne 1a
      // 11: ifnull 28
      // 14: goto 18
      // 17: athrow
      // 18: aload 4
      // 1a: iload 3
      // 1b: ifne 2f
      // 1e: invokevirtual com/google/gson/JsonElement.isJsonNull ()Z
      // 21: ifeq 2d
      // 24: goto 28
      // 27: athrow
      // 28: aload 2
      // 29: goto 32
      // 2c: athrow
      // 2d: aload 4
      // 2f: invokevirtual com/google/gson/JsonElement.getAsString ()Ljava/lang/String;
      // 32: areturn
   }

   private static double б(JsonObject param0, String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc2c3b75cd91.F I
      // 03: aload 0
      // 04: aload 1
      // 05: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 08: astore 3
      // 09: istore 2
      // 0a: aload 3
      // 0b: iload 2
      // 0c: ifne 17
      // 0f: ifnull 25
      // 12: goto 16
      // 15: athrow
      // 16: aload 3
      // 17: iload 2
      // 18: ifne 2b
      // 1b: invokevirtual com/google/gson/JsonElement.isJsonNull ()Z
      // 1e: ifeq 2a
      // 21: goto 25
      // 24: athrow
      // 25: dconst_0
      // 26: goto 2e
      // 29: athrow
      // 2a: aload 3
      // 2b: invokevirtual com/google/gson/JsonElement.getAsDouble ()D
      // 2e: dreturn
   }

   private static int Ȑ(JsonObject param0, String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc2c3b75cd91.F I
      // 03: aload 0
      // 04: aload 1
      // 05: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 08: astore 3
      // 09: istore 2
      // 0a: aload 3
      // 0b: iload 2
      // 0c: ifne 17
      // 0f: ifnull 25
      // 12: goto 16
      // 15: athrow
      // 16: aload 3
      // 17: iload 2
      // 18: ifne 2b
      // 1b: invokevirtual com/google/gson/JsonElement.isJsonNull ()Z
      // 1e: ifeq 2a
      // 21: goto 25
      // 24: athrow
      // 25: bipush 0
      // 26: goto 2e
      // 29: athrow
      // 2a: aload 3
      // 2b: invokevirtual com/google/gson/JsonElement.getAsInt ()I
      // 2e: ireturn
   }

   private static long ő(JsonObject param0, String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc2c3b75cd91.F I
      // 03: aload 0
      // 04: aload 1
      // 05: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 08: astore 3
      // 09: istore 2
      // 0a: aload 3
      // 0b: iload 2
      // 0c: ifne 17
      // 0f: ifnull 25
      // 12: goto 16
      // 15: athrow
      // 16: aload 3
      // 17: iload 2
      // 18: ifne 2b
      // 1b: invokevirtual com/google/gson/JsonElement.isJsonNull ()Z
      // 1e: ifeq 2a
      // 21: goto 25
      // 24: athrow
      // 25: lconst_0
      // 26: goto 2e
      // 29: athrow
      // 2a: aload 3
      // 2b: invokevirtual com/google/gson/JsonElement.getAsLong ()J
      // 2e: lreturn
   }

   static JsonObject ш(String var0, String var1) throws Exception {
      return ӝ(Ӌ(var0, var1).get().build());
   }

   private static JsonElement ѡ(String var0, String var1) throws Exception {
      return ɐ(Ӌ(var0, var1).get().build());
   }

   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static Builder Ӌ(String var0, String var1) throws IOException {
      int var2 = oc2c3b75cd91.F;

      label30: {
         String var10000;
         label29: {
            try {
               var10000 = var1;
               if (var2 != 0) {
                  break label29;
               }

               if (var1 == null) {
                  break label30;
               }
            } catch (IOException var5) {
               throw var5;
            }

            var10000 = var1;
         }

         try {
            if (!var10000.isBlank()) {
               return new Builder().url(var0).header("X-API-Key", var1);
            }
         } catch (IOException var4) {
            throw var4;
         }
      }

      try {
         throw new IOException("No API key set");
      } catch (IOException var3) {
         throw var3;
      }
   }

   private static JsonObject ӝ(Request param0) throws Exception {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc2c3b75cd91.F I
      // 03: aload 0
      // 04: invokestatic x/oc18ad0bed09.ɐ (Lokhttp3/Request;)Lcom/google/gson/JsonElement;
      // 07: astore 2
      // 08: istore 1
      // 09: aload 2
      // 0a: iload 1
      // 0b: ifne 25
      // 0e: invokevirtual com/google/gson/JsonElement.isJsonObject ()Z
      // 11: ifne 24
      // 14: goto 18
      // 17: athrow
      // 18: new java/io/IOException
      // 1b: dup
      // 1c: ldc_w "Unexpected response format (expected JSON object)"
      // 1f: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 22: athrow
      // 23: athrow
      // 24: aload 2
      // 25: invokevirtual com/google/gson/JsonElement.getAsJsonObject ()Lcom/google/gson/JsonObject;
      // 28: areturn
   }

   static JsonElement ɐ(Request param0) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc2c3b75cd91.F I
      // 003: aload 0
      // 004: invokestatic x/oc18ad0bed09.Ӫ (Lokhttp3/Request;)Lokhttp3/Response;
      // 007: astore 2
      // 008: istore 1
      // 009: aload 2
      // 00a: invokevirtual okhttp3/Response.code ()I
      // 00d: istore 3
      // 00e: aload 2
      // 00f: iload 1
      // 010: ifne 024
      // 013: invokevirtual okhttp3/Response.body ()Lokhttp3/ResponseBody;
      // 016: ifnonnull 023
      // 019: goto 01d
      // 01c: athrow
      // 01d: ldc ""
      // 01f: goto 02d
      // 022: athrow
      // 023: aload 2
      // 024: invokevirtual okhttp3/Response.body ()Lokhttp3/ResponseBody;
      // 027: invokevirtual okhttp3/ResponseBody.string ()Ljava/lang/String;
      // 02a: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 02d: astore 4
      // 02f: iload 3
      // 030: iload 1
      // 031: ifne 053
      // 034: ldc_w 946155282
      // 037: ldc_w 946155139
      // 03a: ixor
      // 03b: if_icmpne 04e
      // 03e: goto 042
      // 041: athrow
      // 042: new java/io/IOException
      // 045: dup
      // 046: ldc_w "Invalid or missing API key"
      // 049: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 04c: athrow
      // 04d: athrow
      // 04e: aload 4
      // 050: invokevirtual java/lang/String.isEmpty ()Z
      // 053: iload 1
      // 054: ifne 08f
      // 057: ifeq 089
      // 05a: goto 05e
      // 05d: athrow
      // 05e: new java/io/IOException
      // 061: dup
      // 062: iload 3
      // 063: ldc_w 946155283
      // 066: ldc_w 946155139
      // 069: ixor
      // 06a: if_icmplt 082
      // 06d: goto 071
      // 070: athrow
      // 071: iload 3
      // 072: ldc_w "HTTP "
      // 075: swap
      // 076: ldc_w " (no response body)"
      // 079: invokedynamic makeConcatWithConstants (Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001" ]
      // 07e: goto 085
      // 081: athrow
      // 082: ldc_w "Empty response from server"
      // 085: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 088: athrow
      // 089: aload 2
      // 08a: aload 4
      // 08c: invokestatic x/oc18ad0bed09.Ĉ (Lokhttp3/Response;Ljava/lang/String;)Z
      // 08f: iload 1
      // 090: ifne 09b
      // 093: ifeq 0db
      // 096: goto 09a
      // 099: athrow
      // 09a: iload 3
      // 09b: ldc_w 946155280
      // 09e: ldc_w 946155139
      // 0a1: ixor
      // 0a2: if_icmpne 0b4
      // 0a5: new java/io/IOException
      // 0a8: dup
      // 0a9: aload 2
      // 0aa: aload 4
      // 0ac: invokestatic x/oc18ad0bed09.Ǘ (Lokhttp3/Response;Ljava/lang/String;)Ljava/lang/String;
      // 0af: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 0b2: athrow
      // 0b3: athrow
      // 0b4: new java/io/IOException
      // 0b7: dup
      // 0b8: iload 3
      // 0b9: ldc_w 946155283
      // 0bc: ldc_w 946155139
      // 0bf: ixor
      // 0c0: if_icmplt 0d4
      // 0c3: iload 3
      // 0c4: ldc_w "HTTP "
      // 0c7: swap
      // 0c8: ldc_w " error"
      // 0cb: invokedynamic makeConcatWithConstants (Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001" ]
      // 0d0: goto 0d7
      // 0d3: athrow
      // 0d4: ldc_w "Received HTML instead of JSON (possible Cloudflare challenge)"
      // 0d7: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 0da: athrow
      // 0db: new com/google/gson/JsonParser
      // 0de: dup
      // 0df: invokespecial com/google/gson/JsonParser.<init> ()V
      // 0e2: aload 4
      // 0e4: invokevirtual com/google/gson/JsonParser.parse (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 0e7: astore 5
      // 0e9: goto 117
      // 0ec: astore 6
      // 0ee: new java/io/IOException
      // 0f1: dup
      // 0f2: iload 3
      // 0f3: ldc_w 946155283
      // 0f6: ldc_w 946155139
      // 0f9: ixor
      // 0fa: if_icmplt 10e
      // 0fd: iload 3
      // 0fe: ldc_w "HTTP "
      // 101: swap
      // 102: ldc_w " (invalid JSON response)"
      // 105: invokedynamic makeConcatWithConstants (Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001" ]
      // 10a: goto 111
      // 10d: athrow
      // 10e: ldc_w "Invalid JSON response from server"
      // 111: aload 6
      // 113: invokespecial java/io/IOException.<init> (Ljava/lang/String;Ljava/lang/Throwable;)V
      // 116: athrow
      // 117: aload 5
      // 119: iload 1
      // 11a: ifne 126
      // 11d: ifnull 134
      // 120: goto 124
      // 123: athrow
      // 124: aload 5
      // 126: iload 1
      // 127: ifne 15e
      // 12a: invokevirtual com/google/gson/JsonElement.isJsonNull ()Z
      // 12d: ifeq 15c
      // 130: goto 134
      // 133: athrow
      // 134: new java/io/IOException
      // 137: dup
      // 138: iload 3
      // 139: ldc_w 946155283
      // 13c: ldc_w 946155139
      // 13f: ixor
      // 140: if_icmplt 155
      // 143: goto 147
      // 146: athrow
      // 147: iload 3
      // 148: ldc_w "HTTP "
      // 14b: swap
      // 14c: invokedynamic makeConcatWithConstants (Ljava/lang/String;I)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 151: goto 158
      // 154: athrow
      // 155: ldc_w "Empty response from server"
      // 158: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 15b: athrow
      // 15c: aload 5
      // 15e: invokevirtual com/google/gson/JsonElement.isJsonObject ()Z
      // 161: iload 1
      // 162: ifne 1f7
      // 165: ifeq 1f2
      // 168: goto 16c
      // 16b: athrow
      // 16c: aload 5
      // 16e: invokevirtual com/google/gson/JsonElement.getAsJsonObject ()Lcom/google/gson/JsonObject;
      // 171: astore 6
      // 173: aload 6
      // 175: ldc_w "success"
      // 178: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 17b: iload 1
      // 17c: ifne 1cc
      // 17f: ifeq 1cb
      // 182: goto 186
      // 185: athrow
      // 186: aload 6
      // 188: ldc_w "success"
      // 18b: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 18e: invokevirtual com/google/gson/JsonElement.isJsonNull ()Z
      // 191: iload 1
      // 192: ifne 1cc
      // 195: goto 199
      // 198: athrow
      // 199: ifne 1cb
      // 19c: goto 1a0
      // 19f: athrow
      // 1a0: aload 6
      // 1a2: ldc_w "success"
      // 1a5: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 1a8: invokevirtual com/google/gson/JsonElement.getAsBoolean ()Z
      // 1ab: iload 1
      // 1ac: ifne 1cc
      // 1af: goto 1b3
      // 1b2: athrow
      // 1b3: ifne 1cb
      // 1b6: goto 1ba
      // 1b9: athrow
      // 1ba: new java/io/IOException
      // 1bd: dup
      // 1be: aload 6
      // 1c0: ldc_w "Request failed"
      // 1c3: invokestatic x/oc18ad0bed09.ջ (Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/String;
      // 1c6: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 1c9: athrow
      // 1ca: athrow
      // 1cb: iload 3
      // 1cc: ldc_w 946155283
      // 1cf: ldc_w 946155139
      // 1d2: ixor
      // 1d3: if_icmplt 1ee
      // 1d6: new java/io/IOException
      // 1d9: dup
      // 1da: aload 6
      // 1dc: iload 3
      // 1dd: ldc_w "HTTP "
      // 1e0: swap
      // 1e1: invokedynamic makeConcatWithConstants (Ljava/lang/String;I)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 1e6: invokestatic x/oc18ad0bed09.ջ (Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/String;
      // 1e9: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 1ec: athrow
      // 1ed: athrow
      // 1ee: iload 1
      // 1ef: ifeq 214
      // 1f2: iload 3
      // 1f3: goto 1f7
      // 1f6: athrow
      // 1f7: ldc_w 946155283
      // 1fa: ldc_w 946155139
      // 1fd: ixor
      // 1fe: if_icmplt 214
      // 201: new java/io/IOException
      // 204: dup
      // 205: iload 3
      // 206: ldc_w "HTTP "
      // 209: swap
      // 20a: invokedynamic makeConcatWithConstants (Ljava/lang/String;I)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 20f: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 212: athrow
      // 213: athrow
      // 214: aload 5
      // 216: astore 6
      // 218: aload 2
      // 219: iload 1
      // 21a: ifne 225
      // 21d: ifnull 228
      // 220: goto 224
      // 223: athrow
      // 224: aload 2
      // 225: invokevirtual okhttp3/Response.close ()V
      // 228: aload 6
      // 22a: areturn
      // 22b: astore 3
      // 22c: iload 1
      // 22d: ifne 23c
      // 230: aload 2
      // 231: ifnull 247
      // 234: goto 238
      // 237: athrow
      // 238: aload 2
      // 239: invokevirtual okhttp3/Response.close ()V
      // 23c: goto 247
      // 23f: astore 4
      // 241: aload 3
      // 242: aload 4
      // 244: invokevirtual java/lang/Throwable.addSuppressed (Ljava/lang/Throwable;)V
      // 247: aload 3
      // 248: athrow
   }

   private static boolean Ĉ(Response param0, String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc2c3b75cd91.F I
      // 03: aload 0
      // 04: ldc_w "Content-Type"
      // 07: ldc ""
      // 09: invokevirtual okhttp3/Response.header (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 0c: astore 3
      // 0d: istore 2
      // 0e: aload 3
      // 0f: getstatic java/util/Locale.ROOT Ljava/util/Locale;
      // 12: invokevirtual java/lang/String.toLowerCase (Ljava/util/Locale;)Ljava/lang/String;
      // 15: ldc_w "text/html"
      // 18: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 1b: iload 2
      // 1c: ifne 3d
      // 1f: ifne 3c
      // 22: goto 26
      // 25: athrow
      // 26: aload 1
      // 27: ldc_w "<"
      // 2a: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 2d: iload 2
      // 2e: ifne 3d
      // 31: goto 35
      // 34: athrow
      // 35: ifeq 40
      // 38: goto 3c
      // 3b: athrow
      // 3c: bipush 1
      // 3d: goto 41
      // 40: bipush 0
      // 41: ireturn
   }

   private static String Ǘ(Response param0, String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc2c3b75cd91.F I
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 28
      // 09: getstatic java/util/Locale.ROOT Ljava/util/Locale;
      // 0c: invokevirtual java/lang/String.toLowerCase (Ljava/util/Locale;)Ljava/lang/String;
      // 0f: ldc_w "cloudflare"
      // 12: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 15: ifne 21
      // 18: goto 1c
      // 1b: athrow
      // 1c: ldc_w "HTTP 403: Server returned HTML instead of JSON"
      // 1f: areturn
      // 20: athrow
      // 21: aload 0
      // 22: ldc_w "CF-RAY"
      // 25: invokevirtual okhttp3/Response.header (Ljava/lang/String;)Ljava/lang/String;
      // 28: astore 3
      // 29: aload 3
      // 2a: iload 2
      // 2b: ifne 4e
      // 2e: ifnull 48
      // 31: goto 35
      // 34: athrow
      // 35: aload 3
      // 36: iload 2
      // 37: ifne 52
      // 3a: goto 3e
      // 3d: athrow
      // 3e: invokevirtual java/lang/String.isBlank ()Z
      // 41: ifeq 51
      // 44: goto 48
      // 47: athrow
      // 48: ldc ""
      // 4a: goto 4e
      // 4d: athrow
      // 4e: goto 5b
      // 51: aload 3
      // 52: ldc_w ", Ray ID "
      // 55: swap
      // 56: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 5b: ldc_w "Cloudflare blocked the LocalTS request (HTTP 403"
      // 5e: swap
      // 5f: ldc_w ")"
      // 62: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001" ]
      // 67: areturn
   }

   private static String ջ(JsonObject param0, String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: ldc_w 31208008
      // 03: ldc_w 31208010
      // 06: ixor
      // 07: anewarray 92
      // 0a: dup
      // 0b: bipush 0
      // 0c: ldc_w "error"
      // 0f: aastore
      // 10: dup
      // 11: bipush 1
      // 12: ldc_w "message"
      // 15: aastore
      // 16: astore 3
      // 17: getstatic x/oc2c3b75cd91.F I
      // 1a: aload 3
      // 1b: arraylength
      // 1c: istore 4
      // 1e: istore 2
      // 1f: bipush 0
      // 20: istore 5
      // 22: iload 5
      // 24: iload 4
      // 26: if_icmpge 82
      // 29: aload 3
      // 2a: iload 5
      // 2c: aaload
      // 2d: iload 2
      // 2e: ifne 83
      // 31: astore 6
      // 33: iload 2
      // 34: aload 0
      // 35: aload 6
      // 37: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 3a: astore 7
      // 3c: ifne 7e
      // 3f: aload 7
      // 41: ifnull 7b
      // 44: goto 48
      // 47: athrow
      // 48: aload 7
      // 4a: iload 2
      // 4b: ifne 62
      // 4e: goto 52
      // 51: athrow
      // 52: invokevirtual com/google/gson/JsonElement.isJsonPrimitive ()Z
      // 55: ifeq 7b
      // 58: goto 5c
      // 5b: athrow
      // 5c: aload 7
      // 5e: goto 62
      // 61: athrow
      // 62: invokevirtual com/google/gson/JsonElement.getAsString ()Ljava/lang/String;
      // 65: astore 8
      // 67: iload 2
      // 68: ifne 7e
      // 6b: aload 8
      // 6d: invokevirtual java/lang/String.isBlank ()Z
      // 70: ifne 7b
      // 73: goto 77
      // 76: athrow
      // 77: aload 8
      // 79: areturn
      // 7a: athrow
      // 7b: iinc 5 1
      // 7e: iload 2
      // 7f: ifeq 22
      // 82: aload 1
      // 83: areturn
   }

   private static Response Ӫ(Request param0) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc2c3b75cd91.F I
      // 03: istore 1
      // 04: getstatic x/oc18ad0bed09.ʇ Lokhttp3/OkHttpClient;
      // 07: aload 0
      // 08: invokevirtual okhttp3/OkHttpClient.newCall (Lokhttp3/Request;)Lokhttp3/Call;
      // 0b: invokeinterface okhttp3/Call.execute ()Lokhttp3/Response; 1
      // 10: areturn
      // 11: astore 2
      // 12: aload 2
      // 13: instanceof javax/net/ssl/SSLHandshakeException
      // 16: iload 1
      // 17: ifne 2f
      // 1a: ifne 38
      // 1d: goto 21
      // 20: athrow
      // 21: ldc_w "GET"
      // 24: aload 0
      // 25: invokevirtual okhttp3/Request.method ()Ljava/lang/String;
      // 28: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 2b: goto 2f
      // 2e: athrow
      // 2f: ifne 38
      // 32: aload 2
      // 33: invokestatic x/oc18ad0bed09.ħ (Ljavax/net/ssl/SSLException;)Ljava/io/IOException;
      // 36: athrow
      // 37: athrow
      // 38: getstatic x/oc18ad0bed09.Ջ Lokhttp3/OkHttpClient;
      // 3b: aload 0
      // 3c: invokevirtual okhttp3/OkHttpClient.newCall (Lokhttp3/Request;)Lokhttp3/Call;
      // 3f: invokeinterface okhttp3/Call.execute ()Lokhttp3/Response; 1
      // 44: areturn
      // 45: astore 3
      // 46: aload 3
      // 47: invokestatic x/oc18ad0bed09.ħ (Ljavax/net/ssl/SSLException;)Ljava/io/IOException;
      // 4a: athrow
   }

   private static IOException ħ(SSLException var0) {
      return new IOException("Couldn't establish a secure connection to Localts. Check VPN, proxy, or antivirus HTTPS scanning. [" + var0 + "]", var0);
   }

   private static OkHttpClient ŝ() {
      okhttp3.OkHttpClient.Builder var0 = new okhttp3.OkHttpClient.Builder()
         .connectTimeout(4620892070048231689L ^ 4620892070048231683L, TimeUnit.SECONDS)
         .readTimeout(4620892070048231692L ^ 4620892070048231683L, TimeUnit.SECONDS);

      try {
         KeyStore var1 = KeyStore.getInstance("Windows-ROOT");
         var1.load(null, null);
         ocfbe13520d7 var2 = new ocfbe13520d7(ե(null), ե(var1));
         SSLContext var3 = SSLContext.getInstance("TLS");
         var3.init(null, new TrustManager[]{var2}, null);
         var0.sslSocketFactory(var3.getSocketFactory(), var2);
      } catch (IOException | GeneralSecurityException var4) {
      }

      return var0.build();
   }

   private static X509TrustManager ե(KeyStore var0) throws GeneralSecurityException {
      TrustManagerFactory var1 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      var1.init(var0);

      for (TrustManager var5 : var1.getTrustManagers()) {
         if (var5 instanceof X509TrustManager var6) {
            return var6;
         }
      }

      throw new NoSuchAlgorithmException("No X509TrustManager available");
   }
}

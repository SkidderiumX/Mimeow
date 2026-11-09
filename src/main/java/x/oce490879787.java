package x;

import com.google.gson.JsonObject;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class oce490879787 {
   private static final String ӑ = "MIAU-IRC-CLIENT-V1";
   private static final String Պ = "/api/v1/irc/auth/challenge";
   private static final String Ç = "/api/v1/irc/auth/offline";
   private static final String շ = "MIAU-IRC-OFFLINE-V1";
   private static final Pattern χ = Pattern.compile("^[A-Za-z0-9_]{3,16}$");
   private static final Pattern Ȯ = Pattern.compile("^[a-f0-9]{32}$");
   private static final Pattern Ͽ = Pattern.compile("^[a-f0-9]{32}$");
   private static final Pattern ţ = Pattern.compile("^\\d{13}-[a-f0-9]{32}$");
   private static final Pattern Ø = Pattern.compile("^[a-f0-9]{40}$");
   private static final SecureRandom Е = new SecureRandom();
   private static final int һ = 100;
   private static final int Ը = 500;
   private final String ȇ;
   private final oc7492a57082 Ù;
   public static boolean փ;

   public oce490879787() {
      this(K(), new oc3eff8bef90());
   }

   oce490879787(String var1, oc7492a57082 var2) {
      this.ȇ = var1 == null ? "" : var1.trim();
      this.Ù = var2;
   }

   public ocd4555a3f01 ρ(String var1, String var2) throws IOException {
      String var3 = ř(var1);
      String var4 = Α(var2);
      JsonObject var5 = new JsonObject();
      var5.addProperty("username", var3);
      var5.addProperty("uuid", var4);
      var5.addProperty("branch", oc380d0f830c.D);
      JsonObject var6 = Ⱥ(this.Ù.z$1lvgioz86iz7d("POST", "irc/auth/challenge", var5.toString(), this.Ť("/api/v1/irc/auth/challenge", var3, var4)));
      String var7 = ɻ(var6, "challenge", 2032467202 ^ 2032463106);
      String var8 = ɻ(var6, "serverId", 2032463146 ^ 2032463106);

      try {
         if (!Ø.matcher(var8).matches()) {
            throw Ӱ();
         }
      } catch (IOException var9) {
         throw var9;
      }

      return new ocd4555a3f01(var7, var8, Ǫ(var6, "expiresAt"));
   }

   public oc96b2b18ccc Ƀ(String var1) throws IOException {
      String var2 = ř(var1);
      String var3 = ŧ(var2);
      JsonObject var4 = new JsonObject();
      var4.addProperty("username", var2);
      var4.addProperty("uuid", var3);
      var4.addProperty("branch", oc380d0f830c.D);
      return Ԧ(Ⱥ(this.Ù.z$1lvgioz86iz7d("POST", "irc/auth/offline", var4.toString(), this.Ť("/api/v1/irc/auth/offline", var2, var3))));
   }

   public oc96b2b18ccc ɿ(String var1) throws IOException {
      JsonObject var2 = new JsonObject();
      var2.addProperty("challenge", Պ(var1, -593334655 ^ -593330559));
      JsonObject var3 = Ⱥ(this.Ù.z$1lvgioz86iz7d("POST", "irc/auth/session", var2.toString(), Collections.emptyMap()));
      return Ԧ(var3);
   }

   public boolean ɍ() throws IOException {
      return Ѳ(Ⱥ(this.Ù.z$1lvgioz86iz7d("GET", "irc/status", null, Collections.emptyMap())), "enabled");
   }

   public oc60a32633cd ϥ(String param1, String param2, String param3, boolean param4, boolean param5) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce490879787.փ Z
      // 003: new com/google/gson/JsonObject
      // 006: dup
      // 007: invokespecial com/google/gson/JsonObject.<init> ()V
      // 00a: astore 7
      // 00c: istore 6
      // 00e: aload 7
      // 010: ldc "after"
      // 012: aload 2
      // 013: iload 6
      // 015: ifne 021
      // 018: ifnonnull 024
      // 01b: goto 01f
      // 01e: athrow
      // 01f: ldc ""
      // 021: goto 025
      // 024: aload 2
      // 025: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/String;)V
      // 028: aload 7
      // 02a: ldc "server"
      // 02c: aload 3
      // 02d: iload 6
      // 02f: ifne 03b
      // 032: ifnonnull 03e
      // 035: goto 039
      // 038: athrow
      // 039: ldc ""
      // 03b: goto 03f
      // 03e: aload 3
      // 03f: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/String;)V
      // 042: aload 7
      // 044: ldc "heartbeat"
      // 046: iload 4
      // 048: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
      // 04b: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Boolean;)V
      // 04e: aload 7
      // 050: ldc "hidden"
      // 052: iload 5
      // 054: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
      // 057: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Boolean;)V
      // 05a: aload 0
      // 05b: getfield x/oce490879787.Ù Lx/oc7492a57082;
      // 05e: ldc "POST"
      // 060: ldc "irc/sync"
      // 062: aload 7
      // 064: invokevirtual com/google/gson/JsonObject.toString ()Ljava/lang/String;
      // 067: aload 1
      // 068: invokestatic x/oce490879787.ш (Ljava/lang/String;)Ljava/util/Map;
      // 06b: invokeinterface x/oc7492a57082.z$1lvgioz86iz7d (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String; 5
      // 070: invokestatic x/oce490879787.Ⱥ (Ljava/lang/String;)Lcom/google/gson/JsonObject;
      // 073: astore 8
      // 075: aload 8
      // 077: ldc "messages"
      // 079: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 07c: astore 9
      // 07e: aload 9
      // 080: iload 6
      // 082: ifne 08e
      // 085: ifnull 09d
      // 088: goto 08c
      // 08b: athrow
      // 08c: aload 9
      // 08e: iload 6
      // 090: ifne 0a4
      // 093: invokevirtual com/google/gson/JsonElement.isJsonArray ()Z
      // 096: ifne 0a2
      // 099: goto 09d
      // 09c: athrow
      // 09d: invokestatic x/oce490879787.Ӱ ()Ljava/io/IOException;
      // 0a0: athrow
      // 0a1: athrow
      // 0a2: aload 9
      // 0a4: invokevirtual com/google/gson/JsonElement.getAsJsonArray ()Lcom/google/gson/JsonArray;
      // 0a7: astore 10
      // 0a9: aload 10
      // 0ab: invokevirtual com/google/gson/JsonArray.size ()I
      // 0ae: ldc 1906375297
      // 0b0: ldc 1906375397
      // 0b2: ixor
      // 0b3: if_icmple 0bb
      // 0b6: invokestatic x/oce490879787.Ӱ ()Ljava/io/IOException;
      // 0b9: athrow
      // 0ba: athrow
      // 0bb: new java/util/ArrayList
      // 0be: dup
      // 0bf: invokespecial java/util/ArrayList.<init> ()V
      // 0c2: astore 11
      // 0c4: aload 10
      // 0c6: invokevirtual com/google/gson/JsonArray.iterator ()Ljava/util/Iterator;
      // 0c9: astore 12
      // 0cb: aload 12
      // 0cd: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0d2: ifeq 119
      // 0d5: aload 12
      // 0d7: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0dc: checkcast com/google/gson/JsonElement
      // 0df: astore 13
      // 0e1: iload 6
      // 0e3: ifne 107
      // 0e6: aload 13
      // 0e8: invokevirtual com/google/gson/JsonElement.isJsonObject ()Z
      // 0eb: ifne 0f7
      // 0ee: goto 0f2
      // 0f1: athrow
      // 0f2: invokestatic x/oce490879787.Ӱ ()Ljava/io/IOException;
      // 0f5: athrow
      // 0f6: athrow
      // 0f7: aload 11
      // 0f9: aload 13
      // 0fb: invokevirtual com/google/gson/JsonElement.getAsJsonObject ()Lcom/google/gson/JsonObject;
      // 0fe: invokestatic x/oce490879787.Ӄ (Lcom/google/gson/JsonObject;)Lx/oce33cf14e5f;
      // 101: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 106: pop
      // 107: iload 6
      // 109: ifeq 0cb
      // 10c: bipush 0
      // 10d: ifeq 115
      // 110: bipush 0
      // 111: goto 116
      // 114: athrow
      // 115: bipush 1
      // 116: putstatic x/oc69da1aa7f5.Ҭ Z
      // 119: aload 8
      // 11b: ldc_w "cursor"
      // 11e: ldc_w 1906375333
      // 121: ldc 1906375397
      // 123: ixor
      // 124: invokestatic x/oce490879787.ʖ (Lcom/google/gson/JsonObject;Ljava/lang/String;I)Ljava/lang/String;
      // 127: astore 12
      // 129: aload 12
      // 12b: iload 6
      // 12d: ifne 13d
      // 130: ifnonnull 13b
      // 133: goto 137
      // 136: athrow
      // 137: ldc ""
      // 139: astore 12
      // 13b: aload 12
      // 13d: invokevirtual java/lang/String.isEmpty ()Z
      // 140: iload 6
      // 142: ifne 15b
      // 145: ifne 163
      // 148: goto 14c
      // 14b: athrow
      // 14c: getstatic x/oce490879787.ţ Ljava/util/regex/Pattern;
      // 14f: aload 12
      // 151: invokevirtual java/util/regex/Pattern.matcher (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
      // 154: invokevirtual java/util/regex/Matcher.matches ()Z
      // 157: goto 15b
      // 15a: athrow
      // 15b: ifne 163
      // 15e: invokestatic x/oce490879787.Ӱ ()Ljava/io/IOException;
      // 161: athrow
      // 162: athrow
      // 163: aload 8
      // 165: ldc_w "presence"
      // 168: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 16b: astore 13
      // 16d: new java/util/ArrayList
      // 170: dup
      // 171: invokespecial java/util/ArrayList.<init> ()V
      // 174: astore 14
      // 176: aload 13
      // 178: iload 6
      // 17a: ifne 186
      // 17d: ifnull 21a
      // 180: goto 184
      // 183: athrow
      // 184: aload 13
      // 186: iload 6
      // 188: ifne 19b
      // 18b: invokevirtual com/google/gson/JsonElement.isJsonNull ()Z
      // 18e: ifne 21a
      // 191: goto 195
      // 194: athrow
      // 195: aload 13
      // 197: goto 19b
      // 19a: athrow
      // 19b: iload 6
      // 19d: ifne 1b1
      // 1a0: invokevirtual com/google/gson/JsonElement.isJsonArray ()Z
      // 1a3: ifne 1af
      // 1a6: goto 1aa
      // 1a9: athrow
      // 1aa: invokestatic x/oce490879787.Ӱ ()Ljava/io/IOException;
      // 1ad: athrow
      // 1ae: athrow
      // 1af: aload 13
      // 1b1: invokevirtual com/google/gson/JsonElement.getAsJsonArray ()Lcom/google/gson/JsonArray;
      // 1b4: astore 15
      // 1b6: aload 15
      // 1b8: iload 6
      // 1ba: ifne 1d4
      // 1bd: invokevirtual com/google/gson/JsonArray.size ()I
      // 1c0: ldc_w 1906375441
      // 1c3: ldc 1906375397
      // 1c5: ixor
      // 1c6: if_icmple 1d2
      // 1c9: goto 1cd
      // 1cc: athrow
      // 1cd: invokestatic x/oce490879787.Ӱ ()Ljava/io/IOException;
      // 1d0: athrow
      // 1d1: athrow
      // 1d2: aload 15
      // 1d4: invokevirtual com/google/gson/JsonArray.iterator ()Ljava/util/Iterator;
      // 1d7: astore 16
      // 1d9: aload 16
      // 1db: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 1e0: ifeq 21a
      // 1e3: aload 16
      // 1e5: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 1ea: checkcast com/google/gson/JsonElement
      // 1ed: astore 17
      // 1ef: iload 6
      // 1f1: ifne 215
      // 1f4: aload 17
      // 1f6: invokevirtual com/google/gson/JsonElement.isJsonObject ()Z
      // 1f9: ifne 205
      // 1fc: goto 200
      // 1ff: athrow
      // 200: invokestatic x/oce490879787.Ӱ ()Ljava/io/IOException;
      // 203: athrow
      // 204: athrow
      // 205: aload 14
      // 207: aload 17
      // 209: invokevirtual com/google/gson/JsonElement.getAsJsonObject ()Lcom/google/gson/JsonObject;
      // 20c: invokestatic x/oce490879787.հ (Lcom/google/gson/JsonObject;)Lx/ocab66880042;
      // 20f: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 214: pop
      // 215: iload 6
      // 217: ifeq 1d9
      // 21a: new x/oc60a32633cd
      // 21d: dup
      // 21e: aload 11
      // 220: invokestatic java/util/Collections.unmodifiableList (Ljava/util/List;)Ljava/util/List;
      // 223: aload 12
      // 225: aload 8
      // 227: invokestatic x/oce490879787.Ѿ (Lcom/google/gson/JsonObject;)I
      // 22a: aload 14
      // 22c: invokestatic java/util/Collections.unmodifiableList (Ljava/util/List;)Ljava/util/List;
      // 22f: invokespecial x/oc60a32633cd.<init> (Ljava/util/List;Ljava/lang/String;ILjava/util/List;)V
      // 232: areturn
   }

   public oce33cf14e5f ԍ(String param1, String param2) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce490879787.փ Z
      // 03: new com/google/gson/JsonObject
      // 06: dup
      // 07: invokespecial com/google/gson/JsonObject.<init> ()V
      // 0a: astore 4
      // 0c: istore 3
      // 0d: aload 4
      // 0f: ldc_w "content"
      // 12: aload 2
      // 13: ldc_w 1516650986
      // 16: ldc_w 1516650730
      // 19: ixor
      // 1a: invokestatic x/oce490879787.Պ (Ljava/lang/String;I)Ljava/lang/String;
      // 1d: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/String;)V
      // 20: aload 0
      // 21: getfield x/oce490879787.Ù Lx/oc7492a57082;
      // 24: ldc "POST"
      // 26: ldc_w "irc/messages"
      // 29: aload 4
      // 2b: invokevirtual com/google/gson/JsonObject.toString ()Ljava/lang/String;
      // 2e: aload 1
      // 2f: invokestatic x/oce490879787.ш (Ljava/lang/String;)Ljava/util/Map;
      // 32: invokeinterface x/oc7492a57082.z$1lvgioz86iz7d (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String; 5
      // 37: invokestatic x/oce490879787.Ⱥ (Ljava/lang/String;)Lcom/google/gson/JsonObject;
      // 3a: astore 5
      // 3c: aload 5
      // 3e: ldc_w "message"
      // 41: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 44: astore 6
      // 46: aload 6
      // 48: iload 3
      // 49: ifne 55
      // 4c: ifnull 63
      // 4f: goto 53
      // 52: athrow
      // 53: aload 6
      // 55: iload 3
      // 56: ifne 6a
      // 59: invokevirtual com/google/gson/JsonElement.isJsonObject ()Z
      // 5c: ifne 68
      // 5f: goto 63
      // 62: athrow
      // 63: invokestatic x/oce490879787.Ӱ ()Ljava/io/IOException;
      // 66: athrow
      // 67: athrow
      // 68: aload 6
      // 6a: invokevirtual com/google/gson/JsonElement.getAsJsonObject ()Lcom/google/gson/JsonObject;
      // 6d: invokestatic x/oce490879787.Ӄ (Lcom/google/gson/JsonObject;)Lx/oce33cf14e5f;
      // 70: areturn
   }

   public int ɜ(String var1, String var2) throws IOException {
      boolean var3 = փ;

      oc7492a57082 var10000;
      String var10001;
      try {
         var10000 = this.Ù;
         var10001 = "GET";
         if (var3) {
            return Ѿ(Ⱥ(this.Ù.z$1lvgioz86iz7d("GET", "irc/online?server=" + oc380d0f830c.ѓ(var2), null, ш(var1))));
         }

         if (var2 == null) {
            return Ѿ(Ⱥ(this.Ù.z$1lvgioz86iz7d("GET", "irc/online?server=" + oc380d0f830c.ѓ(""), null, ш(var1))));
         }
      } catch (IOException var4) {
         throw var4;
      }

      return Ѿ(Ⱥ(var10000.z$1lvgioz86iz7d(var10001, "irc/online?server=" + oc380d0f830c.ѓ(var2), null, ш(var1))));
   }

   static String ʴ(String var0, String var1, String var2, String var3, String var4) throws IOException {
      return Ĝ(var0, "/api/v1/irc/auth/challenge", var1, var2, var3, var4);
   }

   static String ƞ(String var0, String var1, String var2, String var3, String var4) throws IOException {
      return Ĝ(var0, "/api/v1/irc/auth/offline", var1, var2, var3, var4);
   }

   private static String Ĝ(String var0, String var1, String var2, String var3, String var4, String var5) throws IOException {
      String var8 = oc380d0f830c.D;
      String var6 = "MIAU-IRC-CLIENT-V1\nPOST\n" + var1 + "\n" + var2 + "\n" + var3 + "\n" + var4 + "\n" + var5 + "\n" + var8;

      try {
         Mac var7 = Mac.getInstance("HmacSHA256");
         var7.init(new SecretKeySpec(var0.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
         return Base64.getUrlEncoder().withoutPadding().encodeToString(var7.doFinal(var6.getBytes(StandardCharsets.UTF_8)));
      } catch (GeneralSecurityException var14) {
         throw new IOException("Unable to create the IRC client proof.", var14);
      }
   }

   private Map<String, String> Ť(String param1, String param2, String param3) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce490879787.փ Z
      // 03: istore 4
      // 05: aload 0
      // 06: getfield x/oce490879787.ȇ Ljava/lang/String;
      // 09: iload 4
      // 0b: ifne 2a
      // 0e: invokestatic x/oce490879787.Υ (Ljava/lang/String;)Z
      // 11: ifne 24
      // 14: goto 18
      // 17: athrow
      // 18: new java/io/IOException
      // 1b: dup
      // 1c: ldc_w "IRC is unavailable in this client build."
      // 1f: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 22: athrow
      // 23: athrow
      // 24: invokestatic java/lang/System.currentTimeMillis ()J
      // 27: invokestatic java/lang/String.valueOf (J)Ljava/lang/String;
      // 2a: astore 5
      // 2c: ldc_w 1037374916
      // 2f: ldc_w 1037374940
      // 32: ixor
      // 33: newarray 8
      // 35: astore 6
      // 37: getstatic x/oce490879787.Е Ljava/security/SecureRandom;
      // 3a: aload 6
      // 3c: invokevirtual java/security/SecureRandom.nextBytes ([B)V
      // 3f: invokestatic java/util/Base64.getUrlEncoder ()Ljava/util/Base64$Encoder;
      // 42: invokevirtual java/util/Base64$Encoder.withoutPadding ()Ljava/util/Base64$Encoder;
      // 45: aload 6
      // 47: invokevirtual java/util/Base64$Encoder.encodeToString ([B)Ljava/lang/String;
      // 4a: astore 7
      // 4c: aload 0
      // 4d: getfield x/oce490879787.ȇ Ljava/lang/String;
      // 50: aload 1
      // 51: aload 5
      // 53: aload 7
      // 55: aload 2
      // 56: aload 3
      // 57: invokestatic x/oce490879787.Ĝ (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 5a: astore 8
      // 5c: new java/util/LinkedHashMap
      // 5f: dup
      // 60: invokespecial java/util/LinkedHashMap.<init> ()V
      // 63: astore 9
      // 65: aload 9
      // 67: ldc_w "Authorization"
      // 6a: aload 8
      // 6c: ldc_w "MiauClient "
      // 6f: swap
      // 70: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 75: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 7a: pop
      // 7b: aload 9
      // 7d: ldc_w "X-Miau-Timestamp"
      // 80: aload 5
      // 82: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 87: pop
      // 88: aload 9
      // 8a: ldc_w "X-Miau-Nonce"
      // 8d: aload 7
      // 8f: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 94: pop
      // 95: aload 9
      // 97: areturn
   }

   private static boolean Υ(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce490879787.փ Z
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 11
      // 09: ifnull 41
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 0
      // 11: iload 1
      // 12: ifne 24
      // 15: invokevirtual java/lang/String.isEmpty ()Z
      // 18: ifne 41
      // 1b: goto 1f
      // 1e: athrow
      // 1f: aload 0
      // 20: goto 24
      // 23: athrow
      // 24: invokevirtual java/lang/String.length ()I
      // 27: iload 1
      // 28: ifne 3e
      // 2b: ldc_w -1686822563
      // 2e: ldc_w -1686818467
      // 31: ixor
      // 32: if_icmpgt 41
      // 35: goto 39
      // 38: athrow
      // 39: bipush 1
      // 3a: goto 3e
      // 3d: athrow
      // 3e: goto 42
      // 41: bipush 0
      // 42: ireturn
   }

   private static oc96b2b18ccc Ԧ(JsonObject var0) throws IOException {
      return new oc96b2b18ccc(ɻ(var0, "token", 72457028 ^ 72452932), Ǫ(var0, "expiresAt"));
   }

   static String ŧ(String var0) throws IOException {
      boolean var10000 = փ;
      String var2 = ř(var0).toLowerCase(Locale.ROOT);
      boolean var1 = var10000;

      try {
         byte[] var3 = MessageDigest.getInstance("SHA-256").digest(("MIAU-IRC-OFFLINE-V1\n" + var2).getBytes(StandardCharsets.UTF_8));
         StringBuilder var4 = new StringBuilder(-270221234 ^ -270221202);
         int var5 = 0;

         while (true) {
            if (var5 < (-270221186 ^ -270221202)) {
               int var6 = var3[var5] & (-270221167 ^ -270221202);

               try {
                  var9 = var4.append(Character.forDigit(var6 >>> (-270221206 ^ -270221202), -270221186 ^ -270221202));
                  if (var1) {
                     break;
                  }

                  var4.append(Character.forDigit(var6 & (-270221215 ^ -270221202), -270221186 ^ -270221202));
                  var5++;
                  if (!var1) {
                     continue;
                  }
               } catch (GeneralSecurityException var7) {
                  throw var7;
               }
            }

            var9 = var4;
            break;
         }

         return var9.toString();
      } catch (GeneralSecurityException var8) {
         throw new IOException("Unable to create the offline IRC identity.", var8);
      }
   }

   static boolean Ï(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce490879787.փ Z
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 17
      // 09: ifnonnull 16
      // 0c: goto 10
      // 0f: athrow
      // 10: ldc ""
      // 12: goto 1a
      // 15: athrow
      // 16: aload 0
      // 17: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 1a: astore 2
      // 1b: aload 2
      // 1c: invokevirtual java/lang/String.isEmpty ()Z
      // 1f: iload 1
      // 20: ifne 83
      // 23: ifne 82
      // 26: goto 2a
      // 29: athrow
      // 2a: ldc_w "0"
      // 2d: aload 2
      // 2e: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 31: iload 1
      // 32: ifne 83
      // 35: goto 39
      // 38: athrow
      // 39: ifne 82
      // 3c: goto 40
      // 3f: athrow
      // 40: ldc_w "-"
      // 43: aload 2
      // 44: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 47: iload 1
      // 48: ifne 83
      // 4b: goto 4f
      // 4e: athrow
      // 4f: ifne 82
      // 52: goto 56
      // 55: athrow
      // 56: ldc_w "null"
      // 59: aload 2
      // 5a: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 5d: iload 1
      // 5e: ifne 83
      // 61: goto 65
      // 64: athrow
      // 65: ifne 82
      // 68: goto 6c
      // 6b: athrow
      // 6c: ldc_w "offline"
      // 6f: aload 2
      // 70: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 73: iload 1
      // 74: ifne 83
      // 77: goto 7b
      // 7a: athrow
      // 7b: ifeq 86
      // 7e: goto 82
      // 81: athrow
      // 82: bipush 1
      // 83: goto 87
      // 86: bipush 0
      // 87: ireturn
   }

   private static oce33cf14e5f Ӄ(JsonObject param0) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: aload 0
      // 001: ldc_w "id"
      // 004: ldc_w -1836522823
      // 007: ldc_w -1836522855
      // 00a: ixor
      // 00b: invokestatic x/oce490879787.ɻ (Lcom/google/gson/JsonObject;Ljava/lang/String;I)Ljava/lang/String;
      // 00e: astore 2
      // 00f: getstatic x/oce490879787.փ Z
      // 012: aload 0
      // 013: ldc_w "cursor"
      // 016: ldc_w -1836522791
      // 019: ldc_w -1836522855
      // 01c: ixor
      // 01d: invokestatic x/oce490879787.ɻ (Lcom/google/gson/JsonObject;Ljava/lang/String;I)Ljava/lang/String;
      // 020: astore 3
      // 021: aload 0
      // 022: ldc "username"
      // 024: ldc_w -1836522823
      // 027: ldc_w -1836522855
      // 02a: ixor
      // 02b: invokestatic x/oce490879787.ɻ (Lcom/google/gson/JsonObject;Ljava/lang/String;I)Ljava/lang/String;
      // 02e: astore 4
      // 030: aload 0
      // 031: ldc_w "role"
      // 034: ldc_w -1836522863
      // 037: ldc_w -1836522855
      // 03a: ixor
      // 03b: invokestatic x/oce490879787.ɻ (Lcom/google/gson/JsonObject;Ljava/lang/String;I)Ljava/lang/String;
      // 03e: astore 5
      // 040: istore 1
      // 041: aload 0
      // 042: ldc_w "content"
      // 045: ldc_w -1836522599
      // 048: ldc_w -1836522855
      // 04b: ixor
      // 04c: invokestatic x/oce490879787.ɻ (Lcom/google/gson/JsonObject;Ljava/lang/String;I)Ljava/lang/String;
      // 04f: astore 6
      // 051: getstatic x/oce490879787.Ͽ Ljava/util/regex/Pattern;
      // 054: iload 1
      // 055: ifne 06d
      // 058: aload 2
      // 059: invokevirtual java/util/regex/Pattern.matcher (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
      // 05c: invokevirtual java/util/regex/Matcher.matches ()Z
      // 05f: ifeq 13c
      // 062: goto 066
      // 065: athrow
      // 066: getstatic x/oce490879787.ţ Ljava/util/regex/Pattern;
      // 069: goto 06d
      // 06c: athrow
      // 06d: aload 3
      // 06e: invokevirtual java/util/regex/Pattern.matcher (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
      // 071: invokevirtual java/util/regex/Matcher.matches ()Z
      // 074: iload 1
      // 075: ifne 093
      // 078: ifeq 13c
      // 07b: goto 07f
      // 07e: athrow
      // 07f: ldc_w "user"
      // 082: iload 1
      // 083: ifne 12a
      // 086: goto 08a
      // 089: athrow
      // 08a: aload 5
      // 08c: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 08f: goto 093
      // 092: athrow
      // 093: ifne 120
      // 096: ldc_w "owner"
      // 099: iload 1
      // 09a: ifne 12a
      // 09d: goto 0a1
      // 0a0: athrow
      // 0a1: aload 5
      // 0a3: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0a6: ifne 120
      // 0a9: goto 0ad
      // 0ac: athrow
      // 0ad: ldc_w "dev"
      // 0b0: iload 1
      // 0b1: ifne 12a
      // 0b4: goto 0b8
      // 0b7: athrow
      // 0b8: aload 5
      // 0ba: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0bd: ifne 120
      // 0c0: goto 0c4
      // 0c3: athrow
      // 0c4: ldc_w "manager"
      // 0c7: iload 1
      // 0c8: ifne 12a
      // 0cb: goto 0cf
      // 0ce: athrow
      // 0cf: aload 5
      // 0d1: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0d4: ifne 120
      // 0d7: goto 0db
      // 0da: athrow
      // 0db: ldc_w "helper"
      // 0de: iload 1
      // 0df: ifne 12a
      // 0e2: goto 0e6
      // 0e5: athrow
      // 0e6: aload 5
      // 0e8: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0eb: ifne 120
      // 0ee: goto 0f2
      // 0f1: athrow
      // 0f2: ldc_w "media"
      // 0f5: iload 1
      // 0f6: ifne 12a
      // 0f9: goto 0fd
      // 0fc: athrow
      // 0fd: aload 5
      // 0ff: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 102: ifne 120
      // 105: goto 109
      // 108: athrow
      // 109: ldc_w "friends"
      // 10c: iload 1
      // 10d: ifne 12a
      // 110: goto 114
      // 113: athrow
      // 114: aload 5
      // 116: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 119: ifeq 13c
      // 11c: goto 120
      // 11f: athrow
      // 120: aload 4
      // 122: iload 1
      // 123: ifne 136
      // 126: goto 12a
      // 129: athrow
      // 12a: invokestatic x/oce490879787.Ⱥ (Ljava/lang/String;)Z
      // 12d: ifne 13c
      // 130: aload 6
      // 132: goto 136
      // 135: athrow
      // 136: invokestatic x/oce490879787.Ⱥ (Ljava/lang/String;)Z
      // 139: ifeq 141
      // 13c: invokestatic x/oce490879787.Ӱ ()Ljava/io/IOException;
      // 13f: athrow
      // 140: athrow
      // 141: new x/oce33cf14e5f
      // 144: dup
      // 145: aload 2
      // 146: aload 3
      // 147: aload 4
      // 149: aload 5
      // 14b: aload 6
      // 14d: aload 0
      // 14e: ldc_w "createdAt"
      // 151: invokestatic x/oce490879787.Ǫ (Lcom/google/gson/JsonObject;Ljava/lang/String;)J
      // 154: invokespecial x/oce33cf14e5f.<init> (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V
      // 157: areturn
   }

   private static ocab66880042 հ(JsonObject param0) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce490879787.փ Z
      // 03: aload 0
      // 04: ldc "uuid"
      // 06: ldc_w 703928998
      // 09: ldc_w 703928966
      // 0c: ixor
      // 0d: invokestatic x/oce490879787.ɻ (Lcom/google/gson/JsonObject;Ljava/lang/String;I)Ljava/lang/String;
      // 10: astore 2
      // 11: aload 0
      // 12: ldc "username"
      // 14: ldc_w 703928982
      // 17: ldc_w 703928966
      // 1a: ixor
      // 1b: invokestatic x/oce490879787.ɻ (Lcom/google/gson/JsonObject;Ljava/lang/String;I)Ljava/lang/String;
      // 1e: astore 3
      // 1f: istore 1
      // 20: getstatic x/oce490879787.Ȯ Ljava/util/regex/Pattern;
      // 23: iload 1
      // 24: ifne 3c
      // 27: aload 2
      // 28: invokevirtual java/util/regex/Pattern.matcher (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
      // 2b: invokevirtual java/util/regex/Matcher.matches ()Z
      // 2e: ifeq 59
      // 31: goto 35
      // 34: athrow
      // 35: getstatic x/oce490879787.χ Ljava/util/regex/Pattern;
      // 38: goto 3c
      // 3b: athrow
      // 3c: aload 3
      // 3d: invokevirtual java/util/regex/Pattern.matcher (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
      // 40: invokevirtual java/util/regex/Matcher.matches ()Z
      // 43: iload 1
      // 44: ifne 56
      // 47: ifeq 59
      // 4a: goto 4e
      // 4d: athrow
      // 4e: aload 3
      // 4f: invokestatic x/oce490879787.Ⱥ (Ljava/lang/String;)Z
      // 52: goto 56
      // 55: athrow
      // 56: ifeq 5e
      // 59: invokestatic x/oce490879787.Ӱ ()Ljava/io/IOException;
      // 5c: athrow
      // 5d: athrow
      // 5e: new x/ocab66880042
      // 61: dup
      // 62: aload 2
      // 63: aload 3
      // 64: invokespecial x/ocab66880042.<init> (Ljava/lang/String;Ljava/lang/String;)V
      // 67: areturn
   }

   private static JsonObject Ⱥ(String param0) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce490879787.փ Z
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 11
      // 09: ifnull 1e
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 0
      // 11: invokevirtual java/lang/String.length ()I
      // 14: ldc_w -2106941804
      // 17: ldc_w -2109038956
      // 1a: ixor
      // 1b: if_icmple 23
      // 1e: invokestatic x/oce490879787.Ӱ ()Ljava/io/IOException;
      // 21: athrow
      // 22: athrow
      // 23: new com/google/gson/JsonParser
      // 26: dup
      // 27: invokespecial com/google/gson/JsonParser.<init> ()V
      // 2a: aload 0
      // 2b: invokevirtual com/google/gson/JsonParser.parse (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 2e: astore 2
      // 2f: aload 2
      // 30: iload 1
      // 31: ifne 44
      // 34: invokevirtual com/google/gson/JsonElement.isJsonObject ()Z
      // 37: ifne 43
      // 3a: goto 3e
      // 3d: athrow
      // 3e: invokestatic x/oce490879787.Ӱ ()Ljava/io/IOException;
      // 41: athrow
      // 42: athrow
      // 43: aload 2
      // 44: invokevirtual com/google/gson/JsonElement.getAsJsonObject ()Lcom/google/gson/JsonObject;
      // 47: astore 3
      // 48: ldc_w "success"
      // 4b: aload 3
      // 4c: ldc_w "status"
      // 4f: ldc_w -2109038924
      // 52: ldc_w -2109038956
      // 55: ixor
      // 56: invokestatic x/oce490879787.ɻ (Lcom/google/gson/JsonObject;Ljava/lang/String;I)Ljava/lang/String;
      // 59: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 5c: ifne 64
      // 5f: invokestatic x/oce490879787.Ӱ ()Ljava/io/IOException;
      // 62: athrow
      // 63: athrow
      // 64: aload 3
      // 65: areturn
      // 66: astore 2
      // 67: aload 2
      // 68: athrow
      // 69: astore 2
      // 6a: invokestatic x/oce490879787.Ӱ ()Ljava/io/IOException;
      // 6d: athrow
   }

   private static Map<String, String> ш(String var0) throws IOException {
      LinkedHashMap var1 = new LinkedHashMap();
      var1.put("Authorization", "Bearer " + Պ(var0, -1900515112 ^ -1900519208));
      return var1;
   }

   private static String ř(String param0) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce490879787.փ Z
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 17
      // 09: ifnonnull 16
      // 0c: goto 10
      // 0f: athrow
      // 10: ldc ""
      // 12: goto 1a
      // 15: athrow
      // 16: aload 0
      // 17: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 1a: astore 2
      // 1b: getstatic x/oce490879787.χ Ljava/util/regex/Pattern;
      // 1e: aload 2
      // 1f: invokevirtual java/util/regex/Pattern.matcher (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
      // 22: invokevirtual java/util/regex/Matcher.matches ()Z
      // 25: ifne 34
      // 28: new java/io/IOException
      // 2b: dup
      // 2c: ldc_w "The Minecraft username is invalid."
      // 2f: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 32: athrow
      // 33: athrow
      // 34: aload 2
      // 35: areturn
   }

   private static String Α(String param0) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce490879787.փ Z
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 22
      // 09: ifnonnull 16
      // 0c: goto 10
      // 0f: athrow
      // 10: ldc ""
      // 12: goto 25
      // 15: athrow
      // 16: aload 0
      // 17: ldc_w "-"
      // 1a: ldc ""
      // 1c: invokevirtual java/lang/String.replace (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
      // 1f: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 22: invokevirtual java/lang/String.toLowerCase ()Ljava/lang/String;
      // 25: astore 2
      // 26: getstatic x/oce490879787.Ȯ Ljava/util/regex/Pattern;
      // 29: aload 2
      // 2a: invokevirtual java/util/regex/Pattern.matcher (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
      // 2d: invokevirtual java/util/regex/Matcher.matches ()Z
      // 30: ifne 3f
      // 33: new java/io/IOException
      // 36: dup
      // 37: ldc_w "The Minecraft session UUID is invalid."
      // 3a: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 3d: athrow
      // 3e: athrow
      // 3f: aload 2
      // 40: areturn
   }

   private static int Ѿ(JsonObject param0) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce490879787.փ Z
      // 03: aload 0
      // 04: ldc_w "online"
      // 07: invokestatic x/oce490879787.Ǫ (Lcom/google/gson/JsonObject;Ljava/lang/String;)J
      // 0a: lstore 2
      // 0b: istore 1
      // 0c: lload 2
      // 0d: lconst_0
      // 0e: iload 1
      // 0f: ifne 2e
      // 12: lcmp
      // 13: iflt 32
      // 16: goto 1a
      // 19: athrow
      // 1a: lload 2
      // 1b: iload 1
      // 1c: ifne 38
      // 1f: goto 23
      // 22: athrow
      // 23: ldc2_w 8312813969711953183
      // 26: ldc2_w 8312813969712265055
      // 29: lxor
      // 2a: goto 2e
      // 2d: athrow
      // 2e: lcmp
      // 2f: ifle 37
      // 32: invokestatic x/oce490879787.Ӱ ()Ljava/io/IOException;
      // 35: athrow
      // 36: athrow
      // 37: lload 2
      // 38: l2i
      // 39: ireturn
   }

   private static boolean Ѳ(JsonObject param0, String param1) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce490879787.փ Z
      // 03: aload 0
      // 04: aload 1
      // 05: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 08: astore 3
      // 09: istore 2
      // 0a: aload 3
      // 0b: iload 2
      // 0c: ifne 17
      // 0f: ifnull 3b
      // 12: goto 16
      // 15: athrow
      // 16: aload 3
      // 17: iload 2
      // 18: ifne 2a
      // 1b: invokevirtual com/google/gson/JsonElement.isJsonPrimitive ()Z
      // 1e: ifeq 3b
      // 21: goto 25
      // 24: athrow
      // 25: aload 3
      // 26: goto 2a
      // 29: athrow
      // 2a: invokevirtual com/google/gson/JsonElement.getAsJsonPrimitive ()Lcom/google/gson/JsonPrimitive;
      // 2d: iload 2
      // 2e: ifne 41
      // 31: invokevirtual com/google/gson/JsonPrimitive.isBoolean ()Z
      // 34: ifne 40
      // 37: goto 3b
      // 3a: athrow
      // 3b: invokestatic x/oce490879787.Ӱ ()Ljava/io/IOException;
      // 3e: athrow
      // 3f: athrow
      // 40: aload 3
      // 41: invokevirtual com/google/gson/JsonElement.getAsBoolean ()Z
      // 44: ireturn
   }

   private static long Ǫ(JsonObject param0, String param1) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce490879787.փ Z
      // 03: aload 0
      // 04: aload 1
      // 05: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 08: astore 3
      // 09: istore 2
      // 0a: aload 3
      // 0b: iload 2
      // 0c: ifne 17
      // 0f: ifnull 37
      // 12: goto 16
      // 15: athrow
      // 16: aload 3
      // 17: iload 2
      // 18: ifne 2e
      // 1b: invokevirtual com/google/gson/JsonElement.isJsonPrimitive ()Z
      // 1e: ifeq 37
      // 21: goto 25
      // 24: athrow
      // 25: aload 3
      // 26: iload 2
      // 27: ifne 3d
      // 2a: goto 2e
      // 2d: athrow
      // 2e: invokevirtual com/google/gson/JsonElement.getAsJsonPrimitive ()Lcom/google/gson/JsonPrimitive;
      // 31: invokevirtual com/google/gson/JsonPrimitive.isNumber ()Z
      // 34: ifne 3c
      // 37: invokestatic x/oce490879787.Ӱ ()Ljava/io/IOException;
      // 3a: athrow
      // 3b: athrow
      // 3c: aload 3
      // 3d: invokevirtual com/google/gson/JsonElement.getAsLong ()J
      // 40: lstore 4
      // 42: goto 4b
      // 45: astore 6
      // 47: invokestatic x/oce490879787.Ӱ ()Ljava/io/IOException;
      // 4a: athrow
      // 4b: lload 4
      // 4d: iload 2
      // 4e: ifne 61
      // 51: lconst_0
      // 52: lcmp
      // 53: ifge 5f
      // 56: goto 5a
      // 59: athrow
      // 5a: invokestatic x/oce490879787.Ӱ ()Ljava/io/IOException;
      // 5d: athrow
      // 5e: athrow
      // 5f: lload 4
      // 61: lreturn
   }

   private static String ɻ(JsonObject param0, String param1, int param2) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce490879787.փ Z
      // 03: aload 0
      // 04: aload 1
      // 05: iload 2
      // 06: invokestatic x/oce490879787.ʖ (Lcom/google/gson/JsonObject;Ljava/lang/String;I)Ljava/lang/String;
      // 09: astore 4
      // 0b: istore 3
      // 0c: aload 4
      // 0e: iload 3
      // 0f: ifne 1b
      // 12: ifnull 29
      // 15: goto 19
      // 18: athrow
      // 19: aload 4
      // 1b: iload 3
      // 1c: ifne 30
      // 1f: invokevirtual java/lang/String.isEmpty ()Z
      // 22: ifeq 2e
      // 25: goto 29
      // 28: athrow
      // 29: invokestatic x/oce490879787.Ӱ ()Ljava/io/IOException;
      // 2c: athrow
      // 2d: athrow
      // 2e: aload 4
      // 30: areturn
   }

   private static String ʖ(JsonObject param0, String param1, int param2) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce490879787.փ Z
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
      // 1b: ifne 2d
      // 1e: invokevirtual com/google/gson/JsonElement.isJsonNull ()Z
      // 21: ifeq 2b
      // 24: goto 28
      // 27: athrow
      // 28: aconst_null
      // 29: areturn
      // 2a: athrow
      // 2b: aload 4
      // 2d: iload 3
      // 2e: ifne 41
      // 31: invokevirtual com/google/gson/JsonElement.isJsonPrimitive ()Z
      // 34: ifeq 52
      // 37: goto 3b
      // 3a: athrow
      // 3b: aload 4
      // 3d: goto 41
      // 40: athrow
      // 41: iload 3
      // 42: ifne 59
      // 45: invokevirtual com/google/gson/JsonElement.getAsJsonPrimitive ()Lcom/google/gson/JsonPrimitive;
      // 48: invokevirtual com/google/gson/JsonPrimitive.isString ()Z
      // 4b: ifne 57
      // 4e: goto 52
      // 51: athrow
      // 52: invokestatic x/oce490879787.Ӱ ()Ljava/io/IOException;
      // 55: athrow
      // 56: athrow
      // 57: aload 4
      // 59: invokevirtual com/google/gson/JsonElement.getAsString ()Ljava/lang/String;
      // 5c: astore 5
      // 5e: aload 5
      // 60: iload 3
      // 61: ifne 76
      // 64: invokevirtual java/lang/String.length ()I
      // 67: iload 2
      // 68: if_icmple 74
      // 6b: goto 6f
      // 6e: athrow
      // 6f: invokestatic x/oce490879787.Ӱ ()Ljava/io/IOException;
      // 72: athrow
      // 73: athrow
      // 74: aload 5
      // 76: areturn
   }

   private static String Պ(String param0, int param1) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce490879787.փ Z
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 17
      // 09: ifnonnull 16
      // 0c: goto 10
      // 0f: athrow
      // 10: ldc ""
      // 12: goto 1a
      // 15: athrow
      // 16: aload 0
      // 17: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 1a: astore 3
      // 1b: aload 3
      // 1c: iload 2
      // 1d: ifne 2f
      // 20: invokevirtual java/lang/String.isEmpty ()Z
      // 23: ifne 3e
      // 26: goto 2a
      // 29: athrow
      // 2a: aload 3
      // 2b: goto 2f
      // 2e: athrow
      // 2f: iload 2
      // 30: ifne 4b
      // 33: invokevirtual java/lang/String.length ()I
      // 36: iload 1
      // 37: if_icmple 4a
      // 3a: goto 3e
      // 3d: athrow
      // 3e: new java/io/IOException
      // 41: dup
      // 42: ldc_w "The IRC request contains an invalid value."
      // 45: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 48: athrow
      // 49: athrow
      // 4a: aload 3
      // 4b: areturn
   }

   private static boolean ircStatusBool(Stringtring param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce490879787.փ Z
      // 03: bipush 0
      // 04: istore 2
      // 05: istore 1
      // 06: iload 2
      // 07: aload 0
      // 08: invokevirtual java/lang/String.length ()I
      // 0b: if_icmpge 4b
      // 0e: aload 0
      // 0f: iload 2
      // 10: invokevirtual java/lang/String.charAt (I)C
      // 13: iload 1
      // 14: ifne 4c
      // 17: istore 3
      // 18: iload 3
      // 19: iload 1
      // 1a: ifne 43
      // 1d: ldc_w 1393692319
      // 20: ldc_w 1393692216
      // 23: ixor
      // 24: if_icmpeq 3e
      // 27: goto 2b
      // 2a: athrow
      // 2b: iload 3
      // 2c: iload 1
      // 2d: ifne 43
      // 30: goto 34
      // 33: athrow
      // 34: invokestatic java/lang/Character.isISOControl (C)Z
      // 37: ifeq 44
      // 3a: goto 3e
      // 3d: athrow
      // 3e: bipush 1
      // 3f: goto 43
      // 42: athrow
      // 43: ireturn
      // 44: iinc 2 1
      // 47: iload 1
      // 48: ifeq 06
      // 4b: bipush 0
      // 4c: ireturn
   }

   private static IOException Ӱ() {
      return new IOException("The IRC service returned an invalid response.");
   }

   static String K() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: ldc_w "miau.irc.clientSecret"
      // 03: ldc ""
      // 05: invokestatic java/lang/System.getProperty (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 08: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 0b: astore 0
      // 0c: aload 0
      // 0d: invokevirtual java/lang/String.isEmpty ()Z
      // 10: ifne 16
      // 13: aload 0
      // 14: areturn
      // 15: athrow
      // 16: ldc_w "MIAU_IRC_CLIENT_SECRET"
      // 19: invokestatic java/lang/System.getenv (Ljava/lang/String;)Ljava/lang/String;
      // 1c: astore 1
      // 1d: aload 1
      // 1e: ifnull 35
      // 21: aload 1
      // 22: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 25: invokevirtual java/lang/String.isEmpty ()Z
      // 28: ifne 35
      // 2b: goto 2f
      // 2e: athrow
      // 2f: aload 1
      // 30: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 33: areturn
      // 34: athrow
      // 35: ldc_w "MIAU_CLIENT_AUTH_SECRET"
      // 38: invokestatic java/lang/System.getenv (Ljava/lang/String;)Ljava/lang/String;
      // 3b: astore 2
      // 3c: aload 2
      // 3d: ifnull 54
      // 40: aload 2
      // 41: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 44: invokevirtual java/lang/String.isEmpty ()Z
      // 47: ifne 54
      // 4a: goto 4e
      // 4d: athrow
      // 4e: aload 2
      // 4f: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 52: areturn
      // 53: athrow
      // 54: invokestatic x/oc9c49691343.Ö ()Ljava/lang/String;
      // 57: areturn
   }
}

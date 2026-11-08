package x;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Logger;
import keystrokesmod.oc4ef17ea060;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Session;

public class ocd6bc26d10b {
   private static final Minecraft ԗ = Minecraft.getMinecraft();
   private static final File ɤ = new File(ԗ.mcDataDir, "openmiau.accounts.json");
   private static final Gson ɚ = new GsonBuilder().setPrettyPrinting().create();
   private static final Logger ԝ = Logger.getLogger(ocd6bc26d10b.class.getName());
   private static final oc59f0ab164a ɢ = oc8a51e14bb3.Ć();
   private static final Object Ӹ = new Object();
   private static long Մ = System.currentTimeMillis();
   private static long ů = Մ;
   private static boolean Ơ;
   public static final List<oc804fdd8d75> ʓ = new CopyOnWriteArrayList<>();
   public static int Ó;

   public static void Ȕ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: getstatic keystrokesmod/oc4ef17ea060.ċ Z
      // 03: invokestatic x/occ19eff12a7.ώ ()Ljavax/net/ssl/SSLContext;
      // 06: pop
      // 07: istore 0
      // 08: getstatic x/ocea775c9d5c.ų Lx/oc04596227b7;
      // 0b: new x/ocde118c643d
      // 0e: dup
      // 0f: invokespecial x/ocde118c643d.<init> ()V
      // 12: invokestatic x/oca3b5ecdd9a.ò (Lx/oc04596227b7;Ljava/lang/Object;)V
      // 15: iload 0
      // 16: ifne 87
      // 19: invokestatic x/occ791aa07d0.Ӽ ()V
      // 1c: getstatic x/ocd6bc26d10b.ɤ Ljava/io/File;
      // 1f: invokevirtual java/io/File.exists ()Z
      // 22: ifne 7e
      // 25: goto 29
      // 28: athrow
      // 29: getstatic x/ocd6bc26d10b.ɤ Ljava/io/File;
      // 2c: invokevirtual java/io/File.getParentFile ()Ljava/io/File;
      // 2f: iload 0
      // 30: ifne 5c
      // 33: invokevirtual java/io/File.exists ()Z
      // 36: ifne 55
      // 39: goto 3d
      // 3c: athrow
      // 3d: getstatic x/ocd6bc26d10b.ɤ Ljava/io/File;
      // 40: invokevirtual java/io/File.getParentFile ()Ljava/io/File;
      // 43: iload 0
      // 44: ifne 5c
      // 47: goto 4b
      // 4a: athrow
      // 4b: invokevirtual java/io/File.mkdirs ()Z
      // 4e: ifeq 6e
      // 51: goto 55
      // 54: athrow
      // 55: getstatic x/ocd6bc26d10b.ɤ Ljava/io/File;
      // 58: goto 5c
      // 5b: athrow
      // 5c: invokevirtual java/io/File.createNewFile ()Z
      // 5f: ifeq 6e
      // 62: getstatic x/ocd6bc26d10b.ԝ Ljava/util/logging/Logger;
      // 65: ldc "Successfully created openmiau.accounts.json"
      // 67: invokevirtual java/util/logging/Logger.info (Ljava/lang/String;)V
      // 6a: goto 6e
      // 6d: athrow
      // 6e: goto 7e
      // 71: astore 1
      // 72: getstatic x/ocd6bc26d10b.ԝ Ljava/util/logging/Logger;
      // 75: getstatic java/util/logging/Level.WARNING Ljava/util/logging/Level;
      // 78: ldc "Couldn't create openmiau.accounts.json"
      // 7a: aload 1
      // 7b: invokevirtual java/util/logging/Logger.log (Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
      // 7e: invokestatic x/ocd6bc26d10b.č ()V
      // 81: invokestatic x/occ791aa07d0.þ ()Lnet/minecraft/util/Session;
      // 84: invokestatic x/ocd6bc26d10b.м (Lnet/minecraft/util/Session;)V
      // 87: return
   }

   public static oc804fdd8d75 Ǻ(oc804fdd8d75 var0) {
      try {
         if (var0 == null) {
            throw new IllegalArgumentException("incoming");
         }
      } catch (IllegalArgumentException var5) {
         throw var5;
      }

      synchronized (Ӹ) {
         oc804fdd8d75 var2 = oc4ff1460136.ă(ʓ, var0);
         ζ();
         return var2;
      }
   }

   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static void ӵ(List<oc804fdd8d75> var0) {
      boolean var1 = oc4ef17ea060.ċ;

      label66: {
         List var10000;
         label61: {
            try {
               var10000 = var0;
               if (var1) {
                  break label61;
               }

               if (var0 == null) {
                  break label66;
               }
            } catch (IllegalArgumentException var9) {
               throw var9;
            }

            var10000 = var0;
         }

         try {
            if (var10000.isEmpty()) {
               break label66;
            }
         } catch (IllegalArgumentException var8) {
            throw var8;
         }

         synchronized (Ӹ) {
            Iterator var3 = var0.iterator();

            while (true) {
               if (var3.hasNext()) {
                  oc804fdd8d75 var4 = (oc804fdd8d75)var3.next();
                  if (var1) {
                     break;
                  }

                  if (!var1 && var4 != null) {
                     oc4ff1460136.ă(ʓ, var4);
                  }

                  if (!var1) {
                     continue;
                  }
               }

               ζ();
               break;
            }

            return;
         }
      }

      try {
         ;
      } catch (IllegalArgumentException var6) {
         throw var6;
      }
   }

   public static void č() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic keystrokesmod/oc4ef17ea060.ċ Z
      // 003: istore 0
      // 004: iload 0
      // 005: getstatic x/ocd6bc26d10b.Ӹ Ljava/lang/Object;
      // 008: dup
      // 009: astore 1
      // 00a: monitorenter
      // 00b: ifne 01f
      // 00e: getstatic x/ocd6bc26d10b.Ơ Z
      // 011: ifeq 017
      // 014: invokestatic x/ocd6bc26d10b.ζ ()V
      // 017: getstatic x/ocd6bc26d10b.ʓ Ljava/util/List;
      // 01a: invokeinterface java/util/List.clear ()V 1
      // 01f: bipush 0
      // 020: istore 2
      // 021: new java/io/InputStreamReader
      // 024: dup
      // 025: new java/io/FileInputStream
      // 028: dup
      // 029: getstatic x/ocd6bc26d10b.ɤ Ljava/io/File;
      // 02c: invokespecial java/io/FileInputStream.<init> (Ljava/io/File;)V
      // 02f: getstatic java/nio/charset/StandardCharsets.UTF_8 Ljava/nio/charset/Charset;
      // 032: invokespecial java/io/InputStreamReader.<init> (Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
      // 035: astore 3
      // 036: new com/google/gson/JsonParser
      // 039: dup
      // 03a: invokespecial com/google/gson/JsonParser.<init> ()V
      // 03d: aload 3
      // 03e: invokevirtual com/google/gson/JsonParser.parse (Ljava/io/Reader;)Lcom/google/gson/JsonElement;
      // 041: astore 4
      // 043: iload 0
      // 044: ifne 1d7
      // 047: aload 4
      // 049: ifnull 1d3
      // 04c: aload 4
      // 04e: iload 0
      // 04f: ifne 05a
      // 052: invokevirtual com/google/gson/JsonElement.isJsonArray ()Z
      // 055: ifeq 1d3
      // 058: aload 4
      // 05a: invokevirtual com/google/gson/JsonElement.getAsJsonArray ()Lcom/google/gson/JsonArray;
      // 05d: invokevirtual com/google/gson/JsonArray.iterator ()Ljava/util/Iterator;
      // 060: astore 5
      // 062: aload 5
      // 064: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 069: ifeq 1d3
      // 06c: aload 5
      // 06e: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 073: checkcast com/google/gson/JsonElement
      // 076: astore 6
      // 078: iload 0
      // 079: ifne 1d7
      // 07c: aload 6
      // 07e: iload 0
      // 07f: ifne 08d
      // 082: invokevirtual com/google/gson/JsonElement.isJsonObject ()Z
      // 085: ifne 08b
      // 088: goto 062
      // 08b: aload 6
      // 08d: invokevirtual com/google/gson/JsonElement.getAsJsonObject ()Lcom/google/gson/JsonObject;
      // 090: astore 7
      // 092: iload 0
      // 093: ldc ""
      // 095: astore 8
      // 097: ldc ""
      // 099: astore 9
      // 09b: ldc ""
      // 09d: astore 10
      // 09f: ifne 12d
      // 0a2: aload 7
      // 0a4: ldc "credentials"
      // 0a6: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 0a9: ifeq 11b
      // 0ac: aload 7
      // 0ae: iload 0
      // 0af: ifne 126
      // 0b2: ldc "credentials"
      // 0b4: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 0b7: invokevirtual com/google/gson/JsonElement.isJsonObject ()Z
      // 0ba: ifeq 11b
      // 0bd: aload 7
      // 0bf: ldc "credentials"
      // 0c1: invokevirtual com/google/gson/JsonObject.getAsJsonObject (Ljava/lang/String;)Lcom/google/gson/JsonObject;
      // 0c4: astore 11
      // 0c6: getstatic x/ocd6bc26d10b.ɢ Lx/oc59f0ab164a;
      // 0c9: aload 11
      // 0cb: ldc "payload"
      // 0cd: invokestatic x/ocd6bc26d10b.é (Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/String;
      // 0d0: invokeinterface x/oc59f0ab164a.z$3gaj86hkfeiuj (Ljava/lang/String;)Ljava/lang/String; 2
      // 0d5: astore 12
      // 0d7: new com/google/gson/JsonParser
      // 0da: dup
      // 0db: invokespecial com/google/gson/JsonParser.<init> ()V
      // 0de: aload 12
      // 0e0: invokevirtual com/google/gson/JsonParser.parse (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 0e3: invokevirtual com/google/gson/JsonElement.getAsJsonObject ()Lcom/google/gson/JsonObject;
      // 0e6: astore 13
      // 0e8: aload 13
      // 0ea: ldc "refreshToken"
      // 0ec: invokestatic x/ocd6bc26d10b.é (Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/String;
      // 0ef: astore 8
      // 0f1: aload 13
      // 0f3: ldc "accessToken"
      // 0f5: invokestatic x/ocd6bc26d10b.é (Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/String;
      // 0f8: astore 9
      // 0fa: aload 13
      // 0fc: ldc_w "authData"
      // 0ff: invokestatic x/ocd6bc26d10b.é (Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/String;
      // 102: astore 10
      // 104: goto 14d
      // 107: astore 11
      // 109: iload 0
      // 10a: getstatic x/ocd6bc26d10b.ԝ Ljava/util/logging/Logger;
      // 10d: getstatic java/util/logging/Level.WARNING Ljava/util/logging/Level;
      // 110: ldc_w "Couldn't decrypt credentials for saved account"
      // 113: aload 11
      // 115: invokevirtual java/util/logging/Logger.log (Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
      // 118: ifeq 14d
      // 11b: aload 7
      // 11d: ldc "refreshToken"
      // 11f: invokestatic x/ocd6bc26d10b.ѫ (Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/String;
      // 122: astore 8
      // 124: aload 7
      // 126: ldc "accessToken"
      // 128: invokestatic x/ocd6bc26d10b.ѫ (Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/String;
      // 12b: astore 9
      // 12d: iload 2
      // 12e: aload 8
      // 130: invokevirtual java/lang/String.isEmpty ()Z
      // 133: iload 0
      // 134: ifne 147
      // 137: ifeq 146
      // 13a: aload 9
      // 13c: invokevirtual java/lang/String.isEmpty ()Z
      // 13f: iload 0
      // 140: ifne 147
      // 143: ifne 14a
      // 146: bipush 1
      // 147: goto 14b
      // 14a: bipush 0
      // 14b: ior
      // 14c: istore 2
      // 14d: getstatic x/ocd6bc26d10b.ʓ Ljava/util/List;
      // 150: new x/oc804fdd8d75
      // 153: dup
      // 154: aload 8
      // 156: aload 9
      // 158: aload 7
      // 15a: ldc_w "username"
      // 15d: invokestatic x/ocd6bc26d10b.ѫ (Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/String;
      // 160: aload 7
      // 162: ldc_w "unban"
      // 165: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 168: invokestatic java/util/Optional.ofNullable (Ljava/lang/Object;)Ljava/util/Optional;
      // 16b: invokedynamic apply ()Ljava/util/function/Function; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Ljava/lang/Object;, com/google/gson/JsonElement.getAsLong ()J, (Lcom/google/gson/JsonElement;)Ljava/lang/Long; ]
      // 170: invokevirtual java/util/Optional.map (Ljava/util/function/Function;)Ljava/util/Optional;
      // 173: lconst_0
      // 174: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 177: invokevirtual java/util/Optional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 17a: checkcast java/lang/Long
      // 17d: invokevirtual java/lang/Long.longValue ()J
      // 180: aload 7
      // 182: ldc_w "clientId"
      // 185: invokestatic x/ocd6bc26d10b.ѫ (Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/String;
      // 188: aload 7
      // 18a: ldc_w "scope"
      // 18d: invokestatic x/ocd6bc26d10b.ѫ (Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/String;
      // 190: aload 7
      // 192: ldc_w "type"
      // 195: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 198: invokestatic java/util/Optional.ofNullable (Ljava/lang/Object;)Ljava/util/Optional;
      // 19b: invokedynamic apply ()Ljava/util/function/Function; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Ljava/lang/Object;, com/google/gson/JsonElement.getAsString ()Ljava/lang/String;, (Lcom/google/gson/JsonElement;)Ljava/lang/String; ]
      // 1a0: invokevirtual java/util/Optional.map (Ljava/util/function/Function;)Ljava/util/Optional;
      // 1a3: ldc_w "premium"
      // 1a6: invokevirtual java/util/Optional.orElse (Ljava/lang/Object;)Ljava/lang/Object;
      // 1a9: checkcast java/lang/String
      // 1ac: aload 7
      // 1ae: ldc_w "uid"
      // 1b1: invokestatic x/ocd6bc26d10b.ѫ (Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/String;
      // 1b4: aload 7
      // 1b6: ldc_w "lastLogin"
      // 1b9: invokestatic x/ocd6bc26d10b.Ү (Lcom/google/gson/JsonObject;Ljava/lang/String;)J
      // 1bc: aload 7
      // 1be: ldc_w "playTime"
      // 1c1: invokestatic x/ocd6bc26d10b.Ү (Lcom/google/gson/JsonObject;Ljava/lang/String;)J
      // 1c4: aload 10
      // 1c6: invokespecial x/oc804fdd8d75.<init> (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;)V
      // 1c9: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 1ce: pop
      // 1cf: iload 0
      // 1d0: ifeq 062
      // 1d3: aload 3
      // 1d4: invokevirtual java/io/Reader.close ()V
      // 1d7: goto 1ef
      // 1da: astore 4
      // 1dc: aload 3
      // 1dd: invokevirtual java/io/Reader.close ()V
      // 1e0: goto 1ec
      // 1e3: astore 5
      // 1e5: aload 4
      // 1e7: aload 5
      // 1e9: invokevirtual java/lang/Throwable.addSuppressed (Ljava/lang/Throwable;)V
      // 1ec: aload 4
      // 1ee: athrow
      // 1ef: goto 211
      // 1f2: astore 3
      // 1f3: getstatic x/ocd6bc26d10b.ԝ Ljava/util/logging/Logger;
      // 1f6: getstatic java/util/logging/Level.WARNING Ljava/util/logging/Level;
      // 1f9: ldc_w "Couldn't find openmiau.accounts.json"
      // 1fc: aload 3
      // 1fd: invokevirtual java/util/logging/Logger.log (Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
      // 200: goto 211
      // 203: astore 3
      // 204: getstatic x/ocd6bc26d10b.ԝ Ljava/util/logging/Logger;
      // 207: getstatic java/util/logging/Level.WARNING Ljava/util/logging/Level;
      // 20a: ldc_w "Couldn't load openmiau.accounts.json"
      // 20d: aload 3
      // 20e: invokevirtual java/util/logging/Logger.log (Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
      // 211: iload 2
      // 212: iload 0
      // 213: ifne 21d
      // 216: ifeq 21c
      // 219: invokestatic x/ocd6bc26d10b.ζ ()V
      // 21c: bipush 0
      // 21d: putstatic x/ocd6bc26d10b.Ơ Z
      // 220: invokestatic java/lang/System.currentTimeMillis ()J
      // 223: putstatic x/ocd6bc26d10b.Մ J
      // 226: getstatic x/ocd6bc26d10b.Մ J
      // 229: putstatic x/ocd6bc26d10b.ů J
      // 22c: aload 1
      // 22d: monitorexit
      // 22e: goto 238
      // 231: astore 14
      // 233: aload 1
      // 234: monitorexit
      // 235: aload 14
      // 237: athrow
      // 238: bipush 0
      // 239: ifeq 24d
      // 23c: iload 0
      // 23d: ifeq 249
      // 240: goto 244
      // 243: athrow
      // 244: bipush 0
      // 245: goto 24a
      // 248: athrow
      // 249: bipush 1
      // 24a: putstatic keystrokesmod/oc4ef17ea060.ċ Z
      // 24d: return
   }

   public static void Շ() {
      synchronized (Ӹ) {
         ζ();
      }
   }

   public static void м(Session var0) {
      boolean var1 = oc4ef17ea060.ċ;

      try {
         if (var0 == null) {
            return;
         }
      } catch (IllegalArgumentException var6) {
         throw var6;
      }

      synchronized (Ӹ) {
         oc804fdd8d75 var3 = Ż(var0);
         if (!var1) {
            if (var3 == null) {
               return;
            }

            var3.Ɋ(var0.getUsername());
            var3.ѳ(var0.getPlayerID());
            var3.Ȧ(System.currentTimeMillis());
            Մ = System.currentTimeMillis();
            ζ();
         }
      }
   }

   public static void ɖ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic keystrokesmod/oc4ef17ea060.ċ Z
      // 03: getstatic x/ocd6bc26d10b.Ӹ Ljava/lang/Object;
      // 06: dup
      // 07: astore 1
      // 08: monitorenter
      // 09: istore 0
      // 0a: invokestatic java/lang/System.currentTimeMillis ()J
      // 0d: lstore 2
      // 0e: lconst_0
      // 0f: ldc2_w -5540579116491701415
      // 12: ldc2_w -5540579116491697967
      // 15: lxor
      // 16: lload 2
      // 17: getstatic x/ocd6bc26d10b.Մ J
      // 1a: lsub
      // 1b: invokestatic java/lang/Math.min (JJ)J
      // 1e: invokestatic java/lang/Math.max (JJ)J
      // 21: lstore 4
      // 23: lload 2
      // 24: putstatic x/ocd6bc26d10b.Մ J
      // 27: getstatic x/ocd6bc26d10b.ԗ Lnet/minecraft/client/Minecraft;
      // 2a: iload 0
      // 2b: ifne 37
      // 2e: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 31: ifnull 44
      // 34: getstatic x/ocd6bc26d10b.ԗ Lnet/minecraft/client/Minecraft;
      // 37: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 3a: ifnull 44
      // 3d: lload 4
      // 3f: lconst_0
      // 40: lcmp
      // 41: ifne 47
      // 44: aload 1
      // 45: monitorexit
      // 46: return
      // 47: invokestatic x/occ791aa07d0.þ ()Lnet/minecraft/util/Session;
      // 4a: invokestatic x/ocd6bc26d10b.Ż (Lnet/minecraft/util/Session;)Lx/oc804fdd8d75;
      // 4d: astore 6
      // 4f: iload 0
      // 50: ifne 6a
      // 53: aload 6
      // 55: ifnonnull 5b
      // 58: aload 1
      // 59: monitorexit
      // 5a: return
      // 5b: aload 6
      // 5d: lload 4
      // 5f: invokevirtual x/oc804fdd8d75.Ә (J)V
      // 62: iload 0
      // 63: bipush 1
      // 64: putstatic x/ocd6bc26d10b.Ơ Z
      // 67: ifne 7d
      // 6a: lload 2
      // 6b: getstatic x/ocd6bc26d10b.ů J
      // 6e: lsub
      // 6f: ldc2_w -5540579116491676191
      // 72: ldc2_w -5540579116491697967
      // 75: lxor
      // 76: lcmp
      // 77: iflt 81
      // 7a: invokestatic x/ocd6bc26d10b.ζ ()V
      // 7d: lload 2
      // 7e: putstatic x/ocd6bc26d10b.ů J
      // 81: aload 1
      // 82: monitorexit
      // 83: goto 8d
      // 86: astore 7
      // 88: aload 1
      // 89: monitorexit
      // 8a: aload 7
      // 8c: athrow
      // 8d: iload 0
      // 8e: ifeq a2
      // 91: bipush 0
      // 92: ifeq 9e
      // 95: goto 99
      // 98: athrow
      // 99: bipush 0
      // 9a: goto 9f
      // 9d: athrow
      // 9e: bipush 1
      // 9f: putstatic x/oc69da1aa7f5.Ҭ Z
      // a2: return
   }

   private static oc804fdd8d75 Ż(Session param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic keystrokesmod/oc4ef17ea060.ċ Z
      // 03: aload 0
      // 04: invokevirtual net/minecraft/util/Session.getToken ()Ljava/lang/String;
      // 07: astore 2
      // 08: istore 1
      // 09: aload 2
      // 0a: iload 1
      // 0b: ifne 7b
      // 0e: ifnull 77
      // 11: goto 15
      // 14: athrow
      // 15: aload 2
      // 16: iload 1
      // 17: ifne 7b
      // 1a: goto 1e
      // 1d: athrow
      // 1e: invokevirtual java/lang/String.isEmpty ()Z
      // 21: ifne 77
      // 24: goto 28
      // 27: athrow
      // 28: ldc_w "0"
      // 2b: iload 1
      // 2c: ifne 7b
      // 2f: goto 33
      // 32: athrow
      // 33: aload 2
      // 34: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 37: ifne 77
      // 3a: goto 3e
      // 3d: athrow
      // 3e: getstatic x/ocd6bc26d10b.ʓ Ljava/util/List;
      // 41: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 46: astore 3
      // 47: aload 3
      // 48: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 4d: ifeq 77
      // 50: aload 3
      // 51: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 56: checkcast x/oc804fdd8d75
      // 59: astore 4
      // 5b: aload 2
      // 5c: iload 1
      // 5d: ifne 7b
      // 60: aload 4
      // 62: invokevirtual x/oc804fdd8d75.Ć ()Ljava/lang/String;
      // 65: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 68: ifeq 73
      // 6b: goto 6f
      // 6e: athrow
      // 6f: aload 4
      // 71: areturn
      // 72: athrow
      // 73: iload 1
      // 74: ifeq 47
      // 77: aload 0
      // 78: invokevirtual net/minecraft/util/Session.getUsername ()Ljava/lang/String;
      // 7b: astore 3
      // 7c: getstatic x/ocd6bc26d10b.ʓ Ljava/util/List;
      // 7f: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 84: astore 4
      // 86: aload 4
      // 88: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 8d: ifeq bc
      // 90: aload 4
      // 92: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 97: checkcast x/oc804fdd8d75
      // 9a: astore 5
      // 9c: aload 3
      // 9d: iload 1
      // 9e: ifne a9
      // a1: ifnull b8
      // a4: goto a8
      // a7: athrow
      // a8: aload 3
      // a9: aload 5
      // ab: invokevirtual x/oc804fdd8d75.Ō ()Ljava/lang/String;
      // ae: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // b1: ifeq b8
      // b4: aload 5
      // b6: areturn
      // b7: athrow
      // b8: iload 1
      // b9: ifeq 86
      // bc: aconst_null
      // bd: areturn
   }

   private static void ζ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: getstatic keystrokesmod/oc4ef17ea060.ċ Z
      // 003: istore 0
      // 004: new com/google/gson/JsonArray
      // 007: dup
      // 008: invokespecial com/google/gson/JsonArray.<init> ()V
      // 00b: astore 1
      // 00c: new java/util/ArrayList
      // 00f: dup
      // 010: getstatic x/ocd6bc26d10b.ʓ Ljava/util/List;
      // 013: invokespecial java/util/ArrayList.<init> (Ljava/util/Collection;)V
      // 016: invokevirtual java/util/ArrayList.iterator ()Ljava/util/Iterator;
      // 019: astore 2
      // 01a: aload 2
      // 01b: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 020: ifeq 153
      // 023: aload 2
      // 024: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 029: checkcast x/oc804fdd8d75
      // 02c: astore 3
      // 02d: iload 0
      // 02e: ifne 285
      // 031: new com/google/gson/JsonObject
      // 034: dup
      // 035: invokespecial com/google/gson/JsonObject.<init> ()V
      // 038: astore 4
      // 03a: aload 3
      // 03b: invokevirtual x/oc804fdd8d75.ǣ ()Ljava/lang/String;
      // 03e: iload 0
      // 03f: ifne 054
      // 042: invokevirtual java/lang/String.isEmpty ()Z
      // 045: ifeq 070
      // 048: goto 04c
      // 04b: athrow
      // 04c: aload 3
      // 04d: invokevirtual x/oc804fdd8d75.Ć ()Ljava/lang/String;
      // 050: goto 054
      // 053: athrow
      // 054: iload 0
      // 055: ifne 06a
      // 058: invokevirtual java/lang/String.isEmpty ()Z
      // 05b: ifeq 070
      // 05e: goto 062
      // 061: athrow
      // 062: aload 3
      // 063: invokevirtual x/oc804fdd8d75.Ȣ ()Ljava/lang/String;
      // 066: goto 06a
      // 069: athrow
      // 06a: invokevirtual java/lang/String.isEmpty ()Z
      // 06d: ifne 0e0
      // 070: new com/google/gson/JsonObject
      // 073: dup
      // 074: invokespecial com/google/gson/JsonObject.<init> ()V
      // 077: astore 5
      // 079: aload 5
      // 07b: ldc "refreshToken"
      // 07d: aload 3
      // 07e: invokevirtual x/oc804fdd8d75.ǣ ()Ljava/lang/String;
      // 081: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/String;)V
      // 084: aload 5
      // 086: ldc "accessToken"
      // 088: aload 3
      // 089: invokevirtual x/oc804fdd8d75.Ć ()Ljava/lang/String;
      // 08c: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/String;)V
      // 08f: aload 5
      // 091: ldc_w "authData"
      // 094: aload 3
      // 095: invokevirtual x/oc804fdd8d75.Ȣ ()Ljava/lang/String;
      // 098: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/String;)V
      // 09b: new com/google/gson/JsonObject
      // 09e: dup
      // 09f: invokespecial com/google/gson/JsonObject.<init> ()V
      // 0a2: astore 6
      // 0a4: aload 6
      // 0a6: ldc_w "version"
      // 0a9: bipush 1
      // 0aa: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 0ad: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Number;)V
      // 0b0: aload 6
      // 0b2: ldc_w "mode"
      // 0b5: getstatic x/ocd6bc26d10b.ɢ Lx/oc59f0ab164a;
      // 0b8: invokeinterface x/oc59f0ab164a.z$3f9e4c95piano ()Ljava/lang/String; 1
      // 0bd: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/String;)V
      // 0c0: aload 6
      // 0c2: ldc "payload"
      // 0c4: getstatic x/ocd6bc26d10b.ɢ Lx/oc59f0ab164a;
      // 0c7: getstatic x/ocd6bc26d10b.ɚ Lcom/google/gson/Gson;
      // 0ca: aload 5
      // 0cc: invokevirtual com/google/gson/Gson.toJson (Lcom/google/gson/JsonElement;)Ljava/lang/String;
      // 0cf: invokeinterface x/oc59f0ab164a.z$2d18fe1ddtiun (Ljava/lang/String;)Ljava/lang/String; 2
      // 0d4: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/String;)V
      // 0d7: aload 4
      // 0d9: ldc "credentials"
      // 0db: aload 6
      // 0dd: invokevirtual com/google/gson/JsonObject.add (Ljava/lang/String;Lcom/google/gson/JsonElement;)V
      // 0e0: aload 4
      // 0e2: ldc_w "username"
      // 0e5: aload 3
      // 0e6: invokevirtual x/oc804fdd8d75.Ō ()Ljava/lang/String;
      // 0e9: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/String;)V
      // 0ec: iload 0
      // 0ed: aload 4
      // 0ef: ldc_w "unban"
      // 0f2: aload 3
      // 0f3: invokevirtual x/oc804fdd8d75.ʏ ()J
      // 0f6: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 0f9: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Number;)V
      // 0fc: aload 4
      // 0fe: ldc_w "clientId"
      // 101: aload 3
      // 102: invokevirtual x/oc804fdd8d75.Ұ ()Ljava/lang/String;
      // 105: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/String;)V
      // 108: aload 4
      // 10a: ldc_w "scope"
      // 10d: aload 3
      // 10e: invokevirtual x/oc804fdd8d75.ʳ ()Ljava/lang/String;
      // 111: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/String;)V
      // 114: aload 4
      // 116: ldc_w "type"
      // 119: aload 3
      // 11a: invokevirtual x/oc804fdd8d75.ż ()Ljava/lang/String;
      // 11d: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/String;)V
      // 120: aload 4
      // 122: ldc_w "uid"
      // 125: aload 3
      // 126: invokevirtual x/oc804fdd8d75.Ӽ ()Ljava/lang/String;
      // 129: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/String;)V
      // 12c: aload 4
      // 12e: ldc_w "lastLogin"
      // 131: aload 3
      // 132: invokevirtual x/oc804fdd8d75.Ύ ()J
      // 135: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 138: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Number;)V
      // 13b: aload 4
      // 13d: ldc_w "playTime"
      // 140: aload 3
      // 141: invokevirtual x/oc804fdd8d75.B ()J
      // 144: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 147: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Number;)V
      // 14a: aload 1
      // 14b: aload 4
      // 14d: invokevirtual com/google/gson/JsonArray.add (Lcom/google/gson/JsonElement;)V
      // 150: ifeq 01a
      // 153: getstatic x/ocd6bc26d10b.ɤ Ljava/io/File;
      // 156: invokevirtual java/io/File.getParentFile ()Ljava/io/File;
      // 159: astore 2
      // 15a: aload 2
      // 15b: iload 0
      // 15c: ifne 197
      // 15f: ifnull 182
      // 162: goto 166
      // 165: athrow
      // 166: aload 2
      // 167: iload 0
      // 168: ifne 197
      // 16b: goto 16f
      // 16e: athrow
      // 16f: invokevirtual java/io/File.exists ()Z
      // 172: ifne 182
      // 175: goto 179
      // 178: athrow
      // 179: aload 2
      // 17a: invokevirtual java/io/File.mkdirs ()Z
      // 17d: pop
      // 17e: goto 182
      // 181: athrow
      // 182: new java/io/File
      // 185: dup
      // 186: getstatic x/ocd6bc26d10b.ɤ Ljava/io/File;
      // 189: invokevirtual java/io/File.getPath ()Ljava/lang/String;
      // 18c: ldc_w ".tmp"
      // 18f: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 194: invokespecial java/io/File.<init> (Ljava/lang/String;)V
      // 197: astore 3
      // 198: new java/io/File
      // 19b: dup
      // 19c: getstatic x/ocd6bc26d10b.ɤ Ljava/io/File;
      // 19f: invokevirtual java/io/File.getPath ()Ljava/lang/String;
      // 1a2: ldc_w ".bak"
      // 1a5: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 1aa: invokespecial java/io/File.<init> (Ljava/lang/String;)V
      // 1ad: astore 4
      // 1af: new java/io/OutputStreamWriter
      // 1b2: dup
      // 1b3: new java/io/FileOutputStream
      // 1b6: dup
      // 1b7: aload 3
      // 1b8: invokespecial java/io/FileOutputStream.<init> (Ljava/io/File;)V
      // 1bb: getstatic java/nio/charset/StandardCharsets.UTF_8 Ljava/nio/charset/Charset;
      // 1be: invokespecial java/io/OutputStreamWriter.<init> (Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
      // 1c1: astore 5
      // 1c3: getstatic x/ocd6bc26d10b.ɚ Lcom/google/gson/Gson;
      // 1c6: aload 1
      // 1c7: aload 5
      // 1c9: invokevirtual com/google/gson/Gson.toJson (Lcom/google/gson/JsonElement;Ljava/lang/Appendable;)V
      // 1cc: aload 5
      // 1ce: invokevirtual java/io/Writer.close ()V
      // 1d1: goto 1ea
      // 1d4: astore 6
      // 1d6: aload 5
      // 1d8: invokevirtual java/io/Writer.close ()V
      // 1db: goto 1e7
      // 1de: astore 7
      // 1e0: aload 6
      // 1e2: aload 7
      // 1e4: invokevirtual java/lang/Throwable.addSuppressed (Ljava/lang/Throwable;)V
      // 1e7: aload 6
      // 1e9: athrow
      // 1ea: getstatic x/ocd6bc26d10b.ɤ Ljava/io/File;
      // 1ed: iload 0
      // 1ee: ifne 230
      // 1f1: invokevirtual java/io/File.isFile ()Z
      // 1f4: ifeq 22f
      // 1f7: goto 1fb
      // 1fa: athrow
      // 1fb: getstatic x/ocd6bc26d10b.ɤ Ljava/io/File;
      // 1fe: iload 0
      // 1ff: ifne 230
      // 202: goto 206
      // 205: athrow
      // 206: invokevirtual java/io/File.length ()J
      // 209: lconst_0
      // 20a: lcmp
      // 20b: ifle 22f
      // 20e: goto 212
      // 211: athrow
      // 212: getstatic x/ocd6bc26d10b.ɤ Ljava/io/File;
      // 215: invokevirtual java/io/File.toPath ()Ljava/nio/file/Path;
      // 218: aload 4
      // 21a: invokevirtual java/io/File.toPath ()Ljava/nio/file/Path;
      // 21d: bipush 1
      // 21e: anewarray 558
      // 221: dup
      // 222: bipush 0
      // 223: getstatic java/nio/file/StandardCopyOption.REPLACE_EXISTING Ljava/nio/file/StandardCopyOption;
      // 226: aastore
      // 227: invokestatic java/nio/file/Files.copy (Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/CopyOption;)Ljava/nio/file/Path;
      // 22a: pop
      // 22b: goto 22f
      // 22e: athrow
      // 22f: aload 3
      // 230: invokevirtual java/io/File.toPath ()Ljava/nio/file/Path;
      // 233: getstatic x/ocd6bc26d10b.ɤ Ljava/io/File;
      // 236: invokevirtual java/io/File.toPath ()Ljava/nio/file/Path;
      // 239: ldc_w -147915139
      // 23c: ldc_w -147915137
      // 23f: ixor
      // 240: anewarray 558
      // 243: dup
      // 244: bipush 0
      // 245: getstatic java/nio/file/StandardCopyOption.REPLACE_EXISTING Ljava/nio/file/StandardCopyOption;
      // 248: aastore
      // 249: dup
      // 24a: bipush 1
      // 24b: getstatic java/nio/file/StandardCopyOption.ATOMIC_MOVE Ljava/nio/file/StandardCopyOption;
      // 24e: aastore
      // 24f: invokestatic java/nio/file/Files.move (Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/CopyOption;)Ljava/nio/file/Path;
      // 252: pop
      // 253: goto 270
      // 256: astore 5
      // 258: aload 3
      // 259: invokevirtual java/io/File.toPath ()Ljava/nio/file/Path;
      // 25c: getstatic x/ocd6bc26d10b.ɤ Ljava/io/File;
      // 25f: invokevirtual java/io/File.toPath ()Ljava/nio/file/Path;
      // 262: bipush 1
      // 263: anewarray 558
      // 266: dup
      // 267: bipush 0
      // 268: getstatic java/nio/file/StandardCopyOption.REPLACE_EXISTING Ljava/nio/file/StandardCopyOption;
      // 26b: aastore
      // 26c: invokestatic java/nio/file/Files.move (Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/CopyOption;)Ljava/nio/file/Path;
      // 26f: pop
      // 270: bipush 0
      // 271: putstatic x/ocd6bc26d10b.Ơ Z
      // 274: goto 285
      // 277: astore 1
      // 278: getstatic x/ocd6bc26d10b.ԝ Ljava/util/logging/Logger;
      // 27b: getstatic java/util/logging/Level.WARNING Ljava/util/logging/Level;
      // 27e: ldc_w "Couldn't save openmiau.accounts.json"
      // 281: aload 1
      // 282: invokevirtual java/util/logging/Logger.log (Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
      // 285: return
   }

   private static String ѫ(JsonObject var0, String var1) {
      return Optional.ofNullable(var0.get(var1)).<String>map(JsonElement::getAsString).orElse("");
   }

   private static long Ү(JsonObject var0, String var1) {
      return Optional.ofNullable(var0.get(var1)).<Long>map(JsonElement::getAsLong).orElse(0L);
   }

   private static String é(JsonObject param0, String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic keystrokesmod/oc4ef17ea060.ċ Z
      // 03: istore 2
      // 04: aload 0
      // 05: aload 1
      // 06: iload 2
      // 07: ifne 1a
      // 0a: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 0d: ifeq 3a
      // 10: goto 14
      // 13: athrow
      // 14: aload 0
      // 15: aload 1
      // 16: goto 1a
      // 19: athrow
      // 1a: iload 2
      // 1b: ifne 31
      // 1e: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 21: invokevirtual com/google/gson/JsonElement.isJsonNull ()Z
      // 24: ifne 3a
      // 27: goto 2b
      // 2a: athrow
      // 2b: aload 0
      // 2c: aload 1
      // 2d: goto 31
      // 30: athrow
      // 31: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 34: invokevirtual com/google/gson/JsonElement.getAsString ()Ljava/lang/String;
      // 37: goto 3c
      // 3a: ldc ""
      // 3c: areturn
   }
}

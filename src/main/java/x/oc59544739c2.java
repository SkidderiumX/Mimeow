package x;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.IOException;
import net.minecraft.client.Minecraft;

public class oc59544739c2 {
   private static final Gson կ = new GsonBuilder().setPrettyPrinting().create();
   private final File ȭ = new File(Minecraft.getMinecraft().mcDataDir, "Miau_Music.json");
   private JsonObject ԓ = new JsonObject();
   private final oc59f0ab164a č = oc8a51e14bb3.Ć();
   public static int Η;

   public synchronized void V() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocbb1bc27172.ԍ I
      // 03: istore 1
      // 04: iload 1
      // 05: aload 0
      // 06: aload 0
      // 07: aload 0
      // 08: getfield x/oc59544739c2.ȭ Ljava/io/File;
      // 0b: invokevirtual x/oc59544739c2.Җ (Ljava/io/File;)Lcom/google/gson/JsonObject;
      // 0e: putfield x/oc59544739c2.ԓ Lcom/google/gson/JsonObject;
      // 11: ifne 33
      // 14: aload 0
      // 15: getfield x/oc59544739c2.ԓ Lcom/google/gson/JsonObject;
      // 18: invokevirtual com/google/gson/JsonObject.entrySet ()Ljava/util/Set;
      // 1b: invokeinterface java/util/Set.isEmpty ()Z 1
      // 20: ifeq 2f
      // 23: goto 27
      // 26: athrow
      // 27: aload 0
      // 28: invokevirtual x/oc59544739c2.Û ()V
      // 2b: goto 2f
      // 2e: athrow
      // 2f: aload 0
      // 30: invokevirtual x/oc59544739c2.Ɍ ()V
      // 33: return
   }

   public synchronized String ç(String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocbb1bc27172.ԍ I
      // 03: istore 2
      // 04: aload 0
      // 05: getfield x/oc59544739c2.ԓ Lcom/google/gson/JsonObject;
      // 08: aload 1
      // 09: iload 2
      // 0a: ifne 28
      // 0d: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 10: ifeq 43
      // 13: goto 17
      // 16: athrow
      // 17: aload 0
      // 18: getfield x/oc59544739c2.ԓ Lcom/google/gson/JsonObject;
      // 1b: iload 2
      // 1c: ifne 3d
      // 1f: goto 23
      // 22: athrow
      // 23: aload 1
      // 24: goto 28
      // 27: athrow
      // 28: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 2b: invokevirtual com/google/gson/JsonElement.isJsonNull ()Z
      // 2e: ifne 43
      // 31: aload 0
      // 32: getfield x/oc59544739c2.ԓ Lcom/google/gson/JsonObject;
      // 35: aload 1
      // 36: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 39: goto 3d
      // 3c: athrow
      // 3d: invokevirtual com/google/gson/JsonElement.getAsString ()Ljava/lang/String;
      // 40: goto 45
      // 43: ldc ""
      // 45: areturn
   }

   public synchronized void Й(String var1, String var2) {
      int var3 = ocbb1bc27172.ԍ;

      JsonObject var10000;
      String var10001;
      String var10002;
      label22: {
         label21: {
            try {
               var10000 = this.ԓ;
               var10001 = var1;
               var10002 = var2;
               if (var3 != 0) {
                  break label22;
               }

               if (var2 == null) {
                  break label21;
               }
            } catch (ocbde1165e4e var4) {
               throw var4;
            }

            var10002 = var2;
            break label22;
         }

         var10002 = "";
      }

      var10000.addProperty(var10001, var10002);
   }

   public synchronized oc5a0c1fbe1c ժ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocbb1bc27172.ԍ I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 1d
      // 09: getfield x/oc59544739c2.ԓ Lcom/google/gson/JsonObject;
      // 0c: ldc "spotify_tokens"
      // 0e: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 11: ifeq 33
      // 14: goto 18
      // 17: athrow
      // 18: aload 0
      // 19: goto 1d
      // 1c: athrow
      // 1d: iload 1
      // 1e: ifne 38
      // 21: getfield x/oc59544739c2.ԓ Lcom/google/gson/JsonObject;
      // 24: ldc "spotify_tokens"
      // 26: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 29: invokevirtual com/google/gson/JsonElement.isJsonObject ()Z
      // 2c: ifne 37
      // 2f: goto 33
      // 32: athrow
      // 33: getstatic x/oc5a0c1fbe1c.Ĭ Lx/oc5a0c1fbe1c;
      // 36: areturn
      // 37: aload 0
      // 38: getfield x/oc59544739c2.ԓ Lcom/google/gson/JsonObject;
      // 3b: ldc "spotify_tokens"
      // 3d: invokevirtual com/google/gson/JsonObject.getAsJsonObject (Ljava/lang/String;)Lcom/google/gson/JsonObject;
      // 40: astore 2
      // 41: aload 0
      // 42: getfield x/oc59544739c2.č Lx/oc59f0ab164a;
      // 45: aload 2
      // 46: ldc "payload"
      // 48: invokestatic x/oc59544739c2.ŉ (Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/String;
      // 4b: invokeinterface x/oc59f0ab164a.z$3gaj86hkfeiuj (Ljava/lang/String;)Ljava/lang/String; 2
      // 50: astore 3
      // 51: new com/google/gson/JsonParser
      // 54: dup
      // 55: invokespecial com/google/gson/JsonParser.<init> ()V
      // 58: aload 3
      // 59: invokevirtual com/google/gson/JsonParser.parse (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 5c: invokevirtual com/google/gson/JsonElement.getAsJsonObject ()Lcom/google/gson/JsonObject;
      // 5f: astore 4
      // 61: new x/oc5a0c1fbe1c
      // 64: dup
      // 65: aload 4
      // 67: ldc "access"
      // 69: invokestatic x/oc59544739c2.ŉ (Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/String;
      // 6c: aload 4
      // 6e: ldc "refresh"
      // 70: invokestatic x/oc59544739c2.ŉ (Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/String;
      // 73: aload 4
      // 75: ldc "expires_at"
      // 77: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 7a: ifeq 8b
      // 7d: aload 4
      // 7f: ldc "expires_at"
      // 81: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 84: invokevirtual com/google/gson/JsonElement.getAsLong ()J
      // 87: goto 8c
      // 8a: athrow
      // 8b: lconst_0
      // 8c: invokespecial x/oc5a0c1fbe1c.<init> (Ljava/lang/String;Ljava/lang/String;J)V
      // 8f: areturn
      // 90: astore 2
      // 91: getstatic x/oc5a0c1fbe1c.Ĭ Lx/oc5a0c1fbe1c;
      // 94: areturn
   }

   public synchronized void Ƶ(oc5a0c1fbe1c var1) throws IOException {
      int var2 = ocbb1bc27172.ԍ;

      try {
         JsonObject var3 = new JsonObject();
         var3.addProperty("access", var1.ȋ());
         var3.addProperty("refresh", var1.Տ());
         var3.addProperty("expires_at", var1.ț());
         JsonObject var4 = new JsonObject();
         var4.addProperty("version", 1);
         var4.addProperty("mode", this.č.z$3f9e4c95piano());
         var4.addProperty("payload", this.č.z$2d18fe1ddtiun(կ.toJson(var3)));
         this.ԓ.add("spotify_tokens", var4);
         this.ԓ.remove("spotify_access_token");
         this.ԓ.remove("spotify_refresh_token");
         this.ʡ();
      } catch (IOException var6) {
         throw var6;
      } catch (Exception var7) {
         throw new IOException("Could not protect Spotify tokens");
      }

      try {
         if (false) {
            ocbb1bc27172.ԍ = ++var2;
         }
      } catch (IOException var5) {
         throw var5;
      }
   }

   public synchronized void ƀ() throws IOException {
      this.ԓ.remove("spotify_tokens");
      this.ԓ.remove("spotify_access_token");
      this.ԓ.remove("spotify_refresh_token");
      this.ʡ();
   }

   public synchronized boolean ĥ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocbb1bc27172.ԍ I
      // 03: aload 0
      // 04: invokevirtual x/oc59544739c2.ժ ()Lx/oc5a0c1fbe1c;
      // 07: astore 2
      // 08: istore 1
      // 09: aload 2
      // 0a: invokevirtual x/oc5a0c1fbe1c.ţ ()Z
      // 0d: iload 1
      // 0e: ifne 2c
      // 11: ifne 2b
      // 14: goto 18
      // 17: athrow
      // 18: aload 2
      // 19: invokevirtual x/oc5a0c1fbe1c.Ҡ ()Z
      // 1c: iload 1
      // 1d: ifne 2c
      // 20: goto 24
      // 23: athrow
      // 24: ifeq 2f
      // 27: goto 2b
      // 2a: athrow
      // 2b: bipush 1
      // 2c: goto 30
      // 2f: bipush 0
      // 30: ireturn
   }

   public synchronized void ʭ() throws IOException {
      this.ԓ = new JsonObject();
      this.ʡ();
   }

   public synchronized void ʡ() throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/ocbb1bc27172.ԍ I
      // 003: aload 0
      // 004: getfield x/oc59544739c2.ȭ Ljava/io/File;
      // 007: invokevirtual java/io/File.getParentFile ()Ljava/io/File;
      // 00a: astore 2
      // 00b: istore 1
      // 00c: aload 2
      // 00d: iload 1
      // 00e: ifne 04a
      // 011: ifnull 034
      // 014: goto 018
      // 017: athrow
      // 018: aload 2
      // 019: iload 1
      // 01a: ifne 04a
      // 01d: goto 021
      // 020: athrow
      // 021: invokevirtual java/io/File.exists ()Z
      // 024: ifne 034
      // 027: goto 02b
      // 02a: athrow
      // 02b: aload 2
      // 02c: invokevirtual java/io/File.mkdirs ()Z
      // 02f: pop
      // 030: goto 034
      // 033: athrow
      // 034: new java/io/File
      // 037: dup
      // 038: aload 0
      // 039: getfield x/oc59544739c2.ȭ Ljava/io/File;
      // 03c: invokevirtual java/io/File.getPath ()Ljava/lang/String;
      // 03f: ldc_w ".tmp"
      // 042: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 047: invokespecial java/io/File.<init> (Ljava/lang/String;)V
      // 04a: astore 3
      // 04b: new java/io/File
      // 04e: dup
      // 04f: aload 0
      // 050: getfield x/oc59544739c2.ȭ Ljava/io/File;
      // 053: invokevirtual java/io/File.getPath ()Ljava/lang/String;
      // 056: ldc_w ".bak"
      // 059: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 05e: invokespecial java/io/File.<init> (Ljava/lang/String;)V
      // 061: astore 4
      // 063: new java/io/OutputStreamWriter
      // 066: dup
      // 067: new java/io/FileOutputStream
      // 06a: dup
      // 06b: aload 3
      // 06c: invokespecial java/io/FileOutputStream.<init> (Ljava/io/File;)V
      // 06f: getstatic java/nio/charset/StandardCharsets.UTF_8 Ljava/nio/charset/Charset;
      // 072: invokespecial java/io/OutputStreamWriter.<init> (Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
      // 075: astore 5
      // 077: getstatic x/oc59544739c2.կ Lcom/google/gson/Gson;
      // 07a: aload 0
      // 07b: getfield x/oc59544739c2.ԓ Lcom/google/gson/JsonObject;
      // 07e: aload 5
      // 080: invokevirtual com/google/gson/Gson.toJson (Lcom/google/gson/JsonElement;Ljava/lang/Appendable;)V
      // 083: aload 5
      // 085: invokevirtual java/io/Writer.close ()V
      // 088: goto 0a1
      // 08b: astore 6
      // 08d: aload 5
      // 08f: invokevirtual java/io/Writer.close ()V
      // 092: goto 09e
      // 095: astore 7
      // 097: aload 6
      // 099: aload 7
      // 09b: invokevirtual java/lang/Throwable.addSuppressed (Ljava/lang/Throwable;)V
      // 09e: aload 6
      // 0a0: athrow
      // 0a1: aload 0
      // 0a2: getfield x/oc59544739c2.ȭ Ljava/io/File;
      // 0a5: iload 1
      // 0a6: ifne 0d2
      // 0a9: invokevirtual java/io/File.isFile ()Z
      // 0ac: ifeq 0d1
      // 0af: goto 0b3
      // 0b2: athrow
      // 0b3: aload 0
      // 0b4: getfield x/oc59544739c2.ȭ Ljava/io/File;
      // 0b7: invokevirtual java/io/File.toPath ()Ljava/nio/file/Path;
      // 0ba: aload 4
      // 0bc: invokevirtual java/io/File.toPath ()Ljava/nio/file/Path;
      // 0bf: bipush 1
      // 0c0: anewarray 308
      // 0c3: dup
      // 0c4: bipush 0
      // 0c5: getstatic java/nio/file/StandardCopyOption.REPLACE_EXISTING Ljava/nio/file/StandardCopyOption;
      // 0c8: aastore
      // 0c9: invokestatic java/nio/file/Files.copy (Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/CopyOption;)Ljava/nio/file/Path;
      // 0cc: pop
      // 0cd: goto 0d1
      // 0d0: athrow
      // 0d1: aload 3
      // 0d2: invokevirtual java/io/File.toPath ()Ljava/nio/file/Path;
      // 0d5: aload 0
      // 0d6: getfield x/oc59544739c2.ȭ Ljava/io/File;
      // 0d9: invokevirtual java/io/File.toPath ()Ljava/nio/file/Path;
      // 0dc: ldc_w -1793891531
      // 0df: ldc_w -1793891529
      // 0e2: ixor
      // 0e3: anewarray 308
      // 0e6: dup
      // 0e7: bipush 0
      // 0e8: getstatic java/nio/file/StandardCopyOption.REPLACE_EXISTING Ljava/nio/file/StandardCopyOption;
      // 0eb: aastore
      // 0ec: dup
      // 0ed: bipush 1
      // 0ee: getstatic java/nio/file/StandardCopyOption.ATOMIC_MOVE Ljava/nio/file/StandardCopyOption;
      // 0f1: aastore
      // 0f2: invokestatic java/nio/file/Files.move (Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/CopyOption;)Ljava/nio/file/Path;
      // 0f5: pop
      // 0f6: goto 114
      // 0f9: astore 5
      // 0fb: aload 3
      // 0fc: invokevirtual java/io/File.toPath ()Ljava/nio/file/Path;
      // 0ff: aload 0
      // 100: getfield x/oc59544739c2.ȭ Ljava/io/File;
      // 103: invokevirtual java/io/File.toPath ()Ljava/nio/file/Path;
      // 106: bipush 1
      // 107: anewarray 308
      // 10a: dup
      // 10b: bipush 0
      // 10c: getstatic java/nio/file/StandardCopyOption.REPLACE_EXISTING Ljava/nio/file/StandardCopyOption;
      // 10f: aastore
      // 110: invokestatic java/nio/file/Files.move (Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/CopyOption;)Ljava/nio/file/Path;
      // 113: pop
      // 114: return
   }

   private JsonObject Җ(File var1) {
      int var10000 = ocbb1bc27172.ԍ;
      JsonObject var3 = this.C(var1);
      int var2 = var10000;

      try {
         if (var2 != 0) {
            return var3;
         }

         if (!var3.entrySet().isEmpty()) {
            return var3;
         }
      } catch (ocbde1165e4e var4) {
         throw var4;
      }

      return this.C(new File(var1.getPath() + ".bak"));
   }

   private JsonObject C(File param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocbb1bc27172.ԍ I
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 18
      // 09: invokevirtual java/io/File.isFile ()Z
      // 0c: ifeq 26
      // 0f: goto 13
      // 12: athrow
      // 13: aload 1
      // 14: goto 18
      // 17: athrow
      // 18: invokevirtual java/io/File.length ()J
      // 1b: ldc2_w -2779505776515788708
      // 1e: ldc2_w -2779505776514740132
      // 21: lxor
      // 22: lcmp
      // 23: ifle 2f
      // 26: new com/google/gson/JsonObject
      // 29: dup
      // 2a: invokespecial com/google/gson/JsonObject.<init> ()V
      // 2d: areturn
      // 2e: athrow
      // 2f: new java/io/InputStreamReader
      // 32: dup
      // 33: new java/io/FileInputStream
      // 36: dup
      // 37: aload 1
      // 38: invokespecial java/io/FileInputStream.<init> (Ljava/io/File;)V
      // 3b: getstatic java/nio/charset/StandardCharsets.UTF_8 Ljava/nio/charset/Charset;
      // 3e: invokespecial java/io/InputStreamReader.<init> (Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
      // 41: astore 3
      // 42: new com/google/gson/JsonParser
      // 45: dup
      // 46: invokespecial com/google/gson/JsonParser.<init> ()V
      // 49: aload 3
      // 4a: invokevirtual com/google/gson/JsonParser.parse (Ljava/io/Reader;)Lcom/google/gson/JsonElement;
      // 4d: astore 4
      // 4f: aload 4
      // 51: iload 2
      // 52: ifne 65
      // 55: invokevirtual com/google/gson/JsonElement.isJsonObject ()Z
      // 58: ifeq 6b
      // 5b: goto 5f
      // 5e: athrow
      // 5f: aload 4
      // 61: goto 65
      // 64: athrow
      // 65: invokevirtual com/google/gson/JsonElement.getAsJsonObject ()Lcom/google/gson/JsonObject;
      // 68: goto 72
      // 6b: new com/google/gson/JsonObject
      // 6e: dup
      // 6f: invokespecial com/google/gson/JsonObject.<init> ()V
      // 72: astore 5
      // 74: aload 3
      // 75: invokevirtual java/io/Reader.close ()V
      // 78: aload 5
      // 7a: areturn
      // 7b: astore 4
      // 7d: aload 3
      // 7e: invokevirtual java/io/Reader.close ()V
      // 81: goto 8d
      // 84: astore 5
      // 86: aload 4
      // 88: aload 5
      // 8a: invokevirtual java/lang/Throwable.addSuppressed (Ljava/lang/Throwable;)V
      // 8d: aload 4
      // 8f: athrow
      // 90: astore 3
      // 91: new com/google/gson/JsonObject
      // 94: dup
      // 95: invokespecial com/google/gson/JsonObject.<init> ()V
      // 98: areturn
   }

   private void Û() {
      JsonObject var1 = this.C(new File(this.ȭ.getParentFile(), "Miau_LastFm.json"));
      String[] var10003 = new String[433174481 ^ 433174482];
      var10003[0] = "lastfm_user";
      var10003[1] = "user";
      var10003[433174480 ^ 433174482] = "username";
      this.а(var1, "lastfm_user", var10003);
      var10003 = new String[433174481 ^ 433174482];
      var10003[0] = "lastfm_key";
      var10003[1] = "key";
      var10003[433174480 ^ 433174482] = "api_key";
      this.а(var1, "lastfm_key", var10003);
      var10003 = new String[433174480 ^ 433174482];
      var10003[0] = "spotify_client_id";
      var10003[1] = "client_id";
      this.а(var1, "spotify_client_id", var10003);
      JsonObject var2 = this.C(new File(this.ȭ.getParentFile(), "Miau_Spotify.json"));
      var10003 = new String[433174480 ^ 433174482];
      var10003[0] = "spotify_client_id";
      var10003[1] = "client_id";
      this.а(var2, "spotify_client_id", var10003);
      var10003 = new String[433174480 ^ 433174482];
      var10003[0] = "spotify_access_token";
      var10003[1] = "access_token";
      this.а(var2, "spotify_access_token", var10003);
      var10003 = new String[433174480 ^ 433174482];
      var10003[0] = "spotify_refresh_token";
      var10003[1] = "refresh_token";
      this.а(var2, "spotify_refresh_token", var10003);

      try {
         this.ʡ();
      } catch (IOException var4) {
      }
   }

   private void Ɍ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocbb1bc27172.ԍ I
      // 03: aload 0
      // 04: ldc "spotify_access_token"
      // 06: invokevirtual x/oc59544739c2.ç (Ljava/lang/String;)Ljava/lang/String;
      // 09: astore 2
      // 0a: istore 1
      // 0b: aload 0
      // 0c: ldc "spotify_refresh_token"
      // 0e: invokevirtual x/oc59544739c2.ç (Ljava/lang/String;)Ljava/lang/String;
      // 11: astore 3
      // 12: iload 1
      // 13: ifne 3c
      // 16: aload 2
      // 17: invokevirtual java/lang/String.isEmpty ()Z
      // 1a: ifeq 2e
      // 1d: goto 21
      // 20: athrow
      // 21: aload 3
      // 22: invokevirtual java/lang/String.isEmpty ()Z
      // 25: ifeq 2e
      // 28: goto 2c
      // 2b: athrow
      // 2c: return
      // 2d: athrow
      // 2e: aload 0
      // 2f: new x/oc5a0c1fbe1c
      // 32: dup
      // 33: aload 2
      // 34: aload 3
      // 35: lconst_0
      // 36: invokespecial x/oc5a0c1fbe1c.<init> (Ljava/lang/String;Ljava/lang/String;J)V
      // 39: invokevirtual x/oc59544739c2.Ƶ (Lx/oc5a0c1fbe1c;)V
      // 3c: goto 41
      // 3f: astore 4
      // 41: return
   }

   private void а(JsonObject param1, String param2, String... param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocbb1bc27172.ԍ I
      // 03: aload 3
      // 04: astore 5
      // 06: istore 4
      // 08: aload 5
      // 0a: arraylength
      // 0b: istore 6
      // 0d: bipush 0
      // 0e: istore 7
      // 10: iload 7
      // 12: iload 6
      // 14: if_icmpge 67
      // 17: aload 5
      // 19: iload 7
      // 1b: aaload
      // 1c: astore 8
      // 1e: iload 4
      // 20: ifne 62
      // 23: aload 1
      // 24: aload 8
      // 26: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 29: ifeq 5f
      // 2c: goto 30
      // 2f: athrow
      // 30: aload 1
      // 31: iload 4
      // 33: ifne 51
      // 36: goto 3a
      // 39: athrow
      // 3a: aload 8
      // 3c: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 3f: invokevirtual com/google/gson/JsonElement.isJsonNull ()Z
      // 42: ifne 5f
      // 45: goto 49
      // 48: athrow
      // 49: aload 0
      // 4a: getfield x/oc59544739c2.ԓ Lcom/google/gson/JsonObject;
      // 4d: goto 51
      // 50: athrow
      // 51: aload 2
      // 52: aload 1
      // 53: aload 8
      // 55: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 58: invokevirtual com/google/gson/JsonElement.getAsString ()Ljava/lang/String;
      // 5b: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/String;)V
      // 5e: return
      // 5f: iinc 7 1
      // 62: iload 4
      // 64: ifeq 10
      // 67: return
   }

   private static String ŉ(JsonObject param0, String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocbb1bc27172.ԍ I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 25
      // 09: aload 1
      // 0a: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 0d: ifeq 3a
      // 10: goto 14
      // 13: athrow
      // 14: aload 0
      // 15: iload 2
      // 16: ifne 34
      // 19: goto 1d
      // 1c: athrow
      // 1d: aload 1
      // 1e: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 21: goto 25
      // 24: athrow
      // 25: invokevirtual com/google/gson/JsonElement.isJsonNull ()Z
      // 28: ifne 3a
      // 2b: aload 0
      // 2c: aload 1
      // 2d: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 30: goto 34
      // 33: athrow
      // 34: invokevirtual com/google/gson/JsonElement.getAsString ()Ljava/lang/String;
      // 37: goto 3c
      // 3a: ldc ""
      // 3c: areturn
   }
}

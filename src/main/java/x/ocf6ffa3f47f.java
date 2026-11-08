package x;

import java.io.File;

public class ocf6ffa3f47f extends oc69da1aa7f5 {
   public static final String վ = "autoauth.json";
   private static final String[] ռ;
   private static final String[] Ц;
   private final oc321b4679dd ԇ;
   private final occ2f8dff8d8 Ҥ;
   private boolean Ѧ;
   private boolean Ƿ;
   private boolean đ;
   public static boolean Ș;

   public ocf6ffa3f47f() {
      super("AutoAuth", oce4cea752dd.з, 0);
      this.ą("Automatically login and register on Cracked servers.");
      this.ʌ(this.ԇ = new oc23d9bdf408(this, "Password", "miauclient67", "Type an authentication password...", 1929915638 ^ 1929915574, this::Ґ).Ӂ(true));
      this.ʌ(this.Ҥ = new occ2f8dff8d8("Double password", true));
      this.ʮ();
   }

   public static File Ӎ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 0
      // 04: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 07: iload 0
      // 08: ifne 15
      // 0b: ifnull 23
      // 0e: goto 12
      // 11: athrow
      // 12: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 15: getfield net/minecraft/client/Minecraft.mcDataDir Ljava/io/File;
      // 18: iload 0
      // 19: ifne 38
      // 1c: ifnonnull 26
      // 1f: goto 23
      // 22: athrow
      // 23: aconst_null
      // 24: areturn
      // 25: athrow
      // 26: new java/io/File
      // 29: dup
      // 2a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 2d: getfield net/minecraft/client/Minecraft.mcDataDir Ljava/io/File;
      // 30: invokestatic x/oc8ccd9c3f55.պ (Ljava/io/File;)Ljava/io/File;
      // 33: ldc "autoauth.json"
      // 35: invokespecial java/io/File.<init> (Ljava/io/File;Ljava/lang/String;)V
      // 38: astore 1
      // 39: aload 1
      // 3a: iload 0
      // 3b: ifne 66
      // 3e: invokevirtual java/io/File.exists ()Z
      // 41: ifne 65
      // 44: goto 48
      // 47: athrow
      // 48: new java/io/File
      // 4b: dup
      // 4c: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 4f: getfield net/minecraft/client/Minecraft.mcDataDir Ljava/io/File;
      // 52: invokestatic x/oc8ccd9c3f55.ζ (Ljava/io/File;)Ljava/io/File;
      // 55: ldc "autoauth.json"
      // 57: invokespecial java/io/File.<init> (Ljava/io/File;Ljava/lang/String;)V
      // 5a: astore 2
      // 5b: aload 2
      // 5c: aload 1
      // 5d: invokestatic x/oc8ccd9c3f55.ϡ (Ljava/io/File;Ljava/io/File;)Z
      // 60: pop
      // 61: goto 65
      // 64: astore 3
      // 65: aload 1
      // 66: areturn
   }

   public void ʮ() {
      File var1 = Ӎ();

      try {
         if (var1 != null) {
            this.ŧ(var1);
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }
   }

   public void ŧ(File param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 2
      // 004: aload 1
      // 005: iload 2
      // 006: ifne 011
      // 009: ifnull 02a
      // 00c: goto 010
      // 00f: athrow
      // 010: aload 1
      // 011: iload 2
      // 012: ifne 024
      // 015: invokevirtual java/io/File.exists ()Z
      // 018: ifeq 02a
      // 01b: goto 01f
      // 01e: athrow
      // 01f: aload 1
      // 020: goto 024
      // 023: athrow
      // 024: invokevirtual java/io/File.isFile ()Z
      // 027: ifne 02c
      // 02a: return
      // 02b: athrow
      // 02c: aload 0
      // 02d: bipush 1
      // 02e: putfield x/ocf6ffa3f47f.đ Z
      // 031: new java/lang/String
      // 034: dup
      // 035: aload 1
      // 036: invokevirtual java/io/File.toPath ()Ljava/nio/file/Path;
      // 039: invokestatic java/nio/file/Files.readAllBytes (Ljava/nio/file/Path;)[B
      // 03c: getstatic java/nio/charset/StandardCharsets.UTF_8 Ljava/nio/charset/Charset;
      // 03f: invokespecial java/lang/String.<init> ([BLjava/nio/charset/Charset;)V
      // 042: astore 3
      // 043: iload 2
      // 044: new com/google/gson/JsonParser
      // 047: dup
      // 048: invokespecial com/google/gson/JsonParser.<init> ()V
      // 04b: aload 3
      // 04c: invokevirtual com/google/gson/JsonParser.parse (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 04f: astore 4
      // 051: ifne 0f9
      // 054: aload 4
      // 056: ifnull 0f4
      // 059: goto 05d
      // 05c: athrow
      // 05d: aload 4
      // 05f: iload 2
      // 060: ifne 077
      // 063: goto 067
      // 066: athrow
      // 067: invokevirtual com/google/gson/JsonElement.isJsonObject ()Z
      // 06a: ifeq 0f4
      // 06d: goto 071
      // 070: athrow
      // 071: aload 4
      // 073: goto 077
      // 076: athrow
      // 077: invokevirtual com/google/gson/JsonElement.getAsJsonObject ()Lcom/google/gson/JsonObject;
      // 07a: astore 5
      // 07c: aload 5
      // 07e: iload 2
      // 07f: ifne 0be
      // 082: ldc "password"
      // 084: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 087: ifeq 0bc
      // 08a: goto 08e
      // 08d: athrow
      // 08e: aload 5
      // 090: iload 2
      // 091: ifne 0be
      // 094: goto 098
      // 097: athrow
      // 098: ldc "password"
      // 09a: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 09d: invokevirtual com/google/gson/JsonElement.isJsonPrimitive ()Z
      // 0a0: ifeq 0bc
      // 0a3: goto 0a7
      // 0a6: athrow
      // 0a7: aload 0
      // 0a8: getfield x/ocf6ffa3f47f.ԇ Lx/oc321b4679dd;
      // 0ab: aload 5
      // 0ad: ldc "password"
      // 0af: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 0b2: invokevirtual com/google/gson/JsonElement.getAsString ()Ljava/lang/String;
      // 0b5: invokevirtual x/oc321b4679dd.z$1bnplyl2p7uqx (Ljava/lang/String;)V
      // 0b8: goto 0bc
      // 0bb: athrow
      // 0bc: aload 5
      // 0be: ldc "doublePassword"
      // 0c0: iload 2
      // 0c1: ifne 0d6
      // 0c4: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 0c7: ifeq 0f4
      // 0ca: goto 0ce
      // 0cd: athrow
      // 0ce: aload 5
      // 0d0: ldc "doublePassword"
      // 0d2: goto 0d6
      // 0d5: athrow
      // 0d6: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 0d9: invokevirtual com/google/gson/JsonElement.isJsonPrimitive ()Z
      // 0dc: ifeq 0f4
      // 0df: aload 0
      // 0e0: getfield x/ocf6ffa3f47f.Ҥ Lx/occ2f8dff8d8;
      // 0e3: aload 5
      // 0e5: ldc "doublePassword"
      // 0e7: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 0ea: invokevirtual com/google/gson/JsonElement.getAsBoolean ()Z
      // 0ed: invokevirtual x/occ2f8dff8d8.ϑ (Z)V
      // 0f0: goto 0f4
      // 0f3: athrow
      // 0f4: aload 0
      // 0f5: bipush 0
      // 0f6: putfield x/ocf6ffa3f47f.đ Z
      // 0f9: goto 10f
      // 0fc: astore 3
      // 0fd: aload 0
      // 0fe: bipush 0
      // 0ff: putfield x/ocf6ffa3f47f.đ Z
      // 102: goto 10f
      // 105: astore 6
      // 107: aload 0
      // 108: bipush 0
      // 109: putfield x/ocf6ffa3f47f.đ Z
      // 10c: aload 6
      // 10e: athrow
      // 10f: return
   }

   public void Ґ() {
      File var1 = Ӎ();

      try {
         if (var1 != null) {
            this.չ(var1);
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }
   }

   public void չ(File param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 15
      // 09: ifnonnull 11
      // 0c: goto 10
      // 0f: athrow
      // 10: return
      // 11: aload 1
      // 12: invokevirtual java/io/File.getParentFile ()Ljava/io/File;
      // 15: astore 3
      // 16: aload 3
      // 17: iload 2
      // 18: ifne 23
      // 1b: ifnull 3a
      // 1e: goto 22
      // 21: athrow
      // 22: aload 3
      // 23: iload 2
      // 24: ifne 36
      // 27: invokevirtual java/io/File.exists ()Z
      // 2a: ifne 3a
      // 2d: goto 31
      // 30: athrow
      // 31: aload 3
      // 32: goto 36
      // 35: athrow
      // 36: invokevirtual java/io/File.mkdirs ()Z
      // 39: pop
      // 3a: new com/google/gson/JsonObject
      // 3d: dup
      // 3e: invokespecial com/google/gson/JsonObject.<init> ()V
      // 41: astore 4
      // 43: aload 4
      // 45: ldc "password"
      // 47: aload 0
      // 48: getfield x/ocf6ffa3f47f.ԇ Lx/oc321b4679dd;
      // 4b: invokevirtual x/oc321b4679dd.Ê ()Ljava/lang/String;
      // 4e: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/String;)V
      // 51: aload 4
      // 53: ldc "doublePassword"
      // 55: aload 0
      // 56: getfield x/ocf6ffa3f47f.Ҥ Lx/occ2f8dff8d8;
      // 59: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 5c: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
      // 5f: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Boolean;)V
      // 62: new com/google/gson/GsonBuilder
      // 65: dup
      // 66: invokespecial com/google/gson/GsonBuilder.<init> ()V
      // 69: invokevirtual com/google/gson/GsonBuilder.setPrettyPrinting ()Lcom/google/gson/GsonBuilder;
      // 6c: invokevirtual com/google/gson/GsonBuilder.create ()Lcom/google/gson/Gson;
      // 6f: aload 4
      // 71: invokevirtual com/google/gson/Gson.toJson (Lcom/google/gson/JsonElement;)Ljava/lang/String;
      // 74: astore 5
      // 76: aload 1
      // 77: invokevirtual java/io/File.toPath ()Ljava/nio/file/Path;
      // 7a: aload 5
      // 7c: getstatic java/nio/charset/StandardCharsets.UTF_8 Ljava/nio/charset/Charset;
      // 7f: invokevirtual java/lang/String.getBytes (Ljava/nio/charset/Charset;)[B
      // 82: bipush 0
      // 83: anewarray 274
      // 86: invokestatic java/nio/file/Files.write (Ljava/nio/file/Path;[B[Ljava/nio/file/OpenOption;)Ljava/nio/file/Path;
      // 89: pop
      // 8a: goto 8e
      // 8d: astore 3
      // 8e: return
   }

   @Override
   public void onEnable() {
      this.ɵ();
      this.ʮ();
   }

   @Override
   public void onDisable() {
      this.ɵ();
      this.Ґ();
   }

   @oc66fa4f2195(
      receiveCanceled = true
   )
   public void Ȗ(oce79181588d param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 07: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0a: ifnull 23
      // 0d: aload 1
      // 0e: iload 2
      // 0f: ifne 26
      // 12: goto 16
      // 15: athrow
      // 16: invokevirtual x/oce79181588d.Ҡ ()Lnet/minecraft/network/Packet;
      // 19: instanceof net/minecraft/network/play/server/S02PacketChat
      // 1c: ifne 25
      // 1f: goto 23
      // 22: athrow
      // 23: return
      // 24: athrow
      // 25: aload 1
      // 26: invokevirtual x/oce79181588d.Ҡ ()Lnet/minecraft/network/Packet;
      // 29: checkcast net/minecraft/network/play/server/S02PacketChat
      // 2c: astore 3
      // 2d: aload 3
      // 2e: iload 2
      // 2f: ifne 48
      // 32: invokevirtual net/minecraft/network/play/server/S02PacketChat.getType ()B
      // 35: ldc_w -1344289243
      // 38: ldc_w -1344289241
      // 3b: ixor
      // 3c: if_icmpeq 4e
      // 3f: goto 43
      // 42: athrow
      // 43: aload 3
      // 44: goto 48
      // 47: athrow
      // 48: invokevirtual net/minecraft/network/play/server/S02PacketChat.getChatComponent ()Lnet/minecraft/util/IChatComponent;
      // 4b: ifnonnull 50
      // 4e: return
      // 4f: athrow
      // 50: aload 0
      // 51: aload 3
      // 52: invokevirtual net/minecraft/network/play/server/S02PacketChat.getChatComponent ()Lnet/minecraft/util/IChatComponent;
      // 55: invokeinterface net/minecraft/util/IChatComponent.getUnformattedText ()Ljava/lang/String; 1
      // 5a: invokevirtual x/ocf6ffa3f47f.Ѣ (Ljava/lang/String;)Ljava/lang/String;
      // 5d: astore 4
      // 5f: aload 4
      // 61: ifnull 73
      // 64: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 67: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 6a: aload 4
      // 6c: invokevirtual net/minecraft/client/entity/EntityPlayerSP.sendChatMessage (Ljava/lang/String;)V
      // 6f: goto 73
      // 72: athrow
      // 73: return
   }

   @oc66fa4f2195
   public void š(ocbab3c9954b var1) {
      this.ɵ();
   }

   String Ѣ(String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: aload 0
      // 04: getfield x/ocf6ffa3f47f.ԇ Lx/oc321b4679dd;
      // 07: invokevirtual x/oc321b4679dd.Ê ()Ljava/lang/String;
      // 0a: invokestatic x/ocf6ffa3f47f.ӊ (Ljava/lang/String;)Ljava/lang/String;
      // 0d: astore 3
      // 0e: istore 2
      // 0f: aload 3
      // 10: iload 2
      // 11: ifne 1f
      // 14: ifnonnull 1e
      // 17: goto 1b
      // 1a: athrow
      // 1b: aconst_null
      // 1c: areturn
      // 1d: athrow
      // 1e: aload 1
      // 1f: iload 2
      // 20: ifne 32
      // 23: ifnonnull 31
      // 26: goto 2a
      // 29: athrow
      // 2a: ldc_w ""
      // 2d: goto 38
      // 30: athrow
      // 31: aload 1
      // 32: getstatic java/util/Locale.ROOT Ljava/util/Locale;
      // 35: invokevirtual java/lang/String.toLowerCase (Ljava/util/Locale;)Ljava/lang/String;
      // 38: astore 4
      // 3a: aload 4
      // 3c: getstatic x/ocf6ffa3f47f.ռ [Ljava/lang/String;
      // 3f: invokestatic x/ocf6ffa3f47f.Ά (Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
      // 42: astore 5
      // 44: aload 5
      // 46: iload 2
      // 47: ifne 94
      // 4a: ifnull 8c
      // 4d: goto 51
      // 50: athrow
      // 51: aload 0
      // 52: iload 2
      // 53: ifne 68
      // 56: goto 5a
      // 59: athrow
      // 5a: getfield x/ocf6ffa3f47f.Ѧ Z
      // 5d: ifeq 67
      // 60: goto 64
      // 63: athrow
      // 64: aconst_null
      // 65: areturn
      // 66: athrow
      // 67: aload 0
      // 68: bipush 1
      // 69: putfield x/ocf6ffa3f47f.Ѧ Z
      // 6c: aload 5
      // 6e: aload 3
      // 6f: aload 0
      // 70: getfield x/ocf6ffa3f47f.Ҥ Lx/occ2f8dff8d8;
      // 73: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 76: ifeq 83
      // 79: aload 3
      // 7a: invokedynamic makeConcatWithConstants (Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ " \u0001" ]
      // 7f: goto 86
      // 82: athrow
      // 83: ldc_w ""
      // 86: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001 \u0001\u0001" ]
      // 8b: areturn
      // 8c: aload 4
      // 8e: getstatic x/ocf6ffa3f47f.Ц [Ljava/lang/String;
      // 91: invokestatic x/ocf6ffa3f47f.Ά (Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
      // 94: astore 6
      // 96: aload 6
      // 98: ifnull ae
      // 9b: aload 0
      // 9c: iload 2
      // 9d: ifne b2
      // a0: goto a4
      // a3: athrow
      // a4: getfield x/ocf6ffa3f47f.Ƿ Z
      // a7: ifeq b1
      // aa: goto ae
      // ad: athrow
      // ae: aconst_null
      // af: areturn
      // b0: athrow
      // b1: aload 0
      // b2: bipush 1
      // b3: putfield x/ocf6ffa3f47f.Ƿ Z
      // b6: aload 6
      // b8: aload 3
      // b9: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001 \u0001" ]
      // be: areturn
   }

   void ɵ() {
      this.Ѧ = false;
      this.Ƿ = false;
   }

   private static String Ά(String param0, String[] param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 1
      // 01: astore 3
      // 02: getstatic x/oc84f20a0bc5.ė I
      // 05: aload 3
      // 06: arraylength
      // 07: istore 4
      // 09: bipush 0
      // 0a: istore 5
      // 0c: istore 2
      // 0d: iload 5
      // 0f: iload 4
      // 11: if_icmpge 36
      // 14: aload 3
      // 15: iload 5
      // 17: aaload
      // 18: astore 6
      // 1a: iload 2
      // 1b: ifne 32
      // 1e: aload 0
      // 1f: aload 6
      // 21: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 24: ifeq 2f
      // 27: goto 2b
      // 2a: athrow
      // 2b: aload 6
      // 2d: areturn
      // 2e: athrow
      // 2f: iinc 5 1
      // 32: iload 2
      // 33: ifeq 0d
      // 36: aconst_null
      // 37: areturn
   }

   private static String ӊ(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 18
      // 09: ifnonnull 17
      // 0c: goto 10
      // 0f: athrow
      // 10: ldc_w ""
      // 13: goto 1b
      // 16: athrow
      // 17: aload 0
      // 18: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 1b: astore 2
      // 1c: aload 2
      // 1d: invokevirtual java/lang/String.isEmpty ()Z
      // 20: iload 1
      // 21: ifne 2f
      // 24: ifeq 2e
      // 27: goto 2b
      // 2a: athrow
      // 2b: aconst_null
      // 2c: areturn
      // 2d: athrow
      // 2e: bipush 0
      // 2f: istore 3
      // 30: iload 3
      // 31: aload 2
      // 32: invokevirtual java/lang/String.length ()I
      // 35: if_icmpge 55
      // 38: aload 2
      // 39: iload 1
      // 3a: ifne 56
      // 3d: iload 3
      // 3e: invokevirtual java/lang/String.charAt (I)C
      // 41: invokestatic java/lang/Character.isWhitespace (C)Z
      // 44: ifeq 4e
      // 47: goto 4b
      // 4a: athrow
      // 4b: aconst_null
      // 4c: areturn
      // 4d: athrow
      // 4e: iinc 3 1
      // 51: iload 1
      // 52: ifeq 30
      // 55: aload 2
      // 56: areturn
   }

   static {
      String[] var10000 = new String[-78367333 ^ -78367341];
      var10000[0] = "/register";
      var10000[1] = "/registrar";
      var10000[-78367343 ^ -78367341] = "/rejestracja";
      var10000[-78367344 ^ -78367341] = "/cadastrar";
      var10000[-78367337 ^ -78367341] = "/enregistrer";
      var10000[-78367338 ^ -78367341] = "/зарег";
      var10000[-78367339 ^ -78367341] = "/kayit";
      var10000[-78367340 ^ -78367341] = "/reg";
      ռ = var10000;
      var10000 = new String[-78367329 ^ -78367341];
      var10000[0] = "/login";
      var10000[1] = "/logar";
      var10000[-78367343 ^ -78367341] = "/entrar";
      var10000[-78367344 ^ -78367341] = "/ingresar";
      var10000[-78367337 ^ -78367341] = "/einloggen";
      var10000[-78367338 ^ -78367341] = "/seconnecter";
      var10000[-78367339 ^ -78367341] = "/connexion";
      var10000[-78367340 ^ -78367341] = "/zaloguj";
      var10000[-78367333 ^ -78367341] = "/войти";
      var10000[-78367334 ^ -78367341] = "/giriş";
      var10000[-78367335 ^ -78367341] = "/giris";
      var10000[-78367336 ^ -78367341] = "/log";
      Ц = var10000;
   }
}

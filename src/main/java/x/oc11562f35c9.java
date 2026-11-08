package x;

public class oc11562f35c9 extends oc69da1aa7f5 {
   private occ2f8dff8d8 ϗ;
   private occ2f8dff8d8 Ǐ;
   private occ2f8dff8d8 Е;
   private int յ = 268261368 ^ -1879222280;
   public static boolean Ջ;

   public oc11562f35c9() {
      super("AutoWho", oce4cea752dd.Ԃ);
      this.ą("Automatically execute /who.");
      this.ʌ(new oc4d46a99983("Automatically execute /who."));
      this.ʌ(new oc4d46a99983(oc7ab2161b9f.Ĭ("Use '&enick [nick]&r' when nicked.")));
      this.ʌ(this.ϗ = new occ2f8dff8d8("Artificial", false));
      this.ʌ(this.Ǐ = new occ2f8dff8d8("Hide message", false));
      this.ʌ(this.Е = new occ2f8dff8d8("Remove bots", true));
   }

   @Override
   public void onDisable() {
      this.յ = 1657875285 ^ -489608363;
   }

   @Override
   public void z$1m9j3ewef9s() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocfa11b18c57.ė I
      // 03: istore 1
      // 04: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 07: iload 1
      // 08: ifne 21
      // 0b: ifne 1d
      // 0e: goto 12
      // 11: athrow
      // 12: aload 0
      // 13: ldc -190728877
      // 15: ldc 1956754771
      // 17: ixor
      // 18: putfield x/oc11562f35c9.յ I
      // 1b: return
      // 1c: athrow
      // 1d: aload 0
      // 1e: invokevirtual x/oc11562f35c9.ǖ ()I
      // 21: istore 2
      // 22: iload 1
      // 23: ifne 58
      // 26: iload 2
      // 27: ldc 1956754769
      // 29: ldc 1956754771
      // 2b: ixor
      // 2c: if_icmpne 53
      // 2f: goto 33
      // 32: athrow
      // 33: aload 0
      // 34: iload 1
      // 35: ifne 54
      // 38: goto 3c
      // 3b: athrow
      // 3c: getfield x/oc11562f35c9.յ I
      // 3f: ldc 1956754769
      // 41: ldc 1956754771
      // 43: ixor
      // 44: if_icmpeq 53
      // 47: goto 4b
      // 4a: athrow
      // 4b: aload 0
      // 4c: invokevirtual x/oc11562f35c9.ժ ()V
      // 4f: goto 53
      // 52: athrow
      // 53: aload 0
      // 54: iload 2
      // 55: putfield x/oc11562f35c9.յ I
      // 58: return
   }

   @oc66fa4f2195
   public void ͺ(oc02e6d57a60 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocfa11b18c57.ė I
      // 03: istore 2
      // 04: aload 1
      // 05: getfield x/oc02e6d57a60.ρ B
      // 08: iload 2
      // 09: ifne 1f
      // 0c: ldc 1121580915
      // 0e: ldc 1121580913
      // 10: ixor
      // 11: if_icmpeq 22
      // 14: goto 18
      // 17: athrow
      // 18: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 1b: goto 1f
      // 1e: athrow
      // 1f: ifne 23
      // 22: return
      // 23: aload 1
      // 24: getfield x/oc02e6d57a60.ǫ Lnet/minecraft/util/IChatComponent;
      // 27: invokeinterface net/minecraft/util/IChatComponent.getUnformattedText ()Ljava/lang/String; 1
      // 2c: invokestatic x/oc7ab2161b9f.ћ (Ljava/lang/String;)Ljava/lang/String;
      // 2f: astore 3
      // 30: aload 3
      // 31: invokevirtual java/lang/String.isEmpty ()Z
      // 34: iload 2
      // 35: ifne 47
      // 38: ifeq 40
      // 3b: goto 3f
      // 3e: athrow
      // 3f: return
      // 40: aload 0
      // 41: getfield x/oc11562f35c9.Ǐ Lx/occ2f8dff8d8;
      // 44: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 47: iload 2
      // 48: ifne 5c
      // 4b: ifeq 79
      // 4e: goto 52
      // 51: athrow
      // 52: aload 3
      // 53: ldc "ONLINE: "
      // 55: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 58: goto 5c
      // 5b: athrow
      // 5c: ifeq 79
      // 5f: aload 1
      // 60: bipush 1
      // 61: invokevirtual x/oc68d6b191af.setCanceled (Z)V
      // 64: getstatic x/oc7ab2161b9f.ô Lorg/apache/logging/log4j/Logger;
      // 67: aload 3
      // 68: ldc "[CHAT] "
      // 6a: swap
      // 6b: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 70: invokeinterface org/apache/logging/log4j/Logger.info (Ljava/lang/String;)V 2
      // 75: goto 79
      // 78: athrow
      // 79: return
   }

   private int ǖ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocfa11b18c57.ė I
      // 03: invokestatic x/oc7ab2161b9f.Ҝ ()I
      // 06: istore 2
      // 07: istore 1
      // 08: iload 2
      // 09: iload 1
      // 0a: ifne 1b
      // 0d: bipush -1
      // 0e: if_icmpeq 18
      // 11: goto 15
      // 14: athrow
      // 15: iload 2
      // 16: ireturn
      // 17: athrow
      // 18: invokestatic x/oc7ab2161b9f.Ь ()I
      // 1b: istore 3
      // 1c: iload 3
      // 1d: iload 1
      // 1e: ifne 2d
      // 21: bipush -1
      // 22: if_icmpeq 2c
      // 25: goto 29
      // 28: athrow
      // 29: iload 3
      // 2a: ireturn
      // 2b: athrow
      // 2c: bipush 0
      // 2d: ireturn
   }

   private void ժ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/ocfa11b18c57.ė I
      // 003: istore 1
      // 004: aload 0
      // 005: getfield x/oc11562f35c9.ϗ Lx/occ2f8dff8d8;
      // 008: iload 1
      // 009: ifne 01e
      // 00c: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 00f: ifeq 105
      // 012: goto 016
      // 015: athrow
      // 016: aload 0
      // 017: getfield x/oc11562f35c9.Ǐ Lx/occ2f8dff8d8;
      // 01a: goto 01e
      // 01d: athrow
      // 01e: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 021: ifeq 02a
      // 024: ldc "ONLINE: "
      // 026: goto 02c
      // 029: athrow
      // 02a: ldc "&b&lONLINE: &r"
      // 02c: astore 2
      // 02d: bipush 1
      // 02e: invokestatic x/oc7ab2161b9f.ˠ (Z)Ljava/util/List;
      // 031: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 036: astore 3
      // 037: aload 3
      // 038: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 03d: ifeq 0be
      // 040: aload 3
      // 041: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 046: checkcast net/minecraft/client/network/NetworkPlayerInfo
      // 049: astore 4
      // 04b: aload 0
      // 04c: iload 1
      // 04d: ifne 0bf
      // 050: iload 1
      // 051: ifne 083
      // 054: goto 058
      // 057: athrow
      // 058: getfield x/oc11562f35c9.Е Lx/occ2f8dff8d8;
      // 05b: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 05e: ifeq 082
      // 061: goto 065
      // 064: athrow
      // 065: aload 4
      // 067: invokevirtual net/minecraft/client/network/NetworkPlayerInfo.getResponseTime ()I
      // 06a: iload 1
      // 06b: ifne 089
      // 06e: goto 072
      // 071: athrow
      // 072: bipush 1
      // 073: if_icmple 082
      // 076: goto 07a
      // 079: athrow
      // 07a: iload 1
      // 07b: ifeq 037
      // 07e: goto 082
      // 081: athrow
      // 082: aload 0
      // 083: getfield x/oc11562f35c9.Ǐ Lx/occ2f8dff8d8;
      // 086: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 089: ifeq 0a1
      // 08c: aload 2
      // 08d: aload 4
      // 08f: invokevirtual net/minecraft/client/network/NetworkPlayerInfo.getGameProfile ()Lcom/mojang/authlib/GameProfile;
      // 092: invokevirtual com/mojang/authlib/GameProfile.getName ()Ljava/lang/String;
      // 095: ldc ", "
      // 097: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001" ]
      // 09c: astore 2
      // 09d: iload 1
      // 09e: ifeq 0ba
      // 0a1: aload 2
      // 0a2: aload 4
      // 0a4: invokevirtual net/minecraft/client/network/NetworkPlayerInfo.getPlayerTeam ()Lnet/minecraft/scoreboard/ScorePlayerTeam;
      // 0a7: aload 4
      // 0a9: invokevirtual net/minecraft/client/network/NetworkPlayerInfo.getGameProfile ()Lcom/mojang/authlib/GameProfile;
      // 0ac: invokevirtual com/mojang/authlib/GameProfile.getName ()Ljava/lang/String;
      // 0af: invokestatic net/minecraft/scoreboard/ScorePlayerTeam.formatPlayerName (Lnet/minecraft/scoreboard/Team;Ljava/lang/String;)Ljava/lang/String;
      // 0b2: ldc "�7, "
      // 0b4: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001" ]
      // 0b9: astore 2
      // 0ba: iload 1
      // 0bb: ifeq 037
      // 0be: aload 0
      // 0bf: getfield x/oc11562f35c9.Ǐ Lx/occ2f8dff8d8;
      // 0c2: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0c5: ifeq 0ea
      // 0c8: getstatic x/oc7ab2161b9f.ô Lorg/apache/logging/log4j/Logger;
      // 0cb: aload 2
      // 0cc: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0cf: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0d2: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getName ()Ljava/lang/String;
      // 0d5: astore 5
      // 0d7: astore 6
      // 0d9: ldc "[CHAT] "
      // 0db: aload 6
      // 0dd: aload 5
      // 0df: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001" ]
      // 0e4: invokeinterface org/apache/logging/log4j/Logger.info (Ljava/lang/String;)V 2
      // 0e9: return
      // 0ea: aload 2
      // 0eb: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0ee: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0f1: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getDisplayName ()Lnet/minecraft/util/IChatComponent;
      // 0f4: invokeinterface net/minecraft/util/IChatComponent.getFormattedText ()Ljava/lang/String; 1
      // 0f9: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 0fe: invokestatic x/oc7ab2161b9f.ȫ (Ljava/lang/String;)V
      // 101: iload 1
      // 102: ifeq 114
      // 105: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 108: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 10b: ldc "/who"
      // 10d: invokevirtual net/minecraft/client/entity/EntityPlayerSP.sendChatMessage (Ljava/lang/String;)V
      // 110: goto 114
      // 113: athrow
      // 114: return
   }
}

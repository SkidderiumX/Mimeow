package x;

public class oc39862c800f extends oc161f4adba4 {
   public static int ʟ;

   public oc39862c800f() {
      super("script", new String[0]);
   }

   public void z$2uoow1halcq2f(ocaae9de8508 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc24b4725b15.Ε I
      // 003: aload 1
      // 004: invokevirtual x/ocaae9de8508.у ()[Ljava/lang/String;
      // 007: astore 3
      // 008: istore 2
      // 009: aload 3
      // 00a: arraylength
      // 00b: iload 2
      // 00c: ifne 09a
      // 00f: bipush 1
      // 010: if_icmplt 090
      // 013: goto 017
      // 016: athrow
      // 017: aload 3
      // 018: iload 2
      // 019: ifne 091
      // 01c: goto 020
      // 01f: athrow
      // 020: bipush 0
      // 021: aaload
      // 022: ldc "edit"
      // 024: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 027: ifeq 090
      // 02a: goto 02e
      // 02d: athrow
      // 02e: aload 3
      // 02f: iload 2
      // 030: ifne 049
      // 033: goto 037
      // 036: athrow
      // 037: arraylength
      // 038: ldc 304877565
      // 03a: ldc 304877567
      // 03c: ixor
      // 03d: if_icmplt 04e
      // 040: goto 044
      // 043: athrow
      // 044: aload 3
      // 045: goto 049
      // 048: athrow
      // 049: bipush 1
      // 04a: aaload
      // 04b: goto 04f
      // 04e: aconst_null
      // 04f: astore 4
      // 051: invokestatic net/minecraft/client/Minecraft.getMinecraft ()Lnet/minecraft/client/Minecraft;
      // 054: astore 5
      // 056: aload 5
      // 058: iload 2
      // 059: ifne 082
      // 05c: invokevirtual net/minecraft/client/Minecraft.isCallingFromMinecraftThread ()Z
      // 05f: ifeq 07c
      // 062: goto 066
      // 065: athrow
      // 066: aload 5
      // 068: new x/ocf65052963e
      // 06b: dup
      // 06c: aload 4
      // 06e: invokespecial x/ocf65052963e.<init> (Ljava/lang/String;)V
      // 071: invokevirtual net/minecraft/client/Minecraft.displayGuiScreen (Lnet/minecraft/client/gui/GuiScreen;)V
      // 074: iload 2
      // 075: ifeq 08f
      // 078: goto 07c
      // 07b: athrow
      // 07c: aload 5
      // 07e: goto 082
      // 081: athrow
      // 082: aload 5
      // 084: aload 4
      // 086: invokedynamic run (Lnet/minecraft/client/Minecraft;Ljava/lang/String;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, x/oc39862c800f.q24kl7cm2xvvzi (Lnet/minecraft/client/Minecraft;Ljava/lang/String;)V, ()V ]
      // 08b: invokevirtual net/minecraft/client/Minecraft.addScheduledTask (Ljava/lang/Runnable;)Lcom/google/common/util/concurrent/ListenableFuture;
      // 08e: pop
      // 08f: return
      // 090: aload 3
      // 091: iload 2
      // 092: ifne 0a3
      // 095: arraylength
      // 096: goto 09a
      // 099: athrow
      // 09a: bipush 1
      // 09b: if_icmpne 0cc
      // 09e: aload 3
      // 09f: goto 0a3
      // 0a2: athrow
      // 0a3: bipush 0
      // 0a4: aaload
      // 0a5: iload 2
      // 0a6: ifne 0bc
      // 0a9: ldc "load"
      // 0ab: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 0ae: ifne 0d6
      // 0b1: goto 0b5
      // 0b4: athrow
      // 0b5: aload 3
      // 0b6: bipush 0
      // 0b7: aaload
      // 0b8: goto 0bc
      // 0bb: athrow
      // 0bc: iload 2
      // 0bd: ifne 0d2
      // 0c0: ldc "refresh"
      // 0c2: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 0c5: ifne 0d6
      // 0c8: goto 0cc
      // 0cb: athrow
      // 0cc: ldc "&cUsage: .script <load|refresh|edit [name]>"
      // 0ce: goto 0d2
      // 0d1: athrow
      // 0d2: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 0d5: return
      // 0d6: invokestatic java/lang/System.currentTimeMillis ()J
      // 0d9: lstore 4
      // 0db: iload 2
      // 0dc: ifne 0f5
      // 0df: getstatic x/oc9755810e45.ř Lkeystrokesmod/script/Manager;
      // 0e2: ifnull 0f9
      // 0e5: goto 0e9
      // 0e8: athrow
      // 0e9: getstatic x/oc9755810e45.ř Lkeystrokesmod/script/Manager;
      // 0ec: lload 4
      // 0ee: invokevirtual keystrokesmod/script/Manager.loadScripts (J)V
      // 0f1: goto 0f5
      // 0f4: athrow
      // 0f5: iload 2
      // 0f6: ifeq 111
      // 0f9: getstatic x/oc2cf3d80e17.ľ Lkeystrokesmod/script/ScriptManager;
      // 0fc: iload 2
      // 0fd: ifne 10e
      // 100: goto 104
      // 103: athrow
      // 104: ifnull 111
      // 107: goto 10b
      // 10a: athrow
      // 10b: getstatic x/oc2cf3d80e17.ľ Lkeystrokesmod/script/ScriptManager;
      // 10e: invokevirtual keystrokesmod/script/ScriptManager.loadScripts ()V
      // 111: return
   }
}

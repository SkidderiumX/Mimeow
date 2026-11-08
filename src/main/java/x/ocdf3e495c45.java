package x;

import com.mojang.authlib.exceptions.AuthenticationException;
import com.mojang.authlib.exceptions.InvalidCredentialsException;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Session;

public class ocdf3e495c45 {
   private static final ocdf3e495c45 Ё = new ocdf3e495c45(new oce490879787());
   private static final long ւ = 20L;
   private static final long Ȏ = 60000L;
   private static final long ƭ = 10000L;
   private static final long ο = 60000L;
   private static final long Φ = 20000L;
   private static final long ϖ = 30000L;
   private static final int Ǉ = 512;
   private final Minecraft ȫ = Minecraft.getMinecraft();
   private final oce490879787 Ō;
   private final oc89e52ca90f Ɂ;
   private final Object Ħ = new Object();
   private final Set<String> Ћ = new LinkedHashSet<>();
   private volatile ScheduledFuture<?> զ;
   private volatile ScheduledFuture<?> r;
   private volatile boolean Ƙ;
   private volatile boolean Ӧ;
   private volatile long Ί;
   private volatile boolean Ј = true;
   private volatile boolean ֆ = true;
   private volatile boolean ո;
   private volatile boolean Д;
   private volatile int ˡ;
   private volatile int Ɓ;
   private volatile String т = "";
   private volatile String Ԛ = "";
   private volatile String B = "";
   private volatile long ˣ;
   private volatile long č;
   private volatile long Ӣ;
   private volatile String Ȓ = "IRC authentication failed.";
   private volatile String Ş = "";
   private volatile String ʙ = "";
   public static boolean ů;

   private ocdf3e495c45(oce490879787 var1) {
      this.Ō = var1;

      try {
         this.Ɂ = new oc89e52ca90f(new oc3c7712a8ae(this));
      } catch (IOException var3) {
         throw new IllegalStateException(var3.getMessage(), var3);
      }
   }

   public static ocdf3e495c45 ϝ() {
      return Ё;
   }

   public void Ӧ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1064)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:565)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:178)
      //
      // Bytecode:
      // 00: getstatic x/oce490879787.փ Z
      // 03: aload 0
      // 04: getfield x/ocdf3e495c45.ȫ Lnet/minecraft/client/Minecraft;
      // 07: invokevirtual net/minecraft/client/Minecraft.getSession ()Lnet/minecraft/util/Session;
      // 0a: invokestatic x/ocdf3e495c45.ǉ (Lnet/minecraft/util/Session;)Ljava/lang/String;
      // 0d: astore 2
      // 0e: istore 1
      // 0f: aload 0
      // 10: dup
      // 11: astore 3
      // 12: monitorenter
      // 13: iload 1
      // 14: ifne 2e
      // 17: aload 0
      // 18: getfield x/ocdf3e495c45.Ƙ Z
      // 1b: ifeq 29
      // 1e: aload 0
      // 1f: getfield x/ocdf3e495c45.ֆ Z
      // 22: iload 1
      // 23: ifne 39
      // 26: ifne 31
      // 29: aload 0
      // 2a: aload 2
      // 2b: putfield x/ocdf3e495c45.ʙ Ljava/lang/String;
      // 2e: aload 3
      // 2f: monitorexit
      // 30: return
      // 31: aload 2
      // 32: aload 0
      // 33: getfield x/ocdf3e495c45.ʙ Ljava/lang/String;
      // 36: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 39: iload 1
      // 3a: ifne 44
      // 3d: ifeq 58
      // 40: aload 0
      // 41: getfield x/ocdf3e495c45.Ӧ Z
      // 44: iload 1
      // 45: ifne 52
      // 48: ifne 55
      // 4b: aload 0
      // 4c: getfield x/ocdf3e495c45.Ɂ Lx/oc89e52ca90f;
      // 4f: invokevirtual x/oc89e52ca90f.ŭ ()Z
      // 52: ifeq 58
      // 55: aload 3
      // 56: monitorexit
      // 57: return
      // 58: aload 0
      // 59: aload 2
      // 5a: putfield x/ocdf3e495c45.ʙ Ljava/lang/String;
      // 5d: aload 0
      // 5e: bipush 1
      // 5f: putfield x/ocdf3e495c45.ո Z
      // 62: aload 0
      // 63: bipush 1
      // 64: putfield x/ocdf3e495c45.Д Z
      // 67: aload 0
      // 68: invokevirtual x/ocdf3e495c45.Յ ()V
      // 6b: aload 3
      // 6c: monitorexit
      // 6d: goto 77
      // 70: astore 4
      // 72: aload 3
      // 73: monitorexit
      // 74: aload 4
      // 76: athrow
      // 77: aload 0
      // 78: invokevirtual x/ocdf3e495c45.Ӛ ()V
      // 7b: iload 1
      // 7c: aload 0
      // 7d: getfield x/ocdf3e495c45.Ɂ Lx/oc89e52ca90f;
      // 80: invokevirtual x/oc89e52ca90f.w ()V
      // 83: aload 0
      // 84: dup
      // 85: astore 3
      // 86: monitorenter
      // 87: ifne 98
      // 8a: aload 0
      // 8b: getfield x/ocdf3e495c45.Ƙ Z
      // 8e: ifne 94
      // 91: aload 3
      // 92: monitorexit
      // 93: return
      // 94: aload 0
      // 95: invokevirtual x/ocdf3e495c45.Յ ()V
      // 98: aload 0
      // 99: getfield x/ocdf3e495c45.Ӧ Z
      // 9c: iload 1
      // 9d: ifne aa
      // a0: ifne b2
      // a3: aload 0
      // a4: getfield x/ocdf3e495c45.Ɂ Lx/oc89e52ca90f;
      // a7: invokevirtual x/oc89e52ca90f.Ā ()Z
      // aa: ifne b2
      // ad: aload 0
      // ae: lconst_0
      // af: invokevirtual x/ocdf3e495c45.È (J)V
      // b2: aload 3
      // b3: monitorexit
      // b4: goto be
      // b7: astore 5
      // b9: aload 3
      // ba: monitorexit
      // bb: aload 5
      // bd: athrow
      // be: return
   }

   public synchronized void ơ() {
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
      // 06: ifne 71
      // 09: getfield x/ocdf3e495c45.Ƙ Z
      // 0c: ifeq 15
      // 0f: goto 13
      // 12: athrow
      // 13: return
      // 14: athrow
      // 15: aload 0
      // 16: dup
      // 17: getfield x/ocdf3e495c45.Ί J
      // 1a: lconst_1
      // 1b: ladd
      // 1c: putfield x/ocdf3e495c45.Ί J
      // 1f: aload 0
      // 20: bipush 1
      // 21: putfield x/ocdf3e495c45.Ƙ Z
      // 24: aload 0
      // 25: bipush 0
      // 26: putfield x/ocdf3e495c45.ո Z
      // 29: aload 0
      // 2a: bipush 0
      // 2b: putfield x/ocdf3e495c45.Д Z
      // 2e: aload 0
      // 2f: bipush 0
      // 30: putfield x/ocdf3e495c45.ˡ I
      // 33: aload 0
      // 34: bipush 1
      // 35: putfield x/ocdf3e495c45.ֆ Z
      // 38: aload 0
      // 39: lconst_0
      // 3a: putfield x/ocdf3e495c45.Ӣ J
      // 3d: aload 0
      // 3e: aload 0
      // 3f: getfield x/ocdf3e495c45.ȫ Lnet/minecraft/client/Minecraft;
      // 42: invokevirtual net/minecraft/client/Minecraft.getSession ()Lnet/minecraft/util/Session;
      // 45: invokestatic x/ocdf3e495c45.ǉ (Lnet/minecraft/util/Session;)Ljava/lang/String;
      // 48: putfield x/ocdf3e495c45.ʙ Ljava/lang/String;
      // 4b: aload 0
      // 4c: invokestatic x/oc2cf3d80e17.ʯ ()Ljava/util/concurrent/ScheduledExecutorService;
      // 4f: new x/oc6a280d1b2d
      // 52: dup
      // 53: aload 0
      // 54: invokespecial x/oc6a280d1b2d.<init> (Lx/ocdf3e495c45;)V
      // 57: ldc2_w 2477679845927545225
      // 5a: ldc2_w 2477679845927545245
      // 5d: lxor
      // 5e: ldc2_w 2477679845927545225
      // 61: ldc2_w 2477679845927545245
      // 64: lxor
      // 65: getstatic java/util/concurrent/TimeUnit.SECONDS Ljava/util/concurrent/TimeUnit;
      // 68: invokeinterface java/util/concurrent/ScheduledExecutorService.scheduleWithFixedDelay (Ljava/lang/Runnable;JJLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture; 7
      // 6d: putfield x/ocdf3e495c45.r Ljava/util/concurrent/ScheduledFuture;
      // 70: aload 0
      // 71: lconst_0
      // 72: invokevirtual x/ocdf3e495c45.È (J)V
      // 75: return
   }

   public synchronized void Դ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 0
      // 01: dup
      // 02: getfield x/ocdf3e495c45.Ί J
      // 05: lconst_1
      // 06: ladd
      // 07: putfield x/ocdf3e495c45.Ί J
      // 0a: getstatic x/oce490879787.փ Z
      // 0d: aload 0
      // 0e: bipush 0
      // 0f: putfield x/ocdf3e495c45.Ƙ Z
      // 12: aload 0
      // 13: bipush 0
      // 14: putfield x/ocdf3e495c45.ո Z
      // 17: istore 1
      // 18: aload 0
      // 19: bipush 0
      // 1a: putfield x/ocdf3e495c45.Д Z
      // 1d: aload 0
      // 1e: bipush 0
      // 1f: putfield x/ocdf3e495c45.Ӧ Z
      // 22: aload 0
      // 23: iload 1
      // 24: ifne 46
      // 27: getfield x/ocdf3e495c45.զ Ljava/util/concurrent/ScheduledFuture;
      // 2a: ifnull 45
      // 2d: goto 31
      // 30: athrow
      // 31: aload 0
      // 32: getfield x/ocdf3e495c45.զ Ljava/util/concurrent/ScheduledFuture;
      // 35: bipush 1
      // 36: invokeinterface java/util/concurrent/ScheduledFuture.cancel (Z)Z 2
      // 3b: pop
      // 3c: aload 0
      // 3d: aconst_null
      // 3e: putfield x/ocdf3e495c45.զ Ljava/util/concurrent/ScheduledFuture;
      // 41: goto 45
      // 44: athrow
      // 45: aload 0
      // 46: iload 1
      // 47: ifne 75
      // 4a: getfield x/ocdf3e495c45.r Ljava/util/concurrent/ScheduledFuture;
      // 4d: ifnull 68
      // 50: goto 54
      // 53: athrow
      // 54: aload 0
      // 55: getfield x/ocdf3e495c45.r Ljava/util/concurrent/ScheduledFuture;
      // 58: bipush 1
      // 59: invokeinterface java/util/concurrent/ScheduledFuture.cancel (Z)Z 2
      // 5e: pop
      // 5f: aload 0
      // 60: aconst_null
      // 61: putfield x/ocdf3e495c45.r Ljava/util/concurrent/ScheduledFuture;
      // 64: goto 68
      // 67: athrow
      // 68: aload 0
      // 69: getfield x/ocdf3e495c45.Ɂ Lx/oc89e52ca90f;
      // 6c: invokevirtual x/oc89e52ca90f.w ()V
      // 6f: aload 0
      // 70: bipush 0
      // 71: putfield x/ocdf3e495c45.Ɓ I
      // 74: aload 0
      // 75: invokevirtual x/ocdf3e495c45.Ӛ ()V
      // 78: return
   }

   public void ն(boolean var1) {
      this.Ј = var1;
   }

   public boolean ʡ() {
      return this.Ј;
   }

   public boolean ɽ(String param1) {
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
      // 05: getfield x/ocdf3e495c45.Ƙ Z
      // 08: iload 2
      // 09: ifne 27
      // 0c: ifeq 26
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: getfield x/ocdf3e495c45.Ј Z
      // 17: iload 2
      // 18: ifne 27
      // 1b: goto 1f
      // 1e: athrow
      // 1f: ifne 28
      // 22: goto 26
      // 25: athrow
      // 26: bipush 0
      // 27: ireturn
      // 28: aload 1
      // 29: invokestatic x/oc752fc2db59.ʗ (Ljava/lang/String;)Lx/oc752fc2db59;
      // 2c: astore 3
      // 2d: aload 3
      // 2e: invokevirtual x/oc752fc2db59.ǉ ()Z
      // 31: iload 2
      // 32: ifne 4b
      // 35: ifne 3f
      // 38: goto 3c
      // 3b: athrow
      // 3c: bipush 0
      // 3d: ireturn
      // 3e: athrow
      // 3f: aload 0
      // 40: iload 2
      // 41: ifne 4f
      // 44: getfield x/ocdf3e495c45.ֆ Z
      // 47: goto 4b
      // 4a: athrow
      // 4b: ifne 57
      // 4e: aload 0
      // 4f: ldc "IRC is disabled globally."
      // 51: bipush 1
      // 52: invokevirtual x/ocdf3e495c45.д (Ljava/lang/String;Z)V
      // 55: bipush 1
      // 56: ireturn
      // 57: aload 3
      // 58: iload 2
      // 59: ifne 71
      // 5c: invokevirtual x/oc752fc2db59.ĸ ()Lx/occaff2246e4;
      // 5f: getstatic x/occaff2246e4.Ѯ Lx/occaff2246e4;
      // 62: if_acmpne 70
      // 65: goto 69
      // 68: athrow
      // 69: aload 0
      // 6a: invokevirtual x/ocdf3e495c45.Ҿ ()V
      // 6d: bipush 1
      // 6e: ireturn
      // 6f: athrow
      // 70: aload 3
      // 71: invokevirtual x/oc752fc2db59.î ()Ljava/lang/String;
      // 74: astore 4
      // 76: aload 4
      // 78: iload 2
      // 79: ifne 93
      // 7c: invokevirtual java/lang/String.isEmpty ()Z
      // 7f: ifeq 91
      // 82: goto 86
      // 85: athrow
      // 86: aload 0
      // 87: ldc_w "Use # <message> to chat or #online to view online users."
      // 8a: bipush 1
      // 8b: invokevirtual x/ocdf3e495c45.д (Ljava/lang/String;Z)V
      // 8e: bipush 1
      // 8f: ireturn
      // 90: athrow
      // 91: aload 4
      // 93: invokevirtual java/lang/String.length ()I
      // 96: iload 2
      // 97: ifne bc
      // 9a: ldc_w 2051716045
      // 9d: ldc_w 2051715789
      // a0: ixor
      // a1: if_icmple b3
      // a4: goto a8
      // a7: athrow
      // a8: aload 0
      // a9: ldc_w "IRC messages cannot exceed 256 characters."
      // ac: bipush 1
      // ad: invokevirtual x/ocdf3e495c45.д (Ljava/lang/String;Z)V
      // b0: bipush 1
      // b1: ireturn
      // b2: athrow
      // b3: aload 0
      // b4: getfield x/ocdf3e495c45.Ɂ Lx/oc89e52ca90f;
      // b7: aload 4
      // b9: invokevirtual x/oc89e52ca90f.Ѓ (Ljava/lang/String;)Z
      // bc: iload 2
      // bd: ifne ec
      // c0: ifne eb
      // c3: goto c7
      // c6: athrow
      // c7: aload 0
      // c8: iload 2
      // c9: ifne e4
      // cc: goto d0
      // cf: athrow
      // d0: getfield x/ocdf3e495c45.Ӧ Z
      // d3: ifne e3
      // d6: goto da
      // d9: athrow
      // da: aload 0
      // db: lconst_0
      // dc: invokevirtual x/ocdf3e495c45.È (J)V
      // df: goto e3
      // e2: athrow
      // e3: aload 0
      // e4: ldc_w "IRC is reconnecting. Try again in a moment."
      // e7: bipush 1
      // e8: invokevirtual x/ocdf3e495c45.д (Ljava/lang/String;Z)V
      // eb: bipush 1
      // ec: ireturn
   }

   private synchronized void È(long param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce490879787.փ Z
      // 03: istore 3
      // 04: aload 0
      // 05: iload 3
      // 06: ifne 18
      // 09: getfield x/ocdf3e495c45.Ƙ Z
      // 0c: ifeq 4f
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: iload 3
      // 19: ifne 2b
      // 1c: getfield x/ocdf3e495c45.ֆ Z
      // 1f: ifeq 4f
      // 22: goto 26
      // 25: athrow
      // 26: aload 0
      // 27: goto 2b
      // 2a: athrow
      // 2b: iload 3
      // 2c: ifne 3e
      // 2f: getfield x/ocdf3e495c45.Ӧ Z
      // 32: ifne 4f
      // 35: goto 39
      // 38: athrow
      // 39: aload 0
      // 3a: goto 3e
      // 3d: athrow
      // 3e: iload 3
      // 3f: ifne 52
      // 42: getfield x/ocdf3e495c45.Ɂ Lx/oc89e52ca90f;
      // 45: invokevirtual x/oc89e52ca90f.Ā ()Z
      // 48: ifeq 51
      // 4b: goto 4f
      // 4e: athrow
      // 4f: return
      // 50: athrow
      // 51: aload 0
      // 52: iload 3
      // 53: ifne 7b
      // 56: getfield x/ocdf3e495c45.զ Ljava/util/concurrent/ScheduledFuture;
      // 59: ifnull 7a
      // 5c: goto 60
      // 5f: athrow
      // 60: aload 0
      // 61: iload 3
      // 62: ifne 7b
      // 65: goto 69
      // 68: athrow
      // 69: getfield x/ocdf3e495c45.զ Ljava/util/concurrent/ScheduledFuture;
      // 6c: invokeinterface java/util/concurrent/ScheduledFuture.isDone ()Z 1
      // 71: ifne 7a
      // 74: goto 78
      // 77: athrow
      // 78: return
      // 79: athrow
      // 7a: aload 0
      // 7b: invokestatic x/oc2cf3d80e17.ʯ ()Ljava/util/concurrent/ScheduledExecutorService;
      // 7e: new x/oc01ba0194ec
      // 81: dup
      // 82: aload 0
      // 83: invokespecial x/oc01ba0194ec.<init> (Lx/ocdf3e495c45;)V
      // 86: lconst_0
      // 87: lload 1
      // 88: invokestatic java/lang/Math.max (JJ)J
      // 8b: getstatic java/util/concurrent/TimeUnit.MILLISECONDS Ljava/util/concurrent/TimeUnit;
      // 8e: invokeinterface java/util/concurrent/ScheduledExecutorService.schedule (Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture; 5
      // 93: putfield x/ocdf3e495c45.զ Ljava/util/concurrent/ScheduledFuture;
      // 96: return
   }

   private synchronized void Յ() {
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
      // 06: ifne 23
      // 09: getfield x/ocdf3e495c45.զ Ljava/util/concurrent/ScheduledFuture;
      // 0c: ifnull 27
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: getfield x/ocdf3e495c45.զ Ljava/util/concurrent/ScheduledFuture;
      // 17: bipush 0
      // 18: invokeinterface java/util/concurrent/ScheduledFuture.cancel (Z)Z 2
      // 1d: pop
      // 1e: aload 0
      // 1f: goto 23
      // 22: athrow
      // 23: aconst_null
      // 24: putfield x/ocdf3e495c45.զ Ljava/util/concurrent/ScheduledFuture;
      // 27: return
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // $VF: Could not create synchronized statement, marking monitor enters and exits
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private void Ԝ() {
      ocdf3e495c45 var4 = this;
      synchronized (this){} // $VF: monitorenter 
      boolean var1 = oce490879787.փ;
      boolean var7 = false /* VF: Semaphore variable */;

      long var2;
      try {
         label75: {
            label73: {
               var7 = true;
               this.զ = null;
               boolean var10000 = this.Ƙ;
               if (!var1) {
                  if (!this.Ƙ) {
                     break label73;
                  }

                  var10000 = this.ֆ;
               }

               if (!var1) {
                  if (!var10000) {
                     break label73;
                  }

                  var10000 = this.Ӧ;
               }

               if (!var1) {
                  if (var10000) {
                     break label73;
                  }

                  var10000 = this.Ɂ.Ā();
               }

               if (!var10000) {
                  this.Ӧ = true;
                  this.ո = false;
                  var2 = this.Ί;
                  // $VF: monitorexit
                  var7 = false;
                  break label75;
               }
            }

            // $VF: monitorexit
            return;
         }
      } finally {
         if (var7) {
            // $VF: monitorexit
         }
      }

      oc2cf3d80e17.P().execute(new oc73ecc79e41(this, var2));
   }

   private void Ϻ(long var1) {
      boolean var3 = oce490879787.փ;

      try {
         if (!this.ӣ(true)) {
            this.ϓ(var1, null);
         } else {
            String var4 = ǉ(this.ȫ.getSession());
            String var5 = this.Ǭ();
            synchronized (this) {
               int var10000 = this.Ƙ;
               if (!var3) {
                  if (!this.Ƙ) {
                     return;
                  }

                  long var10;
                  var10000 = (var10 = this.Ί - var1) == 0L ? 0 : (var10 < 0L ? -1 : 1);
               }

               if (!var3) {
                  if (var10000) {
                     return;
                  }

                  var10000 = var4.equals(ǉ(this.ȫ.getSession()));
               }

               if (!var10000) {
                  this.ո = true;
                  this.Д = true;
                  this.ϓ(var1, null);
               } else {
                  this.Ɂ.Ⱥ(this.ʑ());
                  this.Ɂ.ճ(var5, this.Ş, this.С()).whenComplete((var3x, var4x) -> this.ϓ(var1, var4x));
               }
            }
         }
      } catch (Exception var9) {
         this.ϓ(var1, var9);
      }
   }

   private void ϓ(long param1, Throwable param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: getstatic x/oce490879787.փ Z
      // 03: istore 4
      // 05: iload 4
      // 07: aload 0
      // 08: dup
      // 09: astore 7
      // 0b: monitorenter
      // 0c: ifne 21
      // 0f: aload 0
      // 10: getfield x/ocdf3e495c45.Ί J
      // 13: lload 1
      // 14: lcmp
      // 15: ifeq 1c
      // 18: aload 7
      // 1a: monitorexit
      // 1b: return
      // 1c: aload 0
      // 1d: bipush 0
      // 1e: putfield x/ocdf3e495c45.Ӧ Z
      // 21: aload 0
      // 22: getfield x/ocdf3e495c45.ո Z
      // 25: istore 5
      // 27: aload 0
      // 28: getfield x/ocdf3e495c45.Д Z
      // 2b: istore 6
      // 2d: aload 0
      // 2e: bipush 0
      // 2f: putfield x/ocdf3e495c45.ո Z
      // 32: aload 0
      // 33: bipush 0
      // 34: putfield x/ocdf3e495c45.Д Z
      // 37: aload 7
      // 39: monitorexit
      // 3a: goto 45
      // 3d: astore 8
      // 3f: aload 7
      // 41: monitorexit
      // 42: aload 8
      // 44: athrow
      // 45: aload 0
      // 46: getfield x/ocdf3e495c45.ֆ Z
      // 49: ifeq 73
      // 4c: aload 3
      // 4d: ifnonnull 5d
      // 50: goto 54
      // 53: athrow
      // 54: iload 5
      // 56: ifeq 73
      // 59: goto 5d
      // 5c: athrow
      // 5d: aload 0
      // 5e: iload 6
      // 60: ifeq 6c
      // 63: goto 67
      // 66: athrow
      // 67: lconst_0
      // 68: goto 70
      // 6b: athrow
      // 6c: aload 0
      // 6d: invokevirtual x/ocdf3e495c45.Ԇ ()J
      // 70: invokevirtual x/ocdf3e495c45.È (J)V
      // 73: return
   }

   private void Ĩ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce490879787.փ Z
      // 003: istore 1
      // 004: aload 0
      // 005: iload 1
      // 006: ifne 016
      // 009: getfield x/ocdf3e495c45.Ƙ Z
      // 00c: ifne 015
      // 00f: goto 013
      // 012: athrow
      // 013: return
      // 014: athrow
      // 015: aload 0
      // 016: iload 1
      // 017: ifne 028
      // 01a: bipush 0
      // 01b: invokevirtual x/ocdf3e495c45.ӣ (Z)Z
      // 01e: ifne 027
      // 021: goto 025
      // 024: athrow
      // 025: return
      // 026: athrow
      // 027: aload 0
      // 028: iload 1
      // 029: ifne 03d
      // 02c: invokevirtual x/ocdf3e495c45.ӗ ()Z
      // 02f: ifeq 03c
      // 032: goto 036
      // 035: athrow
      // 036: aload 0
      // 037: invokevirtual x/ocdf3e495c45.Ӧ ()V
      // 03a: return
      // 03b: athrow
      // 03c: aload 0
      // 03d: iload 1
      // 03e: ifne 053
      // 041: getfield x/ocdf3e495c45.Ɂ Lx/oc89e52ca90f;
      // 044: invokevirtual x/oc89e52ca90f.ŭ ()Z
      // 047: ifne 084
      // 04a: goto 04e
      // 04d: athrow
      // 04e: aload 0
      // 04f: goto 053
      // 052: athrow
      // 053: iload 1
      // 054: ifne 066
      // 057: getfield x/ocdf3e495c45.Ӧ Z
      // 05a: ifne 083
      // 05d: goto 061
      // 060: athrow
      // 061: aload 0
      // 062: goto 066
      // 065: athrow
      // 066: iload 1
      // 067: ifne 07c
      // 06a: getfield x/ocdf3e495c45.Ɂ Lx/oc89e52ca90f;
      // 06d: invokevirtual x/oc89e52ca90f.Ā ()Z
      // 070: ifne 083
      // 073: goto 077
      // 076: athrow
      // 077: aload 0
      // 078: goto 07c
      // 07b: athrow
      // 07c: aload 0
      // 07d: invokevirtual x/ocdf3e495c45.Ԇ ()J
      // 080: invokevirtual x/ocdf3e495c45.È (J)V
      // 083: return
      // 084: invokestatic java/lang/System.currentTimeMillis ()J
      // 087: lstore 2
      // 088: aload 0
      // 089: iload 1
      // 08a: ifne 0c2
      // 08d: getfield x/ocdf3e495c45.ˣ J
      // 090: lload 2
      // 091: ldc2_w -4655521523338622607
      // 094: ldc2_w -4655521523338599663
      // 097: lxor
      // 098: ladd
      // 099: lcmp
      // 09a: ifle 0c1
      // 09d: goto 0a1
      // 0a0: athrow
      // 0a1: lload 2
      // 0a2: aload 0
      // 0a3: getfield x/ocdf3e495c45.Ɂ Lx/oc89e52ca90f;
      // 0a6: invokevirtual x/oc89e52ca90f.Н ()J
      // 0a9: lsub
      // 0aa: ldc2_w -4655521523338622607
      // 0ad: ldc2_w -4655521523338599663
      // 0b0: lxor
      // 0b1: lcmp
      // 0b2: iload 1
      // 0b3: ifne 108
      // 0b6: goto 0ba
      // 0b9: athrow
      // 0ba: ifle 0ea
      // 0bd: goto 0c1
      // 0c0: athrow
      // 0c1: aload 0
      // 0c2: iload 1
      // 0c3: ifne 0e3
      // 0c6: getfield x/ocdf3e495c45.ˣ J
      // 0c9: lload 2
      // 0ca: ldc2_w -4655521523338622607
      // 0cd: ldc2_w -4655521523338599663
      // 0d0: lxor
      // 0d1: ladd
      // 0d2: lcmp
      // 0d3: ifgt 0e2
      // 0d6: goto 0da
      // 0d9: athrow
      // 0da: aload 0
      // 0db: invokevirtual x/ocdf3e495c45.Ӛ ()V
      // 0de: goto 0e2
      // 0e1: athrow
      // 0e2: aload 0
      // 0e3: getfield x/ocdf3e495c45.Ɂ Lx/oc89e52ca90f;
      // 0e6: invokevirtual x/oc89e52ca90f.w ()V
      // 0e9: return
      // 0ea: aload 0
      // 0eb: getfield x/ocdf3e495c45.Ɂ Lx/oc89e52ca90f;
      // 0ee: iload 1
      // 0ef: ifne 129
      // 0f2: aload 0
      // 0f3: invokevirtual x/ocdf3e495c45.ʑ ()Z
      // 0f6: invokevirtual x/oc89e52ca90f.Ⱥ (Z)V
      // 0f9: aload 0
      // 0fa: getfield x/ocdf3e495c45.Ɂ Lx/oc89e52ca90f;
      // 0fd: aload 0
      // 0fe: invokevirtual x/ocdf3e495c45.С ()Ljava/lang/String;
      // 101: invokevirtual x/oc89e52ca90f.Ʋ (Ljava/lang/String;)Z
      // 104: goto 108
      // 107: athrow
      // 108: ifeq 121
      // 10b: aload 0
      // 10c: iload 1
      // 10d: ifne 126
      // 110: goto 114
      // 113: athrow
      // 114: getfield x/ocdf3e495c45.Ɂ Lx/oc89e52ca90f;
      // 117: invokevirtual x/oc89e52ca90f.Ė ()Z
      // 11a: ifne 12c
      // 11d: goto 121
      // 120: athrow
      // 121: aload 0
      // 122: goto 126
      // 125: athrow
      // 126: getfield x/ocdf3e495c45.Ɂ Lx/oc89e52ca90f;
      // 129: invokevirtual x/oc89e52ca90f.w ()V
      // 12c: return
   }

   private boolean ʑ() {
      boolean var10000 = oce490879787.փ;
      ocd3ffe14280 var2 = (ocd3ffe14280)oc9755810e45.ʬ(ocd3ffe14280.class);
      boolean var1 = var10000;

      label33: {
         try {
            var5 = var2;
            if (var1) {
               break label33;
            }

            if (var2 == null) {
               return false;
            }
         } catch (IllegalStateException var4) {
            throw var4;
         }

         var5 = var2;
      }

      try {
         var10000 = var5.ó();
         if (var1) {
            return var10000;
         }

         if (var10000) {
            return true;
         }
      } catch (IllegalStateException var3) {
         throw var3;
      }

      return false;
   }

   private void Ҿ() {
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
      // 06: ifne 1d
      // 09: getfield x/ocdf3e495c45.ֆ Z
      // 0c: ifne 1c
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: ldc "IRC is disabled globally."
      // 16: bipush 1
      // 17: invokevirtual x/ocdf3e495c45.д (Ljava/lang/String;Z)V
      // 1a: return
      // 1b: athrow
      // 1c: aload 0
      // 1d: iload 1
      // 1e: ifne 39
      // 21: getfield x/ocdf3e495c45.Ɂ Lx/oc89e52ca90f;
      // 24: invokevirtual x/oc89e52ca90f.ŭ ()Z
      // 27: ifne 38
      // 2a: goto 2e
      // 2d: athrow
      // 2e: aload 0
      // 2f: ldc_w "IRC is reconnecting."
      // 32: bipush 1
      // 33: invokevirtual x/ocdf3e495c45.д (Ljava/lang/String;Z)V
      // 36: return
      // 37: athrow
      // 38: aload 0
      // 39: getfield x/ocdf3e495c45.Ɓ I
      // 3c: istore 2
      // 3d: aload 0
      // 3e: iload 2
      // 3f: iload 2
      // 40: bipush 1
      // 41: if_icmpne 4b
      // 44: ldc_w " user is"
      // 47: goto 4e
      // 4a: athrow
      // 4b: ldc_w " users are"
      // 4e: ldc_w " online."
      // 51: invokedynamic makeConcatWithConstants (ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001" ]
      // 56: bipush 0
      // 57: invokevirtual x/ocdf3e495c45.д (Ljava/lang/String;Z)V
      // 5a: return
   }

   private String Ǭ() throws IOException, AuthenticationException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: getstatic x/oce490879787.փ Z
      // 003: aload 0
      // 004: getfield x/ocdf3e495c45.ȫ Lnet/minecraft/client/Minecraft;
      // 007: invokevirtual net/minecraft/client/Minecraft.getSession ()Lnet/minecraft/util/Session;
      // 00a: astore 2
      // 00b: istore 1
      // 00c: aload 2
      // 00d: iload 1
      // 00e: ifne 01f
      // 011: ifnonnull 01e
      // 014: goto 018
      // 017: athrow
      // 018: ldc ""
      // 01a: goto 022
      // 01d: athrow
      // 01e: aload 2
      // 01f: invokevirtual net/minecraft/util/Session.getUsername ()Ljava/lang/String;
      // 022: astore 3
      // 023: aload 2
      // 024: iload 1
      // 025: ifne 036
      // 028: ifnonnull 035
      // 02b: goto 02f
      // 02e: athrow
      // 02f: ldc ""
      // 031: goto 03c
      // 034: athrow
      // 035: aload 2
      // 036: invokevirtual net/minecraft/util/Session.getPlayerID ()Ljava/lang/String;
      // 039: invokestatic x/ocdf3e495c45.բ (Ljava/lang/String;)Ljava/lang/String;
      // 03c: astore 4
      // 03e: invokestatic java/lang/System.currentTimeMillis ()J
      // 041: lstore 5
      // 043: aload 0
      // 044: aload 3
      // 045: aload 4
      // 047: lload 5
      // 049: invokevirtual x/ocdf3e495c45.н (Ljava/lang/String;Ljava/lang/String;J)Z
      // 04c: ifeq 055
      // 04f: aload 0
      // 050: getfield x/ocdf3e495c45.т Ljava/lang/String;
      // 053: areturn
      // 054: athrow
      // 055: aload 0
      // 056: getfield x/ocdf3e495c45.Ħ Ljava/lang/Object;
      // 059: dup
      // 05a: astore 7
      // 05c: monitorenter
      // 05d: invokestatic java/lang/System.currentTimeMillis ()J
      // 060: iload 1
      // 061: ifne 081
      // 064: lstore 5
      // 066: aload 0
      // 067: aload 3
      // 068: aload 4
      // 06a: lload 5
      // 06c: invokevirtual x/ocdf3e495c45.н (Ljava/lang/String;Ljava/lang/String;J)Z
      // 06f: ifeq 07a
      // 072: aload 0
      // 073: getfield x/ocdf3e495c45.т Ljava/lang/String;
      // 076: aload 7
      // 078: monitorexit
      // 079: areturn
      // 07a: lload 5
      // 07c: aload 0
      // 07d: getfield x/ocdf3e495c45.č J
      // 080: lsub
      // 081: ldc2_w -1952581363578710777
      // 084: ldc2_w -1952581363578703337
      // 087: lxor
      // 088: lcmp
      // 089: ifge 098
      // 08c: new java/io/IOException
      // 08f: dup
      // 090: aload 0
      // 091: getfield x/ocdf3e495c45.Ȓ Ljava/lang/String;
      // 094: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 097: athrow
      // 098: aload 0
      // 099: aload 2
      // 09a: aload 3
      // 09b: aload 4
      // 09d: invokevirtual x/ocdf3e495c45.Ҝ (Lnet/minecraft/util/Session;Ljava/lang/String;Ljava/lang/String;)Lx/oc96b2b18ccc;
      // 0a0: astore 8
      // 0a2: iload 1
      // 0a3: aload 2
      // 0a4: invokestatic x/ocdf3e495c45.ǉ (Lnet/minecraft/util/Session;)Ljava/lang/String;
      // 0a7: astore 9
      // 0a9: aload 0
      // 0aa: dup
      // 0ab: astore 10
      // 0ad: monitorenter
      // 0ae: ifne 0f9
      // 0b1: aload 9
      // 0b3: aload 0
      // 0b4: getfield x/ocdf3e495c45.ȫ Lnet/minecraft/client/Minecraft;
      // 0b7: invokevirtual net/minecraft/client/Minecraft.getSession ()Lnet/minecraft/util/Session;
      // 0ba: invokestatic x/ocdf3e495c45.ǉ (Lnet/minecraft/util/Session;)Ljava/lang/String;
      // 0bd: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0c0: ifne 0cb
      // 0c3: new x/ocf0f315cf21
      // 0c6: dup
      // 0c7: invokespecial x/ocf0f315cf21.<init> ()V
      // 0ca: athrow
      // 0cb: aload 0
      // 0cc: aload 8
      // 0ce: invokevirtual x/oc96b2b18ccc.ģ ()Ljava/lang/String;
      // 0d1: putfield x/ocdf3e495c45.т Ljava/lang/String;
      // 0d4: aload 0
      // 0d5: aload 8
      // 0d7: invokevirtual x/oc96b2b18ccc.ď ()J
      // 0da: putfield x/ocdf3e495c45.ˣ J
      // 0dd: aload 0
      // 0de: aload 3
      // 0df: putfield x/ocdf3e495c45.B Ljava/lang/String;
      // 0e2: aload 0
      // 0e3: aload 4
      // 0e5: putfield x/ocdf3e495c45.Ԛ Ljava/lang/String;
      // 0e8: aload 0
      // 0e9: lconst_0
      // 0ea: putfield x/ocdf3e495c45.č J
      // 0ed: aload 0
      // 0ee: ldc "IRC authentication failed."
      // 0f0: putfield x/ocdf3e495c45.Ȓ Ljava/lang/String;
      // 0f3: aload 0
      // 0f4: aload 9
      // 0f6: putfield x/ocdf3e495c45.ʙ Ljava/lang/String;
      // 0f9: aload 10
      // 0fb: monitorexit
      // 0fc: goto 107
      // 0ff: astore 11
      // 101: aload 10
      // 103: monitorexit
      // 104: aload 11
      // 106: athrow
      // 107: aload 0
      // 108: getfield x/ocdf3e495c45.т Ljava/lang/String;
      // 10b: aload 7
      // 10d: monitorexit
      // 10e: areturn
      // 10f: astore 8
      // 111: aload 8
      // 113: athrow
      // 114: astore 8
      // 116: aload 0
      // 117: aload 8
      // 119: invokevirtual x/ocdf3e495c45.γ (Ljava/lang/Exception;)V
      // 11c: aload 8
      // 11e: athrow
      // 11f: astore 8
      // 121: aload 0
      // 122: aload 8
      // 124: invokevirtual x/ocdf3e495c45.γ (Ljava/lang/Exception;)V
      // 127: aload 8
      // 129: athrow
      // 12a: astore 12
      // 12c: aload 7
      // 12e: monitorexit
      // 12f: aload 12
      // 131: athrow
   }

   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private oc96b2b18ccc Ҝ(Session var1, String var2, String var3) throws IOException, AuthenticationException {
      boolean var4 = oce490879787.փ;

      label42: {
         Session var10000;
         label37: {
            try {
               var10000 = var1;
               if (var4) {
                  break label37;
               }

               if (var1 == null) {
                  break label42;
               }
            } catch (InvalidCredentialsException var10) {
               throw var10;
            }

            var10000 = var1;
         }

         try {
            if (oce490879787.Ï(var10000.getToken())) {
               break label42;
            }
         } catch (InvalidCredentialsException var9) {
            throw var9;
         }

         ocd4555a3f01 var5 = this.Ō.ρ(var2, var3);

         try {
            this.ȫ.getSessionService().joinServer(var1.getProfile(), var1.getToken(), var5.c());
         } catch (InvalidCredentialsException var8) {
            return this.Ō.Ƀ(var2);
         }

         return this.Ō.ɿ(var5.Ŏ());
      }

      try {
         return this.Ō.Ƀ(var2);
      } catch (InvalidCredentialsException var7) {
         throw var7;
      }
   }

   private boolean н(String param1, String param2, long param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce490879787.փ Z
      // 03: istore 5
      // 05: aload 0
      // 06: iload 5
      // 08: ifne 1d
      // 0b: getfield x/ocdf3e495c45.т Ljava/lang/String;
      // 0e: invokevirtual java/lang/String.isEmpty ()Z
      // 11: ifne 6a
      // 14: goto 18
      // 17: athrow
      // 18: aload 0
      // 19: goto 1d
      // 1c: athrow
      // 1d: iload 5
      // 1f: ifne 3b
      // 22: getfield x/ocdf3e495c45.ˣ J
      // 25: lload 3
      // 26: ldc2_w -5507021743251081399
      // 29: ldc2_w -5507021743251104471
      // 2c: lxor
      // 2d: ladd
      // 2e: lcmp
      // 2f: ifle 6a
      // 32: goto 36
      // 35: athrow
      // 36: aload 0
      // 37: goto 3b
      // 3a: athrow
      // 3b: getfield x/ocdf3e495c45.B Ljava/lang/String;
      // 3e: aload 1
      // 3f: iload 5
      // 41: ifne 57
      // 44: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 47: ifeq 6a
      // 4a: goto 4e
      // 4d: athrow
      // 4e: aload 0
      // 4f: getfield x/ocdf3e495c45.Ԛ Ljava/lang/String;
      // 52: aload 2
      // 53: goto 57
      // 56: athrow
      // 57: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 5a: iload 5
      // 5c: ifne 67
      // 5f: ifeq 6a
      // 62: goto 66
      // 65: athrow
      // 66: bipush 1
      // 67: goto 6b
      // 6a: bipush 0
      // 6b: ireturn
   }

   private void γ(Exception param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce490879787.փ Z
      // 03: aload 0
      // 04: invokestatic java/lang/System.currentTimeMillis ()J
      // 07: putfield x/ocdf3e495c45.č J
      // 0a: istore 2
      // 0b: aload 1
      // 0c: invokevirtual java/lang/Exception.getMessage ()Ljava/lang/String;
      // 0f: astore 3
      // 10: aload 0
      // 11: aload 3
      // 12: iload 2
      // 13: ifne 39
      // 16: ifnull 33
      // 19: goto 1d
      // 1c: athrow
      // 1d: aload 3
      // 1e: iload 2
      // 1f: ifne 3d
      // 22: goto 26
      // 25: athrow
      // 26: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 29: invokevirtual java/lang/String.isEmpty ()Z
      // 2c: ifeq 3c
      // 2f: goto 33
      // 32: athrow
      // 33: ldc "IRC authentication failed."
      // 35: goto 39
      // 38: athrow
      // 39: goto 40
      // 3c: aload 3
      // 3d: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 40: putfield x/ocdf3e495c45.Ȓ Ljava/lang/String;
      // 43: return
   }

   private synchronized long Ԇ() {
      int var1 = Math.min(this.ˡ, 1636738701 ^ 1636738696);
      this.ˡ = Math.min(this.ˡ + 1, 1636738710 ^ 1636738696);
      long var2 = Math.min(8371948595394939975L ^ 8371948595394967927L, (8371948595394968223L ^ 8371948595394967927L) << var1);
      long var4 = ThreadLocalRandom.current().nextLong(Math.max(1L, var2 / (8371948595394967923L ^ 8371948595394967927L)));
      return Math.min(8371948595394939975L ^ 8371948595394967927L, var2 + var4);
   }

   private synchronized boolean Π(String param1) {
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
      // 05: getfield x/ocdf3e495c45.Ћ Ljava/util/Set;
      // 08: iload 2
      // 09: ifne 20
      // 0c: aload 1
      // 0d: invokeinterface java/util/Set.add (Ljava/lang/Object;)Z 2
      // 12: ifne 1c
      // 15: goto 19
      // 18: athrow
      // 19: bipush 0
      // 1a: ireturn
      // 1b: athrow
      // 1c: aload 0
      // 1d: getfield x/ocdf3e495c45.Ћ Ljava/util/Set;
      // 20: invokeinterface java/util/Set.size ()I 1
      // 25: ldc_w -1333543890
      // 28: ldc_w -1333543378
      // 2b: ixor
      // 2c: if_icmple 6f
      // 2f: aload 0
      // 30: getfield x/ocdf3e495c45.Ћ Ljava/util/Set;
      // 33: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 38: astore 3
      // 39: iload 2
      // 3a: ifne 6b
      // 3d: aload 3
      // 3e: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 43: iload 2
      // 44: ifne 70
      // 47: goto 4b
      // 4a: athrow
      // 4b: ifne 5a
      // 4e: goto 52
      // 51: athrow
      // 52: iload 2
      // 53: ifeq 6f
      // 56: goto 5a
      // 59: athrow
      // 5a: aload 3
      // 5b: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 60: pop
      // 61: aload 3
      // 62: invokeinterface java/util/Iterator.remove ()V 1
      // 67: goto 6b
      // 6a: athrow
      // 6b: iload 2
      // 6c: ifeq 1c
      // 6f: bipush 1
      // 70: ireturn
   }

   private void ϣ(oce33cf14e5f var1) {
      this.Ω(oc293e52b538.ǳ(var1));
   }

   private void д(String var1, boolean var2) {
      ocdf3e495c45 var10000;
      String var10001;
      label16: {
         try {
            var10000 = this;
            if (var2) {
               var10001 = "§c";
               break label16;
            }
         } catch (IllegalStateException var5) {
            throw var5;
         }

         var10001 = "§f";
      }

      String var4 = var10001;
      var10000.Ω("§7[§dIRC§7] " + var4 + var1);
   }

   private void Ω(String var1) {
      this.ȫ.addScheduledTask(new ocd5282519b9(this, var1));
   }

   private String С() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce490879787.փ Z
      // 03: aload 0
      // 04: getfield x/ocdf3e495c45.ȫ Lnet/minecraft/client/Minecraft;
      // 07: invokevirtual net/minecraft/client/Minecraft.getCurrentServerData ()Lnet/minecraft/client/multiplayer/ServerData;
      // 0a: astore 2
      // 0b: istore 1
      // 0c: aload 2
      // 0d: iload 1
      // 0e: ifne 19
      // 11: ifnull 49
      // 14: goto 18
      // 17: athrow
      // 18: aload 2
      // 19: iload 1
      // 1a: ifne 2c
      // 1d: getfield net/minecraft/client/multiplayer/ServerData.serverIP Ljava/lang/String;
      // 20: ifnull 49
      // 23: goto 27
      // 26: athrow
      // 27: aload 2
      // 28: goto 2c
      // 2b: athrow
      // 2c: getfield net/minecraft/client/multiplayer/ServerData.serverIP Ljava/lang/String;
      // 2f: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 32: invokevirtual java/lang/String.isEmpty ()Z
      // 35: iload 1
      // 36: ifne 50
      // 39: ifne 49
      // 3c: goto 40
      // 3f: athrow
      // 40: aload 2
      // 41: getfield net/minecraft/client/multiplayer/ServerData.serverIP Ljava/lang/String;
      // 44: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 47: areturn
      // 48: athrow
      // 49: aload 0
      // 4a: getfield x/ocdf3e495c45.ȫ Lnet/minecraft/client/Minecraft;
      // 4d: invokevirtual net/minecraft/client/Minecraft.isSingleplayer ()Z
      // 50: ifeq 5a
      // 53: ldc_w "Singleplayer"
      // 56: goto 5d
      // 59: athrow
      // 5a: ldc_w "Main Menu"
      // 5d: areturn
   }

   private static String բ(String param0) {
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
      // 25: areturn
   }

   private boolean ӗ() {
      boolean var1 = oce490879787.փ;

      try {
         boolean var10000 = this.ʙ.equals(ǉ(this.ȫ.getSession()));
         if (var1) {
            return var10000;
         }

         if (!var10000) {
            return true;
         }
      } catch (IllegalStateException var2) {
         throw var2;
      }

      return false;
   }

   static String ǉ(Session param0) {
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
      // 06: ifne 15
      // 09: ifnonnull 14
      // 0c: goto 10
      // 0f: athrow
      // 10: ldc ""
      // 12: areturn
      // 13: athrow
      // 14: aload 0
      // 15: invokevirtual net/minecraft/util/Session.getUsername ()Ljava/lang/String;
      // 18: invokestatic x/ocdf3e495c45.ǒ (Ljava/lang/String;)Ljava/lang/String;
      // 1b: aload 0
      // 1c: invokevirtual net/minecraft/util/Session.getPlayerID ()Ljava/lang/String;
      // 1f: invokestatic x/ocdf3e495c45.բ (Ljava/lang/String;)Ljava/lang/String;
      // 22: aload 0
      // 23: invokevirtual net/minecraft/util/Session.getToken ()Ljava/lang/String;
      // 26: invokestatic x/ocdf3e495c45.ǒ (Ljava/lang/String;)Ljava/lang/String;
      // 29: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0000\u0001\u0000\u0001" ]
      // 2e: areturn
   }

   private static String ǒ(String var0) {
      boolean var1 = oce490879787.փ;

      try {
         if (var1) {
            return var0;
         }

         if (var0 == null) {
            return "";
         }
      } catch (IllegalStateException var2) {
         throw var2;
      }

      return var0;
   }

   private synchronized void Ӛ() {
      this.т = "";
      this.Ԛ = "";
      this.B = "";
      this.ˣ = 0L;
      oc9e2e8d26de.Ё();
   }

   private boolean ӣ(boolean param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce490879787.փ Z
      // 03: invokestatic java/lang/System.currentTimeMillis ()J
      // 06: lstore 3
      // 07: istore 2
      // 08: iload 1
      // 09: iload 2
      // 0a: ifne 3e
      // 0d: ifne 37
      // 10: goto 14
      // 13: athrow
      // 14: lload 3
      // 15: aload 0
      // 16: getfield x/ocdf3e495c45.Ӣ J
      // 19: lsub
      // 1a: ldc2_w 3344658801680941341
      // 1d: ldc2_w 3344658801680961341
      // 20: lxor
      // 21: lcmp
      // 22: iload 2
      // 23: ifne 3e
      // 26: goto 2a
      // 29: athrow
      // 2a: ifge 37
      // 2d: goto 31
      // 30: athrow
      // 31: aload 0
      // 32: getfield x/ocdf3e495c45.ֆ Z
      // 35: ireturn
      // 36: athrow
      // 37: aload 0
      // 38: getfield x/ocdf3e495c45.Ō Lx/oce490879787;
      // 3b: invokevirtual x/oce490879787.ɍ ()Z
      // 3e: istore 5
      // 40: aload 0
      // 41: lload 3
      // 42: putfield x/ocdf3e495c45.Ӣ J
      // 45: iload 5
      // 47: iload 2
      // 48: ifne 5c
      // 4b: ifne 58
      // 4e: goto 52
      // 51: athrow
      // 52: aload 0
      // 53: invokevirtual x/ocdf3e495c45.õ ()V
      // 56: bipush 0
      // 57: ireturn
      // 58: aload 0
      // 59: getfield x/ocdf3e495c45.ֆ Z
      // 5c: iload 2
      // 5d: ifne 68
      // 60: ifne 6b
      // 63: goto 67
      // 66: athrow
      // 67: bipush 1
      // 68: goto 6c
      // 6b: bipush 0
      // 6c: istore 6
      // 6e: aload 0
      // 6f: bipush 1
      // 70: putfield x/ocdf3e495c45.ֆ Z
      // 73: iload 6
      // 75: iload 2
      // 76: ifne c3
      // 79: ifeq c2
      // 7c: goto 80
      // 7f: athrow
      // 80: aload 0
      // 81: bipush 0
      // 82: putfield x/ocdf3e495c45.ˡ I
      // 85: aload 0
      // 86: lconst_0
      // 87: putfield x/ocdf3e495c45.č J
      // 8a: aload 0
      // 8b: dup
      // 8c: astore 7
      // 8e: monitorenter
      // 8f: aload 0
      // 90: getfield x/ocdf3e495c45.Ƙ Z
      // 93: iload 2
      // 94: ifne 9e
      // 97: ifeq b4
      // 9a: aload 0
      // 9b: getfield x/ocdf3e495c45.Ӧ Z
      // 9e: iload 2
      // 9f: ifne ac
      // a2: ifne b4
      // a5: aload 0
      // a6: getfield x/ocdf3e495c45.Ɂ Lx/oc89e52ca90f;
      // a9: invokevirtual x/oc89e52ca90f.Ā ()Z
      // ac: ifne b4
      // af: aload 0
      // b0: lconst_0
      // b1: invokevirtual x/ocdf3e495c45.È (J)V
      // b4: aload 7
      // b6: monitorexit
      // b7: goto c2
      // ba: astore 8
      // bc: aload 7
      // be: monitorexit
      // bf: aload 8
      // c1: athrow
      // c2: bipush 1
      // c3: ireturn
      // c4: astore 5
      // c6: aload 0
      // c7: lload 3
      // c8: putfield x/ocdf3e495c45.Ӣ J
      // cb: aload 0
      // cc: getfield x/ocdf3e495c45.ֆ Z
      // cf: ireturn
   }

   private void õ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce490879787.փ Z
      // 03: aload 0
      // 04: dup
      // 05: astore 3
      // 06: monitorenter
      // 07: istore 1
      // 08: aload 0
      // 09: getfield x/ocdf3e495c45.ֆ Z
      // 0c: istore 2
      // 0d: aload 0
      // 0e: bipush 0
      // 0f: putfield x/ocdf3e495c45.ֆ Z
      // 12: aload 0
      // 13: bipush 0
      // 14: putfield x/ocdf3e495c45.ո Z
      // 17: aload 0
      // 18: bipush 0
      // 19: putfield x/ocdf3e495c45.Д Z
      // 1c: aload 0
      // 1d: invokevirtual x/ocdf3e495c45.Յ ()V
      // 20: aload 3
      // 21: monitorexit
      // 22: goto 2c
      // 25: astore 4
      // 27: aload 3
      // 28: monitorexit
      // 29: aload 4
      // 2b: athrow
      // 2c: aload 0
      // 2d: invokevirtual x/ocdf3e495c45.Ӛ ()V
      // 30: aload 0
      // 31: bipush 0
      // 32: putfield x/ocdf3e495c45.Ɓ I
      // 35: invokestatic x/oc9e2e8d26de.Ё ()V
      // 38: aload 0
      // 39: getfield x/ocdf3e495c45.Ɂ Lx/oc89e52ca90f;
      // 3c: invokevirtual x/oc89e52ca90f.w ()V
      // 3f: iload 2
      // 40: iload 1
      // 41: ifne 53
      // 44: ifeq 61
      // 47: goto 4b
      // 4a: athrow
      // 4b: aload 0
      // 4c: getfield x/ocdf3e495c45.Ƙ Z
      // 4f: goto 53
      // 52: athrow
      // 53: ifeq 61
      // 56: aload 0
      // 57: ldc "IRC is disabled globally."
      // 59: bipush 1
      // 5a: invokevirtual x/ocdf3e495c45.д (Ljava/lang/String;Z)V
      // 5d: goto 61
      // 60: athrow
      // 61: return
   }
}

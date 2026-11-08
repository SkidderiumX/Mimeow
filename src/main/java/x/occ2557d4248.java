package x;

import java.util.Objects;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;
import net.arikia.dev.drpc.DiscordRichPresence.Builder;
import net.minecraft.client.Minecraft;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class occ2557d4248 {
   private static final Logger q = LogManager.getLogger("Mimeow Discord RPC");
   private static final occ2557d4248 ɼ = new occ2557d4248();
   private static final Pattern Π = Pattern.compile("[0-9]{17,20}");
   private static final long ʍ = TimeUnit.SECONDS.toNanos(2815310356516258000L ^ 2815310356516258015L);
   private static final String с = "Version: 2.5";
   private static final int ͼ = 100;
   private final Object Ο = new Object();
   private ScheduledExecutorService ŋ;
   private DiscordEventHandlers Ǌ;
   private String ó;
   private long ӌ;
   private long ˀ;
   private boolean ȁ;
   public static boolean Ü;

   private occ2557d4248() {
   }

   public static occ2557d4248 Ų() {
      return ɼ;
   }

   public void Ԁ(Minecraft param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc69da1aa7f5.ԡ I
      // 003: istore 2
      // 004: iload 2
      // 005: ldc "mimeow.discord.applicationId"
      // 007: ldc "MIMEOW_DISCORD_APPLICATION_ID"
      // 009: ldc "1512760893895872602"
      // 00b: invokestatic x/occ2557d4248.Ⱦ (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 00e: astore 3
      // 00f: ifne 031
      // 012: getstatic x/occ2557d4248.Π Ljava/util/regex/Pattern;
      // 015: aload 3
      // 016: invokevirtual java/util/regex/Pattern.matcher (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
      // 019: invokevirtual java/util/regex/Matcher.matches ()Z
      // 01c: ifne 032
      // 01f: goto 023
      // 022: athrow
      // 023: getstatic x/occ2557d4248.q Lorg/apache/logging/log4j/Logger;
      // 026: ldc "Discord Rich Presence is disabled because its application ID is missing or invalid"
      // 028: invokeinterface org/apache/logging/log4j/Logger.warn (Ljava/lang/String;)V 2
      // 02d: goto 031
      // 030: athrow
      // 031: return
      // 032: aload 0
      // 033: getfield x/occ2557d4248.Ο Ljava/lang/Object;
      // 036: dup
      // 037: astore 4
      // 039: monitorenter
      // 03a: iload 2
      // 03b: ifne 09b
      // 03e: aload 0
      // 03f: getfield x/occ2557d4248.ȁ Z
      // 042: ifeq 049
      // 045: aload 4
      // 047: monitorexit
      // 048: return
      // 049: aload 0
      // 04a: new net/arikia/dev/drpc/DiscordEventHandlers$Builder
      // 04d: dup
      // 04e: invokespecial net/arikia/dev/drpc/DiscordEventHandlers$Builder.<init> ()V
      // 051: invokevirtual net/arikia/dev/drpc/DiscordEventHandlers$Builder.build ()Lnet/arikia/dev/drpc/DiscordEventHandlers;
      // 054: putfield x/occ2557d4248.Ǌ Lnet/arikia/dev/drpc/DiscordEventHandlers;
      // 057: aload 3
      // 058: aload 0
      // 059: getfield x/occ2557d4248.Ǌ Lnet/arikia/dev/drpc/DiscordEventHandlers;
      // 05c: bipush 0
      // 05d: invokestatic net/arikia/dev/drpc/DiscordRPC.discordInitialize (Ljava/lang/String;Lnet/arikia/dev/drpc/DiscordEventHandlers;Z)V
      // 060: aload 0
      // 061: invokestatic java/lang/System.currentTimeMillis ()J
      // 064: ldc2_w -6184853848856002141
      // 067: ldc2_w -6184853848856001973
      // 06a: lxor
      // 06b: ldiv
      // 06c: putfield x/occ2557d4248.ˀ J
      // 06f: aload 0
      // 070: bipush 1
      // 071: putfield x/occ2557d4248.ȁ Z
      // 074: aload 0
      // 075: invokedynamic newThread ()Ljava/util/concurrent/ThreadFactory; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Runnable;)Ljava/lang/Thread;, x/occ2557d4248.q15d7mr9ctxxtl (Ljava/lang/Runnable;)Ljava/lang/Thread;, (Ljava/lang/Runnable;)Ljava/lang/Thread; ]
      // 07a: invokestatic java/util/concurrent/Executors.newSingleThreadScheduledExecutor (Ljava/util/concurrent/ThreadFactory;)Ljava/util/concurrent/ScheduledExecutorService;
      // 07d: putfield x/occ2557d4248.ŋ Ljava/util/concurrent/ScheduledExecutorService;
      // 080: aload 0
      // 081: getfield x/occ2557d4248.ŋ Ljava/util/concurrent/ScheduledExecutorService;
      // 084: aload 0
      // 085: invokedynamic run (Lx/occ2557d4248;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, x/occ2557d4248.ҭ ()V, ()V ]
      // 08a: lconst_0
      // 08b: ldc2_w -6184853848856001975
      // 08e: ldc2_w -6184853848856001973
      // 091: lxor
      // 092: getstatic java/util/concurrent/TimeUnit.SECONDS Ljava/util/concurrent/TimeUnit;
      // 095: invokeinterface java/util/concurrent/ScheduledExecutorService.scheduleWithFixedDelay (Ljava/lang/Runnable;JJLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture; 7
      // 09a: pop
      // 09b: goto 0de
      // 09e: astore 5
      // 0a0: iload 2
      // 0a1: aload 0
      // 0a2: getfield x/occ2557d4248.ŋ Ljava/util/concurrent/ScheduledExecutorService;
      // 0a5: astore 6
      // 0a7: aload 0
      // 0a8: aconst_null
      // 0a9: putfield x/occ2557d4248.ŋ Ljava/util/concurrent/ScheduledExecutorService;
      // 0ac: aload 0
      // 0ad: bipush 0
      // 0ae: putfield x/occ2557d4248.ȁ Z
      // 0b1: ifne 0c9
      // 0b4: aload 0
      // 0b5: aconst_null
      // 0b6: putfield x/occ2557d4248.Ǌ Lnet/arikia/dev/drpc/DiscordEventHandlers;
      // 0b9: aload 6
      // 0bb: ifnull 0c6
      // 0be: aload 6
      // 0c0: invokeinterface java/util/concurrent/ScheduledExecutorService.shutdownNow ()Ljava/util/List; 1
      // 0c5: pop
      // 0c6: invokestatic net/arikia/dev/drpc/DiscordRPC.discordShutdown ()V
      // 0c9: goto 0ce
      // 0cc: astore 7
      // 0ce: getstatic x/occ2557d4248.q Lorg/apache/logging/log4j/Logger;
      // 0d1: ldc "Unable to start Discord Rich Presence"
      // 0d3: aload 5
      // 0d5: invokeinterface org/apache/logging/log4j/Logger.warn (Ljava/lang/String;Ljava/lang/Throwable;)V 3
      // 0da: aload 4
      // 0dc: monitorexit
      // 0dd: return
      // 0de: aload 4
      // 0e0: monitorexit
      // 0e1: goto 0ec
      // 0e4: astore 8
      // 0e6: aload 4
      // 0e8: monitorexit
      // 0e9: aload 8
      // 0eb: athrow
      // 0ec: aload 0
      // 0ed: aload 1
      // 0ee: bipush 1
      // 0ef: invokevirtual x/occ2557d4248.պ (Lnet/minecraft/client/Minecraft;Z)V
      // 0f2: iload 2
      // 0f3: ifeq 107
      // 0f6: bipush 0
      // 0f7: ifeq 103
      // 0fa: goto 0fe
      // 0fd: athrow
      // 0fe: bipush 0
      // 0ff: goto 104
      // 102: athrow
      // 103: bipush 1
      // 104: putstatic x/oc69da1aa7f5.Ҭ Z
      // 107: return
   }

   public void ɺ(Minecraft var1) {
      this.պ(var1, false);
   }

   public void ė() {
      this.ҹ(null, true);
   }

   private void պ(Minecraft var1, boolean var2) {
      String var4 = "Playing on " + Ǽ(var1);
      int var10000 = oc69da1aa7f5.ԡ;
      long var5 = System.nanoTime();
      Throwable var7 = null;
      int var3 = var10000;
      synchronized (this.Ο) {
         var10000 = this.ȁ;
         if (var3 == 0) {
            if (!this.ȁ) {
               return;
            }

            var10000 = var2;
         }

         label65: {
            if (var3 == 0) {
               if (var10000 != 0) {
                  break label65;
               }

               var10000 = Objects.equals(this.ó, var4);
            }

            if (var3 == 0) {
               if (var10000 == 0) {
                  break label65;
               }

               long var16;
               var10000 = (var16 = var5 - this.ӌ) == 0L ? 0 : (var16 < 0L ? -1 : 1);
            }

            if (var10000 < 0) {
               return;
            }
         }

         DiscordRichPresence var9 = new Builder("Version: 2.5").setDetails(var4).setStartTimestamps(this.ˀ).build();

         try {
            DiscordRPC.discordUpdatePresence(var9);
            this.ó = var4;
            this.ӌ = var5 + ʍ;
         } catch (Throwable var13) {
            var7 = var13;
         }
      }

      try {
         if (var7 != null) {
            this.ҹ(var7, false);
         }
      } catch (Throwable var12) {
         throw var12;
      }
   }

   private void ҭ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1057)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.insertSemaphore(FinallyProcessor.java:350)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:99)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:178)
      //
      // Bytecode:
      // 00: getstatic x/oc69da1aa7f5.ԡ I
      // 03: aconst_null
      // 04: astore 2
      // 05: istore 1
      // 06: aload 0
      // 07: getfield x/occ2557d4248.Ο Ljava/lang/Object;
      // 0a: dup
      // 0b: astore 3
      // 0c: monitorenter
      // 0d: iload 1
      // 0e: ifne 1e
      // 11: aload 0
      // 12: getfield x/occ2557d4248.ȁ Z
      // 15: ifne 1b
      // 18: aload 3
      // 19: monitorexit
      // 1a: return
      // 1b: invokestatic net/arikia/dev/drpc/DiscordRPC.discordRunCallbacks ()V
      // 1e: goto 26
      // 21: astore 4
      // 23: aload 4
      // 25: astore 2
      // 26: aload 3
      // 27: monitorexit
      // 28: goto 32
      // 2b: astore 5
      // 2d: aload 3
      // 2e: monitorexit
      // 2f: aload 5
      // 31: athrow
      // 32: aload 2
      // 33: ifnull 40
      // 36: aload 0
      // 37: aload 2
      // 38: bipush 0
      // 39: invokevirtual x/occ2557d4248.ҹ (Ljava/lang/Throwable;Z)V
      // 3c: goto 40
      // 3f: athrow
      // 40: return
   }

   private void ҹ(Throwable param1, boolean param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1057)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.insertSemaphore(FinallyProcessor.java:350)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:99)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:178)
      //
      // Bytecode:
      // 00: getstatic x/oc69da1aa7f5.ԡ I
      // 03: istore 3
      // 04: iload 3
      // 05: aload 0
      // 06: getfield x/occ2557d4248.Ο Ljava/lang/Object;
      // 09: dup
      // 0a: astore 5
      // 0c: monitorenter
      // 0d: ifne 2b
      // 10: aload 0
      // 11: getfield x/occ2557d4248.ȁ Z
      // 14: ifne 26
      // 17: aload 0
      // 18: iload 3
      // 19: ifne 2c
      // 1c: getfield x/occ2557d4248.ŋ Ljava/util/concurrent/ScheduledExecutorService;
      // 1f: ifnonnull 26
      // 22: aload 5
      // 24: monitorexit
      // 25: return
      // 26: aload 0
      // 27: bipush 0
      // 28: putfield x/occ2557d4248.ȁ Z
      // 2b: aload 0
      // 2c: getfield x/occ2557d4248.ŋ Ljava/util/concurrent/ScheduledExecutorService;
      // 2f: astore 4
      // 31: iload 3
      // 32: ifne 44
      // 35: aload 0
      // 36: aconst_null
      // 37: putfield x/occ2557d4248.ŋ Ljava/util/concurrent/ScheduledExecutorService;
      // 3a: iload 2
      // 3b: ifeq 41
      // 3e: invokestatic net/arikia/dev/drpc/DiscordRPC.discordClearPresence ()V
      // 41: invokestatic net/arikia/dev/drpc/DiscordRPC.discordShutdown ()V
      // 44: goto 49
      // 47: astore 6
      // 49: aload 0
      // 4a: aconst_null
      // 4b: putfield x/occ2557d4248.Ǌ Lnet/arikia/dev/drpc/DiscordEventHandlers;
      // 4e: aload 0
      // 4f: aconst_null
      // 50: putfield x/occ2557d4248.ó Ljava/lang/String;
      // 53: aload 5
      // 55: monitorexit
      // 56: goto 61
      // 59: astore 7
      // 5b: aload 5
      // 5d: monitorexit
      // 5e: aload 7
      // 60: athrow
      // 61: aload 4
      // 63: iload 3
      // 64: ifne 70
      // 67: ifnull 76
      // 6a: goto 6e
      // 6d: athrow
      // 6e: aload 4
      // 70: invokeinterface java/util/concurrent/ScheduledExecutorService.shutdownNow ()Ljava/util/List; 1
      // 75: pop
      // 76: aload 1
      // 77: ifnull 8a
      // 7a: getstatic x/occ2557d4248.q Lorg/apache/logging/log4j/Logger;
      // 7d: ldc_w "Discord Rich Presence stopped after an RPC error"
      // 80: aload 1
      // 81: invokeinterface org/apache/logging/log4j/Logger.warn (Ljava/lang/String;Ljava/lang/Throwable;)V 3
      // 86: goto 8a
      // 89: athrow
      // 8a: return
   }

   private static String Ǽ(Minecraft param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc69da1aa7f5.ԡ I
      // 03: aload 0
      // 04: invokevirtual net/minecraft/client/Minecraft.getCurrentServerData ()Lnet/minecraft/client/multiplayer/ServerData;
      // 07: astore 2
      // 08: istore 1
      // 09: aload 2
      // 0a: iload 1
      // 0b: ifne 16
      // 0e: ifnull 8d
      // 11: goto 15
      // 14: athrow
      // 15: aload 2
      // 16: iload 1
      // 17: ifne 29
      // 1a: getfield net/minecraft/client/multiplayer/ServerData.serverIP Ljava/lang/String;
      // 1d: ifnull 8d
      // 20: goto 24
      // 23: athrow
      // 24: aload 2
      // 25: goto 29
      // 28: athrow
      // 29: getfield net/minecraft/client/multiplayer/ServerData.serverIP Ljava/lang/String;
      // 2c: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 2f: ldc_w 108276675
      // 32: ldc_w 108276686
      // 35: ixor
      // 36: ldc_w 108276718
      // 39: ldc_w 108276686
      // 3c: ixor
      // 3d: invokevirtual java/lang/String.replace (CC)Ljava/lang/String;
      // 40: ldc_w 108276676
      // 43: ldc_w 108276686
      // 46: ixor
      // 47: ldc_w 108276718
      // 4a: ldc_w 108276686
      // 4d: ixor
      // 4e: invokevirtual java/lang/String.replace (CC)Ljava/lang/String;
      // 51: astore 3
      // 52: aload 3
      // 53: invokevirtual java/lang/String.isEmpty ()Z
      // 56: iload 1
      // 57: ifne 91
      // 5a: ifne 8d
      // 5d: goto 61
      // 60: athrow
      // 61: aload 3
      // 62: iload 1
      // 63: ifne 81
      // 66: goto 6a
      // 69: athrow
      // 6a: invokevirtual java/lang/String.length ()I
      // 6d: ldc_w 108276650
      // 70: ldc_w 108276686
      // 73: ixor
      // 74: if_icmpgt 80
      // 77: goto 7b
      // 7a: athrow
      // 7b: aload 3
      // 7c: goto 8c
      // 7f: athrow
      // 80: aload 3
      // 81: bipush 0
      // 82: ldc_w 108276650
      // 85: ldc_w 108276686
      // 88: ixor
      // 89: invokevirtual java/lang/String.substring (II)Ljava/lang/String;
      // 8c: areturn
      // 8d: aload 0
      // 8e: invokevirtual net/minecraft/client/Minecraft.isSingleplayer ()Z
      // 91: ifeq 9b
      // 94: ldc_w "Singleplayer"
      // 97: goto 9e
      // 9a: athrow
      // 9b: ldc_w "Main Menu"
      // 9e: areturn
   }

   private static String Ⱦ(String param0, String param1, String param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc69da1aa7f5.ԡ I
      // 03: aload 0
      // 04: invokestatic java/lang/System.getProperty (Ljava/lang/String;)Ljava/lang/String;
      // 07: astore 4
      // 09: istore 3
      // 0a: aload 4
      // 0c: iload 3
      // 0d: ifne 36
      // 10: ifnull 2e
      // 13: goto 17
      // 16: athrow
      // 17: aload 4
      // 19: iload 3
      // 1a: ifne 3a
      // 1d: goto 21
      // 20: athrow
      // 21: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 24: invokevirtual java/lang/String.isEmpty ()Z
      // 27: ifeq 38
      // 2a: goto 2e
      // 2d: athrow
      // 2e: aload 1
      // 2f: invokestatic java/lang/System.getenv (Ljava/lang/String;)Ljava/lang/String;
      // 32: goto 36
      // 35: athrow
      // 36: astore 4
      // 38: aload 4
      // 3a: iload 3
      // 3b: ifne 61
      // 3e: ifnull 5c
      // 41: goto 45
      // 44: athrow
      // 45: aload 4
      // 47: iload 3
      // 48: ifne 66
      // 4b: goto 4f
      // 4e: athrow
      // 4f: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 52: invokevirtual java/lang/String.isEmpty ()Z
      // 55: ifeq 64
      // 58: goto 5c
      // 5b: athrow
      // 5c: aload 2
      // 5d: goto 61
      // 60: athrow
      // 61: goto 69
      // 64: aload 4
      // 66: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 69: areturn
   }
}

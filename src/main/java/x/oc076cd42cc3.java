package x;

import com.google.gson.JsonObject;
import java.net.URLEncoder;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicReference;

public class oc076cd42cc3 implements oc2bb55dd668 {
   private final String Ơ;
   private final String ϙ;
   private final oce7be97fef5 Ը;
   private final AtomicReference<ocbb1bc27172> Ӣ = new AtomicReference<>(ocbb1bc27172.ä);
   private final AtomicReference<oc5395d7bb80> Ş = new AtomicReference<>(oc5395d7bb80.Z);
   private final ScheduledExecutorService ɾ = Executors.newSingleThreadScheduledExecutor(var0 -> {
      Thread var1x = new Thread(var0, "Miau-LastFm");
      var1x.setDaemon(true);
      return var1x;
   });
   private volatile boolean ӟ;
   private ScheduledFuture<?> ʭ;
   private long ɰ = 6414303734975269559L ^ 6414303734975267087L;
   private final Random h = new Random();
   public static boolean ɏ;

   public oc076cd42cc3(String var1, String var2) {
      this(var1, var2, new oc4555106e5a());
   }

   oc076cd42cc3(String var1, String var2, oce7be97fef5 var3) {
      this.Ơ = var1;
      this.ϙ = var2;
      this.Ը = var3;
   }

   public synchronized void z$2uy6urhda6qc2() {
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
      // 06: ifne 31
      // 09: getfield x/oc076cd42cc3.ӟ Z
      // 0c: ifeq 15
      // 0f: goto 13
      // 12: athrow
      // 13: return
      // 14: athrow
      // 15: aload 0
      // 16: bipush 1
      // 17: putfield x/oc076cd42cc3.ӟ Z
      // 1a: aload 0
      // 1b: getfield x/oc076cd42cc3.Ş Ljava/util/concurrent/atomic/AtomicReference;
      // 1e: new x/oc5395d7bb80
      // 21: dup
      // 22: getstatic x/oc1131978c8d.ǡ Lx/oc1131978c8d;
      // 25: ldc "Connecting"
      // 27: ldc "Last.fm"
      // 29: lconst_0
      // 2a: invokespecial x/oc5395d7bb80.<init> (Lx/oc1131978c8d;Ljava/lang/String;Ljava/lang/String;J)V
      // 2d: invokevirtual java/util/concurrent/atomic/AtomicReference.set (Ljava/lang/Object;)V
      // 30: aload 0
      // 31: lconst_0
      // 32: invokevirtual x/oc076cd42cc3.Ą (J)V
      // 35: return
   }

   public synchronized void z$kdc1k1k7jgxc() {
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
      // 06: ifne 37
      // 09: bipush 0
      // 0a: putfield x/oc076cd42cc3.ӟ Z
      // 0d: aload 0
      // 0e: getfield x/oc076cd42cc3.ʭ Ljava/util/concurrent/ScheduledFuture;
      // 11: ifnull 27
      // 14: goto 18
      // 17: athrow
      // 18: aload 0
      // 19: getfield x/oc076cd42cc3.ʭ Ljava/util/concurrent/ScheduledFuture;
      // 1c: bipush 1
      // 1d: invokeinterface java/util/concurrent/ScheduledFuture.cancel (Z)Z 2
      // 22: pop
      // 23: goto 27
      // 26: athrow
      // 27: aload 0
      // 28: aconst_null
      // 29: putfield x/oc076cd42cc3.ʭ Ljava/util/concurrent/ScheduledFuture;
      // 2c: aload 0
      // 2d: getfield x/oc076cd42cc3.Ӣ Ljava/util/concurrent/atomic/AtomicReference;
      // 30: getstatic x/ocbb1bc27172.ä Lx/ocbb1bc27172;
      // 33: invokevirtual java/util/concurrent/atomic/AtomicReference.set (Ljava/lang/Object;)V
      // 36: aload 0
      // 37: getfield x/oc076cd42cc3.Ş Ljava/util/concurrent/atomic/AtomicReference;
      // 3a: getstatic x/oc5395d7bb80.Z Lx/oc5395d7bb80;
      // 3d: invokevirtual java/util/concurrent/atomic/AtomicReference.set (Ljava/lang/Object;)V
      // 40: return
   }

   private synchronized void Ą(long param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocbb1bc27172.ԍ I
      // 03: istore 3
      // 04: aload 0
      // 05: iload 3
      // 06: ifne 16
      // 09: getfield x/oc076cd42cc3.ӟ Z
      // 0c: ifne 15
      // 0f: goto 13
      // 12: athrow
      // 13: return
      // 14: athrow
      // 15: aload 0
      // 16: iload 3
      // 17: ifne 34
      // 1a: getfield x/oc076cd42cc3.ʭ Ljava/util/concurrent/ScheduledFuture;
      // 1d: ifnull 33
      // 20: goto 24
      // 23: athrow
      // 24: aload 0
      // 25: getfield x/oc076cd42cc3.ʭ Ljava/util/concurrent/ScheduledFuture;
      // 28: bipush 0
      // 29: invokeinterface java/util/concurrent/ScheduledFuture.cancel (Z)Z 2
      // 2e: pop
      // 2f: goto 33
      // 32: athrow
      // 33: aload 0
      // 34: aload 0
      // 35: getfield x/oc076cd42cc3.ɾ Ljava/util/concurrent/ScheduledExecutorService;
      // 38: aload 0
      // 39: invokedynamic run (Lx/oc076cd42cc3;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, x/oc076cd42cc3.մ ()V, ()V ]
      // 3e: lconst_0
      // 3f: lload 1
      // 40: invokestatic java/lang/Math.max (JJ)J
      // 43: getstatic java/util/concurrent/TimeUnit.MILLISECONDS Ljava/util/concurrent/TimeUnit;
      // 46: invokeinterface java/util/concurrent/ScheduledExecutorService.schedule (Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture; 5
      // 4b: putfield x/oc076cd42cc3.ʭ Ljava/util/concurrent/ScheduledFuture;
      // 4e: return
   }

   private void մ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/ocbb1bc27172.ԍ I
      // 003: istore 1
      // 004: aload 0
      // 005: iload 1
      // 006: ifne 016
      // 009: getfield x/oc076cd42cc3.ӟ Z
      // 00c: ifne 015
      // 00f: goto 013
      // 012: athrow
      // 013: return
      // 014: athrow
      // 015: aload 0
      // 016: getfield x/oc076cd42cc3.Ơ Ljava/lang/String;
      // 019: invokestatic x/oc076cd42cc3.ɦ (Ljava/lang/String;)Ljava/lang/String;
      // 01c: aload 0
      // 01d: getfield x/oc076cd42cc3.ϙ Ljava/lang/String;
      // 020: invokestatic x/oc076cd42cc3.ɦ (Ljava/lang/String;)Ljava/lang/String;
      // 023: ldc "https://ws.audioscrobbler.com/2.0/?method=user.getrecenttracks&user="
      // 025: dup_x2
      // 026: pop
      // 027: ldc "&api_key="
      // 029: swap
      // 02a: ldc "&format=json&limit=1"
      // 02c: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001\u0001\u0001" ]
      // 031: astore 2
      // 032: aload 0
      // 033: getfield x/oc076cd42cc3.Ը Lx/oce7be97fef5;
      // 036: ldc "GET"
      // 038: aload 2
      // 039: invokestatic x/oc6bed6d7740.ʉ (Ljava/lang/String;Ljava/lang/String;)Lx/oc173ab988a9;
      // 03c: invokevirtual x/oc173ab988a9.ʐ ()Lx/oc6bed6d7740;
      // 03f: invokeinterface x/oce7be97fef5.z$1ahjbl7dqoxur (Lx/oc6bed6d7740;)Lx/oc51f4f13c5a; 2
      // 044: astore 3
      // 045: aload 3
      // 046: invokevirtual x/oc51f4f13c5a.ѣ ()I
      // 049: ldc -610543110
      // 04b: ldc -610543310
      // 04d: ixor
      // 04e: if_icmpeq 066
      // 051: new java/io/IOException
      // 054: dup
      // 055: aload 3
      // 056: invokevirtual x/oc51f4f13c5a.ѣ ()I
      // 059: ldc "Last.fm HTTP "
      // 05b: swap
      // 05c: invokedynamic makeConcatWithConstants (Ljava/lang/String;I)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 061: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 064: athrow
      // 065: athrow
      // 066: new com/google/gson/JsonParser
      // 069: dup
      // 06a: invokespecial com/google/gson/JsonParser.<init> ()V
      // 06d: aload 3
      // 06e: invokevirtual x/oc51f4f13c5a.ʤ ()Ljava/lang/String;
      // 071: invokevirtual com/google/gson/JsonParser.parse (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 074: invokevirtual com/google/gson/JsonElement.getAsJsonObject ()Lcom/google/gson/JsonObject;
      // 077: astore 4
      // 079: aload 4
      // 07b: iload 1
      // 07c: ifne 098
      // 07f: ldc_w "recenttracks"
      // 082: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 085: ifeq 0a1
      // 088: goto 08c
      // 08b: athrow
      // 08c: aload 4
      // 08e: ldc_w "recenttracks"
      // 091: invokevirtual com/google/gson/JsonObject.getAsJsonObject (Ljava/lang/String;)Lcom/google/gson/JsonObject;
      // 094: goto 098
      // 097: athrow
      // 098: ldc_w "track"
      // 09b: invokevirtual com/google/gson/JsonObject.getAsJsonArray (Ljava/lang/String;)Lcom/google/gson/JsonArray;
      // 09e: goto 0a2
      // 0a1: aconst_null
      // 0a2: astore 5
      // 0a4: iload 1
      // 0a5: ifne 0f5
      // 0a8: aload 5
      // 0aa: ifnull 0c5
      // 0ad: goto 0b1
      // 0b0: athrow
      // 0b1: aload 5
      // 0b3: iload 1
      // 0b4: ifne 0fc
      // 0b7: goto 0bb
      // 0ba: athrow
      // 0bb: invokevirtual com/google/gson/JsonArray.size ()I
      // 0be: ifne 0f6
      // 0c1: goto 0c5
      // 0c4: athrow
      // 0c5: aload 0
      // 0c6: getfield x/oc076cd42cc3.Ӣ Ljava/util/concurrent/atomic/AtomicReference;
      // 0c9: getstatic x/ocbb1bc27172.ä Lx/ocbb1bc27172;
      // 0cc: invokevirtual java/util/concurrent/atomic/AtomicReference.set (Ljava/lang/Object;)V
      // 0cf: aload 0
      // 0d0: getfield x/oc076cd42cc3.Ş Ljava/util/concurrent/atomic/AtomicReference;
      // 0d3: new x/oc5395d7bb80
      // 0d6: dup
      // 0d7: getstatic x/oc1131978c8d.У Lx/oc1131978c8d;
      // 0da: ldc_w "No playback"
      // 0dd: ldc "Last.fm"
      // 0df: lconst_0
      // 0e0: invokespecial x/oc5395d7bb80.<init> (Lx/oc1131978c8d;Ljava/lang/String;Ljava/lang/String;J)V
      // 0e3: invokevirtual java/util/concurrent/atomic/AtomicReference.set (Ljava/lang/Object;)V
      // 0e6: aload 0
      // 0e7: ldc2_w 1014073239677745662
      // 0ea: ldc2_w 1014073239677741686
      // 0ed: lxor
      // 0ee: invokevirtual x/oc076cd42cc3.Ą (J)V
      // 0f1: goto 0f5
      // 0f4: athrow
      // 0f5: return
      // 0f6: aload 5
      // 0f8: bipush 0
      // 0f9: invokevirtual com/google/gson/JsonArray.get (I)Lcom/google/gson/JsonElement;
      // 0fc: invokevirtual com/google/gson/JsonElement.getAsJsonObject ()Lcom/google/gson/JsonObject;
      // 0ff: astore 6
      // 101: aload 6
      // 103: ldc_w "@attr"
      // 106: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 109: iload 1
      // 10a: ifne 12c
      // 10d: ifeq 13b
      // 110: goto 114
      // 113: athrow
      // 114: ldc_w "true"
      // 117: aload 6
      // 119: ldc_w "@attr"
      // 11c: invokevirtual com/google/gson/JsonObject.getAsJsonObject (Ljava/lang/String;)Lcom/google/gson/JsonObject;
      // 11f: ldc_w "nowplaying"
      // 122: invokestatic x/oc076cd42cc3.Ɣ (Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/String;
      // 125: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 128: goto 12c
      // 12b: athrow
      // 12c: iload 1
      // 12d: ifne 138
      // 130: ifeq 13b
      // 133: goto 137
      // 136: athrow
      // 137: bipush 1
      // 138: goto 13c
      // 13b: bipush 0
      // 13c: istore 7
      // 13e: iload 7
      // 140: iload 1
      // 141: ifne 188
      // 144: ifne 178
      // 147: goto 14b
      // 14a: athrow
      // 14b: aload 0
      // 14c: getfield x/oc076cd42cc3.Ӣ Ljava/util/concurrent/atomic/AtomicReference;
      // 14f: getstatic x/ocbb1bc27172.ä Lx/ocbb1bc27172;
      // 152: invokevirtual java/util/concurrent/atomic/AtomicReference.set (Ljava/lang/Object;)V
      // 155: aload 0
      // 156: getfield x/oc076cd42cc3.Ş Ljava/util/concurrent/atomic/AtomicReference;
      // 159: new x/oc5395d7bb80
      // 15c: dup
      // 15d: getstatic x/oc1131978c8d.У Lx/oc1131978c8d;
      // 160: ldc_w "Paused"
      // 163: ldc "Last.fm"
      // 165: lconst_0
      // 166: invokespecial x/oc5395d7bb80.<init> (Lx/oc1131978c8d;Ljava/lang/String;Ljava/lang/String;J)V
      // 169: invokevirtual java/util/concurrent/atomic/AtomicReference.set (Ljava/lang/Object;)V
      // 16c: aload 0
      // 16d: ldc2_w 1014073239677745662
      // 170: ldc2_w 1014073239677741686
      // 173: lxor
      // 174: invokevirtual x/oc076cd42cc3.Ą (J)V
      // 177: return
      // 178: aload 6
      // 17a: iload 1
      // 17b: ifne 197
      // 17e: ldc_w "artist"
      // 181: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 184: goto 188
      // 187: athrow
      // 188: ifeq 1a0
      // 18b: aload 6
      // 18d: ldc_w "artist"
      // 190: invokevirtual com/google/gson/JsonObject.getAsJsonObject (Ljava/lang/String;)Lcom/google/gson/JsonObject;
      // 193: goto 197
      // 196: athrow
      // 197: ldc_w "#text"
      // 19a: invokestatic x/oc076cd42cc3.Ɣ (Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/String;
      // 19d: goto 1a3
      // 1a0: ldc_w ""
      // 1a3: astore 8
      // 1a5: aload 6
      // 1a7: iload 1
      // 1a8: ifne 1c9
      // 1ab: ldc_w "url"
      // 1ae: invokestatic x/oc076cd42cc3.Ɣ (Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/String;
      // 1b1: invokevirtual java/lang/String.isEmpty ()Z
      // 1b4: ifne 1c7
      // 1b7: goto 1bb
      // 1ba: athrow
      // 1bb: aload 6
      // 1bd: ldc_w "url"
      // 1c0: invokestatic x/oc076cd42cc3.Ɣ (Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/String;
      // 1c3: goto 1cf
      // 1c6: athrow
      // 1c7: aload 6
      // 1c9: ldc_w "mbid"
      // 1cc: invokestatic x/oc076cd42cc3.Ɣ (Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/String;
      // 1cf: astore 9
      // 1d1: aload 0
      // 1d2: getfield x/oc076cd42cc3.Ӣ Ljava/util/concurrent/atomic/AtomicReference;
      // 1d5: new x/ocbb1bc27172
      // 1d8: dup
      // 1d9: bipush 1
      // 1da: aload 6
      // 1dc: ldc_w "name"
      // 1df: invokestatic x/oc076cd42cc3.Ɣ (Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/String;
      // 1e2: aload 8
      // 1e4: aload 6
      // 1e6: invokestatic x/oc076cd42cc3.ǖ (Lcom/google/gson/JsonObject;)Ljava/lang/String;
      // 1e9: aload 9
      // 1eb: invokespecial x/ocbb1bc27172.<init> (ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
      // 1ee: invokevirtual java/util/concurrent/atomic/AtomicReference.set (Ljava/lang/Object;)V
      // 1f1: aload 0
      // 1f2: getfield x/oc076cd42cc3.Ş Ljava/util/concurrent/atomic/AtomicReference;
      // 1f5: new x/oc5395d7bb80
      // 1f8: dup
      // 1f9: getstatic x/oc1131978c8d.ʏ Lx/oc1131978c8d;
      // 1fc: ldc_w "Playing"
      // 1ff: ldc "Last.fm"
      // 201: lconst_0
      // 202: invokespecial x/oc5395d7bb80.<init> (Lx/oc1131978c8d;Ljava/lang/String;Ljava/lang/String;J)V
      // 205: invokevirtual java/util/concurrent/atomic/AtomicReference.set (Ljava/lang/Object;)V
      // 208: aload 0
      // 209: ldc2_w 1014073239677739470
      // 20c: ldc2_w 1014073239677741686
      // 20f: lxor
      // 210: putfield x/oc076cd42cc3.ɰ J
      // 213: aload 0
      // 214: ldc2_w 1014073239677739470
      // 217: ldc2_w 1014073239677741686
      // 21a: lxor
      // 21b: invokevirtual x/oc076cd42cc3.Ą (J)V
      // 21e: goto 27a
      // 221: astore 2
      // 222: ldc2_w 1014073239677755206
      // 225: ldc2_w 1014073239677741686
      // 228: lxor
      // 229: aload 0
      // 22a: getfield x/oc076cd42cc3.ɰ J
      // 22d: invokestatic java/lang/Math.min (JJ)J
      // 230: aload 0
      // 231: getfield x/oc076cd42cc3.h Ljava/util/Random;
      // 234: ldc_w -610543417
      // 237: ldc -610543310
      // 239: ixor
      // 23a: invokevirtual java/util/Random.nextInt (I)I
      // 23d: i2l
      // 23e: ladd
      // 23f: lstore 3
      // 240: aload 0
      // 241: ldc2_w 1014073239677755206
      // 244: ldc2_w 1014073239677741686
      // 247: lxor
      // 248: aload 0
      // 249: getfield x/oc076cd42cc3.ɰ J
      // 24c: ldc2_w 1014073239677741684
      // 24f: ldc2_w 1014073239677741686
      // 252: lxor
      // 253: lmul
      // 254: invokestatic java/lang/Math.min (JJ)J
      // 257: putfield x/oc076cd42cc3.ɰ J
      // 25a: aload 0
      // 25b: getfield x/oc076cd42cc3.Ş Ljava/util/concurrent/atomic/AtomicReference;
      // 25e: new x/oc5395d7bb80
      // 261: dup
      // 262: getstatic x/oc1131978c8d.ȁ Lx/oc1131978c8d;
      // 265: ldc_w "Last.fm connection error"
      // 268: ldc "Last.fm"
      // 26a: invokestatic java/lang/System.currentTimeMillis ()J
      // 26d: lload 3
      // 26e: ladd
      // 26f: invokespecial x/oc5395d7bb80.<init> (Lx/oc1131978c8d;Ljava/lang/String;Ljava/lang/String;J)V
      // 272: invokevirtual java/util/concurrent/atomic/AtomicReference.set (Ljava/lang/Object;)V
      // 275: aload 0
      // 276: lload 3
      // 277: invokevirtual x/oc076cd42cc3.Ą (J)V
      // 27a: return
   }

   private static String ǖ(JsonObject param0) {
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
      // 05: ldc_w "image"
      // 08: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 0b: ifne 13
      // 0e: ldc_w ""
      // 11: areturn
      // 12: athrow
      // 13: ldc_w ""
      // 16: astore 2
      // 17: aload 0
      // 18: ldc_w "image"
      // 1b: invokevirtual com/google/gson/JsonObject.getAsJsonArray (Ljava/lang/String;)Lcom/google/gson/JsonArray;
      // 1e: invokevirtual com/google/gson/JsonArray.iterator ()Ljava/util/Iterator;
      // 21: astore 3
      // 22: aload 3
      // 23: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 28: ifeq 62
      // 2b: aload 3
      // 2c: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 31: checkcast com/google/gson/JsonElement
      // 34: astore 4
      // 36: aload 4
      // 38: invokevirtual com/google/gson/JsonElement.getAsJsonObject ()Lcom/google/gson/JsonObject;
      // 3b: ldc_w "#text"
      // 3e: invokestatic x/oc076cd42cc3.Ɣ (Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/String;
      // 41: iload 1
      // 42: ifne 63
      // 45: astore 5
      // 47: aload 5
      // 49: iload 1
      // 4a: ifne 5d
      // 4d: invokevirtual java/lang/String.isEmpty ()Z
      // 50: ifne 5e
      // 53: goto 57
      // 56: athrow
      // 57: aload 5
      // 59: goto 5d
      // 5c: athrow
      // 5d: astore 2
      // 5e: iload 1
      // 5f: ifeq 22
      // 62: aload 2
      // 63: areturn
   }

   private static String Ɣ(JsonObject param0, String param1) {
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
      // 06: ifne 11
      // 09: ifnull 46
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 0
      // 11: aload 1
      // 12: iload 2
      // 13: ifne 2e
      // 16: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 19: ifeq 46
      // 1c: goto 20
      // 1f: athrow
      // 20: aload 0
      // 21: iload 2
      // 22: ifne 40
      // 25: goto 29
      // 28: athrow
      // 29: aload 1
      // 2a: goto 2e
      // 2d: athrow
      // 2e: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 31: invokevirtual com/google/gson/JsonElement.isJsonNull ()Z
      // 34: ifne 46
      // 37: aload 0
      // 38: aload 1
      // 39: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 3c: goto 40
      // 3f: athrow
      // 40: invokevirtual com/google/gson/JsonElement.getAsString ()Ljava/lang/String;
      // 43: goto 49
      // 46: ldc_w ""
      // 49: areturn
   }

   private static String ɦ(String var0) throws Exception {
      return URLEncoder.encode(var0, "UTF-8");
   }

   public ocbb1bc27172 z$26y7m47raszk() {
      return this.Ӣ.get();
   }

   public oc5395d7bb80 z$2x2pifjatcjkd() {
      return this.Ş.get();
   }

   public String z$eij0v3yu6as3() {
      return "Last.fm";
   }

   public boolean z$3c74bdt0l3yea() {
      return this.ӟ;
   }
}

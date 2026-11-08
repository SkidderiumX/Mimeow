package x;

import com.google.gson.JsonObject;
import java.net.URLEncoder;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class oc03bc465855 {
   private final oce7be97fef5 ф = new oc4555106e5a();
   private final ExecutorService ұ = Executors.newSingleThreadExecutor(var0 -> {
      Thread var1 = new Thread(var0, "Miau-Lyrics");
      var1.setDaemon(true);
      return var1;
   });
   private final AtomicReference<oc142532d567> ƚ = new AtomicReference<>(oc142532d567.a);
   private final AtomicLong U = new AtomicLong();
   private volatile String ƛ = "";
   public static boolean ɺ;

   public void ӻ(ocbb1bc27172 param1) {
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
      // 06: ifne 11
      // 09: ifnull 34
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 1
      // 11: invokevirtual x/ocbb1bc27172.B ()Ljava/lang/String;
      // 14: iload 2
      // 15: ifne 2a
      // 18: invokevirtual java/lang/String.isEmpty ()Z
      // 1b: ifne 34
      // 1e: goto 22
      // 21: athrow
      // 22: aload 1
      // 23: invokevirtual x/ocbb1bc27172.B ()Ljava/lang/String;
      // 26: goto 2a
      // 29: athrow
      // 2a: aload 0
      // 2b: getfield x/oc03bc465855.ƛ Ljava/lang/String;
      // 2e: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 31: ifeq 36
      // 34: return
      // 35: athrow
      // 36: aload 0
      // 37: aload 1
      // 38: invokevirtual x/ocbb1bc27172.B ()Ljava/lang/String;
      // 3b: putfield x/oc03bc465855.ƛ Ljava/lang/String;
      // 3e: aload 0
      // 3f: getfield x/oc03bc465855.U Ljava/util/concurrent/atomic/AtomicLong;
      // 42: invokevirtual java/util/concurrent/atomic/AtomicLong.incrementAndGet ()J
      // 45: lstore 3
      // 46: aload 0
      // 47: getfield x/oc03bc465855.ƚ Ljava/util/concurrent/atomic/AtomicReference;
      // 4a: new x/oc142532d567
      // 4d: dup
      // 4e: aload 0
      // 4f: getfield x/oc03bc465855.ƛ Ljava/lang/String;
      // 52: invokestatic java/util/Collections.emptyList ()Ljava/util/List;
      // 55: bipush 0
      // 56: bipush 1
      // 57: invokespecial x/oc142532d567.<init> (Ljava/lang/String;Ljava/util/List;ZZ)V
      // 5a: invokevirtual java/util/concurrent/atomic/AtomicReference.set (Ljava/lang/Object;)V
      // 5d: aload 0
      // 5e: getfield x/oc03bc465855.ұ Ljava/util/concurrent/ExecutorService;
      // 61: aload 0
      // 62: aload 1
      // 63: lload 3
      // 64: invokedynamic run (Lx/oc03bc465855;Lx/ocbb1bc27172;J)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, x/oc03bc465855.q34xne78sqrz6x (Lx/ocbb1bc27172;J)V, ()V ]
      // 69: invokeinterface java/util/concurrent/ExecutorService.execute (Ljava/lang/Runnable;)V 2
      // 6e: return
   }

   public oc142532d567 є() {
      return this.ƚ.get();
   }

   public void Ȃ() {
      this.ƛ = "";
      this.U.incrementAndGet();
      this.ƚ.set(oc142532d567.a);
   }

   private void Ͷ(ocbb1bc27172 param1, long param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/ocbb1bc27172.ԍ I
      // 003: istore 4
      // 005: ldc "api/spotify/lyrics"
      // 007: invokestatic x/oc380d0f830c.Ӊ (Ljava/lang/String;)Ljava/lang/String;
      // 00a: aload 1
      // 00b: invokevirtual x/ocbb1bc27172.ԟ ()Ljava/lang/String;
      // 00e: invokestatic x/oc03bc465855.λ (Ljava/lang/String;)Ljava/lang/String;
      // 011: aload 1
      // 012: invokevirtual x/ocbb1bc27172.ϧ ()Ljava/lang/String;
      // 015: invokestatic x/oc03bc465855.λ (Ljava/lang/String;)Ljava/lang/String;
      // 018: aload 1
      // 019: invokevirtual x/ocbb1bc27172.շ ()Ljava/lang/String;
      // 01c: invokestatic x/oc03bc465855.λ (Ljava/lang/String;)Ljava/lang/String;
      // 01f: aload 1
      // 020: invokevirtual x/ocbb1bc27172.ʎ ()J
      // 023: ldc2_w 3649060920022763913
      // 026: ldc2_w 3649060920022764129
      // 029: lxor
      // 02a: ldiv
      // 02b: lstore 12
      // 02d: astore 14
      // 02f: astore 15
      // 031: astore 16
      // 033: ldc "?track="
      // 035: aload 16
      // 037: ldc "&artist="
      // 039: aload 15
      // 03b: ldc "&album="
      // 03d: aload 14
      // 03f: ldc "&duration="
      // 041: lload 12
      // 043: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001" ]
      // 048: astore 5
      // 04a: aload 0
      // 04b: getfield x/oc03bc465855.ф Lx/oce7be97fef5;
      // 04e: ldc "GET"
      // 050: aload 5
      // 052: invokestatic x/oc6bed6d7740.ʉ (Ljava/lang/String;Ljava/lang/String;)Lx/oc173ab988a9;
      // 055: ldc 1692984654
      // 057: ldc 1692989126
      // 059: ixor
      // 05a: ldc 1692986782
      // 05c: ldc 1692989126
      // 05e: ixor
      // 05f: invokevirtual x/oc173ab988a9.ƚ (II)Lx/oc173ab988a9;
      // 062: invokevirtual x/oc173ab988a9.ʐ ()Lx/oc6bed6d7740;
      // 065: invokeinterface x/oce7be97fef5.z$1ahjbl7dqoxur (Lx/oc6bed6d7740;)Lx/oc51f4f13c5a; 2
      // 06a: astore 6
      // 06c: aload 6
      // 06e: invokevirtual x/oc51f4f13c5a.ѣ ()I
      // 071: ldc 1692988942
      // 073: ldc 1692989126
      // 075: ixor
      // 076: if_icmpeq 08f
      // 079: new java/io/IOException
      // 07c: dup
      // 07d: aload 6
      // 07f: invokevirtual x/oc51f4f13c5a.ѣ ()I
      // 082: ldc "Lyrics HTTP "
      // 084: swap
      // 085: invokedynamic makeConcatWithConstants (Ljava/lang/String;I)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 08a: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 08d: athrow
      // 08e: athrow
      // 08f: new com/google/gson/JsonParser
      // 092: dup
      // 093: invokespecial com/google/gson/JsonParser.<init> ()V
      // 096: aload 6
      // 098: invokevirtual x/oc51f4f13c5a.ʤ ()Ljava/lang/String;
      // 09b: invokevirtual com/google/gson/JsonParser.parse (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 09e: invokevirtual com/google/gson/JsonElement.getAsJsonObject ()Lcom/google/gson/JsonObject;
      // 0a1: astore 7
      // 0a3: aload 7
      // 0a5: ldc_w "instrumental"
      // 0a8: iload 4
      // 0aa: ifne 0c0
      // 0ad: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 0b0: ifeq 0d6
      // 0b3: goto 0b7
      // 0b6: athrow
      // 0b7: aload 7
      // 0b9: ldc_w "instrumental"
      // 0bc: goto 0c0
      // 0bf: athrow
      // 0c0: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 0c3: invokevirtual com/google/gson/JsonElement.getAsBoolean ()Z
      // 0c6: iload 4
      // 0c8: ifne 0d3
      // 0cb: ifeq 0d6
      // 0ce: goto 0d2
      // 0d1: athrow
      // 0d2: bipush 1
      // 0d3: goto 0d7
      // 0d6: bipush 0
      // 0d7: istore 8
      // 0d9: aload 7
      // 0db: ldc_w "syncedLyrics"
      // 0de: invokestatic x/oc03bc465855.ͱ (Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/String;
      // 0e1: astore 9
      // 0e3: aload 7
      // 0e5: ldc_w "plainLyrics"
      // 0e8: invokestatic x/oc03bc465855.ͱ (Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/String;
      // 0eb: astore 10
      // 0ed: aload 9
      // 0ef: iload 4
      // 0f1: ifne 109
      // 0f4: invokevirtual java/lang/String.isEmpty ()Z
      // 0f7: ifne 107
      // 0fa: goto 0fe
      // 0fd: athrow
      // 0fe: aload 9
      // 100: invokestatic x/oc03bc465855.ʟ (Ljava/lang/String;)Ljava/util/List;
      // 103: goto 10c
      // 106: athrow
      // 107: aload 10
      // 109: invokestatic x/oc03bc465855.Ԇ (Ljava/lang/String;)Ljava/util/List;
      // 10c: astore 11
      // 10e: aload 0
      // 10f: iload 4
      // 111: ifne 128
      // 114: getfield x/oc03bc465855.U Ljava/util/concurrent/atomic/AtomicLong;
      // 117: invokevirtual java/util/concurrent/atomic/AtomicLong.get ()J
      // 11a: lload 2
      // 11b: lcmp
      // 11c: ifne 13e
      // 11f: goto 123
      // 122: athrow
      // 123: aload 0
      // 124: goto 128
      // 127: athrow
      // 128: getfield x/oc03bc465855.ƚ Ljava/util/concurrent/atomic/AtomicReference;
      // 12b: new x/oc142532d567
      // 12e: dup
      // 12f: aload 1
      // 130: invokevirtual x/ocbb1bc27172.B ()Ljava/lang/String;
      // 133: aload 11
      // 135: iload 8
      // 137: bipush 0
      // 138: invokespecial x/oc142532d567.<init> (Ljava/lang/String;Ljava/util/List;ZZ)V
      // 13b: invokevirtual java/util/concurrent/atomic/AtomicReference.set (Ljava/lang/Object;)V
      // 13e: goto 173
      // 141: astore 5
      // 143: aload 0
      // 144: iload 4
      // 146: ifne 15d
      // 149: getfield x/oc03bc465855.U Ljava/util/concurrent/atomic/AtomicLong;
      // 14c: invokevirtual java/util/concurrent/atomic/AtomicLong.get ()J
      // 14f: lload 2
      // 150: lcmp
      // 151: ifne 173
      // 154: goto 158
      // 157: athrow
      // 158: aload 0
      // 159: goto 15d
      // 15c: athrow
      // 15d: getfield x/oc03bc465855.ƚ Ljava/util/concurrent/atomic/AtomicReference;
      // 160: new x/oc142532d567
      // 163: dup
      // 164: aload 1
      // 165: invokevirtual x/ocbb1bc27172.B ()Ljava/lang/String;
      // 168: invokestatic java/util/Collections.emptyList ()Ljava/util/List;
      // 16b: bipush 0
      // 16c: bipush 0
      // 16d: invokespecial x/oc142532d567.<init> (Ljava/lang/String;Ljava/util/List;ZZ)V
      // 170: invokevirtual java/util/concurrent/atomic/AtomicReference.set (Ljava/lang/Object;)V
      // 173: return
   }

   private static List<oc0ac184e19b> ʟ(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: new java/util/ArrayList
      // 03: dup
      // 04: invokespecial java/util/ArrayList.<init> ()V
      // 07: astore 2
      // 08: aload 0
      // 09: ldc_w "\\r?\\n"
      // 0c: invokevirtual java/lang/String.split (Ljava/lang/String;)[Ljava/lang/String;
      // 0f: astore 3
      // 10: aload 3
      // 11: arraylength
      // 12: istore 4
      // 14: getstatic x/ocbb1bc27172.ԍ I
      // 17: bipush 0
      // 18: istore 5
      // 1a: istore 1
      // 1b: iload 5
      // 1d: iload 4
      // 1f: if_icmpge c8
      // 22: aload 3
      // 23: iload 5
      // 25: aaload
      // 26: astore 6
      // 28: iload 1
      // 29: aload 6
      // 2b: ldc_w -1935979974
      // 2e: ldc_w -1935979929
      // 31: ixor
      // 32: invokevirtual java/lang/String.indexOf (I)I
      // 35: istore 7
      // 37: ifne c4
      // 3a: aload 6
      // 3c: ldc_w "["
      // 3f: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 42: ifeq c1
      // 45: goto 49
      // 48: athrow
      // 49: iload 7
      // 4b: bipush 1
      // 4c: if_icmple c1
      // 4f: goto 53
      // 52: athrow
      // 53: aload 6
      // 55: bipush 1
      // 56: iload 7
      // 58: invokevirtual java/lang/String.substring (II)Ljava/lang/String;
      // 5b: ldc_w ":"
      // 5e: ldc_w -1935979931
      // 61: ldc_w -1935979929
      // 64: ixor
      // 65: invokevirtual java/lang/String.split (Ljava/lang/String;I)[Ljava/lang/String;
      // 68: astore 8
      // 6a: aload 8
      // 6c: bipush 0
      // 6d: aaload
      // 6e: invokestatic java/lang/Long.parseLong (Ljava/lang/String;)J
      // 71: ldc2_w 2757422358284307578
      // 74: ldc2_w 2757422358284297754
      // 77: lxor
      // 78: lmul
      // 79: aload 8
      // 7b: bipush 1
      // 7c: aaload
      // 7d: invokestatic java/lang/Double.parseDouble (Ljava/lang/String;)D
      // 80: ldc2_w 1000.0
      // 83: dmul
      // 84: d2l
      // 85: ladd
      // 86: lstore 9
      // 88: aload 6
      // 8a: iload 7
      // 8c: bipush 1
      // 8d: iadd
      // 8e: invokevirtual java/lang/String.substring (I)Ljava/lang/String;
      // 91: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 94: astore 11
      // 96: aload 11
      // 98: invokevirtual java/lang/String.isEmpty ()Z
      // 9b: iload 1
      // 9c: ifne bb
      // 9f: ifne bc
      // a2: goto a6
      // a5: athrow
      // a6: aload 2
      // a7: new x/oc0ac184e19b
      // aa: dup
      // ab: lload 9
      // ad: aload 11
      // af: invokespecial x/oc0ac184e19b.<init> (JLjava/lang/String;)V
      // b2: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // b7: goto bb
      // ba: athrow
      // bb: pop
      // bc: goto c1
      // bf: astore 9
      // c1: iinc 5 1
      // c4: iload 1
      // c5: ifeq 1b
      // c8: aload 2
      // c9: areturn
   }

   private static List<oc0ac184e19b> Ԇ(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocbb1bc27172.ԍ I
      // 03: new java/util/ArrayList
      // 06: dup
      // 07: invokespecial java/util/ArrayList.<init> ()V
      // 0a: astore 2
      // 0b: aload 0
      // 0c: ldc_w "\\r?\\n"
      // 0f: invokevirtual java/lang/String.split (Ljava/lang/String;)[Ljava/lang/String;
      // 12: astore 3
      // 13: aload 3
      // 14: arraylength
      // 15: istore 4
      // 17: bipush 0
      // 18: istore 5
      // 1a: istore 1
      // 1b: iload 5
      // 1d: iload 4
      // 1f: if_icmpge 75
      // 22: aload 3
      // 23: iload 5
      // 25: aaload
      // 26: astore 6
      // 28: aload 6
      // 2a: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 2d: astore 7
      // 2f: aload 7
      // 31: invokevirtual java/lang/String.isEmpty ()Z
      // 34: iload 1
      // 35: ifne 60
      // 38: ifne 5a
      // 3b: goto 3f
      // 3e: athrow
      // 3f: aload 2
      // 40: new x/oc0ac184e19b
      // 43: dup
      // 44: ldc2_w -4451035647841822750
      // 47: ldc2_w 4451035647841822749
      // 4a: lxor
      // 4b: aload 7
      // 4d: invokespecial x/oc0ac184e19b.<init> (JLjava/lang/String;)V
      // 50: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 55: pop
      // 56: goto 5a
      // 59: athrow
      // 5a: aload 2
      // 5b: invokeinterface java/util/List.size ()I 1
      // 60: ldc_w -353482487
      // 63: ldc_w -353482423
      // 66: ixor
      // 67: if_icmplt 6e
      // 6a: goto 75
      // 6d: athrow
      // 6e: iinc 5 1
      // 71: iload 1
      // 72: ifeq 1b
      // 75: aload 2
      // 76: areturn
   }

   private static String ͱ(JsonObject param0, String param1) {
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

   private static String λ(String var0) throws Exception {
      int var1 = ocbb1bc27172.ԍ;

      try {
         if (var1 != 0) {
            return URLEncoder.encode(var0, "UTF-8");
         }

         if (var0 == null) {
            return URLEncoder.encode("", "UTF-8");
         }
      } catch (Exception var2) {
         throw var2;
      }

      return URLEncoder.encode(var0, "UTF-8");
   }
}

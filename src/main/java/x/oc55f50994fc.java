package x;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

public class oc55f50994fc {
   private final SecureRandom ҁ = new SecureRandom();
   private HttpServer Ȯ;
   private ExecutorService ԓ;
   private ScheduledExecutorService Ź;
   private CompletableFuture<oc3c2319bfae> Ō;
   private String ʂ = "";
   public static boolean ō;

   public synchronized String Ç() throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokevirtual x/oc55f50994fc.ɮ ()V
      // 04: getstatic x/ocbb1bc27172.ԍ I
      // 07: aload 0
      // 08: new java/net/InetSocketAddress
      // 0b: dup
      // 0c: invokestatic java/net/InetAddress.getLoopbackAddress ()Ljava/net/InetAddress;
      // 0f: bipush 0
      // 10: invokespecial java/net/InetSocketAddress.<init> (Ljava/net/InetAddress;I)V
      // 13: bipush 0
      // 14: invokestatic com/sun/net/httpserver/HttpServer.create (Ljava/net/InetSocketAddress;I)Lcom/sun/net/httpserver/HttpServer;
      // 17: putfield x/oc55f50994fc.Ȯ Lcom/sun/net/httpserver/HttpServer;
      // 1a: aload 0
      // 1b: getfield x/oc55f50994fc.Ȯ Lcom/sun/net/httpserver/HttpServer;
      // 1e: invokevirtual com/sun/net/httpserver/HttpServer.getAddress ()Ljava/net/InetSocketAddress;
      // 21: invokevirtual java/net/InetSocketAddress.getPort ()I
      // 24: istore 2
      // 25: ldc -1760249182
      // 27: ldc -1760249214
      // 29: ixor
      // 2a: newarray 8
      // 2c: astore 3
      // 2d: aload 0
      // 2e: getfield x/oc55f50994fc.ҁ Ljava/security/SecureRandom;
      // 31: aload 3
      // 32: invokevirtual java/security/SecureRandom.nextBytes ([B)V
      // 35: istore 1
      // 36: aload 0
      // 37: iload 2
      // 38: invokestatic java/util/Base64.getUrlEncoder ()Ljava/util/Base64$Encoder;
      // 3b: invokevirtual java/util/Base64$Encoder.withoutPadding ()Ljava/util/Base64$Encoder;
      // 3e: aload 3
      // 3f: invokevirtual java/util/Base64$Encoder.encodeToString ([B)Ljava/lang/String;
      // 42: ldc "miau1."
      // 44: dup_x2
      // 45: pop
      // 46: ldc "."
      // 48: swap
      // 49: invokedynamic makeConcatWithConstants (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001\u0001" ]
      // 4e: putfield x/oc55f50994fc.ʂ Ljava/lang/String;
      // 51: aload 0
      // 52: new java/util/concurrent/CompletableFuture
      // 55: dup
      // 56: invokespecial java/util/concurrent/CompletableFuture.<init> ()V
      // 59: putfield x/oc55f50994fc.Ō Ljava/util/concurrent/CompletableFuture;
      // 5c: aload 0
      // 5d: getfield x/oc55f50994fc.Ȯ Lcom/sun/net/httpserver/HttpServer;
      // 60: ldc "/callback"
      // 62: aload 0
      // 63: invokedynamic handle (Lx/oc55f50994fc;)Lcom/sun/net/httpserver/HttpHandler; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Lcom/sun/net/httpserver/HttpExchange;)V, x/oc55f50994fc.S (Lcom/sun/net/httpserver/HttpExchange;)V, (Lcom/sun/net/httpserver/HttpExchange;)V ]
      // 68: invokevirtual com/sun/net/httpserver/HttpServer.createContext (Ljava/lang/String;Lcom/sun/net/httpserver/HttpHandler;)Lcom/sun/net/httpserver/HttpContext;
      // 6b: pop
      // 6c: aload 0
      // 6d: ldc "Miau-Spotify-Callback"
      // 6f: invokestatic x/oc55f50994fc.Ј (Ljava/lang/String;)Ljava/util/concurrent/ThreadFactory;
      // 72: invokestatic java/util/concurrent/Executors.newSingleThreadExecutor (Ljava/util/concurrent/ThreadFactory;)Ljava/util/concurrent/ExecutorService;
      // 75: putfield x/oc55f50994fc.ԓ Ljava/util/concurrent/ExecutorService;
      // 78: aload 0
      // 79: ldc "Miau-Spotify-Timeout"
      // 7b: invokestatic x/oc55f50994fc.Ј (Ljava/lang/String;)Ljava/util/concurrent/ThreadFactory;
      // 7e: invokestatic java/util/concurrent/Executors.newSingleThreadScheduledExecutor (Ljava/util/concurrent/ThreadFactory;)Ljava/util/concurrent/ScheduledExecutorService;
      // 81: putfield x/oc55f50994fc.Ź Ljava/util/concurrent/ScheduledExecutorService;
      // 84: aload 0
      // 85: getfield x/oc55f50994fc.Ȯ Lcom/sun/net/httpserver/HttpServer;
      // 88: aload 0
      // 89: getfield x/oc55f50994fc.ԓ Ljava/util/concurrent/ExecutorService;
      // 8c: invokevirtual com/sun/net/httpserver/HttpServer.setExecutor (Ljava/util/concurrent/Executor;)V
      // 8f: aload 0
      // 90: getfield x/oc55f50994fc.Ȯ Lcom/sun/net/httpserver/HttpServer;
      // 93: invokevirtual com/sun/net/httpserver/HttpServer.start ()V
      // 96: aload 0
      // 97: getfield x/oc55f50994fc.Ź Ljava/util/concurrent/ScheduledExecutorService;
      // 9a: aload 0
      // 9b: invokedynamic run (Lx/oc55f50994fc;)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, x/oc55f50994fc.qgnrzaxhidx9q ()V, ()V ]
      // a0: ldc2_w 1269620184885067215
      // a3: ldc2_w 1269620184885067131
      // a6: lxor
      // a7: getstatic java/util/concurrent/TimeUnit.SECONDS Ljava/util/concurrent/TimeUnit;
      // aa: invokeinterface java/util/concurrent/ScheduledExecutorService.schedule (Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture; 5
      // af: pop
      // b0: aload 0
      // b1: getfield x/oc55f50994fc.ʂ Ljava/lang/String;
      // b4: iload 1
      // b5: ifeq c9
      // b8: bipush 0
      // b9: ifeq c5
      // bc: goto c0
      // bf: athrow
      // c0: bipush 0
      // c1: goto c6
      // c4: athrow
      // c5: bipush 1
      // c6: putstatic x/oc69da1aa7f5.Ҭ Z
      // c9: areturn
   }

   public synchronized CompletableFuture<oc3c2319bfae> έ() {
      return this.Ō;
   }

   public synchronized int ʁ() {
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
      // 06: ifne 19
      // 09: getfield x/oc55f50994fc.Ȯ Lcom/sun/net/httpserver/HttpServer;
      // 0c: ifnonnull 18
      // 0f: goto 13
      // 12: athrow
      // 13: bipush 0
      // 14: goto 22
      // 17: athrow
      // 18: aload 0
      // 19: getfield x/oc55f50994fc.Ȯ Lcom/sun/net/httpserver/HttpServer;
      // 1c: invokevirtual com/sun/net/httpserver/HttpServer.getAddress ()Ljava/net/InetSocketAddress;
      // 1f: invokevirtual java/net/InetSocketAddress.getPort ()I
      // 22: ireturn
   }

   private void S(HttpExchange param1) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: new x/oc0efa069b1c
      // 003: dup
      // 004: aload 1
      // 005: invokevirtual com/sun/net/httpserver/HttpExchange.getRequestURI ()Ljava/net/URI;
      // 008: invokevirtual java/net/URI.getRawQuery ()Ljava/lang/String;
      // 00b: invokespecial x/oc0efa069b1c.<init> (Ljava/lang/String;)V
      // 00e: astore 3
      // 00f: getstatic x/ocbb1bc27172.ԍ I
      // 012: ldc "GET"
      // 014: aload 1
      // 015: invokevirtual com/sun/net/httpserver/HttpExchange.getRequestMethod ()Ljava/lang/String;
      // 018: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 01b: istore 4
      // 01d: istore 2
      // 01e: iload 4
      // 020: iload 2
      // 021: ifne 03c
      // 024: ifeq 04b
      // 027: goto 02b
      // 02a: athrow
      // 02b: aload 0
      // 02c: getfield x/oc55f50994fc.ʂ Ljava/lang/String;
      // 02f: aload 3
      // 030: ldc "state"
      // 032: invokevirtual x/oc0efa069b1c.ѓ (Ljava/lang/String;)Ljava/lang/String;
      // 035: invokestatic x/oc55f50994fc.ƌ (Ljava/lang/String;Ljava/lang/String;)Z
      // 038: goto 03c
      // 03b: athrow
      // 03c: iload 2
      // 03d: ifne 048
      // 040: ifeq 04b
      // 043: goto 047
      // 046: athrow
      // 047: bipush 1
      // 048: goto 04c
      // 04b: bipush 0
      // 04c: istore 5
      // 04e: iload 4
      // 050: iload 2
      // 051: ifne 063
      // 054: ifne 061
      // 057: goto 05b
      // 05a: athrow
      // 05b: ldc "Invalid callback method"
      // 05d: goto 072
      // 060: athrow
      // 061: iload 5
      // 063: ifne 06c
      // 066: ldc "Invalid authorization state"
      // 068: goto 072
      // 06b: athrow
      // 06c: aload 3
      // 06d: ldc "error"
      // 06f: invokevirtual x/oc0efa069b1c.ѓ (Ljava/lang/String;)Ljava/lang/String;
      // 072: astore 6
      // 074: iload 5
      // 076: ifeq 084
      // 079: aload 3
      // 07a: ldc_w "code"
      // 07d: invokevirtual x/oc0efa069b1c.ѓ (Ljava/lang/String;)Ljava/lang/String;
      // 080: goto 086
      // 083: athrow
      // 084: ldc ""
      // 086: astore 7
      // 088: iload 5
      // 08a: iload 2
      // 08b: ifne 0a6
      // 08e: ifeq 0bd
      // 091: goto 095
      // 094: athrow
      // 095: aload 7
      // 097: iload 2
      // 098: ifne 0ab
      // 09b: goto 09f
      // 09e: athrow
      // 09f: invokevirtual java/lang/String.isEmpty ()Z
      // 0a2: goto 0a6
      // 0a5: athrow
      // 0a6: ifne 0bd
      // 0a9: aload 6
      // 0ab: invokevirtual java/lang/String.isEmpty ()Z
      // 0ae: iload 2
      // 0af: ifne 0ba
      // 0b2: ifeq 0bd
      // 0b5: goto 0b9
      // 0b8: athrow
      // 0b9: bipush 1
      // 0ba: goto 0be
      // 0bd: bipush 0
      // 0be: istore 8
      // 0c0: iload 8
      // 0c2: iload 8
      // 0c4: ifeq 0ce
      // 0c7: ldc_w "Spotify connected"
      // 0ca: goto 0d1
      // 0cd: athrow
      // 0ce: ldc_w "Spotify authorization failed"
      // 0d1: iload 8
      // 0d3: ifeq 0dd
      // 0d6: ldc_w "You can close this tab."
      // 0d9: goto 0df
      // 0dc: athrow
      // 0dd: aload 6
      // 0df: invokestatic x/oc55f50994fc.ɳ (ZLjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 0e2: getstatic java/nio/charset/StandardCharsets.UTF_8 Ljava/nio/charset/Charset;
      // 0e5: invokevirtual java/lang/String.getBytes (Ljava/nio/charset/Charset;)[B
      // 0e8: astore 9
      // 0ea: aload 1
      // 0eb: invokevirtual com/sun/net/httpserver/HttpExchange.getResponseHeaders ()Lcom/sun/net/httpserver/Headers;
      // 0ee: ldc_w "Content-Type"
      // 0f1: ldc_w "text/html; charset=utf-8"
      // 0f4: invokevirtual com/sun/net/httpserver/Headers.set (Ljava/lang/String;Ljava/lang/String;)V
      // 0f7: aload 1
      // 0f8: invokevirtual com/sun/net/httpserver/HttpExchange.getResponseHeaders ()Lcom/sun/net/httpserver/Headers;
      // 0fb: ldc_w "Cache-Control"
      // 0fe: ldc_w "no-store"
      // 101: invokevirtual com/sun/net/httpserver/Headers.set (Ljava/lang/String;Ljava/lang/String;)V
      // 104: aload 1
      // 105: iload 8
      // 107: iload 2
      // 108: ifne 119
      // 10b: ifeq 11c
      // 10e: goto 112
      // 111: athrow
      // 112: ldc_w -79892432
      // 115: ldc_w -79892232
      // 118: ixor
      // 119: goto 123
      // 11c: ldc_w -79892120
      // 11f: ldc_w -79892232
      // 122: ixor
      // 123: aload 9
      // 125: arraylength
      // 126: i2l
      // 127: invokevirtual com/sun/net/httpserver/HttpExchange.sendResponseHeaders (IJ)V
      // 12a: aload 1
      // 12b: invokevirtual com/sun/net/httpserver/HttpExchange.getResponseBody ()Ljava/io/OutputStream;
      // 12e: astore 10
      // 130: aload 10
      // 132: aload 9
      // 134: invokevirtual java/io/OutputStream.write ([B)V
      // 137: iload 2
      // 138: ifne 149
      // 13b: aload 10
      // 13d: ifnull 16f
      // 140: aload 10
      // 142: invokevirtual java/io/OutputStream.close ()V
      // 145: goto 149
      // 148: athrow
      // 149: goto 16f
      // 14c: astore 11
      // 14e: iload 2
      // 14f: ifne 160
      // 152: aload 10
      // 154: ifnull 16c
      // 157: goto 15b
      // 15a: athrow
      // 15b: aload 10
      // 15d: invokevirtual java/io/OutputStream.close ()V
      // 160: goto 16c
      // 163: astore 12
      // 165: aload 11
      // 167: aload 12
      // 169: invokevirtual java/lang/Throwable.addSuppressed (Ljava/lang/Throwable;)V
      // 16c: aload 11
      // 16e: athrow
      // 16f: aload 0
      // 170: new x/oc3c2319bfae
      // 173: dup
      // 174: aload 7
      // 176: aload 6
      // 178: invokevirtual java/lang/String.isEmpty ()Z
      // 17b: ifeq 18d
      // 17e: iload 8
      // 180: ifne 18d
      // 183: goto 187
      // 186: athrow
      // 187: ldc_w "Missing authorization code"
      // 18a: goto 18f
      // 18d: aload 6
      // 18f: invokespecial x/oc3c2319bfae.<init> (Ljava/lang/String;Ljava/lang/String;)V
      // 192: invokevirtual x/oc55f50994fc.ϰ (Lx/oc3c2319bfae;)V
      // 195: return
   }

   private synchronized void ϰ(oc3c2319bfae param1) {
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
      // 06: ifne 37
      // 09: getfield x/oc55f50994fc.Ō Ljava/util/concurrent/CompletableFuture;
      // 0c: ifnull 36
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: iload 2
      // 15: ifne 37
      // 18: goto 1c
      // 1b: athrow
      // 1c: getfield x/oc55f50994fc.Ō Ljava/util/concurrent/CompletableFuture;
      // 1f: invokevirtual java/util/concurrent/CompletableFuture.isDone ()Z
      // 22: ifne 36
      // 25: goto 29
      // 28: athrow
      // 29: aload 0
      // 2a: getfield x/oc55f50994fc.Ō Ljava/util/concurrent/CompletableFuture;
      // 2d: aload 1
      // 2e: invokevirtual java/util/concurrent/CompletableFuture.complete (Ljava/lang/Object;)Z
      // 31: pop
      // 32: goto 36
      // 35: athrow
      // 36: aload 0
      // 37: invokevirtual x/oc55f50994fc.Ӱ ()V
      // 3a: return
   }

   public synchronized void ɮ() {
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
      // 09: getfield x/oc55f50994fc.Ō Ljava/util/concurrent/CompletableFuture;
      // 0c: ifnull 36
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: iload 1
      // 15: ifne 37
      // 18: goto 1c
      // 1b: athrow
      // 1c: getfield x/oc55f50994fc.Ō Ljava/util/concurrent/CompletableFuture;
      // 1f: invokevirtual java/util/concurrent/CompletableFuture.isDone ()Z
      // 22: ifne 36
      // 25: goto 29
      // 28: athrow
      // 29: aload 0
      // 2a: getfield x/oc55f50994fc.Ō Ljava/util/concurrent/CompletableFuture;
      // 2d: bipush 1
      // 2e: invokevirtual java/util/concurrent/CompletableFuture.cancel (Z)Z
      // 31: pop
      // 32: goto 36
      // 35: athrow
      // 36: aload 0
      // 37: invokevirtual x/oc55f50994fc.Ӱ ()V
      // 3a: return
   }

   private void Ӱ() {
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
      // 06: ifne 2d
      // 09: getfield x/oc55f50994fc.Ȯ Lcom/sun/net/httpserver/HttpServer;
      // 0c: ifnull 1f
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: getfield x/oc55f50994fc.Ȯ Lcom/sun/net/httpserver/HttpServer;
      // 17: bipush 0
      // 18: invokevirtual com/sun/net/httpserver/HttpServer.stop (I)V
      // 1b: goto 1f
      // 1e: athrow
      // 1f: aload 0
      // 20: aconst_null
      // 21: putfield x/oc55f50994fc.Ȯ Lcom/sun/net/httpserver/HttpServer;
      // 24: iload 1
      // 25: ifne 4e
      // 28: aload 0
      // 29: goto 2d
      // 2c: athrow
      // 2d: getfield x/oc55f50994fc.ԓ Ljava/util/concurrent/ExecutorService;
      // 30: ifnull 41
      // 33: aload 0
      // 34: getfield x/oc55f50994fc.ԓ Ljava/util/concurrent/ExecutorService;
      // 37: invokeinterface java/util/concurrent/ExecutorService.shutdownNow ()Ljava/util/List; 1
      // 3c: pop
      // 3d: goto 41
      // 40: athrow
      // 41: aload 0
      // 42: iload 1
      // 43: ifne 69
      // 46: aconst_null
      // 47: putfield x/oc55f50994fc.ԓ Ljava/util/concurrent/ExecutorService;
      // 4a: goto 4e
      // 4d: athrow
      // 4e: aload 0
      // 4f: getfield x/oc55f50994fc.Ź Ljava/util/concurrent/ScheduledExecutorService;
      // 52: ifnull 63
      // 55: aload 0
      // 56: getfield x/oc55f50994fc.Ź Ljava/util/concurrent/ScheduledExecutorService;
      // 59: invokeinterface java/util/concurrent/ScheduledExecutorService.shutdownNow ()Ljava/util/List; 1
      // 5e: pop
      // 5f: goto 63
      // 62: athrow
      // 63: aload 0
      // 64: aconst_null
      // 65: putfield x/oc55f50994fc.Ź Ljava/util/concurrent/ScheduledExecutorService;
      // 68: aload 0
      // 69: ldc ""
      // 6b: putfield x/oc55f50994fc.ʂ Ljava/lang/String;
      // 6e: return
   }

   private static boolean ƌ(String param0, String param1) {
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
      // 09: ifnull 1c
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 1
      // 11: iload 2
      // 12: ifne 20
      // 15: ifnonnull 1f
      // 18: goto 1c
      // 1b: athrow
      // 1c: bipush 0
      // 1d: ireturn
      // 1e: athrow
      // 1f: aload 0
      // 20: getstatic java/nio/charset/StandardCharsets.UTF_8 Ljava/nio/charset/Charset;
      // 23: invokevirtual java/lang/String.getBytes (Ljava/nio/charset/Charset;)[B
      // 26: aload 1
      // 27: getstatic java/nio/charset/StandardCharsets.UTF_8 Ljava/nio/charset/Charset;
      // 2a: invokevirtual java/lang/String.getBytes (Ljava/nio/charset/Charset;)[B
      // 2d: invokestatic java/security/MessageDigest.isEqual ([B[B)Z
      // 30: ireturn
   }

   private static ThreadFactory Ј(String var0) {
      return var1 -> {
         Thread var2 = new Thread(var1, var0);
         var2.setDaemon(true);
         return var2;
      };
   }

   private static String ɳ(boolean var0, String var1, String var2) {
      String var10000;
      label16: {
         try {
            if (var0) {
               var10000 = "#c489ff";
               break label16;
            }
         } catch (ocbde1165e4e var6) {
            throw var6;
         }

         var10000 = "#ff8fba";
      }

      String var3 = ą(var2);
      String var5 = var10000;
      return "<!doctype html><html><body style='background:#0d0914;color:#fff;font:16px system-ui;display:grid;place-items:center;min-height:100vh'><main><h1 style='color:"
         + var5
         + "'>Miau Spotify</h1><h2>"
         + var1
         + "</h2><p>"
         + var3
         + "</p></main></body></html>";
   }

   private static String ą(String var0) {
      int var1 = ocbb1bc27172.ԍ;

      try {
         if (var1 != 0) {
            return var0.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
         }

         if (var0 == null) {
            return "".replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }

      return var0.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
   }
}

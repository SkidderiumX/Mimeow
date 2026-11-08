package x;

import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.regex.Pattern;

public class oc89e52ca90f {
   private static final Pattern ͷ = Pattern.compile("^[a-f0-9]{32}$");
   private static final Pattern Ԍ = Pattern.compile("^\\d{13}-[a-f0-9]{32}$");
   private static final Pattern ԡ = Pattern.compile("^[a-f0-9]{32}$");
   private static final Pattern O = Pattern.compile("^[A-Za-z0-9_]{3,16}$");
   private static final int ҥ = 16384;
   private static final int փ = 500;
   private final Object Ȓ = new Object();
   private final URI τ;
   private final HttpClient Ώ;
   private final oc1990c51762 я;
   private WebSocket S;
   private long ԗ;
   private boolean Ѫ;
   private volatile long Ύ;
   private volatile boolean Ϋ;
   private volatile boolean ż = true;
   private volatile boolean œ;

   oc89e52ca90f(oc1990c51762 var1) throws IOException {
      this(ǵ(), HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(-4011231727205131922L ^ -4011231727205131930L)).build(), var1);
   }

   oc89e52ca90f(URI var1, HttpClient var2, oc1990c51762 var3) {
      this.τ = var1;
      this.Ώ = var2;
      this.я = var3;
   }

   CompletableFuture<Void> ճ(String param1, String param2, String param3) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce490879787.փ Z
      // 003: aload 1
      // 004: ldc -1535105923
      // 006: ldc -1535101827
      // 008: ixor
      // 009: invokestatic x/oc89e52ca90f.Ͻ (Ljava/lang/String;I)Ljava/lang/String;
      // 00c: astore 5
      // 00e: istore 4
      // 010: aload 2
      // 011: iload 4
      // 013: ifne 027
      // 016: ifnonnull 023
      // 019: goto 01d
      // 01c: athrow
      // 01d: ldc ""
      // 01f: goto 02d
      // 022: athrow
      // 023: aload 2
      // 024: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 027: getstatic java/util/Locale.ROOT Ljava/util/Locale;
      // 02a: invokevirtual java/lang/String.toLowerCase (Ljava/util/Locale;)Ljava/lang/String;
      // 02d: astore 6
      // 02f: aload 6
      // 031: invokevirtual java/lang/String.isEmpty ()Z
      // 034: iload 4
      // 036: ifne 04f
      // 039: ifne 05d
      // 03c: goto 040
      // 03f: athrow
      // 040: getstatic x/oc89e52ca90f.Ԍ Ljava/util/regex/Pattern;
      // 043: aload 6
      // 045: invokevirtual java/util/regex/Pattern.matcher (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
      // 048: invokevirtual java/util/regex/Matcher.matches ()Z
      // 04b: goto 04f
      // 04e: athrow
      // 04f: ifne 05d
      // 052: new java/io/IOException
      // 055: dup
      // 056: ldc "The IRC cursor is invalid."
      // 058: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 05b: athrow
      // 05c: athrow
      // 05d: new com/google/gson/JsonObject
      // 060: dup
      // 061: invokespecial com/google/gson/JsonObject.<init> ()V
      // 064: astore 7
      // 066: aload 7
      // 068: ldc "type"
      // 06a: ldc "auth"
      // 06c: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/String;)V
      // 06f: aload 7
      // 071: ldc "token"
      // 073: aload 5
      // 075: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/String;)V
      // 078: aload 7
      // 07a: ldc "after"
      // 07c: aload 6
      // 07e: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/String;)V
      // 081: aload 7
      // 083: ldc "server"
      // 085: aload 3
      // 086: invokestatic x/oc89e52ca90f.Ή (Ljava/lang/String;)Ljava/lang/String;
      // 089: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/String;)V
      // 08c: aload 0
      // 08d: aload 0
      // 08e: iload 4
      // 090: ifne 0a2
      // 093: getfield x/oc89e52ca90f.Ϋ Z
      // 096: ifeq 0b5
      // 099: goto 09d
      // 09c: athrow
      // 09d: aload 0
      // 09e: goto 0a2
      // 0a1: athrow
      // 0a2: getfield x/oc89e52ca90f.ż Z
      // 0a5: iload 4
      // 0a7: ifne 0b2
      // 0aa: ifeq 0b5
      // 0ad: goto 0b1
      // 0b0: athrow
      // 0b1: bipush 1
      // 0b2: goto 0b6
      // 0b5: bipush 0
      // 0b6: putfield x/oc89e52ca90f.œ Z
      // 0b9: aload 0
      // 0ba: iload 4
      // 0bc: ifne 0d9
      // 0bf: getfield x/oc89e52ca90f.œ Z
      // 0c2: ifeq 0d8
      // 0c5: goto 0c9
      // 0c8: athrow
      // 0c9: aload 7
      // 0cb: ldc "hidden"
      // 0cd: bipush 1
      // 0ce: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
      // 0d1: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Boolean;)V
      // 0d4: goto 0d8
      // 0d7: athrow
      // 0d8: aload 0
      // 0d9: getfield x/oc89e52ca90f.Ȓ Ljava/lang/Object;
      // 0dc: dup
      // 0dd: astore 11
      // 0df: monitorenter
      // 0e0: aload 0
      // 0e1: getfield x/oc89e52ca90f.S Ljava/net/http/WebSocket;
      // 0e4: astore 8
      // 0e6: aload 0
      // 0e7: aconst_null
      // 0e8: putfield x/oc89e52ca90f.S Ljava/net/http/WebSocket;
      // 0eb: aload 0
      // 0ec: bipush 0
      // 0ed: putfield x/oc89e52ca90f.Ѫ Z
      // 0f0: aload 0
      // 0f1: dup
      // 0f2: getfield x/oc89e52ca90f.ԗ J
      // 0f5: lconst_1
      // 0f6: ladd
      // 0f7: dup2_x1
      // 0f8: putfield x/oc89e52ca90f.ԗ J
      // 0fb: lstore 9
      // 0fd: aload 11
      // 0ff: monitorexit
      // 100: goto 10b
      // 103: astore 12
      // 105: aload 11
      // 107: monitorexit
      // 108: aload 12
      // 10a: athrow
      // 10b: aload 8
      // 10d: iload 4
      // 10f: ifne 11b
      // 112: ifnull 120
      // 115: goto 119
      // 118: athrow
      // 119: aload 8
      // 11b: invokeinterface java/net/http/WebSocket.abort ()V 1
      // 120: new x/oce80df83360
      // 123: dup
      // 124: aload 0
      // 125: lload 9
      // 127: aload 7
      // 129: invokevirtual com/google/gson/JsonObject.toString ()Ljava/lang/String;
      // 12c: invokespecial x/oce80df83360.<init> (Lx/oc89e52ca90f;JLjava/lang/String;)V
      // 12f: astore 11
      // 131: aload 0
      // 132: getfield x/oc89e52ca90f.Ώ Ljava/net/http/HttpClient;
      // 135: invokevirtual java/net/http/HttpClient.newWebSocketBuilder ()Ljava/net/http/WebSocket$Builder;
      // 138: ldc2_w 8549543989112388425
      // 13b: ldc2_w 8549543989112388417
      // 13e: lxor
      // 13f: invokestatic java/time/Duration.ofSeconds (J)Ljava/time/Duration;
      // 142: invokeinterface java/net/http/WebSocket$Builder.connectTimeout (Ljava/time/Duration;)Ljava/net/http/WebSocket$Builder; 2
      // 147: aload 0
      // 148: getfield x/oc89e52ca90f.τ Ljava/net/URI;
      // 14b: aload 11
      // 14d: invokeinterface java/net/http/WebSocket$Builder.buildAsync (Ljava/net/URI;Ljava/net/http/WebSocket$Listener;)Ljava/util/concurrent/CompletableFuture; 3
      // 152: invokedynamic apply ()Ljava/util/function/Function; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Ljava/lang/Object;, x/oc89e52ca90f.q33km6thm4p8by (Ljava/net/http/WebSocket;)Ljava/lang/Void;, (Ljava/net/http/WebSocket;)Ljava/lang/Void; ]
      // 157: invokevirtual java/util/concurrent/CompletableFuture.thenApply (Ljava/util/function/Function;)Ljava/util/concurrent/CompletableFuture;
      // 15a: bipush 0
      // 15b: ifeq 170
      // 15e: iload 4
      // 160: ifeq 16c
      // 163: goto 167
      // 166: athrow
      // 167: bipush 0
      // 168: goto 16d
      // 16b: athrow
      // 16c: bipush 1
      // 16d: putstatic x/oce490879787.փ Z
      // 170: areturn
   }

   boolean Ѓ(String var1) {
      return this.ǧ(ƈ(var1));
   }

   boolean Ʋ(String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: new com/google/gson/JsonObject
      // 03: dup
      // 04: invokespecial com/google/gson/JsonObject.<init> ()V
      // 07: astore 3
      // 08: aload 3
      // 09: ldc "type"
      // 0b: ldc_w "presence"
      // 0e: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/String;)V
      // 11: getstatic x/oce490879787.փ Z
      // 14: aload 3
      // 15: ldc "server"
      // 17: aload 1
      // 18: invokestatic x/oc89e52ca90f.Ή (Ljava/lang/String;)Ljava/lang/String;
      // 1b: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/String;)V
      // 1e: istore 2
      // 1f: aload 0
      // 20: iload 2
      // 21: ifne 50
      // 24: getfield x/oc89e52ca90f.Ϋ Z
      // 27: ifeq 4f
      // 2a: goto 2e
      // 2d: athrow
      // 2e: aload 0
      // 2f: iload 2
      // 30: ifne 50
      // 33: goto 37
      // 36: athrow
      // 37: getfield x/oc89e52ca90f.ż Z
      // 3a: ifeq 4f
      // 3d: goto 41
      // 40: athrow
      // 41: aload 3
      // 42: ldc "hidden"
      // 44: bipush 1
      // 45: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
      // 48: invokevirtual com/google/gson/JsonObject.addProperty (Ljava/lang/String;Ljava/lang/Boolean;)V
      // 4b: goto 4f
      // 4e: athrow
      // 4f: aload 0
      // 50: aload 3
      // 51: invokevirtual x/oc89e52ca90f.ǧ (Lcom/google/gson/JsonObject;)Z
      // 54: ireturn
   }

   void Ⱥ(boolean var1) {
      this.Ϋ = var1;
   }

   boolean Ė() {
      JsonObject var1 = new JsonObject();
      var1.addProperty("type", "ping");
      return this.ǧ(var1);
   }

   // $VF: Could not create synchronized statement, marking monitor enters and exits
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   boolean ŭ() {
      Object var2 = this.Ȓ;
      synchronized (this.Ȓ){} // $VF: monitorenter 
      boolean var1 = oce490879787.փ;

      try {
         boolean var6;
         label38: {
            label37: {
               oc89e52ca90f var10000 = this;
               if (!var1) {
                  if (!this.Ѫ) {
                     break label37;
                  }

                  var10000 = this;
               }

               if (var10000.S != null) {
                  var6 = true;
                  break label38;
               }
            }

            var6 = false;
         }

         // $VF: monitorexit
         return var6;
      } finally {
         // $VF: monitorexit
      }
   }

   boolean Ā() {
      synchronized (this.Ȓ) {
         return this.S != null;
      }
   }

   long Н() {
      return this.Ύ;
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // $VF: Could not create synchronized statement, marking monitor enters and exits
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   void w() {
      Object var4 = this.Ȓ;
      synchronized (this.Ȓ){} // $VF: monitorenter 
      boolean var1 = oce490879787.փ;
      boolean var9 = false /* VF: Semaphore variable */;

      WebSocket var2;
      boolean var3;
      try {
         var9 = true;
         var2 = this.S;
         var3 = var2 != null;
         this.S = null;
         this.Ѫ = false;
         this.ԗ++;
         // $VF: monitorexit
         var9 = false;
      } finally {
         if (var9) {
            // $VF: monitorexit
         }
      }

      label62: {
         WebSocket var10000;
         label61: {
            try {
               var10000 = var2;
               if (var1) {
                  break label61;
               }

               if (var2 == null) {
                  break label62;
               }
            } catch (IllegalArgumentException var12) {
               throw var12;
            }

            var10000 = var2;
         }

         var10000.abort();
      }

      try {
         if (var3) {
            this.я.z$2o0lr31w38sle();
         }
      } catch (IllegalArgumentException var10) {
         throw var10;
      }
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // $VF: Could not create synchronized statement, marking monitor enters and exits
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private boolean ǧ(JsonObject var1) {
      Object var6 = this.Ȓ;
      synchronized (this.Ȓ){} // $VF: monitorenter 
      boolean var2 = oce490879787.փ;
      boolean var9 = false /* VF: Semaphore variable */;

      WebSocket var3;
      long var4;
      try {
         oc89e52ca90f var13;
         label46: {
            var9 = true;
            boolean var10000 = this.Ѫ;
            if (!var2) {
               if (this.Ѫ) {
                  var13 = this;
                  if (var2) {
                     break label46;
                  }

                  if (this.S != null) {
                     var13 = this;
                     break label46;
                  }
               }

               var10000 = false;
            }

            // $VF: monitorexit
            return var10000;
         }

         var3 = var13.S;
         var4 = this.ԗ;
         // $VF: monitorexit
         var9 = false;
      } finally {
         if (var9) {
            // $VF: monitorexit
         }
      }

      this.s(var4, var3, var1.toString());
      return true;
   }

   private void s(long var1, WebSocket var3, String var4) {
      var3.sendText(var4, true).whenComplete((var4x, var5) -> {
         try {
            if (var5 != null) {
               this.ɢ(var1, var3);
            }
         } catch (IllegalArgumentException var6) {
            throw var6;
         }
      });
   }

   // $VF: Could not create synchronized statement, marking monitor enters and exits
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private boolean ն(long var1, WebSocket var3) {
      Object var5 = this.Ȓ;
      synchronized (this.Ȓ){} // $VF: monitorenter 
      boolean var4 = oce490879787.փ;

      try {
         long var12;
         int var10000 = (var12 = this.ԗ - var1) == 0L ? 0 : (var12 < 0L ? -1 : 1);
         if (!var4) {
            label50:
            if (!var10000) {
               oc89e52ca90f var11 = this;
               if (!var4) {
                  if (this.S != null) {
                     break label50;
                  }

                  var11 = this;
               }

               var11.S = var3;
               long var6 = System.currentTimeMillis();
               this.Ύ = var6;
               // $VF: monitorexit
               return true;
            }

            var10000 = 0;
         }

         // $VF: monitorexit
         return (boolean)var10000;
      } finally {
         // $VF: monitorexit
      }
   }

   // $VF: Could not create synchronized statement, marking monitor enters and exits
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private boolean Ƌ(long var1, WebSocket var3) {
      Object var5 = this.Ȓ;
      synchronized (this.Ȓ){} // $VF: monitorenter 
      boolean var4 = oce490879787.փ;

      try {
         long var12;
         int var10000 = (var12 = this.ԗ - var1) == 0L ? 0 : (var12 < 0L ? -1 : 1);
         if (!var4) {
            label50:
            if (!var10000) {
               oc89e52ca90f var11 = this;
               if (!var4) {
                  if (this.S != var3) {
                     break label50;
                  }

                  var11 = this;
               }

               var11.Ѫ = true;
               long var6 = System.currentTimeMillis();
               this.Ύ = var6;
               // $VF: monitorexit
               return true;
            }

            var10000 = 0;
         }

         // $VF: monitorexit
         return (boolean)var10000;
      } finally {
         // $VF: monitorexit
      }
   }

   // $VF: Could not create synchronized statement, marking monitor enters and exits
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private boolean Ƅ(long var1, WebSocket var3) {
      Object var5 = this.Ȓ;
      synchronized (this.Ȓ){} // $VF: monitorenter 
      boolean var4 = oce490879787.փ;

      try {
         boolean var9;
         label38: {
            label37: {
               oc89e52ca90f var10000 = this;
               if (!var4) {
                  if (this.ԗ != var1) {
                     break label37;
                  }

                  var10000 = this;
               }

               if (var10000.S == var3) {
                  var9 = true;
                  break label38;
               }
            }

            var9 = false;
         }

         // $VF: monitorexit
         return var9;
      } finally {
         // $VF: monitorexit
      }
   }

   private void ɢ(long var1, WebSocket var3) {
      boolean var5 = false;
      boolean var4 = oce490879787.փ;
      synchronized (this.Ȓ) {
         label41: {
            oc89e52ca90f var10000 = this;
            if (!var4) {
               if (this.ԗ != var1) {
                  break label41;
               }

               var10000 = this;
            }

            if (!var4) {
               if (var10000.S != var3) {
                  break label41;
               }

               this.S = null;
               this.Ѫ = false;
               var10000 = this;
            }

            var10000.ԗ++;
            var5 = true;
         }
      }

      try {
         if (var5) {
            var3.abort();
            this.я.z$2o0lr31w38sle();
         }
      } catch (IllegalArgumentException var8) {
         throw var8;
      }
   }

   private void Ë(long param1, WebSocket param3, String param4) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce490879787.փ Z
      // 003: istore 5
      // 005: aload 0
      // 006: iload 5
      // 008: ifne 01a
      // 00b: lload 1
      // 00c: aload 3
      // 00d: invokevirtual x/oc89e52ca90f.Ƅ (JLjava/net/http/WebSocket;)Z
      // 010: ifne 019
      // 013: goto 017
      // 016: athrow
      // 017: return
      // 018: athrow
      // 019: aload 0
      // 01a: invokestatic java/lang/System.currentTimeMillis ()J
      // 01d: putfield x/oc89e52ca90f.Ύ J
      // 020: new com/google/gson/JsonParser
      // 023: dup
      // 024: invokespecial com/google/gson/JsonParser.<init> ()V
      // 027: aload 4
      // 029: invokevirtual com/google/gson/JsonParser.parse (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 02c: astore 6
      // 02e: goto 037
      // 031: astore 7
      // 033: invokestatic x/oc89e52ca90f.ɱ ()Ljava/io/IOException;
      // 036: athrow
      // 037: aload 6
      // 039: iload 5
      // 03b: ifne 04f
      // 03e: invokevirtual com/google/gson/JsonElement.isJsonObject ()Z
      // 041: ifne 04d
      // 044: goto 048
      // 047: athrow
      // 048: invokestatic x/oc89e52ca90f.ɱ ()Ljava/io/IOException;
      // 04b: athrow
      // 04c: athrow
      // 04d: aload 6
      // 04f: invokevirtual com/google/gson/JsonElement.getAsJsonObject ()Lcom/google/gson/JsonObject;
      // 052: astore 7
      // 054: aload 7
      // 056: ldc "type"
      // 058: ldc_w -2111735889
      // 05b: ldc_w -2111735921
      // 05e: ixor
      // 05f: invokestatic x/oc89e52ca90f.S (Lcom/google/gson/JsonObject;Ljava/lang/String;I)Ljava/lang/String;
      // 062: astore 8
      // 064: ldc_w "auth_success"
      // 067: iload 5
      // 069: ifne 100
      // 06c: aload 8
      // 06e: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 071: ifeq 0fd
      // 074: goto 078
      // 077: athrow
      // 078: aload 7
      // 07a: ldc_w "username"
      // 07d: ldc_w -2111735889
      // 080: ldc_w -2111735921
      // 083: ixor
      // 084: invokestatic x/oc89e52ca90f.S (Lcom/google/gson/JsonObject;Ljava/lang/String;I)Ljava/lang/String;
      // 087: astore 9
      // 089: aload 7
      // 08b: ldc_w "cursor"
      // 08e: ldc_w -2111735857
      // 091: ldc_w -2111735921
      // 094: ixor
      // 095: invokestatic x/oc89e52ca90f.Ȯ (Lcom/google/gson/JsonObject;Ljava/lang/String;I)Ljava/lang/String;
      // 098: astore 10
      // 09a: aload 10
      // 09c: iload 5
      // 09e: ifne 0ae
      // 0a1: ifnonnull 0ac
      // 0a4: goto 0a8
      // 0a7: athrow
      // 0a8: ldc ""
      // 0aa: astore 10
      // 0ac: aload 10
      // 0ae: invokevirtual java/lang/String.isEmpty ()Z
      // 0b1: iload 5
      // 0b3: ifne 0ec
      // 0b6: ifne 0dd
      // 0b9: goto 0bd
      // 0bc: athrow
      // 0bd: getstatic x/oc89e52ca90f.Ԍ Ljava/util/regex/Pattern;
      // 0c0: aload 10
      // 0c2: invokevirtual java/util/regex/Pattern.matcher (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
      // 0c5: invokevirtual java/util/regex/Matcher.matches ()Z
      // 0c8: iload 5
      // 0ca: ifne 0ec
      // 0cd: goto 0d1
      // 0d0: athrow
      // 0d1: ifne 0dd
      // 0d4: goto 0d8
      // 0d7: athrow
      // 0d8: invokestatic x/oc89e52ca90f.ɱ ()Ljava/io/IOException;
      // 0db: athrow
      // 0dc: athrow
      // 0dd: aload 0
      // 0de: iload 5
      // 0e0: ifne 0f0
      // 0e3: lload 1
      // 0e4: aload 3
      // 0e5: invokevirtual x/oc89e52ca90f.Ƌ (JLjava/net/http/WebSocket;)Z
      // 0e8: goto 0ec
      // 0eb: athrow
      // 0ec: ifeq 0fc
      // 0ef: aload 0
      // 0f0: getfield x/oc89e52ca90f.я Lx/oc1990c51762;
      // 0f3: aload 9
      // 0f5: aload 10
      // 0f7: invokeinterface x/oc1990c51762.z$1ain9rmcif72c (Ljava/lang/String;Ljava/lang/String;)V 3
      // 0fc: return
      // 0fd: ldc_w "auth_failed"
      // 100: aload 8
      // 102: iload 5
      // 104: ifne 161
      // 107: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 10a: ifeq 15c
      // 10d: goto 111
      // 110: athrow
      // 111: aload 7
      // 113: ldc_w "reason"
      // 116: ldc_w -2111735857
      // 119: ldc_w -2111735921
      // 11c: ixor
      // 11d: invokestatic x/oc89e52ca90f.S (Lcom/google/gson/JsonObject;Ljava/lang/String;I)Ljava/lang/String;
      // 120: astore 9
      // 122: iload 5
      // 124: ifne 15b
      // 127: aload 0
      // 128: getfield x/oc89e52ca90f.œ Z
      // 12b: ifeq 14a
      // 12e: goto 132
      // 131: athrow
      // 132: ldc_w "unexpected_field"
      // 135: aload 9
      // 137: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 13a: ifeq 14a
      // 13d: goto 141
      // 140: athrow
      // 141: aload 0
      // 142: bipush 0
      // 143: putfield x/oc89e52ca90f.ż Z
      // 146: goto 14a
      // 149: athrow
      // 14a: aload 0
      // 14b: getfield x/oc89e52ca90f.я Lx/oc1990c51762;
      // 14e: aload 9
      // 150: invokeinterface x/oc1990c51762.z$3m9gi0rwxy1yd (Ljava/lang/String;)V 2
      // 155: aload 0
      // 156: lload 1
      // 157: aload 3
      // 158: invokevirtual x/oc89e52ca90f.ɢ (JLjava/net/http/WebSocket;)V
      // 15b: return
      // 15c: ldc_w "chat"
      // 15f: aload 8
      // 161: iload 5
      // 163: ifne 185
      // 166: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 169: ifeq 180
      // 16c: goto 170
      // 16f: athrow
      // 170: aload 0
      // 171: getfield x/oc89e52ca90f.я Lx/oc1990c51762;
      // 174: aload 7
      // 176: invokestatic x/oc89e52ca90f.Р (Lcom/google/gson/JsonObject;)Lx/oce33cf14e5f;
      // 179: invokeinterface x/oc1990c51762.z$1vednwtdjjo44 (Lx/oce33cf14e5f;)V 2
      // 17e: return
      // 17f: athrow
      // 180: ldc_w "presence"
      // 183: aload 8
      // 185: iload 5
      // 187: ifne 1bd
      // 18a: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 18d: ifeq 1af
      // 190: goto 194
      // 193: athrow
      // 194: aload 7
      // 196: invokestatic x/oc89e52ca90f.ǔ (Lcom/google/gson/JsonObject;)Lx/oc2433547729;
      // 199: astore 9
      // 19b: aload 0
      // 19c: getfield x/oc89e52ca90f.я Lx/oc1990c51762;
      // 19f: aload 9
      // 1a1: getfield x/oc2433547729.ą Ljava/util/List;
      // 1a4: aload 9
      // 1a6: getfield x/oc2433547729.չ I
      // 1a9: invokeinterface x/oc1990c51762.z$2wpt8ptpuefzs (Ljava/util/List;I)V 3
      // 1ae: return
      // 1af: ldc_w "error"
      // 1b2: iload 5
      // 1b4: ifne 1e0
      // 1b7: aload 8
      // 1b9: goto 1bd
      // 1bc: athrow
      // 1bd: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 1c0: ifeq 1dd
      // 1c3: aload 0
      // 1c4: getfield x/oc89e52ca90f.я Lx/oc1990c51762;
      // 1c7: aload 7
      // 1c9: ldc_w "message"
      // 1cc: ldc_w -2111736177
      // 1cf: ldc_w -2111735921
      // 1d2: ixor
      // 1d3: invokestatic x/oc89e52ca90f.S (Lcom/google/gson/JsonObject;Ljava/lang/String;I)Ljava/lang/String;
      // 1d6: invokeinterface x/oc1990c51762.z$4rxrffi8xyrb (Ljava/lang/String;)V 2
      // 1db: return
      // 1dc: athrow
      // 1dd: ldc_w "pong"
      // 1e0: aload 8
      // 1e2: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 1e5: ifeq 1ea
      // 1e8: return
      // 1e9: athrow
      // 1ea: invokestatic x/oc89e52ca90f.ɱ ()Ljava/io/IOException;
      // 1ed: athrow
   }

   static oce33cf14e5f Р(JsonObject param0) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: aload 0
      // 001: ldc_w "id"
      // 004: ldc_w 2140364247
      // 007: ldc_w 2140364279
      // 00a: ixor
      // 00b: invokestatic x/oc89e52ca90f.S (Lcom/google/gson/JsonObject;Ljava/lang/String;I)Ljava/lang/String;
      // 00e: astore 2
      // 00f: aload 0
      // 010: ldc_w "cursor"
      // 013: ldc_w 2140364215
      // 016: ldc_w 2140364279
      // 019: ixor
      // 01a: invokestatic x/oc89e52ca90f.S (Lcom/google/gson/JsonObject;Ljava/lang/String;I)Ljava/lang/String;
      // 01d: astore 3
      // 01e: aload 0
      // 01f: ldc_w "source"
      // 022: ldc_w 2140364263
      // 025: ldc_w 2140364279
      // 028: ixor
      // 029: invokestatic x/oc89e52ca90f.S (Lcom/google/gson/JsonObject;Ljava/lang/String;I)Ljava/lang/String;
      // 02c: astore 4
      // 02e: aload 0
      // 02f: ldc_w "username"
      // 032: ldc_w 2140364247
      // 035: ldc_w 2140364279
      // 038: ixor
      // 039: invokestatic x/oc89e52ca90f.S (Lcom/google/gson/JsonObject;Ljava/lang/String;I)Ljava/lang/String;
      // 03c: astore 5
      // 03e: getstatic x/oce490879787.փ Z
      // 041: aload 0
      // 042: ldc_w "role"
      // 045: ldc_w 2140364263
      // 048: ldc_w 2140364279
      // 04b: ixor
      // 04c: invokestatic x/oc89e52ca90f.Ȯ (Lcom/google/gson/JsonObject;Ljava/lang/String;I)Ljava/lang/String;
      // 04f: astore 6
      // 051: aload 0
      // 052: ldc_w "message"
      // 055: ldc_w 2140364023
      // 058: ldc_w 2140364279
      // 05b: ixor
      // 05c: invokestatic x/oc89e52ca90f.S (Lcom/google/gson/JsonObject;Ljava/lang/String;I)Ljava/lang/String;
      // 05f: astore 7
      // 061: aload 0
      // 062: ldc_w "timestamp"
      // 065: invokestatic x/oc89e52ca90f.Ҏ (Lcom/google/gson/JsonObject;Ljava/lang/String;)J
      // 068: lstore 8
      // 06a: istore 1
      // 06b: getstatic x/oc89e52ca90f.ͷ Ljava/util/regex/Pattern;
      // 06e: aload 2
      // 06f: invokevirtual java/util/regex/Pattern.matcher (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
      // 072: iload 1
      // 073: ifne 08b
      // 076: invokevirtual java/util/regex/Matcher.matches ()Z
      // 079: ifeq 10a
      // 07c: goto 080
      // 07f: athrow
      // 080: getstatic x/oc89e52ca90f.Ԍ Ljava/util/regex/Pattern;
      // 083: aload 3
      // 084: invokevirtual java/util/regex/Pattern.matcher (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
      // 087: goto 08b
      // 08a: athrow
      // 08b: invokevirtual java/util/regex/Matcher.matches ()Z
      // 08e: iload 1
      // 08f: ifne 0ad
      // 092: ifeq 10a
      // 095: goto 099
      // 098: athrow
      // 099: ldc_w "client"
      // 09c: iload 1
      // 09d: ifne 0e8
      // 0a0: goto 0a4
      // 0a3: athrow
      // 0a4: aload 4
      // 0a6: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0a9: goto 0ad
      // 0ac: athrow
      // 0ad: ifne 0de
      // 0b0: ldc_w "dashboard"
      // 0b3: iload 1
      // 0b4: ifne 0e8
      // 0b7: goto 0bb
      // 0ba: athrow
      // 0bb: aload 4
      // 0bd: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0c0: ifne 0de
      // 0c3: goto 0c7
      // 0c6: athrow
      // 0c7: ldc_w "discord"
      // 0ca: iload 1
      // 0cb: ifne 0e8
      // 0ce: goto 0d2
      // 0d1: athrow
      // 0d2: aload 4
      // 0d4: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0d7: ifeq 10a
      // 0da: goto 0de
      // 0dd: athrow
      // 0de: aload 6
      // 0e0: iload 1
      // 0e1: ifne 0f8
      // 0e4: goto 0e8
      // 0e7: athrow
      // 0e8: invokestatic x/oc89e52ca90f.Ȥ (Ljava/lang/String;)Z
      // 0eb: ifeq 10a
      // 0ee: aload 5
      // 0f0: iload 1
      // 0f1: ifne 104
      // 0f4: goto 0f8
      // 0f7: athrow
      // 0f8: invokestatic x/oc89e52ca90f.н (Ljava/lang/String;)Z
      // 0fb: ifne 10a
      // 0fe: aload 7
      // 100: goto 104
      // 103: athrow
      // 104: invokestatic x/oc89e52ca90f.н (Ljava/lang/String;)Z
      // 107: ifeq 10f
      // 10a: invokestatic x/oc89e52ca90f.ɱ ()Ljava/io/IOException;
      // 10d: athrow
      // 10e: athrow
      // 10f: new x/oce33cf14e5f
      // 112: dup
      // 113: aload 2
      // 114: aload 3
      // 115: aload 5
      // 117: aload 6
      // 119: aload 4
      // 11b: aload 7
      // 11d: lload 8
      // 11f: invokespecial x/oce33cf14e5f.<init> (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V
      // 122: areturn
   }

   static JsonObject ƈ(String var0) {
      JsonObject var1 = new JsonObject();
      var1.addProperty("type", "chat");
      var1.addProperty("message", var0);
      return var1;
   }

   static oc2433547729 ǔ(JsonObject param0) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce490879787.փ Z
      // 003: aload 0
      // 004: ldc_w "online"
      // 007: invokestatic x/oc89e52ca90f.Ҏ (Lcom/google/gson/JsonObject;Ljava/lang/String;)J
      // 00a: lstore 2
      // 00b: istore 1
      // 00c: aload 0
      // 00d: ldc_w "players"
      // 010: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 013: astore 4
      // 015: lload 2
      // 016: ldc2_w -8649863523819070900
      // 019: ldc2_w -8649863523819022324
      // 01c: lxor
      // 01d: lcmp
      // 01e: ifgt 042
      // 021: aload 4
      // 023: iload 1
      // 024: ifne 03c
      // 027: goto 02b
      // 02a: athrow
      // 02b: ifnull 042
      // 02e: goto 032
      // 031: athrow
      // 032: aload 4
      // 034: iload 1
      // 035: ifne 049
      // 038: goto 03c
      // 03b: athrow
      // 03c: invokevirtual com/google/gson/JsonElement.isJsonArray ()Z
      // 03f: ifne 047
      // 042: invokestatic x/oc89e52ca90f.ɱ ()Ljava/io/IOException;
      // 045: athrow
      // 046: athrow
      // 047: aload 4
      // 049: invokevirtual com/google/gson/JsonElement.getAsJsonArray ()Lcom/google/gson/JsonArray;
      // 04c: astore 5
      // 04e: aload 5
      // 050: invokevirtual com/google/gson/JsonArray.size ()I
      // 053: ldc_w 2006779462
      // 056: ldc_w 2006779826
      // 059: ixor
      // 05a: if_icmple 062
      // 05d: invokestatic x/oc89e52ca90f.ɱ ()Ljava/io/IOException;
      // 060: athrow
      // 061: athrow
      // 062: new java/util/ArrayList
      // 065: dup
      // 066: invokespecial java/util/ArrayList.<init> ()V
      // 069: astore 6
      // 06b: aload 5
      // 06d: invokevirtual com/google/gson/JsonArray.iterator ()Ljava/util/Iterator;
      // 070: astore 7
      // 072: aload 7
      // 074: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 079: ifeq 126
      // 07c: aload 7
      // 07e: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 083: checkcast com/google/gson/JsonElement
      // 086: astore 8
      // 088: aload 8
      // 08a: iload 1
      // 08b: ifne 09f
      // 08e: invokevirtual com/google/gson/JsonElement.isJsonObject ()Z
      // 091: ifne 09d
      // 094: goto 098
      // 097: athrow
      // 098: invokestatic x/oc89e52ca90f.ɱ ()Ljava/io/IOException;
      // 09b: athrow
      // 09c: athrow
      // 09d: aload 8
      // 09f: invokevirtual com/google/gson/JsonElement.getAsJsonObject ()Lcom/google/gson/JsonObject;
      // 0a2: astore 9
      // 0a4: aload 9
      // 0a6: ldc_w "uuid"
      // 0a9: ldc_w 2006779794
      // 0ac: ldc_w 2006779826
      // 0af: ixor
      // 0b0: invokestatic x/oc89e52ca90f.S (Lcom/google/gson/JsonObject;Ljava/lang/String;I)Ljava/lang/String;
      // 0b3: astore 10
      // 0b5: aload 9
      // 0b7: ldc_w "username"
      // 0ba: ldc_w 2006779810
      // 0bd: ldc_w 2006779826
      // 0c0: ixor
      // 0c1: invokestatic x/oc89e52ca90f.S (Lcom/google/gson/JsonObject;Ljava/lang/String;I)Ljava/lang/String;
      // 0c4: astore 11
      // 0c6: getstatic x/oc89e52ca90f.ԡ Ljava/util/regex/Pattern;
      // 0c9: iload 1
      // 0ca: ifne 0e3
      // 0cd: aload 10
      // 0cf: invokevirtual java/util/regex/Pattern.matcher (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
      // 0d2: invokevirtual java/util/regex/Matcher.matches ()Z
      // 0d5: ifeq 10a
      // 0d8: goto 0dc
      // 0db: athrow
      // 0dc: getstatic x/oc89e52ca90f.O Ljava/util/regex/Pattern;
      // 0df: goto 0e3
      // 0e2: athrow
      // 0e3: aload 11
      // 0e5: invokevirtual java/util/regex/Pattern.matcher (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
      // 0e8: invokevirtual java/util/regex/Matcher.matches ()Z
      // 0eb: iload 1
      // 0ec: ifne 0ff
      // 0ef: ifeq 10a
      // 0f2: goto 0f6
      // 0f5: athrow
      // 0f6: aload 11
      // 0f8: invokestatic x/oc89e52ca90f.н (Ljava/lang/String;)Z
      // 0fb: goto 0ff
      // 0fe: athrow
      // 0ff: iload 1
      // 100: ifne 121
      // 103: ifeq 10f
      // 106: goto 10a
      // 109: athrow
      // 10a: invokestatic x/oc89e52ca90f.ɱ ()Ljava/io/IOException;
      // 10d: athrow
      // 10e: athrow
      // 10f: aload 6
      // 111: new x/ocab66880042
      // 114: dup
      // 115: aload 10
      // 117: aload 11
      // 119: invokespecial x/ocab66880042.<init> (Ljava/lang/String;Ljava/lang/String;)V
      // 11c: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 121: pop
      // 122: iload 1
      // 123: ifeq 072
      // 126: new x/oc2433547729
      // 129: dup
      // 12a: aload 6
      // 12c: invokestatic java/util/Collections.unmodifiableList (Ljava/util/List;)Ljava/util/List;
      // 12f: lload 2
      // 130: l2i
      // 131: invokespecial x/oc2433547729.<init> (Ljava/util/List;I)V
      // 134: areturn
   }

   static URI ǵ() throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: ldc_w "miau.irc.websocketUrl"
      // 03: ldc ""
      // 05: invokestatic java/lang/System.getProperty (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 08: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 0b: astore 0
      // 0c: aload 0
      // 0d: invokevirtual java/lang/String.isEmpty ()Z
      // 10: ifeq 23
      // 13: ldc_w "MIAU_IRC_WS_URL"
      // 16: invokestatic java/lang/System.getenv (Ljava/lang/String;)Ljava/lang/String;
      // 19: astore 1
      // 1a: aload 1
      // 1b: ifnull 23
      // 1e: aload 1
      // 1f: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 22: astore 0
      // 23: aload 0
      // 24: invokevirtual java/lang/String.isEmpty ()Z
      // 27: ifeq 2e
      // 2a: ldc_w "wss://irc.getmiau.today/ws"
      // 2d: astore 0
      // 2e: aload 0
      // 2f: invokestatic java/net/URI.create (Ljava/lang/String;)Ljava/net/URI;
      // 32: astore 1
      // 33: aload 1
      // 34: invokevirtual java/net/URI.getScheme ()Ljava/lang/String;
      // 37: astore 2
      // 38: ldc_w "ws"
      // 3b: aload 2
      // 3c: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 3f: ifne 50
      // 42: ldc_w "wss"
      // 45: aload 2
      // 46: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 49: ifeq 8d
      // 4c: goto 50
      // 4f: athrow
      // 50: aload 1
      // 51: invokevirtual java/net/URI.getHost ()Ljava/lang/String;
      // 54: ifnull 8d
      // 57: goto 5b
      // 5a: athrow
      // 5b: aload 1
      // 5c: invokevirtual java/net/URI.getUserInfo ()Ljava/lang/String;
      // 5f: ifnonnull 8d
      // 62: goto 66
      // 65: athrow
      // 66: aload 1
      // 67: invokevirtual java/net/URI.getQuery ()Ljava/lang/String;
      // 6a: ifnonnull 8d
      // 6d: goto 71
      // 70: athrow
      // 71: aload 1
      // 72: invokevirtual java/net/URI.getFragment ()Ljava/lang/String;
      // 75: ifnonnull 8d
      // 78: goto 7c
      // 7b: athrow
      // 7c: ldc_w "/ws"
      // 7f: aload 1
      // 80: invokevirtual java/net/URI.getPath ()Ljava/lang/String;
      // 83: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 86: ifne 92
      // 89: goto 8d
      // 8c: athrow
      // 8d: invokestatic x/oc89e52ca90f.ӕ ()Ljava/io/IOException;
      // 90: athrow
      // 91: athrow
      // 92: aload 1
      // 93: areturn
      // 94: astore 1
      // 95: invokestatic x/oc89e52ca90f.ӕ ()Ljava/io/IOException;
      // 98: athrow
   }

   private static String Ή(String param0) {
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
      // 06: ifne 17
      // 09: ifnonnull 16
      // 0c: goto 10
      // 0f: athrow
      // 10: ldc ""
      // 12: goto 1a
      // 15: athrow
      // 16: aload 0
      // 17: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 1a: astore 2
      // 1b: aload 2
      // 1c: iload 1
      // 1d: ifne 41
      // 20: invokevirtual java/lang/String.length ()I
      // 23: ldc_w -1992780225
      // 26: ldc_w -1992780097
      // 29: ixor
      // 2a: if_icmple 42
      // 2d: goto 31
      // 30: athrow
      // 31: aload 2
      // 32: bipush 0
      // 33: ldc_w -1992780225
      // 36: ldc_w -1992780097
      // 39: ixor
      // 3a: invokevirtual java/lang/String.substring (II)Ljava/lang/String;
      // 3d: goto 41
      // 40: athrow
      // 41: astore 2
      // 42: new java/lang/StringBuilder
      // 45: dup
      // 46: aload 2
      // 47: invokevirtual java/lang/String.length ()I
      // 4a: invokespecial java/lang/StringBuilder.<init> (I)V
      // 4d: astore 3
      // 4e: bipush 0
      // 4f: istore 4
      // 51: iload 4
      // 53: aload 2
      // 54: invokevirtual java/lang/String.length ()I
      // 57: if_icmpge 98
      // 5a: aload 2
      // 5b: iload 4
      // 5d: invokevirtual java/lang/String.charAt (I)C
      // 60: iload 1
      // 61: ifne a4
      // 64: istore 5
      // 66: iload 1
      // 67: ifne 94
      // 6a: iload 5
      // 6c: ldc_w -1992780264
      // 6f: ldc_w -1992780097
      // 72: ixor
      // 73: if_icmpeq 91
      // 76: goto 7a
      // 79: athrow
      // 7a: iload 5
      // 7c: invokestatic java/lang/Character.isISOControl (C)Z
      // 7f: ifne 91
      // 82: goto 86
      // 85: athrow
      // 86: aload 3
      // 87: iload 5
      // 89: invokevirtual java/lang/StringBuilder.append (C)Ljava/lang/StringBuilder;
      // 8c: pop
      // 8d: goto 91
      // 90: athrow
      // 91: iinc 4 1
      // 94: iload 1
      // 95: ifeq 51
      // 98: aload 3
      // 99: iload 1
      // 9a: ifne af
      // 9d: invokevirtual java/lang/StringBuilder.length ()I
      // a0: goto a4
      // a3: athrow
      // a4: ifne ae
      // a7: ldc_w "Main Menu"
      // aa: goto b2
      // ad: athrow
      // ae: aload 3
      // af: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // b2: areturn
   }

   private static String Ͻ(String param0, int param1) throws IOException {
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
      // 05: iload 2
      // 06: ifne 17
      // 09: ifnonnull 16
      // 0c: goto 10
      // 0f: athrow
      // 10: ldc ""
      // 12: goto 1a
      // 15: athrow
      // 16: aload 0
      // 17: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 1a: astore 3
      // 1b: aload 3
      // 1c: iload 2
      // 1d: ifne 2f
      // 20: invokevirtual java/lang/String.isEmpty ()Z
      // 23: ifne 3e
      // 26: goto 2a
      // 29: athrow
      // 2a: aload 3
      // 2b: goto 2f
      // 2e: athrow
      // 2f: iload 2
      // 30: ifne 4b
      // 33: invokevirtual java/lang/String.length ()I
      // 36: iload 1
      // 37: if_icmple 4a
      // 3a: goto 3e
      // 3d: athrow
      // 3e: new java/io/IOException
      // 41: dup
      // 42: ldc_w "The IRC request contains an invalid value."
      // 45: invokespecial java/io/IOException.<init> (Ljava/lang/String;)V
      // 48: athrow
      // 49: athrow
      // 4a: aload 3
      // 4b: areturn
   }

   private static String S(JsonObject param0, String param1, int param2) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce490879787.փ Z
      // 03: aload 0
      // 04: aload 1
      // 05: iload 2
      // 06: invokestatic x/oc89e52ca90f.Ȯ (Lcom/google/gson/JsonObject;Ljava/lang/String;I)Ljava/lang/String;
      // 09: astore 4
      // 0b: istore 3
      // 0c: aload 4
      // 0e: iload 3
      // 0f: ifne 1b
      // 12: ifnull 29
      // 15: goto 19
      // 18: athrow
      // 19: aload 4
      // 1b: iload 3
      // 1c: ifne 30
      // 1f: invokevirtual java/lang/String.isEmpty ()Z
      // 22: ifeq 2e
      // 25: goto 29
      // 28: athrow
      // 29: invokestatic x/oc89e52ca90f.ɱ ()Ljava/io/IOException;
      // 2c: athrow
      // 2d: athrow
      // 2e: aload 4
      // 30: areturn
   }

   private static String Ȯ(JsonObject param0, String param1, int param2) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce490879787.փ Z
      // 03: aload 0
      // 04: aload 1
      // 05: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 08: astore 4
      // 0a: istore 3
      // 0b: aload 4
      // 0d: iload 3
      // 0e: ifne 1a
      // 11: ifnull 28
      // 14: goto 18
      // 17: athrow
      // 18: aload 4
      // 1a: iload 3
      // 1b: ifne 2d
      // 1e: invokevirtual com/google/gson/JsonElement.isJsonNull ()Z
      // 21: ifeq 2b
      // 24: goto 28
      // 27: athrow
      // 28: aconst_null
      // 29: areturn
      // 2a: athrow
      // 2b: aload 4
      // 2d: iload 3
      // 2e: ifne 41
      // 31: invokevirtual com/google/gson/JsonElement.isJsonPrimitive ()Z
      // 34: ifeq 52
      // 37: goto 3b
      // 3a: athrow
      // 3b: aload 4
      // 3d: goto 41
      // 40: athrow
      // 41: iload 3
      // 42: ifne 59
      // 45: invokevirtual com/google/gson/JsonElement.getAsJsonPrimitive ()Lcom/google/gson/JsonPrimitive;
      // 48: invokevirtual com/google/gson/JsonPrimitive.isString ()Z
      // 4b: ifne 57
      // 4e: goto 52
      // 51: athrow
      // 52: invokestatic x/oc89e52ca90f.ɱ ()Ljava/io/IOException;
      // 55: athrow
      // 56: athrow
      // 57: aload 4
      // 59: invokevirtual com/google/gson/JsonElement.getAsString ()Ljava/lang/String;
      // 5c: astore 5
      // 5e: aload 5
      // 60: iload 3
      // 61: ifne 76
      // 64: invokevirtual java/lang/String.length ()I
      // 67: iload 2
      // 68: if_icmple 74
      // 6b: goto 6f
      // 6e: athrow
      // 6f: invokestatic x/oc89e52ca90f.ɱ ()Ljava/io/IOException;
      // 72: athrow
      // 73: athrow
      // 74: aload 5
      // 76: areturn
   }

   private static long Ҏ(JsonObject param0, String param1) throws IOException {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce490879787.փ Z
      // 03: aload 0
      // 04: aload 1
      // 05: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 08: astore 3
      // 09: istore 2
      // 0a: aload 3
      // 0b: iload 2
      // 0c: ifne 1f
      // 0f: ifnull 37
      // 12: goto 16
      // 15: athrow
      // 16: aload 3
      // 17: iload 2
      // 18: ifne 2e
      // 1b: goto 1f
      // 1e: athrow
      // 1f: invokevirtual com/google/gson/JsonElement.isJsonPrimitive ()Z
      // 22: ifeq 37
      // 25: aload 3
      // 26: iload 2
      // 27: ifne 3d
      // 2a: goto 2e
      // 2d: athrow
      // 2e: invokevirtual com/google/gson/JsonElement.getAsJsonPrimitive ()Lcom/google/gson/JsonPrimitive;
      // 31: invokevirtual com/google/gson/JsonPrimitive.isNumber ()Z
      // 34: ifne 3c
      // 37: invokestatic x/oc89e52ca90f.ɱ ()Ljava/io/IOException;
      // 3a: athrow
      // 3b: athrow
      // 3c: aload 3
      // 3d: invokevirtual com/google/gson/JsonElement.getAsString ()Ljava/lang/String;
      // 40: astore 4
      // 42: aload 4
      // 44: iload 2
      // 45: ifne 5c
      // 48: ldc_w "0|[1-9][0-9]*"
      // 4b: invokevirtual java/lang/String.matches (Ljava/lang/String;)Z
      // 4e: ifne 5a
      // 51: goto 55
      // 54: athrow
      // 55: invokestatic x/oc89e52ca90f.ɱ ()Ljava/io/IOException;
      // 58: athrow
      // 59: athrow
      // 5a: aload 4
      // 5c: invokestatic java/lang/Long.parseLong (Ljava/lang/String;)J
      // 5f: lstore 5
      // 61: lload 5
      // 63: iload 2
      // 64: ifne 77
      // 67: lconst_0
      // 68: lcmp
      // 69: ifge 75
      // 6c: goto 70
      // 6f: athrow
      // 70: invokestatic x/oc89e52ca90f.ɱ ()Ljava/io/IOException;
      // 73: athrow
      // 74: athrow
      // 75: lload 5
      // 77: lreturn
      // 78: astore 4
      // 7a: invokestatic x/oc89e52ca90f.ɱ ()Ljava/io/IOException;
      // 7d: athrow
   }

   private static boolean Ȥ(String param0) {
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
      // 06: ifne 13
      // 09: ifnull 90
      // 0c: goto 10
      // 0f: athrow
      // 10: ldc_w "owner"
      // 13: aload 0
      // 14: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 17: iload 1
      // 18: ifne 91
      // 1b: ifne 90
      // 1e: goto 22
      // 21: athrow
      // 22: ldc_w "dev"
      // 25: aload 0
      // 26: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 29: iload 1
      // 2a: ifne 91
      // 2d: goto 31
      // 30: athrow
      // 31: ifne 90
      // 34: goto 38
      // 37: athrow
      // 38: ldc_w "manager"
      // 3b: aload 0
      // 3c: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 3f: iload 1
      // 40: ifne 91
      // 43: goto 47
      // 46: athrow
      // 47: ifne 90
      // 4a: goto 4e
      // 4d: athrow
      // 4e: ldc_w "helper"
      // 51: aload 0
      // 52: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 55: iload 1
      // 56: ifne 91
      // 59: goto 5d
      // 5c: athrow
      // 5d: ifne 90
      // 60: goto 64
      // 63: athrow
      // 64: ldc_w "media"
      // 67: aload 0
      // 68: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 6b: iload 1
      // 6c: ifne 91
      // 6f: goto 73
      // 72: athrow
      // 73: ifne 90
      // 76: goto 7a
      // 79: athrow
      // 7a: ldc_w "friends"
      // 7d: aload 0
      // 7e: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 81: iload 1
      // 82: ifne 91
      // 85: goto 89
      // 88: athrow
      // 89: ifeq 94
      // 8c: goto 90
      // 8f: athrow
      // 90: bipush 1
      // 91: goto 95
      // 94: bipush 0
      // 95: ireturn
   }

   private static boolean н(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce490879787.փ Z
      // 03: bipush 0
      // 04: istore 2
      // 05: istore 1
      // 06: iload 2
      // 07: aload 0
      // 08: invokevirtual java/lang/String.length ()I
      // 0b: if_icmpge 4b
      // 0e: aload 0
      // 0f: iload 2
      // 10: invokevirtual java/lang/String.charAt (I)C
      // 13: iload 1
      // 14: ifne 4c
      // 17: istore 3
      // 18: iload 3
      // 19: iload 1
      // 1a: ifne 43
      // 1d: ldc_w 2023474905
      // 20: ldc_w 2023474814
      // 23: ixor
      // 24: if_icmpeq 3e
      // 27: goto 2b
      // 2a: athrow
      // 2b: iload 3
      // 2c: iload 1
      // 2d: ifne 43
      // 30: goto 34
      // 33: athrow
      // 34: invokestatic java/lang/Character.isISOControl (C)Z
      // 37: ifeq 44
      // 3a: goto 3e
      // 3d: athrow
      // 3e: bipush 1
      // 3f: goto 43
      // 42: athrow
      // 43: ireturn
      // 44: iinc 2 1
      // 47: iload 1
      // 48: ifeq 06
      // 4b: bipush 0
      // 4c: ireturn
   }

   private static IOException ɱ() {
      return new IOException("The IRC service returned an invalid packet.");
   }

   private static IOException ӕ() {
      return new IOException("The IRC WebSocket endpoint is invalid.");
   }
}

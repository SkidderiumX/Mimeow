package x;

import com.google.gson.JsonObject;

public class oc321b4679dd extends N {
   private final String ә;
   private final int Χ;
   private final Runnable ʠ;
   private String Ч;
   private boolean þ;
   private boolean ʙ;
   private long Ԣ;
   public occc831eff22 ǡ;
   public static int v;

   public oc321b4679dd(String var1, String var2, String var3, int var4) {
      this(var1, var2, var3, var4, null);
   }

   public oc321b4679dd(String var1, String var2, String var3, int var4, Runnable var5) {
      super(var1);
      this.ә = var3 == null ? "" : var3;
      this.Χ = Math.max(1, var4);
      this.ʠ = var5;
      this.z$1bnplyl2p7uqx(var2);
   }

   public oc321b4679dd(occc831eff22 var1, String var2, String var3, String var4, int var5) {
      this(var1, var2, var3, var4, var5, null);
   }

   public oc321b4679dd(occc831eff22 var1, String var2, String var3, String var4, int var5, Runnable var6) {
      this(var2, var3, var4, var5, var6);
      this.ǡ = var1;
   }

   public String Ê() {
      return this.Ч;
   }

   public void z$1bnplyl2p7uqx(String var1) {
      String var10000;
      label20: {
         try {
            if (var1 == null) {
               var10000 = "";
               break label20;
            }
         } catch (ocbde1165e4e var3) {
            throw var3;
         }

         var10000 = var1;
      }

      String var2 = var10000;
      if (var2.length() > this.Χ) {
         var2 = var2.substring(0, this.Χ);
      }

      this.Ч = var2;
   }

   public String մ() {
      return this.ә;
   }

   public int x() {
      return this.Χ;
   }

   public oc321b4679dd Ӂ(boolean param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oca9cc61aada.Ƿ I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 1f
      // 09: iload 1
      // 0a: putfield x/oc321b4679dd.þ Z
      // 0d: iload 1
      // 0e: ifeq 1e
      // 11: goto 15
      // 14: athrow
      // 15: aload 0
      // 16: bipush 1
      // 17: putfield x/oc321b4679dd.ʙ Z
      // 1a: goto 1e
      // 1d: athrow
      // 1e: aload 0
      // 1f: areturn
   }

   public boolean Ǽ() {
      return this.þ;
   }

   public oc321b4679dd ɞ(boolean var1) {
      this.ʙ = var1;
      return this;
   }

   public boolean ë() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oca9cc61aada.Ƿ I
      // 03: istore 1
      // 04: aload 0
      // 05: getfield x/oc321b4679dd.ʙ Z
      // 08: iload 1
      // 09: ifne 1f
      // 0c: ifeq 2e
      // 0f: goto 13
      // 12: athrow
      // 13: invokestatic java/lang/System.currentTimeMillis ()J
      // 16: aload 0
      // 17: getfield x/oc321b4679dd.Ԣ J
      // 1a: lcmp
      // 1b: goto 1f
      // 1e: athrow
      // 1f: iload 1
      // 20: ifne 2b
      // 23: iflt 2e
      // 26: goto 2a
      // 29: athrow
      // 2a: bipush 1
      // 2b: goto 2f
      // 2e: bipush 0
      // 2f: ireturn
   }

   public void Ϭ(long var1) {
      this.Ԣ = System.currentTimeMillis() + Math.max(0L, var1);
   }

   @Override
   public String z$3lm3x0je4b2zv() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oca9cc61aada.Ƿ I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 1c
      // 09: getfield x/oc321b4679dd.ǡ Lx/occc831eff22;
      // 0c: ifnonnull 1b
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: invokevirtual x/N.z$18nrktuqeiysv ()Ljava/lang/String;
      // 17: goto 2b
      // 1a: athrow
      // 1b: aload 0
      // 1c: getfield x/oc321b4679dd.ǡ Lx/occc831eff22;
      // 1f: invokevirtual x/N.z$18nrktuqeiysv ()Ljava/lang/String;
      // 22: aload 0
      // 23: invokevirtual x/N.z$18nrktuqeiysv ()Ljava/lang/String;
      // 26: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001.\u0001" ]
      // 2b: areturn
   }

   public void ƺ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oca9cc61aada.Ƿ I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 18
      // 09: getfield x/oc321b4679dd.ʠ Ljava/lang/Runnable;
      // 0c: ifnull 20
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: getfield x/oc321b4679dd.ʠ Ljava/lang/Runnable;
      // 1b: invokeinterface java/lang/Runnable.run ()V 1
      // 20: return
   }

   @Override
   public void z$3ktkzjg2sjswq(JsonObject param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oca9cc61aada.Ƿ I
      // 03: istore 2
      // 04: aload 0
      // 05: getfield x/oc321b4679dd.þ Z
      // 08: ifne 13
      // 0b: aload 1
      // 0c: ifnonnull 15
      // 0f: goto 13
      // 12: athrow
      // 13: return
      // 14: athrow
      // 15: aload 0
      // 16: invokevirtual x/oc321b4679dd.z$3lm3x0je4b2zv ()Ljava/lang/String;
      // 19: astore 3
      // 1a: aload 1
      // 1b: aload 3
      // 1c: iload 2
      // 1d: ifne 30
      // 20: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 23: ifeq 49
      // 26: goto 2a
      // 29: athrow
      // 2a: aload 1
      // 2b: aload 3
      // 2c: goto 30
      // 2f: athrow
      // 30: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 33: invokevirtual com/google/gson/JsonElement.isJsonPrimitive ()Z
      // 36: ifeq 49
      // 39: aload 0
      // 3a: aload 1
      // 3b: aload 3
      // 3c: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 3f: invokevirtual com/google/gson/JsonElement.getAsString ()Ljava/lang/String;
      // 42: invokevirtual x/oc321b4679dd.z$1bnplyl2p7uqx (Ljava/lang/String;)V
      // 45: goto 49
      // 48: athrow
      // 49: return
   }
}

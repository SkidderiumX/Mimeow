package x;

import com.google.gson.JsonObject;

public class occ2f8dff8d8 extends N {
   private String Ȩ;
   private boolean ҁ;
   public boolean ӽ;
   private Runnable с;
   public occc831eff22 ϡ;
   private final String[] ɒ;
   public static boolean Ό;

   public occ2f8dff8d8(String var1, boolean var2) {
      super(var1);
      this.Ȩ = var1;
      this.ҁ = var2;
      this.ӽ = false;
      this.ɒ = new String[0];
   }

   public occ2f8dff8d8(String var1, boolean var2, String... var3) {
      super(var1);
      this.Ȩ = var1;
      this.ҁ = var2;
      this.ӽ = false;
      this.ɒ = var3 != null ? var3 : new String[0];
   }

   public occ2f8dff8d8(occc831eff22 var1, String var2, boolean var3) {
      super(var2);
      this.ϡ = var1;
      this.Ȩ = var2;
      this.ҁ = var3;
      this.ӽ = false;
      this.ɒ = new String[0];
   }

   public occ2f8dff8d8(occc831eff22 var1, String var2, boolean var3, String... var4) {
      super(var2);
      this.ϡ = var1;
      this.Ȩ = var2;
      this.ҁ = var3;
      this.ӽ = false;
      this.ɒ = var4 != null ? var4 : new String[0];
   }

   public occ2f8dff8d8(String var1, Runnable var2) {
      super(var1);
      this.Ȩ = var1;
      this.ҁ = false;
      this.ӽ = true;
      this.с = var2;
      this.ɒ = new String[0];
   }

   public void ը() {
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
      // 09: getfield x/occ2f8dff8d8.с Ljava/lang/Runnable;
      // 0c: ifnull 20
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: getfield x/occ2f8dff8d8.с Ljava/lang/Runnable;
      // 1b: invokeinterface java/lang/Runnable.run ()V 1
      // 20: return
   }

   @Override
   public String z$18nrktuqeiysv() {
      return this.Ȩ;
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
      // 09: getfield x/occ2f8dff8d8.ϡ Lx/occc831eff22;
      // 0c: ifnonnull 1b
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: invokevirtual x/occ2f8dff8d8.z$18nrktuqeiysv ()Ljava/lang/String;
      // 17: goto 2b
      // 1a: athrow
      // 1b: aload 0
      // 1c: getfield x/occ2f8dff8d8.ϡ Lx/occc831eff22;
      // 1f: invokevirtual x/N.z$18nrktuqeiysv ()Ljava/lang/String;
      // 22: aload 0
      // 23: invokevirtual x/occ2f8dff8d8.z$18nrktuqeiysv ()Ljava/lang/String;
      // 26: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001.\u0001" ]
      // 2b: areturn
   }

   public boolean ǭ() {
      return this.ҁ;
   }

   public void ѝ() {
      int var1 = oca9cc61aada.Ƿ;

      occ2f8dff8d8 var10000;
      boolean var10001;
      label22: {
         label21: {
            try {
               var10000 = this;
               var10001 = this.ҁ;
               if (var1 != 0) {
                  break label22;
               }

               if (!this.ҁ) {
                  break label21;
               }
            } catch (ocbde1165e4e var2) {
               throw var2;
            }

            var10001 = false;
            break label22;
         }

         var10001 = true;
      }

      var10000.ҁ = var10001;
   }

   public void ȩ() {
      this.ҁ = true;
   }

   public void Տ() {
      this.ҁ = false;
   }

   public void ϑ(boolean var1) {
      this.ҁ = var1;
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
      // 03: aload 0
      // 04: invokevirtual x/occ2f8dff8d8.z$3lm3x0je4b2zv ()Ljava/lang/String;
      // 07: astore 3
      // 08: aload 0
      // 09: invokevirtual x/occ2f8dff8d8.z$18nrktuqeiysv ()Ljava/lang/String;
      // 0c: astore 4
      // 0e: aconst_null
      // 0f: astore 5
      // 11: istore 2
      // 12: aload 1
      // 13: iload 2
      // 14: ifne 29
      // 17: aload 3
      // 18: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 1b: ifeq 28
      // 1e: goto 22
      // 21: athrow
      // 22: aload 3
      // 23: astore 5
      // 25: goto 72
      // 28: aload 1
      // 29: aload 4
      // 2b: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 2e: ifeq 38
      // 31: aload 4
      // 33: astore 5
      // 35: goto 72
      // 38: aload 0
      // 39: getfield x/occ2f8dff8d8.ɒ [Ljava/lang/String;
      // 3c: astore 6
      // 3e: aload 6
      // 40: arraylength
      // 41: istore 7
      // 43: bipush 0
      // 44: istore 8
      // 46: iload 8
      // 48: iload 7
      // 4a: if_icmpge 72
      // 4d: aload 6
      // 4f: iload 8
      // 51: aaload
      // 52: astore 9
      // 54: iload 2
      // 55: ifne 6f
      // 58: aload 1
      // 59: aload 9
      // 5b: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 5e: ifeq 6c
      // 61: goto 65
      // 64: athrow
      // 65: aload 9
      // 67: astore 5
      // 69: goto 72
      // 6c: iinc 8 1
      // 6f: goto 46
      // 72: aload 5
      // 74: ifnull be
      // 77: aload 1
      // 78: aload 5
      // 7a: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 7d: invokevirtual com/google/gson/JsonElement.isJsonPrimitive ()Z
      // 80: iload 2
      // 81: ifne 9f
      // 84: goto 88
      // 87: athrow
      // 88: ifeq be
      // 8b: goto 8f
      // 8e: athrow
      // 8f: aload 0
      // 90: iload 2
      // 91: ifne a3
      // 94: goto 98
      // 97: athrow
      // 98: getfield x/occ2f8dff8d8.ӽ Z
      // 9b: goto 9f
      // 9e: athrow
      // 9f: ifne be
      // a2: aload 0
      // a3: getfield x/occ2f8dff8d8.ҁ Z
      // a6: istore 6
      // a8: aload 1
      // a9: aload 5
      // ab: invokevirtual com/google/gson/JsonObject.getAsJsonPrimitive (Ljava/lang/String;)Lcom/google/gson/JsonPrimitive;
      // ae: invokevirtual com/google/gson/JsonPrimitive.getAsBoolean ()Z
      // b1: istore 6
      // b3: goto b8
      // b6: astore 7
      // b8: aload 0
      // b9: iload 6
      // bb: invokevirtual x/occ2f8dff8d8.ϑ (Z)V
      // be: return
   }
}

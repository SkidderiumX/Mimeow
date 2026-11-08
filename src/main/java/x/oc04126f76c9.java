package x;

import com.google.gson.JsonObject;

public class oc04126f76c9 extends oca9cc61aada {
   final ocdd342096f8 this$0;

   oc04126f76c9(ocdd342096f8 var1, String var2, int var3, String[] var4) {
      super(var2, var3, var4);
      this.this$0 = var1;
   }

   @Override
   public void z$3ktkzjg2sjswq(JsonObject param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: aload 1
      // 05: aload 0
      // 06: invokevirtual x/oca9cc61aada.z$3lm3x0je4b2zv ()Ljava/lang/String;
      // 09: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 0c: ifeq 17
      // 0f: aload 0
      // 10: invokevirtual x/oca9cc61aada.z$3lm3x0je4b2zv ()Ljava/lang/String;
      // 13: goto 1b
      // 16: athrow
      // 17: aload 0
      // 18: invokevirtual x/oca9cc61aada.z$18nrktuqeiysv ()Ljava/lang/String;
      // 1b: astore 3
      // 1c: iload 2
      // 1d: ifne 8b
      // 20: aload 1
      // 21: aload 3
      // 22: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 25: ifeq 86
      // 28: goto 2c
      // 2b: athrow
      // 2c: aload 1
      // 2d: aload 3
      // 2e: iload 2
      // 2f: ifne 45
      // 32: goto 36
      // 35: athrow
      // 36: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 39: invokevirtual com/google/gson/JsonElement.isJsonPrimitive ()Z
      // 3c: ifeq 86
      // 3f: goto 43
      // 42: athrow
      // 43: aload 1
      // 44: aload 3
      // 45: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 48: invokevirtual com/google/gson/JsonElement.getAsDouble ()D
      // 4b: dstore 4
      // 4d: iload 2
      // 4e: ifne 7f
      // 51: dload 4
      // 53: aload 0
      // 54: invokevirtual x/oca9cc61aada.ԕ ()D
      // 57: dcmpg
      // 58: iflt 75
      // 5b: goto 5f
      // 5e: athrow
      // 5f: dload 4
      // 61: iload 2
      // 62: ifne 7e
      // 65: goto 69
      // 68: athrow
      // 69: aload 0
      // 6a: invokevirtual x/oca9cc61aada.ȶ ()D
      // 6d: dcmpl
      // 6e: ifle 80
      // 71: goto 75
      // 74: athrow
      // 75: aload 0
      // 76: dconst_0
      // 77: invokevirtual x/oca9cc61aada.Ȟ (D)D
      // 7a: goto 7e
      // 7d: athrow
      // 7e: pop2
      // 7f: return
      // 80: goto 86
      // 83: astore 4
      // 85: return
      // 86: aload 0
      // 87: aload 1
      // 88: invokespecial x/oca9cc61aada.z$3ktkzjg2sjswq (Lcom/google/gson/JsonObject;)V
      // 8b: return
   }
}

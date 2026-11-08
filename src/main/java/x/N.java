package x;

import com.google.gson.JsonObject;

public abstract class N {
   public String ϻ;
   public boolean Ӏ = true;
   public static boolean Ҕ;

   public N(String var1) {
      this.ϻ = var1;
   }

   public void ȉ(boolean param1, oc69da1aa7f5 param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 3
      // 02: iload 1
      // 03: aload 0
      // 04: getfield x/N.Ӏ Z
      // 07: if_icmpne 0c
      // 0a: return
      // 0b: athrow
      // 0c: aload 0
      // 0d: iload 1
      // 0e: putfield x/N.Ӏ Z
      // 11: iload 3
      // 12: ifne 27
      // 15: getstatic x/oc2cf3d80e17.V Lx/oc2c25634a7e;
      // 18: ifnull 35
      // 1b: goto 1f
      // 1e: athrow
      // 1f: getstatic x/oc2cf3d80e17.V Lx/oc2c25634a7e;
      // 22: pop
      // 23: goto 27
      // 26: athrow
      // 27: iload 3
      // 28: ifne 3b
      // 2b: getstatic x/oc2c25634a7e.ʴ Ljava/util/ArrayList;
      // 2e: ifnonnull 37
      // 31: goto 35
      // 34: athrow
      // 35: return
      // 36: athrow
      // 37: getstatic x/oc2cf3d80e17.V Lx/oc2c25634a7e;
      // 3a: pop
      // 3b: getstatic x/oc2c25634a7e.ʴ Ljava/util/ArrayList;
      // 3e: invokevirtual java/util/ArrayList.iterator ()Ljava/util/Iterator;
      // 41: astore 4
      // 43: aload 4
      // 45: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 4a: ifeq ca
      // 4d: aload 4
      // 4f: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 54: checkcast x/oc192c7e4083
      // 57: astore 5
      // 59: aload 5
      // 5b: iload 3
      // 5c: ifne 73
      // 5f: getfield x/oc192c7e4083.ȩ Lx/oce4cea752dd;
      // 62: aload 2
      // 63: invokevirtual x/oc69da1aa7f5.ъ ()Lx/oce4cea752dd;
      // 66: if_acmpne c6
      // 69: goto 6d
      // 6c: athrow
      // 6d: aload 5
      // 6f: goto 73
      // 72: athrow
      // 73: getfield x/oc192c7e4083.ŝ Ljava/util/List;
      // 76: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 7b: astore 6
      // 7d: aload 6
      // 7f: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 84: ifeq c6
      // 87: aload 6
      // 89: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 8e: checkcast x/ocebe35f25d6
      // 91: astore 7
      // 93: iload 3
      // 94: ifne ba
      // 97: iload 3
      // 98: ifne 43
      // 9b: goto 9f
      // 9e: athrow
      // 9f: aload 7
      // a1: getfield x/ocebe35f25d6.ԣ Lx/oc69da1aa7f5;
      // a4: invokevirtual x/oc69da1aa7f5.z$3i8m9vxwuvqj0 ()Ljava/lang/String;
      // a7: aload 2
      // a8: invokevirtual x/oc69da1aa7f5.z$3i8m9vxwuvqj0 ()Ljava/lang/String;
      // ab: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // ae: ifeq be
      // b1: aload 7
      // b3: invokevirtual x/ocebe35f25d6.Қ ()V
      // b6: goto ba
      // b9: athrow
      // ba: iload 3
      // bb: ifeq c6
      // be: iload 3
      // bf: ifeq 7d
      // c2: goto c6
      // c5: athrow
      // c6: iload 3
      // c7: ifeq 43
      // ca: return
   }

   public String z$18nrktuqeiysv() {
      return this.ϻ;
   }

   public String z$3lm3x0je4b2zv() {
      return this.ϻ;
   }

   public abstract void z$3ktkzjg2sjswq(JsonObject var1);
}

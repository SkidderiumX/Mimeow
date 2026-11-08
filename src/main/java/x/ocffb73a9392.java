package x;

import java.util.List;
import java.util.Map;

public class ocffb73a9392 {
   public final String ϫ;
   public final String Ѳ;
   public final String â;
   public final String Ӡ;
   public final double Չ;
   public final int Ģ;
   public final String ʅ;
   public final String ͱ;
   public final List<String> ǟ;
   public final Map<Integer, Double> Ɣ;
   public static boolean ǉ;

   public ocffb73a9392(
      String var1, String var2, String var3, String var4, double var5, int var7, String var8, String var9, List<String> var10, Map<Integer, Double> var11
   ) {
      this.ϫ = var1;
      this.Ѳ = var2;
      this.â = var3;
      this.Ӡ = var4;
      this.Չ = var5;
      this.Ģ = var7;
      this.ʅ = var8;
      this.ͱ = var9;
      this.ǟ = var10;
      this.Ɣ = var11;
   }

   public double Θ(int param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc2c3b75cd91.F I
      // 03: dconst_0
      // 04: dstore 3
      // 05: aload 0
      // 06: getfield x/ocffb73a9392.Ɣ Ljava/util/Map;
      // 09: invokeinterface java/util/Map.entrySet ()Ljava/util/Set; 1
      // 0e: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 13: astore 5
      // 15: istore 2
      // 16: aload 5
      // 18: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 1d: ifeq 79
      // 20: aload 5
      // 22: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 27: checkcast java/util/Map$Entry
      // 2a: astore 6
      // 2c: iload 1
      // 2d: iload 2
      // 2e: ifne 60
      // 31: aload 6
      // 33: invokeinterface java/util/Map$Entry.getKey ()Ljava/lang/Object; 1
      // 38: checkcast java/lang/Integer
      // 3b: invokevirtual java/lang/Integer.intValue ()I
      // 3e: if_icmplt 75
      // 41: goto 45
      // 44: athrow
      // 45: aload 6
      // 47: invokeinterface java/util/Map$Entry.getValue ()Ljava/lang/Object; 1
      // 4c: checkcast java/lang/Double
      // 4f: iload 2
      // 50: ifne 71
      // 53: goto 57
      // 56: athrow
      // 57: invokevirtual java/lang/Double.doubleValue ()D
      // 5a: dload 3
      // 5b: dcmpl
      // 5c: goto 60
      // 5f: athrow
      // 60: ifle 75
      // 63: aload 6
      // 65: invokeinterface java/util/Map$Entry.getValue ()Ljava/lang/Object; 1
      // 6a: checkcast java/lang/Double
      // 6d: goto 71
      // 70: athrow
      // 71: invokevirtual java/lang/Double.doubleValue ()D
      // 74: dstore 3
      // 75: iload 2
      // 76: ifeq 16
      // 79: dload 3
      // 7a: dreturn
   }

   public double Ю(int var1) {
      return this.Չ * (1.0 - this.Θ(var1) / 100.0) * var1;
   }
}

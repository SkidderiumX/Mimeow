package x;

import com.google.gson.JsonObject;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class ocf1568fef75 extends N {
   private final double ӫ;
   private final double т;
   private final double ī;
   private final Random г = new Random();
   private String ȳ = "";
   private final String[] ɬ;
   private double Ǉ;
   private double ʈ;
   public occc831eff22 Е;
   public static boolean ʗ;

   public ocf1568fef75(String var1, double var2, double var4, double var6, double var8, double var10) {
      this(null, var1, "", var2, var4, var6, var8, var10);
   }

   public ocf1568fef75(String var1, String var2, double var3, double var5, double var7, double var9, double var11, String... var13) {
      this(null, var1, var2, var3, var5, var7, var9, var11, var13);
   }

   public ocf1568fef75(occc831eff22 var1, String var2, double var3, double var5, double var7, double var9, double var11) {
      this(var1, var2, "", var3, var5, var7, var9, var11);
   }

   public ocf1568fef75(occc831eff22 var1, String var2, String var3, double var4, double var6, double var8, double var10, double var12, String... var14) {
      super(var2);
      this.Е = var1;
      this.ȳ = var3 != null ? var3 : "";
      this.ӫ = var4;
      this.т = var6;
      this.ī = var12;
      this.Ǉ = this.Î(var8);
      this.ʈ = Math.max(this.Ǉ, this.Î(var10));
      this.ɬ = var14 != null ? var14 : new String[0];
   }

   public String М() {
      return this.ȳ;
   }

   public double ö() {
      return this.Ǉ;
   }

   public double і() {
      return this.ʈ;
   }

   public double θ() {
      return this.ӫ;
   }

   public double ɶ() {
      return this.т;
   }

   public double ԥ() {
      return this.ī;
   }

   public void ǹ(double var1) {
      this.Ǉ = Math.min(this.ʈ, this.Î(var1));
   }

   public void з(double var1) {
      this.ʈ = Math.max(this.Ǉ, this.Î(var1));
   }

   public double ϐ() {
      return this.Ǉ + this.г.nextDouble() * (this.ʈ - this.Ǉ);
   }

   public JsonObject Ղ() {
      JsonObject var1 = new JsonObject();
      var1.addProperty("min", this.Ǉ);
      var1.addProperty("max", this.ʈ);
      return var1;
   }

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
      // 09: getfield x/ocf1568fef75.Е Lx/occc831eff22;
      // 0c: ifnonnull 1b
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: invokevirtual x/N.z$18nrktuqeiysv ()Ljava/lang/String;
      // 17: goto 2b
      // 1a: athrow
      // 1b: aload 0
      // 1c: getfield x/ocf1568fef75.Е Lx/occc831eff22;
      // 1f: invokevirtual x/N.z$18nrktuqeiysv ()Ljava/lang/String;
      // 22: aload 0
      // 23: invokevirtual x/N.z$18nrktuqeiysv ()Ljava/lang/String;
      // 26: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001.\u0001" ]
      // 2b: areturn
   }

   public void z$3ktkzjg2sjswq(JsonObject param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: getstatic x/oca9cc61aada.Ƿ I
      // 003: istore 2
      // 004: aload 1
      // 005: iload 2
      // 006: ifne 012
      // 009: ifnonnull 011
      // 00c: goto 010
      // 00f: athrow
      // 010: return
      // 011: aload 1
      // 012: iload 2
      // 013: ifne 02d
      // 016: aload 0
      // 017: invokevirtual x/ocf1568fef75.z$3lm3x0je4b2zv ()Ljava/lang/String;
      // 01a: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 01d: ifeq 02c
      // 020: goto 024
      // 023: athrow
      // 024: aload 0
      // 025: invokevirtual x/ocf1568fef75.z$3lm3x0je4b2zv ()Ljava/lang/String;
      // 028: goto 040
      // 02b: athrow
      // 02c: aload 1
      // 02d: aload 0
      // 02e: invokevirtual x/N.z$18nrktuqeiysv ()Ljava/lang/String;
      // 031: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 034: ifeq 03f
      // 037: aload 0
      // 038: invokevirtual x/N.z$18nrktuqeiysv ()Ljava/lang/String;
      // 03b: goto 040
      // 03e: athrow
      // 03f: aconst_null
      // 040: astore 3
      // 041: aload 3
      // 042: iload 2
      // 043: ifne 0a8
      // 046: ifnonnull 0a7
      // 049: goto 04d
      // 04c: athrow
      // 04d: aload 0
      // 04e: iload 2
      // 04f: ifne 065
      // 052: goto 056
      // 055: athrow
      // 056: getfield x/ocf1568fef75.ɬ [Ljava/lang/String;
      // 059: ifnull 0a7
      // 05c: goto 060
      // 05f: athrow
      // 060: aload 0
      // 061: goto 065
      // 064: athrow
      // 065: getfield x/ocf1568fef75.ɬ [Ljava/lang/String;
      // 068: astore 4
      // 06a: aload 4
      // 06c: arraylength
      // 06d: istore 5
      // 06f: bipush 0
      // 070: istore 6
      // 072: iload 6
      // 074: iload 5
      // 076: if_icmpge 0a7
      // 079: aload 4
      // 07b: iload 6
      // 07d: aaload
      // 07e: iload 2
      // 07f: ifne 0a8
      // 082: astore 7
      // 084: iload 2
      // 085: ifne 0a3
      // 088: aload 1
      // 089: aload 7
      // 08b: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 08e: ifeq 09c
      // 091: goto 095
      // 094: athrow
      // 095: aload 7
      // 097: astore 3
      // 098: iload 2
      // 099: ifeq 0a7
      // 09c: iinc 6 1
      // 09f: goto 0a3
      // 0a2: athrow
      // 0a3: iload 2
      // 0a4: ifeq 072
      // 0a7: aload 3
      // 0a8: ifnonnull 0ac
      // 0ab: return
      // 0ac: aload 1
      // 0ad: aload 3
      // 0ae: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 0b1: astore 4
      // 0b3: aload 4
      // 0b5: iload 2
      // 0b6: ifne 120
      // 0b9: invokevirtual com/google/gson/JsonElement.isJsonObject ()Z
      // 0bc: ifeq 11a
      // 0bf: goto 0c3
      // 0c2: athrow
      // 0c3: aload 4
      // 0c5: invokevirtual com/google/gson/JsonElement.getAsJsonObject ()Lcom/google/gson/JsonObject;
      // 0c8: astore 5
      // 0ca: aload 5
      // 0cc: ldc "min"
      // 0ce: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 0d1: ifeq 0e6
      // 0d4: aload 0
      // 0d5: aload 5
      // 0d7: ldc "min"
      // 0d9: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 0dc: invokevirtual com/google/gson/JsonElement.getAsDouble ()D
      // 0df: invokevirtual x/ocf1568fef75.Î (D)D
      // 0e2: goto 0ea
      // 0e5: athrow
      // 0e6: aload 0
      // 0e7: getfield x/ocf1568fef75.Ǉ D
      // 0ea: dstore 6
      // 0ec: aload 5
      // 0ee: ldc "max"
      // 0f0: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 0f3: ifeq 108
      // 0f6: aload 0
      // 0f7: aload 5
      // 0f9: ldc "max"
      // 0fb: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 0fe: invokevirtual com/google/gson/JsonElement.getAsDouble ()D
      // 101: invokevirtual x/ocf1568fef75.Î (D)D
      // 104: goto 10c
      // 107: athrow
      // 108: aload 0
      // 109: getfield x/ocf1568fef75.ʈ D
      // 10c: dstore 8
      // 10e: iload 2
      // 10f: aload 0
      // 110: dload 6
      // 112: dload 8
      // 114: invokevirtual x/ocf1568fef75.Ѭ (DD)V
      // 117: ifeq 187
      // 11a: aload 4
      // 11c: goto 120
      // 11f: athrow
      // 120: iload 2
      // 121: ifne 16e
      // 124: invokevirtual com/google/gson/JsonElement.isJsonArray ()Z
      // 127: ifeq 168
      // 12a: goto 12e
      // 12d: athrow
      // 12e: aload 4
      // 130: invokevirtual com/google/gson/JsonElement.getAsJsonArray ()Lcom/google/gson/JsonArray;
      // 133: astore 5
      // 135: aload 5
      // 137: invokevirtual com/google/gson/JsonArray.size ()I
      // 13a: ldc 929101413
      // 13c: ldc 929101415
      // 13e: ixor
      // 13f: if_icmplt 164
      // 142: aload 0
      // 143: aload 0
      // 144: aload 5
      // 146: bipush 0
      // 147: invokevirtual com/google/gson/JsonArray.get (I)Lcom/google/gson/JsonElement;
      // 14a: invokevirtual com/google/gson/JsonElement.getAsDouble ()D
      // 14d: invokevirtual x/ocf1568fef75.Î (D)D
      // 150: aload 0
      // 151: aload 5
      // 153: bipush 1
      // 154: invokevirtual com/google/gson/JsonArray.get (I)Lcom/google/gson/JsonElement;
      // 157: invokevirtual com/google/gson/JsonElement.getAsDouble ()D
      // 15a: invokevirtual x/ocf1568fef75.Î (D)D
      // 15d: invokevirtual x/ocf1568fef75.Ѭ (DD)V
      // 160: goto 164
      // 163: athrow
      // 164: iload 2
      // 165: ifeq 187
      // 168: aload 4
      // 16a: goto 16e
      // 16d: athrow
      // 16e: invokevirtual com/google/gson/JsonElement.isJsonPrimitive ()Z
      // 171: ifeq 187
      // 174: aload 0
      // 175: aload 4
      // 177: invokevirtual com/google/gson/JsonElement.getAsDouble ()D
      // 17a: invokevirtual x/ocf1568fef75.Î (D)D
      // 17d: dstore 5
      // 17f: aload 0
      // 180: dload 5
      // 182: dload 5
      // 184: invokevirtual x/ocf1568fef75.Ѭ (DD)V
      // 187: goto 18c
      // 18a: astore 5
      // 18c: return
   }

   private double Î(double var1) {
      double var3 = Math.max(this.ӫ, Math.min(this.т, var1));
      double var5 = Math.round(var3 / this.ī) * this.ī;
      return new BigDecimal(var5).setScale(-893352145 ^ -893352153, RoundingMode.HALF_UP).stripTrailingZeros().doubleValue();
   }

   public void Ѭ(double var1, double var3) {
      this.Ǉ = Math.min(var1, var3);
      this.ʈ = Math.max(var1, var3);
   }
}

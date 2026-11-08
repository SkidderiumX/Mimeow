package x;

import com.google.gson.JsonObject;
import java.awt.Color;

public class oc24a0a5bddf extends N {
   private int ϗ;
   private int ԑ;
   private int ʎ;
   private int ț;
   private final boolean Ϸ;
   private String[] Ƈ = new String[0];
   public occc831eff22 a;
   public static int ւ;

   public oc24a0a5bddf(String var1, int var2, int var3, int var4) {
      this(null, var1, var2, var3, var4, 42250197 ^ 42250026, false);
   }

   public oc24a0a5bddf(String var1, int var2, int var3, int var4, String... var5) {
      this(var1, var2, var3, var4);
      this.Ƈ = var5 != null ? var5 : new String[0];
   }

   public oc24a0a5bddf(String var1, int var2, int var3, int var4, int var5) {
      this(null, var1, var2, var3, var4, var5, true);
   }

   public oc24a0a5bddf(occc831eff22 var1, String var2, int var3, int var4, int var5) {
      this(var1, var2, var3, var4, var5, -1063703864 ^ -1063704009, false);
   }

   public oc24a0a5bddf(occc831eff22 var1, String var2, int var3, int var4, int var5, int var6) {
      this(var1, var2, var3, var4, var5, var6, true);
   }

   public oc24a0a5bddf(occc831eff22 var1, String var2, int var3, int var4, int var5, int var6, boolean var7) {
      super(var2);
      this.a = var1;
      this.ϗ = ԍ(var3);
      this.ԑ = ԍ(var4);
      this.ʎ = ԍ(var5);
      this.ț = ԍ(var6);
      this.Ϸ = var7;
   }

   public int ˀ() {
      return this.ϗ;
   }

   public int z() {
      return this.ԑ;
   }

   public int ц() {
      return this.ʎ;
   }

   public int Ǣ() {
      return this.ț;
   }

   public void Ԙ(int var1) {
      this.ț = ԍ(var1);
   }

   public void ӂ(int var1, int var2, int var3) {
      this.ϗ = ԍ(var1);
      this.ԑ = ԍ(var2);
      this.ʎ = ԍ(var3);
   }

   public void ƾ(int var1, int var2, int var3, int var4) {
      this.ӂ(var1, var2, var3);
      this.ț = ԍ(var4);
   }

   public int ͳ() {
      return this.ț << (1337155380 ^ 1337155372) | this.ϗ << (1337155388 ^ 1337155372) | this.ԑ << (1337155364 ^ 1337155372) | this.ʎ;
   }

   public int ǐ() {
      return this.ϗ << (388452343 ^ 388452327) | this.ԑ << (388452335 ^ 388452327) | this.ʎ;
   }

   public float А() {
      float[] var1 = Color.RGBtoHSB(this.ϗ, this.ԑ, this.ʎ, null);
      return var1[0] * 360.0F;
   }

   public float ї() {
      float[] var1 = Color.RGBtoHSB(this.ϗ, this.ԑ, this.ʎ, null);
      return var1[1];
   }

   public float Բ() {
      float[] var1 = Color.RGBtoHSB(this.ϗ, this.ԑ, this.ʎ, null);
      return var1[-438875724 ^ -438875722];
   }

   public void ȅ(float var1, float var2, float var3) {
      int var5 = Color.HSBtoRGB(var1 / 360.0F, Math.max(0.0F, Math.min(1.0F, var2)), Math.max(0.0F, Math.min(1.0F, var3)));
      int var10000 = oca9cc61aada.Ƿ;
      this.ϗ = var5 >> (196702963 ^ 196702947) & (196702748 ^ 196702947);
      this.ԑ = var5 >> (196702955 ^ 196702947) & (196702748 ^ 196702947);
      int var4 = var10000;

      try {
         this.ʎ = var5 & (196702748 ^ 196702947);
         if (false) {
            oca9cc61aada.Ƿ = ++var4;
         }
      } catch (ocbde1165e4e var6) {
         throw var6;
      }
   }

   public void ɦ(float var1) {
      float[] var2 = Color.RGBtoHSB(this.ϗ, this.ԑ, this.ʎ, null);
      this.ȅ(var1, var2[1], var2[-2073102229 ^ -2073102231]);
   }

   public void ӊ(float var1) {
      float[] var2 = Color.RGBtoHSB(this.ϗ, this.ԑ, this.ʎ, null);
      this.ȅ(var2[0] * 360.0F, var1, var2[-110494275 ^ -110494273]);
   }

   public void N(float var1) {
      float[] var2 = Color.RGBtoHSB(this.ϗ, this.ԑ, this.ʎ, null);
      this.ȅ(var2[0] * 360.0F, var2[1], var1);
   }

   public boolean ũ() {
      return this.Ϸ;
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
      // 09: getfield x/oc24a0a5bddf.a Lx/occc831eff22;
      // 0c: ifnonnull 1b
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: invokevirtual x/N.z$18nrktuqeiysv ()Ljava/lang/String;
      // 17: goto 2b
      // 1a: athrow
      // 1b: aload 0
      // 1c: getfield x/oc24a0a5bddf.a Lx/occc831eff22;
      // 1f: invokevirtual x/N.z$18nrktuqeiysv ()Ljava/lang/String;
      // 22: aload 0
      // 23: invokevirtual x/N.z$18nrktuqeiysv ()Ljava/lang/String;
      // 26: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001.\u0001" ]
      // 2b: areturn
   }

   public void z$3ktkzjg2sjswq(JsonObject param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oca9cc61aada.Ƿ I
      // 003: aload 0
      // 004: invokevirtual x/oc24a0a5bddf.z$3lm3x0je4b2zv ()Ljava/lang/String;
      // 007: astore 3
      // 008: aload 0
      // 009: invokevirtual x/N.z$18nrktuqeiysv ()Ljava/lang/String;
      // 00c: astore 4
      // 00e: istore 2
      // 00f: aconst_null
      // 010: astore 5
      // 012: aload 1
      // 013: iload 2
      // 014: ifne 029
      // 017: aload 3
      // 018: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 01b: ifeq 028
      // 01e: goto 022
      // 021: athrow
      // 022: aload 3
      // 023: astore 5
      // 025: goto 072
      // 028: aload 1
      // 029: aload 4
      // 02b: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 02e: ifeq 038
      // 031: aload 4
      // 033: astore 5
      // 035: goto 072
      // 038: aload 0
      // 039: getfield x/oc24a0a5bddf.Ƈ [Ljava/lang/String;
      // 03c: astore 6
      // 03e: aload 6
      // 040: arraylength
      // 041: istore 7
      // 043: bipush 0
      // 044: istore 8
      // 046: iload 8
      // 048: iload 7
      // 04a: if_icmpge 072
      // 04d: aload 6
      // 04f: iload 8
      // 051: aaload
      // 052: astore 9
      // 054: iload 2
      // 055: ifne 06f
      // 058: aload 1
      // 059: aload 9
      // 05b: invokevirtual com/google/gson/JsonObject.has (Ljava/lang/String;)Z
      // 05e: ifeq 06c
      // 061: goto 065
      // 064: athrow
      // 065: aload 9
      // 067: astore 5
      // 069: goto 072
      // 06c: iinc 8 1
      // 06f: goto 046
      // 072: aload 5
      // 074: ifnull 122
      // 077: aload 1
      // 078: iload 2
      // 079: ifne 090
      // 07c: goto 080
      // 07f: athrow
      // 080: aload 5
      // 082: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 085: invokevirtual com/google/gson/JsonElement.isJsonPrimitive ()Z
      // 088: ifeq 122
      // 08b: goto 08f
      // 08e: athrow
      // 08f: aload 1
      // 090: aload 5
      // 092: invokevirtual com/google/gson/JsonObject.getAsJsonPrimitive (Ljava/lang/String;)Lcom/google/gson/JsonPrimitive;
      // 095: invokevirtual com/google/gson/JsonPrimitive.getAsString ()Ljava/lang/String;
      // 098: astore 6
      // 09a: iload 2
      // 09b: aload 6
      // 09d: ldc ","
      // 09f: invokevirtual java/lang/String.split (Ljava/lang/String;)[Ljava/lang/String;
      // 0a2: astore 7
      // 0a4: ifne 0f9
      // 0a7: aload 7
      // 0a9: arraylength
      // 0aa: ldc 1814582880
      // 0ac: ldc 1814582883
      // 0ae: ixor
      // 0af: if_icmplt 11d
      // 0b2: goto 0b6
      // 0b5: athrow
      // 0b6: aload 0
      // 0b7: aload 7
      // 0b9: bipush 0
      // 0ba: aaload
      // 0bb: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 0be: invokestatic java/lang/Integer.parseInt (Ljava/lang/String;)I
      // 0c1: invokestatic x/oc24a0a5bddf.ԍ (I)I
      // 0c4: putfield x/oc24a0a5bddf.ϗ I
      // 0c7: aload 0
      // 0c8: aload 7
      // 0ca: bipush 1
      // 0cb: aaload
      // 0cc: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 0cf: invokestatic java/lang/Integer.parseInt (Ljava/lang/String;)I
      // 0d2: invokestatic x/oc24a0a5bddf.ԍ (I)I
      // 0d5: putfield x/oc24a0a5bddf.ԑ I
      // 0d8: aload 0
      // 0d9: aload 7
      // 0db: ldc 1814582881
      // 0dd: ldc 1814582883
      // 0df: ixor
      // 0e0: aaload
      // 0e1: iload 2
      // 0e2: ifne 114
      // 0e5: goto 0e9
      // 0e8: athrow
      // 0e9: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 0ec: invokestatic java/lang/Integer.parseInt (Ljava/lang/String;)I
      // 0ef: invokestatic x/oc24a0a5bddf.ԍ (I)I
      // 0f2: putfield x/oc24a0a5bddf.ʎ I
      // 0f5: goto 0f9
      // 0f8: athrow
      // 0f9: aload 7
      // 0fb: arraylength
      // 0fc: ldc 1814582887
      // 0fe: ldc 1814582883
      // 100: ixor
      // 101: if_icmplt 11d
      // 104: aload 0
      // 105: aload 7
      // 107: ldc 1814582880
      // 109: ldc 1814582883
      // 10b: ixor
      // 10c: aaload
      // 10d: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 110: goto 114
      // 113: athrow
      // 114: invokestatic java/lang/Integer.parseInt (Ljava/lang/String;)I
      // 117: invokestatic x/oc24a0a5bddf.ԍ (I)I
      // 11a: putfield x/oc24a0a5bddf.ț I
      // 11d: goto 122
      // 120: astore 6
      // 122: return
   }

   private static int ԍ(int var0) {
      return Math.max(0, Math.min(1387496380 ^ 1387496259, var0));
   }
}

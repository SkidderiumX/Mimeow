package x;

import java.awt.Color;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.StringUtils;

public class ocd2958dac48 extends oc69da1aa7f5 {
   private static final String[] ҷ;
   public static oca9cc61aada Ć;
   private static oc93499ec6de Ѡ;
   private final oc67aa5109f0 Џ;
   private final ocd77007f9e2 H;
   private boolean җ;
   private static final String[] ƚ;
   private static final double Ȣ = 600.0;
   private static final double Đ = 0.06;
   public static oca9cc61aada ƺ;
   public static oca9cc61aada Ě;
   public static oc24a0a5bddf у;
   public static oc24a0a5bddf ь;
   public static oca9cc61aada ӯ;
   public static oca9cc61aada Ѭ;
   private static oca9cc61aada ƌ;
   public final occ2f8dff8d8 Ķ = new occ2f8dff8d8("ArrayList", true);
   public final occ2f8dff8d8 Ѻ = new occ2f8dff8d8("Potion HUD", true);
   private final oc6b01c6afd6 Ƌ = new oc6b01c6afd6();
   private final occc831eff22 ʛ = new occc831eff22("Potion settings");
   private static occ2f8dff8d8 ӣ;
   private static occ2f8dff8d8 Ƭ;
   private static occ2f8dff8d8 Л;
   public static occ2f8dff8d8 ɝ;
   private static final float Ѐ = 5.0F;
   private static final float ѿ = 70.0F;
   public static float Ƃ = 5.0F;
   public static float ș = 70.0F;
   private static float Ƶ = Float.NaN;
   private static float l = Float.NaN;
   public static boolean Ҏ = false;
   public static float Π = 0.0F;
   public static float Ї = 0.0F;
   public static double բ = 0.0;
   public static double ȸ = 0.0;
   private static final String ǉ = "ProductSans";
   private static final String[] ì = oc3ebac73392.ͺ();
   private static final oc5e96231df6[] Ř = Ќ();
   private static final String[] Ɨ = ҋ();
   private boolean Н;
   private String ɭ = "";
   private float ʚ = -1.0F;
   private final Map<oc69da1aa7f5, ocfd3776543a> ά = new IdentityHashMap<>();
   public static boolean Ҵ;

   public ocd2958dac48() {
      super("HUD", oce4cea752dd.Ŏ);
      this.ą("Customize the module list and appearance of client HUDs.");
      String[] var10005 = new String[-1291804542 ^ -1291804543];
      var10005[0] = "Legacy";
      var10005[1] = "Modern";
      var10005[-1291804541 ^ -1291804543] = "Slinky";
      this.ʌ(Ć = new oca9cc61aada("Mode", 1, var10005));
      this.ʌ(this.Ķ);
      ƺ = new oca9cc61aada("Render mode", 0, ҷ, "Color mode");
      Ě = new oca9cc61aada("Color", 0, Ɨ, "Theme");
      у = new oc24a0a5bddf("Primary color", -1291804546 ^ -1291804543, -1291804546 ^ -1291804543, -1291804546 ^ -1291804543, "Color");
      ь = new oc24a0a5bddf("Secondary color", -1291804460 ^ -1291804543, -1291804460 ^ -1291804543, -1291804546 ^ -1291804543, "Color 2");
      ӯ = new oca9cc61aada("Font", Arrays.asList(ì).indexOf("ProductSans"), ì);
      Ѭ = new oca9cc61aada("Scale", 1.0, 0.5, 2.0, 0.01);
      ƌ = new oca9cc61aada("Animation", -1291804541 ^ -1291804543, ƚ);
      Ƭ = new occ2f8dff8d8("Align right", false);
      ӣ = new occ2f8dff8d8("Text shadow", true);
      Л = new occ2f8dff8d8("Lowercase", false);
      ɝ = new occ2f8dff8d8("Show module info", true);
      Ѡ = new oc93499ec6de();
      this.Џ = new oc67aa5109f0(Ѡ);

      for (Entry var2 : Ѡ.ϭ.entrySet()) {
         N var3 = (N)var2.getValue();
         this.z$1k81rl22ylo65(var3, "setting.modern." + (String)var2.getKey());
         if (var3 == Ѡ.ƴ) {
            this.ǯ(ƺ, Ѡ.ƴ);
            this.ǯ(Ě, Ѡ.ƴ);
            this.ǯ(у, Ѡ.ƴ);
            this.ǯ(ь, Ѡ.ƴ);
         } else if (var3 == Ѡ.Ԍ) {
            this.ǯ(Ƭ, Ѡ.Ԍ);
         } else if (var3 == Ѡ.Ȣ) {
            this.ǯ(ƌ, Ѡ.Ȣ);
         } else if (var3 == Ѡ.ϓ) {
            this.ǯ(ӯ, Ѡ.ϓ);
            this.ǯ(Ѭ, Ѡ.ϓ);
            this.ǯ(Л, Ѡ.ϓ);
            this.ǯ(ӣ, Ѡ.ϓ);
         } else if (var3 == Ѡ.p) {
            this.ǯ(ɝ, Ѡ.p);
         }
      }

      this.ʌ(this.ʛ);
      this.ǯ(this.Ѻ, this.ʛ);

      for (N var5 : this.Ƌ.ɠ()) {
         oc93499ec6de.Ҭ(var5, this.ʛ);
         this.Î(var5);
      }

      this.H = new ocd77007f9e2(this);
      this.z$2u87utkr1isxg();
   }

   void ϩ(N var1, String var2) {
      this.z$1k81rl22ylo65(var1, "setting.overlay." + var2);
   }

   private void ǯ(N var1, occc831eff22 var2) {
      oc93499ec6de.Ҭ(var1, var2);
      this.ʌ(var1);
   }

   private void Î(N var1) {
      this.z$1k81rl22ylo65(var1, this.ԣ(var1.z$18nrktuqeiysv()));
   }

   private String ԣ(String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: aload 1
      // 004: astore 3
      // 005: istore 2
      // 006: bipush -1
      // 007: istore 4
      // 009: aload 3
      // 00a: invokevirtual java/lang/String.hashCode ()I
      // 00d: iload 2
      // 00e: ifne 0e6
      // 011: lookupswitch 211 5 -1876518126 145 -1721453412 110 -1557430225 180 1894283676 52 2019842637 81
      // 044: athrow
      // 045: aload 3
      // 046: ldc_w "Potion Lower case"
      // 049: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 04c: iload 2
      // 04d: ifne 0e6
      // 050: goto 054
      // 053: athrow
      // 054: ifeq 0e4
      // 057: goto 05b
      // 05a: athrow
      // 05b: bipush 0
      // 05c: istore 4
      // 05e: iload 2
      // 05f: ifeq 0e4
      // 062: aload 3
      // 063: ldc_w "Potion Icons"
      // 066: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 069: iload 2
      // 06a: ifne 0e6
      // 06d: goto 071
      // 070: athrow
      // 071: ifeq 0e4
      // 074: goto 078
      // 077: athrow
      // 078: bipush 1
      // 079: istore 4
      // 07b: iload 2
      // 07c: ifeq 0e4
      // 07f: aload 3
      // 080: ldc_w "Potion Levels"
      // 083: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 086: iload 2
      // 087: ifne 0e6
      // 08a: goto 08e
      // 08d: athrow
      // 08e: ifeq 0e4
      // 091: goto 095
      // 094: athrow
      // 095: ldc_w -126309604
      // 098: ldc_w -126309602
      // 09b: ixor
      // 09c: istore 4
      // 09e: iload 2
      // 09f: ifeq 0e4
      // 0a2: aload 3
      // 0a3: ldc_w "Potion Durations"
      // 0a6: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0a9: iload 2
      // 0aa: ifne 0e6
      // 0ad: goto 0b1
      // 0b0: athrow
      // 0b1: ifeq 0e4
      // 0b4: goto 0b8
      // 0b7: athrow
      // 0b8: ldc_w -126309603
      // 0bb: ldc_w -126309602
      // 0be: ixor
      // 0bf: istore 4
      // 0c1: iload 2
      // 0c2: ifeq 0e4
      // 0c5: aload 3
      // 0c6: ldc_w "Potion Hide long effects"
      // 0c9: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0cc: iload 2
      // 0cd: ifne 0e6
      // 0d0: goto 0d4
      // 0d3: athrow
      // 0d4: ifeq 0e4
      // 0d7: goto 0db
      // 0da: athrow
      // 0db: ldc_w -126309606
      // 0de: ldc_w -126309602
      // 0e1: ixor
      // 0e2: istore 4
      // 0e4: iload 4
      // 0e6: tableswitch 55 0 4 34 39 43 47 51
      // 108: ldc_w "setting.045"
      // 10b: areturn
      // 10c: athrow
      // 10d: ldc_w "setting.potion.icons"
      // 110: areturn
      // 111: ldc_w "setting.potion.levels"
      // 114: areturn
      // 115: ldc_w "setting.potion.durations"
      // 118: areturn
      // 119: ldc_w "setting.potion.hideLongEffects"
      // 11c: areturn
      // 11d: new java/lang/IllegalArgumentException
      // 120: dup
      // 121: aload 1
      // 122: ldc_w "Unknown embedded HUD setting: "
      // 125: swap
      // 126: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 12b: invokespecial java/lang/IllegalArgumentException.<init> (Ljava/lang/String;)V
      // 12e: athrow
   }

   @Override
   public void z$2u87utkr1isxg() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: invokestatic x/ocd2958dac48.Ǫ ()Z
      // 003: istore 2
      // 004: ldc_w 1982210171
      // 007: ldc_w 1982210173
      // 00a: ixor
      // 00b: anewarray 297
      // 00e: dup
      // 00f: bipush 0
      // 010: getstatic x/ocd2958dac48.ӯ Lx/oca9cc61aada;
      // 013: aastore
      // 014: dup
      // 015: bipush 1
      // 016: getstatic x/ocd2958dac48.Ѭ Lx/oca9cc61aada;
      // 019: aastore
      // 01a: dup
      // 01b: ldc_w 1982210175
      // 01e: ldc_w 1982210173
      // 021: ixor
      // 022: getstatic x/ocd2958dac48.ƌ Lx/oca9cc61aada;
      // 025: aastore
      // 026: dup
      // 027: ldc_w 1982210174
      // 02a: ldc_w 1982210173
      // 02d: ixor
      // 02e: getstatic x/ocd2958dac48.ӣ Lx/occ2f8dff8d8;
      // 031: aastore
      // 032: dup
      // 033: ldc_w 1982210169
      // 036: ldc_w 1982210173
      // 039: ixor
      // 03a: getstatic x/ocd2958dac48.Л Lx/occ2f8dff8d8;
      // 03d: aastore
      // 03e: dup
      // 03f: ldc_w 1982210168
      // 042: ldc_w 1982210173
      // 045: ixor
      // 046: getstatic x/ocd2958dac48.ɝ Lx/occ2f8dff8d8;
      // 049: aastore
      // 04a: astore 3
      // 04b: getstatic x/oce6044968f8.ђ Z
      // 04e: aload 3
      // 04f: arraylength
      // 050: istore 4
      // 052: bipush 0
      // 053: istore 5
      // 055: istore 1
      // 056: iload 5
      // 058: iload 4
      // 05a: if_icmpge 09c
      // 05d: aload 3
      // 05e: iload 5
      // 060: aaload
      // 061: astore 6
      // 063: iload 1
      // 064: ifne 0bc
      // 067: iload 1
      // 068: ifne 098
      // 06b: goto 06f
      // 06e: athrow
      // 06f: aload 6
      // 071: ifnull 095
      // 074: goto 078
      // 077: athrow
      // 078: aload 6
      // 07a: invokestatic x/ocd2958dac48.Է ()Z
      // 07d: iload 1
      // 07e: ifne 08d
      // 081: goto 085
      // 084: athrow
      // 085: ifne 090
      // 088: goto 08c
      // 08b: athrow
      // 08c: bipush 1
      // 08d: goto 091
      // 090: bipush 0
      // 091: aload 0
      // 092: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 095: iinc 5 1
      // 098: iload 1
      // 099: ifeq 056
      // 09c: getstatic x/ocd2958dac48.Ě Lx/oca9cc61aada;
      // 09f: iload 1
      // 0a0: ifne 0ad
      // 0a3: ifnull 0bc
      // 0a6: goto 0aa
      // 0a9: athrow
      // 0aa: getstatic x/ocd2958dac48.Ě Lx/oca9cc61aada;
      // 0ad: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0b0: d2i
      // 0b1: iload 1
      // 0b2: ifne 0bd
      // 0b5: ifne 0c0
      // 0b8: goto 0bc
      // 0bb: athrow
      // 0bc: bipush 1
      // 0bd: goto 0c1
      // 0c0: bipush 0
      // 0c1: istore 3
      // 0c2: getstatic x/ocd2958dac48.ƺ Lx/oca9cc61aada;
      // 0c5: iload 1
      // 0c6: ifne 0d8
      // 0c9: ifnonnull 0d5
      // 0cc: goto 0d0
      // 0cf: athrow
      // 0d0: bipush 0
      // 0d1: goto 0dc
      // 0d4: athrow
      // 0d5: getstatic x/ocd2958dac48.ƺ Lx/oca9cc61aada;
      // 0d8: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0db: d2i
      // 0dc: istore 4
      // 0de: getstatic x/ocd2958dac48.ƺ Lx/oca9cc61aada;
      // 0e1: iload 1
      // 0e2: ifne 0fb
      // 0e5: ifnull 0f8
      // 0e8: goto 0ec
      // 0eb: athrow
      // 0ec: getstatic x/ocd2958dac48.ƺ Lx/oca9cc61aada;
      // 0ef: bipush 1
      // 0f0: aload 0
      // 0f1: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0f4: goto 0f8
      // 0f7: athrow
      // 0f8: getstatic x/ocd2958dac48.Ě Lx/oca9cc61aada;
      // 0fb: iload 1
      // 0fc: ifne 109
      // 0ff: ifnull 12a
      // 102: goto 106
      // 105: athrow
      // 106: getstatic x/ocd2958dac48.Ě Lx/oca9cc61aada;
      // 109: iload 4
      // 10b: iload 1
      // 10c: ifne 122
      // 10f: ldc_w 1982210175
      // 112: ldc_w 1982210173
      // 115: ixor
      // 116: if_icmpeq 125
      // 119: goto 11d
      // 11c: athrow
      // 11d: bipush 1
      // 11e: goto 122
      // 121: athrow
      // 122: goto 126
      // 125: bipush 0
      // 126: aload 0
      // 127: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 12a: getstatic x/ocd2958dac48.у Lx/oc24a0a5bddf;
      // 12d: iload 1
      // 12e: ifne 16f
      // 131: ifnull 16c
      // 134: goto 138
      // 137: athrow
      // 138: getstatic x/ocd2958dac48.у Lx/oc24a0a5bddf;
      // 13b: iload 3
      // 13c: iload 1
      // 13d: ifne 14d
      // 140: goto 144
      // 143: athrow
      // 144: ifeq 167
      // 147: goto 14b
      // 14a: athrow
      // 14b: iload 4
      // 14d: iload 1
      // 14e: ifne 164
      // 151: ldc_w 1982210175
      // 154: ldc_w 1982210173
      // 157: ixor
      // 158: if_icmpeq 167
      // 15b: goto 15f
      // 15e: athrow
      // 15f: bipush 1
      // 160: goto 164
      // 163: athrow
      // 164: goto 168
      // 167: bipush 0
      // 168: aload 0
      // 169: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 16c: getstatic x/ocd2958dac48.ь Lx/oc24a0a5bddf;
      // 16f: iload 1
      // 170: ifne 17d
      // 173: ifnull 1a4
      // 176: goto 17a
      // 179: athrow
      // 17a: getstatic x/ocd2958dac48.ь Lx/oc24a0a5bddf;
      // 17d: iload 3
      // 17e: iload 1
      // 17f: ifne 18b
      // 182: ifeq 19f
      // 185: goto 189
      // 188: athrow
      // 189: iload 4
      // 18b: iload 1
      // 18c: ifne 19c
      // 18f: bipush 1
      // 190: if_icmpne 19f
      // 193: goto 197
      // 196: athrow
      // 197: bipush 1
      // 198: goto 19c
      // 19b: athrow
      // 19c: goto 1a0
      // 19f: bipush 0
      // 1a0: aload 0
      // 1a1: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 1a4: getstatic x/ocd2958dac48.Ƭ Lx/occ2f8dff8d8;
      // 1a7: iload 1
      // 1a8: ifne 1b5
      // 1ab: ifnull 1ca
      // 1ae: goto 1b2
      // 1b1: athrow
      // 1b2: getstatic x/ocd2958dac48.Ƭ Lx/occ2f8dff8d8;
      // 1b5: iload 2
      // 1b6: iload 1
      // 1b7: ifne 1c2
      // 1ba: ifne 1c5
      // 1bd: goto 1c1
      // 1c0: athrow
      // 1c1: bipush 1
      // 1c2: goto 1c6
      // 1c5: bipush 0
      // 1c6: aload 0
      // 1c7: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 1ca: aload 0
      // 1cb: getfield x/ocd2958dac48.Ƌ Lx/oc6b01c6afd6;
      // 1ce: invokevirtual x/oc69da1aa7f5.ɠ ()Ljava/util/ArrayList;
      // 1d1: invokevirtual java/util/ArrayList.iterator ()Ljava/util/Iterator;
      // 1d4: astore 5
      // 1d6: aload 5
      // 1d8: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 1dd: ifeq 201
      // 1e0: aload 5
      // 1e2: iload 1
      // 1e3: ifne 26c
      // 1e6: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 1eb: checkcast x/N
      // 1ee: astore 6
      // 1f0: iload 1
      // 1f1: aload 6
      // 1f3: aload 0
      // 1f4: getfield x/ocd2958dac48.Ѻ Lx/occ2f8dff8d8;
      // 1f7: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 1fa: aload 0
      // 1fb: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 1fe: ifeq 1d6
      // 201: getstatic x/ocd2958dac48.Ѡ Lx/oc93499ec6de;
      // 204: iload 1
      // 205: ifne 212
      // 208: ifnull 250
      // 20b: goto 20f
      // 20e: athrow
      // 20f: getstatic x/ocd2958dac48.Ѡ Lx/oc93499ec6de;
      // 212: aload 0
      // 213: iload 2
      // 214: iload 4
      // 216: getstatic x/ocd2958dac48.ɝ Lx/occ2f8dff8d8;
      // 219: iload 1
      // 21a: ifne 227
      // 21d: ifnull 239
      // 220: goto 224
      // 223: athrow
      // 224: getstatic x/ocd2958dac48.ɝ Lx/occ2f8dff8d8;
      // 227: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 22a: iload 1
      // 22b: ifne 236
      // 22e: ifeq 239
      // 231: goto 235
      // 234: athrow
      // 235: bipush 1
      // 236: goto 23a
      // 239: bipush 0
      // 23a: invokestatic x/ocd2958dac48.Ю ()Z
      // 23d: iload 1
      // 23e: ifne 249
      // 241: ifne 24c
      // 244: goto 248
      // 247: athrow
      // 248: bipush 1
      // 249: goto 24d
      // 24c: bipush 0
      // 24d: invokevirtual x/oc93499ec6de.ȇ (Lx/oc69da1aa7f5;ZIZZ)V
      // 250: aload 0
      // 251: getfield x/ocd2958dac48.H Lx/ocd77007f9e2;
      // 254: ifnull 2ff
      // 257: invokestatic x/ocd2958dac48.Է ()Z
      // 25a: ifeq 2f5
      // 25d: goto 261
      // 260: athrow
      // 261: aload 0
      // 262: invokevirtual x/oc69da1aa7f5.ɠ ()Ljava/util/ArrayList;
      // 265: invokevirtual java/util/ArrayList.iterator ()Ljava/util/Iterator;
      // 268: goto 26c
      // 26b: athrow
      // 26c: astore 5
      // 26e: aload 5
      // 270: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 275: ifeq 2f5
      // 278: aload 5
      // 27a: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 27f: checkcast x/N
      // 282: astore 6
      // 284: iload 1
      // 285: ifne 2ff
      // 288: aload 6
      // 28a: iload 1
      // 28b: ifne 2a2
      // 28e: goto 292
      // 291: athrow
      // 292: getstatic x/ocd2958dac48.Ć Lx/oca9cc61aada;
      // 295: if_acmpeq 2f1
      // 298: goto 29c
      // 29b: athrow
      // 29c: aload 6
      // 29e: goto 2a2
      // 2a1: athrow
      // 2a2: iload 1
      // 2a3: ifne 2b7
      // 2a6: aload 0
      // 2a7: getfield x/ocd2958dac48.Ķ Lx/occ2f8dff8d8;
      // 2aa: if_acmpeq 2f1
      // 2ad: goto 2b1
      // 2b0: athrow
      // 2b1: aload 6
      // 2b3: goto 2b7
      // 2b6: athrow
      // 2b7: iload 1
      // 2b8: ifne 2cc
      // 2bb: aload 0
      // 2bc: getfield x/ocd2958dac48.ʛ Lx/occc831eff22;
      // 2bf: if_acmpeq 2f1
      // 2c2: goto 2c6
      // 2c5: athrow
      // 2c6: aload 6
      // 2c8: goto 2cc
      // 2cb: athrow
      // 2cc: aload 0
      // 2cd: getfield x/ocd2958dac48.Ѻ Lx/occ2f8dff8d8;
      // 2d0: if_acmpeq 2f1
      // 2d3: aload 0
      // 2d4: getfield x/ocd2958dac48.Ƌ Lx/oc6b01c6afd6;
      // 2d7: invokevirtual x/oc69da1aa7f5.ɠ ()Ljava/util/ArrayList;
      // 2da: aload 6
      // 2dc: invokevirtual java/util/ArrayList.contains (Ljava/lang/Object;)Z
      // 2df: ifne 2f1
      // 2e2: goto 2e6
      // 2e5: athrow
      // 2e6: aload 6
      // 2e8: bipush 0
      // 2e9: aload 0
      // 2ea: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 2ed: goto 2f1
      // 2f0: athrow
      // 2f1: iload 1
      // 2f2: ifeq 26e
      // 2f5: aload 0
      // 2f6: getfield x/ocd2958dac48.H Lx/ocd77007f9e2;
      // 2f9: invokestatic x/ocd2958dac48.Է ()Z
      // 2fc: invokevirtual x/ocd77007f9e2.Ӗ (Z)V
      // 2ff: return
   }

   @oc66fa4f2195
   public void Х(oc2422fc1726 var1) {
      try {
         if (Է()) {
            this.H.ԅ(var1.ҁ(), var1.Ʋ());
         }
      } catch (IllegalArgumentException var2) {
         throw var2;
      }
   }

   @oc66fa4f2195
   public void ր(ocbab3c9954b var1) {
      this.H.ǆ();
   }

   public static boolean Է() {
      boolean var0 = oce6044968f8.ђ;

      oca9cc61aada var10000;
      label33: {
         try {
            var10000 = Ć;
            if (var0) {
               break label33;
            }

            if (Ć == null) {
               return (boolean)0;
            }
         } catch (IllegalArgumentException var2) {
            throw var2;
         }

         var10000 = Ć;
      }

      try {
         double var4;
         int var3 = (var4 = var10000.Ӂ() - 2.0) == 0.0 ? 0 : (var4 < 0.0 ? -1 : 1);
         if (var0) {
            return (boolean)var3;
         }

         if (!var3) {
            return (boolean)1;
         }
      } catch (IllegalArgumentException var1) {
         throw var1;
      }

      return (boolean)0;
   }

   @Override
   public void onEnable() {
      this.ά.clear();
      this.Џ.Ȭ();
      this.H.ǆ();
      this.җ = false;
      this.z$2u87utkr1isxg();
      oc9755810e45.ö();
   }

   @Override
   public void guiButtonToggled(occ2f8dff8d8 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 26
      // 09: getstatic x/ocd2958dac48.Ѡ Lx/oc93499ec6de;
      // 0c: getfield x/oc93499ec6de.ĉ Lx/occ2f8dff8d8;
      // 0f: if_acmpne 25
      // 12: goto 16
      // 15: athrow
      // 16: getstatic x/ocd2958dac48.Ѡ Lx/oc93499ec6de;
      // 19: getfield x/oc93499ec6de.ʸ Lx/oca9cc61aada;
      // 1c: dconst_0
      // 1d: invokevirtual x/oca9cc61aada.Ȟ (D)D
      // 20: pop2
      // 21: goto 25
      // 24: athrow
      // 25: aload 1
      // 26: getstatic x/ocd2958dac48.ɝ Lx/occ2f8dff8d8;
      // 29: if_acmpne 33
      // 2c: invokestatic x/oc9755810e45.Я ()V
      // 2f: goto 33
      // 32: athrow
      // 33: aload 0
      // 34: invokevirtual x/ocd2958dac48.z$2u87utkr1isxg ()V
      // 37: return
   }

   @Override
   public void z$1sehylui0i4ix(oca9cc61aada param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 2
      // 04: aload 1
      // 05: getstatic x/ocd2958dac48.Ѡ Lx/oc93499ec6de;
      // 08: iload 2
      // 09: ifne 34
      // 0c: getfield x/oc93499ec6de.ʸ Lx/oca9cc61aada;
      // 0f: if_acmpne 24
      // 12: goto 16
      // 15: athrow
      // 16: getstatic x/ocd2958dac48.Ѡ Lx/oc93499ec6de;
      // 19: invokevirtual x/oc93499ec6de.ë ()V
      // 1c: iload 2
      // 1d: ifeq 5f
      // 20: goto 24
      // 23: athrow
      // 24: aload 1
      // 25: iload 2
      // 26: ifne 5a
      // 29: goto 2d
      // 2c: athrow
      // 2d: getstatic x/ocd2958dac48.Ѡ Lx/oc93499ec6de;
      // 30: goto 34
      // 33: athrow
      // 34: getfield x/oc93499ec6de.Û Lx/oca9cc61aada;
      // 37: if_acmpeq 50
      // 3a: aload 1
      // 3b: iload 2
      // 3c: ifne 5a
      // 3f: goto 43
      // 42: athrow
      // 43: getstatic x/ocd2958dac48.Ѡ Lx/oc93499ec6de;
      // 46: getfield x/oc93499ec6de.Ϸ Lx/oca9cc61aada;
      // 49: if_acmpne 5f
      // 4c: goto 50
      // 4f: athrow
      // 50: getstatic x/ocd2958dac48.Ѡ Lx/oc93499ec6de;
      // 53: getfield x/oc93499ec6de.ʸ Lx/oca9cc61aada;
      // 56: goto 5a
      // 59: athrow
      // 5a: dconst_0
      // 5b: invokevirtual x/oca9cc61aada.Ȟ (D)D
      // 5e: pop2
      // 5f: bipush 1
      // 60: putstatic x/oc69da1aa7f5.ˤ Z
      // 63: aload 0
      // 64: invokevirtual x/ocd2958dac48.z$2u87utkr1isxg ()V
      // 67: return
   }

   @oc66fa4f2195
   public void η(ocf923d5a814 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: istore 2
      // 004: aload 1
      // 005: getfield x/ocb508b4e274.Ұ Lx/oc110d7f376c;
      // 008: getstatic x/oc110d7f376c.END Lx/oc110d7f376c;
      // 00b: if_acmpne 020
      // 00e: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 011: iload 2
      // 012: ifne 02d
      // 015: goto 019
      // 018: athrow
      // 019: ifne 021
      // 01c: goto 020
      // 01f: athrow
      // 020: return
      // 021: aload 0
      // 022: iload 2
      // 023: ifne 03b
      // 026: getfield x/ocd2958dac48.Н Z
      // 029: goto 02d
      // 02c: athrow
      // 02d: getstatic x/ocd2958dac48.ɝ Lx/occ2f8dff8d8;
      // 030: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 033: if_icmpeq 047
      // 036: aload 0
      // 037: goto 03b
      // 03a: athrow
      // 03b: getstatic x/ocd2958dac48.ɝ Lx/occ2f8dff8d8;
      // 03e: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 041: putfield x/ocd2958dac48.Н Z
      // 044: invokestatic x/oc9755810e45.Я ()V
      // 047: invokestatic x/ocd2958dac48.ƛ ()Ljava/lang/String;
      // 04a: astore 3
      // 04b: iload 2
      // 04c: invokestatic x/ocd2958dac48.Ѹ ()F
      // 04f: fstore 4
      // 051: ifne 082
      // 054: aload 3
      // 055: aload 0
      // 056: getfield x/ocd2958dac48.ɭ Ljava/lang/String;
      // 059: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 05c: ifeq 073
      // 05f: goto 063
      // 062: athrow
      // 063: fload 4
      // 065: aload 0
      // 066: getfield x/ocd2958dac48.ʚ F
      // 069: invokestatic java/lang/Float.compare (FF)I
      // 06c: ifeq 085
      // 06f: goto 073
      // 072: athrow
      // 073: aload 0
      // 074: aload 3
      // 075: putfield x/ocd2958dac48.ɭ Ljava/lang/String;
      // 078: aload 0
      // 079: fload 4
      // 07b: putfield x/ocd2958dac48.ʚ F
      // 07e: goto 082
      // 081: athrow
      // 082: invokestatic x/oc9755810e45.Я ()V
      // 085: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 088: iload 2
      // 089: ifne 0b5
      // 08c: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 08f: ifnull 0ae
      // 092: goto 096
      // 095: athrow
      // 096: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 099: iload 2
      // 09a: ifne 0b5
      // 09d: goto 0a1
      // 0a0: athrow
      // 0a1: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 0a4: instanceof net/minecraft/client/gui/GuiChat
      // 0a7: ifeq 0c6
      // 0aa: goto 0ae
      // 0ad: athrow
      // 0ae: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0b1: goto 0b5
      // 0b4: athrow
      // 0b5: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 0b8: getfield net/minecraft/client/settings/GameSettings.showDebugInfo Z
      // 0bb: iload 2
      // 0bc: ifne 0d3
      // 0bf: ifeq 0c7
      // 0c2: goto 0c6
      // 0c5: athrow
      // 0c6: return
      // 0c7: aload 0
      // 0c8: iload 2
      // 0c9: ifne 108
      // 0cc: getfield x/ocd2958dac48.җ Z
      // 0cf: goto 0d3
      // 0d2: athrow
      // 0d3: invokestatic x/ocd2958dac48.Է ()Z
      // 0d6: if_icmpeq 107
      // 0d9: aload 0
      // 0da: invokestatic x/ocd2958dac48.Է ()Z
      // 0dd: putfield x/ocd2958dac48.җ Z
      // 0e0: aload 0
      // 0e1: getfield x/ocd2958dac48.H Lx/ocd77007f9e2;
      // 0e4: invokevirtual x/ocd77007f9e2.ǆ ()V
      // 0e7: aload 0
      // 0e8: iload 2
      // 0e9: ifne 108
      // 0ec: goto 0f0
      // 0ef: athrow
      // 0f0: getfield x/ocd2958dac48.җ Z
      // 0f3: ifeq 107
      // 0f6: goto 0fa
      // 0f9: athrow
      // 0fa: aload 0
      // 0fb: getfield x/ocd2958dac48.H Lx/ocd77007f9e2;
      // 0fe: aload 0
      // 0ff: bipush 1
      // 100: invokevirtual x/ocd77007f9e2.ԅ (Lx/oc69da1aa7f5;Z)V
      // 103: goto 107
      // 106: athrow
      // 107: aload 0
      // 108: iload 2
      // 109: ifne 125
      // 10c: getfield x/ocd2958dac48.Ѻ Lx/occ2f8dff8d8;
      // 10f: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 112: ifeq 124
      // 115: goto 119
      // 118: athrow
      // 119: aload 0
      // 11a: getfield x/ocd2958dac48.Ƌ Lx/oc6b01c6afd6;
      // 11d: invokevirtual x/oc6b01c6afd6.Į ()V
      // 120: goto 124
      // 123: athrow
      // 124: aload 0
      // 125: getfield x/ocd2958dac48.Ķ Lx/occ2f8dff8d8;
      // 128: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 12b: iload 2
      // 12c: ifne 13a
      // 12f: ifne 137
      // 132: goto 136
      // 135: athrow
      // 136: return
      // 137: invokestatic x/ocd2958dac48.Է ()Z
      // 13a: iload 2
      // 13b: ifne 15d
      // 13e: ifeq 14e
      // 141: goto 145
      // 144: athrow
      // 145: aload 0
      // 146: getfield x/ocd2958dac48.H Lx/ocd77007f9e2;
      // 149: invokevirtual x/ocd77007f9e2.Ҹ ()V
      // 14c: return
      // 14d: athrow
      // 14e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 151: getfield net/minecraft/client/Minecraft.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // 154: aload 0
      // 155: invokedynamic getAsInt (Lx/ocd2958dac48;)Ljava/util/function/IntSupplier; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()I, x/ocd2958dac48.q33eq8t6f9t033 ()I, ()I ]
      // 15a: invokevirtual net/minecraft/client/gui/FontRenderer.withSmoothFont (Ljava/util/function/IntSupplier;)I
      // 15d: pop
      // 15e: return
   }

   private void σ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: invokestatic x/ocd2958dac48.M ()V
      // 006: istore 1
      // 007: getstatic x/oc9755810e45.ž Ljava/util/List;
      // 00a: dup
      // 00b: astore 3
      // 00c: monitorenter
      // 00d: getstatic x/oc9755810e45.ž Ljava/util/List;
      // 010: bipush 0
      // 011: anewarray 4
      // 014: invokeinterface java/util/List.toArray ([Ljava/lang/Object;)[Ljava/lang/Object; 2
      // 019: checkcast [Lx/oc69da1aa7f5;
      // 01c: astore 2
      // 01d: aload 3
      // 01e: monitorexit
      // 01f: goto 029
      // 022: astore 4
      // 024: aload 3
      // 025: monitorexit
      // 026: aload 4
      // 028: athrow
      // 029: aload 2
      // 02a: astore 3
      // 02b: aload 3
      // 02c: arraylength
      // 02d: istore 4
      // 02f: bipush 0
      // 030: istore 5
      // 032: iload 5
      // 034: iload 4
      // 036: if_icmpge 06c
      // 039: aload 3
      // 03a: iload 5
      // 03c: aaload
      // 03d: astore 6
      // 03f: iload 1
      // 040: ifne 068
      // 043: aload 6
      // 045: invokevirtual x/oc69da1aa7f5.œ ()Ljava/lang/String;
      // 048: pop
      // 049: iload 1
      // 04a: ifne 07f
      // 04d: goto 051
      // 050: athrow
      // 051: bipush 0
      // 052: ifeq 061
      // 055: goto 059
      // 058: athrow
      // 059: iload 1
      // 05a: ifeq 06c
      // 05d: goto 061
      // 060: athrow
      // 061: iinc 5 1
      // 064: goto 068
      // 067: athrow
      // 068: iload 1
      // 069: ifeq 032
      // 06c: bipush 0
      // 06d: iload 1
      // 06e: ifne 07c
      // 071: ifeq 07b
      // 074: goto 078
      // 077: athrow
      // 078: invokestatic x/oc9755810e45.Я ()V
      // 07b: bipush 0
      // 07c: putstatic x/oc69da1aa7f5.ˤ Z
      // 07f: invokestatic x/ocd2958dac48.ǧ ()Lx/oc1378bc114d;
      // 082: astore 3
      // 083: aload 3
      // 084: invokeinterface x/oc1378bc114d.z$g5bxucc1j700 ()I 1
      // 089: istore 4
      // 08b: aload 3
      // 08c: invokeinterface x/oc1378bc114d.z$w1h9nvoglpkn ()I 1
      // 091: istore 5
      // 093: invokestatic x/ocd2958dac48.ɫ ()I
      // 096: istore 6
      // 098: invokestatic x/ocd2958dac48.Ӈ ()I
      // 09b: istore 7
      // 09d: invokestatic x/ocd2958dac48.ώ ()I
      // 0a0: istore 8
      // 0a2: invokestatic x/ocd2958dac48.ƿ ()I
      // 0a5: istore 9
      // 0a7: aload 3
      // 0a8: iload 7
      // 0aa: iload 8
      // 0ac: iadd
      // 0ad: i2f
      // 0ae: fconst_2
      // 0af: fdiv
      // 0b0: invokestatic x/ocd2958dac48.o (Lx/oc1378bc114d;F)F
      // 0b3: fstore 10
      // 0b5: aload 0
      // 0b6: aload 3
      // 0b7: invokestatic java/lang/System.currentTimeMillis ()J
      // 0ba: invokevirtual x/ocd2958dac48.ƺ (Lx/oc1378bc114d;J)Ljava/util/List;
      // 0bd: astore 11
      // 0bf: invokestatic x/ocd2958dac48.Ǫ ()Z
      // 0c2: iload 1
      // 0c3: ifne 0fe
      // 0c6: ifeq 0f5
      // 0c9: goto 0cd
      // 0cc: athrow
      // 0cd: aload 0
      // 0ce: getfield x/ocd2958dac48.Џ Lx/oc67aa5109f0;
      // 0d1: aload 11
      // 0d3: aload 3
      // 0d4: invokestatic x/ocd2958dac48.ω ()Z
      // 0d7: invokestatic x/ocd2958dac48.Ю ()Z
      // 0da: ifne 0f0
      // 0dd: goto 0e1
      // 0e0: athrow
      // 0e1: invokestatic x/ocd2958dac48.ω ()Z
      // 0e4: ifne 0f0
      // 0e7: goto 0eb
      // 0ea: athrow
      // 0eb: bipush 1
      // 0ec: goto 0f1
      // 0ef: athrow
      // 0f0: bipush 0
      // 0f1: invokevirtual x/oc67aa5109f0.ǫ (Ljava/util/List;Lx/oc1378bc114d;ZZ)V
      // 0f4: return
      // 0f5: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0f8: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 0fb: instanceof net/minecraft/client/gui/GuiChat
      // 0fe: ifeq 335
      // 101: new net/minecraft/client/gui/ScaledResolution
      // 104: dup
      // 105: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 108: invokespecial net/minecraft/client/gui/ScaledResolution.<init> (Lnet/minecraft/client/Minecraft;)V
      // 10b: astore 12
      // 10d: invokestatic org/lwjgl/input/Mouse.getX ()I
      // 110: aload 12
      // 112: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledWidth ()I
      // 115: imul
      // 116: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 119: getfield net/minecraft/client/Minecraft.displayWidth I
      // 11c: idiv
      // 11d: istore 13
      // 11f: aload 12
      // 121: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledHeight ()I
      // 124: invokestatic org/lwjgl/input/Mouse.getY ()I
      // 127: aload 12
      // 129: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledHeight ()I
      // 12c: imul
      // 12d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 130: getfield net/minecraft/client/Minecraft.displayHeight I
      // 133: idiv
      // 134: isub
      // 135: bipush 1
      // 136: isub
      // 137: istore 14
      // 139: fconst_0
      // 13a: fstore 15
      // 13c: fconst_0
      // 13d: fstore 16
      // 13f: aload 11
      // 141: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 146: astore 17
      // 148: aload 17
      // 14a: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 14f: ifeq 17f
      // 152: aload 17
      // 154: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 159: checkcast x/oc6ae023f1e7
      // 15c: astore 18
      // 15e: iload 1
      // 15f: ifne 1a4
      // 162: fload 15
      // 164: aload 18
      // 166: getfield x/oc6ae023f1e7.њ F
      // 169: invokestatic java/lang/Math.max (FF)F
      // 16c: fstore 15
      // 16e: iload 1
      // 16f: fload 16
      // 171: aload 18
      // 173: getfield x/oc6ae023f1e7.Ӵ F
      // 176: fload 10
      // 178: fmul
      // 179: fadd
      // 17a: fstore 16
      // 17c: ifeq 148
      // 17f: aload 11
      // 181: invokeinterface java/util/List.isEmpty ()Z 1
      // 186: iload 1
      // 187: ifne 19d
      // 18a: ifeq 1a4
      // 18d: goto 191
      // 190: athrow
      // 191: aload 3
      // 192: ldc "ArrayList"
      // 194: invokeinterface x/oc1378bc114d.z$toz8pt08w0nc (Ljava/lang/String;)I 2
      // 199: goto 19d
      // 19c: athrow
      // 19d: i2f
      // 19e: fstore 15
      // 1a0: fload 10
      // 1a2: fstore 16
      // 1a4: fload 15
      // 1a6: iload 6
      // 1a8: i2f
      // 1a9: fconst_2
      // 1aa: fmul
      // 1ab: fadd
      // 1ac: iload 9
      // 1ae: i2f
      // 1af: fconst_2
      // 1b0: fmul
      // 1b1: fadd
      // 1b2: fstore 17
      // 1b4: fload 16
      // 1b6: iload 9
      // 1b8: i2f
      // 1b9: fconst_2
      // 1ba: fmul
      // 1bb: fadd
      // 1bc: fstore 18
      // 1be: getstatic x/ocd2958dac48.Ƭ Lx/occ2f8dff8d8;
      // 1c1: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 1c4: ifeq 1d9
      // 1c7: getstatic x/ocd2958dac48.Ƃ F
      // 1ca: fload 15
      // 1cc: fsub
      // 1cd: iload 6
      // 1cf: i2f
      // 1d0: fsub
      // 1d1: iload 9
      // 1d3: i2f
      // 1d4: fsub
      // 1d5: goto 1e4
      // 1d8: athrow
      // 1d9: getstatic x/ocd2958dac48.Ƃ F
      // 1dc: iload 6
      // 1de: i2f
      // 1df: fsub
      // 1e0: iload 9
      // 1e2: i2f
      // 1e3: fsub
      // 1e4: fstore 19
      // 1e6: fload 19
      // 1e8: fload 17
      // 1ea: fadd
      // 1eb: fstore 20
      // 1ed: getstatic x/ocd2958dac48.ș F
      // 1f0: iload 9
      // 1f2: i2f
      // 1f3: fsub
      // 1f4: fstore 21
      // 1f6: fload 21
      // 1f8: fload 18
      // 1fa: fadd
      // 1fb: fstore 22
      // 1fd: iload 13
      // 1ff: iload 1
      // 200: ifne 220
      // 203: i2f
      // 204: fload 19
      // 206: fcmpl
      // 207: iflt 255
      // 20a: goto 20e
      // 20d: athrow
      // 20e: iload 13
      // 210: i2f
      // 211: fload 20
      // 213: iload 1
      // 214: ifne 234
      // 217: goto 21b
      // 21a: athrow
      // 21b: fcmpg
      // 21c: goto 220
      // 21f: athrow
      // 220: ifgt 255
      // 223: iload 14
      // 225: i2f
      // 226: iload 1
      // 227: ifne 247
      // 22a: goto 22e
      // 22d: athrow
      // 22e: fload 21
      // 230: goto 234
      // 233: athrow
      // 234: fcmpl
      // 235: iflt 255
      // 238: iload 14
      // 23a: iload 1
      // 23b: ifne 252
      // 23e: goto 242
      // 241: athrow
      // 242: i2f
      // 243: goto 247
      // 246: athrow
      // 247: fload 22
      // 249: fcmpg
      // 24a: ifgt 255
      // 24d: bipush 1
      // 24e: goto 252
      // 251: athrow
      // 252: goto 256
      // 255: bipush 0
      // 256: istore 23
      // 258: aload 12
      // 25a: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaleFactor ()I
      // 25d: i2d
      // 25e: aload 12
      // 260: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaleFactor ()I
      // 263: i2d
      // 264: ldc2_w 2.0
      // 267: invokestatic java/lang/Math.pow (DD)D
      // 26a: ddiv
      // 26b: dstore 24
      // 26d: iload 23
      // 26f: iload 1
      // 270: ifne 2d1
      // 273: ifeq 2ce
      // 276: goto 27a
      // 279: athrow
      // 27a: getstatic x/ocd2958dac48.Ҏ Z
      // 27d: iload 1
      // 27e: ifne 2d1
      // 281: goto 285
      // 284: athrow
      // 285: ifne 2ce
      // 288: goto 28c
      // 28b: athrow
      // 28c: bipush 0
      // 28d: iload 1
      // 28e: ifne 2d1
      // 291: goto 295
      // 294: athrow
      // 295: invokestatic org/lwjgl/input/Mouse.isButtonDown (I)Z
      // 298: ifeq 2ce
      // 29b: goto 29f
      // 29e: athrow
      // 29f: bipush 1
      // 2a0: putstatic x/ocd2958dac48.Ҏ Z
      // 2a3: getstatic x/ocd2958dac48.Ƃ F
      // 2a6: putstatic x/ocd2958dac48.Π F
      // 2a9: getstatic x/ocd2958dac48.ș F
      // 2ac: putstatic x/ocd2958dac48.Ї F
      // 2af: invokestatic org/lwjgl/input/Mouse.getX ()I
      // 2b2: i2d
      // 2b3: dload 24
      // 2b5: dmul
      // 2b6: putstatic x/ocd2958dac48.բ D
      // 2b9: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 2bc: getfield net/minecraft/client/Minecraft.displayHeight I
      // 2bf: invokestatic org/lwjgl/input/Mouse.getY ()I
      // 2c2: isub
      // 2c3: i2d
      // 2c4: dload 24
      // 2c6: dmul
      // 2c7: putstatic x/ocd2958dac48.ȸ D
      // 2ca: goto 2ce
      // 2cd: athrow
      // 2ce: getstatic x/ocd2958dac48.Ҏ Z
      // 2d1: iload 1
      // 2d2: ifne 2ec
      // 2d5: ifeq 335
      // 2d8: goto 2dc
      // 2db: athrow
      // 2dc: bipush 0
      // 2dd: iload 1
      // 2de: ifne 302
      // 2e1: goto 2e5
      // 2e4: athrow
      // 2e5: invokestatic org/lwjgl/input/Mouse.isButtonDown (I)Z
      // 2e8: goto 2ec
      // 2eb: athrow
      // 2ec: ifne 2fb
      // 2ef: bipush 0
      // 2f0: putstatic x/ocd2958dac48.Ҏ Z
      // 2f3: iload 1
      // 2f4: ifeq 335
      // 2f7: goto 2fb
      // 2fa: athrow
      // 2fb: invokestatic org/lwjgl/input/Mouse.getX ()I
      // 2fe: goto 302
      // 301: athrow
      // 302: i2d
      // 303: dload 24
      // 305: dmul
      // 306: dstore 26
      // 308: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 30b: getfield net/minecraft/client/Minecraft.displayHeight I
      // 30e: invokestatic org/lwjgl/input/Mouse.getY ()I
      // 311: isub
      // 312: i2d
      // 313: dload 24
      // 315: dmul
      // 316: dstore 28
      // 318: getstatic x/ocd2958dac48.Π F
      // 31b: f2d
      // 31c: dload 26
      // 31e: getstatic x/ocd2958dac48.բ D
      // 321: dsub
      // 322: dadd
      // 323: d2f
      // 324: getstatic x/ocd2958dac48.Ї F
      // 327: f2d
      // 328: dload 28
      // 32a: getstatic x/ocd2958dac48.ȸ D
      // 32d: dsub
      // 32e: dadd
      // 32f: d2f
      // 330: aload 12
      // 332: invokestatic x/ocd2958dac48.ȉ (FFLnet/minecraft/client/gui/ScaledResolution;)V
      // 335: getstatic x/ocd2958dac48.ș F
      // 338: fstore 12
      // 33a: new net/minecraft/client/gui/ScaledResolution
      // 33d: dup
      // 33e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 341: invokespecial net/minecraft/client/gui/ScaledResolution.<init> (Lnet/minecraft/client/Minecraft;)V
      // 344: astore 13
      // 346: invokestatic x/ocd2958dac48.ω ()Z
      // 349: istore 14
      // 34b: invokestatic x/ocd2958dac48.Ю ()Z
      // 34e: iload 1
      // 34f: ifne 35b
      // 352: ifne 36a
      // 355: goto 359
      // 358: athrow
      // 359: iload 14
      // 35b: iload 1
      // 35c: ifne 367
      // 35f: ifne 36a
      // 362: goto 366
      // 365: athrow
      // 366: bipush 1
      // 367: goto 36b
      // 36a: bipush 0
      // 36b: istore 15
      // 36d: invokestatic x/oce6044968f8.Ѳ ()Lx/oc1378bc114d;
      // 370: astore 16
      // 372: new java/util/ArrayList
      // 375: dup
      // 376: invokespecial java/util/ArrayList.<init> ()V
      // 379: astore 17
      // 37b: aload 11
      // 37d: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 382: astore 18
      // 384: aload 18
      // 386: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 38b: ifeq 4ab
      // 38e: aload 18
      // 390: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 395: checkcast x/oc6ae023f1e7
      // 398: astore 19
      // 39a: iload 1
      // 39b: aload 19
      // 39d: getfield x/oc6ae023f1e7.Ӵ F
      // 3a0: fstore 20
      // 3a2: ifne 4b0
      // 3a5: getstatic x/ocd2958dac48.Ƃ F
      // 3a8: getstatic x/ocd2958dac48.Ƭ Lx/occ2f8dff8d8;
      // 3ab: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 3ae: ifeq 3be
      // 3b1: goto 3b5
      // 3b4: athrow
      // 3b5: aload 19
      // 3b7: getfield x/oc6ae023f1e7.њ F
      // 3ba: goto 3bf
      // 3bd: athrow
      // 3be: fconst_0
      // 3bf: fsub
      // 3c0: fstore 21
      // 3c2: iload 15
      // 3c4: ifeq 3e8
      // 3c7: fload 21
      // 3c9: getstatic x/ocd2958dac48.Ƭ Lx/occ2f8dff8d8;
      // 3cc: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 3cf: fload 20
      // 3d1: fload 21
      // 3d3: f2d
      // 3d4: fload 21
      // 3d6: aload 19
      // 3d8: getfield x/oc6ae023f1e7.њ F
      // 3db: fadd
      // 3dc: f2d
      // 3dd: aload 13
      // 3df: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledWidth ()I
      // 3e2: invokestatic x/ocd2958dac48.ճ (ZFDDI)F
      // 3e5: fadd
      // 3e6: fstore 21
      // 3e8: fload 21
      // 3ea: fstore 22
      // 3ec: iload 1
      // 3ed: fload 12
      // 3ef: fload 10
      // 3f1: iload 4
      // 3f3: i2f
      // 3f4: fsub
      // 3f5: iload 5
      // 3f7: i2f
      // 3f8: fsub
      // 3f9: fconst_2
      // 3fa: fdiv
      // 3fb: fadd
      // 3fc: iload 4
      // 3fe: i2f
      // 3ff: fadd
      // 400: fstore 23
      // 402: fload 21
      // 404: aload 19
      // 406: getfield x/oc6ae023f1e7.њ F
      // 409: fconst_2
      // 40a: fdiv
      // 40b: fadd
      // 40c: fstore 24
      // 40e: fload 12
      // 410: fload 10
      // 412: fconst_2
      // 413: fdiv
      // 414: fadd
      // 415: fstore 25
      // 417: fload 21
      // 419: iload 6
      // 41b: i2f
      // 41c: fsub
      // 41d: fstore 26
      // 41f: fload 12
      // 421: fstore 27
      // 423: aload 19
      // 425: getfield x/oc6ae023f1e7.њ F
      // 428: iload 6
      // 42a: ldc_w -1277353497
      // 42d: ldc_w -1277353499
      // 430: ixor
      // 431: imul
      // 432: i2f
      // 433: fadd
      // 434: fstore 28
      // 436: fload 10
      // 438: fstore 29
      // 43a: ifne 4a7
      // 43d: iload 14
      // 43f: ifeq 46e
      // 442: goto 446
      // 445: athrow
      // 446: fload 24
      // 448: fload 26
      // 44a: fload 24
      // 44c: fsub
      // 44d: fload 20
      // 44f: fmul
      // 450: fadd
      // 451: fstore 26
      // 453: fload 25
      // 455: fload 27
      // 457: fload 25
      // 459: fsub
      // 45a: fload 20
      // 45c: fmul
      // 45d: fadd
      // 45e: fstore 27
      // 460: fload 28
      // 462: fload 20
      // 464: fmul
      // 465: fstore 28
      // 467: fload 29
      // 469: fload 20
      // 46b: fmul
      // 46c: fstore 29
      // 46e: aload 17
      // 470: new x/oc99b8eeba10
      // 473: dup
      // 474: fload 26
      // 476: fload 27
      // 478: fload 28
      // 47a: fload 29
      // 47c: fload 20
      // 47e: iload 14
      // 480: fload 24
      // 482: fload 25
      // 484: fload 20
      // 486: aload 16
      // 488: aload 19
      // 48a: fload 22
      // 48c: fload 23
      // 48e: invokedynamic run (ZFFFLx/oc1378bc114d;Lx/oc6ae023f1e7;FF)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, x/ocd2958dac48.qpbx7fth7971g (ZFFFLx/oc1378bc114d;Lx/oc6ae023f1e7;FF)V, ()V ]
      // 493: aconst_null
      // 494: invokespecial x/oc99b8eeba10.<init> (FFFFFLjava/lang/Runnable;Ljava/lang/Runnable;)V
      // 497: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 49c: pop
      // 49d: fload 12
      // 49f: fload 20
      // 4a1: fload 10
      // 4a3: fmul
      // 4a4: fadd
      // 4a5: fstore 12
      // 4a7: iload 1
      // 4a8: ifeq 384
      // 4ab: aload 17
      // 4ad: invokestatic x/oce6044968f8.Û (Ljava/util/List;)V
      // 4b0: return
   }

   private List<oc6ae023f1e7> ƺ(oc1378bc114d param1, long param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: istore 4
      // 005: iload 4
      // 007: new java/util/ArrayList
      // 00a: dup
      // 00b: invokespecial java/util/ArrayList.<init> ()V
      // 00e: astore 5
      // 010: ifne 02a
      // 013: invokestatic x/ocd2958dac48.Ю ()Z
      // 016: ifeq 0db
      // 019: goto 01d
      // 01c: athrow
      // 01d: aload 0
      // 01e: getfield x/ocd2958dac48.ά Ljava/util/Map;
      // 021: invokeinterface java/util/Map.clear ()V 1
      // 026: goto 02a
      // 029: athrow
      // 02a: getstatic x/oc9755810e45.ž Ljava/util/List;
      // 02d: dup
      // 02e: astore 7
      // 030: monitorenter
      // 031: new java/util/ArrayList
      // 034: dup
      // 035: getstatic x/oc9755810e45.ž Ljava/util/List;
      // 038: invokespecial java/util/ArrayList.<init> (Ljava/util/Collection;)V
      // 03b: astore 6
      // 03d: aload 7
      // 03f: monitorexit
      // 040: goto 04b
      // 043: astore 8
      // 045: aload 7
      // 047: monitorexit
      // 048: aload 8
      // 04a: athrow
      // 04b: aload 6
      // 04d: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 052: astore 7
      // 054: aload 7
      // 056: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 05b: ifeq 0d3
      // 05e: aload 7
      // 060: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 065: checkcast x/oc69da1aa7f5
      // 068: astore 8
      // 06a: iload 4
      // 06c: ifne 0d8
      // 06f: aload 8
      // 071: iload 4
      // 073: ifne 083
      // 076: goto 07a
      // 079: athrow
      // 07a: ifnull 0ce
      // 07d: goto 081
      // 080: athrow
      // 081: aload 8
      // 083: iload 4
      // 085: ifne 098
      // 088: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 08b: ifeq 0ce
      // 08e: goto 092
      // 091: athrow
      // 092: aload 8
      // 094: goto 098
      // 097: athrow
      // 098: iload 4
      // 09a: ifne 0ab
      // 09d: aload 0
      // 09e: if_acmpeq 0ce
      // 0a1: goto 0a5
      // 0a4: athrow
      // 0a5: aload 8
      // 0a7: goto 0ab
      // 0aa: athrow
      // 0ab: bipush 0
      // 0ac: invokestatic x/ocd2958dac48.ȅ (Lx/oc69da1aa7f5;Z)Z
      // 0af: iload 4
      // 0b1: ifne 0cd
      // 0b4: ifne 0ce
      // 0b7: goto 0bb
      // 0ba: athrow
      // 0bb: aload 5
      // 0bd: aload 8
      // 0bf: aload 1
      // 0c0: fconst_1
      // 0c1: invokestatic x/ocd2958dac48.ӿ (Lx/oc69da1aa7f5;Lx/oc1378bc114d;F)Lx/oc6ae023f1e7;
      // 0c4: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 0c9: goto 0cd
      // 0cc: athrow
      // 0cd: pop
      // 0ce: iload 4
      // 0d0: ifeq 054
      // 0d3: aload 5
      // 0d5: invokestatic x/ocd2958dac48.Ω (Ljava/util/List;)V
      // 0d8: aload 5
      // 0da: areturn
      // 0db: new java/util/ArrayList
      // 0de: dup
      // 0df: getstatic x/oc9755810e45.Ŕ Ljava/util/List;
      // 0e2: invokespecial java/util/ArrayList.<init> (Ljava/util/Collection;)V
      // 0e5: astore 6
      // 0e7: getstatic x/oc9755810e45.ž Ljava/util/List;
      // 0ea: dup
      // 0eb: astore 7
      // 0ed: monitorenter
      // 0ee: getstatic x/oc9755810e45.ž Ljava/util/List;
      // 0f1: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 0f6: astore 8
      // 0f8: aload 8
      // 0fa: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0ff: ifeq 12e
      // 102: aload 8
      // 104: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 109: checkcast x/oc69da1aa7f5
      // 10c: astore 9
      // 10e: aload 6
      // 110: aload 9
      // 112: iload 4
      // 114: ifne 123
      // 117: invokeinterface java/util/List.contains (Ljava/lang/Object;)Z 2
      // 11c: ifne 129
      // 11f: aload 6
      // 121: aload 9
      // 123: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 128: pop
      // 129: iload 4
      // 12b: ifeq 0f8
      // 12e: aload 7
      // 130: monitorexit
      // 131: goto 13c
      // 134: astore 10
      // 136: aload 7
      // 138: monitorexit
      // 139: aload 10
      // 13b: athrow
      // 13c: new java/util/ArrayList
      // 13f: dup
      // 140: aload 0
      // 141: getfield x/ocd2958dac48.ά Ljava/util/Map;
      // 144: invokeinterface java/util/Map.keySet ()Ljava/util/Set; 1
      // 149: invokespecial java/util/ArrayList.<init> (Ljava/util/Collection;)V
      // 14c: invokevirtual java/util/ArrayList.iterator ()Ljava/util/Iterator;
      // 14f: astore 7
      // 151: aload 7
      // 153: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 158: ifeq 198
      // 15b: aload 7
      // 15d: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 162: checkcast x/oc69da1aa7f5
      // 165: astore 8
      // 167: aload 6
      // 169: iload 4
      // 16b: ifne 19a
      // 16e: aload 8
      // 170: iload 4
      // 172: ifne 18d
      // 175: goto 179
      // 178: athrow
      // 179: invokeinterface java/util/List.contains (Ljava/lang/Object;)Z 2
      // 17e: ifne 193
      // 181: goto 185
      // 184: athrow
      // 185: aload 6
      // 187: aload 8
      // 189: goto 18d
      // 18c: athrow
      // 18d: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 192: pop
      // 193: iload 4
      // 195: ifeq 151
      // 198: aload 6
      // 19a: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 19f: astore 7
      // 1a1: aload 7
      // 1a3: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 1a8: ifeq 2ee
      // 1ab: aload 7
      // 1ad: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 1b2: checkcast x/oc69da1aa7f5
      // 1b5: astore 8
      // 1b7: iload 4
      // 1b9: ifne 2f3
      // 1bc: iload 4
      // 1be: ifne 207
      // 1c1: goto 1c5
      // 1c4: athrow
      // 1c5: aload 8
      // 1c7: ifnull 1f7
      // 1ca: goto 1ce
      // 1cd: athrow
      // 1ce: aload 8
      // 1d0: iload 4
      // 1d2: ifne 206
      // 1d5: goto 1d9
      // 1d8: athrow
      // 1d9: aload 0
      // 1da: if_acmpeq 1f7
      // 1dd: goto 1e1
      // 1e0: athrow
      // 1e1: aload 8
      // 1e3: iload 4
      // 1e5: ifne 217
      // 1e8: goto 1ec
      // 1eb: athrow
      // 1ec: bipush 0
      // 1ed: invokestatic x/ocd2958dac48.ȅ (Lx/oc69da1aa7f5;Z)Z
      // 1f0: ifeq 20c
      // 1f3: goto 1f7
      // 1f6: athrow
      // 1f7: aload 0
      // 1f8: getfield x/ocd2958dac48.ά Ljava/util/Map;
      // 1fb: aload 8
      // 1fd: invokeinterface java/util/Map.remove (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 202: goto 206
      // 205: athrow
      // 206: pop
      // 207: iload 4
      // 209: ifeq 1a1
      // 20c: aload 0
      // 20d: getfield x/ocd2958dac48.ά Ljava/util/Map;
      // 210: aload 8
      // 212: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 217: checkcast x/ocfd3776543a
      // 21a: astore 9
      // 21c: aload 9
      // 21e: iload 4
      // 220: ifne 262
      // 223: ifnonnull 260
      // 226: goto 22a
      // 229: athrow
      // 22a: aload 8
      // 22c: iload 4
      // 22e: ifne 25f
      // 231: goto 235
      // 234: athrow
      // 235: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 238: ifne 248
      // 23b: goto 23f
      // 23e: athrow
      // 23f: iload 4
      // 241: ifeq 1a1
      // 244: goto 248
      // 247: athrow
      // 248: new x/ocfd3776543a
      // 24b: dup
      // 24c: lload 2
      // 24d: invokespecial x/ocfd3776543a.<init> (J)V
      // 250: astore 9
      // 252: aload 0
      // 253: getfield x/ocd2958dac48.ά Ljava/util/Map;
      // 256: aload 8
      // 258: aload 9
      // 25a: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 25f: pop
      // 260: aload 9
      // 262: getfield x/ocfd3776543a.Ĩ Lx/oc8ef88da691;
      // 265: invokestatic x/ocd2958dac48.Ǫ ()Z
      // 268: ifeq 279
      // 26b: getstatic x/ocd2958dac48.Ѡ Lx/oc93499ec6de;
      // 26e: getfield x/oc93499ec6de.Ѫ Lx/oca9cc61aada;
      // 271: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 274: d2l
      // 275: goto 280
      // 278: athrow
      // 279: ldc2_w -3588725547501100070
      // 27c: ldc2_w -3588725547501100256
      // 27f: lxor
      // 280: lload 2
      // 281: invokevirtual x/oc8ef88da691.Ԧ (JJ)V
      // 284: iload 4
      // 286: ifne 2e9
      // 289: aload 9
      // 28b: getfield x/ocfd3776543a.Ĩ Lx/oc8ef88da691;
      // 28e: aload 8
      // 290: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 293: lload 2
      // 294: invokevirtual x/oc8ef88da691.ɞ (ZJ)V
      // 297: aload 8
      // 299: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 29c: ifne 2d1
      // 29f: goto 2a3
      // 2a2: athrow
      // 2a3: aload 9
      // 2a5: getfield x/ocfd3776543a.Ĩ Lx/oc8ef88da691;
      // 2a8: lload 2
      // 2a9: invokevirtual x/oc8ef88da691.ń (J)Z
      // 2ac: iload 4
      // 2ae: ifne 2e8
      // 2b1: goto 2b5
      // 2b4: athrow
      // 2b5: ifeq 2d1
      // 2b8: goto 2bc
      // 2bb: athrow
      // 2bc: aload 0
      // 2bd: getfield x/ocd2958dac48.ά Ljava/util/Map;
      // 2c0: aload 8
      // 2c2: invokeinterface java/util/Map.remove (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 2c7: pop
      // 2c8: iload 4
      // 2ca: ifeq 1a1
      // 2cd: goto 2d1
      // 2d0: athrow
      // 2d1: aload 5
      // 2d3: aload 8
      // 2d5: aload 1
      // 2d6: aload 9
      // 2d8: getfield x/ocfd3776543a.Ĩ Lx/oc8ef88da691;
      // 2db: lload 2
      // 2dc: invokevirtual x/oc8ef88da691.ʡ (J)D
      // 2df: d2f
      // 2e0: invokestatic x/ocd2958dac48.ӿ (Lx/oc69da1aa7f5;Lx/oc1378bc114d;F)Lx/oc6ae023f1e7;
      // 2e3: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 2e8: pop
      // 2e9: iload 4
      // 2eb: ifeq 1a1
      // 2ee: aload 5
      // 2f0: invokestatic x/ocd2958dac48.Ω (Ljava/util/List;)V
      // 2f3: aload 5
      // 2f5: areturn
   }

   private static oc6ae023f1e7 ӿ(oc69da1aa7f5 param0, oc1378bc114d param1, float param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokestatic x/ocd2958dac48.Ի (Lx/oc69da1aa7f5;)Ljava/lang/String;
      // 04: astore 4
      // 06: aload 0
      // 07: invokestatic x/ocd2958dac48.ї (Lx/oc69da1aa7f5;)Ljava/lang/String;
      // 0a: astore 5
      // 0c: getstatic x/oce6044968f8.ђ Z
      // 0f: aload 4
      // 11: aload 5
      // 13: invokevirtual java/lang/String.length ()I
      // 16: invokevirtual java/lang/String.substring (I)Ljava/lang/String;
      // 19: astore 6
      // 1b: istore 3
      // 1c: aload 1
      // 1d: aload 5
      // 1f: invokeinterface x/oc1378bc114d.z$toz8pt08w0nc (Ljava/lang/String;)I 2
      // 24: istore 7
      // 26: iload 7
      // 28: i2f
      // 29: fstore 8
      // 2b: aload 1
      // 2c: aload 4
      // 2e: invokeinterface x/oc1378bc114d.z$toz8pt08w0nc (Ljava/lang/String;)I 2
      // 33: i2f
      // 34: fstore 9
      // 36: invokestatic x/ocd2958dac48.Ǫ ()Z
      // 39: iload 3
      // 3a: ifne 55
      // 3d: ifeq 96
      // 40: goto 44
      // 43: athrow
      // 44: getstatic x/ocd2958dac48.Ѡ Lx/oc93499ec6de;
      // 47: getfield x/oc93499ec6de.δ Lx/oca9cc61aada;
      // 4a: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 4d: ldc2_w 6.0
      // 50: dcmpl
      // 51: goto 55
      // 54: athrow
      // 55: iload 3
      // 56: ifne 6c
      // 59: ifeq 67
      // 5c: goto 60
      // 5f: athrow
      // 60: aload 6
      // 62: invokevirtual java/lang/String.stripLeading ()Ljava/lang/String;
      // 65: astore 6
      // 67: aload 6
      // 69: invokevirtual java/lang/String.isEmpty ()Z
      // 6c: ifne 88
      // 6f: fload 8
      // 71: f2d
      // 72: getstatic x/ocd2958dac48.Ѡ Lx/oc93499ec6de;
      // 75: getfield x/oc93499ec6de.ū Lx/oca9cc61aada;
      // 78: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 7b: invokestatic x/ocd2958dac48.Ѹ ()F
      // 7e: f2d
      // 7f: dmul
      // 80: ldc2_w 0.9
      // 83: ddiv
      // 84: dadd
      // 85: d2f
      // 86: fstore 8
      // 88: fload 8
      // 8a: aload 1
      // 8b: aload 6
      // 8d: invokeinterface x/oc1378bc114d.z$toz8pt08w0nc (Ljava/lang/String;)I 2
      // 92: i2f
      // 93: fadd
      // 94: fstore 9
      // 96: new x/oc6ae023f1e7
      // 99: dup
      // 9a: aload 0
      // 9b: aload 4
      // 9d: fload 9
      // 9f: fload 2
      // a0: aload 5
      // a2: aload 6
      // a4: iload 7
      // a6: fload 8
      // a8: invokespecial x/oc6ae023f1e7.<init> (Lx/oc69da1aa7f5;Ljava/lang/String;FFLjava/lang/String;Ljava/lang/String;IF)V
      // ab: areturn
   }

   private static void Ω(List<oc6ae023f1e7> param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 1
      // 04: invokestatic x/ocd2958dac48.Ǫ ()Z
      // 07: iload 1
      // 08: ifne 21
      // 0b: ifeq 3a
      // 0e: goto 12
      // 11: athrow
      // 12: getstatic x/ocd2958dac48.Ѡ Lx/oc93499ec6de;
      // 15: getfield x/oc93499ec6de.Ў Lx/oca9cc61aada;
      // 18: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 1b: dconst_1
      // 1c: dcmpl
      // 1d: goto 21
      // 20: athrow
      // 21: ifne 3a
      // 24: aload 0
      // 25: invokedynamic apply ()Ljava/util/function/Function; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Ljava/lang/Object;, x/ocd2958dac48.q1n3ebfdbacr86 (Lx/oc6ae023f1e7;)Ljava/lang/String;, (Lx/oc6ae023f1e7;)Ljava/lang/String; ]
      // 2a: invokestatic java/util/Comparator.comparing (Ljava/util/function/Function;)Ljava/util/Comparator;
      // 2d: invokeinterface java/util/List.sort (Ljava/util/Comparator;)V 2
      // 32: iload 1
      // 33: ifeq 69
      // 36: goto 3a
      // 39: athrow
      // 3a: invokedynamic applyAsDouble ()Ljava/util/function/ToDoubleFunction; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)D, x/ocd2958dac48.q11otz94vv83hu (Lx/oc6ae023f1e7;)D, (Lx/oc6ae023f1e7;)D ]
      // 3f: invokestatic java/util/Comparator.comparingDouble (Ljava/util/function/ToDoubleFunction;)Ljava/util/Comparator;
      // 42: invokeinterface java/util/Comparator.reversed ()Ljava/util/Comparator; 1
      // 47: astore 2
      // 48: invokestatic x/ocd2958dac48.Ǫ ()Z
      // 4b: ifeq 62
      // 4e: aload 2
      // 4f: invokedynamic applyAsInt ()Ljava/util/function/ToIntFunction; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)I, x/ocd2958dac48.qyc8d071u3fk4 (Lx/oc6ae023f1e7;)I, (Lx/oc6ae023f1e7;)I ]
      // 54: invokestatic java/util/Comparator.comparingInt (Ljava/util/function/ToIntFunction;)Ljava/util/Comparator;
      // 57: invokeinterface java/util/Comparator.reversed ()Ljava/util/Comparator; 1
      // 5c: invokeinterface java/util/Comparator.thenComparing (Ljava/util/Comparator;)Ljava/util/Comparator; 2
      // 61: astore 2
      // 62: aload 0
      // 63: aload 2
      // 64: invokeinterface java/util/List.sort (Ljava/util/Comparator;)V 2
      // 69: invokestatic x/ocd2958dac48.Ǫ ()Z
      // 6c: iload 1
      // 6d: ifne 84
      // 70: ifeq 8f
      // 73: goto 77
      // 76: athrow
      // 77: getstatic x/ocd2958dac48.Ѡ Lx/oc93499ec6de;
      // 7a: getfield x/oc93499ec6de.Ů Lx/occ2f8dff8d8;
      // 7d: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 80: goto 84
      // 83: athrow
      // 84: ifeq 8f
      // 87: aload 0
      // 88: invokestatic java/util/Collections.reverse (Ljava/util/List;)V
      // 8b: goto 8f
      // 8e: athrow
      // 8f: return
   }

   public static boolean Ǫ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 0
      // 04: getstatic x/ocd2958dac48.Ć Lx/oca9cc61aada;
      // 07: iload 0
      // 08: ifne 15
      // 0b: ifnull 2c
      // 0e: goto 12
      // 11: athrow
      // 12: getstatic x/ocd2958dac48.Ć Lx/oca9cc61aada;
      // 15: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 18: dconst_1
      // 19: dcmpl
      // 1a: ifne 2c
      // 1d: getstatic x/ocd2958dac48.Ѡ Lx/oc93499ec6de;
      // 20: ifnull 2c
      // 23: goto 27
      // 26: athrow
      // 27: bipush 1
      // 28: goto 2d
      // 2b: athrow
      // 2c: bipush 0
      // 2d: ireturn
   }

   private static boolean ω() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 0
      // 04: getstatic x/ocd2958dac48.ƌ Lx/oca9cc61aada;
      // 07: iload 0
      // 08: ifne 15
      // 0b: ifnull 2b
      // 0e: goto 12
      // 11: athrow
      // 12: getstatic x/ocd2958dac48.ƌ Lx/oca9cc61aada;
      // 15: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 18: d2i
      // 19: iload 0
      // 1a: ifne 30
      // 1d: ldc_w 263149056
      // 20: ldc_w 263149058
      // 23: ixor
      // 24: if_icmpne 33
      // 27: goto 2b
      // 2a: athrow
      // 2b: bipush 1
      // 2c: goto 30
      // 2f: athrow
      // 30: goto 34
      // 33: bipush 0
      // 34: ireturn
   }

   private static boolean Ю() {
      boolean var0 = oce6044968f8.ђ;

      oca9cc61aada var10000;
      label33: {
         try {
            var10000 = ƌ;
            if (var0) {
               break label33;
            }

            if (ƌ == null) {
               return (boolean)0;
            }
         } catch (IllegalArgumentException var2) {
            throw var2;
         }

         var10000 = ƌ;
      }

      try {
         int var3 = (int)var10000.Ӂ();
         if (var0) {
            return (boolean)var3;
         }

         if (var3 == 0) {
            return (boolean)1;
         }
      } catch (IllegalArgumentException var1) {
         throw var1;
      }

      return (boolean)0;
   }

   static float ճ(boolean var0, float var1, double var2, double var4, int var6) {
      boolean var7 = oce6044968f8.ђ;

      float var10;
      label24: {
         label23: {
            label22: {
               try {
                  var10000 = var0;
                  if (var7) {
                     break label23;
                  }

                  if (var0 == 0) {
                     break label22;
                  }
               } catch (IllegalArgumentException var9) {
                  throw var9;
               }

               var10000 = var6;
               break label23;
            }

            var10 = (float)(-var4);
            break label24;
         }

         var10 = (float)(var10000 - var2);
      }

      float var8 = var10;
      return var8 * (1.0F - И(var1));
   }

   private static void ԛ(float var0, float var1, float var2) {
      float var3 = И(var2);
      GlStateManager.pushMatrix();
      GlStateManager.translate(var0, var1, 0.0F);
      GlStateManager.scale(var3, var3, 1.0F);
      GlStateManager.translate(-var0, -var1, 0.0F);
   }

   static int ϋ(int param0, float param1, boolean param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 3
      // 04: iload 2
      // 05: iload 3
      // 06: ifne 1c
      // 09: ifne 13
      // 0c: goto 10
      // 0f: athrow
      // 10: iload 0
      // 11: ireturn
      // 12: athrow
      // 13: iload 0
      // 14: ldc_w -765637994
      // 17: ldc_w -765638002
      // 1a: ixor
      // 1b: iushr
      // 1c: istore 4
      // 1e: iload 0
      // 1f: iload 4
      // 21: i2f
      // 22: fload 1
      // 23: invokestatic x/ocd2958dac48.И (F)F
      // 26: fmul
      // 27: invokestatic java/lang/Math.round (F)I
      // 2a: invokestatic x/oc7ab2161b9f.Ҭ (II)I
      // 2d: ireturn
   }

   private static float И(float var0) {
      return Math.max(0.0F, Math.min(1.0F, var0));
   }

   public static int p537stateI() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: invokestatic x/ocd2958dac48.ǧ ()Lx/oc1378bc114d;
      // 06: astore 1
      // 07: istore 0
      // 08: bipush 0
      // 09: istore 2
      // 0a: getstatic x/oc9755810e45.ž Ljava/util/List;
      // 0d: dup
      // 0e: astore 4
      // 10: monitorenter
      // 11: getstatic x/oc9755810e45.ž Ljava/util/List;
      // 14: bipush 0
      // 15: anewarray 4
      // 18: invokeinterface java/util/List.toArray ([Ljava/lang/Object;)[Ljava/lang/Object; 2
      // 1d: checkcast [Lx/oc69da1aa7f5;
      // 20: astore 3
      // 21: aload 4
      // 23: monitorexit
      // 24: goto 2f
      // 27: astore 5
      // 29: aload 4
      // 2b: monitorexit
      // 2c: aload 5
      // 2e: athrow
      // 2f: aload 3
      // 30: astore 4
      // 32: aload 4
      // 34: arraylength
      // 35: istore 5
      // 37: bipush 0
      // 38: istore 6
      // 3a: iload 6
      // 3c: iload 5
      // 3e: if_icmpge 77
      // 41: aload 4
      // 43: iload 6
      // 45: aaload
      // 46: astore 7
      // 48: iload 0
      // 49: ifne 73
      // 4c: aload 7
      // 4e: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 51: iload 0
      // 52: ifne 78
      // 55: goto 59
      // 58: athrow
      // 59: ifeq 70
      // 5c: goto 60
      // 5f: athrow
      // 60: iload 2
      // 61: aload 1
      // 62: aload 7
      // 64: invokestatic x/ocd2958dac48.Ի (Lx/oc69da1aa7f5;)Ljava/lang/String;
      // 67: invokeinterface x/oc1378bc114d.z$toz8pt08w0nc (Ljava/lang/String;)I 2
      // 6c: invokestatic java/lang/Math.max (II)I
      // 6f: istore 2
      // 70: iinc 6 1
      // 73: iload 0
      // 74: ifeq 3a
      // 77: iload 2
      // 78: ireturn
   }

   private static boolean ȅ(oc69da1aa7f5 param0, boolean param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 2
      // 04: aload 0
      // 05: invokevirtual x/oc69da1aa7f5.լ ()Z
      // 08: iload 2
      // 09: ifne 19
      // 0c: ifeq 16
      // 0f: goto 13
      // 12: athrow
      // 13: bipush 1
      // 14: ireturn
      // 15: athrow
      // 16: invokestatic x/ocd2958dac48.Ǫ ()Z
      // 19: iload 2
      // 1a: ifne 4f
      // 1d: ifeq 4c
      // 20: goto 24
      // 23: athrow
      // 24: aload 0
      // 25: invokevirtual x/oc69da1aa7f5.ϡ ()Z
      // 28: iload 2
      // 29: ifne 4b
      // 2c: goto 30
      // 2f: athrow
      // 30: ifeq 4a
      // 33: goto 37
      // 36: athrow
      // 37: aload 0
      // 38: instanceof x/oc6a43806f12
      // 3b: iload 2
      // 3c: ifne 4f
      // 3f: goto 43
      // 42: athrow
      // 43: ifeq 4c
      // 46: goto 4a
      // 49: athrow
      // 4a: bipush 1
      // 4b: ireturn
      // 4c: invokestatic x/ocd2958dac48.Ǫ ()Z
      // 4f: iload 2
      // 50: ifne 7a
      // 53: ifeq 76
      // 56: goto 5a
      // 59: athrow
      // 5a: getstatic x/ocd2958dac48.Ѡ Lx/oc93499ec6de;
      // 5d: aload 0
      // 5e: invokevirtual x/oc69da1aa7f5.ъ ()Lx/oce4cea752dd;
      // 61: invokevirtual x/oc93499ec6de.ġ (Lx/oce4cea752dd;)Z
      // 64: iload 2
      // 65: ifne 7a
      // 68: goto 6c
      // 6b: athrow
      // 6c: ifeq 76
      // 6f: goto 73
      // 72: athrow
      // 73: bipush 1
      // 74: ireturn
      // 75: athrow
      // 76: aload 0
      // 77: instanceof x/oc461f94603e
      // 7a: iload 2
      // 7b: ifne 86
      // 7e: ifeq 95
      // 81: goto 85
      // 84: athrow
      // 85: iload 1
      // 86: iload 2
      // 87: ifne 92
      // 8a: ifeq 95
      // 8d: goto 91
      // 90: athrow
      // 91: bipush 1
      // 92: goto 96
      // 95: bipush 0
      // 96: ireturn
   }

   public static oc1378bc114d ǧ() {
      return oc3ebac73392.ȯ(ƛ(), Ѹ());
   }

   public static String ї(oc69da1aa7f5 var0) {
      boolean var1 = oce6044968f8.ђ;
      boolean var10000 = var1;
      String var2 = var0.Ҽ();

      label53: {
         label57: {
            label51: {
               try {
                  if (var10000) {
                     break label51;
                  }

                  if (!Ǫ()) {
                     break label57;
                  }
               } catch (IllegalArgumentException var5) {
                  throw var5;
               }

               var2 = StringUtils.stripControlCodes(var2);
            }

            try {
               var6 = Ѡ.É;
               if (var1) {
                  break label53;
               }

               if (!Ѡ.É.ǭ()) {
                  break label57;
               }
            } catch (IllegalArgumentException var4) {
               throw var4;
            }

            var2 = var2.replace(" ", "");
         }

         var6 = Л;
      }

      label35: {
         try {
            if (var1) {
               break label35;
            }

            if (var6 == null) {
               return var2;
            }
         } catch (IllegalArgumentException var3) {
            throw var3;
         }

         var6 = Л;
      }

      if (var6.ǭ()) {
         var2 = var2.toLowerCase(Locale.ROOT);
      }

      return var2;
   }

   public static String Ի(oc69da1aa7f5 param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: aload 0
      // 04: invokestatic x/ocd2958dac48.ї (Lx/oc69da1aa7f5;)Ljava/lang/String;
      // 07: astore 2
      // 08: aload 0
      // 09: aload 0
      // 0a: invokevirtual x/oc69da1aa7f5.ʱ ()Ljava/lang/String;
      // 0d: invokestatic x/oc466bffbdc9.P (Lx/oc69da1aa7f5;Ljava/lang/String;)Ljava/lang/String;
      // 10: astore 3
      // 11: istore 1
      // 12: getstatic x/ocd2958dac48.ɝ Lx/occ2f8dff8d8;
      // 15: iload 1
      // 16: ifne 80
      // 19: ifnull 7d
      // 1c: goto 20
      // 1f: athrow
      // 20: getstatic x/ocd2958dac48.ɝ Lx/occ2f8dff8d8;
      // 23: iload 1
      // 24: ifne 80
      // 27: goto 2b
      // 2a: athrow
      // 2b: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 2e: ifeq 7d
      // 31: goto 35
      // 34: athrow
      // 35: aload 3
      // 36: iload 1
      // 37: ifne 46
      // 3a: goto 3e
      // 3d: athrow
      // 3e: ifnull 7d
      // 41: goto 45
      // 44: athrow
      // 45: aload 3
      // 46: iload 1
      // 47: ifne 59
      // 4a: invokevirtual java/lang/String.isEmpty ()Z
      // 4d: ifne 7d
      // 50: goto 54
      // 53: athrow
      // 54: aload 2
      // 55: goto 59
      // 58: athrow
      // 59: invokestatic x/ocd2958dac48.Ǫ ()Z
      // 5c: ifeq 6d
      // 5f: getstatic x/ocd2958dac48.Ѡ Lx/oc93499ec6de;
      // 62: aload 3
      // 63: invokestatic net/minecraft/util/StringUtils.stripControlCodes (Ljava/lang/String;)Ljava/lang/String;
      // 66: invokevirtual x/oc93499ec6de.ե (Ljava/lang/String;)Ljava/lang/String;
      // 69: goto 77
      // 6c: athrow
      // 6d: aload 3
      // 6e: ldc_w " §7"
      // 71: swap
      // 72: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 77: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 7c: astore 2
      // 7d: getstatic x/ocd2958dac48.Л Lx/occ2f8dff8d8;
      // 80: iload 1
      // 81: ifne 8e
      // 84: ifnull 9c
      // 87: goto 8b
      // 8a: athrow
      // 8b: getstatic x/ocd2958dac48.Л Lx/occ2f8dff8d8;
      // 8e: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 91: ifeq 9c
      // 94: aload 2
      // 95: getstatic java/util/Locale.ROOT Ljava/util/Locale;
      // 98: invokevirtual java/lang/String.toLowerCase (Ljava/util/Locale;)Ljava/lang/String;
      // 9b: astore 2
      // 9c: aload 2
      // 9d: areturn
   }

   static oc93499ec6de պ() {
      return Ѡ;
   }

   public static String ƛ() {
      try {
         if (ӯ == null) {
            return "ProductSans";
         }
      } catch (IllegalArgumentException var1) {
         throw var1;
      }

      int var0 = (int)Math.max(0.0, Math.min((double)(ӯ.Ҿ().length - 1), ӯ.Ӂ()));
      return ӯ.Ҿ()[var0];
   }

   public static float Ѹ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 0
      // 04: getstatic x/ocd2958dac48.Ѭ Lx/oca9cc61aada;
      // 07: iload 0
      // 08: ifne 1b
      // 0b: ifnonnull 18
      // 0e: goto 12
      // 11: athrow
      // 12: dconst_1
      // 13: invokestatic x/oc05d664c647.Ө (D)F
      // 16: freturn
      // 17: athrow
      // 18: getstatic x/ocd2958dac48.Ѭ Lx/oca9cc61aada;
      // 1b: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 1e: invokestatic x/oc05d664c647.Ө (D)F
      // 21: freturn
   }

   public static float β() {
      M();
      return Ƶ;
   }

   public static float Ş() {
      M();
      return l;
   }

   public float ʫ() {
      return this.Џ.Ҥ();
   }

   public float i() {
      return this.Џ.ԉ();
   }

   public void Ǚ(float var1, float var2) {
      this.Џ.ǟ(var1, var2);
   }

   public double ҟ() {
      return this.Ƌ.Ƭ();
   }

   public double ώ() {
      return this.Ƌ.ԥ();
   }

   public void һ(double var1, double var3) {
      this.Ƌ.ğ(var1, var3);
   }

   public static void Ĵ(float var0, float var1) {
      Ƶ = var0;
      l = var1;
      M();
   }

   public static void Ͷ(float var0, float var1) {
      ȉ(var0, var1, new ScaledResolution(oc69da1aa7f5.ő));
   }

   public static void ſ() {
      Ֆ(new ScaledResolution(oc69da1aa7f5.ő));
   }

   private static void M() {
      հ(new ScaledResolution(oc69da1aa7f5.ő));
   }

   private static void հ(ScaledResolution param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: bipush 1
      // 04: aload 0
      // 05: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledWidth ()I
      // 08: invokestatic java/lang/Math.max (II)I
      // 0b: istore 2
      // 0c: istore 1
      // 0d: bipush 1
      // 0e: aload 0
      // 0f: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledHeight ()I
      // 12: invokestatic java/lang/Math.max (II)I
      // 15: istore 3
      // 16: iload 1
      // 17: ifne 49
      // 1a: getstatic x/ocd2958dac48.Ƶ F
      // 1d: invokestatic java/lang/Float.isNaN (F)Z
      // 20: ifne 3c
      // 23: goto 27
      // 26: athrow
      // 27: getstatic x/ocd2958dac48.l F
      // 2a: iload 1
      // 2b: ifne 61
      // 2e: goto 32
      // 31: athrow
      // 32: invokestatic java/lang/Float.isNaN (F)Z
      // 35: ifeq 52
      // 38: goto 3c
      // 3b: athrow
      // 3c: getstatic x/ocd2958dac48.Ƃ F
      // 3f: iload 2
      // 40: i2f
      // 41: fdiv
      // 42: putstatic x/ocd2958dac48.Ƶ F
      // 45: goto 49
      // 48: athrow
      // 49: getstatic x/ocd2958dac48.ș F
      // 4c: iload 3
      // 4d: i2f
      // 4e: fdiv
      // 4f: putstatic x/ocd2958dac48.l F
      // 52: getstatic x/ocd2958dac48.Ƶ F
      // 55: iload 2
      // 56: i2f
      // 57: fmul
      // 58: putstatic x/ocd2958dac48.Ƃ F
      // 5b: getstatic x/ocd2958dac48.l F
      // 5e: iload 3
      // 5f: i2f
      // 60: fmul
      // 61: putstatic x/ocd2958dac48.ș F
      // 64: return
   }

   private static void ȉ(float var0, float var1, ScaledResolution var2) {
      Ƃ = var0;
      ș = var1;
      int var3 = Math.max(1, var2.getScaledWidth());
      int var4 = Math.max(1, var2.getScaledHeight());
      Ƶ = var0 / var3;
      l = var1 / var4;
   }

   private static void Ֆ(ScaledResolution var0) {
      ȉ(5.0F, 70.0F, var0);
   }

   private static int ɫ() {
      return è(2.0F);
   }

   private static int Ӈ() {
      return è(2.0F);
   }

   private static int p3ceStateI() {
      return 0;
   }

   private static int ƿ() {
      return è(1.0F);
   }

   private static int è(float var0) {
      return Math.round(var0 * Ѹ());
   }

   static float o(oc1378bc114d var0, float var1) {
      int var10000 = oce6044968f8.ђ;
      float var3 = var0.z$3l314uvjy8lta();
      boolean var2 = (boolean)var10000;

      label21: {
         label20: {
            try {
               var10000 = oc3ebac73392.Ϟ(ƛ());
               if (var2) {
                  break label21;
               }

               if (var10000 == 0) {
                  break label20;
               }
            } catch (IllegalArgumentException var5) {
               throw var5;
            }

            var3 += 2.0F * Ѹ() / 0.9F;
         }

         var10000 = var0.z$g5bxucc1j700() + var0.z$w1h9nvoglpkn();
      }

      float var4 = var10000;
      return Math.max(var3, var4 + var1 * 2.0F);
   }

   public static boolean у() {
      boolean var0 = oce6044968f8.ђ;

      occ2f8dff8d8 var10000;
      label33: {
         try {
            var10000 = ӣ;
            if (var0) {
               break label33;
            }

            if (ӣ == null) {
               return true;
            }
         } catch (IllegalArgumentException var2) {
            throw var2;
         }

         var10000 = ӣ;
      }

      try {
         boolean var3 = var10000.ǭ();
         if (var0) {
            return var3;
         }

         if (var3) {
            return true;
         }
      } catch (IllegalArgumentException var1) {
         throw var1;
      }

      return false;
   }

   public static int ů(double var0) {
      return ʰ(0.0, var0);
   }

   public static int ʰ(double var0, double var2) {
      return Ǩ(var0, var2, System.currentTimeMillis());
   }

   static int Ǩ(double param0, double param2, long param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: istore 6
      // 005: getstatic x/ocd2958dac48.ƺ Lx/oca9cc61aada;
      // 008: iload 6
      // 00a: ifne 01c
      // 00d: ifnonnull 019
      // 010: goto 014
      // 013: athrow
      // 014: bipush 0
      // 015: goto 020
      // 018: athrow
      // 019: getstatic x/ocd2958dac48.ƺ Lx/oca9cc61aada;
      // 01c: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 01f: d2i
      // 020: istore 7
      // 022: getstatic x/ocd2958dac48.Ѡ Lx/oc93499ec6de;
      // 025: ifnull 033
      // 028: dload 0
      // 029: dload 2
      // 02a: lload 4
      // 02c: iload 7
      // 02e: invokestatic x/ocd2958dac48.ɼ (DDJI)I
      // 031: ireturn
      // 032: athrow
      // 033: iload 7
      // 035: iload 6
      // 037: ifne 057
      // 03a: ldc_w 656486712
      // 03d: ldc_w 656486714
      // 040: ixor
      // 041: if_icmpne 058
      // 044: goto 048
      // 047: athrow
      // 048: getstatic x/oc5e96231df6.Ѫ Lx/oc5e96231df6;
      // 04b: dload 0
      // 04c: dload 2
      // 04d: invokevirtual x/oc5e96231df6.A (DD)Ljava/awt/Color;
      // 050: invokevirtual java/awt/Color.getRGB ()I
      // 053: goto 057
      // 056: athrow
      // 057: ireturn
      // 058: invokestatic x/ocd2958dac48.ȓ ()Lx/oc5e96231df6;
      // 05b: astore 8
      // 05d: aload 8
      // 05f: ifnull 0b8
      // 062: iload 7
      // 064: iload 6
      // 066: ifne 091
      // 069: goto 06d
      // 06c: athrow
      // 06d: ldc_w 656486713
      // 070: ldc_w 656486714
      // 073: ixor
      // 074: if_icmpne 08f
      // 077: goto 07b
      // 07a: athrow
      // 07b: aload 8
      // 07d: invokevirtual x/oc5e96231df6.ҟ ()Ljava/awt/Color;
      // 080: invokevirtual java/awt/Color.getRGB ()I
      // 083: dload 2
      // 084: invokestatic x/ocd2958dac48.ʲ (D)D
      // 087: ldc2_w 0.55
      // 08a: invokestatic x/ocd2958dac48.Շ (IDD)I
      // 08d: ireturn
      // 08e: athrow
      // 08f: iload 7
      // 091: iload 6
      // 093: ifne 0ac
      // 096: bipush 1
      // 097: if_icmpne 0af
      // 09a: goto 09e
      // 09d: athrow
      // 09e: aload 8
      // 0a0: dconst_0
      // 0a1: dload 2
      // 0a2: invokevirtual x/oc5e96231df6.A (DD)Ljava/awt/Color;
      // 0a5: invokevirtual java/awt/Color.getRGB ()I
      // 0a8: goto 0ac
      // 0ab: athrow
      // 0ac: goto 0b7
      // 0af: aload 8
      // 0b1: invokevirtual x/oc5e96231df6.ҟ ()Ljava/awt/Color;
      // 0b4: invokevirtual java/awt/Color.getRGB ()I
      // 0b7: ireturn
      // 0b8: getstatic x/ocd2958dac48.у Lx/oc24a0a5bddf;
      // 0bb: ifnonnull 0de
      // 0be: new java/awt/Color
      // 0c1: dup
      // 0c2: ldc_w 656486853
      // 0c5: ldc_w 656486714
      // 0c8: ixor
      // 0c9: ldc_w 656486853
      // 0cc: ldc_w 656486714
      // 0cf: ixor
      // 0d0: ldc_w 656486853
      // 0d3: ldc_w 656486714
      // 0d6: ixor
      // 0d7: invokespecial java/awt/Color.<init> (III)V
      // 0da: goto 0f7
      // 0dd: athrow
      // 0de: new java/awt/Color
      // 0e1: dup
      // 0e2: getstatic x/ocd2958dac48.у Lx/oc24a0a5bddf;
      // 0e5: invokevirtual x/oc24a0a5bddf.ˀ ()I
      // 0e8: getstatic x/ocd2958dac48.у Lx/oc24a0a5bddf;
      // 0eb: invokevirtual x/oc24a0a5bddf.z ()I
      // 0ee: getstatic x/ocd2958dac48.у Lx/oc24a0a5bddf;
      // 0f1: invokevirtual x/oc24a0a5bddf.ц ()I
      // 0f4: invokespecial java/awt/Color.<init> (III)V
      // 0f7: astore 9
      // 0f9: iload 7
      // 0fb: iload 6
      // 0fd: ifne 10e
      // 100: bipush 1
      // 101: if_icmpeq 121
      // 104: goto 108
      // 107: athrow
      // 108: iload 7
      // 10a: goto 10e
      // 10d: athrow
      // 10e: iload 6
      // 110: ifne 19f
      // 113: ldc_w 656486713
      // 116: ldc_w 656486714
      // 119: ixor
      // 11a: if_icmpne 19a
      // 11d: goto 121
      // 120: athrow
      // 121: getstatic x/ocd2958dac48.ь Lx/oc24a0a5bddf;
      // 124: ifnonnull 14b
      // 127: goto 12b
      // 12a: athrow
      // 12b: new java/awt/Color
      // 12e: dup
      // 12f: ldc_w 656486767
      // 132: ldc_w 656486714
      // 135: ixor
      // 136: ldc_w 656486767
      // 139: ldc_w 656486714
      // 13c: ixor
      // 13d: ldc_w 656486853
      // 140: ldc_w 656486714
      // 143: ixor
      // 144: invokespecial java/awt/Color.<init> (III)V
      // 147: goto 164
      // 14a: athrow
      // 14b: new java/awt/Color
      // 14e: dup
      // 14f: getstatic x/ocd2958dac48.ь Lx/oc24a0a5bddf;
      // 152: invokevirtual x/oc24a0a5bddf.ˀ ()I
      // 155: getstatic x/ocd2958dac48.ь Lx/oc24a0a5bddf;
      // 158: invokevirtual x/oc24a0a5bddf.z ()I
      // 15b: getstatic x/ocd2958dac48.ь Lx/oc24a0a5bddf;
      // 15e: invokevirtual x/oc24a0a5bddf.ц ()I
      // 161: invokespecial java/awt/Color.<init> (III)V
      // 164: astore 10
      // 166: iload 7
      // 168: iload 6
      // 16a: ifne 18e
      // 16d: ldc_w 656486713
      // 170: ldc_w 656486714
      // 173: ixor
      // 174: if_icmpne 191
      // 177: goto 17b
      // 17a: athrow
      // 17b: aload 9
      // 17d: invokevirtual java/awt/Color.getRGB ()I
      // 180: dload 2
      // 181: invokestatic x/ocd2958dac48.ʲ (D)D
      // 184: ldc2_w 0.55
      // 187: invokestatic x/ocd2958dac48.Շ (IDD)I
      // 18a: goto 18e
      // 18d: athrow
      // 18e: goto 199
      // 191: aload 9
      // 193: aload 10
      // 195: dload 2
      // 196: invokestatic x/ocd2958dac48.ҧ (Ljava/awt/Color;Ljava/awt/Color;D)I
      // 199: ireturn
      // 19a: aload 9
      // 19c: invokevirtual java/awt/Color.getRGB ()I
      // 19f: ireturn
   }

   public static int ց(double param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 2
      // 04: getstatic x/ocd2958dac48.ƺ Lx/oca9cc61aada;
      // 07: iload 2
      // 08: ifne 1a
      // 0b: ifnonnull 17
      // 0e: goto 12
      // 11: athrow
      // 12: bipush 0
      // 13: goto 1e
      // 16: athrow
      // 17: getstatic x/ocd2958dac48.ƺ Lx/oca9cc61aada;
      // 1a: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 1d: d2i
      // 1e: istore 3
      // 1f: iload 3
      // 20: iload 2
      // 21: ifne 3b
      // 24: ldc_w 2139051851
      // 27: ldc_w 2139051849
      // 2a: ixor
      // 2b: if_icmpne 3c
      // 2e: goto 32
      // 31: athrow
      // 32: dconst_0
      // 33: dload 0
      // 34: invokestatic x/ocd2958dac48.ʰ (DD)I
      // 37: goto 3b
      // 3a: athrow
      // 3b: ireturn
      // 3c: invokestatic x/ocd2958dac48.ȓ ()Lx/oc5e96231df6;
      // 3f: astore 4
      // 41: aload 4
      // 43: iload 2
      // 44: ifne 50
      // 47: ifnull 57
      // 4a: goto 4e
      // 4d: athrow
      // 4e: aload 4
      // 50: invokevirtual x/oc5e96231df6.ҟ ()Ljava/awt/Color;
      // 53: invokevirtual java/awt/Color.getRGB ()I
      // 56: ireturn
      // 57: getstatic x/ocd2958dac48.у Lx/oc24a0a5bddf;
      // 5a: iload 2
      // 5b: ifne 72
      // 5e: ifnonnull 6f
      // 61: goto 65
      // 64: athrow
      // 65: getstatic java/awt/Color.WHITE Ljava/awt/Color;
      // 68: invokevirtual java/awt/Color.getRGB ()I
      // 6b: goto 75
      // 6e: athrow
      // 6f: getstatic x/ocd2958dac48.у Lx/oc24a0a5bddf;
      // 72: invokevirtual x/oc24a0a5bddf.ͳ ()I
      // 75: ireturn
   }

   public static int Ǝ(double param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 2
      // 04: getstatic x/ocd2958dac48.ƺ Lx/oca9cc61aada;
      // 07: iload 2
      // 08: ifne 1a
      // 0b: ifnonnull 17
      // 0e: goto 12
      // 11: athrow
      // 12: bipush 0
      // 13: goto 1e
      // 16: athrow
      // 17: getstatic x/ocd2958dac48.ƺ Lx/oca9cc61aada;
      // 1a: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 1d: d2i
      // 1e: istore 3
      // 1f: iload 3
      // 20: iload 2
      // 21: ifne 3f
      // 24: ldc_w 4493247
      // 27: ldc_w 4493245
      // 2a: ixor
      // 2b: if_icmpne 40
      // 2e: goto 32
      // 31: athrow
      // 32: dconst_0
      // 33: dload 0
      // 34: ldc2_w 50.0
      // 37: dadd
      // 38: invokestatic x/ocd2958dac48.ʰ (DD)I
      // 3b: goto 3f
      // 3e: athrow
      // 3f: ireturn
      // 40: invokestatic x/ocd2958dac48.ȓ ()Lx/oc5e96231df6;
      // 43: astore 4
      // 45: aload 4
      // 47: iload 2
      // 48: ifne 54
      // 4b: ifnull 5b
      // 4e: goto 52
      // 51: athrow
      // 52: aload 4
      // 54: invokevirtual x/oc5e96231df6.Ķ ()Ljava/awt/Color;
      // 57: invokevirtual java/awt/Color.getRGB ()I
      // 5a: ireturn
      // 5b: getstatic x/ocd2958dac48.ь Lx/oc24a0a5bddf;
      // 5e: iload 2
      // 5f: ifne 8f
      // 62: ifnonnull 8c
      // 65: goto 69
      // 68: athrow
      // 69: new java/awt/Color
      // 6c: dup
      // 6d: ldc_w 4493288
      // 70: ldc_w 4493245
      // 73: ixor
      // 74: ldc_w 4493288
      // 77: ldc_w 4493245
      // 7a: ixor
      // 7b: ldc_w 4493122
      // 7e: ldc_w 4493245
      // 81: ixor
      // 82: invokespecial java/awt/Color.<init> (III)V
      // 85: invokevirtual java/awt/Color.getRGB ()I
      // 88: goto 92
      // 8b: athrow
      // 8c: getstatic x/ocd2958dac48.ь Lx/oc24a0a5bddf;
      // 8f: invokevirtual x/oc24a0a5bddf.ͳ ()I
      // 92: ireturn
   }

   private static int ɼ(double param0, double param2, long param4, int param6) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/ocd2958dac48.Ѡ Lx/oc93499ec6de;
      // 003: getfield x/oc93499ec6de.Ɋ Lx/oca9cc61aada;
      // 006: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 009: dstore 8
      // 00b: getstatic x/ocd2958dac48.Ѡ Lx/oc93499ec6de;
      // 00e: getfield x/oc93499ec6de.ȩ Lx/oca9cc61aada;
      // 011: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 014: dstore 10
      // 016: getstatic x/oce6044968f8.ђ Z
      // 019: getstatic x/ocd2958dac48.Ѡ Lx/oc93499ec6de;
      // 01c: getfield x/oc93499ec6de.Ȃ Lx/oca9cc61aada;
      // 01f: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 022: invokestatic java/lang/Math.toRadians (D)D
      // 025: dstore 12
      // 027: istore 7
      // 029: getstatic x/ocd2958dac48.Ѡ Lx/oc93499ec6de;
      // 02c: getfield x/oc93499ec6de.ѫ Lx/oca9cc61aada;
      // 02f: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 032: d2i
      // 033: istore 14
      // 035: getstatic x/ocd2958dac48.Ѡ Lx/oc93499ec6de;
      // 038: getfield x/oc93499ec6de.ˤ Lx/occ2f8dff8d8;
      // 03b: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 03e: ifeq 048
      // 041: ldc2_w -1.0
      // 044: goto 049
      // 047: athrow
      // 048: dconst_1
      // 049: dstore 15
      // 04b: iload 6
      // 04d: iload 7
      // 04f: ifne 0d3
      // 052: ldc_w 144788773
      // 055: ldc_w 144788775
      // 058: ixor
      // 059: if_icmpne 0cf
      // 05c: goto 060
      // 05f: athrow
      // 060: iload 14
      // 062: iload 7
      // 064: ifne 079
      // 067: goto 06b
      // 06a: athrow
      // 06b: ifne 077
      // 06e: goto 072
      // 071: athrow
      // 072: dload 2
      // 073: goto 085
      // 076: athrow
      // 077: iload 14
      // 079: bipush 1
      // 07a: if_icmpne 082
      // 07d: dload 0
      // 07e: goto 085
      // 081: athrow
      // 082: dload 0
      // 083: dload 2
      // 084: dadd
      // 085: dstore 17
      // 087: lload 4
      // 089: l2d
      // 08a: dload 8
      // 08c: dmul
      // 08d: ldc2_w 3600.0
      // 090: ddiv
      // 091: dload 17
      // 093: dload 10
      // 095: dmul
      // 096: dload 15
      // 098: dmul
      // 099: ldc2_w 360.0
      // 09c: ddiv
      // 09d: dadd
      // 09e: getstatic x/ocd2958dac48.Ѡ Lx/oc93499ec6de;
      // 0a1: getfield x/oc93499ec6de.Ȃ Lx/oca9cc61aada;
      // 0a4: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0a7: ldc2_w 360.0
      // 0aa: ddiv
      // 0ab: dadd
      // 0ac: dstore 19
      // 0ae: dload 19
      // 0b0: dload 19
      // 0b2: invokestatic java/lang/Math.floor (D)D
      // 0b5: dsub
      // 0b6: d2f
      // 0b7: getstatic x/ocd2958dac48.Ѡ Lx/oc93499ec6de;
      // 0ba: getfield x/oc93499ec6de.խ Lx/oca9cc61aada;
      // 0bd: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0c0: d2f
      // 0c1: getstatic x/ocd2958dac48.Ѡ Lx/oc93499ec6de;
      // 0c4: getfield x/oc93499ec6de.ȷ Lx/oca9cc61aada;
      // 0c7: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0ca: d2f
      // 0cb: invokestatic java/awt/Color.HSBtoRGB (FFF)I
      // 0ce: ireturn
      // 0cf: dload 2
      // 0d0: invokestatic x/ocd2958dac48.ց (D)I
      // 0d3: istore 17
      // 0d5: iload 6
      // 0d7: iload 7
      // 0d9: ifne 0e9
      // 0dc: ifne 0e7
      // 0df: goto 0e3
      // 0e2: athrow
      // 0e3: iload 17
      // 0e5: ireturn
      // 0e6: athrow
      // 0e7: iload 14
      // 0e9: iload 7
      // 0eb: ifne 100
      // 0ee: ifne 0fe
      // 0f1: goto 0f5
      // 0f4: athrow
      // 0f5: dload 2
      // 0f6: ldc2_w 0.06
      // 0f9: dmul
      // 0fa: goto 118
      // 0fd: athrow
      // 0fe: iload 14
      // 100: bipush 1
      // 101: if_icmpne 10d
      // 104: dload 0
      // 105: ldc2_w 0.06
      // 108: dmul
      // 109: goto 118
      // 10c: athrow
      // 10d: dload 0
      // 10e: ldc2_w 0.005
      // 111: dmul
      // 112: dload 2
      // 113: ldc2_w 0.06
      // 116: dmul
      // 117: dadd
      // 118: dstore 18
      // 11a: lload 4
      // 11c: l2d
      // 11d: dload 8
      // 11f: dmul
      // 120: ldc2_w 600.0
      // 123: ddiv
      // 124: dload 18
      // 126: dload 10
      // 128: dmul
      // 129: dload 15
      // 12b: dmul
      // 12c: dadd
      // 12d: dload 12
      // 12f: dadd
      // 130: dstore 20
      // 132: iload 6
      // 134: iload 7
      // 136: ifne 15b
      // 139: ldc_w 144788772
      // 13c: ldc_w 144788775
      // 13f: ixor
      // 140: if_icmpne 15c
      // 143: goto 147
      // 146: athrow
      // 147: iload 17
      // 149: dload 20
      // 14b: getstatic x/ocd2958dac48.Ѡ Lx/oc93499ec6de;
      // 14e: getfield x/oc93499ec6de.Ά Lx/oca9cc61aada;
      // 151: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 154: invokestatic x/ocd2958dac48.Շ (IDD)I
      // 157: goto 15b
      // 15a: athrow
      // 15b: ireturn
      // 15c: dload 20
      // 15e: invokestatic java/lang/Math.sin (D)D
      // 161: ldc2_w 0.5
      // 164: dmul
      // 165: ldc2_w 0.5
      // 168: dadd
      // 169: d2f
      // 16a: fstore 22
      // 16c: invokestatic x/ocd2958dac48.ȓ ()Lx/oc5e96231df6;
      // 16f: astore 23
      // 171: aload 23
      // 173: iload 7
      // 175: ifne 181
      // 178: ifnull 1e2
      // 17b: goto 17f
      // 17e: athrow
      // 17f: aload 23
      // 181: invokevirtual x/oc5e96231df6.Ղ ()Ljava/awt/Color;
      // 184: invokevirtual java/awt/Color.getRGB ()I
      // 187: iload 7
      // 189: ifne 1ed
      // 18c: aload 23
      // 18e: invokevirtual x/oc5e96231df6.ҟ ()Ljava/awt/Color;
      // 191: invokevirtual java/awt/Color.getRGB ()I
      // 194: if_icmpeq 1e2
      // 197: goto 19b
      // 19a: athrow
      // 19b: fload 22
      // 19d: ldc_w 0.5
      // 1a0: fcmpg
      // 1a1: iload 7
      // 1a3: ifne 1ce
      // 1a6: goto 1aa
      // 1a9: athrow
      // 1aa: ifgt 1c6
      // 1ad: goto 1b1
      // 1b0: athrow
      // 1b1: aload 23
      // 1b3: invokevirtual x/oc5e96231df6.Ķ ()Ljava/awt/Color;
      // 1b6: invokevirtual java/awt/Color.getRGB ()I
      // 1b9: iload 17
      // 1bb: fload 22
      // 1bd: fconst_2
      // 1be: fmul
      // 1bf: invokestatic x/oc67aa5109f0.Ò (IIF)I
      // 1c2: goto 1e1
      // 1c5: athrow
      // 1c6: aload 23
      // 1c8: invokevirtual x/oc5e96231df6.Ղ ()Ljava/awt/Color;
      // 1cb: invokevirtual java/awt/Color.getRGB ()I
      // 1ce: aload 23
      // 1d0: invokevirtual x/oc5e96231df6.Ķ ()Ljava/awt/Color;
      // 1d3: invokevirtual java/awt/Color.getRGB ()I
      // 1d6: fload 22
      // 1d8: ldc_w 0.5
      // 1db: fsub
      // 1dc: fconst_2
      // 1dd: fmul
      // 1de: invokestatic x/oc67aa5109f0.Ò (IIF)I
      // 1e1: ireturn
      // 1e2: iload 17
      // 1e4: dload 2
      // 1e5: invokestatic x/ocd2958dac48.Ǝ (D)I
      // 1e8: fload 22
      // 1ea: invokestatic x/oc67aa5109f0.Ò (IIF)I
      // 1ed: ireturn
   }

   private static int Շ(int var0, double var1, double var3) {
      float var5 = (float)(var3 + (1.0 - var3) * (Math.sin(var1) * 0.5 + 0.5));
      return oc67aa5109f0.Ò(571916784 ^ -585711120, var0, var5);
   }

   private static int ҧ(Color var0, Color var1, double var2) {
      double var4 = Math.sin(ʲ(var2)) * 0.5 + 0.5;
      int var6 = (int)(var0.getRed() * (1.0 - var4) + var1.getRed() * var4);
      int var7 = (int)(var0.getGreen() * (1.0 - var4) + var1.getGreen() * var4);
      int var8 = (int)(var0.getBlue() * (1.0 - var4) + var1.getBlue() * var4);
      return new Color(var6, var7, var8).getRGB();
   }

   private static double ʲ(double var0) {
      return System.currentTimeMillis() / 600.0 + var0 * 0.06;
   }

   private static oc5e96231df6 ȓ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 0
      // 04: getstatic x/ocd2958dac48.Ě Lx/oca9cc61aada;
      // 07: iload 0
      // 08: ifne 1a
      // 0b: ifnonnull 17
      // 0e: goto 12
      // 11: athrow
      // 12: bipush 0
      // 13: goto 1e
      // 16: athrow
      // 17: getstatic x/ocd2958dac48.Ě Lx/oca9cc61aada;
      // 1a: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 1d: d2i
      // 1e: istore 1
      // 1f: iload 1
      // 20: iload 0
      // 21: ifne 3b
      // 24: ifle 3e
      // 27: goto 2b
      // 2a: athrow
      // 2b: getstatic x/ocd2958dac48.Ř [Lx/oc5e96231df6;
      // 2e: iload 0
      // 2f: ifne 44
      // 32: goto 36
      // 35: athrow
      // 36: arraylength
      // 37: goto 3b
      // 3a: athrow
      // 3b: ifne 41
      // 3e: aconst_null
      // 3f: areturn
      // 40: athrow
      // 41: getstatic x/ocd2958dac48.Ř [Lx/oc5e96231df6;
      // 44: iload 1
      // 45: bipush 1
      // 46: isub
      // 47: getstatic x/ocd2958dac48.Ř [Lx/oc5e96231df6;
      // 4a: arraylength
      // 4b: bipush 1
      // 4c: isub
      // 4d: invokestatic java/lang/Math.min (II)I
      // 50: aaload
      // 51: areturn
   }

   private static oc5e96231df6[] Ќ() {
      oc5e96231df6[] var0 = oc5e96231df6.values();
      oc5e96231df6[] var1 = new oc5e96231df6[Math.max(0, var0.length - 1)];
      int var2 = 0;

      for (oc5e96231df6 var6 : var0) {
         try {
            if (var6 != oc5e96231df6.Ѫ) {
               var1[var2++] = var6;
            }
         } catch (IllegalArgumentException var8) {
            throw var8;
         }
      }

      try {
         if (var2 == var1.length) {
            return var1;
         }
      } catch (IllegalArgumentException var7) {
         throw var7;
      }

      oc5e96231df6[] var9 = new oc5e96231df6[var2];
      System.arraycopy(var1, 0, var9, 0, var2);
      return var9;
   }

   private static String[] ҋ() {
      String[] var0 = new String[Ř.length + 1];
      var0[0] = "Custom";
      int var1 = 0;

      try {
         while (var1 < Ř.length) {
            var0[var1 + 1] = oc5e96231df6.ѻ[Ř[var1].ordinal()];
            var1++;
         }

         return var0;
      } catch (IllegalArgumentException var2) {
         throw var2;
      }
   }

   static {
      String[] var10000 = new String[-351281920 ^ -351281916];
      var10000[0] = "Static";
      var10000[1] = "Gradient";
      var10000[-351281914 ^ -351281916] = "Rainbow";
      var10000[-351281913 ^ -351281916] = "Breathe";
      ҷ = var10000;
      var10000 = new String[-351281913 ^ -351281916];
      var10000[0] = "None";
      var10000[1] = "Move in";
      var10000[-351281914 ^ -351281916] = "Scale in";
      ƚ = var10000;
   }
}

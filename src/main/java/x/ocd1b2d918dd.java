package x;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import org.lwjgl.opengl.GL11;

public class ocd1b2d918dd extends oc69da1aa7f5 {
   private static final String[] ƙ;
   private static final String[] я;
   private static final String[] Ù;
   private static final String[] Ť;
   private static final int Ӊ = 2;
   private static final int ͻ = 1;
   private static final int Ɠ = 0;
   public oca9cc61aada Ā;
   public oca9cc61aada Ǚ;
   public oc24a0a5bddf ɥ;
   public occ2f8dff8d8 ӯ;
   public occ2f8dff8d8 Й;
   public occc831eff22 Ǒ;
   public occ2f8dff8d8 Ž;
   public occ2f8dff8d8 մ;
   public occ2f8dff8d8 ô;
   public occ2f8dff8d8 Ќ;
   public occ2f8dff8d8 բ;
   public occ2f8dff8d8 ɶ;
   public oca9cc61aada ϯ;
   public occ2f8dff8d8 ʀ;
   public occ2f8dff8d8 ǟ;
   public occ2f8dff8d8 Ͷ;
   public occ2f8dff8d8 Ӱ;
   public occ2f8dff8d8 ǖ;
   public occc831eff22 ɣ;
   public occ2f8dff8d8 Ү;
   public occ2f8dff8d8 ӱ;
   public occ2f8dff8d8 ƈ;
   private final oca9cc61aada δ;
   private final oca9cc61aada ȓ;
   private final oca9cc61aada Ƒ;
   private final oca9cc61aada Վ;
   private final occ2f8dff8d8 Ǡ;
   private final occ2f8dff8d8 Ȧ;
   private final occ2f8dff8d8 ɺ;
   private final occ2f8dff8d8 ѡ;
   private final occ2f8dff8d8 Ή;
   private static final float Ҕ = (float) (180.0 / Math.PI);
   public static boolean F = false;
   private final List<oc55bd31ebd1> ɴ = new ArrayList<>();
   private final List<oc55bd31ebd1> Ʃ = new ArrayList<>();
   private final Map<EntityPlayer, oc55bd31ebd1> D = new HashMap<>();
   private final double[] Ƽ = new double[1498998005 ^ 1498998006];
   private oc29a4412fc2 Ȕ;
   private int ӹ;
   private int Β;
   private Framebuffer Ń;
   private final oc66e0225688 Ō = new oc66e0225688();
   private final oc98d1de20cf Ѧ = new oc98d1de20cf();
   public static boolean Ϗ;

   public ocd1b2d918dd() {
      super("PlayerESP", oce4cea752dd.Ŏ, 0);
      this.ą("Highlights players through walls.");
      this.ʌ(this.Ā = new oca9cc61aada("Mode", 0, ƙ));
      this.ʌ(this.Ǚ = new oca9cc61aada("Thickness", "x", 1.0, 0.25, 2.0, 0.05));
      this.ʌ(this.Ǒ = new occc831eff22("Types"));
      this.ʌ(this.Ž = new occ2f8dff8d8(this.Ǒ, "2D", false));
      this.ʌ(this.մ = new occ2f8dff8d8(this.Ǒ, "Box", false));
      this.ʌ(this.Ќ = new occ2f8dff8d8(this.Ǒ, "Outline", false));
      this.ʌ(this.ɶ = new occ2f8dff8d8(this.Ǒ, "Ring", false));
      this.ʌ(this.բ = new occ2f8dff8d8(this.Ǒ, "Shaded", false));
      String[] var10006 = new String[1498998002 ^ 1498998006];
      var10006[0] = "Box";
      var10006[1] = "Corner A";
      var10006[1498998004 ^ 1498998006] = "Corner B";
      var10006[1498998005 ^ 1498998006] = "Split";
      this.ʌ(this.ϯ = new oca9cc61aada("Box Style", 0, var10006));
      this.ʌ(this.ʀ = new occ2f8dff8d8("Names", false));
      this.ʌ(this.ǟ = new occ2f8dff8d8("Armor", false));
      this.ʌ(this.Ͷ = new occ2f8dff8d8("Items", false));
      this.ʌ(this.Ӱ = new occ2f8dff8d8("Item Icons", false));
      this.ʌ(this.ɥ = new oc24a0a5bddf("Color", 0, 1498997769 ^ 1498998006, 0));
      this.ʌ(this.Й = new occ2f8dff8d8("Rainbow", false));
      this.ʌ(this.ô = new occ2f8dff8d8("Health bar", true));
      this.ʌ(this.ǖ = new occ2f8dff8d8("Red on damage", true));
      this.ʌ(this.ӯ = new occ2f8dff8d8("Team color", false));
      this.ʌ(this.ɣ = new occc831eff22("Targets"));
      this.ʌ(this.Ү = new occ2f8dff8d8(this.ɣ, "Render self", false));
      this.ʌ(this.ӱ = new occ2f8dff8d8(this.ɣ, "Show invis", true));
      this.ʌ(this.ƈ = new occ2f8dff8d8(this.ɣ, "Show Teammate", true));
      this.ʌ(this.δ = new oca9cc61aada("Max distance", 128.0, 32.0, 256.0, 8.0));
      this.ʌ(this.ȓ = new oca9cc61aada("ESP style", 1498998004 ^ 1498998006, я));
      this.ʌ(this.Ƒ = new oca9cc61aada("ESP color", 0, Ù));
      this.ʌ(this.Վ = new oca9cc61aada("ESP health bar", 0, Ť));
      this.ʌ(this.Ǡ = new occ2f8dff8d8("Players", true));
      this.ʌ(this.Ȧ = new occ2f8dff8d8("Friends", true));
      this.ʌ(this.ɺ = new occ2f8dff8d8("Enemies", true));
      this.ʌ(this.ѡ = new occ2f8dff8d8("Self", false));
      this.ʌ(this.Ή = new occ2f8dff8d8("Bots", false));
      this.z$2u87utkr1isxg();
   }

   @Override
   public String getInfo() {
      return ƙ[(int)this.Ā.Ӂ()];
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
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: aload 0
      // 004: invokevirtual x/ocd1b2d918dd.ϱ ()Z
      // 007: istore 2
      // 008: aload 0
      // 009: invokevirtual x/ocd1b2d918dd.ǌ ()Z
      // 00c: istore 3
      // 00d: istore 1
      // 00e: aload 0
      // 00f: getfield x/ocd1b2d918dd.ɣ Lx/occc831eff22;
      // 012: iload 3
      // 013: iload 1
      // 014: ifne 01f
      // 017: ifne 022
      // 01a: goto 01e
      // 01d: athrow
      // 01e: bipush 1
      // 01f: goto 023
      // 022: bipush 0
      // 023: aload 0
      // 024: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 027: aload 0
      // 028: getfield x/ocd1b2d918dd.Ǚ Lx/oca9cc61aada;
      // 02b: aload 0
      // 02c: invokevirtual x/ocd1b2d918dd.ӏ ()Z
      // 02f: aload 0
      // 030: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 033: aload 0
      // 034: getfield x/ocd1b2d918dd.Ǒ Lx/occc831eff22;
      // 037: iload 2
      // 038: aload 0
      // 039: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 03c: aload 0
      // 03d: getfield x/ocd1b2d918dd.Ž Lx/occ2f8dff8d8;
      // 040: iload 2
      // 041: aload 0
      // 042: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 045: aload 0
      // 046: getfield x/ocd1b2d918dd.մ Lx/occ2f8dff8d8;
      // 049: iload 2
      // 04a: aload 0
      // 04b: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 04e: aload 0
      // 04f: getfield x/ocd1b2d918dd.Ќ Lx/occ2f8dff8d8;
      // 052: iload 2
      // 053: aload 0
      // 054: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 057: aload 0
      // 058: getfield x/ocd1b2d918dd.ɶ Lx/occ2f8dff8d8;
      // 05b: iload 2
      // 05c: aload 0
      // 05d: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 060: aload 0
      // 061: iload 1
      // 062: ifne 083
      // 065: getfield x/ocd1b2d918dd.բ Lx/occ2f8dff8d8;
      // 068: iload 2
      // 069: aload 0
      // 06a: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 06d: aload 0
      // 06e: getfield x/ocd1b2d918dd.ô Lx/occ2f8dff8d8;
      // 071: iload 2
      // 072: aload 0
      // 073: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 076: iload 2
      // 077: ifeq 098
      // 07a: goto 07e
      // 07d: athrow
      // 07e: aload 0
      // 07f: goto 083
      // 082: athrow
      // 083: getfield x/ocd1b2d918dd.Ž Lx/occ2f8dff8d8;
      // 086: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 089: iload 1
      // 08a: ifne 095
      // 08d: ifeq 098
      // 090: goto 094
      // 093: athrow
      // 094: bipush 1
      // 095: goto 099
      // 098: bipush 0
      // 099: istore 4
      // 09b: aload 0
      // 09c: getfield x/ocd1b2d918dd.ϯ Lx/oca9cc61aada;
      // 09f: iload 4
      // 0a1: aload 0
      // 0a2: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0a5: aload 0
      // 0a6: getfield x/ocd1b2d918dd.ʀ Lx/occ2f8dff8d8;
      // 0a9: iload 4
      // 0ab: aload 0
      // 0ac: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0af: aload 0
      // 0b0: getfield x/ocd1b2d918dd.ǟ Lx/occ2f8dff8d8;
      // 0b3: iload 4
      // 0b5: aload 0
      // 0b6: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0b9: aload 0
      // 0ba: getfield x/ocd1b2d918dd.Ͷ Lx/occ2f8dff8d8;
      // 0bd: iload 4
      // 0bf: aload 0
      // 0c0: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0c3: aload 0
      // 0c4: getfield x/ocd1b2d918dd.Ӱ Lx/occ2f8dff8d8;
      // 0c7: iload 4
      // 0c9: aload 0
      // 0ca: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0cd: aload 0
      // 0ce: getfield x/ocd1b2d918dd.ȓ Lx/oca9cc61aada;
      // 0d1: iload 3
      // 0d2: aload 0
      // 0d3: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0d6: aload 0
      // 0d7: getfield x/ocd1b2d918dd.Ƒ Lx/oca9cc61aada;
      // 0da: iload 3
      // 0db: aload 0
      // 0dc: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0df: aload 0
      // 0e0: getfield x/ocd1b2d918dd.Վ Lx/oca9cc61aada;
      // 0e3: iload 3
      // 0e4: aload 0
      // 0e5: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0e8: aload 0
      // 0e9: getfield x/ocd1b2d918dd.Ǡ Lx/occ2f8dff8d8;
      // 0ec: iload 3
      // 0ed: aload 0
      // 0ee: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0f1: aload 0
      // 0f2: getfield x/ocd1b2d918dd.Ȧ Lx/occ2f8dff8d8;
      // 0f5: iload 3
      // 0f6: aload 0
      // 0f7: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0fa: aload 0
      // 0fb: getfield x/ocd1b2d918dd.ɺ Lx/occ2f8dff8d8;
      // 0fe: iload 3
      // 0ff: iload 1
      // 100: ifne 12a
      // 103: aload 0
      // 104: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 107: aload 0
      // 108: getfield x/ocd1b2d918dd.ѡ Lx/occ2f8dff8d8;
      // 10b: iload 3
      // 10c: aload 0
      // 10d: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 110: aload 0
      // 111: getfield x/ocd1b2d918dd.Ή Lx/occ2f8dff8d8;
      // 114: iload 3
      // 115: aload 0
      // 116: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 119: aload 0
      // 11a: getfield x/ocd1b2d918dd.Ү Lx/occ2f8dff8d8;
      // 11d: iload 3
      // 11e: ifne 12d
      // 121: goto 125
      // 124: athrow
      // 125: bipush 1
      // 126: goto 12a
      // 129: athrow
      // 12a: goto 12e
      // 12d: bipush 0
      // 12e: aload 0
      // 12f: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 132: aload 0
      // 133: getfield x/ocd1b2d918dd.ɥ Lx/oc24a0a5bddf;
      // 136: iload 3
      // 137: iload 1
      // 138: ifne 143
      // 13b: ifne 146
      // 13e: goto 142
      // 141: athrow
      // 142: bipush 1
      // 143: goto 147
      // 146: bipush 0
      // 147: aload 0
      // 148: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 14b: aload 0
      // 14c: getfield x/ocd1b2d918dd.Й Lx/occ2f8dff8d8;
      // 14f: iload 3
      // 150: iload 1
      // 151: ifne 15c
      // 154: ifne 15f
      // 157: goto 15b
      // 15a: athrow
      // 15b: bipush 1
      // 15c: goto 160
      // 15f: bipush 0
      // 160: aload 0
      // 161: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 164: aload 0
      // 165: getfield x/ocd1b2d918dd.ӯ Lx/occ2f8dff8d8;
      // 168: iload 3
      // 169: iload 1
      // 16a: ifne 175
      // 16d: ifne 178
      // 170: goto 174
      // 173: athrow
      // 174: bipush 1
      // 175: goto 179
      // 178: bipush 0
      // 179: aload 0
      // 17a: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 17d: aload 0
      // 17e: getfield x/ocd1b2d918dd.ǖ Lx/occ2f8dff8d8;
      // 181: iload 3
      // 182: iload 1
      // 183: ifne 18e
      // 186: ifne 191
      // 189: goto 18d
      // 18c: athrow
      // 18d: bipush 1
      // 18e: goto 192
      // 191: bipush 0
      // 192: aload 0
      // 193: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 196: aload 0
      // 197: getfield x/ocd1b2d918dd.ӱ Lx/occ2f8dff8d8;
      // 19a: iload 3
      // 19b: iload 1
      // 19c: ifne 1a7
      // 19f: ifne 1aa
      // 1a2: goto 1a6
      // 1a5: athrow
      // 1a6: bipush 1
      // 1a7: goto 1ab
      // 1aa: bipush 0
      // 1ab: aload 0
      // 1ac: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 1af: aload 0
      // 1b0: getfield x/ocd1b2d918dd.ƈ Lx/occ2f8dff8d8;
      // 1b3: iload 3
      // 1b4: iload 1
      // 1b5: ifne 1c0
      // 1b8: ifne 1c3
      // 1bb: goto 1bf
      // 1be: athrow
      // 1bf: bipush 1
      // 1c0: goto 1c4
      // 1c3: bipush 0
      // 1c4: aload 0
      // 1c5: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 1c8: aload 0
      // 1c9: getfield x/ocd1b2d918dd.δ Lx/oca9cc61aada;
      // 1cc: iload 3
      // 1cd: iload 1
      // 1ce: ifne 1d9
      // 1d1: ifne 1dc
      // 1d4: goto 1d8
      // 1d7: athrow
      // 1d8: bipush 1
      // 1d9: goto 1dd
      // 1dc: bipush 0
      // 1dd: aload 0
      // 1de: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 1e1: bipush 0
      // 1e2: ifeq 1f6
      // 1e5: iload 1
      // 1e6: ifeq 1f2
      // 1e9: goto 1ed
      // 1ec: athrow
      // 1ed: bipush 0
      // 1ee: goto 1f3
      // 1f1: athrow
      // 1f2: bipush 1
      // 1f3: putstatic x/oce6044968f8.ђ Z
      // 1f6: return
   }

   @Override
   public void z$1sehylui0i4ix(oca9cc61aada var1) {
      try {
         if (var1 == this.Ā) {
            this.z$2u87utkr1isxg();
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }
   }

   @Override
   public void z$3tl278wzjcayb(N var1) {
      try {
         if (var1 == this.Ā) {
            this.z$2u87utkr1isxg();
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }
   }

   @Override
   public void guiButtonToggled(occ2f8dff8d8 var1) {
      try {
         if (var1 == this.Ž) {
            this.z$2u87utkr1isxg();
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }

      super.guiButtonToggled(var1);
   }

   public boolean ϱ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 1
      // 04: aload 0
      // 05: getfield x/ocd1b2d918dd.Ā Lx/oca9cc61aada;
      // 08: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0b: d2i
      // 0c: iload 1
      // 0d: ifne 23
      // 10: ldc_w -974897236
      // 13: ldc_w -974897234
      // 16: ixor
      // 17: if_icmpne 26
      // 1a: goto 1e
      // 1d: athrow
      // 1e: bipush 1
      // 1f: goto 23
      // 22: athrow
      // 23: goto 27
      // 26: bipush 0
      // 27: ireturn
   }

   boolean ǌ() {
      boolean var1 = oce6044968f8.ђ;

      try {
         int var10000 = (int)this.Ā.Ӂ();
         if (var1) {
            return (boolean)var10000;
         }

         if (var10000 == 0) {
            return (boolean)1;
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }

      return (boolean)0;
   }

   boolean ӏ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 1
      // 04: aload 0
      // 05: getfield x/ocd1b2d918dd.Ā Lx/oca9cc61aada;
      // 08: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0b: d2i
      // 0c: iload 1
      // 0d: ifne 1d
      // 10: bipush 1
      // 11: if_icmpne 20
      // 14: goto 18
      // 17: athrow
      // 18: bipush 1
      // 19: goto 1d
      // 1c: athrow
      // 1d: goto 21
      // 20: bipush 0
      // 21: ireturn
   }

   @Override
   public void onDisable() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: bipush 0
      // 04: putstatic x/ocd1b2d918dd.F Z
      // 07: istore 1
      // 08: aload 0
      // 09: iload 1
      // 0a: ifne 27
      // 0d: invokevirtual x/ocd1b2d918dd.ǔ ()V
      // 10: aload 0
      // 11: getfield x/ocd1b2d918dd.Ń Lnet/minecraft/client/shader/Framebuffer;
      // 14: ifnull 2b
      // 17: goto 1b
      // 1a: athrow
      // 1b: aload 0
      // 1c: getfield x/ocd1b2d918dd.Ń Lnet/minecraft/client/shader/Framebuffer;
      // 1f: invokevirtual net/minecraft/client/shader/Framebuffer.deleteFramebuffer ()V
      // 22: aload 0
      // 23: goto 27
      // 26: athrow
      // 27: aconst_null
      // 28: putfield x/ocd1b2d918dd.Ń Lnet/minecraft/client/shader/Framebuffer;
      // 2b: return
   }

   @oc66fa4f2195
   public void ʌ(oc9adb807c19 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 1
      // 01: getfield x/ocb508b4e274.Ұ Lx/oc110d7f376c;
      // 04: getstatic x/oc110d7f376c.END Lx/oc110d7f376c;
      // 07: if_acmpeq 0c
      // 0a: return
      // 0b: athrow
      // 0c: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 0f: ifeq 1f
      // 12: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 15: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 18: ifnonnull 25
      // 1b: goto 1f
      // 1e: athrow
      // 1f: aload 0
      // 20: invokevirtual x/ocd1b2d918dd.ǔ ()V
      // 23: return
      // 24: athrow
      // 25: aload 0
      // 26: invokevirtual x/ocd1b2d918dd.Ͱ ()V
      // 29: return
   }

   @oc66fa4f2195
   public void ļ(ocd056cee4b3 param1) {
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
      // 05: invokevirtual x/ocd1b2d918dd.ӏ ()Z
      // 08: ifeq 2e
      // 0b: aload 1
      // 0c: getfield x/oc3554d45dcf.Ǥ Lnet/minecraft/client/entity/AbstractClientPlayer;
      // 0f: ifnull 2e
      // 12: goto 16
      // 15: athrow
      // 16: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 19: iload 2
      // 1a: ifne 2b
      // 1d: goto 21
      // 20: athrow
      // 21: ifeq 2e
      // 24: goto 28
      // 27: athrow
      // 28: getstatic x/ocd1b2d918dd.F Z
      // 2b: ifeq 2f
      // 2e: return
      // 2f: aload 0
      // 30: getfield x/ocd1b2d918dd.D Ljava/util/Map;
      // 33: aload 1
      // 34: getfield x/oc3554d45dcf.Ǥ Lnet/minecraft/client/entity/AbstractClientPlayer;
      // 37: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 3c: checkcast x/oc55bd31ebd1
      // 3f: astore 3
      // 40: aload 3
      // 41: ifnonnull 46
      // 44: return
      // 45: athrow
      // 46: aload 0
      // 47: aload 3
      // 48: invokevirtual x/ocd1b2d918dd.ө (Lx/oc55bd31ebd1;)I
      // 4b: istore 4
      // 4d: iload 2
      // 4e: ifne 9f
      // 51: aload 0
      // 52: getfield x/ocd1b2d918dd.ǖ Lx/occ2f8dff8d8;
      // 55: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 58: ifeq 7e
      // 5b: goto 5f
      // 5e: athrow
      // 5f: aload 1
      // 60: getfield x/oc3554d45dcf.Ǥ Lnet/minecraft/client/entity/AbstractClientPlayer;
      // 63: getfield net/minecraft/client/entity/AbstractClientPlayer.hurtTime I
      // 66: iload 2
      // 67: ifne 7c
      // 6a: goto 6e
      // 6d: athrow
      // 6e: ifeq 7e
      // 71: goto 75
      // 74: athrow
      // 75: ldc_w 260782327
      // 78: ldc_w -260818697
      // 7b: ixor
      // 7c: istore 4
      // 7e: aload 0
      // 7f: aload 1
      // 80: getfield x/oc3554d45dcf.Ǥ Lnet/minecraft/client/entity/AbstractClientPlayer;
      // 83: aload 1
      // 84: getfield x/oc3554d45dcf.Ұ Lnet/minecraft/client/renderer/entity/RenderPlayer;
      // 87: invokevirtual net/minecraft/client/renderer/entity/RenderPlayer.getMainModel ()Lnet/minecraft/client/model/ModelPlayer;
      // 8a: iload 4
      // 8c: aload 1
      // 8d: getfield x/oc3554d45dcf.ʏ F
      // 90: aload 1
      // 91: getfield x/oc3554d45dcf.Ӽ D
      // 94: aload 1
      // 95: getfield x/oc3554d45dcf.է D
      // 98: aload 1
      // 99: getfield x/oc3554d45dcf.ѡ D
      // 9c: invokevirtual x/ocd1b2d918dd.ʐ (Lnet/minecraft/entity/player/EntityPlayer;Lnet/minecraft/client/model/ModelBiped;IFDDD)V
      // 9f: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGHEST
   )
   public void ԕ(oc746a23b244 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: istore 2
      // 004: aload 0
      // 005: iload 2
      // 006: ifne 01c
      // 009: bipush 0
      // 00a: putfield x/ocd1b2d918dd.Β I
      // 00d: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 010: ifeq 03d
      // 013: goto 017
      // 016: athrow
      // 017: aload 0
      // 018: goto 01c
      // 01b: athrow
      // 01c: iload 2
      // 01d: ifne 040
      // 020: invokevirtual x/ocd1b2d918dd.ϱ ()Z
      // 023: ifne 03f
      // 026: goto 02a
      // 029: athrow
      // 02a: aload 0
      // 02b: iload 2
      // 02c: ifne 040
      // 02f: goto 033
      // 032: athrow
      // 033: invokevirtual x/ocd1b2d918dd.ǌ ()Z
      // 036: ifne 03f
      // 039: goto 03d
      // 03c: athrow
      // 03d: return
      // 03e: athrow
      // 03f: aload 0
      // 040: invokevirtual x/ocd1b2d918dd.ǌ ()Z
      // 043: istore 3
      // 044: aload 0
      // 045: getfield x/ocd1b2d918dd.ȓ Lx/oca9cc61aada;
      // 048: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 04b: d2i
      // 04c: istore 4
      // 04e: iload 3
      // 04f: iload 2
      // 050: ifne 0d3
      // 053: ifeq 0cc
      // 056: goto 05a
      // 059: athrow
      // 05a: iload 4
      // 05c: iload 2
      // 05d: ifne 0c5
      // 060: goto 064
      // 063: athrow
      // 064: ldc_w 44887297
      // 067: ldc_w 44887299
      // 06a: ixor
      // 06b: if_icmpeq 0c0
      // 06e: goto 072
      // 071: athrow
      // 072: iload 4
      // 074: iload 2
      // 075: ifne 0c5
      // 078: goto 07c
      // 07b: athrow
      // 07c: ldc_w 44887303
      // 07f: ldc_w 44887299
      // 082: ixor
      // 083: if_icmpeq 0c0
      // 086: goto 08a
      // 089: athrow
      // 08a: iload 4
      // 08c: iload 2
      // 08d: ifne 0c5
      // 090: goto 094
      // 093: athrow
      // 094: ldc_w 44887302
      // 097: ldc_w 44887299
      // 09a: ixor
      // 09b: if_icmpeq 0c0
      // 09e: goto 0a2
      // 0a1: athrow
      // 0a2: aload 0
      // 0a3: getfield x/ocd1b2d918dd.Վ Lx/oca9cc61aada;
      // 0a6: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0a9: d2i
      // 0aa: iload 2
      // 0ab: ifne 0c9
      // 0ae: goto 0b2
      // 0b1: athrow
      // 0b2: ldc_w 44887297
      // 0b5: ldc_w 44887299
      // 0b8: ixor
      // 0b9: if_icmpne 0c8
      // 0bc: goto 0c0
      // 0bf: athrow
      // 0c0: bipush 1
      // 0c1: goto 0c5
      // 0c4: athrow
      // 0c5: goto 125
      // 0c8: bipush 0
      // 0c9: goto 125
      // 0cc: aload 0
      // 0cd: getfield x/ocd1b2d918dd.մ Lx/occ2f8dff8d8;
      // 0d0: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0d3: iload 2
      // 0d4: ifne 121
      // 0d7: ifne 120
      // 0da: goto 0de
      // 0dd: athrow
      // 0de: aload 0
      // 0df: getfield x/ocd1b2d918dd.բ Lx/occ2f8dff8d8;
      // 0e2: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0e5: iload 2
      // 0e6: ifne 121
      // 0e9: goto 0ed
      // 0ec: athrow
      // 0ed: ifne 120
      // 0f0: goto 0f4
      // 0f3: athrow
      // 0f4: aload 0
      // 0f5: getfield x/ocd1b2d918dd.ô Lx/occ2f8dff8d8;
      // 0f8: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0fb: iload 2
      // 0fc: ifne 121
      // 0ff: goto 103
      // 102: athrow
      // 103: ifne 120
      // 106: goto 10a
      // 109: athrow
      // 10a: aload 0
      // 10b: getfield x/ocd1b2d918dd.ɶ Lx/occ2f8dff8d8;
      // 10e: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 111: iload 2
      // 112: ifne 121
      // 115: goto 119
      // 118: athrow
      // 119: ifeq 124
      // 11c: goto 120
      // 11f: athrow
      // 120: bipush 1
      // 121: goto 125
      // 124: bipush 0
      // 125: istore 5
      // 127: iload 3
      // 128: iload 2
      // 129: ifne 188
      // 12c: ifeq 181
      // 12f: goto 133
      // 132: athrow
      // 133: iload 4
      // 135: iload 2
      // 136: ifne 17a
      // 139: goto 13d
      // 13c: athrow
      // 13d: bipush 1
      // 13e: if_icmpeq 175
      // 141: goto 145
      // 144: athrow
      // 145: iload 4
      // 147: iload 2
      // 148: ifne 17a
      // 14b: goto 14f
      // 14e: athrow
      // 14f: ldc_w 44887296
      // 152: ldc_w 44887299
      // 155: ixor
      // 156: if_icmpeq 175
      // 159: goto 15d
      // 15c: athrow
      // 15d: aload 0
      // 15e: getfield x/ocd1b2d918dd.Վ Lx/oca9cc61aada;
      // 161: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 164: d2i
      // 165: iload 2
      // 166: ifne 17e
      // 169: goto 16d
      // 16c: athrow
      // 16d: bipush 1
      // 16e: if_icmpne 17d
      // 171: goto 175
      // 174: athrow
      // 175: bipush 1
      // 176: goto 17a
      // 179: athrow
      // 17a: goto 1ae
      // 17d: bipush 0
      // 17e: goto 1ae
      // 181: aload 0
      // 182: getfield x/ocd1b2d918dd.Ќ Lx/occ2f8dff8d8;
      // 185: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 188: iload 2
      // 189: ifne 1aa
      // 18c: ifne 1a9
      // 18f: goto 193
      // 192: athrow
      // 193: aload 0
      // 194: getfield x/ocd1b2d918dd.Ž Lx/occ2f8dff8d8;
      // 197: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 19a: iload 2
      // 19b: ifne 1aa
      // 19e: goto 1a2
      // 1a1: athrow
      // 1a2: ifeq 1ad
      // 1a5: goto 1a9
      // 1a8: athrow
      // 1a9: bipush 1
      // 1aa: goto 1ae
      // 1ad: bipush 0
      // 1ae: istore 6
      // 1b0: aload 0
      // 1b1: getfield x/ocd1b2d918dd.ӹ I
      // 1b4: iload 2
      // 1b5: ifne 1c1
      // 1b8: ifeq 1dd
      // 1bb: goto 1bf
      // 1be: athrow
      // 1bf: iload 5
      // 1c1: iload 2
      // 1c2: ifne 1df
      // 1c5: ifne 1de
      // 1c8: goto 1cc
      // 1cb: athrow
      // 1cc: iload 6
      // 1ce: iload 2
      // 1cf: ifne 1df
      // 1d2: goto 1d6
      // 1d5: athrow
      // 1d6: ifne 1de
      // 1d9: goto 1dd
      // 1dc: athrow
      // 1dd: return
      // 1de: bipush 0
      // 1df: istore 7
      // 1e1: iload 7
      // 1e3: aload 0
      // 1e4: getfield x/ocd1b2d918dd.ӹ I
      // 1e7: if_icmpge 2cc
      // 1ea: aload 0
      // 1eb: getfield x/ocd1b2d918dd.ɴ Ljava/util/List;
      // 1ee: iload 7
      // 1f0: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 1f5: checkcast x/oc55bd31ebd1
      // 1f8: astore 8
      // 1fa: iload 2
      // 1fb: aload 8
      // 1fd: getfield x/oc55bd31ebd1.ň Lnet/minecraft/entity/EntityLivingBase;
      // 200: astore 9
      // 202: ifne 2c8
      // 205: aload 9
      // 207: ifnull 2c5
      // 20a: goto 20e
      // 20d: athrow
      // 20e: iload 3
      // 20f: iload 2
      // 210: ifne 256
      // 213: goto 217
      // 216: athrow
      // 217: ifeq 251
      // 21a: goto 21e
      // 21d: athrow
      // 21e: aload 9
      // 220: getfield net/minecraft/entity/EntityLivingBase.ignoreFrustumCheck Z
      // 223: iload 2
      // 224: ifne 27a
      // 227: goto 22b
      // 22a: athrow
      // 22b: ifne 269
      // 22e: goto 232
      // 231: athrow
      // 232: aload 9
      // 234: invokevirtual net/minecraft/entity/EntityLivingBase.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 237: ldc2_w 0.1
      // 23a: ldc2_w 0.1
      // 23d: ldc2_w 0.1
      // 240: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 243: invokestatic x/ocbd4917c4b1.ӥ (Lnet/minecraft/util/AxisAlignedBB;)Z
      // 246: ifeq 2c5
      // 249: goto 24d
      // 24c: athrow
      // 24d: goto 269
      // 250: athrow
      // 251: aload 9
      // 253: invokestatic x/ocbd4917c4b1.ž (Lnet/minecraft/entity/Entity;)Z
      // 256: iload 2
      // 257: ifne 27a
      // 25a: ifne 269
      // 25d: goto 261
      // 260: athrow
      // 261: iload 2
      // 262: ifeq 2c5
      // 265: goto 269
      // 268: athrow
      // 269: aload 8
      // 26b: aload 0
      // 26c: aload 8
      // 26e: invokevirtual x/ocd1b2d918dd.ө (Lx/oc55bd31ebd1;)I
      // 271: putfield x/oc55bd31ebd1.ƕ I
      // 274: iload 5
      // 276: goto 27a
      // 279: athrow
      // 27a: iload 2
      // 27b: ifne 2b8
      // 27e: ifeq 2b6
      // 281: goto 285
      // 284: athrow
      // 285: iload 3
      // 286: ifeq 2a7
      // 289: goto 28d
      // 28c: athrow
      // 28d: aload 0
      // 28e: aload 9
      // 290: checkcast net/minecraft/entity/player/EntityPlayer
      // 293: aload 8
      // 295: getfield x/oc55bd31ebd1.ƕ I
      // 298: aload 1
      // 299: getfield x/oc746a23b244.Ё F
      // 29c: invokevirtual x/ocd1b2d918dd.Ӄ (Lnet/minecraft/entity/player/EntityPlayer;IF)V
      // 29f: iload 2
      // 2a0: ifeq 2b6
      // 2a3: goto 2a7
      // 2a6: athrow
      // 2a7: aload 0
      // 2a8: aload 9
      // 2aa: aload 8
      // 2ac: getfield x/oc55bd31ebd1.ƕ I
      // 2af: invokevirtual x/ocd1b2d918dd.Ж (Lnet/minecraft/entity/Entity;I)V
      // 2b2: goto 2b6
      // 2b5: athrow
      // 2b6: iload 6
      // 2b8: ifeq 2c5
      // 2bb: aload 0
      // 2bc: aload 8
      // 2be: invokevirtual x/ocd1b2d918dd.ԡ (Lx/oc55bd31ebd1;)V
      // 2c1: goto 2c5
      // 2c4: athrow
      // 2c5: iinc 7 1
      // 2c8: iload 2
      // 2c9: ifeq 1e1
      // 2cc: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.LOWEST
   )
   public void ϗ(oc746a23b244 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 2
      // 04: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 07: iload 2
      // 08: ifne 22
      // 0b: ifeq 4b
      // 0e: goto 12
      // 11: athrow
      // 12: aload 0
      // 13: iload 2
      // 14: ifne 3d
      // 17: goto 1b
      // 1a: athrow
      // 1b: invokevirtual x/ocd1b2d918dd.ϱ ()Z
      // 1e: goto 22
      // 21: athrow
      // 22: ifne 38
      // 25: aload 0
      // 26: iload 2
      // 27: ifne 3d
      // 2a: goto 2e
      // 2d: athrow
      // 2e: invokevirtual x/ocd1b2d918dd.ǌ ()Z
      // 31: ifeq 4b
      // 34: goto 38
      // 37: athrow
      // 38: aload 0
      // 39: goto 3d
      // 3c: athrow
      // 3d: iload 2
      // 3e: ifne 4e
      // 41: getfield x/ocd1b2d918dd.Β I
      // 44: ifne 4d
      // 47: goto 4b
      // 4a: athrow
      // 4b: return
      // 4c: athrow
      // 4d: aload 0
      // 4e: iload 2
      // 4f: ifne c0
      // 52: invokevirtual x/ocd1b2d918dd.ǌ ()Z
      // 55: ifeq bf
      // 58: goto 5c
      // 5b: athrow
      // 5c: aload 0
      // 5d: getfield x/ocd1b2d918dd.ȓ Lx/oca9cc61aada;
      // 60: iload 2
      // 61: ifne 92
      // 64: goto 68
      // 67: athrow
      // 68: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 6b: d2i
      // 6c: ldc_w -110266897
      // 6f: ldc_w -110266900
      // 72: ixor
      // 73: if_icmpne 86
      // 76: goto 7a
      // 79: athrow
      // 7a: aload 0
      // 7b: aload 1
      // 7c: getfield x/oc746a23b244.Ё F
      // 7f: invokevirtual x/ocd1b2d918dd.ώ (F)V
      // 82: goto 86
      // 85: athrow
      // 86: aload 0
      // 87: iload 2
      // 88: ifne b7
      // 8b: getfield x/ocd1b2d918dd.ȓ Lx/oca9cc61aada;
      // 8e: goto 92
      // 91: athrow
      // 92: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 95: d2i
      // 96: bipush 1
      // 97: if_icmpeq b2
      // 9a: aload 0
      // 9b: iload 2
      // 9c: ifne b7
      // 9f: goto a3
      // a2: athrow
      // a3: getfield x/ocd1b2d918dd.Վ Lx/oca9cc61aada;
      // a6: invokevirtual x/oca9cc61aada.Ӂ ()D
      // a9: d2i
      // aa: bipush 1
      // ab: if_icmpne be
      // ae: goto b2
      // b1: athrow
      // b2: aload 0
      // b3: goto b7
      // b6: athrow
      // b7: aload 1
      // b8: getfield x/oc746a23b244.Ё F
      // bb: invokevirtual x/ocd1b2d918dd.Ų (F)V
      // be: return
      // bf: aload 0
      // c0: iload 2
      // c1: ifne de
      // c4: getfield x/ocd1b2d918dd.Ќ Lx/occ2f8dff8d8;
      // c7: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // ca: ifeq dd
      // cd: goto d1
      // d0: athrow
      // d1: aload 0
      // d2: aload 1
      // d3: getfield x/oc746a23b244.Ё F
      // d6: invokevirtual x/ocd1b2d918dd.ώ (F)V
      // d9: goto dd
      // dc: athrow
      // dd: aload 0
      // de: iload 2
      // df: ifne f4
      // e2: getfield x/ocd1b2d918dd.Ž Lx/occ2f8dff8d8;
      // e5: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // e8: ifeq fb
      // eb: goto ef
      // ee: athrow
      // ef: aload 0
      // f0: goto f4
      // f3: athrow
      // f4: aload 1
      // f5: getfield x/oc746a23b244.Ё F
      // f8: invokevirtual x/ocd1b2d918dd.Ų (F)V
      // fb: return
   }

   private void ώ(float param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: istore 2
      // 004: aload 0
      // 005: iload 2
      // 006: ifne 01b
      // 009: getfield x/ocd1b2d918dd.Ō Lx/oc66e0225688;
      // 00c: invokevirtual x/oc188196c08d.Ҹ ()Z
      // 00f: ifeq 03f
      // 012: goto 016
      // 015: athrow
      // 016: aload 0
      // 017: goto 01b
      // 01a: athrow
      // 01b: iload 2
      // 01c: ifne 031
      // 01f: getfield x/ocd1b2d918dd.Ѧ Lx/oc98d1de20cf;
      // 022: invokevirtual x/oc188196c08d.Ҹ ()Z
      // 025: ifeq 03f
      // 028: goto 02c
      // 02b: athrow
      // 02c: aload 0
      // 02d: goto 031
      // 030: athrow
      // 031: iload 2
      // 032: ifne 04e
      // 035: getfield x/ocd1b2d918dd.Β I
      // 038: ifne 041
      // 03b: goto 03f
      // 03e: athrow
      // 03f: return
      // 040: athrow
      // 041: aload 0
      // 042: aload 0
      // 043: getfield x/ocd1b2d918dd.Ń Lnet/minecraft/client/shader/Framebuffer;
      // 046: bipush 0
      // 047: invokestatic x/ocbd4917c4b1.ɓ (Lnet/minecraft/client/shader/Framebuffer;Z)Lnet/minecraft/client/shader/Framebuffer;
      // 04a: putfield x/ocd1b2d918dd.Ń Lnet/minecraft/client/shader/Framebuffer;
      // 04d: aload 0
      // 04e: getfield x/ocd1b2d918dd.Ń Lnet/minecraft/client/shader/Framebuffer;
      // 051: ifnonnull 056
      // 054: return
      // 055: athrow
      // 056: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 059: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 05c: getfield net/minecraft/client/settings/GameSettings.entityShadows Z
      // 05f: istore 3
      // 060: invokestatic net/minecraft/client/renderer/GlStateManager.pushMatrix ()V
      // 063: invokestatic net/minecraft/client/renderer/GlStateManager.pushAttrib ()V
      // 066: aload 0
      // 067: getfield x/ocd1b2d918dd.Ń Lnet/minecraft/client/shader/Framebuffer;
      // 06a: bipush 0
      // 06b: invokevirtual net/minecraft/client/shader/Framebuffer.bindFramebuffer (Z)V
      // 06e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 071: getfield net/minecraft/client/Minecraft.entityRenderer Lnet/minecraft/client/renderer/EntityRenderer;
      // 074: fload 1
      // 075: bipush 0
      // 076: invokeinterface x/oc65f19d876a.callSetupCameraTransform (FI)V 3
      // 07b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 07e: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 081: bipush 0
      // 082: putfield net/minecraft/client/settings/GameSettings.entityShadows Z
      // 085: bipush 1
      // 086: putstatic x/ocd1b2d918dd.F Z
      // 089: aload 0
      // 08a: getfield x/ocd1b2d918dd.Ѧ Lx/oc98d1de20cf;
      // 08d: invokevirtual x/oc188196c08d.ѿ ()V
      // 090: bipush 0
      // 091: istore 4
      // 093: iload 4
      // 095: aload 0
      // 096: getfield x/ocd1b2d918dd.Β I
      // 099: if_icmpge 167
      // 09c: aload 0
      // 09d: getfield x/ocd1b2d918dd.Ʃ Ljava/util/List;
      // 0a0: iload 4
      // 0a2: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 0a7: checkcast x/oc55bd31ebd1
      // 0aa: astore 5
      // 0ac: iload 2
      // 0ad: aload 5
      // 0af: getfield x/oc55bd31ebd1.ň Lnet/minecraft/entity/EntityLivingBase;
      // 0b2: astore 6
      // 0b4: ifne 1ec
      // 0b7: aload 0
      // 0b8: aload 5
      // 0ba: invokevirtual x/ocd1b2d918dd.е (Lx/oc55bd31ebd1;)I
      // 0bd: istore 7
      // 0bf: aload 0
      // 0c0: getfield x/ocd1b2d918dd.Ѧ Lx/oc98d1de20cf;
      // 0c3: iload 7
      // 0c5: ldc_w 889434939
      // 0c8: ldc_w 889434923
      // 0cb: ixor
      // 0cc: ishr
      // 0cd: ldc_w 889435092
      // 0d0: ldc_w 889434923
      // 0d3: ixor
      // 0d4: iand
      // 0d5: iload 7
      // 0d7: ldc_w 889434915
      // 0da: ldc_w 889434923
      // 0dd: ixor
      // 0de: ishr
      // 0df: ldc_w 889435092
      // 0e2: ldc_w 889434923
      // 0e5: ixor
      // 0e6: iand
      // 0e7: iload 7
      // 0e9: ldc_w 889435092
      // 0ec: ldc_w 889434923
      // 0ef: ixor
      // 0f0: iand
      // 0f1: iload 7
      // 0f3: ldc_w 889434931
      // 0f6: ldc_w 889434923
      // 0f9: ixor
      // 0fa: ishr
      // 0fb: ldc_w 889435092
      // 0fe: ldc_w 889434923
      // 101: ixor
      // 102: iand
      // 103: invokevirtual x/oc98d1de20cf.ԇ (IIII)V
      // 106: aload 6
      // 108: invokevirtual net/minecraft/entity/EntityLivingBase.isInvisible ()Z
      // 10b: istore 8
      // 10d: aload 0
      // 10e: iload 2
      // 10f: ifne 121
      // 112: invokevirtual x/ocd1b2d918dd.ǌ ()Z
      // 115: ifne 132
      // 118: goto 11c
      // 11b: athrow
      // 11c: aload 0
      // 11d: goto 121
      // 120: athrow
      // 121: getfield x/ocd1b2d918dd.ӱ Lx/occ2f8dff8d8;
      // 124: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 127: iload 2
      // 128: ifne 149
      // 12b: ifeq 13c
      // 12e: goto 132
      // 131: athrow
      // 132: aload 6
      // 134: bipush 0
      // 135: invokevirtual net/minecraft/entity/EntityLivingBase.setInvisible (Z)V
      // 138: goto 13c
      // 13b: athrow
      // 13c: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 13f: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 142: aload 6
      // 144: fload 1
      // 145: bipush 1
      // 146: invokevirtual net/minecraft/client/renderer/entity/RenderManager.renderEntityStatic (Lnet/minecraft/entity/Entity;FZ)Z
      // 149: pop
      // 14a: aload 6
      // 14c: iload 8
      // 14e: invokevirtual net/minecraft/entity/EntityLivingBase.setInvisible (Z)V
      // 151: goto 160
      // 154: astore 9
      // 156: aload 6
      // 158: iload 8
      // 15a: invokevirtual net/minecraft/entity/EntityLivingBase.setInvisible (Z)V
      // 15d: aload 9
      // 15f: athrow
      // 160: iinc 4 1
      // 163: iload 2
      // 164: ifeq 093
      // 167: aload 0
      // 168: getfield x/ocd1b2d918dd.Ѧ Lx/oc98d1de20cf;
      // 16b: invokevirtual x/oc188196c08d.ʂ ()V
      // 16e: bipush 0
      // 16f: putstatic x/ocd1b2d918dd.F Z
      // 172: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 175: getfield net/minecraft/client/Minecraft.entityRenderer Lnet/minecraft/client/renderer/EntityRenderer;
      // 178: invokevirtual net/minecraft/client/renderer/EntityRenderer.disableLightmap ()V
      // 17b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 17e: getfield net/minecraft/client/Minecraft.entityRenderer Lnet/minecraft/client/renderer/EntityRenderer;
      // 181: invokevirtual net/minecraft/client/renderer/EntityRenderer.setupOverlayRendering ()V
      // 184: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 187: invokevirtual net/minecraft/client/Minecraft.getFramebuffer ()Lnet/minecraft/client/shader/Framebuffer;
      // 18a: bipush 1
      // 18b: invokevirtual net/minecraft/client/shader/Framebuffer.bindFramebuffer (Z)V
      // 18e: invokestatic net/minecraft/client/renderer/GlStateManager.enableBlend ()V
      // 191: ldc_w 889434153
      // 194: ldc_w 889434923
      // 197: ixor
      // 198: ldc_w 889434152
      // 19b: ldc_w 889434923
      // 19e: ixor
      // 19f: bipush 1
      // 1a0: bipush 0
      // 1a1: invokestatic net/minecraft/client/renderer/GlStateManager.tryBlendFuncSeparate (IIII)V
      // 1a4: aload 0
      // 1a5: getfield x/ocd1b2d918dd.Ō Lx/oc66e0225688;
      // 1a8: invokevirtual x/oc188196c08d.ѿ ()V
      // 1ab: aload 0
      // 1ac: getfield x/ocd1b2d918dd.Ń Lnet/minecraft/client/shader/Framebuffer;
      // 1af: invokestatic x/ocbd4917c4b1.Ή (Lnet/minecraft/client/shader/Framebuffer;)V
      // 1b2: aload 0
      // 1b3: getfield x/ocd1b2d918dd.Ō Lx/oc66e0225688;
      // 1b6: invokevirtual x/oc188196c08d.ʂ ()V
      // 1b9: aload 0
      // 1ba: getfield x/ocd1b2d918dd.Ń Lnet/minecraft/client/shader/Framebuffer;
      // 1bd: invokevirtual net/minecraft/client/shader/Framebuffer.framebufferClear ()V
      // 1c0: aload 0
      // 1c1: getfield x/ocd1b2d918dd.Ѧ Lx/oc98d1de20cf;
      // 1c4: invokevirtual x/oc188196c08d.ʂ ()V
      // 1c7: aload 0
      // 1c8: getfield x/ocd1b2d918dd.Ō Lx/oc66e0225688;
      // 1cb: invokevirtual x/oc188196c08d.ʂ ()V
      // 1ce: bipush 0
      // 1cf: putstatic x/ocd1b2d918dd.F Z
      // 1d2: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1d5: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 1d8: iload 3
      // 1d9: putfield net/minecraft/client/settings/GameSettings.entityShadows Z
      // 1dc: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1df: invokevirtual net/minecraft/client/Minecraft.getFramebuffer ()Lnet/minecraft/client/shader/Framebuffer;
      // 1e2: bipush 0
      // 1e3: invokevirtual net/minecraft/client/shader/Framebuffer.bindFramebuffer (Z)V
      // 1e6: invokestatic net/minecraft/client/renderer/GlStateManager.popAttrib ()V
      // 1e9: invokestatic net/minecraft/client/renderer/GlStateManager.popMatrix ()V
      // 1ec: goto 220
      // 1ef: astore 10
      // 1f1: aload 0
      // 1f2: getfield x/ocd1b2d918dd.Ѧ Lx/oc98d1de20cf;
      // 1f5: invokevirtual x/oc188196c08d.ʂ ()V
      // 1f8: aload 0
      // 1f9: getfield x/ocd1b2d918dd.Ō Lx/oc66e0225688;
      // 1fc: invokevirtual x/oc188196c08d.ʂ ()V
      // 1ff: bipush 0
      // 200: putstatic x/ocd1b2d918dd.F Z
      // 203: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 206: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 209: iload 3
      // 20a: putfield net/minecraft/client/settings/GameSettings.entityShadows Z
      // 20d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 210: invokevirtual net/minecraft/client/Minecraft.getFramebuffer ()Lnet/minecraft/client/shader/Framebuffer;
      // 213: bipush 0
      // 214: invokevirtual net/minecraft/client/shader/Framebuffer.bindFramebuffer (Z)V
      // 217: invokestatic net/minecraft/client/renderer/GlStateManager.popAttrib ()V
      // 21a: invokestatic net/minecraft/client/renderer/GlStateManager.popMatrix ()V
      // 21d: aload 10
      // 21f: athrow
      // 220: return
   }

   private void ǔ() {
      this.ӹ = 0;
      this.Β = 0;
      this.D.clear();
      this.ɴ.clear();
      this.Ʃ.clear();
   }

   private void Ͱ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: istore 1
      // 004: aload 0
      // 005: iload 1
      // 006: ifne 02e
      // 009: bipush 0
      // 00a: putfield x/ocd1b2d918dd.ӹ I
      // 00d: aload 0
      // 00e: bipush 0
      // 00f: putfield x/ocd1b2d918dd.Β I
      // 012: aload 0
      // 013: getfield x/ocd1b2d918dd.D Ljava/util/Map;
      // 016: invokeinterface java/util/Map.clear ()V 1
      // 01b: aload 0
      // 01c: invokevirtual x/ocd1b2d918dd.ǌ ()Z
      // 01f: ifeq 02d
      // 022: goto 026
      // 025: athrow
      // 026: ldc2_w 262144.0
      // 029: goto 03c
      // 02c: athrow
      // 02d: aload 0
      // 02e: getfield x/ocd1b2d918dd.δ Lx/oca9cc61aada;
      // 031: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 034: aload 0
      // 035: getfield x/ocd1b2d918dd.δ Lx/oca9cc61aada;
      // 038: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 03b: dmul
      // 03c: dstore 2
      // 03d: getstatic x/oc2cf3d80e17.ĥ Z
      // 040: iload 1
      // 041: ifne 053
      // 044: ifeq 10e
      // 047: goto 04b
      // 04a: athrow
      // 04b: aload 0
      // 04c: invokevirtual x/ocd1b2d918dd.ǌ ()Z
      // 04f: goto 053
      // 052: athrow
      // 053: ifne 10e
      // 056: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 059: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 05c: getfield net/minecraft/client/multiplayer/WorldClient.loadedEntityList Ljava/util/List;
      // 05f: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 064: astore 4
      // 066: aload 4
      // 068: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 06d: ifeq 10d
      // 070: aload 4
      // 072: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 077: checkcast net/minecraft/entity/Entity
      // 07a: astore 5
      // 07c: aload 5
      // 07e: iload 1
      // 07f: ifne 08e
      // 082: instanceof net/minecraft/entity/EntityLivingBase
      // 085: ifeq 066
      // 088: goto 08c
      // 08b: athrow
      // 08c: aload 5
      // 08e: iload 1
      // 08f: ifne 0a9
      // 092: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 095: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 098: if_acmpne 0a7
      // 09b: goto 09f
      // 09e: athrow
      // 09f: iload 1
      // 0a0: ifeq 066
      // 0a3: goto 0a7
      // 0a6: athrow
      // 0a7: aload 5
      // 0a9: iload 1
      // 0aa: ifne 0eb
      // 0ad: instanceof net/minecraft/entity/player/EntityPlayer
      // 0b0: ifeq 0e9
      // 0b3: goto 0b7
      // 0b6: athrow
      // 0b7: aload 0
      // 0b8: getfield x/ocd1b2d918dd.ƈ Lx/occ2f8dff8d8;
      // 0bb: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0be: iload 1
      // 0bf: ifne 0ef
      // 0c2: goto 0c6
      // 0c5: athrow
      // 0c6: ifne 0e9
      // 0c9: goto 0cd
      // 0cc: athrow
      // 0cd: aload 5
      // 0cf: iload 1
      // 0d0: ifne 0eb
      // 0d3: goto 0d7
      // 0d6: athrow
      // 0d7: invokestatic x/oc7ab2161b9f.ӥ (Lnet/minecraft/entity/Entity;)Z
      // 0da: ifeq 0e9
      // 0dd: goto 0e1
      // 0e0: athrow
      // 0e1: iload 1
      // 0e2: ifeq 066
      // 0e5: goto 0e9
      // 0e8: athrow
      // 0e9: aload 5
      // 0eb: dload 2
      // 0ec: invokestatic x/ocbd4917c4b1.Ϗ (Lnet/minecraft/entity/Entity;D)Z
      // 0ef: ifne 0fa
      // 0f2: iload 1
      // 0f3: ifeq 066
      // 0f6: goto 0fa
      // 0f9: athrow
      // 0fa: aload 0
      // 0fb: aload 5
      // 0fd: checkcast net/minecraft/entity/EntityLivingBase
      // 100: aload 0
      // 101: aload 5
      // 103: invokevirtual x/ocd1b2d918dd.Σ (Lnet/minecraft/entity/Entity;)I
      // 106: invokevirtual x/ocd1b2d918dd.Ø (Lnet/minecraft/entity/EntityLivingBase;I)V
      // 109: iload 1
      // 10a: ifeq 066
      // 10d: return
      // 10e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 111: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 114: astore 4
      // 116: aload 0
      // 117: aload 4
      // 119: invokevirtual x/ocd1b2d918dd.ơ (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // 11c: istore 5
      // 11e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 121: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 124: getfield net/minecraft/client/multiplayer/WorldClient.playerEntities Ljava/util/List;
      // 127: astore 6
      // 129: aload 0
      // 12a: invokevirtual x/ocd1b2d918dd.ǌ ()Z
      // 12d: ifeq 159
      // 130: new java/util/ArrayList
      // 133: dup
      // 134: aload 6
      // 136: invokespecial java/util/ArrayList.<init> (Ljava/util/Collection;)V
      // 139: astore 6
      // 13b: aload 6
      // 13d: invokedynamic applyAsDouble ()Ljava/util/function/ToDoubleFunction; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)D, x/ocd1b2d918dd.q28ujqimparyod (Lnet/minecraft/entity/player/EntityPlayer;)D, (Lnet/minecraft/entity/player/EntityPlayer;)D ]
      // 142: invokestatic java/util/Comparator.comparingDouble (Ljava/util/function/ToDoubleFunction;)Ljava/util/Comparator;
      // 145: invokeinterface java/util/Comparator.reversed ()Ljava/util/Comparator; 1
      // 14a: invokedynamic apply ()Ljava/util/function/Function; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Ljava/lang/Object;, x/ocd1b2d918dd.qncn54pucdkkl (Lnet/minecraft/entity/player/EntityPlayer;)Ljava/lang/String;, (Lnet/minecraft/entity/player/EntityPlayer;)Ljava/lang/String; ]
      // 14f: invokeinterface java/util/Comparator.thenComparing (Ljava/util/function/Function;)Ljava/util/Comparator; 2
      // 154: invokeinterface java/util/List.sort (Ljava/util/Comparator;)V 2
      // 159: aload 6
      // 15b: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 160: astore 7
      // 162: aload 7
      // 164: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 169: ifeq 28f
      // 16c: aload 7
      // 16e: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 173: checkcast net/minecraft/entity/player/EntityPlayer
      // 176: astore 8
      // 178: aload 8
      // 17a: iload 1
      // 17b: ifne 1a2
      // 17e: aload 4
      // 180: if_acmpne 1a0
      // 183: goto 187
      // 186: athrow
      // 187: iload 5
      // 189: iload 1
      // 18a: ifne 1a5
      // 18d: goto 191
      // 190: athrow
      // 191: ifne 1a0
      // 194: goto 198
      // 197: athrow
      // 198: iload 1
      // 199: ifeq 162
      // 19c: goto 1a0
      // 19f: athrow
      // 1a0: aload 8
      // 1a2: getfield net/minecraft/entity/player/EntityPlayer.deathTime I
      // 1a5: iload 1
      // 1a6: ifne 1c4
      // 1a9: ifeq 1b8
      // 1ac: goto 1b0
      // 1af: athrow
      // 1b0: iload 1
      // 1b1: ifeq 162
      // 1b4: goto 1b8
      // 1b7: athrow
      // 1b8: aload 0
      // 1b9: iload 1
      // 1ba: ifne 1e5
      // 1bd: invokevirtual x/ocd1b2d918dd.ǌ ()Z
      // 1c0: goto 1c4
      // 1c3: athrow
      // 1c4: ifeq 1e4
      // 1c7: aload 0
      // 1c8: aload 8
      // 1ca: invokevirtual x/ocd1b2d918dd.Ğ (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // 1cd: iload 1
      // 1ce: ifne 274
      // 1d1: goto 1d5
      // 1d4: athrow
      // 1d5: ifne 26e
      // 1d8: goto 1dc
      // 1db: athrow
      // 1dc: iload 1
      // 1dd: ifeq 162
      // 1e0: goto 1e4
      // 1e3: athrow
      // 1e4: aload 0
      // 1e5: getfield x/ocd1b2d918dd.ӱ Lx/occ2f8dff8d8;
      // 1e8: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 1eb: iload 1
      // 1ec: ifne 1ff
      // 1ef: ifne 20a
      // 1f2: goto 1f6
      // 1f5: athrow
      // 1f6: aload 8
      // 1f8: invokevirtual net/minecraft/entity/player/EntityPlayer.isInvisible ()Z
      // 1fb: goto 1ff
      // 1fe: athrow
      // 1ff: ifeq 20a
      // 202: iload 1
      // 203: ifeq 162
      // 206: goto 20a
      // 209: athrow
      // 20a: aload 4
      // 20c: iload 1
      // 20d: ifne 245
      // 210: aload 8
      // 212: if_acmpeq 243
      // 215: goto 219
      // 218: athrow
      // 219: aload 0
      // 21a: getfield x/ocd1b2d918dd.ƈ Lx/occ2f8dff8d8;
      // 21d: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 220: iload 1
      // 221: ifne 238
      // 224: goto 228
      // 227: athrow
      // 228: ifne 243
      // 22b: goto 22f
      // 22e: athrow
      // 22f: aload 8
      // 231: invokestatic x/oc7ab2161b9f.ӥ (Lnet/minecraft/entity/Entity;)Z
      // 234: goto 238
      // 237: athrow
      // 238: ifeq 243
      // 23b: iload 1
      // 23c: ifeq 162
      // 23f: goto 243
      // 242: athrow
      // 243: aload 4
      // 245: iload 1
      // 246: ifne 270
      // 249: aload 8
      // 24b: if_acmpeq 26e
      // 24e: goto 252
      // 251: athrow
      // 252: aload 8
      // 254: iload 1
      // 255: ifne 270
      // 258: goto 25c
      // 25b: athrow
      // 25c: invokestatic x/oca4f99d2d44.Λ (Lnet/minecraft/entity/Entity;)Z
      // 25f: ifeq 26e
      // 262: goto 266
      // 265: athrow
      // 266: iload 1
      // 267: ifeq 162
      // 26a: goto 26e
      // 26d: athrow
      // 26e: aload 8
      // 270: dload 2
      // 271: invokestatic x/ocbd4917c4b1.Ϗ (Lnet/minecraft/entity/Entity;D)Z
      // 274: ifne 27f
      // 277: iload 1
      // 278: ifeq 162
      // 27b: goto 27f
      // 27e: athrow
      // 27f: aload 0
      // 280: aload 8
      // 282: aload 0
      // 283: aload 8
      // 285: invokevirtual x/ocd1b2d918dd.Σ (Lnet/minecraft/entity/Entity;)I
      // 288: invokevirtual x/ocd1b2d918dd.Ø (Lnet/minecraft/entity/EntityLivingBase;I)V
      // 28b: iload 1
      // 28c: ifeq 162
      // 28f: return
   }

   private boolean ơ(EntityPlayer param1) {
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
      // 05: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 08: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0b: if_acmpne 57
      // 0e: aload 0
      // 0f: iload 2
      // 10: ifne 2a
      // 13: goto 17
      // 16: athrow
      // 17: invokevirtual x/ocd1b2d918dd.ǌ ()Z
      // 1a: ifeq 29
      // 1d: goto 21
      // 20: athrow
      // 21: aload 0
      // 22: getfield x/ocd1b2d918dd.ѡ Lx/occ2f8dff8d8;
      // 25: goto 2d
      // 28: athrow
      // 29: aload 0
      // 2a: getfield x/ocd1b2d918dd.Ү Lx/occ2f8dff8d8;
      // 2d: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 30: iload 2
      // 31: ifne 48
      // 34: ifeq 57
      // 37: goto 3b
      // 3a: athrow
      // 3b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 3e: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 41: getfield net/minecraft/client/settings/GameSettings.thirdPersonView I
      // 44: goto 48
      // 47: athrow
      // 48: iload 2
      // 49: ifne 54
      // 4c: ifle 57
      // 4f: goto 53
      // 52: athrow
      // 53: bipush 1
      // 54: goto 58
      // 57: bipush 0
      // 58: ireturn
   }

   private boolean Ğ(EntityPlayer param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 2
      // 04: aload 1
      // 05: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 08: iload 2
      // 09: ifne 26
      // 0c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0f: if_acmpeq 2c
      // 12: goto 16
      // 15: athrow
      // 16: aload 1
      // 17: iload 2
      // 18: ifne 61
      // 1b: goto 1f
      // 1e: athrow
      // 1f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 22: goto 26
      // 25: athrow
      // 26: invokevirtual net/minecraft/client/Minecraft.getRenderViewEntity ()Lnet/minecraft/entity/Entity;
      // 29: if_acmpne 60
      // 2c: aload 0
      // 2d: getfield x/ocd1b2d918dd.ѡ Lx/occ2f8dff8d8;
      // 30: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 33: iload 2
      // 34: ifne 4f
      // 37: goto 3b
      // 3a: athrow
      // 3b: ifeq 5e
      // 3e: goto 42
      // 41: athrow
      // 42: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 45: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 48: getfield net/minecraft/client/settings/GameSettings.thirdPersonView I
      // 4b: goto 4f
      // 4e: athrow
      // 4f: iload 2
      // 50: ifne 5b
      // 53: ifeq 5e
      // 56: goto 5a
      // 59: athrow
      // 5a: bipush 1
      // 5b: goto 5f
      // 5e: bipush 0
      // 5f: ireturn
      // 60: aload 1
      // 61: iload 2
      // 62: ifne 79
      // 65: invokestatic x/ocdc8e6f6a42.ʉ (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // 68: ifeq 78
      // 6b: goto 6f
      // 6e: athrow
      // 6f: aload 0
      // 70: getfield x/ocd1b2d918dd.Ή Lx/occ2f8dff8d8;
      // 73: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 76: ireturn
      // 77: athrow
      // 78: aload 1
      // 79: iload 2
      // 7a: ifne 91
      // 7d: invokestatic x/oc7ab2161b9f.Ӭ (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // 80: ifeq 90
      // 83: goto 87
      // 86: athrow
      // 87: aload 0
      // 88: getfield x/ocd1b2d918dd.Ȧ Lx/occ2f8dff8d8;
      // 8b: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 8e: ireturn
      // 8f: athrow
      // 90: aload 1
      // 91: invokestatic x/oc7ab2161b9f.Š (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // 94: iload 2
      // 95: ifne af
      // 98: ifeq a8
      // 9b: goto 9f
      // 9e: athrow
      // 9f: aload 0
      // a0: getfield x/ocd1b2d918dd.ɺ Lx/occ2f8dff8d8;
      // a3: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // a6: ireturn
      // a7: athrow
      // a8: aload 0
      // a9: getfield x/ocd1b2d918dd.Ǡ Lx/occ2f8dff8d8;
      // ac: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // af: ireturn
   }

   private void Ø(EntityLivingBase param1, int param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 3
      // 04: aload 0
      // 05: iload 3
      // 06: ifne 45
      // 09: getfield x/ocd1b2d918dd.ӹ I
      // 0c: aload 0
      // 0d: getfield x/ocd1b2d918dd.ɴ Ljava/util/List;
      // 10: invokeinterface java/util/List.size ()I 1
      // 15: if_icmplt 31
      // 18: goto 1c
      // 1b: athrow
      // 1c: aload 0
      // 1d: getfield x/ocd1b2d918dd.ɴ Ljava/util/List;
      // 20: new x/oc55bd31ebd1
      // 23: dup
      // 24: invokespecial x/oc55bd31ebd1.<init> ()V
      // 27: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 2c: pop
      // 2d: goto 31
      // 30: athrow
      // 31: aload 0
      // 32: getfield x/ocd1b2d918dd.ɴ Ljava/util/List;
      // 35: aload 0
      // 36: dup
      // 37: getfield x/ocd1b2d918dd.ӹ I
      // 3a: dup_x1
      // 3b: bipush 1
      // 3c: iadd
      // 3d: putfield x/ocd1b2d918dd.ӹ I
      // 40: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 45: checkcast x/oc55bd31ebd1
      // 48: astore 4
      // 4a: aload 4
      // 4c: iload 3
      // 4d: ifne 73
      // 50: aload 1
      // 51: iload 2
      // 52: invokevirtual x/oc55bd31ebd1.Ķ (Lnet/minecraft/entity/EntityLivingBase;I)V
      // 55: aload 1
      // 56: instanceof net/minecraft/entity/player/EntityPlayer
      // 59: ifeq 74
      // 5c: goto 60
      // 5f: athrow
      // 60: aload 0
      // 61: getfield x/ocd1b2d918dd.D Ljava/util/Map;
      // 64: aload 1
      // 65: checkcast net/minecraft/entity/player/EntityPlayer
      // 68: aload 4
      // 6a: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 6f: goto 73
      // 72: athrow
      // 73: pop
      // 74: return
   }

   private void ԡ(oc55bd31ebd1 param1) {
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
      // 05: iload 2
      // 06: ifne 41
      // 09: getfield x/ocd1b2d918dd.Β I
      // 0c: aload 0
      // 0d: getfield x/ocd1b2d918dd.Ʃ Ljava/util/List;
      // 10: invokeinterface java/util/List.size ()I 1
      // 15: if_icmplt 2f
      // 18: goto 1c
      // 1b: athrow
      // 1c: aload 0
      // 1d: getfield x/ocd1b2d918dd.Ʃ Ljava/util/List;
      // 20: aload 1
      // 21: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 26: pop
      // 27: iload 2
      // 28: ifeq 42
      // 2b: goto 2f
      // 2e: athrow
      // 2f: aload 0
      // 30: getfield x/ocd1b2d918dd.Ʃ Ljava/util/List;
      // 33: aload 0
      // 34: getfield x/ocd1b2d918dd.Β I
      // 37: aload 1
      // 38: invokeinterface java/util/List.set (ILjava/lang/Object;)Ljava/lang/Object; 3
      // 3d: goto 41
      // 40: athrow
      // 41: pop
      // 42: aload 0
      // 43: dup
      // 44: getfield x/ocd1b2d918dd.Β I
      // 47: bipush 1
      // 48: iadd
      // 49: putfield x/ocd1b2d918dd.Β I
      // 4c: return
   }

   private int Σ(Entity param1) {
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
      // 05: iload 2
      // 06: ifne c7
      // 09: invokevirtual x/ocd1b2d918dd.ǌ ()Z
      // 0c: ifeq c6
      // 0f: goto 13
      // 12: athrow
      // 13: aload 1
      // 14: instanceof net/minecraft/entity/player/EntityPlayer
      // 17: iload 2
      // 18: ifne d5
      // 1b: goto 1f
      // 1e: athrow
      // 1f: ifeq c6
      // 22: goto 26
      // 25: athrow
      // 26: aload 1
      // 27: checkcast net/minecraft/entity/player/EntityPlayer
      // 2a: astore 3
      // 2b: aload 3
      // 2c: iload 2
      // 2d: ifne 44
      // 30: invokestatic x/oc7ab2161b9f.Ӭ (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // 33: ifeq 43
      // 36: goto 3a
      // 39: athrow
      // 3a: ldc_w 1294479484
      // 3d: ldc_w -1305961860
      // 40: ixor
      // 41: ireturn
      // 42: athrow
      // 43: aload 3
      // 44: invokestatic x/oc7ab2161b9f.Š (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // 47: iload 2
      // 48: ifne 63
      // 4b: ifeq 5b
      // 4e: goto 52
      // 51: athrow
      // 52: ldc_w 1300404860
      // 55: ldc_w -1305961860
      // 58: ixor
      // 59: ireturn
      // 5a: athrow
      // 5b: aload 0
      // 5c: getfield x/ocd1b2d918dd.Ƒ Lx/oca9cc61aada;
      // 5f: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 62: d2i
      // 63: istore 4
      // 65: iload 4
      // 67: iload 2
      // 68: ifne 9a
      // 6b: bipush 1
      // 6c: if_icmpne 98
      // 6f: goto 73
      // 72: athrow
      // 73: aload 3
      // 74: invokestatic x/ocdc8e6f6a42.Ę (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // 77: iload 2
      // 78: ifne 8d
      // 7b: goto 7f
      // 7e: athrow
      // 7f: ifeq 90
      // 82: goto 86
      // 85: athrow
      // 86: ldc_w 1300090755
      // 89: ldc_w -1305961860
      // 8c: ixor
      // 8d: goto 97
      // 90: ldc_w 1305988905
      // 93: ldc_w -1305961860
      // 96: ixor
      // 97: ireturn
      // 98: iload 4
      // 9a: iload 2
      // 9b: ifne c5
      // 9e: ldc_w -1305961858
      // a1: ldc_w -1305961860
      // a4: ixor
      // a5: if_icmpne bd
      // a8: goto ac
      // ab: athrow
      // ac: dconst_0
      // ad: dconst_0
      // ae: invokestatic x/ocd2958dac48.ʰ (DD)I
      // b1: ldc_w -1305961853
      // b4: ldc_w -1305961860
      // b7: ixor
      // b8: invokestatic x/oc7ab2161b9f.Ҭ (II)I
      // bb: ireturn
      // bc: athrow
      // bd: aload 3
      // be: fconst_1
      // bf: invokestatic x/ocdc8e6f6a42.ȇ (Lnet/minecraft/entity/player/EntityPlayer;F)Ljava/awt/Color;
      // c2: invokevirtual java/awt/Color.getRGB ()I
      // c5: ireturn
      // c6: aload 0
      // c7: iload 2
      // c8: ifne e1
      // cb: getfield x/ocd1b2d918dd.ӯ Lx/occ2f8dff8d8;
      // ce: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // d1: goto d5
      // d4: athrow
      // d5: ifeq e0
      // d8: aload 1
      // d9: invokestatic x/oc7ab2161b9f.ǳ (Lnet/minecraft/entity/Entity;)I
      // dc: goto e7
      // df: athrow
      // e0: aload 0
      // e1: getfield x/ocd1b2d918dd.ɥ Lx/oc24a0a5bddf;
      // e4: invokevirtual x/oc24a0a5bddf.ͳ ()I
      // e7: istore 3
      // e8: iload 3
      // e9: ldc_w -1305961853
      // ec: ldc_w -1305961860
      // ef: ixor
      // f0: invokestatic x/oc7ab2161b9f.Ҭ (II)I
      // f3: ireturn
   }

   private int ө(oc55bd31ebd1 param1) {
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
      // 05: iload 2
      // 06: ifne 1e
      // 09: invokevirtual x/ocd1b2d918dd.ǌ ()Z
      // 0c: ifeq 1d
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: aload 1
      // 15: getfield x/oc55bd31ebd1.ň Lnet/minecraft/entity/EntityLivingBase;
      // 18: invokevirtual x/ocd1b2d918dd.Σ (Lnet/minecraft/entity/Entity;)I
      // 1b: ireturn
      // 1c: athrow
      // 1d: aload 0
      // 1e: getfield x/ocd1b2d918dd.ӯ Lx/occ2f8dff8d8;
      // 21: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 24: iload 2
      // 25: ifne 66
      // 28: ifne 62
      // 2b: goto 2f
      // 2e: athrow
      // 2f: aload 0
      // 30: getfield x/ocd1b2d918dd.Й Lx/occ2f8dff8d8;
      // 33: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 36: iload 2
      // 37: ifne 66
      // 3a: goto 3e
      // 3d: athrow
      // 3e: ifeq 62
      // 41: goto 45
      // 44: athrow
      // 45: ldc2_w -2916394532030574898
      // 48: ldc2_w -2916394532030574900
      // 4b: lxor
      // 4c: bipush 1
      // 4d: newarray 11
      // 4f: dup
      // 50: bipush 0
      // 51: lconst_0
      // 52: lastore
      // 53: invokestatic x/oc7ab2161b9f.ƾ (J[J)I
      // 56: ldc_w 1403712093
      // 59: ldc_w 1403712162
      // 5c: ixor
      // 5d: invokestatic x/oc7ab2161b9f.Ҭ (II)I
      // 60: ireturn
      // 61: athrow
      // 62: aload 1
      // 63: getfield x/oc55bd31ebd1.Ć I
      // 66: ireturn
   }

   private int е(oc55bd31ebd1 param1) {
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
      // 05: invokevirtual x/ocd1b2d918dd.ϱ ()Z
      // 08: iload 2
      // 09: ifne 4c
      // 0c: ifeq 48
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: getfield x/ocd1b2d918dd.ǖ Lx/occ2f8dff8d8;
      // 17: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 1a: iload 2
      // 1b: ifne 4c
      // 1e: goto 22
      // 21: athrow
      // 22: ifeq 48
      // 25: goto 29
      // 28: athrow
      // 29: aload 1
      // 2a: iload 2
      // 2b: ifne 49
      // 2e: goto 32
      // 31: athrow
      // 32: getfield x/oc55bd31ebd1.ň Lnet/minecraft/entity/EntityLivingBase;
      // 35: getfield net/minecraft/entity/EntityLivingBase.hurtTime I
      // 38: ifeq 48
      // 3b: goto 3f
      // 3e: athrow
      // 3f: ldc_w -1773841524
      // 42: ldc_w 1773818764
      // 45: ixor
      // 46: ireturn
      // 47: athrow
      // 48: aload 1
      // 49: getfield x/oc55bd31ebd1.ƕ I
      // 4c: ireturn
   }

   public void Ж(Entity param1, int param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: istore 3
      // 004: aload 0
      // 005: iload 3
      // 006: ifne 05b
      // 009: getfield x/ocd1b2d918dd.մ Lx/occ2f8dff8d8;
      // 00c: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 00f: ifne 05a
      // 012: goto 016
      // 015: athrow
      // 016: aload 0
      // 017: iload 3
      // 018: ifne 05b
      // 01b: goto 01f
      // 01e: athrow
      // 01f: getfield x/ocd1b2d918dd.բ Lx/occ2f8dff8d8;
      // 022: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 025: ifne 05a
      // 028: goto 02c
      // 02b: athrow
      // 02c: aload 0
      // 02d: getfield x/ocd1b2d918dd.ô Lx/occ2f8dff8d8;
      // 030: iload 3
      // 031: ifne 066
      // 034: goto 038
      // 037: athrow
      // 038: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 03b: ifne 05a
      // 03e: goto 042
      // 041: athrow
      // 042: aload 0
      // 043: iload 3
      // 044: ifne 05b
      // 047: goto 04b
      // 04a: athrow
      // 04b: getfield x/ocd1b2d918dd.ɶ Lx/occ2f8dff8d8;
      // 04e: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 051: ifne 05a
      // 054: goto 058
      // 057: athrow
      // 058: return
      // 059: athrow
      // 05a: aload 0
      // 05b: iload 3
      // 05c: ifne 080
      // 05f: getfield x/ocd1b2d918dd.մ Lx/occ2f8dff8d8;
      // 062: goto 066
      // 065: athrow
      // 066: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 069: ifeq 07f
      // 06c: aload 1
      // 06d: bipush 1
      // 06e: dconst_0
      // 06f: dconst_0
      // 070: iload 2
      // 071: aload 0
      // 072: getfield x/ocd1b2d918dd.ǖ Lx/occ2f8dff8d8;
      // 075: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 078: invokestatic x/ocbd4917c4b1.ƨ (Lnet/minecraft/entity/Entity;IDDIZ)V
      // 07b: goto 07f
      // 07e: athrow
      // 07f: aload 0
      // 080: getfield x/ocd1b2d918dd.բ Lx/occ2f8dff8d8;
      // 083: iload 3
      // 084: ifne 0e6
      // 087: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 08a: ifeq 0e2
      // 08d: goto 091
      // 090: athrow
      // 091: getstatic x/oc9755810e45.ӳ Lx/oc5a7218f48b;
      // 094: iload 3
      // 095: ifne 0a6
      // 098: goto 09c
      // 09b: athrow
      // 09c: ifnull 0c9
      // 09f: goto 0a3
      // 0a2: athrow
      // 0a3: getstatic x/oc9755810e45.ӳ Lx/oc5a7218f48b;
      // 0a6: iload 3
      // 0a7: ifne 0bb
      // 0aa: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 0ad: ifeq 0c9
      // 0b0: goto 0b4
      // 0b3: athrow
      // 0b4: getstatic x/oc9755810e45.ӳ Lx/oc5a7218f48b;
      // 0b7: goto 0bb
      // 0ba: athrow
      // 0bb: invokevirtual x/oc5a7218f48b.ÿ ()Z
      // 0be: iload 3
      // 0bf: ifne 0f1
      // 0c2: ifeq 0e2
      // 0c5: goto 0c9
      // 0c8: athrow
      // 0c9: aload 1
      // 0ca: ldc_w -141915123
      // 0cd: ldc_w -141915121
      // 0d0: ixor
      // 0d1: dconst_0
      // 0d2: dconst_0
      // 0d3: iload 2
      // 0d4: aload 0
      // 0d5: getfield x/ocd1b2d918dd.ǖ Lx/occ2f8dff8d8;
      // 0d8: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0db: invokestatic x/ocbd4917c4b1.ƨ (Lnet/minecraft/entity/Entity;IDDIZ)V
      // 0de: goto 0e2
      // 0e1: athrow
      // 0e2: aload 0
      // 0e3: getfield x/ocd1b2d918dd.ô Lx/occ2f8dff8d8;
      // 0e6: iload 3
      // 0e7: ifne 111
      // 0ea: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0ed: goto 0f1
      // 0f0: athrow
      // 0f1: ifeq 10d
      // 0f4: aload 1
      // 0f5: ldc_w -141915125
      // 0f8: ldc_w -141915121
      // 0fb: ixor
      // 0fc: dconst_0
      // 0fd: dconst_0
      // 0fe: iload 2
      // 0ff: aload 0
      // 100: getfield x/ocd1b2d918dd.ǖ Lx/occ2f8dff8d8;
      // 103: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 106: invokestatic x/ocbd4917c4b1.ƨ (Lnet/minecraft/entity/Entity;IDDIZ)V
      // 109: goto 10d
      // 10c: athrow
      // 10d: aload 0
      // 10e: getfield x/ocd1b2d918dd.ɶ Lx/occ2f8dff8d8;
      // 111: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 114: ifeq 130
      // 117: aload 1
      // 118: ldc_w -141915127
      // 11b: ldc_w -141915121
      // 11e: ixor
      // 11f: dconst_0
      // 120: dconst_0
      // 121: iload 2
      // 122: aload 0
      // 123: getfield x/ocd1b2d918dd.ǖ Lx/occ2f8dff8d8;
      // 126: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 129: invokestatic x/ocbd4917c4b1.ƨ (Lnet/minecraft/entity/Entity;IDDIZ)V
      // 12c: goto 130
      // 12f: athrow
      // 130: return
   }

   private void Ӄ(EntityPlayer param1, int param2, float param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 003: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 006: astore 5
      // 008: getstatic x/oce6044968f8.ђ Z
      // 00b: aload 1
      // 00c: getfield net/minecraft/entity/player/EntityPlayer.lastTickPosX D
      // 00f: aload 1
      // 010: getfield net/minecraft/entity/player/EntityPlayer.posX D
      // 013: aload 1
      // 014: getfield net/minecraft/entity/player/EntityPlayer.lastTickPosX D
      // 017: dsub
      // 018: fload 3
      // 019: f2d
      // 01a: dmul
      // 01b: dadd
      // 01c: aload 5
      // 01e: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosX D
      // 021: dsub
      // 022: dstore 6
      // 024: aload 1
      // 025: getfield net/minecraft/entity/player/EntityPlayer.lastTickPosY D
      // 028: aload 1
      // 029: getfield net/minecraft/entity/player/EntityPlayer.posY D
      // 02c: aload 1
      // 02d: getfield net/minecraft/entity/player/EntityPlayer.lastTickPosY D
      // 030: dsub
      // 031: fload 3
      // 032: f2d
      // 033: dmul
      // 034: dadd
      // 035: aload 5
      // 037: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosY D
      // 03a: dsub
      // 03b: dstore 8
      // 03d: istore 4
      // 03f: aload 1
      // 040: getfield net/minecraft/entity/player/EntityPlayer.lastTickPosZ D
      // 043: aload 1
      // 044: getfield net/minecraft/entity/player/EntityPlayer.posZ D
      // 047: aload 1
      // 048: getfield net/minecraft/entity/player/EntityPlayer.lastTickPosZ D
      // 04b: dsub
      // 04c: fload 3
      // 04d: f2d
      // 04e: dmul
      // 04f: dadd
      // 050: aload 5
      // 052: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosZ D
      // 055: dsub
      // 056: dstore 10
      // 058: invokestatic org/lwjgl/opengl/GL11.glPushMatrix ()V
      // 05b: ldc_w -5631044
      // 05e: ldc_w -5903293
      // 061: ixor
      // 062: invokestatic org/lwjgl/opengl/GL11.glPushAttrib (I)V
      // 065: ldc_w -5904479
      // 068: ldc_w -5903293
      // 06b: ixor
      // 06c: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 06f: ldc_w -5902527
      // 072: ldc_w -5903293
      // 075: ixor
      // 076: ldc_w -5902528
      // 079: ldc_w -5903293
      // 07c: ixor
      // 07d: invokestatic org/lwjgl/opengl/GL11.glBlendFunc (II)V
      // 080: ldc_w -5906014
      // 083: ldc_w -5903293
      // 086: ixor
      // 087: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 08a: ldc_w -5904590
      // 08d: ldc_w -5903293
      // 090: ixor
      // 091: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 094: bipush 0
      // 095: invokestatic org/lwjgl/opengl/GL11.glDepthMask (Z)V
      // 098: ldc_w -5904633
      // 09b: ldc_w -5903293
      // 09e: ixor
      // 09f: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 0a2: aload 0
      // 0a3: getfield x/ocd1b2d918dd.ȓ Lx/oca9cc61aada;
      // 0a6: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0a9: d2i
      // 0aa: istore 12
      // 0ac: iload 12
      // 0ae: iload 4
      // 0b0: ifne 150
      // 0b3: ldc_w -5903295
      // 0b6: ldc_w -5903293
      // 0b9: ixor
      // 0ba: if_icmpne 14a
      // 0bd: goto 0c1
      // 0c0: athrow
      // 0c1: aload 1
      // 0c2: invokevirtual net/minecraft/entity/player/EntityPlayer.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 0c5: ldc2_w 0.1
      // 0c8: ldc2_w 0.1
      // 0cb: ldc2_w 0.1
      // 0ce: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 0d1: dload 6
      // 0d3: aload 1
      // 0d4: getfield net/minecraft/entity/player/EntityPlayer.posX D
      // 0d7: dsub
      // 0d8: dload 8
      // 0da: aload 1
      // 0db: getfield net/minecraft/entity/player/EntityPlayer.posY D
      // 0de: dsub
      // 0df: dload 10
      // 0e1: aload 1
      // 0e2: getfield net/minecraft/entity/player/EntityPlayer.posZ D
      // 0e5: dsub
      // 0e6: invokevirtual net/minecraft/util/AxisAlignedBB.offset (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 0e9: astore 13
      // 0eb: iload 4
      // 0ed: ldc_w 1.5
      // 0f0: invokestatic org/lwjgl/opengl/GL11.glLineWidth (F)V
      // 0f3: ldc_w -5904541
      // 0f6: ldc_w -5903293
      // 0f9: ixor
      // 0fa: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 0fd: ldc_w -5906415
      // 100: ldc_w -5903293
      // 103: ixor
      // 104: ldc_w -5898943
      // 107: ldc_w -5903293
      // 10a: ixor
      // 10b: invokestatic org/lwjgl/opengl/GL11.glHint (II)V
      // 10e: aload 13
      // 110: iload 2
      // 111: ldc_w -5903277
      // 114: ldc_w -5903293
      // 117: ixor
      // 118: ishr
      // 119: ldc_w -5903172
      // 11c: ldc_w -5903293
      // 11f: ixor
      // 120: iand
      // 121: iload 2
      // 122: ldc_w -5903285
      // 125: ldc_w -5903293
      // 128: ixor
      // 129: ishr
      // 12a: ldc_w -5903172
      // 12d: ldc_w -5903293
      // 130: ixor
      // 131: iand
      // 132: iload 2
      // 133: ldc_w -5903172
      // 136: ldc_w -5903293
      // 139: ixor
      // 13a: iand
      // 13b: iload 2
      // 13c: ldc_w -5903269
      // 13f: ldc_w -5903293
      // 142: ixor
      // 143: iushr
      // 144: invokestatic net/minecraft/client/renderer/RenderGlobal.drawOutlinedBoundingBox (Lnet/minecraft/util/AxisAlignedBB;IIII)V
      // 147: ifeq 1aa
      // 14a: iload 12
      // 14c: goto 150
      // 14f: athrow
      // 150: iload 4
      // 152: ifne 169
      // 155: ldc_w -5903289
      // 158: ldc_w -5903293
      // 15b: ixor
      // 15c: if_icmpeq 17c
      // 15f: goto 163
      // 162: athrow
      // 163: iload 12
      // 165: goto 169
      // 168: athrow
      // 169: iload 4
      // 16b: ifne 1bb
      // 16e: ldc_w -5903290
      // 171: ldc_w -5903293
      // 174: ixor
      // 175: if_icmpne 1aa
      // 178: goto 17c
      // 17b: athrow
      // 17c: aload 0
      // 17d: aload 1
      // 17e: dload 6
      // 180: dload 8
      // 182: dload 10
      // 184: iload 2
      // 185: iload 12
      // 187: iload 4
      // 189: ifne 1a3
      // 18c: goto 190
      // 18f: athrow
      // 190: ldc_w -5903289
      // 193: ldc_w -5903293
      // 196: ixor
      // 197: if_icmpne 1a6
      // 19a: goto 19e
      // 19d: athrow
      // 19e: bipush 1
      // 19f: goto 1a3
      // 1a2: athrow
      // 1a3: goto 1a7
      // 1a6: bipush 0
      // 1a7: invokevirtual x/ocd1b2d918dd.Ϣ (Lnet/minecraft/entity/player/EntityPlayer;DDDIZ)V
      // 1aa: aload 0
      // 1ab: iload 4
      // 1ad: ifne 1ca
      // 1b0: getfield x/ocd1b2d918dd.Վ Lx/oca9cc61aada;
      // 1b3: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 1b6: d2i
      // 1b7: goto 1bb
      // 1ba: athrow
      // 1bb: ldc_w -5903295
      // 1be: ldc_w -5903293
      // 1c1: ixor
      // 1c2: if_icmpne 1d4
      // 1c5: aload 0
      // 1c6: goto 1ca
      // 1c9: athrow
      // 1ca: aload 1
      // 1cb: dload 6
      // 1cd: dload 8
      // 1cf: dload 10
      // 1d1: invokevirtual x/ocd1b2d918dd.Ҧ (Lnet/minecraft/entity/player/EntityPlayer;DDD)V
      // 1d4: invokestatic org/lwjgl/opengl/GL11.glPopAttrib ()V
      // 1d7: invokestatic org/lwjgl/opengl/GL11.glPopMatrix ()V
      // 1da: goto 1e8
      // 1dd: astore 14
      // 1df: invokestatic org/lwjgl/opengl/GL11.glPopAttrib ()V
      // 1e2: invokestatic org/lwjgl/opengl/GL11.glPopMatrix ()V
      // 1e5: aload 14
      // 1e7: athrow
      // 1e8: return
   }

   private void Ϣ(EntityPlayer param1, double param2, double param4, double param6, int param8, boolean param9) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: invokestatic net/minecraft/client/renderer/GlStateManager.pushMatrix ()V
      // 006: istore 10
      // 008: dload 2
      // 009: dload 4
      // 00b: aload 1
      // 00c: getfield net/minecraft/entity/player/EntityPlayer.height F
      // 00f: f2d
      // 010: ldc2_w 2.0
      // 013: ddiv
      // 014: dadd
      // 015: dload 6
      // 017: invokestatic net/minecraft/client/renderer/GlStateManager.translate (DDD)V
      // 01a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 01d: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 020: getfield net/minecraft/client/renderer/entity/RenderManager.playerViewY F
      // 023: iload 10
      // 025: ifne 03f
      // 028: fneg
      // 029: fconst_0
      // 02a: fconst_1
      // 02b: fconst_0
      // 02c: invokestatic net/minecraft/client/renderer/GlStateManager.rotate (FFFF)V
      // 02f: iload 9
      // 031: ifeq 042
      // 034: goto 038
      // 037: athrow
      // 038: ldc_w -0.098
      // 03b: goto 03f
      // 03e: athrow
      // 03f: goto 045
      // 042: ldc_w -0.1
      // 045: iload 9
      // 047: ifeq 051
      // 04a: ldc_w -0.098
      // 04d: goto 054
      // 050: athrow
      // 051: ldc_w -0.1
      // 054: iload 9
      // 056: ifeq 060
      // 059: ldc_w 0.098
      // 05c: goto 063
      // 05f: athrow
      // 060: ldc_w 0.1
      // 063: invokestatic net/minecraft/client/renderer/GlStateManager.scale (FFF)V
      // 066: iload 9
      // 068: ifeq 072
      // 06b: ldc2_w 26.6
      // 06e: goto 075
      // 071: athrow
      // 072: ldc2_w 23.3
      // 075: aload 1
      // 076: getfield net/minecraft/entity/player/EntityPlayer.width F
      // 079: f2d
      // 07a: dmul
      // 07b: ldc2_w 2.0
      // 07e: ddiv
      // 07f: d2f
      // 080: fstore 11
      // 082: iload 10
      // 084: ldc_w 12.0
      // 087: fstore 12
      // 089: ifne 27e
      // 08c: iload 9
      // 08e: ifeq 23a
      // 091: goto 095
      // 094: athrow
      // 095: fload 11
      // 097: fload 12
      // 099: fconst_1
      // 09a: fsub
      // 09b: fload 11
      // 09d: ldc_w 4.0
      // 0a0: fsub
      // 0a1: fload 12
      // 0a3: iload 8
      // 0a5: invokestatic x/ocd1b2d918dd.ȫ (FFFFI)V
      // 0a8: iload 10
      // 0aa: fload 11
      // 0ac: fneg
      // 0ad: fload 12
      // 0af: fconst_1
      // 0b0: fsub
      // 0b1: fload 11
      // 0b3: fneg
      // 0b4: ldc_w 4.0
      // 0b7: fadd
      // 0b8: fload 12
      // 0ba: iload 8
      // 0bc: invokestatic x/ocd1b2d918dd.ȫ (FFFFI)V
      // 0bf: fload 11
      // 0c1: fneg
      // 0c2: fload 12
      // 0c4: fload 11
      // 0c6: fneg
      // 0c7: fconst_1
      // 0c8: fadd
      // 0c9: fload 12
      // 0cb: ldc_w 4.0
      // 0ce: fsub
      // 0cf: iload 8
      // 0d1: invokestatic x/ocd1b2d918dd.ȫ (FFFFI)V
      // 0d4: fload 11
      // 0d6: fload 12
      // 0d8: fload 11
      // 0da: fconst_1
      // 0db: fsub
      // 0dc: fload 12
      // 0de: ldc_w 4.0
      // 0e1: fsub
      // 0e2: iload 8
      // 0e4: invokestatic x/ocd1b2d918dd.ȫ (FFFFI)V
      // 0e7: fload 11
      // 0e9: fload 12
      // 0eb: fneg
      // 0ec: fload 11
      // 0ee: ldc_w 4.0
      // 0f1: fsub
      // 0f2: fload 12
      // 0f4: fneg
      // 0f5: fconst_1
      // 0f6: fadd
      // 0f7: iload 8
      // 0f9: invokestatic x/ocd1b2d918dd.ȫ (FFFFI)V
      // 0fc: fload 11
      // 0fe: fneg
      // 0ff: fload 12
      // 101: fneg
      // 102: fload 11
      // 104: fneg
      // 105: ldc_w 4.0
      // 108: fadd
      // 109: fload 12
      // 10b: fneg
      // 10c: fconst_1
      // 10d: fadd
      // 10e: iload 8
      // 110: invokestatic x/ocd1b2d918dd.ȫ (FFFFI)V
      // 113: fload 11
      // 115: fneg
      // 116: fload 12
      // 118: fneg
      // 119: fconst_1
      // 11a: fadd
      // 11b: fload 11
      // 11d: fneg
      // 11e: fconst_1
      // 11f: fadd
      // 120: fload 12
      // 122: fneg
      // 123: ldc_w 4.0
      // 126: fadd
      // 127: iload 8
      // 129: invokestatic x/ocd1b2d918dd.ȫ (FFFFI)V
      // 12c: fload 11
      // 12e: fload 12
      // 130: fneg
      // 131: fconst_1
      // 132: fadd
      // 133: fload 11
      // 135: fconst_1
      // 136: fsub
      // 137: fload 12
      // 139: fneg
      // 13a: ldc_w 4.0
      // 13d: fadd
      // 13e: iload 8
      // 140: invokestatic x/ocd1b2d918dd.ȫ (FFFFI)V
      // 143: fload 11
      // 145: fload 12
      // 147: fload 11
      // 149: ldc_w 4.0
      // 14c: fsub
      // 14d: fload 12
      // 14f: ldc_w 0.2
      // 152: fadd
      // 153: ldc_w -1866723601
      // 156: ldc_w 1874595567
      // 159: ixor
      // 15a: invokestatic x/ocd1b2d918dd.ȫ (FFFFI)V
      // 15d: fload 11
      // 15f: fneg
      // 160: fload 12
      // 162: fload 11
      // 164: fneg
      // 165: ldc_w 4.0
      // 168: fadd
      // 169: fload 12
      // 16b: ldc_w 0.2
      // 16e: fadd
      // 16f: ldc_w -1866723601
      // 172: ldc_w 1874595567
      // 175: ixor
      // 176: invokestatic x/ocd1b2d918dd.ȫ (FFFFI)V
      // 179: fload 11
      // 17b: fneg
      // 17c: ldc_w 0.2
      // 17f: fsub
      // 180: fload 12
      // 182: ldc_w 0.2
      // 185: fadd
      // 186: fload 11
      // 188: fneg
      // 189: fload 12
      // 18b: ldc_w 4.0
      // 18e: fsub
      // 18f: ldc_w -1866723601
      // 192: ldc_w 1874595567
      // 195: ixor
      // 196: invokestatic x/ocd1b2d918dd.ȫ (FFFFI)V
      // 199: fload 11
      // 19b: ldc_w 0.2
      // 19e: fadd
      // 19f: fload 12
      // 1a1: ldc_w 0.2
      // 1a4: fadd
      // 1a5: fload 11
      // 1a7: fload 12
      // 1a9: ldc_w 4.0
      // 1ac: fsub
      // 1ad: ldc_w -1866723601
      // 1b0: ldc_w 1874595567
      // 1b3: ixor
      // 1b4: invokestatic x/ocd1b2d918dd.ȫ (FFFFI)V
      // 1b7: fload 11
      // 1b9: ldc_w 0.2
      // 1bc: fadd
      // 1bd: fload 12
      // 1bf: fneg
      // 1c0: fload 11
      // 1c2: ldc_w 4.0
      // 1c5: fsub
      // 1c6: fload 12
      // 1c8: fneg
      // 1c9: ldc_w 0.2
      // 1cc: fsub
      // 1cd: ldc_w -1866723601
      // 1d0: ldc_w 1874595567
      // 1d3: ixor
      // 1d4: invokestatic x/ocd1b2d918dd.ȫ (FFFFI)V
      // 1d7: fload 11
      // 1d9: fneg
      // 1da: ldc_w 0.2
      // 1dd: fsub
      // 1de: fload 12
      // 1e0: fneg
      // 1e1: fload 11
      // 1e3: fneg
      // 1e4: ldc_w 4.0
      // 1e7: fadd
      // 1e8: fload 12
      // 1ea: fneg
      // 1eb: ldc_w 0.2
      // 1ee: fsub
      // 1ef: ldc_w -1866723601
      // 1f2: ldc_w 1874595567
      // 1f5: ixor
      // 1f6: invokestatic x/ocd1b2d918dd.ȫ (FFFFI)V
      // 1f9: fload 11
      // 1fb: fneg
      // 1fc: ldc_w 0.2
      // 1ff: fsub
      // 200: fload 12
      // 202: fneg
      // 203: fload 11
      // 205: fneg
      // 206: fload 12
      // 208: fneg
      // 209: ldc_w 4.0
      // 20c: fadd
      // 20d: ldc_w -1866723601
      // 210: ldc_w 1874595567
      // 213: ixor
      // 214: invokestatic x/ocd1b2d918dd.ȫ (FFFFI)V
      // 217: fload 11
      // 219: ldc_w 0.2
      // 21c: fadd
      // 21d: fload 12
      // 21f: fneg
      // 220: fload 11
      // 222: fload 12
      // 224: fneg
      // 225: ldc_w 4.0
      // 228: fadd
      // 229: ldc_w -1866723601
      // 22c: ldc_w 1874595567
      // 22f: ixor
      // 230: invokestatic x/ocd1b2d918dd.ȫ (FFFFI)V
      // 233: ifeq 29a
      // 236: goto 23a
      // 239: athrow
      // 23a: fload 11
      // 23c: fload 12
      // 23e: fload 11
      // 240: fneg
      // 241: fload 12
      // 243: ldc_w 0.4
      // 246: fadd
      // 247: iload 8
      // 249: invokestatic x/ocd1b2d918dd.ȫ (FFFFI)V
      // 24c: fload 11
      // 24e: fload 12
      // 250: fneg
      // 251: fload 11
      // 253: fneg
      // 254: fload 12
      // 256: fneg
      // 257: ldc_w 0.4
      // 25a: fadd
      // 25b: iload 8
      // 25d: invokestatic x/ocd1b2d918dd.ȫ (FFFFI)V
      // 260: fload 11
      // 262: fload 12
      // 264: fneg
      // 265: ldc_w 0.4
      // 268: fadd
      // 269: fload 11
      // 26b: ldc_w 0.4
      // 26e: fsub
      // 26f: fload 12
      // 271: ldc_w 0.4
      // 274: fadd
      // 275: iload 8
      // 277: invokestatic x/ocd1b2d918dd.ȫ (FFFFI)V
      // 27a: goto 27e
      // 27d: athrow
      // 27e: fload 11
      // 280: fneg
      // 281: fload 12
      // 283: fneg
      // 284: ldc_w 0.4
      // 287: fadd
      // 288: fload 11
      // 28a: fneg
      // 28b: ldc_w 0.4
      // 28e: fadd
      // 28f: fload 12
      // 291: ldc_w 0.4
      // 294: fadd
      // 295: iload 8
      // 297: invokestatic x/ocd1b2d918dd.ȫ (FFFFI)V
      // 29a: invokestatic net/minecraft/client/renderer/GlStateManager.popMatrix ()V
      // 29d: return
   }

   private void Ҧ(EntityPlayer param1, double param2, double param4, double param6) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: aload 1
      // 04: invokevirtual net/minecraft/entity/player/EntityPlayer.getMaxHealth ()F
      // 07: fstore 9
      // 09: istore 8
      // 0b: fload 9
      // 0d: iload 8
      // 0f: ifne 31
      // 12: fconst_0
      // 13: fcmpg
      // 14: ifgt 1d
      // 17: goto 1b
      // 1a: athrow
      // 1b: return
      // 1c: athrow
      // 1d: fconst_0
      // 1e: fconst_1
      // 1f: aload 1
      // 20: invokevirtual net/minecraft/entity/player/EntityPlayer.getHealth ()F
      // 23: aload 1
      // 24: invokevirtual net/minecraft/entity/player/EntityPlayer.getAbsorptionAmount ()F
      // 27: fadd
      // 28: fload 9
      // 2a: fdiv
      // 2b: invokestatic java/lang/Math.min (FF)F
      // 2e: invokestatic java/lang/Math.max (FF)F
      // 31: fstore 10
      // 33: aload 1
      // 34: getfield net/minecraft/entity/player/EntityPlayer.height F
      // 37: ldc_w 0.2
      // 3a: fadd
      // 3b: fstore 11
      // 3d: invokestatic net/minecraft/client/renderer/GlStateManager.pushMatrix ()V
      // 40: dload 2
      // 41: dload 4
      // 43: ldc2_w 0.1
      // 46: dsub
      // 47: dload 6
      // 49: invokestatic net/minecraft/client/renderer/GlStateManager.translate (DDD)V
      // 4c: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 4f: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 52: getfield net/minecraft/client/renderer/entity/RenderManager.playerViewY F
      // 55: fneg
      // 56: fconst_0
      // 57: fconst_1
      // 58: fconst_0
      // 59: invokestatic net/minecraft/client/renderer/GlStateManager.rotate (FFFF)V
      // 5c: ldc_w 0.5725
      // 5f: ldc_w -0.0275
      // 62: ldc_w 0.7275
      // 65: fload 11
      // 67: ldc_w 0.0275
      // 6a: fadd
      // 6b: ldc_w 231395090
      // 6e: ldc_w -221589742
      // 71: ixor
      // 72: invokestatic x/ocd1b2d918dd.ȫ (FFFFI)V
      // 75: ldc_w 0.6
      // 78: fconst_0
      // 79: ldc_w 0.7
      // 7c: fload 11
      // 7e: ldc_w 227184466
      // 81: ldc_w -221589742
      // 84: ixor
      // 85: invokestatic x/ocd1b2d918dd.ȫ (FFFFI)V
      // 88: ldc_w 0.6
      // 8b: fconst_0
      // 8c: ldc_w 0.7
      // 8f: fload 11
      // 91: fload 10
      // 93: fmul
      // 94: fload 10
      // 96: invokestatic x/ocd1b2d918dd.Ȥ (F)I
      // 99: invokestatic x/ocd1b2d918dd.ȫ (FFFFI)V
      // 9c: invokestatic net/minecraft/client/renderer/GlStateManager.popMatrix ()V
      // 9f: return
   }

   private static void ȫ(float var0, float var1, float var2, float var3, int var4) {
      GL11.glColor4f(
         (var4 >> (1436616607 ^ 1436616591) & (1436616560 ^ 1436616591)) / 255.0F,
         (var4 >> (1436616583 ^ 1436616591) & (1436616560 ^ 1436616591)) / 255.0F,
         (var4 & (1436616560 ^ 1436616591)) / 255.0F,
         (var4 >>> (1436616599 ^ 1436616591)) / 255.0F
      );
      GL11.glBegin(1436616584 ^ 1436616591);
      GL11.glVertex2f(var0, var1);
      GL11.glVertex2f(var0, var3);
      GL11.glVertex2f(var2, var3);
      GL11.glVertex2f(var2, var1);
      oc170ea29aae.ŷ();
   }

   private static int Ȥ(float param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: fconst_0
      // 04: fconst_1
      // 05: fload 0
      // 06: invokestatic java/lang/Math.min (FF)F
      // 09: invokestatic java/lang/Math.max (FF)F
      // 0c: fstore 2
      // 0d: istore 1
      // 0e: fload 2
      // 0f: ldc_w 0.9
      // 12: iload 1
      // 13: ifne 33
      // 16: fcmpl
      // 17: iflt 27
      // 1a: goto 1e
      // 1d: athrow
      // 1e: ldc_w -800519606
      // 21: ldc_w 793376074
      // 24: ixor
      // 25: ireturn
      // 26: athrow
      // 27: fload 2
      // 28: iload 1
      // 29: ifne 54
      // 2c: ldc_w 0.55
      // 2f: goto 33
      // 32: athrow
      // 33: fcmpl
      // 34: iflt 53
      // 37: ldc_w -793376182
      // 3a: ldc_w 793376074
      // 3d: ixor
      // 3e: ldc_w -800519606
      // 41: ldc_w 793376074
      // 44: ixor
      // 45: fload 2
      // 46: ldc_w 0.55
      // 49: fsub
      // 4a: ldc_w 0.35
      // 4d: fdiv
      // 4e: invokestatic x/ocd1b2d918dd.Ȅ (IIF)I
      // 51: ireturn
      // 52: athrow
      // 53: fload 2
      // 54: ldc_w 0.45
      // 57: iload 1
      // 58: ifne 70
      // 5b: fcmpl
      // 5c: iflt 6c
      // 5f: goto 63
      // 62: athrow
      // 63: ldc_w -793376182
      // 66: ldc_w 793376074
      // 69: ixor
      // 6a: ireturn
      // 6b: athrow
      // 6c: fload 2
      // 6d: ldc_w 0.1
      // 70: fcmpl
      // 71: iload 1
      // 72: ifne 9f
      // 75: iflt 98
      // 78: goto 7c
      // 7b: athrow
      // 7c: ldc_w -793316022
      // 7f: ldc_w 793376074
      // 82: ixor
      // 83: ldc_w -793376182
      // 86: ldc_w 793376074
      // 89: ixor
      // 8a: fload 2
      // 8b: ldc_w 0.1
      // 8e: fsub
      // 8f: ldc_w 0.35
      // 92: fdiv
      // 93: invokestatic x/ocd1b2d918dd.Ȅ (IIF)I
      // 96: ireturn
      // 97: athrow
      // 98: ldc_w -793316022
      // 9b: ldc_w 793376074
      // 9e: ixor
      // 9f: ireturn
   }

   private static int Ȅ(int var0, int var1, float var2) {
      int var3 = (int)(
         (var0 >> (-1391121494 ^ -1391121478) & (-1391121595 ^ -1391121478))
            + ((var1 >> (-1391121494 ^ -1391121478) & (-1391121595 ^ -1391121478)) - (var0 >> (-1391121494 ^ -1391121478) & (-1391121595 ^ -1391121478)))
               * var2
      );
      int var4 = (int)(
         (var0 >> (-1391121486 ^ -1391121478) & (-1391121595 ^ -1391121478))
            + ((var1 >> (-1391121486 ^ -1391121478) & (-1391121595 ^ -1391121478)) - (var0 >> (-1391121486 ^ -1391121478) & (-1391121595 ^ -1391121478)))
               * var2
      );
      return 1377119162 ^ -1391121478 | var3 << (-1391121494 ^ -1391121478) | var4 << (-1391121486 ^ -1391121478);
   }

   private void Ų(float var1) {
      boolean var10000 = oce6044968f8.ђ;
      RenderManager var3 = oc69da1aa7f5.ő.getRenderManager();
      boolean var2 = var10000;

      try {
         if (var3 == null) {
            return;
         }
      } catch (ocbde1165e4e var8) {
         throw var8;
      }

      ScaledResolution var4 = new ScaledResolution(oc69da1aa7f5.ő);
      oc69da1aa7f5.ő.entityRenderer.callSetupCameraTransform(var1, 0);
      this.Ȕ = ocbd4917c4b1.ө(this.Ȕ, var4.getScaleFactor());
      oc69da1aa7f5.ő.entityRenderer.setupOverlayRendering();
      int var5 = var4.getScaledWidth();
      int var6 = var4.getScaledHeight();
      int var7 = 0;

      while (var7 < this.Β) {
         this.ɧ(this.Ʃ.get(var7), var3, var5, var6, var1);
         var7++;
         if (var2) {
            break;
         }
      }
   }

   private void ɧ(oc55bd31ebd1 param1, RenderManager param2, int param3, int param4, float param5) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: aload 1
      // 001: getfield x/oc55bd31ebd1.ň Lnet/minecraft/entity/EntityLivingBase;
      // 004: astore 7
      // 006: aload 7
      // 008: getfield net/minecraft/entity/EntityLivingBase.lastTickPosX D
      // 00b: aload 7
      // 00d: getfield net/minecraft/entity/EntityLivingBase.posX D
      // 010: aload 7
      // 012: getfield net/minecraft/entity/EntityLivingBase.lastTickPosX D
      // 015: dsub
      // 016: fload 5
      // 018: f2d
      // 019: dmul
      // 01a: dadd
      // 01b: aload 2
      // 01c: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosX D
      // 01f: dsub
      // 020: dstore 8
      // 022: aload 7
      // 024: getfield net/minecraft/entity/EntityLivingBase.lastTickPosY D
      // 027: aload 7
      // 029: getfield net/minecraft/entity/EntityLivingBase.posY D
      // 02c: aload 7
      // 02e: getfield net/minecraft/entity/EntityLivingBase.lastTickPosY D
      // 031: dsub
      // 032: fload 5
      // 034: f2d
      // 035: dmul
      // 036: dadd
      // 037: aload 2
      // 038: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosY D
      // 03b: dsub
      // 03c: dstore 10
      // 03e: aload 7
      // 040: getfield net/minecraft/entity/EntityLivingBase.lastTickPosZ D
      // 043: aload 7
      // 045: getfield net/minecraft/entity/EntityLivingBase.posZ D
      // 048: aload 7
      // 04a: getfield net/minecraft/entity/EntityLivingBase.lastTickPosZ D
      // 04d: dsub
      // 04e: fload 5
      // 050: f2d
      // 051: dmul
      // 052: dadd
      // 053: aload 2
      // 054: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosZ D
      // 057: dsub
      // 058: dstore 12
      // 05a: aload 7
      // 05c: invokevirtual net/minecraft/entity/EntityLivingBase.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 05f: ldc2_w 0.1
      // 062: ldc2_w 0.1
      // 065: ldc2_w 0.1
      // 068: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 06b: astore 14
      // 06d: aload 14
      // 06f: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 072: aload 7
      // 074: getfield net/minecraft/entity/EntityLivingBase.posX D
      // 077: dsub
      // 078: dload 8
      // 07a: dadd
      // 07b: dstore 15
      // 07d: aload 14
      // 07f: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 082: aload 7
      // 084: getfield net/minecraft/entity/EntityLivingBase.posY D
      // 087: dsub
      // 088: dload 10
      // 08a: dadd
      // 08b: dstore 17
      // 08d: getstatic x/oce6044968f8.ђ Z
      // 090: aload 14
      // 092: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 095: aload 7
      // 097: getfield net/minecraft/entity/EntityLivingBase.posZ D
      // 09a: dsub
      // 09b: dload 12
      // 09d: dadd
      // 09e: dstore 19
      // 0a0: aload 14
      // 0a2: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 0a5: aload 7
      // 0a7: getfield net/minecraft/entity/EntityLivingBase.posX D
      // 0aa: dsub
      // 0ab: dload 8
      // 0ad: dadd
      // 0ae: dstore 21
      // 0b0: aload 14
      // 0b2: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 0b5: aload 7
      // 0b7: getfield net/minecraft/entity/EntityLivingBase.posY D
      // 0ba: dsub
      // 0bb: dload 10
      // 0bd: dadd
      // 0be: dstore 23
      // 0c0: aload 14
      // 0c2: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 0c5: aload 7
      // 0c7: getfield net/minecraft/entity/EntityLivingBase.posZ D
      // 0ca: dsub
      // 0cb: dload 12
      // 0cd: dadd
      // 0ce: dstore 25
      // 0d0: ldc2_w Infinity
      // 0d3: dstore 27
      // 0d5: ldc2_w Infinity
      // 0d8: dstore 29
      // 0da: istore 6
      // 0dc: ldc2_w -Infinity
      // 0df: dstore 31
      // 0e1: ldc2_w -Infinity
      // 0e4: dstore 33
      // 0e6: bipush 0
      // 0e7: istore 35
      // 0e9: bipush 0
      // 0ea: istore 36
      // 0ec: iload 36
      // 0ee: ldc_w 2079408646
      // 0f1: ldc_w 2079408654
      // 0f4: ixor
      // 0f5: if_icmpge 219
      // 0f8: iload 6
      // 0fa: ifne 228
      // 0fd: iload 36
      // 0ff: bipush 1
      // 100: iand
      // 101: ifne 10e
      // 104: goto 108
      // 107: athrow
      // 108: dload 15
      // 10a: goto 110
      // 10d: athrow
      // 10e: dload 21
      // 110: dstore 37
      // 112: iload 36
      // 114: ldc_w 2079408652
      // 117: ldc_w 2079408654
      // 11a: ixor
      // 11b: iand
      // 11c: ifne 125
      // 11f: dload 17
      // 121: goto 127
      // 124: athrow
      // 125: dload 23
      // 127: dstore 39
      // 129: iload 36
      // 12b: ldc_w 2079408650
      // 12e: ldc_w 2079408654
      // 131: ixor
      // 132: iand
      // 133: ifne 13c
      // 136: dload 19
      // 138: goto 13e
      // 13b: athrow
      // 13c: dload 25
      // 13e: dstore 41
      // 140: iload 6
      // 142: ifne 214
      // 145: aload 0
      // 146: getfield x/ocd1b2d918dd.Ȕ Lx/oc29a4412fc2;
      // 149: dload 37
      // 14b: dload 39
      // 14d: dload 41
      // 14f: aload 0
      // 150: getfield x/ocd1b2d918dd.Ƽ [D
      // 153: invokestatic x/ocbd4917c4b1.Ǜ (Lx/oc29a4412fc2;DDD[D)Z
      // 156: ifeq 211
      // 159: goto 15d
      // 15c: athrow
      // 15d: aload 0
      // 15e: getfield x/ocd1b2d918dd.Ƽ [D
      // 161: ldc_w 2079408652
      // 164: ldc_w 2079408654
      // 167: ixor
      // 168: daload
      // 169: dstore 43
      // 16b: dload 43
      // 16d: aload 0
      // 16e: invokevirtual x/ocd1b2d918dd.ǌ ()Z
      // 171: ifeq 179
      // 174: dconst_1
      // 175: goto 17c
      // 178: athrow
      // 179: ldc2_w 1.0003684
      // 17c: dcmpl
      // 17d: iload 6
      // 17f: ifne 19a
      // 182: ifge 211
      // 185: goto 189
      // 188: athrow
      // 189: dload 43
      // 18b: iload 6
      // 18d: ifne 1af
      // 190: goto 194
      // 193: athrow
      // 194: dconst_0
      // 195: dcmpg
      // 196: goto 19a
      // 199: athrow
      // 19a: ifgt 1a6
      // 19d: iload 6
      // 19f: ifeq 211
      // 1a2: goto 1a6
      // 1a5: athrow
      // 1a6: bipush 1
      // 1a7: istore 35
      // 1a9: aload 0
      // 1aa: getfield x/ocd1b2d918dd.Ƽ [D
      // 1ad: bipush 0
      // 1ae: daload
      // 1af: dstore 45
      // 1b1: aload 0
      // 1b2: getfield x/ocd1b2d918dd.Ƽ [D
      // 1b5: bipush 1
      // 1b6: daload
      // 1b7: dstore 47
      // 1b9: dload 45
      // 1bb: iload 6
      // 1bd: ifne 1d0
      // 1c0: dload 27
      // 1c2: dcmpg
      // 1c3: ifge 1ce
      // 1c6: goto 1ca
      // 1c9: athrow
      // 1ca: dload 45
      // 1cc: dstore 27
      // 1ce: dload 47
      // 1d0: dload 29
      // 1d2: iload 6
      // 1d4: ifne 1f0
      // 1d7: dcmpg
      // 1d8: ifge 1e3
      // 1db: goto 1df
      // 1de: athrow
      // 1df: dload 47
      // 1e1: dstore 29
      // 1e3: dload 45
      // 1e5: iload 6
      // 1e7: ifne 1fa
      // 1ea: dload 31
      // 1ec: goto 1f0
      // 1ef: athrow
      // 1f0: dcmpl
      // 1f1: ifle 1f8
      // 1f4: dload 45
      // 1f6: dstore 31
      // 1f8: dload 47
      // 1fa: iload 6
      // 1fc: ifne 20f
      // 1ff: dload 33
      // 201: dcmpl
      // 202: ifle 211
      // 205: goto 209
      // 208: athrow
      // 209: dload 47
      // 20b: goto 20f
      // 20e: athrow
      // 20f: dstore 33
      // 211: iinc 36 1
      // 214: iload 6
      // 216: ifeq 0ec
      // 219: iload 35
      // 21b: iload 6
      // 21d: ifne 22c
      // 220: ifne 228
      // 223: goto 227
      // 226: athrow
      // 227: return
      // 228: aload 0
      // 229: invokevirtual x/ocd1b2d918dd.ǌ ()Z
      // 22c: iload 6
      // 22e: ifne 269
      // 231: ifne 25b
      // 234: goto 238
      // 237: athrow
      // 238: dconst_0
      // 239: dload 27
      // 23b: invokestatic java/lang/Math.max (DD)D
      // 23e: dstore 27
      // 240: dconst_0
      // 241: dload 29
      // 243: invokestatic java/lang/Math.max (DD)D
      // 246: dstore 29
      // 248: iload 3
      // 249: i2d
      // 24a: dload 31
      // 24c: invokestatic java/lang/Math.min (DD)D
      // 24f: dstore 31
      // 251: iload 4
      // 253: i2d
      // 254: dload 33
      // 256: invokestatic java/lang/Math.min (DD)D
      // 259: dstore 33
      // 25b: dload 31
      // 25d: iload 6
      // 25f: ifne 26e
      // 262: dload 27
      // 264: dcmpg
      // 265: goto 269
      // 268: athrow
      // 269: ifle 27d
      // 26c: dload 33
      // 26e: dload 29
      // 270: dcmpg
      // 271: iload 6
      // 273: ifne 28b
      // 276: ifgt 27e
      // 279: goto 27d
      // 27c: athrow
      // 27d: return
      // 27e: aload 0
      // 27f: iload 6
      // 281: ifne 2a9
      // 284: invokevirtual x/ocd1b2d918dd.ǌ ()Z
      // 287: goto 28b
      // 28a: athrow
      // 28b: ifeq 2a4
      // 28e: aload 0
      // 28f: aload 1
      // 290: dload 27
      // 292: dload 29
      // 294: dload 31
      // 296: dload 33
      // 298: invokevirtual x/ocd1b2d918dd.ʈ (Lx/oc55bd31ebd1;DDDD)V
      // 29b: iload 6
      // 29d: ifeq 2b5
      // 2a0: goto 2a4
      // 2a3: athrow
      // 2a4: aload 0
      // 2a5: goto 2a9
      // 2a8: athrow
      // 2a9: aload 1
      // 2aa: dload 27
      // 2ac: dload 29
      // 2ae: dload 31
      // 2b0: dload 33
      // 2b2: invokevirtual x/ocd1b2d918dd.Ý (Lx/oc55bd31ebd1;DDDD)V
      // 2b5: return
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private void ʈ(oc55bd31ebd1 var1, double var2, double var4, double var6, double var8) {
      int var10000 = oce6044968f8.ђ;
      GL11.glPushMatrix();
      boolean var10 = (boolean)var10000;
      GL11.glPushAttrib(1391743875 ^ 1392225404);
      boolean var18 = false /* VF: Semaphore variable */;

      try {
         var18 = true;
         GL11.glEnable(1392224158 ^ 1392225404);
         GL11.glBlendFunc(1392226174 ^ 1392225404, 1392226175 ^ 1392225404);
         GL11.glDisable(1392222621 ^ 1392225404);
         GL11.glDisable(1392224013 ^ 1392225404);
         GL11.glDisable(1392224056 ^ 1392225404);
         GL11.glEnable(1392224092 ^ 1392225404);
         var10000 = 1392222254 ^ 1392225404;
         if (!var10) {
            GL11.glHint(var10000, 1392229758 ^ 1392225404);
            if ((int)this.ȓ.Ӂ() == 1) {
               int var11 = var1.ƕ;
               int var12 = var11 & (-1376015236 ^ 1392225404) | (var11 & (1376211072 ^ 1392225404)) >> (1392225406 ^ 1392225404);
               ԟ(var2, var4, var6, var8, 3.0F, var12);
               ԟ(var2, var4, var6, var8, 1.5F, var11);
            }

            var10000 = (int)this.Վ.Ӂ();
         }

         if (var10000 == 1) {
            EntityLivingBase var20 = var1.ň;
            if (var10) {
               var18 = false;
               return;
            }

            float var21 = var20.getMaxHealth();
            if (var21 > 0.0F) {
               float var13 = Math.max(0.0F, Math.min(1.0F, (var20.getHealth() + var20.getAbsorptionAmount()) / var21));
               double var14 = var2 - (var6 - var2) * 0.08;
               Ȥ(var14, var4, var14, var8, 3.0F, Р(Ȥ(var13)));
               Ȥ(var14, var8, var14, var8 - (var8 - var4) * var13, 1.5F, Ȥ(var13));
               var18 = false;
            } else {
               var18 = false;
            }
         } else {
            var18 = false;
         }
      } finally {
         if (var18) {
            GL11.glPopAttrib();
            GL11.glPopMatrix();
         }
      }

      GL11.glPopAttrib();
      GL11.glPopMatrix();
   }

   private static void ԟ(double var0, double var2, double var4, double var6, float var8, int var9) {
      GL11.glLineWidth(var8);
      GL11.glColor4f(
         (var9 >> (2001471168 ^ 2001471184) & (2001471023 ^ 2001471184)) / 255.0F,
         (var9 >> (2001471192 ^ 2001471184) & (2001471023 ^ 2001471184)) / 255.0F,
         (var9 & (2001471023 ^ 2001471184)) / 255.0F,
         (var9 >>> (2001471176 ^ 2001471184)) / 255.0F
      );
      GL11.glBegin(2001471186 ^ 2001471184);
      GL11.glVertex2d(var0, var2);
      GL11.glVertex2d(var4, var2);
      GL11.glVertex2d(var4, var6);
      GL11.glVertex2d(var0, var6);
      oc170ea29aae.ŷ();
   }

   static int Р(int var0) {
      int var1 = (int)((var0 >> (-1999874495 ^ -1999874479) & (-1999874386 ^ -1999874479)) * 0.2F);
      int var2 = (int)((var0 >> (-1999874471 ^ -1999874479) & (-1999874386 ^ -1999874479)) * 0.2F);
      int var3 = (int)((var0 & (-1999874386 ^ -1999874479)) * 0.2F);
      return var0 & (2009880145 ^ -1999874479) | var1 << (-1999874495 ^ -1999874479) | var2 << (-1999874471 ^ -1999874479) | var3;
   }

   private static void Ȥ(double var0, double var2, double var4, double var6, float var8, int var9) {
      GL11.glLineWidth(var8);
      GL11.glColor4f(
         (var9 >> (-124387029 ^ -124387013) & (-124386876 ^ -124387013)) / 255.0F,
         (var9 >> (-124387021 ^ -124387013) & (-124386876 ^ -124387013)) / 255.0F,
         (var9 & (-124386876 ^ -124387013)) / 255.0F,
         (var9 >>> (-124387037 ^ -124387013)) / 255.0F
      );
      GL11.glBegin(1);
      GL11.glVertex2d(var0, var2);
      GL11.glVertex2d(var4, var6);
      oc170ea29aae.ŷ();
   }

   public void ӣ(EntityPlayer var1, ModelBiped var2, int var3, float var4) {
      RenderManager var5 = oc69da1aa7f5.ő.getRenderManager();
      double var6 = var1.lastTickPosX + (var1.posX - var1.lastTickPosX) * var4 - var5.viewerPosX;
      double var8 = var1.lastTickPosY + (var1.posY - var1.lastTickPosY) * var4 - var5.viewerPosY;
      double var10 = var1.lastTickPosZ + (var1.posZ - var1.lastTickPosZ) * var4 - var5.viewerPosZ;
      this.ʐ(var1, var2, var3, var4, var6, var8, var10);
   }

   private void ʐ(EntityPlayer param1, ModelBiped param2, int param3, float param4, double param5, double param7, double param9) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: invokestatic org/lwjgl/opengl/GL11.glPushMatrix ()V
      // 003: getstatic x/oce6044968f8.ђ Z
      // 006: ldc_w -238105005
      // 009: ldc_w -238997076
      // 00c: ixor
      // 00d: invokestatic org/lwjgl/opengl/GL11.glPushAttrib (I)V
      // 010: istore 11
      // 012: ldc_w -238994723
      // 015: ldc_w -238997076
      // 018: ixor
      // 019: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 01c: bipush 0
      // 01d: invokestatic org/lwjgl/opengl/GL11.glDepthMask (Z)V
      // 020: ldc_w -238994866
      // 023: ldc_w -238997076
      // 026: ixor
      // 027: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 02a: ldc_w -238996818
      // 02d: ldc_w -238997076
      // 030: ixor
      // 031: ldc_w -238996817
      // 034: ldc_w -238997076
      // 037: ixor
      // 038: invokestatic org/lwjgl/opengl/GL11.glBlendFunc (II)V
      // 03b: ldc_w -238994692
      // 03e: ldc_w -238997076
      // 041: ixor
      // 042: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 045: ldc_w -238994355
      // 048: ldc_w -238997076
      // 04b: ixor
      // 04c: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 04f: ldc_w -238994804
      // 052: ldc_w -238997076
      // 055: ixor
      // 056: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 059: ldc_w -238993922
      // 05c: ldc_w -238997076
      // 05f: ixor
      // 060: ldc_w -239001426
      // 063: ldc_w -238997076
      // 066: ixor
      // 067: invokestatic org/lwjgl/opengl/GL11.glHint (II)V
      // 06a: iload 3
      // 06b: ldc_w -238997060
      // 06e: ldc_w -238997076
      // 071: ixor
      // 072: ishr
      // 073: ldc_w -238997165
      // 076: ldc_w -238997076
      // 079: ixor
      // 07a: iand
      // 07b: i2f
      // 07c: ldc_w 255.0
      // 07f: fdiv
      // 080: iload 3
      // 081: ldc_w -238997084
      // 084: ldc_w -238997076
      // 087: ixor
      // 088: ishr
      // 089: ldc_w -238997165
      // 08c: ldc_w -238997076
      // 08f: ixor
      // 090: iand
      // 091: i2f
      // 092: ldc_w 255.0
      // 095: fdiv
      // 096: iload 3
      // 097: ldc_w -238997165
      // 09a: ldc_w -238997076
      // 09d: ixor
      // 09e: iand
      // 09f: i2f
      // 0a0: ldc_w 255.0
      // 0a3: fdiv
      // 0a4: iload 3
      // 0a5: ldc_w -238997068
      // 0a8: ldc_w -238997076
      // 0ab: ixor
      // 0ac: iushr
      // 0ad: ldc_w -238997165
      // 0b0: ldc_w -238997076
      // 0b3: ixor
      // 0b4: iand
      // 0b5: i2f
      // 0b6: ldc_w 255.0
      // 0b9: fdiv
      // 0ba: invokestatic org/lwjgl/opengl/GL11.glColor4f (FFFF)V
      // 0bd: dload 5
      // 0bf: dload 7
      // 0c1: dload 9
      // 0c3: invokestatic org/lwjgl/opengl/GL11.glTranslated (DDD)V
      // 0c6: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0c9: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0cc: aload 1
      // 0cd: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getDistanceToEntity (Lnet/minecraft/entity/Entity;)F
      // 0d0: fstore 12
      // 0d2: fload 12
      // 0d4: aload 0
      // 0d5: getfield x/ocd1b2d918dd.Ǚ Lx/oca9cc61aada;
      // 0d8: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0db: invokestatic x/ocd1b2d918dd.Μ (FD)F
      // 0de: invokestatic org/lwjgl/opengl/GL11.glLineWidth (F)V
      // 0e1: aload 1
      // 0e2: getfield net/minecraft/entity/player/EntityPlayer.prevRenderYawOffset F
      // 0e5: aload 1
      // 0e6: getfield net/minecraft/entity/player/EntityPlayer.renderYawOffset F
      // 0e9: fload 4
      // 0eb: invokestatic x/ocd1b2d918dd.վ (FFF)F
      // 0ee: fneg
      // 0ef: fconst_0
      // 0f0: fconst_1
      // 0f1: fconst_0
      // 0f2: invokestatic org/lwjgl/opengl/GL11.glRotatef (FFFF)V
      // 0f5: aload 1
      // 0f6: invokevirtual net/minecraft/entity/player/EntityPlayer.isSneaking ()Z
      // 0f9: istore 13
      // 0fb: iload 13
      // 0fd: ifeq 107
      // 100: ldc2_w 0.6
      // 103: goto 10a
      // 106: athrow
      // 107: ldc2_w 0.75
      // 10a: dstore 14
      // 10c: dconst_0
      // 10d: dload 14
      // 10f: iload 13
      // 111: ifeq 11b
      // 114: ldc2_w -0.2
      // 117: goto 11c
      // 11a: athrow
      // 11b: dconst_0
      // 11c: invokestatic org/lwjgl/opengl/GL11.glTranslated (DDD)V
      // 11f: aload 0
      // 120: ldc2_w -0.15
      // 123: dconst_0
      // 124: dconst_0
      // 125: ldc2_w 0.15
      // 128: dconst_0
      // 129: dconst_0
      // 12a: invokevirtual x/ocd1b2d918dd.Ս (DDDDDD)V
      // 12d: aload 0
      // 12e: aload 2
      // 12f: getfield net/minecraft/client/model/ModelBiped.bipedRightLeg Lnet/minecraft/client/model/ModelRenderer;
      // 132: ldc2_w -0.15
      // 135: dconst_0
      // 136: dconst_0
      // 137: dload 14
      // 139: invokevirtual x/ocd1b2d918dd.Т (Lnet/minecraft/client/model/ModelRenderer;DDDD)V
      // 13c: aload 0
      // 13d: iload 11
      // 13f: ifne 1ac
      // 142: aload 2
      // 143: getfield net/minecraft/client/model/ModelBiped.bipedLeftLeg Lnet/minecraft/client/model/ModelRenderer;
      // 146: ldc2_w 0.15
      // 149: dconst_0
      // 14a: dconst_0
      // 14b: dload 14
      // 14d: invokevirtual x/ocd1b2d918dd.Т (Lnet/minecraft/client/model/ModelRenderer;DDDD)V
      // 150: invokestatic org/lwjgl/opengl/GL11.glPushMatrix ()V
      // 153: iload 13
      // 155: ifeq 169
      // 158: goto 15c
      // 15b: athrow
      // 15c: ldc_w 20.0
      // 15f: fconst_1
      // 160: fconst_0
      // 161: fconst_0
      // 162: invokestatic org/lwjgl/opengl/GL11.glRotatef (FFFF)V
      // 165: goto 169
      // 168: athrow
      // 169: aload 0
      // 16a: dconst_0
      // 16b: dconst_0
      // 16c: dconst_0
      // 16d: dconst_0
      // 16e: ldc2_w 0.65
      // 171: dconst_0
      // 172: invokevirtual x/ocd1b2d918dd.Ս (DDDDDD)V
      // 175: dconst_0
      // 176: ldc2_w 0.65
      // 179: dconst_0
      // 17a: invokestatic org/lwjgl/opengl/GL11.glTranslated (DDD)V
      // 17d: aload 0
      // 17e: ldc2_w -0.35
      // 181: dconst_0
      // 182: dconst_0
      // 183: ldc2_w 0.35
      // 186: dconst_0
      // 187: dconst_0
      // 188: invokevirtual x/ocd1b2d918dd.Ս (DDDDDD)V
      // 18b: aload 0
      // 18c: aload 2
      // 18d: getfield net/minecraft/client/model/ModelBiped.bipedRightArm Lnet/minecraft/client/model/ModelRenderer;
      // 190: ldc2_w -0.35
      // 193: dconst_0
      // 194: dconst_0
      // 195: ldc2_w 0.6
      // 198: invokevirtual x/ocd1b2d918dd.Т (Lnet/minecraft/client/model/ModelRenderer;DDDD)V
      // 19b: aload 0
      // 19c: aload 2
      // 19d: getfield net/minecraft/client/model/ModelBiped.bipedLeftArm Lnet/minecraft/client/model/ModelRenderer;
      // 1a0: ldc2_w 0.35
      // 1a3: dconst_0
      // 1a4: dconst_0
      // 1a5: ldc2_w 0.6
      // 1a8: invokevirtual x/ocd1b2d918dd.Т (Lnet/minecraft/client/model/ModelRenderer;DDDD)V
      // 1ab: aload 0
      // 1ac: aload 2
      // 1ad: getfield net/minecraft/client/model/ModelBiped.bipedHead Lnet/minecraft/client/model/ModelRenderer;
      // 1b0: invokevirtual x/ocd1b2d918dd.ϊ (Lnet/minecraft/client/model/ModelRenderer;)V
      // 1b3: invokestatic org/lwjgl/opengl/GL11.glPopMatrix ()V
      // 1b6: invokestatic org/lwjgl/opengl/GL11.glPopAttrib ()V
      // 1b9: invokestatic org/lwjgl/opengl/GL11.glPopMatrix ()V
      // 1bc: fconst_1
      // 1bd: fconst_1
      // 1be: fconst_1
      // 1bf: fconst_1
      // 1c0: invokestatic net/minecraft/client/renderer/GlStateManager.color (FFFF)V
      // 1c3: goto 1d8
      // 1c6: astore 16
      // 1c8: invokestatic org/lwjgl/opengl/GL11.glPopAttrib ()V
      // 1cb: invokestatic org/lwjgl/opengl/GL11.glPopMatrix ()V
      // 1ce: fconst_1
      // 1cf: fconst_1
      // 1d0: fconst_1
      // 1d1: fconst_1
      // 1d2: invokestatic net/minecraft/client/renderer/GlStateManager.color (FFFF)V
      // 1d5: aload 16
      // 1d7: athrow
      // 1d8: return
   }

   private void Т(ModelRenderer var1, double var2, double var4, double var6, double var8) {
      GL11.glPushMatrix();
      GL11.glTranslated(var2, var4, var6);
      this.Գ(var1);
      this.Ս(0.0, 0.0, 0.0, 0.0, -var8, 0.0);
      GL11.glPopMatrix();
   }

   private void ϊ(ModelRenderer var1) {
      GL11.glPushMatrix();
      this.Գ(var1);
      this.Ս(0.0, 0.0, 0.0, 0.0, 0.4, 0.0);
      this.Ս(0.0, 0.4, 0.0, 0.0, 0.4, 0.25);
      GL11.glPopMatrix();
   }

   private void Գ(ModelRenderer var1) {
      GL11.glRotatef(var1.rotateAngleX * (float) (180.0 / Math.PI), 1.0F, 0.0F, 0.0F);
      GL11.glRotatef(-var1.rotateAngleY * (float) (180.0 / Math.PI), 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(-var1.rotateAngleZ * (float) (180.0 / Math.PI), 0.0F, 0.0F, 1.0F);
   }

   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   static float վ(float var0, float var1, float var2) {
      float var4 = (var1 - var0) % 360.0F;
      boolean var3 = oce6044968f8.ђ;

      float var10000;
      label45: {
         label52: {
            try {
               var10000 = var4;
               if (var3) {
                  break label45;
               }

               if (!(var4 < -180.0F)) {
                  break label52;
               }
            } catch (ocbde1165e4e var8) {
               throw var8;
            }

            var4 += 360.0F;

            try {
               if (!var3) {
                  return var0 + var2 * var4;
               }
            } catch (ocbde1165e4e var7) {
               throw var7;
            }
         }

         try {
            var10000 = var4;
         } catch (ocbde1165e4e var5) {
            throw var5;
         }
      }

      try {
         if (var3) {
            return var10000;
         }

         if (!(var10000 >= 180.0F)) {
            return var0 + var2 * var4;
         }
      } catch (ocbde1165e4e var6) {
         throw var6;
      }

      var4 -= 360.0F;
      return var0 + var2 * var4;
   }

   static float Μ(float var0, double var1) {
      float var3 = Math.max(0.0F, Math.min(var0, 100.0F));
      float var4 = Math.max(1.0F, 4.0F * (1.0F - var3 / 100.0F));
      return var4 * (float)Math.max(0.25, Math.min(var1, 2.0));
   }

   private void Ս(double var1, double var3, double var5, double var7, double var9, double var11) {
      GL11.glBegin(1);
      GL11.glVertex3d(var1, var3, var5);
      GL11.glVertex3d(var7, var9, var11);
      oc170ea29aae.ŷ();
   }

   private void Я(double var1, double var3, double var5, double var7, int var9) {
      ocbd4917c4b1.ĉ(var1, var3, var5, var7, var9);
   }

   private void k(double var1, double var3, double var5, double var7, double var9, int var11, int var12) {
      this.Я(var1, var3, var5, var7, var11);
      this.Я(var1, var3, var1 + var9, var7, var12);
      this.Я(var5 - var9, var3, var5, var7, var12);
      this.Я(var1, var3, var5, var3 + var9, var12);
      this.Я(var1, var7 - var9, var5, var7, var12);
   }

   private int ò(float param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 2
      // 04: fload 1
      // 05: iload 2
      // 06: ifne 1c
      // 09: ldc_w 0.5
      // 0c: fcmpg
      // 0d: ifge 19
      // 10: goto 14
      // 13: athrow
      // 14: fconst_1
      // 15: goto 1e
      // 18: athrow
      // 19: fconst_1
      // 1a: fload 1
      // 1b: fsub
      // 1c: fconst_2
      // 1d: fmul
      // 1e: fstore 3
      // 1f: fload 1
      // 20: iload 2
      // 21: ifne 35
      // 24: ldc_w 0.5
      // 27: fcmpl
      // 28: ifle 34
      // 2b: goto 2f
      // 2e: athrow
      // 2f: fconst_1
      // 30: goto 37
      // 33: athrow
      // 34: fload 1
      // 35: fconst_2
      // 36: fmul
      // 37: fstore 4
      // 39: new java/awt/Color
      // 3c: dup
      // 3d: fload 3
      // 3e: fload 4
      // 40: fconst_0
      // 41: invokespecial java/awt/Color.<init> (FFF)V
      // 44: invokevirtual java/awt/Color.getRGB ()I
      // 47: ireturn
   }

   private void Ý(oc55bd31ebd1 param1, double param2, double param4, double param6, double param8) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: aload 1
      // 004: getfield x/oc55bd31ebd1.ƕ I
      // 007: istore 11
      // 009: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 00c: invokevirtual net/minecraft/client/Minecraft.getRenderItem ()Lnet/minecraft/client/renderer/entity/RenderItem;
      // 00f: astore 12
      // 011: istore 10
      // 013: aload 0
      // 014: getfield x/ocd1b2d918dd.ϯ Lx/oca9cc61aada;
      // 017: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 01a: d2i
      // 01b: istore 13
      // 01d: dload 6
      // 01f: dload 2
      // 020: dsub
      // 021: ldc2_w 4.0
      // 024: ddiv
      // 025: dstore 14
      // 027: dload 6
      // 029: dload 2
      // 02a: dsub
      // 02b: iload 13
      // 02d: iload 10
      // 02f: ifne 04b
      // 032: ldc_w 521624421
      // 035: ldc_w 521624423
      // 038: ixor
      // 039: if_icmpne 04e
      // 03c: goto 040
      // 03f: athrow
      // 040: ldc_w 521624419
      // 043: ldc_w 521624423
      // 046: ixor
      // 047: goto 04b
      // 04a: athrow
      // 04b: goto 055
      // 04e: ldc_w 521624420
      // 051: ldc_w 521624423
      // 054: ixor
      // 055: i2d
      // 056: ddiv
      // 057: dstore 16
      // 059: iload 13
      // 05b: ldc_w 521624421
      // 05e: ldc_w 521624423
      // 061: ixor
      // 062: if_icmpne 06b
      // 065: dload 14
      // 067: goto 074
      // 06a: athrow
      // 06b: dload 8
      // 06d: dload 4
      // 06f: dsub
      // 070: ldc2_w 4.0
      // 073: ddiv
      // 074: dstore 18
      // 076: iload 13
      // 078: iload 10
      // 07a: ifne 0fa
      // 07d: ifne 0f4
      // 080: goto 084
      // 083: athrow
      // 084: aload 0
      // 085: dload 2
      // 086: ldc2_w 0.5
      // 089: dsub
      // 08a: dload 4
      // 08c: ldc2_w 0.5
      // 08f: dsub
      // 090: dload 6
      // 092: ldc2_w 0.5
      // 095: dadd
      // 096: dload 8
      // 098: ldc2_w 0.5
      // 09b: dadd
      // 09c: dconst_1
      // 09d: bipush 0
      // 09e: ldc_w -1994957977
      // 0a1: ldc_w 521624423
      // 0a4: ixor
      // 0a5: invokevirtual x/ocd1b2d918dd.k (DDDDDII)V
      // 0a8: iload 10
      // 0aa: aload 0
      // 0ab: dload 2
      // 0ac: ldc2_w 0.5
      // 0af: dadd
      // 0b0: dload 4
      // 0b2: ldc2_w 0.5
      // 0b5: dadd
      // 0b6: dload 6
      // 0b8: ldc2_w 0.5
      // 0bb: dsub
      // 0bc: dload 8
      // 0be: ldc2_w 0.5
      // 0c1: dsub
      // 0c2: dconst_1
      // 0c3: bipush 0
      // 0c4: iload 11
      // 0c6: invokevirtual x/ocd1b2d918dd.k (DDDDDII)V
      // 0c9: aload 0
      // 0ca: dload 2
      // 0cb: ldc2_w 1.5
      // 0ce: dadd
      // 0cf: dload 4
      // 0d1: ldc2_w 1.5
      // 0d4: dadd
      // 0d5: dload 6
      // 0d7: ldc2_w 1.5
      // 0da: dsub
      // 0db: dload 8
      // 0dd: ldc2_w 1.5
      // 0e0: dsub
      // 0e1: dconst_1
      // 0e2: bipush 0
      // 0e3: ldc_w -1994957977
      // 0e6: ldc_w 521624423
      // 0e9: ixor
      // 0ea: invokevirtual x/ocd1b2d918dd.k (DDDDDII)V
      // 0ed: ifeq 80b
      // 0f0: goto 0f4
      // 0f3: athrow
      // 0f4: iload 13
      // 0f6: goto 0fa
      // 0f9: athrow
      // 0fa: ldc_w 521624420
      // 0fd: ldc_w 521624423
      // 100: ixor
      // 101: if_icmpne 3c7
      // 104: aload 0
      // 105: dload 2
      // 106: ldc2_w 0.5
      // 109: dadd
      // 10a: dload 4
      // 10c: ldc2_w 0.5
      // 10f: dadd
      // 110: dload 2
      // 111: ldc2_w 1.5
      // 114: dadd
      // 115: dload 8
      // 117: ldc2_w 0.5
      // 11a: dsub
      // 11b: iload 11
      // 11d: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 120: iload 10
      // 122: aload 0
      // 123: dload 2
      // 124: ldc2_w 0.5
      // 127: dsub
      // 128: dload 4
      // 12a: ldc2_w 0.5
      // 12d: dadd
      // 12e: dload 2
      // 12f: ldc2_w 0.5
      // 132: dadd
      // 133: dload 8
      // 135: ldc2_w 0.5
      // 138: dsub
      // 139: ldc_w -1994957977
      // 13c: ldc_w 521624423
      // 13f: ixor
      // 140: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 143: aload 0
      // 144: dload 2
      // 145: ldc2_w 1.5
      // 148: dadd
      // 149: dload 4
      // 14b: ldc2_w 2.5
      // 14e: dadd
      // 14f: dload 2
      // 150: ldc2_w 2.5
      // 153: dadd
      // 154: dload 8
      // 156: ldc2_w 2.5
      // 159: dsub
      // 15a: ldc_w -1994957977
      // 15d: ldc_w 521624423
      // 160: ixor
      // 161: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 164: aload 0
      // 165: dload 2
      // 166: dconst_1
      // 167: dadd
      // 168: dload 4
      // 16a: ldc2_w 0.5
      // 16d: dadd
      // 16e: dload 2
      // 16f: dload 14
      // 171: dadd
      // 172: dload 4
      // 174: ldc2_w 1.5
      // 177: dadd
      // 178: iload 11
      // 17a: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 17d: aload 0
      // 17e: dload 2
      // 17f: ldc2_w 0.5
      // 182: dsub
      // 183: dload 4
      // 185: ldc2_w 0.5
      // 188: dsub
      // 189: dload 2
      // 18a: dload 14
      // 18c: dadd
      // 18d: dload 4
      // 18f: ldc2_w 0.5
      // 192: dadd
      // 193: ldc_w -1994957977
      // 196: ldc_w 521624423
      // 199: ixor
      // 19a: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 19d: aload 0
      // 19e: dload 2
      // 19f: ldc2_w 1.5
      // 1a2: dadd
      // 1a3: dload 4
      // 1a5: ldc2_w 1.5
      // 1a8: dadd
      // 1a9: dload 2
      // 1aa: dload 14
      // 1ac: dadd
      // 1ad: dload 4
      // 1af: ldc2_w 2.5
      // 1b2: dadd
      // 1b3: ldc_w -1994957977
      // 1b6: ldc_w 521624423
      // 1b9: ixor
      // 1ba: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 1bd: aload 0
      // 1be: dload 2
      // 1bf: dload 14
      // 1c1: dadd
      // 1c2: dload 4
      // 1c4: ldc2_w 0.5
      // 1c7: dsub
      // 1c8: dload 2
      // 1c9: dload 14
      // 1cb: dadd
      // 1cc: dconst_1
      // 1cd: dadd
      // 1ce: dload 4
      // 1d0: ldc2_w 2.5
      // 1d3: dadd
      // 1d4: ldc_w -1994957977
      // 1d7: ldc_w 521624423
      // 1da: ixor
      // 1db: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 1de: aload 0
      // 1df: dload 2
      // 1e0: dconst_1
      // 1e1: dadd
      // 1e2: dload 8
      // 1e4: ldc2_w 0.5
      // 1e7: dsub
      // 1e8: dload 2
      // 1e9: dload 14
      // 1eb: dadd
      // 1ec: dload 8
      // 1ee: ldc2_w 1.5
      // 1f1: dsub
      // 1f2: iload 11
      // 1f4: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 1f7: aload 0
      // 1f8: dload 2
      // 1f9: ldc2_w 0.5
      // 1fc: dsub
      // 1fd: dload 8
      // 1ff: ldc2_w 0.5
      // 202: dadd
      // 203: dload 2
      // 204: dload 14
      // 206: dadd
      // 207: dload 8
      // 209: ldc2_w 0.5
      // 20c: dsub
      // 20d: ldc_w -1994957977
      // 210: ldc_w 521624423
      // 213: ixor
      // 214: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 217: aload 0
      // 218: dload 2
      // 219: ldc2_w 1.5
      // 21c: dadd
      // 21d: dload 8
      // 21f: ldc2_w 1.5
      // 222: dsub
      // 223: dload 2
      // 224: dload 14
      // 226: dadd
      // 227: dload 8
      // 229: ldc2_w 2.5
      // 22c: dsub
      // 22d: ldc_w -1994957977
      // 230: ldc_w 521624423
      // 233: ixor
      // 234: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 237: aload 0
      // 238: dload 2
      // 239: dload 14
      // 23b: dadd
      // 23c: dload 8
      // 23e: ldc2_w 0.5
      // 241: dadd
      // 242: dload 2
      // 243: dload 14
      // 245: dadd
      // 246: dconst_1
      // 247: dadd
      // 248: dload 8
      // 24a: ldc2_w 2.5
      // 24d: dsub
      // 24e: ldc_w -1994957977
      // 251: ldc_w 521624423
      // 254: ixor
      // 255: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 258: aload 0
      // 259: dload 6
      // 25b: ldc2_w 0.5
      // 25e: dsub
      // 25f: dload 4
      // 261: ldc2_w 0.5
      // 264: dadd
      // 265: dload 6
      // 267: ldc2_w 1.5
      // 26a: dsub
      // 26b: dload 8
      // 26d: ldc2_w 0.5
      // 270: dsub
      // 271: iload 11
      // 273: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 276: aload 0
      // 277: dload 6
      // 279: ldc2_w 0.5
      // 27c: dadd
      // 27d: dload 4
      // 27f: ldc2_w 0.5
      // 282: dadd
      // 283: dload 6
      // 285: ldc2_w 0.5
      // 288: dsub
      // 289: dload 8
      // 28b: ldc2_w 0.5
      // 28e: dsub
      // 28f: ldc_w -1994957977
      // 292: ldc_w 521624423
      // 295: ixor
      // 296: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 299: aload 0
      // 29a: dload 6
      // 29c: ldc2_w 1.5
      // 29f: dsub
      // 2a0: dload 4
      // 2a2: ldc2_w 2.5
      // 2a5: dadd
      // 2a6: dload 6
      // 2a8: ldc2_w 2.5
      // 2ab: dsub
      // 2ac: dload 8
      // 2ae: ldc2_w 2.5
      // 2b1: dsub
      // 2b2: ldc_w -1994957977
      // 2b5: ldc_w 521624423
      // 2b8: ixor
      // 2b9: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 2bc: aload 0
      // 2bd: dload 6
      // 2bf: dconst_1
      // 2c0: dsub
      // 2c1: dload 4
      // 2c3: ldc2_w 0.5
      // 2c6: dadd
      // 2c7: dload 6
      // 2c9: dload 14
      // 2cb: dsub
      // 2cc: dload 4
      // 2ce: ldc2_w 1.5
      // 2d1: dadd
      // 2d2: iload 11
      // 2d4: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 2d7: aload 0
      // 2d8: dload 6
      // 2da: ldc2_w 0.5
      // 2dd: dadd
      // 2de: dload 4
      // 2e0: ldc2_w 0.5
      // 2e3: dsub
      // 2e4: dload 6
      // 2e6: dload 14
      // 2e8: dsub
      // 2e9: dload 4
      // 2eb: ldc2_w 0.5
      // 2ee: dadd
      // 2ef: ldc_w -1994957977
      // 2f2: ldc_w 521624423
      // 2f5: ixor
      // 2f6: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 2f9: aload 0
      // 2fa: dload 6
      // 2fc: ldc2_w 1.5
      // 2ff: dsub
      // 300: dload 4
      // 302: ldc2_w 1.5
      // 305: dadd
      // 306: dload 6
      // 308: dload 14
      // 30a: dsub
      // 30b: dload 4
      // 30d: ldc2_w 2.5
      // 310: dadd
      // 311: ldc_w -1994957977
      // 314: ldc_w 521624423
      // 317: ixor
      // 318: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 31b: aload 0
      // 31c: dload 6
      // 31e: dload 14
      // 320: dsub
      // 321: dload 4
      // 323: ldc2_w 0.5
      // 326: dsub
      // 327: dload 6
      // 329: dload 14
      // 32b: dsub
      // 32c: dconst_1
      // 32d: dsub
      // 32e: dload 4
      // 330: ldc2_w 2.5
      // 333: dadd
      // 334: ldc_w -1994957977
      // 337: ldc_w 521624423
      // 33a: ixor
      // 33b: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 33e: aload 0
      // 33f: dload 6
      // 341: dconst_1
      // 342: dsub
      // 343: dload 8
      // 345: ldc2_w 0.5
      // 348: dsub
      // 349: dload 6
      // 34b: dload 14
      // 34d: dsub
      // 34e: dload 8
      // 350: ldc2_w 1.5
      // 353: dsub
      // 354: iload 11
      // 356: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 359: aload 0
      // 35a: dload 6
      // 35c: ldc2_w 0.5
      // 35f: dadd
      // 360: dload 8
      // 362: ldc2_w 0.5
      // 365: dadd
      // 366: dload 6
      // 368: dload 14
      // 36a: dsub
      // 36b: dload 8
      // 36d: ldc2_w 0.5
      // 370: dsub
      // 371: ldc_w -1994957977
      // 374: ldc_w 521624423
      // 377: ixor
      // 378: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 37b: aload 0
      // 37c: dload 6
      // 37e: ldc2_w 1.5
      // 381: dsub
      // 382: dload 8
      // 384: ldc2_w 1.5
      // 387: dsub
      // 388: dload 6
      // 38a: dload 14
      // 38c: dsub
      // 38d: dload 8
      // 38f: ldc2_w 2.5
      // 392: dsub
      // 393: ldc_w -1994957977
      // 396: ldc_w 521624423
      // 399: ixor
      // 39a: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 39d: aload 0
      // 39e: dload 6
      // 3a0: dload 14
      // 3a2: dsub
      // 3a3: dload 8
      // 3a5: ldc2_w 0.5
      // 3a8: dadd
      // 3a9: dload 6
      // 3ab: dload 14
      // 3ad: dsub
      // 3ae: dconst_1
      // 3af: dsub
      // 3b0: dload 8
      // 3b2: ldc2_w 2.5
      // 3b5: dsub
      // 3b6: ldc_w -1994957977
      // 3b9: ldc_w 521624423
      // 3bc: ixor
      // 3bd: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 3c0: ifeq 80b
      // 3c3: goto 3c7
      // 3c6: athrow
      // 3c7: aload 0
      // 3c8: dload 2
      // 3c9: ldc2_w 0.5
      // 3cc: dadd
      // 3cd: dload 4
      // 3cf: ldc2_w 0.5
      // 3d2: dadd
      // 3d3: dload 2
      // 3d4: ldc2_w 1.5
      // 3d7: dadd
      // 3d8: dload 4
      // 3da: dload 18
      // 3dc: dadd
      // 3dd: ldc2_w 0.5
      // 3e0: dadd
      // 3e1: iload 11
      // 3e3: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 3e6: aload 0
      // 3e7: dload 2
      // 3e8: ldc2_w 0.5
      // 3eb: dadd
      // 3ec: dload 8
      // 3ee: ldc2_w 0.5
      // 3f1: dsub
      // 3f2: dload 2
      // 3f3: ldc2_w 1.5
      // 3f6: dadd
      // 3f7: dload 8
      // 3f9: dload 18
      // 3fb: dsub
      // 3fc: ldc2_w 0.5
      // 3ff: dsub
      // 400: iload 11
      // 402: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 405: aload 0
      // 406: dload 2
      // 407: ldc2_w 0.5
      // 40a: dsub
      // 40b: dload 4
      // 40d: ldc2_w 0.5
      // 410: dadd
      // 411: dload 2
      // 412: ldc2_w 0.5
      // 415: dadd
      // 416: dload 4
      // 418: dload 18
      // 41a: dadd
      // 41b: ldc2_w 0.5
      // 41e: dadd
      // 41f: ldc_w -1994957977
      // 422: ldc_w 521624423
      // 425: ixor
      // 426: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 429: aload 0
      // 42a: dload 2
      // 42b: ldc2_w 1.5
      // 42e: dadd
      // 42f: dload 4
      // 431: ldc2_w 2.5
      // 434: dadd
      // 435: dload 2
      // 436: ldc2_w 2.5
      // 439: dadd
      // 43a: dload 4
      // 43c: dload 18
      // 43e: dadd
      // 43f: ldc2_w 0.5
      // 442: dadd
      // 443: ldc_w -1994957977
      // 446: ldc_w 521624423
      // 449: ixor
      // 44a: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 44d: aload 0
      // 44e: dload 2
      // 44f: ldc2_w 0.5
      // 452: dsub
      // 453: dload 4
      // 455: dload 18
      // 457: dadd
      // 458: ldc2_w 0.5
      // 45b: dadd
      // 45c: dload 2
      // 45d: ldc2_w 2.5
      // 460: dadd
      // 461: dload 4
      // 463: dload 18
      // 465: dadd
      // 466: ldc2_w 1.5
      // 469: dadd
      // 46a: ldc_w -1994957977
      // 46d: ldc_w 521624423
      // 470: ixor
      // 471: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 474: aload 0
      // 475: dload 2
      // 476: ldc2_w 0.5
      // 479: dsub
      // 47a: dload 8
      // 47c: ldc2_w 0.5
      // 47f: dsub
      // 480: dload 2
      // 481: ldc2_w 0.5
      // 484: dadd
      // 485: dload 8
      // 487: dload 18
      // 489: dsub
      // 48a: ldc2_w 0.5
      // 48d: dsub
      // 48e: ldc_w -1994957977
      // 491: ldc_w 521624423
      // 494: ixor
      // 495: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 498: aload 0
      // 499: dload 2
      // 49a: ldc2_w 1.5
      // 49d: dadd
      // 49e: dload 8
      // 4a0: ldc2_w 2.5
      // 4a3: dsub
      // 4a4: dload 2
      // 4a5: ldc2_w 2.5
      // 4a8: dadd
      // 4a9: dload 8
      // 4ab: dload 18
      // 4ad: dsub
      // 4ae: ldc2_w 0.5
      // 4b1: dsub
      // 4b2: ldc_w -1994957977
      // 4b5: ldc_w 521624423
      // 4b8: ixor
      // 4b9: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 4bc: aload 0
      // 4bd: dload 2
      // 4be: ldc2_w 0.5
      // 4c1: dsub
      // 4c2: dload 8
      // 4c4: dload 18
      // 4c6: dsub
      // 4c7: ldc2_w 0.5
      // 4ca: dsub
      // 4cb: dload 2
      // 4cc: ldc2_w 2.5
      // 4cf: dadd
      // 4d0: dload 8
      // 4d2: dload 18
      // 4d4: dsub
      // 4d5: ldc2_w 1.5
      // 4d8: dsub
      // 4d9: ldc_w -1994957977
      // 4dc: ldc_w 521624423
      // 4df: ixor
      // 4e0: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 4e3: aload 0
      // 4e4: dload 2
      // 4e5: dconst_1
      // 4e6: dadd
      // 4e7: dload 4
      // 4e9: ldc2_w 0.5
      // 4ec: dadd
      // 4ed: dload 2
      // 4ee: dload 16
      // 4f0: dadd
      // 4f1: dload 4
      // 4f3: ldc2_w 1.5
      // 4f6: dadd
      // 4f7: iload 11
      // 4f9: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 4fc: aload 0
      // 4fd: dload 2
      // 4fe: ldc2_w 0.5
      // 501: dsub
      // 502: dload 4
      // 504: ldc2_w 0.5
      // 507: dsub
      // 508: dload 2
      // 509: dload 16
      // 50b: dadd
      // 50c: dload 4
      // 50e: ldc2_w 0.5
      // 511: dadd
      // 512: ldc_w -1994957977
      // 515: ldc_w 521624423
      // 518: ixor
      // 519: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 51c: aload 0
      // 51d: dload 2
      // 51e: ldc2_w 1.5
      // 521: dadd
      // 522: dload 4
      // 524: ldc2_w 1.5
      // 527: dadd
      // 528: dload 2
      // 529: dload 16
      // 52b: dadd
      // 52c: dload 4
      // 52e: ldc2_w 2.5
      // 531: dadd
      // 532: ldc_w -1994957977
      // 535: ldc_w 521624423
      // 538: ixor
      // 539: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 53c: aload 0
      // 53d: dload 2
      // 53e: dload 16
      // 540: dadd
      // 541: dload 4
      // 543: ldc2_w 0.5
      // 546: dsub
      // 547: dload 2
      // 548: dload 16
      // 54a: dadd
      // 54b: dconst_1
      // 54c: dadd
      // 54d: dload 4
      // 54f: ldc2_w 2.5
      // 552: dadd
      // 553: ldc_w -1994957977
      // 556: ldc_w 521624423
      // 559: ixor
      // 55a: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 55d: aload 0
      // 55e: dload 2
      // 55f: dconst_1
      // 560: dadd
      // 561: dload 8
      // 563: ldc2_w 0.5
      // 566: dsub
      // 567: dload 2
      // 568: dload 16
      // 56a: dadd
      // 56b: dload 8
      // 56d: ldc2_w 1.5
      // 570: dsub
      // 571: iload 11
      // 573: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 576: aload 0
      // 577: dload 2
      // 578: ldc2_w 0.5
      // 57b: dsub
      // 57c: dload 8
      // 57e: ldc2_w 0.5
      // 581: dadd
      // 582: dload 2
      // 583: dload 16
      // 585: dadd
      // 586: dload 8
      // 588: ldc2_w 0.5
      // 58b: dsub
      // 58c: ldc_w -1994957977
      // 58f: ldc_w 521624423
      // 592: ixor
      // 593: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 596: aload 0
      // 597: dload 2
      // 598: ldc2_w 1.5
      // 59b: dadd
      // 59c: dload 8
      // 59e: ldc2_w 1.5
      // 5a1: dsub
      // 5a2: dload 2
      // 5a3: dload 16
      // 5a5: dadd
      // 5a6: dload 8
      // 5a8: ldc2_w 2.5
      // 5ab: dsub
      // 5ac: ldc_w -1994957977
      // 5af: ldc_w 521624423
      // 5b2: ixor
      // 5b3: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 5b6: aload 0
      // 5b7: dload 2
      // 5b8: dload 16
      // 5ba: dadd
      // 5bb: dload 8
      // 5bd: ldc2_w 0.5
      // 5c0: dadd
      // 5c1: dload 2
      // 5c2: dload 16
      // 5c4: dadd
      // 5c5: dconst_1
      // 5c6: dadd
      // 5c7: dload 8
      // 5c9: ldc2_w 2.5
      // 5cc: dsub
      // 5cd: ldc_w -1994957977
      // 5d0: ldc_w 521624423
      // 5d3: ixor
      // 5d4: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 5d7: aload 0
      // 5d8: dload 6
      // 5da: ldc2_w 0.5
      // 5dd: dsub
      // 5de: dload 4
      // 5e0: ldc2_w 0.5
      // 5e3: dadd
      // 5e4: dload 6
      // 5e6: ldc2_w 1.5
      // 5e9: dsub
      // 5ea: dload 4
      // 5ec: dload 18
      // 5ee: dadd
      // 5ef: ldc2_w 0.5
      // 5f2: dadd
      // 5f3: iload 11
      // 5f5: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 5f8: aload 0
      // 5f9: dload 6
      // 5fb: ldc2_w 0.5
      // 5fe: dsub
      // 5ff: dload 8
      // 601: ldc2_w 0.5
      // 604: dsub
      // 605: dload 6
      // 607: ldc2_w 1.5
      // 60a: dsub
      // 60b: dload 8
      // 60d: dload 18
      // 60f: dsub
      // 610: ldc2_w 0.5
      // 613: dsub
      // 614: iload 11
      // 616: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 619: aload 0
      // 61a: dload 6
      // 61c: ldc2_w 0.5
      // 61f: dadd
      // 620: dload 4
      // 622: ldc2_w 0.5
      // 625: dadd
      // 626: dload 6
      // 628: ldc2_w 0.5
      // 62b: dsub
      // 62c: dload 4
      // 62e: dload 18
      // 630: dadd
      // 631: ldc2_w 0.5
      // 634: dadd
      // 635: ldc_w -1994957977
      // 638: ldc_w 521624423
      // 63b: ixor
      // 63c: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 63f: aload 0
      // 640: dload 6
      // 642: ldc2_w 1.5
      // 645: dsub
      // 646: dload 4
      // 648: ldc2_w 2.5
      // 64b: dadd
      // 64c: dload 6
      // 64e: ldc2_w 2.5
      // 651: dsub
      // 652: dload 4
      // 654: dload 18
      // 656: dadd
      // 657: ldc2_w 0.5
      // 65a: dadd
      // 65b: ldc_w -1994957977
      // 65e: ldc_w 521624423
      // 661: ixor
      // 662: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 665: aload 0
      // 666: dload 6
      // 668: ldc2_w 0.5
      // 66b: dadd
      // 66c: dload 4
      // 66e: dload 18
      // 670: dadd
      // 671: ldc2_w 0.5
      // 674: dadd
      // 675: dload 6
      // 677: ldc2_w 2.5
      // 67a: dsub
      // 67b: dload 4
      // 67d: dload 18
      // 67f: dadd
      // 680: ldc2_w 1.5
      // 683: dadd
      // 684: ldc_w -1994957977
      // 687: ldc_w 521624423
      // 68a: ixor
      // 68b: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 68e: aload 0
      // 68f: dload 6
      // 691: ldc2_w 0.5
      // 694: dadd
      // 695: dload 8
      // 697: ldc2_w 0.5
      // 69a: dsub
      // 69b: dload 6
      // 69d: ldc2_w 0.5
      // 6a0: dsub
      // 6a1: dload 8
      // 6a3: dload 18
      // 6a5: dsub
      // 6a6: ldc2_w 0.5
      // 6a9: dsub
      // 6aa: ldc_w -1994957977
      // 6ad: ldc_w 521624423
      // 6b0: ixor
      // 6b1: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 6b4: aload 0
      // 6b5: dload 6
      // 6b7: ldc2_w 1.5
      // 6ba: dsub
      // 6bb: dload 8
      // 6bd: ldc2_w 2.5
      // 6c0: dsub
      // 6c1: dload 6
      // 6c3: ldc2_w 2.5
      // 6c6: dsub
      // 6c7: dload 8
      // 6c9: dload 18
      // 6cb: dsub
      // 6cc: ldc2_w 0.5
      // 6cf: dsub
      // 6d0: ldc_w -1994957977
      // 6d3: ldc_w 521624423
      // 6d6: ixor
      // 6d7: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 6da: aload 0
      // 6db: dload 6
      // 6dd: ldc2_w 0.5
      // 6e0: dadd
      // 6e1: dload 8
      // 6e3: dload 18
      // 6e5: dsub
      // 6e6: ldc2_w 0.5
      // 6e9: dsub
      // 6ea: dload 6
      // 6ec: ldc2_w 2.5
      // 6ef: dsub
      // 6f0: dload 8
      // 6f2: dload 18
      // 6f4: dsub
      // 6f5: ldc2_w 1.5
      // 6f8: dsub
      // 6f9: ldc_w -1994957977
      // 6fc: ldc_w 521624423
      // 6ff: ixor
      // 700: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 703: aload 0
      // 704: dload 6
      // 706: dconst_1
      // 707: dsub
      // 708: dload 4
      // 70a: ldc2_w 0.5
      // 70d: dadd
      // 70e: dload 6
      // 710: dload 16
      // 712: dsub
      // 713: dload 4
      // 715: ldc2_w 1.5
      // 718: dadd
      // 719: iload 11
      // 71b: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 71e: aload 0
      // 71f: dload 6
      // 721: ldc2_w 0.5
      // 724: dadd
      // 725: dload 4
      // 727: ldc2_w 0.5
      // 72a: dsub
      // 72b: dload 6
      // 72d: dload 16
      // 72f: dsub
      // 730: dload 4
      // 732: ldc2_w 0.5
      // 735: dadd
      // 736: ldc_w -1994957977
      // 739: ldc_w 521624423
      // 73c: ixor
      // 73d: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 740: aload 0
      // 741: dload 6
      // 743: ldc2_w 1.5
      // 746: dsub
      // 747: dload 4
      // 749: ldc2_w 1.5
      // 74c: dadd
      // 74d: dload 6
      // 74f: dload 16
      // 751: dsub
      // 752: dload 4
      // 754: ldc2_w 2.5
      // 757: dadd
      // 758: ldc_w -1994957977
      // 75b: ldc_w 521624423
      // 75e: ixor
      // 75f: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 762: aload 0
      // 763: dload 6
      // 765: dload 16
      // 767: dsub
      // 768: dload 4
      // 76a: ldc2_w 0.5
      // 76d: dsub
      // 76e: dload 6
      // 770: dload 16
      // 772: dsub
      // 773: dconst_1
      // 774: dsub
      // 775: dload 4
      // 777: ldc2_w 2.5
      // 77a: dadd
      // 77b: ldc_w -1994957977
      // 77e: ldc_w 521624423
      // 781: ixor
      // 782: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 785: aload 0
      // 786: dload 6
      // 788: dconst_1
      // 789: dsub
      // 78a: dload 8
      // 78c: ldc2_w 0.5
      // 78f: dsub
      // 790: dload 6
      // 792: dload 16
      // 794: dsub
      // 795: dload 8
      // 797: ldc2_w 1.5
      // 79a: dsub
      // 79b: iload 11
      // 79d: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 7a0: aload 0
      // 7a1: dload 6
      // 7a3: ldc2_w 0.5
      // 7a6: dadd
      // 7a7: dload 8
      // 7a9: ldc2_w 0.5
      // 7ac: dadd
      // 7ad: dload 6
      // 7af: dload 16
      // 7b1: dsub
      // 7b2: dload 8
      // 7b4: ldc2_w 0.5
      // 7b7: dsub
      // 7b8: ldc_w -1994957977
      // 7bb: ldc_w 521624423
      // 7be: ixor
      // 7bf: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 7c2: aload 0
      // 7c3: dload 6
      // 7c5: ldc2_w 1.5
      // 7c8: dsub
      // 7c9: dload 8
      // 7cb: ldc2_w 1.5
      // 7ce: dsub
      // 7cf: dload 6
      // 7d1: dload 16
      // 7d3: dsub
      // 7d4: dload 8
      // 7d6: ldc2_w 2.5
      // 7d9: dsub
      // 7da: ldc_w -1994957977
      // 7dd: ldc_w 521624423
      // 7e0: ixor
      // 7e1: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 7e4: aload 0
      // 7e5: dload 6
      // 7e7: dload 16
      // 7e9: dsub
      // 7ea: dload 8
      // 7ec: ldc2_w 0.5
      // 7ef: dadd
      // 7f0: dload 6
      // 7f2: dload 16
      // 7f4: dsub
      // 7f5: dconst_1
      // 7f6: dsub
      // 7f7: dload 8
      // 7f9: ldc2_w 2.5
      // 7fc: dsub
      // 7fd: ldc_w -1994957977
      // 800: ldc_w 521624423
      // 803: ixor
      // 804: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 807: goto 80b
      // 80a: athrow
      // 80b: aload 0
      // 80c: getfield x/ocd1b2d918dd.ô Lx/occ2f8dff8d8;
      // 80f: iload 10
      // 811: ifne 93b
      // 814: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 817: ifeq 92e
      // 81a: goto 81e
      // 81d: athrow
      // 81e: aload 1
      // 81f: iload 10
      // 821: ifne 837
      // 824: goto 828
      // 827: athrow
      // 828: getfield x/oc55bd31ebd1.ň Lnet/minecraft/entity/EntityLivingBase;
      // 82b: ifnull 92e
      // 82e: goto 832
      // 831: athrow
      // 832: aload 1
      // 833: goto 837
      // 836: athrow
      // 837: getfield x/oc55bd31ebd1.ň Lnet/minecraft/entity/EntityLivingBase;
      // 83a: astore 20
      // 83c: aload 20
      // 83e: invokevirtual net/minecraft/entity/EntityLivingBase.getHealth ()F
      // 841: fstore 21
      // 843: aload 20
      // 845: invokevirtual net/minecraft/entity/EntityLivingBase.getMaxHealth ()F
      // 848: fstore 22
      // 84a: aload 20
      // 84c: invokevirtual net/minecraft/entity/EntityLivingBase.getAbsorptionAmount ()F
      // 84f: fstore 23
      // 851: fload 21
      // 853: fload 22
      // 855: fload 23
      // 857: fadd
      // 858: fdiv
      // 859: fstore 24
      // 85b: fconst_1
      // 85c: fconst_0
      // 85d: fload 21
      // 85f: fload 22
      // 861: fdiv
      // 862: invokestatic java/lang/Math.max (FF)F
      // 865: invokestatic java/lang/Math.min (FF)F
      // 868: fstore 25
      // 86a: aload 0
      // 86b: fload 25
      // 86d: invokevirtual x/ocd1b2d918dd.ò (F)I
      // 870: istore 26
      // 872: dload 4
      // 874: dload 8
      // 876: ldc2_w 0.5
      // 879: dsub
      // 87a: dsub
      // 87b: dstore 27
      // 87d: dload 8
      // 87f: dload 27
      // 881: fload 24
      // 883: f2d
      // 884: dmul
      // 885: dadd
      // 886: dstore 29
      // 888: aload 0
      // 889: dload 2
      // 88a: ldc2_w 6.5
      // 88d: dsub
      // 88e: dload 4
      // 890: ldc2_w 0.5
      // 893: dsub
      // 894: dload 2
      // 895: ldc2_w 2.5
      // 898: dsub
      // 899: dload 8
      // 89b: ldc2_w 0.5
      // 89e: dadd
      // 89f: dconst_1
      // 8a0: ldc_w -1994957977
      // 8a3: ldc_w 521624423
      // 8a6: ixor
      // 8a7: ldc_w -1994957977
      // 8aa: ldc_w 521624423
      // 8ad: ixor
      // 8ae: invokevirtual x/ocd1b2d918dd.k (DDDDDII)V
      // 8b1: iload 26
      // 8b3: ldc_w 535340184
      // 8b6: ldc_w 521624423
      // 8b9: ixor
      // 8ba: iand
      // 8bb: ldc_w 1008163687
      // 8be: ldc_w 521624423
      // 8c1: ixor
      // 8c2: ior
      // 8c3: istore 31
      // 8c5: aload 0
      // 8c6: dload 2
      // 8c7: ldc2_w 5.5
      // 8ca: dsub
      // 8cb: dload 29
      // 8cd: dload 2
      // 8ce: ldc2_w 3.5
      // 8d1: dsub
      // 8d2: dload 8
      // 8d4: dload 27
      // 8d6: dadd
      // 8d7: iload 31
      // 8d9: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 8dc: aload 0
      // 8dd: iload 10
      // 8df: ifne 92f
      // 8e2: dload 2
      // 8e3: ldc2_w 5.5
      // 8e6: dsub
      // 8e7: dload 8
      // 8e9: ldc2_w 0.5
      // 8ec: dsub
      // 8ed: dload 2
      // 8ee: ldc2_w 3.5
      // 8f1: dsub
      // 8f2: dload 29
      // 8f4: iload 26
      // 8f6: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 8f9: fload 23
      // 8fb: fconst_0
      // 8fc: fcmpl
      // 8fd: ifle 92e
      // 900: goto 904
      // 903: athrow
      // 904: dload 27
      // 906: fload 23
      // 908: fload 22
      // 90a: fload 23
      // 90c: fadd
      // 90d: fdiv
      // 90e: f2d
      // 90f: dmul
      // 910: dstore 32
      // 912: aload 0
      // 913: dload 2
      // 914: ldc2_w 5.5
      // 917: dsub
      // 918: dload 29
      // 91a: dload 2
      // 91b: ldc2_w 3.5
      // 91e: dsub
      // 91f: dload 32
      // 921: dload 29
      // 923: dadd
      // 924: ldc_w -521604761
      // 927: ldc_w 521624423
      // 92a: ixor
      // 92b: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // 92e: aload 0
      // 92f: iload 10
      // 931: ifne 9b6
      // 934: getfield x/ocd1b2d918dd.ʀ Lx/occ2f8dff8d8;
      // 937: goto 93b
      // 93a: athrow
      // 93b: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 93e: ifeq 9b5
      // 941: aload 1
      // 942: getfield x/oc55bd31ebd1.ň Lnet/minecraft/entity/EntityLivingBase;
      // 945: instanceof net/minecraft/entity/player/EntityPlayer
      // 948: iload 10
      // 94a: ifne 9c5
      // 94d: goto 951
      // 950: athrow
      // 951: ifeq 9b5
      // 954: goto 958
      // 957: athrow
      // 958: aload 1
      // 959: getfield x/oc55bd31ebd1.ň Lnet/minecraft/entity/EntityLivingBase;
      // 95c: checkcast net/minecraft/entity/player/EntityPlayer
      // 95f: astore 20
      // 961: aload 20
      // 963: invokevirtual net/minecraft/entity/player/EntityPlayer.getDisplayName ()Lnet/minecraft/util/IChatComponent;
      // 966: invokeinterface net/minecraft/util/IChatComponent.getFormattedText ()Ljava/lang/String; 1
      // 96b: astore 21
      // 96d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 970: getfield net/minecraft/client/Minecraft.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // 973: aload 21
      // 975: invokevirtual net/minecraft/client/gui/FontRenderer.getStringWidth (Ljava/lang/String;)I
      // 978: i2f
      // 979: fstore 22
      // 97b: dload 2
      // 97c: dload 6
      // 97e: dload 2
      // 97f: dsub
      // 980: ldc2_w 2.0
      // 983: ddiv
      // 984: dadd
      // 985: fload 22
      // 987: f2d
      // 988: ldc2_w 2.0
      // 98b: ddiv
      // 98c: dsub
      // 98d: d2f
      // 98e: fstore 23
      // 990: dload 4
      // 992: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 995: getfield net/minecraft/client/Minecraft.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // 998: getfield net/minecraft/client/gui/FontRenderer.FONT_HEIGHT I
      // 99b: i2d
      // 99c: dsub
      // 99d: ldc2_w 2.0
      // 9a0: dsub
      // 9a1: d2f
      // 9a2: fstore 24
      // 9a4: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 9a7: getfield net/minecraft/client/Minecraft.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // 9aa: aload 21
      // 9ac: fload 23
      // 9ae: fload 24
      // 9b0: bipush -1
      // 9b1: invokevirtual net/minecraft/client/gui/FontRenderer.drawStringWithShadow (Ljava/lang/String;FFI)I
      // 9b4: pop
      // 9b5: aload 0
      // 9b6: getfield x/ocd1b2d918dd.ǟ Lx/occ2f8dff8d8;
      // 9b9: iload 10
      // 9bb: ifne ab7
      // 9be: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 9c1: goto 9c5
      // 9c4: athrow
      // 9c5: ifeq ab3
      // 9c8: aload 1
      // 9c9: getfield x/oc55bd31ebd1.ň Lnet/minecraft/entity/EntityLivingBase;
      // 9cc: instanceof net/minecraft/entity/player/EntityPlayer
      // 9cf: iload 10
      // 9d1: ifne aba
      // 9d4: goto 9d8
      // 9d7: athrow
      // 9d8: ifeq ab3
      // 9db: goto 9df
      // 9de: athrow
      // 9df: aload 1
      // 9e0: getfield x/oc55bd31ebd1.ň Lnet/minecraft/entity/EntityLivingBase;
      // 9e3: checkcast net/minecraft/entity/player/EntityPlayer
      // 9e6: astore 20
      // 9e8: dload 8
      // 9ea: dload 4
      // 9ec: dsub
      // 9ed: ldc2_w 4.0
      // 9f0: ddiv
      // 9f1: d2f
      // 9f2: fstore 21
      // 9f4: bipush 1
      // 9f5: istore 22
      // 9f7: iload 22
      // 9f9: ldc_w 521624419
      // 9fc: ldc_w 521624423
      // 9ff: ixor
      // a00: if_icmpgt ab3
      // a03: aload 20
      // a05: iload 10
      // a07: ifne aee
      // a0a: iload 22
      // a0c: invokevirtual net/minecraft/entity/player/EntityPlayer.getEquipmentInSlot (I)Lnet/minecraft/item/ItemStack;
      // a0f: astore 23
      // a11: iload 10
      // a13: ifne aae
      // a16: aload 23
      // a18: ifnull aab
      // a1b: goto a1f
      // a1e: athrow
      // a1f: dconst_1
      // a20: aload 23
      // a22: invokevirtual net/minecraft/item/ItemStack.getItemDamage ()I
      // a25: i2d
      // a26: aload 23
      // a28: invokevirtual net/minecraft/item/ItemStack.getMaxDamage ()I
      // a2b: i2d
      // a2c: ddiv
      // a2d: dsub
      // a2e: dstore 24
      // a30: dload 4
      // a32: fload 21
      // a34: ldc_w 521624419
      // a37: ldc_w 521624423
      // a3a: ixor
      // a3b: iload 22
      // a3d: isub
      // a3e: i2f
      // a3f: fmul
      // a40: f2d
      // a41: dadd
      // a42: dstore 26
      // a44: dload 4
      // a46: fload 21
      // a48: ldc_w 521624418
      // a4b: ldc_w 521624423
      // a4e: ixor
      // a4f: iload 22
      // a51: isub
      // a52: i2f
      // a53: fmul
      // a54: f2d
      // a55: dadd
      // a56: dstore 28
      // a58: aload 0
      // a59: dload 6
      // a5b: dconst_1
      // a5c: dadd
      // a5d: dload 26
      // a5f: dconst_1
      // a60: dadd
      // a61: dload 6
      // a63: ldc2_w 5.0
      // a66: dadd
      // a67: dload 28
      // a69: dconst_1
      // a6a: ldc_w -1995716652
      // a6d: ldc_w 521624423
      // a70: ixor
      // a71: ldc_w -1994957977
      // a74: ldc_w 521624423
      // a77: ixor
      // a78: invokevirtual x/ocd1b2d918dd.k (DDDDDII)V
      // a7b: dload 28
      // a7d: dload 26
      // a7f: ldc2_w 2.0
      // a82: dadd
      // a83: dsub
      // a84: dstore 30
      // a86: aload 0
      // a87: dload 6
      // a89: ldc2_w 2.0
      // a8c: dadd
      // a8d: dload 28
      // a8f: dconst_1
      // a90: dsub
      // a91: dload 6
      // a93: ldc2_w 4.0
      // a96: dadd
      // a97: dload 28
      // a99: dconst_1
      // a9a: dsub
      // a9b: dload 30
      // a9d: dload 24
      // a9f: dmul
      // aa0: dsub
      // aa1: ldc_w -530999934
      // aa4: ldc_w 521624423
      // aa7: ixor
      // aa8: invokevirtual x/ocd1b2d918dd.Я (DDDDI)V
      // aab: iinc 22 1
      // aae: iload 10
      // ab0: ifeq 9f7
      // ab3: aload 0
      // ab4: getfield x/ocd1b2d918dd.Ͷ Lx/occ2f8dff8d8;
      // ab7: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // aba: iload 10
      // abc: ifne af1
      // abf: ifne add
      // ac2: goto ac6
      // ac5: athrow
      // ac6: aload 0
      // ac7: getfield x/ocd1b2d918dd.Ӱ Lx/occ2f8dff8d8;
      // aca: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // acd: iload 10
      // acf: ifne af1
      // ad2: goto ad6
      // ad5: athrow
      // ad6: ifeq bbd
      // ad9: goto add
      // adc: athrow
      // add: aload 1
      // ade: iload 10
      // ae0: ifne af5
      // ae3: goto ae7
      // ae6: athrow
      // ae7: getfield x/oc55bd31ebd1.ň Lnet/minecraft/entity/EntityLivingBase;
      // aea: goto aee
      // aed: athrow
      // aee: instanceof net/minecraft/entity/player/EntityPlayer
      // af1: ifeq bbd
      // af4: aload 1
      // af5: getfield x/oc55bd31ebd1.ň Lnet/minecraft/entity/EntityLivingBase;
      // af8: checkcast net/minecraft/entity/player/EntityPlayer
      // afb: astore 20
      // afd: aload 20
      // aff: invokevirtual net/minecraft/entity/player/EntityPlayer.getCurrentEquippedItem ()Lnet/minecraft/item/ItemStack;
      // b02: astore 21
      // b04: aload 21
      // b06: ifnull bbd
      // b09: dload 8
      // b0b: ldc2_w 2.0
      // b0e: dadd
      // b0f: dstore 22
      // b11: aload 0
      // b12: iload 10
      // b14: ifne b78
      // b17: getfield x/ocd1b2d918dd.Ͷ Lx/occ2f8dff8d8;
      // b1a: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // b1d: ifeq b77
      // b20: goto b24
      // b23: athrow
      // b24: aload 21
      // b26: invokevirtual net/minecraft/item/ItemStack.getDisplayName ()Ljava/lang/String;
      // b29: astore 24
      // b2b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // b2e: getfield net/minecraft/client/Minecraft.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // b31: aload 24
      // b33: invokevirtual net/minecraft/client/gui/FontRenderer.getStringWidth (Ljava/lang/String;)I
      // b36: i2f
      // b37: fstore 25
      // b39: dload 2
      // b3a: dload 6
      // b3c: dload 2
      // b3d: dsub
      // b3e: ldc2_w 2.0
      // b41: ddiv
      // b42: dadd
      // b43: fload 25
      // b45: f2d
      // b46: ldc2_w 2.0
      // b49: ddiv
      // b4a: dsub
      // b4b: d2f
      // b4c: fstore 26
      // b4e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // b51: getfield net/minecraft/client/Minecraft.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // b54: aload 24
      // b56: fload 26
      // b58: dload 22
      // b5a: d2f
      // b5b: bipush -1
      // b5c: invokevirtual net/minecraft/client/gui/FontRenderer.drawStringWithShadow (Ljava/lang/String;FFI)I
      // b5f: pop
      // b60: dload 22
      // b62: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // b65: getfield net/minecraft/client/Minecraft.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // b68: getfield net/minecraft/client/gui/FontRenderer.FONT_HEIGHT I
      // b6b: ldc_w 521624421
      // b6e: ldc_w 521624423
      // b71: ixor
      // b72: iadd
      // b73: i2d
      // b74: dadd
      // b75: dstore 22
      // b77: aload 0
      // b78: getfield x/ocd1b2d918dd.Ӱ Lx/occ2f8dff8d8;
      // b7b: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // b7e: ifeq bbd
      // b81: invokestatic net/minecraft/client/renderer/GlStateManager.pushMatrix ()V
      // b84: dload 2
      // b85: dload 6
      // b87: dload 2
      // b88: dsub
      // b89: ldc2_w 2.0
      // b8c: ddiv
      // b8d: dadd
      // b8e: ldc2_w 8.0
      // b91: dsub
      // b92: dload 22
      // b94: dconst_0
      // b95: invokestatic net/minecraft/client/renderer/GlStateManager.translate (DDD)V
      // b98: invokestatic net/minecraft/client/renderer/RenderHelper.enableGUIStandardItemLighting ()V
      // b9b: aload 12
      // b9d: aload 21
      // b9f: bipush 0
      // ba0: bipush 0
      // ba1: invokevirtual net/minecraft/client/renderer/entity/RenderItem.renderItemAndEffectIntoGUI (Lnet/minecraft/item/ItemStack;II)V
      // ba4: aload 12
      // ba6: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // ba9: getfield net/minecraft/client/Minecraft.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // bac: aload 21
      // bae: bipush 0
      // baf: bipush 0
      // bb0: invokevirtual net/minecraft/client/renderer/entity/RenderItem.renderItemOverlays (Lnet/minecraft/client/gui/FontRenderer;Lnet/minecraft/item/ItemStack;II)V
      // bb3: invokestatic net/minecraft/client/renderer/RenderHelper.disableStandardItemLighting ()V
      // bb6: invokestatic net/minecraft/client/renderer/GlStateManager.popMatrix ()V
      // bb9: goto bbd
      // bbc: athrow
      // bbd: return
   }

   static {
      String[] var10000 = new String[1904642467 ^ 1904642464];
      var10000[0] = "Miau";
      var10000[1] = "Skeleton";
      var10000[1904642466 ^ 1904642464] = "Raven";
      ƙ = var10000;
      var10000 = new String[1904642470 ^ 1904642464];
      var10000[0] = "None";
      var10000[1] = "2D";
      var10000[1904642466 ^ 1904642464] = "3D";
      var10000[1904642467 ^ 1904642464] = "Outline";
      var10000[1904642468 ^ 1904642464] = "FakeCorner";
      var10000[1904642469 ^ 1904642464] = "Fake2D";
      я = var10000;
      var10000 = new String[1904642467 ^ 1904642464];
      var10000[0] = "Default";
      var10000[1] = "Teams";
      var10000[1904642466 ^ 1904642464] = "HUD";
      Ù = var10000;
      var10000 = new String[1904642467 ^ 1904642464];
      var10000[0] = "None";
      var10000[1] = "2D";
      var10000[1904642466 ^ 1904642464] = "Raven";
      Ť = var10000;
   }
}

package x;

import net.minecraft.client.gui.GuiScreen;

public class oc6a43806f12 extends oc69da1aa7f5 {
   private static final String[] ʩ = oc3ebac73392.ͺ();
   private static final String[] ѵ;
   public static oca9cc61aada j;
   public static oca9cc61aada Г;
   public static oca9cc61aada Ρ;
   public static oca9cc61aada ի;
   public static oca9cc61aada ӹ;
   public static occ2f8dff8d8 ǆ;
   public static occ2f8dff8d8 ɶ;
   public static occ2f8dff8d8 Ϗ;
   public static occ2f8dff8d8 ı;
   public static oc24a0a5bddf Ų;
   public static occ2f8dff8d8 ȍ;
   public static occ2f8dff8d8 Ҡ;
   public static occ2f8dff8d8 Ќ;
   public static oca9cc61aada ӛ;
   public static occ2f8dff8d8 ʥ;
   private boolean ȁ;
   public static boolean я;

   public oc6a43806f12() {
      super("ClickGUI", oce4cea752dd.Ŏ, 957290475 ^ 957290461);
      this.ʌ(j = new oca9cc61aada("Mode", 957290463 ^ 957290461, ѵ));
      this.ʌ(Г = new oca9cc61aada("Gui scale", "x", 1.0, 0.5, 2.0, 0.01));
      this.ʌ(Ρ = new oca9cc61aada("Font", 0, ʩ));
      this.ʌ(ի = new oca9cc61aada("Background blur", "%", 0.0, 0.0, 100.0, 1.0));
      this.ʌ(ӹ = new oca9cc61aada("Scroll speed", 20.0, 2.0, 90.0, 1.0));
      this.ʌ(ɶ = new occ2f8dff8d8("Dark background", true));
      this.ʌ(ı = new occ2f8dff8d8("Rainbow outlines", true));
      this.ʌ(ǆ = new occ2f8dff8d8("Remove player model", false));
      this.ʌ(Ϗ = new occ2f8dff8d8("Remove watermark", false));
      this.ʌ(Ų = new oc24a0a5bddf("Slinky Accent", 957290274 ^ 957290461, 957290372 ^ 957290461, 0));
      this.ʌ(ȍ = new occ2f8dff8d8("Slinky Compact", false));
      this.ʌ(Ҡ = new occ2f8dff8d8("Slinky Wide", false));
      this.ʌ(Ќ = new occ2f8dff8d8("Blur", true, new String[]{"Miau blur"}));
      this.ʌ(ӛ = new oca9cc61aada("Blur radius", "", 7.0, 1.0, 20.0, 1.0, "Miau blur radius"));
      this.ʌ(ʥ = new occ2f8dff8d8("Allow movement", true, new String[]{"Miau allow movement"}));
   }

   @Override
   public void onEnable() {
      try {
         if (oc7ab2161b9f.Ð()) {
            this.F();
         }
      } catch (ocbde1165e4e var1) {
         throw var1;
      }

      this.z$1ca1cmv0s357();
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
      // 000: getstatic x/oc74760d9133.ƞ I
      // 003: istore 1
      // 004: getstatic x/oc6a43806f12.j Lx/oca9cc61aada;
      // 007: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 00a: d2i
      // 00b: iload 1
      // 00c: ifne 017
      // 00f: ifne 01a
      // 012: goto 016
      // 015: athrow
      // 016: bipush 1
      // 017: goto 01b
      // 01a: bipush 0
      // 01b: istore 2
      // 01c: invokestatic x/oc6a43806f12.Π ()Z
      // 01f: istore 3
      // 020: invokestatic x/oc6a43806f12.ĺ ()Z
      // 023: istore 4
      // 025: getstatic x/oc6a43806f12.Г Lx/oca9cc61aada;
      // 028: bipush 1
      // 029: aload 0
      // 02a: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 02d: getstatic x/oc6a43806f12.Ρ Lx/oca9cc61aada;
      // 030: iload 2
      // 031: aload 0
      // 032: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 035: getstatic x/oc6a43806f12.ի Lx/oca9cc61aada;
      // 038: iload 2
      // 039: iload 1
      // 03a: ifne 052
      // 03d: aload 0
      // 03e: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 041: getstatic x/oc6a43806f12.ӹ Lx/oca9cc61aada;
      // 044: iload 3
      // 045: ifne 061
      // 048: goto 04c
      // 04b: athrow
      // 04c: iload 4
      // 04e: goto 052
      // 051: athrow
      // 052: iload 1
      // 053: ifne 05e
      // 056: ifne 061
      // 059: goto 05d
      // 05c: athrow
      // 05d: bipush 1
      // 05e: goto 062
      // 061: bipush 0
      // 062: aload 0
      // 063: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 066: getstatic x/oc6a43806f12.ɶ Lx/occ2f8dff8d8;
      // 069: iload 2
      // 06a: aload 0
      // 06b: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 06e: getstatic x/oc6a43806f12.ı Lx/occ2f8dff8d8;
      // 071: iload 2
      // 072: aload 0
      // 073: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 076: getstatic x/oc6a43806f12.ǆ Lx/occ2f8dff8d8;
      // 079: iload 2
      // 07a: aload 0
      // 07b: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 07e: getstatic x/oc6a43806f12.Ϗ Lx/occ2f8dff8d8;
      // 081: iload 2
      // 082: aload 0
      // 083: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 086: getstatic x/oc6a43806f12.Ų Lx/oc24a0a5bddf;
      // 089: iload 3
      // 08a: aload 0
      // 08b: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 08e: getstatic x/oc6a43806f12.ȍ Lx/occ2f8dff8d8;
      // 091: iload 3
      // 092: aload 0
      // 093: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 096: getstatic x/oc6a43806f12.Ҡ Lx/occ2f8dff8d8;
      // 099: iload 3
      // 09a: aload 0
      // 09b: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 09e: getstatic x/oc6a43806f12.Ќ Lx/occ2f8dff8d8;
      // 0a1: iload 4
      // 0a3: aload 0
      // 0a4: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0a7: getstatic x/oc6a43806f12.ӛ Lx/oca9cc61aada;
      // 0aa: iload 4
      // 0ac: iload 1
      // 0ad: ifne 0c1
      // 0b0: ifeq 0d0
      // 0b3: goto 0b7
      // 0b6: athrow
      // 0b7: getstatic x/oc6a43806f12.Ќ Lx/occ2f8dff8d8;
      // 0ba: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0bd: goto 0c1
      // 0c0: athrow
      // 0c1: iload 1
      // 0c2: ifne 0cd
      // 0c5: ifeq 0d0
      // 0c8: goto 0cc
      // 0cb: athrow
      // 0cc: bipush 1
      // 0cd: goto 0d1
      // 0d0: bipush 0
      // 0d1: aload 0
      // 0d2: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0d5: getstatic x/oc6a43806f12.ʥ Lx/occ2f8dff8d8;
      // 0d8: iload 4
      // 0da: aload 0
      // 0db: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0de: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0e1: ifnull 163
      // 0e4: aload 0
      // 0e5: getfield x/oc6a43806f12.ȁ Z
      // 0e8: ifne 163
      // 0eb: goto 0ef
      // 0ee: athrow
      // 0ef: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0f2: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 0f5: iload 1
      // 0f6: ifne 141
      // 0f9: goto 0fd
      // 0fc: athrow
      // 0fd: getstatic x/oc2cf3d80e17.V Lx/oc2c25634a7e;
      // 100: if_acmpeq 137
      // 103: goto 107
      // 106: athrow
      // 107: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 10a: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 10d: iload 1
      // 10e: ifne 141
      // 111: goto 115
      // 114: athrow
      // 115: getstatic x/oc2cf3d80e17.ӎ Lx/oc6a954e7c9f;
      // 118: if_acmpeq 137
      // 11b: goto 11f
      // 11e: athrow
      // 11f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 122: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 125: iload 1
      // 126: ifne 141
      // 129: goto 12d
      // 12c: athrow
      // 12d: getstatic x/oc2cf3d80e17.ե Lx/oc1cb76bf763;
      // 130: if_acmpne 163
      // 133: goto 137
      // 136: athrow
      // 137: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 13a: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 13d: goto 141
      // 140: athrow
      // 141: aload 0
      // 142: invokevirtual x/oc6a43806f12.ϝ ()Lnet/minecraft/client/gui/GuiScreen;
      // 145: if_acmpeq 163
      // 148: aload 0
      // 149: bipush 1
      // 14a: putfield x/oc6a43806f12.ȁ Z
      // 14d: aload 0
      // 14e: invokevirtual x/oc6a43806f12.F ()V
      // 151: aload 0
      // 152: bipush 0
      // 153: putfield x/oc6a43806f12.ȁ Z
      // 156: goto 163
      // 159: astore 5
      // 15b: aload 0
      // 15c: bipush 0
      // 15d: putfield x/oc6a43806f12.ȁ Z
      // 160: aload 5
      // 162: athrow
      // 163: iload 1
      // 164: ifeq 178
      // 167: bipush 0
      // 168: ifeq 174
      // 16b: goto 16f
      // 16e: athrow
      // 16f: bipush 0
      // 170: goto 175
      // 173: athrow
      // 174: bipush 1
      // 175: putstatic x/oc69da1aa7f5.Ҭ Z
      // 178: return
   }

   public static boolean Π() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc74760d9133.ƞ I
      // 03: istore 0
      // 04: getstatic x/oc6a43806f12.j Lx/oca9cc61aada;
      // 07: iload 0
      // 08: ifne 15
      // 0b: ifnull 2d
      // 0e: goto 12
      // 11: athrow
      // 12: getstatic x/oc6a43806f12.j Lx/oca9cc61aada;
      // 15: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 18: d2i
      // 19: iload 0
      // 1a: ifne 2a
      // 1d: bipush 1
      // 1e: if_icmpne 2d
      // 21: goto 25
      // 24: athrow
      // 25: bipush 1
      // 26: goto 2a
      // 29: athrow
      // 2a: goto 2e
      // 2d: bipush 0
      // 2e: ireturn
   }

   public static boolean ĺ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc74760d9133.ƞ I
      // 03: istore 0
      // 04: getstatic x/oc6a43806f12.j Lx/oca9cc61aada;
      // 07: iload 0
      // 08: ifne 15
      // 0b: ifnull 31
      // 0e: goto 12
      // 11: athrow
      // 12: getstatic x/oc6a43806f12.j Lx/oca9cc61aada;
      // 15: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 18: d2i
      // 19: iload 0
      // 1a: ifne 2e
      // 1d: ldc 1144926557
      // 1f: ldc 1144926559
      // 21: ixor
      // 22: if_icmpne 31
      // 25: goto 29
      // 28: athrow
      // 29: bipush 1
      // 2a: goto 2e
      // 2d: athrow
      // 2e: goto 32
      // 31: bipush 0
      // 32: ireturn
   }

   private GuiScreen ϝ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc74760d9133.ƞ I
      // 03: istore 1
      // 04: invokestatic x/oc6a43806f12.ĺ ()Z
      // 07: iload 1
      // 08: ifne 1a
      // 0b: ifeq 17
      // 0e: goto 12
      // 11: athrow
      // 12: getstatic x/oc2cf3d80e17.ե Lx/oc1cb76bf763;
      // 15: areturn
      // 16: athrow
      // 17: invokestatic x/oc6a43806f12.Π ()Z
      // 1a: ifeq 22
      // 1d: getstatic x/oc2cf3d80e17.ӎ Lx/oc6a954e7c9f;
      // 20: areturn
      // 21: athrow
      // 22: getstatic x/oc2cf3d80e17.V Lx/oc2c25634a7e;
      // 25: areturn
   }

   private void F() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc74760d9133.ƞ I
      // 03: aload 0
      // 04: invokevirtual x/oc6a43806f12.ϝ ()Lnet/minecraft/client/gui/GuiScreen;
      // 07: astore 2
      // 08: istore 1
      // 09: aload 2
      // 0a: iload 1
      // 0b: ifne 27
      // 0e: ifnull 2b
      // 11: goto 15
      // 14: athrow
      // 15: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 18: iload 1
      // 19: ifne 30
      // 1c: goto 20
      // 1f: athrow
      // 20: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 23: goto 27
      // 26: athrow
      // 27: aload 2
      // 28: if_acmpne 2d
      // 2b: return
      // 2c: athrow
      // 2d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 30: aload 2
      // 31: invokevirtual net/minecraft/client/Minecraft.displayGuiScreen (Lnet/minecraft/client/gui/GuiScreen;)V
      // 34: aload 2
      // 35: getstatic x/oc2cf3d80e17.V Lx/oc2c25634a7e;
      // 38: if_acmpne 45
      // 3b: getstatic x/oc2cf3d80e17.V Lx/oc2c25634a7e;
      // 3e: invokevirtual x/oc2c25634a7e.V ()V
      // 41: goto 45
      // 44: athrow
      // 45: return
   }

   public static String à() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc74760d9133.ƞ I
      // 03: istore 0
      // 04: getstatic x/oc6a43806f12.Ρ Lx/oca9cc61aada;
      // 07: iload 0
      // 08: ifne 15
      // 0b: ifnull 39
      // 0e: goto 12
      // 11: athrow
      // 12: getstatic x/oc6a43806f12.Ρ Lx/oca9cc61aada;
      // 15: invokevirtual x/oca9cc61aada.Ҿ ()[Ljava/lang/String;
      // 18: iload 0
      // 19: ifne 3c
      // 1c: ifnull 39
      // 1f: goto 23
      // 22: athrow
      // 23: getstatic x/oc6a43806f12.Ρ Lx/oca9cc61aada;
      // 26: invokevirtual x/oca9cc61aada.Ҿ ()[Ljava/lang/String;
      // 29: arraylength
      // 2a: iload 0
      // 2b: ifne 57
      // 2e: goto 32
      // 31: athrow
      // 32: ifne 3f
      // 35: goto 39
      // 38: athrow
      // 39: getstatic x/oc6a43806f12.ʩ [Ljava/lang/String;
      // 3c: bipush 0
      // 3d: aaload
      // 3e: areturn
      // 3f: dconst_0
      // 40: getstatic x/oc6a43806f12.Ρ Lx/oca9cc61aada;
      // 43: invokevirtual x/oca9cc61aada.Ҿ ()[Ljava/lang/String;
      // 46: arraylength
      // 47: bipush 1
      // 48: isub
      // 49: i2d
      // 4a: getstatic x/oc6a43806f12.Ρ Lx/oca9cc61aada;
      // 4d: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 50: invokestatic java/lang/Math.min (DD)D
      // 53: invokestatic java/lang/Math.max (DD)D
      // 56: d2i
      // 57: istore 1
      // 58: getstatic x/oc6a43806f12.Ρ Lx/oca9cc61aada;
      // 5b: invokevirtual x/oca9cc61aada.Ҿ ()[Ljava/lang/String;
      // 5e: iload 1
      // 5f: aaload
      // 60: areturn
   }

   public static oc1378bc114d ĉ() {
      return oc3ebac73392.Ε(à());
   }

   public static oc1378bc114d ю() {
      return oc3ebac73392.ĺ(à());
   }

   public static float ȝ() {
      try {
         if (Г == null) {
            return 1.0F;
         }
      } catch (ocbde1165e4e var0) {
         throw var0;
      }

      return (float)Math.max(0.5, Math.min(2.0, Г.Ӂ()));
   }

   static {
      String[] var10000 = new String[2042718959 ^ 2042718956];
      var10000[0] = "Raven";
      var10000[1] = "Slinky";
      var10000[2042718958 ^ 2042718956] = "Miau";
      ѵ = var10000;
   }
}

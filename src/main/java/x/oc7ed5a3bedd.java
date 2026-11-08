package x;

import java.awt.Color;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.EXTFramebufferObject;
import org.lwjgl.opengl.GL11;

public class oc7ed5a3bedd extends oc69da1aa7f5 {
   private static final String[] Ɋ;
   private static final String[] ŷ;
   private static final String[] ӯ;
   private static final String[] չ;
   private static final int Ƌ = 0;
   private static final int ɍ = 1;
   private static final int Ҡ = 2;
   private static final int Ȉ = 4;
   private static final float Ǭ = 6.0F;
   private static final int Җ = 2;
   private oca9cc61aada ϫ;
   private oca9cc61aada Ӓ;
   private oca9cc61aada Н;
   private oca9cc61aada F;
   private oca9cc61aada ŭ;
   private oca9cc61aada ĩ;
   private occ2f8dff8d8 Ĕ;
   private occ2f8dff8d8 ʮ;
   private occ2f8dff8d8 ˠ;
   private occ2f8dff8d8 ʴ;
   private occ2f8dff8d8 ƥ;
   private occ2f8dff8d8 Զ;
   private occ2f8dff8d8 Ϊ;
   private occ2f8dff8d8 Ț;
   private occ2f8dff8d8 Ͽ;
   private oc5f2027353d Ь;
   private EntityLivingBase ɋ;
   public EntityLivingBase Ζ;
   public int Ș = -1794697441 ^ -1794697383;
   public int ɐ = -1794697401 ^ -1794697383;
   private final Map<EntityLivingBase, occcc6917ff6> ɣ = new WeakHashMap<>();
   private final Map<EntityLivingBase, occ4083141c7> ϳ = new WeakHashMap<>();
   private final Map<EntityLivingBase, ocd941e94801> բ = new WeakHashMap<>();
   private final Map<EntityLivingBase, ResourceLocation> ҷ = new WeakHashMap<>();
   private final oc8ef88da691 Ŝ = new oc8ef88da691(false, System.currentTimeMillis());
   private boolean ʕ;
   private double ͻ;
   private double Ǧ;
   private double ƀ;
   private double ү;
   public static boolean ɒ;

   public oc7ed5a3bedd() {
      super("TargetHUD", oce4cea752dd.Ŏ);
      this.ʌ(new oc4d46a99983("Only works with KillAura."));
      this.ʌ(this.ϫ = new oca9cc61aada("Mode", 1, ŷ));
      this.ʌ(this.Ӓ = new oca9cc61aada("Raven mode", 0, ӯ));
      this.ʌ(this.Н = new oca9cc61aada("Animation", -1794697381 ^ -1794697383, Ɋ));
      this.ʌ(this.F = new oca9cc61aada("Scale", 1.0, 0.5, 2.0, 0.01));
      this.ʌ(this.ʴ = new occ2f8dff8d8("Multi targets", true));
      this.ʌ(this.Ĕ = new occ2f8dff8d8("Render ESP", true));
      this.ʌ(this.ʮ = new occ2f8dff8d8("Show win or loss", true));
      this.ʌ(this.ˠ = new occ2f8dff8d8("Traditional health color", false));
      this.ʌ(this.ŭ = new oca9cc61aada("Color", 0, չ));
      this.ʌ(this.ĩ = new oca9cc61aada("Background", "%", 25.0, 0.0, 100.0, 1.0));
      this.ʌ(this.ƥ = new occ2f8dff8d8("Head", true));
      this.ʌ(this.Զ = new occ2f8dff8d8("Indicator", true));
      this.ʌ(this.Ϊ = new occ2f8dff8d8("Outline", false));
      this.ʌ(this.Ț = new occ2f8dff8d8("Animations", true));
      this.ʌ(this.Ͽ = new occ2f8dff8d8("Shadow", true));
   }

   @Override
   public void onDisable() {
      this.ǻ();
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
      // 004: getfield x/oc7ed5a3bedd.ϫ Lx/oca9cc61aada;
      // 007: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 00a: d2i
      // 00b: istore 2
      // 00c: istore 1
      // 00d: iload 2
      // 00e: iload 1
      // 00f: ifne 01a
      // 012: ifne 01d
      // 015: goto 019
      // 018: athrow
      // 019: bipush 1
      // 01a: goto 01e
      // 01d: bipush 0
      // 01e: istore 3
      // 01f: iload 2
      // 020: iload 1
      // 021: ifne 031
      // 024: bipush 1
      // 025: if_icmpne 034
      // 028: goto 02c
      // 02b: athrow
      // 02c: bipush 1
      // 02d: goto 031
      // 030: athrow
      // 031: goto 035
      // 034: bipush 0
      // 035: istore 4
      // 037: iload 2
      // 038: iload 1
      // 039: ifne 04d
      // 03c: ldc -1399070997
      // 03e: ldc -1399070999
      // 040: ixor
      // 041: if_icmpne 050
      // 044: goto 048
      // 047: athrow
      // 048: bipush 1
      // 049: goto 04d
      // 04c: athrow
      // 04d: goto 051
      // 050: bipush 0
      // 051: istore 5
      // 053: aload 0
      // 054: iload 1
      // 055: ifne 070
      // 058: getfield x/oc7ed5a3bedd.Ӓ Lx/oca9cc61aada;
      // 05b: ifnull 06f
      // 05e: goto 062
      // 061: athrow
      // 062: aload 0
      // 063: getfield x/oc7ed5a3bedd.Ӓ Lx/oca9cc61aada;
      // 066: iload 3
      // 067: aload 0
      // 068: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 06b: goto 06f
      // 06e: athrow
      // 06f: aload 0
      // 070: iload 1
      // 071: ifne 08c
      // 074: getfield x/oc7ed5a3bedd.ʮ Lx/occ2f8dff8d8;
      // 077: ifnull 08b
      // 07a: goto 07e
      // 07d: athrow
      // 07e: aload 0
      // 07f: getfield x/oc7ed5a3bedd.ʮ Lx/occ2f8dff8d8;
      // 082: iload 3
      // 083: aload 0
      // 084: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 087: goto 08b
      // 08a: athrow
      // 08b: aload 0
      // 08c: iload 1
      // 08d: ifne 0a8
      // 090: getfield x/oc7ed5a3bedd.ˠ Lx/occ2f8dff8d8;
      // 093: ifnull 0a7
      // 096: goto 09a
      // 099: athrow
      // 09a: aload 0
      // 09b: getfield x/oc7ed5a3bedd.ˠ Lx/occ2f8dff8d8;
      // 09e: iload 3
      // 09f: aload 0
      // 0a0: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0a3: goto 0a7
      // 0a6: athrow
      // 0a7: aload 0
      // 0a8: iload 1
      // 0a9: ifne 109
      // 0ac: getfield x/oc7ed5a3bedd.ʴ Lx/occ2f8dff8d8;
      // 0af: ifnull 0c4
      // 0b2: goto 0b6
      // 0b5: athrow
      // 0b6: aload 0
      // 0b7: getfield x/oc7ed5a3bedd.ʴ Lx/occ2f8dff8d8;
      // 0ba: iload 4
      // 0bc: aload 0
      // 0bd: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0c0: goto 0c4
      // 0c3: athrow
      // 0c4: aload 0
      // 0c5: getfield x/oc7ed5a3bedd.ŭ Lx/oca9cc61aada;
      // 0c8: iload 5
      // 0ca: aload 0
      // 0cb: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0ce: aload 0
      // 0cf: getfield x/oc7ed5a3bedd.ĩ Lx/oca9cc61aada;
      // 0d2: iload 5
      // 0d4: aload 0
      // 0d5: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0d8: aload 0
      // 0d9: getfield x/oc7ed5a3bedd.ƥ Lx/occ2f8dff8d8;
      // 0dc: iload 5
      // 0de: aload 0
      // 0df: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0e2: aload 0
      // 0e3: getfield x/oc7ed5a3bedd.Զ Lx/occ2f8dff8d8;
      // 0e6: iload 5
      // 0e8: aload 0
      // 0e9: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0ec: aload 0
      // 0ed: getfield x/oc7ed5a3bedd.Ϊ Lx/occ2f8dff8d8;
      // 0f0: iload 5
      // 0f2: aload 0
      // 0f3: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0f6: aload 0
      // 0f7: getfield x/oc7ed5a3bedd.Ț Lx/occ2f8dff8d8;
      // 0fa: iload 5
      // 0fc: iload 1
      // 0fd: ifne 122
      // 100: aload 0
      // 101: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 104: aload 0
      // 105: goto 109
      // 108: athrow
      // 109: getfield x/oc7ed5a3bedd.Ͽ Lx/occ2f8dff8d8;
      // 10c: iload 3
      // 10d: ifne 121
      // 110: iload 5
      // 112: iload 1
      // 113: ifne 122
      // 116: goto 11a
      // 119: athrow
      // 11a: ifeq 125
      // 11d: goto 121
      // 120: athrow
      // 121: bipush 1
      // 122: goto 126
      // 125: bipush 0
      // 126: aload 0
      // 127: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 12a: return
   }

   @Override
   public void onEnable() {
      this.ǻ();
      this.z$2u87utkr1isxg();
   }

   @Override
   public void z$1sehylui0i4ix(oca9cc61aada param1) {
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
      // 06: ifne 19
      // 09: aload 0
      // 0a: getfield x/oc7ed5a3bedd.ϫ Lx/oca9cc61aada;
      // 0d: if_acmpeq 20
      // 10: goto 14
      // 13: athrow
      // 14: aload 1
      // 15: goto 19
      // 18: athrow
      // 19: aload 0
      // 1a: getfield x/oc7ed5a3bedd.Ӓ Lx/oca9cc61aada;
      // 1d: if_acmpne 4c
      // 20: aload 0
      // 21: getfield x/oc7ed5a3bedd.ɣ Ljava/util/Map;
      // 24: invokeinterface java/util/Map.clear ()V 1
      // 29: aload 0
      // 2a: getfield x/oc7ed5a3bedd.ϳ Ljava/util/Map;
      // 2d: invokeinterface java/util/Map.clear ()V 1
      // 32: aload 0
      // 33: getfield x/oc7ed5a3bedd.բ Ljava/util/Map;
      // 36: invokeinterface java/util/Map.clear ()V 1
      // 3b: aload 0
      // 3c: getfield x/oc7ed5a3bedd.ҷ Ljava/util/Map;
      // 3f: invokeinterface java/util/Map.clear ()V 1
      // 44: aload 0
      // 45: invokevirtual x/oc7ed5a3bedd.z$2u87utkr1isxg ()V
      // 48: goto 4c
      // 4b: athrow
      // 4c: return
   }

   @oc66fa4f2195
   public void ō(ocf923d5a814 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 2
      // 04: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 07: ifne 10
      // 0a: aload 0
      // 0b: invokevirtual x/oc7ed5a3bedd.ǻ ()V
      // 0e: return
      // 0f: athrow
      // 10: aload 1
      // 11: getfield x/ocb508b4e274.Ұ Lx/oc110d7f376c;
      // 14: getstatic x/oc110d7f376c.END Lx/oc110d7f376c;
      // 17: if_acmpne ee
      // 1a: aload 0
      // 1b: getfield x/oc7ed5a3bedd.ϫ Lx/oca9cc61aada;
      // 1e: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 21: d2i
      // 22: istore 3
      // 23: invokestatic java/lang/System.currentTimeMillis ()J
      // 26: lstore 4
      // 28: aload 0
      // 29: iload 2
      // 2a: ifne 41
      // 2d: iload 3
      // 2e: lload 4
      // 30: invokevirtual x/oc7ed5a3bedd.μ (IJ)V
      // 33: aload 0
      // 34: getfield x/oc7ed5a3bedd.ɋ Lnet/minecraft/entity/EntityLivingBase;
      // 37: ifnonnull 40
      // 3a: goto 3e
      // 3d: athrow
      // 3e: return
      // 3f: athrow
      // 40: aload 0
      // 41: lload 4
      // 43: invokevirtual x/oc7ed5a3bedd.օ (J)F
      // 46: fstore 6
      // 48: iload 2
      // 49: ifne 76
      // 4c: fload 6
      // 4e: fconst_0
      // 4f: fcmpg
      // 50: ifgt 6c
      // 53: goto 57
      // 56: athrow
      // 57: aload 0
      // 58: iload 2
      // 59: ifne 71
      // 5c: goto 60
      // 5f: athrow
      // 60: invokevirtual x/oc7ed5a3bedd.ž ()Z
      // 63: ifne 6c
      // 66: goto 6a
      // 69: athrow
      // 6a: return
      // 6b: athrow
      // 6c: aload 0
      // 6d: invokevirtual x/oc7ed5a3bedd.Ň ()V
      // 70: aload 0
      // 71: fload 6
      // 73: invokevirtual x/oc7ed5a3bedd.Ͷ (F)V
      // 76: iload 3
      // 77: iload 2
      // 78: ifne a2
      // 7b: bipush 1
      // 7c: if_icmpne 9d
      // 7f: goto 83
      // 82: athrow
      // 83: aload 0
      // 84: aload 0
      // 85: invokevirtual x/oc7ed5a3bedd.ĝ ()Z
      // 88: ifeq 95
      // 8b: goto 8f
      // 8e: athrow
      // 8f: fload 6
      // 91: goto 96
      // 94: athrow
      // 95: fconst_1
      // 96: invokevirtual x/oc7ed5a3bedd.ԡ (F)V
      // 99: iload 2
      // 9a: ifeq d6
      // 9d: iload 3
      // 9e: goto a2
      // a1: athrow
      // a2: ldc_w 1438238515
      // a5: ldc_w 1438238513
      // a8: ixor
      // a9: if_icmpne ca
      // ac: aload 0
      // ad: aload 0
      // ae: getfield x/oc7ed5a3bedd.ɋ Lnet/minecraft/entity/EntityLivingBase;
      // b1: aload 0
      // b2: invokevirtual x/oc7ed5a3bedd.ĝ ()Z
      // b5: ifeq c2
      // b8: goto bc
      // bb: athrow
      // bc: fload 6
      // be: goto c3
      // c1: athrow
      // c2: fconst_1
      // c3: invokevirtual x/oc7ed5a3bedd.Ĭ (Lnet/minecraft/entity/EntityLivingBase;F)V
      // c6: iload 2
      // c7: ifeq d6
      // ca: aload 0
      // cb: aload 0
      // cc: getfield x/oc7ed5a3bedd.ɋ Lnet/minecraft/entity/EntityLivingBase;
      // cf: invokevirtual x/oc7ed5a3bedd.x (Lnet/minecraft/entity/EntityLivingBase;)V
      // d2: goto d6
      // d5: athrow
      // d6: aload 0
      // d7: invokevirtual x/oc7ed5a3bedd.ə ()V
      // da: aload 0
      // db: invokevirtual x/oc7ed5a3bedd.έ ()V
      // de: goto ee
      // e1: astore 7
      // e3: aload 0
      // e4: invokevirtual x/oc7ed5a3bedd.ə ()V
      // e7: aload 0
      // e8: invokevirtual x/oc7ed5a3bedd.έ ()V
      // eb: aload 7
      // ed: athrow
      // ee: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGHEST
   )
   public void ü(oc746a23b244 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 2
      // 04: aload 0
      // 05: getfield x/oc7ed5a3bedd.Ĕ Lx/occ2f8dff8d8;
      // 08: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0b: iload 2
      // 0c: ifne 19
      // 0f: ifeq 34
      // 12: goto 16
      // 15: athrow
      // 16: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 19: iload 2
      // 1a: ifne 31
      // 1d: ifeq 34
      // 20: goto 24
      // 23: athrow
      // 24: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 27: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 2a: invokestatic x/oc7ed5a3bedd.V (Lnet/minecraft/client/gui/GuiScreen;)Z
      // 2d: goto 31
      // 30: athrow
      // 31: ifne 35
      // 34: return
      // 35: getstatic x/ocdd342096f8.f Lnet/minecraft/entity/EntityLivingBase;
      // 38: iload 2
      // 39: ifne 6f
      // 3c: ifnull 5f
      // 3f: goto 43
      // 42: athrow
      // 43: getstatic x/ocdd342096f8.f Lnet/minecraft/entity/EntityLivingBase;
      // 46: ldc_w 805040683
      // 49: ldc_w 805040681
      // 4c: ixor
      // 4d: dconst_0
      // 4e: dconst_0
      // 4f: dconst_0
      // 50: invokestatic x/ocd2958dac48.ů (D)I
      // 53: bipush 0
      // 54: invokestatic x/ocbd4917c4b1.ƨ (Lnet/minecraft/entity/Entity;IDDIZ)V
      // 57: iload 2
      // 58: ifeq 87
      // 5b: goto 5f
      // 5e: athrow
      // 5f: aload 0
      // 60: iload 2
      // 61: ifne 73
      // 64: goto 68
      // 67: athrow
      // 68: getfield x/oc7ed5a3bedd.Ζ Lnet/minecraft/entity/EntityLivingBase;
      // 6b: goto 6f
      // 6e: athrow
      // 6f: ifnull 87
      // 72: aload 0
      // 73: getfield x/oc7ed5a3bedd.Ζ Lnet/minecraft/entity/EntityLivingBase;
      // 76: ldc_w 805040683
      // 79: ldc_w 805040681
      // 7c: ixor
      // 7d: dconst_0
      // 7e: dconst_0
      // 7f: dconst_0
      // 80: invokestatic x/ocd2958dac48.ů (D)I
      // 83: bipush 0
      // 84: invokestatic x/ocbd4917c4b1.ƨ (Lnet/minecraft/entity/Entity;IDDIZ)V
      // 87: return
   }

   static boolean V(GuiScreen var0) {
      boolean var1 = oce6044968f8.ђ;

      try {
         boolean var10000 = var0 instanceof GuiChat;
         if (var1) {
            return var10000;
         }

         if (!var10000) {
            return true;
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }

      return false;
   }

   private void x(EntityLivingBase param1) {
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
      // 005: getfield net/minecraft/entity/EntityLivingBase.isDead Z
      // 008: ifeq 010
      // 00b: dconst_0
      // 00c: goto 022
      // 00f: athrow
      // 010: dconst_0
      // 011: dconst_1
      // 012: aload 1
      // 013: invokevirtual net/minecraft/entity/EntityLivingBase.getHealth ()F
      // 016: aload 1
      // 017: invokevirtual net/minecraft/entity/EntityLivingBase.getMaxHealth ()F
      // 01a: fdiv
      // 01b: f2d
      // 01c: invokestatic java/lang/Math.min (DD)D
      // 01f: invokestatic java/lang/Math.max (DD)D
      // 022: dstore 3
      // 023: aload 1
      // 024: invokevirtual net/minecraft/entity/EntityLivingBase.getHealth ()F
      // 027: iload 2
      // 028: ifne 041
      // 02b: aload 1
      // 02c: invokevirtual net/minecraft/entity/EntityLivingBase.getHealth ()F
      // 02f: f2i
      // 030: i2f
      // 031: fcmpl
      // 032: ifne 048
      // 035: goto 039
      // 038: athrow
      // 039: aload 1
      // 03a: invokevirtual net/minecraft/entity/EntityLivingBase.getHealth ()F
      // 03d: goto 041
      // 040: athrow
      // 041: f2i
      // 042: invokestatic java/lang/String.valueOf (I)Ljava/lang/String;
      // 045: goto 05f
      // 048: getstatic java/util/Locale.ROOT Ljava/util/Locale;
      // 04b: ldc_w "%.1f"
      // 04e: bipush 1
      // 04f: anewarray 412
      // 052: dup
      // 053: bipush 0
      // 054: aload 1
      // 055: invokevirtual net/minecraft/entity/EntityLivingBase.getHealth ()F
      // 058: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 05b: aastore
      // 05c: invokestatic java/lang/String.format (Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      // 05f: astore 5
      // 061: aload 1
      // 062: invokevirtual net/minecraft/entity/EntityLivingBase.getDisplayName ()Lnet/minecraft/util/IChatComponent;
      // 065: invokeinterface net/minecraft/util/IChatComponent.getFormattedText ()Ljava/lang/String; 1
      // 06a: astore 6
      // 06c: dload 3
      // 06d: ldc2_w 0.5
      // 070: dcmpl
      // 071: iload 2
      // 072: ifne 09b
      // 075: iflt 08f
      // 078: goto 07c
      // 07b: athrow
      // 07c: aload 6
      // 07e: aload 5
      // 080: ldc_w " §a"
      // 083: swap
      // 084: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001" ]
      // 089: astore 6
      // 08b: iload 2
      // 08c: ifeq 0c0
      // 08f: aload 1
      // 090: invokevirtual net/minecraft/entity/EntityLivingBase.getHealth ()F
      // 093: ldc_w 0.2
      // 096: fcmpl
      // 097: goto 09b
      // 09a: athrow
      // 09b: iflt 0b1
      // 09e: aload 6
      // 0a0: aload 5
      // 0a2: ldc_w " §e"
      // 0a5: swap
      // 0a6: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001" ]
      // 0ab: astore 6
      // 0ad: iload 2
      // 0ae: ifeq 0c0
      // 0b1: aload 6
      // 0b3: aload 5
      // 0b5: ldc_w " §c"
      // 0b8: swap
      // 0b9: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001" ]
      // 0be: astore 6
      // 0c0: aload 0
      // 0c1: getfield x/oc7ed5a3bedd.ʮ Lx/occ2f8dff8d8;
      // 0c4: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0c7: ifeq 0fa
      // 0ca: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0cd: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0d0: invokestatic x/oc7ab2161b9f.ɭ (Lnet/minecraft/entity/EntityLivingBase;)F
      // 0d3: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0d6: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0d9: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getMaxHealth ()F
      // 0dc: fdiv
      // 0dd: fstore 7
      // 0df: aload 6
      // 0e1: dload 3
      // 0e2: fload 7
      // 0e4: f2d
      // 0e5: dcmpg
      // 0e6: ifgt 0f0
      // 0e9: ldc_w " §aW"
      // 0ec: goto 0f3
      // 0ef: athrow
      // 0f0: ldc_w " §cL"
      // 0f3: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 0f8: astore 6
      // 0fa: new net/minecraft/client/gui/ScaledResolution
      // 0fd: dup
      // 0fe: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 101: invokespecial net/minecraft/client/gui/ScaledResolution.<init> (Lnet/minecraft/client/Minecraft;)V
      // 104: astore 7
      // 106: ldc_w 8.0
      // 109: fstore 8
      // 10b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 10e: getfield net/minecraft/client/Minecraft.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // 111: aload 6
      // 113: invokevirtual net/minecraft/client/gui/FontRenderer.getStringWidth (Ljava/lang/String;)I
      // 116: i2f
      // 117: fload 8
      // 119: ldc_w 3.0
      // 11c: fmul
      // 11d: fadd
      // 11e: fstore 9
      // 120: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 123: getfield net/minecraft/client/Minecraft.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // 126: getfield net/minecraft/client/gui/FontRenderer.FONT_HEIGHT I
      // 129: i2f
      // 12a: ldc_w 12.0
      // 12d: fadd
      // 12e: fload 8
      // 130: fconst_2
      // 131: fmul
      // 132: fadd
      // 133: fstore 10
      // 135: aload 7
      // 137: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledWidth ()I
      // 13a: i2f
      // 13b: fconst_2
      // 13c: fdiv
      // 13d: fload 9
      // 13f: fconst_2
      // 140: fdiv
      // 141: fsub
      // 142: aload 0
      // 143: getfield x/oc7ed5a3bedd.Ș I
      // 146: i2f
      // 147: fadd
      // 148: fstore 11
      // 14a: aload 7
      // 14c: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledHeight ()I
      // 14f: i2f
      // 150: fconst_2
      // 151: fdiv
      // 152: ldc_w 7.0
      // 155: fadd
      // 156: aload 0
      // 157: getfield x/oc7ed5a3bedd.ɐ I
      // 15a: i2f
      // 15b: fadd
      // 15c: fstore 12
      // 15e: aload 0
      // 15f: fload 11
      // 161: fload 12
      // 163: fload 9
      // 165: fload 10
      // 167: invokevirtual x/oc7ed5a3bedd.ù (FFFF)V
      // 16a: aload 0
      // 16b: getfield x/oc7ed5a3bedd.Ь Lx/oc5f2027353d;
      // 16e: ifnonnull 17c
      // 171: ldc_w -1635590415
      // 174: ldc_w -1635590642
      // 177: ixor
      // 178: goto 194
      // 17b: athrow
      // 17c: ldc_w -1635590415
      // 17f: ldc_w -1635590642
      // 182: ixor
      // 183: aload 0
      // 184: getfield x/oc7ed5a3bedd.Ь Lx/oc5f2027353d;
      // 187: bipush 0
      // 188: ldc_w -1635590415
      // 18b: ldc_w -1635590642
      // 18e: ixor
      // 18f: bipush 1
      // 190: invokevirtual x/oc5f2027353d.Ӟ (III)I
      // 193: isub
      // 194: istore 13
      // 196: iload 13
      // 198: iload 2
      // 199: ifne 1b6
      // 19c: ifgt 1aa
      // 19f: goto 1a3
      // 1a2: athrow
      // 1a3: aload 0
      // 1a4: aconst_null
      // 1a5: putfield x/oc7ed5a3bedd.ɋ Lnet/minecraft/entity/EntityLivingBase;
      // 1a8: return
      // 1a9: athrow
      // 1aa: iload 13
      // 1ac: ldc_w -1635590560
      // 1af: ldc_w -1635590642
      // 1b2: ixor
      // 1b3: invokestatic java/lang/Math.min (II)I
      // 1b6: istore 14
      // 1b8: iload 13
      // 1ba: ldc_w -1635590436
      // 1bd: ldc_w -1635590642
      // 1c0: ixor
      // 1c1: invokestatic java/lang/Math.min (II)I
      // 1c4: istore 15
      // 1c6: ldc_w -1635590644
      // 1c9: ldc_w -1635590642
      // 1cc: ixor
      // 1cd: newarray 10
      // 1cf: dup
      // 1d0: bipush 0
      // 1d1: dconst_0
      // 1d2: invokestatic x/ocd2958dac48.ů (D)I
      // 1d5: iastore
      // 1d6: dup
      // 1d7: bipush 1
      // 1d8: ldc2_w 48.0
      // 1db: invokestatic x/ocd2958dac48.ů (D)I
      // 1de: iastore
      // 1df: astore 16
      // 1e1: aload 0
      // 1e2: getfield x/oc7ed5a3bedd.Ӓ Lx/oca9cc61aada;
      // 1e5: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 1e8: d2i
      // 1e9: iload 2
      // 1ea: ifne 1fa
      // 1ed: bipush 1
      // 1ee: if_icmpne 1fd
      // 1f1: goto 1f5
      // 1f4: athrow
      // 1f5: bipush 1
      // 1f6: goto 1fa
      // 1f9: athrow
      // 1fa: goto 1fe
      // 1fd: bipush 0
      // 1fe: istore 17
      // 200: iload 17
      // 202: ifeq 2ae
      // 205: aload 0
      // 206: getfield x/oc7ed5a3bedd.Ь Lx/oc5f2027353d;
      // 209: ifnonnull 215
      // 20c: goto 210
      // 20f: athrow
      // 210: fconst_2
      // 211: goto 21e
      // 214: athrow
      // 215: fconst_2
      // 216: iload 13
      // 218: i2f
      // 219: fmul
      // 21a: ldc_w 255.0
      // 21d: fdiv
      // 21e: fstore 18
      // 220: aload 0
      // 221: getfield x/oc7ed5a3bedd.Ь Lx/oc5f2027353d;
      // 224: ifnonnull 22e
      // 227: ldc_w 3.0
      // 22a: goto 239
      // 22d: athrow
      // 22e: ldc_w 3.0
      // 231: iload 13
      // 233: i2f
      // 234: fmul
      // 235: ldc_w 255.0
      // 238: fdiv
      // 239: fstore 19
      // 23b: fload 11
      // 23d: fload 12
      // 23f: fload 9
      // 241: fload 10
      // 243: iload 15
      // 245: invokedynamic run (FFFFI)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, x/oc7ed5a3bedd.q11hfmuwo8qnye (FFFFI)V, ()V ]
      // 24a: ldc_w -1635590643
      // 24d: ldc_w -1635590642
      // 250: ixor
      // 251: fload 18
      // 253: invokestatic x/oc1b46ea259e.І (Ljava/lang/Runnable;IF)Z
      // 256: istore 20
      // 258: fload 11
      // 25a: fload 12
      // 25c: fload 9
      // 25e: fload 10
      // 260: iload 14
      // 262: invokedynamic run (FFFFI)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, x/oc7ed5a3bedd.q3kw15h5uumru1 (FFFFI)V, ()V ]
      // 267: ldc_w -1635590644
      // 26a: ldc_w -1635590642
      // 26d: ixor
      // 26e: fload 19
      // 270: invokestatic x/oc1b46ea259e.ψ (Ljava/lang/Runnable;IF)Z
      // 273: istore 21
      // 275: iload 20
      // 277: iload 2
      // 278: ifne 284
      // 27b: ifne 2aa
      // 27e: goto 282
      // 281: athrow
      // 282: iload 21
      // 284: ifne 2aa
      // 287: fload 11
      // 289: fload 12
      // 28b: fload 11
      // 28d: fload 9
      // 28f: fadd
      // 290: fload 12
      // 292: fload 10
      // 294: fadd
      // 295: ldc_w 8.0
      // 298: getstatic java/awt/Color.BLACK Ljava/awt/Color;
      // 29b: invokevirtual java/awt/Color.getRGB ()I
      // 29e: iload 15
      // 2a0: invokestatic x/oc7ab2161b9f.Ҭ (II)I
      // 2a3: invokestatic x/ocbd4917c4b1.Ӛ (FFFFFI)V
      // 2a6: goto 2aa
      // 2a9: athrow
      // 2aa: iload 2
      // 2ab: ifeq 2e3
      // 2ae: fload 11
      // 2b0: fload 12
      // 2b2: fload 11
      // 2b4: fload 9
      // 2b6: fadd
      // 2b7: fload 12
      // 2b9: fload 10
      // 2bb: fadd
      // 2bc: ldc_w 10.0
      // 2bf: getstatic java/awt/Color.BLACK Ljava/awt/Color;
      // 2c2: invokevirtual java/awt/Color.getRGB ()I
      // 2c5: iload 14
      // 2c7: invokestatic x/oc7ab2161b9f.Ҭ (II)I
      // 2ca: aload 16
      // 2cc: bipush 0
      // 2cd: iaload
      // 2ce: iload 13
      // 2d0: invokestatic x/oc7ab2161b9f.Ҭ (II)I
      // 2d3: aload 16
      // 2d5: bipush 1
      // 2d6: iaload
      // 2d7: iload 13
      // 2d9: invokestatic x/oc7ab2161b9f.Ҭ (II)I
      // 2dc: invokestatic x/ocbd4917c4b1.Т (FFFFFIII)V
      // 2df: goto 2e3
      // 2e2: athrow
      // 2e3: fload 11
      // 2e5: ldc 6.0
      // 2e7: fadd
      // 2e8: fstore 18
      // 2ea: fload 11
      // 2ec: fload 9
      // 2ee: fadd
      // 2ef: ldc 6.0
      // 2f1: fsub
      // 2f2: fstore 19
      // 2f4: fload 12
      // 2f6: fload 10
      // 2f8: fadd
      // 2f9: ldc_w 13.0
      // 2fc: fsub
      // 2fd: fstore 20
      // 2ff: fload 20
      // 301: ldc_w 5.0
      // 304: fadd
      // 305: fstore 21
      // 307: fload 18
      // 309: fload 20
      // 30b: fload 19
      // 30d: fload 21
      // 30f: ldc_w 4.0
      // 312: getstatic java/awt/Color.BLACK Ljava/awt/Color;
      // 315: invokevirtual java/awt/Color.getRGB ()I
      // 318: iload 14
      // 31a: invokestatic x/oc7ab2161b9f.Ҭ (II)I
      // 31d: invokestatic x/ocbd4917c4b1.Ӛ (FFFFFI)V
      // 320: aload 16
      // 322: bipush 0
      // 323: iaload
      // 324: iload 15
      // 326: invokestatic x/oc7ab2161b9f.Ҭ (II)I
      // 329: istore 22
      // 32b: aload 16
      // 32d: bipush 1
      // 32e: iaload
      // 32f: iload 15
      // 331: invokestatic x/oc7ab2161b9f.Ҭ (II)I
      // 334: istore 23
      // 336: aload 0
      // 337: iload 2
      // 338: ifne 34d
      // 33b: getfield x/oc7ed5a3bedd.ˠ Lx/occ2f8dff8d8;
      // 33e: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 341: ifeq 361
      // 344: goto 348
      // 347: athrow
      // 348: aload 0
      // 349: goto 34d
      // 34c: athrow
      // 34d: dload 3
      // 34e: d2f
      // 34f: iload 15
      // 351: invokevirtual x/oc7ed5a3bedd.ѽ (FI)Ljava/awt/Color;
      // 354: invokevirtual java/awt/Color.getRGB ()I
      // 357: istore 24
      // 359: iload 24
      // 35b: istore 22
      // 35d: iload 24
      // 35f: istore 23
      // 361: invokestatic java/lang/System.currentTimeMillis ()J
      // 364: lstore 24
      // 366: aload 0
      // 367: aload 1
      // 368: invokevirtual x/oc7ed5a3bedd.Ǩ (Lnet/minecraft/entity/EntityLivingBase;)Lx/occ4083141c7;
      // 36b: astore 26
      // 36d: aload 26
      // 36f: dload 3
      // 370: d2f
      // 371: lload 24
      // 373: iload 17
      // 375: ifeq 383
      // 378: ldc2_w 3645667258616557469
      // 37b: ldc2_w 3645667258616557161
      // 37e: lxor
      // 37f: goto 38a
      // 382: athrow
      // 383: ldc2_w 3645667258616557367
      // 386: ldc2_w 3645667258616557161
      // 389: lxor
      // 38a: iload 17
      // 38c: invokevirtual x/occ4083141c7.Ɉ (FJJZ)V
      // 38f: aload 26
      // 391: invokevirtual x/occ4083141c7.Ƣ ()F
      // 394: fstore 27
      // 396: fload 19
      // 398: fload 18
      // 39a: fsub
      // 39b: fstore 28
      // 39d: iload 17
      // 39f: iload 2
      // 3a0: ifne 42b
      // 3a3: ifeq 423
      // 3a6: goto 3aa
      // 3a9: athrow
      // 3aa: dload 3
      // 3ab: d2f
      // 3ac: fload 27
      // 3ae: invokestatic java/lang/Math.min (FF)F
      // 3b1: fstore 29
      // 3b3: fload 27
      // 3b5: fconst_0
      // 3b6: iload 2
      // 3b7: ifne 3fb
      // 3ba: fcmpl
      // 3bb: ifle 3f0
      // 3be: goto 3c2
      // 3c1: athrow
      // 3c2: aload 0
      // 3c3: new java/awt/Color
      // 3c6: dup
      // 3c7: iload 23
      // 3c9: bipush 1
      // 3ca: invokespecial java/awt/Color.<init> (IZ)V
      // 3cd: ldc_w 0.75
      // 3d0: iload 15
      // 3d2: invokevirtual x/oc7ed5a3bedd.ѱ (Ljava/awt/Color;FI)Ljava/awt/Color;
      // 3d5: astore 30
      // 3d7: fload 18
      // 3d9: fload 20
      // 3db: fload 18
      // 3dd: fload 28
      // 3df: fload 27
      // 3e1: fmul
      // 3e2: fadd
      // 3e3: fload 21
      // 3e5: ldc_w 4.0
      // 3e8: aload 30
      // 3ea: invokevirtual java/awt/Color.getRGB ()I
      // 3ed: invokestatic x/ocbd4917c4b1.Ӛ (FFFFFI)V
      // 3f0: fload 29
      // 3f2: iload 2
      // 3f3: ifne 405
      // 3f6: fconst_0
      // 3f7: goto 3fb
      // 3fa: athrow
      // 3fb: fcmpl
      // 3fc: ifle 41f
      // 3ff: fload 18
      // 401: goto 405
      // 404: athrow
      // 405: fload 20
      // 407: fload 18
      // 409: fload 28
      // 40b: fload 29
      // 40d: fmul
      // 40e: fadd
      // 40f: fload 21
      // 411: ldc_w 4.0
      // 414: iload 22
      // 416: iload 22
      // 418: iload 23
      // 41a: iload 23
      // 41c: invokestatic x/ocbd4917c4b1.Ӷ (FFFFFIIII)V
      // 41f: iload 2
      // 420: ifeq 456
      // 423: fload 27
      // 425: fconst_0
      // 426: fcmpl
      // 427: goto 42b
      // 42a: athrow
      // 42b: iload 2
      // 42c: ifne 493
      // 42f: ifle 456
      // 432: goto 436
      // 435: athrow
      // 436: fload 18
      // 438: fload 20
      // 43a: fload 18
      // 43c: fload 28
      // 43e: fload 27
      // 440: fmul
      // 441: fadd
      // 442: fload 21
      // 444: ldc_w 4.0
      // 447: iload 22
      // 449: iload 22
      // 44b: iload 23
      // 44d: iload 23
      // 44f: invokestatic x/ocbd4917c4b1.Ӷ (FFFFFIIII)V
      // 452: goto 456
      // 455: athrow
      // 456: new java/awt/Color
      // 459: dup
      // 45a: ldc_w -1635590446
      // 45d: ldc_w -1635590642
      // 460: ixor
      // 461: ldc_w -1635590446
      // 464: ldc_w -1635590642
      // 467: ixor
      // 468: ldc_w -1635590446
      // 46b: ldc_w -1635590642
      // 46e: ixor
      // 46f: invokespecial java/awt/Color.<init> (III)V
      // 472: invokevirtual java/awt/Color.getRGB ()I
      // 475: ldc_w -1635966479
      // 478: ldc_w -1635590642
      // 47b: ixor
      // 47c: iand
      // 47d: iload 13
      // 47f: ldc_w -1635590655
      // 482: ldc_w -1635590642
      // 485: ixor
      // 486: iadd
      // 487: invokestatic x/oc7ab2161b9f.Պ (I)I
      // 48a: ldc_w -1635590634
      // 48d: ldc_w -1635590642
      // 490: ixor
      // 491: ishl
      // 492: ior
      // 493: istore 29
      // 495: invokestatic net/minecraft/client/renderer/GlStateManager.enableBlend ()V
      // 498: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 49b: getfield net/minecraft/client/Minecraft.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // 49e: aload 6
      // 4a0: fload 11
      // 4a2: fload 8
      // 4a4: fadd
      // 4a5: fload 12
      // 4a7: fload 8
      // 4a9: fadd
      // 4aa: iload 29
      // 4ac: aload 0
      // 4ad: getfield x/oc7ed5a3bedd.Ͽ Lx/occ2f8dff8d8;
      // 4b0: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 4b3: invokevirtual net/minecraft/client/gui/FontRenderer.drawString (Ljava/lang/String;FFIZ)I
      // 4b6: pop
      // 4b7: invokestatic net/minecraft/client/renderer/GlStateManager.disableBlend ()V
      // 4ba: return
   }

   private occ4083141c7 Ǩ(EntityLivingBase var1) {
      boolean var10000 = oce6044968f8.ђ;
      occ4083141c7 var3 = this.ϳ.get(var1);
      boolean var2 = var10000;

      try {
         if (var2) {
            return var3;
         }

         if (var3 != null) {
            return var3;
         }
      } catch (ocbde1165e4e var4) {
         throw var4;
      }

      var3 = new occ4083141c7();
      this.ϳ.put(var1, var3);
      return var3;
   }

   private void Ĭ(EntityLivingBase param1, float param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: istore 3
      // 004: fload 2
      // 005: iload 3
      // 006: ifne 029
      // 009: fconst_0
      // 00a: fcmpg
      // 00b: ifgt 014
      // 00e: goto 012
      // 011: athrow
      // 012: return
      // 013: athrow
      // 014: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 017: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 01a: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHealth ()F
      // 01d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 020: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 023: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getAbsorptionAmount ()F
      // 026: fadd
      // 027: fconst_2
      // 028: fdiv
      // 029: fstore 4
      // 02b: aload 1
      // 02c: invokevirtual net/minecraft/entity/EntityLivingBase.getAbsorptionAmount ()F
      // 02f: fconst_2
      // 030: fdiv
      // 031: fstore 5
      // 033: aload 1
      // 034: invokevirtual net/minecraft/entity/EntityLivingBase.getHealth ()F
      // 037: fconst_2
      // 038: fdiv
      // 039: fload 5
      // 03b: fadd
      // 03c: fstore 6
      // 03e: ldc_w 0.5
      // 041: aload 1
      // 042: invokevirtual net/minecraft/entity/EntityLivingBase.getMaxHealth ()F
      // 045: fconst_2
      // 046: fdiv
      // 047: invokestatic java/lang/Math.max (FF)F
      // 04a: fstore 7
      // 04c: invokestatic java/lang/System.currentTimeMillis ()J
      // 04f: lstore 8
      // 051: aload 0
      // 052: aload 1
      // 053: invokevirtual x/oc7ed5a3bedd.ϱ (Lnet/minecraft/entity/EntityLivingBase;)Lx/ocd941e94801;
      // 056: astore 10
      // 058: aload 10
      // 05a: fload 6
      // 05c: fload 7
      // 05e: aload 0
      // 05f: getfield x/oc7ed5a3bedd.Ț Lx/occ2f8dff8d8;
      // 062: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 065: lload 8
      // 067: invokevirtual x/ocd941e94801.խ (FFZJ)F
      // 06a: fstore 11
      // 06c: fconst_0
      // 06d: fconst_1
      // 06e: fload 6
      // 070: fload 7
      // 072: fdiv
      // 073: invokestatic java/lang/Math.min (FF)F
      // 076: invokestatic java/lang/Math.max (FF)F
      // 079: fstore 12
      // 07b: bipush 0
      // 07c: ldc_w 1871356934
      // 07f: ldc_w 1871357177
      // 082: ixor
      // 083: ldc_w 255.0
      // 086: fload 2
      // 087: fmul
      // 088: f2i
      // 089: invokestatic java/lang/Math.min (II)I
      // 08c: invokestatic java/lang/Math.max (II)I
      // 08f: istore 13
      // 091: aload 0
      // 092: aload 1
      // 093: iload 13
      // 095: invokevirtual x/oc7ed5a3bedd.Օ (Lnet/minecraft/entity/EntityLivingBase;I)Ljava/awt/Color;
      // 098: astore 14
      // 09a: aload 0
      // 09b: iload 3
      // 09c: ifne 0b2
      // 09f: getfield x/oc7ed5a3bedd.ŭ Lx/oca9cc61aada;
      // 0a2: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0a5: d2i
      // 0a6: ifne 0bc
      // 0a9: goto 0ad
      // 0ac: athrow
      // 0ad: aload 0
      // 0ae: goto 0b2
      // 0b1: athrow
      // 0b2: fload 11
      // 0b4: iload 13
      // 0b6: invokevirtual x/oc7ed5a3bedd.ѽ (FI)Ljava/awt/Color;
      // 0b9: goto 0be
      // 0bc: aload 14
      // 0be: astore 15
      // 0c0: fconst_0
      // 0c1: fconst_1
      // 0c2: fload 4
      // 0c4: fload 6
      // 0c6: fsub
      // 0c7: fconst_1
      // 0c8: fadd
      // 0c9: fconst_2
      // 0ca: fdiv
      // 0cb: invokestatic java/lang/Math.min (FF)F
      // 0ce: invokestatic java/lang/Math.max (FF)F
      // 0d1: fstore 16
      // 0d3: aload 0
      // 0d4: fload 16
      // 0d6: iload 13
      // 0d8: invokevirtual x/oc7ed5a3bedd.ѽ (FI)Ljava/awt/Color;
      // 0db: astore 17
      // 0dd: aload 0
      // 0de: aload 1
      // 0df: invokevirtual x/oc7ed5a3bedd.ƿ (Lnet/minecraft/entity/EntityLivingBase;)Lnet/minecraft/util/ResourceLocation;
      // 0e2: astore 18
      // 0e4: aload 0
      // 0e5: aload 1
      // 0e6: invokevirtual x/oc7ed5a3bedd.ɫ (Lnet/minecraft/entity/EntityLivingBase;)Ljava/lang/String;
      // 0e9: ldc_w "§r"
      // 0ec: swap
      // 0ed: ldc_w "§r"
      // 0f0: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001" ]
      // 0f5: astore 19
      // 0f7: getstatic java/util/Locale.ROOT Ljava/util/Locale;
      // 0fa: ldc_w "%.1f"
      // 0fd: bipush 1
      // 0fe: anewarray 412
      // 101: dup
      // 102: bipush 0
      // 103: fload 6
      // 105: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 108: aastore
      // 109: invokestatic java/lang/String.format (Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      // 10c: fload 5
      // 10e: fconst_0
      // 10f: fcmpl
      // 110: ifle 11a
      // 113: ldc_w "§6"
      // 116: goto 11d
      // 119: athrow
      // 11a: ldc_w "§c"
      // 11d: astore 47
      // 11f: astore 48
      // 121: ldc_w "§r§f"
      // 124: aload 48
      // 126: aload 47
      // 128: ldc_w "❤§r"
      // 12b: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001\u0001" ]
      // 130: astore 20
      // 132: fload 6
      // 134: fload 4
      // 136: fsub
      // 137: invokestatic java/lang/Math.abs (F)F
      // 13a: ldc_w 1.0E-4
      // 13d: fcmpg
      // 13e: iload 3
      // 13f: ifne 14a
      // 142: ifge 14d
      // 145: goto 149
      // 148: athrow
      // 149: bipush 1
      // 14a: goto 14e
      // 14d: bipush 0
      // 14e: istore 21
      // 150: iload 21
      // 152: iload 3
      // 153: ifne 169
      // 156: ifeq 164
      // 159: goto 15d
      // 15c: athrow
      // 15d: ldc_w "D"
      // 160: goto 176
      // 163: athrow
      // 164: fload 6
      // 166: fload 4
      // 168: fcmpg
      // 169: ifge 173
      // 16c: ldc_w "W"
      // 16f: goto 176
      // 172: athrow
      // 173: ldc_w "L"
      // 176: ldc_w "§r§l"
      // 179: swap
      // 17a: ldc_w "§r"
      // 17d: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001" ]
      // 182: astore 22
      // 184: iload 21
      // 186: ifeq 190
      // 189: ldc_w "0.0"
      // 18c: goto 1a8
      // 18f: athrow
      // 190: getstatic java/util/Locale.ROOT Ljava/util/Locale;
      // 193: ldc_w "%+.1f"
      // 196: bipush 1
      // 197: anewarray 412
      // 19a: dup
      // 19b: bipush 0
      // 19c: fload 4
      // 19e: fload 6
      // 1a0: fsub
      // 1a1: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 1a4: aastore
      // 1a5: invokestatic java/lang/String.format (Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      // 1a8: ldc_w "§r"
      // 1ab: swap
      // 1ac: ldc_w "§r"
      // 1af: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001" ]
      // 1b4: astore 23
      // 1b6: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1b9: getfield net/minecraft/client/Minecraft.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // 1bc: aload 19
      // 1be: invokevirtual net/minecraft/client/gui/FontRenderer.getStringWidth (Ljava/lang/String;)I
      // 1c1: istore 24
      // 1c3: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1c6: getfield net/minecraft/client/Minecraft.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // 1c9: aload 20
      // 1cb: invokevirtual net/minecraft/client/gui/FontRenderer.getStringWidth (Ljava/lang/String;)I
      // 1ce: istore 25
      // 1d0: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1d3: getfield net/minecraft/client/Minecraft.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // 1d6: aload 22
      // 1d8: invokevirtual net/minecraft/client/gui/FontRenderer.getStringWidth (Ljava/lang/String;)I
      // 1db: istore 26
      // 1dd: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1e0: getfield net/minecraft/client/Minecraft.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // 1e3: aload 23
      // 1e5: invokevirtual net/minecraft/client/gui/FontRenderer.getStringWidth (Ljava/lang/String;)I
      // 1e8: istore 27
      // 1ea: aload 0
      // 1eb: getfield x/oc7ed5a3bedd.Զ Lx/occ2f8dff8d8;
      // 1ee: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 1f1: ifeq 1ff
      // 1f4: fconst_2
      // 1f5: iload 26
      // 1f7: i2f
      // 1f8: fadd
      // 1f9: fconst_2
      // 1fa: fadd
      // 1fb: goto 200
      // 1fe: athrow
      // 1ff: fconst_0
      // 200: fstore 28
      // 202: aload 0
      // 203: getfield x/oc7ed5a3bedd.Զ Lx/occ2f8dff8d8;
      // 206: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 209: ifeq 217
      // 20c: fconst_2
      // 20d: iload 27
      // 20f: i2f
      // 210: fadd
      // 211: fconst_2
      // 212: fadd
      // 213: goto 218
      // 216: athrow
      // 217: fconst_0
      // 218: fstore 29
      // 21a: iload 24
      // 21c: i2f
      // 21d: fload 28
      // 21f: fadd
      // 220: iload 25
      // 222: i2f
      // 223: fload 29
      // 225: fadd
      // 226: invokestatic java/lang/Math.max (FF)F
      // 229: fstore 30
      // 22b: aload 0
      // 22c: getfield x/oc7ed5a3bedd.ƥ Lx/occ2f8dff8d8;
      // 22f: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 232: ifeq 245
      // 235: aload 18
      // 237: ifnull 245
      // 23a: goto 23e
      // 23d: athrow
      // 23e: ldc_w 25.0
      // 241: goto 246
      // 244: athrow
      // 245: fconst_0
      // 246: fstore 31
      // 248: fload 31
      // 24a: ldc_w 70.0
      // 24d: fadd
      // 24e: fload 31
      // 250: fconst_2
      // 251: fadd
      // 252: fload 30
      // 254: fadd
      // 255: fconst_2
      // 256: fadd
      // 257: invokestatic java/lang/Math.max (FF)F
      // 25a: fstore 32
      // 25c: aload 0
      // 25d: fload 32
      // 25f: invokevirtual x/oc7ed5a3bedd.Į (F)[F
      // 262: astore 33
      // 264: aload 33
      // 266: bipush 0
      // 267: faload
      // 268: fstore 34
      // 26a: aload 33
      // 26c: bipush 1
      // 26d: faload
      // 26e: fstore 35
      // 270: aload 0
      // 271: fload 34
      // 273: fload 35
      // 275: fload 32
      // 277: ldc_w 27.0
      // 27a: invokevirtual x/oc7ed5a3bedd.ù (FFFF)V
      // 27d: bipush 0
      // 27e: ldc_w 1871356934
      // 281: ldc_w 1871357177
      // 284: ixor
      // 285: ldc2_w 255.0
      // 288: aload 0
      // 289: getfield x/oc7ed5a3bedd.ĩ Lx/oca9cc61aada;
      // 28c: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 28f: dmul
      // 290: ldc2_w 100.0
      // 293: ddiv
      // 294: fload 2
      // 295: f2d
      // 296: dmul
      // 297: d2i
      // 298: invokestatic java/lang/Math.min (II)I
      // 29b: invokestatic java/lang/Math.max (II)I
      // 29e: istore 36
      // 2a0: getstatic java/awt/Color.BLACK Ljava/awt/Color;
      // 2a3: invokevirtual java/awt/Color.getRGB ()I
      // 2a6: iload 36
      // 2a8: invokestatic x/oc7ab2161b9f.Ҭ (II)I
      // 2ab: istore 37
      // 2ad: aload 0
      // 2ae: getfield x/oc7ed5a3bedd.Ϊ Lx/occ2f8dff8d8;
      // 2b1: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 2b4: iload 3
      // 2b5: ifne 2c8
      // 2b8: ifeq 2cb
      // 2bb: goto 2bf
      // 2be: athrow
      // 2bf: aload 14
      // 2c1: invokevirtual java/awt/Color.getRGB ()I
      // 2c4: goto 2c8
      // 2c7: athrow
      // 2c8: goto 2cc
      // 2cb: bipush 0
      // 2cc: istore 38
      // 2ce: iload 3
      // 2cf: aload 0
      // 2d0: fload 34
      // 2d2: fload 35
      // 2d4: fload 34
      // 2d6: fload 32
      // 2d8: fadd
      // 2d9: fload 35
      // 2db: ldc_w 27.0
      // 2de: fadd
      // 2df: ldc_w 1.5
      // 2e2: iload 37
      // 2e4: iload 38
      // 2e6: invokevirtual x/oc7ed5a3bedd.ϙ (FFFFFII)V
      // 2e9: fload 34
      // 2eb: fload 31
      // 2ed: fadd
      // 2ee: fconst_2
      // 2ef: fadd
      // 2f0: fstore 39
      // 2f2: fload 34
      // 2f4: fload 32
      // 2f6: fadd
      // 2f7: fconst_2
      // 2f8: fsub
      // 2f9: fstore 40
      // 2fb: fload 35
      // 2fd: ldc_w 22.0
      // 300: fadd
      // 301: fstore 41
      // 303: fload 35
      // 305: ldc_w 25.0
      // 308: fadd
      // 309: fstore 42
      // 30b: fload 39
      // 30d: f2d
      // 30e: fload 41
      // 310: f2d
      // 311: fload 40
      // 313: f2d
      // 314: fload 42
      // 316: f2d
      // 317: aload 0
      // 318: aload 15
      // 31a: ldc_w 0.2
      // 31d: iload 13
      // 31f: invokevirtual x/oc7ed5a3bedd.ѱ (Ljava/awt/Color;FI)Ljava/awt/Color;
      // 322: invokevirtual java/awt/Color.getRGB ()I
      // 325: invokestatic x/ocbd4917c4b1.ĉ (DDDDI)V
      // 328: aload 0
      // 329: aload 1
      // 32a: invokevirtual x/oc7ed5a3bedd.ī (Lnet/minecraft/entity/EntityLivingBase;)Lx/occcc6917ff6;
      // 32d: astore 43
      // 32f: ifne 34d
      // 332: aload 0
      // 333: getfield x/oc7ed5a3bedd.Ț Lx/occ2f8dff8d8;
      // 336: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 339: ifeq 351
      // 33c: goto 340
      // 33f: athrow
      // 340: aload 43
      // 342: fload 12
      // 344: lload 8
      // 346: invokevirtual x/occcc6917ff6.ƀ (FJ)V
      // 349: goto 34d
      // 34c: athrow
      // 34d: iload 3
      // 34e: ifeq 35c
      // 351: aload 43
      // 353: fload 12
      // 355: invokevirtual x/occcc6917ff6.ϵ (F)V
      // 358: goto 35c
      // 35b: athrow
      // 35c: fload 40
      // 35e: fload 39
      // 360: fsub
      // 361: fstore 44
      // 363: fload 44
      // 365: aload 43
      // 367: invokevirtual x/occcc6917ff6.y ()F
      // 36a: fmul
      // 36b: fstore 45
      // 36d: fload 45
      // 36f: fconst_0
      // 370: iload 3
      // 371: ifne 3a7
      // 374: fcmpl
      // 375: ifle 3a4
      // 378: goto 37c
      // 37b: athrow
      // 37c: fload 39
      // 37e: f2d
      // 37f: fload 41
      // 381: f2d
      // 382: fload 39
      // 384: fload 45
      // 386: fadd
      // 387: f2d
      // 388: fload 42
      // 38a: f2d
      // 38b: aload 0
      // 38c: aload 15
      // 38e: invokevirtual java/awt/Color.getRGB ()I
      // 391: ldc_w 95.0
      // 394: fload 2
      // 395: fmul
      // 396: f2i
      // 397: invokevirtual x/oc7ed5a3bedd.ʱ (II)Ljava/awt/Color;
      // 39a: invokevirtual java/awt/Color.getRGB ()I
      // 39d: invokestatic x/ocbd4917c4b1.ĉ (DDDDI)V
      // 3a0: goto 3a4
      // 3a3: athrow
      // 3a4: fload 11
      // 3a6: fconst_0
      // 3a7: fcmpl
      // 3a8: iload 3
      // 3a9: ifne 3dc
      // 3ac: ifle 3d1
      // 3af: goto 3b3
      // 3b2: athrow
      // 3b3: fload 39
      // 3b5: f2d
      // 3b6: fload 41
      // 3b8: f2d
      // 3b9: fload 39
      // 3bb: fload 11
      // 3bd: fload 44
      // 3bf: fmul
      // 3c0: fadd
      // 3c1: f2d
      // 3c2: fload 42
      // 3c4: f2d
      // 3c5: aload 15
      // 3c7: invokevirtual java/awt/Color.getRGB ()I
      // 3ca: invokestatic x/ocbd4917c4b1.ĉ (DDDDI)V
      // 3cd: goto 3d1
      // 3d0: athrow
      // 3d1: getstatic java/awt/Color.WHITE Ljava/awt/Color;
      // 3d4: invokevirtual java/awt/Color.getRGB ()I
      // 3d7: iload 13
      // 3d9: invokestatic x/oc7ab2161b9f.Ҭ (II)I
      // 3dc: istore 46
      // 3de: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 3e1: getfield net/minecraft/client/Minecraft.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // 3e4: aload 19
      // 3e6: fload 34
      // 3e8: fload 31
      // 3ea: fadd
      // 3eb: fconst_2
      // 3ec: fadd
      // 3ed: fload 35
      // 3ef: fconst_2
      // 3f0: fadd
      // 3f1: iload 46
      // 3f3: aload 0
      // 3f4: getfield x/oc7ed5a3bedd.Ͽ Lx/occ2f8dff8d8;
      // 3f7: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 3fa: invokevirtual net/minecraft/client/gui/FontRenderer.drawString (Ljava/lang/String;FFIZ)I
      // 3fd: pop
      // 3fe: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 401: getfield net/minecraft/client/Minecraft.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // 404: aload 20
      // 406: fload 34
      // 408: fload 31
      // 40a: fadd
      // 40b: fconst_2
      // 40c: fadd
      // 40d: fload 35
      // 40f: ldc_w 12.0
      // 412: fadd
      // 413: iload 46
      // 415: aload 0
      // 416: getfield x/oc7ed5a3bedd.Ͽ Lx/occ2f8dff8d8;
      // 419: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 41c: invokevirtual net/minecraft/client/gui/FontRenderer.drawString (Ljava/lang/String;FFIZ)I
      // 41f: iload 3
      // 420: ifne 496
      // 423: pop
      // 424: aload 0
      // 425: getfield x/oc7ed5a3bedd.Զ Lx/occ2f8dff8d8;
      // 428: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 42b: ifeq 48f
      // 42e: goto 432
      // 431: athrow
      // 432: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 435: getfield net/minecraft/client/Minecraft.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // 438: aload 22
      // 43a: fload 34
      // 43c: fload 32
      // 43e: fadd
      // 43f: fconst_2
      // 440: fsub
      // 441: iload 26
      // 443: i2f
      // 444: fsub
      // 445: fload 35
      // 447: fconst_2
      // 448: fadd
      // 449: aload 17
      // 44b: invokevirtual java/awt/Color.getRGB ()I
      // 44e: aload 0
      // 44f: getfield x/oc7ed5a3bedd.Ͽ Lx/occ2f8dff8d8;
      // 452: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 455: invokevirtual net/minecraft/client/gui/FontRenderer.drawString (Ljava/lang/String;FFIZ)I
      // 458: pop
      // 459: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 45c: getfield net/minecraft/client/Minecraft.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // 45f: aload 23
      // 461: fload 34
      // 463: fload 32
      // 465: fadd
      // 466: fconst_2
      // 467: fsub
      // 468: iload 27
      // 46a: i2f
      // 46b: fsub
      // 46c: fload 35
      // 46e: ldc_w 12.0
      // 471: fadd
      // 472: aload 0
      // 473: aload 17
      // 475: ldc_w 0.8
      // 478: iload 13
      // 47a: invokevirtual x/oc7ed5a3bedd.ѱ (Ljava/awt/Color;FI)Ljava/awt/Color;
      // 47d: invokevirtual java/awt/Color.getRGB ()I
      // 480: aload 0
      // 481: getfield x/oc7ed5a3bedd.Ͽ Lx/occ2f8dff8d8;
      // 484: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 487: invokevirtual net/minecraft/client/gui/FontRenderer.drawString (Ljava/lang/String;FFIZ)I
      // 48a: pop
      // 48b: goto 48f
      // 48e: athrow
      // 48f: aload 0
      // 490: getfield x/oc7ed5a3bedd.ƥ Lx/occ2f8dff8d8;
      // 493: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 496: ifeq 4b5
      // 499: aload 18
      // 49b: ifnull 4b5
      // 49e: goto 4a2
      // 4a1: athrow
      // 4a2: aload 0
      // 4a3: aload 18
      // 4a5: fload 34
      // 4a7: fconst_2
      // 4a8: fadd
      // 4a9: fload 35
      // 4ab: fconst_2
      // 4ac: fadd
      // 4ad: fload 2
      // 4ae: invokevirtual x/oc7ed5a3bedd.Я (Lnet/minecraft/util/ResourceLocation;FFF)V
      // 4b1: goto 4b5
      // 4b4: athrow
      // 4b5: return
   }

   private ocd941e94801 ϱ(EntityLivingBase var1) {
      boolean var10000 = oce6044968f8.ђ;
      ocd941e94801 var3 = this.բ.get(var1);
      boolean var2 = var10000;

      try {
         if (var2) {
            return var3;
         }

         if (var3 != null) {
            return var3;
         }
      } catch (ocbde1165e4e var4) {
         throw var4;
      }

      var3 = new ocd941e94801();
      this.բ.put(var1, var3);
      return var3;
   }

   private ResourceLocation ƿ(EntityLivingBase param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: aload 0
      // 04: getfield x/oc7ed5a3bedd.ҷ Ljava/util/Map;
      // 07: aload 1
      // 08: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 0d: checkcast net/minecraft/util/ResourceLocation
      // 10: astore 3
      // 11: istore 2
      // 12: aload 1
      // 13: instanceof net/minecraft/entity/player/EntityPlayer
      // 16: ifeq 60
      // 19: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1c: iload 2
      // 1d: ifne 35
      // 20: goto 24
      // 23: athrow
      // 24: invokevirtual net/minecraft/client/Minecraft.getNetHandler ()Lnet/minecraft/client/network/NetHandlerPlayClient;
      // 27: ifnull 60
      // 2a: goto 2e
      // 2d: athrow
      // 2e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 31: goto 35
      // 34: athrow
      // 35: invokevirtual net/minecraft/client/Minecraft.getNetHandler ()Lnet/minecraft/client/network/NetHandlerPlayClient;
      // 38: aload 1
      // 39: invokevirtual net/minecraft/entity/EntityLivingBase.getName ()Ljava/lang/String;
      // 3c: invokevirtual net/minecraft/client/network/NetHandlerPlayClient.getPlayerInfo (Ljava/lang/String;)Lnet/minecraft/client/network/NetworkPlayerInfo;
      // 3f: astore 4
      // 41: iload 2
      // 42: ifne 54
      // 45: aload 4
      // 47: ifnull 60
      // 4a: goto 4e
      // 4d: athrow
      // 4e: aload 4
      // 50: invokevirtual net/minecraft/client/network/NetworkPlayerInfo.getLocationSkin ()Lnet/minecraft/util/ResourceLocation;
      // 53: astore 3
      // 54: aload 0
      // 55: getfield x/oc7ed5a3bedd.ҷ Ljava/util/Map;
      // 58: aload 1
      // 59: aload 3
      // 5a: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 5f: pop
      // 60: aload 3
      // 61: areturn
   }

   private Color Օ(EntityLivingBase param1, int param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 3
      // 04: aload 1
      // 05: instanceof net/minecraft/entity/player/EntityPlayer
      // 08: iload 3
      // 09: ifne 6f
      // 0c: ifeq 5f
      // 0f: goto 13
      // 12: athrow
      // 13: aload 1
      // 14: checkcast net/minecraft/entity/player/EntityPlayer
      // 17: astore 4
      // 19: aload 4
      // 1b: iload 3
      // 1c: ifne 3e
      // 1f: invokestatic x/oc7ab2161b9f.Ӭ (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // 22: ifeq 3c
      // 25: goto 29
      // 28: athrow
      // 29: new java/awt/Color
      // 2c: dup
      // 2d: bipush 0
      // 2e: ldc_w 629191680
      // 31: ldc_w 629191850
      // 34: ixor
      // 35: bipush 0
      // 36: iload 2
      // 37: invokespecial java/awt/Color.<init> (IIII)V
      // 3a: areturn
      // 3b: athrow
      // 3c: aload 4
      // 3e: invokestatic x/oc7ab2161b9f.Š (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // 41: iload 3
      // 42: ifne 6f
      // 45: ifeq 5f
      // 48: goto 4c
      // 4b: athrow
      // 4c: new java/awt/Color
      // 4f: dup
      // 50: ldc_w 629191680
      // 53: ldc_w 629191850
      // 56: ixor
      // 57: bipush 0
      // 58: bipush 0
      // 59: iload 2
      // 5a: invokespecial java/awt/Color.<init> (IIII)V
      // 5d: areturn
      // 5e: athrow
      // 5f: aload 0
      // 60: iload 3
      // 61: ifne 92
      // 64: getfield x/oc7ed5a3bedd.ŭ Lx/oca9cc61aada;
      // 67: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 6a: d2i
      // 6b: goto 6f
      // 6e: athrow
      // 6f: ifne 91
      // 72: fconst_0
      // 73: fconst_1
      // 74: aload 1
      // 75: invokevirtual net/minecraft/entity/EntityLivingBase.getHealth ()F
      // 78: fconst_1
      // 79: aload 1
      // 7a: invokevirtual net/minecraft/entity/EntityLivingBase.getMaxHealth ()F
      // 7d: invokestatic java/lang/Math.max (FF)F
      // 80: fdiv
      // 81: invokestatic java/lang/Math.min (FF)F
      // 84: invokestatic java/lang/Math.max (FF)F
      // 87: fstore 4
      // 89: aload 0
      // 8a: fload 4
      // 8c: iload 2
      // 8d: invokevirtual x/oc7ed5a3bedd.ѽ (FI)Ljava/awt/Color;
      // 90: areturn
      // 91: aload 0
      // 92: dconst_0
      // 93: invokestatic x/ocd2958dac48.ů (D)I
      // 96: iload 2
      // 97: invokevirtual x/oc7ed5a3bedd.ʱ (II)Ljava/awt/Color;
      // 9a: areturn
   }

   private String ɫ(EntityLivingBase param1) {
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
      // 06: ifne 19
      // 09: invokevirtual net/minecraft/entity/EntityLivingBase.getDisplayName ()Lnet/minecraft/util/IChatComponent;
      // 0c: ifnonnull 18
      // 0f: goto 13
      // 12: athrow
      // 13: ldc_w ""
      // 16: areturn
      // 17: athrow
      // 18: aload 1
      // 19: invokevirtual net/minecraft/entity/EntityLivingBase.getDisplayName ()Lnet/minecraft/util/IChatComponent;
      // 1c: invokeinterface net/minecraft/util/IChatComponent.getFormattedText ()Ljava/lang/String; 1
      // 21: ldc_w "\\u00A7\\S$"
      // 24: ldc_w ""
      // 27: invokevirtual java/lang/String.replaceAll (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 2a: ldc_w "(?i)\\u00A7r"
      // 2d: ldc_w "§f"
      // 30: invokevirtual java/lang/String.replaceAll (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 33: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 36: areturn
   }

   private void Я(ResourceLocation var1, float var2, float var3, float var4) {
      GlStateManager.enableBlend();
      GlStateManager.enableTexture2D();
      oc69da1aa7f5.ő.getTextureManager().bindTexture(var1);
      GlStateManager.color(1.0F, 1.0F, 1.0F, Math.max(0.0F, Math.min(1.0F, var4)));
      Gui.drawScaledCustomSizeModalRect(
         (int)var2, (int)var3, 8.0F, 8.0F, 295744525 ^ 295744517, 295744525 ^ 295744517, 295744530 ^ 295744517, 295744530 ^ 295744517, 64.0F, 64.0F
      );
      Gui.drawScaledCustomSizeModalRect(
         (int)var2, (int)var3, 40.0F, 8.0F, 295744525 ^ 295744517, 295744525 ^ 295744517, 295744530 ^ 295744517, 295744530 ^ 295744517, 64.0F, 64.0F
      );
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.disableBlend();
   }

   private void ϙ(float param1, float param2, float param3, float param4, float param5, int param6, int param7) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: fload 1
      // 04: f2d
      // 05: fload 2
      // 06: f2d
      // 07: fload 3
      // 08: f2d
      // 09: fload 4
      // 0b: f2d
      // 0c: iload 6
      // 0e: invokestatic x/ocbd4917c4b1.ĉ (DDDDI)V
      // 11: istore 8
      // 13: iload 7
      // 15: iload 8
      // 17: ifne cc
      // 1a: ldc_w 2093431484
      // 1d: ldc_w 2093431460
      // 20: ixor
      // 21: iushr
      // 22: ifne 2b
      // 25: goto 29
      // 28: athrow
      // 29: return
      // 2a: athrow
      // 2b: invokestatic net/minecraft/client/renderer/GlStateManager.enableBlend ()V
      // 2e: invokestatic net/minecraft/client/renderer/GlStateManager.disableTexture2D ()V
      // 31: ldc_w 2093431206
      // 34: ldc_w 2093431460
      // 37: ixor
      // 38: ldc_w 2093431207
      // 3b: ldc_w 2093431460
      // 3e: ixor
      // 3f: bipush 1
      // 40: bipush 0
      // 41: invokestatic net/minecraft/client/renderer/GlStateManager.tryBlendFuncSeparate (IIII)V
      // 44: iload 7
      // 46: ldc_w 2093431476
      // 49: ldc_w 2093431460
      // 4c: ixor
      // 4d: ishr
      // 4e: ldc_w 2093431387
      // 51: ldc_w 2093431460
      // 54: ixor
      // 55: iand
      // 56: i2f
      // 57: ldc_w 255.0
      // 5a: fdiv
      // 5b: iload 7
      // 5d: ldc_w 2093431468
      // 60: ldc_w 2093431460
      // 63: ixor
      // 64: ishr
      // 65: ldc_w 2093431387
      // 68: ldc_w 2093431460
      // 6b: ixor
      // 6c: iand
      // 6d: i2f
      // 6e: ldc_w 255.0
      // 71: fdiv
      // 72: iload 7
      // 74: ldc_w 2093431387
      // 77: ldc_w 2093431460
      // 7a: ixor
      // 7b: iand
      // 7c: i2f
      // 7d: ldc_w 255.0
      // 80: fdiv
      // 81: iload 7
      // 83: ldc_w 2093431484
      // 86: ldc_w 2093431460
      // 89: ixor
      // 8a: iushr
      // 8b: i2f
      // 8c: ldc_w 255.0
      // 8f: fdiv
      // 90: invokestatic org/lwjgl/opengl/GL11.glColor4f (FFFF)V
      // 93: fload 5
      // 95: invokestatic org/lwjgl/opengl/GL11.glLineWidth (F)V
      // 98: ldc_w 2093429124
      // 9b: ldc_w 2093431460
      // 9e: ixor
      // 9f: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // a2: ldc_w 2093431462
      // a5: ldc_w 2093431460
      // a8: ixor
      // a9: invokestatic org/lwjgl/opengl/GL11.glBegin (I)V
      // ac: fload 1
      // ad: fload 2
      // ae: invokestatic org/lwjgl/opengl/GL11.glVertex2f (FF)V
      // b1: fload 1
      // b2: fload 4
      // b4: invokestatic org/lwjgl/opengl/GL11.glVertex2f (FF)V
      // b7: fload 3
      // b8: fload 4
      // ba: invokestatic org/lwjgl/opengl/GL11.glVertex2f (FF)V
      // bd: fload 3
      // be: fload 2
      // bf: invokestatic org/lwjgl/opengl/GL11.glVertex2f (FF)V
      // c2: invokestatic org/lwjgl/opengl/GL11.glEnd ()V
      // c5: ldc_w 2093429124
      // c8: ldc_w 2093431460
      // cb: ixor
      // cc: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // cf: fconst_1
      // d0: invokestatic org/lwjgl/opengl/GL11.glLineWidth (F)V
      // d3: invokestatic net/minecraft/client/renderer/GlStateManager.enableTexture2D ()V
      // d6: invokestatic net/minecraft/client/renderer/GlStateManager.disableBlend ()V
      // d9: fconst_1
      // da: fconst_1
      // db: fconst_1
      // dc: fconst_1
      // dd: invokestatic net/minecraft/client/renderer/GlStateManager.color (FFFF)V
      // e0: return
   }

   private Color ѽ(float param1, int param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: fconst_0
      // 04: fconst_1
      // 05: fload 1
      // 06: invokestatic java/lang/Math.min (FF)F
      // 09: invokestatic java/lang/Math.max (FF)F
      // 0c: fstore 4
      // 0e: istore 3
      // 0f: fload 4
      // 11: iload 3
      // 12: ifne 2f
      // 15: ldc_w 0.9
      // 18: fcmpl
      // 19: iflt 29
      // 1c: goto 20
      // 1f: athrow
      // 20: getstatic java/awt/Color.GREEN Ljava/awt/Color;
      // 23: astore 5
      // 25: iload 3
      // 26: ifeq a2
      // 29: fload 4
      // 2b: goto 2f
      // 2e: athrow
      // 2f: ldc_w 0.55
      // 32: iload 3
      // 33: ifne 69
      // 36: fcmpl
      // 37: iflt 58
      // 3a: goto 3e
      // 3d: athrow
      // 3e: aload 0
      // 3f: getstatic java/awt/Color.YELLOW Ljava/awt/Color;
      // 42: getstatic java/awt/Color.GREEN Ljava/awt/Color;
      // 45: fload 4
      // 47: ldc_w 0.55
      // 4a: fsub
      // 4b: ldc_w 0.35
      // 4e: fdiv
      // 4f: invokevirtual x/oc7ed5a3bedd.Ɋ (Ljava/awt/Color;Ljava/awt/Color;F)Ljava/awt/Color;
      // 52: astore 5
      // 54: iload 3
      // 55: ifeq a2
      // 58: fload 4
      // 5a: iload 3
      // 5b: ifne 7c
      // 5e: goto 62
      // 61: athrow
      // 62: ldc_w 0.45
      // 65: goto 69
      // 68: athrow
      // 69: fcmpl
      // 6a: iflt 76
      // 6d: getstatic java/awt/Color.YELLOW Ljava/awt/Color;
      // 70: astore 5
      // 72: iload 3
      // 73: ifeq a2
      // 76: fload 4
      // 78: goto 7c
      // 7b: athrow
      // 7c: ldc_w 0.1
      // 7f: fcmpl
      // 80: iflt 9d
      // 83: aload 0
      // 84: getstatic java/awt/Color.RED Ljava/awt/Color;
      // 87: getstatic java/awt/Color.YELLOW Ljava/awt/Color;
      // 8a: fload 4
      // 8c: ldc_w 0.1
      // 8f: fsub
      // 90: ldc_w 0.35
      // 93: fdiv
      // 94: invokevirtual x/oc7ed5a3bedd.Ɋ (Ljava/awt/Color;Ljava/awt/Color;F)Ljava/awt/Color;
      // 97: astore 5
      // 99: iload 3
      // 9a: ifeq a2
      // 9d: getstatic java/awt/Color.RED Ljava/awt/Color;
      // a0: astore 5
      // a2: aload 0
      // a3: aload 5
      // a5: invokevirtual java/awt/Color.getRGB ()I
      // a8: iload 2
      // a9: invokevirtual x/oc7ed5a3bedd.ʱ (II)Ljava/awt/Color;
      // ac: areturn
   }

   private Color Ɋ(Color var1, Color var2, float var3) {
      float var4 = Math.max(0.0F, Math.min(1.0F, var3));
      return new Color(
         (int)(var1.getRed() + var4 * (var2.getRed() - var1.getRed())),
         (int)(var1.getGreen() + var4 * (var2.getGreen() - var1.getGreen())),
         (int)(var1.getBlue() + var4 * (var2.getBlue() - var1.getBlue()))
      );
   }

   private Color ѱ(Color var1, float var2, int var3) {
      float var4 = Math.max(0.0F, Math.min(1.0F, var2));
      return new Color(
         (int)(var1.getRed() * var4), (int)(var1.getGreen() * var4), (int)(var1.getBlue() * var4), Math.max(0, Math.min(-1706558102 ^ -1706558059, var3))
      );
   }

   private void ԡ(float param1) {
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
      // 05: fconst_0
      // 06: fcmpg
      // 07: ifgt 0c
      // 0a: return
      // 0b: athrow
      // 0c: aload 0
      // 0d: invokevirtual x/oc7ed5a3bedd.ĥ ()Ljava/util/List;
      // 10: astore 3
      // 11: aload 3
      // 12: iload 2
      // 13: ifne 25
      // 16: invokeinterface java/util/List.isEmpty ()Z 1
      // 1b: ifeq 24
      // 1e: goto 22
      // 21: athrow
      // 22: return
      // 23: athrow
      // 24: aload 3
      // 25: invokeinterface java/util/List.size ()I 1
      // 2a: bipush 1
      // 2b: if_icmpne 3f
      // 2e: aload 0
      // 2f: aload 3
      // 30: bipush 0
      // 31: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 36: checkcast net/minecraft/entity/EntityLivingBase
      // 39: fload 1
      // 3a: invokevirtual x/oc7ed5a3bedd.Ī (Lnet/minecraft/entity/EntityLivingBase;F)V
      // 3d: return
      // 3e: athrow
      // 3f: aload 0
      // 40: aload 3
      // 41: fload 1
      // 42: invokevirtual x/oc7ed5a3bedd.ђ (Ljava/util/List;F)V
      // 45: return
   }

   private List<EntityLivingBase> ĥ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: new java/util/ArrayList
      // 006: dup
      // 007: invokespecial java/util/ArrayList.<init> ()V
      // 00a: astore 2
      // 00b: istore 1
      // 00c: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 00f: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 012: instanceof net/minecraft/client/gui/GuiChat
      // 015: iload 1
      // 016: ifne 04b
      // 019: ifeq 03c
      // 01c: goto 020
      // 01f: athrow
      // 020: aload 0
      // 021: getfield x/oc7ed5a3bedd.ɋ Lnet/minecraft/entity/EntityLivingBase;
      // 024: ifnull 03a
      // 027: goto 02b
      // 02a: athrow
      // 02b: aload 2
      // 02c: aload 0
      // 02d: getfield x/oc7ed5a3bedd.ɋ Lnet/minecraft/entity/EntityLivingBase;
      // 030: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 035: pop
      // 036: goto 03a
      // 039: athrow
      // 03a: aload 2
      // 03b: areturn
      // 03c: aload 0
      // 03d: iload 1
      // 03e: ifne 113
      // 041: getfield x/oc7ed5a3bedd.ʴ Lx/occ2f8dff8d8;
      // 044: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 047: goto 04b
      // 04a: athrow
      // 04b: ifeq 10e
      // 04e: aload 0
      // 04f: iload 1
      // 050: ifne 079
      // 053: goto 057
      // 056: athrow
      // 057: getfield x/oc7ed5a3bedd.ɋ Lnet/minecraft/entity/EntityLivingBase;
      // 05a: invokestatic x/oc7ed5a3bedd.ľ (Lnet/minecraft/entity/EntityLivingBase;)Z
      // 05d: ifeq 073
      // 060: goto 064
      // 063: athrow
      // 064: aload 2
      // 065: aload 0
      // 066: getfield x/oc7ed5a3bedd.ɋ Lnet/minecraft/entity/EntityLivingBase;
      // 069: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 06e: pop
      // 06f: goto 073
      // 072: athrow
      // 073: ldc_w x/ocdd342096f8
      // 076: invokestatic x/oc9755810e45.ʬ (Ljava/lang/Class;)Lx/oc69da1aa7f5;
      // 079: checkcast x/ocdd342096f8
      // 07c: astore 3
      // 07d: aload 3
      // 07e: iload 1
      // 07f: ifne 08a
      // 082: ifnull 10a
      // 085: goto 089
      // 088: athrow
      // 089: aload 3
      // 08a: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 08d: ifeq 10a
      // 090: getstatic x/ocdd342096f8.Ց Ljava/util/List;
      // 093: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 098: astore 4
      // 09a: aload 4
      // 09c: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0a1: ifeq 10a
      // 0a4: aload 4
      // 0a6: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0ab: checkcast net/minecraft/entity/EntityLivingBase
      // 0ae: astore 5
      // 0b0: iload 1
      // 0b1: ifne 133
      // 0b4: aload 2
      // 0b5: invokeinterface java/util/List.size ()I 1
      // 0ba: ldc_w 493140531
      // 0bd: ldc_w 493140535
      // 0c0: ixor
      // 0c1: if_icmplt 0d0
      // 0c4: goto 0c8
      // 0c7: athrow
      // 0c8: iload 1
      // 0c9: ifeq 10a
      // 0cc: goto 0d0
      // 0cf: athrow
      // 0d0: aload 5
      // 0d2: iload 1
      // 0d3: ifne 0e7
      // 0d6: goto 0da
      // 0d9: athrow
      // 0da: aload 0
      // 0db: getfield x/oc7ed5a3bedd.ɋ Lnet/minecraft/entity/EntityLivingBase;
      // 0de: if_acmpeq 09a
      // 0e1: goto 0e5
      // 0e4: athrow
      // 0e5: aload 5
      // 0e7: invokestatic x/oc7ed5a3bedd.ľ (Lnet/minecraft/entity/EntityLivingBase;)Z
      // 0ea: iload 1
      // 0eb: ifne 105
      // 0ee: ifne 0fd
      // 0f1: goto 0f5
      // 0f4: athrow
      // 0f5: iload 1
      // 0f6: ifeq 09a
      // 0f9: goto 0fd
      // 0fc: athrow
      // 0fd: aload 2
      // 0fe: aload 5
      // 100: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 105: pop
      // 106: iload 1
      // 107: ifeq 09a
      // 10a: iload 1
      // 10b: ifeq 133
      // 10e: aload 0
      // 10f: goto 113
      // 112: athrow
      // 113: getfield x/oc7ed5a3bedd.ɋ Lnet/minecraft/entity/EntityLivingBase;
      // 116: invokestatic x/oc7ed5a3bedd.ľ (Lnet/minecraft/entity/EntityLivingBase;)Z
      // 119: iload 1
      // 11a: ifne 132
      // 11d: ifeq 133
      // 120: goto 124
      // 123: athrow
      // 124: aload 2
      // 125: aload 0
      // 126: getfield x/oc7ed5a3bedd.ɋ Lnet/minecraft/entity/EntityLivingBase;
      // 129: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 12e: goto 132
      // 131: athrow
      // 132: pop
      // 133: aload 2
      // 134: areturn
   }

   private static boolean ľ(EntityLivingBase param0) {
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
      // 05: iload 1
      // 06: ifne 11
      // 09: ifnull 38
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 0
      // 11: iload 1
      // 12: ifne 24
      // 15: getfield net/minecraft/entity/EntityLivingBase.isDead Z
      // 18: ifne 38
      // 1b: goto 1f
      // 1e: athrow
      // 1f: aload 0
      // 20: goto 24
      // 23: athrow
      // 24: invokevirtual net/minecraft/entity/EntityLivingBase.getHealth ()F
      // 27: fconst_0
      // 28: fcmpl
      // 29: iload 1
      // 2a: ifne 35
      // 2d: ifle 38
      // 30: goto 34
      // 33: athrow
      // 34: bipush 1
      // 35: goto 39
      // 38: bipush 0
      // 39: ireturn
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private void ђ(List<EntityLivingBase> var1, float var2) {
      oc1378bc114d var4 = this.ʍ(true, -1914329862 ^ -1914329888);
      boolean var10000 = oce6044968f8.ђ;
      float var5 = 145.0F;
      Iterator var6 = var1.iterator();
      boolean var3 = var10000;

      while (true) {
         if (var6.hasNext()) {
            EntityLivingBase var7 = (EntityLivingBase)var6.next();
            var36 = var5;
            if (var3) {
               break;
            }

            var5 = Math.max(var5, var4.z$toz8pt08w0nc(var7.getName()) + 40.0F);
            if (!var3) {
               continue;
            }
         }

         var36 = 37.0F;
         break;
      }

      float var28 = var36;
      int var29 = Math.min(var1.size(), -1914329886 ^ -1914329888);
      int var8 = (var1.size() + var29 - 1) / var29;
      float var9 = var29 * var5 + (var29 - 1) * 6.0F;
      float var10 = var8 * var28 + (var8 - 1) * 6.0F;
      float[] var11 = this.Į(var9);
      this.ù(var11[0], var11[1], var9, var10);
      ScaledResolution var12 = new ScaledResolution(oc69da1aa7f5.ő);
      float var13 = Υ(var1.size());
      float var14 = var12.getScaledWidth() * 0.5F;
      float var15 = var12.getScaledHeight() * 0.35F;
      var13 = Math.min(var13, Math.min(var14 / var9, var15 / var10));
      var13 = Math.max(var13, 0.35F);
      float var16 = var11[0] + var9 / 2.0F;
      GlStateManager.pushMatrix();
      GlStateManager.translate(var16, var11[1], 0.0F);
      GlStateManager.scale(var13, var13, 1.0F);
      GlStateManager.translate(-var16, -var11[1], 0.0F);
      boolean var25 = false /* VF: Semaphore variable */;

      try {
         var25 = true;
         int var17 = 0;

         while (true) {
            if (var17 < var1.size()) {
               int var18 = var17 % var29;
               var10000 = var3;
               int var19 = var17 / var29;
               float var20 = var11[0] + var18 * (var5 + 6.0F);
               float var21 = var11[1] + var19 * (var28 + 6.0F);

               try {
                  this.Л((EntityLivingBase)var1.get(var17), var20, var21, var5, var2, this.ī((EntityLivingBase)var1.get(var17)));
                  if (var10000) {
                     var25 = false;
                     return;
                  }

                  var17++;
                  if (!var3) {
                     continue;
                  }

                  var25 = false;
                  break;
               } catch (ocbde1165e4e var26) {
                  throw var26;
               }
            }

            var25 = false;
            break;
         }
      } finally {
         if (var25) {
            GlStateManager.popMatrix();
         }
      }

      GlStateManager.popMatrix();
   }

   static float Υ(int param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 1
      // 04: iload 0
      // 05: iload 1
      // 06: ifne 15
      // 09: bipush 1
      // 0a: if_icmpgt 14
      // 0d: goto 11
      // 10: athrow
      // 11: fconst_1
      // 12: freturn
      // 13: athrow
      // 14: iload 0
      // 15: iload 1
      // 16: ifne 2d
      // 19: ldc_w -627211098
      // 1c: ldc_w -627211100
      // 1f: ixor
      // 20: if_icmpne 2c
      // 23: goto 27
      // 26: athrow
      // 27: ldc_w 0.9
      // 2a: freturn
      // 2b: athrow
      // 2c: iload 0
      // 2d: ldc_w -627211097
      // 30: ldc_w -627211100
      // 33: ixor
      // 34: if_icmpne 3c
      // 37: ldc_w 0.8
      // 3a: freturn
      // 3b: athrow
      // 3c: ldc_w 0.72
      // 3f: freturn
   }

   private occcc6917ff6 ī(EntityLivingBase var1) {
      boolean var10000 = oce6044968f8.ђ;
      occcc6917ff6 var3 = this.ɣ.get(var1);
      boolean var2 = var10000;

      try {
         if (var2) {
            return var3;
         }

         if (var3 != null) {
            return var3;
         }
      } catch (ocbde1165e4e var4) {
         throw var4;
      }

      var3 = new occcc6917ff6();
      this.ɣ.put(var1, var3);
      return var3;
   }

   private void Ī(EntityLivingBase var1, float var2) {
      oc1378bc114d var3 = this.ʍ(true, -1742340405 ^ -1742340399);
      float var4 = Math.max(145.0F, var3.z$toz8pt08w0nc(var1.getName()) + 40.0F);
      float[] var5 = this.Į(var4);
      this.ù(var5[0], var5[1], var4, 37.0F);
      this.Л(var1, var5[0], var5[1], var4, var2, this.ī(var1));
   }

   private void Л(EntityLivingBase param1, float param2, float param3, float param4, float param5, occcc6917ff6 param6) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: aload 0
      // 004: bipush 1
      // 005: ldc_w -1882711456
      // 008: ldc_w -1882711430
      // 00b: ixor
      // 00c: invokevirtual x/oc7ed5a3bedd.ʍ (ZI)Lx/oc1378bc114d;
      // 00f: astore 8
      // 011: aload 0
      // 012: bipush 1
      // 013: ldc_w -1882711462
      // 016: ldc_w -1882711430
      // 019: ixor
      // 01a: invokevirtual x/oc7ed5a3bedd.ʍ (ZI)Lx/oc1378bc114d;
      // 01d: astore 9
      // 01f: istore 7
      // 021: ldc_w 37.0
      // 024: fstore 10
      // 026: fload 5
      // 028: fconst_0
      // 029: fcmpg
      // 02a: ifgt 02f
      // 02d: return
      // 02e: athrow
      // 02f: aload 0
      // 030: ldc_w 255.0
      // 033: fload 5
      // 035: fmul
      // 036: f2i
      // 037: invokevirtual x/oc7ed5a3bedd.ľ (I)[Ljava/awt/Color;
      // 03a: astore 11
      // 03c: iload 7
      // 03e: aload 0
      // 03f: getstatic java/awt/Color.WHITE Ljava/awt/Color;
      // 042: invokevirtual java/awt/Color.getRGB ()I
      // 045: ldc_w 255.0
      // 048: fload 5
      // 04a: fmul
      // 04b: f2i
      // 04c: invokevirtual x/oc7ed5a3bedd.ʱ (II)Ljava/awt/Color;
      // 04f: invokevirtual java/awt/Color.getRGB ()I
      // 052: istore 12
      // 054: ifne 0b0
      // 057: fload 2
      // 058: fload 3
      // 059: fload 4
      // 05b: fload 10
      // 05d: ldc_w 4.0
      // 060: new java/awt/Color
      // 063: dup
      // 064: ldc_w -1882711442
      // 067: ldc_w -1882711430
      // 06a: ixor
      // 06b: ldc_w -1882711448
      // 06e: ldc_w -1882711430
      // 071: ixor
      // 072: ldc_w -1882711448
      // 075: ldc_w -1882711430
      // 078: ixor
      // 079: ldc_w 90.0
      // 07c: fload 5
      // 07e: fmul
      // 07f: f2i
      // 080: invokespecial java/awt/Color.<init> (IIII)V
      // 083: invokestatic x/W.s (FFFFFLjava/awt/Color;)V
      // 086: aload 1
      // 087: instanceof net/minecraft/client/entity/AbstractClientPlayer
      // 08a: ifeq 0b5
      // 08d: goto 091
      // 090: athrow
      // 091: aload 0
      // 092: aload 1
      // 093: fload 2
      // 094: ldc_w 3.0
      // 097: fadd
      // 098: fload 3
      // 099: ldc_w 3.0
      // 09c: fadd
      // 09d: ldc_w 31.0
      // 0a0: ldc_w 4.0
      // 0a3: fconst_1
      // 0a4: fload 5
      // 0a6: invokevirtual x/oc7ed5a3bedd.Г (Lnet/minecraft/entity/EntityLivingBase;FFFFFF)V
      // 0a9: invokestatic net/minecraft/client/renderer/GlStateManager.disableBlend ()V
      // 0ac: goto 0b0
      // 0af: athrow
      // 0b0: iload 7
      // 0b2: ifeq 0da
      // 0b5: aload 0
      // 0b6: aload 9
      // 0b8: ldc_w "?"
      // 0bb: fload 2
      // 0bc: ldc_w 20.0
      // 0bf: fadd
      // 0c0: fload 3
      // 0c1: ldc_w 17.0
      // 0c4: fadd
      // 0c5: aload 9
      // 0c7: invokeinterface x/oc1378bc114d.z$1tqmx4tpnr6lq ()I 1
      // 0cc: i2f
      // 0cd: fconst_2
      // 0ce: fdiv
      // 0cf: fsub
      // 0d0: iload 12
      // 0d2: bipush 1
      // 0d3: invokevirtual x/oc7ed5a3bedd.ӥ (Lx/oc1378bc114d;Ljava/lang/String;FFIZ)V
      // 0d6: goto 0da
      // 0d9: athrow
      // 0da: aload 8
      // 0dc: aload 1
      // 0dd: invokevirtual net/minecraft/entity/EntityLivingBase.getName ()Ljava/lang/String;
      // 0e0: fload 2
      // 0e1: ldc_w 39.0
      // 0e4: fadd
      // 0e5: fload 3
      // 0e6: ldc_w 5.0
      // 0e9: fadd
      // 0ea: iload 12
      // 0ec: invokeinterface x/oc1378bc114d.z$1vws8s1usg1n1 (Ljava/lang/String;FFI)I 5
      // 0f1: pop
      // 0f2: aload 0
      // 0f3: aload 1
      // 0f4: invokevirtual x/oc7ed5a3bedd.Ư (Lnet/minecraft/entity/EntityLivingBase;)F
      // 0f7: fstore 13
      // 0f9: fload 4
      // 0fb: ldc_w 44.0
      // 0fe: fsub
      // 0ff: fstore 14
      // 101: aload 6
      // 103: fload 13
      // 105: invokestatic java/lang/System.currentTimeMillis ()J
      // 108: invokevirtual x/occcc6917ff6.ƀ (FJ)V
      // 10b: fload 14
      // 10d: aload 6
      // 10f: invokevirtual x/occcc6917ff6.ɑ ()F
      // 112: fmul
      // 113: fstore 15
      // 115: fload 14
      // 117: aload 6
      // 119: invokevirtual x/occcc6917ff6.y ()F
      // 11c: fmul
      // 11d: fstore 16
      // 11f: fload 3
      // 120: fload 10
      // 122: fadd
      // 123: ldc_w 12.0
      // 126: fsub
      // 127: fstore 17
      // 129: fload 2
      // 12a: ldc_w 39.0
      // 12d: fadd
      // 12e: fload 17
      // 130: iload 7
      // 132: ifne 1a2
      // 135: fload 14
      // 137: ldc_w 3.0
      // 13a: ldc_w 1.5
      // 13d: new java/awt/Color
      // 140: dup
      // 141: bipush 0
      // 142: bipush 0
      // 143: bipush 0
      // 144: fload 5
      // 146: ldc_w 110.0
      // 149: fmul
      // 14a: f2i
      // 14b: invokespecial java/awt/Color.<init> (IIII)V
      // 14e: invokestatic x/W.s (FFFFFLjava/awt/Color;)V
      // 151: fload 16
      // 153: fconst_0
      // 154: fcmpl
      // 155: ifle 196
      // 158: goto 15c
      // 15b: athrow
      // 15c: fload 2
      // 15d: ldc_w 39.0
      // 160: fadd
      // 161: fload 17
      // 163: fload 16
      // 165: ldc_w 3.0
      // 168: ldc_w 1.5
      // 16b: aload 0
      // 16c: aload 11
      // 16e: bipush 0
      // 16f: aaload
      // 170: invokevirtual java/awt/Color.getRGB ()I
      // 173: ldc_w 95.0
      // 176: fload 5
      // 178: fmul
      // 179: f2i
      // 17a: invokevirtual x/oc7ed5a3bedd.ʱ (II)Ljava/awt/Color;
      // 17d: aload 0
      // 17e: aload 11
      // 180: bipush 1
      // 181: aaload
      // 182: invokevirtual java/awt/Color.getRGB ()I
      // 185: ldc_w 95.0
      // 188: fload 5
      // 18a: fmul
      // 18b: f2i
      // 18c: invokevirtual x/oc7ed5a3bedd.ʱ (II)Ljava/awt/Color;
      // 18f: invokestatic x/W.Ԧ (FFFFFLjava/awt/Color;Ljava/awt/Color;)V
      // 192: goto 196
      // 195: athrow
      // 196: fload 15
      // 198: iload 7
      // 19a: ifne 1af
      // 19d: fconst_0
      // 19e: goto 1a2
      // 1a1: athrow
      // 1a2: fcmpl
      // 1a3: ifle 1c4
      // 1a6: fload 2
      // 1a7: ldc_w 39.0
      // 1aa: fadd
      // 1ab: goto 1af
      // 1ae: athrow
      // 1af: fload 17
      // 1b1: fload 15
      // 1b3: ldc_w 3.0
      // 1b6: ldc_w 1.5
      // 1b9: aload 11
      // 1bb: bipush 0
      // 1bc: aaload
      // 1bd: aload 11
      // 1bf: bipush 1
      // 1c0: aaload
      // 1c1: invokestatic x/W.Ԧ (FFFFFLjava/awt/Color;Ljava/awt/Color;)V
      // 1c4: return
   }

   private oc1378bc114d ʍ(boolean var1, int var2) {
      try {
         if (var1) {
            return oc3ebac73392.ȯ("Tenacity-Bold", var2 / 20.0F);
         }
      } catch (ocbde1165e4e var3) {
         throw var3;
      }

      return oc3ebac73392.ȯ("Tenacity", var2 / 20.0F);
   }

   private void ӥ(oc1378bc114d var1, String var2, float var3, float var4, int var5, boolean var6) {
      var1.z$ao2ykh4tuw6w(var2, var3 - var1.z$toz8pt08w0nc(var2) / 2.0F, var4, var5, var6);
   }

   private void μ(int param1, long param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: istore 4
      // 005: aload 0
      // 006: iload 4
      // 008: ifne 046
      // 00b: getfield x/oc7ed5a3bedd.ɋ Lnet/minecraft/entity/EntityLivingBase;
      // 00e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 011: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 014: if_acmpne 045
      // 017: goto 01b
      // 01a: athrow
      // 01b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 01e: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 021: instanceof net/minecraft/client/gui/GuiChat
      // 024: ifne 045
      // 027: goto 02b
      // 02a: athrow
      // 02b: aload 0
      // 02c: aconst_null
      // 02d: putfield x/oc7ed5a3bedd.ɋ Lnet/minecraft/entity/EntityLivingBase;
      // 030: aload 0
      // 031: aconst_null
      // 032: putfield x/oc7ed5a3bedd.Ζ Lnet/minecraft/entity/EntityLivingBase;
      // 035: aload 0
      // 036: getfield x/oc7ed5a3bedd.Ŝ Lx/oc8ef88da691;
      // 039: bipush 0
      // 03a: lload 2
      // 03b: invokevirtual x/oc8ef88da691.ΐ (ZJ)V
      // 03e: aload 0
      // 03f: aconst_null
      // 040: putfield x/oc7ed5a3bedd.Ь Lx/oc5f2027353d;
      // 043: return
      // 044: athrow
      // 045: aload 0
      // 046: iload 1
      // 047: invokevirtual x/oc7ed5a3bedd.ӊ (I)Lnet/minecraft/entity/EntityLivingBase;
      // 04a: astore 5
      // 04c: aload 0
      // 04d: iload 4
      // 04f: ifne 08a
      // 052: invokevirtual x/oc7ed5a3bedd.ž ()Z
      // 055: ifeq 089
      // 058: goto 05c
      // 05b: athrow
      // 05c: aload 0
      // 05d: aload 5
      // 05f: putfield x/oc7ed5a3bedd.ɋ Lnet/minecraft/entity/EntityLivingBase;
      // 062: aload 0
      // 063: aload 0
      // 064: getfield x/oc7ed5a3bedd.ɋ Lnet/minecraft/entity/EntityLivingBase;
      // 067: putfield x/oc7ed5a3bedd.Ζ Lnet/minecraft/entity/EntityLivingBase;
      // 06a: aload 0
      // 06b: getfield x/oc7ed5a3bedd.Ŝ Lx/oc8ef88da691;
      // 06e: aload 0
      // 06f: getfield x/oc7ed5a3bedd.ɋ Lnet/minecraft/entity/EntityLivingBase;
      // 072: ifnull 07e
      // 075: goto 079
      // 078: athrow
      // 079: bipush 1
      // 07a: goto 07f
      // 07d: athrow
      // 07e: bipush 0
      // 07f: lload 2
      // 080: invokevirtual x/oc8ef88da691.ΐ (ZJ)V
      // 083: aload 0
      // 084: aconst_null
      // 085: putfield x/oc7ed5a3bedd.Ь Lx/oc5f2027353d;
      // 088: return
      // 089: aload 0
      // 08a: iload 4
      // 08c: ifne 0d0
      // 08f: getfield x/oc7ed5a3bedd.ɋ Lnet/minecraft/entity/EntityLivingBase;
      // 092: ifnonnull 0cb
      // 095: goto 099
      // 098: athrow
      // 099: aload 5
      // 09b: iload 4
      // 09d: ifne 12a
      // 0a0: goto 0a4
      // 0a3: athrow
      // 0a4: ifnull 11d
      // 0a7: goto 0ab
      // 0aa: athrow
      // 0ab: aload 0
      // 0ac: aload 5
      // 0ae: putfield x/oc7ed5a3bedd.ɋ Lnet/minecraft/entity/EntityLivingBase;
      // 0b1: iload 4
      // 0b3: aload 0
      // 0b4: aload 0
      // 0b5: getfield x/oc7ed5a3bedd.ɋ Lnet/minecraft/entity/EntityLivingBase;
      // 0b8: putfield x/oc7ed5a3bedd.Ζ Lnet/minecraft/entity/EntityLivingBase;
      // 0bb: aload 0
      // 0bc: getfield x/oc7ed5a3bedd.Ŝ Lx/oc8ef88da691;
      // 0bf: bipush 1
      // 0c0: lload 2
      // 0c1: invokevirtual x/oc8ef88da691.ɞ (ZJ)V
      // 0c4: ifeq 11d
      // 0c7: goto 0cb
      // 0ca: athrow
      // 0cb: aload 0
      // 0cc: goto 0d0
      // 0cf: athrow
      // 0d0: iload 4
      // 0d2: ifne 10a
      // 0d5: getfield x/oc7ed5a3bedd.ɋ Lnet/minecraft/entity/EntityLivingBase;
      // 0d8: aload 5
      // 0da: if_acmpne 0f3
      // 0dd: goto 0e1
      // 0e0: athrow
      // 0e1: aload 0
      // 0e2: getfield x/oc7ed5a3bedd.Ŝ Lx/oc8ef88da691;
      // 0e5: bipush 1
      // 0e6: lload 2
      // 0e7: invokevirtual x/oc8ef88da691.ɞ (ZJ)V
      // 0ea: iload 4
      // 0ec: ifeq 11d
      // 0ef: goto 0f3
      // 0f2: athrow
      // 0f3: aload 0
      // 0f4: iload 4
      // 0f6: ifne 11e
      // 0f9: goto 0fd
      // 0fc: athrow
      // 0fd: getfield x/oc7ed5a3bedd.Ŝ Lx/oc8ef88da691;
      // 100: bipush 0
      // 101: lload 2
      // 102: invokevirtual x/oc8ef88da691.ɞ (ZJ)V
      // 105: aload 0
      // 106: goto 10a
      // 109: athrow
      // 10a: getfield x/oc7ed5a3bedd.Ŝ Lx/oc8ef88da691;
      // 10d: lload 2
      // 10e: invokevirtual x/oc8ef88da691.ń (J)Z
      // 111: ifeq 11d
      // 114: aload 0
      // 115: aconst_null
      // 116: putfield x/oc7ed5a3bedd.ɋ Lnet/minecraft/entity/EntityLivingBase;
      // 119: goto 11d
      // 11c: athrow
      // 11d: aload 0
      // 11e: iload 4
      // 120: ifne 137
      // 123: getfield x/oc7ed5a3bedd.ɋ Lnet/minecraft/entity/EntityLivingBase;
      // 126: goto 12a
      // 129: athrow
      // 12a: ifnonnull 136
      // 12d: aload 0
      // 12e: aconst_null
      // 12f: putfield x/oc7ed5a3bedd.Ζ Lnet/minecraft/entity/EntityLivingBase;
      // 132: goto 136
      // 135: athrow
      // 136: aload 0
      // 137: aconst_null
      // 138: putfield x/oc7ed5a3bedd.Ь Lx/oc5f2027353d;
      // 13b: return
   }

   private EntityLivingBase ӊ(int param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 2
      // 04: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 07: iload 2
      // 08: ifne 23
      // 0b: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 0e: instanceof net/minecraft/client/gui/GuiChat
      // 11: ifeq 20
      // 14: goto 18
      // 17: athrow
      // 18: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1e: areturn
      // 1f: athrow
      // 20: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 23: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 26: ifnull 2c
      // 29: aconst_null
      // 2a: areturn
      // 2b: athrow
      // 2c: iload 1
      // 2d: iload 2
      // 2e: ifne 3e
      // 31: bipush 1
      // 32: if_icmpeq 48
      // 35: goto 39
      // 38: athrow
      // 39: iload 1
      // 3a: goto 3e
      // 3d: athrow
      // 3e: ldc_w -1106498911
      // 41: ldc_w -1106498909
      // 44: ixor
      // 45: if_icmpne 75
      // 48: ldc_w x/ocdd342096f8
      // 4b: invokestatic x/oc9755810e45.ʬ (Ljava/lang/Class;)Lx/oc69da1aa7f5;
      // 4e: checkcast x/ocdd342096f8
      // 51: astore 4
      // 53: aload 4
      // 55: iload 2
      // 56: ifne 62
      // 59: ifnull 6f
      // 5c: goto 60
      // 5f: athrow
      // 60: aload 4
      // 62: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 65: ifeq 6f
      // 68: getstatic x/ocdd342096f8.f Lnet/minecraft/entity/EntityLivingBase;
      // 6b: goto 70
      // 6e: athrow
      // 6f: aconst_null
      // 70: astore 3
      // 71: iload 2
      // 72: ifeq 79
      // 75: getstatic x/ocdd342096f8.ѐ Lnet/minecraft/entity/EntityLivingBase;
      // 78: astore 3
      // 79: aload 3
      // 7a: iload 2
      // 7b: ifne 86
      // 7e: ifnull b1
      // 81: goto 85
      // 84: athrow
      // 85: aload 3
      // 86: iload 2
      // 87: ifne 99
      // 8a: getfield net/minecraft/entity/EntityLivingBase.isDead Z
      // 8d: ifne b1
      // 90: goto 94
      // 93: athrow
      // 94: aload 3
      // 95: goto 99
      // 98: athrow
      // 99: iload 2
      // 9a: ifne ae
      // 9d: invokevirtual net/minecraft/entity/EntityLivingBase.getHealth ()F
      // a0: fconst_0
      // a1: fcmpl
      // a2: ifle b1
      // a5: goto a9
      // a8: athrow
      // a9: aload 3
      // aa: goto ae
      // ad: athrow
      // ae: goto b2
      // b1: aconst_null
      // b2: areturn
   }

   private boolean ž() {
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
      // 05: iload 1
      // 06: ifne 18
      // 09: getfield x/oc7ed5a3bedd.Н Lx/oca9cc61aada;
      // 0c: ifnull 2e
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: getfield x/oc7ed5a3bedd.Н Lx/oca9cc61aada;
      // 1b: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 1e: d2i
      // 1f: iload 1
      // 20: ifne 2b
      // 23: ifne 2e
      // 26: goto 2a
      // 29: athrow
      // 2a: bipush 1
      // 2b: goto 2f
      // 2e: bipush 0
      // 2f: ireturn
   }

   private boolean ĝ() {
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
      // 05: iload 1
      // 06: ifne 18
      // 09: getfield x/oc7ed5a3bedd.Н Lx/oca9cc61aada;
      // 0c: ifnull 31
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: getfield x/oc7ed5a3bedd.Н Lx/oca9cc61aada;
      // 1b: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 1e: d2i
      // 1f: iload 1
      // 20: ifne 36
      // 23: ldc_w -1510238904
      // 26: ldc_w -1510238902
      // 29: ixor
      // 2a: if_icmpne 39
      // 2d: goto 31
      // 30: athrow
      // 31: bipush 1
      // 32: goto 36
      // 35: athrow
      // 36: goto 3a
      // 39: bipush 0
      // 3a: ireturn
   }

   private float օ(long param1) {
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
      // 06: ifne 19
      // 09: invokevirtual x/oc7ed5a3bedd.ž ()Z
      // 0c: ifeq 18
      // 0f: goto 13
      // 12: athrow
      // 13: fconst_1
      // 14: goto 21
      // 17: athrow
      // 18: aload 0
      // 19: getfield x/oc7ed5a3bedd.Ŝ Lx/oc8ef88da691;
      // 1c: lload 1
      // 1d: invokevirtual x/oc8ef88da691.ʡ (J)D
      // 20: d2f
      // 21: freturn
   }

   private void Ͷ(float param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: invokestatic net/minecraft/client/renderer/GlStateManager.pushMatrix ()V
      // 06: istore 2
      // 07: aload 0
      // 08: invokevirtual x/oc7ed5a3bedd.ž ()Z
      // 0b: ifeq 10
      // 0e: return
      // 0f: athrow
      // 10: new net/minecraft/client/gui/ScaledResolution
      // 13: dup
      // 14: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 17: invokespecial net/minecraft/client/gui/ScaledResolution.<init> (Lnet/minecraft/client/Minecraft;)V
      // 1a: astore 3
      // 1b: iload 2
      // 1c: aload 0
      // 1d: aload 3
      // 1e: invokevirtual x/oc7ed5a3bedd.θ (Lnet/minecraft/client/gui/ScaledResolution;)F
      // 21: fstore 4
      // 23: aload 0
      // 24: aload 3
      // 25: invokevirtual x/oc7ed5a3bedd.ą (Lnet/minecraft/client/gui/ScaledResolution;)F
      // 28: ldc_w 20.0
      // 2b: fadd
      // 2c: fstore 5
      // 2e: ifne 58
      // 31: aload 0
      // 32: invokevirtual x/oc7ed5a3bedd.ĝ ()Z
      // 35: ifeq 5c
      // 38: goto 3c
      // 3b: athrow
      // 3c: fload 4
      // 3e: fload 5
      // 40: fconst_0
      // 41: invokestatic net/minecraft/client/renderer/GlStateManager.translate (FFF)V
      // 44: fload 1
      // 45: fload 1
      // 46: fconst_1
      // 47: invokestatic net/minecraft/client/renderer/GlStateManager.scale (FFF)V
      // 4a: fload 4
      // 4c: fneg
      // 4d: fload 5
      // 4f: fneg
      // 50: fconst_0
      // 51: invokestatic net/minecraft/client/renderer/GlStateManager.translate (FFF)V
      // 54: goto 58
      // 57: athrow
      // 58: iload 2
      // 59: ifeq 6f
      // 5c: fload 4
      // 5e: aload 3
      // 5f: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledWidth ()I
      // 62: fload 1
      // 63: invokestatic x/oc7ed5a3bedd.Щ (FIF)F
      // 66: fconst_0
      // 67: fconst_0
      // 68: invokestatic net/minecraft/client/renderer/GlStateManager.translate (FFF)V
      // 6b: goto 6f
      // 6e: athrow
      // 6f: return
   }

   private void ə() {
      GlStateManager.popMatrix();
   }

   static float Щ(float param0, int param1, float param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 3
      // 04: fload 0
      // 05: iload 1
      // 06: i2f
      // 07: fconst_2
      // 08: fdiv
      // 09: fcmpg
      // 0a: iload 3
      // 0b: ifne 1d
      // 0e: ifgt 1c
      // 11: goto 15
      // 14: athrow
      // 15: iload 1
      // 16: ineg
      // 17: i2f
      // 18: goto 1e
      // 1b: athrow
      // 1c: iload 1
      // 1d: i2f
      // 1e: fstore 4
      // 20: fload 4
      // 22: fconst_1
      // 23: fconst_0
      // 24: fconst_1
      // 25: fload 2
      // 26: invokestatic java/lang/Math.min (FF)F
      // 29: invokestatic java/lang/Math.max (FF)F
      // 2c: fsub
      // 2d: fmul
      // 2e: freturn
   }

   private float[] Į(float var1) {
      ScaledResolution var2 = new ScaledResolution(oc69da1aa7f5.ő);
      float[] var10000 = new float[1655917964 ^ 1655917966];
      var10000[0] = var2.getScaledWidth() / 2.0F - var1 / 2.0F + this.Ș;
      var10000[1] = var2.getScaledHeight() / 2.0F + 15.0F + this.ɐ;
      return var10000;
   }

   private void ù(float param1, float param2, float param3, float param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: istore 5
      // 005: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 008: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 00b: instanceof net/minecraft/client/gui/GuiChat
      // 00e: ifne 013
      // 011: return
      // 012: athrow
      // 013: new net/minecraft/client/gui/ScaledResolution
      // 016: dup
      // 017: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 01a: invokespecial net/minecraft/client/gui/ScaledResolution.<init> (Lnet/minecraft/client/Minecraft;)V
      // 01d: astore 6
      // 01f: aload 0
      // 020: aload 6
      // 022: invokevirtual x/oc7ed5a3bedd.ç (Lnet/minecraft/client/gui/ScaledResolution;)F
      // 025: fstore 7
      // 027: aload 0
      // 028: aload 6
      // 02a: invokevirtual x/oc7ed5a3bedd.Ӷ (Lnet/minecraft/client/gui/ScaledResolution;)F
      // 02d: fstore 8
      // 02f: fload 7
      // 031: fload 1
      // 032: iload 5
      // 034: ifne 051
      // 037: fcmpl
      // 038: iflt 084
      // 03b: goto 03f
      // 03e: athrow
      // 03f: fload 7
      // 041: iload 5
      // 043: ifne 05b
      // 046: goto 04a
      // 049: athrow
      // 04a: fload 1
      // 04b: fload 3
      // 04c: fadd
      // 04d: goto 051
      // 050: athrow
      // 051: fcmpg
      // 052: ifgt 084
      // 055: fload 8
      // 057: goto 05b
      // 05a: athrow
      // 05b: iload 5
      // 05d: ifne 06f
      // 060: fload 2
      // 061: fcmpl
      // 062: iflt 084
      // 065: goto 069
      // 068: athrow
      // 069: fload 8
      // 06b: goto 06f
      // 06e: athrow
      // 06f: fload 2
      // 070: fload 4
      // 072: fadd
      // 073: fcmpg
      // 074: iload 5
      // 076: ifne 081
      // 079: ifgt 084
      // 07c: goto 080
      // 07f: athrow
      // 080: bipush 1
      // 081: goto 085
      // 084: bipush 0
      // 085: istore 9
      // 087: iload 9
      // 089: iload 5
      // 08b: ifne 0f2
      // 08e: ifeq 0ee
      // 091: goto 095
      // 094: athrow
      // 095: aload 0
      // 096: iload 5
      // 098: ifne 0ef
      // 09b: goto 09f
      // 09e: athrow
      // 09f: getfield x/oc7ed5a3bedd.ʕ Z
      // 0a2: ifne 0ee
      // 0a5: goto 0a9
      // 0a8: athrow
      // 0a9: bipush 0
      // 0aa: iload 5
      // 0ac: ifne 0f2
      // 0af: goto 0b3
      // 0b2: athrow
      // 0b3: invokestatic org/lwjgl/input/Mouse.isButtonDown (I)Z
      // 0b6: ifeq 0ee
      // 0b9: goto 0bd
      // 0bc: athrow
      // 0bd: aload 0
      // 0be: bipush 1
      // 0bf: putfield x/oc7ed5a3bedd.ʕ Z
      // 0c2: aload 0
      // 0c3: aload 0
      // 0c4: getfield x/oc7ed5a3bedd.Ș I
      // 0c7: i2d
      // 0c8: putfield x/oc7ed5a3bedd.ƀ D
      // 0cb: aload 0
      // 0cc: aload 0
      // 0cd: getfield x/oc7ed5a3bedd.ɐ I
      // 0d0: i2d
      // 0d1: putfield x/oc7ed5a3bedd.ү D
      // 0d4: aload 0
      // 0d5: aload 0
      // 0d6: aload 6
      // 0d8: invokevirtual x/oc7ed5a3bedd.ç (Lnet/minecraft/client/gui/ScaledResolution;)F
      // 0db: f2d
      // 0dc: putfield x/oc7ed5a3bedd.ͻ D
      // 0df: aload 0
      // 0e0: aload 0
      // 0e1: aload 6
      // 0e3: invokevirtual x/oc7ed5a3bedd.Ӷ (Lnet/minecraft/client/gui/ScaledResolution;)F
      // 0e6: f2d
      // 0e7: putfield x/oc7ed5a3bedd.Ǧ D
      // 0ea: goto 0ee
      // 0ed: athrow
      // 0ee: aload 0
      // 0ef: getfield x/oc7ed5a3bedd.ʕ Z
      // 0f2: iload 5
      // 0f4: ifne 106
      // 0f7: ifeq 147
      // 0fa: goto 0fe
      // 0fd: athrow
      // 0fe: bipush 0
      // 0ff: invokestatic org/lwjgl/input/Mouse.isButtonDown (I)Z
      // 102: goto 106
      // 105: athrow
      // 106: ifne 117
      // 109: aload 0
      // 10a: bipush 0
      // 10b: putfield x/oc7ed5a3bedd.ʕ Z
      // 10e: iload 5
      // 110: ifeq 147
      // 113: goto 117
      // 116: athrow
      // 117: aload 0
      // 118: aload 0
      // 119: getfield x/oc7ed5a3bedd.ƀ D
      // 11c: aload 0
      // 11d: aload 6
      // 11f: invokevirtual x/oc7ed5a3bedd.ç (Lnet/minecraft/client/gui/ScaledResolution;)F
      // 122: f2d
      // 123: dadd
      // 124: aload 0
      // 125: getfield x/oc7ed5a3bedd.ͻ D
      // 128: dsub
      // 129: d2i
      // 12a: putfield x/oc7ed5a3bedd.Ș I
      // 12d: aload 0
      // 12e: aload 0
      // 12f: getfield x/oc7ed5a3bedd.ү D
      // 132: aload 0
      // 133: aload 6
      // 135: invokevirtual x/oc7ed5a3bedd.Ӷ (Lnet/minecraft/client/gui/ScaledResolution;)F
      // 138: f2d
      // 139: dadd
      // 13a: aload 0
      // 13b: getfield x/oc7ed5a3bedd.Ǧ D
      // 13e: dsub
      // 13f: d2i
      // 140: putfield x/oc7ed5a3bedd.ɐ I
      // 143: goto 147
      // 146: athrow
      // 147: return
   }

   private float З() {
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
      // 05: iload 1
      // 06: ifne 19
      // 09: getfield x/oc7ed5a3bedd.F Lx/oca9cc61aada;
      // 0c: ifnonnull 18
      // 0f: goto 13
      // 12: athrow
      // 13: dconst_1
      // 14: goto 1f
      // 17: athrow
      // 18: aload 0
      // 19: getfield x/oc7ed5a3bedd.F Lx/oca9cc61aada;
      // 1c: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 1f: invokestatic x/oc05d664c647.Ө (D)F
      // 22: freturn
   }

   private float θ(ScaledResolution var1) {
      return var1.getScaledWidth() / 2.0F + this.Ș;
   }

   private float ą(ScaledResolution var1) {
      return var1.getScaledHeight() / 2.0F + 15.0F + this.ɐ;
   }

   private float ç(ScaledResolution var1) {
      float var2 = (float)(Mouse.getX() * var1.getScaledWidth()) / oc69da1aa7f5.ő.displayWidth;
      float var3 = this.θ(var1);
      return var3 + (var2 - var3) / this.З();
   }

   private float Ӷ(ScaledResolution var1) {
      float var2 = var1.getScaledHeight() - (float)(Mouse.getY() * var1.getScaledHeight()) / oc69da1aa7f5.ő.displayHeight - 1.0F;
      float var3 = this.ą(var1);
      return var3 + (var2 - var3) / this.З();
   }

   private void Ň() {
      ScaledResolution var1 = new ScaledResolution(oc69da1aa7f5.ő);
      float var2 = this.θ(var1);
      float var3 = this.ą(var1);
      float var4 = this.З();
      GlStateManager.pushMatrix();
      GlStateManager.translate(var2, var3, 0.0F);
      GlStateManager.scale(var4, var4, 1.0F);
      GlStateManager.translate(-var2, -var3, 0.0F);
   }

   private void έ() {
      GlStateManager.popMatrix();
   }

   private void Г(EntityLivingBase param1, float param2, float param3, float param4, float param5, float param6, float param7) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: istore 8
      // 005: aload 1
      // 006: iload 8
      // 008: ifne 01a
      // 00b: instanceof net/minecraft/client/entity/AbstractClientPlayer
      // 00e: ifeq 11a
      // 011: goto 015
      // 014: athrow
      // 015: aload 1
      // 016: goto 01a
      // 019: athrow
      // 01a: checkcast net/minecraft/client/entity/AbstractClientPlayer
      // 01d: astore 9
      // 01f: fload 5
      // 021: fconst_0
      // 022: fcmpl
      // 023: iload 8
      // 025: ifne 032
      // 028: ifle 051
      // 02b: goto 02f
      // 02e: athrow
      // 02f: invokestatic net/minecraft/client/renderer/OpenGlHelper.isReducedRenderMode ()Z
      // 032: iload 8
      // 034: ifne 041
      // 037: ifne 051
      // 03a: goto 03e
      // 03d: athrow
      // 03e: invokestatic net/minecraft/client/renderer/OpenGlHelper.isFramebufferEnabled ()Z
      // 041: iload 8
      // 043: ifne 04e
      // 046: ifeq 051
      // 049: goto 04d
      // 04c: athrow
      // 04d: bipush 1
      // 04e: goto 052
      // 051: bipush 0
      // 052: istore 10
      // 054: iload 8
      // 056: ifne 097
      // 059: iload 10
      // 05b: ifeq 083
      // 05e: goto 062
      // 061: athrow
      // 062: aload 0
      // 063: invokevirtual x/oc7ed5a3bedd.Ӕ ()V
      // 066: fload 2
      // 067: fload 3
      // 068: fload 4
      // 06a: fload 4
      // 06c: fload 5
      // 06e: fload 4
      // 070: fconst_2
      // 071: fdiv
      // 072: invokestatic java/lang/Math.min (FF)F
      // 075: getstatic java/awt/Color.WHITE Ljava/awt/Color;
      // 078: invokestatic x/W.s (FFFFFLjava/awt/Color;)V
      // 07b: aload 0
      // 07c: invokevirtual x/oc7ed5a3bedd.ơ ()V
      // 07f: goto 083
      // 082: athrow
      // 083: invokestatic net/minecraft/client/renderer/GlStateManager.enableBlend ()V
      // 086: invokestatic net/minecraft/client/renderer/GlStateManager.enableTexture2D ()V
      // 089: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 08c: invokevirtual net/minecraft/client/Minecraft.getTextureManager ()Lnet/minecraft/client/renderer/texture/TextureManager;
      // 08f: aload 9
      // 091: invokevirtual net/minecraft/client/entity/AbstractClientPlayer.getLocationSkin ()Lnet/minecraft/util/ResourceLocation;
      // 094: invokevirtual net/minecraft/client/renderer/texture/TextureManager.bindTexture (Lnet/minecraft/util/ResourceLocation;)V
      // 097: fconst_0
      // 098: fconst_1
      // 099: fload 6
      // 09b: invokestatic java/lang/Math.min (FF)F
      // 09e: invokestatic java/lang/Math.max (FF)F
      // 0a1: fstore 11
      // 0a3: fconst_1
      // 0a4: fload 11
      // 0a6: fload 11
      // 0a8: fconst_0
      // 0a9: fconst_1
      // 0aa: fload 7
      // 0ac: invokestatic java/lang/Math.min (FF)F
      // 0af: invokestatic java/lang/Math.max (FF)F
      // 0b2: invokestatic net/minecraft/client/renderer/GlStateManager.color (FFFF)V
      // 0b5: fload 2
      // 0b6: f2i
      // 0b7: fload 3
      // 0b8: f2i
      // 0b9: ldc_w 8.0
      // 0bc: ldc_w 8.0
      // 0bf: ldc_w 520782364
      // 0c2: ldc_w 520782356
      // 0c5: ixor
      // 0c6: ldc_w 520782364
      // 0c9: ldc_w 520782356
      // 0cc: ixor
      // 0cd: fload 4
      // 0cf: f2i
      // 0d0: fload 4
      // 0d2: f2i
      // 0d3: ldc_w 64.0
      // 0d6: ldc_w 64.0
      // 0d9: invokestatic net/minecraft/client/gui/Gui.drawScaledCustomSizeModalRect (IIFFIIIIFF)V
      // 0dc: fload 2
      // 0dd: f2i
      // 0de: fload 3
      // 0df: f2i
      // 0e0: ldc_w 40.0
      // 0e3: ldc_w 8.0
      // 0e6: ldc_w 520782364
      // 0e9: ldc_w 520782356
      // 0ec: ixor
      // 0ed: ldc_w 520782364
      // 0f0: ldc_w 520782356
      // 0f3: ixor
      // 0f4: fload 4
      // 0f6: f2i
      // 0f7: fload 4
      // 0f9: f2i
      // 0fa: ldc_w 64.0
      // 0fd: ldc_w 64.0
      // 100: invokestatic net/minecraft/client/gui/Gui.drawScaledCustomSizeModalRect (IIFFIIIIFF)V
      // 103: fconst_1
      // 104: fconst_1
      // 105: fconst_1
      // 106: fconst_1
      // 107: invokestatic net/minecraft/client/renderer/GlStateManager.color (FFFF)V
      // 10a: invokestatic net/minecraft/client/renderer/GlStateManager.disableBlend ()V
      // 10d: iload 10
      // 10f: ifeq 11a
      // 112: aload 0
      // 113: invokevirtual x/oc7ed5a3bedd.Լ ()V
      // 116: goto 11a
      // 119: athrow
      // 11a: return
   }

   private void Ӕ() {
      boolean var10000 = oce6044968f8.ђ;
      Framebuffer var2 = oc69da1aa7f5.ő.getFramebuffer();
      boolean var1 = var10000;

      label20: {
         try {
            var2.bindFramebuffer(false);
            if (var1) {
               return;
            }

            if (var2.depthBuffer <= -1) {
               break label20;
            }
         } catch (ocbde1165e4e var4) {
            throw var4;
         }

         EXTFramebufferObject.glDeleteRenderbuffersEXT(var2.depthBuffer);
         int var3 = EXTFramebufferObject.glGenRenderbuffersEXT();
         EXTFramebufferObject.glBindRenderbufferEXT(-1810009675 ^ -1809974028, var3);
         EXTFramebufferObject.glRenderbufferStorageEXT(
            -1810009675 ^ -1809974028, -1810008051 ^ -1809974028, oc69da1aa7f5.ő.displayWidth, oc69da1aa7f5.ő.displayHeight
         );
         EXTFramebufferObject.glFramebufferRenderbufferEXT(-1810009676 ^ -1809974028, -1810009644 ^ -1809974028, -1810009675 ^ -1809974028, var3);
         EXTFramebufferObject.glFramebufferRenderbufferEXT(-1810009676 ^ -1809974028, -1810009612 ^ -1809974028, -1810009675 ^ -1809974028, var3);
         var2.depthBuffer = -1;
      }

      GL11.glClear(-1809975052 ^ -1809974028);
      GL11.glEnable(-1809975452 ^ -1809974028);
      GL11.glStencilFunc(-1809973517 ^ -1809974028, 1, 1);
      GL11.glStencilOp(-1809980683 ^ -1809974028, -1809980683 ^ -1809974028, -1809980683 ^ -1809974028);
      GL11.glColorMask(false, false, false, false);
   }

   private void ơ() {
      GL11.glColorMask(true, true, true, true);
      GL11.glStencilFunc(1913659238 ^ 1913658724, 1, 1);
      GL11.glStencilOp(1913652068 ^ 1913658724, 1913652068 ^ 1913658724, 1913652068 ^ 1913658724);
   }

   private void Լ() {
      GL11.glColorMask(true, true, true, true);
      GL11.glDisable(-1940276389 ^ -1940279093);
   }

   private Color[] ľ(int var1) {
      int[] var10000 = new int[-26418257 ^ -26418259];
      var10000[0] = ocd2958dac48.ů(0.0);
      var10000[1] = ocd2958dac48.ů(48.0);
      int[] var2 = var10000;
      Color[] var3 = new Color[-26418257 ^ -26418259];
      var3[0] = this.ʱ(var2[0], var1);
      var3[1] = this.ʱ(var2[1], var1);
      return var3;
   }

   private Color ʱ(int var1, int var2) {
      return new Color(
         var1 >> (416446397 ^ 416446381) & (416446290 ^ 416446381),
         var1 >> (416446373 ^ 416446381) & (416446290 ^ 416446381),
         var1 & (416446290 ^ 416446381),
         Math.max(0, Math.min(416446290 ^ 416446381, var2))
      );
   }

   private float Ư(EntityLivingBase var1) {
      float var2 = Math.max(0.0F, var1.getAbsorptionAmount());
      float var3 = Math.max(1.0F, var1.getMaxHealth() + var2);
      return Math.max(0.0F, Math.min(1.0F, (var1.getHealth() + var2) / var3));
   }

   private void ǻ() {
      this.Ь = null;
      this.ɋ = null;
      this.Ζ = null;
      this.ɣ.clear();
      this.ϳ.clear();
      this.բ.clear();
      this.ҷ.clear();
      this.Ŝ.ΐ(false, System.currentTimeMillis());
   }

   static {
      String[] var10000 = new String[2009717029 ^ 2009717030];
      var10000[0] = "None";
      var10000[1] = "Move in";
      var10000[2009717028 ^ 2009717030] = "Scale in";
      Ɋ = var10000;
      var10000 = new String[2009717029 ^ 2009717030];
      var10000[0] = "Raven";
      var10000[1] = "Miau";
      var10000[2009717028 ^ 2009717030] = "Myau";
      ŷ = var10000;
      var10000 = new String[2009717028 ^ 2009717030];
      var10000[0] = "Legacy";
      var10000[1] = "Modern";
      ӯ = var10000;
      var10000 = new String[2009717028 ^ 2009717030];
      var10000[0] = "Default";
      var10000[1] = "HUD";
      չ = var10000;
   }
}

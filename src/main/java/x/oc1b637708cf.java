package x;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Vec3;

public class oc1b637708cf {
   private final ocbd3640d420 ɣ = ocbd3640d420.L;
   private final occ39d36078d ϊ;
   private EntityPlayer Đ;
   private boolean P;
   private boolean ϩ;
   private boolean ӣ;
   private boolean İ;
   private boolean ͽ;
   private int Ɋ;
   private int Ӕ;
   private int Ȍ;
   private int Ճ;
   private int ӗ;
   private int Ɉ;
   private int կ;
   private long Ÿ;
   private Vec3 ɬ = Ϧ();
   private Vec3 Ȫ = Ϧ();
   private Vec3 ҋ = Ϧ();
   private Vec3 d = Ϧ();
   private float Ԇ;
   private float ƃ;
   private float Ĳ;
   private float Ƥ;
   private final oca9cc61aada Л;
   private final oca9cc61aada Ϗ;
   private final ocf1568fef75 ξ;
   private final oca9cc61aada ȶ;
   private final oca9cc61aada ɀ;
   private final occ2f8dff8d8 З;
   private final occc831eff22 ƣ;
   private final occ2f8dff8d8 Ң;
   private final oca9cc61aada Q;
   private final oc24a0a5bddf ó;
   private final occc831eff22 ο;
   private final occ2f8dff8d8 Ͼ;
   private final occ2f8dff8d8 Ԝ;
   public static int î;

   public oc1b637708cf(occ39d36078d var1) {
      String[] var10009 = new String[429166640 ^ 429166642];
      var10009[0] = "Maximum delay";
      var10009[1] = "setting.014";
      this.Л = new oca9cc61aada("Min Delay", "ms", 100.0, 10.0, 1000.0, 1.0, var10009);
      this.Ϗ = new oca9cc61aada("Max Delay", "ms", 100.0, 10.0, 1000.0, 1.0, "Maximum delay");
      this.ξ = new ocf1568fef75("Active Range", "", 0.0, 12.0, 2.0, 5.0, 0.1, "Target distance");
      this.ȶ = new oca9cc61aada("Maximum hurt time", 10.0, 1.0, 10.0, 1.0);
      this.ɀ = new oca9cc61aada("Cooldown", "ms", 250.0, 0.0, 5000.0, 50.0);
      this.З = new occ2f8dff8d8("Flush when hit", false, new String[]{"Disable when hit"});
      this.ƣ = new occc831eff22("Indicator");
      this.Ң = new occ2f8dff8d8(this.ƣ, "Enabled", false);
      occc831eff22 var10003 = this.ƣ;
      String[] var10006 = new String[429166640 ^ 429166642];
      var10006[0] = "Custom";
      var10006[1] = "HUD";
      this.Q = new oca9cc61aada(var10003, "Color mode", 1, var10006);
      this.ó = new oc24a0a5bddf(this.ƣ, "Indicator color", 429166798 ^ 429166642, 429166798 ^ 429166642, 429166798 ^ 429166642, 429166797 ^ 429166642);
      this.ο = new occc831eff22("Conditions");
      this.Ͼ = new occ2f8dff8d8(this.ο, "Left Click", false);
      this.Ԝ = new occ2f8dff8d8(this.ο, "Holding weapon", false);
      this.ϊ = var1;
      var1.z$1k81rl22ylo65(this.Л, "setting.normal.minDelay");
      var1.z$1k81rl22ylo65(this.Ϗ, "setting.014");
      var1.z$1k81rl22ylo65(this.ξ, "setting.015");
      var1.z$1k81rl22ylo65(this.ȶ, "setting.016");
      var1.z$1k81rl22ylo65(this.ɀ, "setting.017");
      var1.z$1k81rl22ylo65(this.З, "setting.018");
      var1.z$1k81rl22ylo65(this.ƣ, "setting.019");
      var1.z$1k81rl22ylo65(this.Ң, "setting.020");
      var1.z$1k81rl22ylo65(this.Q, "setting.normal.indicatorColorMode");
      var1.z$1k81rl22ylo65(this.ó, "setting.021");
      var1.z$1k81rl22ylo65(this.ο, "setting.025");
      var1.z$1k81rl22ylo65(this.Ͼ, "setting.026");
      var1.z$1k81rl22ylo65(this.Ԝ, "setting.027");
   }

   private N[] ċ() {
      N[] var10000 = new N[84217479 ^ 84217482];
      var10000[0] = this.Л;
      var10000[1] = this.Ϗ;
      var10000[84217480 ^ 84217482] = this.ξ;
      var10000[84217481 ^ 84217482] = this.ȶ;
      var10000[84217486 ^ 84217482] = this.ɀ;
      var10000[84217487 ^ 84217482] = this.З;
      var10000[84217484 ^ 84217482] = this.ƣ;
      var10000[84217485 ^ 84217482] = this.Ң;
      var10000[84217474 ^ 84217482] = this.Q;
      var10000[84217475 ^ 84217482] = this.ó;
      var10000[84217472 ^ 84217482] = this.ο;
      var10000[84217473 ^ 84217482] = this.Ͼ;
      var10000[84217478 ^ 84217482] = this.Ԝ;
      return var10000;
   }

   public void ʗ(boolean param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: aload 0
      // 04: invokevirtual x/oc1b637708cf.ċ ()[Lx/N;
      // 07: astore 3
      // 08: istore 2
      // 09: aload 3
      // 0a: arraylength
      // 0b: istore 4
      // 0d: bipush 0
      // 0e: istore 5
      // 10: iload 5
      // 12: iload 4
      // 14: if_icmpge 36
      // 17: aload 3
      // 18: iload 5
      // 1a: aaload
      // 1b: astore 6
      // 1d: iload 2
      // 1e: ifne 5c
      // 21: aload 6
      // 23: iload 1
      // 24: aload 0
      // 25: getfield x/oc1b637708cf.ϊ Lx/occ39d36078d;
      // 28: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 2b: iload 2
      // 2c: iinc 5 1
      // 2f: ifeq 10
      // 32: goto 36
      // 35: athrow
      // 36: iload 1
      // 37: iload 2
      // 38: ifne 4d
      // 3b: ifeq 5c
      // 3e: goto 42
      // 41: athrow
      // 42: aload 0
      // 43: getfield x/oc1b637708cf.Ң Lx/occ2f8dff8d8;
      // 46: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 49: goto 4d
      // 4c: athrow
      // 4d: iload 2
      // 4e: ifne 59
      // 51: ifeq 5c
      // 54: goto 58
      // 57: athrow
      // 58: bipush 1
      // 59: goto 5d
      // 5c: bipush 0
      // 5d: istore 3
      // 5e: aload 0
      // 5f: getfield x/oc1b637708cf.Q Lx/oca9cc61aada;
      // 62: iload 3
      // 63: aload 0
      // 64: getfield x/oc1b637708cf.ϊ Lx/occ39d36078d;
      // 67: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 6a: aload 0
      // 6b: getfield x/oc1b637708cf.ó Lx/oc24a0a5bddf;
      // 6e: iload 3
      // 6f: iload 2
      // 70: ifne 86
      // 73: ifeq 95
      // 76: goto 7a
      // 79: athrow
      // 7a: aload 0
      // 7b: getfield x/oc1b637708cf.Q Lx/oca9cc61aada;
      // 7e: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 81: d2i
      // 82: goto 86
      // 85: athrow
      // 86: iload 2
      // 87: ifne 92
      // 8a: ifne 95
      // 8d: goto 91
      // 90: athrow
      // 91: bipush 1
      // 92: goto 96
      // 95: bipush 0
      // 96: aload 0
      // 97: getfield x/oc1b637708cf.ϊ Lx/occ39d36078d;
      // 9a: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 9d: return
   }

   int ɦ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 21
      // 09: getfield x/oc1b637708cf.Q Lx/oca9cc61aada;
      // 0c: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0f: d2i
      // 10: bipush 1
      // 11: if_icmpne 20
      // 14: goto 18
      // 17: athrow
      // 18: dconst_0
      // 19: invokestatic x/ocd2958dac48.ů (D)I
      // 1c: goto 27
      // 1f: athrow
      // 20: aload 0
      // 21: getfield x/oc1b637708cf.ó Lx/oc24a0a5bddf;
      // 24: invokevirtual x/oc24a0a5bddf.ǐ ()I
      // 27: ireturn
   }

   public synchronized boolean ѷ() {
      return this.P;
   }

   public EntityPlayer Ӗ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 18
      // 09: getfield x/oc1b637708cf.P Z
      // 0c: ifeq 1e
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: getfield x/oc1b637708cf.Đ Lnet/minecraft/entity/player/EntityPlayer;
      // 1b: goto 1f
      // 1e: aconst_null
      // 1f: areturn
   }

   public Vec3 Ђ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 18
      // 09: getfield x/oc1b637708cf.P Z
      // 0c: ifeq 1e
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: getfield x/oc1b637708cf.d Lnet/minecraft/util/Vec3;
      // 1b: goto 1f
      // 1e: aconst_null
      // 1f: areturn
   }

   public synchronized int ņ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 1d
      // 09: getfield x/oc1b637708cf.P Z
      // 0c: ifeq 1c
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: getfield x/oc1b637708cf.Ÿ J
      // 17: l2i
      // 18: goto 2e
      // 1b: athrow
      // 1c: aload 0
      // 1d: getfield x/oc1b637708cf.Л Lx/oca9cc61aada;
      // 20: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 23: aload 0
      // 24: getfield x/oc1b637708cf.Ϗ Lx/oca9cc61aada;
      // 27: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 2a: invokestatic java/lang/Math.max (DD)D
      // 2d: d2i
      // 2e: ireturn
   }

   public String Ń() {
      return this.ņ() + "ms";
   }

   public synchronized void η(boolean var1) {
      this.ʄ();
      this.Đ = null;
      occ39d36078d.ž = false;
      ocdab58ca6e4.Ե(false);
   }

   private float ϡ(String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: aload 1
      // 04: astore 3
      // 05: istore 2
      // 06: bipush -1
      // 07: istore 4
      // 09: aload 3
      // 0a: invokevirtual java/lang/String.hashCode ()I
      // 0d: iload 2
      // 0e: ifne 65
      // 11: lookupswitch 82 2 -546109589 57 -97623070 28
      // 2c: athrow
      // 2d: aload 3
      // 2e: ldc_w "max_hurt_time"
      // 31: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 34: iload 2
      // 35: ifne 65
      // 38: goto 3c
      // 3b: athrow
      // 3c: ifeq 63
      // 3f: goto 43
      // 42: athrow
      // 43: bipush 0
      // 44: istore 4
      // 46: iload 2
      // 47: ifeq 63
      // 4a: aload 3
      // 4b: ldc_w "cooldown"
      // 4e: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 51: iload 2
      // 52: ifne 65
      // 55: goto 59
      // 58: athrow
      // 59: ifeq 63
      // 5c: goto 60
      // 5f: athrow
      // 60: bipush 1
      // 61: istore 4
      // 63: iload 4
      // 65: lookupswitch 54 2 0 27 1 39
      // 80: aload 0
      // 81: getfield x/oc1b637708cf.ȶ Lx/oca9cc61aada;
      // 84: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 87: d2f
      // 88: goto a4
      // 8b: athrow
      // 8c: aload 0
      // 8d: getfield x/oc1b637708cf.ɀ Lx/oca9cc61aada;
      // 90: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 93: ldc2_w 50.0
      // 96: ddiv
      // 97: d2f
      // 98: goto a4
      // 9b: new java/lang/IllegalArgumentException
      // 9e: dup
      // 9f: aload 1
      // a0: invokespecial java/lang/IllegalArgumentException.<init> (Ljava/lang/String;)V
      // a3: athrow
      // a4: freturn
   }

   private boolean Ѳ(String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: aload 1
      // 001: astore 3
      // 002: getstatic x/oc75d51ec7eb.ϩ I
      // 005: bipush -1
      // 006: istore 4
      // 008: istore 2
      // 009: aload 3
      // 00a: invokevirtual java/lang/String.hashCode ()I
      // 00d: iload 2
      // 00e: ifne 0bb
      // 011: lookupswitch 168 4 -1172250930 102 -958553820 137 -955100618 73 289610030 44
      // 03c: athrow
      // 03d: aload 3
      // 03e: ldc_w "require_mouse_pressed"
      // 041: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 044: iload 2
      // 045: ifne 0bb
      // 048: goto 04c
      // 04b: athrow
      // 04c: ifeq 0b9
      // 04f: goto 053
      // 052: athrow
      // 053: bipush 0
      // 054: istore 4
      // 056: iload 2
      // 057: ifeq 0b9
      // 05a: aload 3
      // 05b: ldc_w "require_weapon"
      // 05e: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 061: iload 2
      // 062: ifne 0bb
      // 065: goto 069
      // 068: athrow
      // 069: ifeq 0b9
      // 06c: goto 070
      // 06f: athrow
      // 070: bipush 1
      // 071: istore 4
      // 073: iload 2
      // 074: ifeq 0b9
      // 077: aload 3
      // 078: ldc_w "flush_on_hit"
      // 07b: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 07e: iload 2
      // 07f: ifne 0bb
      // 082: goto 086
      // 085: athrow
      // 086: ifeq 0b9
      // 089: goto 08d
      // 08c: athrow
      // 08d: ldc_w -785016681
      // 090: ldc_w -785016683
      // 093: ixor
      // 094: istore 4
      // 096: iload 2
      // 097: ifeq 0b9
      // 09a: aload 3
      // 09b: ldc_w "render_remote_pos"
      // 09e: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0a1: iload 2
      // 0a2: ifne 0bb
      // 0a5: goto 0a9
      // 0a8: athrow
      // 0a9: ifeq 0b9
      // 0ac: goto 0b0
      // 0af: athrow
      // 0b0: ldc_w -785016682
      // 0b3: ldc_w -785016683
      // 0b6: ixor
      // 0b7: istore 4
      // 0b9: iload 4
      // 0bb: iload 2
      // 0bc: ifne 0e8
      // 0bf: tableswitch 74 0 3 30 44 54 64
      // 0dc: athrow
      // 0dd: aload 0
      // 0de: getfield x/oc1b637708cf.Ͼ Lx/occ2f8dff8d8;
      // 0e1: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0e4: goto 0e8
      // 0e7: athrow
      // 0e8: goto 112
      // 0eb: aload 0
      // 0ec: getfield x/oc1b637708cf.Ԝ Lx/occ2f8dff8d8;
      // 0ef: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0f2: goto 112
      // 0f5: aload 0
      // 0f6: getfield x/oc1b637708cf.З Lx/occ2f8dff8d8;
      // 0f9: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0fc: goto 112
      // 0ff: aload 0
      // 100: getfield x/oc1b637708cf.Ң Lx/occ2f8dff8d8;
      // 103: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 106: goto 112
      // 109: new java/lang/IllegalArgumentException
      // 10c: dup
      // 10d: aload 1
      // 10e: invokespecial java/lang/IllegalArgumentException.<init> (Ljava/lang/String;)V
      // 111: athrow
      // 112: ireturn
   }

   public boolean ƍ(int param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 2
      // 04: iload 1
      // 05: iload 2
      // 06: ifne 4a
      // 09: ldc_w 1193679968
      // 0c: ldc_w 1193679970
      // 0f: ixor
      // 10: if_icmpeq 45
      // 13: goto 17
      // 16: athrow
      // 17: iload 1
      // 18: iload 2
      // 19: ifne 4a
      // 1c: goto 20
      // 1f: athrow
      // 20: ldc_w 1193679972
      // 23: ldc_w 1193679970
      // 26: ixor
      // 27: if_icmpeq 45
      // 2a: goto 2e
      // 2d: athrow
      // 2e: iload 1
      // 2f: iload 2
      // 30: ifne 4a
      // 33: goto 37
      // 36: athrow
      // 37: ldc_w 1193679984
      // 3a: ldc_w 1193679970
      // 3d: ixor
      // 3e: if_icmpne 4d
      // 41: goto 45
      // 44: athrow
      // 45: bipush 1
      // 46: goto 4a
      // 49: athrow
      // 4a: goto 4e
      // 4d: bipush 0
      // 4e: ireturn
   }

   public synchronized void n(oc6111f05032 param1, oc33e2bcdd33 param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 3
      // 004: aload 2
      // 005: iload 3
      // 006: ifne 02c
      // 009: getfield x/oc33e2bcdd33.Օ I
      // 00c: ldc_w -160726069
      // 00f: ldc_w -160726071
      // 012: ixor
      // 013: if_icmpne 027
      // 016: goto 01a
      // 019: athrow
      // 01a: aload 0
      // 01b: aload 2
      // 01c: invokevirtual x/oc1b637708cf.ε (Lx/oc33e2bcdd33;)V
      // 01f: iload 3
      // 020: ifeq 34c
      // 023: goto 027
      // 026: athrow
      // 027: aload 2
      // 028: goto 02c
      // 02b: athrow
      // 02c: getfield x/oc33e2bcdd33.Օ I
      // 02f: iload 3
      // 030: ifne 086
      // 033: ldc_w -160726065
      // 036: ldc_w -160726071
      // 039: ixor
      // 03a: if_icmpne 076
      // 03d: goto 041
      // 040: athrow
      // 041: aload 0
      // 042: getfield x/oc1b637708cf.ͽ Z
      // 045: ifeq 34c
      // 048: goto 04c
      // 04b: athrow
      // 04c: aload 2
      // 04d: aload 0
      // 04e: getfield x/oc1b637708cf.Ȫ Lnet/minecraft/util/Vec3;
      // 051: aload 0
      // 052: getfield x/oc1b637708cf.ҋ Lnet/minecraft/util/Vec3;
      // 055: aload 0
      // 056: getfield x/oc1b637708cf.ƃ F
      // 059: aload 0
      // 05a: getfield x/oc1b637708cf.Ĳ F
      // 05d: bipush 1
      // 05e: bipush 1
      // 05f: fconst_1
      // 060: new java/awt/Color
      // 063: dup
      // 064: aload 0
      // 065: invokevirtual x/oc1b637708cf.ɦ ()I
      // 068: invokespecial java/awt/Color.<init> (I)V
      // 06b: invokestatic x/ocd857ddc9c4.ğ (Lx/oc33e2bcdd33;Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;FFZZFLjava/awt/Color;)V
      // 06e: iload 3
      // 06f: ifeq 34c
      // 072: goto 076
      // 075: athrow
      // 076: aload 0
      // 077: iload 3
      // 078: ifne 08a
      // 07b: goto 07f
      // 07e: athrow
      // 07f: getfield x/oc1b637708cf.Ȍ I
      // 082: goto 086
      // 085: athrow
      // 086: ifle 097
      // 089: aload 0
      // 08a: dup
      // 08b: getfield x/oc1b637708cf.Ȍ I
      // 08e: bipush 1
      // 08f: isub
      // 090: dup_x1
      // 091: putfield x/oc1b637708cf.Ȍ I
      // 094: ifne 34c
      // 097: invokestatic x/oc02a3730b27.Μ ()Lnet/minecraft/entity/player/EntityPlayer;
      // 09a: astore 4
      // 09c: aload 0
      // 09d: aload 4
      // 09f: putfield x/oc1b637708cf.Đ Lnet/minecraft/entity/player/EntityPlayer;
      // 0a2: aload 0
      // 0a3: getfield x/oc1b637708cf.ξ Lx/ocf1568fef75;
      // 0a6: invokevirtual x/ocf1568fef75.ö ()D
      // 0a9: d2f
      // 0aa: fstore 5
      // 0ac: aload 0
      // 0ad: getfield x/oc1b637708cf.ξ Lx/ocf1568fef75;
      // 0b0: invokevirtual x/ocf1568fef75.і ()D
      // 0b3: d2f
      // 0b4: fstore 6
      // 0b6: aload 1
      // 0b7: invokevirtual x/oc6111f05032.я ()Z
      // 0ba: iload 3
      // 0bb: ifne 0d8
      // 0be: ifeq 1a3
      // 0c1: goto 0c5
      // 0c4: athrow
      // 0c5: aload 0
      // 0c6: ldc_w "require_mouse_pressed"
      // 0c9: iload 3
      // 0ca: ifne 0f6
      // 0cd: goto 0d1
      // 0d0: athrow
      // 0d1: invokevirtual x/oc1b637708cf.Ѳ (Ljava/lang/String;)Z
      // 0d4: goto 0d8
      // 0d7: athrow
      // 0d8: ifeq 0ee
      // 0db: aload 1
      // 0dc: invokestatic x/oc5d43ea95a2.Ы (Lx/oc6111f05032;)Z
      // 0df: iload 3
      // 0e0: ifne 0f9
      // 0e3: goto 0e7
      // 0e6: athrow
      // 0e7: ifeq 1a3
      // 0ea: goto 0ee
      // 0ed: athrow
      // 0ee: aload 0
      // 0ef: ldc_w "require_weapon"
      // 0f2: goto 0f6
      // 0f5: athrow
      // 0f6: invokevirtual x/oc1b637708cf.Ѳ (Ljava/lang/String;)Z
      // 0f9: iload 3
      // 0fa: ifne 139
      // 0fd: ifeq 11e
      // 100: goto 104
      // 103: athrow
      // 104: aload 0
      // 105: getfield x/oc1b637708cf.ɣ Lx/ocbd3640d420;
      // 108: aload 1
      // 109: invokevirtual x/oc6111f05032.ŭ ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 10c: invokevirtual x/ocbd3640d420.Ś (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // 10f: iload 3
      // 110: ifne 139
      // 113: goto 117
      // 116: athrow
      // 117: ifeq 1a3
      // 11a: goto 11e
      // 11d: athrow
      // 11e: aload 1
      // 11f: invokevirtual x/oc6111f05032.ŭ ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 122: iload 3
      // 123: ifne 149
      // 126: goto 12a
      // 129: athrow
      // 12a: getfield net/minecraft/client/entity/EntityPlayerSP.ticksExisted I
      // 12d: aload 1
      // 12e: invokevirtual x/oc6111f05032.ŭ ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 131: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getLastAttackerTime ()I
      // 134: isub
      // 135: goto 139
      // 138: athrow
      // 139: ldc_w -160726051
      // 13c: ldc_w -160726071
      // 13f: ixor
      // 140: if_icmpgt 1a3
      // 143: aload 4
      // 145: goto 149
      // 148: athrow
      // 149: iload 3
      // 14a: ifne 156
      // 14d: ifnull 1a3
      // 150: goto 154
      // 153: athrow
      // 154: aload 4
      // 156: getfield net/minecraft/entity/player/EntityPlayer.hurtTime I
      // 159: iload 3
      // 15a: ifne 183
      // 15d: i2f
      // 15e: aload 0
      // 15f: ldc_w "max_hurt_time"
      // 162: invokevirtual x/oc1b637708cf.ϡ (Ljava/lang/String;)F
      // 165: fcmpl
      // 166: ifgt 1a3
      // 169: goto 16d
      // 16c: athrow
      // 16d: fload 5
      // 16f: fload 5
      // 171: fmul
      // 172: f2d
      // 173: invokestatic x/oc02a3730b27.Ċ ()D
      // 176: iload 3
      // 177: ifne 193
      // 17a: goto 17e
      // 17d: athrow
      // 17e: dcmpl
      // 17f: goto 183
      // 182: athrow
      // 183: ifgt 1a3
      // 186: invokestatic x/oc02a3730b27.Ċ ()D
      // 189: fload 6
      // 18b: fload 6
      // 18d: fmul
      // 18e: f2d
      // 18f: goto 193
      // 192: athrow
      // 193: dcmpl
      // 194: iload 3
      // 195: ifne 1a0
      // 198: ifgt 1a3
      // 19b: goto 19f
      // 19e: athrow
      // 19f: bipush 1
      // 1a0: goto 1a4
      // 1a3: bipush 0
      // 1a4: istore 7
      // 1a6: iload 7
      // 1a8: iload 3
      // 1a9: ifne 1c3
      // 1ac: ifne 1e6
      // 1af: goto 1b3
      // 1b2: athrow
      // 1b3: aload 0
      // 1b4: iload 3
      // 1b5: ifne 1d9
      // 1b8: goto 1bc
      // 1bb: athrow
      // 1bc: getfield x/oc1b637708cf.P Z
      // 1bf: goto 1c3
      // 1c2: athrow
      // 1c3: ifeq 1d8
      // 1c6: aload 0
      // 1c7: aload 0
      // 1c8: ldc_w "cooldown"
      // 1cb: invokevirtual x/oc1b637708cf.ϡ (Ljava/lang/String;)F
      // 1ce: invokestatic x/oc30e402796f.ý (F)I
      // 1d1: putfield x/oc1b637708cf.Ȍ I
      // 1d4: goto 1d8
      // 1d7: athrow
      // 1d8: aload 0
      // 1d9: aload 0
      // 1da: bipush 0
      // 1db: dup_x1
      // 1dc: putfield x/oc1b637708cf.ͽ Z
      // 1df: putfield x/oc1b637708cf.P Z
      // 1e2: iload 3
      // 1e3: ifeq 34c
      // 1e6: aload 1
      // 1e7: invokevirtual x/oc6111f05032.ŭ ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1ea: invokestatic x/oceb15b1dc5f.z (Lnet/minecraft/entity/Entity;)Lnet/minecraft/util/Vec3;
      // 1ed: astore 8
      // 1ef: aload 4
      // 1f1: invokestatic x/oceb15b1dc5f.Ț (Lnet/minecraft/entity/Entity;)Lnet/minecraft/util/Vec3;
      // 1f4: astore 9
      // 1f6: aload 0
      // 1f7: getfield x/oc1b637708cf.Ɋ I
      // 1fa: istore 10
      // 1fc: aload 0
      // 1fd: aload 4
      // 1ff: invokevirtual net/minecraft/entity/player/EntityPlayer.getEntityId ()I
      // 202: putfield x/oc1b637708cf.Ɋ I
      // 205: aload 0
      // 206: aload 1
      // 207: invokevirtual x/oc6111f05032.ŭ ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 20a: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getEntityId ()I
      // 20d: putfield x/oc1b637708cf.Ӕ I
      // 210: aload 0
      // 211: iload 3
      // 212: ifne 2ac
      // 215: aload 0
      // 216: ldc_w "flush_on_hit"
      // 219: invokevirtual x/oc1b637708cf.Ѳ (Ljava/lang/String;)Z
      // 21c: putfield x/oc1b637708cf.ϩ Z
      // 21f: aload 0
      // 220: getfield x/oc1b637708cf.P Z
      // 223: ifne 2a7
      // 226: goto 22a
      // 229: athrow
      // 22a: ldc2_w 0.01
      // 22d: aload 8
      // 22f: aload 9
      // 231: invokestatic x/oc497d0cdf29.Ż (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)D
      // 234: aload 8
      // 236: aload 4
      // 238: invokestatic x/oceb15b1dc5f.z (Lnet/minecraft/entity/Entity;)Lnet/minecraft/util/Vec3;
      // 23b: invokestatic x/oc497d0cdf29.Ż (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)D
      // 23e: dsub
      // 23f: dcmpg
      // 240: iflt 254
      // 243: goto 247
      // 246: athrow
      // 247: aload 0
      // 248: bipush 0
      // 249: putfield x/oc1b637708cf.ͽ Z
      // 24c: iload 3
      // 24d: ifeq 34c
      // 250: goto 254
      // 253: athrow
      // 254: aload 0
      // 255: invokevirtual x/oc1b637708cf.J ()V
      // 258: iload 3
      // 259: aload 0
      // 25a: bipush 1
      // 25b: putfield x/oc1b637708cf.P Z
      // 25e: aload 0
      // 25f: invokestatic x/oc1b637708cf.Ϧ ()Lnet/minecraft/util/Vec3;
      // 262: putfield x/oc1b637708cf.ɬ Lnet/minecraft/util/Vec3;
      // 265: aload 0
      // 266: aload 0
      // 267: bipush 0
      // 268: dup_x1
      // 269: putfield x/oc1b637708cf.İ Z
      // 26c: putfield x/oc1b637708cf.ӣ Z
      // 26f: aload 0
      // 270: aload 0
      // 271: aload 0
      // 272: aload 4
      // 274: invokestatic x/oceb15b1dc5f.z (Lnet/minecraft/entity/Entity;)Lnet/minecraft/util/Vec3;
      // 277: dup_x1
      // 278: putfield x/oc1b637708cf.d Lnet/minecraft/util/Vec3;
      // 27b: dup_x1
      // 27c: putfield x/oc1b637708cf.ҋ Lnet/minecraft/util/Vec3;
      // 27f: putfield x/oc1b637708cf.Ȫ Lnet/minecraft/util/Vec3;
      // 282: aload 0
      // 283: aload 0
      // 284: aload 0
      // 285: aload 4
      // 287: getfield net/minecraft/entity/player/EntityPlayer.rotationYaw F
      // 28a: dup_x1
      // 28b: putfield x/oc1b637708cf.Ƥ F
      // 28e: dup_x1
      // 28f: putfield x/oc1b637708cf.Ĳ F
      // 292: putfield x/oc1b637708cf.ƃ F
      // 295: aload 0
      // 296: aload 0
      // 297: ldc_w "render_remote_pos"
      // 29a: invokevirtual x/oc1b637708cf.Ѳ (Ljava/lang/String;)Z
      // 29d: putfield x/oc1b637708cf.ͽ Z
      // 2a0: ifeq 34c
      // 2a3: goto 2a7
      // 2a6: athrow
      // 2a7: aload 0
      // 2a8: goto 2ac
      // 2ab: athrow
      // 2ac: iload 3
      // 2ad: ifne 2c3
      // 2b0: getfield x/oc1b637708cf.ӣ Z
      // 2b3: ifeq 2c2
      // 2b6: goto 2ba
      // 2b9: athrow
      // 2ba: aload 0
      // 2bb: getfield x/oc1b637708cf.ɬ Lnet/minecraft/util/Vec3;
      // 2be: goto 2cb
      // 2c1: athrow
      // 2c2: aload 0
      // 2c3: getfield x/oc1b637708cf.ɬ Lnet/minecraft/util/Vec3;
      // 2c6: aload 9
      // 2c8: invokevirtual net/minecraft/util/Vec3.add (Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/Vec3;
      // 2cb: astore 11
      // 2cd: iload 3
      // 2ce: ifne 33e
      // 2d1: ldc2_w -0.05
      // 2d4: aload 8
      // 2d6: aload 9
      // 2d8: aload 11
      // 2da: invokestatic x/oc1b637708cf.Ș (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)D
      // 2dd: dcmpl
      // 2de: ifgt 31f
      // 2e1: goto 2e5
      // 2e4: athrow
      // 2e5: iload 10
      // 2e7: aload 0
      // 2e8: getfield x/oc1b637708cf.Ɋ I
      // 2eb: if_icmpne 31f
      // 2ee: goto 2f2
      // 2f1: athrow
      // 2f2: aload 0
      // 2f3: aload 11
      // 2f5: aload 0
      // 2f6: iload 3
      // 2f7: ifne 30d
      // 2fa: goto 2fe
      // 2fd: athrow
      // 2fe: getfield x/oc1b637708cf.İ Z
      // 301: ifeq 313
      // 304: goto 308
      // 307: athrow
      // 308: aload 0
      // 309: goto 30d
      // 30c: athrow
      // 30d: getfield x/oc1b637708cf.Ԇ F
      // 310: goto 318
      // 313: aload 4
      // 315: getfield net/minecraft/entity/player/EntityPlayer.rotationYaw F
      // 318: invokevirtual x/oc1b637708cf.ǻ (Lnet/minecraft/util/Vec3;F)V
      // 31b: iload 3
      // 31c: ifeq 34c
      // 31f: aload 0
      // 320: invokestatic x/oc1b637708cf.Ϧ ()Lnet/minecraft/util/Vec3;
      // 323: putfield x/oc1b637708cf.ɬ Lnet/minecraft/util/Vec3;
      // 326: aload 0
      // 327: aload 0
      // 328: bipush 0
      // 329: dup_x1
      // 32a: putfield x/oc1b637708cf.İ Z
      // 32d: putfield x/oc1b637708cf.ӣ Z
      // 330: aload 0
      // 331: aload 0
      // 332: bipush 0
      // 333: dup_x1
      // 334: putfield x/oc1b637708cf.ͽ Z
      // 337: putfield x/oc1b637708cf.P Z
      // 33a: goto 33e
      // 33d: athrow
      // 33e: aload 0
      // 33f: aload 0
      // 340: ldc_w "cooldown"
      // 343: invokevirtual x/oc1b637708cf.ϡ (Ljava/lang/String;)F
      // 346: invokestatic x/oc30e402796f.ý (F)I
      // 349: putfield x/oc1b637708cf.Ȍ I
      // 34c: return
   }

   private void J() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: aload 0
      // 04: getfield x/oc1b637708cf.Л Lx/oca9cc61aada;
      // 07: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0a: aload 0
      // 0b: getfield x/oc1b637708cf.Ϗ Lx/oca9cc61aada;
      // 0e: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 11: invokestatic java/lang/Math.min (DD)D
      // 14: d2i
      // 15: istore 2
      // 16: aload 0
      // 17: getfield x/oc1b637708cf.Л Lx/oca9cc61aada;
      // 1a: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 1d: aload 0
      // 1e: getfield x/oc1b637708cf.Ϗ Lx/oca9cc61aada;
      // 21: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 24: invokestatic java/lang/Math.max (DD)D
      // 27: d2i
      // 28: istore 3
      // 29: istore 1
      // 2a: aload 0
      // 2b: iload 2
      // 2c: iload 1
      // 2d: ifne 4b
      // 30: iload 3
      // 31: if_icmpne 3e
      // 34: goto 38
      // 37: athrow
      // 38: iload 2
      // 39: i2l
      // 3a: goto 4c
      // 3d: athrow
      // 3e: iload 2
      // 3f: invokestatic java/lang/Math.random ()D
      // 42: iload 3
      // 43: iload 2
      // 44: isub
      // 45: bipush 1
      // 46: iadd
      // 47: i2d
      // 48: dmul
      // 49: d2i
      // 4a: iadd
      // 4b: i2l
      // 4c: putfield x/oc1b637708cf.Ÿ J
      // 4f: return
   }

   public static double Ș(Vec3 var0, Vec3 var1, Vec3 var2) {
      return oc497d0cdf29.Ż(var0, var2) - oc497d0cdf29.Ż(var0, var1);
   }

   public synchronized void ε(oc33e2bcdd33 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 2
      // 004: aload 0
      // 005: getfield x/oc1b637708cf.P Z
      // 008: iload 2
      // 009: ifne 026
      // 00c: ifeq 167
      // 00f: goto 013
      // 012: athrow
      // 013: aload 1
      // 014: getfield x/oc33e2bcdd33.ԉ Lnet/minecraft/network/Packet;
      // 017: iload 2
      // 018: ifne 05f
      // 01b: goto 01f
      // 01e: athrow
      // 01f: instanceof net/minecraft/network/play/server/S19PacketEntityStatus
      // 022: goto 026
      // 025: athrow
      // 026: ifeq 053
      // 029: aload 1
      // 02a: iload 2
      // 02b: ifne 08c
      // 02e: goto 032
      // 031: athrow
      // 032: getfield x/oc33e2bcdd33.ԉ Lnet/minecraft/network/Packet;
      // 035: checkcast net/minecraft/network/play/server/S19PacketEntityStatus
      // 038: invokestatic x/oc756c7feb5c.Ó (Lnet/minecraft/network/play/server/S19PacketEntityStatus;)I
      // 03b: aload 0
      // 03c: getfield x/oc1b637708cf.Ɋ I
      // 03f: if_icmpne 08b
      // 042: goto 046
      // 045: athrow
      // 046: aload 1
      // 047: ldc_w 1848012205
      // 04a: ldc_w 1848012206
      // 04d: ixor
      // 04e: putfield x/oc33e2bcdd33.ҹ I
      // 051: return
      // 052: athrow
      // 053: aload 1
      // 054: iload 2
      // 055: ifne 080
      // 058: getfield x/oc33e2bcdd33.ԉ Lnet/minecraft/network/Packet;
      // 05b: goto 05f
      // 05e: athrow
      // 05f: instanceof net/minecraft/network/play/server/S06PacketUpdateHealth
      // 062: ifne 07b
      // 065: aload 1
      // 066: iload 2
      // 067: ifne 08c
      // 06a: goto 06e
      // 06d: athrow
      // 06e: getfield x/oc33e2bcdd33.ԉ Lnet/minecraft/network/Packet;
      // 071: instanceof net/minecraft/network/play/server/S29PacketSoundEffect
      // 074: ifeq 08b
      // 077: goto 07b
      // 07a: athrow
      // 07b: aload 1
      // 07c: goto 080
      // 07f: athrow
      // 080: ldc_w 1848012205
      // 083: ldc_w 1848012206
      // 086: ixor
      // 087: putfield x/oc33e2bcdd33.ҹ I
      // 08a: return
      // 08b: aload 1
      // 08c: iload 2
      // 08d: ifne 0d5
      // 090: getfield x/oc33e2bcdd33.ԉ Lnet/minecraft/network/Packet;
      // 093: instanceof net/minecraft/network/play/server/S12PacketEntityVelocity
      // 096: ifeq 0d4
      // 099: goto 09d
      // 09c: athrow
      // 09d: aload 0
      // 09e: getfield x/oc1b637708cf.ϩ Z
      // 0a1: iload 2
      // 0a2: ifne 0fe
      // 0a5: goto 0a9
      // 0a8: athrow
      // 0a9: ifeq 0ed
      // 0ac: goto 0b0
      // 0af: athrow
      // 0b0: aload 1
      // 0b1: iload 2
      // 0b2: ifne 0ee
      // 0b5: goto 0b9
      // 0b8: athrow
      // 0b9: getfield x/oc33e2bcdd33.ԉ Lnet/minecraft/network/Packet;
      // 0bc: checkcast net/minecraft/network/play/server/S12PacketEntityVelocity
      // 0bf: invokevirtual net/minecraft/network/play/server/S12PacketEntityVelocity.getEntityID ()I
      // 0c2: aload 0
      // 0c3: getfield x/oc1b637708cf.Ӕ I
      // 0c6: if_icmpne 0ed
      // 0c9: goto 0cd
      // 0cc: athrow
      // 0cd: aload 0
      // 0ce: bipush 0
      // 0cf: putfield x/oc1b637708cf.P Z
      // 0d2: return
      // 0d3: athrow
      // 0d4: aload 1
      // 0d5: iload 2
      // 0d6: ifne 0ee
      // 0d9: getfield x/oc33e2bcdd33.ԉ Lnet/minecraft/network/Packet;
      // 0dc: instanceof net/minecraft/network/play/server/S08PacketPlayerPosLook
      // 0df: ifeq 0ed
      // 0e2: goto 0e6
      // 0e5: athrow
      // 0e6: aload 0
      // 0e7: bipush 0
      // 0e8: putfield x/oc1b637708cf.P Z
      // 0eb: return
      // 0ec: athrow
      // 0ed: aload 1
      // 0ee: iload 2
      // 0ef: ifne 138
      // 0f2: getfield x/oc33e2bcdd33.р J
      // 0f5: aload 0
      // 0f6: getfield x/oc1b637708cf.Ÿ J
      // 0f9: lcmp
      // 0fa: goto 0fe
      // 0fd: athrow
      // 0fe: ifgt 133
      // 101: aload 1
      // 102: bipush 1
      // 103: putfield x/oc33e2bcdd33.ҹ I
      // 106: iload 2
      // 107: ifne 12f
      // 10a: goto 10e
      // 10d: athrow
      // 10e: aload 1
      // 10f: getfield x/oc33e2bcdd33.ǧ I
      // 112: aload 0
      // 113: getfield x/oc1b637708cf.Ճ I
      // 116: if_icmple 167
      // 119: goto 11d
      // 11c: athrow
      // 11d: aload 0
      // 11e: aload 1
      // 11f: getfield x/oc33e2bcdd33.ǧ I
      // 122: putfield x/oc1b637708cf.Ճ I
      // 125: aload 0
      // 126: aload 1
      // 127: bipush 0
      // 128: invokevirtual x/oc1b637708cf.ω (Lx/oc33e2bcdd33;Z)V
      // 12b: goto 12f
      // 12e: athrow
      // 12f: iload 2
      // 130: ifeq 167
      // 133: aload 1
      // 134: goto 138
      // 137: athrow
      // 138: iload 2
      // 139: ifne 14b
      // 13c: getfield x/oc33e2bcdd33.ҹ I
      // 13f: ifne 167
      // 142: goto 146
      // 145: athrow
      // 146: aload 1
      // 147: goto 14b
      // 14a: athrow
      // 14b: getfield x/oc33e2bcdd33.ǧ I
      // 14e: aload 0
      // 14f: getfield x/oc1b637708cf.ӗ I
      // 152: if_icmple 167
      // 155: aload 0
      // 156: aload 1
      // 157: bipush 1
      // 158: invokevirtual x/oc1b637708cf.ω (Lx/oc33e2bcdd33;Z)V
      // 15b: aload 0
      // 15c: aload 1
      // 15d: getfield x/oc33e2bcdd33.ǧ I
      // 160: putfield x/oc1b637708cf.ӗ I
      // 163: goto 167
      // 166: athrow
      // 167: return
   }

   private void ω(oc33e2bcdd33 param1, boolean param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 3
      // 004: iload 2
      // 005: iload 3
      // 006: ifne 032
      // 009: ifeq 027
      // 00c: goto 010
      // 00f: athrow
      // 010: aload 0
      // 011: getfield x/oc1b637708cf.Ɉ I
      // 014: iload 3
      // 015: ifne 032
      // 018: goto 01c
      // 01b: athrow
      // 01c: aload 1
      // 01d: getfield x/oc33e2bcdd33.ǧ I
      // 020: if_icmpgt 1b9
      // 023: goto 027
      // 026: athrow
      // 027: aload 1
      // 028: getfield x/oc33e2bcdd33.ԉ Lnet/minecraft/network/Packet;
      // 02b: instanceof net/minecraft/network/play/server/S14PacketEntity
      // 02e: goto 032
      // 031: athrow
      // 032: istore 4
      // 034: iload 4
      // 036: iload 3
      // 037: ifne 059
      // 03a: ifne 057
      // 03d: goto 041
      // 040: athrow
      // 041: aload 1
      // 042: getfield x/oc33e2bcdd33.ԉ Lnet/minecraft/network/Packet;
      // 045: instanceof net/minecraft/network/play/server/S18PacketEntityTeleport
      // 048: iload 3
      // 049: ifne 059
      // 04c: goto 050
      // 04f: athrow
      // 050: ifeq 1b9
      // 053: goto 057
      // 056: athrow
      // 057: iload 4
      // 059: ifeq 067
      // 05c: aload 1
      // 05d: getfield x/oc33e2bcdd33.ԉ Lnet/minecraft/network/Packet;
      // 060: checkcast net/minecraft/network/play/server/S14PacketEntity
      // 063: goto 068
      // 066: athrow
      // 067: aconst_null
      // 068: astore 5
      // 06a: iload 4
      // 06c: ifeq 074
      // 06f: aconst_null
      // 070: goto 07b
      // 073: athrow
      // 074: aload 1
      // 075: getfield x/oc33e2bcdd33.ԉ Lnet/minecraft/network/Packet;
      // 078: checkcast net/minecraft/network/play/server/S18PacketEntityTeleport
      // 07b: astore 6
      // 07d: iload 4
      // 07f: iload 3
      // 080: ifne 093
      // 083: ifeq 096
      // 086: goto 08a
      // 089: athrow
      // 08a: aload 5
      // 08c: invokestatic x/oc756c7feb5c.ƍ (Lnet/minecraft/network/play/server/S14PacketEntity;)I
      // 08f: goto 093
      // 092: athrow
      // 093: goto 09b
      // 096: aload 6
      // 098: invokevirtual net/minecraft/network/play/server/S18PacketEntityTeleport.getEntityId ()I
      // 09b: aload 0
      // 09c: getfield x/oc1b637708cf.Ɋ I
      // 09f: if_icmpne 1b9
      // 0a2: iload 4
      // 0a4: ifeq 0d4
      // 0a7: goto 0ab
      // 0aa: athrow
      // 0ab: new net/minecraft/util/Vec3
      // 0ae: dup
      // 0af: aload 5
      // 0b1: invokevirtual net/minecraft/network/play/server/S14PacketEntity.func_149062_c ()B
      // 0b4: i2d
      // 0b5: ldc2_w 0.03125
      // 0b8: dmul
      // 0b9: aload 5
      // 0bb: invokevirtual net/minecraft/network/play/server/S14PacketEntity.func_149061_d ()B
      // 0be: i2d
      // 0bf: ldc2_w 0.03125
      // 0c2: dmul
      // 0c3: aload 5
      // 0c5: invokevirtual net/minecraft/network/play/server/S14PacketEntity.func_149064_e ()B
      // 0c8: i2d
      // 0c9: ldc2_w 0.03125
      // 0cc: dmul
      // 0cd: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 0d0: goto 0f9
      // 0d3: athrow
      // 0d4: new net/minecraft/util/Vec3
      // 0d7: dup
      // 0d8: aload 6
      // 0da: invokevirtual net/minecraft/network/play/server/S18PacketEntityTeleport.getX ()I
      // 0dd: i2d
      // 0de: ldc2_w 0.03125
      // 0e1: dmul
      // 0e2: aload 6
      // 0e4: invokevirtual net/minecraft/network/play/server/S18PacketEntityTeleport.getY ()I
      // 0e7: i2d
      // 0e8: ldc2_w 0.03125
      // 0eb: dmul
      // 0ec: aload 6
      // 0ee: invokevirtual net/minecraft/network/play/server/S18PacketEntityTeleport.getZ ()I
      // 0f1: i2d
      // 0f2: ldc2_w 0.03125
      // 0f5: dmul
      // 0f6: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 0f9: astore 7
      // 0fb: iload 2
      // 0fc: iload 3
      // 0fd: ifne 138
      // 100: ifeq 132
      // 103: goto 107
      // 106: athrow
      // 107: aload 0
      // 108: iload 3
      // 109: ifne 12a
      // 10c: goto 110
      // 10f: athrow
      // 110: aload 0
      // 111: getfield x/oc1b637708cf.ɬ Lnet/minecraft/util/Vec3;
      // 114: aload 7
      // 116: invokevirtual net/minecraft/util/Vec3.subtract (Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/Vec3;
      // 119: putfield x/oc1b637708cf.ɬ Lnet/minecraft/util/Vec3;
      // 11c: iload 4
      // 11e: ifne 1b9
      // 121: goto 125
      // 124: athrow
      // 125: aload 0
      // 126: goto 12a
      // 129: athrow
      // 12a: bipush 0
      // 12b: putfield x/oc1b637708cf.ӣ Z
      // 12e: iload 3
      // 12f: ifeq 1b9
      // 132: iload 4
      // 134: goto 138
      // 137: athrow
      // 138: iload 3
      // 139: ifne 161
      // 13c: ifeq 165
      // 13f: goto 143
      // 142: athrow
      // 143: aload 0
      // 144: iload 3
      // 145: ifne 171
      // 148: goto 14c
      // 14b: athrow
      // 14c: aload 0
      // 14d: getfield x/oc1b637708cf.ɬ Lnet/minecraft/util/Vec3;
      // 150: aload 7
      // 152: invokevirtual net/minecraft/util/Vec3.add (Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/Vec3;
      // 155: putfield x/oc1b637708cf.ɬ Lnet/minecraft/util/Vec3;
      // 158: aload 5
      // 15a: invokevirtual net/minecraft/network/play/server/S14PacketEntity.func_149060_h ()Z
      // 15d: goto 161
      // 160: athrow
      // 161: ifne 170
      // 164: return
      // 165: aload 0
      // 166: aload 7
      // 168: putfield x/oc1b637708cf.ɬ Lnet/minecraft/util/Vec3;
      // 16b: aload 0
      // 16c: bipush 1
      // 16d: putfield x/oc1b637708cf.ӣ Z
      // 170: aload 0
      // 171: iload 4
      // 173: iload 3
      // 174: ifne 187
      // 177: ifeq 18a
      // 17a: goto 17e
      // 17d: athrow
      // 17e: aload 5
      // 180: invokevirtual net/minecraft/network/play/server/S14PacketEntity.func_149066_f ()B
      // 183: goto 187
      // 186: athrow
      // 187: goto 18f
      // 18a: aload 6
      // 18c: invokevirtual net/minecraft/network/play/server/S18PacketEntityTeleport.getYaw ()B
      // 18f: i2f
      // 190: ldc_w 360.0
      // 193: fmul
      // 194: ldc_w 0.00390625
      // 197: fmul
      // 198: putfield x/oc1b637708cf.Ԇ F
      // 19b: aload 0
      // 19c: iload 3
      // 19d: ifne 1b2
      // 1a0: bipush 1
      // 1a1: putfield x/oc1b637708cf.İ Z
      // 1a4: iload 4
      // 1a6: ifne 1b9
      // 1a9: goto 1ad
      // 1ac: athrow
      // 1ad: aload 0
      // 1ae: goto 1b2
      // 1b1: athrow
      // 1b2: aload 1
      // 1b3: getfield x/oc33e2bcdd33.ǧ I
      // 1b6: putfield x/oc1b637708cf.Ɉ I
      // 1b9: return
   }

   private void ǻ(Vec3 param1, float param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 3
      // 04: aload 0
      // 05: iload 3
      // 06: ifne 2d
      // 09: getfield x/oc1b637708cf.d Lnet/minecraft/util/Vec3;
      // 0c: aload 1
      // 0d: invokestatic x/oc1b637708cf.ӑ (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Z
      // 10: ifeq 2c
      // 13: goto 17
      // 16: athrow
      // 17: fload 2
      // 18: aload 0
      // 19: getfield x/oc1b637708cf.Ƥ F
      // 1c: fcmpl
      // 1d: iload 3
      // 1e: ifne 5d
      // 21: goto 25
      // 24: athrow
      // 25: ifeq 37
      // 28: goto 2c
      // 2b: athrow
      // 2c: aload 0
      // 2d: ldc_w 313430360
      // 30: ldc_w 313430363
      // 33: ixor
      // 34: putfield x/oc1b637708cf.կ I
      // 37: aload 0
      // 38: iload 3
      // 39: ifne 66
      // 3c: aload 1
      // 3d: putfield x/oc1b637708cf.d Lnet/minecraft/util/Vec3;
      // 40: aload 0
      // 41: aload 0
      // 42: getfield x/oc1b637708cf.ҋ Lnet/minecraft/util/Vec3;
      // 45: putfield x/oc1b637708cf.Ȫ Lnet/minecraft/util/Vec3;
      // 48: aload 0
      // 49: aload 0
      // 4a: getfield x/oc1b637708cf.Ĳ F
      // 4d: putfield x/oc1b637708cf.ƃ F
      // 50: aload 0
      // 51: fload 2
      // 52: putfield x/oc1b637708cf.Ƥ F
      // 55: aload 0
      // 56: getfield x/oc1b637708cf.կ I
      // 59: goto 5d
      // 5c: athrow
      // 5d: bipush 1
      // 5e: if_icmpge 6e
      // 61: aload 0
      // 62: goto 66
      // 65: athrow
      // 66: aload 1
      // 67: putfield x/oc1b637708cf.ҋ Lnet/minecraft/util/Vec3;
      // 6a: iload 3
      // 6b: ifeq b0
      // 6e: dconst_1
      // 6f: aload 0
      // 70: getfield x/oc1b637708cf.կ I
      // 73: i2d
      // 74: ddiv
      // 75: dstore 4
      // 77: aload 0
      // 78: aload 0
      // 79: getfield x/oc1b637708cf.ҋ Lnet/minecraft/util/Vec3;
      // 7c: aload 1
      // 7d: aload 0
      // 7e: getfield x/oc1b637708cf.ҋ Lnet/minecraft/util/Vec3;
      // 81: invokevirtual net/minecraft/util/Vec3.subtract (Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/Vec3;
      // 84: dload 4
      // 86: invokestatic x/oc8166ebfe33.Q (Lnet/minecraft/util/Vec3;D)Lnet/minecraft/util/Vec3;
      // 89: invokevirtual net/minecraft/util/Vec3.add (Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/Vec3;
      // 8c: putfield x/oc1b637708cf.ҋ Lnet/minecraft/util/Vec3;
      // 8f: aload 0
      // 90: getfield x/oc1b637708cf.Ƥ F
      // 93: aload 0
      // 94: getfield x/oc1b637708cf.Ĳ F
      // 97: fsub
      // 98: invokestatic x/oc497d0cdf29.Ը (F)F
      // 9b: f2d
      // 9c: dload 4
      // 9e: dmul
      // 9f: d2f
      // a0: aload 0
      // a1: getfield x/oc1b637708cf.Ĳ F
      // a4: fadd
      // a5: fstore 2
      // a6: aload 0
      // a7: dup
      // a8: getfield x/oc1b637708cf.կ I
      // ab: bipush 1
      // ac: isub
      // ad: putfield x/oc1b637708cf.կ I
      // b0: aload 0
      // b1: fload 2
      // b2: putfield x/oc1b637708cf.Ĳ F
      // b5: return
   }

   private static boolean ӑ(Vec3 param0, Vec3 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 2
      // 04: aload 0
      // 05: getfield net/minecraft/util/Vec3.xCoord D
      // 08: iload 2
      // 09: ifne 2a
      // 0c: invokestatic java/lang/Double.doubleToRawLongBits (D)J
      // 0f: aload 1
      // 10: getfield net/minecraft/util/Vec3.xCoord D
      // 13: invokestatic java/lang/Double.doubleToRawLongBits (D)J
      // 16: lcmp
      // 17: ifne 5a
      // 1a: goto 1e
      // 1d: athrow
      // 1e: aload 0
      // 1f: getfield net/minecraft/util/Vec3.yCoord D
      // 22: iload 2
      // 23: ifne 40
      // 26: goto 2a
      // 29: athrow
      // 2a: invokestatic java/lang/Double.doubleToRawLongBits (D)J
      // 2d: aload 1
      // 2e: getfield net/minecraft/util/Vec3.yCoord D
      // 31: invokestatic java/lang/Double.doubleToRawLongBits (D)J
      // 34: lcmp
      // 35: ifne 5a
      // 38: aload 0
      // 39: getfield net/minecraft/util/Vec3.zCoord D
      // 3c: goto 40
      // 3f: athrow
      // 40: invokestatic java/lang/Double.doubleToRawLongBits (D)J
      // 43: aload 1
      // 44: getfield net/minecraft/util/Vec3.zCoord D
      // 47: invokestatic java/lang/Double.doubleToRawLongBits (D)J
      // 4a: lcmp
      // 4b: iload 2
      // 4c: ifne 57
      // 4f: ifne 5a
      // 52: goto 56
      // 55: athrow
      // 56: bipush 1
      // 57: goto 5b
      // 5a: bipush 0
      // 5b: ireturn
   }

   private static Vec3 Ϧ() {
      return new Vec3(0.0, 0.0, 0.0);
   }

   public synchronized void ŭ(oc6111f05032 var1) {
      this.ʄ();
   }

   private void ʄ() {
      this.P = this.ϩ = this.ӣ = this.İ = this.ͽ = false;
      this.Ɋ = this.Ӕ = this.Ȍ = this.Ճ = this.ӗ = this.Ɉ = this.կ = 0;
      this.Ÿ = 0L;
      this.ɬ = this.Ȫ = this.ҋ = this.d = Ϧ();
      this.Ԇ = this.ƃ = this.Ĳ = this.Ƥ = 0.0F;
   }
}

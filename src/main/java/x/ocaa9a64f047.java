package x;

import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class ocaa9a64f047 extends oc69da1aa7f5 {
   private oca9cc61aada Ѐ;
   private oca9cc61aada Ǧ;
   private oca9cc61aada ǰ;
   private oca9cc61aada ά;
   private oca9cc61aada Θ;
   private oca9cc61aada Ц;
   private occ2f8dff8d8 Ƭ;
   private occ2f8dff8d8 Ć;
   private occ2f8dff8d8 ϧ;
   private occ2f8dff8d8 ƥ;
   private static final String[] Ǐ;
   public static int Ź;

   public ocaa9a64f047() {
      super("Aim Assist", oce4cea752dd.ȁ);
      this.ą("Helps aim at nearby targets within your FOV.");
      this.ʌ(this.Ѐ = new oca9cc61aada("Mode", 0, Ǐ));
      this.ʌ(this.Ǧ = new oca9cc61aada("Speed", 10.0, 1.0, 30.0, 1.0));
      this.z$1k81rl22ylo65(this.ǰ = new oca9cc61aada("Aim point", "%", 0.0, 0.0, 100.0, 1.0, "Multipoint horizontal"), "setting.multipointHorizontal");
      this.z$1k81rl22ylo65(this.ά = new oca9cc61aada("Humanization", "%", 50.0, 0.0, 100.0, 1.0, "Randomization"), "setting.randomization");
      this.ʌ(this.Θ = new oca9cc61aada("FOV", 90.0, 15.0, 360.0, 1.0));
      this.ʌ(this.Ц = new oca9cc61aada("Range", 4.5, 0.0, 5.0, 0.1));
      String[] var10006 = new String[943176289 ^ 943176291];
      var10006[0] = "Require mouse";
      var10006[1] = "Condition.Require mouse";
      this.z$1k81rl22ylo65(this.Ƭ = new occ2f8dff8d8("Require attack", true, var10006), "setting.clickAim");
      this.ʌ(this.Ć = new occ2f8dff8d8("Pause when break", true));
      var10006 = new String[943176289 ^ 943176291];
      var10006[0] = "Ignore behind walls";
      var10006[1] = "Targets.Ignore behind walls";
      this.z$1k81rl22ylo65(this.ƥ = new occ2f8dff8d8("Visible targets only", false, var10006), "setting.ignoreBehindWalls");
      this.ʌ(this.ϧ = new occ2f8dff8d8("Ignore teammates", true));
   }

   @Override
   public String getInfo() {
      return Ǐ[(int)this.Ѐ.Ӂ()];
   }

   public Entity ŷ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 1
      // 04: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 07: ifne 0d
      // 0a: aconst_null
      // 0b: areturn
      // 0c: athrow
      // 0d: getstatic x/oc9755810e45.ϔ Lx/oc8edd24b1ed;
      // 10: iload 1
      // 11: ifne 1e
      // 14: ifnull 27
      // 17: goto 1b
      // 1a: athrow
      // 1b: getstatic x/oc9755810e45.ϔ Lx/oc8edd24b1ed;
      // 1e: invokevirtual x/oc8edd24b1ed.φ ()Z
      // 21: ifeq 27
      // 24: aconst_null
      // 25: areturn
      // 26: athrow
      // 27: getstatic x/oc9755810e45.ÿ Lx/ocdd342096f8;
      // 2a: iload 1
      // 2b: ifne 38
      // 2e: ifnull 53
      // 31: goto 35
      // 34: athrow
      // 35: getstatic x/oc9755810e45.ÿ Lx/ocdd342096f8;
      // 38: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 3b: iload 1
      // 3c: ifne 5f
      // 3f: ifeq 53
      // 42: goto 46
      // 45: athrow
      // 46: getstatic x/ocdd342096f8.f Lnet/minecraft/entity/EntityLivingBase;
      // 49: ifnull 53
      // 4c: goto 50
      // 4f: athrow
      // 50: aconst_null
      // 51: areturn
      // 52: athrow
      // 53: aload 0
      // 54: iload 1
      // 55: ifne 66
      // 58: invokevirtual x/ocaa9a64f047.Г ()Z
      // 5b: goto 5f
      // 5e: athrow
      // 5f: ifne 65
      // 62: aconst_null
      // 63: areturn
      // 64: athrow
      // 65: aload 0
      // 66: aload 0
      // 67: getfield x/ocaa9a64f047.Ѐ Lx/oca9cc61aada;
      // 6a: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 6d: dconst_1
      // 6e: dcmpl
      // 6f: iload 1
      // 70: ifne 7b
      // 73: ifne 7e
      // 76: goto 7a
      // 79: athrow
      // 7a: bipush 1
      // 7b: goto 7f
      // 7e: bipush 0
      // 7f: invokevirtual x/ocaa9a64f047.œ (Z)Lnet/minecraft/entity/Entity;
      // 82: areturn
   }

   public EntityPlayer ʃ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: aload 0
      // 04: invokevirtual x/ocaa9a64f047.ŷ ()Lnet/minecraft/entity/Entity;
      // 07: astore 2
      // 08: istore 1
      // 09: aload 2
      // 0a: iload 1
      // 0b: ifne 1d
      // 0e: instanceof net/minecraft/entity/player/EntityPlayer
      // 11: ifeq 23
      // 14: goto 18
      // 17: athrow
      // 18: aload 2
      // 19: goto 1d
      // 1c: athrow
      // 1d: checkcast net/minecraft/entity/player/EntityPlayer
      // 20: goto 24
      // 23: aconst_null
      // 24: areturn
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.NORMAL
   )
   public void ҩ(oc86de9e2892 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc5e549848f3.İ I
      // 003: istore 2
      // 004: getstatic x/oc9755810e45.ϔ Lx/oc8edd24b1ed;
      // 007: iload 2
      // 008: ifne 015
      // 00b: ifnull 01d
      // 00e: goto 012
      // 011: athrow
      // 012: getstatic x/oc9755810e45.ϔ Lx/oc8edd24b1ed;
      // 015: invokevirtual x/oc8edd24b1ed.φ ()Z
      // 018: ifeq 01d
      // 01b: return
      // 01c: athrow
      // 01d: getstatic x/oc9755810e45.ÿ Lx/ocdd342096f8;
      // 020: iload 2
      // 021: ifne 02e
      // 024: ifnull 048
      // 027: goto 02b
      // 02a: athrow
      // 02b: getstatic x/oc9755810e45.ÿ Lx/ocdd342096f8;
      // 02e: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 031: iload 2
      // 032: ifne 059
      // 035: ifeq 048
      // 038: goto 03c
      // 03b: athrow
      // 03c: getstatic x/ocdd342096f8.f Lnet/minecraft/entity/EntityLivingBase;
      // 03f: ifnull 048
      // 042: goto 046
      // 045: athrow
      // 046: return
      // 047: athrow
      // 048: aload 0
      // 049: iload 2
      // 04a: ifne 05d
      // 04d: getfield x/ocaa9a64f047.Ѐ Lx/oca9cc61aada;
      // 050: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 053: dconst_0
      // 054: dcmpl
      // 055: goto 059
      // 058: athrow
      // 059: ifeq 06b
      // 05c: aload 0
      // 05d: iload 2
      // 05e: ifne 06e
      // 061: invokevirtual x/ocaa9a64f047.Г ()Z
      // 064: ifne 06d
      // 067: goto 06b
      // 06a: athrow
      // 06b: return
      // 06c: athrow
      // 06d: aload 0
      // 06e: bipush 1
      // 06f: invokevirtual x/ocaa9a64f047.œ (Z)Lnet/minecraft/entity/Entity;
      // 072: astore 3
      // 073: aload 3
      // 074: ifnonnull 079
      // 077: return
      // 078: athrow
      // 079: aload 0
      // 07a: getfield x/ocaa9a64f047.ǰ Lx/oca9cc61aada;
      // 07d: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 080: dstore 4
      // 082: aload 0
      // 083: getfield x/ocaa9a64f047.ƥ Lx/occ2f8dff8d8;
      // 086: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 089: istore 6
      // 08b: invokestatic x/ocbb165642ef.ʨ ()Lx/ocbb165642ef;
      // 08e: aload 3
      // 08f: aload 1
      // 090: aload 0
      // 091: getfield x/ocaa9a64f047.Ǧ Lx/oca9cc61aada;
      // 094: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 097: d2i
      // 098: dload 4
      // 09a: dload 4
      // 09c: aload 0
      // 09d: getfield x/ocaa9a64f047.ά Lx/oca9cc61aada;
      // 0a0: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0a3: d2f
      // 0a4: iload 6
      // 0a6: aload 0
      // 0a7: getfield x/ocaa9a64f047.Ц Lx/oca9cc61aada;
      // 0aa: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0ad: iload 6
      // 0af: iload 2
      // 0b0: ifne 0bb
      // 0b3: ifne 0be
      // 0b6: goto 0ba
      // 0b9: athrow
      // 0ba: bipush 1
      // 0bb: goto 0bf
      // 0be: bipush 0
      // 0bf: iload 6
      // 0c1: iload 2
      // 0c2: ifne 0cd
      // 0c5: ifne 0d0
      // 0c8: goto 0cc
      // 0cb: athrow
      // 0cc: bipush 1
      // 0cd: goto 0d1
      // 0d0: bipush 0
      // 0d1: invokevirtual x/ocbb165642ef.Ϭ (Lnet/minecraft/entity/Entity;Lx/oc86de9e2892;IDDFZDZZ)[F
      // 0d4: astore 7
      // 0d6: iload 2
      // 0d7: ifne 102
      // 0da: aload 7
      // 0dc: ifnonnull 0e5
      // 0df: goto 0e3
      // 0e2: athrow
      // 0e3: return
      // 0e4: athrow
      // 0e5: invokestatic x/ocbb165642ef.ʨ ()Lx/ocbb165642ef;
      // 0e8: bipush 1
      // 0e9: putfield x/ocbb165642ef.Н Z
      // 0ec: aload 1
      // 0ed: aload 7
      // 0ef: bipush 0
      // 0f0: faload
      // 0f1: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 0f4: putfield x/oc86de9e2892.Ӝ Ljava/lang/Float;
      // 0f7: aload 1
      // 0f8: aload 7
      // 0fa: bipush 1
      // 0fb: faload
      // 0fc: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 0ff: putfield x/oc86de9e2892.ŷ Ljava/lang/Float;
      // 102: return
   }

   @Override
   public void z$1m9j3ewef9s() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 1
      // 04: getstatic x/oc9755810e45.ϔ Lx/oc8edd24b1ed;
      // 07: iload 1
      // 08: ifne 15
      // 0b: ifnull 1d
      // 0e: goto 12
      // 11: athrow
      // 12: getstatic x/oc9755810e45.ϔ Lx/oc8edd24b1ed;
      // 15: invokevirtual x/oc8edd24b1ed.φ ()Z
      // 18: ifeq 1d
      // 1b: return
      // 1c: athrow
      // 1d: getstatic x/oc9755810e45.ÿ Lx/ocdd342096f8;
      // 20: iload 1
      // 21: ifne 2e
      // 24: ifnull 48
      // 27: goto 2b
      // 2a: athrow
      // 2b: getstatic x/oc9755810e45.ÿ Lx/ocdd342096f8;
      // 2e: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 31: iload 1
      // 32: ifne 59
      // 35: ifeq 48
      // 38: goto 3c
      // 3b: athrow
      // 3c: getstatic x/ocdd342096f8.f Lnet/minecraft/entity/EntityLivingBase;
      // 3f: ifnull 48
      // 42: goto 46
      // 45: athrow
      // 46: return
      // 47: athrow
      // 48: aload 0
      // 49: iload 1
      // 4a: ifne 5d
      // 4d: getfield x/ocaa9a64f047.Ѐ Lx/oca9cc61aada;
      // 50: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 53: dconst_1
      // 54: dcmpl
      // 55: goto 59
      // 58: athrow
      // 59: ifeq 6b
      // 5c: aload 0
      // 5d: iload 1
      // 5e: ifne 6e
      // 61: invokevirtual x/ocaa9a64f047.Г ()Z
      // 64: ifne 6d
      // 67: goto 6b
      // 6a: athrow
      // 6b: return
      // 6c: athrow
      // 6d: aload 0
      // 6e: bipush 0
      // 6f: invokevirtual x/ocaa9a64f047.œ (Z)Lnet/minecraft/entity/Entity;
      // 72: astore 2
      // 73: aload 2
      // 74: ifnonnull 79
      // 77: return
      // 78: athrow
      // 79: aload 0
      // 7a: getfield x/ocaa9a64f047.ǰ Lx/oca9cc61aada;
      // 7d: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 80: dstore 3
      // 81: aload 0
      // 82: getfield x/ocaa9a64f047.ƥ Lx/occ2f8dff8d8;
      // 85: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 88: istore 5
      // 8a: invokestatic x/ocbb165642ef.ʨ ()Lx/ocbb165642ef;
      // 8d: aload 2
      // 8e: aload 0
      // 8f: getfield x/ocaa9a64f047.Ǧ Lx/oca9cc61aada;
      // 92: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 95: d2i
      // 96: dload 3
      // 97: dload 3
      // 98: aload 0
      // 99: getfield x/ocaa9a64f047.ά Lx/oca9cc61aada;
      // 9c: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 9f: d2f
      // a0: iload 5
      // a2: aload 0
      // a3: getfield x/ocaa9a64f047.Ц Lx/oca9cc61aada;
      // a6: invokevirtual x/oca9cc61aada.Ӂ ()D
      // a9: iload 5
      // ab: iload 1
      // ac: ifne b7
      // af: ifne ba
      // b2: goto b6
      // b5: athrow
      // b6: bipush 1
      // b7: goto bb
      // ba: bipush 0
      // bb: iload 5
      // bd: iload 1
      // be: ifne c9
      // c1: ifne cc
      // c4: goto c8
      // c7: athrow
      // c8: bipush 1
      // c9: goto cd
      // cc: bipush 0
      // cd: invokevirtual x/ocbb165642ef.Ԋ (Lnet/minecraft/entity/Entity;IDDFZDZZ)[F
      // d0: astore 6
      // d2: iload 1
      // d3: ifne fb
      // d6: aload 6
      // d8: ifnonnull e1
      // db: goto df
      // de: athrow
      // df: return
      // e0: athrow
      // e1: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // e4: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // e7: aload 6
      // e9: bipush 0
      // ea: faload
      // eb: putfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // ee: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // f1: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // f4: aload 6
      // f6: bipush 1
      // f7: faload
      // f8: putfield net/minecraft/client/entity/EntityPlayerSP.rotationPitch F
      // fb: return
   }

   private Entity œ(boolean param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc5e549848f3.İ I
      // 003: aload 0
      // 004: getfield x/ocaa9a64f047.Θ Lx/oca9cc61aada;
      // 007: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 00a: d2i
      // 00b: istore 3
      // 00c: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 00f: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 012: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 015: fstore 4
      // 017: istore 2
      // 018: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 01b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 01e: getfield net/minecraft/client/entity/EntityPlayerSP.rotationPitch F
      // 021: fstore 5
      // 023: iload 1
      // 024: ifeq 05f
      // 027: invokestatic x/ocbb165642ef.ʨ ()Lx/ocbb165642ef;
      // 02a: invokevirtual x/ocbb165642ef.ɦ ()Ljava/lang/Float;
      // 02d: astore 6
      // 02f: aload 6
      // 031: iload 2
      // 032: ifne 049
      // 035: ifnull 043
      // 038: goto 03c
      // 03b: athrow
      // 03c: aload 6
      // 03e: invokevirtual java/lang/Float.floatValue ()F
      // 041: fstore 4
      // 043: invokestatic x/ocbb165642ef.ʨ ()Lx/ocbb165642ef;
      // 046: invokevirtual x/ocbb165642ef.ȫ ()Ljava/lang/Float;
      // 049: astore 7
      // 04b: aload 7
      // 04d: iload 2
      // 04e: ifne 05a
      // 051: ifnull 05f
      // 054: goto 058
      // 057: athrow
      // 058: aload 7
      // 05a: invokevirtual java/lang/Float.floatValue ()F
      // 05d: fstore 5
      // 05f: new java/util/ArrayList
      // 062: dup
      // 063: invokespecial java/util/ArrayList.<init> ()V
      // 066: astore 6
      // 068: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 06b: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 06e: getfield net/minecraft/client/multiplayer/WorldClient.playerEntities Ljava/util/List;
      // 071: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 076: astore 7
      // 078: aload 7
      // 07a: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 07f: ifeq 1ab
      // 082: aload 7
      // 084: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 089: checkcast net/minecraft/entity/player/EntityPlayer
      // 08c: astore 8
      // 08e: iload 2
      // 08f: ifne 1b8
      // 092: aload 8
      // 094: iload 2
      // 095: ifne 0ab
      // 098: goto 09c
      // 09b: athrow
      // 09c: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 09f: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0a2: if_acmpeq 078
      // 0a5: goto 0a9
      // 0a8: athrow
      // 0a9: aload 8
      // 0ab: iload 2
      // 0ac: ifne 0c3
      // 0af: getfield net/minecraft/entity/player/EntityPlayer.deathTime I
      // 0b2: ifeq 0c1
      // 0b5: goto 0b9
      // 0b8: athrow
      // 0b9: iload 2
      // 0ba: ifeq 078
      // 0bd: goto 0c1
      // 0c0: athrow
      // 0c1: aload 8
      // 0c3: invokestatic x/oc7ab2161b9f.Ӭ (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // 0c6: iload 2
      // 0c7: ifne 0e0
      // 0ca: ifeq 0d9
      // 0cd: goto 0d1
      // 0d0: athrow
      // 0d1: iload 2
      // 0d2: ifeq 078
      // 0d5: goto 0d9
      // 0d8: athrow
      // 0d9: aload 0
      // 0da: getfield x/ocaa9a64f047.ϧ Lx/occ2f8dff8d8;
      // 0dd: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0e0: iload 2
      // 0e1: ifne 114
      // 0e4: ifeq 107
      // 0e7: goto 0eb
      // 0ea: athrow
      // 0eb: aload 8
      // 0ed: iload 2
      // 0ee: ifne 109
      // 0f1: goto 0f5
      // 0f4: athrow
      // 0f5: invokestatic x/oc7ab2161b9f.ӥ (Lnet/minecraft/entity/Entity;)Z
      // 0f8: ifeq 107
      // 0fb: goto 0ff
      // 0fe: athrow
      // 0ff: iload 2
      // 100: ifeq 078
      // 103: goto 107
      // 106: athrow
      // 107: aload 8
      // 109: iload 2
      // 10a: ifne 121
      // 10d: invokevirtual net/minecraft/entity/player/EntityPlayer.isInvisible ()Z
      // 110: goto 114
      // 113: athrow
      // 114: ifeq 11f
      // 117: iload 2
      // 118: ifeq 078
      // 11b: goto 11f
      // 11e: athrow
      // 11f: aload 8
      // 121: iload 2
      // 122: ifne 149
      // 125: invokestatic x/oc75d51ec7eb.Ώ (Lnet/minecraft/entity/Entity;)D
      // 128: aload 0
      // 129: getfield x/ocaa9a64f047.Ц Lx/oca9cc61aada;
      // 12c: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 12f: aload 0
      // 130: getfield x/ocaa9a64f047.Ц Lx/oca9cc61aada;
      // 133: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 136: dmul
      // 137: dcmpl
      // 138: ifle 147
      // 13b: goto 13f
      // 13e: athrow
      // 13f: iload 2
      // 140: ifeq 078
      // 143: goto 147
      // 146: athrow
      // 147: aload 8
      // 149: invokestatic x/oca4f99d2d44.Λ (Lnet/minecraft/entity/Entity;)Z
      // 14c: iload 2
      // 14d: ifne 160
      // 150: ifeq 15f
      // 153: goto 157
      // 156: athrow
      // 157: iload 2
      // 158: ifeq 078
      // 15b: goto 15f
      // 15e: athrow
      // 15f: iload 3
      // 160: iload 2
      // 161: ifne 1a6
      // 164: ldc_w 1831203472
      // 167: ldc_w 1831203832
      // 16a: ixor
      // 16b: if_icmpeq 19d
      // 16e: goto 172
      // 171: athrow
      // 172: aload 8
      // 174: getfield net/minecraft/entity/player/EntityPlayer.posX D
      // 177: aload 8
      // 179: getfield net/minecraft/entity/player/EntityPlayer.posZ D
      // 17c: invokestatic x/oc75d51ec7eb.z (DD)F
      // 17f: fstore 9
      // 181: iload 2
      // 182: ifne 1a7
      // 185: fload 4
      // 187: iload 3
      // 188: i2f
      // 189: fload 9
      // 18b: invokestatic x/oc7ab2161b9f.З (FFF)Z
      // 18e: ifne 19d
      // 191: goto 195
      // 194: athrow
      // 195: iload 2
      // 196: ifeq 078
      // 199: goto 19d
      // 19c: athrow
      // 19d: aload 6
      // 19f: aload 8
      // 1a1: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 1a6: pop
      // 1a7: iload 2
      // 1a8: ifeq 078
      // 1ab: aload 6
      // 1ad: invokeinterface java/util/List.isEmpty ()Z 1
      // 1b2: ifeq 1b8
      // 1b5: aconst_null
      // 1b6: areturn
      // 1b7: athrow
      // 1b8: fload 4
      // 1ba: fstore 7
      // 1bc: fload 5
      // 1be: fstore 8
      // 1c0: fload 7
      // 1c2: fload 8
      // 1c4: invokedynamic applyAsDouble (FF)Ljava/util/function/ToDoubleFunction; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)D, x/ocaa9a64f047.q3gbvc8b450gd5 (FFLnet/minecraft/entity/player/EntityPlayer;)D, (Lnet/minecraft/entity/player/EntityPlayer;)D ]
      // 1c9: invokestatic java/util/Comparator.comparingDouble (Ljava/util/function/ToDoubleFunction;)Ljava/util/Comparator;
      // 1cc: astore 9
      // 1ce: aload 6
      // 1d0: aload 9
      // 1d2: invokedynamic applyAsDouble ()Ljava/util/function/ToDoubleFunction; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)D, x/ocaa9a64f047.q3j4no1rmggi0s (Lnet/minecraft/entity/player/EntityPlayer;)D, (Lnet/minecraft/entity/player/EntityPlayer;)D ]
      // 1d7: invokeinterface java/util/Comparator.thenComparingDouble (Ljava/util/function/ToDoubleFunction;)Ljava/util/Comparator; 2
      // 1dc: invokeinterface java/util/List.sort (Ljava/util/Comparator;)V 2
      // 1e1: aload 0
      // 1e2: iload 2
      // 1e3: ifne 251
      // 1e6: getfield x/ocaa9a64f047.ƥ Lx/occ2f8dff8d8;
      // 1e9: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 1ec: ifeq 249
      // 1ef: goto 1f3
      // 1f2: athrow
      // 1f3: aload 0
      // 1f4: getfield x/ocaa9a64f047.ǰ Lx/oca9cc61aada;
      // 1f7: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 1fa: dstore 10
      // 1fc: aload 0
      // 1fd: getfield x/ocaa9a64f047.Ц Lx/oca9cc61aada;
      // 200: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 203: dstore 12
      // 205: aload 6
      // 207: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 20c: astore 14
      // 20e: aload 14
      // 210: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 215: ifeq 247
      // 218: aload 14
      // 21a: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 21f: checkcast net/minecraft/entity/player/EntityPlayer
      // 222: astore 15
      // 224: aload 15
      // 226: iload 2
      // 227: ifne 242
      // 22a: dload 10
      // 22c: dload 10
      // 22e: dload 12
      // 230: bipush 0
      // 231: bipush 0
      // 232: invokestatic x/oc75d51ec7eb.Ι (Lnet/minecraft/entity/Entity;DDDZZ)Z
      // 235: ifeq 243
      // 238: goto 23c
      // 23b: athrow
      // 23c: aload 15
      // 23e: goto 242
      // 241: athrow
      // 242: areturn
      // 243: iload 2
      // 244: ifeq 20e
      // 247: aconst_null
      // 248: areturn
      // 249: aload 6
      // 24b: bipush 0
      // 24c: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 251: checkcast net/minecraft/entity/Entity
      // 254: areturn
   }

   private boolean Г() {
      int var1 = oc5e549848f3.İ;
      int var2 = -163744059 ^ 134037551;

      while (true) {
         switch (var2) {
            case -1123872411:
               return false;
            case -1045296267:
               return true;
            case -651376794:
               break;
            case -455079957:
               int var10;
               label94: {
                  label93: {
                     try {
                        var10 = GameSettings.isKeyDown(oc69da1aa7f5.ő.gameSettings.keyBindAttack);
                        if (var1 != 0) {
                           break label94;
                        }

                        if (var10 != 0) {
                           break label93;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var2 = 1948904989 ^ 134037551;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var10 = -212747770 ^ 134037551;
               }

               var2 = var10;
               if (var1 == 0) {
                  continue;
               }
               break;
            case -264689002:
               return false;
            case -239061270:
               if (oc69da1aa7f5.ő.currentScreen == null) {
                  var2 = 462921811 ^ 134037551;
                  if (var1 == 0) {
                     continue;
                  }
               }

               var2 = -138122567 ^ 134037551;
               if (var1 == 0) {
                  continue;
               }
            case 1502288890:
               int var9;
               label103: {
                  label102: {
                     try {
                        var9 = this.Ƭ.ǭ();
                        if (var1 != 0) {
                           break label103;
                        }

                        if (var9 == 0) {
                           break label102;
                        }
                     } catch (ocbde1165e4e var6) {
                        throw var6;
                     }

                     var2 = -484620348 ^ 134037551;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var9 = -212747770 ^ 134037551;
               }

               var2 = var9;
               if (var1 == 0) {
                  continue;
               }

               return false;
            case -189990359:
               int var10000;
               label118: {
                  label117: {
                     try {
                        var10000 = this.Ć.ǭ();
                        if (var1 != 0) {
                           break label118;
                        }

                        if (var10000 == 0) {
                           break label117;
                        }
                     } catch (ocbde1165e4e var7) {
                        throw var7;
                     }

                     var2 = -556693687 ^ 134037551;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var10000 = -967881894 ^ 134037551;
               }

               var2 = var10000;
               if (var1 == 0) {
                  continue;
               }
            case 476766332:
               int var8;
               label76: {
                  label75: {
                     try {
                        var8 = oc69da1aa7f5.ő.inGameHasFocus;
                        if (var1 != 0) {
                           break label76;
                        }

                        if (oc69da1aa7f5.ő.inGameHasFocus) {
                           break label75;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = -138122567 ^ 134037551;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var8 = 1584815061 ^ 134037551;
               }

               var2 = var8;
               if (var1 == 0) {
                  continue;
               }

               return false;
            case 1943318066:
               return false;
            default:
               throw null;
         }

         int var11;
         label85: {
            label84: {
               try {
                  var11 = oc7ab2161b9f.Ħ();
                  if (var1 != 0) {
                     break label85;
                  }

                  if (var11 != 0) {
                     break label84;
                  }
               } catch (ocbde1165e4e var4) {
                  throw var4;
               }

               var2 = -967881894 ^ 134037551;
               if (var1 == 0) {
                  continue;
               }
            }

            var11 = -1157738166 ^ 134037551;
         }

         var2 = var11;
      }
   }

   static {
      String[] var10000 = new String[-301497404 ^ -301497402];
      var10000[0] = "Normal";
      var10000[1] = "Silent";
      Ǐ = var10000;
   }
}

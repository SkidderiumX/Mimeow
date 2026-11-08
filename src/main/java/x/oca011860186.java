package x;

public class oca011860186 extends oc49fb68d420 {
   private final oca9cc61aada Ѳ;
   private final occ2f8dff8d8 Ă;
   private final occ2f8dff8d8 ʸ;
   private final occ2f8dff8d8 ʰ;
   private final occ2f8dff8d8 Ū;
   private final occ2f8dff8d8 υ;
   private final ocd299de7725 φ = new ocd299de7725();
   private boolean ȧ;
   public static boolean ɧ;

   public oca011860186(oc72ee500c19 var1) {
      super("JumpReset", var1);
      this.Ⱦ(this.Ѳ = new oca9cc61aada("Chance", "%", 100.0, 0.0, 100.0, 1.0));
      this.Ⱦ(this.Ă = new occ2f8dff8d8("Looking at player", false));
      this.Ⱦ(this.ʸ = new occ2f8dff8d8("Mouse pressed", false));
      this.Ⱦ(this.ʰ = new occ2f8dff8d8("Moving forward", false));
      this.Ⱦ(this.Ū = new occ2f8dff8d8("Holding weapon", false));
      this.Ⱦ(this.υ = new occ2f8dff8d8("Sprinting", true));
   }

   public void z$fe4mfecqaowg() {
      boolean var2 = super.ό.ӂ("JumpReset");
      N[] var10001 = new N[651065691 ^ 651065693];
      var10001[0] = this.Ѳ;
      var10001[1] = this.Ă;
      var10001[651065695 ^ 651065693] = this.ʸ;
      var10001[651065694 ^ 651065693] = this.ʰ;
      var10001[651065689 ^ 651065693] = this.Ū;
      var10001[651065688 ^ 651065693] = this.υ;
      N[] var3 = var10001;
      boolean var1 = false;
      int var4 = var3.length;
      int var5 = 0;

      while (var5 < var4) {
         N var6 = var3[var5];
         var6.ȉ(var2, super.ό);
         var5++;
         if (var1) {
            break;
         }
      }
   }

   void ԕ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 1
      // 02: invokestatic x/oc2922be51da.Ѽ ()Z
      // 05: iload 1
      // 06: ifne 20
      // 09: ifeq 23
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 0
      // 11: iload 1
      // 12: ifne 25
      // 15: goto 19
      // 18: athrow
      // 19: invokevirtual x/oc49fb68d420.Ȧ ()Z
      // 1c: goto 20
      // 1f: athrow
      // 20: ifeq 24
      // 23: return
      // 24: aload 0
      // 25: iload 1
      // 26: ifne 44
      // 29: getfield x/oca011860186.ȧ Z
      // 2c: ifeq 3f
      // 2f: goto 33
      // 32: athrow
      // 33: aload 0
      // 34: invokevirtual x/oca011860186.ґ ()V
      // 37: iload 1
      // 38: ifeq c9
      // 3b: goto 3f
      // 3e: athrow
      // 3f: aload 0
      // 40: goto 44
      // 43: athrow
      // 44: iload 1
      // 45: ifne 5b
      // 48: invokevirtual x/oca011860186.Ž ()Z
      // 4b: ifeq c9
      // 4e: goto 52
      // 51: athrow
      // 52: aload 0
      // 53: iload 1
      // 54: ifne 66
      // 57: goto 5b
      // 5a: athrow
      // 5b: invokevirtual x/oca011860186.Ԇ ()Z
      // 5e: ifeq c9
      // 61: aload 0
      // 62: goto 66
      // 65: athrow
      // 66: iload 1
      // 67: ifne c5
      // 6a: getfield x/oca011860186.υ Lx/occ2f8dff8d8;
      // 6d: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 70: aload 0
      // 71: getfield x/oc49fb68d420.Ǳ Lnet/minecraft/client/Minecraft;
      // 74: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 77: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isSprinting ()Z
      // 7a: aload 0
      // 7b: getfield x/oc49fb68d420.Ǳ Lnet/minecraft/client/Minecraft;
      // 7e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 81: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 84: aload 0
      // 85: getfield x/oc49fb68d420.Ǳ Lnet/minecraft/client/Minecraft;
      // 88: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 8b: getfield net/minecraft/client/entity/EntityPlayerSP.motionY D
      // 8e: aload 0
      // 8f: getfield x/oc49fb68d420.Ǳ Lnet/minecraft/client/Minecraft;
      // 92: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 95: getstatic net/minecraft/potion/Potion.jump Lnet/minecraft/potion/Potion;
      // 98: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isPotionActive (Lnet/minecraft/potion/Potion;)Z
      // 9b: aload 0
      // 9c: getfield x/oc49fb68d420.Ǳ Lnet/minecraft/client/Minecraft;
      // 9f: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // a2: getfield net/minecraft/client/settings/GameSettings.keyBindJump Lnet/minecraft/client/settings/KeyBinding;
      // a5: invokevirtual net/minecraft/client/settings/KeyBinding.isKeyDown ()Z
      // a8: invokestatic x/oca011860186.ɵ (ZZZDZZ)Z
      // ab: ifeq c9
      // ae: goto b2
      // b1: athrow
      // b2: aload 0
      // b3: getfield x/oc49fb68d420.Ǳ Lnet/minecraft/client/Minecraft;
      // b6: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // b9: getfield net/minecraft/client/settings/GameSettings.keyBindJump Lnet/minecraft/client/settings/KeyBinding;
      // bc: bipush 1
      // bd: invokevirtual net/minecraft/client/settings/KeyBinding.setPressed (Z)V
      // c0: aload 0
      // c1: goto c5
      // c4: athrow
      // c5: bipush 1
      // c6: putfield x/oca011860186.ȧ Z
      // c9: return
   }

   static boolean ɵ(boolean param0, boolean param1, boolean param2, double param3, boolean param5, boolean param6) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 7
      // 03: iload 0
      // 04: iload 7
      // 06: ifne 22
      // 09: ifeq 21
      // 0c: goto 10
      // 0f: athrow
      // 10: iload 1
      // 11: iload 7
      // 13: ifne 22
      // 16: goto 1a
      // 19: athrow
      // 1a: ifeq 61
      // 1d: goto 21
      // 20: athrow
      // 21: iload 2
      // 22: iload 7
      // 24: ifne 35
      // 27: ifeq 61
      // 2a: goto 2e
      // 2d: athrow
      // 2e: dconst_0
      // 2f: dload 3
      // 30: dcmpl
      // 31: goto 35
      // 34: athrow
      // 35: iload 7
      // 37: ifne 43
      // 3a: ifge 61
      // 3d: goto 41
      // 40: athrow
      // 41: iload 5
      // 43: iload 7
      // 45: ifne 51
      // 48: ifne 61
      // 4b: goto 4f
      // 4e: athrow
      // 4f: iload 6
      // 51: iload 7
      // 53: ifne 5e
      // 56: ifne 61
      // 59: goto 5d
      // 5c: athrow
      // 5d: bipush 1
      // 5e: goto 62
      // 61: bipush 0
      // 62: ireturn
   }

   private boolean Ž() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: aload 0
      // 02: getfield x/oc49fb68d420.Ǳ Lnet/minecraft/client/Minecraft;
      // 05: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 08: getfield net/minecraft/client/settings/GameSettings.keyBindAttack Lnet/minecraft/client/settings/KeyBinding;
      // 0b: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // 0e: istore 2
      // 0f: istore 1
      // 10: aload 0
      // 11: iload 1
      // 12: ifne 3e
      // 15: getfield x/oca011860186.ʰ Lx/occ2f8dff8d8;
      // 18: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 1b: ifeq 3d
      // 1e: goto 22
      // 21: athrow
      // 22: fconst_0
      // 23: aload 0
      // 24: getfield x/oc49fb68d420.Ǳ Lnet/minecraft/client/Minecraft;
      // 27: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 2a: getfield net/minecraft/client/entity/EntityPlayerSP.moveForward F
      // 2d: fcmpl
      // 2e: iload 1
      // 2f: ifne 4c
      // 32: goto 36
      // 35: athrow
      // 36: ifge d8
      // 39: goto 3d
      // 3c: athrow
      // 3d: aload 0
      // 3e: iload 1
      // 3f: ifne 7c
      // 42: getfield x/oca011860186.ʸ Lx/occ2f8dff8d8;
      // 45: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 48: goto 4c
      // 4b: athrow
      // 4c: ifeq 7b
      // 4f: iload 2
      // 50: iload 1
      // 51: ifne 69
      // 54: goto 58
      // 57: athrow
      // 58: ldc 976241010
      // 5a: ldc -976240913
      // 5c: ixor
      // 5d: if_icmpne 6c
      // 60: goto 64
      // 63: athrow
      // 64: bipush 1
      // 65: goto 69
      // 68: athrow
      // 69: goto 6d
      // 6c: bipush 0
      // 6d: invokestatic org/lwjgl/input/Mouse.isButtonDown (I)Z
      // 70: iload 1
      // 71: ifne 8a
      // 74: ifeq d8
      // 77: goto 7b
      // 7a: athrow
      // 7b: aload 0
      // 7c: iload 1
      // 7d: ifne aa
      // 80: getfield x/oca011860186.Ū Lx/occ2f8dff8d8;
      // 83: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 86: goto 8a
      // 89: athrow
      // 8a: ifeq a9
      // 8d: getstatic x/ocbd3640d420.L Lx/ocbd3640d420;
      // 90: aload 0
      // 91: getfield x/oc49fb68d420.Ǳ Lnet/minecraft/client/Minecraft;
      // 94: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 97: invokevirtual x/ocbd3640d420.Ś (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // 9a: iload 1
      // 9b: ifne b0
      // 9e: goto a2
      // a1: athrow
      // a2: ifeq d8
      // a5: goto a9
      // a8: athrow
      // a9: aload 0
      // aa: getfield x/oca011860186.Ă Lx/occ2f8dff8d8;
      // ad: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // b0: iload 1
      // b1: ifne d5
      // b4: ifeq d4
      // b7: goto bb
      // ba: athrow
      // bb: new x/oc6111f05032
      // be: dup
      // bf: aload 0
      // c0: getfield x/oc49fb68d420.Ǳ Lnet/minecraft/client/Minecraft;
      // c3: invokespecial x/oc6111f05032.<init> (Lnet/minecraft/client/Minecraft;)V
      // c6: invokestatic x/oceb15b1dc5f.ʭ (Lx/oc6111f05032;)Z
      // c9: iload 1
      // ca: ifne d5
      // cd: goto d1
      // d0: athrow
      // d1: ifeq d8
      // d4: bipush 1
      // d5: goto d9
      // d8: bipush 0
      // d9: ireturn
   }

   private boolean Ԇ() {
      float var2 = 0.0F;
      double var3 = 0.0;
      int var5 = 414319695 ^ 1333407995;
      boolean var1 = false;

      while (true) {
         switch (var5) {
            case -509915153:
               var3 = (float)(var2 * 0.01);
               return this.φ.È((float)(-0.05 + var3), (float)(var3 + 0.05), 60.0, oca6eae151db.Ϫ(), oca6eae151db.ő);
            case -489966726:
               return true;
            case 1472738484:
               var2 = (float)this.Ѳ.Ӂ();

               label26: {
                  try {
                     if (var1) {
                        break;
                     }

                     if (!(var2 > 99.0F)) {
                        break label26;
                     }
                  } catch (ocbde1165e4e var6) {
                     throw var6;
                  }

                  var5 = -1380875391 ^ 1333407995;
                  if (!var1) {
                     break;
                  }
               }

               var5 = -1360953580 ^ 1333407995;
               break;
            default:
               throw null;
         }
      }
   }

   private void ґ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 1
      // 02: aload 0
      // 03: iload 1
      // 04: ifne 14
      // 07: getfield x/oca011860186.ȧ Z
      // 0a: ifne 13
      // 0d: goto 11
      // 10: athrow
      // 11: return
      // 12: athrow
      // 13: aload 0
      // 14: getfield x/oc49fb68d420.Ǳ Lnet/minecraft/client/Minecraft;
      // 17: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 1a: getfield net/minecraft/client/settings/GameSettings.keyBindJump Lnet/minecraft/client/settings/KeyBinding;
      // 1d: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // 20: istore 2
      // 21: iload 2
      // 22: iload 1
      // 23: ifne 3c
      // 26: ifge 3b
      // 29: goto 2d
      // 2c: athrow
      // 2d: iload 2
      // 2e: ldc 576919918
      // 30: ldc 576919818
      // 32: ixor
      // 33: iadd
      // 34: invokestatic org/lwjgl/input/Mouse.isButtonDown (I)Z
      // 37: goto 5f
      // 3a: athrow
      // 3b: iload 2
      // 3c: iload 1
      // 3d: ifne 57
      // 40: ifle 5e
      // 43: goto 47
      // 46: athrow
      // 47: iload 2
      // 48: iload 1
      // 49: ifne 5b
      // 4c: goto 50
      // 4f: athrow
      // 50: invokestatic org/lwjgl/input/Keyboard.isKeyDown (I)Z
      // 53: goto 57
      // 56: athrow
      // 57: ifeq 5e
      // 5a: bipush 1
      // 5b: goto 5f
      // 5e: bipush 0
      // 5f: istore 3
      // 60: aload 0
      // 61: getfield x/oc49fb68d420.Ǳ Lnet/minecraft/client/Minecraft;
      // 64: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 67: getfield net/minecraft/client/settings/GameSettings.keyBindJump Lnet/minecraft/client/settings/KeyBinding;
      // 6a: iload 3
      // 6b: invokevirtual net/minecraft/client/settings/KeyBinding.setPressed (Z)V
      // 6e: aload 0
      // 6f: bipush 0
      // 70: putfield x/oca011860186.ȧ Z
      // 73: return
   }

   public void z$1bjr376lv3ef3() {
      this.ґ();
   }

   public void z$2cvyenog50sql(ocbab3c9954b var1) {
      this.ґ();
   }
}

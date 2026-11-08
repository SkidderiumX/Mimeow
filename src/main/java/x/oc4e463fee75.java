package x;

import net.minecraft.network.Packet;

public class oc4e463fee75 extends oc69da1aa7f5 {
   static final int Ǎ = 45;
   static final int Τ = 1;
   private double у;
   private double Ϸ;
   private double Һ;
   private int Ȥ;
   private oc57297d86f0 ô = oc57297d86f0.ԓ;
   private boolean Ҏ;
   public static boolean Ȉ;

   public oc4e463fee75() {
      super("Stasis", oce4cea752dd.ҕ);
      this.ą("Pauses motion in midair with brief release intervals.");
   }

   @Override
   public void onEnable() {
      this.Ȥ = 0;
      this.ô = oc57297d86f0.ԓ;
      this.Ҏ = false;
      this.խ();
   }

   @Override
   public void onDisable() {
      this.ω();
      this.Ȥ = 0;
      this.ô = oc57297d86f0.ԓ;
      this.Ҏ = false;
   }

   @oc66fa4f2195
   public void Ԝ(oc2f61de30bc param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 2
      // 02: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 05: iload 2
      // 06: ifne 1d
      // 09: ifne 11
      // 0c: goto 10
      // 0f: athrow
      // 10: return
      // 11: aload 0
      // 12: iload 2
      // 13: ifne 33
      // 16: getfield x/oc4e463fee75.Ҏ Z
      // 19: goto 1d
      // 1c: athrow
      // 1d: ifne 28
      // 20: aload 0
      // 21: invokevirtual x/oc4e463fee75.խ ()V
      // 24: goto 28
      // 27: athrow
      // 28: aload 0
      // 29: dup
      // 2a: getfield x/oc4e463fee75.Ȥ I
      // 2d: bipush 1
      // 2e: iadd
      // 2f: putfield x/oc4e463fee75.Ȥ I
      // 32: aload 0
      // 33: getfield x/oc4e463fee75.ô Lx/oc57297d86f0;
      // 36: iload 2
      // 37: ifne 84
      // 3a: getstatic x/oc57297d86f0.ԓ Lx/oc57297d86f0;
      // 3d: if_acmpne 74
      // 40: goto 44
      // 43: athrow
      // 44: aload 0
      // 45: iload 2
      // 46: ifne 79
      // 49: goto 4d
      // 4c: athrow
      // 4d: getfield x/oc4e463fee75.Ȥ I
      // 50: ldc -1868980682
      // 52: ldc -1868980709
      // 54: ixor
      // 55: if_icmplt 74
      // 58: goto 5c
      // 5b: athrow
      // 5c: aload 0
      // 5d: getstatic x/oc57297d86f0.ӡ Lx/oc57297d86f0;
      // 60: putfield x/oc4e463fee75.ô Lx/oc57297d86f0;
      // 63: iload 2
      // 64: aload 0
      // 65: bipush 0
      // 66: putfield x/oc4e463fee75.Ȥ I
      // 69: aload 0
      // 6a: invokevirtual x/oc4e463fee75.ω ()V
      // 6d: ifeq b2
      // 70: goto 74
      // 73: athrow
      // 74: aload 0
      // 75: goto 79
      // 78: athrow
      // 79: iload 2
      // 7a: ifne b3
      // 7d: getfield x/oc4e463fee75.ô Lx/oc57297d86f0;
      // 80: goto 84
      // 83: athrow
      // 84: getstatic x/oc57297d86f0.ӡ Lx/oc57297d86f0;
      // 87: if_acmpne b2
      // 8a: aload 0
      // 8b: iload 2
      // 8c: ifne b3
      // 8f: goto 93
      // 92: athrow
      // 93: getfield x/oc4e463fee75.Ȥ I
      // 96: bipush 1
      // 97: if_icmplt b2
      // 9a: goto 9e
      // 9d: athrow
      // 9e: aload 0
      // 9f: getstatic x/oc57297d86f0.ԓ Lx/oc57297d86f0;
      // a2: putfield x/oc4e463fee75.ô Lx/oc57297d86f0;
      // a5: aload 0
      // a6: bipush 0
      // a7: putfield x/oc4e463fee75.Ȥ I
      // aa: aload 0
      // ab: invokevirtual x/oc4e463fee75.խ ()V
      // ae: goto b2
      // b1: athrow
      // b2: aload 0
      // b3: iload 2
      // b4: ifne cf
      // b7: invokevirtual x/oc4e463fee75.Ћ ()V
      // ba: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // bd: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // c0: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // c3: ifeq d2
      // c6: goto ca
      // c9: athrow
      // ca: aload 0
      // cb: goto cf
      // ce: athrow
      // cf: invokevirtual x/oc69da1aa7f5.z$1ca1cmv0s357 ()V
      // d2: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.LOWEST
   )
   public void Ы(oc70db705765 var1) {
      try {
         if (!this.ϩ()) {
            return;
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }

      var1.ď(0.0F);
      var1.Ԥ(0.0F);
      var1.Ƀ(false);
      var1.Г(false);
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.LOWEST
   )
   public void Ջ(oca8d3b21c30 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 2
      // 02: aload 0
      // 03: invokevirtual x/oc4e463fee75.ϩ ()Z
      // 06: ifeq 21
      // 09: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0c: iload 2
      // 0d: ifne 4d
      // 10: goto 14
      // 13: athrow
      // 14: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 17: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 1a: ifnonnull 23
      // 1d: goto 21
      // 20: athrow
      // 21: return
      // 22: athrow
      // 23: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 26: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 29: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 2c: fconst_0
      // 2d: putfield net/minecraft/util/MovementInput.moveForward F
      // 30: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 33: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 36: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 39: fconst_0
      // 3a: putfield net/minecraft/util/MovementInput.moveStrafe F
      // 3d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 40: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 43: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 46: bipush 0
      // 47: putfield net/minecraft/util/MovementInput.jump Z
      // 4a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 4d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 50: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 53: bipush 0
      // 54: putfield net/minecraft/util/MovementInput.sneak Z
      // 57: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.LOWEST
   )
   public void ʎ(oc057a60a0eb var1) {
      this.Ћ();
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.LOWEST
   )
   public void Ǣ(oc55585a6f85 var1) {
      try {
         if (!this.ϩ()) {
            return;
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }

      var1.Ϩ(0.0F);
      var1.Ѝ(0.0F);
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.LOWEST
   )
   public void Ƶ(oc9d4393f3ce param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 2
      // 02: aload 1
      // 03: invokevirtual x/oc9d4393f3ce.ɟ ()Lnet/minecraft/network/Packet;
      // 06: aload 0
      // 07: invokevirtual x/oc4e463fee75.ϩ ()Z
      // 0a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 10: ifnull 18
      // 13: bipush 1
      // 14: goto 19
      // 17: athrow
      // 18: bipush 0
      // 19: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1c: iload 2
      // 1d: ifne 32
      // 20: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 23: ifnonnull 2f
      // 26: goto 2a
      // 29: athrow
      // 2a: bipush 0
      // 2b: goto 38
      // 2e: athrow
      // 2f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 32: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 35: getfield net/minecraft/client/entity/EntityPlayerSP.hurtTime I
      // 38: invokestatic x/oc4e463fee75.ԛ (Lnet/minecraft/network/Packet;ZZI)Z
      // 3b: ifeq 47
      // 3e: aload 1
      // 3f: bipush 1
      // 40: invokevirtual x/oc68d6b191af.setCanceled (Z)V
      // 43: goto 47
      // 46: athrow
      // 47: return
   }

   static boolean ԛ(Packet<?> param0, boolean param1, boolean param2, int param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 4
      // 03: iload 1
      // 04: iload 4
      // 06: ifne 11
      // 09: ifeq 52
      // 0c: goto 10
      // 0f: athrow
      // 10: iload 2
      // 11: iload 4
      // 13: ifne 1e
      // 16: ifeq 52
      // 19: goto 1d
      // 1c: athrow
      // 1d: iload 3
      // 1e: iload 4
      // 20: ifne 3b
      // 23: ifne 52
      // 26: goto 2a
      // 29: athrow
      // 2a: aload 0
      // 2b: iload 4
      // 2d: ifne 3f
      // 30: goto 34
      // 33: athrow
      // 34: instanceof net/minecraft/network/play/client/C03PacketPlayer
      // 37: goto 3b
      // 3a: athrow
      // 3b: ifeq 52
      // 3e: aload 0
      // 3f: instanceof net/minecraft/network/play/client/C03PacketPlayer$C05PacketPlayerLook
      // 42: iload 4
      // 44: ifne 4f
      // 47: ifne 52
      // 4a: goto 4e
      // 4d: athrow
      // 4e: bipush 1
      // 4f: goto 53
      // 52: bipush 0
      // 53: ireturn
   }

   private boolean ϩ() {
      boolean var1 = false;
      int var2 = -1999730904 ^ 357205066;

      while (true) {
         switch (var2) {
            case -1780879917:
               if (this.ô == oc57297d86f0.ԓ) {
                  var2 = -1153231079 ^ 357205066;
                  if (!var1) {
                     break;
                  }
               }

               var2 = -1253541789 ^ 357205066;
               if (!var1) {
                  break;
               }
            case -1375104173:
               return true;
            case -1652292766:
               int var10000;
               label35: {
                  label34: {
                     try {
                        var10000 = oc7ab2161b9f.Ð();
                        if (var1) {
                           break label35;
                        }

                        if (var10000 == 0) {
                           break label34;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = -2137822823 ^ 357205066;
                     if (!var1) {
                        break;
                     }
                  }

                  var10000 = -1253541789 ^ 357205066;
               }

               var2 = var10000;
               if (!var1) {
                  break;
               }
            case -1610417111:
               return false;
            default:
               throw null;
         }
      }
   }

   private void Ћ() {
      try {
         if (!this.ϩ()) {
            return;
         }
      } catch (ocbde1165e4e var1) {
         throw var1;
      }

      oc69da1aa7f5.ő.thePlayer.motionX = 0.0;
      oc69da1aa7f5.ő.thePlayer.motionY = 0.0;
      oc69da1aa7f5.ő.thePlayer.motionZ = 0.0;
   }

   private void խ() {
      try {
         if (!oc7ab2161b9f.Ð()) {
            return;
         }
      } catch (ocbde1165e4e var1) {
         throw var1;
      }

      this.у = oc69da1aa7f5.ő.thePlayer.motionX;
      this.Ϸ = oc69da1aa7f5.ő.thePlayer.motionY;
      this.Һ = oc69da1aa7f5.ő.thePlayer.motionZ;
      this.Ҏ = true;
   }

   private void ω() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 1
      // 02: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 05: iload 1
      // 06: ifne 18
      // 09: ifeq 1b
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 0
      // 11: getfield x/oc4e463fee75.Ҏ Z
      // 14: goto 18
      // 17: athrow
      // 18: ifne 1c
      // 1b: return
      // 1c: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1f: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 22: aload 0
      // 23: getfield x/oc4e463fee75.у D
      // 26: putfield net/minecraft/client/entity/EntityPlayerSP.motionX D
      // 29: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 2c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 2f: aload 0
      // 30: getfield x/oc4e463fee75.Ϸ D
      // 33: putfield net/minecraft/client/entity/EntityPlayerSP.motionY D
      // 36: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 39: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 3c: aload 0
      // 3d: getfield x/oc4e463fee75.Һ D
      // 40: putfield net/minecraft/client/entity/EntityPlayerSP.motionZ D
      // 43: return
   }
}

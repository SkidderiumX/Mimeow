package x;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class T extends oc69da1aa7f5 {
   private static final int À = 0;
   private static final int ΰ = 1;
   private static final double ʦ = 6.0;
   private static final String[] ğ;
   public final oca9cc61aada ɺ;
   private final ocf1568fef75 ĕ;
   private final ocf1568fef75 Չ;
   private final occ2f8dff8d8 Ʀ;
   private final ocba5f31cad4 Ȣ = new ocba5f31cad4();
   private int ˠ;
   private int Β;
   private int Ġ = -1;
   private Entity Ĭ;
   private long Җ;
   private KeyBinding Ԉ;
   private boolean ñ;
   public static boolean ª;

   public T() {
      super("SprintReset", oce4cea752dd.ȁ);
      this.ą("Resets sprint during combat to increase knockback.");
      this.ɺ = new oca9cc61aada("Mode", 0, ğ);
      this.ĕ = new ocf1568fef75("Wait", 0.0, 500.0, 175.0, 250.0, 25.0);
      this.Չ = new ocf1568fef75("Delay", 0.0, 500.0, 100.0, 200.0, 25.0);
      this.Ʀ = new occ2f8dff8d8("OnGroundOnly", false);
      this.ʌ(this.ɺ);
      this.ʌ(this.ĕ);
      this.ʌ(this.Չ);
      this.ʌ(this.Ʀ);
      this.ɮ = true;
      this.z$2u87utkr1isxg();
   }

   @Override
   public String getInfo() {
      int var1 = Math.max(0, Math.min(1, (int)this.ɺ.Ӂ()));
      return ğ[var1];
   }

   @Override
   public void z$2u87utkr1isxg() {
      boolean var1 = this.П();
      this.ĕ.ȉ(var1, this);
      this.Չ.ȉ(var1, this);
      this.Ʀ.ȉ(true, this);
   }

   @Override
   public void z$1sehylui0i4ix(oca9cc61aada var1) {
      try {
         if (var1 == this.ɺ) {
            this.b();
            this.ѱ();
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }

      this.z$2u87utkr1isxg();
   }

   @Override
   public void z$3tl278wzjcayb(N var1) {
      try {
         if (var1 == this.ɺ) {
            this.b();
            this.ѱ();
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }

      this.z$2u87utkr1isxg();
   }

   @Override
   public void onEnable() {
      this.ѱ();
      this.Ȣ.Ÿ();
   }

   @Override
   public void onDisable() {
      this.b();
      this.ѱ();
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.LOW
   )
   public void Б(oce79181588d param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 07: iload 2
      // 08: ifne 1f
      // 0b: ifeq 2a
      // 0e: goto 12
      // 11: athrow
      // 12: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 15: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 18: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isSprinting ()Z
      // 1b: goto 1f
      // 1e: athrow
      // 1f: iload 2
      // 20: ifne 32
      // 23: ifne 2b
      // 26: goto 2a
      // 29: athrow
      // 2a: return
      // 2b: aload 1
      // 2c: invokevirtual x/oce79181588d.Ҡ ()Lnet/minecraft/network/Packet;
      // 2f: instanceof net/minecraft/network/play/server/S19PacketEntityStatus
      // 32: iload 2
      // 33: ifne 52
      // 36: ifeq 55
      // 39: goto 3d
      // 3c: athrow
      // 3d: aload 0
      // 3e: getfield x/T.Ȣ Lx/ocba5f31cad4;
      // 41: aload 0
      // 42: getfield x/T.ˠ I
      // 45: aload 0
      // 46: getfield x/T.Β I
      // 49: iadd
      // 4a: i2l
      // 4b: invokevirtual x/ocba5f31cad4.Ũ (J)Z
      // 4e: goto 52
      // 51: athrow
      // 52: ifne 56
      // 55: return
      // 56: aload 1
      // 57: invokevirtual x/oce79181588d.Ҡ ()Lnet/minecraft/network/Packet;
      // 5a: checkcast net/minecraft/network/play/server/S19PacketEntityStatus
      // 5d: astore 3
      // 5e: aload 3
      // 5f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 62: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 65: invokevirtual net/minecraft/network/play/server/S19PacketEntityStatus.getEntity (Lnet/minecraft/world/World;)Lnet/minecraft/entity/Entity;
      // 68: astore 4
      // 6a: aload 3
      // 6b: invokevirtual net/minecraft/network/play/server/S19PacketEntityStatus.getOpCode ()B
      // 6e: iload 2
      // 6f: ifne 90
      // 72: ldc 1403438870
      // 74: ldc 1403438868
      // 76: ixor
      // 77: if_icmpne 93
      // 7a: goto 7e
      // 7d: athrow
      // 7e: aload 0
      // 7f: iload 2
      // 80: ifne ba
      // 83: goto 87
      // 86: athrow
      // 87: aload 4
      // 89: invokevirtual x/T.ѭ (Lnet/minecraft/entity/Entity;)Z
      // 8c: goto 90
      // 8f: athrow
      // 90: ifne 94
      // 93: return
      // 94: aload 0
      // 95: aload 0
      // 96: getfield x/T.ĕ Lx/ocf1568fef75;
      // 99: invokevirtual x/ocf1568fef75.ϐ ()D
      // 9c: d2i
      // 9d: putfield x/T.ˠ I
      // a0: aload 0
      // a1: aload 0
      // a2: getfield x/T.Չ Lx/ocf1568fef75;
      // a5: invokevirtual x/ocf1568fef75.ϐ ()D
      // a8: d2i
      // a9: putfield x/T.Β I
      // ac: aload 0
      // ad: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // b0: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // b3: getfield net/minecraft/client/entity/EntityPlayerSP.ticksExisted I
      // b6: putfield x/T.Ġ I
      // b9: aload 0
      // ba: getfield x/T.Ȣ Lx/ocba5f31cad4;
      // bd: invokevirtual x/ocba5f31cad4.Ÿ ()V
      // c0: return
   }

   @oc66fa4f2195
   public void Α(oc25aa89b91f param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 07: iload 2
      // 08: ifne 18
      // 0b: ifne 13
      // 0e: goto 12
      // 11: athrow
      // 12: return
      // 13: aload 0
      // 14: bipush 1
      // 15: invokevirtual x/T.Ȱ (I)Z
      // 18: iload 2
      // 19: ifne 82
      // 1c: ifeq 79
      // 1f: goto 23
      // 22: athrow
      // 23: aload 0
      // 24: getfield x/T.Ġ I
      // 27: iload 2
      // 28: ifne 82
      // 2b: goto 2f
      // 2e: athrow
      // 2f: bipush 1
      // 30: iadd
      // 31: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 34: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 37: getfield net/minecraft/client/entity/EntityPlayerSP.ticksExisted I
      // 3a: if_icmpne 79
      // 3d: goto 41
      // 40: athrow
      // 41: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 44: iload 2
      // 45: ifne 72
      // 48: goto 4c
      // 4b: athrow
      // 4c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 4f: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 52: ifne 6f
      // 55: goto 59
      // 58: athrow
      // 59: aload 0
      // 5a: getfield x/T.Ʀ Lx/occ2f8dff8d8;
      // 5d: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 60: iload 2
      // 61: ifne 82
      // 64: goto 68
      // 67: athrow
      // 68: ifne 79
      // 6b: goto 6f
      // 6e: athrow
      // 6f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 72: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 75: bipush 0
      // 76: invokevirtual net/minecraft/client/entity/EntityPlayerSP.setSprinting (Z)V
      // 79: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 7c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 7f: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 82: iload 2
      // 83: ifne a5
      // 86: ifne cd
      // 89: goto 8d
      // 8c: athrow
      // 8d: aload 0
      // 8e: iload 2
      // 8f: ifne a9
      // 92: goto 96
      // 95: athrow
      // 96: getfield x/T.Ȣ Lx/ocba5f31cad4;
      // 99: aload 0
      // 9a: getfield x/T.ˠ I
      // 9d: i2l
      // 9e: invokevirtual x/ocba5f31cad4.Ũ (J)Z
      // a1: goto a5
      // a4: athrow
      // a5: ifne cd
      // a8: aload 0
      // a9: iload 2
      // aa: ifne c9
      // ad: getfield x/T.Ʀ Lx/occ2f8dff8d8;
      // b0: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // b3: ifne cd
      // b6: goto ba
      // b9: athrow
      // ba: aload 0
      // bb: bipush 0
      // bc: putfield x/T.ˠ I
      // bf: aload 0
      // c0: bipush 0
      // c1: putfield x/T.Β I
      // c4: aload 0
      // c5: goto c9
      // c8: athrow
      // c9: bipush -1
      // ca: putfield x/T.Ġ I
      // cd: return
   }

   @oc66fa4f2195
   public void ы(oc70db705765 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 07: iload 2
      // 08: ifne 22
      // 0b: ifeq 25
      // 0e: goto 12
      // 11: athrow
      // 12: aload 0
      // 13: iload 2
      // 14: ifne 27
      // 17: goto 1b
      // 1a: athrow
      // 1b: getfield x/T.Ġ I
      // 1e: goto 22
      // 21: athrow
      // 22: ifge 26
      // 25: return
      // 26: aload 0
      // 27: iload 2
      // 28: ifne 67
      // 2b: bipush 1
      // 2c: invokevirtual x/T.Ȱ (I)Z
      // 2f: ifeq 66
      // 32: goto 36
      // 35: athrow
      // 36: aload 0
      // 37: iload 2
      // 38: ifne 67
      // 3b: goto 3f
      // 3e: athrow
      // 3f: getfield x/T.Ġ I
      // 42: bipush 1
      // 43: iadd
      // 44: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 47: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 4a: getfield net/minecraft/client/entity/EntityPlayerSP.ticksExisted I
      // 4d: if_icmpne 66
      // 50: goto 54
      // 53: athrow
      // 54: aload 0
      // 55: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 58: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 5b: getfield net/minecraft/client/settings/GameSettings.keyBindSprint Lnet/minecraft/client/settings/KeyBinding;
      // 5e: bipush 0
      // 5f: invokevirtual x/T.Û (Lnet/minecraft/client/settings/KeyBinding;Z)V
      // 62: goto 66
      // 65: athrow
      // 66: aload 0
      // 67: iload 2
      // 68: ifne 78
      // 6b: invokevirtual x/T.γ ()Z
      // 6e: ifne 77
      // 71: goto 75
      // 74: athrow
      // 75: return
      // 76: athrow
      // 77: aload 0
      // 78: bipush 0
      // 79: invokevirtual x/T.Ȱ (I)Z
      // 7c: iload 2
      // 7d: ifne 97
      // 80: ifeq b8
      // 83: goto 87
      // 86: athrow
      // 87: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 8a: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 8d: getfield net/minecraft/client/settings/GameSettings.keyBindForward Lnet/minecraft/client/settings/KeyBinding;
      // 90: invokevirtual net/minecraft/client/settings/KeyBinding.isKeyDown ()Z
      // 93: goto 97
      // 96: athrow
      // 97: istore 3
      // 98: aload 0
      // 99: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 9c: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 9f: getfield net/minecraft/client/settings/GameSettings.keyBindForward Lnet/minecraft/client/settings/KeyBinding;
      // a2: bipush 0
      // a3: invokevirtual x/T.Û (Lnet/minecraft/client/settings/KeyBinding;Z)V
      // a6: iload 3
      // a7: ifeq b8
      // aa: aload 1
      // ab: aload 1
      // ac: invokevirtual x/oc70db705765.ԉ ()F
      // af: fconst_1
      // b0: fsub
      // b1: invokevirtual x/oc70db705765.ď (F)V
      // b4: goto b8
      // b7: athrow
      // b8: return
   }

   @oc66fa4f2195
   public void Â(oc52918cda9d param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 19
      // 09: bipush 1
      // 0a: invokevirtual x/T.Ȱ (I)Z
      // 0d: ifne 1c
      // 10: goto 14
      // 13: athrow
      // 14: aload 0
      // 15: goto 19
      // 18: athrow
      // 19: invokevirtual x/T.b ()V
      // 1c: return
   }

   @oc66fa4f2195
   public void Ρ(ocebec3dfd67 var1) {
      this.b();
   }

   @oc66fa4f2195
   public void ȗ(occ48acb5d22 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 18
      // 09: getfield x/occ48acb5d22.Ǻ Lnet/minecraft/entity/Entity;
      // 0c: ifnull 4a
      // 0f: goto 13
      // 12: athrow
      // 13: aload 1
      // 14: goto 18
      // 17: athrow
      // 18: iload 2
      // 19: ifne 2b
      // 1c: getfield x/occ48acb5d22.Ǖ Lnet/minecraft/entity/player/EntityPlayer;
      // 1f: ifnull 37
      // 22: goto 26
      // 25: athrow
      // 26: aload 1
      // 27: goto 2b
      // 2a: athrow
      // 2b: getfield x/occ48acb5d22.Ǖ Lnet/minecraft/entity/player/EntityPlayer;
      // 2e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 31: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 34: if_acmpne 4a
      // 37: aload 0
      // 38: aload 1
      // 39: getfield x/occ48acb5d22.Ǻ Lnet/minecraft/entity/Entity;
      // 3c: putfield x/T.Ĭ Lnet/minecraft/entity/Entity;
      // 3f: aload 0
      // 40: invokestatic java/lang/System.currentTimeMillis ()J
      // 43: putfield x/T.Җ J
      // 46: goto 4a
      // 49: athrow
      // 4a: return
   }

   @oc66fa4f2195
   public void њ(ocbab3c9954b var1) {
      this.b();
      this.ѱ();
   }

   public static boolean Գ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: getstatic x/oc9755810e45.ȕ Lx/T;
      // 06: astore 1
      // 07: istore 0
      // 08: aload 1
      // 09: iload 0
      // 0a: ifne 15
      // 0d: ifnull 3a
      // 10: goto 14
      // 13: athrow
      // 14: aload 1
      // 15: iload 0
      // 16: ifne 28
      // 19: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 1c: ifeq 3a
      // 1f: goto 23
      // 22: athrow
      // 23: aload 1
      // 24: goto 28
      // 27: athrow
      // 28: invokevirtual x/T.ˠ ()Z
      // 2b: iload 0
      // 2c: ifne 37
      // 2f: ifeq 3a
      // 32: goto 36
      // 35: athrow
      // 36: bipush 1
      // 37: goto 3b
      // 3a: bipush 0
      // 3b: ireturn
   }

   public static boolean ɠ() {
      return false;
   }

   private boolean ˠ() {
      int var1 = oc5e549848f3.İ;
      int var2 = -1353573684 ^ -1747347830;

      while (true) {
         label121:
         while (true) {
            switch (var2) {
               case -2053454603:
                  return true;
               case -1763593810:
                  int var8;
                  label110: {
                     label109: {
                        try {
                           var8 = oc69da1aa7f5.ő.thePlayer.onGround;
                           if (var1 != 0) {
                              break label110;
                           }

                           if (oc69da1aa7f5.ő.thePlayer.onGround) {
                              break label109;
                           }
                        } catch (ocbde1165e4e var7) {
                           throw var7;
                        }

                        var2 = -684262435 ^ -1747347830;
                        if (var1 == 0) {
                           continue;
                        }
                     }

                     var8 = 306401919 ^ -1747347830;
                  }

                  var2 = var8;
                  if (var1 == 0) {
                     continue;
                  }
               case 2102778324:
                  int var9;
                  label100: {
                     label99: {
                        try {
                           var9 = this.Ȱ(1);
                           if (var1 != 0) {
                              break label100;
                           }

                           if (var9 == 0) {
                              break label99;
                           }
                        } catch (ocbde1165e4e var6) {
                           throw var6;
                        }

                        var2 = 1777701351 ^ -1747347830;
                        if (var1 == 0) {
                           continue;
                        }
                     }

                     var9 = -1628163474 ^ -1747347830;
                  }

                  var2 = var9;
                  if (var1 == 0) {
                     continue;
                  }
               case -30668947:
                  break;
               case 153986276:
                  return false;
               case 948669510:
                  break label121;
               case 1089432919:
                  int var10000;
                  label68: {
                     label67: {
                        try {
                           var10000 = this.Ʀ.ǭ();
                           if (var1 != 0) {
                              break label68;
                           }

                           if (var10000 != 0) {
                              break label67;
                           }
                        } catch (ocbde1165e4e var3) {
                           throw var3;
                        }

                        var2 = 306401919 ^ -1747347830;
                        if (var1 == 0) {
                           continue;
                        }
                     }

                     var10000 = -1628163474 ^ -1747347830;
                  }

                  var2 = var10000;
                  if (var1 != 0) {
                     return false;
                  }
                  continue;
               default:
                  throw null;
            }

            int var10;
            label89: {
               label88: {
                  try {
                     var10 = this.Ġ;
                     if (var1 != 0) {
                        break label89;
                     }

                     if (this.Ġ + 1 != oc69da1aa7f5.ő.thePlayer.ticksExisted) {
                        break label88;
                     }
                  } catch (ocbde1165e4e var5) {
                     throw var5;
                  }

                  var2 = 20457252 ^ -1747347830;
                  if (var1 == 0) {
                     continue;
                  }
               }

               var10 = -1628163474 ^ -1747347830;
            }

            var2 = var10;
            if (var1 != 0) {
               break;
            }
         }

         int var11;
         label77: {
            label76: {
               try {
                  var11 = oc7ab2161b9f.Ð();
                  if (var1 != 0) {
                     break label77;
                  }

                  if (var11 == 0) {
                     break label76;
                  }
               } catch (ocbde1165e4e var4) {
                  throw var4;
               }

               var2 = -359903394 ^ -1747347830;
               if (var1 == 0) {
                  continue;
               }
            }

            var11 = -1628163474 ^ -1747347830;
         }

         var2 = var11;
         if (var1 != 0) {
            return true;
         }
      }
   }

   private boolean γ() {
      byte var2 = 0;
      byte var3 = 0;
      int var4 = 175505773 ^ 583674031;
      int var1 = oc5e549848f3.İ;

      while (true) {
         label218:
         while (true) {
            label216:
            while (true) {
               label214:
               while (true) {
                  label212:
                  while (true) {
                     label206:
                     while (true) {
                        label204:
                        do {
                           label202:
                           while (true) {
                              switch (var4) {
                                 case -1810130877:
                                    break label212;
                                 case -1538959927:
                                    break;
                                 case -1527822382:
                                    int var14;
                                    label147: {
                                       label146: {
                                          try {
                                             var14 = var3;
                                             if (var1 != 0) {
                                                break label147;
                                             }

                                             if (var3 != 0) {
                                                break label146;
                                             }
                                          } catch (ocbde1165e4e var9) {
                                             throw var9;
                                          }

                                          var4 = 1384995544 ^ 583674031;
                                          if (var1 == 0) {
                                             continue;
                                          }
                                       }

                                       var14 = -1662741116 ^ 583674031;
                                    }

                                    var4 = var14;
                                    if (var1 == 0) {
                                       continue;
                                    }
                                 case -1337972954:
                                    break label214;
                                 case -1104233173:
                                    return true;
                                 case -916709984:
                                    var3 = 1;
                                    var4 = -1227771668 ^ 583674031;
                                    if (var1 != 0) {
                                       break label216;
                                    }
                                    continue;
                                 case -911797967:
                                    break label206;
                                 case 683420098:
                                    int var10000;
                                    label183: {
                                       label182: {
                                          try {
                                             var10000 = this.Ġ;
                                             if (var1 != 0) {
                                                break label183;
                                             }

                                             if (this.Ġ >= 0) {
                                                break label182;
                                             }
                                          } catch (ocbde1165e4e var12) {
                                             throw var12;
                                          }

                                          var4 = 1802645661 ^ 583674031;
                                          if (var1 == 0) {
                                             continue;
                                          }
                                       }

                                       var10000 = 1234259131 ^ 583674031;
                                    }

                                    var4 = var10000;
                                    if (var1 == 0) {
                                       continue;
                                    }
                                 case -1344584402:
                                    var2 = 1;
                                    var4 = -1836445815 ^ 583674031;
                                    if (var1 == 0) {
                                       continue;
                                    }
                                    break;
                                 case 1082281897:
                                    break label202;
                                 case 1236801586:
                                    return false;
                                 case 1393653706:
                                    break label204;
                                 case 1464865467:
                                    return false;
                                 case 1801151508:
                                    break label216;
                                 case 1883730551:
                                    break label218;
                                 default:
                                    throw null;
                              }

                              var3 = 0;
                              var4 = -1227771668 ^ 583674031;
                              if (var1 != 0) {
                                 break;
                              }
                           }

                           var2 = 0;
                           var4 = -1836445815 ^ 583674031;
                        } while (var1 == 0);

                        int var17;
                        label168: {
                           label167: {
                              try {
                                 var17 = this.ˠ;
                                 if (var1 != 0) {
                                    break label168;
                                 }

                                 if (this.ˠ != 0) {
                                    break label167;
                                 }
                              } catch (ocbde1165e4e var11) {
                                 throw var11;
                              }

                              var4 = -342477553 ^ 583674031;
                              if (var1 == 0) {
                                 continue;
                              }
                           }

                           var17 = -2037416602 ^ 583674031;
                        }

                        var4 = var17;
                        if (var1 != 0) {
                           break;
                        }
                     }

                     int var18;
                     label156: {
                        label155: {
                           try {
                              var18 = this.Ġ;
                              if (var1 != 0) {
                                 break label156;
                              }

                              if (this.Ġ != oc69da1aa7f5.ő.thePlayer.ticksExisted) {
                                 break label155;
                              }
                           } catch (ocbde1165e4e var10) {
                              throw var10;
                           }

                           var4 = -2044366979 ^ 583674031;
                           if (var1 == 0) {
                              continue;
                           }
                        }

                        var18 = 1973041684 ^ 583674031;
                     }

                     var4 = var18;
                     if (var1 != 0) {
                        break;
                     }
                  }

                  int var19;
                  label133: {
                     label132: {
                        try {
                           var19 = var2;
                           if (var1 != 0) {
                              break label133;
                           }

                           if (var2 != 0) {
                              break label132;
                           }
                        } catch (ocbde1165e4e var8) {
                           throw var8;
                        }

                        var4 = -345163362 ^ 583674031;
                        if (var1 == 0) {
                           continue;
                        }
                     }

                     var19 = -2044366979 ^ 583674031;
                  }

                  var4 = var19;
                  if (var1 != 0) {
                     return true;
                  }
               }

               int var15;
               label124: {
                  label123: {
                     try {
                        var15 = this.Ȣ.Ũ(this.ˠ);
                        if (var1 != 0) {
                           break label124;
                        }

                        if (var15 != 0) {
                           break label123;
                        }
                     } catch (ocbde1165e4e var7) {
                        throw var7;
                     }

                     var4 = 1910202213 ^ 583674031;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var15 = -342477553 ^ 583674031;
               }

               var4 = var15;
               if (var1 != 0) {
                  break label218;
               }
            }

            int var13;
            label106: {
               label105: {
                  try {
                     var13 = this.Ȣ.Ũ(this.ˠ + this.Β);
                     if (var1 != 0) {
                        break label106;
                     }

                     if (var13 != 0) {
                        break label105;
                     }
                  } catch (ocbde1165e4e var5) {
                     throw var5;
                  }

                  var4 = -1928237695 ^ 583674031;
                  if (var1 == 0) {
                     continue;
                  }
               }

               var13 = 1648912134 ^ 583674031;
            }

            var4 = var13;
            if (var1 != 0) {
               return false;
            }
         }

         int var16;
         label115: {
            label114: {
               try {
                  var16 = this.Ġ;
                  if (var1 != 0) {
                     break label115;
                  }

                  if (this.Ġ != oc69da1aa7f5.ő.thePlayer.ticksExisted) {
                     break label114;
                  }
               } catch (ocbde1165e4e var6) {
                  throw var6;
               }

               var4 = -1662741116 ^ 583674031;
               if (var1 == 0) {
                  continue;
               }
            }

            var16 = 1973041684 ^ 583674031;
         }

         var4 = var16;
      }
   }

   private boolean ѭ(Entity var1) {
      int var2 = oc5e549848f3.İ;
      int var3 = -1252019577 ^ 313405280;

      while (true) {
         label200:
         while (true) {
            label198:
            while (true) {
               label196:
               while (true) {
                  label194:
                  while (true) {
                     label192:
                     while (true) {
                        switch (var3) {
                           case -1611935866:
                              break label192;
                           case -1477337625:
                              break label200;
                           case -1181603585:
                              int var13;
                              label104: {
                                 label103: {
                                    try {
                                       var13 = var1.isDead;
                                       if (var2 != 0) {
                                          break label104;
                                       }

                                       if (var1.isDead) {
                                          break label103;
                                       }
                                    } catch (ocbde1165e4e var4) {
                                       throw var4;
                                    }

                                    var3 = -2059710048 ^ 313405280;
                                    if (var2 == 0) {
                                       continue;
                                    }
                                 }

                                 var13 = -1370514516 ^ 313405280;
                              }

                              var3 = var13;
                              continue;
                           case -1163992368:
                              break label198;
                           case -1126058804:
                              return false;
                           case -803621130:
                              break label194;
                           case 93650224:
                              return true;
                           case 134293449:
                              break label196;
                           case 786139606:
                              int var10000;
                              label177: {
                                 label176: {
                                    try {
                                       var10000 = oca4f99d2d44.Λ(var1);
                                       if (var2 != 0) {
                                          break label177;
                                       }

                                       if (var10000 != 0) {
                                          break label176;
                                       }
                                    } catch (ocbde1165e4e var11) {
                                       throw var11;
                                    }

                                    var3 = -1028154986 ^ 313405280;
                                    if (var2 == 0) {
                                       continue;
                                    }
                                 }

                                 var10000 = -1370514516 ^ 313405280;
                              }

                              var3 = var10000;
                              if (var2 == 0) {
                                 continue;
                              }
                           case -1751810368:
                              int var12;
                              label167: {
                                 label166: {
                                    try {
                                       var12 = var1.isEntityAlive();
                                       if (var2 != 0) {
                                          break label167;
                                       }

                                       if (var12 == 0) {
                                          break label166;
                                       }
                                    } catch (ocbde1165e4e var10) {
                                       throw var10;
                                    }

                                    var3 = 1014343350 ^ 313405280;
                                    if (var2 == 0) {
                                       continue;
                                    }
                                 }

                                 var12 = -1370514516 ^ 313405280;
                              }

                              var3 = var12;
                              if (var2 == 0) {
                                 continue;
                              }
                           case 834092140:
                              break;
                           default:
                              throw null;
                        }

                        if (var1 != oc69da1aa7f5.ő.thePlayer) {
                           var3 = -1422129249 ^ 313405280;
                           if (var2 == 0) {
                              continue;
                           }
                        }

                        var3 = -1370514516 ^ 313405280;
                        if (var2 != 0) {
                           break;
                        }
                     }

                     int var14;
                     label156: {
                        label155: {
                           try {
                              var14 = this.ճ(var1);
                              if (var2 != 0) {
                                 break label156;
                              }

                              if (var14 == 0) {
                                 break label155;
                              }
                           } catch (ocbde1165e4e var9) {
                              throw var9;
                           }

                           var3 = 447678633 ^ 313405280;
                           if (var2 == 0) {
                              continue;
                           }
                        }

                        var14 = -1370514516 ^ 313405280;
                     }

                     var3 = var14;
                     if (var2 != 0) {
                        break;
                     }
                  }

                  int var15;
                  label146: {
                     label145: {
                        try {
                           var15 = oc7ab2161b9f.Ӭ((EntityPlayer)var1);
                           if (var2 != 0) {
                              break label146;
                           }

                           if (var15 != 0) {
                              break label145;
                           }
                        } catch (ocbde1165e4e var8) {
                           throw var8;
                        }

                        var3 = -1473196624 ^ 313405280;
                        if (var2 == 0) {
                           continue;
                        }
                     }

                     var15 = -1370514516 ^ 313405280;
                  }

                  var3 = var15;
                  if (var2 != 0) {
                     break;
                  }
               }

               int var16;
               label136: {
                  label135: {
                     try {
                        var16 = this.ɒ(var1);
                        if (var2 != 0) {
                           break label136;
                        }

                        if (var16 == 0) {
                           break label135;
                        }
                     } catch (ocbde1165e4e var7) {
                        throw var7;
                     }

                     var3 = 389730896 ^ 313405280;
                     if (var2 == 0) {
                        continue;
                     }
                  }

                  var16 = -1370514516 ^ 313405280;
               }

               var3 = var16;
               if (var2 != 0) {
                  break;
               }
            }

            int var17;
            label126: {
               label125: {
                  try {
                     var17 = oc7ab2161b9f.ӥ((EntityPlayer)var1);
                     if (var2 != 0) {
                        break label126;
                     }

                     if (var17 != 0) {
                        break label125;
                     }
                  } catch (ocbde1165e4e var6) {
                     throw var6;
                  }

                  var3 = -1924800282 ^ 313405280;
                  if (var2 == 0) {
                     continue;
                  }
               }

               var17 = -1370514516 ^ 313405280;
            }

            var3 = var17;
            if (var2 != 0) {
               break;
            }
         }

         int var18;
         label113: {
            label112: {
               try {
                  var18 = var1 instanceof EntityPlayer;
                  if (var2 != 0) {
                     break label113;
                  }

                  if (var18 == 0) {
                     break label112;
                  }
               } catch (ocbde1165e4e var5) {
                  throw var5;
               }

               var3 = 588845836 ^ 313405280;
               if (var2 == 0) {
                  continue;
               }
            }

            var18 = -1370514516 ^ 313405280;
         }

         var3 = var18;
         if (var2 != 0) {
            return true;
         }
      }
   }

   private boolean ճ(Entity var1) {
      int var2 = oc5e549848f3.İ;
      int var3 = -1323487356 ^ -1988815203;

      while (true) {
         switch (var3) {
            case -2007510534:
               return false;
            case -812519007:
               return true;
            case -386736843:
               int var10000;
               label57: {
                  label56: {
                     try {
                        long var5;
                        var10000 = (var5 = System.currentTimeMillis() - this.Җ - (1373046004257926036L ^ 1373046004257925244L)) == 0L
                           ? 0
                           : (var5 < 0L ? -1 : 1);
                        if (var2 != 0) {
                           break label57;
                        }

                        if (var10000 > 0) {
                           break label56;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var3 = -740613929 ^ -1988815203;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var10000 = -1272636682 ^ -1988815203;
               }

               var3 = var10000;
               if (var2 == 0) {
                  break;
               }
            case 1521366602:
               return true;
            case 721483968:
               if (oc69da1aa7f5.ő.objectMouseOver.entityHit == var1) {
                  var3 = -1609439742 ^ -1988815203;
                  if (var2 == 0) {
                     break;
                  }
               }

               var3 = 19056487 ^ -1988815203;
               if (var2 == 0) {
                  break;
               }
            case 694481055:
               return true;
            case 2055105265:
               if (this.Ĭ == var1) {
                  var3 = 1636289448 ^ -1988815203;
                  if (var2 == 0) {
                     break;
                  }
               }

               var3 = -1272636682 ^ -1988815203;
               if (var2 == 0) {
                  break;
               }
            case 946354457:
               if (ocdd342096f8.f == var1) {
                  var3 = 1189406524 ^ -1988815203;
                  if (var2 == 0) {
                     break;
                  }
               }

               var3 = -217351060 ^ -1988815203;
               if (var2 == 0) {
                  break;
               }
            case 1028656235:
               if (oc69da1aa7f5.ő.objectMouseOver != null) {
                  var3 = -1569329571 ^ -1988815203;
                  if (var2 == 0) {
                     break;
                  }
               }

               var3 = 19056487 ^ -1988815203;
               break;
            default:
               throw null;
         }
      }
   }

   private boolean ɒ(Entity var1) {
      double var3 = 0.0;
      int var5 = -1856358264 ^ -169015395;
      int var2 = oc5e549848f3.İ;

      while (true) {
         switch (var5) {
            case -404118730:
               return true;
            case 401709038:
               return false;
            case 1689730837:
               var3 = oc69da1aa7f5.ő.thePlayer.getDistanceToEntity(var1);

               label26: {
                  try {
                     if (var2 != 0) {
                        break;
                     }

                     if (!(var3 <= 6.0)) {
                        break label26;
                     }
                  } catch (ocbde1165e4e var6) {
                     throw var6;
                  }

                  var5 = 302294187 ^ -169015395;
                  if (var2 == 0) {
                     break;
                  }
               }

               var5 = -501444493 ^ -169015395;
               break;
            default:
               throw null;
         }
      }
   }

   private boolean П() {
      return this.Ȱ(0);
   }

   private boolean Ȱ(int var1) {
      int var2 = oc5e549848f3.İ;
      int var3 = -229908831 ^ -90365557;

      while (true) {
         switch (var3) {
            case -939678514:
               return false;
            case -54724475:
               return true;
            case 148307754:
               int var10000;
               label29: {
                  label28: {
                     try {
                        var10000 = (int)this.ɺ.Ӂ();
                        if (var2 != 0) {
                           break label29;
                        }

                        if (var10000 != var1) {
                           break label28;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var3 = 102881550 ^ -90365557;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var10000 = 1029735749 ^ -90365557;
               }

               var3 = var10000;
               break;
            default:
               throw null;
         }
      }
   }

   private void Û(KeyBinding param1, boolean param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 3
      // 04: aload 0
      // 05: iload 3
      // 06: ifne 1b
      // 09: getfield x/T.Ԉ Lnet/minecraft/client/settings/KeyBinding;
      // 0c: ifnull 15
      // 0f: goto 13
      // 12: athrow
      // 13: return
      // 14: athrow
      // 15: aload 0
      // 16: aload 1
      // 17: putfield x/T.Ԉ Lnet/minecraft/client/settings/KeyBinding;
      // 1a: aload 0
      // 1b: aload 1
      // 1c: invokevirtual net/minecraft/client/settings/KeyBinding.isKeyDown ()Z
      // 1f: putfield x/T.ñ Z
      // 22: aload 1
      // 23: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // 26: iload 2
      // 27: invokestatic net/minecraft/client/settings/KeyBinding.setKeyBindState (IZ)V
      // 2a: return
   }

   private void b() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 24
      // 09: getfield x/T.Ԉ Lnet/minecraft/client/settings/KeyBinding;
      // 0c: ifnonnull 15
      // 0f: goto 13
      // 12: athrow
      // 13: return
      // 14: athrow
      // 15: aload 0
      // 16: getfield x/T.Ԉ Lnet/minecraft/client/settings/KeyBinding;
      // 19: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // 1c: aload 0
      // 1d: getfield x/T.ñ Z
      // 20: invokestatic net/minecraft/client/settings/KeyBinding.setKeyBindState (IZ)V
      // 23: aload 0
      // 24: aconst_null
      // 25: putfield x/T.Ԉ Lnet/minecraft/client/settings/KeyBinding;
      // 28: return
   }

   private void ѱ() {
      this.ˠ = 0;
      this.Β = 0;
      this.Ġ = -1;
      this.Ĭ = null;
      this.Җ = 0L;
   }

   static {
      String[] var10000 = new String[-72611642 ^ -72611644];
      var10000[0] = "WTap";
      var10000[1] = "NoStop";
      ğ = var10000;
   }
}

package x;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import org.lwjgl.opengl.GL11;

public class oc08bf1f1a9e extends oc69da1aa7f5 {
   private static final int Ѱ = -1;
   private static final int ռ = 18;
   private static final float Î = 20.0F;
   private static final double U = 4.0;
   private static final int γ = 0;
   private static final int Ĳ = 1;
   private static final String[] ұ;
   private static final int ŉ = 0;
   private static final int Ѻ = 1;
   private static final int Ñ = 2;
   private static final String[] Ĕ;
   private static final long Є = 1500L;
   private static final double Ϗ = 1.2;
   private final occc831eff22 A;
   private final occ2f8dff8d8 ǟ;
   private final occ2f8dff8d8 Ӕ;
   private final occ2f8dff8d8 ն;
   private final oca9cc61aada Β;
   private final oca9cc61aada Ѓ;
   private final occ2f8dff8d8 ѐ;
   private final ocf1568fef75 Ǭ;
   private final occ2f8dff8d8 Ğ;
   private final oc278c6c6c7f Ƨ = new oc278c6c6c7f();
   private final Random ð = new Random();
   private boolean ҩ;
   private boolean ƃ;
   private boolean Ū;
   private boolean θ;
   private boolean Ƞ;
   private float Þ;
   private float ğ;
   private int Ń = -1;
   private EntityPlayer ǿ;
   private int Ԉ = -1;
   private float ȉ;
   private long ֆ;
   private EntityPlayer Ƽ;
   private float ş;
   private float Ӎ;
   private float Ǖ;
   private long ƒ;
   private boolean ӧ;
   private long Ȓ = -6854562248066822211L ^ 6854562248066822210L;
   private int þ = -1;
   private long ϵ = -6854562248066822211L ^ 6854562248066822210L;
   public static int ș;

   public oc08bf1f1a9e() {
      super("KBDisplacement", oce4cea752dd.ȁ);
      this.ą("Adjusts attack yaw to influence knockback direction.");
      this.ʌ(this.A = new occc831eff22("Condition"));
      this.ʌ(this.ǟ = new occ2f8dff8d8(this.A, "Weapon only", true));
      this.ʌ(this.Ӕ = new occ2f8dff8d8(this.A, "Sprint only", true));
      this.ʌ(this.ն = new occ2f8dff8d8(this.A, "Ignore teammates", true));
      this.ʌ(this.Β = new oca9cc61aada("Mode", 0, ұ));
      this.ʌ(this.Ѓ = new oca9cc61aada("Direction", 1620670945 ^ 1620670947, Ĕ));
      this.ʌ(this.ѐ = new occ2f8dff8d8("Draw Arrow", true));
      this.ʌ(this.Ǭ = new ocf1568fef75("Yaw offset", 0.0, 180.0, 75.0, 90.0, 0.1));
      this.ʌ(this.Ğ = new occ2f8dff8d8("HideFlick", false));
      this.ɮ = true;
      this.z$2u87utkr1isxg();
   }

   @Override
   public void z$2u87utkr1isxg() {
      int var10000 = oc5e549848f3.İ;
      this.A.ȉ(true, this);
      int var1 = var10000;

      boolean var10001;
      label22: {
         label21: {
            try {
               var3 = this.Ѓ;
               var10001 = this.Ι();
               if (var1 != 0) {
                  break label22;
               }

               if (!var10001) {
                  break label21;
               }
            } catch (ocbde1165e4e var2) {
               throw var2;
            }

            var10001 = false;
            break label22;
         }

         var10001 = true;
      }

      var3.ȉ(var10001, this);
   }

   @Override
   public String getInfo() {
      return ұ[(int)this.Β.Ӂ()];
   }

   @Override
   public void onEnable() {
      this.Ƨ.ɕ();
      this.Ī();
   }

   @Override
   public void onDisable() {
      this.Ƨ.ň();
      this.ɉ();
      this.Ī();
   }

   @oc66fa4f2195
   public void Ԝ(ocf6b0e5bf86 param1) {
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
      // 06: ifne 25
      // 09: bipush 0
      // 0a: putfield x/oc08bf1f1a9e.θ Z
      // 0d: aload 0
      // 0e: bipush 0
      // 0f: putfield x/oc08bf1f1a9e.Ƞ Z
      // 12: aload 0
      // 13: getfield x/oc08bf1f1a9e.Ğ Lx/occ2f8dff8d8;
      // 16: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 19: ifne 2b
      // 1c: goto 20
      // 1f: athrow
      // 20: aload 0
      // 21: goto 25
      // 24: athrow
      // 25: getfield x/oc08bf1f1a9e.Ƨ Lx/oc278c6c6c7f;
      // 28: invokevirtual x/oc278c6c6c7f.ň ()V
      // 2b: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGH
   )
   public void Ң(oc86de9e2892 param1) {
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
      // 08: ifne 2c
      // 0b: ifne 18
      // 0e: goto 12
      // 11: athrow
      // 12: aload 0
      // 13: invokevirtual x/oc08bf1f1a9e.Ī ()V
      // 16: return
      // 17: athrow
      // 18: aload 0
      // 19: iload 2
      // 1a: ifne 30
      // 1d: bipush 1
      // 1e: putfield x/oc08bf1f1a9e.θ Z
      // 21: aload 0
      // 22: getfield x/oc08bf1f1a9e.Ğ Lx/occ2f8dff8d8;
      // 25: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 28: goto 2c
      // 2b: athrow
      // 2c: ifne 36
      // 2f: aload 0
      // 30: getfield x/oc08bf1f1a9e.Ƨ Lx/oc278c6c6c7f;
      // 33: invokevirtual x/oc278c6c6c7f.ň ()V
      // 36: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 39: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 3c: astore 3
      // 3d: aload 0
      // 3e: iload 2
      // 3f: ifne 92
      // 42: getfield x/oc08bf1f1a9e.ҩ Z
      // 45: ifeq 91
      // 48: goto 4c
      // 4b: athrow
      // 4c: aload 0
      // 4d: iload 2
      // 4e: ifne 6b
      // 51: goto 55
      // 54: athrow
      // 55: aload 1
      // 56: aload 3
      // 57: getfield net/minecraft/entity/player/EntityPlayer.rotationYaw F
      // 5a: aload 3
      // 5b: getfield net/minecraft/entity/player/EntityPlayer.rotationPitch F
      // 5e: invokevirtual x/oc08bf1f1a9e.ɭ (Lx/oc86de9e2892;FF)Z
      // 61: ifne 6a
      // 64: goto 68
      // 67: athrow
      // 68: return
      // 69: athrow
      // 6a: aload 0
      // 6b: iload 2
      // 6c: ifne 8d
      // 6f: getfield x/oc08bf1f1a9e.Ğ Lx/occ2f8dff8d8;
      // 72: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 75: ifeq 87
      // 78: goto 7c
      // 7b: athrow
      // 7c: aload 0
      // 7d: getfield x/oc08bf1f1a9e.Ƨ Lx/oc278c6c6c7f;
      // 80: invokevirtual x/oc278c6c6c7f.ň ()V
      // 83: goto 87
      // 86: athrow
      // 87: aload 0
      // 88: aload 3
      // 89: invokevirtual x/oc08bf1f1a9e.Ӑ (Lnet/minecraft/entity/player/EntityPlayer;)V
      // 8c: aload 0
      // 8d: bipush 0
      // 8e: putfield x/oc08bf1f1a9e.ҩ Z
      // 91: aload 0
      // 92: iload 2
      // 93: ifne ee
      // 96: getfield x/oc08bf1f1a9e.ƃ Z
      // 99: ifeq ed
      // 9c: goto a0
      // 9f: athrow
      // a0: aload 0
      // a1: iload 2
      // a2: ifne bf
      // a5: goto a9
      // a8: athrow
      // a9: aload 1
      // aa: aload 0
      // ab: getfield x/oc08bf1f1a9e.ğ F
      // ae: aload 3
      // af: getfield net/minecraft/entity/player/EntityPlayer.rotationPitch F
      // b2: invokevirtual x/oc08bf1f1a9e.ɭ (Lx/oc86de9e2892;FF)Z
      // b5: ifne be
      // b8: goto bc
      // bb: athrow
      // bc: return
      // bd: athrow
      // be: aload 0
      // bf: iload 2
      // c0: ifne e9
      // c3: getfield x/oc08bf1f1a9e.Ğ Lx/occ2f8dff8d8;
      // c6: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // c9: ifeq e3
      // cc: goto d0
      // cf: athrow
      // d0: aload 0
      // d1: getfield x/oc08bf1f1a9e.Ƨ Lx/oc278c6c6c7f;
      // d4: ldc2_w 1342452249765721432
      // d7: ldc2_w 1342452249765721550
      // da: lxor
      // db: bipush 1
      // dc: invokevirtual x/oc278c6c6c7f.Ւ (JZ)V
      // df: goto e3
      // e2: athrow
      // e3: aload 0
      // e4: bipush 1
      // e5: putfield x/oc08bf1f1a9e.ҩ Z
      // e8: aload 0
      // e9: bipush 0
      // ea: putfield x/oc08bf1f1a9e.ƃ Z
      // ed: aload 0
      // ee: invokevirtual x/oc08bf1f1a9e.և ()V
      // f1: return
   }

   @oc66fa4f2195
   public void Я(oc507025139f param1) {
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
      // 06: ifne 18
      // 09: getfield x/oc08bf1f1a9e.Ū Z
      // 0c: ifne 34
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: getfield x/oc08bf1f1a9e.θ Z
      // 1b: iload 2
      // 1c: ifne 29
      // 1f: ifeq 34
      // 22: goto 26
      // 25: athrow
      // 26: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 29: iload 2
      // 2a: ifne 41
      // 2d: ifne 35
      // 30: goto 34
      // 33: athrow
      // 34: return
      // 35: aload 0
      // 36: iload 2
      // 37: ifne 45
      // 3a: getfield x/oc08bf1f1a9e.ҩ Z
      // 3d: goto 41
      // 40: athrow
      // 41: ifne 66
      // 44: aload 0
      // 45: iload 2
      // 46: ifne 58
      // 49: getfield x/oc08bf1f1a9e.ƃ Z
      // 4c: ifne 66
      // 4f: goto 53
      // 52: athrow
      // 53: aload 0
      // 54: goto 58
      // 57: athrow
      // 58: iload 2
      // 59: ifne 6e
      // 5c: getfield x/oc08bf1f1a9e.Ƞ Z
      // 5f: ifeq 6d
      // 62: goto 66
      // 65: athrow
      // 66: aload 1
      // 67: bipush 1
      // 68: invokevirtual x/oc68d6b191af.setCanceled (Z)V
      // 6b: return
      // 6c: athrow
      // 6d: aload 0
      // 6e: aload 1
      // 6f: getfield x/oc507025139f.ϋ Lnet/minecraft/util/MovingObjectPosition;
      // 72: invokevirtual x/oc08bf1f1a9e.ҳ (Lnet/minecraft/util/MovingObjectPosition;)Lnet/minecraft/entity/player/EntityPlayer;
      // 75: astore 3
      // 76: aload 3
      // 77: ifnull 8e
      // 7a: aload 0
      // 7b: iload 2
      // 7c: ifne 9f
      // 7f: goto 83
      // 82: athrow
      // 83: aload 3
      // 84: invokevirtual x/oc08bf1f1a9e.v (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // 87: ifne 90
      // 8a: goto 8e
      // 8d: athrow
      // 8e: return
      // 8f: athrow
      // 90: aload 1
      // 91: bipush 1
      // 92: invokevirtual x/oc68d6b191af.setCanceled (Z)V
      // 95: aload 0
      // 96: invokevirtual x/oc08bf1f1a9e.ͳ ()V
      // 99: aload 0
      // 9a: aload 3
      // 9b: putfield x/oc08bf1f1a9e.ǿ Lnet/minecraft/entity/player/EntityPlayer;
      // 9e: aload 0
      // 9f: invokevirtual x/oc08bf1f1a9e.Ϥ ()F
      // a2: fstore 4
      // a4: aload 0
      // a5: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // a8: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // ab: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // ae: fload 4
      // b0: fadd
      // b1: putfield x/oc08bf1f1a9e.ğ F
      // b4: aload 0
      // b5: bipush 1
      // b6: putfield x/oc08bf1f1a9e.ƃ Z
      // b9: aload 0
      // ba: aload 3
      // bb: aload 0
      // bc: getfield x/oc08bf1f1a9e.ğ F
      // bf: invokevirtual x/oc08bf1f1a9e.Բ (Lnet/minecraft/entity/player/EntityPlayer;F)V
      // c2: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGH
   )
   public void Փ(oc9d4393f3ce param1) {
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
      // 06: ifne 23
      // 09: getfield x/oc08bf1f1a9e.Ğ Lx/occ2f8dff8d8;
      // 0c: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0f: ifeq 22
      // 12: goto 16
      // 15: athrow
      // 16: aload 0
      // 17: getfield x/oc08bf1f1a9e.Ƨ Lx/oc278c6c6c7f;
      // 1a: aload 1
      // 1b: invokevirtual x/oc278c6c6c7f.Գ (Lx/oc9d4393f3ce;)V
      // 1e: goto 22
      // 21: athrow
      // 22: aload 0
      // 23: iload 2
      // 24: ifne 39
      // 27: getfield x/oc08bf1f1a9e.ѐ Lx/occ2f8dff8d8;
      // 2a: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 2d: ifeq ab
      // 30: goto 34
      // 33: athrow
      // 34: aload 0
      // 35: goto 39
      // 38: athrow
      // 39: getfield x/oc08bf1f1a9e.Ƽ Lnet/minecraft/entity/player/EntityPlayer;
      // 3c: ifnull ab
      // 3f: aload 1
      // 40: iload 2
      // 41: ifne 57
      // 44: goto 48
      // 47: athrow
      // 48: invokevirtual x/oc68d6b191af.isCanceled ()Z
      // 4b: ifne ab
      // 4e: goto 52
      // 51: athrow
      // 52: aload 1
      // 53: goto 57
      // 56: athrow
      // 57: iload 2
      // 58: ifne 6d
      // 5b: invokevirtual x/oc9d4393f3ce.ɟ ()Lnet/minecraft/network/Packet;
      // 5e: instanceof net/minecraft/network/play/client/C02PacketUseEntity
      // 61: ifeq ab
      // 64: goto 68
      // 67: athrow
      // 68: aload 1
      // 69: goto 6d
      // 6c: athrow
      // 6d: invokevirtual x/oc9d4393f3ce.ɟ ()Lnet/minecraft/network/Packet;
      // 70: checkcast net/minecraft/network/play/client/C02PacketUseEntity
      // 73: astore 3
      // 74: aload 3
      // 75: iload 2
      // 76: ifne 8b
      // 79: invokevirtual net/minecraft/network/play/client/C02PacketUseEntity.getAction ()Lnet/minecraft/network/play/client/C02PacketUseEntity$Action;
      // 7c: getstatic net/minecraft/network/play/client/C02PacketUseEntity$Action.ATTACK Lnet/minecraft/network/play/client/C02PacketUseEntity$Action;
      // 7f: if_acmpne ab
      // 82: goto 86
      // 85: athrow
      // 86: aload 3
      // 87: goto 8b
      // 8a: athrow
      // 8b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 8e: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 91: invokevirtual net/minecraft/network/play/client/C02PacketUseEntity.getEntityFromWorld (Lnet/minecraft/world/World;)Lnet/minecraft/entity/Entity;
      // 94: astore 4
      // 96: aload 4
      // 98: aload 0
      // 99: getfield x/oc08bf1f1a9e.Ƽ Lnet/minecraft/entity/player/EntityPlayer;
      // 9c: if_acmpne ab
      // 9f: aload 0
      // a0: aload 0
      // a1: getfield x/oc08bf1f1a9e.Ƽ Lnet/minecraft/entity/player/EntityPlayer;
      // a4: invokevirtual x/oc08bf1f1a9e.ʮ (Lnet/minecraft/entity/player/EntityPlayer;)V
      // a7: goto ab
      // aa: athrow
      // ab: return
   }

   @oc66fa4f2195
   public void Π(ocbab3c9954b var1) {
      this.Ƨ.ɕ();
      this.ɉ();
      this.Ī();
   }

   @oc66fa4f2195
   public void ҍ(oc746a23b244 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc5e549848f3.İ I
      // 003: istore 2
      // 004: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 007: iload 2
      // 008: ifne 025
      // 00b: ifeq 028
      // 00e: goto 012
      // 011: athrow
      // 012: aload 0
      // 013: iload 2
      // 014: ifne 02f
      // 017: goto 01b
      // 01a: athrow
      // 01b: getfield x/oc08bf1f1a9e.ѐ Lx/occ2f8dff8d8;
      // 01e: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 021: goto 025
      // 024: athrow
      // 025: ifne 02e
      // 028: aload 0
      // 029: invokevirtual x/oc08bf1f1a9e.ҹ ()V
      // 02c: return
      // 02d: athrow
      // 02e: aload 0
      // 02f: iload 2
      // 030: ifne 06e
      // 033: getfield x/oc08bf1f1a9e.Ƽ Lnet/minecraft/entity/player/EntityPlayer;
      // 036: ifnull 069
      // 039: goto 03d
      // 03c: athrow
      // 03d: aload 0
      // 03e: iload 2
      // 03f: ifne 06e
      // 042: goto 046
      // 045: athrow
      // 046: getfield x/oc08bf1f1a9e.Ƽ Lnet/minecraft/entity/player/EntityPlayer;
      // 049: getfield net/minecraft/entity/player/EntityPlayer.isDead Z
      // 04c: ifne 069
      // 04f: goto 053
      // 052: athrow
      // 053: aload 0
      // 054: iload 2
      // 055: ifne 06e
      // 058: goto 05c
      // 05b: athrow
      // 05c: getfield x/oc08bf1f1a9e.Ƽ Lnet/minecraft/entity/player/EntityPlayer;
      // 05f: getfield net/minecraft/entity/player/EntityPlayer.deathTime I
      // 062: ifeq 072
      // 065: goto 069
      // 068: athrow
      // 069: aload 0
      // 06a: goto 06e
      // 06d: athrow
      // 06e: invokevirtual x/oc08bf1f1a9e.ҹ ()V
      // 071: return
      // 072: invokestatic java/lang/System.currentTimeMillis ()J
      // 075: lstore 3
      // 076: aload 0
      // 077: iload 2
      // 078: ifne 0b8
      // 07b: getfield x/oc08bf1f1a9e.ӧ Z
      // 07e: ifeq 0b7
      // 081: goto 085
      // 084: athrow
      // 085: aload 0
      // 086: iload 2
      // 087: ifne 0b8
      // 08a: goto 08e
      // 08d: athrow
      // 08e: getfield x/oc08bf1f1a9e.ϵ J
      // 091: lconst_0
      // 092: lcmp
      // 093: ifle 0b7
      // 096: goto 09a
      // 099: athrow
      // 09a: lload 3
      // 09b: aload 0
      // 09c: getfield x/oc08bf1f1a9e.ϵ J
      // 09f: lsub
      // 0a0: ldc2_w -491310283490962843
      // 0a3: ldc2_w -491310283490961707
      // 0a6: lxor
      // 0a7: lcmp
      // 0a8: ifle 0b7
      // 0ab: goto 0af
      // 0ae: athrow
      // 0af: aload 0
      // 0b0: invokevirtual x/oc08bf1f1a9e.Ò ()V
      // 0b3: goto 0b7
      // 0b6: athrow
      // 0b7: aload 0
      // 0b8: aload 0
      // 0b9: getfield x/oc08bf1f1a9e.Ƽ Lnet/minecraft/entity/player/EntityPlayer;
      // 0bc: lload 3
      // 0bd: invokevirtual x/oc08bf1f1a9e.Ң (Lnet/minecraft/entity/player/EntityPlayer;J)D
      // 0c0: dstore 5
      // 0c2: aload 0
      // 0c3: lload 3
      // 0c4: invokevirtual x/oc08bf1f1a9e.Ө (J)F
      // 0c7: aload 0
      // 0c8: dload 5
      // 0ca: invokevirtual x/oc08bf1f1a9e.խ (D)F
      // 0cd: fmul
      // 0ce: fstore 7
      // 0d0: fload 7
      // 0d2: fconst_0
      // 0d3: fcmpg
      // 0d4: iload 2
      // 0d5: ifne 0ef
      // 0d8: ifgt 106
      // 0db: goto 0df
      // 0de: athrow
      // 0df: aload 0
      // 0e0: iload 2
      // 0e1: ifne 102
      // 0e4: goto 0e8
      // 0e7: athrow
      // 0e8: getfield x/oc08bf1f1a9e.ӧ Z
      // 0eb: goto 0ef
      // 0ee: athrow
      // 0ef: ifeq 0fd
      // 0f2: dload 5
      // 0f4: dconst_1
      // 0f5: dcmpl
      // 0f6: iflt 105
      // 0f9: goto 0fd
      // 0fc: athrow
      // 0fd: aload 0
      // 0fe: goto 102
      // 101: athrow
      // 102: invokevirtual x/oc08bf1f1a9e.ҹ ()V
      // 105: return
      // 106: aload 0
      // 107: dload 5
      // 109: invokevirtual x/oc08bf1f1a9e.Ö (D)D
      // 10c: dstore 8
      // 10e: aload 0
      // 10f: aload 0
      // 110: getfield x/oc08bf1f1a9e.Ƽ Lnet/minecraft/entity/player/EntityPlayer;
      // 113: aload 0
      // 114: getfield x/oc08bf1f1a9e.ş F
      // 117: aload 1
      // 118: getfield x/oc746a23b244.Ё F
      // 11b: fload 7
      // 11d: dload 8
      // 11f: invokevirtual x/oc08bf1f1a9e.հ (Lnet/minecraft/entity/player/EntityPlayer;FFFD)V
      // 122: return
   }

   private boolean v(EntityPlayer var1) {
      int var2 = oc5e549848f3.İ;
      int var3 = 1380100286 ^ 2049384440;

      while (true) {
         label174:
         while (true) {
            label172:
            while (true) {
               label170:
               while (true) {
                  switch (var3) {
                     case -2090346236:
                        return true;
                     case -1346430964:
                        break label172;
                     case -1272836214:
                        return false;
                     case -1076016676:
                        break label170;
                     case -313488200:
                        break label174;
                     case 387310020:
                        int var13;
                        label144: {
                           label143: {
                              try {
                                 var13 = this.Ι();
                                 if (var2 != 0) {
                                    break label144;
                                 }

                                 if (var13 == 0) {
                                    break label143;
                                 }
                              } catch (ocbde1165e4e var9) {
                                 throw var9;
                              }

                              var3 = 474499122 ^ 2049384440;
                              if (var2 == 0) {
                                 continue;
                              }
                           }

                           var13 = -113195268 ^ 2049384440;
                        }

                        var3 = var13;
                        if (var2 == 0) {
                           continue;
                        }
                        break label170;
                     case 399814941:
                        return false;
                     case 576033483:
                        break;
                     case 799054670:
                        return false;
                     case 1718573002:
                        int var10000;
                        label155: {
                           label154: {
                              try {
                                 var10000 = this.ŏ(var1);
                                 if (var2 != 0) {
                                    break label155;
                                 }

                                 if (var10000 == 0) {
                                    break label154;
                                 }
                              } catch (ocbde1165e4e var10) {
                                 throw var10;
                              }

                              var3 = -113195268 ^ 2049384440;
                              if (var2 == 0) {
                                 continue;
                              }
                           }

                           var10000 = -838528910 ^ 2049384440;
                        }

                        var3 = var10000;
                        if (var2 == 0) {
                           continue;
                        }
                     case 677754694:
                        int var11;
                        label135: {
                           label134: {
                              try {
                                 var11 = this.Լ(var1);
                                 if (var2 != 0) {
                                    break label135;
                                 }

                                 if (var11 != 0) {
                                    break label134;
                                 }
                              } catch (ocbde1165e4e var8) {
                                 throw var8;
                              }

                              var3 = 1434944694 ^ 2049384440;
                              if (var2 == 0) {
                                 continue;
                              }
                           }

                           var11 = -1753771200 ^ 2049384440;
                        }

                        var3 = var11;
                        if (var2 == 0) {
                           continue;
                        }
                        break;
                     case 1826818001:
                        return false;
                     default:
                        throw null;
                  }

                  int var12;
                  label124: {
                     label123: {
                        try {
                           var12 = this.ǟ.ǭ();
                           if (var2 != 0) {
                              break label124;
                           }

                           if (var12 == 0) {
                              break label123;
                           }
                        } catch (ocbde1165e4e var7) {
                           throw var7;
                        }

                        var3 = -711456780 ^ 2049384440;
                        if (var2 == 0) {
                           continue;
                        }
                     }

                     var12 = 1832058428 ^ 2049384440;
                  }

                  var3 = var12;
                  if (var2 != 0) {
                     break label172;
                  }
               }

               int var14;
               label115: {
                  label114: {
                     try {
                        var14 = oc69da1aa7f5.ő.thePlayer.isSprinting();
                        if (var2 != 0) {
                           break label115;
                        }

                        if (var14 != 0) {
                           break label114;
                        }
                     } catch (ocbde1165e4e var6) {
                        throw var6;
                     }

                     var3 = 1844686565 ^ 2049384440;
                     if (var2 == 0) {
                        continue;
                     }
                  }

                  var14 = 1483902259 ^ 2049384440;
               }

               var3 = var14;
               if (var2 != 0) {
                  break label174;
               }
            }

            int var16;
            label100: {
               label99: {
                  try {
                     var16 = this.Ν(oc69da1aa7f5.ő.thePlayer);
                     if (var2 != 0) {
                        break label100;
                     }

                     if (var16 != 0) {
                        break label99;
                     }
                  } catch (ocbde1165e4e var5) {
                     throw var5;
                  }

                  var3 = 381949993 ^ 2049384440;
                  if (var2 == 0) {
                     continue;
                  }
               }

               var16 = 1832058428 ^ 2049384440;
            }

            var3 = var16;
            if (var2 != 0) {
               return false;
            }
         }

         int var15;
         label91: {
            label90: {
               try {
                  var15 = this.Ӕ.ǭ();
                  if (var2 != 0) {
                     break label91;
                  }

                  if (var15 == 0) {
                     break label90;
                  }
               } catch (ocbde1165e4e var4) {
                  throw var4;
               }

               var3 = -973449692 ^ 2049384440;
               if (var2 == 0) {
                  continue;
               }
            }

            var15 = 1483902259 ^ 2049384440;
         }

         var3 = var15;
         if (var2 != 0) {
            return false;
         }
      }
   }

   private void ͳ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 1
      // 04: getstatic x/oc9755810e45.f Lx/oc8825472e29;
      // 07: iload 1
      // 08: ifne 15
      // 0b: ifnull 23
      // 0e: goto 12
      // 11: athrow
      // 12: getstatic x/oc9755810e45.f Lx/oc8825472e29;
      // 15: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 18: iload 1
      // 19: ifne 30
      // 1c: ifne 24
      // 1f: goto 23
      // 22: athrow
      // 23: return
      // 24: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 27: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 2a: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 2d: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 30: istore 2
      // 31: bipush -1
      // 32: istore 3
      // 33: bipush -1
      // 34: istore 4
      // 36: bipush 0
      // 37: istore 5
      // 39: iload 5
      // 3b: ldc_w -821982378
      // 3e: ldc_w -821982369
      // 41: ixor
      // 42: if_icmpge b2
      // 45: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 48: iload 1
      // 49: ifne d2
      // 4c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 4f: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 52: iload 5
      // 54: invokevirtual net/minecraft/entity/player/InventoryPlayer.getStackInSlot (I)Lnet/minecraft/item/ItemStack;
      // 57: astore 6
      // 59: aload 0
      // 5a: aload 6
      // 5c: invokevirtual x/oc08bf1f1a9e.Ф (Lnet/minecraft/item/ItemStack;)Z
      // 5f: iload 1
      // 60: ifne 81
      // 63: ifne 72
      // 66: goto 6a
      // 69: athrow
      // 6a: iload 1
      // 6b: ifeq ab
      // 6e: goto 72
      // 71: athrow
      // 72: getstatic net/minecraft/enchantment/Enchantment.sharpness Lnet/minecraft/enchantment/Enchantment;
      // 75: getfield net/minecraft/enchantment/Enchantment.effectId I
      // 78: aload 6
      // 7a: invokestatic net/minecraft/enchantment/EnchantmentHelper.getEnchantmentLevel (ILnet/minecraft/item/ItemStack;)I
      // 7d: goto 81
      // 80: athrow
      // 81: istore 7
      // 83: iload 1
      // 84: ifne a8
      // 87: iload 7
      // 89: iload 4
      // 8b: if_icmpgt a4
      // 8e: goto 92
      // 91: athrow
      // 92: iload 2
      // 93: iload 1
      // 94: ifne aa
      // 97: goto 9b
      // 9a: athrow
      // 9b: iload 5
      // 9d: if_icmpne ab
      // a0: goto a4
      // a3: athrow
      // a4: iload 7
      // a6: istore 4
      // a8: iload 5
      // aa: istore 3
      // ab: iinc 5 1
      // ae: iload 1
      // af: ifeq 39
      // b2: iload 3
      // b3: iload 1
      // b4: ifne c4
      // b7: bipush -1
      // b8: if_icmpeq c8
      // bb: goto bf
      // be: athrow
      // bf: iload 3
      // c0: goto c4
      // c3: athrow
      // c4: iload 2
      // c5: if_icmpne ca
      // c8: return
      // c9: athrow
      // ca: aload 0
      // cb: iload 2
      // cc: putfield x/oc08bf1f1a9e.Ń I
      // cf: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // d2: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // d5: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // d8: iload 3
      // d9: putfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // dc: aload 0
      // dd: invokevirtual x/oc08bf1f1a9e.ѓ ()V
      // e0: return
   }

   private boolean ŏ(EntityPlayer param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc5e549848f3.İ I
      // 003: istore 2
      // 004: aload 1
      // 005: ifnull 015
      // 008: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 00b: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 00e: ifnonnull 018
      // 011: goto 015
      // 014: athrow
      // 015: bipush 0
      // 016: ireturn
      // 017: athrow
      // 018: aload 1
      // 019: getfield net/minecraft/entity/player/EntityPlayer.posX D
      // 01c: dstore 3
      // 01d: aload 1
      // 01e: getfield net/minecraft/entity/player/EntityPlayer.posZ D
      // 021: dstore 5
      // 023: aload 1
      // 024: getfield net/minecraft/entity/player/EntityPlayer.posY D
      // 027: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 02a: istore 7
      // 02c: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 02f: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 032: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 035: fstore 8
      // 037: new net/minecraft/util/BlockPos
      // 03a: dup
      // 03b: dload 3
      // 03c: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 03f: iload 7
      // 041: dload 5
      // 043: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 046: invokespecial net/minecraft/util/BlockPos.<init> (III)V
      // 049: astore 9
      // 04b: invokestatic java/lang/System.currentTimeMillis ()J
      // 04e: lstore 10
      // 050: aload 1
      // 051: invokevirtual net/minecraft/entity/player/EntityPlayer.getEntityId ()I
      // 054: iload 2
      // 055: ifne 076
      // 058: aload 0
      // 059: getfield x/oc08bf1f1a9e.Ԉ I
      // 05c: if_icmpne 085
      // 05f: goto 063
      // 062: athrow
      // 063: lload 10
      // 065: aload 0
      // 066: getfield x/oc08bf1f1a9e.ֆ J
      // 069: lsub
      // 06a: ldc2_w -6924298082157447942
      // 06d: ldc2_w -6924298082157448922
      // 070: lxor
      // 071: lcmp
      // 072: goto 076
      // 075: athrow
      // 076: iload 2
      // 077: ifne 082
      // 07a: ifge 085
      // 07d: goto 081
      // 080: athrow
      // 081: bipush 1
      // 082: goto 086
      // 085: bipush 0
      // 086: istore 12
      // 088: aload 0
      // 089: aload 9
      // 08b: invokevirtual x/oc08bf1f1a9e.ş (Lnet/minecraft/util/BlockPos;)Z
      // 08e: ifeq 20e
      // 091: fconst_0
      // 092: fstore 13
      // 094: ldc2_w 1.7976931348623157E308
      // 097: dstore 14
      // 099: bipush 0
      // 09a: istore 16
      // 09c: bipush 0
      // 09d: istore 17
      // 09f: iload 17
      // 0a1: ldc_w -1645149032
      // 0a4: ldc_w -1645149046
      // 0a7: ixor
      // 0a8: if_icmpge 14e
      // 0ab: iload 17
      // 0ad: i2f
      // 0ae: ldc 20.0
      // 0b0: fmul
      // 0b1: fstore 18
      // 0b3: iload 2
      // 0b4: fload 18
      // 0b6: f2d
      // 0b7: invokestatic java/lang/Math.toRadians (D)D
      // 0ba: dstore 19
      // 0bc: ifne 163
      // 0bf: dload 19
      // 0c1: invokestatic java/lang/Math.sin (D)D
      // 0c4: dneg
      // 0c5: dstore 21
      // 0c7: dload 19
      // 0c9: invokestatic java/lang/Math.cos (D)D
      // 0cc: dstore 23
      // 0ce: ldc2_w 0.5
      // 0d1: dstore 25
      // 0d3: dload 25
      // 0d5: ldc2_w 4.0
      // 0d8: dcmpg
      // 0d9: ifgt 147
      // 0dc: dload 3
      // 0dd: dload 21
      // 0df: dload 25
      // 0e1: dmul
      // 0e2: dadd
      // 0e3: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 0e6: istore 27
      // 0e8: iload 2
      // 0e9: ifne 14a
      // 0ec: dload 5
      // 0ee: dload 23
      // 0f0: dload 25
      // 0f2: dmul
      // 0f3: dadd
      // 0f4: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 0f7: istore 28
      // 0f9: iload 2
      // 0fa: ifne 143
      // 0fd: aload 0
      // 0fe: iload 27
      // 100: iload 7
      // 102: iload 28
      // 104: invokevirtual x/oc08bf1f1a9e.ϳ (III)Z
      // 107: ifeq 13b
      // 10a: goto 10e
      // 10d: athrow
      // 10e: dload 25
      // 110: iload 2
      // 111: ifne 128
      // 114: goto 118
      // 117: athrow
      // 118: dload 14
      // 11a: dcmpg
      // 11b: ifge 147
      // 11e: goto 122
      // 121: athrow
      // 122: dload 25
      // 124: goto 128
      // 127: athrow
      // 128: dstore 14
      // 12a: iload 2
      // 12b: fload 18
      // 12d: fload 8
      // 12f: fsub
      // 130: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_float (F)F
      // 133: fstore 13
      // 135: bipush 1
      // 136: istore 16
      // 138: ifeq 147
      // 13b: dload 25
      // 13d: ldc2_w 0.3
      // 140: dadd
      // 141: dstore 25
      // 143: iload 2
      // 144: ifeq 0d3
      // 147: iinc 17 1
      // 14a: iload 2
      // 14b: ifeq 09f
      // 14e: iload 16
      // 150: iload 2
      // 151: ifne 16f
      // 154: ifne 163
      // 157: goto 15b
      // 15a: athrow
      // 15b: aload 0
      // 15c: fconst_0
      // 15d: putfield x/oc08bf1f1a9e.Þ F
      // 160: bipush 0
      // 161: ireturn
      // 162: athrow
      // 163: fload 13
      // 165: iload 2
      // 166: ifne 175
      // 169: fconst_0
      // 16a: fcmpl
      // 16b: goto 16f
      // 16e: athrow
      // 16f: ifle 178
      // 172: ldc_w -1.0
      // 175: goto 179
      // 178: fconst_1
      // 179: fstore 17
      // 17b: iload 2
      // 17c: ifne 20c
      // 17f: iload 12
      // 181: ifeq 203
      // 184: goto 188
      // 187: athrow
      // 188: aload 0
      // 189: iload 2
      // 18a: ifne 204
      // 18d: goto 191
      // 190: athrow
      // 191: getfield x/oc08bf1f1a9e.ȉ F
      // 194: fconst_0
      // 195: fcmpl
      // 196: ifeq 203
      // 199: goto 19d
      // 19c: athrow
      // 19d: aload 0
      // 19e: iload 2
      // 19f: ifne 1c6
      // 1a2: goto 1a6
      // 1a5: athrow
      // 1a6: getfield x/oc08bf1f1a9e.ȉ F
      // 1a9: fconst_0
      // 1aa: fcmpl
      // 1ab: ifle 1c5
      // 1ae: goto 1b2
      // 1b1: athrow
      // 1b2: fload 13
      // 1b4: fconst_0
      // 1b5: fcmpl
      // 1b6: iload 2
      // 1b7: ifne 1ea
      // 1ba: goto 1be
      // 1bd: athrow
      // 1be: ifgt 1e9
      // 1c1: goto 1c5
      // 1c4: athrow
      // 1c5: aload 0
      // 1c6: getfield x/oc08bf1f1a9e.ȉ F
      // 1c9: fconst_0
      // 1ca: iload 2
      // 1cb: ifne 1dd
      // 1ce: fcmpg
      // 1cf: ifge 1ed
      // 1d2: goto 1d6
      // 1d5: athrow
      // 1d6: fload 13
      // 1d8: fconst_0
      // 1d9: goto 1dd
      // 1dc: athrow
      // 1dd: fcmpg
      // 1de: iload 2
      // 1df: ifne 1ea
      // 1e2: ifge 1ed
      // 1e5: goto 1e9
      // 1e8: athrow
      // 1e9: bipush 1
      // 1ea: goto 1ee
      // 1ed: bipush 0
      // 1ee: istore 18
      // 1f0: iload 2
      // 1f1: ifne 20c
      // 1f4: iload 18
      // 1f6: ifne 203
      // 1f9: goto 1fd
      // 1fc: athrow
      // 1fd: aload 0
      // 1fe: getfield x/oc08bf1f1a9e.ȉ F
      // 201: fstore 17
      // 203: aload 0
      // 204: aload 1
      // 205: fload 17
      // 207: lload 10
      // 209: invokevirtual x/oc08bf1f1a9e.ų (Lnet/minecraft/entity/player/EntityPlayer;FJ)V
      // 20c: bipush 1
      // 20d: ireturn
      // 20e: ldc2_w 1.7976931348623157E308
      // 211: dstore 13
      // 213: ldc2_w 1.7976931348623157E308
      // 216: dstore 15
      // 218: bipush 0
      // 219: istore 17
      // 21b: bipush 0
      // 21c: istore 18
      // 21e: bipush 0
      // 21f: istore 19
      // 221: iload 19
      // 223: ldc_w -1645149032
      // 226: ldc_w -1645149046
      // 229: ixor
      // 22a: if_icmpge 3b6
      // 22d: iload 19
      // 22f: i2f
      // 230: ldc 20.0
      // 232: fmul
      // 233: fstore 20
      // 235: iload 2
      // 236: fload 20
      // 238: f2d
      // 239: invokestatic java/lang/Math.toRadians (D)D
      // 23c: dstore 21
      // 23e: dload 21
      // 240: invokestatic java/lang/Math.sin (D)D
      // 243: dneg
      // 244: dstore 23
      // 246: dload 21
      // 248: invokestatic java/lang/Math.cos (D)D
      // 24b: dstore 25
      // 24d: fload 20
      // 24f: fload 8
      // 251: fsub
      // 252: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_float (F)F
      // 255: fstore 27
      // 257: fload 27
      // 259: invokestatic java/lang/Math.abs (F)F
      // 25c: fstore 28
      // 25e: ifne 3b2
      // 261: fload 28
      // 263: iload 2
      // 264: ifne 3c7
      // 267: goto 26b
      // 26a: athrow
      // 26b: ldc_w 30.0
      // 26e: fcmpg
      // 26f: iflt 3af
      // 272: goto 276
      // 275: athrow
      // 276: fload 28
      // 278: ldc_w 150.0
      // 27b: fcmpl
      // 27c: ifle 28b
      // 27f: goto 283
      // 282: athrow
      // 283: iload 2
      // 284: ifeq 3af
      // 287: goto 28b
      // 28a: athrow
      // 28b: ldc2_w 1.7976931348623157E308
      // 28e: dstore 29
      // 290: bipush 0
      // 291: istore 31
      // 293: ldc2_w 0.5
      // 296: dstore 32
      // 298: dload 32
      // 29a: ldc2_w 4.0
      // 29d: dcmpg
      // 29e: ifgt 325
      // 2a1: dload 3
      // 2a2: dload 23
      // 2a4: dload 32
      // 2a6: dmul
      // 2a7: dadd
      // 2a8: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 2ab: istore 34
      // 2ad: iload 2
      // 2ae: dload 5
      // 2b0: dload 25
      // 2b2: dload 32
      // 2b4: dmul
      // 2b5: dadd
      // 2b6: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 2b9: istore 35
      // 2bb: ifne 2f5
      // 2be: iload 2
      // 2bf: ifne 3b2
      // 2c2: goto 2c6
      // 2c5: athrow
      // 2c6: aload 0
      // 2c7: iload 34
      // 2c9: iload 7
      // 2cb: iload 35
      // 2cd: invokevirtual x/oc08bf1f1a9e.ʏ (III)Z
      // 2d0: ifne 2f2
      // 2d3: goto 2d7
      // 2d6: athrow
      // 2d7: aload 0
      // 2d8: iload 2
      // 2d9: ifne 2fe
      // 2dc: goto 2e0
      // 2df: athrow
      // 2e0: iload 34
      // 2e2: iload 7
      // 2e4: bipush 1
      // 2e5: iadd
      // 2e6: iload 35
      // 2e8: invokevirtual x/oc08bf1f1a9e.ʏ (III)Z
      // 2eb: ifeq 2f9
      // 2ee: goto 2f2
      // 2f1: athrow
      // 2f2: bipush 1
      // 2f3: istore 31
      // 2f5: iload 2
      // 2f6: ifeq 325
      // 2f9: aload 0
      // 2fa: goto 2fe
      // 2fd: athrow
      // 2fe: new net/minecraft/util/BlockPos
      // 301: dup
      // 302: iload 34
      // 304: iload 7
      // 306: iload 35
      // 308: invokespecial net/minecraft/util/BlockPos.<init> (III)V
      // 30b: invokevirtual x/oc08bf1f1a9e.ş (Lnet/minecraft/util/BlockPos;)Z
      // 30e: ifeq 319
      // 311: dload 32
      // 313: dstore 29
      // 315: iload 2
      // 316: ifeq 325
      // 319: dload 32
      // 31b: ldc2_w 0.5
      // 31e: dadd
      // 31f: dstore 32
      // 321: iload 2
      // 322: ifeq 298
      // 325: iload 31
      // 327: iload 2
      // 328: ifne 33c
      // 32b: ifne 3af
      // 32e: goto 332
      // 331: athrow
      // 332: dload 29
      // 334: ldc2_w 4.0
      // 337: dcmpl
      // 338: goto 33c
      // 33b: athrow
      // 33c: iload 2
      // 33d: ifne 35f
      // 340: ifle 34f
      // 343: goto 347
      // 346: athrow
      // 347: iload 2
      // 348: ifeq 3af
      // 34b: goto 34f
      // 34e: athrow
      // 34f: fload 27
      // 351: fconst_0
      // 352: iload 2
      // 353: ifne 388
      // 356: goto 35a
      // 359: athrow
      // 35a: fcmpl
      // 35b: goto 35f
      // 35e: athrow
      // 35f: ifle 381
      // 362: dload 29
      // 364: dload 13
      // 366: dcmpg
      // 367: iload 2
      // 368: ifne 389
      // 36b: goto 36f
      // 36e: athrow
      // 36f: ifge 381
      // 372: goto 376
      // 375: athrow
      // 376: dload 29
      // 378: dstore 13
      // 37a: iload 2
      // 37b: bipush 1
      // 37c: istore 17
      // 37e: ifeq 3af
      // 381: fload 27
      // 383: fconst_0
      // 384: goto 388
      // 387: athrow
      // 388: fcmpg
      // 389: iload 2
      // 38a: ifne 3a5
      // 38d: ifge 3af
      // 390: goto 394
      // 393: athrow
      // 394: dload 29
      // 396: iload 2
      // 397: ifne 3aa
      // 39a: goto 39e
      // 39d: athrow
      // 39e: dload 15
      // 3a0: dcmpg
      // 3a1: goto 3a5
      // 3a4: athrow
      // 3a5: ifge 3af
      // 3a8: dload 29
      // 3aa: dstore 15
      // 3ac: bipush 1
      // 3ad: istore 18
      // 3af: iinc 19 1
      // 3b2: iload 2
      // 3b3: ifeq 221
      // 3b6: iload 12
      // 3b8: aload 0
      // 3b9: getfield x/oc08bf1f1a9e.ȉ F
      // 3bc: iload 17
      // 3be: dload 13
      // 3c0: iload 18
      // 3c2: dload 15
      // 3c4: invokestatic x/oc08bf1f1a9e.Ŷ (ZFZDZD)F
      // 3c7: fstore 19
      // 3c9: iload 2
      // 3ca: ifne 3e4
      // 3cd: fload 19
      // 3cf: fconst_0
      // 3d0: fcmpl
      // 3d1: ifne 3db
      // 3d4: goto 3d8
      // 3d7: athrow
      // 3d8: bipush 0
      // 3d9: ireturn
      // 3da: athrow
      // 3db: aload 0
      // 3dc: aload 1
      // 3dd: fload 19
      // 3df: lload 10
      // 3e1: invokevirtual x/oc08bf1f1a9e.ų (Lnet/minecraft/entity/player/EntityPlayer;FJ)V
      // 3e4: bipush 1
      // 3e5: ireturn
   }

   static float Ŷ(boolean param0, float param1, boolean param2, double param3, boolean param5, double param6) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 8
      // 05: iload 2
      // 06: iload 8
      // 08: ifne 28
      // 0b: ifne 27
      // 0e: goto 12
      // 11: athrow
      // 12: iload 5
      // 14: iload 8
      // 16: ifne 28
      // 19: goto 1d
      // 1c: athrow
      // 1d: ifne 27
      // 20: goto 24
      // 23: athrow
      // 24: fconst_0
      // 25: freturn
      // 26: athrow
      // 27: iload 2
      // 28: iload 8
      // 2a: ifne 3b
      // 2d: ifne 39
      // 30: goto 34
      // 33: athrow
      // 34: ldc_w -1.0
      // 37: freturn
      // 38: athrow
      // 39: iload 5
      // 3b: iload 8
      // 3d: ifne 4b
      // 40: ifne 4a
      // 43: goto 47
      // 46: athrow
      // 47: fconst_1
      // 48: freturn
      // 49: athrow
      // 4a: iload 0
      // 4b: iload 8
      // 4d: ifne 86
      // 50: ifeq 85
      // 53: goto 57
      // 56: athrow
      // 57: fload 1
      // 58: fconst_0
      // 59: fcmpl
      // 5a: iload 8
      // 5c: ifne 86
      // 5f: goto 63
      // 62: athrow
      // 63: ifle 85
      // 66: goto 6a
      // 69: athrow
      // 6a: dload 3
      // 6b: dload 6
      // 6d: ldc2_w 1.2
      // 70: dadd
      // 71: dcmpg
      // 72: iload 8
      // 74: ifne 86
      // 77: goto 7b
      // 7a: athrow
      // 7b: ifgt 85
      // 7e: goto 82
      // 81: athrow
      // 82: fconst_1
      // 83: freturn
      // 84: athrow
      // 85: iload 0
      // 86: iload 8
      // 88: ifne c6
      // 8b: ifeq c2
      // 8e: goto 92
      // 91: athrow
      // 92: fload 1
      // 93: fconst_0
      // 94: fcmpg
      // 95: iload 8
      // 97: ifne c6
      // 9a: goto 9e
      // 9d: athrow
      // 9e: ifge c2
      // a1: goto a5
      // a4: athrow
      // a5: dload 6
      // a7: dload 3
      // a8: ldc2_w 1.2
      // ab: dadd
      // ac: iload 8
      // ae: ifne c5
      // b1: goto b5
      // b4: athrow
      // b5: dcmpg
      // b6: ifgt c2
      // b9: goto bd
      // bc: athrow
      // bd: ldc_w -1.0
      // c0: freturn
      // c1: athrow
      // c2: dload 3
      // c3: dload 6
      // c5: dcmpg
      // c6: ifge ce
      // c9: fconst_1
      // ca: goto d1
      // cd: athrow
      // ce: ldc_w -1.0
      // d1: freturn
   }

   private void ų(EntityPlayer var1, float var2, long var3) {
      this.Ԉ = var1.getEntityId();
      this.ȉ = var2;
      this.ֆ = var3;
      this.Þ = var2 * (float)this.Ǭ.ϐ();
   }

   private float Ϥ() {
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
      // 06: ifne 1a
      // 09: invokevirtual x/oc08bf1f1a9e.Ι ()Z
      // 0c: ifeq 19
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: getfield x/oc08bf1f1a9e.Þ F
      // 17: freturn
      // 18: athrow
      // 19: aload 0
      // 1a: getfield x/oc08bf1f1a9e.Ǭ Lx/ocf1568fef75;
      // 1d: invokevirtual x/ocf1568fef75.ϐ ()D
      // 20: d2f
      // 21: fstore 2
      // 22: aload 0
      // 23: getfield x/oc08bf1f1a9e.Ѓ Lx/oca9cc61aada;
      // 26: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 29: d2i
      // 2a: istore 3
      // 2b: iload 3
      // 2c: iload 1
      // 2d: ifne 3c
      // 30: ifne 3b
      // 33: goto 37
      // 36: athrow
      // 37: fload 2
      // 38: fneg
      // 39: freturn
      // 3a: athrow
      // 3b: iload 3
      // 3c: iload 1
      // 3d: ifne 52
      // 40: bipush 1
      // 41: if_icmpne 4b
      // 44: goto 48
      // 47: athrow
      // 48: fload 2
      // 49: freturn
      // 4a: athrow
      // 4b: aload 0
      // 4c: getfield x/oc08bf1f1a9e.ð Ljava/util/Random;
      // 4f: invokevirtual java/util/Random.nextBoolean ()Z
      // 52: ifeq 5a
      // 55: fload 2
      // 56: goto 5c
      // 59: athrow
      // 5a: fload 2
      // 5b: fneg
      // 5c: freturn
   }

   private boolean ɭ(oc86de9e2892 var1, float var2, float var3) {
      return var1.л(this, 1088208811 ^ 1088208519, var2, var3);
   }

   private boolean ϳ(int param1, int param2, int param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: ldc_w 268955869
      // 06: ldc_w -268955869
      // 09: ixor
      // 0a: istore 5
      // 0c: istore 4
      // 0e: iload 5
      // 10: ldc_w -268955872
      // 13: ldc_w -268955869
      // 16: ixor
      // 17: if_icmpgt 43
      // 1a: aload 0
      // 1b: iload 1
      // 1c: iload 2
      // 1d: iload 5
      // 1f: iadd
      // 20: iload 3
      // 21: invokevirtual x/oc08bf1f1a9e.ʏ (III)Z
      // 24: iload 4
      // 26: ifne 44
      // 29: iload 4
      // 2b: ifne 3a
      // 2e: goto 32
      // 31: athrow
      // 32: ifeq 3b
      // 35: goto 39
      // 38: athrow
      // 39: bipush 1
      // 3a: ireturn
      // 3b: iinc 5 1
      // 3e: iload 4
      // 40: ifeq 0e
      // 43: bipush 0
      // 44: ireturn
   }

   private boolean ʏ(int var1, int var2, int var3) {
      Object var5 = null;
      IBlockState var6 = null;
      Block var7 = null;
      int var4 = oc5e549848f3.İ;
      Object var8 = null;
      int var9 = 92378505 ^ 553270862;

      while (true) {
         switch (var9) {
            case -666692012:
               return false;
            case 628861895:
               int var10000;
               label51: {
                  label50: {
                     try {
                        var10000 = var2;
                        if (var4 != 0) {
                           break label51;
                        }

                        if (var2 < 0) {
                           break label50;
                        }
                     } catch (ocbde1165e4e var10) {
                        throw var10;
                     }

                     var9 = 1135746010 ^ 553270862;
                     if (var4 == 0) {
                        break;
                     }
                  }

                  var10000 = 1892619699 ^ 553270862;
               }

               var9 = var10000;
               if (var4 == 0) {
                  break;
               }
            case 1188521825:
               var5 = new BlockPos(var1, var2, var3);
               if (var4 == 0) {
                  var6 = oc69da1aa7f5.ő.theWorld.getBlockState((BlockPos)var5);
                  var7 = var6.getBlock();
                  var8 = var7.getCollisionBoundingBox(oc69da1aa7f5.ő.theWorld, (BlockPos)var5, var6);
                  if (var8 != null) {
                     var9 = 165900696 ^ 553270862;
                     if (var4 == 0) {
                        break;
                     }
                  }

                  var9 = -122083302 ^ 553270862;
               }

               if (var4 == 0) {
                  break;
               }

               return true;
            case 689524694:
               return true;
            case 1345661949:
               return false;
            case 1665672596:
               if (oc69da1aa7f5.ő.theWorld == null) {
                  var9 = 1892619699 ^ 553270862;
                  if (var4 == 0) {
                     break;
                  }
               }

               var9 = 1714247983 ^ 553270862;
               if (var4 == 0) {
                  break;
               }

               return false;
            default:
               throw null;
         }
      }
   }

   private boolean ş(BlockPos param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: bipush 0
      // 04: istore 3
      // 05: istore 2
      // 06: iload 3
      // 07: ldc_w -14889227
      // 0a: ldc_w -14889217
      // 0d: ixor
      // 0e: if_icmpge 5e
      // 11: aload 1
      // 12: bipush 0
      // 13: iload 3
      // 14: ineg
      // 15: bipush 0
      // 16: invokevirtual net/minecraft/util/BlockPos.add (III)Lnet/minecraft/util/BlockPos;
      // 19: astore 4
      // 1b: aload 4
      // 1d: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 20: iload 2
      // 21: ifne 5f
      // 24: iload 2
      // 25: ifne 4a
      // 28: goto 2c
      // 2b: athrow
      // 2c: bipush 1
      // 2d: if_icmpge 37
      // 30: goto 34
      // 33: athrow
      // 34: bipush 1
      // 35: ireturn
      // 36: athrow
      // 37: aload 0
      // 38: aload 4
      // 3a: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 3d: aload 4
      // 3f: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 42: aload 4
      // 44: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 47: invokevirtual x/oc08bf1f1a9e.ʏ (III)Z
      // 4a: iload 2
      // 4b: ifne 56
      // 4e: ifeq 57
      // 51: goto 55
      // 54: athrow
      // 55: bipush 0
      // 56: ireturn
      // 57: iinc 3 1
      // 5a: iload 2
      // 5b: ifeq 06
      // 5e: bipush 1
      // 5f: ireturn
   }

   private EntityPlayer ҳ(MovingObjectPosition param1) {
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
      // 06: ifne 11
      // 09: ifnull 22
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 1
      // 11: iload 2
      // 12: ifne 26
      // 15: getfield net/minecraft/util/MovingObjectPosition.entityHit Lnet/minecraft/entity/Entity;
      // 18: instanceof net/minecraft/entity/player/EntityPlayer
      // 1b: ifne 25
      // 1e: goto 22
      // 21: athrow
      // 22: aconst_null
      // 23: areturn
      // 24: athrow
      // 25: aload 1
      // 26: getfield net/minecraft/util/MovingObjectPosition.entityHit Lnet/minecraft/entity/Entity;
      // 29: checkcast net/minecraft/entity/player/EntityPlayer
      // 2c: astore 3
      // 2d: aload 0
      // 2e: aload 3
      // 2f: invokevirtual x/oc08bf1f1a9e.Լ (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // 32: ifeq 3a
      // 35: aload 3
      // 36: goto 3b
      // 39: athrow
      // 3a: aconst_null
      // 3b: areturn
   }

   private boolean Լ(EntityPlayer var1) {
      int var2 = oc5e549848f3.İ;
      int var3 = 2089323010 ^ 599446984;

      while (true) {
         switch (var3) {
            case 1597136842:
               if (var1 != null) {
                  var3 = -1442813713 ^ 599446984;
                  if (var2 == 0) {
                     break;
                  }
               }

               var3 = 1113710031 ^ 599446984;
               if (var2 == 0) {
                  break;
               }
            case -1984250585:
               int var10000;
               label35: {
                  label34: {
                     try {
                        var10000 = oc5e08d6b90f.Ǝ(var1, this.ն.ǭ());
                        if (var2 != 0) {
                           break label35;
                        }

                        if (var10000 == 0) {
                           break label34;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var3 = 574630131 ^ 599446984;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var10000 = 1113710031 ^ 599446984;
               }

               var3 = var10000;
               if (var2 == 0) {
                  break;
               }
            case 33226043:
               return true;
            case 1641744391:
               return false;
            default:
               throw null;
         }
      }
   }

   private boolean Ν(EntityPlayer var1) {
      ItemStack var3 = null;
      int var4 = -1255606810 ^ -798346677;
      int var2 = oc5e549848f3.İ;

      while (true) {
         switch (var4) {
            case 1698875309:
               if (var1 == null) {
                  var4 = -1423977038 ^ -798346677;
                  if (var2 == 0) {
                     break;
                  }
               }

               var4 = -1456343341 ^ -798346677;
               if (var2 == 0) {
                  break;
               }
            case 566029555:
               return this.Ф(var3);
            case 2036057240:
               var3 = var1.getHeldItem();
               var4 = -237576520 ^ -798346677;
               if (var2 == 0) {
                  break;
               }
            case 2071324665:
               var3 = null;
               var4 = -237576520 ^ -798346677;
               break;
            default:
               throw null;
         }
      }
   }

   private boolean Ф(ItemStack var1) {
      int var2 = oc5e549848f3.İ;
      int var3 = 100026426 ^ 1085695368;

      while (true) {
         switch (var3) {
            case -1735605604:
               int var6;
               label64: {
                  label63: {
                     try {
                        var6 = var1.getItem() instanceof ItemAxe;
                        if (var2 != 0) {
                           break label64;
                        }

                        if (var6 != 0) {
                           break label63;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var3 = -64806630 ^ 1085695368;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var6 = -1476999374 ^ 1085695368;
               }

               var3 = var6;
               if (var2 == 0) {
                  break;
               }
            case 1161833906:
               if (var1 != null) {
                  var3 = 942045492 ^ 1085695368;
                  if (var2 == 0) {
                     break;
                  }
               }

               var3 = -1793882425 ^ 1085695368;
               if (var2 == 0) {
                  break;
               }

               return false;
            case -710548657:
               return false;
            case -415194438:
               return true;
            case 2022710460:
               int var10000;
               label55: {
                  label54: {
                     try {
                        var10000 = var1.getItem() instanceof ItemSword;
                        if (var2 != 0) {
                           break label55;
                        }

                        if (var10000 != 0) {
                           break label54;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var3 = -667244780 ^ 1085695368;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var10000 = -1476999374 ^ 1085695368;
               }

               var3 = var10000;
               if (var2 == 0) {
                  break;
               }
            case -1131068270:
               if (var1.getItem() == Items.stick) {
                  var3 = -1476999374 ^ 1085695368;
                  if (var2 == 0) {
                     break;
                  }
               }

               var3 = -1793882425 ^ 1085695368;
               if (var2 == 0) {
                  break;
               }

               return true;
            default:
               throw null;
         }
      }
   }

   private void Ӑ(EntityPlayer param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield x/oc08bf1f1a9e.ǿ Lnet/minecraft/entity/player/EntityPlayer;
      // 04: astore 3
      // 05: getstatic x/oc5e549848f3.İ I
      // 08: aload 0
      // 09: aconst_null
      // 0a: putfield x/oc08bf1f1a9e.ǿ Lnet/minecraft/entity/player/EntityPlayer;
      // 0d: istore 2
      // 0e: aload 0
      // 0f: bipush 1
      // 10: putfield x/oc08bf1f1a9e.Ƞ Z
      // 13: iload 2
      // 14: ifne 5b
      // 17: aload 0
      // 18: bipush 1
      // 19: putfield x/oc08bf1f1a9e.Ū Z
      // 1c: aload 3
      // 1d: ifnull 56
      // 20: aload 0
      // 21: iload 2
      // 22: ifne 57
      // 25: aload 3
      // 26: invokevirtual x/oc08bf1f1a9e.Լ (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // 29: ifeq 56
      // 2c: goto 30
      // 2f: athrow
      // 30: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 33: iload 2
      // 34: ifne 51
      // 37: goto 3b
      // 3a: athrow
      // 3b: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 3e: ifnull 56
      // 41: goto 45
      // 44: athrow
      // 45: aload 0
      // 46: aload 3
      // 47: invokevirtual x/oc08bf1f1a9e.ʮ (Lnet/minecraft/entity/player/EntityPlayer;)V
      // 4a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 4d: goto 51
      // 50: athrow
      // 51: aload 1
      // 52: aload 3
      // 53: invokestatic de/florianmichael/viamcp/fixes/AttackOrder.sendFixedAttack (Lnet/minecraft/client/Minecraft;Lnet/minecraft/entity/player/EntityPlayer;Lnet/minecraft/entity/Entity;)V
      // 56: aload 0
      // 57: bipush 0
      // 58: putfield x/oc08bf1f1a9e.Ū Z
      // 5b: goto 68
      // 5e: astore 4
      // 60: aload 0
      // 61: bipush 0
      // 62: putfield x/oc08bf1f1a9e.Ū Z
      // 65: aload 4
      // 67: athrow
      // 68: return
   }

   private void և() {
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
      // 05: getfield x/oc08bf1f1a9e.Ń I
      // 08: iload 1
      // 09: ifne 24
      // 0c: bipush -1
      // 0d: if_icmpeq 27
      // 10: goto 14
      // 13: athrow
      // 14: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 17: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 1a: getfield net/minecraft/client/settings/GameSettings.keyBindUseItem Lnet/minecraft/client/settings/KeyBinding;
      // 1d: invokestatic x/oc7ab2161b9f.ն (Lnet/minecraft/client/settings/KeyBinding;)Z
      // 20: goto 24
      // 23: athrow
      // 24: ifeq 28
      // 27: return
      // 28: aload 0
      // 29: invokevirtual x/oc08bf1f1a9e.ɉ ()V
      // 2c: return
   }

   private void ɉ() {
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
      // 06: ifne 2e
      // 09: getfield x/oc08bf1f1a9e.Ń I
      // 0c: bipush -1
      // 0d: if_icmpeq 29
      // 10: goto 14
      // 13: athrow
      // 14: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 17: iload 1
      // 18: ifne 36
      // 1b: goto 1f
      // 1e: athrow
      // 1f: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 22: ifnonnull 33
      // 25: goto 29
      // 28: athrow
      // 29: aload 0
      // 2a: goto 2e
      // 2d: athrow
      // 2e: bipush -1
      // 2f: putfield x/oc08bf1f1a9e.Ń I
      // 32: return
      // 33: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 36: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 39: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 3c: aload 0
      // 3d: getfield x/oc08bf1f1a9e.Ń I
      // 40: putfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 43: aload 0
      // 44: invokevirtual x/oc08bf1f1a9e.ѓ ()V
      // 47: aload 0
      // 48: bipush -1
      // 49: putfield x/oc08bf1f1a9e.Ń I
      // 4c: return
   }

   private void ѓ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 1
      // 04: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 07: iload 1
      // 08: ifne 1f
      // 0b: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 0e: instanceof x/oc51cbcffcfe
      // 11: ifeq 27
      // 14: goto 18
      // 17: athrow
      // 18: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1b: goto 1f
      // 1e: athrow
      // 1f: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 22: invokeinterface x/oc51cbcffcfe.callSyncCurrentPlayItem ()V 1
      // 27: return
   }

   private void Ī() {
      this.ҩ = false;
      this.ƃ = false;
      this.Ū = false;
      this.θ = false;
      this.Ƞ = false;
      this.Þ = 0.0F;
      this.ğ = 0.0F;
      this.ǿ = null;
      this.Ń = -1;
      this.Ԉ = -1;
      this.ȉ = 0.0F;
      this.ֆ = 0L;
      this.ҹ();
   }

   private boolean Ι() {
      int var1 = oc5e549848f3.İ;
      int var2 = -1461994794 ^ 750664877;

      while (true) {
         switch (var2) {
            case -2073721221:
               int var10000;
               label28: {
                  label27: {
                     try {
                        var10000 = (int)this.Β.Ӂ();
                        if (var1 != 0) {
                           break label28;
                        }

                        if (var10000 != 1) {
                           break label27;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = -289669862 ^ 750664877;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = 398644297 ^ 750664877;
               }

               var2 = var10000;
               if (var1 == 0) {
                  break;
               }
            case 998041828:
               return false;
            case -1039810121:
               return true;
            default:
               throw null;
         }
      }
   }

   private void Բ(EntityPlayer param1, float param2) {
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
      // 09: getfield x/oc08bf1f1a9e.ѐ Lx/occ2f8dff8d8;
      // 0c: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0f: ifne 1f
      // 12: goto 16
      // 15: athrow
      // 16: aload 0
      // 17: goto 1b
      // 1a: athrow
      // 1b: invokevirtual x/oc08bf1f1a9e.ҹ ()V
      // 1e: return
      // 1f: invokestatic java/lang/System.currentTimeMillis ()J
      // 22: lstore 4
      // 24: aload 0
      // 25: getfield x/oc08bf1f1a9e.Ƽ Lnet/minecraft/entity/player/EntityPlayer;
      // 28: aload 1
      // 29: if_acmpeq 31
      // 2c: bipush 1
      // 2d: goto 32
      // 30: athrow
      // 31: bipush 0
      // 32: istore 6
      // 34: iload 3
      // 35: ifne 73
      // 38: iload 6
      // 3a: ifeq 49
      // 3d: goto 41
      // 40: athrow
      // 41: aload 0
      // 42: invokevirtual x/oc08bf1f1a9e.Ȃ ()V
      // 45: goto 49
      // 48: athrow
      // 49: aload 0
      // 4a: aload 1
      // 4b: putfield x/oc08bf1f1a9e.Ƽ Lnet/minecraft/entity/player/EntityPlayer;
      // 4e: aload 0
      // 4f: fload 2
      // 50: putfield x/oc08bf1f1a9e.ş F
      // 53: aload 0
      // 54: fconst_1
      // 55: putfield x/oc08bf1f1a9e.Ӎ F
      // 58: aload 0
      // 59: fconst_1
      // 5a: putfield x/oc08bf1f1a9e.Ǖ F
      // 5d: aload 0
      // 5e: lload 4
      // 60: putfield x/oc08bf1f1a9e.ƒ J
      // 63: aload 0
      // 64: bipush 1
      // 65: putfield x/oc08bf1f1a9e.ӧ Z
      // 68: aload 0
      // 69: lload 4
      // 6b: putfield x/oc08bf1f1a9e.ϵ J
      // 6e: aload 0
      // 6f: aload 1
      // 70: invokevirtual x/oc08bf1f1a9e.ʮ (Lnet/minecraft/entity/player/EntityPlayer;)V
      // 73: return
   }

   private void Ò() {
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
      // 06: ifne 18
      // 09: getfield x/oc08bf1f1a9e.Ƽ Lnet/minecraft/entity/player/EntityPlayer;
      // 0c: ifnull 3a
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: getfield x/oc08bf1f1a9e.ӧ Z
      // 1b: ifeq 3a
      // 1e: invokestatic java/lang/System.currentTimeMillis ()J
      // 21: lstore 2
      // 22: aload 0
      // 23: aload 0
      // 24: lload 2
      // 25: invokevirtual x/oc08bf1f1a9e.Ө (J)F
      // 28: putfield x/oc08bf1f1a9e.Ӎ F
      // 2b: aload 0
      // 2c: fconst_0
      // 2d: putfield x/oc08bf1f1a9e.Ǖ F
      // 30: aload 0
      // 31: lload 2
      // 32: putfield x/oc08bf1f1a9e.ƒ J
      // 35: aload 0
      // 36: bipush 0
      // 37: putfield x/oc08bf1f1a9e.ӧ Z
      // 3a: return
   }

   private float Ө(long var1) {
      try {
         if (this.ƒ <= 0L) {
            return 1.0F;
         }
      } catch (ocbde1165e4e var4) {
         throw var4;
      }

      float var3 = Math.min(1.0F, Math.max(0.0F, (float)(var1 - this.ƒ) / 100.0F));
      return this.Ӎ + (this.Ǖ - this.Ӎ) * var3;
   }

   private void ʮ(EntityPlayer param1) {
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
      // 05: ifnull 45
      // 08: invokestatic java/lang/System.currentTimeMillis ()J
      // 0b: lstore 3
      // 0c: iload 2
      // 0d: ifne 40
      // 10: aload 0
      // 11: getfield x/oc08bf1f1a9e.þ I
      // 14: aload 1
      // 15: invokevirtual net/minecraft/entity/player/EntityPlayer.getEntityId ()I
      // 18: if_icmpne 34
      // 1b: goto 1f
      // 1e: athrow
      // 1f: lload 3
      // 20: aload 0
      // 21: getfield x/oc08bf1f1a9e.Ȓ J
      // 24: lsub
      // 25: ldc2_w 871956962050060487
      // 28: ldc2_w 871956962050060479
      // 2b: lxor
      // 2c: lcmp
      // 2d: iflt 45
      // 30: goto 34
      // 33: athrow
      // 34: aload 0
      // 35: aload 1
      // 36: invokevirtual net/minecraft/entity/player/EntityPlayer.getEntityId ()I
      // 39: putfield x/oc08bf1f1a9e.þ I
      // 3c: goto 40
      // 3f: athrow
      // 40: aload 0
      // 41: lload 3
      // 42: putfield x/oc08bf1f1a9e.Ȓ J
      // 45: return
   }

   private double Ң(EntityPlayer param1, long param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 4
      // 05: aload 1
      // 06: ifnull 53
      // 09: aload 0
      // 0a: iload 4
      // 0c: ifne 26
      // 0f: goto 13
      // 12: athrow
      // 13: getfield x/oc08bf1f1a9e.þ I
      // 16: aload 1
      // 17: invokevirtual net/minecraft/entity/player/EntityPlayer.getEntityId ()I
      // 1a: if_icmpne 53
      // 1d: goto 21
      // 20: athrow
      // 21: aload 0
      // 22: goto 26
      // 25: athrow
      // 26: getfield x/oc08bf1f1a9e.Ȓ J
      // 29: iload 4
      // 2b: ifne 41
      // 2e: lconst_0
      // 2f: lcmp
      // 30: iflt 53
      // 33: goto 37
      // 36: athrow
      // 37: lload 2
      // 38: aload 0
      // 39: getfield x/oc08bf1f1a9e.Ȓ J
      // 3c: lsub
      // 3d: goto 41
      // 40: athrow
      // 41: l2d
      // 42: ldc2_w 420.0
      // 45: ddiv
      // 46: dstore 5
      // 48: dconst_1
      // 49: dconst_0
      // 4a: dload 5
      // 4c: invokestatic java/lang/Math.max (DD)D
      // 4f: invokestatic java/lang/Math.min (DD)D
      // 52: dreturn
      // 53: ldc2_w -1.0
      // 56: dreturn
   }

   private double Ö(double param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 3
      // 04: dload 1
      // 05: iload 3
      // 06: ifne 29
      // 09: dconst_0
      // 0a: dcmpg
      // 0b: iflt 24
      // 0e: goto 12
      // 11: athrow
      // 12: dload 1
      // 13: iload 3
      // 14: ifne 44
      // 17: goto 1b
      // 1a: athrow
      // 1b: dconst_1
      // 1c: dcmpl
      // 1d: iflt 2a
      // 20: goto 24
      // 23: athrow
      // 24: dconst_0
      // 25: goto 29
      // 28: athrow
      // 29: dreturn
      // 2a: dload 1
      // 2b: ldc2_w 3.141592653589793
      // 2e: dmul
      // 2f: ldc2_w 2.5
      // 32: dmul
      // 33: invokestatic java/lang/Math.sin (D)D
      // 36: dload 1
      // 37: dneg
      // 38: ldc2_w 3.0
      // 3b: dmul
      // 3c: invokestatic java/lang/Math.exp (D)D
      // 3f: dmul
      // 40: dconst_1
      // 41: dload 1
      // 42: dsub
      // 43: dmul
      // 44: dstore 4
      // 46: dload 4
      // 48: ldc2_w 1.45
      // 4b: dmul
      // 4c: dreturn
   }

   private float խ(double param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 3
      // 04: dload 1
      // 05: dconst_0
      // 06: iload 3
      // 07: ifne 22
      // 0a: dcmpg
      // 0b: iflt 26
      // 0e: goto 12
      // 11: athrow
      // 12: dload 1
      // 13: iload 3
      // 14: ifne 32
      // 17: goto 1b
      // 1a: athrow
      // 1b: ldc2_w 0.45
      // 1e: goto 22
      // 21: athrow
      // 22: dcmpg
      // 23: ifgt 29
      // 26: fconst_1
      // 27: freturn
      // 28: athrow
      // 29: dload 1
      // 2a: ldc2_w 0.45
      // 2d: dsub
      // 2e: ldc2_w 0.55
      // 31: ddiv
      // 32: dstore 4
      // 34: dload 4
      // 36: dload 4
      // 38: dmul
      // 39: ldc2_w 3.0
      // 3c: ldc2_w 2.0
      // 3f: dload 4
      // 41: dmul
      // 42: dsub
      // 43: dmul
      // 44: dstore 6
      // 46: dconst_0
      // 47: dconst_1
      // 48: dconst_1
      // 49: dload 6
      // 4b: dsub
      // 4c: invokestatic java/lang/Math.min (DD)D
      // 4f: invokestatic java/lang/Math.max (DD)D
      // 52: d2f
      // 53: freturn
   }

   private void Ȃ() {
      this.Ȓ = -4969214572328776332L ^ 4969214572328776331L;
      this.þ = -1;
   }

   private void ҹ() {
      this.Ƽ = null;
      this.Ӎ = 0.0F;
      this.Ǖ = 0.0F;
      this.ƒ = 0L;
      this.ӧ = false;
      this.ϵ = 5684220388313404984L ^ -5684220388313404985L;
      this.Ȃ();
   }

   private void հ(EntityPlayer var1, float var2, float var3, float var4, double var5) {
      long var7 = System.currentTimeMillis();
      double var9 = Math.sin(var7 % (-7263791282953705176L ^ -7263791282953707448L) / 2400.0 * Math.PI * 2.0) * 0.03;
      double var11 = var1.lastTickPosX + (var1.posX - var1.lastTickPosX) * var3;
      double var13 = var1.lastTickPosY + (var1.posY - var1.lastTickPosY) * var3 + var1.height * 0.52 + var9;
      double var15 = var1.lastTickPosZ + (var1.posZ - var1.lastTickPosZ) * var3;
      double var17 = Math.toRadians(var2);
      double var19 = -Math.sin(var17);
      double var21 = Math.cos(var17);
      double var23 = -var21;
      double var27 = var1.width * 0.5 + 0.22 + var5;
      double var29 = 0.3;
      double var31 = 0.045;
      double var33 = 0.24;
      double var35 = 0.17;
      double var37 = 0.02;
      double var39 = var11 + var19 * var27;
      double var41 = var15 + var21 * var27;
      double var43 = var39 + var19 * var29;
      double var45 = var41 + var21 * var29;
      double var47 = var43 + var19 * var33;
      double var49 = var45 + var21 * var33;
      double var51 = var39 - var23 * var31;
      double var53 = var41 - var19 * var31;
      double var55 = var39 + var23 * var31;
      double var57 = var41 + var19 * var31;
      double var59 = var43 - var23 * var31;
      double var61 = var45 - var19 * var31;
      double var63 = var43 + var23 * var31;
      double var65 = var45 + var19 * var31;
      double var67 = var43 - var23 * var35;
      double var69 = var45 - var19 * var35;
      double var71 = var43 + var23 * var35;
      double var73 = var45 + var19 * var35;
      RenderManager var75 = oc69da1aa7f5.ő.getRenderManager();
      double var76 = var75.viewerPosX;
      double var78 = var75.viewerPosY;
      double var80 = var75.viewerPosZ;
      GL11.glPushMatrix();
      GL11.glTranslated(var11 - var76, var13 - var78, var15 - var80);
      GL11.glRotated(90.0, var19, 0.0, var21);
      GL11.glTranslated(var76 - var11, var78 - var13, var80 - var15);
      GL11.glPushAttrib(-211074700 ^ -211501429);
      GL11.glEnable(-211503767 ^ -211501429);
      GL11.glBlendFunc(-211501687 ^ -211501429, -211501688 ^ -211501429);
      GL11.glDisable(-211504278 ^ -211501429);
      GL11.glDisable(-211503653 ^ -211501429);
      GL11.glDisable(-211503622 ^ -211501429);
      GL11.glDisable(-211503665 ^ -211501429);
      GL11.glDepthMask(false);
      GL11.glEnable(-211503701 ^ -211501429);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.88F * var4);
      GL11.glBegin(-211501425 ^ -211501429);
      this.Ŋ(var51, var13 + var37, var53, var76, var78, var80);
      this.Ŋ(var59, var13 + var37, var61, var76, var78, var80);
      this.Ŋ(var63, var13 + var37, var65, var76, var78, var80);
      this.Ŋ(var51, var13 + var37, var53, var76, var78, var80);
      this.Ŋ(var63, var13 + var37, var65, var76, var78, var80);
      this.Ŋ(var55, var13 + var37, var57, var76, var78, var80);
      this.Ŋ(var67, var13 + var37, var69, var76, var78, var80);
      this.Ŋ(var47, var13 + var37, var49, var76, var78, var80);
      this.Ŋ(var71, var13 + var37, var73, var76, var78, var80);
      GL11.glColor4f(0.85F, 0.88F, 0.92F, 0.85F * var4);
      this.Ŋ(var51, var13 - var37, var53, var76, var78, var80);
      this.Ŋ(var63, var13 - var37, var65, var76, var78, var80);
      this.Ŋ(var59, var13 - var37, var61, var76, var78, var80);
      this.Ŋ(var51, var13 - var37, var53, var76, var78, var80);
      this.Ŋ(var55, var13 - var37, var57, var76, var78, var80);
      this.Ŋ(var63, var13 - var37, var65, var76, var78, var80);
      this.Ŋ(var67, var13 - var37, var69, var76, var78, var80);
      this.Ŋ(var71, var13 - var37, var73, var76, var78, var80);
      this.Ŋ(var47, var13 - var37, var49, var76, var78, var80);
      GL11.glColor4f(0.72F, 0.76F, 0.82F, 0.8F * var4);
      this.s(var51, var53, var59, var61, var13 + var37, var13 - var37, var76, var78, var80);
      this.s(var63, var65, var55, var57, var13 + var37, var13 - var37, var76, var78, var80);
      this.s(var55, var57, var51, var53, var13 + var37, var13 - var37, var76, var78, var80);
      this.s(var59, var61, var67, var69, var13 + var37, var13 - var37, var76, var78, var80);
      this.s(var71, var73, var63, var65, var13 + var37, var13 - var37, var76, var78, var80);
      this.s(var67, var69, var47, var49, var13 + var37, var13 - var37, var76, var78, var80);
      this.s(var47, var49, var71, var73, var13 + var37, var13 - var37, var76, var78, var80);
      oc170ea29aae.ŷ();
      GL11.glLineWidth(1.6F);
      GL11.glColor4f(0.08F, 0.08F, 0.12F, 0.8F * var4);
      GL11.glBegin(-211501431 ^ -211501429);
      this.Ŋ(var51, var13 + var37, var53, var76, var78, var80);
      this.Ŋ(var59, var13 + var37, var61, var76, var78, var80);
      this.Ŋ(var67, var13 + var37, var69, var76, var78, var80);
      this.Ŋ(var47, var13 + var37, var49, var76, var78, var80);
      this.Ŋ(var71, var13 + var37, var73, var76, var78, var80);
      this.Ŋ(var63, var13 + var37, var65, var76, var78, var80);
      this.Ŋ(var55, var13 + var37, var57, var76, var78, var80);
      oc170ea29aae.ŷ();
      GL11.glPopAttrib();
      GL11.glPopMatrix();
   }

   private void s(double var1, double var3, double var5, double var7, double var9, double var11, double var13, double var15, double var17) {
      this.Ŋ(var1, var9, var3, var13, var15, var17);
      this.Ŋ(var5, var9, var7, var13, var15, var17);
      this.Ŋ(var5, var11, var7, var13, var15, var17);
      this.Ŋ(var1, var9, var3, var13, var15, var17);
      this.Ŋ(var5, var11, var7, var13, var15, var17);
      this.Ŋ(var1, var11, var3, var13, var15, var17);
   }

   private void Ŋ(double var1, double var3, double var5, double var7, double var9, double var11) {
      GL11.glVertex3d(var1 - var7, var3 - var9, var5 - var11);
   }

   static {
      String[] var10000 = new String[-1561936624 ^ -1561936622];
      var10000[0] = "Static";
      var10000[1] = "Void";
      ұ = var10000;
      var10000 = new String[-1561936623 ^ -1561936622];
      var10000[0] = "Left";
      var10000[1] = "Right";
      var10000[-1561936624 ^ -1561936622] = "Random";
      Ĕ = var10000;
   }
}

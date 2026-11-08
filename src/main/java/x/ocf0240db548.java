package x;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ocf0240db548 extends oc69da1aa7f5 {
   private static final long դ = 1000L;
   private static final long Ȧ = 5000L;
   private final oca9cc61aada Č;
   private final occc831eff22 Һ;
   private final occ2f8dff8d8 Î;
   private final occ2f8dff8d8 ʘ;
   private final occ2f8dff8d8 Ѥ;
   private final occ2f8dff8d8 Ã;
   private final occ2f8dff8d8 Ĕ;
   private final occ2f8dff8d8 Ǻ;
   private final occ2f8dff8d8 Ӝ;
   private final occ2f8dff8d8 ϸ;
   private final occ2f8dff8d8[] ɭ;
   private final occ2f8dff8d8 Н;
   private EntityPlayer ӛ;
   private long ʪ;
   private int ӕ = -1;
   private boolean Ԕ;
   private EntityPlayer Ų;
   private int ʯ;
   private long é = 4758321570883630651L ^ -4758321570883630652L;
   private boolean Ư;
   public static boolean ř;

   public ocf0240db548() {
      super("Auto Weapon", oce4cea752dd.ȁ);
      this.ą("Selects a priority weapon when attacking.");
      this.ʌ(this.Č = new oca9cc61aada("Activation time", "ms", 0.0, 0.0, 1000.0, 25.0));
      this.ʌ(new oc4d46a99983("Weapon priority"));
      this.ʌ(this.Һ = new occc831eff22("Attribute Swap"));
      this.ʌ(this.Î = new occ2f8dff8d8(this.Һ, "Stick", false, new String[]{"Attribute Swap"}));
      this.ʌ(this.ʘ = new occ2f8dff8d8(this.Һ, "Sword", false));
      this.ʌ(this.Ѥ = new occ2f8dff8d8(this.Һ, "Axe", false));
      this.ʌ(this.Ã = new occ2f8dff8d8(this.Һ, "Pickaxe", false));
      this.ʌ(this.Ĕ = new occ2f8dff8d8(this.Һ, "Shovel", false));
      this.ʌ(this.Ǻ = new occ2f8dff8d8(this.Һ, "Hoe", false));
      this.ʌ(this.Ӝ = new occ2f8dff8d8(this.Һ, "Fishing Rod", false, new String[]{"Rod"}));
      this.ʌ(this.ϸ = new occ2f8dff8d8(this.Һ, "Bow", false));
      occ2f8dff8d8[] var10001 = new occ2f8dff8d8[-1560007619 ^ -1560007627];
      var10001[0] = this.Î;
      var10001[1] = this.ʘ;
      var10001[-1560007625 ^ -1560007627] = this.Ѥ;
      var10001[-1560007626 ^ -1560007627] = this.Ã;
      var10001[-1560007631 ^ -1560007627] = this.Ĕ;
      var10001[-1560007632 ^ -1560007627] = this.Ǻ;
      var10001[-1560007629 ^ -1560007627] = this.Ӝ;
      var10001[-1560007630 ^ -1560007627] = this.ϸ;
      this.ɭ = var10001;
      this.ʌ(new oc4d46a99983("Conditions"));
      this.ʌ(this.Н = new occ2f8dff8d8("Require Left mouse", true, new String[]{"Require mouse down"}));
      this.ɮ = true;
   }

   @Override
   public void onEnable() {
      this.ț();
      this.փ();
   }

   @Override
   public void onDisable() {
      this.ț();
      this.փ();
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
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: aload 0
      // 05: aload 1
      // 06: invokevirtual x/ocf0240db548.Ұ (Lx/occ2f8dff8d8;)Z
      // 09: iload 2
      // 0a: ifne 19
      // 0d: ifne 15
      // 10: goto 14
      // 13: athrow
      // 14: return
      // 15: aload 1
      // 16: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 19: ifeq 5b
      // 1c: aload 0
      // 1d: getfield x/ocf0240db548.ɭ [Lx/occ2f8dff8d8;
      // 20: astore 3
      // 21: aload 3
      // 22: arraylength
      // 23: istore 4
      // 25: bipush 0
      // 26: istore 5
      // 28: iload 5
      // 2a: iload 4
      // 2c: if_icmpge 5b
      // 2f: aload 3
      // 30: iload 5
      // 32: aaload
      // 33: astore 6
      // 35: iload 2
      // 36: ifne 5f
      // 39: iload 2
      // 3a: ifne 57
      // 3d: goto 41
      // 40: athrow
      // 41: aload 6
      // 43: aload 1
      // 44: if_acmpeq 54
      // 47: goto 4b
      // 4a: athrow
      // 4b: aload 6
      // 4d: invokevirtual x/occ2f8dff8d8.Տ ()V
      // 50: goto 54
      // 53: athrow
      // 54: iinc 5 1
      // 57: iload 2
      // 58: ifeq 28
      // 5b: aload 0
      // 5c: invokevirtual x/ocf0240db548.փ ()V
      // 5f: return
   }

   @oc66fa4f2195
   public void ř(oca27090789a param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: getstatic x/oc5e549848f3.İ I
      // 003: istore 2
      // 004: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 007: iload 2
      // 008: ifne 067
      // 00b: ifeq 054
      // 00e: goto 012
      // 011: athrow
      // 012: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 015: iload 2
      // 016: ifne 02e
      // 019: goto 01d
      // 01c: athrow
      // 01d: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 020: ifnonnull 054
      // 023: goto 027
      // 026: athrow
      // 027: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 02a: goto 02e
      // 02d: athrow
      // 02e: getfield net/minecraft/client/Minecraft.inGameHasFocus Z
      // 031: iload 2
      // 032: ifne 067
      // 035: ifeq 054
      // 038: goto 03c
      // 03b: athrow
      // 03c: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 03f: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 042: iload 2
      // 043: ifne 073
      // 046: goto 04a
      // 049: athrow
      // 04a: getfield net/minecraft/client/entity/EntityPlayerSP.isDead Z
      // 04d: ifeq 06f
      // 050: goto 054
      // 053: athrow
      // 054: aload 0
      // 055: iload 2
      // 056: ifne 06b
      // 059: goto 05d
      // 05c: athrow
      // 05d: invokevirtual x/ocf0240db548.ț ()V
      // 060: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 063: goto 067
      // 066: athrow
      // 067: ifne 06e
      // 06a: aload 0
      // 06b: invokevirtual x/ocf0240db548.փ ()V
      // 06e: return
      // 06f: aload 0
      // 070: invokevirtual x/ocf0240db548.æ ()Lnet/minecraft/entity/player/EntityPlayer;
      // 073: astore 3
      // 074: aload 3
      // 075: iload 2
      // 076: ifne 0ac
      // 079: aload 0
      // 07a: getfield x/ocf0240db548.ӛ Lnet/minecraft/entity/player/EntityPlayer;
      // 07d: if_acmpeq 0a0
      // 080: goto 084
      // 083: athrow
      // 084: aload 0
      // 085: aload 3
      // 086: putfield x/ocf0240db548.ӛ Lnet/minecraft/entity/player/EntityPlayer;
      // 089: aload 0
      // 08a: aload 0
      // 08b: getfield x/ocf0240db548.ӛ Lnet/minecraft/entity/player/EntityPlayer;
      // 08e: ifnonnull 09a
      // 091: goto 095
      // 094: athrow
      // 095: lconst_0
      // 096: goto 09d
      // 099: athrow
      // 09a: invokestatic java/lang/System.currentTimeMillis ()J
      // 09d: putfield x/ocf0240db548.ʪ J
      // 0a0: aload 0
      // 0a1: iload 2
      // 0a2: ifne 0df
      // 0a5: getfield x/ocf0240db548.ӛ Lnet/minecraft/entity/player/EntityPlayer;
      // 0a8: goto 0ac
      // 0ab: athrow
      // 0ac: ifnonnull 0de
      // 0af: aload 0
      // 0b0: iload 2
      // 0b1: ifne 0c7
      // 0b4: goto 0b8
      // 0b7: athrow
      // 0b8: getfield x/ocf0240db548.Ư Z
      // 0bb: ifeq 0dd
      // 0be: goto 0c2
      // 0c1: athrow
      // 0c2: aload 0
      // 0c3: goto 0c7
      // 0c6: athrow
      // 0c7: iload 2
      // 0c8: ifne 0da
      // 0cb: invokevirtual x/ocf0240db548.Њ ()Lnet/minecraft/entity/player/EntityPlayer;
      // 0ce: ifnonnull 0dd
      // 0d1: goto 0d5
      // 0d4: athrow
      // 0d5: aload 0
      // 0d6: goto 0da
      // 0d9: athrow
      // 0da: invokevirtual x/ocf0240db548.փ ()V
      // 0dd: return
      // 0de: aload 0
      // 0df: iload 2
      // 0e0: ifne 105
      // 0e3: getfield x/ocf0240db548.ӛ Lnet/minecraft/entity/player/EntityPlayer;
      // 0e6: invokevirtual net/minecraft/entity/player/EntityPlayer.getEntityId ()I
      // 0e9: aload 0
      // 0ea: getfield x/ocf0240db548.ӕ I
      // 0ed: if_icmpeq 100
      // 0f0: goto 0f4
      // 0f3: athrow
      // 0f4: aload 0
      // 0f5: aload 0
      // 0f6: getfield x/ocf0240db548.ӛ Lnet/minecraft/entity/player/EntityPlayer;
      // 0f9: invokevirtual x/ocf0240db548.h (Lnet/minecraft/entity/player/EntityPlayer;)V
      // 0fc: goto 100
      // 0ff: athrow
      // 100: aload 0
      // 101: invokevirtual x/ocf0240db548.φ ()V
      // 104: aload 0
      // 105: getfield x/ocf0240db548.Н Lx/occ2f8dff8d8;
      // 108: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 10b: iload 2
      // 10c: ifne 13c
      // 10f: ifeq 12b
      // 112: goto 116
      // 115: athrow
      // 116: bipush 0
      // 117: iload 2
      // 118: ifne 13c
      // 11b: goto 11f
      // 11e: athrow
      // 11f: invokestatic org/lwjgl/input/Mouse.isButtonDown (I)Z
      // 122: ifne 12b
      // 125: goto 129
      // 128: athrow
      // 129: return
      // 12a: athrow
      // 12b: invokestatic java/lang/System.currentTimeMillis ()J
      // 12e: aload 0
      // 12f: getfield x/ocf0240db548.ʪ J
      // 132: lsub
      // 133: l2d
      // 134: aload 0
      // 135: getfield x/ocf0240db548.Č Lx/oca9cc61aada;
      // 138: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 13b: dcmpg
      // 13c: iload 2
      // 13d: ifne 154
      // 140: ifge 148
      // 143: goto 147
      // 146: athrow
      // 147: return
      // 148: aload 0
      // 149: iload 2
      // 14a: ifne 173
      // 14d: getfield x/ocf0240db548.Ԕ Z
      // 150: goto 154
      // 153: athrow
      // 154: ifne 172
      // 157: aload 0
      // 158: iload 2
      // 159: ifne 173
      // 15c: goto 160
      // 15f: athrow
      // 160: invokevirtual x/ocf0240db548.œ ()Z
      // 163: ifeq 172
      // 166: goto 16a
      // 169: athrow
      // 16a: aload 0
      // 16b: invokevirtual x/ocf0240db548.Û ()I
      // 16e: goto 176
      // 171: athrow
      // 172: aload 0
      // 173: invokevirtual x/ocf0240db548.ό ()I
      // 176: istore 4
      // 178: iload 4
      // 17a: iload 2
      // 17b: ifne 18e
      // 17e: bipush -1
      // 17f: if_icmpne 18c
      // 182: goto 186
      // 185: athrow
      // 186: aload 0
      // 187: invokevirtual x/ocf0240db548.ό ()I
      // 18a: istore 4
      // 18c: iload 4
      // 18e: bipush -1
      // 18f: if_icmpeq 19c
      // 192: aload 0
      // 193: iload 4
      // 195: invokevirtual x/ocf0240db548.Ѳ (I)V
      // 198: goto 19c
      // 19b: athrow
      // 19c: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.LOWEST,
      receiveCanceled = true
   )
   public void ȡ(occ48acb5d22 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc5e549848f3.İ I
      // 003: istore 2
      // 004: aload 1
      // 005: invokevirtual x/oc68d6b191af.isCanceled ()Z
      // 008: iload 2
      // 009: ifne 01b
      // 00c: ifne 0b6
      // 00f: goto 013
      // 012: athrow
      // 013: aload 0
      // 014: invokevirtual x/ocf0240db548.œ ()Z
      // 017: goto 01b
      // 01a: athrow
      // 01b: iload 2
      // 01c: ifne 029
      // 01f: ifeq 0b6
      // 022: goto 026
      // 025: athrow
      // 026: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 029: ifeq 0b6
      // 02c: aload 1
      // 02d: iload 2
      // 02e: ifne 04a
      // 031: goto 035
      // 034: athrow
      // 035: getfield x/occ48acb5d22.Ǖ Lnet/minecraft/entity/player/EntityPlayer;
      // 038: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 03b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 03e: if_acmpne 0b6
      // 041: goto 045
      // 044: athrow
      // 045: aload 1
      // 046: goto 04a
      // 049: athrow
      // 04a: getfield x/occ48acb5d22.Ǻ Lnet/minecraft/entity/Entity;
      // 04d: instanceof net/minecraft/entity/player/EntityPlayer
      // 050: ifeq 0b6
      // 053: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 056: iload 2
      // 057: ifne 06f
      // 05a: goto 05e
      // 05d: athrow
      // 05e: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 061: ifnonnull 0b6
      // 064: goto 068
      // 067: athrow
      // 068: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 06b: goto 06f
      // 06e: athrow
      // 06f: iload 2
      // 070: ifne 084
      // 073: getfield net/minecraft/client/Minecraft.inGameHasFocus Z
      // 076: ifeq 0b6
      // 079: goto 07d
      // 07c: athrow
      // 07d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 080: goto 084
      // 083: athrow
      // 084: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 087: getfield net/minecraft/client/entity/EntityPlayerSP.isDead Z
      // 08a: iload 2
      // 08b: ifne 0a0
      // 08e: ifne 0b6
      // 091: goto 095
      // 094: athrow
      // 095: aload 0
      // 096: getfield x/ocf0240db548.Н Lx/occ2f8dff8d8;
      // 099: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 09c: goto 0a0
      // 09f: athrow
      // 0a0: iload 2
      // 0a1: ifne 0b3
      // 0a4: ifeq 0b7
      // 0a7: goto 0ab
      // 0aa: athrow
      // 0ab: bipush 0
      // 0ac: invokestatic org/lwjgl/input/Mouse.isButtonDown (I)Z
      // 0af: goto 0b3
      // 0b2: athrow
      // 0b3: ifne 0b7
      // 0b6: return
      // 0b7: aload 1
      // 0b8: getfield x/occ48acb5d22.Ǻ Lnet/minecraft/entity/Entity;
      // 0bb: ldc2_w 1.7976931348623157E308
      // 0be: invokestatic x/oc5e08d6b90f.ϰ (Lnet/minecraft/entity/Entity;D)Lnet/minecraft/entity/player/EntityPlayer;
      // 0c1: astore 3
      // 0c2: aload 3
      // 0c3: iload 2
      // 0c4: ifne 0d0
      // 0c7: ifnonnull 0cf
      // 0ca: goto 0ce
      // 0cd: athrow
      // 0ce: return
      // 0cf: aload 3
      // 0d0: aload 0
      // 0d1: getfield x/ocf0240db548.ӛ Lnet/minecraft/entity/player/EntityPlayer;
      // 0d4: if_acmpeq 0e7
      // 0d7: aload 0
      // 0d8: aload 3
      // 0d9: putfield x/ocf0240db548.ӛ Lnet/minecraft/entity/player/EntityPlayer;
      // 0dc: aload 0
      // 0dd: invokestatic java/lang/System.currentTimeMillis ()J
      // 0e0: putfield x/ocf0240db548.ʪ J
      // 0e3: goto 0e7
      // 0e6: athrow
      // 0e7: invokestatic java/lang/System.currentTimeMillis ()J
      // 0ea: aload 0
      // 0eb: getfield x/ocf0240db548.ʪ J
      // 0ee: lsub
      // 0ef: l2d
      // 0f0: aload 0
      // 0f1: getfield x/ocf0240db548.Č Lx/oca9cc61aada;
      // 0f4: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0f7: dcmpg
      // 0f8: iload 2
      // 0f9: ifne 108
      // 0fc: ifge 104
      // 0ff: goto 103
      // 102: athrow
      // 103: return
      // 104: aload 3
      // 105: invokevirtual net/minecraft/entity/player/EntityPlayer.getEntityId ()I
      // 108: iload 2
      // 109: ifne 124
      // 10c: aload 0
      // 10d: getfield x/ocf0240db548.ӕ I
      // 110: if_icmpeq 120
      // 113: goto 117
      // 116: athrow
      // 117: aload 0
      // 118: aload 3
      // 119: invokevirtual x/ocf0240db548.h (Lnet/minecraft/entity/player/EntityPlayer;)V
      // 11c: goto 120
      // 11f: athrow
      // 120: aload 0
      // 121: getfield x/ocf0240db548.Ԕ Z
      // 124: ifeq 128
      // 127: return
      // 128: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 12b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 12e: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 131: astore 4
      // 133: iload 2
      // 134: ifne 16c
      // 137: aload 0
      // 138: aload 4
      // 13a: invokevirtual x/ocf0240db548.Շ (Lnet/minecraft/item/ItemStack;)Z
      // 13d: ifne 158
      // 140: goto 144
      // 143: athrow
      // 144: aload 0
      // 145: invokevirtual x/ocf0240db548.Û ()I
      // 148: istore 5
      // 14a: iload 5
      // 14c: bipush -1
      // 14d: if_icmpne 152
      // 150: return
      // 151: athrow
      // 152: aload 0
      // 153: iload 5
      // 155: invokevirtual x/ocf0240db548.Ѳ (I)V
      // 158: aload 0
      // 159: aload 3
      // 15a: putfield x/ocf0240db548.Ų Lnet/minecraft/entity/player/EntityPlayer;
      // 15d: aload 0
      // 15e: aload 3
      // 15f: getfield net/minecraft/entity/player/EntityPlayer.hurtTime I
      // 162: putfield x/ocf0240db548.ʯ I
      // 165: aload 0
      // 166: invokestatic java/lang/System.currentTimeMillis ()J
      // 169: putfield x/ocf0240db548.é J
      // 16c: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.LOWEST
   )
   public void ҋ(oc2f61de30bc param1) {
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
      // 06: ifne 16
      // 09: getfield x/ocf0240db548.Ư Z
      // 0c: ifne 15
      // 0f: goto 13
      // 12: athrow
      // 13: return
      // 14: athrow
      // 15: aload 0
      // 16: invokevirtual x/ocf0240db548.Њ ()Lnet/minecraft/entity/player/EntityPlayer;
      // 19: astore 3
      // 1a: iload 2
      // 1b: ifne 3d
      // 1e: aload 3
      // 1f: ifnull 35
      // 22: goto 26
      // 25: athrow
      // 26: aload 3
      // 27: invokevirtual net/minecraft/entity/player/EntityPlayer.getEntityId ()I
      // 2a: aload 0
      // 2b: getfield x/ocf0240db548.ӕ I
      // 2e: if_icmpeq 41
      // 31: goto 35
      // 34: athrow
      // 35: aload 0
      // 36: invokevirtual x/ocf0240db548.ț ()V
      // 39: goto 3d
      // 3c: athrow
      // 3d: aload 0
      // 3e: invokevirtual x/ocf0240db548.փ ()V
      // 41: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.LOWEST,
      receiveCanceled = true
   )
   public void Ђ(oce79181588d param1) {
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
      // 09: getfield x/ocf0240db548.Ԕ Z
      // 0c: ifne 46
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: getfield x/ocf0240db548.Ų Lnet/minecraft/entity/player/EntityPlayer;
      // 1b: ifnull 46
      // 1e: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 21: iload 2
      // 22: ifne 3b
      // 25: goto 29
      // 28: athrow
      // 29: ifeq 46
      // 2c: goto 30
      // 2f: athrow
      // 30: aload 1
      // 31: invokevirtual x/oce79181588d.Ҡ ()Lnet/minecraft/network/Packet;
      // 34: instanceof net/minecraft/network/play/server/S19PacketEntityStatus
      // 37: goto 3b
      // 3a: athrow
      // 3b: iload 2
      // 3c: ifne 54
      // 3f: ifne 47
      // 42: goto 46
      // 45: athrow
      // 46: return
      // 47: invokestatic java/lang/System.currentTimeMillis ()J
      // 4a: aload 0
      // 4b: getfield x/ocf0240db548.é J
      // 4e: lsub
      // 4f: aload 0
      // 50: invokevirtual x/ocf0240db548.Ӂ ()J
      // 53: lcmp
      // 54: ifle 5d
      // 57: aload 0
      // 58: invokevirtual x/ocf0240db548.в ()V
      // 5b: return
      // 5c: athrow
      // 5d: aload 1
      // 5e: invokevirtual x/oce79181588d.Ҡ ()Lnet/minecraft/network/Packet;
      // 61: checkcast net/minecraft/network/play/server/S19PacketEntityStatus
      // 64: astore 3
      // 65: aload 3
      // 66: iload 2
      // 67: ifne 7e
      // 6a: invokevirtual net/minecraft/network/play/server/S19PacketEntityStatus.getOpCode ()B
      // 6d: ldc_w 449766877
      // 70: ldc_w 449766879
      // 73: ixor
      // 74: if_icmpeq 7d
      // 77: goto 7b
      // 7a: athrow
      // 7b: return
      // 7c: athrow
      // 7d: aload 3
      // 7e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 81: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 84: invokevirtual net/minecraft/network/play/server/S19PacketEntityStatus.getEntity (Lnet/minecraft/world/World;)Lnet/minecraft/entity/Entity;
      // 87: astore 4
      // 89: aload 4
      // 8b: aload 0
      // 8c: getfield x/ocf0240db548.Ų Lnet/minecraft/entity/player/EntityPlayer;
      // 8f: if_acmpne 9a
      // 92: aload 0
      // 93: invokevirtual x/ocf0240db548.ʣ ()V
      // 96: goto 9a
      // 99: athrow
      // 9a: return
   }

   private void φ() {
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
      // 09: getfield x/ocf0240db548.Ԕ Z
      // 0c: ifne 1e
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: getfield x/ocf0240db548.Ų Lnet/minecraft/entity/player/EntityPlayer;
      // 1b: ifnonnull 20
      // 1e: return
      // 1f: athrow
      // 20: invokestatic java/lang/System.currentTimeMillis ()J
      // 23: aload 0
      // 24: getfield x/ocf0240db548.é J
      // 27: lsub
      // 28: aload 0
      // 29: invokevirtual x/ocf0240db548.Ӂ ()J
      // 2c: lcmp
      // 2d: iload 1
      // 2e: ifne 4d
      // 31: ifle 3e
      // 34: goto 38
      // 37: athrow
      // 38: aload 0
      // 39: invokevirtual x/ocf0240db548.в ()V
      // 3c: return
      // 3d: athrow
      // 3e: aload 0
      // 3f: iload 1
      // 40: ifne 59
      // 43: getfield x/ocf0240db548.Ų Lnet/minecraft/entity/player/EntityPlayer;
      // 46: getfield net/minecraft/entity/player/EntityPlayer.hurtTime I
      // 49: goto 4d
      // 4c: athrow
      // 4d: aload 0
      // 4e: getfield x/ocf0240db548.ʯ I
      // 51: if_icmple 5c
      // 54: aload 0
      // 55: goto 59
      // 58: athrow
      // 59: invokevirtual x/ocf0240db548.ʣ ()V
      // 5c: return
   }

   private void ʣ() {
      this.Ԕ = true;
      this.в();
      int var1 = this.ό();

      try {
         if (var1 != -1) {
            oc69da1aa7f5.ő.thePlayer.inventory.currentItem = var1;
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }
   }

   private EntityPlayer æ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 1
      // 04: getstatic x/oc9755810e45.ÿ Lx/ocdd342096f8;
      // 07: iload 1
      // 08: ifne 15
      // 0b: ifnull 21
      // 0e: goto 12
      // 11: athrow
      // 12: getstatic x/oc9755810e45.ÿ Lx/ocdd342096f8;
      // 15: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 18: ifeq 21
      // 1b: aload 0
      // 1c: invokevirtual x/ocf0240db548.Њ ()Lnet/minecraft/entity/player/EntityPlayer;
      // 1f: areturn
      // 20: athrow
      // 21: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 24: iload 1
      // 25: ifne 39
      // 28: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 2b: ifnull 65
      // 2e: goto 32
      // 31: athrow
      // 32: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 35: goto 39
      // 38: athrow
      // 39: iload 1
      // 3a: ifne 54
      // 3d: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 40: getfield net/minecraft/util/MovingObjectPosition.typeOfHit Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 43: getstatic net/minecraft/util/MovingObjectPosition$MovingObjectType.ENTITY Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 46: if_acmpne 65
      // 49: goto 4d
      // 4c: athrow
      // 4d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 50: goto 54
      // 53: athrow
      // 54: iload 1
      // 55: ifne 6b
      // 58: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 5b: getfield net/minecraft/util/MovingObjectPosition.entityHit Lnet/minecraft/entity/Entity;
      // 5e: ifnonnull 68
      // 61: goto 65
      // 64: athrow
      // 65: aconst_null
      // 66: areturn
      // 67: athrow
      // 68: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 6b: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 6e: getfield net/minecraft/util/MovingObjectPosition.entityHit Lnet/minecraft/entity/Entity;
      // 71: ldc2_w 1.7976931348623157E308
      // 74: invokestatic x/oc5e08d6b90f.ϰ (Lnet/minecraft/entity/Entity;D)Lnet/minecraft/entity/player/EntityPlayer;
      // 77: areturn
   }

   private EntityPlayer Њ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 1
      // 04: getstatic x/oc9755810e45.ÿ Lx/ocdd342096f8;
      // 07: iload 1
      // 08: ifne 15
      // 0b: ifnull 38
      // 0e: goto 12
      // 11: athrow
      // 12: getstatic x/oc9755810e45.ÿ Lx/ocdd342096f8;
      // 15: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 18: iload 1
      // 19: ifne 35
      // 1c: ifeq 38
      // 1f: goto 23
      // 22: athrow
      // 23: getstatic x/ocdd342096f8.f Lnet/minecraft/entity/EntityLivingBase;
      // 26: iload 1
      // 27: ifne 3e
      // 2a: goto 2e
      // 2d: athrow
      // 2e: instanceof net/minecraft/entity/player/EntityPlayer
      // 31: goto 35
      // 34: athrow
      // 35: ifne 3b
      // 38: aconst_null
      // 39: areturn
      // 3a: athrow
      // 3b: getstatic x/ocdd342096f8.f Lnet/minecraft/entity/EntityLivingBase;
      // 3e: ldc2_w 1.7976931348623157E308
      // 41: invokestatic x/oc5e08d6b90f.ϰ (Lnet/minecraft/entity/Entity;D)Lnet/minecraft/entity/player/EntityPlayer;
      // 44: areturn
   }

   private long Ӂ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: bipush 0
      // 04: istore 2
      // 05: istore 1
      // 06: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 09: iload 1
      // 0a: ifne 1e
      // 0d: invokevirtual net/minecraft/client/Minecraft.getNetHandler ()Lnet/minecraft/client/network/NetHandlerPlayClient;
      // 10: ifnull 50
      // 13: goto 17
      // 16: athrow
      // 17: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1a: goto 1e
      // 1d: athrow
      // 1e: iload 1
      // 1f: ifne 33
      // 22: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 25: ifnull 50
      // 28: goto 2c
      // 2b: athrow
      // 2c: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 2f: goto 33
      // 32: athrow
      // 33: invokevirtual net/minecraft/client/Minecraft.getNetHandler ()Lnet/minecraft/client/network/NetHandlerPlayClient;
      // 36: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 39: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 3c: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getUniqueID ()Ljava/util/UUID;
      // 3f: invokevirtual net/minecraft/client/network/NetHandlerPlayClient.getPlayerInfo (Ljava/util/UUID;)Lnet/minecraft/client/network/NetworkPlayerInfo;
      // 42: astore 3
      // 43: aload 3
      // 44: ifnull 50
      // 47: bipush 0
      // 48: aload 3
      // 49: invokevirtual net/minecraft/client/network/NetworkPlayerInfo.getResponseTime ()I
      // 4c: invokestatic java/lang/Math.max (II)I
      // 4f: istore 2
      // 50: iload 2
      // 51: i2l
      // 52: ldc2_w -8240426485702775389
      // 55: ldc2_w -8240426485702775391
      // 58: lxor
      // 59: lmul
      // 5a: ldc2_w -8240426485702775461
      // 5d: ldc2_w -8240426485702775391
      // 60: lxor
      // 61: ladd
      // 62: lstore 3
      // 63: ldc2_w -8240426485702775223
      // 66: ldc2_w -8240426485702775391
      // 69: lxor
      // 6a: ldc2_w -8240426485702771159
      // 6d: ldc2_w -8240426485702775391
      // 70: lxor
      // 71: lload 3
      // 72: invokestatic java/lang/Math.min (JJ)J
      // 75: invokestatic java/lang/Math.max (JJ)J
      // 78: lreturn
   }

   private int Û() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush -1
      // 01: istore 2
      // 02: getstatic x/oc5e549848f3.İ I
      // 05: ldc2_w -Infinity
      // 08: dstore 3
      // 09: istore 1
      // 0a: bipush 0
      // 0b: istore 5
      // 0d: iload 5
      // 0f: ldc_w -24369597
      // 12: ldc_w -24369590
      // 15: ixor
      // 16: if_icmpge 83
      // 19: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1f: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 22: iload 5
      // 24: invokevirtual net/minecraft/entity/player/InventoryPlayer.getStackInSlot (I)Lnet/minecraft/item/ItemStack;
      // 27: astore 6
      // 29: aload 0
      // 2a: iload 1
      // 2b: ifne 4f
      // 2e: aload 6
      // 30: invokevirtual x/ocf0240db548.Շ (Lnet/minecraft/item/ItemStack;)Z
      // 33: iload 1
      // 34: ifne 84
      // 37: goto 3b
      // 3a: athrow
      // 3b: ifne 4a
      // 3e: goto 42
      // 41: athrow
      // 42: iload 1
      // 43: ifeq 7c
      // 46: goto 4a
      // 49: athrow
      // 4a: aload 0
      // 4b: goto 4f
      // 4e: athrow
      // 4f: aload 6
      // 51: invokevirtual x/ocf0240db548.Ɨ (Lnet/minecraft/item/ItemStack;)D
      // 54: dstore 7
      // 56: iload 1
      // 57: ifne 79
      // 5a: iload 2
      // 5b: bipush -1
      // 5c: if_icmpeq 76
      // 5f: goto 63
      // 62: athrow
      // 63: dload 7
      // 65: iload 1
      // 66: ifne 7b
      // 69: goto 6d
      // 6c: athrow
      // 6d: dload 3
      // 6e: dcmpl
      // 6f: ifle 7c
      // 72: goto 76
      // 75: athrow
      // 76: iload 5
      // 78: istore 2
      // 79: dload 7
      // 7b: dstore 3
      // 7c: iinc 5 1
      // 7f: iload 1
      // 80: ifeq 0d
      // 83: iload 2
      // 84: ireturn
   }

   private double Ɨ(ItemStack param1) {
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
      // 06: ifne 2d
      // 09: ifnull 2c
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 1
      // 11: iload 2
      // 12: ifne 2d
      // 15: goto 19
      // 18: athrow
      // 19: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 1c: instanceof net/minecraft/item/ItemBow
      // 1f: ifeq 2c
      // 22: goto 26
      // 25: athrow
      // 26: aload 1
      // 27: invokestatic x/oc561cb941fa.ĸ (Lnet/minecraft/item/ItemStack;)D
      // 2a: dreturn
      // 2b: athrow
      // 2c: aload 1
      // 2d: invokestatic x/oc561cb941fa.ҿ (Lnet/minecraft/item/ItemStack;)D
      // 30: dreturn
   }

   private boolean Շ(ItemStack param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc5e549848f3.İ I
      // 003: istore 2
      // 004: aload 1
      // 005: iload 2
      // 006: ifne 011
      // 009: ifnull 032
      // 00c: goto 010
      // 00f: athrow
      // 010: aload 1
      // 011: getfield net/minecraft/item/ItemStack.stackSize I
      // 014: iload 2
      // 015: ifne 037
      // 018: ifle 032
      // 01b: goto 01f
      // 01e: athrow
      // 01f: aload 1
      // 020: iload 2
      // 021: ifne 039
      // 024: goto 028
      // 027: athrow
      // 028: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 02b: ifnonnull 038
      // 02e: goto 032
      // 031: athrow
      // 032: bipush 0
      // 033: goto 037
      // 036: athrow
      // 037: ireturn
      // 038: aload 1
      // 039: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 03c: astore 3
      // 03d: aload 0
      // 03e: iload 2
      // 03f: ifne 062
      // 042: getfield x/ocf0240db548.Î Lx/occ2f8dff8d8;
      // 045: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 048: ifeq 061
      // 04b: goto 04f
      // 04e: athrow
      // 04f: aload 3
      // 050: getstatic net/minecraft/init/Items.stick Lnet/minecraft/item/Item;
      // 053: if_acmpne 05f
      // 056: goto 05a
      // 059: athrow
      // 05a: bipush 1
      // 05b: goto 060
      // 05e: athrow
      // 05f: bipush 0
      // 060: ireturn
      // 061: aload 0
      // 062: getfield x/ocf0240db548.ʘ Lx/occ2f8dff8d8;
      // 065: iload 2
      // 066: ifne 07d
      // 069: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 06c: ifeq 079
      // 06f: goto 073
      // 072: athrow
      // 073: aload 3
      // 074: instanceof net/minecraft/item/ItemSword
      // 077: ireturn
      // 078: athrow
      // 079: aload 0
      // 07a: getfield x/ocf0240db548.Ѥ Lx/occ2f8dff8d8;
      // 07d: iload 2
      // 07e: ifne 095
      // 081: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 084: ifeq 091
      // 087: goto 08b
      // 08a: athrow
      // 08b: aload 3
      // 08c: instanceof net/minecraft/item/ItemAxe
      // 08f: ireturn
      // 090: athrow
      // 091: aload 0
      // 092: getfield x/ocf0240db548.Ã Lx/occ2f8dff8d8;
      // 095: iload 2
      // 096: ifne 0ad
      // 099: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 09c: ifeq 0a9
      // 09f: goto 0a3
      // 0a2: athrow
      // 0a3: aload 3
      // 0a4: instanceof net/minecraft/item/ItemPickaxe
      // 0a7: ireturn
      // 0a8: athrow
      // 0a9: aload 0
      // 0aa: getfield x/ocf0240db548.Ĕ Lx/occ2f8dff8d8;
      // 0ad: iload 2
      // 0ae: ifne 0c5
      // 0b1: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0b4: ifeq 0c1
      // 0b7: goto 0bb
      // 0ba: athrow
      // 0bb: aload 3
      // 0bc: instanceof net/minecraft/item/ItemSpade
      // 0bf: ireturn
      // 0c0: athrow
      // 0c1: aload 0
      // 0c2: getfield x/ocf0240db548.Ǻ Lx/occ2f8dff8d8;
      // 0c5: iload 2
      // 0c6: ifne 0dd
      // 0c9: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0cc: ifeq 0d9
      // 0cf: goto 0d3
      // 0d2: athrow
      // 0d3: aload 3
      // 0d4: instanceof net/minecraft/item/ItemHoe
      // 0d7: ireturn
      // 0d8: athrow
      // 0d9: aload 0
      // 0da: getfield x/ocf0240db548.Ӝ Lx/occ2f8dff8d8;
      // 0dd: iload 2
      // 0de: ifne 0f5
      // 0e1: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0e4: ifeq 0f1
      // 0e7: goto 0eb
      // 0ea: athrow
      // 0eb: aload 3
      // 0ec: instanceof net/minecraft/item/ItemFishingRod
      // 0ef: ireturn
      // 0f0: athrow
      // 0f1: aload 0
      // 0f2: getfield x/ocf0240db548.ϸ Lx/occ2f8dff8d8;
      // 0f5: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0f8: iload 2
      // 0f9: ifne 10b
      // 0fc: ifeq 11a
      // 0ff: goto 103
      // 102: athrow
      // 103: aload 3
      // 104: instanceof net/minecraft/item/ItemBow
      // 107: goto 10b
      // 10a: athrow
      // 10b: iload 2
      // 10c: ifne 117
      // 10f: ifeq 11a
      // 112: goto 116
      // 115: athrow
      // 116: bipush 1
      // 117: goto 11b
      // 11a: bipush 0
      // 11b: ireturn
   }

   private boolean œ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: aload 0
      // 04: getfield x/ocf0240db548.ɭ [Lx/occ2f8dff8d8;
      // 07: astore 2
      // 08: aload 2
      // 09: arraylength
      // 0a: istore 3
      // 0b: bipush 0
      // 0c: istore 4
      // 0e: istore 1
      // 0f: iload 4
      // 11: iload 3
      // 12: if_icmpge 3d
      // 15: aload 2
      // 16: iload 4
      // 18: aaload
      // 19: astore 5
      // 1b: iload 1
      // 1c: ifne 39
      // 1f: aload 5
      // 21: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 24: iload 1
      // 25: ifne 3e
      // 28: goto 2c
      // 2b: athrow
      // 2c: ifeq 36
      // 2f: goto 33
      // 32: athrow
      // 33: bipush 1
      // 34: ireturn
      // 35: athrow
      // 36: iinc 4 1
      // 39: iload 1
      // 3a: ifeq 0f
      // 3d: bipush 0
      // 3e: ireturn
   }

   private boolean Ұ(occ2f8dff8d8 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield x/ocf0240db548.ɭ [Lx/occ2f8dff8d8;
      // 04: astore 3
      // 05: getstatic x/oc5e549848f3.İ I
      // 08: aload 3
      // 09: arraylength
      // 0a: istore 4
      // 0c: istore 2
      // 0d: bipush 0
      // 0e: istore 5
      // 10: iload 5
      // 12: iload 4
      // 14: if_icmpge 35
      // 17: aload 3
      // 18: iload 5
      // 1a: aaload
      // 1b: astore 6
      // 1d: iload 2
      // 1e: ifne 31
      // 21: aload 6
      // 23: aload 1
      // 24: if_acmpne 2e
      // 27: goto 2b
      // 2a: athrow
      // 2b: bipush 1
      // 2c: ireturn
      // 2d: athrow
      // 2e: iinc 5 1
      // 31: iload 2
      // 32: ifeq 10
      // 35: bipush 0
      // 36: ireturn
   }

   private int ό() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 06: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 09: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 0c: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 0f: istore 2
      // 10: istore 1
      // 11: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 14: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 17: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 1a: iload 2
      // 1b: invokevirtual net/minecraft/entity/player/InventoryPlayer.getStackInSlot (I)Lnet/minecraft/item/ItemStack;
      // 1e: astore 3
      // 1f: aload 0
      // 20: aload 3
      // 21: invokevirtual x/ocf0240db548.Ϛ (Lnet/minecraft/item/ItemStack;)Z
      // 24: iload 1
      // 25: ifne 30
      // 28: ifeq 33
      // 2b: goto 2f
      // 2e: athrow
      // 2f: iload 2
      // 30: goto 34
      // 33: bipush -1
      // 34: istore 4
      // 36: iload 4
      // 38: bipush -1
      // 39: if_icmpne 43
      // 3c: ldc2_w -Infinity
      // 3f: goto 47
      // 42: athrow
      // 43: aload 3
      // 44: invokestatic x/oc561cb941fa.ҿ (Lnet/minecraft/item/ItemStack;)D
      // 47: dstore 5
      // 49: bipush 0
      // 4a: istore 7
      // 4c: iload 7
      // 4e: ldc_w 1292027098
      // 51: ldc_w 1292027091
      // 54: ixor
      // 55: if_icmpge c7
      // 58: iload 7
      // 5a: iload 1
      // 5b: ifne c9
      // 5e: iload 2
      // 5f: if_icmpne 6e
      // 62: goto 66
      // 65: athrow
      // 66: iload 1
      // 67: ifeq c0
      // 6a: goto 6e
      // 6d: athrow
      // 6e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 71: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 74: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 77: iload 7
      // 79: invokevirtual net/minecraft/entity/player/InventoryPlayer.getStackInSlot (I)Lnet/minecraft/item/ItemStack;
      // 7c: astore 8
      // 7e: aload 0
      // 7f: aload 8
      // 81: invokevirtual x/ocf0240db548.Ϛ (Lnet/minecraft/item/ItemStack;)Z
      // 84: ifne 8f
      // 87: iload 1
      // 88: ifeq c0
      // 8b: goto 8f
      // 8e: athrow
      // 8f: aload 8
      // 91: invokestatic x/oc561cb941fa.ҿ (Lnet/minecraft/item/ItemStack;)D
      // 94: dstore 9
      // 96: iload 1
      // 97: ifne bc
      // 9a: iload 4
      // 9c: bipush -1
      // 9d: if_icmpeq b8
      // a0: goto a4
      // a3: athrow
      // a4: dload 9
      // a6: iload 1
      // a7: ifne be
      // aa: goto ae
      // ad: athrow
      // ae: dload 5
      // b0: dcmpl
      // b1: ifle c0
      // b4: goto b8
      // b7: athrow
      // b8: iload 7
      // ba: istore 4
      // bc: dload 9
      // be: dstore 5
      // c0: iinc 7 1
      // c3: iload 1
      // c4: ifeq 4c
      // c7: iload 4
      // c9: ireturn
   }

   private boolean Ϛ(ItemStack var1) {
      Item var3 = null;
      int var4 = -1184226583 ^ -1350265177;
      int var2 = oc5e549848f3.İ;

      while (true) {
         switch (var4) {
            case -1492628831:
               return true;
            case -692777812:
               return false;
            case -100698260:
               var3 = var1.getItem();

               label98: {
                  label97: {
                     try {
                        if (var2 != 0) {
                           break label98;
                        }

                        if (var3 != Items.stick) {
                           break label97;
                        }
                     } catch (ocbde1165e4e var7) {
                        throw var7;
                     }

                     var4 = -1902338239 ^ -1350265177;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var4 = -861223175 ^ -1350265177;
               }

               if (var2 == 0) {
                  break;
               }
            case 1220443217:
               int var10;
               label75: {
                  label74: {
                     try {
                        var10 = var3 instanceof ItemAxe;
                        if (var2 != 0) {
                           break label75;
                        }

                        if (var10 == 0) {
                           break label74;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var4 = 143449094 ^ -1350265177;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var10 = 2033293835 ^ -1350265177;
               }

               var4 = var10;
               if (var2 == 0) {
                  break;
               }

               return false;
            case 384742478:
               if (var1 != null) {
                  var4 = 1023107002 ^ -1350265177;
                  if (var2 == 0) {
                     break;
                  }
               }

               var4 = -1944251524 ^ -1350265177;
               if (var2 == 0) {
                  break;
               }
            case -1820341987:
               int var9;
               label108: {
                  label107: {
                     try {
                        var9 = var1.stackSize;
                        if (var2 != 0) {
                           break label108;
                        }

                        if (var1.stackSize <= 0) {
                           break label107;
                        }
                     } catch (ocbde1165e4e var8) {
                        throw var8;
                     }

                     var4 = -159303878 ^ -1350265177;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var9 = -1944251524 ^ -1350265177;
               }

               var4 = var9;
               if (var2 == 0) {
                  break;
               }
            case 1493541277:
               if (var1.getItem() == null) {
                  var4 = -1944251524 ^ -1350265177;
                  if (var2 == 0) {
                     break;
                  }
               }

               var4 = 1450959307 ^ -1350265177;
               if (var2 == 0) {
                  break;
               }

               return true;
            case 555223526:
               return false;
            case 597263835:
               return false;
            case 1663979614:
               int var10000;
               label84: {
                  label83: {
                     try {
                        var10000 = var3 instanceof ItemSword;
                        if (var2 != 0) {
                           break label84;
                        }

                        if (var10000 != 0) {
                           break label83;
                        }
                     } catch (ocbde1165e4e var6) {
                        throw var6;
                     }

                     var4 = -415569162 ^ -1350265177;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var10000 = 143449094 ^ -1350265177;
               }

               var4 = var10000;
               if (var2 == 0) {
                  break;
               }

               return false;
            default:
               throw null;
         }
      }
   }

   private void Ѳ(int param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: iload 1
      // 05: iload 2
      // 06: ifne 3c
      // 09: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0f: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 12: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 15: if_icmpne 1e
      // 18: goto 1c
      // 1b: athrow
      // 1c: return
      // 1d: athrow
      // 1e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 21: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 24: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 27: iload 1
      // 28: putfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 2b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 2e: iload 2
      // 2f: ifne 42
      // 32: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 35: instanceof x/oc51cbcffcfe
      // 38: goto 3c
      // 3b: athrow
      // 3c: ifeq 4a
      // 3f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 42: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 45: invokeinterface x/oc51cbcffcfe.callSyncCurrentPlayItem ()V 1
      // 4a: return
   }

   private void h(EntityPlayer param1) {
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
      // 05: aload 1
      // 06: invokevirtual net/minecraft/entity/player/EntityPlayer.getEntityId ()I
      // 09: iload 2
      // 0a: ifne 2a
      // 0d: putfield x/ocf0240db548.ӕ I
      // 10: aload 0
      // 11: bipush 0
      // 12: putfield x/ocf0240db548.Ԕ Z
      // 15: aload 0
      // 16: getstatic x/oc9755810e45.ÿ Lx/ocdd342096f8;
      // 19: ifnull 3d
      // 1c: goto 20
      // 1f: athrow
      // 20: getstatic x/oc9755810e45.ÿ Lx/ocdd342096f8;
      // 23: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 26: goto 2a
      // 29: athrow
      // 2a: ifeq 3d
      // 2d: getstatic x/ocdd342096f8.f Lnet/minecraft/entity/EntityLivingBase;
      // 30: aload 1
      // 31: if_acmpne 3d
      // 34: goto 38
      // 37: athrow
      // 38: bipush 1
      // 39: goto 3e
      // 3c: athrow
      // 3d: bipush 0
      // 3e: putfield x/ocf0240db548.Ư Z
      // 41: aload 0
      // 42: invokevirtual x/ocf0240db548.в ()V
      // 45: return
   }

   private void в() {
      this.Ų = null;
      this.ʯ = 0;
      this.é = -4717574105743168105L ^ 4717574105743168104L;
   }

   private void փ() {
      this.ӕ = -1;
      this.Ԕ = false;
      this.Ư = false;
      this.в();
   }

   private void ț() {
      this.ӛ = null;
      this.ʪ = 0L;
   }
}

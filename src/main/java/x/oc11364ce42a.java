package x;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockTrapDoor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;

public class oc11364ce42a {
   private static final EnumFacing[] Զ;
   private static final float ԓ = 100.0F;
   private final oc668fce0dbf ϭ;
   private final Minecraft ĸ = Minecraft.getMinecraft();
   private final Map<BlockPos, Long> ǘ = new HashMap<>();
   private final oc5105eb10d3 ˁ = new oc5105eb10d3(this);
   private boolean ʫ;
   private boolean ß;
   private boolean Ԋ;
   private boolean b;
   private boolean ћ;
   private boolean ϳ;
   private boolean Ŗ;
   private boolean ҷ;
   private boolean Љ;
   private int Ȩ = -1;
   private int Ϟ;
   private int Ά;
   private int Ը;
   private int ī;
   private int µ;
   private int к;
   private int Џ;
   private int Ԗ;
   private int ΐ;
   private int p;
   private int Ѐ;
   private int Ɯ;
   private int ǭ = -1;
   private long ơ;
   private long Ϯ;
   private long ɐ;
   private float ʆ;
   private float ϵ = 100.0F;
   private float ɓ;
   private float Ņ;
   private float Ѫ;
   private float ƴ;
   private BlockPos ŭ;
   private String ҥ;

   oc11364ce42a(oc668fce0dbf var1) {
      this.ϭ = var1;
   }

   void Ѥ() {
      ocea775c9d5c.ų.unregister(this);
      ocea775c9d5c.ų.unregister(this.ˁ);
      this.ʫ = false;
      this.ß = false;
      this.Ԋ = false;
      this.b = false;
      this.ћ = false;
      this.ϳ = false;
      this.Ŗ = false;
      this.ҷ = false;
      this.Љ = false;
      this.Ȩ = -1;
      this.Ϟ = 0;
      this.Ά = 0;
      this.Ը = 0;
      this.ī = 0;
      this.µ = 0;
      this.к = 0;
      this.Џ = 0;
      this.Ԗ = 0;
      this.ΐ = 0;
      this.p = 0;
      this.Ѐ = 0;
      this.Ɯ = 0;
      this.ǭ = -1;
      this.ơ = 0L;
      this.Ϯ = 0L;
      this.ɐ = 0L;
      this.ʆ = 0.0F;
      this.ϵ = 100.0F;
      this.Ѫ = 0.0F;
      this.ƴ = 0.0F;
      this.ŭ = null;
      this.ҥ = null;
      this.ǘ.clear();
   }

   void Ȓ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocea775c9d5c.ų Lx/oc04596227b7;
      // 03: aload 0
      // 04: invokevirtual x/oc04596227b7.unregister (Ljava/lang/Object;)V
      // 07: getstatic x/oc84f20a0bc5.ė I
      // 0a: getstatic x/ocea775c9d5c.ų Lx/oc04596227b7;
      // 0d: aload 0
      // 0e: getfield x/oc11364ce42a.ˁ Lx/oc5105eb10d3;
      // 11: invokevirtual x/oc04596227b7.register (Ljava/lang/Object;)V
      // 14: istore 1
      // 15: aload 0
      // 16: ldc 84.5
      // 18: ldc 87.5
      // 1a: invokestatic x/oc11364ce42a.П (FF)F
      // 1d: putfield x/oc11364ce42a.ɓ F
      // 20: iload 1
      // 21: ifne 49
      // 24: aload 0
      // 25: invokestatic x/oc11364ce42a.Ν ()F
      // 28: putfield x/oc11364ce42a.Ņ F
      // 2b: aload 0
      // 2c: invokevirtual x/oc11364ce42a.Ϭ ()Z
      // 2f: ifne 38
      // 32: goto 36
      // 35: athrow
      // 36: return
      // 37: athrow
      // 38: aload 0
      // 39: aload 0
      // 3a: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 3d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 40: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 43: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 46: putfield x/oc11364ce42a.ǭ I
      // 49: aload 0
      // 4a: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 4d: iload 1
      // 4e: ifne 7f
      // 51: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 54: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 57: ifne 6f
      // 5a: goto 5e
      // 5d: athrow
      // 5e: aload 0
      // 5f: ldc 1492217429
      // 61: ldc 1492217430
      // 63: ixor
      // 64: putfield x/oc11364ce42a.Џ I
      // 67: iload 1
      // 68: ifeq fe
      // 6b: goto 6f
      // 6e: athrow
      // 6f: aload 0
      // 70: iload 1
      // 71: ifne b4
      // 74: goto 78
      // 77: athrow
      // 78: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 7b: goto 7f
      // 7e: athrow
      // 7f: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 82: getstatic net/minecraft/potion/Potion.jump Lnet/minecraft/potion/Potion;
      // 85: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isPotionActive (Lnet/minecraft/potion/Potion;)Z
      // 88: ifeq af
      // 8b: aload 0
      // 8c: iload 1
      // 8d: ifne b4
      // 90: goto 94
      // 93: athrow
      // 94: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 97: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 9a: getstatic net/minecraft/potion/Potion.jump Lnet/minecraft/potion/Potion;
      // 9d: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getActivePotionEffect (Lnet/minecraft/potion/Potion;)Lnet/minecraft/potion/PotionEffect;
      // a0: invokevirtual net/minecraft/potion/PotionEffect.getAmplifier ()I
      // a3: ldc 1492217429
      // a5: ldc 1492217430
      // a7: ixor
      // a8: if_icmpge fe
      // ab: goto af
      // ae: athrow
      // af: aload 0
      // b0: goto b4
      // b3: athrow
      // b4: iload 1
      // b5: ifne ca
      // b8: ldc2_w 0.2
      // bb: invokevirtual x/oc11364ce42a.Ѧ (D)Z
      // be: ifeq fe
      // c1: goto c5
      // c4: athrow
      // c5: aload 0
      // c6: goto ca
      // c9: athrow
      // ca: iload 1
      // cb: ifne f5
      // ce: invokevirtual x/oc11364ce42a.Υ ()I
      // d1: ifle fe
      // d4: goto d8
      // d7: athrow
      // d8: aload 0
      // d9: ldc_w 1492217428
      // dc: ldc 1492217430
      // de: ixor
      // df: putfield x/oc11364ce42a.Ԗ I
      // e2: aload 0
      // e3: aload 0
      // e4: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // e7: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // ea: getfield net/minecraft/client/entity/EntityPlayerSP.ticksExisted I
      // ed: putfield x/oc11364ce42a.ΐ I
      // f0: aload 0
      // f1: goto f5
      // f4: athrow
      // f5: ldc_w 1492217426
      // f8: ldc 1492217430
      // fa: ixor
      // fb: putfield x/oc11364ce42a.Џ I
      // fe: return
   }

   void Լ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: aload 0
      // 04: invokevirtual x/oc11364ce42a.Α ()V
      // 07: istore 1
      // 08: aload 0
      // 09: bipush 0
      // 0a: putfield x/oc11364ce42a.к I
      // 0d: aload 0
      // 0e: bipush 0
      // 0f: putfield x/oc11364ce42a.Џ I
      // 12: aload 0
      // 13: bipush 0
      // 14: putfield x/oc11364ce42a.Ѐ I
      // 17: aload 0
      // 18: iload 1
      // 19: ifne 35
      // 1c: bipush 0
      // 1d: putfield x/oc11364ce42a.Ɯ I
      // 20: aload 0
      // 21: lconst_0
      // 22: putfield x/oc11364ce42a.ơ J
      // 25: aload 0
      // 26: invokevirtual x/oc11364ce42a.Ϭ ()Z
      // 29: ifeq 5e
      // 2c: goto 30
      // 2f: athrow
      // 30: aload 0
      // 31: goto 35
      // 34: athrow
      // 35: iload 1
      // 36: ifne 48
      // 39: getfield x/oc11364ce42a.Ԗ I
      // 3c: ifne 53
      // 3f: goto 43
      // 42: athrow
      // 43: aload 0
      // 44: goto 48
      // 47: athrow
      // 48: getfield x/oc11364ce42a.ǘ Ljava/util/Map;
      // 4b: invokeinterface java/util/Map.isEmpty ()Z 1
      // 50: ifne 5e
      // 53: getstatic x/ocea775c9d5c.ų Lx/oc04596227b7;
      // 56: aload 0
      // 57: invokevirtual x/oc04596227b7.register (Ljava/lang/Object;)V
      // 5a: goto 5e
      // 5d: athrow
      // 5e: return
   }

   boolean ġ() {
      return this.ʫ;
   }

   void Š(oc86de9e2892 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: aload 0
      // 04: invokevirtual x/oc11364ce42a.ӟ ()V
      // 07: istore 2
      // 08: aload 0
      // 09: getfield x/oc11364ce42a.ʫ Z
      // 0c: iload 2
      // 0d: ifne 2a
      // 10: ifeq 2d
      // 13: goto 17
      // 16: athrow
      // 17: aload 1
      // 18: aload 0
      // 19: getfield x/oc11364ce42a.ϭ Lx/oc668fce0dbf;
      // 1c: ldc_w -928630930
      // 1f: ldc_w -928631142
      // 22: ixor
      // 23: invokevirtual x/oc86de9e2892.ǰ (Ljava/lang/Object;I)Z
      // 26: goto 2a
      // 29: athrow
      // 2a: ifne 2e
      // 2d: return
      // 2e: aload 0
      // 2f: getstatic x/oc75d51ec7eb.d [F
      // 32: bipush 0
      // 33: faload
      // 34: getstatic x/oc75d51ec7eb.d [F
      // 37: bipush 1
      // 38: faload
      // 39: invokevirtual x/oc11364ce42a.Щ (FF)[F
      // 3c: astore 3
      // 3d: iload 2
      // 3e: ifne 6d
      // 41: aload 1
      // 42: aload 0
      // 43: getfield x/oc11364ce42a.ϭ Lx/oc668fce0dbf;
      // 46: ldc_w -928630930
      // 49: ldc_w -928631142
      // 4c: ixor
      // 4d: aload 3
      // 4e: bipush 0
      // 4f: faload
      // 50: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 53: aload 3
      // 54: bipush 1
      // 55: faload
      // 56: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 59: bipush 1
      // 5a: invokevirtual x/oc86de9e2892.Ǎ (Ljava/lang/Object;ILjava/lang/Float;Ljava/lang/Float;Z)Z
      // 5d: ifeq 72
      // 60: goto 64
      // 63: athrow
      // 64: aload 1
      // 65: bipush 1
      // 66: invokevirtual x/oc86de9e2892.ʐ (Z)V
      // 69: goto 6d
      // 6c: athrow
      // 6d: aload 1
      // 6e: bipush 1
      // 6f: invokevirtual x/oc86de9e2892.Ȥ (Z)V
      // 72: return
   }

   private void ӟ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 1
      // 004: aload 0
      // 005: iload 1
      // 006: ifne 026
      // 009: invokevirtual x/oc11364ce42a.Ϭ ()Z
      // 00c: ifne 019
      // 00f: goto 013
      // 012: athrow
      // 013: aload 0
      // 014: invokevirtual x/oc11364ce42a.Α ()V
      // 017: return
      // 018: athrow
      // 019: aload 0
      // 01a: iload 1
      // 01b: ifne 04d
      // 01e: invokevirtual x/oc11364ce42a.Ĩ ()V
      // 021: aload 0
      // 022: goto 026
      // 025: athrow
      // 026: getfield x/oc11364ce42a.Ɯ I
      // 029: ifle 04c
      // 02c: aload 0
      // 02d: iload 1
      // 02e: ifne 04d
      // 031: goto 035
      // 034: athrow
      // 035: dup
      // 036: getfield x/oc11364ce42a.Ɯ I
      // 039: bipush 1
      // 03a: isub
      // 03b: dup_x1
      // 03c: putfield x/oc11364ce42a.Ɯ I
      // 03f: ifeq 04c
      // 042: goto 046
      // 045: athrow
      // 046: aload 0
      // 047: invokevirtual x/oc11364ce42a.Α ()V
      // 04a: return
      // 04b: athrow
      // 04c: aload 0
      // 04d: iload 1
      // 04e: ifne 08f
      // 051: getfield x/oc11364ce42a.ћ Z
      // 054: ifne 08a
      // 057: goto 05b
      // 05a: athrow
      // 05b: aload 0
      // 05c: iload 1
      // 05d: ifne 08f
      // 060: goto 064
      // 063: athrow
      // 064: invokevirtual x/oc11364ce42a.Ѻ ()Z
      // 067: ifne 08a
      // 06a: goto 06e
      // 06d: athrow
      // 06e: aload 0
      // 06f: iload 1
      // 070: ifne 094
      // 073: goto 077
      // 076: athrow
      // 077: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 07a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 07d: getfield net/minecraft/client/entity/EntityPlayerSP.capabilities Lnet/minecraft/entity/player/PlayerCapabilities;
      // 080: getfield net/minecraft/entity/player/PlayerCapabilities.allowEdit Z
      // 083: ifne 093
      // 086: goto 08a
      // 089: athrow
      // 08a: aload 0
      // 08b: goto 08f
      // 08e: athrow
      // 08f: invokevirtual x/oc11364ce42a.Α ()V
      // 092: return
      // 093: aload 0
      // 094: invokevirtual x/oc11364ce42a.ϒ ()Lnet/minecraft/item/ItemStack;
      // 097: astore 2
      // 098: aload 2
      // 099: invokestatic x/oc11364ce42a.ʦ (Lnet/minecraft/item/ItemStack;)Z
      // 09c: iload 1
      // 09d: ifne 0cf
      // 0a0: ifne 0c3
      // 0a3: goto 0a7
      // 0a6: athrow
      // 0a7: aload 0
      // 0a8: iload 1
      // 0a9: ifne 0bf
      // 0ac: goto 0b0
      // 0af: athrow
      // 0b0: invokevirtual x/oc11364ce42a.Υ ()I
      // 0b3: ifne 0c2
      // 0b6: goto 0ba
      // 0b9: athrow
      // 0ba: aload 0
      // 0bb: goto 0bf
      // 0be: athrow
      // 0bf: invokevirtual x/oc11364ce42a.Α ()V
      // 0c2: return
      // 0c3: aload 0
      // 0c4: iload 1
      // 0c5: ifne 117
      // 0c8: getfield x/oc11364ce42a.ʫ Z
      // 0cb: goto 0cf
      // 0ce: athrow
      // 0cf: ifne 10d
      // 0d2: aload 0
      // 0d3: aload 0
      // 0d4: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 0d7: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0da: getfield net/minecraft/client/entity/EntityPlayerSP.ticksExisted I
      // 0dd: putfield x/oc11364ce42a.p I
      // 0e0: aload 0
      // 0e1: invokestatic java/lang/System.currentTimeMillis ()J
      // 0e4: putfield x/oc11364ce42a.Ϯ J
      // 0e7: aload 0
      // 0e8: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 0eb: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 0ee: getfield net/minecraft/client/settings/GameSettings.keyBindAttack Lnet/minecraft/client/settings/KeyBinding;
      // 0f1: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // 0f4: bipush 0
      // 0f5: invokestatic net/minecraft/client/settings/KeyBinding.setKeyBindState (IZ)V
      // 0f8: aload 0
      // 0f9: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 0fc: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 0ff: getfield net/minecraft/client/settings/GameSettings.keyBindUseItem Lnet/minecraft/client/settings/KeyBinding;
      // 102: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // 105: bipush 0
      // 106: invokestatic net/minecraft/client/settings/KeyBinding.setKeyBindState (IZ)V
      // 109: goto 10d
      // 10c: athrow
      // 10d: aload 0
      // 10e: bipush 1
      // 10f: putfield x/oc11364ce42a.ʫ Z
      // 112: aload 0
      // 113: invokevirtual x/oc11364ce42a.ш ()V
      // 116: aload 0
      // 117: iload 1
      // 118: ifne 132
      // 11b: getfield x/oc11364ce42a.Џ I
      // 11e: ifle 131
      // 121: goto 125
      // 124: athrow
      // 125: aload 0
      // 126: dup
      // 127: getfield x/oc11364ce42a.Џ I
      // 12a: bipush 1
      // 12b: isub
      // 12c: putfield x/oc11364ce42a.Џ I
      // 12f: return
      // 130: athrow
      // 131: aload 0
      // 132: iload 1
      // 133: ifne 145
      // 136: getfield x/oc11364ce42a.ϳ Z
      // 139: ifne 14b
      // 13c: goto 140
      // 13f: athrow
      // 140: aload 0
      // 141: goto 145
      // 144: athrow
      // 145: getfield x/oc11364ce42a.Ŗ Z
      // 148: ifeq 14d
      // 14b: return
      // 14c: athrow
      // 14d: new net/minecraft/util/BlockPos
      // 150: dup
      // 151: aload 0
      // 152: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 155: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 158: getfield net/minecraft/client/entity/EntityPlayerSP.posX D
      // 15b: aload 0
      // 15c: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 15f: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 162: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // 165: dconst_1
      // 166: dsub
      // 167: aload 0
      // 168: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 16b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 16e: getfield net/minecraft/client/entity/EntityPlayerSP.posZ D
      // 171: invokespecial net/minecraft/util/BlockPos.<init> (DDD)V
      // 174: astore 3
      // 175: aload 0
      // 176: aload 0
      // 177: iload 1
      // 178: ifne 18b
      // 17b: aload 3
      // 17c: invokevirtual x/oc11364ce42a.Ց (Lnet/minecraft/util/BlockPos;)Z
      // 17f: ifeq 193
      // 182: goto 186
      // 185: athrow
      // 186: aload 0
      // 187: goto 18b
      // 18a: athrow
      // 18b: getfield x/oc11364ce42a.Ѐ I
      // 18e: bipush 1
      // 18f: iadd
      // 190: goto 194
      // 193: bipush 0
      // 194: putfield x/oc11364ce42a.Ѐ I
      // 197: aload 0
      // 198: aload 2
      // 199: invokevirtual x/oc11364ce42a.ù (Lnet/minecraft/item/ItemStack;)V
      // 19c: return
   }

   private void ù(ItemStack param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: aload 0
      // 05: aconst_null
      // 06: aload 1
      // 07: invokevirtual x/oc11364ce42a.Κ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/item/ItemStack;)Lnet/minecraft/util/BlockPos;
      // 0a: ifnull 20
      // 0d: aload 1
      // 0e: getfield net/minecraft/item/ItemStack.stackSize I
      // 11: iload 2
      // 12: ifne 25
      // 15: goto 19
      // 18: athrow
      // 19: ifgt 21
      // 1c: goto 20
      // 1f: athrow
      // 20: return
      // 21: aload 0
      // 22: getfield x/oc11364ce42a.ҷ Z
      // 25: iload 2
      // 26: ifne 44
      // 29: ifne 43
      // 2c: goto 30
      // 2f: athrow
      // 30: aload 0
      // 31: invokevirtual x/oc11364ce42a.Њ ()Z
      // 34: iload 2
      // 35: ifne 44
      // 38: goto 3c
      // 3b: athrow
      // 3c: ifeq 7e
      // 3f: goto 43
      // 42: athrow
      // 43: bipush 0
      // 44: istore 3
      // 45: iload 3
      // 46: aload 0
      // 47: getfield x/oc11364ce42a.ϭ Lx/oc668fce0dbf;
      // 4a: invokevirtual x/oc668fce0dbf.ө ()I
      // 4d: if_icmpge 7e
      // 50: aload 1
      // 51: getfield net/minecraft/item/ItemStack.stackSize I
      // 54: iload 2
      // 55: ifne 68
      // 58: ifle 7e
      // 5b: goto 5f
      // 5e: athrow
      // 5f: aload 0
      // 60: aload 1
      // 61: invokevirtual x/oc11364ce42a.Ý (Lnet/minecraft/item/ItemStack;)Z
      // 64: goto 68
      // 67: athrow
      // 68: ifne 73
      // 6b: iload 2
      // 6c: ifeq 7e
      // 6f: goto 73
      // 72: athrow
      // 73: iinc 3 1
      // 76: iload 2
      // 77: ifeq 45
      // 7a: goto 7e
      // 7d: athrow
      // 7e: return
   }

   private BlockPos Κ(BlockPos param1, ItemStack param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: aload 0
      // 004: aload 1
      // 005: invokevirtual x/oc11364ce42a.à (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/util/BlockPos;
      // 008: astore 4
      // 00a: istore 3
      // 00b: aload 4
      // 00d: ifnonnull 013
      // 010: aconst_null
      // 011: areturn
      // 012: athrow
      // 013: aload 0
      // 014: aload 4
      // 016: aconst_null
      // 017: invokevirtual x/oc11364ce42a.Ս (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/BlockPos;)Lnet/minecraft/util/EnumFacing;
      // 01a: astore 5
      // 01c: aload 5
      // 01e: ifnonnull 024
      // 021: aconst_null
      // 022: areturn
      // 023: athrow
      // 024: aload 4
      // 026: aload 5
      // 028: invokevirtual net/minecraft/util/EnumFacing.getOpposite ()Lnet/minecraft/util/EnumFacing;
      // 02b: invokevirtual net/minecraft/util/BlockPos.offset (Lnet/minecraft/util/EnumFacing;)Lnet/minecraft/util/BlockPos;
      // 02e: astore 6
      // 030: aload 0
      // 031: iload 3
      // 032: ifne 088
      // 035: getfield x/oc11364ce42a.Ѐ I
      // 038: ifgt 087
      // 03b: goto 03f
      // 03e: athrow
      // 03f: aload 0
      // 040: invokevirtual x/oc11364ce42a.ɨ ()Z
      // 043: iload 3
      // 044: ifne 05d
      // 047: goto 04b
      // 04a: athrow
      // 04b: ifeq 085
      // 04e: goto 052
      // 051: athrow
      // 052: invokestatic java/lang/Math.random ()D
      // 055: ldc2_w 0.8
      // 058: dcmpl
      // 059: goto 05d
      // 05c: athrow
      // 05d: ifle 085
      // 060: aload 0
      // 061: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 064: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 067: invokeinterface x/oc51cbcffcfe.callSyncCurrentPlayItem ()V 1
      // 06c: aload 0
      // 06d: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 070: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 073: getfield net/minecraft/client/entity/EntityPlayerSP.sendQueue Lnet/minecraft/client/network/NetHandlerPlayClient;
      // 076: new net/minecraft/network/play/client/C08PacketPlayerBlockPlacement
      // 079: dup
      // 07a: aload 2
      // 07b: invokespecial net/minecraft/network/play/client/C08PacketPlayerBlockPlacement.<init> (Lnet/minecraft/item/ItemStack;)V
      // 07e: invokevirtual net/minecraft/client/network/NetHandlerPlayClient.addToSendQueue (Lnet/minecraft/network/Packet;)V
      // 081: goto 085
      // 084: athrow
      // 085: aconst_null
      // 086: areturn
      // 087: aload 0
      // 088: aload 6
      // 08a: aload 5
      // 08c: getstatic x/oc75d51ec7eb.d [F
      // 08f: bipush 0
      // 090: faload
      // 091: invokevirtual x/oc11364ce42a.ԟ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;F)[F
      // 094: astore 7
      // 096: iload 3
      // 097: ifne 0c7
      // 09a: aload 7
      // 09c: ifnonnull 0b7
      // 09f: goto 0a3
      // 0a2: athrow
      // 0a3: aload 1
      // 0a4: ifnonnull 0b0
      // 0a7: goto 0ab
      // 0aa: athrow
      // 0ab: aconst_null
      // 0ac: goto 0b6
      // 0af: athrow
      // 0b0: aload 0
      // 0b1: aconst_null
      // 0b2: aload 2
      // 0b3: invokevirtual x/oc11364ce42a.Κ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/item/ItemStack;)Lnet/minecraft/util/BlockPos;
      // 0b6: areturn
      // 0b7: aload 0
      // 0b8: aload 7
      // 0ba: bipush 0
      // 0bb: faload
      // 0bc: putfield x/oc11364ce42a.ʆ F
      // 0bf: aload 0
      // 0c0: aload 7
      // 0c2: bipush 1
      // 0c3: faload
      // 0c4: putfield x/oc11364ce42a.ϵ F
      // 0c7: aload 0
      // 0c8: aload 7
      // 0ca: bipush 0
      // 0cb: faload
      // 0cc: aload 7
      // 0ce: bipush 1
      // 0cf: faload
      // 0d0: invokevirtual x/oc11364ce42a.Ϸ (FF)Lnet/minecraft/util/MovingObjectPosition;
      // 0d3: astore 8
      // 0d5: aload 8
      // 0d7: aload 6
      // 0d9: aconst_null
      // 0da: invokestatic x/oc11364ce42a.Ϸ (Lnet/minecraft/util/MovingObjectPosition;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;)Z
      // 0dd: iload 3
      // 0de: ifne 126
      // 0e1: ifne 0fc
      // 0e4: goto 0e8
      // 0e7: athrow
      // 0e8: aload 1
      // 0e9: ifnonnull 0f5
      // 0ec: goto 0f0
      // 0ef: athrow
      // 0f0: aconst_null
      // 0f1: goto 0fb
      // 0f4: athrow
      // 0f5: aload 0
      // 0f6: aconst_null
      // 0f7: aload 2
      // 0f8: invokevirtual x/oc11364ce42a.Κ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/item/ItemStack;)Lnet/minecraft/util/BlockPos;
      // 0fb: areturn
      // 0fc: aload 0
      // 0fd: iload 3
      // 0fe: ifne 139
      // 101: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 104: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 107: aload 0
      // 108: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 10b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 10e: aload 0
      // 10f: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 112: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 115: aload 2
      // 116: aload 6
      // 118: aload 5
      // 11a: aload 8
      // 11c: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 11f: invokevirtual net/minecraft/client/multiplayer/PlayerControllerMP.onPlayerRightClick (Lnet/minecraft/client/entity/EntityPlayerSP;Lnet/minecraft/client/multiplayer/WorldClient;Lnet/minecraft/item/ItemStack;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;Lnet/minecraft/util/Vec3;)Z
      // 122: goto 126
      // 125: athrow
      // 126: ifne 12c
      // 129: aconst_null
      // 12a: areturn
      // 12b: athrow
      // 12c: aload 0
      // 12d: invokevirtual x/oc11364ce42a.Ӵ ()V
      // 130: iload 3
      // 131: ifne 170
      // 134: aload 0
      // 135: goto 139
      // 138: athrow
      // 139: getfield x/oc11364ce42a.Ȩ I
      // 13c: bipush -1
      // 13d: if_icmpeq 165
      // 140: aload 0
      // 141: iload 3
      // 142: ifne 16c
      // 145: goto 149
      // 148: athrow
      // 149: invokevirtual x/oc11364ce42a.Њ ()Z
      // 14c: ifeq 165
      // 14f: goto 153
      // 152: athrow
      // 153: aload 0
      // 154: aload 0
      // 155: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 158: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 15b: getfield net/minecraft/client/entity/EntityPlayerSP.ticksExisted I
      // 15e: putfield x/oc11364ce42a.Ά I
      // 161: goto 165
      // 164: athrow
      // 165: aload 0
      // 166: aload 4
      // 168: invokevirtual x/oc11364ce42a.Ҽ (Lnet/minecraft/util/BlockPos;)V
      // 16b: aload 0
      // 16c: bipush 0
      // 16d: putfield x/oc11364ce42a.Ѐ I
      // 170: aload 4
      // 172: areturn
   }

   private boolean Ý(ItemStack var1) {
      BlockPos var3 = null;
      EnumFacing var4 = null;
      BlockPos var5 = null;
      float[] var6 = null;
      int var2 = oc84f20a0bc5.ė;
      MovingObjectPosition var7 = null;
      float var8 = 0.0F;
      float var9 = 0.0F;
      float var10 = 0.0F;
      int var11 = 707009332 ^ -280949973;

      while (true) {
         switch (var11) {
            case -1648952135:
               this.Ӵ();
               this.Ҽ(var3);
               return true;
            case -956372312:
               var4 = null;
               var11 = -117004628 ^ -280949973;
               break;
            case 94538226:
               var4 = this.Ս(var3, this.ŭ);
               var11 = -117004628 ^ -280949973;
               if (var2 == 0) {
                  break;
               }
            case -237385709:
               var5 = var3.offset(var4.getOpposite());
               if (var2 == 0) {
                  var6 = this.ԟ(var5, var4, oc75d51ec7eb.d[0]);
                  if (var6 == null) {
                     var11 = -1515902190 ^ -280949973;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var11 = -1995641067 ^ -280949973;
               }

               if (var2 == 0) {
                  break;
               }
            case 800065103:
               var1.onItemUse(this.ĸ.thePlayer, this.ĸ.theWorld, var5, var7.sideHit, var8, var9, var10);
               var11 = 1928853394 ^ -280949973;
               if (var2 == 0) {
                  break;
               }
            case 1716380734:
               var7 = this.Ϸ(var6[0], var6[1]);
               var11 = -946178280 ^ -280949973;
               if (var2 == 0) {
                  break;
               }
            case 373796231:
               if (var4 == null) {
                  var11 = -1596978354 ^ -280949973;
                  if (var2 == 0) {
                     break;
                  }
               }

               var11 = 513327928 ^ -280949973;
               if (var2 == 0) {
                  break;
               }
            case 685472819:
               int var10000;
               label77: {
                  label76: {
                     try {
                        var10000 = Ϸ(var7, var5, null);
                        if (var2 != 0) {
                           break label77;
                        }

                        if (var10000 != 0) {
                           break label76;
                        }
                     } catch (ocbde1165e4e var12) {
                        throw var12;
                     }

                     var11 = 333678880 ^ -280949973;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var10000 = -60011118 ^ -280949973;
               }

               var11 = var10000;
               if (var2 == 0) {
                  break;
               }
            case -56458741:
               return false;
            case 321734329:
               var8 = (float)(var7.hitVec.xCoord - var5.getX());
               if (var2 == 0) {
                  var9 = (float)(var7.hitVec.yCoord - var5.getY());
                  var10 = (float)(var7.hitVec.zCoord - var5.getZ());
                  this.ĸ.thePlayer.sendQueue.addToSendQueue(new C08PacketPlayerBlockPlacement(var5, var7.sideHit.getIndex(), var1, var8, var9, var10));
                  if (!this.ĸ.thePlayer.capabilities.isCreativeMode) {
                     var11 = -1057944220 ^ -280949973;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var11 = 1928853394 ^ -280949973;
               }

               if (var2 == 0) {
                  break;
               }
            case -983232481:
               var3 = this.à(this.ŭ);

               label86: {
                  label85: {
                     try {
                        if (var2 != 0) {
                           break label86;
                        }

                        if (var3 != null) {
                           break label85;
                        }
                     } catch (ocbde1165e4e var13) {
                        throw var13;
                     }

                     var11 = 700440963 ^ -280949973;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var11 = -354188583 ^ -280949973;
               }

               if (var2 == 0) {
                  break;
               }
            case 1256464441:
               var7 = null;
               var11 = -946178280 ^ -280949973;
               break;
            case 1334902885:
               return false;
            default:
               throw null;
         }
      }
   }

   private void Ҽ(BlockPos var1) {
      this.ŭ = var1;
      this.ơ = System.currentTimeMillis();
      this.ǘ.put(var1, this.ơ);
   }

   private void Ӵ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: aload 0
      // 04: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 07: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0a: invokevirtual net/minecraft/client/entity/EntityPlayerSP.swingItem ()V
      // 0d: istore 1
      // 0e: aload 0
      // 0f: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 12: iload 1
      // 13: ifne 28
      // 16: invokevirtual net/minecraft/client/Minecraft.getItemRenderer ()Lnet/minecraft/client/renderer/ItemRenderer;
      // 19: ifnull 2e
      // 1c: goto 20
      // 1f: athrow
      // 20: aload 0
      // 21: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 24: goto 28
      // 27: athrow
      // 28: invokevirtual net/minecraft/client/Minecraft.getItemRenderer ()Lnet/minecraft/client/renderer/ItemRenderer;
      // 2b: invokevirtual net/minecraft/client/renderer/ItemRenderer.resetEquippedProgress ()V
      // 2e: return
   }

   private BlockPos à(BlockPos param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 2
      // 004: aload 0
      // 005: iload 2
      // 006: ifne 019
      // 009: getfield x/oc11364ce42a.Ȩ I
      // 00c: bipush -1
      // 00d: if_icmpeq 02b
      // 010: goto 014
      // 013: athrow
      // 014: aload 0
      // 015: goto 019
      // 018: athrow
      // 019: invokevirtual x/oc11364ce42a.Њ ()Z
      // 01c: iload 2
      // 01d: ifne 028
      // 020: ifeq 02b
      // 023: goto 027
      // 026: athrow
      // 027: bipush 1
      // 028: goto 02c
      // 02b: bipush 0
      // 02c: istore 3
      // 02d: new java/util/ArrayList
      // 030: dup
      // 031: invokespecial java/util/ArrayList.<init> ()V
      // 034: astore 4
      // 036: ldc_w -453948518
      // 039: ldc_w 453948513
      // 03c: ixor
      // 03d: istore 5
      // 03f: iload 5
      // 041: ldc_w 453948516
      // 044: ldc_w 453948513
      // 047: ixor
      // 048: if_icmpgt 17d
      // 04b: ldc_w -453948518
      // 04e: ldc_w 453948513
      // 051: ixor
      // 052: istore 6
      // 054: iload 6
      // 056: ldc_w 453948516
      // 059: ldc_w 453948513
      // 05c: ixor
      // 05d: if_icmpgt 176
      // 060: iload 2
      // 061: ifne 179
      // 064: ldc_w -453948516
      // 067: ldc_w 453948513
      // 06a: ixor
      // 06b: istore 7
      // 06d: iload 7
      // 06f: bipush -1
      // 070: if_icmpgt 16f
      // 073: aload 0
      // 074: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 077: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 07a: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // 07d: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 080: iload 7
      // 082: iadd
      // 083: istore 8
      // 085: iload 2
      // 086: ifne 172
      // 089: iload 3
      // 08a: iload 2
      // 08b: ifne 09b
      // 08e: goto 092
      // 091: athrow
      // 092: ifeq 0aa
      // 095: goto 099
      // 098: athrow
      // 099: iload 8
      // 09b: aload 0
      // 09c: getfield x/oc11364ce42a.Ȩ I
      // 09f: if_icmpeq 0aa
      // 0a2: iload 2
      // 0a3: ifeq 168
      // 0a6: goto 0aa
      // 0a9: athrow
      // 0aa: aload 0
      // 0ab: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 0ae: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0b1: getfield net/minecraft/client/entity/EntityPlayerSP.posX D
      // 0b4: iload 5
      // 0b6: i2d
      // 0b7: dadd
      // 0b8: dstore 9
      // 0ba: aload 0
      // 0bb: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 0be: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0c1: getfield net/minecraft/client/entity/EntityPlayerSP.posZ D
      // 0c4: iload 6
      // 0c6: i2d
      // 0c7: dadd
      // 0c8: dstore 11
      // 0ca: aload 0
      // 0cb: new net/minecraft/util/BlockPos
      // 0ce: dup
      // 0cf: dload 9
      // 0d1: iload 8
      // 0d3: i2d
      // 0d4: dload 11
      // 0d6: invokespecial net/minecraft/util/BlockPos.<init> (DDD)V
      // 0d9: invokevirtual x/oc11364ce42a.Ց (Lnet/minecraft/util/BlockPos;)Z
      // 0dc: iload 2
      // 0dd: ifne 0f4
      // 0e0: ifeq 0ef
      // 0e3: goto 0e7
      // 0e6: athrow
      // 0e7: iload 2
      // 0e8: ifeq 168
      // 0eb: goto 0ef
      // 0ee: athrow
      // 0ef: bipush -1
      // 0f0: goto 0f4
      // 0f3: athrow
      // 0f4: istore 13
      // 0f6: iload 13
      // 0f8: bipush 1
      // 0f9: if_icmpgt 168
      // 0fc: aload 4
      // 0fe: new net/minecraft/util/Vec3
      // 101: dup
      // 102: dload 9
      // 104: iload 13
      // 106: i2d
      // 107: dadd
      // 108: iload 8
      // 10a: i2d
      // 10b: dload 11
      // 10d: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 110: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 115: pop
      // 116: iload 2
      // 117: ifne 164
      // 11a: aload 4
      // 11c: new net/minecraft/util/Vec3
      // 11f: dup
      // 120: dload 9
      // 122: iload 8
      // 124: i2d
      // 125: dload 11
      // 127: iload 13
      // 129: i2d
      // 12a: dadd
      // 12b: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 12e: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 133: pop
      // 134: iload 2
      // 135: ifne 16b
      // 138: goto 13c
      // 13b: athrow
      // 13c: iload 3
      // 13d: ifne 161
      // 140: goto 144
      // 143: athrow
      // 144: aload 4
      // 146: new net/minecraft/util/Vec3
      // 149: dup
      // 14a: dload 9
      // 14c: iload 8
      // 14e: iload 13
      // 150: iadd
      // 151: i2d
      // 152: dload 11
      // 154: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 157: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 15c: pop
      // 15d: goto 161
      // 160: athrow
      // 161: iinc 13 2
      // 164: iload 2
      // 165: ifeq 0f6
      // 168: iinc 7 1
      // 16b: iload 2
      // 16c: ifeq 06d
      // 16f: iinc 6 1
      // 172: iload 2
      // 173: ifeq 054
      // 176: iinc 5 1
      // 179: iload 2
      // 17a: ifeq 03f
      // 17d: new java/util/HashSet
      // 180: dup
      // 181: aload 4
      // 183: invokeinterface java/util/List.size ()I 1
      // 188: ldc_w 453948515
      // 18b: ldc_w 453948513
      // 18e: ixor
      // 18f: imul
      // 190: invokespecial java/util/HashSet.<init> (I)V
      // 193: astore 5
      // 195: new java/util/ArrayList
      // 198: dup
      // 199: aload 4
      // 19b: invokeinterface java/util/List.size ()I 1
      // 1a0: invokespecial java/util/ArrayList.<init> (I)V
      // 1a3: astore 6
      // 1a5: aload 4
      // 1a7: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 1ac: astore 7
      // 1ae: aload 7
      // 1b0: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 1b5: ifeq 225
      // 1b8: aload 7
      // 1ba: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 1bf: checkcast net/minecraft/util/Vec3
      // 1c2: astore 8
      // 1c4: iload 2
      // 1c5: ifne 229
      // 1c8: aload 8
      // 1ca: getfield net/minecraft/util/Vec3.xCoord D
      // 1cd: invokestatic java/lang/Double.doubleToLongBits (D)J
      // 1d0: aload 8
      // 1d2: getfield net/minecraft/util/Vec3.yCoord D
      // 1d5: invokestatic java/lang/Double.doubleToLongBits (D)J
      // 1d8: ldc2_w -7513296200730086708
      // 1db: ldc2_w -7513296200730086701
      // 1de: lxor
      // 1df: lmul
      // 1e0: lxor
      // 1e1: aload 8
      // 1e3: getfield net/minecraft/util/Vec3.zCoord D
      // 1e6: invokestatic java/lang/Double.doubleToLongBits (D)J
      // 1e9: ldc2_w -7513296200730086708
      // 1ec: ldc2_w -7513296200730086701
      // 1ef: lxor
      // 1f0: lmul
      // 1f1: ldc2_w -7513296200730086708
      // 1f4: ldc2_w -7513296200730086701
      // 1f7: lxor
      // 1f8: lmul
      // 1f9: lxor
      // 1fa: lstore 9
      // 1fc: aload 5
      // 1fe: lload 9
      // 200: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 203: invokeinterface java/util/Set.add (Ljava/lang/Object;)Z 2
      // 208: iload 2
      // 209: ifne 220
      // 20c: ifeq 221
      // 20f: goto 213
      // 212: athrow
      // 213: aload 6
      // 215: aload 8
      // 217: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 21c: goto 220
      // 21f: athrow
      // 220: pop
      // 221: iload 2
      // 222: ifeq 1ae
      // 225: aload 6
      // 227: astore 4
      // 229: aload 0
      // 22a: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 22d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 230: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // 233: dconst_1
      // 234: dsub
      // 235: dstore 7
      // 237: aload 0
      // 238: iload 2
      // 239: ifne 251
      // 23c: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 23f: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 242: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 245: ifne 270
      // 248: goto 24c
      // 24b: athrow
      // 24c: aload 0
      // 24d: goto 251
      // 250: athrow
      // 251: iload 2
      // 252: ifne 264
      // 255: invokevirtual x/oc11364ce42a.ɫ ()Z
      // 258: ifne 270
      // 25b: goto 25f
      // 25e: athrow
      // 25f: aload 0
      // 260: goto 264
      // 263: athrow
      // 264: invokevirtual x/oc11364ce42a.Њ ()Z
      // 267: ifne 270
      // 26a: dload 7
      // 26c: dconst_1
      // 26d: dsub
      // 26e: dstore 7
      // 270: new net/minecraft/util/Vec3
      // 273: dup
      // 274: aload 0
      // 275: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 278: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 27b: getfield net/minecraft/client/entity/EntityPlayerSP.posX D
      // 27e: dload 7
      // 280: aload 0
      // 281: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 284: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 287: getfield net/minecraft/client/entity/EntityPlayerSP.posZ D
      // 28a: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 28d: astore 9
      // 28f: iload 2
      // 290: aload 9
      // 292: dup
      // 293: invokestatic java/util/Objects.requireNonNull (Ljava/lang/Object;)Ljava/lang/Object;
      // 296: pop
      // 297: invokedynamic applyAsDouble (Lnet/minecraft/util/Vec3;)Ljava/util/function/ToDoubleFunction; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)D, net/minecraft/util/Vec3.squareDistanceTo (Lnet/minecraft/util/Vec3;)D, (Lnet/minecraft/util/Vec3;)D ]
      // 29c: invokestatic java/util/Comparator.comparingDouble (Ljava/util/function/ToDoubleFunction;)Ljava/util/Comparator;
      // 29f: astore 10
      // 2a1: ifne 2fe
      // 2a4: aload 0
      // 2a5: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 2a8: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 2ab: getfield net/minecraft/client/entity/EntityPlayerSP.ticksExisted I
      // 2ae: aload 0
      // 2af: getfield x/oc11364ce42a.p I
      // 2b2: isub
      // 2b3: ldc_w 453948514
      // 2b6: ldc_w 453948513
      // 2b9: ixor
      // 2ba: if_icmpgt 2f5
      // 2bd: goto 2c1
      // 2c0: athrow
      // 2c1: aload 0
      // 2c2: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 2c5: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 2c8: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 2cb: ldc_w 0.017453292
      // 2ce: fmul
      // 2cf: f2d
      // 2d0: dstore 11
      // 2d2: dload 11
      // 2d4: invokestatic java/lang/Math.sin (D)D
      // 2d7: dneg
      // 2d8: dstore 13
      // 2da: dload 11
      // 2dc: invokestatic java/lang/Math.cos (D)D
      // 2df: dstore 15
      // 2e1: aload 10
      // 2e3: aload 9
      // 2e5: dload 13
      // 2e7: dload 15
      // 2e9: invokedynamic applyAsDouble (Lnet/minecraft/util/Vec3;DD)Ljava/util/function/ToDoubleFunction; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)D, x/oc11364ce42a.q1w7gpdclzoq2m (Lnet/minecraft/util/Vec3;DDLnet/minecraft/util/Vec3;)D, (Lnet/minecraft/util/Vec3;)D ]
      // 2ee: invokeinterface java/util/Comparator.thenComparingDouble (Ljava/util/function/ToDoubleFunction;)Ljava/util/Comparator; 2
      // 2f3: astore 10
      // 2f5: aload 4
      // 2f7: aload 10
      // 2f9: invokeinterface java/util/List.sort (Ljava/util/Comparator;)V 2
      // 2fe: aload 4
      // 300: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 305: astore 11
      // 307: aload 11
      // 309: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 30e: ifeq 34f
      // 311: aload 11
      // 313: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 318: checkcast net/minecraft/util/Vec3
      // 31b: astore 12
      // 31d: new net/minecraft/util/BlockPos
      // 320: dup
      // 321: aload 12
      // 323: invokespecial net/minecraft/util/BlockPos.<init> (Lnet/minecraft/util/Vec3;)V
      // 326: astore 13
      // 328: aload 0
      // 329: iload 2
      // 32a: ifne 33e
      // 32d: aload 13
      // 32f: invokevirtual x/oc11364ce42a.Ց (Lnet/minecraft/util/BlockPos;)Z
      // 332: ifeq 34b
      // 335: goto 339
      // 338: athrow
      // 339: aload 0
      // 33a: goto 33e
      // 33d: athrow
      // 33e: aload 13
      // 340: aload 1
      // 341: invokevirtual x/oc11364ce42a.Ս (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/BlockPos;)Lnet/minecraft/util/EnumFacing;
      // 344: ifnull 34b
      // 347: aload 13
      // 349: areturn
      // 34a: athrow
      // 34b: iload 2
      // 34c: ifeq 307
      // 34f: aconst_null
      // 350: areturn
   }

   private EnumFacing Ս(BlockPos param1, BlockPos param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: aload 1
      // 004: invokevirtual net/minecraft/util/BlockPos.down ()Lnet/minecraft/util/BlockPos;
      // 007: astore 4
      // 009: istore 3
      // 00a: aload 0
      // 00b: iload 3
      // 00c: ifne 03a
      // 00f: aload 4
      // 011: invokevirtual x/oc11364ce42a.ƴ (Lnet/minecraft/util/BlockPos;)Z
      // 014: ifeq 039
      // 017: goto 01b
      // 01a: athrow
      // 01b: aload 2
      // 01c: iload 3
      // 01d: ifne 02d
      // 020: goto 024
      // 023: athrow
      // 024: ifnull 034
      // 027: goto 02b
      // 02a: athrow
      // 02b: aload 4
      // 02d: aload 2
      // 02e: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 031: ifeq 039
      // 034: getstatic net/minecraft/util/EnumFacing.UP Lnet/minecraft/util/EnumFacing;
      // 037: areturn
      // 038: athrow
      // 039: aload 0
      // 03a: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 03d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 040: getfield net/minecraft/client/entity/EntityPlayerSP.posX D
      // 043: aload 1
      // 044: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 047: i2d
      // 048: ldc2_w 0.5
      // 04b: dadd
      // 04c: dsub
      // 04d: dstore 5
      // 04f: aload 0
      // 050: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 053: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 056: getfield net/minecraft/client/entity/EntityPlayerSP.posZ D
      // 059: aload 1
      // 05a: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 05d: i2d
      // 05e: ldc2_w 0.5
      // 061: dadd
      // 062: dsub
      // 063: dstore 7
      // 065: dload 5
      // 067: invokestatic java/lang/Math.abs (D)D
      // 06a: dload 7
      // 06c: iload 3
      // 06d: ifne 096
      // 070: invokestatic java/lang/Math.abs (D)D
      // 073: dcmpl
      // 074: ifle 093
      // 077: goto 07b
      // 07a: athrow
      // 07b: dload 5
      // 07d: dconst_0
      // 07e: dcmpl
      // 07f: ifle 08d
      // 082: goto 086
      // 085: athrow
      // 086: getstatic net/minecraft/util/EnumFacing.EAST Lnet/minecraft/util/EnumFacing;
      // 089: goto 0a4
      // 08c: athrow
      // 08d: getstatic net/minecraft/util/EnumFacing.WEST Lnet/minecraft/util/EnumFacing;
      // 090: goto 0a4
      // 093: dload 7
      // 095: dconst_0
      // 096: dcmpl
      // 097: ifle 0a1
      // 09a: getstatic net/minecraft/util/EnumFacing.SOUTH Lnet/minecraft/util/EnumFacing;
      // 09d: goto 0a4
      // 0a0: athrow
      // 0a1: getstatic net/minecraft/util/EnumFacing.NORTH Lnet/minecraft/util/EnumFacing;
      // 0a4: astore 9
      // 0a6: aload 1
      // 0a7: aload 9
      // 0a9: invokevirtual net/minecraft/util/BlockPos.offset (Lnet/minecraft/util/EnumFacing;)Lnet/minecraft/util/BlockPos;
      // 0ac: astore 10
      // 0ae: aload 0
      // 0af: aload 10
      // 0b1: invokevirtual x/oc11364ce42a.ƴ (Lnet/minecraft/util/BlockPos;)Z
      // 0b4: ifeq 0d7
      // 0b7: aload 2
      // 0b8: iload 3
      // 0b9: ifne 0c9
      // 0bc: goto 0c0
      // 0bf: athrow
      // 0c0: ifnull 0d0
      // 0c3: goto 0c7
      // 0c6: athrow
      // 0c7: aload 10
      // 0c9: aload 2
      // 0ca: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 0cd: ifeq 0d7
      // 0d0: aload 9
      // 0d2: invokevirtual net/minecraft/util/EnumFacing.getOpposite ()Lnet/minecraft/util/EnumFacing;
      // 0d5: areturn
      // 0d6: athrow
      // 0d7: getstatic x/oc11364ce42a.Զ [Lnet/minecraft/util/EnumFacing;
      // 0da: astore 11
      // 0dc: aload 11
      // 0de: arraylength
      // 0df: istore 12
      // 0e1: bipush 0
      // 0e2: istore 13
      // 0e4: iload 13
      // 0e6: iload 12
      // 0e8: if_icmpge 13d
      // 0eb: aload 11
      // 0ed: iload 13
      // 0ef: aaload
      // 0f0: astore 14
      // 0f2: iload 3
      // 0f3: aload 1
      // 0f4: aload 14
      // 0f6: invokevirtual net/minecraft/util/BlockPos.offset (Lnet/minecraft/util/EnumFacing;)Lnet/minecraft/util/BlockPos;
      // 0f9: astore 15
      // 0fb: ifne 139
      // 0fe: aload 14
      // 100: aload 9
      // 102: if_acmpeq 136
      // 105: goto 109
      // 108: athrow
      // 109: aload 0
      // 10a: aload 15
      // 10c: invokevirtual x/oc11364ce42a.ƴ (Lnet/minecraft/util/BlockPos;)Z
      // 10f: ifeq 136
      // 112: goto 116
      // 115: athrow
      // 116: aload 2
      // 117: iload 3
      // 118: ifne 128
      // 11b: goto 11f
      // 11e: athrow
      // 11f: ifnull 12f
      // 122: goto 126
      // 125: athrow
      // 126: aload 15
      // 128: aload 2
      // 129: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 12c: ifeq 136
      // 12f: aload 14
      // 131: invokevirtual net/minecraft/util/EnumFacing.getOpposite ()Lnet/minecraft/util/EnumFacing;
      // 134: areturn
      // 135: athrow
      // 136: iinc 13 1
      // 139: iload 3
      // 13a: ifeq 0e4
      // 13d: aconst_null
      // 13e: areturn
   }

   private boolean ƴ(BlockPos param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 99
      // 09: getfield x/oc11364ce42a.ǘ Ljava/util/Map;
      // 0c: invokeinterface java/util/Map.isEmpty ()Z 1
      // 11: ifne 98
      // 14: goto 18
      // 17: athrow
      // 18: aload 0
      // 19: iload 2
      // 1a: ifne 99
      // 1d: goto 21
      // 20: athrow
      // 21: getfield x/oc11364ce42a.ǘ Ljava/util/Map;
      // 24: aload 1
      // 25: invokeinterface java/util/Map.containsKey (Ljava/lang/Object;)Z 2
      // 2a: ifne 98
      // 2d: goto 31
      // 30: athrow
      // 31: aload 0
      // 32: iload 2
      // 33: ifne 99
      // 36: goto 3a
      // 39: athrow
      // 3a: invokevirtual x/oc11364ce42a.ƴ ()J
      // 3d: ldc2_w 78534229155113555
      // 40: ldc2_w 78534229155113641
      // 43: lxor
      // 44: lcmp
      // 45: ifge 98
      // 48: goto 4c
      // 4b: athrow
      // 4c: aload 0
      // 4d: getfield x/oc11364ce42a.ǘ Ljava/util/Map;
      // 50: invokeinterface java/util/Map.keySet ()Ljava/util/Set; 1
      // 55: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 5a: astore 3
      // 5b: aload 3
      // 5c: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 61: ifeq 98
      // 64: aload 3
      // 65: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 6a: checkcast net/minecraft/util/BlockPos
      // 6d: astore 4
      // 6f: aload 0
      // 70: iload 2
      // 71: ifne 99
      // 74: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 77: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 7a: aload 4
      // 7c: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getDistanceSq (Lnet/minecraft/util/BlockPos;)D
      // 7f: ldc2_w 12.0
      // 82: dcmpg
      // 83: iload 2
      // 84: ifne 93
      // 87: goto 8b
      // 8a: athrow
      // 8b: ifge 94
      // 8e: goto 92
      // 91: athrow
      // 92: bipush 0
      // 93: ireturn
      // 94: iload 2
      // 95: ifeq 5b
      // 98: aload 0
      // 99: iload 2
      // 9a: ifne ad
      // 9d: aload 1
      // 9e: invokevirtual x/oc11364ce42a.Ց (Lnet/minecraft/util/BlockPos;)Z
      // a1: ifne ce
      // a4: goto a8
      // a7: athrow
      // a8: aload 0
      // a9: goto ad
      // ac: athrow
      // ad: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // b0: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // b3: aload 1
      // b4: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // b7: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // bc: invokestatic x/oc11364ce42a.Ȝ (Lnet/minecraft/block/Block;)Z
      // bf: iload 2
      // c0: ifne cb
      // c3: ifne ce
      // c6: goto ca
      // c9: athrow
      // ca: bipush 1
      // cb: goto cf
      // ce: bipush 0
      // cf: ireturn
   }

   private float[] ԟ(BlockPos param1, EnumFacing param2, float param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 4
      // 005: aload 0
      // 006: iload 4
      // 008: ifne 020
      // 00b: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 00e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 011: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 014: ifeq 026
      // 017: goto 01b
      // 01a: athrow
      // 01b: aload 0
      // 01c: goto 020
      // 01f: athrow
      // 020: invokevirtual x/oc11364ce42a.Ǐ ()F
      // 023: goto 027
      // 026: fload 3
      // 027: fstore 5
      // 029: ldc_w 360.0
      // 02c: fstore 6
      // 02e: fconst_0
      // 02f: fstore 7
      // 031: fconst_0
      // 032: fstore 8
      // 034: fload 5
      // 036: ldc_w 170.0
      // 039: fsub
      // 03a: fstore 9
      // 03c: fload 9
      // 03e: fload 5
      // 040: ldc_w 170.0
      // 043: fadd
      // 044: fcmpg
      // 045: ifgt 153
      // 048: fload 9
      // 04a: iload 4
      // 04c: ifne 155
      // 04f: f2d
      // 050: invokestatic java/lang/Math.random ()D
      // 053: ldc2_w 0.5
      // 056: dsub
      // 057: dadd
      // 058: d2f
      // 059: fstore 10
      // 05b: ldc_w 90.0
      // 05e: fstore 11
      // 060: fload 11
      // 062: ldc_w 30.0
      // 065: fcmpl
      // 066: ifle 146
      // 069: fload 11
      // 06b: f2d
      // 06c: invokestatic java/lang/Math.random ()D
      // 06f: ldc2_w 0.5
      // 072: dsub
      // 073: dadd
      // 074: d2f
      // 075: ldc_w -90.0
      // 078: ldc_w 90.0
      // 07b: invokestatic net/minecraft/util/MathHelper.clamp_float (FFF)F
      // 07e: fstore 12
      // 080: iload 4
      // 082: aload 0
      // 083: fload 10
      // 085: fload 12
      // 087: invokevirtual x/oc11364ce42a.Ϸ (FF)Lnet/minecraft/util/MovingObjectPosition;
      // 08a: astore 13
      // 08c: fload 5
      // 08e: fload 10
      // 090: fsub
      // 091: invokestatic java/lang/Math.abs (F)F
      // 094: fstore 14
      // 096: ifne 14e
      // 099: iload 4
      // 09b: ifne 141
      // 09e: goto 0a2
      // 0a1: athrow
      // 0a2: aload 13
      // 0a4: aload 1
      // 0a5: aload 2
      // 0a6: invokestatic x/oc11364ce42a.Ϸ (Lnet/minecraft/util/MovingObjectPosition;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;)Z
      // 0a9: ifeq 137
      // 0ac: goto 0b0
      // 0af: athrow
      // 0b0: aload 13
      // 0b2: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 0b5: getfield net/minecraft/util/Vec3.xCoord D
      // 0b8: aload 1
      // 0b9: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 0bc: i2d
      // 0bd: dsub
      // 0be: d2f
      // 0bf: iload 4
      // 0c1: ifne 13f
      // 0c4: goto 0c8
      // 0c7: athrow
      // 0c8: invokestatic x/oc11364ce42a.о (F)Z
      // 0cb: ifeq 137
      // 0ce: goto 0d2
      // 0d1: athrow
      // 0d2: aload 13
      // 0d4: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 0d7: getfield net/minecraft/util/Vec3.yCoord D
      // 0da: aload 1
      // 0db: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 0de: i2d
      // 0df: dsub
      // 0e0: d2f
      // 0e1: iload 4
      // 0e3: ifne 13f
      // 0e6: goto 0ea
      // 0e9: athrow
      // 0ea: invokestatic x/oc11364ce42a.о (F)Z
      // 0ed: ifeq 137
      // 0f0: goto 0f4
      // 0f3: athrow
      // 0f4: aload 13
      // 0f6: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 0f9: getfield net/minecraft/util/Vec3.zCoord D
      // 0fc: aload 1
      // 0fd: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 100: i2d
      // 101: dsub
      // 102: d2f
      // 103: iload 4
      // 105: ifne 13f
      // 108: goto 10c
      // 10b: athrow
      // 10c: invokestatic x/oc11364ce42a.о (F)Z
      // 10f: ifeq 137
      // 112: goto 116
      // 115: athrow
      // 116: fload 14
      // 118: iload 4
      // 11a: ifne 13f
      // 11d: goto 121
      // 120: athrow
      // 121: fload 6
      // 123: fcmpg
      // 124: ifge 137
      // 127: goto 12b
      // 12a: athrow
      // 12b: fload 14
      // 12d: fstore 6
      // 12f: fload 10
      // 131: fstore 7
      // 133: fload 12
      // 135: fstore 8
      // 137: fload 11
      // 139: fload 11
      // 13b: invokestatic x/oc11364ce42a.ҧ (F)F
      // 13e: fsub
      // 13f: fstore 11
      // 141: iload 4
      // 143: ifeq 060
      // 146: fload 9
      // 148: ldc_w 5.0
      // 14b: fadd
      // 14c: fstore 9
      // 14e: iload 4
      // 150: ifeq 03c
      // 153: fload 6
      // 155: ldc_w 360.0
      // 158: fcmpl
      // 159: iload 4
      // 15b: ifne 171
      // 15e: ifne 16a
      // 161: goto 165
      // 164: athrow
      // 165: aconst_null
      // 166: goto 17d
      // 169: athrow
      // 16a: ldc_w -2082970657
      // 16d: ldc_w -2082970659
      // 170: ixor
      // 171: newarray 6
      // 173: dup
      // 174: bipush 0
      // 175: fload 7
      // 177: fastore
      // 178: dup
      // 179: bipush 1
      // 17a: fload 8
      // 17c: fastore
      // 17d: areturn
   }

   private static float ҧ(float param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 1
      // 04: fload 0
      // 05: iload 1
      // 06: ifne 1a
      // 09: ldc_w 75.0
      // 0c: fcmpl
      // 0d: ifle 19
      // 10: goto 14
      // 13: athrow
      // 14: fconst_1
      // 15: goto 34
      // 18: athrow
      // 19: fload 0
      // 1a: iload 1
      // 1b: ifne 2e
      // 1e: ldc_w 60.0
      // 21: fcmpl
      // 22: ifle 31
      // 25: goto 29
      // 28: athrow
      // 29: fconst_2
      // 2a: goto 2e
      // 2d: athrow
      // 2e: goto 34
      // 31: ldc_w 5.0
      // 34: freturn
   }

   private static boolean о(float var0) {
      int var1 = oc84f20a0bc5.ė;
      int var2 = 529089068 ^ 508392945;

      while (true) {
         switch (var2) {
            case -1501131926:
               break;
            case 29636573:
               int var8;
               label57: {
                  label56: {
                     try {
                        float var13;
                        var8 = (var13 = var0 - 0.0F) == 0.0F ? 0 : (var13 < 0.0F ? -1 : 1);
                        if (var1 != 0) {
                           break label57;
                        }

                        if (var8 == 0) {
                           break label56;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = 915730699 ^ 508392945;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var8 = 1357466930 ^ 508392945;
               }

               var2 = var8;
               continue;
            case 56462040:
               return false;
            case 685343994:
               int var10000;
               label89: {
                  label88: {
                     try {
                        float var11;
                        var10000 = (var11 = var0 - 1.0F) == 0.0F ? 0 : (var11 < 0.0F ? -1 : 1);
                        if (var1 != 0) {
                           break label89;
                        }

                        if (var10000 == 0) {
                           break label88;
                        }
                     } catch (ocbde1165e4e var6) {
                        throw var6;
                     }

                     var2 = -1285237304 ^ 508392945;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var10000 = 1357466930 ^ 508392945;
               }

               var2 = var10000;
               if (var1 == 0) {
                  continue;
               }
            case -1389780935:
               int var7;
               label79: {
                  label78: {
                     try {
                        double var10;
                        var7 = (var10 = var0 - 0.06) == 0.0 ? 0 : (var10 < 0.0 ? -1 : 1);
                        if (var1 != 0) {
                           break label79;
                        }

                        if (var7 <= 0) {
                           break label78;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var2 = -1194590565 ^ 508392945;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var7 = 487653161 ^ 508392945;
               }

               var2 = var7;
               if (var1 == 0) {
                  continue;
               }
               break;
            case 1319385283:
               return true;
            default:
               throw null;
         }

         int var9;
         label66: {
            label65: {
               try {
                  double var12;
                  var9 = (var12 = var0 - 0.94) == 0.0 ? 0 : (var12 < 0.0 ? -1 : 1);
                  if (var1 != 0) {
                     break label66;
                  }

                  if (var9 >= 0) {
                     break label65;
                  }
               } catch (ocbde1165e4e var4) {
                  throw var4;
               }

               var2 = 1357466930 ^ 508392945;
               if (var1 == 0) {
                  continue;
               }
            }

            var9 = 487653161 ^ 508392945;
         }

         var2 = var9;
         if (var1 != 0) {
            return true;
         }
      }
   }

   private MovingObjectPosition Ϸ(float var1, float var2) {
      Vec3 var3 = new Vec3(this.ĸ.thePlayer.posX, this.ĸ.thePlayer.posY + this.ĸ.thePlayer.getEyeHeight(), this.ĸ.thePlayer.posZ);
      float var11;
      float var4 = MathHelper.cos((var11 = var1 * (float) (-Math.PI / 180.0)) - (float) Math.PI);
      float var5 = MathHelper.sin(var11 - (float) Math.PI);
      float var12;
      float var6 = -MathHelper.cos(var12 = var2 * (float) (-Math.PI / 180.0));
      float var7 = MathHelper.sin(var12);
      Vec3 var8 = new Vec3(var5 * var6, var7, var4 * var6);
      double var9 = this.ĸ.playerController.getBlockReachDistance();
      return this.ĸ.theWorld.rayTraceBlocks(var3, var3.addVector(var8.xCoord * var9, var8.yCoord * var9, var8.zCoord * var9), false, false, false);
   }

   private static boolean Ϸ(MovingObjectPosition var0, BlockPos var1, EnumFacing var2) {
      int var3 = oc84f20a0bc5.ė;
      int var4 = -1032474052 ^ 693159054;

      while (true) {
         switch (var4) {
            case -932222081:
               if (var0.typeOfHit == MovingObjectType.BLOCK) {
                  var4 = -1021576496 ^ 693159054;
                  if (var3 == 0) {
                     break;
                  }
               }

               var4 = -1090166693 ^ 693159054;
               if (var3 == 0) {
                  break;
               }
            case -349866318:
               if (var0 != null) {
                  var4 = -515919887 ^ 693159054;
                  if (var3 == 0) {
                     break;
                  }
               }

               var4 = -1090166693 ^ 693159054;
               break;
            case -364167586:
               int var10000;
               label55: {
                  label54: {
                     try {
                        var10000 = var1.equals(var0.getBlockPos());
                        if (var3 != 0) {
                           break label55;
                        }

                        if (var10000 == 0) {
                           break label54;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var4 = 562698920 ^ 693159054;
                     if (var3 == 0) {
                        break;
                     }
                  }

                  var10000 = -1090166693 ^ 693159054;
               }

               var4 = var10000;
               if (var3 == 0) {
                  break;
               }
            case 1180630991:
               return true;
            case 1260190170:
               if (var0.sideHit == var2) {
                  var4 = 1863203649 ^ 693159054;
                  if (var3 == 0) {
                     break;
                  }
               }

               var4 = -1090166693 ^ 693159054;
               if (var3 == 0) {
                  break;
               }
            case 148561446:
               if (var2 != null) {
                  var4 = 1649163604 ^ 693159054;
                  if (var3 == 0) {
                     break;
                  }
               }

               var4 = 1863203649 ^ 693159054;
               if (var3 == 0) {
                  break;
               }
            case -1772772139:
               return false;
            default:
               throw null;
         }
      }
   }

   private float[] Щ(float param1, float param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 3
      // 004: aload 0
      // 005: iload 3
      // 006: ifne 1cd
      // 009: getfield x/oc11364ce42a.к I
      // 00c: ifle 1cc
      // 00f: goto 013
      // 012: athrow
      // 013: aload 0
      // 014: dup
      // 015: getfield x/oc11364ce42a.к I
      // 018: bipush 1
      // 019: isub
      // 01a: putfield x/oc11364ce42a.к I
      // 01d: ldc_w -180.0
      // 020: fstore 4
      // 022: aload 0
      // 023: iload 3
      // 024: ifne 043
      // 027: getfield x/oc11364ce42a.ϵ F
      // 02a: ldc 100.0
      // 02c: fcmpl
      // 02d: ifne 042
      // 030: goto 034
      // 033: athrow
      // 034: aload 0
      // 035: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 038: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 03b: getfield net/minecraft/client/entity/EntityPlayerSP.rotationPitch F
      // 03e: goto 046
      // 041: athrow
      // 042: aload 0
      // 043: getfield x/oc11364ce42a.ϵ F
      // 046: fstore 5
      // 048: aload 0
      // 049: getfield x/oc11364ce42a.к I
      // 04c: iload 3
      // 04d: ifne 0a2
      // 050: ldc_w -1724417722
      // 053: ldc_w -1724417726
      // 056: ixor
      // 057: if_icmpne 09a
      // 05a: goto 05e
      // 05d: athrow
      // 05e: aload 0
      // 05f: iload 3
      // 060: ifne 08d
      // 063: goto 067
      // 066: athrow
      // 067: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 06a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 06d: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 070: aload 0
      // 071: getfield x/oc11364ce42a.ƴ F
      // 074: fsub
      // 075: f2d
      // 076: ldc2_w -0.7
      // 079: dcmpg
      // 07a: ifge 086
      // 07d: goto 081
      // 080: athrow
      // 081: fload 4
      // 083: fneg
      // 084: fstore 4
      // 086: aload 0
      // 087: fload 4
      // 089: putfield x/oc11364ce42a.Ѫ F
      // 08c: aload 0
      // 08d: dup
      // 08e: getfield x/oc11364ce42a.Џ I
      // 091: bipush 1
      // 092: isub
      // 093: putfield x/oc11364ce42a.Џ I
      // 096: iload 3
      // 097: ifeq 1cc
      // 09a: aload 0
      // 09b: getfield x/oc11364ce42a.к I
      // 09e: goto 0a2
      // 0a1: athrow
      // 0a2: iload 3
      // 0a3: ifne 0e5
      // 0a6: ldc_w -1724417727
      // 0a9: ldc_w -1724417726
      // 0ac: ixor
      // 0ad: if_icmpne 0dd
      // 0b0: goto 0b4
      // 0b3: athrow
      // 0b4: aload 0
      // 0b5: getfield x/oc11364ce42a.Ѫ F
      // 0b8: iload 3
      // 0b9: ifne 0d7
      // 0bc: goto 0c0
      // 0bf: athrow
      // 0c0: fconst_0
      // 0c1: fcmpl
      // 0c2: ifle 0ce
      // 0c5: goto 0c9
      // 0c8: athrow
      // 0c9: fload 4
      // 0cb: fneg
      // 0cc: fstore 4
      // 0ce: ldc_w 20.0
      // 0d1: ldc_w 25.0
      // 0d4: invokestatic x/oc11364ce42a.П (FF)F
      // 0d7: fstore 5
      // 0d9: iload 3
      // 0da: ifeq 1b8
      // 0dd: aload 0
      // 0de: getfield x/oc11364ce42a.к I
      // 0e1: goto 0e5
      // 0e4: athrow
      // 0e5: iload 3
      // 0e6: ifne 136
      // 0e9: ldc_w -1724417728
      // 0ec: ldc_w -1724417726
      // 0ef: ixor
      // 0f0: if_icmpne 126
      // 0f3: goto 0f7
      // 0f6: athrow
      // 0f7: aload 0
      // 0f8: dup
      // 0f9: getfield x/oc11364ce42a.Ѫ F
      // 0fc: ldc_w 105.0
      // 0ff: ldc_w 120.0
      // 102: invokestatic x/oc11364ce42a.П (FF)F
      // 105: aload 0
      // 106: getfield x/oc11364ce42a.Ѫ F
      // 109: invokestatic java/lang/Math.signum (F)F
      // 10c: fmul
      // 10d: fsub
      // 10e: putfield x/oc11364ce42a.Ѫ F
      // 111: iload 3
      // 112: aload 0
      // 113: getfield x/oc11364ce42a.Ѫ F
      // 116: fstore 4
      // 118: ldc_w 40.0
      // 11b: ldc_w 45.0
      // 11e: invokestatic x/oc11364ce42a.П (FF)F
      // 121: fstore 5
      // 123: ifeq 1b8
      // 126: aload 0
      // 127: iload 3
      // 128: ifne 1a4
      // 12b: goto 12f
      // 12e: athrow
      // 12f: getfield x/oc11364ce42a.к I
      // 132: goto 136
      // 135: athrow
      // 136: bipush 1
      // 137: if_icmpne 17b
      // 13a: aload 0
      // 13b: dup
      // 13c: getfield x/oc11364ce42a.Ѫ F
      // 13f: ldc_w 33.0
      // 142: ldc_w 35.0
      // 145: invokestatic x/oc11364ce42a.П (FF)F
      // 148: aload 0
      // 149: getfield x/oc11364ce42a.Ѫ F
      // 14c: iload 3
      // 14d: ifne 1c7
      // 150: goto 154
      // 153: athrow
      // 154: invokestatic java/lang/Math.signum (F)F
      // 157: fmul
      // 158: fsub
      // 159: putfield x/oc11364ce42a.Ѫ F
      // 15c: aload 0
      // 15d: getfield x/oc11364ce42a.Ѫ F
      // 160: fstore 4
      // 162: aload 0
      // 163: getfield x/oc11364ce42a.ϵ F
      // 166: ldc 100.0
      // 168: fcmpl
      // 169: ifne 1b8
      // 16c: ldc_w 50.0
      // 16f: ldc_w 55.0
      // 172: invokestatic x/oc11364ce42a.П (FF)F
      // 175: fstore 5
      // 177: iload 3
      // 178: ifeq 1b8
      // 17b: aload 0
      // 17c: dup
      // 17d: getfield x/oc11364ce42a.Ѫ F
      // 180: ldc_w 29.0
      // 183: iload 3
      // 184: ifne 1c6
      // 187: goto 18b
      // 18a: athrow
      // 18b: ldc_w 33.0
      // 18e: invokestatic x/oc11364ce42a.П (FF)F
      // 191: aload 0
      // 192: getfield x/oc11364ce42a.Ѫ F
      // 195: invokestatic java/lang/Math.signum (F)F
      // 198: fmul
      // 199: fsub
      // 19a: putfield x/oc11364ce42a.Ѫ F
      // 19d: aload 0
      // 19e: getfield x/oc11364ce42a.Ѫ F
      // 1a1: fstore 4
      // 1a3: aload 0
      // 1a4: getfield x/oc11364ce42a.ϵ F
      // 1a7: ldc 100.0
      // 1a9: fcmpl
      // 1aa: ifne 1b8
      // 1ad: ldc_w 65.0
      // 1b0: ldc_w 70.0
      // 1b3: invokestatic x/oc11364ce42a.П (FF)F
      // 1b6: fstore 5
      // 1b8: aload 0
      // 1b9: aload 0
      // 1ba: invokevirtual x/oc11364ce42a.Ǐ ()F
      // 1bd: fload 4
      // 1bf: fadd
      // 1c0: invokestatic x/oc11364ce42a.Ν ()F
      // 1c3: fadd
      // 1c4: fload 5
      // 1c6: fload 1
      // 1c7: fload 2
      // 1c8: invokevirtual x/oc11364ce42a.Ӈ (FFFF)[F
      // 1cb: areturn
      // 1cc: aload 0
      // 1cd: invokevirtual x/oc11364ce42a.ƴ ()J
      // 1d0: lstore 4
      // 1d2: aload 0
      // 1d3: iload 3
      // 1d4: ifne 1f3
      // 1d7: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 1da: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1dd: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isSprinting ()Z
      // 1e0: ifeq 1f2
      // 1e3: goto 1e7
      // 1e6: athrow
      // 1e7: ldc2_w -4663289084565724229
      // 1ea: ldc2_w -4663289084565724803
      // 1ed: lxor
      // 1ee: goto 20b
      // 1f1: athrow
      // 1f2: aload 0
      // 1f3: invokevirtual x/oc11364ce42a.ɨ ()Z
      // 1f6: ifne 204
      // 1f9: ldc2_w -4663289084565725007
      // 1fc: ldc2_w -4663289084565724803
      // 1ff: lxor
      // 200: goto 20b
      // 203: athrow
      // 204: ldc2_w -4663289084565724909
      // 207: ldc2_w -4663289084565724803
      // 20a: lxor
      // 20b: lstore 6
      // 20d: iload 3
      // 20e: ifne 2c5
      // 211: aload 0
      // 212: getfield x/oc11364ce42a.ϵ F
      // 215: ldc 100.0
      // 217: fcmpl
      // 218: ifeq 2bf
      // 21b: goto 21f
      // 21e: athrow
      // 21f: lload 4
      // 221: lload 6
      // 223: lcmp
      // 224: iload 3
      // 225: ifne 2d4
      // 228: goto 22c
      // 22b: athrow
      // 22c: ifge 2bf
      // 22f: goto 233
      // 232: athrow
      // 233: aload 0
      // 234: getfield x/oc11364ce42a.ʆ F
      // 237: fstore 8
      // 239: aload 0
      // 23a: getfield x/oc11364ce42a.ϵ F
      // 23d: fstore 9
      // 23f: lload 4
      // 241: ldc2_w -4663289084565724808
      // 244: ldc2_w -4663289084565724803
      // 247: lxor
      // 248: lcmp
      // 249: iload 3
      // 24a: ifne 264
      // 24d: ifle 2b4
      // 250: goto 254
      // 253: athrow
      // 254: aload 0
      // 255: iload 3
      // 256: ifne 2b5
      // 259: goto 25d
      // 25c: athrow
      // 25d: invokevirtual x/oc11364ce42a.ɨ ()Z
      // 260: goto 264
      // 263: athrow
      // 264: ifeq 2b4
      // 267: invokestatic java/lang/Math.random ()D
      // 26a: iload 3
      // 26b: ifne 284
      // 26e: goto 272
      // 271: athrow
      // 272: ldc2_w 0.3
      // 275: dcmpl
      // 276: ifle 2b4
      // 279: goto 27d
      // 27c: athrow
      // 27d: fload 8
      // 27f: f2d
      // 280: goto 284
      // 283: athrow
      // 284: ldc2_w 0.05
      // 287: ldc2_w 0.45
      // 28a: invokestatic java/lang/Math.random ()D
      // 28d: dmul
      // 28e: dadd
      // 28f: invokestatic java/lang/Math.random ()D
      // 292: ldc2_w 0.5
      // 295: dcmpg
      // 296: iload 3
      // 297: ifne 2a2
      // 29a: ifge 2a5
      // 29d: goto 2a1
      // 2a0: athrow
      // 2a1: bipush -1
      // 2a2: goto 2a6
      // 2a5: bipush 1
      // 2a6: i2d
      // 2a7: dmul
      // 2a8: dadd
      // 2a9: d2f
      // 2aa: fstore 8
      // 2ac: fload 9
      // 2ae: invokestatic x/oc11364ce42a.Ν ()F
      // 2b1: fadd
      // 2b2: fstore 9
      // 2b4: aload 0
      // 2b5: fload 8
      // 2b7: fload 9
      // 2b9: fload 1
      // 2ba: fload 2
      // 2bb: invokevirtual x/oc11364ce42a.Ӈ (FFFF)[F
      // 2be: areturn
      // 2bf: aload 0
      // 2c0: ldc 100.0
      // 2c2: putfield x/oc11364ce42a.ϵ F
      // 2c5: aload 0
      // 2c6: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 2c9: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 2cc: getfield net/minecraft/client/entity/EntityPlayerSP.ticksExisted I
      // 2cf: aload 0
      // 2d0: getfield x/oc11364ce42a.p I
      // 2d3: isub
      // 2d4: istore 8
      // 2d6: aload 0
      // 2d7: invokevirtual x/oc11364ce42a.Ǐ ()F
      // 2da: aload 0
      // 2db: getfield x/oc11364ce42a.Ņ F
      // 2de: fadd
      // 2df: fstore 9
      // 2e1: aload 0
      // 2e2: getfield x/oc11364ce42a.ɓ F
      // 2e5: invokestatic x/oc11364ce42a.Ν ()F
      // 2e8: fadd
      // 2e9: fstore 10
      // 2eb: iload 8
      // 2ed: iload 3
      // 2ee: ifne 39a
      // 2f1: ldc_w -1724417728
      // 2f4: ldc_w -1724417726
      // 2f7: ixor
      // 2f8: if_icmpgt 398
      // 2fb: goto 2ff
      // 2fe: athrow
      // 2ff: aload 0
      // 300: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 303: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 306: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 309: iload 3
      // 30a: ifne 39a
      // 30d: goto 311
      // 310: athrow
      // 311: ifne 398
      // 314: goto 318
      // 317: athrow
      // 318: aload 0
      // 319: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 31c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 31f: getfield net/minecraft/client/entity/EntityPlayerSP.ticksExisted I
      // 322: aload 0
      // 323: getfield x/oc11364ce42a.ΐ I
      // 326: iload 3
      // 327: ifne 3a9
      // 32a: goto 32e
      // 32d: athrow
      // 32e: isub
      // 32f: ldc_w -1724417727
      // 332: ldc_w -1724417726
      // 335: ixor
      // 336: if_icmple 398
      // 339: goto 33d
      // 33c: athrow
      // 33d: aload 0
      // 33e: aconst_null
      // 33f: invokevirtual x/oc11364ce42a.à (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/util/BlockPos;
      // 342: astore 11
      // 344: aload 11
      // 346: ifnonnull 34e
      // 349: aconst_null
      // 34a: goto 355
      // 34d: athrow
      // 34e: aload 0
      // 34f: aload 11
      // 351: aconst_null
      // 352: invokevirtual x/oc11364ce42a.Ս (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/BlockPos;)Lnet/minecraft/util/EnumFacing;
      // 355: astore 12
      // 357: aload 12
      // 359: iload 3
      // 35a: ifne 366
      // 35d: ifnull 398
      // 360: goto 364
      // 363: athrow
      // 364: aload 12
      // 366: getstatic net/minecraft/util/EnumFacing.UP Lnet/minecraft/util/EnumFacing;
      // 369: if_acmpeq 398
      // 36c: aload 0
      // 36d: aload 11
      // 36f: aload 12
      // 371: invokevirtual net/minecraft/util/EnumFacing.getOpposite ()Lnet/minecraft/util/EnumFacing;
      // 374: invokevirtual net/minecraft/util/BlockPos.offset (Lnet/minecraft/util/EnumFacing;)Lnet/minecraft/util/BlockPos;
      // 377: aload 12
      // 379: fload 1
      // 37a: invokevirtual x/oc11364ce42a.ԟ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;F)[F
      // 37d: astore 13
      // 37f: iload 3
      // 380: ifne 392
      // 383: aload 13
      // 385: ifnull 398
      // 388: goto 38c
      // 38b: athrow
      // 38c: aload 13
      // 38e: bipush 0
      // 38f: faload
      // 390: fstore 9
      // 392: aload 13
      // 394: bipush 1
      // 395: faload
      // 396: fstore 10
      // 398: iload 8
      // 39a: iload 3
      // 39b: ifne 3ae
      // 39e: ldc_w -1724417728
      // 3a1: ldc_w -1724417726
      // 3a4: ixor
      // 3a5: goto 3a9
      // 3a8: athrow
      // 3a9: if_icmpgt 412
      // 3ac: iload 8
      // 3ae: iload 3
      // 3af: ifne 3c2
      // 3b2: ifne 3c0
      // 3b5: goto 3b9
      // 3b8: athrow
      // 3b9: ldc_w 0.3
      // 3bc: goto 3d0
      // 3bf: athrow
      // 3c0: iload 8
      // 3c2: bipush 1
      // 3c3: if_icmpne 3cd
      // 3c6: ldc_w 0.8
      // 3c9: goto 3d0
      // 3cc: athrow
      // 3cd: ldc_w 0.55
      // 3d0: f2d
      // 3d1: ldc2_w -0.02
      // 3d4: ldc2_w 0.04
      // 3d7: invokestatic java/lang/Math.random ()D
      // 3da: dmul
      // 3db: dadd
      // 3dc: dadd
      // 3dd: d2f
      // 3de: fstore 11
      // 3e0: fload 9
      // 3e2: fstore 12
      // 3e4: fload 1
      // 3e5: fload 11
      // 3e7: fload 9
      // 3e9: fload 1
      // 3ea: fsub
      // 3eb: fmul
      // 3ec: fadd
      // 3ed: fstore 9
      // 3ef: fload 2
      // 3f0: fload 11
      // 3f2: fload 10
      // 3f4: fload 2
      // 3f5: fsub
      // 3f6: fmul
      // 3f7: fadd
      // 3f8: fstore 10
      // 3fa: fload 9
      // 3fc: fload 12
      // 3fe: fsub
      // 3ff: invokestatic java/lang/Math.abs (F)F
      // 402: ldc_w 5.0
      // 405: fcmpg
      // 406: ifge 412
      // 409: aload 0
      // 40a: bipush 0
      // 40b: putfield x/oc11364ce42a.Џ I
      // 40e: goto 412
      // 411: athrow
      // 412: aload 0
      // 413: fload 9
      // 415: fload 10
      // 417: fload 1
      // 418: fload 2
      // 419: invokevirtual x/oc11364ce42a.Ӈ (FFFF)[F
      // 41c: astore 11
      // 41e: aload 11
      // 420: iload 3
      // 421: ifne 444
      // 424: bipush 0
      // 425: faload
      // 426: fload 1
      // 427: fcmpl
      // 428: ifeq 43e
      // 42b: goto 42f
      // 42e: athrow
      // 42f: aload 0
      // 430: invokestatic x/oc11364ce42a.Ν ()F
      // 433: putfield x/oc11364ce42a.Ņ F
      // 436: iload 3
      // 437: ifeq 447
      // 43a: goto 43e
      // 43d: athrow
      // 43e: aload 11
      // 440: goto 444
      // 443: athrow
      // 444: bipush 1
      // 445: fload 2
      // 446: fastore
      // 447: aload 11
      // 449: areturn
   }

   private float[] Ӈ(float var1, float var2, float var3, float var4) {
      float var5 = this.ĸ.gameSettings.mouseSensitivity * 0.6F + 0.2F;
      double var6 = var5 * var5 * var5 * 1.2;
      float[] var10000 = new float[-1222852441 ^ -1222852443];
      var10000[0] = var3 + (float)(Math.round((var1 - var3) / var6) * var6);
      var10000[1] = MathHelper.clamp_float(var4 + (float)(Math.round((var2 - var4) / var6) * var6), -90.0F, 90.0F);
      return var10000;
   }

   private void ш() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 1
      // 004: aload 0
      // 005: aload 0
      // 006: getfield x/oc11364ce42a.ϭ Lx/oc668fce0dbf;
      // 009: invokevirtual x/oc668fce0dbf.ǭ ()Z
      // 00c: iload 1
      // 00d: ifne 01f
      // 010: ifeq 035
      // 013: goto 017
      // 016: athrow
      // 017: bipush 1
      // 018: invokestatic org/lwjgl/input/Mouse.isButtonDown (I)Z
      // 01b: goto 01f
      // 01e: athrow
      // 01f: ifeq 035
      // 022: aload 0
      // 023: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 026: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 029: ifnonnull 035
      // 02c: goto 030
      // 02f: athrow
      // 030: bipush 1
      // 031: goto 036
      // 034: athrow
      // 035: bipush 0
      // 036: putfield x/oc11364ce42a.Ԋ Z
      // 039: aload 0
      // 03a: invokevirtual x/oc11364ce42a.Њ ()Z
      // 03d: istore 2
      // 03e: aload 0
      // 03f: iload 1
      // 040: ifne 0b4
      // 043: getfield x/oc11364ce42a.Ԋ Z
      // 046: aload 0
      // 047: getfield x/oc11364ce42a.b Z
      // 04a: if_icmpne 0af
      // 04d: goto 051
      // 050: athrow
      // 051: iload 2
      // 052: iload 1
      // 053: ifne 085
      // 056: goto 05a
      // 059: athrow
      // 05a: ifne 080
      // 05d: goto 061
      // 060: athrow
      // 061: aload 0
      // 062: getfield x/oc11364ce42a.ß Z
      // 065: iload 1
      // 066: ifne 085
      // 069: goto 06d
      // 06c: athrow
      // 06d: ifeq 080
      // 070: goto 074
      // 073: athrow
      // 074: aload 0
      // 075: invokevirtual x/oc11364ce42a.Y ()V
      // 078: iload 1
      // 079: ifeq 0de
      // 07c: goto 080
      // 07f: athrow
      // 080: iload 2
      // 081: goto 085
      // 084: athrow
      // 085: iload 1
      // 086: ifne 0df
      // 089: ifeq 0de
      // 08c: goto 090
      // 08f: athrow
      // 090: aload 0
      // 091: getfield x/oc11364ce42a.ß Z
      // 094: iload 1
      // 095: ifne 0df
      // 098: goto 09c
      // 09b: athrow
      // 09c: ifne 0de
      // 09f: goto 0a3
      // 0a2: athrow
      // 0a3: aload 0
      // 0a4: invokevirtual x/oc11364ce42a.ϣ ()V
      // 0a7: iload 1
      // 0a8: ifeq 0de
      // 0ab: goto 0af
      // 0ae: athrow
      // 0af: aload 0
      // 0b0: goto 0b4
      // 0b3: athrow
      // 0b4: getfield x/oc11364ce42a.ß Z
      // 0b7: iload 1
      // 0b8: ifne 0cb
      // 0bb: ifeq 0ca
      // 0be: goto 0c2
      // 0c1: athrow
      // 0c2: aload 0
      // 0c3: invokevirtual x/oc11364ce42a.Y ()V
      // 0c6: goto 0ca
      // 0c9: athrow
      // 0ca: iload 2
      // 0cb: ifeq 0d6
      // 0ce: aload 0
      // 0cf: invokevirtual x/oc11364ce42a.ϣ ()V
      // 0d2: goto 0d6
      // 0d5: athrow
      // 0d6: aload 0
      // 0d7: aload 0
      // 0d8: getfield x/oc11364ce42a.Ԋ Z
      // 0db: putfield x/oc11364ce42a.b Z
      // 0de: iload 2
      // 0df: iload 1
      // 0e0: ifne 14a
      // 0e3: ifne 138
      // 0e6: goto 0ea
      // 0e9: athrow
      // 0ea: aload 0
      // 0eb: iload 1
      // 0ec: ifne 102
      // 0ef: goto 0f3
      // 0f2: athrow
      // 0f3: getfield x/oc11364ce42a.ҷ Z
      // 0f6: ifne 137
      // 0f9: goto 0fd
      // 0fc: athrow
      // 0fd: aload 0
      // 0fe: goto 102
      // 101: athrow
      // 102: iload 1
      // 103: ifne 115
      // 106: getfield x/oc11364ce42a.к I
      // 109: ifle 137
      // 10c: goto 110
      // 10f: athrow
      // 110: aload 0
      // 111: goto 115
      // 114: athrow
      // 115: iload 1
      // 116: ifne 133
      // 119: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 11c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 11f: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 122: ifeq 137
      // 125: goto 129
      // 128: athrow
      // 129: aload 0
      // 12a: bipush 0
      // 12b: putfield x/oc11364ce42a.Џ I
      // 12e: aload 0
      // 12f: goto 133
      // 132: athrow
      // 133: bipush 0
      // 134: putfield x/oc11364ce42a.к I
      // 137: return
      // 138: aload 0
      // 139: iload 1
      // 13a: ifne 1dc
      // 13d: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 140: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 143: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 146: goto 14a
      // 149: athrow
      // 14a: ifeq 1d7
      // 14d: aload 0
      // 14e: iload 1
      // 14f: ifne 1cf
      // 152: goto 156
      // 155: athrow
      // 156: getfield x/oc11364ce42a.Ϟ I
      // 159: ldc_w -1356640151
      // 15c: ldc_w -1356640149
      // 15f: ixor
      // 160: if_icmpeq 1ca
      // 163: goto 167
      // 166: athrow
      // 167: aload 0
      // 168: iload 1
      // 169: ifne 1ac
      // 16c: goto 170
      // 16f: athrow
      // 170: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 173: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 176: getfield net/minecraft/client/entity/EntityPlayerSP.ticksExisted I
      // 179: aload 0
      // 17a: getfield x/oc11364ce42a.Ά I
      // 17d: isub
      // 17e: ldc_w -1356640159
      // 181: ldc_w -1356640149
      // 184: ixor
      // 185: if_icmple 24d
      // 188: goto 18c
      // 18b: athrow
      // 18c: aload 0
      // 18d: aload 0
      // 18e: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 191: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 194: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // 197: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 19a: bipush 1
      // 19b: isub
      // 19c: iload 1
      // 19d: ifne 1c3
      // 1a0: goto 1a4
      // 1a3: athrow
      // 1a4: putfield x/oc11364ce42a.Ȩ I
      // 1a7: aload 0
      // 1a8: goto 1ac
      // 1ab: athrow
      // 1ac: getfield x/oc11364ce42a.к I
      // 1af: ifne 1c1
      // 1b2: aload 0
      // 1b3: ldc_w -1356640146
      // 1b6: ldc_w -1356640149
      // 1b9: ixor
      // 1ba: putfield x/oc11364ce42a.к I
      // 1bd: goto 1c1
      // 1c0: athrow
      // 1c1: aload 0
      // 1c2: bipush 1
      // 1c3: putfield x/oc11364ce42a.Ϟ I
      // 1c6: iload 1
      // 1c7: ifeq 24d
      // 1ca: aload 0
      // 1cb: goto 1cf
      // 1ce: athrow
      // 1cf: bipush 0
      // 1d0: putfield x/oc11364ce42a.Ϟ I
      // 1d3: iload 1
      // 1d4: ifeq 24d
      // 1d7: aload 0
      // 1d8: goto 1dc
      // 1db: athrow
      // 1dc: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 1df: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1e2: iload 1
      // 1e3: ifne 1fd
      // 1e6: getfield net/minecraft/client/entity/EntityPlayerSP.motionY D
      // 1e9: dconst_0
      // 1ea: dcmpg
      // 1eb: ifge 24d
      // 1ee: goto 1f2
      // 1f1: athrow
      // 1f2: aload 0
      // 1f3: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 1f6: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1f9: goto 1fd
      // 1fc: athrow
      // 1fd: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // 200: invokestatic java/lang/Math.floor (D)D
      // 203: dstore 3
      // 204: dload 3
      // 205: dconst_1
      // 206: dsub
      // 207: aload 0
      // 208: iload 1
      // 209: ifne 22f
      // 20c: getfield x/oc11364ce42a.Ȩ I
      // 20f: i2d
      // 210: dcmpl
      // 211: ifne 24d
      // 214: goto 218
      // 217: athrow
      // 218: aload 0
      // 219: iload 1
      // 21a: ifne 243
      // 21d: goto 221
      // 220: athrow
      // 221: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 224: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 227: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // 22a: aload 0
      // 22b: goto 22f
      // 22e: athrow
      // 22f: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 232: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 235: getfield net/minecraft/client/entity/EntityPlayerSP.motionY D
      // 238: dadd
      // 239: dload 3
      // 23a: dcmpg
      // 23b: ifge 24d
      // 23e: aload 0
      // 23f: goto 243
      // 242: athrow
      // 243: ldc_w -1356640146
      // 246: ldc_w -1356640149
      // 249: ixor
      // 24a: putfield x/oc11364ce42a.к I
      // 24d: return
   }

   private void ϣ() {
      this.Ϟ = 0;
      this.ß = true;
   }

   private void Y() {
      this.Ȩ = -1;
      this.Ά = 0;
      this.ß = false;
   }

   private boolean Њ() {
      int var1 = oc84f20a0bc5.ė;
      int var2 = -161856751 ^ 1136426690;

      while (true) {
         label145:
         while (true) {
            switch (var2) {
               case -1815238503:
                  break;
               case -1457303717:
                  return true;
               case -1394445078:
                  return false;
               case -589699015:
                  int var10;
                  label129: {
                     label128: {
                        try {
                           var10 = this.ҷ;
                           if (var1 != 0) {
                              break label129;
                           }

                           if (this.ҷ) {
                              break label128;
                           }
                        } catch (ocbde1165e4e var8) {
                           throw var8;
                        }

                        var2 = 1353882712 ^ 1136426690;
                        if (var1 == 0) {
                           continue;
                        }
                     }

                     var10 = -279049688 ^ 1136426690;
                  }

                  var2 = var10;
                  if (var1 == 0) {
                     continue;
                  }
               case -1243202093:
                  int var11;
                  label117: {
                     label116: {
                        try {
                           var11 = this.ʫ;
                           if (var1 != 0) {
                              break label117;
                           }

                           if (!this.ʫ) {
                              break label116;
                           }
                        } catch (ocbde1165e4e var7) {
                           throw var7;
                        }

                        var2 = -797845925 ^ 1136426690;
                        if (var1 == 0) {
                           continue;
                        }
                     }

                     var11 = -279049688 ^ 1136426690;
                  }

                  var2 = var11;
                  if (var1 == 0) {
                     continue;
                  }
                  break;
               case -537319277:
                  int var9;
                  label86: {
                     label85: {
                        try {
                           var9 = this.ɨ();
                           if (var1 != 0) {
                              break label86;
                           }

                           if (var9 == 0) {
                              break label85;
                           }
                        } catch (ocbde1165e4e var4) {
                           throw var4;
                        }

                        var2 = 1282284525 ^ 1136426690;
                        if (var1 == 0) {
                           continue;
                        }
                     }

                     var9 = -279049688 ^ 1136426690;
                  }

                  var2 = var9;
                  if (var1 != 0) {
                     return true;
                  }
                  continue;
               case 265446703:
                  break label145;
               case 319742618:
                  int var10000;
                  label77: {
                     label76: {
                        try {
                           var10000 = this.ɫ();
                           if (var1 != 0) {
                              break label77;
                           }

                           if (var10000 != 0) {
                              break label76;
                           }
                        } catch (ocbde1165e4e var3) {
                           throw var3;
                        }

                        var2 = -1673177519 ^ 1136426690;
                        if (var1 == 0) {
                           continue;
                        }
                     }

                     var10000 = -279049688 ^ 1136426690;
                  }

                  var2 = var10000;
                  if (var1 != 0) {
                     return false;
                  }
                  continue;
               default:
                  throw null;
            }

            int var12;
            label104: {
               label103: {
                  try {
                     var12 = this.Ԋ;
                     if (var1 != 0) {
                        break label104;
                     }

                     if (!this.Ԋ) {
                        break label103;
                     }
                  } catch (ocbde1165e4e var6) {
                     throw var6;
                  }

                  var2 = -1620732165 ^ 1136426690;
                  if (var1 == 0) {
                     continue;
                  }
               }

               var12 = -279049688 ^ 1136426690;
            }

            var2 = var12;
            if (var1 != 0) {
               break;
            }
         }

         int var13;
         label95: {
            label94: {
               try {
                  var13 = this.ĸ.thePlayer.isSneaking();
                  if (var1 != 0) {
                     break label95;
                  }

                  if (var13 != 0) {
                     break label94;
                  }
               } catch (ocbde1165e4e var5) {
                  throw var5;
               }

               var2 = -358665831 ^ 1136426690;
               if (var1 == 0) {
                  continue;
               }
            }

            var13 = -279049688 ^ 1136426690;
         }

         var2 = var13;
      }
   }

   void ȃ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 1
      // 004: aload 0
      // 005: iload 1
      // 006: ifne 016
      // 009: invokevirtual x/oc11364ce42a.Ϭ ()Z
      // 00c: ifne 015
      // 00f: goto 013
      // 012: athrow
      // 013: return
      // 014: athrow
      // 015: aload 0
      // 016: aload 0
      // 017: iload 1
      // 018: ifne 031
      // 01b: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 01e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 021: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 024: ifeq 030
      // 027: goto 02b
      // 02a: athrow
      // 02b: bipush 0
      // 02c: goto 036
      // 02f: athrow
      // 030: aload 0
      // 031: getfield x/oc11364ce42a.µ I
      // 034: bipush 1
      // 035: iadd
      // 036: putfield x/oc11364ce42a.µ I
      // 039: aload 0
      // 03a: invokevirtual x/oc11364ce42a.Ϫ ()V
      // 03d: aload 0
      // 03e: iload 1
      // 03f: ifne 143
      // 042: getfield x/oc11364ce42a.ҷ Z
      // 045: ifeq 142
      // 048: goto 04c
      // 04b: athrow
      // 04c: aload 0
      // 04d: aload 0
      // 04e: invokevirtual x/oc11364ce42a.ƀ ()Z
      // 051: putfield x/oc11364ce42a.Љ Z
      // 054: aload 0
      // 055: iload 1
      // 056: ifne 079
      // 059: goto 05d
      // 05c: athrow
      // 05d: getfield x/oc11364ce42a.Љ Z
      // 060: ifeq 074
      // 063: goto 067
      // 066: athrow
      // 067: aload 0
      // 068: bipush 1
      // 069: putfield x/oc11364ce42a.ī I
      // 06c: iload 1
      // 06d: ifeq 0b1
      // 070: goto 074
      // 073: athrow
      // 074: aload 0
      // 075: goto 079
      // 078: athrow
      // 079: iload 1
      // 07a: ifne 0b2
      // 07d: getfield x/oc11364ce42a.ī I
      // 080: ifle 0b1
      // 083: goto 087
      // 086: athrow
      // 087: aload 0
      // 088: iload 1
      // 089: ifne 0b2
      // 08c: goto 090
      // 08f: athrow
      // 090: dup
      // 091: getfield x/oc11364ce42a.ī I
      // 094: bipush 1
      // 095: iadd
      // 096: dup_x1
      // 097: putfield x/oc11364ce42a.ī I
      // 09a: ldc_w -116272187
      // 09d: ldc_w -116272179
      // 0a0: ixor
      // 0a1: if_icmpge 0b1
      // 0a4: goto 0a8
      // 0a7: athrow
      // 0a8: aload 0
      // 0a9: bipush 1
      // 0aa: putfield x/oc11364ce42a.Љ Z
      // 0ad: goto 0b1
      // 0b0: athrow
      // 0b1: aload 0
      // 0b2: iload 1
      // 0b3: ifne 11c
      // 0b6: getfield x/oc11364ce42a.Ը I
      // 0b9: ifne 117
      // 0bc: goto 0c0
      // 0bf: athrow
      // 0c0: aload 0
      // 0c1: iload 1
      // 0c2: ifne 11c
      // 0c5: goto 0c9
      // 0c8: athrow
      // 0c9: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 0cc: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0cf: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 0d2: ifeq 117
      // 0d5: goto 0d9
      // 0d8: athrow
      // 0d9: aload 0
      // 0da: iload 1
      // 0db: ifne 109
      // 0de: goto 0e2
      // 0e1: athrow
      // 0e2: getfield x/oc11364ce42a.к I
      // 0e5: ifne 104
      // 0e8: goto 0ec
      // 0eb: athrow
      // 0ec: aload 0
      // 0ed: bipush 1
      // 0ee: putfield x/oc11364ce42a.Ը I
      // 0f1: iload 1
      // 0f2: aload 0
      // 0f3: ldc_w -116272184
      // 0f6: ldc_w -116272179
      // 0f9: ixor
      // 0fa: putfield x/oc11364ce42a.к I
      // 0fd: ifeq 142
      // 100: goto 104
      // 103: athrow
      // 104: aload 0
      // 105: goto 109
      // 108: athrow
      // 109: ldc_w -116272177
      // 10c: ldc_w -116272179
      // 10f: ixor
      // 110: putfield x/oc11364ce42a.Ը I
      // 113: iload 1
      // 114: ifeq 142
      // 117: aload 0
      // 118: goto 11c
      // 11b: athrow
      // 11c: iload 1
      // 11d: ifne 143
      // 120: getfield x/oc11364ce42a.Ը I
      // 123: bipush 1
      // 124: if_icmpne 142
      // 127: goto 12b
      // 12a: athrow
      // 12b: aload 0
      // 12c: aload 0
      // 12d: getfield x/oc11364ce42a.к I
      // 130: putfield x/oc11364ce42a.Џ I
      // 133: aload 0
      // 134: ldc_w -116272177
      // 137: ldc_w -116272179
      // 13a: ixor
      // 13b: putfield x/oc11364ce42a.Ը I
      // 13e: goto 142
      // 141: athrow
      // 142: aload 0
      // 143: iload 1
      // 144: ifne 156
      // 147: invokevirtual x/oc11364ce42a.Њ ()Z
      // 14a: ifeq 195
      // 14d: goto 151
      // 150: athrow
      // 151: aload 0
      // 152: goto 156
      // 155: athrow
      // 156: iload 1
      // 157: ifne 16f
      // 15a: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 15d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 160: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 163: ifeq 195
      // 166: goto 16a
      // 169: athrow
      // 16a: aload 0
      // 16b: goto 16f
      // 16e: athrow
      // 16f: iload 1
      // 170: ifne 18e
      // 173: getfield x/oc11364ce42a.Ϟ I
      // 176: bipush 1
      // 177: if_icmpne 18d
      // 17a: goto 17e
      // 17d: athrow
      // 17e: aload 0
      // 17f: ldc_w -116272177
      // 182: ldc_w -116272179
      // 185: ixor
      // 186: putfield x/oc11364ce42a.Ϟ I
      // 189: goto 18d
      // 18c: athrow
      // 18d: aload 0
      // 18e: aload 0
      // 18f: getfield x/oc11364ce42a.к I
      // 192: putfield x/oc11364ce42a.Џ I
      // 195: return
   }

   private void ʛ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 18
      // 09: getfield x/oc11364ce42a.ʫ Z
      // 0c: ifeq 37
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: invokevirtual x/oc11364ce42a.Ϭ ()Z
      // 1b: iload 1
      // 1c: ifne 34
      // 1f: ifeq 37
      // 22: goto 26
      // 25: athrow
      // 26: invokestatic x/ocbb165642ef.ʨ ()Lx/ocbb165642ef;
      // 29: aload 0
      // 2a: getfield x/oc11364ce42a.ϭ Lx/oc668fce0dbf;
      // 2d: invokevirtual x/ocbb165642ef.D (Ljava/lang/Object;)Z
      // 30: goto 34
      // 33: athrow
      // 34: ifne 38
      // 37: return
      // 38: aload 0
      // 39: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 3c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 3f: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 42: astore 2
      // 43: aload 0
      // 44: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 47: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 4a: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 4d: aload 0
      // 4e: invokevirtual x/oc11364ce42a.ǭ ()F
      // 51: aload 2
      // 52: getfield net/minecraft/util/MovementInput.moveForward F
      // 55: aload 2
      // 56: getfield net/minecraft/util/MovementInput.moveStrafe F
      // 59: invokestatic x/oc11364ce42a.Ά (FFFF)[F
      // 5c: astore 3
      // 5d: aload 2
      // 5e: aload 3
      // 5f: bipush 0
      // 60: faload
      // 61: putfield net/minecraft/util/MovementInput.moveForward F
      // 64: aload 2
      // 65: aload 3
      // 66: bipush 1
      // 67: faload
      // 68: putfield net/minecraft/util/MovementInput.moveStrafe F
      // 6b: return
   }

   static float[] Ά(float param0, float param1, float param2, float param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 4
      // 005: fload 2
      // 006: iload 4
      // 008: ifne 043
      // 00b: fconst_0
      // 00c: fcmpl
      // 00d: ifne 03a
      // 010: goto 014
      // 013: athrow
      // 014: fload 3
      // 015: iload 4
      // 017: ifne 043
      // 01a: goto 01e
      // 01d: athrow
      // 01e: fconst_0
      // 01f: fcmpl
      // 020: ifne 03a
      // 023: goto 027
      // 026: athrow
      // 027: ldc_w -1426755839
      // 02a: ldc_w -1426755837
      // 02d: ixor
      // 02e: newarray 6
      // 030: dup
      // 031: bipush 0
      // 032: fload 2
      // 033: fastore
      // 034: dup
      // 035: bipush 1
      // 036: fload 3
      // 037: fastore
      // 038: areturn
      // 039: athrow
      // 03a: fload 0
      // 03b: fload 2
      // 03c: fload 3
      // 03d: invokestatic x/oc11364ce42a.Ĥ (FFF)F
      // 040: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_float (F)F
      // 043: fstore 5
      // 045: fconst_0
      // 046: fstore 6
      // 048: fconst_0
      // 049: fstore 7
      // 04b: ldc_w -1.0
      // 04e: fstore 8
      // 050: ldc_w -1.0
      // 053: fstore 9
      // 055: fload 9
      // 057: fconst_1
      // 058: fcmpg
      // 059: ifgt 10a
      // 05c: iload 4
      // 05e: ifne 117
      // 061: ldc_w -1.0
      // 064: fstore 10
      // 066: fload 10
      // 068: fconst_1
      // 069: fcmpg
      // 06a: ifgt 0ff
      // 06d: iload 4
      // 06f: ifne 105
      // 072: fload 9
      // 074: iload 4
      // 076: ifne 0b2
      // 079: goto 07d
      // 07c: athrow
      // 07d: fconst_0
      // 07e: fcmpl
      // 07f: ifne 0a3
      // 082: goto 086
      // 085: athrow
      // 086: fload 10
      // 088: iload 4
      // 08a: ifne 0b2
      // 08d: goto 091
      // 090: athrow
      // 091: fconst_0
      // 092: fcmpl
      // 093: ifne 0a3
      // 096: goto 09a
      // 099: athrow
      // 09a: iload 4
      // 09c: ifeq 0f4
      // 09f: goto 0a3
      // 0a2: athrow
      // 0a3: fload 1
      // 0a4: fload 9
      // 0a6: fload 10
      // 0a8: invokestatic x/oc11364ce42a.Ĥ (FFF)F
      // 0ab: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_float (F)F
      // 0ae: goto 0b2
      // 0b1: athrow
      // 0b2: fstore 11
      // 0b4: iload 4
      // 0b6: fload 5
      // 0b8: fload 11
      // 0ba: fsub
      // 0bb: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_float (F)F
      // 0be: invokestatic java/lang/Math.abs (F)F
      // 0c1: fstore 12
      // 0c3: ifne 0f0
      // 0c6: fload 8
      // 0c8: ldc_w -1.0
      // 0cb: fcmpl
      // 0cc: ifeq 0e8
      // 0cf: goto 0d3
      // 0d2: athrow
      // 0d3: fload 12
      // 0d5: iload 4
      // 0d7: ifne 0f8
      // 0da: goto 0de
      // 0dd: athrow
      // 0de: fload 8
      // 0e0: fcmpg
      // 0e1: ifge 0f4
      // 0e4: goto 0e8
      // 0e7: athrow
      // 0e8: fload 12
      // 0ea: fstore 8
      // 0ec: fload 9
      // 0ee: fstore 6
      // 0f0: fload 10
      // 0f2: fstore 7
      // 0f4: fload 10
      // 0f6: fconst_1
      // 0f7: fadd
      // 0f8: fstore 10
      // 0fa: iload 4
      // 0fc: ifeq 066
      // 0ff: fload 9
      // 101: fconst_1
      // 102: fadd
      // 103: fstore 9
      // 105: iload 4
      // 107: ifeq 055
      // 10a: fload 2
      // 10b: invokestatic java/lang/Math.abs (F)F
      // 10e: fload 3
      // 10f: invokestatic java/lang/Math.abs (F)F
      // 112: invokestatic java/lang/Math.max (FF)F
      // 115: fstore 9
      // 117: ldc_w -1426755839
      // 11a: ldc_w -1426755837
      // 11d: ixor
      // 11e: newarray 6
      // 120: dup
      // 121: bipush 0
      // 122: fload 6
      // 124: fload 9
      // 126: fmul
      // 127: fastore
      // 128: dup
      // 129: bipush 1
      // 12a: fload 7
      // 12c: fload 9
      // 12e: fmul
      // 12f: fastore
      // 130: areturn
   }

   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static float Ĥ(float var0, float var1, float var2) {
      float var4 = 1.0F;
      int var3 = oc84f20a0bc5.ė;

      float var10000;
      label92: {
         float var10001;
         label84: {
            label93: {
               label82: {
                  label94: {
                     try {
                        var10000 = var1;
                        var10001 = 0.0F;
                        if (var3 != 0) {
                           break label82;
                        }

                        if (!(var1 < 0.0F)) {
                           break label94;
                        }
                     } catch (ocbde1165e4e var12) {
                        throw var12;
                     }

                     var0 += 180.0F;
                     int var13 = var3;
                     var4 = -0.5F;

                     try {
                        if (var13 == 0) {
                           break label93;
                        }
                     } catch (ocbde1165e4e var11) {
                        throw var11;
                     }
                  }

                  try {
                     var10000 = var1;
                     var10001 = 0.0F;
                  } catch (ocbde1165e4e var6) {
                     throw var6;
                  }
               }

               try {
                  if (var3 != 0) {
                     break label84;
                  }

                  if (!(var10000 > var10001)) {
                     break label93;
                  }
               } catch (ocbde1165e4e var10) {
                  throw var10;
               }

               var4 = 0.5F;
            }

            try {
               var10000 = var2;
               if (var3 != 0) {
                  break label92;
               }

               var10001 = 0.0F;
            } catch (ocbde1165e4e var9) {
               throw var9;
            }
         }

         if (var10000 > var10001) {
            var0 -= 90.0F * var4;

            try {
               if (var3 == 0) {
                  return var0;
               }
            } catch (ocbde1165e4e var8) {
               throw var8;
            }
         }

         try {
            var10000 = var2;
         } catch (ocbde1165e4e var5) {
            throw var5;
         }
      }

      try {
         if (var3 != 0) {
            return var10000;
         }

         if (!(var10000 < 0.0F)) {
            return var0;
         }
      } catch (ocbde1165e4e var7) {
         throw var7;
      }

      var0 += 90.0F * var4;
      return var0;
   }

   void ʗ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 1
      // 004: aload 0
      // 005: iload 1
      // 006: ifne 016
      // 009: invokevirtual x/oc11364ce42a.Ϭ ()Z
      // 00c: ifne 015
      // 00f: goto 013
      // 012: athrow
      // 013: return
      // 014: athrow
      // 015: aload 0
      // 016: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 019: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 01c: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 01f: astore 2
      // 020: aload 0
      // 021: invokevirtual x/oc11364ce42a.Ϫ ()V
      // 024: aload 0
      // 025: iload 1
      // 026: ifne 06d
      // 029: invokevirtual x/oc11364ce42a.ê ()V
      // 02c: aload 0
      // 02d: invokevirtual x/oc11364ce42a.Њ ()Z
      // 030: ifeq 06c
      // 033: goto 037
      // 036: athrow
      // 037: aload 0
      // 038: iload 1
      // 039: ifne 06d
      // 03c: goto 040
      // 03f: athrow
      // 040: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 043: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 046: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 049: ifeq 06c
      // 04c: goto 050
      // 04f: athrow
      // 050: aload 0
      // 051: iload 1
      // 052: ifne 06d
      // 055: goto 059
      // 058: athrow
      // 059: getfield x/oc11364ce42a.Ϟ I
      // 05c: ifne 06c
      // 05f: goto 063
      // 062: athrow
      // 063: aload 2
      // 064: bipush 1
      // 065: putfield net/minecraft/util/MovementInput.jump Z
      // 068: goto 06c
      // 06b: athrow
      // 06c: aload 0
      // 06d: iload 1
      // 06e: ifne 0f8
      // 071: invokevirtual x/oc11364ce42a.ū ()Z
      // 074: ifeq 0f3
      // 077: goto 07b
      // 07a: athrow
      // 07b: aload 0
      // 07c: bipush 1
      // 07d: putfield x/oc11364ce42a.ҷ Z
      // 080: aload 2
      // 081: aload 0
      // 082: getfield x/oc11364ce42a.Ը I
      // 085: iload 1
      // 086: ifne 0a0
      // 089: goto 08d
      // 08c: athrow
      // 08d: ldc_w 398610536
      // 090: ldc_w 398610538
      // 093: ixor
      // 094: if_icmpne 0a3
      // 097: goto 09b
      // 09a: athrow
      // 09b: bipush 1
      // 09c: goto 0a0
      // 09f: athrow
      // 0a0: goto 0a4
      // 0a3: bipush 0
      // 0a4: putfield net/minecraft/util/MovementInput.jump Z
      // 0a7: aload 0
      // 0a8: iload 1
      // 0a9: ifne 0c7
      // 0ac: getfield x/oc11364ce42a.Ը I
      // 0af: ldc_w 398610536
      // 0b2: ldc_w 398610538
      // 0b5: ixor
      // 0b6: if_icmpne 0c6
      // 0b9: goto 0bd
      // 0bc: athrow
      // 0bd: aload 0
      // 0be: bipush 0
      // 0bf: putfield x/oc11364ce42a.Ը I
      // 0c2: goto 0c6
      // 0c5: athrow
      // 0c6: aload 0
      // 0c7: iload 1
      // 0c8: ifne 0da
      // 0cb: getfield x/oc11364ce42a.Љ Z
      // 0ce: ifeq 119
      // 0d1: goto 0d5
      // 0d4: athrow
      // 0d5: aload 0
      // 0d6: goto 0da
      // 0d9: athrow
      // 0da: getfield x/oc11364ce42a.µ I
      // 0dd: bipush 1
      // 0de: if_icmpne 119
      // 0e1: aload 2
      // 0e2: fconst_0
      // 0e3: putfield net/minecraft/util/MovementInput.moveForward F
      // 0e6: iload 1
      // 0e7: aload 2
      // 0e8: fconst_0
      // 0e9: putfield net/minecraft/util/MovementInput.moveStrafe F
      // 0ec: ifeq 119
      // 0ef: goto 0f3
      // 0f2: athrow
      // 0f3: aload 0
      // 0f4: goto 0f8
      // 0f7: athrow
      // 0f8: iload 1
      // 0f9: ifne 115
      // 0fc: getfield x/oc11364ce42a.ҷ Z
      // 0ff: ifeq 119
      // 102: goto 106
      // 105: athrow
      // 106: aload 0
      // 107: bipush 0
      // 108: putfield x/oc11364ce42a.ҷ Z
      // 10b: aload 0
      // 10c: bipush 0
      // 10d: putfield x/oc11364ce42a.Ը I
      // 110: aload 0
      // 111: goto 115
      // 114: athrow
      // 115: bipush -1
      // 116: putfield x/oc11364ce42a.Ȩ I
      // 119: new x/ocf242f30eaa
      // 11c: dup
      // 11d: aload 2
      // 11e: getfield net/minecraft/util/MovementInput.moveForward F
      // 121: aload 2
      // 122: getfield net/minecraft/util/MovementInput.moveStrafe F
      // 125: aload 2
      // 126: getfield net/minecraft/util/MovementInput.jump Z
      // 129: invokespecial x/ocf242f30eaa.<init> (FFZ)V
      // 12c: astore 3
      // 12d: getstatic x/ocea775c9d5c.ų Lx/oc04596227b7;
      // 130: aload 3
      // 131: invokevirtual x/oc04596227b7.post (Lx/oc68d6b191af;)Z
      // 134: pop
      // 135: aload 2
      // 136: aload 3
      // 137: iload 1
      // 138: ifne 14b
      // 13b: invokevirtual x/oc68d6b191af.isCanceled ()Z
      // 13e: ifeq 14a
      // 141: goto 145
      // 144: athrow
      // 145: fconst_0
      // 146: goto 14e
      // 149: athrow
      // 14a: aload 3
      // 14b: invokevirtual x/ocf242f30eaa.Α ()F
      // 14e: putfield net/minecraft/util/MovementInput.moveForward F
      // 151: aload 2
      // 152: aload 3
      // 153: iload 1
      // 154: ifne 167
      // 157: invokevirtual x/oc68d6b191af.isCanceled ()Z
      // 15a: ifeq 166
      // 15d: goto 161
      // 160: athrow
      // 161: fconst_0
      // 162: goto 16a
      // 165: athrow
      // 166: aload 3
      // 167: invokevirtual x/ocf242f30eaa.Υ ()F
      // 16a: putfield net/minecraft/util/MovementInput.moveStrafe F
      // 16d: aload 2
      // 16e: aload 3
      // 16f: invokevirtual x/ocf242f30eaa.ǡ ()Z
      // 172: putfield net/minecraft/util/MovementInput.jump Z
      // 175: aload 0
      // 176: invokevirtual x/oc11364ce42a.ʛ ()V
      // 179: return
   }

   private void ê() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: aload 0
      // 04: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 07: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0a: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 0d: astore 2
      // 0e: istore 1
      // 0f: aload 0
      // 10: getfield x/oc11364ce42a.Ԗ I
      // 13: iload 1
      // 14: ifne 67
      // 17: bipush 1
      // 18: if_icmpne 57
      // 1b: goto 1f
      // 1e: athrow
      // 1f: aload 0
      // 20: iload 1
      // 21: ifne 4f
      // 24: goto 28
      // 27: athrow
      // 28: invokevirtual x/oc11364ce42a.ɫ ()Z
      // 2b: ifeq 4a
      // 2e: goto 32
      // 31: athrow
      // 32: aload 2
      // 33: bipush 0
      // 34: putfield net/minecraft/util/MovementInput.jump Z
      // 37: iload 1
      // 38: aload 0
      // 39: ldc_w -1421036719
      // 3c: ldc_w -1421036717
      // 3f: ixor
      // 40: putfield x/oc11364ce42a.Ԗ I
      // 43: ifeq 7f
      // 46: goto 4a
      // 49: athrow
      // 4a: aload 0
      // 4b: goto 4f
      // 4e: athrow
      // 4f: bipush 0
      // 50: putfield x/oc11364ce42a.Ԗ I
      // 53: iload 1
      // 54: ifeq 7f
      // 57: aload 0
      // 58: iload 1
      // 59: ifne 7b
      // 5c: goto 60
      // 5f: athrow
      // 60: getfield x/oc11364ce42a.Ԗ I
      // 63: goto 67
      // 66: athrow
      // 67: ldc_w -1421036719
      // 6a: ldc_w -1421036717
      // 6d: ixor
      // 6e: if_icmpne 7f
      // 71: aload 2
      // 72: bipush 1
      // 73: putfield net/minecraft/util/MovementInput.jump Z
      // 76: aload 0
      // 77: goto 7b
      // 7a: athrow
      // 7b: bipush 0
      // 7c: putfield x/oc11364ce42a.Ԗ I
      // 7f: return
   }

   @oc66fa4f2195
   public void Җ(oc52918cda9d param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 21
      // 09: invokevirtual x/oc11364ce42a.Ϭ ()Z
      // 0c: ifne 1c
      // 0f: goto 13
      // 12: athrow
      // 13: getstatic x/ocea775c9d5c.ų Lx/oc04596227b7;
      // 16: aload 0
      // 17: invokevirtual x/oc04596227b7.unregister (Ljava/lang/Object;)V
      // 1a: return
      // 1b: athrow
      // 1c: aload 0
      // 1d: invokevirtual x/oc11364ce42a.ê ()V
      // 20: aload 0
      // 21: iload 2
      // 22: ifne 34
      // 25: getfield x/oc11364ce42a.Ԗ I
      // 28: ifne 4a
      // 2b: goto 2f
      // 2e: athrow
      // 2f: aload 0
      // 30: goto 34
      // 33: athrow
      // 34: getfield x/oc11364ce42a.ǘ Ljava/util/Map;
      // 37: invokeinterface java/util/Map.isEmpty ()Z 1
      // 3c: ifeq 4a
      // 3f: getstatic x/ocea775c9d5c.ų Lx/oc04596227b7;
      // 42: aload 0
      // 43: invokevirtual x/oc04596227b7.unregister (Ljava/lang/Object;)V
      // 46: goto 4a
      // 49: athrow
      // 4a: return
   }

   @oc66fa4f2195
   public void Ƅ(oc746a23b244 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 1c
      // 09: invokevirtual x/oc11364ce42a.Ϭ ()Z
      // 0c: ifeq 1b
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: invokevirtual x/oc11364ce42a.Ȗ ()V
      // 17: goto 1b
      // 1a: athrow
      // 1b: aload 0
      // 1c: iload 2
      // 1d: ifne 2f
      // 20: getfield x/oc11364ce42a.Ԗ I
      // 23: ifne 45
      // 26: goto 2a
      // 29: athrow
      // 2a: aload 0
      // 2b: goto 2f
      // 2e: athrow
      // 2f: getfield x/oc11364ce42a.ǘ Ljava/util/Map;
      // 32: invokeinterface java/util/Map.isEmpty ()Z 1
      // 37: ifeq 45
      // 3a: getstatic x/ocea775c9d5c.ų Lx/oc04596227b7;
      // 3d: aload 0
      // 3e: invokevirtual x/oc04596227b7.unregister (Ljava/lang/Object;)V
      // 41: goto 45
      // 44: athrow
      // 45: return
   }

   @oc66fa4f2195
   public void с(ocbab3c9954b var1) {
      this.Ѥ();
   }

   private boolean ū() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: aload 0
      // 004: invokevirtual x/oc11364ce42a.ƴ ()J
      // 007: lstore 2
      // 008: istore 1
      // 009: aload 0
      // 00a: iload 1
      // 00b: ifne 020
      // 00e: getfield x/oc11364ce42a.ϭ Lx/oc668fce0dbf;
      // 011: invokevirtual x/oc668fce0dbf.Ȉ ()Z
      // 014: ifeq 15f
      // 017: goto 01b
      // 01a: athrow
      // 01b: aload 0
      // 01c: goto 020
      // 01f: athrow
      // 020: iload 1
      // 021: ifne 033
      // 024: getfield x/oc11364ce42a.ʫ Z
      // 027: ifeq 15f
      // 02a: goto 02e
      // 02d: athrow
      // 02e: aload 0
      // 02f: goto 033
      // 032: athrow
      // 033: iload 1
      // 034: ifne 049
      // 037: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 03a: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 03d: ifnonnull 15f
      // 040: goto 044
      // 043: athrow
      // 044: aload 0
      // 045: goto 049
      // 048: athrow
      // 049: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 04c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 04f: iload 1
      // 050: ifne 073
      // 053: getfield net/minecraft/client/entity/EntityPlayerSP.capabilities Lnet/minecraft/entity/player/PlayerCapabilities;
      // 056: getfield net/minecraft/entity/player/PlayerCapabilities.isFlying Z
      // 059: ifne 15f
      // 05c: goto 060
      // 05f: athrow
      // 060: aload 0
      // 061: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 064: iload 1
      // 065: ifne 081
      // 068: goto 06c
      // 06b: athrow
      // 06c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 06f: goto 073
      // 072: athrow
      // 073: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isInWater ()Z
      // 076: ifne 15f
      // 079: aload 0
      // 07a: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 07d: goto 081
      // 080: athrow
      // 081: iload 1
      // 082: ifne 0a2
      // 085: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 088: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isInLava ()Z
      // 08b: ifne 15f
      // 08e: goto 092
      // 091: athrow
      // 092: aload 0
      // 093: iload 1
      // 094: ifne 0b0
      // 097: goto 09b
      // 09a: athrow
      // 09b: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 09e: goto 0a2
      // 0a1: athrow
      // 0a2: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0a5: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 0a8: ifnull 15f
      // 0ab: aload 0
      // 0ac: goto 0b0
      // 0af: athrow
      // 0b0: iload 1
      // 0b1: ifne 0d3
      // 0b4: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 0b7: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0ba: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 0bd: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 0c0: instanceof net/minecraft/item/ItemBlock
      // 0c3: ifeq 15f
      // 0c6: goto 0ca
      // 0c9: athrow
      // 0ca: aload 0
      // 0cb: iload 1
      // 0cc: ifne 0de
      // 0cf: goto 0d3
      // 0d2: athrow
      // 0d3: invokevirtual x/oc11364ce42a.ɨ ()Z
      // 0d6: ifeq 15f
      // 0d9: aload 0
      // 0da: goto 0de
      // 0dd: athrow
      // 0de: iload 1
      // 0df: ifne 0f7
      // 0e2: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 0e5: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0e8: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isSneaking ()Z
      // 0eb: ifne 15f
      // 0ee: goto 0f2
      // 0f1: athrow
      // 0f2: aload 0
      // 0f3: goto 0f7
      // 0f6: athrow
      // 0f7: invokevirtual x/oc11364ce42a.ɫ ()Z
      // 0fa: iload 1
      // 0fb: ifne 138
      // 0fe: ifne 12b
      // 101: goto 105
      // 104: athrow
      // 105: aload 0
      // 106: iload 1
      // 107: ifne 11d
      // 10a: goto 10e
      // 10d: athrow
      // 10e: getfield x/oc11364ce42a.Ը I
      // 111: ifeq 15f
      // 114: goto 118
      // 117: athrow
      // 118: aload 0
      // 119: goto 11d
      // 11c: athrow
      // 11d: getfield x/oc11364ce42a.к I
      // 120: iload 1
      // 121: ifne 138
      // 124: ifeq 15f
      // 127: goto 12b
      // 12a: athrow
      // 12b: lload 2
      // 12c: ldc2_w -8718800676502192219
      // 12f: ldc2_w -8718800676502192587
      // 132: lxor
      // 133: lcmp
      // 134: goto 138
      // 137: athrow
      // 138: iload 1
      // 139: ifne 15c
      // 13c: iflt 15b
      // 13f: goto 143
      // 142: athrow
      // 143: lload 2
      // 144: ldc2_w -8718800676502193015
      // 147: ldc2_w -8718800676502192587
      // 14a: lxor
      // 14b: lcmp
      // 14c: iload 1
      // 14d: ifne 15c
      // 150: goto 154
      // 153: athrow
      // 154: ifle 15f
      // 157: goto 15b
      // 15a: athrow
      // 15b: bipush 1
      // 15c: goto 160
      // 15f: bipush 0
      // 160: ireturn
   }

   private void Ϫ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 2a
      // 09: getfield x/oc11364ce42a.ϭ Lx/oc668fce0dbf;
      // 0c: invokevirtual x/oc668fce0dbf.Ȉ ()Z
      // 0f: ifne 2e
      // 12: goto 16
      // 15: athrow
      // 16: aload 0
      // 17: bipush 0
      // 18: putfield x/oc11364ce42a.ҷ Z
      // 1b: aload 0
      // 1c: bipush 0
      // 1d: putfield x/oc11364ce42a.Ը I
      // 20: aload 0
      // 21: bipush 0
      // 22: putfield x/oc11364ce42a.Љ Z
      // 25: aload 0
      // 26: goto 2a
      // 29: athrow
      // 2a: bipush 0
      // 2b: putfield x/oc11364ce42a.ī I
      // 2e: return
   }

   void Ͱ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 1
      // 04: aload 0
      // 05: invokevirtual x/oc11364ce42a.Ϭ ()Z
      // 08: ifeq 2e
      // 0b: getstatic x/oc9755810e45.à Lx/ocd2c4efd8d9;
      // 0e: iload 1
      // 0f: ifne 20
      // 12: goto 16
      // 15: athrow
      // 16: ifnull 2e
      // 19: goto 1d
      // 1c: athrow
      // 1d: getstatic x/oc9755810e45.à Lx/ocd2c4efd8d9;
      // 20: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 23: iload 1
      // 24: ifne 3b
      // 27: ifne 2f
      // 2a: goto 2e
      // 2d: athrow
      // 2e: return
      // 2f: aload 0
      // 30: iload 1
      // 31: ifne 5e
      // 34: invokevirtual x/oc11364ce42a.κ ()Z
      // 37: goto 3b
      // 3a: athrow
      // 3b: ifne 68
      // 3e: aload 0
      // 3f: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 42: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 45: getfield net/minecraft/client/settings/GameSettings.keyBindSprint Lnet/minecraft/client/settings/KeyBinding;
      // 48: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // 4b: bipush 0
      // 4c: invokestatic net/minecraft/client/settings/KeyBinding.setKeyBindState (IZ)V
      // 4f: aload 0
      // 50: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 53: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 56: invokevirtual net/minecraft/client/entity/EntityPlayerSP.resetSprintToggleTimer ()V
      // 59: aload 0
      // 5a: goto 5e
      // 5d: athrow
      // 5e: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 61: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 64: bipush 0
      // 65: invokevirtual net/minecraft/client/entity/EntityPlayerSP.setSprinting (Z)V
      // 68: return
   }

   boolean κ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 1
      // 04: aload 0
      // 05: getfield x/oc11364ce42a.ʫ Z
      // 08: iload 1
      // 09: ifne 3e
      // 0c: ifeq 39
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: getfield x/oc11364ce42a.ҷ Z
      // 17: iload 1
      // 18: ifne 3e
      // 1b: goto 1f
      // 1e: athrow
      // 1f: ifne 39
      // 22: goto 26
      // 25: athrow
      // 26: aload 0
      // 27: iload 1
      // 28: ifne 40
      // 2b: goto 2f
      // 2e: athrow
      // 2f: invokevirtual x/oc11364ce42a.Ϭ ()Z
      // 32: ifne 3f
      // 35: goto 39
      // 38: athrow
      // 39: bipush 1
      // 3a: goto 3e
      // 3d: athrow
      // 3e: ireturn
      // 3f: aload 0
      // 40: iload 1
      // 41: ifne 6b
      // 44: invokevirtual x/oc11364ce42a.Њ ()Z
      // 47: ifeq 6a
      // 4a: goto 4e
      // 4d: athrow
      // 4e: aload 0
      // 4f: getfield x/oc11364ce42a.к I
      // 52: iload 1
      // 53: ifne 67
      // 56: goto 5a
      // 59: athrow
      // 5a: ifle 66
      // 5d: goto 61
      // 60: athrow
      // 61: bipush 1
      // 62: goto a6
      // 65: athrow
      // 66: bipush 0
      // 67: goto a6
      // 6a: aload 0
      // 6b: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 6e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 71: getfield net/minecraft/client/entity/EntityPlayerSP.ticksExisted I
      // 74: iload 1
      // 75: ifne a2
      // 78: aload 0
      // 79: getfield x/oc11364ce42a.p I
      // 7c: if_icmpne 9d
      // 7f: goto 83
      // 82: athrow
      // 83: aload 0
      // 84: getfield x/oc11364ce42a.Ԗ I
      // 87: iload 1
      // 88: ifne a2
      // 8b: goto 8f
      // 8e: athrow
      // 8f: ldc_w -1254088185
      // 92: ldc_w -1254088187
      // 95: ixor
      // 96: if_icmpeq a5
      // 99: goto 9d
      // 9c: athrow
      // 9d: bipush 1
      // 9e: goto a2
      // a1: athrow
      // a2: goto a6
      // a5: bipush 0
      // a6: ireturn
   }

   float ǭ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: invokestatic x/ocbb165642ef.ʨ ()Lx/ocbb165642ef;
      // 06: invokevirtual x/ocbb165642ef.ɦ ()Ljava/lang/Float;
      // 09: astore 2
      // 0a: istore 1
      // 0b: aload 2
      // 0c: iload 1
      // 0d: ifne 26
      // 10: ifnonnull 25
      // 13: goto 17
      // 16: athrow
      // 17: aload 0
      // 18: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 1b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1e: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 21: goto 29
      // 24: athrow
      // 25: aload 2
      // 26: invokevirtual java/lang/Float.floatValue ()F
      // 29: freturn
   }

   private ItemStack ϒ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: aload 0
      // 004: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 007: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 00a: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 00d: astore 2
      // 00e: istore 1
      // 00f: aload 2
      // 010: invokestatic x/oc11364ce42a.ʦ (Lnet/minecraft/item/ItemStack;)Z
      // 013: iload 1
      // 014: ifne 036
      // 017: ifeq 035
      // 01a: goto 01e
      // 01d: athrow
      // 01e: aload 2
      // 01f: getfield net/minecraft/item/ItemStack.stackSize I
      // 022: iload 1
      // 023: ifne 036
      // 026: goto 02a
      // 029: athrow
      // 02a: bipush 1
      // 02b: if_icmple 035
      // 02e: goto 032
      // 031: athrow
      // 032: aload 2
      // 033: areturn
      // 034: athrow
      // 035: bipush 0
      // 036: istore 3
      // 037: iload 3
      // 038: ldc_w 1730554660
      // 03b: ldc_w 1730554669
      // 03e: ixor
      // 03f: if_icmpge 08d
      // 042: aload 0
      // 043: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 046: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 049: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 04c: iload 3
      // 04d: invokevirtual net/minecraft/entity/player/InventoryPlayer.getStackInSlot (I)Lnet/minecraft/item/ItemStack;
      // 050: astore 4
      // 052: iload 1
      // 053: ifne 08f
      // 056: iload 1
      // 057: ifne 089
      // 05a: goto 05e
      // 05d: athrow
      // 05e: aload 4
      // 060: ifnull 086
      // 063: goto 067
      // 066: athrow
      // 067: aload 4
      // 069: getfield net/minecraft/item/ItemStack.stackSize I
      // 06c: ifgt 086
      // 06f: goto 073
      // 072: athrow
      // 073: aload 0
      // 074: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 077: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 07a: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 07d: iload 3
      // 07e: aconst_null
      // 07f: invokevirtual net/minecraft/entity/player/InventoryPlayer.setInventorySlotContents (ILnet/minecraft/item/ItemStack;)V
      // 082: goto 086
      // 085: athrow
      // 086: iinc 3 1
      // 089: iload 1
      // 08a: ifeq 037
      // 08d: bipush -1
      // 08e: istore 3
      // 08f: bipush -1
      // 090: istore 4
      // 092: ldc_w 1730554661
      // 095: ldc_w 1730554669
      // 098: ixor
      // 099: istore 5
      // 09b: iload 5
      // 09d: iflt 140
      // 0a0: aload 0
      // 0a1: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 0a4: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0a7: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 0aa: iload 5
      // 0ac: invokevirtual net/minecraft/entity/player/InventoryPlayer.getStackInSlot (I)Lnet/minecraft/item/ItemStack;
      // 0af: astore 6
      // 0b1: iload 1
      // 0b2: ifne 13c
      // 0b5: iload 1
      // 0b6: ifne 158
      // 0b9: goto 0bd
      // 0bc: athrow
      // 0bd: iload 5
      // 0bf: aload 0
      // 0c0: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 0c3: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0c6: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 0c9: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 0cc: if_icmpeq 139
      // 0cf: goto 0d3
      // 0d2: athrow
      // 0d3: aload 6
      // 0d5: iload 1
      // 0d6: ifne 0ed
      // 0d9: goto 0dd
      // 0dc: athrow
      // 0dd: invokestatic x/oc11364ce42a.ʦ (Lnet/minecraft/item/ItemStack;)Z
      // 0e0: ifeq 139
      // 0e3: goto 0e7
      // 0e6: athrow
      // 0e7: aload 6
      // 0e9: goto 0ed
      // 0ec: athrow
      // 0ed: iload 1
      // 0ee: ifne 105
      // 0f1: getfield net/minecraft/item/ItemStack.stackSize I
      // 0f4: iload 3
      // 0f5: if_icmple 139
      // 0f8: goto 0fc
      // 0fb: athrow
      // 0fc: aload 2
      // 0fd: iload 1
      // 0fe: ifne 131
      // 101: goto 105
      // 104: athrow
      // 105: invokestatic x/oc11364ce42a.ʦ (Lnet/minecraft/item/ItemStack;)Z
      // 108: ifeq 12b
      // 10b: aload 6
      // 10d: iload 1
      // 10e: ifne 131
      // 111: goto 115
      // 114: athrow
      // 115: getfield net/minecraft/item/ItemStack.stackSize I
      // 118: aload 2
      // 119: getfield net/minecraft/item/ItemStack.stackSize I
      // 11c: if_icmpgt 12b
      // 11f: goto 123
      // 122: athrow
      // 123: iload 1
      // 124: ifeq 139
      // 127: goto 12b
      // 12a: athrow
      // 12b: aload 6
      // 12d: goto 131
      // 130: athrow
      // 131: getfield net/minecraft/item/ItemStack.stackSize I
      // 134: istore 3
      // 135: iload 5
      // 137: istore 4
      // 139: iinc 5 -1
      // 13c: iload 1
      // 13d: ifeq 09b
      // 140: iload 4
      // 142: iflt 158
      // 145: aload 0
      // 146: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 149: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 14c: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 14f: iload 4
      // 151: putfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 154: goto 158
      // 157: athrow
      // 158: aload 0
      // 159: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 15c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 15f: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 162: areturn
   }

   static boolean ʦ(ItemStack param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 1
      // 004: aload 0
      // 005: iload 1
      // 006: ifne 011
      // 009: ifnull 022
      // 00c: goto 010
      // 00f: athrow
      // 010: aload 0
      // 011: iload 1
      // 012: ifne 026
      // 015: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 018: instanceof net/minecraft/item/ItemBlock
      // 01b: ifne 025
      // 01e: goto 022
      // 021: athrow
      // 022: bipush 0
      // 023: ireturn
      // 024: athrow
      // 025: aload 0
      // 026: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 029: checkcast net/minecraft/item/ItemBlock
      // 02c: invokevirtual net/minecraft/item/ItemBlock.getBlock ()Lnet/minecraft/block/Block;
      // 02f: astore 2
      // 030: aload 2
      // 031: iload 1
      // 032: ifne 057
      // 035: getstatic net/minecraft/init/Blocks.glass Lnet/minecraft/block/Block;
      // 038: if_acmpeq 052
      // 03b: goto 03f
      // 03e: athrow
      // 03f: aload 2
      // 040: iload 1
      // 041: ifne 057
      // 044: goto 048
      // 047: athrow
      // 048: invokevirtual net/minecraft/block/Block.isFullBlock ()Z
      // 04b: ifeq 120
      // 04e: goto 052
      // 051: athrow
      // 052: aload 2
      // 053: goto 057
      // 056: athrow
      // 057: iload 1
      // 058: ifne 06a
      // 05b: getstatic net/minecraft/init/Blocks.gravel Lnet/minecraft/block/Block;
      // 05e: if_acmpeq 120
      // 061: goto 065
      // 064: athrow
      // 065: aload 2
      // 066: goto 06a
      // 069: athrow
      // 06a: iload 1
      // 06b: ifne 07d
      // 06e: getstatic net/minecraft/init/Blocks.sand Lnet/minecraft/block/BlockSand;
      // 071: if_acmpeq 120
      // 074: goto 078
      // 077: athrow
      // 078: aload 2
      // 079: goto 07d
      // 07c: athrow
      // 07d: iload 1
      // 07e: ifne 090
      // 081: getstatic net/minecraft/init/Blocks.soul_sand Lnet/minecraft/block/Block;
      // 084: if_acmpeq 120
      // 087: goto 08b
      // 08a: athrow
      // 08b: aload 2
      // 08c: goto 090
      // 08f: athrow
      // 090: iload 1
      // 091: ifne 0a3
      // 094: getstatic net/minecraft/init/Blocks.tnt Lnet/minecraft/block/Block;
      // 097: if_acmpeq 120
      // 09a: goto 09e
      // 09d: athrow
      // 09e: aload 2
      // 09f: goto 0a3
      // 0a2: athrow
      // 0a3: iload 1
      // 0a4: ifne 0b6
      // 0a7: getstatic net/minecraft/init/Blocks.crafting_table Lnet/minecraft/block/Block;
      // 0aa: if_acmpeq 120
      // 0ad: goto 0b1
      // 0b0: athrow
      // 0b1: aload 2
      // 0b2: goto 0b6
      // 0b5: athrow
      // 0b6: iload 1
      // 0b7: ifne 0c9
      // 0ba: getstatic net/minecraft/init/Blocks.furnace Lnet/minecraft/block/Block;
      // 0bd: if_acmpeq 120
      // 0c0: goto 0c4
      // 0c3: athrow
      // 0c4: aload 2
      // 0c5: goto 0c9
      // 0c8: athrow
      // 0c9: iload 1
      // 0ca: ifne 0dc
      // 0cd: getstatic net/minecraft/init/Blocks.dispenser Lnet/minecraft/block/Block;
      // 0d0: if_acmpeq 120
      // 0d3: goto 0d7
      // 0d6: athrow
      // 0d7: aload 2
      // 0d8: goto 0dc
      // 0db: athrow
      // 0dc: iload 1
      // 0dd: ifne 0ef
      // 0e0: getstatic net/minecraft/init/Blocks.dropper Lnet/minecraft/block/Block;
      // 0e3: if_acmpeq 120
      // 0e6: goto 0ea
      // 0e9: athrow
      // 0ea: aload 2
      // 0eb: goto 0ef
      // 0ee: athrow
      // 0ef: iload 1
      // 0f0: ifne 102
      // 0f3: getstatic net/minecraft/init/Blocks.noteblock Lnet/minecraft/block/Block;
      // 0f6: if_acmpeq 120
      // 0f9: goto 0fd
      // 0fc: athrow
      // 0fd: aload 2
      // 0fe: goto 102
      // 101: athrow
      // 102: iload 1
      // 103: ifne 115
      // 106: getstatic net/minecraft/init/Blocks.command_block Lnet/minecraft/block/Block;
      // 109: if_acmpeq 120
      // 10c: goto 110
      // 10f: athrow
      // 110: aload 2
      // 111: goto 115
      // 114: athrow
      // 115: getstatic net/minecraft/init/Blocks.pumpkin Lnet/minecraft/block/Block;
      // 118: if_acmpeq 120
      // 11b: bipush 1
      // 11c: goto 121
      // 11f: athrow
      // 120: bipush 0
      // 121: ireturn
   }

   private static boolean Ȝ(Block var0) {
      int var1 = oc84f20a0bc5.ė;
      int var2 = 593221506 ^ -777844916;

      while (true) {
         label171:
         while (true) {
            label169:
            while (true) {
               label167:
               while (true) {
                  label163:
                  while (true) {
                     switch (var2) {
                        case -825178064:
                           break label169;
                        case -154291615:
                           break;
                        case -38763914:
                           break label163;
                        case 238716498:
                           int var9;
                           label124: {
                              label123: {
                                 try {
                                    var9 = var0 instanceof BlockTrapDoor;
                                    if (var1 != 0) {
                                       break label124;
                                    }

                                    if (var9 != 0) {
                                       break label123;
                                    }
                                 } catch (ocbde1165e4e var5) {
                                    throw var5;
                                 }

                                 var2 = -73409175 ^ -777844916;
                                 if (var1 == 0) {
                                    continue;
                                 }
                              }

                              var9 = -2077251314 ^ -777844916;
                           }

                           var2 = var9;
                           if (var1 != 0) {
                              break label171;
                           }
                           continue;
                        case 243121153:
                           break label167;
                        case 691693705:
                           break label171;
                        case 708631077:
                           int var8;
                           label102: {
                              label101: {
                                 try {
                                    var8 = var0 instanceof BlockFence;
                                    if (var1 != 0) {
                                       break label102;
                                    }

                                    if (var8 != 0) {
                                       break label101;
                                    }
                                 } catch (ocbde1165e4e var3) {
                                    throw var3;
                                 }

                                 var2 = 661566765 ^ -777844916;
                                 if (var1 == 0) {
                                    continue;
                                 }
                              }

                              var8 = -2077251314 ^ -777844916;
                           }

                           var2 = var8;
                           continue;
                        case 813561292:
                           if (var0 != Blocks.bed) {
                              var2 = -539051187 ^ -777844916;
                              if (var1 == 0) {
                                 continue;
                              }
                           }

                           var2 = -2077251314 ^ -777844916;
                           if (var1 == 0) {
                              continue;
                           }
                        case -218574642:
                           int var10000;
                           label148: {
                              label147: {
                                 try {
                                    var10000 = var0 instanceof BlockContainer;
                                    if (var1 != 0) {
                                       break label148;
                                    }

                                    if (var10000 != 0) {
                                       break label147;
                                    }
                                 } catch (ocbde1165e4e var7) {
                                    throw var7;
                                 }

                                 var2 = -453479443 ^ -777844916;
                                 if (var1 == 0) {
                                    continue;
                                 }
                              }

                              var10000 = -2077251314 ^ -777844916;
                           }

                           var2 = var10000;
                           if (var1 == 0) {
                              continue;
                           }
                        case 895186081:
                           if (var0 != Blocks.crafting_table) {
                              var2 = -124162107 ^ -777844916;
                              if (var1 == 0) {
                                 continue;
                              }
                           }

                           var2 = -2077251314 ^ -777844916;
                           if (var1 == 0) {
                              continue;
                           }
                           break;
                        case 1435283010:
                           return true;
                        case 1995721035:
                           return false;
                        default:
                           throw null;
                     }

                     int var10;
                     label137: {
                        label136: {
                           try {
                              var10 = var0 instanceof BlockFenceGate;
                              if (var1 != 0) {
                                 break label137;
                              }

                              if (var10 != 0) {
                                 break label136;
                              }
                           } catch (ocbde1165e4e var6) {
                              throw var6;
                           }

                           var2 = 527683452 ^ -777844916;
                           if (var1 == 0) {
                              continue;
                           }
                        }

                        var10 = -2077251314 ^ -777844916;
                     }

                     var2 = var10;
                     if (var1 != 0) {
                        break;
                     }
                  }

                  if (var0 != Blocks.iron_door) {
                     var2 = -2077251314 ^ -777844916;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var2 = -1487450617 ^ -777844916;
                  if (var1 != 0) {
                     break;
                  }
               }

               if (var0 != Blocks.lever) {
                  var2 = -543588066 ^ -777844916;
                  if (var1 == 0) {
                     continue;
                  }
               }

               var2 = -2077251314 ^ -777844916;
               if (var1 != 0) {
                  break;
               }
            }

            int var11;
            label111: {
               label110: {
                  try {
                     var11 = var0 instanceof BlockDoor;
                     if (var1 != 0) {
                        break label111;
                     }

                     if (var11 == 0) {
                        break label110;
                     }
                  } catch (ocbde1165e4e var4) {
                     throw var4;
                  }

                  var2 = 739476794 ^ -777844916;
                  if (var1 == 0) {
                     continue;
                  }
               }

               var11 = -1487450617 ^ -777844916;
            }

            var2 = var11;
            if (var1 != 0) {
               return false;
            }
         }

         if (var0 != Blocks.anvil) {
            var2 = -505482624 ^ -777844916;
            if (var1 == 0) {
               continue;
            }
         }

         var2 = -2077251314 ^ -777844916;
         if (var1 != 0) {
            return true;
         }
      }
   }

   private boolean Ց(BlockPos var1) {
      Block var3 = null;
      int var4 = -385384386 ^ -746022762;
      int var2 = oc84f20a0bc5.ė;

      while (true) {
         switch (var4) {
            case -1861657116:
               if (var3 != Blocks.fire) {
                  var4 = -1133607880 ^ -746022762;
                  if (var2 == 0) {
                     continue;
                  }
               }

               var4 = 467801057 ^ -746022762;
               if (var2 == 0) {
                  continue;
               }
               break;
            case -932541577:
               return true;
            case 571042065:
               break;
            case 1653445512:
               return false;
            case 1877351598:
               int var10000;
               label78: {
                  label77: {
                     try {
                        var10000 = var3 instanceof BlockLiquid;
                        if (var2 != 0) {
                           break label78;
                        }

                        if (var10000 != 0) {
                           break label77;
                        }
                     } catch (ocbde1165e4e var7) {
                        throw var7;
                     }

                     var4 = -243142265 ^ -746022762;
                     if (var2 == 0) {
                        continue;
                     }
                  }

                  var10000 = 467801057 ^ -746022762;
               }

               var4 = var10000;
               if (var2 == 0) {
                  continue;
               }
            case 982456488:
               var3 = this.ĸ.theWorld.getBlockState(var1).getBlock();

               label55: {
                  label54: {
                     try {
                        if (var2 != 0) {
                           break label55;
                        }

                        if (var3 == Blocks.air) {
                           break label54;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var4 = 1115800946 ^ -746022762;
                     if (var2 == 0) {
                        continue;
                     }
                  }

                  var4 = 467801057 ^ -746022762;
               }

               if (var2 == 0) {
                  continue;
               }

               return false;
            default:
               throw null;
         }

         int var8;
         label65: {
            label64: {
               try {
                  var8 = var3.getMaterial().isReplaceable();
                  if (var2 != 0) {
                     break label65;
                  }

                  if (var8 == 0) {
                     break label64;
                  }
               } catch (ocbde1165e4e var6) {
                  throw var6;
               }

               var4 = 467801057 ^ -746022762;
               if (var2 == 0) {
                  continue;
               }
            }

            var8 = -1325069538 ^ -746022762;
         }

         var4 = var8;
      }
   }

   private boolean Ѧ(double var1) {
      int var4 = 0;
      int var5 = 0;
      int var6 = 0;
      double var7 = 0.0;
      int var3 = oc84f20a0bc5.ė;
      double var9 = 0.0;
      int var11 = 442135071 ^ 944123012;

      while (true) {
         label201:
         while (true) {
            label199:
            while (true) {
               switch (var11) {
                  case -1138962273:
                     int var27;
                     label128: {
                        label127: {
                           try {
                              double var30;
                              var27 = (var30 = var7 - (1.0 - var1)) == 0.0 ? 0 : (var30 < 0.0 ? -1 : 1);
                              if (var3 != 0) {
                                 break label128;
                              }

                              if (var27 <= 0) {
                                 break label127;
                              }
                           } catch (ocbde1165e4e var14) {
                              throw var14;
                           }

                           var11 = 1118737854 ^ 944123012;
                           if (var3 == 0) {
                              continue;
                           }
                        }

                        var27 = -132368255 ^ 944123012;
                     }

                     var11 = var27;
                     if (var3 != 0) {
                        return false;
                     }
                     continue;
                  case -1067838459:
                     break label199;
                  case -809393476:
                     return true;
                  case 57030029:
                     break label201;
                  case 572284571:
                     var4 = MathHelper.floor_double(this.ĸ.thePlayer.posX);
                     int var21 = MathHelper.floor_double(this.ĸ.thePlayer.posY - 0.01);
                     if (var3 == 0) {
                        var5 = var21;
                        var6 = MathHelper.floor_double(this.ĸ.thePlayer.posZ);
                        if (this.ĸ.theWorld.isAirBlock(new BlockPos(var4, var5, var6))) {
                           var11 = 1321703933 ^ 944123012;
                           if (var3 == 0) {
                              continue;
                           }
                        }

                        var21 = 1357689353 ^ 944123012;
                     }

                     var11 = var21;
                     if (var3 == 0) {
                        continue;
                     }
                  case -766121654:
                     int var22;
                     label184: {
                        label183: {
                           try {
                              var22 = this.ĸ.theWorld.isAirBlock(new BlockPos(var4, var5, var6 + 1));
                              if (var3 != 0) {
                                 break label184;
                              }

                              if (var22 == 0) {
                                 break label183;
                              }
                           } catch (ocbde1165e4e var19) {
                              throw var19;
                           }

                           var11 = -142111176 ^ 944123012;
                           if (var3 == 0) {
                              continue;
                           }
                        }

                        var22 = 1549358058 ^ 944123012;
                     }

                     var11 = var22;
                     if (var3 == 0) {
                        continue;
                     }
                  case -1971299947:
                     int var23;
                     label174: {
                        label173: {
                           try {
                              double var28;
                              var23 = (var28 = var9 - (1.0 - var1)) == 0.0 ? 0 : (var28 < 0.0 ? -1 : 1);
                              if (var3 != 0) {
                                 break label174;
                              }

                              if (var23 <= 0) {
                                 break label173;
                              }
                           } catch (ocbde1165e4e var18) {
                              throw var18;
                           }

                           var11 = -367802930 ^ 944123012;
                           if (var3 == 0) {
                              continue;
                           }
                        }

                        var23 = 1549358058 ^ 944123012;
                     }

                     var11 = var23;
                     if (var3 == 0) {
                        continue;
                     }
                     break;
                  case 1625162568:
                     int var20;
                     label110: {
                        label109: {
                           try {
                              var20 = this.ĸ.theWorld.isAirBlock(new BlockPos(var4 - 1, var5, var6));
                              if (var3 != 0) {
                                 break label110;
                              }

                              if (var20 != 0) {
                                 break label109;
                              }
                           } catch (ocbde1165e4e var12) {
                              throw var12;
                           }

                           var11 = -2074412005 ^ 944123012;
                           if (var3 == 0) {
                              continue;
                           }
                        }

                        var20 = -142111176 ^ 944123012;
                     }

                     var11 = var20;
                     continue;
                  case 1679785838:
                     return false;
                  case 1756012173:
                     break;
                  case 1988212089:
                     return true;
                  case 2062072122:
                     int var10000;
                     label119: {
                        label118: {
                           try {
                              var10000 = this.ĸ.theWorld.isAirBlock(new BlockPos(var4 + 1, var5, var6));
                              if (var3 != 0) {
                                 break label119;
                              }

                              if (var10000 != 0) {
                                 break label118;
                              }
                           } catch (ocbde1165e4e var13) {
                              throw var13;
                           }

                           var11 = -132368255 ^ 944123012;
                           if (var3 == 0) {
                              continue;
                           }
                        }

                        var10000 = -142111176 ^ 944123012;
                     }

                     var11 = var10000;
                     if (var3 != 0) {
                        return true;
                     }
                     continue;
                  default:
                     throw null;
               }

               var7 = this.ĸ.thePlayer.posX - var4;
               int var24 = var3;
               var9 = this.ĸ.thePlayer.posZ - var6;

               label163: {
                  label162: {
                     try {
                        if (var24 != 0) {
                           break label163;
                        }

                        if (!(var7 < var1)) {
                           break label162;
                        }
                     } catch (ocbde1165e4e var17) {
                        throw var17;
                     }

                     var11 = 1486368716 ^ 944123012;
                     if (var3 == 0) {
                        continue;
                     }
                  }

                  var11 = -2074412005 ^ 944123012;
               }

               if (var3 != 0) {
                  break;
               }
            }

            int var25;
            label151: {
               label150: {
                  try {
                     double var29;
                     var25 = (var29 = var9 - var1) == 0.0 ? 0 : (var29 < 0.0 ? -1 : 1);
                     if (var3 != 0) {
                        break label151;
                     }

                     if (var25 >= 0) {
                        break label150;
                     }
                  } catch (ocbde1165e4e var16) {
                     throw var16;
                  }

                  var11 = 991959305 ^ 944123012;
                  if (var3 == 0) {
                     continue;
                  }
               }

               var25 = -1295616751 ^ 944123012;
            }

            var11 = var25;
            if (var3 != 0) {
               break;
            }
         }

         int var26;
         label137: {
            label136: {
               try {
                  var26 = this.ĸ.theWorld.isAirBlock(new BlockPos(var4, var5, var6 - 1));
                  if (var3 != 0) {
                     break label137;
                  }

                  if (var26 != 0) {
                     break label136;
                  }
               } catch (ocbde1165e4e var15) {
                  throw var15;
               }

               var11 = -1295616751 ^ 944123012;
               if (var3 == 0) {
                  continue;
               }
            }

            var26 = -142111176 ^ 944123012;
         }

         var11 = var26;
         if (var3 != 0) {
            return true;
         }
      }
   }

   private float Ħ() {
      float var10000;
      label28: {
         try {
            if (this.ĸ.gameSettings.keyBindForward.isKeyDown()) {
               var10000 = 1.0F;
               break label28;
            }
         } catch (ocbde1165e4e var2) {
            throw var2;
         }

         var10000 = 0.0F;
      }

      try {
         if (this.ĸ.gameSettings.keyBindBack.isKeyDown()) {
            return var10000 - 1.0F;
         }
      } catch (ocbde1165e4e var1) {
         throw var1;
      }

      return var10000 - 0.0F;
   }

   private float ȉ() {
      float var10000;
      label28: {
         try {
            if (this.ĸ.gameSettings.keyBindLeft.isKeyDown()) {
               var10000 = 1.0F;
               break label28;
            }
         } catch (ocbde1165e4e var2) {
            throw var2;
         }

         var10000 = 0.0F;
      }

      try {
         if (this.ĸ.gameSettings.keyBindRight.isKeyDown()) {
            return var10000 - 1.0F;
         }
      } catch (ocbde1165e4e var1) {
         throw var1;
      }

      return var10000 - 0.0F;
   }

   private boolean ɨ() {
      int var1 = oc84f20a0bc5.ė;
      int var2 = -450704872 ^ -1257342647;

      while (true) {
         switch (var2) {
            case 1345106769:
               int var5;
               label37: {
                  label36: {
                     try {
                        float var6;
                        var5 = (var6 = this.ĸ.thePlayer.movementInput.moveForward - 0.0F) == 0.0F ? 0 : (var6 < 0.0F ? -1 : 1);
                        if (var1 != 0) {
                           break label37;
                        }

                        if (var5 != 0) {
                           break label36;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = -796640672 ^ -1257342647;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var5 = 189294726 ^ -1257342647;
               }

               var2 = var5;
               break;
            case 1703559977:
               int var10000;
               label46: {
                  label45: {
                     try {
                        float var7;
                        var10000 = (var7 = this.ĸ.thePlayer.movementInput.moveStrafe - 0.0F) == 0.0F ? 0 : (var7 < 0.0F ? -1 : 1);
                        if (var1 != 0) {
                           break label46;
                        }

                        if (var10000 == 0) {
                           break label45;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var2 = 189294726 ^ -1257342647;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = -927320297 ^ -1257342647;
               }

               var2 = var10000;
               if (var1 == 0) {
                  break;
               }
            case -1102704177:
               return true;
            case 2108968542:
               return false;
            default:
               throw null;
         }
      }
   }

   private boolean ƀ() {
      float var2 = 0.0F;
      int var3 = -1317336466 ^ -2146476439;
      int var1 = oc84f20a0bc5.ė;

      while (true) {
         switch (var3) {
            case -1962420068:
               return true;
            case -1173273187:
               return false;
            case -1144936433:
               int var9;
               label76: {
                  label75: {
                     try {
                        float var11;
                        var9 = (var11 = this.ȉ() - 0.0F) == 0.0F ? 0 : (var11 < 0.0F ? -1 : 1);
                        if (var1 != 0) {
                           break label76;
                        }

                        if (var9 == 0) {
                           break label75;
                        }
                     } catch (ocbde1165e4e var6) {
                        throw var6;
                     }

                     var3 = 185108213 ^ -2146476439;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var9 = 975051764 ^ -2146476439;
               }

               var3 = var9;
               if (var1 == 0) {
                  break;
               }

               return true;
            case 829707271:
               var2 = Math.abs(this.ĸ.thePlayer.rotationYaw % 90.0F);

               label89: {
                  label88: {
                     try {
                        if (var1 != 0) {
                           break label89;
                        }

                        if (!(var2 > 10.0F)) {
                           break label88;
                        }
                     } catch (ocbde1165e4e var7) {
                        throw var7;
                     }

                     var3 = -477633560 ^ -2146476439;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var3 = -1281102436 ^ -2146476439;
               }

               if (var1 == 0) {
                  break;
               }
            case 866956277:
               int var8;
               label67: {
                  label66: {
                     try {
                        float var10;
                        var8 = (var10 = this.Ħ() - 0.0F) == 0.0F ? 0 : (var10 < 0.0F ? -1 : 1);
                        if (var1 != 0) {
                           break label67;
                        }

                        if (var8 == 0) {
                           break label66;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var3 = 1003419238 ^ -2146476439;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var8 = 975051764 ^ -2146476439;
               }

               var3 = var8;
               if (var1 == 0) {
                  break;
               }

               return false;
            case 1669905793:
               int var10000;
               label58: {
                  label57: {
                     try {
                        float var12;
                        var10000 = (var12 = var2 - 80.0F) == 0.0F ? 0 : (var12 < 0.0F ? -1 : 1);
                        if (var1 != 0) {
                           break label58;
                        }

                        if (var10000 < 0) {
                           break label57;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var3 = -1281102436 ^ -2146476439;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = 185108213 ^ -2146476439;
               }

               var3 = var10000;
               break;
            default:
               throw null;
         }
      }
   }

   private boolean ɫ() {
      return GameSettings.isKeyDown(this.ĸ.gameSettings.keyBindJump);
   }

   private boolean Ϭ() {
      int var1 = oc84f20a0bc5.ė;
      int var2 = 1742881345 ^ 296533031;

      while (true) {
         switch (var2) {
            case 405155540:
               if (this.ĸ.theWorld != null) {
                  var2 = 2050899553 ^ 296533031;
                  if (var1 == 0) {
                     break;
                  }
               }

               var2 = 2036724351 ^ 296533031;
               if (var1 == 0) {
                  break;
               }
            case 1758023256:
               return false;
            case 1804763718:
               return true;
            case 1984888422:
               if (this.ĸ.thePlayer != null) {
                  var2 = 160076531 ^ 296533031;
                  if (var1 == 0) {
                     break;
                  }
               }

               var2 = 2036724351 ^ 296533031;
               break;
            default:
               throw null;
         }
      }
   }

   private float Ǐ() {
      double var1 = Math.toDegrees(Math.atan2(this.ȉ(), -this.Ħ()));
      return this.ĸ.thePlayer.rotationYaw + (float)((var1 + 360.0) % 360.0);
   }

   private long ƴ() {
      return Math.abs(System.currentTimeMillis() - this.ơ);
   }

   private void Α() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne a9
      // 09: getfield x/oc11364ce42a.ʫ Z
      // 0c: ifeq 8a
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: iload 1
      // 15: ifne 6f
      // 18: goto 1c
      // 1b: athrow
      // 1c: invokestatic java/lang/System.currentTimeMillis ()J
      // 1f: putfield x/oc11364ce42a.ɐ J
      // 22: aload 0
      // 23: invokevirtual x/oc11364ce42a.Ϭ ()Z
      // 26: ifeq 6e
      // 29: goto 2d
      // 2c: athrow
      // 2d: aload 0
      // 2e: iload 1
      // 2f: ifne 6f
      // 32: goto 36
      // 35: athrow
      // 36: invokevirtual x/oc11364ce42a.Ѻ ()Z
      // 39: ifne 6e
      // 3c: goto 40
      // 3f: athrow
      // 40: aload 0
      // 41: iload 1
      // 42: ifne 6f
      // 45: goto 49
      // 48: athrow
      // 49: getfield x/oc11364ce42a.ǭ I
      // 4c: bipush -1
      // 4d: if_icmpeq 6e
      // 50: goto 54
      // 53: athrow
      // 54: aload 0
      // 55: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 58: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 5b: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 5e: aload 0
      // 5f: getfield x/oc11364ce42a.ǭ I
      // 62: putfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 65: aload 0
      // 66: bipush -1
      // 67: putfield x/oc11364ce42a.ǭ I
      // 6a: goto 6e
      // 6d: athrow
      // 6e: aload 0
      // 6f: iload 1
      // 70: ifne 86
      // 73: getfield x/oc11364ce42a.ß Z
      // 76: ifeq 85
      // 79: goto 7d
      // 7c: athrow
      // 7d: aload 0
      // 7e: invokevirtual x/oc11364ce42a.Y ()V
      // 81: goto 85
      // 84: athrow
      // 85: aload 0
      // 86: bipush 1
      // 87: putfield x/oc11364ce42a.Ԗ I
      // 8a: aload 0
      // 8b: bipush 0
      // 8c: putfield x/oc11364ce42a.ʫ Z
      // 8f: aload 0
      // 90: bipush 0
      // 91: putfield x/oc11364ce42a.ҷ Z
      // 94: aload 0
      // 95: bipush 0
      // 96: putfield x/oc11364ce42a.Ը I
      // 99: aload 0
      // 9a: bipush 0
      // 9b: putfield x/oc11364ce42a.ī I
      // 9e: aload 0
      // 9f: bipush -1
      // a0: putfield x/oc11364ce42a.Ȩ I
      // a3: aload 0
      // a4: aconst_null
      // a5: putfield x/oc11364ce42a.ŭ Lnet/minecraft/util/BlockPos;
      // a8: aload 0
      // a9: ldc 100.0
      // ab: putfield x/oc11364ce42a.ϵ F
      // ae: return
   }

   void У(Packet<?> param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 50
      // 09: instanceof net/minecraft/network/play/client/C03PacketPlayer
      // 0c: ifeq 4b
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: bipush 0
      // 15: putfield x/oc11364ce42a.ћ Z
      // 18: iload 2
      // 19: aload 0
      // 1a: bipush 0
      // 1b: putfield x/oc11364ce42a.ϳ Z
      // 1e: aload 0
      // 1f: bipush 0
      // 20: putfield x/oc11364ce42a.Ŗ Z
      // 23: ifne 47
      // 26: goto 2a
      // 29: athrow
      // 2a: aload 0
      // 2b: invokevirtual x/oc11364ce42a.Ϭ ()Z
      // 2e: ifeq 9f
      // 31: goto 35
      // 34: athrow
      // 35: aload 0
      // 36: aload 0
      // 37: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 3a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 3d: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 40: putfield x/oc11364ce42a.ƴ F
      // 43: goto 47
      // 46: athrow
      // 47: iload 2
      // 48: ifeq 9f
      // 4b: aload 1
      // 4c: goto 50
      // 4f: athrow
      // 50: iload 2
      // 51: ifne 70
      // 54: instanceof net/minecraft/network/play/client/C02PacketUseEntity
      // 57: ifeq 6b
      // 5a: goto 5e
      // 5d: athrow
      // 5e: aload 0
      // 5f: bipush 1
      // 60: putfield x/oc11364ce42a.ϳ Z
      // 63: iload 2
      // 64: ifeq 9f
      // 67: goto 6b
      // 6a: athrow
      // 6b: aload 1
      // 6c: goto 70
      // 6f: athrow
      // 70: iload 2
      // 71: ifne 90
      // 74: instanceof net/minecraft/network/play/client/C07PacketPlayerDigging
      // 77: ifeq 8b
      // 7a: goto 7e
      // 7d: athrow
      // 7e: aload 0
      // 7f: bipush 1
      // 80: putfield x/oc11364ce42a.Ŗ Z
      // 83: iload 2
      // 84: ifeq 9f
      // 87: goto 8b
      // 8a: athrow
      // 8b: aload 1
      // 8c: goto 90
      // 8f: athrow
      // 90: instanceof net/minecraft/network/play/client/C0DPacketCloseWindow
      // 93: ifeq 9f
      // 96: aload 0
      // 97: bipush 1
      // 98: putfield x/oc11364ce42a.ћ Z
      // 9b: goto 9f
      // 9e: athrow
      // 9f: return
   }

   boolean ю() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 1
      // 04: aload 0
      // 05: invokevirtual x/oc11364ce42a.Ϭ ()Z
      // 08: iload 1
      // 09: ifne 27
      // 0c: ifeq 26
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: invokevirtual x/oc11364ce42a.Υ ()I
      // 17: iload 1
      // 18: ifne 34
      // 1b: goto 1f
      // 1e: athrow
      // 1f: ifne 28
      // 22: goto 26
      // 25: athrow
      // 26: bipush 1
      // 27: ireturn
      // 28: bipush 0
      // 29: iload 1
      // 2a: ifne 47
      // 2d: invokestatic x/ocdd342096f8.բ (Z)Z
      // 30: goto 34
      // 33: athrow
      // 34: ifeq 46
      // 37: aload 0
      // 38: ldc_w -1253672045
      // 3b: ldc_w -1253672047
      // 3e: ixor
      // 3f: putfield x/oc11364ce42a.Ɯ I
      // 42: goto 46
      // 45: athrow
      // 46: bipush 0
      // 47: ireturn
   }

   private boolean Ѻ() {
      int var1 = oc84f20a0bc5.ė;
      int var2 = 940560784 ^ 117391073;

      while (true) {
         switch (var2) {
            case -2100028273:
               int var10;
               label114: {
                  label113: {
                     try {
                        var10 = this.ĸ.currentScreen instanceof oc1cb76bf763;
                        if (var1 != 0) {
                           break label114;
                        }

                        if (var10 != 0) {
                           break label113;
                        }
                     } catch (ocbde1165e4e var7) {
                        throw var7;
                     }

                     var2 = 705738389 ^ 117391073;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var10 = -498470410 ^ 117391073;
               }

               var2 = var10;
               if (var1 == 0) {
                  continue;
               }
            case 1055977329:
               if (this.ĸ.currentScreen != null) {
                  var2 = -1432957801 ^ 117391073;
                  if (var1 == 0) {
                     continue;
                  }
               }

               var2 = -498470410 ^ 117391073;
               if (var1 == 0) {
                  continue;
               }
               break;
            case -1669676988:
               return true;
            case -1402342794:
               break;
            case -457781481:
               return false;
            case 753895540:
               int var9;
               label83: {
                  label82: {
                     try {
                        var9 = this.ĸ.currentScreen instanceof oc97cbf5cc05;
                        if (var1 != 0) {
                           break label83;
                        }

                        if (var9 != 0) {
                           break label82;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var2 = 879919301 ^ 117391073;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var9 = -498470410 ^ 117391073;
               }

               var2 = var9;
               if (var1 == 0) {
                  continue;
               }

               return true;
            case 848150052:
               int var10000;
               label105: {
                  label104: {
                     try {
                        var10000 = this.ĸ.currentScreen instanceof oc6a954e7c9f;
                        if (var1 != 0) {
                           break label105;
                        }

                        if (var10000 != 0) {
                           break label104;
                        }
                     } catch (ocbde1165e4e var6) {
                        throw var6;
                     }

                     var2 = -1702494555 ^ 117391073;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var10000 = -498470410 ^ 117391073;
               }

               var2 = var10000;
               if (var1 == 0) {
                  continue;
               }
            case 1311950110:
               int var8;
               label74: {
                  label73: {
                     try {
                        var8 = this.ĸ.currentScreen instanceof oc2c25634a7e;
                        if (var1 != 0) {
                           break label74;
                        }

                        if (var8 != 0) {
                           break label73;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = -2077547922 ^ 117391073;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var8 = -498470410 ^ 117391073;
               }

               var2 = var8;
               if (var1 == 0) {
                  continue;
               }

               return false;
            default:
               throw null;
         }

         int var11;
         label92: {
            label91: {
               try {
                  var11 = this.ĸ.currentScreen instanceof GuiChat;
                  if (var1 != 0) {
                     break label92;
                  }

                  if (var11 != 0) {
                     break label91;
                  }
               } catch (ocbde1165e4e var5) {
                  throw var5;
               }

               var2 = 1221458943 ^ 117391073;
               if (var1 == 0) {
                  continue;
               }
            }

            var11 = -498470410 ^ 117391073;
         }

         var2 = var11;
      }
   }

   private int Υ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: bipush 0
      // 04: istore 2
      // 05: istore 1
      // 06: bipush 0
      // 07: istore 3
      // 08: iload 3
      // 09: ldc_w -1165693827
      // 0c: ldc_w -1165693836
      // 0f: ixor
      // 10: if_icmpge 4a
      // 13: aload 0
      // 14: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 17: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1a: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 1d: iload 3
      // 1e: invokevirtual net/minecraft/entity/player/InventoryPlayer.getStackInSlot (I)Lnet/minecraft/item/ItemStack;
      // 21: astore 4
      // 23: iload 1
      // 24: ifne 46
      // 27: aload 4
      // 29: invokestatic x/oc11364ce42a.ʦ (Lnet/minecraft/item/ItemStack;)Z
      // 2c: iload 1
      // 2d: ifne 4b
      // 30: goto 34
      // 33: athrow
      // 34: ifeq 43
      // 37: goto 3b
      // 3a: athrow
      // 3b: iload 2
      // 3c: aload 4
      // 3e: getfield net/minecraft/item/ItemStack.stackSize I
      // 41: iadd
      // 42: istore 2
      // 43: iinc 3 1
      // 46: iload 1
      // 47: ifeq 08
      // 4a: iload 2
      // 4b: ireturn
   }

   private void Ĩ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: aload 0
      // 04: invokevirtual x/oc11364ce42a.Υ ()I
      // 07: istore 2
      // 08: istore 1
      // 09: iload 2
      // 0a: iload 1
      // 0b: ifne 24
      // 0e: ldc_w -1203558207
      // 11: ldc_w -1203558204
      // 14: ixor
      // 15: if_icmpgt 23
      // 18: goto 1c
      // 1b: athrow
      // 1c: ldc_w "§c"
      // 1f: goto 50
      // 22: athrow
      // 23: iload 2
      // 24: iload 1
      // 25: ifne 3e
      // 28: ldc_w -1203558197
      // 2b: ldc_w -1203558204
      // 2e: ixor
      // 2f: if_icmpgt 3d
      // 32: goto 36
      // 35: athrow
      // 36: ldc_w "§6"
      // 39: goto 50
      // 3c: athrow
      // 3d: iload 2
      // 3e: ldc_w -1203558179
      // 41: ldc_w -1203558204
      // 44: ixor
      // 45: if_icmpgt 4f
      // 48: ldc_w "§e"
      // 4b: goto 50
      // 4e: athrow
      // 4f: aconst_null
      // 50: astore 3
      // 51: aload 0
      // 52: aload 3
      // 53: iload 1
      // 54: ifne 6c
      // 57: ifnonnull 6b
      // 5a: goto 5e
      // 5d: athrow
      // 5e: iload 2
      // 5f: ldc_w " blocks"
      // 62: invokedynamic makeConcatWithConstants (ILjava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 67: goto 75
      // 6a: athrow
      // 6b: aload 3
      // 6c: iload 2
      // 6d: ldc_w "§f blocks"
      // 70: invokedynamic makeConcatWithConstants (Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001" ]
      // 75: putfield x/oc11364ce42a.ҥ Ljava/lang/String;
      // 78: return
   }

   void ǿ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 1
      // 004: aload 0
      // 005: getfield x/oc11364ce42a.ҥ Ljava/lang/String;
      // 008: ifnull 026
      // 00b: getstatic x/oc9755810e45.ğ Lx/oca3ff10b94f;
      // 00e: iload 1
      // 00f: ifne 020
      // 012: goto 016
      // 015: athrow
      // 016: ifnull 028
      // 019: goto 01d
      // 01c: athrow
      // 01d: getstatic x/oc9755810e45.ğ Lx/oca3ff10b94f;
      // 020: invokevirtual x/oca3ff10b94f.Ռ ()Z
      // 023: ifeq 028
      // 026: return
      // 027: athrow
      // 028: invokestatic java/lang/System.currentTimeMillis ()J
      // 02b: lstore 2
      // 02c: aload 0
      // 02d: getfield x/oc11364ce42a.ʫ Z
      // 030: ifeq 070
      // 033: lload 2
      // 034: aload 0
      // 035: getfield x/oc11364ce42a.Ϯ J
      // 038: lsub
      // 039: lstore 5
      // 03b: lload 5
      // 03d: iload 1
      // 03e: ifne 056
      // 041: ldc2_w 7341243970286361293
      // 044: ldc2_w 7341243970286361264
      // 047: lxor
      // 048: lcmp
      // 049: ifge 063
      // 04c: goto 050
      // 04f: athrow
      // 050: lload 5
      // 052: goto 056
      // 055: athrow
      // 056: l2f
      // 057: ldc_w 125.0
      // 05a: fdiv
      // 05b: ldc_w 240.0
      // 05e: fmul
      // 05f: f2i
      // 060: goto 06a
      // 063: ldc_w 1992176439
      // 066: ldc_w 1992176583
      // 069: ixor
      // 06a: istore 4
      // 06c: iload 1
      // 06d: ifeq 0af
      // 070: lload 2
      // 071: aload 0
      // 072: getfield x/oc11364ce42a.ɐ J
      // 075: lsub
      // 076: lstore 5
      // 078: lload 5
      // 07a: ldc2_w 7341243970286361293
      // 07d: ldc2_w 7341243970286361264
      // 080: lxor
      // 081: lcmp
      // 082: iload 1
      // 083: ifne 0a8
      // 086: ifge 0a3
      // 089: goto 08d
      // 08c: athrow
      // 08d: ldc_w 240.0
      // 090: lload 5
      // 092: l2f
      // 093: ldc_w 125.0
      // 096: fdiv
      // 097: ldc_w 240.0
      // 09a: fmul
      // 09b: fsub
      // 09c: f2i
      // 09d: istore 4
      // 09f: iload 1
      // 0a0: ifeq 0af
      // 0a3: bipush 0
      // 0a4: goto 0a8
      // 0a7: athrow
      // 0a8: istore 4
      // 0aa: aload 0
      // 0ab: aconst_null
      // 0ac: putfield x/oc11364ce42a.ҥ Ljava/lang/String;
      // 0af: iload 4
      // 0b1: ifgt 0b6
      // 0b4: return
      // 0b5: athrow
      // 0b6: new net/minecraft/client/gui/ScaledResolution
      // 0b9: dup
      // 0ba: aload 0
      // 0bb: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 0be: invokespecial net/minecraft/client/gui/ScaledResolution.<init> (Lnet/minecraft/client/Minecraft;)V
      // 0c1: astore 5
      // 0c3: invokestatic net/minecraft/client/renderer/GlStateManager.enableBlend ()V
      // 0c6: ldc_w 1992175813
      // 0c9: ldc_w 1992176583
      // 0cc: ixor
      // 0cd: ldc_w 1992175812
      // 0d0: ldc_w 1992176583
      // 0d3: ixor
      // 0d4: bipush 1
      // 0d5: bipush 0
      // 0d6: invokestatic net/minecraft/client/renderer/GlStateManager.tryBlendFuncSeparate (IIII)V
      // 0d9: aload 0
      // 0da: getfield x/oc11364ce42a.ĸ Lnet/minecraft/client/Minecraft;
      // 0dd: getfield net/minecraft/client/Minecraft.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // 0e0: aload 0
      // 0e1: getfield x/oc11364ce42a.ҥ Ljava/lang/String;
      // 0e4: aload 5
      // 0e6: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledWidth ()I
      // 0e9: i2f
      // 0ea: fconst_2
      // 0eb: fdiv
      // 0ec: ldc_w 11.0
      // 0ef: fadd
      // 0f0: aload 5
      // 0f2: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledHeight ()I
      // 0f5: i2f
      // 0f6: fconst_2
      // 0f7: fdiv
      // 0f8: ldc_w 3.0
      // 0fb: fsub
      // 0fc: iload 4
      // 0fe: ldc_w 1992176607
      // 101: ldc_w 1992176583
      // 104: ixor
      // 105: ishl
      // 106: ldc_w 1984023608
      // 109: ldc_w 1992176583
      // 10c: ixor
      // 10d: ior
      // 10e: bipush 1
      // 10f: invokevirtual net/minecraft/client/gui/FontRenderer.drawString (Ljava/lang/String;FFIZ)I
      // 112: pop
      // 113: invokestatic net/minecraft/client/renderer/GlStateManager.disableBlend ()V
      // 116: return
   }

   boolean ȫ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 1
      // 04: aload 0
      // 05: getfield x/oc11364ce42a.ʫ Z
      // 08: iload 1
      // 09: ifne 27
      // 0c: ifne 36
      // 0f: goto 13
      // 12: athrow
      // 13: invokestatic java/lang/System.currentTimeMillis ()J
      // 16: aload 0
      // 17: getfield x/oc11364ce42a.ɐ J
      // 1a: lsub
      // 1b: ldc2_w -6879552715515060559
      // 1e: ldc2_w -6879552715515060532
      // 21: lxor
      // 22: lcmp
      // 23: goto 27
      // 26: athrow
      // 27: iload 1
      // 28: ifne 33
      // 2b: iflt 36
      // 2e: goto 32
      // 31: athrow
      // 32: bipush 1
      // 33: goto 37
      // 36: bipush 0
      // 37: ireturn
   }

   void Ȗ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: invokestatic java/lang/System.currentTimeMillis ()J
      // 003: lstore 2
      // 004: lload 2
      // 005: l2d
      // 006: ldc2_w 1.0E8
      // 009: ddiv
      // 00a: ldc2_w 0.5
      // 00d: dmul
      // 00e: ldc2_w 400000.0
      // 011: dmul
      // 012: invokestatic java/lang/Math.sin (D)D
      // 015: dconst_1
      // 016: dadd
      // 017: ldc2_w 0.5
      // 01a: dmul
      // 01b: dstore 4
      // 01d: dload 4
      // 01f: ldc2_w 255.0
      // 022: dmul
      // 023: d2i
      // 024: istore 6
      // 026: ldc_w 852333568
      // 029: ldc_w 852333823
      // 02c: ixor
      // 02d: iload 6
      // 02f: isub
      // 030: istore 7
      // 032: ldc_w 852333568
      // 035: ldc_w 852333823
      // 038: ixor
      // 039: iload 6
      // 03b: imul
      // 03c: ldc_w 852333580
      // 03f: ldc_w 852333823
      // 042: ixor
      // 043: iload 7
      // 045: imul
      // 046: iadd
      // 047: ldc_w 852333815
      // 04a: ldc_w 852333823
      // 04d: ixor
      // 04e: ishr
      // 04f: istore 8
      // 051: ldc_w 852333623
      // 054: ldc_w 852333823
      // 057: ixor
      // 058: iload 6
      // 05a: imul
      // 05b: ldc_w 852333765
      // 05e: ldc_w 852333823
      // 061: ixor
      // 062: iload 7
      // 064: imul
      // 065: iadd
      // 066: ldc_w 852333815
      // 069: ldc_w 852333823
      // 06c: ixor
      // 06d: ishr
      // 06e: istore 9
      // 070: getstatic x/oc84f20a0bc5.ė I
      // 073: ldc_w 852333623
      // 076: ldc_w 852333823
      // 079: ixor
      // 07a: iload 6
      // 07c: imul
      // 07d: ldc_w 852333717
      // 080: ldc_w 852333823
      // 083: ixor
      // 084: iload 7
      // 086: imul
      // 087: iadd
      // 088: ldc_w 852333815
      // 08b: ldc_w 852333823
      // 08e: ixor
      // 08f: ishr
      // 090: istore 10
      // 092: aload 0
      // 093: getfield x/oc11364ce42a.ǘ Ljava/util/Map;
      // 096: invokeinterface java/util/Map.entrySet ()Ljava/util/Set; 1
      // 09b: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 0a0: astore 11
      // 0a2: istore 1
      // 0a3: aload 11
      // 0a5: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0aa: ifeq 139
      // 0ad: aload 11
      // 0af: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0b4: checkcast java/util/Map$Entry
      // 0b7: astore 12
      // 0b9: lload 2
      // 0ba: aload 12
      // 0bc: invokeinterface java/util/Map$Entry.getValue ()Ljava/lang/Object; 1
      // 0c1: checkcast java/lang/Long
      // 0c4: invokevirtual java/lang/Long.longValue ()J
      // 0c7: invokestatic java/lang/Math.abs (J)J
      // 0ca: lsub
      // 0cb: l2f
      // 0cc: ldc_w 500.0
      // 0cf: fdiv
      // 0d0: fstore 13
      // 0d2: fload 13
      // 0d4: iload 1
      // 0d5: ifne 100
      // 0d8: fconst_1
      // 0d9: fcmpl
      // 0da: iflt 0f0
      // 0dd: goto 0e1
      // 0e0: athrow
      // 0e1: aload 11
      // 0e3: invokeinterface java/util/Iterator.remove ()V 1
      // 0e8: iload 1
      // 0e9: ifeq 0a3
      // 0ec: goto 0f0
      // 0ef: athrow
      // 0f0: ldc_w 255.0
      // 0f3: fload 13
      // 0f5: ldc_w 255.0
      // 0f8: fmul
      // 0f9: ldc_w 255.0
      // 0fc: invokestatic java/lang/Math.min (FF)F
      // 0ff: fsub
      // 100: f2i
      // 101: istore 14
      // 103: iload 1
      // 104: aload 12
      // 106: invokeinterface java/util/Map$Entry.getKey ()Ljava/lang/Object; 1
      // 10b: checkcast net/minecraft/util/BlockPos
      // 10e: iload 14
      // 110: ldc_w 852333799
      // 113: ldc_w 852333823
      // 116: ixor
      // 117: ishl
      // 118: iload 8
      // 11a: ldc_w 852333807
      // 11d: ldc_w 852333823
      // 120: ixor
      // 121: ishl
      // 122: ior
      // 123: iload 9
      // 125: ldc_w 852333815
      // 128: ldc_w 852333823
      // 12b: ixor
      // 12c: ishl
      // 12d: ior
      // 12e: iload 10
      // 130: ior
      // 131: bipush 1
      // 132: bipush 0
      // 133: invokestatic x/ocbd4917c4b1.ь (Lnet/minecraft/util/BlockPos;IZZ)V
      // 136: ifeq 0a3
      // 139: return
   }

   private static float Ν() {
      return (float)(Math.random() - 0.5);
   }

   private static float П(float var0, float var1) {
      return (float)(var0 + (var1 - var0) * Math.random());
   }

   static {
      EnumFacing[] var10000 = new EnumFacing[1179560153 ^ 1179560157];
      var10000[0] = EnumFacing.EAST;
      var10000[1] = EnumFacing.SOUTH;
      var10000[1179560159 ^ 1179560157] = EnumFacing.NORTH;
      var10000[1179560158 ^ 1179560157] = EnumFacing.WEST;
      Զ = var10000;
   }
}

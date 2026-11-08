package x;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.BlockPos;

public class oc8825472e29 extends oc69da1aa7f5 {
   private static final String[] Ǩ;
   private final oca9cc61aada У;
   private final oca9cc61aada ʤ;
   private final occ2f8dff8d8 ΰ;
   private final occ2f8dff8d8 ŷ;
   private final occ2f8dff8d8 բ;
   private int ñ = -1;
   private float ə = 20.0F;
   private float ѝ;
   private long Ŵ;
   private long ʛ;
   private EntityLivingBase ж;
   private boolean Ԣ;
   private int ă = -1;
   private BlockPos Ӣ;
   private long ε;
   public static int х;

   public oc8825472e29() {
      super("AutoTool", oce4cea752dd.з);
      this.ą("Selects the best tool for the block you are mining.");
      this.ʌ(this.У = new oca9cc61aada("Mode", 0, Ǩ));
      this.ʌ(this.ʤ = new oca9cc61aada("Switch Delay", "ms", 0.0, 0.0, 1000.0, 25.0));
      this.ʌ(this.ΰ = new occ2f8dff8d8("SwitchBack", true));
      this.ʌ(this.ŷ = new occ2f8dff8d8("OnlySneaking", false));
      this.ʌ(this.բ = new occ2f8dff8d8("Pause In Combat", false));
      this.ɮ = true;
   }

   @Override
   public String getInfo() {
      return Ǩ[(int)this.У.Ӂ()];
   }

   @Override
   public void onDisable() {
      oc718fd4d503.Ō.à(this, true);
      this.ģ();
      this.ɶ();
      this.Ԃ();
      this.ñ = -1;
      this.ѝ = 0.0F;
      this.ə = 20.0F;
   }

   @oc66fa4f2195
   public void ʙ(oc9adb807c19 param1) {
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
      // 05: getfield x/ocb508b4e274.Ұ Lx/oc110d7f376c;
      // 08: getstatic x/oc110d7f376c.START Lx/oc110d7f376c;
      // 0b: if_acmpne 18
      // 0e: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 11: ifne 1a
      // 14: goto 18
      // 17: athrow
      // 18: return
      // 19: athrow
      // 1a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 20: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getLastAttacker ()Lnet/minecraft/entity/EntityLivingBase;
      // 23: astore 3
      // 24: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 27: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 2a: getfield net/minecraft/client/entity/EntityPlayerSP.hurtTime I
      // 2d: iload 2
      // 2e: ifne 5c
      // 31: ifle 55
      // 34: goto 38
      // 37: athrow
      // 38: aload 3
      // 39: ifnull 55
      // 3c: goto 40
      // 3f: athrow
      // 40: aload 0
      // 41: aload 3
      // 42: putfield x/oc8825472e29.ж Lnet/minecraft/entity/EntityLivingBase;
      // 45: aload 0
      // 46: bipush 0
      // 47: putfield x/oc8825472e29.Ԣ Z
      // 4a: aload 0
      // 4b: invokestatic java/lang/System.currentTimeMillis ()J
      // 4e: putfield x/oc8825472e29.ʛ J
      // 51: goto 55
      // 54: athrow
      // 55: aload 0
      // 56: getfield x/oc8825472e29.բ Lx/occ2f8dff8d8;
      // 59: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 5c: iload 2
      // 5d: ifne 9d
      // 60: ifeq 91
      // 63: goto 67
      // 66: athrow
      // 67: aload 0
      // 68: invokevirtual x/oc8825472e29.Լ ()Z
      // 6b: iload 2
      // 6c: ifne 9d
      // 6f: goto 73
      // 72: athrow
      // 73: ifeq 91
      // 76: goto 7a
      // 79: athrow
      // 7a: getstatic x/oc718fd4d503.Ō Lx/oc718fd4d503;
      // 7d: aload 0
      // 7e: bipush 1
      // 7f: invokevirtual x/oc718fd4d503.à (Ljava/lang/Object;Z)V
      // 82: aload 0
      // 83: invokevirtual x/oc8825472e29.ģ ()V
      // 86: aload 0
      // 87: invokevirtual x/oc8825472e29.Ԃ ()V
      // 8a: aload 0
      // 8b: lconst_0
      // 8c: putfield x/oc8825472e29.Ŵ J
      // 8f: return
      // 90: athrow
      // 91: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 94: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 97: getfield net/minecraft/client/settings/GameSettings.keyBindAttack Lnet/minecraft/client/settings/KeyBinding;
      // 9a: invokevirtual net/minecraft/client/settings/KeyBinding.isKeyDown ()Z
      // 9d: iload 2
      // 9e: ifne b7
      // a1: ifne b0
      // a4: goto a8
      // a7: athrow
      // a8: aload 0
      // a9: invokevirtual x/oc8825472e29.Ԃ ()V
      // ac: goto b0
      // af: athrow
      // b0: aload 0
      // b1: getfield x/oc8825472e29.ΰ Lx/occ2f8dff8d8;
      // b4: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // b7: iload 2
      // b8: ifne d5
      // bb: ifne c9
      // be: goto c2
      // c1: athrow
      // c2: aload 0
      // c3: bipush -1
      // c4: putfield x/oc8825472e29.ă I
      // c7: return
      // c8: athrow
      // c9: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // cc: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // cf: getfield net/minecraft/client/settings/GameSettings.keyBindAttack Lnet/minecraft/client/settings/KeyBinding;
      // d2: invokevirtual net/minecraft/client/settings/KeyBinding.isKeyDown ()Z
      // d5: ifeq d9
      // d8: return
      // d9: getstatic x/oc718fd4d503.Ō Lx/oc718fd4d503;
      // dc: aload 0
      // dd: bipush 0
      // de: invokevirtual x/oc718fd4d503.à (Ljava/lang/Object;Z)V
      // e1: aload 0
      // e2: invokevirtual x/oc8825472e29.ģ ()V
      // e5: return
   }

   @oc66fa4f2195
   public void Ǿ(occ48acb5d22 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 07: ifeq 31
      // 0a: aload 1
      // 0b: iload 2
      // 0c: ifne 28
      // 0f: goto 13
      // 12: athrow
      // 13: getfield x/occ48acb5d22.Ǖ Lnet/minecraft/entity/player/EntityPlayer;
      // 16: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 19: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1c: if_acmpne 31
      // 1f: goto 23
      // 22: athrow
      // 23: aload 1
      // 24: goto 28
      // 27: athrow
      // 28: getfield x/occ48acb5d22.Ǻ Lnet/minecraft/entity/Entity;
      // 2b: instanceof net/minecraft/entity/EntityLivingBase
      // 2e: ifne 33
      // 31: return
      // 32: athrow
      // 33: aload 0
      // 34: aload 1
      // 35: getfield x/occ48acb5d22.Ǻ Lnet/minecraft/entity/Entity;
      // 38: checkcast net/minecraft/entity/EntityLivingBase
      // 3b: putfield x/oc8825472e29.ж Lnet/minecraft/entity/EntityLivingBase;
      // 3e: aload 0
      // 3f: aload 0
      // 40: invokevirtual x/oc8825472e29.Ԉ ()Lnet/minecraft/entity/EntityLivingBase;
      // 43: aload 0
      // 44: getfield x/oc8825472e29.ж Lnet/minecraft/entity/EntityLivingBase;
      // 47: if_acmpne 4f
      // 4a: bipush 1
      // 4b: goto 50
      // 4e: athrow
      // 4f: bipush 0
      // 50: putfield x/oc8825472e29.Ԣ Z
      // 53: iload 2
      // 54: aload 0
      // 55: invokestatic java/lang/System.currentTimeMillis ()J
      // 58: putfield x/oc8825472e29.ʛ J
      // 5b: ifne 80
      // 5e: aload 0
      // 5f: getfield x/oc8825472e29.բ Lx/occ2f8dff8d8;
      // 62: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 65: ifeq 85
      // 68: goto 6c
      // 6b: athrow
      // 6c: getstatic x/oc718fd4d503.Ō Lx/oc718fd4d503;
      // 6f: aload 0
      // 70: bipush 1
      // 71: invokevirtual x/oc718fd4d503.à (Ljava/lang/Object;Z)V
      // 74: aload 0
      // 75: invokevirtual x/oc8825472e29.ģ ()V
      // 78: aload 0
      // 79: invokevirtual x/oc8825472e29.Ԃ ()V
      // 7c: goto 80
      // 7f: athrow
      // 80: aload 0
      // 81: lconst_0
      // 82: putfield x/oc8825472e29.Ŵ J
      // 85: return
   }

   @oc66fa4f2195
   public void θ(ocbab3c9954b var1) {
      oc718fd4d503.Ō.à(this, false);
      this.ģ();
      this.ɶ();
      this.Ԃ();
   }

   @oc66fa4f2195
   public void Ҙ(oc2bbaa492fe param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 2
      // 004: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 007: ifeq 015
      // 00a: aload 1
      // 00b: getfield x/oc2bbaa492fe.ǧ Lnet/minecraft/util/BlockPos;
      // 00e: ifnonnull 017
      // 011: goto 015
      // 014: athrow
      // 015: return
      // 016: athrow
      // 017: aload 0
      // 018: iload 2
      // 019: ifne 02e
      // 01c: getfield x/oc8825472e29.բ Lx/occ2f8dff8d8;
      // 01f: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 022: ifeq 056
      // 025: goto 029
      // 028: athrow
      // 029: aload 0
      // 02a: goto 02e
      // 02d: athrow
      // 02e: iload 2
      // 02f: ifne 051
      // 032: invokevirtual x/oc8825472e29.Լ ()Z
      // 035: ifeq 056
      // 038: goto 03c
      // 03b: athrow
      // 03c: getstatic x/oc718fd4d503.Ō Lx/oc718fd4d503;
      // 03f: aload 0
      // 040: bipush 1
      // 041: invokevirtual x/oc718fd4d503.à (Ljava/lang/Object;Z)V
      // 044: aload 0
      // 045: invokevirtual x/oc8825472e29.ģ ()V
      // 048: aload 0
      // 049: invokevirtual x/oc8825472e29.Ԃ ()V
      // 04c: aload 0
      // 04d: goto 051
      // 050: athrow
      // 051: lconst_0
      // 052: putfield x/oc8825472e29.Ŵ J
      // 055: return
      // 056: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 059: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 05c: aload 1
      // 05d: getfield x/oc2bbaa492fe.ǧ Lnet/minecraft/util/BlockPos;
      // 060: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 063: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 068: astore 3
      // 069: aload 0
      // 06a: getfield x/oc8825472e29.ŷ Lx/occ2f8dff8d8;
      // 06d: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 070: iload 2
      // 071: ifne 0a7
      // 074: ifeq 093
      // 077: goto 07b
      // 07a: athrow
      // 07b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 07e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 081: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isSneaking ()Z
      // 084: iload 2
      // 085: ifne 0a7
      // 088: goto 08c
      // 08b: athrow
      // 08c: ifeq 0b2
      // 08f: goto 093
      // 092: athrow
      // 093: aload 3
      // 094: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 097: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 09a: aload 1
      // 09b: getfield x/oc2bbaa492fe.ǧ Lnet/minecraft/util/BlockPos;
      // 09e: invokevirtual net/minecraft/block/Block.getBlockHardness (Lnet/minecraft/world/World;Lnet/minecraft/util/BlockPos;)F
      // 0a1: fconst_0
      // 0a2: fcmpl
      // 0a3: goto 0a7
      // 0a6: athrow
      // 0a7: iload 2
      // 0a8: ifne 0c4
      // 0ab: ifne 0b8
      // 0ae: goto 0b2
      // 0b1: athrow
      // 0b2: aload 0
      // 0b3: invokevirtual x/oc8825472e29.Ԃ ()V
      // 0b6: return
      // 0b7: athrow
      // 0b8: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0bb: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0be: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 0c1: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 0c4: istore 4
      // 0c6: aload 3
      // 0c7: iload 4
      // 0c9: invokestatic x/oc8825472e29.Ϻ (Lnet/minecraft/block/Block;I)I
      // 0cc: istore 5
      // 0ce: iload 5
      // 0d0: iload 2
      // 0d1: ifne 0f6
      // 0d4: iload 4
      // 0d6: if_icmpne 0e3
      // 0d9: goto 0dd
      // 0dc: athrow
      // 0dd: aload 0
      // 0de: invokevirtual x/oc8825472e29.Ԃ ()V
      // 0e1: return
      // 0e2: athrow
      // 0e3: aload 0
      // 0e4: iload 2
      // 0e5: ifne 0fb
      // 0e8: aload 1
      // 0e9: getfield x/oc2bbaa492fe.ǧ Lnet/minecraft/util/BlockPos;
      // 0ec: invokestatic java/lang/System.currentTimeMillis ()J
      // 0ef: invokevirtual x/oc8825472e29.Ⱦ (Lnet/minecraft/util/BlockPos;J)Z
      // 0f2: goto 0f6
      // 0f5: athrow
      // 0f6: ifne 0fa
      // 0f9: return
      // 0fa: aload 0
      // 0fb: iload 2
      // 0fc: ifne 134
      // 0ff: getfield x/oc8825472e29.У Lx/oca9cc61aada;
      // 102: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 105: d2i
      // 106: ifne 12f
      // 109: goto 10d
      // 10c: athrow
      // 10d: getstatic x/oc718fd4d503.Ō Lx/oc718fd4d503;
      // 110: aload 0
      // 111: iload 5
      // 113: aconst_null
      // 114: bipush 0
      // 115: bipush 0
      // 116: bipush 1
      // 117: invokevirtual x/oc718fd4d503.ϛ (Ljava/lang/Object;ILjava/lang/Integer;ZZZ)V
      // 11a: iload 2
      // 11b: aload 0
      // 11c: iload 5
      // 11e: putfield x/oc8825472e29.ñ I
      // 121: aload 0
      // 122: invokestatic java/lang/System.currentTimeMillis ()J
      // 125: putfield x/oc8825472e29.Ŵ J
      // 128: ifeq 17f
      // 12b: goto 12f
      // 12e: athrow
      // 12f: aload 0
      // 130: goto 134
      // 133: athrow
      // 134: iload 2
      // 135: ifne 17c
      // 138: getfield x/oc8825472e29.ΰ Lx/occ2f8dff8d8;
      // 13b: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 13e: ifeq 16d
      // 141: goto 145
      // 144: athrow
      // 145: aload 0
      // 146: iload 2
      // 147: ifne 17c
      // 14a: goto 14e
      // 14d: athrow
      // 14e: getfield x/oc8825472e29.ă I
      // 151: bipush -1
      // 152: if_icmpne 16d
      // 155: goto 159
      // 158: athrow
      // 159: aload 0
      // 15a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 15d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 160: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 163: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 166: putfield x/oc8825472e29.ă I
      // 169: goto 16d
      // 16c: athrow
      // 16d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 170: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 173: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 176: iload 5
      // 178: putfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 17b: aload 0
      // 17c: invokevirtual x/oc8825472e29.Ф ()V
      // 17f: aload 0
      // 180: invokevirtual x/oc8825472e29.Ԃ ()V
      // 183: return
   }

   public static int Ϻ(Block param0, int param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 07: iload 2
      // 08: ifne 15
      // 0b: ifnull 23
      // 0e: goto 12
      // 11: athrow
      // 12: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 15: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 18: ifnull 23
      // 1b: aload 0
      // 1c: ifnonnull 26
      // 1f: goto 23
      // 22: athrow
      // 23: iload 1
      // 24: ireturn
      // 25: athrow
      // 26: iload 1
      // 27: iload 2
      // 28: ifne 33
      // 2b: iflt 4d
      // 2e: goto 32
      // 31: athrow
      // 32: iload 1
      // 33: iload 2
      // 34: ifne 4a
      // 37: ldc_w 919494410
      // 3a: ldc_w 919494403
      // 3d: ixor
      // 3e: if_icmpge 4d
      // 41: goto 45
      // 44: athrow
      // 45: iload 1
      // 46: goto 4a
      // 49: athrow
      // 4a: goto 4e
      // 4d: bipush 0
      // 4e: istore 3
      // 4f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 52: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 55: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 58: iload 3
      // 59: invokevirtual net/minecraft/entity/player/InventoryPlayer.getStackInSlot (I)Lnet/minecraft/item/ItemStack;
      // 5c: astore 4
      // 5e: aload 4
      // 60: aload 0
      // 61: invokestatic x/oc7fbc83d9b3.Բ (Lnet/minecraft/item/ItemStack;Lnet/minecraft/block/Block;)F
      // 64: fstore 5
      // 66: bipush 0
      // 67: istore 6
      // 69: iload 6
      // 6b: ldc_w 919494410
      // 6e: ldc_w 919494403
      // 71: ixor
      // 72: if_icmpge b3
      // 75: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 78: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 7b: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 7e: iload 6
      // 80: invokevirtual net/minecraft/entity/player/InventoryPlayer.getStackInSlot (I)Lnet/minecraft/item/ItemStack;
      // 83: astore 7
      // 85: iload 2
      // 86: aload 7
      // 88: aload 0
      // 89: invokestatic x/oc7fbc83d9b3.Բ (Lnet/minecraft/item/ItemStack;Lnet/minecraft/block/Block;)F
      // 8c: fstore 8
      // 8e: ifne af
      // 91: fload 8
      // 93: fload 5
      // 95: fcmpl
      // 96: iload 2
      // 97: ifne b4
      // 9a: goto 9e
      // 9d: athrow
      // 9e: ifle ac
      // a1: goto a5
      // a4: athrow
      // a5: iload 6
      // a7: istore 3
      // a8: fload 8
      // aa: fstore 5
      // ac: iinc 6 1
      // af: iload 2
      // b0: ifeq 69
      // b3: iload 3
      // b4: ireturn
   }

   @oc66fa4f2195
   public void Ø(ocf923d5a814 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 2
      // 004: aload 1
      // 005: getfield x/ocb508b4e274.Ұ Lx/oc110d7f376c;
      // 008: getstatic x/oc110d7f376c.END Lx/oc110d7f376c;
      // 00b: if_acmpne 033
      // 00e: aload 0
      // 00f: getfield x/oc8825472e29.У Lx/oca9cc61aada;
      // 012: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 015: d2i
      // 016: iload 2
      // 017: ifne 028
      // 01a: goto 01e
      // 01d: athrow
      // 01e: ifne 033
      // 021: goto 025
      // 024: athrow
      // 025: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 028: iload 2
      // 029: ifne 040
      // 02c: ifne 034
      // 02f: goto 033
      // 032: athrow
      // 033: return
      // 034: aload 0
      // 035: iload 2
      // 036: ifne 044
      // 039: getfield x/oc8825472e29.ñ I
      // 03c: goto 040
      // 03f: athrow
      // 040: iflt 07c
      // 043: aload 0
      // 044: getfield x/oc8825472e29.ñ I
      // 047: iload 2
      // 048: ifne 06d
      // 04b: ldc_w -613870139
      // 04e: ldc_w -613870132
      // 051: ixor
      // 052: if_icmpge 07c
      // 055: goto 059
      // 058: athrow
      // 059: invokestatic java/lang/System.currentTimeMillis ()J
      // 05c: aload 0
      // 05d: getfield x/oc8825472e29.Ŵ J
      // 060: lsub
      // 061: ldc2_w -3663335542913706457
      // 064: ldc2_w -3663335542913706545
      // 067: lxor
      // 068: lcmp
      // 069: goto 06d
      // 06c: athrow
      // 06d: iload 2
      // 06e: ifne 079
      // 071: ifgt 07c
      // 074: goto 078
      // 077: athrow
      // 078: bipush 1
      // 079: goto 07d
      // 07c: bipush 0
      // 07d: istore 3
      // 07e: iload 3
      // 07f: ifeq 087
      // 082: fconst_0
      // 083: goto 089
      // 086: athrow
      // 087: ldc 20.0
      // 089: fstore 4
      // 08b: iload 3
      // 08c: ifeq 094
      // 08f: fconst_1
      // 090: goto 095
      // 093: athrow
      // 094: fconst_0
      // 095: fstore 5
      // 097: iload 2
      // 098: ifne 0db
      // 09b: aload 0
      // 09c: dup
      // 09d: getfield x/oc8825472e29.ə F
      // 0a0: fload 4
      // 0a2: aload 0
      // 0a3: getfield x/oc8825472e29.ə F
      // 0a6: fsub
      // 0a7: ldc_w 0.15
      // 0aa: fmul
      // 0ab: fadd
      // 0ac: putfield x/oc8825472e29.ə F
      // 0af: aload 0
      // 0b0: dup
      // 0b1: getfield x/oc8825472e29.ѝ F
      // 0b4: fload 5
      // 0b6: aload 0
      // 0b7: getfield x/oc8825472e29.ѝ F
      // 0ba: fsub
      // 0bb: ldc_w 0.15
      // 0be: fmul
      // 0bf: fadd
      // 0c0: putfield x/oc8825472e29.ѝ F
      // 0c3: aload 0
      // 0c4: getfield x/oc8825472e29.ѝ F
      // 0c7: ldc_w 0.01
      // 0ca: fcmpg
      // 0cb: ifgt 0dc
      // 0ce: goto 0d2
      // 0d1: athrow
      // 0d2: aload 0
      // 0d3: bipush -1
      // 0d4: putfield x/oc8825472e29.ñ I
      // 0d7: goto 0db
      // 0da: athrow
      // 0db: return
      // 0dc: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0df: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0e2: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 0e5: aload 0
      // 0e6: getfield x/oc8825472e29.ñ I
      // 0e9: invokevirtual net/minecraft/entity/player/InventoryPlayer.getStackInSlot (I)Lnet/minecraft/item/ItemStack;
      // 0ec: astore 6
      // 0ee: aload 6
      // 0f0: ifnonnull 0f5
      // 0f3: return
      // 0f4: athrow
      // 0f5: new net/minecraft/client/gui/ScaledResolution
      // 0f8: dup
      // 0f9: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0fc: invokespecial net/minecraft/client/gui/ScaledResolution.<init> (Lnet/minecraft/client/Minecraft;)V
      // 0ff: astore 7
      // 101: aload 7
      // 103: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledWidth ()I
      // 106: i2f
      // 107: fconst_2
      // 108: fdiv
      // 109: ldc_w 8.0
      // 10c: fsub
      // 10d: f2i
      // 10e: istore 8
      // 110: aload 7
      // 112: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledHeight ()I
      // 115: i2f
      // 116: ldc_w 72.0
      // 119: fsub
      // 11a: aload 0
      // 11b: getfield x/oc8825472e29.ə F
      // 11e: fadd
      // 11f: f2i
      // 120: istore 9
      // 122: invokestatic net/minecraft/client/renderer/GlStateManager.pushMatrix ()V
      // 125: invokestatic net/minecraft/client/renderer/GlStateManager.enableBlend ()V
      // 128: fconst_1
      // 129: fconst_1
      // 12a: fconst_1
      // 12b: aload 0
      // 12c: getfield x/oc8825472e29.ѝ F
      // 12f: invokestatic net/minecraft/client/renderer/GlStateManager.color (FFFF)V
      // 132: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 135: invokevirtual net/minecraft/client/Minecraft.getRenderItem ()Lnet/minecraft/client/renderer/entity/RenderItem;
      // 138: aload 6
      // 13a: iload 8
      // 13c: iload 9
      // 13e: invokevirtual net/minecraft/client/renderer/entity/RenderItem.renderItemAndEffectIntoGUI (Lnet/minecraft/item/ItemStack;II)V
      // 141: fconst_1
      // 142: fconst_1
      // 143: fconst_1
      // 144: fconst_1
      // 145: invokestatic net/minecraft/client/renderer/GlStateManager.color (FFFF)V
      // 148: invokestatic net/minecraft/client/renderer/GlStateManager.disableBlend ()V
      // 14b: invokestatic net/minecraft/client/renderer/GlStateManager.popMatrix ()V
      // 14e: return
   }

   public int ʷ() {
      return this.ñ;
   }

   public boolean ˡ() {
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
      // 06: ifne 1c
      // 09: getfield x/oc8825472e29.У Lx/oca9cc61aada;
      // 0c: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0f: d2i
      // 10: ifne 4c
      // 13: goto 17
      // 16: athrow
      // 17: aload 0
      // 18: goto 1c
      // 1b: athrow
      // 1c: iload 1
      // 1d: ifne 2f
      // 20: getfield x/oc8825472e29.ñ I
      // 23: iflt 4c
      // 26: goto 2a
      // 29: athrow
      // 2a: aload 0
      // 2b: goto 2f
      // 2e: athrow
      // 2f: getfield x/oc8825472e29.ñ I
      // 32: iload 1
      // 33: ifne 49
      // 36: ldc_w 718146364
      // 39: ldc_w 718146357
      // 3c: ixor
      // 3d: if_icmpge 4c
      // 40: goto 44
      // 43: athrow
      // 44: bipush 1
      // 45: goto 49
      // 48: athrow
      // 49: goto 4d
      // 4c: bipush 0
      // 4d: ireturn
   }

   private boolean Լ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 1
      // 04: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 07: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0a: ifnonnull 10
      // 0d: bipush 0
      // 0e: ireturn
      // 0f: athrow
      // 10: invokestatic java/lang/System.currentTimeMillis ()J
      // 13: lstore 2
      // 14: getstatic x/oc9755810e45.ÿ Lx/ocdd342096f8;
      // 17: iload 1
      // 18: ifne 25
      // 1b: ifnull 37
      // 1e: goto 22
      // 21: athrow
      // 22: getstatic x/oc9755810e45.ÿ Lx/ocdd342096f8;
      // 25: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 28: iload 1
      // 29: ifne 34
      // 2c: ifeq 37
      // 2f: goto 33
      // 32: athrow
      // 33: bipush 1
      // 34: goto 38
      // 37: bipush 0
      // 38: istore 4
      // 3a: iload 1
      // 3b: aload 0
      // 3c: invokevirtual x/oc8825472e29.Ԉ ()Lnet/minecraft/entity/EntityLivingBase;
      // 3f: astore 5
      // 41: aload 0
      // 42: getfield x/oc8825472e29.ж Lnet/minecraft/entity/EntityLivingBase;
      // 45: aload 0
      // 46: getfield x/oc8825472e29.Ԣ Z
      // 49: iload 4
      // 4b: aload 5
      // 4d: invokestatic x/oc8825472e29.ŕ (Ljava/lang/Object;ZZLjava/lang/Object;)Ljava/lang/Object;
      // 50: checkcast net/minecraft/entity/EntityLivingBase
      // 53: astore 6
      // 55: ifne 76
      // 58: aload 6
      // 5a: ifnonnull 68
      // 5d: goto 61
      // 60: athrow
      // 61: aload 0
      // 62: invokevirtual x/oc8825472e29.ɶ ()V
      // 65: bipush 0
      // 66: ireturn
      // 67: athrow
      // 68: aload 0
      // 69: iload 1
      // 6a: ifne 89
      // 6d: aload 6
      // 6f: putfield x/oc8825472e29.ж Lnet/minecraft/entity/EntityLivingBase;
      // 72: goto 76
      // 75: athrow
      // 76: aload 5
      // 78: ifnull 88
      // 7b: aload 0
      // 7c: bipush 1
      // 7d: putfield x/oc8825472e29.Ԣ Z
      // 80: aload 0
      // 81: lload 2
      // 82: putfield x/oc8825472e29.ʛ J
      // 85: bipush 1
      // 86: ireturn
      // 87: athrow
      // 88: aload 0
      // 89: getfield x/oc8825472e29.ж Lnet/minecraft/entity/EntityLivingBase;
      // 8c: getfield net/minecraft/entity/EntityLivingBase.hurtTime I
      // 8f: iload 1
      // 90: ifne b0
      // 93: ifle a2
      // 96: goto 9a
      // 99: athrow
      // 9a: aload 0
      // 9b: lload 2
      // 9c: putfield x/oc8825472e29.ʛ J
      // 9f: bipush 1
      // a0: ireturn
      // a1: athrow
      // a2: lload 2
      // a3: aload 0
      // a4: getfield x/oc8825472e29.ʛ J
      // a7: lsub
      // a8: ldc2_w 7756539349989642361
      // ab: ldc2_w 7756539349989642371
      // ae: lxor
      // af: lcmp
      // b0: iload 1
      // b1: ifne cd
      // b4: ifge be
      // b7: goto bb
      // ba: athrow
      // bb: bipush 1
      // bc: ireturn
      // bd: athrow
      // be: aload 0
      // bf: iload 1
      // c0: ifne f1
      // c3: getfield x/oc8825472e29.ж Lnet/minecraft/entity/EntityLivingBase;
      // c6: getfield net/minecraft/entity/EntityLivingBase.isDead Z
      // c9: goto cd
      // cc: athrow
      // cd: ifne f0
      // d0: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // d3: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // d6: aload 0
      // d7: getfield x/oc8825472e29.ж Lnet/minecraft/entity/EntityLivingBase;
      // da: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getDistanceToEntity (Lnet/minecraft/entity/Entity;)F
      // dd: ldc_w 7.0
      // e0: fcmpl
      // e1: iload 1
      // e2: ifne f7
      // e5: goto e9
      // e8: athrow
      // e9: ifle f6
      // ec: goto f0
      // ef: athrow
      // f0: aload 0
      // f1: invokevirtual x/oc8825472e29.ɶ ()V
      // f4: bipush 0
      // f5: ireturn
      // f6: bipush 1
      // f7: ireturn
   }

   static <T> T ŕ(T param0, boolean param1, boolean param2, T param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 4
      // 05: iload 2
      // 06: iload 4
      // 08: ifne 16
      // 0b: ifeq 15
      // 0e: goto 12
      // 11: athrow
      // 12: aload 3
      // 13: areturn
      // 14: athrow
      // 15: iload 1
      // 16: ifeq 1e
      // 19: aconst_null
      // 1a: goto 1f
      // 1d: athrow
      // 1e: aload 0
      // 1f: areturn
   }

   private EntityLivingBase Ԉ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 1
      // 04: getstatic x/oc9755810e45.ÿ Lx/ocdd342096f8;
      // 07: iload 1
      // 08: ifne 15
      // 0b: ifnull 30
      // 0e: goto 12
      // 11: athrow
      // 12: getstatic x/oc9755810e45.ÿ Lx/ocdd342096f8;
      // 15: iload 1
      // 16: ifne 2a
      // 19: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 1c: ifeq 30
      // 1f: goto 23
      // 22: athrow
      // 23: getstatic x/oc9755810e45.ÿ Lx/ocdd342096f8;
      // 26: goto 2a
      // 29: athrow
      // 2a: invokevirtual x/ocdd342096f8.ɱ ()Lnet/minecraft/entity/EntityLivingBase;
      // 2d: goto 31
      // 30: aconst_null
      // 31: areturn
   }

   private void ɶ() {
      this.ж = null;
      this.Ԣ = false;
      this.ʛ = 0L;
   }

   boolean Ⱦ(BlockPos param1, long param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: lconst_0
      // 04: aload 0
      // 05: getfield x/oc8825472e29.ʤ Lx/oca9cc61aada;
      // 08: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0b: invokestatic java/lang/Math.round (D)J
      // 0e: invokestatic java/lang/Math.max (JJ)J
      // 11: lstore 5
      // 13: istore 4
      // 15: lload 5
      // 17: lconst_0
      // 18: lcmp
      // 19: iload 4
      // 1b: ifne 34
      // 1e: ifne 2c
      // 21: goto 25
      // 24: athrow
      // 25: aload 0
      // 26: invokevirtual x/oc8825472e29.Ԃ ()V
      // 29: bipush 1
      // 2a: ireturn
      // 2b: athrow
      // 2c: aload 1
      // 2d: aload 0
      // 2e: getfield x/oc8825472e29.Ӣ Lnet/minecraft/util/BlockPos;
      // 31: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 34: iload 4
      // 36: ifne 56
      // 39: ifne 4d
      // 3c: goto 40
      // 3f: athrow
      // 40: aload 0
      // 41: aload 1
      // 42: putfield x/oc8825472e29.Ӣ Lnet/minecraft/util/BlockPos;
      // 45: aload 0
      // 46: lload 2
      // 47: putfield x/oc8825472e29.ε J
      // 4a: bipush 0
      // 4b: ireturn
      // 4c: athrow
      // 4d: lload 2
      // 4e: aload 0
      // 4f: getfield x/oc8825472e29.ε J
      // 52: lsub
      // 53: lload 5
      // 55: lcmp
      // 56: iload 4
      // 58: ifne 63
      // 5b: iflt 66
      // 5e: goto 62
      // 61: athrow
      // 62: bipush 1
      // 63: goto 67
      // 66: bipush 0
      // 67: ireturn
   }

   private void Ԃ() {
      this.Ӣ = null;
      this.ε = 0L;
   }

   private void ģ() {
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
      // 06: ifne 2d
      // 09: getfield x/oc8825472e29.ă I
      // 0c: iflt 28
      // 0f: goto 13
      // 12: athrow
      // 13: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 16: iload 1
      // 17: ifne 35
      // 1a: goto 1e
      // 1d: athrow
      // 1e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 21: ifnonnull 32
      // 24: goto 28
      // 27: athrow
      // 28: aload 0
      // 29: goto 2d
      // 2c: athrow
      // 2d: bipush -1
      // 2e: putfield x/oc8825472e29.ă I
      // 31: return
      // 32: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 35: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 38: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 3b: aload 0
      // 3c: getfield x/oc8825472e29.ă I
      // 3f: putfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 42: aload 0
      // 43: bipush -1
      // 44: putfield x/oc8825472e29.ă I
      // 47: aload 0
      // 48: invokevirtual x/oc8825472e29.Ф ()V
      // 4b: return
   }

   private void Ф() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
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

   static {
      String[] var10000 = new String[1464376921 ^ 1464376923];
      var10000[0] = "Silent";
      var10000[1] = "Switch";
      Ǩ = var10000;
   }
}

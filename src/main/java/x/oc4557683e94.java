package x;

import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.client.C09PacketHeldItemChange;
import net.minecraft.network.play.client.C07PacketPlayerDigging.Action;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;

public class oc4557683e94 extends oc69da1aa7f5 {
   private static final int ľ = 1;
   private static final int Ț = 2;
   private static final int Զ = 3;
   public static final int ѭ = 4;
   private static final String[] Џ;
   public static oca9cc61aada հ;
   public static oca9cc61aada Ƹ;
   public static occ2f8dff8d8 Π;
   public static occ2f8dff8d8 Ʈ;
   public static occ2f8dff8d8 ӆ;
   public boolean ȏ;
   private static int յ;
   private int ʮ;
   private boolean Ŀ;
   private int d = -1;
   private final oc4d46a99983 ӫ;
   private final oc76009594cb A = new oc76009594cb(ocd6ae010123::ĕ);
   private final ocfa8b80a093 ƨ = new ocfa8b80a093(ocd6ae010123::ĕ);
   private NetHandlerPlayClient Ӕ;
   private WorldClient ŷ;
   public static int Ò;

   public oc4557683e94() {
      super("NoSlow", oce4cea752dd.ҕ, 0);
      this.ą("Reduces movement slowdown while using items.");
      this.ʌ(հ = new oca9cc61aada("Mode", 0, Џ));
      this.ʌ(Π = new occ2f8dff8d8("Sword", false));
      this.ʌ(Ʈ = new occ2f8dff8d8("Consume", false));
      this.ʌ(ӆ = new occ2f8dff8d8("Bow", false));
      this.ʌ(this.ӫ = new oc4d46a99983("Default is 80% motion reduction."));
      this.ʌ(Ƹ = new oca9cc61aada("Slow %", 80.0, 0.0, 80.0, 1.0));
      this.ԣ();
   }

   @Override
   public void onEnable() {
      this.ǒ();
   }

   @Override
   public void onDisable() {
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
      // 04: ifne 37
      // 07: invokevirtual x/oc4557683e94.ϯ ()V
      // 0a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 10: ifnull 32
      // 13: goto 17
      // 16: athrow
      // 17: aload 0
      // 18: getfield x/oc4557683e94.ƨ Lx/ocfa8b80a093;
      // 1b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 21: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 24: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 27: invokevirtual x/ocfa8b80a093.ϒ (I)V
      // 2a: iload 1
      // 2b: ifeq 3d
      // 2e: goto 32
      // 31: athrow
      // 32: aload 0
      // 33: goto 37
      // 36: athrow
      // 37: getfield x/oc4557683e94.ƨ Lx/ocfa8b80a093;
      // 3a: invokevirtual x/ocfa8b80a093.ȱ ()V
      // 3d: aload 0
      // 3e: bipush 0
      // 3f: putfield x/oc4557683e94.ȏ Z
      // 42: aload 0
      // 43: invokevirtual x/oc4557683e94.ǒ ()V
      // 46: return
   }

   @Override
   public void z$2u87utkr1isxg() {
      this.ԣ();
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
      // 00: bipush 0
      // 01: istore 2
      // 02: aload 1
      // 03: getstatic x/oc4557683e94.հ Lx/oca9cc61aada;
      // 06: if_acmpne 50
      // 09: aload 0
      // 0a: iload 2
      // 0b: ifne 42
      // 0e: goto 12
      // 11: athrow
      // 12: invokevirtual x/oc4557683e94.ϯ ()V
      // 15: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 18: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1b: ifnull 3d
      // 1e: goto 22
      // 21: athrow
      // 22: aload 0
      // 23: getfield x/oc4557683e94.ƨ Lx/ocfa8b80a093;
      // 26: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 29: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 2c: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 2f: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 32: invokevirtual x/ocfa8b80a093.ϒ (I)V
      // 35: iload 2
      // 36: ifeq 48
      // 39: goto 3d
      // 3c: athrow
      // 3d: aload 0
      // 3e: goto 42
      // 41: athrow
      // 42: getfield x/oc4557683e94.ƨ Lx/ocfa8b80a093;
      // 45: invokevirtual x/ocfa8b80a093.ȱ ()V
      // 48: aload 0
      // 49: invokevirtual x/oc4557683e94.ǒ ()V
      // 4c: aload 0
      // 4d: invokevirtual x/oc4557683e94.ԣ ()V
      // 50: return
   }

   @Override
   public void z$3tl278wzjcayb(N param1) {
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
      // 03: getstatic x/oc4557683e94.հ Lx/oca9cc61aada;
      // 06: if_acmpne 4c
      // 09: aload 0
      // 0a: iload 2
      // 0b: ifne 42
      // 0e: goto 12
      // 11: athrow
      // 12: invokevirtual x/oc4557683e94.ϯ ()V
      // 15: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 18: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1b: ifnull 3d
      // 1e: goto 22
      // 21: athrow
      // 22: aload 0
      // 23: getfield x/oc4557683e94.ƨ Lx/ocfa8b80a093;
      // 26: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 29: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 2c: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 2f: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 32: invokevirtual x/ocfa8b80a093.ϒ (I)V
      // 35: iload 2
      // 36: ifeq 48
      // 39: goto 3d
      // 3c: athrow
      // 3d: aload 0
      // 3e: goto 42
      // 41: athrow
      // 42: getfield x/oc4557683e94.ƨ Lx/ocfa8b80a093;
      // 45: invokevirtual x/ocfa8b80a093.ȱ ()V
      // 48: aload 0
      // 49: invokevirtual x/oc4557683e94.ǒ ()V
      // 4c: aload 0
      // 4d: invokevirtual x/oc4557683e94.ԣ ()V
      // 50: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGHEST
   )
   public void о(oc2f61de30bc param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: bipush 0
      // 001: istore 2
      // 002: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 005: iload 2
      // 006: ifne 01d
      // 009: ifne 016
      // 00c: goto 010
      // 00f: athrow
      // 010: aload 0
      // 011: invokevirtual x/oc4557683e94.ǒ ()V
      // 014: return
      // 015: athrow
      // 016: getstatic x/oc4557683e94.հ Lx/oca9cc61aada;
      // 019: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 01c: d2i
      // 01d: istore 3
      // 01e: iload 3
      // 01f: iload 2
      // 020: ifne 07b
      // 023: aload 0
      // 024: getfield x/oc4557683e94.d I
      // 027: if_icmpeq 07a
      // 02a: goto 02e
      // 02d: athrow
      // 02e: aload 0
      // 02f: iload 2
      // 030: ifne 067
      // 033: goto 037
      // 036: athrow
      // 037: invokevirtual x/oc4557683e94.ϯ ()V
      // 03a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 03d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 040: ifnull 062
      // 043: goto 047
      // 046: athrow
      // 047: aload 0
      // 048: getfield x/oc4557683e94.ƨ Lx/ocfa8b80a093;
      // 04b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 04e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 051: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 054: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 057: invokevirtual x/ocfa8b80a093.ϒ (I)V
      // 05a: iload 2
      // 05b: ifeq 06d
      // 05e: goto 062
      // 061: athrow
      // 062: aload 0
      // 063: goto 067
      // 066: athrow
      // 067: getfield x/oc4557683e94.ƨ Lx/ocfa8b80a093;
      // 06a: invokevirtual x/ocfa8b80a093.ȱ ()V
      // 06d: aload 0
      // 06e: invokevirtual x/oc4557683e94.Հ ()V
      // 071: aload 0
      // 072: iload 3
      // 073: putfield x/oc4557683e94.d I
      // 076: aload 0
      // 077: invokevirtual x/oc4557683e94.ԣ ()V
      // 07a: iload 3
      // 07b: iload 2
      // 07c: ifne 358
      // 07f: ldc -1103526301
      // 081: ldc -1103526297
      // 083: ixor
      // 084: if_icmpne 357
      // 087: goto 08b
      // 08a: athrow
      // 08b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 08e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 091: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isUsingItem ()Z
      // 094: iload 2
      // 095: ifne 0a6
      // 098: goto 09c
      // 09b: athrow
      // 09c: ifeq 0b5
      // 09f: goto 0a3
      // 0a2: athrow
      // 0a3: invokestatic x/oc4557683e94.ĝ ()Z
      // 0a6: iload 2
      // 0a7: ifne 0b2
      // 0aa: ifeq 0b5
      // 0ad: goto 0b1
      // 0b0: athrow
      // 0b1: bipush 1
      // 0b2: goto 0b6
      // 0b5: bipush 0
      // 0b6: istore 4
      // 0b8: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0bb: iload 2
      // 0bc: ifne 109
      // 0bf: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0c2: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 0c5: ifnull 106
      // 0c8: goto 0cc
      // 0cb: athrow
      // 0cc: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0cf: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0d2: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 0d5: getfield net/minecraft/util/MovementInput.moveForward F
      // 0d8: fconst_0
      // 0d9: fcmpl
      // 0da: iload 2
      // 0db: ifne 16f
      // 0de: goto 0e2
      // 0e1: athrow
      // 0e2: ifne 16e
      // 0e5: goto 0e9
      // 0e8: athrow
      // 0e9: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0ec: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0ef: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 0f2: getfield net/minecraft/util/MovementInput.moveStrafe F
      // 0f5: fconst_0
      // 0f6: fcmpl
      // 0f7: iload 2
      // 0f8: ifne 16f
      // 0fb: goto 0ff
      // 0fe: athrow
      // 0ff: ifne 16e
      // 102: goto 106
      // 105: athrow
      // 106: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 109: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 10c: getfield net/minecraft/client/settings/GameSettings.keyBindForward Lnet/minecraft/client/settings/KeyBinding;
      // 10f: invokevirtual net/minecraft/client/settings/KeyBinding.isKeyDown ()Z
      // 112: iload 2
      // 113: ifne 16f
      // 116: ifne 16e
      // 119: goto 11d
      // 11c: athrow
      // 11d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 120: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 123: getfield net/minecraft/client/settings/GameSettings.keyBindBack Lnet/minecraft/client/settings/KeyBinding;
      // 126: invokevirtual net/minecraft/client/settings/KeyBinding.isKeyDown ()Z
      // 129: iload 2
      // 12a: ifne 16f
      // 12d: goto 131
      // 130: athrow
      // 131: ifne 16e
      // 134: goto 138
      // 137: athrow
      // 138: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 13b: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 13e: getfield net/minecraft/client/settings/GameSettings.keyBindLeft Lnet/minecraft/client/settings/KeyBinding;
      // 141: invokevirtual net/minecraft/client/settings/KeyBinding.isKeyDown ()Z
      // 144: iload 2
      // 145: ifne 16f
      // 148: goto 14c
      // 14b: athrow
      // 14c: ifne 16e
      // 14f: goto 153
      // 152: athrow
      // 153: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 156: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 159: getfield net/minecraft/client/settings/GameSettings.keyBindRight Lnet/minecraft/client/settings/KeyBinding;
      // 15c: invokevirtual net/minecraft/client/settings/KeyBinding.isKeyDown ()Z
      // 15f: iload 2
      // 160: ifne 16f
      // 163: goto 167
      // 166: athrow
      // 167: ifeq 172
      // 16a: goto 16e
      // 16d: athrow
      // 16e: bipush 1
      // 16f: goto 173
      // 172: bipush 0
      // 173: istore 5
      // 175: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 178: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 17b: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isSneaking ()Z
      // 17e: iload 2
      // 17f: ifne 1a5
      // 182: ifne 1a4
      // 185: goto 189
      // 188: athrow
      // 189: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 18c: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 18f: getfield net/minecraft/client/settings/GameSettings.keyBindSneak Lnet/minecraft/client/settings/KeyBinding;
      // 192: invokevirtual net/minecraft/client/settings/KeyBinding.isKeyDown ()Z
      // 195: iload 2
      // 196: ifne 1a5
      // 199: goto 19d
      // 19c: athrow
      // 19d: ifeq 1a8
      // 1a0: goto 1a4
      // 1a3: athrow
      // 1a4: bipush 1
      // 1a5: goto 1a9
      // 1a8: bipush 0
      // 1a9: istore 6
      // 1ab: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1ae: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1b1: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isInWater ()Z
      // 1b4: iload 2
      // 1b5: ifne 1d8
      // 1b8: ifne 1d7
      // 1bb: goto 1bf
      // 1be: athrow
      // 1bf: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1c2: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1c5: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isInLava ()Z
      // 1c8: iload 2
      // 1c9: ifne 1d8
      // 1cc: goto 1d0
      // 1cf: athrow
      // 1d0: ifeq 1db
      // 1d3: goto 1d7
      // 1d6: athrow
      // 1d7: bipush 1
      // 1d8: goto 1dc
      // 1db: bipush 0
      // 1dc: istore 7
      // 1de: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1e1: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1e4: iload 2
      // 1e5: ifne 1fc
      // 1e8: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 1eb: ifnull 214
      // 1ee: goto 1f2
      // 1f1: athrow
      // 1f2: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1f5: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1f8: goto 1fc
      // 1fb: athrow
      // 1fc: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 1ff: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 202: instanceof net/minecraft/item/ItemBow
      // 205: iload 2
      // 206: ifne 211
      // 209: ifeq 214
      // 20c: goto 210
      // 20f: athrow
      // 210: bipush 1
      // 211: goto 215
      // 214: bipush 0
      // 215: istore 8
      // 217: iload 8
      // 219: iload 2
      // 21a: ifne 225
      // 21d: ifeq 227
      // 220: goto 224
      // 223: athrow
      // 224: bipush 0
      // 225: istore 4
      // 227: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 22a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 22d: iload 2
      // 22e: ifne 245
      // 231: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 234: ifnull 25d
      // 237: goto 23b
      // 23a: athrow
      // 23b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 23e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 241: goto 245
      // 244: athrow
      // 245: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 248: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 24b: instanceof net/minecraft/item/ItemSword
      // 24e: iload 2
      // 24f: ifne 25a
      // 252: ifeq 25d
      // 255: goto 259
      // 258: athrow
      // 259: bipush 1
      // 25a: goto 25e
      // 25d: bipush 0
      // 25e: istore 9
      // 260: iload 9
      // 262: ifeq 2b6
      // 265: getstatic x/oc9755810e45.Ԏ Lx/oce3cc81daa8;
      // 268: iload 2
      // 269: ifne 282
      // 26c: goto 270
      // 26f: athrow
      // 270: ifnull 2b6
      // 273: goto 277
      // 276: athrow
      // 277: getstatic x/oc9755810e45.Ԏ Lx/oce3cc81daa8;
      // 27a: iload 2
      // 27b: ifne 28f
      // 27e: goto 282
      // 281: athrow
      // 282: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 285: ifeq 2b6
      // 288: getstatic x/oc9755810e45.Ԏ Lx/oce3cc81daa8;
      // 28b: goto 28f
      // 28e: athrow
      // 28f: invokevirtual x/oce3cc81daa8.å ()Z
      // 292: iload 2
      // 293: ifne 2b3
      // 296: ifne 2b2
      // 299: goto 29d
      // 29c: athrow
      // 29d: getstatic x/oc9755810e45.Ԏ Lx/oce3cc81daa8;
      // 2a0: invokevirtual x/oce3cc81daa8.ń ()Z
      // 2a3: iload 2
      // 2a4: ifne 2b3
      // 2a7: goto 2ab
      // 2aa: athrow
      // 2ab: ifeq 2b6
      // 2ae: goto 2b2
      // 2b1: athrow
      // 2b2: bipush 1
      // 2b3: goto 2b7
      // 2b6: bipush 0
      // 2b7: istore 10
      // 2b9: iload 9
      // 2bb: iload 2
      // 2bc: ifne 2c8
      // 2bf: ifeq 322
      // 2c2: goto 2c6
      // 2c5: athrow
      // 2c6: iload 10
      // 2c8: iload 2
      // 2c9: ifne 31f
      // 2cc: ifne 31e
      // 2cf: goto 2d3
      // 2d2: athrow
      // 2d3: getstatic x/ocdd342096f8.f Lnet/minecraft/entity/EntityLivingBase;
      // 2d6: iload 2
      // 2d7: ifne 2e8
      // 2da: goto 2de
      // 2dd: athrow
      // 2de: ifnonnull 31e
      // 2e1: goto 2e5
      // 2e4: athrow
      // 2e5: getstatic x/ocdd342096f8.ѐ Lnet/minecraft/entity/EntityLivingBase;
      // 2e8: ifnonnull 31e
      // 2eb: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 2ee: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 2f1: getfield net/minecraft/client/entity/EntityPlayerSP.isSwingInProgress Z
      // 2f4: iload 2
      // 2f5: ifne 31f
      // 2f8: goto 2fc
      // 2fb: athrow
      // 2fc: ifne 31e
      // 2ff: goto 303
      // 302: athrow
      // 303: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 306: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 309: getfield net/minecraft/client/settings/GameSettings.keyBindAttack Lnet/minecraft/client/settings/KeyBinding;
      // 30c: invokevirtual net/minecraft/client/settings/KeyBinding.isKeyDown ()Z
      // 30f: iload 2
      // 310: ifne 31f
      // 313: goto 317
      // 316: athrow
      // 317: ifeq 322
      // 31a: goto 31e
      // 31d: athrow
      // 31e: bipush 1
      // 31f: goto 323
      // 322: bipush 0
      // 323: istore 11
      // 325: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 328: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 32b: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 32e: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 331: istore 12
      // 333: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 336: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 339: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 33c: getfield net/minecraft/entity/player/InventoryPlayer.mainInventory [Lnet/minecraft/item/ItemStack;
      // 33f: astore 13
      // 341: aload 0
      // 342: getfield x/oc4557683e94.ƨ Lx/ocfa8b80a093;
      // 345: iload 4
      // 347: iload 5
      // 349: iload 6
      // 34b: iload 7
      // 34d: iload 11
      // 34f: iload 12
      // 351: aload 13
      // 353: invokevirtual x/ocfa8b80a093.ŏ (ZZZZZI[Lnet/minecraft/item/ItemStack;)V
      // 356: return
      // 357: iload 3
      // 358: iload 2
      // 359: ifne 38b
      // 35c: ldc_w -1103526300
      // 35f: ldc -1103526297
      // 361: ixor
      // 362: if_icmpne 38a
      // 365: goto 369
      // 368: athrow
      // 369: aload 0
      // 36a: invokevirtual x/oc4557683e94.ǘ ()Z
      // 36d: iload 2
      // 36e: ifne 38b
      // 371: goto 375
      // 374: athrow
      // 375: ifeq 38a
      // 378: goto 37c
      // 37b: athrow
      // 37c: aload 0
      // 37d: getfield x/oc4557683e94.A Lx/oc76009594cb;
      // 380: invokestatic java/lang/System.nanoTime ()J
      // 383: invokevirtual x/oc76009594cb.Ԏ (J)V
      // 386: goto 38a
      // 389: athrow
      // 38a: iload 3
      // 38b: iload 2
      // 38c: ifne 3fb
      // 38f: ldc_w -1103526299
      // 392: ldc -1103526297
      // 394: ixor
      // 395: if_icmpne 3ee
      // 398: goto 39c
      // 39b: athrow
      // 39c: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 39f: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 3a2: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isUsingItem ()Z
      // 3a5: iload 2
      // 3a6: ifne 3c7
      // 3a9: goto 3ad
      // 3ac: athrow
      // 3ad: ifeq 3c6
      // 3b0: goto 3b4
      // 3b3: athrow
      // 3b4: invokestatic x/oc4557683e94.ĝ ()Z
      // 3b7: iload 2
      // 3b8: ifne 3dc
      // 3bb: goto 3bf
      // 3be: athrow
      // 3bf: ifne 3cb
      // 3c2: goto 3c6
      // 3c5: athrow
      // 3c6: bipush 0
      // 3c7: putstatic x/oc4557683e94.յ I
      // 3ca: return
      // 3cb: getstatic x/oc4557683e94.յ I
      // 3ce: iload 2
      // 3cf: ifne 3ea
      // 3d2: bipush 1
      // 3d3: iadd
      // 3d4: dup
      // 3d5: putstatic x/oc4557683e94.յ I
      // 3d8: goto 3dc
      // 3db: athrow
      // 3dc: ldc_w -1103526299
      // 3df: ldc -1103526297
      // 3e1: ixor
      // 3e2: if_icmplt 3ed
      // 3e5: bipush 0
      // 3e6: goto 3ea
      // 3e9: athrow
      // 3ea: putstatic x/oc4557683e94.յ I
      // 3ed: return
      // 3ee: bipush 0
      // 3ef: putstatic x/oc4557683e94.յ I
      // 3f2: iload 2
      // 3f3: ifne 411
      // 3f6: iload 3
      // 3f7: goto 3fb
      // 3fa: athrow
      // 3fb: bipush 1
      // 3fc: if_icmpne 415
      // 3ff: aload 0
      // 400: dup
      // 401: getfield x/oc4557683e94.ʮ I
      // 404: bipush 1
      // 405: iadd
      // 406: putfield x/oc4557683e94.ʮ I
      // 409: aload 0
      // 40a: invokevirtual x/oc4557683e94.ũ ()V
      // 40d: goto 411
      // 410: athrow
      // 411: iload 2
      // 412: ifeq 41e
      // 415: aload 0
      // 416: bipush 0
      // 417: putfield x/oc4557683e94.Ŀ Z
      // 41a: goto 41e
      // 41d: athrow
      // 41e: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGHEST
   )
   public void ϭ(oc9d4393f3ce param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: getstatic x/oc4557683e94.հ Lx/oca9cc61aada;
      // 04: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 07: d2i
      // 08: istore 3
      // 09: istore 2
      // 0a: iload 3
      // 0b: iload 2
      // 0c: ifne 2b
      // 0f: ldc_w 1063529590
      // 12: ldc_w 1063529586
      // 15: ixor
      // 16: if_icmpne 2a
      // 19: goto 1d
      // 1c: athrow
      // 1d: aload 0
      // 1e: getfield x/oc4557683e94.ƨ Lx/ocfa8b80a093;
      // 21: aload 1
      // 22: invokevirtual x/oc9d4393f3ce.ɟ ()Lnet/minecraft/network/Packet;
      // 25: invokevirtual x/ocfa8b80a093.Ő (Lnet/minecraft/network/Packet;)V
      // 28: return
      // 29: athrow
      // 2a: iload 3
      // 2b: iload 2
      // 2c: ifne 3e
      // 2f: bipush 1
      // 30: if_icmpne 81
      // 33: goto 37
      // 36: athrow
      // 37: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 3a: goto 3e
      // 3d: athrow
      // 3e: iload 2
      // 3f: ifne 54
      // 42: ifeq 81
      // 45: goto 49
      // 48: athrow
      // 49: aload 1
      // 4a: invokevirtual x/oc9d4393f3ce.ɟ ()Lnet/minecraft/network/Packet;
      // 4d: instanceof net/minecraft/network/play/client/C08PacketPlayerBlockPlacement
      // 50: goto 54
      // 53: athrow
      // 54: iload 2
      // 55: ifne 67
      // 58: ifeq 81
      // 5b: goto 5f
      // 5e: athrow
      // 5f: aload 0
      // 60: invokevirtual x/oc4557683e94.җ ()Z
      // 63: goto 67
      // 66: athrow
      // 67: iload 2
      // 68: ifne 7e
      // 6b: ifeq 81
      // 6e: goto 72
      // 71: athrow
      // 72: bipush 0
      // 73: bipush 1
      // 74: bipush 1
      // 75: bipush 0
      // 76: bipush 0
      // 77: invokestatic x/oc5dd058ac50.ȸ (ZZZZZ)Z
      // 7a: goto 7e
      // 7d: athrow
      // 7e: ifeq 82
      // 81: return
      // 82: aload 0
      // 83: invokevirtual x/oc4557683e94.ŋ ()V
      // 86: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.LOW
   )
   public void ĳ(oc9d4393f3ce param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 2
      // 02: getstatic x/oc4557683e94.հ Lx/oca9cc61aada;
      // 05: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 08: d2i
      // 09: iload 2
      // 0a: ifne 23
      // 0d: ldc_w 349303683
      // 10: ldc_w 349303680
      // 13: ixor
      // 14: if_icmpne 41
      // 17: goto 1b
      // 1a: athrow
      // 1b: aload 1
      // 1c: invokevirtual x/oc68d6b191af.isCanceled ()Z
      // 1f: goto 23
      // 22: athrow
      // 23: iload 2
      // 24: ifne 36
      // 27: ifne 41
      // 2a: goto 2e
      // 2d: athrow
      // 2e: aload 0
      // 2f: invokevirtual x/oc4557683e94.ǘ ()Z
      // 32: goto 36
      // 35: athrow
      // 36: iload 2
      // 37: ifne 4b
      // 3a: ifne 42
      // 3d: goto 41
      // 40: athrow
      // 41: return
      // 42: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 45: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 48: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isUsingItem ()Z
      // 4b: iload 2
      // 4c: ifne 59
      // 4f: ifeq 94
      // 52: goto 56
      // 55: athrow
      // 56: invokestatic x/oc4557683e94.ĝ ()Z
      // 59: iload 2
      // 5a: ifne 79
      // 5d: ifeq 94
      // 60: goto 64
      // 63: athrow
      // 64: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 67: iload 2
      // 68: ifne 7f
      // 6b: goto 6f
      // 6e: athrow
      // 6f: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 72: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isRiding ()Z
      // 75: goto 79
      // 78: athrow
      // 79: ifne 94
      // 7c: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 7f: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 82: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isEntityAlive ()Z
      // 85: iload 2
      // 86: ifne 91
      // 89: ifeq 94
      // 8c: goto 90
      // 8f: athrow
      // 90: bipush 1
      // 91: goto 95
      // 94: bipush 0
      // 95: istore 3
      // 96: aload 0
      // 97: getfield x/oc4557683e94.A Lx/oc76009594cb;
      // 9a: aload 1
      // 9b: invokevirtual x/oc9d4393f3ce.ɟ ()Lnet/minecraft/network/Packet;
      // 9e: iload 3
      // 9f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // a2: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // a5: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // a8: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // ab: invokestatic java/lang/System.nanoTime ()J
      // ae: invokevirtual x/oc76009594cb.Տ (Lnet/minecraft/network/Packet;ZIJ)Z
      // b1: ifeq bd
      // b4: aload 1
      // b5: bipush 1
      // b6: invokevirtual x/oc68d6b191af.setCanceled (Z)V
      // b9: goto bd
      // bc: athrow
      // bd: return
   }

   @oc66fa4f2195
   public void Ɩ(oc5e6785e9df param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 2
      // 02: getstatic x/oc4557683e94.հ Lx/oca9cc61aada;
      // 05: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 08: iload 2
      // 09: ifne 30
      // 0c: d2i
      // 0d: ldc_w 1888156750
      // 10: ldc_w 1888156746
      // 13: ixor
      // 14: if_icmpne 2a
      // 17: goto 1b
      // 1a: athrow
      // 1b: aload 0
      // 1c: getfield x/oc4557683e94.ƨ Lx/ocfa8b80a093;
      // 1f: aload 1
      // 20: invokevirtual x/oc5e6785e9df.ğ ()Lnet/minecraft/network/Packet;
      // 23: invokevirtual x/ocfa8b80a093.Ő (Lnet/minecraft/network/Packet;)V
      // 26: goto 2a
      // 29: athrow
      // 2a: getstatic x/oc4557683e94.հ Lx/oca9cc61aada;
      // 2d: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 30: d2i
      // 31: iload 2
      // 32: ifne 53
      // 35: ldc_w 1888156745
      // 38: ldc_w 1888156746
      // 3b: ixor
      // 3c: if_icmpne 61
      // 3f: goto 43
      // 42: athrow
      // 43: aload 0
      // 44: iload 2
      // 45: ifne 57
      // 48: goto 4c
      // 4b: athrow
      // 4c: invokevirtual x/oc4557683e94.ǘ ()Z
      // 4f: goto 53
      // 52: athrow
      // 53: ifeq 61
      // 56: aload 0
      // 57: getfield x/oc4557683e94.A Lx/oc76009594cb;
      // 5a: aload 1
      // 5b: invokevirtual x/oc5e6785e9df.ğ ()Lnet/minecraft/network/Packet;
      // 5e: invokevirtual x/oc76009594cb.ʉ (Lnet/minecraft/network/Packet;)V
      // 61: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGHEST,
      receiveCanceled = true
   )
   public void Ϋ(oce79181588d param1) {
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
      // 03: invokevirtual x/oce79181588d.Ҡ ()Lnet/minecraft/network/Packet;
      // 06: instanceof net/minecraft/network/play/server/S08PacketPlayerPosLook
      // 09: ifeq 52
      // 0c: aload 0
      // 0d: iload 2
      // 0e: ifne 4c
      // 11: goto 15
      // 14: athrow
      // 15: invokevirtual x/oc4557683e94.ϯ ()V
      // 18: aload 0
      // 19: getfield x/oc4557683e94.A Lx/oc76009594cb;
      // 1c: invokevirtual x/oc76009594cb.Ɲ ()V
      // 1f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 22: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 25: ifnull 47
      // 28: goto 2c
      // 2b: athrow
      // 2c: aload 0
      // 2d: getfield x/oc4557683e94.ƨ Lx/ocfa8b80a093;
      // 30: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 33: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 36: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 39: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 3c: invokevirtual x/ocfa8b80a093.B (I)V
      // 3f: iload 2
      // 40: ifeq 52
      // 43: goto 47
      // 46: athrow
      // 47: aload 0
      // 48: goto 4c
      // 4b: athrow
      // 4c: getfield x/oc4557683e94.ƨ Lx/ocfa8b80a093;
      // 4f: invokevirtual x/ocfa8b80a093.ȱ ()V
      // 52: return
   }

   private boolean ǘ() {
      boolean var1 = false;
      int var2 = -1397900510 ^ -1600794465;

      while (true) {
         switch (var2) {
            case 205024189:
               if (oc69da1aa7f5.ő != null) {
                  var2 = -1167558184 ^ -1600794465;
                  if (!var1) {
                     break;
                  }
               }

               var2 = -166193096 ^ -1600794465;
               if (!var1) {
                  break;
               }
            case -1742397117:
               if (this.Ӕ == oc69da1aa7f5.ő.getNetHandler()) {
                  var2 = -445495843 ^ -1600794465;
                  if (!var1) {
                     break;
                  }
               }

               var2 = 27386731 ^ -1600794465;
               if (!var1) {
                  break;
               }
            case -1590414348:
               this.A.Ɲ();
               this.Ӕ = oc69da1aa7f5.ő.getNetHandler();
               this.ŷ = oc69da1aa7f5.ő.theWorld;
               var2 = 551966482 ^ -1600794465;
               if (!var1) {
                  break;
               }
            case 452831559:
               if (oc69da1aa7f5.ő.thePlayer != null) {
                  var2 = -2133567975 ^ -1600794465;
                  if (!var1) {
                     break;
                  }
               }

               var2 = -166193096 ^ -1600794465;
               if (!var1) {
                  break;
               }
            case -2139912307:
               return true;
            case 541165190:
               if (oc69da1aa7f5.ő.theWorld != null) {
                  var2 = 334340257 ^ -1600794465;
                  if (!var1) {
                     break;
                  }
               }

               var2 = -166193096 ^ -1600794465;
               if (!var1) {
                  break;
               }
            case -1283952578:
               if (oc69da1aa7f5.ő.getNetHandler() == null) {
                  var2 = -166193096 ^ -1600794465;
                  if (!var1) {
                     break;
                  }
               }

               var2 = 951120348 ^ -1600794465;
               if (!var1) {
                  break;
               }
            case 1172804930:
               if (this.ŷ != oc69da1aa7f5.ő.theWorld) {
                  var2 = 27386731 ^ -1600794465;
                  if (!var1) {
                     break;
                  }
               }

               var2 = 551966482 ^ -1600794465;
               break;
            case 1452132519:
               this.A.Ɲ();
               this.Ӕ = null;
               this.ŷ = null;
               return false;
            default:
               throw null;
         }
      }
   }

   private void ϯ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 1
      // 02: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 05: ifnull 6d
      // 08: aload 0
      // 09: iload 1
      // 0a: ifne 72
      // 0d: goto 11
      // 10: athrow
      // 11: getfield x/oc4557683e94.Ӕ Lnet/minecraft/client/network/NetHandlerPlayClient;
      // 14: ifnull 6d
      // 17: goto 1b
      // 1a: athrow
      // 1b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1e: iload 1
      // 1f: ifne 3b
      // 22: goto 26
      // 25: athrow
      // 26: invokevirtual net/minecraft/client/Minecraft.getNetHandler ()Lnet/minecraft/client/network/NetHandlerPlayClient;
      // 29: aload 0
      // 2a: getfield x/oc4557683e94.Ӕ Lnet/minecraft/client/network/NetHandlerPlayClient;
      // 2d: if_acmpne 6d
      // 30: goto 34
      // 33: athrow
      // 34: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 37: goto 3b
      // 3a: athrow
      // 3b: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 3e: aload 0
      // 3f: getfield x/oc4557683e94.ŷ Lnet/minecraft/client/multiplayer/WorldClient;
      // 42: if_acmpne 6d
      // 45: aload 0
      // 46: iload 1
      // 47: ifne 72
      // 4a: goto 4e
      // 4d: athrow
      // 4e: getfield x/oc4557683e94.Ӕ Lnet/minecraft/client/network/NetHandlerPlayClient;
      // 51: invokevirtual net/minecraft/client/network/NetHandlerPlayClient.getNetworkManager ()Lnet/minecraft/network/NetworkManager;
      // 54: invokevirtual net/minecraft/network/NetworkManager.isChannelOpen ()Z
      // 57: ifeq 6d
      // 5a: goto 5e
      // 5d: athrow
      // 5e: aload 0
      // 5f: getfield x/oc4557683e94.A Lx/oc76009594cb;
      // 62: invokevirtual x/oc76009594cb.q ()V
      // 65: iload 1
      // 66: ifeq 78
      // 69: goto 6d
      // 6c: athrow
      // 6d: aload 0
      // 6e: goto 72
      // 71: athrow
      // 72: getfield x/oc4557683e94.A Lx/oc76009594cb;
      // 75: invokevirtual x/oc76009594cb.Ɲ ()V
      // 78: return
   }

   public void ƅ() {
      this.A.Ɲ();
      this.Ӕ = null;
      this.ŷ = null;
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGHEST
   )
   public void Ԡ(oc25aa89b91f param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 2
      // 02: getstatic x/oc4557683e94.հ Lx/oca9cc61aada;
      // 05: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 08: d2i
      // 09: iload 2
      // 0a: ifne 25
      // 0d: bipush 1
      // 0e: if_icmpne 37
      // 11: goto 15
      // 14: athrow
      // 15: aload 0
      // 16: iload 2
      // 17: ifne 33
      // 1a: goto 1e
      // 1d: athrow
      // 1e: invokevirtual x/oc4557683e94.Ԛ ()Z
      // 21: goto 25
      // 24: athrow
      // 25: ifeq 37
      // 28: invokestatic x/oc4557683e94.ɟ ()Lnet/minecraft/network/play/client/C07PacketPlayerDigging;
      // 2b: invokestatic x/ocd6ae010123.Ė (Lnet/minecraft/network/Packet;)V
      // 2e: aload 0
      // 2f: goto 33
      // 32: athrow
      // 33: bipush 1
      // 34: putfield x/oc4557683e94.Ŀ Z
      // 37: return
   }

   public static float Ҳ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: bipush 0
      // 001: istore 0
      // 002: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 005: iload 0
      // 006: ifne 01a
      // 009: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 00c: ifnull 054
      // 00f: goto 013
      // 012: athrow
      // 013: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 016: goto 01a
      // 019: athrow
      // 01a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 01d: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 020: ifnull 054
      // 023: getstatic x/oc9755810e45.ҩ Lx/oc4557683e94;
      // 026: iload 0
      // 027: ifne 038
      // 02a: goto 02e
      // 02d: athrow
      // 02e: ifnull 054
      // 031: goto 035
      // 034: athrow
      // 035: getstatic x/oc9755810e45.ҩ Lx/oc4557683e94;
      // 038: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 03b: iload 0
      // 03c: ifne 049
      // 03f: ifeq 054
      // 042: goto 046
      // 045: athrow
      // 046: invokestatic x/oc4557683e94.ĝ ()Z
      // 049: iload 0
      // 04a: ifne 060
      // 04d: ifne 059
      // 050: goto 054
      // 053: athrow
      // 054: ldc_w 0.2
      // 057: freturn
      // 058: athrow
      // 059: getstatic x/oc4557683e94.հ Lx/oca9cc61aada;
      // 05c: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 05f: d2i
      // 060: istore 1
      // 061: iload 1
      // 062: iload 0
      // 063: ifne 0ab
      // 066: ldc_w -1566891773
      // 069: ldc_w -1566891769
      // 06c: ixor
      // 06d: if_icmpne 0aa
      // 070: goto 074
      // 073: athrow
      // 074: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 077: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 07a: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 07d: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 080: astore 2
      // 081: aload 2
      // 082: instanceof net/minecraft/item/ItemBow
      // 085: iload 0
      // 086: ifne 09e
      // 089: ifeq 095
      // 08c: goto 090
      // 08f: athrow
      // 090: ldc_w 0.2
      // 093: freturn
      // 094: athrow
      // 095: getstatic x/oc9755810e45.ҩ Lx/oc4557683e94;
      // 098: getfield x/oc4557683e94.ƨ Lx/ocfa8b80a093;
      // 09b: invokevirtual x/ocfa8b80a093.Ѐ ()Z
      // 09e: ifeq 0a6
      // 0a1: fconst_1
      // 0a2: goto 0a9
      // 0a5: athrow
      // 0a6: ldc_w 0.2
      // 0a9: freturn
      // 0aa: iload 1
      // 0ab: iload 0
      // 0ac: ifne 0c1
      // 0af: ldc_w -1566891772
      // 0b2: ldc_w -1566891769
      // 0b5: ixor
      // 0b6: if_icmpne 0c0
      // 0b9: goto 0bd
      // 0bc: athrow
      // 0bd: fconst_1
      // 0be: freturn
      // 0bf: athrow
      // 0c0: iload 1
      // 0c1: iload 0
      // 0c2: ifne 0dc
      // 0c5: ldc_w -1566891771
      // 0c8: ldc_w -1566891769
      // 0cb: ixor
      // 0cc: if_icmpne 0db
      // 0cf: goto 0d3
      // 0d2: athrow
      // 0d3: getstatic x/oc4557683e94.յ I
      // 0d6: invokestatic x/oc4557683e94.Ѹ (I)F
      // 0d9: freturn
      // 0da: athrow
      // 0db: iload 1
      // 0dc: bipush 1
      // 0dd: if_icmpne 0f7
      // 0e0: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0e3: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0e6: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 0e9: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 0ec: getstatic x/oc9755810e45.ҩ Lx/oc4557683e94;
      // 0ef: getfield x/oc4557683e94.Ŀ Z
      // 0f2: invokestatic x/oc4557683e94.Ɇ (Lnet/minecraft/item/Item;Z)F
      // 0f5: freturn
      // 0f6: athrow
      // 0f7: ldc_w 100.0
      // 0fa: getstatic x/oc4557683e94.Ƹ Lx/oca9cc61aada;
      // 0fd: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 100: d2f
      // 101: fsub
      // 102: ldc_w 100.0
      // 105: fdiv
      // 106: freturn
   }

   public static boolean Ǻ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 0
      // 02: getstatic x/oc9755810e45.ҩ Lx/oc4557683e94;
      // 05: iload 0
      // 06: ifne 13
      // 09: ifnull 33
      // 0c: goto 10
      // 0f: athrow
      // 10: getstatic x/oc9755810e45.ҩ Lx/oc4557683e94;
      // 13: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 16: iload 0
      // 17: ifne 34
      // 1a: ifeq 33
      // 1d: goto 21
      // 20: athrow
      // 21: invokestatic x/oc4557683e94.ĝ ()Z
      // 24: iload 0
      // 25: ifne 3c
      // 28: goto 2c
      // 2b: athrow
      // 2c: ifne 35
      // 2f: goto 33
      // 32: athrow
      // 33: bipush 0
      // 34: ireturn
      // 35: getstatic x/oc4557683e94.հ Lx/oca9cc61aada;
      // 38: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 3b: d2i
      // 3c: istore 1
      // 3d: iload 1
      // 3e: iload 0
      // 3f: ifne bd
      // 42: ldc_w 1896788377
      // 45: ldc_w 1896788381
      // 48: ixor
      // 49: if_icmpne b9
      // 4c: goto 50
      // 4f: athrow
      // 50: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 53: iload 0
      // 54: ifne 6c
      // 57: goto 5b
      // 5a: athrow
      // 5b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 5e: ifnull b7
      // 61: goto 65
      // 64: athrow
      // 65: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 68: goto 6c
      // 6b: athrow
      // 6c: iload 0
      // 6d: ifne 84
      // 70: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 73: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 76: ifnull b7
      // 79: goto 7d
      // 7c: athrow
      // 7d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 80: goto 84
      // 83: athrow
      // 84: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 87: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 8a: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 8d: instanceof net/minecraft/item/ItemBow
      // 90: iload 0
      // 91: ifne a8
      // 94: ifne b7
      // 97: goto 9b
      // 9a: athrow
      // 9b: getstatic x/oc9755810e45.ҩ Lx/oc4557683e94;
      // 9e: getfield x/oc4557683e94.ƨ Lx/ocfa8b80a093;
      // a1: invokevirtual x/ocfa8b80a093.Ѐ ()Z
      // a4: goto a8
      // a7: athrow
      // a8: iload 0
      // a9: ifne b4
      // ac: ifeq b7
      // af: goto b3
      // b2: athrow
      // b3: bipush 1
      // b4: goto b8
      // b7: bipush 0
      // b8: ireturn
      // b9: iload 1
      // ba: invokestatic x/oc4557683e94.Ӥ (I)Z
      // bd: ireturn
   }

   static boolean ɲ(Item param0, int param1, boolean param2, boolean param3, boolean param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 5
      // 03: aload 0
      // 04: iload 5
      // 06: ifne 17
      // 09: instanceof net/minecraft/item/ItemSword
      // 0c: ifeq 16
      // 0f: goto 13
      // 12: athrow
      // 13: iload 2
      // 14: ireturn
      // 15: athrow
      // 16: aload 0
      // 17: iload 5
      // 19: ifne 2a
      // 1c: instanceof net/minecraft/item/ItemFood
      // 1f: ifeq 29
      // 22: goto 26
      // 25: athrow
      // 26: iload 3
      // 27: ireturn
      // 28: athrow
      // 29: aload 0
      // 2a: iload 5
      // 2c: ifne 65
      // 2f: instanceof net/minecraft/item/ItemPotion
      // 32: ifeq 64
      // 35: goto 39
      // 38: athrow
      // 39: iload 3
      // 3a: iload 5
      // 3c: ifne 5b
      // 3f: goto 43
      // 42: athrow
      // 43: ifeq 62
      // 46: goto 4a
      // 49: athrow
      // 4a: iload 1
      // 4b: iload 5
      // 4d: ifne 5f
      // 50: goto 54
      // 53: athrow
      // 54: invokestatic net/minecraft/item/ItemPotion.isSplash (I)Z
      // 57: goto 5b
      // 5a: athrow
      // 5b: ifne 62
      // 5e: bipush 1
      // 5f: goto 63
      // 62: bipush 0
      // 63: ireturn
      // 64: aload 0
      // 65: instanceof net/minecraft/item/ItemBow
      // 68: iload 5
      // 6a: ifne 76
      // 6d: ifeq 86
      // 70: goto 74
      // 73: athrow
      // 74: iload 4
      // 76: iload 5
      // 78: ifne 83
      // 7b: ifeq 86
      // 7e: goto 82
      // 81: athrow
      // 82: bipush 1
      // 83: goto 87
      // 86: bipush 0
      // 87: ireturn
   }

   static float Ɇ(Item param0, boolean param1) {
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
      // 03: iload 2
      // 04: ifne 16
      // 07: instanceof net/minecraft/item/ItemSword
      // 0a: ifne 24
      // 0d: goto 11
      // 10: athrow
      // 11: aload 0
      // 12: goto 16
      // 15: athrow
      // 16: iload 2
      // 17: ifne 28
      // 1a: instanceof net/minecraft/item/ItemBow
      // 1d: ifeq 27
      // 20: goto 24
      // 23: athrow
      // 24: fconst_1
      // 25: freturn
      // 26: athrow
      // 27: aload 0
      // 28: instanceof net/minecraft/item/ItemFood
      // 2b: iload 2
      // 2c: ifne 4a
      // 2f: ifne 49
      // 32: goto 36
      // 35: athrow
      // 36: aload 0
      // 37: instanceof net/minecraft/item/ItemPotion
      // 3a: iload 2
      // 3b: ifne 4a
      // 3e: goto 42
      // 41: athrow
      // 42: ifeq 56
      // 45: goto 49
      // 48: athrow
      // 49: iload 1
      // 4a: ifeq 52
      // 4d: fconst_1
      // 4e: goto 55
      // 51: athrow
      // 52: ldc_w 0.2
      // 55: freturn
      // 56: ldc_w 0.2
      // 59: freturn
   }

   private static boolean ĝ() {
      ItemStack var1 = null;
      int var2 = 889481783 ^ -1998521680;
      boolean var0 = false;

      while (true) {
         switch (var2) {
            case -1599955027:
               return false;
            case -1109094265:
               break;
            case 822576008:
               return false;
            case 993089721:
               int var10000;
               label62: {
                  label61: {
                     try {
                        var10000 = ɲ(var1.getItem(), var1.getMetadata(), Π.ǭ(), Ʈ.ǭ(), ӆ.ǭ());
                        if (var0) {
                           break label62;
                        }

                        if (var10000 == 0) {
                           break label61;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var2 = -460430560 ^ -1998521680;
                     if (!var0) {
                        continue;
                     }
                  }

                  var10000 = 675439901 ^ -1998521680;
               }

               var2 = var10000;
               if (!var0) {
                  continue;
               }
            case -288918147:
               var1 = oc69da1aa7f5.ő.thePlayer.getHeldItem();

               label51: {
                  label50: {
                     try {
                        if (var0) {
                           break label51;
                        }

                        if (var1 == null) {
                           break label50;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = -1278107127 ^ -1998521680;
                     if (!var0) {
                        continue;
                     }
                  }

                  var2 = 675439901 ^ -1998521680;
               }

               if (!var0) {
                  continue;
               }
               break;
            case 1819187600:
               return true;
            default:
               throw null;
         }

         if (oc69da1aa7f5.ő.thePlayer == null) {
            var2 = -1176012488 ^ -1998521680;
            if (!var0) {
               continue;
            }
         }

         var2 = 1713868749 ^ -1998521680;
         if (var0) {
            return false;
         }
      }
   }

   static boolean Ӥ(int param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 1
      // 02: iload 0
      // 03: iload 1
      // 04: ifne 48
      // 07: ldc_w -2141174337
      // 0a: ldc_w -2141174339
      // 0d: ixor
      // 0e: if_icmpeq 43
      // 11: goto 15
      // 14: athrow
      // 15: iload 0
      // 16: iload 1
      // 17: ifne 48
      // 1a: goto 1e
      // 1d: athrow
      // 1e: ldc_w -2141174338
      // 21: ldc_w -2141174339
      // 24: ixor
      // 25: if_icmpeq 43
      // 28: goto 2c
      // 2b: athrow
      // 2c: iload 0
      // 2d: iload 1
      // 2e: ifne 48
      // 31: goto 35
      // 34: athrow
      // 35: ldc_w -2141174343
      // 38: ldc_w -2141174339
      // 3b: ixor
      // 3c: if_icmpne 4b
      // 3f: goto 43
      // 42: athrow
      // 43: bipush 1
      // 44: goto 48
      // 47: athrow
      // 48: goto 4c
      // 4b: bipush 0
      // 4c: ireturn
   }

   static float λ(boolean param0, Item param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 2
      // 02: iload 0
      // 03: iload 2
      // 04: ifne 16
      // 07: ifeq 1e
      // 0a: goto 0e
      // 0d: athrow
      // 0e: aload 1
      // 0f: instanceof net/minecraft/item/ItemSword
      // 12: goto 16
      // 15: athrow
      // 16: ifeq 1e
      // 19: fconst_1
      // 1a: goto 21
      // 1d: athrow
      // 1e: ldc_w 0.2
      // 21: freturn
   }

   static boolean â(Packet<?> param0) {
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
      // 03: instanceof net/minecraft/network/play/client/C03PacketPlayer
      // 06: iload 1
      // 07: ifne 5e
      // 0a: ifne 5d
      // 0d: goto 11
      // 10: athrow
      // 11: aload 0
      // 12: instanceof net/minecraft/network/play/client/C02PacketUseEntity
      // 15: iload 1
      // 16: ifne 5e
      // 19: goto 1d
      // 1c: athrow
      // 1d: ifne 5d
      // 20: goto 24
      // 23: athrow
      // 24: aload 0
      // 25: instanceof net/minecraft/network/play/client/C0APacketAnimation
      // 28: iload 1
      // 29: ifne 5e
      // 2c: goto 30
      // 2f: athrow
      // 30: ifne 5d
      // 33: goto 37
      // 36: athrow
      // 37: aload 0
      // 38: instanceof net/minecraft/network/play/client/C0BPacketEntityAction
      // 3b: iload 1
      // 3c: ifne 5e
      // 3f: goto 43
      // 42: athrow
      // 43: ifne 5d
      // 46: goto 4a
      // 49: athrow
      // 4a: aload 0
      // 4b: instanceof net/minecraft/network/play/client/C0FPacketConfirmTransaction
      // 4e: iload 1
      // 4f: ifne 5e
      // 52: goto 56
      // 55: athrow
      // 56: ifeq 61
      // 59: goto 5d
      // 5c: athrow
      // 5d: bipush 1
      // 5e: goto 62
      // 61: bipush 0
      // 62: ireturn
   }

   static C08PacketPlayerBlockPlacement į(ItemStack var0) {
      return new C08PacketPlayerBlockPlacement(new BlockPos(-1, -1, -1), 174356432 ^ 174356271, var0, 0.0F, 0.0F, 0.0F);
   }

   private boolean җ() {
      boolean var1 = false;
      int var2 = -628112501 ^ 667969343;

      while (true) {
         switch (var2) {
            case -1974384975:
               return true;
            case -981056907:
               int var10000;
               label57: {
                  label56: {
                     try {
                        var10000 = oc69da1aa7f5.ő.thePlayer.getHeldItem().getItem() instanceof ItemSword;
                        if (var1) {
                           break label57;
                        }

                        if (var10000 == 0) {
                           break label56;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var2 = -1384046194 ^ 667969343;
                     if (!var1) {
                        break;
                     }
                  }

                  var10000 = 276868346 ^ 667969343;
               }

               var2 = var10000;
               if (!var1) {
                  break;
               }
            case -44063564:
               int var5;
               label44: {
                  label43: {
                     try {
                        var5 = Π.ǭ();
                        if (var1) {
                           break label44;
                        }

                        if (var5 == 0) {
                           break label43;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = 545083972 ^ 667969343;
                     if (!var1) {
                        break;
                     }
                  }

                  var5 = 276868346 ^ 667969343;
               }

               var2 = var5;
               if (!var1) {
                  break;
               }

               return true;
            case 128791931:
               if (oc69da1aa7f5.ő.thePlayer.getHeldItem() != null) {
                  var2 = -497670838 ^ 667969343;
                  if (!var1) {
                     break;
                  }
               }

               var2 = 276868346 ^ 667969343;
               break;
            case 928041925:
               return false;
            default:
               throw null;
         }
      }
   }

   private boolean Ԛ() {
      Item var2 = null;
      int var3 = -1924081700 ^ -1078042140;
      boolean var1 = false;

      while (true) {
         label143:
         while (true) {
            label141:
            while (true) {
               switch (var3) {
                  case -2097905931:
                     break;
                  case -1300306750:
                     return false;
                  case -1232376129:
                     return true;
                  case -866154884:
                     break label143;
                  case 3581458:
                     break label141;
                  case 593838858:
                     int var10;
                     label83: {
                        label82: {
                           try {
                              var10 = oc69da1aa7f5.ő.thePlayer.isUsingItem();
                              if (var1) {
                                 break label83;
                              }

                              if (var10 == 0) {
                                 break label82;
                              }
                           } catch (ocbde1165e4e var4) {
                              throw var4;
                           }

                           var3 = 1944184728 ^ -1078042140;
                           if (!var1) {
                              continue;
                           }
                        }

                        var10 = -384465237 ^ -1078042140;
                     }

                     var3 = var10;
                     continue;
                  case 854505016:
                     if (oc69da1aa7f5.ő.thePlayer != null) {
                        var3 = -1663360274 ^ -1078042140;
                        if (!var1) {
                           continue;
                        }
                     }

                     var3 = -384465237 ^ -1078042140;
                     if (!var1) {
                        continue;
                     }
                  case -1162171948:
                     int var10000;
                     label128: {
                        label127: {
                           try {
                              var10000 = var2 instanceof ItemPotion;
                              if (var1) {
                                 break label128;
                              }

                              if (var10000 == 0) {
                                 break label127;
                              }
                           } catch (ocbde1165e4e var8) {
                              throw var8;
                           }

                           var3 = 154472283 ^ -1078042140;
                           if (!var1) {
                              continue;
                           }
                        }

                        var10000 = 230720806 ^ -1078042140;
                     }

                     var3 = var10000;
                     if (!var1) {
                        continue;
                     }
                  case 1654040296:
                     int var9;
                     label118: {
                        label117: {
                           try {
                              var9 = ĝ();
                              if (var1) {
                                 break label118;
                              }

                              if (var9 != 0) {
                                 break label117;
                              }
                           } catch (ocbde1165e4e var7) {
                              throw var7;
                           }

                           var3 = -384465237 ^ -1078042140;
                           if (!var1) {
                              continue;
                           }
                        }

                        var9 = 1028267793 ^ -1078042140;
                     }

                     var3 = var9;
                     if (!var1) {
                        continue;
                     }
                     break;
                  case 1454106447:
                     return false;
                  default:
                     throw null;
               }

               var2 = oc69da1aa7f5.ő.thePlayer.getHeldItem().getItem();

               label107: {
                  label106: {
                     try {
                        if (var1) {
                           break label107;
                        }

                        if (var2 instanceof ItemFood) {
                           break label106;
                        }
                     } catch (ocbde1165e4e var6) {
                        throw var6;
                     }

                     var3 = 84199472 ^ -1078042140;
                     if (!var1) {
                        continue;
                     }
                  }

                  var3 = 154472283 ^ -1078042140;
               }

               if (var1) {
                  break;
               }
            }

            int var11;
            label97: {
               label96: {
                  try {
                     var11 = Ʈ.ǭ();
                     if (var1) {
                        break label97;
                     }

                     if (var11 == 0) {
                        break label96;
                     }
                  } catch (ocbde1165e4e var5) {
                     throw var5;
                  }

                  var3 = -584530164 ^ -1078042140;
                  if (!var1) {
                     continue;
                  }
               }

               var11 = -384465237 ^ -1078042140;
            }

            var3 = var11;
            if (var1) {
               break;
            }
         }

         if (oc69da1aa7f5.ő.thePlayer.getHeldItem() != null) {
            var3 = -1081554954 ^ -1078042140;
            if (!var1) {
               continue;
            }
         }

         var3 = -384465237 ^ -1078042140;
         if (var1) {
            return false;
         }
      }
   }

   private void ũ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: aload 0
      // 02: aload 0
      // 03: invokevirtual x/oc4557683e94.Ԛ ()Z
      // 06: putfield x/oc4557683e94.Ŀ Z
      // 09: istore 1
      // 0a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 10: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isUsingItem ()Z
      // 13: iload 1
      // 14: ifne 21
      // 17: ifeq 5f
      // 1a: goto 1e
      // 1d: athrow
      // 1e: invokestatic x/oc4557683e94.ĝ ()Z
      // 21: iload 1
      // 22: ifne 34
      // 25: ifeq 5f
      // 28: goto 2c
      // 2b: athrow
      // 2c: aload 0
      // 2d: getfield x/oc4557683e94.ʮ I
      // 30: goto 34
      // 33: athrow
      // 34: iload 1
      // 35: ifne 52
      // 38: ldc_w -1762854972
      // 3b: ldc_w -1762854962
      // 3e: ixor
      // 3f: if_icmple 5f
      // 42: goto 46
      // 45: athrow
      // 46: bipush 0
      // 47: bipush 1
      // 48: bipush 1
      // 49: bipush 0
      // 4a: bipush 0
      // 4b: invokestatic x/oc5dd058ac50.ȸ (ZZZZZ)Z
      // 4e: goto 52
      // 51: athrow
      // 52: ifne 5f
      // 55: getstatic x/ocdd342096f8.f Lnet/minecraft/entity/EntityLivingBase;
      // 58: ifnull 61
      // 5b: goto 5f
      // 5e: athrow
      // 5f: return
      // 60: athrow
      // 61: aload 0
      // 62: iload 1
      // 63: ifne 75
      // 66: invokevirtual x/oc4557683e94.җ ()Z
      // 69: ifeq 78
      // 6c: goto 70
      // 6f: athrow
      // 70: aload 0
      // 71: goto 75
      // 74: athrow
      // 75: invokevirtual x/oc4557683e94.Η ()V
      // 78: return
   }

   private void Η() {
      this.ŋ();
      oc69da1aa7f5.ő.thePlayer.sendQueue.addToSendQueue(new C08PacketPlayerBlockPlacement(oc69da1aa7f5.ő.thePlayer.getHeldItem()));
   }

   static C07PacketPlayerDigging ɟ() {
      return new C07PacketPlayerDigging(Action.RELEASE_USE_ITEM, BlockPos.ORIGIN, EnumFacing.UP);
   }

   private void ŋ() {
      int var1 = oc69da1aa7f5.ő.thePlayer.inventory.currentItem;
      oc69da1aa7f5.ő.thePlayer.sendQueue.addToSendQueue(new C09PacketHeldItemChange(var1 % (512979443 ^ 512979451) + 1));
      oc69da1aa7f5.ő.thePlayer.sendQueue.addToSendQueue(new C09PacketHeldItemChange(var1));
   }

   static float Ѹ(int var0) {
      try {
         if (var0 == 0) {
            return 1.0F;
         }
      } catch (ocbde1165e4e var1) {
         throw var1;
      }

      return 0.2F;
   }

   @oc66fa4f2195
   public void Ķ(ocbab3c9954b var1) {
      this.ǒ();
   }

   private void Հ() {
      this.A.Ɲ();
      this.ƨ.ȱ();
      յ = 0;
      this.Ŀ = false;
   }

   private void ǒ() {
      this.Ӕ = null;
      this.ŷ = null;
      this.ʮ = 0;
      this.d = -1;
      this.Հ();
   }

   private void ԣ() {
      int var2 = (int)հ.Ӂ();
      boolean var1 = false;

      int var10000;
      label22: {
         label21: {
            try {
               var10000 = var2;
               if (var1) {
                  break label22;
               }

               if (var2 == 0) {
                  break label21;
               }
            } catch (ocbde1165e4e var4) {
               throw var4;
            }

            var10000 = 0;
            break label22;
         }

         var10000 = 1;
      }

      int var3 = var10000;
      this.ӫ.ȉ((boolean)var3, this);
      Ƹ.ȉ((boolean)var3, this);
   }

   public ocfa8b80a093 ƕ() {
      return this.ƨ;
   }

   @Override
   public String getInfo() {
      int var1 = Math.max(0, Math.min((int)հ.Ӂ(), Џ.length - 1));
      return Џ[var1];
   }

   static {
      String[] var10000 = new String[250273127 ^ 250273122];
      var10000[0] = "Vanilla";
      var10000[1] = "Intave";
      var10000[250273120 ^ 250273122] = "GrimSemi";
      var10000[250273121 ^ 250273122] = "GrimTest";
      var10000[250273126 ^ 250273122] = "Blink";
      Џ = var10000;
   }
}

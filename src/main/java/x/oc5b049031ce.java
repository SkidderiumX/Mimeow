package x;

import java.lang.reflect.Field;
import java.util.Random;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Slot;

public class oc5b049031ce extends oc69da1aa7f5 {
   public oca9cc61aada Ù;
   public occ2f8dff8d8 ē;
   public occ2f8dff8d8 e;
   public occ2f8dff8d8 Ğ;
   public occ2f8dff8d8 Э;
   public occ2f8dff8d8 ƀ;
   public occ2f8dff8d8 λ;
   public oca9cc61aada Ž;
   private occc831eff22 Ǻ;
   private long Ƶ;
   private long Л;
   private boolean ì;
   private Random ø;
   private static Field ϩ;
   public static boolean Ǩ;

   public oc5b049031ce() {
      super("AutoClicker", oce4cea752dd.ȁ, 0);
      this.ą("Automatically click while the left mouse button is pressed.");
      this.ʌ(this.Ù = new oca9cc61aada("Target CPS", 10.0, 1.0, 20.0, 0.5));
      this.ʌ(this.ē = new occ2f8dff8d8("Simulate exhaust", true));
      this.ʌ(this.Ǻ = new occc831eff22("Condition"));
      this.ʌ(this.e = new occ2f8dff8d8(this.Ǻ, "Not using item", false));
      this.ʌ(this.Э = new occ2f8dff8d8(this.Ǻ, "Weapon only", false));
      this.ʌ(this.ƀ = new occ2f8dff8d8(this.Ǻ, "Disable in creative", false));
      this.ʌ(this.Ğ = new occ2f8dff8d8("Break blocks", false));
      this.ʌ(this.λ = new occ2f8dff8d8("Inventory", false));
      this.ʌ(this.Ž = new oca9cc61aada("Start delay", "ms", 100.0, 0.0, 250.0, 10.0));
      this.ɮ = true;
   }

   @Override
   public String getInfo() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: aload 0
      // 04: getfield x/oc5b049031ce.Ù Lx/oca9cc61aada;
      // 07: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0a: dstore 2
      // 0b: istore 1
      // 0c: dload 2
      // 0d: iload 1
      // 0e: ifne 2b
      // 11: dload 2
      // 12: invokestatic java/lang/Math.rint (D)D
      // 15: dcmpl
      // 16: ifne 26
      // 19: goto 1d
      // 1c: athrow
      // 1d: dload 2
      // 1e: d2i
      // 1f: invokestatic java/lang/Integer.toString (I)Ljava/lang/String;
      // 22: goto 2e
      // 25: athrow
      // 26: dload 2
      // 27: bipush 1
      // 28: invokestatic x/oc7ab2161b9f.ɜ (DI)D
      // 2b: invokestatic java/lang/Double.toString (D)Ljava/lang/String;
      // 2e: areturn
   }

   public double Ț() {
      return this.Ù.Ӂ();
   }

   @Override
   public void onEnable() {
      this.ø = new Random();
      this.Ƶ = 0L;
      this.Л = 0L;
      this.ì = false;
      Ӵ();
   }

   @Override
   public void onDisable() {
      this.Ƶ = 0L;
      this.Л = 0L;
      this.ì = false;
   }

   @oc66fa4f2195
   public void Ϊ(ocf923d5a814 param1) {
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
      // 005: getfield x/ocb508b4e274.Ұ Lx/oc110d7f376c;
      // 008: getstatic x/oc110d7f376c.END Lx/oc110d7f376c;
      // 00b: if_acmpeq 010
      // 00e: return
      // 00f: athrow
      // 010: aload 0
      // 011: getfield x/oc5b049031ce.λ Lx/occ2f8dff8d8;
      // 014: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 017: iload 2
      // 018: ifne 026
      // 01b: ifne 023
      // 01e: goto 022
      // 021: athrow
      // 022: return
      // 023: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 026: iload 2
      // 027: ifne 03b
      // 02a: ifne 032
      // 02d: goto 031
      // 030: athrow
      // 031: return
      // 032: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 035: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 038: instanceof net/minecraft/client/gui/inventory/GuiContainer
      // 03b: iload 2
      // 03c: ifne 051
      // 03f: ifne 04d
      // 042: goto 046
      // 045: athrow
      // 046: aload 0
      // 047: lconst_0
      // 048: putfield x/oc5b049031ce.Л J
      // 04b: return
      // 04c: athrow
      // 04d: bipush 0
      // 04e: invokestatic org/lwjgl/input/Mouse.isButtonDown (I)Z
      // 051: ifne 05b
      // 054: aload 0
      // 055: lconst_0
      // 056: putfield x/oc5b049031ce.Л J
      // 059: return
      // 05a: athrow
      // 05b: invokestatic x/oc5b049031ce.Ӵ ()V
      // 05e: getstatic x/oc5b049031ce.ϩ Ljava/lang/reflect/Field;
      // 061: ifnonnull 066
      // 064: return
      // 065: athrow
      // 066: invokestatic java/lang/System.currentTimeMillis ()J
      // 069: lstore 3
      // 06a: aload 0
      // 06b: getfield x/oc5b049031ce.Л J
      // 06e: lconst_0
      // 06f: lcmp
      // 070: iload 2
      // 071: ifne 08e
      // 074: ifne 08d
      // 077: goto 07b
      // 07a: athrow
      // 07b: aload 0
      // 07c: lload 3
      // 07d: aload 0
      // 07e: getfield x/oc5b049031ce.Ž Lx/oca9cc61aada;
      // 081: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 084: d2l
      // 085: ladd
      // 086: putfield x/oc5b049031ce.Л J
      // 089: goto 08d
      // 08c: athrow
      // 08d: bipush 0
      // 08e: istore 5
      // 090: aload 0
      // 091: getfield x/oc5b049031ce.Л J
      // 094: lload 3
      // 095: lcmp
      // 096: ifgt 0b5
      // 099: iinc 5 1
      // 09c: iload 2
      // 09d: ifne 0bc
      // 0a0: aload 0
      // 0a1: dup
      // 0a2: getfield x/oc5b049031ce.Л J
      // 0a5: aload 0
      // 0a6: invokevirtual x/oc5b049031ce.μ ()J
      // 0a9: ladd
      // 0aa: putfield x/oc5b049031ce.Л J
      // 0ad: iload 2
      // 0ae: ifeq 090
      // 0b1: goto 0b5
      // 0b4: athrow
      // 0b5: iload 5
      // 0b7: ifgt 0bc
      // 0ba: return
      // 0bb: athrow
      // 0bc: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0bf: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 0c2: checkcast net/minecraft/client/gui/inventory/GuiContainer
      // 0c5: astore 6
      // 0c7: aload 6
      // 0c9: invokestatic x/oc5b049031ce.š (Lnet/minecraft/client/gui/inventory/GuiContainer;)Lnet/minecraft/inventory/Slot;
      // 0cc: astore 7
      // 0ce: aload 7
      // 0d0: iload 2
      // 0d1: ifne 0dd
      // 0d4: ifnull 0eb
      // 0d7: goto 0db
      // 0da: athrow
      // 0db: aload 7
      // 0dd: getfield net/minecraft/inventory/Slot.slotNumber I
      // 0e0: iload 2
      // 0e1: ifne 0f4
      // 0e4: ifge 0ec
      // 0e7: goto 0eb
      // 0ea: athrow
      // 0eb: return
      // 0ec: aload 6
      // 0ee: getfield net/minecraft/client/gui/inventory/GuiContainer.inventorySlots Lnet/minecraft/inventory/Container;
      // 0f1: getfield net/minecraft/inventory/Container.windowId I
      // 0f4: istore 8
      // 0f6: aload 7
      // 0f8: getfield net/minecraft/inventory/Slot.slotNumber I
      // 0fb: istore 9
      // 0fd: invokestatic net/minecraft/client/gui/GuiScreen.isShiftKeyDown ()Z
      // 100: iload 2
      // 101: ifne 10c
      // 104: ifeq 10f
      // 107: goto 10b
      // 10a: athrow
      // 10b: bipush 1
      // 10c: goto 110
      // 10f: bipush 0
      // 110: istore 10
      // 112: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 115: iload 2
      // 116: ifne 12a
      // 119: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 11c: ifnull 130
      // 11f: goto 123
      // 122: athrow
      // 123: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 126: goto 12a
      // 129: athrow
      // 12a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 12d: ifnonnull 132
      // 130: return
      // 131: athrow
      // 132: bipush 0
      // 133: istore 11
      // 135: iload 11
      // 137: iload 5
      // 139: if_icmpge 15a
      // 13c: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 13f: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 142: iload 8
      // 144: iload 9
      // 146: bipush 0
      // 147: iload 10
      // 149: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 14c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 14f: invokevirtual net/minecraft/client/multiplayer/PlayerControllerMP.windowClick (IIIILnet/minecraft/entity/player/EntityPlayer;)Lnet/minecraft/item/ItemStack;
      // 152: pop
      // 153: iload 2
      // 154: iinc 11 1
      // 157: ifeq 135
      // 15a: return
   }

   @oc66fa4f2195
   public void ɞ(oca27090789a param1) {
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
      // 007: ifne 00c
      // 00a: return
      // 00b: athrow
      // 00c: getstatic x/oc9755810e45.ÿ Lx/ocdd342096f8;
      // 00f: iload 2
      // 010: ifne 01d
      // 013: ifnull 02f
      // 016: goto 01a
      // 019: athrow
      // 01a: getstatic x/oc9755810e45.ÿ Lx/ocdd342096f8;
      // 01d: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 020: ifeq 02f
      // 023: getstatic x/ocdd342096f8.f Lnet/minecraft/entity/EntityLivingBase;
      // 026: ifnull 02f
      // 029: goto 02d
      // 02c: athrow
      // 02d: return
      // 02e: athrow
      // 02f: getstatic x/oc9755810e45.Ԏ Lx/oce3cc81daa8;
      // 032: iload 2
      // 033: ifne 040
      // 036: ifnull 04f
      // 039: goto 03d
      // 03c: athrow
      // 03d: getstatic x/oc9755810e45.Ԏ Lx/oce3cc81daa8;
      // 040: invokevirtual x/oce3cc81daa8.Λ ()Z
      // 043: iload 2
      // 044: ifne 05b
      // 047: ifeq 04f
      // 04a: goto 04e
      // 04d: athrow
      // 04e: return
      // 04f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 052: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 055: getfield net/minecraft/client/settings/GameSettings.keyBindAttack Lnet/minecraft/client/settings/KeyBinding;
      // 058: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // 05b: istore 3
      // 05c: iload 2
      // 05d: ifne 2a3
      // 060: bipush 0
      // 061: invokestatic org/lwjgl/input/Mouse.isButtonDown (I)Z
      // 064: ifeq 290
      // 067: goto 06b
      // 06a: athrow
      // 06b: invokestatic java/lang/System.currentTimeMillis ()J
      // 06e: lstore 4
      // 070: aload 0
      // 071: getfield x/oc5b049031ce.Ƶ J
      // 074: lconst_0
      // 075: lcmp
      // 076: iload 2
      // 077: ifne 091
      // 07a: ifne 090
      // 07d: goto 081
      // 080: athrow
      // 081: aload 0
      // 082: lload 4
      // 084: aload 0
      // 085: invokevirtual x/oc5b049031ce.μ ()J
      // 088: ladd
      // 089: putfield x/oc5b049031ce.Ƶ J
      // 08c: goto 090
      // 08f: athrow
      // 090: bipush 0
      // 091: istore 6
      // 093: aload 0
      // 094: getfield x/oc5b049031ce.Ƶ J
      // 097: lload 4
      // 099: lcmp
      // 09a: ifgt 0b9
      // 09d: iinc 6 1
      // 0a0: iload 2
      // 0a1: ifne 0e4
      // 0a4: aload 0
      // 0a5: dup
      // 0a6: getfield x/oc5b049031ce.Ƶ J
      // 0a9: aload 0
      // 0aa: invokevirtual x/oc5b049031ce.μ ()J
      // 0ad: ladd
      // 0ae: putfield x/oc5b049031ce.Ƶ J
      // 0b1: iload 2
      // 0b2: ifeq 093
      // 0b5: goto 0b9
      // 0b8: athrow
      // 0b9: aload 0
      // 0ba: iload 2
      // 0bb: ifne 0e5
      // 0be: getfield x/oc5b049031ce.e Lx/occ2f8dff8d8;
      // 0c1: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0c4: ifeq 0e4
      // 0c7: goto 0cb
      // 0ca: athrow
      // 0cb: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0ce: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0d1: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isUsingItem ()Z
      // 0d4: iload 2
      // 0d5: ifne 0eb
      // 0d8: goto 0dc
      // 0db: athrow
      // 0dc: ifeq 0e4
      // 0df: goto 0e3
      // 0e2: athrow
      // 0e3: return
      // 0e4: aload 0
      // 0e5: getfield x/oc5b049031ce.ƀ Lx/occ2f8dff8d8;
      // 0e8: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0eb: iload 2
      // 0ec: ifne 10e
      // 0ef: ifeq 112
      // 0f2: goto 0f6
      // 0f5: athrow
      // 0f6: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0f9: iload 2
      // 0fa: ifne 115
      // 0fd: goto 101
      // 100: athrow
      // 101: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 104: getfield net/minecraft/client/entity/EntityPlayerSP.capabilities Lnet/minecraft/entity/player/PlayerCapabilities;
      // 107: getfield net/minecraft/entity/player/PlayerCapabilities.isCreativeMode Z
      // 10a: goto 10e
      // 10d: athrow
      // 10e: ifeq 112
      // 111: return
      // 112: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 115: iload 2
      // 116: ifne 12a
      // 119: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 11c: ifnonnull 138
      // 11f: goto 123
      // 122: athrow
      // 123: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 126: goto 12a
      // 129: athrow
      // 12a: getfield net/minecraft/client/Minecraft.inGameHasFocus Z
      // 12d: iload 2
      // 12e: ifne 148
      // 131: ifne 139
      // 134: goto 138
      // 137: athrow
      // 138: return
      // 139: aload 0
      // 13a: iload 2
      // 13b: ifne 15f
      // 13e: getfield x/oc5b049031ce.Э Lx/occ2f8dff8d8;
      // 141: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 144: goto 148
      // 147: athrow
      // 148: ifeq 15e
      // 14b: invokestatic x/oc7ab2161b9f.Ȓ ()Z
      // 14e: iload 2
      // 14f: ifne 165
      // 152: goto 156
      // 155: athrow
      // 156: ifne 15e
      // 159: goto 15d
      // 15c: athrow
      // 15d: return
      // 15e: aload 0
      // 15f: getfield x/oc5b049031ce.Ğ Lx/occ2f8dff8d8;
      // 162: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 165: iload 2
      // 166: ifne 26c
      // 169: ifeq 26b
      // 16c: goto 170
      // 16f: athrow
      // 170: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 173: iload 2
      // 174: ifne 1bc
      // 177: goto 17b
      // 17a: athrow
      // 17b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 17e: getfield net/minecraft/client/entity/EntityPlayerSP.capabilities Lnet/minecraft/entity/player/PlayerCapabilities;
      // 181: getfield net/minecraft/entity/player/PlayerCapabilities.allowEdit Z
      // 184: ifne 1b5
      // 187: goto 18b
      // 18a: athrow
      // 18b: aload 0
      // 18c: getfield x/oc5b049031ce.ì Z
      // 18f: iload 2
      // 190: ifne 26c
      // 193: goto 197
      // 196: athrow
      // 197: ifeq 26b
      // 19a: goto 19e
      // 19d: athrow
      // 19e: iload 3
      // 19f: bipush 0
      // 1a0: invokestatic net/minecraft/client/settings/KeyBinding.setKeyBindState (IZ)V
      // 1a3: iload 2
      // 1a4: bipush 0
      // 1a5: bipush 0
      // 1a6: invokestatic x/ReflectionUtils.setButton (IZ)V
      // 1a9: aload 0
      // 1aa: bipush 0
      // 1ab: putfield x/oc5b049031ce.ì Z
      // 1ae: ifeq 26b
      // 1b1: goto 1b5
      // 1b4: athrow
      // 1b5: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1b8: goto 1bc
      // 1bb: athrow
      // 1bc: iload 2
      // 1bd: ifne 1d1
      // 1c0: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 1c3: ifnull 26b
      // 1c6: goto 1ca
      // 1c9: athrow
      // 1ca: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1cd: goto 1d1
      // 1d0: athrow
      // 1d1: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 1d4: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 1d7: astore 7
      // 1d9: aload 7
      // 1db: ifnull 262
      // 1de: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1e1: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 1e4: aload 7
      // 1e6: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 1e9: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 1ee: astore 8
      // 1f0: aload 8
      // 1f2: iload 2
      // 1f3: ifne 206
      // 1f6: getstatic net/minecraft/init/Blocks.air Lnet/minecraft/block/Block;
      // 1f9: if_acmpeq 23b
      // 1fc: goto 200
      // 1ff: athrow
      // 200: aload 8
      // 202: goto 206
      // 205: athrow
      // 206: instanceof net/minecraft/block/BlockLiquid
      // 209: iload 2
      // 20a: ifne 247
      // 20d: ifne 23b
      // 210: goto 214
      // 213: athrow
      // 214: aload 0
      // 215: iload 2
      // 216: ifne 236
      // 219: goto 21d
      // 21c: athrow
      // 21d: getfield x/oc5b049031ce.ì Z
      // 220: ifne 23a
      // 223: goto 227
      // 226: athrow
      // 227: iload 3
      // 228: bipush 1
      // 229: invokestatic net/minecraft/client/settings/KeyBinding.setKeyBindState (IZ)V
      // 22c: bipush 0
      // 22d: bipush 1
      // 22e: invokestatic x/ReflectionUtils.setButton (IZ)V
      // 231: aload 0
      // 232: goto 236
      // 235: athrow
      // 236: bipush 1
      // 237: putfield x/oc5b049031ce.ì Z
      // 23a: return
      // 23b: aload 0
      // 23c: iload 2
      // 23d: ifne 259
      // 240: getfield x/oc5b049031ce.ì Z
      // 243: goto 247
      // 246: athrow
      // 247: ifeq 25e
      // 24a: iload 3
      // 24b: bipush 0
      // 24c: invokestatic net/minecraft/client/settings/KeyBinding.setKeyBindState (IZ)V
      // 24f: bipush 0
      // 250: bipush 0
      // 251: invokestatic x/ReflectionUtils.setButton (IZ)V
      // 254: aload 0
      // 255: goto 259
      // 258: athrow
      // 259: bipush 0
      // 25a: putfield x/oc5b049031ce.ì Z
      // 25d: return
      // 25e: iload 2
      // 25f: ifeq 26b
      // 262: aload 0
      // 263: bipush 0
      // 264: putfield x/oc5b049031ce.ì Z
      // 267: goto 26b
      // 26a: athrow
      // 26b: bipush 0
      // 26c: istore 7
      // 26e: iload 7
      // 270: iload 6
      // 272: if_icmpge 28c
      // 275: iload 2
      // 276: ifne 2a8
      // 279: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 27c: invokeinterface x/oc8ecfa69e1b.callClickMouse ()V 1
      // 281: iload 2
      // 282: iinc 7 1
      // 285: ifeq 26e
      // 288: goto 28c
      // 28b: athrow
      // 28c: iload 2
      // 28d: ifeq 2a8
      // 290: aload 0
      // 291: lconst_0
      // 292: putfield x/oc5b049031ce.Ƶ J
      // 295: aload 0
      // 296: bipush 0
      // 297: putfield x/oc5b049031ce.ì Z
      // 29a: iload 3
      // 29b: bipush 0
      // 29c: invokestatic net/minecraft/client/settings/KeyBinding.setKeyBindState (IZ)V
      // 29f: goto 2a3
      // 2a2: athrow
      // 2a3: bipush 0
      // 2a4: bipush 0
      // 2a5: invokestatic x/ReflectionUtils.setButton (IZ)V
      // 2a8: return
   }

   private long μ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc5e549848f3.İ I
      // 003: bipush 1
      // 004: aload 0
      // 005: getfield x/oc5b049031ce.Ù Lx/oca9cc61aada;
      // 008: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 00b: d2i
      // 00c: invokestatic java/lang/Math.max (II)I
      // 00f: istore 2
      // 010: istore 1
      // 011: ldc_w -295765896
      // 014: ldc_w -295765104
      // 017: ixor
      // 018: iload 2
      // 019: idiv
      // 01a: istore 3
      // 01b: aload 0
      // 01c: getfield x/oc5b049031ce.ē Lx/occ2f8dff8d8;
      // 01f: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 022: iload 1
      // 023: ifne 15f
      // 026: ifeq 143
      // 029: goto 02d
      // 02c: athrow
      // 02d: aload 0
      // 02e: getfield x/oc5b049031ce.ø Ljava/util/Random;
      // 031: iload 3
      // 032: bipush 1
      // 033: iadd
      // 034: invokevirtual java/util/Random.nextInt (I)I
      // 037: iload 3
      // 038: ldc_w -295765102
      // 03b: ldc_w -295765104
      // 03e: ixor
      // 03f: idiv
      // 040: isub
      // 041: istore 5
      // 043: iload 3
      // 044: iload 5
      // 046: iadd
      // 047: istore 4
      // 049: aload 0
      // 04a: getfield x/oc5b049031ce.ø Ljava/util/Random;
      // 04d: iload 1
      // 04e: ifne 0bd
      // 051: ldc_w -295765004
      // 054: ldc_w -295765104
      // 057: ixor
      // 058: invokevirtual java/util/Random.nextInt (I)I
      // 05b: ldc_w -295765089
      // 05e: ldc_w -295765104
      // 061: ixor
      // 062: if_icmpge 0b9
      // 065: goto 069
      // 068: athrow
      // 069: aload 0
      // 06a: getfield x/oc5b049031ce.ø Ljava/util/Random;
      // 06d: invokevirtual java/util/Random.nextBoolean ()Z
      // 070: iload 1
      // 071: ifne 0b7
      // 074: goto 078
      // 077: athrow
      // 078: ifeq 09b
      // 07b: goto 07f
      // 07e: athrow
      // 07f: ldc_w -295765111
      // 082: ldc_w -295765104
      // 085: ixor
      // 086: aload 0
      // 087: getfield x/oc5b049031ce.ø Ljava/util/Random;
      // 08a: ldc_w -295765120
      // 08d: ldc_w -295765104
      // 090: ixor
      // 091: invokevirtual java/util/Random.nextInt (I)I
      // 094: iadd
      // 095: istore 4
      // 097: iload 1
      // 098: ifeq 0b9
      // 09b: iload 3
      // 09c: ldc_w -295765086
      // 09f: ldc_w -295765104
      // 0a2: ixor
      // 0a3: iadd
      // 0a4: aload 0
      // 0a5: getfield x/oc5b049031ce.ø Ljava/util/Random;
      // 0a8: ldc_w -295765063
      // 0ab: ldc_w -295765104
      // 0ae: ixor
      // 0af: invokevirtual java/util/Random.nextInt (I)I
      // 0b2: iadd
      // 0b3: goto 0b7
      // 0b6: athrow
      // 0b7: istore 4
      // 0b9: aload 0
      // 0ba: getfield x/oc5b049031ce.ø Ljava/util/Random;
      // 0bd: ldc_w -295765004
      // 0c0: ldc_w -295765104
      // 0c3: ixor
      // 0c4: iload 1
      // 0c5: ifne 10b
      // 0c8: invokevirtual java/util/Random.nextInt (I)I
      // 0cb: ldc_w -295765096
      // 0ce: ldc_w -295765104
      // 0d1: ixor
      // 0d2: if_icmpge 100
      // 0d5: goto 0d9
      // 0d8: athrow
      // 0d9: ldc_w -295765086
      // 0dc: ldc_w -295765104
      // 0df: ixor
      // 0e0: aload 0
      // 0e1: getfield x/oc5b049031ce.ø Ljava/util/Random;
      // 0e4: ldc_w -295765241
      // 0e7: ldc_w -295765104
      // 0ea: ixor
      // 0eb: invokevirtual java/util/Random.nextInt (I)I
      // 0ee: iadd
      // 0ef: istore 6
      // 0f1: iload 4
      // 0f3: iload 6
      // 0f5: imul
      // 0f6: ldc_w -295765004
      // 0f9: ldc_w -295765104
      // 0fc: ixor
      // 0fd: idiv
      // 0fe: istore 4
      // 100: aload 0
      // 101: getfield x/oc5b049031ce.ø Ljava/util/Random;
      // 104: ldc_w -295765004
      // 107: ldc_w -295765104
      // 10a: ixor
      // 10b: invokevirtual java/util/Random.nextInt (I)I
      // 10e: iload 1
      // 10f: ifne 13d
      // 112: ldc_w -295765094
      // 115: ldc_w -295765104
      // 118: ixor
      // 119: if_icmpge 13f
      // 11c: goto 120
      // 11f: athrow
      // 120: iload 4
      // 122: ldc_w -295765094
      // 125: ldc_w -295765104
      // 128: ixor
      // 129: aload 0
      // 12a: getfield x/oc5b049031ce.ø Ljava/util/Random;
      // 12d: ldc_w -295765110
      // 130: ldc_w -295765104
      // 133: ixor
      // 134: invokevirtual java/util/Random.nextInt (I)I
      // 137: iadd
      // 138: iadd
      // 139: goto 13d
      // 13c: athrow
      // 13d: istore 4
      // 13f: iload 1
      // 140: ifeq 161
      // 143: iload 3
      // 144: aload 0
      // 145: getfield x/oc5b049031ce.ø Ljava/util/Random;
      // 148: ldc_w -295765115
      // 14b: ldc_w -295765104
      // 14e: ixor
      // 14f: invokevirtual java/util/Random.nextInt (I)I
      // 152: ldc_w -295765094
      // 155: ldc_w -295765104
      // 158: ixor
      // 159: isub
      // 15a: iadd
      // 15b: goto 15f
      // 15e: athrow
      // 15f: istore 4
      // 161: ldc_w -295765071
      // 164: ldc_w -295765104
      // 167: ixor
      // 168: ldc_w -295765212
      // 16b: ldc_w -295765104
      // 16e: ixor
      // 16f: iload 4
      // 171: invokestatic java/lang/Math.min (II)I
      // 174: invokestatic java/lang/Math.max (II)I
      // 177: i2l
      // 178: lreturn
   }

   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static void Ӵ() {
      int var0 = oc5e549848f3.İ;

      label38: {
         Field var10000;
         label37: {
            try {
               var10000 = ϩ;
               if (var0 != 0) {
                  break label37;
               }

               if (ϩ != null) {
                  return;
               }
            } catch (NoSuchFieldException var6) {
               throw var6;
            }

            try {
               ϩ = GuiContainer.class.getDeclaredField("theSlot");
               var10000 = ϩ;
            } catch (NoSuchFieldException var5) {
               break label38;
            }
         }

         try {
            var10000.setAccessible(true);
            return;
         } catch (NoSuchFieldException var4) {
         }
      }

      try {
         ϩ = GuiContainer.class.getDeclaredField("field_147006_u");
         ϩ.setAccessible(true);
      } catch (NoSuchFieldException var3) {
         ϩ = null;
      }
   }

   private static Slot š(GuiContainer param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 1
      // 04: getstatic x/oc5b049031ce.ϩ Ljava/lang/reflect/Field;
      // 07: ifnull 1a
      // 0a: aload 0
      // 0b: iload 1
      // 0c: ifne 24
      // 0f: goto 13
      // 12: athrow
      // 13: ifnonnull 1d
      // 16: goto 1a
      // 19: athrow
      // 1a: aconst_null
      // 1b: areturn
      // 1c: athrow
      // 1d: getstatic x/oc5b049031ce.ϩ Ljava/lang/reflect/Field;
      // 20: aload 0
      // 21: invokevirtual java/lang/reflect/Field.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 24: astore 2
      // 25: aload 2
      // 26: iload 1
      // 27: ifne 39
      // 2a: instanceof net/minecraft/inventory/Slot
      // 2d: ifeq 3d
      // 30: goto 34
      // 33: athrow
      // 34: aload 2
      // 35: goto 39
      // 38: athrow
      // 39: checkcast net/minecraft/inventory/Slot
      // 3c: areturn
      // 3d: goto 41
      // 40: astore 2
      // 41: aconst_null
      // 42: areturn
   }
}

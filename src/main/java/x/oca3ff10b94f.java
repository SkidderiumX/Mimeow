package x;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.block.BlockButton;
import net.minecraft.block.BlockLever;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldSettings.GameType;

public class oca3ff10b94f extends oc69da1aa7f5 {
   private static final EnumFacing[] Զ;
   private static final EnumFacing[] ʕ;
   private static final EnumFacing[] Ƭ;
   private static final int ϯ = 20;
   private static final int Ґ = 3;
   private static final int ԝ = 5;
   private static final long Ɔ = 125L;
   private final oca9cc61aada ń;
   private final ocb23d192a35 Ή;
   private final occ2f8dff8d8 g;
   private final occ2f8dff8d8 ѵ;
   private final occ2f8dff8d8 ç;
   private final occ2f8dff8d8 і;
   private final oc2ec6a95e5c в;
   private final Deque<BlockPos> ʩ = new ArrayDeque<>();
   private final Set<BlockPos> ӗ = new HashSet<>();
   private final Set<BlockPos> Հ = new HashSet<>();
   private boolean ʎ;
   private boolean ʳ;
   private EntityPlayerSP x;
   private int ѡ = -1;
   private int ʂ = -1;
   private BlockPos Ê;
   private EnumFacing[] ɍ;
   private List<BlockPos> ճ;
   private oc6af2ed7814 ʰ;
   private boolean Ѝ;
   private int ӫ = -1;
   private float Ĕ;
   private float R;
   private int л;
   private int Ʃ;
   private boolean ƙ = true;
   private Vec3 ʱ;
   private BlockPos Π;
   private int Ǐ;
   private String ͼ;
   private int ȣ;
   private long Ү;
   private long Ӝ;
   public static int ԛ;

   public oca3ff10b94f() {
      super("BlockIn", oce4cea752dd.з);
      this.ą("Automatically enclose yourself with blocks.");
      this.ʌ(this.ń = new oca9cc61aada("Delay", "ticks", 1.0, 0.0, 20.0, 0.5));
      this.ʌ(this.Ή = new ocb23d192a35("Select Keybind", 0));
      this.ʌ(this.g = new occ2f8dff8d8("Disable when complete", false));
      this.ʌ(this.ѵ = new occ2f8dff8d8("Show percentage", true));
      this.ʌ(this.ç = new occ2f8dff8d8("Skip near bed", true));
      this.ʌ(this.і = new occ2f8dff8d8("Ignore blocks", false));
      this.ʌ(this.в = new oc2ec6a95e5c("Items"));
      this.ɮ = true;
   }

   @Override
   public void onDisable() {
      this.Ѽ();
      this.ʳ = false;
      this.ͼ = null;
      this.ʱ = null;
      this.Π = null;
      this.Ǐ = 0;
   }

   @Override
   public void z$2u87utkr1isxg() {
      this.в.ȉ(this.і.ǭ(), this);
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGH
   )
   public void Ң(oc86de9e2892 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: aload 0
      // 004: bipush 0
      // 005: putfield x/oca3ff10b94f.Ѝ Z
      // 008: istore 2
      // 009: aload 0
      // 00a: iload 2
      // 00b: ifne 037
      // 00e: invokevirtual x/oca3ff10b94f.Ր ()Z
      // 011: ifne 01e
      // 014: goto 018
      // 017: athrow
      // 018: aload 0
      // 019: invokevirtual x/oca3ff10b94f.Ѽ ()V
      // 01c: return
      // 01d: athrow
      // 01e: aload 0
      // 01f: iload 2
      // 020: ifne 08c
      // 023: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 026: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 029: getfield net/minecraft/client/settings/GameSettings.keyBindAttack Lnet/minecraft/client/settings/KeyBinding;
      // 02c: invokevirtual net/minecraft/client/settings/KeyBinding.isKeyDown ()Z
      // 02f: invokevirtual x/oca3ff10b94f.Ҧ (Z)V
      // 032: aload 0
      // 033: goto 037
      // 036: athrow
      // 037: getfield x/oca3ff10b94f.ʳ Z
      // 03a: ifne 08b
      // 03d: aload 0
      // 03e: iload 2
      // 03f: ifne 08c
      // 042: goto 046
      // 045: athrow
      // 046: invokevirtual x/oca3ff10b94f.β ()Z
      // 049: ifne 08b
      // 04c: goto 050
      // 04f: athrow
      // 050: getstatic x/ocb5d5ed49ea.ҋ Z
      // 053: iload 2
      // 054: ifne 065
      // 057: goto 05b
      // 05a: athrow
      // 05b: ifne 08b
      // 05e: goto 062
      // 061: athrow
      // 062: getstatic x/ocb5d5ed49ea.ƃ Z
      // 065: iload 2
      // 066: ifne 080
      // 069: ifne 08b
      // 06c: goto 070
      // 06f: athrow
      // 070: aload 1
      // 071: aload 0
      // 072: ldc_w -1904551495
      // 075: ldc_w -1904551859
      // 078: ixor
      // 079: invokevirtual x/oc86de9e2892.ǰ (Ljava/lang/Object;I)Z
      // 07c: goto 080
      // 07f: athrow
      // 080: iload 2
      // 081: ifne 09c
      // 084: ifne 090
      // 087: goto 08b
      // 08a: athrow
      // 08b: aload 0
      // 08c: invokevirtual x/oca3ff10b94f.Ѽ ()V
      // 08f: return
      // 090: aload 0
      // 091: iload 2
      // 092: ifne 0c1
      // 095: getfield x/oca3ff10b94f.ʎ Z
      // 098: goto 09c
      // 09b: athrow
      // 09c: ifeq 0c0
      // 09f: aload 0
      // 0a0: iload 2
      // 0a1: ifne 0c1
      // 0a4: goto 0a8
      // 0a7: athrow
      // 0a8: getfield x/oca3ff10b94f.x Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0ab: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0ae: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0b1: if_acmpeq 0c0
      // 0b4: goto 0b8
      // 0b7: athrow
      // 0b8: aload 0
      // 0b9: invokevirtual x/oca3ff10b94f.Ѽ ()V
      // 0bc: goto 0c0
      // 0bf: athrow
      // 0c0: aload 0
      // 0c1: iload 2
      // 0c2: ifne 0e5
      // 0c5: getfield x/oca3ff10b94f.ʎ Z
      // 0c8: ifne 0e4
      // 0cb: goto 0cf
      // 0ce: athrow
      // 0cf: aload 0
      // 0d0: iload 2
      // 0d1: ifne 0e5
      // 0d4: goto 0d8
      // 0d7: athrow
      // 0d8: invokevirtual x/oca3ff10b94f.ь ()Z
      // 0db: ifne 0e4
      // 0de: goto 0e2
      // 0e1: athrow
      // 0e2: return
      // 0e3: athrow
      // 0e4: aload 0
      // 0e5: iload 2
      // 0e6: ifne 0fa
      // 0e9: invokevirtual x/oca3ff10b94f.Ֆ ()Z
      // 0ec: ifne 0f9
      // 0ef: goto 0f3
      // 0f2: athrow
      // 0f3: aload 0
      // 0f4: invokevirtual x/oca3ff10b94f.Ѽ ()V
      // 0f7: return
      // 0f8: athrow
      // 0f9: aload 0
      // 0fa: invokevirtual x/oca3ff10b94f.ƶ ()Lnet/minecraft/util/BlockPos;
      // 0fd: astore 3
      // 0fe: iload 2
      // 0ff: ifne 12b
      // 102: aload 3
      // 103: aload 0
      // 104: getfield x/oca3ff10b94f.Ê Lnet/minecraft/util/BlockPos;
      // 107: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 10a: ifne 11e
      // 10d: goto 111
      // 110: athrow
      // 111: aload 0
      // 112: invokevirtual x/oca3ff10b94f.Ϊ ()V
      // 115: aload 0
      // 116: aload 3
      // 117: putfield x/oca3ff10b94f.Ê Lnet/minecraft/util/BlockPos;
      // 11a: goto 11e
      // 11d: athrow
      // 11e: aload 0
      // 11f: getfield x/oca3ff10b94f.Հ Ljava/util/Set;
      // 122: invokeinterface java/util/Set.clear ()V 1
      // 127: aload 0
      // 128: invokevirtual x/oca3ff10b94f.ŧ ()V
      // 12b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 12e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 131: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 134: astore 4
      // 136: bipush 0
      // 137: istore 5
      // 139: iload 5
      // 13b: ldc_w -1904551864
      // 13e: ldc_w -1904551859
      // 141: ixor
      // 142: if_icmpge 2f4
      // 145: aload 0
      // 146: iload 2
      // 147: ifne 180
      // 14a: getfield x/oca3ff10b94f.ʰ Lx/oc6af2ed7814;
      // 14d: ifnull 16e
      // 150: goto 154
      // 153: athrow
      // 154: aload 0
      // 155: aload 0
      // 156: iload 2
      // 157: ifne 1a1
      // 15a: goto 15e
      // 15d: athrow
      // 15e: getfield x/oca3ff10b94f.ʰ Lx/oc6af2ed7814;
      // 161: getfield x/oc6af2ed7814.η Lnet/minecraft/util/BlockPos;
      // 164: invokevirtual x/oca3ff10b94f.ƿ (Lnet/minecraft/util/BlockPos;)Z
      // 167: ifne 19f
      // 16a: goto 16e
      // 16d: athrow
      // 16e: aload 0
      // 16f: iload 2
      // 170: ifne 1a0
      // 173: goto 177
      // 176: athrow
      // 177: aconst_null
      // 178: putfield x/oca3ff10b94f.ʰ Lx/oc6af2ed7814;
      // 17b: aload 0
      // 17c: goto 180
      // 17f: athrow
      // 180: aload 4
      // 182: invokevirtual x/oca3ff10b94f.ż (Lnet/minecraft/item/ItemStack;)Z
      // 185: ifne 19f
      // 188: aload 0
      // 189: iload 2
      // 18a: ifne 1a0
      // 18d: goto 191
      // 190: athrow
      // 191: aload 4
      // 193: invokevirtual x/oca3ff10b94f.Ҹ (Lnet/minecraft/item/ItemStack;)Z
      // 196: ifne 19f
      // 199: goto 19d
      // 19c: athrow
      // 19d: return
      // 19e: athrow
      // 19f: aload 0
      // 1a0: aload 0
      // 1a1: getfield x/oca3ff10b94f.ʰ Lx/oc6af2ed7814;
      // 1a4: getfield x/oc6af2ed7814.η Lnet/minecraft/util/BlockPos;
      // 1a7: aload 0
      // 1a8: getfield x/oca3ff10b94f.ʰ Lx/oc6af2ed7814;
      // 1ab: getfield x/oc6af2ed7814.ѱ Lnet/minecraft/util/BlockPos;
      // 1ae: aload 0
      // 1af: getfield x/oca3ff10b94f.ʰ Lx/oc6af2ed7814;
      // 1b2: getfield x/oc6af2ed7814.ƥ Lnet/minecraft/util/EnumFacing;
      // 1b5: aload 4
      // 1b7: invokevirtual x/oca3ff10b94f.Ɇ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;Lnet/minecraft/item/ItemStack;)Lx/oc6af2ed7814;
      // 1ba: astore 6
      // 1bc: iload 2
      // 1bd: ifne 1df
      // 1c0: aload 6
      // 1c2: ifnonnull 1d5
      // 1c5: goto 1c9
      // 1c8: athrow
      // 1c9: aload 0
      // 1ca: invokevirtual x/oca3ff10b94f.ɻ ()V
      // 1cd: iload 2
      // 1ce: ifeq 2ed
      // 1d1: goto 1d5
      // 1d4: athrow
      // 1d5: aload 0
      // 1d6: aload 6
      // 1d8: putfield x/oca3ff10b94f.ʰ Lx/oc6af2ed7814;
      // 1db: goto 1df
      // 1de: athrow
      // 1df: aload 6
      // 1e1: getfield x/oc6af2ed7814.Ȳ F
      // 1e4: aload 0
      // 1e5: getfield x/oca3ff10b94f.Ĕ F
      // 1e8: invokestatic x/ocbb165642ef.ȥ (FF)F
      // 1eb: fstore 7
      // 1ed: aload 0
      // 1ee: getfield x/oca3ff10b94f.Ʃ I
      // 1f1: iload 2
      // 1f2: ifne 205
      // 1f5: aload 0
      // 1f6: getfield x/oca3ff10b94f.л I
      // 1f9: if_icmpge 208
      // 1fc: goto 200
      // 1ff: athrow
      // 200: bipush 1
      // 201: goto 205
      // 204: athrow
      // 205: goto 209
      // 208: bipush 0
      // 209: istore 8
      // 20b: iload 8
      // 20d: iload 2
      // 20e: ifne 222
      // 211: ifeq 22c
      // 214: goto 218
      // 217: athrow
      // 218: aload 0
      // 219: getfield x/oca3ff10b94f.Ʃ I
      // 21c: bipush 1
      // 21d: iadd
      // 21e: goto 222
      // 221: athrow
      // 222: i2f
      // 223: aload 0
      // 224: getfield x/oca3ff10b94f.л I
      // 227: i2f
      // 228: fdiv
      // 229: goto 22d
      // 22c: fconst_1
      // 22d: fstore 9
      // 22f: iload 2
      // 230: aload 0
      // 231: getfield x/oca3ff10b94f.Ĕ F
      // 234: fload 7
      // 236: aload 0
      // 237: getfield x/oca3ff10b94f.Ĕ F
      // 23a: fsub
      // 23b: fload 9
      // 23d: fmul
      // 23e: fadd
      // 23f: aload 0
      // 240: getfield x/oca3ff10b94f.R F
      // 243: aload 6
      // 245: getfield x/oc6af2ed7814.Ɵ F
      // 248: aload 0
      // 249: getfield x/oca3ff10b94f.R F
      // 24c: fsub
      // 24d: fload 9
      // 24f: fmul
      // 250: fadd
      // 251: getstatic x/oc75d51ec7eb.d [F
      // 254: bipush 0
      // 255: faload
      // 256: getstatic x/oc75d51ec7eb.d [F
      // 259: bipush 1
      // 25a: faload
      // 25b: invokestatic x/oc75d51ec7eb.Ĩ (FFFF)[F
      // 25e: astore 10
      // 260: ifne 28f
      // 263: aload 1
      // 264: aload 0
      // 265: ldc_w -1904551495
      // 268: ldc_w -1904551859
      // 26b: ixor
      // 26c: aload 10
      // 26e: bipush 0
      // 26f: faload
      // 270: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 273: aload 10
      // 275: bipush 1
      // 276: faload
      // 277: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 27a: invokevirtual x/oc86de9e2892.л (Ljava/lang/Object;ILjava/lang/Float;Ljava/lang/Float;)Z
      // 27d: ifne 28a
      // 280: goto 284
      // 283: athrow
      // 284: aload 0
      // 285: invokevirtual x/oca3ff10b94f.Ѽ ()V
      // 288: return
      // 289: athrow
      // 28a: aload 1
      // 28b: bipush 1
      // 28c: invokevirtual x/oc86de9e2892.ʐ (Z)V
      // 28f: iload 8
      // 291: iload 2
      // 292: ifne 2ac
      // 295: ifeq 2aa
      // 298: goto 29c
      // 29b: athrow
      // 29c: aload 0
      // 29d: dup
      // 29e: getfield x/oca3ff10b94f.Ʃ I
      // 2a1: bipush 1
      // 2a2: iadd
      // 2a3: putfield x/oca3ff10b94f.Ʃ I
      // 2a6: goto 2aa
      // 2a9: athrow
      // 2aa: iload 8
      // 2ac: iload 2
      // 2ad: ifne 2d3
      // 2b0: ifne 2ec
      // 2b3: goto 2b7
      // 2b6: athrow
      // 2b7: aload 0
      // 2b8: iload 2
      // 2b9: ifne 2e0
      // 2bc: goto 2c0
      // 2bf: athrow
      // 2c0: aload 0
      // 2c1: aload 10
      // 2c3: bipush 0
      // 2c4: faload
      // 2c5: aload 10
      // 2c7: bipush 1
      // 2c8: faload
      // 2c9: invokevirtual x/oca3ff10b94f.қ (FF)Lnet/minecraft/util/MovingObjectPosition;
      // 2cc: invokevirtual x/oca3ff10b94f.һ (Lnet/minecraft/util/MovingObjectPosition;)Z
      // 2cf: goto 2d3
      // 2d2: athrow
      // 2d3: ifeq 2ec
      // 2d6: aload 0
      // 2d7: bipush 1
      // 2d8: putfield x/oca3ff10b94f.Ѝ Z
      // 2db: aload 0
      // 2dc: goto 2e0
      // 2df: athrow
      // 2e0: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 2e3: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 2e6: getfield net/minecraft/client/entity/EntityPlayerSP.ticksExisted I
      // 2e9: putfield x/oca3ff10b94f.ӫ I
      // 2ec: return
      // 2ed: iinc 5 1
      // 2f0: iload 2
      // 2f1: ifeq 139
      // 2f4: return
   }

   @oc66fa4f2195
   public void ѻ(oc2f61de30bc param1) {
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
      // 06: ifne 2a
      // 09: invokevirtual x/oca3ff10b94f.Ր ()Z
      // 0c: ifne 19
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: invokevirtual x/oca3ff10b94f.Ѽ ()V
      // 17: return
      // 18: athrow
      // 19: aload 0
      // 1a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1d: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 20: getfield net/minecraft/client/settings/GameSettings.keyBindAttack Lnet/minecraft/client/settings/KeyBinding;
      // 23: invokevirtual net/minecraft/client/settings/KeyBinding.isKeyDown ()Z
      // 26: invokevirtual x/oca3ff10b94f.Ҧ (Z)V
      // 29: aload 0
      // 2a: iload 2
      // 2b: ifne 3f
      // 2e: invokevirtual x/oca3ff10b94f.β ()Z
      // 31: ifeq 3e
      // 34: goto 38
      // 37: athrow
      // 38: aload 0
      // 39: invokevirtual x/oca3ff10b94f.Ѽ ()V
      // 3c: return
      // 3d: athrow
      // 3e: aload 0
      // 3f: iload 2
      // 40: ifne 52
      // 43: getfield x/oca3ff10b94f.ʎ Z
      // 46: ifeq 55
      // 49: goto 4d
      // 4c: athrow
      // 4d: aload 0
      // 4e: goto 52
      // 51: athrow
      // 52: invokevirtual x/oca3ff10b94f.ȩ ()V
      // 55: return
   }

   @oc66fa4f2195
   public void Բ(oc0e4b758d9a param1) {
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
      // 006: ifne 023
      // 009: getfield x/oca3ff10b94f.Ѝ Z
      // 00c: ifne 015
      // 00f: goto 013
      // 012: athrow
      // 013: return
      // 014: athrow
      // 015: aload 0
      // 016: bipush 0
      // 017: putfield x/oca3ff10b94f.Ѝ Z
      // 01a: iload 2
      // 01b: ifne 070
      // 01e: aload 0
      // 01f: goto 023
      // 022: athrow
      // 023: invokevirtual x/oca3ff10b94f.Ր ()Z
      // 026: ifeq 068
      // 029: aload 0
      // 02a: iload 2
      // 02b: ifne 06d
      // 02e: goto 032
      // 031: athrow
      // 032: getfield x/oca3ff10b94f.ʳ Z
      // 035: ifne 068
      // 038: goto 03c
      // 03b: athrow
      // 03c: aload 0
      // 03d: iload 2
      // 03e: ifne 06d
      // 041: goto 045
      // 044: athrow
      // 045: invokevirtual x/oca3ff10b94f.β ()Z
      // 048: ifne 068
      // 04b: goto 04f
      // 04e: athrow
      // 04f: aload 0
      // 050: iload 2
      // 051: ifne 072
      // 054: goto 058
      // 057: athrow
      // 058: getfield x/oca3ff10b94f.x Lnet/minecraft/client/entity/EntityPlayerSP;
      // 05b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 05e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 061: if_acmpeq 071
      // 064: goto 068
      // 067: athrow
      // 068: aload 0
      // 069: goto 06d
      // 06c: athrow
      // 06d: invokevirtual x/oca3ff10b94f.Ѽ ()V
      // 070: return
      // 071: aload 0
      // 072: iload 2
      // 073: ifne 085
      // 076: getfield x/oca3ff10b94f.ʎ Z
      // 079: ifeq 10e
      // 07c: goto 080
      // 07f: athrow
      // 080: aload 0
      // 081: goto 085
      // 084: athrow
      // 085: iload 2
      // 086: ifne 098
      // 089: getfield x/oca3ff10b94f.ʰ Lx/oc6af2ed7814;
      // 08c: ifnull 10e
      // 08f: goto 093
      // 092: athrow
      // 093: aload 0
      // 094: goto 098
      // 097: athrow
      // 098: getfield x/oca3ff10b94f.ӫ I
      // 09b: iload 2
      // 09c: ifne 0ba
      // 09f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0a2: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0a5: getfield net/minecraft/client/entity/EntityPlayerSP.ticksExisted I
      // 0a8: if_icmpne 10e
      // 0ab: goto 0af
      // 0ae: athrow
      // 0af: invokestatic x/ocbb165642ef.ʨ ()Lx/ocbb165642ef;
      // 0b2: aload 0
      // 0b3: invokevirtual x/ocbb165642ef.D (Ljava/lang/Object;)Z
      // 0b6: goto 0ba
      // 0b9: athrow
      // 0ba: iload 2
      // 0bb: ifne 0c8
      // 0be: ifeq 10e
      // 0c1: goto 0c5
      // 0c4: athrow
      // 0c5: getstatic x/ocb5d5ed49ea.ҋ Z
      // 0c8: iload 2
      // 0c9: ifne 0d6
      // 0cc: ifne 10e
      // 0cf: goto 0d3
      // 0d2: athrow
      // 0d3: getstatic x/ocb5d5ed49ea.ƃ Z
      // 0d6: iload 2
      // 0d7: ifne 0e4
      // 0da: ifne 10e
      // 0dd: goto 0e1
      // 0e0: athrow
      // 0e1: getstatic x/ocb5d5ed49ea.Ӿ Z
      // 0e4: iload 2
      // 0e5: ifne 107
      // 0e8: ifne 10e
      // 0eb: goto 0ef
      // 0ee: athrow
      // 0ef: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0f2: iload 2
      // 0f3: ifne 113
      // 0f6: goto 0fa
      // 0f9: athrow
      // 0fa: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0fd: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 100: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 103: goto 107
      // 106: athrow
      // 107: aload 0
      // 108: getfield x/oca3ff10b94f.ʂ I
      // 10b: if_icmpeq 110
      // 10e: return
      // 10f: athrow
      // 110: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 113: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 116: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 119: astore 3
      // 11a: iload 2
      // 11b: ifne 167
      // 11e: aload 0
      // 11f: aload 3
      // 120: invokevirtual x/oca3ff10b94f.Π (Lnet/minecraft/item/ItemStack;)Z
      // 123: ifeq 15e
      // 126: goto 12a
      // 129: athrow
      // 12a: aload 0
      // 12b: iload 2
      // 12c: ifne 163
      // 12f: goto 133
      // 132: athrow
      // 133: aload 0
      // 134: getfield x/oca3ff10b94f.ʰ Lx/oc6af2ed7814;
      // 137: getfield x/oc6af2ed7814.η Lnet/minecraft/util/BlockPos;
      // 13a: invokevirtual x/oca3ff10b94f.ƿ (Lnet/minecraft/util/BlockPos;)Z
      // 13d: ifeq 15e
      // 140: goto 144
      // 143: athrow
      // 144: aload 0
      // 145: iload 2
      // 146: ifne 169
      // 149: goto 14d
      // 14c: athrow
      // 14d: aload 0
      // 14e: getfield x/oca3ff10b94f.ʰ Lx/oc6af2ed7814;
      // 151: getfield x/oc6af2ed7814.ѱ Lnet/minecraft/util/BlockPos;
      // 154: invokevirtual x/oca3ff10b94f.ʃ (Lnet/minecraft/util/BlockPos;)Z
      // 157: ifne 168
      // 15a: goto 15e
      // 15d: athrow
      // 15e: aload 0
      // 15f: goto 163
      // 162: athrow
      // 163: aconst_null
      // 164: putfield x/oca3ff10b94f.ʰ Lx/oc6af2ed7814;
      // 167: return
      // 168: aload 0
      // 169: getstatic x/oc75d51ec7eb.d [F
      // 16c: bipush 0
      // 16d: faload
      // 16e: getstatic x/oc75d51ec7eb.d [F
      // 171: bipush 1
      // 172: faload
      // 173: invokevirtual x/oca3ff10b94f.қ (FF)Lnet/minecraft/util/MovingObjectPosition;
      // 176: astore 4
      // 178: iload 2
      // 179: ifne 1b3
      // 17c: aload 0
      // 17d: aload 4
      // 17f: invokevirtual x/oca3ff10b94f.һ (Lnet/minecraft/util/MovingObjectPosition;)Z
      // 182: ifeq 1ab
      // 185: goto 189
      // 188: athrow
      // 189: aload 0
      // 18a: aload 3
      // 18b: aload 0
      // 18c: getfield x/oca3ff10b94f.ʰ Lx/oc6af2ed7814;
      // 18f: getfield x/oc6af2ed7814.ѱ Lnet/minecraft/util/BlockPos;
      // 192: aload 0
      // 193: getfield x/oca3ff10b94f.ʰ Lx/oc6af2ed7814;
      // 196: getfield x/oc6af2ed7814.ƥ Lnet/minecraft/util/EnumFacing;
      // 199: invokevirtual x/oca3ff10b94f.Κ (Lnet/minecraft/item/ItemStack;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;)Z
      // 19c: iload 2
      // 19d: ifne 1e5
      // 1a0: goto 1a4
      // 1a3: athrow
      // 1a4: ifne 1b4
      // 1a7: goto 1ab
      // 1aa: athrow
      // 1ab: aload 0
      // 1ac: invokevirtual x/oca3ff10b94f.ɻ ()V
      // 1af: goto 1b3
      // 1b2: athrow
      // 1b3: return
      // 1b4: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1b7: iload 2
      // 1b8: ifne 1eb
      // 1bb: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 1be: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1c1: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1c4: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1c7: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 1ca: aload 3
      // 1cb: aload 0
      // 1cc: getfield x/oca3ff10b94f.ʰ Lx/oc6af2ed7814;
      // 1cf: getfield x/oc6af2ed7814.ѱ Lnet/minecraft/util/BlockPos;
      // 1d2: aload 0
      // 1d3: getfield x/oca3ff10b94f.ʰ Lx/oc6af2ed7814;
      // 1d6: getfield x/oc6af2ed7814.ƥ Lnet/minecraft/util/EnumFacing;
      // 1d9: aload 4
      // 1db: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 1de: invokevirtual net/minecraft/client/multiplayer/PlayerControllerMP.onPlayerRightClick (Lnet/minecraft/client/entity/EntityPlayerSP;Lnet/minecraft/client/multiplayer/WorldClient;Lnet/minecraft/item/ItemStack;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;Lnet/minecraft/util/Vec3;)Z
      // 1e1: goto 1e5
      // 1e4: athrow
      // 1e5: ifeq 25a
      // 1e8: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1eb: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1ee: invokevirtual net/minecraft/client/entity/EntityPlayerSP.swingItem ()V
      // 1f1: iload 2
      // 1f2: ifne 256
      // 1f5: aload 0
      // 1f6: getfield x/oca3ff10b94f.ճ Ljava/util/List;
      // 1f9: ifnull 24d
      // 1fc: goto 200
      // 1ff: athrow
      // 200: aload 0
      // 201: iload 2
      // 202: ifne 253
      // 205: goto 209
      // 208: athrow
      // 209: getfield x/oca3ff10b94f.ճ Ljava/util/List;
      // 20c: invokeinterface java/util/List.isEmpty ()Z 1
      // 211: ifne 24d
      // 214: goto 218
      // 217: athrow
      // 218: aload 0
      // 219: iload 2
      // 21a: ifne 253
      // 21d: goto 221
      // 220: athrow
      // 221: getfield x/oca3ff10b94f.ճ Ljava/util/List;
      // 224: bipush 0
      // 225: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 22a: checkcast net/minecraft/util/BlockPos
      // 22d: aload 0
      // 22e: getfield x/oca3ff10b94f.ʰ Lx/oc6af2ed7814;
      // 231: getfield x/oc6af2ed7814.η Lnet/minecraft/util/BlockPos;
      // 234: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 237: ifeq 24d
      // 23a: goto 23e
      // 23d: athrow
      // 23e: aload 0
      // 23f: getfield x/oca3ff10b94f.ճ Ljava/util/List;
      // 242: bipush 0
      // 243: invokeinterface java/util/List.remove (I)Ljava/lang/Object; 2
      // 248: pop
      // 249: goto 24d
      // 24c: athrow
      // 24d: aload 0
      // 24e: aconst_null
      // 24f: putfield x/oca3ff10b94f.ʰ Lx/oc6af2ed7814;
      // 252: aload 0
      // 253: invokevirtual x/oca3ff10b94f.ȩ ()V
      // 256: iload 2
      // 257: ifeq 262
      // 25a: aload 0
      // 25b: invokevirtual x/oca3ff10b94f.ɻ ()V
      // 25e: goto 262
      // 261: athrow
      // 262: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGHEST
   )
   public void ř(oca27090789a param1) {
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
      // 06: ifne 18
      // 09: getfield x/oca3ff10b94f.ʎ Z
      // 0c: ifeq 39
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: iload 2
      // 19: ifne 2b
      // 1c: invokevirtual x/oca3ff10b94f.Ր ()Z
      // 1f: ifeq 39
      // 22: goto 26
      // 25: athrow
      // 26: aload 0
      // 27: goto 2b
      // 2a: athrow
      // 2b: invokevirtual x/oca3ff10b94f.β ()Z
      // 2e: ifne 39
      // 31: aload 1
      // 32: invokevirtual x/oca27090789a.ʜ ()V
      // 35: goto 39
      // 38: athrow
      // 39: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGHEST
   )
   public void й(MouseEvent param1) {
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
      // 06: ifne 18
      // 09: getfield x/oca3ff10b94f.ʎ Z
      // 0c: ifeq 51
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: invokevirtual x/oca3ff10b94f.έ ()Z
      // 1b: iload 2
      // 1c: ifne 36
      // 1f: ifeq 51
      // 22: goto 26
      // 25: athrow
      // 26: aload 1
      // 27: iload 2
      // 28: ifne 3a
      // 2b: goto 2f
      // 2e: athrow
      // 2f: getfield x/MouseEvent.buttonstate Z
      // 32: goto 36
      // 35: athrow
      // 36: ifeq 51
      // 39: aload 1
      // 3a: iload 2
      // 3b: ifne 4d
      // 3e: getfield x/MouseEvent.button I
      // 41: ifle 51
      // 44: goto 48
      // 47: athrow
      // 48: aload 1
      // 49: goto 4d
      // 4c: athrow
      // 4d: bipush 1
      // 4e: invokevirtual x/oc68d6b191af.setCanceled (Z)V
      // 51: return
   }

   @oc66fa4f2195
   public void Ͱ(ocbab3c9954b var1) {
      this.onDisable();
   }

   @oc66fa4f2195
   public void ų(ocf923d5a814 param1) {
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
      // 00b: if_acmpne 046
      // 00e: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 011: ifeq 046
      // 014: goto 018
      // 017: athrow
      // 018: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 01b: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 01e: ifnonnull 046
      // 021: goto 025
      // 024: athrow
      // 025: aload 0
      // 026: iload 2
      // 027: ifne 040
      // 02a: goto 02e
      // 02d: athrow
      // 02e: getfield x/oca3ff10b94f.ѵ Lx/occ2f8dff8d8;
      // 031: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 034: ifeq 046
      // 037: goto 03b
      // 03a: athrow
      // 03b: aload 0
      // 03c: goto 040
      // 03f: athrow
      // 040: getfield x/oca3ff10b94f.ͼ Ljava/lang/String;
      // 043: ifnonnull 048
      // 046: return
      // 047: athrow
      // 048: invokestatic java/lang/System.currentTimeMillis ()J
      // 04b: aload 0
      // 04c: iload 2
      // 04d: ifne 063
      // 050: getfield x/oca3ff10b94f.ʎ Z
      // 053: ifeq 062
      // 056: goto 05a
      // 059: athrow
      // 05a: aload 0
      // 05b: getfield x/oca3ff10b94f.Ү J
      // 05e: goto 066
      // 061: athrow
      // 062: aload 0
      // 063: getfield x/oca3ff10b94f.Ӝ J
      // 066: lsub
      // 067: lstore 3
      // 068: lload 3
      // 069: l2f
      // 06a: ldc_w 125.0
      // 06d: fdiv
      // 06e: fconst_0
      // 06f: fconst_1
      // 070: invokestatic net/minecraft/util/MathHelper.clamp_float (FFF)F
      // 073: fstore 5
      // 075: ldc_w 240.0
      // 078: aload 0
      // 079: getfield x/oca3ff10b94f.ʎ Z
      // 07c: ifeq 085
      // 07f: fload 5
      // 081: goto 089
      // 084: athrow
      // 085: fconst_1
      // 086: fload 5
      // 088: fsub
      // 089: fmul
      // 08a: f2i
      // 08b: istore 6
      // 08d: iload 6
      // 08f: iload 2
      // 090: ifne 0aa
      // 093: ifgt 0b3
      // 096: goto 09a
      // 099: athrow
      // 09a: aload 0
      // 09b: iload 2
      // 09c: ifne 0ae
      // 09f: goto 0a3
      // 0a2: athrow
      // 0a3: getfield x/oca3ff10b94f.ʎ Z
      // 0a6: goto 0aa
      // 0a9: athrow
      // 0aa: ifne 0b2
      // 0ad: aload 0
      // 0ae: aconst_null
      // 0af: putfield x/oca3ff10b94f.ͼ Ljava/lang/String;
      // 0b2: return
      // 0b3: new net/minecraft/client/gui/ScaledResolution
      // 0b6: dup
      // 0b7: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0ba: invokespecial net/minecraft/client/gui/ScaledResolution.<init> (Lnet/minecraft/client/Minecraft;)V
      // 0bd: astore 7
      // 0bf: aload 7
      // 0c1: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledWidth ()I
      // 0c4: i2f
      // 0c5: fconst_2
      // 0c6: fdiv
      // 0c7: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0ca: getfield net/minecraft/client/Minecraft.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // 0cd: aload 0
      // 0ce: getfield x/oca3ff10b94f.ͼ Ljava/lang/String;
      // 0d1: invokevirtual net/minecraft/client/gui/FontRenderer.getStringWidth (Ljava/lang/String;)I
      // 0d4: i2f
      // 0d5: fconst_2
      // 0d6: fdiv
      // 0d7: fsub
      // 0d8: fstore 8
      // 0da: aload 7
      // 0dc: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledHeight ()I
      // 0df: i2f
      // 0e0: fconst_2
      // 0e1: fdiv
      // 0e2: ldc_w 11.0
      // 0e5: fadd
      // 0e6: fstore 9
      // 0e8: invokestatic net/minecraft/client/renderer/GlStateManager.enableBlend ()V
      // 0eb: ldc_w -1914562400
      // 0ee: ldc_w -1914561630
      // 0f1: ixor
      // 0f2: ldc_w -1914562399
      // 0f5: ldc_w -1914561630
      // 0f8: ixor
      // 0f9: bipush 1
      // 0fa: bipush 0
      // 0fb: invokestatic net/minecraft/client/renderer/GlStateManager.tryBlendFuncSeparate (IIII)V
      // 0fe: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 101: getfield net/minecraft/client/Minecraft.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // 104: aload 0
      // 105: getfield x/oca3ff10b94f.ͼ Ljava/lang/String;
      // 108: fload 8
      // 10a: fload 9
      // 10c: iload 6
      // 10e: ldc_w -1914561606
      // 111: ldc_w -1914561630
      // 114: ixor
      // 115: ishl
      // 116: aload 0
      // 117: getfield x/oca3ff10b94f.ȣ I
      // 11a: ldc_w -1927420835
      // 11d: ldc_w -1914561630
      // 120: ixor
      // 121: iand
      // 122: ior
      // 123: bipush 1
      // 124: invokevirtual net/minecraft/client/gui/FontRenderer.drawString (Ljava/lang/String;FFIZ)I
      // 127: pop
      // 128: invokestatic net/minecraft/client/renderer/GlStateManager.disableBlend ()V
      // 12b: return
   }

   boolean Ռ() {
      try {
         if (this.ͼ != null) {
            return true;
         }
      } catch (ocbde1165e4e var1) {
         throw var1;
      }

      return false;
   }

   public boolean ê() {
      return this.ʎ;
   }

   public boolean έ() {
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
      // 05: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 08: iload 1
      // 09: ifne 16
      // 0c: ifeq 40
      // 0f: goto 13
      // 12: athrow
      // 13: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 16: ifeq 40
      // 19: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1c: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 1f: ifnonnull 40
      // 22: goto 26
      // 25: athrow
      // 26: aload 0
      // 27: getfield x/oca3ff10b94f.Ή Lx/ocb23d192a35;
      // 2a: invokevirtual x/ocb23d192a35.Ɛ ()Z
      // 2d: iload 1
      // 2e: ifne 3d
      // 31: goto 35
      // 34: athrow
      // 35: ifeq 40
      // 38: goto 3c
      // 3b: athrow
      // 3c: bipush 1
      // 3d: goto 41
      // 40: bipush 0
      // 41: ireturn
   }

   private boolean Ր() {
      int var1 = oc84f20a0bc5.ė;
      int var2 = 2118505960 ^ 1541431275;

      while (true) {
         label186:
         while (true) {
            label180:
            while (true) {
               label178:
               while (true) {
                  label176:
                  while (true) {
                     switch (var2) {
                        case -2073843148:
                           break label178;
                        case -1614323227:
                           break label186;
                        case -1320700628:
                           if (oc69da1aa7f5.ő.theWorld != null) {
                              var2 = -1004061170 ^ 1541431275;
                              if (var1 == 0) {
                                 continue;
                              }
                           }

                           var2 = -1289848758 ^ 1541431275;
                           if (var1 == 0) {
                              continue;
                           }

                           return true;
                        case -1242206709:
                           return true;
                        case -1168425989:
                           return false;
                        case -1136421278:
                           if (oc69da1aa7f5.ő.playerController.getCurrentGameType() != GameType.ADVENTURE) {
                              var2 = 1193432986 ^ 1541431275;
                              if (var1 == 0) {
                                 continue;
                              }
                           }

                           var2 = -507812848 ^ 1541431275;
                           if (var1 == 0) {
                              continue;
                           }
                        case 1001050505:
                           int var10;
                           label148: {
                              label147: {
                                 try {
                                    var10 = this.Ή.Ɛ();
                                    if (var1 != 0) {
                                       break label148;
                                    }

                                    if (var10 != 0) {
                                       break label147;
                                    }
                                 } catch (ocbde1165e4e var6) {
                                    throw var6;
                                 }

                                 var2 = 570573175 ^ 1541431275;
                                 if (var1 == 0) {
                                    continue;
                                 }
                              }

                              var10 = -2133297137 ^ 1541431275;
                           }

                           var2 = var10;
                           if (var1 == 0) {
                              continue;
                           }
                           break;
                        case -385996895:
                           return false;
                        case -58593986:
                           if (oc69da1aa7f5.ő.currentScreen == null) {
                              var2 = 931318609 ^ 1541431275;
                              if (var1 == 0) {
                                 continue;
                              }
                           }

                           var2 = -507812848 ^ 1541431275;
                           if (var1 != 0) {
                              break label186;
                           }
                           continue;
                        case 482478193:
                           break label176;
                        case 631605763:
                           break;
                        case 854923919:
                           int var10000;
                           label159: {
                              label158: {
                                 try {
                                    var10000 = oc9755810e45.ǜ.z$3rzb3dil7uydr();
                                    if (var1 != 0) {
                                       break label159;
                                    }

                                    if (var10000 != 0) {
                                       break label158;
                                    }
                                 } catch (ocbde1165e4e var7) {
                                    throw var7;
                                 }

                                 var2 = -300600864 ^ 1541431275;
                                 if (var1 == 0) {
                                    continue;
                                 }
                              }

                              var10000 = -507812848 ^ 1541431275;
                           }

                           var2 = var10000;
                           if (var1 == 0) {
                              continue;
                           }
                        case -617076764:
                           int var8;
                           label139: {
                              label138: {
                                 try {
                                    var8 = this.z$3rzb3dil7uydr();
                                    if (var1 != 0) {
                                       break label139;
                                    }

                                    if (var8 == 0) {
                                       break label138;
                                    }
                                 } catch (ocbde1165e4e var5) {
                                    throw var5;
                                 }

                                 var2 = -1486769451 ^ 1541431275;
                                 if (var1 == 0) {
                                    continue;
                                 }
                              }

                              var8 = -507812848 ^ 1541431275;
                           }

                           var2 = var8;
                           if (var1 == 0) {
                              continue;
                           }
                           break label176;
                        case 1818399930:
                           break label180;
                        case 2044862108:
                           this.ʳ = false;
                           return false;
                        default:
                           throw null;
                     }

                     if (oc69da1aa7f5.ő.thePlayer != null) {
                        var2 = -358094137 ^ 1541431275;
                        if (var1 == 0) {
                           continue;
                        }
                     }

                     var2 = -1289848758 ^ 1541431275;
                     if (var1 != 0) {
                        break label178;
                     }
                  }

                  if (oc9755810e45.ǜ != null) {
                     var2 = 1763001700 ^ 1541431275;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var2 = -300600864 ^ 1541431275;
                  if (var1 != 0) {
                     break label180;
                  }
               }

               int var11;
               label120: {
                  label119: {
                     try {
                        var11 = oc69da1aa7f5.ő.playerController.isSpectatorMode();
                        if (var1 != 0) {
                           break label120;
                        }

                        if (var11 != 0) {
                           break label119;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var2 = -408696439 ^ 1541431275;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var11 = -507812848 ^ 1541431275;
               }

               var2 = var11;
               if (var1 != 0) {
                  return false;
               }
            }

            int var9;
            label111: {
               label110: {
                  try {
                     var9 = oc69da1aa7f5.ő.inGameHasFocus;
                     if (var1 != 0) {
                        break label111;
                     }

                     if (!oc69da1aa7f5.ő.inGameHasFocus) {
                        break label110;
                     }
                  } catch (ocbde1165e4e var3) {
                     throw var3;
                  }

                  var2 = -544999969 ^ 1541431275;
                  if (var1 == 0) {
                     continue;
                  }
               }

               var9 = -507812848 ^ 1541431275;
            }

            var2 = var9;
            if (var1 != 0) {
               return false;
            }
         }

         if (oc69da1aa7f5.ő.playerController == null) {
            var2 = -1289848758 ^ 1541431275;
            if (var1 == 0) {
               continue;
            }
         }

         var2 = 1615498850 ^ 1541431275;
      }
   }

   private boolean β() {
      int var1 = oc84f20a0bc5.ė;
      int var2 = 1675041585 ^ -486624838;

      while (true) {
         switch (var2) {
            case -1944628552:
               return true;
            case -1538278452:
               break;
            case 35573107:
               return false;
            case 370880682:
               int var7;
               label95: {
                  label94: {
                     try {
                        var7 = oc9755810e45.ϔ.Ƴ();
                        if (var1 != 0) {
                           break label95;
                        }

                        if (var7 != 0) {
                           break label94;
                        }
                     } catch (ocbde1165e4e var6) {
                        throw var6;
                     }

                     var2 = 1186007670 ^ -486624838;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var7 = 1860821762 ^ -486624838;
               }

               var2 = var7;
               if (var1 == 0) {
                  continue;
               }
            case -2127975797:
               int var8;
               label82: {
                  label81: {
                     try {
                        var8 = oc69da1aa7f5.ő.gameSettings.keyBindAttack.isKeyDown();
                        if (var1 != 0) {
                           break label82;
                        }

                        if (var8 != 0) {
                           break label81;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var2 = -1838458446 ^ -486624838;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var8 = 1860821762 ^ -486624838;
               }

               var2 = var8;
               if (var1 == 0) {
                  continue;
               }

               return true;
            case 580357154:
               int var10000;
               label73: {
                  label72: {
                     try {
                        var10000 = oc69da1aa7f5.ő.playerController.isHittingBlock();
                        if (var1 != 0) {
                           break label73;
                        }

                        if (var10000 == 0) {
                           break label72;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var2 = 1860821762 ^ -486624838;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var10000 = -522158903 ^ -486624838;
               }

               var2 = var10000;
               if (var1 == 0) {
                  continue;
               }
               break;
            case 1888872456:
               if (oc9755810e45.ϔ != null) {
                  var2 = -186285808 ^ -486624838;
                  if (var1 == 0) {
                     continue;
                  }
               }

               var2 = 1186007670 ^ -486624838;
               if (var1 == 0) {
                  continue;
               }

               return false;
            default:
               throw null;
         }

         int var9;
         label64: {
            label63: {
               try {
                  var9 = oc69da1aa7f5.ő.playerController instanceof oc51cbcffcfe;
                  if (var1 != 0) {
                     break label64;
                  }

                  if (var9 == 0) {
                     break label63;
                  }
               } catch (ocbde1165e4e var3) {
                  throw var3;
               }

               var2 = -1066844776 ^ -486624838;
               if (var1 == 0) {
                  continue;
               }
            }

            var9 = -522158903 ^ -486624838;
         }

         var2 = var9;
      }
   }

   private boolean ь() {
      int var2 = 0;
      EnumFacing var3 = null;
      int var4 = 280731688 ^ 1586251997;
      int var1 = oc84f20a0bc5.ė;

      while (true) {
         switch (var4) {
            case 1312286965:
               var2 = this.К();

               label29: {
                  label28: {
                     try {
                        if (var1 != 0) {
                           break label29;
                        }

                        if (var2 >= 0) {
                           break label28;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var4 = 559121462 ^ 1586251997;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var4 = -1178762610 ^ 1586251997;
               }

               if (var1 == 0) {
                  break;
               }
            case -416167341:
               this.x = oc69da1aa7f5.ő.thePlayer;
               this.ѡ = this.x.inventory.currentItem;
               this.ʂ = var2;
               this.ʎ = true;
               this.Ү = System.currentTimeMillis();
               this.Ê = this.ƶ();
               var3 = this.x.getHorizontalFacing();
               EnumFacing[] var10001 = new EnumFacing[1586251993 ^ 1586251997];
               var10001[0] = var3;
               var10001[1] = var3.rotateY();
               var10001[1586251999 ^ 1586251997] = var3.getOpposite();
               var10001[1586251998 ^ 1586251997] = var3.rotateYCCW();
               this.ɍ = var10001;
               return true;
            case 2145373419:
               return false;
            default:
               throw null;
         }
      }
   }

   private boolean Ֆ() {
      int var2 = 0;
      int var3 = -528611074 ^ -2021800455;
      int var1 = oc84f20a0bc5.ė;

      label82:
      while (true) {
         switch (var3) {
            case -1198609205:
               var2 = this.К();

               label72: {
                  label71: {
                     try {
                        if (var1 != 0) {
                           break label72;
                        }

                        if (var2 >= 0) {
                           break label71;
                        }
                     } catch (ocbde1165e4e var6) {
                        throw var6;
                     }

                     var3 = 1353020826 ^ -2021800455;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var3 = -1980328930 ^ -2021800455;
               }

               if (var1 == 0) {
                  break;
               }
            case 244011495:
               this.ʂ = var2;
               var3 = -1797489408 ^ -2021800455;
               if (var1 == 0) {
                  break;
               }

               return false;
            case -673664925:
               return false;
            case 329365753:
               break label82;
            case 653944483:
               int var7;
               label50: {
                  label49: {
                     try {
                        var7 = this.Π(oc69da1aa7f5.ő.thePlayer.inventory.getStackInSlot(this.ʂ));
                        if (var1 != 0) {
                           break label50;
                        }

                        if (var7 != 0) {
                           break label49;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var3 = 1072916786 ^ -2021800455;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var7 = -1797489408 ^ -2021800455;
               }

               var3 = var7;
               break;
            case 1728302343:
               int var10000;
               label59: {
                  label58: {
                     try {
                        var10000 = this.ʂ;
                        if (var1 != 0) {
                           break label59;
                        }

                        if (this.ʂ < 0) {
                           break label58;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var3 = -1584946342 ^ -2021800455;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = 1072916786 ^ -2021800455;
               }

               var3 = var10000;
               if (var1 == 0) {
                  break;
               }
               break label82;
            default:
               throw null;
         }
      }

      oc69da1aa7f5.ő.thePlayer.inventory.currentItem = this.ʂ;
      return true;
   }

   private void Ѽ() {
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
      // 06: ifne 1f
      // 09: getfield x/oca3ff10b94f.ʎ Z
      // 0c: ifeq 1e
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: invokestatic java/lang/System.currentTimeMillis ()J
      // 17: putfield x/oca3ff10b94f.Ӝ J
      // 1a: goto 1e
      // 1d: athrow
      // 1e: aload 0
      // 1f: iload 1
      // 20: ifne a9
      // 23: getfield x/oca3ff10b94f.x Lnet/minecraft/client/entity/EntityPlayerSP;
      // 26: ifnull 85
      // 29: goto 2d
      // 2c: athrow
      // 2d: aload 0
      // 2e: iload 1
      // 2f: ifne a9
      // 32: goto 36
      // 35: athrow
      // 36: getfield x/oca3ff10b94f.x Lnet/minecraft/client/entity/EntityPlayerSP;
      // 39: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 3c: ifnull 85
      // 3f: goto 43
      // 42: athrow
      // 43: aload 0
      // 44: iload 1
      // 45: ifne a9
      // 48: goto 4c
      // 4b: athrow
      // 4c: getfield x/oca3ff10b94f.ѡ I
      // 4f: iflt 85
      // 52: goto 56
      // 55: athrow
      // 56: aload 0
      // 57: iload 1
      // 58: ifne a9
      // 5b: goto 5f
      // 5e: athrow
      // 5f: getfield x/oca3ff10b94f.x Lnet/minecraft/client/entity/EntityPlayerSP;
      // 62: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 65: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 68: aload 0
      // 69: getfield x/oca3ff10b94f.ʂ I
      // 6c: if_icmpne 85
      // 6f: goto 73
      // 72: athrow
      // 73: aload 0
      // 74: getfield x/oca3ff10b94f.x Lnet/minecraft/client/entity/EntityPlayerSP;
      // 77: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 7a: aload 0
      // 7b: getfield x/oca3ff10b94f.ѡ I
      // 7e: putfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 81: goto 85
      // 84: athrow
      // 85: aload 0
      // 86: bipush 0
      // 87: putfield x/oca3ff10b94f.ʎ Z
      // 8a: aload 0
      // 8b: aconst_null
      // 8c: putfield x/oca3ff10b94f.x Lnet/minecraft/client/entity/EntityPlayerSP;
      // 8f: aload 0
      // 90: bipush -1
      // 91: putfield x/oca3ff10b94f.ѡ I
      // 94: aload 0
      // 95: bipush -1
      // 96: putfield x/oca3ff10b94f.ʂ I
      // 99: aload 0
      // 9a: aconst_null
      // 9b: putfield x/oca3ff10b94f.Ê Lnet/minecraft/util/BlockPos;
      // 9e: aload 0
      // 9f: aconst_null
      // a0: putfield x/oca3ff10b94f.ɍ [Lnet/minecraft/util/EnumFacing;
      // a3: aload 0
      // a4: bipush 1
      // a5: putfield x/oca3ff10b94f.ƙ Z
      // a8: aload 0
      // a9: invokevirtual x/oca3ff10b94f.Ϊ ()V
      // ac: return
   }

   private void Ϊ() {
      this.ʰ = null;
      this.ճ = null;
      this.ʩ.clear();
      this.ӗ.clear();
      this.Հ.clear();
      this.Ѝ = false;
      this.ӫ = -1;
      this.Ʃ = 0;
   }

   private int К() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: bipush -1
      // 04: istore 2
      // 05: bipush 0
      // 06: istore 3
      // 07: ldc_w -1.0
      // 0a: fstore 4
      // 0c: bipush 0
      // 0d: istore 5
      // 0f: istore 1
      // 10: iload 5
      // 12: ldc_w 44580081
      // 15: ldc_w 44580088
      // 18: ixor
      // 19: if_icmpge 9d
      // 1c: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1f: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 22: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 25: iload 5
      // 27: invokevirtual net/minecraft/entity/player/InventoryPlayer.getStackInSlot (I)Lnet/minecraft/item/ItemStack;
      // 2a: astore 6
      // 2c: aload 0
      // 2d: aload 6
      // 2f: invokevirtual x/oca3ff10b94f.Π (Lnet/minecraft/item/ItemStack;)Z
      // 32: iload 1
      // 33: ifne 9e
      // 36: ifne 40
      // 39: goto 3d
      // 3c: athrow
      // 3d: goto 96
      // 40: aload 6
      // 42: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 45: checkcast net/minecraft/item/ItemBlock
      // 48: invokevirtual net/minecraft/item/ItemBlock.getBlock ()Lnet/minecraft/block/Block;
      // 4b: invokestatic x/occb1ed1ed8f.ɠ (Lnet/minecraft/block/Block;)F
      // 4e: fstore 7
      // 50: fload 7
      // 52: iload 1
      // 53: ifne 8e
      // 56: fload 4
      // 58: fcmpl
      // 59: ifgt 89
      // 5c: goto 60
      // 5f: athrow
      // 60: fload 7
      // 62: fload 4
      // 64: fcmpl
      // 65: iload 1
      // 66: ifne 85
      // 69: goto 6d
      // 6c: athrow
      // 6d: ifne 96
      // 70: goto 74
      // 73: athrow
      // 74: aload 6
      // 76: iload 1
      // 77: ifne 92
      // 7a: goto 7e
      // 7d: athrow
      // 7e: getfield net/minecraft/item/ItemStack.stackSize I
      // 81: goto 85
      // 84: athrow
      // 85: iload 3
      // 86: if_icmple 96
      // 89: iload 5
      // 8b: istore 2
      // 8c: fload 7
      // 8e: fstore 4
      // 90: aload 6
      // 92: getfield net/minecraft/item/ItemStack.stackSize I
      // 95: istore 3
      // 96: iinc 5 1
      // 99: iload 1
      // 9a: ifeq 10
      // 9d: iload 2
      // 9e: ireturn
   }

   private boolean Π(ItemStack var1) {
      Block var3 = null;
      int var4 = -294115605 ^ 77754909;
      int var2 = oc84f20a0bc5.ė;

      while (true) {
         label192:
         while (true) {
            label190:
            while (true) {
               label188:
               while (true) {
                  label186:
                  while (true) {
                     label184:
                     while (true) {
                        switch (var4) {
                           case -2116264649:
                              return false;
                           case -631907224:
                              int var13;
                              label142: {
                                 label141: {
                                    try {
                                       float var15;
                                       var13 = (var15 = var3.getBlockHardness(oc69da1aa7f5.ő.theWorld, null) - 0.0F) == 0.0F ? 0 : (var15 < 0.0F ? -1 : 1);
                                       if (var2 != 0) {
                                          break label142;
                                       }

                                       if (var13 < 0) {
                                          break label141;
                                       }
                                    } catch (ocbde1165e4e var8) {
                                       throw var8;
                                    }

                                    var4 = 1159832654 ^ 77754909;
                                    if (var2 == 0) {
                                       continue;
                                    }
                                 }

                                 var13 = -199343882 ^ 77754909;
                              }

                              var4 = var13;
                              if (var2 != 0) {
                                 break label186;
                              }
                              continue;
                           case -256101653:
                              return false;
                           case 251589981:
                              int var12;
                              label107: {
                                 label106: {
                                    try {
                                       var12 = this.і.ǭ();
                                       if (var2 != 0) {
                                          break label107;
                                       }

                                       if (var12 == 0) {
                                          break label106;
                                       }
                                    } catch (ocbde1165e4e var5) {
                                       throw var5;
                                    }

                                    var4 = 1239854498 ^ 77754909;
                                    if (var2 == 0) {
                                       continue;
                                    }
                                 }

                                 var12 = 399092368 ^ 77754909;
                              }

                              var4 = var12;
                              continue;
                           case 325834893:
                              return true;
                           case 667792256:
                              break label190;
                           case 980553269:
                              break label188;
                           case 1099159123:
                              break label184;
                           case 1296359359:
                              int var10000;
                              label165: {
                                 label164: {
                                    try {
                                       var10000 = this.в.b(var1);
                                       if (var2 != 0) {
                                          break label165;
                                       }

                                       if (var10000 != 0) {
                                          break label164;
                                       }
                                    } catch (ocbde1165e4e var10) {
                                       throw var10;
                                    }

                                    var4 = 399092368 ^ 77754909;
                                    if (var2 == 0) {
                                       continue;
                                    }
                                 }

                                 var10000 = -199343882 ^ 77754909;
                              }

                              var4 = var10000;
                              if (var2 == 0) {
                                 continue;
                              }
                           case -354790154:
                              if (var1 != null) {
                                 var4 = 1823994754 ^ 77754909;
                                 if (var2 == 0) {
                                    continue;
                                 }
                              }

                              var4 = -2055327958 ^ 77754909;
                              if (var2 == 0) {
                                 continue;
                              }
                              break;
                           case 1746239903:
                              break label186;
                           case 1751334075:
                              break;
                           case 1844769943:
                              break label192;
                           default:
                              throw null;
                        }

                        int var11;
                        label153: {
                           label152: {
                              try {
                                 var11 = var1.getItem() instanceof ItemBlock;
                                 if (var2 != 0) {
                                    break label153;
                                 }

                                 if (var11 != 0) {
                                    break label152;
                                 }
                              } catch (ocbde1165e4e var9) {
                                 throw var9;
                              }

                              var4 = -2055327958 ^ 77754909;
                              if (var2 == 0) {
                                 continue;
                              }
                           }

                           var11 = 1053850664 ^ 77754909;
                        }

                        var4 = var11;
                        if (var2 != 0) {
                           break;
                        }
                     }

                     if (var3 != Blocks.obsidian) {
                        var4 = 173836096 ^ 77754909;
                        if (var2 == 0) {
                           continue;
                        }
                     }

                     var4 = -199343882 ^ 77754909;
                     if (var2 != 0) {
                        break label188;
                     }
                  }

                  int var14;
                  label131: {
                     label130: {
                        try {
                           var14 = var1.stackSize;
                           if (var2 != 0) {
                              break label131;
                           }

                           if (var1.stackSize <= 0) {
                              break label130;
                           }
                        } catch (ocbde1165e4e var7) {
                           throw var7;
                        }

                        var4 = 1824607910 ^ 77754909;
                        if (var2 == 0) {
                           continue;
                        }
                     }

                     var14 = -2055327958 ^ 77754909;
                  }

                  var4 = var14;
                  if (var2 != 0) {
                     break label190;
                  }
               }

               var3 = ((ItemBlock)var1.getItem()).getBlock();

               label121: {
                  label120: {
                     try {
                        if (var2 != 0) {
                           break label121;
                        }

                        if (!occb1ed1ed8f.Ў(var3)) {
                           break label120;
                        }
                     } catch (ocbde1165e4e var6) {
                        throw var6;
                     }

                     var4 = 1767278218 ^ 77754909;
                     if (var2 == 0) {
                        continue;
                     }
                  }

                  var4 = -199343882 ^ 77754909;
               }

               if (var2 != 0) {
                  break label192;
               }
            }

            if (var3 != Blocks.lit_pumpkin) {
               var4 = -554193291 ^ 77754909;
               if (var2 == 0) {
                  continue;
               }
            }

            var4 = -199343882 ^ 77754909;
            if (var2 != 0) {
               return false;
            }
         }

         if (var3 != Blocks.pumpkin) {
            var4 = 594526621 ^ 77754909;
            if (var2 == 0) {
               continue;
            }
         }

         var4 = -199343882 ^ 77754909;
         if (var2 != 0) {
            return true;
         }
      }
   }

   private boolean ż(ItemStack param1) {
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
      // 006: ifne 018
      // 009: aload 1
      // 00a: invokevirtual x/oca3ff10b94f.Ր (Lnet/minecraft/item/ItemStack;)Z
      // 00d: ifeq 017
      // 010: goto 014
      // 013: athrow
      // 014: bipush 1
      // 015: ireturn
      // 016: athrow
      // 017: aload 0
      // 018: invokevirtual x/oca3ff10b94f.ƶ ()Lnet/minecraft/util/BlockPos;
      // 01b: astore 3
      // 01c: aload 3
      // 01d: ldc_w 1549704284
      // 020: ldc_w 1549704286
      // 023: ixor
      // 024: invokevirtual net/minecraft/util/BlockPos.up (I)Lnet/minecraft/util/BlockPos;
      // 027: astore 4
      // 029: aload 0
      // 02a: aload 4
      // 02c: aload 1
      // 02d: getstatic x/oca3ff10b94f.ʕ [Lnet/minecraft/util/EnumFacing;
      // 030: invokevirtual x/oca3ff10b94f.ƅ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/item/ItemStack;[Lnet/minecraft/util/EnumFacing;)Z
      // 033: iload 2
      // 034: ifne 06f
      // 037: ifne 06a
      // 03a: goto 03e
      // 03d: athrow
      // 03e: aload 0
      // 03f: iload 2
      // 040: ifne 071
      // 043: goto 047
      // 046: athrow
      // 047: aload 4
      // 049: aload 3
      // 04a: ldc_w 1549704278
      // 04d: ldc_w 1549704286
      // 050: ixor
      // 051: ldc_w -1549704288
      // 054: ldc_w 1549704286
      // 057: ixor
      // 058: ldc_w 1549704280
      // 05b: ldc_w 1549704286
      // 05e: ixor
      // 05f: aload 1
      // 060: invokevirtual x/oca3ff10b94f.Ŵ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/BlockPos;IIILnet/minecraft/item/ItemStack;)Z
      // 063: ifeq 070
      // 066: goto 06a
      // 069: athrow
      // 06a: bipush 1
      // 06b: goto 06f
      // 06e: athrow
      // 06f: ireturn
      // 070: aload 0
      // 071: getfield x/oca3ff10b94f.ɍ [Lnet/minecraft/util/EnumFacing;
      // 074: astore 5
      // 076: aload 5
      // 078: arraylength
      // 079: istore 6
      // 07b: bipush 0
      // 07c: istore 7
      // 07e: iload 7
      // 080: iload 6
      // 082: if_icmpge 176
      // 085: aload 5
      // 087: iload 7
      // 089: aaload
      // 08a: astore 8
      // 08c: aload 3
      // 08d: invokevirtual net/minecraft/util/BlockPos.down ()Lnet/minecraft/util/BlockPos;
      // 090: aload 8
      // 092: invokevirtual net/minecraft/util/BlockPos.offset (Lnet/minecraft/util/EnumFacing;)Lnet/minecraft/util/BlockPos;
      // 095: astore 9
      // 097: aload 3
      // 098: aload 8
      // 09a: invokevirtual net/minecraft/util/BlockPos.offset (Lnet/minecraft/util/EnumFacing;)Lnet/minecraft/util/BlockPos;
      // 09d: astore 10
      // 09f: aload 10
      // 0a1: invokevirtual net/minecraft/util/BlockPos.up ()Lnet/minecraft/util/BlockPos;
      // 0a4: astore 11
      // 0a6: aload 0
      // 0a7: aload 9
      // 0a9: aload 1
      // 0aa: getstatic x/oca3ff10b94f.Ƭ [Lnet/minecraft/util/EnumFacing;
      // 0ad: invokevirtual x/oca3ff10b94f.ƅ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/item/ItemStack;[Lnet/minecraft/util/EnumFacing;)Z
      // 0b0: iload 2
      // 0b1: ifne 177
      // 0b4: iload 2
      // 0b5: ifne 16e
      // 0b8: goto 0bc
      // 0bb: athrow
      // 0bc: ifne 16d
      // 0bf: goto 0c3
      // 0c2: athrow
      // 0c3: aload 0
      // 0c4: aload 9
      // 0c6: aload 3
      // 0c7: ldc_w 1549704282
      // 0ca: ldc_w 1549704286
      // 0cd: ixor
      // 0ce: ldc_w -1549704284
      // 0d1: ldc_w 1549704286
      // 0d4: ixor
      // 0d5: bipush 0
      // 0d6: aload 1
      // 0d7: invokevirtual x/oca3ff10b94f.Ŵ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/BlockPos;IIILnet/minecraft/item/ItemStack;)Z
      // 0da: iload 2
      // 0db: ifne 16e
      // 0de: goto 0e2
      // 0e1: athrow
      // 0e2: ifne 16d
      // 0e5: goto 0e9
      // 0e8: athrow
      // 0e9: aload 0
      // 0ea: aload 10
      // 0ec: aload 1
      // 0ed: getstatic x/oca3ff10b94f.Ƭ [Lnet/minecraft/util/EnumFacing;
      // 0f0: invokevirtual x/oca3ff10b94f.ƅ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/item/ItemStack;[Lnet/minecraft/util/EnumFacing;)Z
      // 0f3: iload 2
      // 0f4: ifne 16e
      // 0f7: goto 0fb
      // 0fa: athrow
      // 0fb: ifne 16d
      // 0fe: goto 102
      // 101: athrow
      // 102: aload 0
      // 103: aload 10
      // 105: aload 3
      // 106: ldc_w 1549704282
      // 109: ldc_w 1549704286
      // 10c: ixor
      // 10d: ldc_w -1549704285
      // 110: ldc_w 1549704286
      // 113: ixor
      // 114: bipush 1
      // 115: aload 1
      // 116: invokevirtual x/oca3ff10b94f.Ŵ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/BlockPos;IIILnet/minecraft/item/ItemStack;)Z
      // 119: iload 2
      // 11a: ifne 16e
      // 11d: goto 121
      // 120: athrow
      // 121: ifne 16d
      // 124: goto 128
      // 127: athrow
      // 128: aload 0
      // 129: aload 11
      // 12b: aload 1
      // 12c: getstatic x/oca3ff10b94f.ʕ [Lnet/minecraft/util/EnumFacing;
      // 12f: invokevirtual x/oca3ff10b94f.ƅ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/item/ItemStack;[Lnet/minecraft/util/EnumFacing;)Z
      // 132: iload 2
      // 133: ifne 16e
      // 136: goto 13a
      // 139: athrow
      // 13a: ifne 16d
      // 13d: goto 141
      // 140: athrow
      // 141: aload 0
      // 142: aload 11
      // 144: aload 3
      // 145: ldc_w 1549704282
      // 148: ldc_w 1549704286
      // 14b: ixor
      // 14c: ldc_w -1549704288
      // 14f: ldc_w 1549704286
      // 152: ixor
      // 153: ldc_w 1549704284
      // 156: ldc_w 1549704286
      // 159: ixor
      // 15a: aload 1
      // 15b: invokevirtual x/oca3ff10b94f.Ŵ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/BlockPos;IIILnet/minecraft/item/ItemStack;)Z
      // 15e: iload 2
      // 15f: ifne 16e
      // 162: goto 166
      // 165: athrow
      // 166: ifeq 16f
      // 169: goto 16d
      // 16c: athrow
      // 16d: bipush 1
      // 16e: ireturn
      // 16f: iinc 7 1
      // 172: iload 2
      // 173: ifeq 07e
      // 176: bipush 0
      // 177: ireturn
   }

   private boolean ƅ(BlockPos param1, ItemStack param2, EnumFacing[] param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 4
      // 005: aload 0
      // 006: aload 1
      // 007: invokevirtual x/oca3ff10b94f.ƿ (Lnet/minecraft/util/BlockPos;)Z
      // 00a: iload 4
      // 00c: ifne 04f
      // 00f: ifeq 04a
      // 012: goto 016
      // 015: athrow
      // 016: aload 0
      // 017: getfield x/oca3ff10b94f.Հ Ljava/util/Set;
      // 01a: aload 1
      // 01b: invokeinterface java/util/Set.contains (Ljava/lang/Object;)Z 2
      // 020: iload 4
      // 022: ifne 04f
      // 025: goto 029
      // 028: athrow
      // 029: ifne 04a
      // 02c: goto 030
      // 02f: athrow
      // 030: aload 0
      // 031: iload 4
      // 033: ifne 051
      // 036: goto 03a
      // 039: athrow
      // 03a: getfield x/oca3ff10b94f.ӗ Ljava/util/Set;
      // 03d: aload 1
      // 03e: invokeinterface java/util/Set.contains (Ljava/lang/Object;)Z 2
      // 043: ifeq 050
      // 046: goto 04a
      // 049: athrow
      // 04a: bipush 0
      // 04b: goto 04f
      // 04e: athrow
      // 04f: ireturn
      // 050: aload 0
      // 051: invokevirtual x/oca3ff10b94f.ƶ ()Lnet/minecraft/util/BlockPos;
      // 054: astore 5
      // 056: aload 3
      // 057: astore 6
      // 059: aload 6
      // 05b: arraylength
      // 05c: istore 7
      // 05e: bipush 0
      // 05f: istore 8
      // 061: iload 8
      // 063: iload 7
      // 065: if_icmpge 166
      // 068: aload 6
      // 06a: iload 8
      // 06c: aaload
      // 06d: astore 9
      // 06f: aload 1
      // 070: aload 9
      // 072: invokevirtual net/minecraft/util/EnumFacing.getOpposite ()Lnet/minecraft/util/EnumFacing;
      // 075: invokevirtual net/minecraft/util/BlockPos.offset (Lnet/minecraft/util/EnumFacing;)Lnet/minecraft/util/BlockPos;
      // 078: astore 10
      // 07a: aload 10
      // 07c: aload 5
      // 07e: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 081: iload 4
      // 083: ifne 167
      // 086: iload 4
      // 088: ifne 0b8
      // 08b: goto 08f
      // 08e: athrow
      // 08f: ifeq 0a5
      // 092: goto 096
      // 095: athrow
      // 096: aload 9
      // 098: invokevirtual net/minecraft/util/EnumFacing.getAxis ()Lnet/minecraft/util/EnumFacing$Axis;
      // 09b: getstatic net/minecraft/util/EnumFacing$Axis.Y Lnet/minecraft/util/EnumFacing$Axis;
      // 09e: if_acmpeq 15e
      // 0a1: goto 0a5
      // 0a4: athrow
      // 0a5: aload 0
      // 0a6: iload 4
      // 0a8: ifne 0bf
      // 0ab: goto 0af
      // 0ae: athrow
      // 0af: aload 10
      // 0b1: invokevirtual x/oca3ff10b94f.ʃ (Lnet/minecraft/util/BlockPos;)Z
      // 0b4: goto 0b8
      // 0b7: athrow
      // 0b8: ifne 0be
      // 0bb: goto 15e
      // 0be: aload 0
      // 0bf: aload 1
      // 0c0: aload 10
      // 0c2: aload 9
      // 0c4: aload 2
      // 0c5: invokevirtual x/oca3ff10b94f.Ɇ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;Lnet/minecraft/item/ItemStack;)Lx/oc6af2ed7814;
      // 0c8: astore 11
      // 0ca: iload 4
      // 0cc: ifne 0f4
      // 0cf: aload 11
      // 0d1: ifnonnull 0dc
      // 0d4: goto 0d8
      // 0d7: athrow
      // 0d8: goto 15e
      // 0db: athrow
      // 0dc: aload 0
      // 0dd: aload 11
      // 0df: putfield x/oca3ff10b94f.ʰ Lx/oc6af2ed7814;
      // 0e2: aload 0
      // 0e3: getstatic x/oc75d51ec7eb.d [F
      // 0e6: bipush 0
      // 0e7: faload
      // 0e8: putfield x/oca3ff10b94f.Ĕ F
      // 0eb: aload 0
      // 0ec: getstatic x/oc75d51ec7eb.d [F
      // 0ef: bipush 1
      // 0f0: faload
      // 0f1: putfield x/oca3ff10b94f.R F
      // 0f4: aload 0
      // 0f5: getfield x/oca3ff10b94f.ń Lx/oca9cc61aada;
      // 0f8: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0fb: dstore 12
      // 0fd: aload 0
      // 0fe: dload 12
      // 100: d2i
      // 101: iload 4
      // 103: ifne 159
      // 106: putfield x/oca3ff10b94f.л I
      // 109: dload 12
      // 10b: aload 0
      // 10c: getfield x/oca3ff10b94f.л I
      // 10f: i2d
      // 110: dsub
      // 111: ldc2_w 0.5
      // 114: dcmpl
      // 115: iflt 157
      // 118: goto 11c
      // 11b: athrow
      // 11c: aload 0
      // 11d: iload 4
      // 11f: ifne 13f
      // 122: goto 126
      // 125: athrow
      // 126: getfield x/oca3ff10b94f.ƙ Z
      // 129: ifeq 13e
      // 12c: goto 130
      // 12f: athrow
      // 130: aload 0
      // 131: dup
      // 132: getfield x/oca3ff10b94f.л I
      // 135: bipush 1
      // 136: iadd
      // 137: putfield x/oca3ff10b94f.л I
      // 13a: goto 13e
      // 13d: athrow
      // 13e: aload 0
      // 13f: aload 0
      // 140: getfield x/oca3ff10b94f.ƙ Z
      // 143: iload 4
      // 145: ifne 150
      // 148: ifne 153
      // 14b: goto 14f
      // 14e: athrow
      // 14f: bipush 1
      // 150: goto 154
      // 153: bipush 0
      // 154: putfield x/oca3ff10b94f.ƙ Z
      // 157: aload 0
      // 158: bipush 0
      // 159: putfield x/oca3ff10b94f.Ʃ I
      // 15c: bipush 1
      // 15d: ireturn
      // 15e: iinc 8 1
      // 161: iload 4
      // 163: ifeq 061
      // 166: bipush 0
      // 167: ireturn
   }

   private boolean Ր(ItemStack param1) {
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
      // 06: ifne 17
      // 09: getfield x/oca3ff10b94f.ճ Ljava/util/List;
      // 0c: ifnonnull 16
      // 0f: goto 13
      // 12: athrow
      // 13: bipush 0
      // 14: ireturn
      // 15: athrow
      // 16: aload 0
      // 17: getfield x/oca3ff10b94f.ճ Ljava/util/List;
      // 1a: invokeinterface java/util/List.isEmpty ()Z 1
      // 1f: ifne 5d
      // 22: aload 0
      // 23: iload 2
      // 24: ifne 5e
      // 27: goto 2b
      // 2a: athrow
      // 2b: iload 2
      // 2c: ifne 5e
      // 2f: goto 33
      // 32: athrow
      // 33: aload 0
      // 34: getfield x/oca3ff10b94f.ճ Ljava/util/List;
      // 37: bipush 0
      // 38: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 3d: checkcast net/minecraft/util/BlockPos
      // 40: invokevirtual x/oca3ff10b94f.Ү (Lnet/minecraft/util/BlockPos;)Z
      // 43: ifne 5d
      // 46: goto 4a
      // 49: athrow
      // 4a: aload 0
      // 4b: getfield x/oca3ff10b94f.ճ Ljava/util/List;
      // 4e: bipush 0
      // 4f: invokeinterface java/util/List.remove (I)Ljava/lang/Object; 2
      // 54: pop
      // 55: iload 2
      // 56: ifeq 16
      // 59: goto 5d
      // 5c: athrow
      // 5d: aload 0
      // 5e: iload 2
      // 5f: ifne b0
      // 62: getfield x/oca3ff10b94f.ճ Ljava/util/List;
      // 65: invokeinterface java/util/List.isEmpty ()Z 1
      // 6a: ifne af
      // 6d: goto 71
      // 70: athrow
      // 71: aload 0
      // 72: getfield x/oca3ff10b94f.ճ Ljava/util/List;
      // 75: bipush 0
      // 76: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 7b: checkcast net/minecraft/util/BlockPos
      // 7e: astore 3
      // 7f: aload 0
      // 80: aload 3
      // 81: iload 2
      // 82: ifne a0
      // 85: aload 1
      // 86: getstatic x/oca3ff10b94f.ʕ [Lnet/minecraft/util/EnumFacing;
      // 89: invokevirtual x/oca3ff10b94f.ƅ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/item/ItemStack;[Lnet/minecraft/util/EnumFacing;)Z
      // 8c: ifeq 96
      // 8f: goto 93
      // 92: athrow
      // 93: bipush 1
      // 94: ireturn
      // 95: athrow
      // 96: aload 0
      // 97: iload 2
      // 98: ifne b0
      // 9b: aload 3
      // 9c: goto a0
      // 9f: athrow
      // a0: invokevirtual x/oca3ff10b94f.ƿ (Lnet/minecraft/util/BlockPos;)Z
      // a3: ifeq af
      // a6: aload 0
      // a7: aload 3
      // a8: invokevirtual x/oca3ff10b94f.ë (Lnet/minecraft/util/BlockPos;)V
      // ab: goto af
      // ae: athrow
      // af: aload 0
      // b0: aconst_null
      // b1: putfield x/oca3ff10b94f.ճ Ljava/util/List;
      // b4: bipush 0
      // b5: ireturn
   }

   private boolean Ŵ(BlockPos param1, BlockPos param2, int param3, int param4, int param5, ItemStack param6) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 7
      // 005: aload 0
      // 006: aload 1
      // 007: invokevirtual x/oca3ff10b94f.ƿ (Lnet/minecraft/util/BlockPos;)Z
      // 00a: iload 7
      // 00c: ifne 04b
      // 00f: ifeq 04a
      // 012: goto 016
      // 015: athrow
      // 016: aload 0
      // 017: getfield x/oca3ff10b94f.Հ Ljava/util/Set;
      // 01a: aload 1
      // 01b: invokeinterface java/util/Set.contains (Ljava/lang/Object;)Z 2
      // 020: iload 7
      // 022: ifne 04b
      // 025: goto 029
      // 028: athrow
      // 029: ifne 04a
      // 02c: goto 030
      // 02f: athrow
      // 030: aload 0
      // 031: getfield x/oca3ff10b94f.ӗ Ljava/util/Set;
      // 034: aload 1
      // 035: invokeinterface java/util/Set.contains (Ljava/lang/Object;)Z 2
      // 03a: iload 7
      // 03c: ifne 04b
      // 03f: goto 043
      // 042: athrow
      // 043: ifeq 04c
      // 046: goto 04a
      // 049: athrow
      // 04a: bipush 0
      // 04b: ireturn
      // 04c: getstatic x/oca3ff10b94f.ʕ [Lnet/minecraft/util/EnumFacing;
      // 04f: astore 8
      // 051: aload 8
      // 053: arraylength
      // 054: istore 9
      // 056: bipush 0
      // 057: istore 10
      // 059: iload 10
      // 05b: iload 9
      // 05d: if_icmpge 08b
      // 060: aload 8
      // 062: iload 10
      // 064: aaload
      // 065: astore 11
      // 067: iload 7
      // 069: ifne 086
      // 06c: aload 0
      // 06d: aload 1
      // 06e: aload 11
      // 070: invokevirtual net/minecraft/util/EnumFacing.getOpposite ()Lnet/minecraft/util/EnumFacing;
      // 073: invokevirtual net/minecraft/util/BlockPos.offset (Lnet/minecraft/util/EnumFacing;)Lnet/minecraft/util/BlockPos;
      // 076: invokevirtual x/oca3ff10b94f.ʃ (Lnet/minecraft/util/BlockPos;)Z
      // 079: ifeq 083
      // 07c: goto 080
      // 07f: athrow
      // 080: bipush 0
      // 081: ireturn
      // 082: athrow
      // 083: iinc 10 1
      // 086: iload 7
      // 088: ifeq 059
      // 08b: new java/util/HashSet
      // 08e: dup
      // 08f: invokespecial java/util/HashSet.<init> ()V
      // 092: astore 8
      // 094: new java/util/ArrayList
      // 097: dup
      // 098: invokespecial java/util/ArrayList.<init> ()V
      // 09b: astore 9
      // 09d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0a0: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0a3: fconst_1
      // 0a4: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 0a7: astore 10
      // 0a9: aload 0
      // 0aa: invokevirtual x/oca3ff10b94f.ĸ ()D
      // 0ad: aload 0
      // 0ae: invokevirtual x/oca3ff10b94f.ĸ ()D
      // 0b1: dmul
      // 0b2: dstore 11
      // 0b4: iload 3
      // 0b5: ineg
      // 0b6: istore 13
      // 0b8: iload 13
      // 0ba: iload 3
      // 0bb: if_icmpgt 1f5
      // 0be: iload 3
      // 0bf: iload 7
      // 0c1: ifne 207
      // 0c4: ineg
      // 0c5: istore 14
      // 0c7: iload 14
      // 0c9: iload 3
      // 0ca: if_icmpgt 1ed
      // 0cd: iload 7
      // 0cf: ifne 1f0
      // 0d2: iload 4
      // 0d4: istore 15
      // 0d6: iload 15
      // 0d8: iload 5
      // 0da: if_icmpgt 1e5
      // 0dd: aload 2
      // 0de: iload 13
      // 0e0: iload 15
      // 0e2: iload 14
      // 0e4: invokevirtual net/minecraft/util/BlockPos.add (III)Lnet/minecraft/util/BlockPos;
      // 0e7: astore 16
      // 0e9: iload 7
      // 0eb: ifne 1e0
      // 0ee: aload 0
      // 0ef: aload 16
      // 0f1: iload 7
      // 0f3: ifne 1f7
      // 0f6: goto 0fa
      // 0f9: athrow
      // 0fa: invokevirtual x/oca3ff10b94f.ƿ (Lnet/minecraft/util/BlockPos;)Z
      // 0fd: ifeq 1dd
      // 100: goto 104
      // 103: athrow
      // 104: aload 0
      // 105: iload 7
      // 107: ifne 124
      // 10a: goto 10e
      // 10d: athrow
      // 10e: getfield x/oca3ff10b94f.ӗ Ljava/util/Set;
      // 111: aload 16
      // 113: invokeinterface java/util/Set.contains (Ljava/lang/Object;)Z 2
      // 118: ifne 1dd
      // 11b: goto 11f
      // 11e: athrow
      // 11f: aload 0
      // 120: goto 124
      // 123: athrow
      // 124: getfield x/oca3ff10b94f.Հ Ljava/util/Set;
      // 127: aload 16
      // 129: invokeinterface java/util/Set.contains (Ljava/lang/Object;)Z 2
      // 12e: iload 7
      // 130: ifne 154
      // 133: ifeq 13d
      // 136: goto 13a
      // 139: athrow
      // 13a: goto 1dd
      // 13d: aload 8
      // 13f: aload 16
      // 141: invokeinterface java/util/Set.add (Ljava/lang/Object;)Z 2
      // 146: pop
      // 147: iload 13
      // 149: invokestatic java/lang/Math.abs (I)I
      // 14c: iload 14
      // 14e: invokestatic java/lang/Math.abs (I)I
      // 151: invokestatic java/lang/Math.max (II)I
      // 154: ldc_w 378115035
      // 157: ldc_w 378115032
      // 15a: ixor
      // 15b: if_icmple 162
      // 15e: goto 1dd
      // 161: athrow
      // 162: getstatic x/oca3ff10b94f.ʕ [Lnet/minecraft/util/EnumFacing;
      // 165: astore 17
      // 167: aload 17
      // 169: arraylength
      // 16a: istore 18
      // 16c: bipush 0
      // 16d: istore 19
      // 16f: iload 19
      // 171: iload 18
      // 173: if_icmpge 1dd
      // 176: aload 17
      // 178: iload 19
      // 17a: aaload
      // 17b: astore 20
      // 17d: iload 7
      // 17f: aload 16
      // 181: aload 20
      // 183: invokevirtual net/minecraft/util/EnumFacing.getOpposite ()Lnet/minecraft/util/EnumFacing;
      // 186: invokevirtual net/minecraft/util/BlockPos.offset (Lnet/minecraft/util/EnumFacing;)Lnet/minecraft/util/BlockPos;
      // 189: astore 21
      // 18b: ifne 1d8
      // 18e: iload 7
      // 190: ifne 1e0
      // 193: goto 197
      // 196: athrow
      // 197: aload 0
      // 198: aload 21
      // 19a: invokevirtual x/oca3ff10b94f.ʃ (Lnet/minecraft/util/BlockPos;)Z
      // 19d: ifeq 1d1
      // 1a0: goto 1a4
      // 1a3: athrow
      // 1a4: aload 10
      // 1a6: aload 21
      // 1a8: invokestatic x/occb1ed1ed8f.Ʌ (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/BlockPos;)D
      // 1ab: dload 11
      // 1ad: dcmpg
      // 1ae: iload 7
      // 1b0: ifne 1cb
      // 1b3: goto 1b7
      // 1b6: athrow
      // 1b7: ifgt 1d1
      // 1ba: goto 1be
      // 1bd: athrow
      // 1be: aload 9
      // 1c0: aload 16
      // 1c2: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 1c7: goto 1cb
      // 1ca: athrow
      // 1cb: pop
      // 1cc: iload 7
      // 1ce: ifeq 1dd
      // 1d1: iinc 19 1
      // 1d4: goto 1d8
      // 1d7: athrow
      // 1d8: iload 7
      // 1da: ifeq 16f
      // 1dd: iinc 15 1
      // 1e0: iload 7
      // 1e2: ifeq 0d6
      // 1e5: iinc 14 1
      // 1e8: iload 7
      // 1ea: ifeq 0c7
      // 1ed: iinc 13 1
      // 1f0: iload 7
      // 1f2: ifeq 0b8
      // 1f5: aload 0
      // 1f6: aload 1
      // 1f7: aload 9
      // 1f9: aload 8
      // 1fb: invokestatic x/oca872d93a25.ƅ (Lnet/minecraft/util/BlockPos;Ljava/util/List;Ljava/util/Set;)Ljava/util/List;
      // 1fe: putfield x/oca3ff10b94f.ճ Ljava/util/List;
      // 201: aload 0
      // 202: aload 6
      // 204: invokevirtual x/oca3ff10b94f.Ր (Lnet/minecraft/item/ItemStack;)Z
      // 207: ireturn
   }

   private boolean Ҹ(ItemStack param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: aload 0
      // 04: getfield x/oca3ff10b94f.ʩ Ljava/util/Deque;
      // 07: invokeinterface java/util/Deque.size ()I 1
      // 0c: istore 3
      // 0d: istore 2
      // 0e: iload 3
      // 0f: iinc 3 -1
      // 12: ifle 99
      // 15: aload 0
      // 16: getfield x/oca3ff10b94f.ʩ Ljava/util/Deque;
      // 19: invokeinterface java/util/Deque.removeFirst ()Ljava/lang/Object; 1
      // 1e: checkcast net/minecraft/util/BlockPos
      // 21: astore 4
      // 23: aload 0
      // 24: getfield x/oca3ff10b94f.ӗ Ljava/util/Set;
      // 27: aload 4
      // 29: invokeinterface java/util/Set.remove (Ljava/lang/Object;)Z 2
      // 2e: iload 2
      // 2f: ifne 9a
      // 32: iload 2
      // 33: ifne 5f
      // 36: goto 3a
      // 39: athrow
      // 3a: pop
      // 3b: aload 0
      // 3c: aload 4
      // 3e: invokevirtual x/oca3ff10b94f.ƿ (Lnet/minecraft/util/BlockPos;)Z
      // 41: ifne 4c
      // 44: goto 48
      // 47: athrow
      // 48: goto 0e
      // 4b: athrow
      // 4c: aload 0
      // 4d: getfield x/oca3ff10b94f.Հ Ljava/util/Set;
      // 50: iload 2
      // 51: ifne 8d
      // 54: aload 4
      // 56: invokeinterface java/util/Set.contains (Ljava/lang/Object;)Z 2
      // 5b: goto 5f
      // 5e: athrow
      // 5f: ifne 7e
      // 62: aload 0
      // 63: iload 2
      // 64: ifne 8a
      // 67: goto 6b
      // 6a: athrow
      // 6b: aload 4
      // 6d: aload 1
      // 6e: getstatic x/oca3ff10b94f.ʕ [Lnet/minecraft/util/EnumFacing;
      // 71: invokevirtual x/oca3ff10b94f.ƅ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/item/ItemStack;[Lnet/minecraft/util/EnumFacing;)Z
      // 74: ifeq 7e
      // 77: goto 7b
      // 7a: athrow
      // 7b: bipush 1
      // 7c: ireturn
      // 7d: athrow
      // 7e: aload 0
      // 7f: getfield x/oca3ff10b94f.ʩ Ljava/util/Deque;
      // 82: aload 4
      // 84: invokeinterface java/util/Deque.addLast (Ljava/lang/Object;)V 2
      // 89: aload 0
      // 8a: getfield x/oca3ff10b94f.ӗ Ljava/util/Set;
      // 8d: aload 4
      // 8f: invokeinterface java/util/Set.add (Ljava/lang/Object;)Z 2
      // 94: pop
      // 95: iload 2
      // 96: ifeq 0e
      // 99: bipush 0
      // 9a: ireturn
   }

   private void ŧ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: aload 0
      // 04: getfield x/oca3ff10b94f.ʩ Ljava/util/Deque;
      // 07: invokeinterface java/util/Deque.iterator ()Ljava/util/Iterator; 1
      // 0c: astore 2
      // 0d: istore 1
      // 0e: aload 2
      // 0f: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 14: ifeq 4a
      // 17: aload 2
      // 18: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 1d: checkcast net/minecraft/util/BlockPos
      // 20: astore 3
      // 21: iload 1
      // 22: ifne 3b
      // 25: aload 0
      // 26: aload 3
      // 27: invokevirtual x/oca3ff10b94f.ƿ (Lnet/minecraft/util/BlockPos;)Z
      // 2a: ifne 46
      // 2d: goto 31
      // 30: athrow
      // 31: aload 2
      // 32: invokeinterface java/util/Iterator.remove ()V 1
      // 37: goto 3b
      // 3a: athrow
      // 3b: aload 0
      // 3c: getfield x/oca3ff10b94f.ӗ Ljava/util/Set;
      // 3f: aload 3
      // 40: invokeinterface java/util/Set.remove (Ljava/lang/Object;)Z 2
      // 45: pop
      // 46: iload 1
      // 47: ifeq 0e
      // 4a: return
   }

   private void ɻ() {
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
      // 06: ifne 26
      // 09: getfield x/oca3ff10b94f.ʰ Lx/oc6af2ed7814;
      // 0c: ifnonnull 15
      // 0f: goto 13
      // 12: athrow
      // 13: return
      // 14: athrow
      // 15: aload 0
      // 16: aload 0
      // 17: getfield x/oca3ff10b94f.ʰ Lx/oc6af2ed7814;
      // 1a: getfield x/oc6af2ed7814.η Lnet/minecraft/util/BlockPos;
      // 1d: invokevirtual x/oca3ff10b94f.ë (Lnet/minecraft/util/BlockPos;)V
      // 20: aload 0
      // 21: aconst_null
      // 22: putfield x/oca3ff10b94f.ʰ Lx/oc6af2ed7814;
      // 25: aload 0
      // 26: bipush 0
      // 27: putfield x/oca3ff10b94f.Ѝ Z
      // 2a: return
   }

   private void ë(BlockPos param1) {
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
      // 06: ifne 65
      // 09: getfield x/oca3ff10b94f.Հ Ljava/util/Set;
      // 0c: aload 1
      // 0d: invokeinterface java/util/Set.add (Ljava/lang/Object;)Z 2
      // 12: pop
      // 13: aload 0
      // 14: getfield x/oca3ff10b94f.ӗ Ljava/util/Set;
      // 17: aload 1
      // 18: invokeinterface java/util/Set.add (Ljava/lang/Object;)Z 2
      // 1d: ifeq 64
      // 20: goto 24
      // 23: athrow
      // 24: aload 0
      // 25: iload 2
      // 26: ifne 5b
      // 29: goto 2d
      // 2c: athrow
      // 2d: getfield x/oca3ff10b94f.ʩ Ljava/util/Deque;
      // 30: invokeinterface java/util/Deque.size ()I 1
      // 35: ldc_w -1131906934
      // 38: ldc_w -1131906935
      // 3b: ixor
      // 3c: if_icmplt 5a
      // 3f: goto 43
      // 42: athrow
      // 43: aload 0
      // 44: getfield x/oca3ff10b94f.ӗ Ljava/util/Set;
      // 47: aload 0
      // 48: getfield x/oca3ff10b94f.ʩ Ljava/util/Deque;
      // 4b: invokeinterface java/util/Deque.removeFirst ()Ljava/lang/Object; 1
      // 50: invokeinterface java/util/Set.remove (Ljava/lang/Object;)Z 2
      // 55: pop
      // 56: goto 5a
      // 59: athrow
      // 5a: aload 0
      // 5b: getfield x/oca3ff10b94f.ʩ Ljava/util/Deque;
      // 5e: aload 1
      // 5f: invokeinterface java/util/Deque.addLast (Ljava/lang/Object;)V 2
      // 64: aload 0
      // 65: iload 2
      // 66: ifne 78
      // 69: getfield x/oca3ff10b94f.ճ Ljava/util/List;
      // 6c: ifnull b4
      // 6f: goto 73
      // 72: athrow
      // 73: aload 0
      // 74: goto 78
      // 77: athrow
      // 78: getfield x/oca3ff10b94f.ճ Ljava/util/List;
      // 7b: iload 2
      // 7c: ifne a1
      // 7f: invokeinterface java/util/List.isEmpty ()Z 1
      // 84: ifne b4
      // 87: goto 8b
      // 8a: athrow
      // 8b: aload 0
      // 8c: iload 2
      // 8d: ifne b0
      // 90: goto 94
      // 93: athrow
      // 94: getfield x/oca3ff10b94f.ճ Ljava/util/List;
      // 97: bipush 0
      // 98: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 9d: goto a1
      // a0: athrow
      // a1: checkcast net/minecraft/util/BlockPos
      // a4: aload 1
      // a5: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // a8: ifeq b4
      // ab: aload 0
      // ac: goto b0
      // af: athrow
      // b0: aconst_null
      // b1: putfield x/oca3ff10b94f.ճ Ljava/util/List;
      // b4: return
   }

   private oc6af2ed7814 Ɇ(BlockPos param1, BlockPos param2, EnumFacing param3, ItemStack param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 5
      // 005: aload 0
      // 006: iload 5
      // 008: ifne 01b
      // 00b: aload 2
      // 00c: invokevirtual x/oca3ff10b94f.ʃ (Lnet/minecraft/util/BlockPos;)Z
      // 00f: ifeq 025
      // 012: goto 016
      // 015: athrow
      // 016: aload 0
      // 017: goto 01b
      // 01a: athrow
      // 01b: aload 4
      // 01d: aload 2
      // 01e: aload 3
      // 01f: invokevirtual x/oca3ff10b94f.Κ (Lnet/minecraft/item/ItemStack;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;)Z
      // 022: ifne 028
      // 025: aconst_null
      // 026: areturn
      // 027: athrow
      // 028: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 02b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 02e: fconst_1
      // 02f: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 032: astore 6
      // 034: bipush -1
      // 035: istore 7
      // 037: iload 7
      // 039: ldc_w 2018060947
      // 03c: ldc_w 2018060938
      // 03f: ixor
      // 040: if_icmpge 1ad
      // 043: iload 7
      // 045: ifge 04f
      // 048: ldc2_w 0.5
      // 04b: goto 062
      // 04e: athrow
      // 04f: ldc2_w 0.01
      // 052: iload 7
      // 054: ldc_w 2018060943
      // 057: ldc_w 2018060938
      // 05a: ixor
      // 05b: irem
      // 05c: i2d
      // 05d: ldc2_w 0.245
      // 060: dmul
      // 061: dadd
      // 062: dstore 8
      // 064: iload 7
      // 066: ifge 070
      // 069: ldc2_w 0.5
      // 06c: goto 083
      // 06f: athrow
      // 070: ldc2_w 0.01
      // 073: iload 7
      // 075: ldc_w 2018060943
      // 078: ldc_w 2018060938
      // 07b: ixor
      // 07c: idiv
      // 07d: i2d
      // 07e: ldc2_w 0.245
      // 081: dmul
      // 082: dadd
      // 083: dstore 10
      // 085: aload 2
      // 086: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 089: i2d
      // 08a: aload 3
      // 08b: iload 5
      // 08d: ifne 0a2
      // 090: invokevirtual net/minecraft/util/EnumFacing.getAxis ()Lnet/minecraft/util/EnumFacing$Axis;
      // 093: getstatic net/minecraft/util/EnumFacing$Axis.X Lnet/minecraft/util/EnumFacing$Axis;
      // 096: if_acmpne 0b5
      // 099: goto 09d
      // 09c: athrow
      // 09d: aload 3
      // 09e: goto 0a2
      // 0a1: athrow
      // 0a2: getstatic net/minecraft/util/EnumFacing.EAST Lnet/minecraft/util/EnumFacing;
      // 0a5: if_acmpne 0af
      // 0a8: ldc2_w 0.999
      // 0ab: goto 0b7
      // 0ae: athrow
      // 0af: ldc2_w 0.001
      // 0b2: goto 0b7
      // 0b5: dload 8
      // 0b7: dadd
      // 0b8: dstore 12
      // 0ba: aload 2
      // 0bb: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 0be: i2d
      // 0bf: aload 3
      // 0c0: iload 5
      // 0c2: ifne 0d7
      // 0c5: invokevirtual net/minecraft/util/EnumFacing.getAxis ()Lnet/minecraft/util/EnumFacing$Axis;
      // 0c8: getstatic net/minecraft/util/EnumFacing$Axis.Y Lnet/minecraft/util/EnumFacing$Axis;
      // 0cb: if_acmpne 0ea
      // 0ce: goto 0d2
      // 0d1: athrow
      // 0d2: aload 3
      // 0d3: goto 0d7
      // 0d6: athrow
      // 0d7: getstatic net/minecraft/util/EnumFacing.UP Lnet/minecraft/util/EnumFacing;
      // 0da: if_acmpne 0e4
      // 0dd: ldc2_w 0.999
      // 0e0: goto 0ec
      // 0e3: athrow
      // 0e4: ldc2_w 0.001
      // 0e7: goto 0ec
      // 0ea: dload 10
      // 0ec: dadd
      // 0ed: dstore 14
      // 0ef: aload 2
      // 0f0: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 0f3: i2d
      // 0f4: aload 3
      // 0f5: iload 5
      // 0f7: ifne 120
      // 0fa: invokevirtual net/minecraft/util/EnumFacing.getAxis ()Lnet/minecraft/util/EnumFacing$Axis;
      // 0fd: getstatic net/minecraft/util/EnumFacing$Axis.Z Lnet/minecraft/util/EnumFacing$Axis;
      // 100: if_acmpne 11f
      // 103: goto 107
      // 106: athrow
      // 107: aload 3
      // 108: getstatic net/minecraft/util/EnumFacing.SOUTH Lnet/minecraft/util/EnumFacing;
      // 10b: if_acmpne 119
      // 10e: goto 112
      // 111: athrow
      // 112: ldc2_w 0.999
      // 115: goto 131
      // 118: athrow
      // 119: ldc2_w 0.001
      // 11c: goto 131
      // 11f: aload 3
      // 120: invokevirtual net/minecraft/util/EnumFacing.getAxis ()Lnet/minecraft/util/EnumFacing$Axis;
      // 123: getstatic net/minecraft/util/EnumFacing$Axis.X Lnet/minecraft/util/EnumFacing$Axis;
      // 126: if_acmpne 12f
      // 129: dload 8
      // 12b: goto 131
      // 12e: athrow
      // 12f: dload 10
      // 131: dadd
      // 132: dstore 16
      // 134: iload 5
      // 136: aload 6
      // 138: dload 12
      // 13a: dload 14
      // 13c: dload 16
      // 13e: invokestatic x/oc75d51ec7eb.ӆ (Lnet/minecraft/util/Vec3;DDD)[F
      // 141: astore 18
      // 143: aload 18
      // 145: bipush 0
      // 146: faload
      // 147: aload 18
      // 149: bipush 1
      // 14a: faload
      // 14b: getstatic x/oc75d51ec7eb.d [F
      // 14e: bipush 0
      // 14f: faload
      // 150: getstatic x/oc75d51ec7eb.d [F
      // 153: bipush 1
      // 154: faload
      // 155: invokestatic x/oc75d51ec7eb.Ĩ (FFFF)[F
      // 158: astore 18
      // 15a: aload 0
      // 15b: aload 18
      // 15d: bipush 0
      // 15e: faload
      // 15f: aload 18
      // 161: bipush 1
      // 162: faload
      // 163: invokevirtual x/oca3ff10b94f.қ (FF)Lnet/minecraft/util/MovingObjectPosition;
      // 166: astore 19
      // 168: ifne 1a8
      // 16b: aload 19
      // 16d: ifnull 1a5
      // 170: goto 174
      // 173: athrow
      // 174: aload 2
      // 175: aload 19
      // 177: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 17a: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 17d: ifeq 1a5
      // 180: goto 184
      // 183: athrow
      // 184: aload 3
      // 185: aload 19
      // 187: getfield net/minecraft/util/MovingObjectPosition.sideHit Lnet/minecraft/util/EnumFacing;
      // 18a: if_acmpne 1a5
      // 18d: goto 191
      // 190: athrow
      // 191: new x/oc6af2ed7814
      // 194: dup
      // 195: aload 1
      // 196: aload 2
      // 197: aload 3
      // 198: aload 18
      // 19a: bipush 0
      // 19b: faload
      // 19c: aload 18
      // 19e: bipush 1
      // 19f: faload
      // 1a0: invokespecial x/oc6af2ed7814.<init> (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;FF)V
      // 1a3: areturn
      // 1a4: athrow
      // 1a5: iinc 7 1
      // 1a8: iload 5
      // 1aa: ifeq 037
      // 1ad: aconst_null
      // 1ae: areturn
   }

   private boolean һ(MovingObjectPosition var1) {
      int var2 = oc84f20a0bc5.ė;
      int var3 = 2095257755 ^ -750088129;

      while (true) {
         switch (var3) {
            case -1347843932:
               if (this.ʰ != null) {
                  var3 = -1424856968 ^ -750088129;
                  if (var2 == 0) {
                     break;
                  }
               }

               var3 = -378910016 ^ -750088129;
               if (var2 == 0) {
                  break;
               }
            case -2050811685:
               if (this.ʰ.ƥ == var1.sideHit) {
                  var3 = -1658675373 ^ -750088129;
                  if (var2 == 0) {
                     break;
                  }
               }

               var3 = -378910016 ^ -750088129;
               if (var2 == 0) {
                  break;
               }
            case 359096820:
               int var6;
               label74: {
                  label73: {
                     try {
                        var6 = this.ʰ.ѱ.equals(var1.getBlockPos());
                        if (var2 != 0) {
                           break label74;
                        }

                        if (var6 == 0) {
                           break label73;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var3 = 1451854052 ^ -750088129;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var6 = -378910016 ^ -750088129;
               }

               var3 = var6;
               if (var2 == 0) {
                  break;
               }
            case 878086135:
               return true;
            case 410205795:
               if (var1.hitVec != null) {
                  var3 = -970067509 ^ -750088129;
                  if (var2 == 0) {
                     break;
                  }
               }

               var3 = -378910016 ^ -750088129;
               break;
            case 2019096647:
               if (var1 != null) {
                  var3 = -885412260 ^ -750088129;
                  if (var2 == 0) {
                     break;
                  }
               }

               var3 = -378910016 ^ -750088129;
               if (var2 == 0) {
                  break;
               }
            case 1315442540:
               int var10000;
               label65: {
                  label64: {
                     try {
                        var10000 = this.ʰ.η.equals(var1.getBlockPos().offset(var1.sideHit));
                        if (var2 != 0) {
                           break label65;
                        }

                        if (var10000 == 0) {
                           break label64;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var3 = -417589304 ^ -750088129;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var10000 = -378910016 ^ -750088129;
               }

               var3 = var10000;
               if (var2 == 0) {
                  break;
               }
            case 975231743:
               return false;
            default:
               throw null;
         }
      }
   }

   private boolean ƿ(BlockPos param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: aload 0
      // 004: invokevirtual x/oca3ff10b94f.ƶ ()Lnet/minecraft/util/BlockPos;
      // 007: astore 3
      // 008: istore 2
      // 009: aload 1
      // 00a: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 00d: iload 2
      // 00e: ifne 086
      // 011: iflt 085
      // 014: goto 018
      // 017: athrow
      // 018: aload 1
      // 019: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 01c: iload 2
      // 01d: ifne 086
      // 020: goto 024
      // 023: athrow
      // 024: ldc_w 928844699
      // 027: ldc_w 928844443
      // 02a: ixor
      // 02b: if_icmpge 085
      // 02e: goto 032
      // 031: athrow
      // 032: aload 1
      // 033: aload 3
      // 034: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 037: iload 2
      // 038: ifne 086
      // 03b: goto 03f
      // 03e: athrow
      // 03f: ifne 085
      // 042: goto 046
      // 045: athrow
      // 046: aload 1
      // 047: aload 3
      // 048: invokevirtual net/minecraft/util/BlockPos.up ()Lnet/minecraft/util/BlockPos;
      // 04b: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 04e: iload 2
      // 04f: ifne 086
      // 052: goto 056
      // 055: athrow
      // 056: ifne 085
      // 059: goto 05d
      // 05c: athrow
      // 05d: aload 0
      // 05e: aload 1
      // 05f: invokevirtual x/oca3ff10b94f.Ͱ (Lnet/minecraft/util/BlockPos;)Z
      // 062: iload 2
      // 063: ifne 086
      // 066: goto 06a
      // 069: athrow
      // 06a: ifne 085
      // 06d: goto 071
      // 070: athrow
      // 071: aload 0
      // 072: aload 1
      // 073: invokevirtual x/oca3ff10b94f.Ү (Lnet/minecraft/util/BlockPos;)Z
      // 076: iload 2
      // 077: ifne 0a2
      // 07a: goto 07e
      // 07d: athrow
      // 07e: ifne 087
      // 081: goto 085
      // 084: athrow
      // 085: bipush 0
      // 086: ireturn
      // 087: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 08a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 08d: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 090: new net/minecraft/util/AxisAlignedBB
      // 093: dup
      // 094: aload 1
      // 095: aload 1
      // 096: bipush 1
      // 097: bipush 1
      // 098: bipush 1
      // 099: invokevirtual net/minecraft/util/BlockPos.add (III)Lnet/minecraft/util/BlockPos;
      // 09c: invokespecial net/minecraft/util/AxisAlignedBB.<init> (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/BlockPos;)V
      // 09f: invokevirtual net/minecraft/util/AxisAlignedBB.intersectsWith (Lnet/minecraft/util/AxisAlignedBB;)Z
      // 0a2: iload 2
      // 0a3: ifne 0b7
      // 0a6: ifeq 0b0
      // 0a9: goto 0ad
      // 0ac: athrow
      // 0ad: bipush 0
      // 0ae: ireturn
      // 0af: athrow
      // 0b0: aload 0
      // 0b1: getfield x/oca3ff10b94f.ç Lx/occ2f8dff8d8;
      // 0b4: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0b7: iload 2
      // 0b8: ifne 115
      // 0bb: ifeq 114
      // 0be: goto 0c2
      // 0c1: athrow
      // 0c2: aload 0
      // 0c3: aload 1
      // 0c4: invokevirtual net/minecraft/util/BlockPos.down ()Lnet/minecraft/util/BlockPos;
      // 0c7: invokevirtual x/oca3ff10b94f.Ѓ (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/Block;
      // 0ca: getstatic net/minecraft/init/Blocks.bed Lnet/minecraft/block/Block;
      // 0cd: if_acmpne 0d7
      // 0d0: goto 0d4
      // 0d3: athrow
      // 0d4: bipush 0
      // 0d5: ireturn
      // 0d6: athrow
      // 0d7: getstatic x/oca3ff10b94f.Զ [Lnet/minecraft/util/EnumFacing;
      // 0da: astore 4
      // 0dc: aload 4
      // 0de: arraylength
      // 0df: istore 5
      // 0e1: bipush 0
      // 0e2: istore 6
      // 0e4: iload 6
      // 0e6: iload 5
      // 0e8: if_icmpge 114
      // 0eb: aload 4
      // 0ed: iload 6
      // 0ef: aaload
      // 0f0: astore 7
      // 0f2: iload 2
      // 0f3: ifne 110
      // 0f6: aload 0
      // 0f7: aload 1
      // 0f8: aload 7
      // 0fa: invokevirtual net/minecraft/util/BlockPos.offset (Lnet/minecraft/util/EnumFacing;)Lnet/minecraft/util/BlockPos;
      // 0fd: invokevirtual x/oca3ff10b94f.Ѓ (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/Block;
      // 100: getstatic net/minecraft/init/Blocks.bed Lnet/minecraft/block/Block;
      // 103: if_acmpne 10d
      // 106: goto 10a
      // 109: athrow
      // 10a: bipush 0
      // 10b: ireturn
      // 10c: athrow
      // 10d: iinc 6 1
      // 110: iload 2
      // 111: ifeq 0e4
      // 114: bipush 1
      // 115: ireturn
   }

   private boolean ʃ(BlockPos var1) {
      Block var3 = null;
      int var4 = 1187199081 ^ 1011066412;
      int var2 = oc84f20a0bc5.ė;

      while (true) {
         label143:
         while (true) {
            label141:
            while (true) {
               switch (var4) {
                  case -1399637044:
                     int var13;
                     label118: {
                        label117: {
                           try {
                              var13 = var3 instanceof BlockButton;
                              if (var2 != 0) {
                                 break label118;
                              }

                              if (var13 != 0) {
                                 break label117;
                              }
                           } catch (ocbde1165e4e var9) {
                              throw var9;
                           }

                           var4 = 1504371297 ^ 1011066412;
                           if (var2 == 0) {
                              continue;
                           }
                        }

                        var13 = -6160382 ^ 1011066412;
                     }

                     var4 = var13;
                     if (var2 == 0) {
                        continue;
                     }
                     break;
                  case -1008622034:
                     return false;
                  case 1398718727:
                     break;
                  case 1479387707:
                     break label143;
                  case 1709786189:
                     return true;
                  case 1929370055:
                     break label141;
                  case 2055249477:
                     var3 = this.Ѓ(var1);

                     label129: {
                        label128: {
                           try {
                              if (var2 != 0) {
                                 break label129;
                              }

                              if (var3 == Blocks.air) {
                                 break label128;
                              }
                           } catch (ocbde1165e4e var10) {
                              throw var10;
                           }

                           var4 = 1684933655 ^ 1011066412;
                           if (var2 == 0) {
                              continue;
                           }
                        }

                        var4 = -6160382 ^ 1011066412;
                     }

                     if (var2 == 0) {
                        continue;
                     }
                  case 1491643525:
                     int var10000;
                     label109: {
                        label108: {
                           try {
                              var10000 = var3.isReplaceable(oc69da1aa7f5.ő.theWorld, var1);
                              if (var2 != 0) {
                                 break label109;
                              }

                              if (var10000 != 0) {
                                 break label108;
                              }
                           } catch (ocbde1165e4e var8) {
                              throw var8;
                           }

                           var4 = 1320976363 ^ 1011066412;
                           if (var2 == 0) {
                              continue;
                           }
                        }

                        var10000 = -6160382 ^ 1011066412;
                     }

                     var4 = var10000;
                     if (var2 == 0) {
                        continue;
                     }
                     break label141;
                  default:
                     throw null;
               }

               int var14;
               label96: {
                  label95: {
                     try {
                        var14 = var3 instanceof BlockLever;
                        if (var2 != 0) {
                           break label96;
                        }

                        if (var14 != 0) {
                           break label95;
                        }
                     } catch (ocbde1165e4e var7) {
                        throw var7;
                     }

                     var4 = -1865376288 ^ 1011066412;
                     if (var2 == 0) {
                        continue;
                     }
                  }

                  var14 = -6160382 ^ 1011066412;
               }

               var4 = var14;
               if (var2 != 0) {
                  return false;
               }
            }

            int var11;
            label87: {
               label86: {
                  try {
                     var11 = occb1ed1ed8f.ȼ(var3);
                     if (var2 != 0) {
                        break label87;
                     }

                     if (var11 != 0) {
                        break label86;
                     }
                  } catch (ocbde1165e4e var6) {
                     throw var6;
                  }

                  var4 = 1864197931 ^ 1011066412;
                  if (var2 == 0) {
                     continue;
                  }
               }

               var11 = -6160382 ^ 1011066412;
            }

            var4 = var11;
            if (var2 != 0) {
               break;
            }
         }

         int var12;
         label78: {
            label77: {
               try {
                  var12 = occb1ed1ed8f.ѹ(var3);
                  if (var2 != 0) {
                     break label78;
                  }

                  if (var12 != 0) {
                     break label77;
                  }
               } catch (ocbde1165e4e var5) {
                  throw var5;
               }

               var4 = 1688930985 ^ 1011066412;
               if (var2 == 0) {
                  continue;
               }
            }

            var12 = -6160382 ^ 1011066412;
         }

         var4 = var12;
      }
   }

   private Block Ѓ(BlockPos var1) {
      return oc69da1aa7f5.ő.theWorld.getBlockState(var1).getBlock();
   }

   private boolean Ү(BlockPos var1) {
      return this.Ѓ(var1).isReplaceable(oc69da1aa7f5.ő.theWorld, var1);
   }

   private boolean Κ(ItemStack var1, BlockPos var2, EnumFacing var3) {
      int var4 = oc84f20a0bc5.ė;
      int var5 = -25303136 ^ 1814398209;

      while (true) {
         switch (var5) {
            case -795626019:
               return true;
            case -681130549:
               int var8;
               label57: {
                  label56: {
                     try {
                        var8 = var1.getItem() instanceof ItemBlock;
                        if (var4 != 0) {
                           break label57;
                        }

                        if (var8 == 0) {
                           break label56;
                        }
                     } catch (ocbde1165e4e var7) {
                        throw var7;
                     }

                     var5 = 1535430324 ^ 1814398209;
                     if (var4 == 0) {
                        break;
                     }
                  }

                  var8 = -1288522146 ^ 1814398209;
               }

               var5 = var8;
               if (var4 == 0) {
                  break;
               }
            case -1839701343:
               if (var1 != null) {
                  var5 = -1153220406 ^ 1814398209;
                  if (var4 == 0) {
                     break;
                  }
               }

               var5 = -1288522146 ^ 1814398209;
               if (var4 == 0) {
                  break;
               }

               return false;
            case -552127649:
               return false;
            case 933317557:
               int var10000;
               label44: {
                  label43: {
                     try {
                        var10000 = ((ItemBlock)var1.getItem()).canPlaceBlockOnSide(oc69da1aa7f5.ő.theWorld, var2, var3, oc69da1aa7f5.ő.thePlayer, var1);
                        if (var4 != 0) {
                           break label44;
                        }

                        if (var10000 == 0) {
                           break label43;
                        }
                     } catch (ocbde1165e4e var6) {
                        throw var6;
                     }

                     var5 = -1128910628 ^ 1814398209;
                     if (var4 == 0) {
                        break;
                     }
                  }

                  var10000 = -1288522146 ^ 1814398209;
               }

               var5 = var10000;
               break;
            default:
               throw null;
         }
      }
   }

   private MovingObjectPosition қ(float param1, float param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 06: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 09: fconst_1
      // 0a: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 0d: astore 4
      // 0f: fload 1
      // 10: fload 2
      // 11: invokestatic x/oc7ab2161b9f.ҵ (FF)Lnet/minecraft/util/Vec3;
      // 14: astore 5
      // 16: istore 3
      // 17: aload 0
      // 18: invokevirtual x/oca3ff10b94f.ĸ ()D
      // 1b: dstore 6
      // 1d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 20: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 23: aload 4
      // 25: aload 4
      // 27: aload 5
      // 29: getfield net/minecraft/util/Vec3.xCoord D
      // 2c: dload 6
      // 2e: dmul
      // 2f: aload 5
      // 31: getfield net/minecraft/util/Vec3.yCoord D
      // 34: dload 6
      // 36: dmul
      // 37: aload 5
      // 39: getfield net/minecraft/util/Vec3.zCoord D
      // 3c: dload 6
      // 3e: dmul
      // 3f: invokevirtual net/minecraft/util/Vec3.addVector (DDD)Lnet/minecraft/util/Vec3;
      // 42: bipush 0
      // 43: bipush 0
      // 44: bipush 0
      // 45: invokevirtual net/minecraft/client/multiplayer/WorldClient.rayTraceBlocks (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;ZZZ)Lnet/minecraft/util/MovingObjectPosition;
      // 48: astore 8
      // 4a: aload 8
      // 4c: iload 3
      // 4d: ifne 59
      // 50: ifnull 73
      // 53: goto 57
      // 56: athrow
      // 57: aload 8
      // 59: iload 3
      // 5a: ifne 70
      // 5d: getfield net/minecraft/util/MovingObjectPosition.typeOfHit Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 60: getstatic net/minecraft/util/MovingObjectPosition$MovingObjectType.BLOCK Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 63: if_acmpne 73
      // 66: goto 6a
      // 69: athrow
      // 6a: aload 8
      // 6c: goto 70
      // 6f: athrow
      // 70: goto 74
      // 73: aconst_null
      // 74: areturn
   }

   private double ĸ() {
      return oc69da1aa7f5.ő.playerController.getBlockReachDistance();
   }

   private BlockPos ƶ() {
      return new BlockPos(oc69da1aa7f5.ő.thePlayer.posX, oc69da1aa7f5.ő.thePlayer.posY, oc69da1aa7f5.ő.thePlayer.posZ);
   }

   private void ȩ() {
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
      // 05: bipush 0
      // 06: istore 3
      // 07: aload 0
      // 08: invokevirtual x/oca3ff10b94f.ƶ ()Lnet/minecraft/util/BlockPos;
      // 0b: invokestatic x/oca3ff10b94f.Ӿ (Lnet/minecraft/util/BlockPos;)Ljava/util/List;
      // 0e: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 13: astore 4
      // 15: istore 1
      // 16: aload 4
      // 18: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 1d: ifeq 60
      // 20: aload 4
      // 22: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 27: checkcast net/minecraft/util/BlockPos
      // 2a: astore 5
      // 2c: iload 1
      // 2d: ifne 77
      // 30: iload 1
      // 31: ifne 4c
      // 34: goto 38
      // 37: athrow
      // 38: aload 0
      // 39: aload 5
      // 3b: invokevirtual x/oca3ff10b94f.Ͱ (Lnet/minecraft/util/BlockPos;)Z
      // 3e: ifeq 49
      // 41: goto 45
      // 44: athrow
      // 45: goto 16
      // 48: athrow
      // 49: iinc 3 1
      // 4c: aload 0
      // 4d: aload 5
      // 4f: invokevirtual x/oca3ff10b94f.ʃ (Lnet/minecraft/util/BlockPos;)Z
      // 52: ifeq 5c
      // 55: iinc 2 1
      // 58: goto 5c
      // 5b: athrow
      // 5c: iload 1
      // 5d: ifeq 16
      // 60: iload 3
      // 61: iload 1
      // 62: ifne 78
      // 65: ifne 77
      // 68: goto 6c
      // 6b: athrow
      // 6c: ldc_w 1819924246
      // 6f: ldc_w 1819924338
      // 72: ixor
      // 73: goto 83
      // 76: athrow
      // 77: iload 2
      // 78: i2f
      // 79: ldc_w 100.0
      // 7c: fmul
      // 7d: iload 3
      // 7e: i2f
      // 7f: fdiv
      // 80: invokestatic java/lang/Math.round (F)I
      // 83: istore 4
      // 85: aload 0
      // 86: iload 4
      // 88: iload 1
      // 89: ifne b0
      // 8c: invokedynamic makeConcatWithConstants (I)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001%" ]
      // 91: putfield x/oca3ff10b94f.ͼ Ljava/lang/String;
      // 94: aload 0
      // 95: iload 4
      // 97: ldc_w 1819924246
      // 9a: ldc_w 1819924338
      // 9d: ixor
      // 9e: if_icmpne b3
      // a1: goto a5
      // a4: athrow
      // a5: ldc_w 1819879538
      // a8: ldc_w 1819924338
      // ab: ixor
      // ac: goto b0
      // af: athrow
      // b0: goto ba
      // b3: ldc_w 1820731533
      // b6: ldc_w 1819924338
      // b9: ixor
      // ba: putfield x/oca3ff10b94f.ȣ I
      // bd: iload 4
      // bf: iload 1
      // c0: ifne e4
      // c3: ldc_w 1819924246
      // c6: ldc_w 1819924338
      // c9: ixor
      // ca: if_icmpne f4
      // cd: goto d1
      // d0: athrow
      // d1: aload 0
      // d2: iload 1
      // d3: ifne f0
      // d6: goto da
      // d9: athrow
      // da: getfield x/oca3ff10b94f.g Lx/occ2f8dff8d8;
      // dd: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // e0: goto e4
      // e3: athrow
      // e4: ifeq f4
      // e7: aload 0
      // e8: invokevirtual x/oca3ff10b94f.Ѽ ()V
      // eb: aload 0
      // ec: goto f0
      // ef: athrow
      // f0: bipush 1
      // f1: putfield x/oca3ff10b94f.ʳ Z
      // f4: return
   }

   private void Ҧ(boolean param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: iload 1
      // 05: ifeq 37
      // 08: aload 0
      // 09: invokevirtual x/oca3ff10b94f.ό ()Lnet/minecraft/util/Vec3;
      // 0c: astore 3
      // 0d: iload 2
      // 0e: ifne 22
      // 11: aload 3
      // 12: ifnull 37
      // 15: goto 19
      // 18: athrow
      // 19: aload 0
      // 1a: aload 3
      // 1b: putfield x/oca3ff10b94f.ʱ Lnet/minecraft/util/Vec3;
      // 1e: goto 22
      // 21: athrow
      // 22: aload 0
      // 23: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 26: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 29: getfield net/minecraft/client/entity/EntityPlayerSP.ticksExisted I
      // 2c: ldc_w 533936502
      // 2f: ldc_w 533936482
      // 32: ixor
      // 33: iadd
      // 34: putfield x/oca3ff10b94f.Ǐ I
      // 37: getstatic x/oc9755810e45.ϔ Lx/oc8edd24b1ed;
      // 3a: iload 2
      // 3b: ifne 48
      // 3e: ifnull 4e
      // 41: goto 45
      // 44: athrow
      // 45: getstatic x/oc9755810e45.ϔ Lx/oc8edd24b1ed;
      // 48: invokevirtual x/oc8edd24b1ed.Ъ ()Lnet/minecraft/util/Vec3;
      // 4b: goto 4f
      // 4e: aconst_null
      // 4f: astore 3
      // 50: iload 2
      // 51: ifne 8b
      // 54: aload 3
      // 55: ifnonnull 75
      // 58: goto 5c
      // 5b: athrow
      // 5c: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 5f: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 62: getfield net/minecraft/client/entity/EntityPlayerSP.ticksExisted I
      // 65: aload 0
      // 66: getfield x/oca3ff10b94f.Ǐ I
      // 69: if_icmpgt 75
      // 6c: goto 70
      // 6f: athrow
      // 70: aload 0
      // 71: getfield x/oca3ff10b94f.ʱ Lnet/minecraft/util/Vec3;
      // 74: astore 3
      // 75: aload 0
      // 76: aload 0
      // 77: invokevirtual x/oca3ff10b94f.ƶ ()Lnet/minecraft/util/BlockPos;
      // 7a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 7d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 80: fconst_1
      // 81: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 84: aload 3
      // 85: invokestatic x/oca3ff10b94f.ɠ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/BlockPos;
      // 88: putfield x/oca3ff10b94f.Π Lnet/minecraft/util/BlockPos;
      // 8b: return
   }

   private Vec3 ό() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: aload 0
      // 04: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 07: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0a: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 0d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 10: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 13: getfield net/minecraft/client/entity/EntityPlayerSP.rotationPitch F
      // 16: invokevirtual x/oca3ff10b94f.қ (FF)Lnet/minecraft/util/MovingObjectPosition;
      // 19: astore 2
      // 1a: istore 1
      // 1b: aload 2
      // 1c: iload 1
      // 1d: ifne 28
      // 20: ifnull 5c
      // 23: goto 27
      // 26: athrow
      // 27: aload 2
      // 28: iload 1
      // 29: ifne 3e
      // 2c: getfield net/minecraft/util/MovingObjectPosition.typeOfHit Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 2f: getstatic net/minecraft/util/MovingObjectPosition$MovingObjectType.BLOCK Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 32: if_acmpne 5c
      // 35: goto 39
      // 38: athrow
      // 39: aload 2
      // 3a: goto 3e
      // 3d: athrow
      // 3e: iload 1
      // 3f: ifne 55
      // 42: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 45: ifnull 54
      // 48: goto 4c
      // 4b: athrow
      // 4c: aload 2
      // 4d: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 50: goto 5b
      // 53: athrow
      // 54: aload 2
      // 55: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 58: invokestatic x/oca3ff10b94f.ȑ (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/util/Vec3;
      // 5b: areturn
      // 5c: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 5f: iload 1
      // 60: ifne 77
      // 63: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 66: instanceof x/oc51cbcffcfe
      // 69: ifeq af
      // 6c: goto 70
      // 6f: athrow
      // 70: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 73: goto 77
      // 76: athrow
      // 77: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 7a: astore 3
      // 7b: aload 3
      // 7c: iload 1
      // 7d: ifne 91
      // 80: invokeinterface x/oc51cbcffcfe.isHittingBlock ()Z 1
      // 85: ifeq af
      // 88: goto 8c
      // 8b: athrow
      // 8c: aload 3
      // 8d: goto 91
      // 90: athrow
      // 91: iload 1
      // 92: ifne a6
      // 95: invokeinterface x/oc51cbcffcfe.getCurrentBlock ()Lnet/minecraft/util/BlockPos; 1
      // 9a: ifnull af
      // 9d: goto a1
      // a0: athrow
      // a1: aload 3
      // a2: goto a6
      // a5: athrow
      // a6: invokeinterface x/oc51cbcffcfe.getCurrentBlock ()Lnet/minecraft/util/BlockPos; 1
      // ab: invokestatic x/oca3ff10b94f.ȑ (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/util/Vec3;
      // ae: areturn
      // af: aconst_null
      // b0: areturn
   }

   private boolean Ͱ(BlockPos var1) {
      int var2 = oc84f20a0bc5.ė;
      int var3 = -1694135718 ^ 836950545;

      while (true) {
         switch (var3) {
            case -1427681205:
               if (var1 != null) {
                  var3 = -196914301 ^ 836950545;
                  if (var2 == 0) {
                     break;
                  }
               }

               var3 = -931657767 ^ 836950545;
               if (var2 == 0) {
                  break;
               }
            case -979269230:
               int var10000;
               label35: {
                  label34: {
                     try {
                        var10000 = var1.equals(this.Π);
                        if (var2 != 0) {
                           break label35;
                        }

                        if (var10000 == 0) {
                           break label34;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var3 = -799112821 ^ 836950545;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var10000 = -931657767 ^ 836950545;
               }

               var3 = var10000;
               if (var2 == 0) {
                  break;
               }
            case -507749478:
               return true;
            case -107291192:
               return false;
            default:
               throw null;
         }
      }
   }

   private static Vec3 ȑ(BlockPos var0) {
      return new Vec3(var0.getX() + 0.5, var0.getY() + 0.5, var0.getZ() + 0.5);
   }

   private static List<BlockPos> Ӿ(BlockPos var0) {
      int var10000 = oc84f20a0bc5.ė;
      ArrayList var2 = new ArrayList(479629329 ^ 479629336);
      var2.add(var0.up(479629338 ^ 479629336));
      EnumFacing[] var3 = Զ;
      int var4 = var3.length;
      int var5 = 0;
      int var1 = var10000;

      while (true) {
         if (var5 < var4) {
            EnumFacing var6 = var3[var5];
            BlockPos var7 = var0.offset(var6);

            try {
               var9 = var2;
               if (var1 != 0) {
                  break;
               }

               var2.add(var7);
               var2.add(var7.up());
               var5++;
               if (var1 == 0) {
                  continue;
               }
            } catch (ocbde1165e4e var8) {
               throw var8;
            }
         }

         var9 = var2;
         break;
      }

      return var9;
   }

   static BlockPos ɠ(BlockPos param0, Vec3 param1, Vec3 param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 3
      // 04: aload 0
      // 05: ifnull 1c
      // 08: aload 1
      // 09: iload 3
      // 0a: ifne 19
      // 0d: goto 11
      // 10: athrow
      // 11: ifnull 1c
      // 14: goto 18
      // 17: athrow
      // 18: aload 2
      // 19: ifnonnull 1f
      // 1c: aconst_null
      // 1d: areturn
      // 1e: athrow
      // 1f: aconst_null
      // 20: astore 4
      // 22: ldc2_w 1.7976931348623157E308
      // 25: dstore 5
      // 27: aload 0
      // 28: invokestatic x/oca3ff10b94f.Ӿ (Lnet/minecraft/util/BlockPos;)Ljava/util/List;
      // 2b: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 30: astore 7
      // 32: aload 7
      // 34: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 39: ifeq af
      // 3c: aload 7
      // 3e: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 43: checkcast net/minecraft/util/BlockPos
      // 46: iload 3
      // 47: ifne b1
      // 4a: goto 4e
      // 4d: athrow
      // 4e: astore 8
      // 50: new net/minecraft/util/AxisAlignedBB
      // 53: dup
      // 54: aload 8
      // 56: aload 8
      // 58: bipush 1
      // 59: bipush 1
      // 5a: bipush 1
      // 5b: invokevirtual net/minecraft/util/BlockPos.add (III)Lnet/minecraft/util/BlockPos;
      // 5e: invokespecial net/minecraft/util/AxisAlignedBB.<init> (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/BlockPos;)V
      // 61: aload 1
      // 62: aload 2
      // 63: invokevirtual net/minecraft/util/AxisAlignedBB.calculateIntercept (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/MovingObjectPosition;
      // 66: astore 9
      // 68: aload 9
      // 6a: iload 3
      // 6b: ifne 77
      // 6e: ifnull 32
      // 71: goto 75
      // 74: athrow
      // 75: aload 9
      // 77: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 7a: iload 3
      // 7b: ifne 89
      // 7e: ifnonnull 88
      // 81: goto 85
      // 84: athrow
      // 85: goto 32
      // 88: aload 1
      // 89: aload 9
      // 8b: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 8e: invokevirtual net/minecraft/util/Vec3.squareDistanceTo (Lnet/minecraft/util/Vec3;)D
      // 91: dstore 10
      // 93: iload 3
      // 94: ifne a7
      // 97: dload 10
      // 99: dload 5
      // 9b: dcmpg
      // 9c: ifge ab
      // 9f: goto a3
      // a2: athrow
      // a3: aload 8
      // a5: astore 4
      // a7: dload 10
      // a9: dstore 5
      // ab: iload 3
      // ac: ifeq 32
      // af: aload 4
      // b1: areturn
   }

   static {
      EnumFacing[] var10000 = new EnumFacing[1432471240 ^ 1432471244];
      var10000[0] = EnumFacing.EAST;
      var10000[1] = EnumFacing.SOUTH;
      var10000[1432471246 ^ 1432471244] = EnumFacing.WEST;
      var10000[1432471247 ^ 1432471244] = EnumFacing.NORTH;
      Զ = var10000;
      var10000 = new EnumFacing[1432471242 ^ 1432471244];
      var10000[0] = EnumFacing.NORTH;
      var10000[1] = EnumFacing.SOUTH;
      var10000[1432471246 ^ 1432471244] = EnumFacing.WEST;
      var10000[1432471247 ^ 1432471244] = EnumFacing.EAST;
      var10000[1432471240 ^ 1432471244] = EnumFacing.UP;
      var10000[1432471241 ^ 1432471244] = EnumFacing.DOWN;
      ʕ = var10000;
      var10000 = new EnumFacing[1432471242 ^ 1432471244];
      var10000[0] = EnumFacing.UP;
      var10000[1] = EnumFacing.NORTH;
      var10000[1432471246 ^ 1432471244] = EnumFacing.SOUTH;
      var10000[1432471247 ^ 1432471244] = EnumFacing.WEST;
      var10000[1432471240 ^ 1432471244] = EnumFacing.EAST;
      var10000[1432471241 ^ 1432471244] = EnumFacing.DOWN;
      Ƭ = var10000;
   }
}

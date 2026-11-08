package x;

import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;

public class occb1ed1ed8f implements ocda171fe5d8 {
   public static boolean ǐ;

   public static boolean Ŀ(BlockPos param0, BlockPos param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 16
      // 09: aload 1
      // 0a: if_acmpeq 56
      // 0d: goto 11
      // 10: athrow
      // 11: aload 0
      // 12: goto 16
      // 15: athrow
      // 16: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 19: iload 2
      // 1a: ifne 30
      // 1d: aload 1
      // 1e: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 21: if_icmpne 5e
      // 24: goto 28
      // 27: athrow
      // 28: aload 0
      // 29: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 2c: goto 30
      // 2f: athrow
      // 30: aload 1
      // 31: iload 2
      // 32: ifne 50
      // 35: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 38: if_icmpne 5e
      // 3b: goto 3f
      // 3e: athrow
      // 3f: aload 0
      // 40: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 43: iload 2
      // 44: ifne 5b
      // 47: goto 4b
      // 4a: athrow
      // 4b: aload 1
      // 4c: goto 50
      // 4f: athrow
      // 50: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 53: if_icmpne 5e
      // 56: bipush 1
      // 57: goto 5b
      // 5a: athrow
      // 5b: goto 5f
      // 5e: bipush 0
      // 5f: ireturn
   }

   public static boolean Ǣ(Block param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 1
      // 04: aload 0
      // 05: instanceof net/minecraft/block/BlockFenceGate
      // 08: iload 1
      // 09: ifne ac
      // 0c: ifne ab
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: instanceof net/minecraft/block/BlockLadder
      // 17: iload 1
      // 18: ifne ac
      // 1b: goto 1f
      // 1e: athrow
      // 1f: ifne ab
      // 22: goto 26
      // 25: athrow
      // 26: aload 0
      // 27: instanceof net/minecraft/block/BlockFlowerPot
      // 2a: iload 1
      // 2b: ifne ac
      // 2e: goto 32
      // 31: athrow
      // 32: ifne ab
      // 35: goto 39
      // 38: athrow
      // 39: aload 0
      // 3a: instanceof net/minecraft/block/BlockBasePressurePlate
      // 3d: iload 1
      // 3e: ifne ac
      // 41: goto 45
      // 44: athrow
      // 45: ifne ab
      // 48: goto 4c
      // 4b: athrow
      // 4c: aload 0
      // 4d: invokestatic x/occb1ed1ed8f.ѹ (Lnet/minecraft/block/Block;)Z
      // 50: iload 1
      // 51: ifne ac
      // 54: goto 58
      // 57: athrow
      // 58: ifne ab
      // 5b: goto 5f
      // 5e: athrow
      // 5f: aload 0
      // 60: instanceof net/minecraft/block/BlockFence
      // 63: iload 1
      // 64: ifne ac
      // 67: goto 6b
      // 6a: athrow
      // 6b: ifne ab
      // 6e: goto 72
      // 71: athrow
      // 72: aload 0
      // 73: instanceof net/minecraft/block/BlockAnvil
      // 76: iload 1
      // 77: ifne ac
      // 7a: goto 7e
      // 7d: athrow
      // 7e: ifne ab
      // 81: goto 85
      // 84: athrow
      // 85: aload 0
      // 86: instanceof net/minecraft/block/BlockEnchantmentTable
      // 89: iload 1
      // 8a: ifne ac
      // 8d: goto 91
      // 90: athrow
      // 91: ifne ab
      // 94: goto 98
      // 97: athrow
      // 98: aload 0
      // 99: instanceof net/minecraft/block/BlockChest
      // 9c: iload 1
      // 9d: ifne ac
      // a0: goto a4
      // a3: athrow
      // a4: ifeq af
      // a7: goto ab
      // aa: athrow
      // ab: bipush 1
      // ac: goto b0
      // af: bipush 0
      // b0: ireturn
   }

   public static boolean Ў(Block param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 18
      // 09: getstatic net/minecraft/init/Blocks.glass Lnet/minecraft/block/Block;
      // 0c: if_acmpeq dc
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: iload 1
      // 19: ifne 2b
      // 1c: invokevirtual net/minecraft/block/Block.isFullBlock ()Z
      // 1f: ifeq e1
      // 22: goto 26
      // 25: athrow
      // 26: aload 0
      // 27: goto 2b
      // 2a: athrow
      // 2b: iload 1
      // 2c: ifne 3e
      // 2f: getstatic net/minecraft/init/Blocks.gravel Lnet/minecraft/block/Block;
      // 32: if_acmpeq e1
      // 35: goto 39
      // 38: athrow
      // 39: aload 0
      // 3a: goto 3e
      // 3d: athrow
      // 3e: iload 1
      // 3f: ifne 51
      // 42: getstatic net/minecraft/init/Blocks.sand Lnet/minecraft/block/BlockSand;
      // 45: if_acmpeq e1
      // 48: goto 4c
      // 4b: athrow
      // 4c: aload 0
      // 4d: goto 51
      // 50: athrow
      // 51: iload 1
      // 52: ifne 64
      // 55: getstatic net/minecraft/init/Blocks.soul_sand Lnet/minecraft/block/Block;
      // 58: if_acmpeq e1
      // 5b: goto 5f
      // 5e: athrow
      // 5f: aload 0
      // 60: goto 64
      // 63: athrow
      // 64: iload 1
      // 65: ifne 77
      // 68: getstatic net/minecraft/init/Blocks.tnt Lnet/minecraft/block/Block;
      // 6b: if_acmpeq e1
      // 6e: goto 72
      // 71: athrow
      // 72: aload 0
      // 73: goto 77
      // 76: athrow
      // 77: iload 1
      // 78: ifne 8a
      // 7b: getstatic net/minecraft/init/Blocks.crafting_table Lnet/minecraft/block/Block;
      // 7e: if_acmpeq e1
      // 81: goto 85
      // 84: athrow
      // 85: aload 0
      // 86: goto 8a
      // 89: athrow
      // 8a: iload 1
      // 8b: ifne 9d
      // 8e: getstatic net/minecraft/init/Blocks.furnace Lnet/minecraft/block/Block;
      // 91: if_acmpeq e1
      // 94: goto 98
      // 97: athrow
      // 98: aload 0
      // 99: goto 9d
      // 9c: athrow
      // 9d: iload 1
      // 9e: ifne b0
      // a1: getstatic net/minecraft/init/Blocks.dispenser Lnet/minecraft/block/Block;
      // a4: if_acmpeq e1
      // a7: goto ab
      // aa: athrow
      // ab: aload 0
      // ac: goto b0
      // af: athrow
      // b0: iload 1
      // b1: ifne c3
      // b4: getstatic net/minecraft/init/Blocks.dropper Lnet/minecraft/block/Block;
      // b7: if_acmpeq e1
      // ba: goto be
      // bd: athrow
      // be: aload 0
      // bf: goto c3
      // c2: athrow
      // c3: iload 1
      // c4: ifne d6
      // c7: getstatic net/minecraft/init/Blocks.noteblock Lnet/minecraft/block/Block;
      // ca: if_acmpeq e1
      // cd: goto d1
      // d0: athrow
      // d1: aload 0
      // d2: goto d6
      // d5: athrow
      // d6: getstatic net/minecraft/init/Blocks.command_block Lnet/minecraft/block/Block;
      // d9: if_acmpeq e1
      // dc: bipush 1
      // dd: goto e2
      // e0: athrow
      // e1: bipush 0
      // e2: ireturn
   }

   public static BlockPos Ƀ(double var0, double var2, double var4) {
      return new BlockPos(var0, var2, var4);
   }

   public static boolean ņ(BlockPos param0, BlockPos param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 16
      // 09: aload 1
      // 0a: if_acmpeq 56
      // 0d: goto 11
      // 10: athrow
      // 11: aload 0
      // 12: goto 16
      // 15: athrow
      // 16: iload 2
      // 17: ifne 2d
      // 1a: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 1d: aload 1
      // 1e: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 21: if_icmpne 5e
      // 24: goto 28
      // 27: athrow
      // 28: aload 0
      // 29: goto 2d
      // 2c: athrow
      // 2d: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 30: aload 1
      // 31: iload 2
      // 32: ifne 50
      // 35: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 38: if_icmpne 5e
      // 3b: goto 3f
      // 3e: athrow
      // 3f: aload 0
      // 40: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 43: iload 2
      // 44: ifne 5b
      // 47: goto 4b
      // 4a: athrow
      // 4b: aload 1
      // 4c: goto 50
      // 4f: athrow
      // 50: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 53: if_icmpne 5e
      // 56: bipush 1
      // 57: goto 5b
      // 5a: athrow
      // 5b: goto 5f
      // 5e: bipush 0
      // 5f: ireturn
   }

   public static BlockPos ä(MovingObjectPosition var0) {
      return var0.getBlockPos().offset(var0.sideHit);
   }

   public static boolean ѹ(Block param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 1b
      // 09: invokevirtual net/minecraft/block/Block.getMaterial ()Lnet/minecraft/block/material/Material;
      // 0c: getstatic net/minecraft/block/material/Material.lava Lnet/minecraft/block/material/Material;
      // 0f: if_acmpeq 24
      // 12: goto 16
      // 15: athrow
      // 16: aload 0
      // 17: goto 1b
      // 1a: athrow
      // 1b: invokevirtual net/minecraft/block/Block.getMaterial ()Lnet/minecraft/block/material/Material;
      // 1e: getstatic net/minecraft/block/material/Material.water Lnet/minecraft/block/material/Material;
      // 21: if_acmpne 29
      // 24: bipush 1
      // 25: goto 2a
      // 28: athrow
      // 29: bipush 0
      // 2a: ireturn
   }

   public static boolean ȼ(Block param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 1
      // 004: aload 0
      // 005: instanceof net/minecraft/block/BlockTrapDoor
      // 008: iload 1
      // 009: ifne 131
      // 00c: ifne 130
      // 00f: goto 013
      // 012: athrow
      // 013: aload 0
      // 014: instanceof net/minecraft/block/BlockDoor
      // 017: iload 1
      // 018: ifne 131
      // 01b: goto 01f
      // 01e: athrow
      // 01f: ifne 130
      // 022: goto 026
      // 025: athrow
      // 026: aload 0
      // 027: instanceof net/minecraft/block/BlockContainer
      // 02a: iload 1
      // 02b: ifne 131
      // 02e: goto 032
      // 031: athrow
      // 032: ifne 130
      // 035: goto 039
      // 038: athrow
      // 039: aload 0
      // 03a: instanceof net/minecraft/block/BlockJukebox
      // 03d: iload 1
      // 03e: ifne 131
      // 041: goto 045
      // 044: athrow
      // 045: ifne 130
      // 048: goto 04c
      // 04b: athrow
      // 04c: aload 0
      // 04d: instanceof net/minecraft/block/BlockFenceGate
      // 050: iload 1
      // 051: ifne 131
      // 054: goto 058
      // 057: athrow
      // 058: ifne 130
      // 05b: goto 05f
      // 05e: athrow
      // 05f: aload 0
      // 060: instanceof net/minecraft/block/BlockChest
      // 063: iload 1
      // 064: ifne 131
      // 067: goto 06b
      // 06a: athrow
      // 06b: ifne 130
      // 06e: goto 072
      // 071: athrow
      // 072: aload 0
      // 073: instanceof net/minecraft/block/BlockEnderChest
      // 076: iload 1
      // 077: ifne 131
      // 07a: goto 07e
      // 07d: athrow
      // 07e: ifne 130
      // 081: goto 085
      // 084: athrow
      // 085: aload 0
      // 086: instanceof net/minecraft/block/BlockEnchantmentTable
      // 089: iload 1
      // 08a: ifne 131
      // 08d: goto 091
      // 090: athrow
      // 091: ifne 130
      // 094: goto 098
      // 097: athrow
      // 098: aload 0
      // 099: instanceof net/minecraft/block/BlockBrewingStand
      // 09c: iload 1
      // 09d: ifne 131
      // 0a0: goto 0a4
      // 0a3: athrow
      // 0a4: ifne 130
      // 0a7: goto 0ab
      // 0aa: athrow
      // 0ab: aload 0
      // 0ac: instanceof net/minecraft/block/BlockBed
      // 0af: iload 1
      // 0b0: ifne 131
      // 0b3: goto 0b7
      // 0b6: athrow
      // 0b7: ifne 130
      // 0ba: goto 0be
      // 0bd: athrow
      // 0be: aload 0
      // 0bf: instanceof net/minecraft/block/BlockDropper
      // 0c2: iload 1
      // 0c3: ifne 131
      // 0c6: goto 0ca
      // 0c9: athrow
      // 0ca: ifne 130
      // 0cd: goto 0d1
      // 0d0: athrow
      // 0d1: aload 0
      // 0d2: instanceof net/minecraft/block/BlockDispenser
      // 0d5: iload 1
      // 0d6: ifne 131
      // 0d9: goto 0dd
      // 0dc: athrow
      // 0dd: ifne 130
      // 0e0: goto 0e4
      // 0e3: athrow
      // 0e4: aload 0
      // 0e5: instanceof net/minecraft/block/BlockHopper
      // 0e8: iload 1
      // 0e9: ifne 131
      // 0ec: goto 0f0
      // 0ef: athrow
      // 0f0: ifne 130
      // 0f3: goto 0f7
      // 0f6: athrow
      // 0f7: aload 0
      // 0f8: instanceof net/minecraft/block/BlockAnvil
      // 0fb: iload 1
      // 0fc: ifne 131
      // 0ff: goto 103
      // 102: athrow
      // 103: ifne 130
      // 106: goto 10a
      // 109: athrow
      // 10a: aload 0
      // 10b: instanceof net/minecraft/block/BlockNote
      // 10e: iload 1
      // 10f: ifne 131
      // 112: goto 116
      // 115: athrow
      // 116: ifne 130
      // 119: goto 11d
      // 11c: athrow
      // 11d: aload 0
      // 11e: instanceof net/minecraft/block/BlockWorkbench
      // 121: iload 1
      // 122: ifne 131
      // 125: goto 129
      // 128: athrow
      // 129: ifeq 134
      // 12c: goto 130
      // 12f: athrow
      // 130: bipush 1
      // 131: goto 135
      // 134: bipush 0
      // 135: ireturn
   }

   public static boolean ԣ(Block param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 1
      // 004: aload 0
      // 005: iload 1
      // 006: ifne 017
      // 009: instanceof net/minecraft/block/BlockStairs
      // 00c: ifeq 016
      // 00f: goto 013
      // 012: athrow
      // 013: bipush 0
      // 014: ireturn
      // 015: athrow
      // 016: aload 0
      // 017: iload 1
      // 018: ifne 029
      // 01b: instanceof net/minecraft/block/BlockSlab
      // 01e: ifeq 028
      // 021: goto 025
      // 024: athrow
      // 025: bipush 0
      // 026: ireturn
      // 027: athrow
      // 028: aload 0
      // 029: iload 1
      // 02a: ifne 03b
      // 02d: instanceof net/minecraft/block/BlockEndPortalFrame
      // 030: ifeq 03a
      // 033: goto 037
      // 036: athrow
      // 037: bipush 0
      // 038: ireturn
      // 039: athrow
      // 03a: aload 0
      // 03b: iload 1
      // 03c: ifne 04d
      // 03f: instanceof net/minecraft/block/BlockEndPortal
      // 042: ifeq 04c
      // 045: goto 049
      // 048: athrow
      // 049: bipush 0
      // 04a: ireturn
      // 04b: athrow
      // 04c: aload 0
      // 04d: iload 1
      // 04e: ifne 05f
      // 051: instanceof net/minecraft/block/BlockVine
      // 054: ifeq 05e
      // 057: goto 05b
      // 05a: athrow
      // 05b: bipush 0
      // 05c: ireturn
      // 05d: athrow
      // 05e: aload 0
      // 05f: iload 1
      // 060: ifne 071
      // 063: instanceof net/minecraft/block/BlockPumpkin
      // 066: ifeq 070
      // 069: goto 06d
      // 06c: athrow
      // 06d: bipush 0
      // 06e: ireturn
      // 06f: athrow
      // 070: aload 0
      // 071: iload 1
      // 072: ifne 083
      // 075: instanceof net/minecraft/block/BlockCactus
      // 078: ifeq 082
      // 07b: goto 07f
      // 07e: athrow
      // 07f: bipush 0
      // 080: ireturn
      // 081: athrow
      // 082: aload 0
      // 083: iload 1
      // 084: ifne 095
      // 087: instanceof net/minecraft/block/BlockBush
      // 08a: ifeq 094
      // 08d: goto 091
      // 090: athrow
      // 091: bipush 0
      // 092: ireturn
      // 093: athrow
      // 094: aload 0
      // 095: iload 1
      // 096: ifne 0a7
      // 099: instanceof net/minecraft/block/BlockFalling
      // 09c: ifeq 0a6
      // 09f: goto 0a3
      // 0a2: athrow
      // 0a3: bipush 0
      // 0a4: ireturn
      // 0a5: athrow
      // 0a6: aload 0
      // 0a7: iload 1
      // 0a8: ifne 0b9
      // 0ab: instanceof net/minecraft/block/BlockWeb
      // 0ae: ifeq 0b8
      // 0b1: goto 0b5
      // 0b4: athrow
      // 0b5: bipush 0
      // 0b6: ireturn
      // 0b7: athrow
      // 0b8: aload 0
      // 0b9: iload 1
      // 0ba: ifne 0cb
      // 0bd: instanceof net/minecraft/block/BlockPane
      // 0c0: ifeq 0ca
      // 0c3: goto 0c7
      // 0c6: athrow
      // 0c7: bipush 0
      // 0c8: ireturn
      // 0c9: athrow
      // 0ca: aload 0
      // 0cb: iload 1
      // 0cc: ifne 0dd
      // 0cf: instanceof net/minecraft/block/BlockCarpet
      // 0d2: ifeq 0dc
      // 0d5: goto 0d9
      // 0d8: athrow
      // 0d9: bipush 0
      // 0da: ireturn
      // 0db: athrow
      // 0dc: aload 0
      // 0dd: iload 1
      // 0de: ifne 0ef
      // 0e1: instanceof net/minecraft/block/BlockSnow
      // 0e4: ifeq 0ee
      // 0e7: goto 0eb
      // 0ea: athrow
      // 0eb: bipush 0
      // 0ec: ireturn
      // 0ed: athrow
      // 0ee: aload 0
      // 0ef: iload 1
      // 0f0: ifne 101
      // 0f3: instanceof net/minecraft/block/BlockFence
      // 0f6: ifeq 100
      // 0f9: goto 0fd
      // 0fc: athrow
      // 0fd: bipush 0
      // 0fe: ireturn
      // 0ff: athrow
      // 100: aload 0
      // 101: iload 1
      // 102: ifne 113
      // 105: instanceof net/minecraft/block/BlockFenceGate
      // 108: ifeq 112
      // 10b: goto 10f
      // 10e: athrow
      // 10f: bipush 0
      // 110: ireturn
      // 111: athrow
      // 112: aload 0
      // 113: iload 1
      // 114: ifne 125
      // 117: instanceof net/minecraft/block/BlockWall
      // 11a: ifeq 124
      // 11d: goto 121
      // 120: athrow
      // 121: bipush 0
      // 122: ireturn
      // 123: athrow
      // 124: aload 0
      // 125: iload 1
      // 126: ifne 137
      // 129: instanceof net/minecraft/block/BlockLadder
      // 12c: ifeq 136
      // 12f: goto 133
      // 132: athrow
      // 133: bipush 0
      // 134: ireturn
      // 135: athrow
      // 136: aload 0
      // 137: iload 1
      // 138: ifne 149
      // 13b: instanceof net/minecraft/block/BlockTorch
      // 13e: ifeq 148
      // 141: goto 145
      // 144: athrow
      // 145: bipush 0
      // 146: ireturn
      // 147: athrow
      // 148: aload 0
      // 149: iload 1
      // 14a: ifne 15b
      // 14d: instanceof net/minecraft/block/BlockRedstoneWire
      // 150: ifeq 15a
      // 153: goto 157
      // 156: athrow
      // 157: bipush 0
      // 158: ireturn
      // 159: athrow
      // 15a: aload 0
      // 15b: iload 1
      // 15c: ifne 16d
      // 15f: instanceof net/minecraft/block/BlockRedstoneDiode
      // 162: ifeq 16c
      // 165: goto 169
      // 168: athrow
      // 169: bipush 0
      // 16a: ireturn
      // 16b: athrow
      // 16c: aload 0
      // 16d: iload 1
      // 16e: ifne 17f
      // 171: instanceof net/minecraft/block/BlockBasePressurePlate
      // 174: ifeq 17e
      // 177: goto 17b
      // 17a: athrow
      // 17b: bipush 0
      // 17c: ireturn
      // 17d: athrow
      // 17e: aload 0
      // 17f: iload 1
      // 180: ifne 191
      // 183: instanceof net/minecraft/block/BlockTripWire
      // 186: ifeq 190
      // 189: goto 18d
      // 18c: athrow
      // 18d: bipush 0
      // 18e: ireturn
      // 18f: athrow
      // 190: aload 0
      // 191: iload 1
      // 192: ifne 1a3
      // 195: instanceof net/minecraft/block/BlockTripWireHook
      // 198: ifeq 1a2
      // 19b: goto 19f
      // 19e: athrow
      // 19f: bipush 0
      // 1a0: ireturn
      // 1a1: athrow
      // 1a2: aload 0
      // 1a3: iload 1
      // 1a4: ifne 1b5
      // 1a7: instanceof net/minecraft/block/BlockRailBase
      // 1aa: ifeq 1b4
      // 1ad: goto 1b1
      // 1b0: athrow
      // 1b1: bipush 0
      // 1b2: ireturn
      // 1b3: athrow
      // 1b4: aload 0
      // 1b5: iload 1
      // 1b6: ifne 1c7
      // 1b9: instanceof net/minecraft/block/BlockSlime
      // 1bc: ifeq 1c6
      // 1bf: goto 1c3
      // 1c2: athrow
      // 1c3: bipush 0
      // 1c4: ireturn
      // 1c5: athrow
      // 1c6: aload 0
      // 1c7: instanceof net/minecraft/block/BlockTNT
      // 1ca: iload 1
      // 1cb: ifne 1d6
      // 1ce: ifne 1d9
      // 1d1: goto 1d5
      // 1d4: athrow
      // 1d5: bipush 1
      // 1d6: goto 1da
      // 1d9: bipush 0
      // 1da: ireturn
   }

   public static boolean Ր(MovingObjectPosition param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 11
      // 09: ifnull 2d
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 0
      // 11: iload 1
      // 12: ifne 27
      // 15: getfield net/minecraft/util/MovingObjectPosition.typeOfHit Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 18: getstatic net/minecraft/util/MovingObjectPosition$MovingObjectType.BLOCK Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 1b: if_acmpne 2d
      // 1e: goto 22
      // 21: athrow
      // 22: aload 0
      // 23: goto 27
      // 26: athrow
      // 27: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 2a: ifnonnull 30
      // 2d: bipush 0
      // 2e: ireturn
      // 2f: athrow
      // 30: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 33: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 36: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isSneaking ()Z
      // 39: iload 1
      // 3a: ifne 62
      // 3d: ifeq 54
      // 40: goto 44
      // 43: athrow
      // 44: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 47: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 4a: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 4d: ifnonnull 63
      // 50: goto 54
      // 53: athrow
      // 54: aload 0
      // 55: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 58: invokestatic x/occb1ed1ed8f.ϛ (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/Block;
      // 5b: invokestatic x/occb1ed1ed8f.ȼ (Lnet/minecraft/block/Block;)Z
      // 5e: goto 62
      // 61: athrow
      // 62: ireturn
      // 63: bipush 0
      // 64: ireturn
   }

   public static float ԁ(Block param0, ItemStack param1, boolean param2, boolean param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: aload 0
      // 04: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 07: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 0a: aconst_null
      // 0b: invokevirtual net/minecraft/block/Block.getBlockHardness (Lnet/minecraft/world/World;Lnet/minecraft/util/BlockPos;)F
      // 0e: fstore 5
      // 10: istore 4
      // 12: fload 5
      // 14: fconst_0
      // 15: fcmpg
      // 16: iload 4
      // 18: ifne 2c
      // 1b: ifge 25
      // 1e: goto 22
      // 21: athrow
      // 22: fconst_0
      // 23: freturn
      // 24: athrow
      // 25: aload 0
      // 26: invokevirtual net/minecraft/block/Block.getMaterial ()Lnet/minecraft/block/material/Material;
      // 29: invokevirtual net/minecraft/block/material/Material.isToolNotRequired ()Z
      // 2c: ifne 55
      // 2f: aload 1
      // 30: iload 4
      // 32: ifne 68
      // 35: goto 39
      // 38: athrow
      // 39: ifnull 67
      // 3c: goto 40
      // 3f: athrow
      // 40: aload 1
      // 41: iload 4
      // 43: ifne 68
      // 46: goto 4a
      // 49: athrow
      // 4a: aload 0
      // 4b: invokevirtual net/minecraft/item/ItemStack.canHarvestBlock (Lnet/minecraft/block/Block;)Z
      // 4e: ifeq 67
      // 51: goto 55
      // 54: athrow
      // 55: aload 1
      // 56: aload 0
      // 57: iload 2
      // 58: iload 3
      // 59: invokestatic x/occb1ed1ed8f.ȇ (Lnet/minecraft/item/ItemStack;Lnet/minecraft/block/Block;ZZ)F
      // 5c: fload 5
      // 5e: fdiv
      // 5f: ldc_w 30.0
      // 62: fdiv
      // 63: goto 75
      // 66: athrow
      // 67: aload 1
      // 68: aload 0
      // 69: iload 2
      // 6a: iload 3
      // 6b: invokestatic x/occb1ed1ed8f.ȇ (Lnet/minecraft/item/ItemStack;Lnet/minecraft/block/Block;ZZ)F
      // 6e: fload 5
      // 70: fdiv
      // 71: ldc_w 100.0
      // 74: fdiv
      // 75: freturn
   }

   public static float Ĳ(Block param0, int param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 2
      // 04: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 07: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0a: ifnull 1d
      // 0d: iload 1
      // 0e: iload 2
      // 0f: ifne 30
      // 12: goto 16
      // 15: athrow
      // 16: ifgt 20
      // 19: goto 1d
      // 1c: athrow
      // 1d: fconst_0
      // 1e: freturn
      // 1f: athrow
      // 20: iload 1
      // 21: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 24: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 27: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 2a: invokevirtual net/minecraft/entity/player/InventoryPlayer.getSizeInventory ()I
      // 2d: invokestatic java/lang/Math.min (II)I
      // 30: istore 3
      // 31: fconst_0
      // 32: fstore 4
      // 34: bipush 0
      // 35: istore 5
      // 37: iload 5
      // 39: iload 3
      // 3a: if_icmpge 72
      // 3d: aload 0
      // 3e: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 41: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 44: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 47: iload 5
      // 49: invokevirtual net/minecraft/entity/player/InventoryPlayer.getStackInSlot (I)Lnet/minecraft/item/ItemStack;
      // 4c: bipush 0
      // 4d: bipush 0
      // 4e: invokestatic x/occb1ed1ed8f.ԁ (Lnet/minecraft/block/Block;Lnet/minecraft/item/ItemStack;ZZ)F
      // 51: iload 2
      // 52: ifne 74
      // 55: fstore 6
      // 57: iload 2
      // 58: ifne 6e
      // 5b: fload 6
      // 5d: fload 4
      // 5f: fcmpl
      // 60: ifle 6b
      // 63: goto 67
      // 66: athrow
      // 67: fload 6
      // 69: fstore 4
      // 6b: iinc 5 1
      // 6e: iload 2
      // 6f: ifeq 37
      // 72: fload 4
      // 74: freturn
   }

   public static float ȇ(ItemStack param0, Block param1, boolean param2, boolean param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 4
      // 005: aload 0
      // 006: iload 4
      // 008: ifne 018
      // 00b: ifnonnull 017
      // 00e: goto 012
      // 011: athrow
      // 012: fconst_1
      // 013: goto 020
      // 016: athrow
      // 017: aload 0
      // 018: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 01b: aload 0
      // 01c: aload 1
      // 01d: invokevirtual net/minecraft/item/Item.getStrVsBlock (Lnet/minecraft/item/ItemStack;Lnet/minecraft/block/Block;)F
      // 020: fstore 5
      // 022: fload 5
      // 024: fconst_1
      // 025: fcmpl
      // 026: iload 4
      // 028: ifne 06d
      // 02b: ifle 061
      // 02e: goto 032
      // 031: athrow
      // 032: getstatic net/minecraft/enchantment/Enchantment.efficiency Lnet/minecraft/enchantment/Enchantment;
      // 035: getfield net/minecraft/enchantment/Enchantment.effectId I
      // 038: iload 4
      // 03a: ifne 06d
      // 03d: goto 041
      // 040: athrow
      // 041: aload 0
      // 042: invokestatic net/minecraft/enchantment/EnchantmentHelper.getEnchantmentLevel (ILnet/minecraft/item/ItemStack;)I
      // 045: istore 6
      // 047: iload 6
      // 049: ifle 061
      // 04c: aload 0
      // 04d: ifnull 061
      // 050: goto 054
      // 053: athrow
      // 054: fload 5
      // 056: iload 6
      // 058: iload 6
      // 05a: imul
      // 05b: bipush 1
      // 05c: iadd
      // 05d: i2f
      // 05e: fadd
      // 05f: fstore 5
      // 061: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 064: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 067: getstatic net/minecraft/potion/Potion.digSpeed Lnet/minecraft/potion/Potion;
      // 06a: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isPotionActive (Lnet/minecraft/potion/Potion;)Z
      // 06d: iload 4
      // 06f: ifne 097
      // 072: ifeq 096
      // 075: goto 079
      // 078: athrow
      // 079: fload 5
      // 07b: fconst_1
      // 07c: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 07f: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 082: getstatic net/minecraft/potion/Potion.digSpeed Lnet/minecraft/potion/Potion;
      // 085: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getActivePotionEffect (Lnet/minecraft/potion/Potion;)Lnet/minecraft/potion/PotionEffect;
      // 088: invokevirtual net/minecraft/potion/PotionEffect.getAmplifier ()I
      // 08b: bipush 1
      // 08c: iadd
      // 08d: i2f
      // 08e: ldc_w 0.2
      // 091: fmul
      // 092: fadd
      // 093: fmul
      // 094: fstore 5
      // 096: iload 2
      // 097: iload 4
      // 099: ifne 0bc
      // 09c: ifne 16d
      // 09f: goto 0a3
      // 0a2: athrow
      // 0a3: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 0a6: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0a9: iload 4
      // 0ab: ifne 122
      // 0ae: goto 0b2
      // 0b1: athrow
      // 0b2: getstatic net/minecraft/potion/Potion.digSlowdown Lnet/minecraft/potion/Potion;
      // 0b5: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isPotionActive (Lnet/minecraft/potion/Potion;)Z
      // 0b8: goto 0bc
      // 0bb: athrow
      // 0bc: ifeq 113
      // 0bf: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 0c2: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0c5: getstatic net/minecraft/potion/Potion.digSlowdown Lnet/minecraft/potion/Potion;
      // 0c8: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getActivePotionEffect (Lnet/minecraft/potion/Potion;)Lnet/minecraft/potion/PotionEffect;
      // 0cb: invokevirtual net/minecraft/potion/PotionEffect.getAmplifier ()I
      // 0ce: tableswitch 57 0 2 27 37 47
      // 0e8: athrow
      // 0e9: ldc_w 0.3
      // 0ec: fstore 6
      // 0ee: iload 4
      // 0f0: ifeq 10c
      // 0f3: ldc_w 0.09
      // 0f6: fstore 6
      // 0f8: iload 4
      // 0fa: ifeq 10c
      // 0fd: ldc_w 0.0027
      // 100: fstore 6
      // 102: iload 4
      // 104: ifeq 10c
      // 107: ldc_w 8.1E-4
      // 10a: fstore 6
      // 10c: fload 5
      // 10e: fload 6
      // 110: fmul
      // 111: fstore 5
      // 113: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 116: iload 4
      // 118: ifne 14f
      // 11b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 11e: goto 122
      // 121: athrow
      // 122: getstatic net/minecraft/block/material/Material.water Lnet/minecraft/block/material/Material;
      // 125: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isInsideOfMaterial (Lnet/minecraft/block/material/Material;)Z
      // 128: ifeq 14c
      // 12b: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 12e: iload 4
      // 130: ifne 14f
      // 133: goto 137
      // 136: athrow
      // 137: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 13a: invokestatic net/minecraft/enchantment/EnchantmentHelper.getAquaAffinityModifier (Lnet/minecraft/entity/EntityLivingBase;)Z
      // 13d: ifne 14c
      // 140: goto 144
      // 143: athrow
      // 144: fload 5
      // 146: ldc_w 5.0
      // 149: fdiv
      // 14a: fstore 5
      // 14c: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 14f: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 152: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 155: iload 4
      // 157: ifne 162
      // 15a: ifne 16d
      // 15d: goto 161
      // 160: athrow
      // 161: iload 3
      // 162: ifne 16d
      // 165: fload 5
      // 167: ldc_w 5.0
      // 16a: fdiv
      // 16b: fstore 5
      // 16d: fload 5
      // 16f: freturn
   }

   public static Block ϛ(BlockPos var0) {
      return О(var0).getBlock();
   }

   public static Block ҫ(double var0, double var2, double var4) {
      return О(new BlockPos(var0, var2, var4)).getBlock();
   }

   public static Block æ(Vec3 var0) {
      return О(new BlockPos(var0.xCoord, var0.yCoord, var0.zCoord)).getBlock();
   }

   public static IBlockState О(BlockPos param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 03: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 06: ifnull 11
      // 09: aload 0
      // 0a: ifnonnull 19
      // 0d: goto 11
      // 10: athrow
      // 11: getstatic net/minecraft/init/Blocks.air Lnet/minecraft/block/Block;
      // 14: invokevirtual net/minecraft/block/Block.getDefaultState ()Lnet/minecraft/block/state/IBlockState;
      // 17: areturn
      // 18: athrow
      // 19: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 1c: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 1f: aload 0
      // 20: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 23: areturn
   }

   public static AxisAlignedBB ª(BlockPos param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 1
      // 04: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 07: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 0a: ifnull 15
      // 0d: aload 0
      // 0e: ifnonnull 18
      // 11: goto 15
      // 14: athrow
      // 15: aconst_null
      // 16: areturn
      // 17: athrow
      // 18: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 1b: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 1e: aload 0
      // 1f: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 22: astore 2
      // 23: aload 2
      // 24: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 29: astore 3
      // 2a: aload 3
      // 2b: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 2e: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 31: aload 0
      // 32: invokevirtual net/minecraft/block/Block.setBlockBoundsBasedOnState (Lnet/minecraft/world/IBlockAccess;Lnet/minecraft/util/BlockPos;)V
      // 35: aload 3
      // 36: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 39: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 3c: aload 0
      // 3d: invokevirtual net/minecraft/block/Block.getSelectedBoundingBox (Lnet/minecraft/world/World;Lnet/minecraft/util/BlockPos;)Lnet/minecraft/util/AxisAlignedBB;
      // 40: astore 4
      // 42: aload 4
      // 44: iload 1
      // 45: ifne 7e
      // 48: ifnonnull 7c
      // 4b: goto 4f
      // 4e: athrow
      // 4f: new net/minecraft/util/AxisAlignedBB
      // 52: dup
      // 53: aload 0
      // 54: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 57: i2d
      // 58: aload 0
      // 59: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 5c: i2d
      // 5d: aload 0
      // 5e: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 61: i2d
      // 62: aload 0
      // 63: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 66: i2d
      // 67: dconst_1
      // 68: dadd
      // 69: aload 0
      // 6a: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 6d: i2d
      // 6e: dconst_1
      // 6f: dadd
      // 70: aload 0
      // 71: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 74: i2d
      // 75: dconst_1
      // 76: dadd
      // 77: invokespecial net/minecraft/util/AxisAlignedBB.<init> (DDDDDD)V
      // 7a: astore 4
      // 7c: aload 4
      // 7e: areturn
   }

   public static AxisAlignedBB с(BlockPos param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 1
      // 04: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 07: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 0a: ifnull 15
      // 0d: aload 0
      // 0e: ifnonnull 18
      // 11: goto 15
      // 14: athrow
      // 15: aconst_null
      // 16: areturn
      // 17: athrow
      // 18: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 1b: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 1e: aload 0
      // 1f: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 22: astore 2
      // 23: aload 2
      // 24: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 29: astore 3
      // 2a: aload 3
      // 2b: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 2e: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 31: aload 0
      // 32: aload 2
      // 33: invokevirtual net/minecraft/block/Block.getCollisionBoundingBox (Lnet/minecraft/world/World;Lnet/minecraft/util/BlockPos;Lnet/minecraft/block/state/IBlockState;)Lnet/minecraft/util/AxisAlignedBB;
      // 36: astore 4
      // 38: aload 4
      // 3a: iload 1
      // 3b: ifne 54
      // 3e: ifnonnull 52
      // 41: goto 45
      // 44: athrow
      // 45: aload 3
      // 46: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 49: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 4c: aload 0
      // 4d: invokevirtual net/minecraft/block/Block.getSelectedBoundingBox (Lnet/minecraft/world/World;Lnet/minecraft/util/BlockPos;)Lnet/minecraft/util/AxisAlignedBB;
      // 50: astore 4
      // 52: aload 4
      // 54: iload 1
      // 55: ifne 8e
      // 58: ifnonnull 8c
      // 5b: goto 5f
      // 5e: athrow
      // 5f: new net/minecraft/util/AxisAlignedBB
      // 62: dup
      // 63: aload 0
      // 64: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 67: i2d
      // 68: aload 0
      // 69: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 6c: i2d
      // 6d: aload 0
      // 6e: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 71: i2d
      // 72: aload 0
      // 73: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 76: i2d
      // 77: dconst_1
      // 78: dadd
      // 79: aload 0
      // 7a: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 7d: i2d
      // 7e: dconst_1
      // 7f: dadd
      // 80: aload 0
      // 81: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 84: i2d
      // 85: dconst_1
      // 86: dadd
      // 87: invokespecial net/minecraft/util/AxisAlignedBB.<init> (DDDDDD)V
      // 8a: astore 4
      // 8c: aload 4
      // 8e: areturn
   }

   public static AxisAlignedBB ɜ(BlockPos param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 1
      // 04: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 07: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 0a: ifnull 15
      // 0d: aload 0
      // 0e: ifnonnull 18
      // 11: goto 15
      // 14: athrow
      // 15: aconst_null
      // 16: areturn
      // 17: athrow
      // 18: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 1b: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 1e: aload 0
      // 1f: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 22: astore 2
      // 23: aload 2
      // 24: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 29: astore 3
      // 2a: aload 3
      // 2b: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 2e: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 31: aload 0
      // 32: aload 2
      // 33: invokevirtual net/minecraft/block/Block.getCollisionBoundingBox (Lnet/minecraft/world/World;Lnet/minecraft/util/BlockPos;Lnet/minecraft/block/state/IBlockState;)Lnet/minecraft/util/AxisAlignedBB;
      // 36: astore 4
      // 38: aload 4
      // 3a: iload 1
      // 3b: ifne 54
      // 3e: ifnonnull 52
      // 41: goto 45
      // 44: athrow
      // 45: aload 3
      // 46: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 49: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 4c: aload 0
      // 4d: invokevirtual net/minecraft/block/Block.getSelectedBoundingBox (Lnet/minecraft/world/World;Lnet/minecraft/util/BlockPos;)Lnet/minecraft/util/AxisAlignedBB;
      // 50: astore 4
      // 52: aload 4
      // 54: areturn
   }

   public static AxisAlignedBB ҡ(BlockPos var0, BlockPos var1) {
      AxisAlignedBB var2 = с(var0);
      AxisAlignedBB var3 = с(var1);
      return var2.union(var3);
   }

   public static EnumFacing Х(BlockPos param0, Vec3 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 1
      // 01: getfield net/minecraft/util/Vec3.xCoord D
      // 04: aload 0
      // 05: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 08: i2d
      // 09: ldc2_w 0.5
      // 0c: dadd
      // 0d: dsub
      // 0e: dstore 3
      // 0f: getstatic x/oc75d51ec7eb.ϩ I
      // 12: aload 1
      // 13: getfield net/minecraft/util/Vec3.yCoord D
      // 16: aload 0
      // 17: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 1a: i2d
      // 1b: ldc2_w 0.5
      // 1e: dadd
      // 1f: dsub
      // 20: dstore 5
      // 22: aload 1
      // 23: getfield net/minecraft/util/Vec3.zCoord D
      // 26: aload 0
      // 27: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 2a: i2d
      // 2b: ldc2_w 0.5
      // 2e: dadd
      // 2f: dsub
      // 30: dstore 7
      // 32: istore 2
      // 33: dload 3
      // 34: invokestatic java/lang/Math.abs (D)D
      // 37: dstore 9
      // 39: dload 5
      // 3b: invokestatic java/lang/Math.abs (D)D
      // 3e: dstore 11
      // 40: dload 7
      // 42: invokestatic java/lang/Math.abs (D)D
      // 45: dstore 13
      // 47: dload 9
      // 49: dload 11
      // 4b: iload 2
      // 4c: ifne 84
      // 4f: dcmpl
      // 50: ifle 80
      // 53: goto 57
      // 56: athrow
      // 57: dload 9
      // 59: dload 13
      // 5b: iload 2
      // 5c: ifne 84
      // 5f: goto 63
      // 62: athrow
      // 63: dcmpl
      // 64: ifle 80
      // 67: goto 6b
      // 6a: athrow
      // 6b: dload 3
      // 6c: dconst_0
      // 6d: dcmpl
      // 6e: ifle 7c
      // 71: goto 75
      // 74: athrow
      // 75: getstatic net/minecraft/util/EnumFacing.EAST Lnet/minecraft/util/EnumFacing;
      // 78: goto 7f
      // 7b: athrow
      // 7c: getstatic net/minecraft/util/EnumFacing.WEST Lnet/minecraft/util/EnumFacing;
      // 7f: areturn
      // 80: dload 11
      // 82: dload 13
      // 84: iload 2
      // 85: ifne a9
      // 88: dcmpl
      // 89: ifle a6
      // 8c: goto 90
      // 8f: athrow
      // 90: dload 5
      // 92: dconst_0
      // 93: dcmpl
      // 94: ifle a2
      // 97: goto 9b
      // 9a: athrow
      // 9b: getstatic net/minecraft/util/EnumFacing.UP Lnet/minecraft/util/EnumFacing;
      // 9e: goto a5
      // a1: athrow
      // a2: getstatic net/minecraft/util/EnumFacing.DOWN Lnet/minecraft/util/EnumFacing;
      // a5: areturn
      // a6: dload 7
      // a8: dconst_0
      // a9: dcmpl
      // aa: ifle b4
      // ad: getstatic net/minecraft/util/EnumFacing.SOUTH Lnet/minecraft/util/EnumFacing;
      // b0: goto b7
      // b3: athrow
      // b4: getstatic net/minecraft/util/EnumFacing.NORTH Lnet/minecraft/util/EnumFacing;
      // b7: areturn
   }

   public static boolean ӑ(BlockPos var0, Block var1) {
      try {
         if (ϛ(var0) == var1) {
            return true;
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }

      return false;
   }

   public static boolean ɍ(BlockPos param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 1
      // 04: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 07: iload 1
      // 08: ifne 23
      // 0b: ifne 15
      // 0e: goto 12
      // 11: athrow
      // 12: bipush 1
      // 13: ireturn
      // 14: athrow
      // 15: aload 0
      // 16: invokestatic x/occb1ed1ed8f.ϛ (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/Block;
      // 19: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 1c: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 1f: aload 0
      // 20: invokevirtual net/minecraft/block/Block.isReplaceable (Lnet/minecraft/world/World;Lnet/minecraft/util/BlockPos;)Z
      // 23: ireturn
   }

   public static boolean Ũ(BlockPos param0, Vec3 param1, Vec3 param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 06: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 09: aload 1
      // 0a: aload 2
      // 0b: bipush 0
      // 0c: bipush 0
      // 0d: bipush 0
      // 0e: invokevirtual net/minecraft/client/multiplayer/WorldClient.rayTraceBlocks (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;ZZZ)Lnet/minecraft/util/MovingObjectPosition;
      // 11: astore 4
      // 13: istore 3
      // 14: aload 4
      // 16: iload 3
      // 17: ifne 26
      // 1a: ifnonnull 24
      // 1d: goto 21
      // 20: athrow
      // 21: bipush 1
      // 22: ireturn
      // 23: athrow
      // 24: aload 4
      // 26: iload 3
      // 27: ifne 3d
      // 2a: getfield net/minecraft/util/MovingObjectPosition.typeOfHit Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 2d: getstatic net/minecraft/util/MovingObjectPosition$MovingObjectType.BLOCK Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 30: if_acmpne 89
      // 33: goto 37
      // 36: athrow
      // 37: aload 4
      // 39: goto 3d
      // 3c: athrow
      // 3d: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 40: astore 5
      // 42: aload 5
      // 44: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 47: iload 3
      // 48: ifne 8a
      // 4b: aload 0
      // 4c: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 4f: if_icmpne 89
      // 52: goto 56
      // 55: athrow
      // 56: aload 5
      // 58: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 5b: iload 3
      // 5c: ifne 8a
      // 5f: goto 63
      // 62: athrow
      // 63: aload 0
      // 64: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 67: if_icmpne 89
      // 6a: goto 6e
      // 6d: athrow
      // 6e: aload 5
      // 70: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 73: iload 3
      // 74: ifne 8a
      // 77: goto 7b
      // 7a: athrow
      // 7b: aload 0
      // 7c: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 7f: if_icmpne 89
      // 82: goto 86
      // 85: athrow
      // 86: bipush 1
      // 87: ireturn
      // 88: athrow
      // 89: bipush 0
      // 8a: ireturn
   }

   public static boolean ɺ(BlockPos param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: new net/minecraft/util/Vec3
      // 003: dup
      // 004: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 007: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 00a: getfield net/minecraft/client/entity/EntityPlayerSP.posX D
      // 00d: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 010: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 013: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // 016: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 019: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 01c: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getEyeHeight ()F
      // 01f: f2d
      // 020: dadd
      // 021: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 024: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 027: getfield net/minecraft/client/entity/EntityPlayerSP.posZ D
      // 02a: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 02d: astore 2
      // 02e: getstatic x/oc75d51ec7eb.ϩ I
      // 031: dconst_0
      // 032: dstore 3
      // 033: istore 1
      // 034: dload 3
      // 035: ldc2_w 0.5
      // 038: dcmpg
      // 039: ifgt 10b
      // 03c: aload 0
      // 03d: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 040: iload 1
      // 041: ifne 10c
      // 044: i2d
      // 045: dload 3
      // 046: dadd
      // 047: dstore 5
      // 049: new net/minecraft/util/Vec3
      // 04c: dup
      // 04d: aload 0
      // 04e: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 051: bipush 1
      // 052: iadd
      // 053: i2d
      // 054: dload 5
      // 056: aload 0
      // 057: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 05a: i2d
      // 05b: ldc2_w 0.5
      // 05e: dadd
      // 05f: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 062: astore 7
      // 064: aload 0
      // 065: iload 1
      // 066: ifne 093
      // 069: aload 2
      // 06a: aload 7
      // 06c: invokestatic x/occb1ed1ed8f.Ũ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Z
      // 06f: ifeq 079
      // 072: goto 076
      // 075: athrow
      // 076: bipush 1
      // 077: ireturn
      // 078: athrow
      // 079: new net/minecraft/util/Vec3
      // 07c: dup
      // 07d: aload 0
      // 07e: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 081: i2d
      // 082: dload 5
      // 084: aload 0
      // 085: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 088: i2d
      // 089: ldc2_w 0.5
      // 08c: dadd
      // 08d: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 090: astore 7
      // 092: aload 0
      // 093: aload 2
      // 094: aload 7
      // 096: iload 1
      // 097: ifne 0ce
      // 09a: invokestatic x/occb1ed1ed8f.Ũ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Z
      // 09d: ifeq 0a7
      // 0a0: goto 0a4
      // 0a3: athrow
      // 0a4: bipush 1
      // 0a5: ireturn
      // 0a6: athrow
      // 0a7: new net/minecraft/util/Vec3
      // 0aa: dup
      // 0ab: aload 0
      // 0ac: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 0af: i2d
      // 0b0: ldc2_w 0.5
      // 0b3: dadd
      // 0b4: dload 5
      // 0b6: aload 0
      // 0b7: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 0ba: bipush 1
      // 0bb: iadd
      // 0bc: i2d
      // 0bd: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 0c0: astore 7
      // 0c2: iload 1
      // 0c3: ifne 0f4
      // 0c6: aload 0
      // 0c7: aload 2
      // 0c8: aload 7
      // 0ca: goto 0ce
      // 0cd: athrow
      // 0ce: invokestatic x/occb1ed1ed8f.Ũ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Z
      // 0d1: ifeq 0d7
      // 0d4: bipush 1
      // 0d5: ireturn
      // 0d6: athrow
      // 0d7: new net/minecraft/util/Vec3
      // 0da: dup
      // 0db: aload 0
      // 0dc: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 0df: i2d
      // 0e0: ldc2_w 0.5
      // 0e3: dadd
      // 0e4: dload 5
      // 0e6: aload 0
      // 0e7: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 0ea: i2d
      // 0eb: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 0ee: astore 7
      // 0f0: iload 1
      // 0f1: ifne 107
      // 0f4: aload 0
      // 0f5: aload 2
      // 0f6: aload 7
      // 0f8: invokestatic x/occb1ed1ed8f.Ũ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Z
      // 0fb: ifeq 101
      // 0fe: bipush 1
      // 0ff: ireturn
      // 100: athrow
      // 101: dload 3
      // 102: ldc2_w 0.5
      // 105: dadd
      // 106: dstore 3
      // 107: iload 1
      // 108: ifeq 034
      // 10b: bipush 0
      // 10c: ireturn
   }

   public static EnumDyeColor Ѐ(IBlockState var0) {
      return (EnumDyeColor)var0.getProperties().get(BlockColored.COLOR);
   }

   public static EnumFacing[] ԧ(Vec3 var0, BlockPos var1) {
      EnumFacing var10000;
      label44: {
         try {
            if (Math.abs(var0.yCoord - (var1.getY() + 1)) < Math.abs(var0.yCoord - var1.getY())) {
               var10000 = EnumFacing.UP;
               break label44;
            }
         } catch (ocbde1165e4e var7) {
            throw var7;
         }

         var10000 = EnumFacing.DOWN;
      }

      EnumFacing var2 = var10000;

      label36: {
         try {
            if (Math.abs(var0.zCoord - (var1.getZ() + 1)) < Math.abs(var0.zCoord - var1.getZ())) {
               var10000 = EnumFacing.SOUTH;
               break label36;
            }
         } catch (ocbde1165e4e var6) {
            throw var6;
         }

         var10000 = EnumFacing.NORTH;
      }

      EnumFacing var3 = var10000;

      label28: {
         try {
            if (Math.abs(var0.xCoord - (var1.getX() + 1)) < Math.abs(var0.xCoord - var1.getX())) {
               var10000 = EnumFacing.EAST;
               break label28;
            }
         } catch (ocbde1165e4e var5) {
            throw var5;
         }

         var10000 = EnumFacing.WEST;
      }

      EnumFacing var4 = var10000;
      EnumFacing[] var10 = new EnumFacing[-1003185523 ^ -1003185522];
      var10[0] = var2;
      var10[1] = var3;
      var10[-1003185524 ^ -1003185522] = var4;
      return var10;
   }

   public static boolean Ġ(EnumFacing[] param0, EnumFacing param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 0
      // 01: astore 3
      // 02: getstatic x/oc75d51ec7eb.ϩ I
      // 05: aload 3
      // 06: arraylength
      // 07: istore 4
      // 09: istore 2
      // 0a: bipush 0
      // 0b: istore 5
      // 0d: iload 5
      // 0f: iload 4
      // 11: if_icmpge 32
      // 14: aload 3
      // 15: iload 5
      // 17: aaload
      // 18: astore 6
      // 1a: iload 2
      // 1b: ifne 2e
      // 1e: aload 6
      // 20: aload 1
      // 21: if_acmpne 2b
      // 24: goto 28
      // 27: athrow
      // 28: bipush 1
      // 29: ireturn
      // 2a: athrow
      // 2b: iinc 5 1
      // 2e: iload 2
      // 2f: ifeq 0d
      // 32: bipush 0
      // 33: ireturn
   }

   // $VF: Unable to simplify switch on enum
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public static Vec3 ш(BlockPos var0, EnumFacing var1) {
      double var2 = 0.001;
      double var4 = var0.getX() + 0.5;
      double var6 = var0.getY() + 0.5;
      double var8 = var0.getZ() + 0.5;

      try {
         switch (P.Ό[var1.ordinal()]) {
            case 1:
               return new Vec3(var4, var0.getY() + 1 - var2, var8);
            case 2:
               return new Vec3(var4, var0.getY() + var2, var8);
            case 3:
               return new Vec3(var4, var6, var0.getZ() + var2);
            case 4:
               return new Vec3(var4, var6, var0.getZ() + 1 - var2);
            case 5:
               return new Vec3(var0.getX() + 1 - var2, var6, var8);
            case 6:
               return new Vec3(var0.getX() + var2, var6, var8);
         }
      } catch (ocbde1165e4e var10) {
         throw var10;
      }

      return new Vec3(var4, var6, var8);
   }

   public static double Ʌ(Vec3 var0, BlockPos var1) {
      double var2 = Math.max((double)var1.getX(), Math.min((double)(var1.getX() + 1), var0.xCoord));
      double var4 = Math.max((double)var1.getY(), Math.min((double)(var1.getY() + 1), var0.yCoord));
      double var6 = Math.max((double)var1.getZ(), Math.min((double)(var1.getZ() + 1), var0.zCoord));
      double var8 = var0.xCoord - var2;
      double var10 = var0.yCoord - var4;
      double var12 = var0.zCoord - var6;
      return var8 * var8 + var10 * var10 + var12 * var12;
   }

   public static boolean ā(ItemStack param0, BlockPos param1, EnumFacing param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 3
      // 04: aload 0
      // 05: iload 3
      // 06: ifne 11
      // 09: ifnull 22
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 0
      // 11: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 14: iload 3
      // 15: ifne 29
      // 18: instanceof net/minecraft/item/ItemBlock
      // 1b: ifne 25
      // 1e: goto 22
      // 21: athrow
      // 22: bipush 0
      // 23: ireturn
      // 24: athrow
      // 25: aload 0
      // 26: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 29: checkcast net/minecraft/item/ItemBlock
      // 2c: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 2f: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 32: aload 1
      // 33: aload 2
      // 34: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 37: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 3a: aload 0
      // 3b: invokevirtual net/minecraft/item/ItemBlock.canPlaceBlockOnSide (Lnet/minecraft/world/World;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;Lnet/minecraft/entity/player/EntityPlayer;Lnet/minecraft/item/ItemStack;)Z
      // 3e: ireturn
   }

   public static float ɠ(Block param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: aload 0
      // 04: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 07: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 0a: aconst_null
      // 0b: invokevirtual net/minecraft/block/Block.getBlockHardness (Lnet/minecraft/world/World;Lnet/minecraft/util/BlockPos;)F
      // 0e: fstore 2
      // 0f: istore 1
      // 10: fload 2
      // 11: iload 1
      // 12: ifne 24
      // 15: fconst_0
      // 16: fcmpg
      // 17: ifge 23
      // 1a: goto 1e
      // 1d: athrow
      // 1e: ldc_w 3.4028235E38
      // 21: freturn
      // 22: athrow
      // 23: fload 2
      // 24: iload 1
      // 25: ifne 35
      // 28: fconst_0
      // 29: fcmpl
      // 2a: ifne 34
      // 2d: goto 31
      // 30: athrow
      // 31: fconst_0
      // 32: freturn
      // 33: athrow
      // 34: fload 2
      // 35: aload 0
      // 36: invokevirtual net/minecraft/block/Block.getMaterial ()Lnet/minecraft/block/material/Material;
      // 39: invokevirtual net/minecraft/block/material/Material.isToolNotRequired ()Z
      // 3c: ifeq 46
      // 3f: ldc_w 30.0
      // 42: goto 49
      // 45: athrow
      // 46: ldc_w 100.0
      // 49: fmul
      // 4a: freturn
   }

   public static boolean İ(BlockPos param0, BlockPos... param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: invokestatic net/minecraft/util/EnumFacing.values ()[Lnet/minecraft/util/EnumFacing;
      // 03: astore 3
      // 04: getstatic x/oc75d51ec7eb.ϩ I
      // 07: aload 3
      // 08: arraylength
      // 09: istore 4
      // 0b: bipush 0
      // 0c: istore 5
      // 0e: istore 2
      // 0f: iload 5
      // 11: iload 4
      // 13: if_icmpge 9c
      // 16: aload 3
      // 17: iload 5
      // 19: aaload
      // 1a: astore 6
      // 1c: aload 0
      // 1d: aload 6
      // 1f: invokevirtual net/minecraft/util/BlockPos.offset (Lnet/minecraft/util/EnumFacing;)Lnet/minecraft/util/BlockPos;
      // 22: astore 7
      // 24: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 27: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 2a: aload 7
      // 2c: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 2f: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 34: getstatic net/minecraft/init/Blocks.air Lnet/minecraft/block/Block;
      // 37: if_acmpeq 3e
      // 3a: goto 95
      // 3d: athrow
      // 3e: bipush 0
      // 3f: istore 8
      // 41: aload 1
      // 42: astore 9
      // 44: aload 9
      // 46: arraylength
      // 47: istore 10
      // 49: bipush 0
      // 4a: istore 11
      // 4c: iload 11
      // 4e: iload 10
      // 50: if_icmpge 86
      // 53: aload 9
      // 55: iload 11
      // 57: aaload
      // 58: astore 12
      // 5a: iload 2
      // 5b: ifne 82
      // 5e: iload 2
      // 5f: ifne 98
      // 62: goto 66
      // 65: athrow
      // 66: aload 7
      // 68: aload 12
      // 6a: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 6d: ifeq 7b
      // 70: goto 74
      // 73: athrow
      // 74: bipush 1
      // 75: istore 8
      // 77: iload 2
      // 78: ifeq 86
      // 7b: iinc 11 1
      // 7e: goto 82
      // 81: athrow
      // 82: iload 2
      // 83: ifeq 4c
      // 86: iload 8
      // 88: iload 2
      // 89: ifne 94
      // 8c: ifne 95
      // 8f: goto 93
      // 92: athrow
      // 93: bipush 1
      // 94: ireturn
      // 95: iinc 5 1
      // 98: iload 2
      // 99: ifeq 0f
      // 9c: bipush 0
      // 9d: ireturn
   }

   public static boolean П(BlockPos param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: invokestatic net/minecraft/util/EnumFacing.values ()[Lnet/minecraft/util/EnumFacing;
      // 06: astore 2
      // 07: istore 1
      // 08: aload 2
      // 09: arraylength
      // 0a: istore 3
      // 0b: bipush 0
      // 0c: istore 4
      // 0e: iload 4
      // 10: iload 3
      // 11: if_icmpge 43
      // 14: aload 2
      // 15: iload 4
      // 17: aaload
      // 18: astore 5
      // 1a: iload 1
      // 1b: ifne 3f
      // 1e: aload 0
      // 1f: aload 5
      // 21: invokevirtual net/minecraft/util/BlockPos.offset (Lnet/minecraft/util/EnumFacing;)Lnet/minecraft/util/BlockPos;
      // 24: invokestatic x/occb1ed1ed8f.ϛ (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/Block;
      // 27: instanceof net/minecraft/block/BlockBed
      // 2a: iload 1
      // 2b: ifne 44
      // 2e: goto 32
      // 31: athrow
      // 32: ifeq 3c
      // 35: goto 39
      // 38: athrow
      // 39: bipush 1
      // 3a: ireturn
      // 3b: athrow
      // 3c: iinc 4 1
      // 3f: iload 1
      // 40: ifeq 0e
      // 43: bipush 0
      // 44: ireturn
   }

   public static MovingObjectPosition ǘ(Vec3 param0, Vec3 param1, boolean param2, boolean param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 4
      // 005: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 008: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 00b: ifnonnull 011
      // 00e: aconst_null
      // 00f: areturn
      // 010: athrow
      // 011: aload 0
      // 012: iload 4
      // 014: ifne 029
      // 017: getfield net/minecraft/util/Vec3.xCoord D
      // 01a: invokestatic java/lang/Double.isNaN (D)Z
      // 01d: ifne 052
      // 020: goto 024
      // 023: athrow
      // 024: aload 0
      // 025: goto 029
      // 028: athrow
      // 029: getfield net/minecraft/util/Vec3.yCoord D
      // 02c: iload 4
      // 02e: ifne 043
      // 031: invokestatic java/lang/Double.isNaN (D)Z
      // 034: ifne 052
      // 037: goto 03b
      // 03a: athrow
      // 03b: aload 0
      // 03c: getfield net/minecraft/util/Vec3.zCoord D
      // 03f: goto 043
      // 042: athrow
      // 043: iload 4
      // 045: ifne 062
      // 048: invokestatic java/lang/Double.isNaN (D)Z
      // 04b: ifeq 055
      // 04e: goto 052
      // 051: athrow
      // 052: aconst_null
      // 053: areturn
      // 054: athrow
      // 055: aload 1
      // 056: iload 4
      // 058: ifne 06d
      // 05b: getfield net/minecraft/util/Vec3.xCoord D
      // 05e: goto 062
      // 061: athrow
      // 062: invokestatic java/lang/Double.isNaN (D)Z
      // 065: ifne 096
      // 068: aload 1
      // 069: goto 06d
      // 06c: athrow
      // 06d: getfield net/minecraft/util/Vec3.yCoord D
      // 070: iload 4
      // 072: ifne 087
      // 075: invokestatic java/lang/Double.isNaN (D)Z
      // 078: ifne 096
      // 07b: goto 07f
      // 07e: athrow
      // 07f: aload 1
      // 080: getfield net/minecraft/util/Vec3.zCoord D
      // 083: goto 087
      // 086: athrow
      // 087: iload 4
      // 089: ifne 09d
      // 08c: invokestatic java/lang/Double.isNaN (D)Z
      // 08f: ifeq 099
      // 092: goto 096
      // 095: athrow
      // 096: aconst_null
      // 097: areturn
      // 098: athrow
      // 099: aload 1
      // 09a: getfield net/minecraft/util/Vec3.xCoord D
      // 09d: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 0a0: istore 5
      // 0a2: aload 1
      // 0a3: getfield net/minecraft/util/Vec3.yCoord D
      // 0a6: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 0a9: istore 6
      // 0ab: aload 1
      // 0ac: getfield net/minecraft/util/Vec3.zCoord D
      // 0af: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 0b2: istore 7
      // 0b4: aload 0
      // 0b5: getfield net/minecraft/util/Vec3.xCoord D
      // 0b8: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 0bb: istore 8
      // 0bd: aload 0
      // 0be: getfield net/minecraft/util/Vec3.yCoord D
      // 0c1: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 0c4: istore 9
      // 0c6: aload 0
      // 0c7: getfield net/minecraft/util/Vec3.zCoord D
      // 0ca: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 0cd: istore 10
      // 0cf: aconst_null
      // 0d0: astore 11
      // 0d2: iload 8
      // 0d4: iload 9
      // 0d6: iload 10
      // 0d8: aload 0
      // 0d9: aload 1
      // 0da: invokestatic x/occb1ed1ed8f.ʡ (IIILnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/MovingObjectPosition;
      // 0dd: astore 12
      // 0df: aload 12
      // 0e1: iload 4
      // 0e3: ifne 0ef
      // 0e6: ifnull 10b
      // 0e9: goto 0ed
      // 0ec: athrow
      // 0ed: aload 12
      // 0ef: iload 4
      // 0f1: ifne 109
      // 0f4: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 0f7: iload 2
      // 0f8: iload 3
      // 0f9: invokestatic x/occb1ed1ed8f.Β (Lnet/minecraft/util/BlockPos;ZZ)Z
      // 0fc: ifeq 107
      // 0ff: goto 103
      // 102: athrow
      // 103: aload 12
      // 105: areturn
      // 106: athrow
      // 107: aload 12
      // 109: astore 11
      // 10b: aload 0
      // 10c: astore 13
      // 10e: ldc_w -1110340836
      // 111: ldc_w -1110340652
      // 114: ixor
      // 115: istore 14
      // 117: iload 14
      // 119: iinc 14 -1
      // 11c: iflt 4c3
      // 11f: aload 13
      // 121: iload 4
      // 123: ifne 139
      // 126: getfield net/minecraft/util/Vec3.xCoord D
      // 129: invokestatic java/lang/Double.isNaN (D)Z
      // 12c: ifne 163
      // 12f: goto 133
      // 132: athrow
      // 133: aload 13
      // 135: goto 139
      // 138: athrow
      // 139: getfield net/minecraft/util/Vec3.yCoord D
      // 13c: iload 4
      // 13e: ifne 154
      // 141: invokestatic java/lang/Double.isNaN (D)Z
      // 144: ifne 163
      // 147: goto 14b
      // 14a: athrow
      // 14b: aload 13
      // 14d: getfield net/minecraft/util/Vec3.zCoord D
      // 150: goto 154
      // 153: athrow
      // 154: invokestatic java/lang/Double.isNaN (D)Z
      // 157: iload 4
      // 159: ifne 169
      // 15c: ifeq 167
      // 15f: goto 163
      // 162: athrow
      // 163: aload 11
      // 165: areturn
      // 166: athrow
      // 167: iload 8
      // 169: iload 4
      // 16b: ifne 1a4
      // 16e: iload 5
      // 170: if_icmpne 1a3
      // 173: goto 177
      // 176: athrow
      // 177: iload 9
      // 179: iload 4
      // 17b: ifne 1a4
      // 17e: goto 182
      // 181: athrow
      // 182: iload 6
      // 184: if_icmpne 1a3
      // 187: goto 18b
      // 18a: athrow
      // 18b: iload 10
      // 18d: iload 4
      // 18f: ifne 1a4
      // 192: goto 196
      // 195: athrow
      // 196: iload 7
      // 198: if_icmpne 1a3
      // 19b: goto 19f
      // 19e: athrow
      // 19f: aload 11
      // 1a1: areturn
      // 1a2: athrow
      // 1a3: bipush 1
      // 1a4: istore 15
      // 1a6: bipush 1
      // 1a7: istore 16
      // 1a9: bipush 1
      // 1aa: istore 17
      // 1ac: ldc2_w 999.0
      // 1af: dstore 18
      // 1b1: ldc2_w 999.0
      // 1b4: dstore 20
      // 1b6: ldc2_w 999.0
      // 1b9: dstore 22
      // 1bb: iload 5
      // 1bd: iload 4
      // 1bf: ifne 1dd
      // 1c2: iload 8
      // 1c4: if_icmple 1d7
      // 1c7: goto 1cb
      // 1ca: athrow
      // 1cb: iload 8
      // 1cd: i2d
      // 1ce: dconst_1
      // 1cf: dadd
      // 1d0: dstore 18
      // 1d2: iload 4
      // 1d4: ifeq 1fc
      // 1d7: iload 5
      // 1d9: goto 1dd
      // 1dc: athrow
      // 1dd: iload 4
      // 1df: ifne 1fa
      // 1e2: iload 8
      // 1e4: if_icmpge 1f5
      // 1e7: goto 1eb
      // 1ea: athrow
      // 1eb: iload 8
      // 1ed: i2d
      // 1ee: dstore 18
      // 1f0: iload 4
      // 1f2: ifeq 1fc
      // 1f5: bipush 0
      // 1f6: goto 1fa
      // 1f9: athrow
      // 1fa: istore 15
      // 1fc: iload 6
      // 1fe: iload 4
      // 200: ifne 21e
      // 203: iload 9
      // 205: if_icmple 218
      // 208: goto 20c
      // 20b: athrow
      // 20c: iload 9
      // 20e: i2d
      // 20f: dconst_1
      // 210: dadd
      // 211: dstore 20
      // 213: iload 4
      // 215: ifeq 23d
      // 218: iload 6
      // 21a: goto 21e
      // 21d: athrow
      // 21e: iload 4
      // 220: ifne 23b
      // 223: iload 9
      // 225: if_icmpge 236
      // 228: goto 22c
      // 22b: athrow
      // 22c: iload 9
      // 22e: i2d
      // 22f: dstore 20
      // 231: iload 4
      // 233: ifeq 23d
      // 236: bipush 0
      // 237: goto 23b
      // 23a: athrow
      // 23b: istore 16
      // 23d: iload 7
      // 23f: iload 4
      // 241: ifne 25f
      // 244: iload 10
      // 246: if_icmple 259
      // 249: goto 24d
      // 24c: athrow
      // 24d: iload 10
      // 24f: i2d
      // 250: dconst_1
      // 251: dadd
      // 252: dstore 22
      // 254: iload 4
      // 256: ifeq 27e
      // 259: iload 7
      // 25b: goto 25f
      // 25e: athrow
      // 25f: iload 4
      // 261: ifne 27c
      // 264: iload 10
      // 266: if_icmpge 277
      // 269: goto 26d
      // 26c: athrow
      // 26d: iload 10
      // 26f: i2d
      // 270: dstore 22
      // 272: iload 4
      // 274: ifeq 27e
      // 277: bipush 0
      // 278: goto 27c
      // 27b: athrow
      // 27c: istore 17
      // 27e: aload 1
      // 27f: getfield net/minecraft/util/Vec3.xCoord D
      // 282: aload 13
      // 284: getfield net/minecraft/util/Vec3.xCoord D
      // 287: dsub
      // 288: dstore 24
      // 28a: aload 1
      // 28b: getfield net/minecraft/util/Vec3.yCoord D
      // 28e: aload 13
      // 290: getfield net/minecraft/util/Vec3.yCoord D
      // 293: dsub
      // 294: dstore 26
      // 296: aload 1
      // 297: getfield net/minecraft/util/Vec3.zCoord D
      // 29a: aload 13
      // 29c: getfield net/minecraft/util/Vec3.zCoord D
      // 29f: dsub
      // 2a0: dstore 28
      // 2a2: ldc2_w 999.0
      // 2a5: dstore 30
      // 2a7: ldc2_w 999.0
      // 2aa: dstore 32
      // 2ac: ldc2_w 999.0
      // 2af: dstore 34
      // 2b1: iload 15
      // 2b3: iload 4
      // 2b5: ifne 2ce
      // 2b8: ifeq 2cc
      // 2bb: goto 2bf
      // 2be: athrow
      // 2bf: dload 18
      // 2c1: aload 13
      // 2c3: getfield net/minecraft/util/Vec3.xCoord D
      // 2c6: dsub
      // 2c7: dload 24
      // 2c9: ddiv
      // 2ca: dstore 30
      // 2cc: iload 16
      // 2ce: iload 4
      // 2d0: ifne 2e9
      // 2d3: ifeq 2e7
      // 2d6: goto 2da
      // 2d9: athrow
      // 2da: dload 20
      // 2dc: aload 13
      // 2de: getfield net/minecraft/util/Vec3.yCoord D
      // 2e1: dsub
      // 2e2: dload 26
      // 2e4: ddiv
      // 2e5: dstore 32
      // 2e7: iload 17
      // 2e9: iload 4
      // 2eb: ifne 311
      // 2ee: ifeq 302
      // 2f1: goto 2f5
      // 2f4: athrow
      // 2f5: dload 22
      // 2f7: aload 13
      // 2f9: getfield net/minecraft/util/Vec3.zCoord D
      // 2fc: dsub
      // 2fd: dload 28
      // 2ff: ddiv
      // 300: dstore 34
      // 302: dload 30
      // 304: ldc2_w -0.0
      // 307: iload 4
      // 309: ifne 327
      // 30c: dcmpl
      // 30d: goto 311
      // 310: athrow
      // 311: ifne 319
      // 314: ldc2_w -1.0E-4
      // 317: dstore 30
      // 319: dload 32
      // 31b: iload 4
      // 31d: ifne 332
      // 320: ldc2_w -0.0
      // 323: goto 327
      // 326: athrow
      // 327: dcmpl
      // 328: ifne 330
      // 32b: ldc2_w -1.0E-4
      // 32e: dstore 32
      // 330: dload 34
      // 332: ldc2_w -0.0
      // 335: iload 4
      // 337: ifne 354
      // 33a: dcmpl
      // 33b: ifne 347
      // 33e: goto 342
      // 341: athrow
      // 342: ldc2_w -1.0E-4
      // 345: dstore 34
      // 347: dload 30
      // 349: iload 4
      // 34b: ifne 3ac
      // 34e: dload 32
      // 350: goto 354
      // 353: athrow
      // 354: dcmpg
      // 355: ifge 3aa
      // 358: dload 30
      // 35a: iload 4
      // 35c: ifne 3ac
      // 35f: goto 363
      // 362: athrow
      // 363: dload 34
      // 365: dcmpg
      // 366: ifge 3aa
      // 369: goto 36d
      // 36c: athrow
      // 36d: iload 5
      // 36f: iload 8
      // 371: if_icmple 37f
      // 374: goto 378
      // 377: athrow
      // 378: getstatic net/minecraft/util/EnumFacing.WEST Lnet/minecraft/util/EnumFacing;
      // 37b: goto 382
      // 37e: athrow
      // 37f: getstatic net/minecraft/util/EnumFacing.EAST Lnet/minecraft/util/EnumFacing;
      // 382: astore 36
      // 384: iload 4
      // 386: new net/minecraft/util/Vec3
      // 389: dup
      // 38a: dload 18
      // 38c: aload 13
      // 38e: getfield net/minecraft/util/Vec3.yCoord D
      // 391: dload 26
      // 393: dload 30
      // 395: dmul
      // 396: dadd
      // 397: aload 13
      // 399: getfield net/minecraft/util/Vec3.zCoord D
      // 39c: dload 28
      // 39e: dload 30
      // 3a0: dmul
      // 3a1: dadd
      // 3a2: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 3a5: astore 13
      // 3a7: ifeq 42c
      // 3aa: dload 32
      // 3ac: dload 34
      // 3ae: dcmpg
      // 3af: iload 4
      // 3b1: ifne 3fa
      // 3b4: ifge 3f8
      // 3b7: goto 3bb
      // 3ba: athrow
      // 3bb: iload 6
      // 3bd: iload 9
      // 3bf: if_icmple 3cd
      // 3c2: goto 3c6
      // 3c5: athrow
      // 3c6: getstatic net/minecraft/util/EnumFacing.DOWN Lnet/minecraft/util/EnumFacing;
      // 3c9: goto 3d0
      // 3cc: athrow
      // 3cd: getstatic net/minecraft/util/EnumFacing.UP Lnet/minecraft/util/EnumFacing;
      // 3d0: astore 36
      // 3d2: iload 4
      // 3d4: new net/minecraft/util/Vec3
      // 3d7: dup
      // 3d8: aload 13
      // 3da: getfield net/minecraft/util/Vec3.xCoord D
      // 3dd: dload 24
      // 3df: dload 32
      // 3e1: dmul
      // 3e2: dadd
      // 3e3: dload 20
      // 3e5: aload 13
      // 3e7: getfield net/minecraft/util/Vec3.zCoord D
      // 3ea: dload 28
      // 3ec: dload 32
      // 3ee: dmul
      // 3ef: dadd
      // 3f0: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 3f3: astore 13
      // 3f5: ifeq 42c
      // 3f8: iload 7
      // 3fa: iload 10
      // 3fc: if_icmple 406
      // 3ff: getstatic net/minecraft/util/EnumFacing.NORTH Lnet/minecraft/util/EnumFacing;
      // 402: goto 409
      // 405: athrow
      // 406: getstatic net/minecraft/util/EnumFacing.SOUTH Lnet/minecraft/util/EnumFacing;
      // 409: astore 36
      // 40b: new net/minecraft/util/Vec3
      // 40e: dup
      // 40f: aload 13
      // 411: getfield net/minecraft/util/Vec3.xCoord D
      // 414: dload 24
      // 416: dload 34
      // 418: dmul
      // 419: dadd
      // 41a: aload 13
      // 41c: getfield net/minecraft/util/Vec3.yCoord D
      // 41f: dload 26
      // 421: dload 34
      // 423: dmul
      // 424: dadd
      // 425: dload 22
      // 427: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 42a: astore 13
      // 42c: aload 13
      // 42e: getfield net/minecraft/util/Vec3.xCoord D
      // 431: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 434: aload 36
      // 436: getstatic net/minecraft/util/EnumFacing.EAST Lnet/minecraft/util/EnumFacing;
      // 439: if_acmpne 441
      // 43c: bipush 1
      // 43d: goto 442
      // 440: athrow
      // 441: bipush 0
      // 442: isub
      // 443: istore 8
      // 445: aload 13
      // 447: getfield net/minecraft/util/Vec3.yCoord D
      // 44a: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 44d: aload 36
      // 44f: getstatic net/minecraft/util/EnumFacing.UP Lnet/minecraft/util/EnumFacing;
      // 452: if_acmpne 45a
      // 455: bipush 1
      // 456: goto 45b
      // 459: athrow
      // 45a: bipush 0
      // 45b: isub
      // 45c: istore 9
      // 45e: aload 13
      // 460: getfield net/minecraft/util/Vec3.zCoord D
      // 463: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 466: aload 36
      // 468: getstatic net/minecraft/util/EnumFacing.SOUTH Lnet/minecraft/util/EnumFacing;
      // 46b: if_acmpne 473
      // 46e: bipush 1
      // 46f: goto 474
      // 472: athrow
      // 473: bipush 0
      // 474: isub
      // 475: istore 10
      // 477: iload 8
      // 479: iload 9
      // 47b: iload 10
      // 47d: aload 0
      // 47e: aload 1
      // 47f: invokestatic x/occb1ed1ed8f.ʡ (IIILnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/MovingObjectPosition;
      // 482: iload 4
      // 484: ifne 494
      // 487: astore 12
      // 489: aload 12
      // 48b: ifnull 4be
      // 48e: aload 12
      // 490: goto 494
      // 493: athrow
      // 494: iload 4
      // 496: ifne 4ae
      // 499: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 49c: iload 2
      // 49d: iload 3
      // 49e: invokestatic x/occb1ed1ed8f.Β (Lnet/minecraft/util/BlockPos;ZZ)Z
      // 4a1: ifeq 4ac
      // 4a4: goto 4a8
      // 4a7: athrow
      // 4a8: aload 12
      // 4aa: areturn
      // 4ab: athrow
      // 4ac: aload 11
      // 4ae: iload 4
      // 4b0: ifne 4bc
      // 4b3: ifnonnull 4be
      // 4b6: goto 4ba
      // 4b9: athrow
      // 4ba: aload 12
      // 4bc: astore 11
      // 4be: iload 4
      // 4c0: ifeq 117
      // 4c3: aload 11
      // 4c5: areturn
   }

   private static MovingObjectPosition ʡ(int param0, int param1, int param2, Vec3 param3, Vec3 param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: new net/minecraft/util/BlockPos
      // 06: dup
      // 07: iload 0
      // 08: iload 1
      // 09: iload 2
      // 0a: invokespecial net/minecraft/util/BlockPos.<init> (III)V
      // 0d: astore 6
      // 0f: istore 5
      // 11: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 14: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 17: aload 6
      // 19: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 1c: astore 7
      // 1e: aload 7
      // 20: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 25: astore 8
      // 27: aload 8
      // 29: iload 5
      // 2b: ifne 40
      // 2e: aload 7
      // 30: bipush 0
      // 31: invokevirtual net/minecraft/block/Block.canCollideCheck (Lnet/minecraft/block/state/IBlockState;Z)Z
      // 34: ifne 3e
      // 37: goto 3b
      // 3a: athrow
      // 3b: aconst_null
      // 3c: areturn
      // 3d: athrow
      // 3e: aload 8
      // 40: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 43: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 46: aload 6
      // 48: aload 3
      // 49: aload 4
      // 4b: invokevirtual net/minecraft/block/Block.collisionRayTrace (Lnet/minecraft/world/World;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/MovingObjectPosition;
      // 4e: areturn
   }

   private static boolean Β(BlockPos param0, boolean param1, boolean param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: aload 0
      // 04: invokestatic x/occb1ed1ed8f.ϛ (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/Block;
      // 07: astore 4
      // 09: aload 4
      // 0b: instanceof net/minecraft/block/BlockBed
      // 0e: istore 5
      // 10: istore 3
      // 11: iload 1
      // 12: iload 3
      // 13: ifne 32
      // 16: ifeq 31
      // 19: goto 1d
      // 1c: athrow
      // 1d: iload 5
      // 1f: iload 3
      // 20: ifne 32
      // 23: goto 27
      // 26: athrow
      // 27: ifeq 31
      // 2a: goto 2e
      // 2d: athrow
      // 2e: bipush 1
      // 2f: ireturn
      // 30: athrow
      // 31: iload 2
      // 32: iload 3
      // 33: ifne 65
      // 36: ifeq 64
      // 39: goto 3d
      // 3c: athrow
      // 3d: iload 5
      // 3f: iload 3
      // 40: ifne 65
      // 43: goto 47
      // 46: athrow
      // 47: ifne 64
      // 4a: goto 4e
      // 4d: athrow
      // 4e: aload 0
      // 4f: invokestatic x/occb1ed1ed8f.П (Lnet/minecraft/util/BlockPos;)Z
      // 52: iload 3
      // 53: ifne 65
      // 56: goto 5a
      // 59: athrow
      // 5a: ifeq 64
      // 5d: goto 61
      // 60: athrow
      // 61: bipush 1
      // 62: ireturn
      // 63: athrow
      // 64: bipush 0
      // 65: ireturn
   }
}

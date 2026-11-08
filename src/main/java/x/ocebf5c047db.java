package x;

import net.minecraft.block.Block;
import net.minecraft.block.BlockAnvil;
import net.minecraft.block.BlockBed;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockEnchantmentTable;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;

public class ocebf5c047db extends oca897d4a197 {
   private static final int ȧ = -1;
   private static final int ƭ = 20;
   private static final int һ = 60;
   private final oca9cc61aada Ƴ;
   private final oca9cc61aada ҧ;
   private final occ2f8dff8d8 ю;
   private final oca9cc61aada ǰ;
   private double Ϛ;
   private boolean Ι;
   private boolean Ȣ;
   private BlockPos ѥ;
   private int ɟ = -1;
   private int Ŝ;
   private int Қ;
   public static boolean Ϙ;

   public ocebf5c047db(ocff26c2f723 var1) {
      super("MLG", var1);
      this.ѫ(this.Ƴ = new oca9cc61aada("Min Fall", 2.5, 1.0, 5.0, 0.1));
      this.ѫ(this.ҧ = new oca9cc61aada("PickupDelay", 3.0, 0.0, 20.0, 1.0));
      this.ѫ(this.ю = new occ2f8dff8d8("SwitchBack", true));
      this.ѫ(this.ǰ = new oca9cc61aada("RotationSpeed", 6.0, 2.0, 10.0, 0.1));
   }

   public void z$22mqk5pab06po() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield x/oca897d4a197.ä Lx/ocff26c2f723;
      // 04: ldc "MLG"
      // 06: invokevirtual x/ocff26c2f723.ǹ (Ljava/lang/String;)Z
      // 09: istore 2
      // 0a: aload 0
      // 0b: getfield x/ocebf5c047db.Ƴ Lx/oca9cc61aada;
      // 0e: iload 2
      // 0f: aload 0
      // 10: getfield x/oca897d4a197.ä Lx/ocff26c2f723;
      // 13: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 16: aload 0
      // 17: getfield x/ocebf5c047db.ҧ Lx/oca9cc61aada;
      // 1a: iload 2
      // 1b: aload 0
      // 1c: getfield x/oca897d4a197.ä Lx/ocff26c2f723;
      // 1f: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 22: getstatic x/oca897d4a197.Է Z
      // 25: aload 0
      // 26: getfield x/ocebf5c047db.ю Lx/occ2f8dff8d8;
      // 29: iload 2
      // 2a: aload 0
      // 2b: getfield x/oca897d4a197.ä Lx/ocff26c2f723;
      // 2e: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 31: istore 1
      // 32: aload 0
      // 33: getfield x/ocebf5c047db.ǰ Lx/oca9cc61aada;
      // 36: iload 2
      // 37: aload 0
      // 38: getfield x/oca897d4a197.ä Lx/ocff26c2f723;
      // 3b: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 3e: iload 1
      // 3f: ifeq 53
      // 42: bipush 0
      // 43: ifeq 4f
      // 46: goto 4a
      // 49: athrow
      // 4a: bipush 0
      // 4b: goto 50
      // 4e: athrow
      // 4f: bipush 1
      // 50: putstatic x/oc69da1aa7f5.Ҭ Z
      // 53: return
   }

   public void z$v0pjcuscvgpm() {
      ocebf5c047db var10000;
      double var10001;
      label16: {
         try {
            this.Ǜ(false);
            var10000 = this;
            if (oc7ab2161b9f.Ð()) {
               var10001 = super.ω.thePlayer.posY;
               break label16;
            }
         } catch (ocbde1165e4e var1) {
            throw var1;
         }

         var10001 = 0.0;
      }

      var10000.Ϛ = var10001;
   }

   public void z$lhgkqjml0t90() {
      this.Ǜ(true);
   }

   public void z$332enlh7knq4u(oc86de9e2892 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oca897d4a197.Է Z
      // 003: istore 2
      // 004: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 007: ifne 011
      // 00a: aload 0
      // 00b: bipush 0
      // 00c: invokevirtual x/ocebf5c047db.Ǜ (Z)V
      // 00f: return
      // 010: athrow
      // 011: aload 0
      // 012: getfield x/oca897d4a197.ω Lnet/minecraft/client/Minecraft;
      // 015: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 018: astore 3
      // 019: aload 3
      // 01a: iload 2
      // 01b: ifne 032
      // 01e: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // 021: aload 0
      // 022: getfield x/ocebf5c047db.Ϛ D
      // 025: dcmpl
      // 026: ifgt 040
      // 029: goto 02d
      // 02c: athrow
      // 02d: aload 3
      // 02e: goto 032
      // 031: athrow
      // 032: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 035: iload 2
      // 036: ifne 058
      // 039: ifeq 04c
      // 03c: goto 040
      // 03f: athrow
      // 040: aload 0
      // 041: aload 3
      // 042: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // 045: putfield x/ocebf5c047db.Ϛ D
      // 048: goto 04c
      // 04b: athrow
      // 04c: aload 0
      // 04d: iload 2
      // 04e: ifne 082
      // 051: getfield x/ocebf5c047db.Қ I
      // 054: goto 058
      // 057: athrow
      // 058: ifle 081
      // 05b: aload 0
      // 05c: iload 2
      // 05d: ifne 07d
      // 060: goto 064
      // 063: athrow
      // 064: dup
      // 065: getfield x/ocebf5c047db.Қ I
      // 068: bipush 1
      // 069: isub
      // 06a: putfield x/ocebf5c047db.Қ I
      // 06d: aload 0
      // 06e: getfield x/ocebf5c047db.Қ I
      // 071: ifne 080
      // 074: goto 078
      // 077: athrow
      // 078: aload 0
      // 079: goto 07d
      // 07c: athrow
      // 07d: invokevirtual x/ocebf5c047db.ӡ ()V
      // 080: return
      // 081: aload 0
      // 082: getfield x/ocebf5c047db.Ι Z
      // 085: iload 2
      // 086: ifne 09b
      // 089: ifeq 097
      // 08c: goto 090
      // 08f: athrow
      // 090: aload 0
      // 091: aload 1
      // 092: invokevirtual x/ocebf5c047db.ʅ (Lx/oc86de9e2892;)V
      // 095: return
      // 096: athrow
      // 097: aload 3
      // 098: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 09b: iload 2
      // 09c: ifne 0bd
      // 09f: ifeq 0b1
      // 0a2: goto 0a6
      // 0a5: athrow
      // 0a6: aload 0
      // 0a7: bipush 0
      // 0a8: putfield x/ocebf5c047db.Ȣ Z
      // 0ab: aload 0
      // 0ac: invokevirtual x/ocebf5c047db.ӡ ()V
      // 0af: return
      // 0b0: athrow
      // 0b1: aload 0
      // 0b2: iload 2
      // 0b3: ifne 0d4
      // 0b6: getfield x/ocebf5c047db.Ȣ Z
      // 0b9: goto 0bd
      // 0bc: athrow
      // 0bd: ifeq 0d3
      // 0c0: aload 3
      // 0c1: aload 0
      // 0c2: getfield x/oca897d4a197.ω Lnet/minecraft/client/Minecraft;
      // 0c5: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 0c8: getfield net/minecraft/client/settings/GameSettings.keyBindSneak Lnet/minecraft/client/settings/KeyBinding;
      // 0cb: invokevirtual net/minecraft/client/settings/KeyBinding.isKeyDown ()Z
      // 0ce: invokevirtual net/minecraft/client/entity/EntityPlayerSP.setSneaking (Z)V
      // 0d1: return
      // 0d2: athrow
      // 0d3: aload 0
      // 0d4: invokevirtual x/ocebf5c047db.ѓ ()Z
      // 0d7: istore 4
      // 0d9: aload 3
      // 0da: ldc 911329900
      // 0dc: ldc 911329912
      // 0de: ixor
      // 0df: invokestatic x/oc1a696cd7dd.ӟ (Lnet/minecraft/entity/EntityLivingBase;I)[Lx/oce673b272fb;
      // 0e2: astore 5
      // 0e4: aload 0
      // 0e5: aload 5
      // 0e7: iload 4
      // 0e9: invokevirtual x/ocebf5c047db.Ц ([Lx/oce673b272fb;Z)Lx/oce673b272fb;
      // 0ec: astore 6
      // 0ee: aload 6
      // 0f0: ifnonnull 0f5
      // 0f3: return
      // 0f4: athrow
      // 0f5: aload 0
      // 0f6: getfield x/ocebf5c047db.Ϛ D
      // 0f9: aload 6
      // 0fb: invokevirtual x/oce673b272fb.Ƶ ()D
      // 0fe: dsub
      // 0ff: dstore 7
      // 101: dload 7
      // 103: aload 0
      // 104: getfield x/ocebf5c047db.Ƴ Lx/oca9cc61aada;
      // 107: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 10a: dcmpg
      // 10b: iload 2
      // 10c: ifne 126
      // 10f: ifge 117
      // 112: goto 116
      // 115: athrow
      // 116: return
      // 117: aload 0
      // 118: iload 2
      // 119: ifne 12b
      // 11c: aload 1
      // 11d: aload 6
      // 11f: invokevirtual x/ocebf5c047db.Ҳ (Lx/oc86de9e2892;Lx/oce673b272fb;)Z
      // 122: goto 126
      // 125: athrow
      // 126: ifeq 12a
      // 129: return
      // 12a: aload 0
      // 12b: aload 1
      // 12c: aload 6
      // 12e: iload 4
      // 130: invokevirtual x/ocebf5c047db.ѩ (Lx/oc86de9e2892;Lx/oce673b272fb;Z)Z
      // 133: pop
      // 134: return
   }

   public void z$1ctfmdsr4zs0m(ocbab3c9954b var1) {
      this.Ǜ(false);
   }

   private oce673b272fb Ц(oce673b272fb[] param1, boolean param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oca897d4a197.Է Z
      // 03: bipush 1
      // 04: istore 4
      // 06: istore 3
      // 07: iload 4
      // 09: aload 1
      // 0a: arraylength
      // 0b: if_icmpge 6a
      // 0e: aload 1
      // 0f: iload 4
      // 11: aaload
      // 12: astore 5
      // 14: aload 5
      // 16: iload 3
      // 17: ifne 2e
      // 1a: invokevirtual x/oce673b272fb.Ö ()Z
      // 1d: ifne 6a
      // 20: goto 24
      // 23: athrow
      // 24: aload 5
      // 26: iload 3
      // 27: ifne 52
      // 2a: goto 2e
      // 2d: athrow
      // 2e: invokevirtual x/oce673b272fb.Ϫ ()Z
      // 31: ifeq 4c
      // 34: iload 2
      // 35: iload 3
      // 36: ifne 5d
      // 39: goto 3d
      // 3c: athrow
      // 3d: ifne 4c
      // 40: goto 44
      // 43: athrow
      // 44: iload 3
      // 45: ifeq 6a
      // 48: goto 4c
      // 4b: athrow
      // 4c: aload 5
      // 4e: goto 52
      // 51: athrow
      // 52: iload 3
      // 53: ifne 62
      // 56: invokevirtual x/oce673b272fb.w ()Z
      // 59: goto 5d
      // 5c: athrow
      // 5d: ifeq 63
      // 60: aload 5
      // 62: areturn
      // 63: iinc 4 1
      // 66: iload 3
      // 67: ifeq 07
      // 6a: aconst_null
      // 6b: areturn
   }

   private void ʅ(oc86de9e2892 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: getstatic x/oca897d4a197.Է Z
      // 003: istore 2
      // 004: iload 2
      // 005: aload 0
      // 006: getfield x/oca897d4a197.ω Lnet/minecraft/client/Minecraft;
      // 009: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 00c: astore 3
      // 00d: ifne 02f
      // 010: aload 3
      // 011: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 014: ifne 01d
      // 017: goto 01b
      // 01a: athrow
      // 01b: return
      // 01c: athrow
      // 01d: aload 0
      // 01e: iload 2
      // 01f: ifne 046
      // 022: dup
      // 023: getfield x/ocebf5c047db.Ŝ I
      // 026: bipush 1
      // 027: iadd
      // 028: putfield x/ocebf5c047db.Ŝ I
      // 02b: goto 02f
      // 02e: athrow
      // 02f: aload 0
      // 030: getfield x/ocebf5c047db.Ŝ I
      // 033: ldc -712346470
      // 035: ldc -712346458
      // 037: ixor
      // 038: if_icmple 045
      // 03b: aload 0
      // 03c: invokevirtual x/ocebf5c047db.ӡ ()V
      // 03f: aload 0
      // 040: invokevirtual x/ocebf5c047db.Ҏ ()V
      // 043: return
      // 044: athrow
      // 045: aload 0
      // 046: iload 2
      // 047: ifne 05f
      // 04a: getfield x/ocebf5c047db.ѥ Lnet/minecraft/util/BlockPos;
      // 04d: ifnonnull 05e
      // 050: goto 054
      // 053: athrow
      // 054: aload 0
      // 055: invokevirtual x/ocebf5c047db.ӡ ()V
      // 058: aload 0
      // 059: invokevirtual x/ocebf5c047db.Ҏ ()V
      // 05c: return
      // 05d: athrow
      // 05e: aload 0
      // 05f: getfield x/oca897d4a197.ω Lnet/minecraft/client/Minecraft;
      // 062: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 065: aload 0
      // 066: getfield x/ocebf5c047db.ѥ Lnet/minecraft/util/BlockPos;
      // 069: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 06c: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 071: astore 4
      // 073: aload 4
      // 075: iload 2
      // 076: ifne 089
      // 079: getstatic net/minecraft/init/Blocks.water Lnet/minecraft/block/BlockStaticLiquid;
      // 07c: if_acmpeq 099
      // 07f: goto 083
      // 082: athrow
      // 083: aload 4
      // 085: goto 089
      // 088: athrow
      // 089: getstatic net/minecraft/init/Blocks.flowing_water Lnet/minecraft/block/BlockDynamicLiquid;
      // 08c: if_acmpeq 099
      // 08f: aload 0
      // 090: invokevirtual x/ocebf5c047db.ӡ ()V
      // 093: aload 0
      // 094: invokevirtual x/ocebf5c047db.Ҏ ()V
      // 097: return
      // 098: athrow
      // 099: aload 0
      // 09a: bipush 0
      // 09b: invokevirtual x/ocebf5c047db.ų (Z)I
      // 09e: istore 5
      // 0a0: iload 2
      // 0a1: ifne 0ba
      // 0a4: iload 5
      // 0a6: bipush -1
      // 0a7: if_icmpne 0bb
      // 0aa: goto 0ae
      // 0ad: athrow
      // 0ae: aload 0
      // 0af: invokevirtual x/ocebf5c047db.ӡ ()V
      // 0b2: aload 0
      // 0b3: invokevirtual x/ocebf5c047db.Ҏ ()V
      // 0b6: goto 0ba
      // 0b9: athrow
      // 0ba: return
      // 0bb: aload 3
      // 0bc: fconst_1
      // 0bd: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 0c0: astore 6
      // 0c2: ldc2_w 1.7976931348623157E308
      // 0c5: dstore 7
      // 0c7: aconst_null
      // 0c8: astore 9
      // 0ca: ldc_w 0.1
      // 0cd: fstore 10
      // 0cf: fload 10
      // 0d1: ldc_w 0.9
      // 0d4: fcmpg
      // 0d5: ifgt 1d3
      // 0d8: iload 2
      // 0d9: ifne 1e2
      // 0dc: ldc_w 0.1
      // 0df: fstore 11
      // 0e1: fload 11
      // 0e3: ldc_w 0.9
      // 0e6: fcmpg
      // 0e7: ifgt 1c7
      // 0ea: new net/minecraft/util/Vec3
      // 0ed: dup
      // 0ee: aload 0
      // 0ef: getfield x/ocebf5c047db.ѥ Lnet/minecraft/util/BlockPos;
      // 0f2: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 0f5: i2f
      // 0f6: fload 10
      // 0f8: fadd
      // 0f9: f2d
      // 0fa: aload 0
      // 0fb: getfield x/ocebf5c047db.ѥ Lnet/minecraft/util/BlockPos;
      // 0fe: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 101: i2d
      // 102: ldc2_w 0.5
      // 105: dadd
      // 106: aload 0
      // 107: getfield x/ocebf5c047db.ѥ Lnet/minecraft/util/BlockPos;
      // 10a: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 10d: i2f
      // 10e: fload 11
      // 110: fadd
      // 111: f2d
      // 112: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 115: astore 12
      // 117: aload 0
      // 118: getfield x/oca897d4a197.ω Lnet/minecraft/client/Minecraft;
      // 11b: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 11e: aload 6
      // 120: aload 12
      // 122: invokevirtual net/minecraft/client/multiplayer/WorldClient.rayTraceBlocks (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/MovingObjectPosition;
      // 125: iload 2
      // 126: ifne 226
      // 129: astore 13
      // 12b: iload 2
      // 12c: ifne 1c3
      // 12f: aload 13
      // 131: ifnull 1bb
      // 134: goto 138
      // 137: athrow
      // 138: aload 13
      // 13a: getfield net/minecraft/util/MovingObjectPosition.typeOfHit Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 13d: getstatic net/minecraft/util/MovingObjectPosition$MovingObjectType.BLOCK Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 140: if_acmpne 1bb
      // 143: goto 147
      // 146: athrow
      // 147: aload 0
      // 148: getfield x/ocebf5c047db.ѥ Lnet/minecraft/util/BlockPos;
      // 14b: aload 13
      // 14d: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 150: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 153: ifne 162
      // 156: goto 15a
      // 159: athrow
      // 15a: iload 2
      // 15b: ifeq 1bb
      // 15e: goto 162
      // 161: athrow
      // 162: aload 6
      // 164: aload 13
      // 166: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 169: getfield net/minecraft/util/Vec3.xCoord D
      // 16c: aload 13
      // 16e: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 171: getfield net/minecraft/util/Vec3.yCoord D
      // 174: aload 13
      // 176: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 179: getfield net/minecraft/util/Vec3.zCoord D
      // 17c: invokestatic x/oc75d51ec7eb.ӆ (Lnet/minecraft/util/Vec3;DDD)[F
      // 17f: astore 14
      // 181: aload 14
      // 183: bipush 0
      // 184: faload
      // 185: aload 0
      // 186: aload 1
      // 187: invokevirtual x/ocebf5c047db.Ư (Lx/oc86de9e2892;)F
      // 18a: iload 2
      // 18b: ifne 1c0
      // 18e: fsub
      // 18f: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_float (F)F
      // 192: invokestatic java/lang/Math.abs (F)F
      // 195: f2d
      // 196: ldc2_w 3.0
      // 199: dmul
      // 19a: aload 14
      // 19c: bipush 1
      // 19d: faload
      // 19e: aload 0
      // 19f: aload 1
      // 1a0: invokevirtual x/ocebf5c047db.Z (Lx/oc86de9e2892;)F
      // 1a3: fsub
      // 1a4: invokestatic java/lang/Math.abs (F)F
      // 1a7: f2d
      // 1a8: dadd
      // 1a9: dstore 15
      // 1ab: dload 15
      // 1ad: dload 7
      // 1af: dcmpg
      // 1b0: ifge 1bb
      // 1b3: dload 15
      // 1b5: dstore 7
      // 1b7: aload 14
      // 1b9: astore 9
      // 1bb: fload 11
      // 1bd: ldc_w 0.2
      // 1c0: fadd
      // 1c1: fstore 11
      // 1c3: iload 2
      // 1c4: ifeq 0e1
      // 1c7: fload 10
      // 1c9: ldc_w 0.2
      // 1cc: fadd
      // 1cd: fstore 10
      // 1cf: iload 2
      // 1d0: ifeq 0cf
      // 1d3: aload 9
      // 1d5: ifnonnull 1e2
      // 1d8: aload 0
      // 1d9: invokevirtual x/ocebf5c047db.ӡ ()V
      // 1dc: aload 0
      // 1dd: invokevirtual x/ocebf5c047db.Ҏ ()V
      // 1e0: return
      // 1e1: athrow
      // 1e2: aload 0
      // 1e3: iload 2
      // 1e4: ifne 1f7
      // 1e7: aload 1
      // 1e8: aload 9
      // 1ea: invokevirtual x/ocebf5c047db.Ю (Lx/oc86de9e2892;[F)Z
      // 1ed: ifne 1f6
      // 1f0: goto 1f4
      // 1f3: athrow
      // 1f4: return
      // 1f5: athrow
      // 1f6: aload 0
      // 1f7: iload 2
      // 1f8: ifne 216
      // 1fb: getfield x/ocebf5c047db.Ŝ I
      // 1fe: aload 0
      // 1ff: getfield x/ocebf5c047db.ҧ Lx/oca9cc61aada;
      // 202: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 205: d2i
      // 206: if_icmpgt 20f
      // 209: goto 20d
      // 20c: athrow
      // 20d: return
      // 20e: athrow
      // 20f: aload 0
      // 210: iload 5
      // 212: invokevirtual x/ocebf5c047db.ȩ (I)V
      // 215: aload 0
      // 216: ldc2_w 5.0
      // 219: aload 0
      // 21a: aload 1
      // 21b: invokevirtual x/ocebf5c047db.Ư (Lx/oc86de9e2892;)F
      // 21e: aload 0
      // 21f: aload 1
      // 220: invokevirtual x/ocebf5c047db.Z (Lx/oc86de9e2892;)F
      // 223: invokevirtual x/ocebf5c047db.Է (DFF)Lnet/minecraft/util/MovingObjectPosition;
      // 226: astore 10
      // 228: aload 10
      // 22a: iload 2
      // 22b: ifne 237
      // 22e: ifnull 240
      // 231: goto 235
      // 234: athrow
      // 235: aload 10
      // 237: getfield net/minecraft/util/MovingObjectPosition.typeOfHit Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 23a: getstatic net/minecraft/util/MovingObjectPosition$MovingObjectType.BLOCK Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 23d: if_acmpeq 242
      // 240: return
      // 241: athrow
      // 242: aload 0
      // 243: getfield x/oca897d4a197.ω Lnet/minecraft/client/Minecraft;
      // 246: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 249: aload 10
      // 24b: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 24e: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 251: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 256: astore 11
      // 258: aload 11
      // 25a: iload 2
      // 25b: ifne 26e
      // 25e: getstatic net/minecraft/init/Blocks.water Lnet/minecraft/block/BlockStaticLiquid;
      // 261: if_acmpeq 274
      // 264: goto 268
      // 267: athrow
      // 268: aload 11
      // 26a: goto 26e
      // 26d: athrow
      // 26e: getstatic net/minecraft/init/Blocks.flowing_water Lnet/minecraft/block/BlockDynamicLiquid;
      // 271: if_acmpne 28f
      // 274: aload 0
      // 275: iload 2
      // 276: ifne 29a
      // 279: goto 27d
      // 27c: athrow
      // 27d: getfield x/ocebf5c047db.ѥ Lnet/minecraft/util/BlockPos;
      // 280: aload 10
      // 282: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 285: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 288: ifne 299
      // 28b: goto 28f
      // 28e: athrow
      // 28f: aload 0
      // 290: invokevirtual x/ocebf5c047db.ӡ ()V
      // 293: aload 0
      // 294: invokevirtual x/ocebf5c047db.Ҏ ()V
      // 297: return
      // 298: athrow
      // 299: aload 0
      // 29a: iload 2
      // 29b: ifne 2bf
      // 29e: getfield x/oca897d4a197.ω Lnet/minecraft/client/Minecraft;
      // 2a1: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 2a4: aload 3
      // 2a5: aload 0
      // 2a6: getfield x/oca897d4a197.ω Lnet/minecraft/client/Minecraft;
      // 2a9: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 2ac: aload 3
      // 2ad: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 2b0: invokevirtual net/minecraft/client/multiplayer/PlayerControllerMP.sendUseItem (Lnet/minecraft/entity/player/EntityPlayer;Lnet/minecraft/world/World;Lnet/minecraft/item/ItemStack;)Z
      // 2b3: ifeq 2e2
      // 2b6: goto 2ba
      // 2b9: athrow
      // 2ba: aload 0
      // 2bb: goto 2bf
      // 2be: athrow
      // 2bf: aload 0
      // 2c0: getfield x/ocebf5c047db.ю Lx/occ2f8dff8d8;
      // 2c3: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 2c6: iload 2
      // 2c7: ifne 2d7
      // 2ca: ifeq 2da
      // 2cd: goto 2d1
      // 2d0: athrow
      // 2d1: ldc_w -712346461
      // 2d4: ldc -712346458
      // 2d6: ixor
      // 2d7: goto 2db
      // 2da: bipush 0
      // 2db: putfield x/ocebf5c047db.Қ I
      // 2de: aload 0
      // 2df: invokevirtual x/ocebf5c047db.Ҏ ()V
      // 2e2: return
   }

   private boolean Ҳ(oc86de9e2892 param1, oce673b272fb param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oca897d4a197.Է Z
      // 003: aload 0
      // 004: getfield x/oca897d4a197.ω Lnet/minecraft/client/Minecraft;
      // 007: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 00a: astore 4
      // 00c: aload 0
      // 00d: bipush 1
      // 00e: invokevirtual x/ocebf5c047db.ų (Z)I
      // 011: istore 5
      // 013: istore 3
      // 014: iload 5
      // 016: iload 3
      // 017: ifne 027
      // 01a: bipush -1
      // 01b: if_icmpne 028
      // 01e: goto 022
      // 021: athrow
      // 022: bipush 0
      // 023: goto 027
      // 026: athrow
      // 027: ireturn
      // 028: new net/minecraft/util/BlockPos
      // 02b: dup
      // 02c: aload 2
      // 02d: invokevirtual x/oce673b272fb.Ϡ ()D
      // 030: aload 2
      // 031: invokevirtual x/oce673b272fb.Ƶ ()D
      // 034: aload 2
      // 035: invokevirtual x/oce673b272fb.Õ ()D
      // 038: invokespecial net/minecraft/util/BlockPos.<init> (DDD)V
      // 03b: invokevirtual net/minecraft/util/BlockPos.down ()Lnet/minecraft/util/BlockPos;
      // 03e: astore 6
      // 040: aload 0
      // 041: getfield x/oca897d4a197.ω Lnet/minecraft/client/Minecraft;
      // 044: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 047: aload 6
      // 049: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 04c: astore 7
      // 04e: aload 7
      // 050: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 055: aload 0
      // 056: getfield x/oca897d4a197.ω Lnet/minecraft/client/Minecraft;
      // 059: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 05c: aload 6
      // 05e: aload 7
      // 060: invokevirtual net/minecraft/block/Block.getCollisionBoundingBox (Lnet/minecraft/world/World;Lnet/minecraft/util/BlockPos;Lnet/minecraft/block/state/IBlockState;)Lnet/minecraft/util/AxisAlignedBB;
      // 063: astore 8
      // 065: aload 8
      // 067: iload 3
      // 068: ifne 074
      // 06b: ifnull 07e
      // 06e: goto 072
      // 071: athrow
      // 072: aload 8
      // 074: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 077: ldc2_w 0.1
      // 07a: dsub
      // 07b: goto 088
      // 07e: aload 6
      // 080: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 083: i2d
      // 084: ldc2_w 0.9
      // 087: dadd
      // 088: dstore 9
      // 08a: aload 4
      // 08c: fconst_1
      // 08d: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 090: astore 11
      // 092: ldc2_w 1.7976931348623157E308
      // 095: dstore 12
      // 097: aconst_null
      // 098: astore 14
      // 09a: aconst_null
      // 09b: astore 15
      // 09d: ldc_w 0.05
      // 0a0: fstore 16
      // 0a2: fload 16
      // 0a4: ldc_w 0.95
      // 0a7: fcmpg
      // 0a8: ifgt 1ea
      // 0ab: iload 3
      // 0ac: ifne 1f8
      // 0af: ldc_w 0.05
      // 0b2: fstore 17
      // 0b4: fload 17
      // 0b6: ldc_w 0.95
      // 0b9: fcmpg
      // 0ba: ifgt 1de
      // 0bd: new net/minecraft/util/Vec3
      // 0c0: dup
      // 0c1: aload 6
      // 0c3: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 0c6: i2f
      // 0c7: fload 16
      // 0c9: fadd
      // 0ca: f2d
      // 0cb: dload 9
      // 0cd: aload 6
      // 0cf: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 0d2: i2f
      // 0d3: fload 17
      // 0d5: fadd
      // 0d6: f2d
      // 0d7: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 0da: iload 3
      // 0db: ifne 1ec
      // 0de: astore 18
      // 0e0: iload 3
      // 0e1: aload 0
      // 0e2: getfield x/oca897d4a197.ω Lnet/minecraft/client/Minecraft;
      // 0e5: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 0e8: aload 11
      // 0ea: aload 18
      // 0ec: invokevirtual net/minecraft/client/multiplayer/WorldClient.rayTraceBlocks (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/MovingObjectPosition;
      // 0ef: astore 19
      // 0f1: ifne 1da
      // 0f4: aload 19
      // 0f6: ifnull 1d2
      // 0f9: goto 0fd
      // 0fc: athrow
      // 0fd: aload 19
      // 0ff: iload 3
      // 100: ifne 11a
      // 103: goto 107
      // 106: athrow
      // 107: getfield net/minecraft/util/MovingObjectPosition.typeOfHit Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 10a: getstatic net/minecraft/util/MovingObjectPosition$MovingObjectType.BLOCK Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 10d: if_acmpne 1d2
      // 110: goto 114
      // 113: athrow
      // 114: aload 19
      // 116: goto 11a
      // 119: athrow
      // 11a: getfield net/minecraft/util/MovingObjectPosition.sideHit Lnet/minecraft/util/EnumFacing;
      // 11d: getstatic net/minecraft/util/EnumFacing.UP Lnet/minecraft/util/EnumFacing;
      // 120: if_acmpne 1d2
      // 123: aload 6
      // 125: aload 19
      // 127: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 12a: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 12d: ifne 13c
      // 130: goto 134
      // 133: athrow
      // 134: iload 3
      // 135: ifeq 1d2
      // 138: goto 13c
      // 13b: athrow
      // 13c: aload 11
      // 13e: aload 19
      // 140: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 143: getfield net/minecraft/util/Vec3.xCoord D
      // 146: aload 19
      // 148: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 14b: getfield net/minecraft/util/Vec3.yCoord D
      // 14e: aload 19
      // 150: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 153: getfield net/minecraft/util/Vec3.zCoord D
      // 156: invokestatic x/oc75d51ec7eb.ӆ (Lnet/minecraft/util/Vec3;DDD)[F
      // 159: astore 20
      // 15b: iload 3
      // 15c: aload 20
      // 15e: bipush 0
      // 15f: faload
      // 160: aload 0
      // 161: aload 1
      // 162: invokevirtual x/ocebf5c047db.Ư (Lx/oc86de9e2892;)F
      // 165: fsub
      // 166: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_float (F)F
      // 169: invokestatic java/lang/Math.abs (F)F
      // 16c: f2d
      // 16d: ldc2_w 3.0
      // 170: dmul
      // 171: aload 20
      // 173: bipush 1
      // 174: faload
      // 175: aload 0
      // 176: aload 1
      // 177: invokevirtual x/ocebf5c047db.Z (Lx/oc86de9e2892;)F
      // 17a: fsub
      // 17b: invokestatic java/lang/Math.abs (F)F
      // 17e: f2d
      // 17f: dadd
      // 180: dstore 21
      // 182: aload 19
      // 184: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 187: getfield net/minecraft/util/Vec3.zCoord D
      // 18a: aload 6
      // 18c: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 18f: i2d
      // 190: ldc2_w 0.5
      // 193: dadd
      // 194: dsub
      // 195: aload 19
      // 197: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 19a: getfield net/minecraft/util/Vec3.xCoord D
      // 19d: aload 6
      // 19f: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 1a2: i2d
      // 1a3: ldc2_w 0.5
      // 1a6: dadd
      // 1a7: dsub
      // 1a8: invokestatic java/lang/Math.hypot (DD)D
      // 1ab: ldc2_w 15.0
      // 1ae: dmul
      // 1af: dstore 23
      // 1b1: ifne 1da
      // 1b4: dload 21
      // 1b6: dload 23
      // 1b8: dadd
      // 1b9: dstore 21
      // 1bb: dload 21
      // 1bd: dload 12
      // 1bf: dcmpg
      // 1c0: ifge 1d2
      // 1c3: dload 21
      // 1c5: dstore 12
      // 1c7: aload 19
      // 1c9: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 1cc: astore 14
      // 1ce: aload 20
      // 1d0: astore 15
      // 1d2: fload 17
      // 1d4: ldc_w 0.1
      // 1d7: fadd
      // 1d8: fstore 17
      // 1da: iload 3
      // 1db: ifeq 0b4
      // 1de: fload 16
      // 1e0: ldc_w 0.1
      // 1e3: fadd
      // 1e4: fstore 16
      // 1e6: iload 3
      // 1e7: ifeq 0a2
      // 1ea: aload 14
      // 1ec: ifnull 1f8
      // 1ef: aload 15
      // 1f1: ifnonnull 1fa
      // 1f4: goto 1f8
      // 1f7: athrow
      // 1f8: bipush 1
      // 1f9: ireturn
      // 1fa: aload 0
      // 1fb: iload 5
      // 1fd: invokevirtual x/ocebf5c047db.ȩ (I)V
      // 200: aload 0
      // 201: iload 3
      // 202: ifne 21c
      // 205: aload 7
      // 207: invokevirtual x/ocebf5c047db.Ѝ (Lnet/minecraft/block/state/IBlockState;)Z
      // 20a: ifeq 21b
      // 20d: goto 211
      // 210: athrow
      // 211: aload 4
      // 213: bipush 1
      // 214: invokevirtual net/minecraft/client/entity/EntityPlayerSP.setSneaking (Z)V
      // 217: goto 21b
      // 21a: athrow
      // 21b: aload 0
      // 21c: iload 3
      // 21d: ifne 231
      // 220: aload 1
      // 221: aload 15
      // 223: invokevirtual x/ocebf5c047db.Ю (Lx/oc86de9e2892;[F)Z
      // 226: ifne 230
      // 229: goto 22d
      // 22c: athrow
      // 22d: bipush 1
      // 22e: ireturn
      // 22f: athrow
      // 230: aload 0
      // 231: ldc2_w 8.0
      // 234: aload 0
      // 235: aload 1
      // 236: invokevirtual x/ocebf5c047db.Ư (Lx/oc86de9e2892;)F
      // 239: aload 0
      // 23a: aload 1
      // 23b: invokevirtual x/ocebf5c047db.Z (Lx/oc86de9e2892;)F
      // 23e: invokevirtual x/ocebf5c047db.Է (DFF)Lnet/minecraft/util/MovingObjectPosition;
      // 241: astore 16
      // 243: aload 16
      // 245: iload 3
      // 246: ifne 252
      // 249: ifnull 263
      // 24c: goto 250
      // 24f: athrow
      // 250: aload 16
      // 252: iload 3
      // 253: ifne 268
      // 256: getfield net/minecraft/util/MovingObjectPosition.sideHit Lnet/minecraft/util/EnumFacing;
      // 259: getstatic net/minecraft/util/EnumFacing.UP Lnet/minecraft/util/EnumFacing;
      // 25c: if_acmpeq 266
      // 25f: goto 263
      // 262: athrow
      // 263: bipush 1
      // 264: ireturn
      // 265: athrow
      // 266: aload 16
      // 268: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 26b: invokevirtual net/minecraft/util/BlockPos.up ()Lnet/minecraft/util/BlockPos;
      // 26e: astore 17
      // 270: new net/minecraft/util/AxisAlignedBB
      // 273: dup
      // 274: aload 17
      // 276: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 279: i2d
      // 27a: aload 17
      // 27c: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 27f: i2d
      // 280: aload 17
      // 282: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 285: i2d
      // 286: aload 17
      // 288: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 28b: i2d
      // 28c: dconst_1
      // 28d: dadd
      // 28e: aload 17
      // 290: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 293: i2d
      // 294: dconst_1
      // 295: dadd
      // 296: aload 17
      // 298: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 29b: i2d
      // 29c: dconst_1
      // 29d: dadd
      // 29e: invokespecial net/minecraft/util/AxisAlignedBB.<init> (DDDDDD)V
      // 2a1: astore 18
      // 2a3: aload 2
      // 2a4: invokevirtual x/oce673b272fb.Ě ()Lnet/minecraft/util/AxisAlignedBB;
      // 2a7: aload 18
      // 2a9: invokevirtual net/minecraft/util/AxisAlignedBB.intersectsWith (Lnet/minecraft/util/AxisAlignedBB;)Z
      // 2ac: iload 3
      // 2ad: ifne 2d2
      // 2b0: ifne 2ba
      // 2b3: goto 2b7
      // 2b6: athrow
      // 2b7: bipush 1
      // 2b8: ireturn
      // 2b9: athrow
      // 2ba: aload 0
      // 2bb: getfield x/oca897d4a197.ω Lnet/minecraft/client/Minecraft;
      // 2be: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 2c1: aload 4
      // 2c3: aload 0
      // 2c4: getfield x/oca897d4a197.ω Lnet/minecraft/client/Minecraft;
      // 2c7: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 2ca: aload 4
      // 2cc: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 2cf: invokevirtual net/minecraft/client/multiplayer/PlayerControllerMP.sendUseItem (Lnet/minecraft/entity/player/EntityPlayer;Lnet/minecraft/world/World;Lnet/minecraft/item/ItemStack;)Z
      // 2d2: iload 3
      // 2d3: ifne 2f7
      // 2d6: ifeq 2f6
      // 2d9: goto 2dd
      // 2dc: athrow
      // 2dd: aload 0
      // 2de: bipush 1
      // 2df: putfield x/ocebf5c047db.Ȣ Z
      // 2e2: aload 0
      // 2e3: bipush 1
      // 2e4: putfield x/ocebf5c047db.Ι Z
      // 2e7: aload 0
      // 2e8: aload 17
      // 2ea: putfield x/ocebf5c047db.ѥ Lnet/minecraft/util/BlockPos;
      // 2ed: aload 0
      // 2ee: bipush 0
      // 2ef: putfield x/ocebf5c047db.Ŝ I
      // 2f2: goto 2f6
      // 2f5: athrow
      // 2f6: bipush 1
      // 2f7: ireturn
   }

   private boolean ѩ(oc86de9e2892 param1, oce673b272fb param2, boolean param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oca897d4a197.Է Z
      // 003: aload 0
      // 004: getfield x/oca897d4a197.ω Lnet/minecraft/client/Minecraft;
      // 007: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 00a: astore 5
      // 00c: istore 4
      // 00e: aload 0
      // 00f: invokevirtual x/ocebf5c047db.բ ()I
      // 012: istore 6
      // 014: iload 6
      // 016: iload 4
      // 018: ifne 028
      // 01b: bipush -1
      // 01c: if_icmpne 029
      // 01f: goto 023
      // 022: athrow
      // 023: bipush 0
      // 024: goto 028
      // 027: athrow
      // 028: ireturn
      // 029: new java/util/ArrayList
      // 02c: dup
      // 02d: invokespecial java/util/ArrayList.<init> ()V
      // 030: astore 7
      // 032: bipush -1
      // 033: istore 8
      // 035: iload 8
      // 037: bipush 1
      // 038: if_icmpgt 1c3
      // 03b: iload 4
      // 03d: ifne 1d8
      // 040: bipush -1
      // 041: istore 9
      // 043: iload 9
      // 045: bipush 1
      // 046: if_icmpgt 1bb
      // 049: new net/minecraft/util/BlockPos
      // 04c: dup
      // 04d: aload 2
      // 04e: invokevirtual x/oce673b272fb.Ϡ ()D
      // 051: iload 8
      // 053: i2d
      // 054: dadd
      // 055: aload 2
      // 056: invokevirtual x/oce673b272fb.Ƶ ()D
      // 059: aload 2
      // 05a: invokevirtual x/oce673b272fb.Õ ()D
      // 05d: iload 9
      // 05f: i2d
      // 060: dadd
      // 061: invokespecial net/minecraft/util/BlockPos.<init> (DDD)V
      // 064: astore 10
      // 066: iload 4
      // 068: ifne 1be
      // 06b: new net/minecraft/util/AxisAlignedBB
      // 06e: dup
      // 06f: aload 10
      // 071: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 074: i2d
      // 075: aload 10
      // 077: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 07a: i2d
      // 07b: aload 10
      // 07d: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 080: i2d
      // 081: aload 10
      // 083: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 086: i2d
      // 087: dconst_1
      // 088: dadd
      // 089: aload 10
      // 08b: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 08e: i2d
      // 08f: dconst_1
      // 090: dadd
      // 091: aload 10
      // 093: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 096: i2d
      // 097: dconst_1
      // 098: dadd
      // 099: invokespecial net/minecraft/util/AxisAlignedBB.<init> (DDDDDD)V
      // 09c: astore 11
      // 09e: aload 11
      // 0a0: aload 2
      // 0a1: invokevirtual x/oce673b272fb.Ě ()Lnet/minecraft/util/AxisAlignedBB;
      // 0a4: invokevirtual net/minecraft/util/AxisAlignedBB.intersectsWith (Lnet/minecraft/util/AxisAlignedBB;)Z
      // 0a7: ifne 0b3
      // 0aa: iload 4
      // 0ac: ifeq 1b3
      // 0af: goto 0b3
      // 0b2: athrow
      // 0b3: aload 10
      // 0b5: invokevirtual net/minecraft/util/BlockPos.down ()Lnet/minecraft/util/BlockPos;
      // 0b8: astore 12
      // 0ba: iload 4
      // 0bc: ifne 1b6
      // 0bf: aload 12
      // 0c1: invokestatic x/occb1ed1ed8f.ϛ (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/Block;
      // 0c4: aload 0
      // 0c5: goto 0c9
      // 0c8: athrow
      // 0c9: getfield x/oca897d4a197.ω Lnet/minecraft/client/Minecraft;
      // 0cc: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 0cf: aload 12
      // 0d1: invokevirtual net/minecraft/block/Block.isReplaceable (Lnet/minecraft/world/World;Lnet/minecraft/util/BlockPos;)Z
      // 0d4: ifne 1b3
      // 0d7: aload 10
      // 0d9: invokestatic x/occb1ed1ed8f.ϛ (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/Block;
      // 0dc: aload 0
      // 0dd: getfield x/oca897d4a197.ω Lnet/minecraft/client/Minecraft;
      // 0e0: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 0e3: aload 10
      // 0e5: invokevirtual net/minecraft/block/Block.isReplaceable (Lnet/minecraft/world/World;Lnet/minecraft/util/BlockPos;)Z
      // 0e8: iload 4
      // 0ea: ifne 108
      // 0ed: ifne 0fd
      // 0f0: goto 0f4
      // 0f3: athrow
      // 0f4: iload 4
      // 0f6: ifeq 1b3
      // 0f9: goto 0fd
      // 0fc: athrow
      // 0fd: ldc_w -318507790
      // 100: ldc_w -318507786
      // 103: ixor
      // 104: goto 108
      // 107: athrow
      // 108: anewarray 411
      // 10b: dup
      // 10c: bipush 0
      // 10d: getstatic net/minecraft/util/EnumFacing.SOUTH Lnet/minecraft/util/EnumFacing;
      // 110: aastore
      // 111: dup
      // 112: bipush 1
      // 113: getstatic net/minecraft/util/EnumFacing.WEST Lnet/minecraft/util/EnumFacing;
      // 116: aastore
      // 117: dup
      // 118: ldc_w -318507788
      // 11b: ldc_w -318507786
      // 11e: ixor
      // 11f: getstatic net/minecraft/util/EnumFacing.NORTH Lnet/minecraft/util/EnumFacing;
      // 122: aastore
      // 123: dup
      // 124: ldc_w -318507787
      // 127: ldc_w -318507786
      // 12a: ixor
      // 12b: getstatic net/minecraft/util/EnumFacing.EAST Lnet/minecraft/util/EnumFacing;
      // 12e: aastore
      // 12f: astore 13
      // 131: aload 13
      // 133: arraylength
      // 134: istore 14
      // 136: bipush 0
      // 137: istore 15
      // 139: iload 15
      // 13b: iload 14
      // 13d: if_icmpge 1b3
      // 140: aload 13
      // 142: iload 15
      // 144: aaload
      // 145: astore 16
      // 147: aload 10
      // 149: aload 16
      // 14b: invokevirtual net/minecraft/util/BlockPos.offset (Lnet/minecraft/util/EnumFacing;)Lnet/minecraft/util/BlockPos;
      // 14e: astore 17
      // 150: aload 17
      // 152: invokestatic x/occb1ed1ed8f.ϛ (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/Block;
      // 155: aload 0
      // 156: iload 4
      // 158: ifne 0c9
      // 15b: getfield x/oca897d4a197.ω Lnet/minecraft/client/Minecraft;
      // 15e: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 161: aload 17
      // 163: invokevirtual net/minecraft/block/Block.isReplaceable (Lnet/minecraft/world/World;Lnet/minecraft/util/BlockPos;)Z
      // 166: iload 4
      // 168: ifne 19b
      // 16b: ifne 196
      // 16e: goto 172
      // 171: athrow
      // 172: aload 7
      // 174: aload 12
      // 176: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 17b: iload 4
      // 17d: ifne 19b
      // 180: goto 184
      // 183: athrow
      // 184: pop
      // 185: iload 3
      // 186: ifne 196
      // 189: goto 18d
      // 18c: athrow
      // 18d: iload 4
      // 18f: ifeq 1b3
      // 192: goto 196
      // 195: athrow
      // 196: iload 3
      // 197: goto 19b
      // 19a: athrow
      // 19b: ifeq 1a7
      // 19e: iload 4
      // 1a0: ifeq 1b3
      // 1a3: goto 1a7
      // 1a6: athrow
      // 1a7: iinc 15 1
      // 1aa: iload 4
      // 1ac: ifeq 139
      // 1af: goto 1b3
      // 1b2: athrow
      // 1b3: iinc 9 1
      // 1b6: iload 4
      // 1b8: ifeq 043
      // 1bb: iinc 8 1
      // 1be: iload 4
      // 1c0: ifeq 035
      // 1c3: aload 7
      // 1c5: invokeinterface java/util/List.isEmpty ()Z 1
      // 1ca: iload 4
      // 1cc: ifne 1d7
      // 1cf: ifeq 1d8
      // 1d2: goto 1d6
      // 1d5: athrow
      // 1d6: bipush 0
      // 1d7: ireturn
      // 1d8: aload 5
      // 1da: fconst_1
      // 1db: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 1de: astore 8
      // 1e0: ldc2_w 1.7976931348623157E308
      // 1e3: dstore 9
      // 1e5: aconst_null
      // 1e6: astore 11
      // 1e8: aconst_null
      // 1e9: astore 12
      // 1eb: aconst_null
      // 1ec: astore 13
      // 1ee: aconst_null
      // 1ef: astore 14
      // 1f1: aload 7
      // 1f3: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 1f8: astore 15
      // 1fa: aload 15
      // 1fc: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 201: ifeq 3c2
      // 204: aload 15
      // 206: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 20b: checkcast net/minecraft/util/BlockPos
      // 20e: astore 16
      // 210: iload 4
      // 212: ifne 3d9
      // 215: aload 0
      // 216: getfield x/oca897d4a197.ω Lnet/minecraft/client/Minecraft;
      // 219: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 21c: aload 16
      // 21e: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 221: astore 17
      // 223: aload 17
      // 225: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 22a: aload 0
      // 22b: getfield x/oca897d4a197.ω Lnet/minecraft/client/Minecraft;
      // 22e: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 231: aload 16
      // 233: aload 17
      // 235: invokevirtual net/minecraft/block/Block.getCollisionBoundingBox (Lnet/minecraft/world/World;Lnet/minecraft/util/BlockPos;Lnet/minecraft/block/state/IBlockState;)Lnet/minecraft/util/AxisAlignedBB;
      // 238: astore 18
      // 23a: aload 18
      // 23c: iload 4
      // 23e: ifne 24a
      // 241: ifnull 254
      // 244: goto 248
      // 247: athrow
      // 248: aload 18
      // 24a: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 24d: ldc2_w 0.1
      // 250: dsub
      // 251: goto 25e
      // 254: aload 16
      // 256: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 259: i2d
      // 25a: ldc2_w 0.9
      // 25d: dadd
      // 25e: dstore 19
      // 260: ldc_w 0.05
      // 263: fstore 21
      // 265: fload 21
      // 267: ldc_w 0.95
      // 26a: fcmpg
      // 26b: ifgt 3bd
      // 26e: iload 4
      // 270: ifne 1fa
      // 273: ldc_w 0.05
      // 276: fstore 22
      // 278: fload 22
      // 27a: ldc_w 0.95
      // 27d: fcmpg
      // 27e: ifgt 3b0
      // 281: new net/minecraft/util/Vec3
      // 284: dup
      // 285: aload 16
      // 287: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 28a: i2f
      // 28b: fload 21
      // 28d: fadd
      // 28e: f2d
      // 28f: dload 19
      // 291: aload 16
      // 293: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 296: i2f
      // 297: fload 22
      // 299: fadd
      // 29a: f2d
      // 29b: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 29e: astore 23
      // 2a0: aload 0
      // 2a1: iload 4
      // 2a3: ifne 3eb
      // 2a6: getfield x/oca897d4a197.ω Lnet/minecraft/client/Minecraft;
      // 2a9: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 2ac: aload 8
      // 2ae: aload 23
      // 2b0: invokevirtual net/minecraft/client/multiplayer/WorldClient.rayTraceBlocks (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/MovingObjectPosition;
      // 2b3: astore 24
      // 2b5: iload 4
      // 2b7: ifne 3ab
      // 2ba: aload 24
      // 2bc: ifnull 3a3
      // 2bf: goto 2c3
      // 2c2: athrow
      // 2c3: aload 24
      // 2c5: iload 4
      // 2c7: ifne 2e1
      // 2ca: goto 2ce
      // 2cd: athrow
      // 2ce: getfield net/minecraft/util/MovingObjectPosition.typeOfHit Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 2d1: getstatic net/minecraft/util/MovingObjectPosition$MovingObjectType.BLOCK Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 2d4: if_acmpne 3a3
      // 2d7: goto 2db
      // 2da: athrow
      // 2db: aload 24
      // 2dd: goto 2e1
      // 2e0: athrow
      // 2e1: getfield net/minecraft/util/MovingObjectPosition.sideHit Lnet/minecraft/util/EnumFacing;
      // 2e4: getstatic net/minecraft/util/EnumFacing.UP Lnet/minecraft/util/EnumFacing;
      // 2e7: if_acmpne 3a3
      // 2ea: aload 16
      // 2ec: aload 24
      // 2ee: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 2f1: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 2f4: ifne 304
      // 2f7: goto 2fb
      // 2fa: athrow
      // 2fb: iload 4
      // 2fd: ifeq 3a3
      // 300: goto 304
      // 303: athrow
      // 304: aload 8
      // 306: aload 24
      // 308: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 30b: getfield net/minecraft/util/Vec3.xCoord D
      // 30e: aload 24
      // 310: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 313: getfield net/minecraft/util/Vec3.yCoord D
      // 316: aload 24
      // 318: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 31b: getfield net/minecraft/util/Vec3.zCoord D
      // 31e: invokestatic x/oc75d51ec7eb.ӆ (Lnet/minecraft/util/Vec3;DDD)[F
      // 321: astore 25
      // 323: aload 25
      // 325: bipush 0
      // 326: faload
      // 327: aload 0
      // 328: aload 1
      // 329: invokevirtual x/ocebf5c047db.Ư (Lx/oc86de9e2892;)F
      // 32c: fsub
      // 32d: iload 4
      // 32f: ifne 3a9
      // 332: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_float (F)F
      // 335: invokestatic java/lang/Math.abs (F)F
      // 338: f2d
      // 339: ldc2_w 3.0
      // 33c: dmul
      // 33d: aload 25
      // 33f: bipush 1
      // 340: faload
      // 341: aload 0
      // 342: aload 1
      // 343: invokevirtual x/ocebf5c047db.Z (Lx/oc86de9e2892;)F
      // 346: fsub
      // 347: invokestatic java/lang/Math.abs (F)F
      // 34a: f2d
      // 34b: dadd
      // 34c: dstore 26
      // 34e: aload 24
      // 350: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 353: getfield net/minecraft/util/Vec3.zCoord D
      // 356: aload 16
      // 358: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 35b: i2d
      // 35c: ldc2_w 0.5
      // 35f: dadd
      // 360: dsub
      // 361: aload 24
      // 363: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 366: getfield net/minecraft/util/Vec3.xCoord D
      // 369: aload 16
      // 36b: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 36e: i2d
      // 36f: ldc2_w 0.5
      // 372: dadd
      // 373: dsub
      // 374: invokestatic java/lang/Math.hypot (DD)D
      // 377: ldc2_w 15.0
      // 37a: dmul
      // 37b: dstore 28
      // 37d: dload 26
      // 37f: dload 28
      // 381: dadd
      // 382: dstore 26
      // 384: dload 26
      // 386: dload 9
      // 388: dcmpg
      // 389: ifge 3a3
      // 38c: dload 26
      // 38e: dstore 9
      // 390: aload 24
      // 392: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 395: astore 11
      // 397: aload 25
      // 399: astore 14
      // 39b: aload 16
      // 39d: astore 12
      // 39f: aload 17
      // 3a1: astore 13
      // 3a3: fload 22
      // 3a5: ldc_w 0.1
      // 3a8: fadd
      // 3a9: fstore 22
      // 3ab: iload 4
      // 3ad: ifeq 278
      // 3b0: fload 21
      // 3b2: ldc_w 0.1
      // 3b5: fadd
      // 3b6: fstore 21
      // 3b8: iload 4
      // 3ba: ifeq 265
      // 3bd: iload 4
      // 3bf: ifeq 1fa
      // 3c2: aload 11
      // 3c4: ifnull 3d9
      // 3c7: aload 12
      // 3c9: ifnull 3d9
      // 3cc: goto 3d0
      // 3cf: athrow
      // 3d0: aload 14
      // 3d2: ifnonnull 3db
      // 3d5: goto 3d9
      // 3d8: athrow
      // 3d9: bipush 1
      // 3da: ireturn
      // 3db: aload 0
      // 3dc: iload 4
      // 3de: ifne 3fe
      // 3e1: iload 6
      // 3e3: invokevirtual x/ocebf5c047db.ȩ (I)V
      // 3e6: aload 0
      // 3e7: goto 3eb
      // 3ea: athrow
      // 3eb: aload 13
      // 3ed: invokevirtual x/ocebf5c047db.Ѝ (Lnet/minecraft/block/state/IBlockState;)Z
      // 3f0: ifeq 3fd
      // 3f3: aload 5
      // 3f5: bipush 1
      // 3f6: invokevirtual net/minecraft/client/entity/EntityPlayerSP.setSneaking (Z)V
      // 3f9: goto 3fd
      // 3fc: athrow
      // 3fd: aload 0
      // 3fe: iload 4
      // 400: ifne 414
      // 403: aload 1
      // 404: aload 14
      // 406: invokevirtual x/ocebf5c047db.Ю (Lx/oc86de9e2892;[F)Z
      // 409: ifne 413
      // 40c: goto 410
      // 40f: athrow
      // 410: bipush 1
      // 411: ireturn
      // 412: athrow
      // 413: aload 0
      // 414: aload 0
      // 415: invokevirtual x/ocebf5c047db.л ()F
      // 418: f2d
      // 419: aload 0
      // 41a: aload 1
      // 41b: invokevirtual x/ocebf5c047db.Ư (Lx/oc86de9e2892;)F
      // 41e: aload 0
      // 41f: aload 1
      // 420: invokevirtual x/ocebf5c047db.Z (Lx/oc86de9e2892;)F
      // 423: invokevirtual x/ocebf5c047db.Է (DFF)Lnet/minecraft/util/MovingObjectPosition;
      // 426: astore 15
      // 428: aload 15
      // 42a: iload 4
      // 42c: ifne 438
      // 42f: ifnull 45b
      // 432: goto 436
      // 435: athrow
      // 436: aload 15
      // 438: getfield net/minecraft/util/MovingObjectPosition.sideHit Lnet/minecraft/util/EnumFacing;
      // 43b: getstatic net/minecraft/util/EnumFacing.UP Lnet/minecraft/util/EnumFacing;
      // 43e: if_acmpne 45b
      // 441: aload 12
      // 443: aload 15
      // 445: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 448: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 44b: iload 4
      // 44d: ifne 480
      // 450: goto 454
      // 453: athrow
      // 454: ifne 45e
      // 457: goto 45b
      // 45a: athrow
      // 45b: bipush 1
      // 45c: ireturn
      // 45d: athrow
      // 45e: aload 0
      // 45f: getfield x/oca897d4a197.ω Lnet/minecraft/client/Minecraft;
      // 462: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 465: aload 5
      // 467: aload 0
      // 468: getfield x/oca897d4a197.ω Lnet/minecraft/client/Minecraft;
      // 46b: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 46e: aload 5
      // 470: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 473: aload 12
      // 475: getstatic net/minecraft/util/EnumFacing.UP Lnet/minecraft/util/EnumFacing;
      // 478: aload 15
      // 47a: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 47d: invokevirtual net/minecraft/client/multiplayer/PlayerControllerMP.onPlayerRightClick (Lnet/minecraft/client/entity/EntityPlayerSP;Lnet/minecraft/client/multiplayer/WorldClient;Lnet/minecraft/item/ItemStack;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;Lnet/minecraft/util/Vec3;)Z
      // 480: iload 4
      // 482: ifne 49b
      // 485: ifeq 49a
      // 488: goto 48c
      // 48b: athrow
      // 48c: aload 0
      // 48d: bipush 1
      // 48e: putfield x/ocebf5c047db.Ȣ Z
      // 491: aload 0
      // 492: bipush 0
      // 493: putfield x/ocebf5c047db.Ŝ I
      // 496: goto 49a
      // 499: athrow
      // 49a: bipush 1
      // 49b: ireturn
   }

   private boolean Ю(oc86de9e2892 var1, float[] var2) {
      float[] var10000 = new float[-344081575 ^ -344081573];
      var10000[0] = this.Ư(var1);
      var10000[1] = this.Z(var1);
      float[] var3 = var10000;
      float[] var4 = oc75d51ec7eb.ӈ(var3, var2, this.Ǽ());
      return var1.Ǎ(super.ä, -344081745 ^ -344081573, var4[0], var4[1], false);
   }

   private MovingObjectPosition Է(double var1, float var3, float var4) {
      Vec3 var5 = super.ω.thePlayer.getPositionEyes(1.0F);
      Vec3 var6 = oc7ab2161b9f.ҵ(var3, var4);
      Vec3 var7 = var5.addVector(var6.xCoord * var1, var6.yCoord * var1, var6.zCoord * var1);
      return super.ω.theWorld.rayTraceBlocks(var5, var7, false, true, false);
   }

   private float Ư(oc86de9e2892 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oca897d4a197.Է Z
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 22
      // 09: getfield x/oc86de9e2892.Ӝ Ljava/lang/Float;
      // 0c: ifnonnull 21
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: getfield x/oca897d4a197.ω Lnet/minecraft/client/Minecraft;
      // 17: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1a: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 1d: goto 28
      // 20: athrow
      // 21: aload 1
      // 22: getfield x/oc86de9e2892.Ӝ Ljava/lang/Float;
      // 25: invokevirtual java/lang/Float.floatValue ()F
      // 28: freturn
   }

   private float Z(oc86de9e2892 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oca897d4a197.Է Z
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 22
      // 09: getfield x/oc86de9e2892.ŷ Ljava/lang/Float;
      // 0c: ifnonnull 21
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: getfield x/oca897d4a197.ω Lnet/minecraft/client/Minecraft;
      // 17: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1a: getfield net/minecraft/client/entity/EntityPlayerSP.rotationPitch F
      // 1d: goto 28
      // 20: athrow
      // 21: aload 1
      // 22: getfield x/oc86de9e2892.ŷ Ljava/lang/Float;
      // 25: invokevirtual java/lang/Float.floatValue ()F
      // 28: freturn
   }

   private float л() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oca897d4a197.Է Z
      // 03: istore 1
      // 04: aload 0
      // 05: getfield x/oca897d4a197.ω Lnet/minecraft/client/Minecraft;
      // 08: iload 1
      // 09: ifne 21
      // 0c: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 0f: ifnonnull 1d
      // 12: goto 16
      // 15: athrow
      // 16: ldc_w 4.5
      // 19: goto 27
      // 1c: athrow
      // 1d: aload 0
      // 1e: getfield x/oca897d4a197.ω Lnet/minecraft/client/Minecraft;
      // 21: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 24: invokevirtual net/minecraft/client/multiplayer/PlayerControllerMP.getBlockReachDistance ()F
      // 27: freturn
   }

   private float Ǽ() {
      return (float)Math.pow(this.ǰ.Ӂ() / 10.0, 1.5) * 180.0F;
   }

   private int բ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oca897d4a197.Է Z
      // 03: bipush 0
      // 04: istore 2
      // 05: istore 1
      // 06: iload 2
      // 07: ldc_w -1261770071
      // 0a: ldc_w -1261770080
      // 0d: ixor
      // 0e: if_icmpge 60
      // 11: aload 0
      // 12: getfield x/oca897d4a197.ω Lnet/minecraft/client/Minecraft;
      // 15: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 18: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 1b: iload 2
      // 1c: invokevirtual net/minecraft/entity/player/InventoryPlayer.getStackInSlot (I)Lnet/minecraft/item/ItemStack;
      // 1f: astore 3
      // 20: iload 1
      // 21: ifne 5c
      // 24: aload 3
      // 25: ifnull 59
      // 28: goto 2c
      // 2b: athrow
      // 2c: aload 3
      // 2d: iload 1
      // 2e: ifne 47
      // 31: goto 35
      // 34: athrow
      // 35: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 38: instanceof net/minecraft/item/ItemBlock
      // 3b: ifeq 59
      // 3e: goto 42
      // 41: athrow
      // 42: aload 3
      // 43: goto 47
      // 46: athrow
      // 47: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 4a: checkcast net/minecraft/item/ItemBlock
      // 4d: invokevirtual net/minecraft/item/ItemBlock.getBlock ()Lnet/minecraft/block/Block;
      // 50: getstatic net/minecraft/init/Blocks.ladder Lnet/minecraft/block/Block;
      // 53: if_acmpne 59
      // 56: iload 2
      // 57: ireturn
      // 58: athrow
      // 59: iinc 2 1
      // 5c: iload 1
      // 5d: ifeq 06
      // 60: bipush -1
      // 61: ireturn
   }

   private int ų(boolean param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: getstatic x/oca897d4a197.Է Z
      // 03: bipush 0
      // 04: istore 3
      // 05: istore 2
      // 06: iload 3
      // 07: ldc_w -562474680
      // 0a: ldc_w -562474687
      // 0d: ixor
      // 0e: if_icmpge 6e
      // 11: aload 0
      // 12: getfield x/oca897d4a197.ω Lnet/minecraft/client/Minecraft;
      // 15: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 18: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 1b: iload 3
      // 1c: invokevirtual net/minecraft/entity/player/InventoryPlayer.getStackInSlot (I)Lnet/minecraft/item/ItemStack;
      // 1f: astore 4
      // 21: aload 4
      // 23: ifnonnull 2e
      // 26: iload 2
      // 27: ifeq 67
      // 2a: goto 2e
      // 2d: athrow
      // 2e: iload 1
      // 2f: iload 2
      // 30: ifne 52
      // 33: goto 37
      // 36: athrow
      // 37: ifeq 4d
      // 3a: goto 3e
      // 3d: athrow
      // 3e: aload 4
      // 40: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 43: getstatic net/minecraft/init/Items.water_bucket Lnet/minecraft/item/Item;
      // 46: if_acmpeq 64
      // 49: goto 4d
      // 4c: athrow
      // 4d: iload 1
      // 4e: goto 52
      // 51: athrow
      // 52: ifne 67
      // 55: aload 4
      // 57: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 5a: getstatic net/minecraft/init/Items.bucket Lnet/minecraft/item/Item;
      // 5d: if_acmpne 67
      // 60: goto 64
      // 63: athrow
      // 64: iload 3
      // 65: ireturn
      // 66: athrow
      // 67: iinc 3 1
      // 6a: iload 2
      // 6b: ifeq 06
      // 6e: bipush -1
      // 6f: ireturn
   }

   private void ȩ(int param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oca897d4a197.Է Z
      // 03: istore 2
      // 04: iload 1
      // 05: iload 2
      // 06: ifne 11
      // 09: iflt 40
      // 0c: goto 10
      // 0f: athrow
      // 10: iload 1
      // 11: iload 2
      // 12: ifne 3c
      // 15: ldc_w -274397226
      // 18: ldc_w -274397217
      // 1b: ixor
      // 1c: if_icmpge 40
      // 1f: goto 23
      // 22: athrow
      // 23: aload 0
      // 24: iload 2
      // 25: ifne 43
      // 28: goto 2c
      // 2b: athrow
      // 2c: getfield x/oca897d4a197.ω Lnet/minecraft/client/Minecraft;
      // 2f: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 32: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 35: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 38: goto 3c
      // 3b: athrow
      // 3c: iload 1
      // 3d: if_icmpne 42
      // 40: return
      // 41: athrow
      // 42: aload 0
      // 43: iload 2
      // 44: ifne 8c
      // 47: getfield x/ocebf5c047db.ю Lx/occ2f8dff8d8;
      // 4a: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 4d: ifeq 7d
      // 50: goto 54
      // 53: athrow
      // 54: aload 0
      // 55: iload 2
      // 56: ifne 8c
      // 59: goto 5d
      // 5c: athrow
      // 5d: getfield x/ocebf5c047db.ɟ I
      // 60: bipush -1
      // 61: if_icmpne 7d
      // 64: goto 68
      // 67: athrow
      // 68: aload 0
      // 69: aload 0
      // 6a: getfield x/oca897d4a197.ω Lnet/minecraft/client/Minecraft;
      // 6d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 70: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 73: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 76: putfield x/ocebf5c047db.ɟ I
      // 79: goto 7d
      // 7c: athrow
      // 7d: aload 0
      // 7e: getfield x/oca897d4a197.ω Lnet/minecraft/client/Minecraft;
      // 81: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 84: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 87: iload 1
      // 88: putfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 8b: aload 0
      // 8c: invokevirtual x/ocebf5c047db.θ ()V
      // 8f: return
   }

   private void ӡ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oca897d4a197.Է Z
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 94
      // 09: getfield x/ocebf5c047db.ɟ I
      // 0c: bipush -1
      // 0d: if_icmpeq 93
      // 10: goto 14
      // 13: athrow
      // 14: aload 0
      // 15: iload 1
      // 16: ifne 94
      // 19: goto 1d
      // 1c: athrow
      // 1d: getfield x/ocebf5c047db.ю Lx/occ2f8dff8d8;
      // 20: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 23: ifeq 93
      // 26: goto 2a
      // 29: athrow
      // 2a: aload 0
      // 2b: iload 1
      // 2c: ifne 94
      // 2f: goto 33
      // 32: athrow
      // 33: getfield x/oca897d4a197.ω Lnet/minecraft/client/Minecraft;
      // 36: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 39: ifnull 93
      // 3c: goto 40
      // 3f: athrow
      // 40: aload 0
      // 41: iload 1
      // 42: ifne 94
      // 45: goto 49
      // 48: athrow
      // 49: getfield x/ocebf5c047db.ɟ I
      // 4c: ldc_w -930862610
      // 4f: ldc_w -930862617
      // 52: ixor
      // 53: if_icmpge 93
      // 56: goto 5a
      // 59: athrow
      // 5a: aload 0
      // 5b: iload 1
      // 5c: ifne 94
      // 5f: goto 63
      // 62: athrow
      // 63: getfield x/oca897d4a197.ω Lnet/minecraft/client/Minecraft;
      // 66: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 69: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 6c: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 6f: aload 0
      // 70: getfield x/ocebf5c047db.ɟ I
      // 73: if_icmpeq 93
      // 76: goto 7a
      // 79: athrow
      // 7a: aload 0
      // 7b: getfield x/oca897d4a197.ω Lnet/minecraft/client/Minecraft;
      // 7e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 81: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 84: aload 0
      // 85: getfield x/ocebf5c047db.ɟ I
      // 88: putfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 8b: aload 0
      // 8c: invokevirtual x/ocebf5c047db.θ ()V
      // 8f: goto 93
      // 92: athrow
      // 93: aload 0
      // 94: bipush -1
      // 95: putfield x/ocebf5c047db.ɟ I
      // 98: return
   }

   private void θ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oca897d4a197.Է Z
      // 03: istore 1
      // 04: aload 0
      // 05: getfield x/oca897d4a197.ω Lnet/minecraft/client/Minecraft;
      // 08: iload 1
      // 09: ifne 21
      // 0c: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 0f: instanceof x/oc51cbcffcfe
      // 12: ifeq 29
      // 15: goto 19
      // 18: athrow
      // 19: aload 0
      // 1a: getfield x/oca897d4a197.ω Lnet/minecraft/client/Minecraft;
      // 1d: goto 21
      // 20: athrow
      // 21: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 24: invokeinterface x/oc51cbcffcfe.callSyncCurrentPlayItem ()V 1
      // 29: return
   }

   private void Ǜ(boolean param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oca897d4a197.Է Z
      // 03: istore 2
      // 04: iload 1
      // 05: iload 2
      // 06: ifne 13
      // 09: ifeq 22
      // 0c: goto 10
      // 0f: athrow
      // 10: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 13: ifeq 22
      // 16: aload 0
      // 17: invokevirtual x/ocebf5c047db.ӡ ()V
      // 1a: iload 2
      // 1b: ifeq 2b
      // 1e: goto 22
      // 21: athrow
      // 22: aload 0
      // 23: bipush -1
      // 24: putfield x/ocebf5c047db.ɟ I
      // 27: goto 2b
      // 2a: athrow
      // 2b: aload 0
      // 2c: invokevirtual x/ocebf5c047db.Ҏ ()V
      // 2f: aload 0
      // 30: bipush 0
      // 31: putfield x/ocebf5c047db.Ȣ Z
      // 34: aload 0
      // 35: bipush 0
      // 36: putfield x/ocebf5c047db.Қ I
      // 39: aload 0
      // 3a: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 3d: ifeq 4e
      // 40: aload 0
      // 41: getfield x/oca897d4a197.ω Lnet/minecraft/client/Minecraft;
      // 44: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 47: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // 4a: goto 4f
      // 4d: athrow
      // 4e: dconst_0
      // 4f: putfield x/ocebf5c047db.Ϛ D
      // 52: return
   }

   private void Ҏ() {
      this.Ι = false;
      this.ѥ = null;
      this.Ŝ = 0;
   }

   private boolean ѓ() {
      oc668fce0dbf var2 = null;
      int var3 = 1706949898 ^ -220840186;
      boolean var1 = oca897d4a197.Է;

      while (true) {
         switch (var3) {
            case -1754545652:
               var2 = (oc668fce0dbf)oc9755810e45.ʬ(oc668fce0dbf.class);

               label51: {
                  label50: {
                     try {
                        if (var1) {
                           break label51;
                        }

                        if (var2 == null) {
                           break label50;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var3 = -2112231686 ^ -220840186;
                     if (!var1) {
                        break;
                     }
                  }

                  var3 = -1897454083 ^ -220840186;
               }

               if (!var1) {
                  break;
               }
            case 1892669948:
               int var10000;
               label39: {
                  label38: {
                     try {
                        var10000 = var2.z$3rzb3dil7uydr();
                        if (var1) {
                           break label39;
                        }

                        if (var10000 == 0) {
                           break label38;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var3 = 502959801 ^ -220840186;
                     if (!var1) {
                        break;
                     }
                  }

                  var10000 = -1897454083 ^ -220840186;
               }

               var3 = var10000;
               if (!var1) {
                  break;
               }

               return true;
            case -282283585:
               return true;
            case 2083592955:
               return false;
            default:
               throw null;
         }
      }
   }

   private boolean Ѝ(IBlockState var1) {
      Block var3 = null;
      int var4 = 914349873 ^ -160256100;
      boolean var2 = oca897d4a197.Է;

      while (true) {
         label203:
         while (true) {
            label201:
            while (true) {
               label197:
               while (true) {
                  label195:
                  while (true) {
                     switch (var4) {
                        case -1774017757:
                           return false;
                        case -1670330712:
                           break label197;
                        case -1072861011:
                           break label201;
                        case -1036093901:
                           int var15;
                           label180: {
                              label179: {
                                 try {
                                    var15 = var3 instanceof BlockFenceGate;
                                    if (var2) {
                                       break label180;
                                    }

                                    if (var15 != 0) {
                                       break label179;
                                    }
                                 } catch (ocbde1165e4e var12) {
                                    throw var12;
                                 }

                                 var4 = -227547652 ^ -160256100;
                                 if (!var2) {
                                    continue;
                                 }
                              }

                              var15 = -1579676554 ^ -160256100;
                           }

                           var4 = var15;
                           if (!var2) {
                              continue;
                           }
                        case 69028448:
                           int var16;
                           label169: {
                              label168: {
                                 try {
                                    var16 = var3 instanceof BlockTrapDoor;
                                    if (var2) {
                                       break label169;
                                    }

                                    if (var16 != 0) {
                                       break label168;
                                    }
                                 } catch (ocbde1165e4e var11) {
                                    throw var11;
                                 }

                                 var4 = 747402221 ^ -160256100;
                                 if (!var2) {
                                    continue;
                                 }
                              }

                              var16 = -1579676554 ^ -160256100;
                           }

                           var4 = var16;
                           if (!var2) {
                              continue;
                           }
                           break;
                        case -757689565:
                           int var14;
                           label106: {
                              label105: {
                                 try {
                                    var14 = var3 instanceof BlockDoor;
                                    if (var2) {
                                       break label106;
                                    }

                                    if (var14 != 0) {
                                       break label105;
                                    }
                                 } catch (ocbde1165e4e var5) {
                                    throw var5;
                                 }

                                 var4 = 877451695 ^ -160256100;
                                 if (!var2) {
                                    continue;
                                 }
                              }

                              var14 = -1579676554 ^ -160256100;
                           }

                           var4 = var14;
                           if (var2) {
                              return false;
                           }
                           continue;
                        case -620831631:
                           break label203;
                        case -108529458:
                           break label195;
                        case 1470800874:
                           return true;
                        case 1785760567:
                           int var10000;
                           label160: {
                              label159: {
                                 try {
                                    var10000 = var3 instanceof BlockBed;
                                    if (var2) {
                                       break label160;
                                    }

                                    if (var10000 != 0) {
                                       break label159;
                                    }
                                 } catch (ocbde1165e4e var10) {
                                    throw var10;
                                 }

                                 var4 = 614743231 ^ -160256100;
                                 if (!var2) {
                                    continue;
                                 }
                              }

                              var10000 = -1579676554 ^ -160256100;
                           }

                           var4 = var10000;
                           if (!var2) {
                              continue;
                           }
                           break label195;
                        case 1847526403:
                           return false;
                        case 1951311188:
                           break;
                        default:
                           throw null;
                     }

                     int var17;
                     label148: {
                        label147: {
                           try {
                              var17 = var3 instanceof BlockAnvil;
                              if (var2) {
                                 break label148;
                              }

                              if (var17 != 0) {
                                 break label147;
                              }
                           } catch (ocbde1165e4e var9) {
                              throw var9;
                           }

                           var4 = -1677581141 ^ -160256100;
                           if (!var2) {
                              continue;
                           }
                        }

                        var17 = -1579676554 ^ -160256100;
                     }

                     var4 = var17;
                     if (var2) {
                        break label197;
                     }
                  }

                  int var13;
                  label139: {
                     label138: {
                        try {
                           var13 = var3 instanceof BlockWorkbench;
                           if (var2) {
                              break label139;
                           }

                           if (var13 != 0) {
                              break label138;
                           }
                        } catch (ocbde1165e4e var8) {
                           throw var8;
                        }

                        var4 = -2109994296 ^ -160256100;
                        if (!var2) {
                           continue;
                        }
                     }

                     var13 = -1579676554 ^ -160256100;
                  }

                  var4 = var13;
                  if (var2) {
                     break label201;
                  }
               }

               var3 = var1.getBlock();

               label124: {
                  label123: {
                     try {
                        if (var2) {
                           break label124;
                        }

                        if (var3 instanceof BlockContainer) {
                           break label123;
                        }
                     } catch (ocbde1165e4e var7) {
                        throw var7;
                     }

                     var4 = 267736914 ^ -160256100;
                     if (!var2) {
                        continue;
                     }
                  }

                  var4 = -1579676554 ^ -160256100;
               }

               if (var2) {
                  return false;
               }
            }

            if (var1 == null) {
               var4 = 1613761727 ^ -160256100;
               if (!var2) {
                  continue;
               }
            }

            var4 = 1778542900 ^ -160256100;
            if (var2) {
               break;
            }
         }

         int var18;
         label115: {
            label114: {
               try {
                  var18 = var3 instanceof BlockEnchantmentTable;
                  if (var2) {
                     break label115;
                  }

                  if (var18 == 0) {
                     break label114;
                  }
               } catch (ocbde1165e4e var6) {
                  throw var6;
               }

               var4 = -1579676554 ^ -160256100;
               if (!var2) {
                  continue;
               }
            }

            var18 = -1737643105 ^ -160256100;
         }

         var4 = var18;
      }
   }
}

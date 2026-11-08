package x;

public class oc7e673dd779 extends oc69da1aa7f5 {
   private static final occc831eff22 J = new occc831eff22("Condition");
   public static oca9cc61aada ҡ;
   public static oca9cc61aada Ñ;
   public static occ2f8dff8d8 ѝ;
   public static occ2f8dff8d8 Ĕ;
   public static occ2f8dff8d8 ɺ;
   public static occ2f8dff8d8 Ȧ;
   public static boolean ѫ;

   public oc7e673dd779() {
      super("Reach", oce4cea752dd.ȁ, 0);
      this.ą("Extends the distance at which you can hit entities.");
      this.ʌ(ҡ = new oca9cc61aada("Min", 3.1, 3.0, 6.0, 0.05));
      this.ʌ(Ñ = new oca9cc61aada("Max", 3.3, 3.0, 6.0, 0.05));
      this.ʌ(J);
      this.ʌ(ѝ = new occ2f8dff8d8(J, "Weapon only", false));
      this.ʌ(Ĕ = new occ2f8dff8d8(J, "Moving only", false));
      this.ʌ(ɺ = new occ2f8dff8d8(J, "Sprint only", false));
      this.ʌ(Ȧ = new occ2f8dff8d8("Hit through blocks", false));
      this.ɮ = true;
   }

   @Override
   public void z$2u87utkr1isxg() {
      J.ȉ(true, this);
      oc7ab2161b9f.Ұ(ҡ, Ñ);
   }

   @oc66fa4f2195
   public void X(MouseEvent param1) {
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
      // 09: getfield x/MouseEvent.button I
      // 0c: iflt 38
      // 0f: goto 13
      // 12: athrow
      // 13: aload 1
      // 14: goto 18
      // 17: athrow
      // 18: getfield x/MouseEvent.buttonstate Z
      // 1b: iload 2
      // 1c: ifne 29
      // 1f: ifeq 38
      // 22: goto 26
      // 25: athrow
      // 26: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 29: iload 2
      // 2a: ifne 37
      // 2d: ifeq 38
      // 30: goto 34
      // 33: athrow
      // 34: invokestatic x/oc7e673dd779.Ҭ ()Z
      // 37: pop
      // 38: return
   }

   public static boolean Ҭ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc5e549848f3.İ I
      // 003: istore 0
      // 004: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 007: iload 0
      // 008: ifne 023
      // 00b: ifne 015
      // 00e: goto 012
      // 011: athrow
      // 012: bipush 0
      // 013: ireturn
      // 014: athrow
      // 015: getstatic x/oc7e673dd779.ѝ Lx/occ2f8dff8d8;
      // 018: iload 0
      // 019: ifne 03e
      // 01c: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 01f: goto 023
      // 022: athrow
      // 023: ifeq 03b
      // 026: invokestatic x/oc7ab2161b9f.Ȓ ()Z
      // 029: iload 0
      // 02a: ifne 049
      // 02d: goto 031
      // 030: athrow
      // 031: ifne 03b
      // 034: goto 038
      // 037: athrow
      // 038: bipush 0
      // 039: ireturn
      // 03a: athrow
      // 03b: getstatic x/oc7e673dd779.Ĕ Lx/occ2f8dff8d8;
      // 03e: iload 0
      // 03f: ifne 088
      // 042: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 045: goto 049
      // 048: athrow
      // 049: ifeq 085
      // 04c: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 04f: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 052: getfield net/minecraft/client/entity/EntityPlayerSP.moveForward F
      // 055: f2d
      // 056: dconst_0
      // 057: dcmpl
      // 058: iload 0
      // 059: ifne 093
      // 05c: goto 060
      // 05f: athrow
      // 060: ifne 085
      // 063: goto 067
      // 066: athrow
      // 067: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 06a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 06d: getfield net/minecraft/client/entity/EntityPlayerSP.moveStrafing F
      // 070: f2d
      // 071: dconst_0
      // 072: dcmpl
      // 073: iload 0
      // 074: ifne 093
      // 077: goto 07b
      // 07a: athrow
      // 07b: ifne 085
      // 07e: goto 082
      // 081: athrow
      // 082: bipush 0
      // 083: ireturn
      // 084: athrow
      // 085: getstatic x/oc7e673dd779.ɺ Lx/occ2f8dff8d8;
      // 088: iload 0
      // 089: ifne 0b4
      // 08c: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 08f: goto 093
      // 092: athrow
      // 093: ifeq 0b1
      // 096: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 099: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 09c: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isSprinting ()Z
      // 09f: iload 0
      // 0a0: ifne 0b7
      // 0a3: goto 0a7
      // 0a6: athrow
      // 0a7: ifne 0b1
      // 0aa: goto 0ae
      // 0ad: athrow
      // 0ae: bipush 0
      // 0af: ireturn
      // 0b0: athrow
      // 0b1: getstatic x/oc7e673dd779.Ȧ Lx/occ2f8dff8d8;
      // 0b4: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0b7: ifne 0fd
      // 0ba: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0bd: iload 0
      // 0be: ifne 0d6
      // 0c1: goto 0c5
      // 0c4: athrow
      // 0c5: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 0c8: ifnull 0fd
      // 0cb: goto 0cf
      // 0ce: athrow
      // 0cf: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0d2: goto 0d6
      // 0d5: athrow
      // 0d6: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 0d9: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 0dc: astore 1
      // 0dd: aload 1
      // 0de: ifnull 0fd
      // 0e1: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0e4: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 0e7: aload 1
      // 0e8: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 0eb: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 0f0: getstatic net/minecraft/init/Blocks.air Lnet/minecraft/block/Block;
      // 0f3: if_acmpeq 0fd
      // 0f6: goto 0fa
      // 0f9: athrow
      // 0fa: bipush 0
      // 0fb: ireturn
      // 0fc: athrow
      // 0fd: getstatic x/oc7e673dd779.ҡ Lx/oca9cc61aada;
      // 100: getstatic x/oc7e673dd779.Ñ Lx/oca9cc61aada;
      // 103: invokestatic x/oc7ab2161b9f.û ()Ljava/util/Random;
      // 106: invokestatic x/oc7ab2161b9f.Μ (Lx/oca9cc61aada;Lx/oca9cc61aada;Ljava/util/Random;)D
      // 109: dstore 1
      // 10a: dload 1
      // 10b: dconst_0
      // 10c: invokestatic x/oc7e673dd779.ʯ (DD)[Ljava/lang/Object;
      // 10f: astore 3
      // 110: aload 3
      // 111: iload 0
      // 112: ifne 122
      // 115: ifnonnull 11f
      // 118: goto 11c
      // 11b: athrow
      // 11c: bipush 0
      // 11d: ireturn
      // 11e: athrow
      // 11f: aload 3
      // 120: bipush 0
      // 121: aaload
      // 122: checkcast net/minecraft/entity/Entity
      // 125: astore 4
      // 127: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 12a: new net/minecraft/util/MovingObjectPosition
      // 12d: dup
      // 12e: aload 4
      // 130: aload 3
      // 131: bipush 1
      // 132: aaload
      // 133: checkcast net/minecraft/util/Vec3
      // 136: invokespecial net/minecraft/util/MovingObjectPosition.<init> (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/Vec3;)V
      // 139: putfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 13c: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 13f: aload 4
      // 141: putfield net/minecraft/client/Minecraft.pointedEntity Lnet/minecraft/entity/Entity;
      // 144: bipush 1
      // 145: ireturn
   }

   private static Object[] ʯ(double param0, double param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 4
      // 05: getstatic x/oc9755810e45.Ɖ Lx/oc7e673dd779;
      // 08: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 0b: iload 4
      // 0d: ifne 24
      // 10: ifne 32
      // 13: goto 17
      // 16: athrow
      // 17: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1a: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 1d: invokevirtual net/minecraft/client/multiplayer/PlayerControllerMP.extendedReach ()Z
      // 20: goto 24
      // 23: athrow
      // 24: ifeq 2e
      // 27: ldc2_w 6.0
      // 2a: goto 31
      // 2d: athrow
      // 2e: ldc2_w 3.0
      // 31: dstore 0
      // 32: dload 0
      // 33: dload 2
      // 34: aconst_null
      // 35: invokestatic x/oc7e673dd779.ʁ (DD[F)[Ljava/lang/Object;
      // 38: areturn
   }

   public static Object[] ʁ(double param0, double param2, float[] param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc5e549848f3.İ I
      // 003: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 006: invokevirtual net/minecraft/client/Minecraft.getRenderViewEntity ()Lnet/minecraft/entity/Entity;
      // 009: astore 6
      // 00b: aconst_null
      // 00c: astore 7
      // 00e: istore 5
      // 010: aload 6
      // 012: iload 5
      // 014: ifne 023
      // 017: ifnonnull 021
      // 01a: goto 01e
      // 01d: athrow
      // 01e: aconst_null
      // 01f: areturn
      // 020: athrow
      // 021: aload 6
      // 023: fconst_1
      // 024: invokevirtual net/minecraft/entity/Entity.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 027: astore 8
      // 029: aload 4
      // 02b: iload 5
      // 02d: ifne 039
      // 030: ifnull 049
      // 033: goto 037
      // 036: athrow
      // 037: aload 4
      // 039: bipush 1
      // 03a: faload
      // 03b: aload 4
      // 03d: bipush 0
      // 03e: faload
      // 03f: invokestatic x/oc75d51ec7eb.ď (FF)Lnet/minecraft/util/Vec3;
      // 042: astore 9
      // 044: iload 5
      // 046: ifeq 051
      // 049: aload 6
      // 04b: fconst_1
      // 04c: invokevirtual net/minecraft/entity/Entity.getLook (F)Lnet/minecraft/util/Vec3;
      // 04f: astore 9
      // 051: aload 8
      // 053: aload 9
      // 055: getfield net/minecraft/util/Vec3.xCoord D
      // 058: dload 0
      // 059: dmul
      // 05a: aload 9
      // 05c: getfield net/minecraft/util/Vec3.yCoord D
      // 05f: dload 0
      // 060: dmul
      // 061: aload 9
      // 063: getfield net/minecraft/util/Vec3.zCoord D
      // 066: dload 0
      // 067: dmul
      // 068: invokevirtual net/minecraft/util/Vec3.addVector (DDD)Lnet/minecraft/util/Vec3;
      // 06b: astore 10
      // 06d: aconst_null
      // 06e: astore 11
      // 070: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 073: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 076: aload 6
      // 078: aload 6
      // 07a: invokevirtual net/minecraft/entity/Entity.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 07d: aload 9
      // 07f: getfield net/minecraft/util/Vec3.xCoord D
      // 082: dload 0
      // 083: dmul
      // 084: aload 9
      // 086: getfield net/minecraft/util/Vec3.yCoord D
      // 089: dload 0
      // 08a: dmul
      // 08b: aload 9
      // 08d: getfield net/minecraft/util/Vec3.zCoord D
      // 090: dload 0
      // 091: dmul
      // 092: invokevirtual net/minecraft/util/AxisAlignedBB.addCoord (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 095: dconst_1
      // 096: dconst_1
      // 097: dconst_1
      // 098: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 09b: invokevirtual net/minecraft/client/multiplayer/WorldClient.getEntitiesWithinAABBExcludingEntity (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/AxisAlignedBB;)Ljava/util/List;
      // 09e: astore 12
      // 0a0: dload 0
      // 0a1: dstore 13
      // 0a3: bipush 0
      // 0a4: istore 15
      // 0a6: iload 15
      // 0a8: aload 12
      // 0aa: invokeinterface java/util/List.size ()I 1
      // 0af: if_icmpge 1e0
      // 0b2: iload 5
      // 0b4: ifne 21d
      // 0b7: aload 12
      // 0b9: iload 15
      // 0bb: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 0c0: checkcast net/minecraft/entity/Entity
      // 0c3: astore 16
      // 0c5: iload 5
      // 0c7: ifne 1db
      // 0ca: aload 16
      // 0cc: invokevirtual net/minecraft/entity/Entity.canBeCollidedWith ()Z
      // 0cf: ifeq 1d8
      // 0d2: goto 0d6
      // 0d5: athrow
      // 0d6: aload 16
      // 0d8: invokevirtual net/minecraft/entity/Entity.getCollisionBorderSize ()F
      // 0db: f2d
      // 0dc: aload 16
      // 0de: invokestatic x/occe13d5edb4.ɕ (Lnet/minecraft/entity/Entity;)D
      // 0e1: dmul
      // 0e2: d2f
      // 0e3: fstore 17
      // 0e5: aload 16
      // 0e7: invokevirtual net/minecraft/entity/Entity.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 0ea: fload 17
      // 0ec: f2d
      // 0ed: fload 17
      // 0ef: f2d
      // 0f0: fload 17
      // 0f2: f2d
      // 0f3: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 0f6: astore 18
      // 0f8: aload 18
      // 0fa: dload 2
      // 0fb: dload 2
      // 0fc: dload 2
      // 0fd: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 100: astore 18
      // 102: aload 18
      // 104: aload 8
      // 106: aload 10
      // 108: invokevirtual net/minecraft/util/AxisAlignedBB.calculateIntercept (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/MovingObjectPosition;
      // 10b: astore 19
      // 10d: aload 18
      // 10f: aload 8
      // 111: invokevirtual net/minecraft/util/AxisAlignedBB.isVecInside (Lnet/minecraft/util/Vec3;)Z
      // 114: iload 5
      // 116: ifne 131
      // 119: ifeq 166
      // 11c: goto 120
      // 11f: athrow
      // 120: dconst_0
      // 121: dload 13
      // 123: iload 5
      // 125: ifne 13b
      // 128: goto 12c
      // 12b: athrow
      // 12c: dcmpg
      // 12d: goto 131
      // 130: athrow
      // 131: iflt 13f
      // 134: dload 13
      // 136: dconst_0
      // 137: goto 13b
      // 13a: athrow
      // 13b: dcmpl
      // 13c: ifne 1d8
      // 13f: aload 16
      // 141: astore 7
      // 143: aload 19
      // 145: iload 5
      // 147: ifne 159
      // 14a: ifnonnull 157
      // 14d: goto 151
      // 150: athrow
      // 151: aload 8
      // 153: goto 15c
      // 156: athrow
      // 157: aload 19
      // 159: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 15c: astore 11
      // 15e: iload 5
      // 160: dconst_0
      // 161: dstore 13
      // 163: ifeq 1d8
      // 166: aload 19
      // 168: ifnull 1d8
      // 16b: goto 16f
      // 16e: athrow
      // 16f: aload 8
      // 171: aload 19
      // 173: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 176: invokevirtual net/minecraft/util/Vec3.distanceTo (Lnet/minecraft/util/Vec3;)D
      // 179: dstore 20
      // 17b: dload 20
      // 17d: dload 13
      // 17f: iload 5
      // 181: ifne 193
      // 184: dcmpg
      // 185: iflt 197
      // 188: goto 18c
      // 18b: athrow
      // 18c: dload 13
      // 18e: dconst_0
      // 18f: goto 193
      // 192: athrow
      // 193: dcmpl
      // 194: ifne 1d8
      // 197: aload 16
      // 199: iload 5
      // 19b: ifne 1cb
      // 19e: goto 1a2
      // 1a1: athrow
      // 1a2: aload 6
      // 1a4: getfield net/minecraft/entity/Entity.ridingEntity Lnet/minecraft/entity/Entity;
      // 1a7: if_acmpne 1c9
      // 1aa: goto 1ae
      // 1ad: athrow
      // 1ae: dload 13
      // 1b0: dconst_0
      // 1b1: dcmpl
      // 1b2: ifne 1d8
      // 1b5: goto 1b9
      // 1b8: athrow
      // 1b9: aload 16
      // 1bb: astore 7
      // 1bd: iload 5
      // 1bf: aload 19
      // 1c1: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 1c4: astore 11
      // 1c6: ifeq 1d8
      // 1c9: aload 16
      // 1cb: astore 7
      // 1cd: aload 19
      // 1cf: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 1d2: astore 11
      // 1d4: dload 20
      // 1d6: dstore 13
      // 1d8: iinc 15 1
      // 1db: iload 5
      // 1dd: ifeq 0a6
      // 1e0: dload 13
      // 1e2: dload 0
      // 1e3: dcmpg
      // 1e4: iload 5
      // 1e6: ifne 202
      // 1e9: ifge 21d
      // 1ec: goto 1f0
      // 1ef: athrow
      // 1f0: aload 7
      // 1f2: iload 5
      // 1f4: ifne 21f
      // 1f7: goto 1fb
      // 1fa: athrow
      // 1fb: instanceof net/minecraft/entity/EntityLivingBase
      // 1fe: goto 202
      // 201: athrow
      // 202: ifne 21d
      // 205: aload 7
      // 207: iload 5
      // 209: ifne 21f
      // 20c: goto 210
      // 20f: athrow
      // 210: instanceof net/minecraft/entity/item/EntityItemFrame
      // 213: ifne 21d
      // 216: goto 21a
      // 219: athrow
      // 21a: aconst_null
      // 21b: astore 7
      // 21d: aload 7
      // 21f: ifnull 241
      // 222: aload 11
      // 224: ifnull 241
      // 227: goto 22b
      // 22a: athrow
      // 22b: ldc_w 760895893
      // 22e: ldc_w 760895895
      // 231: ixor
      // 232: anewarray 208
      // 235: dup
      // 236: bipush 0
      // 237: aload 7
      // 239: aastore
      // 23a: dup
      // 23b: bipush 1
      // 23c: aload 11
      // 23e: aastore
      // 23f: areturn
      // 240: athrow
      // 241: aconst_null
      // 242: areturn
   }
}

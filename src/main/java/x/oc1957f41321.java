package x;

import java.util.function.Predicate;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;

public class oc1957f41321 {
   private boolean ӯ;
   private boolean ϲ;
   private EntityPlayer ȡ;
   private double ӑ;
   public static boolean ɭ;

   public EntityPlayer ϭ() {
      return this.ȡ;
   }

   public double Ĩ() {
      return this.ӑ;
   }

   public void ҽ(oc6111f05032 var1) {
      this.ԍ(var1, oc02a3730b27::Ӛ);
   }

   public void ԍ(oc6111f05032 param1, Predicate<EntityPlayer> param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc02a3730b27.Ŧ I
      // 003: istore 3
      // 004: aload 0
      // 005: iload 3
      // 006: ifne 01d
      // 009: bipush 0
      // 00a: putfield x/oc1957f41321.ӯ Z
      // 00d: aload 1
      // 00e: invokevirtual x/oc6111f05032.Մ ()Z
      // 011: ifne 025
      // 014: goto 018
      // 017: athrow
      // 018: aload 0
      // 019: goto 01d
      // 01c: athrow
      // 01d: aconst_null
      // 01e: putfield x/oc1957f41321.ȡ Lnet/minecraft/entity/player/EntityPlayer;
      // 021: iload 3
      // 022: ifeq 21f
      // 025: new net/minecraft/util/Vec3
      // 028: dup
      // 029: aload 1
      // 02a: invokevirtual x/oc6111f05032.ŭ ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 02d: getfield net/minecraft/client/entity/EntityPlayerSP.posX D
      // 030: aload 1
      // 031: invokevirtual x/oc6111f05032.ŭ ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 034: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // 037: ldc2_w 1.62
      // 03a: dadd
      // 03b: aload 1
      // 03c: invokevirtual x/oc6111f05032.ŭ ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 03f: getfield net/minecraft/client/entity/EntityPlayerSP.posZ D
      // 042: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 045: astore 4
      // 047: aconst_null
      // 048: astore 5
      // 04a: aload 1
      // 04b: invokevirtual x/oc6111f05032.Ĩ ()Lnet/minecraft/client/Minecraft;
      // 04e: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 051: astore 6
      // 053: aload 6
      // 055: iload 3
      // 056: ifne 062
      // 059: ifnull 0bd
      // 05c: goto 060
      // 05f: athrow
      // 060: aload 6
      // 062: iload 3
      // 063: ifne 079
      // 066: getfield net/minecraft/util/MovingObjectPosition.typeOfHit Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 069: getstatic net/minecraft/util/MovingObjectPosition$MovingObjectType.ENTITY Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 06c: if_acmpne 0bd
      // 06f: goto 073
      // 072: athrow
      // 073: aload 6
      // 075: goto 079
      // 078: athrow
      // 079: iload 3
      // 07a: ifne 090
      // 07d: getfield net/minecraft/util/MovingObjectPosition.entityHit Lnet/minecraft/entity/Entity;
      // 080: instanceof net/minecraft/client/entity/EntityOtherPlayerMP
      // 083: ifeq 0bd
      // 086: goto 08a
      // 089: athrow
      // 08a: aload 6
      // 08c: goto 090
      // 08f: athrow
      // 090: getfield net/minecraft/util/MovingObjectPosition.entityHit Lnet/minecraft/entity/Entity;
      // 093: checkcast net/minecraft/entity/player/EntityPlayer
      // 096: astore 7
      // 098: aload 2
      // 099: aload 7
      // 09b: invokeinterface java/util/function/Predicate.test (Ljava/lang/Object;)Z 2
      // 0a0: iload 3
      // 0a1: ifne 0b6
      // 0a4: ifeq 0bd
      // 0a7: goto 0ab
      // 0aa: athrow
      // 0ab: fconst_0
      // 0ac: aload 7
      // 0ae: invokevirtual net/minecraft/entity/player/EntityPlayer.getHealth ()F
      // 0b1: fcmpl
      // 0b2: goto 0b6
      // 0b5: athrow
      // 0b6: ifge 0bd
      // 0b9: aload 7
      // 0bb: astore 5
      // 0bd: aload 5
      // 0bf: iload 3
      // 0c0: ifne 101
      // 0c3: ifnonnull 0ff
      // 0c6: goto 0ca
      // 0c9: athrow
      // 0ca: getstatic x/oc9755810e45.ţ Lx/ocaa9a64f047;
      // 0cd: iload 3
      // 0ce: ifne 0df
      // 0d1: goto 0d5
      // 0d4: athrow
      // 0d5: ifnull 0ff
      // 0d8: goto 0dc
      // 0db: athrow
      // 0dc: getstatic x/oc9755810e45.ţ Lx/ocaa9a64f047;
      // 0df: invokevirtual x/ocaa9a64f047.ŷ ()Lnet/minecraft/entity/Entity;
      // 0e2: astore 7
      // 0e4: aload 7
      // 0e6: iload 3
      // 0e7: ifne 0fa
      // 0ea: instanceof net/minecraft/entity/player/EntityPlayer
      // 0ed: ifeq 0ff
      // 0f0: goto 0f4
      // 0f3: athrow
      // 0f4: aload 7
      // 0f6: goto 0fa
      // 0f9: athrow
      // 0fa: checkcast net/minecraft/entity/player/EntityPlayer
      // 0fd: astore 5
      // 0ff: aload 5
      // 101: ifnull 11d
      // 104: aload 0
      // 105: aload 5
      // 107: putfield x/oc1957f41321.ȡ Lnet/minecraft/entity/player/EntityPlayer;
      // 10a: iload 3
      // 10b: aload 0
      // 10c: aload 4
      // 10e: aload 5
      // 110: invokestatic x/oc1957f41321.ĩ (Lnet/minecraft/util/Vec3;Lnet/minecraft/entity/Entity;)D
      // 113: putfield x/oc1957f41321.ӑ D
      // 116: ifeq 21f
      // 119: goto 11d
      // 11c: athrow
      // 11d: ldc2_w 225.0
      // 120: dstore 7
      // 122: aload 1
      // 123: invokevirtual x/oc6111f05032.X ()Lnet/minecraft/client/multiplayer/WorldClient;
      // 126: getfield net/minecraft/client/multiplayer/WorldClient.playerEntities Ljava/util/List;
      // 129: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 12e: astore 9
      // 130: aload 9
      // 132: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 137: ifeq 206
      // 13a: aload 9
      // 13c: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 141: checkcast net/minecraft/entity/player/EntityPlayer
      // 144: iload 3
      // 145: ifne 216
      // 148: astore 10
      // 14a: aload 10
      // 14c: aload 1
      // 14d: invokevirtual x/oc6111f05032.ŭ ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 150: if_acmpeq 202
      // 153: aload 2
      // 154: aload 10
      // 156: invokeinterface java/util/function/Predicate.test (Ljava/lang/Object;)Z 2
      // 15b: iload 3
      // 15c: ifne 175
      // 15f: goto 163
      // 162: athrow
      // 163: ifeq 202
      // 166: goto 16a
      // 169: athrow
      // 16a: fconst_0
      // 16b: aload 10
      // 16d: invokevirtual net/minecraft/entity/player/EntityPlayer.getHealth ()F
      // 170: fcmpl
      // 171: goto 175
      // 174: athrow
      // 175: iload 3
      // 176: ifne 189
      // 179: ifge 202
      // 17c: goto 180
      // 17f: athrow
      // 180: aload 10
      // 182: invokevirtual net/minecraft/entity/player/EntityPlayer.isPlayerSleeping ()Z
      // 185: goto 189
      // 188: athrow
      // 189: ifne 202
      // 18c: aload 4
      // 18e: aload 10
      // 190: invokestatic x/oc1957f41321.ĩ (Lnet/minecraft/util/Vec3;Lnet/minecraft/entity/Entity;)D
      // 193: dstore 11
      // 195: dload 11
      // 197: dload 7
      // 199: dcmpl
      // 19a: ifgt 202
      // 19d: aload 4
      // 19f: new net/minecraft/util/Vec3
      // 1a2: dup
      // 1a3: aload 10
      // 1a5: getfield net/minecraft/entity/player/EntityPlayer.posX D
      // 1a8: aload 10
      // 1aa: getfield net/minecraft/entity/player/EntityPlayer.posY D
      // 1ad: aload 10
      // 1af: getfield net/minecraft/entity/player/EntityPlayer.posZ D
      // 1b2: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 1b5: invokestatic x/oc497d0cdf29.ʂ (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)[F
      // 1b8: astore 13
      // 1ba: iload 3
      // 1bb: aload 13
      // 1bd: bipush 0
      // 1be: faload
      // 1bf: aload 1
      // 1c0: invokevirtual x/oc6111f05032.ŭ ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1c3: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 1c6: fsub
      // 1c7: invokestatic x/oc497d0cdf29.Ը (F)F
      // 1ca: fstore 14
      // 1cc: aload 13
      // 1ce: bipush 1
      // 1cf: faload
      // 1d0: aload 1
      // 1d1: invokevirtual x/oc6111f05032.ŭ ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1d4: getfield net/minecraft/client/entity/EntityPlayerSP.rotationPitch F
      // 1d7: fsub
      // 1d8: fstore 15
      // 1da: fload 14
      // 1dc: fload 14
      // 1de: fmul
      // 1df: fstore 16
      // 1e1: fload 16
      // 1e3: fload 15
      // 1e5: fadd
      // 1e6: fstore 16
      // 1e8: ifne 1fe
      // 1eb: fload 16
      // 1ed: fload 15
      // 1ef: fadd
      // 1f0: fstore 16
      // 1f2: fload 16
      // 1f4: ldc 4900.0
      // 1f6: fcmpl
      // 1f7: ifgt 202
      // 1fa: dload 11
      // 1fc: dstore 7
      // 1fe: aload 10
      // 200: astore 5
      // 202: iload 3
      // 203: ifeq 130
      // 206: aload 0
      // 207: iload 3
      // 208: ifne 21a
      // 20b: aload 5
      // 20d: putfield x/oc1957f41321.ȡ Lnet/minecraft/entity/player/EntityPlayer;
      // 210: aload 5
      // 212: goto 216
      // 215: athrow
      // 216: ifnull 21f
      // 219: aload 0
      // 21a: dload 7
      // 21c: putfield x/oc1957f41321.ӑ D
      // 21f: return
   }

   private static double ĩ(Vec3 var0, Entity var1) {
      AxisAlignedBB var2 = var1.getEntityBoundingBox().expand(0.1, 0.1, 0.1);
      double var3 = oc497d0cdf29.ɨ(var2.minX, var2.maxX, var0.xCoord) - var0.xCoord;
      double var5 = oc497d0cdf29.ɨ(var2.minY, var2.maxY, var0.yCoord) - var0.yCoord;
      double var7 = oc497d0cdf29.ɨ(var2.minZ, var2.maxZ, var0.zCoord) - var0.zCoord;
      return var7 * var7 + (var3 * var3 + var5 * var5);
   }

   public void ϸ() {
      this.ӯ = false;
      this.ȡ = null;
      this.ӑ = 0.0;
   }

   public void Ч() {
      this.ӯ = false;
   }

   public void ɀ(oc6111f05032 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc02a3730b27.Ŧ I
      // 03: istore 2
      // 04: aload 0
      // 05: getfield x/oc1957f41321.ӯ Z
      // 08: ifne c4
      // 0b: aload 1
      // 0c: invokevirtual x/oc6111f05032.Ĩ ()Lnet/minecraft/client/Minecraft;
      // 0f: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 12: astore 3
      // 13: aload 1
      // 14: invokevirtual x/oc6111f05032.Մ ()Z
      // 17: ifeq b2
      // 1a: aload 3
      // 1b: iload 2
      // 1c: ifne 2b
      // 1f: goto 23
      // 22: athrow
      // 23: ifnull b2
      // 26: goto 2a
      // 29: athrow
      // 2a: aload 3
      // 2b: getfield net/minecraft/util/MovingObjectPosition.typeOfHit Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 2e: getstatic net/minecraft/util/MovingObjectPosition$MovingObjectType.ENTITY Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 31: if_acmpne b2
      // 34: aload 0
      // 35: bipush 1
      // 36: new net/minecraft/util/Vec3
      // 39: dup
      // 3a: aload 1
      // 3b: invokevirtual x/oc6111f05032.ŭ ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 3e: getfield net/minecraft/client/entity/EntityPlayerSP.posX D
      // 41: aload 1
      // 42: invokevirtual x/oc6111f05032.ŭ ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 45: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // 48: ldc2_w 1.62
      // 4b: dadd
      // 4c: aload 1
      // 4d: invokevirtual x/oc6111f05032.ŭ ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 50: getfield net/minecraft/client/entity/EntityPlayerSP.posZ D
      // 53: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 56: aload 3
      // 57: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 5a: aload 1
      // 5b: invokevirtual x/oc6111f05032.ŭ ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 5e: getfield net/minecraft/client/entity/EntityPlayerSP.motionX D
      // 61: aload 1
      // 62: invokevirtual x/oc6111f05032.ŭ ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 65: getfield net/minecraft/client/entity/EntityPlayerSP.motionY D
      // 68: aload 1
      // 69: invokevirtual x/oc6111f05032.ŭ ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 6c: getfield net/minecraft/client/entity/EntityPlayerSP.motionZ D
      // 6f: aload 1
      // 70: invokevirtual x/oc6111f05032.ŭ ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 73: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 76: aload 1
      // 77: invokevirtual x/oc6111f05032.ŭ ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 7a: getfield net/minecraft/client/entity/EntityPlayerSP.moveForward F
      // 7d: aload 1
      // 7e: invokevirtual x/oc6111f05032.ŭ ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 81: getfield net/minecraft/client/entity/EntityPlayerSP.moveStrafing F
      // 84: aload 1
      // 85: iload 2
      // 86: ifne 9f
      // 89: goto 8d
      // 8c: athrow
      // 8d: invokevirtual x/oc6111f05032.ŭ ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 90: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 93: ifeq a8
      // 96: goto 9a
      // 99: athrow
      // 9a: aload 1
      // 9b: goto 9f
      // 9e: athrow
      // 9f: invokevirtual x/oc6111f05032.ŭ ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // a2: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getAIMoveSpeed ()F
      // a5: goto ab
      // a8: ldc_w 0.026
      // ab: invokevirtual x/oc1957f41321.ͻ (ZLnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;DDDFFFF)V
      // ae: iload 2
      // af: ifeq c4
      // b2: aload 0
      // b3: bipush 0
      // b4: aconst_null
      // b5: aconst_null
      // b6: dconst_0
      // b7: dconst_0
      // b8: dconst_0
      // b9: fconst_0
      // ba: fconst_0
      // bb: fconst_0
      // bc: fconst_0
      // bd: invokevirtual x/oc1957f41321.ͻ (ZLnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;DDDFFFF)V
      // c0: goto c4
      // c3: athrow
      // c4: return
   }

   public void ͻ(
      boolean param1, Vec3 param2, Vec3 param3, double param4, double param6, double param8, float param10, float param11, float param12, float param13
   ) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc02a3730b27.Ŧ I
      // 03: istore 14
      // 05: aload 0
      // 06: iload 14
      // 08: ifne 1a
      // 0b: getfield x/oc1957f41321.ӯ Z
      // 0e: ifne c5
      // 11: goto 15
      // 14: athrow
      // 15: aload 0
      // 16: goto 1a
      // 19: athrow
      // 1a: iload 14
      // 1c: ifne c1
      // 1f: bipush 1
      // 20: putfield x/oc1957f41321.ϲ Z
      // 23: iload 1
      // 24: ifeq c0
      // 27: goto 2b
      // 2a: athrow
      // 2b: fload 10
      // 2d: fload 11
      // 2f: fload 12
      // 31: fload 13
      // 33: invokestatic x/oc497d0cdf29.Ρ (FFFF)[D
      // 36: astore 15
      // 38: dload 4
      // 3a: aload 15
      // 3c: bipush 0
      // 3d: daload
      // 3e: dadd
      // 3f: dstore 16
      // 41: dload 6
      // 43: dconst_0
      // 44: dadd
      // 45: dstore 18
      // 47: aload 15
      // 49: bipush 1
      // 4a: daload
      // 4b: dload 8
      // 4d: dadd
      // 4e: dstore 20
      // 50: dload 4
      // 52: ldc2_w 0.6
      // 55: dmul
      // 56: aload 15
      // 58: bipush 0
      // 59: daload
      // 5a: dadd
      // 5b: dstore 22
      // 5d: dload 6
      // 5f: dconst_0
      // 60: dadd
      // 61: dstore 24
      // 63: aload 15
      // 65: bipush 1
      // 66: daload
      // 67: ldc2_w 0.6
      // 6a: dload 8
      // 6c: dmul
      // 6d: dadd
      // 6e: dstore 26
      // 70: aload 2
      // 71: getfield net/minecraft/util/Vec3.xCoord D
      // 74: dload 22
      // 76: dadd
      // 77: aload 2
      // 78: getfield net/minecraft/util/Vec3.yCoord D
      // 7b: dload 24
      // 7d: dadd
      // 7e: dload 26
      // 80: aload 2
      // 81: getfield net/minecraft/util/Vec3.zCoord D
      // 84: dadd
      // 85: aload 3
      // 86: invokestatic x/oc1957f41321.Л (DDDLnet/minecraft/util/Vec3;)D
      // 89: dstore 28
      // 8b: aload 2
      // 8c: getfield net/minecraft/util/Vec3.xCoord D
      // 8f: dload 16
      // 91: dadd
      // 92: aload 2
      // 93: getfield net/minecraft/util/Vec3.yCoord D
      // 96: dload 18
      // 98: dadd
      // 99: dload 20
      // 9b: aload 2
      // 9c: getfield net/minecraft/util/Vec3.zCoord D
      // 9f: dadd
      // a0: aload 3
      // a1: invokestatic x/oc1957f41321.Л (DDDLnet/minecraft/util/Vec3;)D
      // a4: dstore 30
      // a6: aload 0
      // a7: dload 30
      // a9: dload 28
      // ab: dcmpl
      // ac: iload 14
      // ae: ifne b9
      // b1: ifle bc
      // b4: goto b8
      // b7: athrow
      // b8: bipush 1
      // b9: goto bd
      // bc: bipush 0
      // bd: putfield x/oc1957f41321.ϲ Z
      // c0: aload 0
      // c1: bipush 1
      // c2: putfield x/oc1957f41321.ӯ Z
      // c5: return
   }

   private static double Л(double var0, double var2, double var4, Vec3 var6) {
      var0 -= var6.xCoord;
      var2 -= var6.yCoord;
      var4 -= var6.zCoord;
      return var4 * var4 + (var0 * var0 + var2 * var2);
   }

   public oc33e2bcdd33 Ļ(int var1, boolean var2) {
      int var3 = oc02a3730b27.Ŧ;

      label45: {
         boolean var10000;
         label44: {
            try {
               var10000 = this.ӯ;
               if (var3 != 0) {
                  break label44;
               }

               if (this.ӯ) {
                  break label45;
               }
            } catch (IllegalStateException var7) {
               throw var7;
            }

            var10000 = var2;
         }

         try {
            if (!var10000) {
               throw new IllegalStateException("Attack status must be prepared before dispatch");
            }
         } catch (IllegalStateException var5) {
            throw var5;
         }
      }

      oc33e2bcdd33 var4 = new oc33e2bcdd33(var1);

      oc33e2bcdd33 var8;
      boolean var10001;
      label35: {
         label34: {
            try {
               var8 = var4;
               var10001 = var2;
               if (var3 != 0) {
                  break label35;
               }

               if (!var2) {
                  break label34;
               }
            } catch (IllegalStateException var6) {
               throw var6;
            }

            var10001 = false;
            break label35;
         }

         var10001 = true;
      }

      var8.ä = var10001;
      var4.ˢ = this.ϲ;
      return var4;
   }
}

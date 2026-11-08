package x;

import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;

public class ocd692148b4a implements ocda171fe5d8 {
   public static boolean ц;

   private ocd692148b4a() {
   }

   public static Vec3 ȳ(float var0, float var1) {
      float var2 = MathHelper.cos(-var1 * (float) (Math.PI / 180.0) - (float) Math.PI);
      float var3 = MathHelper.sin(-var1 * (float) (Math.PI / 180.0) - (float) Math.PI);
      float var4 = -MathHelper.cos(-var0 * (float) (Math.PI / 180.0));
      float var5 = MathHelper.sin(-var0 * (float) (Math.PI / 180.0));
      return new Vec3(var3 * var4, var5, var2 * var4);
   }

   public static MovingObjectPosition ї(float var0, float var1, double var2, float var4) {
      return қ(var0, var1, var2, var4, ocda171fe5d8.ǔ.thePlayer, false);
   }

   public static MovingObjectPosition қ(float param0, float param1, double param2, float param4, Entity param5, boolean param6) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 7
      // 005: aload 5
      // 007: ifnull 017
      // 00a: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 00d: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 010: ifnonnull 01a
      // 013: goto 017
      // 016: athrow
      // 017: aconst_null
      // 018: areturn
      // 019: athrow
      // 01a: aload 5
      // 01c: fconst_1
      // 01d: invokevirtual net/minecraft/entity/Entity.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 020: astore 8
      // 022: fload 1
      // 023: fload 0
      // 024: invokestatic x/ocd692148b4a.ȳ (FF)Lnet/minecraft/util/Vec3;
      // 027: astore 9
      // 029: aload 8
      // 02b: aload 9
      // 02d: getfield net/minecraft/util/Vec3.xCoord D
      // 030: dload 2
      // 031: dmul
      // 032: aload 9
      // 034: getfield net/minecraft/util/Vec3.yCoord D
      // 037: dload 2
      // 038: dmul
      // 039: aload 9
      // 03b: getfield net/minecraft/util/Vec3.zCoord D
      // 03e: dload 2
      // 03f: dmul
      // 040: invokevirtual net/minecraft/util/Vec3.addVector (DDD)Lnet/minecraft/util/Vec3;
      // 043: astore 10
      // 045: iload 6
      // 047: ifeq 04f
      // 04a: aconst_null
      // 04b: goto 05f
      // 04e: athrow
      // 04f: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 052: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 055: aload 8
      // 057: aload 10
      // 059: bipush 0
      // 05a: bipush 0
      // 05b: bipush 1
      // 05c: invokevirtual net/minecraft/client/multiplayer/WorldClient.rayTraceBlocks (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;ZZZ)Lnet/minecraft/util/MovingObjectPosition;
      // 05f: astore 11
      // 061: dload 2
      // 062: dstore 12
      // 064: aload 11
      // 066: iload 7
      // 068: ifne 074
      // 06b: ifnull 093
      // 06e: goto 072
      // 071: athrow
      // 072: aload 11
      // 074: iload 7
      // 076: ifne 089
      // 079: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 07c: ifnull 093
      // 07f: goto 083
      // 082: athrow
      // 083: aload 11
      // 085: goto 089
      // 088: athrow
      // 089: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 08c: aload 8
      // 08e: invokevirtual net/minecraft/util/Vec3.distanceTo (Lnet/minecraft/util/Vec3;)D
      // 091: dstore 12
      // 093: aconst_null
      // 094: astore 14
      // 096: aconst_null
      // 097: astore 15
      // 099: getstatic x/ocda171fe5d8.ǔ Lnet/minecraft/client/Minecraft;
      // 09c: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 09f: aload 5
      // 0a1: aload 5
      // 0a3: invokevirtual net/minecraft/entity/Entity.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 0a6: aload 9
      // 0a8: getfield net/minecraft/util/Vec3.xCoord D
      // 0ab: dload 2
      // 0ac: dmul
      // 0ad: aload 9
      // 0af: getfield net/minecraft/util/Vec3.yCoord D
      // 0b2: dload 2
      // 0b3: dmul
      // 0b4: aload 9
      // 0b6: getfield net/minecraft/util/Vec3.zCoord D
      // 0b9: dload 2
      // 0ba: dmul
      // 0bb: invokevirtual net/minecraft/util/AxisAlignedBB.addCoord (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 0be: dconst_1
      // 0bf: dconst_1
      // 0c0: dconst_1
      // 0c1: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 0c4: getstatic net/minecraft/util/EntitySelectors.NOT_SPECTATING Lcom/google/common/base/Predicate;
      // 0c7: invokedynamic apply ()Lcom/google/common/base/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/minecraft/entity/Entity.canBeCollidedWith ()Z, (Lnet/minecraft/entity/Entity;)Z ]
      // 0cc: invokestatic com/google/common/base/Predicates.and (Lcom/google/common/base/Predicate;Lcom/google/common/base/Predicate;)Lcom/google/common/base/Predicate;
      // 0cf: invokevirtual net/minecraft/client/multiplayer/WorldClient.getEntitiesInAABBexcluding (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/AxisAlignedBB;Lcom/google/common/base/Predicate;)Ljava/util/List;
      // 0d2: astore 16
      // 0d4: aload 16
      // 0d6: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 0db: astore 17
      // 0dd: aload 17
      // 0df: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0e4: ifeq 1b3
      // 0e7: aload 17
      // 0e9: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0ee: checkcast net/minecraft/entity/Entity
      // 0f1: astore 18
      // 0f3: aload 18
      // 0f5: invokevirtual net/minecraft/entity/Entity.getCollisionBorderSize ()F
      // 0f8: fload 4
      // 0fa: fadd
      // 0fb: fstore 19
      // 0fd: aload 18
      // 0ff: invokevirtual net/minecraft/entity/Entity.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 102: fload 19
      // 104: f2d
      // 105: fload 19
      // 107: f2d
      // 108: fload 19
      // 10a: f2d
      // 10b: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 10e: astore 20
      // 110: aload 20
      // 112: aload 8
      // 114: aload 10
      // 116: invokevirtual net/minecraft/util/AxisAlignedBB.calculateIntercept (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/MovingObjectPosition;
      // 119: iload 7
      // 11b: ifne 1d5
      // 11e: astore 21
      // 120: aload 20
      // 122: aload 8
      // 124: invokevirtual net/minecraft/util/AxisAlignedBB.isVecInside (Lnet/minecraft/util/Vec3;)Z
      // 127: iload 7
      // 129: ifne 13b
      // 12c: ifeq 165
      // 12f: goto 133
      // 132: athrow
      // 133: dload 12
      // 135: dconst_0
      // 136: dcmpl
      // 137: goto 13b
      // 13a: athrow
      // 13b: iflt 1ae
      // 13e: aload 18
      // 140: astore 14
      // 142: aload 21
      // 144: iload 7
      // 146: ifne 158
      // 149: ifnonnull 156
      // 14c: goto 150
      // 14f: athrow
      // 150: aload 8
      // 152: goto 15b
      // 155: athrow
      // 156: aload 21
      // 158: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 15b: astore 15
      // 15d: iload 7
      // 15f: dconst_0
      // 160: dstore 12
      // 162: ifeq 1ae
      // 165: aload 21
      // 167: ifnull 1ae
      // 16a: goto 16e
      // 16d: athrow
      // 16e: aload 8
      // 170: aload 21
      // 172: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 175: invokevirtual net/minecraft/util/Vec3.distanceTo (Lnet/minecraft/util/Vec3;)D
      // 178: dstore 22
      // 17a: dload 22
      // 17c: dload 12
      // 17e: iload 7
      // 180: ifne 19b
      // 183: dcmpg
      // 184: ifge 1ae
      // 187: goto 18b
      // 18a: athrow
      // 18b: dload 12
      // 18d: iload 7
      // 18f: ifne 1ac
      // 192: goto 196
      // 195: athrow
      // 196: dconst_0
      // 197: goto 19b
      // 19a: athrow
      // 19b: dcmpl
      // 19c: ifeq 1ae
      // 19f: aload 18
      // 1a1: astore 14
      // 1a3: aload 21
      // 1a5: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 1a8: astore 15
      // 1aa: dload 22
      // 1ac: dstore 12
      // 1ae: iload 7
      // 1b0: ifeq 0dd
      // 1b3: aload 14
      // 1b5: ifnull 1d3
      // 1b8: new net/minecraft/util/MovingObjectPosition
      // 1bb: dup
      // 1bc: aload 14
      // 1be: aload 15
      // 1c0: ifnonnull 1cd
      // 1c3: goto 1c7
      // 1c6: athrow
      // 1c7: aload 8
      // 1c9: goto 1cf
      // 1cc: athrow
      // 1cd: aload 15
      // 1cf: invokespecial net/minecraft/util/MovingObjectPosition.<init> (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/Vec3;)V
      // 1d2: areturn
      // 1d3: aload 11
      // 1d5: areturn
   }
}

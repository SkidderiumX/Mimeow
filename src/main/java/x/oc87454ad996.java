package x;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;

public class oc87454ad996 extends oc69da1aa7f5 {
   private occc831eff22 G;
   private occ2f8dff8d8 Β;
   private occ2f8dff8d8 Ǻ;
   private occ2f8dff8d8 θ;
   private occ2f8dff8d8 Ҩ;
   private occc831eff22 ҁ;
   private occ2f8dff8d8 ն;
   private occ2f8dff8d8 Ҕ;
   private occ2f8dff8d8 ǳ;
   private occc831eff22 Ր;
   private occc831eff22 d;
   private occ2f8dff8d8 Ğ;
   private occ2f8dff8d8 ì;
   private occ2f8dff8d8 ъ;
   private occ2f8dff8d8 Ʈ;
   private occ2f8dff8d8 Ɨ;
   private occ2f8dff8d8 Ƽ;
   private occ2f8dff8d8 ќ;
   private occ2f8dff8d8 Ո;
   private occ2f8dff8d8 ι;
   private occ2f8dff8d8 ԇ;
   public static int ı;

   public oc87454ad996() {
      super("GhostHand", oce4cea752dd.з);
      this.ʌ(this.G = new occc831eff22("Interact through"));
      this.ʌ(this.Β = new occ2f8dff8d8(this.G, "Non-player entities", true));
      this.ʌ(this.Ǻ = new occ2f8dff8d8(this.G, "Bots", false));
      this.ʌ(this.θ = new occ2f8dff8d8(this.G, "Friendlies", false));
      this.ʌ(this.Ҩ = new occ2f8dff8d8(this.G, "Enemies", true));
      this.ʌ(this.ҁ = new occc831eff22("Preferred targets"));
      this.ʌ(this.ն = new occ2f8dff8d8(this.ҁ, "Everything", true));
      this.ʌ(this.Ҕ = new occ2f8dff8d8(this.ҁ, "Bed", false));
      this.ʌ(this.ǳ = new occ2f8dff8d8(this.ҁ, "Next to bed", false));
      this.ʌ(this.Ր = new occc831eff22("Allow while using"));
      this.ʌ(this.Ğ = new occ2f8dff8d8(this.Ր, "Sword", false));
      this.ʌ(this.ì = new occ2f8dff8d8(this.Ր, "Tool", true));
      this.ʌ(this.ъ = new occ2f8dff8d8(this.Ր, "Fists", true));
      this.ʌ(this.Ʈ = new occ2f8dff8d8(this.Ր, "Bucket", true));
      this.ʌ(this.Ɨ = new occ2f8dff8d8(this.Ր, "Flint and steel", true));
      this.ʌ(this.Ƽ = new occ2f8dff8d8(this.Ր, "Cobweb", true));
      this.ʌ(this.ќ = new occ2f8dff8d8(this.Ր, "Other", true));
      this.ʌ(this.d = new occc831eff22("Conditions"));
      this.ʌ(this.Ո = new occ2f8dff8d8(this.d, "Require Left mouse", false));
      this.ʌ(this.ι = new occ2f8dff8d8(this.d, "Require right mouse", false));
      this.ʌ(this.ԇ = new occ2f8dff8d8(this.d, "Not holding a sword", false));
   }

   public boolean ƭ() {
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
      // 09: ifne 14
      // 0c: ifne 15
      // 0f: goto 13
      // 12: athrow
      // 13: bipush 0
      // 14: ireturn
      // 15: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 18: iload 1
      // 19: ifne 26
      // 1c: ifnull 49
      // 1f: goto 23
      // 22: athrow
      // 23: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 26: iload 1
      // 27: ifne 3b
      // 2a: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 2d: ifnull 49
      // 30: goto 34
      // 33: athrow
      // 34: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 37: goto 3b
      // 3a: athrow
      // 3b: iload 1
      // 3c: ifne 4f
      // 3f: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 42: ifnonnull 4c
      // 45: goto 49
      // 48: athrow
      // 49: bipush 0
      // 4a: ireturn
      // 4b: athrow
      // 4c: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 4f: invokevirtual net/minecraft/client/Minecraft.getRenderViewEntity ()Lnet/minecraft/entity/Entity;
      // 52: ifnonnull 58
      // 55: bipush 0
      // 56: ireturn
      // 57: athrow
      // 58: aload 0
      // 59: getfield x/oc87454ad996.ԇ Lx/occ2f8dff8d8;
      // 5c: iload 1
      // 5d: ifne 83
      // 60: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 63: ifeq 7f
      // 66: goto 6a
      // 69: athrow
      // 6a: invokestatic x/oc7ab2161b9f.ө ()Z
      // 6d: iload 1
      // 6e: ifne 8e
      // 71: goto 75
      // 74: athrow
      // 75: ifeq 7f
      // 78: goto 7c
      // 7b: athrow
      // 7c: bipush 0
      // 7d: ireturn
      // 7e: athrow
      // 7f: aload 0
      // 80: getfield x/oc87454ad996.Ո Lx/occ2f8dff8d8;
      // 83: iload 1
      // 84: ifne b3
      // 87: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 8a: goto 8e
      // 8d: athrow
      // 8e: ifeq a7
      // 91: bipush 0
      // 92: iload 1
      // 93: ifne b6
      // 96: goto 9a
      // 99: athrow
      // 9a: invokestatic org/lwjgl/input/Mouse.isButtonDown (I)Z
      // 9d: ifne a7
      // a0: goto a4
      // a3: athrow
      // a4: bipush 0
      // a5: ireturn
      // a6: athrow
      // a7: aload 0
      // a8: iload 1
      // a9: ifne d0
      // ac: getfield x/oc87454ad996.ι Lx/occ2f8dff8d8;
      // af: goto b3
      // b2: athrow
      // b3: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // b6: ifeq cf
      // b9: bipush 1
      // ba: iload 1
      // bb: ifne d3
      // be: goto c2
      // c1: athrow
      // c2: invokestatic org/lwjgl/input/Mouse.isButtonDown (I)Z
      // c5: ifne cf
      // c8: goto cc
      // cb: athrow
      // cc: bipush 0
      // cd: ireturn
      // ce: athrow
      // cf: aload 0
      // d0: invokevirtual x/oc87454ad996.ӕ ()Z
      // d3: ireturn
   }

   public void D(float param1) {
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
      // 005: invokevirtual x/oc87454ad996.ƭ ()Z
      // 008: ifne 00d
      // 00b: return
      // 00c: athrow
      // 00d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 010: invokevirtual net/minecraft/client/Minecraft.getRenderViewEntity ()Lnet/minecraft/entity/Entity;
      // 013: astore 3
      // 014: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 017: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 01a: invokevirtual net/minecraft/client/multiplayer/PlayerControllerMP.getBlockReachDistance ()F
      // 01d: f2d
      // 01e: dstore 4
      // 020: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 023: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 026: invokevirtual net/minecraft/client/multiplayer/PlayerControllerMP.extendedReach ()Z
      // 029: ifeq 031
      // 02c: ldc2_w 6.0
      // 02f: dstore 4
      // 031: aload 0
      // 032: aload 3
      // 033: dload 4
      // 035: fload 1
      // 036: invokevirtual x/oc87454ad996.Ǒ (Lnet/minecraft/entity/Entity;DF)Lnet/minecraft/util/MovingObjectPosition;
      // 039: astore 6
      // 03b: aload 6
      // 03d: iload 2
      // 03e: ifne 04b
      // 041: ifnonnull 049
      // 044: goto 048
      // 047: athrow
      // 048: return
      // 049: aload 6
      // 04b: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 04e: astore 7
      // 050: aload 7
      // 052: invokestatic x/occb1ed1ed8f.ϛ (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/Block;
      // 055: astore 8
      // 057: aload 8
      // 059: instanceof net/minecraft/block/BlockBed
      // 05c: istore 9
      // 05e: iload 9
      // 060: iload 2
      // 061: ifne 074
      // 064: ifne 083
      // 067: goto 06b
      // 06a: athrow
      // 06b: aload 7
      // 06d: invokestatic x/occb1ed1ed8f.П (Lnet/minecraft/util/BlockPos;)Z
      // 070: goto 074
      // 073: athrow
      // 074: iload 2
      // 075: ifne 080
      // 078: ifeq 083
      // 07b: goto 07f
      // 07e: athrow
      // 07f: bipush 1
      // 080: goto 084
      // 083: bipush 0
      // 084: istore 10
      // 086: aload 0
      // 087: iload 2
      // 088: ifne 0aa
      // 08b: getfield x/oc87454ad996.Ҕ Lx/occ2f8dff8d8;
      // 08e: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 091: ifeq 0a9
      // 094: goto 098
      // 097: athrow
      // 098: iload 9
      // 09a: iload 2
      // 09b: ifne 0c9
      // 09e: goto 0a2
      // 0a1: athrow
      // 0a2: ifne 0c8
      // 0a5: goto 0a9
      // 0a8: athrow
      // 0a9: aload 0
      // 0aa: getfield x/oc87454ad996.ǳ Lx/occ2f8dff8d8;
      // 0ad: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0b0: iload 2
      // 0b1: ifne 0bd
      // 0b4: ifeq 0cc
      // 0b7: goto 0bb
      // 0ba: athrow
      // 0bb: iload 10
      // 0bd: iload 2
      // 0be: ifne 0c9
      // 0c1: ifeq 0cc
      // 0c4: goto 0c8
      // 0c7: athrow
      // 0c8: bipush 1
      // 0c9: goto 0cd
      // 0cc: bipush 0
      // 0cd: istore 11
      // 0cf: aload 0
      // 0d0: getfield x/oc87454ad996.ն Lx/occ2f8dff8d8;
      // 0d3: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0d6: iload 2
      // 0d7: ifne 0f5
      // 0da: ifne 0f3
      // 0dd: goto 0e1
      // 0e0: athrow
      // 0e1: iload 11
      // 0e3: iload 2
      // 0e4: ifne 0f5
      // 0e7: goto 0eb
      // 0ea: athrow
      // 0eb: ifne 0f3
      // 0ee: goto 0f2
      // 0f1: athrow
      // 0f2: return
      // 0f3: iload 11
      // 0f5: ifne 276
      // 0f8: aload 3
      // 0f9: fload 1
      // 0fa: invokevirtual net/minecraft/entity/Entity.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 0fd: astore 12
      // 0ff: aload 6
      // 101: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 104: astore 13
      // 106: aload 12
      // 108: aload 13
      // 10a: invokevirtual net/minecraft/util/Vec3.distanceTo (Lnet/minecraft/util/Vec3;)D
      // 10d: dstore 14
      // 10f: new net/minecraft/util/AxisAlignedBB
      // 112: dup
      // 113: aload 12
      // 115: getfield net/minecraft/util/Vec3.xCoord D
      // 118: aload 13
      // 11a: getfield net/minecraft/util/Vec3.xCoord D
      // 11d: invokestatic java/lang/Math.min (DD)D
      // 120: dconst_1
      // 121: dsub
      // 122: aload 12
      // 124: getfield net/minecraft/util/Vec3.yCoord D
      // 127: aload 13
      // 129: getfield net/minecraft/util/Vec3.yCoord D
      // 12c: invokestatic java/lang/Math.min (DD)D
      // 12f: dconst_1
      // 130: dsub
      // 131: aload 12
      // 133: getfield net/minecraft/util/Vec3.zCoord D
      // 136: aload 13
      // 138: getfield net/minecraft/util/Vec3.zCoord D
      // 13b: invokestatic java/lang/Math.min (DD)D
      // 13e: dconst_1
      // 13f: dsub
      // 140: aload 12
      // 142: getfield net/minecraft/util/Vec3.xCoord D
      // 145: aload 13
      // 147: getfield net/minecraft/util/Vec3.xCoord D
      // 14a: invokestatic java/lang/Math.max (DD)D
      // 14d: dconst_1
      // 14e: dadd
      // 14f: aload 12
      // 151: getfield net/minecraft/util/Vec3.yCoord D
      // 154: aload 13
      // 156: getfield net/minecraft/util/Vec3.yCoord D
      // 159: invokestatic java/lang/Math.max (DD)D
      // 15c: dconst_1
      // 15d: dadd
      // 15e: aload 12
      // 160: getfield net/minecraft/util/Vec3.zCoord D
      // 163: aload 13
      // 165: getfield net/minecraft/util/Vec3.zCoord D
      // 168: invokestatic java/lang/Math.max (DD)D
      // 16b: dconst_1
      // 16c: dadd
      // 16d: invokespecial net/minecraft/util/AxisAlignedBB.<init> (DDDDDD)V
      // 170: astore 16
      // 172: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 175: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 178: aload 3
      // 179: aload 16
      // 17b: getstatic net/minecraft/util/EntitySelectors.NOT_SPECTATING Lcom/google/common/base/Predicate;
      // 17e: invokedynamic apply ()Lcom/google/common/base/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/minecraft/entity/Entity.canBeCollidedWith ()Z, (Lnet/minecraft/entity/Entity;)Z ]
      // 183: invokestatic com/google/common/base/Predicates.and (Lcom/google/common/base/Predicate;Lcom/google/common/base/Predicate;)Lcom/google/common/base/Predicate;
      // 186: invokevirtual net/minecraft/client/multiplayer/WorldClient.getEntitiesInAABBexcluding (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/AxisAlignedBB;Lcom/google/common/base/Predicate;)Ljava/util/List;
      // 189: astore 17
      // 18b: aconst_null
      // 18c: astore 18
      // 18e: ldc2_w 1.7976931348623157E308
      // 191: dstore 19
      // 193: aload 17
      // 195: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 19a: astore 21
      // 19c: aload 21
      // 19e: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 1a3: ifeq 263
      // 1a6: aload 21
      // 1a8: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 1ad: checkcast net/minecraft/entity/Entity
      // 1b0: astore 22
      // 1b2: iload 2
      // 1b3: ifne 275
      // 1b6: aload 22
      // 1b8: iload 2
      // 1b9: ifne 1ce
      // 1bc: goto 1c0
      // 1bf: athrow
      // 1c0: aload 3
      // 1c1: if_acmpne 1cc
      // 1c4: goto 1c8
      // 1c7: athrow
      // 1c8: goto 19c
      // 1cb: athrow
      // 1cc: aload 22
      // 1ce: invokevirtual net/minecraft/entity/Entity.getCollisionBorderSize ()F
      // 1d1: fstore 23
      // 1d3: aload 22
      // 1d5: invokevirtual net/minecraft/entity/Entity.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 1d8: fload 23
      // 1da: f2d
      // 1db: fload 23
      // 1dd: f2d
      // 1de: fload 23
      // 1e0: f2d
      // 1e1: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 1e4: astore 24
      // 1e6: aload 24
      // 1e8: aload 12
      // 1ea: aload 13
      // 1ec: invokevirtual net/minecraft/util/AxisAlignedBB.calculateIntercept (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/MovingObjectPosition;
      // 1ef: astore 25
      // 1f1: aload 24
      // 1f3: aload 12
      // 1f5: invokevirtual net/minecraft/util/AxisAlignedBB.isVecInside (Lnet/minecraft/util/Vec3;)Z
      // 1f8: istore 26
      // 1fa: iload 26
      // 1fc: iload 2
      // 1fd: ifne 216
      // 200: ifne 214
      // 203: goto 207
      // 206: athrow
      // 207: aload 25
      // 209: ifnonnull 214
      // 20c: goto 210
      // 20f: athrow
      // 210: goto 19c
      // 213: athrow
      // 214: iload 26
      // 216: ifeq 21e
      // 219: dconst_0
      // 21a: goto 228
      // 21d: athrow
      // 21e: aload 12
      // 220: aload 25
      // 222: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 225: invokevirtual net/minecraft/util/Vec3.distanceTo (Lnet/minecraft/util/Vec3;)D
      // 228: dstore 27
      // 22a: dload 27
      // 22c: dload 14
      // 22e: dcmpl
      // 22f: iflt 236
      // 232: goto 19c
      // 235: athrow
      // 236: aload 22
      // 238: aload 3
      // 239: getfield net/minecraft/entity/Entity.ridingEntity Lnet/minecraft/entity/Entity;
      // 23c: if_acmpne 243
      // 23f: goto 19c
      // 242: athrow
      // 243: dload 27
      // 245: iload 2
      // 246: ifne 259
      // 249: dload 19
      // 24b: dcmpg
      // 24c: ifge 25f
      // 24f: goto 253
      // 252: athrow
      // 253: dload 27
      // 255: goto 259
      // 258: athrow
      // 259: dstore 19
      // 25b: aload 22
      // 25d: astore 18
      // 25f: iload 2
      // 260: ifeq 19c
      // 263: aload 18
      // 265: ifnull 275
      // 268: aload 0
      // 269: aload 18
      // 26b: invokevirtual x/oc87454ad996.ŧ (Lnet/minecraft/entity/Entity;)Z
      // 26e: ifne 276
      // 271: goto 275
      // 274: athrow
      // 275: return
      // 276: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 279: aload 6
      // 27b: putfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 27e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 281: aconst_null
      // 282: putfield net/minecraft/client/Minecraft.pointedEntity Lnet/minecraft/entity/Entity;
      // 285: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 288: getfield net/minecraft/client/Minecraft.entityRenderer Lnet/minecraft/client/renderer/EntityRenderer;
      // 28b: astore 12
      // 28d: aload 12
      // 28f: iload 2
      // 290: ifne 2a3
      // 293: instanceof x/oc65f19d876a
      // 296: ifeq 2a9
      // 299: goto 29d
      // 29c: athrow
      // 29d: aload 12
      // 29f: goto 2a3
      // 2a2: athrow
      // 2a3: aconst_null
      // 2a4: invokeinterface x/oc65f19d876a.setPointedEntity (Lnet/minecraft/entity/Entity;)V 2
      // 2a9: return
   }

   private MovingObjectPosition Ǒ(Entity var1, double var2, float var4) {
      Vec3 var5 = var1.getPositionEyes(var4);
      Vec3 var6 = var1.getLook(var4);
      Vec3 var7 = var5.addVector(var6.xCoord * var2, var6.yCoord * var2, var6.zCoord * var2);
      return occb1ed1ed8f.ǘ(var5, var7, this.Ҕ.ǭ(), this.ǳ.ǭ());
   }

   private boolean ӕ() {
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
      // 09: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 0c: astore 2
      // 0d: istore 1
      // 0e: getstatic x/oc6eb2930568.Į [I
      // 11: aload 2
      // 12: invokestatic x/oc87454ad996.Ύ (Lnet/minecraft/item/ItemStack;)Lx/oc25e0b6a6a2;
      // 15: invokevirtual java/lang/Enum.ordinal ()I
      // 18: iaload
      // 19: iload 1
      // 1a: ifne 7d
      // 1d: tableswitch 89 1 6 40 49 57 65 73 81
      // 44: athrow
      // 45: aload 0
      // 46: getfield x/oc87454ad996.Ğ Lx/occ2f8dff8d8;
      // 49: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 4c: ireturn
      // 4d: athrow
      // 4e: aload 0
      // 4f: getfield x/oc87454ad996.ì Lx/occ2f8dff8d8;
      // 52: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 55: ireturn
      // 56: aload 0
      // 57: getfield x/oc87454ad996.ъ Lx/occ2f8dff8d8;
      // 5a: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 5d: ireturn
      // 5e: aload 0
      // 5f: getfield x/oc87454ad996.Ʈ Lx/occ2f8dff8d8;
      // 62: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 65: ireturn
      // 66: aload 0
      // 67: getfield x/oc87454ad996.Ɨ Lx/occ2f8dff8d8;
      // 6a: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 6d: ireturn
      // 6e: aload 0
      // 6f: getfield x/oc87454ad996.Ƽ Lx/occ2f8dff8d8;
      // 72: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 75: ireturn
      // 76: aload 0
      // 77: getfield x/oc87454ad996.ќ Lx/occ2f8dff8d8;
      // 7a: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 7d: ireturn
   }

   private boolean ŧ(Entity var1) {
      EntityPlayer var3 = null;
      int var4 = -1061529399 ^ 464719321;
      int var2 = oc84f20a0bc5.ė;

      while (true) {
         switch (var4) {
            case -2103486785:
               break;
            case -1978682252:
               return this.Ǻ.ǭ();
            case -1156151130:
               return this.θ.ǭ();
            case -620145392:
               int var9;
               label92: {
                  label91: {
                     try {
                        var9 = var1 instanceof EntityPlayer;
                        if (var2 != 0) {
                           break label92;
                        }

                        if (var9 != 0) {
                           break label91;
                        }
                     } catch (ocbde1165e4e var8) {
                        throw var8;
                     }

                     var4 = 2129359040 ^ 464719321;
                     if (var2 == 0) {
                        continue;
                     }
                  }

                  var9 = -1725146266 ^ 464719321;
               }

               var4 = var9;
               if (var2 == 0) {
                  continue;
               }
            case -1448722287:
               int var10;
               label61: {
                  label60: {
                     try {
                        var10 = oc7ab2161b9f.ӥ(var3);
                        if (var2 != 0) {
                           break label61;
                        }

                        if (var10 == 0) {
                           break label60;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var4 = -1599765121 ^ 464719321;
                     if (var2 == 0) {
                        continue;
                     }
                  }

                  var10 = 2082858033 ^ 464719321;
               }

               var4 = var10;
               if (var2 == 0) {
                  continue;
               }

               return this.Β.ǭ();
            case 1089051654:
               int var10000;
               label77: {
                  label76: {
                     try {
                        var10000 = oc7ab2161b9f.Ӭ(var3);
                        if (var2 != 0) {
                           break label77;
                        }

                        if (var10000 != 0) {
                           break label76;
                        }
                     } catch (ocbde1165e4e var7) {
                        throw var7;
                     }

                     var4 = -1307226808 ^ 464719321;
                     if (var2 == 0) {
                        continue;
                     }
                  }

                  var10000 = -1599765121 ^ 464719321;
               }

               var4 = var10000;
               if (var2 == 0) {
                  continue;
               }
               break;
            case 1700298009:
               return this.Β.ǭ();
            case 1737943528:
               return this.Ҩ.ǭ();
            default:
               throw null;
         }

         var3 = (EntityPlayer)var1;

         label67: {
            try {
               if (var2 != 0) {
                  continue;
               }

               if (!oca4f99d2d44.Λ(var3)) {
                  break label67;
               }
            } catch (ocbde1165e4e var6) {
               throw var6;
            }

            var4 = -1849902675 ^ 464719321;
            if (var2 == 0) {
               continue;
            }
         }

         var4 = 1532662239 ^ 464719321;
      }
   }

   private static oc25e0b6a6a2 Ύ(ItemStack param0) {
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
      // 06: ifne 16
      // 09: ifnonnull 15
      // 0c: goto 10
      // 0f: athrow
      // 10: getstatic x/oc25e0b6a6a2.ˁ Lx/oc25e0b6a6a2;
      // 13: areturn
      // 14: athrow
      // 15: aload 0
      // 16: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 19: astore 2
      // 1a: aload 2
      // 1b: iload 1
      // 1c: ifne 2f
      // 1f: instanceof net/minecraft/item/ItemSword
      // 22: ifeq 2e
      // 25: goto 29
      // 28: athrow
      // 29: getstatic x/oc25e0b6a6a2.Ь Lx/oc25e0b6a6a2;
      // 2c: areturn
      // 2d: athrow
      // 2e: aload 2
      // 2f: iload 1
      // 30: ifne 42
      // 33: instanceof net/minecraft/item/ItemTool
      // 36: ifne 63
      // 39: goto 3d
      // 3c: athrow
      // 3d: aload 2
      // 3e: goto 42
      // 41: athrow
      // 42: iload 1
      // 43: ifne 55
      // 46: instanceof net/minecraft/item/ItemHoe
      // 49: ifne 63
      // 4c: goto 50
      // 4f: athrow
      // 50: aload 2
      // 51: goto 55
      // 54: athrow
      // 55: iload 1
      // 56: ifne 69
      // 59: instanceof net/minecraft/item/ItemShears
      // 5c: ifeq 68
      // 5f: goto 63
      // 62: athrow
      // 63: getstatic x/oc25e0b6a6a2.Ƕ Lx/oc25e0b6a6a2;
      // 66: areturn
      // 67: athrow
      // 68: aload 2
      // 69: iload 1
      // 6a: ifne 7d
      // 6d: instanceof net/minecraft/item/ItemBucket
      // 70: ifeq 7c
      // 73: goto 77
      // 76: athrow
      // 77: getstatic x/oc25e0b6a6a2.ս Lx/oc25e0b6a6a2;
      // 7a: areturn
      // 7b: athrow
      // 7c: aload 2
      // 7d: iload 1
      // 7e: ifne 91
      // 81: instanceof net/minecraft/item/ItemFlintAndSteel
      // 84: ifeq 90
      // 87: goto 8b
      // 8a: athrow
      // 8b: getstatic x/oc25e0b6a6a2.ϗ Lx/oc25e0b6a6a2;
      // 8e: areturn
      // 8f: athrow
      // 90: aload 2
      // 91: iload 1
      // 92: ifne a4
      // 95: instanceof net/minecraft/item/ItemBlock
      // 98: ifeq b5
      // 9b: goto 9f
      // 9e: athrow
      // 9f: aload 2
      // a0: goto a4
      // a3: athrow
      // a4: checkcast net/minecraft/item/ItemBlock
      // a7: invokevirtual net/minecraft/item/ItemBlock.getBlock ()Lnet/minecraft/block/Block;
      // aa: getstatic net/minecraft/init/Blocks.web Lnet/minecraft/block/Block;
      // ad: if_acmpne b5
      // b0: getstatic x/oc25e0b6a6a2.Ť Lx/oc25e0b6a6a2;
      // b3: areturn
      // b4: athrow
      // b5: getstatic x/oc25e0b6a6a2.ƿ Lx/oc25e0b6a6a2;
      // b8: areturn
   }
}

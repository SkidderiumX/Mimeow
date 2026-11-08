package x;

public class ocf906b7c70b extends oc69da1aa7f5 {
   private oca9cc61aada Ԣ;
   private occc831eff22 Ǎ;
   private occ2f8dff8d8 Ԧ;
   private occ2f8dff8d8 Ǡ;
   private occ2f8dff8d8 Ӷ;
   private occ2f8dff8d8 Ƅ;
   private occ2f8dff8d8 ӄ;
   private int Α = -1;
   private String[] Ρ;
   public static int Ф;

   public ocf906b7c70b() {
      super("Piercing", oce4cea752dd.ȁ);
      String[] var10001 = new String[1831697000 ^ 1831697002];
      var10001[0] = "Hurt time";
      var10001[1] = "Health";
      this.Ρ = var10001;
      this.ą("Allows you to hit through entities.");
      this.ʌ(this.Ԣ = new oca9cc61aada("Sort mode", 0, this.Ρ));
      this.ʌ(this.Ǎ = new occc831eff22("Filter"));
      this.ʌ(this.Ԧ = new occ2f8dff8d8(this.Ǎ, "Ignore blocks", false));
      this.ʌ(this.Ӷ = new occ2f8dff8d8(this.Ǎ, "Ignore non-players", true));
      this.ʌ(this.Ǡ = new occ2f8dff8d8(this.Ǎ, "Ignore teammates", true));
      this.ʌ(this.Ƅ = new occ2f8dff8d8(this.Ǎ, "Weapon only", false));
      this.ʌ(this.ӄ = new occ2f8dff8d8(this.Ǎ, "Inside hitbox only", false));
   }

   @Override
   public String getInfo() {
      return this.Ρ[(int)this.Ԣ.Ӂ()];
   }

   public boolean Ϧ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
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
      // 1c: ifnull 41
      // 1f: goto 23
      // 22: athrow
      // 23: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 26: iload 1
      // 27: ifne 3b
      // 2a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 2d: ifnull 41
      // 30: goto 34
      // 33: athrow
      // 34: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 37: goto 3b
      // 3a: athrow
      // 3b: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 3e: ifnonnull 44
      // 41: bipush 0
      // 42: ireturn
      // 43: athrow
      // 44: aload 0
      // 45: getfield x/ocf906b7c70b.Ƅ Lx/occ2f8dff8d8;
      // 48: iload 1
      // 49: ifne 6f
      // 4c: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 4f: ifeq 6b
      // 52: goto 56
      // 55: athrow
      // 56: invokestatic x/oc7ab2161b9f.Ȓ ()Z
      // 59: iload 1
      // 5a: ifne 72
      // 5d: goto 61
      // 60: athrow
      // 61: ifne 6b
      // 64: goto 68
      // 67: athrow
      // 68: bipush 0
      // 69: ireturn
      // 6a: athrow
      // 6b: aload 0
      // 6c: getfield x/ocf906b7c70b.Ԧ Lx/occ2f8dff8d8;
      // 6f: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 72: iload 1
      // 73: ifne aa
      // 76: ifne a5
      // 79: goto 7d
      // 7c: athrow
      // 7d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 80: iload 1
      // 81: ifne 99
      // 84: goto 88
      // 87: athrow
      // 88: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 8b: ifnull a5
      // 8e: goto 92
      // 91: athrow
      // 92: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 95: goto 99
      // 98: athrow
      // 99: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 9c: getfield net/minecraft/util/MovingObjectPosition.typeOfHit Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 9f: getstatic net/minecraft/util/MovingObjectPosition$MovingObjectType.BLOCK Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // a2: if_acmpeq ad
      // a5: bipush 1
      // a6: goto aa
      // a9: athrow
      // aa: goto ae
      // ad: bipush 0
      // ae: ireturn
   }

   public void Ŏ(float param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 16
      // 09: invokevirtual x/ocf906b7c70b.Ϧ ()Z
      // 0c: ifne 15
      // 0f: goto 13
      // 12: athrow
      // 13: return
      // 14: athrow
      // 15: aload 0
      // 16: fload 1
      // 17: invokevirtual x/ocf906b7c70b.і (F)V
      // 1a: return
   }

   private void і(float param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: getstatic x/oc5e549848f3.İ I
      // 003: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 006: invokevirtual net/minecraft/client/Minecraft.getRenderViewEntity ()Lnet/minecraft/entity/Entity;
      // 009: astore 3
      // 00a: istore 2
      // 00b: aload 3
      // 00c: ifnull 024
      // 00f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 012: iload 2
      // 013: ifne 029
      // 016: goto 01a
      // 019: athrow
      // 01a: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 01d: ifnonnull 026
      // 020: goto 024
      // 023: athrow
      // 024: return
      // 025: athrow
      // 026: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 029: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 02c: invokevirtual net/minecraft/client/multiplayer/PlayerControllerMP.getBlockReachDistance ()F
      // 02f: f2d
      // 030: dstore 4
      // 032: aload 3
      // 033: fload 1
      // 034: invokevirtual net/minecraft/entity/Entity.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 037: astore 6
      // 039: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 03c: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 03f: invokevirtual net/minecraft/client/multiplayer/PlayerControllerMP.extendedReach ()Z
      // 042: ifeq 04a
      // 045: ldc2_w 6.0
      // 048: dstore 4
      // 04a: aload 3
      // 04b: fload 1
      // 04c: invokevirtual net/minecraft/entity/Entity.getLook (F)Lnet/minecraft/util/Vec3;
      // 04f: astore 7
      // 051: aload 6
      // 053: aload 7
      // 055: getfield net/minecraft/util/Vec3.xCoord D
      // 058: dload 4
      // 05a: dmul
      // 05b: aload 7
      // 05d: getfield net/minecraft/util/Vec3.yCoord D
      // 060: dload 4
      // 062: dmul
      // 063: aload 7
      // 065: getfield net/minecraft/util/Vec3.zCoord D
      // 068: dload 4
      // 06a: dmul
      // 06b: invokevirtual net/minecraft/util/Vec3.addVector (DDD)Lnet/minecraft/util/Vec3;
      // 06e: astore 8
      // 070: aconst_null
      // 071: astore 9
      // 073: aconst_null
      // 074: astore 10
      // 076: ldc2_w 1.7976931348623157E308
      // 079: dstore 11
      // 07b: bipush 0
      // 07c: istore 13
      // 07e: ldc 1683208108
      // 080: ldc 464275539
      // 082: ixor
      // 083: istore 14
      // 085: ldc Infinity
      // 087: fstore 15
      // 089: aload 0
      // 08a: getfield x/ocf906b7c70b.Ԣ Lx/oca9cc61aada;
      // 08d: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 090: d2i
      // 091: istore 16
      // 093: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 096: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 099: aload 3
      // 09a: aload 3
      // 09b: invokevirtual net/minecraft/entity/Entity.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 09e: aload 7
      // 0a0: getfield net/minecraft/util/Vec3.xCoord D
      // 0a3: dload 4
      // 0a5: dmul
      // 0a6: aload 7
      // 0a8: getfield net/minecraft/util/Vec3.yCoord D
      // 0ab: dload 4
      // 0ad: dmul
      // 0ae: aload 7
      // 0b0: getfield net/minecraft/util/Vec3.zCoord D
      // 0b3: dload 4
      // 0b5: dmul
      // 0b6: invokevirtual net/minecraft/util/AxisAlignedBB.addCoord (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 0b9: dconst_1
      // 0ba: dconst_1
      // 0bb: dconst_1
      // 0bc: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 0bf: getstatic net/minecraft/util/EntitySelectors.NOT_SPECTATING Lcom/google/common/base/Predicate;
      // 0c2: invokedynamic apply ()Lcom/google/common/base/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, net/minecraft/entity/Entity.canBeCollidedWith ()Z, (Lnet/minecraft/entity/Entity;)Z ]
      // 0c7: invokestatic com/google/common/base/Predicates.and (Lcom/google/common/base/Predicate;Lcom/google/common/base/Predicate;)Lcom/google/common/base/Predicate;
      // 0ca: invokevirtual net/minecraft/client/multiplayer/WorldClient.getEntitiesInAABBexcluding (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/AxisAlignedBB;Lcom/google/common/base/Predicate;)Ljava/util/List;
      // 0cd: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 0d2: astore 17
      // 0d4: aload 17
      // 0d6: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0db: ifeq 435
      // 0de: aload 17
      // 0e0: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0e5: checkcast net/minecraft/entity/Entity
      // 0e8: astore 18
      // 0ea: iload 2
      // 0eb: ifne 4a1
      // 0ee: aload 0
      // 0ef: iload 2
      // 0f0: ifne 119
      // 0f3: goto 0f7
      // 0f6: athrow
      // 0f7: getfield x/ocf906b7c70b.Ӷ Lx/occ2f8dff8d8;
      // 0fa: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0fd: ifeq 118
      // 100: goto 104
      // 103: athrow
      // 104: aload 18
      // 106: instanceof net/minecraft/entity/player/EntityPlayer
      // 109: iload 2
      // 10a: ifne 11f
      // 10d: goto 111
      // 110: athrow
      // 111: ifeq 0d4
      // 114: goto 118
      // 117: athrow
      // 118: aload 0
      // 119: getfield x/ocf906b7c70b.Ǡ Lx/occ2f8dff8d8;
      // 11c: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 11f: iload 2
      // 120: ifne 147
      // 123: ifeq 13e
      // 126: goto 12a
      // 129: athrow
      // 12a: aload 18
      // 12c: iload 2
      // 12d: ifne 144
      // 130: goto 134
      // 133: athrow
      // 134: invokestatic x/oc7ab2161b9f.ӥ (Lnet/minecraft/entity/Entity;)Z
      // 137: ifne 0d4
      // 13a: goto 13e
      // 13d: athrow
      // 13e: aload 18
      // 140: iload 2
      // 141: ifne 14c
      // 144: invokestatic x/oca4f99d2d44.Λ (Lnet/minecraft/entity/Entity;)Z
      // 147: ifne 0d4
      // 14a: aload 18
      // 14c: iload 2
      // 14d: ifne 17b
      // 150: instanceof net/minecraft/entity/player/EntityPlayer
      // 153: ifeq 179
      // 156: goto 15a
      // 159: athrow
      // 15a: aload 18
      // 15c: iload 2
      // 15d: ifne 17b
      // 160: goto 164
      // 163: athrow
      // 164: checkcast net/minecraft/entity/player/EntityPlayer
      // 167: invokestatic x/oc7ab2161b9f.Ӭ (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // 16a: ifeq 179
      // 16d: goto 171
      // 170: athrow
      // 171: iload 2
      // 172: ifeq 0d4
      // 175: goto 179
      // 178: athrow
      // 179: aload 18
      // 17b: invokevirtual net/minecraft/entity/Entity.getCollisionBorderSize ()F
      // 17e: fstore 19
      // 180: aload 18
      // 182: invokevirtual net/minecraft/entity/Entity.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 185: fload 19
      // 187: f2d
      // 188: fload 19
      // 18a: f2d
      // 18b: fload 19
      // 18d: f2d
      // 18e: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 191: astore 20
      // 193: aload 20
      // 195: aload 6
      // 197: aload 8
      // 199: invokevirtual net/minecraft/util/AxisAlignedBB.calculateIntercept (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/MovingObjectPosition;
      // 19c: astore 21
      // 19e: aload 20
      // 1a0: aload 6
      // 1a2: invokevirtual net/minecraft/util/AxisAlignedBB.isVecInside (Lnet/minecraft/util/Vec3;)Z
      // 1a5: istore 22
      // 1a7: iload 22
      // 1a9: iload 2
      // 1aa: ifne 1c3
      // 1ad: ifne 1c1
      // 1b0: goto 1b4
      // 1b3: athrow
      // 1b4: aload 21
      // 1b6: ifnonnull 1c1
      // 1b9: goto 1bd
      // 1bc: athrow
      // 1bd: goto 0d4
      // 1c0: athrow
      // 1c1: iload 22
      // 1c3: ifeq 1cb
      // 1c6: dconst_0
      // 1c7: goto 1d5
      // 1ca: athrow
      // 1cb: aload 6
      // 1cd: aload 21
      // 1cf: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 1d2: invokevirtual net/minecraft/util/Vec3.distanceTo (Lnet/minecraft/util/Vec3;)D
      // 1d5: dstore 23
      // 1d7: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1da: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 1dd: invokevirtual net/minecraft/client/multiplayer/PlayerControllerMP.extendedReach ()Z
      // 1e0: iload 2
      // 1e1: ifne 211
      // 1e4: ifne 204
      // 1e7: goto 1eb
      // 1ea: athrow
      // 1eb: dload 23
      // 1ed: iload 2
      // 1ee: ifne 206
      // 1f1: goto 1f5
      // 1f4: athrow
      // 1f5: ldc2_w 3.0
      // 1f8: dcmpl
      // 1f9: ifle 204
      // 1fc: goto 200
      // 1ff: athrow
      // 200: goto 0d4
      // 203: athrow
      // 204: dload 23
      // 206: dload 4
      // 208: iload 2
      // 209: ifne 21b
      // 20c: dcmpl
      // 20d: goto 211
      // 210: athrow
      // 211: ifle 217
      // 214: goto 0d4
      // 217: dload 23
      // 219: dload 11
      // 21b: dcmpl
      // 21c: iload 2
      // 21d: ifne 231
      // 220: iflt 22a
      // 223: goto 227
      // 226: athrow
      // 227: goto 0d4
      // 22a: aload 0
      // 22b: getfield x/ocf906b7c70b.ӄ Lx/occ2f8dff8d8;
      // 22e: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 231: iload 2
      // 232: ifne 246
      // 235: ifeq 24c
      // 238: goto 23c
      // 23b: athrow
      // 23c: dload 23
      // 23e: ldc2_w 0.10000000149011612
      // 241: dcmpl
      // 242: goto 246
      // 245: athrow
      // 246: ifle 24c
      // 249: goto 0d4
      // 24c: aload 18
      // 24e: iload 2
      // 24f: ifne 286
      // 252: aload 3
      // 253: getfield net/minecraft/entity/Entity.ridingEntity Lnet/minecraft/entity/Entity;
      // 256: if_acmpne 284
      // 259: goto 25d
      // 25c: athrow
      // 25d: aload 3
      // 25e: iload 2
      // 25f: ifne 286
      // 262: goto 266
      // 265: athrow
      // 266: invokevirtual net/minecraft/entity/Entity.canRiderInteract ()Z
      // 269: ifne 284
      // 26c: goto 270
      // 26f: athrow
      // 270: aload 9
      // 272: iload 2
      // 273: ifne 286
      // 276: goto 27a
      // 279: athrow
      // 27a: ifnull 284
      // 27d: goto 281
      // 280: athrow
      // 281: goto 0d4
      // 284: aload 18
      // 286: instanceof net/minecraft/entity/EntityLivingBase
      // 289: istore 25
      // 28b: iload 25
      // 28d: iload 2
      // 28e: ifne 2a4
      // 291: ifeq 2a7
      // 294: goto 298
      // 297: athrow
      // 298: aload 18
      // 29a: checkcast net/minecraft/entity/EntityLivingBase
      // 29d: getfield net/minecraft/entity/EntityLivingBase.hurtTime I
      // 2a0: goto 2a4
      // 2a3: athrow
      // 2a4: goto 2ac
      // 2a7: ldc 1683208108
      // 2a9: ldc 464275539
      // 2ab: ixor
      // 2ac: istore 26
      // 2ae: iload 25
      // 2b0: ifeq 2bf
      // 2b3: aload 18
      // 2b5: checkcast net/minecraft/entity/EntityLivingBase
      // 2b8: invokevirtual net/minecraft/entity/EntityLivingBase.getHealth ()F
      // 2bb: goto 2c1
      // 2be: athrow
      // 2bf: ldc Infinity
      // 2c1: fstore 27
      // 2c3: iload 2
      // 2c4: bipush 0
      // 2c5: istore 28
      // 2c7: ifne 2d6
      // 2ca: aload 9
      // 2cc: ifnonnull 2da
      // 2cf: goto 2d3
      // 2d2: athrow
      // 2d3: bipush 1
      // 2d4: istore 28
      // 2d6: iload 2
      // 2d7: ifeq 3e5
      // 2da: iload 25
      // 2dc: iload 2
      // 2dd: ifne 309
      // 2e0: goto 2e4
      // 2e3: athrow
      // 2e4: ifeq 303
      // 2e7: goto 2eb
      // 2ea: athrow
      // 2eb: iload 13
      // 2ed: iload 2
      // 2ee: ifne 309
      // 2f1: goto 2f5
      // 2f4: athrow
      // 2f5: ifne 303
      // 2f8: goto 2fc
      // 2fb: athrow
      // 2fc: bipush 1
      // 2fd: istore 28
      // 2ff: iload 2
      // 300: ifeq 3e5
      // 303: iload 25
      // 305: goto 309
      // 308: athrow
      // 309: iload 2
      // 30a: ifne 3e7
      // 30d: iload 13
      // 30f: if_icmpne 3e5
      // 312: goto 316
      // 315: athrow
      // 316: iload 25
      // 318: iload 2
      // 319: ifne 34c
      // 31c: goto 320
      // 31f: athrow
      // 320: ifne 346
      // 323: goto 327
      // 326: athrow
      // 327: dload 23
      // 329: dload 11
      // 32b: dcmpg
      // 32c: iload 2
      // 32d: ifne 33c
      // 330: goto 334
      // 333: athrow
      // 334: ifge 33f
      // 337: goto 33b
      // 33a: athrow
      // 33b: bipush 1
      // 33c: goto 340
      // 33f: bipush 0
      // 340: istore 28
      // 342: iload 2
      // 343: ifeq 3e5
      // 346: iload 16
      // 348: goto 34c
      // 34b: athrow
      // 34c: iload 2
      // 34d: ifne 3b0
      // 350: ifne 39f
      // 353: goto 357
      // 356: athrow
      // 357: iload 26
      // 359: iload 2
      // 35a: ifne 377
      // 35d: goto 361
      // 360: athrow
      // 361: iload 14
      // 363: if_icmpge 371
      // 366: goto 36a
      // 369: athrow
      // 36a: bipush 1
      // 36b: istore 28
      // 36d: iload 2
      // 36e: ifeq 3e5
      // 371: iload 26
      // 373: goto 377
      // 376: athrow
      // 377: iload 2
      // 378: ifne 3e7
      // 37b: iload 14
      // 37d: if_icmpne 3e5
      // 380: goto 384
      // 383: athrow
      // 384: dload 23
      // 386: dload 11
      // 388: dcmpg
      // 389: iload 2
      // 38a: ifne 3e7
      // 38d: goto 391
      // 390: athrow
      // 391: ifge 3e5
      // 394: goto 398
      // 397: athrow
      // 398: bipush 1
      // 399: istore 28
      // 39b: iload 2
      // 39c: ifeq 3e5
      // 39f: fload 27
      // 3a1: fload 15
      // 3a3: iload 2
      // 3a4: ifne 3c2
      // 3a7: goto 3ab
      // 3aa: athrow
      // 3ab: fcmpg
      // 3ac: goto 3b0
      // 3af: athrow
      // 3b0: ifge 3ba
      // 3b3: bipush 1
      // 3b4: istore 28
      // 3b6: iload 2
      // 3b7: ifeq 3e5
      // 3ba: fload 27
      // 3bc: fload 15
      // 3be: goto 3c2
      // 3c1: athrow
      // 3c2: fcmpl
      // 3c3: iload 2
      // 3c4: ifne 3e7
      // 3c7: ifne 3e5
      // 3ca: goto 3ce
      // 3cd: athrow
      // 3ce: dload 23
      // 3d0: dload 11
      // 3d2: dcmpg
      // 3d3: iload 2
      // 3d4: ifne 3e7
      // 3d7: goto 3db
      // 3da: athrow
      // 3db: ifge 3e5
      // 3de: goto 3e2
      // 3e1: athrow
      // 3e2: bipush 1
      // 3e3: istore 28
      // 3e5: iload 28
      // 3e7: iload 2
      // 3e8: ifne 3f8
      // 3eb: ifeq 431
      // 3ee: goto 3f2
      // 3f1: athrow
      // 3f2: aload 18
      // 3f4: astore 9
      // 3f6: iload 22
      // 3f8: ifeq 41a
      // 3fb: aload 21
      // 3fd: iload 2
      // 3fe: ifne 414
      // 401: goto 405
      // 404: athrow
      // 405: ifnonnull 412
      // 408: goto 40c
      // 40b: athrow
      // 40c: aload 6
      // 40e: goto 41f
      // 411: athrow
      // 412: aload 21
      // 414: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 417: goto 41f
      // 41a: aload 21
      // 41c: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 41f: astore 10
      // 421: dload 23
      // 423: dstore 11
      // 425: iload 25
      // 427: istore 13
      // 429: iload 26
      // 42b: istore 14
      // 42d: fload 27
      // 42f: fstore 15
      // 431: iload 2
      // 432: ifeq 0d4
      // 435: aload 9
      // 437: iload 2
      // 438: ifne 4a3
      // 43b: ifnull 4a1
      // 43e: goto 442
      // 441: athrow
      // 442: dload 4
      // 444: iload 2
      // 445: ifne 45d
      // 448: goto 44c
      // 44b: athrow
      // 44c: ldc2_w 3.0
      // 44f: dcmpl
      // 450: ifle 4a1
      // 453: goto 457
      // 456: athrow
      // 457: dload 11
      // 459: goto 45d
      // 45c: athrow
      // 45d: ldc2_w 3.0
      // 460: dcmpl
      // 461: iload 2
      // 462: ifne 481
      // 465: ifle 4a1
      // 468: goto 46c
      // 46b: athrow
      // 46c: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 46f: iload 2
      // 470: ifne 487
      // 473: goto 477
      // 476: athrow
      // 477: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 47a: invokevirtual net/minecraft/client/multiplayer/PlayerControllerMP.extendedReach ()Z
      // 47d: goto 481
      // 480: athrow
      // 481: ifne 4a1
      // 484: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 487: new net/minecraft/util/MovingObjectPosition
      // 48a: dup
      // 48b: getstatic net/minecraft/util/MovingObjectPosition$MovingObjectType.MISS Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 48e: aload 10
      // 490: aconst_null
      // 491: new net/minecraft/util/BlockPos
      // 494: dup
      // 495: aload 10
      // 497: invokespecial net/minecraft/util/BlockPos.<init> (Lnet/minecraft/util/Vec3;)V
      // 49a: invokespecial net/minecraft/util/MovingObjectPosition.<init> (Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;Lnet/minecraft/util/Vec3;Lnet/minecraft/util/EnumFacing;Lnet/minecraft/util/BlockPos;)V
      // 49d: putfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 4a0: return
      // 4a1: aload 9
      // 4a3: iload 2
      // 4a4: ifne 4cd
      // 4a7: ifnull 4eb
      // 4aa: goto 4ae
      // 4ad: athrow
      // 4ae: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 4b1: iload 2
      // 4b2: ifne 4e6
      // 4b5: goto 4b9
      // 4b8: athrow
      // 4b9: new net/minecraft/util/MovingObjectPosition
      // 4bc: dup
      // 4bd: aload 9
      // 4bf: aload 10
      // 4c1: invokespecial net/minecraft/util/MovingObjectPosition.<init> (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/Vec3;)V
      // 4c4: putfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 4c7: aload 9
      // 4c9: goto 4cd
      // 4cc: athrow
      // 4cd: instanceof net/minecraft/entity/EntityLivingBase
      // 4d0: ifne 4df
      // 4d3: aload 9
      // 4d5: instanceof net/minecraft/entity/item/EntityItemFrame
      // 4d8: ifeq 4eb
      // 4db: goto 4df
      // 4de: athrow
      // 4df: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 4e2: goto 4e6
      // 4e5: athrow
      // 4e6: aload 9
      // 4e8: putfield net/minecraft/client/Minecraft.pointedEntity Lnet/minecraft/entity/Entity;
      // 4eb: return
   }
}

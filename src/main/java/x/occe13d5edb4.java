package x;

import java.awt.Color;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import org.lwjgl.opengl.GL11;

public class occe13d5edb4 extends oc69da1aa7f5 {
   public static oca9cc61aada Ԁ;
   public occ2f8dff8d8 Ӛ;
   public occ2f8dff8d8 Ѻ;
   public occ2f8dff8d8 ԇ;
   private Entity ǆ;
   private MovingObjectPosition Ğ;
   public static boolean ǧ;

   public occe13d5edb4() {
      super("Hitboxes", oce4cea752dd.ȁ, 0);
      this.ą("Expands entity hitboxes.");
      this.ʌ(Ԁ = new oca9cc61aada("Multiplier", "x", 1.2, 1.0, 5.0, 0.05));
      this.ʌ(this.Ѻ = new occ2f8dff8d8("Players only", true));
      this.ʌ(this.Ӛ = new occ2f8dff8d8("Show new hitbox", false));
      this.ʌ(this.ԇ = new occ2f8dff8d8("Weapon only", false));
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
      // 03: istore 1
      // 04: getstatic x/occe13d5edb4.Ԁ Lx/oca9cc61aada;
      // 07: iload 1
      // 08: ifne 31
      // 0b: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0e: d2i
      // 0f: i2d
      // 10: getstatic x/occe13d5edb4.Ԁ Lx/oca9cc61aada;
      // 13: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 16: dcmpl
      // 17: ifne 2e
      // 1a: goto 1e
      // 1d: athrow
      // 1e: getstatic x/occe13d5edb4.Ԁ Lx/oca9cc61aada;
      // 21: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 24: d2i
      // 25: invokedynamic makeConcatWithConstants (I)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001" ]
      // 2a: goto 37
      // 2d: athrow
      // 2e: getstatic x/occe13d5edb4.Ԁ Lx/oca9cc61aada;
      // 31: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 34: invokestatic java/lang/Double.valueOf (D)Ljava/lang/Double;
      // 37: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 3a: getstatic x/occe13d5edb4.Ԁ Lx/oca9cc61aada;
      // 3d: invokevirtual x/oca9cc61aada.Ĝ ()Ljava/lang/String;
      // 40: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 45: areturn
   }

   @oc66fa4f2195
   public void ҙ(MouseEvent param1) {
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
      // 0c: ifne 6c
      // 0f: goto 13
      // 12: athrow
      // 13: aload 1
      // 14: goto 18
      // 17: athrow
      // 18: getfield x/MouseEvent.buttonstate Z
      // 1b: iload 2
      // 1c: ifne 29
      // 1f: ifeq 6c
      // 22: goto 26
      // 25: athrow
      // 26: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 29: iload 2
      // 2a: ifne 40
      // 2d: ifeq 6c
      // 30: goto 34
      // 33: athrow
      // 34: getstatic x/occe13d5edb4.Ԁ Lx/oca9cc61aada;
      // 37: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 3a: dconst_1
      // 3b: dcmpl
      // 3c: goto 40
      // 3f: athrow
      // 40: iload 2
      // 41: ifne 60
      // 44: ifeq 6c
      // 47: goto 4b
      // 4a: athrow
      // 4b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 4e: iload 2
      // 4f: ifne 66
      // 52: goto 56
      // 55: athrow
      // 56: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 59: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isBlocking ()Z
      // 5c: goto 60
      // 5f: athrow
      // 60: ifne 6c
      // 63: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 66: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 69: ifnull 6e
      // 6c: return
      // 6d: athrow
      // 6e: aload 0
      // 6f: iload 2
      // 70: ifne 8d
      // 73: getfield x/occe13d5edb4.ԇ Lx/occ2f8dff8d8;
      // 76: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 79: ifeq 8c
      // 7c: goto 80
      // 7f: athrow
      // 80: invokestatic x/oc7ab2161b9f.Ȓ ()Z
      // 83: ifne 8c
      // 86: goto 8a
      // 89: athrow
      // 8a: return
      // 8b: athrow
      // 8c: aload 0
      // 8d: fconst_1
      // 8e: invokevirtual x/occe13d5edb4.Ȝ (F)Lnet/minecraft/entity/Entity;
      // 91: astore 3
      // 92: aload 3
      // 93: iload 2
      // 94: ifne a0
      // 97: ifnonnull 9f
      // 9a: goto 9e
      // 9d: athrow
      // 9e: return
      // 9f: aload 3
      // a0: instanceof net/minecraft/entity/player/EntityPlayer
      // a3: iload 2
      // a4: ifne c5
      // a7: ifeq be
      // aa: goto ae
      // ad: athrow
      // ae: aload 3
      // af: checkcast net/minecraft/entity/player/EntityPlayer
      // b2: invokestatic x/oc7ab2161b9f.Ӭ (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // b5: ifeq c9
      // b8: goto bc
      // bb: athrow
      // bc: return
      // bd: athrow
      // be: aload 0
      // bf: getfield x/occe13d5edb4.Ѻ Lx/occ2f8dff8d8;
      // c2: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // c5: ifeq c9
      // c8: return
      // c9: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // cc: aload 0
      // cd: getfield x/occe13d5edb4.Ğ Lnet/minecraft/util/MovingObjectPosition;
      // d0: putfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // d3: return
   }

   @oc66fa4f2195
   public void ʁ(oc746a23b244 param1) {
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
      // 05: getfield x/occe13d5edb4.Ӛ Lx/occ2f8dff8d8;
      // 08: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0b: iload 2
      // 0c: ifne 19
      // 0f: ifeq ae
      // 12: goto 16
      // 15: athrow
      // 16: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 19: ifeq ae
      // 1c: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1f: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 22: getfield net/minecraft/client/multiplayer/WorldClient.loadedEntityList Ljava/util/List;
      // 25: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 2a: astore 3
      // 2b: aload 3
      // 2c: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 31: ifeq ae
      // 34: aload 3
      // 35: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 3a: checkcast net/minecraft/entity/Entity
      // 3d: astore 4
      // 3f: aload 4
      // 41: iload 2
      // 42: ifne 58
      // 45: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 48: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 4b: if_acmpeq aa
      // 4e: goto 52
      // 51: athrow
      // 52: aload 4
      // 54: goto 58
      // 57: athrow
      // 58: iload 2
      // 59: ifne 6c
      // 5c: instanceof net/minecraft/entity/EntityLivingBase
      // 5f: ifeq aa
      // 62: goto 66
      // 65: athrow
      // 66: aload 4
      // 68: goto 6c
      // 6b: athrow
      // 6c: checkcast net/minecraft/entity/EntityLivingBase
      // 6f: iload 2
      // 70: ifne 83
      // 73: getfield net/minecraft/entity/EntityLivingBase.deathTime I
      // 76: ifne aa
      // 79: goto 7d
      // 7c: athrow
      // 7d: aload 4
      // 7f: goto 83
      // 82: athrow
      // 83: iload 2
      // 84: ifne 97
      // 87: instanceof net/minecraft/entity/item/EntityArmorStand
      // 8a: ifne aa
      // 8d: goto 91
      // 90: athrow
      // 91: aload 4
      // 93: goto 97
      // 96: athrow
      // 97: invokevirtual net/minecraft/entity/Entity.isInvisible ()Z
      // 9a: ifne aa
      // 9d: aload 0
      // 9e: aload 4
      // a0: getstatic java/awt/Color.WHITE Ljava/awt/Color;
      // a3: invokevirtual x/occe13d5edb4.Ά (Lnet/minecraft/entity/Entity;Ljava/awt/Color;)V
      // a6: goto aa
      // a9: athrow
      // aa: iload 2
      // ab: ifeq 2b
      // ae: return
   }

   public static double ɕ(Entity var0) {
      return Ԁ.Ӂ();
   }

   public Entity Ȝ(float param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: getstatic x/oc5e549848f3.İ I
      // 003: istore 2
      // 004: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 007: iload 2
      // 008: ifne 01c
      // 00b: invokevirtual net/minecraft/client/Minecraft.getRenderViewEntity ()Lnet/minecraft/entity/Entity;
      // 00e: ifnull 2cb
      // 011: goto 015
      // 014: athrow
      // 015: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 018: goto 01c
      // 01b: athrow
      // 01c: iload 2
      // 01d: ifne 03d
      // 020: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 023: ifnull 2cb
      // 026: goto 02a
      // 029: athrow
      // 02a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 02d: aconst_null
      // 02e: putfield net/minecraft/client/Minecraft.pointedEntity Lnet/minecraft/entity/Entity;
      // 031: aload 0
      // 032: aconst_null
      // 033: putfield x/occe13d5edb4.ǆ Lnet/minecraft/entity/Entity;
      // 036: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 039: goto 03d
      // 03c: athrow
      // 03d: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 040: invokevirtual net/minecraft/client/multiplayer/PlayerControllerMP.extendedReach ()Z
      // 043: iload 2
      // 044: ifne 05b
      // 047: ifeq 055
      // 04a: goto 04e
      // 04d: athrow
      // 04e: ldc2_w 6.0
      // 051: goto 071
      // 054: athrow
      // 055: getstatic x/oc9755810e45.Ɖ Lx/oc7e673dd779;
      // 058: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 05b: ifeq 06e
      // 05e: getstatic x/oc7e673dd779.ҡ Lx/oca9cc61aada;
      // 061: getstatic x/oc7e673dd779.Ñ Lx/oca9cc61aada;
      // 064: invokestatic x/oc7ab2161b9f.û ()Ljava/util/Random;
      // 067: invokestatic x/oc7ab2161b9f.Μ (Lx/oca9cc61aada;Lx/oca9cc61aada;Ljava/util/Random;)D
      // 06a: goto 071
      // 06d: athrow
      // 06e: ldc2_w 3.0
      // 071: dstore 3
      // 072: aload 0
      // 073: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 076: invokevirtual net/minecraft/client/Minecraft.getRenderViewEntity ()Lnet/minecraft/entity/Entity;
      // 079: dload 3
      // 07a: fload 1
      // 07b: invokevirtual net/minecraft/entity/Entity.rayTrace (DF)Lnet/minecraft/util/MovingObjectPosition;
      // 07e: putfield x/occe13d5edb4.Ğ Lnet/minecraft/util/MovingObjectPosition;
      // 081: dload 3
      // 082: dstore 5
      // 084: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 087: invokevirtual net/minecraft/client/Minecraft.getRenderViewEntity ()Lnet/minecraft/entity/Entity;
      // 08a: fload 1
      // 08b: invokevirtual net/minecraft/entity/Entity.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 08e: astore 7
      // 090: aload 0
      // 091: iload 2
      // 092: ifne 0a4
      // 095: getfield x/occe13d5edb4.Ğ Lnet/minecraft/util/MovingObjectPosition;
      // 098: ifnull 0b1
      // 09b: goto 09f
      // 09e: athrow
      // 09f: aload 0
      // 0a0: goto 0a4
      // 0a3: athrow
      // 0a4: getfield x/occe13d5edb4.Ğ Lnet/minecraft/util/MovingObjectPosition;
      // 0a7: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 0aa: aload 7
      // 0ac: invokevirtual net/minecraft/util/Vec3.distanceTo (Lnet/minecraft/util/Vec3;)D
      // 0af: dstore 5
      // 0b1: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0b4: invokevirtual net/minecraft/client/Minecraft.getRenderViewEntity ()Lnet/minecraft/entity/Entity;
      // 0b7: fload 1
      // 0b8: invokevirtual net/minecraft/entity/Entity.getLook (F)Lnet/minecraft/util/Vec3;
      // 0bb: astore 8
      // 0bd: aload 7
      // 0bf: aload 8
      // 0c1: getfield net/minecraft/util/Vec3.xCoord D
      // 0c4: dload 3
      // 0c5: dmul
      // 0c6: aload 8
      // 0c8: getfield net/minecraft/util/Vec3.yCoord D
      // 0cb: dload 3
      // 0cc: dmul
      // 0cd: aload 8
      // 0cf: getfield net/minecraft/util/Vec3.zCoord D
      // 0d2: dload 3
      // 0d3: dmul
      // 0d4: invokevirtual net/minecraft/util/Vec3.addVector (DDD)Lnet/minecraft/util/Vec3;
      // 0d7: astore 9
      // 0d9: aconst_null
      // 0da: astore 10
      // 0dc: fconst_1
      // 0dd: fstore 11
      // 0df: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0e2: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 0e5: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0e8: invokevirtual net/minecraft/client/Minecraft.getRenderViewEntity ()Lnet/minecraft/entity/Entity;
      // 0eb: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0ee: invokevirtual net/minecraft/client/Minecraft.getRenderViewEntity ()Lnet/minecraft/entity/Entity;
      // 0f1: invokevirtual net/minecraft/entity/Entity.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 0f4: aload 8
      // 0f6: getfield net/minecraft/util/Vec3.xCoord D
      // 0f9: dload 3
      // 0fa: dmul
      // 0fb: aload 8
      // 0fd: getfield net/minecraft/util/Vec3.yCoord D
      // 100: dload 3
      // 101: dmul
      // 102: aload 8
      // 104: getfield net/minecraft/util/Vec3.zCoord D
      // 107: dload 3
      // 108: dmul
      // 109: invokevirtual net/minecraft/util/AxisAlignedBB.addCoord (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 10c: fload 11
      // 10e: f2d
      // 10f: fload 11
      // 111: f2d
      // 112: fload 11
      // 114: f2d
      // 115: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 118: invokevirtual net/minecraft/client/multiplayer/WorldClient.getEntitiesWithinAABBExcludingEntity (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/AxisAlignedBB;)Ljava/util/List;
      // 11b: astore 12
      // 11d: dload 5
      // 11f: dstore 13
      // 121: aload 12
      // 123: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 128: astore 15
      // 12a: aload 15
      // 12c: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 131: ifeq 257
      // 134: aload 15
      // 136: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 13b: astore 16
      // 13d: iload 2
      // 13e: aload 16
      // 140: checkcast net/minecraft/entity/Entity
      // 143: astore 17
      // 145: ifne 2cb
      // 148: aload 17
      // 14a: iload 2
      // 14b: ifne 162
      // 14e: goto 152
      // 151: athrow
      // 152: invokevirtual net/minecraft/entity/Entity.canBeCollidedWith ()Z
      // 155: ifeq 253
      // 158: goto 15c
      // 15b: athrow
      // 15c: aload 17
      // 15e: goto 162
      // 161: athrow
      // 162: invokevirtual net/minecraft/entity/Entity.getCollisionBorderSize ()F
      // 165: f2d
      // 166: aload 17
      // 168: invokestatic x/occe13d5edb4.ɕ (Lnet/minecraft/entity/Entity;)D
      // 16b: dmul
      // 16c: d2f
      // 16d: fstore 18
      // 16f: aload 17
      // 171: invokevirtual net/minecraft/entity/Entity.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 174: fload 18
      // 176: f2d
      // 177: fload 18
      // 179: f2d
      // 17a: fload 18
      // 17c: f2d
      // 17d: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 180: astore 19
      // 182: aload 19
      // 184: aload 7
      // 186: aload 9
      // 188: invokevirtual net/minecraft/util/AxisAlignedBB.calculateIntercept (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/MovingObjectPosition;
      // 18b: astore 20
      // 18d: aload 19
      // 18f: aload 7
      // 191: invokevirtual net/minecraft/util/AxisAlignedBB.isVecInside (Lnet/minecraft/util/Vec3;)Z
      // 194: iload 2
      // 195: ifne 1af
      // 198: ifeq 1e4
      // 19b: goto 19f
      // 19e: athrow
      // 19f: dconst_0
      // 1a0: iload 2
      // 1a1: ifne 1b4
      // 1a4: goto 1a8
      // 1a7: athrow
      // 1a8: dload 13
      // 1aa: dcmpg
      // 1ab: goto 1af
      // 1ae: athrow
      // 1af: iflt 1b9
      // 1b2: dload 13
      // 1b4: dconst_0
      // 1b5: dcmpl
      // 1b6: ifne 253
      // 1b9: aload 0
      // 1ba: aload 17
      // 1bc: putfield x/occe13d5edb4.ǆ Lnet/minecraft/entity/Entity;
      // 1bf: aload 20
      // 1c1: iload 2
      // 1c2: ifne 1d8
      // 1c5: goto 1c9
      // 1c8: athrow
      // 1c9: ifnonnull 1d6
      // 1cc: goto 1d0
      // 1cf: athrow
      // 1d0: aload 7
      // 1d2: goto 1db
      // 1d5: athrow
      // 1d6: aload 20
      // 1d8: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 1db: astore 10
      // 1dd: iload 2
      // 1de: dconst_0
      // 1df: dstore 13
      // 1e1: ifeq 253
      // 1e4: aload 20
      // 1e6: ifnull 253
      // 1e9: goto 1ed
      // 1ec: athrow
      // 1ed: aload 7
      // 1ef: aload 20
      // 1f1: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 1f4: invokevirtual net/minecraft/util/Vec3.distanceTo (Lnet/minecraft/util/Vec3;)D
      // 1f7: dstore 21
      // 1f9: dload 21
      // 1fb: dload 13
      // 1fd: iload 2
      // 1fe: ifne 210
      // 201: dcmpg
      // 202: iflt 214
      // 205: goto 209
      // 208: athrow
      // 209: dload 13
      // 20b: dconst_0
      // 20c: goto 210
      // 20f: athrow
      // 210: dcmpl
      // 211: ifne 253
      // 214: aload 17
      // 216: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 219: invokevirtual net/minecraft/client/Minecraft.getRenderViewEntity ()Lnet/minecraft/entity/Entity;
      // 21c: getfield net/minecraft/entity/Entity.ridingEntity Lnet/minecraft/entity/Entity;
      // 21f: if_acmpne 242
      // 222: goto 226
      // 225: athrow
      // 226: dload 13
      // 228: dconst_0
      // 229: dcmpl
      // 22a: ifne 253
      // 22d: goto 231
      // 230: athrow
      // 231: aload 0
      // 232: aload 17
      // 234: putfield x/occe13d5edb4.ǆ Lnet/minecraft/entity/Entity;
      // 237: iload 2
      // 238: aload 20
      // 23a: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 23d: astore 10
      // 23f: ifeq 253
      // 242: aload 0
      // 243: aload 17
      // 245: putfield x/occe13d5edb4.ǆ Lnet/minecraft/entity/Entity;
      // 248: aload 20
      // 24a: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 24d: astore 10
      // 24f: dload 21
      // 251: dstore 13
      // 253: iload 2
      // 254: ifeq 12a
      // 257: aload 0
      // 258: getfield x/occe13d5edb4.ǆ Lnet/minecraft/entity/Entity;
      // 25b: ifnull 2cb
      // 25e: dload 13
      // 260: dload 5
      // 262: dcmpg
      // 263: iload 2
      // 264: ifne 2a9
      // 267: goto 26b
      // 26a: athrow
      // 26b: iflt 285
      // 26e: goto 272
      // 271: athrow
      // 272: aload 0
      // 273: iload 2
      // 274: ifne 2a3
      // 277: goto 27b
      // 27a: athrow
      // 27b: getfield x/occe13d5edb4.Ğ Lnet/minecraft/util/MovingObjectPosition;
      // 27e: ifnonnull 2cb
      // 281: goto 285
      // 284: athrow
      // 285: aload 0
      // 286: iload 2
      // 287: ifne 2c7
      // 28a: goto 28e
      // 28d: athrow
      // 28e: new net/minecraft/util/MovingObjectPosition
      // 291: dup
      // 292: aload 0
      // 293: getfield x/occe13d5edb4.ǆ Lnet/minecraft/entity/Entity;
      // 296: aload 10
      // 298: invokespecial net/minecraft/util/MovingObjectPosition.<init> (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/Vec3;)V
      // 29b: putfield x/occe13d5edb4.Ğ Lnet/minecraft/util/MovingObjectPosition;
      // 29e: aload 0
      // 29f: goto 2a3
      // 2a2: athrow
      // 2a3: getfield x/occe13d5edb4.ǆ Lnet/minecraft/entity/Entity;
      // 2a6: instanceof net/minecraft/entity/EntityLivingBase
      // 2a9: ifne 2c2
      // 2ac: aload 0
      // 2ad: iload 2
      // 2ae: ifne 2c7
      // 2b1: goto 2b5
      // 2b4: athrow
      // 2b5: getfield x/occe13d5edb4.ǆ Lnet/minecraft/entity/Entity;
      // 2b8: instanceof net/minecraft/entity/item/EntityItemFrame
      // 2bb: ifeq 2cb
      // 2be: goto 2c2
      // 2c1: athrow
      // 2c2: aload 0
      // 2c3: goto 2c7
      // 2c6: athrow
      // 2c7: getfield x/occe13d5edb4.ǆ Lnet/minecraft/entity/Entity;
      // 2ca: areturn
      // 2cb: aconst_null
      // 2cc: areturn
   }

   private void Ά(Entity var1, Color var2) {
      if (var1 instanceof EntityLivingBase) {
         float var3 = oc69da1aa7f5.ő.getTimer().renderPartialTicks;
         double var4 = var1.lastTickPosX + (var1.posX - var1.lastTickPosX) * var3 - oc69da1aa7f5.ő.getRenderManager().viewerPosX;
         double var6 = var1.lastTickPosY + (var1.posY - var1.lastTickPosY) * var3 - oc69da1aa7f5.ő.getRenderManager().viewerPosY;
         double var8 = var1.lastTickPosZ + (var1.posZ - var1.lastTickPosZ) * var3 - oc69da1aa7f5.ő.getRenderManager().viewerPosZ;
         float var10 = (float)(var1.getCollisionBorderSize() * Ԁ.Ӂ());
         AxisAlignedBB var11 = var1.getEntityBoundingBox().expand(var10, var10, var10);
         AxisAlignedBB var12 = new AxisAlignedBB(
            var11.minX - var1.posX + var4,
            var11.minY - var1.posY + var6,
            var11.minZ - var1.posZ + var8,
            var11.maxX - var1.posX + var4,
            var11.maxY - var1.posY + var6,
            var11.maxZ - var1.posZ + var8
         );
         GL11.glBlendFunc(-1136478354 ^ -1136479124, -1136478353 ^ -1136479124);
         GL11.glEnable(-1136476274 ^ -1136479124);
         GL11.glDisable(-1136477811 ^ -1136479124);
         GL11.glDisable(-1136476387 ^ -1136479124);
         GL11.glDepthMask(false);
         GL11.glLineWidth(2.0F);
         GL11.glColor3d(var2.getRed(), var2.getGreen(), var2.getBlue());
         RenderGlobal.drawSelectionBoundingBox(var12);
         GL11.glEnable(-1136477811 ^ -1136479124);
         GL11.glEnable(-1136476387 ^ -1136479124);
         GL11.glDepthMask(true);
         GL11.glDisable(-1136476274 ^ -1136479124);
      }
   }
}

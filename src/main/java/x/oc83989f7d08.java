package x;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityTNTPrimed;

public class oc83989f7d08 extends oc69da1aa7f5 {
   private final occ2f8dff8d8 Ѣ;
   private final occ2f8dff8d8 d;
   private final occ2f8dff8d8 Ѵ;
   private final oca9cc61aada х;
   private final oca9cc61aada օ;
   private final oca9cc61aada Ց;
   private final oca9cc61aada Ķ;
   private final oc24a0a5bddf Ц;
   private final List<ocbc000ed560> Ɯ = new ArrayList<>();
   public static int Ё;

   public oc83989f7d08() {
      super("TNT ESP", oce4cea752dd.Ŏ);
      this.ą("Shows TNT blast areas and estimated damage to you in health points.");
      this.ʌ(this.Ѣ = new occ2f8dff8d8("Blast radius", true));
      this.ʌ(this.d = new occ2f8dff8d8("Damage", true));
      this.ʌ(this.Ѵ = new occ2f8dff8d8("Through walls", true));
      this.ʌ(this.х = new oca9cc61aada("Explosion power", 4.0, 1.0, 8.0, 0.5));
      this.ʌ(this.օ = new oca9cc61aada("Opacity", 15.0, 0.0, 50.0, 1.0));
      this.ʌ(this.Ց = new oca9cc61aada("Range", 64.0, 8.0, 128.0, 4.0));
      this.ʌ(this.Ķ = new oca9cc61aada("Scale", 1.0, 0.5, 3.0, 0.05));
      this.ʌ(this.Ц = new oc24a0a5bddf("Blast color", -1074618028 ^ -1074617941, -1074617875 ^ -1074617941, -1074617875 ^ -1074617941));
   }

   @Override
   public void onEnable() {
      this.ҷ();
   }

   @Override
   public void onDisable() {
      this.Ɯ.clear();
   }

   @oc66fa4f2195
   public void դ(oc9adb807c19 var1) {
      try {
         if (var1.Ұ == oc110d7f376c.END) {
            this.ҷ();
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }
   }

   private void ҷ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 1e
      // 09: getfield x/oc83989f7d08.Ɯ Ljava/util/List;
      // 0c: invokeinterface java/util/List.clear ()V 1
      // 11: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 14: ifne 1d
      // 17: goto 1b
      // 1a: athrow
      // 1b: return
      // 1c: athrow
      // 1d: aload 0
      // 1e: getfield x/oc83989f7d08.Ց Lx/oca9cc61aada;
      // 21: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 24: aload 0
      // 25: getfield x/oc83989f7d08.Ց Lx/oca9cc61aada;
      // 28: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 2b: dmul
      // 2c: dstore 2
      // 2d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 30: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 33: getfield net/minecraft/client/multiplayer/WorldClient.loadedEntityList Ljava/util/List;
      // 36: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 3b: astore 4
      // 3d: aload 4
      // 3f: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 44: ifeq ef
      // 47: aload 4
      // 49: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 4e: checkcast net/minecraft/entity/Entity
      // 51: astore 5
      // 53: aload 5
      // 55: iload 1
      // 56: ifne 65
      // 59: instanceof net/minecraft/entity/item/EntityTNTPrimed
      // 5c: ifeq 3d
      // 5f: goto 63
      // 62: athrow
      // 63: aload 5
      // 65: iload 1
      // 66: ifne 75
      // 69: getfield net/minecraft/entity/Entity.isDead Z
      // 6c: ifne 3d
      // 6f: goto 73
      // 72: athrow
      // 73: aload 5
      // 75: iload 1
      // 76: ifne 95
      // 79: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 7c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 7f: invokevirtual net/minecraft/entity/Entity.getDistanceSqToEntity (Lnet/minecraft/entity/Entity;)D
      // 82: dload 2
      // 83: dcmpl
      // 84: ifle 93
      // 87: goto 8b
      // 8a: athrow
      // 8b: iload 1
      // 8c: ifeq 3d
      // 8f: goto 93
      // 92: athrow
      // 93: aload 5
      // 95: checkcast net/minecraft/entity/item/EntityTNTPrimed
      // 98: astore 6
      // 9a: aload 6
      // 9c: getfield net/minecraft/entity/item/EntityTNTPrimed.fuse I
      // 9f: iload 1
      // a0: ifne b9
      // a3: ifgt b2
      // a6: goto aa
      // a9: athrow
      // aa: iload 1
      // ab: ifeq 3d
      // ae: goto b2
      // b1: athrow
      // b2: aload 0
      // b3: getfield x/oc83989f7d08.d Lx/occ2f8dff8d8;
      // b6: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // b9: ifeq d3
      // bc: aload 6
      // be: aload 0
      // bf: getfield x/oc83989f7d08.х Lx/oca9cc61aada;
      // c2: invokevirtual x/oca9cc61aada.Ӂ ()D
      // c5: d2f
      // c6: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // c9: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // cc: invokestatic x/oce5883ca002.Ӹ (Lnet/minecraft/entity/item/EntityTNTPrimed;FLnet/minecraft/entity/player/EntityPlayer;)F
      // cf: goto d4
      // d2: athrow
      // d3: fconst_0
      // d4: fstore 7
      // d6: iload 1
      // d7: aload 0
      // d8: getfield x/oc83989f7d08.Ɯ Ljava/util/List;
      // db: new x/ocbc000ed560
      // de: dup
      // df: aload 6
      // e1: fload 7
      // e3: invokespecial x/ocbc000ed560.<init> (Lnet/minecraft/entity/item/EntityTNTPrimed;F)V
      // e6: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // eb: pop
      // ec: ifeq 3d
      // ef: return
   }

   @oc66fa4f2195
   public void Ο(oc746a23b244 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: istore 2
      // 004: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 007: ifne 00c
      // 00a: return
      // 00b: athrow
      // 00c: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 00f: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 012: astore 3
      // 013: aload 0
      // 014: getfield x/oc83989f7d08.օ Lx/oca9cc61aada;
      // 017: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 01a: d2f
      // 01b: ldc 100.0
      // 01d: fdiv
      // 01e: fstore 4
      // 020: aload 0
      // 021: getfield x/oc83989f7d08.х Lx/oca9cc61aada;
      // 024: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 027: dstore 5
      // 029: aload 0
      // 02a: getfield x/oc83989f7d08.Ɯ Ljava/util/List;
      // 02d: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 032: astore 7
      // 034: aload 7
      // 036: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 03b: ifeq 195
      // 03e: aload 7
      // 040: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 045: checkcast x/ocbc000ed560
      // 048: astore 8
      // 04a: aload 8
      // 04c: getfield x/ocbc000ed560.Ԍ Lnet/minecraft/entity/item/EntityTNTPrimed;
      // 04f: astore 9
      // 051: aload 9
      // 053: iload 2
      // 054: ifne 063
      // 057: getfield net/minecraft/entity/item/EntityTNTPrimed.isDead Z
      // 05a: ifne 034
      // 05d: goto 061
      // 060: athrow
      // 061: aload 9
      // 063: iload 2
      // 064: ifne 073
      // 067: getfield net/minecraft/entity/item/EntityTNTPrimed.fuse I
      // 06a: ifle 034
      // 06d: goto 071
      // 070: athrow
      // 071: aload 9
      // 073: iload 2
      // 074: ifne 091
      // 077: getfield net/minecraft/entity/item/EntityTNTPrimed.worldObj Lnet/minecraft/world/World;
      // 07a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 07d: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 080: if_acmpeq 08f
      // 083: goto 087
      // 086: athrow
      // 087: iload 2
      // 088: ifeq 034
      // 08b: goto 08f
      // 08e: athrow
      // 08f: aload 9
      // 091: getfield net/minecraft/entity/item/EntityTNTPrimed.lastTickPosX D
      // 094: aload 9
      // 096: getfield net/minecraft/entity/item/EntityTNTPrimed.posX D
      // 099: aload 9
      // 09b: getfield net/minecraft/entity/item/EntityTNTPrimed.lastTickPosX D
      // 09e: dsub
      // 09f: aload 1
      // 0a0: getfield x/oc746a23b244.Ё F
      // 0a3: f2d
      // 0a4: dmul
      // 0a5: dadd
      // 0a6: aload 3
      // 0a7: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosX D
      // 0aa: dsub
      // 0ab: dstore 10
      // 0ad: aload 9
      // 0af: getfield net/minecraft/entity/item/EntityTNTPrimed.lastTickPosY D
      // 0b2: aload 9
      // 0b4: getfield net/minecraft/entity/item/EntityTNTPrimed.posY D
      // 0b7: aload 9
      // 0b9: getfield net/minecraft/entity/item/EntityTNTPrimed.lastTickPosY D
      // 0bc: dsub
      // 0bd: aload 1
      // 0be: getfield x/oc746a23b244.Ё F
      // 0c1: f2d
      // 0c2: dmul
      // 0c3: dadd
      // 0c4: aload 3
      // 0c5: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosY D
      // 0c8: dsub
      // 0c9: dstore 12
      // 0cb: aload 9
      // 0cd: getfield net/minecraft/entity/item/EntityTNTPrimed.lastTickPosZ D
      // 0d0: aload 9
      // 0d2: getfield net/minecraft/entity/item/EntityTNTPrimed.posZ D
      // 0d5: aload 9
      // 0d7: getfield net/minecraft/entity/item/EntityTNTPrimed.lastTickPosZ D
      // 0da: dsub
      // 0db: aload 1
      // 0dc: getfield x/oc746a23b244.Ё F
      // 0df: f2d
      // 0e0: dmul
      // 0e1: dadd
      // 0e2: aload 3
      // 0e3: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosZ D
      // 0e6: dsub
      // 0e7: dstore 14
      // 0e9: new net/minecraft/util/Vec3
      // 0ec: dup
      // 0ed: dload 10
      // 0ef: dload 12
      // 0f1: aload 9
      // 0f3: getfield net/minecraft/entity/item/EntityTNTPrimed.height F
      // 0f6: ldc_w 16.0
      // 0f9: fdiv
      // 0fa: f2d
      // 0fb: dadd
      // 0fc: dload 14
      // 0fe: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 101: astore 16
      // 103: aload 0
      // 104: getfield x/oc83989f7d08.Ѣ Lx/occ2f8dff8d8;
      // 107: iload 2
      // 108: ifne 16f
      // 10b: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 10e: ifeq 155
      // 111: goto 115
      // 114: athrow
      // 115: aload 16
      // 117: dload 5
      // 119: ldc2_w 2.0
      // 11c: dmul
      // 11d: ldc_w 1911672992
      // 120: ldc_w 1896755039
      // 123: ixor
      // 124: fload 4
      // 126: ldc_w 0.1
      // 129: fmul
      // 12a: ldc_w 0.12
      // 12d: aload 0
      // 12e: getfield x/oc83989f7d08.Ѵ Lx/occ2f8dff8d8;
      // 131: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 134: invokestatic x/oc3c7d73111d.Җ (Lnet/minecraft/util/Vec3;DIFFZ)V
      // 137: aload 16
      // 139: dload 5
      // 13b: aload 0
      // 13c: getfield x/oc83989f7d08.Ц Lx/oc24a0a5bddf;
      // 13f: invokevirtual x/oc24a0a5bddf.ͳ ()I
      // 142: fload 4
      // 144: ldc_w 0.35
      // 147: aload 0
      // 148: getfield x/oc83989f7d08.Ѵ Lx/occ2f8dff8d8;
      // 14b: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 14e: invokestatic x/oc3c7d73111d.Җ (Lnet/minecraft/util/Vec3;DIFFZ)V
      // 151: goto 155
      // 154: athrow
      // 155: aload 0
      // 156: iload 2
      // 157: ifne 17a
      // 15a: aload 9
      // 15c: dload 10
      // 15e: dload 12
      // 160: dload 14
      // 162: fload 4
      // 164: invokevirtual x/oc83989f7d08.Ê (Lnet/minecraft/entity/item/EntityTNTPrimed;DDDF)V
      // 167: aload 0
      // 168: getfield x/oc83989f7d08.d Lx/occ2f8dff8d8;
      // 16b: goto 16f
      // 16e: athrow
      // 16f: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 172: ifeq 191
      // 175: aload 0
      // 176: goto 17a
      // 179: athrow
      // 17a: aload 8
      // 17c: dload 10
      // 17e: dload 12
      // 180: aload 9
      // 182: getfield net/minecraft/entity/item/EntityTNTPrimed.height F
      // 185: f2d
      // 186: dadd
      // 187: ldc2_w 0.35
      // 18a: dadd
      // 18b: dload 14
      // 18d: aload 3
      // 18e: invokevirtual x/oc83989f7d08.o (Lx/ocbc000ed560;DDDLnet/minecraft/client/renderer/entity/RenderManager;)V
      // 191: iload 2
      // 192: ifeq 034
      // 195: return
   }

   private void Ê(EntityTNTPrimed param1, double param2, double param4, double param6, float param8) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 1
      // 01: getfield net/minecraft/entity/item/EntityTNTPrimed.width F
      // 04: f2d
      // 05: ldc2_w 0.5
      // 08: dmul
      // 09: dstore 10
      // 0b: new net/minecraft/util/AxisAlignedBB
      // 0e: dup
      // 0f: dload 2
      // 10: dload 10
      // 12: dsub
      // 13: dload 4
      // 15: dload 6
      // 17: dload 10
      // 19: dsub
      // 1a: dload 2
      // 1b: dload 10
      // 1d: dadd
      // 1e: dload 4
      // 20: aload 1
      // 21: getfield net/minecraft/entity/item/EntityTNTPrimed.height F
      // 24: f2d
      // 25: dadd
      // 26: dload 6
      // 28: dload 10
      // 2a: dadd
      // 2b: invokespecial net/minecraft/util/AxisAlignedBB.<init> (DDDDDD)V
      // 2e: ldc2_w 0.002
      // 31: ldc2_w 0.002
      // 34: ldc2_w 0.002
      // 37: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 3a: astore 12
      // 3c: getstatic x/oce6044968f8.ђ Z
      // 3f: ldc_w -1301863350
      // 42: ldc_w -1301750859
      // 45: ixor
      // 46: invokestatic org/lwjgl/opengl/GL11.glPushAttrib (I)V
      // 49: istore 9
      // 4b: ldc_w -1301753769
      // 4e: ldc_w -1301750859
      // 51: ixor
      // 52: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 55: iload 9
      // 57: ldc_w -1301751625
      // 5a: ldc_w -1301750859
      // 5d: ixor
      // 5e: ldc_w -1301751626
      // 61: ldc_w -1301750859
      // 64: ixor
      // 65: invokestatic org/lwjgl/opengl/GL11.glBlendFunc (II)V
      // 68: ldc_w -1301752236
      // 6b: ldc_w -1301750859
      // 6e: ixor
      // 6f: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 72: ldc_w -1301753627
      // 75: ldc_w -1301750859
      // 78: ixor
      // 79: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 7c: ldc_w -1301753739
      // 7f: ldc_w -1301750859
      // 82: ixor
      // 83: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 86: ifne d7
      // 89: ldc_w -1301753615
      // 8c: ldc_w -1301750859
      // 8f: ixor
      // 90: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 93: aload 0
      // 94: getfield x/oc83989f7d08.Ѵ Lx/occ2f8dff8d8;
      // 97: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 9a: ifeq af
      // 9d: goto a1
      // a0: athrow
      // a1: ldc_w -1301753660
      // a4: ldc_w -1301750859
      // a7: ixor
      // a8: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // ab: goto af
      // ae: athrow
      // af: bipush 0
      // b0: invokestatic org/lwjgl/opengl/GL11.glDepthMask (Z)V
      // b3: ldc_w 1.5
      // b6: invokestatic org/lwjgl/opengl/GL11.glLineWidth (F)V
      // b9: fconst_1
      // ba: fconst_1
      // bb: fconst_1
      // bc: ldc_w 0.9
      // bf: invokestatic org/lwjgl/opengl/GL11.glColor4f (FFFF)V
      // c2: aload 12
      // c4: dconst_0
      // c5: dconst_0
      // c6: dconst_0
      // c7: invokestatic x/ocbd4917c4b1.ԁ (Lnet/minecraft/util/AxisAlignedBB;DDD)V
      // ca: aload 12
      // cc: fconst_1
      // cd: fconst_1
      // ce: fconst_1
      // cf: fload 8
      // d1: invokestatic x/ocbd4917c4b1.ʓ (Lnet/minecraft/util/AxisAlignedBB;FFFF)V
      // d4: invokestatic org/lwjgl/opengl/GL11.glPopAttrib ()V
      // d7: goto e2
      // da: astore 13
      // dc: invokestatic org/lwjgl/opengl/GL11.glPopAttrib ()V
      // df: aload 13
      // e1: athrow
      // e2: return
   }

   private void o(ocbc000ed560 param1, double param2, double param4, double param6, RenderManager param8) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: ldc_w -360690984
      // 003: ldc_w -360693368
      // 006: ixor
      // 007: invokestatic org/lwjgl/opengl/GL11.glIsEnabled (I)Z
      // 00a: istore 10
      // 00c: getstatic x/oce6044968f8.ђ Z
      // 00f: ldc_w -360690951
      // 012: ldc_w -360693368
      // 015: ixor
      // 016: invokestatic org/lwjgl/opengl/GL11.glIsEnabled (I)Z
      // 019: istore 11
      // 01b: ldc_w -360690583
      // 01e: ldc_w -360693368
      // 021: ixor
      // 022: invokestatic org/lwjgl/opengl/GL11.glIsEnabled (I)Z
      // 025: istore 12
      // 027: ldc_w -360691094
      // 02a: ldc_w -360693368
      // 02d: ixor
      // 02e: invokestatic org/lwjgl/opengl/GL11.glIsEnabled (I)Z
      // 031: istore 13
      // 033: ldc_w -360691128
      // 036: ldc_w -360693368
      // 039: ixor
      // 03a: invokestatic org/lwjgl/opengl/GL11.glIsEnabled (I)Z
      // 03d: istore 14
      // 03f: ldc_w -360690950
      // 042: ldc_w -360693368
      // 045: ixor
      // 046: invokestatic org/lwjgl/opengl/GL11.glGetBoolean (I)Z
      // 049: istore 15
      // 04b: ldc_w -360660671
      // 04e: ldc_w -360693368
      // 051: ixor
      // 052: invokestatic org/lwjgl/opengl/GL11.glGetInteger (I)I
      // 055: istore 16
      // 057: ldc_w -360660672
      // 05a: ldc_w -360693368
      // 05d: ixor
      // 05e: invokestatic org/lwjgl/opengl/GL11.glGetInteger (I)I
      // 061: istore 17
      // 063: ldc_w -360660669
      // 066: ldc_w -360693368
      // 069: ixor
      // 06a: invokestatic org/lwjgl/opengl/GL11.glGetInteger (I)I
      // 06d: istore 18
      // 06f: ldc_w -360660670
      // 072: ldc_w -360693368
      // 075: ixor
      // 076: invokestatic org/lwjgl/opengl/GL11.glGetInteger (I)I
      // 079: istore 19
      // 07b: bipush 1
      // 07c: invokestatic org/lwjgl/opengl/GL11.glPushAttrib (I)V
      // 07f: invokestatic net/minecraft/client/renderer/GlStateManager.pushMatrix ()V
      // 082: istore 9
      // 084: dload 2
      // 085: dload 4
      // 087: dload 6
      // 089: invokestatic net/minecraft/client/renderer/GlStateManager.translate (DDD)V
      // 08c: aload 8
      // 08e: getfield net/minecraft/client/renderer/entity/RenderManager.playerViewY F
      // 091: fneg
      // 092: fconst_0
      // 093: fconst_1
      // 094: fconst_0
      // 095: invokestatic net/minecraft/client/renderer/GlStateManager.rotate (FFFF)V
      // 098: aload 8
      // 09a: getfield net/minecraft/client/renderer/entity/RenderManager.playerViewX F
      // 09d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0a0: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 0a3: getfield net/minecraft/client/settings/GameSettings.thirdPersonView I
      // 0a6: iload 9
      // 0a8: ifne 0be
      // 0ab: ldc_w -360693366
      // 0ae: ldc_w -360693368
      // 0b1: ixor
      // 0b2: if_icmpne 0c1
      // 0b5: goto 0b9
      // 0b8: athrow
      // 0b9: bipush -1
      // 0ba: goto 0be
      // 0bd: athrow
      // 0be: goto 0c2
      // 0c1: bipush 1
      // 0c2: i2f
      // 0c3: fmul
      // 0c4: fconst_1
      // 0c5: fconst_0
      // 0c6: fconst_0
      // 0c7: invokestatic net/minecraft/client/renderer/GlStateManager.rotate (FFFF)V
      // 0ca: iload 9
      // 0cc: ldc_w 0.02666667
      // 0cf: aload 0
      // 0d0: getfield x/oc83989f7d08.Ķ Lx/oca9cc61aada;
      // 0d3: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0d6: invokestatic x/oc05d664c647.Ө (D)F
      // 0d9: fmul
      // 0da: fstore 20
      // 0dc: ifne 122
      // 0df: fload 20
      // 0e1: fneg
      // 0e2: fload 20
      // 0e4: fneg
      // 0e5: fload 20
      // 0e7: invokestatic net/minecraft/client/renderer/GlStateManager.scale (FFF)V
      // 0ea: invokestatic net/minecraft/client/renderer/GlStateManager.disableLighting ()V
      // 0ed: invokestatic net/minecraft/client/renderer/GlStateManager.enableTexture2D ()V
      // 0f0: invokestatic net/minecraft/client/renderer/GlStateManager.enableAlpha ()V
      // 0f3: invokestatic net/minecraft/client/renderer/GlStateManager.enableBlend ()V
      // 0f6: ldc_w -360693110
      // 0f9: ldc_w -360693368
      // 0fc: ixor
      // 0fd: ldc_w -360693109
      // 100: ldc_w -360693368
      // 103: ixor
      // 104: bipush 1
      // 105: bipush 0
      // 106: invokestatic net/minecraft/client/renderer/GlStateManager.tryBlendFuncSeparate (IIII)V
      // 109: aload 0
      // 10a: getfield x/oc83989f7d08.Ѵ Lx/occ2f8dff8d8;
      // 10d: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 110: ifeq 11e
      // 113: goto 117
      // 116: athrow
      // 117: invokestatic net/minecraft/client/renderer/GlStateManager.disableDepth ()V
      // 11a: goto 11e
      // 11d: athrow
      // 11e: bipush 0
      // 11f: invokestatic net/minecraft/client/renderer/GlStateManager.depthMask (Z)V
      // 122: aload 1
      // 123: iload 9
      // 125: ifne 148
      // 128: getfield x/ocbc000ed560.ύ F
      // 12b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 12e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 131: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHealth ()F
      // 134: fcmpl
      // 135: iflt 147
      // 138: goto 13c
      // 13b: athrow
      // 13c: ldc_w 360645064
      // 13f: ldc_w -360693368
      // 142: ixor
      // 143: goto 16a
      // 146: athrow
      // 147: aload 1
      // 148: getfield x/ocbc000ed560.ύ F
      // 14b: fconst_0
      // 14c: fcmpl
      // 14d: iload 9
      // 14f: ifne 160
      // 152: ifle 163
      // 155: goto 159
      // 158: athrow
      // 159: ldc_w 360704989
      // 15c: ldc_w -360693368
      // 15f: ixor
      // 160: goto 16a
      // 163: ldc_w 352370184
      // 166: ldc_w -360693368
      // 169: ixor
      // 16a: istore 21
      // 16c: iload 9
      // 16e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 171: getfield net/minecraft/client/Minecraft.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // 174: astore 22
      // 176: ifne 19d
      // 179: aload 22
      // 17b: aload 1
      // 17c: getfield x/ocbc000ed560.ɓ Ljava/lang/String;
      // 17f: aload 22
      // 181: aload 1
      // 182: getfield x/ocbc000ed560.ɓ Ljava/lang/String;
      // 185: invokevirtual net/minecraft/client/gui/FontRenderer.getStringWidth (Ljava/lang/String;)I
      // 188: ineg
      // 189: i2f
      // 18a: ldc_w 0.5
      // 18d: fmul
      // 18e: fconst_0
      // 18f: iload 21
      // 191: invokevirtual net/minecraft/client/gui/FontRenderer.drawStringWithShadow (Ljava/lang/String;FFI)I
      // 194: pop
      // 195: iload 10
      // 197: ifeq 1a2
      // 19a: invokestatic net/minecraft/client/renderer/GlStateManager.enableLighting ()V
      // 19d: iload 9
      // 19f: ifeq 1a9
      // 1a2: invokestatic net/minecraft/client/renderer/GlStateManager.disableLighting ()V
      // 1a5: goto 1a9
      // 1a8: athrow
      // 1a9: iload 11
      // 1ab: ifeq 1ba
      // 1ae: invokestatic net/minecraft/client/renderer/GlStateManager.enableDepth ()V
      // 1b1: iload 9
      // 1b3: ifeq 1c1
      // 1b6: goto 1ba
      // 1b9: athrow
      // 1ba: invokestatic net/minecraft/client/renderer/GlStateManager.disableDepth ()V
      // 1bd: goto 1c1
      // 1c0: athrow
      // 1c1: iload 12
      // 1c3: ifeq 1d2
      // 1c6: invokestatic net/minecraft/client/renderer/GlStateManager.enableTexture2D ()V
      // 1c9: iload 9
      // 1cb: ifeq 1d9
      // 1ce: goto 1d2
      // 1d1: athrow
      // 1d2: invokestatic net/minecraft/client/renderer/GlStateManager.disableTexture2D ()V
      // 1d5: goto 1d9
      // 1d8: athrow
      // 1d9: iload 13
      // 1db: ifeq 1ea
      // 1de: invokestatic net/minecraft/client/renderer/GlStateManager.enableBlend ()V
      // 1e1: iload 9
      // 1e3: ifeq 1f1
      // 1e6: goto 1ea
      // 1e9: athrow
      // 1ea: invokestatic net/minecraft/client/renderer/GlStateManager.disableBlend ()V
      // 1ed: goto 1f1
      // 1f0: athrow
      // 1f1: iload 14
      // 1f3: ifeq 202
      // 1f6: invokestatic net/minecraft/client/renderer/GlStateManager.enableAlpha ()V
      // 1f9: iload 9
      // 1fb: ifeq 209
      // 1fe: goto 202
      // 201: athrow
      // 202: invokestatic net/minecraft/client/renderer/GlStateManager.disableAlpha ()V
      // 205: goto 209
      // 208: athrow
      // 209: iload 15
      // 20b: invokestatic net/minecraft/client/renderer/GlStateManager.depthMask (Z)V
      // 20e: iload 16
      // 210: iload 17
      // 212: iload 18
      // 214: iload 19
      // 216: invokestatic net/minecraft/client/renderer/GlStateManager.tryBlendFuncSeparate (IIII)V
      // 219: invokestatic net/minecraft/client/renderer/GlStateManager.popMatrix ()V
      // 21c: invokestatic org/lwjgl/opengl/GL11.glPopAttrib ()V
      // 21f: invokestatic net/minecraft/client/renderer/GlStateManager.resetColor ()V
      // 222: goto 2c0
      // 225: astore 23
      // 227: iload 9
      // 229: ifne 238
      // 22c: iload 10
      // 22e: ifeq 23d
      // 231: invokestatic net/minecraft/client/renderer/GlStateManager.enableLighting ()V
      // 234: goto 238
      // 237: athrow
      // 238: iload 9
      // 23a: ifeq 244
      // 23d: invokestatic net/minecraft/client/renderer/GlStateManager.disableLighting ()V
      // 240: goto 244
      // 243: athrow
      // 244: iload 11
      // 246: ifeq 255
      // 249: invokestatic net/minecraft/client/renderer/GlStateManager.enableDepth ()V
      // 24c: iload 9
      // 24e: ifeq 25c
      // 251: goto 255
      // 254: athrow
      // 255: invokestatic net/minecraft/client/renderer/GlStateManager.disableDepth ()V
      // 258: goto 25c
      // 25b: athrow
      // 25c: iload 12
      // 25e: ifeq 26d
      // 261: invokestatic net/minecraft/client/renderer/GlStateManager.enableTexture2D ()V
      // 264: iload 9
      // 266: ifeq 274
      // 269: goto 26d
      // 26c: athrow
      // 26d: invokestatic net/minecraft/client/renderer/GlStateManager.disableTexture2D ()V
      // 270: goto 274
      // 273: athrow
      // 274: iload 13
      // 276: ifeq 285
      // 279: invokestatic net/minecraft/client/renderer/GlStateManager.enableBlend ()V
      // 27c: iload 9
      // 27e: ifeq 28c
      // 281: goto 285
      // 284: athrow
      // 285: invokestatic net/minecraft/client/renderer/GlStateManager.disableBlend ()V
      // 288: goto 28c
      // 28b: athrow
      // 28c: iload 14
      // 28e: ifeq 29d
      // 291: invokestatic net/minecraft/client/renderer/GlStateManager.enableAlpha ()V
      // 294: iload 9
      // 296: ifeq 2a4
      // 299: goto 29d
      // 29c: athrow
      // 29d: invokestatic net/minecraft/client/renderer/GlStateManager.disableAlpha ()V
      // 2a0: goto 2a4
      // 2a3: athrow
      // 2a4: iload 15
      // 2a6: invokestatic net/minecraft/client/renderer/GlStateManager.depthMask (Z)V
      // 2a9: iload 16
      // 2ab: iload 17
      // 2ad: iload 18
      // 2af: iload 19
      // 2b1: invokestatic net/minecraft/client/renderer/GlStateManager.tryBlendFuncSeparate (IIII)V
      // 2b4: invokestatic net/minecraft/client/renderer/GlStateManager.popMatrix ()V
      // 2b7: invokestatic org/lwjgl/opengl/GL11.glPopAttrib ()V
      // 2ba: invokestatic net/minecraft/client/renderer/GlStateManager.resetColor ()V
      // 2bd: aload 23
      // 2bf: athrow
      // 2c0: return
   }
}

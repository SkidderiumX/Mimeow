package x;

import java.awt.Color;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;
import org.lwjgl.opengl.GL11;

public class Z extends oc69da1aa7f5 {
   private occc831eff22 ɱ;
   private occ2f8dff8d8 ҥ;
   private occ2f8dff8d8 ů;
   private occ2f8dff8d8 Ԁ;
   private occ2f8dff8d8 Ȁ;
   private occ2f8dff8d8 Ș;
   private occ2f8dff8d8 ɍ;
   private occ2f8dff8d8 Ə;
   private occ2f8dff8d8 Ҡ;
   private oca9cc61aada Ƕ;
   private oca9cc61aada Ғ;
   private occ2f8dff8d8 G;
   private occ2f8dff8d8 Ƽ;
   private occ2f8dff8d8 Ǳ;
   private occ2f8dff8d8 Ε;
   private occ2f8dff8d8 ɵ;
   private static final int ӓ = 5;
   private static final double Ɋ = 1.0;
   private static final float ɨ = 2.0F;
   private static final float ƺ = 0.18F;
   private static final double ˠ = 0.05;
   private static final double ǉ = 0.03;
   private static final double Ƶ = 0.99;
   private static final double ʀ = 0.6;
   private static final double ӏ = 0.8;
   private static final double ȁ = 0.014;
   private static final double Θ = -0.4F;
   private static final double ԝ = 0.001;
   private static final double ն = 1.0E-7;
   private static final double ˢ = 0.3;
   private static final int ʨ = 120;
   private static final int ɶ = 4;
   private static final int Վ = 5;
   private static final double Π = 0.12;
   private static final double Է = 0.02;
   private static final double Ӟ = 0.15;
   private static final float Ӕ = 2.0F;
   private static final float ť = 1.0F;
   private static final double Ȉ = 0.35;
   private static final double җ = 0.01;
   private static final double Չ = 0.05;
   private int Ԑ;
   private final Map<Entity, Vec3> Ǆ = new HashMap<>();
   private final Set<Entity> ԕ = new HashSet<>();
   private String[] ì;
   public static int ϩ;

   public Z() {
      super("Indicators", oce4cea752dd.Ŏ);
      String[] var10001 = new String[646215189 ^ 646215190];
      var10001[0] = "Caret";
      var10001[1] = "Greater than";
      var10001[646215188 ^ 646215190] = "Triangle";
      this.ì = var10001;
      this.ą("Shows directional indicators for nearby projectiles.");
      this.ʌ(this.ɱ = new occc831eff22("Items"));
      this.ʌ(this.ҥ = new occ2f8dff8d8(this.ɱ, "Render arrows", true));
      this.ʌ(this.ů = new occ2f8dff8d8(this.ɱ, "Render ender pearls", true));
      this.ʌ(this.Ԁ = new occ2f8dff8d8(this.ɱ, "Render fireballs", true));
      this.ʌ(this.Ș = new occ2f8dff8d8(this.ɱ, "Draw arrow trajectory", false));
      this.ʌ(this.ɍ = new occ2f8dff8d8(this.ɱ, "Draw pearl trajectory", false));
      this.ʌ(this.Ȁ = new occ2f8dff8d8(this.ɱ, "Draw fireball trajectory", true));
      this.ʌ(this.Ə = new occ2f8dff8d8(this.ɱ, "Render eggs", false));
      this.ʌ(this.Ҡ = new occ2f8dff8d8(this.ɱ, "Render snowballs", false));
      this.ʌ(this.Ƕ = new oca9cc61aada("Arrow", 0, this.ì));
      this.ʌ(this.Ғ = new oca9cc61aada("Circle radius", 50.0, 30.0, 200.0, 5.0));
      this.ʌ(this.G = new occ2f8dff8d8("Item colors", true));
      this.ʌ(this.Ƽ = new occ2f8dff8d8("Render item", true));
      this.ʌ(this.Ǳ = new occ2f8dff8d8("Render distance", true));
      this.ʌ(this.Ε = new occ2f8dff8d8("Only when approaching", false));
      this.ʌ(this.ɵ = new occ2f8dff8d8("Render only offscreen", false));
      this.ԟ();
   }

   @Override
   public void z$1m9j3ewef9s() {
      this.ԟ();
   }

   @Override
   public void guiButtonToggled(occ2f8dff8d8 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 19
      // 09: aload 0
      // 0a: getfield x/Z.Ԁ Lx/occ2f8dff8d8;
      // 0d: if_acmpeq 48
      // 10: goto 14
      // 13: athrow
      // 14: aload 1
      // 15: goto 19
      // 18: athrow
      // 19: iload 2
      // 1a: ifne 2d
      // 1d: aload 0
      // 1e: getfield x/Z.ҥ Lx/occ2f8dff8d8;
      // 21: if_acmpeq 48
      // 24: goto 28
      // 27: athrow
      // 28: aload 1
      // 29: goto 2d
      // 2c: athrow
      // 2d: aload 0
      // 2e: iload 2
      // 2f: ifne 42
      // 32: getfield x/Z.ů Lx/occ2f8dff8d8;
      // 35: if_acmpeq 48
      // 38: goto 3c
      // 3b: athrow
      // 3c: aload 1
      // 3d: aload 0
      // 3e: goto 42
      // 41: athrow
      // 42: getfield x/Z.Ȁ Lx/occ2f8dff8d8;
      // 45: if_acmpne 50
      // 48: aload 0
      // 49: invokevirtual x/Z.ԟ ()V
      // 4c: goto 50
      // 4f: athrow
      // 50: return
   }

   @Override
   public void onDisable() {
      this.Ǆ.clear();
      this.ԕ.clear();
   }

   @oc66fa4f2195
   public void ί(oc9adb807c19 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: istore 2
      // 004: aload 1
      // 005: getfield x/ocb508b4e274.Ұ Lx/oc110d7f376c;
      // 008: getstatic x/oc110d7f376c.END Lx/oc110d7f376c;
      // 00b: if_acmpne 020
      // 00e: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 011: iload 2
      // 012: ifne 037
      // 015: goto 019
      // 018: athrow
      // 019: ifne 021
      // 01c: goto 020
      // 01f: athrow
      // 020: return
      // 021: aload 0
      // 022: dup
      // 023: getfield x/Z.Ԑ I
      // 026: bipush 1
      // 027: iadd
      // 028: putfield x/Z.Ԑ I
      // 02b: aload 0
      // 02c: getfield x/Z.Ԑ I
      // 02f: ldc_w 97445081
      // 032: ldc_w 97445084
      // 035: ixor
      // 036: irem
      // 037: ifeq 03b
      // 03a: return
      // 03b: new java/util/HashSet
      // 03e: dup
      // 03f: invokespecial java/util/HashSet.<init> ()V
      // 042: astore 3
      // 043: aload 0
      // 044: getfield x/Z.ԕ Ljava/util/Set;
      // 047: invokeinterface java/util/Set.clear ()V 1
      // 04c: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 04f: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 052: getfield net/minecraft/client/entity/EntityPlayerSP.posX D
      // 055: dstore 4
      // 057: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 05a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 05d: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // 060: dstore 6
      // 062: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 065: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 068: getfield net/minecraft/client/entity/EntityPlayerSP.posZ D
      // 06b: dstore 8
      // 06d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 070: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 073: getfield net/minecraft/client/multiplayer/WorldClient.loadedEntityList Ljava/util/List;
      // 076: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 07b: astore 10
      // 07d: aload 10
      // 07f: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 084: ifeq 1f9
      // 087: aload 10
      // 089: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 08e: checkcast net/minecraft/entity/Entity
      // 091: astore 11
      // 093: iload 2
      // 094: ifne 209
      // 097: aload 11
      // 099: iload 2
      // 09a: ifne 0aa
      // 09d: goto 0a1
      // 0a0: athrow
      // 0a1: ifnull 07d
      // 0a4: goto 0a8
      // 0a7: athrow
      // 0a8: aload 11
      // 0aa: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0ad: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0b0: if_acmpne 0bb
      // 0b3: iload 2
      // 0b4: ifeq 07d
      // 0b7: goto 0bb
      // 0ba: athrow
      // 0bb: aload 0
      // 0bc: aload 11
      // 0be: invokevirtual x/Z.Մ (Lnet/minecraft/entity/Entity;)Lnet/minecraft/item/ItemStack;
      // 0c1: astore 12
      // 0c3: aload 12
      // 0c5: ifnull 07d
      // 0c8: aload 0
      // 0c9: iload 2
      // 0ca: ifne 0f5
      // 0cd: aload 11
      // 0cf: invokevirtual x/Z.ʤ (Lnet/minecraft/entity/Entity;)Z
      // 0d2: ifne 0e1
      // 0d5: goto 0d9
      // 0d8: athrow
      // 0d9: iload 2
      // 0da: ifeq 07d
      // 0dd: goto 0e1
      // 0e0: athrow
      // 0e1: aload 3
      // 0e2: aload 11
      // 0e4: invokeinterface java/util/Set.add (Ljava/lang/Object;)Z 2
      // 0e9: pop
      // 0ea: aload 0
      // 0eb: getfield x/Z.Ǆ Ljava/util/Map;
      // 0ee: aload 11
      // 0f0: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 0f5: checkcast net/minecraft/util/Vec3
      // 0f8: astore 13
      // 0fa: iload 2
      // 0fb: ifne 1f5
      // 0fe: aload 0
      // 0ff: getfield x/Z.Ε Lx/occ2f8dff8d8;
      // 102: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 105: ifeq 1c7
      // 108: goto 10c
      // 10b: athrow
      // 10c: aload 13
      // 10e: iload 2
      // 10f: ifne 142
      // 112: goto 116
      // 115: athrow
      // 116: ifnonnull 147
      // 119: goto 11d
      // 11c: athrow
      // 11d: aload 0
      // 11e: getfield x/Z.Ǆ Ljava/util/Map;
      // 121: aload 11
      // 123: new net/minecraft/util/Vec3
      // 126: dup
      // 127: aload 11
      // 129: getfield net/minecraft/entity/Entity.posX D
      // 12c: aload 11
      // 12e: getfield net/minecraft/entity/Entity.posY D
      // 131: aload 11
      // 133: getfield net/minecraft/entity/Entity.posZ D
      // 136: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 139: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 13e: goto 142
      // 141: athrow
      // 142: pop
      // 143: iload 2
      // 144: ifeq 07d
      // 147: dload 4
      // 149: aload 13
      // 14b: getfield net/minecraft/util/Vec3.xCoord D
      // 14e: dsub
      // 14f: dload 4
      // 151: aload 13
      // 153: getfield net/minecraft/util/Vec3.xCoord D
      // 156: dsub
      // 157: dmul
      // 158: dload 6
      // 15a: aload 13
      // 15c: getfield net/minecraft/util/Vec3.yCoord D
      // 15f: dsub
      // 160: dload 6
      // 162: aload 13
      // 164: getfield net/minecraft/util/Vec3.yCoord D
      // 167: dsub
      // 168: dmul
      // 169: dadd
      // 16a: dload 8
      // 16c: aload 13
      // 16e: getfield net/minecraft/util/Vec3.zCoord D
      // 171: dsub
      // 172: dload 8
      // 174: aload 13
      // 176: getfield net/minecraft/util/Vec3.zCoord D
      // 179: dsub
      // 17a: dmul
      // 17b: dadd
      // 17c: invokestatic java/lang/Math.sqrt (D)D
      // 17f: dstore 14
      // 181: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 184: iload 2
      // 185: ifne 1f4
      // 188: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 18b: aload 11
      // 18d: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getDistanceToEntity (Lnet/minecraft/entity/Entity;)F
      // 190: f2d
      // 191: dstore 16
      // 193: dload 14
      // 195: dload 16
      // 197: dsub
      // 198: dconst_1
      // 199: dcmpg
      // 19a: ifgt 1c7
      // 19d: aload 0
      // 19e: getfield x/Z.Ǆ Ljava/util/Map;
      // 1a1: aload 11
      // 1a3: new net/minecraft/util/Vec3
      // 1a6: dup
      // 1a7: aload 11
      // 1a9: getfield net/minecraft/entity/Entity.posX D
      // 1ac: aload 11
      // 1ae: getfield net/minecraft/entity/Entity.posY D
      // 1b1: aload 11
      // 1b3: getfield net/minecraft/entity/Entity.posZ D
      // 1b6: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 1b9: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 1be: pop
      // 1bf: iload 2
      // 1c0: ifeq 07d
      // 1c3: goto 1c7
      // 1c6: athrow
      // 1c7: aload 0
      // 1c8: getfield x/Z.ԕ Ljava/util/Set;
      // 1cb: aload 11
      // 1cd: invokeinterface java/util/Set.add (Ljava/lang/Object;)Z 2
      // 1d2: pop
      // 1d3: aload 0
      // 1d4: getfield x/Z.Ǆ Ljava/util/Map;
      // 1d7: aload 11
      // 1d9: new net/minecraft/util/Vec3
      // 1dc: dup
      // 1dd: aload 11
      // 1df: getfield net/minecraft/entity/Entity.posX D
      // 1e2: aload 11
      // 1e4: getfield net/minecraft/entity/Entity.posY D
      // 1e7: aload 11
      // 1e9: getfield net/minecraft/entity/Entity.posZ D
      // 1ec: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 1ef: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 1f4: pop
      // 1f5: iload 2
      // 1f6: ifeq 07d
      // 1f9: aload 0
      // 1fa: getfield x/Z.Ǆ Ljava/util/Map;
      // 1fd: invokeinterface java/util/Map.keySet ()Ljava/util/Set; 1
      // 202: aload 3
      // 203: invokeinterface java/util/Set.retainAll (Ljava/util/Collection;)Z 2
      // 208: pop
      // 209: return
   }

   @oc66fa4f2195
   public void Ò(ocf923d5a814 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 2
      // 04: aload 1
      // 05: getfield x/ocb508b4e274.Ұ Lx/oc110d7f376c;
      // 08: getstatic x/oc110d7f376c.END Lx/oc110d7f376c;
      // 0b: if_acmpeq 10
      // 0e: return
      // 0f: athrow
      // 10: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 13: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 16: ifnonnull 23
      // 19: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 1c: ifne 25
      // 1f: goto 23
      // 22: athrow
      // 23: return
      // 24: athrow
      // 25: aload 0
      // 26: getfield x/Z.ԕ Ljava/util/Set;
      // 29: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 2e: astore 3
      // 2f: aload 3
      // 30: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 35: ifeq 78
      // 38: aload 3
      // 39: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 3e: checkcast net/minecraft/entity/Entity
      // 41: astore 4
      // 43: iload 2
      // 44: aload 0
      // 45: aload 4
      // 47: invokevirtual x/Z.Մ (Lnet/minecraft/entity/Entity;)Lnet/minecraft/item/ItemStack;
      // 4a: astore 5
      // 4c: ifne 7c
      // 4f: iload 2
      // 50: ifne 74
      // 53: goto 57
      // 56: athrow
      // 57: aload 5
      // 59: ifnonnull 68
      // 5c: goto 60
      // 5f: athrow
      // 60: iload 2
      // 61: ifeq 2f
      // 64: goto 68
      // 67: athrow
      // 68: aload 0
      // 69: aload 4
      // 6b: aload 5
      // 6d: aload 1
      // 6e: getfield x/ocf923d5a814.ô F
      // 71: invokevirtual x/Z.Ɔ (Lnet/minecraft/entity/Entity;Lnet/minecraft/item/ItemStack;F)V
      // 74: iload 2
      // 75: ifeq 2f
      // 78: goto 7c
      // 7b: astore 3
      // 7c: return
   }

   @oc66fa4f2195
   public void m(oc746a23b244 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: istore 2
      // 004: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 007: ifeq 022
      // 00a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 00d: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 010: ifnull 022
      // 013: goto 017
      // 016: athrow
      // 017: aload 0
      // 018: invokevirtual x/Z.Ѝ ()Z
      // 01b: ifne 024
      // 01e: goto 022
      // 021: athrow
      // 022: return
      // 023: athrow
      // 024: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 027: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 02a: getfield net/minecraft/client/multiplayer/WorldClient.loadedEntityList Ljava/util/List;
      // 02d: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 032: astore 3
      // 033: aload 3
      // 034: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 039: ifeq 132
      // 03c: aload 3
      // 03d: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 042: checkcast net/minecraft/entity/Entity
      // 045: astore 4
      // 047: iload 2
      // 048: ifne 136
      // 04b: aload 0
      // 04c: aload 4
      // 04e: invokevirtual x/Z.ʤ (Lnet/minecraft/entity/Entity;)Z
      // 051: iload 2
      // 052: ifne 075
      // 055: goto 059
      // 058: athrow
      // 059: ifne 068
      // 05c: goto 060
      // 05f: athrow
      // 060: iload 2
      // 061: ifeq 033
      // 064: goto 068
      // 067: athrow
      // 068: aload 4
      // 06a: iload 2
      // 06b: ifne 0a5
      // 06e: instanceof net/minecraft/entity/projectile/EntityLargeFireball
      // 071: goto 075
      // 074: athrow
      // 075: ifeq 09f
      // 078: aload 0
      // 079: getfield x/Z.Ȁ Lx/occ2f8dff8d8;
      // 07c: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 07f: iload 2
      // 080: ifne 0b0
      // 083: goto 087
      // 086: athrow
      // 087: ifeq 09f
      // 08a: goto 08e
      // 08d: athrow
      // 08e: aload 0
      // 08f: aload 4
      // 091: checkcast net/minecraft/entity/projectile/EntityLargeFireball
      // 094: invokevirtual x/Z.ι (Lnet/minecraft/entity/projectile/EntityLargeFireball;)V
      // 097: iload 2
      // 098: ifeq 12e
      // 09b: goto 09f
      // 09e: athrow
      // 09f: aload 4
      // 0a1: goto 0a5
      // 0a4: athrow
      // 0a5: iload 2
      // 0a6: ifne 0fd
      // 0a9: instanceof net/minecraft/entity/projectile/EntityArrow
      // 0ac: goto 0b0
      // 0af: athrow
      // 0b0: ifeq 0f7
      // 0b3: aload 0
      // 0b4: getfield x/Z.Ș Lx/occ2f8dff8d8;
      // 0b7: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0ba: iload 2
      // 0bb: ifne 100
      // 0be: goto 0c2
      // 0c1: athrow
      // 0c2: ifeq 0f7
      // 0c5: goto 0c9
      // 0c8: athrow
      // 0c9: aload 4
      // 0cb: iload 2
      // 0cc: ifne 0fd
      // 0cf: goto 0d3
      // 0d2: athrow
      // 0d3: checkcast x/oce1a6914380
      // 0d6: invokeinterface x/oce1a6914380.getInGround ()Z 1
      // 0db: ifne 0f7
      // 0de: goto 0e2
      // 0e1: athrow
      // 0e2: aload 0
      // 0e3: aload 4
      // 0e5: checkcast net/minecraft/entity/projectile/EntityArrow
      // 0e8: aload 1
      // 0e9: getfield x/oc746a23b244.Ё F
      // 0ec: invokevirtual x/Z.Ј (Lnet/minecraft/entity/projectile/EntityArrow;F)V
      // 0ef: iload 2
      // 0f0: ifeq 12e
      // 0f3: goto 0f7
      // 0f6: athrow
      // 0f7: aload 4
      // 0f9: goto 0fd
      // 0fc: athrow
      // 0fd: instanceof net/minecraft/entity/item/EntityEnderPearl
      // 100: iload 2
      // 101: ifne 11e
      // 104: ifeq 12e
      // 107: goto 10b
      // 10a: athrow
      // 10b: aload 0
      // 10c: iload 2
      // 10d: ifne 122
      // 110: goto 114
      // 113: athrow
      // 114: getfield x/Z.ɍ Lx/occ2f8dff8d8;
      // 117: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 11a: goto 11e
      // 11d: athrow
      // 11e: ifeq 12e
      // 121: aload 0
      // 122: aload 4
      // 124: checkcast net/minecraft/entity/item/EntityEnderPearl
      // 127: aload 1
      // 128: getfield x/oc746a23b244.Ё F
      // 12b: invokevirtual x/Z.ʝ (Lnet/minecraft/entity/item/EntityEnderPearl;F)V
      // 12e: iload 2
      // 12f: ifeq 033
      // 132: goto 136
      // 135: astore 3
      // 136: return
   }

   private ItemStack Մ(Entity param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 14
      // 09: ifnonnull 13
      // 0c: goto 10
      // 0f: athrow
      // 10: aconst_null
      // 11: areturn
      // 12: athrow
      // 13: aload 1
      // 14: iload 2
      // 15: ifne 41
      // 18: instanceof net/minecraft/entity/projectile/EntityArrow
      // 1b: ifeq 40
      // 1e: goto 22
      // 21: athrow
      // 22: aload 1
      // 23: checkcast x/oce1a6914380
      // 26: invokeinterface x/oce1a6914380.getInGround ()Z 1
      // 2b: ifeq 35
      // 2e: goto 32
      // 31: athrow
      // 32: aconst_null
      // 33: areturn
      // 34: athrow
      // 35: new net/minecraft/item/ItemStack
      // 38: dup
      // 39: getstatic net/minecraft/init/Items.arrow Lnet/minecraft/item/Item;
      // 3c: invokespecial net/minecraft/item/ItemStack.<init> (Lnet/minecraft/item/Item;)V
      // 3f: areturn
      // 40: aload 1
      // 41: iload 2
      // 42: ifne 5c
      // 45: instanceof net/minecraft/entity/projectile/EntityFireball
      // 48: ifeq 5b
      // 4b: goto 4f
      // 4e: athrow
      // 4f: new net/minecraft/item/ItemStack
      // 52: dup
      // 53: getstatic net/minecraft/init/Items.fire_charge Lnet/minecraft/item/Item;
      // 56: invokespecial net/minecraft/item/ItemStack.<init> (Lnet/minecraft/item/Item;)V
      // 59: areturn
      // 5a: athrow
      // 5b: aload 1
      // 5c: iload 2
      // 5d: ifne 77
      // 60: instanceof net/minecraft/entity/item/EntityEnderPearl
      // 63: ifeq 76
      // 66: goto 6a
      // 69: athrow
      // 6a: new net/minecraft/item/ItemStack
      // 6d: dup
      // 6e: getstatic net/minecraft/init/Items.ender_pearl Lnet/minecraft/item/Item;
      // 71: invokespecial net/minecraft/item/ItemStack.<init> (Lnet/minecraft/item/Item;)V
      // 74: areturn
      // 75: athrow
      // 76: aload 1
      // 77: iload 2
      // 78: ifne 92
      // 7b: instanceof net/minecraft/entity/projectile/EntityEgg
      // 7e: ifeq 91
      // 81: goto 85
      // 84: athrow
      // 85: new net/minecraft/item/ItemStack
      // 88: dup
      // 89: getstatic net/minecraft/init/Items.egg Lnet/minecraft/item/Item;
      // 8c: invokespecial net/minecraft/item/ItemStack.<init> (Lnet/minecraft/item/Item;)V
      // 8f: areturn
      // 90: athrow
      // 91: aload 1
      // 92: instanceof net/minecraft/entity/projectile/EntitySnowball
      // 95: ifeq a4
      // 98: new net/minecraft/item/ItemStack
      // 9b: dup
      // 9c: getstatic net/minecraft/init/Items.snowball Lnet/minecraft/item/Item;
      // 9f: invokespecial net/minecraft/item/ItemStack.<init> (Lnet/minecraft/item/Item;)V
      // a2: areturn
      // a3: athrow
      // a4: aconst_null
      // a5: areturn
   }

   private boolean ʤ(Entity param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 45
      // 09: instanceof net/minecraft/entity/projectile/EntityArrow
      // 0c: ifeq 44
      // 0f: goto 13
      // 12: athrow
      // 13: aload 1
      // 14: iload 2
      // 15: ifne 45
      // 18: goto 1c
      // 1b: athrow
      // 1c: checkcast x/oce1a6914380
      // 1f: invokeinterface x/oce1a6914380.getInGround ()Z 1
      // 24: ifne 44
      // 27: goto 2b
      // 2a: athrow
      // 2b: aload 0
      // 2c: getfield x/Z.ҥ Lx/occ2f8dff8d8;
      // 2f: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 32: iload 2
      // 33: ifne 50
      // 36: goto 3a
      // 39: athrow
      // 3a: ifeq 44
      // 3d: goto 41
      // 40: athrow
      // 41: bipush 1
      // 42: ireturn
      // 43: athrow
      // 44: aload 1
      // 45: iload 2
      // 46: ifne 6d
      // 49: instanceof net/minecraft/entity/projectile/EntityLargeFireball
      // 4c: goto 50
      // 4f: athrow
      // 50: ifeq 6c
      // 53: aload 0
      // 54: getfield x/Z.Ԁ Lx/occ2f8dff8d8;
      // 57: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 5a: iload 2
      // 5b: ifne 78
      // 5e: goto 62
      // 61: athrow
      // 62: ifeq 6c
      // 65: goto 69
      // 68: athrow
      // 69: bipush 1
      // 6a: ireturn
      // 6b: athrow
      // 6c: aload 1
      // 6d: iload 2
      // 6e: ifne 95
      // 71: instanceof net/minecraft/entity/item/EntityEnderPearl
      // 74: goto 78
      // 77: athrow
      // 78: ifeq 94
      // 7b: aload 0
      // 7c: getfield x/Z.ů Lx/occ2f8dff8d8;
      // 7f: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 82: iload 2
      // 83: ifne a0
      // 86: goto 8a
      // 89: athrow
      // 8a: ifeq 94
      // 8d: goto 91
      // 90: athrow
      // 91: bipush 1
      // 92: ireturn
      // 93: athrow
      // 94: aload 1
      // 95: iload 2
      // 96: ifne bd
      // 99: instanceof net/minecraft/entity/projectile/EntityEgg
      // 9c: goto a0
      // 9f: athrow
      // a0: ifeq bc
      // a3: aload 0
      // a4: getfield x/Z.Ə Lx/occ2f8dff8d8;
      // a7: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // aa: iload 2
      // ab: ifne c0
      // ae: goto b2
      // b1: athrow
      // b2: ifeq bc
      // b5: goto b9
      // b8: athrow
      // b9: bipush 1
      // ba: ireturn
      // bb: athrow
      // bc: aload 1
      // bd: instanceof net/minecraft/entity/projectile/EntitySnowball
      // c0: iload 2
      // c1: ifne e5
      // c4: ifeq e4
      // c7: goto cb
      // ca: athrow
      // cb: aload 0
      // cc: getfield x/Z.Ҡ Lx/occ2f8dff8d8;
      // cf: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // d2: iload 2
      // d3: ifne e5
      // d6: goto da
      // d9: athrow
      // da: ifeq e4
      // dd: goto e1
      // e0: athrow
      // e1: bipush 1
      // e2: ireturn
      // e3: athrow
      // e4: bipush 0
      // e5: ireturn
   }

   private void Ɔ(Entity param1, ItemStack param2, float param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: istore 4
      // 005: aload 0
      // 006: iload 4
      // 008: ifne 019
      // 00b: aload 1
      // 00c: invokevirtual x/Z.ʤ (Lnet/minecraft/entity/Entity;)Z
      // 00f: ifne 018
      // 012: goto 016
      // 015: athrow
      // 016: return
      // 017: athrow
      // 018: aload 0
      // 019: iload 4
      // 01b: ifne 02d
      // 01e: aload 1
      // 01f: aload 2
      // 020: invokevirtual x/Z.ռ (Lnet/minecraft/entity/Entity;Lnet/minecraft/item/ItemStack;)Z
      // 023: ifne 02c
      // 026: goto 02a
      // 029: athrow
      // 02a: return
      // 02b: athrow
      // 02c: aload 0
      // 02d: iload 4
      // 02f: ifne 04d
      // 032: getfield x/Z.ɵ Lx/occ2f8dff8d8;
      // 035: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 038: ifeq 04c
      // 03b: goto 03f
      // 03e: athrow
      // 03f: aload 1
      // 040: invokestatic x/ocbd4917c4b1.ž (Lnet/minecraft/entity/Entity;)Z
      // 043: ifeq 04c
      // 046: goto 04a
      // 049: athrow
      // 04a: return
      // 04b: athrow
      // 04c: aload 0
      // 04d: aload 2
      // 04e: invokevirtual x/Z.Ј (Lnet/minecraft/item/ItemStack;)Ljava/awt/Color;
      // 051: astore 5
      // 053: aload 0
      // 054: getfield x/Z.G Lx/occ2f8dff8d8;
      // 057: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 05a: iload 4
      // 05c: ifne 06f
      // 05f: ifeq 072
      // 062: goto 066
      // 065: athrow
      // 066: aload 5
      // 068: invokevirtual java/awt/Color.getRGB ()I
      // 06b: goto 06f
      // 06e: athrow
      // 06f: goto 073
      // 072: bipush -1
      // 073: istore 6
      // 075: iload 4
      // 077: aload 1
      // 078: getfield net/minecraft/entity/Entity.lastTickPosX D
      // 07b: aload 1
      // 07c: getfield net/minecraft/entity/Entity.posX D
      // 07f: aload 1
      // 080: getfield net/minecraft/entity/Entity.lastTickPosX D
      // 083: dsub
      // 084: fload 3
      // 085: f2d
      // 086: dmul
      // 087: dadd
      // 088: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 08b: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 08e: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosX D
      // 091: dsub
      // 092: dstore 7
      // 094: aload 1
      // 095: getfield net/minecraft/entity/Entity.lastTickPosY D
      // 098: aload 1
      // 099: getfield net/minecraft/entity/Entity.posY D
      // 09c: aload 1
      // 09d: getfield net/minecraft/entity/Entity.lastTickPosY D
      // 0a0: dsub
      // 0a1: fload 3
      // 0a2: f2d
      // 0a3: dmul
      // 0a4: dadd
      // 0a5: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0a8: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 0ab: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosY D
      // 0ae: dsub
      // 0af: aload 1
      // 0b0: getfield net/minecraft/entity/Entity.height F
      // 0b3: fconst_2
      // 0b4: fdiv
      // 0b5: f2d
      // 0b6: dadd
      // 0b7: dstore 9
      // 0b9: aload 1
      // 0ba: getfield net/minecraft/entity/Entity.lastTickPosZ D
      // 0bd: aload 1
      // 0be: getfield net/minecraft/entity/Entity.posZ D
      // 0c1: aload 1
      // 0c2: getfield net/minecraft/entity/Entity.lastTickPosZ D
      // 0c5: dsub
      // 0c6: fload 3
      // 0c7: f2d
      // 0c8: dmul
      // 0c9: dadd
      // 0ca: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0cd: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 0d0: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosZ D
      // 0d3: dsub
      // 0d4: dstore 11
      // 0d6: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0d9: getfield net/minecraft/client/Minecraft.entityRenderer Lnet/minecraft/client/renderer/EntityRenderer;
      // 0dc: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0df: invokeinterface x/oc8ecfa69e1b.getTimer ()Lnet/minecraft/util/Timer; 1
      // 0e4: getfield net/minecraft/util/Timer.renderPartialTicks F
      // 0e7: bipush 0
      // 0e8: invokeinterface x/oc65f19d876a.callSetupCameraTransform (FI)V 3
      // 0ed: new net/minecraft/client/gui/ScaledResolution
      // 0f0: dup
      // 0f1: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0f4: invokespecial net/minecraft/client/gui/ScaledResolution.<init> (Lnet/minecraft/client/Minecraft;)V
      // 0f7: astore 13
      // 0f9: aload 13
      // 0fb: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaleFactor ()I
      // 0fe: dload 7
      // 100: dload 9
      // 102: dload 11
      // 104: invokestatic x/ocbd4917c4b1.ʵ (IDDD)Lnet/minecraft/util/Vec3;
      // 107: astore 14
      // 109: ifne 122
      // 10c: aload 14
      // 10e: ifnull 545
      // 111: goto 115
      // 114: athrow
      // 115: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 118: getfield net/minecraft/client/Minecraft.entityRenderer Lnet/minecraft/client/renderer/EntityRenderer;
      // 11b: invokevirtual net/minecraft/client/renderer/EntityRenderer.setupOverlayRendering ()V
      // 11e: goto 122
      // 121: athrow
      // 122: new net/minecraft/client/gui/ScaledResolution
      // 125: dup
      // 126: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 129: invokespecial net/minecraft/client/gui/ScaledResolution.<init> (Lnet/minecraft/client/Minecraft;)V
      // 12c: astore 15
      // 12e: aload 14
      // 130: getfield net/minecraft/util/Vec3.xCoord D
      // 133: aload 15
      // 135: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledWidth ()I
      // 138: i2d
      // 139: ldc2_w 2.0
      // 13c: ddiv
      // 13d: dsub
      // 13e: dstore 16
      // 140: aload 14
      // 142: getfield net/minecraft/util/Vec3.yCoord D
      // 145: aload 15
      // 147: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledHeight ()I
      // 14a: i2d
      // 14b: ldc2_w 2.0
      // 14e: ddiv
      // 14f: dsub
      // 150: dstore 18
      // 152: aload 14
      // 154: getfield net/minecraft/util/Vec3.zCoord D
      // 157: ldc2_w 1.0003684
      // 15a: dcmpg
      // 15b: iload 4
      // 15d: ifne 168
      // 160: ifge 16b
      // 163: goto 167
      // 166: athrow
      // 167: bipush 1
      // 168: goto 16c
      // 16b: bipush 0
      // 16c: istore 20
      // 16e: iload 4
      // 170: ifne 184
      // 173: iload 20
      // 175: ifne 18c
      // 178: goto 17c
      // 17b: athrow
      // 17c: dload 16
      // 17e: ldc2_w -1.0
      // 181: dmul
      // 182: dstore 16
      // 184: dload 18
      // 186: ldc2_w -1.0
      // 189: dmul
      // 18a: dstore 18
      // 18c: dload 16
      // 18e: dload 18
      // 190: invokestatic java/lang/Math.atan2 (DD)D
      // 193: dstore 21
      // 195: dload 18
      // 197: dload 16
      // 199: invokestatic java/lang/Math.atan2 (DD)D
      // 19c: ldc2_w 57.295780181884766
      // 19f: dmul
      // 1a0: ldc2_w 90.0
      // 1a3: dadd
      // 1a4: dstore 23
      // 1a6: dload 16
      // 1a8: dload 18
      // 1aa: invokestatic java/lang/Math.hypot (DD)D
      // 1ad: dstore 25
      // 1af: aload 0
      // 1b0: getfield x/Z.Ғ Lx/oca9cc61aada;
      // 1b3: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 1b6: dstore 27
      // 1b8: aload 0
      // 1b9: getfield x/Z.Ƽ Lx/occ2f8dff8d8;
      // 1bc: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 1bf: iload 4
      // 1c1: ifne 1d5
      // 1c4: ifeq 1d3
      // 1c7: goto 1cb
      // 1ca: athrow
      // 1cb: dload 27
      // 1cd: ldc2_w 20.0
      // 1d0: dadd
      // 1d1: dstore 27
      // 1d3: iload 20
      // 1d5: iload 4
      // 1d7: ifne 201
      // 1da: ifeq 1fc
      // 1dd: goto 1e1
      // 1e0: athrow
      // 1e1: dload 25
      // 1e3: dload 27
      // 1e5: iload 4
      // 1e7: ifne 205
      // 1ea: goto 1ee
      // 1ed: athrow
      // 1ee: ldc2_w 15.0
      // 1f1: dadd
      // 1f2: dcmpg
      // 1f3: ifge 1fc
      // 1f6: goto 1fa
      // 1f9: athrow
      // 1fa: return
      // 1fb: athrow
      // 1fc: aload 15
      // 1fe: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledWidth ()I
      // 201: i2d
      // 202: ldc2_w 2.0
      // 205: ddiv
      // 206: dstore 29
      // 208: aload 15
      // 20a: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledHeight ()I
      // 20d: i2d
      // 20e: ldc2_w 2.0
      // 211: ddiv
      // 212: dstore 31
      // 214: dload 21
      // 216: invokestatic java/lang/Math.sin (D)D
      // 219: dstore 33
      // 21b: dload 21
      // 21d: invokestatic java/lang/Math.cos (D)D
      // 220: dstore 35
      // 222: dload 29
      // 224: dload 27
      // 226: dload 33
      // 228: dmul
      // 229: dadd
      // 22a: dstore 37
      // 22c: dload 31
      // 22e: dload 27
      // 230: dload 35
      // 232: dmul
      // 233: dadd
      // 234: dstore 39
      // 236: invokestatic net/minecraft/client/renderer/GlStateManager.pushMatrix ()V
      // 239: dload 37
      // 23b: dload 39
      // 23d: dconst_0
      // 23e: invokestatic net/minecraft/client/renderer/GlStateManager.translate (DDD)V
      // 241: dload 23
      // 243: d2f
      // 244: fconst_0
      // 245: fconst_0
      // 246: fconst_1
      // 247: invokestatic net/minecraft/client/renderer/GlStateManager.rotate (FFFF)V
      // 24a: fconst_1
      // 24b: fconst_1
      // 24c: fconst_1
      // 24d: invokestatic net/minecraft/client/renderer/GlStateManager.scale (FFF)V
      // 250: aload 0
      // 251: getfield x/Z.Ƕ Lx/oca9cc61aada;
      // 254: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 257: d2i
      // 258: istore 41
      // 25a: iload 41
      // 25c: iload 4
      // 25e: ifne 352
      // 261: ifne 34c
      // 264: goto 268
      // 267: athrow
      // 268: iload 6
      // 26a: iload 4
      // 26c: ifne 293
      // 26f: goto 273
      // 272: athrow
      // 273: bipush -1
      // 274: if_icmpne 28a
      // 277: goto 27b
      // 27a: athrow
      // 27b: dconst_1
      // 27c: dconst_1
      // 27d: dconst_1
      // 27e: invokestatic org/lwjgl/opengl/GL11.glColor3d (DDD)V
      // 281: iload 4
      // 283: ifeq 2a3
      // 286: goto 28a
      // 289: athrow
      // 28a: aload 5
      // 28c: invokevirtual java/awt/Color.getRed ()I
      // 28f: goto 293
      // 292: athrow
      // 293: i2d
      // 294: aload 5
      // 296: invokevirtual java/awt/Color.getGreen ()I
      // 299: i2d
      // 29a: aload 5
      // 29c: invokevirtual java/awt/Color.getBlue ()I
      // 29f: i2d
      // 2a0: invokestatic org/lwjgl/opengl/GL11.glColor3d (DDD)V
      // 2a3: ldc_w -281113627
      // 2a6: ldc_w -281116665
      // 2a9: ixor
      // 2aa: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 2ad: iload 4
      // 2af: ldc_w -281113114
      // 2b2: ldc_w -281116665
      // 2b5: ixor
      // 2b6: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 2b9: ldc_w -281115899
      // 2bc: ldc_w -281116665
      // 2bf: ixor
      // 2c0: ldc_w -281115900
      // 2c3: ldc_w -281116665
      // 2c6: ixor
      // 2c7: invokestatic org/lwjgl/opengl/GL11.glBlendFunc (II)V
      // 2ca: ldc_w -281113817
      // 2cd: ldc_w -281116665
      // 2d0: ixor
      // 2d1: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 2d4: ldc2_w 0.6108652353286743
      // 2d7: dstore 42
      // 2d9: ldc2_w 9.0
      // 2dc: dstore 44
      // 2de: ldc2_w 5.0
      // 2e1: dstore 46
      // 2e3: ldc_w 3.0
      // 2e6: invokestatic org/lwjgl/opengl/GL11.glLineWidth (F)V
      // 2e9: ldc_w -281116668
      // 2ec: ldc_w -281116665
      // 2ef: ixor
      // 2f0: invokestatic org/lwjgl/opengl/GL11.glBegin (I)V
      // 2f3: dload 42
      // 2f5: dneg
      // 2f6: invokestatic java/lang/Math.sin (D)D
      // 2f9: dload 44
      // 2fb: dmul
      // 2fc: dload 42
      // 2fe: dneg
      // 2ff: invokestatic java/lang/Math.cos (D)D
      // 302: dload 44
      // 304: dmul
      // 305: dload 46
      // 307: dsub
      // 308: invokestatic org/lwjgl/opengl/GL11.glVertex2d (DD)V
      // 30b: dconst_0
      // 30c: dload 46
      // 30e: dneg
      // 30f: invokestatic org/lwjgl/opengl/GL11.glVertex2d (DD)V
      // 312: dload 42
      // 314: invokestatic java/lang/Math.sin (D)D
      // 317: dload 44
      // 319: dmul
      // 31a: dload 42
      // 31c: invokestatic java/lang/Math.cos (D)D
      // 31f: dload 44
      // 321: dmul
      // 322: dload 46
      // 324: dsub
      // 325: invokestatic org/lwjgl/opengl/GL11.glVertex2d (DD)V
      // 328: invokestatic x/oc170ea29aae.ŷ ()V
      // 32b: ldc_w -281113114
      // 32e: ldc_w -281116665
      // 331: ixor
      // 332: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 335: ldc_w -281113627
      // 338: ldc_w -281116665
      // 33b: ixor
      // 33c: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 33f: ldc_w -281113817
      // 342: ldc_w -281116665
      // 345: ixor
      // 346: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 349: ifeq 3cb
      // 34c: iload 41
      // 34e: goto 352
      // 351: athrow
      // 352: iload 4
      // 354: ifne 399
      // 357: bipush 1
      // 358: if_icmpne 393
      // 35b: goto 35f
      // 35e: athrow
      // 35f: ldc_w -90.0
      // 362: fconst_0
      // 363: fconst_0
      // 364: fconst_1
      // 365: invokestatic net/minecraft/client/renderer/GlStateManager.rotate (FFFF)V
      // 368: iload 4
      // 36a: ldc2_w 1.5
      // 36d: ldc2_w 1.5
      // 370: ldc2_w 1.5
      // 373: invokestatic net/minecraft/client/renderer/GlStateManager.scale (DDD)V
      // 376: aload 0
      // 377: invokevirtual x/Z.ԥ ()Lx/oc1378bc114d;
      // 37a: astore 42
      // 37c: aload 42
      // 37e: ldc_w ">"
      // 381: ldc_w -2.0
      // 384: ldc_w -4.0
      // 387: iload 6
      // 389: bipush 0
      // 38a: invokeinterface x/oc1378bc114d.z$ao2ykh4tuw6w (Ljava/lang/String;FFIZ)I 6
      // 38f: pop
      // 390: ifeq 3cb
      // 393: iload 41
      // 395: goto 399
      // 398: athrow
      // 399: iload 4
      // 39b: ifne 411
      // 39e: ldc_w -281116667
      // 3a1: ldc_w -281116665
      // 3a4: ixor
      // 3a5: if_icmpne 3cb
      // 3a8: goto 3ac
      // 3ab: athrow
      // 3ac: dconst_0
      // 3ad: dconst_0
      // 3ae: ldc2_w 5.0
      // 3b1: ldc_w -281116668
      // 3b4: ldc_w -281116665
      // 3b7: ixor
      // 3b8: iload 6
      // 3ba: ldc_w -281116424
      // 3bd: ldc_w -281116665
      // 3c0: ixor
      // 3c1: invokestatic x/oc7ab2161b9f.Ҭ (II)I
      // 3c4: invokestatic x/ocbd4917c4b1.İ (DDDII)V
      // 3c7: goto 3cb
      // 3ca: athrow
      // 3cb: invokestatic net/minecraft/client/renderer/GlStateManager.popMatrix ()V
      // 3ce: dload 29
      // 3d0: dload 27
      // 3d2: ldc2_w 13.0
      // 3d5: dsub
      // 3d6: dload 33
      // 3d8: dmul
      // 3d9: dadd
      // 3da: dstore 37
      // 3dc: dload 31
      // 3de: dload 27
      // 3e0: ldc2_w 13.0
      // 3e3: dsub
      // 3e4: dload 35
      // 3e6: dmul
      // 3e7: dadd
      // 3e8: dstore 39
      // 3ea: invokestatic net/minecraft/client/renderer/GlStateManager.pushMatrix ()V
      // 3ed: dload 37
      // 3ef: dload 39
      // 3f1: dconst_0
      // 3f2: invokestatic net/minecraft/client/renderer/GlStateManager.translate (DDD)V
      // 3f5: ldc2_w 0.8
      // 3f8: ldc2_w 0.8
      // 3fb: ldc2_w 0.8
      // 3fe: invokestatic net/minecraft/client/renderer/GlStateManager.scale (DDD)V
      // 401: aload 0
      // 402: iload 4
      // 404: ifne 478
      // 407: getfield x/Z.Ǳ Lx/occ2f8dff8d8;
      // 40a: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 40d: goto 411
      // 410: athrow
      // 411: ifeq 474
      // 414: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 417: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 41a: aload 1
      // 41b: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getDistanceToEntity (Lnet/minecraft/entity/Entity;)F
      // 41e: f2i
      // 41f: invokedynamic makeConcatWithConstants (I)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001m" ]
      // 424: astore 42
      // 426: aload 0
      // 427: invokevirtual x/Z.ԥ ()Lx/oc1378bc114d;
      // 42a: astore 43
      // 42c: aload 43
      // 42e: aload 42
      // 430: invokeinterface x/oc1378bc114d.z$toz8pt08w0nc (Ljava/lang/String;)I 2
      // 435: ineg
      // 436: i2f
      // 437: fconst_2
      // 438: fdiv
      // 439: fstore 44
      // 43b: fload 44
      // 43d: invokestatic x/oce6044968f8.ǆ ()F
      // 440: fsub
      // 441: ldc_w -4.0
      // 444: invokestatic x/oce6044968f8.š ()F
      // 447: fsub
      // 448: aload 43
      // 44a: aload 42
      // 44c: invokeinterface x/oc1378bc114d.z$toz8pt08w0nc (Ljava/lang/String;)I 2
      // 451: i2f
      // 452: invokestatic x/oce6044968f8.ǆ ()F
      // 455: fconst_2
      // 456: fmul
      // 457: fadd
      // 458: aload 43
      // 45a: invokeinterface x/oc1378bc114d.z$1tqmx4tpnr6lq ()I 1
      // 45f: i2f
      // 460: invokestatic x/oce6044968f8.š ()F
      // 463: fconst_2
      // 464: fmul
      // 465: fadd
      // 466: aload 43
      // 468: aload 42
      // 46a: fload 44
      // 46c: invokedynamic run (Lx/oc1378bc114d;Ljava/lang/String;F)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, x/Z.q1g7m2t8h5mzhm (Lx/oc1378bc114d;Ljava/lang/String;F)V, ()V ]
      // 471: invokestatic x/oce6044968f8.ӱ (FFFFLjava/lang/Runnable;)V
      // 474: invokestatic net/minecraft/client/renderer/GlStateManager.popMatrix ()V
      // 477: aload 0
      // 478: getfield x/Z.Ƽ Lx/occ2f8dff8d8;
      // 47b: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 47e: ifeq 545
      // 481: aload 2
      // 482: iload 4
      // 484: ifne 4a3
      // 487: goto 48b
      // 48a: athrow
      // 48b: ifnull 545
      // 48e: goto 492
      // 491: athrow
      // 492: invokestatic net/minecraft/client/renderer/GlStateManager.pushMatrix ()V
      // 495: iload 4
      // 497: ifne 52a
      // 49a: goto 49e
      // 49d: athrow
      // 49e: aload 2
      // 49f: goto 4a3
      // 4a2: athrow
      // 4a3: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 4a6: getstatic net/minecraft/init/Items.arrow Lnet/minecraft/item/Item;
      // 4a9: if_acmpne 500
      // 4ac: dload 29
      // 4ae: dload 27
      // 4b0: ldc2_w 26.0
      // 4b3: dsub
      // 4b4: dload 33
      // 4b6: dmul
      // 4b7: dadd
      // 4b8: dstore 37
      // 4ba: iload 4
      // 4bc: dload 31
      // 4be: dload 27
      // 4c0: ldc2_w 26.0
      // 4c3: dsub
      // 4c4: dload 35
      // 4c6: dmul
      // 4c7: dadd
      // 4c8: dstore 39
      // 4ca: dload 37
      // 4cc: dload 39
      // 4ce: dconst_0
      // 4cf: invokestatic net/minecraft/client/renderer/GlStateManager.translate (DDD)V
      // 4d2: fconst_1
      // 4d3: fconst_1
      // 4d4: fconst_1
      // 4d5: invokestatic net/minecraft/client/renderer/GlStateManager.scale (FFF)V
      // 4d8: dload 23
      // 4da: d2f
      // 4db: ldc_w 45.0
      // 4de: fsub
      // 4df: fconst_0
      // 4e0: fconst_0
      // 4e1: fconst_1
      // 4e2: invokestatic net/minecraft/client/renderer/GlStateManager.rotate (FFFF)V
      // 4e5: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 4e8: invokevirtual net/minecraft/client/Minecraft.getRenderItem ()Lnet/minecraft/client/renderer/entity/RenderItem;
      // 4eb: aload 2
      // 4ec: ldc_w 281116659
      // 4ef: ldc_w -281116665
      // 4f2: ixor
      // 4f3: ldc_w 281116667
      // 4f6: ldc_w -281116665
      // 4f9: ixor
      // 4fa: invokevirtual net/minecraft/client/renderer/entity/RenderItem.renderItemIntoGUI (Lnet/minecraft/item/ItemStack;II)V
      // 4fd: ifeq 542
      // 500: dload 29
      // 502: dload 27
      // 504: ldc2_w 29.0
      // 507: dsub
      // 508: dload 33
      // 50a: dmul
      // 50b: dadd
      // 50c: dstore 37
      // 50e: dload 31
      // 510: dload 27
      // 512: ldc2_w 29.0
      // 515: dsub
      // 516: dload 35
      // 518: dmul
      // 519: dadd
      // 51a: dstore 39
      // 51c: dload 37
      // 51e: dload 39
      // 520: dconst_0
      // 521: invokestatic net/minecraft/client/renderer/GlStateManager.translate (DDD)V
      // 524: fconst_1
      // 525: fconst_1
      // 526: fconst_1
      // 527: invokestatic net/minecraft/client/renderer/GlStateManager.scale (FFF)V
      // 52a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 52d: invokevirtual net/minecraft/client/Minecraft.getRenderItem ()Lnet/minecraft/client/renderer/entity/RenderItem;
      // 530: aload 2
      // 531: ldc_w 281116671
      // 534: ldc_w -281116665
      // 537: ixor
      // 538: ldc_w 281116656
      // 53b: ldc_w -281116665
      // 53e: ixor
      // 53f: invokevirtual net/minecraft/client/renderer/entity/RenderItem.renderItemIntoGUI (Lnet/minecraft/item/ItemStack;II)V
      // 542: invokestatic net/minecraft/client/renderer/GlStateManager.popMatrix ()V
      // 545: return
   }

   private Color Ј(ItemStack param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 16
      // 09: ifnonnull 15
      // 0c: goto 10
      // 0f: athrow
      // 10: getstatic java/awt/Color.WHITE Ljava/awt/Color;
      // 13: areturn
      // 14: athrow
      // 15: aload 1
      // 16: iload 2
      // 17: ifne 40
      // 1a: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 1d: getstatic net/minecraft/init/Items.ender_pearl Lnet/minecraft/item/Item;
      // 20: if_acmpne 3f
      // 23: goto 27
      // 26: athrow
      // 27: new java/awt/Color
      // 2a: dup
      // 2b: ldc_w -426063492
      // 2e: ldc_w -426063442
      // 31: ixor
      // 32: bipush 0
      // 33: ldc_w -426063535
      // 36: ldc_w -426063442
      // 39: ixor
      // 3a: invokespecial java/awt/Color.<init> (III)V
      // 3d: areturn
      // 3e: athrow
      // 3f: aload 1
      // 40: iload 2
      // 41: ifne 6a
      // 44: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 47: getstatic net/minecraft/init/Items.fire_charge Lnet/minecraft/item/Item;
      // 4a: if_acmpne 69
      // 4d: goto 51
      // 50: athrow
      // 51: new java/awt/Color
      // 54: dup
      // 55: ldc_w -426063535
      // 58: ldc_w -426063442
      // 5b: ixor
      // 5c: ldc_w -426063560
      // 5f: ldc_w -426063442
      // 62: ixor
      // 63: bipush 0
      // 64: invokespecial java/awt/Color.<init> (III)V
      // 67: areturn
      // 68: athrow
      // 69: aload 1
      // 6a: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 6d: getstatic net/minecraft/init/Items.egg Lnet/minecraft/item/Item;
      // 70: if_acmpne 91
      // 73: new java/awt/Color
      // 76: dup
      // 77: ldc_w -426063535
      // 7a: ldc_w -426063442
      // 7d: ixor
      // 7e: ldc_w -426063552
      // 81: ldc_w -426063442
      // 84: ixor
      // 85: ldc_w -426063564
      // 88: ldc_w -426063442
      // 8b: ixor
      // 8c: invokespecial java/awt/Color.<init> (III)V
      // 8f: areturn
      // 90: athrow
      // 91: getstatic java/awt/Color.WHITE Ljava/awt/Color;
      // 94: areturn
   }

   private boolean ռ(Entity var1, ItemStack var2) {
      return true;
   }

   private boolean Ѝ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 2d
      // 09: getfield x/Z.Ԁ Lx/occ2f8dff8d8;
      // 0c: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0f: ifeq 2c
      // 12: goto 16
      // 15: athrow
      // 16: aload 0
      // 17: getfield x/Z.Ȁ Lx/occ2f8dff8d8;
      // 1a: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 1d: iload 1
      // 1e: ifne 81
      // 21: goto 25
      // 24: athrow
      // 25: ifne 80
      // 28: goto 2c
      // 2b: athrow
      // 2c: aload 0
      // 2d: getfield x/Z.ҥ Lx/occ2f8dff8d8;
      // 30: iload 1
      // 31: ifne 64
      // 34: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 37: ifeq 54
      // 3a: goto 3e
      // 3d: athrow
      // 3e: aload 0
      // 3f: getfield x/Z.Ș Lx/occ2f8dff8d8;
      // 42: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 45: iload 1
      // 46: ifne 81
      // 49: goto 4d
      // 4c: athrow
      // 4d: ifne 80
      // 50: goto 54
      // 53: athrow
      // 54: aload 0
      // 55: iload 1
      // 56: ifne 6f
      // 59: goto 5d
      // 5c: athrow
      // 5d: getfield x/Z.ů Lx/occ2f8dff8d8;
      // 60: goto 64
      // 63: athrow
      // 64: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 67: ifeq 84
      // 6a: aload 0
      // 6b: goto 6f
      // 6e: athrow
      // 6f: getfield x/Z.ɍ Lx/occ2f8dff8d8;
      // 72: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 75: iload 1
      // 76: ifne 81
      // 79: ifeq 84
      // 7c: goto 80
      // 7f: athrow
      // 80: bipush 1
      // 81: goto 85
      // 84: bipush 0
      // 85: ireturn
   }

   private void ԟ() {
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
      // 06: ifne 4a
      // 09: getfield x/Z.Ȁ Lx/occ2f8dff8d8;
      // 0c: ifnull 49
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: getfield x/Z.Ȁ Lx/occ2f8dff8d8;
      // 17: aload 0
      // 18: iload 1
      // 19: ifne 2f
      // 1c: goto 20
      // 1f: athrow
      // 20: getfield x/Z.Ԁ Lx/occ2f8dff8d8;
      // 23: ifnull 44
      // 26: goto 2a
      // 29: athrow
      // 2a: aload 0
      // 2b: goto 2f
      // 2e: athrow
      // 2f: getfield x/Z.Ԁ Lx/occ2f8dff8d8;
      // 32: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 35: iload 1
      // 36: ifne 41
      // 39: ifeq 44
      // 3c: goto 40
      // 3f: athrow
      // 40: bipush 1
      // 41: goto 45
      // 44: bipush 0
      // 45: aload 0
      // 46: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 49: aload 0
      // 4a: iload 1
      // 4b: ifne 8f
      // 4e: getfield x/Z.Ș Lx/occ2f8dff8d8;
      // 51: ifnull 8e
      // 54: goto 58
      // 57: athrow
      // 58: aload 0
      // 59: getfield x/Z.Ș Lx/occ2f8dff8d8;
      // 5c: aload 0
      // 5d: iload 1
      // 5e: ifne 74
      // 61: goto 65
      // 64: athrow
      // 65: getfield x/Z.ҥ Lx/occ2f8dff8d8;
      // 68: ifnull 89
      // 6b: goto 6f
      // 6e: athrow
      // 6f: aload 0
      // 70: goto 74
      // 73: athrow
      // 74: getfield x/Z.ҥ Lx/occ2f8dff8d8;
      // 77: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 7a: iload 1
      // 7b: ifne 86
      // 7e: ifeq 89
      // 81: goto 85
      // 84: athrow
      // 85: bipush 1
      // 86: goto 8a
      // 89: bipush 0
      // 8a: aload 0
      // 8b: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 8e: aload 0
      // 8f: iload 1
      // 90: ifne a2
      // 93: getfield x/Z.ɍ Lx/occ2f8dff8d8;
      // 96: ifnull d3
      // 99: goto 9d
      // 9c: athrow
      // 9d: aload 0
      // 9e: goto a2
      // a1: athrow
      // a2: getfield x/Z.ɍ Lx/occ2f8dff8d8;
      // a5: aload 0
      // a6: iload 1
      // a7: ifne b9
      // aa: getfield x/Z.ů Lx/occ2f8dff8d8;
      // ad: ifnull ce
      // b0: goto b4
      // b3: athrow
      // b4: aload 0
      // b5: goto b9
      // b8: athrow
      // b9: getfield x/Z.ů Lx/occ2f8dff8d8;
      // bc: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // bf: iload 1
      // c0: ifne cb
      // c3: ifeq ce
      // c6: goto ca
      // c9: athrow
      // ca: bipush 1
      // cb: goto cf
      // ce: bipush 0
      // cf: aload 0
      // d0: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // d3: return
   }

   private void ι(EntityLargeFireball param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 1
      // 01: invokestatic x/oca163026023.Ω (Lnet/minecraft/entity/projectile/EntityLargeFireball;)Lx/oc94a86ee062;
      // 04: astore 3
      // 05: getstatic x/oce6044968f8.ђ Z
      // 08: aload 3
      // 09: invokevirtual x/oc94a86ee062.Ʃ ()Lnet/minecraft/util/Vec3;
      // 0c: astore 4
      // 0e: istore 2
      // 0f: aload 3
      // 10: invokevirtual x/oc94a86ee062.ѿ ()Z
      // 13: ifeq 27
      // 16: aload 4
      // 18: iload 2
      // 19: ifne 4b
      // 1c: goto 20
      // 1f: athrow
      // 20: ifnonnull 28
      // 23: goto 27
      // 26: athrow
      // 27: return
      // 28: aload 4
      // 2a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 2d: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 30: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosX D
      // 33: dneg
      // 34: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 37: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 3a: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosY D
      // 3d: dneg
      // 3e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 41: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 44: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosZ D
      // 47: dneg
      // 48: invokevirtual net/minecraft/util/Vec3.addVector (DDD)Lnet/minecraft/util/Vec3;
      // 4b: astore 5
      // 4d: aload 3
      // 4e: invokevirtual x/oc94a86ee062.ʘ ()Lnet/minecraft/util/Vec3;
      // 51: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 54: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 57: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosX D
      // 5a: dneg
      // 5b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 5e: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 61: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosY D
      // 64: dneg
      // 65: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 68: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 6b: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosZ D
      // 6e: dneg
      // 6f: invokevirtual net/minecraft/util/Vec3.addVector (DDD)Lnet/minecraft/util/Vec3;
      // 72: astore 6
      // 74: bipush 0
      // 75: aload 1
      // 76: getfield net/minecraft/entity/projectile/EntityLargeFireball.explosionPower I
      // 79: invokestatic java/lang/Math.max (II)I
      // 7c: i2d
      // 7d: ldc2_w 2.0
      // 80: dmul
      // 81: dstore 7
      // 83: aload 5
      // 85: dload 7
      // 87: ldc_w 830425954
      // 8a: ldc_w 830518429
      // 8d: ixor
      // 8e: ldc_w 0.06
      // 91: ldc_w 0.3
      // 94: bipush 1
      // 95: invokestatic x/oc3c7d73111d.Җ (Lnet/minecraft/util/Vec3;DIFFZ)V
      // 98: aload 6
      // 9a: aload 1
      // 9b: getfield net/minecraft/entity/projectile/EntityLargeFireball.width F
      // 9e: f2d
      // 9f: ldc2_w 0.5
      // a2: dmul
      // a3: ldc_w 830465229
      // a6: ldc_w 830518429
      // a9: ixor
      // aa: ldc_w 0.2
      // ad: ldc_w 0.65
      // b0: bipush 1
      // b1: invokestatic x/oc3c7d73111d.Җ (Lnet/minecraft/util/Vec3;DIFFZ)V
      // b4: return
   }

   private void Ј(EntityArrow var1, float var2) {
      oc8ea84f7e0d var3 = new oc8ea84f7e0d(0.05, 0.99, 0.6, Math.max(var1.width * 0.5, 0.25), var1.width, var1.height, true, -1143886860 ^ -1143886863);
      this.Ǎ(var1, var2, this.ǿ(var1, var3, var1.shootingEntity), Color.WHITE);
   }

   private void ʝ(EntityEnderPearl param1, float param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: new x/oc8ea84f7e0d
      // 06: dup
      // 07: ldc2_w 0.03
      // 0a: ldc2_w 0.99
      // 0d: ldc2_w 0.8
      // 10: aload 1
      // 11: getfield net/minecraft/entity/item/EntityEnderPearl.width F
      // 14: f2d
      // 15: ldc2_w 0.5
      // 18: dmul
      // 19: ldc2_w 0.125
      // 1c: invokestatic java/lang/Math.max (DD)D
      // 1f: aload 1
      // 20: getfield net/minecraft/entity/item/EntityEnderPearl.width F
      // 23: f2d
      // 24: aload 1
      // 25: getfield net/minecraft/entity/item/EntityEnderPearl.height F
      // 28: f2d
      // 29: bipush 0
      // 2a: ldc_w 1378041513
      // 2d: ldc_w 1378041516
      // 30: ixor
      // 31: invokespecial x/oc8ea84f7e0d.<init> (DDDDDDZI)V
      // 34: astore 4
      // 36: istore 3
      // 37: aload 0
      // 38: iload 3
      // 39: ifne 4e
      // 3c: getfield x/Z.G Lx/occ2f8dff8d8;
      // 3f: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 42: ifeq 5e
      // 45: goto 49
      // 48: athrow
      // 49: aload 0
      // 4a: goto 4e
      // 4d: athrow
      // 4e: new net/minecraft/item/ItemStack
      // 51: dup
      // 52: getstatic net/minecraft/init/Items.ender_pearl Lnet/minecraft/item/Item;
      // 55: invokespecial net/minecraft/item/ItemStack.<init> (Lnet/minecraft/item/Item;)V
      // 58: invokevirtual x/Z.Ј (Lnet/minecraft/item/ItemStack;)Ljava/awt/Color;
      // 5b: goto 61
      // 5e: getstatic java/awt/Color.WHITE Ljava/awt/Color;
      // 61: astore 5
      // 63: aload 0
      // 64: aload 1
      // 65: fload 2
      // 66: aload 0
      // 67: aload 1
      // 68: aload 4
      // 6a: aload 1
      // 6b: invokevirtual net/minecraft/entity/item/EntityEnderPearl.getThrower ()Lnet/minecraft/entity/EntityLivingBase;
      // 6e: invokevirtual x/Z.ǿ (Lnet/minecraft/entity/Entity;Lx/oc8ea84f7e0d;Lnet/minecraft/entity/Entity;)Lx/oc9f62920480;
      // 71: aload 5
      // 73: invokevirtual x/Z.Ǎ (Lnet/minecraft/entity/Entity;FLx/oc9f62920480;Ljava/awt/Color;)V
      // 76: return
   }

   private oc9f62920480 ǿ(Entity param1, oc8ea84f7e0d param2, Entity param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: aload 1
      // 001: getfield net/minecraft/entity/Entity.posX D
      // 004: dstore 5
      // 006: aload 1
      // 007: getfield net/minecraft/entity/Entity.posY D
      // 00a: dstore 7
      // 00c: getstatic x/oce6044968f8.ђ Z
      // 00f: aload 1
      // 010: getfield net/minecraft/entity/Entity.posZ D
      // 013: dstore 9
      // 015: istore 4
      // 017: aload 1
      // 018: getfield net/minecraft/entity/Entity.motionX D
      // 01b: dstore 11
      // 01d: aload 1
      // 01e: getfield net/minecraft/entity/Entity.motionY D
      // 021: dstore 13
      // 023: aload 1
      // 024: getfield net/minecraft/entity/Entity.motionZ D
      // 027: dstore 15
      // 029: bipush 0
      // 02a: aload 1
      // 02b: getfield net/minecraft/entity/Entity.ticksExisted I
      // 02e: invokestatic java/lang/Math.max (II)I
      // 031: istore 17
      // 033: new java/util/ArrayList
      // 036: dup
      // 037: invokespecial java/util/ArrayList.<init> ()V
      // 03a: astore 18
      // 03c: aload 18
      // 03e: new net/minecraft/util/Vec3
      // 041: dup
      // 042: dload 5
      // 044: dload 7
      // 046: dload 9
      // 048: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 04b: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 050: pop
      // 051: bipush 0
      // 052: istore 19
      // 054: iload 19
      // 056: ldc_w 931453126
      // 059: ldc_w 931453118
      // 05c: ixor
      // 05d: if_icmpge 3c2
      // 060: aload 0
      // 061: dload 5
      // 063: dload 7
      // 065: dload 9
      // 067: aload 2
      // 068: getfield x/oc8ea84f7e0d.ь D
      // 06b: aload 2
      // 06c: getfield x/oc8ea84f7e0d.ћ D
      // 06f: aload 1
      // 070: invokevirtual x/Z.ε (DDDDDLnet/minecraft/entity/Entity;)Lx/occaf91a1f8e;
      // 073: astore 20
      // 075: ldc_w 931453117
      // 078: ldc_w 931453118
      // 07b: ixor
      // 07c: newarray 7
      // 07e: dup
      // 07f: bipush 0
      // 080: dload 11
      // 082: dastore
      // 083: dup
      // 084: bipush 1
      // 085: dload 13
      // 087: dastore
      // 088: dup
      // 089: ldc_w 931453116
      // 08c: ldc_w 931453118
      // 08f: ixor
      // 090: dload 15
      // 092: dastore
      // 093: astore 21
      // 095: aload 0
      // 096: aload 20
      // 098: aload 21
      // 09a: invokevirtual x/Z.ǧ (Lx/occaf91a1f8e;[D)V
      // 09d: aload 21
      // 09f: bipush 0
      // 0a0: daload
      // 0a1: dstore 11
      // 0a3: aload 21
      // 0a5: bipush 1
      // 0a6: daload
      // 0a7: dstore 13
      // 0a9: aload 21
      // 0ab: ldc_w 931453116
      // 0ae: ldc_w 931453118
      // 0b1: ixor
      // 0b2: daload
      // 0b3: dstore 15
      // 0b5: dload 5
      // 0b7: dload 11
      // 0b9: dadd
      // 0ba: dstore 22
      // 0bc: dload 7
      // 0be: dload 13
      // 0c0: dadd
      // 0c1: dstore 24
      // 0c3: dload 9
      // 0c5: dload 15
      // 0c7: dadd
      // 0c8: dstore 26
      // 0ca: new net/minecraft/util/Vec3
      // 0cd: dup
      // 0ce: dload 5
      // 0d0: dload 7
      // 0d2: dload 9
      // 0d4: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 0d7: astore 28
      // 0d9: new net/minecraft/util/Vec3
      // 0dc: dup
      // 0dd: dload 22
      // 0df: dload 24
      // 0e1: dload 26
      // 0e3: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 0e6: astore 29
      // 0e8: aload 0
      // 0e9: aload 28
      // 0eb: aload 29
      // 0ed: aload 2
      // 0ee: invokevirtual x/Z.ɠ (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;Lx/oc8ea84f7e0d;)Lx/oc50ba88bc3e;
      // 0f1: astore 30
      // 0f3: aload 30
      // 0f5: getfield x/oc50ba88bc3e.շ Lnet/minecraft/util/MovingObjectPosition;
      // 0f8: astore 31
      // 0fa: aload 30
      // 0fc: getfield x/oc50ba88bc3e.ҕ D
      // 0ff: dstore 32
      // 101: aload 31
      // 103: iload 4
      // 105: ifne 111
      // 108: ifnull 117
      // 10b: goto 10f
      // 10e: athrow
      // 10f: aload 31
      // 111: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 114: goto 119
      // 117: aload 29
      // 119: astore 34
      // 11b: new net/minecraft/util/AxisAlignedBB
      // 11e: dup
      // 11f: dload 5
      // 121: aload 2
      // 122: getfield x/oc8ea84f7e0d.պ D
      // 125: dsub
      // 126: dload 7
      // 128: aload 2
      // 129: getfield x/oc8ea84f7e0d.պ D
      // 12c: dsub
      // 12d: dload 9
      // 12f: aload 2
      // 130: getfield x/oc8ea84f7e0d.պ D
      // 133: dsub
      // 134: dload 5
      // 136: aload 2
      // 137: getfield x/oc8ea84f7e0d.պ D
      // 13a: dadd
      // 13b: dload 7
      // 13d: aload 2
      // 13e: getfield x/oc8ea84f7e0d.պ D
      // 141: dadd
      // 142: dload 9
      // 144: aload 2
      // 145: getfield x/oc8ea84f7e0d.պ D
      // 148: dadd
      // 149: invokespecial net/minecraft/util/AxisAlignedBB.<init> (DDDDDD)V
      // 14c: dload 11
      // 14e: dload 13
      // 150: dload 15
      // 152: invokevirtual net/minecraft/util/AxisAlignedBB.addCoord (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 155: dconst_1
      // 156: dconst_1
      // 157: dconst_1
      // 158: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 15b: astore 35
      // 15d: aconst_null
      // 15e: astore 36
      // 160: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 163: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 166: aload 1
      // 167: aload 35
      // 169: invokevirtual net/minecraft/client/multiplayer/WorldClient.getEntitiesWithinAABBExcludingEntity (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/AxisAlignedBB;)Ljava/util/List;
      // 16c: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 171: astore 37
      // 173: aload 37
      // 175: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 17a: ifeq 2c2
      // 17d: aload 37
      // 17f: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 184: checkcast net/minecraft/entity/Entity
      // 187: astore 38
      // 189: iload 4
      // 18b: ifne 2f1
      // 18e: aload 38
      // 190: iload 4
      // 192: ifne 1ae
      // 195: goto 199
      // 198: athrow
      // 199: instanceof net/minecraft/entity/EntityLivingBase
      // 19c: ifne 1ac
      // 19f: goto 1a3
      // 1a2: athrow
      // 1a3: iload 4
      // 1a5: ifeq 173
      // 1a8: goto 1ac
      // 1ab: athrow
      // 1ac: aload 38
      // 1ae: iload 4
      // 1b0: ifne 1c8
      // 1b3: instanceof net/minecraft/entity/item/EntityArmorStand
      // 1b6: ifeq 1c6
      // 1b9: goto 1bd
      // 1bc: athrow
      // 1bd: iload 4
      // 1bf: ifeq 173
      // 1c2: goto 1c6
      // 1c5: athrow
      // 1c6: aload 38
      // 1c8: iload 4
      // 1ca: ifne 1e2
      // 1cd: invokevirtual net/minecraft/entity/Entity.canBeCollidedWith ()Z
      // 1d0: ifne 1e0
      // 1d3: goto 1d7
      // 1d6: athrow
      // 1d7: iload 4
      // 1d9: ifeq 173
      // 1dc: goto 1e0
      // 1df: athrow
      // 1e0: aload 38
      // 1e2: checkcast net/minecraft/entity/EntityLivingBase
      // 1e5: iload 4
      // 1e7: ifne 1ff
      // 1ea: getfield net/minecraft/entity/EntityLivingBase.deathTime I
      // 1ed: ifeq 1fd
      // 1f0: goto 1f4
      // 1f3: athrow
      // 1f4: iload 4
      // 1f6: ifeq 173
      // 1f9: goto 1fd
      // 1fc: athrow
      // 1fd: aload 38
      // 1ff: iload 4
      // 201: ifne 22d
      // 204: instanceof net/minecraft/entity/player/EntityPlayer
      // 207: ifeq 22c
      // 20a: goto 20e
      // 20d: athrow
      // 20e: aload 38
      // 210: iload 4
      // 212: ifne 22d
      // 215: goto 219
      // 218: athrow
      // 219: invokestatic x/oca4f99d2d44.Λ (Lnet/minecraft/entity/Entity;)Z
      // 21c: ifeq 22c
      // 21f: goto 223
      // 222: athrow
      // 223: iload 4
      // 225: ifeq 173
      // 228: goto 22c
      // 22b: athrow
      // 22c: aload 3
      // 22d: iload 4
      // 22f: ifne 267
      // 232: ifnull 265
      // 235: goto 239
      // 238: athrow
      // 239: aload 38
      // 23b: iload 4
      // 23d: ifne 267
      // 240: goto 244
      // 243: athrow
      // 244: aload 3
      // 245: invokevirtual net/minecraft/entity/Entity.isEntityEqual (Lnet/minecraft/entity/Entity;)Z
      // 248: ifeq 265
      // 24b: goto 24f
      // 24e: athrow
      // 24f: iload 17
      // 251: aload 2
      // 252: getfield x/oc8ea84f7e0d.ӫ I
      // 255: if_icmpge 265
      // 258: goto 25c
      // 25b: athrow
      // 25c: iload 4
      // 25e: ifeq 173
      // 261: goto 265
      // 264: athrow
      // 265: aload 38
      // 267: invokevirtual net/minecraft/entity/Entity.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 26a: ldc2_w 0.3
      // 26d: ldc2_w 0.3
      // 270: ldc2_w 0.3
      // 273: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 276: astore 39
      // 278: aload 39
      // 27a: aload 28
      // 27c: aload 34
      // 27e: invokevirtual net/minecraft/util/AxisAlignedBB.calculateIntercept (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/MovingObjectPosition;
      // 281: astore 40
      // 283: aload 40
      // 285: ifnonnull 291
      // 288: iload 4
      // 28a: ifeq 173
      // 28d: goto 291
      // 290: athrow
      // 291: aload 28
      // 293: aload 40
      // 295: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 298: invokevirtual net/minecraft/util/Vec3.squareDistanceTo (Lnet/minecraft/util/Vec3;)D
      // 29b: dstore 41
      // 29d: iload 4
      // 29f: ifne 2b6
      // 2a2: dload 41
      // 2a4: ldc2_w 1.0E-7
      // 2a7: dadd
      // 2a8: dload 32
      // 2aa: dcmpg
      // 2ab: ifge 2bd
      // 2ae: goto 2b2
      // 2b1: athrow
      // 2b2: dload 41
      // 2b4: dstore 32
      // 2b6: aload 40
      // 2b8: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 2bb: astore 36
      // 2bd: iload 4
      // 2bf: ifeq 173
      // 2c2: aload 36
      // 2c4: ifnull 2f1
      // 2c7: aload 0
      // 2c8: aload 18
      // 2ca: dload 5
      // 2cc: dload 7
      // 2ce: dload 9
      // 2d0: dload 11
      // 2d2: dload 13
      // 2d4: dload 15
      // 2d6: aload 36
      // 2d8: invokevirtual x/Z.v (Ljava/util/List;DDDDDDLnet/minecraft/util/Vec3;)V
      // 2db: new x/oc9f62920480
      // 2de: dup
      // 2df: aload 18
      // 2e1: aload 36
      // 2e3: aconst_null
      // 2e4: aload 2
      // 2e5: getfield x/oc8ea84f7e0d.ь D
      // 2e8: aload 2
      // 2e9: getfield x/oc8ea84f7e0d.ћ D
      // 2ec: invokespecial x/oc9f62920480.<init> (Ljava/util/List;Lnet/minecraft/util/Vec3;Lnet/minecraft/util/BlockPos;DD)V
      // 2ef: areturn
      // 2f0: athrow
      // 2f1: aload 31
      // 2f3: ifnull 32a
      // 2f6: aload 0
      // 2f7: aload 18
      // 2f9: dload 5
      // 2fb: dload 7
      // 2fd: dload 9
      // 2ff: dload 11
      // 301: dload 13
      // 303: dload 15
      // 305: aload 31
      // 307: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 30a: invokevirtual x/Z.v (Ljava/util/List;DDDDDDLnet/minecraft/util/Vec3;)V
      // 30d: new x/oc9f62920480
      // 310: dup
      // 311: aload 18
      // 313: aload 31
      // 315: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 318: aload 31
      // 31a: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 31d: aload 2
      // 31e: getfield x/oc8ea84f7e0d.ь D
      // 321: aload 2
      // 322: getfield x/oc8ea84f7e0d.ћ D
      // 325: invokespecial x/oc9f62920480.<init> (Ljava/util/List;Lnet/minecraft/util/Vec3;Lnet/minecraft/util/BlockPos;DD)V
      // 328: areturn
      // 329: athrow
      // 32a: aload 0
      // 32b: aload 18
      // 32d: dload 5
      // 32f: dload 7
      // 331: dload 9
      // 333: dload 11
      // 335: dload 13
      // 337: dload 15
      // 339: invokevirtual x/Z.ɵ (Ljava/util/List;DDDDDD)V
      // 33c: dload 22
      // 33e: dstore 5
      // 340: dload 24
      // 342: dstore 7
      // 344: dload 26
      // 346: dstore 9
      // 348: dload 11
      // 34a: aload 20
      // 34c: getfield x/occaf91a1f8e.в Z
      // 34f: ifeq 35a
      // 352: aload 2
      // 353: getfield x/oc8ea84f7e0d.Ǐ D
      // 356: goto 35e
      // 359: athrow
      // 35a: aload 2
      // 35b: getfield x/oc8ea84f7e0d.Ԇ D
      // 35e: dmul
      // 35f: dstore 11
      // 361: dload 13
      // 363: aload 20
      // 365: getfield x/occaf91a1f8e.в Z
      // 368: ifeq 373
      // 36b: aload 2
      // 36c: getfield x/oc8ea84f7e0d.Ǐ D
      // 36f: goto 377
      // 372: athrow
      // 373: aload 2
      // 374: getfield x/oc8ea84f7e0d.Ԇ D
      // 377: dmul
      // 378: dstore 13
      // 37a: dload 15
      // 37c: aload 20
      // 37e: getfield x/occaf91a1f8e.в Z
      // 381: ifeq 38c
      // 384: aload 2
      // 385: getfield x/oc8ea84f7e0d.Ǐ D
      // 388: goto 390
      // 38b: athrow
      // 38c: aload 2
      // 38d: getfield x/oc8ea84f7e0d.Ԇ D
      // 390: dmul
      // 391: dstore 15
      // 393: iload 4
      // 395: ifne 3bd
      // 398: dload 13
      // 39a: aload 2
      // 39b: getfield x/oc8ea84f7e0d.ъ D
      // 39e: dsub
      // 39f: dstore 13
      // 3a1: iinc 17 1
      // 3a4: dload 7
      // 3a6: ldc2_w -64.0
      // 3a9: dcmpg
      // 3aa: ifge 3b6
      // 3ad: iload 4
      // 3af: ifeq 3c2
      // 3b2: goto 3b6
      // 3b5: athrow
      // 3b6: iinc 19 1
      // 3b9: goto 3bd
      // 3bc: athrow
      // 3bd: iload 4
      // 3bf: ifeq 054
      // 3c2: new x/oc9f62920480
      // 3c5: dup
      // 3c6: aload 18
      // 3c8: aconst_null
      // 3c9: aconst_null
      // 3ca: aload 2
      // 3cb: getfield x/oc8ea84f7e0d.ь D
      // 3ce: aload 2
      // 3cf: getfield x/oc8ea84f7e0d.ћ D
      // 3d2: invokespecial x/oc9f62920480.<init> (Ljava/util/List;Lnet/minecraft/util/Vec3;Lnet/minecraft/util/BlockPos;DD)V
      // 3d5: areturn
   }

   private void ɵ(List<Vec3> var1, double var2, double var4, double var6, double var8, double var10, double var12) {
      int var15 = 1;
      boolean var14 = oce6044968f8.ђ;

      while (var15 <= (433880076 ^ 433880072)) {
         double var16 = var15 / 4.0;
         var1.add(new Vec3(var2 + var8 * var16, var4 + var10 * var16, var6 + var12 * var16));
         var15++;
         if (var14) {
            break;
         }
      }
   }

   private void v(List<Vec3> param1, double param2, double param4, double param6, double param8, double param10, double param12, Vec3 param14) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: dload 8
      // 02: dload 8
      // 04: dmul
      // 05: dload 10
      // 07: dload 10
      // 09: dmul
      // 0a: dadd
      // 0b: dload 12
      // 0d: dload 12
      // 0f: dmul
      // 10: dadd
      // 11: dstore 16
      // 13: aload 14
      // 15: getfield net/minecraft/util/Vec3.xCoord D
      // 18: dload 2
      // 19: dsub
      // 1a: dstore 18
      // 1c: aload 14
      // 1e: getfield net/minecraft/util/Vec3.yCoord D
      // 21: dload 4
      // 23: dsub
      // 24: dstore 20
      // 26: getstatic x/oce6044968f8.ђ Z
      // 29: aload 14
      // 2b: getfield net/minecraft/util/Vec3.zCoord D
      // 2e: dload 6
      // 30: dsub
      // 31: dstore 22
      // 33: istore 15
      // 35: dload 18
      // 37: dload 18
      // 39: dmul
      // 3a: dload 20
      // 3c: dload 20
      // 3e: dmul
      // 3f: dadd
      // 40: dload 22
      // 42: dload 22
      // 44: dmul
      // 45: dadd
      // 46: dstore 24
      // 48: dload 16
      // 4a: iload 15
      // 4c: ifne 64
      // 4f: dconst_0
      // 50: dcmpl
      // 51: ifle 67
      // 54: goto 58
      // 57: athrow
      // 58: dload 24
      // 5a: dload 16
      // 5c: ddiv
      // 5d: invokestatic java/lang/Math.sqrt (D)D
      // 60: goto 64
      // 63: athrow
      // 64: goto 68
      // 67: dconst_0
      // 68: dstore 26
      // 6a: dconst_0
      // 6b: dconst_1
      // 6c: dload 26
      // 6e: invokestatic java/lang/Math.min (DD)D
      // 71: invokestatic java/lang/Math.max (DD)D
      // 74: dstore 26
      // 76: dload 26
      // 78: ldc2_w 4.0
      // 7b: dmul
      // 7c: invokestatic java/lang/Math.ceil (D)D
      // 7f: d2i
      // 80: istore 28
      // 82: bipush 1
      // 83: istore 29
      // 85: iload 29
      // 87: iload 28
      // 89: if_icmpge c7
      // 8c: iload 29
      // 8e: iload 15
      // 90: ifne cf
      // 93: i2d
      // 94: ldc2_w 4.0
      // 97: ddiv
      // 98: dstore 30
      // 9a: iload 15
      // 9c: aload 1
      // 9d: new net/minecraft/util/Vec3
      // a0: dup
      // a1: dload 2
      // a2: dload 8
      // a4: dload 30
      // a6: dmul
      // a7: dadd
      // a8: dload 4
      // aa: dload 10
      // ac: dload 30
      // ae: dmul
      // af: dadd
      // b0: dload 6
      // b2: dload 12
      // b4: dload 30
      // b6: dmul
      // b7: dadd
      // b8: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // bb: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // c0: pop
      // c1: iinc 29 1
      // c4: ifeq 85
      // c7: aload 1
      // c8: aload 14
      // ca: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // cf: pop
      // d0: return
   }

   private void Ǎ(Entity param1, float param2, oc9f62920480 param3, Color param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: istore 5
      // 005: aload 3
      // 006: getfield x/oc9f62920480.բ Ljava/util/List;
      // 009: invokeinterface java/util/List.size ()I 1
      // 00e: ldc_w 1744556440
      // 011: ldc_w 1744556442
      // 014: ixor
      // 015: if_icmpge 01a
      // 018: return
      // 019: athrow
      // 01a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 01d: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 020: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosX D
      // 023: dstore 6
      // 025: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 028: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 02b: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosY D
      // 02e: dstore 8
      // 030: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 033: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 036: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosZ D
      // 039: dstore 10
      // 03b: aload 1
      // 03c: getfield net/minecraft/entity/Entity.lastTickPosX D
      // 03f: aload 1
      // 040: getfield net/minecraft/entity/Entity.posX D
      // 043: aload 1
      // 044: getfield net/minecraft/entity/Entity.lastTickPosX D
      // 047: dsub
      // 048: fload 2
      // 049: f2d
      // 04a: dmul
      // 04b: dadd
      // 04c: dstore 12
      // 04e: aload 1
      // 04f: getfield net/minecraft/entity/Entity.lastTickPosY D
      // 052: aload 1
      // 053: getfield net/minecraft/entity/Entity.posY D
      // 056: aload 1
      // 057: getfield net/minecraft/entity/Entity.lastTickPosY D
      // 05a: dsub
      // 05b: fload 2
      // 05c: f2d
      // 05d: dmul
      // 05e: dadd
      // 05f: dstore 14
      // 061: aload 1
      // 062: getfield net/minecraft/entity/Entity.lastTickPosZ D
      // 065: aload 1
      // 066: getfield net/minecraft/entity/Entity.posZ D
      // 069: aload 1
      // 06a: getfield net/minecraft/entity/Entity.lastTickPosZ D
      // 06d: dsub
      // 06e: fload 2
      // 06f: f2d
      // 070: dmul
      // 071: dadd
      // 072: dstore 16
      // 074: aload 4
      // 076: invokevirtual java/awt/Color.getRed ()I
      // 079: i2f
      // 07a: ldc_w 255.0
      // 07d: fdiv
      // 07e: fstore 18
      // 080: aload 4
      // 082: invokevirtual java/awt/Color.getGreen ()I
      // 085: i2f
      // 086: ldc_w 255.0
      // 089: fdiv
      // 08a: fstore 19
      // 08c: aload 4
      // 08e: invokevirtual java/awt/Color.getBlue ()I
      // 091: i2f
      // 092: ldc_w 255.0
      // 095: fdiv
      // 096: fstore 20
      // 098: invokestatic org/lwjgl/opengl/GL11.glPushMatrix ()V
      // 09b: ldc_w 1744558712
      // 09e: ldc_w 1744556442
      // 0a1: ixor
      // 0a2: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 0a5: ldc_w 1744556696
      // 0a8: ldc_w 1744556442
      // 0ab: ixor
      // 0ac: ldc_w 1744556697
      // 0af: ldc_w 1744556442
      // 0b2: ixor
      // 0b3: invokestatic org/lwjgl/opengl/GL11.glBlendFunc (II)V
      // 0b6: ldc_w 1744558778
      // 0b9: ldc_w 1744556442
      // 0bc: ixor
      // 0bd: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 0c0: ldc_w 1744559227
      // 0c3: ldc_w 1744556442
      // 0c6: ixor
      // 0c7: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 0ca: ldc_w 1744558827
      // 0cd: ldc_w 1744556442
      // 0d0: ixor
      // 0d1: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 0d4: bipush 0
      // 0d5: invokestatic org/lwjgl/opengl/GL11.glDepthMask (Z)V
      // 0d8: fconst_2
      // 0d9: invokestatic org/lwjgl/opengl/GL11.glLineWidth (F)V
      // 0dc: fload 18
      // 0de: fload 19
      // 0e0: fload 20
      // 0e2: fconst_1
      // 0e3: invokestatic org/lwjgl/opengl/GL11.glColor4f (FFFF)V
      // 0e6: ldc_w 1744556441
      // 0e9: ldc_w 1744556442
      // 0ec: ixor
      // 0ed: invokestatic org/lwjgl/opengl/GL11.glBegin (I)V
      // 0f0: dload 12
      // 0f2: dload 6
      // 0f4: dsub
      // 0f5: dload 14
      // 0f7: dload 8
      // 0f9: dsub
      // 0fa: dload 16
      // 0fc: dload 10
      // 0fe: dsub
      // 0ff: invokestatic org/lwjgl/opengl/GL11.glVertex3d (DDD)V
      // 102: bipush 1
      // 103: istore 21
      // 105: iload 21
      // 107: aload 3
      // 108: getfield x/oc9f62920480.բ Ljava/util/List;
      // 10b: invokeinterface java/util/List.size ()I 1
      // 110: if_icmpge 14f
      // 113: aload 3
      // 114: getfield x/oc9f62920480.բ Ljava/util/List;
      // 117: iload 21
      // 119: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 11e: checkcast net/minecraft/util/Vec3
      // 121: astore 22
      // 123: iload 5
      // 125: aload 22
      // 127: getfield net/minecraft/util/Vec3.xCoord D
      // 12a: dload 6
      // 12c: dsub
      // 12d: aload 22
      // 12f: getfield net/minecraft/util/Vec3.yCoord D
      // 132: dload 8
      // 134: dsub
      // 135: aload 22
      // 137: getfield net/minecraft/util/Vec3.zCoord D
      // 13a: dload 10
      // 13c: dsub
      // 13d: invokestatic org/lwjgl/opengl/GL11.glVertex3d (DDD)V
      // 140: ifne 152
      // 143: iinc 21 1
      // 146: iload 5
      // 148: ifeq 105
      // 14b: goto 14f
      // 14e: athrow
      // 14f: invokestatic x/oc170ea29aae.ŷ ()V
      // 152: aload 3
      // 153: getfield x/oc9f62920480.Ӭ Lnet/minecraft/util/Vec3;
      // 156: ifnull 185
      // 159: aload 0
      // 15a: aload 1
      // 15b: aload 3
      // 15c: invokevirtual x/Z.Ϛ (Lnet/minecraft/entity/Entity;Lx/oc9f62920480;)Lnet/minecraft/util/AxisAlignedBB;
      // 15f: astore 21
      // 161: aload 21
      // 163: dload 6
      // 165: dload 8
      // 167: dload 10
      // 169: invokestatic x/ocbd4917c4b1.ԁ (Lnet/minecraft/util/AxisAlignedBB;DDD)V
      // 16c: aload 21
      // 16e: dload 6
      // 170: dneg
      // 171: dload 8
      // 173: dneg
      // 174: dload 10
      // 176: dneg
      // 177: invokevirtual net/minecraft/util/AxisAlignedBB.offset (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 17a: fload 18
      // 17c: fload 19
      // 17e: fload 20
      // 180: ldc 0.18
      // 182: invokestatic x/ocbd4917c4b1.ʓ (Lnet/minecraft/util/AxisAlignedBB;FFFF)V
      // 185: aload 1
      // 186: instanceof net/minecraft/entity/projectile/EntityArrow
      // 189: iload 5
      // 18b: ifne 1e6
      // 18e: ifeq 1b2
      // 191: goto 195
      // 194: athrow
      // 195: aload 0
      // 196: aload 3
      // 197: aload 1
      // 198: fload 2
      // 199: dload 12
      // 19b: dload 14
      // 19d: dload 16
      // 19f: dload 6
      // 1a1: dload 8
      // 1a3: dload 10
      // 1a5: fload 18
      // 1a7: fload 19
      // 1a9: fload 20
      // 1ab: invokevirtual x/Z.ͺ (Lx/oc9f62920480;Lnet/minecraft/entity/Entity;FDDDDDDFFF)V
      // 1ae: goto 1b2
      // 1b1: athrow
      // 1b2: fconst_1
      // 1b3: invokestatic org/lwjgl/opengl/GL11.glLineWidth (F)V
      // 1b6: fconst_1
      // 1b7: fconst_1
      // 1b8: fconst_1
      // 1b9: fconst_1
      // 1ba: invokestatic org/lwjgl/opengl/GL11.glColor4f (FFFF)V
      // 1bd: bipush 1
      // 1be: invokestatic org/lwjgl/opengl/GL11.glDepthMask (Z)V
      // 1c1: ldc_w 1744558827
      // 1c4: ldc_w 1744556442
      // 1c7: ixor
      // 1c8: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 1cb: ldc_w 1744559227
      // 1ce: ldc_w 1744556442
      // 1d1: ixor
      // 1d2: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 1d5: ldc_w 1744558778
      // 1d8: ldc_w 1744556442
      // 1db: ixor
      // 1dc: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 1df: ldc_w 1744558712
      // 1e2: ldc_w 1744556442
      // 1e5: ixor
      // 1e6: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 1e9: invokestatic org/lwjgl/opengl/GL11.glPopMatrix ()V
      // 1ec: return
   }

   private void ͺ(
      oc9f62920480 var1,
      Entity var2,
      float var3,
      double var4,
      double var6,
      double var8,
      double var10,
      double var12,
      double var14,
      float var16,
      float var17,
      float var18
   ) {
      boolean var10000 = oce6044968f8.ђ;
      Vec3 var20 = this.í(var1, var2, var4, var6, var8);
      boolean var19 = var10000;

      label53: {
         try {
            var40 = var20;
            if (var19) {
               break label53;
            }

            if (var20 == null) {
               return;
            }
         } catch (ocbde1165e4e var39) {
            throw var39;
         }

         var40 = this.ʄ(var20);
      }

      Vec3 var21 = var40;

      label42: {
         try {
            var41 = var21;
            if (var19) {
               break label42;
            }

            if (var21 == null) {
               return;
            }
         } catch (ocbde1165e4e var38) {
            throw var38;
         }

         var41 = this.ò(this.ҿ(var20, var21));
      }

      Vec3 var22 = var41;

      try {
         if (var22 == null) {
            return;
         }
      } catch (ocbde1165e4e var37) {
         throw var37;
      }

      double var23 = var4 - var20.xCoord * 0.12;
      double var25 = var6 - var20.yCoord * 0.12;
      double var27 = var8 - var20.zCoord * 0.12;
      double var29 = (var2.ticksExisted + var3) * 0.35;
      double var31 = Math.cos(var29);
      double var33 = Math.sin(var29);
      Vec3 var35 = this.Ӳ(var21, var22, var31, var33);
      Vec3 var36 = this.Ӳ(var22, var21, var31, -var33);
      GL11.glLineWidth(2.0F);
      GL11.glColor4f(var16, var17, var18, 1.0F);
      GL11.glBegin(1);
      this.Ց(var23, var25, var27, var35, var20, var10, var12, var14);
      this.Ց(var23, var25, var27, new Vec3(-var35.xCoord, -var35.yCoord, -var35.zCoord), var20, var10, var12, var14);
      this.Ց(var23, var25, var27, var36, var20, var10, var12, var14);
      this.Ց(var23, var25, var27, new Vec3(-var36.xCoord, -var36.yCoord, -var36.zCoord), var20, var10, var12, var14);
      oc170ea29aae.ŷ();
   }

   private void Ց(double var1, double var3, double var5, Vec3 var7, Vec3 var8, double var9, double var11, double var13) {
      GL11.glVertex3d(
         var1 + var7.xCoord * 0.02 - var8.xCoord * 0.01 - var9,
         var3 + var7.yCoord * 0.02 - var8.yCoord * 0.01 - var11,
         var5 + var7.zCoord * 0.02 - var8.zCoord * 0.01 - var13
      );
      GL11.glVertex3d(
         var1 + var7.xCoord * 0.15 - var8.xCoord * 0.05 - var9,
         var3 + var7.yCoord * 0.15 - var8.yCoord * 0.05 - var11,
         var5 + var7.zCoord * 0.15 - var8.zCoord * 0.05 - var13
      );
   }

   private Vec3 í(oc9f62920480 param1, Entity param2, double param3, double param5, double param7) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: aload 0
      // 04: new net/minecraft/util/Vec3
      // 07: dup
      // 08: aload 2
      // 09: getfield net/minecraft/entity/Entity.motionX D
      // 0c: aload 2
      // 0d: getfield net/minecraft/entity/Entity.motionY D
      // 10: aload 2
      // 11: getfield net/minecraft/entity/Entity.motionZ D
      // 14: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 17: invokevirtual x/Z.ò (Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/Vec3;
      // 1a: astore 10
      // 1c: istore 9
      // 1e: aload 10
      // 20: iload 9
      // 22: ifne 2e
      // 25: ifnull 2f
      // 28: goto 2c
      // 2b: athrow
      // 2c: aload 10
      // 2e: areturn
      // 2f: aload 1
      // 30: iload 9
      // 32: ifne 58
      // 35: getfield x/oc9f62920480.բ Ljava/util/List;
      // 38: invokeinterface java/util/List.size ()I 1
      // 3d: ldc_w 1190006337
      // 40: ldc_w 1190006339
      // 43: ixor
      // 44: if_icmpge 4e
      // 47: goto 4b
      // 4a: athrow
      // 4b: aconst_null
      // 4c: areturn
      // 4d: athrow
      // 4e: aload 1
      // 4f: getfield x/oc9f62920480.բ Ljava/util/List;
      // 52: bipush 1
      // 53: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 58: checkcast net/minecraft/util/Vec3
      // 5b: astore 11
      // 5d: aload 0
      // 5e: new net/minecraft/util/Vec3
      // 61: dup
      // 62: aload 11
      // 64: getfield net/minecraft/util/Vec3.xCoord D
      // 67: dload 3
      // 68: dsub
      // 69: aload 11
      // 6b: getfield net/minecraft/util/Vec3.yCoord D
      // 6e: dload 5
      // 70: dsub
      // 71: aload 11
      // 73: getfield net/minecraft/util/Vec3.zCoord D
      // 76: dload 7
      // 78: dsub
      // 79: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 7c: invokevirtual x/Z.ò (Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/Vec3;
      // 7f: areturn
   }

   private Vec3 ʄ(Vec3 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 28
      // 09: getfield net/minecraft/util/Vec3.yCoord D
      // 0c: invokestatic java/lang/Math.abs (D)D
      // 0f: ldc2_w 0.9
      // 12: dcmpg
      // 13: ifge 2b
      // 16: goto 1a
      // 19: athrow
      // 1a: new net/minecraft/util/Vec3
      // 1d: dup
      // 1e: dconst_0
      // 1f: dconst_1
      // 20: dconst_0
      // 21: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 24: goto 28
      // 27: athrow
      // 28: goto 35
      // 2b: new net/minecraft/util/Vec3
      // 2e: dup
      // 2f: dconst_1
      // 30: dconst_0
      // 31: dconst_0
      // 32: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 35: astore 3
      // 36: aload 0
      // 37: aload 0
      // 38: aload 1
      // 39: aload 3
      // 3a: invokevirtual x/Z.ҿ (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/Vec3;
      // 3d: invokevirtual x/Z.ò (Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/Vec3;
      // 40: areturn
   }

   private Vec3 Ӳ(Vec3 var1, Vec3 var2, double var3, double var5) {
      return new Vec3(var1.xCoord * var3 + var2.xCoord * var5, var1.yCoord * var3 + var2.yCoord * var5, var1.zCoord * var3 + var2.zCoord * var5);
   }

   private Vec3 ҿ(Vec3 var1, Vec3 var2) {
      return new Vec3(
         var1.yCoord * var2.zCoord - var1.zCoord * var2.yCoord,
         var1.zCoord * var2.xCoord - var1.xCoord * var2.zCoord,
         var1.xCoord * var2.yCoord - var1.yCoord * var2.xCoord
      );
   }

   private Vec3 ò(Vec3 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: aload 1
      // 04: getfield net/minecraft/util/Vec3.xCoord D
      // 07: aload 1
      // 08: getfield net/minecraft/util/Vec3.xCoord D
      // 0b: dmul
      // 0c: aload 1
      // 0d: getfield net/minecraft/util/Vec3.yCoord D
      // 10: aload 1
      // 11: getfield net/minecraft/util/Vec3.yCoord D
      // 14: dmul
      // 15: dadd
      // 16: aload 1
      // 17: getfield net/minecraft/util/Vec3.zCoord D
      // 1a: aload 1
      // 1b: getfield net/minecraft/util/Vec3.zCoord D
      // 1e: dmul
      // 1f: dadd
      // 20: dstore 3
      // 21: istore 2
      // 22: dload 3
      // 23: iload 2
      // 24: ifne 3b
      // 27: ldc2_w 1.0E-6
      // 2a: dcmpg
      // 2b: ifgt 35
      // 2e: goto 32
      // 31: athrow
      // 32: aconst_null
      // 33: areturn
      // 34: athrow
      // 35: dconst_1
      // 36: dload 3
      // 37: invokestatic java/lang/Math.sqrt (D)D
      // 3a: ddiv
      // 3b: dstore 5
      // 3d: new net/minecraft/util/Vec3
      // 40: dup
      // 41: aload 1
      // 42: getfield net/minecraft/util/Vec3.xCoord D
      // 45: dload 5
      // 47: dmul
      // 48: aload 1
      // 49: getfield net/minecraft/util/Vec3.yCoord D
      // 4c: dload 5
      // 4e: dmul
      // 4f: aload 1
      // 50: getfield net/minecraft/util/Vec3.zCoord D
      // 53: dload 5
      // 55: dmul
      // 56: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 59: areturn
   }

   private AxisAlignedBB Ϛ(Entity param1, oc9f62920480 param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 3
      // 04: aload 1
      // 05: instanceof net/minecraft/entity/projectile/EntityArrow
      // 08: ifeq 12
      // 0b: aload 0
      // 0c: aload 2
      // 0d: invokevirtual x/Z.ʵ (Lx/oc9f62920480;)Lnet/minecraft/util/AxisAlignedBB;
      // 10: areturn
      // 11: athrow
      // 12: aload 2
      // 13: iload 3
      // 14: ifne 26
      // 17: getfield x/oc9f62920480.é Lnet/minecraft/util/BlockPos;
      // 1a: ifnull 7d
      // 1d: goto 21
      // 20: athrow
      // 21: aload 2
      // 22: goto 26
      // 25: athrow
      // 26: getfield x/oc9f62920480.é Lnet/minecraft/util/BlockPos;
      // 29: invokestatic x/occb1ed1ed8f.ª (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/util/AxisAlignedBB;
      // 2c: astore 4
      // 2e: aload 4
      // 30: iload 3
      // 31: ifne 7c
      // 34: ifnull 3f
      // 37: goto 3b
      // 3a: athrow
      // 3b: aload 4
      // 3d: areturn
      // 3e: athrow
      // 3f: new net/minecraft/util/AxisAlignedBB
      // 42: dup
      // 43: aload 2
      // 44: getfield x/oc9f62920480.é Lnet/minecraft/util/BlockPos;
      // 47: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 4a: i2d
      // 4b: aload 2
      // 4c: getfield x/oc9f62920480.é Lnet/minecraft/util/BlockPos;
      // 4f: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 52: i2d
      // 53: aload 2
      // 54: getfield x/oc9f62920480.é Lnet/minecraft/util/BlockPos;
      // 57: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 5a: i2d
      // 5b: aload 2
      // 5c: getfield x/oc9f62920480.é Lnet/minecraft/util/BlockPos;
      // 5f: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 62: i2d
      // 63: dconst_1
      // 64: dadd
      // 65: aload 2
      // 66: getfield x/oc9f62920480.é Lnet/minecraft/util/BlockPos;
      // 69: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 6c: i2d
      // 6d: dconst_1
      // 6e: dadd
      // 6f: aload 2
      // 70: getfield x/oc9f62920480.é Lnet/minecraft/util/BlockPos;
      // 73: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 76: i2d
      // 77: dconst_1
      // 78: dadd
      // 79: invokespecial net/minecraft/util/AxisAlignedBB.<init> (DDDDDD)V
      // 7c: areturn
      // 7d: aload 0
      // 7e: aload 2
      // 7f: invokevirtual x/Z.ʵ (Lx/oc9f62920480;)Lnet/minecraft/util/AxisAlignedBB;
      // 82: areturn
   }

   private AxisAlignedBB ʵ(oc9f62920480 var1) {
      double var2 = var1.ˤ * 0.5;
      return new AxisAlignedBB(var1.Ӭ.xCoord - var2, var1.Ӭ.yCoord, var1.Ӭ.zCoord - var2, var1.Ӭ.xCoord + var2, var1.Ӭ.yCoord + var1.ҋ, var1.Ӭ.zCoord + var2);
   }

   private occaf91a1f8e ε(double param1, double param3, double param5, double param7, double param9, Entity param11) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: new net/minecraft/util/AxisAlignedBB
      // 003: dup
      // 004: dload 1
      // 005: dload 7
      // 007: ldc2_w 0.5
      // 00a: dmul
      // 00b: dsub
      // 00c: dload 3
      // 00d: dload 5
      // 00f: dload 7
      // 011: ldc2_w 0.5
      // 014: dmul
      // 015: dsub
      // 016: dload 1
      // 017: dload 7
      // 019: ldc2_w 0.5
      // 01c: dmul
      // 01d: dadd
      // 01e: dload 3
      // 01f: dload 9
      // 021: dadd
      // 022: dload 5
      // 024: dload 7
      // 026: ldc2_w 0.5
      // 029: dmul
      // 02a: dadd
      // 02b: invokespecial net/minecraft/util/AxisAlignedBB.<init> (DDDDDD)V
      // 02e: astore 13
      // 030: aload 13
      // 032: dconst_0
      // 033: ldc2_w -0.4000000059604645
      // 036: dconst_0
      // 037: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 03a: ldc2_w 0.001
      // 03d: ldc2_w 0.001
      // 040: ldc2_w 0.001
      // 043: invokevirtual net/minecraft/util/AxisAlignedBB.contract (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 046: astore 14
      // 048: aload 14
      // 04a: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 04d: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 050: istore 15
      // 052: aload 14
      // 054: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 057: dconst_1
      // 058: dadd
      // 059: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 05c: istore 16
      // 05e: aload 14
      // 060: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 063: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 066: istore 17
      // 068: getstatic x/oce6044968f8.ђ Z
      // 06b: aload 14
      // 06d: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 070: dconst_1
      // 071: dadd
      // 072: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 075: istore 18
      // 077: aload 14
      // 079: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 07c: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 07f: istore 19
      // 081: aload 14
      // 083: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 086: dconst_1
      // 087: dadd
      // 088: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 08b: istore 20
      // 08d: istore 12
      // 08f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 092: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 095: new net/minecraft/util/BlockPos
      // 098: dup
      // 099: iload 15
      // 09b: iload 17
      // 09d: iload 19
      // 09f: invokespecial net/minecraft/util/BlockPos.<init> (III)V
      // 0a2: new net/minecraft/util/BlockPos
      // 0a5: dup
      // 0a6: iload 16
      // 0a8: iload 18
      // 0aa: iload 20
      // 0ac: invokespecial net/minecraft/util/BlockPos.<init> (III)V
      // 0af: bipush 1
      // 0b0: invokevirtual net/minecraft/client/multiplayer/WorldClient.isAreaLoaded (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/BlockPos;Z)Z
      // 0b3: iload 12
      // 0b5: ifne 0d4
      // 0b8: ifne 0d3
      // 0bb: goto 0bf
      // 0be: athrow
      // 0bf: new x/occaf91a1f8e
      // 0c2: dup
      // 0c3: bipush 0
      // 0c4: new net/minecraft/util/Vec3
      // 0c7: dup
      // 0c8: dconst_0
      // 0c9: dconst_0
      // 0ca: dconst_0
      // 0cb: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 0ce: invokespecial x/occaf91a1f8e.<init> (ZLnet/minecraft/util/Vec3;)V
      // 0d1: areturn
      // 0d2: athrow
      // 0d3: bipush 0
      // 0d4: istore 21
      // 0d6: new net/minecraft/util/Vec3
      // 0d9: dup
      // 0da: dconst_0
      // 0db: dconst_0
      // 0dc: dconst_0
      // 0dd: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 0e0: astore 22
      // 0e2: new net/minecraft/util/BlockPos$MutableBlockPos
      // 0e5: dup
      // 0e6: invokespecial net/minecraft/util/BlockPos$MutableBlockPos.<init> ()V
      // 0e9: astore 23
      // 0eb: iload 15
      // 0ed: istore 24
      // 0ef: iload 24
      // 0f1: iload 16
      // 0f3: if_icmpge 1ae
      // 0f6: iload 12
      // 0f8: ifne 1cc
      // 0fb: iload 17
      // 0fd: istore 25
      // 0ff: iload 25
      // 101: iload 18
      // 103: if_icmpge 1a6
      // 106: iload 12
      // 108: ifne 1a9
      // 10b: iload 19
      // 10d: istore 26
      // 10f: iload 26
      // 111: iload 20
      // 113: if_icmpge 19e
      // 116: aload 23
      // 118: iload 24
      // 11a: iload 25
      // 11c: iload 26
      // 11e: invokevirtual net/minecraft/util/BlockPos$MutableBlockPos.set (III)Lnet/minecraft/util/BlockPos$MutableBlockPos;
      // 121: pop
      // 122: iload 12
      // 124: ifne 1a1
      // 127: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 12a: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 12d: aload 23
      // 12f: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 132: astore 27
      // 134: aload 27
      // 136: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 13b: invokevirtual net/minecraft/block/Block.getMaterial ()Lnet/minecraft/block/material/Material;
      // 13e: getstatic net/minecraft/block/material/Material.water Lnet/minecraft/block/material/Material;
      // 141: if_acmpeq 14d
      // 144: iload 12
      // 146: ifeq 196
      // 149: goto 14d
      // 14c: athrow
      // 14d: iload 25
      // 14f: bipush 1
      // 150: iadd
      // 151: i2f
      // 152: aload 27
      // 154: getstatic net/minecraft/block/BlockLiquid.LEVEL Lnet/minecraft/block/properties/PropertyInteger;
      // 157: invokeinterface net/minecraft/block/state/IBlockState.getValue (Lnet/minecraft/block/properties/IProperty;)Ljava/lang/Comparable; 2
      // 15c: checkcast java/lang/Integer
      // 15f: invokevirtual java/lang/Integer.intValue ()I
      // 162: invokestatic net/minecraft/block/BlockLiquid.getLiquidHeightPercent (I)F
      // 165: fsub
      // 166: f2d
      // 167: dstore 28
      // 169: iload 12
      // 16b: ifne 199
      // 16e: iload 18
      // 170: i2d
      // 171: dload 28
      // 173: dcmpl
      // 174: iflt 196
      // 177: goto 17b
      // 17a: athrow
      // 17b: bipush 1
      // 17c: istore 21
      // 17e: aload 27
      // 180: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 185: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 188: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 18b: aload 23
      // 18d: aload 11
      // 18f: aload 22
      // 191: invokevirtual net/minecraft/block/Block.modifyAcceleration (Lnet/minecraft/world/World;Lnet/minecraft/util/BlockPos;Lnet/minecraft/entity/Entity;Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/Vec3;
      // 194: astore 22
      // 196: iinc 26 1
      // 199: iload 12
      // 19b: ifeq 10f
      // 19e: iinc 25 1
      // 1a1: iload 12
      // 1a3: ifeq 0ff
      // 1a6: iinc 24 1
      // 1a9: iload 12
      // 1ab: ifeq 0ef
      // 1ae: aload 22
      // 1b0: iload 12
      // 1b2: ifne 1ca
      // 1b5: invokevirtual net/minecraft/util/Vec3.lengthVector ()D
      // 1b8: dconst_0
      // 1b9: dcmpl
      // 1ba: ifle 1cc
      // 1bd: goto 1c1
      // 1c0: athrow
      // 1c1: aload 22
      // 1c3: invokevirtual net/minecraft/util/Vec3.normalize ()Lnet/minecraft/util/Vec3;
      // 1c6: goto 1ca
      // 1c9: athrow
      // 1ca: astore 22
      // 1cc: new x/occaf91a1f8e
      // 1cf: dup
      // 1d0: iload 21
      // 1d2: aload 22
      // 1d4: invokespecial x/occaf91a1f8e.<init> (ZLnet/minecraft/util/Vec3;)V
      // 1d7: areturn
   }

   private void ǧ(occaf91a1f8e param1, double[] param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 3
      // 04: aload 1
      // 05: iload 3
      // 06: ifne 18
      // 09: getfield x/occaf91a1f8e.в Z
      // 0c: ifeq 23
      // 0f: goto 13
      // 12: athrow
      // 13: aload 1
      // 14: goto 18
      // 17: athrow
      // 18: getfield x/occaf91a1f8e.Һ Lnet/minecraft/util/Vec3;
      // 1b: invokevirtual net/minecraft/util/Vec3.lengthVector ()D
      // 1e: dconst_0
      // 1f: dcmpg
      // 20: ifgt 25
      // 23: return
      // 24: athrow
      // 25: aload 2
      // 26: bipush 0
      // 27: dup2
      // 28: daload
      // 29: aload 1
      // 2a: getfield x/occaf91a1f8e.Һ Lnet/minecraft/util/Vec3;
      // 2d: getfield net/minecraft/util/Vec3.xCoord D
      // 30: ldc2_w 0.014
      // 33: dmul
      // 34: dadd
      // 35: dastore
      // 36: aload 2
      // 37: bipush 1
      // 38: dup2
      // 39: daload
      // 3a: aload 1
      // 3b: getfield x/occaf91a1f8e.Һ Lnet/minecraft/util/Vec3;
      // 3e: getfield net/minecraft/util/Vec3.yCoord D
      // 41: ldc2_w 0.014
      // 44: dmul
      // 45: dadd
      // 46: dastore
      // 47: aload 2
      // 48: ldc_w -1436941281
      // 4b: ldc_w -1436941283
      // 4e: ixor
      // 4f: dup2
      // 50: daload
      // 51: aload 1
      // 52: getfield x/occaf91a1f8e.Һ Lnet/minecraft/util/Vec3;
      // 55: getfield net/minecraft/util/Vec3.zCoord D
      // 58: ldc2_w 0.014
      // 5b: dmul
      // 5c: dadd
      // 5d: dastore
      // 5e: return
   }

   private AxisAlignedBB Ҁ(Vec3 var1, Vec3 var2) {
      return new AxisAlignedBB(
         Math.min(var1.xCoord, var2.xCoord),
         Math.min(var1.yCoord, var2.yCoord),
         Math.min(var1.zCoord, var2.zCoord),
         Math.max(var1.xCoord, var2.xCoord),
         Math.max(var1.yCoord, var2.yCoord),
         Math.max(var1.zCoord, var2.zCoord)
      );
   }

   private AxisAlignedBB Ҳ(Block var1, BlockPos var2) {
      var1.setBlockBoundsBasedOnState(oc69da1aa7f5.ő.theWorld, var2);
      return var1.getSelectedBoundingBox(oc69da1aa7f5.ő.theWorld, var2);
   }

   private AxisAlignedBB ɭ(AxisAlignedBB param1, AxisAlignedBB param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: aload 1
      // 04: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 07: aload 2
      // 08: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 0b: invokestatic java/lang/Math.max (DD)D
      // 0e: dstore 4
      // 10: aload 1
      // 11: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 14: aload 2
      // 15: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 18: invokestatic java/lang/Math.max (DD)D
      // 1b: dstore 6
      // 1d: istore 3
      // 1e: aload 1
      // 1f: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 22: aload 2
      // 23: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 26: invokestatic java/lang/Math.max (DD)D
      // 29: dstore 8
      // 2b: aload 1
      // 2c: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 2f: aload 2
      // 30: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 33: invokestatic java/lang/Math.min (DD)D
      // 36: dstore 10
      // 38: aload 1
      // 39: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 3c: aload 2
      // 3d: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 40: invokestatic java/lang/Math.min (DD)D
      // 43: dstore 12
      // 45: aload 1
      // 46: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 49: aload 2
      // 4a: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 4d: invokestatic java/lang/Math.min (DD)D
      // 50: dstore 14
      // 52: dload 10
      // 54: dload 4
      // 56: dsub
      // 57: iload 3
      // 58: ifne 77
      // 5b: ldc2_w 1.0E-7
      // 5e: dcmpg
      // 5f: ifle 8e
      // 62: goto 66
      // 65: athrow
      // 66: dload 12
      // 68: dload 6
      // 6a: iload 3
      // 6b: ifne 8a
      // 6e: goto 72
      // 71: athrow
      // 72: dsub
      // 73: goto 77
      // 76: athrow
      // 77: ldc2_w 1.0E-7
      // 7a: dcmpg
      // 7b: ifle 8e
      // 7e: dload 14
      // 80: dload 8
      // 82: dsub
      // 83: ldc2_w 1.0E-7
      // 86: goto 8a
      // 89: athrow
      // 8a: dcmpg
      // 8b: ifgt 91
      // 8e: aconst_null
      // 8f: areturn
      // 90: athrow
      // 91: new net/minecraft/util/AxisAlignedBB
      // 94: dup
      // 95: dload 4
      // 97: dload 6
      // 99: dload 8
      // 9b: dload 10
      // 9d: dload 12
      // 9f: dload 14
      // a1: invokespecial net/minecraft/util/AxisAlignedBB.<init> (DDDDDD)V
      // a4: areturn
   }

   private oc50ba88bc3e Ǚ(Vec3 param1, Vec3 param2, oc8ea84f7e0d param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: aload 0
      // 001: aload 1
      // 002: aload 2
      // 003: invokevirtual x/Z.Ҁ (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/AxisAlignedBB;
      // 006: astore 5
      // 008: getstatic x/oce6044968f8.ђ Z
      // 00b: aload 5
      // 00d: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 010: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 013: istore 6
      // 015: aload 5
      // 017: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 01a: dconst_1
      // 01b: dadd
      // 01c: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 01f: istore 7
      // 021: aload 5
      // 023: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 026: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 029: istore 8
      // 02b: istore 4
      // 02d: aload 5
      // 02f: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 032: dconst_1
      // 033: dadd
      // 034: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 037: istore 9
      // 039: aload 5
      // 03b: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 03e: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 041: istore 10
      // 043: aload 5
      // 045: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 048: dconst_1
      // 049: dadd
      // 04a: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 04d: istore 11
      // 04f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 052: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 055: new net/minecraft/util/BlockPos
      // 058: dup
      // 059: iload 6
      // 05b: iload 8
      // 05d: iload 10
      // 05f: invokespecial net/minecraft/util/BlockPos.<init> (III)V
      // 062: new net/minecraft/util/BlockPos
      // 065: dup
      // 066: iload 7
      // 068: iload 9
      // 06a: iload 11
      // 06c: invokespecial net/minecraft/util/BlockPos.<init> (III)V
      // 06f: bipush 1
      // 070: invokevirtual net/minecraft/client/multiplayer/WorldClient.isAreaLoaded (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/BlockPos;Z)Z
      // 073: ifne 083
      // 076: new x/oc50ba88bc3e
      // 079: dup
      // 07a: aconst_null
      // 07b: ldc2_w 1.7976931348623157E308
      // 07e: invokespecial x/oc50ba88bc3e.<init> (Lnet/minecraft/util/MovingObjectPosition;D)V
      // 081: areturn
      // 082: athrow
      // 083: new java/util/ArrayList
      // 086: dup
      // 087: invokespecial java/util/ArrayList.<init> ()V
      // 08a: astore 12
      // 08c: new net/minecraft/util/BlockPos$MutableBlockPos
      // 08f: dup
      // 090: invokespecial net/minecraft/util/BlockPos$MutableBlockPos.<init> ()V
      // 093: astore 13
      // 095: aconst_null
      // 096: astore 14
      // 098: ldc2_w 1.7976931348623157E308
      // 09b: dstore 15
      // 09d: iload 6
      // 09f: istore 17
      // 0a1: iload 17
      // 0a3: iload 7
      // 0a5: if_icmpge 20a
      // 0a8: iload 8
      // 0aa: istore 18
      // 0ac: iload 18
      // 0ae: iload 9
      // 0b0: if_icmpge 202
      // 0b3: iload 4
      // 0b5: ifne 205
      // 0b8: iload 10
      // 0ba: istore 19
      // 0bc: iload 19
      // 0be: iload 11
      // 0c0: if_icmpge 1fa
      // 0c3: iload 4
      // 0c5: ifne 1fd
      // 0c8: aload 13
      // 0ca: iload 17
      // 0cc: iload 18
      // 0ce: iload 19
      // 0d0: invokevirtual net/minecraft/util/BlockPos$MutableBlockPos.set (III)Lnet/minecraft/util/BlockPos$MutableBlockPos;
      // 0d3: pop
      // 0d4: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0d7: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 0da: aload 13
      // 0dc: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 0df: astore 20
      // 0e1: aload 20
      // 0e3: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 0e8: astore 21
      // 0ea: aload 3
      // 0eb: getfield x/oc8ea84f7e0d.ҏ Z
      // 0ee: iload 4
      // 0f0: ifne 125
      // 0f3: ifeq 119
      // 0f6: goto 0fa
      // 0f9: athrow
      // 0fa: aload 21
      // 0fc: iload 4
      // 0fe: ifne 11f
      // 101: goto 105
      // 104: athrow
      // 105: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 108: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 10b: aload 13
      // 10d: aload 20
      // 10f: invokevirtual net/minecraft/block/Block.getCollisionBoundingBox (Lnet/minecraft/world/World;Lnet/minecraft/util/BlockPos;Lnet/minecraft/block/state/IBlockState;)Lnet/minecraft/util/AxisAlignedBB;
      // 112: ifnull 1f2
      // 115: goto 119
      // 118: athrow
      // 119: aload 21
      // 11b: goto 11f
      // 11e: athrow
      // 11f: aload 20
      // 121: bipush 0
      // 122: invokevirtual net/minecraft/block/Block.canCollideCheck (Lnet/minecraft/block/state/IBlockState;Z)Z
      // 125: ifeq 1f2
      // 128: aload 12
      // 12a: invokeinterface java/util/List.clear ()V 1
      // 12f: aload 0
      // 130: goto 134
      // 133: athrow
      // 134: aload 21
      // 136: aload 13
      // 138: invokevirtual x/Z.Ҳ (Lnet/minecraft/block/Block;Lnet/minecraft/util/BlockPos;)Lnet/minecraft/util/AxisAlignedBB;
      // 13b: astore 22
      // 13d: aload 21
      // 13f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 142: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 145: aload 13
      // 147: aload 20
      // 149: aload 5
      // 14b: aload 12
      // 14d: aconst_null
      // 14e: invokevirtual net/minecraft/block/Block.addCollisionBoxesToList (Lnet/minecraft/world/World;Lnet/minecraft/util/BlockPos;Lnet/minecraft/block/state/IBlockState;Lnet/minecraft/util/AxisAlignedBB;Ljava/util/List;Lnet/minecraft/entity/Entity;)V
      // 151: aload 12
      // 153: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 158: astore 23
      // 15a: aload 23
      // 15c: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 161: ifeq 1f2
      // 164: aload 23
      // 166: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 16b: checkcast net/minecraft/util/AxisAlignedBB
      // 16e: astore 24
      // 170: aload 0
      // 171: iload 4
      // 173: ifne 134
      // 176: aload 24
      // 178: aload 22
      // 17a: invokevirtual x/Z.ɭ (Lnet/minecraft/util/AxisAlignedBB;Lnet/minecraft/util/AxisAlignedBB;)Lnet/minecraft/util/AxisAlignedBB;
      // 17d: astore 25
      // 17f: aload 25
      // 181: iload 4
      // 183: ifne 198
      // 186: ifnonnull 196
      // 189: goto 18d
      // 18c: athrow
      // 18d: iload 4
      // 18f: ifeq 15a
      // 192: goto 196
      // 195: athrow
      // 196: aload 25
      // 198: aload 1
      // 199: aload 2
      // 19a: invokevirtual net/minecraft/util/AxisAlignedBB.calculateIntercept (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/MovingObjectPosition;
      // 19d: astore 26
      // 19f: aload 26
      // 1a1: ifnonnull 1ad
      // 1a4: iload 4
      // 1a6: ifeq 15a
      // 1a9: goto 1ad
      // 1ac: athrow
      // 1ad: aload 1
      // 1ae: aload 26
      // 1b0: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 1b3: invokevirtual net/minecraft/util/Vec3.squareDistanceTo (Lnet/minecraft/util/Vec3;)D
      // 1b6: dstore 27
      // 1b8: iload 4
      // 1ba: ifne 1d1
      // 1bd: dload 27
      // 1bf: ldc2_w 1.0E-7
      // 1c2: dadd
      // 1c3: dload 15
      // 1c5: dcmpg
      // 1c6: ifge 1ed
      // 1c9: goto 1cd
      // 1cc: athrow
      // 1cd: dload 27
      // 1cf: dstore 15
      // 1d1: new net/minecraft/util/MovingObjectPosition
      // 1d4: dup
      // 1d5: aload 26
      // 1d7: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 1da: aload 26
      // 1dc: getfield net/minecraft/util/MovingObjectPosition.sideHit Lnet/minecraft/util/EnumFacing;
      // 1df: new net/minecraft/util/BlockPos
      // 1e2: dup
      // 1e3: aload 13
      // 1e5: invokespecial net/minecraft/util/BlockPos.<init> (Lnet/minecraft/util/Vec3i;)V
      // 1e8: invokespecial net/minecraft/util/MovingObjectPosition.<init> (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/EnumFacing;Lnet/minecraft/util/BlockPos;)V
      // 1eb: astore 14
      // 1ed: iload 4
      // 1ef: ifeq 15a
      // 1f2: iinc 19 1
      // 1f5: iload 4
      // 1f7: ifeq 0bc
      // 1fa: iinc 18 1
      // 1fd: iload 4
      // 1ff: ifeq 0ac
      // 202: iinc 17 1
      // 205: iload 4
      // 207: ifeq 0a1
      // 20a: new x/oc50ba88bc3e
      // 20d: dup
      // 20e: aload 14
      // 210: dload 15
      // 212: invokespecial x/oc50ba88bc3e.<init> (Lnet/minecraft/util/MovingObjectPosition;D)V
      // 215: areturn
   }

   private oc50ba88bc3e ɠ(Vec3 param1, Vec3 param2, oc8ea84f7e0d param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 06: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 09: aload 1
      // 0a: aload 2
      // 0b: bipush 0
      // 0c: aload 3
      // 0d: getfield x/oc8ea84f7e0d.ҏ Z
      // 10: bipush 0
      // 11: invokevirtual net/minecraft/client/multiplayer/WorldClient.rayTraceBlocks (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;ZZZ)Lnet/minecraft/util/MovingObjectPosition;
      // 14: astore 5
      // 16: istore 4
      // 18: aload 5
      // 1a: ifnull 2a
      // 1d: aload 1
      // 1e: aload 5
      // 20: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 23: invokevirtual net/minecraft/util/Vec3.squareDistanceTo (Lnet/minecraft/util/Vec3;)D
      // 26: goto 2d
      // 29: athrow
      // 2a: ldc2_w 1.7976931348623157E308
      // 2d: dstore 6
      // 2f: aload 0
      // 30: aload 1
      // 31: aload 2
      // 32: aload 3
      // 33: invokevirtual x/Z.Ǚ (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;Lx/oc8ea84f7e0d;)Lx/oc50ba88bc3e;
      // 36: astore 8
      // 38: aload 8
      // 3a: iload 4
      // 3c: ifne 74
      // 3f: getfield x/oc50ba88bc3e.շ Lnet/minecraft/util/MovingObjectPosition;
      // 42: ifnull 69
      // 45: goto 49
      // 48: athrow
      // 49: aload 8
      // 4b: iload 4
      // 4d: ifne 74
      // 50: goto 54
      // 53: athrow
      // 54: getfield x/oc50ba88bc3e.ҕ D
      // 57: ldc2_w 1.0E-7
      // 5a: dadd
      // 5b: dload 6
      // 5d: dcmpg
      // 5e: ifge 69
      // 61: goto 65
      // 64: athrow
      // 65: aload 8
      // 67: areturn
      // 68: athrow
      // 69: new x/oc50ba88bc3e
      // 6c: dup
      // 6d: aload 5
      // 6f: dload 6
      // 71: invokespecial x/oc50ba88bc3e.<init> (Lnet/minecraft/util/MovingObjectPosition;D)V
      // 74: areturn
   }

   private oc1378bc114d ԥ() {
      return oce6044968f8.ʜ();
   }
}

package x;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;
import org.lwjgl.opengl.GL11;

public class oca1af5e72c7 extends oc69da1aa7f5 {
   private static final int Ȓ = 0;
   private static final int ɺ = 1;
   private static final int ş = 2;
   private static final int Э = 3;
   private occ2f8dff8d8 Ӷ;
   private occ2f8dff8d8 ȉ;
   private occ2f8dff8d8 λ;
   private oca9cc61aada Ȧ;
   private occ2f8dff8d8 Ǩ;
   private oc24a0a5bddf Б;
   private oc24a0a5bddf ć;
   private oc24a0a5bddf դ;
   private oc24a0a5bddf Ŧ;
   private oca9cc61aada Ϗ;
   private occ2f8dff8d8 ќ;
   private occ2f8dff8d8 Ƃ;
   private occ2f8dff8d8 ы;
   private oca9cc61aada Ӹ;
   private oc24a0a5bddf Σ;
   private static final double ӈ = 0.6;
   private static final double ϟ = 0.8;
   private static final double ì = 0.92;
   private static final double Ǖ = 0.014;
   private static final double Ý = -0.4F;
   private static final double Ä = 0.001;
   private static final double ϗ = -0.1F;
   private static final double ƿ = -0.4F;
   private static final int ѐ = 5;
   private static final double Ʀ = 0.04F;
   private static final double ϩ = 0.8;
   private static final double ȯ = 0.9;
   private static final double ҡ = 0.5;
   private static final double ʴ = 1.0E-7;
   private static final double ӛ = 0.3;
   private static final float Ķ = 1.75F;
   public static int Г;

   public oca1af5e72c7() {
      super("Trajectories", oce4cea752dd.Ŏ);
      this.ą("Predicts projectile paths and landing positions.");
      this.ʌ(this.Ӷ = new occ2f8dff8d8("Disable uncharged bow", true));
      this.ʌ(this.ȉ = new occ2f8dff8d8("Highlight on entity", true));
      this.ʌ(this.λ = new occ2f8dff8d8("Shorten line", false));
      this.ʌ(this.Ȧ = new oca9cc61aada("Line thickness", 2.0, 1.0, 5.0, 0.1));
      this.ʌ(this.Б = new oc24a0a5bddf("Default", 1176043835 ^ 1176043921, 0, 1176043886 ^ 1176043921));
      this.ʌ(this.ć = new oc24a0a5bddf("Enemy Hit", 1176043886 ^ 1176043921, 1176043939 ^ 1176043921, 1176043939 ^ 1176043921));
      this.ʌ(this.դ = new oc24a0a5bddf("Wall Hit", 1176043939 ^ 1176043921, 1176043886 ^ 1176043921, 1176043939 ^ 1176043921));
      this.ʌ(this.Ŧ = new oc24a0a5bddf("Ground Hit", 1176043972 ^ 1176043921, 1176043886 ^ 1176043921, 1176043886 ^ 1176043921));
      this.ʌ(this.Ϗ = new oca9cc61aada("Max ticks", 100.0, 30.0, 200.0, 10.0));
      this.ʌ(this.ќ = new occ2f8dff8d8("Show landing", true));
      this.ʌ(this.Ƃ = new occ2f8dff8d8("Only when holding", true));
      this.ʌ(this.Ǩ = new occ2f8dff8d8("Add player velocity", false));
      this.ʌ(this.ы = new occ2f8dff8d8("Fireballs", true));
      this.ʌ(this.Ӹ = new oca9cc61aada("Fireball range", 128.0, 16.0, 256.0, 8.0));
      this.ʌ(this.Σ = new oc24a0a5bddf("Fireball", 1176043939 ^ 1176043921, 1176043776 ^ 1176043921, 1176043886 ^ 1176043921));
   }

   private float ɠ(float var1) {
      boolean var10000 = oce6044968f8.ђ;
      int var3 = oc69da1aa7f5.ő.thePlayer.getItemInUseCount();
      boolean var2 = var10000;
      float var4 = (2050698870 ^ 2050635574) - var3 + var1;
      float var5 = var4 / 20.0F;
      float var7 = var5 * var5;
      float var10001 = var5 * 2.0F;
      if (!var2) {
         var5 = (var7 + var10001) / 3.0F;
         if (var5 > 1.0F) {
            var5 = 1.0F;
         }

         var7 = var5 * 2.0F;
         var10001 = 1.5F;
      }

      return var7 * var10001;
   }

   private oc55a0d9ec35 Ҟ(Item param1, EntityPlayer param2, float param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: istore 4
      // 005: aload 1
      // 006: iload 4
      // 008: ifne 03f
      // 00b: getstatic net/minecraft/init/Items.bow Lnet/minecraft/item/ItemBow;
      // 00e: if_acmpne 03e
      // 011: goto 015
      // 014: athrow
      // 015: aload 0
      // 016: fload 3
      // 017: invokevirtual x/oca1af5e72c7.ɠ (F)F
      // 01a: fstore 5
      // 01c: new x/oc55a0d9ec35
      // 01f: dup
      // 020: getstatic x/D.Ø Lx/D;
      // 023: ldc2_w 0.05
      // 026: ldc2_w 0.99
      // 029: ldc2_w 0.6
      // 02c: ldc2_w 0.5
      // 02f: ldc2_w 0.5
      // 032: ldc2_w 0.5
      // 035: fload 5
      // 037: f2d
      // 038: bipush 0
      // 039: bipush 1
      // 03a: invokespecial x/oc55a0d9ec35.<init> (Lx/D;DDDDDDDZZ)V
      // 03d: areturn
      // 03e: aload 1
      // 03f: iload 4
      // 041: ifne 072
      // 044: getstatic net/minecraft/init/Items.ender_pearl Lnet/minecraft/item/Item;
      // 047: if_acmpne 071
      // 04a: goto 04e
      // 04d: athrow
      // 04e: new x/oc55a0d9ec35
      // 051: dup
      // 052: getstatic x/D.ˤ Lx/D;
      // 055: ldc2_w 0.03
      // 058: ldc2_w 0.99
      // 05b: ldc2_w 0.8
      // 05e: ldc2_w 0.25
      // 061: ldc2_w 0.25
      // 064: ldc2_w 0.25
      // 067: ldc2_w 1.5
      // 06a: bipush 1
      // 06b: bipush 0
      // 06c: invokespecial x/oc55a0d9ec35.<init> (Lx/D;DDDDDDDZZ)V
      // 06f: areturn
      // 070: athrow
      // 071: aload 1
      // 072: iload 4
      // 074: ifne 086
      // 077: getstatic net/minecraft/init/Items.snowball Lnet/minecraft/item/Item;
      // 07a: if_acmpeq 095
      // 07d: goto 081
      // 080: athrow
      // 081: aload 1
      // 082: goto 086
      // 085: athrow
      // 086: iload 4
      // 088: ifne 0b9
      // 08b: getstatic net/minecraft/init/Items.egg Lnet/minecraft/item/Item;
      // 08e: if_acmpne 0b8
      // 091: goto 095
      // 094: athrow
      // 095: new x/oc55a0d9ec35
      // 098: dup
      // 099: getstatic x/D.ˤ Lx/D;
      // 09c: ldc2_w 0.03
      // 09f: ldc2_w 0.99
      // 0a2: ldc2_w 0.8
      // 0a5: ldc2_w 0.25
      // 0a8: ldc2_w 0.25
      // 0ab: ldc2_w 0.25
      // 0ae: ldc2_w 1.5
      // 0b1: bipush 1
      // 0b2: bipush 0
      // 0b3: invokespecial x/oc55a0d9ec35.<init> (Lx/D;DDDDDDDZZ)V
      // 0b6: areturn
      // 0b7: athrow
      // 0b8: aload 1
      // 0b9: iload 4
      // 0bb: ifne 0ec
      // 0be: getstatic net/minecraft/init/Items.experience_bottle Lnet/minecraft/item/Item;
      // 0c1: if_acmpne 0eb
      // 0c4: goto 0c8
      // 0c7: athrow
      // 0c8: new x/oc55a0d9ec35
      // 0cb: dup
      // 0cc: getstatic x/D.ˤ Lx/D;
      // 0cf: ldc2_w 0.07
      // 0d2: ldc2_w 0.99
      // 0d5: ldc2_w 0.8
      // 0d8: ldc2_w 0.25
      // 0db: ldc2_w 0.25
      // 0de: ldc2_w 0.25
      // 0e1: ldc2_w 0.7
      // 0e4: bipush 1
      // 0e5: bipush 0
      // 0e6: invokespecial x/oc55a0d9ec35.<init> (Lx/D;DDDDDDDZZ)V
      // 0e9: areturn
      // 0ea: athrow
      // 0eb: aload 1
      // 0ec: iload 4
      // 0ee: ifne 11f
      // 0f1: getstatic net/minecraft/init/Items.potionitem Lnet/minecraft/item/ItemPotion;
      // 0f4: if_acmpne 11e
      // 0f7: goto 0fb
      // 0fa: athrow
      // 0fb: new x/oc55a0d9ec35
      // 0fe: dup
      // 0ff: getstatic x/D.ˤ Lx/D;
      // 102: ldc2_w 0.05
      // 105: ldc2_w 0.99
      // 108: ldc2_w 0.8
      // 10b: ldc2_w 0.25
      // 10e: ldc2_w 0.25
      // 111: ldc2_w 0.25
      // 114: ldc2_w 0.5
      // 117: bipush 1
      // 118: bipush 0
      // 119: invokespecial x/oc55a0d9ec35.<init> (Lx/D;DDDDDDDZZ)V
      // 11c: areturn
      // 11d: athrow
      // 11e: aload 1
      // 11f: getstatic net/minecraft/init/Items.fishing_rod Lnet/minecraft/item/ItemFishingRod;
      // 122: if_acmpne 148
      // 125: new x/oc55a0d9ec35
      // 128: dup
      // 129: getstatic x/D.ӽ Lx/D;
      // 12c: ldc2_w 0.04
      // 12f: ldc2_w 0.92
      // 132: ldc2_w 0.92
      // 135: ldc2_w 0.25
      // 138: ldc2_w 0.25
      // 13b: ldc2_w 0.25
      // 13e: ldc2_w 1.5
      // 141: bipush 0
      // 142: bipush 0
      // 143: invokespecial x/oc55a0d9ec35.<init> (Lx/D;DDDDDDDZZ)V
      // 146: areturn
      // 147: athrow
      // 148: aconst_null
      // 149: areturn
   }

   private boolean Ƀ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 1
      // 04: invokestatic x/oc7ab2161b9f.Տ ()Z
      // 07: iload 1
      // 08: ifne 2c
      // 0b: ifeq 27
      // 0e: goto 12
      // 11: athrow
      // 12: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 15: iload 1
      // 16: ifne 30
      // 19: goto 1d
      // 1c: athrow
      // 1d: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 20: ifnonnull 2d
      // 23: goto 27
      // 26: athrow
      // 27: bipush 0
      // 28: goto 2c
      // 2b: athrow
      // 2c: ireturn
      // 2d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 30: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 33: invokevirtual net/minecraft/client/multiplayer/WorldClient.getScoreboard ()Lnet/minecraft/scoreboard/Scoreboard;
      // 36: astore 2
      // 37: aload 2
      // 38: iload 1
      // 39: ifne 47
      // 3c: ifnonnull 46
      // 3f: goto 43
      // 42: athrow
      // 43: bipush 0
      // 44: ireturn
      // 45: athrow
      // 46: aload 2
      // 47: bipush 1
      // 48: invokevirtual net/minecraft/scoreboard/Scoreboard.getObjectiveInDisplaySlot (I)Lnet/minecraft/scoreboard/ScoreObjective;
      // 4b: astore 3
      // 4c: aload 3
      // 4d: iload 1
      // 4e: ifne 59
      // 51: ifnull 74
      // 54: goto 58
      // 57: athrow
      // 58: aload 3
      // 59: invokevirtual net/minecraft/scoreboard/ScoreObjective.getDisplayName ()Ljava/lang/String;
      // 5c: invokestatic x/oc7ab2161b9f.ȑ (Ljava/lang/String;)Ljava/lang/String;
      // 5f: ldc_w "BED WARS"
      // 62: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 65: iload 1
      // 66: ifne 71
      // 69: ifeq 74
      // 6c: goto 70
      // 6f: athrow
      // 70: bipush 1
      // 71: goto 75
      // 74: bipush 0
      // 75: ireturn
   }

   private boolean Ї(ItemStack param1) {
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
      // 06: ifne 11
      // 09: ifnull 22
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 1
      // 11: iload 2
      // 12: ifne 26
      // 15: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 18: getstatic net/minecraft/init/Items.snowball Lnet/minecraft/item/Item;
      // 1b: if_acmpeq 25
      // 1e: goto 22
      // 21: athrow
      // 22: bipush 0
      // 23: ireturn
      // 24: athrow
      // 25: aload 1
      // 26: invokevirtual net/minecraft/item/ItemStack.getDisplayName ()Ljava/lang/String;
      // 29: astore 3
      // 2a: aload 3
      // 2b: iload 2
      // 2c: ifne 40
      // 2f: ifnonnull 39
      // 32: goto 36
      // 35: athrow
      // 36: bipush 0
      // 37: ireturn
      // 38: athrow
      // 39: aload 3
      // 3a: invokestatic x/oc7ab2161b9f.ȑ (Ljava/lang/String;)Ljava/lang/String;
      // 3d: invokevirtual java/lang/String.toLowerCase ()Ljava/lang/String;
      // 40: ldc_w "bedbug"
      // 43: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 46: ireturn
   }

   private C Ξ(double param1, double param3, double param5, oc55a0d9ec35 param7) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: aload 0
      // 001: dload 1
      // 002: dload 3
      // 003: dload 5
      // 005: aload 7
      // 007: invokevirtual x/oca1af5e72c7.Ҏ (DDDLx/oc55a0d9ec35;)Lnet/minecraft/util/AxisAlignedBB;
      // 00a: astore 9
      // 00c: aload 9
      // 00e: dconst_0
      // 00f: ldc2_w -0.4000000059604645
      // 012: dconst_0
      // 013: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 016: ldc2_w 0.001
      // 019: ldc2_w 0.001
      // 01c: ldc2_w 0.001
      // 01f: invokevirtual net/minecraft/util/AxisAlignedBB.contract (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 022: astore 10
      // 024: aload 10
      // 026: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 029: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 02c: istore 11
      // 02e: aload 10
      // 030: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 033: dconst_1
      // 034: dadd
      // 035: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 038: istore 12
      // 03a: getstatic x/oce6044968f8.ђ Z
      // 03d: aload 10
      // 03f: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 042: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 045: istore 13
      // 047: aload 10
      // 049: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 04c: dconst_1
      // 04d: dadd
      // 04e: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 051: istore 14
      // 053: istore 8
      // 055: aload 10
      // 057: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 05a: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 05d: istore 15
      // 05f: aload 10
      // 061: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 064: dconst_1
      // 065: dadd
      // 066: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 069: istore 16
      // 06b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 06e: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 071: new net/minecraft/util/BlockPos
      // 074: dup
      // 075: iload 11
      // 077: iload 13
      // 079: iload 15
      // 07b: invokespecial net/minecraft/util/BlockPos.<init> (III)V
      // 07e: new net/minecraft/util/BlockPos
      // 081: dup
      // 082: iload 12
      // 084: iload 14
      // 086: iload 16
      // 088: invokespecial net/minecraft/util/BlockPos.<init> (III)V
      // 08b: bipush 1
      // 08c: invokevirtual net/minecraft/client/multiplayer/WorldClient.isAreaLoaded (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/BlockPos;Z)Z
      // 08f: iload 8
      // 091: ifne 0b1
      // 094: ifne 0b0
      // 097: goto 09b
      // 09a: athrow
      // 09b: new x/C
      // 09e: dup
      // 09f: bipush 0
      // 0a0: bipush 0
      // 0a1: new net/minecraft/util/Vec3
      // 0a4: dup
      // 0a5: dconst_0
      // 0a6: dconst_0
      // 0a7: dconst_0
      // 0a8: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 0ab: invokespecial x/C.<init> (ZZLnet/minecraft/util/Vec3;)V
      // 0ae: areturn
      // 0af: athrow
      // 0b0: bipush 0
      // 0b1: istore 17
      // 0b3: new net/minecraft/util/Vec3
      // 0b6: dup
      // 0b7: dconst_0
      // 0b8: dconst_0
      // 0b9: dconst_0
      // 0ba: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 0bd: astore 18
      // 0bf: new net/minecraft/util/BlockPos$MutableBlockPos
      // 0c2: dup
      // 0c3: invokespecial net/minecraft/util/BlockPos$MutableBlockPos.<init> ()V
      // 0c6: astore 19
      // 0c8: iload 11
      // 0ca: istore 20
      // 0cc: iload 20
      // 0ce: iload 12
      // 0d0: if_icmpge 18f
      // 0d3: iload 8
      // 0d5: ifne 1c5
      // 0d8: iload 13
      // 0da: istore 21
      // 0dc: iload 21
      // 0de: iload 14
      // 0e0: if_icmpge 187
      // 0e3: iload 8
      // 0e5: ifne 18a
      // 0e8: iload 15
      // 0ea: istore 22
      // 0ec: iload 22
      // 0ee: iload 16
      // 0f0: if_icmpge 17f
      // 0f3: aload 19
      // 0f5: iload 20
      // 0f7: iload 21
      // 0f9: iload 22
      // 0fb: invokevirtual net/minecraft/util/BlockPos$MutableBlockPos.set (III)Lnet/minecraft/util/BlockPos$MutableBlockPos;
      // 0fe: pop
      // 0ff: iload 8
      // 101: ifne 182
      // 104: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 107: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 10a: aload 19
      // 10c: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 10f: astore 23
      // 111: aload 23
      // 113: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 118: invokevirtual net/minecraft/block/Block.getMaterial ()Lnet/minecraft/block/material/Material;
      // 11b: getstatic net/minecraft/block/material/Material.water Lnet/minecraft/block/material/Material;
      // 11e: if_acmpeq 12a
      // 121: iload 8
      // 123: ifeq 177
      // 126: goto 12a
      // 129: athrow
      // 12a: iload 21
      // 12c: bipush 1
      // 12d: iadd
      // 12e: i2f
      // 12f: aload 23
      // 131: getstatic net/minecraft/block/BlockLiquid.LEVEL Lnet/minecraft/block/properties/PropertyInteger;
      // 134: invokeinterface net/minecraft/block/state/IBlockState.getValue (Lnet/minecraft/block/properties/IProperty;)Ljava/lang/Comparable; 2
      // 139: checkcast java/lang/Integer
      // 13c: invokevirtual java/lang/Integer.intValue ()I
      // 13f: invokestatic net/minecraft/block/BlockLiquid.getLiquidHeightPercent (I)F
      // 142: fsub
      // 143: f2d
      // 144: dstore 24
      // 146: iload 8
      // 148: ifne 17a
      // 14b: iload 14
      // 14d: i2d
      // 14e: dload 24
      // 150: dcmpl
      // 151: iflt 177
      // 154: goto 158
      // 157: athrow
      // 158: bipush 1
      // 159: istore 17
      // 15b: aload 23
      // 15d: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 162: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 165: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 168: aload 19
      // 16a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 16d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 170: aload 18
      // 172: invokevirtual net/minecraft/block/Block.modifyAcceleration (Lnet/minecraft/world/World;Lnet/minecraft/util/BlockPos;Lnet/minecraft/entity/Entity;Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/Vec3;
      // 175: astore 18
      // 177: iinc 22 1
      // 17a: iload 8
      // 17c: ifeq 0ec
      // 17f: iinc 21 1
      // 182: iload 8
      // 184: ifeq 0dc
      // 187: iinc 20 1
      // 18a: iload 8
      // 18c: ifeq 0cc
      // 18f: aload 18
      // 191: invokevirtual net/minecraft/util/Vec3.lengthVector ()D
      // 194: dconst_0
      // 195: dcmpl
      // 196: iload 8
      // 198: ifne 1c3
      // 19b: ifle 1a9
      // 19e: goto 1a2
      // 1a1: athrow
      // 1a2: aload 18
      // 1a4: invokevirtual net/minecraft/util/Vec3.normalize ()Lnet/minecraft/util/Vec3;
      // 1a7: astore 18
      // 1a9: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1ac: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 1af: aload 9
      // 1b1: ldc2_w -0.10000000149011612
      // 1b4: ldc2_w -0.4000000059604645
      // 1b7: ldc2_w -0.10000000149011612
      // 1ba: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 1bd: getstatic net/minecraft/block/material/Material.lava Lnet/minecraft/block/material/Material;
      // 1c0: invokevirtual net/minecraft/client/multiplayer/WorldClient.isMaterialInBB (Lnet/minecraft/util/AxisAlignedBB;Lnet/minecraft/block/material/Material;)Z
      // 1c3: istore 20
      // 1c5: new x/C
      // 1c8: dup
      // 1c9: iload 17
      // 1cb: iload 20
      // 1cd: aload 18
      // 1cf: invokespecial x/C.<init> (ZZLnet/minecraft/util/Vec3;)V
      // 1d2: areturn
   }

   private AxisAlignedBB Ҏ(double var1, double var3, double var5, oc55a0d9ec35 var7) {
      return new AxisAlignedBB(var1 - var7.Έ * 0.5, var3, var5 - var7.Έ * 0.5, var1 + var7.Έ * 0.5, var3 + var7.Π, var5 + var7.Έ * 0.5);
   }

   private double Ӱ(double var1, double var3, double var5, oc55a0d9ec35 var7) {
      boolean var10000 = oce6044968f8.ђ;
      AxisAlignedBB var9 = this.Ҏ(var1, var3, var5, var7);
      double var10 = 0.0;
      boolean var8 = var10000;
      int var12 = 0;

      while (true) {
         if (var12 < (-396805183 ^ -396805180)) {
            double var13 = var9.maxY - var9.minY;
            var21 = var9.minY;
            if (var8) {
               break;
            }

            double var15 = var9.minY + var13 * var12 / 5.0;
            var10000 = var8;
            double var17 = var9.minY + var13 * (var12 + 1) / 5.0;
            AxisAlignedBB var19 = new AxisAlignedBB(var9.minX, var15, var9.minZ, var9.maxX, var17, var9.maxZ);

            label30: {
               label29: {
                  try {
                     if (var10000) {
                        break label30;
                     }

                     if (!oc69da1aa7f5.ő.theWorld.isAABBInMaterial(var19, Material.water)) {
                        break label29;
                     }
                  } catch (ocbde1165e4e var20) {
                     throw var20;
                  }

                  var10 += 0.2;
               }

               var12++;
            }

            if (!var8) {
               continue;
            }
         }

         var21 = var10;
         break;
      }

      return var21;
   }

   private void Ё(C param1, double[] param2) {
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
      // 09: getfield x/C.Ɨ Z
      // 0c: ifeq 23
      // 0f: goto 13
      // 12: athrow
      // 13: aload 1
      // 14: goto 18
      // 17: athrow
      // 18: getfield x/C.ɍ Lnet/minecraft/util/Vec3;
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
      // 2a: getfield x/C.ɍ Lnet/minecraft/util/Vec3;
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
      // 3b: getfield x/C.ɍ Lnet/minecraft/util/Vec3;
      // 3e: getfield net/minecraft/util/Vec3.yCoord D
      // 41: ldc2_w 0.014
      // 44: dmul
      // 45: dadd
      // 46: dastore
      // 47: aload 2
      // 48: ldc_w 1647205834
      // 4b: ldc_w 1647205832
      // 4e: ixor
      // 4f: dup2
      // 50: daload
      // 51: aload 1
      // 52: getfield x/C.ɍ Lnet/minecraft/util/Vec3;
      // 55: getfield net/minecraft/util/Vec3.zCoord D
      // 58: ldc2_w 0.014
      // 5b: dmul
      // 5c: dadd
      // 5d: dastore
      // 5e: return
   }

   private void Ů(oc55a0d9ec35 var1, C var2, double[] var3) {
      double var10000;
      label16: {
         try {
            if (var2.Ɨ) {
               var10000 = var1.ä;
               break label16;
            }
         } catch (ocbde1165e4e var6) {
            throw var6;
         }

         var10000 = var1.ĸ;
      }

      double var4 = var10000;
      var3[0] *= var4;
      var3[1] *= var4;
      var3[-1605431358 ^ -1605431360] = var3[-1605431358 ^ -1605431360] * var4;
      var3[1] -= var1.ǜ;
   }

   private void ȭ(double var1, double var3, double var5, oc55a0d9ec35 var7, double[] var8) {
      boolean var10000 = oce6044968f8.ђ;
      double var10 = var7.ĸ;
      double var12 = this.Ӱ(var1, var3, var5, var7);
      boolean var9 = var10000;
      double var14 = var12 * 2.0 - 1.0;

      label20: {
         try {
            if (var9) {
               return;
            }

            var8[1] += 0.04F * var14;
            if (!(var12 > 0.0)) {
               break label20;
            }
         } catch (ocbde1165e4e var16) {
            throw var16;
         }

         var10 *= 0.9;
         var8[1] *= 0.8;
      }

      var8[0] *= var10;
      var8[1] *= var10;
      var8[-167373985 ^ -167373987] = var8[-167373985 ^ -167373987] * var10;
   }

   private void Ͱ(double param1, double param3, double param5, oc55a0d9ec35 param7, C param8, double[] param9) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 10
      // 05: aload 7
      // 07: getfield x/oc55a0d9ec35.ļ Lx/D;
      // 0a: getstatic x/D.ӽ Lx/D;
      // 0d: if_acmpne 1e
      // 10: aload 0
      // 11: dload 1
      // 12: dload 3
      // 13: dload 5
      // 15: aload 7
      // 17: aload 9
      // 19: invokevirtual x/oca1af5e72c7.ȭ (DDDLx/oc55a0d9ec35;[D)V
      // 1c: return
      // 1d: athrow
      // 1e: aload 8
      // 20: iload 10
      // 22: ifne 35
      // 25: getfield x/C.Ϗ Z
      // 28: ifeq 3b
      // 2b: goto 2f
      // 2e: athrow
      // 2f: aload 8
      // 31: goto 35
      // 34: athrow
      // 35: getfield x/C.Ɨ Z
      // 38: ifne 3b
      // 3b: aload 0
      // 3c: aload 7
      // 3e: aload 8
      // 40: aload 9
      // 42: invokevirtual x/oca1af5e72c7.Ů (Lx/oc55a0d9ec35;Lx/C;[D)V
      // 45: return
   }

   private AxisAlignedBB ʥ(AxisAlignedBB var1) {
      return var1.expand(0.3, 0.3, 0.3);
   }

   private AxisAlignedBB Ί(Vec3 var1, Vec3 var2) {
      return new AxisAlignedBB(
         Math.min(var1.xCoord, var2.xCoord),
         Math.min(var1.yCoord, var2.yCoord),
         Math.min(var1.zCoord, var2.zCoord),
         Math.max(var1.xCoord, var2.xCoord),
         Math.max(var1.yCoord, var2.yCoord),
         Math.max(var1.zCoord, var2.zCoord)
      );
   }

   private AxisAlignedBB Ձ(Block var1, BlockPos var2) {
      var1.setBlockBoundsBasedOnState(oc69da1aa7f5.ő.theWorld, var2);
      return var1.getSelectedBoundingBox(oc69da1aa7f5.ő.theWorld, var2);
   }

   private AxisAlignedBB ʜ(AxisAlignedBB param1, AxisAlignedBB param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 1
      // 01: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 04: aload 2
      // 05: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 08: invokestatic java/lang/Math.max (DD)D
      // 0b: dstore 4
      // 0d: aload 1
      // 0e: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 11: aload 2
      // 12: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 15: invokestatic java/lang/Math.max (DD)D
      // 18: dstore 6
      // 1a: aload 1
      // 1b: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 1e: aload 2
      // 1f: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 22: invokestatic java/lang/Math.max (DD)D
      // 25: dstore 8
      // 27: aload 1
      // 28: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 2b: aload 2
      // 2c: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 2f: invokestatic java/lang/Math.min (DD)D
      // 32: dstore 10
      // 34: getstatic x/oce6044968f8.ђ Z
      // 37: aload 1
      // 38: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 3b: aload 2
      // 3c: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 3f: invokestatic java/lang/Math.min (DD)D
      // 42: dstore 12
      // 44: aload 1
      // 45: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 48: aload 2
      // 49: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 4c: invokestatic java/lang/Math.min (DD)D
      // 4f: dstore 14
      // 51: istore 3
      // 52: dload 10
      // 54: dload 4
      // 56: iload 3
      // 57: ifne 7a
      // 5a: dsub
      // 5b: ldc2_w 1.0E-7
      // 5e: dcmpg
      // 5f: ifle 8e
      // 62: goto 66
      // 65: athrow
      // 66: dload 12
      // 68: dload 6
      // 6a: dsub
      // 6b: iload 3
      // 6c: ifne 87
      // 6f: goto 73
      // 72: athrow
      // 73: ldc2_w 1.0E-7
      // 76: goto 7a
      // 79: athrow
      // 7a: dcmpg
      // 7b: ifle 8e
      // 7e: dload 14
      // 80: dload 8
      // 82: dsub
      // 83: goto 87
      // 86: athrow
      // 87: ldc2_w 1.0E-7
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

   private ocdd27a3af4f ɚ(Vec3 param1, Vec3 param2, oc55a0d9ec35 param3) {
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
      // 003: invokevirtual x/oca1af5e72c7.Ί (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/AxisAlignedBB;
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
      // 02b: aload 5
      // 02d: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 030: dconst_1
      // 031: dadd
      // 032: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 035: istore 9
      // 037: aload 5
      // 039: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 03c: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 03f: istore 10
      // 041: istore 4
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
      // 076: new x/ocdd27a3af4f
      // 079: dup
      // 07a: aconst_null
      // 07b: ldc2_w 1.7976931348623157E308
      // 07e: invokespecial x/ocdd27a3af4f.<init> (Lnet/minecraft/util/MovingObjectPosition;D)V
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
      // 0c3: aload 13
      // 0c5: iload 17
      // 0c7: iload 18
      // 0c9: iload 19
      // 0cb: invokevirtual net/minecraft/util/BlockPos$MutableBlockPos.set (III)Lnet/minecraft/util/BlockPos$MutableBlockPos;
      // 0ce: pop
      // 0cf: iload 4
      // 0d1: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0d4: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 0d7: aload 13
      // 0d9: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 0dc: astore 20
      // 0de: ifne 1fd
      // 0e1: aload 20
      // 0e3: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 0e8: astore 21
      // 0ea: aload 3
      // 0eb: getfield x/oc55a0d9ec35.И Z
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
      // 130: aload 21
      // 132: aload 13
      // 134: invokevirtual x/oca1af5e72c7.Ձ (Lnet/minecraft/block/Block;Lnet/minecraft/util/BlockPos;)Lnet/minecraft/util/AxisAlignedBB;
      // 137: astore 22
      // 139: aload 21
      // 13b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 13e: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 141: aload 13
      // 143: aload 20
      // 145: aload 5
      // 147: aload 12
      // 149: aconst_null
      // 14a: invokevirtual net/minecraft/block/Block.addCollisionBoxesToList (Lnet/minecraft/world/World;Lnet/minecraft/util/BlockPos;Lnet/minecraft/block/state/IBlockState;Lnet/minecraft/util/AxisAlignedBB;Ljava/util/List;Lnet/minecraft/entity/Entity;)V
      // 14d: aload 12
      // 14f: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 154: astore 23
      // 156: aload 23
      // 158: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 15d: ifeq 1f2
      // 160: aload 23
      // 162: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 167: checkcast net/minecraft/util/AxisAlignedBB
      // 16a: astore 24
      // 16c: iload 4
      // 16e: ifne 1f5
      // 171: aload 0
      // 172: aload 24
      // 174: aload 22
      // 176: invokevirtual x/oca1af5e72c7.ʜ (Lnet/minecraft/util/AxisAlignedBB;Lnet/minecraft/util/AxisAlignedBB;)Lnet/minecraft/util/AxisAlignedBB;
      // 179: astore 25
      // 17b: aload 25
      // 17d: iload 4
      // 17f: ifne 194
      // 182: ifnonnull 192
      // 185: goto 189
      // 188: athrow
      // 189: iload 4
      // 18b: ifeq 156
      // 18e: goto 192
      // 191: athrow
      // 192: aload 25
      // 194: aload 1
      // 195: aload 2
      // 196: invokevirtual net/minecraft/util/AxisAlignedBB.calculateIntercept (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/MovingObjectPosition;
      // 199: astore 26
      // 19b: aload 26
      // 19d: ifnonnull 1a9
      // 1a0: iload 4
      // 1a2: ifeq 156
      // 1a5: goto 1a9
      // 1a8: athrow
      // 1a9: aload 1
      // 1aa: aload 26
      // 1ac: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 1af: invokevirtual net/minecraft/util/Vec3.squareDistanceTo (Lnet/minecraft/util/Vec3;)D
      // 1b2: dstore 27
      // 1b4: dload 27
      // 1b6: iload 4
      // 1b8: ifne 1cf
      // 1bb: ldc2_w 1.0E-7
      // 1be: dadd
      // 1bf: dload 15
      // 1c1: dcmpg
      // 1c2: ifge 1ed
      // 1c5: goto 1c9
      // 1c8: athrow
      // 1c9: dload 27
      // 1cb: goto 1cf
      // 1ce: athrow
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
      // 1ef: ifeq 156
      // 1f2: iinc 19 1
      // 1f5: iload 4
      // 1f7: ifeq 0bc
      // 1fa: iinc 18 1
      // 1fd: iload 4
      // 1ff: ifeq 0ac
      // 202: iinc 17 1
      // 205: iload 4
      // 207: ifeq 0a1
      // 20a: new x/ocdd27a3af4f
      // 20d: dup
      // 20e: aload 14
      // 210: dload 15
      // 212: invokespecial x/ocdd27a3af4f.<init> (Lnet/minecraft/util/MovingObjectPosition;D)V
      // 215: areturn
   }

   private ocdd27a3af4f N(Vec3 param1, Vec3 param2, oc55a0d9ec35 param3) {
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
      // 0d: getfield x/oc55a0d9ec35.И Z
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
      // 33: invokevirtual x/oca1af5e72c7.ɚ (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;Lx/oc55a0d9ec35;)Lx/ocdd27a3af4f;
      // 36: astore 8
      // 38: aload 8
      // 3a: iload 4
      // 3c: ifne 74
      // 3f: getfield x/ocdd27a3af4f.է Lnet/minecraft/util/MovingObjectPosition;
      // 42: ifnull 69
      // 45: goto 49
      // 48: athrow
      // 49: aload 8
      // 4b: iload 4
      // 4d: ifne 74
      // 50: goto 54
      // 53: athrow
      // 54: getfield x/ocdd27a3af4f.τ D
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
      // 69: new x/ocdd27a3af4f
      // 6c: dup
      // 6d: aload 5
      // 6f: dload 6
      // 71: invokespecial x/ocdd27a3af4f.<init> (Lnet/minecraft/util/MovingObjectPosition;D)V
      // 74: areturn
   }

   private List<double[]> Ȃ(List<double[]> param1, double param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: istore 4
      // 005: dload 2
      // 006: dconst_0
      // 007: dcmpg
      // 008: iload 4
      // 00a: ifne 027
      // 00d: ifle 031
      // 010: goto 014
      // 013: athrow
      // 014: aload 1
      // 015: iload 4
      // 017: ifne 036
      // 01a: goto 01e
      // 01d: athrow
      // 01e: invokeinterface java/util/List.size ()I 1
      // 023: goto 027
      // 026: athrow
      // 027: ldc_w -1186098650
      // 02a: ldc_w -1186098652
      // 02d: ixor
      // 02e: if_icmpge 037
      // 031: aload 1
      // 032: goto 036
      // 035: athrow
      // 036: areturn
      // 037: new java/util/ArrayList
      // 03a: dup
      // 03b: invokespecial java/util/ArrayList.<init> ()V
      // 03e: astore 5
      // 040: dload 2
      // 041: dstore 6
      // 043: aload 1
      // 044: bipush 0
      // 045: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 04a: checkcast [D
      // 04d: astore 8
      // 04f: bipush 1
      // 050: istore 9
      // 052: iload 9
      // 054: aload 1
      // 055: invokeinterface java/util/List.size ()I 1
      // 05a: if_icmpge 17c
      // 05d: aload 1
      // 05e: iload 9
      // 060: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 065: checkcast [D
      // 068: astore 10
      // 06a: aload 10
      // 06c: bipush 0
      // 06d: daload
      // 06e: aload 8
      // 070: bipush 0
      // 071: daload
      // 072: dsub
      // 073: dstore 11
      // 075: aload 10
      // 077: bipush 1
      // 078: daload
      // 079: aload 8
      // 07b: bipush 1
      // 07c: daload
      // 07d: dsub
      // 07e: dstore 13
      // 080: aload 10
      // 082: ldc_w -1186098650
      // 085: ldc_w -1186098652
      // 088: ixor
      // 089: daload
      // 08a: aload 8
      // 08c: ldc_w -1186098650
      // 08f: ldc_w -1186098652
      // 092: ixor
      // 093: daload
      // 094: dsub
      // 095: dstore 15
      // 097: dload 11
      // 099: dload 11
      // 09b: dmul
      // 09c: dload 13
      // 09e: dload 13
      // 0a0: dmul
      // 0a1: dadd
      // 0a2: dload 15
      // 0a4: dload 15
      // 0a6: dmul
      // 0a7: dadd
      // 0a8: invokestatic java/lang/Math.sqrt (D)D
      // 0ab: dstore 17
      // 0ad: dload 6
      // 0af: dconst_0
      // 0b0: dcmpl
      // 0b1: iload 4
      // 0b3: ifne 16f
      // 0b6: ifle 162
      // 0b9: goto 0bd
      // 0bc: athrow
      // 0bd: dload 17
      // 0bf: ldc2_w 1.0E-7
      // 0c2: iload 4
      // 0c4: ifne 0ed
      // 0c7: goto 0cb
      // 0ca: athrow
      // 0cb: dcmpg
      // 0cc: ifgt 0dc
      // 0cf: goto 0d3
      // 0d2: athrow
      // 0d3: aload 10
      // 0d5: astore 8
      // 0d7: iload 4
      // 0d9: ifeq 174
      // 0dc: dload 17
      // 0de: iload 4
      // 0e0: ifne 10a
      // 0e3: goto 0e7
      // 0e6: athrow
      // 0e7: dload 6
      // 0e9: goto 0ed
      // 0ec: athrow
      // 0ed: dcmpg
      // 0ee: ifgt 101
      // 0f1: dload 6
      // 0f3: dload 17
      // 0f5: dsub
      // 0f6: dstore 6
      // 0f8: iload 4
      // 0fa: aload 10
      // 0fc: astore 8
      // 0fe: ifeq 174
      // 101: dload 6
      // 103: dload 17
      // 105: ddiv
      // 106: goto 10a
      // 109: athrow
      // 10a: dstore 19
      // 10c: iload 4
      // 10e: aload 5
      // 110: ldc_w -1186098649
      // 113: ldc_w -1186098652
      // 116: ixor
      // 117: newarray 7
      // 119: dup
      // 11a: bipush 0
      // 11b: aload 8
      // 11d: bipush 0
      // 11e: daload
      // 11f: dload 11
      // 121: dload 19
      // 123: dmul
      // 124: dadd
      // 125: dastore
      // 126: dup
      // 127: bipush 1
      // 128: aload 8
      // 12a: bipush 1
      // 12b: daload
      // 12c: dload 13
      // 12e: dload 19
      // 130: dmul
      // 131: dadd
      // 132: dastore
      // 133: dup
      // 134: ldc_w -1186098650
      // 137: ldc_w -1186098652
      // 13a: ixor
      // 13b: aload 8
      // 13d: ldc_w -1186098650
      // 140: ldc_w -1186098652
      // 143: ixor
      // 144: daload
      // 145: dload 15
      // 147: dload 19
      // 149: dmul
      // 14a: dadd
      // 14b: dastore
      // 14c: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 151: pop
      // 152: aload 5
      // 154: aload 10
      // 156: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 15b: pop
      // 15c: dconst_0
      // 15d: dstore 6
      // 15f: ifeq 170
      // 162: aload 5
      // 164: aload 10
      // 166: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 16b: goto 16f
      // 16e: athrow
      // 16f: pop
      // 170: aload 10
      // 172: astore 8
      // 174: iinc 9 1
      // 177: iload 4
      // 179: ifeq 052
      // 17c: aload 5
      // 17e: areturn
   }

   private ItemStack ӣ(EntityPlayer param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: aload 1
      // 04: invokevirtual net/minecraft/entity/player/EntityPlayer.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 07: astore 3
      // 08: istore 2
      // 09: aload 3
      // 0a: iload 2
      // 0b: ifne 19
      // 0e: ifnonnull 18
      // 11: goto 15
      // 14: athrow
      // 15: aconst_null
      // 16: areturn
      // 17: athrow
      // 18: aload 3
      // 19: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 1c: astore 4
      // 1e: aload 4
      // 20: iload 2
      // 21: ifne 34
      // 24: getstatic net/minecraft/init/Items.ender_pearl Lnet/minecraft/item/Item;
      // 27: if_acmpeq 7e
      // 2a: goto 2e
      // 2d: athrow
      // 2e: aload 4
      // 30: goto 34
      // 33: athrow
      // 34: iload 2
      // 35: ifne 48
      // 38: getstatic net/minecraft/init/Items.snowball Lnet/minecraft/item/Item;
      // 3b: if_acmpeq 7e
      // 3e: goto 42
      // 41: athrow
      // 42: aload 4
      // 44: goto 48
      // 47: athrow
      // 48: iload 2
      // 49: ifne 5c
      // 4c: getstatic net/minecraft/init/Items.egg Lnet/minecraft/item/Item;
      // 4f: if_acmpeq 7e
      // 52: goto 56
      // 55: athrow
      // 56: aload 4
      // 58: goto 5c
      // 5b: athrow
      // 5c: iload 2
      // 5d: ifne 70
      // 60: getstatic net/minecraft/init/Items.experience_bottle Lnet/minecraft/item/Item;
      // 63: if_acmpeq 7e
      // 66: goto 6a
      // 69: athrow
      // 6a: aload 4
      // 6c: goto 70
      // 6f: athrow
      // 70: iload 2
      // 71: ifne 83
      // 74: getstatic net/minecraft/init/Items.fire_charge Lnet/minecraft/item/Item;
      // 77: if_acmpne 81
      // 7a: goto 7e
      // 7d: athrow
      // 7e: aload 3
      // 7f: areturn
      // 80: athrow
      // 81: aload 4
      // 83: iload 2
      // 84: ifne b1
      // 87: getstatic net/minecraft/init/Items.potionitem Lnet/minecraft/item/ItemPotion;
      // 8a: if_acmpne af
      // 8d: goto 91
      // 90: athrow
      // 91: aload 3
      // 92: iload 2
      // 93: ifne ac
      // 96: goto 9a
      // 99: athrow
      // 9a: invokevirtual net/minecraft/item/ItemStack.getMetadata ()I
      // 9d: invokestatic net/minecraft/item/ItemPotion.isSplash (I)Z
      // a0: ifeq ad
      // a3: goto a7
      // a6: athrow
      // a7: aload 3
      // a8: goto ac
      // ab: athrow
      // ac: areturn
      // ad: aconst_null
      // ae: areturn
      // af: aload 4
      // b1: iload 2
      // b2: ifne c4
      // b5: instanceof net/minecraft/item/ItemBow
      // b8: ifeq c2
      // bb: goto bf
      // be: athrow
      // bf: aload 3
      // c0: areturn
      // c1: athrow
      // c2: aload 4
      // c4: getstatic net/minecraft/init/Items.fishing_rod Lnet/minecraft/item/ItemFishingRod;
      // c7: if_acmpne cd
      // ca: aload 3
      // cb: areturn
      // cc: athrow
      // cd: aconst_null
      // ce: areturn
   }

   @oc66fa4f2195
   public void ϥ(oc746a23b244 param1) {
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
      // 007: ifeq 01f
      // 00a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 00d: iload 2
      // 00e: ifne 024
      // 011: goto 015
      // 014: athrow
      // 015: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 018: ifnonnull 021
      // 01b: goto 01f
      // 01e: athrow
      // 01f: return
      // 020: athrow
      // 021: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 024: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 027: astore 3
      // 028: aload 1
      // 029: getfield x/oc746a23b244.Ё F
      // 02c: fstore 4
      // 02e: aload 0
      // 02f: aload 3
      // 030: invokevirtual x/oca1af5e72c7.ӣ (Lnet/minecraft/entity/player/EntityPlayer;)Lnet/minecraft/item/ItemStack;
      // 033: astore 5
      // 035: aload 0
      // 036: getfield x/oca1af5e72c7.Ƃ Lx/occ2f8dff8d8;
      // 039: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 03c: ifeq 051
      // 03f: aload 5
      // 041: iload 2
      // 042: ifne 053
      // 045: goto 049
      // 048: athrow
      // 049: ifnonnull 051
      // 04c: goto 050
      // 04f: athrow
      // 050: return
      // 051: aload 5
      // 053: iload 2
      // 054: ifne 061
      // 057: ifnonnull 05f
      // 05a: goto 05e
      // 05d: athrow
      // 05e: return
      // 05f: aload 5
      // 061: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 064: astore 6
      // 066: aload 6
      // 068: getstatic net/minecraft/init/Items.fire_charge Lnet/minecraft/item/Item;
      // 06b: if_acmpne 090
      // 06e: aload 0
      // 06f: iload 2
      // 070: ifne 089
      // 073: goto 077
      // 076: athrow
      // 077: getfield x/oca1af5e72c7.ы Lx/occ2f8dff8d8;
      // 07a: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 07d: ifeq 08f
      // 080: goto 084
      // 083: athrow
      // 084: aload 0
      // 085: goto 089
      // 088: athrow
      // 089: aload 3
      // 08a: fload 4
      // 08c: invokevirtual x/oca1af5e72c7.ц (Lnet/minecraft/entity/player/EntityPlayer;F)V
      // 08f: return
      // 090: aload 0
      // 091: aload 6
      // 093: aload 3
      // 094: fload 4
      // 096: invokevirtual x/oca1af5e72c7.Ҟ (Lnet/minecraft/item/Item;Lnet/minecraft/entity/player/EntityPlayer;F)Lx/oc55a0d9ec35;
      // 099: astore 7
      // 09b: aload 7
      // 09d: iload 2
      // 09e: ifne 0ab
      // 0a1: ifnonnull 0a9
      // 0a4: goto 0a8
      // 0a7: athrow
      // 0a8: return
      // 0a9: aload 7
      // 0ab: getfield x/oc55a0d9ec35.ć D
      // 0ae: dstore 8
      // 0b0: aload 6
      // 0b2: iload 2
      // 0b3: ifne 0e7
      // 0b6: getstatic net/minecraft/init/Items.snowball Lnet/minecraft/item/Item;
      // 0b9: if_acmpne 0e5
      // 0bc: goto 0c0
      // 0bf: athrow
      // 0c0: aload 0
      // 0c1: iload 2
      // 0c2: ifne 0d8
      // 0c5: goto 0c9
      // 0c8: athrow
      // 0c9: invokevirtual x/oca1af5e72c7.Ƀ ()Z
      // 0cc: ifeq 0e5
      // 0cf: goto 0d3
      // 0d2: athrow
      // 0d3: aload 0
      // 0d4: goto 0d8
      // 0d7: athrow
      // 0d8: aload 5
      // 0da: invokevirtual x/oca1af5e72c7.Ї (Lnet/minecraft/item/ItemStack;)Z
      // 0dd: ifeq 0e5
      // 0e0: ldc2_w 1.75
      // 0e3: dstore 8
      // 0e5: aload 6
      // 0e7: getstatic net/minecraft/init/Items.bow Lnet/minecraft/item/ItemBow;
      // 0ea: if_acmpne 12c
      // 0ed: aload 0
      // 0ee: getfield x/oca1af5e72c7.Ӷ Lx/occ2f8dff8d8;
      // 0f1: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0f4: iload 2
      // 0f5: ifne 10b
      // 0f8: goto 0fc
      // 0fb: athrow
      // 0fc: ifeq 12c
      // 0ff: goto 103
      // 102: athrow
      // 103: aload 3
      // 104: invokevirtual net/minecraft/entity/player/EntityPlayer.isUsingItem ()Z
      // 107: goto 10b
      // 10a: athrow
      // 10b: iload 2
      // 10c: ifne 128
      // 10f: ifeq 12b
      // 112: goto 116
      // 115: athrow
      // 116: dload 8
      // 118: iload 2
      // 119: ifne 134
      // 11c: goto 120
      // 11f: athrow
      // 120: ldc2_w 0.1
      // 123: dcmpg
      // 124: goto 128
      // 127: athrow
      // 128: ifge 12c
      // 12b: return
      // 12c: aload 3
      // 12d: getfield net/minecraft/entity/player/EntityPlayer.rotationYaw F
      // 130: f2d
      // 131: invokestatic java/lang/Math.toRadians (D)D
      // 134: d2f
      // 135: fstore 10
      // 137: aload 3
      // 138: getfield net/minecraft/entity/player/EntityPlayer.rotationPitch F
      // 13b: f2d
      // 13c: invokestatic java/lang/Math.toRadians (D)D
      // 13f: d2f
      // 140: fstore 11
      // 142: aload 3
      // 143: getfield net/minecraft/entity/player/EntityPlayer.lastTickPosX D
      // 146: aload 3
      // 147: getfield net/minecraft/entity/player/EntityPlayer.posX D
      // 14a: aload 3
      // 14b: getfield net/minecraft/entity/player/EntityPlayer.lastTickPosX D
      // 14e: dsub
      // 14f: fload 4
      // 151: f2d
      // 152: dmul
      // 153: dadd
      // 154: fload 10
      // 156: invokestatic net/minecraft/util/MathHelper.cos (F)F
      // 159: ldc_w 0.16
      // 15c: fmul
      // 15d: f2d
      // 15e: dsub
      // 15f: dstore 12
      // 161: aload 3
      // 162: getfield net/minecraft/entity/player/EntityPlayer.lastTickPosY D
      // 165: aload 3
      // 166: getfield net/minecraft/entity/player/EntityPlayer.posY D
      // 169: aload 3
      // 16a: getfield net/minecraft/entity/player/EntityPlayer.lastTickPosY D
      // 16d: dsub
      // 16e: fload 4
      // 170: f2d
      // 171: dmul
      // 172: dadd
      // 173: aload 3
      // 174: invokevirtual net/minecraft/entity/player/EntityPlayer.getEyeHeight ()F
      // 177: f2d
      // 178: dadd
      // 179: ldc2_w 0.1
      // 17c: dsub
      // 17d: dstore 14
      // 17f: aload 3
      // 180: getfield net/minecraft/entity/player/EntityPlayer.lastTickPosZ D
      // 183: aload 3
      // 184: getfield net/minecraft/entity/player/EntityPlayer.posZ D
      // 187: aload 3
      // 188: getfield net/minecraft/entity/player/EntityPlayer.lastTickPosZ D
      // 18b: dsub
      // 18c: fload 4
      // 18e: f2d
      // 18f: dmul
      // 190: dadd
      // 191: fload 10
      // 193: invokestatic net/minecraft/util/MathHelper.sin (F)F
      // 196: ldc_w 0.16
      // 199: fmul
      // 19a: f2d
      // 19b: dsub
      // 19c: dstore 16
      // 19e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1a1: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 1a4: getfield net/minecraft/client/settings/GameSettings.thirdPersonView I
      // 1a7: ifne 1b1
      // 1aa: ldc2_w 0.5
      // 1ad: goto 1b2
      // 1b0: athrow
      // 1b1: dconst_0
      // 1b2: dstore 18
      // 1b4: fload 10
      // 1b6: invokestatic net/minecraft/util/MathHelper.sin (F)F
      // 1b9: fneg
      // 1ba: fload 11
      // 1bc: invokestatic net/minecraft/util/MathHelper.cos (F)F
      // 1bf: fmul
      // 1c0: f2d
      // 1c1: dstore 20
      // 1c3: fload 11
      // 1c5: invokestatic net/minecraft/util/MathHelper.sin (F)F
      // 1c8: fneg
      // 1c9: f2d
      // 1ca: dstore 22
      // 1cc: fload 10
      // 1ce: invokestatic net/minecraft/util/MathHelper.cos (F)F
      // 1d1: fload 11
      // 1d3: invokestatic net/minecraft/util/MathHelper.cos (F)F
      // 1d6: fmul
      // 1d7: f2d
      // 1d8: dstore 24
      // 1da: dload 20
      // 1dc: dload 20
      // 1de: dmul
      // 1df: dload 22
      // 1e1: dload 22
      // 1e3: dmul
      // 1e4: dadd
      // 1e5: dload 24
      // 1e7: dload 24
      // 1e9: dmul
      // 1ea: dadd
      // 1eb: invokestatic java/lang/Math.sqrt (D)D
      // 1ee: dstore 26
      // 1f0: dload 20
      // 1f2: dload 26
      // 1f4: ddiv
      // 1f5: dstore 20
      // 1f7: dload 22
      // 1f9: dload 26
      // 1fb: ddiv
      // 1fc: dstore 22
      // 1fe: dload 24
      // 200: dload 26
      // 202: ddiv
      // 203: dstore 24
      // 205: dload 20
      // 207: dload 8
      // 209: dmul
      // 20a: dstore 20
      // 20c: dload 22
      // 20e: dload 8
      // 210: dmul
      // 211: dstore 22
      // 213: dload 24
      // 215: dload 8
      // 217: dmul
      // 218: dstore 24
      // 21a: aload 0
      // 21b: getfield x/oca1af5e72c7.Ǩ Lx/occ2f8dff8d8;
      // 21e: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 221: iload 2
      // 222: ifne 262
      // 225: ifeq 25b
      // 228: goto 22c
      // 22b: athrow
      // 22c: dload 20
      // 22e: aload 3
      // 22f: iload 2
      // 230: ifne 24c
      // 233: goto 237
      // 236: athrow
      // 237: getfield net/minecraft/entity/player/EntityPlayer.motionX D
      // 23a: dadd
      // 23b: dstore 20
      // 23d: dload 22
      // 23f: aload 3
      // 240: getfield net/minecraft/entity/player/EntityPlayer.onGround Z
      // 243: ifeq 24b
      // 246: dconst_0
      // 247: goto 24f
      // 24a: athrow
      // 24b: aload 3
      // 24c: getfield net/minecraft/entity/player/EntityPlayer.motionY D
      // 24f: dadd
      // 250: dstore 22
      // 252: dload 24
      // 254: aload 3
      // 255: getfield net/minecraft/entity/player/EntityPlayer.motionZ D
      // 258: dadd
      // 259: dstore 24
      // 25b: ldc_w 267415641
      // 25e: ldc_w 267415642
      // 261: ixor
      // 262: newarray 7
      // 264: dup
      // 265: bipush 0
      // 266: dload 20
      // 268: dastore
      // 269: dup
      // 26a: bipush 1
      // 26b: dload 22
      // 26d: dastore
      // 26e: dup
      // 26f: ldc_w 267415640
      // 272: ldc_w 267415642
      // 275: ixor
      // 276: dload 24
      // 278: dastore
      // 279: astore 28
      // 27b: aload 7
      // 27d: getfield x/oc55a0d9ec35.ր Z
      // 280: ifeq 2bb
      // 283: aload 0
      // 284: dload 12
      // 286: dload 14
      // 288: dload 16
      // 28a: aload 7
      // 28c: invokevirtual x/oca1af5e72c7.Ξ (DDDLx/oc55a0d9ec35;)Lx/C;
      // 28f: astore 29
      // 291: aload 0
      // 292: aload 29
      // 294: aload 28
      // 296: invokevirtual x/oca1af5e72c7.Ё (Lx/C;[D)V
      // 299: aload 0
      // 29a: aload 7
      // 29c: aload 29
      // 29e: aload 28
      // 2a0: invokevirtual x/oca1af5e72c7.Ů (Lx/oc55a0d9ec35;Lx/C;[D)V
      // 2a3: aload 28
      // 2a5: bipush 0
      // 2a6: daload
      // 2a7: dstore 20
      // 2a9: aload 28
      // 2ab: bipush 1
      // 2ac: daload
      // 2ad: dstore 22
      // 2af: aload 28
      // 2b1: ldc_w 267415640
      // 2b4: ldc_w 267415642
      // 2b7: ixor
      // 2b8: daload
      // 2b9: dstore 24
      // 2bb: new java/util/ArrayList
      // 2be: dup
      // 2bf: invokespecial java/util/ArrayList.<init> ()V
      // 2c2: astore 29
      // 2c4: aconst_null
      // 2c5: astore 30
      // 2c7: aconst_null
      // 2c8: astore 31
      // 2ca: aconst_null
      // 2cb: astore 32
      // 2cd: bipush 0
      // 2ce: istore 33
      // 2d0: aconst_null
      // 2d1: astore 34
      // 2d3: aconst_null
      // 2d4: astore 35
      // 2d6: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 2d9: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 2dc: astore 36
      // 2de: aload 0
      // 2df: getfield x/oca1af5e72c7.Ϗ Lx/oca9cc61aada;
      // 2e2: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 2e5: d2i
      // 2e6: istore 37
      // 2e8: ldc_w 267415646
      // 2eb: ldc_w 267415642
      // 2ee: ixor
      // 2ef: istore 38
      // 2f1: aload 7
      // 2f3: getfield x/oc55a0d9ec35.ƍ D
      // 2f6: dstore 39
      // 2f8: bipush 0
      // 2f9: istore 41
      // 2fb: iload 41
      // 2fd: iload 37
      // 2ff: if_icmpge 877
      // 302: aload 0
      // 303: dload 12
      // 305: dload 14
      // 307: dload 16
      // 309: aload 7
      // 30b: invokevirtual x/oca1af5e72c7.Ξ (DDDLx/oc55a0d9ec35;)Lx/C;
      // 30e: astore 42
      // 310: aload 28
      // 312: bipush 0
      // 313: dload 20
      // 315: dastore
      // 316: aload 28
      // 318: bipush 1
      // 319: dload 22
      // 31b: dastore
      // 31c: aload 28
      // 31e: ldc_w 267415640
      // 321: ldc_w 267415642
      // 324: ixor
      // 325: dload 24
      // 327: dastore
      // 328: aload 0
      // 329: aload 42
      // 32b: aload 28
      // 32d: invokevirtual x/oca1af5e72c7.Ё (Lx/C;[D)V
      // 330: aload 28
      // 332: bipush 0
      // 333: daload
      // 334: dstore 20
      // 336: aload 28
      // 338: bipush 1
      // 339: daload
      // 33a: dstore 22
      // 33c: aload 28
      // 33e: ldc_w 267415640
      // 341: ldc_w 267415642
      // 344: ixor
      // 345: daload
      // 346: dstore 24
      // 348: dload 12
      // 34a: dload 20
      // 34c: dadd
      // 34d: dstore 43
      // 34f: dload 14
      // 351: dload 22
      // 353: dadd
      // 354: dstore 45
      // 356: dload 16
      // 358: dload 24
      // 35a: dadd
      // 35b: dstore 47
      // 35d: new net/minecraft/util/Vec3
      // 360: dup
      // 361: dload 12
      // 363: dload 14
      // 365: dload 16
      // 367: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 36a: astore 49
      // 36c: new net/minecraft/util/Vec3
      // 36f: dup
      // 370: dload 43
      // 372: dload 45
      // 374: dload 47
      // 376: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 379: astore 50
      // 37b: aload 0
      // 37c: aload 49
      // 37e: aload 50
      // 380: aload 7
      // 382: invokevirtual x/oca1af5e72c7.N (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;Lx/oc55a0d9ec35;)Lx/ocdd27a3af4f;
      // 385: astore 51
      // 387: aload 51
      // 389: getfield x/ocdd27a3af4f.է Lnet/minecraft/util/MovingObjectPosition;
      // 38c: astore 52
      // 38e: aload 51
      // 390: getfield x/ocdd27a3af4f.τ D
      // 393: dstore 53
      // 395: aload 52
      // 397: ifnull 3bd
      // 39a: new net/minecraft/util/Vec3
      // 39d: dup
      // 39e: aload 52
      // 3a0: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 3a3: getfield net/minecraft/util/Vec3.xCoord D
      // 3a6: aload 52
      // 3a8: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 3ab: getfield net/minecraft/util/Vec3.yCoord D
      // 3ae: aload 52
      // 3b0: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 3b3: getfield net/minecraft/util/Vec3.zCoord D
      // 3b6: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 3b9: goto 3bf
      // 3bc: athrow
      // 3bd: aload 50
      // 3bf: astore 55
      // 3c1: new net/minecraft/util/AxisAlignedBB
      // 3c4: dup
      // 3c5: dload 12
      // 3c7: dload 39
      // 3c9: dsub
      // 3ca: dload 14
      // 3cc: dload 39
      // 3ce: dsub
      // 3cf: dload 16
      // 3d1: dload 39
      // 3d3: dsub
      // 3d4: dload 12
      // 3d6: dload 39
      // 3d8: dadd
      // 3d9: dload 14
      // 3db: dload 39
      // 3dd: dadd
      // 3de: dload 16
      // 3e0: dload 39
      // 3e2: dadd
      // 3e3: invokespecial net/minecraft/util/AxisAlignedBB.<init> (DDDDDD)V
      // 3e6: dload 20
      // 3e8: dload 22
      // 3ea: dload 24
      // 3ec: invokevirtual net/minecraft/util/AxisAlignedBB.addCoord (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 3ef: dconst_1
      // 3f0: dconst_1
      // 3f1: dconst_1
      // 3f2: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 3f5: astore 56
      // 3f7: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 3fa: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 3fd: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 400: invokevirtual net/minecraft/client/Minecraft.getRenderViewEntity ()Lnet/minecraft/entity/Entity;
      // 403: aload 56
      // 405: invokevirtual net/minecraft/client/multiplayer/WorldClient.getEntitiesWithinAABBExcludingEntity (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/AxisAlignedBB;)Ljava/util/List;
      // 408: astore 57
      // 40a: aconst_null
      // 40b: astore 58
      // 40d: aconst_null
      // 40e: astore 59
      // 410: aconst_null
      // 411: astore 60
      // 413: dload 53
      // 415: dstore 61
      // 417: aload 57
      // 419: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 41e: astore 63
      // 420: aload 63
      // 422: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 427: ifeq 517
      // 42a: aload 63
      // 42c: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 431: checkcast net/minecraft/entity/Entity
      // 434: astore 64
      // 436: iload 2
      // 437: ifne 60f
      // 43a: aload 64
      // 43c: iload 2
      // 43d: ifne 454
      // 440: goto 444
      // 443: athrow
      // 444: instanceof net/minecraft/entity/EntityLivingBase
      // 447: ifne 452
      // 44a: goto 44e
      // 44d: athrow
      // 44e: goto 420
      // 451: athrow
      // 452: aload 64
      // 454: iload 2
      // 455: ifne 468
      // 458: instanceof net/minecraft/entity/item/EntityArmorStand
      // 45b: ifeq 466
      // 45e: goto 462
      // 461: athrow
      // 462: goto 420
      // 465: athrow
      // 466: aload 64
      // 468: iload 2
      // 469: ifne 47c
      // 46c: invokevirtual net/minecraft/entity/Entity.canBeCollidedWith ()Z
      // 46f: ifne 47a
      // 472: goto 476
      // 475: athrow
      // 476: goto 420
      // 479: athrow
      // 47a: aload 64
      // 47c: checkcast net/minecraft/entity/EntityLivingBase
      // 47f: iload 2
      // 480: ifne 493
      // 483: getfield net/minecraft/entity/EntityLivingBase.deathTime I
      // 486: ifeq 491
      // 489: goto 48d
      // 48c: athrow
      // 48d: goto 420
      // 490: athrow
      // 491: aload 64
      // 493: iload 2
      // 494: ifne 4bb
      // 497: instanceof net/minecraft/entity/player/EntityPlayer
      // 49a: ifeq 4b9
      // 49d: goto 4a1
      // 4a0: athrow
      // 4a1: aload 64
      // 4a3: iload 2
      // 4a4: ifne 4bb
      // 4a7: goto 4ab
      // 4aa: athrow
      // 4ab: invokestatic x/oca4f99d2d44.Λ (Lnet/minecraft/entity/Entity;)Z
      // 4ae: ifeq 4b9
      // 4b1: goto 4b5
      // 4b4: athrow
      // 4b5: goto 420
      // 4b8: athrow
      // 4b9: aload 64
      // 4bb: invokevirtual net/minecraft/entity/Entity.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 4be: astore 65
      // 4c0: aload 0
      // 4c1: aload 65
      // 4c3: invokevirtual x/oca1af5e72c7.ʥ (Lnet/minecraft/util/AxisAlignedBB;)Lnet/minecraft/util/AxisAlignedBB;
      // 4c6: astore 66
      // 4c8: aload 66
      // 4ca: aload 49
      // 4cc: aload 55
      // 4ce: invokevirtual net/minecraft/util/AxisAlignedBB.calculateIntercept (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/MovingObjectPosition;
      // 4d1: astore 67
      // 4d3: aload 67
      // 4d5: ifnonnull 4dc
      // 4d8: goto 420
      // 4db: athrow
      // 4dc: aload 49
      // 4de: aload 67
      // 4e0: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 4e3: invokevirtual net/minecraft/util/Vec3.squareDistanceTo (Lnet/minecraft/util/Vec3;)D
      // 4e6: dstore 68
      // 4e8: dload 68
      // 4ea: iload 2
      // 4eb: ifne 502
      // 4ee: ldc2_w 1.0E-7
      // 4f1: dadd
      // 4f2: dload 61
      // 4f4: dcmpg
      // 4f5: ifge 513
      // 4f8: goto 4fc
      // 4fb: athrow
      // 4fc: dload 68
      // 4fe: goto 502
      // 501: athrow
      // 502: dstore 61
      // 504: aload 64
      // 506: astore 58
      // 508: aload 67
      // 50a: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 50d: astore 59
      // 50f: aload 66
      // 511: astore 60
      // 513: iload 2
      // 514: ifeq 420
      // 517: aload 58
      // 519: ifnull 60f
      // 51c: dload 61
      // 51e: invokestatic java/lang/Math.sqrt (D)D
      // 521: dload 20
      // 523: dload 20
      // 525: dmul
      // 526: dload 22
      // 528: dload 22
      // 52a: dmul
      // 52b: dadd
      // 52c: dload 24
      // 52e: dload 24
      // 530: dmul
      // 531: dadd
      // 532: invokestatic java/lang/Math.sqrt (D)D
      // 535: ddiv
      // 536: dstore 63
      // 538: dconst_0
      // 539: dconst_1
      // 53a: dload 63
      // 53c: invokestatic java/lang/Math.min (DD)D
      // 53f: invokestatic java/lang/Math.max (DD)D
      // 542: dstore 63
      // 544: dload 63
      // 546: ldc2_w 4.0
      // 549: dmul
      // 54a: invokestatic java/lang/Math.ceil (D)D
      // 54d: d2i
      // 54e: istore 65
      // 550: bipush 0
      // 551: istore 66
      // 553: iload 66
      // 555: iload 65
      // 557: if_icmpge 5bc
      // 55a: iload 66
      // 55c: i2d
      // 55d: ldc2_w 4.0
      // 560: ddiv
      // 561: dstore 67
      // 563: aload 29
      // 565: ldc_w 267415641
      // 568: ldc_w 267415642
      // 56b: ixor
      // 56c: newarray 7
      // 56e: dup
      // 56f: bipush 0
      // 570: dload 12
      // 572: dload 20
      // 574: dload 67
      // 576: dmul
      // 577: dadd
      // 578: iload 2
      // 579: ifne 5f6
      // 57c: aload 36
      // 57e: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosX D
      // 581: dsub
      // 582: dastore
      // 583: dup
      // 584: bipush 1
      // 585: dload 14
      // 587: dload 22
      // 589: dload 67
      // 58b: dmul
      // 58c: dadd
      // 58d: aload 36
      // 58f: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosY D
      // 592: dsub
      // 593: dastore
      // 594: dup
      // 595: ldc_w 267415640
      // 598: ldc_w 267415642
      // 59b: ixor
      // 59c: dload 16
      // 59e: dload 24
      // 5a0: dload 67
      // 5a2: dmul
      // 5a3: dadd
      // 5a4: aload 36
      // 5a6: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosZ D
      // 5a9: dsub
      // 5aa: dastore
      // 5ab: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 5b0: pop
      // 5b1: iload 2
      // 5b2: iinc 66 1
      // 5b5: ifeq 553
      // 5b8: goto 5bc
      // 5bb: athrow
      // 5bc: aload 29
      // 5be: ldc_w 267415641
      // 5c1: ldc_w 267415642
      // 5c4: ixor
      // 5c5: newarray 7
      // 5c7: dup
      // 5c8: bipush 0
      // 5c9: aload 59
      // 5cb: getfield net/minecraft/util/Vec3.xCoord D
      // 5ce: aload 36
      // 5d0: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosX D
      // 5d3: dsub
      // 5d4: dastore
      // 5d5: dup
      // 5d6: bipush 1
      // 5d7: aload 59
      // 5d9: getfield net/minecraft/util/Vec3.yCoord D
      // 5dc: aload 36
      // 5de: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosY D
      // 5e1: dsub
      // 5e2: dastore
      // 5e3: dup
      // 5e4: ldc_w 267415640
      // 5e7: ldc_w 267415642
      // 5ea: ixor
      // 5eb: aload 59
      // 5ed: getfield net/minecraft/util/Vec3.zCoord D
      // 5f0: aload 36
      // 5f2: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosZ D
      // 5f5: dsub
      // 5f6: dastore
      // 5f7: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 5fc: pop
      // 5fd: aload 58
      // 5ff: astore 31
      // 601: aload 60
      // 603: astore 32
      // 605: bipush 1
      // 606: istore 33
      // 608: aload 59
      // 60a: astore 34
      // 60c: goto 877
      // 60f: aload 52
      // 611: iload 2
      // 612: ifne 61e
      // 615: ifnull 794
      // 618: goto 61c
      // 61b: athrow
      // 61c: aload 52
      // 61e: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 621: astore 63
      // 623: aload 52
      // 625: getfield net/minecraft/util/MovingObjectPosition.sideHit Lnet/minecraft/util/EnumFacing;
      // 628: invokevirtual net/minecraft/util/EnumFacing.getIndex ()I
      // 62b: istore 64
      // 62d: iload 64
      // 62f: iload 2
      // 630: ifne 657
      // 633: ifeq 64c
      // 636: goto 63a
      // 639: athrow
      // 63a: iload 64
      // 63c: iload 2
      // 63d: ifne 657
      // 640: goto 644
      // 643: athrow
      // 644: bipush 1
      // 645: if_icmpne 65a
      // 648: goto 64c
      // 64b: athrow
      // 64c: ldc_w 267415641
      // 64f: ldc_w 267415642
      // 652: ixor
      // 653: goto 657
      // 656: athrow
      // 657: goto 661
      // 65a: ldc_w 267415640
      // 65d: ldc_w 267415642
      // 660: ixor
      // 661: istore 33
      // 663: aload 63
      // 665: astore 34
      // 667: dload 20
      // 669: dload 20
      // 66b: dmul
      // 66c: dload 22
      // 66e: dload 22
      // 670: dmul
      // 671: dadd
      // 672: dload 24
      // 674: dload 24
      // 676: dmul
      // 677: dadd
      // 678: dstore 65
      // 67a: aload 63
      // 67c: getfield net/minecraft/util/Vec3.xCoord D
      // 67f: dload 12
      // 681: dsub
      // 682: dstore 67
      // 684: aload 63
      // 686: getfield net/minecraft/util/Vec3.yCoord D
      // 689: dload 14
      // 68b: dsub
      // 68c: dstore 69
      // 68e: aload 63
      // 690: getfield net/minecraft/util/Vec3.zCoord D
      // 693: dload 16
      // 695: dsub
      // 696: dstore 71
      // 698: dload 65
      // 69a: iload 2
      // 69b: ifne 6c2
      // 69e: dconst_0
      // 69f: dcmpl
      // 6a0: ifle 6c5
      // 6a3: goto 6a7
      // 6a6: athrow
      // 6a7: dload 67
      // 6a9: dload 67
      // 6ab: dmul
      // 6ac: dload 69
      // 6ae: dload 69
      // 6b0: dmul
      // 6b1: dadd
      // 6b2: dload 71
      // 6b4: dload 71
      // 6b6: dmul
      // 6b7: dadd
      // 6b8: dload 65
      // 6ba: ddiv
      // 6bb: invokestatic java/lang/Math.sqrt (D)D
      // 6be: goto 6c2
      // 6c1: athrow
      // 6c2: goto 6c6
      // 6c5: dconst_0
      // 6c6: dstore 73
      // 6c8: dconst_0
      // 6c9: dconst_1
      // 6ca: dload 73
      // 6cc: invokestatic java/lang/Math.min (DD)D
      // 6cf: invokestatic java/lang/Math.max (DD)D
      // 6d2: dstore 73
      // 6d4: dload 73
      // 6d6: ldc2_w 4.0
      // 6d9: dmul
      // 6da: invokestatic java/lang/Math.ceil (D)D
      // 6dd: d2i
      // 6de: istore 75
      // 6e0: bipush 0
      // 6e1: istore 76
      // 6e3: iload 76
      // 6e5: iload 75
      // 6e7: if_icmpge 74c
      // 6ea: iload 76
      // 6ec: i2d
      // 6ed: ldc2_w 4.0
      // 6f0: ddiv
      // 6f1: dstore 77
      // 6f3: aload 29
      // 6f5: ldc_w 267415641
      // 6f8: ldc_w 267415642
      // 6fb: ixor
      // 6fc: newarray 7
      // 6fe: dup
      // 6ff: bipush 0
      // 700: dload 12
      // 702: dload 20
      // 704: dload 77
      // 706: dmul
      // 707: dadd
      // 708: aload 36
      // 70a: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosX D
      // 70d: dsub
      // 70e: dastore
      // 70f: dup
      // 710: iload 2
      // 711: ifne 774
      // 714: bipush 1
      // 715: dload 14
      // 717: dload 22
      // 719: dload 77
      // 71b: dmul
      // 71c: dadd
      // 71d: aload 36
      // 71f: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosY D
      // 722: dsub
      // 723: dastore
      // 724: dup
      // 725: ldc_w 267415640
      // 728: ldc_w 267415642
      // 72b: ixor
      // 72c: dload 16
      // 72e: dload 24
      // 730: dload 77
      // 732: dmul
      // 733: dadd
      // 734: aload 36
      // 736: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosZ D
      // 739: dsub
      // 73a: dastore
      // 73b: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 740: pop
      // 741: iload 2
      // 742: iinc 76 1
      // 745: ifeq 6e3
      // 748: goto 74c
      // 74b: athrow
      // 74c: aload 29
      // 74e: ldc_w 267415641
      // 751: ldc_w 267415642
      // 754: ixor
      // 755: newarray 7
      // 757: dup
      // 758: bipush 0
      // 759: aload 63
      // 75b: getfield net/minecraft/util/Vec3.xCoord D
      // 75e: aload 36
      // 760: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosX D
      // 763: dsub
      // 764: dastore
      // 765: dup
      // 766: bipush 1
      // 767: aload 63
      // 769: getfield net/minecraft/util/Vec3.yCoord D
      // 76c: aload 36
      // 76e: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosY D
      // 771: dsub
      // 772: dastore
      // 773: dup
      // 774: ldc_w 267415640
      // 777: ldc_w 267415642
      // 77a: ixor
      // 77b: aload 63
      // 77d: getfield net/minecraft/util/Vec3.zCoord D
      // 780: aload 36
      // 782: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosZ D
      // 785: dsub
      // 786: dastore
      // 787: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 78c: pop
      // 78d: aload 52
      // 78f: astore 30
      // 791: goto 877
      // 794: bipush 0
      // 795: istore 63
      // 797: iload 63
      // 799: ldc_w 267415646
      // 79c: ldc_w 267415642
      // 79f: ixor
      // 7a0: if_icmpge 805
      // 7a3: iload 63
      // 7a5: i2d
      // 7a6: ldc2_w 4.0
      // 7a9: ddiv
      // 7aa: dstore 64
      // 7ac: iload 2
      // 7ad: ifne 864
      // 7b0: aload 29
      // 7b2: ldc_w 267415641
      // 7b5: ldc_w 267415642
      // 7b8: ixor
      // 7b9: newarray 7
      // 7bb: dup
      // 7bc: bipush 0
      // 7bd: dload 12
      // 7bf: dload 20
      // 7c1: dload 64
      // 7c3: dmul
      // 7c4: dadd
      // 7c5: aload 36
      // 7c7: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosX D
      // 7ca: dsub
      // 7cb: dastore
      // 7cc: dup
      // 7cd: bipush 1
      // 7ce: dload 14
      // 7d0: dload 22
      // 7d2: dload 64
      // 7d4: dmul
      // 7d5: dadd
      // 7d6: aload 36
      // 7d8: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosY D
      // 7db: dsub
      // 7dc: dastore
      // 7dd: dup
      // 7de: ldc_w 267415640
      // 7e1: ldc_w 267415642
      // 7e4: ixor
      // 7e5: dload 16
      // 7e7: dload 24
      // 7e9: dload 64
      // 7eb: dmul
      // 7ec: dadd
      // 7ed: aload 36
      // 7ef: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosZ D
      // 7f2: dsub
      // 7f3: dastore
      // 7f4: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 7f9: pop
      // 7fa: iload 2
      // 7fb: iinc 63 1
      // 7fe: ifeq 797
      // 801: goto 805
      // 804: athrow
      // 805: dload 43
      // 807: dstore 12
      // 809: iload 2
      // 80a: dload 45
      // 80c: dstore 14
      // 80e: dload 47
      // 810: dstore 16
      // 812: ifne 874
      // 815: new net/minecraft/util/Vec3
      // 818: dup
      // 819: dload 12
      // 81b: dload 14
      // 81d: dload 16
      // 81f: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 822: astore 35
      // 824: aload 28
      // 826: bipush 0
      // 827: dload 20
      // 829: dastore
      // 82a: aload 28
      // 82c: bipush 1
      // 82d: dload 22
      // 82f: dastore
      // 830: aload 28
      // 832: ldc_w 267415640
      // 835: ldc_w 267415642
      // 838: ixor
      // 839: dload 24
      // 83b: dastore
      // 83c: aload 0
      // 83d: dload 12
      // 83f: dload 14
      // 841: dload 16
      // 843: aload 7
      // 845: aload 42
      // 847: aload 28
      // 849: invokevirtual x/oca1af5e72c7.Ͱ (DDDLx/oc55a0d9ec35;Lx/C;[D)V
      // 84c: aload 28
      // 84e: bipush 0
      // 84f: daload
      // 850: dstore 20
      // 852: aload 28
      // 854: bipush 1
      // 855: daload
      // 856: dstore 22
      // 858: aload 28
      // 85a: ldc_w 267415640
      // 85d: ldc_w 267415642
      // 860: ixor
      // 861: daload
      // 862: dstore 24
      // 864: dload 14
      // 866: ldc2_w -64.0
      // 869: dcmpg
      // 86a: ifge 871
      // 86d: goto 877
      // 870: athrow
      // 871: iinc 41 1
      // 874: goto 2fb
      // 877: aload 34
      // 879: ifnonnull 8a0
      // 87c: aload 7
      // 87e: getfield x/oc55a0d9ec35.ļ Lx/D;
      // 881: getstatic x/D.ӽ Lx/D;
      // 884: if_acmpne 8a0
      // 887: goto 88b
      // 88a: athrow
      // 88b: aload 35
      // 88d: iload 2
      // 88e: ifne 89e
      // 891: goto 895
      // 894: athrow
      // 895: ifnull 8a0
      // 898: goto 89c
      // 89b: athrow
      // 89c: aload 35
      // 89e: astore 34
      // 8a0: iload 33
      // 8a2: iload 2
      // 8a3: ifne 8f3
      // 8a6: tableswitch 66 1 3 27 40 53
      // 8c0: athrow
      // 8c1: aload 0
      // 8c2: getfield x/oca1af5e72c7.ć Lx/oc24a0a5bddf;
      // 8c5: invokevirtual x/oc24a0a5bddf.ͳ ()I
      // 8c8: istore 41
      // 8ca: iload 2
      // 8cb: ifeq 8f5
      // 8ce: aload 0
      // 8cf: getfield x/oca1af5e72c7.դ Lx/oc24a0a5bddf;
      // 8d2: invokevirtual x/oc24a0a5bddf.ͳ ()I
      // 8d5: istore 41
      // 8d7: iload 2
      // 8d8: ifeq 8f5
      // 8db: aload 0
      // 8dc: getfield x/oca1af5e72c7.Ŧ Lx/oc24a0a5bddf;
      // 8df: invokevirtual x/oc24a0a5bddf.ͳ ()I
      // 8e2: istore 41
      // 8e4: iload 2
      // 8e5: ifeq 8f5
      // 8e8: aload 0
      // 8e9: getfield x/oca1af5e72c7.Б Lx/oc24a0a5bddf;
      // 8ec: invokevirtual x/oc24a0a5bddf.ͳ ()I
      // 8ef: goto 8f3
      // 8f2: athrow
      // 8f3: istore 41
      // 8f5: iload 41
      // 8f7: ldc_w 267415626
      // 8fa: ldc_w 267415642
      // 8fd: ixor
      // 8fe: ishr
      // 8ff: ldc_w 267415717
      // 902: ldc_w 267415642
      // 905: ixor
      // 906: iand
      // 907: i2f
      // 908: ldc_w 255.0
      // 90b: fdiv
      // 90c: fstore 42
      // 90e: iload 41
      // 910: ldc_w 267415634
      // 913: ldc_w 267415642
      // 916: ixor
      // 917: ishr
      // 918: ldc_w 267415717
      // 91b: ldc_w 267415642
      // 91e: ixor
      // 91f: iand
      // 920: i2f
      // 921: ldc_w 255.0
      // 924: fdiv
      // 925: fstore 43
      // 927: iload 41
      // 929: ldc_w 267415717
      // 92c: ldc_w 267415642
      // 92f: ixor
      // 930: iand
      // 931: i2f
      // 932: ldc_w 255.0
      // 935: fdiv
      // 936: fstore 44
      // 938: invokestatic org/lwjgl/opengl/GL11.glPushMatrix ()V
      // 93b: ldc_w 267418490
      // 93e: ldc_w 267415642
      // 941: ixor
      // 942: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 945: ldc_w 267416408
      // 948: ldc_w 267415642
      // 94b: ixor
      // 94c: ldc_w 267416409
      // 94f: ldc_w 267415642
      // 952: ixor
      // 953: invokestatic org/lwjgl/opengl/GL11.glBlendFunc (II)V
      // 956: ldc_w 267418552
      // 959: ldc_w 267415642
      // 95c: ixor
      // 95d: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 960: ldc_w 267419067
      // 963: ldc_w 267415642
      // 966: ixor
      // 967: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 96a: ldc_w 267418411
      // 96d: ldc_w 267415642
      // 970: ixor
      // 971: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 974: bipush 0
      // 975: invokestatic org/lwjgl/opengl/GL11.glDepthMask (Z)V
      // 978: aload 0
      // 979: getfield x/oca1af5e72c7.Ȧ Lx/oca9cc61aada;
      // 97c: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 97f: d2f
      // 980: fstore 45
      // 982: fload 42
      // 984: fload 43
      // 986: fload 44
      // 988: fconst_1
      // 989: invokestatic org/lwjgl/opengl/GL11.glColor4f (FFFF)V
      // 98c: fload 45
      // 98e: invokestatic org/lwjgl/opengl/GL11.glLineWidth (F)V
      // 991: ldc_w 267415641
      // 994: ldc_w 267415642
      // 997: ixor
      // 998: invokestatic org/lwjgl/opengl/GL11.glBegin (I)V
      // 99b: bipush 1
      // 99c: istore 46
      // 99e: aload 0
      // 99f: aload 29
      // 9a1: dload 18
      // 9a3: invokevirtual x/oca1af5e72c7.Ȃ (Ljava/util/List;D)Ljava/util/List;
      // 9a6: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 9ab: astore 47
      // 9ad: aload 47
      // 9af: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 9b4: ifeq a11
      // 9b7: aload 47
      // 9b9: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 9be: checkcast [D
      // 9c1: astore 48
      // 9c3: iload 2
      // 9c4: ifne a0d
      // 9c7: iload 2
      // 9c8: ifne a14
      // 9cb: goto 9cf
      // 9ce: athrow
      // 9cf: iload 46
      // 9d1: ifeq 9f5
      // 9d4: goto 9d8
      // 9d7: athrow
      // 9d8: aload 0
      // 9d9: getfield x/oca1af5e72c7.λ Lx/occ2f8dff8d8;
      // 9dc: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 9df: iload 2
      // 9e0: ifne 9f6
      // 9e3: goto 9e7
      // 9e6: athrow
      // 9e7: ifeq 9f5
      // 9ea: goto 9ee
      // 9ed: athrow
      // 9ee: bipush 0
      // 9ef: istore 46
      // 9f1: iload 2
      // 9f2: ifeq 9ad
      // 9f5: bipush 0
      // 9f6: istore 46
      // 9f8: aload 48
      // 9fa: bipush 0
      // 9fb: daload
      // 9fc: aload 48
      // 9fe: bipush 1
      // 9ff: daload
      // a00: aload 48
      // a02: ldc_w 267415640
      // a05: ldc_w 267415642
      // a08: ixor
      // a09: daload
      // a0a: invokestatic org/lwjgl/opengl/GL11.glVertex3d (DDD)V
      // a0d: iload 2
      // a0e: ifeq 9ad
      // a11: invokestatic x/oc170ea29aae.ŷ ()V
      // a14: aload 31
      // a16: ifnull af3
      // a19: aload 0
      // a1a: getfield x/oca1af5e72c7.ȉ Lx/occ2f8dff8d8;
      // a1d: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // a20: ifeq af3
      // a23: goto a27
      // a26: athrow
      // a27: aload 32
      // a29: ifnull af3
      // a2c: goto a30
      // a2f: athrow
      // a30: aload 31
      // a32: getfield net/minecraft/entity/Entity.lastTickPosX D
      // a35: aload 31
      // a37: getfield net/minecraft/entity/Entity.posX D
      // a3a: aload 31
      // a3c: getfield net/minecraft/entity/Entity.lastTickPosX D
      // a3f: dsub
      // a40: fload 4
      // a42: f2d
      // a43: dmul
      // a44: dadd
      // a45: dstore 47
      // a47: aload 31
      // a49: getfield net/minecraft/entity/Entity.lastTickPosY D
      // a4c: aload 31
      // a4e: getfield net/minecraft/entity/Entity.posY D
      // a51: aload 31
      // a53: getfield net/minecraft/entity/Entity.lastTickPosY D
      // a56: dsub
      // a57: fload 4
      // a59: f2d
      // a5a: dmul
      // a5b: dadd
      // a5c: dstore 49
      // a5e: aload 31
      // a60: getfield net/minecraft/entity/Entity.lastTickPosZ D
      // a63: aload 31
      // a65: getfield net/minecraft/entity/Entity.posZ D
      // a68: aload 31
      // a6a: getfield net/minecraft/entity/Entity.lastTickPosZ D
      // a6d: dsub
      // a6e: fload 4
      // a70: f2d
      // a71: dmul
      // a72: dadd
      // a73: dstore 51
      // a75: new net/minecraft/util/AxisAlignedBB
      // a78: dup
      // a79: aload 32
      // a7b: getfield net/minecraft/util/AxisAlignedBB.minX D
      // a7e: aload 31
      // a80: getfield net/minecraft/entity/Entity.posX D
      // a83: dsub
      // a84: dload 47
      // a86: dadd
      // a87: aload 32
      // a89: getfield net/minecraft/util/AxisAlignedBB.minY D
      // a8c: aload 31
      // a8e: getfield net/minecraft/entity/Entity.posY D
      // a91: dsub
      // a92: dload 49
      // a94: dadd
      // a95: aload 32
      // a97: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // a9a: aload 31
      // a9c: getfield net/minecraft/entity/Entity.posZ D
      // a9f: dsub
      // aa0: dload 51
      // aa2: dadd
      // aa3: aload 32
      // aa5: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // aa8: aload 31
      // aaa: getfield net/minecraft/entity/Entity.posX D
      // aad: dsub
      // aae: dload 47
      // ab0: dadd
      // ab1: aload 32
      // ab3: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // ab6: aload 31
      // ab8: getfield net/minecraft/entity/Entity.posY D
      // abb: dsub
      // abc: dload 49
      // abe: dadd
      // abf: aload 32
      // ac1: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // ac4: aload 31
      // ac6: getfield net/minecraft/entity/Entity.posZ D
      // ac9: dsub
      // aca: dload 51
      // acc: dadd
      // acd: invokespecial net/minecraft/util/AxisAlignedBB.<init> (DDDDDD)V
      // ad0: astore 53
      // ad2: fload 42
      // ad4: fload 43
      // ad6: fload 44
      // ad8: fconst_1
      // ad9: invokestatic org/lwjgl/opengl/GL11.glColor4f (FFFF)V
      // adc: aload 53
      // ade: aload 36
      // ae0: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosX D
      // ae3: aload 36
      // ae5: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosY D
      // ae8: aload 36
      // aea: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosZ D
      // aed: invokestatic x/ocbd4917c4b1.ԁ (Lnet/minecraft/util/AxisAlignedBB;DDD)V
      // af0: goto b4b
      // af3: aload 30
      // af5: ifnull b4b
      // af8: aload 0
      // af9: iload 2
      // afa: ifne b4c
      // afd: goto b01
      // b00: athrow
      // b01: getfield x/oca1af5e72c7.ќ Lx/occ2f8dff8d8;
      // b04: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // b07: ifne b4b
      // b0a: goto b0e
      // b0d: athrow
      // b0e: aload 30
      // b10: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // b13: astore 47
      // b15: iload 2
      // b16: aload 47
      // b18: invokestatic x/occb1ed1ed8f.ª (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/util/AxisAlignedBB;
      // b1b: astore 48
      // b1d: ifne b37
      // b20: aload 48
      // b22: ifnull b4b
      // b25: goto b29
      // b28: athrow
      // b29: fload 42
      // b2b: fload 43
      // b2d: fload 44
      // b2f: fconst_1
      // b30: invokestatic org/lwjgl/opengl/GL11.glColor4f (FFFF)V
      // b33: goto b37
      // b36: athrow
      // b37: aload 48
      // b39: aload 36
      // b3b: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosX D
      // b3e: aload 36
      // b40: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosY D
      // b43: aload 36
      // b45: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosZ D
      // b48: invokestatic x/ocbd4917c4b1.ԁ (Lnet/minecraft/util/AxisAlignedBB;DDD)V
      // b4b: aload 0
      // b4c: getfield x/oca1af5e72c7.ќ Lx/occ2f8dff8d8;
      // b4f: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // b52: iload 2
      // b53: ifne bb0
      // b56: ifeq b87
      // b59: goto b5d
      // b5c: athrow
      // b5d: aload 34
      // b5f: ifnull b87
      // b62: goto b66
      // b65: athrow
      // b66: aload 0
      // b67: aload 34
      // b69: aload 36
      // b6b: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosX D
      // b6e: aload 36
      // b70: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosY D
      // b73: aload 36
      // b75: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosZ D
      // b78: fload 42
      // b7a: fload 43
      // b7c: fload 44
      // b7e: iload 33
      // b80: invokevirtual x/oca1af5e72c7.Ո (Lnet/minecraft/util/Vec3;DDDFFFI)V
      // b83: goto b87
      // b86: athrow
      // b87: ldc_w 267418552
      // b8a: ldc_w 267415642
      // b8d: ixor
      // b8e: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // b91: ldc_w 267419067
      // b94: ldc_w 267415642
      // b97: ixor
      // b98: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // b9b: ldc_w 267418411
      // b9e: ldc_w 267415642
      // ba1: ixor
      // ba2: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // ba5: bipush 1
      // ba6: invokestatic org/lwjgl/opengl/GL11.glDepthMask (Z)V
      // ba9: ldc_w 267418490
      // bac: ldc_w 267415642
      // baf: ixor
      // bb0: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // bb3: invokestatic org/lwjgl/opengl/GL11.glPopMatrix ()V
      // bb6: return
   }

   private void ц(EntityPlayer param1, float param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: aload 1
      // 001: fload 2
      // 002: aload 0
      // 003: getfield x/oca1af5e72c7.Ӹ Lx/oca9cc61aada;
      // 006: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 009: invokestatic x/oca163026023.Љ (Lnet/minecraft/entity/player/EntityPlayer;FD)Lnet/minecraft/util/MovingObjectPosition;
      // 00c: astore 4
      // 00e: aload 1
      // 00f: fload 2
      // 010: invokevirtual net/minecraft/entity/player/EntityPlayer.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 013: astore 5
      // 015: aload 1
      // 016: getfield net/minecraft/entity/player/EntityPlayer.rotationPitch F
      // 019: aload 1
      // 01a: getfield net/minecraft/entity/player/EntityPlayer.rotationYaw F
      // 01d: invokestatic x/oc75d51ec7eb.ď (FF)Lnet/minecraft/util/Vec3;
      // 020: astore 6
      // 022: getstatic x/oce6044968f8.ђ Z
      // 025: aload 1
      // 026: getfield net/minecraft/entity/player/EntityPlayer.rotationYaw F
      // 029: f2d
      // 02a: invokestatic java/lang/Math.toRadians (D)D
      // 02d: dstore 7
      // 02f: istore 3
      // 030: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 033: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 036: getfield net/minecraft/client/settings/GameSettings.thirdPersonView I
      // 039: iload 3
      // 03a: ifne 045
      // 03d: ifne 048
      // 040: goto 044
      // 043: athrow
      // 044: bipush 1
      // 045: goto 049
      // 048: bipush 0
      // 049: istore 9
      // 04b: aload 5
      // 04d: aload 6
      // 04f: getfield net/minecraft/util/Vec3.xCoord D
      // 052: ldc2_w 0.5
      // 055: iload 3
      // 056: ifne 070
      // 059: dmul
      // 05a: iload 9
      // 05c: ifeq 073
      // 05f: goto 063
      // 062: athrow
      // 063: dload 7
      // 065: invokestatic java/lang/Math.cos (D)D
      // 068: ldc2_w 0.35
      // 06b: dmul
      // 06c: goto 070
      // 06f: athrow
      // 070: goto 074
      // 073: dconst_0
      // 074: dsub
      // 075: aload 6
      // 077: getfield net/minecraft/util/Vec3.yCoord D
      // 07a: ldc2_w 0.5
      // 07d: iload 3
      // 07e: ifne 092
      // 081: dmul
      // 082: iload 9
      // 084: ifeq 095
      // 087: goto 08b
      // 08a: athrow
      // 08b: ldc2_w 0.25
      // 08e: goto 092
      // 091: athrow
      // 092: goto 096
      // 095: dconst_0
      // 096: dsub
      // 097: aload 6
      // 099: getfield net/minecraft/util/Vec3.zCoord D
      // 09c: ldc2_w 0.5
      // 09f: iload 3
      // 0a0: ifne 0ba
      // 0a3: dmul
      // 0a4: iload 9
      // 0a6: ifeq 0bd
      // 0a9: goto 0ad
      // 0ac: athrow
      // 0ad: dload 7
      // 0af: invokestatic java/lang/Math.sin (D)D
      // 0b2: ldc2_w 0.35
      // 0b5: dmul
      // 0b6: goto 0ba
      // 0b9: athrow
      // 0ba: goto 0be
      // 0bd: dconst_0
      // 0be: dsub
      // 0bf: invokevirtual net/minecraft/util/Vec3.addVector (DDD)Lnet/minecraft/util/Vec3;
      // 0c2: astore 10
      // 0c4: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0c7: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 0ca: astore 11
      // 0cc: aload 0
      // 0cd: getfield x/oca1af5e72c7.Σ Lx/oc24a0a5bddf;
      // 0d0: invokevirtual x/oc24a0a5bddf.ͳ ()I
      // 0d3: istore 12
      // 0d5: iload 12
      // 0d7: ldc_w -1632763482
      // 0da: ldc_w -1632763466
      // 0dd: ixor
      // 0de: ishr
      // 0df: ldc_w -1632763575
      // 0e2: ldc_w -1632763466
      // 0e5: ixor
      // 0e6: iand
      // 0e7: i2f
      // 0e8: ldc_w 255.0
      // 0eb: fdiv
      // 0ec: fstore 13
      // 0ee: iload 12
      // 0f0: ldc_w -1632763458
      // 0f3: ldc_w -1632763466
      // 0f6: ixor
      // 0f7: ishr
      // 0f8: ldc_w -1632763575
      // 0fb: ldc_w -1632763466
      // 0fe: ixor
      // 0ff: iand
      // 100: i2f
      // 101: ldc_w 255.0
      // 104: fdiv
      // 105: fstore 14
      // 107: iload 12
      // 109: ldc_w -1632763575
      // 10c: ldc_w -1632763466
      // 10f: ixor
      // 110: iand
      // 111: i2f
      // 112: ldc_w 255.0
      // 115: fdiv
      // 116: fstore 15
      // 118: ldc_w -1633550775
      // 11b: ldc_w -1632763466
      // 11e: ixor
      // 11f: invokestatic org/lwjgl/opengl/GL11.glPushAttrib (I)V
      // 122: ldc_w -1632761260
      // 125: ldc_w -1632763466
      // 128: ixor
      // 129: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 12c: iload 3
      // 12d: ldc_w -1632763212
      // 130: ldc_w -1632763466
      // 133: ixor
      // 134: ldc_w -1632763211
      // 137: ldc_w -1632763466
      // 13a: ixor
      // 13b: invokestatic org/lwjgl/opengl/GL11.glBlendFunc (II)V
      // 13e: ldc_w -1632761194
      // 141: ldc_w -1632763466
      // 144: ixor
      // 145: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 148: ldc_w -1632760745
      // 14b: ldc_w -1632763466
      // 14e: ixor
      // 14f: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 152: ldc_w -1632761114
      // 155: ldc_w -1632763466
      // 158: ixor
      // 159: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 15c: ldc_w -1632761226
      // 15f: ldc_w -1632763466
      // 162: ixor
      // 163: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 166: ldc_w -1632761145
      // 169: ldc_w -1632763466
      // 16c: ixor
      // 16d: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 170: ifne 2e2
      // 173: ldc_w -1632761102
      // 176: ldc_w -1632763466
      // 179: ixor
      // 17a: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 17d: bipush 0
      // 17e: invokestatic org/lwjgl/opengl/GL11.glDepthMask (Z)V
      // 181: aload 0
      // 182: getfield x/oca1af5e72c7.Ȧ Lx/oca9cc61aada;
      // 185: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 188: d2f
      // 189: invokestatic org/lwjgl/opengl/GL11.glLineWidth (F)V
      // 18c: fload 13
      // 18e: fload 14
      // 190: fload 15
      // 192: fconst_1
      // 193: invokestatic org/lwjgl/opengl/GL11.glColor4f (FFFF)V
      // 196: bipush 1
      // 197: invokestatic org/lwjgl/opengl/GL11.glBegin (I)V
      // 19a: aload 10
      // 19c: getfield net/minecraft/util/Vec3.xCoord D
      // 19f: aload 11
      // 1a1: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosX D
      // 1a4: dsub
      // 1a5: aload 10
      // 1a7: getfield net/minecraft/util/Vec3.yCoord D
      // 1aa: aload 11
      // 1ac: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosY D
      // 1af: dsub
      // 1b0: aload 10
      // 1b2: getfield net/minecraft/util/Vec3.zCoord D
      // 1b5: aload 11
      // 1b7: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosZ D
      // 1ba: dsub
      // 1bb: invokestatic org/lwjgl/opengl/GL11.glVertex3d (DDD)V
      // 1be: aload 4
      // 1c0: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 1c3: getfield net/minecraft/util/Vec3.xCoord D
      // 1c6: aload 11
      // 1c8: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosX D
      // 1cb: dsub
      // 1cc: aload 4
      // 1ce: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 1d1: getfield net/minecraft/util/Vec3.yCoord D
      // 1d4: aload 11
      // 1d6: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosY D
      // 1d9: dsub
      // 1da: aload 4
      // 1dc: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 1df: getfield net/minecraft/util/Vec3.zCoord D
      // 1e2: aload 11
      // 1e4: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosZ D
      // 1e7: dsub
      // 1e8: invokestatic org/lwjgl/opengl/GL11.glVertex3d (DDD)V
      // 1eb: invokestatic x/oc170ea29aae.ŷ ()V
      // 1ee: aload 0
      // 1ef: getfield x/oca1af5e72c7.ќ Lx/occ2f8dff8d8;
      // 1f2: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 1f5: ifeq 2df
      // 1f8: aconst_null
      // 1f9: astore 16
      // 1fb: aload 4
      // 1fd: iload 3
      // 1fe: ifne 21d
      // 201: getfield net/minecraft/util/MovingObjectPosition.typeOfHit Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 204: getstatic net/minecraft/util/MovingObjectPosition$MovingObjectType.BLOCK Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 207: if_acmpne 21b
      // 20a: goto 20e
      // 20d: athrow
      // 20e: aload 4
      // 210: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 213: invokestatic x/occb1ed1ed8f.ª (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/util/AxisAlignedBB;
      // 216: astore 16
      // 218: goto 23b
      // 21b: aload 4
      // 21d: getfield net/minecraft/util/MovingObjectPosition.entityHit Lnet/minecraft/entity/Entity;
      // 220: ifnull 23b
      // 223: aload 0
      // 224: getfield x/oca1af5e72c7.ȉ Lx/occ2f8dff8d8;
      // 227: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 22a: ifeq 23b
      // 22d: goto 231
      // 230: athrow
      // 231: aload 4
      // 233: getfield net/minecraft/util/MovingObjectPosition.entityHit Lnet/minecraft/entity/Entity;
      // 236: invokevirtual net/minecraft/entity/Entity.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 239: astore 16
      // 23b: aload 16
      // 23d: iload 3
      // 23e: ifne 2d3
      // 241: ifnonnull 298
      // 244: goto 248
      // 247: athrow
      // 248: ldc2_w 0.1
      // 24b: dstore 17
      // 24d: new net/minecraft/util/AxisAlignedBB
      // 250: dup
      // 251: aload 4
      // 253: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 256: getfield net/minecraft/util/Vec3.xCoord D
      // 259: dload 17
      // 25b: dsub
      // 25c: aload 4
      // 25e: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 261: getfield net/minecraft/util/Vec3.yCoord D
      // 264: dload 17
      // 266: dsub
      // 267: aload 4
      // 269: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 26c: getfield net/minecraft/util/Vec3.zCoord D
      // 26f: dload 17
      // 271: dsub
      // 272: aload 4
      // 274: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 277: getfield net/minecraft/util/Vec3.xCoord D
      // 27a: dload 17
      // 27c: dadd
      // 27d: aload 4
      // 27f: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 282: getfield net/minecraft/util/Vec3.yCoord D
      // 285: dload 17
      // 287: dadd
      // 288: aload 4
      // 28a: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 28d: getfield net/minecraft/util/Vec3.zCoord D
      // 290: dload 17
      // 292: dadd
      // 293: invokespecial net/minecraft/util/AxisAlignedBB.<init> (DDDDDD)V
      // 296: astore 16
      // 298: aload 16
      // 29a: ldc2_w 0.002
      // 29d: ldc2_w 0.002
      // 2a0: ldc2_w 0.002
      // 2a3: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 2a6: astore 16
      // 2a8: aload 16
      // 2aa: aload 11
      // 2ac: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosX D
      // 2af: aload 11
      // 2b1: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosY D
      // 2b4: aload 11
      // 2b6: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosZ D
      // 2b9: invokestatic x/ocbd4917c4b1.ԁ (Lnet/minecraft/util/AxisAlignedBB;DDD)V
      // 2bc: aload 16
      // 2be: aload 11
      // 2c0: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosX D
      // 2c3: dneg
      // 2c4: aload 11
      // 2c6: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosY D
      // 2c9: dneg
      // 2ca: aload 11
      // 2cc: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosZ D
      // 2cf: dneg
      // 2d0: invokevirtual net/minecraft/util/AxisAlignedBB.offset (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 2d3: fload 13
      // 2d5: fload 14
      // 2d7: fload 15
      // 2d9: ldc_w 0.18
      // 2dc: invokestatic x/ocbd4917c4b1.ʓ (Lnet/minecraft/util/AxisAlignedBB;FFFF)V
      // 2df: invokestatic org/lwjgl/opengl/GL11.glPopAttrib ()V
      // 2e2: goto 2ed
      // 2e5: astore 19
      // 2e7: invokestatic org/lwjgl/opengl/GL11.glPopAttrib ()V
      // 2ea: aload 19
      // 2ec: athrow
      // 2ed: return
   }

   private void Ո(Vec3 var1, double var2, double var4, double var6, float var8, float var9, float var10, int var11) {
      double var10000;
      label30: {
         try {
            if (var11 == 1) {
               var10000 = 0.4;
               break label30;
            }
         } catch (ocbde1165e4e var25) {
            throw var25;
         }

         var10000 = 0.2;
      }

      double var12 = var10000;
      AxisAlignedBB var14 = new AxisAlignedBB(
         var1.xCoord - var12, var1.yCoord - var12, var1.zCoord - var12, var1.xCoord + var12, var1.yCoord + var12, var1.zCoord + var12
      );
      GL11.glLineWidth(2.0F);
      GL11.glColor4f(var8, var9, var10, 1.0F);
      ocbd4917c4b1.ԁ(var14, var2, var4, var6);
      AxisAlignedBB var15 = var14.offset(-var2, -var4, -var6);
      GL11.glColor4f(var8, var9, var10, 0.3F);
      ocbd4917c4b1.ʓ(var15, var8, var9, var10, 0.3F);
      double var16 = var1.xCoord - var2;
      double var18 = var1.yCoord - var4;
      double var20 = var1.zCoord - var6;

      label22: {
         try {
            if (var11 == 1) {
               var10000 = 0.5;
               break label22;
            }
         } catch (ocbde1165e4e var24) {
            throw var24;
         }

         var10000 = 0.3;
      }

      double var22 = var10000;
      GL11.glLineWidth(1.5F);
      GL11.glColor4f(var8, var9, var10, 1.0F);
      GL11.glBegin(1);
      GL11.glVertex3d(var16 - var22, var18, var20);
      GL11.glVertex3d(var16 + var22, var18, var20);
      GL11.glVertex3d(var16, var18 - var22, var20);
      GL11.glVertex3d(var16, var18 + var22, var20);
      GL11.glVertex3d(var16, var18, var20 - var22);
      GL11.glVertex3d(var16, var18, var20 + var22);
      oc170ea29aae.ŷ();
   }
}

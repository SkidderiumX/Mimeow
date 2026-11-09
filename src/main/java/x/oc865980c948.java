package x;

import com.google.common.base.Predicate;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.enchantment.EnchantmentProtection;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.FoodStats;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovementInput;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.border.WorldBorder;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import org.apache.commons.lang3.tuple.Pair;

public class oc865980c948 {
   private static final Minecraft ʖ = Minecraft.getMinecraft();
   private final EntityPlayerSP Ȁ;
   public AxisAlignedBB У;
   public final MovementInput Ŗ;
   private int լ;
   public double τ;
   public double Մ;
   public double μ;
   private boolean ћ;
   public boolean ӕ;
   private boolean ɟ;
   public float ǖ;
   public float ԕ;
   private double б;
   private double ъ;
   private double ҟ;
   private final PlayerCapabilities Η;
   private final Entity ə;
   private float Խ;
   private final World ƀ;
   public boolean ǡ;
   private boolean ɑ;
   private final WorldBorder î;
   private final IChunkProvider Ӈ;
   private boolean ʷ;
   private final Entity ʡ;
   private BaseAttributeMap ղ;
   private final boolean ɋ;
   public float Ó;
   private final float Ǻ;
   private boolean ϡ;
   private int Є;
   private float Ԕ;
   private float ό;
   private int Ӎ;
   public final float ԋ;
   private final float Ǽ;
   private final int Ԅ;
   private boolean ȼ;
   private boolean ͳ;
   private boolean ǝ;
   private boolean ƨ;
   private final FoodStats Ҵ;
   private float ȸ = 0.0F;
   private float ȹ = 0.0F;
   private boolean Ы = false;
   public boolean Ǎ = false;
   private static final float u = 0.02F;
   public static int Ņ;

   public oc865980c948(
      EntityPlayerSP var1,
      AxisAlignedBB var2,
      MovementInput var3,
      int var4,
      double var5,
      double var7,
      double var9,
      boolean var11,
      boolean var12,
      boolean var13,
      float var14,
      float var15,
      double var16,
      double var18,
      double var20,
      PlayerCapabilities var22,
      Entity var23,
      float var24,
      World var25,
      boolean var26,
      boolean var27,
      WorldBorder var28,
      IChunkProvider var29,
      boolean var30,
      Entity var31,
      BaseAttributeMap var32,
      boolean var33,
      float var34,
      float var35,
      boolean var36,
      int var37,
      float var38,
      float var39,
      int var40,
      float var41,
      float var42,
      int var43,
      boolean var44,
      boolean var45,
      boolean var46,
      FoodStats var47
   ) {
      this.Ȁ = var1;
      this.У = var2;
      this.Ŗ = var3;
      this.լ = var4;
      this.τ = var5;
      this.Մ = var7;
      this.μ = var9;
      this.ћ = var11;
      this.ӕ = var12;
      this.ɟ = var13;
      this.ǖ = var14;
      this.ԕ = var15;
      this.б = var16;
      this.ъ = var18;
      this.ҟ = var20;
      this.Η = var22;
      this.ə = var23;
      this.Խ = var24;
      this.ƀ = var25;
      this.ǡ = var26;
      this.ɑ = var27;
      this.î = var28;
      this.Ӈ = var29;
      this.ʷ = var30;
      this.ʡ = var31;
      this.ղ = var32;
      this.ɋ = var33;
      this.Ó = var34;
      this.Ǻ = var35;
      this.ϡ = var36;
      this.Є = var37;
      this.Ԕ = var38;
      this.ό = var39;
      this.Ӎ = var40;
      this.ԋ = var41;
      this.Ǽ = var42;
      this.Ԅ = var43;
      this.ȼ = var44;
      this.ͳ = var45;
      this.ǝ = var46;
      this.ƨ = var46;
      this.Ҵ = var47;
   }

   public Vec3 ʩ() {
      return new Vec3(this.б, this.ъ, this.ҟ);
   }

   public static oc865980c948 ʢ(MovementInput param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc865980c948.ʖ Lnet/minecraft/client/Minecraft;
      // 003: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 006: astore 2
      // 007: getstatic x/oc166ec60a37.ȗ Z
      // 00a: aload 2
      // 00b: invokestatic x/oc865980c948.ʓ (Lnet/minecraft/client/entity/EntityPlayerSP;)Lnet/minecraft/entity/player/PlayerCapabilities;
      // 00e: astore 3
      // 00f: aload 2
      // 010: invokestatic x/oc865980c948.Ũ (Lnet/minecraft/client/entity/EntityPlayerSP;)Lnet/minecraft/util/FoodStats;
      // 013: astore 4
      // 015: istore 1
      // 016: new net/minecraft/util/MovementInput
      // 019: dup
      // 01a: invokespecial net/minecraft/util/MovementInput.<init> ()V
      // 01d: astore 5
      // 01f: aload 5
      // 021: aload 0
      // 022: getfield net/minecraft/util/MovementInput.jump Z
      // 025: putfield net/minecraft/util/MovementInput.jump Z
      // 028: aload 5
      // 02a: aload 0
      // 02b: getfield net/minecraft/util/MovementInput.moveForward F
      // 02e: putfield net/minecraft/util/MovementInput.moveForward F
      // 031: aload 5
      // 033: aload 0
      // 034: getfield net/minecraft/util/MovementInput.moveStrafe F
      // 037: putfield net/minecraft/util/MovementInput.moveStrafe F
      // 03a: aload 5
      // 03c: aload 0
      // 03d: getfield net/minecraft/util/MovementInput.sneak Z
      // 040: putfield net/minecraft/util/MovementInput.sneak Z
      // 043: new x/oc865980c948
      // 046: dup
      // 047: aload 2
      // 048: aload 2
      // 049: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 04c: aload 5
      // 04e: aload 2
      // 04f: invokeinterface x/oc09673369f7.getJumpTicks ()I 1
      // 054: aload 2
      // 055: getfield net/minecraft/client/entity/EntityPlayerSP.motionZ D
      // 058: aload 2
      // 059: getfield net/minecraft/client/entity/EntityPlayerSP.motionY D
      // 05c: aload 2
      // 05d: getfield net/minecraft/client/entity/EntityPlayerSP.motionX D
      // 060: aload 2
      // 061: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isInWater ()Z
      // 064: aload 2
      // 065: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 068: aload 2
      // 069: getfield net/minecraft/client/entity/EntityPlayerSP.isAirBorne Z
      // 06c: aload 2
      // 06d: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 070: aload 2
      // 071: getfield net/minecraft/client/entity/EntityPlayerSP.rotationPitch F
      // 074: aload 2
      // 075: getfield net/minecraft/client/entity/EntityPlayerSP.posX D
      // 078: aload 2
      // 079: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // 07c: aload 2
      // 07d: getfield net/minecraft/client/entity/EntityPlayerSP.posZ D
      // 080: aload 3
      // 081: aload 2
      // 082: getfield net/minecraft/client/entity/EntityPlayerSP.ridingEntity Lnet/minecraft/entity/Entity;
      // 085: aload 2
      // 086: getfield net/minecraft/client/entity/EntityPlayerSP.jumpMovementFactor F
      // 089: aload 2
      // 08a: getfield net/minecraft/client/entity/EntityPlayerSP.worldObj Lnet/minecraft/world/World;
      // 08d: aload 2
      // 08e: getfield net/minecraft/client/entity/EntityPlayerSP.isCollidedHorizontally Z
      // 091: aload 2
      // 092: getfield net/minecraft/client/entity/EntityPlayerSP.isCollidedVertically Z
      // 095: aload 2
      // 096: getfield net/minecraft/client/entity/EntityPlayerSP.worldObj Lnet/minecraft/world/World;
      // 099: invokevirtual net/minecraft/world/World.getWorldBorder ()Lnet/minecraft/world/border/WorldBorder;
      // 09c: aload 2
      // 09d: getfield net/minecraft/client/entity/EntityPlayerSP.worldObj Lnet/minecraft/world/World;
      // 0a0: invokevirtual net/minecraft/world/World.getChunkProvider ()Lnet/minecraft/world/chunk/IChunkProvider;
      // 0a3: aload 2
      // 0a4: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isOutsideBorder ()Z
      // 0a7: aload 2
      // 0a8: getfield net/minecraft/client/entity/EntityPlayerSP.riddenByEntity Lnet/minecraft/entity/Entity;
      // 0ab: aload 2
      // 0ac: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getAttributeMap ()Lnet/minecraft/entity/ai/attributes/BaseAttributeMap;
      // 0af: aload 2
      // 0b0: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isSpectator ()Z
      // 0b3: aload 2
      // 0b4: getfield net/minecraft/client/entity/EntityPlayerSP.fallDistance F
      // 0b7: aload 2
      // 0b8: getfield net/minecraft/client/entity/EntityPlayerSP.stepHeight F
      // 0bb: aload 2
      // 0bc: getfield net/minecraft/client/entity/EntityPlayerSP.isCollided Z
      // 0bf: aload 2
      // 0c0: invokeinterface x/ocafaaad134a.getFire ()I 1
      // 0c5: aload 2
      // 0c6: getfield net/minecraft/client/entity/EntityPlayerSP.distanceWalkedModified F
      // 0c9: aload 2
      // 0ca: getfield net/minecraft/client/entity/EntityPlayerSP.distanceWalkedOnStepModified F
      // 0cd: aload 2
      // 0ce: invokeinterface x/ocafaaad134a.getNextStepDistance ()I 1
      // 0d3: aload 2
      // 0d4: getfield net/minecraft/client/entity/EntityPlayerSP.height F
      // 0d7: aload 2
      // 0d8: getfield net/minecraft/client/entity/EntityPlayerSP.width F
      // 0db: aload 2
      // 0dc: getfield net/minecraft/client/entity/EntityPlayerSP.fireResistance I
      // 0df: aload 2
      // 0e0: invokeinterface x/ocafaaad134a.getIsInWeb ()Z 1
      // 0e5: aload 2
      // 0e6: getfield net/minecraft/client/entity/EntityPlayerSP.noClip Z
      // 0e9: aload 2
      // 0ea: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isSprinting ()Z
      // 0ed: aload 4
      // 0ef: invokespecial x/oc865980c948.<init> (Lnet/minecraft/client/entity/EntityPlayerSP;Lnet/minecraft/util/AxisAlignedBB;Lnet/minecraft/util/MovementInput;IDDDZZZFFDDDLnet/minecraft/entity/player/PlayerCapabilities;Lnet/minecraft/entity/Entity;FLnet/minecraft/world/World;ZZLnet/minecraft/world/border/WorldBorder;Lnet/minecraft/world/chunk/IChunkProvider;ZLnet/minecraft/entity/Entity;Lnet/minecraft/entity/ai/attributes/BaseAttributeMap;ZFFZIFFIFFIZZZLnet/minecraft/util/FoodStats;)V
      // 0f2: iload 1
      // 0f3: ifeq 107
      // 0f6: bipush 0
      // 0f7: ifeq 103
      // 0fa: goto 0fe
      // 0fd: athrow
      // 0fe: bipush 0
      // 0ff: goto 104
      // 102: athrow
      // 103: bipush 1
      // 104: putstatic x/oc69da1aa7f5.Ҭ Z
      // 107: areturn
   }

   private static FoodStats Ũ(EntityPlayerSP var0) {
      NBTTagCompound var1 = new NBTTagCompound();
      FoodStats var2 = new FoodStats();
      var0.getFoodStats().writeNBT(var1);
      var2.readNBT(var1);
      return var2;
   }

   private static PlayerCapabilities ʓ(EntityPlayerSP var0) {
      NBTTagCompound var1 = new NBTTagCompound();
      PlayerCapabilities var2 = new PlayerCapabilities();
      var0.capabilities.writeCapabilitiesToNBT(var1);
      var2.readCapabilitiesFromNBT(var1);
      var2.isFlying = false;
      var2.allowFlying = false;
      return var2;
   }

   private boolean Ϣ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc166ec60a37.ȗ Z
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 2d
      // 09: invokevirtual x/oc865980c948.Ѕ ()Z
      // 0c: pop
      // 0d: aload 0
      // 0e: getfield x/oc865980c948.ƀ Lnet/minecraft/world/World;
      // 11: getfield net/minecraft/world/World.isRemote Z
      // 14: ifeq 28
      // 17: goto 1b
      // 1a: athrow
      // 1b: aload 0
      // 1c: bipush 0
      // 1d: putfield x/oc865980c948.Є I
      // 20: iload 1
      // 21: ifeq 49
      // 24: goto 28
      // 27: athrow
      // 28: aload 0
      // 29: goto 2d
      // 2c: athrow
      // 2d: iload 1
      // 2e: ifne 4a
      // 31: getfield x/oc865980c948.Є I
      // 34: ifle 49
      // 37: goto 3b
      // 3a: athrow
      // 3b: aload 0
      // 3c: dup
      // 3d: getfield x/oc865980c948.Є I
      // 40: bipush 1
      // 41: isub
      // 42: putfield x/oc865980c948.Є I
      // 45: goto 49
      // 48: athrow
      // 49: aload 0
      // 4a: iload 1
      // 4b: ifne 6d
      // 4e: invokevirtual x/oc865980c948.â ()Z
      // 51: ifeq 6c
      // 54: goto 58
      // 57: athrow
      // 58: aload 0
      // 59: invokevirtual x/oc865980c948.ϩ ()V
      // 5c: aload 0
      // 5d: dup
      // 5e: getfield x/oc865980c948.Ó F
      // 61: ldc_w 0.5
      // 64: fmul
      // 65: putfield x/oc865980c948.Ó F
      // 68: goto 6c
      // 6b: athrow
      // 6c: aload 0
      // 6d: getfield x/oc865980c948.ъ D
      // 70: ldc2_w -64.0
      // 73: dcmpg
      // 74: iload 1
      // 75: ifne 80
      // 78: iflt 83
      // 7b: goto 7f
      // 7e: athrow
      // 7f: bipush 1
      // 80: goto 84
      // 83: bipush 0
      // 84: ireturn
   }

   public void ǫ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc166ec60a37.ȗ Z
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 18
      // 09: invokevirtual x/oc865980c948.Ϣ ()Z
      // 0c: ifeq 29
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: iload 1
      // 19: ifne 35
      // 1c: getfield x/oc865980c948.Ȁ Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1f: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isRiding ()Z
      // 22: ifeq 2b
      // 25: goto 29
      // 28: athrow
      // 29: return
      // 2a: athrow
      // 2b: aload 0
      // 2c: bipush 0
      // 2d: invokevirtual x/oc865980c948.ē (Z)V
      // 30: aload 0
      // 31: invokevirtual x/oc865980c948.դ ()V
      // 34: aload 0
      // 35: bipush 1
      // 36: invokevirtual x/oc865980c948.ē (Z)V
      // 39: return
   }

   private void դ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc166ec60a37.ȗ Z
      // 003: aload 0
      // 004: aload 0
      // 005: getfield x/oc865980c948.б D
      // 008: aload 0
      // 009: getfield x/oc865980c948.Ǽ F
      // 00c: f2d
      // 00d: ldc2_w 0.35
      // 010: dmul
      // 011: dsub
      // 012: aload 0
      // 013: invokevirtual x/oc865980c948.ш ()Lnet/minecraft/util/AxisAlignedBB;
      // 016: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 019: ldc2_w 0.5
      // 01c: dadd
      // 01d: aload 0
      // 01e: getfield x/oc865980c948.ҟ D
      // 021: aload 0
      // 022: getfield x/oc865980c948.Ǽ F
      // 025: f2d
      // 026: ldc2_w 0.35
      // 029: dmul
      // 02a: dadd
      // 02b: invokevirtual x/oc865980c948.Λ (DDD)Z
      // 02e: pop
      // 02f: istore 1
      // 030: aload 0
      // 031: aload 0
      // 032: getfield x/oc865980c948.б D
      // 035: aload 0
      // 036: getfield x/oc865980c948.Ǽ F
      // 039: f2d
      // 03a: ldc2_w 0.35
      // 03d: dmul
      // 03e: dsub
      // 03f: aload 0
      // 040: invokevirtual x/oc865980c948.ш ()Lnet/minecraft/util/AxisAlignedBB;
      // 043: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 046: ldc2_w 0.5
      // 049: dadd
      // 04a: aload 0
      // 04b: getfield x/oc865980c948.ҟ D
      // 04e: aload 0
      // 04f: getfield x/oc865980c948.Ǽ F
      // 052: f2d
      // 053: ldc2_w 0.35
      // 056: dmul
      // 057: dsub
      // 058: invokevirtual x/oc865980c948.Λ (DDD)Z
      // 05b: iload 1
      // 05c: ifne 0ea
      // 05f: pop
      // 060: aload 0
      // 061: aload 0
      // 062: getfield x/oc865980c948.б D
      // 065: aload 0
      // 066: getfield x/oc865980c948.Ǽ F
      // 069: f2d
      // 06a: ldc2_w 0.35
      // 06d: dmul
      // 06e: dadd
      // 06f: aload 0
      // 070: invokevirtual x/oc865980c948.ш ()Lnet/minecraft/util/AxisAlignedBB;
      // 073: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 076: ldc2_w 0.5
      // 079: dadd
      // 07a: aload 0
      // 07b: getfield x/oc865980c948.ҟ D
      // 07e: aload 0
      // 07f: getfield x/oc865980c948.Ǽ F
      // 082: f2d
      // 083: ldc2_w 0.35
      // 086: dmul
      // 087: dsub
      // 088: invokevirtual x/oc865980c948.Λ (DDD)Z
      // 08b: pop
      // 08c: aload 0
      // 08d: aload 0
      // 08e: getfield x/oc865980c948.б D
      // 091: aload 0
      // 092: getfield x/oc865980c948.Ǽ F
      // 095: f2d
      // 096: ldc2_w 0.35
      // 099: dmul
      // 09a: dadd
      // 09b: aload 0
      // 09c: invokevirtual x/oc865980c948.ш ()Lnet/minecraft/util/AxisAlignedBB;
      // 09f: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 0a2: ldc2_w 0.5
      // 0a5: dadd
      // 0a6: aload 0
      // 0a7: getfield x/oc865980c948.ҟ D
      // 0aa: aload 0
      // 0ab: getfield x/oc865980c948.Ǽ F
      // 0ae: f2d
      // 0af: ldc2_w 0.35
      // 0b2: dmul
      // 0b3: dadd
      // 0b4: invokevirtual x/oc865980c948.Λ (DDD)Z
      // 0b7: pop
      // 0b8: getstatic x/oc9755810e45.ҩ Lx/oc4557683e94;
      // 0bb: ifnull 0e9
      // 0be: goto 0c2
      // 0c1: athrow
      // 0c2: getstatic x/oc9755810e45.ҩ Lx/oc4557683e94;
      // 0c5: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 0c8: iload 1
      // 0c9: ifne 0ea
      // 0cc: goto 0d0
      // 0cf: athrow
      // 0d0: ifeq 0e9
      // 0d3: goto 0d7
      // 0d6: athrow
      // 0d7: invokestatic x/oc4557683e94.Ǻ ()Z
      // 0da: iload 1
      // 0db: ifne 0ea
      // 0de: goto 0e2
      // 0e1: athrow
      // 0e2: ifne 0ed
      // 0e5: goto 0e9
      // 0e8: athrow
      // 0e9: bipush 1
      // 0ea: goto 0ee
      // 0ed: bipush 0
      // 0ee: istore 2
      // 0ef: aload 0
      // 0f0: iload 1
      // 0f1: ifne 133
      // 0f4: getfield x/oc865980c948.Ȁ Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0f7: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isUsingItem ()Z
      // 0fa: ifeq 132
      // 0fd: goto 101
      // 100: athrow
      // 101: aload 0
      // 102: iload 1
      // 103: ifne 133
      // 106: goto 10a
      // 109: athrow
      // 10a: getfield x/oc865980c948.ə Lnet/minecraft/entity/Entity;
      // 10d: ifnonnull 132
      // 110: goto 114
      // 113: athrow
      // 114: invokestatic x/oc4557683e94.Ҳ ()F
      // 117: fstore 3
      // 118: aload 0
      // 119: getfield x/oc865980c948.Ŗ Lnet/minecraft/util/MovementInput;
      // 11c: dup
      // 11d: getfield net/minecraft/util/MovementInput.moveStrafe F
      // 120: fload 3
      // 121: fmul
      // 122: putfield net/minecraft/util/MovementInput.moveStrafe F
      // 125: aload 0
      // 126: getfield x/oc865980c948.Ŗ Lnet/minecraft/util/MovementInput;
      // 129: dup
      // 12a: getfield net/minecraft/util/MovementInput.moveForward F
      // 12d: fload 3
      // 12e: fmul
      // 12f: putfield net/minecraft/util/MovementInput.moveForward F
      // 132: aload 0
      // 133: getfield x/oc865980c948.Ҵ Lnet/minecraft/util/FoodStats;
      // 136: invokevirtual net/minecraft/util/FoodStats.getFoodLevel ()I
      // 139: istore 3
      // 13a: iload 3
      // 13b: iload 1
      // 13c: ifne 164
      // 13f: ldc_w -1041546673
      // 142: ldc_w -1041546679
      // 145: ixor
      // 146: if_icmpgt 163
      // 149: goto 14d
      // 14c: athrow
      // 14d: aload 0
      // 14e: getfield x/oc865980c948.Η Lnet/minecraft/entity/player/PlayerCapabilities;
      // 151: getfield net/minecraft/entity/player/PlayerCapabilities.allowFlying Z
      // 154: iload 1
      // 155: ifne 164
      // 158: goto 15c
      // 15b: athrow
      // 15c: ifeq 167
      // 15f: goto 163
      // 162: athrow
      // 163: bipush 1
      // 164: goto 168
      // 167: bipush 0
      // 168: istore 4
      // 16a: aload 0
      // 16b: getstatic net/minecraft/potion/Potion.blindness Lnet/minecraft/potion/Potion;
      // 16e: invokevirtual x/oc865980c948.ϱ (Lnet/minecraft/potion/Potion;)Z
      // 171: istore 5
      // 173: aload 0
      // 174: iload 1
      // 175: ifne 23e
      // 178: getfield x/oc865980c948.ƨ Z
      // 17b: ifeq 23d
      // 17e: goto 182
      // 181: athrow
      // 182: aload 0
      // 183: getfield x/oc865980c948.Ŗ Lnet/minecraft/util/MovementInput;
      // 186: iload 1
      // 187: ifne 249
      // 18a: goto 18e
      // 18d: athrow
      // 18e: getfield net/minecraft/util/MovementInput.sneak Z
      // 191: ifne 23d
      // 194: goto 198
      // 197: athrow
      // 198: aload 0
      // 199: iload 1
      // 19a: ifne 23e
      // 19d: goto 1a1
      // 1a0: athrow
      // 1a1: getfield x/oc865980c948.ӕ Z
      // 1a4: ifeq 23d
      // 1a7: goto 1ab
      // 1aa: athrow
      // 1ab: aload 0
      // 1ac: iload 1
      // 1ad: ifne 23e
      // 1b0: goto 1b4
      // 1b3: athrow
      // 1b4: getfield x/oc865980c948.ǡ Z
      // 1b7: ifne 23d
      // 1ba: goto 1be
      // 1bd: athrow
      // 1be: aload 0
      // 1bf: getfield x/oc865980c948.Ŗ Lnet/minecraft/util/MovementInput;
      // 1c2: getfield net/minecraft/util/MovementInput.moveForward F
      // 1c5: ldc_w 0.8
      // 1c8: fcmpl
      // 1c9: iload 1
      // 1ca: ifne 1f6
      // 1cd: goto 1d1
      // 1d0: athrow
      // 1d1: ifge 1f0
      // 1d4: goto 1d8
      // 1d7: athrow
      // 1d8: aload 0
      // 1d9: getfield x/oc865980c948.Ŗ Lnet/minecraft/util/MovementInput;
      // 1dc: iload 1
      // 1dd: ifne 249
      // 1e0: goto 1e4
      // 1e3: athrow
      // 1e4: getfield net/minecraft/util/MovementInput.moveStrafe F
      // 1e7: fconst_0
      // 1e8: fcmpl
      // 1e9: ifeq 23d
      // 1ec: goto 1f0
      // 1ef: athrow
      // 1f0: iload 4
      // 1f2: goto 1f6
      // 1f5: athrow
      // 1f6: iload 1
      // 1f7: ifne 24c
      // 1fa: ifeq 23d
      // 1fd: goto 201
      // 200: athrow
      // 201: aload 0
      // 202: getfield x/oc865980c948.Ȁ Lnet/minecraft/client/entity/EntityPlayerSP;
      // 205: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isUsingItem ()Z
      // 208: iload 1
      // 209: ifne 229
      // 20c: goto 210
      // 20f: athrow
      // 210: ifeq 227
      // 213: goto 217
      // 216: athrow
      // 217: iload 2
      // 218: iload 1
      // 219: ifne 24c
      // 21c: goto 220
      // 21f: athrow
      // 220: ifne 23d
      // 223: goto 227
      // 226: athrow
      // 227: iload 5
      // 229: iload 1
      // 22a: ifne 24c
      // 22d: ifne 23d
      // 230: goto 234
      // 233: athrow
      // 234: aload 0
      // 235: bipush 1
      // 236: invokevirtual x/oc865980c948.i (Z)V
      // 239: goto 23d
      // 23c: athrow
      // 23d: aload 0
      // 23e: iload 1
      // 23f: ifne 259
      // 242: getfield x/oc865980c948.Ŗ Lnet/minecraft/util/MovementInput;
      // 245: goto 249
      // 248: athrow
      // 249: getfield net/minecraft/util/MovementInput.sneak Z
      // 24c: ifeq 258
      // 24f: aload 0
      // 250: bipush 0
      // 251: invokevirtual x/oc865980c948.i (Z)V
      // 254: goto 258
      // 257: athrow
      // 258: aload 0
      // 259: iload 1
      // 25a: ifne 2df
      // 25d: invokevirtual x/oc865980c948.Í ()Z
      // 260: ifeq 2de
      // 263: goto 267
      // 266: athrow
      // 267: aload 0
      // 268: iload 1
      // 269: ifne 2da
      // 26c: goto 270
      // 26f: athrow
      // 270: getfield x/oc865980c948.Ŗ Lnet/minecraft/util/MovementInput;
      // 273: getfield net/minecraft/util/MovementInput.moveForward F
      // 276: fconst_0
      // 277: fcmpg
      // 278: ifle 2d5
      // 27b: goto 27f
      // 27e: athrow
      // 27f: aload 0
      // 280: iload 1
      // 281: ifne 2da
      // 284: goto 288
      // 287: athrow
      // 288: getfield x/oc865980c948.Ŗ Lnet/minecraft/util/MovementInput;
      // 28b: getfield net/minecraft/util/MovementInput.sneak Z
      // 28e: ifne 2d5
      // 291: goto 295
      // 294: athrow
      // 295: aload 0
      // 296: iload 1
      // 297: ifne 2da
      // 29a: goto 29e
      // 29d: athrow
      // 29e: getfield x/oc865980c948.ǡ Z
      // 2a1: ifne 2d5
      // 2a4: goto 2a8
      // 2a7: athrow
      // 2a8: iload 3
      // 2a9: iload 1
      // 2aa: ifne 2ed
      // 2ad: goto 2b1
      // 2b0: athrow
      // 2b1: ldc_w -1041546673
      // 2b4: ldc_w -1041546679
      // 2b7: ixor
      // 2b8: if_icmpgt 2de
      // 2bb: goto 2bf
      // 2be: athrow
      // 2bf: aload 0
      // 2c0: getfield x/oc865980c948.Η Lnet/minecraft/entity/player/PlayerCapabilities;
      // 2c3: iload 1
      // 2c4: ifne 2e2
      // 2c7: goto 2cb
      // 2ca: athrow
      // 2cb: getfield net/minecraft/entity/player/PlayerCapabilities.allowFlying Z
      // 2ce: ifne 2de
      // 2d1: goto 2d5
      // 2d4: athrow
      // 2d5: aload 0
      // 2d6: goto 2da
      // 2d9: athrow
      // 2da: bipush 0
      // 2db: invokevirtual x/oc865980c948.i (Z)V
      // 2de: aload 0
      // 2df: getfield x/oc865980c948.Η Lnet/minecraft/entity/player/PlayerCapabilities;
      // 2e2: iload 1
      // 2e3: ifne 336
      // 2e6: getfield net/minecraft/entity/player/PlayerCapabilities.allowFlying Z
      // 2e9: goto 2ed
      // 2ec: athrow
      // 2ed: ifeq 32a
      // 2f0: getstatic x/oc865980c948.ʖ Lnet/minecraft/client/Minecraft;
      // 2f3: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 2f6: invokevirtual net/minecraft/client/multiplayer/PlayerControllerMP.isSpectatorMode ()Z
      // 2f9: iload 1
      // 2fa: ifne 339
      // 2fd: goto 301
      // 300: athrow
      // 301: ifeq 32a
      // 304: goto 308
      // 307: athrow
      // 308: aload 0
      // 309: iload 1
      // 30a: ifne 32b
      // 30d: goto 311
      // 310: athrow
      // 311: getfield x/oc865980c948.Η Lnet/minecraft/entity/player/PlayerCapabilities;
      // 314: getfield net/minecraft/entity/player/PlayerCapabilities.isFlying Z
      // 317: ifne 32a
      // 31a: goto 31e
      // 31d: athrow
      // 31e: aload 0
      // 31f: getfield x/oc865980c948.Η Lnet/minecraft/entity/player/PlayerCapabilities;
      // 322: bipush 1
      // 323: putfield net/minecraft/entity/player/PlayerCapabilities.isFlying Z
      // 326: goto 32a
      // 329: athrow
      // 32a: aload 0
      // 32b: iload 1
      // 32c: ifne 397
      // 32f: getfield x/oc865980c948.Η Lnet/minecraft/entity/player/PlayerCapabilities;
      // 332: goto 336
      // 335: athrow
      // 336: getfield net/minecraft/entity/player/PlayerCapabilities.isFlying Z
      // 339: ifeq 396
      // 33c: aload 0
      // 33d: getfield x/oc865980c948.Ŗ Lnet/minecraft/util/MovementInput;
      // 340: iload 1
      // 341: ifne 377
      // 344: goto 348
      // 347: athrow
      // 348: getfield net/minecraft/util/MovementInput.sneak Z
      // 34b: ifeq 36b
      // 34e: goto 352
      // 351: athrow
      // 352: aload 0
      // 353: dup
      // 354: getfield x/oc865980c948.Մ D
      // 357: aload 0
      // 358: getfield x/oc865980c948.Η Lnet/minecraft/entity/player/PlayerCapabilities;
      // 35b: invokevirtual net/minecraft/entity/player/PlayerCapabilities.getFlySpeed ()F
      // 35e: ldc_w 3.0
      // 361: fmul
      // 362: f2d
      // 363: dsub
      // 364: putfield x/oc865980c948.Մ D
      // 367: goto 36b
      // 36a: athrow
      // 36b: aload 0
      // 36c: iload 1
      // 36d: ifne 397
      // 370: getfield x/oc865980c948.Ŗ Lnet/minecraft/util/MovementInput;
      // 373: goto 377
      // 376: athrow
      // 377: getfield net/minecraft/util/MovementInput.jump Z
      // 37a: ifeq 396
      // 37d: aload 0
      // 37e: dup
      // 37f: getfield x/oc865980c948.Մ D
      // 382: aload 0
      // 383: getfield x/oc865980c948.Η Lnet/minecraft/entity/player/PlayerCapabilities;
      // 386: invokevirtual net/minecraft/entity/player/PlayerCapabilities.getFlySpeed ()F
      // 389: ldc_w 3.0
      // 38c: fmul
      // 38d: f2d
      // 38e: dadd
      // 38f: putfield x/oc865980c948.Մ D
      // 392: goto 396
      // 395: athrow
      // 396: aload 0
      // 397: invokevirtual x/oc865980c948.Ǝ ()V
      // 39a: return
   }

   private void ē(boolean param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc166ec60a37.ȗ Z
      // 03: istore 2
      // 04: iload 1
      // 05: iload 2
      // 06: ifne 28
      // 09: ifne 38
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 0
      // 11: aload 0
      // 12: getfield x/oc865980c948.ɋ Z
      // 15: putfield x/oc865980c948.ͳ Z
      // 18: iload 2
      // 19: ifne 34
      // 1c: goto 20
      // 1f: athrow
      // 20: aload 0
      // 21: getfield x/oc865980c948.ɋ Z
      // 24: goto 28
      // 27: athrow
      // 28: ifeq 40
      // 2b: aload 0
      // 2c: bipush 0
      // 2d: putfield x/oc865980c948.ӕ Z
      // 30: goto 34
      // 33: athrow
      // 34: iload 2
      // 35: ifeq 40
      // 38: aload 0
      // 39: invokevirtual x/oc865980c948.ԛ ()V
      // 3c: goto 40
      // 3f: athrow
      // 40: return
   }

   private void Ǝ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc166ec60a37.ȗ Z
      // 003: istore 1
      // 004: aload 0
      // 005: iload 1
      // 006: ifne 022
      // 009: getfield x/oc865980c948.լ I
      // 00c: ifle 021
      // 00f: goto 013
      // 012: athrow
      // 013: aload 0
      // 014: dup
      // 015: getfield x/oc865980c948.լ I
      // 018: bipush 1
      // 019: isub
      // 01a: putfield x/oc865980c948.լ I
      // 01d: goto 021
      // 020: athrow
      // 021: aload 0
      // 022: getfield x/oc865980c948.μ D
      // 025: iload 1
      // 026: ifne 04f
      // 029: invokestatic java/lang/Math.abs (D)D
      // 02c: ldc2_w 0.005
      // 02f: dcmpg
      // 030: ifge 040
      // 033: goto 037
      // 036: athrow
      // 037: aload 0
      // 038: dconst_0
      // 039: putfield x/oc865980c948.μ D
      // 03c: goto 040
      // 03f: athrow
      // 040: aload 0
      // 041: iload 1
      // 042: ifne 060
      // 045: getfield x/oc865980c948.Մ D
      // 048: invokestatic java/lang/Math.abs (D)D
      // 04b: goto 04f
      // 04e: athrow
      // 04f: ldc2_w 0.005
      // 052: dcmpg
      // 053: ifge 05f
      // 056: aload 0
      // 057: dconst_0
      // 058: putfield x/oc865980c948.Մ D
      // 05b: goto 05f
      // 05e: athrow
      // 05f: aload 0
      // 060: iload 1
      // 061: ifne 07f
      // 064: getfield x/oc865980c948.τ D
      // 067: invokestatic java/lang/Math.abs (D)D
      // 06a: ldc2_w 0.005
      // 06d: dcmpg
      // 06e: ifge 07e
      // 071: goto 075
      // 074: athrow
      // 075: aload 0
      // 076: dconst_0
      // 077: putfield x/oc865980c948.τ D
      // 07a: goto 07e
      // 07d: athrow
      // 07e: aload 0
      // 07f: iload 1
      // 080: ifne 0a9
      // 083: invokevirtual x/oc865980c948.ώ ()Z
      // 086: ifeq 0a4
      // 089: goto 08d
      // 08c: athrow
      // 08d: aload 0
      // 08e: bipush 0
      // 08f: putfield x/oc865980c948.Ы Z
      // 092: iload 1
      // 093: aload 0
      // 094: fconst_0
      // 095: putfield x/oc865980c948.ȹ F
      // 098: aload 0
      // 099: fconst_0
      // 09a: putfield x/oc865980c948.ȸ F
      // 09d: ifeq 0bf
      // 0a0: goto 0a4
      // 0a3: athrow
      // 0a4: aload 0
      // 0a5: goto 0a9
      // 0a8: athrow
      // 0a9: iload 1
      // 0aa: ifne 0c0
      // 0ad: invokevirtual x/oc865980c948.Ȋ ()Z
      // 0b0: ifeq 0bf
      // 0b3: goto 0b7
      // 0b6: athrow
      // 0b7: aload 0
      // 0b8: invokevirtual x/oc865980c948.ů ()V
      // 0bb: goto 0bf
      // 0be: athrow
      // 0bf: aload 0
      // 0c0: iload 1
      // 0c1: ifne 137
      // 0c4: getfield x/oc865980c948.Ы Z
      // 0c7: ifeq 132
      // 0ca: goto 0ce
      // 0cd: athrow
      // 0ce: aload 0
      // 0cf: iload 1
      // 0d0: ifne 0f9
      // 0d3: goto 0d7
      // 0d6: athrow
      // 0d7: invokevirtual x/oc865980c948.ΰ ()Z
      // 0da: ifne 0f4
      // 0dd: goto 0e1
      // 0e0: athrow
      // 0e1: aload 0
      // 0e2: iload 1
      // 0e3: ifne 105
      // 0e6: goto 0ea
      // 0e9: athrow
      // 0ea: invokevirtual x/oc865980c948.â ()Z
      // 0ed: ifeq 100
      // 0f0: goto 0f4
      // 0f3: athrow
      // 0f4: aload 0
      // 0f5: goto 0f9
      // 0f8: athrow
      // 0f9: invokevirtual x/oc865980c948.ǚ ()V
      // 0fc: iload 1
      // 0fd: ifeq 13b
      // 100: aload 0
      // 101: goto 105
      // 104: athrow
      // 105: iload 1
      // 106: ifne 16e
      // 109: getfield x/oc865980c948.ӕ Z
      // 10c: ifeq 13b
      // 10f: goto 113
      // 112: athrow
      // 113: aload 0
      // 114: iload 1
      // 115: ifne 16e
      // 118: goto 11c
      // 11b: athrow
      // 11c: getfield x/oc865980c948.լ I
      // 11f: ifne 13b
      // 122: goto 126
      // 125: athrow
      // 126: aload 0
      // 127: invokevirtual x/oc865980c948.ƌ ()V
      // 12a: iload 1
      // 12b: ifeq 13b
      // 12e: goto 132
      // 131: athrow
      // 132: aload 0
      // 133: goto 137
      // 136: athrow
      // 137: bipush 0
      // 138: putfield x/oc865980c948.լ I
      // 13b: aload 0
      // 13c: dup
      // 13d: getfield x/oc865980c948.ȹ F
      // 140: ldc_w 0.98
      // 143: fmul
      // 144: putfield x/oc865980c948.ȹ F
      // 147: aload 0
      // 148: iload 1
      // 149: ifne 187
      // 14c: dup
      // 14d: getfield x/oc865980c948.ȸ F
      // 150: ldc_w 0.98
      // 153: fmul
      // 154: putfield x/oc865980c948.ȸ F
      // 157: aload 0
      // 158: aload 0
      // 159: getfield x/oc865980c948.ȹ F
      // 15c: aload 0
      // 15d: getfield x/oc865980c948.ȸ F
      // 160: invokevirtual x/oc865980c948.ť (FF)V
      // 163: aload 0
      // 164: ldc 0.02
      // 166: putfield x/oc865980c948.Խ F
      // 169: aload 0
      // 16a: goto 16e
      // 16d: athrow
      // 16e: invokevirtual x/oc865980c948.Í ()Z
      // 171: ifeq 186
      // 174: aload 0
      // 175: aload 0
      // 176: getfield x/oc865980c948.Խ F
      // 179: f2d
      // 17a: ldc2_w 0.005999999865889549
      // 17d: dadd
      // 17e: d2f
      // 17f: putfield x/oc865980c948.Խ F
      // 182: goto 186
      // 185: athrow
      // 186: aload 0
      // 187: iload 1
      // 188: ifne 19a
      // 18b: getfield x/oc865980c948.ӕ Z
      // 18e: ifeq 1ca
      // 191: goto 195
      // 194: athrow
      // 195: aload 0
      // 196: goto 19a
      // 199: athrow
      // 19a: iload 1
      // 19b: ifne 1b0
      // 19e: getfield x/oc865980c948.Η Lnet/minecraft/entity/player/PlayerCapabilities;
      // 1a1: getfield net/minecraft/entity/player/PlayerCapabilities.isFlying Z
      // 1a4: ifeq 1ca
      // 1a7: goto 1ab
      // 1aa: athrow
      // 1ab: aload 0
      // 1ac: goto 1b0
      // 1af: athrow
      // 1b0: iload 1
      // 1b1: ifne 1c3
      // 1b4: getfield x/oc865980c948.ɋ Z
      // 1b7: ifne 1ca
      // 1ba: goto 1be
      // 1bd: athrow
      // 1be: aload 0
      // 1bf: goto 1c3
      // 1c2: athrow
      // 1c3: getfield x/oc865980c948.Η Lnet/minecraft/entity/player/PlayerCapabilities;
      // 1c6: bipush 0
      // 1c7: putfield net/minecraft/entity/player/PlayerCapabilities.isFlying Z
      // 1ca: return
   }

   private void ԛ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc166ec60a37.ȗ Z
      // 03: aload 0
      // 04: getfield x/oc865980c948.б D
      // 07: ldc2_w -2.9999999E7
      // 0a: ldc2_w 2.9999999E7
      // 0d: invokestatic net/minecraft/util/MathHelper.clamp_double (DDD)D
      // 10: dstore 2
      // 11: istore 1
      // 12: aload 0
      // 13: getfield x/oc865980c948.ҟ D
      // 16: ldc2_w -2.9999999E7
      // 19: ldc2_w 2.9999999E7
      // 1c: invokestatic net/minecraft/util/MathHelper.clamp_double (DDD)D
      // 1f: dstore 4
      // 21: dload 2
      // 22: aload 0
      // 23: iload 1
      // 24: ifne 39
      // 27: getfield x/oc865980c948.б D
      // 2a: dcmpl
      // 2b: ifne 40
      // 2e: goto 32
      // 31: athrow
      // 32: dload 4
      // 34: aload 0
      // 35: goto 39
      // 38: athrow
      // 39: getfield x/oc865980c948.ҟ D
      // 3c: dcmpl
      // 3d: ifeq 4f
      // 40: aload 0
      // 41: dload 2
      // 42: aload 0
      // 43: getfield x/oc865980c948.ъ D
      // 46: dload 4
      // 48: invokevirtual x/oc865980c948.ҙ (DDD)V
      // 4b: goto 4f
      // 4e: athrow
      // 4f: return
   }

   private void ҙ(double var1, double var3, double var5) {
      this.б = var1;
      this.ъ = var3;
      this.ҟ = var5;
      float var7 = this.Ǽ / 2.0F;
      float var8 = this.ԋ;
      this.Ѣ(new AxisAlignedBB(var1 - var7, var3, var5 - var7, var1 + var7, var3 + var8, var5 + var7));
   }

   private void i(boolean var1) {
      this.ǝ = var1;
   }

   public void ʶ(boolean var1) {
      this.ƨ = var1;
   }

   public void й(double param1, double param3, double param5, boolean param7) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 0
      // 01: dload 1
      // 02: dload 3
      // 03: dload 5
      // 05: invokevirtual x/oc865980c948.ҙ (DDD)V
      // 08: aload 0
      // 09: dconst_0
      // 0a: putfield x/oc865980c948.μ D
      // 0d: aload 0
      // 0e: dconst_0
      // 0f: putfield x/oc865980c948.Մ D
      // 12: getstatic x/oc166ec60a37.ȗ Z
      // 15: aload 0
      // 16: dconst_0
      // 17: putfield x/oc865980c948.τ D
      // 1a: istore 8
      // 1c: aload 0
      // 1d: iload 7
      // 1f: iload 8
      // 21: ifne 36
      // 24: putfield x/oc865980c948.ӕ Z
      // 27: aload 0
      // 28: iload 7
      // 2a: ifne 39
      // 2d: goto 31
      // 30: athrow
      // 31: bipush 1
      // 32: goto 36
      // 35: athrow
      // 36: goto 3a
      // 39: bipush 0
      // 3a: putfield x/oc865980c948.ɟ Z
      // 3d: aload 0
      // 3e: bipush 0
      // 3f: putfield x/oc865980c948.ϡ Z
      // 42: aload 0
      // 43: bipush 0
      // 44: putfield x/oc865980c948.ǡ Z
      // 47: aload 0
      // 48: iload 7
      // 4a: putfield x/oc865980c948.ɑ Z
      // 4d: aload 0
      // 4e: fconst_0
      // 4f: putfield x/oc865980c948.Ó F
      // 52: aload 0
      // 53: bipush 0
      // 54: putfield x/oc865980c948.լ I
      // 57: aload 0
      // 58: bipush 0
      // 59: putfield x/oc865980c948.ћ Z
      // 5c: aload 0
      // 5d: bipush 0
      // 5e: putfield x/oc865980c948.ȼ Z
      // 61: aload 0
      // 62: bipush 0
      // 63: putfield x/oc865980c948.ǝ Z
      // 66: aload 0
      // 67: bipush 0
      // 68: putfield x/oc865980c948.ƨ Z
      // 6b: aload 0
      // 6c: getfield x/oc865980c948.Ŗ Lnet/minecraft/util/MovementInput;
      // 6f: fconst_0
      // 70: putfield net/minecraft/util/MovementInput.moveForward F
      // 73: aload 0
      // 74: getfield x/oc865980c948.Ŗ Lnet/minecraft/util/MovementInput;
      // 77: fconst_0
      // 78: putfield net/minecraft/util/MovementInput.moveStrafe F
      // 7b: aload 0
      // 7c: getfield x/oc865980c948.Ŗ Lnet/minecraft/util/MovementInput;
      // 7f: bipush 0
      // 80: putfield net/minecraft/util/MovementInput.jump Z
      // 83: aload 0
      // 84: getfield x/oc865980c948.Ŗ Lnet/minecraft/util/MovementInput;
      // 87: bipush 0
      // 88: putfield net/minecraft/util/MovementInput.sneak Z
      // 8b: return
   }

   private boolean Λ(double param1, double param3, double param5) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc166ec60a37.ȗ Z
      // 003: istore 7
      // 005: aload 0
      // 006: getfield x/oc865980c948.ͳ Z
      // 009: iload 7
      // 00b: ifne 016
      // 00e: ifeq 017
      // 011: goto 015
      // 014: athrow
      // 015: bipush 0
      // 016: ireturn
      // 017: new net/minecraft/util/BlockPos
      // 01a: dup
      // 01b: dload 1
      // 01c: dload 3
      // 01d: dload 5
      // 01f: invokespecial net/minecraft/util/BlockPos.<init> (DDD)V
      // 022: astore 8
      // 024: dload 1
      // 025: aload 8
      // 027: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 02a: i2d
      // 02b: dsub
      // 02c: dstore 9
      // 02e: dload 5
      // 030: aload 8
      // 032: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 035: i2d
      // 036: dsub
      // 037: dstore 11
      // 039: aload 0
      // 03a: getfield x/oc865980c948.ԋ F
      // 03d: f2d
      // 03e: invokestatic java/lang/Math.ceil (D)D
      // 041: d2i
      // 042: istore 13
      // 044: aload 0
      // 045: aload 8
      // 047: iload 13
      // 049: invokevirtual x/oc865980c948.ӗ (Lnet/minecraft/util/BlockPos;I)Z
      // 04c: iload 7
      // 04e: ifne 059
      // 051: ifne 05c
      // 054: goto 058
      // 057: athrow
      // 058: bipush 1
      // 059: goto 05d
      // 05c: bipush 0
      // 05d: istore 14
      // 05f: iload 14
      // 061: iload 7
      // 063: ifne 1ca
      // 066: ifeq 1c9
      // 069: goto 06d
      // 06c: athrow
      // 06d: bipush -1
      // 06e: istore 15
      // 070: ldc2_w 9999.0
      // 073: dstore 16
      // 075: aload 0
      // 076: aload 8
      // 078: invokevirtual net/minecraft/util/BlockPos.west ()Lnet/minecraft/util/BlockPos;
      // 07b: iload 13
      // 07d: iload 7
      // 07f: ifne 0b0
      // 082: invokevirtual x/oc865980c948.ӗ (Lnet/minecraft/util/BlockPos;I)Z
      // 085: ifeq 0a8
      // 088: goto 08c
      // 08b: athrow
      // 08c: dload 9
      // 08e: dload 16
      // 090: dcmpg
      // 091: iload 7
      // 093: ifne 0bc
      // 096: goto 09a
      // 099: athrow
      // 09a: ifge 0a8
      // 09d: goto 0a1
      // 0a0: athrow
      // 0a1: dload 9
      // 0a3: dstore 16
      // 0a5: bipush 0
      // 0a6: istore 15
      // 0a8: aload 0
      // 0a9: aload 8
      // 0ab: invokevirtual net/minecraft/util/BlockPos.east ()Lnet/minecraft/util/BlockPos;
      // 0ae: iload 13
      // 0b0: iload 7
      // 0b2: ifne 0f0
      // 0b5: invokevirtual x/oc865980c948.ӗ (Lnet/minecraft/util/BlockPos;I)Z
      // 0b8: goto 0bc
      // 0bb: athrow
      // 0bc: ifeq 0df
      // 0bf: dconst_1
      // 0c0: dload 9
      // 0c2: dsub
      // 0c3: dload 16
      // 0c5: dcmpg
      // 0c6: iload 7
      // 0c8: ifne 0f3
      // 0cb: goto 0cf
      // 0ce: athrow
      // 0cf: ifge 0df
      // 0d2: goto 0d6
      // 0d5: athrow
      // 0d6: dconst_1
      // 0d7: dload 9
      // 0d9: dsub
      // 0da: dstore 16
      // 0dc: bipush 1
      // 0dd: istore 15
      // 0df: aload 0
      // 0e0: aload 8
      // 0e2: invokevirtual net/minecraft/util/BlockPos.north ()Lnet/minecraft/util/BlockPos;
      // 0e5: iload 7
      // 0e7: ifne 11e
      // 0ea: iload 13
      // 0ec: goto 0f0
      // 0ef: athrow
      // 0f0: invokevirtual x/oc865980c948.ӗ (Lnet/minecraft/util/BlockPos;I)Z
      // 0f3: ifeq 118
      // 0f6: dload 11
      // 0f8: dload 16
      // 0fa: dcmpg
      // 0fb: iload 7
      // 0fd: ifne 123
      // 100: goto 104
      // 103: athrow
      // 104: ifge 118
      // 107: goto 10b
      // 10a: athrow
      // 10b: dload 11
      // 10d: dstore 16
      // 10f: ldc_w 1705378288
      // 112: ldc_w 1705378292
      // 115: ixor
      // 116: istore 15
      // 118: aload 0
      // 119: aload 8
      // 11b: invokevirtual net/minecraft/util/BlockPos.south ()Lnet/minecraft/util/BlockPos;
      // 11e: iload 13
      // 120: invokevirtual x/oc865980c948.ӗ (Lnet/minecraft/util/BlockPos;I)Z
      // 123: iload 7
      // 125: ifne 13a
      // 128: ifeq 14f
      // 12b: goto 12f
      // 12e: athrow
      // 12f: dconst_1
      // 130: dload 11
      // 132: dsub
      // 133: dload 16
      // 135: dcmpg
      // 136: goto 13a
      // 139: athrow
      // 13a: iload 7
      // 13c: ifne 14d
      // 13f: ifge 14f
      // 142: goto 146
      // 145: athrow
      // 146: ldc_w 1705378289
      // 149: ldc_w 1705378292
      // 14c: ixor
      // 14d: istore 15
      // 14f: ldc_w 0.1
      // 152: fstore 18
      // 154: iload 15
      // 156: iload 7
      // 158: ifne 170
      // 15b: ifne 16e
      // 15e: goto 162
      // 161: athrow
      // 162: aload 0
      // 163: fload 18
      // 165: fneg
      // 166: f2d
      // 167: putfield x/oc865980c948.μ D
      // 16a: goto 16e
      // 16d: athrow
      // 16e: iload 15
      // 170: iload 7
      // 172: ifne 18a
      // 175: bipush 1
      // 176: if_icmpne 188
      // 179: goto 17d
      // 17c: athrow
      // 17d: aload 0
      // 17e: fload 18
      // 180: f2d
      // 181: putfield x/oc865980c948.μ D
      // 184: goto 188
      // 187: athrow
      // 188: iload 15
      // 18a: iload 7
      // 18c: ifne 1ab
      // 18f: ldc_w 1705378288
      // 192: ldc_w 1705378292
      // 195: ixor
      // 196: if_icmpne 1a9
      // 199: goto 19d
      // 19c: athrow
      // 19d: aload 0
      // 19e: fload 18
      // 1a0: fneg
      // 1a1: f2d
      // 1a2: putfield x/oc865980c948.τ D
      // 1a5: goto 1a9
      // 1a8: athrow
      // 1a9: iload 15
      // 1ab: iload 7
      // 1ad: ifne 1ca
      // 1b0: ldc_w 1705378289
      // 1b3: ldc_w 1705378292
      // 1b6: ixor
      // 1b7: if_icmpne 1c9
      // 1ba: goto 1be
      // 1bd: athrow
      // 1be: aload 0
      // 1bf: fload 18
      // 1c1: f2d
      // 1c2: putfield x/oc865980c948.τ D
      // 1c5: goto 1c9
      // 1c8: athrow
      // 1c9: bipush 0
      // 1ca: ireturn
   }

   private boolean ӗ(BlockPos param1, int param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc166ec60a37.ȗ Z
      // 03: bipush 0
      // 04: istore 4
      // 06: istore 3
      // 07: iload 4
      // 09: iload 2
      // 0a: if_icmpge 35
      // 0d: aload 0
      // 0e: aload 1
      // 0f: bipush 0
      // 10: iload 4
      // 12: bipush 0
      // 13: invokevirtual net/minecraft/util/BlockPos.add (III)Lnet/minecraft/util/BlockPos;
      // 16: invokevirtual x/oc865980c948.ϳ (Lnet/minecraft/util/BlockPos;)Z
      // 19: iload 3
      // 1a: ifne 36
      // 1d: iload 3
      // 1e: ifne 2d
      // 21: goto 25
      // 24: athrow
      // 25: ifne 2e
      // 28: goto 2c
      // 2b: athrow
      // 2c: bipush 0
      // 2d: ireturn
      // 2e: iinc 4 1
      // 31: iload 3
      // 32: ifeq 07
      // 35: bipush 1
      // 36: ireturn
   }

   private boolean ϳ(BlockPos var1) {
      return this.ո(var1).getBlock().isNormalCube();
   }

   private void ť(float param1, float param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc166ec60a37.ȗ Z
      // 03: istore 3
      // 04: aload 0
      // 05: iload 3
      // 06: ifne 7b
      // 09: getfield x/oc865980c948.Η Lnet/minecraft/entity/player/PlayerCapabilities;
      // 0c: getfield net/minecraft/entity/player/PlayerCapabilities.isFlying Z
      // 0f: ifeq 76
      // 12: goto 16
      // 15: athrow
      // 16: aload 0
      // 17: iload 3
      // 18: ifne 7b
      // 1b: goto 1f
      // 1e: athrow
      // 1f: getfield x/oc865980c948.ə Lnet/minecraft/entity/Entity;
      // 22: ifnonnull 76
      // 25: goto 29
      // 28: athrow
      // 29: aload 0
      // 2a: getfield x/oc865980c948.Մ D
      // 2d: dstore 4
      // 2f: aload 0
      // 30: getfield x/oc865980c948.Խ F
      // 33: fstore 6
      // 35: aload 0
      // 36: aload 0
      // 37: getfield x/oc865980c948.Η Lnet/minecraft/entity/player/PlayerCapabilities;
      // 3a: invokevirtual net/minecraft/entity/player/PlayerCapabilities.getFlySpeed ()F
      // 3d: aload 0
      // 3e: invokevirtual x/oc865980c948.Í ()Z
      // 41: iload 3
      // 42: ifne 53
      // 45: ifeq 56
      // 48: goto 4c
      // 4b: athrow
      // 4c: ldc_w -2012514543
      // 4f: ldc_w -2012514541
      // 52: ixor
      // 53: goto 57
      // 56: bipush 1
      // 57: i2f
      // 58: fmul
      // 59: putfield x/oc865980c948.Խ F
      // 5c: iload 3
      // 5d: aload 0
      // 5e: fload 1
      // 5f: fload 2
      // 60: invokevirtual x/oc865980c948.ҡ (FF)V
      // 63: aload 0
      // 64: dload 4
      // 66: ldc2_w 0.6
      // 69: dmul
      // 6a: putfield x/oc865980c948.Մ D
      // 6d: aload 0
      // 6e: fload 6
      // 70: putfield x/oc865980c948.Խ F
      // 73: ifeq 80
      // 76: aload 0
      // 77: goto 7b
      // 7a: athrow
      // 7b: fload 1
      // 7c: fload 2
      // 7d: invokevirtual x/oc865980c948.ҡ (FF)V
      // 80: return
   }

   private void ҡ(float param1, float param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc166ec60a37.ȗ Z
      // 003: istore 3
      // 004: aload 0
      // 005: iload 3
      // 006: ifne 018
      // 009: invokevirtual x/oc865980c948.Ȋ ()Z
      // 00c: ifeq 463
      // 00f: goto 013
      // 012: athrow
      // 013: aload 0
      // 014: goto 018
      // 017: athrow
      // 018: iload 3
      // 019: ifne 041
      // 01c: invokevirtual x/oc865980c948.ΰ ()Z
      // 01f: ifeq 03c
      // 022: goto 026
      // 025: athrow
      // 026: aload 0
      // 027: iload 3
      // 028: ifne 35d
      // 02b: goto 02f
      // 02e: athrow
      // 02f: getfield x/oc865980c948.Η Lnet/minecraft/entity/player/PlayerCapabilities;
      // 032: getfield net/minecraft/entity/player/PlayerCapabilities.isFlying Z
      // 035: ifeq 358
      // 038: goto 03c
      // 03b: athrow
      // 03c: aload 0
      // 03d: goto 041
      // 040: athrow
      // 041: iload 3
      // 042: ifne 054
      // 045: invokevirtual x/oc865980c948.â ()Z
      // 048: ifeq 100
      // 04b: goto 04f
      // 04e: athrow
      // 04f: aload 0
      // 050: goto 054
      // 053: athrow
      // 054: iload 3
      // 055: ifne 06a
      // 058: getfield x/oc865980c948.Η Lnet/minecraft/entity/player/PlayerCapabilities;
      // 05b: getfield net/minecraft/entity/player/PlayerCapabilities.isFlying Z
      // 05e: ifne 100
      // 061: goto 065
      // 064: athrow
      // 065: aload 0
      // 066: goto 06a
      // 069: athrow
      // 06a: getfield x/oc865980c948.ъ D
      // 06d: dstore 4
      // 06f: aload 0
      // 070: fload 1
      // 071: fload 2
      // 072: ldc 0.02
      // 074: invokevirtual x/oc865980c948.Ѻ (FFF)V
      // 077: aload 0
      // 078: aload 0
      // 079: getfield x/oc865980c948.μ D
      // 07c: aload 0
      // 07d: getfield x/oc865980c948.Մ D
      // 080: aload 0
      // 081: getfield x/oc865980c948.τ D
      // 084: invokevirtual x/oc865980c948.ư (DDD)V
      // 087: aload 0
      // 088: dup
      // 089: getfield x/oc865980c948.μ D
      // 08c: ldc2_w 0.5
      // 08f: dmul
      // 090: putfield x/oc865980c948.μ D
      // 093: aload 0
      // 094: dup
      // 095: iload 3
      // 096: ifne 0d4
      // 099: getfield x/oc865980c948.Մ D
      // 09c: ldc2_w 0.5
      // 09f: dmul
      // 0a0: putfield x/oc865980c948.Մ D
      // 0a3: aload 0
      // 0a4: dup
      // 0a5: getfield x/oc865980c948.τ D
      // 0a8: ldc2_w 0.5
      // 0ab: dmul
      // 0ac: putfield x/oc865980c948.τ D
      // 0af: aload 0
      // 0b0: dup
      // 0b1: getfield x/oc865980c948.Մ D
      // 0b4: ldc2_w 0.02
      // 0b7: dsub
      // 0b8: putfield x/oc865980c948.Մ D
      // 0bb: aload 0
      // 0bc: getfield x/oc865980c948.ǡ Z
      // 0bf: ifeq 463
      // 0c2: goto 0c6
      // 0c5: athrow
      // 0c6: aload 0
      // 0c7: iload 3
      // 0c8: ifne 0f6
      // 0cb: goto 0cf
      // 0ce: athrow
      // 0cf: aload 0
      // 0d0: goto 0d4
      // 0d3: athrow
      // 0d4: getfield x/oc865980c948.μ D
      // 0d7: aload 0
      // 0d8: getfield x/oc865980c948.Մ D
      // 0db: ldc2_w 0.6000000238418579
      // 0de: dadd
      // 0df: aload 0
      // 0e0: getfield x/oc865980c948.ъ D
      // 0e3: dsub
      // 0e4: dload 4
      // 0e6: dadd
      // 0e7: aload 0
      // 0e8: getfield x/oc865980c948.τ D
      // 0eb: invokevirtual x/oc865980c948.ǡ (DDD)Z
      // 0ee: ifeq 463
      // 0f1: aload 0
      // 0f2: goto 0f6
      // 0f5: athrow
      // 0f6: ldc2_w 0.30000001192092896
      // 0f9: putfield x/oc865980c948.Մ D
      // 0fc: iload 3
      // 0fd: ifeq 463
      // 100: ldc_w 0.91
      // 103: fstore 9
      // 105: aload 0
      // 106: iload 3
      // 107: ifne 119
      // 10a: getfield x/oc865980c948.ӕ Z
      // 10d: ifeq 14e
      // 110: goto 114
      // 113: athrow
      // 114: aload 0
      // 115: goto 119
      // 118: athrow
      // 119: getfield x/oc865980c948.ƀ Lnet/minecraft/world/World;
      // 11c: new net/minecraft/util/BlockPos
      // 11f: dup
      // 120: aload 0
      // 121: getfield x/oc865980c948.б D
      // 124: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 127: aload 0
      // 128: invokevirtual x/oc865980c948.ш ()Lnet/minecraft/util/AxisAlignedBB;
      // 12b: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 12e: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 131: bipush 1
      // 132: isub
      // 133: aload 0
      // 134: getfield x/oc865980c948.ҟ D
      // 137: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 13a: invokespecial net/minecraft/util/BlockPos.<init> (III)V
      // 13d: invokevirtual net/minecraft/world/World.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 140: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 145: getfield net/minecraft/block/Block.slipperiness F
      // 148: ldc_w 0.91
      // 14b: fmul
      // 14c: fstore 9
      // 14e: ldc_w 0.16277136
      // 151: fload 9
      // 153: fload 9
      // 155: fmul
      // 156: fload 9
      // 158: fmul
      // 159: fdiv
      // 15a: fstore 10
      // 15c: aload 0
      // 15d: iload 3
      // 15e: ifne 177
      // 161: getfield x/oc865980c948.ӕ Z
      // 164: ifeq 176
      // 167: goto 16b
      // 16a: athrow
      // 16b: aload 0
      // 16c: invokevirtual x/oc865980c948.ϯ ()F
      // 16f: fload 10
      // 171: fmul
      // 172: goto 17a
      // 175: athrow
      // 176: aload 0
      // 177: getfield x/oc865980c948.Խ F
      // 17a: fstore 7
      // 17c: aload 0
      // 17d: fload 1
      // 17e: fload 2
      // 17f: fload 7
      // 181: invokevirtual x/oc865980c948.Ѻ (FFF)V
      // 184: ldc_w 0.91
      // 187: fstore 9
      // 189: aload 0
      // 18a: iload 3
      // 18b: ifne 1cf
      // 18e: getfield x/oc865980c948.ӕ Z
      // 191: ifeq 1ce
      // 194: goto 198
      // 197: athrow
      // 198: aload 0
      // 199: getfield x/oc865980c948.ƀ Lnet/minecraft/world/World;
      // 19c: new net/minecraft/util/BlockPos
      // 19f: dup
      // 1a0: aload 0
      // 1a1: getfield x/oc865980c948.б D
      // 1a4: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 1a7: aload 0
      // 1a8: invokevirtual x/oc865980c948.ш ()Lnet/minecraft/util/AxisAlignedBB;
      // 1ab: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 1ae: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 1b1: bipush 1
      // 1b2: isub
      // 1b3: aload 0
      // 1b4: getfield x/oc865980c948.ҟ D
      // 1b7: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 1ba: invokespecial net/minecraft/util/BlockPos.<init> (III)V
      // 1bd: invokevirtual net/minecraft/world/World.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 1c0: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 1c5: getfield net/minecraft/block/Block.slipperiness F
      // 1c8: ldc_w 0.91
      // 1cb: fmul
      // 1cc: fstore 9
      // 1ce: aload 0
      // 1cf: iload 3
      // 1d0: ifne 273
      // 1d3: invokevirtual x/oc865980c948.ϰ ()Z
      // 1d6: ifeq 25a
      // 1d9: goto 1dd
      // 1dc: athrow
      // 1dd: ldc_w 0.15
      // 1e0: fstore 8
      // 1e2: aload 0
      // 1e3: aload 0
      // 1e4: getfield x/oc865980c948.μ D
      // 1e7: fload 8
      // 1e9: fneg
      // 1ea: f2d
      // 1eb: fload 8
      // 1ed: f2d
      // 1ee: invokestatic net/minecraft/util/MathHelper.clamp_double (DDD)D
      // 1f1: putfield x/oc865980c948.μ D
      // 1f4: aload 0
      // 1f5: iload 3
      // 1f6: ifne 22a
      // 1f9: aload 0
      // 1fa: getfield x/oc865980c948.τ D
      // 1fd: fload 8
      // 1ff: fneg
      // 200: f2d
      // 201: fload 8
      // 203: f2d
      // 204: invokestatic net/minecraft/util/MathHelper.clamp_double (DDD)D
      // 207: putfield x/oc865980c948.τ D
      // 20a: aload 0
      // 20b: fconst_0
      // 20c: putfield x/oc865980c948.Ó F
      // 20f: aload 0
      // 210: getfield x/oc865980c948.Մ D
      // 213: ldc2_w -0.15
      // 216: dcmpg
      // 217: ifge 229
      // 21a: goto 21e
      // 21d: athrow
      // 21e: aload 0
      // 21f: ldc2_w -0.15
      // 222: putfield x/oc865980c948.Մ D
      // 225: goto 229
      // 228: athrow
      // 229: aload 0
      // 22a: invokevirtual x/oc865980c948.y ()Z
      // 22d: istore 11
      // 22f: iload 3
      // 230: ifne 272
      // 233: iload 11
      // 235: ifeq 25a
      // 238: goto 23c
      // 23b: athrow
      // 23c: aload 0
      // 23d: iload 3
      // 23e: ifne 273
      // 241: goto 245
      // 244: athrow
      // 245: getfield x/oc865980c948.Մ D
      // 248: dconst_0
      // 249: dcmpg
      // 24a: ifge 25a
      // 24d: goto 251
      // 250: athrow
      // 251: aload 0
      // 252: dconst_0
      // 253: putfield x/oc865980c948.Մ D
      // 256: goto 25a
      // 259: athrow
      // 25a: aload 0
      // 25b: iload 3
      // 25c: ifne 298
      // 25f: aload 0
      // 260: getfield x/oc865980c948.μ D
      // 263: aload 0
      // 264: getfield x/oc865980c948.Մ D
      // 267: aload 0
      // 268: getfield x/oc865980c948.τ D
      // 26b: invokevirtual x/oc865980c948.ư (DDD)V
      // 26e: goto 272
      // 271: athrow
      // 272: aload 0
      // 273: getfield x/oc865980c948.ǡ Z
      // 276: ifeq 297
      // 279: aload 0
      // 27a: iload 3
      // 27b: ifne 298
      // 27e: goto 282
      // 281: athrow
      // 282: invokevirtual x/oc865980c948.ϰ ()Z
      // 285: ifeq 297
      // 288: goto 28c
      // 28b: athrow
      // 28c: aload 0
      // 28d: ldc2_w 0.2
      // 290: putfield x/oc865980c948.Մ D
      // 293: goto 297
      // 296: athrow
      // 297: aload 0
      // 298: iload 3
      // 299: ifne 325
      // 29c: getfield x/oc865980c948.ƀ Lnet/minecraft/world/World;
      // 29f: getfield net/minecraft/world/World.isRemote Z
      // 2a2: ifeq 320
      // 2a5: goto 2a9
      // 2a8: athrow
      // 2a9: aload 0
      // 2aa: iload 3
      // 2ab: ifne 2fd
      // 2ae: goto 2b2
      // 2b1: athrow
      // 2b2: getfield x/oc865980c948.ƀ Lnet/minecraft/world/World;
      // 2b5: new net/minecraft/util/BlockPos
      // 2b8: dup
      // 2b9: aload 0
      // 2ba: getfield x/oc865980c948.б D
      // 2bd: dconst_0
      // 2be: aload 0
      // 2bf: getfield x/oc865980c948.ҟ D
      // 2c2: invokespecial net/minecraft/util/BlockPos.<init> (DDD)V
      // 2c5: invokevirtual net/minecraft/world/World.isBlockLoaded (Lnet/minecraft/util/BlockPos;)Z
      // 2c8: ifeq 2f8
      // 2cb: goto 2cf
      // 2ce: athrow
      // 2cf: aload 0
      // 2d0: iload 3
      // 2d1: ifne 325
      // 2d4: goto 2d8
      // 2d7: athrow
      // 2d8: getfield x/oc865980c948.ƀ Lnet/minecraft/world/World;
      // 2db: new net/minecraft/util/BlockPos
      // 2de: dup
      // 2df: aload 0
      // 2e0: getfield x/oc865980c948.б D
      // 2e3: dconst_0
      // 2e4: aload 0
      // 2e5: getfield x/oc865980c948.ҟ D
      // 2e8: invokespecial net/minecraft/util/BlockPos.<init> (DDD)V
      // 2eb: invokevirtual net/minecraft/world/World.getChunkFromBlockCoords (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/world/chunk/Chunk;
      // 2ee: invokevirtual net/minecraft/world/chunk/Chunk.isLoaded ()Z
      // 2f1: ifne 320
      // 2f4: goto 2f8
      // 2f7: athrow
      // 2f8: aload 0
      // 2f9: goto 2fd
      // 2fc: athrow
      // 2fd: aload 0
      // 2fe: getfield x/oc865980c948.ъ D
      // 301: iload 3
      // 302: ifne 315
      // 305: dconst_0
      // 306: dcmpl
      // 307: ifle 318
      // 30a: goto 30e
      // 30d: athrow
      // 30e: ldc2_w -0.1
      // 311: goto 315
      // 314: athrow
      // 315: goto 319
      // 318: dconst_0
      // 319: putfield x/oc865980c948.Մ D
      // 31c: iload 3
      // 31d: ifeq 330
      // 320: aload 0
      // 321: goto 325
      // 324: athrow
      // 325: dup
      // 326: getfield x/oc865980c948.Մ D
      // 329: ldc2_w 0.08
      // 32c: dsub
      // 32d: putfield x/oc865980c948.Մ D
      // 330: aload 0
      // 331: dup
      // 332: getfield x/oc865980c948.Մ D
      // 335: ldc2_w 0.9800000190734863
      // 338: dmul
      // 339: putfield x/oc865980c948.Մ D
      // 33c: iload 3
      // 33d: aload 0
      // 33e: dup
      // 33f: getfield x/oc865980c948.μ D
      // 342: fload 9
      // 344: f2d
      // 345: dmul
      // 346: putfield x/oc865980c948.μ D
      // 349: aload 0
      // 34a: dup
      // 34b: getfield x/oc865980c948.τ D
      // 34e: fload 9
      // 350: f2d
      // 351: dmul
      // 352: putfield x/oc865980c948.τ D
      // 355: ifeq 463
      // 358: aload 0
      // 359: goto 35d
      // 35c: athrow
      // 35d: getfield x/oc865980c948.ъ D
      // 360: dstore 4
      // 362: ldc_w 0.8
      // 365: fstore 7
      // 367: ldc 0.02
      // 369: fstore 8
      // 36b: aload 0
      // 36c: getfield x/oc865980c948.Ȁ Lnet/minecraft/client/entity/EntityPlayerSP;
      // 36f: invokestatic net/minecraft/enchantment/EnchantmentHelper.getDepthStriderModifier (Lnet/minecraft/entity/Entity;)I
      // 372: i2f
      // 373: fstore 6
      // 375: fload 6
      // 377: ldc_w 3.0
      // 37a: fcmpl
      // 37b: iload 3
      // 37c: ifne 38f
      // 37f: ifle 38b
      // 382: goto 386
      // 385: athrow
      // 386: ldc_w 3.0
      // 389: fstore 6
      // 38b: aload 0
      // 38c: getfield x/oc865980c948.ӕ Z
      // 38f: iload 3
      // 390: ifne 3a6
      // 393: ifne 3a2
      // 396: goto 39a
      // 399: athrow
      // 39a: fload 6
      // 39c: ldc_w 0.5
      // 39f: fmul
      // 3a0: fstore 6
      // 3a2: fload 6
      // 3a4: fconst_0
      // 3a5: fcmpl
      // 3a6: iload 3
      // 3a7: ifne 42a
      // 3aa: ifle 3d6
      // 3ad: goto 3b1
      // 3b0: athrow
      // 3b1: fload 7
      // 3b3: ldc_w 0.54600006
      // 3b6: fload 7
      // 3b8: fsub
      // 3b9: fload 6
      // 3bb: fmul
      // 3bc: ldc_w 3.0
      // 3bf: fdiv
      // 3c0: fadd
      // 3c1: fstore 7
      // 3c3: fload 8
      // 3c5: aload 0
      // 3c6: invokevirtual x/oc865980c948.ϯ ()F
      // 3c9: fload 8
      // 3cb: fsub
      // 3cc: fload 6
      // 3ce: fmul
      // 3cf: ldc_w 3.0
      // 3d2: fdiv
      // 3d3: fadd
      // 3d4: fstore 8
      // 3d6: aload 0
      // 3d7: fload 1
      // 3d8: fload 2
      // 3d9: fload 8
      // 3db: invokevirtual x/oc865980c948.Ѻ (FFF)V
      // 3de: aload 0
      // 3df: aload 0
      // 3e0: getfield x/oc865980c948.μ D
      // 3e3: aload 0
      // 3e4: getfield x/oc865980c948.Մ D
      // 3e7: aload 0
      // 3e8: getfield x/oc865980c948.τ D
      // 3eb: invokevirtual x/oc865980c948.ư (DDD)V
      // 3ee: aload 0
      // 3ef: dup
      // 3f0: getfield x/oc865980c948.μ D
      // 3f3: fload 7
      // 3f5: f2d
      // 3f6: dmul
      // 3f7: putfield x/oc865980c948.μ D
      // 3fa: aload 0
      // 3fb: dup
      // 3fc: getfield x/oc865980c948.Մ D
      // 3ff: ldc2_w 0.800000011920929
      // 402: dmul
      // 403: putfield x/oc865980c948.Մ D
      // 406: aload 0
      // 407: dup
      // 408: getfield x/oc865980c948.τ D
      // 40b: fload 7
      // 40d: f2d
      // 40e: dmul
      // 40f: putfield x/oc865980c948.τ D
      // 412: aload 0
      // 413: dup
      // 414: iload 3
      // 415: ifne 43b
      // 418: getfield x/oc865980c948.Մ D
      // 41b: ldc2_w 0.02
      // 41e: dsub
      // 41f: putfield x/oc865980c948.Մ D
      // 422: aload 0
      // 423: getfield x/oc865980c948.ǡ Z
      // 426: goto 42a
      // 429: athrow
      // 42a: ifeq 463
      // 42d: aload 0
      // 42e: iload 3
      // 42f: ifne 45d
      // 432: goto 436
      // 435: athrow
      // 436: aload 0
      // 437: goto 43b
      // 43a: athrow
      // 43b: getfield x/oc865980c948.μ D
      // 43e: aload 0
      // 43f: getfield x/oc865980c948.Մ D
      // 442: ldc2_w 0.6000000238418579
      // 445: dadd
      // 446: aload 0
      // 447: getfield x/oc865980c948.ъ D
      // 44a: dsub
      // 44b: dload 4
      // 44d: dadd
      // 44e: aload 0
      // 44f: getfield x/oc865980c948.τ D
      // 452: invokevirtual x/oc865980c948.ǡ (DDD)Z
      // 455: ifeq 463
      // 458: aload 0
      // 459: goto 45d
      // 45c: athrow
      // 45d: ldc2_w 0.30000001192092896
      // 460: putfield x/oc865980c948.Մ D
      // 463: return
   }

   public void ư(double param1, double param3, double param5) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: dload 1
      // 001: dstore 8
      // 003: getstatic x/oc166ec60a37.ȗ Z
      // 006: dload 3
      // 007: dstore 10
      // 009: dload 5
      // 00b: dstore 12
      // 00d: istore 7
      // 00f: aload 0
      // 010: iload 7
      // 012: ifne 042
      // 015: getfield x/oc865980c948.ͳ Z
      // 018: ifeq 03d
      // 01b: goto 01f
      // 01e: athrow
      // 01f: aload 0
      // 020: aload 0
      // 021: invokevirtual x/oc865980c948.ш ()Lnet/minecraft/util/AxisAlignedBB;
      // 024: dload 8
      // 026: dload 10
      // 028: dload 12
      // 02a: invokevirtual net/minecraft/util/AxisAlignedBB.offset (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 02d: invokevirtual x/oc865980c948.Ѣ (Lnet/minecraft/util/AxisAlignedBB;)V
      // 030: iload 7
      // 032: aload 0
      // 033: invokevirtual x/oc865980c948.ն ()V
      // 036: ifeq 8a8
      // 039: goto 03d
      // 03c: athrow
      // 03d: aload 0
      // 03e: goto 042
      // 041: athrow
      // 042: getfield x/oc865980c948.б D
      // 045: dstore 14
      // 047: iload 7
      // 049: aload 0
      // 04a: getfield x/oc865980c948.ъ D
      // 04d: dstore 16
      // 04f: aload 0
      // 050: getfield x/oc865980c948.ҟ D
      // 053: dstore 18
      // 055: ifne 08a
      // 058: aload 0
      // 059: getfield x/oc865980c948.ȼ Z
      // 05c: ifeq 08f
      // 05f: goto 063
      // 062: athrow
      // 063: aload 0
      // 064: bipush 0
      // 065: putfield x/oc865980c948.ȼ Z
      // 068: dload 8
      // 06a: ldc2_w 0.25
      // 06d: dmul
      // 06e: dstore 8
      // 070: dload 10
      // 072: ldc2_w 0.05000000074505806
      // 075: dmul
      // 076: dstore 10
      // 078: dload 12
      // 07a: ldc2_w 0.25
      // 07d: dmul
      // 07e: dstore 12
      // 080: aload 0
      // 081: dconst_0
      // 082: putfield x/oc865980c948.μ D
      // 085: aload 0
      // 086: dconst_0
      // 087: putfield x/oc865980c948.Մ D
      // 08a: aload 0
      // 08b: dconst_0
      // 08c: putfield x/oc865980c948.τ D
      // 08f: dload 8
      // 091: dstore 20
      // 093: dload 10
      // 095: dstore 22
      // 097: dload 12
      // 099: dstore 24
      // 09b: aload 0
      // 09c: iload 7
      // 09e: ifne 0b0
      // 0a1: getfield x/oc865980c948.ӕ Z
      // 0a4: ifeq 0d7
      // 0a7: goto 0ab
      // 0aa: athrow
      // 0ab: aload 0
      // 0ac: goto 0b0
      // 0af: athrow
      // 0b0: invokevirtual x/oc865980c948.y ()Z
      // 0b3: iload 7
      // 0b5: ifne 0d4
      // 0b8: ifne 0d3
      // 0bb: goto 0bf
      // 0be: athrow
      // 0bf: aload 0
      // 0c0: getfield x/oc865980c948.Ǎ Z
      // 0c3: iload 7
      // 0c5: ifne 0d4
      // 0c8: goto 0cc
      // 0cb: athrow
      // 0cc: ifeq 0d7
      // 0cf: goto 0d3
      // 0d2: athrow
      // 0d3: bipush 1
      // 0d4: goto 0d8
      // 0d7: bipush 0
      // 0d8: istore 26
      // 0da: iload 7
      // 0dc: ifne 0fc
      // 0df: iload 26
      // 0e1: ifeq 110
      // 0e4: goto 0e8
      // 0e7: athrow
      // 0e8: aload 0
      // 0e9: aload 0
      // 0ea: dload 8
      // 0ec: dload 12
      // 0ee: invokevirtual x/oc865980c948.Ǖ (Lx/oc865980c948;DD)Lorg/apache/commons/lang3/tuple/Pair;
      // 0f1: invokevirtual org/apache/commons/lang3/tuple/Pair.getLeft ()Ljava/lang/Object;
      // 0f4: checkcast java/lang/Double
      // 0f7: invokevirtual java/lang/Double.doubleValue ()D
      // 0fa: dstore 20
      // 0fc: aload 0
      // 0fd: aload 0
      // 0fe: dload 8
      // 100: dload 12
      // 102: invokevirtual x/oc865980c948.Ǖ (Lx/oc865980c948;DD)Lorg/apache/commons/lang3/tuple/Pair;
      // 105: invokevirtual org/apache/commons/lang3/tuple/Pair.getRight ()Ljava/lang/Object;
      // 108: checkcast java/lang/Double
      // 10b: invokevirtual java/lang/Double.doubleValue ()D
      // 10e: dstore 24
      // 110: aload 0
      // 111: getfield x/oc865980c948.ƀ Lnet/minecraft/world/World;
      // 114: aload 0
      // 115: getfield x/oc865980c948.Ȁ Lnet/minecraft/client/entity/EntityPlayerSP;
      // 118: aload 0
      // 119: invokevirtual x/oc865980c948.ш ()Lnet/minecraft/util/AxisAlignedBB;
      // 11c: dload 8
      // 11e: dload 10
      // 120: dload 12
      // 122: invokevirtual net/minecraft/util/AxisAlignedBB.addCoord (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 125: invokevirtual net/minecraft/world/World.getCollidingBoundingBoxes (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/AxisAlignedBB;)Ljava/util/List;
      // 128: astore 27
      // 12a: aload 0
      // 12b: invokevirtual x/oc865980c948.ш ()Lnet/minecraft/util/AxisAlignedBB;
      // 12e: astore 28
      // 130: aload 27
      // 132: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 137: astore 29
      // 139: aload 29
      // 13b: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 140: ifeq 166
      // 143: aload 29
      // 145: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 14a: checkcast net/minecraft/util/AxisAlignedBB
      // 14d: astore 30
      // 14f: iload 7
      // 151: ifne 175
      // 154: aload 30
      // 156: aload 0
      // 157: invokevirtual x/oc865980c948.ш ()Lnet/minecraft/util/AxisAlignedBB;
      // 15a: dload 10
      // 15c: invokevirtual net/minecraft/util/AxisAlignedBB.calculateYOffset (Lnet/minecraft/util/AxisAlignedBB;D)D
      // 15f: dstore 10
      // 161: iload 7
      // 163: ifeq 139
      // 166: aload 0
      // 167: aload 0
      // 168: invokevirtual x/oc865980c948.ш ()Lnet/minecraft/util/AxisAlignedBB;
      // 16b: dconst_0
      // 16c: dload 10
      // 16e: dconst_0
      // 16f: invokevirtual net/minecraft/util/AxisAlignedBB.offset (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 172: invokevirtual x/oc865980c948.Ѣ (Lnet/minecraft/util/AxisAlignedBB;)V
      // 175: aload 0
      // 176: getfield x/oc865980c948.ӕ Z
      // 179: iload 7
      // 17b: ifne 1af
      // 17e: ifne 1ae
      // 181: goto 185
      // 184: athrow
      // 185: dload 22
      // 187: dload 10
      // 189: iload 7
      // 18b: ifne 1a1
      // 18e: goto 192
      // 191: athrow
      // 192: dcmpl
      // 193: ifeq 1b2
      // 196: goto 19a
      // 199: athrow
      // 19a: dload 22
      // 19c: dconst_0
      // 19d: goto 1a1
      // 1a0: athrow
      // 1a1: dcmpg
      // 1a2: iload 7
      // 1a4: ifne 1af
      // 1a7: ifge 1b2
      // 1aa: goto 1ae
      // 1ad: athrow
      // 1ae: bipush 1
      // 1af: goto 1b3
      // 1b2: bipush 0
      // 1b3: istore 29
      // 1b5: aload 27
      // 1b7: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 1bc: astore 30
      // 1be: aload 30
      // 1c0: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 1c5: ifeq 1eb
      // 1c8: aload 30
      // 1ca: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 1cf: checkcast net/minecraft/util/AxisAlignedBB
      // 1d2: astore 31
      // 1d4: aload 31
      // 1d6: aload 0
      // 1d7: invokevirtual x/oc865980c948.ш ()Lnet/minecraft/util/AxisAlignedBB;
      // 1da: iload 7
      // 1dc: ifne 21f
      // 1df: dload 8
      // 1e1: invokevirtual net/minecraft/util/AxisAlignedBB.calculateXOffset (Lnet/minecraft/util/AxisAlignedBB;D)D
      // 1e4: dstore 8
      // 1e6: iload 7
      // 1e8: ifeq 1be
      // 1eb: aload 0
      // 1ec: aload 0
      // 1ed: invokevirtual x/oc865980c948.ш ()Lnet/minecraft/util/AxisAlignedBB;
      // 1f0: dload 8
      // 1f2: dconst_0
      // 1f3: dconst_0
      // 1f4: invokevirtual net/minecraft/util/AxisAlignedBB.offset (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 1f7: invokevirtual x/oc865980c948.Ѣ (Lnet/minecraft/util/AxisAlignedBB;)V
      // 1fa: aload 27
      // 1fc: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 201: astore 30
      // 203: aload 30
      // 205: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 20a: ifeq 234
      // 20d: aload 30
      // 20f: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 214: checkcast net/minecraft/util/AxisAlignedBB
      // 217: astore 31
      // 219: aload 31
      // 21b: aload 0
      // 21c: invokevirtual x/oc865980c948.ш ()Lnet/minecraft/util/AxisAlignedBB;
      // 21f: dload 12
      // 221: invokevirtual net/minecraft/util/AxisAlignedBB.calculateZOffset (Lnet/minecraft/util/AxisAlignedBB;D)D
      // 224: dstore 12
      // 226: iload 7
      // 228: ifne 248
      // 22b: iload 7
      // 22d: ifeq 203
      // 230: goto 234
      // 233: athrow
      // 234: aload 0
      // 235: aload 0
      // 236: invokevirtual x/oc865980c948.ш ()Lnet/minecraft/util/AxisAlignedBB;
      // 239: dconst_0
      // 23a: dconst_0
      // 23b: dload 12
      // 23d: invokevirtual net/minecraft/util/AxisAlignedBB.offset (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 240: invokevirtual x/oc865980c948.Ѣ (Lnet/minecraft/util/AxisAlignedBB;)V
      // 243: iload 7
      // 245: ifne 54c
      // 248: aload 0
      // 249: getfield x/oc865980c948.Ǻ F
      // 24c: fconst_0
      // 24d: fcmpl
      // 24e: ifle 548
      // 251: iload 29
      // 253: iload 7
      // 255: ifne 275
      // 258: goto 25c
      // 25b: athrow
      // 25c: ifeq 548
      // 25f: goto 263
      // 262: athrow
      // 263: dload 20
      // 265: iload 7
      // 267: ifne 293
      // 26a: goto 26e
      // 26d: athrow
      // 26e: dload 8
      // 270: dcmpl
      // 271: goto 275
      // 274: athrow
      // 275: ifne 28d
      // 278: dload 24
      // 27a: iload 7
      // 27c: ifne 293
      // 27f: goto 283
      // 282: athrow
      // 283: dload 12
      // 285: dcmpl
      // 286: ifeq 548
      // 289: goto 28d
      // 28c: athrow
      // 28d: dload 8
      // 28f: goto 293
      // 292: athrow
      // 293: dstore 30
      // 295: dload 10
      // 297: dstore 32
      // 299: dload 12
      // 29b: dstore 34
      // 29d: aload 0
      // 29e: invokevirtual x/oc865980c948.ш ()Lnet/minecraft/util/AxisAlignedBB;
      // 2a1: astore 36
      // 2a3: aload 0
      // 2a4: aload 28
      // 2a6: invokevirtual x/oc865980c948.Ѣ (Lnet/minecraft/util/AxisAlignedBB;)V
      // 2a9: aload 0
      // 2aa: getfield x/oc865980c948.Ǻ F
      // 2ad: f2d
      // 2ae: dstore 10
      // 2b0: aload 0
      // 2b1: getfield x/oc865980c948.ƀ Lnet/minecraft/world/World;
      // 2b4: aload 0
      // 2b5: getfield x/oc865980c948.Ȁ Lnet/minecraft/client/entity/EntityPlayerSP;
      // 2b8: aload 0
      // 2b9: invokevirtual x/oc865980c948.ш ()Lnet/minecraft/util/AxisAlignedBB;
      // 2bc: dload 20
      // 2be: dload 10
      // 2c0: dload 24
      // 2c2: invokevirtual net/minecraft/util/AxisAlignedBB.addCoord (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 2c5: invokevirtual net/minecraft/world/World.getCollidingBoundingBoxes (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/AxisAlignedBB;)Ljava/util/List;
      // 2c8: astore 37
      // 2ca: aload 0
      // 2cb: invokevirtual x/oc865980c948.ш ()Lnet/minecraft/util/AxisAlignedBB;
      // 2ce: astore 38
      // 2d0: aload 38
      // 2d2: dload 20
      // 2d4: dconst_0
      // 2d5: dload 24
      // 2d7: invokevirtual net/minecraft/util/AxisAlignedBB.addCoord (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 2da: astore 39
      // 2dc: dload 10
      // 2de: dstore 40
      // 2e0: aload 37
      // 2e2: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 2e7: astore 42
      // 2e9: aload 42
      // 2eb: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 2f0: ifeq 314
      // 2f3: aload 42
      // 2f5: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 2fa: checkcast net/minecraft/util/AxisAlignedBB
      // 2fd: astore 43
      // 2ff: iload 7
      // 301: ifne 31f
      // 304: aload 43
      // 306: aload 39
      // 308: dload 40
      // 30a: invokevirtual net/minecraft/util/AxisAlignedBB.calculateYOffset (Lnet/minecraft/util/AxisAlignedBB;D)D
      // 30d: dstore 40
      // 30f: iload 7
      // 311: ifeq 2e9
      // 314: aload 38
      // 316: dconst_0
      // 317: dload 40
      // 319: dconst_0
      // 31a: invokevirtual net/minecraft/util/AxisAlignedBB.offset (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 31d: astore 38
      // 31f: dload 20
      // 321: dstore 42
      // 323: aload 37
      // 325: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 32a: astore 44
      // 32c: aload 44
      // 32e: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 333: ifeq 35b
      // 336: aload 44
      // 338: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 33d: checkcast net/minecraft/util/AxisAlignedBB
      // 340: astore 45
      // 342: iload 7
      // 344: aload 45
      // 346: aload 38
      // 348: dload 42
      // 34a: invokevirtual net/minecraft/util/AxisAlignedBB.calculateXOffset (Lnet/minecraft/util/AxisAlignedBB;D)D
      // 34d: dstore 42
      // 34f: ifne 366
      // 352: iload 7
      // 354: ifeq 32c
      // 357: goto 35b
      // 35a: athrow
      // 35b: aload 38
      // 35d: dload 42
      // 35f: dconst_0
      // 360: dconst_0
      // 361: invokevirtual net/minecraft/util/AxisAlignedBB.offset (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 364: astore 38
      // 366: dload 24
      // 368: dstore 44
      // 36a: aload 37
      // 36c: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 371: astore 46
      // 373: aload 46
      // 375: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 37a: ifeq 39e
      // 37d: aload 46
      // 37f: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 384: checkcast net/minecraft/util/AxisAlignedBB
      // 387: astore 47
      // 389: iload 7
      // 38b: ifne 3a9
      // 38e: aload 47
      // 390: aload 38
      // 392: dload 44
      // 394: invokevirtual net/minecraft/util/AxisAlignedBB.calculateZOffset (Lnet/minecraft/util/AxisAlignedBB;D)D
      // 397: dstore 44
      // 399: iload 7
      // 39b: ifeq 373
      // 39e: aload 38
      // 3a0: dconst_0
      // 3a1: dconst_0
      // 3a2: dload 44
      // 3a4: invokevirtual net/minecraft/util/AxisAlignedBB.offset (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 3a7: astore 38
      // 3a9: aload 0
      // 3aa: invokevirtual x/oc865980c948.ш ()Lnet/minecraft/util/AxisAlignedBB;
      // 3ad: astore 46
      // 3af: dload 10
      // 3b1: dstore 47
      // 3b3: aload 37
      // 3b5: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 3ba: astore 49
      // 3bc: aload 49
      // 3be: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 3c3: ifeq 3e7
      // 3c6: aload 49
      // 3c8: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 3cd: checkcast net/minecraft/util/AxisAlignedBB
      // 3d0: astore 50
      // 3d2: iload 7
      // 3d4: ifne 3f2
      // 3d7: aload 50
      // 3d9: aload 46
      // 3db: dload 47
      // 3dd: invokevirtual net/minecraft/util/AxisAlignedBB.calculateYOffset (Lnet/minecraft/util/AxisAlignedBB;D)D
      // 3e0: dstore 47
      // 3e2: iload 7
      // 3e4: ifeq 3bc
      // 3e7: aload 46
      // 3e9: dconst_0
      // 3ea: dload 47
      // 3ec: dconst_0
      // 3ed: invokevirtual net/minecraft/util/AxisAlignedBB.offset (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 3f0: astore 46
      // 3f2: dload 20
      // 3f4: dstore 49
      // 3f6: aload 37
      // 3f8: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 3fd: astore 51
      // 3ff: aload 51
      // 401: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 406: ifeq 42a
      // 409: aload 51
      // 40b: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 410: checkcast net/minecraft/util/AxisAlignedBB
      // 413: astore 52
      // 415: aload 52
      // 417: aload 46
      // 419: dload 49
      // 41b: invokevirtual net/minecraft/util/AxisAlignedBB.calculateXOffset (Lnet/minecraft/util/AxisAlignedBB;D)D
      // 41e: iload 7
      // 420: ifne 437
      // 423: dstore 49
      // 425: iload 7
      // 427: ifeq 3ff
      // 42a: aload 46
      // 42c: dload 49
      // 42e: dconst_0
      // 42f: dconst_0
      // 430: invokevirtual net/minecraft/util/AxisAlignedBB.offset (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 433: astore 46
      // 435: dload 24
      // 437: dstore 51
      // 439: aload 37
      // 43b: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 440: astore 53
      // 442: aload 53
      // 444: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 449: ifeq 46d
      // 44c: aload 53
      // 44e: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 453: checkcast net/minecraft/util/AxisAlignedBB
      // 456: astore 54
      // 458: iload 7
      // 45a: ifne 478
      // 45d: aload 54
      // 45f: aload 46
      // 461: dload 51
      // 463: invokevirtual net/minecraft/util/AxisAlignedBB.calculateZOffset (Lnet/minecraft/util/AxisAlignedBB;D)D
      // 466: dstore 51
      // 468: iload 7
      // 46a: ifeq 442
      // 46d: aload 46
      // 46f: dconst_0
      // 470: dconst_0
      // 471: dload 51
      // 473: invokevirtual net/minecraft/util/AxisAlignedBB.offset (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 476: astore 46
      // 478: dload 42
      // 47a: dload 42
      // 47c: dmul
      // 47d: dload 44
      // 47f: dload 44
      // 481: dmul
      // 482: dadd
      // 483: dstore 53
      // 485: iload 7
      // 487: dload 49
      // 489: dload 49
      // 48b: dmul
      // 48c: dload 51
      // 48e: dload 51
      // 490: dmul
      // 491: dadd
      // 492: dstore 55
      // 494: ifne 4c8
      // 497: dload 53
      // 499: dload 55
      // 49b: dcmpl
      // 49c: ifle 4bb
      // 49f: goto 4a3
      // 4a2: athrow
      // 4a3: dload 42
      // 4a5: dstore 8
      // 4a7: iload 7
      // 4a9: dload 44
      // 4ab: dstore 12
      // 4ad: dload 40
      // 4af: dneg
      // 4b0: dstore 10
      // 4b2: aload 0
      // 4b3: aload 38
      // 4b5: invokevirtual x/oc865980c948.Ѣ (Lnet/minecraft/util/AxisAlignedBB;)V
      // 4b8: ifeq 4ce
      // 4bb: dload 49
      // 4bd: dstore 8
      // 4bf: dload 51
      // 4c1: dstore 12
      // 4c3: dload 47
      // 4c5: dneg
      // 4c6: dstore 10
      // 4c8: aload 0
      // 4c9: aload 46
      // 4cb: invokevirtual x/oc865980c948.Ѣ (Lnet/minecraft/util/AxisAlignedBB;)V
      // 4ce: aload 37
      // 4d0: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 4d5: astore 57
      // 4d7: aload 57
      // 4d9: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 4de: ifeq 504
      // 4e1: aload 57
      // 4e3: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 4e8: checkcast net/minecraft/util/AxisAlignedBB
      // 4eb: astore 58
      // 4ed: iload 7
      // 4ef: ifne 51c
      // 4f2: aload 58
      // 4f4: aload 0
      // 4f5: invokevirtual x/oc865980c948.ш ()Lnet/minecraft/util/AxisAlignedBB;
      // 4f8: dload 10
      // 4fa: invokevirtual net/minecraft/util/AxisAlignedBB.calculateYOffset (Lnet/minecraft/util/AxisAlignedBB;D)D
      // 4fd: dstore 10
      // 4ff: iload 7
      // 501: ifeq 4d7
      // 504: aload 0
      // 505: iload 7
      // 507: ifne 54d
      // 50a: aload 0
      // 50b: invokevirtual x/oc865980c948.ш ()Lnet/minecraft/util/AxisAlignedBB;
      // 50e: dconst_0
      // 50f: dload 10
      // 511: dconst_0
      // 512: invokevirtual net/minecraft/util/AxisAlignedBB.offset (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 515: invokevirtual x/oc865980c948.Ѣ (Lnet/minecraft/util/AxisAlignedBB;)V
      // 518: goto 51c
      // 51b: athrow
      // 51c: dload 30
      // 51e: dload 30
      // 520: dmul
      // 521: dload 34
      // 523: dload 34
      // 525: dmul
      // 526: dadd
      // 527: dload 8
      // 529: dload 8
      // 52b: dmul
      // 52c: dload 12
      // 52e: dload 12
      // 530: dmul
      // 531: dadd
      // 532: dcmpl
      // 533: iflt 548
      // 536: dload 30
      // 538: dstore 8
      // 53a: dload 32
      // 53c: dstore 10
      // 53e: dload 34
      // 540: dstore 12
      // 542: aload 0
      // 543: aload 36
      // 545: invokevirtual x/oc865980c948.Ѣ (Lnet/minecraft/util/AxisAlignedBB;)V
      // 548: aload 0
      // 549: invokevirtual x/oc865980c948.ն ()V
      // 54c: aload 0
      // 54d: dload 20
      // 54f: dload 8
      // 551: dcmpl
      // 552: iload 7
      // 554: ifne 574
      // 557: ifne 573
      // 55a: goto 55e
      // 55d: athrow
      // 55e: dload 24
      // 560: dload 12
      // 562: dcmpl
      // 563: iload 7
      // 565: ifne 574
      // 568: goto 56c
      // 56b: athrow
      // 56c: ifeq 577
      // 56f: goto 573
      // 572: athrow
      // 573: bipush 1
      // 574: goto 578
      // 577: bipush 0
      // 578: putfield x/oc865980c948.ǡ Z
      // 57b: aload 0
      // 57c: dload 22
      // 57e: dload 10
      // 580: dcmpl
      // 581: iload 7
      // 583: ifne 58e
      // 586: ifeq 591
      // 589: goto 58d
      // 58c: athrow
      // 58d: bipush 1
      // 58e: goto 592
      // 591: bipush 0
      // 592: putfield x/oc865980c948.ɑ Z
      // 595: aload 0
      // 596: aload 0
      // 597: getfield x/oc865980c948.ɑ Z
      // 59a: iload 7
      // 59c: ifne 5ae
      // 59f: ifeq 5be
      // 5a2: goto 5a6
      // 5a5: athrow
      // 5a6: dload 22
      // 5a8: dconst_0
      // 5a9: dcmpg
      // 5aa: goto 5ae
      // 5ad: athrow
      // 5ae: iload 7
      // 5b0: ifne 5bb
      // 5b3: ifge 5be
      // 5b6: goto 5ba
      // 5b9: athrow
      // 5ba: bipush 1
      // 5bb: goto 5bf
      // 5be: bipush 0
      // 5bf: putfield x/oc865980c948.ӕ Z
      // 5c2: aload 0
      // 5c3: aload 0
      // 5c4: getfield x/oc865980c948.ǡ Z
      // 5c7: iload 7
      // 5c9: ifne 5e8
      // 5cc: ifne 5e7
      // 5cf: goto 5d3
      // 5d2: athrow
      // 5d3: aload 0
      // 5d4: getfield x/oc865980c948.ɑ Z
      // 5d7: iload 7
      // 5d9: ifne 5e8
      // 5dc: goto 5e0
      // 5df: athrow
      // 5e0: ifeq 5eb
      // 5e3: goto 5e7
      // 5e6: athrow
      // 5e7: bipush 1
      // 5e8: goto 5ec
      // 5eb: bipush 0
      // 5ec: putfield x/oc865980c948.ϡ Z
      // 5ef: iload 7
      // 5f1: aload 0
      // 5f2: getfield x/oc865980c948.б D
      // 5f5: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 5f8: istore 30
      // 5fa: aload 0
      // 5fb: getfield x/oc865980c948.ъ D
      // 5fe: ldc2_w 0.20000000298023224
      // 601: dsub
      // 602: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 605: istore 31
      // 607: aload 0
      // 608: getfield x/oc865980c948.ҟ D
      // 60b: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 60e: istore 32
      // 610: new net/minecraft/util/BlockPos
      // 613: dup
      // 614: iload 30
      // 616: iload 31
      // 618: iload 32
      // 61a: invokespecial net/minecraft/util/BlockPos.<init> (III)V
      // 61d: astore 33
      // 61f: aload 0
      // 620: getfield x/oc865980c948.ƀ Lnet/minecraft/world/World;
      // 623: aload 33
      // 625: invokevirtual net/minecraft/world/World.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 628: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 62d: astore 34
      // 62f: ifne 69d
      // 632: aload 34
      // 634: invokevirtual net/minecraft/block/Block.getMaterial ()Lnet/minecraft/block/material/Material;
      // 637: getstatic net/minecraft/block/material/Material.air Lnet/minecraft/block/material/Material;
      // 63a: if_acmpne 693
      // 63d: goto 641
      // 640: athrow
      // 641: aload 0
      // 642: getfield x/oc865980c948.ƀ Lnet/minecraft/world/World;
      // 645: aload 33
      // 647: invokevirtual net/minecraft/util/BlockPos.down ()Lnet/minecraft/util/BlockPos;
      // 64a: invokevirtual net/minecraft/world/World.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 64d: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 652: astore 35
      // 654: aload 35
      // 656: iload 7
      // 658: ifne 691
      // 65b: instanceof net/minecraft/block/BlockFence
      // 65e: ifne 68f
      // 661: goto 665
      // 664: athrow
      // 665: aload 35
      // 667: iload 7
      // 669: ifne 691
      // 66c: goto 670
      // 66f: athrow
      // 670: instanceof net/minecraft/block/BlockWall
      // 673: ifne 68f
      // 676: goto 67a
      // 679: athrow
      // 67a: aload 35
      // 67c: instanceof net/minecraft/block/BlockFenceGate
      // 67f: iload 7
      // 681: ifne 6ab
      // 684: goto 688
      // 687: athrow
      // 688: ifeq 693
      // 68b: goto 68f
      // 68e: athrow
      // 68f: aload 35
      // 691: astore 34
      // 693: aload 0
      // 694: dload 10
      // 696: aload 0
      // 697: getfield x/oc865980c948.ӕ Z
      // 69a: invokevirtual x/oc865980c948.ɿ (DZ)V
      // 69d: dload 20
      // 69f: iload 7
      // 6a1: ifne 6b9
      // 6a4: dload 8
      // 6a6: dcmpl
      // 6a7: goto 6ab
      // 6aa: athrow
      // 6ab: ifeq 6b7
      // 6ae: aload 0
      // 6af: dconst_0
      // 6b0: putfield x/oc865980c948.μ D
      // 6b3: goto 6b7
      // 6b6: athrow
      // 6b7: dload 24
      // 6b9: dload 12
      // 6bb: iload 7
      // 6bd: ifne 6d5
      // 6c0: dcmpl
      // 6c1: ifeq 6d1
      // 6c4: goto 6c8
      // 6c7: athrow
      // 6c8: aload 0
      // 6c9: dconst_0
      // 6ca: putfield x/oc865980c948.τ D
      // 6cd: goto 6d1
      // 6d0: athrow
      // 6d1: dload 22
      // 6d3: dload 10
      // 6d5: dcmpl
      // 6d6: iload 7
      // 6d8: ifne 6f9
      // 6db: ifeq 6ec
      // 6de: goto 6e2
      // 6e1: athrow
      // 6e2: aload 0
      // 6e3: aload 34
      // 6e5: invokevirtual x/oc865980c948.Ě (Lnet/minecraft/block/Block;)V
      // 6e8: goto 6ec
      // 6eb: athrow
      // 6ec: aload 0
      // 6ed: iload 7
      // 6ef: ifne 7e2
      // 6f2: invokevirtual x/oc865980c948.ҙ ()Z
      // 6f5: goto 6f9
      // 6f8: athrow
      // 6f9: ifeq 7e1
      // 6fc: iload 26
      // 6fe: ifne 7e1
      // 701: goto 705
      // 704: athrow
      // 705: aload 0
      // 706: iload 7
      // 708: ifne 7e2
      // 70b: goto 70f
      // 70e: athrow
      // 70f: getfield x/oc865980c948.ə Lnet/minecraft/entity/Entity;
      // 712: ifnonnull 7e1
      // 715: goto 719
      // 718: athrow
      // 719: aload 0
      // 71a: getfield x/oc865980c948.б D
      // 71d: dload 14
      // 71f: dsub
      // 720: dstore 35
      // 722: aload 0
      // 723: getfield x/oc865980c948.ъ D
      // 726: dload 16
      // 728: dsub
      // 729: dstore 37
      // 72b: aload 0
      // 72c: getfield x/oc865980c948.ҟ D
      // 72f: dload 18
      // 731: dsub
      // 732: dstore 39
      // 734: aload 34
      // 736: iload 7
      // 738: ifne 74a
      // 73b: getstatic net/minecraft/init/Blocks.ladder Lnet/minecraft/block/Block;
      // 73e: if_acmpeq 748
      // 741: goto 745
      // 744: athrow
      // 745: dconst_0
      // 746: dstore 37
      // 748: aload 34
      // 74a: ifnull 76b
      // 74d: aload 0
      // 74e: iload 7
      // 750: ifne 7b7
      // 753: goto 757
      // 756: athrow
      // 757: getfield x/oc865980c948.ӕ Z
      // 75a: ifeq 76b
      // 75d: goto 761
      // 760: athrow
      // 761: aload 0
      // 762: aload 34
      // 764: invokevirtual x/oc865980c948.ɍ (Lnet/minecraft/block/Block;)V
      // 767: goto 76b
      // 76a: athrow
      // 76b: aload 0
      // 76c: aload 0
      // 76d: getfield x/oc865980c948.Ԕ F
      // 770: f2d
      // 771: dload 35
      // 773: dload 35
      // 775: dmul
      // 776: dload 39
      // 778: dload 39
      // 77a: dmul
      // 77b: dadd
      // 77c: invokestatic net/minecraft/util/MathHelper.sqrt_double (D)F
      // 77f: f2d
      // 780: ldc2_w 0.6
      // 783: dmul
      // 784: dadd
      // 785: d2f
      // 786: putfield x/oc865980c948.Ԕ F
      // 789: iload 7
      // 78b: aload 0
      // 78c: aload 0
      // 78d: getfield x/oc865980c948.ό F
      // 790: f2d
      // 791: dload 35
      // 793: dload 35
      // 795: dmul
      // 796: dload 37
      // 798: dload 37
      // 79a: dmul
      // 79b: dadd
      // 79c: dload 39
      // 79e: dload 39
      // 7a0: dmul
      // 7a1: dadd
      // 7a2: invokestatic net/minecraft/util/MathHelper.sqrt_double (D)F
      // 7a5: f2d
      // 7a6: ldc2_w 0.6
      // 7a9: dmul
      // 7aa: dadd
      // 7ab: d2f
      // 7ac: putfield x/oc865980c948.ό F
      // 7af: ifne 7e5
      // 7b2: aload 0
      // 7b3: goto 7b7
      // 7b6: athrow
      // 7b7: getfield x/oc865980c948.ό F
      // 7ba: aload 0
      // 7bb: getfield x/oc865980c948.Ӎ I
      // 7be: i2f
      // 7bf: fcmpl
      // 7c0: ifle 7e1
      // 7c3: aload 34
      // 7c5: invokevirtual net/minecraft/block/Block.getMaterial ()Lnet/minecraft/block/material/Material;
      // 7c8: getstatic net/minecraft/block/material/Material.air Lnet/minecraft/block/material/Material;
      // 7cb: if_acmpeq 7e1
      // 7ce: goto 7d2
      // 7d1: athrow
      // 7d2: aload 0
      // 7d3: aload 0
      // 7d4: getfield x/oc865980c948.ό F
      // 7d7: f2i
      // 7d8: bipush 1
      // 7d9: iadd
      // 7da: putfield x/oc865980c948.Ӎ I
      // 7dd: goto 7e1
      // 7e0: athrow
      // 7e1: aload 0
      // 7e2: invokevirtual x/oc865980c948.ω ()V
      // 7e5: goto 7ef
      // 7e8: astore 35
      // 7ea: aload 35
      // 7ec: invokevirtual java/lang/Throwable.printStackTrace ()V
      // 7ef: aload 0
      // 7f0: invokevirtual x/oc865980c948.Ұ ()Z
      // 7f3: istore 35
      // 7f5: aload 0
      // 7f6: iload 7
      // 7f8: ifne 861
      // 7fb: getfield x/oc865980c948.ƀ Lnet/minecraft/world/World;
      // 7fe: aload 0
      // 7ff: invokevirtual x/oc865980c948.ш ()Lnet/minecraft/util/AxisAlignedBB;
      // 802: ldc2_w 0.001
      // 805: ldc2_w 0.001
      // 808: ldc2_w 0.001
      // 80b: invokevirtual net/minecraft/util/AxisAlignedBB.contract (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 80e: invokevirtual net/minecraft/world/World.isFlammableWithin (Lnet/minecraft/util/AxisAlignedBB;)Z
      // 811: ifeq 85c
      // 814: goto 818
      // 817: athrow
      // 818: iload 35
      // 81a: iload 7
      // 81c: ifne 87f
      // 81f: goto 823
      // 822: athrow
      // 823: ifne 87d
      // 826: goto 82a
      // 829: athrow
      // 82a: aload 0
      // 82b: dup
      // 82c: getfield x/oc865980c948.Є I
      // 82f: bipush 1
      // 830: iadd
      // 831: putfield x/oc865980c948.Є I
      // 834: aload 0
      // 835: getfield x/oc865980c948.Є I
      // 838: iload 7
      // 83a: ifne 87f
      // 83d: goto 841
      // 840: athrow
      // 841: ifne 87d
      // 844: goto 848
      // 847: athrow
      // 848: aload 0
      // 849: ldc_w 424153869
      // 84c: ldc_w 424153861
      // 84f: ixor
      // 850: invokevirtual x/oc865980c948.ϭ (I)V
      // 853: iload 7
      // 855: ifeq 87d
      // 858: goto 85c
      // 85b: athrow
      // 85c: aload 0
      // 85d: goto 861
      // 860: athrow
      // 861: getfield x/oc865980c948.Є I
      // 864: iload 7
      // 866: ifne 87f
      // 869: ifgt 87d
      // 86c: goto 870
      // 86f: athrow
      // 870: aload 0
      // 871: aload 0
      // 872: getfield x/oc865980c948.Ԅ I
      // 875: ineg
      // 876: putfield x/oc865980c948.Є I
      // 879: goto 87d
      // 87c: athrow
      // 87d: iload 35
      // 87f: iload 7
      // 881: ifne 89c
      // 884: ifeq 8a8
      // 887: goto 88b
      // 88a: athrow
      // 88b: aload 0
      // 88c: iload 7
      // 88e: ifne 8a0
      // 891: goto 895
      // 894: athrow
      // 895: getfield x/oc865980c948.Є I
      // 898: goto 89c
      // 89b: athrow
      // 89c: ifle 8a8
      // 89f: aload 0
      // 8a0: aload 0
      // 8a1: getfield x/oc865980c948.Ԅ I
      // 8a4: ineg
      // 8a5: putfield x/oc865980c948.Є I
      // 8a8: return
   }

   public AxisAlignedBB ш() {
      return this.У;
   }

   public void Ѣ(AxisAlignedBB var1) {
      this.У = var1;
   }

   public void ϩ() {
      this.ϭ(1122735470 ^ 1122735457);
   }

   public void ϭ(int var1) {
      int var3 = var1 * (2065181570 ^ 2065181590);
      boolean var2 = oc166ec60a37.ȗ;
      oc865980c948 var10000 = this;
      if (!var2) {
         var3 = EnchantmentProtection.getFireTimeForEntity(this.Ȁ, var3);

         try {
            if (this.Є >= var3) {
               return;
            }

            var10000 = this;
         } catch (ocbde1165e4e var4) {
            throw var4;
         }
      }

      var10000.Є = var3;
   }

   public boolean Ұ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc166ec60a37.ȗ Z
      // 03: istore 1
      // 04: aload 0
      // 05: getfield x/oc865980c948.ћ Z
      // 08: iload 1
      // 09: ifne 66
      // 0c: ifne 65
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: new net/minecraft/util/BlockPos
      // 17: dup
      // 18: aload 0
      // 19: getfield x/oc865980c948.б D
      // 1c: aload 0
      // 1d: getfield x/oc865980c948.ъ D
      // 20: aload 0
      // 21: getfield x/oc865980c948.ҟ D
      // 24: invokespecial net/minecraft/util/BlockPos.<init> (DDD)V
      // 27: invokevirtual x/oc865980c948.ϼ (Lnet/minecraft/util/BlockPos;)Z
      // 2a: iload 1
      // 2b: ifne 66
      // 2e: goto 32
      // 31: athrow
      // 32: ifne 65
      // 35: goto 39
      // 38: athrow
      // 39: aload 0
      // 3a: new net/minecraft/util/BlockPos
      // 3d: dup
      // 3e: aload 0
      // 3f: getfield x/oc865980c948.б D
      // 42: aload 0
      // 43: getfield x/oc865980c948.ъ D
      // 46: aload 0
      // 47: getfield x/oc865980c948.ԋ F
      // 4a: f2d
      // 4b: dadd
      // 4c: aload 0
      // 4d: getfield x/oc865980c948.ҟ D
      // 50: invokespecial net/minecraft/util/BlockPos.<init> (DDD)V
      // 53: invokevirtual x/oc865980c948.ϼ (Lnet/minecraft/util/BlockPos;)Z
      // 56: iload 1
      // 57: ifne 66
      // 5a: goto 5e
      // 5d: athrow
      // 5e: ifeq 69
      // 61: goto 65
      // 64: athrow
      // 65: bipush 1
      // 66: goto 6a
      // 69: bipush 0
      // 6a: ireturn
   }

   public void ω() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc166ec60a37.ȗ Z
      // 003: new net/minecraft/util/BlockPos
      // 006: dup
      // 007: aload 0
      // 008: invokevirtual x/oc865980c948.ш ()Lnet/minecraft/util/AxisAlignedBB;
      // 00b: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 00e: ldc2_w 0.001
      // 011: dadd
      // 012: aload 0
      // 013: invokevirtual x/oc865980c948.ш ()Lnet/minecraft/util/AxisAlignedBB;
      // 016: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 019: ldc2_w 0.001
      // 01c: dadd
      // 01d: aload 0
      // 01e: invokevirtual x/oc865980c948.ш ()Lnet/minecraft/util/AxisAlignedBB;
      // 021: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 024: ldc2_w 0.001
      // 027: dadd
      // 028: invokespecial net/minecraft/util/BlockPos.<init> (DDD)V
      // 02b: astore 2
      // 02c: istore 1
      // 02d: new net/minecraft/util/BlockPos
      // 030: dup
      // 031: aload 0
      // 032: invokevirtual x/oc865980c948.ш ()Lnet/minecraft/util/AxisAlignedBB;
      // 035: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 038: ldc2_w 0.001
      // 03b: dsub
      // 03c: aload 0
      // 03d: invokevirtual x/oc865980c948.ш ()Lnet/minecraft/util/AxisAlignedBB;
      // 040: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 043: ldc2_w 0.001
      // 046: dsub
      // 047: aload 0
      // 048: invokevirtual x/oc865980c948.ш ()Lnet/minecraft/util/AxisAlignedBB;
      // 04b: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 04e: ldc2_w 0.001
      // 051: dsub
      // 052: invokespecial net/minecraft/util/BlockPos.<init> (DDD)V
      // 055: astore 3
      // 056: aload 0
      // 057: aload 2
      // 058: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 05b: aload 2
      // 05c: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 05f: aload 2
      // 060: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 063: aload 3
      // 064: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 067: aload 3
      // 068: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 06b: aload 3
      // 06c: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 06f: bipush 1
      // 070: invokevirtual x/oc865980c948.ď (IIIIIIZ)Z
      // 073: iload 1
      // 074: ifne 086
      // 077: ifeq 13e
      // 07a: goto 07e
      // 07d: athrow
      // 07e: aload 2
      // 07f: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 082: goto 086
      // 085: athrow
      // 086: istore 4
      // 088: iload 4
      // 08a: aload 3
      // 08b: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 08e: if_icmpgt 13e
      // 091: aload 2
      // 092: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 095: istore 5
      // 097: iload 5
      // 099: aload 3
      // 09a: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 09d: if_icmpgt 137
      // 0a0: aload 2
      // 0a1: iload 1
      // 0a2: ifne 092
      // 0a5: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 0a8: istore 6
      // 0aa: iload 6
      // 0ac: aload 3
      // 0ad: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 0b0: if_icmpgt 130
      // 0b3: new net/minecraft/util/BlockPos
      // 0b6: dup
      // 0b7: iload 4
      // 0b9: iload 5
      // 0bb: iload 6
      // 0bd: invokespecial net/minecraft/util/BlockPos.<init> (III)V
      // 0c0: astore 7
      // 0c2: iload 1
      // 0c3: ifne 133
      // 0c6: aload 0
      // 0c7: getfield x/oc865980c948.ƀ Lnet/minecraft/world/World;
      // 0ca: aload 7
      // 0cc: invokevirtual net/minecraft/world/World.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 0cf: astore 8
      // 0d1: aload 8
      // 0d3: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 0d8: astore 9
      // 0da: aload 9
      // 0dc: iload 1
      // 0dd: ifne 0fd
      // 0e0: instanceof net/minecraft/block/BlockWeb
      // 0e3: ifeq 0f7
      // 0e6: goto 0ea
      // 0e9: athrow
      // 0ea: aload 0
      // 0eb: bipush 1
      // 0ec: putfield x/oc865980c948.ȼ Z
      // 0ef: iload 1
      // 0f0: ifeq 11f
      // 0f3: goto 0f7
      // 0f6: athrow
      // 0f7: aload 9
      // 0f9: goto 0fd
      // 0fc: athrow
      // 0fd: instanceof net/minecraft/block/BlockSoulSand
      // 100: ifeq 11f
      // 103: aload 0
      // 104: dup
      // 105: getfield x/oc865980c948.μ D
      // 108: ldc2_w 0.4
      // 10b: dmul
      // 10c: putfield x/oc865980c948.μ D
      // 10f: aload 0
      // 110: dup
      // 111: getfield x/oc865980c948.τ D
      // 114: ldc2_w 0.4
      // 117: dmul
      // 118: putfield x/oc865980c948.τ D
      // 11b: goto 11f
      // 11e: athrow
      // 11f: goto 129
      // 122: astore 9
      // 124: aload 9
      // 126: invokevirtual java/lang/Throwable.printStackTrace ()V
      // 129: iinc 6 1
      // 12c: iload 1
      // 12d: ifeq 0aa
      // 130: iinc 5 1
      // 133: iload 1
      // 134: ifeq 097
      // 137: iinc 4 1
      // 13a: iload 1
      // 13b: ifeq 088
      // 13e: return
   }

   public void ɿ(double param1, boolean param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc166ec60a37.ȗ Z
      // 03: istore 4
      // 05: aload 0
      // 06: invokevirtual x/oc865980c948.ΰ ()Z
      // 09: iload 4
      // 0b: ifne 1f
      // 0e: ifne 1e
      // 11: goto 15
      // 14: athrow
      // 15: aload 0
      // 16: invokevirtual x/oc865980c948.Ѕ ()Z
      // 19: pop
      // 1a: goto 1e
      // 1d: athrow
      // 1e: iload 3
      // 1f: iload 4
      // 21: ifne 56
      // 24: ifeq 4f
      // 27: goto 2b
      // 2a: athrow
      // 2b: aload 0
      // 2c: iload 4
      // 2e: ifne 46
      // 31: goto 35
      // 34: athrow
      // 35: getfield x/oc865980c948.Ó F
      // 38: fconst_0
      // 39: fcmpl
      // 3a: ifle 69
      // 3d: goto 41
      // 40: athrow
      // 41: aload 0
      // 42: goto 46
      // 45: athrow
      // 46: fconst_0
      // 47: putfield x/oc865980c948.Ó F
      // 4a: iload 4
      // 4c: ifeq 69
      // 4f: dload 1
      // 50: dconst_0
      // 51: dcmpg
      // 52: goto 56
      // 55: athrow
      // 56: ifge 69
      // 59: aload 0
      // 5a: aload 0
      // 5b: getfield x/oc865980c948.Ó F
      // 5e: f2d
      // 5f: dload 1
      // 60: dsub
      // 61: d2f
      // 62: putfield x/oc865980c948.Ó F
      // 65: goto 69
      // 68: athrow
      // 69: return
   }

   public boolean Ѕ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc166ec60a37.ȗ Z
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 4a
      // 09: aload 0
      // 0a: invokevirtual x/oc865980c948.ш ()Lnet/minecraft/util/AxisAlignedBB;
      // 0d: dconst_0
      // 0e: ldc2_w -0.4000000059604645
      // 11: dconst_0
      // 12: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 15: ldc2_w 0.001
      // 18: ldc2_w 0.001
      // 1b: ldc2_w 0.001
      // 1e: invokevirtual net/minecraft/util/AxisAlignedBB.contract (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 21: getstatic net/minecraft/block/material/Material.water Lnet/minecraft/block/material/Material;
      // 24: invokevirtual x/oc865980c948.Į (Lnet/minecraft/util/AxisAlignedBB;Lnet/minecraft/block/material/Material;)Z
      // 27: ifeq 45
      // 2a: goto 2e
      // 2d: athrow
      // 2e: aload 0
      // 2f: fconst_0
      // 30: putfield x/oc865980c948.Ó F
      // 33: iload 1
      // 34: aload 0
      // 35: bipush 1
      // 36: putfield x/oc865980c948.ћ Z
      // 39: aload 0
      // 3a: bipush 0
      // 3b: putfield x/oc865980c948.Є I
      // 3e: ifeq 4e
      // 41: goto 45
      // 44: athrow
      // 45: aload 0
      // 46: goto 4a
      // 49: athrow
      // 4a: bipush 0
      // 4b: putfield x/oc865980c948.ћ Z
      // 4e: aload 0
      // 4f: getfield x/oc865980c948.ћ Z
      // 52: ireturn
   }

   public boolean Į(AxisAlignedBB param1, Material param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: aload 1
      // 001: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 004: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 007: istore 4
      // 009: getstatic x/oc166ec60a37.ȗ Z
      // 00c: aload 1
      // 00d: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 010: dconst_1
      // 011: dadd
      // 012: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 015: istore 5
      // 017: aload 1
      // 018: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 01b: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 01e: istore 6
      // 020: aload 1
      // 021: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 024: dconst_1
      // 025: dadd
      // 026: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 029: istore 7
      // 02b: aload 1
      // 02c: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 02f: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 032: istore 8
      // 034: istore 3
      // 035: aload 1
      // 036: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 039: dconst_1
      // 03a: dadd
      // 03b: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 03e: istore 9
      // 040: aload 0
      // 041: iload 4
      // 043: iload 6
      // 045: iload 8
      // 047: iload 5
      // 049: iload 7
      // 04b: iload 9
      // 04d: bipush 1
      // 04e: invokevirtual x/oc865980c948.ď (IIIIIIZ)Z
      // 051: iload 3
      // 052: ifne 060
      // 055: ifne 05f
      // 058: goto 05c
      // 05b: athrow
      // 05c: bipush 0
      // 05d: ireturn
      // 05e: athrow
      // 05f: bipush 0
      // 060: istore 10
      // 062: new net/minecraft/util/Vec3
      // 065: dup
      // 066: dconst_0
      // 067: dconst_0
      // 068: dconst_0
      // 069: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 06c: astore 11
      // 06e: new net/minecraft/util/BlockPos$MutableBlockPos
      // 071: dup
      // 072: invokespecial net/minecraft/util/BlockPos$MutableBlockPos.<init> ()V
      // 075: astore 12
      // 077: iload 4
      // 079: istore 13
      // 07b: iload 13
      // 07d: iload 5
      // 07f: if_icmpge 142
      // 082: iload 3
      // 083: ifne 1a6
      // 086: iload 6
      // 088: istore 14
      // 08a: iload 14
      // 08c: iload 7
      // 08e: if_icmpge 13b
      // 091: iload 3
      // 092: ifne 13e
      // 095: iload 8
      // 097: istore 15
      // 099: iload 15
      // 09b: iload 9
      // 09d: if_icmpge 134
      // 0a0: aload 12
      // 0a2: iload 13
      // 0a4: iload 14
      // 0a6: iload 15
      // 0a8: invokevirtual net/minecraft/util/BlockPos$MutableBlockPos.set (III)Lnet/minecraft/util/BlockPos$MutableBlockPos;
      // 0ab: pop
      // 0ac: iload 3
      // 0ad: ifne 137
      // 0b0: aload 0
      // 0b1: aload 12
      // 0b3: invokevirtual x/oc865980c948.ո (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 0b6: astore 16
      // 0b8: aload 16
      // 0ba: iload 3
      // 0bb: ifne 0ca
      // 0be: ifnonnull 0c8
      // 0c1: goto 0c5
      // 0c4: athrow
      // 0c5: goto 12d
      // 0c8: aload 16
      // 0ca: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 0cf: astore 17
      // 0d1: aload 17
      // 0d3: iload 3
      // 0d4: ifne 0e3
      // 0d7: ifnonnull 0e1
      // 0da: goto 0de
      // 0dd: athrow
      // 0de: goto 12d
      // 0e1: aload 17
      // 0e3: invokevirtual net/minecraft/block/Block.getMaterial ()Lnet/minecraft/block/material/Material;
      // 0e6: aload 2
      // 0e7: if_acmpne 12d
      // 0ea: iload 14
      // 0ec: bipush 1
      // 0ed: iadd
      // 0ee: i2f
      // 0ef: aload 16
      // 0f1: getstatic net/minecraft/block/BlockLiquid.LEVEL Lnet/minecraft/block/properties/PropertyInteger;
      // 0f4: invokeinterface net/minecraft/block/state/IBlockState.getValue (Lnet/minecraft/block/properties/IProperty;)Ljava/lang/Comparable; 2
      // 0f9: checkcast java/lang/Integer
      // 0fc: invokevirtual java/lang/Integer.intValue ()I
      // 0ff: invokestatic net/minecraft/block/BlockLiquid.getLiquidHeightPercent (I)F
      // 102: fsub
      // 103: f2d
      // 104: dstore 18
      // 106: iload 3
      // 107: ifne 130
      // 10a: iload 7
      // 10c: i2d
      // 10d: dload 18
      // 10f: dcmpl
      // 110: iflt 12d
      // 113: goto 117
      // 116: athrow
      // 117: bipush 1
      // 118: istore 10
      // 11a: aload 17
      // 11c: aload 0
      // 11d: getfield x/oc865980c948.ƀ Lnet/minecraft/world/World;
      // 120: aload 12
      // 122: aload 0
      // 123: getfield x/oc865980c948.Ȁ Lnet/minecraft/client/entity/EntityPlayerSP;
      // 126: aload 11
      // 128: invokevirtual net/minecraft/block/Block.modifyAcceleration (Lnet/minecraft/world/World;Lnet/minecraft/util/BlockPos;Lnet/minecraft/entity/Entity;Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/Vec3;
      // 12b: astore 11
      // 12d: iinc 15 1
      // 130: iload 3
      // 131: ifeq 099
      // 134: iinc 14 1
      // 137: iload 3
      // 138: ifeq 08a
      // 13b: iinc 13 1
      // 13e: iload 3
      // 13f: ifeq 07b
      // 142: aload 11
      // 144: invokevirtual net/minecraft/util/Vec3.lengthVector ()D
      // 147: dconst_0
      // 148: dcmpl
      // 149: iload 3
      // 14a: ifne 1a8
      // 14d: ifle 1a6
      // 150: goto 154
      // 153: athrow
      // 154: aload 0
      // 155: invokevirtual x/oc865980c948.ƚ ()Z
      // 158: iload 3
      // 159: ifne 1a8
      // 15c: goto 160
      // 15f: athrow
      // 160: ifeq 1a6
      // 163: goto 167
      // 166: athrow
      // 167: aload 11
      // 169: invokevirtual net/minecraft/util/Vec3.normalize ()Lnet/minecraft/util/Vec3;
      // 16c: astore 11
      // 16e: ldc2_w 0.014
      // 171: dstore 13
      // 173: aload 0
      // 174: dup
      // 175: getfield x/oc865980c948.μ D
      // 178: aload 11
      // 17a: getfield net/minecraft/util/Vec3.xCoord D
      // 17d: dload 13
      // 17f: dmul
      // 180: dadd
      // 181: putfield x/oc865980c948.μ D
      // 184: aload 0
      // 185: dup
      // 186: getfield x/oc865980c948.Մ D
      // 189: aload 11
      // 18b: getfield net/minecraft/util/Vec3.yCoord D
      // 18e: dload 13
      // 190: dmul
      // 191: dadd
      // 192: putfield x/oc865980c948.Մ D
      // 195: aload 0
      // 196: dup
      // 197: getfield x/oc865980c948.τ D
      // 19a: aload 11
      // 19c: getfield net/minecraft/util/Vec3.zCoord D
      // 19f: dload 13
      // 1a1: dmul
      // 1a2: dadd
      // 1a3: putfield x/oc865980c948.τ D
      // 1a6: iload 10
      // 1a8: ireturn
   }

   public boolean ď(int param1, int param2, int param3, int param4, int param5, int param6, boolean param7) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc166ec60a37.ȗ Z
      // 03: istore 8
      // 05: iload 5
      // 07: iload 8
      // 09: ifne a4
      // 0c: iflt a3
      // 0f: goto 13
      // 12: athrow
      // 13: iload 2
      // 14: iload 8
      // 16: ifne a4
      // 19: goto 1d
      // 1c: athrow
      // 1d: ldc_w -972759253
      // 20: ldc_w -972759509
      // 23: ixor
      // 24: if_icmpge a3
      // 27: goto 2b
      // 2a: athrow
      // 2b: iload 1
      // 2c: ldc_w -972759505
      // 2f: ldc_w -972759509
      // 32: ixor
      // 33: ishr
      // 34: istore 1
      // 35: iload 3
      // 36: ldc_w -972759505
      // 39: ldc_w -972759509
      // 3c: ixor
      // 3d: ishr
      // 3e: istore 3
      // 3f: iload 4
      // 41: ldc_w -972759505
      // 44: ldc_w -972759509
      // 47: ixor
      // 48: ishr
      // 49: istore 4
      // 4b: iload 6
      // 4d: ldc_w -972759505
      // 50: ldc_w -972759509
      // 53: ixor
      // 54: ishr
      // 55: istore 6
      // 57: iload 1
      // 58: istore 9
      // 5a: iload 9
      // 5c: iload 4
      // 5e: if_icmpgt a1
      // 61: iload 3
      // 62: iload 8
      // 64: ifne a2
      // 67: istore 10
      // 69: iload 10
      // 6b: iload 6
      // 6d: if_icmpgt 99
      // 70: iload 8
      // 72: ifne 9c
      // 75: aload 0
      // 76: iload 9
      // 78: iload 10
      // 7a: iload 7
      // 7c: invokevirtual x/oc865980c948.C (IIZ)Z
      // 7f: iload 8
      // 81: ifne 90
      // 84: goto 88
      // 87: athrow
      // 88: ifne 91
      // 8b: goto 8f
      // 8e: athrow
      // 8f: bipush 0
      // 90: ireturn
      // 91: iinc 10 1
      // 94: iload 8
      // 96: ifeq 69
      // 99: iinc 9 1
      // 9c: iload 8
      // 9e: ifeq 5a
      // a1: bipush 1
      // a2: ireturn
      // a3: bipush 0
      // a4: ireturn
   }

   public void ɍ(Block param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc166ec60a37.ȗ Z
      // 03: istore 2
      // 04: aload 1
      // 05: instanceof net/minecraft/block/BlockSlime
      // 08: iload 2
      // 09: ifne 2a
      // 0c: ifeq 58
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: iload 2
      // 15: ifne 2e
      // 18: goto 1c
      // 1b: athrow
      // 1c: getfield x/oc865980c948.Մ D
      // 1f: invokestatic java/lang/Math.abs (D)D
      // 22: ldc2_w 0.1
      // 25: dcmpg
      // 26: goto 2a
      // 29: athrow
      // 2a: ifge 58
      // 2d: aload 0
      // 2e: invokevirtual x/oc865980c948.y ()Z
      // 31: ifne 58
      // 34: ldc2_w 0.4
      // 37: aload 0
      // 38: getfield x/oc865980c948.Մ D
      // 3b: invokestatic java/lang/Math.abs (D)D
      // 3e: ldc2_w 0.2
      // 41: dmul
      // 42: dadd
      // 43: dstore 3
      // 44: aload 0
      // 45: dup
      // 46: getfield x/oc865980c948.μ D
      // 49: dload 3
      // 4a: dmul
      // 4b: putfield x/oc865980c948.μ D
      // 4e: aload 0
      // 4f: dup
      // 50: getfield x/oc865980c948.τ D
      // 53: dload 3
      // 54: dmul
      // 55: putfield x/oc865980c948.τ D
      // 58: return
   }

   public boolean ҙ() {
      boolean var1 = oc166ec60a37.ȗ;

      try {
         if (var1) {
            return this.Η.isFlying;
         }

         if (!this.Η.isFlying) {
            return true;
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }

      return false;
   }

   public boolean ϰ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield x/oc865980c948.б D
      // 04: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 07: istore 2
      // 08: aload 0
      // 09: invokevirtual x/oc865980c948.ш ()Lnet/minecraft/util/AxisAlignedBB;
      // 0c: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 0f: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 12: istore 3
      // 13: getstatic x/oc166ec60a37.ȗ Z
      // 16: aload 0
      // 17: getfield x/oc865980c948.ҟ D
      // 1a: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 1d: istore 4
      // 1f: aload 0
      // 20: getfield x/oc865980c948.ƀ Lnet/minecraft/world/World;
      // 23: new net/minecraft/util/BlockPos
      // 26: dup
      // 27: iload 2
      // 28: iload 3
      // 29: iload 4
      // 2b: invokespecial net/minecraft/util/BlockPos.<init> (III)V
      // 2e: invokevirtual net/minecraft/world/World.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 31: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 36: astore 5
      // 38: istore 1
      // 39: aload 5
      // 3b: iload 1
      // 3c: ifne 4f
      // 3f: getstatic net/minecraft/init/Blocks.ladder Lnet/minecraft/block/Block;
      // 42: if_acmpeq 55
      // 45: goto 49
      // 48: athrow
      // 49: aload 5
      // 4b: goto 4f
      // 4e: athrow
      // 4f: getstatic net/minecraft/init/Blocks.vine Lnet/minecraft/block/Block;
      // 52: if_acmpne 6c
      // 55: aload 0
      // 56: getfield x/oc865980c948.ɋ Z
      // 59: iload 1
      // 5a: ifne 69
      // 5d: goto 61
      // 60: athrow
      // 61: ifne 6c
      // 64: goto 68
      // 67: athrow
      // 68: bipush 1
      // 69: goto 6d
      // 6c: bipush 0
      // 6d: ireturn
   }

   public void Ѻ(float var1, float var2, float var3) {
      float var5 = var1;
      float var6 = var2;
      boolean var4 = oc166ec60a37.ȗ;
      float var7 = var1 * var1 + var2 * var2;

      label41: {
         float var10000;
         label42: {
            try {
               var10000 = var7;
               if (var4) {
                  break label42;
               }

               if (!(var7 >= 1.0E-4F)) {
                  return;
               }
            } catch (ocbde1165e4e var11) {
               throw var11;
            }

            var7 = MathHelper.sqrt_float(var7);

            try {
               if (var4) {
                  break label41;
               }

               var10000 = var7;
            } catch (ocbde1165e4e var10) {
               throw var10;
            }
         }

         if (var10000 < 1.0F) {
            var7 = 1.0F;
         }

         var7 = var3 / var7;
         var5 = var1 * var7;
         var6 = var2 * var7;
      }

      float var8 = MathHelper.sin(this.ǖ * (float) Math.PI / 180.0F);
      float var9 = MathHelper.cos(this.ǖ * (float) Math.PI / 180.0F);
      this.μ += var5 * var9 - var6 * var8;
      this.τ += var6 * var9 + var5 * var8;
   }

   public void ƌ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc166ec60a37.ȗ Z
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 3f
      // 09: aload 0
      // 0a: invokevirtual x/oc865980c948.ϖ ()F
      // 0d: f2d
      // 0e: putfield x/oc865980c948.Մ D
      // 11: aload 0
      // 12: getstatic net/minecraft/potion/Potion.jump Lnet/minecraft/potion/Potion;
      // 15: invokevirtual x/oc865980c948.ϱ (Lnet/minecraft/potion/Potion;)Z
      // 18: ifeq 3e
      // 1b: goto 1f
      // 1e: athrow
      // 1f: aload 0
      // 20: dup
      // 21: getfield x/oc865980c948.Մ D
      // 24: aload 0
      // 25: getstatic net/minecraft/potion/Potion.jump Lnet/minecraft/potion/Potion;
      // 28: invokevirtual x/oc865980c948.З (Lnet/minecraft/potion/Potion;)Lnet/minecraft/potion/PotionEffect;
      // 2b: invokevirtual net/minecraft/potion/PotionEffect.getAmplifier ()I
      // 2e: bipush 1
      // 2f: iadd
      // 30: i2f
      // 31: ldc_w 0.1
      // 34: fmul
      // 35: f2d
      // 36: dadd
      // 37: putfield x/oc865980c948.Մ D
      // 3a: goto 3e
      // 3d: athrow
      // 3e: aload 0
      // 3f: iload 1
      // 40: ifne 7b
      // 43: invokevirtual x/oc865980c948.Í ()Z
      // 46: ifeq 7a
      // 49: goto 4d
      // 4c: athrow
      // 4d: aload 0
      // 4e: getfield x/oc865980c948.ǖ F
      // 51: ldc_w 0.017453292
      // 54: fmul
      // 55: fstore 2
      // 56: aload 0
      // 57: dup
      // 58: getfield x/oc865980c948.μ D
      // 5b: fload 2
      // 5c: invokestatic net/minecraft/util/MathHelper.sin (F)F
      // 5f: ldc_w 0.2
      // 62: fmul
      // 63: f2d
      // 64: dsub
      // 65: putfield x/oc865980c948.μ D
      // 68: aload 0
      // 69: dup
      // 6a: getfield x/oc865980c948.τ D
      // 6d: fload 2
      // 6e: invokestatic net/minecraft/util/MathHelper.cos (F)F
      // 71: ldc_w 0.2
      // 74: fmul
      // 75: f2d
      // 76: dadd
      // 77: putfield x/oc865980c948.τ D
      // 7a: aload 0
      // 7b: bipush 1
      // 7c: putfield x/oc865980c948.ɟ Z
      // 7f: return
   }

   public boolean Í() {
      return this.ǝ;
   }

   public boolean ϱ(Potion var1) {
      try {
         if (this.Ȁ.getActivePotionEffect(var1) != null) {
            return true;
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }

      return false;
   }

   public PotionEffect З(Potion var1) {
      return this.Ȁ.getActivePotionEffect(var1);
   }

   public float ϖ() {
      return 0.42F;
   }

   public boolean ΰ() {
      return this.ћ;
   }

   public void ů() {
      this.ȸ = this.Ŗ.moveForward;
      this.ȹ = this.Ŗ.moveStrafe;
      this.Ы = this.Ŗ.jump;
   }

   public boolean Ȋ() {
      return true;
   }

   public boolean ώ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc166ec60a37.ȗ Z
      // 03: istore 1
      // 04: aload 0
      // 05: getfield x/oc865980c948.Ȁ Lnet/minecraft/client/entity/EntityPlayerSP;
      // 08: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHealth ()F
      // 0b: fconst_0
      // 0c: fcmpg
      // 0d: iload 1
      // 0e: ifne 2f
      // 11: ifle 2e
      // 14: goto 18
      // 17: athrow
      // 18: aload 0
      // 19: getfield x/oc865980c948.Ȁ Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1c: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isPlayerSleeping ()Z
      // 1f: iload 1
      // 20: ifne 2f
      // 23: goto 27
      // 26: athrow
      // 27: ifeq 32
      // 2a: goto 2e
      // 2d: athrow
      // 2e: bipush 1
      // 2f: goto 33
      // 32: bipush 0
      // 33: ireturn
   }

   public boolean â() {
      return this.ƀ.isMaterialInBB(this.ш().expand(-0.1F, -0.4F, -0.1F), Material.lava);
   }

   public boolean Ҹ() {
      return this.ɑ;
   }

   public void ǚ() {
      this.Մ += 0.04F;
   }

   public boolean ǡ(double var1, double var3, double var5) {
      AxisAlignedBB var7 = this.ш().offset(var1, var3, var5);
      return this.ш(var7);
   }

   public boolean ш(AxisAlignedBB param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc166ec60a37.ȗ Z
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 25
      // 09: getfield x/oc865980c948.ƀ Lnet/minecraft/world/World;
      // 0c: aload 0
      // 0d: getfield x/oc865980c948.Ȁ Lnet/minecraft/client/entity/EntityPlayerSP;
      // 10: aload 1
      // 11: invokevirtual net/minecraft/world/World.getCollidingBoundingBoxes (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/AxisAlignedBB;)Ljava/util/List;
      // 14: invokeinterface java/util/List.isEmpty ()Z 1
      // 19: ifeq 3b
      // 1c: goto 20
      // 1f: athrow
      // 20: aload 0
      // 21: goto 25
      // 24: athrow
      // 25: getfield x/oc865980c948.ƀ Lnet/minecraft/world/World;
      // 28: aload 1
      // 29: invokevirtual net/minecraft/world/World.isAnyLiquid (Lnet/minecraft/util/AxisAlignedBB;)Z
      // 2c: iload 2
      // 2d: ifne 38
      // 30: ifne 3b
      // 33: goto 37
      // 36: athrow
      // 37: bipush 1
      // 38: goto 3c
      // 3b: bipush 0
      // 3c: ireturn
   }

   public List<AxisAlignedBB> Ʋ(AxisAlignedBB param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: invokestatic com/google/common/collect/Lists.newArrayList ()Ljava/util/ArrayList;
      // 003: astore 3
      // 004: aload 1
      // 005: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 008: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 00b: istore 4
      // 00d: aload 1
      // 00e: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 011: dconst_1
      // 012: dadd
      // 013: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 016: istore 5
      // 018: aload 1
      // 019: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 01c: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 01f: istore 6
      // 021: getstatic x/oc166ec60a37.ȗ Z
      // 024: aload 1
      // 025: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 028: dconst_1
      // 029: dadd
      // 02a: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 02d: istore 7
      // 02f: aload 1
      // 030: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 033: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 036: istore 8
      // 038: aload 1
      // 039: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 03c: dconst_1
      // 03d: dadd
      // 03e: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 041: istore 9
      // 043: aload 0
      // 044: invokevirtual x/oc865980c948.ω ()Lnet/minecraft/world/border/WorldBorder;
      // 047: astore 10
      // 049: aload 0
      // 04a: getfield x/oc865980c948.ʷ Z
      // 04d: istore 11
      // 04f: aload 0
      // 050: aload 10
      // 052: iload 11
      // 054: invokevirtual x/oc865980c948.Δ (Lnet/minecraft/world/border/WorldBorder;Z)Z
      // 057: istore 12
      // 059: istore 2
      // 05a: getstatic net/minecraft/init/Blocks.stone Lnet/minecraft/block/Block;
      // 05d: invokevirtual net/minecraft/block/Block.getDefaultState ()Lnet/minecraft/block/state/IBlockState;
      // 060: astore 13
      // 062: new net/minecraft/util/BlockPos$MutableBlockPos
      // 065: dup
      // 066: invokespecial net/minecraft/util/BlockPos$MutableBlockPos.<init> ()V
      // 069: astore 14
      // 06b: iload 4
      // 06d: istore 15
      // 06f: iload 15
      // 071: iload 5
      // 073: if_icmpge 167
      // 076: iload 8
      // 078: istore 16
      // 07a: iload 16
      // 07c: iload 9
      // 07e: if_icmpge 160
      // 081: iload 2
      // 082: ifne 163
      // 085: aload 0
      // 086: aload 14
      // 088: iload 15
      // 08a: ldc_w 575278225
      // 08d: ldc_w 575278289
      // 090: ixor
      // 091: iload 16
      // 093: invokevirtual net/minecraft/util/BlockPos$MutableBlockPos.set (III)Lnet/minecraft/util/BlockPos$MutableBlockPos;
      // 096: invokevirtual x/oc865980c948.Ŧ (Lnet/minecraft/util/BlockPos;)Z
      // 099: iload 2
      // 09a: ifne 0b0
      // 09d: goto 0a1
      // 0a0: athrow
      // 0a1: ifeq 159
      // 0a4: goto 0a8
      // 0a7: athrow
      // 0a8: iload 6
      // 0aa: bipush 1
      // 0ab: isub
      // 0ac: goto 0b0
      // 0af: athrow
      // 0b0: istore 17
      // 0b2: iload 17
      // 0b4: iload 7
      // 0b6: if_icmpge 159
      // 0b9: iload 2
      // 0ba: ifne 15c
      // 0bd: aload 14
      // 0bf: iload 15
      // 0c1: iload 17
      // 0c3: iload 16
      // 0c5: invokevirtual net/minecraft/util/BlockPos$MutableBlockPos.set (III)Lnet/minecraft/util/BlockPos$MutableBlockPos;
      // 0c8: pop
      // 0c9: iload 11
      // 0cb: iload 2
      // 0cc: ifne 0fe
      // 0cf: goto 0d3
      // 0d2: athrow
      // 0d3: ifeq 0f8
      // 0d6: goto 0da
      // 0d9: athrow
      // 0da: iload 12
      // 0dc: iload 2
      // 0dd: ifne 0fe
      // 0e0: goto 0e4
      // 0e3: athrow
      // 0e4: ifeq 0f8
      // 0e7: goto 0eb
      // 0ea: athrow
      // 0eb: aload 0
      // 0ec: bipush 0
      // 0ed: putfield x/oc865980c948.ʷ Z
      // 0f0: iload 2
      // 0f1: ifeq 117
      // 0f4: goto 0f8
      // 0f7: athrow
      // 0f8: iload 11
      // 0fa: goto 0fe
      // 0fd: athrow
      // 0fe: iload 2
      // 0ff: ifne 10b
      // 102: ifne 117
      // 105: goto 109
      // 108: athrow
      // 109: iload 12
      // 10b: ifne 117
      // 10e: aload 0
      // 10f: bipush 1
      // 110: putfield x/oc865980c948.ʷ Z
      // 113: goto 117
      // 116: athrow
      // 117: aload 13
      // 119: astore 18
      // 11b: aload 10
      // 11d: aload 14
      // 11f: invokevirtual net/minecraft/world/border/WorldBorder.contains (Lnet/minecraft/util/BlockPos;)Z
      // 122: iload 2
      // 123: ifne 12f
      // 126: ifne 132
      // 129: goto 12d
      // 12c: athrow
      // 12d: iload 12
      // 12f: ifne 13a
      // 132: aload 0
      // 133: aload 14
      // 135: invokevirtual x/oc865980c948.ո (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 138: astore 18
      // 13a: aload 18
      // 13c: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 141: aload 0
      // 142: getfield x/oc865980c948.ƀ Lnet/minecraft/world/World;
      // 145: aload 14
      // 147: aload 18
      // 149: aload 1
      // 14a: aload 3
      // 14b: aload 0
      // 14c: getfield x/oc865980c948.Ȁ Lnet/minecraft/client/entity/EntityPlayerSP;
      // 14f: invokevirtual net/minecraft/block/Block.addCollisionBoxesToList (Lnet/minecraft/world/World;Lnet/minecraft/util/BlockPos;Lnet/minecraft/block/state/IBlockState;Lnet/minecraft/util/AxisAlignedBB;Ljava/util/List;Lnet/minecraft/entity/Entity;)V
      // 152: iload 2
      // 153: iinc 17 1
      // 156: ifeq 0b2
      // 159: iinc 16 1
      // 15c: iload 2
      // 15d: ifeq 07a
      // 160: iinc 15 1
      // 163: iload 2
      // 164: ifeq 06f
      // 167: ldc2_w 0.25
      // 16a: dstore 15
      // 16c: aload 0
      // 16d: aload 0
      // 16e: getfield x/oc865980c948.Ȁ Lnet/minecraft/client/entity/EntityPlayerSP;
      // 171: aload 1
      // 172: dload 15
      // 174: dload 15
      // 176: dload 15
      // 178: invokevirtual net/minecraft/util/AxisAlignedBB.expand (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 17b: invokevirtual x/oc865980c948.Ŏ (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/AxisAlignedBB;)Ljava/util/List;
      // 17e: astore 17
      // 180: aload 17
      // 182: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 187: astore 18
      // 189: aload 18
      // 18b: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 190: ifeq 236
      // 193: aload 18
      // 195: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 19a: checkcast net/minecraft/entity/Entity
      // 19d: astore 19
      // 19f: aload 0
      // 1a0: iload 2
      // 1a1: ifne 1b5
      // 1a4: getfield x/oc865980c948.ʡ Lnet/minecraft/entity/Entity;
      // 1a7: aload 19
      // 1a9: if_acmpeq 232
      // 1ac: goto 1b0
      // 1af: athrow
      // 1b0: aload 0
      // 1b1: goto 1b5
      // 1b4: athrow
      // 1b5: getfield x/oc865980c948.ə Lnet/minecraft/entity/Entity;
      // 1b8: iload 2
      // 1b9: ifne 1cb
      // 1bc: aload 19
      // 1be: if_acmpeq 232
      // 1c1: goto 1c5
      // 1c4: athrow
      // 1c5: aload 19
      // 1c7: goto 1cb
      // 1ca: athrow
      // 1cb: invokevirtual net/minecraft/entity/Entity.getCollisionBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 1ce: astore 20
      // 1d0: iload 2
      // 1d1: ifne 20f
      // 1d4: aload 20
      // 1d6: ifnull 1ff
      // 1d9: goto 1dd
      // 1dc: athrow
      // 1dd: aload 20
      // 1df: iload 2
      // 1e0: ifne 211
      // 1e3: goto 1e7
      // 1e6: athrow
      // 1e7: aload 1
      // 1e8: invokevirtual net/minecraft/util/AxisAlignedBB.intersectsWith (Lnet/minecraft/util/AxisAlignedBB;)Z
      // 1eb: ifeq 1ff
      // 1ee: goto 1f2
      // 1f1: athrow
      // 1f2: aload 3
      // 1f3: aload 20
      // 1f5: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 1fa: pop
      // 1fb: goto 1ff
      // 1fe: athrow
      // 1ff: aload 0
      // 200: aload 0
      // 201: getfield x/oc865980c948.Ȁ Lnet/minecraft/client/entity/EntityPlayerSP;
      // 204: aload 19
      // 206: invokevirtual x/oc865980c948.Ļ (Lnet/minecraft/entity/Entity;Lnet/minecraft/entity/Entity;)Lnet/minecraft/util/AxisAlignedBB;
      // 209: iload 2
      // 20a: ifne 216
      // 20d: astore 20
      // 20f: aload 20
      // 211: ifnull 232
      // 214: aload 20
      // 216: aload 1
      // 217: invokevirtual net/minecraft/util/AxisAlignedBB.intersectsWith (Lnet/minecraft/util/AxisAlignedBB;)Z
      // 21a: iload 2
      // 21b: ifne 231
      // 21e: ifeq 232
      // 221: goto 225
      // 224: athrow
      // 225: aload 3
      // 226: aload 20
      // 228: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 22d: goto 231
      // 230: athrow
      // 231: pop
      // 232: iload 2
      // 233: ifeq 189
      // 236: aload 3
      // 237: bipush 0
      // 238: ifeq 24c
      // 23b: iload 2
      // 23c: ifeq 248
      // 23f: goto 243
      // 242: athrow
      // 243: bipush 0
      // 244: goto 249
      // 247: athrow
      // 248: bipush 1
      // 249: putstatic x/oc166ec60a37.ȗ Z
      // 24c: areturn
   }

   public IBlockState ո(BlockPos var1) {
      return this.ƀ.getBlockState(var1);
   }

   private Chunk ˣ(BlockPos var1) {
      return this.Ⱥ(var1.getX() >> (-721445938 ^ -721445942), var1.getZ() >> (-721445938 ^ -721445942));
   }

   private Chunk Ⱥ(int var1, int var2) {
      return this.Ӈ.provideChunk(var1, var2);
   }

   private boolean Ь(BlockPos param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc166ec60a37.ȗ Z
      // 03: istore 2
      // 04: aload 1
      // 05: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 08: iload 2
      // 09: ifne 22
      // 0c: ldc_w 508151527
      // 0f: ldc_w -528483737
      // 12: ixor
      // 13: if_icmplt 9d
      // 16: goto 1a
      // 19: athrow
      // 1a: aload 1
      // 1b: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 1e: goto 22
      // 21: athrow
      // 22: iload 2
      // 23: ifne 3c
      // 26: ldc_w 508151527
      // 29: ldc_w -528483737
      // 2c: ixor
      // 2d: if_icmplt 9d
      // 30: goto 34
      // 33: athrow
      // 34: aload 1
      // 35: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 38: goto 3c
      // 3b: athrow
      // 3c: iload 2
      // 3d: ifne 5e
      // 40: ldc_w -508151321
      // 43: ldc_w -528483737
      // 46: ixor
      // 47: if_icmpge 9d
      // 4a: goto 4e
      // 4d: athrow
      // 4e: aload 1
      // 4f: iload 2
      // 50: ifne 6d
      // 53: goto 57
      // 56: athrow
      // 57: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 5a: goto 5e
      // 5d: athrow
      // 5e: ldc_w -508151321
      // 61: ldc_w -528483737
      // 64: ixor
      // 65: if_icmpge 9d
      // 68: aload 1
      // 69: goto 6d
      // 6c: athrow
      // 6d: iload 2
      // 6e: ifne 80
      // 71: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 74: iflt 9d
      // 77: goto 7b
      // 7a: athrow
      // 7b: aload 1
      // 7c: goto 80
      // 7f: athrow
      // 80: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 83: iload 2
      // 84: ifne 9a
      // 87: ldc_w -528483481
      // 8a: ldc_w -528483737
      // 8d: ixor
      // 8e: if_icmpge 9d
      // 91: goto 95
      // 94: athrow
      // 95: bipush 1
      // 96: goto 9a
      // 99: athrow
      // 9a: goto 9e
      // 9d: bipush 0
      // 9e: ireturn
   }

   private WorldBorder borderW() {
      return this.î;
   }

   private boolean Δ(WorldBorder param1, boolean param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 1
      // 01: invokevirtual net/minecraft/world/border/WorldBorder.minX ()D
      // 04: dstore 4
      // 06: getstatic x/oc166ec60a37.ȗ Z
      // 09: aload 1
      // 0a: invokevirtual net/minecraft/world/border/WorldBorder.minZ ()D
      // 0d: dstore 6
      // 0f: istore 3
      // 10: aload 1
      // 11: invokevirtual net/minecraft/world/border/WorldBorder.maxX ()D
      // 14: dstore 8
      // 16: iload 3
      // 17: aload 1
      // 18: invokevirtual net/minecraft/world/border/WorldBorder.maxZ ()D
      // 1b: dstore 10
      // 1d: ifne 56
      // 20: iload 2
      // 21: ifeq 44
      // 24: goto 28
      // 27: athrow
      // 28: dload 4
      // 2a: dconst_1
      // 2b: dadd
      // 2c: dstore 4
      // 2e: iload 3
      // 2f: dload 6
      // 31: dconst_1
      // 32: dadd
      // 33: dstore 6
      // 35: dload 8
      // 37: dconst_1
      // 38: dsub
      // 39: dstore 8
      // 3b: dload 10
      // 3d: dconst_1
      // 3e: dsub
      // 3f: dstore 10
      // 41: ifeq 5c
      // 44: dload 4
      // 46: dconst_1
      // 47: dsub
      // 48: dstore 4
      // 4a: dload 6
      // 4c: dconst_1
      // 4d: dsub
      // 4e: dstore 6
      // 50: dload 8
      // 52: dconst_1
      // 53: dadd
      // 54: dstore 8
      // 56: dload 10
      // 58: dconst_1
      // 59: dadd
      // 5a: dstore 10
      // 5c: aload 0
      // 5d: iload 3
      // 5e: ifne 73
      // 61: getfield x/oc865980c948.б D
      // 64: dload 4
      // 66: dcmpl
      // 67: ifle b4
      // 6a: goto 6e
      // 6d: athrow
      // 6e: aload 0
      // 6f: goto 73
      // 72: athrow
      // 73: getfield x/oc865980c948.б D
      // 76: dload 8
      // 78: iload 3
      // 79: ifne 96
      // 7c: dcmpg
      // 7d: ifge b4
      // 80: goto 84
      // 83: athrow
      // 84: aload 0
      // 85: iload 3
      // 86: ifne 9f
      // 89: goto 8d
      // 8c: athrow
      // 8d: getfield x/oc865980c948.ҟ D
      // 90: dload 6
      // 92: goto 96
      // 95: athrow
      // 96: dcmpl
      // 97: ifle b4
      // 9a: aload 0
      // 9b: goto 9f
      // 9e: athrow
      // 9f: getfield x/oc865980c948.ҟ D
      // a2: dload 10
      // a4: dcmpg
      // a5: iload 3
      // a6: ifne b1
      // a9: ifge b4
      // ac: goto b0
      // af: athrow
      // b0: bipush 1
      // b1: goto b5
      // b4: bipush 0
      // b5: ireturn
   }

   private boolean Ŧ(BlockPos var1) {
      return this.P(var1, true);
   }

   private boolean P(BlockPos param1, boolean param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc166ec60a37.ȗ Z
      // 03: istore 3
      // 04: aload 0
      // 05: iload 3
      // 06: ifne 19
      // 09: aload 1
      // 0a: invokevirtual x/oc865980c948.Ь (Lnet/minecraft/util/BlockPos;)Z
      // 0d: ifeq 44
      // 10: goto 14
      // 13: athrow
      // 14: aload 0
      // 15: goto 19
      // 18: athrow
      // 19: aload 1
      // 1a: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 1d: ldc_w -1947214675
      // 20: ldc_w -1947214679
      // 23: ixor
      // 24: ishr
      // 25: aload 1
      // 26: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 29: ldc_w -1947214675
      // 2c: ldc_w -1947214679
      // 2f: ixor
      // 30: ishr
      // 31: iload 2
      // 32: invokevirtual x/oc865980c948.C (IIZ)Z
      // 35: iload 3
      // 36: ifne 41
      // 39: ifeq 44
      // 3c: goto 40
      // 3f: athrow
      // 40: bipush 1
      // 41: goto 45
      // 44: bipush 0
      // 45: ireturn
   }

   private boolean C(int param1, int param2, boolean param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc166ec60a37.ȗ Z
      // 03: istore 4
      // 05: aload 0
      // 06: getfield x/oc865980c948.Ӈ Lnet/minecraft/world/chunk/IChunkProvider;
      // 09: iload 1
      // 0a: iload 2
      // 0b: invokeinterface net/minecraft/world/chunk/IChunkProvider.chunkExists (II)Z 3
      // 10: iload 4
      // 12: ifne 1d
      // 15: ifeq 4b
      // 18: goto 1c
      // 1b: athrow
      // 1c: iload 3
      // 1d: iload 4
      // 1f: ifne 48
      // 22: ifne 47
      // 25: goto 29
      // 28: athrow
      // 29: aload 0
      // 2a: getfield x/oc865980c948.Ӈ Lnet/minecraft/world/chunk/IChunkProvider;
      // 2d: iload 1
      // 2e: iload 2
      // 2f: invokeinterface net/minecraft/world/chunk/IChunkProvider.provideChunk (II)Lnet/minecraft/world/chunk/Chunk; 3
      // 34: invokevirtual net/minecraft/world/chunk/Chunk.isEmpty ()Z
      // 37: iload 4
      // 39: ifne 48
      // 3c: goto 40
      // 3f: athrow
      // 40: ifne 4b
      // 43: goto 47
      // 46: athrow
      // 47: bipush 1
      // 48: goto 4c
      // 4b: bipush 0
      // 4c: ireturn
   }

   private List<Entity> Ŏ(Entity var1, AxisAlignedBB var2) {
      return this.ѕ(var1, var2, EntitySelectors.NOT_SPECTATING);
   }

   private List<Entity> ѕ(Entity param1, AxisAlignedBB param2, Predicate<Entity> param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc166ec60a37.ȗ Z
      // 03: invokestatic com/google/common/collect/Lists.newArrayList ()Ljava/util/ArrayList;
      // 06: astore 5
      // 08: istore 4
      // 0a: aload 2
      // 0b: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 0e: ldc2_w 2.0
      // 11: dsub
      // 12: ldc2_w 16.0
      // 15: ddiv
      // 16: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 19: istore 6
      // 1b: aload 2
      // 1c: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 1f: ldc2_w 2.0
      // 22: dadd
      // 23: ldc2_w 16.0
      // 26: ddiv
      // 27: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 2a: istore 7
      // 2c: aload 2
      // 2d: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 30: ldc2_w 2.0
      // 33: dsub
      // 34: ldc2_w 16.0
      // 37: ddiv
      // 38: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 3b: istore 8
      // 3d: aload 2
      // 3e: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 41: ldc2_w 2.0
      // 44: dadd
      // 45: ldc2_w 16.0
      // 48: ddiv
      // 49: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 4c: istore 9
      // 4e: iload 6
      // 50: istore 10
      // 52: iload 10
      // 54: iload 7
      // 56: if_icmpgt a6
      // 59: iload 8
      // 5b: istore 11
      // 5d: iload 11
      // 5f: iload 9
      // 61: if_icmpgt 9e
      // 64: iload 4
      // 66: ifne a1
      // 69: aload 0
      // 6a: iload 4
      // 6c: ifne 87
      // 6f: goto 73
      // 72: athrow
      // 73: iload 10
      // 75: iload 11
      // 77: bipush 1
      // 78: invokevirtual x/oc865980c948.C (IIZ)Z
      // 7b: ifeq 96
      // 7e: goto 82
      // 81: athrow
      // 82: aload 0
      // 83: goto 87
      // 86: athrow
      // 87: iload 10
      // 89: iload 11
      // 8b: invokevirtual x/oc865980c948.Ⱥ (II)Lnet/minecraft/world/chunk/Chunk;
      // 8e: aload 1
      // 8f: aload 2
      // 90: aload 5
      // 92: aload 3
      // 93: invokevirtual net/minecraft/world/chunk/Chunk.getEntitiesWithinAABBForEntity (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/AxisAlignedBB;Ljava/util/List;Lcom/google/common/base/Predicate;)V
      // 96: iinc 11 1
      // 99: iload 4
      // 9b: ifeq 5d
      // 9e: iinc 10 1
      // a1: iload 4
      // a3: ifeq 52
      // a6: aload 5
      // a8: areturn
   }

   private AxisAlignedBB Ļ(Entity param1, Entity param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc166ec60a37.ȗ Z
      // 03: istore 3
      // 04: aload 2
      // 05: iload 3
      // 06: ifne 1a
      // 09: instanceof net/minecraft/entity/item/EntityBoat
      // 0c: ifeq 19
      // 0f: goto 13
      // 12: athrow
      // 13: aload 2
      // 14: invokevirtual net/minecraft/entity/Entity.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 17: areturn
      // 18: athrow
      // 19: aload 2
      // 1a: iload 3
      // 1b: ifne 2d
      // 1e: instanceof net/minecraft/entity/item/EntityMinecart
      // 21: ifeq 32
      // 24: goto 28
      // 27: athrow
      // 28: aload 1
      // 29: goto 2d
      // 2c: athrow
      // 2d: aload 2
      // 2e: invokevirtual net/minecraft/entity/Entity.getCollisionBox (Lnet/minecraft/entity/Entity;)Lnet/minecraft/util/AxisAlignedBB;
      // 31: areturn
      // 32: aconst_null
      // 33: areturn
   }

   private float ϯ() {
      return (float)this.ɼ(SharedMonsterAttributes.movementSpeed).getAttributeValue();
   }

   private IAttributeInstance ɼ(IAttribute var1) {
      return this.Ȍ().getAttributeInstance(var1);
   }

   private BaseAttributeMap Ȍ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc166ec60a37.ȗ Z
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 23
      // 09: getfield x/oc865980c948.ղ Lnet/minecraft/entity/ai/attributes/BaseAttributeMap;
      // 0c: ifnonnull 22
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: new net/minecraft/entity/ai/attributes/ServersideAttributeMap
      // 17: dup
      // 18: invokespecial net/minecraft/entity/ai/attributes/ServersideAttributeMap.<init> ()V
      // 1b: putfield x/oc865980c948.ղ Lnet/minecraft/entity/ai/attributes/BaseAttributeMap;
      // 1e: goto 22
      // 21: athrow
      // 22: aload 0
      // 23: getfield x/oc865980c948.ղ Lnet/minecraft/entity/ai/attributes/BaseAttributeMap;
      // 26: areturn
   }

   private void ն() {
      this.б = (this.ш().minX + this.ш().maxX) / 2.0;
      this.ъ = this.ш().minY;
      this.ҟ = (this.ш().minZ + this.ш().maxZ) / 2.0;
   }

   private void Ě(Block param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc166ec60a37.ȗ Z
      // 03: istore 2
      // 04: aload 1
      // 05: instanceof net/minecraft/block/BlockSlime
      // 08: iload 2
      // 09: ifne 23
      // 0c: ifeq 59
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: iload 2
      // 15: ifne 38
      // 18: goto 1c
      // 1b: athrow
      // 1c: invokevirtual x/oc865980c948.y ()Z
      // 1f: goto 23
      // 22: athrow
      // 23: ifeq 33
      // 26: aload 0
      // 27: dconst_0
      // 28: putfield x/oc865980c948.Մ D
      // 2b: iload 2
      // 2c: ifeq 62
      // 2f: goto 33
      // 32: athrow
      // 33: aload 0
      // 34: goto 38
      // 37: athrow
      // 38: iload 2
      // 39: ifne 4d
      // 3c: getfield x/oc865980c948.Մ D
      // 3f: dconst_0
      // 40: dcmpg
      // 41: ifge 62
      // 44: goto 48
      // 47: athrow
      // 48: aload 0
      // 49: goto 4d
      // 4c: athrow
      // 4d: aload 0
      // 4e: getfield x/oc865980c948.Մ D
      // 51: dneg
      // 52: putfield x/oc865980c948.Մ D
      // 55: iload 2
      // 56: ifeq 62
      // 59: aload 0
      // 5a: dconst_0
      // 5b: putfield x/oc865980c948.Մ D
      // 5e: goto 62
      // 61: athrow
      // 62: return
   }

   public boolean y() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc166ec60a37.ȗ Z
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 1b
      // 09: getfield x/oc865980c948.Ŗ Lnet/minecraft/util/MovementInput;
      // 0c: getfield net/minecraft/util/MovementInput.sneak Z
      // 0f: ifeq 30
      // 12: goto 16
      // 15: athrow
      // 16: aload 0
      // 17: goto 1b
      // 1a: athrow
      // 1b: getfield x/oc865980c948.Ȁ Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1e: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isPlayerSleeping ()Z
      // 21: iload 1
      // 22: ifne 2d
      // 25: ifne 30
      // 28: goto 2c
      // 2b: athrow
      // 2c: bipush 1
      // 2d: goto 31
      // 30: bipush 0
      // 31: ireturn
   }

   private boolean ϼ(BlockPos param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc166ec60a37.ȗ Z
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 20
      // 09: getfield x/oc865980c948.ƀ Lnet/minecraft/world/World;
      // 0c: fconst_1
      // 0d: invokevirtual net/minecraft/world/World.getRainStrength (F)F
      // 10: f2d
      // 11: ldc2_w 0.2
      // 14: dcmpg
      // 15: ifgt 1f
      // 18: goto 1c
      // 1b: athrow
      // 1c: bipush 0
      // 1d: ireturn
      // 1e: athrow
      // 1f: aload 0
      // 20: iload 2
      // 21: ifne 33
      // 24: aload 1
      // 25: invokevirtual x/oc865980c948.Ў (Lnet/minecraft/util/BlockPos;)Z
      // 28: ifne 32
      // 2b: goto 2f
      // 2e: athrow
      // 2f: bipush 0
      // 30: ireturn
      // 31: athrow
      // 32: aload 0
      // 33: getfield x/oc865980c948.ƀ Lnet/minecraft/world/World;
      // 36: iload 2
      // 37: ifne 53
      // 3a: aload 1
      // 3b: invokevirtual net/minecraft/world/World.getPrecipitationHeight (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/util/BlockPos;
      // 3e: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 41: aload 1
      // 42: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 45: if_icmple 4f
      // 48: goto 4c
      // 4b: athrow
      // 4c: bipush 0
      // 4d: ireturn
      // 4e: athrow
      // 4f: aload 0
      // 50: getfield x/oc865980c948.ƀ Lnet/minecraft/world/World;
      // 53: aload 1
      // 54: invokevirtual net/minecraft/world/World.getBiomeGenForCoords (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/world/biome/BiomeGenBase;
      // 57: astore 3
      // 58: aload 3
      // 59: invokevirtual net/minecraft/world/biome/BiomeGenBase.getEnableSnow ()Z
      // 5c: iload 2
      // 5d: ifne 73
      // 60: ifeq 6a
      // 63: goto 67
      // 66: athrow
      // 67: bipush 0
      // 68: ireturn
      // 69: athrow
      // 6a: aload 0
      // 6b: getfield x/oc865980c948.ƀ Lnet/minecraft/world/World;
      // 6e: aload 1
      // 6f: bipush 0
      // 70: invokevirtual net/minecraft/world/World.canSnowAt (Lnet/minecraft/util/BlockPos;Z)Z
      // 73: iload 2
      // 74: ifne 85
      // 77: ifeq 81
      // 7a: goto 7e
      // 7d: athrow
      // 7e: bipush 0
      // 7f: ireturn
      // 80: athrow
      // 81: aload 3
      // 82: invokevirtual net/minecraft/world/biome/BiomeGenBase.canRain ()Z
      // 85: ireturn
   }

   private boolean Ў(BlockPos var1) {
      return this.ˣ(var1).canSeeSky(var1);
   }

   private boolean ƚ() {
      boolean var1 = oc166ec60a37.ȗ;

      try {
         if (var1) {
            return this.Η.isFlying;
         }

         if (!this.Η.isFlying) {
            return true;
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }

      return false;
   }

   public Pair<Double, Double> Ǖ(oc865980c948 param1, double param2, double param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc166ec60a37.ȗ Z
      // 003: getstatic x/oc865980c948.ʖ Lnet/minecraft/client/Minecraft;
      // 006: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 009: astore 7
      // 00b: istore 6
      // 00d: aload 7
      // 00f: getfield net/minecraft/client/entity/EntityPlayerSP.worldObj Lnet/minecraft/world/World;
      // 012: astore 8
      // 014: dload 2
      // 015: dstore 11
      // 017: dload 4
      // 019: dstore 13
      // 01b: ldc2_w 0.05
      // 01e: dstore 9
      // 020: dload 2
      // 021: dconst_0
      // 022: dcmpl
      // 023: ifeq 0b1
      // 026: aload 8
      // 028: aload 7
      // 02a: aload 1
      // 02b: getfield x/oc865980c948.У Lnet/minecraft/util/AxisAlignedBB;
      // 02e: dload 2
      // 02f: iload 6
      // 031: ifne 181
      // 034: ldc2_w -1.0
      // 037: dconst_0
      // 038: invokevirtual net/minecraft/util/AxisAlignedBB.offset (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 03b: invokevirtual net/minecraft/world/World.getCollidingBoundingBoxes (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/AxisAlignedBB;)Ljava/util/List;
      // 03e: invokeinterface java/util/List.isEmpty ()Z 1
      // 043: iload 6
      // 045: ifne 0b5
      // 048: goto 04c
      // 04b: athrow
      // 04c: ifeq 0b1
      // 04f: goto 053
      // 052: athrow
      // 053: dload 2
      // 054: dload 9
      // 056: iload 6
      // 058: ifne 092
      // 05b: goto 05f
      // 05e: athrow
      // 05f: dcmpg
      // 060: ifge 083
      // 063: goto 067
      // 066: athrow
      // 067: dload 2
      // 068: iload 6
      // 06a: ifne 088
      // 06d: goto 071
      // 070: athrow
      // 071: dload 9
      // 073: dneg
      // 074: dcmpl
      // 075: iflt 083
      // 078: goto 07c
      // 07b: athrow
      // 07c: dconst_0
      // 07d: dstore 2
      // 07e: iload 6
      // 080: ifeq 0a9
      // 083: dload 2
      // 084: goto 088
      // 087: athrow
      // 088: iload 6
      // 08a: ifne 0a8
      // 08d: dconst_0
      // 08e: goto 092
      // 091: athrow
      // 092: dcmpl
      // 093: ifle 0a0
      // 096: dload 2
      // 097: dload 9
      // 099: dsub
      // 09a: dstore 2
      // 09b: iload 6
      // 09d: ifeq 0a9
      // 0a0: dload 2
      // 0a1: dload 9
      // 0a3: dadd
      // 0a4: goto 0a8
      // 0a7: athrow
      // 0a8: dstore 2
      // 0a9: dload 2
      // 0aa: dstore 11
      // 0ac: iload 6
      // 0ae: ifeq 020
      // 0b1: dload 4
      // 0b3: dconst_0
      // 0b4: dcmpl
      // 0b5: ifeq 151
      // 0b8: aload 8
      // 0ba: aload 7
      // 0bc: iload 6
      // 0be: ifne 17c
      // 0c1: goto 0c5
      // 0c4: athrow
      // 0c5: aload 1
      // 0c6: getfield x/oc865980c948.У Lnet/minecraft/util/AxisAlignedBB;
      // 0c9: dconst_0
      // 0ca: ldc2_w -1.0
      // 0cd: dload 4
      // 0cf: invokevirtual net/minecraft/util/AxisAlignedBB.offset (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 0d2: invokevirtual net/minecraft/world/World.getCollidingBoundingBoxes (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/AxisAlignedBB;)Ljava/util/List;
      // 0d5: invokeinterface java/util/List.isEmpty ()Z 1
      // 0da: iload 6
      // 0dc: ifne 154
      // 0df: goto 0e3
      // 0e2: athrow
      // 0e3: ifeq 151
      // 0e6: goto 0ea
      // 0e9: athrow
      // 0ea: dload 4
      // 0ec: iload 6
      // 0ee: ifne 123
      // 0f1: goto 0f5
      // 0f4: athrow
      // 0f5: dload 9
      // 0f7: dcmpg
      // 0f8: ifge 11d
      // 0fb: goto 0ff
      // 0fe: athrow
      // 0ff: dload 4
      // 101: iload 6
      // 103: ifne 123
      // 106: goto 10a
      // 109: athrow
      // 10a: dload 9
      // 10c: dneg
      // 10d: dcmpl
      // 10e: iflt 11d
      // 111: goto 115
      // 114: athrow
      // 115: dconst_0
      // 116: dstore 4
      // 118: iload 6
      // 11a: ifeq 148
      // 11d: dload 4
      // 11f: goto 123
      // 122: athrow
      // 123: iload 6
      // 125: ifne 146
      // 128: dconst_0
      // 129: dcmpl
      // 12a: ifle 13d
      // 12d: goto 131
      // 130: athrow
      // 131: dload 4
      // 133: dload 9
      // 135: dsub
      // 136: dstore 4
      // 138: iload 6
      // 13a: ifeq 148
      // 13d: dload 4
      // 13f: dload 9
      // 141: dadd
      // 142: goto 146
      // 145: athrow
      // 146: dstore 4
      // 148: dload 4
      // 14a: dstore 13
      // 14c: iload 6
      // 14e: ifeq 0b1
      // 151: dload 2
      // 152: dconst_0
      // 153: dcmpl
      // 154: ifeq 255
      // 157: dload 4
      // 159: iload 6
      // 15b: ifne 257
      // 15e: goto 162
      // 161: athrow
      // 162: iload 6
      // 164: ifne 257
      // 167: goto 16b
      // 16a: athrow
      // 16b: dconst_0
      // 16c: dcmpl
      // 16d: ifeq 255
      // 170: goto 174
      // 173: athrow
      // 174: aload 8
      // 176: aload 7
      // 178: goto 17c
      // 17b: athrow
      // 17c: aload 1
      // 17d: getfield x/oc865980c948.У Lnet/minecraft/util/AxisAlignedBB;
      // 180: dload 2
      // 181: ldc2_w -1.0
      // 184: dload 4
      // 186: invokevirtual net/minecraft/util/AxisAlignedBB.offset (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 189: invokevirtual net/minecraft/world/World.getCollidingBoundingBoxes (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/AxisAlignedBB;)Ljava/util/List;
      // 18c: invokeinterface java/util/List.isEmpty ()Z 1
      // 191: iload 6
      // 193: ifne 1ae
      // 196: ifeq 255
      // 199: goto 19d
      // 19c: athrow
      // 19d: dload 2
      // 19e: dload 9
      // 1a0: iload 6
      // 1a2: ifne 1dc
      // 1a5: goto 1a9
      // 1a8: athrow
      // 1a9: dcmpg
      // 1aa: goto 1ae
      // 1ad: athrow
      // 1ae: ifge 1cd
      // 1b1: dload 2
      // 1b2: iload 6
      // 1b4: ifne 1d2
      // 1b7: goto 1bb
      // 1ba: athrow
      // 1bb: dload 9
      // 1bd: dneg
      // 1be: dcmpl
      // 1bf: iflt 1cd
      // 1c2: goto 1c6
      // 1c5: athrow
      // 1c6: dconst_0
      // 1c7: dstore 2
      // 1c8: iload 6
      // 1ca: ifeq 1f3
      // 1cd: dload 2
      // 1ce: goto 1d2
      // 1d1: athrow
      // 1d2: iload 6
      // 1d4: ifne 1f2
      // 1d7: dconst_0
      // 1d8: goto 1dc
      // 1db: athrow
      // 1dc: dcmpl
      // 1dd: ifle 1ea
      // 1e0: dload 2
      // 1e1: dload 9
      // 1e3: dsub
      // 1e4: dstore 2
      // 1e5: iload 6
      // 1e7: ifeq 1f3
      // 1ea: dload 2
      // 1eb: dload 9
      // 1ed: dadd
      // 1ee: goto 1f2
      // 1f1: athrow
      // 1f2: dstore 2
      // 1f3: dload 2
      // 1f4: iload 6
      // 1f6: ifne 227
      // 1f9: dstore 11
      // 1fb: dload 4
      // 1fd: dload 9
      // 1ff: dcmpg
      // 200: ifge 221
      // 203: dload 4
      // 205: iload 6
      // 207: ifne 227
      // 20a: goto 20e
      // 20d: athrow
      // 20e: dload 9
      // 210: dneg
      // 211: dcmpl
      // 212: iflt 221
      // 215: goto 219
      // 218: athrow
      // 219: dconst_0
      // 21a: dstore 4
      // 21c: iload 6
      // 21e: ifeq 24c
      // 221: dload 4
      // 223: goto 227
      // 226: athrow
      // 227: iload 6
      // 229: ifne 24a
      // 22c: dconst_0
      // 22d: dcmpl
      // 22e: ifle 241
      // 231: goto 235
      // 234: athrow
      // 235: dload 4
      // 237: dload 9
      // 239: dsub
      // 23a: dstore 4
      // 23c: iload 6
      // 23e: ifeq 24c
      // 241: dload 4
      // 243: dload 9
      // 245: dadd
      // 246: goto 24a
      // 249: athrow
      // 24a: dstore 4
      // 24c: dload 4
      // 24e: dstore 13
      // 250: iload 6
      // 252: ifeq 151
      // 255: dload 11
      // 257: invokestatic java/lang/Double.valueOf (D)Ljava/lang/Double;
      // 25a: dload 13
      // 25c: invokestatic java/lang/Double.valueOf (D)Ljava/lang/Double;
      // 25f: invokestatic org/apache/commons/lang3/tuple/Pair.of (Ljava/lang/Object;Ljava/lang/Object;)Lorg/apache/commons/lang3/tuple/Pair;
      // 262: areturn
   }

   public float ұ() {
      return this.ԋ * 0.85F;
   }
}

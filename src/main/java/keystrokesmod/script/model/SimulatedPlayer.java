/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.model;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import keystrokesmod.script.model.Vec3;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockSlime;
import net.minecraft.block.BlockSoulSand;
import net.minecraft.block.BlockWall;
import net.minecraft.block.BlockWeb;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentProtection;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.ai.attributes.ServersideAttributeMap;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.FoodStats;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovementInput;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.border.WorldBorder;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import org.apache.commons.lang3.tuple.Pair;
import x.oc4557683e94;
import x.oc9755810e45;

public class SimulatedPlayer {
    private static final Minecraft mc = Minecraft.getMinecraft();
    private final EntityPlayerSP player;
    public AxisAlignedBB box;
    public final MovementInput movementInput;
    private int jumpTicks;
    public double motionZ;
    public double motionY;
    public double motionX;
    private boolean inWater;
    public boolean onGround;
    private boolean isAirBorne;
    public float rotationYaw;
    public float rotationPitch;
    private double posX;
    private double posY;
    private double posZ;
    private final PlayerCapabilities capabilities;
    private final Entity ridingEntity;
    private float jumpMovementFactor;
    private final World worldObj;
    public boolean isCollidedHorizontally;
    private boolean isCollidedVertically;
    private final WorldBorder worldBorder;
    private final IChunkProvider chunkProvider;
    private boolean isOutsideBorder;
    private final Entity riddenByEntity;
    private BaseAttributeMap attributeMap;
    private final boolean isSpectator;
    public float fallDistance;
    private final float stepHeight;
    private boolean isCollided;
    private int fire;
    private float distanceWalkedModified;
    private float distanceWalkedOnStepModified;
    private int nextStepDistance;
    public final float height;
    private final float width;
    private final int fireResistance;
    private boolean isInWeb;
    private boolean noClip;
    private boolean isSprinting;
    private boolean sprintRequested;
    private final FoodStats foodStats;
    private float moveForward = 0.0f;
    private float moveStrafing = 0.0f;
    private boolean isJumping = false;
    public boolean safeWalk = false;
    private static final float SPEED_IN_AIR = 0.02f;

    public SimulatedPlayer(EntityPlayerSP entityPlayerSP, AxisAlignedBB axisAlignedBB, MovementInput movementInput, int n, double d, double d2, double d3, boolean bl, boolean bl2, boolean bl3, float f, float f2, double d4, double d5, double d6, PlayerCapabilities playerCapabilities, Entity entity, float f3, World world2, boolean bl4, boolean bl5, WorldBorder worldBorder, IChunkProvider iChunkProvider, boolean bl6, Entity entity2, BaseAttributeMap baseAttributeMap, boolean bl7, float f4, float f5, boolean bl8, int n2, float f6, float f7, int n3, float f8, float f9, int n4, boolean bl9, boolean bl10, boolean bl11, FoodStats foodStats) {
        this.player = entityPlayerSP;
        this.box = axisAlignedBB;
        this.movementInput = movementInput;
        this.jumpTicks = n;
        this.motionZ = d;
        this.motionY = d2;
        this.motionX = d3;
        this.inWater = bl;
        this.onGround = bl2;
        this.isAirBorne = bl3;
        this.rotationYaw = f;
        this.rotationPitch = f2;
        this.posX = d4;
        this.posY = d5;
        this.posZ = d6;
        this.capabilities = playerCapabilities;
        this.ridingEntity = entity;
        this.jumpMovementFactor = f3;
        this.worldObj = world2;
        this.isCollidedHorizontally = bl4;
        this.isCollidedVertically = bl5;
        this.worldBorder = worldBorder;
        this.chunkProvider = iChunkProvider;
        this.isOutsideBorder = bl6;
        this.riddenByEntity = entity2;
        this.attributeMap = baseAttributeMap;
        this.isSpectator = bl7;
        this.fallDistance = f4;
        this.stepHeight = f5;
        this.isCollided = bl8;
        this.fire = n2;
        this.distanceWalkedModified = f6;
        this.distanceWalkedOnStepModified = f7;
        this.nextStepDistance = n3;
        this.height = f8;
        this.width = f9;
        this.fireResistance = n4;
        this.isInWeb = bl9;
        this.noClip = bl10;
        this.isSprinting = bl11;
        this.sprintRequested = bl11;
        this.foodStats = foodStats;
    }

    public Vec3 getPos() {
        return new Vec3(this.posX, this.posY, this.posZ);
    }

    public static SimulatedPlayer fromClientPlayer(MovementInput movementInput) {
        EntityPlayerSP entityPlayerSP = SimulatedPlayer.mc.thePlayer;
        PlayerCapabilities playerCapabilities = SimulatedPlayer.createCapabilitiesCopy(entityPlayerSP);
        FoodStats foodStats = SimulatedPlayer.createFoodStatsCopy(entityPlayerSP);
        MovementInput movementInput2 = new MovementInput();
        movementInput2.jump = movementInput.jump;
        movementInput2.moveForward = movementInput.moveForward;
        movementInput2.moveStrafe = movementInput.moveStrafe;
        movementInput2.sneak = movementInput.sneak;
        return new SimulatedPlayer(entityPlayerSP, entityPlayerSP.getEntityBoundingBox(), movementInput2, entityPlayerSP.getJumpTicks(), entityPlayerSP.motionZ, entityPlayerSP.motionY, entityPlayerSP.motionX, entityPlayerSP.isInWater(), entityPlayerSP.onGround, entityPlayerSP.isAirBorne, entityPlayerSP.rotationYaw, entityPlayerSP.rotationPitch, entityPlayerSP.posX, entityPlayerSP.posY, entityPlayerSP.posZ, playerCapabilities, entityPlayerSP.ridingEntity, entityPlayerSP.jumpMovementFactor, entityPlayerSP.worldObj, entityPlayerSP.isCollidedHorizontally, entityPlayerSP.isCollidedVertically, entityPlayerSP.worldObj.getWorldBorder(), entityPlayerSP.worldObj.getChunkProvider(), entityPlayerSP.isOutsideBorder(), entityPlayerSP.riddenByEntity, entityPlayerSP.getAttributeMap(), entityPlayerSP.isSpectator(), entityPlayerSP.fallDistance, entityPlayerSP.stepHeight, entityPlayerSP.isCollided, entityPlayerSP.getFire(), entityPlayerSP.distanceWalkedModified, entityPlayerSP.distanceWalkedOnStepModified, entityPlayerSP.getNextStepDistance(), entityPlayerSP.height, entityPlayerSP.width, entityPlayerSP.fireResistance, entityPlayerSP.getIsInWeb(), entityPlayerSP.noClip, entityPlayerSP.isSprinting(), foodStats);
    }

    private static FoodStats createFoodStatsCopy(EntityPlayerSP entityPlayerSP) {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        FoodStats foodStats = new FoodStats();
        entityPlayerSP.getFoodStats().writeNBT(nBTTagCompound);
        foodStats.readNBT(nBTTagCompound);
        return foodStats;
    }

    private static PlayerCapabilities createCapabilitiesCopy(EntityPlayerSP entityPlayerSP) {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        PlayerCapabilities playerCapabilities = new PlayerCapabilities();
        entityPlayerSP.capabilities.writeCapabilitiesToNBT(nBTTagCompound);
        playerCapabilities.readCapabilitiesFromNBT(nBTTagCompound);
        playerCapabilities.isFlying = false;
        playerCapabilities.allowFlying = false;
        return playerCapabilities;
    }

    private boolean onEntityUpdate() {
        this.handleWaterMovement();
        if (this.worldObj.isRemote) {
            this.fire = 0;
        } else if (this.fire > 0) {
            --this.fire;
        }
        if (this.isInLava()) {
            this.setOnFireFromLava();
            this.fallDistance *= 0.5f;
        }
        return !(this.posY < -64.0);
    }

    public void tick() {
        if (!this.onEntityUpdate() || this.player.isRiding()) {
            return;
        }
        this.playerUpdate(false);
        this.clientPlayerLivingUpdate();
        this.playerUpdate(true);
    }

    private void clientPlayerLivingUpdate() {
        int n;
        boolean bl;
        this.pushOutOfBlocks(this.posX - (double)this.width * 0.35, this.getEntityBoundingBox().minY + 0.5, this.posZ + (double)this.width * 0.35);
        this.pushOutOfBlocks(this.posX - (double)this.width * 0.35, this.getEntityBoundingBox().minY + 0.5, this.posZ - (double)this.width * 0.35);
        this.pushOutOfBlocks(this.posX + (double)this.width * 0.35, this.getEntityBoundingBox().minY + 0.5, this.posZ - (double)this.width * 0.35);
        this.pushOutOfBlocks(this.posX + (double)this.width * 0.35, this.getEntityBoundingBox().minY + 0.5, this.posZ + (double)this.width * 0.35);
        boolean bl2 = bl = oc9755810e45.\u04a9 == null || !oc9755810e45.\u04a9.z$3rzb3dil7uydr() || oc4557683e94.\u01b8.\u04c1() == 80.0;
        if (this.player.isUsingItem() && this.ridingEntity == null) {
            float f = oc4557683e94.\u04b2();
            this.movementInput.moveStrafe *= f;
            this.movementInput.moveForward *= f;
        }
        boolean bl3 = (n = this.foodStats.getFoodLevel()) > (0x7089CDCC ^ 0x7089CDCA) || this.capabilities.allowFlying;
        boolean bl4 = this.isPotionActive(Potion.blindness);
        if (!(!this.sprintRequested || this.movementInput.sneak || !this.onGround || this.isCollidedHorizontally || !(this.movementInput.moveForward >= 0.8f) && this.movementInput.moveStrafe == 0.0f || !bl3 || this.player.isUsingItem() && bl || bl4)) {
            this.setSprinting(true);
        }
        if (this.movementInput.sneak) {
            this.setSprinting(false);
        }
        if (this.isSprinting() && (this.movementInput.moveForward <= 0.0f || this.movementInput.sneak || this.isCollidedHorizontally || n <= (0x7089CDCC ^ 0x7089CDCA) && !this.capabilities.allowFlying)) {
            this.setSprinting(false);
        }
        if (this.capabilities.allowFlying && SimulatedPlayer.mc.playerController.isSpectatorMode() && !this.capabilities.isFlying) {
            this.capabilities.isFlying = true;
        }
        if (this.capabilities.isFlying) {
            if (this.movementInput.sneak) {
                this.motionY -= (double)(this.capabilities.getFlySpeed() * 3.0f);
            }
            if (this.movementInput.jump) {
                this.motionY += (double)(this.capabilities.getFlySpeed() * 3.0f);
            }
        }
        this.livingEntityUpdate();
    }

    private void playerUpdate(boolean bl) {
        if (!bl) {
            this.noClip = this.isSpectator;
            if (this.isSpectator) {
                this.onGround = false;
            }
        } else {
            this.clampPositionFromEntityPlayer();
        }
    }

    private void livingEntityUpdate() {
        if (this.jumpTicks > 0) {
            --this.jumpTicks;
        }
        if (Math.abs(this.motionX) < 0.005) {
            this.motionX = 0.0;
        }
        if (Math.abs(this.motionY) < 0.005) {
            this.motionY = 0.0;
        }
        if (Math.abs(this.motionZ) < 0.005) {
            this.motionZ = 0.0;
        }
        if (this.isMovementBlocked()) {
            this.isJumping = false;
            this.moveStrafing = 0.0f;
            this.moveForward = 0.0f;
        } else if (this.isServerWorld()) {
            this.updateLivingEntityInput();
        }
        if (this.isJumping) {
            if (this.isInWater() || this.isInLava()) {
                this.updateAITick();
            } else if (this.onGround && this.jumpTicks == 0) {
                this.jump();
            }
        } else {
            this.jumpTicks = 0;
        }
        this.moveStrafing *= 0.98f;
        this.moveForward *= 0.98f;
        this.playerSideMoveEntityWithHeading(this.moveStrafing, this.moveForward);
        this.jumpMovementFactor = 0.02f;
        if (this.isSprinting()) {
            this.jumpMovementFactor = (float)((double)this.jumpMovementFactor + 0.005999999865889549);
        }
        if (this.onGround && this.capabilities.isFlying && !this.isSpectator) {
            this.capabilities.isFlying = false;
        }
    }

    private void clampPositionFromEntityPlayer() {
        double d = MathHelper.clamp_double(this.posX, -2.9999999E7, 2.9999999E7);
        double d2 = MathHelper.clamp_double(this.posZ, -2.9999999E7, 2.9999999E7);
        if (d != this.posX || d2 != this.posZ) {
            this.setPosition(d, this.posY, d2);
        }
    }

    private void setPosition(double d, double d2, double d3) {
        this.posX = d;
        this.posY = d2;
        this.posZ = d3;
        float f = this.width / 2.0f;
        float f2 = this.height;
        this.setEntityBoundingBox(new AxisAlignedBB(d - (double)f, d2, d3 - (double)f, d + (double)f, d2 + (double)f2, d3 + (double)f));
    }

    private void setSprinting(boolean bl) {
        this.isSprinting = bl;
    }

    public void setSprintRequested(boolean bl) {
        this.sprintRequested = bl;
    }

    public void resetSimulationState(double d, double d2, double d3, boolean bl) {
        this.setPosition(d, d2, d3);
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.onGround = bl;
        this.isAirBorne = !bl;
        this.isCollided = false;
        this.isCollidedHorizontally = false;
        this.isCollidedVertically = bl;
        this.fallDistance = 0.0f;
        this.jumpTicks = 0;
        this.inWater = false;
        this.isInWeb = false;
        this.isSprinting = false;
        this.sprintRequested = false;
        this.movementInput.moveForward = 0.0f;
        this.movementInput.moveStrafe = 0.0f;
        this.movementInput.jump = false;
        this.movementInput.sneak = false;
    }

    private boolean pushOutOfBlocks(double d, double d2, double d3) {
        boolean bl;
        if (this.noClip) {
            return false;
        }
        BlockPos blockPos = new BlockPos(d, d2, d3);
        double d4 = d - (double)blockPos.getX();
        double d5 = d3 - (double)blockPos.getZ();
        int n = (int)Math.ceil(this.height);
        boolean bl2 = bl = !this.isHeadspaceFree(blockPos, n);
        if (bl) {
            int n2 = -1;
            double d6 = 9999.0;
            if (this.isHeadspaceFree(blockPos.west(), n) && d4 < d6) {
                d6 = d4;
                n2 = 0;
            }
            if (this.isHeadspaceFree(blockPos.east(), n) && 1.0 - d4 < d6) {
                d6 = 1.0 - d4;
                n2 = 1;
            }
            if (this.isHeadspaceFree(blockPos.north(), n) && d5 < d6) {
                d6 = d5;
                n2 = 0xDF26FBFB ^ 0xDF26FBFF;
            }
            if (this.isHeadspaceFree(blockPos.south(), n) && 1.0 - d5 < d6) {
                n2 = 0xDF26FBFA ^ 0xDF26FBFF;
            }
            float f = 0.1f;
            if (n2 == 0) {
                this.motionX = -f;
            }
            if (n2 == 1) {
                this.motionX = f;
            }
            if (n2 == (0xDF26FBFB ^ 0xDF26FBFF)) {
                this.motionZ = -f;
            }
            if (n2 == (0xDF26FBFA ^ 0xDF26FBFF)) {
                this.motionZ = f;
            }
        }
        return false;
    }

    private boolean isHeadspaceFree(BlockPos blockPos, int n) {
        for (int i = 0; i < n; ++i) {
            if (this.isOpenBlockSpace(blockPos.add(0, i, 0))) continue;
            return false;
        }
        return true;
    }

    private boolean isOpenBlockSpace(BlockPos blockPos) {
        return this.getBlockState(blockPos).getBlock().isNormalCube();
    }

    private void playerSideMoveEntityWithHeading(float f, float f2) {
        if (this.capabilities.isFlying && this.ridingEntity == null) {
            double d = this.motionY;
            float f3 = this.jumpMovementFactor;
            this.jumpMovementFactor = this.capabilities.getFlySpeed() * (float)(this.isSprinting() ? 0x6A6D4483 ^ 0x6A6D4481 : 1);
            this.livingEntitySideMoveEntityWithHeading(f, f2);
            this.motionY = d * 0.6;
            this.jumpMovementFactor = f3;
        } else {
            this.livingEntitySideMoveEntityWithHeading(f, f2);
        }
    }

    private void livingEntitySideMoveEntityWithHeading(float f, float f2) {
        if (this.isServerWorld()) {
            if (!this.isInWater() || this.capabilities.isFlying) {
                if (this.isInLava() && !this.capabilities.isFlying) {
                    double d = this.posY;
                    this.moveFlying(f, f2, 0.02f);
                    this.moveEntity(this.motionX, this.motionY, this.motionZ);
                    this.motionX *= 0.5;
                    this.motionY *= 0.5;
                    this.motionZ *= 0.5;
                    this.motionY -= 0.02;
                    if (this.isCollidedHorizontally && this.isOffsetPositionInLiquid(this.motionX, this.motionY + (double)0.6f - this.posY + d, this.motionZ)) {
                        this.motionY = 0.3f;
                    }
                } else {
                    float f3 = 0.91f;
                    if (this.onGround) {
                        f3 = this.worldObj.getBlockState((BlockPos)new BlockPos((int)MathHelper.floor_double((double)this.posX), (int)(MathHelper.floor_double((double)this.getEntityBoundingBox().minY) - 1), (int)MathHelper.floor_double((double)this.posZ))).getBlock().slipperiness * 0.91f;
                    }
                    float f4 = 0.16277136f / (f3 * f3 * f3);
                    float f5 = this.onGround ? this.getAIMoveSpeed() * f4 : this.jumpMovementFactor;
                    this.moveFlying(f, f2, f5);
                    f3 = 0.91f;
                    if (this.onGround) {
                        f3 = this.worldObj.getBlockState((BlockPos)new BlockPos((int)MathHelper.floor_double((double)this.posX), (int)(MathHelper.floor_double((double)this.getEntityBoundingBox().minY) - 1), (int)MathHelper.floor_double((double)this.posZ))).getBlock().slipperiness * 0.91f;
                    }
                    if (this.isOnLadder()) {
                        boolean bl;
                        float f6 = 0.15f;
                        this.motionX = MathHelper.clamp_double(this.motionX, -f6, f6);
                        this.motionZ = MathHelper.clamp_double(this.motionZ, -f6, f6);
                        this.fallDistance = 0.0f;
                        if (this.motionY < -0.15) {
                            this.motionY = -0.15;
                        }
                        if ((bl = this.isSneaking()) && this.motionY < 0.0) {
                            this.motionY = 0.0;
                        }
                    }
                    this.moveEntity(this.motionX, this.motionY, this.motionZ);
                    if (this.isCollidedHorizontally && this.isOnLadder()) {
                        this.motionY = 0.2;
                    }
                    this.motionY = !(!this.worldObj.isRemote || this.worldObj.isBlockLoaded(new BlockPos(this.posX, 0.0, this.posZ)) && this.worldObj.getChunkFromBlockCoords(new BlockPos(this.posX, 0.0, this.posZ)).isLoaded()) ? (this.posY > 0.0 ? -0.1 : 0.0) : (this.motionY -= 0.08);
                    this.motionY *= (double)0.98f;
                    this.motionX *= (double)f3;
                    this.motionZ *= (double)f3;
                }
            } else {
                double d = this.posY;
                float f7 = 0.8f;
                float f8 = 0.02f;
                float f9 = EnchantmentHelper.getDepthStriderModifier(this.player);
                if (f9 > 3.0f) {
                    f9 = 3.0f;
                }
                if (!this.onGround) {
                    f9 *= 0.5f;
                }
                if (f9 > 0.0f) {
                    f7 += (0.54600006f - f7) * f9 / 3.0f;
                    f8 += (this.getAIMoveSpeed() - f8) * f9 / 3.0f;
                }
                this.moveFlying(f, f2, f8);
                this.moveEntity(this.motionX, this.motionY, this.motionZ);
                this.motionX *= (double)f7;
                this.motionY *= (double)0.8f;
                this.motionZ *= (double)f7;
                this.motionY -= 0.02;
                if (this.isCollidedHorizontally && this.isOffsetPositionInLiquid(this.motionX, this.motionY + (double)0.6f - this.posY + d, this.motionZ)) {
                    this.motionY = 0.3f;
                }
            }
        }
    }

    public void moveEntity(double d, double d2, double d3) {
        double d4 = d;
        double d5 = d2;
        double d6 = d3;
        if (this.noClip) {
            this.setEntityBoundingBox(this.getEntityBoundingBox().offset(d4, d5, d6));
            this.resetPositionToBB();
        } else {
            Block throwable;
            boolean bl;
            double d7 = this.posX;
            double d8 = this.posY;
            double d9 = this.posZ;
            if (this.isInWeb) {
                this.isInWeb = false;
                d4 *= 0.25;
                d5 *= (double)0.05f;
                d6 *= 0.25;
                this.motionX = 0.0;
                this.motionY = 0.0;
                this.motionZ = 0.0;
            }
            double d10 = d4;
            double d11 = d5;
            double d12 = d6;
            boolean bl2 = bl = this.onGround && (this.isSneaking() || this.safeWalk);
            if (bl) {
                d10 = this.checkForCollision(this, d4, d6).getLeft();
                d12 = this.checkForCollision(this, d4, d6).getRight();
            }
            List<AxisAlignedBB> list = this.worldObj.getCollidingBoundingBoxes(this.player, this.getEntityBoundingBox().addCoord(d4, d5, d6));
            AxisAlignedBB axisAlignedBB = this.getEntityBoundingBox();
            for (AxisAlignedBB iterator2 : list) {
                d5 = iterator2.calculateYOffset(this.getEntityBoundingBox(), d5);
            }
            this.setEntityBoundingBox(this.getEntityBoundingBox().offset(0.0, d5, 0.0));
            boolean bl3 = this.onGround || d11 != d5 && d11 < 0.0;
            for (AxisAlignedBB axisAlignedBB2 : list) {
                d4 = axisAlignedBB2.calculateXOffset(this.getEntityBoundingBox(), d4);
            }
            this.setEntityBoundingBox(this.getEntityBoundingBox().offset(d4, 0.0, 0.0));
            for (AxisAlignedBB axisAlignedBB2 : list) {
                d6 = axisAlignedBB2.calculateZOffset(this.getEntityBoundingBox(), d6);
            }
            this.setEntityBoundingBox(this.getEntityBoundingBox().offset(0.0, 0.0, d6));
            if (this.stepHeight > 0.0f && bl3 && (d10 != d4 || d12 != d6)) {
                double d13 = d4;
                double d14 = d5;
                double d15 = d6;
                AxisAlignedBB axisAlignedBB3 = this.getEntityBoundingBox();
                this.setEntityBoundingBox(axisAlignedBB);
                d5 = this.stepHeight;
                List<AxisAlignedBB> list2 = this.worldObj.getCollidingBoundingBoxes(this.player, this.getEntityBoundingBox().addCoord(d10, d5, d12));
                AxisAlignedBB axisAlignedBB4 = this.getEntityBoundingBox();
                AxisAlignedBB axisAlignedBB5 = axisAlignedBB4.addCoord(d10, 0.0, d12);
                double d16 = d5;
                for (AxisAlignedBB axisAlignedBB6 : list2) {
                    d16 = axisAlignedBB6.calculateYOffset(axisAlignedBB5, d16);
                }
                axisAlignedBB4 = axisAlignedBB4.offset(0.0, d16, 0.0);
                double d17 = d10;
                for (AxisAlignedBB axisAlignedBB7 : list2) {
                    d17 = axisAlignedBB7.calculateXOffset(axisAlignedBB4, d17);
                }
                axisAlignedBB4 = axisAlignedBB4.offset(d17, 0.0, 0.0);
                double d18 = d12;
                for (AxisAlignedBB axisAlignedBB8 : list2) {
                    d18 = axisAlignedBB8.calculateZOffset(axisAlignedBB4, d18);
                }
                axisAlignedBB4 = axisAlignedBB4.offset(0.0, 0.0, d18);
                Object object = this.getEntityBoundingBox();
                double d19 = d5;
                for (AxisAlignedBB axisAlignedBB9 : list2) {
                    d19 = axisAlignedBB9.calculateYOffset((AxisAlignedBB)object, d19);
                }
                object = ((AxisAlignedBB)object).offset(0.0, d19, 0.0);
                double d20 = d10;
                for (AxisAlignedBB axisAlignedBB10 : list2) {
                    d20 = axisAlignedBB10.calculateXOffset((AxisAlignedBB)object, d20);
                }
                object = ((AxisAlignedBB)object).offset(d20, 0.0, 0.0);
                double d21 = d12;
                for (AxisAlignedBB axisAlignedBB11 : list2) {
                    d21 = axisAlignedBB11.calculateZOffset((AxisAlignedBB)object, d21);
                }
                object = ((AxisAlignedBB)object).offset(0.0, 0.0, d21);
                double d22 = d17 * d17 + d18 * d18;
                double d23 = d20 * d20 + d21 * d21;
                if (d22 > d23) {
                    d4 = d17;
                    d6 = d18;
                    d5 = -d16;
                    this.setEntityBoundingBox(axisAlignedBB4);
                } else {
                    d4 = d20;
                    d6 = d21;
                    d5 = -d19;
                    this.setEntityBoundingBox((AxisAlignedBB)object);
                }
                for (AxisAlignedBB axisAlignedBB12 : list2) {
                    d5 = axisAlignedBB12.calculateYOffset(this.getEntityBoundingBox(), d5);
                }
                this.setEntityBoundingBox(this.getEntityBoundingBox().offset(0.0, d5, 0.0));
                if (d13 * d13 + d15 * d15 >= d4 * d4 + d6 * d6) {
                    d4 = d13;
                    d5 = d14;
                    d6 = d15;
                    this.setEntityBoundingBox(axisAlignedBB3);
                }
            }
            this.resetPositionToBB();
            this.isCollidedHorizontally = d10 != d4 || d12 != d6;
            this.isCollidedVertically = d11 != d5;
            this.onGround = this.isCollidedVertically && d11 < 0.0;
            this.isCollided = this.isCollidedHorizontally || this.isCollidedVertically;
            int n = MathHelper.floor_double(this.posX);
            int n2 = MathHelper.floor_double(this.posY - (double)0.2f);
            int n3 = MathHelper.floor_double(this.posZ);
            BlockPos blockPos = new BlockPos(n, n2, n3);
            Block block = this.worldObj.getBlockState(blockPos).getBlock();
            if (block.getMaterial() == Material.air && ((throwable = this.worldObj.getBlockState(blockPos.down()).getBlock()) instanceof BlockFence || throwable instanceof BlockWall || throwable instanceof BlockFenceGate)) {
                block = throwable;
            }
            this.updateFallState(d5, this.onGround);
            if (d10 != d4) {
                this.motionX = 0.0;
            }
            if (d12 != d6) {
                this.motionZ = 0.0;
            }
            if (d11 != d5) {
                this.onLanded(block);
            }
            if (this.canTriggerWalking() && !bl && this.ridingEntity == null) {
                double bl4 = this.posX - d7;
                double d24 = this.posY - d8;
                double d25 = this.posZ - d9;
                if (block != Blocks.ladder) {
                    d24 = 0.0;
                }
                if (block != null && this.onGround) {
                    this.onEntityCollidedWithBlock(block);
                }
                this.distanceWalkedModified = (float)((double)this.distanceWalkedModified + (double)MathHelper.sqrt_double(bl4 * bl4 + d25 * d25) * 0.6);
                this.distanceWalkedOnStepModified = (float)((double)this.distanceWalkedOnStepModified + (double)MathHelper.sqrt_double(bl4 * bl4 + d24 * d24 + d25 * d25) * 0.6);
                if (this.distanceWalkedOnStepModified > (float)this.nextStepDistance && block.getMaterial() != Material.air) {
                    this.nextStepDistance = (int)this.distanceWalkedOnStepModified + 1;
                }
            }
            try {
                this.doBlockCollisions();
            }
            catch (Throwable throwable2) {
                throwable2.printStackTrace();
            }
            boolean bl4 = this.isWet();
            if (this.worldObj.isFlammableWithin(this.getEntityBoundingBox().contract(0.001, 0.001, 0.001))) {
                if (!bl4) {
                    ++this.fire;
                    if (this.fire == 0) {
                        this.setFire(0x8446DC3E ^ 0x8446DC36);
                    }
                }
            } else if (this.fire <= 0) {
                this.fire = -this.fireResistance;
            }
            if (bl4 && this.fire > 0) {
                this.fire = -this.fireResistance;
            }
        }
    }

    public AxisAlignedBB getEntityBoundingBox() {
        return this.box;
    }

    public void setEntityBoundingBox(AxisAlignedBB axisAlignedBB) {
        this.box = axisAlignedBB;
    }

    public void setOnFireFromLava() {
        this.setFire(0xD8FE1B79 ^ 0xD8FE1B76);
    }

    public void setFire(int n) {
        int n2 = n * (0x5BC64DD5 ^ 0x5BC64DC1);
        if (this.fire < (n2 = EnchantmentProtection.getFireTimeForEntity(this.player, n2))) {
            this.fire = n2;
        }
    }

    public boolean isWet() {
        return this.inWater || this.isRainingAt(new BlockPos(this.posX, this.posY, this.posZ)) || this.isRainingAt(new BlockPos(this.posX, this.posY + (double)this.height, this.posZ));
    }

    public void doBlockCollisions() {
        BlockPos blockPos = new BlockPos(this.getEntityBoundingBox().minX + 0.001, this.getEntityBoundingBox().minY + 0.001, this.getEntityBoundingBox().minZ + 0.001);
        BlockPos blockPos2 = new BlockPos(this.getEntityBoundingBox().maxX - 0.001, this.getEntityBoundingBox().maxY - 0.001, this.getEntityBoundingBox().maxZ - 0.001);
        if (this.isAreaLoaded(blockPos.getX(), blockPos.getY(), blockPos.getZ(), blockPos2.getX(), blockPos2.getY(), blockPos2.getZ(), true)) {
            for (int i = blockPos.getX(); i <= blockPos2.getX(); ++i) {
                for (int j = blockPos.getY(); j <= blockPos2.getY(); ++j) {
                    for (int k = blockPos.getZ(); k <= blockPos2.getZ(); ++k) {
                        BlockPos blockPos3 = new BlockPos(i, j, k);
                        IBlockState iBlockState = this.worldObj.getBlockState(blockPos3);
                        try {
                            Block block = iBlockState.getBlock();
                            if (block instanceof BlockWeb) {
                                this.isInWeb = true;
                                continue;
                            }
                            if (!(block instanceof BlockSoulSand)) continue;
                            this.motionX *= 0.4;
                            this.motionZ *= 0.4;
                            continue;
                        }
                        catch (Throwable throwable) {
                            throwable.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public void updateFallState(double d, boolean bl) {
        if (!this.isInWater()) {
            this.handleWaterMovement();
        }
        if (bl) {
            if (this.fallDistance > 0.0f) {
                this.fallDistance = 0.0f;
            }
        } else if (d < 0.0) {
            this.fallDistance = (float)((double)this.fallDistance - d);
        }
    }

    public boolean handleWaterMovement() {
        if (this.handleMaterialAcceleration(this.getEntityBoundingBox().expand(0.0, -0.4f, 0.0).contract(0.001, 0.001, 0.001), Material.water)) {
            this.fallDistance = 0.0f;
            this.inWater = true;
            this.fire = 0;
        } else {
            this.inWater = false;
        }
        return this.inWater;
    }

    public boolean handleMaterialAcceleration(AxisAlignedBB axisAlignedBB, Material material) {
        int n;
        int n2 = MathHelper.floor_double(axisAlignedBB.minX);
        int n3 = MathHelper.floor_double(axisAlignedBB.maxX + 1.0);
        int n4 = MathHelper.floor_double(axisAlignedBB.minY);
        int n5 = MathHelper.floor_double(axisAlignedBB.maxY + 1.0);
        int n6 = MathHelper.floor_double(axisAlignedBB.minZ);
        if (!this.isAreaLoaded(n2, n4, n6, n3, n5, n = MathHelper.floor_double(axisAlignedBB.maxZ + 1.0), true)) {
            return false;
        }
        boolean bl = false;
        net.minecraft.util.Vec3 vec3 = new net.minecraft.util.Vec3(0.0, 0.0, 0.0);
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        for (int i = n2; i < n3; ++i) {
            for (int j = n4; j < n5; ++j) {
                for (int k = n6; k < n; ++k) {
                    double d;
                    Block block;
                    mutableBlockPos.set(i, j, k);
                    IBlockState iBlockState = this.getBlockState(mutableBlockPos);
                    if (iBlockState == null || (block = iBlockState.getBlock()) == null || block.getMaterial() != material || !((double)n5 >= (d = (double)((float)(j + 1) - BlockLiquid.getLiquidHeightPercent(iBlockState.getValue(BlockLiquid.LEVEL)))))) continue;
                    bl = true;
                    vec3 = block.modifyAcceleration(this.worldObj, mutableBlockPos, this.player, vec3);
                }
            }
        }
        if (vec3.lengthVector() > 0.0 && this.isPushedByWater()) {
            vec3 = vec3.normalize();
            double d = 0.014;
            this.motionX += vec3.xCoord * d;
            this.motionY += vec3.yCoord * d;
            this.motionZ += vec3.zCoord * d;
        }
        return bl;
    }

    public boolean isAreaLoaded(int n, int n2, int n3, int n4, int n5, int n6, boolean bl) {
        if (n5 >= 0 && n2 < (0x2ACA5E9C ^ 0x2ACA5F9C)) {
            n3 >>= 0x2ACA5F98 ^ 0x2ACA5F9C;
            n4 >>= 0x2ACA5F98 ^ 0x2ACA5F9C;
            n6 >>= 0x2ACA5F98 ^ 0x2ACA5F9C;
            for (int i = n >>= 0x2ACA5F98 ^ 0x2ACA5F9C; i <= n4; ++i) {
                for (int j = n3; j <= n6; ++j) {
                    if (this.isChunkLoaded(i, j, bl)) continue;
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public void onEntityCollidedWithBlock(Block block) {
        if (block instanceof BlockSlime && Math.abs(this.motionY) < 0.1 && !this.isSneaking()) {
            double d = 0.4 + Math.abs(this.motionY) * 0.2;
            this.motionX *= d;
            this.motionZ *= d;
        }
    }

    public boolean canTriggerWalking() {
        return !this.capabilities.isFlying;
    }

    public boolean isOnLadder() {
        int n;
        int n2;
        int n3 = MathHelper.floor_double(this.posX);
        Block block = this.worldObj.getBlockState(new BlockPos(n3, n2 = MathHelper.floor_double(this.getEntityBoundingBox().minY), n = MathHelper.floor_double(this.posZ))).getBlock();
        return (block == Blocks.ladder || block == Blocks.vine) && !this.isSpectator;
    }

    public void moveFlying(float f, float f2, float f3) {
        float f4 = f;
        float f5 = f2;
        float f6 = f4 * f4 + f5 * f5;
        if (f6 >= 1.0E-4f) {
            if ((f6 = MathHelper.sqrt_float(f6)) < 1.0f) {
                f6 = 1.0f;
            }
            f6 = f3 / f6;
            float f7 = MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0f);
            float f8 = MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0f);
            this.motionX += (double)((f4 *= f6) * f8 - (f5 *= f6) * f7);
            this.motionZ += (double)(f5 * f8 + f4 * f7);
        }
    }

    public void jump() {
        this.motionY = this.getJumpUpwardsMotion();
        if (this.isPotionActive(Potion.jump)) {
            this.motionY += (double)((float)(this.getActivePotionEffect(Potion.jump).getAmplifier() + 1) * 0.1f);
        }
        if (this.isSprinting()) {
            float f = this.rotationYaw * ((float)Math.PI / 180);
            this.motionX -= (double)(MathHelper.sin(f) * 0.2f);
            this.motionZ += (double)(MathHelper.cos(f) * 0.2f);
        }
        this.isAirBorne = true;
    }

    public boolean isSprinting() {
        return this.isSprinting;
    }

    public boolean isPotionActive(Potion potion) {
        return this.player.getActivePotionEffect(potion) != null;
    }

    public PotionEffect getActivePotionEffect(Potion potion) {
        return this.player.getActivePotionEffect(potion);
    }

    public float getJumpUpwardsMotion() {
        return 0.42f;
    }

    public boolean isInWater() {
        return this.inWater;
    }

    public void updateLivingEntityInput() {
        this.moveForward = this.movementInput.moveForward;
        this.moveStrafing = this.movementInput.moveStrafe;
        this.isJumping = this.movementInput.jump;
    }

    public boolean isServerWorld() {
        return true;
    }

    public boolean isMovementBlocked() {
        return this.player.getHealth() <= 0.0f || this.player.isPlayerSleeping();
    }

    public boolean isInLava() {
        return this.worldObj.isMaterialInBB(this.getEntityBoundingBox().expand(-0.1f, -0.4f, -0.1f), Material.lava);
    }

    public void updateAITick() {
        this.motionY += (double)0.04f;
    }

    public boolean isOffsetPositionInLiquid(double d, double d2, double d3) {
        AxisAlignedBB axisAlignedBB = this.getEntityBoundingBox().offset(d, d2, d3);
        return this.isLiquidPresentInAABB(axisAlignedBB);
    }

    public boolean isLiquidPresentInAABB(AxisAlignedBB axisAlignedBB) {
        return this.worldObj.getCollidingBoundingBoxes(this.player, axisAlignedBB).isEmpty() && !this.worldObj.isAnyLiquid(axisAlignedBB);
    }

    public List<AxisAlignedBB> getCollidingBoundingBoxes(AxisAlignedBB axisAlignedBB) {
        ArrayList<AxisAlignedBB> arrayList = Lists.newArrayList();
        int n = MathHelper.floor_double(axisAlignedBB.minX);
        int n2 = MathHelper.floor_double(axisAlignedBB.maxX + 1.0);
        int n3 = MathHelper.floor_double(axisAlignedBB.minY);
        int n4 = MathHelper.floor_double(axisAlignedBB.maxY + 1.0);
        int n5 = MathHelper.floor_double(axisAlignedBB.minZ);
        int n6 = MathHelper.floor_double(axisAlignedBB.maxZ + 1.0);
        WorldBorder worldBorder = this.getWorldBorder();
        boolean bl = this.isOutsideBorder;
        boolean bl2 = this.isInsideBorder(worldBorder, bl);
        IBlockState iBlockState = Blocks.stone.getDefaultState();
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        for (int i = n; i < n2; ++i) {
            for (int j = n5; j < n6; ++j) {
                if (!this.isBlockLoaded(mutableBlockPos.set(i, 0x6859ADA5 ^ 0x6859ADE5, j))) continue;
                for (int k = n3 - 1; k < n4; ++k) {
                    mutableBlockPos.set(i, k, j);
                    if (bl && bl2) {
                        this.isOutsideBorder = false;
                    } else if (!bl && !bl2) {
                        this.isOutsideBorder = true;
                    }
                    Object object = iBlockState;
                    if (worldBorder.contains(mutableBlockPos) || !bl2) {
                        object = this.getBlockState(mutableBlockPos);
                    }
                    object.getBlock().addCollisionBoxesToList(this.worldObj, mutableBlockPos, (IBlockState)object, axisAlignedBB, arrayList, this.player);
                }
            }
        }
        double d = 0.25;
        List<Entity> list = this.getEntitiesWithinAABBExcludingEntity(this.player, axisAlignedBB.expand(d, d, d));
        for (Entity entity : list) {
            if (this.riddenByEntity == entity || this.ridingEntity == entity) continue;
            AxisAlignedBB axisAlignedBB2 = entity.getCollisionBoundingBox();
            if (axisAlignedBB2 != null && axisAlignedBB2.intersectsWith(axisAlignedBB)) {
                arrayList.add(axisAlignedBB2);
            }
            if ((axisAlignedBB2 = this.getCollisionBox(this.player, entity)) == null || !axisAlignedBB2.intersectsWith(axisAlignedBB)) continue;
            arrayList.add(axisAlignedBB2);
        }
        return arrayList;
    }

    public IBlockState getBlockState(BlockPos blockPos) {
        return this.worldObj.getBlockState(blockPos);
    }

    private Chunk getChunkFromBlockCoords(BlockPos blockPos) {
        return this.getChunkFromChunkCoords(blockPos.getX() >> (0xC21E8BC1 ^ 0xC21E8BC5), blockPos.getZ() >> (0xC21E8BC1 ^ 0xC21E8BC5));
    }

    private Chunk getChunkFromChunkCoords(int n, int n2) {
        return this.chunkProvider.provideChunk(n, n2);
    }

    private boolean isValid(BlockPos blockPos) {
        return blockPos.getX() >= (0x22001590 ^ 0xDC362910) && blockPos.getZ() >= (0x22001590 ^ 0xDC362910) && blockPos.getX() < (0xDDFFEA90 ^ 0xDC362910) && blockPos.getZ() < (0xDDFFEA90 ^ 0xDC362910) && blockPos.getY() >= 0 && blockPos.getY() < (0xDC362810 ^ 0xDC362910);
    }

    private WorldBorder getWorldBorder() {
        return this.worldBorder;
    }

    private boolean isInsideBorder(WorldBorder worldBorder, boolean bl) {
        double d = worldBorder.minX();
        double d2 = worldBorder.minZ();
        double d3 = worldBorder.maxX();
        double d4 = worldBorder.maxZ();
        if (bl) {
            d += 1.0;
            d2 += 1.0;
            d3 -= 1.0;
            d4 -= 1.0;
        } else {
            d -= 1.0;
            d2 -= 1.0;
            d3 += 1.0;
            d4 += 1.0;
        }
        return this.posX > d && this.posX < d3 && this.posZ > d2 && this.posZ < d4;
    }

    private boolean isBlockLoaded(BlockPos blockPos) {
        return this.isBlockLoaded(blockPos, true);
    }

    private boolean isBlockLoaded(BlockPos blockPos, boolean bl) {
        return this.isValid(blockPos) && this.isChunkLoaded(blockPos.getX() >> (0x7F1B494F ^ 0x7F1B494B), blockPos.getZ() >> (0x7F1B494F ^ 0x7F1B494B), bl);
    }

    private boolean isChunkLoaded(int n, int n2, boolean bl) {
        return this.chunkProvider.chunkExists(n, n2) && (bl || !this.chunkProvider.provideChunk(n, n2).isEmpty());
    }

    private List<Entity> getEntitiesWithinAABBExcludingEntity(Entity entity, AxisAlignedBB axisAlignedBB) {
        return this.getEntitiesInAABBexcluding(entity, axisAlignedBB, EntitySelectors.NOT_SPECTATING);
    }

    private List<Entity> getEntitiesInAABBexcluding(Entity entity, AxisAlignedBB axisAlignedBB, Predicate<Entity> predicate) {
        ArrayList<Entity> arrayList = Lists.newArrayList();
        int n = MathHelper.floor_double((axisAlignedBB.minX - 2.0) / 16.0);
        int n2 = MathHelper.floor_double((axisAlignedBB.maxX + 2.0) / 16.0);
        int n3 = MathHelper.floor_double((axisAlignedBB.minZ - 2.0) / 16.0);
        int n4 = MathHelper.floor_double((axisAlignedBB.maxZ + 2.0) / 16.0);
        for (int i = n; i <= n2; ++i) {
            for (int j = n3; j <= n4; ++j) {
                if (!this.isChunkLoaded(i, j, true)) continue;
                this.getChunkFromChunkCoords(i, j).getEntitiesWithinAABBForEntity(entity, axisAlignedBB, arrayList, predicate);
            }
        }
        return arrayList;
    }

    private AxisAlignedBB getCollisionBox(Entity entity, Entity entity2) {
        if (entity2 instanceof EntityBoat) {
            return entity2.getEntityBoundingBox();
        }
        if (entity2 instanceof EntityMinecart) {
            return entity.getCollisionBox(entity2);
        }
        return null;
    }

    private float getAIMoveSpeed() {
        return (float)this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue();
    }

    private IAttributeInstance getEntityAttribute(IAttribute iAttribute) {
        return this.getAttributeMap().getAttributeInstance(iAttribute);
    }

    private BaseAttributeMap getAttributeMap() {
        if (this.attributeMap == null) {
            this.attributeMap = new ServersideAttributeMap();
        }
        return this.attributeMap;
    }

    private void resetPositionToBB() {
        this.posX = (this.getEntityBoundingBox().minX + this.getEntityBoundingBox().maxX) / 2.0;
        this.posY = this.getEntityBoundingBox().minY;
        this.posZ = (this.getEntityBoundingBox().minZ + this.getEntityBoundingBox().maxZ) / 2.0;
    }

    private void onLanded(Block block) {
        if (block instanceof BlockSlime) {
            if (this.isSneaking()) {
                this.motionY = 0.0;
            } else if (this.motionY < 0.0) {
                this.motionY = -this.motionY;
            }
        } else {
            this.motionY = 0.0;
        }
    }

    public boolean isSneaking() {
        return this.movementInput.sneak && !this.player.isPlayerSleeping();
    }

    private boolean isRainingAt(BlockPos blockPos) {
        if ((double)this.worldObj.getRainStrength(1.0f) <= 0.2) {
            return false;
        }
        if (!this.canSeeSky(blockPos)) {
            return false;
        }
        if (this.worldObj.getPrecipitationHeight(blockPos).getY() > blockPos.getY()) {
            return false;
        }
        BiomeGenBase biomeGenBase = this.worldObj.getBiomeGenForCoords(blockPos);
        if (biomeGenBase.getEnableSnow()) {
            return false;
        }
        if (this.worldObj.canSnowAt(blockPos, false)) {
            return false;
        }
        return biomeGenBase.canRain();
    }

    private boolean canSeeSky(BlockPos blockPos) {
        return this.getChunkFromBlockCoords(blockPos).canSeeSky(blockPos);
    }

    private boolean isPushedByWater() {
        return !this.capabilities.isFlying;
    }

    public Pair<Double, Double> checkForCollision(SimulatedPlayer simulatedPlayer, double d, double d2) {
        EntityPlayerSP entityPlayerSP = SimulatedPlayer.mc.thePlayer;
        World world2 = entityPlayerSP.worldObj;
        double d3 = d;
        double d4 = d2;
        double d5 = 0.05;
        while (d != 0.0 && world2.getCollidingBoundingBoxes(entityPlayerSP, simulatedPlayer.box.offset(d, -1.0, 0.0)).isEmpty()) {
            d = d < d5 && d >= -d5 ? 0.0 : (d > 0.0 ? (d -= d5) : (d += d5));
            d3 = d;
        }
        while (d2 != 0.0 && world2.getCollidingBoundingBoxes(entityPlayerSP, simulatedPlayer.box.offset(0.0, -1.0, d2)).isEmpty()) {
            d2 = d2 < d5 && d2 >= -d5 ? 0.0 : (d2 > 0.0 ? (d2 -= d5) : (d2 += d5));
            d4 = d2;
        }
        while (d != 0.0 && d2 != 0.0 && world2.getCollidingBoundingBoxes(entityPlayerSP, simulatedPlayer.box.offset(d, -1.0, d2)).isEmpty()) {
            d = d < d5 && d >= -d5 ? 0.0 : (d > 0.0 ? (d -= d5) : (d += d5));
            d3 = d;
            d2 = d2 < d5 && d2 >= -d5 ? 0.0 : (d2 > 0.0 ? (d2 -= d5) : (d2 += d5));
            d4 = d2;
        }
        return Pair.of(d3, d4);
    }

    public float getEyeHeight() {
        return this.height * 0.85f;
    }
}


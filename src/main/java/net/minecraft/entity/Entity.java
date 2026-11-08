/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity;

import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import de.florianmichael.viamcp.ViaMCP;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Callable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockWall;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.command.CommandResultStats;
import net.minecraft.command.ICommandSender;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentProtection;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.event.HoverEvent;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ReportedException;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import x.E;
import x.oc5540c34271;
import x.oc55585a6f85;
import x.oc9755810e45;
import x.oc9ee35e7bd8;
import x.oca62773982d;
import x.oca8d3b21c30;
import x.ocafaaad134a;
import x.ocbb7e5a42d7;
import x.ocea775c9d5c;
import x.ocee33618a8d;

public abstract class Entity
implements ICommandSender,
oc5540c34271,
ocafaaad134a {
    private static final AxisAlignedBB ZERO_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
    private static int nextEntityID;
    private int entityId = nextEntityID++;
    public double renderDistanceWeight = 1.0;
    public boolean preventEntitySpawning;
    public Entity riddenByEntity;
    public Entity ridingEntity;
    public boolean forceSpawn;
    public World worldObj;
    public double prevPosX;
    public double prevPosY;
    public double prevPosZ;
    public double posX;
    public double posY;
    public double posZ;
    public double motionX;
    public double motionY;
    public double motionZ;
    public float rotationYaw;
    public float rotationPitch;
    public float prevRotationYaw;
    public float prevRotationPitch;
    private AxisAlignedBB boundingBox = ZERO_AABB;
    public boolean onGround;
    public boolean isCollidedHorizontally;
    public boolean isCollidedVertically;
    public boolean isCollided;
    public boolean velocityChanged;
    protected boolean isInWeb;
    private boolean isOutsideBorder;
    public boolean isDead;
    public float width = 0.6f;
    public float height = 1.8f;
    public float prevDistanceWalkedModified;
    public float distanceWalkedModified;
    public float distanceWalkedOnStepModified;
    public float fallDistance;
    private int nextStepDistance = 1;
    public double lastTickPosX;
    public double lastTickPosY;
    public double lastTickPosZ;
    public float stepHeight;
    public boolean noClip;
    public float entityCollisionReduction;
    protected Random rand = new ocbb7e5a42d7();
    public int ticksExisted;
    public int fireResistance = 1;
    private int fire;
    protected boolean inWater;
    public int hurtResistantTime;
    protected boolean firstUpdate = true;
    protected boolean isImmuneToFire;
    protected DataWatcher dataWatcher;
    private double entityRiderPitchDelta;
    private double entityRiderYawDelta;
    public boolean addedToChunk;
    public int chunkCoordX;
    public int chunkCoordY;
    public int chunkCoordZ;
    public int serverPosX;
    public int serverPosY;
    public int serverPosZ;
    public boolean ignoreFrustumCheck;
    public boolean isAirBorne;
    public int timeUntilPortal;
    protected boolean inPortal;
    protected int portalCounter;
    public int dimension;
    protected BlockPos lastPortalPos;
    protected Vec3 lastPortalVec;
    protected EnumFacing teleportDirection;
    private boolean invulnerable;
    protected UUID entityUniqueID = MathHelper.getRandomUuid(this.rand);
    private final CommandResultStats cmdResultStats = new CommandResultStats();
    private double backtrackTrueX;
    private double backtrackTrueY;
    private double backtrackTrueZ;
    private double backtrackLerpX;
    private double backtrackLerpY;
    private double backtrackLerpZ;
    private boolean backtrackTruePosition;

    public int getEntityId() {
        return this.entityId;
    }

    public void setEntityId(int n) {
        this.entityId = n;
    }

    public void onKillCommand() {
        this.setDead();
    }

    public Entity(World world2) {
        this.worldObj = world2;
        this.setPosition(0.0, 0.0, 0.0);
        if (world2 != null) {
            this.dimension = world2.provider.getDimensionId();
        }
        this.dataWatcher = new DataWatcher(this);
        this.dataWatcher.addObject(0, (byte)0);
        this.dataWatcher.addObject(1, (short)300);
        this.dataWatcher.addObject(3, (byte)0);
        this.dataWatcher.addObject(2, "");
        this.dataWatcher.addObject(4, (byte)0);
        this.entityInit();
    }

    protected abstract void entityInit();

    public DataWatcher getDataWatcher() {
        return this.dataWatcher;
    }

    public boolean equals(Object object) {
        return object instanceof Entity ? ((Entity)object).entityId == this.entityId : false;
    }

    public int hashCode() {
        return this.entityId;
    }

    protected void preparePlayerToSpawn() {
        block1: {
            if (this.worldObj == null) break block1;
            while (this.posY > 0.0 && this.posY < 256.0) {
                this.setPosition(this.posX, this.posY, this.posZ);
                if (this.worldObj.getCollidingBoundingBoxes(this, this.getEntityBoundingBox()).isEmpty()) break;
                this.posY += 1.0;
            }
            this.motionZ = 0.0;
            this.motionY = 0.0;
            this.motionX = 0.0;
            this.rotationPitch = 0.0f;
        }
    }

    public void setDead() {
        this.isDead = true;
    }

    protected void setSize(float f, float f2) {
        if (f != this.width || f2 != this.height) {
            float f3 = this.width;
            this.width = f;
            this.height = f2;
            this.setEntityBoundingBox(new AxisAlignedBB(this.getEntityBoundingBox().minX, this.getEntityBoundingBox().minY, this.getEntityBoundingBox().minZ, this.getEntityBoundingBox().minX + (double)this.width, this.getEntityBoundingBox().minY + (double)this.height, this.getEntityBoundingBox().minZ + (double)this.width));
            if (this.width > f3 && !this.firstUpdate && !this.worldObj.isRemote) {
                this.moveEntity(f3 - this.width, 0.0, f3 - this.width);
            }
        }
    }

    protected void setRotation(float f, float f2) {
        this.rotationYaw = f % 360.0f;
        this.rotationPitch = f2 % 360.0f;
    }

    public void setPosition(double d, double d2, double d3) {
        this.posX = d;
        this.posY = d2;
        this.posZ = d3;
        float f = this.width / 2.0f;
        float f2 = this.height;
        this.setEntityBoundingBox(new AxisAlignedBB(d - (double)f, d2, d3 - (double)f, d + (double)f, d2 + (double)f2, d3 + (double)f));
    }

    public void setAngles(float f, float f2) {
        oc9ee35e7bd8 oc9ee35e7bd82;
        if (this instanceof EntityPlayerSP && (oc9ee35e7bd82 = oc9755810e45.\u0411) != null && oc9ee35e7bd82.\u00d6()) {
            oc9ee35e7bd82.\u02af(f, f2);
            return;
        }
        float f3 = this.rotationPitch;
        float f4 = this.rotationYaw;
        this.rotationYaw = (float)((double)this.rotationYaw + (double)f * 0.15);
        this.rotationPitch = (float)((double)this.rotationPitch - (double)f2 * 0.15);
        this.rotationPitch = MathHelper.clamp_float(this.rotationPitch, -90.0f, 90.0f);
        this.prevRotationPitch += this.rotationPitch - f3;
        this.prevRotationYaw += this.rotationYaw - f4;
    }

    public void onUpdate() {
        this.onEntityUpdate();
    }

    public void onEntityUpdate() {
        this.worldObj.theProfiler.startSection("entityBaseTick");
        if (this.ridingEntity != null && this.ridingEntity.isDead) {
            this.ridingEntity = null;
        }
        this.prevDistanceWalkedModified = this.distanceWalkedModified;
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.prevRotationPitch = this.rotationPitch;
        this.prevRotationYaw = this.rotationYaw;
        if (!this.worldObj.isRemote && this.worldObj instanceof WorldServer) {
            this.worldObj.theProfiler.startSection("portal");
            MinecraftServer minecraftServer = ((WorldServer)this.worldObj).getMinecraftServer();
            int n = this.getMaxInPortalTime();
            if (this.inPortal) {
                if (minecraftServer.getAllowNether()) {
                    if (this.ridingEntity == null && this.portalCounter++ >= n) {
                        this.portalCounter = n;
                        this.timeUntilPortal = this.getPortalCooldown();
                        int n2 = this.worldObj.provider.getDimensionId() == -1 ? 0 : -1;
                        this.travelToDimension(n2);
                    }
                    this.inPortal = false;
                }
            } else {
                if (this.portalCounter > 0) {
                    this.portalCounter -= 4;
                }
                if (this.portalCounter < 0) {
                    this.portalCounter = 0;
                }
            }
            if (this.timeUntilPortal > 0) {
                --this.timeUntilPortal;
            }
            this.worldObj.theProfiler.endSection();
        }
        this.spawnRunningParticles();
        this.handleWaterMovement();
        if (this.worldObj.isRemote) {
            this.fire = 0;
        } else if (this.fire > 0) {
            if (this.isImmuneToFire) {
                this.fire -= 4;
                if (this.fire < 0) {
                    this.fire = 0;
                }
            } else {
                if (this.fire % 20 == 0) {
                    this.attackEntityFrom(DamageSource.onFire, 1.0f);
                }
                --this.fire;
            }
        }
        if (this.isInLava()) {
            this.setOnFireFromLava();
            this.fallDistance *= 0.5f;
        }
        if (this.posY < -64.0) {
            this.kill();
        }
        if (!this.worldObj.isRemote) {
            this.setFlag(0, this.fire > 0);
        }
        this.firstUpdate = false;
        this.worldObj.theProfiler.endSection();
    }

    public int getMaxInPortalTime() {
        return 0;
    }

    protected void setOnFireFromLava() {
        if (!this.isImmuneToFire) {
            this.attackEntityFrom(DamageSource.lava, 4.0f);
            this.setFire(15);
        }
    }

    public void setFire(int n) {
        int n2 = n * 20;
        if (this.fire < (n2 = EnchantmentProtection.getFireTimeForEntity(this, n2))) {
            this.fire = n2;
        }
    }

    public void extinguish() {
        this.fire = 0;
    }

    protected void kill() {
        this.setDead();
    }

    public boolean isOffsetPositionInLiquid(double d, double d2, double d3) {
        AxisAlignedBB axisAlignedBB = this.getEntityBoundingBox().offset(d, d2, d3);
        return this.isLiquidPresentInAABB(axisAlignedBB);
    }

    private boolean isLiquidPresentInAABB(AxisAlignedBB axisAlignedBB) {
        return this.worldObj.getCollidingBoundingBoxes(this, axisAlignedBB).isEmpty() && !this.worldObj.isAnyLiquid(axisAlignedBB);
    }

    public void moveEntity(double d, double d2, double d3) {
        this.mimeow$injectPlayerMoveEvent(d, d2, d3, new ocee33618a8d("moveEntity", false));
        if (this.noClip) {
            this.setEntityBoundingBox(this.getEntityBoundingBox().offset(d, d2, d3));
            this.resetPositionToBB();
        } else {
            Block throwable;
            Object object;
            Object object2;
            boolean bl;
            this.worldObj.theProfiler.startSection("move");
            double d4 = this.posX;
            double d5 = this.posY;
            double d6 = this.posZ;
            if (this.isInWeb) {
                this.isInWeb = false;
                d *= 0.25;
                d2 *= (double)0.05f;
                d3 *= 0.25;
                this.motionX = 0.0;
                this.motionY = 0.0;
                this.motionZ = 0.0;
            }
            double d7 = d;
            double d8 = d2;
            double d9 = d3;
            boolean bl2 = bl = this.onGround && this.isSneaking() && this instanceof EntityPlayer;
            if (bl) {
                double d10 = 0.05;
                while (d != 0.0 && this.worldObj.getCollidingBoundingBoxes(this, this.getEntityBoundingBox().offset(d, -1.0, 0.0)).isEmpty()) {
                    d = d < d10 && d >= -d10 ? 0.0 : (d > 0.0 ? (d -= d10) : (d += d10));
                    d7 = d;
                }
                while (d3 != 0.0 && this.worldObj.getCollidingBoundingBoxes(this, this.getEntityBoundingBox().offset(0.0, -1.0, d3)).isEmpty()) {
                    d3 = d3 < d10 && d3 >= -d10 ? 0.0 : (d3 > 0.0 ? (d3 -= d10) : (d3 += d10));
                    d9 = d3;
                }
                while (d != 0.0 && d3 != 0.0 && this.worldObj.getCollidingBoundingBoxes(this, this.getEntityBoundingBox().offset(d, -1.0, d3)).isEmpty()) {
                    d = d < d10 && d >= -d10 ? 0.0 : (d > 0.0 ? (d -= d10) : (d += d10));
                    d7 = d;
                    d3 = d3 < d10 && d3 >= -d10 ? 0.0 : (d3 > 0.0 ? (d3 -= d10) : (d3 += d10));
                    d9 = d3;
                }
            }
            List<AxisAlignedBB> list = this.worldObj.getCollidingBoundingBoxes(this, this.getEntityBoundingBox().addCoord(d, d2, d3));
            AxisAlignedBB axisAlignedBB = this.getEntityBoundingBox();
            for (AxisAlignedBB iterator2 : list) {
                d2 = iterator2.calculateYOffset(this.getEntityBoundingBox(), d2);
            }
            this.setEntityBoundingBox(this.getEntityBoundingBox().offset(0.0, d2, 0.0));
            boolean bl3 = this.onGround || d8 != d2 && d8 < 0.0;
            for (AxisAlignedBB axisAlignedBB2 : list) {
                d = axisAlignedBB2.calculateXOffset(this.getEntityBoundingBox(), d);
            }
            this.setEntityBoundingBox(this.getEntityBoundingBox().offset(d, 0.0, 0.0));
            for (AxisAlignedBB axisAlignedBB2 : list) {
                d3 = axisAlignedBB2.calculateZOffset(this.getEntityBoundingBox(), d3);
            }
            this.setEntityBoundingBox(this.getEntityBoundingBox().offset(0.0, 0.0, d3));
            if (this.mimeow$redirectStepHeight(this) > 0.0f && bl3 && (d7 != d || d9 != d3)) {
                double d10 = d;
                double d11 = d2;
                double d12 = d3;
                object2 = this.getEntityBoundingBox();
                this.setEntityBoundingBox(axisAlignedBB);
                d2 = this.stepHeight;
                object = this.worldObj.getCollidingBoundingBoxes(this, this.getEntityBoundingBox().addCoord(d7, d2, d9));
                AxisAlignedBB axisAlignedBB3 = this.getEntityBoundingBox();
                AxisAlignedBB axisAlignedBB4 = axisAlignedBB3.addCoord(d7, 0.0, d9);
                double d13 = d2;
                Iterator<AxisAlignedBB> iterator2 = object.iterator();
                while (iterator2.hasNext()) {
                    AxisAlignedBB axisAlignedBB5 = iterator2.next();
                    d13 = axisAlignedBB5.calculateYOffset(axisAlignedBB4, d13);
                }
                axisAlignedBB3 = axisAlignedBB3.offset(0.0, d13, 0.0);
                double d14 = d7;
                Iterator<AxisAlignedBB> iterator3 = object.iterator();
                while (iterator3.hasNext()) {
                    AxisAlignedBB axisAlignedBB6 = iterator3.next();
                    d14 = axisAlignedBB6.calculateXOffset(axisAlignedBB3, d14);
                }
                axisAlignedBB3 = axisAlignedBB3.offset(d14, 0.0, 0.0);
                double d15 = d9;
                Object object3 = object.iterator();
                while (object3.hasNext()) {
                    AxisAlignedBB axisAlignedBB7 = object3.next();
                    d15 = axisAlignedBB7.calculateZOffset(axisAlignedBB3, d15);
                }
                axisAlignedBB3 = axisAlignedBB3.offset(0.0, 0.0, d15);
                object3 = this.getEntityBoundingBox();
                double d16 = d2;
                Iterator<AxisAlignedBB> iterator4 = object.iterator();
                while (iterator4.hasNext()) {
                    AxisAlignedBB axisAlignedBB8 = iterator4.next();
                    d16 = axisAlignedBB8.calculateYOffset((AxisAlignedBB)object3, d16);
                }
                object3 = ((AxisAlignedBB)object3).offset(0.0, d16, 0.0);
                double d17 = d7;
                Iterator iterator5 = object.iterator();
                while (iterator5.hasNext()) {
                    AxisAlignedBB axisAlignedBB9 = (AxisAlignedBB)iterator5.next();
                    d17 = axisAlignedBB9.calculateXOffset((AxisAlignedBB)object3, d17);
                }
                object3 = ((AxisAlignedBB)object3).offset(d17, 0.0, 0.0);
                double d18 = d9;
                Iterator iterator6 = object.iterator();
                while (iterator6.hasNext()) {
                    AxisAlignedBB axisAlignedBB10 = (AxisAlignedBB)iterator6.next();
                    d18 = axisAlignedBB10.calculateZOffset((AxisAlignedBB)object3, d18);
                }
                object3 = ((AxisAlignedBB)object3).offset(0.0, 0.0, d18);
                double d19 = d14 * d14 + d15 * d15;
                double d20 = d17 * d17 + d18 * d18;
                if (d19 > d20) {
                    d = d14;
                    d3 = d15;
                    d2 = -d13;
                    this.setEntityBoundingBox(axisAlignedBB3);
                } else {
                    d = d17;
                    d3 = d18;
                    d2 = -d16;
                    this.setEntityBoundingBox((AxisAlignedBB)object3);
                }
                Iterator iterator7 = object.iterator();
                while (iterator7.hasNext()) {
                    AxisAlignedBB axisAlignedBB11 = (AxisAlignedBB)iterator7.next();
                    d2 = axisAlignedBB11.calculateYOffset(this.getEntityBoundingBox(), d2);
                }
                this.setEntityBoundingBox(this.getEntityBoundingBox().offset(0.0, d2, 0.0));
                if (d10 * d10 + d12 * d12 >= d * d + d3 * d3) {
                    d = d10;
                    d2 = d11;
                    d3 = d12;
                    this.setEntityBoundingBox((AxisAlignedBB)object2);
                }
            }
            this.worldObj.theProfiler.endSection();
            this.worldObj.theProfiler.startSection("rest");
            this.resetPositionToBB();
            this.isCollidedHorizontally = d7 != d || d9 != d3;
            this.isCollidedVertically = d8 != d2;
            this.onGround = this.isCollidedVertically && d8 < 0.0;
            this.isCollided = this.isCollidedHorizontally || this.isCollidedVertically;
            int n = MathHelper.floor_double(this.posX);
            int n2 = MathHelper.floor_double(this.posY - (double)0.2f);
            int n3 = MathHelper.floor_double(this.posZ);
            BlockPos blockPos = new BlockPos(n, n2, n3);
            Block block = this.worldObj.getBlockState(blockPos).getBlock();
            if (block.getMaterial() == Material.air && ((throwable = this.worldObj.getBlockState(blockPos.down()).getBlock()) instanceof BlockFence || throwable instanceof BlockWall || throwable instanceof BlockFenceGate)) {
                block = throwable;
                blockPos = blockPos.down();
            }
            this.updateFallState(d2, this.onGround, block, blockPos);
            if (d7 != d) {
                this.motionX = 0.0;
            }
            if (d9 != d3) {
                this.motionZ = 0.0;
            }
            if (d8 != d2) {
                block.onLanded(this.worldObj, this);
            }
            if (this.canTriggerWalking() && !bl && this.ridingEntity == null) {
                double bl4 = this.posX - d4;
                double d21 = this.posY - d5;
                double d22 = this.posZ - d6;
                if (block != Blocks.ladder) {
                    d21 = 0.0;
                }
                if (block != null && this.onGround) {
                    block.onEntityCollidedWithBlock(this.worldObj, blockPos, this);
                }
                this.distanceWalkedModified = (float)((double)this.distanceWalkedModified + (double)MathHelper.sqrt_double(bl4 * bl4 + d22 * d22) * 0.6);
                this.distanceWalkedOnStepModified = (float)((double)this.distanceWalkedOnStepModified + (double)MathHelper.sqrt_double(bl4 * bl4 + d21 * d21 + d22 * d22) * 0.6);
                if (this.distanceWalkedOnStepModified > (float)this.nextStepDistance && block.getMaterial() != Material.air) {
                    this.nextStepDistance = (int)this.distanceWalkedOnStepModified + 1;
                    if (this.isInWater()) {
                        float f = MathHelper.sqrt_double(this.motionX * this.motionX * (double)0.2f + this.motionY * this.motionY + this.motionZ * this.motionZ * (double)0.2f) * 0.35f;
                        if (f > 1.0f) {
                            f = 1.0f;
                        }
                        this.playSound(this.getSwimSound(), f, 1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.4f);
                    }
                    this.playStepSound(blockPos, block);
                }
            }
            try {
                this.doBlockCollisions();
            }
            catch (Throwable throwable2) {
                object2 = CrashReport.makeCrashReport(throwable2, "Checking entity block collision");
                object = ((CrashReport)object2).makeCategory("Entity being checked for collision");
                this.addEntityCrashInfo((CrashReportCategory)object);
                throw new ReportedException((CrashReport)object2);
            }
            boolean bl4 = this.isWet();
            if (this.worldObj.isFlammableWithin(this.getEntityBoundingBox().contract(0.001, 0.001, 0.001))) {
                this.dealFireDamage(1);
                if (!bl4) {
                    ++this.fire;
                    if (this.fire == 0) {
                        this.setFire(8);
                    }
                }
            } else if (this.fire <= 0) {
                this.fire = -this.fireResistance;
            }
            if (bl4 && this.fire > 0) {
                this.playSound("random.fizz", 0.7f, 1.6f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.4f);
                this.fire = -this.fireResistance;
            }
            this.worldObj.theProfiler.endSection();
        }
    }

    private void resetPositionToBB() {
        this.posX = (this.getEntityBoundingBox().minX + this.getEntityBoundingBox().maxX) / 2.0;
        this.posY = this.getEntityBoundingBox().minY;
        this.posZ = (this.getEntityBoundingBox().minZ + this.getEntityBoundingBox().maxZ) / 2.0;
    }

    protected String getSwimSound() {
        return "game.neutral.swim";
    }

    protected void doBlockCollisions() {
        BlockPos blockPos = new BlockPos(this.getEntityBoundingBox().minX + 0.001, this.getEntityBoundingBox().minY + 0.001, this.getEntityBoundingBox().minZ + 0.001);
        BlockPos blockPos2 = new BlockPos(this.getEntityBoundingBox().maxX - 0.001, this.getEntityBoundingBox().maxY - 0.001, this.getEntityBoundingBox().maxZ - 0.001);
        if (this.worldObj.isAreaLoaded(blockPos, blockPos2)) {
            for (int i = blockPos.getX(); i <= blockPos2.getX(); ++i) {
                for (int j = blockPos.getY(); j <= blockPos2.getY(); ++j) {
                    for (int k = blockPos.getZ(); k <= blockPos2.getZ(); ++k) {
                        BlockPos blockPos3 = new BlockPos(i, j, k);
                        IBlockState iBlockState = this.worldObj.getBlockState(blockPos3);
                        try {
                            iBlockState.getBlock().onEntityCollidedWithBlock(this.worldObj, blockPos3, iBlockState, this);
                            continue;
                        }
                        catch (Throwable throwable) {
                            CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Colliding entity with block");
                            CrashReportCategory crashReportCategory = crashReport.makeCategory("Block being collided with");
                            CrashReportCategory.addBlockInfo(crashReportCategory, blockPos3, iBlockState);
                            throw new ReportedException(crashReport);
                        }
                    }
                }
            }
        }
    }

    protected void playStepSound(BlockPos blockPos, Block block) {
        Block.SoundType soundType = block.stepSound;
        if (this.worldObj.getBlockState(blockPos.up()).getBlock() == Blocks.snow_layer) {
            soundType = Blocks.snow_layer.stepSound;
            this.playSound(soundType.getStepSound(), soundType.getVolume() * 0.15f, soundType.getFrequency());
        } else if (!block.getMaterial().isLiquid()) {
            this.playSound(soundType.getStepSound(), soundType.getVolume() * 0.15f, soundType.getFrequency());
        }
    }

    public void playSound(String string, float f, float f2) {
        if (!this.isSilent()) {
            this.worldObj.playSoundAtEntity(this, string, f, f2);
        }
    }

    public boolean isSilent() {
        return this.dataWatcher.getWatchableObjectByte(4) == 1;
    }

    public void setSilent(boolean bl) {
        this.dataWatcher.updateObject(4, (byte)(bl ? 1 : 0));
    }

    protected boolean canTriggerWalking() {
        return true;
    }

    protected void updateFallState(double d, boolean bl, Block block, BlockPos blockPos) {
        if (bl) {
            if (this.fallDistance > 0.0f) {
                if (block != null) {
                    block.onFallenUpon(this.worldObj, blockPos, this, this.fallDistance);
                } else {
                    this.fall(this.fallDistance, 1.0f);
                }
                this.fallDistance = 0.0f;
            }
        } else if (d < 0.0) {
            this.fallDistance = (float)((double)this.fallDistance - d);
        }
    }

    public AxisAlignedBB getCollisionBoundingBox() {
        return null;
    }

    protected void dealFireDamage(int n) {
        if (!this.isImmuneToFire) {
            this.attackEntityFrom(DamageSource.inFire, n);
        }
    }

    public final boolean isImmuneToFire() {
        return this.isImmuneToFire;
    }

    public void fall(float f, float f2) {
        if (this.riddenByEntity != null) {
            this.riddenByEntity.fall(f, f2);
        }
    }

    public boolean isWet() {
        return this.inWater || this.worldObj.isRainingAt(new BlockPos(this.posX, this.posY, this.posZ)) || this.worldObj.isRainingAt(new BlockPos(this.posX, this.posY + (double)this.height, this.posZ));
    }

    public boolean isInWater() {
        return this.inWater;
    }

    public boolean handleWaterMovement() {
        if (this.worldObj.handleMaterialAcceleration(this.getEntityBoundingBox().expand(0.0, -0.4f, 0.0).contract(0.001, 0.001, 0.001), Material.water, this)) {
            if (!this.inWater && !this.firstUpdate) {
                this.resetHeight();
            }
            this.fallDistance = 0.0f;
            this.inWater = true;
            this.fire = 0;
        } else {
            this.inWater = false;
        }
        return this.inWater;
    }

    protected void resetHeight() {
        float f;
        float f2;
        float f3 = MathHelper.sqrt_double(this.motionX * this.motionX * (double)0.2f + this.motionY * this.motionY + this.motionZ * this.motionZ * (double)0.2f) * 0.2f;
        if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        this.playSound(this.getSplashSound(), f3, 1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.4f);
        float f4 = MathHelper.floor_double(this.getEntityBoundingBox().minY);
        int n = 0;
        while ((float)n < 1.0f + this.width * 20.0f) {
            f2 = (this.rand.nextFloat() * 2.0f - 1.0f) * this.width;
            f = (this.rand.nextFloat() * 2.0f - 1.0f) * this.width;
            this.worldObj.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX + (double)f2, (double)(f4 + 1.0f), this.posZ + (double)f, this.motionX, this.motionY - (double)(this.rand.nextFloat() * 0.2f), this.motionZ, new int[0]);
            ++n;
        }
        n = 0;
        while ((float)n < 1.0f + this.width * 20.0f) {
            f2 = (this.rand.nextFloat() * 2.0f - 1.0f) * this.width;
            f = (this.rand.nextFloat() * 2.0f - 1.0f) * this.width;
            this.worldObj.spawnParticle(EnumParticleTypes.WATER_SPLASH, this.posX + (double)f2, (double)(f4 + 1.0f), this.posZ + (double)f, this.motionX, this.motionY, this.motionZ, new int[0]);
            ++n;
        }
    }

    public void spawnRunningParticles() {
        if (this.isSprinting() && !this.isInWater()) {
            this.createRunningParticles();
        }
    }

    protected void createRunningParticles() {
        int n;
        int n2;
        int n3 = MathHelper.floor_double(this.posX);
        BlockPos blockPos = new BlockPos(n3, n2 = MathHelper.floor_double(this.posY - (double)0.2f), n = MathHelper.floor_double(this.posZ));
        IBlockState iBlockState = this.worldObj.getBlockState(blockPos);
        Block block = iBlockState.getBlock();
        if (block.getRenderType() != -1) {
            this.worldObj.spawnParticle(EnumParticleTypes.BLOCK_CRACK, this.posX + ((double)this.rand.nextFloat() - 0.5) * (double)this.width, this.getEntityBoundingBox().minY + 0.1, this.posZ + ((double)this.rand.nextFloat() - 0.5) * (double)this.width, -this.motionX * 4.0, 1.5, -this.motionZ * 4.0, Block.getStateId(iBlockState));
        }
    }

    protected String getSplashSound() {
        return "game.neutral.swim.splash";
    }

    public boolean isInsideOfMaterial(Material material) {
        double d = this.posY + (double)this.getEyeHeight();
        BlockPos blockPos = new BlockPos(this.posX, d, this.posZ);
        IBlockState iBlockState = this.worldObj.getBlockState(blockPos);
        Block block = iBlockState.getBlock();
        if (block.getMaterial() == material) {
            float f = BlockLiquid.getLiquidHeightPercent(iBlockState.getBlock().getMetaFromState(iBlockState)) - 0.11111111f;
            float f2 = (float)(blockPos.getY() + 1) - f;
            boolean bl = d < (double)f2;
            return !bl && this instanceof EntityPlayer ? false : bl;
        }
        return false;
    }

    public boolean isInLava() {
        return this.worldObj.isMaterialInBB(this.getEntityBoundingBox().expand(-0.1f, -0.4f, -0.1f), Material.lava);
    }

    public int getBrightnessForRender(float f) {
        BlockPos blockPos = new BlockPos(this.posX, this.posY + (double)this.getEyeHeight(), this.posZ);
        return this.worldObj.isBlockLoaded(blockPos) ? this.worldObj.getCombinedLight(blockPos, 0) : 0;
    }

    public float getBrightness(float f) {
        BlockPos blockPos = new BlockPos(this.posX, this.posY + (double)this.getEyeHeight(), this.posZ);
        return this.worldObj.isBlockLoaded(blockPos) ? this.worldObj.getLightBrightness(blockPos) : 0.0f;
    }

    public void setWorld(World world2) {
        this.worldObj = world2;
    }

    public void setPositionAndRotation(double d, double d2, double d3, float f, float f2) {
        this.prevPosX = this.posX = d;
        this.prevPosY = this.posY = d2;
        this.prevPosZ = this.posZ = d3;
        this.prevRotationYaw = this.rotationYaw = f;
        this.prevRotationPitch = this.rotationPitch = f2;
        double d4 = this.prevRotationYaw - f;
        if (d4 < -180.0) {
            this.prevRotationYaw += 360.0f;
        }
        if (d4 >= 180.0) {
            this.prevRotationYaw -= 360.0f;
        }
        this.setPosition(this.posX, this.posY, this.posZ);
        this.setRotation(f, f2);
    }

    public void moveToBlockPosAndAngles(BlockPos blockPos, float f, float f2) {
        this.setLocationAndAngles((double)blockPos.getX() + 0.5, blockPos.getY(), (double)blockPos.getZ() + 0.5, f, f2);
    }

    public void setLocationAndAngles(double d, double d2, double d3, float f, float f2) {
        this.prevPosX = this.posX = d;
        this.lastTickPosX = this.posX;
        this.prevPosY = this.posY = d2;
        this.lastTickPosY = this.posY;
        this.prevPosZ = this.posZ = d3;
        this.lastTickPosZ = this.posZ;
        this.rotationYaw = f;
        this.rotationPitch = f2;
        this.setPosition(this.posX, this.posY, this.posZ);
    }

    public float getDistanceToEntity(Entity entity) {
        float f = (float)(this.posX - entity.posX);
        float f2 = (float)(this.posY - entity.posY);
        float f3 = (float)(this.posZ - entity.posZ);
        return MathHelper.sqrt_float(f * f + f2 * f2 + f3 * f3);
    }

    public double getDistanceSq(double d, double d2, double d3) {
        double d4 = this.posX - d;
        double d5 = this.posY - d2;
        double d6 = this.posZ - d3;
        return d4 * d4 + d5 * d5 + d6 * d6;
    }

    public double getDistanceSq(BlockPos blockPos) {
        return blockPos.distanceSq(this.posX, this.posY, this.posZ);
    }

    public double getDistanceSqToCenter(BlockPos blockPos) {
        return blockPos.distanceSqToCenter(this.posX, this.posY, this.posZ);
    }

    public double getDistance(double d, double d2, double d3) {
        double d4 = this.posX - d;
        double d5 = this.posY - d2;
        double d6 = this.posZ - d3;
        return MathHelper.sqrt_double(d4 * d4 + d5 * d5 + d6 * d6);
    }

    public double getDistanceSqToEntity(Entity entity) {
        double d = this.posX - entity.posX;
        double d2 = this.posY - entity.posY;
        double d3 = this.posZ - entity.posZ;
        return d * d + d2 * d2 + d3 * d3;
    }

    public void onCollideWithPlayer(EntityPlayer entityPlayer) {
    }

    public void applyEntityCollision(Entity entity) {
        double d;
        double d2;
        double d3;
        if (entity.riddenByEntity != this && entity.ridingEntity != this && !entity.noClip && !this.noClip && (d3 = MathHelper.abs_max(d2 = entity.posX - this.posX, d = entity.posZ - this.posZ)) >= (double)0.01f) {
            d3 = MathHelper.sqrt_double(d3);
            d2 /= d3;
            d /= d3;
            double d4 = 1.0 / d3;
            if (d4 > 1.0) {
                d4 = 1.0;
            }
            d2 *= d4;
            d *= d4;
            d2 *= (double)0.05f;
            d *= (double)0.05f;
            d2 *= (double)(1.0f - this.entityCollisionReduction);
            d *= (double)(1.0f - this.entityCollisionReduction);
            if (this.riddenByEntity == null) {
                this.addVelocity(-d2, 0.0, -d);
            }
            if (entity.riddenByEntity == null) {
                entity.addVelocity(d2, 0.0, d);
            }
        }
    }

    public void addVelocity(double d, double d2, double d3) {
        this.motionX += d;
        this.motionY += d2;
        this.motionZ += d3;
        this.isAirBorne = true;
    }

    protected void setBeenAttacked() {
        this.velocityChanged = true;
    }

    public boolean attackEntityFrom(DamageSource damageSource, float f) {
        if (this.isEntityInvulnerable(damageSource)) {
            return false;
        }
        this.setBeenAttacked();
        return false;
    }

    public Vec3 getLook(float f) {
        if (f == 1.0f) {
            return this.getVectorForRotation(this.rotationPitch, this.rotationYaw);
        }
        float f2 = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * f;
        float f3 = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * f;
        return this.getVectorForRotation(f2, f3);
    }

    public Vec3 getPositionEyes(float f) {
        if (f == 1.0f) {
            return new Vec3(this.posX, this.posY + (double)this.getEyeHeight(), this.posZ);
        }
        double d = this.prevPosX + (this.posX - this.prevPosX) * (double)f;
        double d2 = this.prevPosY + (this.posY - this.prevPosY) * (double)f + (double)this.getEyeHeight();
        double d3 = this.prevPosZ + (this.posZ - this.prevPosZ) * (double)f;
        return new Vec3(d, d2, d3);
    }

    public MovingObjectPosition rayTrace(double d, float f) {
        Vec3 vec3 = this.getPositionEyes(f);
        Vec3 vec32 = this.getLook(f);
        Vec3 vec33 = vec3.addVector(vec32.xCoord * d, vec32.yCoord * d, vec32.zCoord * d);
        return this.worldObj.rayTraceBlocks(vec3, vec33, false, false, true);
    }

    public boolean canBeCollidedWith() {
        return false;
    }

    public boolean canBePushed() {
        return false;
    }

    public void addToPlayerScore(Entity entity, int n) {
    }

    public boolean isInRangeToRender3d(double d, double d2, double d3) {
        double d4 = this.posX - d;
        double d5 = this.posY - d2;
        double d6 = this.posZ - d3;
        double d7 = d4 * d4 + d5 * d5 + d6 * d6;
        return this.isInRangeToRenderDist(d7);
    }

    public boolean isInRangeToRenderDist(double d) {
        double d2 = this.getEntityBoundingBox().getAverageEdgeLength();
        if (Double.isNaN(d2)) {
            d2 = 1.0;
        }
        return d < (d2 = d2 * 64.0 * this.renderDistanceWeight) * d2;
    }

    public boolean writeMountToNBT(NBTTagCompound nBTTagCompound) {
        String string = this.getEntityString();
        if (!this.isDead && string != null) {
            nBTTagCompound.setString("id", string);
            this.writeToNBT(nBTTagCompound);
            return true;
        }
        return false;
    }

    public boolean writeToNBTOptional(NBTTagCompound nBTTagCompound) {
        String string = this.getEntityString();
        if (!this.isDead && string != null && this.riddenByEntity == null) {
            nBTTagCompound.setString("id", string);
            this.writeToNBT(nBTTagCompound);
            return true;
        }
        return false;
    }

    public void writeToNBT(NBTTagCompound nBTTagCompound) {
        try {
            NBTTagCompound nBTTagCompound2;
            nBTTagCompound.setTag("Pos", this.newDoubleNBTList(this.posX, this.posY, this.posZ));
            nBTTagCompound.setTag("Motion", this.newDoubleNBTList(this.motionX, this.motionY, this.motionZ));
            nBTTagCompound.setTag("Rotation", this.newFloatNBTList(this.rotationYaw, this.rotationPitch));
            nBTTagCompound.setFloat("FallDistance", this.fallDistance);
            nBTTagCompound.setShort("Fire", (short)this.fire);
            nBTTagCompound.setShort("Air", (short)this.getAir());
            nBTTagCompound.setBoolean("OnGround", this.onGround);
            nBTTagCompound.setInteger("Dimension", this.dimension);
            nBTTagCompound.setBoolean("Invulnerable", this.invulnerable);
            nBTTagCompound.setInteger("PortalCooldown", this.timeUntilPortal);
            nBTTagCompound.setLong("UUIDMost", this.getUniqueID().getMostSignificantBits());
            nBTTagCompound.setLong("UUIDLeast", this.getUniqueID().getLeastSignificantBits());
            if (this.getCustomNameTag() != null && this.getCustomNameTag().length() > 0) {
                nBTTagCompound.setString("CustomName", this.getCustomNameTag());
                nBTTagCompound.setBoolean("CustomNameVisible", this.getAlwaysRenderNameTag());
            }
            this.cmdResultStats.writeStatsToNBT(nBTTagCompound);
            if (this.isSilent()) {
                nBTTagCompound.setBoolean("Silent", this.isSilent());
            }
            this.writeEntityToNBT(nBTTagCompound);
            if (this.ridingEntity != null && this.ridingEntity.writeMountToNBT(nBTTagCompound2 = new NBTTagCompound())) {
                nBTTagCompound.setTag("Riding", nBTTagCompound2);
            }
        }
        catch (Throwable throwable) {
            CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Saving entity NBT");
            CrashReportCategory crashReportCategory = crashReport.makeCategory("Entity being saved");
            this.addEntityCrashInfo(crashReportCategory);
            throw new ReportedException(crashReport);
        }
    }

    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        try {
            NBTTagList nBTTagList = nBTTagCompound.getTagList("Pos", 6);
            NBTTagList nBTTagList2 = nBTTagCompound.getTagList("Motion", 6);
            NBTTagList nBTTagList3 = nBTTagCompound.getTagList("Rotation", 5);
            this.motionX = nBTTagList2.getDoubleAt(0);
            this.motionY = nBTTagList2.getDoubleAt(1);
            this.motionZ = nBTTagList2.getDoubleAt(2);
            if (Math.abs(this.motionX) > 10.0) {
                this.motionX = 0.0;
            }
            if (Math.abs(this.motionY) > 10.0) {
                this.motionY = 0.0;
            }
            if (Math.abs(this.motionZ) > 10.0) {
                this.motionZ = 0.0;
            }
            this.lastTickPosX = this.posX = nBTTagList.getDoubleAt(0);
            this.prevPosX = this.posX;
            this.lastTickPosY = this.posY = nBTTagList.getDoubleAt(1);
            this.prevPosY = this.posY;
            this.lastTickPosZ = this.posZ = nBTTagList.getDoubleAt(2);
            this.prevPosZ = this.posZ;
            this.prevRotationYaw = this.rotationYaw = nBTTagList3.getFloatAt(0);
            this.prevRotationPitch = this.rotationPitch = nBTTagList3.getFloatAt(1);
            this.setRotationYawHead(this.rotationYaw);
            this.setRenderYawOffset(this.rotationYaw);
            this.fallDistance = nBTTagCompound.getFloat("FallDistance");
            this.fire = nBTTagCompound.getShort("Fire");
            this.setAir(nBTTagCompound.getShort("Air"));
            this.onGround = nBTTagCompound.getBoolean("OnGround");
            this.dimension = nBTTagCompound.getInteger("Dimension");
            this.invulnerable = nBTTagCompound.getBoolean("Invulnerable");
            this.timeUntilPortal = nBTTagCompound.getInteger("PortalCooldown");
            if (nBTTagCompound.hasKey("UUIDMost", 4) && nBTTagCompound.hasKey("UUIDLeast", 4)) {
                this.entityUniqueID = new UUID(nBTTagCompound.getLong("UUIDMost"), nBTTagCompound.getLong("UUIDLeast"));
            } else if (nBTTagCompound.hasKey("UUID", 8)) {
                this.entityUniqueID = UUID.fromString(nBTTagCompound.getString("UUID"));
            }
            this.setPosition(this.posX, this.posY, this.posZ);
            this.setRotation(this.rotationYaw, this.rotationPitch);
            if (nBTTagCompound.hasKey("CustomName", 8) && nBTTagCompound.getString("CustomName").length() > 0) {
                this.setCustomNameTag(nBTTagCompound.getString("CustomName"));
            }
            this.setAlwaysRenderNameTag(nBTTagCompound.getBoolean("CustomNameVisible"));
            this.cmdResultStats.readStatsFromNBT(nBTTagCompound);
            this.setSilent(nBTTagCompound.getBoolean("Silent"));
            this.readEntityFromNBT(nBTTagCompound);
            if (this.shouldSetPosAfterLoading()) {
                this.setPosition(this.posX, this.posY, this.posZ);
            }
        }
        catch (Throwable throwable) {
            CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Loading entity NBT");
            CrashReportCategory crashReportCategory = crashReport.makeCategory("Entity being loaded");
            this.addEntityCrashInfo(crashReportCategory);
            throw new ReportedException(crashReport);
        }
    }

    protected boolean shouldSetPosAfterLoading() {
        return true;
    }

    protected final String getEntityString() {
        return EntityList.getEntityString(this);
    }

    protected abstract void readEntityFromNBT(NBTTagCompound var1);

    protected abstract void writeEntityToNBT(NBTTagCompound var1);

    public void onChunkLoad() {
    }

    protected NBTTagList newDoubleNBTList(double ... dArray) {
        NBTTagList nBTTagList = new NBTTagList();
        for (double d : dArray) {
            nBTTagList.appendTag(new NBTTagDouble(d));
        }
        return nBTTagList;
    }

    protected NBTTagList newFloatNBTList(float ... fArray) {
        NBTTagList nBTTagList = new NBTTagList();
        for (float f : fArray) {
            nBTTagList.appendTag(new NBTTagFloat(f));
        }
        return nBTTagList;
    }

    public EntityItem dropItem(Item item, int n) {
        return this.dropItemWithOffset(item, n, 0.0f);
    }

    public EntityItem dropItemWithOffset(Item item, int n, float f) {
        return this.entityDropItem(new ItemStack(item, n, 0), f);
    }

    public EntityItem entityDropItem(ItemStack itemStack, float f) {
        if (itemStack.stackSize != 0 && itemStack.getItem() != null) {
            EntityItem entityItem = new EntityItem(this.worldObj, this.posX, this.posY + (double)f, this.posZ, itemStack);
            entityItem.setDefaultPickupDelay();
            this.worldObj.spawnEntityInWorld(entityItem);
            return entityItem;
        }
        return null;
    }

    public boolean isEntityAlive() {
        return !this.isDead;
    }

    public boolean isEntityInsideOpaqueBlock() {
        if (this.noClip) {
            return false;
        }
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
        for (int i = 0; i < 8; ++i) {
            int n = MathHelper.floor_double(this.posY + (double)(((float)((i >> 0) % 2) - 0.5f) * 0.1f) + (double)this.getEyeHeight());
            int n2 = MathHelper.floor_double(this.posX + (double)(((float)((i >> 1) % 2) - 0.5f) * this.width * 0.8f));
            int n3 = MathHelper.floor_double(this.posZ + (double)(((float)((i >> 2) % 2) - 0.5f) * this.width * 0.8f));
            if (mutableBlockPos.getX() == n2 && mutableBlockPos.getY() == n && mutableBlockPos.getZ() == n3) continue;
            mutableBlockPos.set(n2, n, n3);
            if (!this.worldObj.getBlockState(mutableBlockPos).getBlock().isVisuallyOpaque()) continue;
            return true;
        }
        return false;
    }

    public boolean interactFirst(EntityPlayer entityPlayer) {
        return false;
    }

    public AxisAlignedBB getCollisionBox(Entity entity) {
        return null;
    }

    public void updateRidden() {
        if (this.ridingEntity.isDead) {
            this.ridingEntity = null;
        } else {
            this.motionX = 0.0;
            this.motionY = 0.0;
            this.motionZ = 0.0;
            this.onUpdate();
            if (this.ridingEntity != null) {
                this.ridingEntity.updateRiderPosition();
                this.entityRiderYawDelta += (double)(this.ridingEntity.rotationYaw - this.ridingEntity.prevRotationYaw);
                this.entityRiderPitchDelta += (double)(this.ridingEntity.rotationPitch - this.ridingEntity.prevRotationPitch);
                while (this.entityRiderYawDelta >= 180.0) {
                    this.entityRiderYawDelta -= 360.0;
                }
                while (this.entityRiderYawDelta < -180.0) {
                    this.entityRiderYawDelta += 360.0;
                }
                while (this.entityRiderPitchDelta >= 180.0) {
                    this.entityRiderPitchDelta -= 360.0;
                }
                while (this.entityRiderPitchDelta < -180.0) {
                    this.entityRiderPitchDelta += 360.0;
                }
                double d = this.entityRiderYawDelta * 0.5;
                double d2 = this.entityRiderPitchDelta * 0.5;
                float f = 10.0f;
                if (d > (double)f) {
                    d = f;
                }
                if (d < (double)(-f)) {
                    d = -f;
                }
                if (d2 > (double)f) {
                    d2 = f;
                }
                if (d2 < (double)(-f)) {
                    d2 = -f;
                }
                this.entityRiderYawDelta -= d;
                this.entityRiderPitchDelta -= d2;
            }
        }
    }

    public void updateRiderPosition() {
        if (this.riddenByEntity != null) {
            this.riddenByEntity.setPosition(this.posX, this.posY + this.getMountedYOffset() + this.riddenByEntity.getYOffset(), this.posZ);
        }
    }

    public double getYOffset() {
        return 0.0;
    }

    public double getMountedYOffset() {
        return (double)this.height * 0.75;
    }

    public boolean canRiderInteract() {
        return false;
    }

    public void mountEntity(Entity entity) {
        this.entityRiderPitchDelta = 0.0;
        this.entityRiderYawDelta = 0.0;
        if (entity == null) {
            if (this.ridingEntity != null) {
                this.setLocationAndAngles(this.ridingEntity.posX, this.ridingEntity.getEntityBoundingBox().minY + (double)this.ridingEntity.height, this.ridingEntity.posZ, this.rotationYaw, this.rotationPitch);
                this.ridingEntity.riddenByEntity = null;
            }
            this.ridingEntity = null;
        } else {
            if (this.ridingEntity != null) {
                this.ridingEntity.riddenByEntity = null;
            }
            if (entity != null) {
                Entity entity2 = entity.ridingEntity;
                while (entity2 != null) {
                    if (entity2 == this) {
                        return;
                    }
                    entity2 = entity2.ridingEntity;
                }
            }
            this.ridingEntity = entity;
            entity.riddenByEntity = this;
        }
    }

    public void setPositionAndRotation2(double d, double d2, double d3, float f, float f2, int n, boolean bl) {
        this.setPosition(d, d2, d3);
        this.setRotation(f, f2);
        List<AxisAlignedBB> list = this.worldObj.getCollidingBoundingBoxes(this, this.getEntityBoundingBox().contract(0.03125, 0.0, 0.03125));
        if (!list.isEmpty()) {
            double d4 = 0.0;
            for (AxisAlignedBB axisAlignedBB : list) {
                if (!(axisAlignedBB.maxY > d4)) continue;
                d4 = axisAlignedBB.maxY;
            }
            this.setPosition(d, d2 += d4 - this.getEntityBoundingBox().minY, d3);
        }
    }

    public float getCollisionBorderSize() {
        return ViaMCP.isTargetVersionAtLeast(ProtocolVersion.v1_9) ? 0.0f : 0.1f;
    }

    public Vec3 getLookVec() {
        return null;
    }

    public void setPortal(BlockPos blockPos) {
        if (this.timeUntilPortal > 0) {
            this.timeUntilPortal = this.getPortalCooldown();
        } else {
            if (!this.worldObj.isRemote && !blockPos.equals(this.lastPortalPos)) {
                this.lastPortalPos = blockPos;
                BlockPattern.PatternHelper patternHelper = Blocks.portal.func_181089_f(this.worldObj, blockPos);
                double d = patternHelper.getFinger().getAxis() == EnumFacing.Axis.X ? (double)patternHelper.getPos().getZ() : (double)patternHelper.getPos().getX();
                double d2 = patternHelper.getFinger().getAxis() == EnumFacing.Axis.X ? this.posZ : this.posX;
                d2 = Math.abs(MathHelper.func_181160_c(d2 - (double)(patternHelper.getFinger().rotateY().getAxisDirection() == EnumFacing.AxisDirection.NEGATIVE ? 1 : 0), d, d - (double)patternHelper.func_181118_d()));
                double d3 = MathHelper.func_181160_c(this.posY - 1.0, patternHelper.getPos().getY(), patternHelper.getPos().getY() - patternHelper.func_181119_e());
                this.lastPortalVec = new Vec3(d2, d3, 0.0);
                this.teleportDirection = patternHelper.getFinger();
            }
            this.inPortal = true;
        }
    }

    public int getPortalCooldown() {
        return 300;
    }

    public void setVelocity(double d, double d2, double d3) {
        this.motionX = d;
        this.motionY = d2;
        this.motionZ = d3;
    }

    public void handleStatusUpdate(byte by) {
    }

    public void performHurtAnimation() {
    }

    public ItemStack[] getInventory() {
        return null;
    }

    public void setCurrentItemOrArmor(int n, ItemStack itemStack) {
    }

    public boolean isBurning() {
        boolean bl = this.worldObj != null && this.worldObj.isRemote;
        return !this.isImmuneToFire && (this.fire > 0 || bl && this.getFlag(0));
    }

    public boolean isRiding() {
        return this.ridingEntity != null;
    }

    public boolean isSneaking() {
        return this.getFlag(1);
    }

    public void setSneaking(boolean bl) {
        this.setFlag(1, bl);
    }

    public boolean isSprinting() {
        return this.getFlag(3);
    }

    public void setSprinting(boolean bl) {
        this.setFlag(3, bl);
    }

    public boolean isInvisible() {
        return this.getFlag(5);
    }

    public boolean isInvisibleToPlayer(EntityPlayer entityPlayer) {
        return entityPlayer.isSpectator() ? false : this.isInvisible();
    }

    public void setInvisible(boolean bl) {
        this.setFlag(5, bl);
    }

    public boolean isEating() {
        return this.getFlag(4);
    }

    public void setEating(boolean bl) {
        this.setFlag(4, bl);
    }

    protected boolean getFlag(int n) {
        return (this.dataWatcher.getWatchableObjectByte(0) & 1 << n) != 0;
    }

    protected void setFlag(int n, boolean bl) {
        byte by = this.dataWatcher.getWatchableObjectByte(0);
        if (bl) {
            this.dataWatcher.updateObject(0, (byte)(by | 1 << n));
        } else {
            this.dataWatcher.updateObject(0, (byte)(by & ~(1 << n)));
        }
    }

    public int getAir() {
        return this.dataWatcher.getWatchableObjectShort(1);
    }

    public void setAir(int n) {
        this.dataWatcher.updateObject(1, (short)n);
    }

    public void onStruckByLightning(EntityLightningBolt entityLightningBolt) {
        this.attackEntityFrom(DamageSource.lightningBolt, 5.0f);
        ++this.fire;
        if (this.fire == 0) {
            this.setFire(8);
        }
    }

    public void onKillEntity(EntityLivingBase entityLivingBase) {
    }

    protected boolean pushOutOfBlocks(double d, double d2, double d3) {
        BlockPos blockPos = new BlockPos(d, d2, d3);
        double d4 = d - (double)blockPos.getX();
        double d5 = d2 - (double)blockPos.getY();
        double d6 = d3 - (double)blockPos.getZ();
        List<AxisAlignedBB> list = this.worldObj.getCollisionBoxes(this.getEntityBoundingBox());
        if (list.isEmpty() && !this.worldObj.isBlockFullCube(blockPos)) {
            return false;
        }
        int n = 3;
        double d7 = 9999.0;
        if (!this.worldObj.isBlockFullCube(blockPos.west()) && d4 < d7) {
            d7 = d4;
            n = 0;
        }
        if (!this.worldObj.isBlockFullCube(blockPos.east()) && 1.0 - d4 < d7) {
            d7 = 1.0 - d4;
            n = 1;
        }
        if (!this.worldObj.isBlockFullCube(blockPos.up()) && 1.0 - d5 < d7) {
            d7 = 1.0 - d5;
            n = 3;
        }
        if (!this.worldObj.isBlockFullCube(blockPos.north()) && d6 < d7) {
            d7 = d6;
            n = 4;
        }
        if (!this.worldObj.isBlockFullCube(blockPos.south()) && 1.0 - d6 < d7) {
            d7 = 1.0 - d6;
            n = 5;
        }
        float f = this.rand.nextFloat() * 0.2f + 0.1f;
        if (n == 0) {
            this.motionX = -f;
        }
        if (n == 1) {
            this.motionX = f;
        }
        if (n == 3) {
            this.motionY = f;
        }
        if (n == 4) {
            this.motionZ = -f;
        }
        if (n == 5) {
            this.motionZ = f;
        }
        return true;
    }

    public void setInWeb() {
        this.isInWeb = true;
        this.fallDistance = 0.0f;
    }

    @Override
    public String getName() {
        if (this.hasCustomName()) {
            return this.getCustomNameTag();
        }
        String string = EntityList.getEntityString(this);
        if (string == null) {
            string = "generic";
        }
        return StatCollector.translateToLocal("entity." + string + ".name");
    }

    public Entity[] getParts() {
        return null;
    }

    public boolean isEntityEqual(Entity entity) {
        return this == entity;
    }

    public float getRotationYawHead() {
        return 0.0f;
    }

    public void setRotationYawHead(float f) {
    }

    public void setRenderYawOffset(float f) {
    }

    public boolean canAttackWithItem() {
        return true;
    }

    public boolean hitByEntity(Entity entity) {
        return false;
    }

    public String toString() {
        return String.format("%s['%s'/%d, l='%s', x=%.2f, y=%.2f, z=%.2f]", this.getClass().getSimpleName(), this.getName(), this.entityId, this.worldObj == null ? "~NULL~" : this.worldObj.getWorldInfo().getWorldName(), this.posX, this.posY, this.posZ);
    }

    public boolean isEntityInvulnerable(DamageSource damageSource) {
        return this.invulnerable && damageSource != DamageSource.outOfWorld && !damageSource.isCreativePlayer();
    }

    public void copyLocationAndAnglesFrom(Entity entity) {
        this.setLocationAndAngles(entity.posX, entity.posY, entity.posZ, entity.rotationYaw, entity.rotationPitch);
    }

    public void copyDataFromOld(Entity entity) {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        entity.writeToNBT(nBTTagCompound);
        this.readFromNBT(nBTTagCompound);
        this.timeUntilPortal = entity.timeUntilPortal;
        this.lastPortalPos = entity.lastPortalPos;
        this.lastPortalVec = entity.lastPortalVec;
        this.teleportDirection = entity.teleportDirection;
    }

    public void travelToDimension(int n) {
        if (!this.worldObj.isRemote && !this.isDead) {
            this.worldObj.theProfiler.startSection("changeDimension");
            MinecraftServer minecraftServer = MinecraftServer.getServer();
            int n2 = this.dimension;
            WorldServer worldServer = minecraftServer.worldServerForDimension(n2);
            WorldServer worldServer2 = minecraftServer.worldServerForDimension(n);
            this.dimension = n;
            if (n2 == 1 && n == 1) {
                worldServer2 = minecraftServer.worldServerForDimension(0);
                this.dimension = 0;
            }
            this.worldObj.removeEntity(this);
            this.isDead = false;
            this.worldObj.theProfiler.startSection("reposition");
            minecraftServer.getConfigurationManager().transferEntityToWorld(this, n2, worldServer, worldServer2);
            this.worldObj.theProfiler.endStartSection("reloading");
            Entity entity = EntityList.createEntityByName(EntityList.getEntityString(this), worldServer2);
            if (entity != null) {
                entity.copyDataFromOld(this);
                if (n2 == 1 && n == 1) {
                    BlockPos blockPos = this.worldObj.getTopSolidOrLiquidBlock(worldServer2.getSpawnPoint());
                    entity.moveToBlockPosAndAngles(blockPos, entity.rotationYaw, entity.rotationPitch);
                }
                worldServer2.spawnEntityInWorld(entity);
            }
            this.isDead = true;
            this.worldObj.theProfiler.endSection();
            worldServer.resetUpdateEntityTick();
            worldServer2.resetUpdateEntityTick();
            this.worldObj.theProfiler.endSection();
        }
    }

    public float getExplosionResistance(Explosion explosion, World world2, BlockPos blockPos, IBlockState iBlockState) {
        return iBlockState.getBlock().getExplosionResistance(this);
    }

    public boolean verifyExplosion(Explosion explosion, World world2, BlockPos blockPos, IBlockState iBlockState, float f) {
        return true;
    }

    public int getMaxFallHeight() {
        return 3;
    }

    public Vec3 func_181014_aG() {
        return this.lastPortalVec;
    }

    public EnumFacing getTeleportDirection() {
        return this.teleportDirection;
    }

    public boolean doesEntityNotTriggerPressurePlate() {
        return false;
    }

    public void addEntityCrashInfo(CrashReportCategory crashReportCategory) {
        crashReportCategory.addCrashSectionCallable("Entity Type", new Callable<String>(){

            @Override
            public String call() throws Exception {
                return EntityList.getEntityString(Entity.this) + " (" + Entity.this.getClass().getCanonicalName() + ")";
            }
        });
        crashReportCategory.addCrashSection("Entity ID", this.entityId);
        crashReportCategory.addCrashSectionCallable("Entity Name", new Callable<String>(){

            @Override
            public String call() throws Exception {
                return Entity.this.getName();
            }
        });
        crashReportCategory.addCrashSection("Entity's Exact location", String.format("%.2f, %.2f, %.2f", this.posX, this.posY, this.posZ));
        crashReportCategory.addCrashSection("Entity's Block location", CrashReportCategory.getCoordinateInfo(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)));
        crashReportCategory.addCrashSection("Entity's Momentum", String.format("%.2f, %.2f, %.2f", this.motionX, this.motionY, this.motionZ));
        crashReportCategory.addCrashSectionCallable("Entity's Rider", new Callable<String>(){

            @Override
            public String call() throws Exception {
                return Entity.this.riddenByEntity.toString();
            }
        });
        crashReportCategory.addCrashSectionCallable("Entity's Vehicle", new Callable<String>(){

            @Override
            public String call() throws Exception {
                return Entity.this.ridingEntity.toString();
            }
        });
    }

    public boolean canRenderOnFire() {
        return this.isBurning();
    }

    public UUID getUniqueID() {
        return this.entityUniqueID;
    }

    public boolean isPushedByWater() {
        return true;
    }

    @Override
    public IChatComponent getDisplayName() {
        ChatComponentText chatComponentText = new ChatComponentText(this.getName());
        chatComponentText.getChatStyle().setChatHoverEvent(this.getHoverEvent());
        chatComponentText.getChatStyle().setInsertion(this.getUniqueID().toString());
        return chatComponentText;
    }

    public void setCustomNameTag(String string) {
        this.dataWatcher.updateObject(2, string);
    }

    public String getCustomNameTag() {
        return this.dataWatcher.getWatchableObjectString(2);
    }

    public boolean hasCustomName() {
        return this.dataWatcher.getWatchableObjectString(2).length() > 0;
    }

    public void setAlwaysRenderNameTag(boolean bl) {
        this.dataWatcher.updateObject(3, (byte)(bl ? 1 : 0));
    }

    public boolean getAlwaysRenderNameTag() {
        return this.dataWatcher.getWatchableObjectByte(3) == 1;
    }

    public void setPositionAndUpdate(double d, double d2, double d3) {
        this.setLocationAndAngles(d, d2, d3, this.rotationYaw, this.rotationPitch);
    }

    public boolean getAlwaysRenderNameTagForRender() {
        return this.getAlwaysRenderNameTag();
    }

    public void onDataWatcherUpdate(int n) {
    }

    public EnumFacing getHorizontalFacing() {
        return EnumFacing.getHorizontal(MathHelper.floor_double((double)(this.rotationYaw * 4.0f / 360.0f) + 0.5) & 3);
    }

    protected HoverEvent getHoverEvent() {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        String string = EntityList.getEntityString(this);
        nBTTagCompound.setString("id", this.getUniqueID().toString());
        if (string != null) {
            nBTTagCompound.setString("type", string);
        }
        nBTTagCompound.setString("name", this.getName());
        return new HoverEvent(HoverEvent.Action.SHOW_ENTITY, new ChatComponentText(nBTTagCompound.toString()));
    }

    public boolean isSpectatedByPlayer(EntityPlayerMP entityPlayerMP) {
        return true;
    }

    public AxisAlignedBB getEntityBoundingBox() {
        return this.boundingBox;
    }

    public void setEntityBoundingBox(AxisAlignedBB axisAlignedBB) {
        this.boundingBox = axisAlignedBB;
    }

    public float getEyeHeight() {
        return this.height * 0.85f;
    }

    public boolean isOutsideBorder() {
        return this.isOutsideBorder;
    }

    public void setOutsideBorder(boolean bl) {
        this.isOutsideBorder = bl;
    }

    public boolean replaceItemInInventory(int n, ItemStack itemStack) {
        return false;
    }

    @Override
    public void addChatMessage(IChatComponent iChatComponent) {
    }

    @Override
    public boolean canCommandSenderUseCommand(int n, String string) {
        return true;
    }

    @Override
    public BlockPos getPosition() {
        return new BlockPos(this.posX, this.posY + 0.5, this.posZ);
    }

    @Override
    public Vec3 getPositionVector() {
        return new Vec3(this.posX, this.posY, this.posZ);
    }

    @Override
    public World getEntityWorld() {
        return this.worldObj;
    }

    @Override
    public Entity getCommandSenderEntity() {
        return this;
    }

    @Override
    public boolean sendCommandFeedback() {
        return false;
    }

    @Override
    public void setCommandStat(CommandResultStats.Type type, int n) {
        this.cmdResultStats.setCommandStatScore(this, type, n);
    }

    public CommandResultStats getCommandStats() {
        return this.cmdResultStats;
    }

    public void setCommandStats(Entity entity) {
        this.cmdResultStats.addAllStats(entity.getCommandStats());
    }

    public NBTTagCompound getNBTTagCompound() {
        return null;
    }

    public void clientUpdateEntityNBT(NBTTagCompound nBTTagCompound) {
    }

    public boolean interactAt(EntityPlayer entityPlayer, Vec3 vec3) {
        return false;
    }

    public boolean isImmuneToExplosions() {
        return false;
    }

    protected void applyEnchantments(EntityLivingBase entityLivingBase, Entity entity) {
        if (entity instanceof EntityLivingBase) {
            EnchantmentHelper.applyThornEnchantments((EntityLivingBase)entity, entityLivingBase);
        }
        EnchantmentHelper.applyArthropodEnchantments(entityLivingBase, entity);
    }

    public void moveFlying(float f, float f2, float f3) {
        oc55585a6f85 oc55585a6f852 = new oc55585a6f85(f, f2, f3, this.rotationYaw);
        if (this == Minecraft.getMinecraft().thePlayer) {
            ocea775c9d5c.\u0173.post(oc55585a6f852);
        }
        f = oc55585a6f852.\u00cc();
        f2 = oc55585a6f852.\u01f0();
        f3 = oc55585a6f852.\u04cf();
        float f4 = oc55585a6f852.\u048b();
        float f5 = f * f + f2 * f2;
        if (f5 >= 1.0E-4f) {
            if ((f5 = MathHelper.sqrt_float(f5)) < 1.0f) {
                f5 = 1.0f;
            }
            f5 = f3 / f5;
            float f6 = MathHelper.sin(f4 * (float)Math.PI / 180.0f);
            float f7 = MathHelper.cos(f4 * (float)Math.PI / 180.0f);
            this.motionX += (double)((f *= f5) * f7 - (f2 *= f5) * f6);
            this.motionZ += (double)(f2 * f7 + f * f6);
        }
    }

    private float mimeow$redirectStepHeight(Entity entity) {
        oca62773982d oca62773982d2 = new oca62773982d(entity, entity.stepHeight);
        ocea775c9d5c.\u0173.post(oca62773982d2);
        return oca62773982d2.\u037d;
    }

    protected final Vec3 getVectorForRotation(float f, float f2) {
        E e = new E(f2, f);
        ocea775c9d5c.\u0173.post(e);
        f = e.\u01ee;
        f2 = e.\u01fd;
        float f3 = MathHelper.cos(-f2 * ((float)Math.PI / 180) - (float)Math.PI);
        float f4 = MathHelper.sin(-f2 * ((float)Math.PI / 180) - (float)Math.PI);
        float f5 = -MathHelper.cos(-f * ((float)Math.PI / 180));
        float f6 = MathHelper.sin(-f * ((float)Math.PI / 180));
        return new Vec3(f4 * f5, f6, f3 * f5);
    }

    private void mimeow$injectPlayerMoveEvent(double d, double d2, double d3, ocee33618a8d ocee33618a8d2) {
        if (this instanceof EntityPlayerSP) {
            ocea775c9d5c.\u0173.post(new oca8d3b21c30(d, d2, d3));
        }
    }

    @Override
    public double getBacktrackTrueX() {
        return this.backtrackTrueX;
    }

    @Override
    public void setBacktrackTrueX(double d) {
        this.backtrackTrueX = d;
    }

    @Override
    public double getBacktrackTrueY() {
        return this.backtrackTrueY;
    }

    @Override
    public void setBacktrackTrueY(double d) {
        this.backtrackTrueY = d;
    }

    @Override
    public double getBacktrackTrueZ() {
        return this.backtrackTrueZ;
    }

    @Override
    public void setBacktrackTrueZ(double d) {
        this.backtrackTrueZ = d;
    }

    @Override
    public double getBacktrackLerpX() {
        return this.backtrackLerpX;
    }

    @Override
    public void setBacktrackLerpX(double d) {
        this.backtrackLerpX = d;
    }

    @Override
    public double getBacktrackLerpY() {
        return this.backtrackLerpY;
    }

    @Override
    public void setBacktrackLerpY(double d) {
        this.backtrackLerpY = d;
    }

    @Override
    public double getBacktrackLerpZ() {
        return this.backtrackLerpZ;
    }

    @Override
    public void setBacktrackLerpZ(double d) {
        this.backtrackLerpZ = d;
    }

    @Override
    public boolean hasBacktrackTruePosition() {
        return this.backtrackTruePosition;
    }

    @Override
    public void setBacktrackTruePosition(boolean bl) {
        this.backtrackTruePosition = bl;
    }

    @Override
    public int getFire() {
        return this.fire;
    }

    @Override
    public int getNextStepDistance() {
        return this.nextStepDistance;
    }

    @Override
    public boolean getIsInWeb() {
        return this.isInWeb;
    }
}


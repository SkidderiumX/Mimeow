/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.effect;

import java.util.List;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityWeatherEffect;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityLightningBolt
extends EntityWeatherEffect {
    private int lightningState;
    public long boltVertex;
    private int boltLivingTime;

    public EntityLightningBolt(World world2, double d, double d2, double d3) {
        super(world2);
        this.setLocationAndAngles(d, d2, d3, 0.0f, 0.0f);
        this.lightningState = 2;
        this.boltVertex = this.rand.nextLong();
        this.boltLivingTime = this.rand.nextInt(3) + 1;
        BlockPos blockPos = new BlockPos(this);
        if (!world2.isRemote && world2.getGameRules().getBoolean("doFireTick") && (world2.getDifficulty() == EnumDifficulty.NORMAL || world2.getDifficulty() == EnumDifficulty.HARD) && world2.isAreaLoaded(blockPos, 10)) {
            if (world2.getBlockState(blockPos).getBlock().getMaterial() == Material.air && Blocks.fire.canPlaceBlockAt(world2, blockPos)) {
                world2.setBlockState(blockPos, Blocks.fire.getDefaultState());
            }
            for (int i = 0; i < 4; ++i) {
                BlockPos blockPos2 = blockPos.add(this.rand.nextInt(3) - 1, this.rand.nextInt(3) - 1, this.rand.nextInt(3) - 1);
                if (world2.getBlockState(blockPos2).getBlock().getMaterial() != Material.air || !Blocks.fire.canPlaceBlockAt(world2, blockPos2)) continue;
                world2.setBlockState(blockPos2, Blocks.fire.getDefaultState());
            }
        }
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.lightningState == 2) {
            this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "ambient.weather.thunder", 10000.0f, 0.8f + this.rand.nextFloat() * 0.2f);
            this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "random.explode", 2.0f, 0.5f + this.rand.nextFloat() * 0.2f);
        }
        --this.lightningState;
        if (this.lightningState < 0) {
            if (this.boltLivingTime == 0) {
                this.setDead();
            } else if (this.lightningState < -this.rand.nextInt(10)) {
                --this.boltLivingTime;
                this.lightningState = 1;
                this.boltVertex = this.rand.nextLong();
                BlockPos blockPos = new BlockPos(this);
                if (!this.worldObj.isRemote && this.worldObj.getGameRules().getBoolean("doFireTick") && this.worldObj.isAreaLoaded(blockPos, 10) && this.worldObj.getBlockState(blockPos).getBlock().getMaterial() == Material.air && Blocks.fire.canPlaceBlockAt(this.worldObj, blockPos)) {
                    this.worldObj.setBlockState(blockPos, Blocks.fire.getDefaultState());
                }
            }
        }
        if (this.lightningState >= 0) {
            if (this.worldObj.isRemote) {
                this.worldObj.setLastLightningBolt(2);
            } else {
                double d = 3.0;
                List<Entity> list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, new AxisAlignedBB(this.posX - d, this.posY - d, this.posZ - d, this.posX + d, this.posY + 6.0 + d, this.posZ + d));
                for (int i = 0; i < list.size(); ++i) {
                    Entity entity = list.get(i);
                    entity.onStruckByLightning(this);
                }
            }
        }
    }

    @Override
    protected void entityInit() {
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
    }
}


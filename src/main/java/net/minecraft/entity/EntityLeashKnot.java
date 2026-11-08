/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity;

import net.minecraft.block.BlockFence;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class EntityLeashKnot
extends EntityHanging {
    public EntityLeashKnot(World world2) {
        super(world2);
    }

    public EntityLeashKnot(World world2, BlockPos blockPos) {
        super(world2, blockPos);
        this.setPosition((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.5, (double)blockPos.getZ() + 0.5);
        float f = 0.125f;
        float f2 = 0.1875f;
        float f3 = 0.25f;
        this.setEntityBoundingBox(new AxisAlignedBB(this.posX - 0.1875, this.posY - 0.25 + 0.125, this.posZ - 0.1875, this.posX + 0.1875, this.posY + 0.25 + 0.125, this.posZ + 0.1875));
    }

    @Override
    protected void entityInit() {
        super.entityInit();
    }

    @Override
    public void updateFacingWithBoundingBox(EnumFacing enumFacing) {
    }

    @Override
    public int getWidthPixels() {
        return 9;
    }

    @Override
    public int getHeightPixels() {
        return 9;
    }

    @Override
    public float getEyeHeight() {
        return -0.0625f;
    }

    @Override
    public boolean isInRangeToRenderDist(double d) {
        return d < 1024.0;
    }

    @Override
    public void onBroken(Entity entity) {
    }

    @Override
    public boolean writeToNBTOptional(NBTTagCompound nBTTagCompound) {
        return false;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
    }

    @Override
    public boolean interactFirst(EntityPlayer entityPlayer) {
        double d;
        ItemStack itemStack = entityPlayer.getHeldItem();
        boolean bl = false;
        if (itemStack != null && itemStack.getItem() == Items.lead && !this.worldObj.isRemote) {
            d = 7.0;
            for (EntityLiving entityLiving : this.worldObj.getEntitiesWithinAABB(EntityLiving.class, new AxisAlignedBB(this.posX - d, this.posY - d, this.posZ - d, this.posX + d, this.posY + d, this.posZ + d))) {
                if (!entityLiving.getLeashed() || entityLiving.getLeashedToEntity() != entityPlayer) continue;
                entityLiving.setLeashedToEntity(this, true);
                bl = true;
            }
        }
        if (!this.worldObj.isRemote && !bl) {
            this.setDead();
            if (entityPlayer.capabilities.isCreativeMode) {
                d = 7.0;
                for (EntityLiving entityLiving : this.worldObj.getEntitiesWithinAABB(EntityLiving.class, new AxisAlignedBB(this.posX - d, this.posY - d, this.posZ - d, this.posX + d, this.posY + d, this.posZ + d))) {
                    if (!entityLiving.getLeashed() || entityLiving.getLeashedToEntity() != this) continue;
                    entityLiving.clearLeashed(true, false);
                }
            }
        }
        return true;
    }

    @Override
    public boolean onValidSurface() {
        return this.worldObj.getBlockState(this.hangingPosition).getBlock() instanceof BlockFence;
    }

    public static EntityLeashKnot createKnot(World world2, BlockPos blockPos) {
        EntityLeashKnot entityLeashKnot = new EntityLeashKnot(world2, blockPos);
        entityLeashKnot.forceSpawn = true;
        world2.spawnEntityInWorld(entityLeashKnot);
        return entityLeashKnot;
    }

    public static EntityLeashKnot getKnotForPosition(World world2, BlockPos blockPos) {
        int n = blockPos.getX();
        int n2 = blockPos.getY();
        int n3 = blockPos.getZ();
        for (EntityLeashKnot entityLeashKnot : world2.getEntitiesWithinAABB(EntityLeashKnot.class, new AxisAlignedBB((double)n - 1.0, (double)n2 - 1.0, (double)n3 - 1.0, (double)n + 1.0, (double)n2 + 1.0, (double)n3 + 1.0))) {
            if (!entityLeashKnot.getHangingPosition().equals(blockPos)) continue;
            return entityLeashKnot;
        }
        return null;
    }
}


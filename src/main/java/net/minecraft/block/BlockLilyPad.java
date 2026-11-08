/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import de.florianmichael.viamcp.ViaMCP;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockLilyPad
extends BlockBush {
    protected BlockLilyPad() {
        float f = 0.5f;
        float f2 = 0.015625f;
        this.setBlockBounds(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, f2, 0.5f + f);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    @Override
    public void addCollisionBoxesToList(World world2, BlockPos blockPos, IBlockState iBlockState, AxisAlignedBB axisAlignedBB, List<AxisAlignedBB> list, Entity entity) {
        if (entity == null || !(entity instanceof EntityBoat)) {
            super.addCollisionBoxesToList(world2, blockPos, iBlockState, axisAlignedBB, list, entity);
        }
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(World world2, BlockPos blockPos, IBlockState iBlockState) {
        if (ViaMCP.isTargetVersionAtLeast(ProtocolVersion.v1_9)) {
            return new AxisAlignedBB((double)blockPos.getX() + 0.0625, blockPos.getY(), (double)blockPos.getZ() + 0.0625, (double)blockPos.getX() + 0.9375, (double)blockPos.getY() + 0.09375, (double)blockPos.getZ() + 0.9375);
        }
        return new AxisAlignedBB((double)blockPos.getX() + this.minX, (double)blockPos.getY() + this.minY, (double)blockPos.getZ() + this.minZ, (double)blockPos.getX() + this.maxX, (double)blockPos.getY() + this.maxY, (double)blockPos.getZ() + this.maxZ);
    }

    @Override
    public int getBlockColor() {
        return 7455580;
    }

    @Override
    public int getRenderColor(IBlockState iBlockState) {
        return 7455580;
    }

    @Override
    public int colorMultiplier(IBlockAccess iBlockAccess, BlockPos blockPos, int n) {
        return 2129968;
    }

    @Override
    protected boolean canPlaceBlockOn(Block block) {
        return block == Blocks.water;
    }

    @Override
    public boolean canBlockStay(World world2, BlockPos blockPos, IBlockState iBlockState) {
        if (blockPos.getY() >= 0 && blockPos.getY() < 256) {
            IBlockState iBlockState2 = world2.getBlockState(blockPos.down());
            return iBlockState2.getBlock().getMaterial() == Material.water && iBlockState2.getValue(BlockLiquid.LEVEL) == 0;
        }
        return false;
    }

    @Override
    public int getMetaFromState(IBlockState iBlockState) {
        return 0;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.IdentityHashMap;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class BlockAir
extends Block {
    private static Map mapOriginalOpacity = new IdentityHashMap();

    protected BlockAir() {
        super(Material.air);
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(World world2, BlockPos blockPos, IBlockState iBlockState) {
        return null;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean canCollideCheck(IBlockState iBlockState, boolean bl) {
        return false;
    }

    @Override
    public void dropBlockAsItemWithChance(World world2, BlockPos blockPos, IBlockState iBlockState, float f, int n) {
    }

    @Override
    public boolean isReplaceable(World world2, BlockPos blockPos) {
        return true;
    }

    public static void setLightOpacity(Block block, int n) {
        if (!mapOriginalOpacity.containsKey(block)) {
            mapOriginalOpacity.put(block, block.lightOpacity);
        }
        block.lightOpacity = n;
    }

    public static void restoreLightOpacity(Block block) {
        if (mapOriginalOpacity.containsKey(block)) {
            int n = (Integer)mapOriginalOpacity.get(block);
            BlockAir.setLightOpacity(block, n);
        }
    }
}


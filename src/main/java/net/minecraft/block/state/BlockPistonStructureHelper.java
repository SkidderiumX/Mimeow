/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block.state;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockPistonStructureHelper {
    private final World world;
    private final BlockPos pistonPos;
    private final BlockPos blockToMove;
    private final EnumFacing moveDirection;
    private final List<BlockPos> toMove = Lists.newArrayList();
    private final List<BlockPos> toDestroy = Lists.newArrayList();

    public BlockPistonStructureHelper(World world2, BlockPos blockPos, EnumFacing enumFacing, boolean bl) {
        this.world = world2;
        this.pistonPos = blockPos;
        if (bl) {
            this.moveDirection = enumFacing;
            this.blockToMove = blockPos.offset(enumFacing);
        } else {
            this.moveDirection = enumFacing.getOpposite();
            this.blockToMove = blockPos.offset(enumFacing, 2);
        }
    }

    public boolean canMove() {
        this.toMove.clear();
        this.toDestroy.clear();
        Block block = this.world.getBlockState(this.blockToMove).getBlock();
        if (!BlockPistonBase.canPush(block, this.world, this.blockToMove, this.moveDirection, false)) {
            if (block.getMobilityFlag() != 1) {
                return false;
            }
            this.toDestroy.add(this.blockToMove);
            return true;
        }
        if (!this.func_177251_a(this.blockToMove)) {
            return false;
        }
        for (int i = 0; i < this.toMove.size(); ++i) {
            BlockPos blockPos = this.toMove.get(i);
            if (this.world.getBlockState(blockPos).getBlock() != Blocks.slime_block || this.func_177250_b(blockPos)) continue;
            return false;
        }
        return true;
    }

    private boolean func_177251_a(BlockPos blockPos) {
        int n;
        BlockPos blockPos2;
        Block block = this.world.getBlockState(blockPos).getBlock();
        if (block.getMaterial() == Material.air) {
            return true;
        }
        if (!BlockPistonBase.canPush(block, this.world, blockPos, this.moveDirection, false)) {
            return true;
        }
        if (blockPos.equals(this.pistonPos)) {
            return true;
        }
        if (this.toMove.contains(blockPos)) {
            return true;
        }
        int n2 = 1;
        if (n2 + this.toMove.size() > 12) {
            return false;
        }
        while (block == Blocks.slime_block && (block = this.world.getBlockState(blockPos2 = blockPos.offset(this.moveDirection.getOpposite(), n2)).getBlock()).getMaterial() != Material.air && BlockPistonBase.canPush(block, this.world, blockPos2, this.moveDirection, false) && !blockPos2.equals(this.pistonPos)) {
            if (++n2 + this.toMove.size() <= 12) continue;
            return false;
        }
        int n3 = 0;
        for (n = n2 - 1; n >= 0; --n) {
            this.toMove.add(blockPos.offset(this.moveDirection.getOpposite(), n));
            ++n3;
        }
        n = 1;
        while (true) {
            BlockPos blockPos3;
            int n4;
            if ((n4 = this.toMove.indexOf(blockPos3 = blockPos.offset(this.moveDirection, n))) > -1) {
                this.func_177255_a(n3, n4);
                for (int i = 0; i <= n4 + n3; ++i) {
                    BlockPos blockPos4 = this.toMove.get(i);
                    if (this.world.getBlockState(blockPos4).getBlock() != Blocks.slime_block || this.func_177250_b(blockPos4)) continue;
                    return false;
                }
                return true;
            }
            block = this.world.getBlockState(blockPos3).getBlock();
            if (block.getMaterial() == Material.air) {
                return true;
            }
            if (!BlockPistonBase.canPush(block, this.world, blockPos3, this.moveDirection, true) || blockPos3.equals(this.pistonPos)) {
                return false;
            }
            if (block.getMobilityFlag() == 1) {
                this.toDestroy.add(blockPos3);
                return true;
            }
            if (this.toMove.size() >= 12) {
                return false;
            }
            this.toMove.add(blockPos3);
            ++n3;
            ++n;
        }
    }

    private void func_177255_a(int n, int n2) {
        ArrayList<BlockPos> arrayList = Lists.newArrayList();
        ArrayList<BlockPos> arrayList2 = Lists.newArrayList();
        ArrayList<BlockPos> arrayList3 = Lists.newArrayList();
        arrayList.addAll(this.toMove.subList(0, n2));
        arrayList2.addAll(this.toMove.subList(this.toMove.size() - n, this.toMove.size()));
        arrayList3.addAll(this.toMove.subList(n2, this.toMove.size() - n));
        this.toMove.clear();
        this.toMove.addAll(arrayList);
        this.toMove.addAll(arrayList2);
        this.toMove.addAll(arrayList3);
    }

    private boolean func_177250_b(BlockPos blockPos) {
        for (EnumFacing enumFacing : EnumFacing.values()) {
            if (enumFacing.getAxis() == this.moveDirection.getAxis() || this.func_177251_a(blockPos.offset(enumFacing))) continue;
            return false;
        }
        return true;
    }

    public List<BlockPos> getBlocksToMove() {
        return this.toMove;
    }

    public List<BlockPos> getBlocksToDestroy() {
        return this.toDestroy;
    }
}


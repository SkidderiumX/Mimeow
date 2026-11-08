/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.model;

import keystrokesmod.script.model.Vec3;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import x.oc7ab2161b9f;
import x.occb1ed1ed8f;

public class Block {
    public String type;
    public String name;
    public boolean interactable;
    public int variant;
    public double height;
    public double width;
    public double length;
    public double x;
    public double y;
    public double z;

    public Block(net.minecraft.block.Block block, BlockPos blockPos) {
        this.type = block.getClass().getSimpleName();
        this.name = ((ResourceLocation)net.minecraft.block.Block.blockRegistry.getNameForObject(block)).toString().replace("minecraft:", "");
        this.interactable = occb1ed1ed8f.\u023c(block);
        this.variant = block.getMetaFromState(occb1ed1ed8f.\u041e(blockPos));
        this.height = block.getBlockBoundsMaxY() - block.getBlockBoundsMinY();
        this.width = block.getBlockBoundsMaxX() - block.getBlockBoundsMinX();
        this.length = block.getBlockBoundsMaxZ() - block.getBlockBoundsMinZ();
        this.x = blockPos.getX();
        this.y = blockPos.getY();
        this.z = blockPos.getZ();
    }

    public Block(IBlockState iBlockState, BlockPos blockPos) {
        net.minecraft.block.Block block = iBlockState.getBlock();
        this.type = block.getClass().getSimpleName();
        this.name = ((ResourceLocation)net.minecraft.block.Block.blockRegistry.getNameForObject(block)).toString().replace("minecraft:", "");
        this.interactable = occb1ed1ed8f.\u023c(block);
        this.variant = block.getMetaFromState(iBlockState);
        this.height = block.getBlockBoundsMaxY() - block.getBlockBoundsMinY();
        this.width = block.getBlockBoundsMaxX() - block.getBlockBoundsMinX();
        this.length = block.getBlockBoundsMaxZ() - block.getBlockBoundsMinZ();
        this.x = blockPos.getX();
        this.y = blockPos.getY();
        this.z = blockPos.getZ();
    }

    public Block(int n, int n2, int n3) {
        this(occb1ed1ed8f.\u04ab(n, n2, n3), new BlockPos(n, n2, n3));
    }

    protected Block(String string, Vec3 vec3) {
        this(oc7ab2161b9f.\u015c(string), Vec3.getBlockPos(vec3));
    }

    public Block(String string) {
        this(string, new Vec3(-1.0, -1.0, -1.0));
    }

    public Block(Vec3 vec3) {
        this(occb1ed1ed8f.\u04ab(vec3.x, vec3.y, vec3.z), new BlockPos(vec3.x, vec3.y, vec3.z));
    }
}


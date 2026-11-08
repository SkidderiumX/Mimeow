/*
 * Decompiled with CFR 0.152.
 */
package net.optifine;

import com.google.common.collect.AbstractIterator;
import java.util.Iterator;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3i;

public class BlockPosM
extends BlockPos {
    private int mx;
    private int my;
    private int mz;
    private int level;
    private BlockPosM[] facings;
    private boolean needsUpdate;

    public BlockPosM(int n, int n2, int n3) {
        this(n, n2, n3, 0);
    }

    public BlockPosM(double d, double d2, double d3) {
        this(MathHelper.floor_double(d), MathHelper.floor_double(d2), MathHelper.floor_double(d3));
    }

    public BlockPosM(int n, int n2, int n3, int n4) {
        super(0, 0, 0);
        this.mx = n;
        this.my = n2;
        this.mz = n3;
        this.level = n4;
    }

    @Override
    public int getX() {
        return this.mx;
    }

    @Override
    public int getY() {
        return this.my;
    }

    @Override
    public int getZ() {
        return this.mz;
    }

    public void setXyz(int n, int n2, int n3) {
        this.mx = n;
        this.my = n2;
        this.mz = n3;
        this.needsUpdate = true;
    }

    public void setXyz(double d, double d2, double d3) {
        this.setXyz(MathHelper.floor_double(d), MathHelper.floor_double(d2), MathHelper.floor_double(d3));
    }

    public BlockPosM set(Vec3i vec3i) {
        this.setXyz(vec3i.getX(), vec3i.getY(), vec3i.getZ());
        return this;
    }

    public BlockPosM set(int n, int n2, int n3) {
        this.setXyz(n, n2, n3);
        return this;
    }

    public BlockPos offsetMutable(EnumFacing enumFacing) {
        return this.offset(enumFacing);
    }

    @Override
    public BlockPos offset(EnumFacing enumFacing) {
        int n;
        BlockPosM blockPosM;
        if (this.level <= 0) {
            return super.offset(enumFacing, 1);
        }
        if (this.facings == null) {
            this.facings = new BlockPosM[EnumFacing.VALUES.length];
        }
        if (this.needsUpdate) {
            this.update();
        }
        if ((blockPosM = this.facings[n = enumFacing.getIndex()]) == null) {
            int n2 = this.mx + enumFacing.getFrontOffsetX();
            int n3 = this.my + enumFacing.getFrontOffsetY();
            int n4 = this.mz + enumFacing.getFrontOffsetZ();
            this.facings[n] = blockPosM = new BlockPosM(n2, n3, n4, this.level - 1);
        }
        return blockPosM;
    }

    @Override
    public BlockPos offset(EnumFacing enumFacing, int n) {
        return n == 1 ? this.offset(enumFacing) : super.offset(enumFacing, n);
    }

    private void update() {
        for (int i = 0; i < 6; ++i) {
            BlockPosM blockPosM = this.facings[i];
            if (blockPosM == null) continue;
            EnumFacing enumFacing = EnumFacing.VALUES[i];
            int n = this.mx + enumFacing.getFrontOffsetX();
            int n2 = this.my + enumFacing.getFrontOffsetY();
            int n3 = this.mz + enumFacing.getFrontOffsetZ();
            blockPosM.setXyz(n, n2, n3);
        }
        this.needsUpdate = false;
    }

    public BlockPos toImmutable() {
        return new BlockPos(this.mx, this.my, this.mz);
    }

    public static Iterable getAllInBoxMutable(BlockPos blockPos, BlockPos blockPos2) {
        final BlockPos blockPos3 = new BlockPos(Math.min(blockPos.getX(), blockPos2.getX()), Math.min(blockPos.getY(), blockPos2.getY()), Math.min(blockPos.getZ(), blockPos2.getZ()));
        final BlockPos blockPos4 = new BlockPos(Math.max(blockPos.getX(), blockPos2.getX()), Math.max(blockPos.getY(), blockPos2.getY()), Math.max(blockPos.getZ(), blockPos2.getZ()));
        return new Iterable(){

            public Iterator iterator() {
                return new AbstractIterator(){
                    private BlockPosM theBlockPosM = null;

                    protected BlockPosM computeNext0() {
                        if (this.theBlockPosM == null) {
                            this.theBlockPosM = new BlockPosM(blockPos3.getX(), blockPos3.getY(), blockPos3.getZ(), 3);
                            return this.theBlockPosM;
                        }
                        if (this.theBlockPosM.equals(blockPos4)) {
                            return (BlockPosM)this.endOfData();
                        }
                        int n = this.theBlockPosM.getX();
                        int n2 = this.theBlockPosM.getY();
                        int n3 = this.theBlockPosM.getZ();
                        if (n < blockPos4.getX()) {
                            ++n;
                        } else if (n2 < blockPos4.getY()) {
                            n = blockPos3.getX();
                            ++n2;
                        } else if (n3 < blockPos4.getZ()) {
                            n = blockPos3.getX();
                            n2 = blockPos3.getY();
                            ++n3;
                        }
                        this.theBlockPosM.setXyz(n, n2, n3);
                        return this.theBlockPosM;
                    }

                    protected Object computeNext() {
                        return this.computeNext0();
                    }
                };
            }
        };
    }
}


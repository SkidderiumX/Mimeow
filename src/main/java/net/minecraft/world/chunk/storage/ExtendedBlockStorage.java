/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.chunk.storage;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.chunk.NibbleArray;
import net.optifine.reflect.Reflector;

public class ExtendedBlockStorage {
    private int yBase;
    private int blockRefCount;
    private int tickRefCount;
    private char[] data;
    private NibbleArray blocklightArray;
    private NibbleArray skylightArray;

    public ExtendedBlockStorage(int n, boolean bl) {
        this.yBase = n;
        this.data = new char[4096];
        this.blocklightArray = new NibbleArray();
        if (bl) {
            this.skylightArray = new NibbleArray();
        }
    }

    public IBlockState get(int n, int n2, int n3) {
        IBlockState iBlockState = Block.BLOCK_STATE_IDS.getByValue(this.data[n2 << 8 | n3 << 4 | n]);
        return iBlockState != null ? iBlockState : Blocks.air.getDefaultState();
    }

    public void set(int n, int n2, int n3, IBlockState iBlockState) {
        if (Reflector.IExtendedBlockState.isInstance(iBlockState)) {
            iBlockState = (IBlockState)Reflector.call(iBlockState, Reflector.IExtendedBlockState_getClean, new Object[0]);
        }
        IBlockState iBlockState2 = this.get(n, n2, n3);
        Block block = iBlockState2.getBlock();
        Block block2 = iBlockState.getBlock();
        if (block != Blocks.air) {
            --this.blockRefCount;
            if (block.getTickRandomly()) {
                --this.tickRefCount;
            }
        }
        if (block2 != Blocks.air) {
            ++this.blockRefCount;
            if (block2.getTickRandomly()) {
                ++this.tickRefCount;
            }
        }
        this.data[n2 << 8 | n3 << 4 | n] = (char)Block.BLOCK_STATE_IDS.get(iBlockState);
    }

    public Block getBlockByExtId(int n, int n2, int n3) {
        return this.get(n, n2, n3).getBlock();
    }

    public int getExtBlockMetadata(int n, int n2, int n3) {
        IBlockState iBlockState = this.get(n, n2, n3);
        return iBlockState.getBlock().getMetaFromState(iBlockState);
    }

    public boolean isEmpty() {
        return this.blockRefCount == 0;
    }

    public boolean getNeedsRandomTick() {
        return this.tickRefCount > 0;
    }

    public int getYLocation() {
        return this.yBase;
    }

    public void setExtSkylightValue(int n, int n2, int n3, int n4) {
        this.skylightArray.set(n, n2, n3, n4);
    }

    public int getExtSkylightValue(int n, int n2, int n3) {
        return this.skylightArray.get(n, n2, n3);
    }

    public void setExtBlocklightValue(int n, int n2, int n3, int n4) {
        this.blocklightArray.set(n, n2, n3, n4);
    }

    public int getExtBlocklightValue(int n, int n2, int n3) {
        return this.blocklightArray.get(n, n2, n3);
    }

    public void removeInvalidBlocks() {
        IBlockState iBlockState = Blocks.air.getDefaultState();
        int n = 0;
        int n2 = 0;
        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 16; ++j) {
                for (int k = 0; k < 16; ++k) {
                    Block block = this.getBlockByExtId(k, i, j);
                    if (block == Blocks.air) continue;
                    ++n;
                    if (!block.getTickRandomly()) continue;
                    ++n2;
                }
            }
        }
        this.blockRefCount = n;
        this.tickRefCount = n2;
    }

    public char[] getData() {
        return this.data;
    }

    public void setData(char[] cArray) {
        this.data = cArray;
    }

    public NibbleArray getBlocklightArray() {
        return this.blocklightArray;
    }

    public NibbleArray getSkylightArray() {
        return this.skylightArray;
    }

    public void setBlocklightArray(NibbleArray nibbleArray) {
        this.blocklightArray = nibbleArray;
    }

    public void setSkylightArray(NibbleArray nibbleArray) {
        this.skylightArray = nibbleArray;
    }

    public int getBlockRefCount() {
        return this.blockRefCount;
    }
}


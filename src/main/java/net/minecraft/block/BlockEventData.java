/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;

public class BlockEventData {
    private BlockPos position;
    private Block blockType;
    private int eventID;
    private int eventParameter;

    public BlockEventData(BlockPos blockPos, Block block, int n, int n2) {
        this.position = blockPos;
        this.eventID = n;
        this.eventParameter = n2;
        this.blockType = block;
    }

    public BlockPos getPosition() {
        return this.position;
    }

    public int getEventID() {
        return this.eventID;
    }

    public int getEventParameter() {
        return this.eventParameter;
    }

    public Block getBlock() {
        return this.blockType;
    }

    public boolean equals(Object object) {
        if (!(object instanceof BlockEventData)) {
            return false;
        }
        BlockEventData blockEventData = (BlockEventData)object;
        return this.position.equals(blockEventData.position) && this.eventID == blockEventData.eventID && this.eventParameter == blockEventData.eventParameter && this.blockType == blockEventData.blockType;
    }

    public String toString() {
        return "TE(" + String.valueOf(this.position) + ")," + this.eventID + "," + this.eventParameter + "," + String.valueOf(this.blockType);
    }
}


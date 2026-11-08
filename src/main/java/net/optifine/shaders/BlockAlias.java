/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.shaders;

import java.util.ArrayList;
import java.util.HashSet;
import net.minecraft.src.Config;
import net.optifine.config.MatchBlock;

public class BlockAlias {
    private int blockAliasId;
    private MatchBlock[] matchBlocks;

    public BlockAlias(int n, MatchBlock[] matchBlockArray) {
        this.blockAliasId = n;
        this.matchBlocks = matchBlockArray;
    }

    public int getBlockAliasId() {
        return this.blockAliasId;
    }

    public boolean matches(int n, int n2) {
        for (int i = 0; i < this.matchBlocks.length; ++i) {
            MatchBlock matchBlock = this.matchBlocks[i];
            if (!matchBlock.matches(n, n2)) continue;
            return true;
        }
        return false;
    }

    public int[] getMatchBlockIds() {
        Object object;
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int i = 0; i < this.matchBlocks.length; ++i) {
            object = this.matchBlocks[i];
            int n = ((MatchBlock)object).getBlockId();
            hashSet.add(n);
        }
        Integer[] integerArray = hashSet.toArray(new Integer[hashSet.size()]);
        object = Config.toPrimitive(integerArray);
        return object;
    }

    public MatchBlock[] getMatchBlocks(int n) {
        ArrayList<MatchBlock> arrayList = new ArrayList<MatchBlock>();
        for (int i = 0; i < this.matchBlocks.length; ++i) {
            MatchBlock matchBlock = this.matchBlocks[i];
            if (matchBlock.getBlockId() != n) continue;
            arrayList.add(matchBlock);
        }
        MatchBlock[] matchBlockArray = arrayList.toArray(new MatchBlock[arrayList.size()]);
        return matchBlockArray;
    }

    public String toString() {
        return "block." + this.blockAliasId + "=" + Config.arrayToString(this.matchBlocks);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.util.BlockPos;

public interface oc51cbcffcfe {
    public float getCurBlockDamageMP();

    public BlockPos getCurrentBlock();

    public void setCurBlockDamageMP(float var1);

    public int getBlockHitDelay();

    public void setBlockHitDelay(int var1);

    public boolean isHittingBlock();

    public int getCurrentPlayerItem();

    public void setCurrentPlayerItem(int var1);

    public void callSyncCurrentPlayItem();
}


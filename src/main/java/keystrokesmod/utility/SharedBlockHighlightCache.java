/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.utility;

import java.util.Map;
import java.util.Set;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import x.oc10354c7bb8;
import x.oc5627f01551;
import x.oce79181588d;
import x.ocfbf6a7fb78;

public class SharedBlockHighlightCache {
    private SharedBlockHighlightCache() {
    }

    public static SharedBlockHighlightCache get() {
        return Holder.INSTANCE;
    }

    public void attachBlockList(oc10354c7bb8 oc10354c7bb82) {
        ocfbf6a7fb78.\u0101().\u017c(oc10354c7bb82);
    }

    public void detachBlockList() {
        ocfbf6a7fb78.\u0101().\u00e3();
    }

    public void attachBed() {
        ocfbf6a7fb78.\u0101().\u01cd();
    }

    public void detachBed() {
        ocfbf6a7fb78.\u0101().\u051b();
    }

    public boolean anyConsumerActive() {
        return ocfbf6a7fb78.\u0101().\u01bd();
    }

    public void clear() {
        ocfbf6a7fb78.\u0101().\u012f();
    }

    public void addUpdateListener(oc5627f01551 oc5627f015512) {
        ocfbf6a7fb78.\u0101().\u01b3(oc5627f015512);
    }

    public void removeUpdateListener(oc5627f01551 oc5627f015512) {
        ocfbf6a7fb78.\u0101().\u01e2(oc5627f015512);
    }

    public void enqueueChunk(int n, int n2) {
        ocfbf6a7fb78.\u0101().\u0463(n, n2);
    }

    public void removeChunk(int n, int n2) {
        ocfbf6a7fb78.\u0101().\u0471(n, n2);
    }

    public void enqueueLoadedChunks() {
        ocfbf6a7fb78.\u0101().\u00c4();
    }

    public void tickScan(int n) {
        ocfbf6a7fb78.\u0101().\u04a9(n);
    }

    public void onBlockChange(BlockPos blockPos, IBlockState iBlockState) {
        ocfbf6a7fb78.\u0101().\u0515(blockPos, iBlockState);
    }

    public void onBlockListSettingsChanged() {
        ocfbf6a7fb78.\u0101().\u0147();
    }

    public Iterable<Map.Entry<Long, Set<BlockPos>>> entriesBlockList() {
        return ocfbf6a7fb78.\u0101().\u0222();
    }

    public Iterable<Map.Entry<Long, Set<BlockPos>>> entriesBedFeet() {
        return ocfbf6a7fb78.\u0101().\u021b();
    }

    public int totalBlockList() {
        return ocfbf6a7fb78.\u0101().\u0531();
    }

    public int totalBedFeet() {
        return ocfbf6a7fb78.\u0101().\u00da();
    }

    public boolean containsBlockList(BlockPos blockPos) {
        return ocfbf6a7fb78.\u0101().\u046c(blockPos);
    }

    public void handleReceivePacket(oce79181588d oce79181588d2) {
        ocfbf6a7fb78.\u0101().\u03e2(oce79181588d2);
    }

    private static final class Holder {
        private static final SharedBlockHighlightCache INSTANCE = new SharedBlockHighlightCache();

        private Holder() {
        }
    }
}


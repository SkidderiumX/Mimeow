/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import x.oc84f20a0bc5;
import x.occ81b8a8753;

public class oca872d93a25 {
    private oca872d93a25() {
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static List<BlockPos> \u0185(BlockPos blockPos, List<BlockPos> list, Set<BlockPos> set) {
        int n;
        HashMap<BlockPos, BlockPos> hashMap;
        HashMap<BlockPos, Integer> hashMap2;
        PriorityQueue<occ81b8a8753> priorityQueue;
        int n2;
        block42: {
            boolean bl;
            block41: {
                n2 = oc84f20a0bc5.\u0117;
                bl = set.contains(blockPos);
                if (n2 != 0) break block41;
                if (!bl) return null;
                bl = list.isEmpty();
            }
            if (bl) {
                return null;
            }
            priorityQueue = new PriorityQueue<occ81b8a8753>(Comparator.comparingInt(occ81b8a87532 -> occ81b8a87532.\u03bc).thenComparingInt(occ81b8a87532 -> occ81b8a87532.T).thenComparingInt(occ81b8a87532 -> occ81b8a87532.\u025f.getY()).thenComparingInt(occ81b8a87532 -> occ81b8a87532.\u025f.getX()).thenComparingInt(occ81b8a87532 -> occ81b8a87532.\u025f.getZ()));
            hashMap2 = new HashMap<BlockPos, Integer>();
            hashMap = new HashMap<BlockPos, BlockPos>();
            for (BlockPos blockPos2 : list) {
                block44: {
                    boolean bl2;
                    HashMap<BlockPos, Integer> hashMap3;
                    block43: {
                        n = set.contains(blockPos2);
                        if (n2 != 0) break block42;
                        if (n2 != 0) break block43;
                        if (n == 0) continue;
                        hashMap3 = hashMap2;
                        if (n2 != 0) break block44;
                        bl2 = hashMap3.containsKey(blockPos2);
                    }
                    if (bl2) continue;
                    hashMap2.put(blockPos2, 0);
                    hashMap3 = hashMap.put(blockPos2, null);
                }
                priorityQueue.add(new occ81b8a8753(blockPos2, 0, oca872d93a25.\u041f(blockPos2, blockPos)));
                if (n2 == 0) continue;
            }
            n = Math.min(0x5339C093 ^ 0x5339DFD3, Math.max(0x5339DE27 ^ 0x5339DFD3, set.size() * (0x5339DFD1 ^ 0x5339DFD3)));
        }
        int n3 = n;
        int n4 = 0;
        block31: while (!priorityQueue.isEmpty() && n4 < n3) {
            Object object = priorityQueue.remove();
            block32: while (true) {
                occ81b8a8753 occ81b8a87533;
                occ81b8a8753 occ81b8a87534 = occ81b8a87533 = (occ81b8a8753)object;
                if (n2 == 0) {
                    if (occ81b8a87534.\u019c != (Integer)hashMap2.get(occ81b8a87533.\u025f)) {
                        continue block31;
                    }
                    ++n4;
                    occ81b8a87534 = occ81b8a87533;
                }
                if (occ81b8a87534.\u025f.equals(blockPos)) {
                    ArrayList arrayList = new ArrayList();
                    BlockPos blockPos3 = blockPos;
                    while (blockPos3 != null) {
                        arrayList.add(blockPos3);
                        if (n2 != 0) return arrayList;
                        blockPos3 = (BlockPos)hashMap.get(blockPos3);
                        if (n2 == 0) continue;
                    }
                    Collections.reverse(arrayList);
                    return arrayList;
                }
                for (EnumFacing enumFacing : EnumFacing.values()) {
                    int n5;
                    BlockPos blockPos4;
                    block46: {
                        Comparable<Integer> comparable;
                        block47: {
                            int n6;
                            block45: {
                                blockPos4 = occ81b8a87533.\u025f.offset(enumFacing);
                                object = set;
                                if (n2 != 0) continue block32;
                                n6 = object.contains(blockPos4);
                                if (n2 != 0) break block45;
                                if (n6 == 0) {
                                    continue;
                                }
                                n6 = occ81b8a87533.\u019c;
                            }
                            int n7 = enumFacing.getAxis() == EnumFacing.Axis.Y ? 0x5339DFD1 ^ 0x5339DFD3 : 1;
                            n5 = n6 + n7;
                            Integer n8 = (Integer)hashMap2.get(blockPos4);
                            if (n2 != 0) break block46;
                            if (n8 == null) break block47;
                            comparable = n8;
                            if (n2 != 0) break block46;
                            if (comparable <= n5) {
                                continue;
                            }
                        }
                        hashMap2.put(blockPos4, n5);
                        comparable = hashMap.put(blockPos4, occ81b8a87533.\u025f);
                    }
                    priorityQueue.add(new occ81b8a8753(blockPos4, n5, oca872d93a25.\u041f(blockPos4, blockPos)));
                    if (n2 == 0) continue;
                }
                break;
            }
            if (n2 != 0) return null;
        }
        return null;
    }

    private static int \u041f(BlockPos blockPos, BlockPos blockPos2) {
        return Math.abs(blockPos.getX() - blockPos2.getX()) + Math.abs(blockPos.getZ() - blockPos2.getZ()) + (0x219C6109 ^ 0x219C610B) * Math.abs(blockPos.getY() - blockPos2.getY());
    }
}


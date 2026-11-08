/*
 * Decompiled with CFR 0.152.
 */
package net.optifine;

import com.google.common.collect.Iterators;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import net.minecraft.util.BlockPos;
import net.minecraft.util.LongHashMap;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.NextTickListEntry;

public class NextTickHashSet
extends TreeSet {
    private LongHashMap longHashMap = new LongHashMap();
    private int minX = Integer.MIN_VALUE;
    private int minZ = Integer.MIN_VALUE;
    private int maxX = Integer.MIN_VALUE;
    private int maxZ = Integer.MIN_VALUE;
    private static final int UNDEFINED = Integer.MIN_VALUE;

    public NextTickHashSet(Set set) {
        for (Object e : set) {
            this.add(e);
        }
    }

    @Override
    public boolean contains(Object object) {
        if (!(object instanceof NextTickListEntry)) {
            return false;
        }
        NextTickListEntry nextTickListEntry = (NextTickListEntry)object;
        Set set = this.getSubSet(nextTickListEntry, false);
        return set == null ? false : set.contains(nextTickListEntry);
    }

    @Override
    public boolean add(Object object) {
        boolean bl;
        if (!(object instanceof NextTickListEntry)) {
            return false;
        }
        NextTickListEntry nextTickListEntry = (NextTickListEntry)object;
        if (nextTickListEntry == null) {
            return false;
        }
        Set set = this.getSubSet(nextTickListEntry, true);
        boolean bl2 = set.add(nextTickListEntry);
        if (bl2 != (bl = super.add(object))) {
            throw new IllegalStateException("Added: " + bl2 + ", addedParent: " + bl);
        }
        return bl;
    }

    @Override
    public boolean remove(Object object) {
        boolean bl;
        if (!(object instanceof NextTickListEntry)) {
            return false;
        }
        NextTickListEntry nextTickListEntry = (NextTickListEntry)object;
        Set set = this.getSubSet(nextTickListEntry, false);
        if (set == null) {
            return false;
        }
        boolean bl2 = set.remove(nextTickListEntry);
        if (bl2 != (bl = super.remove(nextTickListEntry))) {
            throw new IllegalStateException("Added: " + bl2 + ", addedParent: " + bl);
        }
        return bl;
    }

    private Set getSubSet(NextTickListEntry nextTickListEntry, boolean bl) {
        if (nextTickListEntry == null) {
            return null;
        }
        BlockPos blockPos = nextTickListEntry.position;
        int n = blockPos.getX() >> 4;
        int n2 = blockPos.getZ() >> 4;
        return this.getSubSet(n, n2, bl);
    }

    private Set getSubSet(int n, int n2, boolean bl) {
        long l = ChunkCoordIntPair.chunkXZ2Int(n, n2);
        HashSet hashSet = (HashSet)this.longHashMap.getValueByKey(l);
        if (hashSet == null && bl) {
            hashSet = new HashSet();
            this.longHashMap.add(l, hashSet);
        }
        return hashSet;
    }

    @Override
    public Iterator iterator() {
        if (this.minX == Integer.MIN_VALUE) {
            return super.iterator();
        }
        if (this.size() <= 0) {
            return Iterators.emptyIterator();
        }
        int n = this.minX >> 4;
        int n2 = this.minZ >> 4;
        int n3 = this.maxX >> 4;
        int n4 = this.maxZ >> 4;
        ArrayList arrayList = new ArrayList();
        for (int i = n; i <= n3; ++i) {
            for (int j = n2; j <= n4; ++j) {
                Set set = this.getSubSet(i, j, false);
                if (set == null) continue;
                arrayList.add(set.iterator());
            }
        }
        if (arrayList.size() <= 0) {
            return Iterators.emptyIterator();
        }
        if (arrayList.size() == 1) {
            return (Iterator)arrayList.get(0);
        }
        return Iterators.concat(arrayList.iterator());
    }

    public void setIteratorLimits(int n, int n2, int n3, int n4) {
        this.minX = Math.min(n, n3);
        this.minZ = Math.min(n2, n4);
        this.maxX = Math.max(n, n3);
        this.maxZ = Math.max(n2, n4);
    }

    public void clearIteratorLimits() {
        this.minX = Integer.MIN_VALUE;
        this.minZ = Integer.MIN_VALUE;
        this.maxX = Integer.MIN_VALUE;
        this.maxZ = Integer.MIN_VALUE;
    }
}


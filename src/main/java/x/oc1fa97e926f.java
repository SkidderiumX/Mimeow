/*
 * Decompiled with CFR 0.152.
 */
package x;

import com.viaversion.viaversion.libs.fastutil.longs.Long2ObjectOpenHashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3i;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.NextTickListEntry;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import x.oc0e5aa4f07e;
import x.oc170ea29aae;
import x.oc5c5c928041;

public class oc1fa97e926f
extends TreeSet<NextTickListEntry> {
    private final Long2ObjectOpenHashMap<List<NextTickListEntry>> \u0517 = new Long2ObjectOpenHashMap();
    public static int \u0138;

    private static long \u0526(NextTickListEntry nextTickListEntry) {
        BlockPos blockPos = nextTickListEntry.position;
        return ChunkCoordIntPair.chunkXZ2Int(blockPos.getX() >> (0xA40BEEFD ^ 0xA40BEEF9), blockPos.getZ() >> (0xA40BEEFD ^ 0xA40BEEF9));
    }

    public boolean \u0453(NextTickListEntry nextTickListEntry) {
        block6: {
            List<NextTickListEntry> list;
            block7: {
                boolean bl;
                block5: {
                    boolean bl2;
                    block4: {
                        bl = oc170ea29aae.\u0406;
                        bl2 = super.add(nextTickListEntry);
                        if (bl) break block4;
                        if (bl2) break block5;
                        bl2 = false;
                    }
                    return bl2;
                }
                long l = oc1fa97e926f.\u0526(nextTickListEntry);
                list = this.\u0517.get(l);
                if (bl) break block6;
                if (list != null) break block7;
                list = new ArrayList<NextTickListEntry>(0xAFF49CEA ^ 0xAFF49CEE);
                this.\u0517.put(l, list);
            }
            list.add(nextTickListEntry);
        }
        return true;
    }

    @Override
    public boolean remove(Object object) {
        oc1fa97e926f oc1fa97e926f2;
        block4: {
            block5: {
                boolean bl = oc170ea29aae.\u0406;
                oc1fa97e926f2 = this;
                if (bl) break block4;
                if (super.remove(object)) break block5;
                return false;
            }
            oc1fa97e926f2 = this;
        }
        oc1fa97e926f2.F((NextTickListEntry)object);
        return true;
    }

    @Override
    public NextTickListEntry pollFirst() {
        NextTickListEntry nextTickListEntry;
        block4: {
            NextTickListEntry nextTickListEntry2;
            block5: {
                nextTickListEntry2 = (NextTickListEntry)super.pollFirst();
                boolean bl = oc170ea29aae.\u0406;
                nextTickListEntry = nextTickListEntry2;
                if (bl) break block4;
                if (nextTickListEntry == null) break block5;
                this.F(nextTickListEntry2);
            }
            nextTickListEntry = nextTickListEntry2;
        }
        return nextTickListEntry;
    }

    @Override
    public NextTickListEntry pollLast() {
        NextTickListEntry nextTickListEntry;
        block4: {
            NextTickListEntry nextTickListEntry2;
            block5: {
                nextTickListEntry2 = (NextTickListEntry)super.pollLast();
                boolean bl = oc170ea29aae.\u0406;
                nextTickListEntry = nextTickListEntry2;
                if (bl) break block4;
                if (nextTickListEntry == null) break block5;
                this.F(nextTickListEntry2);
            }
            nextTickListEntry = nextTickListEntry2;
        }
        return nextTickListEntry;
    }

    @Override
    public void clear() {
        super.clear();
        this.\u0517.clear();
    }

    private void F(NextTickListEntry nextTickListEntry) {
        block17: {
            List<NextTickListEntry> list;
            boolean bl;
            long l;
            block15: {
                List<NextTickListEntry> list2;
                block16: {
                    l = oc1fa97e926f.\u0526(nextTickListEntry);
                    bl = oc170ea29aae.\u0406;
                    list = this.\u0517.get(l);
                    list2 = list;
                    if (bl) break block15;
                    if (list2 != null) break block16;
                    return;
                }
                list2 = list;
            }
            for (int i = (v3854586).size() - 1; i >= 0; --i) {
                block18: {
                    if (bl) break block17;
                    Object object = list;
                    if (bl) break block18;
                    if (object.get(i) != nextTickListEntry) continue;
                    object = list.remove(i);
                }
                if (!bl) break;
                if (!bl) continue;
                break;
            }
            List<NextTickListEntry> list3 = list;
            if (bl || !list3.isEmpty()) break block17;
            list3 = this.\u0517.remove(l);
        }
    }

    @Override
    public Iterator<NextTickListEntry> iterator() {
        Iterator iterator2 = super.iterator();
        return new oc5c5c928041(this, iterator2);
    }

    public Iterator<NextTickListEntry> \u01ac(StructureBoundingBox structureBoundingBox) {
        List<NextTickListEntry> list;
        block4: {
            List<NextTickListEntry> list2;
            block5: {
                list2 = this.\u03b3(structureBoundingBox);
                boolean bl = oc170ea29aae.\u0406;
                list = list2;
                if (bl) break block4;
                if (!list.isEmpty()) break block5;
                return Collections.emptyIterator();
            }
            list = list2;
        }
        Iterator<NextTickListEntry> iterator2 = list.iterator();
        return new oc0e5aa4f07e(this, iterator2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private List<NextTickListEntry> \u03b3(StructureBoundingBox structureBoundingBox) {
        StructureBoundingBox structureBoundingBox2;
        int n;
        boolean bl;
        block34: {
            bl = oc170ea29aae.\u0406;
            n = structureBoundingBox.maxX;
            structureBoundingBox2 = structureBoundingBox;
            if (bl) break block34;
            if (n <= structureBoundingBox2.minX) return Collections.emptyList();
            n = structureBoundingBox.maxZ;
            structureBoundingBox2 = structureBoundingBox;
        }
        if (n <= structureBoundingBox2.minZ) {
            return Collections.emptyList();
        }
        ArrayList<NextTickListEntry> arrayList = new ArrayList<NextTickListEntry>();
        int n2 = structureBoundingBox.minX >> (0xBD4E2830 ^ 0xBD4E2834);
        while (n2 <= structureBoundingBox.maxX - 1 >> (0xBD4E2830 ^ 0xBD4E2834)) {
            block35: {
                if (bl) return arrayList;
                block29: for (int i = structureBoundingBox.minZ >> (0xBD4E2830 ^ 0xBD4E2834); i <= structureBoundingBox.maxZ - 1 >> (0xBD4E2830 ^ 0xBD4E2834); ++i) {
                    if (bl) break block35;
                    Object object = this.\u0517.get(ChunkCoordIntPair.chunkXZ2Int(n2, i));
                    block30: while (true) {
                        List<NextTickListEntry> list;
                        List<NextTickListEntry> list2 = list = object;
                        if (!bl) {
                            if (list2 == null && !bl) continue block29;
                            list2 = list;
                        }
                        for (NextTickListEntry nextTickListEntry : list2) {
                            block37: {
                                int n3;
                                block39: {
                                    BlockPos blockPos;
                                    BlockPos blockPos2;
                                    block38: {
                                        block36: {
                                            blockPos2 = nextTickListEntry.position;
                                            object = blockPos2;
                                            if (bl) continue block30;
                                            if (bl) break block36;
                                            if (((Vec3i)object).getX() < structureBoundingBox.minX) break block37;
                                            blockPos = blockPos2;
                                        }
                                        if (bl) break block38;
                                        if (blockPos.getX() >= structureBoundingBox.maxX) break block37;
                                        blockPos = blockPos2;
                                    }
                                    n3 = blockPos.getZ();
                                    if (bl) break block39;
                                    if (n3 < structureBoundingBox.minZ) break block37;
                                    n3 = blockPos2.getZ();
                                }
                                if (bl || n3 >= structureBoundingBox.maxZ) break block37;
                                n3 = arrayList.add(nextTickListEntry) ? 1 : 0;
                            }
                            if (!bl) continue;
                        }
                        break;
                    }
                    if (!bl) continue;
                }
                ++n2;
            }
            if (!bl) continue;
        }
        Collections.sort(arrayList);
        return arrayList;
    }
}


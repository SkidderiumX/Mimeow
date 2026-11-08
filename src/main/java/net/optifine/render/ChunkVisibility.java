/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.render;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import net.minecraft.entity.Entity;
import net.minecraft.util.ClassInheritanceMultiMap;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3i;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;

public class ChunkVisibility {
    public static final int MASK_FACINGS = 63;
    public static final EnumFacing[][] enumFacingArrays = ChunkVisibility.makeEnumFacingArrays(false);
    public static final EnumFacing[][] enumFacingOppositeArrays = ChunkVisibility.makeEnumFacingArrays(true);
    private static int counter = 0;
    private static int iMaxStatic = -1;
    private static int iMaxStaticFinal = 16;
    private static World worldLast = null;
    private static int pcxLast = Integer.MIN_VALUE;
    private static int pczLast = Integer.MIN_VALUE;

    public static int getMaxChunkY(World world2, Entity entity, int n) {
        int n2 = MathHelper.floor_double(entity.posX) >> 4;
        int n3 = MathHelper.floor_double(entity.posY) >> 4;
        int n4 = MathHelper.floor_double(entity.posZ) >> 4;
        Chunk chunk = world2.getChunkFromChunkCoords(n2, n4);
        int n5 = n2 - n;
        int n6 = n2 + n;
        int n7 = n4 - n;
        int n8 = n4 + n;
        if (world2 != worldLast || n2 != pcxLast || n4 != pczLast) {
            counter = 0;
            iMaxStaticFinal = 16;
            worldLast = world2;
            pcxLast = n2;
            pczLast = n4;
        }
        if (counter == 0) {
            iMaxStatic = -1;
        }
        int n9 = iMaxStatic;
        switch (counter) {
            case 0: {
                n6 = n2;
                n8 = n4;
                break;
            }
            case 1: {
                n5 = n2;
                n8 = n4;
                break;
            }
            case 2: {
                n6 = n2;
                n7 = n4;
                break;
            }
            case 3: {
                n5 = n2;
                n7 = n4;
            }
        }
        for (int i = n5; i < n6; ++i) {
            block9: for (int j = n7; j < n8; ++j) {
                ClassInheritanceMultiMap<Entity>[] classInheritanceMultiMapArray;
                Chunk chunk2 = world2.getChunkFromChunkCoords(i, j);
                if (chunk2.isEmpty()) continue;
                ExtendedBlockStorage[] extendedBlockStorageArray = chunk2.getBlockStorageArray();
                for (int k = extendedBlockStorageArray.length - 1; k > n9; --k) {
                    ExtendedBlockStorage extendedBlockStorage = extendedBlockStorageArray[k];
                    if (extendedBlockStorage == null || extendedBlockStorage.isEmpty()) continue;
                    if (k <= n9) break;
                    n9 = k;
                    break;
                }
                try {
                    classInheritanceMultiMapArray = chunk2.getTileEntityMap();
                    if (!classInheritanceMultiMapArray.isEmpty()) {
                        for (ClassInheritanceMultiMap<Entity> classInheritanceMultiMap : classInheritanceMultiMapArray.keySet()) {
                            int n10 = ((Vec3i)((Object)classInheritanceMultiMap)).getY() >> 4;
                            if (n10 <= n9) continue;
                            n9 = n10;
                        }
                    }
                }
                catch (ConcurrentModificationException concurrentModificationException) {
                    // empty catch block
                }
                classInheritanceMultiMapArray = chunk2.getEntityLists();
                for (int k = classInheritanceMultiMapArray.length - 1; k > n9; --k) {
                    ClassInheritanceMultiMap<Entity> classInheritanceMultiMap;
                    classInheritanceMultiMap = classInheritanceMultiMapArray[k];
                    if (classInheritanceMultiMap.isEmpty() || chunk2 == chunk && k == n3 && classInheritanceMultiMap.size() == 1) continue;
                    if (k <= n9) continue block9;
                    n9 = k;
                    continue block9;
                }
            }
        }
        if (counter < 3) {
            iMaxStatic = n9;
            n9 = iMaxStaticFinal;
        } else {
            iMaxStaticFinal = n9;
            iMaxStatic = -1;
        }
        counter = (counter + 1) % 4;
        return n9 << 4;
    }

    public static boolean isFinished() {
        return counter == 0;
    }

    private static EnumFacing[][] makeEnumFacingArrays(boolean bl) {
        int n = 64;
        EnumFacing[][] enumFacingArray = new EnumFacing[n][];
        for (int i = 0; i < n; ++i) {
            ArrayList<EnumFacing> arrayList = new ArrayList<EnumFacing>();
            for (int j = 0; j < EnumFacing.VALUES.length; ++j) {
                EnumFacing enumFacing = EnumFacing.VALUES[j];
                EnumFacing enumFacing2 = bl ? enumFacing.getOpposite() : enumFacing;
                int n2 = 1 << enumFacing2.ordinal();
                if ((i & n2) == 0) continue;
                arrayList.add(enumFacing);
            }
            EnumFacing[] enumFacingArray2 = arrayList.toArray(new EnumFacing[arrayList.size()]);
            enumFacingArray[i] = enumFacingArray2;
        }
        return enumFacingArray;
    }

    public static EnumFacing[] getFacingsNotOpposite(int n) {
        int n2 = ~n & 0x3F;
        return enumFacingOppositeArrays[n2];
    }

    public static void reset() {
        worldLast = null;
    }
}


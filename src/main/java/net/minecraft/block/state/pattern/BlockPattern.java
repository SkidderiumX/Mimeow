/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block.state.pattern;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import net.minecraft.block.state.BlockWorldState;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Vec3i;
import net.minecraft.world.World;

public class BlockPattern {
    private final Predicate<BlockWorldState>[][][] blockMatches;
    private final int fingerLength;
    private final int thumbLength;
    private final int palmLength;

    public BlockPattern(Predicate<BlockWorldState>[][][] predicateArray) {
        this.blockMatches = predicateArray;
        this.fingerLength = predicateArray.length;
        if (this.fingerLength > 0) {
            this.thumbLength = predicateArray[0].length;
            this.palmLength = this.thumbLength > 0 ? predicateArray[0][0].length : 0;
        } else {
            this.thumbLength = 0;
            this.palmLength = 0;
        }
    }

    public int getThumbLength() {
        return this.thumbLength;
    }

    public int getPalmLength() {
        return this.palmLength;
    }

    private PatternHelper checkPatternAt(BlockPos blockPos, EnumFacing enumFacing, EnumFacing enumFacing2, LoadingCache<BlockPos, BlockWorldState> loadingCache) {
        for (int i = 0; i < this.palmLength; ++i) {
            for (int j = 0; j < this.thumbLength; ++j) {
                for (int k = 0; k < this.fingerLength; ++k) {
                    if (this.blockMatches[k][j][i].apply(loadingCache.getUnchecked(BlockPattern.translateOffset(blockPos, enumFacing, enumFacing2, i, j, k)))) continue;
                    return null;
                }
            }
        }
        return new PatternHelper(blockPos, enumFacing, enumFacing2, loadingCache, this.palmLength, this.thumbLength, this.fingerLength);
    }

    public PatternHelper match(World world2, BlockPos blockPos) {
        LoadingCache<BlockPos, BlockWorldState> loadingCache = BlockPattern.func_181627_a(world2, false);
        int n = Math.max(Math.max(this.palmLength, this.thumbLength), this.fingerLength);
        for (BlockPos blockPos2 : BlockPos.getAllInBox(blockPos, blockPos.add(n - 1, n - 1, n - 1))) {
            for (EnumFacing enumFacing : EnumFacing.values()) {
                for (EnumFacing enumFacing2 : EnumFacing.values()) {
                    PatternHelper patternHelper;
                    if (enumFacing2 == enumFacing || enumFacing2 == enumFacing.getOpposite() || (patternHelper = this.checkPatternAt(blockPos2, enumFacing, enumFacing2, loadingCache)) == null) continue;
                    return patternHelper;
                }
            }
        }
        return null;
    }

    public static LoadingCache<BlockPos, BlockWorldState> func_181627_a(World world2, boolean bl) {
        return CacheBuilder.newBuilder().build(new CacheLoader(world2, bl));
    }

    protected static BlockPos translateOffset(BlockPos blockPos, EnumFacing enumFacing, EnumFacing enumFacing2, int n, int n2, int n3) {
        if (enumFacing != enumFacing2 && enumFacing != enumFacing2.getOpposite()) {
            Vec3i vec3i = new Vec3i(enumFacing.getFrontOffsetX(), enumFacing.getFrontOffsetY(), enumFacing.getFrontOffsetZ());
            Vec3i vec3i2 = new Vec3i(enumFacing2.getFrontOffsetX(), enumFacing2.getFrontOffsetY(), enumFacing2.getFrontOffsetZ());
            Vec3i vec3i3 = vec3i.crossProduct(vec3i2);
            return blockPos.add(vec3i2.getX() * -n2 + vec3i3.getX() * n + vec3i.getX() * n3, vec3i2.getY() * -n2 + vec3i3.getY() * n + vec3i.getY() * n3, vec3i2.getZ() * -n2 + vec3i3.getZ() * n + vec3i.getZ() * n3);
        }
        throw new IllegalArgumentException("Invalid forwards & up combination");
    }

    public static class PatternHelper {
        private final BlockPos pos;
        private final EnumFacing finger;
        private final EnumFacing thumb;
        private final LoadingCache<BlockPos, BlockWorldState> lcache;
        private final int field_181120_e;
        private final int field_181121_f;
        private final int field_181122_g;

        public PatternHelper(BlockPos blockPos, EnumFacing enumFacing, EnumFacing enumFacing2, LoadingCache<BlockPos, BlockWorldState> loadingCache, int n, int n2, int n3) {
            this.pos = blockPos;
            this.finger = enumFacing;
            this.thumb = enumFacing2;
            this.lcache = loadingCache;
            this.field_181120_e = n;
            this.field_181121_f = n2;
            this.field_181122_g = n3;
        }

        public BlockPos getPos() {
            return this.pos;
        }

        public EnumFacing getFinger() {
            return this.finger;
        }

        public EnumFacing getThumb() {
            return this.thumb;
        }

        public int func_181118_d() {
            return this.field_181120_e;
        }

        public int func_181119_e() {
            return this.field_181121_f;
        }

        public BlockWorldState translateOffset(int n, int n2, int n3) {
            return this.lcache.getUnchecked(BlockPattern.translateOffset(this.pos, this.getFinger(), this.getThumb(), n, n2, n3));
        }

        public String toString() {
            return Objects.toStringHelper(this).add("up", this.thumb).add("forwards", this.finger).add("frontTopLeft", this.pos).toString();
        }
    }

    public static class CacheLoader
    extends com.google.common.cache.CacheLoader<BlockPos, BlockWorldState> {
        private final World world;
        private final boolean field_181626_b;

        public CacheLoader(World world2, boolean bl) {
            this.world = world2;
            this.field_181626_b = bl;
        }

        @Override
        public BlockWorldState load(BlockPos blockPos) throws Exception {
            return new BlockWorldState(this.world, blockPos, this.field_181626_b);
        }
    }
}


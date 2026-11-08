/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;

public interface oce6fde6f14a {
    public boolean z$11r2n2rw0zig9(IBlockState var1);

    default public boolean z$3mptsutoy1cyd(BlockPos blockPos, IBlockState iBlockState) {
        return this.z$11r2n2rw0zig9(iBlockState);
    }

    default public boolean z$2terxsjcchy0a() {
        return true;
    }

    default public void z$1o3njpmxa1ma5() {
    }
}


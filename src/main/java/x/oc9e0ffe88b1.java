/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.block.BlockBed;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import x.oc75d51ec7eb;
import x.oce6fde6f14a;

public class oc9e0ffe88b1
implements oce6fde6f14a {
    public static boolean \u04e2;

    @Override
    public boolean z$11r2n2rw0zig9(IBlockState iBlockState) {
        boolean bl;
        block6: {
            block5: {
                IBlockState iBlockState2;
                int n;
                block4: {
                    n = oc75d51ec7eb.\u03e9;
                    iBlockState2 = iBlockState;
                    if (n != 0) break block4;
                    if (iBlockState2 == null) break block5;
                    iBlockState2 = iBlockState;
                }
                bl = iBlockState2.getBlock() instanceof BlockBed;
                if (n != 0) break block6;
                if (!bl) break block5;
                bl = true;
                break block6;
            }
            bl = false;
        }
        return bl;
    }

    @Override
    public boolean z$3mptsutoy1cyd(BlockPos blockPos, IBlockState iBlockState) {
        block5: {
            boolean bl;
            block4: {
                int n = oc75d51ec7eb.\u03e9;
                bl = this.z$11r2n2rw0zig9(iBlockState);
                if (n != 0) break block4;
                if (bl) break block5;
                bl = false;
            }
            return bl;
        }
        boolean bl = iBlockState.getValue(BlockBed.PART) == BlockBed.EnumPartType.FOOT;
        return bl;
    }
}


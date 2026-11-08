/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Map;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Vec3;
import x.oc2ae3d414e8;
import x.oc63a9b409d2;
import x.ocfa11b18c57;

public class oc9b32a258fb {
    private final BlockPos \u0450;
    private final BlockPos \u04f0;
    private final EnumFacing \u01d1;
    private Vec3 \u057e;
    private final IBlockState \u050b;
    private final int \u03d7;
    private final float \u04e5;
    private final float p;
    private float E;
    private float \u049c;
    private boolean I;
    final oc63a9b409d2 this$0;

    private oc9b32a258fb(oc63a9b409d2 oc63a9b409d22, BlockPos blockPos, BlockPos blockPos2, EnumFacing enumFacing, Vec3 vec3, IBlockState iBlockState, int n, float f, float f2) {
        this.this$0 = oc63a9b409d22;
        this.\u0450 = blockPos;
        this.\u04f0 = blockPos2;
        this.\u01d1 = enumFacing;
        this.\u057e = vec3;
        this.\u050b = iBlockState;
        this.\u03d7 = n;
        this.\u04e5 = f;
        this.p = f2;
        this.E = f;
        this.\u049c = f2;
    }

    private boolean \u021a(Map<BlockPos, oc2ae3d414e8> map) {
        boolean bl;
        block6: {
            block7: {
                block5: {
                    oc2ae3d414e8 oc2ae3d414e82;
                    int n;
                    block4: {
                        oc2ae3d414e8 oc2ae3d414e83 = map.get(this.\u0450);
                        n = ocfa11b18c57.\u0117;
                        oc2ae3d414e82 = oc2ae3d414e83;
                        if (n != 0) break block4;
                        if (oc2ae3d414e82 == null) break block5;
                        oc2ae3d414e82 = oc2ae3d414e83;
                    }
                    bl = oc2ae3d414e82.\u0121;
                    if (n != 0) break block6;
                    if (!bl) break block7;
                }
                bl = true;
                break block6;
            }
            bl = false;
        }
        return bl;
    }
}


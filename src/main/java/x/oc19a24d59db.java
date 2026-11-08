/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import x.ocbf5a535fb8;
import x.occ0b63c0426;
import x.occb1ed1ed8f;

public class oc19a24d59db {
    private final IBlockState D;
    private final Block \u04fc;
    public String y;
    public String \u0461;
    public boolean \u01ee;
    public int \u0580;
    public double \u04d7;
    public double \u0175;
    public double \u04bd;
    public double \u04d4;
    public double \u0123;
    public double \u01bd;
    public static boolean \u02b4;

    public oc19a24d59db(Block block, BlockPos blockPos) {
        this(block == null ? null : block.getDefaultState(), blockPos);
    }

    public oc19a24d59db(IBlockState iBlockState) {
        this(iBlockState, BlockPos.ORIGIN);
    }

    public oc19a24d59db(IBlockState iBlockState, BlockPos blockPos) {
        this.D = iBlockState;
        this.\u04fc = iBlockState == null ? null : iBlockState.getBlock();
        this.\u04d4 = blockPos == null ? 0.0 : (double)blockPos.getX();
        this.\u0123 = blockPos == null ? 0.0 : (double)blockPos.getY();
        this.\u01bd = blockPos == null ? 0.0 : (double)blockPos.getZ();
        this.y = this.\u04fc == null ? "BlockAir" : this.\u04fc.getClass().getSimpleName();
        this.\u0461 = occ0b63c0426.\u025b(this.\u04fc);
        this.\u01ee = this.\u04fc != null && occb1ed1ed8f.\u023c(this.\u04fc);
        this.\u0580 = iBlockState == null || this.\u04fc == null ? 0 : this.\u04fc.getMetaFromState(iBlockState);
        this.\u04d7 = this.\u04fc == null ? 0.0 : this.\u04fc.getBlockBoundsMaxY() - this.\u04fc.getBlockBoundsMinY();
        this.\u0175 = this.\u04fc == null ? 0.0 : this.\u04fc.getBlockBoundsMaxX() - this.\u04fc.getBlockBoundsMinX();
        this.\u04bd = this.\u04fc == null ? 0.0 : this.\u04fc.getBlockBoundsMaxZ() - this.\u04fc.getBlockBoundsMinZ();
    }

    public oc19a24d59db(int n, int n2, int n3) {
        this(oc19a24d59db.\u044b(n, n2, n3), new BlockPos(n, n2, n3));
    }

    public oc19a24d59db(String string) {
        this(Block.blockRegistry.getObject(string == null ? new ResourceLocation("air") : new ResourceLocation(string)), BlockPos.ORIGIN);
    }

    public oc19a24d59db(ocbf5a535fb8 ocbf5a535fb82) {
        this(ocbf5a535fb82 == null ? 0 : (int)Math.floor(ocbf5a535fb82.\u03ba), ocbf5a535fb82 == null ? 0 : (int)Math.floor(ocbf5a535fb82.\u0418), ocbf5a535fb82 == null ? 0 : (int)Math.floor(ocbf5a535fb82.\u03e0));
    }

    public String \u019d() {
        String string;
        block8: {
            Object v2;
            block6: {
                Object var2_2;
                block7: {
                    int n = occ0b63c0426.\u039f;
                    Object v0 = this.\u04fc == null ? null : Block.blockRegistry.getNameForObject(this.\u04fc);
                    var2_2 = v0;
                    v2 = var2_2;
                    if (n != 0) break block6;
                    if (v2 != null) break block7;
                    string = "minecraft:air";
                    break block8;
                }
                v2 = var2_2;
            }
            string = String.valueOf(v2);
        }
        return string;
    }

    public int \u0129() {
        int n;
        block6: {
            oc19a24d59db oc19a24d59db2;
            block4: {
                block5: {
                    int n2 = occ0b63c0426.\u039f;
                    oc19a24d59db2 = this;
                    if (n2 != 0) break block4;
                    if (oc19a24d59db2.\u04fc != null) break block5;
                    n = 0;
                    break block6;
                }
                oc19a24d59db2 = this;
            }
            n = Block.getIdFromBlock(oc19a24d59db2.\u04fc);
        }
        return n;
    }

    public int \u042a() {
        return this.\u0580;
    }

    public String \u01ad() {
        return this.y;
    }

    public String \u04aa() {
        return this.\u0461;
    }

    public boolean \u03f5() {
        return this.\u01ee;
    }

    public int \u0585() {
        return this.\u0580;
    }

    public double \u0554() {
        return this.\u04d7;
    }

    public double \u0213() {
        return this.\u0175;
    }

    public double \u0400() {
        return this.\u04bd;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean \u026a() {
        oc19a24d59db oc19a24d59db2;
        block6: {
            int n = occ0b63c0426.\u039f;
            oc19a24d59db2 = this;
            if (n != 0) break block6;
            if (oc19a24d59db2.\u04fc == null) return true;
            oc19a24d59db2 = this;
        }
        if (oc19a24d59db2.\u04fc.getMaterial() != Material.air) return false;
        return true;
    }

    public boolean \u0155() {
        boolean bl;
        block8: {
            block7: {
                oc19a24d59db oc19a24d59db2;
                int n;
                block6: {
                    n = occ0b63c0426.\u039f;
                    oc19a24d59db2 = this;
                    if (n != 0) break block6;
                    if (oc19a24d59db2.\u04fc == null) break block7;
                    oc19a24d59db2 = this;
                }
                bl = occb1ed1ed8f.\u0523(oc19a24d59db2.\u04fc);
                if (n != 0) break block8;
                if (!bl) break block7;
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }

    public float \u04ac() {
        float f;
        block6: {
            oc19a24d59db oc19a24d59db2;
            block4: {
                block5: {
                    int n = occ0b63c0426.\u039f;
                    oc19a24d59db2 = this;
                    if (n != 0) break block4;
                    if (oc19a24d59db2.\u04fc != null) break block5;
                    f = 0.0f;
                    break block6;
                }
                oc19a24d59db2 = this;
            }
            f = oc19a24d59db2.\u04fc.getBlockHardness(Minecraft.getMinecraft().theWorld, new BlockPos(this.\u04d4, this.\u0123, this.\u01bd));
        }
        return f;
    }

    public ocbf5a535fb8 \u053f() {
        return new ocbf5a535fb8(this.\u04d4, this.\u0123, this.\u01bd);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static IBlockState \u044b(int n, int n2, int n3) {
        Minecraft minecraft;
        block7: {
            Minecraft minecraft2;
            block8: {
                int n4;
                block6: {
                    minecraft2 = Minecraft.getMinecraft();
                    n4 = occ0b63c0426.\u039f;
                    minecraft = minecraft2;
                    if (n4 != 0) break block6;
                    if (minecraft == null) return null;
                    minecraft = minecraft2;
                }
                if (n4 != 0) break block7;
                if (minecraft.theWorld != null) break block8;
                return null;
            }
            minecraft = minecraft2;
        }
        IBlockState iBlockState = minecraft.theWorld.getBlockState(new BlockPos(n, n2, n3));
        return iBlockState;
    }
}


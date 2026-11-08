/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen;

import com.google.common.base.Objects;
import java.util.Random;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.MapGenBase;

public class MapGenCaves
extends MapGenBase {
    protected void func_180703_a(long l, int n, int n2, ChunkPrimer chunkPrimer, double d, double d2, double d3) {
        this.func_180702_a(l, n, n2, chunkPrimer, d, d2, d3, 1.0f + this.rand.nextFloat() * 6.0f, 0.0f, 0.0f, -1, -1, 0.5);
    }

    protected void func_180702_a(long l, int n, int n2, ChunkPrimer chunkPrimer, double d, double d2, double d3, float f, float f2, float f3, int n3, int n4, double d4) {
        boolean bl;
        int n5;
        double d5 = n * 16 + 8;
        double d6 = n2 * 16 + 8;
        float f4 = 0.0f;
        float f5 = 0.0f;
        Random random = new Random(l);
        if (n4 <= 0) {
            n5 = this.range * 16 - 16;
            n4 = n5 - random.nextInt(n5 / 4);
        }
        n5 = 0;
        if (n3 == -1) {
            n3 = n4 / 2;
            n5 = 1;
        }
        int n6 = random.nextInt(n4 / 2) + n4 / 4;
        boolean bl2 = bl = random.nextInt(6) == 0;
        while (n3 < n4) {
            double d7 = 1.5 + (double)(MathHelper.sin((float)n3 * (float)Math.PI / (float)n4) * f * 1.0f);
            double d8 = d7 * d4;
            float f6 = MathHelper.cos(f3);
            float f7 = MathHelper.sin(f3);
            d += (double)(MathHelper.cos(f2) * f6);
            d2 += (double)f7;
            d3 += (double)(MathHelper.sin(f2) * f6);
            f3 = bl ? (f3 *= 0.92f) : (f3 *= 0.7f);
            f3 += f5 * 0.1f;
            f2 += f4 * 0.1f;
            f5 *= 0.9f;
            f4 *= 0.75f;
            f5 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 2.0f;
            f4 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 4.0f;
            if (n5 == 0 && n3 == n6 && f > 1.0f && n4 > 0) {
                this.func_180702_a(random.nextLong(), n, n2, chunkPrimer, d, d2, d3, random.nextFloat() * 0.5f + 0.5f, f2 - 1.5707964f, f3 / 3.0f, n3, n4, 1.0);
                this.func_180702_a(random.nextLong(), n, n2, chunkPrimer, d, d2, d3, random.nextFloat() * 0.5f + 0.5f, f2 + 1.5707964f, f3 / 3.0f, n3, n4, 1.0);
                return;
            }
            if (n5 != 0 || random.nextInt(4) != 0) {
                double d9 = d - d5;
                double d10 = d3 - d6;
                double d11 = n4 - n3;
                double d12 = f + 2.0f + 16.0f;
                if (d9 * d9 + d10 * d10 - d11 * d11 > d12 * d12) {
                    return;
                }
                if (d >= d5 - 16.0 - d7 * 2.0 && d3 >= d6 - 16.0 - d7 * 2.0 && d <= d5 + 16.0 + d7 * 2.0 && d3 <= d6 + 16.0 + d7 * 2.0) {
                    int n7;
                    int n8 = MathHelper.floor_double(d - d7) - n * 16 - 1;
                    int n9 = MathHelper.floor_double(d + d7) - n * 16 + 1;
                    int n10 = MathHelper.floor_double(d2 - d8) - 1;
                    int n11 = MathHelper.floor_double(d2 + d8) + 1;
                    int n12 = MathHelper.floor_double(d3 - d7) - n2 * 16 - 1;
                    int n13 = MathHelper.floor_double(d3 + d7) - n2 * 16 + 1;
                    if (n8 < 0) {
                        n8 = 0;
                    }
                    if (n9 > 16) {
                        n9 = 16;
                    }
                    if (n10 < 1) {
                        n10 = 1;
                    }
                    if (n11 > 248) {
                        n11 = 248;
                    }
                    if (n12 < 0) {
                        n12 = 0;
                    }
                    if (n13 > 16) {
                        n13 = 16;
                    }
                    boolean bl3 = false;
                    for (int i = n8; !bl3 && i < n9; ++i) {
                        for (n7 = n12; !bl3 && n7 < n13; ++n7) {
                            for (int j = n11 + 1; !bl3 && j >= n10 - 1; --j) {
                                if (j < 0 || j >= 256) continue;
                                IBlockState iBlockState = chunkPrimer.getBlockState(i, j, n7);
                                if (iBlockState.getBlock() == Blocks.flowing_water || iBlockState.getBlock() == Blocks.water) {
                                    bl3 = true;
                                }
                                if (j == n10 - 1 || i == n8 || i == n9 - 1 || n7 == n12 || n7 == n13 - 1) continue;
                                j = n10;
                            }
                        }
                    }
                    if (!bl3) {
                        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
                        for (n7 = n8; n7 < n9; ++n7) {
                            double d13 = ((double)(n7 + n * 16) + 0.5 - d) / d7;
                            for (int i = n12; i < n13; ++i) {
                                double d14 = ((double)(i + n2 * 16) + 0.5 - d3) / d7;
                                boolean bl4 = false;
                                if (!(d13 * d13 + d14 * d14 < 1.0)) continue;
                                for (int j = n11; j > n10; --j) {
                                    double d15 = ((double)(j - 1) + 0.5 - d2) / d8;
                                    if (!(d15 > -0.7) || !(d13 * d13 + d15 * d15 + d14 * d14 < 1.0)) continue;
                                    IBlockState iBlockState = chunkPrimer.getBlockState(n7, j, i);
                                    IBlockState iBlockState2 = Objects.firstNonNull(chunkPrimer.getBlockState(n7, j + 1, i), Blocks.air.getDefaultState());
                                    if (iBlockState.getBlock() == Blocks.grass || iBlockState.getBlock() == Blocks.mycelium) {
                                        bl4 = true;
                                    }
                                    if (!this.func_175793_a(iBlockState, iBlockState2)) continue;
                                    if (j - 1 < 10) {
                                        chunkPrimer.setBlockState(n7, j, i, Blocks.lava.getDefaultState());
                                        continue;
                                    }
                                    chunkPrimer.setBlockState(n7, j, i, Blocks.air.getDefaultState());
                                    if (iBlockState2.getBlock() == Blocks.sand) {
                                        chunkPrimer.setBlockState(n7, j + 1, i, iBlockState2.getValue(BlockSand.VARIANT) == BlockSand.EnumType.RED_SAND ? Blocks.red_sandstone.getDefaultState() : Blocks.sandstone.getDefaultState());
                                    }
                                    if (!bl4 || chunkPrimer.getBlockState(n7, j - 1, i).getBlock() != Blocks.dirt) continue;
                                    mutableBlockPos.set(n7 + n * 16, 0, i + n2 * 16);
                                    chunkPrimer.setBlockState(n7, j - 1, i, this.worldObj.getBiomeGenForCoords((BlockPos)mutableBlockPos).topBlock.getBlock().getDefaultState());
                                }
                            }
                        }
                        if (n5 != 0) break;
                    }
                }
            }
            ++n3;
        }
    }

    protected boolean func_175793_a(IBlockState iBlockState, IBlockState iBlockState2) {
        return iBlockState.getBlock() == Blocks.stone ? true : (iBlockState.getBlock() == Blocks.dirt ? true : (iBlockState.getBlock() == Blocks.grass ? true : (iBlockState.getBlock() == Blocks.hardened_clay ? true : (iBlockState.getBlock() == Blocks.stained_hardened_clay ? true : (iBlockState.getBlock() == Blocks.sandstone ? true : (iBlockState.getBlock() == Blocks.red_sandstone ? true : (iBlockState.getBlock() == Blocks.mycelium ? true : (iBlockState.getBlock() == Blocks.snow_layer ? true : (iBlockState.getBlock() == Blocks.sand || iBlockState.getBlock() == Blocks.gravel) && iBlockState2.getBlock().getMaterial() != Material.water))))))));
    }

    @Override
    protected void recursiveGenerate(World world2, int n, int n2, int n3, int n4, ChunkPrimer chunkPrimer) {
        int n5 = this.rand.nextInt(this.rand.nextInt(this.rand.nextInt(15) + 1) + 1);
        if (this.rand.nextInt(7) != 0) {
            n5 = 0;
        }
        for (int i = 0; i < n5; ++i) {
            double d = n * 16 + this.rand.nextInt(16);
            double d2 = this.rand.nextInt(this.rand.nextInt(120) + 8);
            double d3 = n2 * 16 + this.rand.nextInt(16);
            int n6 = 1;
            if (this.rand.nextInt(4) == 0) {
                this.func_180703_a(this.rand.nextLong(), n3, n4, chunkPrimer, d, d2, d3);
                n6 += this.rand.nextInt(4);
            }
            for (int j = 0; j < n6; ++j) {
                float f = this.rand.nextFloat() * (float)Math.PI * 2.0f;
                float f2 = (this.rand.nextFloat() - 0.5f) * 2.0f / 8.0f;
                float f3 = this.rand.nextFloat() * 2.0f + this.rand.nextFloat();
                if (this.rand.nextInt(10) == 0) {
                    f3 *= this.rand.nextFloat() * this.rand.nextFloat() * 3.0f + 1.0f;
                }
                this.func_180702_a(this.rand.nextLong(), n3, n4, chunkPrimer, d, d2, d3, f3, f, f2, 0, 0, 1.0);
            }
        }
    }
}


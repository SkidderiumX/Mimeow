/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import x.oc75d51ec7eb;
import x.oc7beea7ccff;
import x.oc84f20a0bc5;
import x.ocda171fe5d8;
import x.ocea775c9d5c;
import x.ocf242f30eaa;

public class oc3e9033eba7
implements ocda171fe5d8 {
    public static int \u0497;

    private oc3e9033eba7() {
    }

    public static Block \u0224(double d, double d2, double d3) {
        return ocda171fe5d8.\u01d4.theWorld.getBlockState(new BlockPos(d, d2, d3)).getBlock();
    }

    public static boolean \u039f() {
        return oc3e9033eba7.\u00fc(1.0);
    }

    public static AxisAlignedBB \u0569(double d) {
        double d2;
        double d3;
        EntityPlayerSP entityPlayerSP;
        block35: {
            float f;
            float f2;
            float f3;
            oc7beea7ccff oc7beea7ccff2;
            block36: {
                float f4;
                float f5;
                block37: {
                    int n;
                    block34: {
                        block33: {
                            double d4;
                            block32: {
                                block38: {
                                    ocf242f30eaa ocf242f30eaa2;
                                    block30: {
                                        block31: {
                                            GameSettings gameSettings;
                                            GameSettings gameSettings2;
                                            block28: {
                                                block29: {
                                                    block26: {
                                                        block27: {
                                                            block24: {
                                                                block25: {
                                                                    entityPlayerSP = ocda171fe5d8.\u01d4.thePlayer;
                                                                    oc7beea7ccff2 = oc7beea7ccff.\u056f();
                                                                    d3 = entityPlayerSP.motionX;
                                                                    d2 = entityPlayerSP.motionZ;
                                                                    n = oc75d51ec7eb.\u03e9;
                                                                    f3 = 0.0f;
                                                                    f2 = 0.0f;
                                                                    gameSettings2 = ocda171fe5d8.\u01d4.gameSettings;
                                                                    gameSettings = gameSettings2;
                                                                    if (n != 0) break block24;
                                                                    if (!gameSettings.keyBindForward.isKeyDown()) break block25;
                                                                    f3 += 1.0f;
                                                                }
                                                                gameSettings = gameSettings2;
                                                            }
                                                            if (n != 0) break block26;
                                                            if (!gameSettings.keyBindBack.isKeyDown()) break block27;
                                                            f3 -= 1.0f;
                                                        }
                                                        gameSettings = gameSettings2;
                                                    }
                                                    if (n != 0) break block28;
                                                    if (!gameSettings.keyBindLeft.isKeyDown()) break block29;
                                                    f2 += 1.0f;
                                                }
                                                gameSettings = gameSettings2;
                                            }
                                            if (gameSettings.keyBindRight.isKeyDown()) {
                                                f2 -= 1.0f;
                                            }
                                            ocf242f30eaa2 = new ocf242f30eaa(f3, f2, gameSettings2.keyBindJump.isKeyDown());
                                            ocea775c9d5c.\u0173.post(ocf242f30eaa2);
                                            if (n != 0) break block30;
                                            if (!ocf242f30eaa2.isCanceled()) break block31;
                                            f2 = 0.0f;
                                            f3 = 0.0f;
                                            if (n == 0) break block38;
                                        }
                                        f3 = ocf242f30eaa2.\u0391();
                                    }
                                    f2 = ocf242f30eaa2.\u03a5();
                                }
                                double d5 = d3 * 0.98;
                                if (n == 0) {
                                    d3 = d5;
                                    d2 *= 0.98;
                                    if (Math.abs(d3) < 0.005) {
                                        d3 = 0.0;
                                    }
                                    d4 = d2;
                                    if (n != 0) break block32;
                                    d5 = Math.abs(d4);
                                }
                                if (!(d5 < 0.005)) break block33;
                                d4 = 0.0;
                            }
                            d2 = d4;
                        }
                        f2 *= 0.98f;
                        f3 *= 0.98f;
                        float f6 = 0.91f;
                        if (entityPlayerSP.onGround) {
                            BlockPos blockPos = new BlockPos(MathHelper.floor_double(entityPlayerSP.posX), MathHelper.floor_double(entityPlayerSP.getEntityBoundingBox().minY) - 1, MathHelper.floor_double(entityPlayerSP.posZ));
                            f6 = entityPlayerSP.worldObj.getBlockState((BlockPos)blockPos).getBlock().slipperiness * 0.91f;
                        }
                        float f7 = 0.16277136f / (f6 * f6 * f6);
                        f5 = entityPlayerSP.getAIMoveSpeed() * f7;
                        f4 = f2 * f2 + f3 * f3;
                        f = f4;
                        if (n != 0) break block34;
                        if (!(f >= 1.0E-4f)) break block35;
                        f = f4 = MathHelper.sqrt_float(f4);
                    }
                    if (n != 0) break block36;
                    if (!(f < 1.0f)) break block37;
                    f4 = 1.0f;
                }
                f4 = f5 / f4;
                f2 *= f4;
                f3 *= f4;
                f = MathHelper.sin(oc7beea7ccff2.\u0265() * (float)Math.PI / 180.0f);
            }
            float f8 = f;
            float f9 = MathHelper.cos(oc7beea7ccff2.\u0265() * (float)Math.PI / 180.0f);
            d3 += (double)(f2 * f9 - f3 * f8);
            d2 += (double)(f3 * f9 + f2 * f8);
        }
        return entityPlayerSP.getEntityBoundingBox().offset(d3 * d, 0.0, d2 * d);
    }

    public static AxisAlignedBB \u0463(double d, float f, float f2, float f3) {
        double d2;
        double d3;
        EntityPlayerSP entityPlayerSP;
        block17: {
            float f4;
            block18: {
                float f5;
                float f6;
                float f7;
                block16: {
                    int n;
                    block15: {
                        double d4;
                        block14: {
                            double d5;
                            double d6;
                            block12: {
                                block13: {
                                    entityPlayerSP = ocda171fe5d8.\u01d4.thePlayer;
                                    d3 = entityPlayerSP.motionX;
                                    d2 = entityPlayerSP.motionZ;
                                    n = oc75d51ec7eb.\u03e9;
                                    d6 = Math.abs(d3);
                                    d5 = 0.005;
                                    if (n != 0) break block12;
                                    if (!(d6 < d5)) break block13;
                                    d3 = 0.0;
                                }
                                d4 = d2;
                                if (n != 0) break block14;
                                d6 = Math.abs(d4);
                                d5 = 0.005;
                            }
                            if (!(d6 < d5)) break block15;
                            d4 = 0.0;
                        }
                        d2 = d4;
                    }
                    f3 *= 0.98f;
                    f2 *= 0.98f;
                    float f8 = 0.91f;
                    if (entityPlayerSP.onGround) {
                        BlockPos blockPos = new BlockPos(MathHelper.floor_double(entityPlayerSP.posX), MathHelper.floor_double(entityPlayerSP.getEntityBoundingBox().minY) - 1, MathHelper.floor_double(entityPlayerSP.posZ));
                        f8 = entityPlayerSP.worldObj.getBlockState((BlockPos)blockPos).getBlock().slipperiness * 0.91f;
                    }
                    float f9 = 0.16277136f / (f8 * f8 * f8);
                    f7 = entityPlayerSP.getAIMoveSpeed() * f9;
                    f6 = f3 * f3 + f2 * f2;
                    f4 = f6;
                    f5 = 1.0E-4f;
                    if (n != 0) break block16;
                    if (!(f4 >= f5)) break block17;
                    f6 = MathHelper.sqrt_float(f6);
                    f4 = f6;
                    if (n != 0) break block18;
                    f5 = 1.0f;
                }
                if (f4 < f5) {
                    f6 = 1.0f;
                }
                f6 = f7 / f6;
                f3 *= f6;
                f2 *= f6;
                f4 = MathHelper.sin(f * (float)Math.PI / 180.0f);
            }
            float f10 = f4;
            float f11 = MathHelper.cos(f * (float)Math.PI / 180.0f);
            d3 += (double)(f3 * f11 - f2 * f10);
            d2 += (double)(f2 * f11 + f3 * f10);
        }
        return entityPlayerSP.getEntityBoundingBox().offset(d3 * d, 0.0, d2 * d);
    }

    public static boolean \u00fc(double d) {
        AxisAlignedBB axisAlignedBB = oc3e9033eba7.\u0569(d).offset(0.0, -0.5, 0.0);
        return ocda171fe5d8.\u01d4.theWorld.getCollidingBoundingBoxes(ocda171fe5d8.\u01d4.thePlayer, axisAlignedBB).isEmpty();
    }

    public static boolean \u0495(double d, float f, float f2, float f3) {
        AxisAlignedBB axisAlignedBB = oc3e9033eba7.\u0463(d, f, f2, f3).offset(0.0, -0.5, 0.0);
        return ocda171fe5d8.\u01d4.theWorld.getCollidingBoundingBoxes(ocda171fe5d8.\u01d4.thePlayer, axisAlignedBB).isEmpty();
    }

    public static Vec3 \u00e5(oc84f20a0bc5 oc84f20a0bc52) {
        oc84f20a0bc5 oc84f20a0bc53;
        block4: {
            block5: {
                int n = oc75d51ec7eb.\u03e9;
                oc84f20a0bc53 = oc84f20a0bc52;
                if (n != 0) break block4;
                if (oc84f20a0bc53 != null) break block5;
                return null;
            }
            oc84f20a0bc53 = oc84f20a0bc52;
        }
        return oc3e9033eba7.\u03cf(oc84f20a0bc53.\u0292(), oc84f20a0bc52.\u04c7());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Vec3 \u03cf(BlockPos blockPos, EnumFacing enumFacing) {
        Vec3 vec3 = new Vec3(blockPos);
        double d = 0.45 + Math.random() * 0.1;
        int n = oc75d51ec7eb.\u03e9;
        double d2 = 0.45 + Math.random() * 0.1;
        EnumFacing enumFacing2 = enumFacing;
        if (n == 0) {
            if (enumFacing2 == EnumFacing.UP) {
                vec3 = vec3.addVector(d, 1.0, d2);
                if (n == 0) return vec3;
            }
            enumFacing2 = enumFacing;
        }
        if (n == 0) {
            if (enumFacing2 == EnumFacing.DOWN) {
                vec3 = vec3.addVector(d, 0.0, d2);
                if (n == 0) return vec3;
            }
            enumFacing2 = enumFacing;
        }
        if (n == 0) {
            if (enumFacing2 == EnumFacing.EAST) {
                vec3 = vec3.addVector(1.0, d, d2);
                if (n == 0) return vec3;
            }
            enumFacing2 = enumFacing;
        }
        if (n == 0) {
            if (enumFacing2 == EnumFacing.WEST) {
                vec3 = vec3.addVector(0.0, d, d2);
                if (n == 0) return vec3;
            }
            enumFacing2 = enumFacing;
        }
        if (n == 0) {
            if (enumFacing2 == EnumFacing.NORTH) {
                vec3 = vec3.addVector(d, d2, 0.0);
                if (n == 0) return vec3;
            }
            enumFacing2 = enumFacing;
        }
        if (enumFacing2 != EnumFacing.SOUTH) return vec3;
        return vec3.addVector(d, d2, 1.0);
    }

    public static int \u0212() {
        Minecraft minecraft;
        block19: {
            int n = 0;
            int n2 = oc75d51ec7eb.\u03e9;
            while (n < (0x83A83909 ^ 0x83A83900)) {
                block20: {
                    block21: {
                        ItemStack itemStack;
                        block23: {
                            ItemStack itemStack2;
                            block24: {
                                block22: {
                                    minecraft = ocda171fe5d8.\u01d4;
                                    if (n2 != 0) break block19;
                                    itemStack2 = minecraft.thePlayer.inventory.mainInventory[n];
                                    if (n2 != 0) break block20;
                                    if (itemStack2 == null) break block21;
                                    itemStack = itemStack2;
                                    if (n2 != 0) break block22;
                                    if (!(itemStack.getItem() instanceof ItemBlock)) break block21;
                                    itemStack = itemStack2;
                                }
                                if (n2 != 0) break block23;
                                if (itemStack.stackSize > 0) break block24;
                                if (n2 == 0) break block21;
                            }
                            itemStack = itemStack2;
                        }
                        ItemBlock itemBlock = (ItemBlock)itemStack.getItem();
                        if (n2 != 0) break block20;
                        if (!oc3e9033eba7.\u0189(itemBlock.getBlock())) break block21;
                        return n;
                    }
                    ++n;
                }
                if (n2 == 0) continue;
            }
            minecraft = ocda171fe5d8.\u01d4;
        }
        return minecraft.thePlayer.inventory.currentItem;
    }

    public static boolean \u0189(Block block) {
        boolean bl;
        block58: {
            block48: {
                Block block2;
                block57: {
                    int n;
                    block56: {
                        block55: {
                            block54: {
                                block53: {
                                    block52: {
                                        block51: {
                                            block50: {
                                                block49: {
                                                    block46: {
                                                        block47: {
                                                            n = oc75d51ec7eb.\u03e9;
                                                            block2 = block;
                                                            if (n != 0) break block46;
                                                            if (block2.isFullBlock()) break block47;
                                                            block2 = block;
                                                            if (n != 0) break block46;
                                                            if (block2 != Blocks.glass) break block48;
                                                        }
                                                        block2 = block;
                                                    }
                                                    if (n != 0) break block49;
                                                    if (block2 == Blocks.sand) break block48;
                                                    block2 = block;
                                                }
                                                if (n != 0) break block50;
                                                if (block2 == Blocks.gravel) break block48;
                                                block2 = block;
                                            }
                                            if (n != 0) break block51;
                                            if (block2 == Blocks.dispenser) break block48;
                                            block2 = block;
                                        }
                                        if (n != 0) break block52;
                                        if (block2 == Blocks.command_block) break block48;
                                        block2 = block;
                                    }
                                    if (n != 0) break block53;
                                    if (block2 == Blocks.noteblock) break block48;
                                    block2 = block;
                                }
                                if (n != 0) break block54;
                                if (block2 == Blocks.furnace) break block48;
                                block2 = block;
                            }
                            if (n != 0) break block55;
                            if (block2 == Blocks.crafting_table) break block48;
                            block2 = block;
                        }
                        if (n != 0) break block56;
                        if (block2 == Blocks.tnt) break block48;
                        block2 = block;
                    }
                    if (n != 0) break block57;
                    if (block2 == Blocks.dropper) break block48;
                    block2 = block;
                }
                if (block2 == Blocks.beacon) break block48;
                bl = true;
                break block58;
            }
            bl = false;
        }
        return bl;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.BlockPos;
import x.oc75d51ec7eb;
import x.oc8825472e29;
import x.ocda171fe5d8;

public class oce0a4bd4278 {
    private oce0a4bd4278() {
    }

    static float \u02b0(BlockPos blockPos) {
        float f;
        block8: {
            float f2;
            float f3;
            block6: {
                float f4;
                int n;
                IBlockState iBlockState;
                block7: {
                    iBlockState = ocda171fe5d8.\u01d4.theWorld.getBlockState(blockPos);
                    n = oc8825472e29.\u03fa(iBlockState.getBlock(), ocda171fe5d8.\u01d4.thePlayer.inventory.currentItem);
                    Block block = iBlockState.getBlock();
                    int n2 = oc75d51ec7eb.\u03e9;
                    f4 = block.getBlockHardness(ocda171fe5d8.\u01d4.theWorld, blockPos);
                    float f5 = oce0a4bd4278.\u020c(block, n) ? 30.0f : 100.0f;
                    f3 = f5;
                    f2 = f4;
                    if (n2 != 0) break block6;
                    if (!(f2 < 0.0f)) break block7;
                    f = 0.0f;
                    break block8;
                }
                f2 = oce0a4bd4278.\u021f(iBlockState, n) / f4;
            }
            f = f2 / f3;
        }
        return f;
    }

    private static float \u021f(IBlockState iBlockState, int n) {
        float f;
        float f2;
        block13: {
            block14: {
                float f3;
                int n2;
                ItemStack itemStack;
                block12: {
                    ItemStack itemStack2;
                    block10: {
                        block11: {
                            itemStack = ocda171fe5d8.\u01d4.thePlayer.inventory.getStackInSlot(n);
                            n2 = oc75d51ec7eb.\u03e9;
                            itemStack2 = itemStack;
                            if (n2 != 0) break block10;
                            if (itemStack2 != null) break block11;
                            f3 = 1.0f;
                            break block12;
                        }
                        itemStack2 = itemStack;
                    }
                    f3 = itemStack2.getItem().getStrVsBlock(itemStack, iBlockState.getBlock());
                }
                f2 = f3;
                float f4 = f2 - 1.0f;
                f = f4 == 0.0f ? 0 : (f4 > 0.0f ? 1 : -1);
                if (n2 != 0) break block13;
                if (f <= 0) break block14;
                f = EnchantmentHelper.getEnchantmentLevel(Enchantment.efficiency.effectId, itemStack);
                if (n2 != 0) break block13;
                float f5 = f;
                if (f5 > 0) {
                    f2 += (float)(f5 * f5) + 1.0f;
                }
            }
            f = (float)ocda171fe5d8.\u01d4.thePlayer.isPotionActive(Potion.digSpeed);
        }
        if (f != false) {
            f2 *= 1.0f + (float)(ocda171fe5d8.\u01d4.thePlayer.getActivePotionEffect(Potion.digSpeed).getAmplifier() + 1) * 0.2f;
        }
        return f2;
    }

    private static boolean \u020c(Block block, int n) {
        boolean bl;
        block10: {
            block9: {
                ItemStack itemStack;
                int n2;
                block8: {
                    block7: {
                        boolean bl2;
                        block6: {
                            n2 = oc75d51ec7eb.\u03e9;
                            bl2 = block.getMaterial().isToolNotRequired();
                            if (n2 != 0) break block6;
                            if (!bl2) break block7;
                            bl2 = true;
                        }
                        return bl2;
                    }
                    ItemStack itemStack2 = ocda171fe5d8.\u01d4.thePlayer.inventory.getStackInSlot(n);
                    itemStack = itemStack2;
                    if (n2 != 0) break block8;
                    if (itemStack == null) break block9;
                    itemStack = itemStack2;
                }
                bl = itemStack.canHarvestBlock(block);
                if (n2 != 0) break block10;
                if (!bl) break block9;
                bl = true;
                break block10;
            }
            bl = false;
        }
        return bl;
    }
}


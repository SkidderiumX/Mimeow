/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import x.oc7ab2161b9f;
import x.oce6044968f8;

public enum oc0745e01074 {
    \u0269(Items.diamond_pickaxe, "Diamond Pickaxe"),
    \u040f(Items.iron_axe, "Iron Axe"),
    \u0172(Items.iron_hoe, "Iron Hoe"),
    \u0567(Items.iron_pickaxe, "Iron Pickaxe"),
    \u01d7(Items.shears, "Shears"),
    \u0187(Items.iron_shovel, "Iron Shovel"),
    \u0216(Items.iron_sword, "Iron Sword");
    private static final oc0745e01074[] $VALUES_REF;
    static {
        $VALUES_REF = oc0745e01074.\u01c7();
    }







    private final Item \u03ed;
    private final String \u0503;
    private final ItemStack \u04f1;


    private oc0745e01074(Item item, String string2) {
        this.\u03ed = item;
        this.\u0503 = string2;
        this.\u04f1 = new ItemStack(item);
    }

    private ItemStack \u0464() {
        return this.\u04f1.copy();
    }

    private static oc0745e01074 \u01a4(IBlockState iBlockState) {
        oc0745e01074 oc0745e010742;
        block18: {
            IBlockState iBlockState2;
            boolean bl;
            block16: {
                block17: {
                    bl = oce6044968f8.\u0452;
                    iBlockState2 = iBlockState;
                    if (bl) break block16;
                    if (iBlockState2 != null) break block17;
                    return null;
                }
                iBlockState2 = iBlockState;
            }
            Block block = iBlockState2.getBlock();
            if (block == Blocks.obsidian) {
                return \u0269;
            }
            oc0745e01074 oc0745e010743 = \u0567;
            float f = 1.0f;
            oc0745e01074[] oc0745e01074Array = oc0745e01074.values();
            int n = oc0745e01074Array.length;
            int n2 = 0;
            while (n2 < n) {
                block22: {
                    block21: {
                        oc0745e01074 oc0745e010744;
                        oc0745e01074 oc0745e010745;
                        block19: {
                            block20: {
                                oc0745e010742 = oc0745e01074Array[n2];
                                if (bl) break block18;
                                oc0745e010745 = oc0745e010742;
                                oc0745e010744 = oc0745e010745;
                                if (bl) break block19;
                                if (oc0745e010744 != \u0269) break block20;
                                if (!bl) break block21;
                            }
                            oc0745e010744 = oc0745e010745;
                        }
                        float f2 = oc7ab2161b9f.\u028e(oc0745e010744.\u04f1, block);
                        if (bl) break block22;
                        if (!(f2 > f)) break block21;
                        f = f2;
                        oc0745e010743 = oc0745e010745;
                    }
                    ++n2;
                }
                if (!bl) continue;
            }
            oc0745e010742 = oc0745e010743;
        }
        return oc0745e010742;
    }

    private static oc0745e01074[] \u01c7() {
        oc0745e01074[] oc0745e01074Array = new oc0745e01074[0x9B1A7109 ^ 0x9B1A710E];
        oc0745e01074Array[0] = \u0269;
        oc0745e01074Array[1] = \u040f;
        oc0745e01074Array[0x9B1A710C ^ 0x9B1A710E] = \u0172;
        oc0745e01074Array[0x9B1A710D ^ 0x9B1A710E] = \u0567;
        oc0745e01074Array[0x9B1A710A ^ 0x9B1A710E] = \u01d7;
        oc0745e01074Array[0x9B1A710B ^ 0x9B1A710E] = \u0187;
        oc0745e01074Array[0x9B1A7108 ^ 0x9B1A710E] = \u0216;
        return oc0745e01074Array;
    }
}


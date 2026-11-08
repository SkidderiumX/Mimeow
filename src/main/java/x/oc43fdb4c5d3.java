/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class oc43fdb4c5d3 {
    public final Block \u0167;
    public final int \u02b6;
    public final String \u00ed;
    public final String \u020e;
    private final Item \u0299;
    public static boolean \u03a4;

    oc43fdb4c5d3(Block block, int n, String string, String string2) {
        this(block, n, string, string2, null);
    }

    oc43fdb4c5d3(Block block, int n, String string, String string2, Item item) {
        this.\u0167 = block;
        this.\u02b6 = n;
        this.\u00ed = string != null ? string : "";
        this.\u020e = string2;
        this.\u0299 = item;
    }

    public ItemStack \u04c2() {
        if (this.\u0299 != null) {
            return new ItemStack(this.\u0299, 1, this.\u02b6);
        }
        return new ItemStack(this.\u0167, 1, this.\u02b6);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import x.oc75d51ec7eb;

public class oc2ef79a3df1 {
    public final Item \u0470;
    public final int t;
    public final String \u0466;
    public final String \u0468;
    private final ItemStack \u045c;
    public static boolean \u0517;

    oc2ef79a3df1(Item item, int n, String string, String string2) {
        this(item, n, string, string2, item != null ? new ItemStack(item, 1, n) : null);
    }

    oc2ef79a3df1(Item item, int n, String string, String string2, ItemStack itemStack) {
        this.\u0470 = item;
        this.t = n;
        this.\u0466 = string != null ? string : "";
        this.\u0468 = string2;
        this.\u045c = itemStack != null ? itemStack.copy() : null;
    }

    public ItemStack \u020b() {
        ItemStack itemStack;
        block6: {
            block5: {
                oc2ef79a3df1 oc2ef79a3df12;
                block4: {
                    int n = oc75d51ec7eb.\u03e9;
                    oc2ef79a3df12 = this;
                    if (n != 0) break block4;
                    if (oc2ef79a3df12.\u045c == null) break block5;
                    oc2ef79a3df12 = this;
                }
                itemStack = oc2ef79a3df12.\u045c.copy();
                break block6;
            }
            itemStack = null;
        }
        return itemStack;
    }
}


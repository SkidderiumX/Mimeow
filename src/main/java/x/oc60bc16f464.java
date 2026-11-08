/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import x.oc75d51ec7eb;
import x.ocb50cc94190;

public class oc60bc16f464
extends ocb50cc94190 {
    private oc60bc16f464(String string2, String string3, ItemStack itemStack) {
    }

    @Override
    boolean z$2opx8s6bbbs2u(ItemStack itemStack) {
        boolean bl;
        block6: {
            block5: {
                ItemStack itemStack2;
                int n;
                block4: {
                    n = oc75d51ec7eb.\u03e9;
                    itemStack2 = itemStack;
                    if (n != 0) break block4;
                    if (itemStack2 == null) break block5;
                    itemStack2 = itemStack;
                }
                bl = itemStack2.getItem() instanceof ItemAxe;
                if (n != 0) break block6;
                if (!bl) break block5;
                bl = true;
                break block6;
            }
            bl = false;
        }
        return bl;
    }
}


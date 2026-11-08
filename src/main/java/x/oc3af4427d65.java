/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.List;
import net.minecraft.item.ItemStack;
import x.oc43fdb4c5d3;
import x.oc75d51ec7eb;

public class oc3af4427d65 {
    public final String \u01a7;
    public final List<oc43fdb4c5d3> \u049e;
    public final int \u012b;
    public static boolean \u029c;

    public oc3af4427d65(String string, List<oc43fdb4c5d3> list, int n) {
        this.\u01a7 = string;
        this.\u049e = list;
        this.\u012b = n;
    }

    public boolean \u04ae() {
        boolean bl;
        block4: {
            block5: {
                int n = oc75d51ec7eb.\u03e9;
                bl = this.\u049e.size();
                if (n != 0) break block4;
                if (bl > true) break block5;
                bl = true;
                break block4;
            }
            bl = false;
        }
        return bl;
    }

    public String \u0520() {
        return this.\u049e.get((int)0).\u00ed + " (" + this.\u049e.size() + ")";
    }

    public ItemStack \u0478() {
        int n = (int)(System.currentTimeMillis() / (0x53091797CBC13864L ^ 0x53091797CBC13B8CL) % (long)this.\u049e.size());
        return this.\u049e.get(n).\u04c2();
    }
}


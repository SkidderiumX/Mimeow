/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.List;
import net.minecraft.item.ItemStack;
import x.oc2ef79a3df1;
import x.oc75d51ec7eb;

public class oc019314a9ca {
    public final String \u04e0;
    public final List<oc2ef79a3df1> \u0465;
    public final int \u04ae;
    private final String \u042a;
    private final String X;
    public static boolean \u028d;

    public oc019314a9ca(String string, List<oc2ef79a3df1> list, int n, String string2, String string3) {
        this.\u04e0 = string;
        this.\u0465 = list;
        this.\u04ae = n;
        this.\u042a = string2;
        this.X = string3;
    }

    public boolean \u04cf() {
        boolean bl;
        block4: {
            block5: {
                int n = oc75d51ec7eb.\u03e9;
                bl = this.\u0465.size();
                if (n != 0) break block4;
                if (bl > true) break block5;
                bl = true;
                break block4;
            }
            bl = false;
        }
        return bl;
    }

    public String \u0493() {
        return this.\u042a + " (" + this.\u0465.size() + ")";
    }

    public String \u014b() {
        return this.\u042a;
    }

    public String \u0417() {
        return this.X;
    }

    public ItemStack \u0189() {
        int n = (int)(System.currentTimeMillis() / (0x8DF1181F803C9739L ^ 0x8DF1181F803C94D1L) % (long)this.\u0465.size());
        return this.\u0465.get(n).\u020b();
    }
}


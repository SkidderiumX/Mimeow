/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import x.oc06c9105cec;
import x.oc2922be51da;
import x.oca75e2afde8;
import x.ocd5cc9ffddf;

public class oc47ba9d5fd2
implements oca75e2afde8 {
    final InventoryPlayer val$player;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    oc47ba9d5fd2(InventoryPlayer inventoryPlayer) {
        this.val$player = inventoryPlayer;
    }

    @Override
    public int z$u0i97vtlfwrv() {
        return this.val$player.currentItem;
    }

    @Override
    public void z$f8yzt7edcdjd(int n) {
        this.val$player.currentItem = n;
    }

    private ItemStack \u0414(int n) {
        return this.val$player.getStackInSlot(n);
    }

    @Override
    public boolean z$39wouso4y16is(int n) {
        boolean bl = this.\u0414(n) != null;
        return bl;
    }

    @Override
    public boolean z$1nwt8p8bpa19d(int n) {
        boolean bl;
        block8: {
            block7: {
                int n2;
                oc47ba9d5fd2 oc47ba9d5fd22;
                block6: {
                    boolean bl2 = ocd5cc9ffddf.\u0406;
                    oc47ba9d5fd22 = this;
                    n2 = n;
                    if (bl2) break block6;
                    if (oc47ba9d5fd22.\u0414(n2) == null) break block7;
                    oc47ba9d5fd22 = this;
                    n2 = n;
                }
                if (oc47ba9d5fd22.\u0414(n2).getItem() == null) break block7;
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }

    @Override
    public int z$1x9lvqwr1hi6a(int n) {
        return oc2922be51da.\u0446(this.\u0414(n));
    }

    @Override
    public boolean z$1lg9n53t5fysv(int n) {
        return oc06c9105cec.\u04b2(this.\u0414(n));
    }

    @Override
    public int z$dreqphaxw0s4(int n) {
        return this.\u0414((int)n).stackSize;
    }
}


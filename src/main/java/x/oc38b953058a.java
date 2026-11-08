/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.item.ItemStack;
import x.oc0a84d4d076;
import x.oc2922be51da;
import x.oc3597ecdd91;
import x.oc84f20a0bc5;

public class oc38b953058a
implements oc3597ecdd91 {
    final oc0a84d4d076 this$0;

    oc38b953058a(oc0a84d4d076 oc0a84d4d0762) {
        this.this$0 = oc0a84d4d0762;
    }

    @Override
    public boolean z$1gxqz2ykq93bd() {
        boolean bl = oc0a84d4d076.\u03e4().currentScreen != null;
        return bl;
    }

    @Override
    public boolean z$2q6lby9zs89gh() {
        return oc0a84d4d076.\u00ee().currentScreen instanceof GuiInventory;
    }

    @Override
    public boolean z$9a8hqj71hsha() {
        boolean bl = oc0a84d4d076.\u0389().thePlayer != null;
        return bl;
    }

    @Override
    public int z$q3scp0iyvlxr(int n) {
        return oc2922be51da.\u0446(oc0a84d4d076.\u0427().thePlayer.inventory.getStackInSlot(n));
    }

    @Override
    public int z$c2wc1k2mgy0i(int n) {
        int n2;
        block6: {
            ItemStack itemStack;
            block4: {
                ItemStack itemStack2;
                block5: {
                    itemStack2 = oc0a84d4d076.\u045c().thePlayer.inventory.getStackInSlot(n);
                    int n3 = oc84f20a0bc5.\u0117;
                    itemStack = itemStack2;
                    if (n3 != 0) break block4;
                    if (itemStack != null) break block5;
                    n2 = 0;
                    break block6;
                }
                itemStack = itemStack2;
            }
            n2 = itemStack.getItemDamage();
        }
        return n2;
    }

    @Override
    public void z$vua0g6kq8t86() {
        this.this$0.\u025c = true;
        oc2922be51da.\u00e8(oc0a84d4d076.\u04a1().gameSettings.keyBindInventory);
    }

    @Override
    public void z$15qcshdinzofo(int n, int n2) {
        oc2922be51da.\u0515((GuiInventory)oc0a84d4d076.\u0248().currentScreen, n, n2, 1);
    }

    @Override
    public void z$3sia07z66yj4y() {
        this.this$0.\u0129();
    }
}


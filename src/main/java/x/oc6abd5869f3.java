/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.InventoryPlayer;
import x.oc2922be51da;
import x.oc69da1aa7f5;
import x.ocd9239eeaa3;
import x.ocf5b7e839f8;

public class oc6abd5869f3
implements ocd9239eeaa3 {
    private final oc69da1aa7f5 \u0573;
    private final Minecraft \u0193 = Minecraft.getMinecraft();
    private InventoryPlayer \u040e;
    private int \u0172;
    private int \u0174;
    public static int \u00fc;

    public oc6abd5869f3(oc69da1aa7f5 oc69da1aa7f52) {
        this.\u0573 = oc69da1aa7f52;
    }

    @Override
    public boolean z$anxdtwn4g6ug() {
        return oc2922be51da.\u047c();
    }

    @Override
    public float z$3lt5um2a5hv9q() {
        return this.\u0193.thePlayer.getHealth();
    }

    @Override
    public float z$1w3lld1hkwhio() {
        return this.\u0193.thePlayer.getMaxHealth();
    }

    @Override
    public boolean z$2gfgmirh41iui() {
        return this.\u0193.thePlayer.isUsingItem();
    }

    @Override
    public int z$1lp7va4o6d80m() {
        return this.\u0193.thePlayer.inventory.currentItem;
    }

    @Override
    public int z$3e8x1kwe0a79w(int n) {
        return oc2922be51da.\u0446(this.\u0193.thePlayer.inventory.getStackInSlot(n));
    }

    @Override
    public void z$3jogde5ium8v4() {
        oc2922be51da.\u01df();
        this.\u040e = this.\u0193.thePlayer.inventory;
        this.\u0174 = this.\u0172 = this.\u040e.currentItem;
    }

    @Override
    public void z$1hx0qv2ewhl2h(int n) {
        block10: {
            Minecraft minecraft;
            block8: {
                block9: {
                    int n2 = oc2922be51da.\u0431;
                    minecraft = this.\u0193;
                    if (n2 != 0) break block8;
                    if (!minecraft.thePlayer.isUsingItem()) break block9;
                    this.\u0193.playerController.onStoppedUsingItem(this.\u0193.thePlayer);
                }
                this.\u0174 = n;
                this.\u0193.thePlayer.inventory.currentItem = n;
                minecraft = this.\u0193;
            }
            if (minecraft.thePlayer.inventory != this.\u040e || n != this.\u0172) break block10;
            this.\u040e = null;
        }
    }

    @Override
    public void z$2z3lkjwy30sx3() {
        this.\u0193.playerController.sendUseItem(this.\u0193.thePlayer, this.\u0193.theWorld, this.\u0193.thePlayer.getHeldItem());
    }

    @Override
    public void z$2vzhfzwpcsuw2() {
        oc2922be51da.\u00e8(this.\u0193.gameSettings.keyBindDrop);
    }

    @Override
    public boolean z$vy1dg17beg2m() {
        return ocf5b7e839f8.\u04e1(this.\u0573);
    }

    @Override
    public void z$2gwofgrh6v6or() {
        this.\u040e = null;
        ocf5b7e839f8.\u0130(this.\u0573);
    }

    @Override
    public void z$stl0dlcdtyh7() {
        this.\u0573.z$1ca1cmv0s357();
    }

    public void \u0244() {
        oc6abd5869f3 oc6abd5869f32;
        block8: {
            block9: {
                block10: {
                    oc6abd5869f3 oc6abd5869f33;
                    block11: {
                        int n = oc2922be51da.\u0431;
                        oc6abd5869f32 = this;
                        if (n != 0) break block8;
                        if (oc6abd5869f32.\u040e == null) break block9;
                        oc6abd5869f33 = this;
                        if (n != 0) break block10;
                        if (oc6abd5869f33.\u040e.currentItem != this.\u0174) break block11;
                        this.\u040e.currentItem = this.\u0172;
                    }
                    oc6abd5869f33 = this;
                }
                oc6abd5869f33.\u040e = null;
            }
            oc6abd5869f32 = this;
        }
        oc6abd5869f32.z$2gwofgrh6v6or();
    }
}


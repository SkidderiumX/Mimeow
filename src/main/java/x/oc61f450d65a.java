/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import x.oc67945d613a;
import x.oc75d51ec7eb;
import x.ocbd3640d420;

public class oc61f450d65a
implements oc67945d613a {
    private ItemStack \u04c6;
    final EntityPlayer val$player;
    final ocbd3640d420 this$0;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    oc61f450d65a(ocbd3640d420 ocbd3640d4202, EntityPlayer entityPlayer) {
        this.this$0 = ocbd3640d4202;
        this.val$player = entityPlayer;
    }

    @Override
    public int z$2q582f3onryq8() {
        int n;
        block6: {
            oc61f450d65a oc61f450d65a2;
            block4: {
                block5: {
                    int n2 = oc75d51ec7eb.\u03e9;
                    oc61f450d65a2 = this;
                    if (n2 != 0) break block4;
                    oc61f450d65a2.\u04c6 = this.val$player.inventory.getStackInSlot(this.val$player.inventory.currentItem);
                    if (this.\u04c6 != null) break block5;
                    n = 0;
                    break block6;
                }
                oc61f450d65a2 = this;
            }
            n = ocbd3640d420.\u041d(oc61f450d65a2.\u04c6);
        }
        return n;
    }

    @Override
    public boolean z$o9rmcwuma2iz(int n) {
        boolean bl;
        block16: {
            block18: {
                block17: {
                    oc61f450d65a oc61f450d65a2;
                    int n2;
                    block14: {
                        block15: {
                            n2 = oc75d51ec7eb.\u03e9;
                            oc61f450d65a2 = this;
                            if (n2 != 0) break block14;
                            if (oc61f450d65a2.\u04c6 != null) break block15;
                            bl = this.this$0.\u04e2("fist");
                            break block16;
                        }
                        oc61f450d65a2 = this;
                    }
                    bl = oc61f450d65a2.this$0.\u010d(this.val$player.inventory.currentItem);
                    if (n2 != 0) break block16;
                    if (bl) break block17;
                    bl = this.this$0.u(n);
                    if (n2 != 0) break block16;
                    if (bl) break block17;
                    bl = this.this$0.\u0573(this.\u04c6.getItem());
                    if (n2 != 0) break block16;
                    if (!bl) break block18;
                }
                bl = true;
                break block16;
            }
            bl = false;
        }
        return bl;
    }
}


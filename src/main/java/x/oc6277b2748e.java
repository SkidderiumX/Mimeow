/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiSlot;
import x.oc804fdd8d75;
import x.ocd6bc26d10b;
import x.ocf130f74f2a;
import x.ocfc2b827e17;

public class oc6277b2748e
extends GuiSlot {
    final ocfc2b827e17 this$0;

    public oc6277b2748e(ocfc2b827e17 ocfc2b827e172, Minecraft minecraft) {
        this.this$0 = ocfc2b827e172;
        super(minecraft, ocfc2b827e172.\u03ac, ocfc2b827e172.height, ocfc2b827e172.\u0103, ocfc2b827e172.\u0285, 0x149FF7DE ^ 0x149FF7C2);
        this.setSlotXBoundsFromLeft(ocfc2b827e172.\u0136);
    }

    @Override
    protected int getSize() {
        return ocd6bc26d10b.\u0293.size();
    }

    @Override
    protected boolean isSelected(int n) {
        int n2;
        block4: {
            block5: {
                boolean bl = ocf130f74f2a.\u02a1;
                n2 = n;
                if (bl) break block4;
                if (n2 != this.this$0.\u037a) break block5;
                n2 = 1;
                break block4;
            }
            n2 = 0;
        }
        return n2 != 0;
    }

    @Override
    protected int getScrollBarX() {
        return this.this$0.\u0136 + this.this$0.\u03ac - (0xF4723E26 ^ 0xF4723E20);
    }

    @Override
    public int getListWidth() {
        return Math.max(0x63AD90B3 ^ 0x63AD90A7, this.this$0.\u03ac - (0x63AD90AD ^ 0x63AD90A7));
    }

    @Override
    protected int getContentHeight() {
        return ocd6bc26d10b.\u0293.size() * (0xF3D1CCAC ^ 0xF3D1CCB0);
    }

    @Override
    protected void elementClicked(int n, boolean bl, int n2, int n3) {
        block5: {
            oc6277b2748e oc6277b2748e2;
            block4: {
                boolean bl2 = ocf130f74f2a.\u02a1;
                oc6277b2748e2 = this;
                if (bl2) break block4;
                oc6277b2748e2.this$0.\u037a = n;
                this.this$0.updateScreen();
                if (!bl) break block5;
                oc6277b2748e2 = this;
            }
            oc6277b2748e2.this$0.actionPerformed(this.this$0.\u0467);
        }
    }

    @Override
    protected void drawBackground() {
        this.this$0.drawDefaultBackground();
    }

    @Override
    protected void drawSlot(int n, int n2, int n3, int n4, int n5, int n6) {
        int n7;
        int n8;
        int n9;
        int n10;
        int n11;
        int n12;
        oc804fdd8d75 oc804fdd8d752;
        FontRenderer fontRenderer;
        block4: {
            block5: {
                fontRenderer = ocfc2b827e17.\u020d(this.this$0);
                oc804fdd8d752 = ocd6bc26d10b.\u0293.get(n);
                n12 = this.getListWidth() - (0xB84A9748 ^ 0xB84A974C);
                boolean bl = ocf130f74f2a.\u02a1;
                n11 = n2;
                n10 = n3;
                n9 = n2 + n12;
                n8 = n3;
                n7 = 0xB84A9754 ^ 0xB84A974C;
                if (bl) break block4;
                n8 = n8 + n7;
                if (n != this.this$0.\u037a) break block5;
                n7 = 0x325CD316 ^ 0xB84A974C;
                break block4;
            }
            n7 = 0xCA4A974C ^ 0xB84A974C;
        }
        Gui.drawRect(n11, n10, n9, n8, n7);
        this.this$0.\u01ca(fontRenderer, "Account: ", this.this$0.\u01f3(oc804fdd8d752), n2 + (0xB84A9748 ^ 0xB84A974C), n3 + (0xB84A974F ^ 0xB84A974C), n12 - (0xB84A9744 ^ 0xB84A974C));
        this.this$0.\u01ca(fontRenderer, "Type: ", this.this$0.\u047c(oc804fdd8d752), n2 + (0xB84A9748 ^ 0xB84A974C), n3 + (0xB84A9742 ^ 0xB84A974C), n12 - (0xB84A9744 ^ 0xB84A974C));
    }
}


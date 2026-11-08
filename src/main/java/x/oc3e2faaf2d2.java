/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlot;
import x.oc4882bbe420;
import x.oc54714bd439;
import x.ocf130f74f2a;

public class oc3e2faaf2d2
extends GuiSlot {
    final oc4882bbe420 this$0;

    public oc3e2faaf2d2(oc4882bbe420 oc4882bbe4202, Minecraft minecraft) {
        this.this$0 = oc4882bbe4202;
        super(minecraft, oc4882bbe4202.width, oc4882bbe4202.height, 0x57304D29 ^ 0x57304D01, oc4882bbe4202.height - (0x57304D29 ^ 0x57304D01), 0x57304D13 ^ 0x57304D01);
    }

    @Override
    protected int getSize() {
        return this.this$0.\u04b0.size();
    }

    @Override
    protected void elementClicked(int n, boolean n2, int n3, int n4) {
        block8: {
            int n5;
            block9: {
                boolean bl;
                block7: {
                    bl = ocf130f74f2a.\u02a1;
                    n5 = n2;
                    if (bl) break block7;
                    if (n5 == 0) break block8;
                    n5 = n;
                }
                if (bl) break block9;
                if (n5 < 0) break block8;
                n5 = n;
            }
            if (n5 < this.this$0.\u04b0.size()) {
                GuiScreen.setClipboardString(this.this$0.\u04b0.get(n));
            }
        }
    }

    @Override
    protected boolean isSelected(int n) {
        return false;
    }

    @Override
    protected void drawBackground() {
        this.this$0.drawDefaultBackground();
    }

    @Override
    public int getListWidth() {
        return Math.min(this.width - (0xDC84CCE2 ^ 0xDC84CCCA), 0xDC84CDE6 ^ 0xDC84CCCA);
    }

    @Override
    protected int getScrollBarX() {
        return (this.width + this.getListWidth()) / (0x9BADD327 ^ 0x9BADD325) + (0x9BADD327 ^ 0x9BADD325);
    }

    @Override
    protected void drawSlot(int n, int n2, int n3, int n4, int n5, int n6) {
        if (n >= this.this$0.\u04b0.size()) {
            return;
        }
        String string = this.this$0.\u04b0.get(n);
        Object[] objectArray = new Object[0x7F21738D ^ 0x7F21738F];
        objectArray[0] = n + 1;
        objectArray[1] = string;
        this.this$0.drawString(oc4882bbe420.\u017d(this.this$0), oc54714bd439.\u01e4(String.format("&8%d. &b%s&r", objectArray)), n2 + (0x7F21738D ^ 0x7F21738F), n3 + (0x7F21738D ^ 0x7F21738F), -1);
    }
}


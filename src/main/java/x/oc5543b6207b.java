/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiSlot;
import x.oc2aee63e2ea;
import x.oc54714bd439;
import x.ocf130f74f2a;
import x.ocffb73a9392;

public class oc5543b6207b
extends GuiSlot {
    final oc2aee63e2ea this$0;

    public oc5543b6207b(oc2aee63e2ea oc2aee63e2ea2, Minecraft minecraft) {
        this.this$0 = oc2aee63e2ea2;
        super(minecraft, oc2aee63e2ea2.width, oc2aee63e2ea2.height, 0x6C0094 ^ 0x6C00A8, oc2aee63e2ea2.height - (0x6C00E2 ^ 0x6C00A8), 0x6C00BE ^ 0x6C00A8);
    }

    @Override
    protected int getSize() {
        return this.this$0.\u01e5.size();
    }

    @Override
    protected boolean isSelected(int n) {
        int n2;
        block4: {
            block5: {
                boolean bl = ocf130f74f2a.\u02a1;
                n2 = n;
                if (bl) break block4;
                if (n2 != this.this$0.\u0236) break block5;
                n2 = 1;
                break block4;
            }
            n2 = 0;
        }
        return n2 != 0;
    }

    @Override
    protected int getScrollBarX() {
        return (this.width + this.getListWidth()) / (0xDDE33E98 ^ 0xDDE33E9A) + (0xDDE33E98 ^ 0xDDE33E9A);
    }

    @Override
    public int getListWidth() {
        return Math.min(this.width - (0xE8FEA08F ^ 0xE8FEA0A7), 0xE8FEA1CF ^ 0xE8FEA0A7);
    }

    @Override
    protected int getContentHeight() {
        return this.this$0.\u01e5.size() * (0xA8386AD ^ 0xA8386BB);
    }

    @Override
    protected void elementClicked(int n, boolean bl, int n2, int n3) {
        this.this$0.\u0236 = n;
    }

    @Override
    protected void drawBackground() {
        this.this$0.drawDefaultBackground();
    }

    @Override
    protected void drawSlot(int n, int n2, int n3, int n4, int n5, int n6) {
        int n7;
        ocffb73a9392 ocffb73a93922;
        FontRenderer fontRenderer;
        block6: {
            block7: {
                boolean bl = ocf130f74f2a.\u02a1;
                if (n >= this.this$0.\u01e5.size()) {
                    return;
                }
                fontRenderer = oc2aee63e2ea.\u00fd(this.this$0);
                ocffb73a93922 = this.this$0.\u01e5.get(n);
                Object object = "";
                if (!ocffb73a93922.\u01df.isEmpty()) {
                    object = " &8[&7" + String.join((CharSequence)", ", ocffb73a93922.\u01df) + "&8]";
                }
                Object[] objectArray = new Object[0xFADA0507 ^ 0xFADA0505];
                objectArray[0] = ocffb73a93922.\u0472;
                objectArray[1] = object;
                String string = oc54714bd439.\u01e4(String.format("&f%s%s&r", objectArray));
                this.this$0.drawString(fontRenderer, string, n2 + (0xFADA0507 ^ 0xFADA0505), n3 + (0xFADA0507 ^ 0xFADA0505), -1);
                n7 = ocffb73a93922.\u0122;
                if (bl) break block6;
                if (n7 <= 0) break block7;
                n7 = 0xFA25FA50 ^ 0xFADA0505;
                break block6;
            }
            n7 = 0xFA255050 ^ 0xFADA0505;
        }
        int n8 = n7;
        String string = oc54714bd439.\u01e4(String.format("&a%.0f credits", ocffb73a93922.\u0549));
        this.this$0.drawString(fontRenderer, string, n2 + (0xFADA0507 ^ 0xFADA0505), n3 + (0xFADA0509 ^ 0xFADA0505), -1);
        String string2 = String.format("Stock: %d", ocffb73a93922.\u0122);
        int n9 = fontRenderer.getStringWidth(string2);
        fontRenderer.drawStringWithShadow(string2, n2 + this.getListWidth() - (0xFADA0500 ^ 0xFADA0505) - n9, n3 + (0xFADA0509 ^ 0xFADA0505), n8);
    }
}


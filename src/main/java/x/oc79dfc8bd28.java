/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.text.SimpleDateFormat;
import java.util.Date;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiSlot;
import x.oc2aee63e2ea;
import x.oc54714bd439;
import x.occ796112162;
import x.ocf130f74f2a;

public class oc79dfc8bd28
extends GuiSlot {
    private static final SimpleDateFormat \u03f8 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    final oc2aee63e2ea this$0;

    public oc79dfc8bd28(oc2aee63e2ea oc2aee63e2ea2, Minecraft minecraft) {
        this.this$0 = oc2aee63e2ea2;
        super(minecraft, oc2aee63e2ea2.width, oc2aee63e2ea2.height, 0xAAAE5CA3 ^ 0xAAAE5C9F, oc2aee63e2ea2.height - (0xAAAE5CD5 ^ 0xAAAE5C9F), 0xAAAE5C8B ^ 0xAAAE5C9F);
    }

    @Override
    protected int getSize() {
        return this.this$0.\u03ad.size();
    }

    @Override
    protected boolean isSelected(int n) {
        int n2;
        block4: {
            block5: {
                boolean bl = ocf130f74f2a.\u02a1;
                n2 = n;
                if (bl) break block4;
                if (n2 != this.this$0.\u028a) break block5;
                n2 = 1;
                break block4;
            }
            n2 = 0;
        }
        return n2 != 0;
    }

    @Override
    protected int getScrollBarX() {
        return (this.width + this.getListWidth()) / (0x1B1264CA ^ 0x1B1264C8) + (0x1B1264CA ^ 0x1B1264C8);
    }

    @Override
    public int getListWidth() {
        return Math.min(this.width - (0x859FF7D5 ^ 0x859FF7FD), 0x859FF695 ^ 0x859FF7FD);
    }

    @Override
    protected int getContentHeight() {
        return this.this$0.\u03ad.size() * (0xD627EC14 ^ 0xD627EC00);
    }

    @Override
    protected void elementClicked(int n, boolean n2, int n3, int n4) {
        block8: {
            int n5;
            block9: {
                boolean bl;
                block7: {
                    this.this$0.\u028a = n;
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
            if (n5 < this.this$0.\u03ad.size()) {
                this.this$0.\u01e7(this.this$0.\u03ad.get((int)n).\u0479);
            }
        }
    }

    @Override
    protected void drawBackground() {
        this.this$0.drawDefaultBackground();
    }

    @Override
    protected void drawSlot(int n, int n2, int n3, int n4, int n5, int n6) {
        if (n >= this.this$0.\u03ad.size()) {
            return;
        }
        FontRenderer fontRenderer = oc2aee63e2ea.\u053b(this.this$0);
        occ796112162 occ7961121622 = this.this$0.\u03ad.get(n);
        Object[] objectArray = new Object[0xE2F7D33C ^ 0xE2F7D33E];
        objectArray[0] = oc2aee63e2ea.\u0506(occ7961121622.\u0479, 0xE2F7D32E ^ 0xE2F7D33E);
        objectArray[1] = occ7961121622.\u01a1;
        String string = oc54714bd439.\u01e4(String.format("&f%s &8[&e%s&8]&r", objectArray));
        this.this$0.drawString(fontRenderer, string, n2 + (0xE2F7D33C ^ 0xE2F7D33E), n3 + (0xE2F7D33A ^ 0xE2F7D33E), -1);
        String string2 = oc54714bd439.\u01e4(String.format("&7%s&r", \u03f8.format(new Date(occ7961121622.\u048b))));
        int n7 = fontRenderer.getStringWidth(string2);
        this.this$0.drawString(fontRenderer, string2, n2 + this.getListWidth() - (0xE2F7D33B ^ 0xE2F7D33E) - n7, n3 + (0xE2F7D33A ^ 0xE2F7D33E), -1);
    }
}


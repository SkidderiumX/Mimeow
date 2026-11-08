/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlot;
import x.oc2aee63e2ea;
import x.oc2c3b75cd91;
import x.oc54714bd439;
import x.ocf130f74f2a;

public class ocf698ee98f9
extends GuiSlot {
    final oc2aee63e2ea this$0;

    public ocf698ee98f9(oc2aee63e2ea oc2aee63e2ea2, Minecraft minecraft) {
        this.this$0 = oc2aee63e2ea2;
        super(minecraft, oc2aee63e2ea2.width, oc2aee63e2ea2.height, 0x17AE700B ^ 0x17AE7027, oc2aee63e2ea2.height - (0x17AE701B ^ 0x17AE7027), 0x17AE7037 ^ 0x17AE7027);
    }

    @Override
    protected int getSize() {
        int n;
        block6: {
            block5: {
                ocf698ee98f9 ocf698ee98f92;
                block4: {
                    boolean bl = ocf130f74f2a.\u02a1;
                    ocf698ee98f92 = this;
                    if (bl) break block4;
                    if (ocf698ee98f92.this$0.\u0472 == null) break block5;
                    ocf698ee98f92 = this;
                }
                n = ocf698ee98f92.this$0.\u0472.\u04b1.size();
                break block6;
            }
            n = 0;
        }
        return n;
    }

    @Override
    protected boolean isSelected(int n) {
        return this.this$0.\u0132.contains(n);
    }

    @Override
    protected int getScrollBarX() {
        return (this.width + this.getListWidth()) / (0xFC009638 ^ 0xFC00963A) + (0xFC009638 ^ 0xFC00963A);
    }

    @Override
    public int getListWidth() {
        return Math.min(this.width - (0x9E3DF49E ^ 0x9E3DF4B6), 0x9E3DF526 ^ 0x9E3DF4B6);
    }

    @Override
    protected int getContentHeight() {
        return this.getSize() * (0x732B4E55 ^ 0x732B4E45);
    }

    @Override
    protected void elementClicked(int n, boolean bl, int n2, int n3) {
        block9: {
            int n4;
            block10: {
                boolean bl2 = ocf130f74f2a.\u02a1;
                if (!bl || this.this$0.\u0472 == null) break block9;
                n4 = n;
                if (bl2) break block10;
                if (n4 < 0) break block9;
                n4 = n;
            }
            if (n4 < this.this$0.\u0472.\u04b1.size()) {
                GuiScreen.setClipboardString(this.this$0.\u0472.\u04b1.get((int)n).\u020e);
                this.this$0.\u00fe = "&aCopied to clipboard!&r";
            }
        }
    }

    @Override
    protected void drawBackground() {
        this.this$0.drawDefaultBackground();
    }

    @Override
    protected void drawSlot(int n, int n2, int n3, int n4, int n5, int n6) {
        block6: {
            if (this.this$0.\u0472 != null && n < this.this$0.\u0472.\u04b1.size()) break block6;
            return;
        }
        FontRenderer fontRenderer = oc2aee63e2ea.\u03e3(this.this$0);
        oc2c3b75cd91 oc2c3b75cd912 = this.this$0.\u0472.\u04b1.get(n);
        boolean bl = this.this$0.\u0132.contains(n);
        String string = bl ? "&a[x]" : "&7[ ]";
        String string2 = string;
        String string3 = oc2aee63e2ea.\u0506(oc2c3b75cd912.\u020e, 0xD1B4589E ^ 0xD1B458A9);
        Object[] objectArray = new Object[0xD1B458AA ^ 0xD1B458A9];
        objectArray[0] = string2;
        objectArray[1] = n + 1;
        objectArray[0xD1B458AB ^ 0xD1B458A9] = string3;
        String string4 = oc54714bd439.\u01e4(String.format("%s &8%d. &f%s&r", objectArray));
        this.this$0.drawString(fontRenderer, string4, n2 + (0xD1B458AB ^ 0xD1B458A9), n3 + (0xD1B458AB ^ 0xD1B458A9), -1);
    }
}


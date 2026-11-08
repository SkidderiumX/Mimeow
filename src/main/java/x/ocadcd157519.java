/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.network.play.client.C09PacketHeldItemChange;
import x.occ0b63c0426;
import x.occ2ace216f9;

public class ocadcd157519 {
    private final Minecraft A = Minecraft.getMinecraft();
    public static boolean \u04dc;

    public int \u0279() {
        int n;
        block6: {
            ocadcd157519 ocadcd1575192;
            block4: {
                block5: {
                    int n2 = occ0b63c0426.\u039f;
                    ocadcd1575192 = this;
                    if (n2 != 0) break block4;
                    if (ocadcd1575192.A.thePlayer != null) break block5;
                    n = 0;
                    break block6;
                }
                ocadcd1575192 = this;
            }
            n = ocadcd1575192.A.thePlayer.inventory.currentItem;
        }
        return n;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void \u01e5(int n) {
        ocadcd157519 ocadcd1575192;
        block12: {
            int n2;
            int n3;
            block11: {
                n3 = occ0b63c0426.\u039f;
                if (this.A.thePlayer == null) return;
                n2 = n;
                if (n3 != 0) break block11;
                if (n2 < 0) return;
                n2 = n;
            }
            if (n2 > (0x61845E06 ^ 0x61845E0E)) {
                return;
            }
            ocadcd1575192 = this;
            if (n3 != 0) break block12;
            ocadcd1575192.A.thePlayer.inventory.currentItem = n;
            if (this.A.getNetHandler() == null) return;
            ocadcd1575192 = this;
        }
        ocadcd1575192.A.getNetHandler().addToSendQueue(new C09PacketHeldItemChange(n));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public occ2ace216f9 \u01a7(int n) {
        int n2;
        block6: {
            int n3 = occ0b63c0426.\u039f;
            if (this.A.thePlayer == null) return null;
            n2 = n;
            if (n3 != 0) break block6;
            if (n2 < 0) return null;
            n2 = n;
        }
        if (n2 < this.A.thePlayer.inventory.getSizeInventory()) return occ2ace216f9.\u0256(this.A.thePlayer.inventory.getStackInSlot(n));
        return null;
    }

    public int \u012d() {
        int n;
        block6: {
            Minecraft minecraft;
            block4: {
                block5: {
                    int n2 = occ0b63c0426.\u039f;
                    minecraft = this.A;
                    if (n2 != 0) break block4;
                    if (minecraft.thePlayer != null) break block5;
                    n = 0;
                    break block6;
                }
                minecraft = this.A;
            }
            n = minecraft.thePlayer.inventory.getSizeInventory();
        }
        return n;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String \u0415() {
        ocadcd157519 ocadcd1575192;
        block9: {
            block10: {
                int n;
                block8: {
                    n = occ0b63c0426.\u039f;
                    ocadcd1575192 = this;
                    if (n != 0) break block8;
                    if (ocadcd1575192.A.thePlayer == null) return "";
                    ocadcd1575192 = this;
                }
                if (n != 0) break block9;
                if (ocadcd1575192.A.thePlayer.openContainer != null) break block10;
                return "";
            }
            ocadcd1575192 = this;
        }
        String string = ocadcd1575192.A.thePlayer.openContainer.getClass().getSimpleName();
        return string;
    }

    public String \u0202() {
        return this.\u0415();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int \u019f() {
        EntityPlayerSP entityPlayerSP;
        block9: {
            block10: {
                Minecraft minecraft;
                int n;
                block8: {
                    n = occ0b63c0426.\u039f;
                    minecraft = this.A;
                    if (n != 0) break block8;
                    if (minecraft.thePlayer == null) return 0;
                    minecraft = this.A;
                }
                entityPlayerSP = minecraft.thePlayer;
                if (n != 0) break block9;
                if (entityPlayerSP.openContainer != null) break block10;
                return 0;
            }
            entityPlayerSP = this.A.thePlayer;
        }
        int n = entityPlayerSP.openContainer.inventorySlots.size();
        return n;
    }

    public void \u01f8(int n, int n2, int n3) {
        block13: {
            ocadcd157519 ocadcd1575192;
            block15: {
                int n4;
                block14: {
                    block12: {
                        n4 = occ0b63c0426.\u039f;
                        ocadcd1575192 = this;
                        if (n4 != 0) break block12;
                        if (ocadcd1575192.A.thePlayer == null) break block13;
                        ocadcd1575192 = this;
                    }
                    if (n4 != 0) break block14;
                    if (ocadcd1575192.A.playerController == null) break block13;
                    ocadcd1575192 = this;
                }
                if (n4 != 0) break block15;
                if (ocadcd1575192.A.thePlayer.openContainer == null) break block13;
                ocadcd1575192 = this;
            }
            ocadcd1575192.A.playerController.windowClick(this.A.thePlayer.openContainer.windowId, n, n2, n3, this.A.thePlayer);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public occ2ace216f9 \u02ae(int n) {
        int n2;
        block11: {
            ocadcd157519 ocadcd1575192;
            int n3;
            block10: {
                n3 = occ0b63c0426.\u039f;
                ocadcd1575192 = this;
                if (n3 != 0) break block10;
                if (ocadcd1575192.A.thePlayer == null) return null;
                ocadcd1575192 = this;
            }
            if (ocadcd1575192.A.thePlayer.openContainer == null) return null;
            n2 = n;
            if (n3 != 0) break block11;
            if (n2 < 0) return null;
            n2 = n;
        }
        if (n2 < this.A.thePlayer.openContainer.inventorySlots.size()) return occ2ace216f9.\u0256(this.A.thePlayer.openContainer.inventorySlots.get(n).getStack());
        return null;
    }

    public occ2ace216f9 \u0455(int n) {
        return this.\u02ae(n);
    }

    public occ2ace216f9 \u00d3() {
        return this.\u02ae(0);
    }

    public List<String> \u0444() {
        return new ArrayList<String>();
    }

    public void \u01e9() {
        block5: {
            ocadcd157519 ocadcd1575192;
            block4: {
                int n = occ0b63c0426.\u039f;
                ocadcd1575192 = this;
                if (n != 0) break block4;
                if (ocadcd1575192.A.thePlayer == null) break block5;
                ocadcd1575192 = this;
            }
            ocadcd1575192.A.displayGuiScreen(new GuiInventory(this.A.thePlayer));
        }
    }
}


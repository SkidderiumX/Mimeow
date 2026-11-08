/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.packet.serverbound;

import keystrokesmod.script.model.ItemStack;
import keystrokesmod.script.packet.serverbound.CPacket;
import net.minecraft.network.play.client.C0EPacketClickWindow;

public class C0E
extends CPacket {
    public int windowId;
    public int slot;
    public int button;
    public int mode;
    public short action;
    public ItemStack itemStack;

    public C0E(int n, int n2, int n3, int n4, ItemStack itemStack) {
        super(null);
        this.windowId = n;
        this.slot = n2;
        this.button = n3;
        this.mode = n4;
        this.itemStack = itemStack;
    }

    public C0E(C0EPacketClickWindow c0EPacketClickWindow) {
        super(c0EPacketClickWindow);
        this.windowId = c0EPacketClickWindow.getWindowId();
        this.slot = c0EPacketClickWindow.getSlotId();
        this.button = c0EPacketClickWindow.getUsedButton();
        this.mode = c0EPacketClickWindow.getMode();
        this.action = c0EPacketClickWindow.getActionNumber();
        this.itemStack = new ItemStack(c0EPacketClickWindow.getClickedItem(), 0);
    }

    @Override
    public C0EPacketClickWindow convert() {
        return new C0EPacketClickWindow(this.windowId, this.slot, this.button, this.mode, this.itemStack.itemStack, this.action);
    }
}


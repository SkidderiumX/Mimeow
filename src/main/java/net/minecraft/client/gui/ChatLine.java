/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import net.minecraft.util.IChatComponent;

public class ChatLine {
    private final int updateCounterCreated;
    private final IChatComponent lineString;
    private final int chatLineID;

    public ChatLine(int n, IChatComponent iChatComponent, int n2) {
        this.lineString = iChatComponent;
        this.updateCounterCreated = n;
        this.chatLineID = n2;
    }

    public IChatComponent getChatComponent() {
        return this.lineString;
    }

    public int getUpdatedCounter() {
        return this.updateCounterCreated;
    }

    public int getChatLineID() {
        return this.chatLineID;
    }
}


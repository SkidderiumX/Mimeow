/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import net.minecraft.util.ChatComponentStyle;
import net.minecraft.util.IChatComponent;

public class ChatComponentSelector
extends ChatComponentStyle {
    private final String selector;

    public ChatComponentSelector(String string) {
        this.selector = string;
    }

    public String getSelector() {
        return this.selector;
    }

    @Override
    public String getUnformattedTextForChat() {
        return this.selector;
    }

    @Override
    public ChatComponentSelector createCopy() {
        ChatComponentSelector chatComponentSelector = new ChatComponentSelector(this.selector);
        chatComponentSelector.setChatStyle(this.getChatStyle().createShallowCopy());
        for (IChatComponent iChatComponent : this.getSiblings()) {
            chatComponentSelector.appendSibling(iChatComponent.createCopy());
        }
        return chatComponentSelector;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ChatComponentSelector)) {
            return false;
        }
        ChatComponentSelector chatComponentSelector = (ChatComponentSelector)object;
        return this.selector.equals(chatComponentSelector.selector) && super.equals(object);
    }

    @Override
    public String toString() {
        return "SelectorComponent{pattern='" + this.selector + "', siblings=" + String.valueOf(this.siblings) + ", style=" + String.valueOf(this.getChatStyle()) + "}";
    }
}


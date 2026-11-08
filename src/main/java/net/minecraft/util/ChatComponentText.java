/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import net.minecraft.util.ChatComponentStyle;
import net.minecraft.util.IChatComponent;

public class ChatComponentText
extends ChatComponentStyle {
    private final String text;

    public ChatComponentText(String string) {
        this.text = string;
    }

    public String getChatComponentText_TextValue() {
        return this.text;
    }

    @Override
    public String getUnformattedTextForChat() {
        return this.text;
    }

    @Override
    public ChatComponentText createCopy() {
        ChatComponentText chatComponentText = new ChatComponentText(this.text);
        chatComponentText.setChatStyle(this.getChatStyle().createShallowCopy());
        for (IChatComponent iChatComponent : this.getSiblings()) {
            chatComponentText.appendSibling(iChatComponent.createCopy());
        }
        return chatComponentText;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ChatComponentText)) {
            return false;
        }
        ChatComponentText chatComponentText = (ChatComponentText)object;
        return this.text.equals(chatComponentText.getChatComponentText_TextValue()) && super.equals(object);
    }

    @Override
    public String toString() {
        return "TextComponent{text='" + this.text + "', siblings=" + String.valueOf(this.siblings) + ", style=" + String.valueOf(this.getChatStyle()) + "}";
    }
}


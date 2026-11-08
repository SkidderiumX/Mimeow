/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.model;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.event.ClickEvent;
import net.minecraft.event.HoverEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.IChatComponent;
import x.oc7ab2161b9f;

public class Message {
    public ChatComponentText component;

    public Message(String string) {
        this.component = new ChatComponentText(string);
    }

    public void appendStyle(String string, String string2, String string3, String string4) {
        ChatStyle chatStyle = new ChatStyle();
        if (string.equals("HOVER")) {
            chatStyle.setChatHoverEvent(new HoverEvent(oc7ab2161b9f.\u0120(HoverEvent.Action.class, string2), new ChatComponentText(string3)));
        } else if (string.equals("CLICK")) {
            chatStyle.setChatClickEvent(new ClickEvent(oc7ab2161b9f.\u0120(ClickEvent.Action.class, string2), string3));
        }
        this.component.appendSibling(new ChatComponentText(string4).setChatStyle(chatStyle));
    }

    public void append(String string) {
        this.component.appendSibling(new ChatComponentText(string));
    }

    public List<Message> getSiblings() {
        ArrayList<Message> arrayList = new ArrayList<Message>();
        for (IChatComponent iChatComponent : this.component.getSiblings()) {
            arrayList.add(new Message(iChatComponent.getUnformattedTextForChat()));
        }
        return arrayList;
    }

    public String getStyle() {
        return this.component.getChatStyle().toString();
    }

    public String getText() {
        return this.component.getUnformattedTextForChat();
    }

    public String toString() {
        String string = String.valueOf(this.component.getChatStyle());
        String string2 = String.valueOf(this.component.getSiblings());
        String string3 = this.component.getUnformattedTextForChat();
        return "TextComponent{text='" + string3 + "', siblings=" + string2 + ", style=" + string + "}";
    }
}


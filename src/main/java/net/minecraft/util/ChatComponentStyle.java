/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import com.google.common.base.Function;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;

public abstract class ChatComponentStyle
implements IChatComponent {
    protected List<IChatComponent> siblings = Lists.newArrayList();
    private ChatStyle style;

    @Override
    public IChatComponent appendSibling(IChatComponent iChatComponent) {
        iChatComponent.getChatStyle().setParentStyle(this.getChatStyle());
        this.siblings.add(iChatComponent);
        return this;
    }

    @Override
    public List<IChatComponent> getSiblings() {
        return this.siblings;
    }

    @Override
    public IChatComponent appendText(String string) {
        return this.appendSibling(new ChatComponentText(string));
    }

    @Override
    public IChatComponent setChatStyle(ChatStyle chatStyle) {
        this.style = chatStyle;
        for (IChatComponent iChatComponent : this.siblings) {
            iChatComponent.getChatStyle().setParentStyle(this.getChatStyle());
        }
        return this;
    }

    @Override
    public ChatStyle getChatStyle() {
        if (this.style == null) {
            this.style = new ChatStyle();
            for (IChatComponent iChatComponent : this.siblings) {
                iChatComponent.getChatStyle().setParentStyle(this.style);
            }
        }
        return this.style;
    }

    @Override
    public Iterator<IChatComponent> iterator() {
        return Iterators.concat(Iterators.forArray(this), ChatComponentStyle.createDeepCopyIterator(this.siblings));
    }

    @Override
    public final String getUnformattedText() {
        StringBuilder stringBuilder = new StringBuilder();
        for (IChatComponent iChatComponent : this) {
            stringBuilder.append(iChatComponent.getUnformattedTextForChat());
        }
        return stringBuilder.toString();
    }

    @Override
    public final String getFormattedText() {
        StringBuilder stringBuilder = new StringBuilder();
        for (IChatComponent iChatComponent : this) {
            stringBuilder.append(iChatComponent.getChatStyle().getFormattingCode());
            stringBuilder.append(iChatComponent.getUnformattedTextForChat());
            stringBuilder.append((Object)EnumChatFormatting.RESET);
        }
        return stringBuilder.toString();
    }

    public static Iterator<IChatComponent> createDeepCopyIterator(Iterable<IChatComponent> iterable) {
        Iterator<IChatComponent> iterator2 = Iterators.concat(Iterators.transform(iterable.iterator(), new Function<IChatComponent, Iterator<IChatComponent>>(){

            @Override
            public Iterator<IChatComponent> apply(IChatComponent iChatComponent) {
                return iChatComponent.iterator();
            }
        }));
        iterator2 = Iterators.transform(iterator2, new Function<IChatComponent, IChatComponent>(){

            @Override
            public IChatComponent apply(IChatComponent iChatComponent) {
                IChatComponent iChatComponent2 = iChatComponent.createCopy();
                iChatComponent2.setChatStyle(iChatComponent2.getChatStyle().createDeepCopy());
                return iChatComponent2;
            }
        });
        return iterator2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ChatComponentStyle)) {
            return false;
        }
        ChatComponentStyle chatComponentStyle = (ChatComponentStyle)object;
        return this.siblings.equals(chatComponentStyle.siblings) && this.getChatStyle().equals(chatComponentStyle.getChatStyle());
    }

    public int hashCode() {
        return 31 * this.style.hashCode() + this.siblings.hashCode();
    }

    public String toString() {
        return "BaseComponent{style=" + String.valueOf(this.style) + ", siblings=" + String.valueOf(this.siblings) + "}";
    }
}


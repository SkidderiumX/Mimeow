/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import java.util.List;
import net.minecraft.command.CommandException;
import net.minecraft.command.EntityNotFoundException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerSelector;
import net.minecraft.entity.Entity;
import net.minecraft.util.ChatComponentScore;
import net.minecraft.util.ChatComponentSelector;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.IChatComponent;

public class ChatComponentProcessor {
    public static IChatComponent processComponent(ICommandSender iCommandSender, IChatComponent iChatComponent, Entity entity) throws CommandException {
        Object object;
        IChatComponent iChatComponent2 = null;
        if (iChatComponent instanceof ChatComponentScore) {
            object = (ChatComponentScore)iChatComponent;
            String string = ((ChatComponentScore)object).getName();
            if (PlayerSelector.hasArguments(string)) {
                List<Entity> object2 = PlayerSelector.matchEntities(iCommandSender, string, Entity.class);
                if (object2.size() != 1) {
                    throw new EntityNotFoundException();
                }
                string = object2.get(0).getName();
            }
            iChatComponent2 = entity != null && string.equals("*") ? new ChatComponentScore(entity.getName(), ((ChatComponentScore)object).getObjective()) : new ChatComponentScore(string, ((ChatComponentScore)object).getObjective());
            ((ChatComponentScore)iChatComponent2).setValue(((ChatComponentScore)object).getUnformattedTextForChat());
        } else if (iChatComponent instanceof ChatComponentSelector) {
            object = ((ChatComponentSelector)iChatComponent).getSelector();
            iChatComponent2 = PlayerSelector.matchEntitiesToChatComponent(iCommandSender, (String)object);
            if (iChatComponent2 == null) {
                iChatComponent2 = new ChatComponentText("");
            }
        } else if (iChatComponent instanceof ChatComponentText) {
            iChatComponent2 = new ChatComponentText(((ChatComponentText)iChatComponent).getChatComponentText_TextValue());
        } else {
            if (!(iChatComponent instanceof ChatComponentTranslation)) {
                return iChatComponent;
            }
            object = ((ChatComponentTranslation)iChatComponent).getFormatArgs();
            for (int i = 0; i < ((Object[])object).length; ++i) {
                Object object2 = object[i];
                if (!(object2 instanceof IChatComponent)) continue;
                object[i] = ChatComponentProcessor.processComponent(iCommandSender, (IChatComponent)object2, entity);
            }
            iChatComponent2 = new ChatComponentTranslation(((ChatComponentTranslation)iChatComponent).getKey(), (Object[])object);
        }
        object = iChatComponent.getChatStyle();
        if (object != null) {
            iChatComponent2.setChatStyle(((ChatStyle)object).createShallowCopy());
        }
        for (IChatComponent iChatComponent3 : iChatComponent.getSiblings()) {
            iChatComponent2.appendSibling(ChatComponentProcessor.processComponent(iCommandSender, iChatComponent3, entity));
        }
        return iChatComponent2;
    }
}


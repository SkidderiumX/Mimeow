/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import x.oc1378bc114d;

public class GuiUtilRenderComponents {
    public static String func_178909_a(String string, boolean bl) {
        return !bl && !Minecraft.getMinecraft().gameSettings.chatColours ? EnumChatFormatting.getTextWithoutFormattingCodes(string) : string;
    }

    public static List<IChatComponent> splitText(IChatComponent iChatComponent, int n, final FontRenderer fontRenderer, boolean bl, boolean bl2) {
        return GuiUtilRenderComponents.splitText(iChatComponent, n, new TextMetrics(){

            @Override
            public int width(String string) {
                return fontRenderer.getStringWidth(string);
            }

            @Override
            public String trim(String string, int n) {
                return fontRenderer.trimStringToWidth(string, n, false);
            }
        }, bl, bl2);
    }

    public static List<IChatComponent> splitText(IChatComponent iChatComponent, int n, final oc1378bc114d oc1378bc114d2, boolean bl, boolean bl2) {
        return GuiUtilRenderComponents.splitText(iChatComponent, n, new TextMetrics(){

            @Override
            public int width(String string) {
                return oc1378bc114d2.z$toz8pt08w0nc(string);
            }

            @Override
            public String trim(String string, int n) {
                return oc1378bc114d2.z$6okofawej3do(string, n);
            }
        }, bl, bl2);
    }

    private static List<IChatComponent> splitText(IChatComponent iChatComponent, int n, TextMetrics textMetrics, boolean bl, boolean bl2) {
        n = Math.max(1, n);
        int n2 = 0;
        ChatComponentText chatComponentText = new ChatComponentText("");
        ArrayList<IChatComponent> arrayList = Lists.newArrayList();
        ArrayList<IChatComponent> arrayList2 = Lists.newArrayList(iChatComponent);
        for (int i = 0; i < arrayList2.size(); ++i) {
            String string;
            String string2;
            IChatComponent iChatComponent2 = (IChatComponent)arrayList2.get(i);
            String string3 = iChatComponent2.getUnformattedTextForChat();
            boolean bl3 = false;
            if (string3.contains("\n")) {
                int n3 = string3.indexOf(10);
                string2 = string3.substring(n3 + 1);
                string3 = string3.substring(0, n3 + 1);
                ChatComponentText chatComponentText2 = new ChatComponentText(string2);
                chatComponentText2.setChatStyle(iChatComponent2.getChatStyle().createShallowCopy());
                arrayList2.add(i + 1, chatComponentText2);
                bl3 = true;
            }
            string2 = (string = GuiUtilRenderComponents.func_178909_a(iChatComponent2.getChatStyle().getFormattingCode() + string3, bl2)).endsWith("\n") ? string.substring(0, string.length() - 1) : string;
            int n4 = textMetrics.width(string2);
            ChatComponentText chatComponentText3 = new ChatComponentText(string2);
            chatComponentText3.setChatStyle(iChatComponent2.getChatStyle().createShallowCopy());
            if (n2 + n4 > n) {
                String string4;
                String string5 = textMetrics.trim(string, n - n2);
                if (n2 == 0 && textMetrics.width(string5) == 0 && string5.length() < string2.length()) {
                    int n5 = string5.length();
                    while (n5 + 1 < string2.length() && string2.charAt(n5) == '\u00a7') {
                        n5 += 2;
                    }
                    if (n5 < string2.length()) {
                        n5 += Character.charCount(string2.codePointAt(n5));
                    }
                    string5 = string2.substring(0, n5);
                }
                String string6 = string4 = string5.length() < string.length() ? string.substring(string5.length()) : null;
                if (string4 != null && string4.length() > 0) {
                    int n6 = string5.lastIndexOf(" ");
                    if (n6 >= 0 && textMetrics.width(string.substring(0, n6)) > 0) {
                        string5 = string.substring(0, n6);
                        if (bl) {
                            ++n6;
                        }
                        string4 = string.substring(n6);
                    } else if (n2 > 0 && !string.contains(" ")) {
                        string5 = "";
                        string4 = string;
                    }
                    ChatComponentText chatComponentText4 = new ChatComponentText(FontRenderer.getFormatFromString(string5) + string4);
                    chatComponentText4.setChatStyle(iChatComponent2.getChatStyle().createShallowCopy());
                    arrayList2.add(i + 1, chatComponentText4);
                }
                n4 = textMetrics.width(string5);
                chatComponentText3 = new ChatComponentText(string5);
                chatComponentText3.setChatStyle(iChatComponent2.getChatStyle().createShallowCopy());
                bl3 = true;
            }
            if (n2 + n4 <= n || n2 == 0) {
                n2 += n4;
                chatComponentText.appendSibling(chatComponentText3);
            } else {
                bl3 = true;
            }
            if (!bl3) continue;
            arrayList.add(chatComponentText);
            n2 = 0;
            chatComponentText = new ChatComponentText("");
        }
        arrayList.add(chatComponentText);
        return arrayList;
    }

    private static interface TextMetrics {
        public int width(String var1);

        public String trim(String var1, int var2);
    }
}


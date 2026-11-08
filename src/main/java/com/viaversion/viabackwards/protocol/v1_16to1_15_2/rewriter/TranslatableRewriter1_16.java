/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_16to1_15_2.rewriter;

import com.viaversion.viabackwards.api.rewriters.text.JsonNBTComponentRewriter;
import com.viaversion.viabackwards.protocol.v1_16to1_15_2.Protocol1_16To1_15_2;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.libs.gson.JsonPrimitive;
import com.viaversion.viaversion.protocols.v1_15_2to1_16.packet.ClientboundPackets1_16;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.util.ComponentUtil;
import com.viaversion.viaversion.util.SerializerVersion;

public class TranslatableRewriter1_16
extends JsonNBTComponentRewriter<ClientboundPackets1_16> {
    private static final ChatColor[] COLORS = new ChatColor[]{new ChatColor("black", 0), new ChatColor("dark_blue", 170), new ChatColor("dark_green", 43520), new ChatColor("dark_aqua", 43690), new ChatColor("dark_red", 0xAA0000), new ChatColor("dark_purple", 0xAA00AA), new ChatColor("gold", 0xFFAA00), new ChatColor("gray", 0xAAAAAA), new ChatColor("dark_gray", 0x555555), new ChatColor("blue", 0x5555FF), new ChatColor("green", 0x55FF55), new ChatColor("aqua", 0x55FFFF), new ChatColor("red", 0xFF5555), new ChatColor("light_purple", 0xFF55FF), new ChatColor("yellow", 0xFFFF55), new ChatColor("white", 0xFFFFFF)};

    public TranslatableRewriter1_16(Protocol1_16To1_15_2 protocol1_16To1_15_2) {
        super(protocol1_16To1_15_2, ComponentRewriterBase.ReadType.JSON);
    }

    @Override
    public void processText(UserConnection userConnection, JsonElement jsonElement) {
        JsonObject jsonObject;
        String string;
        Object object;
        Object object2;
        super.processText(userConnection, jsonElement);
        if (jsonElement == null || !jsonElement.isJsonObject()) {
            return;
        }
        JsonObject jsonObject2 = jsonElement.getAsJsonObject();
        JsonPrimitive jsonPrimitive = jsonObject2.getAsJsonPrimitive("color");
        if (jsonPrimitive != null && !((String)(object2 = jsonPrimitive.getAsString())).isEmpty() && ((String)object2).charAt(0) == '#') {
            int n = Integer.parseInt(((String)object2).substring(1), 16);
            object = this.getClosestChatColor(n);
            jsonObject2.addProperty("color", (String)object);
        }
        if ((object2 = jsonObject2.getAsJsonObject("clickEvent")) != null && ((JsonObject)object2).has("action") && (string = ((JsonObject)object2).get("action").getAsString()).equals("copy_to_clipboard")) {
            ((JsonObject)object2).addProperty("action", "suggest_command");
        }
        if ((jsonObject = jsonObject2.getAsJsonObject("hoverEvent")) == null || !jsonObject.has("contents")) {
            return;
        }
        object = (JsonObject)ComponentUtil.convertJson(jsonObject2, SerializerVersion.V1_16, SerializerVersion.V1_15);
        jsonObject2.add("hoverEvent", ((JsonObject)object).getAsJsonObject("hoverEvent"));
    }

    private String getClosestChatColor(int n) {
        int n2 = n >> 16 & 0xFF;
        int n3 = n >> 8 & 0xFF;
        int n4 = n & 0xFF;
        ChatColor chatColor = null;
        int n5 = 0;
        for (ChatColor chatColor2 : COLORS) {
            if (chatColor2.rgb == n) {
                return chatColor2.colorName;
            }
            int n6 = (chatColor2.r + n2) / 2;
            int n7 = chatColor2.r - n2;
            int n8 = chatColor2.g - n3;
            int n9 = chatColor2.b - n4;
            int n10 = (2 + (n6 >> 8)) * n7 * n7 + 4 * n8 * n8 + (2 + (255 - n6 >> 8)) * n9 * n9;
            if (chatColor != null && n10 >= n5) continue;
            chatColor = chatColor2;
            n5 = n10;
        }
        return chatColor.colorName;
    }

    private static final class ChatColor {
        private final String colorName;
        private final int rgb;
        private final int r;
        private final int g;
        private final int b;

        ChatColor(String string, int n) {
            this.colorName = string;
            this.rgb = n;
            this.r = n >> 16 & 0xFF;
            this.g = n >> 8 & 0xFF;
            this.b = n & 0xFF;
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.utils;

import com.viaversion.viarewind.ViaRewind;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.libs.gson.JsonParser;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.Protocol1_12_2To1_13;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.rewriter.text.JsonNBTComponentRewriter;
import com.viaversion.viaversion.util.ComponentUtil;
import java.util.logging.Level;
import java.util.regex.Pattern;

@Deprecated
public class ChatUtil {
    private static final Pattern UNUSED_COLOR_PATTERN = Pattern.compile("(?>(?>\u00a7[0-fk-or])*(\u00a7r|\\Z))|(?>(?>\u00a7[0-f])*(\u00a7[0-f]))");
    private static final JsonNBTComponentRewriter<ClientboundPacketType> LEGACY_REWRITER = new JsonNBTComponentRewriter<ClientboundPacketType>(null, ComponentRewriterBase.ReadType.JSON){

        @Override
        protected void handleTranslate(JsonObject jsonObject, String string) {
            String string2 = Protocol1_12_2To1_13.MAPPINGS.getMojangTranslation().get(string);
            if (string2 != null) {
                jsonObject.addProperty("translate", string2);
            }
        }
    };

    public static String jsonToLegacy(String string) {
        if (string == null || string.equals("null") || string.isEmpty()) {
            return "";
        }
        try {
            return ChatUtil.jsonToLegacy(JsonParser.parseString(string));
        }
        catch (Exception exception) {
            if (Via.getConfig().logTextComponentConversionErrors()) {
                ViaRewind.getPlatform().getLogger().log(Level.WARNING, "Could not convert component to legacy text: " + string, exception);
            }
            return "";
        }
    }

    public static String jsonToLegacy(JsonElement jsonElement) {
        if (jsonElement.isJsonNull() || jsonElement.isJsonArray() && jsonElement.getAsJsonArray().isEmpty() || jsonElement.isJsonObject() && jsonElement.getAsJsonObject().isEmpty()) {
            return "";
        }
        if (jsonElement.isJsonPrimitive()) {
            return jsonElement.getAsString();
        }
        try {
            LEGACY_REWRITER.processText(null, jsonElement);
            String string = ComponentUtil.jsonToLegacy(jsonElement);
            int n = 0;
            while (string.startsWith("\u00a7f") && n++ < 10) {
                string = string.substring(2);
            }
            return string;
        }
        catch (Exception exception) {
            if (Via.getConfig().logTextComponentConversionErrors()) {
                ViaRewind.getPlatform().getLogger().log(Level.WARNING, "Could not convert component to legacy text: " + String.valueOf(jsonElement), exception);
            }
            return "";
        }
    }

    public static String removeUnusedColor(String string, char c) {
        if (string == null) {
            return null;
        }
        string = UNUSED_COLOR_PATTERN.matcher(string).replaceAll("$1$2");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < string.length(); ++i) {
            char c2 = string.charAt(i);
            if (c2 != '\u00a7' || i == string.length() - 1) {
                stringBuilder.append(c2);
                continue;
            }
            if ((c2 = string.charAt(++i)) == c) continue;
            stringBuilder.append('\u00a7').append(c2);
            c = c2;
        }
        return stringBuilder.toString();
    }
}


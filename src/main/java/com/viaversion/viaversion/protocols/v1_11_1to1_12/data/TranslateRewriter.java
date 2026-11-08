/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_11_1to1_12.data;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.libs.gson.JsonArray;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.protocols.v1_11_1to1_12.data.AchievementTranslations1_12;
import com.viaversion.viaversion.protocols.v1_9_1to1_9_3.packet.ClientboundPackets1_9_3;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.rewriter.text.JsonNBTComponentRewriter;
import com.viaversion.viaversion.util.SerializerVersion;
import com.viaversion.viaversion.util.StringUtil;
import java.util.logging.Level;

public class TranslateRewriter {
    private static final JsonNBTComponentRewriter<ClientboundPackets1_9_3> ACHIEVEMENT_TEXT_REWRITER = new JsonNBTComponentRewriter<ClientboundPackets1_9_3>(null, ComponentRewriterBase.ReadType.JSON){

        @Override
        protected void handleTranslate(JsonObject jsonObject, String string) {
            String string2 = AchievementTranslations1_12.get(string);
            if (string2 != null) {
                jsonObject.addProperty("translate", string2);
            }
        }

        @Override
        protected void handleHoverEvent(UserConnection userConnection, JsonObject jsonObject) {
            String string = jsonObject.getAsJsonPrimitive("action").getAsString();
            if (!string.equals("show_achievement")) {
                super.handleHoverEvent(userConnection, jsonObject);
                return;
            }
            String string2 = SerializerVersion.V1_9.toComponent(jsonObject.get("value")).asUnformattedString();
            if (AchievementTranslations1_12.get(string2) == null) {
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("text", "Invalid statistic/achievement!");
                jsonObject2.addProperty("color", "red");
                jsonObject.addProperty("action", "show_text");
                jsonObject.add("value", jsonObject2);
                super.handleHoverEvent(userConnection, jsonObject);
                return;
            }
            try {
                JsonObject jsonObject3 = new JsonObject();
                jsonObject3.addProperty("text", "\n");
                JsonArray jsonArray = new JsonArray();
                jsonArray.add("");
                JsonObject jsonObject4 = new JsonObject();
                JsonObject jsonObject5 = new JsonObject();
                jsonArray.add(jsonObject4);
                jsonArray.add(jsonObject3);
                jsonArray.add(jsonObject5);
                if (string2.startsWith("achievement")) {
                    jsonObject4.addProperty("translate", string2);
                    jsonObject4.addProperty("color", AchievementTranslations1_12.isSpecial(string2) ? "dark_purple" : "green");
                    jsonObject5.addProperty("translate", "stats.tooltip.type.achievement");
                    JsonObject jsonObject6 = new JsonObject();
                    jsonObject5.addProperty("italic", true);
                    jsonObject6.addProperty("translate", string2 + ".desc");
                    jsonArray.add(jsonObject3);
                    jsonArray.add(jsonObject6);
                } else if (string2.startsWith("stat")) {
                    jsonObject4.addProperty("translate", string2);
                    jsonObject4.addProperty("color", "gray");
                    jsonObject5.addProperty("translate", "stats.tooltip.type.statistic");
                    jsonObject5.addProperty("italic", true);
                }
                jsonObject.addProperty("action", "show_text");
                jsonObject.add("value", jsonArray);
            }
            catch (Exception exception) {
                if (Via.getConfig().logOtherConversionWarnings()) {
                    this.protocol.getLogger().log(Level.WARNING, "Error rewriting show_achievement: " + StringUtil.forLogging(jsonObject), exception);
                }
                JsonObject jsonObject7 = new JsonObject();
                jsonObject7.addProperty("text", "Invalid statistic/achievement!");
                jsonObject7.addProperty("color", "red");
                jsonObject.addProperty("action", "show_text");
                jsonObject.add("value", jsonObject7);
            }
            super.handleHoverEvent(userConnection, jsonObject);
        }
    };

    public static void toClient(UserConnection userConnection, JsonElement jsonElement) {
        JsonObject jsonObject;
        JsonElement jsonElement2;
        if (jsonElement instanceof JsonObject && (jsonElement2 = (jsonObject = (JsonObject)jsonElement).get("translate")) != null && jsonElement2.getAsString().startsWith("chat.type.achievement")) {
            ACHIEVEMENT_TEXT_REWRITER.processText(userConnection, jsonObject);
        }
    }
}


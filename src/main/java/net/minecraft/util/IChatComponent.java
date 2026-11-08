/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import net.minecraft.util.ChatComponentScore;
import net.minecraft.util.ChatComponentSelector;
import net.minecraft.util.ChatComponentStyle;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumTypeAdapterFactory;
import net.minecraft.util.JsonUtils;

public interface IChatComponent
extends Iterable<IChatComponent> {
    public IChatComponent setChatStyle(ChatStyle var1);

    public ChatStyle getChatStyle();

    public IChatComponent appendText(String var1);

    public IChatComponent appendSibling(IChatComponent var1);

    public String getUnformattedTextForChat();

    public String getUnformattedText();

    public String getFormattedText();

    public List<IChatComponent> getSiblings();

    public IChatComponent createCopy();

    public static class Serializer
    implements JsonDeserializer<IChatComponent>,
    JsonSerializer<IChatComponent> {
        private static final Gson GSON;

        @Override
        public IChatComponent deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            Object object;
            ChatComponentStyle chatComponentStyle;
            if (jsonElement.isJsonPrimitive()) {
                return new ChatComponentText(jsonElement.getAsString());
            }
            if (!jsonElement.isJsonObject()) {
                if (jsonElement.isJsonArray()) {
                    JsonArray jsonArray = jsonElement.getAsJsonArray();
                    IChatComponent iChatComponent = null;
                    for (JsonElement jsonElement2 : jsonArray) {
                        IChatComponent iChatComponent2 = this.deserialize(jsonElement2, jsonElement2.getClass(), jsonDeserializationContext);
                        if (iChatComponent == null) {
                            iChatComponent = iChatComponent2;
                            continue;
                        }
                        iChatComponent.appendSibling(iChatComponent2);
                    }
                    return iChatComponent;
                }
                throw new JsonParseException("Don't know how to turn " + jsonElement.toString() + " into a Component");
            }
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            if (jsonObject.has("text")) {
                chatComponentStyle = new ChatComponentText(jsonObject.get("text").getAsString());
            } else if (jsonObject.has("translate")) {
                object = jsonObject.get("translate").getAsString();
                if (jsonObject.has("with")) {
                    JsonArray jsonArray = jsonObject.getAsJsonArray("with");
                    Object[] objectArray = new Object[jsonArray.size()];
                    for (int i = 0; i < objectArray.length; ++i) {
                        ChatComponentText chatComponentText;
                        objectArray[i] = this.deserialize(jsonArray.get(i), type, jsonDeserializationContext);
                        if (!(objectArray[i] instanceof ChatComponentText) || !(chatComponentText = (ChatComponentText)objectArray[i]).getChatStyle().isEmpty() || !chatComponentText.getSiblings().isEmpty()) continue;
                        objectArray[i] = chatComponentText.getChatComponentText_TextValue();
                    }
                    chatComponentStyle = new ChatComponentTranslation((String)object, objectArray);
                } else {
                    chatComponentStyle = new ChatComponentTranslation((String)object, new Object[0]);
                }
            } else if (jsonObject.has("score")) {
                object = jsonObject.getAsJsonObject("score");
                if (!((JsonObject)object).has("name") || !((JsonObject)object).has("objective")) {
                    throw new JsonParseException("A score component needs a least a name and an objective");
                }
                chatComponentStyle = new ChatComponentScore(JsonUtils.getString((JsonObject)object, "name"), JsonUtils.getString((JsonObject)object, "objective"));
                if (((JsonObject)object).has("value")) {
                    ((ChatComponentScore)chatComponentStyle).setValue(JsonUtils.getString((JsonObject)object, "value"));
                }
            } else {
                if (!jsonObject.has("selector")) {
                    throw new JsonParseException("Don't know how to turn " + jsonElement.toString() + " into a Component");
                }
                chatComponentStyle = new ChatComponentSelector(JsonUtils.getString(jsonObject, "selector"));
            }
            if (jsonObject.has("extra")) {
                object = jsonObject.getAsJsonArray("extra");
                if (((JsonArray)object).size() <= 0) {
                    throw new JsonParseException("Unexpected empty array of components");
                }
                for (int i = 0; i < ((JsonArray)object).size(); ++i) {
                    chatComponentStyle.appendSibling(this.deserialize(((JsonArray)object).get(i), type, jsonDeserializationContext));
                }
            }
            chatComponentStyle.setChatStyle((ChatStyle)jsonDeserializationContext.deserialize(jsonElement, (Type)((Object)ChatStyle.class)));
            return chatComponentStyle;
        }

        private void serializeChatStyle(ChatStyle chatStyle, JsonObject jsonObject, JsonSerializationContext jsonSerializationContext) {
            JsonElement jsonElement = jsonSerializationContext.serialize(chatStyle);
            if (jsonElement.isJsonObject()) {
                JsonObject jsonObject2 = (JsonObject)jsonElement;
                for (Map.Entry<String, JsonElement> entry : jsonObject2.entrySet()) {
                    jsonObject.add(entry.getKey(), entry.getValue());
                }
            }
        }

        @Override
        public JsonElement serialize(IChatComponent iChatComponent, Type type, JsonSerializationContext jsonSerializationContext) {
            Iterable<JsonElement> iterable;
            if (iChatComponent instanceof ChatComponentText && iChatComponent.getChatStyle().isEmpty() && iChatComponent.getSiblings().isEmpty()) {
                return new JsonPrimitive(((ChatComponentText)iChatComponent).getChatComponentText_TextValue());
            }
            JsonObject jsonObject = new JsonObject();
            if (!iChatComponent.getChatStyle().isEmpty()) {
                this.serializeChatStyle(iChatComponent.getChatStyle(), jsonObject, jsonSerializationContext);
            }
            if (!iChatComponent.getSiblings().isEmpty()) {
                iterable = new JsonArray();
                for (IChatComponent objectArray : iChatComponent.getSiblings()) {
                    ((JsonArray)iterable).add(this.serialize(objectArray, (Type)objectArray.getClass(), jsonSerializationContext));
                }
                jsonObject.add("extra", (JsonElement)((Object)iterable));
            }
            if (iChatComponent instanceof ChatComponentText) {
                jsonObject.addProperty("text", ((ChatComponentText)iChatComponent).getChatComponentText_TextValue());
            } else if (iChatComponent instanceof ChatComponentTranslation) {
                iterable = (ChatComponentTranslation)iChatComponent;
                jsonObject.addProperty("translate", ((ChatComponentTranslation)iterable).getKey());
                if (((ChatComponentTranslation)iterable).getFormatArgs() != null && ((ChatComponentTranslation)iterable).getFormatArgs().length > 0) {
                    var6_6 = new JsonArray();
                    for (Object object : ((ChatComponentTranslation)iterable).getFormatArgs()) {
                        if (object instanceof IChatComponent) {
                            ((JsonArray)var6_6).add(this.serialize((IChatComponent)object, (Type)object.getClass(), jsonSerializationContext));
                            continue;
                        }
                        ((JsonArray)var6_6).add(new JsonPrimitive(String.valueOf(object)));
                    }
                    jsonObject.add("with", (JsonElement)var6_6);
                }
            } else if (iChatComponent instanceof ChatComponentScore) {
                iterable = (ChatComponentScore)iChatComponent;
                var6_6 = new JsonObject();
                ((JsonObject)var6_6).addProperty("name", ((ChatComponentScore)iterable).getName());
                ((JsonObject)var6_6).addProperty("objective", ((ChatComponentScore)iterable).getObjective());
                ((JsonObject)var6_6).addProperty("value", ((ChatComponentScore)iterable).getUnformattedTextForChat());
                jsonObject.add("score", (JsonElement)var6_6);
            } else {
                if (!(iChatComponent instanceof ChatComponentSelector)) {
                    throw new IllegalArgumentException("Don't know how to serialize " + String.valueOf(iChatComponent) + " as a Component");
                }
                iterable = (ChatComponentSelector)iChatComponent;
                jsonObject.addProperty("selector", ((ChatComponentSelector)iterable).getSelector());
            }
            return jsonObject;
        }

        public static String componentToJson(IChatComponent iChatComponent) {
            return GSON.toJson(iChatComponent);
        }

        public static IChatComponent jsonToComponent(String string) {
            return GSON.fromJson(string, IChatComponent.class);
        }

        static {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeHierarchyAdapter(IChatComponent.class, new Serializer());
            gsonBuilder.registerTypeHierarchyAdapter(ChatStyle.class, new ChatStyle.Serializer());
            gsonBuilder.registerTypeAdapterFactory(new EnumTypeAdapterFactory());
            GSON = gsonBuilder.create();
        }
    }
}


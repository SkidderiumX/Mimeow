/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.util;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.libs.mcstructs.core.Copyable;
import com.viaversion.viaversion.libs.mcstructs.text.Style;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.StringComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.TranslationComponent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.impl.EntityHoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.impl.ItemHoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.TextComponentSerializer;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.StringFormat;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.handling.ColorHandling;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.handling.DeserializerUnknownHandling;
import com.viaversion.viaversion.libs.mcstructs.text.utils.TextUtils;
import com.viaversion.viaversion.util.SerializerVersion;
import com.viaversion.viaversion.util.StringUtil;
import com.viaversion.viaversion.util.TagUtil;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import org.checkerframework.checker.nullness.qual.Nullable;

public class ComponentUtil {
    private static final int MAX_UNSIGNED_SHORT = 65535;

    public static JsonObject emptyJsonComponent() {
        return ComponentUtil.plainToJson("");
    }

    public static String emptyJsonComponentString() {
        return "{\"text\":\"\"}";
    }

    public static JsonObject plainToJson(String string) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("text", string);
        return jsonObject;
    }

    public static @Nullable JsonElement tagToJson(@Nullable Tag tag) {
        try {
            TextComponent textComponent = SerializerVersion.V1_20_3.toComponent(tag);
            return textComponent != null ? SerializerVersion.V1_19_4.toJson(textComponent) : null;
        }
        catch (Exception exception) {
            if (Via.getConfig().logTextComponentConversionErrors()) {
                Via.getPlatform().getLogger().log(Level.SEVERE, "Error converting tag: " + StringUtil.forLogging(tag), exception);
            }
            return ComponentUtil.plainToJson("<error>");
        }
    }

    public static @Nullable Tag jsonToTag(@Nullable JsonElement jsonElement) {
        if (jsonElement == null || jsonElement.isJsonNull()) {
            return null;
        }
        try {
            TextComponent textComponent = SerializerVersion.V1_19_4.toComponent(jsonElement);
            return ComponentUtil.trimStrings(SerializerVersion.V1_20_3.toTag(textComponent));
        }
        catch (Exception exception) {
            if (Via.getConfig().logTextComponentConversionErrors()) {
                Via.getPlatform().getLogger().log(Level.SEVERE, "Error converting component: " + StringUtil.forLogging(jsonElement), exception);
            }
            return new StringTag("<error>");
        }
    }

    public static Tag trimStrings(Tag tag2) {
        if (tag2 == null) {
            return null;
        }
        return TagUtil.handleDeep(tag2, (string, tag) -> {
            StringTag stringTag;
            String string2;
            if (tag instanceof StringTag && (string2 = (stringTag = (StringTag)tag).getValue()).length() > 21845 && string2.getBytes(StandardCharsets.UTF_8).length > 65535) {
                stringTag.setValue("{}");
            }
            return tag;
        });
    }

    public static @Nullable String tagToJsonString(@Nullable Tag tag) {
        try {
            TextComponent textComponent = SerializerVersion.V1_20_5.toComponent(tag);
            return textComponent != null ? SerializerVersion.V1_20_3.toString(textComponent) : null;
        }
        catch (Exception exception) {
            if (Via.getConfig().logTextComponentConversionErrors()) {
                Via.getPlatform().getLogger().log(Level.SEVERE, "Error converting tag: " + StringUtil.forLogging(tag), exception);
            }
            return ComponentUtil.plainToJson("<error>").toString();
        }
    }

    public static @Nullable Tag jsonStringToTag(@Nullable String string) {
        return ComponentUtil.jsonStringToTag(string, SerializerVersion.V1_20_3, SerializerVersion.V1_20_5);
    }

    public static @Nullable Tag jsonStringToTag(@Nullable String string, SerializerVersion serializerVersion, SerializerVersion serializerVersion2) {
        if (string == null) {
            return null;
        }
        return serializerVersion2.toTag(serializerVersion.jsonSerializer.deserialize(string));
    }

    public static @Nullable JsonElement convertJson(@Nullable JsonElement jsonElement, SerializerVersion serializerVersion, SerializerVersion serializerVersion2) {
        return jsonElement != null ? ComponentUtil.convert(serializerVersion, serializerVersion2, serializerVersion.toComponent(jsonElement)) : null;
    }

    public static @Nullable JsonElement convertJson(@Nullable String string, SerializerVersion serializerVersion, SerializerVersion serializerVersion2) {
        return string != null ? ComponentUtil.convert(serializerVersion, serializerVersion2, serializerVersion.toComponent(string)) : null;
    }

    public static @Nullable JsonElement convertJsonOrEmpty(@Nullable String string, SerializerVersion serializerVersion, SerializerVersion serializerVersion2) {
        TextComponent textComponent = serializerVersion.toComponent(string);
        if (textComponent == null) {
            return ComponentUtil.emptyJsonComponent();
        }
        return serializerVersion2.toJson(textComponent);
    }

    private static JsonElement convert(SerializerVersion serializerVersion, SerializerVersion serializerVersion2, TextComponent textComponent2) {
        if (serializerVersion.ordinal() >= SerializerVersion.V1_16.ordinal() && serializerVersion2.ordinal() < SerializerVersion.V1_16.ordinal()) {
            textComponent2.forEach(textComponent -> ComponentUtil.convertHoverToLegacy(serializerVersion2, textComponent));
        }
        return serializerVersion2.toJson(textComponent2);
    }

    private static void convertHoverToLegacy(SerializerVersion serializerVersion, TextComponent textComponent) {
        ItemHoverEvent itemHoverEvent;
        EntityHoverEvent entityHoverEvent;
        Object object;
        Object object2;
        Object object3;
        Copyable<TextComponent> copyable;
        if (textComponent instanceof TranslationComponent) {
            copyable = (TranslationComponent)textComponent;
            object3 = ((TranslationComponent)copyable).getArgs();
            int n = ((Object[])object3).length;
            for (int i = 0; i < n; ++i) {
                object2 = object3[i];
                if (!(object2 instanceof TextComponent)) continue;
                object = (TextComponent)object2;
                ComponentUtil.convertHoverToLegacy(serializerVersion, (TextComponent)object);
            }
        }
        if ((object3 = ((Style)(copyable = textComponent.getStyle())).getHoverEvent()) instanceof EntityHoverEvent && (entityHoverEvent = (EntityHoverEvent)object3).isModern()) {
            object2 = entityHoverEvent.asModern();
            object = new CompoundTag();
            ((CompoundTag)object).putString("type", ((EntityHoverEvent.ModernHolder)object2).getType().get());
            ((CompoundTag)object).putString("id", ((EntityHoverEvent.ModernHolder)object2).getUuid().toString());
            ((CompoundTag)object).putString("name", serializerVersion.toString(((EntityHoverEvent.ModernHolder)object2).getName() != null ? ((EntityHoverEvent.ModernHolder)object2).getName() : new StringComponent("")));
            entityHoverEvent.setLegacyData(new StringComponent(serializerVersion.toSNBT((Tag)object)));
        } else if (object3 instanceof ItemHoverEvent && (itemHoverEvent = (ItemHoverEvent)object3).isModern()) {
            object2 = itemHoverEvent.asModern();
            object = new CompoundTag();
            ((CompoundTag)object).putString("id", ((ItemHoverEvent.ModernHolder)object2).getId().get());
            ((CompoundTag)object).putByte("Count", (byte)((ItemHoverEvent.ModernHolder)object2).getCount());
            if (((ItemHoverEvent.ModernHolder)object2).getTag() != null) {
                ((CompoundTag)object).put("tag", ((ItemHoverEvent.ModernHolder)object2).getTag());
            }
            itemHoverEvent.setLegacyData(serializerVersion.toSNBT((Tag)object));
        }
    }

    public static JsonElement legacyToJson(String string) {
        return SerializerVersion.V1_12.toJson(StringFormat.vanilla().fromString(string, ColorHandling.RESET, DeserializerUnknownHandling.WHITE));
    }

    public static String legacyToJsonString(String string) {
        return ComponentUtil.legacyToJsonString(string, false);
    }

    public static String legacyToJsonString(String string, boolean bl) {
        TextComponent textComponent2 = StringFormat.vanilla().fromString(string, ColorHandling.RESET, DeserializerUnknownHandling.WHITE);
        if (bl) {
            TextUtils.iterateAll(textComponent2, textComponent -> {
                if (!textComponent.getStyle().isEmpty()) {
                    textComponent.setParentStyle(new Style().setItalic(false));
                }
            });
        }
        return SerializerVersion.V1_12.toString(textComponent2);
    }

    public static String jsonToLegacy(String string) {
        return TextComponentSerializer.V1_12.deserializeReader(string).asLegacyFormatString();
    }

    public static String jsonToLegacy(JsonElement jsonElement) {
        return SerializerVersion.V1_12.toComponent(jsonElement).asLegacyFormatString();
    }

    public static CompoundTag deserializeLegacyShowItem(JsonElement jsonElement, SerializerVersion serializerVersion) {
        return (CompoundTag)serializerVersion.toTag(serializerVersion.toComponent(jsonElement).asUnformattedString());
    }

    public static CompoundTag deserializeShowItem(Tag tag, SerializerVersion serializerVersion) {
        return (CompoundTag)serializerVersion.toTag(serializerVersion.toComponent(tag).asUnformattedString());
    }
}


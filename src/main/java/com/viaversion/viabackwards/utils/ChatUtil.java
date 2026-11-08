/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.utils;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.libs.mcstructs.text.Style;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.TextFormatting;
import com.viaversion.viaversion.libs.mcstructs.text.components.TranslationComponent;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.StringFormat;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.handling.ColorHandling;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.handling.DeserializerUnknownHandling;
import com.viaversion.viaversion.libs.mcstructs.text.utils.TextUtils;
import com.viaversion.viaversion.util.SerializerVersion;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import java.util.regex.Pattern;

public class ChatUtil {
    private static final Pattern UNUSED_COLOR_PATTERN = Pattern.compile("(?>(?>\u00a7[0-fk-or])*(\u00a7r|\\Z))|(?>(?>\u00a7[0-f])*(\u00a7[0-f]))");
    private static final Pattern UNUSED_COLOR_PATTERN_PREFIX = Pattern.compile("(?>(?>\u00a7[0-fk-or])*(\u00a7r))|(?>(?>\u00a7[0-f])*(\u00a7[0-f]))");

    public static Tag translate(String string, Tag ... tagArray) {
        TranslationComponent translationComponent = new TranslationComponent(string, Arrays.stream(tagArray).map(SerializerVersion.V1_21_6::toComponent).toArray());
        return SerializerVersion.V1_21_6.toTag(translationComponent);
    }

    public static Tag translate(String string, Object ... objectArray) {
        TranslationComponent translationComponent = new TranslationComponent(string, objectArray);
        return SerializerVersion.V1_21_6.toTag(translationComponent);
    }

    public static Tag[] split(Tag tag, String string) {
        TextComponent textComponent = SerializerVersion.V1_21_6.toComponent(tag);
        return (Tag[])Arrays.stream(TextUtils.split(textComponent, string, false)).map(SerializerVersion.V1_21_6::toTag).toArray(Tag[]::new);
    }

    public static Tag fixStyle(Tag tag) {
        TextComponent textComponent = SerializerVersion.V1_21_6.toComponent(tag);
        if (textComponent.getStyle().getColor() == null) {
            textComponent.getStyle().setFormatting(TextFormatting.WHITE);
        }
        textComponent.getStyle().setItalic(false);
        return SerializerVersion.V1_21_6.toTag(textComponent);
    }

    public static CompoundTag translate(String string) {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putString("translate", string);
        compoundTag.putString("color", "white");
        compoundTag.putBoolean("italic", false);
        return compoundTag;
    }

    public static String removeUnusedColor(String string, char c) {
        return ChatUtil.removeUnusedColor(string, c, false);
    }

    public static String legacyToJsonString(String string, String string2, boolean bl) {
        return ChatUtil.legacyToJsonString(string, (TextComponent textComponent) -> {
            textComponent.append(" ");
            textComponent.append((TextComponent)new TranslationComponent(string2, new Object[0]));
        }, bl);
    }

    public static String legacyToJsonString(String string, Consumer<TextComponent> consumer, boolean bl) {
        TextComponent textComponent = StringFormat.vanilla().fromString(string, ColorHandling.RESET, DeserializerUnknownHandling.WHITE);
        consumer.accept(textComponent);
        if (bl) {
            textComponent.setParentStyle(new Style().setItalic(false));
        }
        return SerializerVersion.V1_12.toString(textComponent);
    }

    public static String fromLegacy(String string, char c, int n) {
        return ChatUtil.fromLegacy(string, c, n, false);
    }

    public static String fromLegacyPrefix(String string, char c, int n) {
        return ChatUtil.fromLegacy(string, c, n, true);
    }

    public static String fromLegacy(String string, char c, int n, boolean bl) {
        if ((string = ChatUtil.removeUnusedColor(string, c, bl)).length() > n) {
            string = string.substring(0, n);
        }
        if (string.endsWith("\u00a7")) {
            string = string.substring(0, string.length() - 1);
        }
        return string;
    }

    public static String removeUnusedColor(String string, char c, boolean bl) {
        if (string == null) {
            return null;
        }
        Pattern pattern = bl ? UNUSED_COLOR_PATTERN_PREFIX : UNUSED_COLOR_PATTERN;
        string = pattern.matcher(string).replaceAll("$1$2");
        StringBuilder stringBuilder = new StringBuilder();
        ChatFormattingState chatFormattingState = new ChatFormattingState(c);
        ChatFormattingState chatFormattingState2 = new ChatFormattingState(c);
        for (int i = 0; i < string.length(); ++i) {
            char c2 = string.charAt(i);
            if (c2 != '\u00a7' || i == string.length() - 1) {
                if (!chatFormattingState2.equals(chatFormattingState)) {
                    chatFormattingState2.appendTo(stringBuilder);
                    chatFormattingState = chatFormattingState2.copy();
                }
                stringBuilder.append(c2);
                continue;
            }
            c2 = string.charAt(++i);
            chatFormattingState2.processNextControlChar(c2);
        }
        if (bl && !chatFormattingState2.equals(chatFormattingState)) {
            chatFormattingState2.appendTo(stringBuilder);
        }
        return stringBuilder.toString();
    }

    private static class ChatFormattingState {
        private final Set<Character> formatting;
        private final char defaultColor;
        private char color;

        private ChatFormattingState(char c) {
            this(new HashSet<Character>(), c, c);
        }

        public ChatFormattingState(Set<Character> set, char c, char c2) {
            this.formatting = set;
            this.defaultColor = c;
            this.color = c2;
        }

        private void setColor(char c) {
            this.formatting.clear();
            this.color = c;
        }

        public ChatFormattingState copy() {
            return new ChatFormattingState(new HashSet<Character>(this.formatting), this.defaultColor, this.color);
        }

        public void appendTo(StringBuilder stringBuilder) {
            stringBuilder.append('\u00a7').append(this.color);
            for (Character c : this.formatting) {
                stringBuilder.append('\u00a7').append(c);
            }
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || this.getClass() != object.getClass()) {
                return false;
            }
            ChatFormattingState chatFormattingState = (ChatFormattingState)object;
            return this.defaultColor == chatFormattingState.defaultColor && this.color == chatFormattingState.color && Objects.equals(this.formatting, chatFormattingState.formatting);
        }

        public int hashCode() {
            return Objects.hash(this.formatting, Character.valueOf(this.defaultColor), Character.valueOf(this.color));
        }

        public void processNextControlChar(char c) {
            if (c == 'r') {
                this.setColor(this.defaultColor);
                return;
            }
            if (c == 'l' || c == 'm' || c == 'n' || c == 'o') {
                this.formatting.add(Character.valueOf(c));
                return;
            }
            this.setColor(c);
        }
    }
}


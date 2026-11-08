/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.serializer;

import com.viaversion.viaversion.libs.mcstructs.text.Style;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.TextFormatting;
import com.viaversion.viaversion.libs.mcstructs.text.components.StringComponent;
import java.util.function.Function;
import java.util.function.Supplier;

@Deprecated
public class LegacyStringDeserializer {
    @Deprecated
    public static TextComponent parse(String string, boolean bl) {
        return LegacyStringDeserializer.parse(string, '\u00a7', bl);
    }

    @Deprecated
    public static TextComponent parse(String string, char c2, boolean bl) {
        return LegacyStringDeserializer.parse(string, c2, c -> {
            TextFormatting textFormatting = TextFormatting.getByCode(c.charValue());
            if (textFormatting == null) {
                if (bl) {
                    return TextFormatting.WHITE;
                }
                return null;
            }
            return textFormatting;
        });
    }

    @Deprecated
    public static TextComponent parse(String string, char c, Function<Character, TextFormatting> function) {
        return LegacyStringDeserializer.parse(string, c, Style::new, function);
    }

    @Deprecated
    public static TextComponent parse(String string, char c, Supplier<Style> supplier, Function<Character, TextFormatting> function) {
        char[] cArray = string.toCharArray();
        Style style = supplier.get();
        StringBuilder stringBuilder = new StringBuilder();
        StringComponent stringComponent = new StringComponent("");
        for (int i = 0; i < cArray.length; ++i) {
            char c2 = cArray[i];
            if (c2 == c) {
                char c3;
                TextFormatting textFormatting;
                if (i + 1 >= cArray.length || (textFormatting = function.apply(Character.valueOf(c3 = cArray[++i]))) == null) continue;
                if (stringBuilder.length() != 0) {
                    stringComponent.append(new StringComponent(stringBuilder.toString()).setStyle(style.copy()));
                    stringBuilder = new StringBuilder();
                    if (textFormatting.isColor() || TextFormatting.RESET.equals(textFormatting)) {
                        style = supplier.get();
                    }
                }
                style.setFormatting(textFormatting);
                continue;
            }
            stringBuilder.append(c2);
        }
        if (stringBuilder.length() != 0) {
            stringComponent.append(new StringComponent(stringBuilder.toString()).setStyle(style));
        }
        if (stringComponent.getSiblings().size() == 1) {
            return stringComponent.getSiblings().get(0);
        }
        return stringComponent;
    }
}


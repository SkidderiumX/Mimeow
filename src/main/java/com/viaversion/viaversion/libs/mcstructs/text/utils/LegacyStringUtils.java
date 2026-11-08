/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.utils;

import com.viaversion.viaversion.libs.mcstructs.core.utils.ToString;
import com.viaversion.viaversion.libs.mcstructs.text.TextFormatting;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Deprecated
public class LegacyStringUtils {
    @Deprecated
    public static LegacyStyle getStyleAt(String string, int n, boolean bl) {
        return LegacyStringUtils.getStyleAt(string, n, c -> {
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
    public static LegacyStyle getStyleAt(String string, int n, Function<Character, TextFormatting> function) {
        char[] cArray = string.toCharArray();
        LegacyStyle legacyStyle = new LegacyStyle();
        for (int i = 0; i < Math.min(cArray.length, n); ++i) {
            char c;
            TextFormatting textFormatting;
            char c2 = cArray[i];
            if (c2 != '\u00a7' || i + 1 >= cArray.length || (textFormatting = function.apply(Character.valueOf(c = cArray[++i]))) == null) continue;
            if (TextFormatting.RESET.equals(textFormatting)) {
                legacyStyle.setColor(null);
                legacyStyle.getStyles().clear();
                continue;
            }
            if (textFormatting.isColor()) {
                legacyStyle.setColor(textFormatting);
                legacyStyle.getStyles().clear();
                continue;
            }
            legacyStyle.getStyles().add(textFormatting);
        }
        return legacyStyle;
    }

    @Deprecated
    public static String[] split(String string, String string2, boolean bl) {
        return LegacyStringUtils.split(string, string2, c -> {
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
    public static String[] split(String string, String string2, Function<Character, TextFormatting> function) {
        String[] stringArray = string.split(Pattern.quote(string2));
        for (int i = 1; i < stringArray.length; ++i) {
            String string3 = stringArray[i - 1];
            LegacyStyle legacyStyle = LegacyStringUtils.getStyleAt(string3, string3.length(), function);
            stringArray[i] = legacyStyle.toLegacy() + stringArray[i];
        }
        return stringArray;
    }

    @Deprecated
    public static class LegacyStyle {
        private TextFormatting color = null;
        private final Set<TextFormatting> styles = new HashSet<TextFormatting>();

        private LegacyStyle() {
        }

        public void setColor(@Nullable TextFormatting textFormatting) {
            this.color = textFormatting;
        }

        @Nullable
        public TextFormatting getColor() {
            return this.color;
        }

        @Nonnull
        public Set<TextFormatting> getStyles() {
            return this.styles;
        }

        public String toLegacy() {
            StringBuilder stringBuilder = new StringBuilder();
            if (this.color != null) {
                stringBuilder.append(this.color.toLegacy());
            }
            for (TextFormatting textFormatting : this.styles) {
                stringBuilder.append(textFormatting.toLegacy());
            }
            return stringBuilder.toString();
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || this.getClass() != object.getClass()) {
                return false;
            }
            LegacyStyle legacyStyle = (LegacyStyle)object;
            return Objects.equals(this.color, legacyStyle.color) && Objects.equals(this.styles, legacyStyle.styles);
        }

        public int hashCode() {
            return Objects.hash(this.color, this.styles);
        }

        public String toString() {
            return ToString.of(this).add("color", this.color).add("styles", this.styles).toString();
        }
    }
}


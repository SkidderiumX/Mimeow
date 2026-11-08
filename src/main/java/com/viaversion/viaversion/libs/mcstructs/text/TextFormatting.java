/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text;

import com.viaversion.viaversion.libs.mcstructs.core.utils.ToString;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;

public class TextFormatting {
    public static final Map<String, TextFormatting> ALL = new LinkedHashMap<String, TextFormatting>();
    public static final Map<String, TextFormatting> COLORS = new LinkedHashMap<String, TextFormatting>();
    public static final Map<String, TextFormatting> FORMATTINGS = new LinkedHashMap<String, TextFormatting>();
    public static final char COLOR_CHAR = '\u00a7';
    public static final TextFormatting BLACK = new TextFormatting("black", '0', 0);
    public static final TextFormatting DARK_BLUE = new TextFormatting("dark_blue", '1', 170);
    public static final TextFormatting DARK_GREEN = new TextFormatting("dark_green", '2', 43520);
    public static final TextFormatting DARK_AQUA = new TextFormatting("dark_aqua", '3', 43690);
    public static final TextFormatting DARK_RED = new TextFormatting("dark_red", '4', 0xAA0000);
    public static final TextFormatting DARK_PURPLE = new TextFormatting("dark_purple", '5', 0xAA00AA);
    public static final TextFormatting GOLD = new TextFormatting("gold", '6', 0xFFAA00);
    public static final TextFormatting GRAY = new TextFormatting("gray", '7', 0xAAAAAA);
    public static final TextFormatting DARK_GRAY = new TextFormatting("dark_gray", '8', 0x555555);
    public static final TextFormatting BLUE = new TextFormatting("blue", '9', 0x5555FF);
    public static final TextFormatting GREEN = new TextFormatting("green", 'a', 0x55FF55);
    public static final TextFormatting AQUA = new TextFormatting("aqua", 'b', 0x55FFFF);
    public static final TextFormatting RED = new TextFormatting("red", 'c', 0xFF5555);
    public static final TextFormatting LIGHT_PURPLE = new TextFormatting("light_purple", 'd', 0xFF55FF);
    public static final TextFormatting YELLOW = new TextFormatting("yellow", 'e', 0xFFFF55);
    public static final TextFormatting WHITE = new TextFormatting("white", 'f', 0xFFFFFF);
    public static final TextFormatting OBFUSCATED = new TextFormatting("obfuscated", 'k');
    public static final TextFormatting BOLD = new TextFormatting("bold", 'l');
    public static final TextFormatting STRIKETHROUGH = new TextFormatting("strikethrough", 'm');
    public static final TextFormatting UNDERLINE = new TextFormatting("underline", 'n');
    public static final TextFormatting ITALIC = new TextFormatting("italic", 'o');
    public static final TextFormatting RESET = new TextFormatting("reset", 'r');
    private final Type type;
    private final int ordinal;
    private final String name;
    private final char code;
    private final int rgbValue;

    @Nullable
    public static TextFormatting getByOrdinal(int n) {
        return ALL.values().stream().filter(textFormatting -> textFormatting.ordinal == n).findFirst().orElse(null);
    }

    @Nullable
    public static TextFormatting getByName(String string) {
        return ALL.get(string.toLowerCase());
    }

    @Nullable
    public static TextFormatting getByCode(char c) {
        for (TextFormatting textFormatting : ALL.values()) {
            if (textFormatting.getCode() != c) continue;
            return textFormatting;
        }
        return null;
    }

    @Nullable
    public static TextFormatting parse(String string) {
        if (!string.isEmpty() && string.charAt(0) == '#') {
            try {
                return new TextFormatting(Integer.parseInt(string.substring(1), 16));
            }
            catch (NumberFormatException numberFormatException) {
                return null;
            }
        }
        return TextFormatting.getByName(string);
    }

    public static TextFormatting getClosestFormattingColor(int n) {
        int n2 = n >> 16 & 0xFF;
        int n3 = n >> 8 & 0xFF;
        int n4 = n & 0xFF;
        TextFormatting textFormatting = null;
        int n5 = Integer.MAX_VALUE;
        for (TextFormatting textFormatting2 : COLORS.values()) {
            int n6;
            int n7;
            int n8 = textFormatting2.getRgbValue() >> 16 & 0xFF;
            int n9 = (n2 - n8) * (n2 - n8) + (n3 - (n7 = textFormatting2.getRgbValue() >> 8 & 0xFF)) * (n3 - n7) + (n4 - (n6 = textFormatting2.getRgbValue() & 0xFF)) * (n4 - n6);
            if (n9 >= n5) continue;
            textFormatting = textFormatting2;
            n5 = n9;
        }
        return textFormatting;
    }

    private TextFormatting(String string, char c, int n) {
        this.type = Type.COLOR;
        this.ordinal = ALL.size();
        this.name = string;
        this.code = c;
        this.rgbValue = n;
        ALL.put(string, this);
        COLORS.put(string, this);
    }

    private TextFormatting(String string, char c) {
        this.type = Type.FORMATTING;
        this.ordinal = ALL.size();
        this.name = string;
        this.code = c;
        this.rgbValue = -1;
        ALL.put(string, this);
        FORMATTINGS.put(string, this);
    }

    public TextFormatting(int n) {
        this.type = Type.RGB;
        this.ordinal = -1;
        this.name = "RGB_COLOR";
        this.code = '\u0000';
        this.rgbValue = n & 0xFFFFFF;
    }

    public boolean isColor() {
        return Type.COLOR.equals((Object)this.type) || Type.RGB.equals((Object)this.type);
    }

    public boolean isFormattingColor() {
        return Type.COLOR.equals((Object)this.type);
    }

    public boolean isRGBColor() {
        return Type.RGB.equals((Object)this.type);
    }

    public boolean isFormatting() {
        return Type.FORMATTING.equals((Object)this.type);
    }

    public int getOrdinal() {
        return this.ordinal;
    }

    public String getName() {
        return this.name;
    }

    public char getCode() {
        return this.code;
    }

    public int getRgbValue() {
        return this.rgbValue;
    }

    public String toLegacy() {
        return String.valueOf('\u00a7') + this.code;
    }

    public String serialize() {
        if (Type.RGB.equals((Object)this.type)) {
            StringBuilder stringBuilder = new StringBuilder(7);
            stringBuilder.append('#');
            String string = Integer.toHexString(this.rgbValue);
            for (int i = 0; i < 6 - string.length(); ++i) {
                stringBuilder.append('0');
            }
            stringBuilder.append(string);
            return stringBuilder.toString();
        }
        return this.name;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        TextFormatting textFormatting = (TextFormatting)object;
        return this.code == textFormatting.code && this.rgbValue == textFormatting.rgbValue && this.type == textFormatting.type && Objects.equals(this.name, textFormatting.name);
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.type, this.name, Character.valueOf(this.code), this.rgbValue});
    }

    public String toString() {
        return ToString.of(this).add("type", this.type).add("name", this.name, string -> !this.type.equals((Object)Type.RGB)).add("code", Character.valueOf(this.code), c -> !this.type.equals((Object)Type.RGB)).add("rgbValue", this.rgbValue, n -> this.type.equals((Object)Type.RGB), n -> String.format("#%06X", n)).toString();
    }

    private static enum Type {
        COLOR,
        FORMATTING,
        RGB;

    }
}


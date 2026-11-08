/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.stringformat.matcher;

import com.viaversion.viaversion.libs.mcstructs.text.TextFormatting;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.StringFormat;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.TextStringReader;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

public class AnsiStringFormat
extends StringFormat {
    private static final String PREFIX = "\u001b[";
    private static final String TRUE_COLOR_PREFIX = "38;2;";
    private static final String SUFFIX = "m";
    private static final Map<TextFormatting, String> FORMATTING_TO_ANSI = AnsiStringFormat.init(new HashMap(), hashMap -> {
        hashMap.put(TextFormatting.BLACK, "30");
        hashMap.put(TextFormatting.DARK_BLUE, "34");
        hashMap.put(TextFormatting.DARK_GREEN, "32");
        hashMap.put(TextFormatting.DARK_AQUA, "36");
        hashMap.put(TextFormatting.DARK_RED, "31");
        hashMap.put(TextFormatting.DARK_PURPLE, "35");
        hashMap.put(TextFormatting.GOLD, "33");
        hashMap.put(TextFormatting.GRAY, "37");
        hashMap.put(TextFormatting.DARK_GRAY, "90");
        hashMap.put(TextFormatting.BLUE, "94");
        hashMap.put(TextFormatting.GREEN, "92");
        hashMap.put(TextFormatting.AQUA, "96");
        hashMap.put(TextFormatting.RED, "91");
        hashMap.put(TextFormatting.LIGHT_PURPLE, "95");
        hashMap.put(TextFormatting.YELLOW, "93");
        hashMap.put(TextFormatting.WHITE, "97");
        hashMap.put(TextFormatting.BOLD, "1");
        hashMap.put(TextFormatting.STRIKETHROUGH, "9");
        hashMap.put(TextFormatting.UNDERLINE, "4");
        hashMap.put(TextFormatting.ITALIC, "3");
        hashMap.put(TextFormatting.RESET, "0");
    });
    private static final Map<String, TextFormatting> ANSI_TO_FORMATTING = AnsiStringFormat.init(new HashMap(), hashMap -> {
        hashMap.put("30", TextFormatting.BLACK);
        hashMap.put("34", TextFormatting.DARK_BLUE);
        hashMap.put("32", TextFormatting.DARK_GREEN);
        hashMap.put("36", TextFormatting.DARK_AQUA);
        hashMap.put("31", TextFormatting.DARK_RED);
        hashMap.put("35", TextFormatting.DARK_PURPLE);
        hashMap.put("33", TextFormatting.GOLD);
        hashMap.put("37", TextFormatting.GRAY);
        hashMap.put("90", TextFormatting.DARK_GRAY);
        hashMap.put("94", TextFormatting.BLUE);
        hashMap.put("92", TextFormatting.GREEN);
        hashMap.put("96", TextFormatting.AQUA);
        hashMap.put("91", TextFormatting.RED);
        hashMap.put("95", TextFormatting.LIGHT_PURPLE);
        hashMap.put("93", TextFormatting.YELLOW);
        hashMap.put("97", TextFormatting.WHITE);
        hashMap.put("1", TextFormatting.BOLD);
        hashMap.put("9", TextFormatting.STRIKETHROUGH);
        hashMap.put("4", TextFormatting.UNDERLINE);
        hashMap.put("3", TextFormatting.ITALIC);
        hashMap.put("0", TextFormatting.RESET);
    });
    private final boolean trueColor;

    public AnsiStringFormat(boolean bl) {
        super('\u001b');
        this.trueColor = bl;
    }

    @Override
    public boolean matches(TextStringReader textStringReader) {
        if (textStringReader.canRead(PREFIX.length()) && textStringReader.read(PREFIX.length()).equals(PREFIX)) {
            if (textStringReader.canRead(2) && ANSI_TO_FORMATTING.containsKey(textStringReader.peek(1)) && textStringReader.peekAt(1) == 'm') {
                return true;
            }
            if (textStringReader.canRead(3) && ANSI_TO_FORMATTING.containsKey(textStringReader.peek(2)) && textStringReader.peekAt(2) == 'm') {
                return true;
            }
            if (this.trueColor && textStringReader.canRead(TRUE_COLOR_PREFIX.length()) && textStringReader.peek(TRUE_COLOR_PREFIX.length()).equals(TRUE_COLOR_PREFIX)) {
                return textStringReader.readUntil('m').length() <= 11 && textStringReader.canRead() && textStringReader.peek() == 'm';
            }
        }
        return false;
    }

    @Override
    @Nullable
    public TextFormatting read(TextStringReader textStringReader) {
        textStringReader.skip(PREFIX.length());
        if (this.trueColor && textStringReader.canRead(TRUE_COLOR_PREFIX.length()) && textStringReader.peek(TRUE_COLOR_PREFIX.length()).equals(TRUE_COLOR_PREFIX)) {
            textStringReader.skip(TRUE_COLOR_PREFIX.length());
            String string = textStringReader.read(textStringReader.peekAt(1) == ';' ? 1 : 2);
            textStringReader.skip();
            String[] stringArray = string.split(";");
            if (stringArray.length != 3) {
                return null;
            }
            try {
                int n = Integer.parseInt(stringArray[0]);
                int n2 = Integer.parseInt(stringArray[1]);
                int n3 = Integer.parseInt(stringArray[2]);
                return new TextFormatting(n << 16 | n2 << 8 | n3);
            }
            catch (Throwable throwable) {
                return null;
            }
        }
        String string = textStringReader.read(textStringReader.peekAt(1) == 'm' ? 1 : 2);
        textStringReader.skip();
        return ANSI_TO_FORMATTING.get(string);
    }

    @Override
    public boolean canWrite(TextFormatting textFormatting) {
        return this.trueColor || FORMATTING_TO_ANSI.containsKey(textFormatting);
    }

    @Override
    public void write(StringBuilder stringBuilder, TextFormatting textFormatting) {
        if (textFormatting.isRGBColor()) {
            int n = textFormatting.getRgbValue() >> 16 & 0xFF;
            int n2 = textFormatting.getRgbValue() >> 8 & 0xFF;
            int n3 = textFormatting.getRgbValue() & 0xFF;
            stringBuilder.append(PREFIX).append(TRUE_COLOR_PREFIX).append(n).append(';').append(n2).append(';').append(n3).append(SUFFIX);
        } else {
            stringBuilder.append(PREFIX).append(FORMATTING_TO_ANSI.get(textFormatting)).append(SUFFIX);
        }
    }

    @Override
    public boolean shouldResetAtEnd() {
        return true;
    }
}


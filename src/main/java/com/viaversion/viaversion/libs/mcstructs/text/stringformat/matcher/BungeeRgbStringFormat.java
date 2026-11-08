/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.stringformat.matcher;

import com.viaversion.viaversion.libs.mcstructs.text.TextFormatting;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.StringFormat;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.TextStringReader;
import javax.annotation.Nullable;

public class BungeeRgbStringFormat
extends StringFormat {
    public BungeeRgbStringFormat(char c) {
        super(c);
    }

    @Override
    public boolean matches(TextStringReader textStringReader) {
        return textStringReader.canRead(14) && textStringReader.read() == this.colorChar && textStringReader.peek() == 'x';
    }

    @Override
    @Nullable
    public TextFormatting read(TextStringReader textStringReader) {
        textStringReader.skip(2);
        String string = textStringReader.skip().read(1) + textStringReader.skip().read(1) + textStringReader.skip().read(1) + textStringReader.skip().read(1) + textStringReader.skip().read(1) + textStringReader.skip().read(1);
        try {
            return new TextFormatting(Integer.parseInt(string, 16));
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    @Override
    public boolean canWrite(TextFormatting textFormatting) {
        return textFormatting.isRGBColor();
    }

    @Override
    public void write(StringBuilder stringBuilder, TextFormatting textFormatting) {
        stringBuilder.append(this.colorChar).append("x");
        String string = String.format("%06X", textFormatting.getRgbValue());
        for (int i = 0; i < string.length(); ++i) {
            stringBuilder.append(this.colorChar).append(string.charAt(i));
        }
    }
}


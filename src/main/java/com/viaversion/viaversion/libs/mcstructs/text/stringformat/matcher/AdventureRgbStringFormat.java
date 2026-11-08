/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.stringformat.matcher;

import com.viaversion.viaversion.libs.mcstructs.text.TextFormatting;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.StringFormat;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.TextStringReader;
import javax.annotation.Nullable;

public class AdventureRgbStringFormat
extends StringFormat {
    public AdventureRgbStringFormat(char c) {
        super(c);
    }

    @Override
    public boolean matches(TextStringReader textStringReader) {
        return textStringReader.canRead(8) && textStringReader.read() == this.colorChar && textStringReader.peek() == '#';
    }

    @Override
    @Nullable
    public TextFormatting read(TextStringReader textStringReader) {
        try {
            return new TextFormatting(Integer.parseInt(textStringReader.skip(2).read(6), 16));
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
        stringBuilder.append(this.colorChar).append("#").append(String.format("%06X", textFormatting.getRgbValue()));
    }
}


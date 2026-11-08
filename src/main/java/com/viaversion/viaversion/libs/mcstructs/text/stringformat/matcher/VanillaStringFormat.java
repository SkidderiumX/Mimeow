/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.stringformat.matcher;

import com.viaversion.viaversion.libs.mcstructs.text.TextFormatting;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.StringFormat;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.TextStringReader;
import javax.annotation.Nullable;

public class VanillaStringFormat
extends StringFormat {
    private final boolean downsampleRgbColors;

    public VanillaStringFormat(char c, boolean bl) {
        super(c);
        this.downsampleRgbColors = bl;
    }

    @Override
    public boolean matches(TextStringReader textStringReader) {
        return textStringReader.canRead(2) && textStringReader.read() == this.colorChar && this.getByCode(textStringReader.peek()) != null;
    }

    @Override
    @Nullable
    public TextFormatting read(TextStringReader textStringReader) {
        textStringReader.skip();
        return this.getByCode(textStringReader.read());
    }

    @Override
    public boolean canWrite(TextFormatting textFormatting) {
        if (this.downsampleRgbColors) {
            return true;
        }
        return !textFormatting.isRGBColor();
    }

    @Override
    public void write(StringBuilder stringBuilder, TextFormatting textFormatting) {
        if (this.downsampleRgbColors && textFormatting.isRGBColor()) {
            textFormatting = TextFormatting.getClosestFormattingColor(textFormatting.getRgbValue());
        }
        stringBuilder.append(this.colorChar).append(textFormatting.getCode());
    }

    @Nullable
    protected TextFormatting getByCode(char c) {
        return TextFormatting.getByCode(c);
    }
}


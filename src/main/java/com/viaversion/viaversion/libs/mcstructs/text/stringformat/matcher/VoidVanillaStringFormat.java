/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.stringformat.matcher;

import com.viaversion.viaversion.libs.mcstructs.text.TextFormatting;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.StringFormat;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.TextStringReader;
import javax.annotation.Nullable;

public class VoidVanillaStringFormat
extends StringFormat {
    public VoidVanillaStringFormat(char c) {
        super(c);
    }

    @Override
    public boolean matches(TextStringReader textStringReader) {
        return textStringReader.canRead() && textStringReader.peek() == this.colorChar;
    }

    @Override
    @Nullable
    public TextFormatting read(TextStringReader textStringReader) {
        textStringReader.skip();
        if (textStringReader.canRead()) {
            textStringReader.skip();
        }
        return null;
    }

    @Override
    public boolean canWrite(TextFormatting textFormatting) {
        return true;
    }

    @Override
    public void write(StringBuilder stringBuilder, TextFormatting textFormatting) {
    }
}


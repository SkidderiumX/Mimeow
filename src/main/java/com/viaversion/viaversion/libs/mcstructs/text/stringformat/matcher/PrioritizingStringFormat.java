/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.stringformat.matcher;

import com.viaversion.viaversion.libs.mcstructs.text.TextFormatting;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.StringFormat;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.TextStringReader;
import javax.annotation.Nullable;

public class PrioritizingStringFormat
extends StringFormat {
    private final StringFormat[] matchers;

    public PrioritizingStringFormat(StringFormat ... stringFormatArray) {
        super('\u0000');
        this.matchers = stringFormatArray;
    }

    @Override
    public boolean canRead(TextStringReader textStringReader) {
        for (StringFormat stringFormat : this.matchers) {
            if (!stringFormat.canRead(textStringReader)) continue;
            return true;
        }
        return false;
    }

    @Override
    public boolean matches(TextStringReader textStringReader) {
        textStringReader.mark();
        for (StringFormat stringFormat : this.matchers) {
            if (stringFormat.canRead(textStringReader) && stringFormat.matches(textStringReader)) {
                return true;
            }
            textStringReader.reset();
        }
        return false;
    }

    @Override
    @Nullable
    public TextFormatting read(TextStringReader textStringReader) {
        textStringReader.mark();
        for (StringFormat stringFormat : this.matchers) {
            if (stringFormat.canRead(textStringReader) && stringFormat.matches(textStringReader)) {
                textStringReader.reset();
                return stringFormat.read(textStringReader);
            }
            textStringReader.reset();
        }
        return null;
    }

    @Override
    public boolean canWrite(TextFormatting textFormatting) {
        for (StringFormat stringFormat : this.matchers) {
            if (!stringFormat.canWrite(textFormatting)) continue;
            return true;
        }
        return false;
    }

    @Override
    public void write(StringBuilder stringBuilder, TextFormatting textFormatting) {
        for (StringFormat stringFormat : this.matchers) {
            if (!stringFormat.canWrite(textFormatting)) continue;
            stringFormat.write(stringBuilder, textFormatting);
            return;
        }
    }
}


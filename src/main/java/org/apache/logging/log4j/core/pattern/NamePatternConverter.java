/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.pattern;

import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;
import org.apache.logging.log4j.core.pattern.NameAbbreviator;

public abstract class NamePatternConverter
extends LogEventPatternConverter {
    private final NameAbbreviator abbreviator;

    protected NamePatternConverter(String string, String string2, String[] stringArray) {
        super(string, string2);
        this.abbreviator = stringArray != null && stringArray.length > 0 ? NameAbbreviator.getAbbreviator(stringArray[0]) : NameAbbreviator.getDefaultAbbreviator();
    }

    protected final String abbreviate(String string) {
        return this.abbreviator.abbreviate(string);
    }
}


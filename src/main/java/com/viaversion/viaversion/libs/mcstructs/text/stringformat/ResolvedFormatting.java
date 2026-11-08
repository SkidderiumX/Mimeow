/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.stringformat;

import com.viaversion.viaversion.libs.mcstructs.text.TextFormatting;
import javax.annotation.Nullable;

public class ResolvedFormatting {
    private final String raw;
    @Nullable
    private final TextFormatting formatting;

    public ResolvedFormatting(String string, @Nullable TextFormatting textFormatting) {
        this.raw = string;
        this.formatting = textFormatting;
    }

    public String raw() {
        return this.raw;
    }

    @Nullable
    public TextFormatting get() {
        return this.formatting;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.stringformat.handling;

import com.viaversion.viaversion.libs.mcstructs.text.TextFormatting;
import com.viaversion.viaversion.libs.mcstructs.text.stringformat.ResolvedFormatting;

@FunctionalInterface
public interface DeserializerUnknownHandling {
    public static final DeserializerUnknownHandling WHITE = (resolvedFormatting, stringBuilder) -> TextFormatting.WHITE;
    public static final DeserializerUnknownHandling IGNORE = (resolvedFormatting, stringBuilder) -> null;
    public static final DeserializerUnknownHandling RESET = (resolvedFormatting, stringBuilder) -> TextFormatting.RESET;
    public static final DeserializerUnknownHandling TEXT = (resolvedFormatting, stringBuilder) -> {
        stringBuilder.append(resolvedFormatting.raw());
        return null;
    };
    public static final DeserializerUnknownHandling THROW = (resolvedFormatting, stringBuilder) -> {
        throw new IllegalArgumentException("Unknown formatting code: " + resolvedFormatting.raw());
    };

    public TextFormatting handle(ResolvedFormatting var1, StringBuilder var2);
}


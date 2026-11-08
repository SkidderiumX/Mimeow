/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.api.rewriters.text;

import com.viaversion.viaversion.api.rewriter.ComponentRewriter;
import org.checkerframework.checker.nullness.qual.Nullable;

public interface TranslatableRewriter
extends ComponentRewriter {
    public @Nullable String mappedTranslationKey(String var1);
}


/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.translation;

import com.viaversion.viaversion.libs.mcstructs.text.translation.BasicTranslator;
import javax.annotation.Nullable;

@FunctionalInterface
public interface Translator {
    public static final BasicTranslator GLOBAL = new BasicTranslator();

    @Nullable
    public String translate(String var1);

    default public String translateOrKey(String string) {
        String string2 = this.translate(string);
        return string2 != null ? string2 : string;
    }
}


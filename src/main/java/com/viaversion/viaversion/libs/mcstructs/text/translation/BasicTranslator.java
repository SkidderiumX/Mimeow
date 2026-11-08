/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.translation;

import com.viaversion.viaversion.libs.mcstructs.text.translation.Translator;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

public class BasicTranslator
implements Translator {
    private final Map<String, String> translations;

    public BasicTranslator() {
        this(new HashMap<String, String>());
    }

    public BasicTranslator(Map<String, String> map) {
        this.translations = map;
    }

    public Map<String, String> getTranslations() {
        return Collections.unmodifiableMap(this.translations);
    }

    public synchronized void addTranslation(String string, String string2) {
        this.translations.put(string, string2);
    }

    public synchronized void removeTranslation(String string) {
        this.translations.remove(string);
    }

    @Override
    @Nullable
    public String translate(String string) {
        return this.translations.get(string);
    }

    @Override
    public String translateOrKey(String string) {
        return this.translations.getOrDefault(string, string);
    }
}


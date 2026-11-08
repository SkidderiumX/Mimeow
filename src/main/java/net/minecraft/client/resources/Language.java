/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.resources;

public class Language
implements Comparable<Language> {
    private final String languageCode;
    private final String region;
    private final String name;
    private final boolean bidirectional;

    public Language(String string, String string2, String string3, boolean bl) {
        this.languageCode = string;
        this.region = string2;
        this.name = string3;
        this.bidirectional = bl;
    }

    public String getLanguageCode() {
        return this.languageCode;
    }

    public boolean isBidirectional() {
        return this.bidirectional;
    }

    public String toString() {
        return String.format("%s (%s)", this.name, this.region);
    }

    public boolean equals(Object object) {
        return this == object ? true : (!(object instanceof Language) ? false : this.languageCode.equals(((Language)object).languageCode));
    }

    public int hashCode() {
        return this.languageCode.hashCode();
    }

    @Override
    public int compareTo(Language language) {
        return this.languageCode.compareTo(language.languageCode);
    }
}


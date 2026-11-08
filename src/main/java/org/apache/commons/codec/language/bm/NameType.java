/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.codec.language.bm;

public enum NameType {
    ASHKENAZI("ash"),
    GENERIC("gen"),
    SEPHARDIC("sep");

    private final String name;

    private NameType(String string2) {
        this.name = string2;
    }

    public String getName() {
        return this.name;
    }
}


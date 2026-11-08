/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.codec.language.bm;

public enum RuleType {
    APPROX("approx"),
    EXACT("exact"),
    RULES("rules");

    private final String name;

    private RuleType(String string2) {
        this.name = string2;
    }

    public String getName() {
        return this.name;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.core;

import lombok.Generated;

public class Identifier {
    public static final String DEFAULT_NAMESPACE = "minecraft";
    public static final String VALID_KEY_CHARS = "[_\\-a-z0-9.]*";
    public static final String VALID_VALUE_CHARS = "[_\\-a-z0-9/.]*";
    private final String key;
    private final String value;

    public static Identifier defaultNamespace(String string) {
        return Identifier.of(DEFAULT_NAMESPACE, string);
    }

    public static Identifier of(String string) {
        int n = string.indexOf(58);
        String string2 = n <= 0 ? DEFAULT_NAMESPACE : string.substring(0, n);
        String string3 = n == -1 ? string : string.substring(n + 1);
        return Identifier.of(string2, string3);
    }

    public static Identifier tryOf(String string) {
        try {
            return Identifier.of(string);
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    public static Identifier of(String string, String string2) {
        return new Identifier(string, string2);
    }

    public static String stripDefaultNamespace(Identifier identifier) {
        if (identifier.getKey().equals(DEFAULT_NAMESPACE)) {
            return identifier.getValue();
        }
        return identifier.get();
    }

    private Identifier(String string, String string2) {
        if (!string.matches(VALID_KEY_CHARS)) {
            throw new IllegalArgumentException("Key contains illegal chars");
        }
        if (!string2.matches(VALID_VALUE_CHARS)) {
            throw new IllegalArgumentException("Value contains illegal chars");
        }
        this.key = string;
        this.value = string2;
    }

    public String get() {
        return this.key + ":" + this.value;
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public boolean equals(String string, String string2) {
        return this.key.equals(string) && this.value.equals(string2);
    }

    public String toString() {
        return this.get();
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Identifier)) {
            return false;
        }
        Identifier identifier = (Identifier)object;
        if (!identifier.canEqual(this)) {
            return false;
        }
        String string = this.getKey();
        String string2 = identifier.getKey();
        if (string == null ? string2 != null : !string.equals(string2)) {
            return false;
        }
        String string3 = this.getValue();
        String string4 = identifier.getValue();
        return !(string3 == null ? string4 != null : !string3.equals(string4));
    }

    @Generated
    protected boolean canEqual(Object object) {
        return object instanceof Identifier;
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        String string = this.getKey();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        String string2 = this.getValue();
        n2 = n2 * 59 + (string2 == null ? 43 : string2.hashCode());
        return n2;
    }
}


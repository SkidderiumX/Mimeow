/*
 * Decompiled with CFR 0.152.
 */
package org.slf4j.event;

import java.util.Objects;

public class KeyValuePair {
    public final String key;
    public final Object value;

    public KeyValuePair(String string, Object object) {
        this.key = string;
        this.value = object;
    }

    public String toString() {
        return String.valueOf(this.key) + "=\"" + String.valueOf(this.value) + "\"";
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        KeyValuePair keyValuePair = (KeyValuePair)object;
        return Objects.equals(this.key, keyValuePair.key) && Objects.equals(this.value, keyValuePair.value);
    }

    public int hashCode() {
        return Objects.hash(this.key, this.value);
    }
}


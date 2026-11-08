/*
 * Decompiled with CFR 0.152.
 */
package joptsimple.util;

public class KeyValuePair {
    public final String key;
    public final String value;

    private KeyValuePair(String string, String string2) {
        this.key = string;
        this.value = string2;
    }

    public static KeyValuePair valueOf(String string) {
        int n = string.indexOf(61);
        if (n == -1) {
            return new KeyValuePair(string, "");
        }
        String string2 = string.substring(0, n);
        String string3 = n == string.length() - 1 ? "" : string.substring(n + 1);
        return new KeyValuePair(string2, string3);
    }

    public boolean equals(Object object) {
        if (!(object instanceof KeyValuePair)) {
            return false;
        }
        KeyValuePair keyValuePair = (KeyValuePair)object;
        return this.key.equals(keyValuePair.key) && this.value.equals(keyValuePair.value);
    }

    public int hashCode() {
        return this.key.hashCode() ^ this.value.hashCode();
    }

    public String toString() {
        return this.key + '=' + this.value;
    }
}


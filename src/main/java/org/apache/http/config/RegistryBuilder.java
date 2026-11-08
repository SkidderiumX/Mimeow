/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.config;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.config.Registry;
import org.apache.http.util.Args;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@NotThreadSafe
public class RegistryBuilder<I> {
    private final Map<String, I> items = new HashMap<String, I>();

    public static <I> RegistryBuilder<I> create() {
        return new RegistryBuilder<I>();
    }

    RegistryBuilder() {
    }

    public RegistryBuilder<I> register(String string, I i) {
        Args.notEmpty(string, "ID");
        Args.notNull(i, "Item");
        this.items.put(string.toLowerCase(Locale.US), i);
        return this;
    }

    public Registry<I> build() {
        return new Registry<I>(this.items);
    }

    public String toString() {
        return this.items.toString();
    }
}


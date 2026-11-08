/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.httpclient.model;

import java.util.Objects;
import javax.annotation.Nonnull;

public class HttpHeader {
    @Nonnull
    private final String name;
    @Nonnull
    private final String value;

    public HttpHeader(@Nonnull String string, @Nonnull String string2) {
        this.name = string;
        this.value = string2;
    }

    @Nonnull
    public String getName() {
        return this.name;
    }

    @Nonnull
    public String getValue() {
        return this.value;
    }

    public String toString() {
        return "HttpHeader{name='" + this.name + '\'' + ", value='" + this.value + '\'' + '}';
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        HttpHeader httpHeader = (HttpHeader)object;
        return Objects.equals(this.name, httpHeader.name) && Objects.equals(this.value, httpHeader.value);
    }

    public int hashCode() {
        return Objects.hash(this.name, this.value);
    }
}


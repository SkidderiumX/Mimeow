/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.message;

import java.io.Serializable;
import org.apache.http.NameValuePair;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;
import org.apache.http.util.LangUtils;

@Immutable
public class BasicNameValuePair
implements NameValuePair,
Cloneable,
Serializable {
    private static final long serialVersionUID = -6437800749411518984L;
    private final String name;
    private final String value;

    public BasicNameValuePair(String string, String string2) {
        this.name = Args.notNull(string, "Name");
        this.value = string2;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        if (this.value == null) {
            return this.name;
        }
        int n = this.name.length() + 1 + this.value.length();
        StringBuilder stringBuilder = new StringBuilder(n);
        stringBuilder.append(this.name);
        stringBuilder.append("=");
        stringBuilder.append(this.value);
        return stringBuilder.toString();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof NameValuePair) {
            BasicNameValuePair basicNameValuePair = (BasicNameValuePair)object;
            return this.name.equals(basicNameValuePair.name) && LangUtils.equals(this.value, basicNameValuePair.value);
        }
        return false;
    }

    public int hashCode() {
        int n = 17;
        n = LangUtils.hashCode(n, this.name);
        n = LangUtils.hashCode(n, this.value);
        return n;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}


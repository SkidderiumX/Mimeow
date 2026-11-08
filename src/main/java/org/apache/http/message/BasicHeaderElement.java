/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.message;

import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.Args;
import org.apache.http.util.LangUtils;

@NotThreadSafe
public class BasicHeaderElement
implements HeaderElement,
Cloneable {
    private final String name;
    private final String value;
    private final NameValuePair[] parameters;

    public BasicHeaderElement(String string, String string2, NameValuePair[] nameValuePairArray) {
        this.name = Args.notNull(string, "Name");
        this.value = string2;
        this.parameters = nameValuePairArray != null ? nameValuePairArray : new NameValuePair[0];
    }

    public BasicHeaderElement(String string, String string2) {
        this(string, string2, null);
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public NameValuePair[] getParameters() {
        return (NameValuePair[])this.parameters.clone();
    }

    public int getParameterCount() {
        return this.parameters.length;
    }

    public NameValuePair getParameter(int n) {
        return this.parameters[n];
    }

    public NameValuePair getParameterByName(String string) {
        Args.notNull(string, "Name");
        NameValuePair nameValuePair = null;
        for (NameValuePair nameValuePair2 : this.parameters) {
            if (!nameValuePair2.getName().equalsIgnoreCase(string)) continue;
            nameValuePair = nameValuePair2;
            break;
        }
        return nameValuePair;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof HeaderElement) {
            BasicHeaderElement basicHeaderElement = (BasicHeaderElement)object;
            return this.name.equals(basicHeaderElement.name) && LangUtils.equals(this.value, basicHeaderElement.value) && LangUtils.equals(this.parameters, basicHeaderElement.parameters);
        }
        return false;
    }

    public int hashCode() {
        int n = 17;
        n = LangUtils.hashCode(n, this.name);
        n = LangUtils.hashCode(n, this.value);
        for (NameValuePair nameValuePair : this.parameters) {
            n = LangUtils.hashCode(n, nameValuePair);
        }
        return n;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name);
        if (this.value != null) {
            stringBuilder.append("=");
            stringBuilder.append(this.value);
        }
        for (NameValuePair nameValuePair : this.parameters) {
            stringBuilder.append("; ");
            stringBuilder.append(nameValuePair);
        }
        return stringBuilder.toString();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}


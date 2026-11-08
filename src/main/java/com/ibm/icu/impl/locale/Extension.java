/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl.locale;

public class Extension {
    private char _key;
    protected String _value;

    protected Extension(char c) {
        this._key = c;
    }

    Extension(char c, String string) {
        this._key = c;
        this._value = string;
    }

    public char getKey() {
        return this._key;
    }

    public String getValue() {
        return this._value;
    }

    public String getID() {
        return this._key + "-" + this._value;
    }

    public String toString() {
        return this.getID();
    }
}


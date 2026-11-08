/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.nbt.stringified;

public class StringifiedTagParseException
extends RuntimeException {
    private static final long serialVersionUID = -3001637514903912905L;
    private final int position;

    public StringifiedTagParseException(String string, int n) {
        super(string);
        this.position = n;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + "(at position " + this.position + ")";
    }

    public int getPosition() {
        return this.position;
    }
}


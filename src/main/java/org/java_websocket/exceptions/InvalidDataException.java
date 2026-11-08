/*
 * Decompiled with CFR 0.152.
 */
package org.java_websocket.exceptions;

public class InvalidDataException
extends Exception {
    private static final long serialVersionUID = 3731842424390998726L;
    private final int closecode;

    public InvalidDataException(int n) {
        this.closecode = n;
    }

    public InvalidDataException(int n, String string) {
        super(string);
        this.closecode = n;
    }

    public InvalidDataException(int n, Throwable throwable) {
        super(throwable);
        this.closecode = n;
    }

    public InvalidDataException(int n, String string, Throwable throwable) {
        super(string, throwable);
        this.closecode = n;
    }

    public int getCloseCode() {
        return this.closecode;
    }
}


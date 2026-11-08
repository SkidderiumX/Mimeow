/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl;

public class IllegalIcuArgumentException
extends IllegalArgumentException {
    private static final long serialVersionUID = 3789261542830211225L;

    public IllegalIcuArgumentException(String string) {
        super(string);
    }

    public IllegalIcuArgumentException(Throwable throwable) {
        super(throwable);
    }

    public IllegalIcuArgumentException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public synchronized IllegalIcuArgumentException initCause(Throwable throwable) {
        return (IllegalIcuArgumentException)super.initCause(throwable);
    }
}


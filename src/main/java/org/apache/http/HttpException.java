/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http;

public class HttpException
extends Exception {
    private static final long serialVersionUID = -5437299376222011036L;

    public HttpException() {
    }

    public HttpException(String string) {
        super(string);
    }

    public HttpException(String string, Throwable throwable) {
        super(string);
        this.initCause(throwable);
    }
}


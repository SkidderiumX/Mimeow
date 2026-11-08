/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.io;

import java.io.IOException;

public class IOExceptionWithCause
extends IOException {
    private static final long serialVersionUID = 1L;

    public IOExceptionWithCause(String string, Throwable throwable) {
        super(string);
        this.initCause(throwable);
    }

    public IOExceptionWithCause(Throwable throwable) {
        super(throwable == null ? null : throwable.toString());
        this.initCause(throwable);
    }
}


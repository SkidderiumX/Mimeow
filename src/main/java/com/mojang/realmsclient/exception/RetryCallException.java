/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.realmsclient.exception;

import com.mojang.realmsclient.exception.RealmsServiceException;

public class RetryCallException
extends RealmsServiceException {
    public static final int DEFAULT_DELAY = 5;
    public final int delaySeconds;

    public RetryCallException(int n) {
        super(503, "Retry operation", -1, "");
        this.delaySeconds = n < 0 || n > 120 ? 5 : n;
    }
}


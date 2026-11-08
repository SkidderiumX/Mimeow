/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna;

import com.sun.jna.Platform;

public class LastErrorException
extends RuntimeException {
    private int errorCode;

    private static String formatMessage(int n) {
        return Platform.isWindows() ? "GetLastError() returned " + n : "errno was " + n;
    }

    private static String parseMessage(String string) {
        try {
            return LastErrorException.formatMessage(Integer.parseInt(string));
        }
        catch (NumberFormatException numberFormatException) {
            return string;
        }
    }

    public LastErrorException(String string) {
        super(LastErrorException.parseMessage(string.trim()));
        try {
            if (string.startsWith("[")) {
                string = string.substring(1, string.indexOf("]"));
            }
            this.errorCode = Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            this.errorCode = -1;
        }
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public LastErrorException(int n) {
        super(LastErrorException.formatMessage(n));
        this.errorCode = n;
    }
}


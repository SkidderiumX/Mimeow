/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal;

import java.math.BigDecimal;
import java.math.BigInteger;

public class NumberLimits {
    private static final int MAX_NUMBER_STRING_LENGTH = 10000;

    private NumberLimits() {
    }

    private static void checkNumberStringLength(String string) {
        if (string.length() > 10000) {
            throw new NumberFormatException("Number string too large: " + string.substring(0, 30) + "...");
        }
    }

    public static BigDecimal parseBigDecimal(String string) throws NumberFormatException {
        NumberLimits.checkNumberStringLength(string);
        BigDecimal bigDecimal = new BigDecimal(string);
        if (Math.abs((long)bigDecimal.scale()) >= 10000L) {
            throw new NumberFormatException("Number has unsupported scale: " + string);
        }
        return bigDecimal;
    }

    public static BigInteger parseBigInteger(String string) throws NumberFormatException {
        NumberLimits.checkNumberStringLength(string);
        return new BigInteger(string);
    }
}


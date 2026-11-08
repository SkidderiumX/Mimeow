/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal;

import com.google.gson.internal.NumberLimits;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.math.BigDecimal;

public class LazilyParsedNumber
extends Number {
    private final String value;

    public LazilyParsedNumber(String string) {
        this.value = string;
    }

    private BigDecimal asBigDecimal() {
        return NumberLimits.parseBigDecimal(this.value);
    }

    @Override
    public int intValue() {
        try {
            return Integer.parseInt(this.value);
        }
        catch (NumberFormatException numberFormatException) {
            try {
                return (int)Long.parseLong(this.value);
            }
            catch (NumberFormatException numberFormatException2) {
                return this.asBigDecimal().intValue();
            }
        }
    }

    @Override
    public long longValue() {
        try {
            return Long.parseLong(this.value);
        }
        catch (NumberFormatException numberFormatException) {
            return this.asBigDecimal().longValue();
        }
    }

    @Override
    public float floatValue() {
        return Float.parseFloat(this.value);
    }

    @Override
    public double doubleValue() {
        return Double.parseDouble(this.value);
    }

    public String toString() {
        return this.value;
    }

    private Object writeReplace() throws ObjectStreamException {
        return this.asBigDecimal();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof LazilyParsedNumber) {
            LazilyParsedNumber lazilyParsedNumber = (LazilyParsedNumber)object;
            return this.value.equals(lazilyParsedNumber.value);
        }
        return false;
    }
}


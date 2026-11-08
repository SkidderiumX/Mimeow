/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.mutable;

import org.apache.commons.lang3.mutable.Mutable;

public class MutableShort
extends Number
implements Comparable<MutableShort>,
Mutable<Number> {
    private static final long serialVersionUID = -2135791679L;
    private short value;

    public MutableShort() {
    }

    public MutableShort(short s) {
        this.value = s;
    }

    public MutableShort(Number number) {
        this.value = number.shortValue();
    }

    public MutableShort(String string) throws NumberFormatException {
        this.value = Short.parseShort(string);
    }

    @Override
    public Short getValue() {
        return this.value;
    }

    @Override
    public void setValue(short s) {
        this.value = s;
    }

    @Override
    public void setValue(Number number) {
        this.value = number.shortValue();
    }

    public void increment() {
        this.value = (short)(this.value + 1);
    }

    public void decrement() {
        this.value = (short)(this.value - 1);
    }

    public void add(short s) {
        this.value = (short)(this.value + s);
    }

    public void add(Number number) {
        this.value = (short)(this.value + number.shortValue());
    }

    public void subtract(short s) {
        this.value = (short)(this.value - s);
    }

    public void subtract(Number number) {
        this.value = (short)(this.value - number.shortValue());
    }

    @Override
    public short shortValue() {
        return this.value;
    }

    @Override
    public int intValue() {
        return this.value;
    }

    @Override
    public long longValue() {
        return this.value;
    }

    @Override
    public float floatValue() {
        return this.value;
    }

    @Override
    public double doubleValue() {
        return this.value;
    }

    public Short toShort() {
        return this.shortValue();
    }

    public boolean equals(Object object) {
        if (object instanceof MutableShort) {
            return this.value == ((MutableShort)object).shortValue();
        }
        return false;
    }

    public int hashCode() {
        return this.value;
    }

    @Override
    public int compareTo(MutableShort mutableShort) {
        short s = mutableShort.value;
        return this.value < s ? -1 : (this.value == s ? 0 : 1);
    }

    public String toString() {
        return String.valueOf(this.value);
    }
}


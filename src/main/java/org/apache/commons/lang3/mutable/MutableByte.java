/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.mutable;

import org.apache.commons.lang3.mutable.Mutable;

public class MutableByte
extends Number
implements Comparable<MutableByte>,
Mutable<Number> {
    private static final long serialVersionUID = -1585823265L;
    private byte value;

    public MutableByte() {
    }

    public MutableByte(byte by) {
        this.value = by;
    }

    public MutableByte(Number number) {
        this.value = number.byteValue();
    }

    public MutableByte(String string) throws NumberFormatException {
        this.value = Byte.parseByte(string);
    }

    @Override
    public Byte getValue() {
        return this.value;
    }

    @Override
    public void setValue(byte by) {
        this.value = by;
    }

    @Override
    public void setValue(Number number) {
        this.value = number.byteValue();
    }

    public void increment() {
        this.value = (byte)(this.value + 1);
    }

    public void decrement() {
        this.value = (byte)(this.value - 1);
    }

    public void add(byte by) {
        this.value = (byte)(this.value + by);
    }

    public void add(Number number) {
        this.value = (byte)(this.value + number.byteValue());
    }

    public void subtract(byte by) {
        this.value = (byte)(this.value - by);
    }

    public void subtract(Number number) {
        this.value = (byte)(this.value - number.byteValue());
    }

    @Override
    public byte byteValue() {
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

    public Byte toByte() {
        return this.byteValue();
    }

    public boolean equals(Object object) {
        if (object instanceof MutableByte) {
            return this.value == ((MutableByte)object).byteValue();
        }
        return false;
    }

    public int hashCode() {
        return this.value;
    }

    @Override
    public int compareTo(MutableByte mutableByte) {
        byte by = mutableByte.value;
        return this.value < by ? -1 : (this.value == by ? 0 : 1);
    }

    public String toString() {
        return String.valueOf(this.value);
    }
}


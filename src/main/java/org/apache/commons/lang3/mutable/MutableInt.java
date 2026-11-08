/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.mutable;

import org.apache.commons.lang3.mutable.Mutable;

public class MutableInt
extends Number
implements Comparable<MutableInt>,
Mutable<Number> {
    private static final long serialVersionUID = 512176391864L;
    private int value;

    public MutableInt() {
    }

    public MutableInt(int n) {
        this.value = n;
    }

    public MutableInt(Number number) {
        this.value = number.intValue();
    }

    public MutableInt(String string) throws NumberFormatException {
        this.value = Integer.parseInt(string);
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public void setValue(int n) {
        this.value = n;
    }

    @Override
    public void setValue(Number number) {
        this.value = number.intValue();
    }

    public void increment() {
        ++this.value;
    }

    public void decrement() {
        --this.value;
    }

    public void add(int n) {
        this.value += n;
    }

    public void add(Number number) {
        this.value += number.intValue();
    }

    public void subtract(int n) {
        this.value -= n;
    }

    public void subtract(Number number) {
        this.value -= number.intValue();
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

    public Integer toInteger() {
        return this.intValue();
    }

    public boolean equals(Object object) {
        if (object instanceof MutableInt) {
            return this.value == ((MutableInt)object).intValue();
        }
        return false;
    }

    public int hashCode() {
        return this.value;
    }

    @Override
    public int compareTo(MutableInt mutableInt) {
        int n = mutableInt.value;
        return this.value < n ? -1 : (this.value == n ? 0 : 1);
    }

    public String toString() {
        return String.valueOf(this.value);
    }
}


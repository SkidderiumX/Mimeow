/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.mutable;

import org.apache.commons.lang3.mutable.Mutable;

public class MutableDouble
extends Number
implements Comparable<MutableDouble>,
Mutable<Number> {
    private static final long serialVersionUID = 1587163916L;
    private double value;

    public MutableDouble() {
    }

    public MutableDouble(double d) {
        this.value = d;
    }

    public MutableDouble(Number number) {
        this.value = number.doubleValue();
    }

    public MutableDouble(String string) throws NumberFormatException {
        this.value = Double.parseDouble(string);
    }

    @Override
    public Double getValue() {
        return this.value;
    }

    @Override
    public void setValue(double d) {
        this.value = d;
    }

    @Override
    public void setValue(Number number) {
        this.value = number.doubleValue();
    }

    public boolean isNaN() {
        return Double.isNaN(this.value);
    }

    public boolean isInfinite() {
        return Double.isInfinite(this.value);
    }

    public void increment() {
        this.value += 1.0;
    }

    public void decrement() {
        this.value -= 1.0;
    }

    public void add(double d) {
        this.value += d;
    }

    public void add(Number number) {
        this.value += number.doubleValue();
    }

    public void subtract(double d) {
        this.value -= d;
    }

    public void subtract(Number number) {
        this.value -= number.doubleValue();
    }

    @Override
    public int intValue() {
        return (int)this.value;
    }

    @Override
    public long longValue() {
        return (long)this.value;
    }

    @Override
    public float floatValue() {
        return (float)this.value;
    }

    @Override
    public double doubleValue() {
        return this.value;
    }

    public Double toDouble() {
        return this.doubleValue();
    }

    public boolean equals(Object object) {
        return object instanceof MutableDouble && Double.doubleToLongBits(((MutableDouble)object).value) == Double.doubleToLongBits(this.value);
    }

    public int hashCode() {
        long l = Double.doubleToLongBits(this.value);
        return (int)(l ^ l >>> 32);
    }

    @Override
    public int compareTo(MutableDouble mutableDouble) {
        double d = mutableDouble.value;
        return Double.compare(this.value, d);
    }

    public String toString() {
        return String.valueOf(this.value);
    }
}


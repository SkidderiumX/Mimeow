/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.util;

import com.ibm.icu.util.MeasureUnit;

public abstract class Measure {
    private Number number;
    private MeasureUnit unit;

    protected Measure(Number number, MeasureUnit measureUnit) {
        if (number == null || measureUnit == null) {
            throw new NullPointerException();
        }
        this.number = number;
        this.unit = measureUnit;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        try {
            Measure measure = (Measure)object;
            return this.unit.equals(measure.unit) && Measure.numbersEqual(this.number, measure.number);
        }
        catch (ClassCastException classCastException) {
            return false;
        }
    }

    private static boolean numbersEqual(Number number, Number number2) {
        if (number.equals(number2)) {
            return true;
        }
        return number.doubleValue() == number2.doubleValue();
    }

    public int hashCode() {
        return this.number.hashCode() ^ this.unit.hashCode();
    }

    public String toString() {
        return this.number.toString() + ' ' + this.unit.toString();
    }

    public Number getNumber() {
        return this.number;
    }

    public MeasureUnit getUnit() {
        return this.unit;
    }
}


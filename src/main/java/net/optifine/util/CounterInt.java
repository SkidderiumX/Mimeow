/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.util;

public class CounterInt {
    private int startValue;
    private int value;

    public CounterInt(int n) {
        this.startValue = n;
        this.value = n;
    }

    public synchronized int nextValue() {
        int n = this.value++;
        return n;
    }

    public synchronized void reset() {
        this.value = this.startValue;
    }

    public int getValue() {
        return this.value;
    }
}


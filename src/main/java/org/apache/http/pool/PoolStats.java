/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.pool;

import org.apache.http.annotation.Immutable;

@Immutable
public class PoolStats {
    private final int leased;
    private final int pending;
    private final int available;
    private final int max;

    public PoolStats(int n, int n2, int n3, int n4) {
        this.leased = n;
        this.pending = n2;
        this.available = n3;
        this.max = n4;
    }

    public int getLeased() {
        return this.leased;
    }

    public int getPending() {
        return this.pending;
    }

    public int getAvailable() {
        return this.available;
    }

    public int getMax() {
        return this.max;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[leased: ");
        stringBuilder.append(this.leased);
        stringBuilder.append("; pending: ");
        stringBuilder.append(this.pending);
        stringBuilder.append("; available: ");
        stringBuilder.append(this.available);
        stringBuilder.append("; max: ");
        stringBuilder.append(this.max);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}


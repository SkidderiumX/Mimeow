/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl;

import com.ibm.icu.impl.IntTrieBuilder;
import com.ibm.icu.impl.PropsVectors;

public class PVecToTrieCompactHandler
implements PropsVectors.CompactHandler {
    public IntTrieBuilder builder;
    public int initialValue;

    public void setRowIndexForErrorValue(int n) {
    }

    public void setRowIndexForInitialValue(int n) {
        this.initialValue = n;
    }

    public void setRowIndexForRange(int n, int n2, int n3) {
        this.builder.setRange(n, n2 + 1, n3, true);
    }

    public void startRealValues(int n) {
        if (n > 65535) {
            throw new IndexOutOfBoundsException();
        }
        this.builder = new IntTrieBuilder(null, 100000, this.initialValue, this.initialValue, false);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.text.Replaceable;
import com.ibm.icu.text.UTF16;
import com.ibm.icu.text.UnicodeMatcher;

public abstract class UnicodeFilter
implements UnicodeMatcher {
    public abstract boolean contains(int var1);

    public int matches(Replaceable replaceable, int[] nArray, int n, boolean bl) {
        int n2;
        if (nArray[0] < n && this.contains(n2 = replaceable.char32At(nArray[0]))) {
            nArray[0] = nArray[0] + UTF16.getCharCount(n2);
            return 2;
        }
        if (nArray[0] > n && this.contains(replaceable.char32At(nArray[0]))) {
            nArray[0] = nArray[0] - 1;
            if (nArray[0] >= 0) {
                nArray[0] = nArray[0] - (UTF16.getCharCount(replaceable.char32At(nArray[0])) - 1);
            }
            return 2;
        }
        if (bl && nArray[0] == n) {
            return 1;
        }
        return 0;
    }

    protected UnicodeFilter() {
    }
}


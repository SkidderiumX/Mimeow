/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.impl.Assert;
import com.ibm.icu.text.DictionaryMatcher;
import com.ibm.icu.text.UCharacterIterator;
import com.ibm.icu.util.BytesTrie;
import java.text.CharacterIterator;

public class BytesDictionaryMatcher
extends DictionaryMatcher {
    private final byte[] characters;
    private final int transform;

    public BytesDictionaryMatcher(byte[] byArray, int n) {
        this.characters = byArray;
        Assert.assrt((n & 0x7F000000) == 0x1000000);
        this.transform = n;
    }

    private int transform(int n) {
        if (n == 8205) {
            return 255;
        }
        if (n == 8204) {
            return 254;
        }
        int n2 = n - (this.transform & 0x1FFFFF);
        if (n2 < 0 || 253 < n2) {
            return -1;
        }
        return n2;
    }

    public int matches(CharacterIterator characterIterator, int n, int[] nArray, int[] nArray2, int n2, int[] nArray3) {
        UCharacterIterator uCharacterIterator = UCharacterIterator.getInstance(characterIterator);
        BytesTrie bytesTrie = new BytesTrie(this.characters, 0);
        int n3 = uCharacterIterator.nextCodePoint();
        BytesTrie.Result result = bytesTrie.first(this.transform(n3));
        int n4 = 1;
        int n5 = 0;
        while (true) {
            if (result.hasValue()) {
                if (n5 < n2) {
                    if (nArray3 != null) {
                        nArray3[n5] = bytesTrie.getValue();
                    }
                    nArray[n5] = n4;
                    ++n5;
                }
                if (result == BytesTrie.Result.FINAL_VALUE) {
                    break;
                }
            } else if (result == BytesTrie.Result.NO_MATCH) break;
            if (n4 >= n) break;
            n3 = uCharacterIterator.nextCodePoint();
            ++n4;
            result = bytesTrie.next(this.transform(n3));
        }
        nArray2[0] = n5;
        return n4;
    }

    public int getType() {
        return 0;
    }
}


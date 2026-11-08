/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.text.LanguageBreakEngine;
import com.ibm.icu.text.UCharacterIterator;
import com.ibm.icu.text.UnicodeSet;
import java.text.CharacterIterator;
import java.util.Stack;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class DictionaryBreakEngine
implements LanguageBreakEngine {
    protected UnicodeSet fSet = new UnicodeSet();
    private final int fTypes;

    public DictionaryBreakEngine(int n) {
        this.fTypes = n;
    }

    @Override
    public boolean handles(int n, int n2) {
        return n2 >= 0 && n2 < 32 && (1 << n2 & this.fTypes) != 0 && this.fSet.contains(n);
    }

    @Override
    public int findBreaks(CharacterIterator characterIterator, int n, int n2, boolean bl, int n3, Stack<Integer> stack) {
        int n4;
        int n5;
        int n6;
        if (n3 < 0 || n3 >= 32 || (1 << n3 & this.fTypes) == 0) {
            return 0;
        }
        int n7 = 0;
        UCharacterIterator uCharacterIterator = UCharacterIterator.getInstance(characterIterator);
        int n8 = uCharacterIterator.getIndex();
        int n9 = uCharacterIterator.current();
        if (bl) {
            boolean bl2 = this.fSet.contains(n9);
            while ((n6 = uCharacterIterator.getIndex()) > n && bl2) {
                n9 = uCharacterIterator.previous();
                bl2 = this.fSet.contains(n9);
            }
            n5 = n6 < n ? n : n6 + (bl2 ? 0 : 1);
            n4 = n8 + 1;
        } else {
            while ((n6 = uCharacterIterator.getIndex()) < n2 && this.fSet.contains(n9)) {
                n9 = uCharacterIterator.next();
            }
            n5 = n8;
            n4 = n6;
        }
        n7 = this.divideUpDictionaryRange(uCharacterIterator, n5, n4, stack);
        uCharacterIterator.setIndex(n6);
        return n7;
    }

    protected abstract int divideUpDictionaryRange(UCharacterIterator var1, int var2, int var3, Stack<Integer> var4);
}


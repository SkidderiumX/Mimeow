/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.text.DictionaryMatcher;
import com.ibm.icu.text.UCharacterIterator;
import com.ibm.icu.util.BytesTrie;
import com.ibm.icu.util.CharsTrie;
import java.text.CharacterIterator;

public class CharsDictionaryMatcher
extends DictionaryMatcher {
    private CharSequence characters;

    public CharsDictionaryMatcher(CharSequence charSequence) {
        this.characters = charSequence;
    }

    public int matches(CharacterIterator characterIterator, int n, int[] nArray, int[] nArray2, int n2, int[] nArray3) {
        UCharacterIterator uCharacterIterator = UCharacterIterator.getInstance(characterIterator);
        CharsTrie charsTrie = new CharsTrie(this.characters, 0);
        int n3 = uCharacterIterator.nextCodePoint();
        BytesTrie.Result result = charsTrie.firstForCodePoint(n3);
        int n4 = 1;
        int n5 = 0;
        while (true) {
            if (result.hasValue()) {
                if (n5 < n2) {
                    if (nArray3 != null) {
                        nArray3[n5] = charsTrie.getValue();
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
            result = charsTrie.nextForCodePoint(n3);
        }
        nArray2[0] = n5;
        return n4;
    }

    public int getType() {
        return 1;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.impl.Assert;
import com.ibm.icu.impl.CharacterIteration;
import com.ibm.icu.text.DictionaryData;
import com.ibm.icu.text.DictionaryMatcher;
import com.ibm.icu.text.LanguageBreakEngine;
import com.ibm.icu.text.Normalizer;
import com.ibm.icu.text.UnicodeSet;
import java.io.IOException;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Stack;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class CjkBreakEngine
implements LanguageBreakEngine {
    private static final UnicodeSet fHangulWordSet = new UnicodeSet();
    private static final UnicodeSet fHanWordSet = new UnicodeSet();
    private static final UnicodeSet fKatakanaWordSet = new UnicodeSet();
    private static final UnicodeSet fHiraganaWordSet = new UnicodeSet();
    private final UnicodeSet fWordSet;
    private DictionaryMatcher fDictionary = DictionaryData.loadDictionaryFor("Hira");
    private static final int kMaxKatakanaLength = 8;
    private static final int kMaxKatakanaGroupLength = 20;
    private static final int maxSnlp = 255;
    private static final int kint32max = Integer.MAX_VALUE;

    public CjkBreakEngine(boolean bl) throws IOException {
        if (bl) {
            this.fWordSet = fHangulWordSet;
        } else {
            this.fWordSet = new UnicodeSet();
            this.fWordSet.addAll(fHanWordSet);
            this.fWordSet.addAll(fKatakanaWordSet);
            this.fWordSet.addAll(fHiraganaWordSet);
            this.fWordSet.add("\\uff70\\u30fc");
        }
    }

    @Override
    public boolean handles(int n, int n2) {
        return n2 == 1 && this.fWordSet.contains(n);
    }

    private static int getKatakanaCost(int n) {
        int[] nArray = new int[]{8192, 984, 408, 240, 204, 252, 300, 372, 480};
        return n > 8 ? 8192 : nArray[n];
    }

    private static boolean isKatakana(int n) {
        return n >= 12449 && n <= 12542 && n != 12539 || n >= 65382 && n <= 65439;
    }

    @Override
    public int findBreaks(CharacterIterator characterIterator, int n, int n2, boolean bl, int n3, Stack<Integer> stack) {
        int n4;
        int n5;
        int n6;
        if (n >= n2) {
            return 0;
        }
        characterIterator.setIndex(n);
        int n7 = n2 - n;
        int[] nArray = new int[n7 + 1];
        StringBuffer stringBuffer = new StringBuffer("");
        characterIterator.setIndex(n);
        while (characterIterator.getIndex() < n2) {
            stringBuffer.append(characterIterator.current());
            characterIterator.next();
        }
        String string = stringBuffer.toString();
        boolean bl2 = Normalizer.quickCheck(string, Normalizer.NFKC) == Normalizer.YES || Normalizer.isNormalized(string, Normalizer.NFKC, 0);
        CharacterIterator characterIterator2 = characterIterator;
        int n8 = 0;
        if (bl2) {
            int n9 = 0;
            nArray[0] = 0;
            while (n9 < string.length()) {
                int n10 = string.codePointAt(n9);
                nArray[++n8] = n9 += Character.charCount(n10);
            }
        } else {
            String string2 = Normalizer.normalize(string, Normalizer.NFKC);
            characterIterator2 = new StringCharacterIterator(string2);
            nArray = new int[string2.length() + 1];
            Normalizer normalizer = new Normalizer(string, Normalizer.NFKC, 0);
            n6 = 0;
            nArray[0] = 0;
            while (n6 < normalizer.endIndex()) {
                normalizer.next();
                nArray[++n8] = n6 = normalizer.getIndex();
            }
        }
        int[] nArray2 = new int[n8 + 1];
        nArray2[0] = 0;
        for (int i = 1; i <= n8; ++i) {
            nArray2[i] = Integer.MAX_VALUE;
        }
        int[] nArray3 = new int[n8 + 1];
        for (n6 = 0; n6 <= n8; ++n6) {
            nArray3[n6] = -1;
        }
        n6 = 20;
        int[] nArray4 = new int[n8];
        int[] nArray5 = new int[n8];
        int n11 = 0;
        for (int i = 0; i < n8; ++i) {
            int n12;
            int n13;
            characterIterator2.setIndex(i);
            if (nArray2[i] == Integer.MAX_VALUE) continue;
            n5 = i + 20 < n8 ? 20 : n8 - i;
            int[] nArray6 = new int[1];
            this.fDictionary.matches(characterIterator2, n5, nArray5, nArray6, n5, nArray4);
            n4 = nArray6[0];
            if (!(n4 != 0 && nArray5[0] == 1 || CharacterIteration.current32(characterIterator2) == Integer.MAX_VALUE || fHangulWordSet.contains(CharacterIteration.current32(characterIterator2)))) {
                nArray4[n4] = 255;
                nArray5[n4] = 1;
                ++n4;
            }
            for (n13 = 0; n13 < n4; ++n13) {
                n12 = nArray2[i] + nArray4[n13];
                if (n12 >= nArray2[nArray5[n13] + i]) continue;
                nArray2[nArray5[n13] + i] = n12;
                nArray3[nArray5[n13] + i] = i;
            }
            characterIterator2.setIndex(i);
            n13 = CjkBreakEngine.isKatakana(CharacterIteration.current32(characterIterator2)) ? 1 : 0;
            if (n11 == 0 && n13 != 0) {
                int n14;
                CharacterIteration.next32(characterIterator2);
                for (n12 = i + 1; n12 < n8 && n12 - i < 20 && CjkBreakEngine.isKatakana(CharacterIteration.current32(characterIterator2)); ++n12) {
                    CharacterIteration.next32(characterIterator2);
                }
                if (n12 - i < 20 && (n14 = nArray2[i] + CjkBreakEngine.getKatakanaCost(n12 - i)) < nArray2[n12]) {
                    nArray2[n12] = n14;
                    nArray3[n12] = i;
                }
            }
            n11 = n13;
        }
        int[] nArray7 = new int[n8 + 1];
        n5 = 0;
        if (nArray2[n8] == Integer.MAX_VALUE) {
            nArray7[n5] = n8;
            ++n5;
        } else {
            int n15 = n8;
            while (n15 > 0) {
                nArray7[n5] = n15;
                ++n5;
                n15 = nArray3[n15];
            }
            Assert.assrt(nArray3[nArray7[n5 - 1]] == 0);
        }
        if (stack.size() == 0 || stack.peek() < n) {
            nArray7[n5++] = 0;
        }
        for (int i = n5 - 1; i >= 0; --i) {
            n4 = nArray[nArray7[i]] + n;
            if (stack.contains(n4) || n4 == n) continue;
            stack.push(nArray[nArray7[i]] + n);
        }
        if (!stack.empty() && stack.peek() == n2) {
            stack.pop();
        }
        if (!stack.empty()) {
            characterIterator.setIndex(stack.peek());
        }
        return 0;
    }

    static {
        fHangulWordSet.applyPattern("[\\uac00-\\ud7a3]");
        fHanWordSet.applyPattern("[:Han:]");
        fKatakanaWordSet.applyPattern("[[:Katakana:]\\uff9e\\uff9f]");
        fHiraganaWordSet.applyPattern("[:Hiragana:]");
        fHangulWordSet.freeze();
        fHanWordSet.freeze();
        fKatakanaWordSet.freeze();
        fHiraganaWordSet.freeze();
    }
}


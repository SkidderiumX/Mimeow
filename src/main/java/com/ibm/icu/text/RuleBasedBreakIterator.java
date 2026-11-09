/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.impl.Assert;
import com.ibm.icu.impl.CharTrie;
import com.ibm.icu.impl.CharacterIteration;
import com.ibm.icu.impl.ICUDebug;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.text.BreakIterator;
import com.ibm.icu.text.CjkBreakEngine;
import com.ibm.icu.text.LanguageBreakEngine;
import com.ibm.icu.text.RBBIDataWrapper;
import com.ibm.icu.text.RBBIRuleBuilder;
import com.ibm.icu.text.ThaiBreakEngine;
import com.ibm.icu.text.UnhandledBreakEngine;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class RuleBasedBreakIterator
extends BreakIterator {
    public static final int WORD_NONE = 0;
    public static final int WORD_NONE_LIMIT = 100;
    public static final int WORD_NUMBER = 100;
    public static final int WORD_NUMBER_LIMIT = 200;
    public static final int WORD_LETTER = 200;
    public static final int WORD_LETTER_LIMIT = 300;
    public static final int WORD_KANA = 300;
    public static final int WORD_KANA_LIMIT = 400;
    public static final int WORD_IDEO = 400;
    public static final int WORD_IDEO_LIMIT = 500;
    private static final int START_STATE = 1;
    private static final int STOP_STATE = 0;
    private static final int RBBI_START = 0;
    private static final int RBBI_RUN = 1;
    private static final int RBBI_END = 2;
    private CharacterIterator fText = new StringCharacterIterator("");
    RBBIDataWrapper fRData;
    private int fLastRuleStatusIndex;
    private boolean fLastStatusIndexValid = true;
    private int fDictionaryCharCount = 0;
    private static final String RBBI_DEBUG_ARG = "rbbi";
    private static final boolean TRACE = ICUDebug.enabled("rbbi") && ICUDebug.value("rbbi").indexOf("trace") >= 0;
    private int fBreakType = 2;
    private final UnhandledBreakEngine fUnhandledBreakEngine = new UnhandledBreakEngine();
    private int[] fCachedBreakPositions;
    private int fPositionInCache;
    private boolean fUseDictionary = true;
    private final Set<LanguageBreakEngine> fBreakEngines = Collections.synchronizedSet(new HashSet());
    static final String fDebugEnv = ICUDebug.enabled("rbbi") ? ICUDebug.value("rbbi") : null;

    private RuleBasedBreakIterator() {
        this.fBreakEngines.add(this.fUnhandledBreakEngine);
    }

    public static RuleBasedBreakIterator getInstanceFromCompiledRules(InputStream inputStream2) throws IOException {
        RuleBasedBreakIterator ruleBasedBreakIterator = new RuleBasedBreakIterator();
        ruleBasedBreakIterator.fRData = RBBIDataWrapper.get(inputStream2);
        return ruleBasedBreakIterator;
    }

    public RuleBasedBreakIterator(String string) {
        this();
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            RuleBasedBreakIterator.compileRules(string, byteArrayOutputStream);
            byte[] byArray = byteArrayOutputStream.toByteArray();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
            this.fRData = RBBIDataWrapper.get(byteArrayInputStream);
        }
        catch (IOException iOException) {
            RuntimeException runtimeException = new RuntimeException("RuleBasedBreakIterator rule compilation internal error: " + iOException.getMessage());
            throw runtimeException;
        }
    }

    public Object clone() {
        RuleBasedBreakIterator ruleBasedBreakIterator = (RuleBasedBreakIterator)super.clone();
        if (this.fText != null) {
            ruleBasedBreakIterator.fText = (CharacterIterator)this.fText.clone();
        }
        return ruleBasedBreakIterator;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        try {
            RuleBasedBreakIterator ruleBasedBreakIterator = (RuleBasedBreakIterator)object;
            if (this.fRData != ruleBasedBreakIterator.fRData && (this.fRData == null || ruleBasedBreakIterator.fRData == null)) {
                return false;
            }
            if (this.fRData != null && ruleBasedBreakIterator.fRData != null && !this.fRData.fRuleSource.equals(ruleBasedBreakIterator.fRData.fRuleSource)) {
                return false;
            }
            if (this.fText == null && ruleBasedBreakIterator.fText == null) {
                return true;
            }
            if (this.fText == null || ruleBasedBreakIterator.fText == null) {
                return false;
            }
            return this.fText.equals(ruleBasedBreakIterator.fText);
        }
        catch (ClassCastException classCastException) {
            return false;
        }
    }

    public String toString() {
        String string = "";
        if (this.fRData != null) {
            string = this.fRData.fRuleSource;
        }
        return string;
    }

    public int hashCode() {
        return this.fRData.fRuleSource.hashCode();
    }

    public void dump() {
        this.fRData.dump();
    }

    public static void compileRules(String string, OutputStream outputStream2) throws IOException {
        RBBIRuleBuilder.compileRules(string, outputStream2);
    }

    public int first() {
        this.fCachedBreakPositions = null;
        this.fDictionaryCharCount = 0;
        this.fPositionInCache = 0;
        this.fLastRuleStatusIndex = 0;
        this.fLastStatusIndexValid = true;
        if (this.fText == null) {
            return -1;
        }
        this.fText.first();
        return this.fText.getIndex();
    }

    public int last() {
        this.fCachedBreakPositions = null;
        this.fDictionaryCharCount = 0;
        this.fPositionInCache = 0;
        if (this.fText == null) {
            this.fLastRuleStatusIndex = 0;
            this.fLastStatusIndexValid = true;
            return -1;
        }
        this.fLastStatusIndexValid = false;
        int n = this.fText.getEndIndex();
        this.fText.setIndex(n);
        return n;
    }

    public int next(int n) {
        int n2 = this.current();
        while (n > 0) {
            n2 = this.handleNext();
            --n;
        }
        while (n < 0) {
            n2 = this.previous();
            ++n;
        }
        return n2;
    }

    public int next() {
        return this.handleNext();
    }

    public int previous() {
        int n;
        CharacterIterator characterIterator = this.getText();
        this.fLastStatusIndexValid = false;
        if (this.fCachedBreakPositions != null && this.fPositionInCache > 0) {
            --this.fPositionInCache;
            characterIterator.setIndex(this.fCachedBreakPositions[this.fPositionInCache]);
            return this.fCachedBreakPositions[this.fPositionInCache];
        }
        this.fCachedBreakPositions = null;
        int n2 = this.current();
        int n3 = this.rulesPrevious();
        if (n3 == -1) {
            return n3;
        }
        if (this.fDictionaryCharCount == 0) {
            return n3;
        }
        if (this.fCachedBreakPositions != null) {
            this.fPositionInCache = this.fCachedBreakPositions.length - 2;
            return n3;
        }
        while (n3 < n2 && (n = this.handleNext()) < n2) {
            n3 = n;
        }
        if (this.fCachedBreakPositions != null) {
            this.fPositionInCache = 0;
            while (this.fPositionInCache < this.fCachedBreakPositions.length) {
                if (this.fCachedBreakPositions[this.fPositionInCache] >= n2) {
                    --this.fPositionInCache;
                    break;
                }
                ++this.fPositionInCache;
            }
        }
        this.fLastStatusIndexValid = false;
        characterIterator.setIndex(n3);
        return n3;
    }

    private int rulesPrevious() {
        if (this.fText == null || this.current() == this.fText.getBeginIndex()) {
            this.fLastRuleStatusIndex = 0;
            this.fLastStatusIndexValid = true;
            return -1;
        }
        if (this.fRData.fSRTable != null || this.fRData.fSFTable != null) {
            return this.handlePrevious(this.fRData.fRTable);
        }
        int n = this.current();
        CharacterIteration.previous32(this.fText);
        int n2 = this.handlePrevious(this.fRData.fRTable);
        if (n2 == -1) {
            n2 = this.fText.getBeginIndex();
            this.fText.setIndex(n2);
        }
        int n3 = n2;
        int n4 = 0;
        boolean bl = false;
        while ((n3 = this.handleNext()) != -1 && n3 < n) {
            n2 = n3;
            n4 = this.fLastRuleStatusIndex;
            bl = true;
        }
        this.fText.setIndex(n2);
        this.fLastRuleStatusIndex = n4;
        this.fLastStatusIndexValid = bl;
        return n2;
    }

    public int following(int n) {
        CharacterIterator characterIterator = this.getText();
        if (this.fCachedBreakPositions == null || n < this.fCachedBreakPositions[0] || n >= this.fCachedBreakPositions[this.fCachedBreakPositions.length - 1]) {
            this.fCachedBreakPositions = null;
            return this.rulesFollowing(n);
        }
        this.fPositionInCache = 0;
        while (this.fPositionInCache < this.fCachedBreakPositions.length && n >= this.fCachedBreakPositions[this.fPositionInCache]) {
            ++this.fPositionInCache;
        }
        characterIterator.setIndex(this.fCachedBreakPositions[this.fPositionInCache]);
        return characterIterator.getIndex();
    }

    private int rulesFollowing(int n) {
        this.fLastRuleStatusIndex = 0;
        this.fLastStatusIndexValid = true;
        if (this.fText == null || n >= this.fText.getEndIndex()) {
            this.last();
            return this.next();
        }
        if (n < this.fText.getBeginIndex()) {
            return this.first();
        }
        int n2 = 0;
        if (this.fRData.fSRTable != null) {
            this.fText.setIndex(n);
            CharacterIteration.next32(this.fText);
            this.handlePrevious(this.fRData.fSRTable);
            n2 = this.next();
            while (n2 <= n) {
                n2 = this.next();
            }
            return n2;
        }
        if (this.fRData.fSFTable != null) {
            this.fText.setIndex(n);
            CharacterIteration.previous32(this.fText);
            this.handleNext(this.fRData.fSFTable);
            int n3 = this.previous();
            while (n3 > n) {
                n2 = this.previous();
                if (n2 <= n) {
                    return n3;
                }
                n3 = n2;
            }
            n2 = this.next();
            if (n2 <= n) {
                return this.next();
            }
            return n2;
        }
        this.fText.setIndex(n);
        if (n == this.fText.getBeginIndex()) {
            return this.handleNext();
        }
        n2 = this.previous();
        while (n2 != -1 && n2 <= n) {
            n2 = this.next();
        }
        return n2;
    }

    public int preceding(int n) {
        CharacterIterator characterIterator = this.getText();
        if (this.fCachedBreakPositions == null || n <= this.fCachedBreakPositions[0] || n > this.fCachedBreakPositions[this.fCachedBreakPositions.length - 1]) {
            this.fCachedBreakPositions = null;
            return this.rulesPreceding(n);
        }
        this.fPositionInCache = 0;
        while (this.fPositionInCache < this.fCachedBreakPositions.length && n > this.fCachedBreakPositions[this.fPositionInCache]) {
            ++this.fPositionInCache;
        }
        --this.fPositionInCache;
        characterIterator.setIndex(this.fCachedBreakPositions[this.fPositionInCache]);
        return characterIterator.getIndex();
    }

    private int rulesPreceding(int n) {
        if (this.fText == null || n > this.fText.getEndIndex()) {
            return this.last();
        }
        if (n < this.fText.getBeginIndex()) {
            return this.first();
        }
        if (this.fRData.fSFTable != null) {
            this.fText.setIndex(n);
            CharacterIteration.previous32(this.fText);
            this.handleNext(this.fRData.fSFTable);
            int n2 = this.previous();
            while (n2 >= n) {
                n2 = this.previous();
            }
            return n2;
        }
        if (this.fRData.fSRTable != null) {
            int n3;
            this.fText.setIndex(n);
            CharacterIteration.next32(this.fText);
            this.handlePrevious(this.fRData.fSRTable);
            int n4 = this.next();
            while (n4 < n) {
                n3 = this.next();
                if (n3 >= n) {
                    return n4;
                }
                n4 = n3;
            }
            n3 = this.previous();
            if (n3 >= n) {
                return this.previous();
            }
            return n3;
        }
        this.fText.setIndex(n);
        return this.previous();
    }

    protected static final void checkOffset(int n, CharacterIterator characterIterator) {
        if (n < characterIterator.getBeginIndex() || n > characterIterator.getEndIndex()) {
            throw new IllegalArgumentException("offset out of bounds");
        }
    }

    public boolean isBoundary(int n) {
        RuleBasedBreakIterator.checkOffset(n, this.fText);
        if (n == this.fText.getBeginIndex()) {
            this.first();
            return true;
        }
        if (n == this.fText.getEndIndex()) {
            this.last();
            return true;
        }
        this.fText.setIndex(n);
        CharacterIteration.previous32(this.fText);
        int n2 = this.fText.getIndex();
        boolean bl = this.following(n2) == n;
        return bl;
    }

    public int current() {
        return this.fText != null ? this.fText.getIndex() : -1;
    }

    private void makeRuleStatusValid() {
        if (!this.fLastStatusIndexValid) {
            int n = this.current();
            if (n == -1 || n == this.fText.getBeginIndex()) {
                this.fLastRuleStatusIndex = 0;
                this.fLastStatusIndexValid = true;
            } else {
                int n2 = this.fText.getIndex();
                this.first();
                int n3 = this.current();
                while (this.fText.getIndex() < n2) {
                    n3 = this.next();
                }
                Assert.assrt(n2 == n3);
            }
            Assert.assrt(this.fLastStatusIndexValid);
            Assert.assrt(this.fLastRuleStatusIndex >= 0 && this.fLastRuleStatusIndex < this.fRData.fStatusTable.length);
        }
    }

    public int getRuleStatus() {
        this.makeRuleStatusValid();
        int n = this.fLastRuleStatusIndex + this.fRData.fStatusTable[this.fLastRuleStatusIndex];
        int n2 = this.fRData.fStatusTable[n];
        return n2;
    }

    public int getRuleStatusVec(int[] nArray) {
        this.makeRuleStatusValid();
        int n = this.fRData.fStatusTable[this.fLastRuleStatusIndex];
        if (nArray != null) {
            int n2 = Math.min(n, nArray.length);
            for (int i = 0; i < n2; ++i) {
                nArray[i] = this.fRData.fStatusTable[this.fLastRuleStatusIndex + i + 1];
            }
        }
        return n;
    }

    public CharacterIterator getText() {
        return this.fText;
    }

    public void setText(CharacterIterator characterIterator) {
        this.fText = characterIterator;
        int n = this.first();
        if (characterIterator != null) {
            this.fUseDictionary = (this.fBreakType == 1 || this.fBreakType == 2) && characterIterator.getEndIndex() != n;
        }
    }

    void setBreakType(int n) {
        this.fBreakType = n;
        if (n != 1 && n != 2) {
            this.fUseDictionary = false;
        }
    }

    int getBreakType() {
        return this.fBreakType;
    }

    private LanguageBreakEngine getEngineFor(int n) {
        LanguageBreakEngine languageBreakEngine2;
        if (n == Integer.MAX_VALUE || !this.fUseDictionary) {
            return null;
        }
        for (LanguageBreakEngine languageBreakEngine2_r : this.fBreakEngines) {
            if (!languageBreakEngine2_r.handles(n, this.fBreakType)) continue;
            return languageBreakEngine2_r;
        }
        int n2 = UCharacter.getIntPropertyValue(n, 4106);
        languageBreakEngine2 = null;
        try {
            switch (n2) {
                case 38: {
                    languageBreakEngine2 = new ThaiBreakEngine();
                    break;
                }
                case 17: 
                case 20: 
                case 22: {
                    if (this.getBreakType() == 1) {
                        languageBreakEngine2 = new CjkBreakEngine(false);
                        break;
                    }
                    this.fUnhandledBreakEngine.handleChar(n, this.getBreakType());
                    languageBreakEngine2 = this.fUnhandledBreakEngine;
                    break;
                }
                case 18: {
                    if (this.getBreakType() == 1) {
                        languageBreakEngine2 = new CjkBreakEngine(true);
                        break;
                    }
                    this.fUnhandledBreakEngine.handleChar(n, this.getBreakType());
                    languageBreakEngine2 = this.fUnhandledBreakEngine;
                    break;
                }
                default: {
                    this.fUnhandledBreakEngine.handleChar(n, this.getBreakType());
                    languageBreakEngine2 = this.fUnhandledBreakEngine;
                    break;
                }
            }
        }
        catch (IOException iOException) {
            languageBreakEngine2 = null;
        }
        if (languageBreakEngine2 != null) {
            this.fBreakEngines.add(languageBreakEngine2);
        }
        return languageBreakEngine2;
    }

    /*
     * Enabled aggressive block sorting
     */
    private int handleNext() {
        if (this.fCachedBreakPositions == null || this.fPositionInCache == this.fCachedBreakPositions.length - 1) {
            int n = this.fText.getIndex();
            this.fDictionaryCharCount = 0;
            int n2 = this.handleNext(this.fRData.fFTable);
            if (this.fDictionaryCharCount > 1 && n2 - n > 1) {
                this.fText.setIndex(n);
                LanguageBreakEngine languageBreakEngine = this.getEngineFor(CharacterIteration.current32(this.fText));
                if (languageBreakEngine == null) {
                    this.fText.setIndex(n2);
                    return n2;
                }
                Stack<Integer> stack = new Stack<Integer>();
                languageBreakEngine.findBreaks(this.fText, n, n2, false, this.getBreakType(), stack);
                int n3 = stack.size();
                this.fCachedBreakPositions = new int[n3 + 2];
                this.fCachedBreakPositions[0] = n;
                for (int i = 0; i < n3; ++i) {
                    this.fCachedBreakPositions[i + 1] = (Integer)stack.elementAt(i);
                }
                this.fCachedBreakPositions[n3 + 1] = n2;
                this.fPositionInCache = 0;
            } else {
                this.fCachedBreakPositions = null;
                return n2;
            }
        }
        if (this.fCachedBreakPositions != null) {
            ++this.fPositionInCache;
            this.fText.setIndex(this.fCachedBreakPositions[this.fPositionInCache]);
            return this.fCachedBreakPositions[this.fPositionInCache];
        }
        Assert.assrt(false);
        return -1;
    }

    private int handleNext(short[] sArray) {
        int n;
        if (TRACE) {
            System.out.println("Handle Next   pos      char  state category");
        }
        this.fLastStatusIndexValid = true;
        this.fLastRuleStatusIndex = 0;
        CharacterIterator characterIterator = this.fText;
        CharTrie charTrie = this.fRData.fTrie;
        int n2 = characterIterator.current();
        if (n2 >= 55296 && (n2 = CharacterIteration.nextTrail32(characterIterator, n2)) == Integer.MAX_VALUE) {
            return -1;
        }
        int n3 = n = characterIterator.getIndex();
        int n4 = 1;
        int n5 = this.fRData.getRowIndex(n4);
        int n6 = 3;
        short s = sArray[5];
        int n7 = 1;
        if ((s & 2) != 0) {
            n6 = 2;
            n7 = 0;
            if (TRACE) {
                System.out.print("            " + RBBIDataWrapper.intToString(characterIterator.getIndex(), 5));
                System.out.print(RBBIDataWrapper.intToHexString(n2, 10));
                System.out.println(RBBIDataWrapper.intToString(n4, 7) + RBBIDataWrapper.intToString(n6, 6));
            }
        }
        short s2 = 0;
        int n8 = 0;
        int n9 = 0;
        while (n4 != 0) {
            if (n2 == Integer.MAX_VALUE) {
                if (n7 == 2) {
                    if (n9 <= n3) break;
                    n3 = n9;
                    this.fLastRuleStatusIndex = n8;
                    break;
                }
                n7 = 2;
                n6 = 1;
            } else if (n7 == 1) {
                n6 = (short)charTrie.getCodePointValue(n2);
                if ((n6 & 0x4000) != 0) {
                    ++this.fDictionaryCharCount;
                    n6 = (short)(n6 & 0xFFFFBFFF);
                }
                if (TRACE) {
                    System.out.print("            " + RBBIDataWrapper.intToString(characterIterator.getIndex(), 5));
                    System.out.print(RBBIDataWrapper.intToHexString(n2, 10));
                    System.out.println(RBBIDataWrapper.intToString(n4, 7) + RBBIDataWrapper.intToString(n6, 6));
                }
                if ((n2 = (int)characterIterator.next()) >= 55296) {
                    n2 = CharacterIteration.nextTrail32(characterIterator, n2);
                }
            } else {
                n7 = 1;
            }
            n4 = sArray[n5 + 4 + n6];
            n5 = this.fRData.getRowIndex(n4);
            if (sArray[n5 + 0] == -1) {
                n3 = characterIterator.getIndex();
                if (n2 >= 65536 && n2 <= 0x10FFFF) {
                    --n3;
                }
                this.fLastRuleStatusIndex = sArray[n5 + 2];
            }
            if (sArray[n5 + 1] != 0) {
                if (s2 != 0 && sArray[n5 + 0] == s2) {
                    n3 = n9;
                    this.fLastRuleStatusIndex = n8;
                    s2 = 0;
                    if ((s & 1) == 0) continue;
                    characterIterator.setIndex(n3);
                    return n3;
                }
                n9 = characterIterator.getIndex();
                if (n2 >= 65536 && n2 <= 0x10FFFF) {
                    --n9;
                }
                s2 = sArray[n5 + 1];
                n8 = sArray[n5 + 2];
                continue;
            }
            if (sArray[n5 + 0] == 0) continue;
            s2 = 0;
        }
        if (n3 == n) {
            if (TRACE) {
                System.out.println("Iterator did not move. Advancing by 1.");
            }
            characterIterator.setIndex(n);
            CharacterIteration.next32(characterIterator);
            n3 = characterIterator.getIndex();
        } else {
            characterIterator.setIndex(n3);
        }
        if (TRACE) {
            System.out.println("result = " + n3);
        }
        return n3;
    }

    private int handlePrevious(short[] sArray) {
        if (this.fText == null || sArray == null) {
            return 0;
        }
        int n = 0;
        short s = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        boolean bl = (sArray[5] & 1) != 0;
        this.fLastStatusIndexValid = false;
        this.fLastRuleStatusIndex = 0;
        n2 = n3 = this.fText.getIndex();
        int n5 = CharacterIteration.previous32(this.fText);
        int n6 = 1;
        int n7 = this.fRData.getRowIndex(n6);
        n = 3;
        int n8 = 1;
        if ((sArray[5] & 2) != 0) {
            n = 2;
            n8 = 0;
        }
        if (TRACE) {
            System.out.println("Handle Prev   pos   char  state category ");
        }
        while (true) {
            if (n5 == Integer.MAX_VALUE) {
                if (n8 == 2 || this.fRData.fHeader.fVersion == 1) {
                    if (n4 < n2) {
                        n2 = n4;
                        s = 0;
                        break;
                    }
                    if (n2 != n3) break;
                    this.fText.setIndex(n3);
                    CharacterIteration.previous32(this.fText);
                    break;
                }
                n8 = 2;
                n = 1;
            }
            if (n8 == 1 && ((n = (int)((short)this.fRData.fTrie.getCodePointValue(n5))) & 0x4000) != 0) {
                ++this.fDictionaryCharCount;
                n &= 0xFFFFBFFF;
            }
            if (TRACE) {
                System.out.print("             " + this.fText.getIndex() + "   ");
                if (32 <= n5 && n5 < 127) {
                    System.out.print("  " + n5 + "  ");
                } else {
                    System.out.print(" " + Integer.toHexString(n5) + " ");
                }
                System.out.println(" " + n6 + "  " + n + " ");
            }
            if (sArray[(n7 = this.fRData.getRowIndex(n6 = sArray[n7 + 4 + n])) + 0] == -1) {
                n2 = this.fText.getIndex();
            }
            if (sArray[n7 + 1] != 0) {
                if (s != 0 && sArray[n7 + 0] == s) {
                    n2 = n4;
                    s = 0;
                    if (bl) {
                        break;
                    }
                } else {
                    n4 = this.fText.getIndex();
                    s = sArray[n7 + 1];
                }
            } else if (sArray[n7 + 0] != 0 && !bl) {
                s = 0;
            }
            if (n6 == 0) break;
            if (n8 == 1) {
                n5 = CharacterIteration.previous32(this.fText);
                continue;
            }
            if (n8 != 0) continue;
            n8 = 1;
        }
        if (n2 == n3) {
            n2 = this.fText.setIndex(n3);
            CharacterIteration.previous32(this.fText);
            n2 = this.fText.getIndex();
        }
        this.fText.setIndex(n2);
        if (TRACE) {
            System.out.println("Result = " + n2);
        }
        return n2;
    }
}


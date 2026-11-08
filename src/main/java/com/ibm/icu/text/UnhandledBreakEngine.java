/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.text.LanguageBreakEngine;
import com.ibm.icu.text.UnicodeSet;
import java.text.CharacterIterator;
import java.util.Stack;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class UnhandledBreakEngine
implements LanguageBreakEngine {
    private final UnicodeSet[] fHandled = new UnicodeSet[5];

    public UnhandledBreakEngine() {
        for (int i = 0; i < this.fHandled.length; ++i) {
            this.fHandled[i] = new UnicodeSet();
        }
    }

    @Override
    public boolean handles(int n, int n2) {
        return n2 >= 0 && n2 < this.fHandled.length && this.fHandled[n2].contains(n);
    }

    @Override
    public int findBreaks(CharacterIterator characterIterator, int n, int n2, boolean bl, int n3, Stack<Integer> stack) {
        characterIterator.setIndex(n2);
        return 0;
    }

    public synchronized void handleChar(int n, int n2) {
        if (n2 >= 0 && n2 < this.fHandled.length && n != Integer.MAX_VALUE && !this.fHandled[n2].contains(n)) {
            int n3 = UCharacter.getIntPropertyValue(n, 4106);
            this.fHandled[n2].applyIntPropertyValue(4106, n3);
        }
    }
}


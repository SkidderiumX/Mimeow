/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.impl.ICUDebug;
import com.ibm.icu.text.RuleBasedBreakIterator;
import com.ibm.icu.util.ULocale;
import java.lang.ref.SoftReference;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Locale;
import java.util.MissingResourceException;

public abstract class BreakIterator
implements Cloneable {
    private static final boolean DEBUG = ICUDebug.enabled("breakiterator");
    public static final int DONE = -1;
    public static final int KIND_CHARACTER = 0;
    public static final int KIND_WORD = 1;
    public static final int KIND_LINE = 2;
    public static final int KIND_SENTENCE = 3;
    public static final int KIND_TITLE = 4;
    private static final int KIND_COUNT = 5;
    private static final SoftReference<?>[] iterCache = new SoftReference[5];
    private static BreakIteratorServiceShim shim;
    private ULocale validLocale;
    private ULocale actualLocale;

    protected BreakIterator() {
    }

    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new IllegalStateException();
        }
    }

    public abstract int first();

    public abstract int last();

    public abstract int next(int var1);

    public abstract int next();

    public abstract int previous();

    public abstract int following(int var1);

    public int preceding(int n) {
        int n2 = this.following(n);
        while (n2 >= n && n2 != -1) {
            n2 = this.previous();
        }
        return n2;
    }

    public boolean isBoundary(int n) {
        if (n == 0) {
            return true;
        }
        return this.following(n - 1) == n;
    }

    public abstract int current();

    public abstract CharacterIterator getText();

    public void setText(String string) {
        this.setText(new StringCharacterIterator(string));
    }

    public abstract void setText(CharacterIterator var1);

    public static BreakIterator getWordInstance() {
        return BreakIterator.getWordInstance(ULocale.getDefault());
    }

    public static BreakIterator getWordInstance(Locale locale) {
        return BreakIterator.getBreakInstance(ULocale.forLocale(locale), 1);
    }

    public static BreakIterator getWordInstance(ULocale uLocale) {
        return BreakIterator.getBreakInstance(uLocale, 1);
    }

    public static BreakIterator getLineInstance() {
        return BreakIterator.getLineInstance(ULocale.getDefault());
    }

    public static BreakIterator getLineInstance(Locale locale) {
        return BreakIterator.getBreakInstance(ULocale.forLocale(locale), 2);
    }

    public static BreakIterator getLineInstance(ULocale uLocale) {
        return BreakIterator.getBreakInstance(uLocale, 2);
    }

    public static BreakIterator getCharacterInstance() {
        return BreakIterator.getCharacterInstance(ULocale.getDefault());
    }

    public static BreakIterator getCharacterInstance(Locale locale) {
        return BreakIterator.getBreakInstance(ULocale.forLocale(locale), 0);
    }

    public static BreakIterator getCharacterInstance(ULocale uLocale) {
        return BreakIterator.getBreakInstance(uLocale, 0);
    }

    public static BreakIterator getSentenceInstance() {
        return BreakIterator.getSentenceInstance(ULocale.getDefault());
    }

    public static BreakIterator getSentenceInstance(Locale locale) {
        return BreakIterator.getBreakInstance(ULocale.forLocale(locale), 3);
    }

    public static BreakIterator getSentenceInstance(ULocale uLocale) {
        return BreakIterator.getBreakInstance(uLocale, 3);
    }

    public static BreakIterator getTitleInstance() {
        return BreakIterator.getTitleInstance(ULocale.getDefault());
    }

    public static BreakIterator getTitleInstance(Locale locale) {
        return BreakIterator.getBreakInstance(ULocale.forLocale(locale), 4);
    }

    public static BreakIterator getTitleInstance(ULocale uLocale) {
        return BreakIterator.getBreakInstance(uLocale, 4);
    }

    public static Object registerInstance(BreakIterator breakIterator, Locale locale, int n) {
        return BreakIterator.registerInstance(breakIterator, ULocale.forLocale(locale), n);
    }

    public static Object registerInstance(BreakIterator breakIterator, ULocale uLocale, int n) {
        BreakIteratorCache breakIteratorCache;
        if (iterCache[n] != null && (breakIteratorCache = (BreakIteratorCache)iterCache[n].get()) != null && breakIteratorCache.getLocale().equals(uLocale)) {
            BreakIterator.iterCache[n] = null;
        }
        return BreakIterator.getShim().registerInstance(breakIterator, uLocale, n);
    }

    public static boolean unregister(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("registry key must not be null");
        }
        if (shim != null) {
            for (int i = 0; i < 5; ++i) {
                BreakIterator.iterCache[i] = null;
            }
            return shim.unregister(object);
        }
        return false;
    }

    public static BreakIterator getBreakInstance(ULocale uLocale, int n) {
        Object object;
        if (iterCache[n] != null && (object = (BreakIteratorCache)iterCache[n].get()) != null && ((BreakIteratorCache)object).getLocale().equals(uLocale)) {
            return ((BreakIteratorCache)object).createBreakInstance();
        }
        object = BreakIterator.getShim().createBreakIterator(uLocale, n);
        BreakIteratorCache breakIteratorCache = new BreakIteratorCache(uLocale, (BreakIterator)object);
        BreakIterator.iterCache[n] = new SoftReference<BreakIteratorCache>(breakIteratorCache);
        if (object instanceof RuleBasedBreakIterator) {
            RuleBasedBreakIterator ruleBasedBreakIterator = (RuleBasedBreakIterator)object;
            ruleBasedBreakIterator.setBreakType(n);
        }
        return object;
    }

    public static synchronized Locale[] getAvailableLocales() {
        return BreakIterator.getShim().getAvailableLocales();
    }

    public static synchronized ULocale[] getAvailableULocales() {
        return BreakIterator.getShim().getAvailableULocales();
    }

    private static BreakIteratorServiceShim getShim() {
        if (shim == null) {
            try {
                Class<?> clazz = Class.forName("com.ibm.icu.text.BreakIteratorFactory");
                shim = (BreakIteratorServiceShim)clazz.newInstance();
            }
            catch (MissingResourceException missingResourceException) {
                throw missingResourceException;
            }
            catch (Exception exception) {
                if (DEBUG) {
                    exception.printStackTrace();
                }
                throw new RuntimeException(exception.getMessage());
            }
        }
        return shim;
    }

    public final ULocale getLocale(ULocale.Type type) {
        return type == ULocale.ACTUAL_LOCALE ? this.actualLocale : this.validLocale;
    }

    final void setLocale(ULocale uLocale, ULocale uLocale2) {
        if (uLocale == null != (uLocale2 == null)) {
            throw new IllegalArgumentException();
        }
        this.validLocale = uLocale;
        this.actualLocale = uLocale2;
    }

    public static abstract class BreakIteratorServiceShim {
        BreakIteratorServiceShim() {
        }

        public abstract Object registerInstance(BreakIterator var1, ULocale var2, int var3);

        public abstract boolean unregister(Object var1);

        public abstract Locale[] getAvailableLocales();

        public abstract ULocale[] getAvailableULocales();

        public abstract BreakIterator createBreakIterator(ULocale var1, int var2);
    }

    private static final class BreakIteratorCache {
        private BreakIterator iter;
        private ULocale where;

        BreakIteratorCache(ULocale uLocale, BreakIterator breakIterator) {
            this.where = uLocale;
            this.iter = (BreakIterator)breakIterator.clone();
        }

        ULocale getLocale() {
            return this.where;
        }

        BreakIterator createBreakInstance() {
            return (BreakIterator)this.iter.clone();
        }
    }
}


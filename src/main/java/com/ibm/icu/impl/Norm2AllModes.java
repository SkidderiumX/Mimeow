/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl;

import com.ibm.icu.impl.CacheBase;
import com.ibm.icu.impl.Normalizer2Impl;
import com.ibm.icu.impl.SoftCache;
import com.ibm.icu.text.Normalizer;
import com.ibm.icu.text.Normalizer2;
import java.io.IOException;
import java.io.InputStream;

public class Norm2AllModes {
    public final Normalizer2Impl impl;
    public final ComposeNormalizer2 comp;
    public final DecomposeNormalizer2 decomp;
    public final FCDNormalizer2 fcd;
    public final ComposeNormalizer2 fcc;
    private static CacheBase<String, Norm2AllModes, InputStream> cache = new SoftCache<String, Norm2AllModes, InputStream>(){

        @Override
        protected Norm2AllModes createInstance(String string, InputStream inputStream2) {
            Normalizer2Impl normalizer2Impl = inputStream2 == null ? new Normalizer2Impl().load("data/icudt51b/" + string + ".nrm") : new Normalizer2Impl().load(inputStream2);
            return new Norm2AllModes(normalizer2Impl);
        }
    };
    public static final NoopNormalizer2 NOOP_NORMALIZER2 = new NoopNormalizer2();

    private Norm2AllModes(Normalizer2Impl normalizer2Impl) {
        this.impl = normalizer2Impl;
        this.comp = new ComposeNormalizer2(normalizer2Impl, false);
        this.decomp = new DecomposeNormalizer2(normalizer2Impl);
        this.fcd = new FCDNormalizer2(normalizer2Impl);
        this.fcc = new ComposeNormalizer2(normalizer2Impl, true);
    }

    private static Norm2AllModes getInstanceFromSingleton(Norm2AllModesSingleton norm2AllModesSingleton) {
        if (norm2AllModesSingleton.exception != null) {
            throw norm2AllModesSingleton.exception;
        }
        return norm2AllModesSingleton.allModes;
    }

    public static Norm2AllModes getNFCInstance() {
        return Norm2AllModes.getInstanceFromSingleton(NFCSingleton.INSTANCE);
    }

    public static Norm2AllModes getNFKCInstance() {
        return Norm2AllModes.getInstanceFromSingleton(NFKCSingleton.INSTANCE);
    }

    public static Norm2AllModes getNFKC_CFInstance() {
        return Norm2AllModes.getInstanceFromSingleton(NFKC_CFSingleton.INSTANCE);
    }

    public static Normalizer2WithImpl getN2WithImpl(int n) {
        switch (n) {
            case 0: {
                return Norm2AllModes.getNFCInstance().decomp;
            }
            case 1: {
                return Norm2AllModes.getNFKCInstance().decomp;
            }
            case 2: {
                return Norm2AllModes.getNFCInstance().comp;
            }
            case 3: {
                return Norm2AllModes.getNFKCInstance().comp;
            }
        }
        return null;
    }

    public static Norm2AllModes getInstance(InputStream inputStream2, String string) {
        Norm2AllModesSingleton norm2AllModesSingleton;
        if (inputStream2 == null && (norm2AllModesSingleton = string.equals("nfc") ? NFCSingleton.INSTANCE : (string.equals("nfkc") ? NFKCSingleton.INSTANCE : (string.equals("nfkc_cf") ? NFKC_CFSingleton.INSTANCE : null))) != null) {
            if (norm2AllModesSingleton.exception != null) {
                throw norm2AllModesSingleton.exception;
            }
            return norm2AllModesSingleton.allModes;
        }
        return cache.getInstance(string, inputStream2);
    }

    public static Normalizer2 getFCDNormalizer2() {
        return Norm2AllModes.getNFCInstance().fcd;
    }

    private static final class NFKC_CFSingleton {
        private static final Norm2AllModesSingleton INSTANCE = new Norm2AllModesSingleton("nfkc_cf");

        private NFKC_CFSingleton() {
        }
    }

    private static final class NFKCSingleton {
        private static final Norm2AllModesSingleton INSTANCE = new Norm2AllModesSingleton("nfkc");

        private NFKCSingleton() {
        }
    }

    private static final class NFCSingleton {
        private static final Norm2AllModesSingleton INSTANCE = new Norm2AllModesSingleton("nfc");

        private NFCSingleton() {
        }
    }

    private static final class Norm2AllModesSingleton {
        private Norm2AllModes allModes;
        private RuntimeException exception;

        private Norm2AllModesSingleton(String string) {
            try {
                Normalizer2Impl normalizer2Impl = new Normalizer2Impl().load("data/icudt51b/" + string + ".nrm");
                this.allModes = new Norm2AllModes(normalizer2Impl);
            }
            catch (RuntimeException runtimeException) {
                this.exception = runtimeException;
            }
        }
    }

    public static final class FCDNormalizer2
    extends Normalizer2WithImpl {
        public FCDNormalizer2(Normalizer2Impl normalizer2Impl) {
            super(normalizer2Impl);
        }

        protected void normalize(CharSequence charSequence, Normalizer2Impl.ReorderingBuffer reorderingBuffer) {
            this.impl.makeFCD(charSequence, 0, charSequence.length(), reorderingBuffer);
        }

        protected void normalizeAndAppend(CharSequence charSequence, boolean bl, Normalizer2Impl.ReorderingBuffer reorderingBuffer) {
            this.impl.makeFCDAndAppend(charSequence, bl, reorderingBuffer);
        }

        public int spanQuickCheckYes(CharSequence charSequence) {
            return this.impl.makeFCD(charSequence, 0, charSequence.length(), null);
        }

        public int getQuickCheck(int n) {
            return this.impl.isDecompYes(this.impl.getNorm16(n)) ? 1 : 0;
        }

        public boolean hasBoundaryBefore(int n) {
            return this.impl.hasFCDBoundaryBefore(n);
        }

        public boolean hasBoundaryAfter(int n) {
            return this.impl.hasFCDBoundaryAfter(n);
        }

        public boolean isInert(int n) {
            return this.impl.isFCDInert(n);
        }
    }

    public static final class ComposeNormalizer2
    extends Normalizer2WithImpl {
        private final boolean onlyContiguous;

        public ComposeNormalizer2(Normalizer2Impl normalizer2Impl, boolean bl) {
            super(normalizer2Impl);
            this.onlyContiguous = bl;
        }

        protected void normalize(CharSequence charSequence, Normalizer2Impl.ReorderingBuffer reorderingBuffer) {
            this.impl.compose(charSequence, 0, charSequence.length(), this.onlyContiguous, true, reorderingBuffer);
        }

        protected void normalizeAndAppend(CharSequence charSequence, boolean bl, Normalizer2Impl.ReorderingBuffer reorderingBuffer) {
            this.impl.composeAndAppend(charSequence, bl, this.onlyContiguous, reorderingBuffer);
        }

        public boolean isNormalized(CharSequence charSequence) {
            return this.impl.compose(charSequence, 0, charSequence.length(), this.onlyContiguous, false, new Normalizer2Impl.ReorderingBuffer(this.impl, new StringBuilder(), 5));
        }

        public Normalizer.QuickCheckResult quickCheck(CharSequence charSequence) {
            int n = this.impl.composeQuickCheck(charSequence, 0, charSequence.length(), this.onlyContiguous, false);
            if ((n & 1) != 0) {
                return Normalizer.MAYBE;
            }
            if (n >>> 1 == charSequence.length()) {
                return Normalizer.YES;
            }
            return Normalizer.NO;
        }

        public int spanQuickCheckYes(CharSequence charSequence) {
            return this.impl.composeQuickCheck(charSequence, 0, charSequence.length(), this.onlyContiguous, true) >>> 1;
        }

        public int getQuickCheck(int n) {
            return this.impl.getCompQuickCheck(this.impl.getNorm16(n));
        }

        public boolean hasBoundaryBefore(int n) {
            return this.impl.hasCompBoundaryBefore(n);
        }

        public boolean hasBoundaryAfter(int n) {
            return this.impl.hasCompBoundaryAfter(n, this.onlyContiguous, false);
        }

        public boolean isInert(int n) {
            return this.impl.hasCompBoundaryAfter(n, this.onlyContiguous, true);
        }
    }

    public static final class DecomposeNormalizer2
    extends Normalizer2WithImpl {
        public DecomposeNormalizer2(Normalizer2Impl normalizer2Impl) {
            super(normalizer2Impl);
        }

        protected void normalize(CharSequence charSequence, Normalizer2Impl.ReorderingBuffer reorderingBuffer) {
            this.impl.decompose(charSequence, 0, charSequence.length(), reorderingBuffer);
        }

        protected void normalizeAndAppend(CharSequence charSequence, boolean bl, Normalizer2Impl.ReorderingBuffer reorderingBuffer) {
            this.impl.decomposeAndAppend(charSequence, bl, reorderingBuffer);
        }

        public int spanQuickCheckYes(CharSequence charSequence) {
            return this.impl.decompose(charSequence, 0, charSequence.length(), null);
        }

        public int getQuickCheck(int n) {
            return this.impl.isDecompYes(this.impl.getNorm16(n)) ? 1 : 0;
        }

        public boolean hasBoundaryBefore(int n) {
            return this.impl.hasDecompBoundary(n, true);
        }

        public boolean hasBoundaryAfter(int n) {
            return this.impl.hasDecompBoundary(n, false);
        }

        public boolean isInert(int n) {
            return this.impl.isDecompInert(n);
        }
    }

    public static abstract class Normalizer2WithImpl
    extends Normalizer2 {
        public final Normalizer2Impl impl;

        public Normalizer2WithImpl(Normalizer2Impl normalizer2Impl) {
            this.impl = normalizer2Impl;
        }

        public StringBuilder normalize(CharSequence charSequence, StringBuilder stringBuilder) {
            if (stringBuilder == charSequence) {
                throw new IllegalArgumentException();
            }
            stringBuilder.setLength(0);
            this.normalize(charSequence, new Normalizer2Impl.ReorderingBuffer(this.impl, stringBuilder, charSequence.length()));
            return stringBuilder;
        }

        public Appendable normalize(CharSequence charSequence, Appendable appendable) {
            if (appendable == charSequence) {
                throw new IllegalArgumentException();
            }
            Normalizer2Impl.ReorderingBuffer reorderingBuffer = new Normalizer2Impl.ReorderingBuffer(this.impl, appendable, charSequence.length());
            this.normalize(charSequence, reorderingBuffer);
            reorderingBuffer.flush();
            return appendable;
        }

        protected abstract void normalize(CharSequence var1, Normalizer2Impl.ReorderingBuffer var2);

        public StringBuilder normalizeSecondAndAppend(StringBuilder stringBuilder, CharSequence charSequence) {
            return this.normalizeSecondAndAppend(stringBuilder, charSequence, true);
        }

        public StringBuilder append(StringBuilder stringBuilder, CharSequence charSequence) {
            return this.normalizeSecondAndAppend(stringBuilder, charSequence, false);
        }

        public StringBuilder normalizeSecondAndAppend(StringBuilder stringBuilder, CharSequence charSequence, boolean bl) {
            if (stringBuilder == charSequence) {
                throw new IllegalArgumentException();
            }
            this.normalizeAndAppend(charSequence, bl, new Normalizer2Impl.ReorderingBuffer(this.impl, stringBuilder, stringBuilder.length() + charSequence.length()));
            return stringBuilder;
        }

        protected abstract void normalizeAndAppend(CharSequence var1, boolean var2, Normalizer2Impl.ReorderingBuffer var3);

        public String getDecomposition(int n) {
            return this.impl.getDecomposition(n);
        }

        public String getRawDecomposition(int n) {
            return this.impl.getRawDecomposition(n);
        }

        public int composePair(int n, int n2) {
            return this.impl.composePair(n, n2);
        }

        public int getCombiningClass(int n) {
            return this.impl.getCC(this.impl.getNorm16(n));
        }

        public boolean isNormalized(CharSequence charSequence) {
            return charSequence.length() == this.spanQuickCheckYes(charSequence);
        }

        public Normalizer.QuickCheckResult quickCheck(CharSequence charSequence) {
            return this.isNormalized(charSequence) ? Normalizer.YES : Normalizer.NO;
        }

        public int getQuickCheck(int n) {
            return 1;
        }
    }

    public static final class NoopNormalizer2
    extends Normalizer2 {
        public StringBuilder normalize(CharSequence charSequence, StringBuilder stringBuilder) {
            if (stringBuilder != charSequence) {
                stringBuilder.setLength(0);
                return stringBuilder.append(charSequence);
            }
            throw new IllegalArgumentException();
        }

        public Appendable normalize(CharSequence charSequence, Appendable appendable) {
            if (appendable != charSequence) {
                try {
                    return appendable.append(charSequence);
                }
                catch (IOException iOException) {
                    throw new RuntimeException(iOException);
                }
            }
            throw new IllegalArgumentException();
        }

        public StringBuilder normalizeSecondAndAppend(StringBuilder stringBuilder, CharSequence charSequence) {
            if (stringBuilder != charSequence) {
                return stringBuilder.append(charSequence);
            }
            throw new IllegalArgumentException();
        }

        public StringBuilder append(StringBuilder stringBuilder, CharSequence charSequence) {
            if (stringBuilder != charSequence) {
                return stringBuilder.append(charSequence);
            }
            throw new IllegalArgumentException();
        }

        public String getDecomposition(int n) {
            return null;
        }

        public boolean isNormalized(CharSequence charSequence) {
            return true;
        }

        public Normalizer.QuickCheckResult quickCheck(CharSequence charSequence) {
            return Normalizer.YES;
        }

        public int spanQuickCheckYes(CharSequence charSequence) {
            return charSequence.length();
        }

        public boolean hasBoundaryBefore(int n) {
            return true;
        }

        public boolean hasBoundaryAfter(int n) {
            return true;
        }

        public boolean isInert(int n) {
            return true;
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.impl.Norm2AllModes;
import com.ibm.icu.text.Normalizer;
import java.io.InputStream;

public abstract class Normalizer2 {
    public static Normalizer2 getNFCInstance() {
        return Norm2AllModes.getNFCInstance().comp;
    }

    public static Normalizer2 getNFDInstance() {
        return Norm2AllModes.getNFCInstance().decomp;
    }

    public static Normalizer2 getNFKCInstance() {
        return Norm2AllModes.getNFKCInstance().comp;
    }

    public static Normalizer2 getNFKDInstance() {
        return Norm2AllModes.getNFKCInstance().decomp;
    }

    public static Normalizer2 getNFKCCasefoldInstance() {
        return Norm2AllModes.getNFKC_CFInstance().comp;
    }

    public static Normalizer2 getInstance(InputStream inputStream2, String string, Mode mode) {
        Norm2AllModes norm2AllModes = Norm2AllModes.getInstance(inputStream2, string);
        switch (mode) {
            case COMPOSE: {
                return norm2AllModes.comp;
            }
            case DECOMPOSE: {
                return norm2AllModes.decomp;
            }
            case FCD: {
                return norm2AllModes.fcd;
            }
            case COMPOSE_CONTIGUOUS: {
                return norm2AllModes.fcc;
            }
        }
        return null;
    }

    public String normalize(CharSequence charSequence) {
        if (charSequence instanceof String) {
            int n = this.spanQuickCheckYes(charSequence);
            if (n == charSequence.length()) {
                return (String)charSequence;
            }
            StringBuilder stringBuilder = new StringBuilder(charSequence.length()).append(charSequence, 0, n);
            return this.normalizeSecondAndAppend(stringBuilder, charSequence.subSequence(n, charSequence.length())).toString();
        }
        return this.normalize(charSequence, new StringBuilder(charSequence.length())).toString();
    }

    public abstract StringBuilder normalize(CharSequence var1, StringBuilder var2);

    public abstract Appendable normalize(CharSequence var1, Appendable var2);

    public abstract StringBuilder normalizeSecondAndAppend(StringBuilder var1, CharSequence var2);

    public abstract StringBuilder append(StringBuilder var1, CharSequence var2);

    public abstract String getDecomposition(int var1);

    public String getRawDecomposition(int n) {
        return null;
    }

    public int composePair(int n, int n2) {
        return -1;
    }

    public int getCombiningClass(int n) {
        return 0;
    }

    public abstract boolean isNormalized(CharSequence var1);

    public abstract Normalizer.QuickCheckResult quickCheck(CharSequence var1);

    public abstract int spanQuickCheckYes(CharSequence var1);

    public abstract boolean hasBoundaryBefore(int var1);

    public abstract boolean hasBoundaryAfter(int var1);

    public abstract boolean isInert(int var1);

    protected Normalizer2() {
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static enum Mode {
        COMPOSE,
        DECOMPOSE,
        FCD,
        COMPOSE_CONTIGUOUS;

    }
}


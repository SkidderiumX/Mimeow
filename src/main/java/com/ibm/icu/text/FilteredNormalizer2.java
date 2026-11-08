/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.text.Normalizer;
import com.ibm.icu.text.Normalizer2;
import com.ibm.icu.text.UnicodeSet;
import java.io.IOException;

public class FilteredNormalizer2
extends Normalizer2 {
    private Normalizer2 norm2;
    private UnicodeSet set;

    public FilteredNormalizer2(Normalizer2 normalizer2, UnicodeSet unicodeSet) {
        this.norm2 = normalizer2;
        this.set = unicodeSet;
    }

    public StringBuilder normalize(CharSequence charSequence, StringBuilder stringBuilder) {
        if (stringBuilder == charSequence) {
            throw new IllegalArgumentException();
        }
        stringBuilder.setLength(0);
        this.normalize(charSequence, stringBuilder, UnicodeSet.SpanCondition.SIMPLE);
        return stringBuilder;
    }

    public Appendable normalize(CharSequence charSequence, Appendable appendable) {
        if (appendable == charSequence) {
            throw new IllegalArgumentException();
        }
        return this.normalize(charSequence, appendable, UnicodeSet.SpanCondition.SIMPLE);
    }

    public StringBuilder normalizeSecondAndAppend(StringBuilder stringBuilder, CharSequence charSequence) {
        return this.normalizeSecondAndAppend(stringBuilder, charSequence, true);
    }

    public StringBuilder append(StringBuilder stringBuilder, CharSequence charSequence) {
        return this.normalizeSecondAndAppend(stringBuilder, charSequence, false);
    }

    public String getDecomposition(int n) {
        return this.set.contains(n) ? this.norm2.getDecomposition(n) : null;
    }

    public String getRawDecomposition(int n) {
        return this.set.contains(n) ? this.norm2.getRawDecomposition(n) : null;
    }

    public int composePair(int n, int n2) {
        return this.set.contains(n) && this.set.contains(n2) ? this.norm2.composePair(n, n2) : -1;
    }

    public int getCombiningClass(int n) {
        return this.set.contains(n) ? this.norm2.getCombiningClass(n) : 0;
    }

    public boolean isNormalized(CharSequence charSequence) {
        UnicodeSet.SpanCondition spanCondition = UnicodeSet.SpanCondition.SIMPLE;
        int n = 0;
        while (n < charSequence.length()) {
            int n2 = this.set.span(charSequence, n, spanCondition);
            if (spanCondition == UnicodeSet.SpanCondition.NOT_CONTAINED) {
                spanCondition = UnicodeSet.SpanCondition.SIMPLE;
            } else {
                if (!this.norm2.isNormalized(charSequence.subSequence(n, n2))) {
                    return false;
                }
                spanCondition = UnicodeSet.SpanCondition.NOT_CONTAINED;
            }
            n = n2;
        }
        return true;
    }

    public Normalizer.QuickCheckResult quickCheck(CharSequence charSequence) {
        Normalizer.QuickCheckResult quickCheckResult = Normalizer.YES;
        UnicodeSet.SpanCondition spanCondition = UnicodeSet.SpanCondition.SIMPLE;
        int n = 0;
        while (n < charSequence.length()) {
            int n2 = this.set.span(charSequence, n, spanCondition);
            if (spanCondition == UnicodeSet.SpanCondition.NOT_CONTAINED) {
                spanCondition = UnicodeSet.SpanCondition.SIMPLE;
            } else {
                Normalizer.QuickCheckResult quickCheckResult2 = this.norm2.quickCheck(charSequence.subSequence(n, n2));
                if (quickCheckResult2 == Normalizer.NO) {
                    return quickCheckResult2;
                }
                if (quickCheckResult2 == Normalizer.MAYBE) {
                    quickCheckResult = quickCheckResult2;
                }
                spanCondition = UnicodeSet.SpanCondition.NOT_CONTAINED;
            }
            n = n2;
        }
        return quickCheckResult;
    }

    public int spanQuickCheckYes(CharSequence charSequence) {
        UnicodeSet.SpanCondition spanCondition = UnicodeSet.SpanCondition.SIMPLE;
        int n = 0;
        while (n < charSequence.length()) {
            int n2 = this.set.span(charSequence, n, spanCondition);
            if (spanCondition == UnicodeSet.SpanCondition.NOT_CONTAINED) {
                spanCondition = UnicodeSet.SpanCondition.SIMPLE;
            } else {
                int n3 = n + this.norm2.spanQuickCheckYes(charSequence.subSequence(n, n2));
                if (n3 < n2) {
                    return n3;
                }
                spanCondition = UnicodeSet.SpanCondition.NOT_CONTAINED;
            }
            n = n2;
        }
        return charSequence.length();
    }

    public boolean hasBoundaryBefore(int n) {
        return !this.set.contains(n) || this.norm2.hasBoundaryBefore(n);
    }

    public boolean hasBoundaryAfter(int n) {
        return !this.set.contains(n) || this.norm2.hasBoundaryAfter(n);
    }

    public boolean isInert(int n) {
        return !this.set.contains(n) || this.norm2.isInert(n);
    }

    private Appendable normalize(CharSequence charSequence, Appendable appendable, UnicodeSet.SpanCondition spanCondition) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            int n = 0;
            while (n < charSequence.length()) {
                int n2 = this.set.span(charSequence, n, spanCondition);
                int n3 = n2 - n;
                if (spanCondition == UnicodeSet.SpanCondition.NOT_CONTAINED) {
                    if (n3 != 0) {
                        appendable.append(charSequence, n, n2);
                    }
                    spanCondition = UnicodeSet.SpanCondition.SIMPLE;
                } else {
                    if (n3 != 0) {
                        appendable.append(this.norm2.normalize(charSequence.subSequence(n, n2), stringBuilder));
                    }
                    spanCondition = UnicodeSet.SpanCondition.NOT_CONTAINED;
                }
                n = n2;
            }
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        return appendable;
    }

    private StringBuilder normalizeSecondAndAppend(StringBuilder stringBuilder, CharSequence charSequence, boolean bl) {
        CharSequence charSequence2;
        if (stringBuilder == charSequence) {
            throw new IllegalArgumentException();
        }
        if (stringBuilder.length() == 0) {
            if (bl) {
                return this.normalize(charSequence, stringBuilder);
            }
            return stringBuilder.append(charSequence);
        }
        int n = this.set.span(charSequence, 0, UnicodeSet.SpanCondition.SIMPLE);
        if (n != 0) {
            charSequence2 = charSequence.subSequence(0, n);
            int n2 = this.set.spanBack(stringBuilder, Integer.MAX_VALUE, UnicodeSet.SpanCondition.SIMPLE);
            if (n2 == 0) {
                if (bl) {
                    this.norm2.normalizeSecondAndAppend(stringBuilder, charSequence2);
                } else {
                    this.norm2.append(stringBuilder, charSequence2);
                }
            } else {
                StringBuilder stringBuilder2 = new StringBuilder(stringBuilder.subSequence(n2, stringBuilder.length()));
                if (bl) {
                    this.norm2.normalizeSecondAndAppend(stringBuilder2, charSequence2);
                } else {
                    this.norm2.append(stringBuilder2, charSequence2);
                }
                stringBuilder.delete(n2, Integer.MAX_VALUE).append((CharSequence)stringBuilder2);
            }
        }
        if (n < charSequence.length()) {
            charSequence2 = charSequence.subSequence(n, charSequence.length());
            if (bl) {
                this.normalize(charSequence2, stringBuilder, UnicodeSet.SpanCondition.NOT_CONTAINED);
            } else {
                stringBuilder.append(charSequence2);
            }
        }
        return stringBuilder;
    }
}


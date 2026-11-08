/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl;

import com.ibm.icu.impl.UCharacterProperty;
import com.ibm.icu.text.UTF16;
import com.ibm.icu.text.UnicodeSet;
import java.util.ArrayList;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class UnicodeSetStringSpan {
    public static final int FWD = 32;
    public static final int BACK = 16;
    public static final int UTF16 = 8;
    public static final int CONTAINED = 2;
    public static final int NOT_CONTAINED = 1;
    public static final int ALL = 63;
    public static final int FWD_UTF16_CONTAINED = 42;
    public static final int FWD_UTF16_NOT_CONTAINED = 41;
    public static final int BACK_UTF16_CONTAINED = 26;
    public static final int BACK_UTF16_NOT_CONTAINED = 25;
    static final short ALL_CP_CONTAINED = 255;
    static final short LONG_SPAN = 254;
    private UnicodeSet spanSet;
    private UnicodeSet spanNotSet;
    private ArrayList<String> strings;
    private short[] spanLengths;
    private int maxLength16;
    private boolean all;
    private OffsetList offsets;

    public UnicodeSetStringSpan(UnicodeSet unicodeSet, ArrayList<String> arrayList, int n) {
        int n2;
        int n3;
        int n4;
        this.spanSet = new UnicodeSet(0, 0x10FFFF);
        this.strings = arrayList;
        this.all = n == 63;
        this.spanSet.retainAll(unicodeSet);
        if (0 != (n & 1)) {
            this.spanNotSet = this.spanSet;
        }
        this.offsets = new OffsetList();
        int n5 = this.strings.size();
        boolean bl = false;
        for (n4 = 0; n4 < n5; ++n4) {
            String string = this.strings.get(n4);
            n3 = string.length();
            n2 = this.spanSet.span(string, UnicodeSet.SpanCondition.CONTAINED);
            if (n2 < n3) {
                bl = true;
            }
            if (0 == (n & 8) || n3 <= this.maxLength16) continue;
            this.maxLength16 = n3;
        }
        if (!bl) {
            this.maxLength16 = 0;
            return;
        }
        if (this.all) {
            this.spanSet.freeze();
        }
        n3 = this.all ? n5 * 2 : n5;
        this.spanLengths = new short[n3];
        int n6 = this.all ? n5 : 0;
        for (n4 = 0; n4 < n5; ++n4) {
            String string = this.strings.get(n4);
            int n7 = string.length();
            n2 = this.spanSet.span(string, UnicodeSet.SpanCondition.CONTAINED);
            if (n2 < n7) {
                int n8;
                if (0 != (n & 8)) {
                    if (0 != (n & 2)) {
                        if (0 != (n & 0x20)) {
                            this.spanLengths[n4] = UnicodeSetStringSpan.makeSpanLengthByte(n2);
                        }
                        if (0 != (n & 0x10)) {
                            n2 = n7 - this.spanSet.spanBack(string, n7, UnicodeSet.SpanCondition.CONTAINED);
                            this.spanLengths[n6 + n4] = UnicodeSetStringSpan.makeSpanLengthByte(n2);
                        }
                    } else {
                        this.spanLengths[n6 + n4] = 0;
                        this.spanLengths[n4] = 0;
                    }
                }
                if (0 == (n & 1)) continue;
                if (0 != (n & 0x20)) {
                    n8 = string.codePointAt(0);
                    this.addToSpanNotSet(n8);
                }
                if (0 == (n & 0x10)) continue;
                n8 = string.codePointBefore(n7);
                this.addToSpanNotSet(n8);
                continue;
            }
            if (this.all) {
                this.spanLengths[n6 + n4] = 255;
                this.spanLengths[n4] = 255;
                continue;
            }
            this.spanLengths[n4] = 255;
        }
        if (this.all) {
            this.spanNotSet.freeze();
        }
    }

    public UnicodeSetStringSpan(UnicodeSetStringSpan unicodeSetStringSpan, ArrayList<String> arrayList) {
        this.spanSet = unicodeSetStringSpan.spanSet;
        this.strings = arrayList;
        this.maxLength16 = unicodeSetStringSpan.maxLength16;
        this.all = true;
        this.spanNotSet = unicodeSetStringSpan.spanNotSet == unicodeSetStringSpan.spanSet ? this.spanSet : (UnicodeSet)unicodeSetStringSpan.spanNotSet.clone();
        this.offsets = new OffsetList();
        this.spanLengths = (short[])unicodeSetStringSpan.spanLengths.clone();
    }

    public boolean needsStringSpanUTF16() {
        return this.maxLength16 != 0;
    }

    public boolean contains(int n) {
        return this.spanSet.contains(n);
    }

    private void addToSpanNotSet(int n) {
        if (this.spanNotSet == null || this.spanNotSet == this.spanSet) {
            if (this.spanSet.contains(n)) {
                return;
            }
            this.spanNotSet = this.spanSet.cloneAsThawed();
        }
        this.spanNotSet.add(n);
    }

    public synchronized int span(CharSequence charSequence, int n, int n2, UnicodeSet.SpanCondition spanCondition) {
        if (spanCondition == UnicodeSet.SpanCondition.NOT_CONTAINED) {
            return this.spanNot(charSequence, n, n2);
        }
        int n3 = this.spanSet.span(charSequence.subSequence(n, n + n2), UnicodeSet.SpanCondition.CONTAINED);
        if (n3 == n2) {
            return n2;
        }
        int n4 = 0;
        if (spanCondition == UnicodeSet.SpanCondition.CONTAINED) {
            n4 = this.maxLength16;
        }
        this.offsets.setMaxLength(n4);
        int n5 = n + n3;
        int n6 = n2 - n3;
        int n7 = this.strings.size();
        while (true) {
            int n8;
            int n9;
            int n10;
            if (spanCondition == UnicodeSet.SpanCondition.CONTAINED) {
                block1: for (n10 = 0; n10 < n7; ++n10) {
                    n9 = this.spanLengths[n10];
                    if (n9 == 255) continue;
                    String string = this.strings.get(n10);
                    n8 = string.length();
                    if (n9 >= 254) {
                        n9 = n8;
                        n9 = string.offsetByCodePoints(n9, -1);
                    }
                    if (n9 > n3) {
                        n9 = n3;
                    }
                    for (int i = n8 - n9; i <= n6; ++i) {
                        if (!this.offsets.containsOffset(i) && UnicodeSetStringSpan.matches16CPB(charSequence, n5 - n9, n2, string, n8)) {
                            if (i == n6) {
                                return n2;
                            }
                            this.offsets.addOffset(i);
                        }
                        if (n9 == 0) continue block1;
                        --n9;
                    }
                }
            } else {
                n9 = 0;
                int n11 = 0;
                block3: for (n10 = 0; n10 < n7; ++n10) {
                    n8 = this.spanLengths[n10];
                    String string = this.strings.get(n10);
                    int n12 = string.length();
                    if (n8 >= 254) {
                        n8 = n12;
                    }
                    if (n8 > n3) {
                        n8 = n3;
                    }
                    for (int i = n12 - n8; i <= n6 && n8 >= n11; --n8, ++i) {
                        if (n8 <= n11 && i <= n9 || !UnicodeSetStringSpan.matches16CPB(charSequence, n5 - n8, n2, string, n12)) continue;
                        n9 = i;
                        n11 = n8;
                        continue block3;
                    }
                }
                if (n9 != 0 || n11 != 0) {
                    n5 += n9;
                    if ((n6 -= n9) == 0) {
                        return n2;
                    }
                    n3 = 0;
                    continue;
                }
            }
            if (n3 != 0 || n5 == 0) {
                if (this.offsets.isEmpty()) {
                    return n5 - n;
                }
            } else {
                if (this.offsets.isEmpty()) {
                    n3 = this.spanSet.span(charSequence.subSequence(n5, n5 + n6), UnicodeSet.SpanCondition.CONTAINED);
                    if (n3 == n6 || n3 == 0) {
                        return n5 + n3 - n;
                    }
                    n5 += n3;
                    n6 -= n3;
                    continue;
                }
                n3 = UnicodeSetStringSpan.spanOne(this.spanSet, charSequence, n5, n6);
                if (n3 > 0) {
                    if (n3 == n6) {
                        return n2;
                    }
                    n5 += n3;
                    n6 -= n3;
                    this.offsets.shift(n3);
                    n3 = 0;
                    continue;
                }
            }
            n9 = this.offsets.popMinimum();
            n5 += n9;
            n6 -= n9;
            n3 = 0;
        }
    }

    public synchronized int spanBack(CharSequence charSequence, int n, UnicodeSet.SpanCondition spanCondition) {
        if (spanCondition == UnicodeSet.SpanCondition.NOT_CONTAINED) {
            return this.spanNotBack(charSequence, n);
        }
        int n2 = this.spanSet.spanBack(charSequence, n, UnicodeSet.SpanCondition.CONTAINED);
        if (n2 == 0) {
            return 0;
        }
        int n3 = n - n2;
        int n4 = 0;
        if (spanCondition == UnicodeSet.SpanCondition.CONTAINED) {
            n4 = this.maxLength16;
        }
        this.offsets.setMaxLength(n4);
        int n5 = this.strings.size();
        int n6 = 0;
        if (this.all) {
            n6 = n5;
        }
        while (true) {
            int n7;
            int n8;
            int n9;
            if (spanCondition == UnicodeSet.SpanCondition.CONTAINED) {
                block1: for (n9 = 0; n9 < n5; ++n9) {
                    int n10;
                    n8 = this.spanLengths[n6 + n9];
                    if (n8 == 255) continue;
                    String string = this.strings.get(n9);
                    n7 = string.length();
                    if (n8 >= 254) {
                        n8 = n7;
                        n10 = 0;
                        n10 = string.offsetByCodePoints(0, 1);
                        n8 -= n10;
                    }
                    if (n8 > n3) {
                        n8 = n3;
                    }
                    for (n10 = n7 - n8; n10 <= n2; ++n10) {
                        if (!this.offsets.containsOffset(n10) && UnicodeSetStringSpan.matches16CPB(charSequence, n2 - n10, n, string, n7)) {
                            if (n10 == n2) {
                                return 0;
                            }
                            this.offsets.addOffset(n10);
                        }
                        if (n8 == 0) continue block1;
                        --n8;
                    }
                }
            } else {
                n8 = 0;
                int n11 = 0;
                block3: for (n9 = 0; n9 < n5; ++n9) {
                    n7 = this.spanLengths[n6 + n9];
                    String string = this.strings.get(n9);
                    int n12 = string.length();
                    if (n7 >= 254) {
                        n7 = n12;
                    }
                    if (n7 > n3) {
                        n7 = n3;
                    }
                    for (int i = n12 - n7; i <= n2 && n7 >= n11; --n7, ++i) {
                        if (n7 <= n11 && i <= n8 || !UnicodeSetStringSpan.matches16CPB(charSequence, n2 - i, n, string, n12)) continue;
                        n8 = i;
                        n11 = n7;
                        continue block3;
                    }
                }
                if (n8 != 0 || n11 != 0) {
                    if ((n2 -= n8) == 0) {
                        return 0;
                    }
                    n3 = 0;
                    continue;
                }
            }
            if (n3 != 0 || n2 == n) {
                if (this.offsets.isEmpty()) {
                    return n2;
                }
            } else {
                if (this.offsets.isEmpty()) {
                    n8 = n2;
                    n2 = this.spanSet.spanBack(charSequence, n8, UnicodeSet.SpanCondition.CONTAINED);
                    n3 = n8 - n2;
                    if (n2 != 0 && n3 != 0) continue;
                    return n2;
                }
                n3 = UnicodeSetStringSpan.spanOneBack(this.spanSet, charSequence, n2);
                if (n3 > 0) {
                    if (n3 == n2) {
                        return 0;
                    }
                    n2 -= n3;
                    this.offsets.shift(n3);
                    n3 = 0;
                    continue;
                }
            }
            n2 -= this.offsets.popMinimum();
            n3 = 0;
        }
    }

    private int spanNot(CharSequence charSequence, int n, int n2) {
        int n3;
        int n4 = n;
        int n5 = n2;
        int n6 = this.strings.size();
        do {
            int n7;
            if ((n7 = this.spanNotSet.span(charSequence.subSequence(n4, n4 + n5), UnicodeSet.SpanCondition.NOT_CONTAINED)) == n5) {
                return n2;
            }
            n3 = UnicodeSetStringSpan.spanOne(this.spanSet, charSequence, n4 += n7, n5 -= n7);
            if (n3 > 0) {
                return n4 - n;
            }
            for (n7 = 0; n7 < n6; ++n7) {
                String string;
                int n8;
                if (this.spanLengths[n7] == 255 || (n8 = (string = this.strings.get(n7)).length()) > n5 || !UnicodeSetStringSpan.matches16CPB(charSequence, n4, n2, string, n8)) continue;
                return n4 - n;
            }
            n4 -= n3;
        } while ((n5 += n3) != 0);
        return n2;
    }

    private int spanNotBack(CharSequence charSequence, int n) {
        int n2;
        int n3 = n;
        int n4 = this.strings.size();
        do {
            if ((n3 = this.spanNotSet.spanBack(charSequence, n3, UnicodeSet.SpanCondition.NOT_CONTAINED)) == 0) {
                return 0;
            }
            n2 = UnicodeSetStringSpan.spanOneBack(this.spanSet, charSequence, n3);
            if (n2 > 0) {
                return n3;
            }
            for (int i = 0; i < n4; ++i) {
                String string;
                int n5;
                if (this.spanLengths[i] == 255 || (n5 = (string = this.strings.get(i)).length()) > n3 || !UnicodeSetStringSpan.matches16CPB(charSequence, n3 - n5, n, string, n5)) continue;
                return n3;
            }
        } while ((n3 += n2) != 0);
        return 0;
    }

    static short makeSpanLengthByte(int n) {
        return (short)(n < 254 ? (int)n : 254);
    }

    private static boolean matches16(CharSequence charSequence, int n, String string, int n2) {
        int n3 = n + n2;
        while (n2-- > 0) {
            if (charSequence.charAt(--n3) == string.charAt(n2)) continue;
            return false;
        }
        return true;
    }

    static boolean matches16CPB(CharSequence charSequence, int n, int n2, String string, int n3) {
        return !(0 < n && com.ibm.icu.text.UTF16.isLeadSurrogate(charSequence.charAt(n - 1)) && com.ibm.icu.text.UTF16.isTrailSurrogate(charSequence.charAt(n + 0)) || n3 < n2 && com.ibm.icu.text.UTF16.isLeadSurrogate(charSequence.charAt(n + n3 - 1)) && com.ibm.icu.text.UTF16.isTrailSurrogate(charSequence.charAt(n + n3)) || !UnicodeSetStringSpan.matches16(charSequence, n, string, n3));
    }

    static int spanOne(UnicodeSet unicodeSet, CharSequence charSequence, int n, int n2) {
        char c;
        char c2 = charSequence.charAt(n);
        if (c2 >= '\ud800' && c2 <= '\udbff' && n2 >= 2 && com.ibm.icu.text.UTF16.isTrailSurrogate(c = charSequence.charAt(n + 1))) {
            int n3 = UCharacterProperty.getRawSupplementary(c2, c);
            return unicodeSet.contains(n3) ? 2 : -2;
        }
        return unicodeSet.contains(c2) ? 1 : -1;
    }

    static int spanOneBack(UnicodeSet unicodeSet, CharSequence charSequence, int n) {
        char c;
        char c2 = charSequence.charAt(n - 1);
        if (c2 >= '\udc00' && c2 <= '\udfff' && n >= 2 && com.ibm.icu.text.UTF16.isLeadSurrogate(c = charSequence.charAt(n - 2))) {
            int n2 = UCharacterProperty.getRawSupplementary(c, c2);
            return unicodeSet.contains(n2) ? 2 : -2;
        }
        return unicodeSet.contains(c2) ? 1 : -1;
    }

    public static class OffsetList {
        private boolean[] list = new boolean[16];
        private int length;
        private int start;

        public void setMaxLength(int n) {
            if (n > this.list.length) {
                this.list = new boolean[n];
            }
            this.clear();
        }

        public void clear() {
            int n = this.list.length;
            while (n-- > 0) {
                this.list[n] = false;
            }
            this.length = 0;
            this.start = 0;
        }

        public boolean isEmpty() {
            return this.length == 0;
        }

        public void shift(int n) {
            int n2 = this.start + n;
            if (n2 >= this.list.length) {
                n2 -= this.list.length;
            }
            if (this.list[n2]) {
                this.list[n2] = false;
                --this.length;
            }
            this.start = n2;
        }

        public void addOffset(int n) {
            int n2 = this.start + n;
            if (n2 >= this.list.length) {
                n2 -= this.list.length;
            }
            this.list[n2] = true;
            ++this.length;
        }

        public boolean containsOffset(int n) {
            int n2 = this.start + n;
            if (n2 >= this.list.length) {
                n2 -= this.list.length;
            }
            return this.list[n2];
        }

        public int popMinimum() {
            int n = this.start;
            while (++n < this.list.length) {
                if (!this.list[n]) continue;
                this.list[n] = false;
                --this.length;
                int n2 = n - this.start;
                this.start = n;
                return n2;
            }
            int n3 = this.list.length - this.start;
            n = 0;
            while (!this.list[n]) {
                ++n;
            }
            this.list[n] = false;
            --this.length;
            this.start = n;
            return n3 + n;
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.pattern;

import java.util.ArrayList;
import java.util.List;

public abstract class NameAbbreviator {
    private static final NameAbbreviator DEFAULT = new NOPAbbreviator();

    public static NameAbbreviator getAbbreviator(String string) {
        if (string.length() > 0) {
            int n;
            String string2 = string.trim();
            if (string2.isEmpty()) {
                return DEFAULT;
            }
            for (n = 0; n < string2.length() && string2.charAt(n) >= '0' && string2.charAt(n) <= '9'; ++n) {
            }
            if (n == string2.length()) {
                return new MaxElementAbbreviator(Integer.parseInt(string2));
            }
            ArrayList<PatternAbbreviatorFragment> arrayList = new ArrayList<PatternAbbreviatorFragment>(5);
            for (int i = 0; i < string2.length() && i >= 0; ++i) {
                int n2;
                int n3 = i;
                if (string2.charAt(i) == '*') {
                    n2 = Integer.MAX_VALUE;
                    ++n3;
                } else if (string2.charAt(i) >= '0' && string2.charAt(i) <= '9') {
                    n2 = string2.charAt(i) - 48;
                    ++n3;
                } else {
                    n2 = 0;
                }
                char c = '\u0000';
                if (n3 < string2.length() && (c = string2.charAt(n3)) == '.') {
                    c = '\u0000';
                }
                arrayList.add(new PatternAbbreviatorFragment(n2, c));
                i = string2.indexOf(46, i);
                if (i == -1) break;
            }
            return new PatternAbbreviator(arrayList);
        }
        return DEFAULT;
    }

    public static NameAbbreviator getDefaultAbbreviator() {
        return DEFAULT;
    }

    public abstract String abbreviate(String var1);

    private static class PatternAbbreviator
    extends NameAbbreviator {
        private final PatternAbbreviatorFragment[] fragments;

        public PatternAbbreviator(List<PatternAbbreviatorFragment> list) {
            if (list.size() == 0) {
                throw new IllegalArgumentException("fragments must have at least one element");
            }
            this.fragments = new PatternAbbreviatorFragment[list.size()];
            list.toArray(this.fragments);
        }

        @Override
        public String abbreviate(String string) {
            int n = 0;
            StringBuilder stringBuilder = new StringBuilder(string);
            for (int i = 0; i < this.fragments.length - 1 && n < string.length(); ++i) {
                n = this.fragments[i].abbreviate(stringBuilder, n);
            }
            PatternAbbreviatorFragment patternAbbreviatorFragment = this.fragments[this.fragments.length - 1];
            while (n < string.length() && n >= 0) {
                n = patternAbbreviatorFragment.abbreviate(stringBuilder, n);
            }
            return stringBuilder.toString();
        }
    }

    private static class PatternAbbreviatorFragment {
        private final int charCount;
        private final char ellipsis;

        public PatternAbbreviatorFragment(int n, char c) {
            this.charCount = n;
            this.ellipsis = c;
        }

        public int abbreviate(StringBuilder stringBuilder, int n) {
            int n2 = stringBuilder.toString().indexOf(46, n);
            if (n2 != -1) {
                if (n2 - n > this.charCount) {
                    stringBuilder.delete(n + this.charCount, n2);
                    n2 = n + this.charCount;
                    if (this.ellipsis != '\u0000') {
                        stringBuilder.insert(n2, this.ellipsis);
                        ++n2;
                    }
                }
                ++n2;
            }
            return n2;
        }
    }

    private static class MaxElementAbbreviator
    extends NameAbbreviator {
        private final int count;

        public MaxElementAbbreviator(int n) {
            this.count = n < 1 ? 1 : n;
        }

        @Override
        public String abbreviate(String string) {
            int n = string.length() - 1;
            for (int i = this.count; i > 0; --i) {
                if ((n = string.lastIndexOf(46, n - 1)) != -1) continue;
                return string;
            }
            return string.substring(n + 1);
        }
    }

    private static class NOPAbbreviator
    extends NameAbbreviator {
        @Override
        public String abbreviate(String string) {
            return string;
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.AbstractIterator;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.CheckReturnValue;

@GwtCompatible(emulated=true)
public class Splitter {
    private final CharMatcher trimmer;
    private final boolean omitEmptyStrings;
    private final Strategy strategy;
    private final int limit;

    private Splitter(Strategy strategy) {
        this(strategy, false, CharMatcher.NONE, Integer.MAX_VALUE);
    }

    private Splitter(Strategy strategy, boolean bl, CharMatcher charMatcher, int n) {
        this.strategy = strategy;
        this.omitEmptyStrings = bl;
        this.trimmer = charMatcher;
        this.limit = n;
    }

    public static Splitter on(char c) {
        return Splitter.on(CharMatcher.is(c));
    }

    public static Splitter on(final CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return new Splitter(new Strategy(){

            public SplittingIterator iterator(Splitter splitter, CharSequence charSequence) {
                return new SplittingIterator(splitter, charSequence){

                    @Override
                    int separatorStart(int n) {
                        return charMatcher.indexIn(this.toSplit, n);
                    }

                    @Override
                    int separatorEnd(int n) {
                        return n + 1;
                    }
                };
            }
        });
    }

    public static Splitter on(final String string) {
        Preconditions.checkArgument(string.length() != 0, "The separator may not be the empty string.");
        return new Splitter(new Strategy(){

            public SplittingIterator iterator(Splitter splitter, CharSequence charSequence) {
                return new SplittingIterator(splitter, charSequence){

                    @Override
                    public int separatorStart(int n) {
                        int n2 = string.length();
                        int n3 = this.toSplit.length() - n2;
                        block0: for (int i = n; i <= n3; ++i) {
                            for (int j = 0; j < n2; ++j) {
                                if (this.toSplit.charAt(j + i) != string.charAt(j)) continue block0;
                            }
                            return i;
                        }
                        return -1;
                    }

                    @Override
                    public int separatorEnd(int n) {
                        return n + string.length();
                    }
                };
            }
        });
    }

    @GwtIncompatible(value="java.util.regex")
    public static Splitter on(final Pattern pattern) {
        Preconditions.checkNotNull(pattern);
        Preconditions.checkArgument(!pattern.matcher("").matches(), "The pattern may not match the empty string: %s", pattern);
        return new Splitter(new Strategy(){

            public SplittingIterator iterator(Splitter splitter, CharSequence charSequence) {
                final Matcher matcher = pattern.matcher(charSequence);
                return new SplittingIterator(splitter, charSequence){

                    @Override
                    public int separatorStart(int n) {
                        return matcher.find(n) ? matcher.start() : -1;
                    }

                    @Override
                    public int separatorEnd(int n) {
                        return matcher.end();
                    }
                };
            }
        });
    }

    @GwtIncompatible(value="java.util.regex")
    public static Splitter onPattern(String string) {
        return Splitter.on(Pattern.compile(string));
    }

    public static Splitter fixedLength(final int n) {
        Preconditions.checkArgument(n > 0, "The length may not be less than 1");
        return new Splitter(new Strategy(){

            public SplittingIterator iterator(Splitter splitter, CharSequence charSequence) {
                return new SplittingIterator(splitter, charSequence){

                    @Override
                    public int separatorStart(int n) {
                        int n2 = n + n;
                        return n2 < this.toSplit.length() ? n2 : -1;
                    }

                    @Override
                    public int separatorEnd(int n) {
                        return n;
                    }
                };
            }
        });
    }

    @CheckReturnValue
    public Splitter omitEmptyStrings() {
        return new Splitter(this.strategy, true, this.trimmer, this.limit);
    }

    @CheckReturnValue
    public Splitter limit(int n) {
        Preconditions.checkArgument(n > 0, "must be greater than zero: %s", n);
        return new Splitter(this.strategy, this.omitEmptyStrings, this.trimmer, n);
    }

    @CheckReturnValue
    public Splitter trimResults() {
        return this.trimResults(CharMatcher.WHITESPACE);
    }

    @CheckReturnValue
    public Splitter trimResults(CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return new Splitter(this.strategy, this.omitEmptyStrings, charMatcher, this.limit);
    }

    public Iterable<String> split(final CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        return new Iterable<String>(){

            @Override
            public Iterator<String> iterator() {
                return Splitter.this.splittingIterator(charSequence);
            }

            public String toString() {
                return Joiner.on(", ").appendTo(new StringBuilder().append('['), (Iterable<?>)this).append(']').toString();
            }
        };
    }

    private Iterator<String> splittingIterator(CharSequence charSequence) {
        return this.strategy.iterator(this, charSequence);
    }

    @Beta
    public List<String> splitToList(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        Iterator<String> iterator2 = this.splittingIterator(charSequence);
        ArrayList<String> arrayList = new ArrayList<String>();
        while (iterator2.hasNext()) {
            arrayList.add(iterator2.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    @CheckReturnValue
    @Beta
    public MapSplitter withKeyValueSeparator(String string) {
        return this.withKeyValueSeparator(Splitter.on(string));
    }

    @CheckReturnValue
    @Beta
    public MapSplitter withKeyValueSeparator(char c) {
        return this.withKeyValueSeparator(Splitter.on(c));
    }

    @CheckReturnValue
    @Beta
    public MapSplitter withKeyValueSeparator(Splitter splitter) {
        return new MapSplitter(this, splitter);
    }

    private static abstract class SplittingIterator
    extends AbstractIterator<String> {
        final CharSequence toSplit;
        final CharMatcher trimmer;
        final boolean omitEmptyStrings;
        int offset = 0;
        int limit;

        abstract int separatorStart(int var1);

        abstract int separatorEnd(int var1);

        protected SplittingIterator(Splitter splitter, CharSequence charSequence) {
            this.trimmer = splitter.trimmer;
            this.omitEmptyStrings = splitter.omitEmptyStrings;
            this.limit = splitter.limit;
            this.toSplit = charSequence;
        }

        @Override
        protected String computeNext() {
            int n = this.offset;
            while (this.offset != -1) {
                int n2;
                int n3 = n;
                int n4 = this.separatorStart(this.offset);
                if (n4 == -1) {
                    n2 = this.toSplit.length();
                    this.offset = -1;
                } else {
                    n2 = n4;
                    this.offset = this.separatorEnd(n4);
                }
                if (this.offset == n) {
                    ++this.offset;
                    if (this.offset < this.toSplit.length()) continue;
                    this.offset = -1;
                    continue;
                }
                while (n3 < n2 && this.trimmer.matches(this.toSplit.charAt(n3))) {
                    ++n3;
                }
                while (n2 > n3 && this.trimmer.matches(this.toSplit.charAt(n2 - 1))) {
                    --n2;
                }
                if (this.omitEmptyStrings && n3 == n2) {
                    n = this.offset;
                    continue;
                }
                if (this.limit == 1) {
                    this.offset = -1;
                    for (n2 = this.toSplit.length(); n2 > n3 && this.trimmer.matches(this.toSplit.charAt(n2 - 1)); --n2) {
                    }
                } else {
                    --this.limit;
                }
                return this.toSplit.subSequence(n3, n2).toString();
            }
            return (String)this.endOfData();
        }
    }

    private static interface Strategy {
        public Iterator<String> iterator(Splitter var1, CharSequence var2);
    }

    @Beta
    public static final class MapSplitter {
        private static final String INVALID_ENTRY_MESSAGE = "Chunk [%s] is not a valid entry";
        private final Splitter outerSplitter;
        private final Splitter entrySplitter;

        private MapSplitter(Splitter splitter, Splitter splitter2) {
            this.outerSplitter = splitter;
            this.entrySplitter = Preconditions.checkNotNull(splitter2);
        }

        public Map<String, String> split(CharSequence charSequence) {
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
            for (String string : this.outerSplitter.split(charSequence)) {
                Iterator iterator2 = this.entrySplitter.splittingIterator(string);
                Preconditions.checkArgument(iterator2.hasNext(), INVALID_ENTRY_MESSAGE, string);
                String string2 = (String)iterator2.next();
                Preconditions.checkArgument(!linkedHashMap.containsKey(string2), "Duplicate key [%s] found.", string2);
                Preconditions.checkArgument(iterator2.hasNext(), INVALID_ENTRY_MESSAGE, string);
                String string3 = (String)iterator2.next();
                linkedHashMap.put(string2, string3);
                Preconditions.checkArgument(!iterator2.hasNext(), INVALID_ENTRY_MESSAGE, string);
            }
            return Collections.unmodifiableMap(linkedHashMap);
        }
    }
}


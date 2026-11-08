/*
 * Decompiled with CFR 0.152.
 */
package com.google.thirdparty.publicsuffix;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.thirdparty.publicsuffix.PublicSuffixType;
import java.util.List;

@GwtCompatible
public class TrieParser {
    private static final Joiner PREFIX_JOINER = Joiner.on("");

    TrieParser() {
    }

    static ImmutableMap<String, PublicSuffixType> parseTrie(CharSequence charSequence) {
        ImmutableMap.Builder<String, PublicSuffixType> builder = ImmutableMap.builder();
        int n = charSequence.length();
        for (int i = 0; i < n; i += TrieParser.doParseTrieToBuilder(Lists.<CharSequence>newLinkedList(), charSequence.subSequence(i, n), builder)) {
        }
        return builder.build();
    }

    private static int doParseTrieToBuilder(List<CharSequence> list, CharSequence charSequence, ImmutableMap.Builder<String, PublicSuffixType> builder) {
        String string;
        int n;
        int n2 = charSequence.length();
        char c = '\u0000';
        for (n = 0; n < n2 && (c = charSequence.charAt(n)) != '&' && c != '?' && c != '!' && c != ':' && c != ','; ++n) {
        }
        list.add(0, TrieParser.reverse(charSequence.subSequence(0, n)));
        if ((c == '!' || c == '?' || c == ':' || c == ',') && (string = PREFIX_JOINER.join(list)).length() > 0) {
            builder.put(string, PublicSuffixType.fromCode(c));
        }
        ++n;
        if (c != '?' && c != ',') {
            while (n < n2) {
                if (charSequence.charAt(n += TrieParser.doParseTrieToBuilder(list, charSequence.subSequence(n, n2), builder)) != '?' && charSequence.charAt(n) != ',') continue;
                ++n;
                break;
            }
        }
        list.remove(0);
        return n;
    }

    private static CharSequence reverse(CharSequence charSequence) {
        int n = charSequence.length();
        if (n <= 1) {
            return charSequence;
        }
        char[] cArray = new char[n];
        cArray[0] = charSequence.charAt(n - 1);
        for (int i = 1; i < n; ++i) {
            cArray[i] = charSequence.charAt(n - 1 - i);
            if (!Character.isSurrogatePair(cArray[i], cArray[i - 1])) continue;
            TrieParser.swap(cArray, i - 1, i);
        }
        return new String(cArray);
    }

    private static void swap(char[] cArray, int n, int n2) {
        char c = cArray[n];
        cArray[n] = cArray[n2];
        cArray[n2] = c;
    }
}


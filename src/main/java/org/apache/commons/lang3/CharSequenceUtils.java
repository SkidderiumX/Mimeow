/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3;

public class CharSequenceUtils {
    public static CharSequence subSequence(CharSequence charSequence, int n) {
        return charSequence == null ? null : charSequence.subSequence(n, charSequence.length());
    }

    static int indexOf(CharSequence charSequence, int n, int n2) {
        if (charSequence instanceof String) {
            return ((String)charSequence).indexOf(n, n2);
        }
        int n3 = charSequence.length();
        if (n2 < 0) {
            n2 = 0;
        }
        for (int i = n2; i < n3; ++i) {
            if (charSequence.charAt(i) != n) continue;
            return i;
        }
        return -1;
    }

    static int indexOf(CharSequence charSequence, CharSequence charSequence2, int n) {
        return charSequence.toString().indexOf(charSequence2.toString(), n);
    }

    static int lastIndexOf(CharSequence charSequence, int n, int n2) {
        if (charSequence instanceof String) {
            return ((String)charSequence).lastIndexOf(n, n2);
        }
        int n3 = charSequence.length();
        if (n2 < 0) {
            return -1;
        }
        if (n2 >= n3) {
            n2 = n3 - 1;
        }
        for (int i = n2; i >= 0; --i) {
            if (charSequence.charAt(i) != n) continue;
            return i;
        }
        return -1;
    }

    static int lastIndexOf(CharSequence charSequence, CharSequence charSequence2, int n) {
        return charSequence.toString().lastIndexOf(charSequence2.toString(), n);
    }

    static char[] toCharArray(CharSequence charSequence) {
        if (charSequence instanceof String) {
            return ((String)charSequence).toCharArray();
        }
        int n = charSequence.length();
        char[] cArray = new char[charSequence.length()];
        for (int i = 0; i < n; ++i) {
            cArray[i] = charSequence.charAt(i);
        }
        return cArray;
    }

    static boolean regionMatches(CharSequence charSequence, boolean bl, int n, CharSequence charSequence2, int n2, int n3) {
        if (charSequence instanceof String && charSequence2 instanceof String) {
            return ((String)charSequence).regionMatches(bl, n, (String)charSequence2, n2, n3);
        }
        int n4 = n;
        int n5 = n2;
        int n6 = n3;
        while (n6-- > 0) {
            char c;
            char c2;
            if ((c2 = charSequence.charAt(n4++)) == (c = charSequence2.charAt(n5++))) continue;
            if (!bl) {
                return false;
            }
            if (Character.toUpperCase(c2) == Character.toUpperCase(c) || Character.toLowerCase(c2) == Character.toLowerCase(c)) continue;
            return false;
        }
        return true;
    }
}


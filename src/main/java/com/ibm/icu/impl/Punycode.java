/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl;

import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.text.StringPrepParseException;
import com.ibm.icu.text.UTF16;

public class Punycode {
    private static final int BASE = 36;
    private static final int TMIN = 1;
    private static final int TMAX = 26;
    private static final int SKEW = 38;
    private static final int DAMP = 700;
    private static final int INITIAL_BIAS = 72;
    private static final int INITIAL_N = 128;
    private static final int HYPHEN = 45;
    private static final int DELIMITER = 45;
    private static final int ZERO = 48;
    private static final int SMALL_A = 97;
    private static final int SMALL_Z = 122;
    private static final int CAPITAL_A = 65;
    private static final int CAPITAL_Z = 90;
    private static final int MAX_CP_COUNT = 200;
    static final int[] basicToDigit = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    private static int adaptBias(int n, int n2, boolean bl) {
        n = bl ? (n /= 700) : (n /= 2);
        n += n / n2;
        int n3 = 0;
        while (n > 455) {
            n /= 35;
            n3 += 36;
        }
        return n3 + 36 * n / (n + 38);
    }

    private static char asciiCaseMap(char c, boolean bl) {
        if (bl) {
            if ('a' <= c && c <= 'z') {
                c = (char)(c - 32);
            }
        } else if ('A' <= c && c <= 'Z') {
            c = (char)(c + 32);
        }
        return c;
    }

    private static char digitToBasic(int n, boolean bl) {
        if (n < 26) {
            if (bl) {
                return (char)(65 + n);
            }
            return (char)(97 + n);
        }
        return (char)(22 + n);
    }

    public static StringBuilder encode(CharSequence charSequence, boolean[] blArray) throws StringPrepParseException {
        int n;
        int n2;
        int[] nArray = new int[200];
        int n3 = charSequence.length();
        int n4 = 200;
        char[] cArray = new char[n4];
        StringBuilder stringBuilder = new StringBuilder();
        int n5 = 0;
        int n6 = 0;
        for (n2 = 0; n2 < n3; ++n2) {
            char c;
            if (n6 == 200) {
                throw new IndexOutOfBoundsException();
            }
            char c2 = charSequence.charAt(n2);
            if (Punycode.isBasic(c2)) {
                if (n5 < n4) {
                    nArray[n6++] = 0;
                    cArray[n5] = blArray != null ? Punycode.asciiCaseMap(c2, blArray[n2]) : c2;
                }
                ++n5;
                continue;
            }
            n = (blArray != null && blArray[n2] ? 1 : 0) << 31;
            if (!UTF16.isSurrogate(c2)) {
                n |= c2;
            } else if (UTF16.isLeadSurrogate(c2) && n2 + 1 < n3 && UTF16.isTrailSurrogate(c = charSequence.charAt(n2 + 1))) {
                ++n2;
                n |= UCharacter.getCodePoint(c2, c);
            } else {
                throw new StringPrepParseException("Illegal char found", 1);
            }
            nArray[n6++] = n;
        }
        int n7 = n5;
        if (n7 > 0) {
            if (n5 < n4) {
                cArray[n5] = 45;
            }
            ++n5;
        }
        n = 128;
        int n8 = 0;
        int n9 = 72;
        int n10 = n7;
        while (n10 < n6) {
            int n11;
            int n12 = Integer.MAX_VALUE;
            for (n2 = 0; n2 < n6; ++n2) {
                n11 = nArray[n2] & Integer.MAX_VALUE;
                if (n > n11 || n11 >= n12) continue;
                n12 = n11;
            }
            if (n12 - n > (0x7FFFFF37 - n8) / (n10 + 1)) {
                throw new IllegalStateException("Internal program error");
            }
            n8 += (n12 - n) * (n10 + 1);
            n = n12;
            for (n2 = 0; n2 < n6; ++n2) {
                n11 = nArray[n2] & Integer.MAX_VALUE;
                if (n11 < n) {
                    ++n8;
                    continue;
                }
                if (n11 != n) continue;
                n11 = n8;
                int n13 = 36;
                while (true) {
                    int n14;
                    if ((n14 = n13 - n9) < 1) {
                        n14 = 1;
                    } else if (n13 >= n9 + 26) {
                        n14 = 26;
                    }
                    if (n11 < n14) break;
                    if (n5 < n4) {
                        cArray[n5++] = Punycode.digitToBasic(n14 + (n11 - n14) % (36 - n14), false);
                    }
                    n11 = (n11 - n14) / (36 - n14);
                    n13 += 36;
                }
                if (n5 < n4) {
                    cArray[n5++] = Punycode.digitToBasic(n11, nArray[n2] < 0);
                }
                n9 = Punycode.adaptBias(n8, n10 + 1, n10 == n7);
                n8 = 0;
                ++n10;
            }
            ++n8;
            ++n;
        }
        return stringBuilder.append(cArray, 0, n5);
    }

    private static boolean isBasic(int n) {
        return n < 128;
    }

    private static boolean isBasicUpperCase(int n) {
        return 65 <= n && n >= 90;
    }

    private static boolean isSurrogate(int n) {
        return (n & 0xFFFFF800) == 55296;
    }

    public static StringBuilder decode(CharSequence charSequence, boolean[] blArray) throws StringPrepParseException {
        int n;
        int n2;
        int n3 = charSequence.length();
        StringBuilder stringBuilder = new StringBuilder();
        int n4 = 200;
        char[] cArray = new char[n4];
        int n5 = n3;
        while (n5 > 0 && charSequence.charAt(--n5) != '-') {
        }
        int n6 = n2 = n5;
        int n7 = n2;
        while (n5 > 0) {
            char c;
            if (!Punycode.isBasic(c = charSequence.charAt(--n5))) {
                throw new StringPrepParseException("Illegal char found", 0);
            }
            if (n5 >= n4) continue;
            cArray[n5] = c;
            if (blArray == null) continue;
            blArray[n5] = Punycode.isBasicUpperCase(c);
        }
        int n8 = 128;
        int n9 = 0;
        int n10 = 72;
        int n11 = 1000000000;
        int n12 = n = n6 > 0 ? n6 + 1 : 0;
        while (n < n3) {
            int n13 = n9;
            int n14 = 1;
            int n15 = 36;
            while (true) {
                int n16;
                if (n >= n3) {
                    throw new StringPrepParseException("Illegal char found", 1);
                }
                if ((n16 = basicToDigit[charSequence.charAt(n++) & 0xFF]) < 0) {
                    throw new StringPrepParseException("Invalid char found", 0);
                }
                if (n16 > (Integer.MAX_VALUE - n9) / n14) {
                    throw new StringPrepParseException("Illegal char found", 1);
                }
                n9 += n16 * n14;
                int n17 = n15 - n10;
                if (n17 < 1) {
                    n17 = 1;
                } else if (n15 >= n10 + 26) {
                    n17 = 26;
                }
                if (n16 < n17) break;
                if (n14 > Integer.MAX_VALUE / (36 - n17)) {
                    throw new StringPrepParseException("Illegal char found", 1);
                }
                n14 *= 36 - n17;
                n15 += 36;
            }
            n10 = Punycode.adaptBias(n9 - n13, ++n2, n13 == 0);
            if (n9 / n2 > Integer.MAX_VALUE - n8) {
                throw new StringPrepParseException("Illegal char found", 1);
            }
            n8 += n9 / n2;
            n9 %= n2;
            if (n8 > 0x10FFFF || Punycode.isSurrogate(n8)) {
                throw new StringPrepParseException("Illegal char found", 1);
            }
            int n18 = UTF16.getCharCount(n8);
            if (n7 + n18 < n4) {
                int n19;
                if (n9 <= n11) {
                    n19 = n9;
                    n11 = n18 > 1 ? n19 : ++n11;
                } else {
                    n19 = n11;
                    n19 = UTF16.moveCodePointOffset(cArray, 0, n7, n19, n9 - n19);
                }
                if (n19 < n7) {
                    System.arraycopy(cArray, n19, cArray, n19 + n18, n7 - n19);
                    if (blArray != null) {
                        System.arraycopy(blArray, n19, blArray, n19 + n18, n7 - n19);
                    }
                }
                if (n18 == 1) {
                    cArray[n19] = (char)n8;
                } else {
                    cArray[n19] = UTF16.getLeadSurrogate(n8);
                    cArray[n19 + 1] = UTF16.getTrailSurrogate(n8);
                }
                if (blArray != null) {
                    blArray[n19] = Punycode.isBasicUpperCase(charSequence.charAt(n - 1));
                    if (n18 == 2) {
                        blArray[n19 + 1] = false;
                    }
                }
            }
            n7 += n18;
            ++n9;
        }
        stringBuilder.append(cArray, 0, n7);
        return stringBuilder;
    }
}


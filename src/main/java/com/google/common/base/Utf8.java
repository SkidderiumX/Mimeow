/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;

@Beta
@GwtCompatible
public class Utf8 {
    public static int encodedLength(CharSequence charSequence) {
        int n;
        int n2;
        int n3 = n2 = charSequence.length();
        for (n = 0; n < n2 && charSequence.charAt(n) < '\u0080'; ++n) {
        }
        while (n < n2) {
            char c = charSequence.charAt(n);
            if (c < '\u0800') {
                n3 += 127 - c >>> 31;
            } else {
                n3 += Utf8.encodedLengthGeneral(charSequence, n);
                break;
            }
            ++n;
        }
        if (n3 < n2) {
            throw new IllegalArgumentException("UTF-8 length does not fit in int: " + ((long)n3 + 0x100000000L));
        }
        return n3;
    }

    private static int encodedLengthGeneral(CharSequence charSequence, int n) {
        int n2 = charSequence.length();
        int n3 = 0;
        for (int i = n; i < n2; ++i) {
            char c = charSequence.charAt(i);
            if (c < '\u0800') {
                n3 += 127 - c >>> 31;
                continue;
            }
            n3 += 2;
            if ('\ud800' > c || c > '\udfff') continue;
            int n4 = Character.codePointAt(charSequence, i);
            if (n4 < 65536) {
                throw new IllegalArgumentException("Unpaired surrogate at index " + i);
            }
            ++i;
        }
        return n3;
    }

    public static boolean isWellFormed(byte[] byArray) {
        return Utf8.isWellFormed(byArray, 0, byArray.length);
    }

    public static boolean isWellFormed(byte[] byArray, int n, int n2) {
        int n3 = n + n2;
        Preconditions.checkPositionIndexes(n, n3, byArray.length);
        for (int i = n; i < n3; ++i) {
            if (byArray[i] >= 0) continue;
            return Utf8.isWellFormedSlowPath(byArray, i, n3);
        }
        return true;
    }

    private static boolean isWellFormedSlowPath(byte[] byArray, int n, int n2) {
        int n3 = n;
        while (true) {
            byte by;
            byte by2;
            if (n3 >= n2) {
                return true;
            }
            if ((by2 = byArray[n3++]) >= 0) continue;
            if (by2 < -32) {
                if (n3 == n2) {
                    return false;
                }
                if (by2 >= -62 && byArray[n3++] <= -65) continue;
                return false;
            }
            if (by2 < -16) {
                if (n3 + 1 >= n2) {
                    return false;
                }
                if (!((by = byArray[n3++]) > -65 || by2 == -32 && by < -96 || by2 == -19 && -96 <= by) && byArray[n3++] <= -65) continue;
                return false;
            }
            if (n3 + 2 >= n2) {
                return false;
            }
            if ((by = byArray[n3++]) > -65 || (by2 << 28) + (by - -112) >> 30 != 0 || byArray[n3++] > -65 || byArray[n3++] > -65) break;
        }
        return false;
    }

    private Utf8() {
    }
}


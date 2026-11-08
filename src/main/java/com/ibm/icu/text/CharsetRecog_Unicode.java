/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.text.CharsetDetector;
import com.ibm.icu.text.CharsetMatch;
import com.ibm.icu.text.CharsetRecognizer;

public abstract class CharsetRecog_Unicode
extends CharsetRecognizer {
    CharsetRecog_Unicode() {
    }

    abstract String getName();

    abstract CharsetMatch match(CharsetDetector var1);

    public static class CharsetRecog_UTF_32_LE
    extends CharsetRecog_UTF_32 {
        CharsetRecog_UTF_32_LE() {
        }

        int getChar(byte[] byArray, int n) {
            return (byArray[n + 3] & 0xFF) << 24 | (byArray[n + 2] & 0xFF) << 16 | (byArray[n + 1] & 0xFF) << 8 | byArray[n + 0] & 0xFF;
        }

        String getName() {
            return "UTF-32LE";
        }
    }

    public static class CharsetRecog_UTF_32_BE
    extends CharsetRecog_UTF_32 {
        CharsetRecog_UTF_32_BE() {
        }

        int getChar(byte[] byArray, int n) {
            return (byArray[n + 0] & 0xFF) << 24 | (byArray[n + 1] & 0xFF) << 16 | (byArray[n + 2] & 0xFF) << 8 | byArray[n + 3] & 0xFF;
        }

        String getName() {
            return "UTF-32BE";
        }
    }

    public static abstract class CharsetRecog_UTF_32
    extends CharsetRecog_Unicode {
        CharsetRecog_UTF_32() {
        }

        abstract int getChar(byte[] var1, int var2);

        abstract String getName();

        CharsetMatch match(CharsetDetector charsetDetector) {
            byte[] byArray = charsetDetector.fRawInput;
            int n = charsetDetector.fRawLength / 4 * 4;
            int n2 = 0;
            int n3 = 0;
            boolean bl = false;
            int n4 = 0;
            if (n == 0) {
                return null;
            }
            if (this.getChar(byArray, 0) == 65279) {
                bl = true;
            }
            for (int i = 0; i < n; i += 4) {
                int n5 = this.getChar(byArray, i);
                if (n5 < 0 || n5 >= 0x10FFFF || n5 >= 55296 && n5 <= 57343) {
                    ++n3;
                    continue;
                }
                ++n2;
            }
            if (bl && n3 == 0) {
                n4 = 100;
            } else if (bl && n2 > n3 * 10) {
                n4 = 80;
            } else if (n2 > 3 && n3 == 0) {
                n4 = 100;
            } else if (n2 > 0 && n3 == 0) {
                n4 = 80;
            } else if (n2 > n3 * 10) {
                n4 = 25;
            }
            return n4 == 0 ? null : new CharsetMatch(charsetDetector, this, n4);
        }
    }

    public static class CharsetRecog_UTF_16_LE
    extends CharsetRecog_Unicode {
        CharsetRecog_UTF_16_LE() {
        }

        String getName() {
            return "UTF-16LE";
        }

        CharsetMatch match(CharsetDetector charsetDetector) {
            byte[] byArray = charsetDetector.fRawInput;
            if (byArray.length >= 2 && (byArray[0] & 0xFF) == 255 && (byArray[1] & 0xFF) == 254) {
                if (byArray.length >= 4 && byArray[2] == 0 && byArray[3] == 0) {
                    return null;
                }
                int n = 100;
                return new CharsetMatch(charsetDetector, this, n);
            }
            return null;
        }
    }

    public static class CharsetRecog_UTF_16_BE
    extends CharsetRecog_Unicode {
        CharsetRecog_UTF_16_BE() {
        }

        String getName() {
            return "UTF-16BE";
        }

        CharsetMatch match(CharsetDetector charsetDetector) {
            byte[] byArray = charsetDetector.fRawInput;
            if (byArray.length >= 2 && (byArray[0] & 0xFF) == 254 && (byArray[1] & 0xFF) == 255) {
                int n = 100;
                return new CharsetMatch(charsetDetector, this, n);
            }
            return null;
        }
    }
}


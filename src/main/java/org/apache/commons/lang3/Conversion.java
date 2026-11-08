/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3;

import java.util.UUID;

public class Conversion {
    public static int hexDigitToInt(char c) {
        int n = Character.digit(c, 16);
        if (n < 0) {
            throw new IllegalArgumentException("Cannot interpret '" + c + "' as a hexadecimal digit");
        }
        return n;
    }

    public static int hexDigitMsb0ToInt(char c) {
        switch (c) {
            case '0': {
                return 0;
            }
            case '1': {
                return 8;
            }
            case '2': {
                return 4;
            }
            case '3': {
                return 12;
            }
            case '4': {
                return 2;
            }
            case '5': {
                return 10;
            }
            case '6': {
                return 6;
            }
            case '7': {
                return 14;
            }
            case '8': {
                return 1;
            }
            case '9': {
                return 9;
            }
            case 'A': 
            case 'a': {
                return 5;
            }
            case 'B': 
            case 'b': {
                return 13;
            }
            case 'C': 
            case 'c': {
                return 3;
            }
            case 'D': 
            case 'd': {
                return 11;
            }
            case 'E': 
            case 'e': {
                return 7;
            }
            case 'F': 
            case 'f': {
                return 15;
            }
        }
        throw new IllegalArgumentException("Cannot interpret '" + c + "' as a hexadecimal digit");
    }

    public static boolean[] hexDigitToBinary(char c) {
        switch (c) {
            case '0': {
                return new boolean[]{false, false, false, false};
            }
            case '1': {
                return new boolean[]{true, false, false, false};
            }
            case '2': {
                return new boolean[]{false, true, false, false};
            }
            case '3': {
                return new boolean[]{true, true, false, false};
            }
            case '4': {
                return new boolean[]{false, false, true, false};
            }
            case '5': {
                return new boolean[]{true, false, true, false};
            }
            case '6': {
                return new boolean[]{false, true, true, false};
            }
            case '7': {
                return new boolean[]{true, true, true, false};
            }
            case '8': {
                return new boolean[]{false, false, false, true};
            }
            case '9': {
                return new boolean[]{true, false, false, true};
            }
            case 'A': 
            case 'a': {
                return new boolean[]{false, true, false, true};
            }
            case 'B': 
            case 'b': {
                return new boolean[]{true, true, false, true};
            }
            case 'C': 
            case 'c': {
                return new boolean[]{false, false, true, true};
            }
            case 'D': 
            case 'd': {
                return new boolean[]{true, false, true, true};
            }
            case 'E': 
            case 'e': {
                return new boolean[]{false, true, true, true};
            }
            case 'F': 
            case 'f': {
                return new boolean[]{true, true, true, true};
            }
        }
        throw new IllegalArgumentException("Cannot interpret '" + c + "' as a hexadecimal digit");
    }

    public static boolean[] hexDigitMsb0ToBinary(char c) {
        switch (c) {
            case '0': {
                return new boolean[]{false, false, false, false};
            }
            case '1': {
                return new boolean[]{false, false, false, true};
            }
            case '2': {
                return new boolean[]{false, false, true, false};
            }
            case '3': {
                return new boolean[]{false, false, true, true};
            }
            case '4': {
                return new boolean[]{false, true, false, false};
            }
            case '5': {
                return new boolean[]{false, true, false, true};
            }
            case '6': {
                return new boolean[]{false, true, true, false};
            }
            case '7': {
                return new boolean[]{false, true, true, true};
            }
            case '8': {
                return new boolean[]{true, false, false, false};
            }
            case '9': {
                return new boolean[]{true, false, false, true};
            }
            case 'A': 
            case 'a': {
                return new boolean[]{true, false, true, false};
            }
            case 'B': 
            case 'b': {
                return new boolean[]{true, false, true, true};
            }
            case 'C': 
            case 'c': {
                return new boolean[]{true, true, false, false};
            }
            case 'D': 
            case 'd': {
                return new boolean[]{true, true, false, true};
            }
            case 'E': 
            case 'e': {
                return new boolean[]{true, true, true, false};
            }
            case 'F': 
            case 'f': {
                return new boolean[]{true, true, true, true};
            }
        }
        throw new IllegalArgumentException("Cannot interpret '" + c + "' as a hexadecimal digit");
    }

    public static char binaryToHexDigit(boolean[] blArray) {
        return Conversion.binaryToHexDigit(blArray, 0);
    }

    public static char binaryToHexDigit(boolean[] blArray, int n) {
        if (blArray.length == 0) {
            throw new IllegalArgumentException("Cannot convert an empty array.");
        }
        if (blArray.length > n + 3 && blArray[n + 3]) {
            if (blArray.length > n + 2 && blArray[n + 2]) {
                if (blArray.length > n + 1 && blArray[n + 1]) {
                    if (blArray[n]) {
                        return 'f';
                    }
                    return 'e';
                }
                if (blArray[n]) {
                    return 'd';
                }
                return 'c';
            }
            if (blArray.length > n + 1 && blArray[n + 1]) {
                if (blArray[n]) {
                    return 'b';
                }
                return 'a';
            }
            if (blArray[n]) {
                return '9';
            }
            return '8';
        }
        if (blArray.length > n + 2 && blArray[n + 2]) {
            if (blArray.length > n + 1 && blArray[n + 1]) {
                if (blArray[n]) {
                    return '7';
                }
                return '6';
            }
            if (blArray[n]) {
                return '5';
            }
            return '4';
        }
        if (blArray.length > n + 1 && blArray[n + 1]) {
            if (blArray[n]) {
                return '3';
            }
            return '2';
        }
        if (blArray[n]) {
            return '1';
        }
        return '0';
    }

    public static char binaryToHexDigitMsb0_4bits(boolean[] blArray) {
        return Conversion.binaryToHexDigitMsb0_4bits(blArray, 0);
    }

    public static char binaryToHexDigitMsb0_4bits(boolean[] blArray, int n) {
        if (blArray.length > 8) {
            throw new IllegalArgumentException("src.length>8: src.length=" + blArray.length);
        }
        if (blArray.length - n < 4) {
            throw new IllegalArgumentException("src.length-srcPos<4: src.length=" + blArray.length + ", srcPos=" + n);
        }
        if (blArray[n + 3]) {
            if (blArray[n + 2]) {
                if (blArray[n + 1]) {
                    if (blArray[n]) {
                        return 'f';
                    }
                    return '7';
                }
                if (blArray[n]) {
                    return 'b';
                }
                return '3';
            }
            if (blArray[n + 1]) {
                if (blArray[n]) {
                    return 'd';
                }
                return '5';
            }
            if (blArray[n]) {
                return '9';
            }
            return '1';
        }
        if (blArray[n + 2]) {
            if (blArray[n + 1]) {
                if (blArray[n]) {
                    return 'e';
                }
                return '6';
            }
            if (blArray[n]) {
                return 'a';
            }
            return '2';
        }
        if (blArray[n + 1]) {
            if (blArray[n]) {
                return 'c';
            }
            return '4';
        }
        if (blArray[n]) {
            return '8';
        }
        return '0';
    }

    public static char binaryBeMsb0ToHexDigit(boolean[] blArray) {
        return Conversion.binaryBeMsb0ToHexDigit(blArray, 0);
    }

    public static char binaryBeMsb0ToHexDigit(boolean[] blArray, int n) {
        if (blArray.length == 0) {
            throw new IllegalArgumentException("Cannot convert an empty array.");
        }
        int n2 = blArray.length - 1 - n;
        int n3 = Math.min(4, n2 + 1);
        boolean[] blArray2 = new boolean[4];
        System.arraycopy(blArray, n2 + 1 - n3, blArray2, 4 - n3, n3);
        blArray = blArray2;
        n = 0;
        if (blArray[n]) {
            if (blArray.length > n + 1 && blArray[n + 1]) {
                if (blArray.length > n + 2 && blArray[n + 2]) {
                    if (blArray.length > n + 3 && blArray[n + 3]) {
                        return 'f';
                    }
                    return 'e';
                }
                if (blArray.length > n + 3 && blArray[n + 3]) {
                    return 'd';
                }
                return 'c';
            }
            if (blArray.length > n + 2 && blArray[n + 2]) {
                if (blArray.length > n + 3 && blArray[n + 3]) {
                    return 'b';
                }
                return 'a';
            }
            if (blArray.length > n + 3 && blArray[n + 3]) {
                return '9';
            }
            return '8';
        }
        if (blArray.length > n + 1 && blArray[n + 1]) {
            if (blArray.length > n + 2 && blArray[n + 2]) {
                if (blArray.length > n + 3 && blArray[n + 3]) {
                    return '7';
                }
                return '6';
            }
            if (blArray.length > n + 3 && blArray[n + 3]) {
                return '5';
            }
            return '4';
        }
        if (blArray.length > n + 2 && blArray[n + 2]) {
            if (blArray.length > n + 3 && blArray[n + 3]) {
                return '3';
            }
            return '2';
        }
        if (blArray.length > n + 3 && blArray[n + 3]) {
            return '1';
        }
        return '0';
    }

    public static char intToHexDigit(int n) {
        char c = Character.forDigit(n, 16);
        if (c == '\u0000') {
            throw new IllegalArgumentException("nibble value not between 0 and 15: " + n);
        }
        return c;
    }

    public static char intToHexDigitMsb0(int n) {
        switch (n) {
            case 0: {
                return '0';
            }
            case 1: {
                return '8';
            }
            case 2: {
                return '4';
            }
            case 3: {
                return 'c';
            }
            case 4: {
                return '2';
            }
            case 5: {
                return 'a';
            }
            case 6: {
                return '6';
            }
            case 7: {
                return 'e';
            }
            case 8: {
                return '1';
            }
            case 9: {
                return '9';
            }
            case 10: {
                return '5';
            }
            case 11: {
                return 'd';
            }
            case 12: {
                return '3';
            }
            case 13: {
                return 'b';
            }
            case 14: {
                return '7';
            }
            case 15: {
                return 'f';
            }
        }
        throw new IllegalArgumentException("nibble value not between 0 and 15: " + n);
    }

    public static long intArrayToLong(int[] nArray, int n, long l, int n2, int n3) {
        if (nArray.length == 0 && n == 0 || 0 == n3) {
            return l;
        }
        if ((n3 - 1) * 32 + n2 >= 64) {
            throw new IllegalArgumentException("(nInts-1)*32+dstPos is greather or equal to than 64");
        }
        long l2 = l;
        int n4 = 0;
        for (int i = 0; i < n3; ++i) {
            n4 = i * 32 + n2;
            long l3 = (0xFFFFFFFFL & (long)nArray[i + n]) << n4;
            long l4 = 0xFFFFFFFFL << n4;
            l2 = l2 & (l4 ^ 0xFFFFFFFFFFFFFFFFL) | l3;
        }
        return l2;
    }

    public static long shortArrayToLong(short[] sArray, int n, long l, int n2, int n3) {
        if (sArray.length == 0 && n == 0 || 0 == n3) {
            return l;
        }
        if ((n3 - 1) * 16 + n2 >= 64) {
            throw new IllegalArgumentException("(nShorts-1)*16+dstPos is greather or equal to than 64");
        }
        long l2 = l;
        int n4 = 0;
        for (int i = 0; i < n3; ++i) {
            n4 = i * 16 + n2;
            long l3 = (0xFFFFL & (long)sArray[i + n]) << n4;
            long l4 = 65535L << n4;
            l2 = l2 & (l4 ^ 0xFFFFFFFFFFFFFFFFL) | l3;
        }
        return l2;
    }

    public static int shortArrayToInt(short[] sArray, int n, int n2, int n3, int n4) {
        if (sArray.length == 0 && n == 0 || 0 == n4) {
            return n2;
        }
        if ((n4 - 1) * 16 + n3 >= 32) {
            throw new IllegalArgumentException("(nShorts-1)*16+dstPos is greather or equal to than 32");
        }
        int n5 = n2;
        int n6 = 0;
        for (int i = 0; i < n4; ++i) {
            n6 = i * 16 + n3;
            int n7 = (0xFFFF & sArray[i + n]) << n6;
            int n8 = 65535 << n6;
            n5 = n5 & ~n8 | n7;
        }
        return n5;
    }

    public static long byteArrayToLong(byte[] byArray, int n, long l, int n2, int n3) {
        if (byArray.length == 0 && n == 0 || 0 == n3) {
            return l;
        }
        if ((n3 - 1) * 8 + n2 >= 64) {
            throw new IllegalArgumentException("(nBytes-1)*8+dstPos is greather or equal to than 64");
        }
        long l2 = l;
        int n4 = 0;
        for (int i = 0; i < n3; ++i) {
            n4 = i * 8 + n2;
            long l3 = (0xFFL & (long)byArray[i + n]) << n4;
            long l4 = 255L << n4;
            l2 = l2 & (l4 ^ 0xFFFFFFFFFFFFFFFFL) | l3;
        }
        return l2;
    }

    public static int byteArrayToInt(byte[] byArray, int n, int n2, int n3, int n4) {
        if (byArray.length == 0 && n == 0 || 0 == n4) {
            return n2;
        }
        if ((n4 - 1) * 8 + n3 >= 32) {
            throw new IllegalArgumentException("(nBytes-1)*8+dstPos is greather or equal to than 32");
        }
        int n5 = n2;
        int n6 = 0;
        for (int i = 0; i < n4; ++i) {
            n6 = i * 8 + n3;
            int n7 = (0xFF & byArray[i + n]) << n6;
            int n8 = 255 << n6;
            n5 = n5 & ~n8 | n7;
        }
        return n5;
    }

    public static short byteArrayToShort(byte[] byArray, int n, short s, int n2, int n3) {
        if (byArray.length == 0 && n == 0 || 0 == n3) {
            return s;
        }
        if ((n3 - 1) * 8 + n2 >= 16) {
            throw new IllegalArgumentException("(nBytes-1)*8+dstPos is greather or equal to than 16");
        }
        short s2 = s;
        int n4 = 0;
        for (int i = 0; i < n3; ++i) {
            n4 = i * 8 + n2;
            int n5 = (0xFF & byArray[i + n]) << n4;
            int n6 = 255 << n4;
            s2 = (short)(s2 & ~n6 | n5);
        }
        return s2;
    }

    public static long hexToLong(String string, int n, long l, int n2, int n3) {
        if (0 == n3) {
            return l;
        }
        if ((n3 - 1) * 4 + n2 >= 64) {
            throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greather or equal to than 64");
        }
        long l2 = l;
        int n4 = 0;
        for (int i = 0; i < n3; ++i) {
            n4 = i * 4 + n2;
            long l3 = (0xFL & (long)Conversion.hexDigitToInt(string.charAt(i + n))) << n4;
            long l4 = 15L << n4;
            l2 = l2 & (l4 ^ 0xFFFFFFFFFFFFFFFFL) | l3;
        }
        return l2;
    }

    public static int hexToInt(String string, int n, int n2, int n3, int n4) {
        if (0 == n4) {
            return n2;
        }
        if ((n4 - 1) * 4 + n3 >= 32) {
            throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greather or equal to than 32");
        }
        int n5 = n2;
        int n6 = 0;
        for (int i = 0; i < n4; ++i) {
            n6 = i * 4 + n3;
            int n7 = (0xF & Conversion.hexDigitToInt(string.charAt(i + n))) << n6;
            int n8 = 15 << n6;
            n5 = n5 & ~n8 | n7;
        }
        return n5;
    }

    public static short hexToShort(String string, int n, short s, int n2, int n3) {
        if (0 == n3) {
            return s;
        }
        if ((n3 - 1) * 4 + n2 >= 16) {
            throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greather or equal to than 16");
        }
        short s2 = s;
        int n4 = 0;
        for (int i = 0; i < n3; ++i) {
            n4 = i * 4 + n2;
            int n5 = (0xF & Conversion.hexDigitToInt(string.charAt(i + n))) << n4;
            int n6 = 15 << n4;
            s2 = (short)(s2 & ~n6 | n5);
        }
        return s2;
    }

    public static byte hexToByte(String string, int n, byte by, int n2, int n3) {
        if (0 == n3) {
            return by;
        }
        if ((n3 - 1) * 4 + n2 >= 8) {
            throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greather or equal to than 8");
        }
        byte by2 = by;
        int n4 = 0;
        for (int i = 0; i < n3; ++i) {
            n4 = i * 4 + n2;
            int n5 = (0xF & Conversion.hexDigitToInt(string.charAt(i + n))) << n4;
            int n6 = 15 << n4;
            by2 = (byte)(by2 & ~n6 | n5);
        }
        return by2;
    }

    public static long binaryToLong(boolean[] blArray, int n, long l, int n2, int n3) {
        if (blArray.length == 0 && n == 0 || 0 == n3) {
            return l;
        }
        if (n3 - 1 + n2 >= 64) {
            throw new IllegalArgumentException("nBools-1+dstPos is greather or equal to than 64");
        }
        long l2 = l;
        int n4 = 0;
        for (int i = 0; i < n3; ++i) {
            n4 = i * 1 + n2;
            long l3 = (blArray[i + n] ? 1L : 0L) << n4;
            long l4 = 1L << n4;
            l2 = l2 & (l4 ^ 0xFFFFFFFFFFFFFFFFL) | l3;
        }
        return l2;
    }

    public static int binaryToInt(boolean[] blArray, int n, int n2, int n3, int n4) {
        if (blArray.length == 0 && n == 0 || 0 == n4) {
            return n2;
        }
        if (n4 - 1 + n3 >= 32) {
            throw new IllegalArgumentException("nBools-1+dstPos is greather or equal to than 32");
        }
        int n5 = n2;
        int n6 = 0;
        for (int i = 0; i < n4; ++i) {
            n6 = i * 1 + n3;
            int n7 = (blArray[i + n] ? 1 : 0) << n6;
            int n8 = 1 << n6;
            n5 = n5 & ~n8 | n7;
        }
        return n5;
    }

    public static short binaryToShort(boolean[] blArray, int n, short s, int n2, int n3) {
        if (blArray.length == 0 && n == 0 || 0 == n3) {
            return s;
        }
        if (n3 - 1 + n2 >= 16) {
            throw new IllegalArgumentException("nBools-1+dstPos is greather or equal to than 16");
        }
        short s2 = s;
        int n4 = 0;
        for (int i = 0; i < n3; ++i) {
            n4 = i * 1 + n2;
            int n5 = (blArray[i + n] ? 1 : 0) << n4;
            int n6 = 1 << n4;
            s2 = (short)(s2 & ~n6 | n5);
        }
        return s2;
    }

    public static byte binaryToByte(boolean[] blArray, int n, byte by, int n2, int n3) {
        if (blArray.length == 0 && n == 0 || 0 == n3) {
            return by;
        }
        if (n3 - 1 + n2 >= 8) {
            throw new IllegalArgumentException("nBools-1+dstPos is greather or equal to than 8");
        }
        byte by2 = by;
        int n4 = 0;
        for (int i = 0; i < n3; ++i) {
            n4 = i * 1 + n2;
            int n5 = (blArray[i + n] ? 1 : 0) << n4;
            int n6 = 1 << n4;
            by2 = (byte)(by2 & ~n6 | n5);
        }
        return by2;
    }

    public static int[] longToIntArray(long l, int n, int[] nArray, int n2, int n3) {
        if (0 == n3) {
            return nArray;
        }
        if ((n3 - 1) * 32 + n >= 64) {
            throw new IllegalArgumentException("(nInts-1)*32+srcPos is greather or equal to than 64");
        }
        int n4 = 0;
        for (int i = 0; i < n3; ++i) {
            n4 = i * 32 + n;
            nArray[n2 + i] = (int)(0xFFFFFFFFFFFFFFFFL & l >> n4);
        }
        return nArray;
    }

    public static short[] longToShortArray(long l, int n, short[] sArray, int n2, int n3) {
        if (0 == n3) {
            return sArray;
        }
        if ((n3 - 1) * 16 + n >= 64) {
            throw new IllegalArgumentException("(nShorts-1)*16+srcPos is greather or equal to than 64");
        }
        int n4 = 0;
        for (int i = 0; i < n3; ++i) {
            n4 = i * 16 + n;
            sArray[n2 + i] = (short)(0xFFFFL & l >> n4);
        }
        return sArray;
    }

    public static short[] intToShortArray(int n, int n2, short[] sArray, int n3, int n4) {
        if (0 == n4) {
            return sArray;
        }
        if ((n4 - 1) * 16 + n2 >= 32) {
            throw new IllegalArgumentException("(nShorts-1)*16+srcPos is greather or equal to than 32");
        }
        int n5 = 0;
        for (int i = 0; i < n4; ++i) {
            n5 = i * 16 + n2;
            sArray[n3 + i] = (short)(0xFFFF & n >> n5);
        }
        return sArray;
    }

    public static byte[] longToByteArray(long l, int n, byte[] byArray, int n2, int n3) {
        if (0 == n3) {
            return byArray;
        }
        if ((n3 - 1) * 8 + n >= 64) {
            throw new IllegalArgumentException("(nBytes-1)*8+srcPos is greather or equal to than 64");
        }
        int n4 = 0;
        for (int i = 0; i < n3; ++i) {
            n4 = i * 8 + n;
            byArray[n2 + i] = (byte)(0xFFL & l >> n4);
        }
        return byArray;
    }

    public static byte[] intToByteArray(int n, int n2, byte[] byArray, int n3, int n4) {
        if (0 == n4) {
            return byArray;
        }
        if ((n4 - 1) * 8 + n2 >= 32) {
            throw new IllegalArgumentException("(nBytes-1)*8+srcPos is greather or equal to than 32");
        }
        int n5 = 0;
        for (int i = 0; i < n4; ++i) {
            n5 = i * 8 + n2;
            byArray[n3 + i] = (byte)(0xFF & n >> n5);
        }
        return byArray;
    }

    public static byte[] shortToByteArray(short s, int n, byte[] byArray, int n2, int n3) {
        if (0 == n3) {
            return byArray;
        }
        if ((n3 - 1) * 8 + n >= 16) {
            throw new IllegalArgumentException("(nBytes-1)*8+srcPos is greather or equal to than 16");
        }
        int n4 = 0;
        for (int i = 0; i < n3; ++i) {
            n4 = i * 8 + n;
            byArray[n2 + i] = (byte)(0xFF & s >> n4);
        }
        return byArray;
    }

    public static String longToHex(long l, int n, String string, int n2, int n3) {
        if (0 == n3) {
            return string;
        }
        if ((n3 - 1) * 4 + n >= 64) {
            throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greather or equal to than 64");
        }
        StringBuilder stringBuilder = new StringBuilder(string);
        int n4 = 0;
        int n5 = stringBuilder.length();
        for (int i = 0; i < n3; ++i) {
            n4 = i * 4 + n;
            int n6 = (int)(0xFL & l >> n4);
            if (n2 + i == n5) {
                ++n5;
                stringBuilder.append(Conversion.intToHexDigit(n6));
                continue;
            }
            stringBuilder.setCharAt(n2 + i, Conversion.intToHexDigit(n6));
        }
        return stringBuilder.toString();
    }

    public static String intToHex(int n, int n2, String string, int n3, int n4) {
        if (0 == n4) {
            return string;
        }
        if ((n4 - 1) * 4 + n2 >= 32) {
            throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greather or equal to than 32");
        }
        StringBuilder stringBuilder = new StringBuilder(string);
        int n5 = 0;
        int n6 = stringBuilder.length();
        for (int i = 0; i < n4; ++i) {
            n5 = i * 4 + n2;
            int n7 = 0xF & n >> n5;
            if (n3 + i == n6) {
                ++n6;
                stringBuilder.append(Conversion.intToHexDigit(n7));
                continue;
            }
            stringBuilder.setCharAt(n3 + i, Conversion.intToHexDigit(n7));
        }
        return stringBuilder.toString();
    }

    public static String shortToHex(short s, int n, String string, int n2, int n3) {
        if (0 == n3) {
            return string;
        }
        if ((n3 - 1) * 4 + n >= 16) {
            throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greather or equal to than 16");
        }
        StringBuilder stringBuilder = new StringBuilder(string);
        int n4 = 0;
        int n5 = stringBuilder.length();
        for (int i = 0; i < n3; ++i) {
            n4 = i * 4 + n;
            int n6 = 0xF & s >> n4;
            if (n2 + i == n5) {
                ++n5;
                stringBuilder.append(Conversion.intToHexDigit(n6));
                continue;
            }
            stringBuilder.setCharAt(n2 + i, Conversion.intToHexDigit(n6));
        }
        return stringBuilder.toString();
    }

    public static String byteToHex(byte by, int n, String string, int n2, int n3) {
        if (0 == n3) {
            return string;
        }
        if ((n3 - 1) * 4 + n >= 8) {
            throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greather or equal to than 8");
        }
        StringBuilder stringBuilder = new StringBuilder(string);
        int n4 = 0;
        int n5 = stringBuilder.length();
        for (int i = 0; i < n3; ++i) {
            n4 = i * 4 + n;
            int n6 = 0xF & by >> n4;
            if (n2 + i == n5) {
                ++n5;
                stringBuilder.append(Conversion.intToHexDigit(n6));
                continue;
            }
            stringBuilder.setCharAt(n2 + i, Conversion.intToHexDigit(n6));
        }
        return stringBuilder.toString();
    }

    public static boolean[] longToBinary(long l, int n, boolean[] blArray, int n2, int n3) {
        if (0 == n3) {
            return blArray;
        }
        if (n3 - 1 + n >= 64) {
            throw new IllegalArgumentException("nBools-1+srcPos is greather or equal to than 64");
        }
        int n4 = 0;
        for (int i = 0; i < n3; ++i) {
            n4 = i * 1 + n;
            blArray[n2 + i] = (1L & l >> n4) != 0L;
        }
        return blArray;
    }

    public static boolean[] intToBinary(int n, int n2, boolean[] blArray, int n3, int n4) {
        if (0 == n4) {
            return blArray;
        }
        if (n4 - 1 + n2 >= 32) {
            throw new IllegalArgumentException("nBools-1+srcPos is greather or equal to than 32");
        }
        int n5 = 0;
        for (int i = 0; i < n4; ++i) {
            n5 = i * 1 + n2;
            blArray[n3 + i] = (1 & n >> n5) != 0;
        }
        return blArray;
    }

    public static boolean[] shortToBinary(short s, int n, boolean[] blArray, int n2, int n3) {
        if (0 == n3) {
            return blArray;
        }
        if (n3 - 1 + n >= 16) {
            throw new IllegalArgumentException("nBools-1+srcPos is greather or equal to than 16");
        }
        int n4 = 0;
        assert ((n3 - 1) * 1 < 16 - n);
        for (int i = 0; i < n3; ++i) {
            n4 = i * 1 + n;
            blArray[n2 + i] = (1 & s >> n4) != 0;
        }
        return blArray;
    }

    public static boolean[] byteToBinary(byte by, int n, boolean[] blArray, int n2, int n3) {
        if (0 == n3) {
            return blArray;
        }
        if (n3 - 1 + n >= 8) {
            throw new IllegalArgumentException("nBools-1+srcPos is greather or equal to than 8");
        }
        int n4 = 0;
        for (int i = 0; i < n3; ++i) {
            n4 = i * 1 + n;
            blArray[n2 + i] = (1 & by >> n4) != 0;
        }
        return blArray;
    }

    public static byte[] uuidToByteArray(UUID uUID, byte[] byArray, int n, int n2) {
        if (0 == n2) {
            return byArray;
        }
        if (n2 > 16) {
            throw new IllegalArgumentException("nBytes is greather than 16");
        }
        Conversion.longToByteArray(uUID.getMostSignificantBits(), 0, byArray, n, n2 > 8 ? 8 : n2);
        if (n2 >= 8) {
            Conversion.longToByteArray(uUID.getLeastSignificantBits(), 0, byArray, n + 8, n2 - 8);
        }
        return byArray;
    }

    public static UUID byteArrayToUuid(byte[] byArray, int n) {
        if (byArray.length - n < 16) {
            throw new IllegalArgumentException("Need at least 16 bytes for UUID");
        }
        return new UUID(Conversion.byteArrayToLong(byArray, n, 0L, 0, 8), Conversion.byteArrayToLong(byArray, n + 8, 0L, 0, 8));
    }
}


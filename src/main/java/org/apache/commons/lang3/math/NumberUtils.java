/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.math;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.apache.commons.lang3.StringUtils;

public class NumberUtils {
    public static final Long LONG_ZERO = 0L;
    public static final Long LONG_ONE = 1L;
    public static final Long LONG_MINUS_ONE = -1L;
    public static final Integer INTEGER_ZERO = 0;
    public static final Integer INTEGER_ONE = 1;
    public static final Integer INTEGER_MINUS_ONE = -1;
    public static final Short SHORT_ZERO = 0;
    public static final Short SHORT_ONE = 1;
    public static final Short SHORT_MINUS_ONE = -1;
    public static final Byte BYTE_ZERO = 0;
    public static final Byte BYTE_ONE = 1;
    public static final Byte BYTE_MINUS_ONE = -1;
    public static final Double DOUBLE_ZERO = 0.0;
    public static final Double DOUBLE_ONE = 1.0;
    public static final Double DOUBLE_MINUS_ONE = -1.0;
    public static final Float FLOAT_ZERO = Float.valueOf(0.0f);
    public static final Float FLOAT_ONE = Float.valueOf(1.0f);
    public static final Float FLOAT_MINUS_ONE = Float.valueOf(-1.0f);

    public static int toInt(String string) {
        return NumberUtils.toInt(string, 0);
    }

    public static int toInt(String string, int n) {
        if (string == null) {
            return n;
        }
        try {
            return Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            return n;
        }
    }

    public static long toLong(String string) {
        return NumberUtils.toLong(string, 0L);
    }

    public static long toLong(String string, long l) {
        if (string == null) {
            return l;
        }
        try {
            return Long.parseLong(string);
        }
        catch (NumberFormatException numberFormatException) {
            return l;
        }
    }

    public static float toFloat(String string) {
        return NumberUtils.toFloat(string, 0.0f);
    }

    public static float toFloat(String string, float f) {
        if (string == null) {
            return f;
        }
        try {
            return Float.parseFloat(string);
        }
        catch (NumberFormatException numberFormatException) {
            return f;
        }
    }

    public static double toDouble(String string) {
        return NumberUtils.toDouble(string, 0.0);
    }

    public static double toDouble(String string, double d) {
        if (string == null) {
            return d;
        }
        try {
            return Double.parseDouble(string);
        }
        catch (NumberFormatException numberFormatException) {
            return d;
        }
    }

    public static byte toByte(String string) {
        return NumberUtils.toByte(string, (byte)0);
    }

    public static byte toByte(String string, byte by) {
        if (string == null) {
            return by;
        }
        try {
            return Byte.parseByte(string);
        }
        catch (NumberFormatException numberFormatException) {
            return by;
        }
    }

    public static short toShort(String string) {
        return NumberUtils.toShort(string, (short)0);
    }

    public static short toShort(String string, short s) {
        if (string == null) {
            return s;
        }
        try {
            return Short.parseShort(string);
        }
        catch (NumberFormatException numberFormatException) {
            return s;
        }
    }

    public static Number createNumber(String string) throws NumberFormatException {
        Number number;
        String string2;
        String string3;
        String string4;
        if (string == null) {
            return null;
        }
        if (StringUtils.isBlank(string)) {
            throw new NumberFormatException("A blank string is not a valid number");
        }
        String[] stringArray = new String[]{"0x", "0X", "-0x", "-0X", "#", "-#"};
        int n = 0;
        String[] stringArray2 = stringArray;
        int n2 = stringArray2.length;
        for (int i = 0; i < n2; ++i) {
            string4 = stringArray2[i];
            if (!string.startsWith(string4)) continue;
            n += string4.length();
            break;
        }
        if (n > 0) {
            char c = '\u0000';
            for (n2 = n; n2 < string.length() && (c = string.charAt(n2)) == '0'; ++n2) {
                ++n;
            }
            n2 = string.length() - n;
            if (n2 > 16 || n2 == 16 && c > '7') {
                return NumberUtils.createBigInteger(string);
            }
            if (n2 > 8 || n2 == 8 && c > '7') {
                return NumberUtils.createLong(string);
            }
            return NumberUtils.createInteger(string);
        }
        char c = string.charAt(string.length() - 1);
        int n3 = string.indexOf(46);
        int n4 = string.indexOf(101) + string.indexOf(69) + 1;
        int n5 = 0;
        if (n3 > -1) {
            if (n4 > -1) {
                if (n4 < n3 || n4 > string.length()) {
                    throw new NumberFormatException(string + " is not a valid number.");
                }
                string3 = string.substring(n3 + 1, n4);
            } else {
                string3 = string.substring(n3 + 1);
            }
            string2 = string.substring(0, n3);
            n5 = string3.length();
        } else {
            if (n4 > -1) {
                if (n4 > string.length()) {
                    throw new NumberFormatException(string + " is not a valid number.");
                }
                string2 = string.substring(0, n4);
            } else {
                string2 = string;
            }
            string3 = null;
        }
        if (!Character.isDigit(c) && c != '.') {
            string4 = n4 > -1 && n4 < string.length() - 1 ? string.substring(n4 + 1, string.length() - 1) : null;
            String string5 = string.substring(0, string.length() - 1);
            boolean bl = NumberUtils.isAllZeros(string2) && NumberUtils.isAllZeros(string4);
            switch (c) {
                case 'L': 
                case 'l': {
                    if (string3 == null && string4 == null && (string5.charAt(0) == '-' && NumberUtils.isDigits(string5.substring(1)) || NumberUtils.isDigits(string5))) {
                        try {
                            return NumberUtils.createLong(string5);
                        }
                        catch (NumberFormatException numberFormatException) {
                            return NumberUtils.createBigInteger(string5);
                        }
                    }
                    throw new NumberFormatException(string + " is not a valid number.");
                }
                case 'F': 
                case 'f': {
                    Number number2;
                    try {
                        number2 = NumberUtils.createFloat(string5);
                        if (!((Float)number2).isInfinite() && (((Float)number2).floatValue() != 0.0f || bl)) {
                            return number2;
                        }
                    }
                    catch (NumberFormatException numberFormatException) {
                        // empty catch block
                    }
                }
                case 'D': 
                case 'd': {
                    Number number2;
                    try {
                        number2 = NumberUtils.createDouble(string5);
                        if (!((Double)number2).isInfinite() && ((double)((Double)number2).floatValue() != 0.0 || bl)) {
                            return number2;
                        }
                    }
                    catch (NumberFormatException numberFormatException) {
                        // empty catch block
                    }
                    try {
                        return NumberUtils.createBigDecimal(string5);
                    }
                    catch (NumberFormatException numberFormatException) {
                        // empty catch block
                    }
                }
            }
            throw new NumberFormatException(string + " is not a valid number.");
        }
        string4 = n4 > -1 && n4 < string.length() - 1 ? string.substring(n4 + 1, string.length()) : null;
        if (string3 == null && string4 == null) {
            try {
                return NumberUtils.createInteger(string);
            }
            catch (NumberFormatException numberFormatException) {
                try {
                    return NumberUtils.createLong(string);
                }
                catch (NumberFormatException numberFormatException2) {
                    return NumberUtils.createBigInteger(string);
                }
            }
        }
        boolean bl = NumberUtils.isAllZeros(string2) && NumberUtils.isAllZeros(string4);
        try {
            if (n5 <= 7 && !((Float)(number = NumberUtils.createFloat(string))).isInfinite() && (((Float)number).floatValue() != 0.0f || bl)) {
                return number;
            }
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        try {
            if (n5 <= 16 && !((Double)(number = NumberUtils.createDouble(string))).isInfinite() && ((Double)number != 0.0 || bl)) {
                return number;
            }
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
        return NumberUtils.createBigDecimal(string);
    }

    private static boolean isAllZeros(String string) {
        if (string == null) {
            return true;
        }
        for (int i = string.length() - 1; i >= 0; --i) {
            if (string.charAt(i) == '0') continue;
            return false;
        }
        return string.length() > 0;
    }

    public static Float createFloat(String string) {
        if (string == null) {
            return null;
        }
        return Float.valueOf(string);
    }

    public static Double createDouble(String string) {
        if (string == null) {
            return null;
        }
        return Double.valueOf(string);
    }

    public static Integer createInteger(String string) {
        if (string == null) {
            return null;
        }
        return Integer.decode(string);
    }

    public static Long createLong(String string) {
        if (string == null) {
            return null;
        }
        return Long.decode(string);
    }

    public static BigInteger createBigInteger(String string) {
        if (string == null) {
            return null;
        }
        int n = 0;
        int n2 = 10;
        boolean bl = false;
        if (string.startsWith("-")) {
            bl = true;
            n = 1;
        }
        if (string.startsWith("0x", n) || string.startsWith("0x", n)) {
            n2 = 16;
            n += 2;
        } else if (string.startsWith("#", n)) {
            n2 = 16;
            ++n;
        } else if (string.startsWith("0", n) && string.length() > n + 1) {
            n2 = 8;
            ++n;
        }
        BigInteger bigInteger = new BigInteger(string.substring(n), n2);
        return bl ? bigInteger.negate() : bigInteger;
    }

    public static BigDecimal createBigDecimal(String string) {
        if (string == null) {
            return null;
        }
        if (StringUtils.isBlank(string)) {
            throw new NumberFormatException("A blank string is not a valid number");
        }
        if (string.trim().startsWith("--")) {
            throw new NumberFormatException(string + " is not a valid number.");
        }
        return new BigDecimal(string);
    }

    public static long min(long[] lArray) {
        NumberUtils.validateArray(lArray);
        long l = lArray[0];
        for (int i = 1; i < lArray.length; ++i) {
            if (lArray[i] >= l) continue;
            l = lArray[i];
        }
        return l;
    }

    public static int min(int[] nArray) {
        NumberUtils.validateArray(nArray);
        int n = nArray[0];
        for (int i = 1; i < nArray.length; ++i) {
            if (nArray[i] >= n) continue;
            n = nArray[i];
        }
        return n;
    }

    public static short min(short[] sArray) {
        NumberUtils.validateArray(sArray);
        short s = sArray[0];
        for (int i = 1; i < sArray.length; ++i) {
            if (sArray[i] >= s) continue;
            s = sArray[i];
        }
        return s;
    }

    public static byte min(byte[] byArray) {
        NumberUtils.validateArray(byArray);
        byte by = byArray[0];
        for (int i = 1; i < byArray.length; ++i) {
            if (byArray[i] >= by) continue;
            by = byArray[i];
        }
        return by;
    }

    public static double min(double[] dArray) {
        NumberUtils.validateArray(dArray);
        double d = dArray[0];
        for (int i = 1; i < dArray.length; ++i) {
            if (Double.isNaN(dArray[i])) {
                return Double.NaN;
            }
            if (!(dArray[i] < d)) continue;
            d = dArray[i];
        }
        return d;
    }

    public static float min(float[] fArray) {
        NumberUtils.validateArray(fArray);
        float f = fArray[0];
        for (int i = 1; i < fArray.length; ++i) {
            if (Float.isNaN(fArray[i])) {
                return Float.NaN;
            }
            if (!(fArray[i] < f)) continue;
            f = fArray[i];
        }
        return f;
    }

    public static long max(long[] lArray) {
        NumberUtils.validateArray(lArray);
        long l = lArray[0];
        for (int i = 1; i < lArray.length; ++i) {
            if (lArray[i] <= l) continue;
            l = lArray[i];
        }
        return l;
    }

    public static int max(int[] nArray) {
        NumberUtils.validateArray(nArray);
        int n = nArray[0];
        for (int i = 1; i < nArray.length; ++i) {
            if (nArray[i] <= n) continue;
            n = nArray[i];
        }
        return n;
    }

    public static short max(short[] sArray) {
        NumberUtils.validateArray(sArray);
        short s = sArray[0];
        for (int i = 1; i < sArray.length; ++i) {
            if (sArray[i] <= s) continue;
            s = sArray[i];
        }
        return s;
    }

    public static byte max(byte[] byArray) {
        NumberUtils.validateArray(byArray);
        byte by = byArray[0];
        for (int i = 1; i < byArray.length; ++i) {
            if (byArray[i] <= by) continue;
            by = byArray[i];
        }
        return by;
    }

    public static double max(double[] dArray) {
        NumberUtils.validateArray(dArray);
        double d = dArray[0];
        for (int i = 1; i < dArray.length; ++i) {
            if (Double.isNaN(dArray[i])) {
                return Double.NaN;
            }
            if (!(dArray[i] > d)) continue;
            d = dArray[i];
        }
        return d;
    }

    public static float max(float[] fArray) {
        NumberUtils.validateArray(fArray);
        float f = fArray[0];
        for (int i = 1; i < fArray.length; ++i) {
            if (Float.isNaN(fArray[i])) {
                return Float.NaN;
            }
            if (!(fArray[i] > f)) continue;
            f = fArray[i];
        }
        return f;
    }

    private static void validateArray(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("The Array must not be null");
        }
        if (Array.getLength(object) == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
    }

    public static long min(long l, long l2, long l3) {
        if (l2 < l) {
            l = l2;
        }
        if (l3 < l) {
            l = l3;
        }
        return l;
    }

    public static int min(int n, int n2, int n3) {
        if (n2 < n) {
            n = n2;
        }
        if (n3 < n) {
            n = n3;
        }
        return n;
    }

    public static short min(short s, short s2, short s3) {
        if (s2 < s) {
            s = s2;
        }
        if (s3 < s) {
            s = s3;
        }
        return s;
    }

    public static byte min(byte by, byte by2, byte by3) {
        if (by2 < by) {
            by = by2;
        }
        if (by3 < by) {
            by = by3;
        }
        return by;
    }

    public static double min(double d, double d2, double d3) {
        return Math.min(Math.min(d, d2), d3);
    }

    public static float min(float f, float f2, float f3) {
        return Math.min(Math.min(f, f2), f3);
    }

    public static long max(long l, long l2, long l3) {
        if (l2 > l) {
            l = l2;
        }
        if (l3 > l) {
            l = l3;
        }
        return l;
    }

    public static int max(int n, int n2, int n3) {
        if (n2 > n) {
            n = n2;
        }
        if (n3 > n) {
            n = n3;
        }
        return n;
    }

    public static short max(short s, short s2, short s3) {
        if (s2 > s) {
            s = s2;
        }
        if (s3 > s) {
            s = s3;
        }
        return s;
    }

    public static byte max(byte by, byte by2, byte by3) {
        if (by2 > by) {
            by = by2;
        }
        if (by3 > by) {
            by = by3;
        }
        return by;
    }

    public static double max(double d, double d2, double d3) {
        return Math.max(Math.max(d, d2), d3);
    }

    public static float max(float f, float f2, float f3) {
        return Math.max(Math.max(f, f2), f3);
    }

    public static boolean isDigits(String string) {
        if (StringUtils.isEmpty(string)) {
            return false;
        }
        for (int i = 0; i < string.length(); ++i) {
            if (Character.isDigit(string.charAt(i))) continue;
            return false;
        }
        return true;
    }

    public static boolean isNumber(String string) {
        int n;
        int n2;
        if (StringUtils.isEmpty(string)) {
            return false;
        }
        char[] cArray = string.toCharArray();
        int n3 = cArray.length;
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        int n4 = n2 = cArray[0] == '-' ? 1 : 0;
        if (n3 > n2 + 1 && cArray[n2] == '0') {
            if (cArray[n2 + 1] == 'x' || cArray[n2 + 1] == 'X') {
                int n5 = n2 + 2;
                if (n5 == n3) {
                    return false;
                }
                while (n5 < cArray.length) {
                    if (!(cArray[n5] >= '0' && cArray[n5] <= '9' || cArray[n5] >= 'a' && cArray[n5] <= 'f' || cArray[n5] >= 'A' && cArray[n5] <= 'F')) {
                        return false;
                    }
                    ++n5;
                }
                return true;
            }
            if (Character.isDigit(cArray[n2 + 1])) {
                for (int i = n2 + 1; i < cArray.length; ++i) {
                    if (cArray[i] >= '0' && cArray[i] <= '7') continue;
                    return false;
                }
                return true;
            }
        }
        --n3;
        for (n = n2; n < n3 || n < n3 + 1 && bl3 && !bl4; ++n) {
            if (cArray[n] >= '0' && cArray[n] <= '9') {
                bl4 = true;
                bl3 = false;
                continue;
            }
            if (cArray[n] == '.') {
                if (bl2 || bl) {
                    return false;
                }
                bl2 = true;
                continue;
            }
            if (cArray[n] == 'e' || cArray[n] == 'E') {
                if (bl) {
                    return false;
                }
                if (!bl4) {
                    return false;
                }
                bl = true;
                bl3 = true;
                continue;
            }
            if (cArray[n] == '+' || cArray[n] == '-') {
                if (!bl3) {
                    return false;
                }
                bl3 = false;
                bl4 = false;
                continue;
            }
            return false;
        }
        if (n < cArray.length) {
            if (cArray[n] >= '0' && cArray[n] <= '9') {
                return true;
            }
            if (cArray[n] == 'e' || cArray[n] == 'E') {
                return false;
            }
            if (cArray[n] == '.') {
                if (bl2 || bl) {
                    return false;
                }
                return bl4;
            }
            if (!(bl3 || cArray[n] != 'd' && cArray[n] != 'D' && cArray[n] != 'f' && cArray[n] != 'F')) {
                return bl4;
            }
            if (cArray[n] == 'l' || cArray[n] == 'L') {
                return bl4 && !bl && !bl2;
            }
            return false;
        }
        return !bl3 && bl4;
    }
}


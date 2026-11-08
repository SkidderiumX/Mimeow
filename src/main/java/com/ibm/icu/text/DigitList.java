/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import java.math.BigDecimal;
import java.math.BigInteger;

public class DigitList {
    public static final int MAX_LONG_DIGITS = 19;
    public static final int DBL_DIG = 17;
    public int decimalAt = 0;
    public int count = 0;
    public byte[] digits = new byte[19];
    private static byte[] LONG_MIN_REP;

    DigitList() {
    }

    private final void ensureCapacity(int n, int n2) {
        if (n > this.digits.length) {
            byte[] byArray = new byte[n * 2];
            System.arraycopy(this.digits, 0, byArray, 0, n2);
            this.digits = byArray;
        }
    }

    boolean isZero() {
        for (int i = 0; i < this.count; ++i) {
            if (this.digits[i] == 48) continue;
            return false;
        }
        return true;
    }

    public void append(int n) {
        this.ensureCapacity(this.count + 1, this.count);
        this.digits[this.count++] = (byte)n;
    }

    public byte getDigitValue(int n) {
        return (byte)(this.digits[n] - 48);
    }

    public final double getDouble() {
        if (this.count == 0) {
            return 0.0;
        }
        StringBuilder stringBuilder = new StringBuilder(this.count);
        stringBuilder.append('.');
        for (int i = 0; i < this.count; ++i) {
            stringBuilder.append((char)this.digits[i]);
        }
        stringBuilder.append('E');
        stringBuilder.append(Integer.toString(this.decimalAt));
        return Double.valueOf(stringBuilder.toString());
    }

    public final long getLong() {
        if (this.count == 0) {
            return 0L;
        }
        if (this.isLongMIN_VALUE()) {
            return Long.MIN_VALUE;
        }
        StringBuilder stringBuilder = new StringBuilder(this.count);
        for (int i = 0; i < this.decimalAt; ++i) {
            stringBuilder.append(i < this.count ? (char)this.digits[i] : (char)'0');
        }
        return Long.parseLong(stringBuilder.toString());
    }

    public BigInteger getBigInteger(boolean bl) {
        int n;
        int n2;
        if (this.isZero()) {
            return BigInteger.valueOf(0L);
        }
        int n3 = n2 = this.decimalAt > this.count ? this.decimalAt : this.count;
        if (!bl) {
            ++n2;
        }
        char[] cArray = new char[n2];
        int n4 = 0;
        if (!bl) {
            cArray[0] = 45;
            for (n = 0; n < this.count; ++n) {
                cArray[n + 1] = (char)this.digits[n];
            }
            n4 = this.count + 1;
        } else {
            for (n = 0; n < this.count; ++n) {
                cArray[n] = (char)this.digits[n];
            }
            n4 = this.count;
        }
        for (n = n4; n < cArray.length; ++n) {
            cArray[n] = 48;
        }
        return new BigInteger(new String(cArray));
    }

    private String getStringRep(boolean bl) {
        int n;
        if (this.isZero()) {
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder(this.count + 1);
        if (!bl) {
            stringBuilder.append('-');
        }
        if ((n = this.decimalAt) < 0) {
            stringBuilder.append('.');
            while (n < 0) {
                stringBuilder.append('0');
                ++n;
            }
            n = -1;
        }
        for (int i = 0; i < this.count; ++i) {
            if (n == i) {
                stringBuilder.append('.');
            }
            stringBuilder.append((char)this.digits[i]);
        }
        while (n-- > this.count) {
            stringBuilder.append('0');
        }
        return stringBuilder.toString();
    }

    public BigDecimal getBigDecimal(boolean bl) {
        if (this.isZero()) {
            return BigDecimal.valueOf(0L);
        }
        long l = (long)this.count - (long)this.decimalAt;
        if (l > 0L) {
            int n = this.count;
            if (l > Integer.MAX_VALUE) {
                long l2 = l - Integer.MAX_VALUE;
                if (l2 < (long)this.count) {
                    n = (int)((long)n - l2);
                } else {
                    return new BigDecimal(0);
                }
            }
            StringBuilder stringBuilder = new StringBuilder(n + 1);
            if (!bl) {
                stringBuilder.append('-');
            }
            for (int i = 0; i < n; ++i) {
                stringBuilder.append((char)this.digits[i]);
            }
            BigInteger bigInteger = new BigInteger(stringBuilder.toString());
            return new BigDecimal(bigInteger, (int)l);
        }
        return new BigDecimal(this.getStringRep(bl));
    }

    public com.ibm.icu.math.BigDecimal getBigDecimalICU(boolean bl) {
        if (this.isZero()) {
            return com.ibm.icu.math.BigDecimal.valueOf(0L);
        }
        long l = (long)this.count - (long)this.decimalAt;
        if (l > 0L) {
            int n = this.count;
            if (l > Integer.MAX_VALUE) {
                long l2 = l - Integer.MAX_VALUE;
                if (l2 < (long)this.count) {
                    n = (int)((long)n - l2);
                } else {
                    return new com.ibm.icu.math.BigDecimal(0);
                }
            }
            StringBuilder stringBuilder = new StringBuilder(n + 1);
            if (!bl) {
                stringBuilder.append('-');
            }
            for (int i = 0; i < n; ++i) {
                stringBuilder.append((char)this.digits[i]);
            }
            BigInteger bigInteger = new BigInteger(stringBuilder.toString());
            return new com.ibm.icu.math.BigDecimal(bigInteger, (int)l);
        }
        return new com.ibm.icu.math.BigDecimal(this.getStringRep(bl));
    }

    boolean isIntegral() {
        while (this.count > 0 && this.digits[this.count - 1] == 48) {
            --this.count;
        }
        return this.count == 0 || this.decimalAt >= this.count;
    }

    final void set(double d, int n, boolean bl) {
        if (d == 0.0) {
            d = 0.0;
        }
        String string = Double.toString(d);
        this.set(string, 19);
        if (bl) {
            if (-this.decimalAt > n) {
                this.count = 0;
                return;
            }
            if (-this.decimalAt == n) {
                if (this.shouldRoundUp(0)) {
                    this.count = 1;
                    ++this.decimalAt;
                    this.digits[0] = 49;
                } else {
                    this.count = 0;
                }
                return;
            }
        }
        while (this.count > 1 && this.digits[this.count - 1] == 48) {
            --this.count;
        }
        this.round(bl ? n + this.decimalAt : (n == 0 ? -1 : n));
    }

    private void set(String string, int n) {
        this.decimalAt = -1;
        this.count = 0;
        int n2 = 0;
        int n3 = 0;
        boolean bl = false;
        int n4 = 0;
        if (string.charAt(n4) == '-') {
            ++n4;
        }
        while (n4 < string.length()) {
            char c = string.charAt(n4);
            if (c == '.') {
                this.decimalAt = this.count;
            } else {
                if (c == 'e' || c == 'E') {
                    if (string.charAt(++n4) == '+') {
                        ++n4;
                    }
                    n2 = Integer.valueOf(string.substring(n4));
                    break;
                }
                if (this.count < n) {
                    if (!bl) {
                        boolean bl2 = bl = c != '0';
                        if (!bl && this.decimalAt != -1) {
                            ++n3;
                        }
                    }
                    if (bl) {
                        this.ensureCapacity(this.count + 1, this.count);
                        this.digits[this.count++] = (byte)c;
                    }
                }
            }
            ++n4;
        }
        if (this.decimalAt == -1) {
            this.decimalAt = this.count;
        }
        this.decimalAt += n2 - n3;
    }

    private boolean shouldRoundUp(int n) {
        if (n < this.count) {
            if (this.digits[n] > 53) {
                return true;
            }
            if (this.digits[n] == 53) {
                for (int i = n + 1; i < this.count; ++i) {
                    if (this.digits[i] == 48) continue;
                    return true;
                }
                return n > 0 && this.digits[n - 1] % 2 != 0;
            }
        }
        return false;
    }

    public final void round(int n) {
        if (n >= 0 && n < this.count) {
            if (this.shouldRoundUp(n)) {
                do {
                    if (--n < 0) {
                        this.digits[0] = 49;
                        ++this.decimalAt;
                        n = 0;
                        break;
                    }
                    int n2 = n;
                    this.digits[n2] = (byte)(this.digits[n2] + 1);
                } while (this.digits[n] > 57);
                ++n;
            }
            this.count = n;
        }
        while (this.count > 1 && this.digits[this.count - 1] == 48) {
            --this.count;
        }
    }

    public final void set(long l) {
        this.set(l, 0);
    }

    public final void set(long l, int n) {
        if (l <= 0L) {
            if (l == Long.MIN_VALUE) {
                this.count = 19;
                this.decimalAt = 19;
                System.arraycopy(LONG_MIN_REP, 0, this.digits, 0, this.count);
            } else {
                this.count = 0;
                this.decimalAt = 0;
            }
        } else {
            int n2 = 19;
            while (l > 0L) {
                this.digits[--n2] = (byte)(48L + l % 10L);
                l /= 10L;
            }
            this.decimalAt = 19 - n2;
            int n3 = 18;
            while (this.digits[n3] == 48) {
                --n3;
            }
            this.count = n3 - n2 + 1;
            System.arraycopy(this.digits, n2, this.digits, 0, this.count);
        }
        if (n > 0) {
            this.round(n);
        }
    }

    public final void set(BigInteger bigInteger, int n) {
        String string = bigInteger.toString();
        this.count = this.decimalAt = string.length();
        while (this.count > 1 && string.charAt(this.count - 1) == '0') {
            --this.count;
        }
        int n2 = 0;
        if (string.charAt(0) == '-') {
            ++n2;
            --this.count;
            --this.decimalAt;
        }
        this.ensureCapacity(this.count, 0);
        for (int i = 0; i < this.count; ++i) {
            this.digits[i] = (byte)string.charAt(i + n2);
        }
        if (n > 0) {
            this.round(n);
        }
    }

    private void setBigDecimalDigits(String string, int n, boolean bl) {
        this.set(string, string.length());
        this.round(bl ? n + this.decimalAt : (n == 0 ? -1 : n));
    }

    public final void set(BigDecimal bigDecimal, int n, boolean bl) {
        this.setBigDecimalDigits(bigDecimal.toString(), n, bl);
    }

    public final void set(com.ibm.icu.math.BigDecimal bigDecimal, int n, boolean bl) {
        this.setBigDecimalDigits(bigDecimal.toString(), n, bl);
    }

    private boolean isLongMIN_VALUE() {
        if (this.decimalAt != this.count || this.count != 19) {
            return false;
        }
        for (int i = 0; i < this.count; ++i) {
            if (this.digits[i] == LONG_MIN_REP[i]) continue;
            return false;
        }
        return true;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof DigitList)) {
            return false;
        }
        DigitList digitList = (DigitList)object;
        if (this.count != digitList.count || this.decimalAt != digitList.decimalAt) {
            return false;
        }
        for (int i = 0; i < this.count; ++i) {
            if (this.digits[i] == digitList.digits[i]) continue;
            return false;
        }
        return true;
    }

    public int hashCode() {
        int n = this.decimalAt;
        for (int i = 0; i < this.count; ++i) {
            n = n * 37 + this.digits[i];
        }
        return n;
    }

    public String toString() {
        if (this.isZero()) {
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder("0.");
        for (int i = 0; i < this.count; ++i) {
            stringBuilder.append((char)this.digits[i]);
        }
        stringBuilder.append("x10^");
        stringBuilder.append(this.decimalAt);
        return stringBuilder.toString();
    }

    static {
        String string = Long.toString(Long.MIN_VALUE);
        LONG_MIN_REP = new byte[19];
        for (int i = 0; i < 19; ++i) {
            DigitList.LONG_MIN_REP[i] = (byte)string.charAt(i + 1);
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.pattern;

public class FormattingInfo {
    private static final char[] SPACES = new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    private static final FormattingInfo DEFAULT = new FormattingInfo(false, 0, Integer.MAX_VALUE);
    private final int minLength;
    private final int maxLength;
    private final boolean leftAlign;

    public FormattingInfo(boolean bl, int n, int n2) {
        this.leftAlign = bl;
        this.minLength = n;
        this.maxLength = n2;
    }

    public static FormattingInfo getDefault() {
        return DEFAULT;
    }

    public boolean isLeftAligned() {
        return this.leftAlign;
    }

    public int getMinLength() {
        return this.minLength;
    }

    public int getMaxLength() {
        return this.maxLength;
    }

    public void format(int n, StringBuilder stringBuilder) {
        int n2 = stringBuilder.length() - n;
        if (n2 > this.maxLength) {
            stringBuilder.delete(n, stringBuilder.length() - this.maxLength);
        } else if (n2 < this.minLength) {
            if (this.leftAlign) {
                int n3 = stringBuilder.length();
                stringBuilder.setLength(n + this.minLength);
                for (int i = n3; i < stringBuilder.length(); ++i) {
                    stringBuilder.setCharAt(i, ' ');
                }
            } else {
                int n4;
                for (n4 = this.minLength - n2; n4 > SPACES.length; n4 -= SPACES.length) {
                    stringBuilder.insert(n, SPACES);
                }
                stringBuilder.insert(n, SPACES, 0, n4);
            }
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append("[leftAlign=");
        stringBuilder.append(this.leftAlign);
        stringBuilder.append(", maxLength=");
        stringBuilder.append(this.maxLength);
        stringBuilder.append(", minLength=");
        stringBuilder.append(this.minLength);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}


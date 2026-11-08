/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.impl.IDNA2003;
import com.ibm.icu.impl.UTS46;
import com.ibm.icu.text.StringPrepParseException;
import com.ibm.icu.text.UCharacterIterator;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class IDNA {
    public static final int DEFAULT = 0;
    public static final int ALLOW_UNASSIGNED = 1;
    public static final int USE_STD3_RULES = 2;
    public static final int CHECK_BIDI = 4;
    public static final int CHECK_CONTEXTJ = 8;
    public static final int NONTRANSITIONAL_TO_ASCII = 16;
    public static final int NONTRANSITIONAL_TO_UNICODE = 32;
    public static final int CHECK_CONTEXTO = 64;

    public static IDNA getUTS46Instance(int n) {
        return new UTS46(n);
    }

    public abstract StringBuilder labelToASCII(CharSequence var1, StringBuilder var2, Info var3);

    public abstract StringBuilder labelToUnicode(CharSequence var1, StringBuilder var2, Info var3);

    public abstract StringBuilder nameToASCII(CharSequence var1, StringBuilder var2, Info var3);

    public abstract StringBuilder nameToUnicode(CharSequence var1, StringBuilder var2, Info var3);

    protected static void resetInfo(Info info) {
        info.reset();
    }

    protected static boolean hasCertainErrors(Info info, EnumSet<Error> enumSet) {
        return !info.errors.isEmpty() && !Collections.disjoint(info.errors, enumSet);
    }

    protected static boolean hasCertainLabelErrors(Info info, EnumSet<Error> enumSet) {
        return !info.labelErrors.isEmpty() && !Collections.disjoint(info.labelErrors, enumSet);
    }

    protected static void addLabelError(Info info, Error error) {
        info.labelErrors.add(error);
    }

    protected static void promoteAndResetLabelErrors(Info info) {
        if (!info.labelErrors.isEmpty()) {
            info.errors.addAll(info.labelErrors);
            info.labelErrors.clear();
        }
    }

    protected static void addError(Info info, Error error) {
        info.errors.add(error);
    }

    protected static void setTransitionalDifferent(Info info) {
        info.isTransDiff = true;
    }

    protected static void setBiDi(Info info) {
        info.isBiDi = true;
    }

    protected static boolean isBiDi(Info info) {
        return info.isBiDi;
    }

    protected static void setNotOkBiDi(Info info) {
        info.isOkBiDi = false;
    }

    protected static boolean isOkBiDi(Info info) {
        return info.isOkBiDi;
    }

    protected IDNA() {
    }

    public static StringBuffer convertToASCII(String string, int n) throws StringPrepParseException {
        UCharacterIterator uCharacterIterator = UCharacterIterator.getInstance(string);
        return IDNA.convertToASCII(uCharacterIterator, n);
    }

    public static StringBuffer convertToASCII(StringBuffer stringBuffer, int n) throws StringPrepParseException {
        UCharacterIterator uCharacterIterator = UCharacterIterator.getInstance(stringBuffer);
        return IDNA.convertToASCII(uCharacterIterator, n);
    }

    public static StringBuffer convertToASCII(UCharacterIterator uCharacterIterator, int n) throws StringPrepParseException {
        return IDNA2003.convertToASCII(uCharacterIterator, n);
    }

    public static StringBuffer convertIDNToASCII(UCharacterIterator uCharacterIterator, int n) throws StringPrepParseException {
        return IDNA.convertIDNToASCII(uCharacterIterator.getText(), n);
    }

    public static StringBuffer convertIDNToASCII(StringBuffer stringBuffer, int n) throws StringPrepParseException {
        return IDNA.convertIDNToASCII(stringBuffer.toString(), n);
    }

    public static StringBuffer convertIDNToASCII(String string, int n) throws StringPrepParseException {
        return IDNA2003.convertIDNToASCII(string, n);
    }

    public static StringBuffer convertToUnicode(String string, int n) throws StringPrepParseException {
        UCharacterIterator uCharacterIterator = UCharacterIterator.getInstance(string);
        return IDNA.convertToUnicode(uCharacterIterator, n);
    }

    public static StringBuffer convertToUnicode(StringBuffer stringBuffer, int n) throws StringPrepParseException {
        UCharacterIterator uCharacterIterator = UCharacterIterator.getInstance(stringBuffer);
        return IDNA.convertToUnicode(uCharacterIterator, n);
    }

    public static StringBuffer convertToUnicode(UCharacterIterator uCharacterIterator, int n) throws StringPrepParseException {
        return IDNA2003.convertToUnicode(uCharacterIterator, n);
    }

    public static StringBuffer convertIDNToUnicode(UCharacterIterator uCharacterIterator, int n) throws StringPrepParseException {
        return IDNA.convertIDNToUnicode(uCharacterIterator.getText(), n);
    }

    public static StringBuffer convertIDNToUnicode(StringBuffer stringBuffer, int n) throws StringPrepParseException {
        return IDNA.convertIDNToUnicode(stringBuffer.toString(), n);
    }

    public static StringBuffer convertIDNToUnicode(String string, int n) throws StringPrepParseException {
        return IDNA2003.convertIDNToUnicode(string, n);
    }

    public static int compare(StringBuffer stringBuffer, StringBuffer stringBuffer2, int n) throws StringPrepParseException {
        if (stringBuffer == null || stringBuffer2 == null) {
            throw new IllegalArgumentException("One of the source buffers is null");
        }
        return IDNA2003.compare(stringBuffer.toString(), stringBuffer2.toString(), n);
    }

    public static int compare(String string, String string2, int n) throws StringPrepParseException {
        if (string == null || string2 == null) {
            throw new IllegalArgumentException("One of the source buffers is null");
        }
        return IDNA2003.compare(string, string2, n);
    }

    public static int compare(UCharacterIterator uCharacterIterator, UCharacterIterator uCharacterIterator2, int n) throws StringPrepParseException {
        if (uCharacterIterator == null || uCharacterIterator2 == null) {
            throw new IllegalArgumentException("One of the source buffers is null");
        }
        return IDNA2003.compare(uCharacterIterator.getText(), uCharacterIterator2.getText(), n);
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static enum Error {
        EMPTY_LABEL,
        LABEL_TOO_LONG,
        DOMAIN_NAME_TOO_LONG,
        LEADING_HYPHEN,
        TRAILING_HYPHEN,
        HYPHEN_3_4,
        LEADING_COMBINING_MARK,
        DISALLOWED,
        PUNYCODE,
        LABEL_HAS_DOT,
        INVALID_ACE_LABEL,
        BIDI,
        CONTEXTJ,
        CONTEXTO_PUNCTUATION,
        CONTEXTO_DIGITS;

    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static final class Info {
        private EnumSet<Error> errors = EnumSet.noneOf(Error.class);
        private EnumSet<Error> labelErrors = EnumSet.noneOf(Error.class);
        private boolean isTransDiff = false;
        private boolean isBiDi = false;
        private boolean isOkBiDi = true;

        public boolean hasErrors() {
            return !this.errors.isEmpty();
        }

        public Set<Error> getErrors() {
            return this.errors;
        }

        public boolean isTransitionalDifferent() {
            return this.isTransDiff;
        }

        private void reset() {
            this.errors.clear();
            this.labelErrors.clear();
            this.isTransDiff = false;
            this.isBiDi = false;
            this.isOkBiDi = true;
        }
    }
}


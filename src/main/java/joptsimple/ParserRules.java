/*
 * Decompiled with CFR 0.152.
 */
package joptsimple;

import java.util.Collection;
import joptsimple.IllegalOptionSpecificationException;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class ParserRules {
    static final char HYPHEN_CHAR = '-';
    static final String HYPHEN = String.valueOf('-');
    static final String DOUBLE_HYPHEN = "--";
    static final String OPTION_TERMINATOR = "--";
    static final String RESERVED_FOR_EXTENSIONS = "W";

    private ParserRules() {
        throw new UnsupportedOperationException();
    }

    static boolean isShortOptionToken(String string) {
        return string.startsWith(HYPHEN) && !HYPHEN.equals(string) && !ParserRules.isLongOptionToken(string);
    }

    static boolean isLongOptionToken(String string) {
        return string.startsWith("--") && !ParserRules.isOptionTerminator(string);
    }

    static boolean isOptionTerminator(String string) {
        return "--".equals(string);
    }

    static void ensureLegalOption(String string) {
        if (string.startsWith(HYPHEN)) {
            throw new IllegalOptionSpecificationException(String.valueOf(string));
        }
        for (int i = 0; i < string.length(); ++i) {
            ParserRules.ensureLegalOptionCharacter(string.charAt(i));
        }
    }

    static void ensureLegalOptions(Collection<String> collection) {
        for (String string : collection) {
            ParserRules.ensureLegalOption(string);
        }
    }

    private static void ensureLegalOptionCharacter(char c) {
        if (!Character.isLetterOrDigit(c) && !ParserRules.isAllowedPunctuation(c)) {
            throw new IllegalOptionSpecificationException(String.valueOf(c));
        }
    }

    private static boolean isAllowedPunctuation(char c) {
        String string = "?.-";
        return string.indexOf(c) != -1;
    }
}


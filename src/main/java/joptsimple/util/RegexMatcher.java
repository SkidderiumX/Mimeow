/*
 * Decompiled with CFR 0.152.
 */
package joptsimple.util;

import java.util.regex.Pattern;
import joptsimple.ValueConversionException;
import joptsimple.ValueConverter;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class RegexMatcher
implements ValueConverter<String> {
    private final Pattern pattern;

    public RegexMatcher(String string, int n) {
        this.pattern = Pattern.compile(string, n);
    }

    public static ValueConverter<String> regex(String string) {
        return new RegexMatcher(string, 0);
    }

    @Override
    public String convert(String string) {
        if (!this.pattern.matcher(string).matches()) {
            throw new ValueConversionException("Value [" + string + "] did not match regex [" + this.pattern.pattern() + ']');
        }
        return string;
    }

    @Override
    public Class<String> valueType() {
        return String.class;
    }

    @Override
    public String valuePattern() {
        return this.pattern.pattern();
    }
}


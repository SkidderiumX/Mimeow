/*
 * Decompiled with CFR 0.152.
 */
package joptsimple.util;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import joptsimple.ValueConversionException;
import joptsimple.ValueConverter;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class DateConverter
implements ValueConverter<Date> {
    private final DateFormat formatter;

    public DateConverter(DateFormat dateFormat) {
        if (dateFormat == null) {
            throw new NullPointerException("illegal null formatter");
        }
        this.formatter = dateFormat;
    }

    public static DateConverter datePattern(String string) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(string);
        simpleDateFormat.setLenient(false);
        return new DateConverter(simpleDateFormat);
    }

    @Override
    public Date convert(String string) {
        ParsePosition parsePosition = new ParsePosition(0);
        Date date = this.formatter.parse(string, parsePosition);
        if (parsePosition.getIndex() != string.length()) {
            throw new ValueConversionException(this.message(string));
        }
        return date;
    }

    @Override
    public Class<Date> valueType() {
        return Date.class;
    }

    @Override
    public String valuePattern() {
        return this.formatter instanceof SimpleDateFormat ? ((SimpleDateFormat)this.formatter).toPattern() : "";
    }

    private String message(String string) {
        String string2 = "Value [" + string + "] does not match date/time pattern";
        if (this.formatter instanceof SimpleDateFormat) {
            string2 = string2 + " [" + ((SimpleDateFormat)this.formatter).toPattern() + ']';
        }
        return string2;
    }
}


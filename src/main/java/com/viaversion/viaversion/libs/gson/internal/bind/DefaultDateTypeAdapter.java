package com.viaversion.viaversion.libs.gson.internal.bind;

import com.viaversion.viaversion.libs.gson.internal.*;
import java.io.*;
import com.viaversion.viaversion.libs.gson.stream.*;
import java.text.*;
import com.viaversion.viaversion.libs.gson.internal.bind.util.*;
import java.util.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.libs.gson.reflect.*;

public class DefaultDateTypeAdapter<T extends Date> extends TypeAdapter<T>
{
    private static final String SIMPLE_NAME = "DefaultDateTypeAdapter";
    public static final TypeAdapterFactory DEFAULT_STYLE_FACTORY;
    private final DateType<T> dateType;
    private final List<DateFormat> dateFormats;
    
    private DefaultDateTypeAdapter(final DateType<T> obj, final String s) {
        this.dateFormats = new ArrayList<DateFormat>();
        this.dateType = Objects.requireNonNull(obj);
        this.dateFormats.add(new SimpleDateFormat(s, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.dateFormats.add(new SimpleDateFormat(s));
        }
    }
    
    private DefaultDateTypeAdapter(final DateType<T> obj, final int n, final int n2) {
        this.dateFormats = new ArrayList<DateFormat>();
        this.dateType = Objects.requireNonNull(obj);
        this.dateFormats.add(DateFormat.getDateTimeInstance(n, n2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.dateFormats.add(DateFormat.getDateTimeInstance(n, n2));
        }
        if (JavaVersion.isJava9OrLater()) {
            this.dateFormats.add(PreJava9DateFormatProvider.getUsDateTimeFormat(n, n2));
        }
    }
    
    @Override
    public void write(final JsonWriter jsonWriter, final Date date) throws IOException {
        if (date == null) {
            jsonWriter.nullValue();
            return;
        }
        final DateFormat dateFormat = this.dateFormats.get(0);
        final String format;
        synchronized (this.dateFormats) {
            format = dateFormat.format(date);
        }
        jsonWriter.value(format);
    }
    
    @Override
    public T read(final JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        return this.dateType.deserialize(this.deserializeToDate(jsonReader));
    }
    
    private Date deserializeToDate(final JsonReader jsonReader) throws IOException {
        final String nextString = jsonReader.nextString();
        synchronized (this.dateFormats) {
            for (final DateFormat dateFormat : this.dateFormats) {
                final TimeZone timeZone = dateFormat.getTimeZone();
                try {
                    return dateFormat.parse(nextString);
                }
                catch (final ParseException ex) {}
                finally {
                    dateFormat.setTimeZone(timeZone);
                }
            }
        }
        try {
            return ISO8601Utils.parse(nextString, new ParsePosition(0));
        }
        catch (final ParseException ex2) {
            throw new JsonSyntaxException("Failed parsing '" + nextString + "' as Date; at path " + jsonReader.getPreviousPath(), ex2);
        }
    }
    
    @Override
    public String toString() {
        final DateFormat dateFormat = this.dateFormats.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat)dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + ((SimpleDateFormat)dateFormat).getClass().getSimpleName() + ')';
    }
    
    static {
        DEFAULT_STYLE_FACTORY = new TypeAdapterFactory() {
            @Override
            public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
                return (typeToken.getRawType() == Date.class) ? new DefaultDateTypeAdapter<T>(DateType.DATE, 2, 2, null) : null;
            }
            
            @Override
            public String toString() {
                return "DefaultDateTypeAdapter#DEFAULT_STYLE_FACTORY";
            }
        };
    }
    
    public abstract static class DateType<T extends Date>
    {
        public static final DateType<Date> DATE;
        private final Class<T> dateClass;
        
        protected DateType(final Class<T> dateClass) {
            this.dateClass = dateClass;
        }
        
        protected abstract T deserialize(final Date p0);
        
        private TypeAdapterFactory createFactory(final DefaultDateTypeAdapter<T> defaultDateTypeAdapter) {
            return TypeAdapters.newFactory(this.dateClass, defaultDateTypeAdapter);
        }
        
        public final TypeAdapterFactory createAdapterFactory(final String s) {
            return this.createFactory(new DefaultDateTypeAdapter<T>(this, s, null));
        }
        
        public final TypeAdapterFactory createAdapterFactory(final int n, final int n2) {
            return this.createFactory(new DefaultDateTypeAdapter<T>(this, n, n2, null));
        }
        
        static {
            DATE = new DateType<Date>() {
                @Override
                protected Date deserialize(final Date date) {
                    return date;
                }
            };
        }
    }
}

/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.gson.internal.bind;

import com.viaversion.viaversion.libs.gson.Gson;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonIOException;
import com.viaversion.viaversion.libs.gson.JsonSyntaxException;
import com.viaversion.viaversion.libs.gson.TypeAdapter;
import com.viaversion.viaversion.libs.gson.TypeAdapterFactory;
import com.viaversion.viaversion.libs.gson.internal.LazilyParsedNumber;
import com.viaversion.viaversion.libs.gson.internal.NumberLimits;
import com.viaversion.viaversion.libs.gson.internal.TroubleshootingGuide;
import com.viaversion.viaversion.libs.gson.internal.bind.EnumTypeAdapter;
import com.viaversion.viaversion.libs.gson.internal.bind.JsonElementTypeAdapter;
import com.viaversion.viaversion.libs.gson.reflect.TypeToken;
import com.viaversion.viaversion.libs.gson.stream.JsonReader;
import com.viaversion.viaversion.libs.gson.stream.JsonToken;
import com.viaversion.viaversion.libs.gson.stream.JsonWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

public class TypeAdapters {
    public static final TypeAdapter<Class> CLASS = new TypeAdapter<Class>(){

        @Override
        public void write(JsonWriter jsonWriter, Class clazz) throws IOException {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + clazz.getName() + ". Forgot to register a type adapter?\nSee " + TroubleshootingGuide.createUrl("java-lang-class-unsupported"));
        }

        @Override
        public Class read(JsonReader jsonReader) throws IOException {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?\nSee " + TroubleshootingGuide.createUrl("java-lang-class-unsupported"));
        }
    }.nullSafe();
    public static final TypeAdapterFactory CLASS_FACTORY = TypeAdapters.newFactory(Class.class, CLASS);
    public static final TypeAdapter<BitSet> BIT_SET = new TypeAdapter<BitSet>(){

        @Override
        public BitSet read(JsonReader jsonReader) throws IOException {
            BitSet bitSet = new BitSet();
            jsonReader.beginArray();
            int n = 0;
            JsonToken jsonToken = jsonReader.peek();
            while (jsonToken != JsonToken.END_ARRAY) {
                boolean bl;
                switch (jsonToken) {
                    case NUMBER: 
                    case STRING: {
                        int n2 = jsonReader.nextInt();
                        if (n2 == 0) {
                            bl = false;
                            break;
                        }
                        if (n2 == 1) {
                            bl = true;
                            break;
                        }
                        throw new JsonSyntaxException("Invalid bitset value " + n2 + ", expected 0 or 1; at path " + jsonReader.getPreviousPath());
                    }
                    case BOOLEAN: {
                        bl = jsonReader.nextBoolean();
                        break;
                    }
                    default: {
                        throw new JsonSyntaxException("Invalid bitset value type: " + (Object)((Object)jsonToken) + "; at path " + jsonReader.getPath());
                    }
                }
                if (bl) {
                    bitSet.set(n);
                }
                ++n;
                jsonToken = jsonReader.peek();
            }
            jsonReader.endArray();
            return bitSet;
        }

        @Override
        public void write(JsonWriter jsonWriter, BitSet bitSet) throws IOException {
            jsonWriter.beginArray();
            int n = bitSet.length();
            for (int i = 0; i < n; ++i) {
                int n2 = bitSet.get(i) ? 1 : 0;
                jsonWriter.value(n2);
            }
            jsonWriter.endArray();
        }
    }.nullSafe();
    public static final TypeAdapterFactory BIT_SET_FACTORY = TypeAdapters.newFactory(BitSet.class, BIT_SET);
    public static final TypeAdapter<Boolean> BOOLEAN = new TypeAdapter<Boolean>(){

        @Override
        public Boolean read(JsonReader jsonReader) throws IOException {
            JsonToken jsonToken = jsonReader.peek();
            if (jsonToken == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            if (jsonToken == JsonToken.STRING) {
                return Boolean.parseBoolean(jsonReader.nextString());
            }
            return jsonReader.nextBoolean();
        }

        @Override
        public void write(JsonWriter jsonWriter, Boolean bl) throws IOException {
            jsonWriter.value(bl);
        }
    };
    public static final TypeAdapter<Boolean> BOOLEAN_AS_STRING = new TypeAdapter<Boolean>(){

        @Override
        public Boolean read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return Boolean.valueOf(jsonReader.nextString());
        }

        @Override
        public void write(JsonWriter jsonWriter, Boolean bl) throws IOException {
            jsonWriter.value(bl == null ? "null" : bl.toString());
        }
    };
    public static final TypeAdapterFactory BOOLEAN_FACTORY = TypeAdapters.newFactory(Boolean.TYPE, Boolean.class, BOOLEAN);
    public static final TypeAdapter<Number> BYTE = new TypeAdapter<Number>(){

        @Override
        public Number read(JsonReader jsonReader) throws IOException {
            int n;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                n = jsonReader.nextInt();
            }
            catch (NumberFormatException numberFormatException) {
                throw new JsonSyntaxException(numberFormatException);
            }
            if (n > 255 || n < -128) {
                throw new JsonSyntaxException("Lossy conversion from " + n + " to byte; at path " + jsonReader.getPreviousPath());
            }
            return (byte)n;
        }

        @Override
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(number.byteValue());
            }
        }
    };
    public static final TypeAdapterFactory BYTE_FACTORY = TypeAdapters.newFactory(Byte.TYPE, Byte.class, BYTE);
    public static final TypeAdapter<Number> SHORT = new TypeAdapter<Number>(){

        @Override
        public Number read(JsonReader jsonReader) throws IOException {
            int n;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                n = jsonReader.nextInt();
            }
            catch (NumberFormatException numberFormatException) {
                throw new JsonSyntaxException(numberFormatException);
            }
            if (n > 65535 || n < Short.MIN_VALUE) {
                throw new JsonSyntaxException("Lossy conversion from " + n + " to short; at path " + jsonReader.getPreviousPath());
            }
            return (short)n;
        }

        @Override
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(number.shortValue());
            }
        }
    };
    public static final TypeAdapterFactory SHORT_FACTORY = TypeAdapters.newFactory(Short.TYPE, Short.class, SHORT);
    public static final TypeAdapter<Number> INTEGER = new TypeAdapter<Number>(){

        @Override
        public Number read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return jsonReader.nextInt();
            }
            catch (NumberFormatException numberFormatException) {
                throw new JsonSyntaxException(numberFormatException);
            }
        }

        @Override
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(number.intValue());
            }
        }
    };
    public static final TypeAdapterFactory INTEGER_FACTORY = TypeAdapters.newFactory(Integer.TYPE, Integer.class, INTEGER);
    public static final TypeAdapter<AtomicInteger> ATOMIC_INTEGER = new TypeAdapter<AtomicInteger>(){

        @Override
        public AtomicInteger read(JsonReader jsonReader) throws IOException {
            try {
                return new AtomicInteger(jsonReader.nextInt());
            }
            catch (NumberFormatException numberFormatException) {
                throw new JsonSyntaxException(numberFormatException);
            }
        }

        @Override
        public void write(JsonWriter jsonWriter, AtomicInteger atomicInteger) throws IOException {
            jsonWriter.value(atomicInteger.get());
        }
    }.nullSafe();
    public static final TypeAdapterFactory ATOMIC_INTEGER_FACTORY = TypeAdapters.newFactory(AtomicInteger.class, ATOMIC_INTEGER);
    public static final TypeAdapter<AtomicBoolean> ATOMIC_BOOLEAN = new TypeAdapter<AtomicBoolean>(){

        @Override
        public AtomicBoolean read(JsonReader jsonReader) throws IOException {
            return new AtomicBoolean(jsonReader.nextBoolean());
        }

        @Override
        public void write(JsonWriter jsonWriter, AtomicBoolean atomicBoolean) throws IOException {
            jsonWriter.value(atomicBoolean.get());
        }
    }.nullSafe();
    public static final TypeAdapterFactory ATOMIC_BOOLEAN_FACTORY = TypeAdapters.newFactory(AtomicBoolean.class, ATOMIC_BOOLEAN);
    public static final TypeAdapter<AtomicIntegerArray> ATOMIC_INTEGER_ARRAY = new TypeAdapter<AtomicIntegerArray>(){

        @Override
        public AtomicIntegerArray read(JsonReader jsonReader) throws IOException {
            int n;
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                try {
                    n = jsonReader.nextInt();
                    arrayList.add(n);
                }
                catch (NumberFormatException numberFormatException) {
                    throw new JsonSyntaxException(numberFormatException);
                }
            }
            jsonReader.endArray();
            n = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(n);
            for (int i = 0; i < n; ++i) {
                atomicIntegerArray.set(i, (Integer)arrayList.get(i));
            }
            return atomicIntegerArray;
        }

        @Override
        public void write(JsonWriter jsonWriter, AtomicIntegerArray atomicIntegerArray) throws IOException {
            jsonWriter.beginArray();
            int n = atomicIntegerArray.length();
            for (int i = 0; i < n; ++i) {
                jsonWriter.value(atomicIntegerArray.get(i));
            }
            jsonWriter.endArray();
        }
    }.nullSafe();
    public static final TypeAdapterFactory ATOMIC_INTEGER_ARRAY_FACTORY = TypeAdapters.newFactory(AtomicIntegerArray.class, ATOMIC_INTEGER_ARRAY);
    public static final TypeAdapter<Number> LONG = new TypeAdapter<Number>(){

        @Override
        public Number read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return jsonReader.nextLong();
            }
            catch (NumberFormatException numberFormatException) {
                throw new JsonSyntaxException(numberFormatException);
            }
        }

        @Override
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(number.longValue());
            }
        }
    };
    public static final TypeAdapter<Number> LONG_AS_STRING = new TypeAdapter<Number>(){

        @Override
        public Number read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return jsonReader.nextLong();
        }

        @Override
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            if (number == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.value(number.toString());
        }
    };
    public static final TypeAdapter<Number> FLOAT = new FloatAdapter(false);
    public static final TypeAdapter<Number> FLOAT_STRICT = new FloatAdapter(true);
    public static final TypeAdapter<Number> DOUBLE = new DoubleAdapter(false);
    public static final TypeAdapter<Number> DOUBLE_STRICT = new DoubleAdapter(true);
    public static final TypeAdapter<Character> CHARACTER = new TypeAdapter<Character>(){

        @Override
        public Character read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String string = jsonReader.nextString();
            if (string.length() != 1) {
                throw new JsonSyntaxException("Expecting character, got: " + string + "; at " + jsonReader.getPreviousPath());
            }
            return Character.valueOf(string.charAt(0));
        }

        @Override
        public void write(JsonWriter jsonWriter, Character c) throws IOException {
            jsonWriter.value(c == null ? null : String.valueOf(c));
        }
    };
    public static final TypeAdapterFactory CHARACTER_FACTORY = TypeAdapters.newFactory(Character.TYPE, Character.class, CHARACTER);
    public static final TypeAdapter<String> STRING = new TypeAdapter<String>(){

        @Override
        public String read(JsonReader jsonReader) throws IOException {
            JsonToken jsonToken = jsonReader.peek();
            if (jsonToken == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            if (jsonToken == JsonToken.BOOLEAN) {
                return Boolean.toString(jsonReader.nextBoolean());
            }
            return jsonReader.nextString();
        }

        @Override
        public void write(JsonWriter jsonWriter, String string) throws IOException {
            jsonWriter.value(string);
        }
    };
    public static final TypeAdapter<BigDecimal> BIG_DECIMAL = new TypeAdapter<BigDecimal>(){

        @Override
        public BigDecimal read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String string = jsonReader.nextString();
            try {
                return NumberLimits.parseBigDecimal(string);
            }
            catch (NumberFormatException numberFormatException) {
                throw new JsonSyntaxException("Failed parsing '" + string + "' as BigDecimal; at path " + jsonReader.getPreviousPath(), numberFormatException);
            }
        }

        @Override
        public void write(JsonWriter jsonWriter, BigDecimal bigDecimal) throws IOException {
            jsonWriter.value(bigDecimal);
        }
    };
    public static final TypeAdapterFactory BIG_DECIMAL_FACTORY = TypeAdapters.newFactory(BigDecimal.class, BIG_DECIMAL);
    public static final TypeAdapter<BigInteger> BIG_INTEGER = new TypeAdapter<BigInteger>(){

        @Override
        public BigInteger read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String string = jsonReader.nextString();
            try {
                return NumberLimits.parseBigInteger(string);
            }
            catch (NumberFormatException numberFormatException) {
                throw new JsonSyntaxException("Failed parsing '" + string + "' as BigInteger; at path " + jsonReader.getPreviousPath(), numberFormatException);
            }
        }

        @Override
        public void write(JsonWriter jsonWriter, BigInteger bigInteger) throws IOException {
            jsonWriter.value(bigInteger);
        }
    };
    public static final TypeAdapterFactory BIG_INTEGER_FACTORY = TypeAdapters.newFactory(BigInteger.class, BIG_INTEGER);
    public static final TypeAdapter<LazilyParsedNumber> LAZILY_PARSED_NUMBER = new TypeAdapter<LazilyParsedNumber>(){

        @Override
        public LazilyParsedNumber read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return new LazilyParsedNumber(jsonReader.nextString());
        }

        @Override
        public void write(JsonWriter jsonWriter, LazilyParsedNumber lazilyParsedNumber) throws IOException {
            jsonWriter.value(lazilyParsedNumber);
        }
    };
    public static final TypeAdapterFactory LAZILY_PARSED_NUMBER_FACTORY = TypeAdapters.newFactory(LazilyParsedNumber.class, LAZILY_PARSED_NUMBER);
    public static final TypeAdapterFactory STRING_FACTORY = TypeAdapters.newFactory(String.class, STRING);
    public static final TypeAdapter<StringBuilder> STRING_BUILDER = new TypeAdapter<StringBuilder>(){

        @Override
        public StringBuilder read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return new StringBuilder(jsonReader.nextString());
        }

        @Override
        public void write(JsonWriter jsonWriter, StringBuilder stringBuilder) throws IOException {
            jsonWriter.value(stringBuilder == null ? null : stringBuilder.toString());
        }
    };
    public static final TypeAdapterFactory STRING_BUILDER_FACTORY = TypeAdapters.newFactory(StringBuilder.class, STRING_BUILDER);
    public static final TypeAdapter<StringBuffer> STRING_BUFFER = new TypeAdapter<StringBuffer>(){

        @Override
        public StringBuffer read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return new StringBuffer(jsonReader.nextString());
        }

        @Override
        public void write(JsonWriter jsonWriter, StringBuffer stringBuffer) throws IOException {
            jsonWriter.value(stringBuffer == null ? null : stringBuffer.toString());
        }
    };
    public static final TypeAdapterFactory STRING_BUFFER_FACTORY = TypeAdapters.newFactory(StringBuffer.class, STRING_BUFFER);
    public static final TypeAdapter<URL> URL = new TypeAdapter<URL>(){

        @Override
        public URL read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String string = jsonReader.nextString();
            return string.equals("null") ? null : new URL(string);
        }

        @Override
        public void write(JsonWriter jsonWriter, URL uRL) throws IOException {
            jsonWriter.value(uRL == null ? null : uRL.toExternalForm());
        }
    };
    public static final TypeAdapterFactory URL_FACTORY = TypeAdapters.newFactory(URL.class, URL);
    public static final TypeAdapter<URI> URI = new TypeAdapter<URI>(){

        @Override
        public URI read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                String string = jsonReader.nextString();
                return string.equals("null") ? null : new URI(string);
            }
            catch (URISyntaxException uRISyntaxException) {
                throw new JsonIOException(uRISyntaxException);
            }
        }

        @Override
        public void write(JsonWriter jsonWriter, URI uRI) throws IOException {
            jsonWriter.value(uRI == null ? null : uRI.toASCIIString());
        }
    };
    public static final TypeAdapterFactory URI_FACTORY = TypeAdapters.newFactory(URI.class, URI);
    public static final TypeAdapter<InetAddress> INET_ADDRESS = new TypeAdapter<InetAddress>(){

        @Override
        public InetAddress read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            InetAddress inetAddress = InetAddress.getByName(jsonReader.nextString());
            return inetAddress;
        }

        @Override
        public void write(JsonWriter jsonWriter, InetAddress inetAddress) throws IOException {
            jsonWriter.value(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    };
    public static final TypeAdapterFactory INET_ADDRESS_FACTORY = TypeAdapters.newTypeHierarchyFactory(InetAddress.class, INET_ADDRESS);
    public static final TypeAdapter<UUID> UUID = new TypeAdapter<UUID>(){

        @Override
        public UUID read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String string = jsonReader.nextString();
            try {
                return java.util.UUID.fromString(string);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                throw new JsonSyntaxException("Failed parsing '" + string + "' as UUID; at path " + jsonReader.getPreviousPath(), illegalArgumentException);
            }
        }

        @Override
        public void write(JsonWriter jsonWriter, UUID uUID) throws IOException {
            jsonWriter.value(uUID == null ? null : uUID.toString());
        }
    };
    public static final TypeAdapterFactory UUID_FACTORY = TypeAdapters.newFactory(UUID.class, UUID);
    public static final TypeAdapter<Currency> CURRENCY = new TypeAdapter<Currency>(){

        @Override
        public Currency read(JsonReader jsonReader) throws IOException {
            String string = jsonReader.nextString();
            try {
                return Currency.getInstance(string);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                throw new JsonSyntaxException("Failed parsing '" + string + "' as Currency; at path " + jsonReader.getPreviousPath(), illegalArgumentException);
            }
        }

        @Override
        public void write(JsonWriter jsonWriter, Currency currency) throws IOException {
            jsonWriter.value(currency.getCurrencyCode());
        }
    }.nullSafe();
    public static final TypeAdapterFactory CURRENCY_FACTORY = TypeAdapters.newFactory(Currency.class, CURRENCY);
    public static final TypeAdapter<Calendar> CALENDAR = new IntegerFieldsTypeAdapter<Calendar>(new String[]{"year", "month", "dayOfMonth", "hourOfDay", "minute", "second"}){

        @Override
        Calendar create(long[] lArray) {
            return new GregorianCalendar(TypeAdapters.toIntExact(lArray[0]), TypeAdapters.toIntExact(lArray[1]), TypeAdapters.toIntExact(lArray[2]), TypeAdapters.toIntExact(lArray[3]), TypeAdapters.toIntExact(lArray[4]), TypeAdapters.toIntExact(lArray[5]));
        }

        @Override
        long[] integerValues(Calendar calendar) {
            return new long[]{calendar.get(1), calendar.get(2), calendar.get(5), calendar.get(11), calendar.get(12), calendar.get(13)};
        }
    };
    public static final TypeAdapterFactory CALENDAR_FACTORY = TypeAdapters.newFactoryForMultipleTypes(Calendar.class, GregorianCalendar.class, CALENDAR);
    public static final TypeAdapter<Locale> LOCALE = new TypeAdapter<Locale>(){

        @Override
        public Locale read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            String string = jsonReader.nextString();
            StringTokenizer stringTokenizer = new StringTokenizer(string, "_");
            String string2 = null;
            String string3 = null;
            String string4 = null;
            if (stringTokenizer.hasMoreElements()) {
                string2 = stringTokenizer.nextToken();
            }
            if (stringTokenizer.hasMoreElements()) {
                string3 = stringTokenizer.nextToken();
            }
            if (stringTokenizer.hasMoreElements()) {
                string4 = stringTokenizer.nextToken();
            }
            if (string3 == null && string4 == null) {
                return new Locale(string2);
            }
            if (string4 == null) {
                return new Locale(string2, string3);
            }
            return new Locale(string2, string3, string4);
        }

        @Override
        public void write(JsonWriter jsonWriter, Locale locale) throws IOException {
            jsonWriter.value(locale == null ? null : locale.toString());
        }
    };
    public static final TypeAdapterFactory LOCALE_FACTORY = TypeAdapters.newFactory(Locale.class, LOCALE);
    public static final TypeAdapter<JsonElement> JSON_ELEMENT = JsonElementTypeAdapter.ADAPTER;
    public static final TypeAdapterFactory JSON_ELEMENT_FACTORY = TypeAdapters.newTypeHierarchyFactory(JsonElement.class, JSON_ELEMENT);
    public static final TypeAdapterFactory ENUM_FACTORY = EnumTypeAdapter.FACTORY;

    private TypeAdapters() {
        throw new UnsupportedOperationException();
    }

    public static TypeAdapter<AtomicLong> atomicLongAdapter(final TypeAdapter<Number> typeAdapter) {
        Objects.requireNonNull(typeAdapter);
        return new TypeAdapter<AtomicLong>(){

            @Override
            public AtomicLong read(JsonReader jsonReader) throws IOException {
                Number number = (Number)typeAdapter.read(jsonReader);
                return new AtomicLong(number.longValue());
            }

            @Override
            public void write(JsonWriter jsonWriter, AtomicLong atomicLong) throws IOException {
                typeAdapter.write(jsonWriter, atomicLong.get());
            }
        }.nullSafe();
    }

    public static TypeAdapter<AtomicLongArray> atomicLongArrayAdapter(final TypeAdapter<Number> typeAdapter) {
        Objects.requireNonNull(typeAdapter);
        return new TypeAdapter<AtomicLongArray>(){

            @Override
            public AtomicLongArray read(JsonReader jsonReader) throws IOException {
                ArrayList<Long> arrayList = new ArrayList<Long>();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    long l = ((Number)typeAdapter.read(jsonReader)).longValue();
                    arrayList.add(l);
                }
                jsonReader.endArray();
                int n = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(n);
                for (int i = 0; i < n; ++i) {
                    atomicLongArray.set(i, (Long)arrayList.get(i));
                }
                return atomicLongArray;
            }

            @Override
            public void write(JsonWriter jsonWriter, AtomicLongArray atomicLongArray) throws IOException {
                jsonWriter.beginArray();
                int n = atomicLongArray.length();
                for (int i = 0; i < n; ++i) {
                    typeAdapter.write(jsonWriter, atomicLongArray.get(i));
                }
                jsonWriter.endArray();
            }
        }.nullSafe();
    }

    private static void checkValidFloatingPoint(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private static int toIntExact(long l) {
        int n = (int)l;
        if ((long)n != l) {
            throw new IllegalArgumentException("Too big for an int: " + l);
        }
        return n;
    }

    public static TypeAdapterFactory javaTimeTypeAdapterFactory() {
        try {
            Class<?> clazz = Class.forName("com.viaversion.viaversion.libs.gson.internal.bind.JavaTimeTypeAdapters");
            FactorySupplier factorySupplier = (FactorySupplier)clazz.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            return factorySupplier.get();
        }
        catch (LinkageError | ReflectiveOperationException throwable) {
            return null;
        }
    }

    public static <TT> TypeAdapterFactory newFactory(final TypeToken<TT> typeToken, final TypeAdapter<TT> typeAdapter) {
        return new TypeAdapterFactory(){

            @Override
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken2) {
                return typeToken2.equals(typeToken) ? typeAdapter : null;
            }
        };
    }

    public static <TT> TypeAdapterFactory newFactory(final Class<TT> clazz, final TypeAdapter<TT> typeAdapter) {
        return new TypeAdapterFactory(){

            @Override
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                return typeToken.getRawType() == clazz ? typeAdapter : null;
            }

            public String toString() {
                return "Factory[type=" + clazz.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static <TT> TypeAdapterFactory newFactory(final Class<TT> clazz, final Class<TT> clazz2, final TypeAdapter<? super TT> typeAdapter) {
        return new TypeAdapterFactory(){

            @Override
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                Class<T> clazz3 = typeToken.getRawType();
                return clazz3 == clazz || clazz3 == clazz2 ? typeAdapter : null;
            }

            public String toString() {
                return "Factory[type=" + clazz2.getName() + "+" + clazz.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static <TT> TypeAdapterFactory newFactoryForMultipleTypes(final Class<TT> clazz, final Class<? extends TT> clazz2, final TypeAdapter<? super TT> typeAdapter) {
        return new TypeAdapterFactory(){

            @Override
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                Class<T> clazz3 = typeToken.getRawType();
                return clazz3 == clazz || clazz3 == clazz2 ? typeAdapter : null;
            }

            public String toString() {
                return "Factory[type=" + clazz.getName() + "+" + clazz2.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static <T1> TypeAdapterFactory newTypeHierarchyFactory(final Class<T1> clazz, final TypeAdapter<T1> typeAdapter) {
        return new TypeAdapterFactory(){

            public <T2> TypeAdapter<T2> create(Gson gson, TypeToken<T2> typeToken) {
                final Class<T2> clazz2 = typeToken.getRawType();
                if (!clazz.isAssignableFrom(clazz2)) {
                    return null;
                }
                return new TypeAdapter<T1>(){

                    @Override
                    public void write(JsonWriter jsonWriter, T1 T1) throws IOException {
                        typeAdapter.write(jsonWriter, T1);
                    }

                    @Override
                    public T1 read(JsonReader jsonReader) throws IOException {
                        Object t = typeAdapter.read(jsonReader);
                        if (t != null && !clazz2.isInstance(t)) {
                            throw new JsonSyntaxException("Expected a " + clazz2.getName() + " but was " + t.getClass().getName() + "; at path " + jsonReader.getPreviousPath());
                        }
                        return t;
                    }
                };
            }

            public String toString() {
                return "Factory[typeHierarchy=" + clazz.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static interface FactorySupplier {
        public TypeAdapterFactory get();
    }

    private static class FloatAdapter
    extends TypeAdapter<Number> {
        private final boolean strict;

        FloatAdapter(boolean bl) {
            this.strict = bl;
        }

        @Override
        public Float read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return Float.valueOf((float)jsonReader.nextDouble());
        }

        @Override
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            if (number == null) {
                jsonWriter.nullValue();
                return;
            }
            float f = number.floatValue();
            if (this.strict) {
                TypeAdapters.checkValidFloatingPoint(f);
            }
            Number number2 = number instanceof Float ? (Number)number : (Number)Float.valueOf(f);
            jsonWriter.value(number2);
        }
    }

    private static class DoubleAdapter
    extends TypeAdapter<Number> {
        private final boolean strict;

        DoubleAdapter(boolean bl) {
            this.strict = bl;
        }

        @Override
        public Double read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return jsonReader.nextDouble();
        }

        @Override
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            if (number == null) {
                jsonWriter.nullValue();
                return;
            }
            double d = number.doubleValue();
            if (this.strict) {
                TypeAdapters.checkValidFloatingPoint(d);
            }
            jsonWriter.value(d);
        }
    }

    public static abstract class IntegerFieldsTypeAdapter<T>
    extends TypeAdapter<T> {
        private final List<String> fields;

        IntegerFieldsTypeAdapter(String ... stringArray) {
            this.fields = Arrays.asList(stringArray);
        }

        abstract T create(long[] var1);

        abstract long[] integerValues(T var1);

        @Override
        public T read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            long[] lArray = new long[this.fields.size()];
            while (jsonReader.peek() != JsonToken.END_OBJECT) {
                String string = jsonReader.nextName();
                int n = this.fields.indexOf(string);
                if (n >= 0) {
                    lArray[n] = jsonReader.nextLong();
                    continue;
                }
                jsonReader.skipValue();
            }
            jsonReader.endObject();
            return this.create(lArray);
        }

        @Override
        public void write(JsonWriter jsonWriter, T t) throws IOException {
            if (t == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            long[] lArray = this.integerValues(t);
            for (int i = 0; i < this.fields.size(); ++i) {
                jsonWriter.name(this.fields.get(i));
                jsonWriter.value(lArray[i]);
            }
            jsonWriter.endObject();
        }
    }
}


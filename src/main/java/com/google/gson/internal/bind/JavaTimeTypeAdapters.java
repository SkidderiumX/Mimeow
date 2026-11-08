/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.bind.IgnoreJRERequirement;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@IgnoreJRERequirement
public class JavaTimeTypeAdapters
implements TypeAdapters.FactorySupplier {
    private static final TypeAdapter<Duration> DURATION = new TypeAdapters.IntegerFieldsTypeAdapter<Duration>(new String[]{"seconds", "nanos"}){

        @Override
        Duration create(long[] lArray) {
            return Duration.ofSeconds(lArray[0], lArray[1]);
        }

        @Override
        long[] integerValues(Duration duration) {
            return new long[]{duration.getSeconds(), duration.getNano()};
        }
    };
    private static final TypeAdapter<Instant> INSTANT = new TypeAdapters.IntegerFieldsTypeAdapter<Instant>(new String[]{"seconds", "nanos"}){

        @Override
        Instant create(long[] lArray) {
            return Instant.ofEpochSecond(lArray[0], lArray[1]);
        }

        @Override
        long[] integerValues(Instant instant) {
            return new long[]{instant.getEpochSecond(), instant.getNano()};
        }
    };
    private static final TypeAdapter<LocalDate> LOCAL_DATE = new TypeAdapters.IntegerFieldsTypeAdapter<LocalDate>(new String[]{"year", "month", "day"}){

        @Override
        LocalDate create(long[] lArray) {
            return LocalDate.of(Math.toIntExact(lArray[0]), Math.toIntExact(lArray[1]), Math.toIntExact(lArray[2]));
        }

        @Override
        long[] integerValues(LocalDate localDate) {
            return new long[]{localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth()};
        }
    };
    public static final TypeAdapter<LocalTime> LOCAL_TIME = new TypeAdapters.IntegerFieldsTypeAdapter<LocalTime>(new String[]{"hour", "minute", "second", "nano"}){

        @Override
        LocalTime create(long[] lArray) {
            return LocalTime.of(Math.toIntExact(lArray[0]), Math.toIntExact(lArray[1]), Math.toIntExact(lArray[2]), Math.toIntExact(lArray[3]));
        }

        @Override
        long[] integerValues(LocalTime localTime) {
            return new long[]{localTime.getHour(), localTime.getMinute(), localTime.getSecond(), localTime.getNano()};
        }
    };
    private static final TypeAdapter<MonthDay> MONTH_DAY = new TypeAdapters.IntegerFieldsTypeAdapter<MonthDay>(new String[]{"month", "day"}){

        @Override
        MonthDay create(long[] lArray) {
            return MonthDay.of(Math.toIntExact(lArray[0]), Math.toIntExact(lArray[1]));
        }

        @Override
        long[] integerValues(MonthDay monthDay) {
            return new long[]{monthDay.getMonthValue(), monthDay.getDayOfMonth()};
        }
    };
    private static final TypeAdapter<Period> PERIOD = new TypeAdapters.IntegerFieldsTypeAdapter<Period>(new String[]{"years", "months", "days"}){

        @Override
        Period create(long[] lArray) {
            return Period.of(Math.toIntExact(lArray[0]), Math.toIntExact(lArray[1]), Math.toIntExact(lArray[2]));
        }

        @Override
        long[] integerValues(Period period) {
            return new long[]{period.getYears(), period.getMonths(), period.getDays()};
        }
    };
    private static final TypeAdapter<Year> YEAR = new TypeAdapters.IntegerFieldsTypeAdapter<Year>(new String[]{"year"}){

        @Override
        Year create(long[] lArray) {
            return Year.of(Math.toIntExact(lArray[0]));
        }

        @Override
        long[] integerValues(Year year) {
            return new long[]{year.getValue()};
        }
    };
    private static final TypeAdapter<YearMonth> YEAR_MONTH = new TypeAdapters.IntegerFieldsTypeAdapter<YearMonth>(new String[]{"year", "month"}){

        @Override
        YearMonth create(long[] lArray) {
            return YearMonth.of(Math.toIntExact(lArray[0]), Math.toIntExact(lArray[1]));
        }

        @Override
        long[] integerValues(YearMonth yearMonth) {
            return new long[]{yearMonth.getYear(), yearMonth.getMonthValue()};
        }
    };
    private static final TypeAdapter<ZoneId> ZONE_ID = new TypeAdapter<ZoneId>(){

        @Override
        public ZoneId read(JsonReader jsonReader) throws IOException {
            jsonReader.beginObject();
            String string = null;
            Integer n = null;
            block8: while (jsonReader.peek() != JsonToken.END_OBJECT) {
                String string2;
                switch (string2 = jsonReader.nextName()) {
                    case "id": {
                        string = jsonReader.nextString();
                        continue block8;
                    }
                    case "totalSeconds": {
                        n = jsonReader.nextInt();
                        continue block8;
                    }
                }
                jsonReader.skipValue();
            }
            jsonReader.endObject();
            if (string != null) {
                return ZoneId.of(string);
            }
            if (n != null) {
                return ZoneOffset.ofTotalSeconds(n);
            }
            throw new JsonSyntaxException("Missing id or totalSeconds field; at path " + jsonReader.getPreviousPath());
        }

        @Override
        public void write(JsonWriter jsonWriter, ZoneId zoneId) throws IOException {
            if (zoneId instanceof ZoneOffset) {
                jsonWriter.beginObject();
                jsonWriter.name("totalSeconds");
                jsonWriter.value(((ZoneOffset)zoneId).getTotalSeconds());
                jsonWriter.endObject();
            } else {
                jsonWriter.beginObject();
                jsonWriter.name("id");
                jsonWriter.value(zoneId.getId());
                jsonWriter.endObject();
            }
        }
    }.nullSafe();
    static final TypeAdapterFactory JAVA_TIME_FACTORY = new TypeAdapterFactory(){

        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            Class<T> clazz = typeToken.getRawType();
            if (!clazz.getName().startsWith("java.time.")) {
                return null;
            }
            TypeAdapter typeAdapter = null;
            if (clazz == Duration.class) {
                typeAdapter = DURATION;
            } else if (clazz == Instant.class) {
                typeAdapter = INSTANT;
            } else if (clazz == LocalDate.class) {
                typeAdapter = LOCAL_DATE;
            } else if (clazz == LocalTime.class) {
                typeAdapter = LOCAL_TIME;
            } else if (clazz == LocalDateTime.class) {
                typeAdapter = JavaTimeTypeAdapters.localDateTime(gson);
            } else if (clazz == MonthDay.class) {
                typeAdapter = MONTH_DAY;
            } else if (clazz == OffsetDateTime.class) {
                typeAdapter = JavaTimeTypeAdapters.offsetDateTime(gson);
            } else if (clazz == OffsetTime.class) {
                typeAdapter = JavaTimeTypeAdapters.offsetTime(gson);
            } else if (clazz == Period.class) {
                typeAdapter = PERIOD;
            } else if (clazz == Year.class) {
                typeAdapter = YEAR;
            } else if (clazz == YearMonth.class) {
                typeAdapter = YEAR_MONTH;
            } else if (clazz == ZoneId.class || clazz == ZoneOffset.class) {
                typeAdapter = ZONE_ID;
            } else if (clazz == ZonedDateTime.class) {
                typeAdapter = JavaTimeTypeAdapters.zonedDateTime(gson);
            }
            TypeAdapter typeAdapter2 = typeAdapter;
            return typeAdapter2;
        }
    };

    JavaTimeTypeAdapters() {
    }

    @Override
    public TypeAdapterFactory get() {
        return JAVA_TIME_FACTORY;
    }

    private static TypeAdapter<LocalDateTime> localDateTime(Gson gson) {
        final TypeAdapter<LocalDate> typeAdapter = gson.getAdapter(LocalDate.class);
        final TypeAdapter<LocalTime> typeAdapter2 = gson.getAdapter(LocalTime.class);
        return new TypeAdapter<LocalDateTime>(){

            @Override
            public LocalDateTime read(JsonReader jsonReader) throws IOException {
                LocalDate localDate = null;
                LocalTime localTime = null;
                jsonReader.beginObject();
                block8: while (jsonReader.peek() != JsonToken.END_OBJECT) {
                    String string;
                    switch (string = jsonReader.nextName()) {
                        case "date": {
                            localDate = (LocalDate)typeAdapter.read(jsonReader);
                            continue block8;
                        }
                        case "time": {
                            localTime = (LocalTime)typeAdapter2.read(jsonReader);
                            continue block8;
                        }
                    }
                    jsonReader.skipValue();
                }
                jsonReader.endObject();
                return LocalDateTime.of((LocalDate)JavaTimeTypeAdapters.requireNonNullField(localDate, "date", jsonReader), (LocalTime)JavaTimeTypeAdapters.requireNonNullField(localTime, "time", jsonReader));
            }

            @Override
            public void write(JsonWriter jsonWriter, LocalDateTime localDateTime) throws IOException {
                jsonWriter.beginObject();
                jsonWriter.name("date");
                typeAdapter.write(jsonWriter, localDateTime.toLocalDate());
                jsonWriter.name("time");
                typeAdapter2.write(jsonWriter, localDateTime.toLocalTime());
                jsonWriter.endObject();
            }
        }.nullSafe();
    }

    private static TypeAdapter<OffsetDateTime> offsetDateTime(Gson gson) {
        final TypeAdapter<LocalDateTime> typeAdapter = JavaTimeTypeAdapters.localDateTime(gson);
        final TypeAdapter<ZoneOffset> typeAdapter2 = gson.getAdapter(ZoneOffset.class);
        return new TypeAdapter<OffsetDateTime>(){

            @Override
            public OffsetDateTime read(JsonReader jsonReader) throws IOException {
                jsonReader.beginObject();
                LocalDateTime localDateTime = null;
                ZoneOffset zoneOffset = null;
                block8: while (jsonReader.peek() != JsonToken.END_OBJECT) {
                    String string;
                    switch (string = jsonReader.nextName()) {
                        case "dateTime": {
                            localDateTime = (LocalDateTime)typeAdapter.read(jsonReader);
                            continue block8;
                        }
                        case "offset": {
                            zoneOffset = (ZoneOffset)typeAdapter2.read(jsonReader);
                            continue block8;
                        }
                    }
                    jsonReader.skipValue();
                }
                jsonReader.endObject();
                return OffsetDateTime.of((LocalDateTime)JavaTimeTypeAdapters.requireNonNullField(localDateTime, "dateTime", jsonReader), (ZoneOffset)JavaTimeTypeAdapters.requireNonNullField(zoneOffset, "offset", jsonReader));
            }

            @Override
            public void write(JsonWriter jsonWriter, OffsetDateTime offsetDateTime) throws IOException {
                jsonWriter.beginObject();
                jsonWriter.name("dateTime");
                typeAdapter.write(jsonWriter, offsetDateTime.toLocalDateTime());
                jsonWriter.name("offset");
                typeAdapter2.write(jsonWriter, offsetDateTime.getOffset());
                jsonWriter.endObject();
            }
        }.nullSafe();
    }

    private static TypeAdapter<OffsetTime> offsetTime(Gson gson) {
        final TypeAdapter<LocalTime> typeAdapter = gson.getAdapter(LocalTime.class);
        final TypeAdapter<ZoneOffset> typeAdapter2 = gson.getAdapter(ZoneOffset.class);
        return new TypeAdapter<OffsetTime>(){

            @Override
            public OffsetTime read(JsonReader jsonReader) throws IOException {
                jsonReader.beginObject();
                LocalTime localTime = null;
                ZoneOffset zoneOffset = null;
                block8: while (jsonReader.peek() != JsonToken.END_OBJECT) {
                    String string;
                    switch (string = jsonReader.nextName()) {
                        case "time": {
                            localTime = (LocalTime)typeAdapter.read(jsonReader);
                            continue block8;
                        }
                        case "offset": {
                            zoneOffset = (ZoneOffset)typeAdapter2.read(jsonReader);
                            continue block8;
                        }
                    }
                    jsonReader.skipValue();
                }
                jsonReader.endObject();
                return OffsetTime.of((LocalTime)JavaTimeTypeAdapters.requireNonNullField(localTime, "time", jsonReader), (ZoneOffset)JavaTimeTypeAdapters.requireNonNullField(zoneOffset, "offset", jsonReader));
            }

            @Override
            public void write(JsonWriter jsonWriter, OffsetTime offsetTime) throws IOException {
                jsonWriter.beginObject();
                jsonWriter.name("time");
                typeAdapter.write(jsonWriter, offsetTime.toLocalTime());
                jsonWriter.name("offset");
                typeAdapter2.write(jsonWriter, offsetTime.getOffset());
                jsonWriter.endObject();
            }
        }.nullSafe();
    }

    private static TypeAdapter<ZonedDateTime> zonedDateTime(Gson gson) {
        final TypeAdapter<LocalDateTime> typeAdapter = JavaTimeTypeAdapters.localDateTime(gson);
        final TypeAdapter<ZoneOffset> typeAdapter2 = gson.getAdapter(ZoneOffset.class);
        final TypeAdapter<ZoneId> typeAdapter3 = gson.getAdapter(ZoneId.class);
        return new TypeAdapter<ZonedDateTime>(){

            @Override
            public ZonedDateTime read(JsonReader jsonReader) throws IOException {
                jsonReader.beginObject();
                LocalDateTime localDateTime = null;
                ZoneOffset zoneOffset = null;
                ZoneId zoneId = null;
                block10: while (jsonReader.peek() != JsonToken.END_OBJECT) {
                    String string;
                    switch (string = jsonReader.nextName()) {
                        case "dateTime": {
                            localDateTime = (LocalDateTime)typeAdapter.read(jsonReader);
                            continue block10;
                        }
                        case "offset": {
                            zoneOffset = (ZoneOffset)typeAdapter2.read(jsonReader);
                            continue block10;
                        }
                        case "zone": {
                            zoneId = (ZoneId)typeAdapter3.read(jsonReader);
                            continue block10;
                        }
                    }
                    jsonReader.skipValue();
                }
                jsonReader.endObject();
                return ZonedDateTime.ofInstant((LocalDateTime)JavaTimeTypeAdapters.requireNonNullField(localDateTime, "dateTime", jsonReader), (ZoneOffset)JavaTimeTypeAdapters.requireNonNullField(zoneOffset, "offset", jsonReader), (ZoneId)JavaTimeTypeAdapters.requireNonNullField(zoneId, "zone", jsonReader));
            }

            @Override
            public void write(JsonWriter jsonWriter, ZonedDateTime zonedDateTime) throws IOException {
                if (zonedDateTime == null) {
                    jsonWriter.nullValue();
                    return;
                }
                jsonWriter.beginObject();
                jsonWriter.name("dateTime");
                typeAdapter.write(jsonWriter, zonedDateTime.toLocalDateTime());
                jsonWriter.name("offset");
                typeAdapter2.write(jsonWriter, zonedDateTime.getOffset());
                jsonWriter.name("zone");
                typeAdapter3.write(jsonWriter, zonedDateTime.getZone());
                jsonWriter.endObject();
            }
        }.nullSafe();
    }

    private static <T> T requireNonNullField(T t, String string, JsonReader jsonReader) {
        if (t == null) {
            throw new JsonSyntaxException("Missing " + string + " field; at path " + jsonReader.getPreviousPath());
        }
        return t;
    }
}


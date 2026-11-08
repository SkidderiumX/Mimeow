/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.gson;

import com.viaversion.viaversion.libs.gson.JsonParseException;
import com.viaversion.viaversion.libs.gson.ToNumberStrategy;
import com.viaversion.viaversion.libs.gson.internal.LazilyParsedNumber;
import com.viaversion.viaversion.libs.gson.internal.NumberLimits;
import com.viaversion.viaversion.libs.gson.stream.JsonReader;
import com.viaversion.viaversion.libs.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.math.BigDecimal;

public enum ToNumberPolicy implements ToNumberStrategy
{
    DOUBLE{

        @Override
        public Double readNumber(JsonReader jsonReader) throws IOException {
            return jsonReader.nextDouble();
        }
    }
    ,
    LAZILY_PARSED_NUMBER{

        @Override
        public Number readNumber(JsonReader jsonReader) throws IOException {
            return new LazilyParsedNumber(jsonReader.nextString());
        }
    }
    ,
    LONG_OR_DOUBLE{

        @Override
        public Number readNumber(JsonReader jsonReader) throws IOException, JsonParseException {
            String string = jsonReader.nextString();
            if (string.indexOf(46) >= 0) {
                return this.parseAsDouble(string, jsonReader);
            }
            try {
                return Long.parseLong(string);
            }
            catch (NumberFormatException numberFormatException) {
                return this.parseAsDouble(string, jsonReader);
            }
        }

        private Number parseAsDouble(String string, JsonReader jsonReader) throws IOException {
            try {
                Double d = Double.valueOf(string);
                if ((d.isInfinite() || d.isNaN()) && !jsonReader.isLenient()) {
                    throw new MalformedJsonException("JSON forbids NaN and infinities: " + d + "; at path " + jsonReader.getPreviousPath());
                }
                return d;
            }
            catch (NumberFormatException numberFormatException) {
                throw new JsonParseException("Cannot parse " + string + "; at path " + jsonReader.getPreviousPath(), numberFormatException);
            }
        }
    }
    ,
    BIG_DECIMAL{

        @Override
        public BigDecimal readNumber(JsonReader jsonReader) throws IOException {
            String string = jsonReader.nextString();
            try {
                return NumberLimits.parseBigDecimal(string);
            }
            catch (NumberFormatException numberFormatException) {
                throw new JsonParseException("Cannot parse " + string + "; at path " + jsonReader.getPreviousPath(), numberFormatException);
            }
        }
    };

}


/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.gson.elements;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Nonnull;
import net.lenni0451.commons.gson.elements.GsonArray;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.lenni0451.commons.gson.elements.GsonPrimitive;

public class GsonElement {
    private final JsonElement element;

    public static GsonElement wrap(JsonElement jsonElement) {
        if (jsonElement instanceof JsonObject) {
            return new GsonObject(jsonElement.getAsJsonObject());
        }
        if (jsonElement instanceof JsonArray) {
            return new GsonArray(jsonElement.getAsJsonArray());
        }
        if (jsonElement instanceof JsonPrimitive) {
            return new GsonPrimitive(jsonElement.getAsJsonPrimitive());
        }
        return new GsonElement(jsonElement);
    }

    protected GsonElement(@Nonnull JsonElement jsonElement) {
        this.element = jsonElement;
    }

    @Nonnull
    public JsonElement getJsonElement() {
        return this.element;
    }

    public GsonElement deepCopy() {
        return GsonElement.wrap(this.element.deepCopy());
    }

    public boolean isObject() {
        return this.element.isJsonObject();
    }

    public boolean isArray() {
        return this.element.isJsonArray();
    }

    public boolean isPrimitive() {
        return this.element.isJsonPrimitive();
    }

    public boolean isNull() {
        return this.element.isJsonNull();
    }

    public GsonObject asObject() {
        if (this instanceof GsonObject) {
            return (GsonObject)this;
        }
        return new GsonObject(this.element.getAsJsonObject());
    }

    public GsonArray asArray() {
        if (this instanceof GsonArray) {
            return (GsonArray)this;
        }
        return new GsonArray(this.element.getAsJsonArray());
    }

    public GsonPrimitive asPrimitive() {
        if (this instanceof GsonPrimitive) {
            return (GsonPrimitive)this;
        }
        return new GsonPrimitive(this.element.getAsJsonPrimitive());
    }

    public boolean asBoolean() {
        return this.element.getAsBoolean();
    }

    public byte asByte() {
        return this.element.getAsByte();
    }

    public short asShort() {
        return this.element.getAsShort();
    }

    public int asInt() {
        return this.element.getAsInt();
    }

    public long asLong() {
        return this.element.getAsLong();
    }

    public float asFloat() {
        return this.element.getAsFloat();
    }

    public double asDouble() {
        return this.element.getAsDouble();
    }

    public BigInteger asBigInteger() {
        return this.element.getAsBigInteger();
    }

    public BigDecimal asBigDecimal() {
        return this.element.getAsBigDecimal();
    }

    public Number asNumber() {
        return this.element.getAsNumber();
    }

    public String asString() {
        return this.element.getAsString();
    }

    public String toString() {
        return this.element.toString();
    }

    public boolean equals(Object object) {
        if (object instanceof GsonElement) {
            return this.element.equals(((GsonElement)object).element);
        }
        if (object instanceof JsonElement) {
            return this.element.equals(object);
        }
        return false;
    }

    public int hashCode() {
        return this.element.hashCode();
    }
}


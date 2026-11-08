/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.gson.elements;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.lenni0451.commons.gson.elements.GsonArray;
import net.lenni0451.commons.gson.elements.GsonElement;
import net.lenni0451.commons.gson.elements.GsonPrimitive;

public class GsonObject
extends GsonElement
implements Iterable<Map.Entry<String, GsonElement>> {
    private final JsonObject object;

    public GsonObject() {
        this(new JsonObject());
    }

    public GsonObject(JsonObject jsonObject) {
        super(jsonObject);
        this.object = jsonObject;
    }

    public JsonObject getJsonObject() {
        return this.object;
    }

    public GsonObject add(String string, @Nullable JsonElement jsonElement) {
        this.object.add(string, jsonElement);
        return this;
    }

    public GsonObject add(String string, @Nullable GsonElement gsonElement) {
        this.object.add(string, gsonElement == null ? null : gsonElement.getJsonElement());
        return this;
    }

    public GsonObject add(String string, boolean bl) {
        this.object.addProperty(string, bl);
        return this;
    }

    public GsonObject add(String string, @Nullable Number number) {
        this.object.addProperty(string, number);
        return this;
    }

    public GsonObject add(String string, @Nullable String string2) {
        this.object.addProperty(string, string2);
        return this;
    }

    public GsonObject addAll(JsonObject jsonObject) {
        jsonObject.asMap().forEach(this.object::add);
        return this;
    }

    public GsonObject addAll(GsonObject gsonObject) {
        gsonObject.getJsonObject().asMap().forEach(this.object::add);
        return this;
    }

    public GsonElement remove(String string) {
        JsonElement jsonElement = this.object.remove(string);
        if (jsonElement == null) {
            return null;
        }
        return GsonElement.wrap(jsonElement);
    }

    public GsonObject clear() {
        this.object.asMap().clear();
        return this;
    }

    public boolean has(String string) {
        return this.object.has(string);
    }

    public boolean hasObject(String string) {
        return this.object.has(string) && this.object.get(string).isJsonObject();
    }

    public boolean hasArray(String string) {
        return this.object.has(string) && this.object.get(string).isJsonArray();
    }

    public boolean hasPrimitive(String string) {
        return this.object.has(string) && this.object.get(string).isJsonPrimitive();
    }

    public boolean hasBoolean(String string) {
        return this.object.has(string) && this.object.get(string).isJsonPrimitive() && this.object.get(string).getAsJsonPrimitive().isBoolean();
    }

    public boolean hasNumber(String string) {
        return this.object.has(string) && this.object.get(string).isJsonPrimitive() && this.object.get(string).getAsJsonPrimitive().isNumber();
    }

    public boolean hasString(String string) {
        return this.object.has(string) && this.object.get(string).isJsonPrimitive() && this.object.get(string).getAsJsonPrimitive().isString();
    }

    public GsonElement get(String string) {
        return this.get(string, null);
    }

    public GsonElement get(String string, @Nullable GsonElement gsonElement) {
        return this.has(string) ? GsonElement.wrap(this.object.get(string)) : gsonElement;
    }

    public Optional<GsonElement> opt(String string) {
        return Optional.ofNullable(this.get(string, null));
    }

    @Nonnull
    public GsonElement req(String string) {
        GsonElement gsonElement = this.get(string, null);
        if (gsonElement == null) {
            throw new NoSuchElementException("No element found for key: " + string);
        }
        return gsonElement;
    }

    public GsonObject getObject(String string) {
        return this.getObject(string, null);
    }

    public GsonObject getObject(String string, @Nullable GsonObject gsonObject) {
        return this.hasObject(string) ? this.get(string, gsonObject).asObject() : gsonObject;
    }

    public Optional<GsonObject> optObject(String string) {
        return Optional.ofNullable(this.getObject(string, null));
    }

    @Nonnull
    public GsonObject reqObject(String string) {
        GsonObject gsonObject = this.getObject(string, null);
        if (gsonObject == null) {
            throw new NoSuchElementException("No object found for key: " + string);
        }
        return gsonObject;
    }

    public GsonArray getArray(String string) {
        return this.getArray(string, null);
    }

    public GsonArray getArray(String string, @Nullable GsonArray gsonArray) {
        return this.hasArray(string) ? this.get(string, gsonArray).asArray() : gsonArray;
    }

    public Optional<GsonArray> optArray(String string) {
        return Optional.ofNullable(this.getArray(string, null));
    }

    @Nonnull
    public GsonArray reqArray(String string) {
        GsonArray gsonArray = this.getArray(string, null);
        if (gsonArray == null) {
            throw new NoSuchElementException("No array found for key: " + string);
        }
        return gsonArray;
    }

    public GsonPrimitive getPrimitive(String string) {
        return this.getPrimitive(string, null);
    }

    public GsonPrimitive getPrimitive(String string, @Nullable GsonPrimitive gsonPrimitive) {
        return this.hasPrimitive(string) ? this.get(string, gsonPrimitive).asPrimitive() : gsonPrimitive;
    }

    public Optional<GsonPrimitive> optPrimitive(String string) {
        return Optional.ofNullable(this.getPrimitive(string, null));
    }

    @Nonnull
    public GsonPrimitive reqPrimitive(String string) {
        GsonPrimitive gsonPrimitive = this.getPrimitive(string, null);
        if (gsonPrimitive == null) {
            throw new NoSuchElementException("No primitive found for key: " + string);
        }
        return gsonPrimitive;
    }

    public boolean getBoolean(String string) {
        return this.getBoolean(string, false);
    }

    public boolean getBoolean(String string, boolean bl) {
        return this.hasBoolean(string) ? this.object.get(string).getAsBoolean() : bl;
    }

    public boolean reqBoolean(String string) {
        if (!this.hasBoolean(string)) {
            throw new NoSuchElementException("No boolean found for key: " + string);
        }
        return this.getBoolean(string);
    }

    public byte getByte(String string) {
        return this.getByte(string, (byte)0);
    }

    public byte getByte(String string, byte by) {
        return this.hasNumber(string) ? this.object.get(string).getAsByte() : by;
    }

    public byte reqByte(String string) {
        if (!this.hasNumber(string)) {
            throw new NoSuchElementException("No byte found for key: " + string);
        }
        return this.getByte(string);
    }

    public short getShort(String string) {
        return this.getShort(string, (short)0);
    }

    public short getShort(String string, short s) {
        return this.hasNumber(string) ? this.object.get(string).getAsShort() : s;
    }

    public short reqShort(String string) {
        if (!this.hasNumber(string)) {
            throw new NoSuchElementException("No short found for key: " + string);
        }
        return this.getShort(string);
    }

    public int getInt(String string) {
        return this.getInt(string, 0);
    }

    public int getInt(String string, int n) {
        return this.hasNumber(string) ? this.object.get(string).getAsInt() : n;
    }

    public OptionalInt optInt(String string) {
        return this.hasNumber(string) ? OptionalInt.of(this.object.get(string).getAsInt()) : OptionalInt.empty();
    }

    public int reqInt(String string) {
        if (!this.hasNumber(string)) {
            throw new NoSuchElementException("No int found for key: " + string);
        }
        return this.getInt(string);
    }

    public long getLong(String string) {
        return this.getLong(string, 0L);
    }

    public long getLong(String string, long l) {
        return this.hasNumber(string) ? this.object.get(string).getAsLong() : l;
    }

    public OptionalLong optLong(String string) {
        return this.hasNumber(string) ? OptionalLong.of(this.object.get(string).getAsLong()) : OptionalLong.empty();
    }

    public long reqLong(String string) {
        if (!this.hasNumber(string)) {
            throw new NoSuchElementException("No long found for key: " + string);
        }
        return this.getLong(string);
    }

    public float getFloat(String string) {
        return this.getFloat(string, 0.0f);
    }

    public float getFloat(String string, float f) {
        return this.hasNumber(string) ? this.object.get(string).getAsFloat() : f;
    }

    public float reqFloat(String string) {
        if (!this.hasNumber(string)) {
            throw new NoSuchElementException("No float found for key: " + string);
        }
        return this.getFloat(string);
    }

    public double getDouble(String string) {
        return this.getDouble(string, 0.0);
    }

    public double getDouble(String string, double d) {
        return this.hasNumber(string) ? this.object.get(string).getAsDouble() : d;
    }

    public OptionalDouble optDouble(String string) {
        return this.hasNumber(string) ? OptionalDouble.of(this.object.get(string).getAsDouble()) : OptionalDouble.empty();
    }

    public double reqDouble(String string) {
        if (!this.hasNumber(string)) {
            throw new NoSuchElementException("No double found for key: " + string);
        }
        return this.getDouble(string);
    }

    public Number getNumber(String string) {
        return this.getNumber(string, null);
    }

    public Number getNumber(String string, @Nullable Number number) {
        return this.hasNumber(string) ? (Number)this.object.get(string).getAsNumber() : (Number)number;
    }

    public Optional<Number> optNumber(String string) {
        return Optional.ofNullable(this.getNumber(string, null));
    }

    @Nonnull
    public Number reqNumber(String string) {
        if (!this.hasNumber(string)) {
            throw new NoSuchElementException("No number found for key: " + string);
        }
        return this.getNumber(string);
    }

    public String getString(String string) {
        return this.getString(string, null);
    }

    public String getString(String string, @Nullable String string2) {
        return this.hasString(string) ? this.object.get(string).getAsString() : string2;
    }

    public Optional<String> optString(String string) {
        return Optional.ofNullable(this.getString(string, null));
    }

    @Nonnull
    public String reqString(String string) {
        String string2 = this.getString(string, null);
        if (string2 == null) {
            throw new NoSuchElementException("No string found for key: " + string);
        }
        return string2;
    }

    public int size() {
        return this.object.size();
    }

    public boolean isEmpty() {
        return this.object.isEmpty();
    }

    public Set<String> keySet() {
        return this.object.keySet();
    }

    public Set<Map.Entry<String, GsonElement>> entrySet() {
        return this.object.entrySet().stream().map(WrappedMapEntry::new).collect(Collectors.toSet());
    }

    @Override
    @Nonnull
    public Iterator<Map.Entry<String, GsonElement>> iterator() {
        return new WrappedIterator(this.object.entrySet().iterator());
    }

    public Stream<Map.Entry<String, GsonElement>> stream() {
        return StreamSupport.stream(this.spliterator(), false);
    }

    public Map<String, GsonElement> asMap() {
        HashMap<String, GsonElement> hashMap = new HashMap<String, GsonElement>();
        for (Map.Entry<String, JsonElement> entry : this.object.entrySet()) {
            hashMap.put(entry.getKey(), GsonElement.wrap(entry.getValue()));
        }
        return hashMap;
    }

    public <T> Map<String, T> asMap(Function<GsonElement, T> function) {
        HashMap<String, T> hashMap = new HashMap<String, T>();
        for (Map.Entry<String, JsonElement> entry : this.object.entrySet()) {
            hashMap.put(entry.getKey(), function.apply(GsonElement.wrap(entry.getValue())));
        }
        return hashMap;
    }

    private static class WrappedIterator
    implements Iterator<Map.Entry<String, GsonElement>> {
        private final Iterator<Map.Entry<String, JsonElement>> iterator;

        public WrappedIterator(Iterator<Map.Entry<String, JsonElement>> iterator2) {
            this.iterator = iterator2;
        }

        @Override
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override
        public Map.Entry<String, GsonElement> next() {
            return new WrappedMapEntry(this.iterator.next());
        }

        @Override
        public void remove() {
            this.iterator.remove();
        }
    }

    private static class WrappedMapEntry
    implements Map.Entry<String, GsonElement> {
        private final Map.Entry<String, JsonElement> entry;

        public WrappedMapEntry(Map.Entry<String, JsonElement> entry) {
            this.entry = entry;
        }

        @Override
        public String getKey() {
            return this.entry.getKey();
        }

        @Override
        public GsonElement getValue() {
            return GsonElement.wrap(this.entry.getValue());
        }

        @Override
        public GsonElement setValue(GsonElement gsonElement) {
            JsonElement jsonElement = this.entry.setValue(gsonElement.getJsonElement());
            if (jsonElement == null) {
                return null;
            }
            return GsonElement.wrap(jsonElement);
        }
    }
}


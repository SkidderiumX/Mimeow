/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.gson.elements;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.lenni0451.commons.gson.elements.GsonElement;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.lenni0451.commons.gson.elements.GsonPrimitive;

public class GsonArray
extends GsonElement
implements Iterable<GsonElement> {
    private final JsonArray array;

    public GsonArray() {
        this(new JsonArray());
    }

    public GsonArray(JsonArray jsonArray) {
        super(jsonArray);
        this.array = jsonArray;
    }

    public JsonArray getJsonArray() {
        return this.array;
    }

    public GsonArray add(@Nullable JsonElement jsonElement) {
        this.array.add(jsonElement);
        return this;
    }

    public GsonArray add(@Nullable GsonElement gsonElement) {
        this.array.add(gsonElement == null ? null : gsonElement.getJsonElement());
        return this;
    }

    public GsonArray add(boolean bl) {
        this.array.add(bl);
        return this;
    }

    public GsonArray add(@Nullable Number number) {
        this.array.add(number);
        return this;
    }

    public GsonArray add(@Nullable String string) {
        this.array.add(string);
        return this;
    }

    public GsonArray addAll(JsonArray jsonArray) {
        this.array.addAll(jsonArray);
        return this;
    }

    public GsonArray addAll(GsonArray gsonArray) {
        this.array.addAll(gsonArray.getJsonArray());
        return this;
    }

    public GsonElement set(int n, JsonElement jsonElement) {
        JsonElement jsonElement2 = this.array.set(n, jsonElement);
        if (jsonElement2 == null) {
            return null;
        }
        return GsonElement.wrap(jsonElement2);
    }

    public GsonElement set(int n, GsonElement gsonElement) {
        JsonElement jsonElement = this.array.set(n, gsonElement.getJsonElement());
        if (jsonElement == null) {
            return null;
        }
        return GsonElement.wrap(jsonElement);
    }

    public GsonElement set(int n, boolean bl) {
        JsonElement jsonElement = this.array.set(n, new JsonPrimitive(bl));
        if (jsonElement == null) {
            return null;
        }
        return GsonElement.wrap(jsonElement);
    }

    public GsonElement set(int n, Number number) {
        JsonElement jsonElement = this.array.set(n, new JsonPrimitive(number));
        if (jsonElement == null) {
            return null;
        }
        return GsonElement.wrap(jsonElement);
    }

    public GsonElement set(int n, String string) {
        JsonElement jsonElement = this.array.set(n, new JsonPrimitive(string));
        if (jsonElement == null) {
            return null;
        }
        return GsonElement.wrap(jsonElement);
    }

    public GsonElement get(int n) {
        return GsonElement.wrap(this.array.get(n));
    }

    public GsonObject getObject(int n) {
        return this.get(n).asObject();
    }

    public GsonArray getArray(int n) {
        return this.get(n).asArray();
    }

    public GsonPrimitive getPrimitive(int n) {
        return this.get(n).asPrimitive();
    }

    public boolean getBoolean(int n) {
        return this.get(n).asBoolean();
    }

    public byte getByte(int n) {
        return this.get(n).asByte();
    }

    public short getShort(int n) {
        return this.get(n).asShort();
    }

    public int getInt(int n) {
        return this.get(n).asInt();
    }

    public long getLong(int n) {
        return this.get(n).asLong();
    }

    public float getFloat(int n) {
        return this.get(n).asFloat();
    }

    public double getDouble(int n) {
        return this.get(n).asDouble();
    }

    public Number getNumber(int n) {
        return this.get(n).asNumber();
    }

    public String getString(int n) {
        return this.get(n).asString();
    }

    public GsonElement remove(int n) {
        JsonElement jsonElement = this.array.remove(n);
        if (jsonElement == null) {
            return null;
        }
        return GsonElement.wrap(jsonElement);
    }

    public boolean remove(@Nullable JsonElement jsonElement) {
        return this.array.remove(jsonElement == null ? JsonNull.INSTANCE : jsonElement);
    }

    public boolean remove(@Nullable GsonElement gsonElement) {
        return this.array.remove(gsonElement == null ? JsonNull.INSTANCE : gsonElement.getJsonElement());
    }

    public boolean removeBoolean(boolean bl) {
        return this.remove(new JsonPrimitive(bl));
    }

    public boolean removeNumber(Number number) {
        return this.remove(new JsonPrimitive(number));
    }

    public boolean removeString(String string) {
        return this.remove(new JsonPrimitive(string));
    }

    public boolean removeAll(JsonArray jsonArray) {
        boolean bl = false;
        for (JsonElement jsonElement : jsonArray) {
            bl |= this.array.remove(jsonElement);
        }
        return bl;
    }

    public boolean removeAll(GsonArray gsonArray) {
        return this.removeAll(gsonArray.getJsonArray());
    }

    public GsonArray clear() {
        while (!this.array.isEmpty()) {
            this.array.remove(0);
        }
        return this;
    }

    public boolean has(int n) {
        return n >= 0 && n < this.array.size();
    }

    public boolean has(@Nullable JsonElement jsonElement) {
        return this.array.contains(jsonElement == null ? JsonNull.INSTANCE : jsonElement);
    }

    public boolean has(@Nullable GsonElement gsonElement) {
        return this.array.contains(gsonElement == null ? JsonNull.INSTANCE : gsonElement.getJsonElement());
    }

    public int size() {
        return this.array.size();
    }

    public boolean isEmpty() {
        return this.array.isEmpty();
    }

    @Override
    @Nonnull
    public Iterator<GsonElement> iterator() {
        return new WrappedIterator(this.array.iterator());
    }

    public Stream<GsonElement> stream() {
        return StreamSupport.stream(this.spliterator(), false);
    }

    public List<GsonElement> asList() {
        ArrayList<GsonElement> arrayList = new ArrayList<GsonElement>();
        for (JsonElement jsonElement : this.array) {
            arrayList.add(GsonElement.wrap(jsonElement));
        }
        return arrayList;
    }

    public <T> List<T> asList(Function<GsonElement, T> function) {
        ArrayList<T> arrayList = new ArrayList<T>();
        for (JsonElement jsonElement : this.array) {
            arrayList.add(function.apply(GsonElement.wrap(jsonElement)));
        }
        return arrayList;
    }

    private static class WrappedIterator
    implements Iterator<GsonElement> {
        private final Iterator<JsonElement> iterator;

        public WrappedIterator(Iterator<JsonElement> iterator2) {
            this.iterator = iterator2;
        }

        @Override
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override
        public GsonElement next() {
            return GsonElement.wrap(this.iterator.next());
        }

        @Override
        public void remove() {
            this.iterator.remove();
        }
    }
}


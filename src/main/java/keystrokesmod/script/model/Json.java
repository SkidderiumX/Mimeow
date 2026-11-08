/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public class Json {
    private final JsonElement element;
    private final Type type;

    private Json(JsonElement jsonElement) {
        JsonPrimitive jsonPrimitive;
        this.element = jsonElement;
        this.type = jsonElement.isJsonObject() ? Type.OBJECT : (jsonElement.isJsonArray() ? Type.ARRAY : (jsonElement.isJsonPrimitive() ? ((jsonPrimitive = jsonElement.getAsJsonPrimitive()).isBoolean() ? Type.BOOLEAN : (jsonPrimitive.isNumber() ? Type.NUMBER : Type.STRING)) : (jsonElement.isJsonNull() ? Type.NULL : Type.NULL)));
    }

    public static Json parse(String string) {
        return new Json(new JsonParser().parse(string));
    }

    public static Json object() {
        return new Json(new JsonObject());
    }

    public static Json array() {
        return new Json(new JsonArray());
    }

    public static Json string(String string) {
        return new Json(new JsonPrimitive(string));
    }

    public static Json number(Number number) {
        return new Json(new JsonPrimitive(number));
    }

    public static Json booleanValue(boolean bl) {
        return new Json(new JsonPrimitive(bl));
    }

    public static Json nullValue() {
        return new Json(JsonNull.INSTANCE);
    }

    public Type type() {
        return this.type;
    }

    private void ensureObject() {
        if (this.type != Type.OBJECT) {
            throw new IllegalStateException("Not a JSON object: " + String.valueOf((Object)this.type));
        }
    }

    public Json add(String string, Json json) {
        this.ensureObject();
        this.element.getAsJsonObject().add(string, json.element);
        return this;
    }

    public Json add(String string, String string2) {
        return this.add(string, Json.string(string2));
    }

    public Json add(String string, Number number) {
        return this.add(string, Json.number(number));
    }

    public Json add(String string, boolean bl) {
        return this.add(string, Json.booleanValue(bl));
    }

    public Json get(String string) {
        this.ensureObject();
        JsonElement jsonElement = this.element.getAsJsonObject().get(string);
        return jsonElement == null ? Json.nullValue() : new Json(jsonElement);
    }

    public boolean has(String string) {
        this.ensureObject();
        return this.element.getAsJsonObject().has(string);
    }

    private void ensureArray() {
        if (this.type != Type.ARRAY) {
            throw new IllegalStateException("Not a JSON array: " + String.valueOf((Object)this.type));
        }
    }

    public Json add(Json json) {
        this.ensureArray();
        this.element.getAsJsonArray().add(json.element);
        return this;
    }

    public Json add(String string) {
        return this.add(Json.string(string));
    }

    public Json add(Number number) {
        return this.add(Json.number(number));
    }

    public Json add(boolean bl) {
        return this.add(Json.booleanValue(bl));
    }

    public List<Json> asArray() {
        this.ensureArray();
        ArrayList<Json> arrayList = new ArrayList<Json>();
        for (JsonElement jsonElement : this.element.getAsJsonArray()) {
            arrayList.add(new Json(jsonElement));
        }
        return arrayList;
    }

    private void ensurePrimitive() {
        if (this.type != Type.STRING && this.type != Type.NUMBER && this.type != Type.BOOLEAN) {
            throw new IllegalStateException("Not a primitive: " + String.valueOf((Object)this.type));
        }
    }

    public String asString() {
        this.ensurePrimitive();
        return this.element.getAsString();
    }

    public int asInt() {
        this.ensurePrimitive();
        return this.element.getAsInt();
    }

    public double asDouble() {
        this.ensurePrimitive();
        return this.element.getAsDouble();
    }

    public long asLong() {
        this.ensurePrimitive();
        return this.element.getAsLong();
    }

    public float asFloat() {
        this.ensurePrimitive();
        return this.element.getAsFloat();
    }

    public boolean asBoolean() {
        this.ensurePrimitive();
        return this.element.getAsBoolean();
    }

    public LinkedHashSet<String> keys() {
        this.ensureObject();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        for (Map.Entry<String, JsonElement> entry : this.element.getAsJsonObject().entrySet()) {
            linkedHashSet.add(entry.getKey());
        }
        return linkedHashSet;
    }

    public Json remove(String string) {
        this.ensureObject();
        this.element.getAsJsonObject().remove(string);
        return this;
    }

    public Json remove(int n) {
        this.ensureArray();
        if (n < 0) {
            return this;
        }
        JsonArray jsonArray = this.element.getAsJsonArray();
        int n2 = 0;
        Iterator<JsonElement> iterator2 = jsonArray.iterator();
        while (iterator2.hasNext()) {
            iterator2.next();
            if (n2 == n) {
                iterator2.remove();
                break;
            }
            ++n2;
        }
        return this;
    }

    public String toString() {
        return this.element.toString();
    }

    public static final class Type
    extends Enum<Type> {
        public static final /* enum */ Type OBJECT = new Type();
        public static final /* enum */ Type ARRAY = new Type();
        public static final /* enum */ Type STRING = new Type();
        public static final /* enum */ Type NUMBER = new Type();
        public static final /* enum */ Type BOOLEAN = new Type();
        public static final /* enum */ Type NULL = new Type();
        private static final /* synthetic */ Type[] $VALUES;

        public static Type[] values() {
            return (Type[])$VALUES.clone();
        }

        public static Type valueOf(String string) {
            return Enum.valueOf(Type.class, string);
        }

        private static /* synthetic */ Type[] $values() {
            Type[] typeArray = new Type[0x649EA6FC ^ 0x649EA6FA];
            typeArray[0] = OBJECT;
            typeArray[1] = ARRAY;
            typeArray[0x649EA6F8 ^ 0x649EA6FA] = STRING;
            typeArray[0x649EA6F9 ^ 0x649EA6FA] = NUMBER;
            typeArray[0x649EA6FE ^ 0x649EA6FA] = BOOLEAN;
            typeArray[0x649EA6FF ^ 0x649EA6FA] = NULL;
            return typeArray;
        }

        static {
            $VALUES = Type.$values();
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.gson;

import java.util.function.Function;
import java.util.stream.Collector;
import net.lenni0451.commons.gson.elements.GsonArray;
import net.lenni0451.commons.gson.elements.GsonElement;
import net.lenni0451.commons.gson.elements.GsonObject;

public class GsonCollectors {
    public static <T extends GsonElement> Collector<T, ?, GsonArray> toArray() {
        return Collector.of(GsonArray::new, GsonArray::add, (gsonArray, gsonArray2) -> {
            if (gsonArray.isEmpty()) {
                return gsonArray2;
            }
            if (gsonArray2.isEmpty()) {
                return gsonArray;
            }
            GsonArray gsonArray3 = new GsonArray();
            gsonArray3.addAll((GsonArray)gsonArray);
            gsonArray3.addAll((GsonArray)gsonArray2);
            return gsonArray3;
        }, new Collector.Characteristics[0]);
    }

    public static <P, V extends GsonElement> Collector<P, ?, GsonObject> toObject(Function<P, String> function, Function<P, V> function2) {
        return Collector.of(GsonObject::new, (gsonObject, object) -> gsonObject.add((String)function.apply(object), (GsonElement)function2.apply(object)), (gsonObject, gsonObject2) -> {
            if (gsonObject.isEmpty()) {
                return gsonObject2;
            }
            if (gsonObject2.isEmpty()) {
                return gsonObject;
            }
            GsonObject gsonObject3 = new GsonObject();
            gsonObject3.addAll((GsonObject)gsonObject);
            gsonObject3.addAll((GsonObject)gsonObject2);
            return gsonObject3;
        }, new Collector.Characteristics[0]);
    }
}


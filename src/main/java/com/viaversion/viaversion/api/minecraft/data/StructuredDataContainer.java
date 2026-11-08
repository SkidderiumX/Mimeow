/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.data;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.data.FullMappings;
import com.viaversion.viaversion.api.minecraft.data.StructuredData;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntFunction;
import com.viaversion.viaversion.libs.fastutil.objects.Reference2ObjectOpenHashMap;
import com.viaversion.viaversion.util.Copyable;
import com.viaversion.viaversion.util.Unit;
import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import org.checkerframework.checker.nullness.qual.Nullable;

public class StructuredDataContainer
implements Copyable {
    private final Map<StructuredDataKey<?>, StructuredData<?>> data;
    private FullMappings lookup;
    private boolean mappedNames;

    public StructuredDataContainer(Map<StructuredDataKey<?>, StructuredData<?>> map) {
        this.data = map;
    }

    public StructuredDataContainer(StructuredData<?>[] structuredDataArray) {
        this(new Reference2ObjectOpenHashMap(structuredDataArray.length));
        for (StructuredData<?> structuredData : structuredDataArray) {
            this.data.put(structuredData.key(), structuredData);
        }
    }

    public StructuredDataContainer() {
        this(new Reference2ObjectOpenHashMap(0));
    }

    public <T> @Nullable T get(StructuredDataKey<T> structuredDataKey) {
        StructuredData<?> structuredData = this.data.get(structuredDataKey);
        if (structuredData == null || structuredData.isEmpty()) {
            return null;
        }
        return (T)structuredData.value();
    }

    public <T> @Nullable StructuredData<T> getData(StructuredDataKey<T> structuredDataKey) {
        return this.data.get(structuredDataKey);
    }

    public <T> @Nullable StructuredData<T> getNonEmptyData(StructuredDataKey<T> structuredDataKey) {
        StructuredData<?> structuredData = this.data.get(structuredDataKey);
        return structuredData != null && structuredData.isPresent() ? structuredData : null;
    }

    public <T> void set(StructuredDataKey<T> structuredDataKey, T t) {
        int n = this.serializerId(structuredDataKey);
        if (n != -1) {
            this.data.put(structuredDataKey, StructuredData.of(structuredDataKey, t, n));
        }
    }

    public void set(StructuredDataKey<Unit> structuredDataKey) {
        this.set(structuredDataKey, Unit.INSTANCE);
    }

    public void setEmpty(StructuredDataKey<?> structuredDataKey) {
        this.data.put(structuredDataKey, StructuredData.empty(structuredDataKey, this.serializerId(structuredDataKey)));
    }

    public <T> void replace(StructuredDataKey<T> structuredDataKey, Function<T, @Nullable T> function) {
        StructuredData<T> structuredData = this.getNonEmptyData(structuredDataKey);
        if (structuredData == null) {
            return;
        }
        T t = function.apply(structuredData.value());
        if (t != null) {
            structuredData.setValue(t);
        } else {
            this.data.remove(structuredDataKey);
        }
    }

    public <T> void replaceKey(StructuredDataKey<T> structuredDataKey, StructuredDataKey<T> structuredDataKey2) {
        this.replace(structuredDataKey, structuredDataKey2, Function.identity());
    }

    public <T, V> void replace(StructuredDataKey<T> structuredDataKey, StructuredDataKey<V> structuredDataKey2, Function<T, @Nullable V> function) {
        this.replace(structuredDataKey, structuredDataKey2, function, null);
    }

    public <T, V> void replace(StructuredDataKey<T> structuredDataKey, StructuredDataKey<V> structuredDataKey2, Function<T, @Nullable V> function, Runnable runnable2) {
        StructuredData<?> structuredData = this.data.remove(structuredDataKey);
        if (structuredData == null) {
            return;
        }
        if (structuredData.isPresent()) {
            Object obj = structuredData.value();
            V v = function.apply(obj);
            if (v != null) {
                this.set(structuredDataKey2, v);
            }
        } else {
            this.setEmpty(structuredDataKey2);
            if (runnable2 != null) {
                runnable2.run();
            }
        }
    }

    public void remove(StructuredDataKey<?> structuredDataKey) {
        this.data.remove(structuredDataKey);
    }

    public void remove(Collection<StructuredDataKey<?>> collection) {
        for (StructuredDataKey<?> structuredDataKey : collection) {
            this.data.remove(structuredDataKey);
        }
    }

    public boolean has(StructuredDataKey<?> structuredDataKey) {
        return this.data.containsKey(structuredDataKey);
    }

    public boolean hasValue(StructuredDataKey<?> structuredDataKey) {
        StructuredData<?> structuredData = this.data.get(structuredDataKey);
        return structuredData != null && structuredData.isPresent();
    }

    public boolean hasEmpty(StructuredDataKey<?> structuredDataKey) {
        StructuredData<?> structuredData = this.data.get(structuredDataKey);
        return structuredData != null && structuredData.isEmpty();
    }

    public void setIdLookup(Protocol<?, ?, ?, ?> protocol, boolean bl) {
        this.lookup = protocol.getMappingData().getDataComponentSerializerMappings();
        Preconditions.checkNotNull(this.lookup, "Data component serializer mappings are null");
        this.mappedNames = bl;
    }

    public void updateIds(Protocol<?, ?, ?, ?> protocol, Int2IntFunction int2IntFunction) {
        for (StructuredData<?> structuredData : this.data.values()) {
            int n = int2IntFunction.applyAsInt(structuredData.id());
            if (n == -1) continue;
            structuredData.setId(n);
        }
    }

    @Override
    public StructuredDataContainer copy() {
        Reference2ObjectOpenHashMap reference2ObjectOpenHashMap = new Reference2ObjectOpenHashMap(this.data.size());
        for (StructuredData<?> structuredData : this.data.values()) {
            reference2ObjectOpenHashMap.put(structuredData.key(), (StructuredData<?>)structuredData.copy());
        }
        StructuredDataContainer structuredDataContainer = new StructuredDataContainer(reference2ObjectOpenHashMap);
        structuredDataContainer.lookup = this.lookup;
        return structuredDataContainer;
    }

    private int serializerId(StructuredDataKey<?> structuredDataKey) {
        int n;
        int n2 = n = this.mappedNames ? this.lookup.mappedId(structuredDataKey.identifier()) : this.lookup.id(structuredDataKey.identifier());
        if (n == -1) {
            Via.getPlatform().getLogger().severe("Could not find item data serializer for type " + String.valueOf(structuredDataKey));
        }
        return n;
    }

    public Map<StructuredDataKey<?>, StructuredData<?>> data() {
        return this.data;
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    public String toString() {
        return "StructuredDataContainer{data=" + String.valueOf(this.data) + ", lookup=" + String.valueOf(this.lookup) + ", mappedNames=" + this.mappedNames + "}";
    }
}


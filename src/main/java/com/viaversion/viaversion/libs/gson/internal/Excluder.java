/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.gson.internal;

import com.viaversion.viaversion.libs.gson.ExclusionStrategy;
import com.viaversion.viaversion.libs.gson.FieldAttributes;
import com.viaversion.viaversion.libs.gson.Gson;
import com.viaversion.viaversion.libs.gson.TypeAdapter;
import com.viaversion.viaversion.libs.gson.TypeAdapterFactory;
import com.viaversion.viaversion.libs.gson.annotations.Expose;
import com.viaversion.viaversion.libs.gson.annotations.Since;
import com.viaversion.viaversion.libs.gson.annotations.Until;
import com.viaversion.viaversion.libs.gson.internal.reflect.ReflectionHelper;
import com.viaversion.viaversion.libs.gson.reflect.TypeToken;
import com.viaversion.viaversion.libs.gson.stream.JsonReader;
import com.viaversion.viaversion.libs.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Excluder
implements TypeAdapterFactory,
Cloneable {
    private static final double IGNORE_VERSIONS = -1.0;
    public static final Excluder DEFAULT = new Excluder();
    private double version = -1.0;
    private int modifiers = 136;
    private boolean serializeInnerClasses = true;
    private boolean requireExpose;
    private List<ExclusionStrategy> serializationStrategies = Collections.emptyList();
    private List<ExclusionStrategy> deserializationStrategies = Collections.emptyList();

    protected Excluder clone() {
        try {
            return (Excluder)super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new AssertionError((Object)cloneNotSupportedException);
        }
    }

    public Excluder withVersion(double d) {
        Excluder excluder = this.clone();
        excluder.version = d;
        return excluder;
    }

    public Excluder withModifiers(int ... nArray) {
        Excluder excluder = this.clone();
        excluder.modifiers = 0;
        for (int n : nArray) {
            excluder.modifiers |= n;
        }
        return excluder;
    }

    public Excluder disableInnerClassSerialization() {
        Excluder excluder = this.clone();
        excluder.serializeInnerClasses = false;
        return excluder;
    }

    public Excluder excludeFieldsWithoutExposeAnnotation() {
        Excluder excluder = this.clone();
        excluder.requireExpose = true;
        return excluder;
    }

    public Excluder withExclusionStrategy(ExclusionStrategy exclusionStrategy, boolean bl, boolean bl2) {
        Excluder excluder = this.clone();
        if (bl) {
            excluder.serializationStrategies = new ArrayList<ExclusionStrategy>(this.serializationStrategies);
            excluder.serializationStrategies.add(exclusionStrategy);
        }
        if (bl2) {
            excluder.deserializationStrategies = new ArrayList<ExclusionStrategy>(this.deserializationStrategies);
            excluder.deserializationStrategies.add(exclusionStrategy);
        }
        return excluder;
    }

    @Override
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
        Class<T> clazz = typeToken.getRawType();
        final boolean bl = this.excludeClass(clazz, true);
        final boolean bl2 = this.excludeClass(clazz, false);
        if (!bl && !bl2) {
            return null;
        }
        return new TypeAdapter<T>(){
            private volatile TypeAdapter<T> delegate;

            @Override
            public T read(JsonReader jsonReader) throws IOException {
                if (bl2) {
                    jsonReader.skipValue();
                    return null;
                }
                return this.delegate().read(jsonReader);
            }

            @Override
            public void write(JsonWriter jsonWriter, T t) throws IOException {
                if (bl) {
                    jsonWriter.nullValue();
                    return;
                }
                this.delegate().write(jsonWriter, t);
            }

            private TypeAdapter<T> delegate() {
                TypeAdapter typeAdapter = this.delegate;
                if (typeAdapter == null) {
                    typeAdapter = this.delegate = gson.getDelegateAdapter(Excluder.this, typeToken);
                }
                return typeAdapter;
            }
        };
    }

    public boolean excludeField(Field field, boolean bl) {
        Object object;
        if ((this.modifiers & field.getModifiers()) != 0) {
            return true;
        }
        if (this.version != -1.0 && !this.isValidVersion(field.getAnnotation(Since.class), field.getAnnotation(Until.class))) {
            return true;
        }
        if (field.isSynthetic()) {
            return true;
        }
        if (this.requireExpose && ((object = field.getAnnotation(Expose.class)) == null || (bl ? !object.serialize() : !object.deserialize()))) {
            return true;
        }
        if (this.excludeClass(field.getType(), bl)) {
            return true;
        }
        Object object2 = object = bl ? this.serializationStrategies : this.deserializationStrategies;
        if (!object.isEmpty()) {
            FieldAttributes fieldAttributes = new FieldAttributes(field);
            Iterator iterator2 = object.iterator();
            while (iterator2.hasNext()) {
                ExclusionStrategy exclusionStrategy = (ExclusionStrategy)iterator2.next();
                if (!exclusionStrategy.shouldSkipField(fieldAttributes)) continue;
                return true;
            }
        }
        return false;
    }

    public boolean excludeClass(Class<?> clazz, boolean bl) {
        if (this.version != -1.0 && !this.isValidVersion(clazz.getAnnotation(Since.class), clazz.getAnnotation(Until.class))) {
            return true;
        }
        if (!this.serializeInnerClasses && Excluder.isInnerClass(clazz)) {
            return true;
        }
        if (!bl && !Enum.class.isAssignableFrom(clazz) && ReflectionHelper.isAnonymousOrNonStaticLocal(clazz)) {
            return true;
        }
        List<ExclusionStrategy> list = bl ? this.serializationStrategies : this.deserializationStrategies;
        for (ExclusionStrategy exclusionStrategy : list) {
            if (!exclusionStrategy.shouldSkipClass(clazz)) continue;
            return true;
        }
        return false;
    }

    private static boolean isInnerClass(Class<?> clazz) {
        return clazz.isMemberClass() && !ReflectionHelper.isStatic(clazz);
    }

    private boolean isValidVersion(Since since, Until until) {
        return this.isValidSince(since) && this.isValidUntil(until);
    }

    private boolean isValidSince(Since since) {
        if (since != null) {
            double d = since.value();
            return this.version >= d;
        }
        return true;
    }

    private boolean isValidUntil(Until until) {
        if (until != null) {
            double d = until.value();
            return this.version < d;
        }
        return true;
    }
}


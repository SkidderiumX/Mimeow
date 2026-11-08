/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MapConstraint;
import com.google.common.collect.MapConstraints;
import com.google.common.primitives.Primitives;
import java.util.HashMap;
import java.util.Map;

public class MutableClassToInstanceMap<B>
extends MapConstraints.ConstrainedMap<Class<? extends B>, B>
implements ClassToInstanceMap<B> {
    private static final MapConstraint<Class<?>, Object> VALUE_CAN_BE_CAST_TO_KEY = new MapConstraint<Class<?>, Object>(){

        @Override
        public void checkKeyValue(Class<?> clazz, Object object) {
            MutableClassToInstanceMap.cast(clazz, object);
        }
    };
    private static final long serialVersionUID = 0L;

    public static <B> MutableClassToInstanceMap<B> create() {
        return new MutableClassToInstanceMap(new HashMap());
    }

    public static <B> MutableClassToInstanceMap<B> create(Map<Class<? extends B>, B> map) {
        return new MutableClassToInstanceMap<B>(map);
    }

    private MutableClassToInstanceMap(Map<Class<? extends B>, B> map) {
        super(map, VALUE_CAN_BE_CAST_TO_KEY);
    }

    @Override
    public <T extends B> T putInstance(Class<T> clazz, T t) {
        return MutableClassToInstanceMap.cast(clazz, this.put(clazz, t));
    }

    @Override
    public <T extends B> T getInstance(Class<T> clazz) {
        return MutableClassToInstanceMap.cast(clazz, this.get(clazz));
    }

    private static <B, T extends B> T cast(Class<T> clazz, B b) {
        return Primitives.wrap(clazz).cast(b);
    }
}


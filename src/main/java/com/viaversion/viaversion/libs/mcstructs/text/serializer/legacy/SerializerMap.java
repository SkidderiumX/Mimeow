/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.serializer.legacy;

import com.viaversion.viaversion.libs.mcstructs.snbt.SNbt;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.legacy.EventSerializer;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class SerializerMap<R, A extends Enum<A>, IO> {
    private final SNbt<?> sNbt;
    private final Map<A, List<EventSerializer<R, ? extends R, A, IO>>> serializers;
    private final Function<R, A> toActionFunction;

    public static <R, A extends Enum<A>, IO> Builder<R, A, IO> create(SNbt<?> sNbt) {
        return new Builder(sNbt);
    }

    private SerializerMap(SNbt<?> sNbt, List<EventSerializer<R, ? extends R, A, IO>> list, Function<R, A> function) {
        this.sNbt = sNbt;
        this.toActionFunction = function;
        HashMap<Enum, List> hashMap = new HashMap<Enum, List>();
        for (EventSerializer<R, R, A, IO> eventSerializer : list) {
            hashMap.computeIfAbsent((Enum)eventSerializer.getAction(), enum_ -> new ArrayList()).add(eventSerializer);
        }
        this.serializers = new EnumMap<A, List<EventSerializer<R, ? extends R, A, IO>>>(hashMap);
    }

    public IO serialize(R r) {
        Enum enum_ = (Enum)this.toActionFunction.apply(r);
        List<EventSerializer<R, R, A, IO>> list = this.serializers.get(enum_);
        if (list == null || list.isEmpty()) {
            throw new UnsupportedOperationException("No serializer found for " + r);
        }
        for (EventSerializer<R, R, R, IO> eventSerializer : list) {
            if (!eventSerializer.matches(r)) continue;
            try {
                return eventSerializer.serialize(this.sNbt, this.cast(r));
            }
            catch (Throwable throwable) {
            }
        }
        throw new UnsupportedOperationException("No serializer found for " + r);
    }

    public R deserialize(A a, IO IO) {
        List<EventSerializer<R, R, A, IO>> list = this.serializers.get(a);
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (EventSerializer<R, R, A, IO> eventSerializer : list) {
            if (!eventSerializer.matches(a)) continue;
            try {
                return eventSerializer.deserialize(this.sNbt, IO);
            }
            catch (Throwable throwable) {
            }
        }
        throw new UnsupportedOperationException("No serializer found for " + a + " - " + IO);
    }

    private <X> X cast(Object object) {
        return (X)object;
    }

    public static class Builder<R, A extends Enum<A>, IO> {
        private final SNbt<?> sNbt;
        private final List<EventSerializer<R, ? extends R, A, IO>> serializers = new ArrayList<EventSerializer<R, ? extends R, A, IO>>();

        protected Builder(SNbt<?> sNbt) {
            this.sNbt = sNbt;
        }

        public Builder<R, A, IO> add(EventSerializer<R, ? extends R, A, IO> eventSerializer) {
            this.serializers.add(eventSerializer);
            return this;
        }

        public SerializerMap<R, A, IO> finalize(Function<R, A> function) {
            return new SerializerMap(this.sNbt, this.serializers, function);
        }
    }
}


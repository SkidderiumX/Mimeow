/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.serializer.legacy;

import com.viaversion.viaversion.libs.mcstructs.snbt.SNbt;
import java.util.function.Predicate;

public class EventSerializer<R, T extends R, A extends Enum<A>, IO> {
    private final Predicate<R> classMatcher;
    private final IOFunction<T, IO> serializer;
    private final A action;
    private final IOFunction<IO, T> deserializer;

    protected EventSerializer(Predicate<R> predicate, IOFunction<T, IO> iOFunction, A a, IOFunction<IO, T> iOFunction2) {
        this.classMatcher = predicate;
        this.serializer = iOFunction;
        this.action = a;
        this.deserializer = iOFunction2;
    }

    public A getAction() {
        return this.action;
    }

    public boolean matches(R r) {
        return this.classMatcher.test(r);
    }

    public IO serialize(SNbt<?> sNbt, T t) throws Throwable {
        return this.serializer.apply(sNbt, t);
    }

    public boolean matches(A a) {
        return this.action == a;
    }

    public T deserialize(SNbt<?> sNbt, IO IO) throws Throwable {
        return this.deserializer.apply(sNbt, IO);
    }

    @FunctionalInterface
    protected static interface BasicIOFunction<I, O>
    extends IOFunction<I, O> {
        public O apply(I var1) throws Throwable;

        @Override
        default public O apply(SNbt<?> sNbt, I i) throws Throwable {
            return this.apply(i);
        }
    }

    @FunctionalInterface
    protected static interface IOFunction<I, O> {
        public O apply(SNbt<?> var1, I var2) throws Throwable;
    }
}


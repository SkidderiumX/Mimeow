/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Type;
import io.netty.buffer.ByteBuf;
import java.util.function.Function;

public class TransformingType<F, T>
extends Type<T> {
    private final Type<F> from;
    private final Function<F, T> mapFunction;
    private final Function<T, F> reverseFunction;

    protected TransformingType(Type<F> type, Class<T> clazz, Function<F, T> function, Function<T, F> function2) {
        super(type.getTypeName(), clazz);
        this.from = type;
        this.mapFunction = function;
        this.reverseFunction = function2;
    }

    public static <F, T> Type<T> of(Type<F> type, Class<T> clazz, Function<F, T> function, Function<T, F> function2) {
        return new TransformingType<F, T>(type, clazz, function, function2);
    }

    @Override
    public T read(ByteBuf byteBuf) {
        return this.mapFunction.apply(this.from.read(byteBuf));
    }

    @Override
    public void write(ByteBuf byteBuf, T t) {
        this.from.write(byteBuf, this.reverseFunction.apply(t));
    }

    @Override
    public void write(Ops ops, T t) {
        this.from.write(ops, this.reverseFunction.apply(t));
    }
}


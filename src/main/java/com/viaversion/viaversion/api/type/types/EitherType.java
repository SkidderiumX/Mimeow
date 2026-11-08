/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.util.Either;
import io.netty.buffer.ByteBuf;

public class EitherType<T, V>
extends Type<Either<T, V>> {
    private final Type<T> leftType;
    private final Type<V> rightType;

    public EitherType(Type<T> type, Type<V> type2) {
        super(Either.class);
        this.leftType = type;
        this.rightType = type2;
    }

    @Override
    public Either<T, V> read(ByteBuf byteBuf) {
        return EitherType.read(byteBuf, this.leftType, this.rightType);
    }

    @Override
    public void write(ByteBuf byteBuf, Either<T, V> either) {
        EitherType.write(byteBuf, either, this.leftType, this.rightType);
    }

    public static <X, Y> Either<X, Y> read(ByteBuf byteBuf, Type<X> type, Type<Y> type2) {
        if (byteBuf.readBoolean()) {
            return Either.left(type.read(byteBuf));
        }
        return Either.right(type2.read(byteBuf));
    }

    public static <X, Y> void write(ByteBuf byteBuf, Either<X, Y> either, Type<X> type, Type<Y> type2) {
        if (either.isLeft()) {
            byteBuf.writeBoolean(true);
            type.write(byteBuf, either.left());
        } else {
            byteBuf.writeBoolean(false);
            type2.write(byteBuf, either.right());
        }
    }
}


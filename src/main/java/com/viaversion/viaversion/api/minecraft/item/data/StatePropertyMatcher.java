/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.ArrayType;
import com.viaversion.viaversion.util.Either;
import io.netty.buffer.ByteBuf;
import org.checkerframework.checker.nullness.qual.Nullable;

public record StatePropertyMatcher(String name, Either<String, RangedMatcher> matcher) {
    public static final Type<StatePropertyMatcher> TYPE = new Type<StatePropertyMatcher>(StatePropertyMatcher.class){

        @Override
        public StatePropertyMatcher read(ByteBuf byteBuf) {
            String string = (String)Types.STRING.read(byteBuf);
            if (byteBuf.readBoolean()) {
                String string2 = (String)Types.STRING.read(byteBuf);
                return new StatePropertyMatcher(string, Either.left(string2));
            }
            String string3 = (String)Types.OPTIONAL_STRING.read(byteBuf);
            String string4 = (String)Types.OPTIONAL_STRING.read(byteBuf);
            return new StatePropertyMatcher(string, Either.right(new RangedMatcher(string3, string4)));
        }

        @Override
        public void write(ByteBuf byteBuf, StatePropertyMatcher statePropertyMatcher) {
            Types.STRING.write(byteBuf, statePropertyMatcher.name);
            if (statePropertyMatcher.matcher.isLeft()) {
                byteBuf.writeBoolean(true);
                Types.STRING.write(byteBuf, statePropertyMatcher.matcher.left());
            } else {
                byteBuf.writeBoolean(false);
                Types.OPTIONAL_STRING.write(byteBuf, statePropertyMatcher.matcher.right().minValue());
                Types.OPTIONAL_STRING.write(byteBuf, statePropertyMatcher.matcher.right().maxValue());
            }
        }
    };
    public static final Type<StatePropertyMatcher[]> ARRAY_TYPE = new ArrayType<StatePropertyMatcher>(TYPE);

    public record RangedMatcher(@Nullable String minValue, @Nullable String maxValue) {
    }
}


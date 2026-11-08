/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.minecraft.item.data.FilterableString;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.util.Copyable;
import io.netty.buffer.ByteBuf;

public record WritableBook(FilterableString[] pages) implements Copyable
{
    public static final Type<WritableBook> TYPE = new Type<WritableBook>(WritableBook.class){

        @Override
        public WritableBook read(ByteBuf byteBuf) {
            return new WritableBook((FilterableString[])FilterableString.ARRAY_TYPE.read(byteBuf));
        }

        @Override
        public void write(ByteBuf byteBuf, WritableBook writableBook) {
            FilterableString.ARRAY_TYPE.write(byteBuf, writableBook.pages);
        }

        @Override
        public void write(Ops ops, WritableBook writableBook) {
            ops.writeMap(mapSerializer -> mapSerializer.writeOptional("pages", FilterableString.ARRAY_TYPE, writableBook.pages, new FilterableString[0]));
        }
    };

    @Override
    public WritableBook copy() {
        return new WritableBook(Copyable.copy(this.pages));
    }
}


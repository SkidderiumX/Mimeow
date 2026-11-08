/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.minecraft.item.data.FilterableComponent;
import com.viaversion.viaversion.api.minecraft.item.data.FilterableString;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.util.Copyable;
import io.netty.buffer.ByteBuf;

public record WrittenBook(FilterableString title, String author, int generation, FilterableComponent[] pages, boolean resolved) implements Copyable
{
    public static final Type<WrittenBook> TYPE = new Type<WrittenBook>(WrittenBook.class){

        @Override
        public WrittenBook read(ByteBuf byteBuf) {
            FilterableString filterableString = (FilterableString)FilterableString.TYPE.read(byteBuf);
            String string = (String)Types.STRING.read(byteBuf);
            int n = Types.VAR_INT.readPrimitive(byteBuf);
            FilterableComponent[] filterableComponentArray = (FilterableComponent[])FilterableComponent.ARRAY_TYPE.read(byteBuf);
            boolean bl = byteBuf.readBoolean();
            return new WrittenBook(filterableString, string, n, filterableComponentArray, bl);
        }

        @Override
        public void write(ByteBuf byteBuf, WrittenBook writtenBook) {
            FilterableString.TYPE.write(byteBuf, writtenBook.title);
            Types.STRING.write(byteBuf, writtenBook.author);
            Types.VAR_INT.writePrimitive(byteBuf, writtenBook.generation);
            FilterableComponent.ARRAY_TYPE.write(byteBuf, writtenBook.pages);
            byteBuf.writeBoolean(writtenBook.resolved);
        }

        @Override
        public void write(Ops ops, WrittenBook writtenBook) {
            ops.writeMap(mapSerializer -> mapSerializer.write("title", FilterableString.TYPE, writtenBook.title).write("author", Types.STRING, writtenBook.author).writeOptional("generation", Types.INT, writtenBook.generation, 0).writeOptional("pages", FilterableComponent.ARRAY_TYPE, writtenBook.pages, new FilterableComponent[0]).writeOptional("resolved", Types.BOOLEAN, writtenBook.resolved, false));
        }
    };

    @Override
    public WrittenBook copy() {
        return new WrittenBook(this.title, this.author, this.generation, Copyable.copy(this.pages), this.resolved);
    }
}


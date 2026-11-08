/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.misc.HolderType;
import com.viaversion.viaversion.util.Copyable;
import io.netty.buffer.ByteBuf;

public record ChatType(ChatTypeDecoration chatDecoration, ChatTypeDecoration narrationDecoration) implements Copyable
{
    public static final HolderType<ChatType> TYPE = new HolderType<ChatType>(){

        @Override
        public ChatType readDirect(ByteBuf byteBuf) {
            ChatTypeDecoration chatTypeDecoration = (ChatTypeDecoration)ChatTypeDecoration.TYPE.read(byteBuf);
            ChatTypeDecoration chatTypeDecoration2 = (ChatTypeDecoration)ChatTypeDecoration.TYPE.read(byteBuf);
            return new ChatType(chatTypeDecoration, chatTypeDecoration2);
        }

        @Override
        public void writeDirect(ByteBuf byteBuf, ChatType chatType) {
            ChatTypeDecoration.TYPE.write(byteBuf, chatType.chatDecoration());
            ChatTypeDecoration.TYPE.write(byteBuf, chatType.narrationDecoration());
        }
    };

    @Override
    public ChatType copy() {
        return new ChatType(this.chatDecoration.copy(), this.narrationDecoration.copy());
    }

    public record ChatTypeDecoration(String translationKey, int[] parameters, Tag style) implements Copyable
    {
        public static final Type<ChatTypeDecoration> TYPE = new Type<ChatTypeDecoration>(ChatTypeDecoration.class){

            @Override
            public ChatTypeDecoration read(ByteBuf byteBuf) {
                String string = (String)Types.STRING.read(byteBuf);
                int[] nArray = (int[])Types.INT_ARRAY_PRIMITIVE.read(byteBuf);
                Tag tag = (Tag)Types.TRUSTED_TAG.read(byteBuf);
                return new ChatTypeDecoration(string, nArray, tag);
            }

            @Override
            public void write(ByteBuf byteBuf, ChatTypeDecoration chatTypeDecoration) {
                Types.STRING.write(byteBuf, chatTypeDecoration.translationKey());
                Types.INT_ARRAY_PRIMITIVE.write(byteBuf, chatTypeDecoration.parameters());
                Types.TRUSTED_TAG.write(byteBuf, chatTypeDecoration.style());
            }
        };

        @Override
        public ChatTypeDecoration copy() {
            return new ChatTypeDecoration(this.translationKey, (int[])this.parameters.clone(), this.style.copy());
        }
    }
}


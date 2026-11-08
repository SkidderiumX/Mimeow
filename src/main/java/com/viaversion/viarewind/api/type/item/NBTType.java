/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.api.type.item;

import com.viaversion.nbt.io.NBTIO;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.type.Type;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.ByteBufOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class NBTType
extends Type<CompoundTag> {
    public NBTType() {
        super(CompoundTag.class);
    }

    @Override
    public CompoundTag read(ByteBuf byteBuf) {
        CompoundTag compoundTag;
        short s = byteBuf.readShort();
        if (s <= 0) {
            return null;
        }
        ByteBuf byteBuf2 = byteBuf.readSlice(s);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteBufInputStream(byteBuf2));
        try {
            compoundTag = NBTIO.reader(CompoundTag.class).named().read(gZIPInputStream);
        }
        catch (Throwable throwable) {
            try {
                try {
                    gZIPInputStream.close();
                }
                catch (Throwable throwable2) {
                    throwable.addSuppressed(throwable2);
                }
                throw throwable;
            }
            catch (IOException iOException) {
                throw new RuntimeException(iOException);
            }
        }
        gZIPInputStream.close();
        return compoundTag;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void write(ByteBuf byteBuf, CompoundTag compoundTag) {
        if (compoundTag == null) {
            byteBuf.writeShort(-1);
            return;
        }
        ByteBuf byteBuf2 = byteBuf.alloc().buffer();
        try {
            try (GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(new ByteBufOutputStream(byteBuf2));){
                NBTIO.writer().named().write(gZIPOutputStream, (Tag)compoundTag);
            }
            catch (IOException iOException) {
                throw new RuntimeException(iOException);
            }
            byteBuf.writeShort(byteBuf2.readableBytes());
            byteBuf.writeBytes(byteBuf2);
        }
        finally {
            byteBuf2.release();
        }
    }
}


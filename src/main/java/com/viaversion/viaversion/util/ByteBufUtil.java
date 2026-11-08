/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.util;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

public class ByteBufUtil {
    public static ByteBuf copy(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf) {
        int n = byteBuf.readableBytes();
        return byteBufAllocator.buffer(n).writeBytes(byteBuf, n);
    }
}


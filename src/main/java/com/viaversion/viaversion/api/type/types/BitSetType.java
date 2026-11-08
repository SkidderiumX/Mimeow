/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.type.Type;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import java.util.BitSet;

public class BitSetType
extends Type<BitSet> {
    private final int length;
    private final int bytesLength;

    public BitSetType(int n) {
        super(BitSet.class);
        this.length = n;
        this.bytesLength = (int)Math.ceil((double)n / 8.0);
    }

    @Override
    public BitSet read(ByteBuf byteBuf) {
        byte[] byArray = new byte[this.bytesLength];
        byteBuf.readBytes(byArray);
        return BitSet.valueOf(byArray);
    }

    @Override
    public void write(ByteBuf byteBuf, BitSet bitSet) {
        Preconditions.checkArgument(bitSet.length() <= this.length, "BitSet of length %s larger than max length %s", bitSet.length(), this.length);
        byte[] byArray = bitSet.toByteArray();
        byteBuf.writeBytes(byArray.length == this.bytesLength ? byArray : Arrays.copyOf(byArray, this.bytesLength));
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.OptionalType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;
import java.nio.charset.StandardCharsets;

public class StringType
extends Type<String> {
    private static final int MAX_CHAR_UTF_8_LENGTH = Character.toString('\uffff').getBytes(StandardCharsets.UTF_8).length;
    private final int maxLength;
    private final int maxByteLength;

    public StringType() {
        this(Short.MAX_VALUE);
    }

    public StringType(int n) {
        super(String.class);
        this.maxLength = n;
        this.maxByteLength = n * MAX_CHAR_UTF_8_LENGTH;
    }

    @Override
    public String read(ByteBuf byteBuf) {
        int n = Types.VAR_INT.readPrimitive(byteBuf);
        if (n > this.maxByteLength) {
            throw new IllegalArgumentException("Cannot receive string longer than " + this.maxLength + " * " + MAX_CHAR_UTF_8_LENGTH + " bytes (got " + n + " bytes)");
        }
        String string = byteBuf.toString(byteBuf.readerIndex(), n, StandardCharsets.UTF_8);
        byteBuf.skipBytes(n);
        if (string.length() > this.maxLength) {
            throw new IllegalArgumentException("Cannot receive string longer than " + this.maxLength + " characters (got " + string.length() + ")");
        }
        return string;
    }

    @Override
    public void write(ByteBuf byteBuf, String string) {
        if (string.length() > this.maxLength) {
            throw new IllegalArgumentException("Cannot send string longer than " + this.maxLength + " characters (got " + string.length() + " characters)");
        }
        byte[] byArray = string.getBytes(StandardCharsets.UTF_8);
        Types.VAR_INT.writePrimitive(byteBuf, byArray.length);
        byteBuf.writeBytes(byArray);
    }

    @Override
    public void write(Ops ops, String string) {
        ops.writeString(string);
    }

    public static final class OptionalStringType
    extends OptionalType<String> {
        public OptionalStringType() {
            super(Types.STRING);
        }
    }
}


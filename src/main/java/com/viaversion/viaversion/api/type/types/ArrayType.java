/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ArrayType<T>
extends Type<T[]> {
    private final Type<T> elementType;
    private final int maxLength;

    public ArrayType(Type<T> type) {
        this(type, -1);
    }

    public ArrayType(Type<T> type, int n) {
        super(type.getTypeName() + " Array", ArrayType.getArrayClass(type.getOutputClass()));
        this.elementType = type;
        this.maxLength = n;
    }

    private ArrayType(Class<? super T[]> clazz, Type<T> type, int n) {
        super(type.getTypeName() + " Array", clazz);
        this.elementType = type;
        this.maxLength = n;
    }

    public static Class<?> getArrayClass(Class<?> clazz) {
        return Array.newInstance(clazz, 0).getClass();
    }

    @Override
    public T[] read(ByteBuf byteBuf) {
        int n = Types.VAR_INT.readPrimitive(byteBuf);
        if (this.maxLength != -1 && n > this.maxLength) {
            throw new IllegalArgumentException("Array length " + n + " is longer than maximum " + this.maxLength);
        }
        return n < Short.MAX_VALUE ? this.readArray(byteBuf, n) : this.readList(byteBuf, n);
    }

    private T[] readArray(ByteBuf byteBuf, int n) {
        T[] TArray = this.createArray(n);
        for (int i = 0; i < n; ++i) {
            TArray[i] = this.elementType.read(byteBuf);
        }
        return TArray;
    }

    private T[] readList(ByteBuf byteBuf, int n) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < n; ++i) {
            arrayList.add(this.elementType.read(byteBuf));
        }
        return arrayList.toArray(this.createArray(0));
    }

    private T[] createArray(int n) {
        return (Object[])Array.newInstance(this.elementType.getOutputClass(), n);
    }

    @Override
    public void write(ByteBuf byteBuf, T[] TArray) {
        if (this.maxLength != -1 && TArray.length > this.maxLength) {
            throw new IllegalArgumentException("Array length " + TArray.length + " is longer than maximum " + this.maxLength);
        }
        Types.VAR_INT.writePrimitive(byteBuf, TArray.length);
        for (T t : TArray) {
            this.elementType.write(byteBuf, t);
        }
    }

    @Override
    public void write(Ops ops, T[] TArray) {
        ops.writeList(listSerializer -> {
            for (Object object : TArray) {
                listSerializer.write(this.elementType, object);
            }
        });
    }

    public ArrayType<T> withMaxLength(int n) {
        return new ArrayType<T>(this.getOutputClass(), this.elementType, n);
    }
}


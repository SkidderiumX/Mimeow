/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.converter;

import com.viaversion.viaversion.libs.mcstructs.converter.DataConverter;
import com.viaversion.viaversion.libs.mcstructs.converter.codec.Codec;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Result;
import java.util.Objects;
import lombok.Generated;

public class SerializedData<T> {
    private final T data;
    private final DataConverter<T> converter;

    public <S> Result<S> convert(DataConverter<S> dataConverter) {
        if (this.converter == dataConverter) {
            return Result.success(this.data);
        }
        return Result.success(this.converter.convertTo(dataConverter, this.data));
    }

    public <O> Result<O> deserialize(Codec<O> codec) {
        return codec.deserialize(this.converter, this.data);
    }

    public String toString() {
        return "SerializedData{" + this.data + "}";
    }

    public boolean equals(Object object) {
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        SerializedData serializedData = (SerializedData)object;
        return Objects.equals(this.data, serializedData.data);
    }

    public int hashCode() {
        return Objects.hash(this.data);
    }

    @Generated
    public T getData() {
        return this.data;
    }

    @Generated
    public DataConverter<T> getConverter() {
        return this.converter;
    }

    @Generated
    public SerializedData(T t, DataConverter<T> dataConverter) {
        this.data = t;
        this.converter = dataConverter;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.item;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.data.FullMappings;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.minecraft.data.StructuredData;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.item.StructuredDataTypeBase;
import io.netty.buffer.ByteBuf;
import java.util.Collection;
import org.checkerframework.checker.nullness.qual.Nullable;

public class StructuredDataType
extends Type<StructuredData<?>>
implements StructuredDataTypeBase {
    private StructuredDataKey<?>[] types;

    public StructuredDataType() {
        super(StructuredData.class);
    }

    @Override
    public void write(ByteBuf byteBuf, StructuredData<?> structuredData) {
        Types.VAR_INT.writePrimitive(byteBuf, structuredData.id());
        structuredData.write(byteBuf);
    }

    @Override
    public StructuredData<?> read(ByteBuf byteBuf) {
        Preconditions.checkNotNull(this.types, "StructuredDataType has not been initialized");
        int n = Types.VAR_INT.readPrimitive(byteBuf);
        StructuredDataKey<?> structuredDataKey = this.key(n);
        if (structuredDataKey == null) {
            throw new IllegalArgumentException("No data component serializer found for id " + n);
        }
        return this.readData(byteBuf, structuredDataKey, n);
    }

    @Override
    public @Nullable StructuredDataKey<?> key(int n) {
        return n >= 0 && n < this.types.length ? this.types[n] : null;
    }

    @Override
    public void write(Ops ops, StructuredData<?> structuredData) {
        if (structuredData.isPresent() && ops.context().isSupported(structuredData.key())) {
            this.writeGeneric(ops, structuredData);
        }
    }

    private <V> void writeGeneric(Ops ops, StructuredData<V> structuredData) {
        structuredData.key().type().write(ops, structuredData.value());
    }

    <T> StructuredData<T> readData(ByteBuf byteBuf, StructuredDataKey<T> structuredDataKey, int n) {
        return StructuredData.of(structuredDataKey, structuredDataKey.type().read(byteBuf), n);
    }

    public DataFiller filler(Protocol<?, ?, ?, ?> protocol) {
        DataFiller dataFiller = new DataFiller(protocol);
        if (protocol.mappedTypes() != null) {
            dataFiller.add(protocol.mappedTypes().structuredDataKeys().keys());
        }
        return dataFiller;
    }

    public final class DataFiller {
        private final FullMappings mappings;

        private DataFiller(Protocol<?, ?, ?, ?> protocol) {
            this.mappings = protocol.getMappingData().getDataComponentSerializerMappings();
            Preconditions.checkArgument(this.mappings != null, "No mappings found for protocol %s", protocol.getClass());
            Preconditions.checkArgument(StructuredDataType.this.types == null, "StructuredDataType has already been initialized");
            StructuredDataType.this.types = new StructuredDataKey[this.mappings.mappedSize()];
        }

        public DataFiller add(StructuredDataKey<?> structuredDataKey) {
            int n = this.mappings.mappedId(structuredDataKey.identifier());
            Preconditions.checkArgument(n != -1, "No mapped id found for %s", structuredDataKey.identifier());
            Preconditions.checkArgument(StructuredDataType.this.types[n] == null, "Data component serializer already exists for id %s", n);
            StructuredDataType.this.types[n] = structuredDataKey;
            return this;
        }

        public DataFiller add(StructuredDataKey<?> ... structuredDataKeyArray) {
            for (StructuredDataKey<?> structuredDataKey : structuredDataKeyArray) {
                this.add(structuredDataKey);
            }
            return this;
        }

        public DataFiller add(Collection<StructuredDataKey<?>> collection) {
            for (StructuredDataKey<?> structuredDataKey : collection) {
                this.add(structuredDataKey);
            }
            return this;
        }
    }
}


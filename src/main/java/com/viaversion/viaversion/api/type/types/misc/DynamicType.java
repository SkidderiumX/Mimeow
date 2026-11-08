/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.misc;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.data.FullMappings;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectOpenHashMap;
import com.viaversion.viaversion.util.IdHolder;
import io.netty.buffer.ByteBuf;

public abstract class DynamicType<T extends IdHolder>
extends Type<T> {
    protected final Int2ObjectMap<DataReader<T>> readers;

    protected DynamicType(Int2ObjectMap<DataReader<T>> int2ObjectMap, Class<T> clazz) {
        super(clazz.getSimpleName(), clazz);
        this.readers = int2ObjectMap;
    }

    protected DynamicType(Class<T> clazz) {
        this(new Int2ObjectOpenHashMap<DataReader<T>>(), clazz);
    }

    public DataFiller filler(Protocol<?, ?, ?, ?> protocol) {
        return this.filler(protocol, true);
    }

    public DataFiller filler(Protocol<?, ?, ?, ?> protocol, boolean bl) {
        return new DataFiller(protocol, bl);
    }

    protected void readData(ByteBuf byteBuf, T t) {
        DataReader dataReader = (DataReader)this.readers.get(t.id());
        if (dataReader != null) {
            dataReader.read(byteBuf, t);
        }
    }

    public RawDataFiller rawFiller() {
        return new RawDataFiller();
    }

    protected abstract FullMappings mappings(Protocol<?, ?, ?, ?> var1);

    public final class DataFiller {
        private final FullMappings mappings;
        private final boolean useMappedNames;

        private DataFiller(Protocol<?, ?, ?, ?> protocol, boolean bl) {
            this.mappings = DynamicType.this.mappings(protocol);
            Preconditions.checkNotNull(this.mappings, "Mappings for %s are null", protocol.getClass());
            this.useMappedNames = bl;
        }

        public DataFiller reader(String string, DataReader<T> dataReader) {
            DynamicType.this.readers.put(this.useMappedNames ? this.mappings.mappedId(string) : this.mappings.id(string), dataReader);
            return this;
        }
    }

    @FunctionalInterface
    public static interface DataReader<T> {
        public void read(ByteBuf var1, T var2);
    }

    public final class RawDataFiller {
        public RawDataFiller reader(int n, DataReader<T> dataReader) {
            DynamicType.this.readers.put(n, dataReader);
            return this;
        }
    }
}


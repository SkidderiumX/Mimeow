/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.codec;

import com.viaversion.viaversion.api.minecraft.codec.CodecContext;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import java.util.Objects;
import java.util.function.Consumer;
import org.checkerframework.checker.nullness.qual.Nullable;

public interface Ops {
    public CodecContext context();

    public void writeByte(byte var1);

    public void writeBytes(byte[] var1);

    public void writeBoolean(boolean var1);

    public void writeShort(short var1);

    public void writeString(CharSequence var1);

    public void writeInt(int var1);

    public void writeLong(long var1);

    public void writeFloat(float var1);

    public void writeDouble(double var1);

    public void writeInts(int[] var1);

    public void writeLongs(long[] var1);

    public void writeList(Consumer<ListSerializer> var1);

    public void writeMap(Consumer<MapSerializer> var1);

    public <V> void write(Type<V> var1, V var2);

    public static interface MapSerializer {
        public <K, V> MapSerializer write(Type<K> var1, K var2, Type<V> var3, V var4);

        default public <V> MapSerializer write(String string, Type<V> type, V v) {
            this.write(Types.STRING, string, type, v);
            return this;
        }

        default public <V> MapSerializer write(String string, Type<V> type, @Nullable V v, V v2) {
            this.write(Types.STRING, string, type, v != null ? v : v2);
            return this;
        }

        default public <V> MapSerializer writeOptional(String string, Type<V> type, @Nullable V v) {
            if (v != null) {
                this.write(Types.STRING, string, type, v);
            }
            return this;
        }

        default public <V> MapSerializer writeOptional(String string, Type<V> type, @Nullable V v, V v2) {
            if (v != null && !Objects.deepEquals(v, v2)) {
                this.write(Types.STRING, string, type, v);
            }
            return this;
        }

        public MapSerializer writeList(String var1, Consumer<ListSerializer> var2);

        public MapSerializer writeMap(String var1, Consumer<MapSerializer> var2);

        public <T> MapSerializer writeInlinedMap(Type<T> var1, T var2);
    }

    public static interface ListSerializer {
        public <V> ListSerializer write(Type<V> var1, V var2);

        public ListSerializer writeList(Consumer<ListSerializer> var1);

        public ListSerializer writeMap(Consumer<MapSerializer> var1);
    }
}


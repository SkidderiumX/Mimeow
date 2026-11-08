/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.codec.hash;

import com.viaversion.viaversion.api.minecraft.codec.CodecContext;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.minecraft.codec.ThrowingOps;
import com.viaversion.viaversion.api.minecraft.codec.hash.Hasher;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.codec.OpsBase;
import com.viaversion.viaversion.codec.hash.HashBuilder;
import com.viaversion.viaversion.codec.hash.HashFunction;
import com.viaversion.viaversion.libs.fastutil.ints.IntArrayList;
import com.viaversion.viaversion.libs.fastutil.ints.IntList;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class HashOps
extends OpsBase
implements Hasher {
    private static final byte TAG_MAP_START = 2;
    private static final byte TAG_MAP_END = 3;
    private static final byte TAG_LIST_START = 4;
    private static final byte TAG_LIST_END = 5;
    private static final byte TAG_BYTE = 6;
    private static final byte TAG_SHORT = 7;
    private static final byte TAG_INT = 8;
    private static final byte TAG_LONG = 9;
    private static final byte TAG_FLOAT = 10;
    private static final byte TAG_DOUBLE = 11;
    private static final byte TAG_STRING = 12;
    private static final byte TAG_BOOLEAN = 13;
    private static final byte TAG_BYTE_ARRAY_START = 14;
    private static final byte TAG_BYTE_ARRAY_END = 15;
    private static final byte TAG_INT_ARRAY_START = 16;
    private static final byte TAG_INT_ARRAY_END = 17;
    private static final byte TAG_LONG_ARRAY_START = 18;
    private static final byte TAG_LONG_ARRAY_END = 19;
    static final byte[] FALSE = new byte[]{13, 0};
    static final byte[] TRUE = new byte[]{13, 1};
    static final byte[] EMPTY_LIST = new byte[]{4, 5};
    static final byte[] EMPTY_MAP = new byte[]{2, 3};
    private final HashBuilder hashBuilder;

    public HashOps(CodecContext codecContext, HashFunction hashFunction) {
        super(codecContext);
        this.hashBuilder = new HashBuilder(hashFunction);
    }

    @Override
    public void writeByte(byte by) {
        this.hashBuilder.preSize(2).writeByte((byte)6).writeByte(by);
    }

    @Override
    public void writeBytes(byte[] byArray) {
        this.hashBuilder.preSize(byArray.length + 2).writeByte((byte)14).writeBytes(byArray).writeByte((byte)15);
    }

    @Override
    public void writeBoolean(boolean bl) {
        this.hashBuilder.writeBytesDirect(bl ? TRUE : FALSE);
    }

    @Override
    public void writeShort(short s) {
        this.hashBuilder.preSize(3).writeByte((byte)7).writeShort(s);
    }

    @Override
    public void writeString(CharSequence charSequence) {
        this.hashBuilder.preSize(charSequence.length() * 2 + 1 + 4).writeByte((byte)12).writeInt(charSequence.length()).writeString(charSequence);
    }

    @Override
    public void writeInt(int n) {
        this.hashBuilder.preSize(5).writeByte((byte)8).writeInt(n);
    }

    @Override
    public void writeLong(long l) {
        this.hashBuilder.preSize(9).writeByte((byte)9).writeLong(l);
    }

    @Override
    public void writeFloat(float f) {
        this.hashBuilder.preSize(5).writeByte((byte)10).writeFloat(f);
    }

    @Override
    public void writeDouble(double d) {
        this.hashBuilder.preSize(9).writeByte((byte)11).writeDouble(d);
    }

    @Override
    public void writeInts(int[] nArray) {
        this.hashBuilder.preSize(nArray.length * 4 + 2);
        this.hashBuilder.writeByte((byte)16);
        for (int n : nArray) {
            this.hashBuilder.writeInt(n);
        }
        this.hashBuilder.writeByte((byte)17);
    }

    @Override
    public void writeLongs(long[] lArray) {
        this.hashBuilder.preSize(lArray.length * 8 + 2);
        this.hashBuilder.writeByte((byte)18);
        for (long l : lArray) {
            this.hashBuilder.writeLong(l);
        }
        this.hashBuilder.writeByte((byte)19);
    }

    @Override
    public void writeList(Consumer<Ops.ListSerializer> consumer) {
        ListHashBuilder listHashBuilder = new ListHashBuilder();
        consumer.accept(listHashBuilder);
        listHashBuilder.applyHashToParent();
    }

    @Override
    public void writeMap(Consumer<Ops.MapSerializer> consumer) {
        MapHashBuilder mapHashBuilder = new MapHashBuilder();
        consumer.accept(mapHashBuilder);
        mapHashBuilder.applyHashToParent();
    }

    @Override
    public <V> void write(Type<V> type, V v) {
        type.write(this, v);
    }

    @Override
    public int hash() {
        return this.hashBuilder.hash();
    }

    @Override
    public void reset() {
        this.hashBuilder.reset();
    }

    private final class ListHashBuilder
    extends CollectionHashBuilder
    implements Ops.ListSerializer {
        private final IntList entries;

        private ListHashBuilder() {
            this.entries = new IntArrayList();
        }

        public <T> Ops.ListSerializer write(Type<T> type, T t) {
            this.entries.add(this.hash(type, t));
            return this;
        }

        @Override
        public Ops.ListSerializer writeList(Consumer<Ops.ListSerializer> consumer) {
            this.entries.add(this.listHash(consumer));
            return this;
        }

        @Override
        public Ops.ListSerializer writeMap(Consumer<Ops.MapSerializer> consumer) {
            this.entries.add(this.mapHash(consumer));
            return this;
        }

        public void applyHashToParent() {
            if (this.entries.isEmpty()) {
                HashOps.this.hashBuilder.writeBytesDirect(EMPTY_LIST);
                return;
            }
            int n = this.entries.size();
            HashOps.this.hashBuilder.preSize(n * 4 + 2);
            HashOps.this.hashBuilder.writeByte((byte)4);
            for (int i = 0; i < n; ++i) {
                HashOps.this.hashBuilder.writeInt(this.entries.getInt(i));
            }
            HashOps.this.hashBuilder.writeByte((byte)5);
        }
    }

    private final class MapHashBuilder
    extends CollectionHashBuilder
    implements Ops.MapSerializer {
        private final List<Entry> entries;

        private MapHashBuilder() {
            this.entries = new ArrayList<Entry>();
        }

        public <K, T> Ops.MapSerializer write(Type<K> type, K k, Type<T> type2, T t) {
            this.entries.add(new Entry(this.hash(type, k), this.hash(type2, t)));
            return this;
        }

        @Override
        public Ops.MapSerializer writeList(String string, Consumer<Ops.ListSerializer> consumer) {
            this.entries.add(new Entry(this.hash(Types.STRING, string), this.listHash(consumer)));
            return this;
        }

        @Override
        public Ops.MapSerializer writeMap(String string, Consumer<Ops.MapSerializer> consumer) {
            this.entries.add(new Entry(this.hash(Types.STRING, string), this.mapHash(consumer)));
            return this;
        }

        @Override
        public <T> Ops.MapSerializer writeInlinedMap(Type<T> type, T t) {
            type.write(new ThrowingOps(){

                @Override
                public void writeMap(Consumer<Ops.MapSerializer> consumer) {
                    consumer.accept(MapHashBuilder.this);
                }
            }, t);
            return this;
        }

        public void applyHashToParent() {
            if (this.entries.isEmpty()) {
                HashOps.this.hashBuilder.writeBytesDirect(EMPTY_MAP);
                return;
            }
            int n = this.entries.size();
            HashOps.this.hashBuilder.preSize(n * 4 * 2 + 2);
            HashOps.this.hashBuilder.writeByte((byte)2);
            this.entries.sort(Comparator.naturalOrder());
            for (int i = 0; i < n; ++i) {
                Entry entry = this.entries.get(i);
                HashOps.this.hashBuilder.writeInt(entry.key);
                HashOps.this.hashBuilder.writeInt(entry.value);
            }
            HashOps.this.hashBuilder.writeByte((byte)3);
        }

        private record Entry(int key, int value) implements Comparable<Entry>
        {
            @Override
            public int compareTo(Entry entry) {
                if (this.key != entry.key) {
                    return Long.compare(Entry.padToLong(this.key), Entry.padToLong(entry.key));
                }
                return Long.compare(Entry.padToLong(this.value), Entry.padToLong(entry.value));
            }

            private static long padToLong(int n) {
                return (long)n & 0xFFFFFFFFL;
            }
        }
    }

    private abstract class CollectionHashBuilder {
        protected final HashOps hasher;

        private CollectionHashBuilder() {
            this.hasher = new HashOps(HashOps.this.context(), HashOps.this.hashBuilder.function());
        }

        protected int listHash(Consumer<Ops.ListSerializer> consumer) {
            this.hasher.reset();
            ListHashBuilder listHashBuilder = this.hasher.new ListHashBuilder();
            consumer.accept(listHashBuilder);
            listHashBuilder.applyHashToParent();
            return this.hasher.hash();
        }

        protected int mapHash(Consumer<Ops.MapSerializer> consumer) {
            this.hasher.reset();
            MapHashBuilder mapHashBuilder = this.hasher.new MapHashBuilder();
            consumer.accept(mapHashBuilder);
            mapHashBuilder.applyHashToParent();
            return this.hasher.hash();
        }

        protected <V> int hash(Type<V> type, V v) {
            this.hasher.reset();
            type.write(this.hasher, v);
            return this.hasher.hash();
        }
    }
}


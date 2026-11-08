/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.ints;

import com.viaversion.viaversion.libs.fastutil.ints.AbstractInt2IntMap;
import com.viaversion.viaversion.libs.fastutil.ints.AbstractIntCollection;
import com.viaversion.viaversion.libs.fastutil.ints.AbstractIntSet;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntMap;
import com.viaversion.viaversion.libs.fastutil.ints.IntArrays;
import com.viaversion.viaversion.libs.fastutil.ints.IntCollection;
import com.viaversion.viaversion.libs.fastutil.ints.IntIntPair;
import com.viaversion.viaversion.libs.fastutil.ints.IntIterator;
import com.viaversion.viaversion.libs.fastutil.ints.IntSet;
import com.viaversion.viaversion.libs.fastutil.ints.IntSpliterator;
import com.viaversion.viaversion.libs.fastutil.ints.IntSpliterators;
import com.viaversion.viaversion.libs.fastutil.objects.AbstractObjectSet;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectIterator;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectSpliterator;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectSpliterators;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class Int2IntArrayMap
extends AbstractInt2IntMap
implements Serializable,
Cloneable {
    private static final long serialVersionUID = 1L;
    protected transient int[] key;
    protected transient int[] value;
    protected int size;
    protected transient Int2IntMap.FastEntrySet entries;
    protected transient IntSet keys;
    protected transient IntCollection values;

    public Int2IntArrayMap(int[] nArray, int[] nArray2) {
        this.key = nArray;
        this.value = nArray2;
        this.size = nArray.length;
        if (nArray.length != nArray2.length) {
            throw new IllegalArgumentException("Keys and values have different lengths (" + nArray.length + ", " + nArray2.length + ")");
        }
    }

    public Int2IntArrayMap() {
        this.key = IntArrays.EMPTY_ARRAY;
        this.value = IntArrays.EMPTY_ARRAY;
    }

    public Int2IntArrayMap(int n) {
        this.key = new int[n];
        this.value = new int[n];
    }

    public Int2IntArrayMap(Int2IntMap int2IntMap) {
        this(int2IntMap.size());
        int n = 0;
        for (Int2IntMap.Entry entry : int2IntMap.int2IntEntrySet()) {
            this.key[n] = entry.getIntKey();
            this.value[n] = entry.getIntValue();
            ++n;
        }
        this.size = n;
    }

    public Int2IntArrayMap(Map<? extends Integer, ? extends Integer> map) {
        this(map.size());
        int n = 0;
        for (Map.Entry<? extends Integer, ? extends Integer> entry : map.entrySet()) {
            this.key[n] = entry.getKey();
            this.value[n] = entry.getValue();
            ++n;
        }
        this.size = n;
    }

    public Int2IntArrayMap(int[] nArray, int[] nArray2, int n) {
        this.key = nArray;
        this.value = nArray2;
        this.size = n;
        if (nArray.length != nArray2.length) {
            throw new IllegalArgumentException("Keys and values have different lengths (" + nArray.length + ", " + nArray2.length + ")");
        }
        if (n > nArray.length) {
            throw new IllegalArgumentException("The provided size (" + n + ") is larger than or equal to the backing-arrays size (" + nArray.length + ")");
        }
    }

    public Int2IntMap.FastEntrySet int2IntEntrySet() {
        if (this.entries == null) {
            this.entries = new EntrySet();
        }
        return this.entries;
    }

    private int findKey(int n) {
        int[] nArray = this.key;
        int n2 = this.size;
        while (n2-- != 0) {
            if (nArray[n2] != n) continue;
            return n2;
        }
        return -1;
    }

    @Override
    public int get(int n) {
        int[] nArray = this.key;
        int n2 = this.size;
        while (n2-- != 0) {
            if (nArray[n2] != n) continue;
            return this.value[n2];
        }
        return this.defRetValue;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        this.size = 0;
    }

    @Override
    public boolean containsKey(int n) {
        return this.findKey(n) != -1;
    }

    @Override
    public boolean containsValue(int n) {
        int[] nArray = this.value;
        int n2 = this.size;
        while (n2-- != 0) {
            if (nArray[n2] != n) continue;
            return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int put(int n, int n2) {
        int n3 = this.findKey(n);
        if (n3 != -1) {
            int n4 = this.value[n3];
            this.value[n3] = n2;
            return n4;
        }
        if (this.size == this.key.length) {
            int[] nArray = new int[this.size == 0 ? 2 : this.size * 2];
            int[] nArray2 = new int[this.size == 0 ? 2 : this.size * 2];
            int n5 = this.size;
            while (n5-- != 0) {
                nArray[n5] = this.key[n5];
                nArray2[n5] = this.value[n5];
            }
            this.key = nArray;
            this.value = nArray2;
        }
        this.key[this.size] = n;
        this.value[this.size] = n2;
        ++this.size;
        return this.defRetValue;
    }

    @Override
    public int remove(int n) {
        int n2 = this.findKey(n);
        if (n2 == -1) {
            return this.defRetValue;
        }
        int n3 = this.value[n2];
        int n4 = this.size - n2 - 1;
        System.arraycopy(this.key, n2 + 1, this.key, n2, n4);
        System.arraycopy(this.value, n2 + 1, this.value, n2, n4);
        --this.size;
        return n3;
    }

    @Override
    public IntSet keySet() {
        if (this.keys == null) {
            this.keys = new KeySet();
        }
        return this.keys;
    }

    @Override
    public IntCollection values() {
        if (this.values == null) {
            this.values = new ValuesCollection();
        }
        return this.values;
    }

    public Int2IntArrayMap clone() {
        Int2IntArrayMap int2IntArrayMap;
        try {
            int2IntArrayMap = (Int2IntArrayMap)super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new InternalError();
        }
        int2IntArrayMap.key = (int[])this.key.clone();
        int2IntArrayMap.value = (int[])this.value.clone();
        int2IntArrayMap.entries = null;
        int2IntArrayMap.keys = null;
        int2IntArrayMap.values = null;
        return int2IntArrayMap;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        int[] nArray = this.key;
        int[] nArray2 = this.value;
        int n = this.size;
        for (int i = 0; i < n; ++i) {
            objectOutputStream.writeInt(nArray[i]);
            objectOutputStream.writeInt(nArray2[i]);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.key = new int[this.size];
        int[] nArray = this.key;
        this.value = new int[this.size];
        int[] nArray2 = this.value;
        for (int i = 0; i < this.size; ++i) {
            nArray[i] = objectInputStream.readInt();
            nArray2[i] = objectInputStream.readInt();
        }
    }

    private final class EntrySet
    extends AbstractObjectSet<Int2IntMap.Entry>
    implements Int2IntMap.FastEntrySet {
        private EntrySet() {
        }

        @Override
        public ObjectIterator<Int2IntMap.Entry> iterator() {
            return new ObjectIterator<Int2IntMap.Entry>(){
                private MapEntry entry;
                int curr = -1;
                int next = 0;

                @Override
                public boolean hasNext() {
                    return this.next < Int2IntArrayMap.this.size;
                }

                @Override
                public Int2IntMap.Entry next() {
                    if (!this.hasNext()) {
                        throw new NoSuchElementException();
                    }
                    this.curr = this.next++;
                    this.entry = new MapEntry(this.curr);
                    return this.entry;
                }

                @Override
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    int n = Int2IntArrayMap.this.size-- - this.next--;
                    System.arraycopy(Int2IntArrayMap.this.key, this.next + 1, Int2IntArrayMap.this.key, this.next, n);
                    System.arraycopy(Int2IntArrayMap.this.value, this.next + 1, Int2IntArrayMap.this.value, this.next, n);
                    this.entry.index = -1;
                }

                @Override
                public int skip(int n) {
                    if (n < 0) {
                        throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                    }
                    n = Math.min(n, Int2IntArrayMap.this.size - this.next);
                    this.next += n;
                    if (n != 0) {
                        this.curr = this.next - 1;
                    }
                    return n;
                }

                @Override
                public void forEachRemaining(Consumer<? super Int2IntMap.Entry> consumer) {
                    int n = Int2IntArrayMap.this.size;
                    while (this.next < n) {
                        ++this.next;
                        this.curr = this.curr;
                        this.entry = new MapEntry(this.curr);
                        consumer.accept(this.entry);
                    }
                }
            };
        }

        @Override
        public ObjectIterator<Int2IntMap.Entry> fastIterator() {
            return new ObjectIterator<Int2IntMap.Entry>(){
                private MapEntry entry;
                int next;
                int curr;
                {
                    this.entry = new MapEntry();
                    this.next = 0;
                    this.curr = -1;
                }

                @Override
                public boolean hasNext() {
                    return this.next < Int2IntArrayMap.this.size;
                }

                @Override
                public Int2IntMap.Entry next() {
                    if (!this.hasNext()) {
                        throw new NoSuchElementException();
                    }
                    this.curr = this.next++;
                    this.entry.index = this.curr;
                    return this.entry;
                }

                @Override
                public void remove() {
                    if (this.curr == -1) {
                        throw new IllegalStateException();
                    }
                    this.curr = -1;
                    int n = Int2IntArrayMap.this.size-- - this.next--;
                    System.arraycopy(Int2IntArrayMap.this.key, this.next + 1, Int2IntArrayMap.this.key, this.next, n);
                    System.arraycopy(Int2IntArrayMap.this.value, this.next + 1, Int2IntArrayMap.this.value, this.next, n);
                    this.entry.index = -1;
                }

                @Override
                public int skip(int n) {
                    if (n < 0) {
                        throw new IllegalArgumentException("Argument must be nonnegative: " + n);
                    }
                    n = Math.min(n, Int2IntArrayMap.this.size - this.next);
                    this.next += n;
                    if (n != 0) {
                        this.curr = this.next - 1;
                    }
                    return n;
                }

                @Override
                public void forEachRemaining(Consumer<? super Int2IntMap.Entry> consumer) {
                    int n = Int2IntArrayMap.this.size;
                    while (this.next < n) {
                        ++this.next;
                        this.entry.index = this.curr = this.curr;
                        consumer.accept(this.entry);
                    }
                }
            };
        }

        @Override
        public ObjectSpliterator<Int2IntMap.Entry> spliterator() {
            return new EntrySetSpliterator(0, Int2IntArrayMap.this.size);
        }

        @Override
        public void forEach(Consumer<? super Int2IntMap.Entry> consumer) {
            int n = Int2IntArrayMap.this.size;
            for (int i = 0; i < n; ++i) {
                consumer.accept(new MapEntry(i));
            }
        }

        @Override
        public void fastForEach(Consumer<? super Int2IntMap.Entry> consumer) {
            MapEntry mapEntry = new MapEntry();
            int n = 0;
            int n2 = Int2IntArrayMap.this.size;
            while (n < n2) {
                mapEntry.index = n++;
                consumer.accept(mapEntry);
            }
        }

        @Override
        public int size() {
            return Int2IntArrayMap.this.size;
        }

        @Override
        public boolean contains(Object object) {
            if (!(object instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry)object;
            if (entry.getKey() == null || !(entry.getKey() instanceof Integer)) {
                return false;
            }
            if (entry.getValue() == null || !(entry.getValue() instanceof Integer)) {
                return false;
            }
            int n = (Integer)entry.getKey();
            return Int2IntArrayMap.this.containsKey(n) && Int2IntArrayMap.this.get(n) == ((Integer)entry.getValue()).intValue();
        }

        @Override
        public boolean remove(Object object) {
            if (!(object instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry)object;
            if (entry.getKey() == null || !(entry.getKey() instanceof Integer)) {
                return false;
            }
            if (entry.getValue() == null || !(entry.getValue() instanceof Integer)) {
                return false;
            }
            int n = (Integer)entry.getKey();
            int n2 = (Integer)entry.getValue();
            int n3 = Int2IntArrayMap.this.findKey(n);
            if (n3 == -1 || n2 != Int2IntArrayMap.this.value[n3]) {
                return false;
            }
            int n4 = Int2IntArrayMap.this.size - n3 - 1;
            System.arraycopy(Int2IntArrayMap.this.key, n3 + 1, Int2IntArrayMap.this.key, n3, n4);
            System.arraycopy(Int2IntArrayMap.this.value, n3 + 1, Int2IntArrayMap.this.value, n3, n4);
            --Int2IntArrayMap.this.size;
            return true;
        }

        public final class EntrySetSpliterator
        extends ObjectSpliterators.EarlyBindingSizeIndexBasedSpliterator<Int2IntMap.Entry>
        implements ObjectSpliterator<Int2IntMap.Entry> {
            EntrySetSpliterator(int n, int n2) {
                super(n, n2);
            }

            @Override
            public int characteristics() {
                return 16465;
            }

            @Override
            protected final Int2IntMap.Entry get(int n) {
                return new MapEntry(n);
            }

            protected final EntrySetSpliterator makeForSplit(int n, int n2) {
                return new EntrySetSpliterator(n, n2);
            }
        }
    }

    private final class KeySet
    extends AbstractIntSet {
        private KeySet() {
        }

        @Override
        public boolean contains(int n) {
            return Int2IntArrayMap.this.findKey(n) != -1;
        }

        @Override
        public boolean remove(int n) {
            int n2 = Int2IntArrayMap.this.findKey(n);
            if (n2 == -1) {
                return false;
            }
            int n3 = Int2IntArrayMap.this.size - n2 - 1;
            System.arraycopy(Int2IntArrayMap.this.key, n2 + 1, Int2IntArrayMap.this.key, n2, n3);
            System.arraycopy(Int2IntArrayMap.this.value, n2 + 1, Int2IntArrayMap.this.value, n2, n3);
            --Int2IntArrayMap.this.size;
            return true;
        }

        @Override
        public IntIterator iterator() {
            return new IntIterator(){
                int pos = 0;

                @Override
                public boolean hasNext() {
                    return this.pos < Int2IntArrayMap.this.size;
                }

                @Override
                public int nextInt() {
                    if (!this.hasNext()) {
                        throw new NoSuchElementException();
                    }
                    return Int2IntArrayMap.this.key[this.pos++];
                }

                @Override
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int n = Int2IntArrayMap.this.size - this.pos;
                    System.arraycopy(Int2IntArrayMap.this.key, this.pos, Int2IntArrayMap.this.key, this.pos - 1, n);
                    System.arraycopy(Int2IntArrayMap.this.value, this.pos, Int2IntArrayMap.this.value, this.pos - 1, n);
                    --Int2IntArrayMap.this.size;
                    --this.pos;
                }

                @Override
                public void forEachRemaining(IntConsumer intConsumer) {
                    int[] nArray = Int2IntArrayMap.this.key;
                    int n = Int2IntArrayMap.this.size;
                    while (this.pos < n) {
                        intConsumer.accept(nArray[this.pos++]);
                    }
                }
            };
        }

        @Override
        public IntSpliterator spliterator() {
            return new KeySetSpliterator(0, Int2IntArrayMap.this.size);
        }

        @Override
        public void forEach(IntConsumer intConsumer) {
            int[] nArray = Int2IntArrayMap.this.key;
            int n = Int2IntArrayMap.this.size;
            for (int i = 0; i < n; ++i) {
                intConsumer.accept(nArray[i]);
            }
        }

        @Override
        public int size() {
            return Int2IntArrayMap.this.size;
        }

        @Override
        public void clear() {
            Int2IntArrayMap.this.clear();
        }

        public final class KeySetSpliterator
        extends IntSpliterators.EarlyBindingSizeIndexBasedSpliterator
        implements IntSpliterator {
            KeySetSpliterator(int n, int n2) {
                super(n, n2);
            }

            @Override
            public int characteristics() {
                return 16721;
            }

            @Override
            protected final int get(int n) {
                return Int2IntArrayMap.this.key[n];
            }

            @Override
            protected final KeySetSpliterator makeForSplit(int n, int n2) {
                return new KeySetSpliterator(n, n2);
            }

            @Override
            public void forEachRemaining(IntConsumer intConsumer) {
                int[] nArray = Int2IntArrayMap.this.key;
                int n = Int2IntArrayMap.this.size;
                while (this.pos < n) {
                    intConsumer.accept(nArray[this.pos++]);
                }
            }
        }
    }

    private final class ValuesCollection
    extends AbstractIntCollection {
        private ValuesCollection() {
        }

        @Override
        public boolean contains(int n) {
            return Int2IntArrayMap.this.containsValue(n);
        }

        @Override
        public IntIterator iterator() {
            return new IntIterator(){
                int pos = 0;

                @Override
                public boolean hasNext() {
                    return this.pos < Int2IntArrayMap.this.size;
                }

                @Override
                public int nextInt() {
                    if (!this.hasNext()) {
                        throw new NoSuchElementException();
                    }
                    return Int2IntArrayMap.this.value[this.pos++];
                }

                @Override
                public void remove() {
                    if (this.pos == 0) {
                        throw new IllegalStateException();
                    }
                    int n = Int2IntArrayMap.this.size - this.pos;
                    System.arraycopy(Int2IntArrayMap.this.key, this.pos, Int2IntArrayMap.this.key, this.pos - 1, n);
                    System.arraycopy(Int2IntArrayMap.this.value, this.pos, Int2IntArrayMap.this.value, this.pos - 1, n);
                    --Int2IntArrayMap.this.size;
                    --this.pos;
                }

                @Override
                public void forEachRemaining(IntConsumer intConsumer) {
                    int[] nArray = Int2IntArrayMap.this.value;
                    int n = Int2IntArrayMap.this.size;
                    while (this.pos < n) {
                        intConsumer.accept(nArray[this.pos++]);
                    }
                }
            };
        }

        @Override
        public IntSpliterator spliterator() {
            return new ValuesSpliterator(0, Int2IntArrayMap.this.size);
        }

        @Override
        public void forEach(IntConsumer intConsumer) {
            int[] nArray = Int2IntArrayMap.this.value;
            int n = Int2IntArrayMap.this.size;
            for (int i = 0; i < n; ++i) {
                intConsumer.accept(nArray[i]);
            }
        }

        @Override
        public int size() {
            return Int2IntArrayMap.this.size;
        }

        @Override
        public void clear() {
            Int2IntArrayMap.this.clear();
        }

        public final class ValuesSpliterator
        extends IntSpliterators.EarlyBindingSizeIndexBasedSpliterator
        implements IntSpliterator {
            ValuesSpliterator(int n, int n2) {
                super(n, n2);
            }

            @Override
            public int characteristics() {
                return 16720;
            }

            @Override
            protected final int get(int n) {
                return Int2IntArrayMap.this.value[n];
            }

            @Override
            protected final ValuesSpliterator makeForSplit(int n, int n2) {
                return new ValuesSpliterator(n, n2);
            }

            @Override
            public void forEachRemaining(IntConsumer intConsumer) {
                int[] nArray = Int2IntArrayMap.this.value;
                int n = Int2IntArrayMap.this.size;
                while (this.pos < n) {
                    intConsumer.accept(nArray[this.pos++]);
                }
            }
        }
    }

    private final class MapEntry
    implements Int2IntMap.Entry,
    Map.Entry<Integer, Integer>,
    IntIntPair {
        int index;

        MapEntry() {
        }

        MapEntry(int n) {
            this.index = n;
        }

        @Override
        public int getIntKey() {
            return Int2IntArrayMap.this.key[this.index];
        }

        @Override
        public int leftInt() {
            return Int2IntArrayMap.this.key[this.index];
        }

        @Override
        public int getIntValue() {
            return Int2IntArrayMap.this.value[this.index];
        }

        @Override
        public int rightInt() {
            return Int2IntArrayMap.this.value[this.index];
        }

        @Override
        public int setValue(int n) {
            int n2 = Int2IntArrayMap.this.value[this.index];
            Int2IntArrayMap.this.value[this.index] = n;
            return n2;
        }

        @Override
        public IntIntPair right(int n) {
            Int2IntArrayMap.this.value[this.index] = n;
            return this;
        }

        @Override
        @Deprecated
        public Integer getKey() {
            return Int2IntArrayMap.this.key[this.index];
        }

        @Override
        @Deprecated
        public Integer getValue() {
            return Int2IntArrayMap.this.value[this.index];
        }

        @Override
        @Deprecated
        public Integer setValue(Integer n) {
            return this.setValue((int)n);
        }

        @Override
        public boolean equals(Object object) {
            if (!(object instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry)object;
            return Int2IntArrayMap.this.key[this.index] == (Integer)entry.getKey() && Int2IntArrayMap.this.value[this.index] == (Integer)entry.getValue();
        }

        @Override
        public int hashCode() {
            return Int2IntArrayMap.this.key[this.index] ^ Int2IntArrayMap.this.value[this.index];
        }

        public String toString() {
            return Int2IntArrayMap.this.key[this.index] + "=>" + Int2IntArrayMap.this.value[this.index];
        }
    }
}


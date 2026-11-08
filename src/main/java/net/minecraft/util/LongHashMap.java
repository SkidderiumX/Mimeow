/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

public class LongHashMap<V> {
    private transient Entry<V>[] hashArray = new Entry[4096];
    private transient int numHashElements;
    private int mask = this.hashArray.length - 1;
    private int capacity = 3072;
    private final float percentUseable = 0.75f;
    private volatile transient int modCount;

    private static int getHashedKey(long l) {
        return (int)(l ^ l >>> 27);
    }

    private static int hash(int n) {
        n = n ^ n >>> 20 ^ n >>> 12;
        return n ^ n >>> 7 ^ n >>> 4;
    }

    private static int getHashIndex(int n, int n2) {
        return n & n2;
    }

    public int getNumHashElements() {
        return this.numHashElements;
    }

    public V getValueByKey(long l) {
        int n = LongHashMap.getHashedKey(l);
        Entry<V> entry = this.hashArray[LongHashMap.getHashIndex(n, this.mask)];
        while (entry != null) {
            if (entry.key == l) {
                return entry.value;
            }
            entry = entry.nextEntry;
        }
        return null;
    }

    public boolean containsItem(long l) {
        return this.getEntry(l) != null;
    }

    final Entry<V> getEntry(long l) {
        int n = LongHashMap.getHashedKey(l);
        Entry<V> entry = this.hashArray[LongHashMap.getHashIndex(n, this.mask)];
        while (entry != null) {
            if (entry.key == l) {
                return entry;
            }
            entry = entry.nextEntry;
        }
        return null;
    }

    public void add(long l, V v) {
        int n = LongHashMap.getHashedKey(l);
        int n2 = LongHashMap.getHashIndex(n, this.mask);
        Entry<V> entry = this.hashArray[n2];
        while (entry != null) {
            if (entry.key == l) {
                entry.value = v;
                return;
            }
            entry = entry.nextEntry;
        }
        ++this.modCount;
        this.createKey(n, l, v, n2);
    }

    private void resizeTable(int n) {
        Entry<V>[] entryArray = this.hashArray;
        int n2 = entryArray.length;
        if (n2 == 0x40000000) {
            this.capacity = Integer.MAX_VALUE;
        } else {
            Entry[] entryArray2 = new Entry[n];
            this.copyHashTableTo(entryArray2);
            this.hashArray = entryArray2;
            this.mask = this.hashArray.length - 1;
            float f = n;
            this.getClass();
            this.capacity = (int)(f * 0.75f);
        }
    }

    private void copyHashTableTo(Entry<V>[] entryArray) {
        Entry<V>[] entryArray2 = this.hashArray;
        int n = entryArray.length;
        for (int i = 0; i < entryArray2.length; ++i) {
            Entry entry;
            Entry<V> entry2 = entryArray2[i];
            if (entry2 == null) continue;
            entryArray2[i] = null;
            do {
                entry = entry2.nextEntry;
                int n2 = LongHashMap.getHashIndex(entry2.hash, n - 1);
                entry2.nextEntry = entryArray[n2];
                entryArray[n2] = entry2;
                entry2 = entry;
            } while (entry != null);
        }
    }

    public V remove(long l) {
        Entry<V> entry = this.removeKey(l);
        return entry == null ? null : (V)entry.value;
    }

    final Entry<V> removeKey(long l) {
        Entry<V> entry;
        int n = LongHashMap.getHashedKey(l);
        int n2 = LongHashMap.getHashIndex(n, this.mask);
        Entry<V> entry2 = entry = this.hashArray[n2];
        while (entry2 != null) {
            Entry entry3 = entry2.nextEntry;
            if (entry2.key == l) {
                ++this.modCount;
                --this.numHashElements;
                if (entry == entry2) {
                    this.hashArray[n2] = entry3;
                } else {
                    entry.nextEntry = entry3;
                }
                return entry2;
            }
            entry = entry2;
            entry2 = entry3;
        }
        return entry2;
    }

    private void createKey(int n, long l, V v, int n2) {
        Entry<V> entry = this.hashArray[n2];
        this.hashArray[n2] = new Entry<V>(n, l, v, entry);
        if (this.numHashElements++ >= this.capacity) {
            this.resizeTable(2 * this.hashArray.length);
        }
    }

    public double getKeyDistribution() {
        int n = 0;
        for (int i = 0; i < this.hashArray.length; ++i) {
            if (this.hashArray[i] == null) continue;
            ++n;
        }
        return 1.0 * (double)n / (double)this.numHashElements;
    }

    public static class Entry<V> {
        final long key;
        V value;
        Entry<V> nextEntry;
        final int hash;

        Entry(int n, long l, V v, Entry<V> entry) {
            this.value = v;
            this.nextEntry = entry;
            this.key = l;
            this.hash = n;
        }

        public final long getKey() {
            return this.key;
        }

        public final V getValue() {
            return this.value;
        }

        public final boolean equals(Object object) {
            V v;
            V v2;
            Long l;
            if (!(object instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry)object;
            Long l2 = this.getKey();
            return (l2 == (l = Long.valueOf(entry.getKey())) || l2 != null && ((Object)l2).equals(l)) && ((v2 = this.getValue()) == (v = entry.getValue()) || v2 != null && v2.equals(v));
        }

        public final int hashCode() {
            return LongHashMap.getHashedKey(this.key);
        }

        public final String toString() {
            return this.getKey() + "=" + String.valueOf(this.getValue());
        }
    }
}


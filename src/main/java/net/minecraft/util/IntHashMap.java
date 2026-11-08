/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

public class IntHashMap<V> {
    private transient Entry<V>[] slots = new Entry[16];
    private transient int count;
    private int threshold = 12;
    private final float growFactor = 0.75f;

    private static int computeHash(int n) {
        n = n ^ n >>> 20 ^ n >>> 12;
        return n ^ n >>> 7 ^ n >>> 4;
    }

    private static int getSlotIndex(int n, int n2) {
        return n & n2 - 1;
    }

    public V lookup(int n) {
        int n2 = IntHashMap.computeHash(n);
        Entry<V> entry = this.slots[IntHashMap.getSlotIndex(n2, this.slots.length)];
        while (entry != null) {
            if (entry.hashEntry == n) {
                return entry.valueEntry;
            }
            entry = entry.nextEntry;
        }
        return null;
    }

    public boolean containsItem(int n) {
        return this.lookupEntry(n) != null;
    }

    final Entry<V> lookupEntry(int n) {
        int n2 = IntHashMap.computeHash(n);
        Entry<V> entry = this.slots[IntHashMap.getSlotIndex(n2, this.slots.length)];
        while (entry != null) {
            if (entry.hashEntry == n) {
                return entry;
            }
            entry = entry.nextEntry;
        }
        return null;
    }

    public void addKey(int n, V v) {
        int n2 = IntHashMap.computeHash(n);
        int n3 = IntHashMap.getSlotIndex(n2, this.slots.length);
        Entry<V> entry = this.slots[n3];
        while (entry != null) {
            if (entry.hashEntry == n) {
                entry.valueEntry = v;
                return;
            }
            entry = entry.nextEntry;
        }
        this.insert(n2, n, v, n3);
    }

    private void grow(int n) {
        Entry<V>[] entryArray = this.slots;
        int n2 = entryArray.length;
        if (n2 == 0x40000000) {
            this.threshold = Integer.MAX_VALUE;
        } else {
            Entry[] entryArray2 = new Entry[n];
            this.copyTo(entryArray2);
            this.slots = entryArray2;
            this.threshold = (int)((float)n * this.growFactor);
        }
    }

    private void copyTo(Entry<V>[] entryArray) {
        Entry<V>[] entryArray2 = this.slots;
        int n = entryArray.length;
        for (int i = 0; i < entryArray2.length; ++i) {
            Entry entry;
            Entry<V> entry2 = entryArray2[i];
            if (entry2 == null) continue;
            entryArray2[i] = null;
            do {
                entry = entry2.nextEntry;
                int n2 = IntHashMap.getSlotIndex(entry2.slotHash, n);
                entry2.nextEntry = entryArray[n2];
                entryArray[n2] = entry2;
                entry2 = entry;
            } while (entry != null);
        }
    }

    public V removeObject(int n) {
        Entry<V> entry = this.removeEntry(n);
        return entry == null ? null : (V)entry.valueEntry;
    }

    final Entry<V> removeEntry(int n) {
        Entry<V> entry;
        int n2 = IntHashMap.computeHash(n);
        int n3 = IntHashMap.getSlotIndex(n2, this.slots.length);
        Entry<V> entry2 = entry = this.slots[n3];
        while (entry2 != null) {
            Entry entry3 = entry2.nextEntry;
            if (entry2.hashEntry == n) {
                --this.count;
                if (entry == entry2) {
                    this.slots[n3] = entry3;
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

    public void clearMap() {
        Entry<V>[] entryArray = this.slots;
        for (int i = 0; i < entryArray.length; ++i) {
            entryArray[i] = null;
        }
        this.count = 0;
    }

    private void insert(int n, int n2, V v, int n3) {
        Entry<V> entry = this.slots[n3];
        this.slots[n3] = new Entry<V>(n, n2, v, entry);
        if (this.count++ >= this.threshold) {
            this.grow(2 * this.slots.length);
        }
    }

    public static class Entry<V> {
        final int hashEntry;
        V valueEntry;
        Entry<V> nextEntry;
        final int slotHash;

        Entry(int n, int n2, V v, Entry<V> entry) {
            this.valueEntry = v;
            this.nextEntry = entry;
            this.hashEntry = n2;
            this.slotHash = n;
        }

        public final int getHash() {
            return this.hashEntry;
        }

        public final V getValue() {
            return this.valueEntry;
        }

        public final boolean equals(Object object) {
            V v;
            V v2;
            Integer n;
            if (!(object instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry)object;
            Integer n2 = this.getHash();
            return (n2 == (n = Integer.valueOf(entry.getHash())) || n2 != null && ((Object)n2).equals(n)) && ((v2 = this.getValue()) == (v = entry.getValue()) || v2 != null && v2.equals(v));
        }

        public final int hashCode() {
            return IntHashMap.computeHash(this.hashEntry);
        }

        public final String toString() {
            return this.getHash() + "=" + String.valueOf(this.getValue());
        }
    }
}


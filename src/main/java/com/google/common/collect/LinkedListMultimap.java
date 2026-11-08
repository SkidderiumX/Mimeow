/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMapEntry;
import com.google.common.collect.AbstractMultimap;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;
import com.google.common.collect.TransformedListIterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true, emulated=true)
public class LinkedListMultimap<K, V>
extends AbstractMultimap<K, V>
implements ListMultimap<K, V>,
Serializable {
    private transient Node<K, V> head;
    private transient Node<K, V> tail;
    private transient Map<K, KeyList<K, V>> keyToKeyList;
    private transient int size;
    private transient int modCount;
    @GwtIncompatible(value="java serialization not supported")
    private static final long serialVersionUID = 0L;

    public static <K, V> LinkedListMultimap<K, V> create() {
        return new LinkedListMultimap<K, V>();
    }

    public static <K, V> LinkedListMultimap<K, V> create(int n) {
        return new LinkedListMultimap<K, V>(n);
    }

    public static <K, V> LinkedListMultimap<K, V> create(Multimap<? extends K, ? extends V> multimap) {
        return new LinkedListMultimap<K, V>(multimap);
    }

    LinkedListMultimap() {
        this.keyToKeyList = Maps.newHashMap();
    }

    private LinkedListMultimap(int n) {
        this.keyToKeyList = new HashMap<K, KeyList<K, V>>(n);
    }

    private LinkedListMultimap(Multimap<? extends K, ? extends V> multimap) {
        this(multimap.keySet().size());
        this.putAll((Multimap)multimap);
    }

    private Node<K, V> addNode(@Nullable K k, @Nullable V v, @Nullable Node<K, V> node) {
        Node<K, V> node2 = new Node<K, V>(k, v);
        if (this.head == null) {
            this.tail = node2;
            this.head = this.tail;
            this.keyToKeyList.put(k, new KeyList<K, V>(node2));
            ++this.modCount;
        } else if (node == null) {
            this.tail.next = node2;
            node2.previous = this.tail;
            this.tail = node2;
            KeyList<K, V> keyList = this.keyToKeyList.get(k);
            if (keyList == null) {
                keyList = new KeyList<K, V>(node2);
                this.keyToKeyList.put(k, keyList);
                ++this.modCount;
            } else {
                ++keyList.count;
                Node node3 = keyList.tail;
                node3.nextSibling = node2;
                node2.previousSibling = node3;
                keyList.tail = node2;
            }
        } else {
            KeyList<K, V> keyList = this.keyToKeyList.get(k);
            ++keyList.count;
            node2.previous = node.previous;
            node2.previousSibling = node.previousSibling;
            node2.next = node;
            node2.nextSibling = node;
            if (node.previousSibling == null) {
                this.keyToKeyList.get(k).head = node2;
            } else {
                node.previousSibling.nextSibling = node2;
            }
            if (node.previous == null) {
                this.head = node2;
            } else {
                node.previous.next = node2;
            }
            node.previous = node2;
            node.previousSibling = node2;
        }
        ++this.size;
        return node2;
    }

    private void removeNode(Node<K, V> node) {
        if (node.previous != null) {
            node.previous.next = node.next;
        } else {
            this.head = node.next;
        }
        if (node.next != null) {
            node.next.previous = node.previous;
        } else {
            this.tail = node.previous;
        }
        if (node.previousSibling == null && node.nextSibling == null) {
            KeyList<K, V> keyList = this.keyToKeyList.remove(node.key);
            keyList.count = 0;
            ++this.modCount;
        } else {
            KeyList<K, V> keyList = this.keyToKeyList.get(node.key);
            --keyList.count;
            if (node.previousSibling == null) {
                keyList.head = node.nextSibling;
            } else {
                node.previousSibling.nextSibling = node.nextSibling;
            }
            if (node.nextSibling == null) {
                keyList.tail = node.previousSibling;
            } else {
                node.nextSibling.previousSibling = node.previousSibling;
            }
        }
        --this.size;
    }

    private void removeAllNodes(@Nullable Object object) {
        Iterators.clear(new ValueForKeyIterator(object));
    }

    private static void checkElement(@Nullable Object object) {
        if (object == null) {
            throw new NoSuchElementException();
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public boolean containsKey(@Nullable Object object) {
        return this.keyToKeyList.containsKey(object);
    }

    @Override
    public boolean containsValue(@Nullable Object object) {
        return this.values().contains(object);
    }

    @Override
    public boolean put(@Nullable K k, @Nullable V v) {
        this.addNode(k, v, null);
        return true;
    }

    @Override
    public List<V> replaceValues(@Nullable K k, Iterable<? extends V> iterable) {
        List<V> list = this.getCopy(k);
        ValueForKeyIterator valueForKeyIterator = new ValueForKeyIterator(k);
        Iterator<V> iterator2 = iterable.iterator();
        while (valueForKeyIterator.hasNext() && iterator2.hasNext()) {
            valueForKeyIterator.next();
            valueForKeyIterator.set(iterator2.next());
        }
        while (valueForKeyIterator.hasNext()) {
            valueForKeyIterator.next();
            valueForKeyIterator.remove();
        }
        while (iterator2.hasNext()) {
            valueForKeyIterator.add(iterator2.next());
        }
        return list;
    }

    private List<V> getCopy(@Nullable Object object) {
        return Collections.unmodifiableList(Lists.newArrayList(new ValueForKeyIterator(object)));
    }

    @Override
    public List<V> removeAll(@Nullable Object object) {
        List<V> list = this.getCopy(object);
        this.removeAllNodes(object);
        return list;
    }

    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        this.keyToKeyList.clear();
        this.size = 0;
        ++this.modCount;
    }

    @Override
    public List<V> get(final @Nullable K k) {
        return new AbstractSequentialList<V>(){

            @Override
            public int size() {
                KeyList keyList = (KeyList)LinkedListMultimap.this.keyToKeyList.get(k);
                return keyList == null ? 0 : keyList.count;
            }

            @Override
            public ListIterator<V> listIterator(int n) {
                return new ValueForKeyIterator(k, n);
            }
        };
    }

    @Override
    Set<K> createKeySet() {
        return new Sets.ImprovedAbstractSet<K>(){

            @Override
            public int size() {
                return LinkedListMultimap.this.keyToKeyList.size();
            }

            @Override
            public Iterator<K> iterator() {
                return new DistinctKeyIterator();
            }

            @Override
            public boolean contains(Object object) {
                return LinkedListMultimap.this.containsKey(object);
            }

            @Override
            public boolean remove(Object object) {
                return !LinkedListMultimap.this.removeAll(object).isEmpty();
            }
        };
    }

    @Override
    public List<V> values() {
        return (List)super.values();
    }

    @Override
    List<V> createValues() {
        return new AbstractSequentialList<V>(){

            @Override
            public int size() {
                return LinkedListMultimap.this.size;
            }

            @Override
            public ListIterator<V> listIterator(int n) {
                final NodeIterator nodeIterator = new NodeIterator(n);
                return new TransformedListIterator<Map.Entry<K, V>, V>(nodeIterator){

                    @Override
                    V transform(Map.Entry<K, V> entry) {
                        return entry.getValue();
                    }

                    @Override
                    public void set(V v) {
                        nodeIterator.setValue(v);
                    }
                };
            }
        };
    }

    @Override
    public List<Map.Entry<K, V>> entries() {
        return (List)super.entries();
    }

    @Override
    List<Map.Entry<K, V>> createEntries() {
        return new AbstractSequentialList<Map.Entry<K, V>>(){

            @Override
            public int size() {
                return LinkedListMultimap.this.size;
            }

            @Override
            public ListIterator<Map.Entry<K, V>> listIterator(int n) {
                return new NodeIterator(n);
            }
        };
    }

    @Override
    Iterator<Map.Entry<K, V>> entryIterator() {
        throw new AssertionError((Object)"should never be called");
    }

    @Override
    Map<K, Collection<V>> createAsMap() {
        return new Multimaps.AsMap(this);
    }

    @GwtIncompatible(value="java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.size());
        for (Map.Entry entry : this.entries()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    @GwtIncompatible(value="java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.keyToKeyList = Maps.newLinkedHashMap();
        int n = objectInputStream.readInt();
        for (int i = 0; i < n; ++i) {
            Object object = objectInputStream.readObject();
            Object object2 = objectInputStream.readObject();
            this.put(object, object2);
        }
    }

    private class ValueForKeyIterator
    implements ListIterator<V> {
        final Object key;
        int nextIndex;
        Node<K, V> next;
        Node<K, V> current;
        Node<K, V> previous;

        ValueForKeyIterator(Object object) {
            this.key = object;
            KeyList keyList = (KeyList)LinkedListMultimap.this.keyToKeyList.get(object);
            this.next = keyList == null ? null : keyList.head;
        }

        public ValueForKeyIterator(Object object, int n) {
            KeyList keyList = (KeyList)LinkedListMultimap.this.keyToKeyList.get(object);
            int n2 = keyList == null ? 0 : keyList.count;
            Preconditions.checkPositionIndex(n, n2);
            if (n >= n2 / 2) {
                this.previous = keyList == null ? null : keyList.tail;
                this.nextIndex = n2;
                while (n++ < n2) {
                    this.previous();
                }
            } else {
                Node node = this.next = keyList == null ? null : keyList.head;
                while (n-- > 0) {
                    this.next();
                }
            }
            this.key = object;
            this.current = null;
        }

        @Override
        public boolean hasNext() {
            return this.next != null;
        }

        @Override
        public V next() {
            LinkedListMultimap.checkElement(this.next);
            this.current = this.next;
            this.previous = this.current;
            this.next = this.next.nextSibling;
            ++this.nextIndex;
            return this.current.value;
        }

        @Override
        public boolean hasPrevious() {
            return this.previous != null;
        }

        @Override
        public V previous() {
            LinkedListMultimap.checkElement(this.previous);
            this.current = this.previous;
            this.next = this.current;
            this.previous = this.previous.previousSibling;
            --this.nextIndex;
            return this.current.value;
        }

        @Override
        public int nextIndex() {
            return this.nextIndex;
        }

        @Override
        public int previousIndex() {
            return this.nextIndex - 1;
        }

        @Override
        public void remove() {
            CollectPreconditions.checkRemove(this.current != null);
            if (this.current != this.next) {
                this.previous = this.current.previousSibling;
                --this.nextIndex;
            } else {
                this.next = this.current.nextSibling;
            }
            LinkedListMultimap.this.removeNode(this.current);
            this.current = null;
        }

        @Override
        public void set(V v) {
            Preconditions.checkState(this.current != null);
            this.current.value = v;
        }

        @Override
        public void add(V v) {
            this.previous = LinkedListMultimap.this.addNode(this.key, v, this.next);
            ++this.nextIndex;
            this.current = null;
        }
    }

    private class DistinctKeyIterator
    implements Iterator<K> {
        final Set<K> seenKeys;
        Node<K, V> next;
        Node<K, V> current;
        int expectedModCount;

        private DistinctKeyIterator() {
            this.seenKeys = Sets.newHashSetWithExpectedSize(LinkedListMultimap.this.keySet().size());
            this.next = LinkedListMultimap.this.head;
            this.expectedModCount = LinkedListMultimap.this.modCount;
        }

        private void checkForConcurrentModification() {
            if (LinkedListMultimap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        public boolean hasNext() {
            this.checkForConcurrentModification();
            return this.next != null;
        }

        @Override
        public K next() {
            this.checkForConcurrentModification();
            LinkedListMultimap.checkElement(this.next);
            this.current = this.next;
            this.seenKeys.add(this.current.key);
            do {
                this.next = this.next.next;
            } while (this.next != null && !this.seenKeys.add(this.next.key));
            return this.current.key;
        }

        @Override
        public void remove() {
            this.checkForConcurrentModification();
            CollectPreconditions.checkRemove(this.current != null);
            LinkedListMultimap.this.removeAllNodes(this.current.key);
            this.current = null;
            this.expectedModCount = LinkedListMultimap.this.modCount;
        }
    }

    private class NodeIterator
    implements ListIterator<Map.Entry<K, V>> {
        int nextIndex;
        Node<K, V> next;
        Node<K, V> current;
        Node<K, V> previous;
        int expectedModCount;

        NodeIterator(int n) {
            this.expectedModCount = LinkedListMultimap.this.modCount;
            int n2 = LinkedListMultimap.this.size();
            Preconditions.checkPositionIndex(n, n2);
            if (n >= n2 / 2) {
                this.previous = LinkedListMultimap.this.tail;
                this.nextIndex = n2;
                while (n++ < n2) {
                    this.previous();
                }
            } else {
                this.next = LinkedListMultimap.this.head;
                while (n-- > 0) {
                    this.next();
                }
            }
            this.current = null;
        }

        private void checkForConcurrentModification() {
            if (LinkedListMultimap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        public boolean hasNext() {
            this.checkForConcurrentModification();
            return this.next != null;
        }

        @Override
        public Node<K, V> next() {
            this.checkForConcurrentModification();
            LinkedListMultimap.checkElement(this.next);
            this.current = this.next;
            this.previous = this.current;
            this.next = this.next.next;
            ++this.nextIndex;
            return this.current;
        }

        @Override
        public void remove() {
            this.checkForConcurrentModification();
            CollectPreconditions.checkRemove(this.current != null);
            if (this.current != this.next) {
                this.previous = this.current.previous;
                --this.nextIndex;
            } else {
                this.next = this.current.next;
            }
            LinkedListMultimap.this.removeNode(this.current);
            this.current = null;
            this.expectedModCount = LinkedListMultimap.this.modCount;
        }

        @Override
        public boolean hasPrevious() {
            this.checkForConcurrentModification();
            return this.previous != null;
        }

        @Override
        public Node<K, V> previous() {
            this.checkForConcurrentModification();
            LinkedListMultimap.checkElement(this.previous);
            this.current = this.previous;
            this.next = this.current;
            this.previous = this.previous.previous;
            --this.nextIndex;
            return this.current;
        }

        @Override
        public int nextIndex() {
            return this.nextIndex;
        }

        @Override
        public int previousIndex() {
            return this.nextIndex - 1;
        }

        @Override
        public void set(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        void setValue(V v) {
            Preconditions.checkState(this.current != null);
            this.current.value = v;
        }
    }

    private static class KeyList<K, V> {
        Node<K, V> head;
        Node<K, V> tail;
        int count;

        KeyList(Node<K, V> node) {
            this.head = node;
            this.tail = node;
            node.previousSibling = null;
            node.nextSibling = null;
            this.count = 1;
        }
    }

    private static final class Node<K, V>
    extends AbstractMapEntry<K, V> {
        final K key;
        V value;
        Node<K, V> next;
        Node<K, V> previous;
        Node<K, V> nextSibling;
        Node<K, V> previousSibling;

        Node(@Nullable K k, @Nullable V v) {
            this.key = k;
            this.value = v;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public V setValue(@Nullable V v) {
            V v2 = this.value;
            this.value = v;
            return v2;
        }
    }
}


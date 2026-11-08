/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.logging.impl;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class WeakHashtable
extends Hashtable {
    private static final long serialVersionUID = -1546036869799732453L;
    private static final int MAX_CHANGES_BEFORE_PURGE = 100;
    private static final int PARTIAL_PURGE_COUNT = 10;
    private final ReferenceQueue queue = new ReferenceQueue();
    private int changeCount = 0;

    public boolean containsKey(Object object) {
        Referenced referenced = new Referenced(object);
        return super.containsKey(referenced);
    }

    public Enumeration elements() {
        this.purge();
        return super.elements();
    }

    public Set entrySet() {
        this.purge();
        Set set = super.entrySet();
        HashSet<Entry> hashSet = new HashSet<Entry>();
        Iterator iterator2 = set.iterator();
        while (iterator2.hasNext()) {
            Map.Entry entry = iterator2.next();
            Referenced referenced = (Referenced)entry.getKey();
            Object object = referenced.getValue();
            Object v = entry.getValue();
            if (object == null) continue;
            Entry entry2 = new Entry(object, v);
            hashSet.add(entry2);
        }
        return hashSet;
    }

    public Object get(Object object) {
        Referenced referenced = new Referenced(object);
        return super.get(referenced);
    }

    public Enumeration keys() {
        this.purge();
        final Enumeration enumeration = super.keys();
        return new Enumeration(){

            public boolean hasMoreElements() {
                return enumeration.hasMoreElements();
            }

            public Object nextElement() {
                Referenced referenced = (Referenced)enumeration.nextElement();
                return referenced.getValue();
            }
        };
    }

    public Set keySet() {
        this.purge();
        Set set = super.keySet();
        HashSet<Object> hashSet = new HashSet<Object>();
        Iterator iterator2 = set.iterator();
        while (iterator2.hasNext()) {
            Referenced referenced = (Referenced)iterator2.next();
            Object object = referenced.getValue();
            if (object == null) continue;
            hashSet.add(object);
        }
        return hashSet;
    }

    public synchronized Object put(Object object, Object object2) {
        if (object == null) {
            throw new NullPointerException("Null keys are not allowed");
        }
        if (object2 == null) {
            throw new NullPointerException("Null values are not allowed");
        }
        if (this.changeCount++ > 100) {
            this.purge();
            this.changeCount = 0;
        } else if (this.changeCount % 10 == 0) {
            this.purgeOne();
        }
        Referenced referenced = new Referenced(object, this.queue);
        return super.put(referenced, object2);
    }

    public void putAll(Map map) {
        if (map != null) {
            Set set = map.entrySet();
            Iterator iterator2 = set.iterator();
            while (iterator2.hasNext()) {
                Map.Entry entry = iterator2.next();
                this.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public Collection values() {
        this.purge();
        return super.values();
    }

    public synchronized Object remove(Object object) {
        if (this.changeCount++ > 100) {
            this.purge();
            this.changeCount = 0;
        } else if (this.changeCount % 10 == 0) {
            this.purgeOne();
        }
        return super.remove(new Referenced(object));
    }

    public boolean isEmpty() {
        this.purge();
        return super.isEmpty();
    }

    public int size() {
        this.purge();
        return super.size();
    }

    public String toString() {
        this.purge();
        return super.toString();
    }

    protected void rehash() {
        this.purge();
        super.rehash();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void purge() {
        ArrayList<Referenced> arrayList = new ArrayList<Referenced>();
        ReferenceQueue referenceQueue = this.queue;
        synchronized (referenceQueue) {
            WeakKey weakKey;
            while ((weakKey = (WeakKey)this.queue.poll()) != null) {
                arrayList.add(weakKey.getReferenced());
            }
        }
        int n = arrayList.size();
        for (int i = 0; i < n; ++i) {
            super.remove(arrayList.get(i));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void purgeOne() {
        ReferenceQueue referenceQueue = this.queue;
        synchronized (referenceQueue) {
            WeakKey weakKey = (WeakKey)this.queue.poll();
            if (weakKey != null) {
                super.remove(weakKey.getReferenced());
            }
        }
    }

    private static final class WeakKey
    extends WeakReference {
        private final Referenced referenced;

        private WeakKey(Object object, ReferenceQueue referenceQueue, Referenced referenced) {
            super(object, referenceQueue);
            this.referenced = referenced;
        }

        private Referenced getReferenced() {
            return this.referenced;
        }
    }

    private static final class Referenced {
        private final WeakReference reference;
        private final int hashCode;

        private Referenced(Object object) {
            this.reference = new WeakReference<Object>(object);
            this.hashCode = object.hashCode();
        }

        private Referenced(Object object, ReferenceQueue referenceQueue) {
            this.reference = new WeakKey(object, referenceQueue, this);
            this.hashCode = object.hashCode();
        }

        public int hashCode() {
            return this.hashCode;
        }

        private Object getValue() {
            return this.reference.get();
        }

        public boolean equals(Object object) {
            boolean bl = false;
            if (object instanceof Referenced) {
                Referenced referenced = (Referenced)object;
                Object object2 = this.getValue();
                Object object3 = referenced.getValue();
                if (object2 == null) {
                    bl = object3 == null;
                    bl = bl && this.hashCode() == referenced.hashCode();
                } else {
                    bl = object2.equals(object3);
                }
            }
            return bl;
        }
    }

    private static final class Entry
    implements Map.Entry {
        private final Object key;
        private final Object value;

        private Entry(Object object, Object object2) {
            this.key = object;
            this.value = object2;
        }

        public boolean equals(Object object) {
            boolean bl = false;
            if (object != null && object instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry)object;
                bl = (this.getKey() == null ? entry.getKey() == null : this.getKey().equals(entry.getKey())) && (this.getValue() == null ? entry.getValue() == null : this.getValue().equals(entry.getValue()));
            }
            return bl;
        }

        public int hashCode() {
            return (this.getKey() == null ? 0 : this.getKey().hashCode()) ^ (this.getValue() == null ? 0 : this.getValue().hashCode());
        }

        public Object setValue(Object object) {
            throw new UnsupportedOperationException("Entry.setValue is not supported.");
        }

        public Object getValue() {
            return this.value;
        }

        public Object getKey() {
            return this.key;
        }
    }
}


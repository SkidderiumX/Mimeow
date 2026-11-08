/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.spi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.spi.ThreadContextStack;

public class MutableThreadContextStack
implements ThreadContextStack {
    private static final long serialVersionUID = 50505011L;
    private final List<String> list;

    public MutableThreadContextStack(List<String> list) {
        this.list = new ArrayList<String>(list);
    }

    private MutableThreadContextStack(MutableThreadContextStack mutableThreadContextStack) {
        this.list = new ArrayList<String>(mutableThreadContextStack.list);
    }

    @Override
    public String pop() {
        if (this.list.isEmpty()) {
            return null;
        }
        int n = this.list.size() - 1;
        String string = this.list.remove(n);
        return string;
    }

    @Override
    public String peek() {
        if (this.list.isEmpty()) {
            return null;
        }
        int n = this.list.size() - 1;
        return this.list.get(n);
    }

    @Override
    public void push(String string) {
        this.list.add(string);
    }

    @Override
    public int getDepth() {
        return this.list.size();
    }

    @Override
    public List<String> asList() {
        return this.list;
    }

    @Override
    public void trim(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Maximum stack depth cannot be negative");
        }
        if (this.list == null) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<String>(this.list.size());
        int n2 = Math.min(n, this.list.size());
        for (int i = 0; i < n2; ++i) {
            arrayList.add(this.list.get(i));
        }
        this.list.clear();
        this.list.addAll(arrayList);
    }

    @Override
    public ThreadContextStack copy() {
        return new MutableThreadContextStack(this);
    }

    @Override
    public void clear() {
        this.list.clear();
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public boolean contains(Object object) {
        return this.list.contains(object);
    }

    @Override
    public Iterator<String> iterator() {
        return this.list.iterator();
    }

    @Override
    public Object[] toArray() {
        return this.list.toArray();
    }

    @Override
    public <T> T[] toArray(T[] TArray) {
        return this.list.toArray(TArray);
    }

    @Override
    public boolean add(String string) {
        return this.list.add(string);
    }

    @Override
    public boolean remove(Object object) {
        return this.list.remove(object);
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return this.list.containsAll(collection);
    }

    @Override
    public boolean addAll(Collection<? extends String> collection) {
        return this.list.addAll(collection);
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return this.list.removeAll(collection);
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return this.list.retainAll(collection);
    }

    public String toString() {
        return String.valueOf(this.list);
    }
}


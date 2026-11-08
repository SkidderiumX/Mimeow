/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.spi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.apache.logging.log4j.spi.MutableThreadContextStack;
import org.apache.logging.log4j.spi.ThreadContextStack;

public class DefaultThreadContextStack
implements ThreadContextStack {
    private static final long serialVersionUID = 5050501L;
    private static ThreadLocal<List<String>> stack = new ThreadLocal();
    private final boolean useStack;

    public DefaultThreadContextStack(boolean bl) {
        this.useStack = bl;
    }

    @Override
    public String pop() {
        if (!this.useStack) {
            return "";
        }
        List<String> list = stack.get();
        if (list == null || list.size() == 0) {
            throw new NoSuchElementException("The ThreadContext stack is empty");
        }
        ArrayList<String> arrayList = new ArrayList<String>(list);
        int n = arrayList.size() - 1;
        String string = (String)arrayList.remove(n);
        stack.set(Collections.unmodifiableList(arrayList));
        return string;
    }

    @Override
    public String peek() {
        List<String> list = stack.get();
        if (list == null || list.size() == 0) {
            return null;
        }
        int n = list.size() - 1;
        return list.get(n);
    }

    @Override
    public void push(String string) {
        if (!this.useStack) {
            return;
        }
        this.add(string);
    }

    @Override
    public int getDepth() {
        List<String> list = stack.get();
        return list == null ? 0 : list.size();
    }

    @Override
    public List<String> asList() {
        List<String> list = stack.get();
        if (list == null) {
            return Collections.emptyList();
        }
        return list;
    }

    @Override
    public void trim(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Maximum stack depth cannot be negative");
        }
        List<String> list = stack.get();
        if (list == null) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<String>();
        int n2 = Math.min(n, list.size());
        for (int i = 0; i < n2; ++i) {
            arrayList.add(list.get(i));
        }
        stack.set(arrayList);
    }

    @Override
    public ThreadContextStack copy() {
        List<String> list = null;
        if (!this.useStack || (list = stack.get()) == null) {
            return new MutableThreadContextStack(new ArrayList<String>());
        }
        return new MutableThreadContextStack(list);
    }

    @Override
    public void clear() {
        stack.remove();
    }

    @Override
    public int size() {
        List<String> list = stack.get();
        return list == null ? 0 : list.size();
    }

    @Override
    public boolean isEmpty() {
        List<String> list = stack.get();
        return list == null || list.isEmpty();
    }

    @Override
    public boolean contains(Object object) {
        List<String> list = stack.get();
        return list != null && list.contains(object);
    }

    @Override
    public Iterator<String> iterator() {
        List<String> list = stack.get();
        if (list == null) {
            List list2 = Collections.emptyList();
            return list2.iterator();
        }
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        List<String> list = stack.get();
        if (list == null) {
            return new String[0];
        }
        return list.toArray(new Object[list.size()]);
    }

    @Override
    public <T> T[] toArray(T[] TArray) {
        List<String> list = stack.get();
        if (list == null) {
            if (TArray.length > 0) {
                TArray[0] = null;
            }
            return TArray;
        }
        return list.toArray(TArray);
    }

    @Override
    public boolean add(String string) {
        if (!this.useStack) {
            return false;
        }
        List<String> list = stack.get();
        ArrayList<String> arrayList = list == null ? new ArrayList<String>() : new ArrayList<String>(list);
        arrayList.add(string);
        stack.set(Collections.unmodifiableList(arrayList));
        return true;
    }

    @Override
    public boolean remove(Object object) {
        if (!this.useStack) {
            return false;
        }
        List<String> list = stack.get();
        if (list == null || list.size() == 0) {
            return false;
        }
        ArrayList<String> arrayList = new ArrayList<String>(list);
        boolean bl = arrayList.remove(object);
        stack.set(Collections.unmodifiableList(arrayList));
        return bl;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        if (collection.isEmpty()) {
            return true;
        }
        List<String> list = stack.get();
        return list != null && list.containsAll(collection);
    }

    @Override
    public boolean addAll(Collection<? extends String> collection) {
        if (!this.useStack || collection.isEmpty()) {
            return false;
        }
        List<String> list = stack.get();
        ArrayList<? extends String> arrayList = list == null ? new ArrayList<String>() : new ArrayList<String>(list);
        arrayList.addAll(collection);
        stack.set(Collections.unmodifiableList(arrayList));
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        if (!this.useStack || collection.isEmpty()) {
            return false;
        }
        List<String> list = stack.get();
        if (list == null || list.isEmpty()) {
            return false;
        }
        ArrayList<String> arrayList = new ArrayList<String>(list);
        boolean bl = arrayList.removeAll(collection);
        stack.set(Collections.unmodifiableList(arrayList));
        return bl;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        if (!this.useStack || collection.isEmpty()) {
            return false;
        }
        List<String> list = stack.get();
        if (list == null || list.isEmpty()) {
            return false;
        }
        ArrayList<String> arrayList = new ArrayList<String>(list);
        boolean bl = arrayList.retainAll(collection);
        stack.set(Collections.unmodifiableList(arrayList));
        return bl;
    }

    public String toString() {
        List<String> list = stack.get();
        return list == null ? "[]" : list.toString();
    }
}


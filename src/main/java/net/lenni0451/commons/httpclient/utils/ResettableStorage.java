/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.httpclient.utils;

public class ResettableStorage<T> {
    private boolean set = false;
    private T value;

    public ResettableStorage() {
    }

    public ResettableStorage(T t) {
        this.set(t);
    }

    public boolean isSet() {
        return this.set;
    }

    public void unset() {
        this.set = false;
        this.value = null;
    }

    public T get() {
        if (!this.set) {
            throw new IllegalStateException("Value is not set");
        }
        return this.value;
    }

    public void set(T t) {
        this.value = t;
        this.set = true;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.util.holder;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import lombok.Generated;
import net.raphimc.minecraftauth.util.Expirable;
import net.raphimc.minecraftauth.util.holder.IoSupplier;
import net.raphimc.minecraftauth.util.holder.listener.ChangeListeners;
import org.jetbrains.annotations.ApiStatus;

public class Holder<T extends Expirable> {
    private final ChangeListeners changeListeners = new ChangeListeners();
    private final IoSupplier<T> supplier;
    private final Object lock;
    private T value;

    public Holder(IoSupplier<T> ioSupplier) {
        this(ioSupplier, new Object());
    }

    public Holder(IoSupplier<T> ioSupplier, Object object) {
        this.supplier = ioSupplier;
        this.lock = object;
    }

    public T getCached() {
        return this.value;
    }

    public boolean hasValue() {
        return this.value != null;
    }

    public boolean isExpired() {
        return this.value == null || this.value.isExpired();
    }

    public T getUpToDate() throws IOException {
        this.refreshIfExpired();
        return this.value;
    }

    public T getUpToDateUnchecked() {
        return this.getUpToDate();
    }

    public CompletableFuture<T> getUpToDateAsync() {
        return CompletableFuture.supplyAsync(this::getUpToDateUnchecked);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean refreshIfExpired() throws IOException {
        Object object = this.lock;
        synchronized (object) {
            if (this.isExpired()) {
                this.refresh();
                return true;
            }
            return false;
        }
    }

    public boolean refreshIfExpiredUnchecked() {
        return this.refreshIfExpired();
    }

    public CompletableFuture<Boolean> refreshIfExpiredAsync() {
        return CompletableFuture.supplyAsync(this::refreshIfExpiredUnchecked);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public T refresh() throws IOException {
        Object object = this.lock;
        synchronized (object) {
            this.set((Expirable)this.supplier.get());
            return this.value;
        }
    }

    public T refreshUnchecked() {
        return this.refresh();
    }

    public CompletableFuture<T> refreshAsync() {
        return CompletableFuture.supplyAsync(this::refreshUnchecked);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @ApiStatus.Internal
    public void set(T t) {
        Object object = this.lock;
        synchronized (object) {
            T t2 = this.value;
            this.value = t;
            this.changeListeners.invoke(t2, t);
        }
    }

    @Generated
    public ChangeListeners getChangeListeners() {
        return this.changeListeners;
    }
}


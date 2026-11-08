/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.util.holder;

import java.io.IOException;

@FunctionalInterface
public interface IoSupplier<T> {
    public T get() throws IOException;
}


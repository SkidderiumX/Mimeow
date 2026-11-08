/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_12_2to1_12_1.storage;

import com.viaversion.viaversion.api.connection.StorableObject;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.Nullable;

public class KeepAliveTracker
implements StorableObject {
    private final Map<Integer, Long> pending = new HashMap<Integer, Long>();
    private int nextId;

    public int track(long l) {
        int n = this.nextId++;
        this.pending.put(n, l);
        return n;
    }

    public @Nullable Long consume(int n) {
        return this.pending.remove(n);
    }
}


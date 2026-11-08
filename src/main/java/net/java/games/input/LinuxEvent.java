/*
 * Decompiled with CFR 0.152.
 */
package net.java.games.input;

import net.java.games.input.LinuxAxisDescriptor;

public class LinuxEvent {
    private long nanos;
    private final LinuxAxisDescriptor descriptor = new LinuxAxisDescriptor();
    private int value;

    LinuxEvent() {
    }

    public final void set(long l, long l2, int n, int n2, int n3) {
        this.nanos = (l * 1000000L + l2) * 1000L;
        this.descriptor.set(n, n2);
        this.value = n3;
    }

    public final int getValue() {
        return this.value;
    }

    public final LinuxAxisDescriptor getDescriptor() {
        return this.descriptor;
    }

    public final long getNanos() {
        return this.nanos;
    }
}


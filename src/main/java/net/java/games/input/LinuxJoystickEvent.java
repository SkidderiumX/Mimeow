/*
 * Decompiled with CFR 0.152.
 */
package net.java.games.input;

public class LinuxJoystickEvent {
    private long nanos;
    private int value;
    private int type;
    private int number;

    LinuxJoystickEvent() {
    }

    public final void set(long l, int n, int n2, int n3) {
        this.nanos = l * 1000000L;
        this.value = n;
        this.type = n2;
        this.number = n3;
    }

    public final int getValue() {
        return this.value;
    }

    public final int getType() {
        return this.type;
    }

    public final int getNumber() {
        return this.number;
    }

    public final long getNanos() {
        return this.nanos;
    }
}


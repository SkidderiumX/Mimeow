/*
 * Decompiled with CFR 0.152.
 */
package io.netty.channel.epoll;

import io.netty.channel.epoll.Native;

public class Epoll {
    private static final Throwable UNAVAILABILITY_CAUSE;

    public static boolean isAvailable() {
        return UNAVAILABILITY_CAUSE == null;
    }

    public static void ensureAvailability() {
        if (UNAVAILABILITY_CAUSE != null) {
            throw (Error)new UnsatisfiedLinkError("failed to load the required native library").initCause(UNAVAILABILITY_CAUSE);
        }
    }

    public static Throwable unavailabilityCause() {
        return UNAVAILABILITY_CAUSE;
    }

    private Epoll() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static {
        Throwable throwable = null;
        int n = -1;
        int n2 = -1;
        try {
            n = Native.epollCreate();
            n2 = Native.eventFd();
        }
        catch (Throwable throwable2) {
            throwable = throwable2;
        }
        finally {
            if (n != -1) {
                try {
                    Native.close(n);
                }
                catch (Exception exception) {}
            }
            if (n2 != -1) {
                try {
                    Native.close(n2);
                }
                catch (Exception exception) {}
            }
        }
        UNAVAILABILITY_CAUSE = throwable != null ? throwable : null;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.openal;

import org.jspecify.annotations.Nullable;
import org.lwjgl.openal.SOFTSystemEventProcI;
import org.lwjgl.system.Callback;

public abstract class SOFTSystemEventProc
extends Callback
implements SOFTSystemEventProcI {
    public static SOFTSystemEventProc create(long l) {
        SOFTSystemEventProcI sOFTSystemEventProcI = (SOFTSystemEventProcI)Callback.get(l);
        return sOFTSystemEventProcI instanceof SOFTSystemEventProc ? (SOFTSystemEventProc)sOFTSystemEventProcI : new Container(l, sOFTSystemEventProcI);
    }

    public static @Nullable SOFTSystemEventProc createSafe(long l) {
        return l == 0L ? null : SOFTSystemEventProc.create(l);
    }

    public static SOFTSystemEventProc create(SOFTSystemEventProcI sOFTSystemEventProcI) {
        return sOFTSystemEventProcI instanceof SOFTSystemEventProc ? (SOFTSystemEventProc)sOFTSystemEventProcI : new Container(sOFTSystemEventProcI.address(), sOFTSystemEventProcI);
    }

    protected SOFTSystemEventProc() {
        super(CIF);
    }

    SOFTSystemEventProc(long l) {
        super(l);
    }

    private static final class Container
    extends SOFTSystemEventProc {
        private final SOFTSystemEventProcI delegate;

        Container(long l, SOFTSystemEventProcI sOFTSystemEventProcI) {
            super(l);
            this.delegate = sOFTSystemEventProcI;
        }

        @Override
        public void invoke(int n, int n2, long l, int n3, long l2, long l3) {
            this.delegate.invoke(n, n2, l, n3, l2, l3);
        }
    }
}


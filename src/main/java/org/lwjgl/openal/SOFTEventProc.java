/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.openal;

import org.jspecify.annotations.Nullable;
import org.lwjgl.openal.SOFTEventProcI;
import org.lwjgl.system.Callback;

public abstract class SOFTEventProc
extends Callback
implements SOFTEventProcI {
    public static SOFTEventProc create(long l) {
        SOFTEventProcI sOFTEventProcI = (SOFTEventProcI)Callback.get(l);
        return sOFTEventProcI instanceof SOFTEventProc ? (SOFTEventProc)sOFTEventProcI : new Container(l, sOFTEventProcI);
    }

    public static @Nullable SOFTEventProc createSafe(long l) {
        return l == 0L ? null : SOFTEventProc.create(l);
    }

    public static SOFTEventProc create(SOFTEventProcI sOFTEventProcI) {
        return sOFTEventProcI instanceof SOFTEventProc ? (SOFTEventProc)sOFTEventProcI : new Container(sOFTEventProcI.address(), sOFTEventProcI);
    }

    protected SOFTEventProc() {
        super(CIF);
    }

    SOFTEventProc(long l) {
        super(l);
    }

    private static final class Container
    extends SOFTEventProc {
        private final SOFTEventProcI delegate;

        Container(long l, SOFTEventProcI sOFTEventProcI) {
            super(l);
            this.delegate = sOFTEventProcI;
        }

        @Override
        public void invoke(int n, int n2, int n3, int n4, long l, long l2) {
            this.delegate.invoke(n, n2, n3, n4, l, l2);
        }
    }
}


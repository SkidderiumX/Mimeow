/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.openal;

import org.jspecify.annotations.Nullable;
import org.lwjgl.openal.EXTDebugProcI;
import org.lwjgl.system.Callback;

public abstract class EXTDebugProc
extends Callback
implements EXTDebugProcI {
    public static EXTDebugProc create(long l) {
        EXTDebugProcI eXTDebugProcI = (EXTDebugProcI)Callback.get(l);
        return eXTDebugProcI instanceof EXTDebugProc ? (EXTDebugProc)eXTDebugProcI : new Container(l, eXTDebugProcI);
    }

    public static @Nullable EXTDebugProc createSafe(long l) {
        return l == 0L ? null : EXTDebugProc.create(l);
    }

    public static EXTDebugProc create(EXTDebugProcI eXTDebugProcI) {
        return eXTDebugProcI instanceof EXTDebugProc ? (EXTDebugProc)eXTDebugProcI : new Container(eXTDebugProcI.address(), eXTDebugProcI);
    }

    protected EXTDebugProc() {
        super(CIF);
    }

    EXTDebugProc(long l) {
        super(l);
    }

    private static final class Container
    extends EXTDebugProc {
        private final EXTDebugProcI delegate;

        Container(long l, EXTDebugProcI eXTDebugProcI) {
            super(l);
            this.delegate = eXTDebugProcI;
        }

        @Override
        public void invoke(int n, int n2, int n3, int n4, int n5, long l, long l2) {
            this.delegate.invoke(n, n2, n3, n4, n5, l, l2);
        }
    }
}


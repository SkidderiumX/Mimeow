/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.openal;

import org.jspecify.annotations.Nullable;
import org.lwjgl.openal.SOFTCallbackBufferTypeI;
import org.lwjgl.system.Callback;

public abstract class SOFTCallbackBufferType
extends Callback
implements SOFTCallbackBufferTypeI {
    public static SOFTCallbackBufferType create(long l) {
        SOFTCallbackBufferTypeI sOFTCallbackBufferTypeI = (SOFTCallbackBufferTypeI)Callback.get(l);
        return sOFTCallbackBufferTypeI instanceof SOFTCallbackBufferType ? (SOFTCallbackBufferType)sOFTCallbackBufferTypeI : new Container(l, sOFTCallbackBufferTypeI);
    }

    public static @Nullable SOFTCallbackBufferType createSafe(long l) {
        return l == 0L ? null : SOFTCallbackBufferType.create(l);
    }

    public static SOFTCallbackBufferType create(SOFTCallbackBufferTypeI sOFTCallbackBufferTypeI) {
        return sOFTCallbackBufferTypeI instanceof SOFTCallbackBufferType ? (SOFTCallbackBufferType)sOFTCallbackBufferTypeI : new Container(sOFTCallbackBufferTypeI.address(), sOFTCallbackBufferTypeI);
    }

    protected SOFTCallbackBufferType() {
        super(CIF);
    }

    SOFTCallbackBufferType(long l) {
        super(l);
    }

    private static final class Container
    extends SOFTCallbackBufferType {
        private final SOFTCallbackBufferTypeI delegate;

        Container(long l, SOFTCallbackBufferTypeI sOFTCallbackBufferTypeI) {
            super(l);
            this.delegate = sOFTCallbackBufferTypeI;
        }

        @Override
        public int invoke(long l, long l2, int n) {
            return this.delegate.invoke(l, l2, n);
        }
    }
}


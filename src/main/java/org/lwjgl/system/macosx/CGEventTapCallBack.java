/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.macosx;

import org.jspecify.annotations.Nullable;
import org.lwjgl.system.Callback;
import org.lwjgl.system.macosx.CGEventTapCallBackI;

public abstract class CGEventTapCallBack
extends Callback
implements CGEventTapCallBackI {
    public static CGEventTapCallBack create(long l) {
        CGEventTapCallBackI cGEventTapCallBackI = (CGEventTapCallBackI)Callback.get(l);
        return cGEventTapCallBackI instanceof CGEventTapCallBack ? (CGEventTapCallBack)cGEventTapCallBackI : new Container(l, cGEventTapCallBackI);
    }

    public static @Nullable CGEventTapCallBack createSafe(long l) {
        return l == 0L ? null : CGEventTapCallBack.create(l);
    }

    public static CGEventTapCallBack create(CGEventTapCallBackI cGEventTapCallBackI) {
        return cGEventTapCallBackI instanceof CGEventTapCallBack ? (CGEventTapCallBack)cGEventTapCallBackI : new Container(cGEventTapCallBackI.address(), cGEventTapCallBackI);
    }

    protected CGEventTapCallBack() {
        super(CIF);
    }

    CGEventTapCallBack(long l) {
        super(l);
    }

    private static final class Container
    extends CGEventTapCallBack {
        private final CGEventTapCallBackI delegate;

        Container(long l, CGEventTapCallBackI cGEventTapCallBackI) {
            super(l);
            this.delegate = cGEventTapCallBackI;
        }

        @Override
        public long invoke(long l, int n, long l2, long l3) {
            return this.delegate.invoke(l, n, l2, l3);
        }
    }
}


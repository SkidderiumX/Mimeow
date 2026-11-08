/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.nanovg;

import org.jspecify.annotations.Nullable;
import org.lwjgl.nanovg.UIHandlerI;
import org.lwjgl.system.Callback;

public abstract class UIHandler
extends Callback
implements UIHandlerI {
    public static UIHandler create(long l) {
        UIHandlerI uIHandlerI = (UIHandlerI)Callback.get(l);
        return uIHandlerI instanceof UIHandler ? (UIHandler)uIHandlerI : new Container(l, uIHandlerI);
    }

    public static @Nullable UIHandler createSafe(long l) {
        return l == 0L ? null : UIHandler.create(l);
    }

    public static UIHandler create(UIHandlerI uIHandlerI) {
        return uIHandlerI instanceof UIHandler ? (UIHandler)uIHandlerI : new Container(uIHandlerI.address(), uIHandlerI);
    }

    protected UIHandler() {
        super(CIF);
    }

    UIHandler(long l) {
        super(l);
    }

    private static final class Container
    extends UIHandler {
        private final UIHandlerI delegate;

        Container(long l, UIHandlerI uIHandlerI) {
            super(l);
            this.delegate = uIHandlerI;
        }

        @Override
        public void invoke(int n, int n2) {
            this.delegate.invoke(n, n2);
        }
    }
}


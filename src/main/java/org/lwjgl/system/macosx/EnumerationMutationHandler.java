/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.macosx;

import org.jspecify.annotations.Nullable;
import org.lwjgl.system.Callback;
import org.lwjgl.system.macosx.EnumerationMutationHandlerI;

public abstract class EnumerationMutationHandler
extends Callback
implements EnumerationMutationHandlerI {
    public static EnumerationMutationHandler create(long l) {
        EnumerationMutationHandlerI enumerationMutationHandlerI = (EnumerationMutationHandlerI)Callback.get(l);
        return enumerationMutationHandlerI instanceof EnumerationMutationHandler ? (EnumerationMutationHandler)enumerationMutationHandlerI : new Container(l, enumerationMutationHandlerI);
    }

    public static @Nullable EnumerationMutationHandler createSafe(long l) {
        return l == 0L ? null : EnumerationMutationHandler.create(l);
    }

    public static EnumerationMutationHandler create(EnumerationMutationHandlerI enumerationMutationHandlerI) {
        return enumerationMutationHandlerI instanceof EnumerationMutationHandler ? (EnumerationMutationHandler)enumerationMutationHandlerI : new Container(enumerationMutationHandlerI.address(), enumerationMutationHandlerI);
    }

    protected EnumerationMutationHandler() {
        super(CIF);
    }

    EnumerationMutationHandler(long l) {
        super(l);
    }

    private static final class Container
    extends EnumerationMutationHandler {
        private final EnumerationMutationHandlerI delegate;

        Container(long l, EnumerationMutationHandlerI enumerationMutationHandlerI) {
            super(l);
            this.delegate = enumerationMutationHandlerI;
        }

        @Override
        public void invoke(long l) {
            this.delegate.invoke(l);
        }
    }
}


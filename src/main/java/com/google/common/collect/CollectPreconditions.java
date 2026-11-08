/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;

@GwtCompatible
public class CollectPreconditions {
    CollectPreconditions() {
    }

    static void checkEntryNotNull(Object object, Object object2) {
        if (object == null) {
            throw new NullPointerException("null key in entry: null=" + object2);
        }
        if (object2 == null) {
            throw new NullPointerException("null value in entry: " + object + "=null");
        }
    }

    static int checkNonnegative(int n, String string) {
        if (n < 0) {
            throw new IllegalArgumentException(string + " cannot be negative but was: " + n);
        }
        return n;
    }

    static void checkRemove(boolean bl) {
        Preconditions.checkState(bl, "no calls to next() since the last call to remove()");
    }
}


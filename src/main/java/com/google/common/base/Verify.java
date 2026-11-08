/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.VerifyException;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
public class Verify {
    public static void verify(boolean bl) {
        if (!bl) {
            throw new VerifyException();
        }
    }

    public static void verify(boolean bl, @Nullable String string, Object ... objectArray) {
        if (!bl) {
            throw new VerifyException(Preconditions.format(string, objectArray));
        }
    }

    public static <T> T verifyNotNull(@Nullable T t) {
        return Verify.verifyNotNull(t, "expected a non-null reference", new Object[0]);
    }

    public static <T> T verifyNotNull(@Nullable T t, @Nullable String string, Object ... objectArray) {
        Verify.verify(t != null, string, objectArray);
        return t;
    }

    private Verify() {
    }
}


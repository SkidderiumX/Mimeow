/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.CharMatcher;
import com.google.common.base.Enums;
import com.google.common.base.Optional;
import java.lang.ref.WeakReference;

@GwtCompatible(emulated=true)
public class Platform {
    private Platform() {
    }

    static long systemNanoTime() {
        return System.nanoTime();
    }

    static CharMatcher precomputeCharMatcher(CharMatcher charMatcher) {
        return charMatcher.precomputedInternal();
    }

    static <T extends Enum<T>> Optional<T> getEnumIfPresent(Class<T> clazz, String string) {
        WeakReference<Enum<?>> weakReference = Enums.getEnumConstants(clazz).get(string);
        return weakReference == null ? Optional.absent() : Optional.of(clazz.cast(weakReference.get()));
    }
}


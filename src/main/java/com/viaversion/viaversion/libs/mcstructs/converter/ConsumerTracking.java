/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.converter;

import java.util.function.Consumer;
import javax.annotation.Nullable;

public interface ConsumerTracking {
    @Nullable
    default public Consumer<String> currentConsumer() {
        return null;
    }

    default public void setCurrentConsumer(Consumer<String> consumer) {
    }

    default public ConsumerTracking forkIfDefault() {
        return this;
    }
}


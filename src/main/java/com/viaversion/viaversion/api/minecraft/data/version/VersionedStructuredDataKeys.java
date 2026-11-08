/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.data.version;

import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.libs.fastutil.objects.ReferenceArraySet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class VersionedStructuredDataKeys {
    private final List<StructuredDataKey<?>> keys = new ArrayList();
    protected final Set<StructuredDataKey<?>> unsupportedForOps = new ReferenceArraySet();

    protected <T> StructuredDataKey<T> add(String string, Type<T> type) {
        StructuredDataKey<T> structuredDataKey = new StructuredDataKey<T>(string, type);
        this.keys.add(structuredDataKey);
        return structuredDataKey;
    }

    public List<StructuredDataKey<?>> keys() {
        return this.keys;
    }

    public boolean supportsOps(StructuredDataKey<?> structuredDataKey) {
        return !this.unsupportedForOps.contains(structuredDataKey);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.protocol.version;

import com.google.common.base.Preconditions;

public record SubVersionRange(String baseVersion, int rangeFrom, int rangeTo) {
    public SubVersionRange {
        Preconditions.checkNotNull(string);
        Preconditions.checkArgument(n >= 0);
        Preconditions.checkArgument(n2 > n);
    }
}


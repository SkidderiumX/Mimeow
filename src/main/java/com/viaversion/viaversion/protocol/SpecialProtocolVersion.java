/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocol;

import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.protocol.version.SubVersionRange;
import com.viaversion.viaversion.api.protocol.version.VersionType;
import java.util.Comparator;
import org.checkerframework.checker.nullness.qual.Nullable;

public class SpecialProtocolVersion
extends ProtocolVersion {
    private final ProtocolVersion delegate;

    public SpecialProtocolVersion(int n, String string, ProtocolVersion protocolVersion) {
        this(n, -1, string, null, protocolVersion);
    }

    public SpecialProtocolVersion(int n, int n2, String string, @Nullable SubVersionRange subVersionRange, ProtocolVersion protocolVersion) {
        super(VersionType.SPECIAL, n, n2, string, subVersionRange);
        this.delegate = protocolVersion;
    }

    @Override
    protected @Nullable Comparator<ProtocolVersion> customComparator() {
        return (protocolVersion, protocolVersion2) -> {
            if (protocolVersion == this) {
                protocolVersion = this.delegate;
            }
            if (protocolVersion2 == this) {
                protocolVersion2 = this.delegate;
            }
            return protocolVersion.compareTo((ProtocolVersion)protocolVersion2);
        };
    }

    public ProtocolVersion getDelegate() {
        return this.delegate;
    }

    public @Nullable ProtocolVersion getBaseProtocolVersion() {
        return this.delegate;
    }
}


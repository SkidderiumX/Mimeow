/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocol;

import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.protocol.version.ServerProtocolVersion;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectLinkedOpenHashSet;
import java.util.SortedSet;

public record ServerProtocolVersionSingleton(ProtocolVersion protocolVersion) implements ServerProtocolVersion
{
    @Override
    public ProtocolVersion lowestSupportedProtocolVersion() {
        return this.protocolVersion;
    }

    @Override
    public ProtocolVersion highestSupportedProtocolVersion() {
        return this.protocolVersion;
    }

    @Override
    public SortedSet<ProtocolVersion> supportedProtocolVersions() {
        ObjectLinkedOpenHashSet<ProtocolVersion> objectLinkedOpenHashSet = new ObjectLinkedOpenHashSet<ProtocolVersion>();
        objectLinkedOpenHashSet.add(this.protocolVersion);
        return objectLinkedOpenHashSet;
    }
}


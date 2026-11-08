/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocol;

import com.viaversion.viaversion.api.protocol.version.BlockedProtocolVersions;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import java.util.Set;

public record BlockedProtocolVersionsImpl(Set<ProtocolVersion> singleBlockedVersions, ProtocolVersion blocksBelow, ProtocolVersion blocksAbove) implements BlockedProtocolVersions
{
    @Override
    public boolean contains(ProtocolVersion protocolVersion) {
        return this.blocksBelow.isKnown() && protocolVersion.olderThan(this.blocksBelow) || this.blocksAbove.isKnown() && protocolVersion.newerThan(this.blocksAbove) || this.singleBlockedVersions.contains(protocolVersion);
    }
}


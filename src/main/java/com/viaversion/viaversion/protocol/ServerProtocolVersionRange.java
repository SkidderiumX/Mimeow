/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocol;

import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.protocol.version.ServerProtocolVersion;
import java.util.SortedSet;

public record ServerProtocolVersionRange(ProtocolVersion lowestSupportedProtocolVersion, ProtocolVersion highestSupportedProtocolVersion, SortedSet<ProtocolVersion> supportedProtocolVersions) implements ServerProtocolVersion
{
}


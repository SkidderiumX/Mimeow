/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocol.shared_registration;

import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.protocol.shared_registration.SharedRegistrations;

public record VersionedTemplateGroup(SharedRegistrations.RegistrationAction<?, ?> action, ProtocolVersion min, ProtocolVersion max) {
    public boolean contains(ProtocolVersion protocolVersion) {
        return protocolVersion.newerThanOrEqualTo(this.min) && (this.max == null || protocolVersion.olderThan(this.max));
    }
}


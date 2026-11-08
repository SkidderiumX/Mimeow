/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocol.shared_registration;

import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.ServerboundPacketType;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.protocol.version.VersionType;
import com.viaversion.viaversion.protocol.shared_registration.RegistrationBuilder;
import com.viaversion.viaversion.protocol.shared_registration.RegistrationContext;
import com.viaversion.viaversion.protocol.shared_registration.VersionedTemplateGroup;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;

public class SharedRegistrations {
    private static final SharedRegistrations DEFAULT_REGISTRATIONS = new SharedRegistrations();
    private final EnumMap<VersionType, List<VersionedTemplateGroup>> versionedTemplates = new EnumMap(VersionType.class);

    public static SharedRegistrations defaultRegistrations() {
        return DEFAULT_REGISTRATIONS;
    }

    public static SharedRegistrations create() {
        return new SharedRegistrations();
    }

    public RegistrationBuilder registrations() {
        return new RegistrationBuilder(this);
    }

    public void applyMatching(AbstractProtocol<?, ?, ?, ?> abstractProtocol) {
        if (abstractProtocol.isBaseProtocol()) {
            return;
        }
        ProtocolVersion protocolVersion = abstractProtocol.getServerVersion();
        if (protocolVersion.getVersionType() != abstractProtocol.getClientVersion().getVersionType()) {
            return;
        }
        List<VersionedTemplateGroup> list = this.versionedTemplates.get((Object)protocolVersion.getVersionType());
        if (list == null) {
            return;
        }
        for (VersionedTemplateGroup versionedTemplateGroup : list) {
            if (versionedTemplateGroup.min().newerThan(protocolVersion)) break;
            if (versionedTemplateGroup.max() != null && protocolVersion.newerThanOrEqualTo(versionedTemplateGroup.max())) continue;
            RegistrationContext registrationContext = new RegistrationContext(abstractProtocol, versionedTemplateGroup.min(), versionedTemplateGroup.max());
            versionedTemplateGroup.action().accept(registrationContext);
        }
    }

    void register(VersionType versionType2, List<VersionedTemplateGroup> list) {
        List list2 = this.versionedTemplates.computeIfAbsent(versionType2, versionType -> new ArrayList());
        list2.addAll(list);
        list2.sort(Comparator.comparing(VersionedTemplateGroup::min, Comparator.nullsFirst(Comparator.naturalOrder())));
    }

    @FunctionalInterface
    public static interface RegistrationAction<CU extends ClientboundPacketType, SU extends ServerboundPacketType> {
        public void accept(RegistrationContext<CU, SU> var1);
    }
}


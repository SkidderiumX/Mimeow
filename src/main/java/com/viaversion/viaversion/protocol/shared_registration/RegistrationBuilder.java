/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocol.shared_registration;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.ServerboundPacketType;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.protocol.version.VersionType;
import com.viaversion.viaversion.protocol.shared_registration.RegistrationContext;
import com.viaversion.viaversion.protocol.shared_registration.SharedRegistrations;
import com.viaversion.viaversion.protocol.shared_registration.VersionedTemplateGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class RegistrationBuilder {
    private final List<VersionedTemplateGroup> groups = new ArrayList<VersionedTemplateGroup>();
    private final SharedRegistrations registrations;
    private VersionType versionType;

    RegistrationBuilder(SharedRegistrations sharedRegistrations) {
        this.registrations = sharedRegistrations;
    }

    public RegistrationBuilder since(ProtocolVersion protocolVersion, SharedRegistrations.RegistrationAction<?, ?> registrationAction) {
        this.checkVersionType(protocolVersion);
        this.groups.add(new VersionedTemplateGroup(registrationAction, protocolVersion, null));
        return this;
    }

    public RegistrationBuilder range(ProtocolVersion protocolVersion, ProtocolVersion protocolVersion2, SharedRegistrations.RegistrationAction<?, ?> registrationAction) {
        this.checkVersionType(protocolVersion);
        this.checkVersionType(protocolVersion2);
        this.groups.add(new VersionedTemplateGroup(registrationAction, protocolVersion, protocolVersion2));
        return this;
    }

    public <CU extends ClientboundPacketType, SU extends ServerboundPacketType> RegistrationBuilder ranges(ProtocolVersion protocolVersion, Consumer<RangesBuilder<CU, SU>> consumer) {
        consumer.accept(new RangesBuilder(protocolVersion));
        return this;
    }

    public <CU extends ClientboundPacketType, SU extends ServerboundPacketType, R> RegistrationBuilder ranges(Function<RegistrationContext<CU, SU>, R> function, ProtocolVersion protocolVersion, Consumer<TypedRangesBuilder<CU, SU, R>> consumer) {
        consumer.accept(new TypedRangesBuilder<CU, SU, R>(function, protocolVersion));
        return this;
    }

    public void register() {
        this.registrations.register(this.versionType, this.groups);
    }

    private void checkVersionType(ProtocolVersion protocolVersion) {
        if (this.versionType == null) {
            this.versionType = protocolVersion.getVersionType();
        } else if (this.versionType != protocolVersion.getVersionType()) {
            throw new IllegalArgumentException("Cannot mix different version types in the same registration builder");
        }
    }

    public class RangesBuilder<CU extends ClientboundPacketType, SU extends ServerboundPacketType> {
        private ProtocolVersion currentMin;
        private boolean completed;

        private RangesBuilder(ProtocolVersion protocolVersion) {
            this.currentMin = protocolVersion;
        }

        public RangesBuilder<CU, SU> m38fe5599bf(ProtocolVersion protocolVersion, SharedRegistrations.RegistrationAction<CU, SU> registrationAction) {
            Preconditions.checkState(!this.completed, "Range chain already completed");
            RegistrationBuilder.this.range(this.currentMin, protocolVersion, registrationAction);
            this.currentMin = protocolVersion;
            return this;
        }

        public RegistrationBuilder since(SharedRegistrations.RegistrationAction<CU, SU> registrationAction) {
            Preconditions.checkState(!this.completed, "Range chain already completed");
            this.completed = true;
            return RegistrationBuilder.this.since(this.currentMin, registrationAction);
        }
    }

    public final class TypedRangesBuilder<CU extends ClientboundPacketType, SU extends ServerboundPacketType, R>
    extends RangesBuilder<CU, SU> {
        private final Function<RegistrationContext<CU, SU>, R> adapter;

        private TypedRangesBuilder(Function<RegistrationContext<CU, SU>, R> function, ProtocolVersion protocolVersion) {
            super(protocolVersion);
            this.adapter = function;
        }

        public TypedRangesBuilder<CU, SU, R> mf353e93580(ProtocolVersion protocolVersion, TypedRegistrationAction<CU, SU, R> typedRegistrationAction) {
            this.to(protocolVersion, this.wrapAction(typedRegistrationAction));
            return this;
        }

        public TypedRangesBuilder<CU, SU, R> since(TypedRegistrationAction<CU, SU, R> typedRegistrationAction) {
            this.since(this.wrapAction(typedRegistrationAction));
            return this;
        }

        private SharedRegistrations.RegistrationAction<CU, SU> wrapAction(TypedRegistrationAction<CU, SU, R> typedRegistrationAction) {
            return registrationContext -> {
                R r = this.adapter.apply(registrationContext);
                if (r != null) {
                    typedRegistrationAction.accept(registrationContext, r);
                }
            };
        }
    }

    @FunctionalInterface
    public static interface TypedRegistrationAction<CU extends ClientboundPacketType, SU extends ServerboundPacketType, R> {
        public void accept(RegistrationContext<CU, SU> var1, R var2);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.api;

import com.viaversion.viabackwards.api.data.BackwardsMappingData;
import com.viaversion.viabackwards.api.rewriters.BackwardsRegistryRewriter;
import com.viaversion.viabackwards.protocol.registration.BackwardsRegistrations;
import com.viaversion.viabackwards.utils.BackwardsProtocolLogger;
import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.ServerboundPacketType;
import com.viaversion.viaversion.util.ProtocolLogger;
import org.checkerframework.checker.nullness.qual.Nullable;

public abstract class BackwardsProtocol<CU extends ClientboundPacketType, CM extends ClientboundPacketType, SM extends ServerboundPacketType, SU extends ServerboundPacketType>
extends AbstractProtocol<CU, CM, SM, SU> {
    @Deprecated
    protected BackwardsProtocol() {
    }

    protected BackwardsProtocol(@Nullable Class<CU> clazz, @Nullable Class<CM> clazz2, @Nullable Class<SM> clazz3, @Nullable Class<SU> clazz4) {
        super(clazz, clazz2, clazz3, clazz4);
    }

    @Override
    protected void applySharedRegistrations() {
        super.applySharedRegistrations();
        BackwardsRegistrations.registrations().applyMatching(this);
    }

    @Override
    protected ProtocolLogger createLogger() {
        return new BackwardsProtocolLogger(this.getClass());
    }

    @Override
    public @Nullable Class<? extends Protocol<?, ?, ?, ?>> dependsOn() {
        return this.getMappingData() != null ? this.getMappingData().getViaVersionProtocolClass() : null;
    }

    @Override
    public @Nullable BackwardsMappingData getMappingData() {
        return null;
    }

    @Override
    public @Nullable BackwardsRegistryRewriter getRegistryDataRewriter() {
        return null;
    }
}


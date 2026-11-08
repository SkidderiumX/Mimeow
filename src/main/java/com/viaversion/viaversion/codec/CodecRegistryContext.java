/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.codec;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.codec.CodecContext;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.item.data.DamageType;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.types.version.VersionedTypesHolder;
import com.viaversion.viaversion.libs.fastutil.objects.ReferenceOpenHashSet;
import java.util.List;
import java.util.Set;

public record CodecRegistryContext(Protocol<?, ?, ?, ?> protocol, CodecContext.RegistryAccess registryAccess, boolean mapped) implements CodecContext
{
    private static final Set<StructuredDataKey<?>> NOT_IMPLEMENTED = new ReferenceOpenHashSet<StructuredDataKey<DamageType>>(List.of(StructuredDataKey.DAMAGE_TYPE1_21_11));

    public CodecRegistryContext(Protocol<?, ?, ?, ?> protocol, CodecContext.RegistryAccess registryAccess, boolean bl) {
        this.protocol = protocol;
        this.registryAccess = registryAccess.withMapped(bl);
        this.mapped = bl;
    }

    @Override
    public boolean isSupported(StructuredDataKey<?> structuredDataKey) {
        if (this.protocol == null) {
            return !NOT_IMPLEMENTED.contains(structuredDataKey);
        }
        VersionedTypesHolder versionedTypesHolder = this.mapped ? this.protocol.mappedTypes() : this.protocol.types();
        return (NOT_IMPLEMENTED.isEmpty() || !NOT_IMPLEMENTED.contains(structuredDataKey)) && versionedTypesHolder.structuredDataKeys().supportsOps(structuredDataKey);
    }

    @Override
    public UserConnection connection() {
        return this.registryAccess.connection();
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.codec;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.FullMappings;
import com.viaversion.viaversion.api.data.MappingData;
import com.viaversion.viaversion.api.data.entity.EntityTracker;
import com.viaversion.viaversion.api.minecraft.codec.CodecContext;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.KeyMappings;
import org.checkerframework.checker.nullness.qual.Nullable;

public class RegistryAccessImpl
implements CodecContext.RegistryAccess {
    private final EntityTracker entityTracker;
    private final MappingData mappingData;
    private final UserConnection connection;
    private final boolean mapped;

    RegistryAccessImpl(Protocol<?, ?, ?, ?> protocol, UserConnection userConnection) {
        this.mappingData = Preconditions.checkNotNull(protocol.getMappingData(), "No mapping data present for protocol");
        this.entityTracker = (EntityTracker)Preconditions.checkNotNull(protocol.getEntityRewriter().tracker(userConnection), "Entity tracker has to be added first");
        this.connection = userConnection;
        this.mapped = false;
    }

    private RegistryAccessImpl(MappingData mappingData, UserConnection userConnection, EntityTracker entityTracker, boolean bl) {
        this.mappingData = mappingData;
        this.connection = userConnection;
        this.entityTracker = entityTracker;
        this.mapped = bl;
    }

    @Override
    public UserConnection connection() {
        return this.connection;
    }

    @Override
    public Key item(int n) {
        return this.key(this.mappingData.getFullItemMappings(), n);
    }

    @Override
    public Key attributeModifier(int n) {
        return this.key(this.mappingData.getAttributeMappings(), n);
    }

    @Override
    public Key dataComponentType(int n) {
        return this.key(this.mappingData.getDataComponentSerializerMappings(), n);
    }

    @Override
    public Key entity(int n) {
        return this.key(this.mappingData.getEntityMappings(), n);
    }

    @Override
    public Key blockEntity(int n) {
        return this.key(this.mappingData.getBlockEntityMappings(), n);
    }

    @Override
    public Key sound(int n) {
        return this.key(this.mappingData.getFullSoundMappings(), n);
    }

    @Override
    public Key key(MappingData.MappingType mappingType, int n) {
        return this.key(this.mappingData.getFullMappings(mappingType), n);
    }

    @Override
    public int id(MappingData.MappingType mappingType, String string) {
        FullMappings fullMappings = this.mappingData.getFullMappings(mappingType);
        return this.mapped ? fullMappings.mappedId(string) : fullMappings.id(string);
    }

    @Override
    public Key registryKey(String string, int n) {
        KeyMappings keyMappings = this.entityTracker.registryKeys(string);
        Preconditions.checkNotNull(keyMappings, "No registry mappings for registry: %s", string);
        return this.keyOrUnknown(keyMappings.key(n), n);
    }

    private Key key(FullMappings fullMappings, int n) {
        Key key = this.mapped ? fullMappings.mappedKeyFromMappedId(n) : fullMappings.keyFromId(n);
        return this.keyOrUnknown(key, n);
    }

    private Key keyOrUnknown(@Nullable Key key, int n) {
        return key != null ? key : Key.of("viaversion", "unknown/" + n);
    }

    @Override
    public CodecContext.RegistryAccess withMapped(boolean bl) {
        return this.mapped == bl ? this : new RegistryAccessImpl(this.mappingData, this.connection, this.entityTracker, bl);
    }
}


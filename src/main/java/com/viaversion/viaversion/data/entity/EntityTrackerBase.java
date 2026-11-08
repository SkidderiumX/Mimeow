/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.data.entity;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.entity.ClientEntityIdChangeListener;
import com.viaversion.viaversion.api.data.entity.DimensionData;
import com.viaversion.viaversion.api.data.entity.EntityTracker;
import com.viaversion.viaversion.api.data.entity.TrackedEntity;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.data.entity.TrackedEntityImpl;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectOpenHashMap;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.KeyMappings;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.Nullable;

public class EntityTrackerBase
implements EntityTracker,
ClientEntityIdChangeListener {
    protected final Int2ObjectMap<TrackedEntity> entities = new Int2ObjectOpenHashMap<TrackedEntity>();
    private final Map<String, KeyMappings> registryKeyMappings = new HashMap<String, KeyMappings>();
    private final UserConnection connection;
    private final EntityType playerType;
    private Integer clientEntityId;
    private int currentWorldSectionHeight = -1;
    private int currentMinY;
    private String currentWorld;
    private int currentDimensionId = -1;
    private int biomesSent = -1;
    private Map<String, DimensionData> dimensions = Collections.emptyMap();
    private boolean instaBuild;
    private Type<Chunk> chunkType;
    private Type<Chunk> mappedChunkType;

    public EntityTrackerBase(UserConnection userConnection, @Nullable EntityType entityType) {
        this.connection = userConnection;
        this.playerType = entityType;
    }

    @Override
    public UserConnection user() {
        return this.connection;
    }

    @Override
    public TrackedEntity addEntity(int n, EntityType entityType) {
        TrackedEntityImpl trackedEntityImpl = new TrackedEntityImpl(entityType);
        this.entities.put(n, (TrackedEntity)trackedEntityImpl);
        return trackedEntityImpl;
    }

    @Override
    public boolean hasEntity(int n) {
        return this.entities.containsKey(n);
    }

    @Override
    public @Nullable TrackedEntity entity(int n) {
        return (TrackedEntity)this.entities.get(n);
    }

    @Override
    public @Nullable EntityType entityType(int n) {
        TrackedEntity trackedEntity = (TrackedEntity)this.entities.get(n);
        return trackedEntity != null ? trackedEntity.entityType() : null;
    }

    @Override
    public TrackedEntity removeEntity(int n) {
        return (TrackedEntity)this.entities.remove(n);
    }

    @Override
    public void clearEntities() {
        for (int n : this.entities.keySet().toIntArray()) {
            this.removeEntity(n);
        }
        if (this.clientEntityId != null) {
            this.entities.put((int)this.clientEntityId, (TrackedEntity)new TrackedEntityImpl(this.playerType));
        }
    }

    @Override
    public void clear() {
        for (int n : this.entities.keySet().toIntArray()) {
            this.removeEntity(n);
        }
        this.clientEntityId = null;
        this.registryKeyMappings.clear();
    }

    @Override
    public boolean hasClientEntityId() {
        return this.clientEntityId != null;
    }

    @Override
    public int clientEntityId() throws IllegalStateException {
        if (this.clientEntityId == null) {
            throw new IllegalStateException("Client entity id not set");
        }
        return this.clientEntityId;
    }

    @Override
    public void setClientEntityId(int n) {
        TrackedEntity trackedEntity;
        Preconditions.checkNotNull(this.playerType);
        if (this.clientEntityId != null && (trackedEntity = (TrackedEntity)this.entities.remove(this.clientEntityId)) != null) {
            this.entities.put(n, trackedEntity);
        } else {
            this.entities.put(n, (TrackedEntity)new TrackedEntityImpl(this.playerType));
        }
        this.clientEntityId = n;
    }

    @Override
    public boolean canInstaBuild() {
        return this.instaBuild;
    }

    @Override
    public void setInstaBuild(boolean bl) {
        this.instaBuild = bl;
    }

    @Override
    public int currentWorldSectionHeight() {
        return this.currentWorldSectionHeight;
    }

    @Override
    public void setCurrentWorldSectionHeight(int n) {
        if (this.currentWorldSectionHeight != n) {
            this.chunkType = null;
            this.mappedChunkType = null;
        }
        this.currentWorldSectionHeight = n;
    }

    @Override
    public int currentMinY() {
        return this.currentMinY;
    }

    @Override
    public void setCurrentMinY(int n) {
        this.currentMinY = n;
    }

    @Override
    public @Nullable String currentWorld() {
        return this.currentWorld;
    }

    @Override
    public void setCurrentWorld(String string) {
        this.currentWorld = string;
    }

    @Override
    public int currentDimensionId() {
        return this.currentDimensionId;
    }

    @Override
    public void setCurrentDimensionId(int n) {
        this.currentDimensionId = n;
    }

    @Override
    public int biomesSent() {
        return this.biomesSent;
    }

    @Override
    public void setBiomesSent(int n) {
        if (this.biomesSent != n) {
            this.chunkType = null;
            this.mappedChunkType = null;
        }
        this.biomesSent = n;
    }

    @Override
    public @Nullable Type<Chunk> chunkType(boolean bl) {
        return bl ? this.mappedChunkType : this.chunkType;
    }

    @Override
    public void setChunkType(boolean bl, @Nullable Type<Chunk> type) {
        if (bl) {
            this.mappedChunkType = type;
        } else {
            this.chunkType = type;
        }
    }

    @Override
    public EntityType playerType() {
        return this.playerType;
    }

    @Override
    public @Nullable DimensionData dimensionData(String string) {
        return this.dimensions.get(Key.stripMinecraftNamespace(string));
    }

    @Override
    public @Nullable DimensionData dimensionData(int n) {
        return this.dimensions.values().stream().filter(dimensionData -> dimensionData.id() == n).findFirst().orElse(null);
    }

    @Override
    public void setDimensions(Map<String, DimensionData> map) {
        this.dimensions = map;
    }

    @Override
    public @Nullable KeyMappings registryKeys(String string) {
        return this.registryKeyMappings.get(Key.stripMinecraftNamespace(string));
    }

    @Override
    public void addRegistryKeys(String string, KeyMappings keyMappings) {
        this.registryKeyMappings.put(Key.stripMinecraftNamespace(string), keyMappings);
    }
}


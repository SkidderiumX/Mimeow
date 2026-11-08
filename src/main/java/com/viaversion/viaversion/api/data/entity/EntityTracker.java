/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.data.entity;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.entity.DimensionData;
import com.viaversion.viaversion.api.data.entity.TrackedEntity;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.util.KeyMappings;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.Nullable;

public interface EntityTracker {
    @Deprecated
    public UserConnection user();

    public TrackedEntity addEntity(int var1, EntityType var2);

    public boolean hasEntity(int var1);

    public @Nullable TrackedEntity entity(int var1);

    public @Nullable EntityType entityType(int var1);

    public @Nullable TrackedEntity removeEntity(int var1);

    public void clearEntities();

    public void clear();

    public boolean hasClientEntityId();

    public int clientEntityId() throws IllegalStateException;

    public void setClientEntityId(int var1);

    public boolean canInstaBuild();

    public void setInstaBuild(boolean var1);

    public int currentWorldSectionHeight();

    public void setCurrentWorldSectionHeight(int var1);

    public int currentMinY();

    public void setCurrentMinY(int var1);

    public @Nullable String currentWorld();

    public void setCurrentWorld(String var1);

    public int currentDimensionId();

    public void setCurrentDimensionId(int var1);

    public int biomesSent();

    public void setBiomesSent(int var1);

    public @Nullable Type<Chunk> chunkType(boolean var1);

    public void setChunkType(boolean var1, @Nullable Type<Chunk> var2);

    public EntityType playerType();

    public @Nullable DimensionData dimensionData(String var1);

    public @Nullable DimensionData dimensionData(int var1);

    public void setDimensions(Map<String, DimensionData> var1);

    public @Nullable KeyMappings registryKeys(String var1);

    public void addRegistryKeys(String var1, KeyMappings var2);
}


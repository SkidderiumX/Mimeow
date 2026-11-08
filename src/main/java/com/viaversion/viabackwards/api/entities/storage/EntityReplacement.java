/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.api.entities.storage;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.data.BackwardsMappingData;
import com.viaversion.viabackwards.api.entities.storage.WrappedEntityData;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.util.ComponentUtil;
import java.util.Locale;
import org.checkerframework.checker.nullness.qual.Nullable;

public class EntityReplacement {
    private final BackwardsProtocol<?, ?, ?, ?> protocol;
    private final int id;
    private final int replacementId;
    private final String key;
    private final String translateKey;
    private final String fallbackName;
    private ComponentType componentType = ComponentType.NONE;
    private EntityDataCreator defaultData;

    public EntityReplacement(BackwardsProtocol<?, ?, ?, ?> backwardsProtocol, EntityType entityType, int n) {
        this(backwardsProtocol, entityType.name().toLowerCase(Locale.ROOT), entityType.getId(), n);
    }

    public EntityReplacement(BackwardsProtocol<?, ?, ?, ?> backwardsProtocol, String string, int n, int n2) {
        this.protocol = backwardsProtocol;
        this.id = n;
        this.replacementId = n2;
        this.key = string;
        this.translateKey = "vb.entity." + string;
        this.fallbackName = BackwardsMappingData.nameFromIdentifier(this.key);
    }

    public EntityReplacement jsonName() {
        this.componentType = ComponentType.JSON;
        return this;
    }

    public EntityReplacement tagName() {
        this.componentType = ComponentType.TAG;
        return this;
    }

    public EntityReplacement plainName() {
        this.componentType = ComponentType.PLAIN;
        return this;
    }

    public EntityReplacement spawnEntityData(EntityDataCreator entityDataCreator) {
        this.defaultData = entityDataCreator;
        return this;
    }

    public boolean hasBaseData() {
        return this.defaultData != null;
    }

    public int typeId() {
        return this.id;
    }

    public @Nullable Object entityName() {
        if (this.componentType == ComponentType.NONE) {
            return null;
        }
        if (this.componentType == ComponentType.JSON) {
            return ComponentUtil.plainToJson(this.fallbackName);
        }
        if (this.componentType == ComponentType.TAG) {
            CompoundTag compoundTag = new CompoundTag();
            compoundTag.putString("color", "white");
            compoundTag.putString("translate", this.translateKey);
            compoundTag.putString("fallback", this.fallbackName);
            compoundTag.putBoolean("italic", false);
            return compoundTag;
        }
        return this.fallbackName;
    }

    public int replacementId() {
        return this.replacementId;
    }

    public @Nullable EntityDataCreator defaultData() {
        return this.defaultData;
    }

    public boolean isObjectType() {
        return false;
    }

    public int objectData() {
        return -1;
    }

    public String toString() {
        return "EntityReplacement{protocol=" + String.valueOf(this.protocol) + ", id=" + this.id + ", replacementId=" + this.replacementId + ", key='" + this.key + "', componentType=" + String.valueOf((Object)this.componentType) + ", defaultData=" + String.valueOf(this.defaultData) + "}";
    }

    private static enum ComponentType {
        PLAIN,
        JSON,
        TAG,
        NONE;

    }

    @FunctionalInterface
    public static interface EntityDataCreator {
        public void createData(WrappedEntityData var1);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.util;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.data.FullMappings;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.protocol.Protocol;
import java.util.ArrayList;
import java.util.Comparator;

public class EntityTypeUtil {
    private static final EntityType[] EMPTY_ARRAY = new EntityType[0];

    public static EntityType[] toOrderedArray(EntityType[] entityTypeArray) {
        ArrayList<EntityType> arrayList = new ArrayList<EntityType>();
        for (EntityType entityType : entityTypeArray) {
            if (entityType.getId() == -1) continue;
            arrayList.add(entityType);
        }
        arrayList.sort(Comparator.comparingInt(EntityType::getId));
        return arrayList.toArray(EMPTY_ARRAY);
    }

    public static <T extends EntityType> void initialize(T[] TArray, EntityType[] entityTypeArray, Protocol<?, ?, ?, ?> protocol, EntityIdSetter<T> entityIdSetter) {
        FullMappings fullMappings = protocol.getMappingData().getEntityMappings();
        for (T t : TArray) {
            if (t.isAbstractType()) continue;
            int n = fullMappings.mappedId(t.identifier());
            Preconditions.checkArgument(n != -1, "Entity type %s has no id", t.identifier());
            entityIdSetter.setId(t, n);
            entityTypeArray[n] = t;
        }
        if (entityTypeArray.length != fullMappings.mappedSize()) {
            throw new IllegalArgumentException("typesToFill length doesn't match the amount of entity types: " + entityTypeArray.length + " != " + fullMappings.size());
        }
    }

    public static EntityType[] createSizedArray(EntityType[] entityTypeArray) {
        int n = 0;
        for (EntityType entityType : entityTypeArray) {
            if (entityType.isAbstractType()) continue;
            ++n;
        }
        return new EntityType[n];
    }

    public static EntityType getTypeFromId(EntityType[] entityTypeArray, int n, EntityType entityType) {
        EntityType entityType2;
        if (n < 0 || n >= entityTypeArray.length || (entityType2 = entityTypeArray[n]) == null) {
            Via.getPlatform().getLogger().severe("Could not find " + entityType.getClass().getSimpleName() + " type id " + n);
            return entityType;
        }
        return entityType2;
    }

    @FunctionalInterface
    public static interface EntityIdSetter<T extends EntityType> {
        public void setId(T var1, int var2);
    }
}


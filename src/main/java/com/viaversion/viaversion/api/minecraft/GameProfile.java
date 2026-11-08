/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.Nullable;

public record GameProfile(@Nullable String name, @Nullable UUID id, Property[] properties, boolean dynamic) {
    public GameProfile(@Nullable String string, @Nullable UUID uUID, Property[] propertyArray) {
        this(string, uUID, propertyArray, true);
    }

    public GameProfile(@Nullable String string, @Nullable UUID uUID) {
        this(string, uUID, new Property[0]);
    }

    public Map<String, List<Property>> propertiesMap() {
        HashMap<String, List<Property>> hashMap = new HashMap<String, List<Property>>();
        for (Property property : this.properties) {
            hashMap.computeIfAbsent(property.name(), string -> new ArrayList()).add(property);
        }
        return hashMap;
    }

    public record Property(String name, String value, @Nullable String signature) {
        public Property(String string, String string2) {
            this(string, string2, null);
        }
    }
}


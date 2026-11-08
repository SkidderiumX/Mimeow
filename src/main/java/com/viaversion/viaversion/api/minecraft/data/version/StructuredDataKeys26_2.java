/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.data.version;

import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.data.version.StructuredDataKeys1_21_11;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.type.types.version.VersionedTypesHolder;

public class StructuredDataKeys26_2
extends StructuredDataKeys1_21_11 {
    public final StructuredDataKey<Item> sulfurCubeContent;

    public StructuredDataKeys26_2(VersionedTypesHolder versionedTypesHolder) {
        super(versionedTypesHolder);
        this.sulfurCubeContent = this.add("sulfur_cube_content", versionedTypesHolder.item());
    }
}


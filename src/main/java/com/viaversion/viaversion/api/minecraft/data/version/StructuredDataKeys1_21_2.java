/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.data.version;

import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.data.version.VersionedStructuredDataKeys;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.data.ContainterContents;
import com.viaversion.viaversion.api.type.types.version.VersionedTypesHolder;

public class StructuredDataKeys1_21_2
extends VersionedStructuredDataKeys {
    public final StructuredDataKey<Item[]> container;
    public final StructuredDataKey<Item[]> chargedProjectiles;
    public final StructuredDataKey<Item[]> bundleContents;
    public final StructuredDataKey<Item> useRemainder;

    public StructuredDataKeys1_21_2(VersionedTypesHolder versionedTypesHolder) {
        this.container = this.add("container", new ContainterContents.ContainerContentsType(versionedTypesHolder.optionalItemTemplate()));
        this.chargedProjectiles = this.add("charged_projectiles", versionedTypesHolder.itemTemplateArray().withMaxLength(1024));
        this.bundleContents = this.add("bundle_contents", versionedTypesHolder.itemTemplateArray().withMaxLength(1024));
        this.useRemainder = this.add("use_remainder", versionedTypesHolder.itemTemplate());
    }
}


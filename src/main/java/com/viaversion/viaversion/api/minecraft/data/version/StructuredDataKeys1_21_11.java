/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.data.version;

import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.data.predicate.DataComponentPredicate;
import com.viaversion.viaversion.api.minecraft.data.version.StructuredDataKeys1_21_2;
import com.viaversion.viaversion.api.minecraft.item.data.AdventureModePredicate;
import com.viaversion.viaversion.api.type.types.version.VersionedTypesHolder;

public class StructuredDataKeys1_21_11
extends StructuredDataKeys1_21_2 {
    public final StructuredDataKey<AdventureModePredicate> canPlaceOn;
    public final StructuredDataKey<AdventureModePredicate> canBreak;

    public StructuredDataKeys1_21_11(VersionedTypesHolder versionedTypesHolder) {
        super(versionedTypesHolder);
        AdventureModePredicate.AdventureModePredicateType1_21_5 adventureModePredicateType1_21_5 = new AdventureModePredicate.AdventureModePredicateType1_21_5(versionedTypesHolder.structuredDataArray(), DataComponentPredicate.ARRAY_TYPE1_21_11);
        this.canPlaceOn = this.add("can_place_on", adventureModePredicateType1_21_5);
        this.canBreak = this.add("can_break", adventureModePredicateType1_21_5);
        this.unsupportedForOps.add(this.canPlaceOn);
        this.unsupportedForOps.add(this.canBreak);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v26_1to26_2.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.protocols.v26_1to26_2.Protocol26_1To26_2;
import com.viaversion.viaversion.rewriter.RegistryDataRewriter;
import com.viaversion.viaversion.util.Key;

public class RegistryDataRewriter26_2
extends RegistryDataRewriter {
    public RegistryDataRewriter26_2(Protocol26_1To26_2 protocol26_1To26_2) {
        super(protocol26_1To26_2);
    }

    @Override
    public void updateEnchantmentTerm(CompoundTag compoundTag) {
        CompoundTag compoundTag2;
        super.updateEnchantmentTerm(compoundTag);
        String string = compoundTag.getString("condition");
        if (Key.equals(string, "entity_properties")) {
            CompoundTag compoundTag3 = compoundTag.getCompoundTag("predicate");
            if (compoundTag3 != null) {
                this.updateEntityPredicate(compoundTag3);
            }
        } else if (Key.equals(string, "damage_source_properties") && (compoundTag2 = compoundTag.getCompoundTag("predicate")) != null) {
            this.updateNestedEntityPredicate(compoundTag2, "source_entity");
            this.updateNestedEntityPredicate(compoundTag2, "direct_entity");
        }
    }

    private void updateEntityPredicate(CompoundTag compoundTag) {
        Tag tag;
        CompoundTag compoundTag2 = (CompoundTag)compoundTag.removeUnchecked("type_specific");
        if (compoundTag2 != null) {
            this.updateTypeSpecificTerm(compoundTag, compoundTag2);
        }
        if ((tag = compoundTag.remove("type")) != null) {
            compoundTag.put("entity_type", tag);
        }
        this.updateNestedEntityPredicate(compoundTag, "vehicle");
        this.updateNestedEntityPredicate(compoundTag, "passenger");
        this.updateNestedEntityPredicate(compoundTag, "targeted_entity");
    }

    private void updateNestedEntityPredicate(CompoundTag compoundTag, String string) {
        CompoundTag compoundTag2 = compoundTag.getCompoundTag(string);
        if (compoundTag2 != null) {
            this.updateEntityPredicate(compoundTag2);
        }
    }

    private void updateTypeSpecificTerm(CompoundTag compoundTag, CompoundTag compoundTag2) {
        String string;
        StringTag stringTag = (StringTag)compoundTag2.removeUnchecked("type");
        if (stringTag == null) {
            return;
        }
        switch (string = Key.stripMinecraftNamespace(stringTag.getValue())) {
            case "player": 
            case "lightning": 
            case "fishing_hook": 
            case "raider": 
            case "sheep": {
                compoundTag.put("type_specific/" + string, compoundTag2);
                break;
            }
            case "slime": {
                compoundTag.put("type_specific/cube_mob", compoundTag2);
            }
        }
    }
}


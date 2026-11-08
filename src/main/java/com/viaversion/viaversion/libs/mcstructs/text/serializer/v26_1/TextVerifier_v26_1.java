/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.serializer.v26_1;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.libs.mcstructs.core.Identifier;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.verify.TextVerifier;

public interface TextVerifier_v26_1
extends TextVerifier {
    default public boolean verifyRegistryItem(Identifier identifier) {
        return true;
    }

    default public boolean verifyRegistryEntity(Identifier identifier) {
        return true;
    }

    default public boolean verifyDataComponents(CompoundTag compoundTag) {
        return true;
    }

    default public boolean verifySelector(String string) {
        return true;
    }

    default public boolean verifyCoordinates(String string) {
        return true;
    }

    default public boolean verifyNbtPath(String string) {
        return true;
    }
}


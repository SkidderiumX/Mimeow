/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.components.nbt;

import com.viaversion.viaversion.libs.mcstructs.core.Identifier;
import com.viaversion.viaversion.libs.mcstructs.core.utils.ToString;
import com.viaversion.viaversion.libs.mcstructs.text.components.nbt.NbtDataSource;
import lombok.Generated;

public class StorageNbtSource
implements NbtDataSource {
    private Identifier id;

    public StorageNbtSource(Identifier identifier) {
        this.id = identifier;
    }

    public Identifier getId() {
        return this.id;
    }

    public StorageNbtSource setId(Identifier identifier) {
        this.id = identifier;
        return this;
    }

    @Override
    public StorageNbtSource copy() {
        return new StorageNbtSource(this.id);
    }

    public String toString() {
        return ToString.of(this).add("id", this.id).toString();
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof StorageNbtSource)) {
            return false;
        }
        StorageNbtSource storageNbtSource = (StorageNbtSource)object;
        if (!storageNbtSource.canEqual(this)) {
            return false;
        }
        Identifier identifier = this.getId();
        Identifier identifier2 = storageNbtSource.getId();
        return !(identifier == null ? identifier2 != null : !((Object)identifier).equals(identifier2));
    }

    @Generated
    protected boolean canEqual(Object object) {
        return object instanceof StorageNbtSource;
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        Identifier identifier = this.getId();
        n2 = n2 * 59 + (identifier == null ? 43 : ((Object)identifier).hashCode());
        return n2;
    }
}


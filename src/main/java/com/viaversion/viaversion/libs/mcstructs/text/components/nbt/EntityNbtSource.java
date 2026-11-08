/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.components.nbt;

import com.viaversion.viaversion.libs.mcstructs.core.utils.ToString;
import com.viaversion.viaversion.libs.mcstructs.text.components.nbt.NbtDataSource;
import lombok.Generated;

public class EntityNbtSource
implements NbtDataSource {
    private String selector;

    public EntityNbtSource(String string) {
        this.selector = string;
    }

    public String getSelector() {
        return this.selector;
    }

    public EntityNbtSource setSelector(String string) {
        this.selector = string;
        return this;
    }

    @Override
    public EntityNbtSource copy() {
        return new EntityNbtSource(this.selector);
    }

    public String toString() {
        return ToString.of(this).add("selector", this.selector).toString();
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof EntityNbtSource)) {
            return false;
        }
        EntityNbtSource entityNbtSource = (EntityNbtSource)object;
        if (!entityNbtSource.canEqual(this)) {
            return false;
        }
        String string = this.getSelector();
        String string2 = entityNbtSource.getSelector();
        return !(string == null ? string2 != null : !string.equals(string2));
    }

    @Generated
    protected boolean canEqual(Object object) {
        return object instanceof EntityNbtSource;
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        String string = this.getSelector();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        return n2;
    }
}


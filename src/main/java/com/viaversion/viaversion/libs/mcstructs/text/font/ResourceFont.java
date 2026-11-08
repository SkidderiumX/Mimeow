/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.font;

import com.viaversion.viaversion.libs.mcstructs.core.Identifier;
import com.viaversion.viaversion.libs.mcstructs.core.utils.ToString;
import com.viaversion.viaversion.libs.mcstructs.text.font.FontDescription;
import lombok.Generated;

public class ResourceFont
implements FontDescription {
    public Identifier id;

    public String toString() {
        return ToString.of(this).add("id", this.id).toString();
    }

    @Generated
    public Identifier getId() {
        return this.id;
    }

    @Generated
    public void setId(Identifier identifier) {
        this.id = identifier;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ResourceFont)) {
            return false;
        }
        ResourceFont resourceFont = (ResourceFont)object;
        if (!resourceFont.canEqual(this)) {
            return false;
        }
        Identifier identifier = this.getId();
        Identifier identifier2 = resourceFont.getId();
        return !(identifier == null ? identifier2 != null : !((Object)identifier).equals(identifier2));
    }

    @Generated
    protected boolean canEqual(Object object) {
        return object instanceof ResourceFont;
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        Identifier identifier = this.getId();
        n2 = n2 * 59 + (identifier == null ? 43 : ((Object)identifier).hashCode());
        return n2;
    }

    @Generated
    public ResourceFont() {
    }

    @Generated
    public ResourceFont(Identifier identifier) {
        this.id = identifier;
    }
}


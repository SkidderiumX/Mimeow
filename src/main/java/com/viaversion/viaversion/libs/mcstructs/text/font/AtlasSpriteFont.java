/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.font;

import com.viaversion.viaversion.libs.mcstructs.core.Identifier;
import com.viaversion.viaversion.libs.mcstructs.core.utils.ToString;
import com.viaversion.viaversion.libs.mcstructs.text.font.FontDescription;
import lombok.Generated;

public class AtlasSpriteFont
implements FontDescription {
    private Identifier atlasId;
    private Identifier spriteId;

    public String toString() {
        return ToString.of(this).add("atlasId", this.atlasId).add("spriteId", this.spriteId).toString();
    }

    @Generated
    public Identifier getAtlasId() {
        return this.atlasId;
    }

    @Generated
    public Identifier getSpriteId() {
        return this.spriteId;
    }

    @Generated
    public void setAtlasId(Identifier identifier) {
        this.atlasId = identifier;
    }

    @Generated
    public void setSpriteId(Identifier identifier) {
        this.spriteId = identifier;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof AtlasSpriteFont)) {
            return false;
        }
        AtlasSpriteFont atlasSpriteFont = (AtlasSpriteFont)object;
        if (!atlasSpriteFont.canEqual(this)) {
            return false;
        }
        Identifier identifier = this.getAtlasId();
        Identifier identifier2 = atlasSpriteFont.getAtlasId();
        if (identifier == null ? identifier2 != null : !((Object)identifier).equals(identifier2)) {
            return false;
        }
        Identifier identifier3 = this.getSpriteId();
        Identifier identifier4 = atlasSpriteFont.getSpriteId();
        return !(identifier3 == null ? identifier4 != null : !((Object)identifier3).equals(identifier4));
    }

    @Generated
    protected boolean canEqual(Object object) {
        return object instanceof AtlasSpriteFont;
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        Identifier identifier = this.getAtlasId();
        n2 = n2 * 59 + (identifier == null ? 43 : ((Object)identifier).hashCode());
        Identifier identifier2 = this.getSpriteId();
        n2 = n2 * 59 + (identifier2 == null ? 43 : ((Object)identifier2).hashCode());
        return n2;
    }

    @Generated
    public AtlasSpriteFont() {
    }

    @Generated
    public AtlasSpriteFont(Identifier identifier, Identifier identifier2) {
        this.atlasId = identifier;
        this.spriteId = identifier2;
    }
}


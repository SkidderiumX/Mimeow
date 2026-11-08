/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.font;

import com.viaversion.viaversion.libs.mcstructs.converter.SerializedData;
import com.viaversion.viaversion.libs.mcstructs.core.utils.ToString;
import com.viaversion.viaversion.libs.mcstructs.text.font.FontDescription;
import lombok.Generated;

public class PlayerSpriteFont
implements FontDescription {
    private SerializedData<?> profile;
    private boolean hat;

    public String toString() {
        return ToString.of(this).add("profile", this.profile).add("hat", this.hat).toString();
    }

    @Generated
    public SerializedData<?> getProfile() {
        return this.profile;
    }

    @Generated
    public boolean isHat() {
        return this.hat;
    }

    @Generated
    public void setProfile(SerializedData<?> serializedData) {
        this.profile = serializedData;
    }

    @Generated
    public void setHat(boolean bl) {
        this.hat = bl;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof PlayerSpriteFont)) {
            return false;
        }
        PlayerSpriteFont playerSpriteFont = (PlayerSpriteFont)object;
        if (!playerSpriteFont.canEqual(this)) {
            return false;
        }
        if (this.isHat() != playerSpriteFont.isHat()) {
            return false;
        }
        SerializedData<?> serializedData = this.getProfile();
        SerializedData<?> serializedData2 = playerSpriteFont.getProfile();
        return !(serializedData == null ? serializedData2 != null : !((Object)serializedData).equals(serializedData2));
    }

    @Generated
    protected boolean canEqual(Object object) {
        return object instanceof PlayerSpriteFont;
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        n2 = n2 * 59 + (this.isHat() ? 79 : 97);
        SerializedData<?> serializedData = this.getProfile();
        n2 = n2 * 59 + (serializedData == null ? 43 : ((Object)serializedData).hashCode());
        return n2;
    }

    @Generated
    public PlayerSpriteFont() {
    }

    @Generated
    public PlayerSpriteFont(SerializedData<?> serializedData, boolean bl) {
        this.profile = serializedData;
        this.hat = bl;
    }
}


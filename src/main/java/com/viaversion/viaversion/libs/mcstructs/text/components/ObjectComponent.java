/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.components;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.libs.mcstructs.converter.SerializedData;
import com.viaversion.viaversion.libs.mcstructs.converter.impl.v1_21_5.NbtConverter_v1_21_5;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Result;
import com.viaversion.viaversion.libs.mcstructs.core.Identifier;
import com.viaversion.viaversion.libs.mcstructs.core.utils.ToString;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.font.AtlasSpriteFont;
import com.viaversion.viaversion.libs.mcstructs.text.font.FontDescription;
import com.viaversion.viaversion.libs.mcstructs.text.font.PlayerSpriteFont;
import java.util.Objects;
import javax.annotation.Nullable;
import lombok.Generated;

public class ObjectComponent
extends TextComponent {
    private ObjectInfo objectInfo;
    @Nullable
    private TextComponent fallback;

    public ObjectComponent(ObjectInfo objectInfo) {
        this(objectInfo, null);
    }

    @Override
    public String asSingleString() {
        return this.objectInfo.getDescription();
    }

    @Override
    public TextComponent shallowCopy() {
        ObjectComponent objectComponent = new ObjectComponent(this.objectInfo, this.fallback == null ? null : this.fallback.copy());
        return objectComponent.setStyle(this.getStyle().copy());
    }

    @Override
    public String toString() {
        return ToString.of(this).put("siblings", this.getSiblings(), list -> !list.isEmpty()).put("style", this.getStyle(), style -> !style.isEmpty()).put("objectInfo", this.objectInfo).put("fallback", this.fallback, Objects::nonNull).toString();
    }

    @Generated
    public ObjectInfo getObjectInfo() {
        return this.objectInfo;
    }

    @Nullable
    @Generated
    public TextComponent getFallback() {
        return this.fallback;
    }

    @Generated
    public void setObjectInfo(ObjectInfo objectInfo) {
        this.objectInfo = objectInfo;
    }

    @Generated
    public void setFallback(@Nullable TextComponent textComponent) {
        this.fallback = textComponent;
    }

    @Generated
    public ObjectComponent(ObjectInfo objectInfo, @Nullable TextComponent textComponent) {
        this.objectInfo = objectInfo;
        this.fallback = textComponent;
    }

    @Override
    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ObjectComponent)) {
            return false;
        }
        ObjectComponent objectComponent = (ObjectComponent)object;
        if (!objectComponent.canEqual(this)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        ObjectInfo objectInfo = this.getObjectInfo();
        ObjectInfo objectInfo2 = objectComponent.getObjectInfo();
        if (objectInfo == null ? objectInfo2 != null : !objectInfo.equals(objectInfo2)) {
            return false;
        }
        TextComponent textComponent = this.getFallback();
        TextComponent textComponent2 = objectComponent.getFallback();
        return !(textComponent == null ? textComponent2 != null : !((Object)textComponent).equals(textComponent2));
    }

    @Override
    @Generated
    protected boolean canEqual(Object object) {
        return object instanceof ObjectComponent;
    }

    @Override
    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = super.hashCode();
        ObjectInfo objectInfo = this.getObjectInfo();
        n2 = n2 * 59 + (objectInfo == null ? 43 : objectInfo.hashCode());
        TextComponent textComponent = this.getFallback();
        n2 = n2 * 59 + (textComponent == null ? 43 : ((Object)textComponent).hashCode());
        return n2;
    }

    public static class PlayerSprite
    implements ObjectInfo {
        private SerializedData<?> profile;
        private boolean hat;

        @Override
        public FontDescription getUpdatedFont() {
            return new PlayerSpriteFont(this.profile, this.hat);
        }

        @Override
        public String getDescription() {
            String string = this.profile.convert(NbtConverter_v1_21_5.INSTANCE).map(tag -> (CompoundTag)tag).mapResult(compoundTag -> {
                String string_r = compoundTag.getString("name", null);
                return string_r == null ? Result.error("No name in profile") : Result.success(string_r);
            }).orElse(null);
            if (string == null) {
                return "[unknown player head]";
            }
            return "[" + string + " head]";
        }

        @Override
        public String toString() {
            return ToString.of(this).put("profile", this.profile).put("hat", this.hat).toString();
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
        public PlayerSprite(SerializedData<?> serializedData, boolean bl) {
            this.profile = serializedData;
            this.hat = bl;
        }

        @Generated
        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof PlayerSprite)) {
                return false;
            }
            PlayerSprite playerSprite = (PlayerSprite)object;
            if (!playerSprite.canEqual(this)) {
                return false;
            }
            if (this.isHat() != playerSprite.isHat()) {
                return false;
            }
            SerializedData<?> serializedData = this.getProfile();
            SerializedData<?> serializedData2 = playerSprite.getProfile();
            return !(serializedData == null ? serializedData2 != null : !((Object)serializedData).equals(serializedData2));
        }

        @Generated
        protected boolean canEqual(Object object) {
            return object instanceof PlayerSprite;
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
    }

    public static class AtlasSprite
    implements ObjectInfo {
        public static final Identifier DEFAULT_ATLAS = Identifier.defaultNamespace("blocks");
        private Identifier atlas;
        private Identifier sprite;

        public AtlasSprite(Identifier identifier) {
            this.atlas = DEFAULT_ATLAS;
            this.sprite = identifier;
        }

        @Override
        public FontDescription getUpdatedFont() {
            return new AtlasSpriteFont(this.atlas, this.sprite);
        }

        @Override
        public String getDescription() {
            String string = Identifier.stripDefaultNamespace(this.sprite);
            if (this.atlas.equals(DEFAULT_ATLAS)) {
                return "[" + string + "]";
            }
            String string2 = Identifier.stripDefaultNamespace(this.atlas);
            return "[" + string2 + "@" + string + "]";
        }

        @Override
        public String toString() {
            return ToString.of(this).put("atlas", this.atlas).put("sprite", this.sprite).toString();
        }

        @Generated
        public Identifier getAtlas() {
            return this.atlas;
        }

        @Generated
        public Identifier getSprite() {
            return this.sprite;
        }

        @Generated
        public void setAtlas(Identifier identifier) {
            this.atlas = identifier;
        }

        @Generated
        public void setSprite(Identifier identifier) {
            this.sprite = identifier;
        }

        @Generated
        public AtlasSprite(Identifier identifier, Identifier identifier2) {
            this.atlas = identifier;
            this.sprite = identifier2;
        }

        @Generated
        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof AtlasSprite)) {
                return false;
            }
            AtlasSprite atlasSprite = (AtlasSprite)object;
            if (!atlasSprite.canEqual(this)) {
                return false;
            }
            Identifier identifier = this.getAtlas();
            Identifier identifier2 = atlasSprite.getAtlas();
            if (identifier == null ? identifier2 != null : !((Object)identifier).equals(identifier2)) {
                return false;
            }
            Identifier identifier3 = this.getSprite();
            Identifier identifier4 = atlasSprite.getSprite();
            return !(identifier3 == null ? identifier4 != null : !((Object)identifier3).equals(identifier4));
        }

        @Generated
        protected boolean canEqual(Object object) {
            return object instanceof AtlasSprite;
        }

        @Generated
        public int hashCode() {
            int n = 59;
            int n2 = 1;
            Identifier identifier = this.getAtlas();
            n2 = n2 * 59 + (identifier == null ? 43 : ((Object)identifier).hashCode());
            Identifier identifier2 = this.getSprite();
            n2 = n2 * 59 + (identifier2 == null ? 43 : ((Object)identifier2).hashCode());
            return n2;
        }
    }

    public static interface ObjectInfo {
        public FontDescription getUpdatedFont();

        public String getDescription();

        public String toString();
    }
}


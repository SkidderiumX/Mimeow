/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.events.hover.impl;

import com.viaversion.viaversion.libs.mcstructs.core.Identifier;
import com.viaversion.viaversion.libs.mcstructs.core.utils.ToString;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.HoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.HoverEventAction;
import java.util.Objects;
import java.util.UUID;
import javax.annotation.Nullable;
import lombok.Generated;

public class EntityHoverEvent
extends HoverEvent {
    private DataHolder data;

    public EntityHoverEvent(DataHolder dataHolder) {
        super(HoverEventAction.SHOW_ENTITY);
        this.data = dataHolder;
    }

    public EntityHoverEvent(TextComponent textComponent) {
        super(HoverEventAction.SHOW_ENTITY);
        this.data = new LegacyHolder(textComponent);
    }

    public EntityHoverEvent(Identifier identifier, UUID uUID, @Nullable TextComponent textComponent) {
        super(HoverEventAction.SHOW_ENTITY);
        this.data = new ModernHolder(identifier, uUID, textComponent);
    }

    public DataHolder getData() {
        return this.data;
    }

    public EntityHoverEvent setData(DataHolder dataHolder) {
        this.data = dataHolder;
        return this;
    }

    public boolean isLegacy() {
        return this.data instanceof LegacyHolder;
    }

    public boolean isModern() {
        return this.data instanceof ModernHolder;
    }

    public LegacyHolder asLegacy() {
        if (this.data instanceof LegacyHolder) {
            return (LegacyHolder)this.data;
        }
        throw new UnsupportedOperationException("Data holder is not a legacy string holder: " + this.data);
    }

    public ModernHolder asModern() {
        if (this.data instanceof ModernHolder) {
            return (ModernHolder)this.data;
        }
        throw new UnsupportedOperationException("Data holder is not a modern holder: " + this.data);
    }

    public EntityHoverEvent setLegacyData(TextComponent textComponent) {
        this.data = new LegacyHolder(textComponent);
        return this;
    }

    public EntityHoverEvent setModernData(Identifier identifier, UUID uUID, @Nullable TextComponent textComponent) {
        this.data = new ModernHolder(identifier, uUID, textComponent);
        return this;
    }

    @Override
    public String toString() {
        return ToString.of(this).add("action", this.action).add("data", this.data).toString();
    }

    @Override
    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof EntityHoverEvent)) {
            return false;
        }
        EntityHoverEvent entityHoverEvent = (EntityHoverEvent)object;
        if (!entityHoverEvent.canEqual(this)) {
            return false;
        }
        DataHolder dataHolder = this.getData();
        DataHolder dataHolder2 = entityHoverEvent.getData();
        return !(dataHolder == null ? dataHolder2 != null : !dataHolder.equals(dataHolder2));
    }

    @Generated
    protected boolean canEqual(Object object) {
        return object instanceof EntityHoverEvent;
    }

    @Override
    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        DataHolder dataHolder = this.getData();
        n2 = n2 * 59 + (dataHolder == null ? 43 : dataHolder.hashCode());
        return n2;
    }

    public static class ModernHolder
    implements DataHolder {
        private Identifier type;
        private UUID uuid;
        @Nullable
        private TextComponent name;

        public String toString() {
            return ToString.of(this).add("type", this.type).add("uuid", this.uuid).add("name", this.name, Objects::nonNull).toString();
        }

        @Generated
        public Identifier getType() {
            return this.type;
        }

        @Generated
        public UUID getUuid() {
            return this.uuid;
        }

        @Nullable
        @Generated
        public TextComponent getName() {
            return this.name;
        }

        @Generated
        public void setType(Identifier identifier) {
            this.type = identifier;
        }

        @Generated
        public void setUuid(UUID uUID) {
            this.uuid = uUID;
        }

        @Generated
        public void setName(@Nullable TextComponent textComponent) {
            this.name = textComponent;
        }

        @Generated
        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof ModernHolder)) {
                return false;
            }
            ModernHolder modernHolder = (ModernHolder)object;
            if (!modernHolder.canEqual(this)) {
                return false;
            }
            Identifier identifier = this.getType();
            Identifier identifier2 = modernHolder.getType();
            if (identifier == null ? identifier2 != null : !((Object)identifier).equals(identifier2)) {
                return false;
            }
            UUID uUID = this.getUuid();
            UUID uUID2 = modernHolder.getUuid();
            if (uUID == null ? uUID2 != null : !((Object)uUID).equals(uUID2)) {
                return false;
            }
            TextComponent textComponent = this.getName();
            TextComponent textComponent2 = modernHolder.getName();
            return !(textComponent == null ? textComponent2 != null : !((Object)textComponent).equals(textComponent2));
        }

        @Generated
        protected boolean canEqual(Object object) {
            return object instanceof ModernHolder;
        }

        @Generated
        public int hashCode() {
            int n = 59;
            int n2 = 1;
            Identifier identifier = this.getType();
            n2 = n2 * 59 + (identifier == null ? 43 : ((Object)identifier).hashCode());
            UUID uUID = this.getUuid();
            n2 = n2 * 59 + (uUID == null ? 43 : ((Object)uUID).hashCode());
            TextComponent textComponent = this.getName();
            n2 = n2 * 59 + (textComponent == null ? 43 : ((Object)textComponent).hashCode());
            return n2;
        }

        @Generated
        public ModernHolder(Identifier identifier, UUID uUID, @Nullable TextComponent textComponent) {
            this.type = identifier;
            this.uuid = uUID;
            this.name = textComponent;
        }
    }

    public static class LegacyHolder
    implements DataHolder {
        private TextComponent data;

        public String toString() {
            return ToString.of(this).add("data", this.data).toString();
        }

        @Generated
        public TextComponent getData() {
            return this.data;
        }

        @Generated
        public void setData(TextComponent textComponent) {
            this.data = textComponent;
        }

        @Generated
        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof LegacyHolder)) {
                return false;
            }
            LegacyHolder legacyHolder = (LegacyHolder)object;
            if (!legacyHolder.canEqual(this)) {
                return false;
            }
            TextComponent textComponent = this.getData();
            TextComponent textComponent2 = legacyHolder.getData();
            return !(textComponent == null ? textComponent2 != null : !((Object)textComponent).equals(textComponent2));
        }

        @Generated
        protected boolean canEqual(Object object) {
            return object instanceof LegacyHolder;
        }

        @Generated
        public int hashCode() {
            int n = 59;
            int n2 = 1;
            TextComponent textComponent = this.getData();
            n2 = n2 * 59 + (textComponent == null ? 43 : ((Object)textComponent).hashCode());
            return n2;
        }

        @Generated
        public LegacyHolder(TextComponent textComponent) {
            this.data = textComponent;
        }
    }

    public static interface DataHolder {
    }
}


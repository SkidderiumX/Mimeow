/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.events.hover.impl;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.libs.mcstructs.core.Identifier;
import com.viaversion.viaversion.libs.mcstructs.core.utils.ToString;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.HoverEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.hover.HoverEventAction;
import java.util.Objects;
import javax.annotation.Nullable;
import lombok.Generated;

public class ItemHoverEvent
extends HoverEvent {
    private DataHolder data;

    public ItemHoverEvent(DataHolder dataHolder) {
        super(HoverEventAction.SHOW_ITEM);
        this.data = dataHolder;
    }

    public ItemHoverEvent(String string) {
        super(HoverEventAction.SHOW_ITEM);
        this.data = new LegacyHolder(string);
    }

    public ItemHoverEvent(Identifier identifier, int n, @Nullable CompoundTag compoundTag) {
        super(HoverEventAction.SHOW_ITEM);
        this.data = new ModernHolder(identifier, n, compoundTag);
    }

    public DataHolder getData() {
        return this.data;
    }

    public ItemHoverEvent setData(String string) {
        this.data = new LegacyHolder(string);
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
        throw new UnsupportedOperationException("Data holder is not a legacy raw holder: " + this.data);
    }

    public ModernHolder asModern() {
        if (this.data instanceof ModernHolder) {
            return (ModernHolder)this.data;
        }
        throw new UnsupportedOperationException("Data holder is not a modern holder: " + this.data);
    }

    public ItemHoverEvent setLegacyData(String string) {
        this.data = new LegacyHolder(string);
        return this;
    }

    public ItemHoverEvent setModernData(Identifier identifier, int n, @Nullable CompoundTag compoundTag) {
        this.data = new ModernHolder(identifier, n, compoundTag);
        return this;
    }

    @Override
    public String toString() {
        return ToString.of(this).put("action", this.action).put("data", this.data).toString();
    }

    @Override
    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ItemHoverEvent)) {
            return false;
        }
        ItemHoverEvent itemHoverEvent = (ItemHoverEvent)object;
        if (!itemHoverEvent.canEqual(this)) {
            return false;
        }
        DataHolder dataHolder = this.getData();
        DataHolder dataHolder2 = itemHoverEvent.getData();
        return !(dataHolder == null ? dataHolder2 != null : !dataHolder.equals(dataHolder2));
    }

    @Generated
    protected boolean canEqual(Object object) {
        return object instanceof ItemHoverEvent;
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
        private Identifier id;
        private int count;
        @Nullable
        private CompoundTag tag;

        public String toString() {
            return ToString.of(this).put("id", this.id).put("count", this.count, n -> n != 1).put("tag", this.tag, Objects::nonNull).toString();
        }

        @Generated
        public Identifier getId() {
            return this.id;
        }

        @Generated
        public int getCount() {
            return this.count;
        }

        @Nullable
        @Generated
        public CompoundTag getTag() {
            return this.tag;
        }

        @Generated
        public void setId(Identifier identifier) {
            this.id = identifier;
        }

        @Generated
        public void setCount(int n) {
            this.count = n;
        }

        @Generated
        public void setTag(@Nullable CompoundTag compoundTag) {
            this.tag = compoundTag;
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
            if (this.getCount() != modernHolder.getCount()) {
                return false;
            }
            Identifier identifier = this.getId();
            Identifier identifier2 = modernHolder.getId();
            if (identifier == null ? identifier2 != null : !((Object)identifier).equals(identifier2)) {
                return false;
            }
            CompoundTag compoundTag = this.getTag();
            CompoundTag compoundTag2 = modernHolder.getTag();
            return !(compoundTag == null ? compoundTag2 != null : !((Object)compoundTag).equals(compoundTag2));
        }

        @Generated
        protected boolean canEqual(Object object) {
            return object instanceof ModernHolder;
        }

        @Generated
        public int hashCode() {
            int n = 59;
            int n2 = 1;
            n2 = n2 * 59 + this.getCount();
            Identifier identifier = this.getId();
            n2 = n2 * 59 + (identifier == null ? 43 : ((Object)identifier).hashCode());
            CompoundTag compoundTag = this.getTag();
            n2 = n2 * 59 + (compoundTag == null ? 43 : ((Object)compoundTag).hashCode());
            return n2;
        }

        @Generated
        public ModernHolder(Identifier identifier, int n, @Nullable CompoundTag compoundTag) {
            this.id = identifier;
            this.count = n;
            this.tag = compoundTag;
        }
    }

    public static class LegacyHolder
    implements DataHolder {
        private String data;

        public String toString() {
            return ToString.of(this).put("data", this.data).toString();
        }

        @Generated
        public String getData() {
            return this.data;
        }

        @Generated
        public void setData(String string) {
            this.data = string;
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
            String string = this.getData();
            String string2 = legacyHolder.getData();
            return !(string == null ? string2 != null : !string.equals(string2));
        }

        @Generated
        protected boolean canEqual(Object object) {
            return object instanceof LegacyHolder;
        }

        @Generated
        public int hashCode() {
            int n = 59;
            int n2 = 1;
            String string = this.getData();
            n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
            return n2;
        }

        @Generated
        public LegacyHolder(String string) {
            this.data = string;
        }
    }

    public static interface DataHolder {
    }
}


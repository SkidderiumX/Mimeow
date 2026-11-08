/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.api.rewriters;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.ServerboundPacketType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.rewriter.ItemRewriter;
import org.checkerframework.checker.nullness.qual.Nullable;

public abstract class BackwardsItemRewriterBase<C extends ClientboundPacketType, S extends ServerboundPacketType, T extends BackwardsProtocol<C, ?, ?, S>>
extends ItemRewriter<C, S, T> {
    protected final boolean jsonNameFormat;

    protected BackwardsItemRewriterBase(T t, Type<Item> type, Type<Item[]> type2, Type<Item> type3, Type<Item[]> type4, boolean bl) {
        super(t, type, type2, type3, type4);
        this.jsonNameFormat = bl;
    }

    protected BackwardsItemRewriterBase(T t, Type<Item> type, Type<Item[]> type2, boolean bl) {
        this(t, type, type2, type, type2, bl);
    }

    @Override
    public @Nullable Item handleItemToServer(UserConnection userConnection, @Nullable Item item) {
        if (item == null) {
            return null;
        }
        item = super.handleItemToServer(userConnection, item);
        this.restoreDisplayTag(item);
        return item;
    }

    protected boolean hasBackupTag(CompoundTag compoundTag, String string) {
        return compoundTag.contains(this.nbtTagName(string));
    }

    protected void saveStringTag(CompoundTag compoundTag, StringTag stringTag, String string) {
        String string2 = this.nbtTagName(string);
        if (!compoundTag.contains(string2)) {
            compoundTag.putString(string2, stringTag.getValue());
        }
    }

    protected void saveListTag(CompoundTag compoundTag, ListTag<?> listTag, String string) {
        String string2 = this.nbtTagName(string);
        if (!compoundTag.contains(string2)) {
            compoundTag.put(string2, listTag.copy());
        }
    }

    protected void restoreDisplayTag(Item item) {
        if (item.tag() == null) {
            return;
        }
        CompoundTag compoundTag = item.tag().getCompoundTag("display");
        if (compoundTag != null) {
            if (compoundTag.remove(this.nbtTagName("customName")) != null) {
                compoundTag.remove("Name");
            } else {
                this.restoreStringTag(compoundTag, "Name");
            }
            this.restoreListTag(compoundTag, "Lore");
        }
    }

    protected void restoreStringTag(CompoundTag compoundTag, String string) {
        Tag tag = compoundTag.remove(this.nbtTagName(string));
        if (tag instanceof StringTag) {
            compoundTag.putString(string, ((StringTag)tag).getValue());
        }
    }

    protected void restoreListTag(CompoundTag compoundTag, String string) {
        Tag tag = compoundTag.remove(this.nbtTagName(string));
        if (tag instanceof ListTag) {
            compoundTag.put(string, ((ListTag)tag).copy());
        }
    }

    @Override
    public String nbtTagName() {
        return "VB|" + ((BackwardsProtocol)this.protocol).getClass().getSimpleName();
    }
}


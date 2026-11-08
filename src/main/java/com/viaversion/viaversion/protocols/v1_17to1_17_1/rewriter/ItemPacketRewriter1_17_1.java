/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_17to1_17_1.rewriter;

import com.viaversion.nbt.tag.ByteTag;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_16_4to1_17.packet.ClientboundPackets1_17;
import com.viaversion.viaversion.protocols.v1_16_4to1_17.packet.ServerboundPackets1_17;
import com.viaversion.viaversion.protocols.v1_17to1_17_1.Protocol1_17To1_17_1;
import com.viaversion.viaversion.rewriter.ItemRewriter;
import com.viaversion.viaversion.rewriter.RecipeRewriter;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.Limit;
import java.util.Iterator;
import org.checkerframework.checker.nullness.qual.Nullable;

public class ItemPacketRewriter1_17_1
extends ItemRewriter<ClientboundPackets1_17, ServerboundPackets1_17, Protocol1_17To1_17_1> {
    public ItemPacketRewriter1_17_1(Protocol1_17To1_17_1 protocol1_17To1_17_1) {
        super(protocol1_17To1_17_1, Types.ITEM1_13_2, Types.ITEM1_13_2_SHORT_ARRAY);
    }

    @Override
    public void registerPackets() {
        new RecipeRewriter<ClientboundPackets1_17>(this.protocol).register(ClientboundPackets1_17.UPDATE_RECIPES);
        ((Protocol1_17To1_17_1)this.protocol).replaceClientbound(ClientboundPackets1_17.CONTAINER_SET_SLOT, packetWrapper -> {
            packetWrapper.passthrough(Types.BYTE);
            packetWrapper.write(Types.VAR_INT, 0);
            packetWrapper.passthrough(Types.SHORT);
            this.passthroughClientboundItem(packetWrapper);
        });
        ((Protocol1_17To1_17_1)this.protocol).replaceClientbound(ClientboundPackets1_17.CONTAINER_SET_CONTENT, packetWrapper -> {
            packetWrapper.passthrough(Types.UNSIGNED_BYTE);
            packetWrapper.write(Types.VAR_INT, 0);
            Item[] itemArray = packetWrapper.passthroughAndMap(Types.ITEM1_13_2_SHORT_ARRAY, Types.ITEM1_13_2_ARRAY);
            for (int i = 0; i < itemArray.length; ++i) {
                itemArray[i] = this.handleItemToClient(packetWrapper.user(), itemArray[i]);
            }
            packetWrapper.write(Types.ITEM1_13_2, null);
        });
        ((Protocol1_17To1_17_1)this.protocol).replaceServerbound(ServerboundPackets1_17.CONTAINER_CLICK, packetWrapper -> {
            packetWrapper.passthrough(Types.BYTE);
            packetWrapper.read(Types.VAR_INT);
            packetWrapper.passthrough(Types.SHORT);
            packetWrapper.passthrough(Types.BYTE);
            packetWrapper.passthrough(Types.VAR_INT);
            int n = Limit.max(packetWrapper.passthrough(Types.VAR_INT), 128);
            for (int i = 0; i < n; ++i) {
                packetWrapper.passthrough(Types.SHORT);
                packetWrapper.write(Types.ITEM1_13_2, this.handleItemToServer(packetWrapper.user(), packetWrapper.read(Types.ITEM1_13_2)));
            }
            packetWrapper.write(Types.ITEM1_13_2, this.handleItemToServer(packetWrapper.user(), packetWrapper.read(Types.ITEM1_13_2)));
        });
    }

    @Override
    public Item handleItemToClient(UserConnection userConnection, Item item) {
        if (item == null) {
            return null;
        }
        CompoundTag compoundTag = item.tag();
        if (compoundTag == null) {
            return item;
        }
        int n = compoundTag.getInt("HideFlags");
        if ((n & 1) == 0) {
            this.replaceInvalidEnchantments(compoundTag, "Enchantments");
        }
        if ((n & 0x20) == 0) {
            this.replaceInvalidEnchantments(compoundTag, "StoredEnchantments");
        }
        return item;
    }

    @Override
    public @Nullable Item handleItemToServer(UserConnection userConnection, @Nullable Item item) {
        if (item == null) {
            return null;
        }
        CompoundTag compoundTag = item.tag();
        if (compoundTag == null) {
            return item;
        }
        this.restoreInvalidEnchantments(compoundTag, "Enchantments");
        this.restoreInvalidEnchantments(compoundTag, "StoredEnchantments");
        return item;
    }

    private void replaceInvalidEnchantments(CompoundTag compoundTag, String string) {
        ListTag<CompoundTag> listTag = compoundTag.getListTag(string, CompoundTag.class);
        if (listTag == null) {
            return;
        }
        boolean bl = false;
        Iterator iterator2 = listTag.getValue().iterator();
        while (iterator2.hasNext()) {
            CompoundTag compoundTag2 = (CompoundTag)iterator2.next();
            short s = compoundTag2.getShort("lvl");
            if (s >= 0 && s <= 255) continue;
            bl = true;
            break;
        }
        if (!bl) {
            return;
        }
        compoundTag.put(this.nbtTagName(string), new ByteTag(true));
        int n = compoundTag.getInt("HideFlags");
        compoundTag.put(this.nbtTagName("HideFlags"), new ByteTag((byte)n));
        int n2 = string.equals("Enchantments") ? 1 : 32;
        compoundTag.put("HideFlags", new ByteTag((byte)(n | n2)));
        CompoundTag compoundTag3 = compoundTag.getCompoundTag("display");
        if (compoundTag3 != null) {
            compoundTag.put(this.nbtTagName("display"), compoundTag3.copy());
        } else {
            compoundTag3 = new CompoundTag();
            compoundTag.put("display", compoundTag3);
        }
        ListTag<StringTag> listTag2 = compoundTag3.getListTag("Lore", StringTag.class);
        if (listTag2 == null) {
            listTag2 = new ListTag<StringTag>(StringTag.class);
            compoundTag3.put("Lore", listTag2);
        }
        for (int i = listTag.size() - 1; i >= 0; --i) {
            CompoundTag compoundTag4 = listTag.get(i);
            String string2 = compoundTag4.getString("id");
            if (string2 == null) continue;
            short s = compoundTag4.getShort("lvl");
            Key key = Key.of(string2);
            listTag2.getValue().add(0, new StringTag("{\"italic\":false,\"color\":\"gray\",\"translate\":\"enchantment." + key.namespace() + "." + key.path() + "\",\"extra\":[\" \",{\"translate\":\"enchantment.level." + s + "\"}]}"));
        }
    }

    private void restoreInvalidEnchantments(CompoundTag compoundTag, String string) {
        Tag tag;
        Tag tag2 = compoundTag.remove(this.nbtTagName(string));
        if (tag2 == null) {
            return;
        }
        Tag tag3 = compoundTag.remove(this.nbtTagName("HideFlags"));
        if (tag3 != null) {
            if (((ByteTag)tag3).asByte() == 0) {
                compoundTag.remove("HideFlags");
            } else {
                compoundTag.put("HideFlags", tag3);
            }
        }
        if ((tag = compoundTag.remove(this.nbtTagName("display"))) != null) {
            compoundTag.put("display", tag);
        } else {
            compoundTag.remove("display");
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_5to1_21_4.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.rewriters.text.NBTComponentRewriter;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ClientboundPacket1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.rewriter.BlockItemPacketRewriter1_21_5;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.SerializerVersion;
import com.viaversion.viaversion.util.TagUtil;
import java.util.HashSet;
import java.util.Set;
import org.checkerframework.checker.nullness.qual.Nullable;

public class ComponentRewriter1_21_5
extends NBTComponentRewriter<ClientboundPacket1_21_5> {
    public ComponentRewriter1_21_5(BackwardsProtocol<ClientboundPacket1_21_5, ?, ?, ?> backwardsProtocol) {
        super(backwardsProtocol);
    }

    @Override
    protected void processCompoundTag(UserConnection userConnection, CompoundTag compoundTag) {
        CompoundTag compoundTag2;
        super.processCompoundTag(userConnection, compoundTag);
        Tag tag = compoundTag.remove("hover_event");
        if (tag instanceof CompoundTag) {
            compoundTag2 = (CompoundTag)tag;
            compoundTag.put("hoverEvent", compoundTag2);
        }
        if ((tag = compoundTag.remove("click_event")) instanceof CompoundTag) {
            compoundTag2 = (CompoundTag)tag;
            compoundTag.put("clickEvent", compoundTag2);
            this.updateClickEvent(compoundTag2);
        }
    }

    @Override
    protected void handleHoverEvent(UserConnection userConnection, CompoundTag compoundTag) {
        String string = compoundTag.getString("action");
        if (string == null) {
            return;
        }
        switch (string) {
            case "show_text": {
                this.updateShowTextHover(compoundTag);
                break;
            }
            case "show_entity": {
                this.updateShowEntityHover(compoundTag);
                break;
            }
            case "show_item": {
                this.updateShowItemHover(userConnection, compoundTag);
            }
        }
    }

    private void updateClickEvent(CompoundTag compoundTag) {
        String string = compoundTag.getString("action");
        if (string == null) {
            return;
        }
        switch (string) {
            case "open_url": {
                compoundTag.put("value", compoundTag.getStringTag("url"));
                break;
            }
            case "change_page": {
                compoundTag.putString("value", Integer.toString(compoundTag.getInt("page")));
                break;
            }
            case "run_command": {
                StringTag stringTag = compoundTag.getStringTag("command");
                if (stringTag != null && !stringTag.getValue().startsWith("/")) {
                    stringTag.setValue("/" + stringTag.getValue());
                }
                compoundTag.put("value", stringTag);
                break;
            }
            case "suggest_command": {
                compoundTag.put("value", compoundTag.getStringTag("command"));
            }
        }
    }

    private void updateShowTextHover(CompoundTag compoundTag) {
        Tag tag = compoundTag.remove("value");
        compoundTag.put("contents", tag);
    }

    private void updateShowItemHover(UserConnection userConnection, CompoundTag compoundTag) {
        Tag tag;
        CompoundTag compoundTag2 = new CompoundTag();
        compoundTag.put("contents", compoundTag2);
        Tag tag2 = compoundTag.get("count");
        if (tag2 instanceof NumberTag) {
            tag = (NumberTag)tag2;
            compoundTag2.put("count", tag);
        }
        if ((tag2 = compoundTag.get("id")) instanceof StringTag) {
            tag = (StringTag)tag2;
            compoundTag2.put("id", tag);
        }
        tag = compoundTag.getCompoundTag("components");
        this.handleShowItem(userConnection, compoundTag2, (CompoundTag)tag);
        if (tag != null) {
            compoundTag.remove("components");
            compoundTag2.put("components", tag);
        }
    }

    @Override
    protected void handleShowItem(UserConnection userConnection, CompoundTag compoundTag, @Nullable CompoundTag compoundTag2) {
        super.handleShowItem(userConnection, compoundTag, compoundTag2);
        if (compoundTag2 == null) {
            return;
        }
        this.insertUglyJson(compoundTag2, userConnection);
        this.updateDataComponents(compoundTag2);
        this.removeDataComponents(compoundTag2, BlockItemPacketRewriter1_21_5.NEW_DATA_TO_REMOVE);
    }

    private void updateDataComponents(CompoundTag compoundTag) {
        Tag tag;
        Object object;
        ListTag<Tag> listTag;
        CompoundTag compoundTag2 = TagUtil.getNamespacedCompoundTag(compoundTag, "tooltip_display");
        Set<String> set = Set.of();
        if (compoundTag2 != null && (listTag = compoundTag2.getListTag("hidden_components", StringTag.class)) != null) {
            set = new HashSet(listTag.size());
            object = listTag.iterator();
            while (object.hasNext()) {
                tag = (StringTag)object.next();
                set.add(Key.stripMinecraftNamespace(((StringTag)tag).getValue()));
            }
        }
        if (set.containsAll(BlockItemPacketRewriter1_21_5.HIDE_ADDITIONAL_KEYS.stream().map(StructuredDataKey::identifier).toList())) {
            compoundTag.put("hide_additional_tooltip", new CompoundTag());
        }
        if ((listTag = TagUtil.getNamespacedCompoundTagList(compoundTag, "attribute_modifiers")) != null) {
            TagUtil.removeNamespaced(compoundTag, "attribute_modifiers");
            object = new CompoundTag();
            ((CompoundTag)object).put("modifiers", listTag);
            ((CompoundTag)object).putBoolean("show_in_tooltip", set.contains("attribute_modifiers"));
            compoundTag.put("attribute_modifiers", (Tag)object);
        }
        if ((object = TagUtil.getNamespacedNumberTag(compoundTag, "dyed_color")) != null) {
            TagUtil.removeNamespaced(compoundTag, "dyed_color");
            tag = new CompoundTag();
            ((CompoundTag)tag).put("rgb", (Tag)object);
            ((CompoundTag)tag).putBoolean("show_in_tooltip", set.contains("dyed_color"));
            compoundTag.put("dyed_color", tag);
        }
        this.updateShowInTooltip(compoundTag, "unbreakable", set);
        this.updateShowInTooltip(compoundTag, "dyed_color", set);
        this.updateShowInTooltip(compoundTag, "trim", set);
        this.updateShowInTooltip(compoundTag, "jukebox_playable", set);
        this.handleAdventureModePredicate(compoundTag, "can_place_on", set);
        this.handleAdventureModePredicate(compoundTag, "can_break", set);
        this.handleEnchantments(compoundTag, "enchantments", set);
        this.handleEnchantments(compoundTag, "stored_enchantments", set);
        this.removeDataComponents(compoundTag, StructuredDataKey.INSTRUMENT1_21_5, StructuredDataKey.JUKEBOX_PLAYABLE1_21_5);
    }

    private void updateShowInTooltip(CompoundTag compoundTag, String string, Set<String> set) {
        CompoundTag compoundTag2 = TagUtil.getNamespacedCompoundTag(compoundTag, string);
        if (compoundTag2 != null) {
            compoundTag2.putBoolean("show_in_tooltip", !set.contains(string));
        }
    }

    private void handleAdventureModePredicate(CompoundTag compoundTag, String string, Set<String> set) {
        ListTag<CompoundTag> listTag = TagUtil.getNamespacedCompoundTagList(compoundTag, string);
        if (listTag == null) {
            return;
        }
        this.removeDataComponents(compoundTag, string);
        CompoundTag compoundTag2 = new CompoundTag();
        compoundTag2.put("predicates", listTag);
        compoundTag2.putBoolean("show_in_tooltip", !set.contains(string));
        compoundTag.put(string, compoundTag2);
    }

    private void handleEnchantments(CompoundTag compoundTag, String string, Set<String> set) {
        CompoundTag compoundTag2 = TagUtil.getNamespacedCompoundTag(compoundTag, string);
        if (compoundTag2 != null) {
            TagUtil.removeNamespaced(compoundTag, string);
            CompoundTag compoundTag3 = new CompoundTag();
            compoundTag3.put("levels", compoundTag2);
            compoundTag3.putBoolean("show_in_tooltip", !set.contains(string));
            compoundTag.put(string, compoundTag3);
        }
    }

    private void insertUglyJson(CompoundTag compoundTag, UserConnection userConnection) {
        this.insertUglyJson(compoundTag, "item_name", userConnection);
        this.insertUglyJson(compoundTag, "custom_name", userConnection);
        String string = TagUtil.getNamespacedTagKey(compoundTag, "lore");
        ListTag<?> listTag = compoundTag.getListTag(string);
        if (listTag != null) {
            compoundTag.put(string, this.updateComponentList(userConnection, listTag));
        }
    }

    public ListTag<StringTag> updateComponentList(UserConnection userConnection, ListTag<?> listTag) {
        ListTag<StringTag> listTag2 = new ListTag<StringTag>(StringTag.class);
        for (Tag tag : listTag) {
            listTag2.add(new StringTag(this.toUglyJson(userConnection, tag)));
        }
        return listTag2;
    }

    private void insertUglyJson(CompoundTag compoundTag, String string, UserConnection userConnection) {
        String string2 = TagUtil.getNamespacedTagKey(compoundTag, string);
        Tag tag = compoundTag.get(string2);
        if (tag == null) {
            return;
        }
        compoundTag.putString(string2, this.toUglyJson(userConnection, tag));
    }

    private void updateShowEntityHover(CompoundTag compoundTag) {
        Tag tag;
        Tag tag2;
        CompoundTag compoundTag2 = new CompoundTag();
        compoundTag.put("contents", compoundTag2);
        Tag tag3 = compoundTag.remove("name");
        if (tag3 != null) {
            compoundTag2.put("name", tag3);
        }
        if ((tag2 = compoundTag.remove("id")) instanceof StringTag) {
            tag = (StringTag)tag2;
            ((StringTag)tag).setValue(this.protocol.getEntityRewriter().mappedEntityIdentifier(((StringTag)tag).getValue()));
            compoundTag2.put("type", tag);
        }
        if ((tag = compoundTag.remove("uuid")) != null) {
            compoundTag2.put("id", tag);
        }
    }

    String toUglyJson(UserConnection userConnection, Tag tag) {
        this.processTag(userConnection, tag);
        return SerializerVersion.V1_21_4.toString(SerializerVersion.V1_21_4.toComponent(tag));
    }

    @Override
    protected void handleWrittenBookContents(UserConnection userConnection, CompoundTag compoundTag) {
        CompoundTag compoundTag2 = TagUtil.getNamespacedCompoundTag(compoundTag, "written_book_content");
        if (compoundTag2 == null) {
            return;
        }
        ListTag<CompoundTag> listTag = compoundTag2.getListTag("pages", CompoundTag.class);
        if (listTag == null) {
            return;
        }
        for (CompoundTag compoundTag3 : listTag) {
            Tag tag = compoundTag3.get("raw");
            compoundTag3.putString("raw", this.toUglyJson(userConnection, tag));
            Tag tag2 = compoundTag3.get("filtered");
            if (tag2 == null) continue;
            compoundTag3.putString("filtered", this.toUglyJson(userConnection, tag));
        }
    }
}


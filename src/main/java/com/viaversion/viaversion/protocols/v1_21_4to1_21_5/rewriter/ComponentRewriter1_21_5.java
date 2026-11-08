/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21_4to1_21_5.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.Protocol1_21_4To1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.rewriter.BlockItemPacketRewriter1_21_5;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPacket1_21_2;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.rewriter.text.JsonNBTComponentRewriter;
import com.viaversion.viaversion.util.SerializerVersion;
import com.viaversion.viaversion.util.StringUtil;
import com.viaversion.viaversion.util.TagUtil;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Level;
import org.checkerframework.checker.nullness.qual.Nullable;

public class ComponentRewriter1_21_5
extends JsonNBTComponentRewriter<ClientboundPacket1_21_2> {
    public ComponentRewriter1_21_5(Protocol1_21_4To1_21_5 protocol1_21_4To1_21_5) {
        super(protocol1_21_4To1_21_5, ComponentRewriterBase.ReadType.NBT);
    }

    @Override
    protected void processCompoundTag(UserConnection userConnection, CompoundTag compoundTag) {
        CompoundTag compoundTag2;
        super.processCompoundTag(userConnection, compoundTag);
        Tag tag = compoundTag.remove("hoverEvent");
        if (tag instanceof CompoundTag) {
            compoundTag2 = (CompoundTag)tag;
            compoundTag.put("hover_event", compoundTag2);
        }
        if ((tag = compoundTag.remove("clickEvent")) instanceof CompoundTag) {
            compoundTag2 = (CompoundTag)tag;
            try {
                this.updateClickEvent(compoundTag2);
            }
            catch (IllegalArgumentException | URISyntaxException exception) {
                return;
            }
            compoundTag.put("click_event", compoundTag2);
        }
    }

    @Override
    protected void handleShowItem(UserConnection userConnection, CompoundTag compoundTag, @Nullable CompoundTag compoundTag2) {
        Object object;
        Object object2;
        super.handleShowItem(userConnection, compoundTag, compoundTag2);
        if (compoundTag2 == null) {
            return;
        }
        CompoundTag compoundTag3 = new CompoundTag();
        boolean bl = TagUtil.removeNamespaced(compoundTag2, "hide_tooltip");
        ListTag<StringTag> listTag = new ListTag<StringTag>(StringTag.class);
        if (TagUtil.removeNamespaced(compoundTag2, "hide_additional_tooltip")) {
            object2 = BlockItemPacketRewriter1_21_5.HIDE_ADDITIONAL_KEYS.iterator();
            while (object2.hasNext()) {
                object = object2.next();
                listTag.add(new StringTag(((StructuredDataKey)object).identifier()));
            }
        }
        this.updateHiddenComponents(compoundTag2, "unbreakable", listTag);
        this.updateHiddenComponents(compoundTag2, "can_place_on", listTag);
        this.updateHiddenComponents(compoundTag2, "can_break", listTag);
        this.updateHiddenComponents(compoundTag2, "dyed_color", listTag);
        this.updateHiddenComponents(compoundTag2, "attribute_modifiers", listTag);
        this.updateHiddenComponents(compoundTag2, "trim", listTag);
        this.updateHiddenComponents(compoundTag2, "enchantments", listTag);
        this.updateHiddenComponents(compoundTag2, "stored_enchantments", listTag);
        this.updateHiddenComponents(compoundTag2, "jukebox_playable", listTag);
        if (bl || !listTag.isEmpty()) {
            compoundTag3.putBoolean("hide_tooltip", bl);
            compoundTag3.put("hidden_components", listTag);
            compoundTag2.put("tooltip_display", compoundTag3);
        }
        if ((object2 = TagUtil.getNamespacedCompoundTag(compoundTag2, "attribute_modifiers")) != null) {
            this.removeDataComponents(compoundTag2, "attribute_modifiers");
            compoundTag2.put("attribute_modifiers", ((CompoundTag)object2).get("modifiers"));
        }
        if ((object = TagUtil.getNamespacedCompoundTag(compoundTag2, "dyed_color")) != null) {
            this.removeDataComponents(compoundTag2, "dyed_color");
            compoundTag2.put("dyed_color", ((CompoundTag)object).get("rgb"));
        }
        this.handleAdventureModePredicate(compoundTag2, "can_break");
        this.handleAdventureModePredicate(compoundTag2, "can_place_on");
        this.handleEnchantments(compoundTag2, "enchantments");
        this.handleEnchantments(compoundTag2, "stored_enchantments");
        this.updateUglyJson(compoundTag2, userConnection);
        this.removeDataComponents(compoundTag2, StructuredDataKey.INSTRUMENT1_21_2, StructuredDataKey.JUKEBOX_PLAYABLE1_21);
    }

    private void updateHiddenComponents(CompoundTag compoundTag, String string, ListTag<StringTag> listTag) {
        CompoundTag compoundTag2 = TagUtil.getNamespacedCompoundTag(compoundTag, string);
        if (compoundTag2 == null) {
            return;
        }
        boolean bl = compoundTag2.getBoolean("show_in_tooltip", true);
        if (!bl) {
            listTag.add(new StringTag(string));
        }
        compoundTag2.remove("show_in_tooltip");
    }

    private void handleAdventureModePredicate(CompoundTag compoundTag, String string) {
        CompoundTag compoundTag2 = TagUtil.getNamespacedCompoundTag(compoundTag, string);
        if (compoundTag2 == null) {
            return;
        }
        ListTag<CompoundTag> listTag = compoundTag2.getListTag("predicates", CompoundTag.class);
        this.removeDataComponents(compoundTag, string);
        compoundTag.put(string, listTag);
    }

    private void handleEnchantments(CompoundTag compoundTag, String string) {
        Tag tag;
        CompoundTag compoundTag2 = TagUtil.getNamespacedCompoundTag(compoundTag, string);
        if (compoundTag2 != null && (tag = compoundTag2.remove("levels")) instanceof CompoundTag) {
            CompoundTag compoundTag3 = (CompoundTag)tag;
            compoundTag2.putAll(compoundTag3);
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
                this.updateShowTextHover(userConnection, compoundTag);
                break;
            }
            case "show_entity": {
                this.updateShowEntityHover(userConnection, compoundTag);
                break;
            }
            case "show_item": {
                this.updateShowItemHover(userConnection, compoundTag);
            }
        }
    }

    private void updateClickEvent(CompoundTag compoundTag) throws URISyntaxException {
        String string = compoundTag.getString("action");
        if (string == null) {
            return;
        }
        if (string.equals("open_url")) {
            StringTag stringTag = compoundTag.getStringTag("value");
            URI uRI = new URI(stringTag.getValue());
            if (!"https".equalsIgnoreCase(uRI.getScheme()) && !"http".equalsIgnoreCase(uRI.getScheme())) {
                throw new IllegalArgumentException("Invalid URL");
            }
            compoundTag.put("url", stringTag);
        } else if (string.equals("change_page")) {
            int n = Integer.parseInt(compoundTag.getString("value"));
            if (n < 1) {
                throw new IllegalArgumentException("Invalid page number");
            }
            compoundTag.putInt("page", n);
        } else if (string.equals("run_command") || string.equals("suggest_command")) {
            String string2 = compoundTag.getString("value");
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < string2.length(); ++i) {
                char c = string2.charAt(i);
                if (c != '\u00a7' && c >= ' ' && c != '\u007f') {
                    stringBuilder.append(c);
                    continue;
                }
                if (!string.equals("suggest_command") || c != '\n') continue;
                stringBuilder.append(c);
            }
            compoundTag.putString("command", stringBuilder.toString());
        }
    }

    private void updateShowTextHover(UserConnection userConnection, CompoundTag compoundTag) {
        Tag tag = compoundTag.get("value");
        if (tag != null) {
            this.processTag(userConnection, tag);
            return;
        }
        Tag tag2 = compoundTag.remove("contents");
        this.processTag(userConnection, tag2);
        compoundTag.put("value", tag2);
    }

    private void updateShowItemHover(UserConnection userConnection, CompoundTag compoundTag) {
        this.convertLegacyItemContents(compoundTag);
        Tag tag = compoundTag.remove("contents");
        if (tag instanceof CompoundTag) {
            Tag tag2;
            CompoundTag compoundTag2 = (CompoundTag)tag;
            Tag tag3 = compoundTag2.get("count");
            if (tag3 != null) {
                compoundTag.put("count", tag3);
            }
            if ((tag2 = compoundTag2.get("id")) != null) {
                compoundTag.put("id", tag2);
            }
            CompoundTag compoundTag3 = compoundTag2.getCompoundTag("components");
            this.handleShowItem(userConnection, compoundTag2, compoundTag3);
            if (compoundTag3 != null) {
                compoundTag.put("components", compoundTag3);
            }
        } else if (tag instanceof StringTag) {
            StringTag stringTag = (StringTag)tag;
            compoundTag.put("id", stringTag);
        }
    }

    private void updateUglyJson(CompoundTag compoundTag, UserConnection userConnection) {
        this.updateUglyJson(compoundTag, "item_name", userConnection);
        this.updateUglyJson(compoundTag, "custom_name", userConnection);
        String string = TagUtil.getNamespacedTagKey(compoundTag, "lore");
        ListTag<StringTag> listTag = compoundTag.getListTag(string, StringTag.class);
        if (listTag != null) {
            compoundTag.put(string, this.updateComponentList(userConnection, listTag, false));
        }
    }

    public ListTag<CompoundTag> updateComponentList(UserConnection userConnection, ListTag<StringTag> listTag, boolean bl) {
        ListTag<CompoundTag> listTag2 = new ListTag<CompoundTag>(CompoundTag.class);
        for (StringTag stringTag : listTag) {
            Tag tag;
            try {
                tag = bl ? this.uglyJsonToTagUncaught(userConnection, stringTag.getValue()) : this.uglyJsonToTag(userConnection, stringTag.getValue());
            }
            catch (Exception exception) {
                continue;
            }
            CompoundTag compoundTag = new CompoundTag();
            compoundTag.putString("text", "");
            compoundTag.put("extra", new ListTag<Tag>(List.of(tag)));
            listTag2.add(compoundTag);
        }
        return listTag2;
    }

    private void updateUglyJson(CompoundTag compoundTag, String string, UserConnection userConnection) {
        String string2 = TagUtil.getNamespacedTagKey(compoundTag, string);
        String string3 = compoundTag.getString(string2);
        if (string3 == null) {
            return;
        }
        compoundTag.put(string2, this.uglyJsonToTag(userConnection, string3));
    }

    private void updateShowEntityHover(UserConnection userConnection, CompoundTag compoundTag) {
        StringTag stringTag;
        Tag tag;
        this.convertLegacyEntityContents(compoundTag);
        Tag tag2 = compoundTag.remove("contents");
        if (!(tag2 instanceof CompoundTag)) {
            return;
        }
        CompoundTag compoundTag2 = (CompoundTag)tag2;
        tag2 = compoundTag2.get("name");
        if (tag2 != null) {
            this.processTag(userConnection, tag2);
            compoundTag.put("name", tag2);
        }
        if ((tag = compoundTag2.get("id")) != null) {
            compoundTag.put("uuid", tag);
        }
        if ((stringTag = compoundTag2.getStringTag("type")) != null) {
            stringTag.setValue(this.protocol.getEntityRewriter().mappedEntityIdentifier(stringTag.getValue()));
            compoundTag.put("id", stringTag);
        }
    }

    public Tag uglyJsonToTagUncaught(UserConnection userConnection, String string) {
        Tag tag = SerializerVersion.V1_21_4.toTag(SerializerVersion.V1_21_4.toComponent(string));
        this.processTag(userConnection, tag);
        return tag;
    }

    public Tag uglyJsonToTag(UserConnection userConnection, String string) {
        try {
            return this.uglyJsonToTagUncaught(userConnection, string);
        }
        catch (Exception exception) {
            if (Via.getConfig().logTextComponentConversionErrors()) {
                Via.getPlatform().getLogger().log(Level.SEVERE, "Error converting json text component: " + StringUtil.forLogging(string), exception);
            }
            return new StringTag("<error>");
        }
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
            String string = compoundTag3.getString("raw");
            compoundTag3.put("raw", this.uglyJsonToTag(userConnection, string));
            String string2 = compoundTag3.getString("filtered");
            if (string2 == null) continue;
            compoundTag3.put("filtered", this.uglyJsonToTag(userConnection, string2));
        }
    }

    @Override
    protected SerializerVersion inputSerializerVersion() {
        return SerializerVersion.V1_21_4;
    }
}


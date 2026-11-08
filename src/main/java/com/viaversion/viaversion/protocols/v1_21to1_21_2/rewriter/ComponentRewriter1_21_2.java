/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21to1_21_2.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.FullMappings;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundPacket1_21;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.Protocol1_21To1_21_2;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.rewriter.text.JsonNBTComponentRewriter;
import com.viaversion.viaversion.util.SerializerVersion;
import com.viaversion.viaversion.util.TagUtil;
import java.util.Collections;
import java.util.Iterator;

public class ComponentRewriter1_21_2
extends JsonNBTComponentRewriter<ClientboundPacket1_21> {
    public ComponentRewriter1_21_2(Protocol1_21To1_21_2 protocol1_21To1_21_2) {
        super(protocol1_21To1_21_2, ComponentRewriterBase.ReadType.NBT);
    }

    @Override
    protected void handleShowItem(UserConnection userConnection, CompoundTag compoundTag, CompoundTag compoundTag2) {
        Tag tag;
        CompoundTag compoundTag3;
        CompoundTag compoundTag4;
        super.handleShowItem(userConnection, compoundTag, compoundTag2);
        if (compoundTag2 == null) {
            return;
        }
        ComponentRewriter1_21_2.convertAttributes(compoundTag2, this.protocol.getMappingData().getAttributeMappings());
        CompoundTag compoundTag5 = TagUtil.getNamespacedCompoundTag(compoundTag2, "instrument");
        if (compoundTag5 != null) {
            compoundTag5.putString("description", "");
        }
        if ((compoundTag4 = TagUtil.getNamespacedCompoundTag(compoundTag2, "food")) != null) {
            compoundTag3 = compoundTag4.getCompoundTag("using_converts_to");
            if (compoundTag3 != null) {
                compoundTag4.remove("using_converts_to");
                compoundTag2.put("minecraft:use_remainder", compoundTag3);
            }
            compoundTag4.remove("eat_seconds");
            compoundTag4.remove("effects");
        }
        if ((compoundTag3 = TagUtil.getNamespacedCompoundTag(compoundTag2, "enchantments")) != null) {
            tag = compoundTag3.getCompoundTag("levels");
            tag.entrySet().removeIf(entry -> ((NumberTag)entry.getValue()).asInt() == 0);
        }
        this.removeDataComponents(compoundTag2, StructuredDataKey.FIRE_RESISTANT, StructuredDataKey.LOCK1_20_5);
        tag = TagUtil.getNamespacedStringTag(compoundTag2, "custom_name");
        StringTag stringTag = TagUtil.getNamespacedStringTag(compoundTag2, "item_name");
        if (tag != null || stringTag == null) {
            return;
        }
        int n = this.protocol.getMappingData().getFullItemMappings().mappedId(compoundTag.getString("id"));
        if (n == 952 || n == 1147 || n == 1039 || n == 1203 || n == 1200 || n == 1204 || n == 1202) {
            SerializerVersion serializerVersion = this.inputSerializerVersion();
            SerializerVersion serializerVersion2 = this.outputSerializerVersion();
            CompoundTag compoundTag6 = new CompoundTag();
            compoundTag6.putBoolean("italic", false);
            compoundTag6.putString("text", "");
            Tag tag2 = serializerVersion.toTag(serializerVersion.toComponent(stringTag.getValue()));
            compoundTag6.put("extra", new ListTag<Tag>(Collections.singletonList(tag2)));
            compoundTag2.put("minecraft:custom_name", new StringTag(serializerVersion2.toString(serializerVersion2.toComponent(compoundTag6))));
        }
    }

    @Override
    protected void handleTranslate(UserConnection userConnection, CompoundTag compoundTag, StringTag stringTag) {
        switch (stringTag.getValue()) {
            case "commands.drop.no_loot_table": {
                stringTag.setValue("Entity %s has no loot table");
                break;
            }
            case "commands.advancement.advancementNotFound": {
                stringTag.setValue("No advancement was found by the name '%1$s'");
                break;
            }
            case "commands.function.success.single": {
                stringTag.setValue("Test Executed %s command(s) from function '%s'");
                break;
            }
            case "commands.function.success.single.result": {
                stringTag.setValue("Function '%2$s' returned %1$s");
                break;
            }
            case "commands.function.success.multiple": {
                stringTag.setValue("Test Executed %s command(s) from %s functions");
                break;
            }
            case "commands.function.success.multiple.result": {
                stringTag.setValue("Executed %s functions");
                break;
            }
            case "commands.fillbiome.success": {
                stringTag.setValue("%s biome entry/entries set between %s, %s, %s and %s, %s, %s");
                break;
            }
            case "commands.publish.success": {
                stringTag.setValue("Multiplayer game is now hosted on port %s");
            }
        }
    }

    public static void convertAttributes(CompoundTag compoundTag, FullMappings fullMappings) {
        CompoundTag compoundTag2 = TagUtil.getNamespacedCompoundTag(compoundTag, "attribute_modifiers");
        if (compoundTag2 == null) {
            return;
        }
        ListTag<CompoundTag> listTag = compoundTag2.getListTag("modifiers", CompoundTag.class);
        Iterator<CompoundTag> iterator2 = listTag.iterator();
        while (iterator2.hasNext()) {
            CompoundTag compoundTag3 = iterator2.next();
            StringTag stringTag = compoundTag3.getStringTag("type");
            String string = fullMappings.mappedIdentifier(stringTag.getValue());
            if (string != null) {
                stringTag.setValue(string);
                continue;
            }
            iterator2.remove();
        }
    }

    @Override
    protected SerializerVersion inputSerializerVersion() {
        return SerializerVersion.V1_20_5;
    }
}


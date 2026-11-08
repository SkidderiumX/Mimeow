/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.api.rewriters;

import com.viaversion.nbt.tag.ByteTag;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.data.BackwardsMappingData;
import com.viaversion.viabackwards.api.rewriters.BackwardsStructuredItemRewriter;
import com.viaversion.viabackwards.utils.ChatUtil;
import com.viaversion.viaversion.api.data.Mappings;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.data.Enchantments;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntMap;
import com.viaversion.viaversion.rewriter.IdRewriteFunction;
import com.viaversion.viaversion.util.ComponentUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class StructuredEnchantmentRewriter {
    protected final BackwardsStructuredItemRewriter<?, ?, ?> itemRewriter;
    private boolean rewriteIds = true;

    public StructuredEnchantmentRewriter(BackwardsStructuredItemRewriter<?, ?, ?> backwardsStructuredItemRewriter) {
        this.itemRewriter = backwardsStructuredItemRewriter;
    }

    public void handleToClient(Item item) {
        StructuredDataContainer structuredDataContainer = item.dataContainer();
        BackwardsMappingData backwardsMappingData = ((BackwardsProtocol)this.itemRewriter.protocol()).getMappingData();
        IdRewriteFunction idRewriteFunction = n -> {
            Mappings mappings = backwardsMappingData.getEnchantmentMappings();
            return mappings.getNewId(n);
        };
        DescriptionSupplier descriptionSupplier = (n, n2) -> {
            String string = backwardsMappingData.mappedEnchantmentName(n);
            return ComponentUtil.jsonStringToTag(ChatUtil.legacyToJsonString("\u00a77" + string, "enchantment.level.%s".formatted(n2), true));
        };
        this.rewriteEnchantmentsToClient(structuredDataContainer, StructuredDataKey.ENCHANTMENTS1_20_5, idRewriteFunction, descriptionSupplier, false);
        this.rewriteEnchantmentsToClient(structuredDataContainer, StructuredDataKey.STORED_ENCHANTMENTS1_20_5, idRewriteFunction, descriptionSupplier, true);
    }

    public void handleToServer(Item item) {
        StructuredDataContainer structuredDataContainer = item.dataContainer();
        CompoundTag compoundTag = structuredDataContainer.get(StructuredDataKey.CUSTOM_DATA);
        if (compoundTag != null) {
            this.rewriteEnchantmentsToServer(structuredDataContainer, compoundTag, StructuredDataKey.ENCHANTMENTS1_20_5);
            this.rewriteEnchantmentsToServer(structuredDataContainer, compoundTag, StructuredDataKey.STORED_ENCHANTMENTS1_20_5);
        }
    }

    public void rewriteEnchantmentsToClient(StructuredDataContainer structuredDataContainer, StructuredDataKey<Enchantments> structuredDataKey, IdRewriteFunction idRewriteFunction, DescriptionSupplier descriptionSupplier, boolean bl) {
        Object object;
        Enchantments enchantments = structuredDataContainer.get(structuredDataKey);
        if (enchantments == null || enchantments.size() == 0) {
            return;
        }
        ArrayList<Tag> arrayList = new ArrayList<Tag>();
        boolean bl2 = false;
        boolean bl3 = false;
        Iterator iterator2 = enchantments.enchantments().int2IntEntrySet().iterator();
        ArrayList<PendingIdChange> arrayList2 = new ArrayList<PendingIdChange>();
        while (iterator2.hasNext()) {
            Tag tag;
            object = (Int2IntMap.Entry)iterator2.next();
            int n = object.getIntKey();
            int n2 = idRewriteFunction.rewrite(n);
            int n3 = object.getIntValue();
            if (n2 != -1) {
                if (!this.rewriteIds) continue;
                arrayList2.add(new PendingIdChange(n, n2, n3));
                continue;
            }
            if (!bl2) {
                tag = this.customData(structuredDataContainer);
                this.itemRewriter.saveListTag((CompoundTag)tag, this.asTag(enchantments), structuredDataKey.identifier());
                bl2 = true;
            }
            if ((tag = descriptionSupplier.get(n, n3)) != null && enchantments.showInTooltip()) {
                arrayList.add(tag);
                bl3 = true;
            }
            iterator2.remove();
        }
        for (PendingIdChange pendingIdChange : arrayList2) {
            enchantments.remove(pendingIdChange.id());
        }
        for (PendingIdChange pendingIdChange : arrayList2) {
            enchantments.add(pendingIdChange.mappedId(), pendingIdChange.level());
        }
        if (bl2) {
            object = this.customData(structuredDataContainer);
            if (!bl && enchantments.size() == 0) {
                Boolean bl4 = structuredDataContainer.get(StructuredDataKey.ENCHANTMENT_GLINT_OVERRIDE);
                if (bl4 != null) {
                    ((CompoundTag)object).putBoolean(this.itemRewriter.nbtTagName("glint"), bl4);
                } else {
                    ((CompoundTag)object).putBoolean(this.itemRewriter.nbtTagName("noglint"), true);
                }
                structuredDataContainer.set(StructuredDataKey.ENCHANTMENT_GLINT_OVERRIDE, true);
            }
            if (enchantments.showInTooltip()) {
                ((CompoundTag)object).putBoolean(this.itemRewriter.nbtTagName("show_" + structuredDataKey.identifier()), true);
            }
        }
        if (bl3) {
            object = this.customData(structuredDataContainer);
            Tag[] tagArray = structuredDataContainer.get(StructuredDataKey.LORE);
            if (tagArray != null) {
                List<Tag> list = Arrays.asList(tagArray);
                this.itemRewriter.saveGenericTagList((CompoundTag)object, list, "lore");
                arrayList.addAll(list);
            } else {
                ((CompoundTag)object).putBoolean(this.itemRewriter.nbtTagName("nolore"), true);
            }
            structuredDataContainer.set(StructuredDataKey.LORE, arrayList.toArray(new Tag[0]));
        }
    }

    private CompoundTag customData(StructuredDataContainer structuredDataContainer) {
        CompoundTag compoundTag = structuredDataContainer.get(StructuredDataKey.CUSTOM_DATA);
        if (compoundTag == null) {
            compoundTag = new CompoundTag();
            structuredDataContainer.set(StructuredDataKey.CUSTOM_DATA, compoundTag);
        }
        return compoundTag;
    }

    private ListTag<CompoundTag> asTag(Enchantments enchantments) {
        ListTag<CompoundTag> listTag = new ListTag<CompoundTag>(CompoundTag.class);
        for (Int2IntMap.Entry entry : enchantments.enchantments().int2IntEntrySet()) {
            CompoundTag compoundTag = new CompoundTag();
            compoundTag.putInt("id", entry.getIntKey());
            compoundTag.putInt("lvl", entry.getIntValue());
            listTag.add(compoundTag);
        }
        return listTag;
    }

    public void rewriteEnchantmentsToServer(StructuredDataContainer structuredDataContainer, CompoundTag compoundTag, StructuredDataKey<Enchantments> structuredDataKey) {
        ListTag<CompoundTag> listTag = this.itemRewriter.removeListTag(compoundTag, structuredDataKey.identifier(), CompoundTag.class);
        if (listTag == null) {
            return;
        }
        Tag tag = compoundTag.remove(this.itemRewriter.nbtTagName("glint"));
        if (tag instanceof ByteTag) {
            structuredDataContainer.set(StructuredDataKey.ENCHANTMENT_GLINT_OVERRIDE, ((NumberTag)tag).asBoolean());
        } else if (compoundTag.remove(this.itemRewriter.nbtTagName("noglint")) != null) {
            structuredDataContainer.remove(StructuredDataKey.ENCHANTMENT_GLINT_OVERRIDE);
        }
        List<Tag> list = this.itemRewriter.removeGenericTagList(compoundTag, "lore");
        if (list != null) {
            structuredDataContainer.set(StructuredDataKey.LORE, list.toArray(new Tag[0]));
        } else if (compoundTag.remove(this.itemRewriter.nbtTagName("nolore")) != null) {
            structuredDataContainer.remove(StructuredDataKey.LORE);
        }
        Enchantments enchantments = new Enchantments(compoundTag.remove(this.itemRewriter.nbtTagName("show_" + structuredDataKey.identifier())) != null);
        for (CompoundTag compoundTag2 : listTag) {
            enchantments.add(compoundTag2.getInt("id"), compoundTag2.getInt("lvl"));
        }
        structuredDataContainer.set(structuredDataKey, enchantments);
    }

    public void setRewriteIds(boolean bl) {
        this.rewriteIds = bl;
    }

    @FunctionalInterface
    public static interface DescriptionSupplier {
        public Tag get(int var1, int var2);
    }

    private record PendingIdChange(int id, int mappedId, int level) {
    }
}


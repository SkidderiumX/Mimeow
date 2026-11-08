/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.api.rewriters;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.api.rewriters.BackwardsItemRewriter;
import com.viaversion.viabackwards.utils.ChatUtil;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.util.Key;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class EnchantmentRewriter {
    public static final String ENCHANTMENT_LEVEL_TRANSLATION = "enchantment.level.%s";
    protected final Map<String, String> enchantmentMappings = new HashMap<String, String>();
    protected final BackwardsItemRewriter<?, ?, ?> itemRewriter;
    private final boolean jsonFormat;

    public EnchantmentRewriter(BackwardsItemRewriter<?, ?, ?> backwardsItemRewriter, boolean bl) {
        this.itemRewriter = backwardsItemRewriter;
        this.jsonFormat = bl;
    }

    public EnchantmentRewriter(BackwardsItemRewriter<?, ?, ?> backwardsItemRewriter) {
        this(backwardsItemRewriter, true);
    }

    public void registerEnchantment(String string, String string2) {
        this.enchantmentMappings.put(Key.stripMinecraftNamespace(string), string2);
    }

    public void handleToClient(Item item) {
        CompoundTag compoundTag = item.tag();
        if (compoundTag == null) {
            return;
        }
        if (compoundTag.getListTag("Enchantments") != null) {
            this.rewriteEnchantmentsToClient(compoundTag, false);
        }
        if (compoundTag.getListTag("StoredEnchantments") != null) {
            this.rewriteEnchantmentsToClient(compoundTag, true);
        }
    }

    public void handleToServer(Item item) {
        CompoundTag compoundTag = item.tag();
        if (compoundTag == null) {
            return;
        }
        if (compoundTag.contains(this.itemRewriter.nbtTagName("Enchantments"))) {
            this.rewriteEnchantmentsToServer(compoundTag, false);
        }
        if (compoundTag.contains(this.itemRewriter.nbtTagName("StoredEnchantments"))) {
            this.rewriteEnchantmentsToServer(compoundTag, true);
        }
    }

    public void rewriteEnchantmentsToClient(CompoundTag compoundTag, boolean bl) {
        Tag tag;
        CompoundTag compoundTag2;
        String string = bl ? "StoredEnchantments" : "Enchantments";
        ListTag<CompoundTag> listTag = compoundTag.getListTag(string, CompoundTag.class);
        ArrayList<StringTag> arrayList = new ArrayList<StringTag>();
        boolean bl2 = false;
        Iterator<CompoundTag> iterator2 = listTag.iterator();
        while (iterator2.hasNext()) {
            String string2;
            String string3;
            compoundTag2 = iterator2.next();
            tag = compoundTag2.getStringTag("id");
            if (tag == null || (string3 = this.enchantmentMappings.get(string2 = Key.stripMinecraftNamespace(((StringTag)tag).getValue()))) == null) continue;
            if (!bl2) {
                this.itemRewriter.saveListTag(compoundTag, listTag, string);
                bl2 = true;
            }
            iterator2.remove();
            NumberTag numberTag = compoundTag2.getNumberTag("lvl");
            int n = numberTag != null ? numberTag.asInt() : 1;
            Object object = this.jsonFormat ? ChatUtil.legacyToJsonString(string3, ENCHANTMENT_LEVEL_TRANSLATION.formatted(n), true) : string3 + " " + EnchantmentRewriter.getRomanNumber(n);
            arrayList.add(new StringTag((String)object));
        }
        if (!arrayList.isEmpty()) {
            if (!bl && listTag.isEmpty()) {
                compoundTag2 = new CompoundTag();
                compoundTag2.putString("id", "");
                compoundTag2.putShort("lvl", (short)0);
                listTag.add(compoundTag2);
            }
            if ((compoundTag2 = compoundTag.getCompoundTag("display")) == null) {
                compoundTag2 = new CompoundTag();
                compoundTag.put("display", compoundTag2);
            }
            if ((tag = compoundTag2.getListTag("Lore", StringTag.class)) == null) {
                tag = new ListTag<StringTag>(StringTag.class);
                compoundTag2.put("Lore", tag);
            } else {
                this.itemRewriter.saveListTag(compoundTag2, (ListTag<?>)tag, "Lore");
            }
            arrayList.addAll((Collection<StringTag>)((ListTag)tag).getValue());
            ((ListTag)tag).setValue(arrayList);
        }
    }

    public void rewriteEnchantmentsToServer(CompoundTag compoundTag, boolean bl) {
        String string = bl ? "StoredEnchantments" : "Enchantments";
        this.itemRewriter.restoreListTag(compoundTag, string);
    }

    public static String getRomanNumber(int n) {
        return switch (n) {
            case 1 -> "I";
            case 2 -> "II";
            case 3 -> "III";
            case 4 -> "IV";
            case 5 -> "V";
            case 6 -> "VI";
            case 7 -> "VII";
            case 8 -> "VIII";
            case 9 -> "IX";
            case 10 -> "X";
            default -> ENCHANTMENT_LEVEL_TRANSLATION.formatted(n);
        };
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.api.rewriters;

import com.viaversion.nbt.tag.ByteTag;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.api.rewriters.EnchantmentRewriter;
import com.viaversion.viaversion.api.minecraft.item.Item;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LegacyEnchantmentRewriter {
    private final Map<Short, String> enchantmentMappings = new HashMap<Short, String>();
    private final String nbtTagName;
    private final boolean dummyEnchantment;
    private Set<Short> hideLevelForEnchants;

    public LegacyEnchantmentRewriter(String string) {
        this(string, true);
    }

    public LegacyEnchantmentRewriter(String string, boolean bl) {
        this.nbtTagName = string;
        this.dummyEnchantment = bl;
    }

    public void registerEnchantment(int n, String string) {
        this.enchantmentMappings.put((short)n, string);
    }

    public void handleToClient(Item item) {
        CompoundTag compoundTag = item.tag();
        if (compoundTag == null) {
            return;
        }
        if (compoundTag.getListTag("ench") != null) {
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
        if (compoundTag.getListTag(this.nbtTagName + "|ench", CompoundTag.class) != null) {
            this.rewriteEnchantmentsToServer(compoundTag, false);
        }
        if (compoundTag.getListTag(this.nbtTagName + "|StoredEnchantments", CompoundTag.class) != null) {
            this.rewriteEnchantmentsToServer(compoundTag, true);
        }
    }

    public void rewriteEnchantmentsToClient(CompoundTag compoundTag, boolean bl) {
        Tag tag;
        String string = bl ? "StoredEnchantments" : "ench";
        ListTag<CompoundTag> listTag = compoundTag.getListTag(string, CompoundTag.class);
        ListTag<CompoundTag> listTag2 = new ListTag<CompoundTag>(CompoundTag.class);
        ArrayList<StringTag> arrayList = new ArrayList<StringTag>();
        Object object = ((ListTag)listTag.copy()).iterator();
        while (object.hasNext()) {
            short s;
            short s2;
            String string2;
            tag = (CompoundTag)object.next();
            NumberTag numberTag = ((CompoundTag)tag).getNumberTag("id");
            if (numberTag == null || (string2 = this.enchantmentMappings.get(s2 = numberTag.asShort())) == null) continue;
            listTag.remove((CompoundTag)tag);
            NumberTag numberTag2 = ((CompoundTag)tag).getNumberTag("lvl");
            short s3 = s = numberTag2 != null ? numberTag2.asShort() : (short)1;
            if (this.hideLevelForEnchants != null && this.hideLevelForEnchants.contains(s2)) {
                arrayList.add(new StringTag(string2));
            } else {
                arrayList.add(new StringTag(string2 + " " + EnchantmentRewriter.getRomanNumber(s)));
            }
            listTag2.add((CompoundTag)tag);
        }
        if (!arrayList.isEmpty()) {
            if (this.dummyEnchantment && !bl && listTag.isEmpty()) {
                object = new CompoundTag();
                ((CompoundTag)object).putShort("id", (short)0);
                ((CompoundTag)object).putShort("lvl", (short)0);
                listTag.add((CompoundTag)object);
                compoundTag.put(this.nbtTagName + "|dummyEnchant", new ByteTag(false));
                tag = compoundTag.getNumberTag("HideFlags");
                if (tag == null) {
                    tag = new IntTag();
                } else {
                    compoundTag.putInt(this.nbtTagName + "|oldHideFlags", tag.asByte());
                }
                int n = tag.asByte() | 1;
                compoundTag.putInt("HideFlags", n);
            }
            compoundTag.put(this.nbtTagName + "|" + string, listTag2);
            object = compoundTag.getCompoundTag("display");
            if (object == null) {
                object = new CompoundTag();
                compoundTag.put("display", (Tag)object);
            }
            if ((tag = ((CompoundTag)object).getListTag("Lore", StringTag.class)) == null) {
                tag = new ListTag<StringTag>(StringTag.class);
                ((CompoundTag)object).put("Lore", tag);
            }
            arrayList.addAll((Collection<StringTag>)((ListTag)tag).getValue());
            ((ListTag)tag).setValue(arrayList);
        }
    }

    public void rewriteEnchantmentsToServer(CompoundTag compoundTag, boolean bl) {
        Object object;
        Tag tag;
        Tag tag2;
        Object object2;
        String string = bl ? "StoredEnchantments" : "ench";
        ListTag<CompoundTag> listTag = compoundTag.getListTag(string, CompoundTag.class);
        if (listTag == null) {
            listTag = new ListTag<CompoundTag>(CompoundTag.class);
        }
        if (!bl && compoundTag.remove(this.nbtTagName + "|dummyEnchant") != null) {
            object2 = ((ListTag)listTag.copy()).iterator();
            while (object2.hasNext()) {
                short s;
                tag2 = (CompoundTag)object2.next();
                tag = ((CompoundTag)tag2).getNumberTag("id");
                object = ((CompoundTag)tag2).getNumberTag("lvl");
                short s2 = tag != null ? tag.asShort() : (short)0;
                short s3 = s = object != null ? object.asShort() : (short)0;
                if (s2 != 0 || s != 0) continue;
                listTag.remove((CompoundTag)tag2);
            }
            object2 = compoundTag.remove(this.nbtTagName + "|oldHideFlags");
            if (object2 instanceof IntTag) {
                tag2 = (IntTag)object2;
                compoundTag.putInt("HideFlags", ((IntTag)tag2).asByte());
            } else {
                compoundTag.remove("HideFlags");
            }
        }
        tag2 = (object2 = compoundTag.getCompoundTag("display")) != null ? ((CompoundTag)object2).getListTag("Lore", StringTag.class) : null;
        tag = (ListTag)compoundTag.remove(this.nbtTagName + "|" + string);
        object = ((ListTag)((ListTag)tag).copy()).iterator();
        while (object.hasNext()) {
            CompoundTag compoundTag2 = (CompoundTag)object.next();
            listTag.add(compoundTag2);
            if (tag2 == null || ((ListTag)tag2).isEmpty()) continue;
            ((ListTag)tag2).remove((StringTag)((ListTag)tag2).get(0));
        }
        if (tag2 != null && ((ListTag)tag2).isEmpty()) {
            ((CompoundTag)object2).remove("Lore");
            if (((CompoundTag)object2).isEmpty()) {
                compoundTag.remove("display");
            }
        }
        compoundTag.put(string, listTag);
    }

    public void setHideLevelForEnchants(int ... nArray) {
        this.hideLevelForEnchants = new HashSet<Short>();
        for (int n : nArray) {
            this.hideLevelForEnchants.add((short)n);
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.api.data;

import com.google.common.base.Preconditions;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.ViaBackwards;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.data.BackwardsMappingDataLoader;
import com.viaversion.viabackwards.api.data.ItemMappings;
import com.viaversion.viabackwards.api.data.MappedItem;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.data.BiMappings;
import com.viaversion.viaversion.api.data.IdentityMappings;
import com.viaversion.viaversion.api.data.MappingData;
import com.viaversion.viaversion.api.data.MappingDataBase;
import com.viaversion.viaversion.api.data.Mappings;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectArrayMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectOpenHashMap;
import com.viaversion.viaversion.util.Key;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.qual.Nullable;

public class BackwardsMappingData
extends MappingDataBase {
    private final Class<? extends Protocol<?, ?, ?, ?>> vvProtocolClass;
    protected Int2ObjectMap<MappedItem> backwardsItemMappings;
    private Int2ObjectMap<String> enchantmentNames;

    public BackwardsMappingData(String string, String string2) {
        this(string, string2, null);
    }

    public BackwardsMappingData(String string, String string2, @Nullable Class<? extends Protocol<?, ?, ?, ?>> clazz) {
        super(string, string2);
        Preconditions.checkArgument(clazz == null || !BackwardsProtocol.class.isAssignableFrom(clazz));
        this.vvProtocolClass = clazz;
    }

    @Override
    protected void loadExtras(CompoundTag compoundTag) {
        CompoundTag compoundTag2 = compoundTag.getCompoundTag("custom_model_data");
        if (compoundTag2 != null) {
            Preconditions.checkNotNull(this.itemMappings);
            this.backwardsItemMappings = new Int2ObjectOpenHashMap<MappedItem>(compoundTag2.size());
            this.loadBackwardsItemMappings(compoundTag2);
        }
        this.enchantmentNames = this.loadNameByIdMappings(compoundTag, "enchantmentnames");
    }

    protected void loadBackwardsItemMappings(CompoundTag compoundTag) {
        for (Map.Entry<String, Tag> entry : compoundTag.entrySet()) {
            int n = Integer.parseInt(entry.getKey());
            int n2 = ((NumberTag)entry.getValue()).asInt();
            String string = this.getFullItemMappings().identifier(n);
            String string2 = this.unmappedVersion + " " + BackwardsMappingData.nameFromIdentifier(string);
            this.backwardsItemMappings.put(n, new MappedItem(this.getNewItemId(n), string, string2, n2));
        }
    }

    private @Nullable Int2ObjectMap<String> loadNameByIdMappings(CompoundTag compoundTag, String string) {
        CompoundTag compoundTag2 = compoundTag.getCompoundTag(string);
        if (compoundTag2 == null) {
            return null;
        }
        Int2ObjectArrayMap<String> int2ObjectArrayMap = new Int2ObjectArrayMap<String>(compoundTag2.size());
        for (Map.Entry<String, Tag> entry : compoundTag2.entrySet()) {
            StringTag stringTag = (StringTag)entry.getValue();
            int2ObjectArrayMap.put(Integer.parseInt(entry.getKey()), stringTag.getValue());
        }
        return int2ObjectArrayMap;
    }

    @Override
    protected @Nullable BiMappings loadBiMappings(CompoundTag compoundTag, String string) {
        if (string.equals("items") && this.vvProtocolClass != null) {
            Mappings mappings = super.loadMappings(compoundTag, string);
            MappingData mappingData = Via.getManager().getProtocolManager().getProtocol(this.vvProtocolClass).getMappingData();
            if (mappingData != null && mappingData.getItemMappings() != null) {
                BiMappings biMappings = mappingData.getItemMappings();
                if (mappings == null) {
                    mappings = new IdentityMappings(biMappings.mappedSize(), biMappings.size());
                }
                return ItemMappings.of(mappings, biMappings);
            }
        }
        return super.loadBiMappings(compoundTag, string);
    }

    @Override
    public int getNewItemId(int n) {
        return this.itemMappings.getNewId(n);
    }

    @Override
    public int getNewBlockId(int n) {
        return this.blockMappings.getNewId(n);
    }

    @Override
    public int getOldItemId(int n) {
        return this.checkValidity(n, this.itemMappings.inverse().getNewId(n), "item");
    }

    @Override
    public int getNewAttributeId(int n) {
        return this.attributeMappings.getNewId(n);
    }

    public @Nullable MappedItem getMappedItem(int n) {
        return this.backwardsItemMappings != null ? (MappedItem)this.backwardsItemMappings.get(n) : null;
    }

    public @Nullable String getMappedNamedSound(String string) {
        return this.getFullSoundMappings().mappedIdentifier(string);
    }

    public @Nullable String mappedEnchantmentName(int n) {
        if (this.enchantmentNames == null) {
            ViaBackwards.getPlatform().getLogger().log(Level.SEVERE, "No enchantment name mappings found when requesting " + n, new RuntimeException());
            return null;
        }
        return (String)this.enchantmentNames.get(n);
    }

    public @Nullable Int2ObjectMap<MappedItem> getBackwardsItemMappings() {
        return this.backwardsItemMappings;
    }

    public @Nullable Class<? extends Protocol<?, ?, ?, ?>> getViaVersionProtocolClass() {
        return this.vvProtocolClass;
    }

    @Override
    protected Logger getLogger() {
        return ViaBackwards.getPlatform().getLogger();
    }

    @Override
    protected @Nullable CompoundTag readMappingsFile(String string) {
        return BackwardsMappingDataLoader.INSTANCE.loadNBTFromDir(string);
    }

    public static String nameFromIdentifier(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string2 : Key.stripMinecraftNamespace(string).split("_")) {
            stringBuilder.append(' ').append(Character.toUpperCase(string2.charAt(0))).append(string2.substring(1));
        }
        return stringBuilder.substring(1);
    }
}


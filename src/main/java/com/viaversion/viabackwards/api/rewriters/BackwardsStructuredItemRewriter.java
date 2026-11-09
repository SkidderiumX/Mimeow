/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.api.rewriters;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.FloatTag;
import com.viaversion.nbt.tag.IntArrayTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.ViaBackwards;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.data.BackwardsMappingData;
import com.viaversion.viabackwards.api.data.MappedItem;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.EitherHolder;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.HolderSet;
import com.viaversion.viaversion.api.minecraft.SoundEvent;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.data.CustomModelData1_21_4;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.ServerboundPacketType;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.rewriter.StructuredItemRewriter;
import com.viaversion.viaversion.util.ArrayUtil;
import com.viaversion.viaversion.util.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import org.checkerframework.checker.nullness.qual.Nullable;

public class BackwardsStructuredItemRewriter<C extends ClientboundPacketType, S extends ServerboundPacketType, T extends BackwardsProtocol<C, ?, ?, S>>
extends StructuredItemRewriter<C, S, T> {
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final String GLOBAL_MODEL_DATA_MARKER = "VB|injected_cmd";
    private final String nbtTagName;

    public BackwardsStructuredItemRewriter(T t) {
        super(t);
        this.nbtTagName = "VB|" + t.getClass().getSimpleName();
    }

    @Override
    protected void backupInconvertibleData(UserConnection userConnection, Item item, StructuredDataContainer structuredDataContainer, CompoundTag compoundTag) {
        MappedItem mappedItem;
        super.backupInconvertibleData(userConnection, item, structuredDataContainer, compoundTag);
        BackwardsMappingData backwardsMappingData = ((BackwardsProtocol)this.protocol).getMappingData();
        MappedItem mappedItem2 = mappedItem = backwardsMappingData != null ? backwardsMappingData.getMappedItem(item.identifier()) : null;
        if (mappedItem == null) {
            return;
        }
        CompoundTag compoundTag2 = this.createCustomTag(item);
        compoundTag2.putInt(this.nbtTagName("id"), item.identifier());
        if (ViaBackwards.getConfig().passOriginalItemNameToResourcePacks()) {
            if (userConnection.getProtocolInfo().protocolVersion().newerThanOrEqualTo(ProtocolVersion.v1_21_4)) {
                this.addCustomModelData(item, mappedItem, compoundTag2);
            } else if (!structuredDataContainer.has(StructuredDataKey.CUSTOM_MODEL_DATA1_20_5)) {
                structuredDataContainer.set(StructuredDataKey.CUSTOM_MODEL_DATA1_20_5, mappedItem.customModelData());
            }
        }
        if (!structuredDataContainer.has(StructuredDataKey.CUSTOM_NAME)) {
            structuredDataContainer.set(StructuredDataKey.CUSTOM_NAME, mappedItem.tagName());
            compoundTag2.putBoolean(this.nbtTagName("added_custom_name"), true);
        }
    }

    private void addCustomModelData(Item item, MappedItem mappedItem, CompoundTag compoundTag) {
        StructuredDataContainer structuredDataContainer = item.dataContainer();
        CustomModelData1_21_4 customModelData1_21_4 = structuredDataContainer.get(StructuredDataKey.CUSTOM_MODEL_DATA1_21_4);
        if (customModelData1_21_4 == null) {
            customModelData1_21_4 = new CustomModelData1_21_4(new float[]{mappedItem.customModelData()}, new boolean[0], new String[]{((BackwardsProtocol)this.protocol).getMappingData().getFullItemMappings().identifier(item.identifier())}, EMPTY_INT_ARRAY);
            structuredDataContainer.set(StructuredDataKey.CUSTOM_MODEL_DATA1_21_4, customModelData1_21_4);
            compoundTag.putBoolean(GLOBAL_MODEL_DATA_MARKER, true);
            compoundTag.putBoolean(this.nbtTagName("added_custom_model_data"), true);
        } else if (!compoundTag.contains(GLOBAL_MODEL_DATA_MARKER)) {
            String string = ((BackwardsProtocol)this.protocol).getMappingData().getFullItemMappings().identifier(item.identifier());
            structuredDataContainer.set(StructuredDataKey.CUSTOM_MODEL_DATA1_21_4, new CustomModelData1_21_4(customModelData1_21_4.floats(), customModelData1_21_4.booleans(), ArrayUtil.add(customModelData1_21_4.strings(), string), customModelData1_21_4.colors()));
            compoundTag.putBoolean(GLOBAL_MODEL_DATA_MARKER, true);
            compoundTag.putString(this.nbtTagName("injected_custom_model_data"), string);
        }
    }

    @Override
    protected void restoreBackupData(Item item, StructuredDataContainer structuredDataContainer, CompoundTag compoundTag) {
        Tag tag;
        super.restoreBackupData(item, structuredDataContainer, compoundTag);
        Tag tag2 = this.removeBackupTag(compoundTag, "id");
        if (tag2 instanceof IntTag) {
            tag = (IntTag)tag2;
            item.setIdentifier(tag.asInt());
            this.removeCustomTag(structuredDataContainer, compoundTag);
        }
        if ((tag2 = this.removeBackupTag(compoundTag, "injected_custom_model_data")) instanceof StringTag) {
            tag = (StringTag)tag2;
            compoundTag.remove(GLOBAL_MODEL_DATA_MARKER);
            structuredDataContainer.replace(StructuredDataKey.CUSTOM_MODEL_DATA1_21_4, arg_0 -> BackwardsStructuredItemRewriter.lambda$restoreBackupData$0((StringTag)tag, arg_0));
        } else if (this.removeBackupTag(compoundTag, "added_custom_model_data") != null) {
            compoundTag.remove(GLOBAL_MODEL_DATA_MARKER);
            structuredDataContainer.remove(StructuredDataKey.CUSTOM_MODEL_DATA1_21_4);
        }
    }

    protected void saveListTag(CompoundTag compoundTag, ListTag<?> listTag, String string) {
        String string2 = this.nbtTagName(string);
        if (!compoundTag.contains(string2)) {
            compoundTag.put(string2, listTag.copy());
        }
    }

    public <T extends Tag> @Nullable ListTag<T> removeListTag(CompoundTag compoundTag, String string, Class<T> clazz) {
        String string2 = this.nbtTagName(string);
        ListTag<T> listTag = compoundTag.getListTag(string2, clazz);
        if (listTag == null) {
            return null;
        }
        compoundTag.remove(string2);
        return listTag;
    }

    protected void saveGenericTagList(CompoundTag compoundTag, List<Tag> list, String string) {
        String string2 = this.nbtTagName(string);
        if (!compoundTag.contains(string2)) {
            CompoundTag compoundTag2 = new CompoundTag();
            for (int i = 0; i < list.size(); ++i) {
                compoundTag2.put(Integer.toString(i), list.get(i));
            }
            compoundTag.put(string2, compoundTag2);
        }
    }

    protected List<Tag> removeGenericTagList(CompoundTag compoundTag, String string) {
        String string2 = this.nbtTagName(string);
        CompoundTag compoundTag2 = compoundTag.getCompoundTag(string2);
        if (compoundTag2 == null) {
            return null;
        }
        compoundTag.remove(string2);
        return new ArrayList<Tag>(compoundTag2.values());
    }

    protected Tag holderSetToTag(HolderSet holderSet) {
        if (holderSet.hasIds()) {
            return new IntArrayTag(holderSet.ids());
        }
        return new StringTag(holderSet.tagKey());
    }

    protected HolderSet restoreHolderSet(CompoundTag compoundTag, String string) {
        Tag tag = compoundTag.get(string);
        if (tag == null) {
            return HolderSet.of(EMPTY_INT_ARRAY);
        }
        if (tag instanceof StringTag) {
            StringTag stringTag = (StringTag)tag;
            return HolderSet.of(stringTag.getValue());
        }
        if (tag instanceof IntArrayTag) {
            IntArrayTag intArrayTag = (IntArrayTag)tag;
            return HolderSet.of(intArrayTag.getValue());
        }
        return HolderSet.of(EMPTY_INT_ARRAY);
    }

    protected <V> Tag holderToTag(Holder<V> holder, BiConsumer<V, CompoundTag> biConsumer) {
        if (holder.hasId()) {
            return new IntTag(holder.id());
        }
        CompoundTag compoundTag = new CompoundTag();
        biConsumer.accept(holder.value(), compoundTag);
        return compoundTag;
    }

    protected <V> Tag eitherHolderToTag(EitherHolder<V> eitherHolder, BiConsumer<V, CompoundTag> biConsumer) {
        if (eitherHolder.hasKey()) {
            return new StringTag(eitherHolder.key());
        }
        return this.holderToTag(eitherHolder.holder(), biConsumer);
    }

    protected <V> void saveEitherHolderData(StructuredDataKey<EitherHolder<V>> structuredDataKey, StructuredDataContainer structuredDataContainer, CompoundTag compoundTag, BiConsumer<V, CompoundTag> biConsumer) {
        EitherHolder<V> eitherHolder = structuredDataContainer.get(structuredDataKey);
        if (eitherHolder != null) {
            compoundTag.put(structuredDataKey.identifier(), this.eitherHolderToTag(eitherHolder, biConsumer));
        }
    }

    protected <V> void saveHolderData(StructuredDataKey<Holder<V>> structuredDataKey, StructuredDataContainer structuredDataContainer, CompoundTag compoundTag, BiConsumer<V, CompoundTag> biConsumer) {
        Holder<V> holder = structuredDataContainer.get(structuredDataKey);
        if (holder != null) {
            compoundTag.put(structuredDataKey.identifier(), this.holderToTag(holder, biConsumer));
        }
    }

    protected <V> Holder<V> restoreHolder(CompoundTag compoundTag, String string, Function<CompoundTag, V> function) {
        Tag tag = compoundTag.get(string);
        if (tag == null) {
            return Holder.of(false);
        }
        if (tag instanceof IntTag) {
            IntTag intTag = (IntTag)tag;
            return Holder.of(intTag.asInt());
        }
        if (tag instanceof CompoundTag) {
            CompoundTag compoundTag2 = (CompoundTag)tag;
            return Holder.of(function.apply(compoundTag2));
        }
        return Holder.of(false);
    }

    protected <V> EitherHolder<V> restoreEitherHolder(CompoundTag compoundTag, String string, Function<CompoundTag, V> function) {
        Tag tag = compoundTag.get(string);
        if (tag == null) {
            return EitherHolder.of(Holder.of(false));
        }
        if (tag instanceof StringTag) {
            StringTag stringTag = (StringTag)tag;
            return EitherHolder.of(stringTag.getValue());
        }
        return EitherHolder.of(this.restoreHolder(compoundTag, string, function));
    }

    protected <V> void restoreHolderData(StructuredDataKey<Holder<V>> structuredDataKey, StructuredDataContainer structuredDataContainer, CompoundTag compoundTag, Function<CompoundTag, V> function) {
        if (compoundTag.contains(structuredDataKey.identifier())) {
            structuredDataContainer.set(structuredDataKey, this.restoreHolder(compoundTag, structuredDataKey.identifier(), function));
        }
    }

    protected void saveStringData(StructuredDataKey<String> structuredDataKey, StructuredDataContainer structuredDataContainer, CompoundTag compoundTag) {
        String string = structuredDataContainer.get(structuredDataKey);
        if (string != null) {
            compoundTag.putString(structuredDataKey.identifier(), string);
        }
    }

    protected void restoreStringData(StructuredDataKey<String> structuredDataKey, StructuredDataContainer structuredDataContainer, CompoundTag compoundTag) {
        String string = compoundTag.getString(structuredDataKey.identifier());
        if (string != null) {
            structuredDataContainer.set(structuredDataKey, string);
        }
    }

    protected void saveKeyData(StructuredDataKey<Key> structuredDataKey, StructuredDataContainer structuredDataContainer, CompoundTag compoundTag) {
        Key key = structuredDataContainer.get(structuredDataKey);
        if (key != null) {
            compoundTag.putString(structuredDataKey.identifier(), key.original());
        }
    }

    protected void restoreKeyData(StructuredDataKey<Key> structuredDataKey, StructuredDataContainer structuredDataContainer, CompoundTag compoundTag) {
        String string = compoundTag.getString(structuredDataKey.identifier());
        if (string != null) {
            structuredDataContainer.set(structuredDataKey, Key.of(string));
        }
    }

    protected void saveIntData(StructuredDataKey<Integer> structuredDataKey, StructuredDataContainer structuredDataContainer, CompoundTag compoundTag) {
        Integer n = structuredDataContainer.get(structuredDataKey);
        if (n != null) {
            compoundTag.putInt(structuredDataKey.identifier(), n);
        }
    }

    protected void restoreIntData(StructuredDataKey<Integer> structuredDataKey, StructuredDataContainer structuredDataContainer, CompoundTag compoundTag) {
        IntTag intTag = compoundTag.getIntTag(structuredDataKey.identifier());
        if (intTag != null) {
            structuredDataContainer.set(structuredDataKey, intTag.asInt());
        }
    }

    protected void saveFloatData(StructuredDataKey<Float> structuredDataKey, StructuredDataContainer structuredDataContainer, CompoundTag compoundTag) {
        Float f = structuredDataContainer.get(structuredDataKey);
        if (f != null) {
            compoundTag.putFloat(structuredDataKey.identifier(), f.floatValue());
        }
    }

    protected void restoreFloatData(StructuredDataKey<Float> structuredDataKey, StructuredDataContainer structuredDataContainer, CompoundTag compoundTag) {
        FloatTag floatTag = compoundTag.getFloatTag(structuredDataKey.identifier());
        if (floatTag != null) {
            structuredDataContainer.set(structuredDataKey, Float.valueOf(floatTag.asFloat()));
        }
    }

    protected void saveSoundEventHolder(CompoundTag compoundTag, Holder<SoundEvent> holder) {
        compoundTag.put("sound_event", this.holderToTag(holder, this::saveSoundEvent));
    }

    protected void saveSoundEvent(SoundEvent soundEvent, CompoundTag compoundTag) {
        compoundTag.putString("identifier", soundEvent.identifier());
        if (soundEvent.fixedRange() != null) {
            compoundTag.putFloat("fixed_range", soundEvent.fixedRange().floatValue());
        }
    }

    protected Holder<SoundEvent> restoreSoundEventHolder(CompoundTag compoundTag) {
        return this.restoreSoundEventHolder(compoundTag, "sound_event");
    }

    protected Holder<SoundEvent> restoreSoundEventHolder(CompoundTag compoundTag2, String string) {
        return this.restoreHolder(compoundTag2, string, compoundTag -> {
            String string_r = compoundTag.getString("identifier");
            FloatTag floatTag = compoundTag.getFloatTag("fixed_range");
            return new SoundEvent(string_r, floatTag != null ? Float.valueOf(floatTag.asFloat()) : null);
        });
    }

    @Override
    public String nbtTagName() {
        return this.nbtTagName;
    }

    private static /* synthetic */ CustomModelData1_21_4 lambda$restoreBackupData$0(StringTag stringTag, CustomModelData1_21_4 customModelData1_21_4) {
        String string = stringTag.getValue();
        String[] stringArray = customModelData1_21_4.strings();
        for (int i = 0; i < stringArray.length; ++i) {
            if (!stringArray[i].equals(string)) continue;
            String[] stringArray2 = ArrayUtil.remove(stringArray, i);
            return new CustomModelData1_21_4(customModelData1_21_4.floats(), customModelData1_21_4.booleans(), stringArray2, customModelData1_21_4.colors());
        }
        return customModelData1_21_4;
    }
}


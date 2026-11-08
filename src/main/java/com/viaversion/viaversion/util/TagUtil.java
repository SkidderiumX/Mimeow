/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.util;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.util.Key;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.Nullable;

public class TagUtil {
    public static ListTag<CompoundTag> getRegistryEntries(CompoundTag compoundTag, String string) {
        return TagUtil.getRegistryEntries(compoundTag, string, null);
    }

    public static ListTag<CompoundTag> getRegistryEntries(CompoundTag compoundTag, String string, @Nullable ListTag<CompoundTag> listTag) {
        CompoundTag compoundTag2 = TagUtil.getNamespacedCompoundTag(compoundTag, string);
        if (compoundTag2 == null) {
            return listTag;
        }
        return compoundTag2.getListTag("value", CompoundTag.class);
    }

    public static ListTag<CompoundTag> removeRegistryEntries(CompoundTag compoundTag, String string) {
        return TagUtil.removeRegistryEntries(compoundTag, string, null);
    }

    public static ListTag<CompoundTag> removeRegistryEntries(CompoundTag compoundTag, String string, @Nullable ListTag<CompoundTag> listTag) {
        String string2 = TagUtil.getNamespacedTagKey(compoundTag, string);
        CompoundTag compoundTag2 = compoundTag.getCompoundTag(string2);
        if (compoundTag2 == null) {
            return listTag;
        }
        compoundTag.remove(string2);
        return compoundTag2.getListTag("value", CompoundTag.class);
    }

    public static boolean removeNamespaced(CompoundTag compoundTag, String string) {
        return compoundTag.remove(Key.namespaced(string)) != null || compoundTag.remove(Key.stripMinecraftNamespace(string)) != null;
    }

    public static boolean containsNamespaced(CompoundTag compoundTag, String string) {
        return compoundTag.contains(Key.namespaced(string)) || compoundTag.contains(Key.stripMinecraftNamespace(string));
    }

    public static String getNamespacedTagKey(CompoundTag compoundTag, String string) {
        return compoundTag.contains(Key.namespaced(string)) ? Key.namespaced(string) : Key.stripMinecraftNamespace(string);
    }

    public static @Nullable Tag getNamespacedTag(CompoundTag compoundTag, String string) {
        Tag tag = compoundTag.get(Key.namespaced(string));
        return tag != null ? tag : compoundTag.get(Key.stripMinecraftNamespace(string));
    }

    public static @Nullable CompoundTag getNamespacedCompoundTag(CompoundTag compoundTag, String string) {
        CompoundTag compoundTag2 = compoundTag.getCompoundTag(Key.namespaced(string));
        return compoundTag2 != null ? compoundTag2 : compoundTag.getCompoundTag(Key.stripMinecraftNamespace(string));
    }

    public static @Nullable ListTag<? extends Tag> getNamespacedTagList(CompoundTag compoundTag, String string) {
        ListTag<?> listTag = compoundTag.getListTag(Key.namespaced(string));
        return listTag != null ? listTag : compoundTag.getListTag(Key.stripMinecraftNamespace(string));
    }

    public static @Nullable ListTag<CompoundTag> getNamespacedCompoundTagList(CompoundTag compoundTag, String string) {
        ListTag<CompoundTag> listTag = compoundTag.getListTag(Key.namespaced(string), CompoundTag.class);
        return listTag != null ? listTag : compoundTag.getListTag(Key.stripMinecraftNamespace(string), CompoundTag.class);
    }

    public static @Nullable StringTag getNamespacedStringTag(CompoundTag compoundTag, String string) {
        StringTag stringTag = compoundTag.getStringTag(Key.namespaced(string));
        return stringTag != null ? stringTag : compoundTag.getStringTag(Key.stripMinecraftNamespace(string));
    }

    public static @Nullable NumberTag getNamespacedNumberTag(CompoundTag compoundTag, String string) {
        NumberTag numberTag = compoundTag.getNumberTag(Key.namespaced(string));
        return numberTag != null ? numberTag : compoundTag.getNumberTag(Key.stripMinecraftNamespace(string));
    }

    public static Tag handleDeep(Tag tag, TagUpdater tagUpdater) {
        return TagUtil.handleDeep(null, tag, tagUpdater);
    }

    private static Tag handleDeep(@Nullable String string, Tag tag, TagUpdater tagUpdater) {
        if (tag instanceof CompoundTag) {
            CompoundTag compoundTag = (CompoundTag)tag;
            for (Map.Entry<String, Tag> entry : compoundTag.entrySet()) {
                Tag tag2 = TagUtil.handleDeep(entry.getKey(), entry.getValue(), tagUpdater);
                entry.setValue(tag2);
            }
        } else if (tag instanceof ListTag) {
            ListTag listTag = (ListTag)tag;
            TagUtil.handleListTag(listTag, tagUpdater);
        }
        return tagUpdater.update(string, tag);
    }

    private static <T extends Tag> void handleListTag(ListTag<T> listTag, TagUpdater tagUpdater) {
        listTag.getValue().replaceAll(tag -> TagUtil.handleDeep(null, tag, tagUpdater));
    }

    @FunctionalInterface
    public static interface TagUpdater {
        public Tag update(@Nullable String var1, Tag var2);
    }
}


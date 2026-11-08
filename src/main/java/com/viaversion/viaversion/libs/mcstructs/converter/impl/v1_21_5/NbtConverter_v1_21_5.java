/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.converter.impl.v1_21_5;

import com.viaversion.nbt.tag.ByteArrayTag;
import com.viaversion.nbt.tag.ByteTag;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntArrayTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.LongArrayTag;
import com.viaversion.nbt.tag.LongTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.libs.mcstructs.converter.DataConverter;
import com.viaversion.viaversion.libs.mcstructs.converter.impl.v1_20_3.NbtConverter_v1_20_3;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Result;
import com.viaversion.viaversion.libs.mcstructs.snbt.SNbt;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

public class NbtConverter_v1_21_5
extends NbtConverter_v1_20_3 {
    public static final NbtConverter_v1_21_5 INSTANCE = new NbtConverter_v1_21_5();

    @Override
    public DataConverter<Tag> forkIfDefault() {
        return this == INSTANCE ? new NbtConverter_v1_21_5() : this;
    }

    public NbtConverter_v1_21_5() {
        this(SNbt.V1_21_5);
    }

    protected NbtConverter_v1_21_5(SNbt<CompoundTag> sNbt) {
        super(sNbt);
    }

    @Override
    public Result<Tag> mergeList(@Nullable Tag tag2, List<Tag> list) {
        Tag tag3;
        Object object;
        ListType listType;
        if (tag2 == null) {
            listType = ListType.LIST;
        } else if (tag2 instanceof ByteArrayTag) {
            listType = ((ByteArrayTag)tag2).length() == 0 ? ListType.LIST : ListType.BYTE;
        } else if (tag2 instanceof IntArrayTag) {
            listType = ((IntArrayTag)tag2).length() == 0 ? ListType.LIST : ListType.INT;
        } else if (tag2 instanceof LongArrayTag) {
            listType = ((LongArrayTag)tag2).length() == 0 ? ListType.LIST : ListType.LONG;
        } else if (tag2 instanceof ListTag) {
            object = (ListTag)tag2;
            listType = CompoundTag.class == ((ListTag)object).getElementType() ? ListType.MIXED_LIST : ListType.LIST;
        } else {
            return Result.error("Invalid list tag: " + tag2);
        }
        Object object2 = object = tag2 == null ? Result.success(new ArrayList()) : this.asList(tag2);
        if (object.isError()) {
            return object.mapError();
        }
        List<Tag> list2 = object.get();
        list2.addAll(list);
        if (list2.isEmpty()) {
            return Result.success(new ListTag());
        }
        if (listType.equals((Object)ListType.BYTE)) {
            if (list2.stream().allMatch(tag -> tag instanceof ByteTag)) {
                byte[] byArray = new byte[list2.size()];
                for (int i = 0; i < list2.size(); ++i) {
                    byArray[i] = ((ByteTag)list2.get(i)).getValue();
                }
                return Result.success(new ByteArrayTag(byArray));
            }
        } else if (listType.equals((Object)ListType.INT)) {
            if (list2.stream().allMatch(tag -> tag instanceof IntTag)) {
                int[] nArray = new int[list2.size()];
                for (int i = 0; i < list2.size(); ++i) {
                    nArray[i] = ((IntTag)list2.get(i)).getValue();
                }
                return Result.success(new IntArrayTag(nArray));
            }
        } else if (listType.equals((Object)ListType.LONG)) {
            if (list2.stream().allMatch(tag -> tag instanceof LongTag)) {
                long[] lArray = new long[list2.size()];
                for (int i = 0; i < list2.size(); ++i) {
                    lArray[i] = ((LongTag)list2.get(i)).getValue();
                }
                return Result.success(new LongArrayTag(lArray));
            }
        } else if (listType.equals((Object)ListType.LIST)) {
            tag3 = null;
            for (Tag tag4 : list2) {
                if (tag3 == null) {
                    tag3 = tag4;
                    continue;
                }
                if (tag3.equals(tag4)) continue;
                tag3 = null;
                break;
            }
            if (tag3 != null) {
                return Result.success(new ListTag<Tag>(list2));
            }
        }
        tag3 = new ListTag();
        for (Tag tag4 : list2) {
            boolean bl;
            boolean bl2 = bl = tag4 instanceof CompoundTag && ((CompoundTag)tag4).size() == 1 && ((CompoundTag)tag4).contains("");
            if (tag4 instanceof CompoundTag && !bl) {
                ((ListTag)tag3).add(tag4);
                continue;
            }
            CompoundTag compoundTag = new CompoundTag();
            compoundTag.put("", tag4);
            ((ListTag)tag3).add(compoundTag);
        }
        return Result.success(tag3);
    }

    private static enum ListType {
        BYTE,
        INT,
        LONG,
        LIST,
        MIXED_LIST;

    }
}


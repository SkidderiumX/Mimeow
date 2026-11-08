/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.nbt.tag;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.Tag;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class MixedListTag
extends ListTag<Tag> {
    public MixedListTag() {
    }

    public MixedListTag(List<Tag> list) {
        super(list);
    }

    @Override
    public void setValue(List<Tag> list) {
        this.value = new ArrayList<Tag>(list);
    }

    @Override
    protected void checkAddedTag(Tag tag) {
    }

    @Override
    @Nullable
    public Class<? extends Tag> getElementType() {
        return null;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        if (this.value.isEmpty()) {
            dataOutput.writeByte(0);
        } else {
            dataOutput.writeByte(10);
        }
        dataOutput.writeInt(this.value.size());
        for (Tag tag : this.value) {
            MixedListTag.wrap(tag).write(dataOutput);
        }
    }

    @Override
    public MixedListTag copy() {
        MixedListTag mixedListTag = new MixedListTag();
        mixedListTag.value = new ArrayList(this.value.size());
        for (Tag tag : this.value) {
            mixedListTag.add(tag.copy());
        }
        return mixedListTag;
    }

    private static Tag wrap(Tag tag) {
        if (tag instanceof CompoundTag) {
            return tag;
        }
        CompoundTag compoundTag = new CompoundTag(new LinkedHashMap<String, Tag>(1, 1.0f));
        compoundTag.put("", tag);
        return compoundTag;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft;

import com.google.common.base.Preconditions;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.minecraft.HolderSetImpl;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntFunction;
import java.util.function.ToIntFunction;

public interface HolderSet {
    public static HolderSet of(String string) {
        Preconditions.checkNotNull(string);
        return new HolderSetImpl.Tag(string);
    }

    public static HolderSet of(int[] nArray) {
        Preconditions.checkNotNull(nArray);
        return new HolderSetImpl.Ids(nArray);
    }

    public static HolderSet fromTag(Tag tag, ToIntFunction<String> toIntFunction) {
        if (tag instanceof StringTag) {
            StringTag stringTag = (StringTag)tag;
            if (stringTag.getValue().startsWith("#")) {
                return HolderSet.of(stringTag.getValue().substring(1));
            }
            int n = toIntFunction.applyAsInt(stringTag.getValue());
            return HolderSet.of(new int[]{n});
        }
        if (tag instanceof ListTag) {
            ListTag listTag = (ListTag)tag;
            int[] nArray = new int[listTag.size()];
            for (int i = 0; i < listTag.size(); ++i) {
                String string = ((StringTag)listTag.get(i)).getValue();
                nArray[i] = toIntFunction.applyAsInt(string);
            }
            return HolderSet.of(nArray);
        }
        throw new IllegalArgumentException();
    }

    public String tagKey();

    public boolean hasTagKey();

    public int[] ids();

    public boolean hasIds();

    public HolderSet rewrite(Int2IntFunction var1);
}


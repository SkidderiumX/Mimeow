/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.nbt.tag;

import com.viaversion.nbt.io.TagRegistry;
import com.viaversion.nbt.limiter.TagLimiter;
import com.viaversion.nbt.stringified.SNBT;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.MixedListTag;
import com.viaversion.nbt.tag.Tag;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import org.jetbrains.annotations.Nullable;

public class ListTag<T extends Tag>
implements Tag,
Iterable<T> {
    public static final int ID = 9;
    protected List<T> value;
    private Class<T> type;

    @Deprecated
    public ListTag() {
        this.value = new ArrayList<T>();
    }

    public ListTag(Class<T> clazz) {
        this.type = clazz;
        this.value = new ArrayList<T>();
    }

    private ListTag(Class<T> clazz, List<T> list) {
        this.type = clazz;
        this.value = list;
    }

    public ListTag(List<T> list) {
        this.setValue(list);
    }

    public static ListTag<?> of(List<Tag> list) {
        int n = -1;
        for (Tag tag : list) {
            if (n == -1) {
                n = tag.getTagId();
                continue;
            }
            if (n == tag.getTagId()) continue;
            return new MixedListTag(list);
        }
        return new ListTag<Tag>(list);
    }

    public static ListTag<?> read(DataInput dataInput, TagLimiter tagLimiter, int n) throws IOException {
        tagLimiter.checkLevel(n);
        tagLimiter.countBytes(5);
        byte by = dataInput.readByte();
        Class<? extends Tag> clazz = null;
        if (by != 0 && (clazz = TagRegistry.getClassFor(by)) == null) {
            throw new IOException("Unknown tag ID in ListTag: " + by);
        }
        return ListTag.read(dataInput, by, clazz, tagLimiter, n);
    }

    private static <T extends Tag> ListTag<?> read(DataInput dataInput, int n, Class<T> clazz, TagLimiter tagLimiter, int n2) throws IOException {
        int n3 = dataInput.readInt();
        ListTag<T> listTag = new ListTag<T>(clazz, new ArrayList(Math.min(n3, Short.MAX_VALUE)));
        int n4 = n2 + 1;
        for (int i = 0; i < n3; ++i) {
            Tag tag;
            try {
                tag = TagRegistry.read(n, dataInput, tagLimiter, n4);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                throw new IOException("Failed to create tag.", illegalArgumentException);
            }
            Tag tag2 = ListTag.unwrap(tag);
            if (tag2 != null) {
                MixedListTag mixedListTag = new MixedListTag(listTag.value);
                mixedListTag.add(tag2);
                int n5 = n3 - i - 1;
                return ListTag.readMixed(mixedListTag, dataInput, tagLimiter, n2, n5);
            }
            listTag.value.add(tag);
        }
        return listTag;
    }

    private static MixedListTag readMixed(MixedListTag mixedListTag, DataInput dataInput, TagLimiter tagLimiter, int n, int n2) throws IOException {
        for (int i = 0; i < n2; ++i) {
            Tag tag;
            try {
                tag = TagRegistry.read(10, dataInput, tagLimiter, n);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                throw new IOException("Failed to create tag.", illegalArgumentException);
            }
            Tag tag2 = ListTag.unwrap(tag);
            mixedListTag.add(tag2 != null ? tag2 : tag);
        }
        return mixedListTag;
    }

    @Nullable
    private static Tag unwrap(Tag tag) {
        CompoundTag compoundTag;
        if (tag instanceof CompoundTag && (compoundTag = (CompoundTag)tag).size() == 1) {
            return compoundTag.get("");
        }
        return null;
    }

    @Override
    public List<T> getValue() {
        return this.value;
    }

    @Override
    public String asRawString() {
        return this.value.toString();
    }

    public void setValue(List<T> list) {
        this.value = new ArrayList<T>(list);
        if (!list.isEmpty()) {
            if (this.type == null) {
                this.type = ((Tag)list.get(0)).getClass();
            }
            for (Tag tag : list) {
                this.checkType(tag);
            }
        }
    }

    @Nullable
    public Class<? extends Tag> getElementType() {
        return this.type;
    }

    public boolean add(T t) throws IllegalArgumentException {
        this.checkAddedTag(t);
        return this.value.add(t);
    }

    protected void checkAddedTag(T t) {
        if (this.type == null) {
            this.type = t.getClass();
        } else {
            this.checkType((Tag)t);
        }
    }

    private void checkType(Tag tag) {
        if (tag.getClass() != this.type) {
            throw new IllegalArgumentException("Tag type " + tag.getClass().getSimpleName() + " differs from list type " + this.type.getSimpleName());
        }
    }

    public boolean remove(T t) {
        return this.value.remove(t);
    }

    public T get(int n) {
        return (T)((Tag)this.value.get(n));
    }

    public T set(int n, T t) {
        this.checkAddedTag(t);
        return (T)((Tag)this.value.set(n, t));
    }

    public T remove(int n) {
        return (T)((Tag)this.value.remove(n));
    }

    public int size() {
        return this.value.size();
    }

    public boolean isEmpty() {
        return this.value.isEmpty();
    }

    public Stream<T> stream() {
        return this.value.stream();
    }

    @Override
    public Iterator<T> iterator() {
        return this.value.iterator();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        if (this.value.isEmpty()) {
            dataOutput.writeByte(0);
        } else {
            int n = TagRegistry.getIdFor(this.type);
            if (n == -1) {
                throw new IOException("ListTag contains unregistered tag class.");
            }
            dataOutput.writeByte(n);
        }
        dataOutput.writeInt(this.value.size());
        for (Tag tag : this.value) {
            tag.write(dataOutput);
        }
    }

    @Override
    public ListTag<T> copy() {
        ListTag<Tag> listTag = new ListTag<Tag>(this.type);
        listTag.value = new ArrayList<T>(this.value.size());
        for (Tag tag : this.value) {
            listTag.add(tag.copy());
        }
        return listTag;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        ListTag listTag = (ListTag)object;
        if (!Objects.equals(this.type, listTag.type)) {
            return false;
        }
        return this.value.equals(listTag.value);
    }

    public int hashCode() {
        int n = this.type != null ? this.type.hashCode() : 0;
        n = 31 * n + this.value.hashCode();
        return n;
    }

    @Override
    public int getTagId() {
        return 9;
    }

    public String toString() {
        return SNBT.serialize(this);
    }
}


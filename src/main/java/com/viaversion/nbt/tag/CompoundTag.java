/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.nbt.tag;

import com.viaversion.nbt.io.TagRegistry;
import com.viaversion.nbt.limiter.TagLimiter;
import com.viaversion.nbt.stringified.SNBT;
import com.viaversion.nbt.tag.ByteArrayTag;
import com.viaversion.nbt.tag.ByteTag;
import com.viaversion.nbt.tag.DoubleTag;
import com.viaversion.nbt.tag.FloatTag;
import com.viaversion.nbt.tag.IntArrayTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.LongArrayTag;
import com.viaversion.nbt.tag.LongTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.nbt.tag.ShortTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.Nullable;

public class CompoundTag
implements Tag,
Iterable<Map.Entry<String, Tag>> {
    public static final int ID = 10;
    private Map<String, Tag> value;

    public CompoundTag() {
        this(new LinkedHashMap<String, Tag>(8));
    }

    public CompoundTag(Map<String, Tag> map) {
        this.setValue(map);
    }

    public CompoundTag(LinkedHashMap<String, Tag> linkedHashMap) {
        this.setValue(linkedHashMap);
    }

    public static CompoundTag read(DataInput dataInput, TagLimiter tagLimiter, int n) throws IOException {
        tagLimiter.checkLevel(n);
        int n2 = n + 1;
        CompoundTag compoundTag = new CompoundTag();
        while (true) {
            Tag tag;
            tagLimiter.countByte();
            byte by = dataInput.readByte();
            if (by == 0) break;
            String string = dataInput.readUTF();
            tagLimiter.countBytes(2 * string.length());
            try {
                tag = TagRegistry.read(by, dataInput, tagLimiter, n2);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                throw new IOException("Failed to create tag.", illegalArgumentException);
            }
            compoundTag.value.put(string, tag);
        }
        return compoundTag;
    }

    @Override
    public Map<String, Tag> getValue() {
        return this.value;
    }

    @Override
    public String asRawString() {
        return this.value.toString();
    }

    public void setValue(Map<String, Tag> map) {
        this.setValue(new LinkedHashMap<String, Tag>(map));
    }

    public void setValue(LinkedHashMap<String, Tag> linkedHashMap) {
        for (Map.Entry<String, Tag> entry : linkedHashMap.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) continue;
            throw new IllegalArgumentException("key and value cannot be null");
        }
        this.value = linkedHashMap;
    }

    public boolean isEmpty() {
        return this.value.isEmpty();
    }

    public boolean contains(String string) {
        return this.value.containsKey(string);
    }

    @Nullable
    public Tag get(String string) {
        return this.value.get(string);
    }

    @Nullable
    public <T extends Tag> T getUnchecked(String string) {
        return (T)this.value.get(string);
    }

    @Nullable
    public StringTag getStringTag(String string) {
        Tag tag = this.value.get(string);
        return tag instanceof StringTag ? (StringTag)tag : null;
    }

    @Nullable
    public CompoundTag getCompoundTag(String string) {
        Tag tag = this.value.get(string);
        return tag instanceof CompoundTag ? (CompoundTag)tag : null;
    }

    @Nullable
    public ListTag<?> getListTag(String string) {
        Tag tag = this.value.get(string);
        return tag instanceof ListTag ? (ListTag)tag : null;
    }

    @Nullable
    public <T extends Tag> ListTag<T> getListTag(String string, Class<T> clazz) {
        Tag tag = this.value.get(string);
        if (!(tag instanceof ListTag)) {
            return null;
        }
        Class<Tag> clazz2 = ((ListTag)tag).getElementType();
        return clazz2 == clazz || clazz2 == null ? (ListTag)tag : null;
    }

    @Nullable
    public ListTag<? extends NumberTag> getNumberListTag(String string) {
        Tag tag = this.value.get(string);
        if (!(tag instanceof ListTag)) {
            return null;
        }
        Class<Tag> clazz = ((ListTag)tag).getElementType();
        return clazz == null || NumberTag.class.isAssignableFrom(clazz) ? (ListTag)tag : null;
    }

    @Nullable
    public IntTag getIntTag(String string) {
        Tag tag = this.value.get(string);
        return tag instanceof IntTag ? (IntTag)tag : null;
    }

    @Nullable
    public LongTag getLongTag(String string) {
        Tag tag = this.value.get(string);
        return tag instanceof LongTag ? (LongTag)tag : null;
    }

    @Nullable
    public ShortTag getShortTag(String string) {
        Tag tag = this.value.get(string);
        return tag instanceof ShortTag ? (ShortTag)tag : null;
    }

    @Nullable
    public ByteTag getByteTag(String string) {
        Tag tag = this.value.get(string);
        return tag instanceof ByteTag ? (ByteTag)tag : null;
    }

    @Nullable
    public FloatTag getFloatTag(String string) {
        Tag tag = this.value.get(string);
        return tag instanceof FloatTag ? (FloatTag)tag : null;
    }

    @Nullable
    public DoubleTag getDoubleTag(String string) {
        Tag tag = this.value.get(string);
        return tag instanceof DoubleTag ? (DoubleTag)tag : null;
    }

    @Nullable
    public NumberTag getNumberTag(String string) {
        Tag tag = this.value.get(string);
        return tag instanceof NumberTag ? (NumberTag)tag : null;
    }

    @Nullable
    public ByteArrayTag getByteArrayTag(String string) {
        Tag tag = this.value.get(string);
        return tag instanceof ByteArrayTag ? (ByteArrayTag)tag : null;
    }

    @Nullable
    public IntArrayTag getIntArrayTag(String string) {
        Tag tag = this.value.get(string);
        return tag instanceof IntArrayTag ? (IntArrayTag)tag : null;
    }

    @Nullable
    public LongArrayTag getLongArrayTag(String string) {
        Tag tag = this.value.get(string);
        return tag instanceof LongArrayTag ? (LongArrayTag)tag : null;
    }

    @Nullable
    public String getString(String string) {
        return this.getString(string, null);
    }

    @Nullable
    public String getString(String string, @Nullable String string2) {
        Tag tag = this.value.get(string);
        return tag instanceof StringTag ? ((StringTag)tag).getValue() : string2;
    }

    public int getInt(String string) {
        return this.getInt(string, 0);
    }

    public int getInt(String string, int n) {
        Tag tag = this.value.get(string);
        return tag instanceof NumberTag ? ((NumberTag)tag).asInt() : n;
    }

    public long getLong(String string) {
        return this.getLong(string, 0L);
    }

    public long getLong(String string, long l) {
        Tag tag = this.value.get(string);
        return tag instanceof NumberTag ? ((NumberTag)tag).asLong() : l;
    }

    public short getShort(String string) {
        return this.getShort(string, (short)0);
    }

    public short getShort(String string, short s) {
        Tag tag = this.value.get(string);
        return tag instanceof NumberTag ? ((NumberTag)tag).asShort() : s;
    }

    public byte getByte(String string) {
        return this.getByte(string, (byte)0);
    }

    public byte getByte(String string, byte by) {
        Tag tag = this.value.get(string);
        return tag instanceof NumberTag ? ((NumberTag)tag).asByte() : by;
    }

    public float getFloat(String string) {
        return this.getFloat(string, 0.0f);
    }

    public float getFloat(String string, float f) {
        Tag tag = this.value.get(string);
        return tag instanceof NumberTag ? ((NumberTag)tag).asFloat() : f;
    }

    public double getDouble(String string) {
        return this.getDouble(string, 0.0);
    }

    public double getDouble(String string, double d) {
        Tag tag = this.value.get(string);
        return tag instanceof NumberTag ? ((NumberTag)tag).asDouble() : d;
    }

    public boolean getBoolean(String string) {
        return this.getBoolean(string, false);
    }

    public boolean getBoolean(String string, boolean bl) {
        Tag tag = this.value.get(string);
        return tag instanceof NumberTag ? ((NumberTag)tag).asBoolean() : bl;
    }

    public int getIntStrict(String string) {
        return this.getIntStrict(string, 0);
    }

    public int getIntStrict(String string, int n) {
        Tag tag = this.value.get(string);
        return tag instanceof IntTag ? ((IntTag)tag).asInt() : n;
    }

    public long getLongStrict(String string) {
        return this.getLongStrict(string, 0L);
    }

    public long getLongStrict(String string, long l) {
        Tag tag = this.value.get(string);
        return tag instanceof LongTag ? ((LongTag)tag).asLong() : l;
    }

    public short getShortStrict(String string) {
        return this.getShortStrict(string, (short)0);
    }

    public short getShortStrict(String string, short s) {
        Tag tag = this.value.get(string);
        return tag instanceof ShortTag ? ((ShortTag)tag).asShort() : s;
    }

    public byte getByteStrict(String string) {
        return this.getByteStrict(string, (byte)0);
    }

    public byte getByteStrict(String string, byte by) {
        Tag tag = this.value.get(string);
        return tag instanceof ByteTag ? ((ByteTag)tag).asByte() : by;
    }

    public float getFloatStrict(String string) {
        return this.getFloatStrict(string, 0.0f);
    }

    public float getFloatStrict(String string, float f) {
        Tag tag = this.value.get(string);
        return tag instanceof FloatTag ? ((FloatTag)tag).asFloat() : f;
    }

    public double getDoubleStrict(String string) {
        return this.getDoubleStrict(string, 0.0);
    }

    public double getDoubleStrict(String string, double d) {
        Tag tag = this.value.get(string);
        return tag instanceof DoubleTag ? ((DoubleTag)tag).asDouble() : d;
    }

    @Nullable
    public Tag put(String string, Tag tag) {
        if (tag == null) {
            throw new IllegalArgumentException("Cannot add a null tag");
        }
        if (tag == this) {
            throw new IllegalArgumentException("Cannot add a tag to itself");
        }
        return this.value.put(string, tag);
    }

    public void putString(String string, String string2) {
        this.value.put(string, new StringTag(string2));
    }

    public void putByte(String string, byte by) {
        this.value.put(string, new ByteTag(by));
    }

    public void putInt(String string, int n) {
        this.value.put(string, new IntTag(n));
    }

    public void putShort(String string, short s) {
        this.value.put(string, new ShortTag(s));
    }

    public void putLong(String string, long l) {
        this.value.put(string, new LongTag(l));
    }

    public void putFloat(String string, float f) {
        this.value.put(string, new FloatTag(f));
    }

    public void putDouble(String string, double d) {
        this.value.put(string, new DoubleTag(d));
    }

    public void putBoolean(String string, boolean bl) {
        this.value.put(string, new ByteTag((byte)(bl ? 1 : 0)));
    }

    public void putAll(CompoundTag compoundTag) {
        this.value.putAll(compoundTag.value);
    }

    @Nullable
    public Tag remove(String string) {
        return this.value.remove(string);
    }

    @Nullable
    public <T extends Tag> T removeUnchecked(String string) {
        return (T)this.value.remove(string);
    }

    public Set<String> keySet() {
        return this.value.keySet();
    }

    public Collection<Tag> values() {
        return this.value.values();
    }

    public Set<Map.Entry<String, Tag>> entrySet() {
        return this.value.entrySet();
    }

    public int size() {
        return this.value.size();
    }

    public void clear() {
        this.value.clear();
    }

    @Override
    public Iterator<Map.Entry<String, Tag>> iterator() {
        return this.value.entrySet().iterator();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        for (Map.Entry<String, Tag> entry : this.value.entrySet()) {
            Tag tag = entry.getValue();
            dataOutput.writeByte(tag.getTagId());
            dataOutput.writeUTF(entry.getKey());
            tag.write(dataOutput);
        }
        dataOutput.writeByte(0);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        CompoundTag compoundTag = (CompoundTag)object;
        return this.value.equals(compoundTag.value);
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    @Override
    public CompoundTag copy() {
        LinkedHashMap<String, Tag> linkedHashMap = new LinkedHashMap<String, Tag>(this.value.size());
        for (Map.Entry<String, Tag> entry : this.value.entrySet()) {
            linkedHashMap.put(entry.getKey(), entry.getValue().copy());
        }
        return new CompoundTag(linkedHashMap);
    }

    @Override
    public int getTagId() {
        return 10;
    }

    public String toString() {
        return SNBT.serialize(this);
    }
}


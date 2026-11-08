/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.nbt.io;

import com.viaversion.nbt.limiter.TagLimiter;
import com.viaversion.nbt.tag.ByteArrayTag;
import com.viaversion.nbt.tag.ByteTag;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.DoubleTag;
import com.viaversion.nbt.tag.FloatTag;
import com.viaversion.nbt.tag.IntArrayTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.LongArrayTag;
import com.viaversion.nbt.tag.LongTag;
import com.viaversion.nbt.tag.ShortTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.libs.fastutil.objects.Object2IntMap;
import com.viaversion.viaversion.libs.fastutil.objects.Object2IntOpenHashMap;
import java.io.DataInput;
import java.io.IOException;
import org.jetbrains.annotations.Nullable;

public class TagRegistry {
    public static final int END = 0;
    private static final int HIGHEST_ID = 12;
    private static final RegisteredTagType[] TAGS = new RegisteredTagType[13];
    private static final Object2IntMap<Class<? extends Tag>> TAG_TO_ID = new Object2IntOpenHashMap<Class<? extends Tag>>();

    public static <T extends Tag> void register(int n, Class<T> clazz, TagSupplier<T> tagSupplier) {
        if (n < 0 || n > 12) {
            throw new IllegalArgumentException("Tag ID must be between 0 and 12");
        }
        if (TAGS[n] != null) {
            throw new IllegalArgumentException("Tag ID \"" + n + "\" is already in use.");
        }
        if (TAG_TO_ID.containsKey(clazz)) {
            throw new IllegalArgumentException("Tag \"" + clazz.getSimpleName() + "\" is already registered.");
        }
        TagRegistry.TAGS[n] = new RegisteredTagType(clazz, tagSupplier);
        TAG_TO_ID.put((Class<? extends Tag>)clazz, n);
    }

    @Nullable
    public static Class<? extends Tag> getClassFor(int n) {
        return n >= 0 && n < TAGS.length ? TAGS[n].type : null;
    }

    public static int getIdFor(Class<? extends Tag> clazz) {
        return TAG_TO_ID.getInt(clazz);
    }

    public static Tag read(int n, DataInput dataInput, TagLimiter tagLimiter, int n2) throws IOException {
        TagSupplier tagSupplier;
        TagSupplier tagSupplier2 = tagSupplier = n > 0 && n < TAGS.length ? TAGS[n].supplier : null;
        if (tagSupplier == null) {
            throw new IllegalArgumentException("Could not find tag with ID \"" + n + "\".");
        }
        return tagSupplier.create(dataInput, tagLimiter, n2);
    }

    static {
        TAG_TO_ID.defaultReturnValue(-1);
        TagRegistry.register(1, ByteTag.class, (dataInput, tagLimiter, n) -> ByteTag.read(dataInput, tagLimiter));
        TagRegistry.register(2, ShortTag.class, (dataInput, tagLimiter, n) -> ShortTag.read(dataInput, tagLimiter));
        TagRegistry.register(3, IntTag.class, (dataInput, tagLimiter, n) -> IntTag.read(dataInput, tagLimiter));
        TagRegistry.register(4, LongTag.class, (dataInput, tagLimiter, n) -> LongTag.read(dataInput, tagLimiter));
        TagRegistry.register(5, FloatTag.class, (dataInput, tagLimiter, n) -> FloatTag.read(dataInput, tagLimiter));
        TagRegistry.register(6, DoubleTag.class, (dataInput, tagLimiter, n) -> DoubleTag.read(dataInput, tagLimiter));
        TagRegistry.register(7, ByteArrayTag.class, (dataInput, tagLimiter, n) -> ByteArrayTag.read(dataInput, tagLimiter));
        TagRegistry.register(8, StringTag.class, (dataInput, tagLimiter, n) -> StringTag.read(dataInput, tagLimiter));
        TagRegistry.register(9, ListTag.class, ListTag::read);
        TagRegistry.register(10, CompoundTag.class, CompoundTag::read);
        TagRegistry.register(11, IntArrayTag.class, (dataInput, tagLimiter, n) -> IntArrayTag.read(dataInput, tagLimiter));
        TagRegistry.register(12, LongArrayTag.class, (dataInput, tagLimiter, n) -> LongArrayTag.read(dataInput, tagLimiter));
    }

    private static final class RegisteredTagType {
        private final Class<? extends Tag> type;
        private final TagSupplier<? extends Tag> supplier;

        private <T extends Tag> RegisteredTagType(Class<T> clazz, TagSupplier<T> tagSupplier) {
            this.type = clazz;
            this.supplier = tagSupplier;
        }
    }

    @FunctionalInterface
    public static interface TagSupplier<T extends Tag> {
        public T create(DataInput var1, TagLimiter var2, int var3) throws IOException;
    }
}


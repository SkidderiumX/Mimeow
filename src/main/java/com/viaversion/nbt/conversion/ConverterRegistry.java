/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.nbt.conversion;

import com.viaversion.nbt.conversion.ConversionException;
import com.viaversion.nbt.conversion.TagConverter;
import com.viaversion.nbt.conversion.converter.ByteArrayTagConverter;
import com.viaversion.nbt.conversion.converter.ByteTagConverter;
import com.viaversion.nbt.conversion.converter.CompoundTagConverter;
import com.viaversion.nbt.conversion.converter.DoubleTagConverter;
import com.viaversion.nbt.conversion.converter.FloatTagConverter;
import com.viaversion.nbt.conversion.converter.IntArrayTagConverter;
import com.viaversion.nbt.conversion.converter.IntTagConverter;
import com.viaversion.nbt.conversion.converter.ListTagConverter;
import com.viaversion.nbt.conversion.converter.LongArrayTagConverter;
import com.viaversion.nbt.conversion.converter.LongTagConverter;
import com.viaversion.nbt.conversion.converter.ShortTagConverter;
import com.viaversion.nbt.conversion.converter.StringTagConverter;
import com.viaversion.nbt.io.TagRegistry;
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
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectOpenHashMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.Nullable;

public class ConverterRegistry {
    private static final Int2ObjectMap<TagConverter<? extends Tag, ?>> TAG_TO_CONVERTER = new Int2ObjectOpenHashMap();
    private static final Map<Class<?>, TagConverter<? extends Tag, ?>> TYPE_TO_CONVERTER = new HashMap();

    public static <T extends Tag, V> void register(Class<T> clazz, Class<? extends V> clazz2, TagConverter<T, V> tagConverter) {
        int n = TagRegistry.getIdFor(clazz);
        if (n == -1) {
            throw new IllegalArgumentException("Tag " + clazz.getName() + " is not a registered tag.");
        }
        if (TAG_TO_CONVERTER.containsKey(n)) {
            throw new IllegalArgumentException("Type conversion to tag " + clazz.getName() + " is already registered.");
        }
        if (TYPE_TO_CONVERTER.containsKey(clazz2)) {
            throw new IllegalArgumentException("Tag conversion to type " + clazz2.getName() + " is already registered.");
        }
        TAG_TO_CONVERTER.put(n, (TagConverter<Tag, ?>)tagConverter);
        TYPE_TO_CONVERTER.put(clazz2, tagConverter);
    }

    public static <T extends Tag, V> void unregister(Class<T> clazz, Class<V> clazz2) {
        TAG_TO_CONVERTER.remove(TagRegistry.getIdFor(clazz));
        TYPE_TO_CONVERTER.remove(clazz2);
    }

    @Nullable
    public static <T extends Tag, V> V convertToValue(@Nullable T t) throws ConversionException {
        if (t == null || t.getValue() == null) {
            return null;
        }
        TagConverter tagConverter = (TagConverter)TAG_TO_CONVERTER.get(t.getTagId());
        if (tagConverter == null) {
            throw new ConversionException("Tag type " + t.getClass().getName() + " has no converter.");
        }
        return (V)tagConverter.convert(t);
    }

    @Nullable
    public static <V, T extends Tag> T convertToTag(@Nullable V v) throws ConversionException {
        if (v == null) {
            return null;
        }
        Class<?> clazz = v.getClass();
        TagConverter<Tag, ?> tagConverter = TYPE_TO_CONVERTER.get(clazz);
        if (tagConverter == null) {
            Class<?> clazz2;
            Class<?>[] classArray = clazz.getInterfaces();
            int n = classArray.length;
            for (int i = 0; i < n && (tagConverter = TYPE_TO_CONVERTER.get(clazz2 = classArray[i])) == null; ++i) {
            }
            if (tagConverter == null) {
                throw new ConversionException("Value type " + clazz.getName() + " has no converter.");
            }
        }
        return (T)tagConverter.convert(v);
    }

    static {
        ConverterRegistry.register(ByteTag.class, Byte.class, new ByteTagConverter());
        ConverterRegistry.register(ShortTag.class, Short.class, new ShortTagConverter());
        ConverterRegistry.register(IntTag.class, Integer.class, new IntTagConverter());
        ConverterRegistry.register(LongTag.class, Long.class, new LongTagConverter());
        ConverterRegistry.register(FloatTag.class, Float.class, new FloatTagConverter());
        ConverterRegistry.register(DoubleTag.class, Double.class, new DoubleTagConverter());
        ConverterRegistry.register(ByteArrayTag.class, byte[].class, new ByteArrayTagConverter());
        ConverterRegistry.register(StringTag.class, String.class, new StringTagConverter());
        ConverterRegistry.register(ListTag.class, List.class, new ListTagConverter());
        ConverterRegistry.register(CompoundTag.class, Map.class, new CompoundTagConverter());
        ConverterRegistry.register(IntArrayTag.class, int[].class, new IntArrayTagConverter());
        ConverterRegistry.register(LongArrayTag.class, long[].class, new LongArrayTagConverter());
    }
}


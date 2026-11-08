/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block.properties;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Map;
import net.minecraft.block.properties.PropertyHelper;
import net.minecraft.util.IStringSerializable;

public class PropertyEnum<T extends Enum<T>>
extends PropertyHelper<T> {
    private final ImmutableSet<T> allowedValues;
    private final Map<String, T> nameToValue = Maps.newHashMap();

    protected PropertyEnum(String string, Class<T> clazz, Collection<T> collection) {
        super(string, clazz);
        this.allowedValues = ImmutableSet.copyOf(collection);
        for (Enum enum_ : collection) {
            String string2 = ((IStringSerializable)((Object)enum_)).getName();
            if (this.nameToValue.containsKey(string2)) {
                throw new IllegalArgumentException("Multiple values have the same name '" + string2 + "'");
            }
            this.nameToValue.put(string2, enum_);
        }
    }

    @Override
    public Collection<T> getAllowedValues() {
        return this.allowedValues;
    }

    @Override
    public String getName(T t) {
        return ((IStringSerializable)t).getName();
    }

    public static <T extends Enum<T>> PropertyEnum<T> create(String string, Class<T> clazz) {
        return PropertyEnum.create(string, clazz, Predicates.alwaysTrue());
    }

    public static <T extends Enum<T>> PropertyEnum<T> create(String string, Class<T> clazz, Predicate<T> predicate) {
        return PropertyEnum.create(string, clazz, Collections2.filter(Lists.newArrayList((Enum[])clazz.getEnumConstants()), predicate));
    }

    public static <T extends Enum<T>> PropertyEnum<T> create(String string, Class<T> clazz, T ... TArray) {
        return PropertyEnum.create(string, clazz, Lists.newArrayList(TArray));
    }

    public static <T extends Enum<T>> PropertyEnum<T> create(String string, Class<T> clazz, Collection<T> collection) {
        return new PropertyEnum<T>(string, clazz, collection);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.minecraft.item.data.Filterable;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.ArrayType;
import org.checkerframework.checker.nullness.qual.Nullable;

public class FilterableString
extends Filterable<String> {
    public static final Type<FilterableString> TYPE = new Filterable.FilterableType<String, FilterableString>(Types.STRING, Types.OPTIONAL_STRING, FilterableString.class){

        @Override
        protected FilterableString create(String string, String string2) {
            return new FilterableString(string, string2);
        }
    };
    public static final Type<FilterableString[]> ARRAY_TYPE = new ArrayType<FilterableString>(TYPE);

    public FilterableString(String string, @Nullable String string2) {
        super(string, string2);
    }
}


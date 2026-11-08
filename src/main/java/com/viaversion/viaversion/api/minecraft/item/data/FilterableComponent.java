/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.item.data.Filterable;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.ArrayType;
import com.viaversion.viaversion.util.Copyable;
import com.viaversion.viaversion.util.Rewritable;
import org.checkerframework.checker.nullness.qual.Nullable;

public class FilterableComponent
extends Filterable<Tag>
implements Copyable,
Rewritable {
    public static final Type<FilterableComponent> TYPE = new Filterable.FilterableType<Tag, FilterableComponent>(Types.TAG, Types.OPTIONAL_TAG, FilterableComponent.class){

        @Override
        protected FilterableComponent create(Tag tag, Tag tag2) {
            return new FilterableComponent(tag, tag2);
        }
    };
    public static final Type<FilterableComponent[]> ARRAY_TYPE = new ArrayType<FilterableComponent>(TYPE);

    public FilterableComponent(Tag tag, @Nullable Tag tag2) {
        super(tag, tag2);
    }

    @Override
    public FilterableComponent rewrite(UserConnection userConnection, Protocol<?, ?, ?, ?> protocol, boolean bl) {
        if (protocol.getComponentRewriter() == null) {
            return this;
        }
        FilterableComponent filterableComponent = this.copy();
        protocol.getComponentRewriter().processTag(userConnection, (Tag)filterableComponent.raw());
        protocol.getComponentRewriter().processTag(userConnection, (Tag)filterableComponent.filtered());
        return filterableComponent;
    }

    @Override
    public FilterableComponent copy() {
        return new FilterableComponent(((Tag)this.raw()).copy(), this.filtered() != null ? ((Tag)this.filtered()).copy() : null);
    }
}


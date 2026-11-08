/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.MappingData;
import com.viaversion.viaversion.api.minecraft.HolderSet;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.TransformingType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.misc.HolderSetType;
import com.viaversion.viaversion.util.Rewritable;

public record Repairable(HolderSet items) implements Rewritable
{
    public static final Type<Repairable> TYPE = new TransformingType<HolderSet, Repairable>(Types.HOLDER_SET, Repairable.class, Repairable::new, Repairable::items){

        @Override
        public void write(Ops ops, Repairable repairable) {
            ops.writeMap(mapSerializer -> mapSerializer.write("items", new HolderSetType(MappingData.MappingType.ITEM), repairable.items));
        }
    };

    @Override
    public Repairable rewrite(UserConnection userConnection, Protocol<?, ?, ?, ?> protocol, boolean bl) {
        HolderSet holderSet = this.items.rewrite(Rewritable.itemRewriteFunction(protocol, bl));
        return this.items == holderSet ? this : new Repairable(holderSet);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.TransformingType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.util.Copyable;
import com.viaversion.viaversion.util.Rewritable;

public record PotDecorations(int[] itemIds) implements Copyable,
Rewritable
{
    public static final Type<PotDecorations> TYPE = new TransformingType<int[], PotDecorations>(Types.VAR_INT_ARRAY_PRIMITIVE, PotDecorations.class, PotDecorations::new, PotDecorations::itemIds){

        @Override
        public void write(Ops ops, PotDecorations potDecorations) {
            ops.writeList(listSerializer -> {
                for (int n : potDecorations.itemIds) {
                    listSerializer.write(Types.IDENTIFIER, ops.context().registryAccess().item(n));
                }
            });
        }
    };

    public PotDecorations(int n, int n2, int n3, int n4) {
        this(new int[]{n, n2, n3, n4});
    }

    public int backItem() {
        return this.item(0);
    }

    public int leftItem() {
        return this.item(1);
    }

    public int rightItem() {
        return this.item(2);
    }

    public int frontItem() {
        return this.item(3);
    }

    private int item(int n) {
        return n < 0 || n >= this.itemIds.length ? -1 : this.itemIds[n];
    }

    @Override
    public PotDecorations rewrite(UserConnection userConnection, Protocol<?, ?, ?, ?> protocol, boolean bl) {
        int[] nArray = new int[this.itemIds.length];
        for (int i = 0; i < this.itemIds.length; ++i) {
            nArray[i] = Rewritable.rewriteItem(protocol, bl, this.itemIds[i]);
        }
        return new PotDecorations(nArray);
    }

    @Override
    public PotDecorations copy() {
        return new PotDecorations(Copyable.copy(this.itemIds));
    }
}


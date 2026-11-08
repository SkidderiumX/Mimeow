/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.libs.fastutil.ints.IntBidirectionalIterator;
import com.viaversion.viaversion.libs.fastutil.ints.IntLinkedOpenHashSet;
import com.viaversion.viaversion.libs.fastutil.ints.IntSortedSet;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.Rewritable;
import io.netty.buffer.ByteBuf;

public record TooltipDisplay(boolean hideTooltip, IntSortedSet hiddenComponents) implements Rewritable
{
    public static final Type<TooltipDisplay> TYPE = new Type<TooltipDisplay>(TooltipDisplay.class){

        @Override
        public TooltipDisplay read(ByteBuf byteBuf) {
            boolean bl = byteBuf.readBoolean();
            IntLinkedOpenHashSet intLinkedOpenHashSet = new IntLinkedOpenHashSet();
            int n = Types.VAR_INT.readPrimitive(byteBuf);
            for (int i = 0; i < n; ++i) {
                intLinkedOpenHashSet.add(Types.VAR_INT.readPrimitive(byteBuf));
            }
            return new TooltipDisplay(bl, intLinkedOpenHashSet);
        }

        @Override
        public void write(ByteBuf byteBuf, TooltipDisplay tooltipDisplay) {
            byteBuf.writeBoolean(tooltipDisplay.hideTooltip());
            Types.VAR_INT.writePrimitive(byteBuf, tooltipDisplay.hiddenComponents().size());
            IntBidirectionalIterator intBidirectionalIterator = tooltipDisplay.hiddenComponents().iterator();
            while (intBidirectionalIterator.hasNext()) {
                int n = (Integer)intBidirectionalIterator.next();
                Types.VAR_INT.writePrimitive(byteBuf, n);
            }
        }

        @Override
        public void write(Ops ops, TooltipDisplay tooltipDisplay) {
            Key[] keyArray = (Key[])tooltipDisplay.hiddenComponents.intStream().mapToObj(n -> ops.context().registryAccess().dataComponentType(n)).toArray(Key[]::new);
            ops.writeMap(mapSerializer -> mapSerializer.writeOptional("hide_tooltip", Types.BOOLEAN, tooltipDisplay.hideTooltip, false).writeOptional("hidden_components", Types.IDENTIFIER_ARRAY, keyArray, new Key[0]));
        }
    };

    @Override
    public TooltipDisplay rewrite(UserConnection userConnection, Protocol<?, ?, ?, ?> protocol, boolean bl) {
        if (this.hiddenComponents.isEmpty()) {
            return this;
        }
        IntLinkedOpenHashSet intLinkedOpenHashSet = new IntLinkedOpenHashSet();
        IntBidirectionalIterator intBidirectionalIterator = this.hiddenComponents.iterator();
        while (intBidirectionalIterator.hasNext()) {
            int n = (Integer)intBidirectionalIterator.next();
            int n2 = Rewritable.rewriteDataComponentType(protocol, bl, n);
            if (n2 == -1) continue;
            intLinkedOpenHashSet.add(n2);
        }
        return new TooltipDisplay(this.hideTooltip, intLinkedOpenHashSet);
    }
}


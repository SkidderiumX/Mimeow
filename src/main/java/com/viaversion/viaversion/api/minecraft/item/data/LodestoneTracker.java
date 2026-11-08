/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.minecraft.GlobalBlockPosition;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;
import org.checkerframework.checker.nullness.qual.Nullable;

public record LodestoneTracker(@Nullable GlobalBlockPosition position, boolean tracked) {
    public static final Type<LodestoneTracker> TYPE = new Type<LodestoneTracker>(LodestoneTracker.class){

        @Override
        public LodestoneTracker read(ByteBuf byteBuf) {
            GlobalBlockPosition globalBlockPosition = (GlobalBlockPosition)Types.OPTIONAL_GLOBAL_POSITION.read(byteBuf);
            boolean bl = byteBuf.readBoolean();
            return new LodestoneTracker(globalBlockPosition, bl);
        }

        @Override
        public void write(ByteBuf byteBuf, LodestoneTracker lodestoneTracker) {
            Types.OPTIONAL_GLOBAL_POSITION.write(byteBuf, lodestoneTracker.position);
            byteBuf.writeBoolean(lodestoneTracker.tracked);
        }

        @Override
        public void write(Ops ops, LodestoneTracker lodestoneTracker) {
            ops.writeMap(mapSerializer -> mapSerializer.writeOptional("target", Types.GLOBAL_POSITION, lodestoneTracker.position).writeOptional("tracked", Types.BOOLEAN, lodestoneTracker.tracked, true));
        }
    };
}


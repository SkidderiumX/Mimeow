/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;
import java.util.Arrays;

public record TropicalFishPattern(int packedId) {
    public static final Type<TropicalFishPattern> TYPE = new Type<TropicalFishPattern>(TropicalFishPattern.class){

        @Override
        public TropicalFishPattern read(ByteBuf byteBuf) {
            int n = Types.VAR_INT.readPrimitive(byteBuf);
            return new TropicalFishPattern(n);
        }

        @Override
        public void write(ByteBuf byteBuf, TropicalFishPattern tropicalFishPattern) {
            Types.VAR_INT.writePrimitive(byteBuf, tropicalFishPattern.packedId);
        }

        @Override
        public void write(Ops ops, TropicalFishPattern tropicalFishPattern) {
            Pattern pattern2 = Arrays.stream(Pattern.values()).filter(pattern -> pattern.packedId == tropicalFishPattern.packedId).findAny().orElse(Pattern.KOB);
            ops.write(Types.STRING, pattern2.key);
        }
    };

    public int sizeId() {
        return this.packedId & 0xFF;
    }

    public int sizeSpecificId() {
        return this.packedId >> 8;
    }

    private static enum Pattern {
        KOB("kob", 0, 0),
        SUNSTREAK("sunstreak", 0, 1),
        SNOOPER("snooper", 0, 2),
        DASHER("dasher", 0, 3),
        BRINELY("brinely", 0, 4),
        SPOTTY("spotty", 0, 5),
        FLOPPER("flopper", 1, 0),
        STRIPEY("stripey", 1, 1),
        GLITTER("glitter", 1, 2),
        BLOCKFISH("blockfish", 1, 3),
        BETTY("betty", 1, 4),
        CLAYFISH("clayfish", 1, 5);

        private final String key;
        private final int packedId;

        private Pattern(String string2, int n2, int n3) {
            this.key = string2;
            this.packedId = n2 | n3 << 8;
        }
    }
}


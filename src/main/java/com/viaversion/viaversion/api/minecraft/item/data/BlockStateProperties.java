/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.libs.fastutil.objects.Object2ObjectOpenHashMap;
import com.viaversion.viaversion.util.Copyable;
import io.netty.buffer.ByteBuf;
import java.util.Map;

public record BlockStateProperties(Map<String, String> properties) implements Copyable
{
    public static final Type<BlockStateProperties> TYPE = new Type<BlockStateProperties>(BlockStateProperties.class){

        @Override
        public BlockStateProperties read(ByteBuf byteBuf) {
            int n = Types.VAR_INT.readPrimitive(byteBuf);
            Object2ObjectOpenHashMap<String, String> object2ObjectOpenHashMap = new Object2ObjectOpenHashMap<String, String>();
            for (int i = 0; i < n; ++i) {
                object2ObjectOpenHashMap.put((String)Types.STRING.read(byteBuf), (String)Types.STRING.read(byteBuf));
            }
            return new BlockStateProperties(object2ObjectOpenHashMap);
        }

        @Override
        public void write(ByteBuf byteBuf, BlockStateProperties blockStateProperties) {
            Types.VAR_INT.writePrimitive(byteBuf, blockStateProperties.properties.size());
            for (Map.Entry<String, String> entry : blockStateProperties.properties.entrySet()) {
                Types.STRING.write(byteBuf, entry.getKey());
                Types.STRING.write(byteBuf, entry.getValue());
            }
        }

        @Override
        public void write(Ops ops, BlockStateProperties blockStateProperties) {
            ops.writeMap(mapSerializer -> {
                for (Map.Entry<String, String> entry : blockStateProperties.properties.entrySet()) {
                    mapSerializer.write(Types.STRING, entry.getKey(), Types.STRING, entry.getValue());
                }
            });
        }
    };

    @Override
    public BlockStateProperties copy() {
        return new BlockStateProperties(new Object2ObjectOpenHashMap<String, String>(this.properties));
    }
}


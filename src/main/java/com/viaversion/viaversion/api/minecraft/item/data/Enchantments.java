/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntOpenHashMap;
import com.viaversion.viaversion.util.Copyable;
import com.viaversion.viaversion.util.Key;
import io.netty.buffer.ByteBuf;

public record Enchantments(Int2IntMap enchantments, boolean showInTooltip) implements Copyable
{
    public static final Type<Enchantments> TYPE1_20_5 = new Type<Enchantments>(Enchantments.class){

        @Override
        public Enchantments read(ByteBuf byteBuf) {
            Int2IntOpenHashMap int2IntOpenHashMap = new Int2IntOpenHashMap();
            int n = Types.VAR_INT.readPrimitive(byteBuf);
            for (int i = 0; i < n; ++i) {
                int n2 = Types.VAR_INT.readPrimitive(byteBuf);
                int n3 = Types.VAR_INT.readPrimitive(byteBuf);
                int2IntOpenHashMap.put(n2, n3);
            }
            return new Enchantments(int2IntOpenHashMap, byteBuf.readBoolean());
        }

        @Override
        public void write(ByteBuf byteBuf, Enchantments enchantments) {
            Types.VAR_INT.writePrimitive(byteBuf, enchantments.enchantments.size());
            for (Int2IntMap.Entry entry : enchantments.enchantments.int2IntEntrySet()) {
                Types.VAR_INT.writePrimitive(byteBuf, entry.getIntKey());
                Types.VAR_INT.writePrimitive(byteBuf, entry.getIntValue());
            }
            byteBuf.writeBoolean(enchantments.showInTooltip());
        }
    };
    public static final Type<Enchantments> TYPE1_21_5 = new Type<Enchantments>(Enchantments.class){

        @Override
        public Enchantments read(ByteBuf byteBuf) {
            Int2IntOpenHashMap int2IntOpenHashMap = new Int2IntOpenHashMap();
            int n = Types.VAR_INT.readPrimitive(byteBuf);
            for (int i = 0; i < n; ++i) {
                int n2 = Types.VAR_INT.readPrimitive(byteBuf);
                int n3 = Types.VAR_INT.readPrimitive(byteBuf);
                int2IntOpenHashMap.put(n2, n3);
            }
            return new Enchantments(int2IntOpenHashMap);
        }

        @Override
        public void write(ByteBuf byteBuf, Enchantments enchantments) {
            Types.VAR_INT.writePrimitive(byteBuf, enchantments.enchantments.size());
            for (Int2IntMap.Entry entry : enchantments.enchantments.int2IntEntrySet()) {
                Types.VAR_INT.writePrimitive(byteBuf, entry.getIntKey());
                Types.VAR_INT.writePrimitive(byteBuf, entry.getIntValue());
            }
        }

        @Override
        public void write(Ops ops, Enchantments enchantments) {
            ops.writeMap(mapSerializer -> {
                for (Int2IntMap.Entry entry : enchantments.enchantments.int2IntEntrySet()) {
                    Key key = ops.context().registryAccess().registryKey("enchantment", entry.getIntKey());
                    mapSerializer.write(Types.IDENTIFIER, key, Types.VAR_INT, Integer.valueOf(entry.getIntValue()));
                }
            });
        }
    };

    public Enchantments(Int2IntMap int2IntMap) {
        this(int2IntMap, true);
    }

    public Enchantments(boolean bl) {
        this(new Int2IntOpenHashMap(), bl);
    }

    public int size() {
        return this.enchantments.size();
    }

    public void add(int n, int n2) {
        this.enchantments.put(n, n2);
    }

    public void remove(int n) {
        this.enchantments.remove(n);
    }

    public void clear() {
        this.enchantments.clear();
    }

    public int getLevel(int n) {
        return this.enchantments.getOrDefault(n, -1);
    }

    @Override
    public Enchantments copy() {
        return new Enchantments(new Int2IntOpenHashMap(this.enchantments), this.showInTooltip);
    }
}


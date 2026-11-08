/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.api.data;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.util.IdAndData;
import org.checkerframework.checker.nullness.qual.Nullable;

public class MappedLegacyBlockItem {
    private final int id;
    private final short data;
    private final String name;
    private final IdAndData block;
    private BlockEntityHandler blockEntityHandler;

    public MappedLegacyBlockItem(int n) {
        this(n, -1, null, Type.ITEM);
    }

    public MappedLegacyBlockItem(int n, short s, @Nullable String string, Type type) {
        this.id = n;
        this.data = s;
        Object object = this.name = string != null ? "\u00a7f" + string : null;
        this.block = type != Type.ITEM ? (s != -1 ? new IdAndData(n, s) : new IdAndData(n)) : null;
    }

    public int getId() {
        return this.id;
    }

    public short getData() {
        return this.data;
    }

    public String getName() {
        return this.name;
    }

    public IdAndData getBlock() {
        return this.block;
    }

    public boolean hasBlockEntityHandler() {
        return this.blockEntityHandler != null;
    }

    public @Nullable BlockEntityHandler getBlockEntityHandler() {
        return this.blockEntityHandler;
    }

    public void setBlockEntityHandler(@Nullable BlockEntityHandler blockEntityHandler) {
        this.blockEntityHandler = blockEntityHandler;
    }

    public static enum Type {
        ITEM("items"),
        BLOCK_ITEM("block-items"),
        BLOCK("blocks");

        final String name;

        private Type(String string2) {
            this.name = string2;
        }

        public String getName() {
            return this.name;
        }
    }

    @FunctionalInterface
    public static interface BlockEntityHandler {
        public void handleCompoundTag(int var1, CompoundTag var2);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTSizeTracker;

public class NBTTagByte
extends NBTBase.NBTPrimitive {
    private byte data;

    NBTTagByte() {
    }

    public NBTTagByte(byte by) {
        this.data = by;
    }

    @Override
    void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(this.data);
    }

    @Override
    void read(DataInput dataInput, int n, NBTSizeTracker nBTSizeTracker) throws IOException {
        nBTSizeTracker.read(72L);
        this.data = dataInput.readByte();
    }

    @Override
    public byte getId() {
        return 1;
    }

    @Override
    public String toString() {
        return this.data + "b";
    }

    @Override
    public NBTBase copy() {
        return new NBTTagByte(this.data);
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object)) {
            NBTTagByte nBTTagByte = (NBTTagByte)object;
            return this.data == nBTTagByte.data;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() ^ this.data;
    }

    @Override
    public long getLong() {
        return this.data;
    }

    @Override
    public int getInt() {
        return this.data;
    }

    @Override
    public short getShort() {
        return this.data;
    }

    @Override
    public byte getByte() {
        return this.data;
    }

    @Override
    public double getDouble() {
        return this.data;
    }

    @Override
    public float getFloat() {
        return this.data;
    }
}


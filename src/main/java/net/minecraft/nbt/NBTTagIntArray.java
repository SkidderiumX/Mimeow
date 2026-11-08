/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTSizeTracker;

public class NBTTagIntArray
extends NBTBase {
    private int[] intArray;

    NBTTagIntArray() {
    }

    public NBTTagIntArray(int[] nArray) {
        this.intArray = nArray;
    }

    @Override
    void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.intArray.length);
        for (int i = 0; i < this.intArray.length; ++i) {
            dataOutput.writeInt(this.intArray[i]);
        }
    }

    @Override
    void read(DataInput dataInput, int n, NBTSizeTracker nBTSizeTracker) throws IOException {
        nBTSizeTracker.read(192L);
        int n2 = dataInput.readInt();
        nBTSizeTracker.read(32 * n2);
        this.intArray = new int[n2];
        for (int i = 0; i < n2; ++i) {
            this.intArray[i] = dataInput.readInt();
        }
    }

    @Override
    public byte getId() {
        return 11;
    }

    @Override
    public String toString() {
        Object object = "[";
        for (int n : this.intArray) {
            object = (String)object + n + ",";
        }
        return (String)object + "]";
    }

    @Override
    public NBTBase copy() {
        int[] nArray = new int[this.intArray.length];
        System.arraycopy(this.intArray, 0, nArray, 0, this.intArray.length);
        return new NBTTagIntArray(nArray);
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object) ? Arrays.equals(this.intArray, ((NBTTagIntArray)object).intArray) : false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() ^ Arrays.hashCode(this.intArray);
    }

    public int[] getIntArray() {
        return this.intArray;
    }
}


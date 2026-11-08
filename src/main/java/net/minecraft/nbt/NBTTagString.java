/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTSizeTracker;

public class NBTTagString
extends NBTBase {
    private String data;
    private String cachedString;

    public NBTTagString() {
        this.data = "";
    }

    public NBTTagString(String string) {
        this.data = string;
        if (string == null) {
            throw new IllegalArgumentException("Empty string not allowed");
        }
    }

    @Override
    void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this.data);
    }

    @Override
    void read(DataInput dataInput, int n, NBTSizeTracker nBTSizeTracker) throws IOException {
        nBTSizeTracker.read(288L);
        this.data = dataInput.readUTF();
        this.cachedString = null;
        nBTSizeTracker.read(16 * this.data.length());
    }

    @Override
    public byte getId() {
        return 8;
    }

    @Override
    public String toString() {
        if (this.cachedString == null) {
            this.cachedString = "\"" + this.data.replace("\"", "\\\"") + "\"";
        }
        return this.cachedString;
    }

    @Override
    public NBTBase copy() {
        return new NBTTagString(this.data);
    }

    @Override
    public boolean hasNoTags() {
        return this.data.isEmpty();
    }

    @Override
    public boolean equals(Object object) {
        if (!super.equals(object)) {
            return false;
        }
        NBTTagString nBTTagString = (NBTTagString)object;
        return this.data == null && nBTTagString.data == null || this.data != null && this.data.equals(nBTTagString.data);
    }

    @Override
    public int hashCode() {
        return super.hashCode() ^ this.data.hashCode();
    }

    @Override
    public String getString() {
        return this.data;
    }
}


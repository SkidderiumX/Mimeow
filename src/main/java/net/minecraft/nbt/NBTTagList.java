/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.nbt;

import com.google.common.collect.Lists;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.List;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTSizeTracker;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.nbt.NBTTagEnd;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagIntArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NBTTagList
extends NBTBase {
    private static final Logger LOGGER = LogManager.getLogger();
    private List<NBTBase> tagList = Lists.newArrayList();
    private byte tagType = 0;

    @Override
    void write(DataOutput dataOutput) throws IOException {
        this.tagType = !this.tagList.isEmpty() ? this.tagList.get(0).getId() : (byte)0;
        dataOutput.writeByte(this.tagType);
        dataOutput.writeInt(this.tagList.size());
        for (int i = 0; i < this.tagList.size(); ++i) {
            this.tagList.get(i).write(dataOutput);
        }
    }

    @Override
    void read(DataInput dataInput, int n, NBTSizeTracker nBTSizeTracker) throws IOException {
        nBTSizeTracker.read(296L);
        if (n > 512) {
            throw new RuntimeException("Tried to read NBT tag with too high complexity, depth > 512");
        }
        this.tagType = dataInput.readByte();
        int n2 = dataInput.readInt();
        if (this.tagType == 0 && n2 > 0) {
            throw new RuntimeException("Missing type on ListTag");
        }
        nBTSizeTracker.read(32L * (long)n2);
        this.tagList = Lists.newArrayListWithCapacity(n2);
        for (int i = 0; i < n2; ++i) {
            NBTBase nBTBase = NBTBase.createNewByType(this.tagType);
            nBTBase.read(dataInput, n + 1, nBTSizeTracker);
            this.tagList.add(nBTBase);
        }
    }

    @Override
    public byte getId() {
        return 9;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < this.tagList.size(); ++i) {
            if (i != 0) {
                stringBuilder.append(',');
            }
            stringBuilder.append(i).append(':').append(this.tagList.get(i));
        }
        return stringBuilder.append(']').toString();
    }

    public void appendTag(NBTBase nBTBase) {
        if (nBTBase.getId() == 0) {
            LOGGER.warn("Invalid TagEnd added to ListTag");
        } else {
            if (this.tagType == 0) {
                this.tagType = nBTBase.getId();
            } else if (this.tagType != nBTBase.getId()) {
                LOGGER.warn("Adding mismatching tag types to tag list");
                return;
            }
            this.tagList.add(nBTBase);
        }
    }

    public void set(int n, NBTBase nBTBase) {
        if (nBTBase.getId() == 0) {
            LOGGER.warn("Invalid TagEnd added to ListTag");
        } else if (n >= 0 && n < this.tagList.size()) {
            if (this.tagType == 0) {
                this.tagType = nBTBase.getId();
            } else if (this.tagType != nBTBase.getId()) {
                LOGGER.warn("Adding mismatching tag types to tag list");
                return;
            }
            this.tagList.set(n, nBTBase);
        } else {
            LOGGER.warn("index out of bounds to set tag in tag list");
        }
    }

    public NBTBase removeTag(int n) {
        return this.tagList.remove(n);
    }

    @Override
    public boolean hasNoTags() {
        return this.tagList.isEmpty();
    }

    public NBTTagCompound getCompoundTagAt(int n) {
        if (n >= 0 && n < this.tagList.size()) {
            NBTBase nBTBase = this.tagList.get(n);
            return nBTBase.getId() == 10 ? (NBTTagCompound)nBTBase : new NBTTagCompound();
        }
        return new NBTTagCompound();
    }

    public int[] getIntArrayAt(int n) {
        if (n >= 0 && n < this.tagList.size()) {
            NBTBase nBTBase = this.tagList.get(n);
            return nBTBase.getId() == 11 ? ((NBTTagIntArray)nBTBase).getIntArray() : new int[]{};
        }
        return new int[0];
    }

    public double getDoubleAt(int n) {
        if (n >= 0 && n < this.tagList.size()) {
            NBTBase nBTBase = this.tagList.get(n);
            return nBTBase.getId() == 6 ? ((NBTTagDouble)nBTBase).getDouble() : 0.0;
        }
        return 0.0;
    }

    public float getFloatAt(int n) {
        if (n >= 0 && n < this.tagList.size()) {
            NBTBase nBTBase = this.tagList.get(n);
            return nBTBase.getId() == 5 ? ((NBTTagFloat)nBTBase).getFloat() : 0.0f;
        }
        return 0.0f;
    }

    public String getStringTagAt(int n) {
        if (n >= 0 && n < this.tagList.size()) {
            NBTBase nBTBase = this.tagList.get(n);
            return nBTBase.getId() == 8 ? nBTBase.getString() : nBTBase.toString();
        }
        return "";
    }

    public NBTBase get(int n) {
        return n >= 0 && n < this.tagList.size() ? this.tagList.get(n) : new NBTTagEnd();
    }

    public int tagCount() {
        return this.tagList.size();
    }

    @Override
    public NBTBase copy() {
        NBTTagList nBTTagList = new NBTTagList();
        nBTTagList.tagType = this.tagType;
        for (NBTBase nBTBase : this.tagList) {
            NBTBase nBTBase2 = nBTBase.copy();
            nBTTagList.tagList.add(nBTBase2);
        }
        return nBTTagList;
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object)) {
            NBTTagList nBTTagList = (NBTTagList)object;
            if (this.tagType == nBTTagList.tagType) {
                return this.tagList.equals(nBTTagList.tagList);
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() ^ this.tagList.hashCode();
    }

    public int getTagType() {
        return this.tagType;
    }
}


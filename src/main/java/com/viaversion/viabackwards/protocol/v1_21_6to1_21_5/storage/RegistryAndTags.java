/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.storage;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.libs.fastutil.objects.Object2ObjectArrayMap;
import com.viaversion.viaversion.libs.fastutil.objects.Object2ObjectMap;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.KeyMappings;

public class RegistryAndTags
implements StorableObject {
    private KeyMappings dialogMappings;
    private Object2ObjectMap<String, CompoundTag> dialogs;
    private Object2ObjectMap<String, int[]> dialogTags;

    public void storeRegistry(KeyMappings keyMappings, Object2ObjectMap<String, CompoundTag> object2ObjectMap) {
        this.dialogMappings = keyMappings;
        this.dialogs = object2ObjectMap;
    }

    public CompoundTag fromRegistry(int n) {
        return (CompoundTag)this.dialogs.get(this.dialogMappings.idToKey(n));
    }

    public CompoundTag fromRegistry(String string) {
        return (CompoundTag)this.dialogs.get(Key.stripMinecraftNamespace(string));
    }

    public void storeTags(String string, int[] nArray) {
        if (this.dialogTags == null) {
            this.dialogTags = new Object2ObjectArrayMap<String, int[]>();
        }
        this.dialogTags.put(Key.stripMinecraftNamespace(string), nArray);
    }

    public CompoundTag[] fromRegistryKey(String string) {
        int[] nArray = (int[])this.dialogTags.get(Key.stripMinecraftNamespace(string));
        if (nArray == null) {
            return null;
        }
        CompoundTag[] compoundTagArray = new CompoundTag[nArray.length];
        for (int i = 0; i < nArray.length; ++i) {
            compoundTagArray[i] = this.fromRegistry(nArray[i]);
        }
        return compoundTagArray;
    }
}


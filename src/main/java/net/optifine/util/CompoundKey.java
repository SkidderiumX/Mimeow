/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.util;

import net.minecraft.src.Config;

public class CompoundKey {
    private Object[] keys;
    private int hashcode = 0;

    public CompoundKey(Object[] objectArray) {
        this.keys = (Object[])objectArray.clone();
    }

    public CompoundKey(Object object, Object object2) {
        this(new Object[]{object, object2});
    }

    public CompoundKey(Object object, Object object2, Object object3) {
        this(new Object[]{object, object2, object3});
    }

    public int hashCode() {
        if (this.hashcode == 0) {
            this.hashcode = 7;
            for (int i = 0; i < this.keys.length; ++i) {
                Object object = this.keys[i];
                if (object == null) continue;
                this.hashcode = 31 * this.hashcode + object.hashCode();
            }
        }
        return this.hashcode;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (!(object instanceof CompoundKey)) {
            return false;
        }
        CompoundKey compoundKey = (CompoundKey)object;
        Object[] objectArray = compoundKey.getKeys();
        if (objectArray.length != this.keys.length) {
            return false;
        }
        for (int i = 0; i < this.keys.length; ++i) {
            if (CompoundKey.compareKeys(this.keys[i], objectArray[i])) continue;
            return false;
        }
        return true;
    }

    private static boolean compareKeys(Object object, Object object2) {
        return object == object2 ? true : (object == null ? false : (object2 == null ? false : object.equals(object2)));
    }

    private Object[] getKeys() {
        return this.keys;
    }

    public Object[] getKeysCopy() {
        return (Object[])this.keys.clone();
    }

    public String toString() {
        return "[" + Config.arrayToString(this.keys) + "]";
    }
}


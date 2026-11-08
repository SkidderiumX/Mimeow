/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna;

import com.sun.jna.Function;
import com.sun.jna.Memory;
import com.sun.jna.NativeString;
import com.sun.jna.Pointer;
import com.sun.jna.WString;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringArray
extends Memory
implements Function.PostCallRead {
    private boolean wide;
    private List natives = new ArrayList();
    private Object[] original;

    public StringArray(String[] stringArray) {
        this(stringArray, false);
    }

    public StringArray(String[] stringArray, boolean bl) {
        this((Object[])stringArray, bl);
    }

    public StringArray(WString[] wStringArray) {
        this(wStringArray, true);
    }

    private StringArray(Object[] objectArray, boolean bl) {
        super((objectArray.length + 1) * Pointer.SIZE);
        this.original = objectArray;
        this.wide = bl;
        for (int i = 0; i < objectArray.length; ++i) {
            Pointer pointer = null;
            if (objectArray[i] != null) {
                NativeString nativeString = new NativeString(objectArray[i].toString(), bl);
                this.natives.add(nativeString);
                pointer = nativeString.getPointer();
            }
            this.setPointer(Pointer.SIZE * i, pointer);
        }
        this.setPointer(Pointer.SIZE * objectArray.length, null);
    }

    public void read() {
        boolean bl = this.original instanceof WString[];
        for (int i = 0; i < this.original.length; ++i) {
            Pointer pointer = this.getPointer(i * Pointer.SIZE);
            CharSequence charSequence = null;
            if (pointer != null) {
                charSequence = pointer.getString(0L, this.wide);
                if (bl) {
                    charSequence = new WString((String)charSequence);
                }
            }
            this.original[i] = charSequence;
        }
    }

    public String toString() {
        String string = this.wide ? "const wchar_t*[]" : "const char*[]";
        string = string + Arrays.asList(this.original);
        return string;
    }
}


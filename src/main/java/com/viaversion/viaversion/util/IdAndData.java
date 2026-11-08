/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.util;

import com.google.common.base.Preconditions;
import java.util.Objects;

public class IdAndData {
    private int id;
    private byte data;

    public IdAndData(int n) {
        this.id = n;
        this.data = (byte)-1;
    }

    public IdAndData(int n, int n2) {
        Preconditions.checkArgument(n2 >= 0 && n2 <= 15, "Data has to be between 0 and 15: (id: " + n + " data: " + n2 + ")");
        this.id = n;
        this.data = (byte)n2;
    }

    public static int getId(int n) {
        return n >> 4;
    }

    public static int getData(int n) {
        return n & 0xF;
    }

    public static int toRawData(int n) {
        return n << 4;
    }

    public static int removeData(int n) {
        return n & 0xFFFFFFF0;
    }

    public static IdAndData fromRawData(int n) {
        return new IdAndData(n >> 4, n & 0xF);
    }

    public static int toRawData(int n, int n2) {
        return n << 4 | n2 & 0xF;
    }

    public int toRawData() {
        return IdAndData.toRawData(this.id, this.data);
    }

    public IdAndData withData(int n) {
        return new IdAndData(this.id, n);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int n) {
        this.id = n;
    }

    public byte getData() {
        return this.data;
    }

    public void setData(int n) {
        this.data = (byte)n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        IdAndData idAndData = (IdAndData)object;
        return this.id == idAndData.id && this.data == idAndData.data;
    }

    public int hashCode() {
        return Objects.hash(this.id, this.data);
    }

    public String toString() {
        return "IdAndData{id=" + this.id + ", data=" + this.data + "}";
    }
}


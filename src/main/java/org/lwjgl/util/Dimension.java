/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.util;

import java.io.Serializable;
import org.lwjgl.util.ReadableDimension;
import org.lwjgl.util.WritableDimension;

public class Dimension
implements Serializable,
ReadableDimension,
WritableDimension {
    static final long serialVersionUID = 1L;
    private int width;
    private int height;

    public Dimension() {
    }

    public Dimension(int n, int n2) {
        this.width = n;
        this.height = n2;
    }

    public Dimension(ReadableDimension readableDimension) {
        this.setSize(readableDimension);
    }

    @Override
    public void setSize(int n, int n2) {
        this.width = n;
        this.height = n2;
    }

    @Override
    public void setSize(ReadableDimension readableDimension) {
        this.width = readableDimension.getWidth();
        this.height = readableDimension.getHeight();
    }

    @Override
    public void getSize(WritableDimension writableDimension) {
        writableDimension.setSize(this);
    }

    public boolean equals(Object object) {
        if (object instanceof ReadableDimension) {
            ReadableDimension readableDimension = (ReadableDimension)object;
            return this.width == readableDimension.getWidth() && this.height == readableDimension.getHeight();
        }
        return false;
    }

    public int hashCode() {
        int n = this.width + this.height;
        return n * (n + 1) / 2 + this.width;
    }

    public String toString() {
        return this.getClass().getName() + "[width=" + this.width + ",height=" + this.height + "]";
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public void setHeight(int n) {
        this.height = n;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public void setWidth(int n) {
        this.width = n;
    }
}


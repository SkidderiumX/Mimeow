/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.realms;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.renderer.vertex.VertexFormatElement;
import net.minecraft.realms.RealmsVertexFormatElement;

public class RealmsVertexFormat {
    private VertexFormat v;

    public RealmsVertexFormat(VertexFormat vertexFormat) {
        this.v = vertexFormat;
    }

    public RealmsVertexFormat from(VertexFormat vertexFormat) {
        this.v = vertexFormat;
        return this;
    }

    public VertexFormat getVertexFormat() {
        return this.v;
    }

    public void clear() {
        this.v.clear();
    }

    public int getUvOffset(int n) {
        return this.v.getUvOffsetById(n);
    }

    public int getElementCount() {
        return this.v.getElementCount();
    }

    public boolean hasColor() {
        return this.v.hasColor();
    }

    public boolean hasUv(int n) {
        return this.v.hasUvOffset(n);
    }

    public RealmsVertexFormatElement getElement(int n) {
        return new RealmsVertexFormatElement(this.v.getElement(n));
    }

    public RealmsVertexFormat addElement(RealmsVertexFormatElement realmsVertexFormatElement) {
        return this.from(this.v.addElement(realmsVertexFormatElement.getVertexFormatElement()));
    }

    public int getColorOffset() {
        return this.v.getColorOffset();
    }

    public List<RealmsVertexFormatElement> getElements() {
        ArrayList<RealmsVertexFormatElement> arrayList = new ArrayList<RealmsVertexFormatElement>();
        for (VertexFormatElement vertexFormatElement : this.v.getElements()) {
            arrayList.add(new RealmsVertexFormatElement(vertexFormatElement));
        }
        return arrayList;
    }

    public boolean hasNormal() {
        return this.v.hasNormal();
    }

    public int getVertexSize() {
        return this.v.getNextOffset();
    }

    public int getOffset(int n) {
        return this.v.getOffset(n);
    }

    public int getNormalOffset() {
        return this.v.getNormalOffset();
    }

    public int getIntegerSize() {
        return this.v.getIntegerSize();
    }

    public boolean equals(Object object) {
        return this.v.equals(object);
    }

    public int hashCode() {
        return this.v.hashCode();
    }

    public String toString() {
        return this.v.toString();
    }
}


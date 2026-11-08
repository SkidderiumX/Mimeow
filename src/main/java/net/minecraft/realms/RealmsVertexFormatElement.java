/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.realms;

import net.minecraft.client.renderer.vertex.VertexFormatElement;

public class RealmsVertexFormatElement {
    private VertexFormatElement v;

    public RealmsVertexFormatElement(VertexFormatElement vertexFormatElement) {
        this.v = vertexFormatElement;
    }

    public VertexFormatElement getVertexFormatElement() {
        return this.v;
    }

    public boolean isPosition() {
        return this.v.isPositionElement();
    }

    public int getIndex() {
        return this.v.getIndex();
    }

    public int getByteSize() {
        return this.v.getSize();
    }

    public int getCount() {
        return this.v.getElementCount();
    }

    public int hashCode() {
        return this.v.hashCode();
    }

    public boolean equals(Object object) {
        return this.v.equals(object);
    }

    public String toString() {
        return this.v.toString();
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.vertex;

import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.client.renderer.vertex.VertexFormatElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VertexFormat {
    private static final Logger LOGGER = LogManager.getLogger();
    private final List<VertexFormatElement> elements = Lists.newArrayList();
    private final List<Integer> offsets = Lists.newArrayList();
    private int nextOffset = 0;
    private int colorElementOffset = -1;
    private List<Integer> uvOffsetsById = Lists.newArrayList();
    private int normalElementOffset = -1;

    public VertexFormat(VertexFormat vertexFormat) {
        this();
        for (int i = 0; i < vertexFormat.getElementCount(); ++i) {
            this.addElement(vertexFormat.getElement(i));
        }
        this.nextOffset = vertexFormat.getNextOffset();
    }

    public VertexFormat() {
    }

    public void clear() {
        this.elements.clear();
        this.offsets.clear();
        this.colorElementOffset = -1;
        this.uvOffsetsById.clear();
        this.normalElementOffset = -1;
        this.nextOffset = 0;
    }

    public VertexFormat addElement(VertexFormatElement vertexFormatElement) {
        if (vertexFormatElement.isPositionElement() && this.hasPosition()) {
            LOGGER.warn("VertexFormat error: Trying to add a position VertexFormatElement when one already exists, ignoring.");
            return this;
        }
        this.elements.add(vertexFormatElement);
        this.offsets.add(this.nextOffset);
        switch (vertexFormatElement.getUsage()) {
            case NORMAL: {
                this.normalElementOffset = this.nextOffset;
                break;
            }
            case COLOR: {
                this.colorElementOffset = this.nextOffset;
                break;
            }
            case UV: {
                this.uvOffsetsById.add(vertexFormatElement.getIndex(), this.nextOffset);
            }
        }
        this.nextOffset += vertexFormatElement.getSize();
        return this;
    }

    public boolean hasNormal() {
        return this.normalElementOffset >= 0;
    }

    public int getNormalOffset() {
        return this.normalElementOffset;
    }

    public boolean hasColor() {
        return this.colorElementOffset >= 0;
    }

    public int getColorOffset() {
        return this.colorElementOffset;
    }

    public boolean hasUvOffset(int n) {
        return this.uvOffsetsById.size() - 1 >= n;
    }

    public int getUvOffsetById(int n) {
        return this.uvOffsetsById.get(n);
    }

    public String toString() {
        String string = "format: " + this.elements.size() + " elements: ";
        for (int i = 0; i < this.elements.size(); ++i) {
            string = string + this.elements.get(i).toString();
            if (i == this.elements.size() - 1) continue;
            string = string + " ";
        }
        return string;
    }

    private boolean hasPosition() {
        int n = this.elements.size();
        for (int i = 0; i < n; ++i) {
            VertexFormatElement vertexFormatElement = this.elements.get(i);
            if (!vertexFormatElement.isPositionElement()) continue;
            return true;
        }
        return false;
    }

    public int getIntegerSize() {
        return this.getNextOffset() / 4;
    }

    public int getNextOffset() {
        return this.nextOffset;
    }

    public List<VertexFormatElement> getElements() {
        return this.elements;
    }

    public int getElementCount() {
        return this.elements.size();
    }

    public VertexFormatElement getElement(int n) {
        return this.elements.get(n);
    }

    public int getOffset(int n) {
        return this.offsets.get(n);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null && this.getClass() == object.getClass()) {
            VertexFormat vertexFormat = (VertexFormat)object;
            return this.nextOffset != vertexFormat.nextOffset ? false : (!this.elements.equals(vertexFormat.elements) ? false : this.offsets.equals(vertexFormat.offsets));
        }
        return false;
    }

    public int hashCode() {
        int n = this.elements.hashCode();
        n = 31 * n + this.offsets.hashCode();
        n = 31 * n + this.nextOffset;
        return n;
    }
}


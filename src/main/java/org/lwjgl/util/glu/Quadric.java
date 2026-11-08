/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.util.glu;

import org.lwjgl.opengl.GL11;

public class Quadric {
    protected int drawStyle = 100012;
    protected int orientation = 100020;
    protected boolean textureFlag = false;
    protected int normals = 100000;

    protected void normal3f(float f, float f2, float f3) {
        float f4 = (float)Math.sqrt(f * f + f2 * f2 + f3 * f3);
        if (f4 > 1.0E-5f) {
            f /= f4;
            f2 /= f4;
            f3 /= f4;
        }
        GL11.glNormal3f(f, f2, f3);
    }

    public void setDrawStyle(int n) {
        this.drawStyle = n;
    }

    public void setNormals(int n) {
        this.normals = n;
    }

    public void setOrientation(int n) {
        this.orientation = n;
    }

    public void setTextureFlag(boolean bl) {
        this.textureFlag = bl;
    }

    public int getDrawStyle() {
        return this.drawStyle;
    }

    public int getNormals() {
        return this.normals;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public boolean getTextureFlag() {
        return this.textureFlag;
    }

    protected void TXTR_COORD(float f, float f2) {
        if (this.textureFlag) {
            GL11.glTexCoord2f(f, f2);
        }
    }

    protected float sin(float f) {
        return (float)Math.sin(f);
    }

    protected float cos(float f) {
        return (float)Math.cos(f);
    }
}


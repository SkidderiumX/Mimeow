/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import net.minecraft.client.model.PositionTextureVertex;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.src.Config;
import net.minecraft.util.Vec3;
import net.optifine.shaders.SVertexFormat;

public class TexturedQuad {
    public PositionTextureVertex[] vertexPositions;
    public int nVertices;
    private boolean invertNormal;

    public TexturedQuad(PositionTextureVertex[] positionTextureVertexArray) {
        this.vertexPositions = positionTextureVertexArray;
        this.nVertices = positionTextureVertexArray.length;
    }

    public TexturedQuad(PositionTextureVertex[] positionTextureVertexArray, int n, int n2, int n3, int n4, float f, float f2) {
        this(positionTextureVertexArray);
        float f3 = 0.0f / f;
        float f4 = 0.0f / f2;
        positionTextureVertexArray[0] = positionTextureVertexArray[0].setTexturePosition((float)n3 / f - f3, (float)n2 / f2 + f4);
        positionTextureVertexArray[1] = positionTextureVertexArray[1].setTexturePosition((float)n / f + f3, (float)n2 / f2 + f4);
        positionTextureVertexArray[2] = positionTextureVertexArray[2].setTexturePosition((float)n / f + f3, (float)n4 / f2 - f4);
        positionTextureVertexArray[3] = positionTextureVertexArray[3].setTexturePosition((float)n3 / f - f3, (float)n4 / f2 - f4);
    }

    public void flipFace() {
        PositionTextureVertex[] positionTextureVertexArray = new PositionTextureVertex[this.vertexPositions.length];
        for (int i = 0; i < this.vertexPositions.length; ++i) {
            positionTextureVertexArray[i] = this.vertexPositions[this.vertexPositions.length - i - 1];
        }
        this.vertexPositions = positionTextureVertexArray;
    }

    public void draw(WorldRenderer worldRenderer, float f) {
        boolean bl = worldRenderer.isDrawing();
        Vec3 vec3 = this.vertexPositions[1].vector3D.subtractReverse(this.vertexPositions[0].vector3D);
        Vec3 vec32 = this.vertexPositions[1].vector3D.subtractReverse(this.vertexPositions[2].vector3D);
        Vec3 vec33 = vec32.crossProduct(vec3).normalize();
        float f2 = (float)vec33.xCoord;
        float f3 = (float)vec33.yCoord;
        float f4 = (float)vec33.zCoord;
        if (this.invertNormal) {
            f2 = -f2;
            f3 = -f3;
            f4 = -f4;
        }
        if (!bl && Config.isShaders()) {
            worldRenderer.begin(7, SVertexFormat.defVertexFormatTextured);
        } else if (!bl) {
            worldRenderer.begin(7, DefaultVertexFormats.OLDMODEL_POSITION_TEX_NORMAL);
        }
        for (int i = 0; i < 4; ++i) {
            PositionTextureVertex positionTextureVertex = this.vertexPositions[i];
            worldRenderer.pos(positionTextureVertex.vector3D.xCoord * (double)f, positionTextureVertex.vector3D.yCoord * (double)f, positionTextureVertex.vector3D.zCoord * (double)f).tex(positionTextureVertex.texturePositionX, positionTextureVertex.texturePositionY).normal(f2, f3, f4).endVertex();
        }
        if (!bl) {
            Tessellator.getInstance().draw();
        }
    }
}


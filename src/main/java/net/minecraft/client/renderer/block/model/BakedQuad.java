/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.block.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.BreakingFour;
import net.minecraft.client.renderer.block.model.FaceBakery;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.src.Config;
import net.minecraft.util.EnumFacing;
import net.optifine.compat.model.pipeline.IVertexConsumer;
import net.optifine.compat.model.pipeline.IVertexProducer;
import net.optifine.model.QuadBounds;
import net.optifine.reflect.Reflector;

public class BakedQuad
implements IVertexProducer {
    protected int[] vertexData;
    protected final int tintIndex;
    protected EnumFacing face;
    protected TextureAtlasSprite sprite;
    private int[] vertexDataSingle = null;
    private QuadBounds quadBounds;
    private boolean quadEmissiveChecked;
    private BakedQuad quadEmissive;

    public BakedQuad(int[] nArray, int n, EnumFacing enumFacing, TextureAtlasSprite textureAtlasSprite) {
        this.vertexData = nArray;
        this.tintIndex = n;
        this.face = enumFacing;
        this.sprite = textureAtlasSprite;
        this.fixVertexData();
    }

    public BakedQuad(int[] nArray, int n, EnumFacing enumFacing) {
        this.vertexData = nArray;
        this.tintIndex = n;
        this.face = enumFacing;
        this.fixVertexData();
    }

    public TextureAtlasSprite getSprite() {
        if (this.sprite == null) {
            this.sprite = BakedQuad.getSpriteByUv(this.getVertexData());
        }
        return this.sprite;
    }

    public int[] getVertexData() {
        this.fixVertexData();
        return this.vertexData;
    }

    public boolean hasTintIndex() {
        return this.tintIndex != -1;
    }

    public int getTintIndex() {
        return this.tintIndex;
    }

    public EnumFacing getFace() {
        if (this.face == null) {
            this.face = FaceBakery.getFacingFromVertexData(this.getVertexData());
        }
        return this.face;
    }

    public int[] getVertexDataSingle() {
        if (this.vertexDataSingle == null) {
            this.vertexDataSingle = BakedQuad.makeVertexDataSingle(this.getVertexData(), this.getSprite());
        }
        return this.vertexDataSingle;
    }

    private static int[] makeVertexDataSingle(int[] nArray, TextureAtlasSprite textureAtlasSprite) {
        int[] nArray2 = (int[])nArray.clone();
        int n = nArray2.length / 4;
        for (int i = 0; i < 4; ++i) {
            int n2 = i * n;
            float f = Float.intBitsToFloat(nArray2[n2 + 4]);
            float f2 = Float.intBitsToFloat(nArray2[n2 + 4 + 1]);
            float f3 = textureAtlasSprite.toSingleU(f);
            float f4 = textureAtlasSprite.toSingleV(f2);
            nArray2[n2 + 4] = Float.floatToRawIntBits(f3);
            nArray2[n2 + 4 + 1] = Float.floatToRawIntBits(f4);
        }
        return nArray2;
    }

    @Override
    public void pipe(IVertexConsumer iVertexConsumer) {
        Reflector.callVoid(Reflector.LightUtil_putBakedQuad, iVertexConsumer, this);
    }

    private static TextureAtlasSprite getSpriteByUv(int[] nArray) {
        float f = 1.0f;
        float f2 = 1.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        int n = nArray.length / 4;
        for (int i = 0; i < 4; ++i) {
            int n2 = i * n;
            float f5 = Float.intBitsToFloat(nArray[n2 + 4]);
            float f6 = Float.intBitsToFloat(nArray[n2 + 4 + 1]);
            f = Math.min(f, f5);
            f2 = Math.min(f2, f6);
            f3 = Math.max(f3, f5);
            f4 = Math.max(f4, f6);
        }
        float f7 = (f + f3) / 2.0f;
        float f8 = (f2 + f4) / 2.0f;
        TextureAtlasSprite textureAtlasSprite = Minecraft.getMinecraft().getTextureMapBlocks().getIconByUV(f7, f8);
        return textureAtlasSprite;
    }

    protected void fixVertexData() {
        if (Config.isShaders()) {
            if (this.vertexData.length == 28) {
                this.vertexData = BakedQuad.expandVertexData(this.vertexData);
            }
        } else if (this.vertexData.length == 56) {
            this.vertexData = BakedQuad.compactVertexData(this.vertexData);
        }
    }

    private static int[] expandVertexData(int[] nArray) {
        int n = nArray.length / 4;
        int n2 = n * 2;
        int[] nArray2 = new int[n2 * 4];
        for (int i = 0; i < 4; ++i) {
            System.arraycopy(nArray, i * n, nArray2, i * n2, n);
        }
        return nArray2;
    }

    private static int[] compactVertexData(int[] nArray) {
        int n = nArray.length / 4;
        int n2 = n / 2;
        int[] nArray2 = new int[n2 * 4];
        for (int i = 0; i < 4; ++i) {
            System.arraycopy(nArray, i * n, nArray2, i * n2, n2);
        }
        return nArray2;
    }

    public QuadBounds getQuadBounds() {
        if (this.quadBounds == null) {
            this.quadBounds = new QuadBounds(this.getVertexData());
        }
        return this.quadBounds;
    }

    public float getMidX() {
        QuadBounds quadBounds = this.getQuadBounds();
        return (quadBounds.getMaxX() + quadBounds.getMinX()) / 2.0f;
    }

    public double getMidY() {
        QuadBounds quadBounds = this.getQuadBounds();
        return (quadBounds.getMaxY() + quadBounds.getMinY()) / 2.0f;
    }

    public double getMidZ() {
        QuadBounds quadBounds = this.getQuadBounds();
        return (quadBounds.getMaxZ() + quadBounds.getMinZ()) / 2.0f;
    }

    public boolean isFaceQuad() {
        QuadBounds quadBounds = this.getQuadBounds();
        return quadBounds.isFaceQuad(this.face);
    }

    public boolean isFullQuad() {
        QuadBounds quadBounds = this.getQuadBounds();
        return quadBounds.isFullQuad(this.face);
    }

    public boolean isFullFaceQuad() {
        return this.isFullQuad() && this.isFaceQuad();
    }

    public BakedQuad getQuadEmissive() {
        if (this.quadEmissiveChecked) {
            return this.quadEmissive;
        }
        if (this.quadEmissive == null && this.sprite != null && this.sprite.spriteEmissive != null) {
            this.quadEmissive = new BreakingFour(this, this.sprite.spriteEmissive);
        }
        this.quadEmissiveChecked = true;
        return this.quadEmissive;
    }

    public String toString() {
        return "vertex: " + this.vertexData.length / 7 + ", tint: " + this.tintIndex + ", facing: " + String.valueOf(this.face) + ", sprite: " + String.valueOf(this.sprite);
    }
}


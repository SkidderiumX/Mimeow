/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer;

import com.google.common.primitives.Floats;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.renderer.vertex.VertexFormatElement;
import net.minecraft.src.Config;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.MathHelper;
import net.optifine.SmartAnimations;
import net.optifine.render.RenderEnv;
import net.optifine.shaders.SVertexBuilder;
import net.optifine.util.TextureUtils;
import org.apache.logging.log4j.LogManager;
import org.lwjgl.opengl.GL11;
import x.oc170ea29aae;

public class WorldRenderer {
    private ByteBuffer byteBuffer;
    public IntBuffer rawIntBuffer;
    private ShortBuffer rawShortBuffer;
    public FloatBuffer rawFloatBuffer;
    public int vertexCount;
    private VertexFormatElement vertexFormatElement;
    private int vertexFormatIndex;
    private boolean noColor;
    public int drawMode;
    private double xOffset;
    private double yOffset;
    private double zOffset;
    private VertexFormat vertexFormat;
    private boolean isDrawing;
    private EnumWorldBlockLayer blockLayer = null;
    private boolean[] drawnIcons = new boolean[256];
    private TextureAtlasSprite[] quadSprites = null;
    private TextureAtlasSprite[] quadSpritesPrev = null;
    private TextureAtlasSprite quadSprite = null;
    public SVertexBuilder sVertexBuilder;
    public RenderEnv renderEnv = null;
    public BitSet animatedSprites = null;
    public BitSet animatedSpritesCached = new BitSet();
    private boolean modeTriangles = false;
    private ByteBuffer byteBufferTriangles;

    public WorldRenderer(int n) {
        this.byteBuffer = GLAllocation.createDirectByteBuffer(n * 4);
        this.rawIntBuffer = this.byteBuffer.asIntBuffer();
        this.rawShortBuffer = this.byteBuffer.asShortBuffer();
        this.rawFloatBuffer = this.byteBuffer.asFloatBuffer();
        SVertexBuilder.initVertexBuilder(this);
    }

    private void growBuffer(int n) {
        if (n > this.rawIntBuffer.remaining()) {
            int n2 = this.byteBuffer.capacity();
            int n3 = n2 % 0x200000;
            int n4 = n3 + (((this.rawIntBuffer.position() + n) * 4 - n3) / 0x200000 + 1) * 0x200000;
            LogManager.getLogger().warn("Needed to grow BufferBuilder buffer: Old size " + n2 + " bytes, new size " + n4 + " bytes.");
            int n5 = this.rawIntBuffer.position();
            ByteBuffer byteBuffer = GLAllocation.createDirectByteBuffer(n4);
            this.byteBuffer.position(0);
            byteBuffer.put(this.byteBuffer);
            byteBuffer.rewind();
            this.byteBuffer = byteBuffer;
            this.rawFloatBuffer = this.byteBuffer.asFloatBuffer();
            this.rawIntBuffer = this.byteBuffer.asIntBuffer();
            this.rawIntBuffer.position(n5);
            this.rawShortBuffer = this.byteBuffer.asShortBuffer();
            this.rawShortBuffer.position(n5 << 1);
            if (this.quadSprites != null) {
                TextureAtlasSprite[] textureAtlasSpriteArray = this.quadSprites;
                int n6 = this.getBufferQuadSize();
                this.quadSprites = new TextureAtlasSprite[n6];
                System.arraycopy(textureAtlasSpriteArray, 0, this.quadSprites, 0, Math.min(textureAtlasSpriteArray.length, this.quadSprites.length));
                this.quadSpritesPrev = null;
            }
        }
    }

    public void sortVertexData(float f, float f2, float f3) {
        int n;
        int n2;
        int n3;
        int n4 = this.vertexCount / 4;
        final float[] fArray = new float[n4];
        for (int i = 0; i < n4; ++i) {
            fArray[i] = WorldRenderer.getDistanceSq(this.rawFloatBuffer, (float)((double)f + this.xOffset), (float)((double)f2 + this.yOffset), (float)((double)f3 + this.zOffset), this.vertexFormat.getIntegerSize(), i * this.vertexFormat.getNextOffset());
        }
        Integer[] integerArray = new Integer[n4];
        for (int i = 0; i < integerArray.length; ++i) {
            integerArray[i] = i;
        }
        Arrays.sort(integerArray, new Comparator<Integer>(){

            @Override
            public int compare(Integer n, Integer n2) {
                return Floats.compare(fArray[n2], fArray[n]);
            }
        });
        BitSet bitSet = new BitSet();
        int n5 = this.vertexFormat.getNextOffset();
        int[] nArray = new int[n5];
        int n6 = 0;
        while ((n6 = bitSet.nextClearBit(n6)) < integerArray.length) {
            n3 = integerArray[n6];
            if (n3 != n6) {
                this.rawIntBuffer.limit(n3 * n5 + n5);
                this.rawIntBuffer.position(n3 * n5);
                this.rawIntBuffer.get(nArray);
                n2 = n3;
                n = integerArray[n3];
                while (n2 != n6) {
                    this.rawIntBuffer.limit(n * n5 + n5);
                    this.rawIntBuffer.position(n * n5);
                    IntBuffer intBuffer = this.rawIntBuffer.slice();
                    this.rawIntBuffer.limit(n2 * n5 + n5);
                    this.rawIntBuffer.position(n2 * n5);
                    this.rawIntBuffer.put(intBuffer);
                    bitSet.set(n2);
                    n2 = n;
                    n = integerArray[n];
                }
                this.rawIntBuffer.limit(n6 * n5 + n5);
                this.rawIntBuffer.position(n6 * n5);
                this.rawIntBuffer.put(nArray);
            }
            bitSet.set(n6);
            ++n6;
        }
        this.rawIntBuffer.limit(this.rawIntBuffer.capacity());
        this.rawIntBuffer.position(this.getBufferSize());
        if (this.quadSprites != null) {
            TextureAtlasSprite[] textureAtlasSpriteArray = new TextureAtlasSprite[this.vertexCount / 4];
            n3 = this.vertexFormat.getNextOffset() / 4 * 4;
            for (n2 = 0; n2 < integerArray.length; ++n2) {
                n = integerArray[n2];
                textureAtlasSpriteArray[n2] = this.quadSprites[n];
            }
            System.arraycopy(textureAtlasSpriteArray, 0, this.quadSprites, 0, textureAtlasSpriteArray.length);
        }
    }

    public State getVertexState() {
        this.rawIntBuffer.rewind();
        int n = this.getBufferSize();
        this.rawIntBuffer.limit(n);
        int[] nArray = new int[n];
        this.rawIntBuffer.get(nArray);
        this.rawIntBuffer.limit(this.rawIntBuffer.capacity());
        this.rawIntBuffer.position(n);
        TextureAtlasSprite[] textureAtlasSpriteArray = null;
        if (this.quadSprites != null) {
            int n2 = this.vertexCount / 4;
            textureAtlasSpriteArray = new TextureAtlasSprite[n2];
            System.arraycopy(this.quadSprites, 0, textureAtlasSpriteArray, 0, n2);
        }
        return new State(nArray, new VertexFormat(this.vertexFormat), textureAtlasSpriteArray);
    }

    public int getBufferSize() {
        return this.vertexCount * this.vertexFormat.getIntegerSize();
    }

    private static float getDistanceSq(FloatBuffer floatBuffer, float f, float f2, float f3, int n, int n2) {
        float f4 = floatBuffer.get(n2 + n * 0 + 0);
        float f5 = floatBuffer.get(n2 + n * 0 + 1);
        float f6 = floatBuffer.get(n2 + n * 0 + 2);
        float f7 = floatBuffer.get(n2 + n * 1 + 0);
        float f8 = floatBuffer.get(n2 + n * 1 + 1);
        float f9 = floatBuffer.get(n2 + n * 1 + 2);
        float f10 = floatBuffer.get(n2 + n * 2 + 0);
        float f11 = floatBuffer.get(n2 + n * 2 + 1);
        float f12 = floatBuffer.get(n2 + n * 2 + 2);
        float f13 = floatBuffer.get(n2 + n * 3 + 0);
        float f14 = floatBuffer.get(n2 + n * 3 + 1);
        float f15 = floatBuffer.get(n2 + n * 3 + 2);
        float f16 = (f4 + f7 + f10 + f13) * 0.25f - f;
        float f17 = (f5 + f8 + f11 + f14) * 0.25f - f2;
        float f18 = (f6 + f9 + f12 + f15) * 0.25f - f3;
        return f16 * f16 + f17 * f17 + f18 * f18;
    }

    public void setVertexState(State state) {
        this.rawIntBuffer.clear();
        this.growBuffer(state.getRawBuffer().length);
        this.rawIntBuffer.put(state.getRawBuffer());
        this.vertexCount = state.getVertexCount();
        this.vertexFormat = new VertexFormat(state.getVertexFormat());
        if (state.stateQuadSprites != null) {
            if (this.quadSprites == null) {
                this.quadSprites = this.quadSpritesPrev;
            }
            if (this.quadSprites == null || this.quadSprites.length < this.getBufferQuadSize()) {
                this.quadSprites = new TextureAtlasSprite[this.getBufferQuadSize()];
            }
            TextureAtlasSprite[] textureAtlasSpriteArray = state.stateQuadSprites;
            System.arraycopy(textureAtlasSpriteArray, 0, this.quadSprites, 0, textureAtlasSpriteArray.length);
        } else {
            if (this.quadSprites != null) {
                this.quadSpritesPrev = this.quadSprites;
            }
            this.quadSprites = null;
        }
    }

    public void reset() {
        this.vertexCount = 0;
        this.vertexFormatElement = null;
        this.vertexFormatIndex = 0;
        this.quadSprite = null;
        if (SmartAnimations.isActive()) {
            if (this.animatedSprites == null) {
                this.animatedSprites = this.animatedSpritesCached;
            }
            this.animatedSprites.clear();
        } else if (this.animatedSprites != null) {
            this.animatedSprites = null;
        }
        this.modeTriangles = false;
    }

    public void begin(int n, VertexFormat vertexFormat) {
        if (this.isDrawing) {
            throw new IllegalStateException("Already building!");
        }
        this.isDrawing = true;
        this.reset();
        this.drawMode = n;
        this.vertexFormat = vertexFormat;
        this.vertexFormatElement = vertexFormat.getElement(this.vertexFormatIndex);
        this.noColor = false;
        this.byteBuffer.limit(this.byteBuffer.capacity());
        if (Config.isShaders()) {
            SVertexBuilder.endSetVertexFormat(this);
        }
        if (Config.isMultiTexture()) {
            if (this.blockLayer != null) {
                if (this.quadSprites == null) {
                    this.quadSprites = this.quadSpritesPrev;
                }
                if (this.quadSprites == null || this.quadSprites.length < this.getBufferQuadSize()) {
                    this.quadSprites = new TextureAtlasSprite[this.getBufferQuadSize()];
                }
            }
        } else {
            if (this.quadSprites != null) {
                this.quadSpritesPrev = this.quadSprites;
            }
            this.quadSprites = null;
        }
    }

    public WorldRenderer tex(double d, double d2) {
        if (this.quadSprite != null && this.quadSprites != null) {
            d = this.quadSprite.toSingleU((float)d);
            d2 = this.quadSprite.toSingleV((float)d2);
            this.quadSprites[this.vertexCount / 4] = this.quadSprite;
        }
        int n = this.vertexCount * this.vertexFormat.getNextOffset() + this.vertexFormat.getOffset(this.vertexFormatIndex);
        switch (this.vertexFormatElement.getType()) {
            case FLOAT: {
                this.byteBuffer.putFloat(n, (float)d);
                this.byteBuffer.putFloat(n + 4, (float)d2);
                break;
            }
            case UINT: 
            case INT: {
                this.byteBuffer.putInt(n, (int)d);
                this.byteBuffer.putInt(n + 4, (int)d2);
                break;
            }
            case USHORT: 
            case SHORT: {
                this.byteBuffer.putShort(n, (short)d2);
                this.byteBuffer.putShort(n + 2, (short)d);
                break;
            }
            case UBYTE: 
            case BYTE: {
                this.byteBuffer.put(n, (byte)d2);
                this.byteBuffer.put(n + 1, (byte)d);
            }
        }
        this.nextVertexFormatIndex();
        return this;
    }

    public WorldRenderer lightmap(int n, int n2) {
        int n3 = this.vertexCount * this.vertexFormat.getNextOffset() + this.vertexFormat.getOffset(this.vertexFormatIndex);
        switch (this.vertexFormatElement.getType()) {
            case FLOAT: {
                this.byteBuffer.putFloat(n3, n);
                this.byteBuffer.putFloat(n3 + 4, n2);
                break;
            }
            case UINT: 
            case INT: {
                this.byteBuffer.putInt(n3, n);
                this.byteBuffer.putInt(n3 + 4, n2);
                break;
            }
            case USHORT: 
            case SHORT: {
                this.byteBuffer.putShort(n3, (short)n2);
                this.byteBuffer.putShort(n3 + 2, (short)n);
                break;
            }
            case UBYTE: 
            case BYTE: {
                this.byteBuffer.put(n3, (byte)n2);
                this.byteBuffer.put(n3 + 1, (byte)n);
            }
        }
        this.nextVertexFormatIndex();
        return this;
    }

    public void putBrightness4(int n, int n2, int n3, int n4) {
        int n5 = (this.vertexCount - 4) * this.vertexFormat.getIntegerSize() + this.vertexFormat.getUvOffsetById(1) / 4;
        int n6 = this.vertexFormat.getNextOffset() >> 2;
        this.rawIntBuffer.put(n5, n);
        this.rawIntBuffer.put(n5 + n6, n2);
        this.rawIntBuffer.put(n5 + n6 * 2, n3);
        this.rawIntBuffer.put(n5 + n6 * 3, n4);
    }

    public void putPosition(double d, double d2, double d3) {
        int n = this.vertexFormat.getIntegerSize();
        int n2 = (this.vertexCount - 4) * n;
        for (int i = 0; i < 4; ++i) {
            int n3 = n2 + i * n;
            int n4 = n3 + 1;
            int n5 = n4 + 1;
            this.rawIntBuffer.put(n3, Float.floatToRawIntBits((float)(d + this.xOffset) + Float.intBitsToFloat(this.rawIntBuffer.get(n3))));
            this.rawIntBuffer.put(n4, Float.floatToRawIntBits((float)(d2 + this.yOffset) + Float.intBitsToFloat(this.rawIntBuffer.get(n4))));
            this.rawIntBuffer.put(n5, Float.floatToRawIntBits((float)(d3 + this.zOffset) + Float.intBitsToFloat(this.rawIntBuffer.get(n5))));
        }
    }

    public int getColorIndex(int n) {
        return ((this.vertexCount - n) * this.vertexFormat.getNextOffset() + this.vertexFormat.getColorOffset()) / 4;
    }

    public void putColorMultiplier(float f, float f2, float f3, int n) {
        int n2 = this.getColorIndex(n);
        int n3 = -1;
        if (!this.noColor) {
            n3 = this.rawIntBuffer.get(n2);
            if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
                int n4 = (int)((float)(n3 & 0xFF) * f);
                int n5 = (int)((float)(n3 >> 8 & 0xFF) * f2);
                int n6 = (int)((float)(n3 >> 16 & 0xFF) * f3);
                n3 &= 0xFF000000;
                n3 = n3 | n6 << 16 | n5 << 8 | n4;
            } else {
                int n7 = (int)((float)(n3 >> 24 & 0xFF) * f);
                int n8 = (int)((float)(n3 >> 16 & 0xFF) * f2);
                int n9 = (int)((float)(n3 >> 8 & 0xFF) * f3);
                n3 &= 0xFF;
                n3 = n3 | n7 << 24 | n8 << 16 | n9 << 8;
            }
        }
        this.rawIntBuffer.put(n2, n3);
    }

    private void putColor(int n, int n2) {
        int n3 = this.getColorIndex(n2);
        int n4 = n >> 16 & 0xFF;
        int n5 = n >> 8 & 0xFF;
        int n6 = n & 0xFF;
        int n7 = n >> 24 & 0xFF;
        this.putColorRGBA(n3, n4, n5, n6, n7);
    }

    public void putColorRGB_F(float f, float f2, float f3, int n) {
        int n2 = this.getColorIndex(n);
        int n3 = MathHelper.clamp_int((int)(f * 255.0f), 0, 255);
        int n4 = MathHelper.clamp_int((int)(f2 * 255.0f), 0, 255);
        int n5 = MathHelper.clamp_int((int)(f3 * 255.0f), 0, 255);
        this.putColorRGBA(n2, n3, n4, n5, 255);
    }

    public void putColorRGBA(int n, int n2, int n3, int n4, int n5) {
        if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
            this.rawIntBuffer.put(n, n5 << 24 | n4 << 16 | n3 << 8 | n2);
        } else {
            this.rawIntBuffer.put(n, n2 << 24 | n3 << 16 | n4 << 8 | n5);
        }
    }

    public void noColor() {
        this.noColor = true;
    }

    public WorldRenderer color(float f, float f2, float f3, float f4) {
        return this.color((int)(f * 255.0f), (int)(f2 * 255.0f), (int)(f3 * 255.0f), (int)(f4 * 255.0f));
    }

    public WorldRenderer color(int n, int n2, int n3, int n4) {
        if (this.noColor) {
            return this;
        }
        int n5 = this.vertexCount * this.vertexFormat.getNextOffset() + this.vertexFormat.getOffset(this.vertexFormatIndex);
        switch (this.vertexFormatElement.getType()) {
            case FLOAT: {
                this.byteBuffer.putFloat(n5, (float)n / 255.0f);
                this.byteBuffer.putFloat(n5 + 4, (float)n2 / 255.0f);
                this.byteBuffer.putFloat(n5 + 8, (float)n3 / 255.0f);
                this.byteBuffer.putFloat(n5 + 12, (float)n4 / 255.0f);
                break;
            }
            case UINT: 
            case INT: {
                this.byteBuffer.putFloat(n5, n);
                this.byteBuffer.putFloat(n5 + 4, n2);
                this.byteBuffer.putFloat(n5 + 8, n3);
                this.byteBuffer.putFloat(n5 + 12, n4);
                break;
            }
            case USHORT: 
            case SHORT: {
                this.byteBuffer.putShort(n5, (short)n);
                this.byteBuffer.putShort(n5 + 2, (short)n2);
                this.byteBuffer.putShort(n5 + 4, (short)n3);
                this.byteBuffer.putShort(n5 + 6, (short)n4);
                break;
            }
            case UBYTE: 
            case BYTE: {
                if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
                    this.byteBuffer.put(n5, (byte)n);
                    this.byteBuffer.put(n5 + 1, (byte)n2);
                    this.byteBuffer.put(n5 + 2, (byte)n3);
                    this.byteBuffer.put(n5 + 3, (byte)n4);
                    break;
                }
                this.byteBuffer.put(n5, (byte)n4);
                this.byteBuffer.put(n5 + 1, (byte)n3);
                this.byteBuffer.put(n5 + 2, (byte)n2);
                this.byteBuffer.put(n5 + 3, (byte)n);
            }
        }
        this.nextVertexFormatIndex();
        return this;
    }

    public void addVertexData(int[] nArray) {
        if (Config.isShaders()) {
            SVertexBuilder.beginAddVertexData(this, nArray);
        }
        this.growBuffer(nArray.length);
        this.rawIntBuffer.position(this.getBufferSize());
        this.rawIntBuffer.put(nArray);
        this.vertexCount += nArray.length / this.vertexFormat.getIntegerSize();
        if (Config.isShaders()) {
            SVertexBuilder.endAddVertexData(this);
        }
    }

    public void endVertex() {
        ++this.vertexCount;
        this.growBuffer(this.vertexFormat.getIntegerSize());
        this.vertexFormatIndex = 0;
        this.vertexFormatElement = this.vertexFormat.getElement(this.vertexFormatIndex);
        if (Config.isShaders()) {
            SVertexBuilder.endAddVertex(this);
        }
    }

    public WorldRenderer pos(double d, double d2, double d3) {
        if (Config.isShaders()) {
            SVertexBuilder.beginAddVertex(this);
        }
        int n = this.vertexCount * this.vertexFormat.getNextOffset() + this.vertexFormat.getOffset(this.vertexFormatIndex);
        switch (this.vertexFormatElement.getType()) {
            case FLOAT: {
                this.byteBuffer.putFloat(n, (float)(d + this.xOffset));
                this.byteBuffer.putFloat(n + 4, (float)(d2 + this.yOffset));
                this.byteBuffer.putFloat(n + 8, (float)(d3 + this.zOffset));
                break;
            }
            case UINT: 
            case INT: {
                this.byteBuffer.putInt(n, Float.floatToRawIntBits((float)(d + this.xOffset)));
                this.byteBuffer.putInt(n + 4, Float.floatToRawIntBits((float)(d2 + this.yOffset)));
                this.byteBuffer.putInt(n + 8, Float.floatToRawIntBits((float)(d3 + this.zOffset)));
                break;
            }
            case USHORT: 
            case SHORT: {
                this.byteBuffer.putShort(n, (short)(d + this.xOffset));
                this.byteBuffer.putShort(n + 2, (short)(d2 + this.yOffset));
                this.byteBuffer.putShort(n + 4, (short)(d3 + this.zOffset));
                break;
            }
            case UBYTE: 
            case BYTE: {
                this.byteBuffer.put(n, (byte)(d + this.xOffset));
                this.byteBuffer.put(n + 1, (byte)(d2 + this.yOffset));
                this.byteBuffer.put(n + 2, (byte)(d3 + this.zOffset));
            }
        }
        this.nextVertexFormatIndex();
        return this;
    }

    public void putNormal(float f, float f2, float f3) {
        int n = (byte)(f * 127.0f) & 0xFF;
        int n2 = (byte)(f2 * 127.0f) & 0xFF;
        int n3 = (byte)(f3 * 127.0f) & 0xFF;
        int n4 = n | n2 << 8 | n3 << 16;
        int n5 = this.vertexFormat.getNextOffset() >> 2;
        int n6 = (this.vertexCount - 4) * n5 + this.vertexFormat.getNormalOffset() / 4;
        this.rawIntBuffer.put(n6, n4);
        this.rawIntBuffer.put(n6 + n5, n4);
        this.rawIntBuffer.put(n6 + n5 * 2, n4);
        this.rawIntBuffer.put(n6 + n5 * 3, n4);
    }

    private void nextVertexFormatIndex() {
        ++this.vertexFormatIndex;
        this.vertexFormatIndex %= this.vertexFormat.getElementCount();
        this.vertexFormatElement = this.vertexFormat.getElement(this.vertexFormatIndex);
        if (this.vertexFormatElement.getUsage() == VertexFormatElement.EnumUsage.PADDING) {
            this.nextVertexFormatIndex();
        }
    }

    public WorldRenderer normal(float f, float f2, float f3) {
        int n = this.vertexCount * this.vertexFormat.getNextOffset() + this.vertexFormat.getOffset(this.vertexFormatIndex);
        switch (this.vertexFormatElement.getType()) {
            case FLOAT: {
                this.byteBuffer.putFloat(n, f);
                this.byteBuffer.putFloat(n + 4, f2);
                this.byteBuffer.putFloat(n + 8, f3);
                break;
            }
            case UINT: 
            case INT: {
                this.byteBuffer.putInt(n, (int)f);
                this.byteBuffer.putInt(n + 4, (int)f2);
                this.byteBuffer.putInt(n + 8, (int)f3);
                break;
            }
            case USHORT: 
            case SHORT: {
                this.byteBuffer.putShort(n, (short)((int)(f * 32767.0f) & 0xFFFF));
                this.byteBuffer.putShort(n + 2, (short)((int)(f2 * 32767.0f) & 0xFFFF));
                this.byteBuffer.putShort(n + 4, (short)((int)(f3 * 32767.0f) & 0xFFFF));
                break;
            }
            case UBYTE: 
            case BYTE: {
                this.byteBuffer.put(n, (byte)((int)(f * 127.0f) & 0xFF));
                this.byteBuffer.put(n + 1, (byte)((int)(f2 * 127.0f) & 0xFF));
                this.byteBuffer.put(n + 2, (byte)((int)(f3 * 127.0f) & 0xFF));
            }
        }
        this.nextVertexFormatIndex();
        return this;
    }

    public void setTranslation(double d, double d2, double d3) {
        this.xOffset = d;
        this.yOffset = d2;
        this.zOffset = d3;
    }

    public void finishDrawing() {
        if (!this.isDrawing) {
            throw new IllegalStateException("Not building!");
        }
        this.isDrawing = false;
        this.byteBuffer.position(0);
        this.byteBuffer.limit(this.getBufferSize() * 4);
    }

    public ByteBuffer getByteBuffer() {
        return this.modeTriangles ? this.byteBufferTriangles : this.byteBuffer;
    }

    public VertexFormat getVertexFormat() {
        return this.vertexFormat;
    }

    public int getVertexCount() {
        return this.modeTriangles ? this.vertexCount / 4 * 6 : this.vertexCount;
    }

    public int getDrawMode() {
        return this.modeTriangles ? 4 : this.drawMode;
    }

    public void putColor4(int n) {
        for (int i = 0; i < 4; ++i) {
            this.putColor(n, i + 1);
        }
    }

    public void putColorRGB_F4(float f, float f2, float f3) {
        for (int i = 0; i < 4; ++i) {
            this.putColorRGB_F(f, f2, f3, i + 1);
        }
    }

    public void putSprite(TextureAtlasSprite textureAtlasSprite) {
        if (this.animatedSprites != null && textureAtlasSprite != null && textureAtlasSprite.getAnimationIndex() >= 0) {
            this.animatedSprites.set(textureAtlasSprite.getAnimationIndex());
        }
        if (this.quadSprites != null) {
            int n = this.vertexCount / 4;
            this.quadSprites[n - 1] = textureAtlasSprite;
        }
    }

    public void setSprite(TextureAtlasSprite textureAtlasSprite) {
        if (this.animatedSprites != null && textureAtlasSprite != null && textureAtlasSprite.getAnimationIndex() >= 0) {
            this.animatedSprites.set(textureAtlasSprite.getAnimationIndex());
        }
        if (this.quadSprites != null) {
            this.quadSprite = textureAtlasSprite;
        }
    }

    public boolean isMultiTexture() {
        return this.quadSprites != null;
    }

    public void drawMultiTexture() {
        if (this.quadSprites != null) {
            int n = Config.getMinecraft().getTextureMapBlocks().getCountRegisteredSprites();
            if (this.drawnIcons.length <= n) {
                this.drawnIcons = new boolean[n + 1];
            }
            Arrays.fill(this.drawnIcons, false);
            int n2 = 0;
            int n3 = -1;
            int n4 = this.vertexCount / 4;
            for (int i = 0; i < n4; ++i) {
                int n5;
                TextureAtlasSprite textureAtlasSprite = this.quadSprites[i];
                if (textureAtlasSprite == null || this.drawnIcons[n5 = textureAtlasSprite.getIndexInMap()]) continue;
                if (textureAtlasSprite == TextureUtils.iconGrassSideOverlay) {
                    if (n3 >= 0) continue;
                    n3 = i;
                    continue;
                }
                i = this.drawForIcon(textureAtlasSprite, i) - 1;
                ++n2;
                if (this.blockLayer == EnumWorldBlockLayer.TRANSLUCENT) continue;
                this.drawnIcons[n5] = true;
            }
            if (n3 >= 0) {
                this.drawForIcon(TextureUtils.iconGrassSideOverlay, n3);
                ++n2;
            }
            if (n2 > 0) {
                // empty if block
            }
        }
    }

    private int drawForIcon(TextureAtlasSprite textureAtlasSprite, int n) {
        GL11.glBindTexture(3553, textureAtlasSprite.glSpriteTextureId);
        int n2 = -1;
        int n3 = -1;
        int n4 = this.vertexCount / 4;
        for (int i = n; i < n4; ++i) {
            TextureAtlasSprite textureAtlasSprite2 = this.quadSprites[i];
            if (textureAtlasSprite2 == textureAtlasSprite) {
                if (n3 >= 0) continue;
                n3 = i;
                continue;
            }
            if (n3 < 0) continue;
            this.draw(n3, i);
            if (this.blockLayer == EnumWorldBlockLayer.TRANSLUCENT) {
                return i;
            }
            n3 = -1;
            if (n2 >= 0) continue;
            n2 = i;
        }
        if (n3 >= 0) {
            this.draw(n3, n4);
        }
        if (n2 < 0) {
            n2 = n4;
        }
        return n2;
    }

    private void draw(int n, int n2) {
        int n3 = n2 - n;
        if (n3 > 0) {
            int n4 = n * 4;
            int n5 = n3 * 4;
            oc170ea29aae.\u03ad(this.drawMode, n4, n5);
        }
    }

    public void setBlockLayer(EnumWorldBlockLayer enumWorldBlockLayer) {
        this.blockLayer = enumWorldBlockLayer;
        if (enumWorldBlockLayer == null) {
            if (this.quadSprites != null) {
                this.quadSpritesPrev = this.quadSprites;
            }
            this.quadSprites = null;
            this.quadSprite = null;
        }
    }

    private int getBufferQuadSize() {
        int n = this.rawIntBuffer.capacity() * 4 / (this.vertexFormat.getIntegerSize() * 4);
        return n;
    }

    public RenderEnv getRenderEnv(IBlockState iBlockState, BlockPos blockPos) {
        if (this.renderEnv == null) {
            this.renderEnv = new RenderEnv(iBlockState, blockPos);
            return this.renderEnv;
        }
        this.renderEnv.reset(iBlockState, blockPos);
        return this.renderEnv;
    }

    public boolean isDrawing() {
        return this.isDrawing;
    }

    public double getXOffset() {
        return this.xOffset;
    }

    public double getYOffset() {
        return this.yOffset;
    }

    public double getZOffset() {
        return this.zOffset;
    }

    public EnumWorldBlockLayer getBlockLayer() {
        return this.blockLayer;
    }

    public void putColorMultiplierRgba(float f, float f2, float f3, float f4, int n) {
        int n2 = this.getColorIndex(n);
        int n3 = -1;
        if (!this.noColor) {
            n3 = this.rawIntBuffer.get(n2);
            if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
                int n4 = (int)((float)(n3 & 0xFF) * f);
                int n5 = (int)((float)(n3 >> 8 & 0xFF) * f2);
                int n6 = (int)((float)(n3 >> 16 & 0xFF) * f3);
                int n7 = (int)((float)(n3 >> 24 & 0xFF) * f4);
                n3 = n7 << 24 | n6 << 16 | n5 << 8 | n4;
            } else {
                int n8 = (int)((float)(n3 >> 24 & 0xFF) * f);
                int n9 = (int)((float)(n3 >> 16 & 0xFF) * f2);
                int n10 = (int)((float)(n3 >> 8 & 0xFF) * f3);
                int n11 = (int)((float)(n3 & 0xFF) * f4);
                n3 = n8 << 24 | n9 << 16 | n10 << 8 | n11;
            }
        }
        this.rawIntBuffer.put(n2, n3);
    }

    public void quadsToTriangles() {
        if (this.drawMode == 7) {
            if (this.byteBufferTriangles == null) {
                this.byteBufferTriangles = GLAllocation.createDirectByteBuffer(this.byteBuffer.capacity() * 2);
            }
            if (this.byteBufferTriangles.capacity() < this.byteBuffer.capacity() * 2) {
                this.byteBufferTriangles = GLAllocation.createDirectByteBuffer(this.byteBuffer.capacity() * 2);
            }
            int n = this.vertexFormat.getNextOffset();
            int n2 = this.byteBuffer.limit();
            this.byteBuffer.rewind();
            this.byteBufferTriangles.clear();
            for (int i = 0; i < this.vertexCount; i += 4) {
                this.byteBuffer.limit((i + 3) * n);
                this.byteBuffer.position(i * n);
                this.byteBufferTriangles.put(this.byteBuffer);
                this.byteBuffer.limit((i + 1) * n);
                this.byteBuffer.position(i * n);
                this.byteBufferTriangles.put(this.byteBuffer);
                this.byteBuffer.limit((i + 2 + 2) * n);
                this.byteBuffer.position((i + 2) * n);
                this.byteBufferTriangles.put(this.byteBuffer);
            }
            this.byteBuffer.limit(n2);
            this.byteBuffer.rewind();
            this.byteBufferTriangles.flip();
            this.modeTriangles = true;
        }
    }

    public boolean isColorDisabled() {
        return this.noColor;
    }

    public class State {
        private final int[] stateRawBuffer;
        private final VertexFormat stateVertexFormat;
        private TextureAtlasSprite[] stateQuadSprites;

        public State(int[] nArray, VertexFormat vertexFormat, TextureAtlasSprite[] textureAtlasSpriteArray) {
            this.stateRawBuffer = nArray;
            this.stateVertexFormat = vertexFormat;
            this.stateQuadSprites = textureAtlasSpriteArray;
        }

        public State(int[] nArray, VertexFormat vertexFormat) {
            this.stateRawBuffer = nArray;
            this.stateVertexFormat = vertexFormat;
        }

        public int[] getRawBuffer() {
            return this.stateRawBuffer;
        }

        public int getVertexCount() {
            return this.stateRawBuffer.length / this.stateVertexFormat.getIntegerSize();
        }

        public VertexFormat getVertexFormat() {
            return this.stateVertexFormat;
        }
    }
}


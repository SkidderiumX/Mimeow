/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.shaders;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import net.minecraft.block.Block;
import net.minecraft.block.state.BlockStateBase;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.optifine.shaders.BlockAliases;
import net.optifine.shaders.Shaders;
import org.lwjgl.opengl.GL20;

public class SVertexBuilder {
    int vertexSize;
    int offsetNormal;
    int offsetUV;
    int offsetUVCenter;
    boolean hasNormal;
    boolean hasTangent;
    boolean hasUV;
    boolean hasUVCenter;
    long[] entityData = new long[10];
    int entityDataIndex = 0;

    public SVertexBuilder() {
        this.entityData[this.entityDataIndex] = 0L;
    }

    public static void initVertexBuilder(WorldRenderer worldRenderer) {
        worldRenderer.sVertexBuilder = new SVertexBuilder();
    }

    public void pushEntity(long l) {
        ++this.entityDataIndex;
        this.entityData[this.entityDataIndex] = l;
    }

    public void popEntity() {
        this.entityData[this.entityDataIndex] = 0L;
        --this.entityDataIndex;
    }

    public static void pushEntity(IBlockState iBlockState, BlockPos blockPos, IBlockAccess iBlockAccess, WorldRenderer worldRenderer) {
        int n;
        int n2;
        Block block = iBlockState.getBlock();
        if (iBlockState instanceof BlockStateBase) {
            BlockStateBase blockStateBase = (BlockStateBase)iBlockState;
            n2 = blockStateBase.getBlockId();
            n = blockStateBase.getMetadata();
        } else {
            n2 = Block.getIdFromBlock(block);
            n = block.getMetaFromState(iBlockState);
        }
        int n3 = BlockAliases.getBlockAliasId(n2, n);
        if (n3 >= 0) {
            n2 = n3;
        }
        int n4 = block.getRenderType();
        int n5 = ((n4 & 0xFFFF) << 16) + (n2 & 0xFFFF);
        int n6 = n & 0xFFFF;
        worldRenderer.sVertexBuilder.pushEntity(((long)n6 << 32) + (long)n5);
    }

    public static void popEntity(WorldRenderer worldRenderer) {
        worldRenderer.sVertexBuilder.popEntity();
    }

    public static boolean popEntity(boolean bl, WorldRenderer worldRenderer) {
        worldRenderer.sVertexBuilder.popEntity();
        return bl;
    }

    public static void endSetVertexFormat(WorldRenderer worldRenderer) {
        SVertexBuilder sVertexBuilder = worldRenderer.sVertexBuilder;
        VertexFormat vertexFormat = worldRenderer.getVertexFormat();
        sVertexBuilder.vertexSize = vertexFormat.getNextOffset() / 4;
        sVertexBuilder.hasTangent = sVertexBuilder.hasNormal = vertexFormat.hasNormal();
        sVertexBuilder.hasUV = vertexFormat.hasUvOffset(0);
        sVertexBuilder.offsetNormal = sVertexBuilder.hasNormal ? vertexFormat.getNormalOffset() / 4 : 0;
        sVertexBuilder.offsetUV = sVertexBuilder.hasUV ? vertexFormat.getUvOffsetById(0) / 4 : 0;
        sVertexBuilder.offsetUVCenter = 8;
    }

    public static void beginAddVertex(WorldRenderer worldRenderer) {
        if (worldRenderer.vertexCount == 0) {
            SVertexBuilder.endSetVertexFormat(worldRenderer);
        }
    }

    public static void endAddVertex(WorldRenderer worldRenderer) {
        SVertexBuilder sVertexBuilder = worldRenderer.sVertexBuilder;
        if (sVertexBuilder.vertexSize == 14) {
            if (worldRenderer.drawMode == 7 && worldRenderer.vertexCount % 4 == 0) {
                sVertexBuilder.calcNormal(worldRenderer, worldRenderer.getBufferSize() - 4 * sVertexBuilder.vertexSize);
            }
            long l = sVertexBuilder.entityData[sVertexBuilder.entityDataIndex];
            int n = worldRenderer.getBufferSize() - 14 + 12;
            worldRenderer.rawIntBuffer.put(n, (int)l);
            worldRenderer.rawIntBuffer.put(n + 1, (int)(l >> 32));
        }
    }

    public static void beginAddVertexData(WorldRenderer worldRenderer, int[] nArray) {
        if (worldRenderer.vertexCount == 0) {
            SVertexBuilder.endSetVertexFormat(worldRenderer);
        }
        SVertexBuilder sVertexBuilder = worldRenderer.sVertexBuilder;
        if (sVertexBuilder.vertexSize == 14) {
            long l = sVertexBuilder.entityData[sVertexBuilder.entityDataIndex];
            int n = 12;
            while (n + 1 < nArray.length) {
                nArray[n] = (int)l;
                nArray[n + 1] = (int)(l >> 32);
                n += 14;
            }
        }
    }

    public static void beginAddVertexData(WorldRenderer worldRenderer, ByteBuffer byteBuffer) {
        if (worldRenderer.vertexCount == 0) {
            SVertexBuilder.endSetVertexFormat(worldRenderer);
        }
        SVertexBuilder sVertexBuilder = worldRenderer.sVertexBuilder;
        if (sVertexBuilder.vertexSize == 14) {
            long l = sVertexBuilder.entityData[sVertexBuilder.entityDataIndex];
            int n = byteBuffer.limit() / 4;
            int n2 = 12;
            while (n2 + 1 < n) {
                int n3 = (int)l;
                int n4 = (int)(l >> 32);
                byteBuffer.putInt(n2 * 4, n3);
                byteBuffer.putInt((n2 + 1) * 4, n4);
                n2 += 14;
            }
        }
    }

    public static void endAddVertexData(WorldRenderer worldRenderer) {
        SVertexBuilder sVertexBuilder = worldRenderer.sVertexBuilder;
        if (sVertexBuilder.vertexSize == 14 && worldRenderer.drawMode == 7 && worldRenderer.vertexCount % 4 == 0) {
            sVertexBuilder.calcNormal(worldRenderer, worldRenderer.getBufferSize() - 4 * sVertexBuilder.vertexSize);
        }
    }

    public void calcNormal(WorldRenderer worldRenderer, int n) {
        FloatBuffer floatBuffer = worldRenderer.rawFloatBuffer;
        IntBuffer intBuffer = worldRenderer.rawIntBuffer;
        int n2 = worldRenderer.getBufferSize();
        float f = floatBuffer.get(n + 0 * this.vertexSize);
        float f2 = floatBuffer.get(n + 0 * this.vertexSize + 1);
        float f3 = floatBuffer.get(n + 0 * this.vertexSize + 2);
        float f4 = floatBuffer.get(n + 0 * this.vertexSize + this.offsetUV);
        float f5 = floatBuffer.get(n + 0 * this.vertexSize + this.offsetUV + 1);
        float f6 = floatBuffer.get(n + 1 * this.vertexSize);
        float f7 = floatBuffer.get(n + 1 * this.vertexSize + 1);
        float f8 = floatBuffer.get(n + 1 * this.vertexSize + 2);
        float f9 = floatBuffer.get(n + 1 * this.vertexSize + this.offsetUV);
        float f10 = floatBuffer.get(n + 1 * this.vertexSize + this.offsetUV + 1);
        float f11 = floatBuffer.get(n + 2 * this.vertexSize);
        float f12 = floatBuffer.get(n + 2 * this.vertexSize + 1);
        float f13 = floatBuffer.get(n + 2 * this.vertexSize + 2);
        float f14 = floatBuffer.get(n + 2 * this.vertexSize + this.offsetUV);
        float f15 = floatBuffer.get(n + 2 * this.vertexSize + this.offsetUV + 1);
        float f16 = floatBuffer.get(n + 3 * this.vertexSize);
        float f17 = floatBuffer.get(n + 3 * this.vertexSize + 1);
        float f18 = floatBuffer.get(n + 3 * this.vertexSize + 2);
        float f19 = floatBuffer.get(n + 3 * this.vertexSize + this.offsetUV);
        float f20 = floatBuffer.get(n + 3 * this.vertexSize + this.offsetUV + 1);
        float f21 = f12 - f2;
        float f22 = f18 - f8;
        float f23 = f17 - f7;
        float f24 = f13 - f3;
        float f25 = f21 * f22 - f23 * f24;
        float f26 = f16 - f6;
        float f27 = f11 - f;
        float f28 = f24 * f26 - f22 * f27;
        float f29 = f27 * f23 - f26 * f21;
        float f30 = f25 * f25 + f28 * f28 + f29 * f29;
        float f31 = (double)f30 != 0.0 ? (float)(1.0 / Math.sqrt(f30)) : 1.0f;
        f25 *= f31;
        f28 *= f31;
        f29 *= f31;
        f27 = f6 - f;
        f21 = f7 - f2;
        f24 = f8 - f3;
        float f32 = f9 - f4;
        float f33 = f10 - f5;
        f26 = f11 - f;
        f23 = f12 - f2;
        f22 = f13 - f3;
        float f34 = f14 - f4;
        float f35 = f15 - f5;
        float f36 = f32 * f35 - f34 * f33;
        float f37 = f36 != 0.0f ? 1.0f / f36 : 1.0f;
        float f38 = (f35 * f27 - f33 * f26) * f37;
        float f39 = (f35 * f21 - f33 * f23) * f37;
        float f40 = (f35 * f24 - f33 * f22) * f37;
        float f41 = (f32 * f26 - f34 * f27) * f37;
        float f42 = (f32 * f23 - f34 * f21) * f37;
        float f43 = (f32 * f22 - f34 * f24) * f37;
        f30 = f38 * f38 + f39 * f39 + f40 * f40;
        f31 = (double)f30 != 0.0 ? (float)(1.0 / Math.sqrt(f30)) : 1.0f;
        f38 *= f31;
        f39 *= f31;
        f40 *= f31;
        f30 = f41 * f41 + f42 * f42 + f43 * f43;
        f31 = (double)f30 != 0.0 ? (float)(1.0 / Math.sqrt(f30)) : 1.0f;
        float f44 = f29 * f39 - f28 * f40;
        float f45 = f25 * f40 - f29 * f38;
        float f46 = f28 * f38 - f25 * f39;
        float f47 = (f41 *= f31) * f44 + (f42 *= f31) * f45 + (f43 *= f31) * f46 < 0.0f ? -1.0f : 1.0f;
        int n3 = (int)(f25 * 127.0f) & 0xFF;
        int n4 = (int)(f28 * 127.0f) & 0xFF;
        int n5 = (int)(f29 * 127.0f) & 0xFF;
        int n6 = (n5 << 16) + (n4 << 8) + n3;
        intBuffer.put(n + 0 * this.vertexSize + this.offsetNormal, n6);
        intBuffer.put(n + 1 * this.vertexSize + this.offsetNormal, n6);
        intBuffer.put(n + 2 * this.vertexSize + this.offsetNormal, n6);
        intBuffer.put(n + 3 * this.vertexSize + this.offsetNormal, n6);
        int n7 = ((int)(f38 * 32767.0f) & 0xFFFF) + (((int)(f39 * 32767.0f) & 0xFFFF) << 16);
        int n8 = ((int)(f40 * 32767.0f) & 0xFFFF) + (((int)(f47 * 32767.0f) & 0xFFFF) << 16);
        intBuffer.put(n + 0 * this.vertexSize + 10, n7);
        intBuffer.put(n + 0 * this.vertexSize + 10 + 1, n8);
        intBuffer.put(n + 1 * this.vertexSize + 10, n7);
        intBuffer.put(n + 1 * this.vertexSize + 10 + 1, n8);
        intBuffer.put(n + 2 * this.vertexSize + 10, n7);
        intBuffer.put(n + 2 * this.vertexSize + 10 + 1, n8);
        intBuffer.put(n + 3 * this.vertexSize + 10, n7);
        intBuffer.put(n + 3 * this.vertexSize + 10 + 1, n8);
        float f48 = (f4 + f9 + f14 + f19) / 4.0f;
        float f49 = (f5 + f10 + f15 + f20) / 4.0f;
        floatBuffer.put(n + 0 * this.vertexSize + 8, f48);
        floatBuffer.put(n + 0 * this.vertexSize + 8 + 1, f49);
        floatBuffer.put(n + 1 * this.vertexSize + 8, f48);
        floatBuffer.put(n + 1 * this.vertexSize + 8 + 1, f49);
        floatBuffer.put(n + 2 * this.vertexSize + 8, f48);
        floatBuffer.put(n + 2 * this.vertexSize + 8 + 1, f49);
        floatBuffer.put(n + 3 * this.vertexSize + 8, f48);
        floatBuffer.put(n + 3 * this.vertexSize + 8 + 1, f49);
    }

    public static void calcNormalChunkLayer(WorldRenderer worldRenderer) {
        if (worldRenderer.getVertexFormat().hasNormal() && worldRenderer.drawMode == 7 && worldRenderer.vertexCount % 4 == 0) {
            SVertexBuilder sVertexBuilder = worldRenderer.sVertexBuilder;
            SVertexBuilder.endSetVertexFormat(worldRenderer);
            int n = worldRenderer.vertexCount * sVertexBuilder.vertexSize;
            for (int i = 0; i < n; i += sVertexBuilder.vertexSize * 4) {
                sVertexBuilder.calcNormal(worldRenderer, i);
            }
        }
    }

    public static void drawArrays(int n, int n2, int n3, WorldRenderer worldRenderer) {
        if (n3 != 0) {
            VertexFormat vertexFormat = worldRenderer.getVertexFormat();
            int n4 = vertexFormat.getNextOffset();
            if (n4 == 56) {
                ByteBuffer byteBuffer = worldRenderer.getByteBuffer();
                byteBuffer.position(32);
                GL20.glVertexAttribPointer(Shaders.midTexCoordAttrib, 2, 5126, false, n4, byteBuffer);
                byteBuffer.position(40);
                GL20.glVertexAttribPointer(Shaders.tangentAttrib, 4, 5122, false, n4, byteBuffer);
                byteBuffer.position(48);
                GL20.glVertexAttribPointer(Shaders.entityAttrib, 3, 5122, false, n4, byteBuffer);
                byteBuffer.position(0);
                GL20.glEnableVertexAttribArray(Shaders.midTexCoordAttrib);
                GL20.glEnableVertexAttribArray(Shaders.tangentAttrib);
                GL20.glEnableVertexAttribArray(Shaders.entityAttrib);
                GlStateManager.glDrawArrays(n, n2, n3);
                GL20.glDisableVertexAttribArray(Shaders.midTexCoordAttrib);
                GL20.glDisableVertexAttribArray(Shaders.tangentAttrib);
                GL20.glDisableVertexAttribArray(Shaders.entityAttrib);
            } else {
                GlStateManager.glDrawArrays(n, n2, n3);
            }
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package net.optifine;

import net.minecraft.world.World;
import net.optifine.LightMap;

public class LightMapPack {
    private LightMap lightMap;
    private LightMap lightMapRain;
    private LightMap lightMapThunder;
    private int[] colorBuffer1 = new int[0];
    private int[] colorBuffer2 = new int[0];

    public LightMapPack(LightMap lightMap, LightMap lightMap2, LightMap lightMap3) {
        if (lightMap2 != null || lightMap3 != null) {
            if (lightMap2 == null) {
                lightMap2 = lightMap;
            }
            if (lightMap3 == null) {
                lightMap3 = lightMap2;
            }
        }
        this.lightMap = lightMap;
        this.lightMapRain = lightMap2;
        this.lightMapThunder = lightMap3;
    }

    public boolean updateLightmap(World world2, float f, int[] nArray, boolean bl, float f2) {
        if (this.lightMapRain == null && this.lightMapThunder == null) {
            return this.lightMap.updateLightmap(world2, f, nArray, bl);
        }
        int n = world2.provider.getDimensionId();
        if (n != 1 && n != -1) {
            boolean bl2;
            float f3 = world2.getRainStrength(f2);
            float f4 = world2.getThunderStrength(f2);
            float f5 = 1.0E-4f;
            boolean bl3 = f3 > f5;
            boolean bl4 = bl2 = f4 > f5;
            if (!bl3 && !bl2) {
                return this.lightMap.updateLightmap(world2, f, nArray, bl);
            }
            if (f3 > 0.0f) {
                f4 /= f3;
            }
            float f6 = 1.0f - f3;
            float f7 = f3 - f4;
            if (this.colorBuffer1.length != nArray.length) {
                this.colorBuffer1 = new int[nArray.length];
                this.colorBuffer2 = new int[nArray.length];
            }
            int n2 = 0;
            int[][] nArrayArray = new int[][]{nArray, this.colorBuffer1, this.colorBuffer2};
            float[] fArray = new float[3];
            if (f6 > f5 && this.lightMap.updateLightmap(world2, f, nArrayArray[n2], bl)) {
                fArray[n2] = f6;
                ++n2;
            }
            if (f7 > f5 && this.lightMapRain != null && this.lightMapRain.updateLightmap(world2, f, nArrayArray[n2], bl)) {
                fArray[n2] = f7;
                ++n2;
            }
            if (f4 > f5 && this.lightMapThunder != null && this.lightMapThunder.updateLightmap(world2, f, nArrayArray[n2], bl)) {
                fArray[n2] = f4;
                ++n2;
            }
            return n2 == 2 ? this.blend(nArrayArray[0], fArray[0], nArrayArray[1], fArray[1]) : (n2 == 3 ? this.blend(nArrayArray[0], fArray[0], nArrayArray[1], fArray[1], nArrayArray[2], fArray[2]) : true);
        }
        return this.lightMap.updateLightmap(world2, f, nArray, bl);
    }

    private boolean blend(int[] nArray, float f, int[] nArray2, float f2) {
        if (nArray2.length != nArray.length) {
            return false;
        }
        for (int i = 0; i < nArray.length; ++i) {
            int n = nArray[i];
            int n2 = n >> 16 & 0xFF;
            int n3 = n >> 8 & 0xFF;
            int n4 = n & 0xFF;
            int n5 = nArray2[i];
            int n6 = n5 >> 16 & 0xFF;
            int n7 = n5 >> 8 & 0xFF;
            int n8 = n5 & 0xFF;
            int n9 = (int)((float)n2 * f + (float)n6 * f2);
            int n10 = (int)((float)n3 * f + (float)n7 * f2);
            int n11 = (int)((float)n4 * f + (float)n8 * f2);
            nArray[i] = 0xFF000000 | n9 << 16 | n10 << 8 | n11;
        }
        return true;
    }

    private boolean blend(int[] nArray, float f, int[] nArray2, float f2, int[] nArray3, float f3) {
        if (nArray2.length == nArray.length && nArray3.length == nArray.length) {
            for (int i = 0; i < nArray.length; ++i) {
                int n = nArray[i];
                int n2 = n >> 16 & 0xFF;
                int n3 = n >> 8 & 0xFF;
                int n4 = n & 0xFF;
                int n5 = nArray2[i];
                int n6 = n5 >> 16 & 0xFF;
                int n7 = n5 >> 8 & 0xFF;
                int n8 = n5 & 0xFF;
                int n9 = nArray3[i];
                int n10 = n9 >> 16 & 0xFF;
                int n11 = n9 >> 8 & 0xFF;
                int n12 = n9 & 0xFF;
                int n13 = (int)((float)n2 * f + (float)n6 * f2 + (float)n10 * f3);
                int n14 = (int)((float)n3 * f + (float)n7 * f2 + (float)n11 * f3);
                int n15 = (int)((float)n4 * f + (float)n8 * f2 + (float)n12 * f3);
                nArray[i] = 0xFF000000 | n13 << 16 | n14 << 8 | n15;
            }
            return true;
        }
        return false;
    }
}


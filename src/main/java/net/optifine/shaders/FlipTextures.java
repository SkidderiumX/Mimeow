/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.shaders;

import java.nio.IntBuffer;
import java.util.Arrays;

public class FlipTextures {
    private IntBuffer textures;
    private int indexFlipped;
    private boolean[] flips;
    private boolean[] changed;

    public FlipTextures(IntBuffer intBuffer, int n) {
        this.textures = intBuffer;
        this.indexFlipped = n;
        this.flips = new boolean[intBuffer.capacity()];
        this.changed = new boolean[intBuffer.capacity()];
    }

    public int getA(int n) {
        return this.get(n, this.flips[n]);
    }

    public int getB(int n) {
        return this.get(n, !this.flips[n]);
    }

    private int get(int n, boolean bl) {
        int n2 = bl ? this.indexFlipped : 0;
        return this.textures.get(n2 + n);
    }

    public void flip(int n) {
        this.flips[n] = !this.flips[n];
        this.changed[n] = true;
    }

    public boolean isChanged(int n) {
        return this.changed[n];
    }

    public void reset() {
        Arrays.fill(this.flips, false);
        Arrays.fill(this.changed, false);
    }
}


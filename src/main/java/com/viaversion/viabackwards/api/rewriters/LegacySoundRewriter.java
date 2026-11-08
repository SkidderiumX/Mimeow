/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.api.rewriters;

import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viaversion.api.rewriter.RewriterBase;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectOpenHashMap;

@Deprecated
public abstract class LegacySoundRewriter<T extends BackwardsProtocol<?, ?, ?, ?>>
extends RewriterBase<T> {
    protected final Int2ObjectMap<SoundData> soundRewrites = new Int2ObjectOpenHashMap<SoundData>(64);

    protected LegacySoundRewriter(T t) {
        super(t);
    }

    public SoundData added(int n, int n2) {
        return this.added(n, n2, -1.0f);
    }

    public SoundData added(int n, int n2, float f) {
        SoundData soundData = new SoundData(n2, true, f, true);
        this.soundRewrites.put(n, soundData);
        return soundData;
    }

    public SoundData removed(int n) {
        SoundData soundData = new SoundData(-1, false, -1.0f, false);
        this.soundRewrites.put(n, soundData);
        return soundData;
    }

    public int handleSounds(int n) {
        int n2 = n;
        SoundData soundData = (SoundData)this.soundRewrites.get(n);
        if (soundData != null) {
            return soundData.replacementSound();
        }
        for (Int2ObjectMap.Entry entry : this.soundRewrites.int2ObjectEntrySet()) {
            if (n <= entry.getIntKey()) continue;
            if (((SoundData)entry.getValue()).added()) {
                --n2;
                continue;
            }
            ++n2;
        }
        return n2;
    }

    public boolean hasPitch(int n) {
        SoundData soundData = (SoundData)this.soundRewrites.get(n);
        return soundData != null && soundData.changePitch();
    }

    public float handlePitch(int n) {
        SoundData soundData = (SoundData)this.soundRewrites.get(n);
        return soundData != null ? soundData.newPitch() : 1.0f;
    }

    public record SoundData(int replacementSound, boolean changePitch, float newPitch, boolean added) {
    }
}


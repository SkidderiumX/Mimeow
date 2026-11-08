/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.resources.data;

import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.minecraft.client.resources.data.AnimationFrame;
import net.minecraft.client.resources.data.IMetadataSection;

public class AnimationMetadataSection
implements IMetadataSection {
    private final List<AnimationFrame> animationFrames;
    private final int frameWidth;
    private final int frameHeight;
    private final int frameTime;
    private final boolean interpolate;

    public AnimationMetadataSection(List<AnimationFrame> list, int n, int n2, int n3, boolean bl) {
        this.animationFrames = list;
        this.frameWidth = n;
        this.frameHeight = n2;
        this.frameTime = n3;
        this.interpolate = bl;
    }

    public int getFrameHeight() {
        return this.frameHeight;
    }

    public int getFrameWidth() {
        return this.frameWidth;
    }

    public int getFrameCount() {
        return this.animationFrames.size();
    }

    public int getFrameTime() {
        return this.frameTime;
    }

    public boolean isInterpolate() {
        return this.interpolate;
    }

    private AnimationFrame getAnimationFrame(int n) {
        return this.animationFrames.get(n);
    }

    public int getFrameTimeSingle(int n) {
        AnimationFrame animationFrame = this.getAnimationFrame(n);
        return animationFrame.hasNoTime() ? this.frameTime : animationFrame.getFrameTime();
    }

    public boolean frameHasTime(int n) {
        return !this.animationFrames.get(n).hasNoTime();
    }

    public int getFrameIndex(int n) {
        return this.animationFrames.get(n).getFrameIndex();
    }

    public Set<Integer> getFrameIndexSet() {
        HashSet<Integer> hashSet = Sets.newHashSet();
        for (AnimationFrame animationFrame : this.animationFrames) {
            hashSet.add(animationFrame.getFrameIndex());
        }
        return hashSet;
    }
}


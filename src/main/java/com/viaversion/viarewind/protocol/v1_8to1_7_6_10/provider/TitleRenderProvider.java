/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.protocol.v1_8to1_7_6_10.provider;

import com.viaversion.viaversion.api.platform.providers.Provider;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class TitleRenderProvider
implements Provider {
    protected Map<UUID, Integer> fadeIn = new HashMap<UUID, Integer>();
    protected Map<UUID, Integer> stay = new HashMap<UUID, Integer>();
    protected Map<UUID, Integer> fadeOut = new HashMap<UUID, Integer>();
    protected Map<UUID, String> titles = new HashMap<UUID, String>();
    protected Map<UUID, String> subTitles = new HashMap<UUID, String>();
    protected Map<UUID, AtomicInteger> times = new HashMap<UUID, AtomicInteger>();

    public void setTimings(UUID uUID, int n, int n2, int n3) {
        this.setFadeIn(uUID, n);
        this.setStay(uUID, n2);
        this.setFadeOut(uUID, n3);
        AtomicInteger atomicInteger = this.getTime(uUID);
        if (atomicInteger.get() > 0) {
            atomicInteger.set(this.getFadeIn(uUID) + this.getStay(uUID) + this.getFadeOut(uUID));
        }
    }

    public void reset(UUID uUID) {
        this.titles.remove(uUID);
        this.subTitles.remove(uUID);
        this.getTime(uUID).set(0);
        this.fadeIn.remove(uUID);
        this.stay.remove(uUID);
        this.fadeOut.remove(uUID);
    }

    public void setTitle(UUID uUID, String string) {
        this.titles.put(uUID, string);
        this.getTime(uUID).set(this.getFadeIn(uUID) + this.getStay(uUID) + this.getFadeOut(uUID));
    }

    public void setSubTitle(UUID uUID, String string) {
        this.subTitles.put(uUID, string);
    }

    public void clear(UUID uUID) {
        this.titles.remove(uUID);
        this.subTitles.remove(uUID);
        this.getTime(uUID).set(0);
    }

    public AtomicInteger getTime(UUID uUID2) {
        return this.times.computeIfAbsent(uUID2, uUID -> new AtomicInteger(0));
    }

    public int getFadeIn(UUID uUID) {
        return this.fadeIn.getOrDefault(uUID, 10);
    }

    public int getStay(UUID uUID) {
        return this.stay.getOrDefault(uUID, 70);
    }

    public int getFadeOut(UUID uUID) {
        return this.fadeOut.getOrDefault(uUID, 20);
    }

    public void setFadeIn(UUID uUID, int n) {
        if (n >= 0) {
            this.fadeIn.put(uUID, n);
        } else {
            this.fadeIn.remove(uUID);
        }
    }

    public void setStay(UUID uUID, int n) {
        if (n >= 0) {
            this.stay.put(uUID, n);
        } else {
            this.stay.remove(uUID);
        }
    }

    public void setFadeOut(UUID uUID, int n) {
        if (n >= 0) {
            this.fadeOut.put(uUID, n);
        } else {
            this.fadeOut.remove(uUID);
        }
    }
}


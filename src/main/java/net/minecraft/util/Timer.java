/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import net.minecraft.client.Minecraft;
import net.minecraft.util.MathHelper;

public class Timer {
    float ticksPerSecond;
    private double lastHRTime;
    public int elapsedTicks;
    public float renderPartialTicks;
    public float timerSpeed = 1.0f;
    public float elapsedPartialTicks;
    private long lastSyncSysClock;
    private long lastSyncHRClock;
    private long counter;
    private double timeSyncAdjustment = 1.0;

    public Timer(float f) {
        this.ticksPerSecond = f;
        this.lastSyncSysClock = Minecraft.getSystemTime();
        this.lastSyncHRClock = System.nanoTime() / 1000000L;
    }

    public void updateTimer() {
        long l = Minecraft.getSystemTime();
        long l2 = l - this.lastSyncSysClock;
        long l3 = System.nanoTime() / 1000000L;
        double d = (double)l3 / 1000.0;
        if (l2 <= 1000L && l2 >= 0L) {
            this.counter += l2;
            if (this.counter > 1000L) {
                long l4 = l3 - this.lastSyncHRClock;
                double d2 = (double)this.counter / (double)l4;
                this.timeSyncAdjustment += (d2 - this.timeSyncAdjustment) * (double)0.2f;
                this.lastSyncHRClock = l3;
                this.counter = 0L;
            }
            if (this.counter < 0L) {
                this.lastSyncHRClock = l3;
            }
        } else {
            this.lastHRTime = d;
        }
        this.lastSyncSysClock = l;
        double d3 = (d - this.lastHRTime) * this.timeSyncAdjustment;
        this.lastHRTime = d;
        d3 = MathHelper.clamp_double(d3, 0.0, 1.0);
        this.elapsedPartialTicks = (float)((double)this.elapsedPartialTicks + d3 * (double)this.timerSpeed * (double)this.ticksPerSecond);
        this.elapsedTicks = (int)this.elapsedPartialTicks;
        this.elapsedPartialTicks -= (float)this.elapsedTicks;
        if (this.elapsedTicks > 10) {
            this.elapsedTicks = 10;
        }
        this.renderPartialTicks = this.elapsedPartialTicks;
    }
}


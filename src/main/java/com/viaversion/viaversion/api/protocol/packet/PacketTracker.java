/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.protocol.packet;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.configuration.RateLimitConfig;
import com.viaversion.viaversion.api.configuration.ViaVersionConfig;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.util.MathUtil;
import java.util.Arrays;

public class PacketTracker {
    private static final long SECOND_NANOS = 1000000000L;
    private final RateTracker packetTracker = new RateTracker(5);
    private final RateTracker packetSizeTracker = new RateTracker(3);
    private long startTime = System.nanoTime();
    private boolean packetLimiterEnabled = true;
    private final UserConnection connection;
    private long sentPacketsTotal;
    private long receivedPacketsTotal;

    public PacketTracker(UserConnection userConnection) {
        this.connection = userConnection;
    }

    public void incrementSent() {
        ++this.sentPacketsTotal;
    }

    @Deprecated(forRemoval=true)
    public boolean incrementReceived() {
        return this.incrementReceived(0);
    }

    public boolean incrementReceived(int n) {
        ++this.receivedPacketsTotal;
        ViaVersionConfig viaVersionConfig = Via.getConfig();
        long l = System.nanoTime();
        long l2 = l - this.startTime;
        if (l2 < 1000000000L) {
            if (viaVersionConfig.getPacketTrackerConfig().enabled()) {
                this.packetTracker.add(1);
            }
            if (viaVersionConfig.getPacketSizeTrackerConfig().enabled()) {
                this.packetSizeTracker.add(n);
            }
            return false;
        }
        if (viaVersionConfig.getPacketTrackerConfig().enabled()) {
            this.packetTracker.updateRate(l2);
            this.packetTracker.add(1);
        }
        if (viaVersionConfig.getPacketSizeTrackerConfig().enabled()) {
            this.packetSizeTracker.updateRate(l2);
            this.packetSizeTracker.add(n);
        }
        this.startTime = l;
        return true;
    }

    public boolean exceedsLimits() {
        if (this.connection.isClientSide()) {
            return false;
        }
        ViaVersionConfig viaVersionConfig = Via.getConfig();
        return this.packetTracker.exceedsLimit(this.connection, viaVersionConfig.getPacketTrackerConfig()) || this.packetSizeTracker.exceedsLimit(this.connection, viaVersionConfig.getPacketSizeTrackerConfig());
    }

    public long getSentPackets() {
        return this.sentPacketsTotal;
    }

    @Deprecated(forRemoval=true)
    public void setSentPackets(long l) {
        this.sentPacketsTotal = l;
    }

    public long getReceivedPackets() {
        return this.receivedPacketsTotal;
    }

    @Deprecated(forRemoval=true)
    public void setReceivedPackets(long l) {
        this.receivedPacketsTotal = l;
    }

    public long getIntervalPackets() {
        return this.packetTracker.count;
    }

    public void setIntervalPackets(long l) {
        this.packetTracker.count = l;
    }

    public int getPacketsPerSecond() {
        return this.packetTracker.smoothedRate;
    }

    public boolean isPacketLimiterEnabled() {
        ViaVersionConfig viaVersionConfig = Via.getConfig();
        return this.packetLimiterEnabled && (viaVersionConfig.getPacketTrackerConfig().enabled() || viaVersionConfig.getPacketSizeTrackerConfig().enabled());
    }

    public void setPacketLimiterEnabled(boolean bl) {
        this.packetLimiterEnabled = bl;
    }

    @Deprecated(forRemoval=true)
    public void setWarnings(int n) {
        this.packetTracker.warnings = n;
    }

    public void reset() {
        this.sentPacketsTotal = 0L;
        this.receivedPacketsTotal = 0L;
        this.startTime = System.nanoTime();
        this.packetTracker.reset();
        this.packetSizeTracker.reset();
    }

    private static final class RateTracker {
        private final int[] history;
        private int historyIndex;
        private int historyCount;
        private int smoothedRate = -1;
        private long count;
        private long warningPeriodStart = System.nanoTime();
        private long lastWarning = Long.MIN_VALUE;
        private int warnings;

        public RateTracker(int n) {
            this.history = new int[n];
        }

        public void add(int n) {
            this.count += (long)n;
        }

        public void updateRate(long l) {
            long l2 = this.count * 1000000000L / l;
            this.history[this.historyIndex] = (int)MathUtil.clamp(l2, 0L, Integer.MAX_VALUE);
            this.historyIndex = (this.historyIndex + 1) % this.history.length;
            if (this.historyCount < this.history.length) {
                ++this.historyCount;
            }
            long l3 = 0L;
            for (int i = 0; i < this.historyCount; ++i) {
                l3 += (long)this.history[i];
            }
            this.smoothedRate = (int)(l3 / (long)this.historyCount);
            this.count = 0L;
        }

        public boolean exceedsLimit(UserConnection userConnection, RateLimitConfig rateLimitConfig) {
            if (!rateLimitConfig.enabled()) {
                return false;
            }
            if (rateLimitConfig.maxRate() > 0 && this.count >= (long)rateLimitConfig.maxRate()) {
                userConnection.disconnect(rateLimitConfig.maxRateKickMessage().replace(rateLimitConfig.ratePlaceholder(), Long.toString(this.count)));
                return true;
            }
            if (rateLimitConfig.maxWarnings() > 0 && rateLimitConfig.trackingPeriodNanos() > 0L && rateLimitConfig.warningRate() > 0) {
                return this.checkTrackedInterval(userConnection, rateLimitConfig);
            }
            return false;
        }

        private boolean checkTrackedInterval(UserConnection userConnection, RateLimitConfig rateLimitConfig) {
            long l = System.nanoTime();
            if (l - this.warningPeriodStart >= rateLimitConfig.trackingPeriodNanos()) {
                this.warnings = 0;
                this.warningPeriodStart = l;
            }
            if (this.smoothedRate >= rateLimitConfig.warningRate() && l - this.lastWarning >= 1000000000L) {
                this.lastWarning = l;
                if (++this.warnings >= rateLimitConfig.maxWarnings()) {
                    userConnection.disconnect(rateLimitConfig.warningKickMessage().replace(rateLimitConfig.ratePlaceholder(), Integer.toString(this.smoothedRate)));
                    return true;
                }
            }
            return false;
        }

        public void reset() {
            this.count = 0L;
            this.smoothedRate = -1;
            this.warnings = 0;
            this.warningPeriodStart = System.nanoTime();
            this.historyIndex = 0;
            this.historyCount = 0;
            Arrays.fill(this.history, 0);
        }
    }
}


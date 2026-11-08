/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.protocol.v1_9to1_8.storage;

import com.viaversion.viarewind.ViaRewind;
import com.viaversion.viarewind.protocol.v1_9to1_8.cooldown.CooldownVisualization;
import com.viaversion.viarewind.protocol.v1_9to1_8.storage.BlockPlaceDestroyTracker;
import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.util.Pair;
import java.util.List;
import java.util.logging.Level;

public class CooldownStorage
implements StorableObject {
    private CooldownVisualization.Factory visualizationFactory = CooldownVisualization.Factory.fromConfiguration();
    private CooldownVisualization current;
    private double attackSpeed = 4.0;
    private long lastHit = 0L;

    public void tick(UserConnection userConnection) {
        if (!this.hasCooldown()) {
            this.endCurrentVisualization();
            return;
        }
        BlockPlaceDestroyTracker blockPlaceDestroyTracker = userConnection.get(BlockPlaceDestroyTracker.class);
        if (blockPlaceDestroyTracker.isMining()) {
            this.lastHit = 0L;
            this.endCurrentVisualization();
            return;
        }
        if (this.current == null) {
            this.current = this.visualizationFactory.create(userConnection);
        }
        try {
            this.current.show(this.getCooldown());
        }
        catch (Exception exception) {
            ViaRewind.getPlatform().getLogger().log(Level.WARNING, "Unable to show cooldown visualization", exception);
        }
    }

    private void endCurrentVisualization() {
        if (this.current != null) {
            try {
                this.current.hide();
            }
            catch (Exception exception) {
                ViaRewind.getPlatform().getLogger().log(Level.WARNING, "Unable to hide cooldown visualization", exception);
            }
            this.current = null;
        }
    }

    public boolean hasCooldown() {
        long l = System.currentTimeMillis() - this.lastHit;
        double d = this.restrain((double)l * this.attackSpeed / 1000.0, 1.5);
        return d > 0.1 && d < 1.1;
    }

    public double getCooldown() {
        long l = System.currentTimeMillis() - this.lastHit;
        return this.restrain((double)l * this.attackSpeed / 1000.0, 1.0);
    }

    private double restrain(double d, double d2) {
        if (d < 0.0) {
            return 0.0;
        }
        return Math.min(d, d2);
    }

    public void setAttackSpeed(double d, List<Pair<Byte, Double>> list) {
        int n;
        this.attackSpeed = d;
        for (n = 0; n < list.size(); ++n) {
            if (list.get(n).key() != 0) continue;
            this.attackSpeed += list.get(n).value().doubleValue();
            list.remove(n--);
        }
        for (n = 0; n < list.size(); ++n) {
            if (list.get(n).key() != 1) continue;
            this.attackSpeed += d * list.get(n).value();
            list.remove(n--);
        }
        for (n = 0; n < list.size(); ++n) {
            if (list.get(n).key() != 2) continue;
            this.attackSpeed *= 1.0 + list.get(n).value();
            list.remove(n--);
        }
    }

    public void hit() {
        this.lastHit = System.currentTimeMillis();
    }

    public void setLastHit(long l) {
        this.lastHit = l;
    }

    public CooldownVisualization.Factory getVisualizationFactory() {
        return this.visualizationFactory;
    }

    public void setVisualizationFactory(CooldownVisualization.Factory factory) {
        this.visualizationFactory = factory;
    }
}


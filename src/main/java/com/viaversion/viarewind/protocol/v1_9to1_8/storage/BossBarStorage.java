/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.protocol.v1_9to1_8.storage;

import com.viaversion.viarewind.protocol.v1_9to1_8.data.WitherBossBar;
import com.viaversion.viarewind.protocol.v1_9to1_8.storage.PlayerPositionTracker;
import com.viaversion.viaversion.api.connection.StoredObject;
import com.viaversion.viaversion.api.connection.UserConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BossBarStorage
extends StoredObject {
    private final Map<UUID, WitherBossBar> bossBars = new HashMap<UUID, WitherBossBar>();

    public BossBarStorage(UserConnection userConnection) {
        super(userConnection);
    }

    public void reset() {
        this.updateLocation();
        this.changeWorld();
    }

    public void add(UUID uUID, String string, float f) {
        WitherBossBar witherBossBar = new WitherBossBar(this.getUser(), uUID, string, f);
        PlayerPositionTracker playerPositionTracker = this.getUser().get(PlayerPositionTracker.class);
        witherBossBar.setPlayerLocation(playerPositionTracker.getPosX(), playerPositionTracker.getPosY(), playerPositionTracker.getPosZ(), playerPositionTracker.getYaw(), playerPositionTracker.getPitch());
        witherBossBar.show();
        this.bossBars.put(uUID, witherBossBar);
    }

    public void remove(UUID uUID) {
        WitherBossBar witherBossBar = this.bossBars.remove(uUID);
        if (witherBossBar == null) {
            return;
        }
        witherBossBar.hide();
    }

    public void updateLocation() {
        PlayerPositionTracker playerPositionTracker = this.getUser().get(PlayerPositionTracker.class);
        this.bossBars.values().forEach(witherBossBar -> {
            try {
                witherBossBar.setPlayerLocation(playerPositionTracker.getPosX(), playerPositionTracker.getPosY(), playerPositionTracker.getPosZ(), playerPositionTracker.getYaw(), playerPositionTracker.getPitch());
            }
            catch (Exception exception) {
                throw new RuntimeException(exception);
            }
        });
    }

    public void changeWorld() {
        this.bossBars.values().forEach(witherBossBar -> {
            witherBossBar.hide();
            witherBossBar.show();
        });
    }

    public void updateHealth(UUID uUID, float f) {
        WitherBossBar witherBossBar = this.bossBars.get(uUID);
        if (witherBossBar == null) {
            return;
        }
        witherBossBar.setHealth(f);
    }

    public void updateTitle(UUID uUID, String string) {
        WitherBossBar witherBossBar = this.bossBars.get(uUID);
        if (witherBossBar == null) {
            return;
        }
        witherBossBar.setTitle(string);
    }
}


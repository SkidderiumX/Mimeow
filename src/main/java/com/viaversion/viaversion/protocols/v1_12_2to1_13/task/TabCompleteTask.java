/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_12_2to1_13.task;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.connection.StorableObjectTask;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.storage.TabCompleteTracker;

public class TabCompleteTask
extends StorableObjectTask<TabCompleteTracker> {
    public TabCompleteTask() {
        super(TabCompleteTracker.class);
    }

    @Override
    public void run(UserConnection userConnection, TabCompleteTracker tabCompleteTracker) {
        tabCompleteTracker.sendPacketToServer(userConnection);
    }
}


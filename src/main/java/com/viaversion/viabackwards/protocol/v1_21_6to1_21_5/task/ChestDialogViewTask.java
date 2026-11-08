/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.task;

import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.storage.ChestDialogStorage;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.connection.StorableObjectTask;

public class ChestDialogViewTask
extends StorableObjectTask<ChestDialogStorage> {
    public ChestDialogViewTask() {
        super(ChestDialogStorage.class);
    }

    @Override
    public void run(UserConnection userConnection, ChestDialogStorage chestDialogStorage) {
        chestDialogStorage.tick(userConnection);
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.connection;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.connection.UserConnection;

public abstract class StorableObjectTask<T extends StorableObject>
implements Runnable {
    private final Class<T> storableObject;

    protected StorableObjectTask(Class<T> clazz) {
        this.storableObject = clazz;
    }

    public abstract void run(UserConnection var1, T var2);

    @Override
    public void run() {
        for (UserConnection userConnection : Via.getManager().getConnectionManager().getConnections()) {
            if (!userConnection.isActive() || !userConnection.has(this.storableObject)) continue;
            userConnection.getChannel().eventLoop().execute(() -> {
                T t = userConnection.get(this.storableObject);
                if (t != null) {
                    this.run(userConnection, t);
                }
            });
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.api.entities.storage;

import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.entities.storage.EntityPositionStorage;
import com.viaversion.viabackwards.api.rewriters.EntityRewriterBase;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.entity.TrackedEntity;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import java.util.function.Supplier;

public class EntityPositionHandler {
    public static final double RELATIVE_MOVE_FACTOR = 4096.0;
    private final EntityRewriterBase<?, ?> entityRewriter;
    private final Class<? extends EntityPositionStorage> storageClass;
    private final Supplier<? extends EntityPositionStorage> storageSupplier;

    public EntityPositionHandler(EntityRewriterBase<?, ?> entityRewriterBase, Class<? extends EntityPositionStorage> clazz, Supplier<? extends EntityPositionStorage> supplier) {
        this.entityRewriter = entityRewriterBase;
        this.storageClass = clazz;
        this.storageSupplier = supplier;
    }

    public void cacheEntityPosition(PacketWrapper packetWrapper, boolean bl, boolean bl2) {
        this.cacheEntityPosition(packetWrapper, packetWrapper.get(Types.DOUBLE, 0), packetWrapper.get(Types.DOUBLE, 1), packetWrapper.get(Types.DOUBLE, 2), bl, bl2);
    }

    public void cacheEntityPosition(PacketWrapper packetWrapper, double d, double d2, double d3, boolean bl, boolean bl2) {
        this.cacheEntityPosition(packetWrapper, packetWrapper.get(Types.VAR_INT, 0), d, d2, d3, bl, bl2);
    }

    public void cacheEntityPosition(PacketWrapper packetWrapper, int n, double d, double d2, double d3, boolean bl, boolean bl2) {
        EntityPositionStorage entityPositionStorage;
        TrackedEntity trackedEntity = this.entityRewriter.tracker(packetWrapper.user()).entity(n);
        if (trackedEntity == null) {
            return;
        }
        if (bl) {
            entityPositionStorage = this.storageSupplier.get();
            trackedEntity.put(entityPositionStorage);
        } else {
            entityPositionStorage = trackedEntity.get(this.storageClass);
            if (entityPositionStorage == null) {
                ((BackwardsProtocol)this.entityRewriter.protocol()).getLogger().warning("Stored entity with id " + n + " missing " + this.storageClass.getSimpleName());
                return;
            }
        }
        if (bl2) {
            entityPositionStorage.addRelativePosition(d, d2, d3);
        } else {
            entityPositionStorage.setPosition(d, d2, d3);
        }
    }

    public EntityPositionStorage getStorage(UserConnection userConnection, int n) {
        EntityPositionStorage entityPositionStorage;
        TrackedEntity trackedEntity = this.entityRewriter.tracker(userConnection).entity(n);
        if (trackedEntity == null || (entityPositionStorage = trackedEntity.get(EntityPositionStorage.class)) == null) {
            ((BackwardsProtocol)this.entityRewriter.protocol()).getLogger().warning("Untracked entity with id " + n + " in " + this.storageClass.getSimpleName());
            return null;
        }
        return entityPositionStorage;
    }

    public static void writeFacingAngles(PacketWrapper packetWrapper, double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d4 - d;
        double d8 = d5 - d2;
        double d9 = d6 - d3;
        double d10 = Math.sqrt(d7 * d7 + d8 * d8 + d9 * d9);
        double d11 = -Math.atan2(d7, d9) / Math.PI * 180.0;
        if (d11 < 0.0) {
            d11 = 360.0 + d11;
        }
        double d12 = -Math.asin(d8 / d10) / Math.PI * 180.0;
        packetWrapper.write(Types.BYTE, (byte)(d11 * 256.0 / 360.0));
        packetWrapper.write(Types.BYTE, (byte)(d12 * 256.0 / 360.0));
    }

    public static void writeFacingDegrees(PacketWrapper packetWrapper, double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d4 - d;
        double d8 = d5 - d2;
        double d9 = d6 - d3;
        double d10 = Math.sqrt(d7 * d7 + d8 * d8 + d9 * d9);
        double d11 = -Math.atan2(d7, d9) / Math.PI * 180.0;
        if (d11 < 0.0) {
            d11 = 360.0 + d11;
        }
        double d12 = -Math.asin(d8 / d10) / Math.PI * 180.0;
        packetWrapper.write(Types.FLOAT, Float.valueOf((float)d11));
        packetWrapper.write(Types.FLOAT, Float.valueOf((float)d12));
    }
}


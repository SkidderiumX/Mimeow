/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_19to1_18_2.storage;

import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import java.util.UUID;

public class StoredPainting
implements StorableObject {
    private final int entityId;
    private final UUID uuid;
    private final BlockPosition position;
    private final byte direction;
    private int type;

    public StoredPainting(int n, UUID uUID, BlockPosition blockPosition, byte by) {
        this.entityId = n;
        this.uuid = uUID;
        this.position = blockPosition;
        this.direction = by;
    }

    public StoredPainting(int n, UUID uUID, BlockPosition blockPosition, int n2) {
        this(n, uUID, blockPosition, StoredPainting.to2dDirection(n2));
    }

    private static byte to2dDirection(int n) {
        return switch (n) {
            case 0, 1 -> -1;
            case 2 -> 2;
            case 3 -> 0;
            case 4 -> 1;
            case 5 -> 3;
            default -> throw new IllegalArgumentException("Invalid direction: " + n);
        };
    }

    public int entityId() {
        return this.entityId;
    }

    public UUID uuid() {
        return this.uuid;
    }

    public BlockPosition position() {
        return this.position;
    }

    public byte direction() {
        return this.direction;
    }

    public int type() {
        return this.type;
    }

    public void setType(int n) {
        this.type = n;
    }
}


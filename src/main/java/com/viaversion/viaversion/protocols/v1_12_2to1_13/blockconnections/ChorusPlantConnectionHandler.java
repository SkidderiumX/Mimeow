/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.BlockFace;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.AbstractFenceConnectionHandler;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.ConnectionData;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.WrappedBlockData;
import java.util.ArrayList;
import java.util.List;

public class ChorusPlantConnectionHandler
extends AbstractFenceConnectionHandler {
    private final int endstone = ConnectionData.getId("minecraft:end_stone");

    static List<ConnectionData.ConnectorInitAction> init() {
        ArrayList<ConnectionData.ConnectorInitAction> arrayList = new ArrayList<ConnectionData.ConnectorInitAction>(2);
        ChorusPlantConnectionHandler chorusPlantConnectionHandler = new ChorusPlantConnectionHandler();
        arrayList.add(chorusPlantConnectionHandler.getInitAction("minecraft:chorus_plant"));
        arrayList.add(chorusPlantConnectionHandler.getExtraAction());
        return arrayList;
    }

    public ChorusPlantConnectionHandler() {
        super(null);
    }

    private ConnectionData.ConnectorInitAction getExtraAction() {
        return wrappedBlockData -> {
            if (wrappedBlockData.getMinecraftKey().equals("minecraft:chorus_flower")) {
                this.getBlockStates().add(wrappedBlockData.getSavedBlockStateId());
            }
        };
    }

    @Override
    protected byte getStates(WrappedBlockData wrappedBlockData) {
        byte by = super.getStates(wrappedBlockData);
        if (wrappedBlockData.getValue("up").equals("true")) {
            by = (byte)(by | 0x10);
        }
        if (wrappedBlockData.getValue("down").equals("true")) {
            by = (byte)(by | 0x20);
        }
        return by;
    }

    @Override
    protected byte statesSize() {
        return 64;
    }

    @Override
    protected byte getStates(UserConnection userConnection, BlockPosition blockPosition) {
        byte by = super.getStates(userConnection, blockPosition);
        if (this.connects(BlockFace.TOP, this.getBlockData(userConnection, blockPosition.getRelative(BlockFace.TOP)), false)) {
            by = (byte)(by | 0x10);
        }
        if (this.connects(BlockFace.BOTTOM, this.getBlockData(userConnection, blockPosition.getRelative(BlockFace.BOTTOM)), false)) {
            by = (byte)(by | 0x20);
        }
        return by;
    }

    @Override
    protected boolean connects(BlockFace blockFace, int n, boolean bl) {
        return this.getBlockStates().contains(n) || blockFace == BlockFace.BOTTOM && n == this.endstone;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.BlockFace;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.libs.fastutil.ints.IntOpenHashSet;
import com.viaversion.viaversion.libs.fastutil.ints.IntSet;
import com.viaversion.viaversion.libs.fastutil.objects.Object2IntMap;
import com.viaversion.viaversion.libs.fastutil.objects.Object2IntOpenHashMap;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.ConnectionData;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.ConnectionHandler;
import java.util.HashSet;

public class SnowyGrassConnectionHandler
implements ConnectionHandler {
    private static final Object2IntMap<GrassBlock> GRASS_BLOCKS = new Object2IntOpenHashMap<GrassBlock>();
    private static final IntSet SNOWY_GRASS_BLOCKS = new IntOpenHashSet();

    static ConnectionData.ConnectorInitAction init() {
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add("minecraft:grass_block");
        hashSet.add("minecraft:podzol");
        hashSet.add("minecraft:mycelium");
        GRASS_BLOCKS.defaultReturnValue(-1);
        SnowyGrassConnectionHandler snowyGrassConnectionHandler = new SnowyGrassConnectionHandler();
        return wrappedBlockData -> {
            if (hashSet.contains(wrappedBlockData.getMinecraftKey())) {
                ConnectionData.connectionHandlerMap.put(wrappedBlockData.getSavedBlockStateId(), (ConnectionHandler)snowyGrassConnectionHandler);
                wrappedBlockData.set("snowy", "true");
                GRASS_BLOCKS.put(new GrassBlock(wrappedBlockData.getSavedBlockStateId(), true), wrappedBlockData.getBlockStateId());
                wrappedBlockData.set("snowy", "false");
                GRASS_BLOCKS.put(new GrassBlock(wrappedBlockData.getSavedBlockStateId(), false), wrappedBlockData.getBlockStateId());
            }
            if (wrappedBlockData.getMinecraftKey().equals("minecraft:snow") || wrappedBlockData.getMinecraftKey().equals("minecraft:snow_block")) {
                ConnectionData.connectionHandlerMap.put(wrappedBlockData.getSavedBlockStateId(), (ConnectionHandler)snowyGrassConnectionHandler);
                SNOWY_GRASS_BLOCKS.add(wrappedBlockData.getSavedBlockStateId());
            }
        };
    }

    @Override
    public int connect(UserConnection userConnection, BlockPosition blockPosition, int n) {
        int n2 = this.getBlockData(userConnection, blockPosition.getRelative(BlockFace.TOP));
        int n3 = GRASS_BLOCKS.getInt(new GrassBlock(n, SNOWY_GRASS_BLOCKS.contains(n2)));
        return n3 != -1 ? n3 : n;
    }

    private record GrassBlock(int blockStateId, boolean snowy) {
    }
}


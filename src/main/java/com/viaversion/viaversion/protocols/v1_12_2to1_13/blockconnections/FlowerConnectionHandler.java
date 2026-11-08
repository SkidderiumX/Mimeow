/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.BlockFace;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntOpenHashMap;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.ConnectionData;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.ConnectionHandler;
import java.util.HashSet;

public class FlowerConnectionHandler
implements ConnectionHandler {
    private static final Int2IntMap FLOWERS = new Int2IntOpenHashMap();

    static ConnectionData.ConnectorInitAction init() {
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add("minecraft:rose_bush");
        hashSet.add("minecraft:sunflower");
        hashSet.add("minecraft:peony");
        hashSet.add("minecraft:tall_grass");
        hashSet.add("minecraft:large_fern");
        hashSet.add("minecraft:lilac");
        FlowerConnectionHandler flowerConnectionHandler = new FlowerConnectionHandler();
        return wrappedBlockData -> {
            if (hashSet.contains(wrappedBlockData.getMinecraftKey())) {
                ConnectionData.connectionHandlerMap.put(wrappedBlockData.getSavedBlockStateId(), (ConnectionHandler)flowerConnectionHandler);
                if (wrappedBlockData.getValue("half").equals("lower")) {
                    wrappedBlockData.set("half", "upper");
                    FLOWERS.put(wrappedBlockData.getSavedBlockStateId(), wrappedBlockData.getBlockStateId());
                }
            }
        };
    }

    @Override
    public int connect(UserConnection userConnection, BlockPosition blockPosition, int n) {
        int n2 = this.getBlockData(userConnection, blockPosition.getRelative(BlockFace.BOTTOM));
        int n3 = FLOWERS.get(n2);
        if (n3 != 0) {
            int n4 = this.getBlockData(userConnection, blockPosition.getRelative(BlockFace.TOP));
            if (Via.getConfig().isStemWhenBlockAbove() ? n4 == 0 : !FLOWERS.containsKey(n4)) {
                return n3;
            }
        }
        return n;
    }
}


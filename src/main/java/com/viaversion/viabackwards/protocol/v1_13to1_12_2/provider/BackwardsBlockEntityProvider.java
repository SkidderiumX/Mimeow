/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_13to1_12_2.provider;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viabackwards.protocol.v1_13to1_12_2.block_entity_handlers.BannerHandler;
import com.viaversion.viabackwards.protocol.v1_13to1_12_2.block_entity_handlers.BedHandler;
import com.viaversion.viabackwards.protocol.v1_13to1_12_2.block_entity_handlers.FlowerPotHandler;
import com.viaversion.viabackwards.protocol.v1_13to1_12_2.block_entity_handlers.PistonHandler;
import com.viaversion.viabackwards.protocol.v1_13to1_12_2.block_entity_handlers.SkullHandler;
import com.viaversion.viabackwards.protocol.v1_13to1_12_2.block_entity_handlers.SpawnerHandler;
import com.viaversion.viabackwards.protocol.v1_13to1_12_2.storage.BackwardsBlockStorage;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.platform.providers.Provider;
import com.viaversion.viaversion.util.Key;
import java.util.HashMap;
import java.util.Map;

public class BackwardsBlockEntityProvider
implements Provider {
    private final Map<String, BackwardsBlockEntityHandler> handlers = new HashMap<String, BackwardsBlockEntityHandler>();

    public BackwardsBlockEntityProvider() {
        this.handlers.put("flower_pot", new FlowerPotHandler());
        this.handlers.put("bed", new BedHandler());
        this.handlers.put("banner", new BannerHandler());
        this.handlers.put("skull", new SkullHandler());
        this.handlers.put("mob_spawner", new SpawnerHandler());
        this.handlers.put("piston", new PistonHandler());
    }

    public boolean isHandled(String string) {
        return this.handlers.containsKey(Key.stripMinecraftNamespace(string));
    }

    public CompoundTag transform(UserConnection userConnection, BlockPosition blockPosition, CompoundTag compoundTag) {
        StringTag stringTag = compoundTag.getStringTag("id");
        if (stringTag == null) {
            return compoundTag;
        }
        String string = stringTag.getValue();
        BackwardsBlockEntityHandler backwardsBlockEntityHandler = this.handlers.get(Key.stripMinecraftNamespace(string));
        if (backwardsBlockEntityHandler == null) {
            return compoundTag;
        }
        BackwardsBlockStorage backwardsBlockStorage = userConnection.get(BackwardsBlockStorage.class);
        Integer n = backwardsBlockStorage.get(blockPosition);
        if (n == null) {
            return compoundTag;
        }
        return backwardsBlockEntityHandler.transform(n, compoundTag);
    }

    public CompoundTag transform(UserConnection userConnection, BlockPosition blockPosition, String string) {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putString("id", string);
        compoundTag.putInt("x", Math.toIntExact(blockPosition.x()));
        compoundTag.putInt("y", Math.toIntExact(blockPosition.y()));
        compoundTag.putInt("z", Math.toIntExact(blockPosition.z()));
        return this.transform(userConnection, blockPosition, compoundTag);
    }

    @FunctionalInterface
    public static interface BackwardsBlockEntityHandler {
        public CompoundTag transform(int var1, CompoundTag var2);
    }
}


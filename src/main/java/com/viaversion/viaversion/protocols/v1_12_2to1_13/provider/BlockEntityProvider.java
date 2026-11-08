/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_12_2to1_13.provider;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.platform.providers.Provider;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.Protocol1_12_2To1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ClientboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.provider.blockentities.BannerHandler;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.provider.blockentities.BedHandler;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.provider.blockentities.CommandBlockHandler;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.provider.blockentities.FlowerPotHandler;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.provider.blockentities.SkullHandler;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.provider.blockentities.SpawnerHandler;
import com.viaversion.viaversion.util.ComponentUtil;
import java.util.HashMap;
import java.util.Map;

public class BlockEntityProvider
implements Provider {
    private final Map<String, BlockEntityHandler> handlers = new HashMap<String, BlockEntityHandler>();

    public BlockEntityProvider() {
        this.handlers.put("minecraft:flower_pot", new FlowerPotHandler());
        this.handlers.put("minecraft:bed", new BedHandler());
        this.handlers.put("minecraft:banner", new BannerHandler());
        this.handlers.put("minecraft:skull", new SkullHandler());
        this.handlers.put("minecraft:mob_spawner", new SpawnerHandler());
        this.handlers.put("minecraft:command_block", new CommandBlockHandler());
        BlockEntityHandler blockEntityHandler = (userConnection, compoundTag) -> {
            StringTag stringTag = compoundTag.getStringTag("CustomName");
            if (stringTag != null) {
                stringTag.setValue(ComponentUtil.legacyToJsonString(stringTag.getValue()));
            }
            return -1;
        };
        this.handlers.put("minecraft:chest", blockEntityHandler);
        this.handlers.put("minecraft:dispenser", blockEntityHandler);
        this.handlers.put("minecraft:dropper", blockEntityHandler);
        this.handlers.put("minecraft:enchanting_table", blockEntityHandler);
        this.handlers.put("minecraft:furnace", blockEntityHandler);
        this.handlers.put("minecraft:hopper", blockEntityHandler);
        this.handlers.put("minecraft:shulker_box", blockEntityHandler);
    }

    public int transform(UserConnection userConnection, BlockPosition blockPosition, CompoundTag compoundTag, boolean bl) {
        StringTag stringTag = compoundTag.getStringTag("id");
        if (stringTag == null) {
            return -1;
        }
        BlockEntityHandler blockEntityHandler = this.handlers.get(stringTag.getValue());
        if (blockEntityHandler == null) {
            if (Via.getManager().isDebug()) {
                Protocol1_12_2To1_13.LOGGER.warning("Unhandled BlockEntity " + stringTag.getValue() + " full tag: " + String.valueOf(compoundTag));
            }
            return -1;
        }
        int n = blockEntityHandler.transform(userConnection, compoundTag);
        if (bl && n != -1) {
            this.sendBlockChange(userConnection, blockPosition, n);
        }
        return n;
    }

    private void sendBlockChange(UserConnection userConnection, BlockPosition blockPosition, int n) {
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_13.BLOCK_UPDATE, null, userConnection);
        packetWrapper.write(Types.BLOCK_POSITION1_8, blockPosition);
        packetWrapper.write(Types.VAR_INT, n);
        packetWrapper.send(Protocol1_12_2To1_13.class);
    }

    @FunctionalInterface
    public static interface BlockEntityHandler {
        public int transform(UserConnection var1, CompoundTag var2);
    }
}


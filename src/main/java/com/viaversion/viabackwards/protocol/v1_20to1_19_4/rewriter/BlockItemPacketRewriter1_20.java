/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_20to1_19_4.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.api.rewriters.BackwardsItemRewriter;
import com.viaversion.viabackwards.protocol.v1_20to1_19_4.Protocol1_20To1_19_4;
import com.viaversion.viabackwards.protocol.v1_20to1_19_4.storage.BackSignEditStorage;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.BlockChangeRecord;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.packet.ClientboundPackets1_19_4;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.packet.ServerboundPackets1_19_4;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.rewriter.RecipeRewriter1_19_4;
import com.viaversion.viaversion.util.Key;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.checkerframework.checker.nullness.qual.Nullable;

public class BlockItemPacketRewriter1_20
extends BackwardsItemRewriter<ClientboundPackets1_19_4, ServerboundPackets1_19_4, Protocol1_20To1_19_4> {
    private static final Set<String> NEW_TRIM_PATTERNS = new HashSet<String>(Arrays.asList("host", "raiser", "shaper", "silence", "wayfinder"));

    public BlockItemPacketRewriter1_20(Protocol1_20To1_19_4 protocol1_20To1_19_4) {
        super(protocol1_20To1_19_4, Types.ITEM1_13_2, Types.ITEM1_13_2_ARRAY);
    }

    @Override
    public void registerPackets() {
        ((Protocol1_20To1_19_4)this.protocol).replaceClientbound(ClientboundPackets1_19_4.LEVEL_CHUNK_WITH_LIGHT, new PacketHandlers(){

            @Override
            protected void register() {
                this.handler(packetWrapper -> {
                    Chunk chunk = ((Protocol1_20To1_19_4)BlockItemPacketRewriter1_20.this.protocol).getBlockRewriter().handleChunk1_18(packetWrapper);
                    ((Protocol1_20To1_19_4)BlockItemPacketRewriter1_20.this.protocol).getBlockRewriter().handleBlockEntities(chunk, packetWrapper.user());
                });
                this.create(Types.BOOLEAN, true);
            }
        });
        ((Protocol1_20To1_19_4)this.protocol).registerClientbound(ClientboundPackets1_19_4.LIGHT_UPDATE, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.write(Types.BOOLEAN, true);
        });
        ((Protocol1_20To1_19_4)this.protocol).replaceClientbound(ClientboundPackets1_19_4.SECTION_BLOCKS_UPDATE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.LONG);
                this.create(Types.BOOLEAN, false);
                this.handler(packetWrapper -> {
                    for (BlockChangeRecord blockChangeRecord : packetWrapper.passthrough(Types.VAR_LONG_BLOCK_CHANGE_ARRAY)) {
                        blockChangeRecord.setBlockId(((Protocol1_20To1_19_4)BlockItemPacketRewriter1_20.this.protocol).getMappingData().getNewBlockStateId(blockChangeRecord.getBlockId()));
                    }
                });
            }
        });
        ((Protocol1_20To1_19_4)this.protocol).replaceClientbound(ClientboundPackets1_19_4.UPDATE_ADVANCEMENTS, packetWrapper -> {
            packetWrapper.passthrough(Types.BOOLEAN);
            int n = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n; ++i) {
                int n2;
                packetWrapper.passthrough(Types.STRING);
                packetWrapper.passthrough(Types.OPTIONAL_STRING);
                if (packetWrapper.passthrough(Types.BOOLEAN).booleanValue()) {
                    packetWrapper.passthrough(Types.COMPONENT);
                    packetWrapper.passthrough(Types.COMPONENT);
                    this.passthroughClientboundItem(packetWrapper);
                    packetWrapper.passthrough(Types.VAR_INT);
                    n2 = packetWrapper.passthrough(Types.INT);
                    if ((n2 & 1) != 0) {
                        packetWrapper.passthrough(Types.STRING);
                    }
                    packetWrapper.passthrough(Types.FLOAT);
                    packetWrapper.passthrough(Types.FLOAT);
                }
                packetWrapper.passthrough(Types.STRING_ARRAY);
                n2 = packetWrapper.passthrough(Types.VAR_INT);
                for (int j = 0; j < n2; ++j) {
                    packetWrapper.passthrough(Types.STRING_ARRAY);
                }
                packetWrapper.read(Types.BOOLEAN);
            }
        });
        ((Protocol1_20To1_19_4)this.protocol).registerClientbound(ClientboundPackets1_19_4.OPEN_SIGN_EDITOR, packetWrapper -> {
            BlockPosition blockPosition = packetWrapper.passthrough(Types.BLOCK_POSITION1_14);
            boolean bl = packetWrapper.read(Types.BOOLEAN);
            if (bl) {
                packetWrapper.user().remove(BackSignEditStorage.class);
            } else {
                packetWrapper.user().put(new BackSignEditStorage(blockPosition));
            }
        });
        ((Protocol1_20To1_19_4)this.protocol).registerServerbound(ServerboundPackets1_19_4.SIGN_UPDATE, packetWrapper -> {
            BlockPosition blockPosition = packetWrapper.passthrough(Types.BLOCK_POSITION1_14);
            BackSignEditStorage backSignEditStorage = packetWrapper.user().remove(BackSignEditStorage.class);
            boolean bl = backSignEditStorage == null || !backSignEditStorage.position().equals(blockPosition);
            packetWrapper.write(Types.BOOLEAN, bl);
        });
        new RecipeRewriter1_19_4<ClientboundPackets1_19_4>(this.protocol).register(ClientboundPackets1_19_4.UPDATE_RECIPES);
    }

    @Override
    public @Nullable Item handleItemToClient(UserConnection userConnection, @Nullable Item item) {
        String string;
        StringTag stringTag;
        CompoundTag compoundTag;
        if (item == null) {
            return null;
        }
        CompoundTag compoundTag2 = (item = super.handleItemToClient(userConnection, item)).tag();
        if (compoundTag2 != null && (compoundTag = compoundTag2.getCompoundTag("Trim")) != null && (stringTag = compoundTag.getStringTag("pattern")) != null && NEW_TRIM_PATTERNS.contains(string = Key.stripMinecraftNamespace(stringTag.getValue()))) {
            compoundTag2.remove("Trim");
            compoundTag2.put(this.nbtTagName("Trim"), compoundTag);
        }
        return item;
    }

    @Override
    public @Nullable Item handleItemToServer(UserConnection userConnection, @Nullable Item item) {
        Tag tag;
        if (item == null) {
            return null;
        }
        CompoundTag compoundTag = (item = super.handleItemToServer(userConnection, item)).tag();
        if (compoundTag != null && (tag = compoundTag.remove(this.nbtTagName("Trim"))) != null) {
            compoundTag.put("Trim", tag);
        }
        return item;
    }
}


/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_19_4to1_20.rewriter;

import com.viaversion.viaversion.api.minecraft.BlockChangeRecord;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.packet.ClientboundPackets1_19_4;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.packet.ServerboundPackets1_19_4;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.rewriter.RecipeRewriter1_19_4;
import com.viaversion.viaversion.protocols.v1_19_4to1_20.Protocol1_19_4To1_20;
import com.viaversion.viaversion.rewriter.ItemRewriter;
import com.viaversion.viaversion.util.Key;

public class ItemPacketRewriter1_20
extends ItemRewriter<ClientboundPackets1_19_4, ServerboundPackets1_19_4, Protocol1_19_4To1_20> {
    public ItemPacketRewriter1_20(Protocol1_19_4To1_20 protocol1_19_4To1_20) {
        super(protocol1_19_4To1_20, Types.ITEM1_13_2, Types.ITEM1_13_2_ARRAY);
    }

    @Override
    public void registerPackets() {
        ((Protocol1_19_4To1_20)this.protocol).replaceClientbound(ClientboundPackets1_19_4.UPDATE_ADVANCEMENTS, packetWrapper -> {
            packetWrapper.passthrough(Types.BOOLEAN);
            int n = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n; ++i) {
                int n2;
                packetWrapper.passthrough(Types.STRING);
                packetWrapper.passthrough(Types.OPTIONAL_STRING);
                if (packetWrapper.passthrough(Types.BOOLEAN).booleanValue()) {
                    packetWrapper.passthrough(Types.COMPONENT);
                    packetWrapper.passthrough(Types.COMPONENT);
                    this.handleItemToClient(packetWrapper.user(), packetWrapper.passthrough(Types.ITEM1_13_2));
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
                packetWrapper.write(Types.BOOLEAN, false);
            }
        });
        ((Protocol1_19_4To1_20)this.protocol).registerClientbound(ClientboundPackets1_19_4.OPEN_SIGN_EDITOR, packetWrapper -> {
            packetWrapper.passthrough(Types.BLOCK_POSITION1_14);
            packetWrapper.write(Types.BOOLEAN, true);
        });
        ((Protocol1_19_4To1_20)this.protocol).registerServerbound(ServerboundPackets1_19_4.SIGN_UPDATE, packetWrapper -> {
            packetWrapper.passthrough(Types.BLOCK_POSITION1_14);
            boolean bl = packetWrapper.read(Types.BOOLEAN);
            if (!bl) {
                packetWrapper.cancel();
            }
        });
        ((Protocol1_19_4To1_20)this.protocol).replaceClientbound(ClientboundPackets1_19_4.LEVEL_CHUNK_WITH_LIGHT, new PacketHandlers(){

            @Override
            protected void register() {
                this.handler(packetWrapper -> {
                    Chunk chunk = ((Protocol1_19_4To1_20)ItemPacketRewriter1_20.this.protocol).getBlockRewriter().handleChunk1_18(packetWrapper);
                    ((Protocol1_19_4To1_20)ItemPacketRewriter1_20.this.protocol).getBlockRewriter().handleBlockEntities(chunk, packetWrapper.user());
                });
                this.read(Types.BOOLEAN);
            }
        });
        ((Protocol1_19_4To1_20)this.protocol).registerClientbound(ClientboundPackets1_19_4.LIGHT_UPDATE, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.read(Types.BOOLEAN);
        });
        ((Protocol1_19_4To1_20)this.protocol).replaceClientbound(ClientboundPackets1_19_4.SECTION_BLOCKS_UPDATE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.LONG);
                this.read(Types.BOOLEAN);
                this.handler(packetWrapper -> {
                    for (BlockChangeRecord blockChangeRecord : packetWrapper.passthrough(Types.VAR_LONG_BLOCK_CHANGE_ARRAY)) {
                        blockChangeRecord.setBlockId(((Protocol1_19_4To1_20)ItemPacketRewriter1_20.this.protocol).getMappingData().getNewBlockStateId(blockChangeRecord.getBlockId()));
                    }
                });
            }
        });
        RecipeRewriter1_19_4 recipeRewriter1_19_4 = new RecipeRewriter1_19_4(this.protocol);
        ((Protocol1_19_4To1_20)this.protocol).registerClientbound(ClientboundPackets1_19_4.UPDATE_RECIPES, packetWrapper -> {
            int n;
            int n2 = n = packetWrapper.passthrough(Types.VAR_INT).intValue();
            for (int i = 0; i < n; ++i) {
                String string = packetWrapper.read(Types.STRING);
                String string2 = Key.stripMinecraftNamespace(string);
                if (string2.equals("smithing")) {
                    --n2;
                    packetWrapper.read(Types.STRING);
                    packetWrapper.read(Types.ITEM1_13_2_ARRAY);
                    packetWrapper.read(Types.ITEM1_13_2_ARRAY);
                    packetWrapper.read(Types.ITEM1_13_2);
                    continue;
                }
                packetWrapper.write(Types.STRING, string);
                packetWrapper.passthrough(Types.STRING);
                recipeRewriter1_19_4.handleRecipeType(packetWrapper, string2);
            }
            packetWrapper.set(Types.VAR_INT, 0, n2);
        });
    }
}

